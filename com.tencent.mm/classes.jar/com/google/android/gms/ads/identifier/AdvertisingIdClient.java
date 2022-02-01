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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zze;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
  private final Context mContext;
  private BlockingServiceConnection zze;
  private zze zzf;
  private boolean zzg;
  private final Object zzh;
  private zza zzi;
  private final boolean zzj;
  private final long zzk;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false, false);
  }
  
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
      paramContext.finish();
      AppMethodBeat.o(53025);
      return localObject2;
    }
    finally
    {
      try
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
  }
  
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
        return localBlockingServiceConnection;
      }
      finally
      {
        paramContext = new IOException(paramContext);
        AppMethodBeat.o(53024);
      }
    }
    throw paramContext;
  }
  
  /* Error */
  private static zze zza(Context paramContext, BlockingServiceConnection paramBlockingServiceConnection)
  {
    // Byte code:
    //   0: ldc 198
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc2_w 199
    //   9: getstatic 206	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   12: invokevirtual 210	com/google/android/gms/common/BlockingServiceConnection:getServiceWithTimeout	(JLjava/util/concurrent/TimeUnit;)Landroid/os/IBinder;
    //   15: invokestatic 215	com/google/android/gms/internal/ads_identifier/zzf:zza	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/ads_identifier/zze;
    //   18: astore_0
    //   19: ldc 198
    //   21: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: areturn
    //   26: astore_0
    //   27: new 157	java/io/IOException
    //   30: dup
    //   31: ldc 217
    //   33: invokespecial 162	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: ldc 198
    //   39: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: athrow
    //   44: astore_0
    //   45: new 157	java/io/IOException
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   53: astore_0
    //   54: ldc 198
    //   56: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramContext	Context
    //   0	61	1	paramBlockingServiceConnection	BlockingServiceConnection
    // Exception table:
    //   from	to	target	type
    //   5	19	26	java/lang/InterruptedException
    //   5	19	44	finally
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
          break label221;
        }
      }
    }
    label221:
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
    //   0: ldc_w 358
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 238
    //   8: invokestatic 241	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 59	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   17: ifnull +10 -> 27
    //   20: aload_0
    //   21: getfield 245	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   24: ifnonnull +12 -> 36
    //   27: aload_0
    //   28: monitorexit
    //   29: ldc_w 358
    //   32: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_0
    //   37: getfield 61	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   40: ifeq +17 -> 57
    //   43: invokestatic 183	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   46: aload_0
    //   47: getfield 59	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   50: aload_0
    //   51: getfield 245	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   54: invokevirtual 362	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 61	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 249	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 245	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   72: aload_0
    //   73: monitorexit
    //   74: ldc_w 358
    //   77: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc_w 358
    //   87: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: goto -36 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	AdvertisingIdClient
    //   81	10	1	localObject1	Object
    //   92	1	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	27	81	finally
    //   27	29	81	finally
    //   57	74	81	finally
    //   36	57	92	finally
  }
  
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
  
  public void start()
  {
    AppMethodBeat.i(53017);
    zza(true);
    AppMethodBeat.o(53017);
  }
  
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