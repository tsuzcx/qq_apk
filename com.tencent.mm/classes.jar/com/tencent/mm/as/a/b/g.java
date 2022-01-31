package com.tencent.mm.as.a.b;

import com.tencent.mm.as.a.c.n;
import com.tencent.mm.as.a.d.a;

public final class g
  implements n
{
  private a<String, Integer> erN = new a(10);
  
  /* Error */
  public final boolean mu(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/mm/as/a/b/g:erN	Lcom/tencent/mm/as/a/d/a;
    //   6: aload_1
    //   7: invokevirtual 27	com/tencent/mm/as/a/d/a:aC	(Ljava/lang/Object;)Z
    //   10: ifeq +89 -> 99
    //   13: aload_0
    //   14: getfield 20	com/tencent/mm/as/a/b/g:erN	Lcom/tencent/mm/as/a/d/a;
    //   17: aload_1
    //   18: invokevirtual 31	com/tencent/mm/as/a/d/a:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 33	java/lang/Integer
    //   24: invokevirtual 37	java/lang/Integer:intValue	()I
    //   27: istore_2
    //   28: aload_0
    //   29: getfield 20	com/tencent/mm/as/a/b/g:erN	Lcom/tencent/mm/as/a/d/a;
    //   32: aload_1
    //   33: iload_2
    //   34: iconst_1
    //   35: iadd
    //   36: invokestatic 41	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: invokevirtual 45	com/tencent/mm/as/a/d/a:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: iload_2
    //   44: bipush 50
    //   46: if_icmplt +66 -> 112
    //   49: iload_2
    //   50: bipush 50
    //   52: if_icmpeq +11 -> 63
    //   55: iload_2
    //   56: sipush 500
    //   59: irem
    //   60: ifne +33 -> 93
    //   63: ldc 47
    //   65: ldc 49
    //   67: iconst_3
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: bipush 50
    //   79: invokestatic 41	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: dup
    //   84: iconst_2
    //   85: iload_2
    //   86: invokestatic 41	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: iconst_0
    //   94: istore_3
    //   95: aload_0
    //   96: monitorexit
    //   97: iload_3
    //   98: ireturn
    //   99: aload_0
    //   100: getfield 20	com/tencent/mm/as/a/b/g:erN	Lcom/tencent/mm/as/a/d/a;
    //   103: aload_1
    //   104: iconst_1
    //   105: invokestatic 41	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: invokevirtual 45	com/tencent/mm/as/a/d/a:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: iconst_1
    //   113: istore_3
    //   114: goto -19 -> 95
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	g
    //   0	122	1	paramString	String
    //   27	59	2	i	int
    //   94	20	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	43	117	finally
    //   63	93	117	finally
    //   99	112	117	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.as.a.b.g
 * JD-Core Version:    0.7.0.1
 */