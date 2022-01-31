package com.tencent.mm.am;

public final class b
{
  /* Error */
  public static Object q(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 10	java/io/ObjectInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 14	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: aload_1
    //   14: invokevirtual 18	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_1
    //   21: invokevirtual 22	java/io/ObjectInputStream:close	()V
    //   24: aload_0
    //   25: areturn
    //   26: astore_1
    //   27: ldc 24
    //   29: new 26	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 28
    //   35: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_1
    //   39: invokevirtual 35	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   42: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 48	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: areturn
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: ldc 24
    //   60: new 26	java/lang/StringBuilder
    //   63: dup
    //   64: ldc 50
    //   66: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_2
    //   70: invokevirtual 35	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 48	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_3
    //   83: astore_0
    //   84: aload_1
    //   85: ifnull -61 -> 24
    //   88: aload_1
    //   89: invokevirtual 22	java/io/ObjectInputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: ldc 24
    //   97: new 26	java/lang/StringBuilder
    //   100: dup
    //   101: ldc 28
    //   103: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: invokevirtual 35	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 48	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 22	java/io/ObjectInputStream:close	()V
    //   132: aload_1
    //   133: athrow
    //   134: astore_0
    //   135: ldc 24
    //   137: new 26	java/lang/StringBuilder
    //   140: dup
    //   141: ldc 28
    //   143: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokevirtual 35	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   150: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 48	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: goto -27 -> 132
    //   162: astore_1
    //   163: goto -39 -> 124
    //   166: astore_2
    //   167: goto -111 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramInputStream	java.io.InputStream
    //   10	11	1	localObjectInputStream	java.io.ObjectInputStream
    //   26	13	1	localException1	java.lang.Exception
    //   55	34	1	localObject1	Object
    //   121	12	1	localObject2	Object
    //   162	1	1	localObject3	Object
    //   17	2	2	localObject4	Object
    //   53	17	2	localException2	java.lang.Exception
    //   166	1	2	localException3	java.lang.Exception
    //   1	82	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   20	24	26	java/lang/Exception
    //   2	11	53	java/lang/Exception
    //   88	92	94	java/lang/Exception
    //   2	11	121	finally
    //   128	132	134	java/lang/Exception
    //   13	18	162	finally
    //   58	82	162	finally
    //   13	18	166	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.am.b
 * JD-Core Version:    0.7.0.1
 */