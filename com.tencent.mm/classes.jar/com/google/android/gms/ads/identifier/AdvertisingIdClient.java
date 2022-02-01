package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@KeepForSdk
public class AdvertisingIdClient
{
  @GuardedBy("this")
  private final Context mContext;
  @GuardedBy("this")
  private BlockingServiceConnection zze;
  @GuardedBy("this")
  private zze zzf;
  @GuardedBy("this")
  private boolean zzg;
  private final Object zzh;
  @GuardedBy("mAutoDisconnectTaskLock")
  private zza zzi;
  private final boolean zzj;
  private final long zzk;
  
  @KeepForSdk
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false, false);
  }
  
  @VisibleForTesting
  private AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(53016);
    this.zzh = new Object();
    Preconditions.checkNotNull(paramContext);
    Context localContext;
    if (paramBoolean1)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext != null) {}
    }
    for (this.mContext = paramContext;; this.mContext = paramContext)
    {
      this.zzg = false;
      this.zzk = paramLong;
      this.zzj = paramBoolean2;
      AppMethodBeat.o(53016);
      return;
      paramContext = localContext;
      break;
    }
  }
  
  @KeepForSdk
  public static Info getAdvertisingIdInfo(Context paramContext)
  {
    AppMethodBeat.i(53025);
    Object localObject2 = new zzb(paramContext);
    boolean bool = ((zzb)localObject2).getBoolean("gads:ad_id_app_context:enabled", false);
    float f = ((zzb)localObject2).getFloat("gads:ad_id_app_context:ping_ratio", 0.0F);
    String str = ((zzb)localObject2).getString("gads:ad_id_use_shared_preference:experiment_id", "");
    paramContext = new AdvertisingIdClient(paramContext, -1L, bool, ((zzb)localObject2).getBoolean("gads:ad_id_use_persistent_service:enabled", false));
    try
    {
      long l = SystemClock.elapsedRealtime();
      paramContext.zza(false);
      localObject2 = paramContext.getInfo();
      paramContext.zza((Info)localObject2, bool, f, SystemClock.elapsedRealtime() - l, str, null);
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      paramContext.zza(null, bool, f, -1L, str, localThrowable);
      AppMethodBeat.o(53025);
      throw localThrowable;
    }
    finally
    {
      paramContext.finish();
      AppMethodBeat.o(53025);
    }
  }
  
  @KeepForSdk
  public static boolean getIsAdIdFakeForDebugLogging(Context paramContext)
  {
    AppMethodBeat.i(53026);
    zzb localzzb = new zzb(paramContext);
    paramContext = new AdvertisingIdClient(paramContext, -1L, localzzb.getBoolean("gads:ad_id_app_context:enabled", false), localzzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
    try
    {
      paramContext.zza(false);
      boolean bool = paramContext.zzb();
      return bool;
    }
    finally
    {
      paramContext.finish();
      AppMethodBeat.o(53026);
    }
  }
  
  @KeepForSdk
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  private static BlockingServiceConnection zza(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(53024);
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      switch (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, 12451000))
      {
      case 1: 
      default: 
        paramContext = new IOException("Google Play services not available");
        AppMethodBeat.o(53024);
        throw paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new GooglePlayServicesNotAvailableException(9);
      AppMethodBeat.o(53024);
      throw paramContext;
    }
    if (paramBoolean) {}
    for (Object localObject = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";; localObject = "com.google.android.gms.ads.identifier.service.START")
    {
      BlockingServiceConnection localBlockingServiceConnection = new BlockingServiceConnection();
      localObject = new Intent((String)localObject);
      ((Intent)localObject).setPackage("com.google.android.gms");
      try
      {
        paramBoolean = ConnectionTracker.getInstance().bindService(paramContext, (Intent)localObject, localBlockingServiceConnection, 1);
        if (!paramBoolean) {
          break;
        }
        AppMethodBeat.o(53024);
        return localBlockingServiceConnection;
      }
      catch (Throwable paramContext)
      {
        paramContext = new IOException(paramContext);
        AppMethodBeat.o(53024);
        throw paramContext;
      }
    }
    paramContext = new IOException("Connection failure");
    AppMethodBeat.o(53024);
    throw paramContext;
  }
  
  @VisibleForTesting
  private static zze zza(Context paramContext, BlockingServiceConnection paramBlockingServiceConnection)
  {
    AppMethodBeat.i(53028);
    try
    {
      paramContext = zzf.zza(paramBlockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
      AppMethodBeat.o(53028);
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      paramContext = new IOException("Interrupted exception");
      AppMethodBeat.o(53028);
      throw paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext = new IOException(paramContext);
      AppMethodBeat.o(53028);
      throw paramContext;
    }
  }
  
  private final void zza()
  {
    AppMethodBeat.i(53019);
    synchronized (this.zzh)
    {
      if (this.zzi != null) {
        this.zzi.zzo.countDown();
      }
    }
    try
    {
      this.zzi.join();
      label36:
      if (this.zzk > 0L) {
        this.zzi = new zza(this, this.zzk);
      }
      AppMethodBeat.o(53019);
      return;
      localObject2 = finally;
      AppMethodBeat.o(53019);
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label36;
    }
  }
  
  @VisibleForTesting
  private final void zza(boolean paramBoolean)
  {
    AppMethodBeat.i(53018);
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzg) {
        finish();
      }
      this.zze = zza(this.mContext, this.zzj);
      this.zzf = zza(this.mContext, this.zze);
      this.zzg = true;
      if (paramBoolean) {
        zza();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(53018);
    }
  }
  
  @VisibleForTesting
  private final boolean zza(Info paramInfo, boolean paramBoolean, float paramFloat, long paramLong, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(53027);
    if (Math.random() > paramFloat)
    {
      AppMethodBeat.o(53027);
      return false;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean)
    {
      str = "1";
      localHashMap.put("app_context", str);
      if (paramInfo != null) {
        if (!paramInfo.isLimitAdTrackingEnabled()) {
          break label224;
        }
      }
    }
    label224:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("limit_ad_tracking", str);
      if ((paramInfo != null) && (paramInfo.getId() != null)) {
        localHashMap.put("ad_id_size", Integer.toString(paramInfo.getId().length()));
      }
      if (paramThrowable != null) {
        localHashMap.put("error", paramThrowable.getClass().getName());
      }
      if ((paramString != null) && (!paramString.isEmpty())) {
        localHashMap.put("experiment_id", paramString);
      }
      localHashMap.put("tag", "AdvertisingIdClient");
      localHashMap.put("time_spent", Long.toString(paramLong));
      new zza(this, localHashMap).start();
      AppMethodBeat.o(53027);
      return true;
      str = "0";
      break;
    }
  }
  
  private final boolean zzb()
  {
    AppMethodBeat.i(53021);
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzg) {
        break label139;
      }
      synchronized (this.zzh)
      {
        if ((this.zzi == null) || (!this.zzi.zzp))
        {
          IOException localIOException4 = new IOException("AdvertisingIdClient is not connected.");
          AppMethodBeat.o(53021);
          throw localIOException4;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(53021);
    }
    try
    {
      zza(false);
      if (!this.zzg)
      {
        IOException localIOException1 = new IOException("AdvertisingIdClient cannot reconnect.");
        AppMethodBeat.o(53021);
        throw localIOException1;
      }
    }
    catch (Exception localException)
    {
      IOException localIOException2 = new IOException("AdvertisingIdClient cannot reconnect.", localException);
      AppMethodBeat.o(53021);
      throw localIOException2;
    }
    label139:
    Preconditions.checkNotNull(this.zze);
    Preconditions.checkNotNull(this.zzf);
    try
    {
      boolean bool = this.zzf.zzc();
      zza();
      AppMethodBeat.o(53021);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      IOException localIOException3 = new IOException("Remote exception");
      AppMethodBeat.o(53021);
      throw localIOException3;
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(53023);
    finish();
    super.finalize();
    AppMethodBeat.o(53023);
  }
  
  /* Error */
  public final void finish()
  {
    // Byte code:
    //   0: ldc_w 368
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 248
    //   8: invokestatic 251	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 67	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   17: ifnull +10 -> 27
    //   20: aload_0
    //   21: getfield 255	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   24: ifnonnull +12 -> 36
    //   27: aload_0
    //   28: monitorexit
    //   29: ldc_w 368
    //   32: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_0
    //   37: getfield 69	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   40: ifeq +17 -> 57
    //   43: invokestatic 193	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   46: aload_0
    //   47: getfield 67	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   50: aload_0
    //   51: getfield 255	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   54: invokevirtual 372	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 69	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 259	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 255	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   72: aload_0
    //   73: monitorexit
    //   74: ldc_w 368
    //   77: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc_w 368
    //   87: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: goto -36 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	AdvertisingIdClient
    //   81	10	1	localObject	Object
    //   92	1	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   13	27	81	finally
    //   27	29	81	finally
    //   36	57	81	finally
    //   57	74	81	finally
    //   82	84	81	finally
    //   36	57	92	java/lang/Throwable
  }
  
  @KeepForSdk
  public Info getInfo()
  {
    AppMethodBeat.i(53020);
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzg) {
        break label139;
      }
      synchronized (this.zzh)
      {
        if ((this.zzi == null) || (!this.zzi.zzp))
        {
          IOException localIOException3 = new IOException("AdvertisingIdClient is not connected.");
          AppMethodBeat.o(53020);
          throw localIOException3;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(53020);
    }
    Object localObject3;
    try
    {
      zza(false);
      if (!this.zzg)
      {
        IOException localIOException1 = new IOException("AdvertisingIdClient cannot reconnect.");
        AppMethodBeat.o(53020);
        throw localIOException1;
      }
    }
    catch (Exception localException)
    {
      localObject3 = new IOException("AdvertisingIdClient cannot reconnect.", localException);
      AppMethodBeat.o(53020);
      throw ((Throwable)localObject3);
    }
    label139:
    Preconditions.checkNotNull(this.zze);
    Preconditions.checkNotNull(this.zzf);
    try
    {
      localObject3 = new Info(this.zzf.getId(), this.zzf.zzb(true));
      zza();
      AppMethodBeat.o(53020);
      return localObject3;
    }
    catch (RemoteException localRemoteException)
    {
      IOException localIOException2 = new IOException("Remote exception");
      AppMethodBeat.o(53020);
      throw localIOException2;
    }
  }
  
  @KeepForSdk
  public void start()
  {
    AppMethodBeat.i(53017);
    zza(true);
    AppMethodBeat.o(53017);
  }
  
  @KeepForSdkWithMembers
  public static final class Info
  {
    private final String zzq;
    private final boolean zzr;
    
    public Info(String paramString, boolean paramBoolean)
    {
      this.zzq = paramString;
      this.zzr = paramBoolean;
    }
    
    public final String getId()
    {
      return this.zzq;
    }
    
    public final boolean isLimitAdTrackingEnabled()
    {
      return this.zzr;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(53012);
      String str = this.zzq;
      boolean bool = this.zzr;
      str = String.valueOf(str).length() + 7 + "{" + str + "}" + bool;
      AppMethodBeat.o(53012);
      return str;
    }
  }
  
  @VisibleForTesting
  static final class zza
    extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzm;
    private long zzn;
    CountDownLatch zzo;
    boolean zzp;
    
    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      AppMethodBeat.i(53013);
      this.zzm = new WeakReference(paramAdvertisingIdClient);
      this.zzn = paramLong;
      this.zzo = new CountDownLatch(1);
      this.zzp = false;
      start();
      AppMethodBeat.o(53013);
    }
    
    private final void disconnect()
    {
      AppMethodBeat.i(53014);
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzm.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        this.zzp = true;
      }
      AppMethodBeat.o(53014);
    }
    
    public final void run()
    {
      AppMethodBeat.i(53015);
      try
      {
        if (!this.zzo.await(this.zzn, TimeUnit.MILLISECONDS)) {
          disconnect();
        }
        AppMethodBeat.o(53015);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        disconnect();
        AppMethodBeat.o(53015);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient
 * JD-Core Version:    0.7.0.1
 */