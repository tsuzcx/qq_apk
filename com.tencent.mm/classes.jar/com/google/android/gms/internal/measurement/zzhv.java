package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class zzhv
  implements Runnable
{
  zzhv(zzhk paramzzhk, AtomicReference paramAtomicReference) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 16	com/google/android/gms/internal/measurement/zzhv:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   9: astore_1
    //   10: aload_1
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 16	com/google/android/gms/internal/measurement/zzhv:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   16: aload_0
    //   17: getfield 14	com/google/android/gms/internal/measurement/zzhv:zzanw	Lcom/google/android/gms/internal/measurement/zzhk;
    //   20: invokevirtual 34	com/google/android/gms/internal/measurement/zzhg:zzgg	()Lcom/google/android/gms/internal/measurement/zzef;
    //   23: invokevirtual 40	com/google/android/gms/internal/measurement/zzef:zzhm	()Ljava/lang/String;
    //   26: invokevirtual 46	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 16	com/google/android/gms/internal/measurement/zzhv:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   33: invokevirtual 49	java/lang/Object:notify	()V
    //   36: aload_1
    //   37: monitorexit
    //   38: ldc 22
    //   40: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 16	com/google/android/gms/internal/measurement/zzhv:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   49: invokevirtual 49	java/lang/Object:notify	()V
    //   52: ldc 22
    //   54: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_2
    //   58: athrow
    //   59: astore_2
    //   60: aload_1
    //   61: monitorexit
    //   62: ldc 22
    //   64: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	zzhv
    //   9	52	1	localAtomicReference	AtomicReference
    //   44	14	2	localObject1	Object
    //   59	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	29	44	finally
    //   29	38	59	finally
    //   45	59	59	finally
    //   60	62	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzhv
 * JD-Core Version:    0.7.0.1
 */