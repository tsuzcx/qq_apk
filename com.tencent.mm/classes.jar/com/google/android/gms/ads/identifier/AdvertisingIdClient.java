package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.zzg;
import com.google.android.gms.internal.zzcq;
import com.google.android.gms.internal.zzcq.zza;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
  private final Context mContext;
  com.google.android.gms.common.zza zzsa;
  zzcq zzsb;
  boolean zzsc;
  Object zzsd = new Object();
  AdvertisingIdClient.zza zzse;
  final long zzsf;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false);
  }
  
  public AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean)
  {
    zzac.zzw(paramContext);
    Context localContext;
    if (paramBoolean)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext != null) {}
    }
    for (this.mContext = paramContext;; this.mContext = paramContext)
    {
      this.zzsc = false;
      this.zzsf = paramLong;
      return;
      paramContext = localContext;
      break;
    }
  }
  
  public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context paramContext)
  {
    f2 = 0.0F;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool2;
    try
    {
      localObject1 = zzg.getRemoteContext(paramContext);
      f1 = f2;
      bool1 = bool3;
      if (localObject1 != null)
      {
        bool1 = bool2;
        localObject1 = ((Context)localObject1).getSharedPreferences("google_ads_flags", 1);
        bool1 = bool2;
        bool2 = ((SharedPreferences)localObject1).getBoolean("gads:ad_id_app_context:enabled", false);
        bool1 = bool2;
        f1 = ((SharedPreferences)localObject1).getFloat("gads:ad_id_app_context:ping_ratio", 0.0F);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        float f1 = f2;
      }
    }
    paramContext = new AdvertisingIdClient(paramContext, -1L, bool1);
    try
    {
      paramContext.zze(false);
      localObject1 = paramContext.getInfo();
      paramContext.zza((AdvertisingIdClient.Info)localObject1, bool1, f1, null);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      paramContext.zza(null, bool1, f1, localThrowable);
      return null;
    }
    finally
    {
      paramContext.finish();
    }
  }
  
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  static zzcq zza(Context paramContext, com.google.android.gms.common.zza paramzza)
  {
    try
    {
      paramContext = zzcq.zza.zzf(paramzza.zza(10000L, TimeUnit.MILLISECONDS));
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      throw new IOException("Interrupted exception");
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
  }
  
  private void zza(AdvertisingIdClient.Info paramInfo, boolean paramBoolean, float paramFloat, Throwable paramThrowable)
  {
    if (Math.random() > paramFloat) {
      return;
    }
    new AdvertisingIdClient.1(this, zza(paramInfo, paramBoolean, paramThrowable).toString()).start();
  }
  
  private void zzbw()
  {
    synchronized (this.zzsd)
    {
      if (this.zzse != null) {
        this.zzse.cancel();
      }
    }
    try
    {
      this.zzse.join();
      label28:
      if (this.zzsf > 0L) {
        this.zzse = new AdvertisingIdClient.zza(this, this.zzsf);
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label28;
    }
  }
  
  static com.google.android.gms.common.zza zzf(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      switch (zze.zzuY().isGooglePlayServicesAvailable(paramContext))
      {
      case 1: 
      default: 
        throw new IOException("Google Play services not available");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new GooglePlayServicesNotAvailableException(9);
    }
    com.google.android.gms.common.zza localzza = new com.google.android.gms.common.zza();
    Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
    localIntent.setPackage("com.google.android.gms");
    try
    {
      boolean bool = com.google.android.gms.common.stats.zza.zzyJ().zza(paramContext, localIntent, localzza, 1);
      if (bool) {
        return localzza;
      }
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
    throw new IOException("Connection failure");
  }
  
  protected void finalize()
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 235	com/google/android/gms/common/internal/zzac:zzdk	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 49	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 237	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsa	Lcom/google/android/gms/common/zza;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 51	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsc	Z
    //   28: ifeq +17 -> 45
    //   31: invokestatic 220	com/google/android/gms/common/stats/zza:zzyJ	()Lcom/google/android/gms/common/stats/zza;
    //   34: aload_0
    //   35: getfield 49	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 237	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsa	Lcom/google/android/gms/common/zza;
    //   42: invokevirtual 240	com/google/android/gms/common/stats/zza:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 51	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsc	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 242	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsb	Lcom/google/android/gms/internal/zzcq;
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 237	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsa	Lcom/google/android/gms/common/zza;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: goto -24 -> 45
    //   72: astore_1
    //   73: goto -28 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	AdvertisingIdClient
    //   63	4	1	localObject	Object
    //   68	1	1	localThrowable	Throwable
    //   72	1	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   7	21	63	finally
    //   21	23	63	finally
    //   24	45	63	finally
    //   45	62	63	finally
    //   64	66	63	finally
    //   24	45	68	java/lang/Throwable
    //   24	45	72	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public AdvertisingIdClient.Info getInfo()
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 235	com/google/android/gms/common/internal/zzac:zzdk	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 51	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsc	Z
    //   11: ifne +83 -> 94
    //   14: aload_0
    //   15: getfield 35	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsd	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 161	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzse	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 161	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzse	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   32: invokevirtual 248	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzbx	()Z
    //   35: ifne +23 -> 58
    //   38: new 127	java/io/IOException
    //   41: dup
    //   42: ldc 250
    //   44: invokespecial 132	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: aload_1
    //   59: monitorexit
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual 91	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	(Z)V
    //   65: aload_0
    //   66: getfield 51	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsc	Z
    //   69: ifne +25 -> 94
    //   72: new 127	java/io/IOException
    //   75: dup
    //   76: ldc 252
    //   78: invokespecial 132	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: astore_1
    //   83: new 127	java/io/IOException
    //   86: dup
    //   87: ldc 252
    //   89: aload_1
    //   90: invokespecial 255	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: athrow
    //   94: aload_0
    //   95: getfield 237	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsa	Lcom/google/android/gms/common/zza;
    //   98: invokestatic 41	com/google/android/gms/common/internal/zzac:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_0
    //   103: getfield 242	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsb	Lcom/google/android/gms/internal/zzcq;
    //   106: invokestatic 41	com/google/android/gms/common/internal/zzac:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: new 6	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   113: dup
    //   114: aload_0
    //   115: getfield 242	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsb	Lcom/google/android/gms/internal/zzcq;
    //   118: invokeinterface 260 1 0
    //   123: aload_0
    //   124: getfield 242	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsb	Lcom/google/android/gms/internal/zzcq;
    //   127: iconst_1
    //   128: invokeinterface 263 2 0
    //   133: invokespecial 266	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_0
    //   140: invokespecial 268	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzbw	()V
    //   143: aload_1
    //   144: areturn
    //   145: astore_1
    //   146: new 127	java/io/IOException
    //   149: dup
    //   150: ldc_w 270
    //   153: invokespecial 132	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	AdvertisingIdClient
    //   18	32	1	localObject1	Object
    //   53	6	1	localObject2	Object
    //   82	8	1	localException	Exception
    //   136	8	1	localInfo	AdvertisingIdClient.Info
    //   145	1	1	localRemoteException	android.os.RemoteException
    //   48	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	38	48	finally
    //   38	48	48	finally
    //   49	51	48	finally
    //   58	60	48	finally
    //   7	21	53	finally
    //   51	53	53	finally
    //   54	56	53	finally
    //   60	65	53	finally
    //   65	82	53	finally
    //   83	94	53	finally
    //   94	110	53	finally
    //   110	137	53	finally
    //   137	139	53	finally
    //   146	157	53	finally
    //   60	65	82	java/lang/Exception
    //   110	137	145	android/os/RemoteException
  }
  
  public void start()
  {
    zze(true);
  }
  
  Uri zza(AdvertisingIdClient.Info paramInfo, boolean paramBoolean, Throwable paramThrowable)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      str = "1";
      localBundle.putString("app_context", str);
      if (paramInfo != null) {
        if (!paramInfo.isLimitAdTrackingEnabled()) {
          break label168;
        }
      }
    }
    label168:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("limit_ad_tracking", str);
      if ((paramInfo != null) && (paramInfo.getId() != null)) {
        localBundle.putString("ad_id_size", Integer.toString(paramInfo.getId().length()));
      }
      if (paramThrowable != null) {
        localBundle.putString("error", paramThrowable.getClass().getName());
      }
      paramInfo = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
      paramThrowable = localBundle.keySet().iterator();
      while (paramThrowable.hasNext())
      {
        str = (String)paramThrowable.next();
        paramInfo.appendQueryParameter(str, localBundle.getString(str));
      }
      str = "0";
      break;
    }
    return paramInfo.build();
  }
  
  protected void zze(boolean paramBoolean)
  {
    zzac.zzdk("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzsc) {
        finish();
      }
      this.zzsa = zzf(this.mContext);
      this.zzsb = zza(this.mContext, this.zzsa);
      this.zzsc = true;
      if (paramBoolean) {
        zzbw();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient
 * JD-Core Version:    0.7.0.1
 */