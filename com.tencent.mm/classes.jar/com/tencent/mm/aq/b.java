package com.tencent.mm.aq;

public final class b
{
  /* Error */
  public static Object z(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 9
    //   4: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_3
    //   8: astore_2
    //   9: aload_0
    //   10: ifnull +23 -> 33
    //   13: new 17	java/io/ObjectInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 21	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokevirtual 25	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   28: astore_2
    //   29: aload_1
    //   30: invokevirtual 29	java/io/ObjectInputStream:close	()V
    //   33: ldc 9
    //   35: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_2
    //   39: areturn
    //   40: astore_0
    //   41: ldc 34
    //   43: new 36	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 38
    //   49: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   56: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: goto -32 -> 33
    //   68: astore_2
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: astore_0
    //   73: ldc 34
    //   75: new 36	java/lang/StringBuilder
    //   78: dup
    //   79: ldc 60
    //   81: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_2
    //   85: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_3
    //   98: astore_2
    //   99: aload_1
    //   100: ifnull -67 -> 33
    //   103: aload_1
    //   104: invokevirtual 29	java/io/ObjectInputStream:close	()V
    //   107: aload_3
    //   108: astore_2
    //   109: goto -76 -> 33
    //   112: astore_0
    //   113: ldc 34
    //   115: new 36	java/lang/StringBuilder
    //   118: dup
    //   119: ldc 38
    //   121: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_0
    //   125: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_3
    //   138: astore_2
    //   139: goto -106 -> 33
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 29	java/io/ObjectInputStream:close	()V
    //   153: ldc 9
    //   155: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_1
    //   159: athrow
    //   160: astore_0
    //   161: ldc 34
    //   163: new 36	java/lang/StringBuilder
    //   166: dup
    //   167: ldc 38
    //   169: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -32 -> 153
    //   188: astore_1
    //   189: goto -44 -> 145
    //   192: astore_2
    //   193: goto -122 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramInputStream	java.io.InputStream
    //   21	83	1	localObjectInputStream	java.io.ObjectInputStream
    //   142	17	1	localObject1	Object
    //   188	1	1	localObject2	Object
    //   8	31	2	localObject3	Object
    //   68	17	2	localException1	java.lang.Exception
    //   98	41	2	localObject4	Object
    //   192	1	2	localException2	java.lang.Exception
    //   1	137	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   29	33	40	java/lang/Exception
    //   13	22	68	java/lang/Exception
    //   103	107	112	java/lang/Exception
    //   13	22	142	finally
    //   149	153	160	java/lang/Exception
    //   24	29	188	finally
    //   73	97	188	finally
    //   24	29	192	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aq.b
 * JD-Core Version:    0.7.0.1
 */