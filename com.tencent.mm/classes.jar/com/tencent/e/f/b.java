package com.tencent.e.f;

public final class b
{
  /* Error */
  public static byte[] co(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 19	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 23	java/io/ByteArrayInputStream:<init>	([B)V
    //   13: astore_0
    //   14: new 25	java/util/zip/InflaterInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 28	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore_2
    //   23: new 30	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 33	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore_3
    //   31: aload_2
    //   32: invokevirtual 37	java/util/zip/InflaterInputStream:read	()I
    //   35: istore_1
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpeq +45 -> 83
    //   41: aload_3
    //   42: iload_1
    //   43: invokevirtual 40	java/io/ByteArrayOutputStream:write	(I)V
    //   46: goto -15 -> 31
    //   49: astore 4
    //   51: ldc 42
    //   53: aload 4
    //   55: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokevirtual 52	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 58	com/tencent/e/f/h:cU	(Ljava/lang/Object;)V
    //   64: aload_0
    //   65: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   68: aload_2
    //   69: invokevirtual 62	java/util/zip/InflaterInputStream:close	()V
    //   72: aload_3
    //   73: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   76: ldc 11
    //   78: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aconst_null
    //   82: areturn
    //   83: aload_3
    //   84: invokevirtual 70	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   87: astore 4
    //   89: aload_0
    //   90: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   93: aload_2
    //   94: invokevirtual 62	java/util/zip/InflaterInputStream:close	()V
    //   97: aload_3
    //   98: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   101: ldc 11
    //   103: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload 4
    //   108: areturn
    //   109: astore 4
    //   111: aload_0
    //   112: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   115: aload_2
    //   116: invokevirtual 62	java/util/zip/InflaterInputStream:close	()V
    //   119: aload_3
    //   120: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   123: ldc 11
    //   125: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload 4
    //   130: athrow
    //   131: astore_0
    //   132: goto -9 -> 123
    //   135: astore_0
    //   136: goto -60 -> 76
    //   139: astore_0
    //   140: goto -39 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramArrayOfByte	byte[]
    //   35	8	1	i	int
    //   22	94	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   30	90	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   49	5	4	localException	java.lang.Exception
    //   87	20	4	arrayOfByte	byte[]
    //   109	20	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	36	49	java/lang/Exception
    //   41	46	49	java/lang/Exception
    //   83	89	49	java/lang/Exception
    //   31	36	109	finally
    //   41	46	109	finally
    //   51	64	109	finally
    //   83	89	109	finally
    //   111	123	131	java/io/IOException
    //   64	76	135	java/io/IOException
    //   89	101	139	java/io/IOException
  }
  
  /* Error */
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 73
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 30	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 33	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_1
    //   13: new 75	java/util/zip/DeflaterOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 78	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 80	java/util/zip/DeflaterOutputStream:write	([B)V
    //   27: aload_2
    //   28: invokevirtual 83	java/util/zip/DeflaterOutputStream:finish	()V
    //   31: aload_1
    //   32: invokevirtual 70	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   40: aload_2
    //   41: invokevirtual 84	java/util/zip/DeflaterOutputStream:close	()V
    //   44: ldc 73
    //   46: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: ldc 86
    //   54: aload_0
    //   55: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokevirtual 52	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 58	com/tencent/e/f/h:cU	(Ljava/lang/Object;)V
    //   64: aload_1
    //   65: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   68: aload_2
    //   69: invokevirtual 84	java/util/zip/DeflaterOutputStream:close	()V
    //   72: ldc 73
    //   74: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aload_1
    //   81: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   84: aload_2
    //   85: invokevirtual 84	java/util/zip/DeflaterOutputStream:close	()V
    //   88: ldc 73
    //   90: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_0
    //   94: athrow
    //   95: astore_1
    //   96: goto -8 -> 88
    //   99: astore_0
    //   100: goto -28 -> 72
    //   103: astore_1
    //   104: goto -60 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramArrayOfByte	byte[]
    //   12	69	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   95	1	1	localIOException1	java.io.IOException
    //   103	1	1	localIOException2	java.io.IOException
    //   21	64	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   22	36	51	java/lang/Exception
    //   22	36	79	finally
    //   52	64	79	finally
    //   80	88	95	java/io/IOException
    //   64	72	99	java/io/IOException
    //   36	44	103	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.f.b
 * JD-Core Version:    0.7.0.1
 */