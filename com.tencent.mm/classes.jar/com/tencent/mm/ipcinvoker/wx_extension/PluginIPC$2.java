package com.tencent.mm.ipcinvoker.wx_extension;

final class PluginIPC$2
  implements Runnable
{
  PluginIPC$2(PluginIPC paramPluginIPC) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 25
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 37	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   10: invokevirtual 43	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   13: getstatic 49	com/tencent/mm/storage/ae$a:Fml	Lcom/tencent/mm/storage/ae$a;
    //   16: lconst_0
    //   17: invokevirtual 55	com/tencent/mm/storage/ab:a	(Lcom/tencent/mm/storage/ae$a;J)J
    //   20: lstore_2
    //   21: invokestatic 59	com/tencent/mm/ipcinvoker/wx_extension/PluginIPC:access$000	()J
    //   24: lstore 4
    //   26: invokestatic 64	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   29: lstore 6
    //   31: lload_2
    //   32: lload 4
    //   34: ladd
    //   35: lload 6
    //   37: lcmp
    //   38: ifgt +154 -> 192
    //   41: invokestatic 70	com/tencent/mm/ipcinvoker/wx_extension/c:Km	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   44: getfield 76	com/tencent/mm/sdk/platformtools/ax:EVG	Lcom/tencent/mmkv/MMKV;
    //   47: invokevirtual 81	com/tencent/mmkv/MMKV:totalSize	()J
    //   50: ldc2_w 82
    //   53: lcmp
    //   54: iflt +55 -> 109
    //   57: ldc 85
    //   59: ldc 87
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: iload_1
    //   68: invokestatic 93	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   71: aastore
    //   72: invokestatic 98	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: iload_1
    //   76: ifeq +9 -> 85
    //   79: invokestatic 70	com/tencent/mm/ipcinvoker/wx_extension/c:Km	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   82: invokevirtual 101	com/tencent/mm/sdk/platformtools/ax:clearAll	()V
    //   85: invokestatic 37	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   88: invokevirtual 43	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   91: getstatic 49	com/tencent/mm/storage/ae$a:Fml	Lcom/tencent/mm/storage/ae$a;
    //   94: invokestatic 64	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   97: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   100: invokevirtual 110	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   103: ldc 25
    //   105: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: return
    //   109: iconst_0
    //   110: istore_1
    //   111: goto -54 -> 57
    //   114: astore 8
    //   116: ldc 85
    //   118: ldc 115
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload 8
    //   128: aastore
    //   129: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: invokestatic 37	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   135: invokevirtual 43	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   138: getstatic 49	com/tencent/mm/storage/ae$a:Fml	Lcom/tencent/mm/storage/ae$a;
    //   141: invokestatic 64	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   144: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: invokevirtual 110	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   150: ldc 25
    //   152: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: astore 8
    //   158: ldc 25
    //   160: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: return
    //   164: astore 8
    //   166: invokestatic 37	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   169: invokevirtual 43	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   172: getstatic 49	com/tencent/mm/storage/ae$a:Fml	Lcom/tencent/mm/storage/ae$a;
    //   175: invokestatic 64	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   178: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   181: invokevirtual 110	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   184: ldc 25
    //   186: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload 8
    //   191: athrow
    //   192: ldc 25
    //   194: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	2
    //   1	110	1	bool	boolean
    //   20	12	2	l1	long
    //   24	9	4	l2	long
    //   29	7	6	l3	long
    //   114	13	8	localThrowable1	java.lang.Throwable
    //   156	1	8	localThrowable2	java.lang.Throwable
    //   164	26	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   41	57	114	java/lang/Throwable
    //   57	75	114	java/lang/Throwable
    //   79	85	114	java/lang/Throwable
    //   7	31	156	java/lang/Throwable
    //   85	108	156	java/lang/Throwable
    //   132	155	156	java/lang/Throwable
    //   166	192	156	java/lang/Throwable
    //   41	57	164	finally
    //   57	75	164	finally
    //   79	85	164	finally
    //   116	132	164	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.2
 * JD-Core Version:    0.7.0.1
 */