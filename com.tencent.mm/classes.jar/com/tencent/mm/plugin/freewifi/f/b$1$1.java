package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.ai.f;

final class b$1$1
  implements f
{
  b$1$1(b.1 param1) {}
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, java.lang.String paramString, com.tencent.mm.ai.m paramm)
  {
    // Byte code:
    //   0: sipush 20868
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 32
    //   8: ldc 34
    //   10: iconst_3
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: iload_1
    //   17: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: iload_2
    //   24: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: aload_3
    //   31: aastore
    //   32: invokestatic 45	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: iload_1
    //   36: iload_2
    //   37: invokestatic 51	com/tencent/mm/plugin/freewifi/m:ep	(II)Z
    //   40: ifeq +187 -> 227
    //   43: aload 4
    //   45: checkcast 53	com/tencent/mm/plugin/freewifi/d/e
    //   48: invokevirtual 57	com/tencent/mm/plugin/freewifi/d/e:bAY	()Ljava/util/LinkedList;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +172 -> 227
    //   58: aload 4
    //   60: invokevirtual 63	java/util/LinkedList:size	()I
    //   63: ifle +164 -> 227
    //   66: invokestatic 69	com/tencent/mm/plugin/freewifi/model/j:bAM	()Lcom/tencent/mm/plugin/freewifi/g/f;
    //   69: astore_3
    //   70: aload 4
    //   72: invokevirtual 73	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   75: astore 4
    //   77: aload 4
    //   79: invokeinterface 79 1 0
    //   84: ifeq +143 -> 227
    //   87: aload 4
    //   89: invokeinterface 83 1 0
    //   94: checkcast 85	com/tencent/mm/protocal/protobuf/aeb
    //   97: astore 6
    //   99: aload 6
    //   101: getfield 89	com/tencent/mm/protocal/protobuf/aeb:id	Ljava/lang/String;
    //   104: astore 5
    //   106: aload 6
    //   108: getfield 93	com/tencent/mm/protocal/protobuf/aeb:csV	I
    //   111: istore_1
    //   112: ldc 32
    //   114: ldc 95
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload 5
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: iload_1
    //   128: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: invokestatic 45	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload 5
    //   137: invokestatic 99	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   140: ifne -63 -> 77
    //   143: iload_1
    //   144: ifne -67 -> 77
    //   147: ldc 101
    //   149: ldc 103
    //   151: iconst_1
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload 5
    //   159: aastore
    //   160: invokestatic 45	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: new 105	com/tencent/mm/plugin/freewifi/g/e
    //   166: dup
    //   167: invokespecial 106	com/tencent/mm/plugin/freewifi/g/e:<init>	()V
    //   170: astore 6
    //   172: aload 6
    //   174: aload 5
    //   176: putfield 109	com/tencent/mm/plugin/freewifi/g/e:field_id	Ljava/lang/String;
    //   179: ldc 101
    //   181: ldc 111
    //   183: aload_3
    //   184: aload 6
    //   186: iconst_0
    //   187: anewarray 113	java/lang/String
    //   190: invokevirtual 119	com/tencent/mm/plugin/freewifi/g/f:delete	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   193: invokestatic 122	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   196: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: goto -125 -> 77
    //   205: astore_3
    //   206: ldc 32
    //   208: aload_3
    //   209: invokestatic 133	com/tencent/mm/plugin/freewifi/m:f	(Ljava/lang/Exception;)Ljava/lang/String;
    //   212: invokestatic 136	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: iconst_1
    //   216: invokestatic 142	com/tencent/mm/plugin/freewifi/f/b:access$002	(Z)Z
    //   219: pop
    //   220: sipush 20868
    //   223: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: return
    //   227: iconst_1
    //   228: invokestatic 142	com/tencent/mm/plugin/freewifi/f/b:access$002	(Z)Z
    //   231: pop
    //   232: sipush 20868
    //   235: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: return
    //   239: astore_3
    //   240: iconst_1
    //   241: invokestatic 142	com/tencent/mm/plugin/freewifi/f/b:access$002	(Z)Z
    //   244: pop
    //   245: sipush 20868
    //   248: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_3
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	1
    //   0	253	1	paramInt1	int
    //   0	253	2	paramInt2	int
    //   0	253	3	paramString	java.lang.String
    //   0	253	4	paramm	com.tencent.mm.ai.m
    //   104	71	5	str	java.lang.String
    //   97	88	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	53	205	java/lang/Exception
    //   58	77	205	java/lang/Exception
    //   77	143	205	java/lang/Exception
    //   147	202	205	java/lang/Exception
    //   6	53	239	finally
    //   58	77	239	finally
    //   77	143	239	finally
    //   147	202	239	finally
    //   206	215	239	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.f.b.1.1
 * JD-Core Version:    0.7.0.1
 */