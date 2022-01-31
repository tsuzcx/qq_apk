package com.tencent.mm.plugin.clean.c.a;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;

public final class b
  implements c
{
  public HashMap<Long, ah> iCb = new HashMap(5);
  private HashSet<Long> iCc = new HashSet(5);
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    paramByte = 0;
    while (paramByte <= 5)
    {
      e.c(new b.1(this), "ThreadController_handler", 1).start();
      paramByte += 1;
    }
  }
  
  private void f(Long paramLong)
  {
    try
    {
      if (this.iCc.remove(paramLong)) {
        y.d("MicroMsg.ThreadController", "thread is idle, id=%d", new Object[] { paramLong });
      }
      return;
    }
    finally
    {
      paramLong = finally;
      throw paramLong;
    }
  }
  
  /* Error */
  public final boolean b(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: putfield 74	com/tencent/mm/plugin/clean/c/a/a:iCa	Lcom/tencent/mm/plugin/clean/c/a/c;
    //   7: ldc 58
    //   9: ldc 76
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 27	com/tencent/mm/plugin/clean/c/a/b:iCc	Ljava/util/HashSet;
    //   21: invokevirtual 80	java/util/HashSet:toString	()Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 66	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 32	com/tencent/mm/plugin/clean/c/a/b:iCb	Ljava/util/HashMap;
    //   32: invokevirtual 84	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   35: invokeinterface 90 1 0
    //   40: astore_3
    //   41: aload_3
    //   42: invokeinterface 96 1 0
    //   47: ifeq +67 -> 114
    //   50: aload_3
    //   51: invokeinterface 100 1 0
    //   56: checkcast 102	java/util/Map$Entry
    //   59: astore 4
    //   61: aload_0
    //   62: getfield 27	com/tencent/mm/plugin/clean/c/a/b:iCc	Ljava/util/HashSet;
    //   65: aload 4
    //   67: invokeinterface 105 1 0
    //   72: invokevirtual 108	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   75: ifne -34 -> 41
    //   78: aload 4
    //   80: invokeinterface 111 1 0
    //   85: checkcast 113	com/tencent/mm/sdk/platformtools/ah
    //   88: aload_1
    //   89: invokevirtual 117	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
    //   92: pop
    //   93: aload_0
    //   94: getfield 27	com/tencent/mm/plugin/clean/c/a/b:iCc	Ljava/util/HashSet;
    //   97: aload 4
    //   99: invokeinterface 105 1 0
    //   104: invokevirtual 120	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   107: pop
    //   108: iconst_1
    //   109: istore_2
    //   110: aload_0
    //   111: monitorexit
    //   112: iload_2
    //   113: ireturn
    //   114: iconst_0
    //   115: istore_2
    //   116: goto -6 -> 110
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	b
    //   0	124	1	parama	a
    //   109	7	2	bool	boolean
    //   40	11	3	localIterator	java.util.Iterator
    //   59	39	4	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   2	41	119	finally
    //   41	108	119	finally
  }
  
  public final void g(Long paramLong)
  {
    f(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a.b
 * JD-Core Version:    0.7.0.1
 */