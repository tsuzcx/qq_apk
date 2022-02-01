package com.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$d
{
  private String bRs;
  private long bRt;
  private String bRu;
  private long bRv;
  
  static boolean r(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88027);
    if (Math.abs(paramLong1 - paramLong2) <= 10000L)
    {
      AppMethodBeat.o(88027);
      return true;
    }
    AppMethodBeat.o(88027);
    return false;
  }
  
  /* Error */
  final String a(String paramString, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 43
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload 4
    //   9: ifeq +116 -> 125
    //   12: aload_1
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 45	com/c/a/a/n$d:bRs	Ljava/lang/String;
    //   19: ifnull +45 -> 64
    //   22: aload_1
    //   23: astore 5
    //   25: lload_2
    //   26: aload_0
    //   27: getfield 47	com/c/a/a/n$d:bRt	J
    //   30: invokestatic 49	com/c/a/a/n$d:r	(JJ)Z
    //   33: ifeq +31 -> 64
    //   36: new 51	java/lang/StringBuilder
    //   39: dup
    //   40: aload_1
    //   41: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   44: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 45	com/c/a/a/n$d:bRs	Ljava/lang/String;
    //   51: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 5
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 45	com/c/a/a/n$d:bRs	Ljava/lang/String;
    //   64: aload 5
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 70	com/c/a/a/n$d:bRu	Ljava/lang/String;
    //   71: ifnull +45 -> 116
    //   74: aload 5
    //   76: astore_1
    //   77: lload_2
    //   78: aload_0
    //   79: getfield 72	com/c/a/a/n$d:bRv	J
    //   82: invokestatic 49	com/c/a/a/n$d:r	(JJ)Z
    //   85: ifeq +31 -> 116
    //   88: new 51	java/lang/StringBuilder
    //   91: dup
    //   92: aload 5
    //   94: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 70	com/c/a/a/n$d:bRu	Ljava/lang/String;
    //   104: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore_1
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 70	com/c/a/a/n$d:bRu	Ljava/lang/String;
    //   116: ldc 43
    //   118: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: areturn
    //   125: aload_1
    //   126: astore 5
    //   128: aload_0
    //   129: getfield 45	com/c/a/a/n$d:bRs	Ljava/lang/String;
    //   132: ifnull +48 -> 180
    //   135: aload_1
    //   136: astore 5
    //   138: lload_2
    //   139: aload_0
    //   140: getfield 47	com/c/a/a/n$d:bRt	J
    //   143: invokestatic 49	com/c/a/a/n$d:r	(JJ)Z
    //   146: ifeq +34 -> 180
    //   149: new 51	java/lang/StringBuilder
    //   152: dup
    //   153: aload_1
    //   154: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   157: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: aload_0
    //   161: getfield 45	com/c/a/a/n$d:bRs	Ljava/lang/String;
    //   164: invokestatic 78	com/c/a/a/v:bG	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 5
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 45	com/c/a/a/n$d:bRs	Ljava/lang/String;
    //   180: aload 5
    //   182: astore_1
    //   183: aload_0
    //   184: getfield 70	com/c/a/a/n$d:bRu	Ljava/lang/String;
    //   187: ifnull -71 -> 116
    //   190: aload 5
    //   192: astore_1
    //   193: lload_2
    //   194: aload_0
    //   195: getfield 72	com/c/a/a/n$d:bRv	J
    //   198: invokestatic 49	com/c/a/a/n$d:r	(JJ)Z
    //   201: ifeq -85 -> 116
    //   204: new 51	java/lang/StringBuilder
    //   207: dup
    //   208: aload 5
    //   210: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   213: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload_0
    //   217: getfield 70	com/c/a/a/n$d:bRu	Ljava/lang/String;
    //   220: invokestatic 81	com/c/a/a/v:bF	(Ljava/lang/String;)Ljava/lang/String;
    //   223: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore_1
    //   230: aload_0
    //   231: aconst_null
    //   232: putfield 70	com/c/a/a/n$d:bRu	Ljava/lang/String;
    //   235: goto -119 -> 116
    //   238: astore_1
    //   239: aload_0
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	d
    //   0	243	1	paramString	String
    //   0	243	2	paramLong	long
    //   0	243	4	paramBoolean	boolean
    //   13	196	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	7	238	finally
    //   15	22	238	finally
    //   25	64	238	finally
    //   67	74	238	finally
    //   77	116	238	finally
    //   116	121	238	finally
    //   128	135	238	finally
    //   138	180	238	finally
    //   183	190	238	finally
    //   193	235	238	finally
  }
  
  final void l(String paramString, long paramLong)
  {
    try
    {
      this.bRs = paramString;
      this.bRt = paramLong;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final void m(String paramString, long paramLong)
  {
    try
    {
      this.bRu = paramString;
      this.bRv = paramLong;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final void reset()
  {
    try
    {
      this.bRs = null;
      this.bRu = null;
      this.bRt = 0L;
      this.bRv = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.c.a.a.n.d
 * JD-Core Version:    0.7.0.1
 */