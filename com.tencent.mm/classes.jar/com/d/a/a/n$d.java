package com.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$d
{
  private String bZn;
  private long bZo;
  private String bZp;
  private long bZq;
  
  static boolean o(long paramLong1, long paramLong2)
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
    //   2: ldc 42
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload 4
    //   9: ifeq +116 -> 125
    //   12: aload_1
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
    //   19: ifnull +45 -> 64
    //   22: aload_1
    //   23: astore 5
    //   25: lload_2
    //   26: aload_0
    //   27: getfield 46	com/d/a/a/n$d:bZo	J
    //   30: invokestatic 48	com/d/a/a/n$d:o	(JJ)Z
    //   33: ifeq +31 -> 64
    //   36: new 50	java/lang/StringBuilder
    //   39: dup
    //   40: aload_1
    //   41: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   44: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
    //   51: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 5
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
    //   64: aload 5
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
    //   71: ifnull +45 -> 116
    //   74: aload 5
    //   76: astore_1
    //   77: lload_2
    //   78: aload_0
    //   79: getfield 71	com/d/a/a/n$d:bZq	J
    //   82: invokestatic 48	com/d/a/a/n$d:o	(JJ)Z
    //   85: ifeq +31 -> 116
    //   88: new 50	java/lang/StringBuilder
    //   91: dup
    //   92: aload 5
    //   94: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
    //   104: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore_1
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
    //   116: ldc 42
    //   118: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: areturn
    //   125: aload_1
    //   126: astore 5
    //   128: aload_0
    //   129: getfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
    //   132: ifnull +48 -> 180
    //   135: aload_1
    //   136: astore 5
    //   138: lload_2
    //   139: aload_0
    //   140: getfield 46	com/d/a/a/n$d:bZo	J
    //   143: invokestatic 48	com/d/a/a/n$d:o	(JJ)Z
    //   146: ifeq +34 -> 180
    //   149: new 50	java/lang/StringBuilder
    //   152: dup
    //   153: aload_1
    //   154: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   157: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: aload_0
    //   161: getfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
    //   164: invokestatic 77	com/d/a/a/v:cq	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 5
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
    //   180: aload 5
    //   182: astore_1
    //   183: aload_0
    //   184: getfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
    //   187: ifnull -71 -> 116
    //   190: aload 5
    //   192: astore_1
    //   193: lload_2
    //   194: aload_0
    //   195: getfield 71	com/d/a/a/n$d:bZq	J
    //   198: invokestatic 48	com/d/a/a/n$d:o	(JJ)Z
    //   201: ifeq -85 -> 116
    //   204: new 50	java/lang/StringBuilder
    //   207: dup
    //   208: aload 5
    //   210: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   213: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload_0
    //   217: getfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
    //   220: invokestatic 80	com/d/a/a/v:cp	(Ljava/lang/String;)Ljava/lang/String;
    //   223: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore_1
    //   230: aload_0
    //   231: aconst_null
    //   232: putfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
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
      this.bZn = paramString;
      this.bZo = paramLong;
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
      this.bZp = paramString;
      this.bZq = paramLong;
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
      this.bZn = null;
      this.bZp = null;
      this.bZo = 0L;
      this.bZq = 0L;
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
 * Qualified Name:     com.d.a.a.n.d
 * JD-Core Version:    0.7.0.1
 */