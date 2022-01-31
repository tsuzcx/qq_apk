package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

public class zza
{
  private static Object zzbEM = new Object();
  private static zza zzbEN;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final Thread zzXh;
  private volatile AdvertisingIdClient.Info zzadB;
  private volatile long zzbEG = 900000L;
  private volatile long zzbEH = 30000L;
  private volatile long zzbEI;
  private volatile long zzbEJ;
  private final Object zzbEK = new Object();
  private zza.zza zzbEL = new zza.1(this);
  private final zze zzuP;
  
  private zza(Context paramContext)
  {
    this(paramContext, null, zzi.zzzc());
  }
  
  public zza(Context paramContext, zza.zza paramzza, zze paramzze)
  {
    this.zzuP = paramzze;
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      if (paramzza != null) {
        this.zzbEL = paramzza;
      }
      this.zzbEI = this.zzuP.currentTimeMillis();
      this.zzXh = new Thread(new zza.2(this));
      return;
    }
  }
  
  /* Error */
  private void zzPV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 99	com/google/android/gms/tagmanager/zza:zzPW	()V
    //   6: aload_0
    //   7: ldc2_w 100
    //   10: invokevirtual 105	java/lang/Object:wait	(J)V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    //   21: astore_1
    //   22: goto -9 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	zza
    //   16	4	1	localObject	Object
    //   21	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
    //   13	15	16	finally
    //   17	19	16	finally
    //   2	13	21	java/lang/InterruptedException
  }
  
  private void zzPW()
  {
    if (this.zzuP.currentTimeMillis() - this.zzbEI > this.zzbEH) {}
    synchronized (this.zzbEK)
    {
      this.zzbEK.notify();
      this.zzbEI = this.zzuP.currentTimeMillis();
      return;
    }
  }
  
  private void zzPX()
  {
    if (this.zzuP.currentTimeMillis() - this.zzbEJ > 3600000L) {
      this.zzadB = null;
    }
  }
  
  /* Error */
  private void zzPY()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 122	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 56	com/google/android/gms/tagmanager/zza:mClosed	Z
    //   9: istore_1
    //   10: aload_0
    //   11: getfield 65	com/google/android/gms/tagmanager/zza:zzbEL	Lcom/google/android/gms/tagmanager/zza$zza;
    //   14: invokeinterface 126 1 0
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +26 -> 47
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 115	com/google/android/gms/tagmanager/zza:zzadB	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 67	com/google/android/gms/tagmanager/zza:zzuP	Lcom/google/android/gms/common/util/zze;
    //   34: invokeinterface 81 1 0
    //   39: putfield 111	com/google/android/gms/tagmanager/zza:zzbEJ	J
    //   42: ldc 128
    //   44: invokestatic 134	com/google/android/gms/tagmanager/zzbo:zzbg	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: monitorenter
    //   49: aload_0
    //   50: invokevirtual 137	java/lang/Object:notifyAll	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: getfield 58	com/google/android/gms/tagmanager/zza:zzbEK	Ljava/lang/Object;
    //   59: astore_2
    //   60: aload_2
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 58	com/google/android/gms/tagmanager/zza:zzbEK	Ljava/lang/Object;
    //   66: aload_0
    //   67: getfield 50	com/google/android/gms/tagmanager/zza:zzbEG	J
    //   70: invokevirtual 105	java/lang/Object:wait	(J)V
    //   73: aload_2
    //   74: monitorexit
    //   75: goto -70 -> 5
    //   78: astore_3
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_3
    //   82: athrow
    //   83: astore_2
    //   84: ldc 139
    //   86: invokestatic 134	com/google/android/gms/tagmanager/zzbo:zzbg	(Ljava/lang/String;)V
    //   89: goto -84 -> 5
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	zza
    //   9	1	1	bool	boolean
    //   83	1	2	localInterruptedException	java.lang.InterruptedException
    //   92	4	2	localObject2	Object
    //   78	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	75	78	finally
    //   79	81	78	finally
    //   55	62	83	java/lang/InterruptedException
    //   81	83	83	java/lang/InterruptedException
    //   49	55	92	finally
    //   93	95	92	finally
  }
  
  public static zza zzbS(Context paramContext)
  {
    if (zzbEN == null) {}
    synchronized (zzbEM)
    {
      if (zzbEN == null)
      {
        paramContext = new zza(paramContext);
        zzbEN = paramContext;
        paramContext.start();
      }
      return zzbEN;
    }
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    if (this.zzadB == null) {
      zzPV();
    }
    for (;;)
    {
      zzPX();
      if (this.zzadB != null) {
        break;
      }
      return true;
      zzPW();
    }
    return this.zzadB.isLimitAdTrackingEnabled();
  }
  
  public void start()
  {
    this.zzXh.start();
  }
  
  public String zzPU()
  {
    if (this.zzadB == null) {
      zzPV();
    }
    for (;;)
    {
      zzPX();
      if (this.zzadB != null) {
        break;
      }
      return null;
      zzPW();
    }
    return this.zzadB.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zza
 * JD-Core Version:    0.7.0.1
 */