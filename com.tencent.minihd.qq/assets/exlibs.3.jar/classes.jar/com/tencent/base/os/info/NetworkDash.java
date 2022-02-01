package com.tencent.base.os.info;

import android.content.Context;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.base.Global;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NetworkDash
{
  private static final NetworkObserver OBSERVER;
  private static final List<WeakReference<NetworkStateListener>> OBSERVER_LIST;
  private static NetworkState currState;
  private static ServiceProvider imsiProvider = null;
  private static NetworkState lastState;
  private static Handler mainHandler;
  
  static
  {
    OBSERVER = new NetworkObserver()
    {
      public void onNetworkChanged()
      {
        NetworkDash.updateNetworkState();
      }
    };
    OBSERVER_LIST = new ArrayList();
    updateNetworkState();
    OBSERVER.startListen();
  }
  
  public static void addListener(NetworkStateListener paramNetworkStateListener)
  {
    synchronized (OBSERVER_LIST)
    {
      OBSERVER_LIST.add(new WeakReference(paramNetworkStateListener));
      return;
    }
  }
  
  public static AccessPoint getAccessPoint()
  {
    NetworkState localNetworkState = getCurrState();
    if (localNetworkState != null) {
      return localNetworkState.getAccessPoint();
    }
    return AccessPoint.NONE;
  }
  
  public static String getApnName()
  {
    NetworkState localNetworkState = getCurrState();
    if (localNetworkState != null) {
      return localNetworkState.getApnName();
    }
    return "";
  }
  
  public static String getApnNameOrWifi()
  {
    if (!isAvailable()) {
      return "";
    }
    if (isWifi()) {
      return "wifi";
    }
    return getApnName();
  }
  
  public static int getCellLevel()
  {
    return OBSERVER.getCellLevel();
  }
  
  public static NetworkState getCurrState()
  {
    return currState;
  }
  
  public static String getDeviceIdBySlot(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      if ((paramInt >= 0) && (paramInt <= 1)) {
        try
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          paramContext = Class.forName("android.telephony.TelephonyManager").getMethod("getSimOperatorGemini", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(paramInt) });
          if (paramContext != null)
          {
            paramContext = paramContext.toString();
            return paramContext;
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return null;
  }
  
  public static String getIMSI()
  {
    try
    {
      Object localObject2 = ((TelephonyManager)Global.getSystemService("phone")).getSimOperator();
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = getDeviceIdBySlot(Global.getContext(), 0);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = getDeviceIdBySlot(Global.getContext(), 1);
      }
      return localObject2;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static ServiceProvider getIMSIProvider()
  {
    if (imsiProvider == null) {
      updateIMSIProvider();
    }
    return imsiProvider;
  }
  
  protected static NetworkState getLastState()
  {
    return lastState;
  }
  
  public static ServiceProvider getProvider()
  {
    NetworkState localNetworkState = getCurrState();
    if (localNetworkState != null) {
      return localNetworkState.getAccessPoint().getProvider();
    }
    return ServiceProvider.NONE;
  }
  
  public static ServiceProvider getProvider(boolean paramBoolean)
  {
    ServiceProvider localServiceProvider = ServiceProvider.NONE;
    if (paramBoolean)
    {
      localServiceProvider = getIMSIProvider();
      if (!ServiceProvider.NONE.equals(localServiceProvider)) {
        return localServiceProvider;
      }
    }
    return getProvider();
  }
  
  public static NetworkType getType()
  {
    NetworkState localNetworkState = getCurrState();
    if (localNetworkState != null) {
      return localNetworkState.getType();
    }
    return NetworkType.NONE;
  }
  
  public static boolean isAvailable()
  {
    updateNetworkState();
    if (getCurrState() != null) {
      return getCurrState().isConnected();
    }
    return false;
  }
  
  public static boolean isMobile()
  {
    NetworkType localNetworkType = getType();
    return (NetworkType.MOBILE_3G.equals(localNetworkType)) || (NetworkType.MOBILE_2G.equals(localNetworkType));
  }
  
  public static boolean isWap()
  {
    return getAccessPoint().isWap();
  }
  
  public static boolean isWifi()
  {
    return NetworkType.WIFI.equals(getType());
  }
  
  private static void notifyNetworkStateChange()
  {
    if (OBSERVER_LIST == null) {
      return;
    }
    for (;;)
    {
      synchronized (OBSERVER_LIST)
      {
        Iterator localIterator = OBSERVER_LIST.iterator();
        if (!localIterator.hasNext()) {
          return;
        }
      }
      NetworkStateListener localNetworkStateListener = (NetworkStateListener)((WeakReference)localObject.next()).get();
      if (localNetworkStateListener != null) {
        localNetworkStateListener.onNetworkStateChanged(getLastState(), getCurrState());
      }
    }
  }
  
  /* Error */
  public static void removeListener(NetworkStateListener paramNetworkStateListener)
  {
    // Byte code:
    //   0: getstatic 34	com/tencent/base/os/info/NetworkDash:OBSERVER_LIST	Ljava/util/List;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: aconst_null
    //   7: astore_1
    //   8: getstatic 34	com/tencent/base/os/info/NetworkDash:OBSERVER_LIST	Ljava/util/List;
    //   11: invokeinterface 220 1 0
    //   16: astore 4
    //   18: aload 4
    //   20: invokeinterface 225 1 0
    //   25: ifne +18 -> 43
    //   28: aload_1
    //   29: astore_0
    //   30: getstatic 34	com/tencent/base/os/info/NetworkDash:OBSERVER_LIST	Ljava/util/List;
    //   33: aload_0
    //   34: invokeinterface 244 2 0
    //   39: pop
    //   40: aload_3
    //   41: monitorexit
    //   42: return
    //   43: aload 4
    //   45: invokeinterface 229 1 0
    //   50: checkcast 53	java/lang/ref/WeakReference
    //   53: astore_2
    //   54: aload_2
    //   55: invokevirtual 232	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   58: checkcast 234	com/tencent/base/os/info/NetworkStateListener
    //   61: astore 5
    //   63: aload 5
    //   65: ifnull -47 -> 18
    //   68: aload 5
    //   70: aload_0
    //   71: invokevirtual 245	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   74: ifeq -56 -> 18
    //   77: aload_2
    //   78: astore_0
    //   79: goto -49 -> 30
    //   82: astore_0
    //   83: aload_3
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramNetworkStateListener	NetworkStateListener
    //   7	22	1	localObject	Object
    //   53	25	2	localWeakReference	WeakReference
    //   3	81	3	localList	List
    //   16	28	4	localIterator	Iterator
    //   61	8	5	localNetworkStateListener	NetworkStateListener
    // Exception table:
    //   from	to	target	type
    //   8	18	82	finally
    //   18	28	82	finally
    //   30	42	82	finally
    //   43	63	82	finally
    //   68	77	82	finally
    //   83	85	82	finally
  }
  
  protected static boolean setCurrState(NetworkState paramNetworkState)
  {
    boolean bool = false;
    try
    {
      if (currState == null)
      {
        lastState = currState;
        currState = paramNetworkState;
        bool = true;
      }
      if (!currState.equals(paramNetworkState))
      {
        lastState = currState;
        currState = paramNetworkState;
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public static ServiceProvider updateIMSIProvider()
  {
    try
    {
      try
      {
        imsiProvider = ServiceProvider.fromIMSI(getIMSI());
        ServiceProvider localServiceProvider = imsiProvider;
        return localServiceProvider;
      }
      finally {}
      return ServiceProvider.NONE;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public static boolean updateNetworkState()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 258
    //   6: invokestatic 151	com/tencent/base/Global:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast 260	android/net/ConnectivityManager
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +8 -> 22
    //   17: ldc 2
    //   19: monitorexit
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_1
    //   23: invokevirtual 264	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 268	com/tencent/base/os/info/NetworkState:fromNetworkInfo	(Landroid/net/NetworkInfo;)Lcom/tencent/base/os/info/NetworkState;
    //   31: invokestatic 270	com/tencent/base/os/info/NetworkDash:setCurrState	(Lcom/tencent/base/os/info/NetworkState;)Z
    //   34: istore_0
    //   35: iload_0
    //   36: ifeq +44 -> 80
    //   39: invokestatic 171	com/tencent/base/os/info/NetworkDash:updateIMSIProvider	()Lcom/tencent/base/os/info/ServiceProvider;
    //   42: pop
    //   43: invokestatic 275	com/tencent/base/os/info/WifiDash:updateBSSID	()Ljava/lang/String;
    //   46: pop
    //   47: getstatic 277	com/tencent/base/os/info/NetworkDash:mainHandler	Landroid/os/Handler;
    //   50: ifnonnull +16 -> 66
    //   53: new 279	android/os/Handler
    //   56: dup
    //   57: invokestatic 283	com/tencent/base/Global:getMainLooper	()Landroid/os/Looper;
    //   60: invokespecial 286	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   63: putstatic 277	com/tencent/base/os/info/NetworkDash:mainHandler	Landroid/os/Handler;
    //   66: getstatic 277	com/tencent/base/os/info/NetworkDash:mainHandler	Landroid/os/Handler;
    //   69: new 8	com/tencent/base/os/info/NetworkDash$2
    //   72: dup
    //   73: invokespecial 287	com/tencent/base/os/info/NetworkDash$2:<init>	()V
    //   76: invokevirtual 291	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   79: pop
    //   80: ldc 2
    //   82: monitorexit
    //   83: iload_0
    //   84: ireturn
    //   85: astore_1
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_1
    //   94: goto -67 -> 27
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_1
    //   100: goto -73 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	50	0	bool	boolean
    //   12	16	1	localObject1	Object
    //   85	5	1	localObject2	Object
    //   91	1	1	localError	java.lang.Error
    //   93	1	1	localObject3	Object
    //   97	1	1	localException	Exception
    //   99	1	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	85	finally
    //   17	20	85	finally
    //   22	27	85	finally
    //   27	35	85	finally
    //   39	66	85	finally
    //   66	80	85	finally
    //   80	83	85	finally
    //   86	89	85	finally
    //   3	13	91	java/lang/Error
    //   22	27	91	java/lang/Error
    //   3	13	97	java/lang/Exception
    //   22	27	97	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.base.os.info.NetworkDash
 * JD-Core Version:    0.7.0.1
 */