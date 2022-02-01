package com.tencent.mm.memory;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;

public abstract class a<T>
  extends BucketPool<T, Integer>
{
  public T g(Integer paramInteger)
  {
    label136:
    for (;;)
    {
      try
      {
        paramInteger = this.nNn.subMap(paramInteger, true, Integer.valueOf(2147483647), true);
        if ((paramInteger != null) && (!paramInteger.isEmpty()))
        {
          Iterator localIterator = paramInteger.keySet().iterator();
          if (!localIterator.hasNext()) {
            break label136;
          }
          d locald = (d)paramInteger.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
          if (locald.size() <= 0) {
            continue;
          }
          paramInteger = locald.pop();
          this.nNn.put((Integer)locald.bvH(), locald);
          if (paramInteger != null)
          {
            io(jdMethod_do(paramInteger));
            return paramInteger;
          }
        }
        paramInteger = null;
        continue;
        paramInteger = null;
      }
      finally {}
    }
  }
  
  /* Error */
  public T h(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/tencent/mm/memory/a:nNn	Ljava/util/NavigableMap;
    //   6: aload_1
    //   7: invokeinterface 64 2 0
    //   12: checkcast 66	com/tencent/mm/memory/d
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +46 -> 63
    //   20: aload_3
    //   21: invokevirtual 69	com/tencent/mm/memory/d:size	()I
    //   24: ifle +39 -> 63
    //   27: aload_3
    //   28: invokevirtual 72	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 22	com/tencent/mm/memory/a:nNn	Ljava/util/NavigableMap;
    //   36: aload_3
    //   37: invokevirtual 75	com/tencent/mm/memory/d:bvH	()Ljava/lang/Object;
    //   40: checkcast 14	java/lang/Integer
    //   43: aload_3
    //   44: invokeinterface 79 3 0
    //   49: pop
    //   50: aload_0
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 83	com/tencent/mm/memory/a:do	(Ljava/lang/Object;)J
    //   56: invokevirtual 87	com/tencent/mm/memory/a:io	(J)V
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: aload_3
    //   64: ifnonnull +32 -> 96
    //   67: iconst_m1
    //   68: istore_2
    //   69: ldc 92
    //   71: ldc 94
    //   73: iconst_2
    //   74: anewarray 96	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: iload_2
    //   84: invokestatic 27	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aconst_null
    //   92: astore_1
    //   93: goto -34 -> 59
    //   96: aload_3
    //   97: getfield 106	com/tencent/mm/memory/d:nNl	Ljava/util/Queue;
    //   100: ifnonnull +8 -> 108
    //   103: iconst_m1
    //   104: istore_2
    //   105: goto -36 -> 69
    //   108: aload_3
    //   109: getfield 106	com/tencent/mm/memory/d:nNl	Ljava/util/Queue;
    //   112: invokeinterface 109 1 0
    //   117: istore_2
    //   118: goto -49 -> 69
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	a
    //   0	126	1	paramInteger	Integer
    //   68	50	2	i	int
    //   15	94	3	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	16	121	finally
    //   20	59	121	finally
    //   69	91	121	finally
    //   96	103	121	finally
    //   108	118	121	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a
 * JD-Core Version:    0.7.0.1
 */