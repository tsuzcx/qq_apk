package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class zzhl
  implements Runnable
{
  zzhl(zzhk paramzzhk, AtomicReference paramAtomicReference) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 16	com/google/android/gms/internal/measurement/zzhl:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   9: astore_1
    //   10: aload_1
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 16	com/google/android/gms/internal/measurement/zzhl:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   16: aload_0
    //   17: getfield 14	com/google/android/gms/internal/measurement/zzhl:zzanw	Lcom/google/android/gms/internal/measurement/zzhk;
    //   20: invokevirtual 34	com/google/android/gms/internal/measurement/zzhg:zzgg	()Lcom/google/android/gms/internal/measurement/zzef;
    //   23: invokevirtual 40	com/google/android/gms/internal/measurement/zzef:zzhl	()Z
    //   26: invokestatic 46	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   29: invokevirtual 52	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   32: aload_0
    //   33: getfield 16	com/google/android/gms/internal/measurement/zzhl:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   36: invokevirtual 55	java/lang/Object:notify	()V
    //   39: aload_1
    //   40: monitorexit
    //   41: ldc 22
    //   43: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: return
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 16	com/google/android/gms/internal/measurement/zzhl:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   52: invokevirtual 55	java/lang/Object:notify	()V
    //   55: ldc 22
    //   57: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_2
    //   61: athrow
    //   62: astore_2
    //   63: aload_1
    //   64: monitorexit
    //   65: ldc 22
    //   67: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	zzhl
    //   9	55	1	localAtomicReference	AtomicReference
    //   47	14	2	localObject1	Object
    //   62	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	32	47	finally
    //   32	41	62	finally
    //   48	62	62	finally
    //   63	65	62	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzhl
 * JD-Core Version:    0.7.0.1
 */