package com.tencent.mm.ay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.p;
import com.tencent.mm.ay.a.d.a;

public final class g
  implements p
{
  private a<String, Integer> lSg;
  
  public g()
  {
    AppMethodBeat.i(130423);
    this.lSg = new a(10);
    AppMethodBeat.o(130423);
  }
  
  /* Error */
  public final boolean Ww(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 33
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 26	com/tencent/mm/ay/a/b/g:lSg	Lcom/tencent/mm/ay/a/d/a;
    //   11: aload_1
    //   12: invokevirtual 37	com/tencent/mm/ay/a/d/a:check	(Ljava/lang/Object;)Z
    //   15: ifeq +94 -> 109
    //   18: aload_0
    //   19: getfield 26	com/tencent/mm/ay/a/b/g:lSg	Lcom/tencent/mm/ay/a/d/a;
    //   22: aload_1
    //   23: invokevirtual 41	com/tencent/mm/ay/a/d/a:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 43	java/lang/Integer
    //   29: invokevirtual 47	java/lang/Integer:intValue	()I
    //   32: istore_2
    //   33: aload_0
    //   34: getfield 26	com/tencent/mm/ay/a/b/g:lSg	Lcom/tencent/mm/ay/a/d/a;
    //   37: aload_1
    //   38: iload_2
    //   39: iconst_1
    //   40: iadd
    //   41: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokevirtual 55	com/tencent/mm/ay/a/d/a:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: iload_2
    //   49: bipush 50
    //   51: if_icmplt +71 -> 122
    //   54: iload_2
    //   55: bipush 50
    //   57: if_icmpeq +11 -> 68
    //   60: iload_2
    //   61: sipush 500
    //   64: irem
    //   65: ifne +33 -> 98
    //   68: ldc 57
    //   70: ldc 59
    //   72: iconst_3
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: bipush 50
    //   84: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: dup
    //   89: iconst_2
    //   90: iload_2
    //   91: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: invokestatic 64	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: ldc 33
    //   100: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_0
    //   104: istore_3
    //   105: aload_0
    //   106: monitorexit
    //   107: iload_3
    //   108: ireturn
    //   109: aload_0
    //   110: getfield 26	com/tencent/mm/ay/a/b/g:lSg	Lcom/tencent/mm/ay/a/d/a;
    //   113: aload_1
    //   114: iconst_1
    //   115: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 55	com/tencent/mm/ay/a/d/a:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: ldc 33
    //   124: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iconst_1
    //   128: istore_3
    //   129: goto -24 -> 105
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	g
    //   0	137	1	paramString	String
    //   32	59	2	i	int
    //   104	25	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	48	132	finally
    //   68	98	132	finally
    //   98	103	132	finally
    //   109	122	132	finally
    //   122	127	132	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ay.a.b.g
 * JD-Core Version:    0.7.0.1
 */