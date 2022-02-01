package com.tencent.util;

public class SerializeHelper
{
  /* Error */
  public static Object a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: iconst_0
    //   5: invokestatic 21	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   8: astore_0
    //   9: new 23	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 26	java/io/ByteArrayInputStream:<init>	([B)V
    //   17: astore_1
    //   18: new 28	java/io/ObjectInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 31	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_0
    //   27: aload_1
    //   28: astore_3
    //   29: aload_0
    //   30: astore_2
    //   31: aload_0
    //   32: invokevirtual 35	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   35: astore 5
    //   37: aload 5
    //   39: astore_2
    //   40: aload_1
    //   41: invokevirtual 38	java/io/ByteArrayInputStream:close	()V
    //   44: aload_0
    //   45: invokevirtual 39	java/io/ObjectInputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore 5
    //   52: aload_1
    //   53: astore_3
    //   54: aload_0
    //   55: astore_2
    //   56: aload 5
    //   58: invokevirtual 42	java/lang/ClassNotFoundException:printStackTrace	()V
    //   61: aload 4
    //   63: astore_2
    //   64: goto -24 -> 40
    //   67: astore 4
    //   69: aload_1
    //   70: astore_3
    //   71: aload_0
    //   72: astore_2
    //   73: aload 4
    //   75: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   78: aload_1
    //   79: invokevirtual 38	java/io/ByteArrayInputStream:close	()V
    //   82: aload_0
    //   83: invokevirtual 39	java/io/ObjectInputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   100: goto -56 -> 44
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   108: aload_2
    //   109: areturn
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   115: goto -33 -> 82
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_1
    //   124: invokevirtual 38	java/io/ByteArrayInputStream:close	()V
    //   127: aload_2
    //   128: invokevirtual 39	java/io/ObjectInputStream:close	()V
    //   131: aload_0
    //   132: athrow
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   138: goto -11 -> 127
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   146: goto -15 -> 131
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_2
    //   152: goto -29 -> 123
    //   155: astore_0
    //   156: aload_3
    //   157: astore_1
    //   158: goto -35 -> 123
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_1
    //   165: aconst_null
    //   166: astore_0
    //   167: goto -98 -> 69
    //   170: astore 4
    //   172: aconst_null
    //   173: astore_0
    //   174: goto -105 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	java.lang.String
    //   17	62	1	localByteArrayInputStream1	java.io.ByteArrayInputStream
    //   95	2	1	localIOException1	java.io.IOException
    //   110	2	1	localIOException2	java.io.IOException
    //   120	4	1	localObject1	Object
    //   133	2	1	localIOException3	java.io.IOException
    //   141	2	1	localIOException4	java.io.IOException
    //   157	8	1	localObject2	Object
    //   30	122	2	localObject3	Object
    //   28	129	3	localByteArrayInputStream2	java.io.ByteArrayInputStream
    //   1	61	4	localObject4	Object
    //   67	7	4	localIOException5	java.io.IOException
    //   161	1	4	localIOException6	java.io.IOException
    //   170	1	4	localIOException7	java.io.IOException
    //   35	3	5	localObject5	Object
    //   50	7	5	localClassNotFoundException	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   31	37	50	java/lang/ClassNotFoundException
    //   31	37	67	java/io/IOException
    //   56	61	67	java/io/IOException
    //   82	86	88	java/io/IOException
    //   40	44	95	java/io/IOException
    //   44	48	103	java/io/IOException
    //   78	82	110	java/io/IOException
    //   9	18	118	finally
    //   123	127	133	java/io/IOException
    //   127	131	141	java/io/IOException
    //   18	27	149	finally
    //   31	37	155	finally
    //   56	61	155	finally
    //   73	78	155	finally
    //   9	18	161	java/io/IOException
    //   18	27	170	java/io/IOException
  }
  
  /* Error */
  public static java.lang.String a(Object paramObject)
  {
    // Byte code:
    //   0: new 46	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 47	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 49	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 52	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 5
    //   18: aload 5
    //   20: astore_3
    //   21: aload_1
    //   22: astore_2
    //   23: aload 5
    //   25: aload_0
    //   26: invokevirtual 56	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   29: aload 5
    //   31: astore_3
    //   32: aload_1
    //   33: astore_2
    //   34: new 58	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: invokevirtual 62	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: iconst_0
    //   43: invokestatic 66	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   46: invokespecial 69	java/lang/String:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 70	java/io/ByteArrayOutputStream:close	()V
    //   54: aload 5
    //   56: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   59: aload_0
    //   60: areturn
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   66: goto -12 -> 54
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   74: aload_0
    //   75: areturn
    //   76: astore 4
    //   78: aconst_null
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_0
    //   83: astore_3
    //   84: aload_1
    //   85: astore_2
    //   86: aload 4
    //   88: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   91: aload_1
    //   92: invokevirtual 70	java/io/ByteArrayOutputStream:close	()V
    //   95: aload_0
    //   96: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   106: goto -11 -> 95
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 70	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_3
    //   126: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   129: aload_0
    //   130: athrow
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   136: goto -11 -> 125
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   144: goto -15 -> 129
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_3
    //   150: goto -29 -> 121
    //   153: astore_0
    //   154: aload_2
    //   155: astore_1
    //   156: goto -35 -> 121
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_0
    //   163: goto -81 -> 82
    //   166: astore 4
    //   168: aload 5
    //   170: astore_0
    //   171: goto -89 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramObject	Object
    //   7	44	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   61	2	1	localIOException1	java.io.IOException
    //   69	2	1	localIOException2	java.io.IOException
    //   81	11	1	localObject1	Object
    //   101	2	1	localIOException3	java.io.IOException
    //   120	2	1	localObject2	Object
    //   131	2	1	localIOException4	java.io.IOException
    //   139	2	1	localIOException5	java.io.IOException
    //   155	1	1	localObject3	Object
    //   22	133	2	localObject4	Object
    //   20	130	3	localObject5	Object
    //   76	11	4	localIOException6	java.io.IOException
    //   159	1	4	localIOException7	java.io.IOException
    //   166	1	4	localIOException8	java.io.IOException
    //   16	153	5	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	54	61	java/io/IOException
    //   54	59	69	java/io/IOException
    //   0	8	76	java/io/IOException
    //   91	95	101	java/io/IOException
    //   95	99	109	java/io/IOException
    //   0	8	116	finally
    //   121	125	131	java/io/IOException
    //   125	129	139	java/io/IOException
    //   8	18	147	finally
    //   23	29	153	finally
    //   34	50	153	finally
    //   86	91	153	finally
    //   8	18	159	java/io/IOException
    //   23	29	166	java/io/IOException
    //   34	50	166	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.SerializeHelper
 * JD-Core Version:    0.7.0.1
 */