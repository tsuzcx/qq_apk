package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class zzhx
  implements Runnable
{
  zzhx(zzhk paramzzhk, AtomicReference paramAtomicReference) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 1752
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 16	com/google/android/gms/internal/measurement/zzhx:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   10: astore_1
    //   11: aload_1
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 16	com/google/android/gms/internal/measurement/zzhx:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 14	com/google/android/gms/internal/measurement/zzhx:zzanw	Lcom/google/android/gms/internal/measurement/zzhk;
    //   22: invokevirtual 33	com/google/android/gms/internal/measurement/zzhg:zzgg	()Lcom/google/android/gms/internal/measurement/zzef;
    //   25: astore_3
    //   26: aload_2
    //   27: aload_3
    //   28: aload_3
    //   29: invokevirtual 37	com/google/android/gms/internal/measurement/zzhg:zzfv	()Lcom/google/android/gms/internal/measurement/zzfb;
    //   32: invokevirtual 43	com/google/android/gms/internal/measurement/zzfb:zzah	()Ljava/lang/String;
    //   35: getstatic 49	com/google/android/gms/internal/measurement/zzew:zzahs	Lcom/google/android/gms/internal/measurement/zzex;
    //   38: invokevirtual 55	com/google/android/gms/internal/measurement/zzef:zzb	(Ljava/lang/String;Lcom/google/android/gms/internal/measurement/zzex;)I
    //   41: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokevirtual 67	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   47: aload_0
    //   48: getfield 16	com/google/android/gms/internal/measurement/zzhx:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   51: invokevirtual 70	java/lang/Object:notify	()V
    //   54: aload_1
    //   55: monitorexit
    //   56: sipush 1752
    //   59: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 16	com/google/android/gms/internal/measurement/zzhx:zzanv	Ljava/util/concurrent/atomic/AtomicReference;
    //   68: invokevirtual 70	java/lang/Object:notify	()V
    //   71: sipush 1752
    //   74: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_2
    //   78: athrow
    //   79: astore_2
    //   80: aload_1
    //   81: monitorexit
    //   82: sipush 1752
    //   85: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	zzhx
    //   10	71	1	localAtomicReference1	AtomicReference
    //   17	10	2	localAtomicReference2	AtomicReference
    //   63	15	2	localObject1	Object
    //   79	10	2	localObject2	Object
    //   25	4	3	localzzef	zzef
    // Exception table:
    //   from	to	target	type
    //   13	47	63	finally
    //   47	56	79	finally
    //   64	79	79	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzhx
 * JD-Core Version:    0.7.0.1
 */