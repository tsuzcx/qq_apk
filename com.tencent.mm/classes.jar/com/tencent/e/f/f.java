package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;

public final class f
{
  /* Error */
  public static java.lang.String X(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 7
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 15
    //   7: astore_2
    //   8: new 17	java/io/BufferedReader
    //   11: dup
    //   12: new 19	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 23	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   20: invokespecial 26	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 30	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnull +14 -> 44
    //   33: aload_1
    //   34: invokestatic 34	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   37: ldc 7
    //   39: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: areturn
    //   44: aload_1
    //   45: invokestatic 34	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   48: ldc 7
    //   50: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: areturn
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_2
    //   59: astore_0
    //   60: aload_1
    //   61: ifnull -13 -> 48
    //   64: aload_1
    //   65: invokestatic 34	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   68: aload_2
    //   69: astore_0
    //   70: goto -22 -> 48
    //   73: astore_0
    //   74: goto -16 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramFile	java.io.File
    //   23	42	1	localBufferedReader	java.io.BufferedReader
    //   7	62	2	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   8	24	55	finally
    //   24	29	73	finally
  }
  
  /* Error */
  public static byte[] Y(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 45	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 47
    //   12: invokespecial 50	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 54	java/io/RandomAccessFile:length	()J
    //   20: lstore_2
    //   21: lload_2
    //   22: l2i
    //   23: istore_1
    //   24: iload_1
    //   25: i2l
    //   26: lload_2
    //   27: lcmp
    //   28: ifeq +41 -> 69
    //   31: new 42	java/io/IOException
    //   34: dup
    //   35: ldc 15
    //   37: invokespecial 57	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   40: astore 4
    //   42: ldc 43
    //   44: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload 4
    //   49: athrow
    //   50: astore 4
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 61	java/io/RandomAccessFile:close	()V
    //   60: ldc 43
    //   62: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: iconst_0
    //   66: newarray byte
    //   68: areturn
    //   69: iload_1
    //   70: newarray byte
    //   72: astore 4
    //   74: aload_0
    //   75: aload 4
    //   77: invokevirtual 65	java/io/RandomAccessFile:readFully	([B)V
    //   80: aload_0
    //   81: invokevirtual 61	java/io/RandomAccessFile:close	()V
    //   84: ldc 43
    //   86: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload 4
    //   91: areturn
    //   92: astore_0
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 61	java/io/RandomAccessFile:close	()V
    //   101: ldc 43
    //   103: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_0
    //   107: athrow
    //   108: astore_0
    //   109: goto -25 -> 84
    //   112: astore_0
    //   113: goto -53 -> 60
    //   116: astore_0
    //   117: goto -16 -> 101
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -71 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramFile	java.io.File
    //   23	47	1	i	int
    //   20	7	2	l	long
    //   40	8	4	localIOException	java.io.IOException
    //   50	1	4	localObject	Object
    //   72	18	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	21	50	finally
    //   31	50	50	finally
    //   69	80	50	finally
    //   80	84	108	java/io/IOException
    //   56	60	112	java/io/IOException
    //   97	101	116	java/io/IOException
    //   5	16	120	finally
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(138478);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally
    {
      AppMethodBeat.o(138478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.f.f
 * JD-Core Version:    0.7.0.1
 */