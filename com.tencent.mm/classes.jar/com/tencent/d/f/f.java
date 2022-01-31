package com.tencent.d.f;

import java.io.Closeable;

public final class f
{
  /* Error */
  public static java.lang.String V(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 10
    //   2: astore_1
    //   3: aconst_null
    //   4: astore_2
    //   5: new 12	java/io/BufferedReader
    //   8: dup
    //   9: new 14	java/io/FileReader
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 18	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   17: invokespecial 21	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 25	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +9 -> 38
    //   32: aload_0
    //   33: invokestatic 29	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   36: aload_1
    //   37: areturn
    //   38: aload_0
    //   39: invokestatic 29	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   42: aload_1
    //   43: areturn
    //   44: astore_0
    //   45: aconst_null
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull -12 -> 36
    //   51: aload_0
    //   52: invokestatic 29	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   55: ldc 10
    //   57: areturn
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokestatic 29	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   69: aload_0
    //   70: athrow
    //   71: astore_2
    //   72: aload_0
    //   73: astore_1
    //   74: aload_2
    //   75: astore_0
    //   76: goto -15 -> 61
    //   79: astore_2
    //   80: goto -33 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramFile	java.io.File
    //   2	72	1	localObject1	Object
    //   4	56	2	str	java.lang.String
    //   71	4	2	localObject2	Object
    //   79	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	21	44	java/lang/Throwable
    //   5	21	58	finally
    //   21	26	71	finally
    //   21	26	79	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] W(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 36	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 38
    //   7: invokespecial 41	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: astore_0
    //   15: aload 4
    //   17: invokevirtual 45	java/io/RandomAccessFile:length	()J
    //   20: lstore_2
    //   21: lload_2
    //   22: l2i
    //   23: istore_1
    //   24: iload_1
    //   25: i2l
    //   26: lload_2
    //   27: lcmp
    //   28: ifeq +38 -> 66
    //   31: aload 4
    //   33: astore_0
    //   34: new 34	java/io/IOException
    //   37: dup
    //   38: ldc 10
    //   40: invokespecial 48	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: astore_0
    //   45: aload 4
    //   47: astore_0
    //   48: iconst_0
    //   49: newarray byte
    //   51: astore 5
    //   53: aload 4
    //   55: ifnull +8 -> 63
    //   58: aload 4
    //   60: invokevirtual 52	java/io/RandomAccessFile:close	()V
    //   63: aload 5
    //   65: areturn
    //   66: aload 4
    //   68: astore_0
    //   69: iload_1
    //   70: newarray byte
    //   72: astore 5
    //   74: aload 4
    //   76: astore_0
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 56	java/io/RandomAccessFile:readFully	([B)V
    //   84: aload 4
    //   86: invokevirtual 52	java/io/RandomAccessFile:close	()V
    //   89: aload 5
    //   91: areturn
    //   92: astore_0
    //   93: aload 5
    //   95: areturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore 4
    //   100: aload 4
    //   102: ifnull +8 -> 110
    //   105: aload 4
    //   107: invokevirtual 52	java/io/RandomAccessFile:close	()V
    //   110: aload_0
    //   111: athrow
    //   112: astore_0
    //   113: aload 5
    //   115: areturn
    //   116: astore 4
    //   118: goto -8 -> 110
    //   121: astore 4
    //   123: aload_0
    //   124: astore 5
    //   126: aload 4
    //   128: astore_0
    //   129: aload 5
    //   131: astore 4
    //   133: goto -33 -> 100
    //   136: astore_0
    //   137: aconst_null
    //   138: astore 4
    //   140: goto -95 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramFile	java.io.File
    //   23	47	1	i	int
    //   20	7	2	l	long
    //   10	96	4	localRandomAccessFile	java.io.RandomAccessFile
    //   116	1	4	localIOException	java.io.IOException
    //   121	6	4	localObject1	Object
    //   131	8	4	localObject2	Object
    //   51	79	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	44	java/lang/Throwable
    //   34	44	44	java/lang/Throwable
    //   69	74	44	java/lang/Throwable
    //   77	84	44	java/lang/Throwable
    //   84	89	92	java/io/IOException
    //   0	12	96	finally
    //   58	63	112	java/io/IOException
    //   105	110	116	java/io/IOException
    //   15	21	121	finally
    //   34	44	121	finally
    //   48	53	121	finally
    //   69	74	121	finally
    //   77	84	121	finally
    //   0	12	136	java/lang/Throwable
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.f
 * JD-Core Version:    0.7.0.1
 */