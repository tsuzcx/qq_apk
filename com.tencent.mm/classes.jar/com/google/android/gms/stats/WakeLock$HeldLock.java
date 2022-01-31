package com.google.android.gms.stats;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;

public class WakeLock$HeldLock
{
  private boolean zzaek = true;
  private Future zzael;
  private final String zzaem;
  
  private WakeLock$HeldLock(WakeLock paramWakeLock, String paramString)
  {
    this.zzaem = paramString;
  }
  
  public void finalize()
  {
    AppMethodBeat.i(113948);
    if (this.zzaek)
    {
      String str = String.valueOf(this.zzaem);
      if (str.length() == 0) {
        break label45;
      }
      "HeldLock finalized while still holding the WakeLock! Reason: ".concat(str);
    }
    for (;;)
    {
      release(0);
      AppMethodBeat.o(113948);
      return;
      label45:
      new String("HeldLock finalized while still holding the WakeLock! Reason: ");
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(113946);
    release(0);
    AppMethodBeat.o(113946);
  }
  
  /* Error */
  public void release(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 69
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 24	com/google/android/gms/stats/WakeLock$HeldLock:zzaek	Z
    //   11: ifne +11 -> 22
    //   14: ldc 69
    //   16: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 24	com/google/android/gms/stats/WakeLock$HeldLock:zzaek	Z
    //   27: aload_0
    //   28: getfield 34	com/google/android/gms/stats/WakeLock$HeldLock:zzael	Ljava/util/concurrent/Future;
    //   31: ifnull +19 -> 50
    //   34: aload_0
    //   35: getfield 34	com/google/android/gms/stats/WakeLock$HeldLock:zzael	Ljava/util/concurrent/Future;
    //   38: iconst_0
    //   39: invokeinterface 75 2 0
    //   44: pop
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 34	com/google/android/gms/stats/WakeLock$HeldLock:zzael	Ljava/util/concurrent/Future;
    //   50: aload_0
    //   51: getfield 19	com/google/android/gms/stats/WakeLock$HeldLock:zzaei	Lcom/google/android/gms/stats/WakeLock;
    //   54: aload_0
    //   55: getfield 26	com/google/android/gms/stats/WakeLock$HeldLock:zzaem	Ljava/lang/String;
    //   58: iload_1
    //   59: invokestatic 78	com/google/android/gms/stats/WakeLock:zza	(Lcom/google/android/gms/stats/WakeLock;Ljava/lang/String;I)V
    //   62: ldc 69
    //   64: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: goto -48 -> 19
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	HeldLock
    //   0	75	1	paramInt	int
    //   70	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	70	finally
    //   22	50	70	finally
    //   50	67	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.stats.WakeLock.HeldLock
 * JD-Core Version:    0.7.0.1
 */