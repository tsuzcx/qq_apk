package com.tencent.mars.cdn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;", "", "()V", "mIsMobileAvailable", "", "mLock", "Ljava/lang/Object;", "mMobileNetId", "", "mMobileNetwork", "Landroid/net/Network;", "mMobileNetworkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "activeMobileNetwork", "", "context", "Landroid/content/Context;", "bindSocket", "socketFd", "bindSocketToMobile", "delayUnregister", "getAllNetworkInterfaces", "getIpv4Address", "", "inetIpList", "", "Ljava/net/InetAddress;", "getMobileNetId", "isIpv4", "ip", "isNormalInterface", "networkInterface", "Ljava/net/NetworkInterface;", "negativeMobileNetwork", "onMobileNetworkReady", "network", "onMobileUnAvailable", "printINetAddress", "reflectCallBind", "syncActiveMobileNetwork", "Companion", "DelayUnregister", "MobileNetworkCallback", "wechat-commons-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CronetMultiNetLinkWaysUtil
{
  public static final Companion Companion = new Companion(null);
  private static final String TAG = "CronetMultiNetLinkWaysUtil.cronet";
  private static CronetMultiNetLinkWaysUtil mInstance;
  private boolean mIsMobileAvailable;
  private Object mLock = new Object();
  private int mMobileNetId = -1;
  private Network mMobileNetwork;
  private ConnectivityManager.NetworkCallback mMobileNetworkCallback;
  
  private final boolean bindSocket(int paramInt)
  {
    if ((!this.mIsMobileAvailable) && (Build.VERSION.SDK_INT >= 23))
    {
      Log.w("CronetMultiNetLinkWaysUtil.cronet", s.X("mobile network is not available: ", Integer.valueOf(Build.VERSION.SDK_INT)));
      return false;
    }
    FileDescriptor localFileDescriptor = new FileDescriptor();
    try
    {
      localObject = FileDescriptor.class.getDeclaredField("descriptor");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).setInt(localFileDescriptor, paramInt);
      if (Build.VERSION.SDK_INT < 23)
      {
        Log.w("CronetMultiNetLinkWaysUtil.cronet", s.X("current sdk version is less than 23: ", Integer.valueOf(Build.VERSION.SDK_INT)));
        return reflectCallBind(paramInt);
      }
      if (this.mMobileNetwork == null)
      {
        Log.w("CronetMultiNetLinkWaysUtil.cronet", "mMobileNetwork is null");
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.e("CronetMultiNetLinkWaysUtil.cronet", s.X("bind socket failed: ", localException.getMessage()));
      return false;
    }
    Object localObject = this.mMobileNetwork;
    if (localObject != null) {
      ((Network)localObject).bindSocket(localException);
    }
    return true;
  }
  
  private final void delayUnregister(Context paramContext)
  {
    Timer localTimer = new Timer();
    CronetMultiNetLinkWaysUtil localCronetMultiNetLinkWaysUtil = mInstance;
    s.checkNotNull(localCronetMultiNetLinkWaysUtil);
    localTimer.schedule((TimerTask)new DelayUnregister(localCronetMultiNetLinkWaysUtil, paramContext), 30000L);
  }
  
  private final String getIpv4Address(List<? extends InetAddress> paramList)
  {
    if (paramList == null) {
      return "";
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      InetAddress localInetAddress = (InetAddress)paramList.next();
      if (localInetAddress != null)
      {
        String str = localInetAddress.getHostAddress();
        s.s(str, "inet.hostAddress");
        if (isIpv4(str))
        {
          paramList = localInetAddress.getHostAddress();
          s.s(paramList, "inet.hostAddress");
          return paramList;
        }
      }
    }
    return "";
  }
  
  private final boolean isIpv4(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    return (!n.a((CharSequence)paramString, (CharSequence)":", false)) && (n.a((CharSequence)paramString, (CharSequence)".", false));
  }
  
  private final boolean isNormalInterface(NetworkInterface paramNetworkInterface)
  {
    if (paramNetworkInterface == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 9) && (paramNetworkInterface.isVirtual())) {
      return false;
    }
    paramNetworkInterface = Collections.list(paramNetworkInterface.getInetAddresses());
    printINetAddress((List)paramNetworkInterface);
    paramNetworkInterface = paramNetworkInterface.iterator();
    while (paramNetworkInterface.hasNext())
    {
      Object localObject = (InetAddress)paramNetworkInterface.next();
      if ((localObject == null) || (((InetAddress)localObject).isLoopbackAddress())) {
        return false;
      }
      String str = ((InetAddress)localObject).toString();
      s.s(str, "inet.toString()");
      if (!n.a((CharSequence)str, (CharSequence)"127.0.0.1", false))
      {
        localObject = ((InetAddress)localObject).toString();
        s.s(localObject, "inet.toString()");
        if (!n.a((CharSequence)localObject, (CharSequence)"::1", false)) {
          break;
        }
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  private final void printINetAddress(List<? extends InetAddress> paramList)
  {
    if (paramList == null) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer("inet size is ");
    localStringBuffer.append(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      InetAddress localInetAddress = (InetAddress)paramList.next();
      if (localInetAddress != null)
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(localInetAddress.toString());
        localStringBuffer.append(" host address ");
        localStringBuffer.append(localInetAddress.getHostAddress());
      }
    }
    Log.i("CronetMultiNetLinkWaysUtil.cronet", s.X("inet info ", localStringBuffer));
  }
  
  private final boolean reflectCallBind(int paramInt)
  {
    Log.i("CronetMultiNetLinkWaysUtil.cronet", "try to call reflection version");
    try
    {
      Object localObject1 = Class.forName("android.net.NetworkUtils");
      Object localObject2 = ((Class)localObject1).newInstance();
      localObject1 = ((Class)localObject1).getDeclaredMethod("bindSocketToNetwork", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(localObject2, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getMobileNetId()) });
      if (localObject1 == null) {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      }
    }
    catch (Exception localException)
    {
      Log.e("CronetMultiNetLinkWaysUtil.cronet", s.X("call reflection bind error: ", localException.getMessage()));
      return false;
    }
    paramInt = ((Integer)localException).intValue();
    Log.i("CronetMultiNetLinkWaysUtil.cronet", s.X("call reflection bind ret: ", Integer.valueOf(paramInt)));
    return paramInt == 0;
  }
  
  private final void syncActiveMobileNetwork(Context paramContext)
  {
    synchronized (this.mLock)
    {
      if (!this.mIsMobileAvailable) {
        activeMobileNetwork(paramContext);
      }
      try
      {
        this.mLock.wait(4000L);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("CronetMultiNetLinkWaysUtil.cronet", s.X("cronet activeMobileNetwork error: ", localException));
          delayUnregister(paramContext);
        }
        paramContext = finally;
        throw paramContext;
      }
      finally
      {
        delayUnregister(paramContext);
      }
      paramContext = ah.aiuX;
      return;
    }
  }
  
  public final void activeMobileNetwork(Context paramContext)
  {
    if ((Build.VERSION.SDK_INT < 21) || (paramContext == null))
    {
      localObject = new StringBuilder("current sdk version: ").append(Build.VERSION.SDK_INT).append(" is less than 21or context is null: ");
      if (paramContext == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("CronetMultiNetLinkWaysUtil.cronet", bool);
        return;
      }
    }
    Log.i("CronetMultiNetLinkWaysUtil.cronet", "start active mobile network");
    if (this.mMobileNetworkCallback == null) {
      this.mMobileNetworkCallback = ((ConnectivityManager.NetworkCallback)new MobileNetworkCallback(this));
    }
    paramContext = paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
    paramContext = (ConnectivityManager)paramContext;
    Object localObject = new NetworkRequest.Builder();
    ((NetworkRequest.Builder)localObject).addCapability(12);
    ((NetworkRequest.Builder)localObject).addTransportType(0);
    localObject = ((NetworkRequest.Builder)localObject).build();
    ConnectivityManager.NetworkCallback localNetworkCallback = this.mMobileNetworkCallback;
    s.checkNotNull(localNetworkCallback);
    paramContext.requestNetwork((NetworkRequest)localObject, localNetworkCallback);
  }
  
  public final boolean bindSocketToMobile(int paramInt, Context paramContext)
  {
    Log.i("CronetMultiNetLinkWaysUtil.cronet", "cronet bindSocketToMobile");
    syncActiveMobileNetwork(paramContext);
    boolean bool = bindSocket(paramInt);
    Log.d("CronetMultiNetLinkWaysUtil.cronet", s.X("bindSocketToMobile ", Boolean.valueOf(bool)));
    return bool;
  }
  
  public final void getAllNetworkInterfaces()
  {
    Iterator localIterator = ((ArrayList)Collections.list(NetworkInterface.getNetworkInterfaces())).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NetworkInterface)localIterator.next();
      if ((localObject != null) && (isNormalInterface((NetworkInterface)localObject)))
      {
        String str = ((NetworkInterface)localObject).getName();
        localObject = getIpv4Address((List)Collections.list(((NetworkInterface)localObject).getInetAddresses()));
        if ((!TextUtils.isEmpty((CharSequence)str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          s.s(str, "name");
          if (n.a((CharSequence)str, (CharSequence)"rmnet_data0", false)) {
            Log.i("CronetMultiNetLinkWaysUtil.cronet", "mobile network name: " + str + ", ip is: " + (String)localObject);
          }
        }
      }
    }
  }
  
  public final int getMobileNetId()
  {
    return this.mMobileNetId;
  }
  
  public final void negativeMobileNetwork(Context arg1)
  {
    Log.i("CronetMultiNetLinkWaysUtil.cronet", "cronet negativeMobileNetwork");
    if ((Build.VERSION.SDK_INT < 21) || (??? == null)) {
      return;
    }
    this.mIsMobileAvailable = false;
    ??? = ???.getSystemService("connectivity");
    if (??? == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
    Object localObject1 = (ConnectivityManager)???;
    synchronized (this.mLock)
    {
      if (this.mMobileNetworkCallback == null)
      {
        Log.i("CronetMultiNetLinkWaysUtil.cronet", "cronet already negativeMobileNetwork");
        return;
      }
    }
    try
    {
      ConnectivityManager.NetworkCallback localNetworkCallback = this.mMobileNetworkCallback;
      s.checkNotNull(localNetworkCallback);
      ((ConnectivityManager)localObject1).unregisterNetworkCallback(localNetworkCallback);
      this.mMobileNetworkCallback = null;
      label98:
      localObject1 = ah.aiuX;
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      break label98;
    }
  }
  
  /* Error */
  public final void onMobileNetworkReady(Network arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 456
    //   4: invokestatic 459	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 145	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mMobileNetwork	Landroid/net/Network;
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 462	android/net/Network:hashCode	()I
    //   17: bipush 11
    //   19: idiv
    //   20: putfield 79	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mMobileNetId	I
    //   23: ldc 64
    //   25: ldc_w 464
    //   28: aload_0
    //   29: getfield 79	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mMobileNetId	I
    //   32: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: invokestatic 112	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokestatic 293	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: iconst_1
    //   43: putfield 93	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mIsMobileAvailable	Z
    //   46: aload_0
    //   47: getfield 81	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mLock	Ljava/lang/Object;
    //   50: astore_1
    //   51: aload_1
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 81	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mLock	Ljava/lang/Object;
    //   57: invokevirtual 467	java/lang/Object:notifyAll	()V
    //   60: getstatic 351	kotlin/ah:aiuX	Lkotlin/ah;
    //   63: astore_2
    //   64: aload_1
    //   65: monitorexit
    //   66: return
    //   67: astore_2
    //   68: aload_1
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    //   72: astore_1
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 93	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mIsMobileAvailable	Z
    //   78: ldc 64
    //   80: ldc_w 469
    //   83: aload_1
    //   84: invokevirtual 472	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   87: invokestatic 112	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: getfield 81	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mLock	Ljava/lang/Object;
    //   97: astore_1
    //   98: aload_1
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 81	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mLock	Ljava/lang/Object;
    //   104: invokevirtual 467	java/lang/Object:notifyAll	()V
    //   107: getstatic 351	kotlin/ah:aiuX	Lkotlin/ah;
    //   110: astore_2
    //   111: aload_1
    //   112: monitorexit
    //   113: return
    //   114: astore_2
    //   115: aload_1
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_2
    //   120: aload_0
    //   121: getfield 81	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mLock	Ljava/lang/Object;
    //   124: astore_1
    //   125: aload_1
    //   126: monitorenter
    //   127: aload_0
    //   128: getfield 81	com/tencent/mars/cdn/CronetMultiNetLinkWaysUtil:mLock	Ljava/lang/Object;
    //   131: invokevirtual 467	java/lang/Object:notifyAll	()V
    //   134: getstatic 351	kotlin/ah:aiuX	Lkotlin/ah;
    //   137: astore_3
    //   138: aload_1
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    //   142: astore_2
    //   143: aload_1
    //   144: monitorexit
    //   145: aload_2
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	CronetMultiNetLinkWaysUtil
    //   63	1	2	localah1	ah
    //   67	4	2	localObject1	Object
    //   110	1	2	localah2	ah
    //   114	4	2	localObject2	Object
    //   119	22	2	localObject3	Object
    //   142	4	2	localObject4	Object
    //   137	1	3	localah3	ah
    // Exception table:
    //   from	to	target	type
    //   53	64	67	finally
    //   41	46	72	java/lang/Exception
    //   100	111	114	finally
    //   41	46	119	finally
    //   73	93	119	finally
    //   127	138	142	finally
  }
  
  public final void onMobileUnAvailable()
  {
    this.mIsMobileAvailable = false;
    synchronized (this.mLock)
    {
      this.mLock.notifyAll();
      ah localah = ah.aiuX;
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil$Companion;", "", "()V", "TAG", "", "mInstance", "Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;", "instance", "wechat-commons-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion
  {
    public final CronetMultiNetLinkWaysUtil instance()
    {
      if (CronetMultiNetLinkWaysUtil.access$getMInstance$cp() == null) {
        CronetMultiNetLinkWaysUtil.access$setMInstance$cp(new CronetMultiNetLinkWaysUtil(null));
      }
      CronetMultiNetLinkWaysUtil localCronetMultiNetLinkWaysUtil = CronetMultiNetLinkWaysUtil.access$getMInstance$cp();
      s.checkNotNull(localCronetMultiNetLinkWaysUtil);
      return localCronetMultiNetLinkWaysUtil;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil$DelayUnregister;", "Ljava/util/TimerTask;", "receiver", "Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;", "context", "Landroid/content/Context;", "(Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;Landroid/content/Context;)V", "()V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mReceiver", "getMReceiver", "()Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;", "setMReceiver", "(Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;)V", "run", "", "wechat-commons-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class DelayUnregister
    extends TimerTask
  {
    private Context mContext;
    private CronetMultiNetLinkWaysUtil mReceiver;
    
    public DelayUnregister() {}
    
    public DelayUnregister(CronetMultiNetLinkWaysUtil paramCronetMultiNetLinkWaysUtil, Context paramContext)
    {
      this();
      this.mReceiver = paramCronetMultiNetLinkWaysUtil;
      this.mContext = paramContext;
    }
    
    public final Context getMContext()
    {
      return this.mContext;
    }
    
    public final CronetMultiNetLinkWaysUtil getMReceiver()
    {
      return this.mReceiver;
    }
    
    public final void run()
    {
      CronetMultiNetLinkWaysUtil localCronetMultiNetLinkWaysUtil = this.mReceiver;
      if (localCronetMultiNetLinkWaysUtil != null) {
        localCronetMultiNetLinkWaysUtil.negativeMobileNetwork(this.mContext);
      }
    }
    
    public final void setMContext(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final void setMReceiver(CronetMultiNetLinkWaysUtil paramCronetMultiNetLinkWaysUtil)
    {
      this.mReceiver = paramCronetMultiNetLinkWaysUtil;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil$MobileNetworkCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "receiver", "Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;", "(Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;)V", "()V", "mReceiver", "getMReceiver", "()Lcom/tencent/mars/cdn/CronetMultiNetLinkWaysUtil;", "setMReceiver", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "onUnavailable", "wechat-commons-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class MobileNetworkCallback
    extends ConnectivityManager.NetworkCallback
  {
    private CronetMultiNetLinkWaysUtil mReceiver;
    
    public MobileNetworkCallback() {}
    
    public MobileNetworkCallback(CronetMultiNetLinkWaysUtil paramCronetMultiNetLinkWaysUtil)
    {
      this();
      this.mReceiver = paramCronetMultiNetLinkWaysUtil;
    }
    
    public final CronetMultiNetLinkWaysUtil getMReceiver()
    {
      return this.mReceiver;
    }
    
    public final void onAvailable(Network paramNetwork)
    {
      s.u(paramNetwork, "network");
      Log.i("CronetMultiNetLinkWaysUtil.cronet", s.X("network available ", paramNetwork));
      CronetMultiNetLinkWaysUtil localCronetMultiNetLinkWaysUtil = this.mReceiver;
      if (localCronetMultiNetLinkWaysUtil != null) {
        localCronetMultiNetLinkWaysUtil.onMobileNetworkReady(paramNetwork);
      }
    }
    
    public final void onLost(Network paramNetwork)
    {
      s.u(paramNetwork, "network");
      Log.i("CronetMultiNetLinkWaysUtil.cronet", "network onLost");
      paramNetwork = this.mReceiver;
      if (paramNetwork != null) {
        paramNetwork.onMobileUnAvailable();
      }
    }
    
    public final void onUnavailable()
    {
      Log.i("CronetMultiNetLinkWaysUtil.cronet", "network onUnavailable");
      CronetMultiNetLinkWaysUtil localCronetMultiNetLinkWaysUtil = this.mReceiver;
      if (localCronetMultiNetLinkWaysUtil != null) {
        localCronetMultiNetLinkWaysUtil.onMobileUnAvailable();
      }
    }
    
    public final void setMReceiver(CronetMultiNetLinkWaysUtil paramCronetMultiNetLinkWaysUtil)
    {
      this.mReceiver = paramCronetMultiNetLinkWaysUtil;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetMultiNetLinkWaysUtil
 * JD-Core Version:    0.7.0.1
 */