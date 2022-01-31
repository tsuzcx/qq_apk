package com.tencent.mm.memory;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;

public abstract class a<T>
  extends e<T, Integer>
{
  public T b(Integer paramInteger)
  {
    label133:
    for (;;)
    {
      try
      {
        paramInteger = this.dOX.subMap(paramInteger, true, Integer.valueOf(2147483647), true);
        if ((paramInteger != null) && (!paramInteger.isEmpty()))
        {
          Iterator localIterator = paramInteger.keySet().iterator();
          if (!localIterator.hasNext()) {
            break label133;
          }
          d locald = (d)paramInteger.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
          if (locald.size() <= 0) {
            continue;
          }
          paramInteger = locald.pop();
          this.dOX.put(locald.EU(), locald);
          if (paramInteger != null)
          {
            bA(as(paramInteger));
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
  public T c(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/tencent/mm/memory/a:dOX	Ljava/util/NavigableMap;
    //   6: aload_1
    //   7: invokeinterface 64 2 0
    //   12: checkcast 66	com/tencent/mm/memory/d
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +43 -> 60
    //   20: aload_3
    //   21: invokevirtual 69	com/tencent/mm/memory/d:size	()I
    //   24: ifle +36 -> 60
    //   27: aload_3
    //   28: invokevirtual 72	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 22	com/tencent/mm/memory/a:dOX	Ljava/util/NavigableMap;
    //   36: aload_3
    //   37: invokevirtual 75	com/tencent/mm/memory/d:EU	()Ljava/lang/Object;
    //   40: aload_3
    //   41: invokeinterface 79 3 0
    //   46: pop
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 83	com/tencent/mm/memory/a:as	(Ljava/lang/Object;)J
    //   53: invokevirtual 87	com/tencent/mm/memory/a:bA	(J)V
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: aload_3
    //   61: ifnonnull +32 -> 93
    //   64: iconst_m1
    //   65: istore_2
    //   66: ldc 92
    //   68: ldc 94
    //   70: iconst_2
    //   71: anewarray 96	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_1
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: iload_2
    //   81: invokestatic 27	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokestatic 102	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -34 -> 56
    //   93: aload_3
    //   94: getfield 106	com/tencent/mm/memory/d:dOV	Ljava/util/Queue;
    //   97: ifnonnull +8 -> 105
    //   100: iconst_m1
    //   101: istore_2
    //   102: goto -36 -> 66
    //   105: aload_3
    //   106: getfield 106	com/tencent/mm/memory/d:dOV	Ljava/util/Queue;
    //   109: invokeinterface 109 1 0
    //   114: istore_2
    //   115: goto -49 -> 66
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	a
    //   0	123	1	paramInteger	Integer
    //   65	50	2	i	int
    //   15	91	3	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	16	118	finally
    //   20	56	118	finally
    //   66	88	118	finally
    //   93	100	118	finally
    //   105	115	118	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a
 * JD-Core Version:    0.7.0.1
 */