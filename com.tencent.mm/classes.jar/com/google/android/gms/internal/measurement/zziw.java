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
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
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
    //   0: ldc 36
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 44
    //   7: invokestatic 50	com/google/android/gms/common/internal/Preconditions:checkMainThread	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 52	com/google/android/gms/internal/measurement/zziw:zzapl	Lcom/google/android/gms/internal/measurement/zzff;
    //   16: invokevirtual 58	com/google/android/gms/internal/measurement/zzff:getService	()Landroid/os/IInterface;
    //   19: checkcast 60	com/google/android/gms/internal/measurement/zzey
    //   22: astore_1
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 52	com/google/android/gms/internal/measurement/zziw:zzapl	Lcom/google/android/gms/internal/measurement/zzff;
    //   28: aload_0
    //   29: getfield 21	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   32: invokevirtual 66	com/google/android/gms/internal/measurement/zzhg:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   35: new 68	com/google/android/gms/internal/measurement/zziz
    //   38: dup
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 71	com/google/android/gms/internal/measurement/zziz:<init>	(Lcom/google/android/gms/internal/measurement/zziw;Lcom/google/android/gms/internal/measurement/zzey;)V
    //   44: invokevirtual 77	com/google/android/gms/internal/measurement/zzgg:zzc	(Ljava/lang/Runnable;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: ldc 36
    //   51: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 52	com/google/android/gms/internal/measurement/zziw:zzapl	Lcom/google/android/gms/internal/measurement/zzff;
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 29	com/google/android/gms/internal/measurement/zziw:zzapk	Z
    //   66: goto -19 -> 47
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: ldc 36
    //   74: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: goto -24 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	zziw
    //   0	83	1	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   12	47	55	java/lang/IllegalStateException
    //   12	47	69	finally
    //   47	49	69	finally
    //   56	66	69	finally
    //   70	72	69	finally
    //   12	47	79	android/os/DeadObjectException
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(69341);
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
      AppMethodBeat.o(69341);
      return;
    }
    finally
    {
      AppMethodBeat.o(69341);
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    AppMethodBeat.i(69340);
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
    this.zzape.zzge().zzis().log("Service connection suspended");
    this.zzape.zzgd().zzc(new zzja(this));
    AppMethodBeat.o(69340);
  }
  
  /* Error */
  public final void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: ldc 141
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 143
    //   7: invokestatic 50	com/google/android/gms/common/internal/Preconditions:checkMainThread	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_2
    //   13: ifnonnull +31 -> 44
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 29	com/google/android/gms/internal/measurement/zziw:zzapk	Z
    //   21: aload_0
    //   22: getfield 21	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   25: invokevirtual 123	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   28: invokevirtual 146	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   31: ldc 148
    //   33: invokevirtual 131	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: monitorexit
    //   38: ldc 141
    //   40: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload_2
    //   45: invokeinterface 154 1 0
    //   50: astore_1
    //   51: ldc 156
    //   53: aload_1
    //   54: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: istore_3
    //   58: iload_3
    //   59: ifeq +128 -> 187
    //   62: aload_2
    //   63: ifnonnull +57 -> 120
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_0
    //   69: getfield 21	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   72: invokevirtual 123	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   75: invokevirtual 165	com/google/android/gms/internal/measurement/zzfg:zzit	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   78: ldc 167
    //   80: invokevirtual 131	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: ifnonnull +124 -> 208
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 29	com/google/android/gms/internal/measurement/zziw:zzapk	Z
    //   92: invokestatic 173	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   95: aload_0
    //   96: getfield 21	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   99: invokevirtual 177	com/google/android/gms/internal/measurement/zzhg:getContext	()Landroid/content/Context;
    //   102: aload_0
    //   103: getfield 21	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   106: invokestatic 180	com/google/android/gms/internal/measurement/zzii:zza	(Lcom/google/android/gms/internal/measurement/zzii;)Lcom/google/android/gms/internal/measurement/zziw;
    //   109: invokevirtual 184	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   112: aload_0
    //   113: monitorexit
    //   114: ldc 141
    //   116: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: aload_2
    //   121: ldc 156
    //   123: invokeinterface 188 2 0
    //   128: astore_1
    //   129: aload_1
    //   130: instanceof 60
    //   133: ifeq +11 -> 144
    //   136: aload_1
    //   137: checkcast 60	com/google/android/gms/internal/measurement/zzey
    //   140: astore_1
    //   141: goto -73 -> 68
    //   144: new 190	com/google/android/gms/internal/measurement/zzfa
    //   147: dup
    //   148: aload_2
    //   149: invokespecial 193	com/google/android/gms/internal/measurement/zzfa:<init>	(Landroid/os/IBinder;)V
    //   152: astore_1
    //   153: goto -85 -> 68
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 21	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   163: invokevirtual 123	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   166: invokevirtual 146	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   169: ldc 195
    //   171: invokevirtual 131	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   174: goto -91 -> 83
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: ldc 141
    //   182: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_1
    //   186: athrow
    //   187: aload_0
    //   188: getfield 21	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   191: invokevirtual 123	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   194: invokevirtual 146	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   197: ldc 197
    //   199: aload_1
    //   200: invokevirtual 111	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   203: aconst_null
    //   204: astore_1
    //   205: goto -122 -> 83
    //   208: aload_0
    //   209: getfield 21	com/google/android/gms/internal/measurement/zziw:zzape	Lcom/google/android/gms/internal/measurement/zzii;
    //   212: invokevirtual 66	com/google/android/gms/internal/measurement/zzhg:zzgd	()Lcom/google/android/gms/internal/measurement/zzgg;
    //   215: new 199	com/google/android/gms/internal/measurement/zzix
    //   218: dup
    //   219: aload_0
    //   220: aload_1
    //   221: invokespecial 200	com/google/android/gms/internal/measurement/zzix:<init>	(Lcom/google/android/gms/internal/measurement/zziw;Lcom/google/android/gms/internal/measurement/zzey;)V
    //   224: invokevirtual 77	com/google/android/gms/internal/measurement/zzgg:zzc	(Ljava/lang/Runnable;)V
    //   227: goto -115 -> 112
    //   230: astore_1
    //   231: goto -119 -> 112
    //   234: astore_2
    //   235: goto -76 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	zziw
    //   0	238	1	paramComponentName	ComponentName
    //   0	238	2	paramIBinder	android.os.IBinder
    //   57	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   44	58	156	android/os/RemoteException
    //   120	141	156	android/os/RemoteException
    //   144	153	156	android/os/RemoteException
    //   187	203	156	android/os/RemoteException
    //   16	38	177	finally
    //   44	58	177	finally
    //   68	83	177	finally
    //   87	92	177	finally
    //   92	112	177	finally
    //   112	114	177	finally
    //   120	141	177	finally
    //   144	153	177	finally
    //   159	174	177	finally
    //   178	180	177	finally
    //   187	203	177	finally
    //   208	227	177	finally
    //   92	112	230	java/lang/IllegalArgumentException
    //   68	83	234	android/os/RemoteException
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(69337);
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
    this.zzape.zzge().zzis().log("Service disconnected");
    this.zzape.zzgd().zzc(new zziy(this, paramComponentName));
    AppMethodBeat.o(69337);
  }
  
  public final void zzc(Intent paramIntent)
  {
    AppMethodBeat.i(69335);
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
      AppMethodBeat.o(69335);
    }
  }
  
  public final void zzkh()
  {
    AppMethodBeat.i(69338);
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
      AppMethodBeat.o(69338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zziw
 * JD-Core Version:    0.7.0.1
 */