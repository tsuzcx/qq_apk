package com.tencent.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;

public final class e
{
  /* Error */
  public static byte[] Y(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 17	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 19
    //   12: invokespecial 23	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 27	java/io/RandomAccessFile:length	()J
    //   20: lstore_2
    //   21: lload_2
    //   22: l2i
    //   23: istore_1
    //   24: iload_1
    //   25: i2l
    //   26: lload_2
    //   27: lcmp
    //   28: ifeq +41 -> 69
    //   31: new 8	java/io/IOException
    //   34: dup
    //   35: ldc 29
    //   37: invokespecial 32	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   40: astore 4
    //   42: ldc 9
    //   44: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload 4
    //   49: athrow
    //   50: astore 4
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 39	java/io/RandomAccessFile:close	()V
    //   60: ldc 9
    //   62: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: iconst_0
    //   66: newarray byte
    //   68: areturn
    //   69: iload_1
    //   70: newarray byte
    //   72: astore 4
    //   74: aload_0
    //   75: aload 4
    //   77: invokevirtual 43	java/io/RandomAccessFile:readFully	([B)V
    //   80: aload_0
    //   81: invokevirtual 39	java/io/RandomAccessFile:close	()V
    //   84: ldc 9
    //   86: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload 4
    //   91: areturn
    //   92: astore_0
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 39	java/io/RandomAccessFile:close	()V
    //   101: ldc 9
    //   103: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(212030);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally
    {
      AppMethodBeat.o(212030);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.c.e
 * JD-Core Version:    0.7.0.1
 */