package com.tencent.tmassistantbase.a;

public class p
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 10	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 14	java/util/zip/Deflater:<init>	()V
    //   7: astore_2
    //   8: new 16	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: aload_0
    //   13: arraylength
    //   14: invokespecial 19	java/io/ByteArrayOutputStream:<init>	(I)V
    //   17: astore_1
    //   18: aload_2
    //   19: bipush 9
    //   21: invokevirtual 22	java/util/zip/Deflater:setLevel	(I)V
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 26	java/util/zip/Deflater:setInput	([B)V
    //   29: aload_2
    //   30: invokevirtual 29	java/util/zip/Deflater:finish	()V
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_0
    //   39: aload_2
    //   40: invokevirtual 33	java/util/zip/Deflater:finished	()Z
    //   43: ifne +32 -> 75
    //   46: aload_1
    //   47: aload_0
    //   48: iconst_0
    //   49: aload_2
    //   50: aload_0
    //   51: invokevirtual 37	java/util/zip/Deflater:deflate	([B)I
    //   54: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 44	java/util/zip/Deflater:end	()V
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: aload_2
    //   76: invokevirtual 44	java/util/zip/Deflater:end	()V
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   87: aload_1
    //   88: invokevirtual 51	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   91: areturn
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   97: goto -10 -> 87
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   105: goto -32 -> 73
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_1
    //   111: goto -50 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramArrayOfByte	byte[]
    //   17	71	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   100	2	1	localIOException	java.io.IOException
    //   110	1	1	localObject	Object
    //   7	69	2	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   18	39	60	finally
    //   39	57	60	finally
    //   83	87	92	java/io/IOException
    //   69	73	100	java/io/IOException
    //   8	18	108	finally
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 60	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 61	java/util/zip/Inflater:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: new 16	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_0
    //   16: arraylength
    //   17: invokespecial 19	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_2
    //   23: sipush 1024
    //   26: newarray byte
    //   28: astore_3
    //   29: aload_1
    //   30: astore_2
    //   31: aload 4
    //   33: aload_0
    //   34: invokevirtual 62	java/util/zip/Inflater:setInput	([B)V
    //   37: aload_1
    //   38: astore_2
    //   39: aload 4
    //   41: invokevirtual 63	java/util/zip/Inflater:finished	()Z
    //   44: ifne +51 -> 95
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: aload_3
    //   51: iconst_0
    //   52: aload 4
    //   54: aload_3
    //   55: invokevirtual 66	java/util/zip/Inflater:inflate	([B)I
    //   58: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -24 -> 37
    //   64: astore_3
    //   65: aload_1
    //   66: astore_0
    //   67: aload_0
    //   68: astore_2
    //   69: aload_3
    //   70: invokevirtual 67	java/util/zip/DataFormatException:printStackTrace	()V
    //   73: aload 4
    //   75: invokevirtual 68	java/util/zip/Inflater:end	()V
    //   78: aload_0
    //   79: astore_2
    //   80: aload_0
    //   81: ifnull +9 -> 90
    //   84: aload_0
    //   85: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_0
    //   89: astore_2
    //   90: aload_2
    //   91: invokevirtual 51	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: areturn
    //   95: aload 4
    //   97: invokevirtual 68	java/util/zip/Inflater:end	()V
    //   100: aload_1
    //   101: astore_2
    //   102: aload_1
    //   103: ifnull -13 -> 90
    //   106: aload_1
    //   107: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   110: aload_1
    //   111: astore_2
    //   112: goto -22 -> 90
    //   115: astore_0
    //   116: aload_1
    //   117: astore_2
    //   118: goto -28 -> 90
    //   121: astore_0
    //   122: aload 4
    //   124: invokevirtual 68	java/util/zip/Inflater:end	()V
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: astore_2
    //   140: goto -50 -> 90
    //   143: astore_1
    //   144: goto -9 -> 135
    //   147: astore_0
    //   148: goto -26 -> 122
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_0
    //   154: goto -87 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramArrayOfByte	byte[]
    //   20	97	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   137	1	1	localIOException1	java.io.IOException
    //   143	1	1	localIOException2	java.io.IOException
    //   10	130	2	localObject	Object
    //   28	27	3	arrayOfByte	byte[]
    //   64	6	3	localDataFormatException1	java.util.zip.DataFormatException
    //   151	1	3	localDataFormatException2	java.util.zip.DataFormatException
    //   7	116	4	localInflater	java.util.zip.Inflater
    // Exception table:
    //   from	to	target	type
    //   23	29	64	java/util/zip/DataFormatException
    //   31	37	64	java/util/zip/DataFormatException
    //   39	47	64	java/util/zip/DataFormatException
    //   49	61	64	java/util/zip/DataFormatException
    //   106	110	115	java/io/IOException
    //   11	21	121	finally
    //   84	88	137	java/io/IOException
    //   131	135	143	java/io/IOException
    //   23	29	147	finally
    //   31	37	147	finally
    //   39	47	147	finally
    //   49	61	147	finally
    //   69	73	147	finally
    //   11	21	151	java/util/zip/DataFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.a.p
 * JD-Core Version:    0.7.0.1
 */