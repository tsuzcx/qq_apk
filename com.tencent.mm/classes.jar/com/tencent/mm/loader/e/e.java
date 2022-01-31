package com.tencent.mm.loader.e;

import com.tencent.mm.loader.h.d;

public final class e
  implements com.tencent.mm.loader.d.e
{
  private d<String, Integer> eOy = new d(10);
  
  /* Error */
  public final boolean a(com.tencent.mm.loader.h.a.a<?> parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/mm/loader/e/e:eOy	Lcom/tencent/mm/loader/h/d;
    //   6: aload_1
    //   7: invokevirtual 29	com/tencent/mm/loader/h/a/a:toString	()Ljava/lang/String;
    //   10: invokevirtual 33	com/tencent/mm/loader/h/d:Z	(Ljava/lang/Object;)Z
    //   13: ifeq +95 -> 108
    //   16: aload_0
    //   17: getfield 20	com/tencent/mm/loader/e/e:eOy	Lcom/tencent/mm/loader/h/d;
    //   20: aload_1
    //   21: invokevirtual 29	com/tencent/mm/loader/h/a/a:toString	()Ljava/lang/String;
    //   24: invokevirtual 37	com/tencent/mm/loader/h/d:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 39	java/lang/Integer
    //   30: invokevirtual 43	java/lang/Integer:intValue	()I
    //   33: istore_2
    //   34: aload_0
    //   35: getfield 20	com/tencent/mm/loader/e/e:eOy	Lcom/tencent/mm/loader/h/d;
    //   38: aload_1
    //   39: invokevirtual 29	com/tencent/mm/loader/h/a/a:toString	()Ljava/lang/String;
    //   42: iload_2
    //   43: iconst_1
    //   44: iadd
    //   45: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: invokevirtual 51	com/tencent/mm/loader/h/d:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: iload_2
    //   53: bipush 50
    //   55: if_icmplt +69 -> 124
    //   58: iload_2
    //   59: bipush 50
    //   61: if_icmpeq +11 -> 72
    //   64: iload_2
    //   65: sipush 500
    //   68: irem
    //   69: ifne +33 -> 102
    //   72: ldc 53
    //   74: ldc 55
    //   76: iconst_3
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_1
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: bipush 50
    //   88: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aastore
    //   92: dup
    //   93: iconst_2
    //   94: iload_2
    //   95: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokestatic 61	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: iconst_0
    //   103: istore_3
    //   104: aload_0
    //   105: monitorexit
    //   106: iload_3
    //   107: ireturn
    //   108: aload_0
    //   109: getfield 20	com/tencent/mm/loader/e/e:eOy	Lcom/tencent/mm/loader/h/d;
    //   112: aload_1
    //   113: invokevirtual 29	com/tencent/mm/loader/h/a/a:toString	()Ljava/lang/String;
    //   116: iconst_1
    //   117: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: invokevirtual 51	com/tencent/mm/loader/h/d:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: iconst_1
    //   125: istore_3
    //   126: goto -22 -> 104
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	e
    //   0	134	1	parama	com.tencent.mm.loader.h.a.a<?>
    //   33	62	2	i	int
    //   103	23	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	52	129	finally
    //   72	102	129	finally
    //   108	124	129	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.e.e
 * JD-Core Version:    0.7.0.1
 */