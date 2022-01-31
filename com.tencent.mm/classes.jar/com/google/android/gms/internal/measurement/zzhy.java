package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class zzhy
  implements Runnable
{
  zzhy(zzhk paramzzhk, AtomicReference paramAtomicReference) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 16	com/google/android/gms/internal/measurement/zzhy:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   9: astore_1
    //   10: aload_1
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 16	com/google/android/gms/internal/measurement/zzhy:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   16: astore_2
    //   17: aload_0
    //   18: getfield 14	com/google/android/gms/internal/measurement/zzhy:zzanw	Lcom/google/android/gms/internal/measurement/zzhk;
    //   21: invokevirtual 34	com/google/android/gms/internal/measurement/zzhg:zzgg	()Lcom/google/android/gms/internal/measurement/zzef;
    //   24: astore_3
    //   25: aload_2
    //   26: aload_3
    //   27: aload_3
    //   28: invokevirtual 38	com/google/android/gms/internal/measurement/zzhg:zzfv	()Lcom/google/android/gms/internal/measurement/zzfb;
    //   31: invokevirtual 44	com/google/android/gms/internal/measurement/zzfb:zzah	()Ljava/lang/String;
    //   34: getstatic 50	com/google/android/gms/internal/measurement/zzew:zzaht	Lcom/google/android/gms/internal/measurement/zzex;
    //   37: invokevirtual 56	com/google/android/gms/internal/measurement/zzef:zzc	(Ljava/lang/String;Lcom/google/android/gms/internal/measurement/zzex;)D
    //   40: invokestatic 62	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   43: invokevirtual 68	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 16	com/google/android/gms/internal/measurement/zzhy:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   50: invokevirtual 71	java/lang/Object:notify	()V
    //   53: aload_1
    //   54: monitorexit
    //   55: ldc 22
    //   57: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 16	com/google/android/gms/internal/measurement/zzhy:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   66: invokevirtual 71	java/lang/Object:notify	()V
    //   69: ldc 22
    //   71: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: aload_1
    //   78: monitorexit
    //   79: ldc 22
    //   81: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	zzhy
    //   9	69	1	localAtomicReference1	AtomicReference
    //   16	10	2	localAtomicReference2	AtomicReference
    //   61	14	2	localObject1	Object
    //   76	9	2	localObject2	Object
    //   24	4	3	localzzef	zzef
    // Exception table:
    //   from	to	target	type
    //   12	46	61	finally
    //   46	55	76	finally
    //   62	76	76	finally
    //   77	79	76	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzhy
 * JD-Core Version:    0.7.0.1
 */