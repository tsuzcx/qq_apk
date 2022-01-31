package com.tencent.mm.an;

public final class b
{
  /* Error */
  public static Object t(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 9
    //   4: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 17	java/io/ObjectInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 21	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 25	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_0
    //   25: aload_1
    //   26: invokevirtual 29	java/io/ObjectInputStream:close	()V
    //   29: ldc 9
    //   31: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: areturn
    //   36: astore_1
    //   37: ldc 34
    //   39: new 36	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 38
    //   45: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: aload_1
    //   49: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   52: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: goto -32 -> 29
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_1
    //   67: aload_1
    //   68: astore_0
    //   69: ldc 34
    //   71: new 36	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 60
    //   77: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_2
    //   81: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_3
    //   94: astore_0
    //   95: aload_1
    //   96: ifnull -67 -> 29
    //   99: aload_1
    //   100: invokevirtual 29	java/io/ObjectInputStream:close	()V
    //   103: aload_3
    //   104: astore_0
    //   105: goto -76 -> 29
    //   108: astore_0
    //   109: ldc 34
    //   111: new 36	java/lang/StringBuilder
    //   114: dup
    //   115: ldc 38
    //   117: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_0
    //   121: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_3
    //   134: astore_0
    //   135: goto -106 -> 29
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 29	java/io/ObjectInputStream:close	()V
    //   149: ldc 9
    //   151: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_1
    //   155: athrow
    //   156: astore_0
    //   157: ldc 34
    //   159: new 36	java/lang/StringBuilder
    //   162: dup
    //   163: ldc 38
    //   165: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload_0
    //   169: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: goto -32 -> 149
    //   184: astore_1
    //   185: goto -44 -> 141
    //   188: astore_2
    //   189: goto -122 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramInputStream	java.io.InputStream
    //   15	11	1	localObjectInputStream	java.io.ObjectInputStream
    //   36	13	1	localException1	java.lang.Exception
    //   66	34	1	localObject1	Object
    //   138	17	1	localObject2	Object
    //   184	1	1	localObject3	Object
    //   22	2	2	localObject4	Object
    //   64	17	2	localException2	java.lang.Exception
    //   188	1	2	localException3	java.lang.Exception
    //   1	133	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   25	29	36	java/lang/Exception
    //   7	16	64	java/lang/Exception
    //   99	103	108	java/lang/Exception
    //   7	16	138	finally
    //   145	149	156	java/lang/Exception
    //   18	23	184	finally
    //   69	93	184	finally
    //   18	23	188	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.an.b
 * JD-Core Version:    0.7.0.1
 */