package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;

public final class e<T>
{
  private T huI;
  
  public e(T paramT)
  {
    this.huI = paramT;
  }
  
  public final T cu(T paramT)
  {
    try
    {
      AppMethodBeat.i(136943);
      Object localObject = this.huI;
      this.huI = paramT;
      b.i("StateRunner", localObject.toString() + " -> " + this.huI.toString());
      AppMethodBeat.o(136943);
      return localObject;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public final T get()
  {
    try
    {
      Object localObject1 = this.huI;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /* Error */
  public final boolean i(T... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 57
    //   6: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_0
    //   10: istore_2
    //   11: iload_2
    //   12: ifgt +38 -> 50
    //   15: aload_1
    //   16: iconst_0
    //   17: aaload
    //   18: astore 4
    //   20: aload_0
    //   21: getfield 15	com/tencent/mm/audio/mix/f/e:huI	Ljava/lang/Object;
    //   24: aload 4
    //   26: invokevirtual 61	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +14 -> 43
    //   32: iconst_1
    //   33: istore_3
    //   34: ldc 57
    //   36: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_3
    //   42: ireturn
    //   43: iload_2
    //   44: iconst_1
    //   45: iadd
    //   46: istore_2
    //   47: goto -36 -> 11
    //   50: ldc 57
    //   52: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: goto -16 -> 39
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	e
    //   0	63	1	paramVarArgs	T[]
    //   10	37	2	i	int
    //   1	41	3	bool	boolean
    //   18	7	4	?	T
    // Exception table:
    //   from	to	target	type
    //   4	9	58	finally
    //   20	32	58	finally
    //   34	39	58	finally
    //   50	55	58	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.e
 * JD-Core Version:    0.7.0.1
 */