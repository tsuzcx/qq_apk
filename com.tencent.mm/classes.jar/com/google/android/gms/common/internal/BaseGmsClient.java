package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public abstract class BaseGmsClient<T extends IInterface>
{
  public static final int CONNECT_STATE_CONNECTED = 4;
  public static final int CONNECT_STATE_DISCONNECTED = 1;
  public static final int CONNECT_STATE_DISCONNECTING = 5;
  public static final int CONNECT_STATE_LOCAL_CONNECTING = 3;
  public static final int CONNECT_STATE_REMOTE_CONNECTING = 2;
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final String FEATURE_GOOGLE_ME = "service_googleme";
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = { "service_esmobile", "service_googleme" };
  public static final String KEY_PENDING_INTENT = "pendingIntent";
  private static final Feature[] zzqz = new Feature[0];
  @VisibleForTesting
  protected ConnectionProgressReportCallbacks mConnectionProgressReportCallbacks;
  private final Context mContext;
  @VisibleForTesting
  protected AtomicInteger mDisconnectCount = new AtomicInteger(0);
  final Handler mHandler;
  private final Object mLock = new Object();
  private final Looper zzcn;
  private final GoogleApiAvailabilityLight zzgk;
  private int zzra;
  private long zzrb;
  private long zzrc;
  private int zzrd;
  private long zzre;
  @VisibleForTesting
  private GmsServiceEndpoint zzrf;
  private final GmsClientSupervisor zzrg;
  private final Object zzrh = new Object();
  @GuardedBy("mServiceBrokerLock")
  private IGmsServiceBroker zzri;
  @GuardedBy("mLock")
  private T zzrj;
  private final ArrayList<BaseGmsClient<T>.CallbackProxy<?>> zzrk = new ArrayList();
  @GuardedBy("mLock")
  private BaseGmsClient<T>.GmsServiceConnection zzrl;
  @GuardedBy("mLock")
  private int zzrm = 1;
  private final BaseConnectionCallbacks zzrn;
  private final BaseOnConnectionFailedListener zzro;
  private final int zzrp;
  private final String zzrq;
  private ConnectionResult zzrr = null;
  private boolean zzrs = false;
  private volatile ConnectionInfo zzrt = null;
  
  @VisibleForTesting
  protected BaseGmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "Context must not be null"));
    this.mHandler = ((Handler)Preconditions.checkNotNull(paramHandler, "Handler must not be null"));
    this.zzcn = paramHandler.getLooper();
    this.zzrg = ((GmsClientSupervisor)Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null"));
    this.zzgk = ((GoogleApiAvailabilityLight)Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.zzrp = paramInt;
    this.zzrn = paramBaseConnectionCallbacks;
    this.zzro = paramBaseOnConnectionFailedListener;
    this.zzrq = null;
  }
  
  protected BaseGmsClient(Context paramContext, Looper paramLooper, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailabilityLight.getInstance(), paramInt, (BaseConnectionCallbacks)Preconditions.checkNotNull(paramBaseConnectionCallbacks), (BaseOnConnectionFailedListener)Preconditions.checkNotNull(paramBaseOnConnectionFailedListener), paramString);
  }
  
  @VisibleForTesting
  protected BaseGmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "Context must not be null"));
    this.zzcn = ((Looper)Preconditions.checkNotNull(paramLooper, "Looper must not be null"));
    this.zzrg = ((GmsClientSupervisor)Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null"));
    this.zzgk = ((GoogleApiAvailabilityLight)Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.mHandler = new zzb(paramLooper);
    this.zzrp = paramInt;
    this.zzrn = paramBaseConnectionCallbacks;
    this.zzro = paramBaseOnConnectionFailedListener;
    this.zzrq = paramString;
  }
  
  private final void zza(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 4)
    {
      i = 1;
      if (paramT == null) {
        break label483;
      }
      j = 1;
      label17:
      if (i != j) {
        break label489;
      }
    }
    for (;;)
    {
      Preconditions.checkArgument(bool);
      for (;;)
      {
        synchronized (this.mLock)
        {
          this.zzrm = paramInt;
          this.zzrj = paramT;
          onSetConnectState(paramInt, paramT);
          switch (paramInt)
          {
          case 2: 
            return;
          case 3: 
            String str;
            if ((this.zzrl != null) && (this.zzrf != null))
            {
              paramT = this.zzrf.zzcw();
              str = this.zzrf.getPackageName();
              new StringBuilder(String.valueOf(paramT).length() + 70 + String.valueOf(str).length()).append("Calling connect() while still connected, missing disconnect() for ").append(paramT).append(" on ").append(str);
              this.zzrg.unbindService(this.zzrf.zzcw(), this.zzrf.getPackageName(), this.zzrf.getBindFlags(), this.zzrl, getRealClientName());
              this.mDisconnectCount.incrementAndGet();
            }
            this.zzrl = new GmsServiceConnection(this.mDisconnectCount.get());
            if ((this.zzrm == 3) && (getLocalStartServiceAction() != null))
            {
              paramT = new GmsServiceEndpoint(getContext().getPackageName(), getLocalStartServiceAction(), true, getServiceBindFlags());
              this.zzrf = paramT;
              if (this.zzrg.bindService(this.zzrf.zzcw(), this.zzrf.getPackageName(), this.zzrf.getBindFlags(), this.zzrl, getRealClientName())) {
                continue;
              }
              paramT = this.zzrf.zzcw();
              str = this.zzrf.getPackageName();
              new StringBuilder(String.valueOf(paramT).length() + 34 + String.valueOf(str).length()).append("unable to connect to service: ").append(paramT).append(" on ").append(str);
              onPostServiceBindingHandler(16, null, this.mDisconnectCount.get());
            }
            break;
          }
        }
        paramT = new GmsServiceEndpoint(getStartServicePackage(), getStartServiceAction(), false, getServiceBindFlags());
        continue;
        onConnectedLocked(paramT);
        continue;
        if (this.zzrl != null)
        {
          this.zzrg.unbindService(getStartServiceAction(), getStartServicePackage(), getServiceBindFlags(), this.zzrl, getRealClientName());
          this.zzrl = null;
        }
      }
      i = 0;
      break;
      label483:
      j = 0;
      break label17;
      label489:
      bool = false;
    }
  }
  
  private final void zza(ConnectionInfo paramConnectionInfo)
  {
    this.zzrt = paramConnectionInfo;
  }
  
  private final boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.mLock)
    {
      if (this.zzrm != paramInt1) {
        return false;
      }
      zza(paramInt2, paramT);
      return true;
    }
  }
  
  private final boolean zzcq()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.zzrm == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private final boolean zzcr()
  {
    if (this.zzrs) {}
    while ((TextUtils.isEmpty(getServiceDescriptor())) || (TextUtils.isEmpty(getLocalStartServiceAction()))) {
      return false;
    }
    try
    {
      Class.forName(getServiceDescriptor());
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private final void zzj(int paramInt)
  {
    if (zzcq())
    {
      paramInt = 5;
      this.zzrs = true;
    }
    for (;;)
    {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(paramInt, this.mDisconnectCount.get(), 16));
      return;
      paramInt = 4;
    }
  }
  
  public void checkAvailabilityAndConnect()
  {
    int i = this.zzgk.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
    if (i != 0)
    {
      zza(1, null);
      triggerNotAvailable(new LegacyClientCallbackAdapter(), i, null);
      return;
    }
    connect(new LegacyClientCallbackAdapter());
  }
  
  protected final void checkConnected()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void connect(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    this.mConnectionProgressReportCallbacks = ((ConnectionProgressReportCallbacks)Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
    zza(2, null);
  }
  
  protected abstract T createServiceInterface(IBinder paramIBinder);
  
  public void disconnect()
  {
    this.mDisconnectCount.incrementAndGet();
    synchronized (this.zzrk)
    {
      int j = this.zzrk.size();
      int i = 0;
      while (i < j)
      {
        ((CallbackProxy)this.zzrk.get(i)).removeListener();
        i += 1;
      }
      this.zzrk.clear();
    }
    synchronized (this.zzrh)
    {
      this.zzri = null;
      zza(1, null);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  @Deprecated
  public final void doCallbackDEPRECATED(BaseGmsClient<T>.CallbackProxy<?> paramBaseGmsClient)
  {
    synchronized (this.zzrk)
    {
      this.zzrk.add(paramBaseGmsClient);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(2, this.mDisconnectCount.get(), -1, paramBaseGmsClient));
      return;
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] arg4)
  {
    int i;
    synchronized (this.mLock)
    {
      i = this.zzrm;
      paramFileDescriptor = this.zzrj;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.zzrh)
      {
        localObject = this.zzri;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramFileDescriptor != null) {
            break label533;
          }
          paramPrintWriter.append("null");
          paramPrintWriter.append(" mServiceBroker=");
          if (localObject != null) {
            break label566;
          }
          paramPrintWriter.println("null");
          paramFileDescriptor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          long l;
          if (this.zzrc > 0L)
          {
            ??? = paramPrintWriter.append(paramString).append("lastConnectedTime=");
            l = this.zzrc;
            localObject = paramFileDescriptor.format(new Date(this.zzrc));
            ???.println(String.valueOf(localObject).length() + 21 + l + " " + (String)localObject);
          }
          if (this.zzrb > 0L) {
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          }
          switch (this.zzra)
          {
          default: 
            paramPrintWriter.append(String.valueOf(this.zzra));
            ??? = paramPrintWriter.append(" lastSuspendedTime=");
            l = this.zzrb;
            localObject = paramFileDescriptor.format(new Date(this.zzrb));
            ???.println(String.valueOf(localObject).length() + 21 + l + " " + (String)localObject);
            if (this.zzre > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzrd));
              paramString = paramPrintWriter.append(" lastFailedTime=");
              l = this.zzre;
              paramFileDescriptor = paramFileDescriptor.format(new Date(this.zzre));
              paramString.println(String.valueOf(paramFileDescriptor).length() + 21 + l + " " + paramFileDescriptor);
            }
            return;
            paramString = finally;
            throw paramString;
          }
          break;
        }
      }
      paramPrintWriter.print("REMOTE_CONNECTING");
      continue;
      paramPrintWriter.print("LOCAL_CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label533:
      paramPrintWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(paramFileDescriptor.asBinder())));
      continue;
      label566:
      paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((IGmsServiceBroker)localObject).asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }
  
  public Account getAccount()
  {
    return null;
  }
  
  public final Account getAccountOrDefault()
  {
    if (getAccount() != null) {
      return getAccount();
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public Feature[] getApiFeatures()
  {
    return zzqz;
  }
  
  public final Feature[] getAvailableFeatures()
  {
    ConnectionInfo localConnectionInfo = this.zzrt;
    if (localConnectionInfo == null) {
      return null;
    }
    return localConnectionInfo.getAvailableFeatures();
  }
  
  public Bundle getConnectionHint()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public String getEndpointPackageName()
  {
    if ((isConnected()) && (this.zzrf != null)) {
      return this.zzrf.getPackageName();
    }
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  protected Bundle getGetServiceRequestExtraArgs()
  {
    return new Bundle();
  }
  
  @VisibleForTesting
  public final Handler getHandlerForTesting()
  {
    return this.mHandler;
  }
  
  protected String getLocalStartServiceAction()
  {
    return null;
  }
  
  public final Looper getLooper()
  {
    return this.zzcn;
  }
  
  public int getMinApkVersion()
  {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  protected final String getRealClientName()
  {
    if (this.zzrq == null) {
      return this.mContext.getClass().getName();
    }
    return this.zzrq;
  }
  
  /* Error */
  public void getRemoteService(IAccountAccessor arg1, Set<Scope> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 618	com/google/android/gms/common/internal/BaseGmsClient:getGetServiceRequestExtraArgs	()Landroid/os/Bundle;
    //   4: astore_3
    //   5: new 620	com/google/android/gms/common/internal/GetServiceRequest
    //   8: dup
    //   9: aload_0
    //   10: getfield 198	com/google/android/gms/common/internal/BaseGmsClient:zzrp	I
    //   13: invokespecial 621	com/google/android/gms/common/internal/GetServiceRequest:<init>	(I)V
    //   16: aload_0
    //   17: getfield 172	com/google/android/gms/common/internal/BaseGmsClient:mContext	Landroid/content/Context;
    //   20: invokevirtual 300	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: invokevirtual 625	com/google/android/gms/common/internal/GetServiceRequest:setCallingPackage	(Ljava/lang/String;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   26: aload_3
    //   27: invokevirtual 629	com/google/android/gms/common/internal/GetServiceRequest:setExtraArgs	(Landroid/os/Bundle;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   30: astore_3
    //   31: aload_2
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: aload_2
    //   37: invokevirtual 633	com/google/android/gms/common/internal/GetServiceRequest:setScopes	(Ljava/util/Collection;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 636	com/google/android/gms/common/internal/BaseGmsClient:requiresSignIn	()Z
    //   45: ifeq +76 -> 121
    //   48: aload_3
    //   49: aload_0
    //   50: invokevirtual 638	com/google/android/gms/common/internal/BaseGmsClient:getAccountOrDefault	()Landroid/accounts/Account;
    //   53: invokevirtual 642	com/google/android/gms/common/internal/GetServiceRequest:setClientRequestedAccount	(Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   56: aload_1
    //   57: invokevirtual 646	com/google/android/gms/common/internal/GetServiceRequest:setAuthenticatedAccount	(Lcom/google/android/gms/common/internal/IAccountAccessor;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   60: pop
    //   61: aload_3
    //   62: aload_0
    //   63: invokevirtual 649	com/google/android/gms/common/internal/BaseGmsClient:getRequiredFeatures	()[Lcom/google/android/gms/common/Feature;
    //   66: invokevirtual 653	com/google/android/gms/common/internal/GetServiceRequest:setClientRequiredFeatures	([Lcom/google/android/gms/common/Feature;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   69: pop
    //   70: aload_3
    //   71: aload_0
    //   72: invokevirtual 655	com/google/android/gms/common/internal/BaseGmsClient:getApiFeatures	()[Lcom/google/android/gms/common/Feature;
    //   75: invokevirtual 658	com/google/android/gms/common/internal/GetServiceRequest:setClientApiFeatures	([Lcom/google/android/gms/common/Feature;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   78: pop
    //   79: aload_0
    //   80: getfield 140	com/google/android/gms/common/internal/BaseGmsClient:zzrh	Ljava/lang/Object;
    //   83: astore_1
    //   84: aload_1
    //   85: monitorenter
    //   86: aload_0
    //   87: getfield 230	com/google/android/gms/common/internal/BaseGmsClient:zzri	Lcom/google/android/gms/common/internal/IGmsServiceBroker;
    //   90: ifnull +28 -> 118
    //   93: aload_0
    //   94: getfield 230	com/google/android/gms/common/internal/BaseGmsClient:zzri	Lcom/google/android/gms/common/internal/IGmsServiceBroker;
    //   97: new 19	com/google/android/gms/common/internal/BaseGmsClient$GmsCallbacks
    //   100: dup
    //   101: aload_0
    //   102: aload_0
    //   103: getfield 160	com/google/android/gms/common/internal/BaseGmsClient:mDisconnectCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   106: invokevirtual 289	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   109: invokespecial 659	com/google/android/gms/common/internal/BaseGmsClient$GmsCallbacks:<init>	(Lcom/google/android/gms/common/internal/BaseGmsClient;I)V
    //   112: aload_3
    //   113: invokeinterface 663 3 0
    //   118: aload_1
    //   119: monitorexit
    //   120: return
    //   121: aload_0
    //   122: invokevirtual 666	com/google/android/gms/common/internal/BaseGmsClient:requiresAccount	()Z
    //   125: ifeq -64 -> 61
    //   128: aload_3
    //   129: aload_0
    //   130: invokevirtual 570	com/google/android/gms/common/internal/BaseGmsClient:getAccount	()Landroid/accounts/Account;
    //   133: invokevirtual 642	com/google/android/gms/common/internal/GetServiceRequest:setClientRequestedAccount	(Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   136: pop
    //   137: goto -76 -> 61
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: iconst_1
    //   148: invokevirtual 669	com/google/android/gms/common/internal/BaseGmsClient:triggerConnectionSuspended	(I)V
    //   151: return
    //   152: astore_1
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: aload_0
    //   157: bipush 8
    //   159: aconst_null
    //   160: aconst_null
    //   161: aload_0
    //   162: getfield 160	com/google/android/gms/common/internal/BaseGmsClient:mDisconnectCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   165: invokevirtual 289	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   168: invokevirtual 673	com/google/android/gms/common/internal/BaseGmsClient:onPostInitHandler	(ILandroid/os/IBinder;Landroid/os/Bundle;I)V
    //   171: return
    //   172: astore_1
    //   173: goto -17 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	BaseGmsClient
    //   0	176	2	paramSet	Set<Scope>
    //   4	125	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   86	118	140	finally
    //   118	120	140	finally
    //   141	143	140	finally
    //   79	86	145	android/os/DeadObjectException
    //   143	145	145	android/os/DeadObjectException
    //   79	86	152	java/lang/SecurityException
    //   143	145	152	java/lang/SecurityException
    //   79	86	155	android/os/RemoteException
    //   143	145	155	android/os/RemoteException
    //   79	86	172	java/lang/RuntimeException
    //   143	145	172	java/lang/RuntimeException
  }
  
  public Feature[] getRequiredFeatures()
  {
    return zzqz;
  }
  
  protected Set<Scope> getScopes()
  {
    return Collections.EMPTY_SET;
  }
  
  public final T getService()
  {
    synchronized (this.mLock)
    {
      if (this.zzrm == 5) {
        throw new DeadObjectException();
      }
    }
    checkConnected();
    if (this.zzrj != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Client is connected but service is null");
      IInterface localIInterface = this.zzrj;
      return localIInterface;
    }
  }
  
  protected int getServiceBindFlags()
  {
    return 129;
  }
  
  public IBinder getServiceBrokerBinder()
  {
    synchronized (this.zzrh)
    {
      if (this.zzri == null) {
        return null;
      }
      IBinder localIBinder = this.zzri.asBinder();
      return localIBinder;
    }
  }
  
  @VisibleForTesting
  public final IGmsServiceBroker getServiceBrokerForTesting()
  {
    synchronized (this.zzrh)
    {
      IGmsServiceBroker localIGmsServiceBroker = this.zzri;
      return localIGmsServiceBroker;
    }
  }
  
  protected abstract String getServiceDescriptor();
  
  public Intent getSignInIntent()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  protected abstract String getStartServiceAction();
  
  protected String getStartServicePackage()
  {
    return "com.google.android.gms";
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.zzrm == 4)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.zzrm != 2)
        {
          if (this.zzrm != 3) {
            break label40;
          }
          break label35;
          return bool;
        }
      }
      label35:
      boolean bool = true;
      continue;
      label40:
      bool = false;
    }
  }
  
  protected void onConnectedLocked(T paramT)
  {
    this.zzrc = System.currentTimeMillis();
  }
  
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzrd = paramConnectionResult.getErrorCode();
    this.zzre = System.currentTimeMillis();
  }
  
  protected void onConnectionSuspended(int paramInt)
  {
    this.zzra = paramInt;
    this.zzrb = System.currentTimeMillis();
  }
  
  protected void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new PostInitCallback(paramInt1, paramIBinder, paramBundle)));
  }
  
  protected void onPostServiceBindingHandler(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(7, paramInt2, -1, new PostServiceBindingCallback(paramInt1, paramBundle)));
  }
  
  void onSetConnectState(int paramInt, T paramT) {}
  
  public void onUserSignOut(SignOutCallbacks paramSignOutCallbacks)
  {
    paramSignOutCallbacks.onSignOutComplete();
  }
  
  public boolean providesSignIn()
  {
    return false;
  }
  
  public boolean requiresAccount()
  {
    return false;
  }
  
  public boolean requiresGooglePlayServices()
  {
    return true;
  }
  
  public boolean requiresSignIn()
  {
    return false;
  }
  
  @VisibleForTesting
  public void setConnectionInfoForTesting(ConnectionInfo paramConnectionInfo)
  {
    this.zzrt = paramConnectionInfo;
  }
  
  @VisibleForTesting
  public final void setServiceBrokerForTesting(IGmsServiceBroker paramIGmsServiceBroker)
  {
    synchronized (this.zzrh)
    {
      this.zzri = paramIGmsServiceBroker;
      return;
    }
  }
  
  @VisibleForTesting
  public final void setServiceForTesting(T paramT)
  {
    if (paramT != null) {}
    for (int i = 4;; i = 1)
    {
      zza(i, paramT);
      return;
    }
  }
  
  public void triggerConnectionSuspended(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.mDisconnectCount.get(), paramInt));
  }
  
  @VisibleForTesting
  protected void triggerNotAvailable(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks, int paramInt, PendingIntent paramPendingIntent)
  {
    this.mConnectionProgressReportCallbacks = ((ConnectionProgressReportCallbacks)Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.mDisconnectCount.get(), paramInt, paramPendingIntent));
  }
  
  public static abstract interface BaseConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface BaseOnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
  
  protected abstract class CallbackProxy<TListener>
  {
    private TListener zzli;
    private boolean zzrv;
    
    public CallbackProxy()
    {
      Object localObject;
      this.zzli = localObject;
      this.zzrv = false;
    }
    
    public void deliverCallback()
    {
      for (;;)
      {
        try
        {
          Object localObject1 = this.zzli;
          if (this.zzrv)
          {
            String str = String.valueOf(this);
            new StringBuilder(String.valueOf(str).length() + 47).append("Callback proxy ").append(str).append(" being reused. This is not safe.");
          }
          if (localObject1 != null) {}
          onDeliverCallbackFailed();
        }
        finally
        {
          try
          {
            deliverCallback(localObject1);
          }
          catch (RuntimeException localRuntimeException)
          {
            onDeliverCallbackFailed();
            throw localRuntimeException;
          }
          try
          {
            this.zzrv = true;
            unregister();
            return;
          }
          finally {}
          localObject2 = finally;
        }
      }
    }
    
    protected abstract void deliverCallback(TListener paramTListener);
    
    protected abstract void onDeliverCallbackFailed();
    
    public void removeListener()
    {
      try
      {
        this.zzli = null;
        return;
      }
      finally {}
    }
    
    public void unregister()
    {
      removeListener();
      synchronized (BaseGmsClient.zzf(BaseGmsClient.this))
      {
        BaseGmsClient.zzf(BaseGmsClient.this).remove(this);
        return;
      }
    }
  }
  
  public static abstract interface ConnectionProgressReportCallbacks
  {
    public abstract void onReportServiceBinding(ConnectionResult paramConnectionResult);
  }
  
  @VisibleForTesting
  public static final class GmsCallbacks
    extends IGmsCallbacks.Stub
  {
    private BaseGmsClient zzrw;
    private final int zzrx;
    
    public GmsCallbacks(BaseGmsClient paramBaseGmsClient, int paramInt)
    {
      this.zzrw = paramBaseGmsClient;
      this.zzrx = paramInt;
    }
    
    public final void onAccountValidationComplete(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(89570);
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
      AppMethodBeat.o(89570);
    }
    
    public final void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      AppMethodBeat.i(89571);
      Preconditions.checkNotNull(this.zzrw, "onPostInitComplete can be called only once per call to getRemoteService");
      this.zzrw.onPostInitHandler(paramInt, paramIBinder, paramBundle, this.zzrx);
      this.zzrw = null;
      AppMethodBeat.o(89571);
    }
    
    public final void onPostInitCompleteWithConnectionInfo(int paramInt, IBinder paramIBinder, ConnectionInfo paramConnectionInfo)
    {
      AppMethodBeat.i(89572);
      Preconditions.checkNotNull(this.zzrw, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
      Preconditions.checkNotNull(paramConnectionInfo);
      BaseGmsClient.zza(this.zzrw, paramConnectionInfo);
      onPostInitComplete(paramInt, paramIBinder, paramConnectionInfo.getResolutionBundle());
      AppMethodBeat.o(89572);
    }
  }
  
  @VisibleForTesting
  public final class GmsServiceConnection
    implements ServiceConnection
  {
    private final int zzrx;
    
    public GmsServiceConnection(int paramInt)
    {
      this.zzrx = paramInt;
    }
    
    public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      AppMethodBeat.i(89573);
      if (paramIBinder == null)
      {
        BaseGmsClient.zza(BaseGmsClient.this, 16);
        AppMethodBeat.o(89573);
        return;
      }
      synchronized (BaseGmsClient.zza(BaseGmsClient.this))
      {
        BaseGmsClient.zza(BaseGmsClient.this, IGmsServiceBroker.Stub.asInterface(paramIBinder));
        BaseGmsClient.this.onPostServiceBindingHandler(0, null, this.zzrx);
        AppMethodBeat.o(89573);
        return;
      }
    }
    
    public final void onServiceDisconnected(ComponentName arg1)
    {
      AppMethodBeat.i(89574);
      synchronized (BaseGmsClient.zza(BaseGmsClient.this))
      {
        BaseGmsClient.zza(BaseGmsClient.this, null);
        BaseGmsClient.this.mHandler.sendMessage(BaseGmsClient.this.mHandler.obtainMessage(6, this.zzrx, 1));
        AppMethodBeat.o(89574);
        return;
      }
    }
  }
  
  public class LegacyClientCallbackAdapter
    implements BaseGmsClient.ConnectionProgressReportCallbacks
  {
    public LegacyClientCallbackAdapter() {}
    
    public void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(89575);
      if (paramConnectionResult.isSuccess())
      {
        BaseGmsClient.this.getRemoteService(null, BaseGmsClient.this.getScopes());
        AppMethodBeat.o(89575);
        return;
      }
      if (BaseGmsClient.zzg(BaseGmsClient.this) != null) {
        BaseGmsClient.zzg(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
      }
      AppMethodBeat.o(89575);
    }
  }
  
  protected final class PostInitCallback
    extends BaseGmsClient.zza
  {
    public final IBinder service;
    
    public PostInitCallback(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      this.service = paramIBinder;
    }
    
    protected final void handleServiceFailure(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(89576);
      if (BaseGmsClient.zzg(BaseGmsClient.this) != null) {
        BaseGmsClient.zzg(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
      }
      BaseGmsClient.this.onConnectionFailed(paramConnectionResult);
      AppMethodBeat.o(89576);
    }
    
    protected final boolean handleServiceSuccess()
    {
      AppMethodBeat.i(89577);
      try
      {
        String str1 = this.service.getInterfaceDescriptor();
        if (!BaseGmsClient.this.getServiceDescriptor().equals(str1))
        {
          String str2 = BaseGmsClient.this.getServiceDescriptor();
          new StringBuilder(String.valueOf(str2).length() + 34 + String.valueOf(str1).length()).append("service descriptor mismatch: ").append(str2).append(" vs. ").append(str1);
          AppMethodBeat.o(89577);
          return false;
        }
      }
      catch (RemoteException localRemoteException)
      {
        AppMethodBeat.o(89577);
        return false;
      }
      Object localObject = BaseGmsClient.this.createServiceInterface(this.service);
      if ((localObject != null) && ((BaseGmsClient.zza(BaseGmsClient.this, 2, 4, (IInterface)localObject)) || (BaseGmsClient.zza(BaseGmsClient.this, 3, 4, (IInterface)localObject))))
      {
        BaseGmsClient.zza(BaseGmsClient.this, null);
        localObject = BaseGmsClient.this.getConnectionHint();
        if (BaseGmsClient.zze(BaseGmsClient.this) != null) {
          BaseGmsClient.zze(BaseGmsClient.this).onConnected((Bundle)localObject);
        }
        AppMethodBeat.o(89577);
        return true;
      }
      AppMethodBeat.o(89577);
      return false;
    }
  }
  
  protected final class PostServiceBindingCallback
    extends BaseGmsClient.zza
  {
    public PostServiceBindingCallback(int paramInt, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
    }
    
    protected final void handleServiceFailure(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(89578);
      BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(paramConnectionResult);
      BaseGmsClient.this.onConnectionFailed(paramConnectionResult);
      AppMethodBeat.o(89578);
    }
    
    protected final boolean handleServiceSuccess()
    {
      AppMethodBeat.i(89579);
      BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
      AppMethodBeat.o(89579);
      return true;
    }
  }
  
  public static abstract interface SignOutCallbacks
  {
    public abstract void onSignOutComplete();
  }
  
  abstract class zza
    extends BaseGmsClient<T>.CallbackProxy<Boolean>
  {
    public final Bundle resolution;
    public final int statusCode;
    
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.TRUE);
      this.statusCode = paramInt;
      this.resolution = paramBundle;
    }
    
    protected void deliverCallback(Boolean paramBoolean)
    {
      Object localObject = null;
      if (paramBoolean == null) {
        BaseGmsClient.zza(BaseGmsClient.this, 1, null);
      }
      do
      {
        return;
        switch (this.statusCode)
        {
        default: 
          BaseGmsClient.zza(BaseGmsClient.this, 1, null);
          paramBoolean = localObject;
          if (this.resolution != null) {
            paramBoolean = (PendingIntent)this.resolution.getParcelable("pendingIntent");
          }
          handleServiceFailure(new ConnectionResult(this.statusCode, paramBoolean));
          return;
        }
      } while (handleServiceSuccess());
      BaseGmsClient.zza(BaseGmsClient.this, 1, null);
      handleServiceFailure(new ConnectionResult(8, null));
      return;
      BaseGmsClient.zza(BaseGmsClient.this, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
    
    protected abstract void handleServiceFailure(ConnectionResult paramConnectionResult);
    
    protected abstract boolean handleServiceSuccess();
    
    protected void onDeliverCallbackFailed() {}
  }
  
  final class zzb
    extends Handler
  {
    public zzb(Looper paramLooper)
    {
      super();
    }
    
    private static void zza(Message paramMessage)
    {
      AppMethodBeat.i(89581);
      paramMessage = (BaseGmsClient.CallbackProxy)paramMessage.obj;
      paramMessage.onDeliverCallbackFailed();
      paramMessage.unregister();
      AppMethodBeat.o(89581);
    }
    
    private static boolean zzb(Message paramMessage)
    {
      return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 7);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      PendingIntent localPendingIntent = null;
      AppMethodBeat.i(89580);
      if (BaseGmsClient.this.mDisconnectCount.get() != paramMessage.arg1)
      {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
        AppMethodBeat.o(89580);
        return;
      }
      if (((paramMessage.what == 1) || (paramMessage.what == 7) || (paramMessage.what == 4) || (paramMessage.what == 5)) && (!BaseGmsClient.this.isConnecting()))
      {
        zza(paramMessage);
        AppMethodBeat.o(89580);
        return;
      }
      if (paramMessage.what == 4)
      {
        BaseGmsClient.zza(BaseGmsClient.this, new ConnectionResult(paramMessage.arg2));
        if ((BaseGmsClient.zzb(BaseGmsClient.this)) && (!BaseGmsClient.zzc(BaseGmsClient.this)))
        {
          BaseGmsClient.zza(BaseGmsClient.this, 3, null);
          AppMethodBeat.o(89580);
          return;
        }
        if (BaseGmsClient.zzd(BaseGmsClient.this) != null) {}
        for (paramMessage = BaseGmsClient.zzd(BaseGmsClient.this);; paramMessage = new ConnectionResult(8))
        {
          BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(paramMessage);
          BaseGmsClient.this.onConnectionFailed(paramMessage);
          AppMethodBeat.o(89580);
          return;
        }
      }
      if (paramMessage.what == 5)
      {
        if (BaseGmsClient.zzd(BaseGmsClient.this) != null) {}
        for (paramMessage = BaseGmsClient.zzd(BaseGmsClient.this);; paramMessage = new ConnectionResult(8))
        {
          BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(paramMessage);
          BaseGmsClient.this.onConnectionFailed(paramMessage);
          AppMethodBeat.o(89580);
          return;
        }
      }
      if (paramMessage.what == 3)
      {
        if ((paramMessage.obj instanceof PendingIntent)) {
          localPendingIntent = (PendingIntent)paramMessage.obj;
        }
        paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
        BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(paramMessage);
        BaseGmsClient.this.onConnectionFailed(paramMessage);
        AppMethodBeat.o(89580);
        return;
      }
      if (paramMessage.what == 6)
      {
        BaseGmsClient.zza(BaseGmsClient.this, 5, null);
        if (BaseGmsClient.zze(BaseGmsClient.this) != null) {
          BaseGmsClient.zze(BaseGmsClient.this).onConnectionSuspended(paramMessage.arg2);
        }
        BaseGmsClient.this.onConnectionSuspended(paramMessage.arg2);
        BaseGmsClient.zza(BaseGmsClient.this, 5, 1, null);
        AppMethodBeat.o(89580);
        return;
      }
      if ((paramMessage.what == 2) && (!BaseGmsClient.this.isConnected()))
      {
        zza(paramMessage);
        AppMethodBeat.o(89580);
        return;
      }
      if (zzb(paramMessage))
      {
        ((BaseGmsClient.CallbackProxy)paramMessage.obj).deliverCallback();
        AppMethodBeat.o(89580);
        return;
      }
      int i = paramMessage.what;
      Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
      AppMethodBeat.o(89580);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.BaseGmsClient
 * JD-Core Version:    0.7.0.1
 */