package com.tencent.g.c;

public final class a
{
  /* Error */
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 19	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 23	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_1
    //   13: new 25	java/util/zip/DeflaterOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 28	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 32	java/util/zip/DeflaterOutputStream:write	([B)V
    //   27: aload_2
    //   28: invokevirtual 35	java/util/zip/DeflaterOutputStream:finish	()V
    //   31: aload_1
    //   32: invokevirtual 39	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   40: aload_2
    //   41: invokevirtual 43	java/util/zip/DeflaterOutputStream:close	()V
    //   44: ldc 11
    //   46: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   56: aload_2
    //   57: invokevirtual 43	java/util/zip/DeflaterOutputStream:close	()V
    //   60: ldc 11
    //   62: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 43	java/util/zip/DeflaterOutputStream:close	()V
    //   76: ldc 11
    //   78: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: athrow
    //   83: astore_1
    //   84: goto -8 -> 76
    //   87: astore_0
    //   88: goto -28 -> 60
    //   91: astore_1
    //   92: goto -48 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramArrayOfByte	byte[]
    //   12	57	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   83	1	1	localIOException1	java.io.IOException
    //   91	1	1	localIOException2	java.io.IOException
    //   21	52	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   22	36	51	java/lang/Exception
    //   22	36	67	finally
    //   68	76	83	java/io/IOException
    //   52	60	87	java/io/IOException
    //   36	44	91	java/io/IOException
  }
  
  /* Error */
  public static byte[] dt(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 51	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 53	java/io/ByteArrayInputStream:<init>	([B)V
    //   13: astore_0
    //   14: new 55	java/util/zip/InflaterInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 58	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore_2
    //   23: new 19	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 23	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore_3
    //   31: aload_2
    //   32: invokevirtual 62	java/util/zip/InflaterInputStream:read	()I
    //   35: istore_1
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpeq +32 -> 70
    //   41: aload_3
    //   42: iload_1
    //   43: invokevirtual 64	java/io/ByteArrayOutputStream:write	(I)V
    //   46: goto -15 -> 31
    //   49: astore 4
    //   51: aload_0
    //   52: invokevirtual 65	java/io/ByteArrayInputStream:close	()V
    //   55: aload_2
    //   56: invokevirtual 66	java/util/zip/InflaterInputStream:close	()V
    //   59: aload_3
    //   60: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   63: ldc 49
    //   65: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_3
    //   71: invokevirtual 39	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   74: astore 4
    //   76: aload_0
    //   77: invokevirtual 65	java/io/ByteArrayInputStream:close	()V
    //   80: aload_2
    //   81: invokevirtual 66	java/util/zip/InflaterInputStream:close	()V
    //   84: aload_3
    //   85: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   88: ldc 49
    //   90: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload 4
    //   95: areturn
    //   96: astore 4
    //   98: aload_0
    //   99: invokevirtual 65	java/io/ByteArrayInputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 66	java/util/zip/InflaterInputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   110: ldc 49
    //   112: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload 4
    //   117: athrow
    //   118: astore_0
    //   119: goto -9 -> 110
    //   122: astore_0
    //   123: goto -60 -> 63
    //   126: astore_0
    //   127: goto -39 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramArrayOfByte	byte[]
    //   35	8	1	i	int
    //   22	81	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   30	77	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   49	1	4	localException	java.lang.Exception
    //   74	20	4	arrayOfByte	byte[]
    //   96	20	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	36	49	java/lang/Exception
    //   41	46	49	java/lang/Exception
    //   70	76	49	java/lang/Exception
    //   31	36	96	finally
    //   41	46	96	finally
    //   70	76	96	finally
    //   98	110	118	java/io/IOException
    //   51	63	122	java/io/IOException
    //   76	88	126	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.c.a
 * JD-Core Version:    0.7.0.1
 */