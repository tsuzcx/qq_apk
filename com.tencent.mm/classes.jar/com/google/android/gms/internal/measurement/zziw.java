package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zziw
  implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener
{
  private volatile boolean zzapk;
  private volatile zzff zzapl;
  
  protected zziw(zzii paramzzii) {}
  
  /* Error */
  public final void onConnected(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: sipush 1862
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 42
    //   8: invokestatic 48	com/google/android/gms/common/internal/Preconditions:checkMainThread	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 50	com/google/android/gms/internal/measurement/zziw:zzapl	Lcom/google/android/gms/internal/measurement/zzff;
    //   17: invokevirtual 56	com/google/android/gms/internal/measurement/zzff:getService	()Landroid/os/IInterface;
    //   20: checkcast 58	com/google/android/gms/internal/measurement/zzey
    //   23: astore_1
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 50	com/google/android/gms/internal/measurement/zziw:zzapl	Lcom/google/android/gms/internal/measurement/zzff;
    //   29: aload_0
    //   30: getfield 20	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   33: invokevirtual 64	com/google/android/gms/internal/measurement/zzhg:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   36: new 66	com/google/android/gms/internal/measurement/zziz
    //   39: dup
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 69	com/google/android/gms/internal/measurement/zziz:<init>	(Lcom/google/android/gms/internal/measurement/zziw;Lcom/google/android/gms/internal/measurement/zzey;)V
    //   45: invokevirtual 75	com/google/android/gms/internal/measurement/zzgg:zzc	(Ljava/lang/Runnable;)V
    //   48: aload_0
    //   49: monitorexit
    //   50: sipush 1862
    //   53: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: return
    //   57: astore_1
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 50	com/google/android/gms/internal/measurement/zziw:zzapl	Lcom/google/android/gms/internal/measurement/zzff;
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 28	com/google/android/gms/internal/measurement/zziw:zzapk	Z
    //   68: goto -20 -> 48
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: sipush 1862
    //   77: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: goto -25 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	zziw
    //   0	86	1	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   13	48	57	java/lang/IllegalStateException
    //   13	48	71	finally
    //   48	50	71	finally
    //   58	68	71	finally
    //   13	48	82	android/os/DeadObjectException
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(1864);
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
    zzfg localzzfg = this.zzape.zzacw.zzjo();
    if (localzzfg != null) {
      localzzfg.zzip().zzg("Service connection failed", paramConnectionResult);
    }
    try
    {
      this.zzapk = false;
      this.zzapl = null;
      this.zzape.zzgd().zzc(new zzjb(this));
      AppMethodBeat.o(1864);
      return;
    }
    finally
    {
      AppMethodBeat.o(1864);
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    AppMethodBeat.i(1863);
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
    this.zzape.zzge().zzis().log("Service connection suspended");
    this.zzape.zzgd().zzc(new zzja(this));
    AppMethodBeat.o(1863);
  }
  
  /* Error */
  public final void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: sipush 1859
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 138
    //   8: invokestatic 48	com/google/android/gms/common/internal/Preconditions:checkMainThread	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_2
    //   14: ifnonnull +32 -> 46
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 28	com/google/android/gms/internal/measurement/zziw:zzapk	Z
    //   22: aload_0
    //   23: getfield 20	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   26: invokevirtual 119	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   29: invokevirtual 141	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   32: ldc 143
    //   34: invokevirtual 127	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: sipush 1859
    //   42: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload_2
    //   47: invokeinterface 149 1 0
    //   52: astore_1
    //   53: ldc 151
    //   55: aload_1
    //   56: invokevirtual 157	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq +130 -> 191
    //   64: aload_2
    //   65: ifnonnull +58 -> 123
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 20	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   74: invokevirtual 119	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   77: invokevirtual 160	com/google/android/gms/internal/measurement/zzfg:zzit	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   80: ldc 162
    //   82: invokevirtual 127	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   85: aload_1
    //   86: ifnonnull +126 -> 212
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 28	com/google/android/gms/internal/measurement/zziw:zzapk	Z
    //   94: invokestatic 168	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   97: aload_0
    //   98: getfield 20	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   101: invokevirtual 172	com/google/android/gms/internal/measurement/zzhg:getContext	()Landroid/content/Context;
    //   104: aload_0
    //   105: getfield 20	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   108: invokestatic 175	com/google/android/gms/internal/measurement/zzii:zza	(Lcom/google/android/gms/internal/measurement/zzii;)Lcom/google/android/gms/internal/measurement/zziw;
    //   111: invokevirtual 179	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   114: aload_0
    //   115: monitorexit
    //   116: sipush 1859
    //   119: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: aload_2
    //   124: ldc 151
    //   126: invokeinterface 183 2 0
    //   131: astore_1
    //   132: aload_1
    //   133: instanceof 58
    //   136: ifeq +11 -> 147
    //   139: aload_1
    //   140: checkcast 58	com/google/android/gms/internal/measurement/zzey
    //   143: astore_1
    //   144: goto -74 -> 70
    //   147: new 185	com/google/android/gms/internal/measurement/zzfa
    //   150: dup
    //   151: aload_2
    //   152: invokespecial 188	com/google/android/gms/internal/measurement/zzfa:<init>	(Landroid/os/IBinder;)V
    //   155: astore_1
    //   156: goto -86 -> 70
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_0
    //   163: getfield 20	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   166: invokevirtual 119	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   169: invokevirtual 141	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   172: ldc 190
    //   174: invokevirtual 127	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   177: goto -92 -> 85
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: sipush 1859
    //   186: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: athrow
    //   191: aload_0
    //   192: getfield 20	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   195: invokevirtual 119	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   198: invokevirtual 141	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   201: ldc 192
    //   203: aload_1
    //   204: invokevirtual 108	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   207: aconst_null
    //   208: astore_1
    //   209: goto -124 -> 85
    //   212: aload_0
    //   213: getfield 20	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   216: invokevirtual 64	com/google/android/gms/internal/measurement/zzhg:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   219: new 194	com/google/android/gms/internal/measurement/zzix
    //   222: dup
    //   223: aload_0
    //   224: aload_1
    //   225: invokespecial 195	com/google/android/gms/internal/measurement/zzix:<init>	(Lcom/google/android/gms/internal/measurement/zziw;Lcom/google/android/gms/internal/measurement/zzey;)V
    //   228: invokevirtual 75	com/google/android/gms/internal/measurement/zzgg:zzc	(Ljava/lang/Runnable;)V
    //   231: goto -117 -> 114
    //   234: astore_1
    //   235: goto -121 -> 114
    //   238: astore_2
    //   239: goto -77 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	zziw
    //   0	242	1	paramComponentName	ComponentName
    //   0	242	2	paramIBinder	android.os.IBinder
    //   59	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   46	60	159	android/os/RemoteException
    //   123	144	159	android/os/RemoteException
    //   147	156	159	android/os/RemoteException
    //   191	207	159	android/os/RemoteException
    //   17	39	180	finally
    //   46	60	180	finally
    //   70	85	180	finally
    //   89	94	180	finally
    //   94	114	180	finally
    //   114	116	180	finally
    //   123	144	180	finally
    //   147	156	180	finally
    //   162	177	180	finally
    //   191	207	180	finally
    //   212	231	180	finally
    //   94	114	234	java/lang/IllegalArgumentException
    //   70	85	238	android/os/RemoteException
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(1860);
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
    this.zzape.zzge().zzis().log("Service disconnected");
    this.zzape.zzgd().zzc(new zziy(this, paramComponentName));
    AppMethodBeat.o(1860);
  }
  
  public final void zzc(Intent paramIntent)
  {
    AppMethodBeat.i(1858);
    this.zzape.zzab();
    Context localContext = this.zzape.getContext();
    ConnectionTracker localConnectionTracker = ConnectionTracker.getInstance();
    try
    {
      if (this.zzapk)
      {
        this.zzape.zzge().zzit().log("Connection attempt already in progress");
        return;
      }
      this.zzape.zzge().zzit().log("Using local app measurement service");
      this.zzapk = true;
      localConnectionTracker.bindService(localContext, paramIntent, zzii.zza(this.zzape), 129);
      return;
    }
    finally
    {
      AppMethodBeat.o(1858);
    }
  }
  
  public final void zzkh()
  {
    AppMethodBeat.i(1861);
    this.zzape.zzab();
    Context localContext = this.zzape.getContext();
    try
    {
      if (this.zzapk)
      {
        this.zzape.zzge().zzit().log("Connection attempt already in progress");
        return;
      }
      if (this.zzapl != null)
      {
        this.zzape.zzge().zzit().log("Already awaiting connection attempt");
        return;
      }
      this.zzapl = new zzff(localContext, Looper.getMainLooper(), this, this);
      this.zzape.zzge().zzit().log("Connecting to remote service");
      this.zzapk = true;
      this.zzapl.checkAvailabilityAndConnect();
      return;
    }
    finally
    {
      AppMethodBeat.o(1861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zziw
 * JD-Core Version:    0.7.0.1
 */