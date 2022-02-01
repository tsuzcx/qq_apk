package com.tencent.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;

public final class e
{
  /* Error */
  public static byte[] T(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 19	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 21
    //   12: invokespecial 25	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: astore_0
    //   20: aload 4
    //   22: invokevirtual 29	java/io/RandomAccessFile:length	()J
    //   25: lstore_2
    //   26: lload_2
    //   27: l2i
    //   28: istore_1
    //   29: iload_1
    //   30: i2l
    //   31: lload_2
    //   32: lcmp
    //   33: ifeq +51 -> 84
    //   36: aload 4
    //   38: astore_0
    //   39: new 10	java/io/IOException
    //   42: dup
    //   43: ldc 31
    //   45: invokespecial 34	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: astore 5
    //   50: aload 4
    //   52: astore_0
    //   53: ldc 11
    //   55: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload 4
    //   60: astore_0
    //   61: aload 5
    //   63: athrow
    //   64: astore_0
    //   65: aload 4
    //   67: ifnull +8 -> 75
    //   70: aload 4
    //   72: invokevirtual 41	java/io/RandomAccessFile:close	()V
    //   75: ldc 11
    //   77: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: newarray byte
    //   83: areturn
    //   84: aload 4
    //   86: astore_0
    //   87: iload_1
    //   88: newarray byte
    //   90: astore 5
    //   92: aload 4
    //   94: astore_0
    //   95: aload 4
    //   97: aload 5
    //   99: invokevirtual 45	java/io/RandomAccessFile:readFully	([B)V
    //   102: aload 4
    //   104: invokevirtual 41	java/io/RandomAccessFile:close	()V
    //   107: ldc 11
    //   109: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload 5
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: astore 4
    //   119: aload 4
    //   121: ifnull +8 -> 129
    //   124: aload 4
    //   126: invokevirtual 41	java/io/RandomAccessFile:close	()V
    //   129: ldc 11
    //   131: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: goto -30 -> 107
    //   140: astore_0
    //   141: goto -66 -> 75
    //   144: astore 4
    //   146: goto -17 -> 129
    //   149: astore 4
    //   151: aload_0
    //   152: astore 5
    //   154: aload 4
    //   156: astore_0
    //   157: aload 5
    //   159: astore 4
    //   161: goto -42 -> 119
    //   164: astore_0
    //   165: aconst_null
    //   166: astore 4
    //   168: goto -103 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramFile	java.io.File
    //   28	60	1	i	int
    //   25	7	2	l	long
    //   15	110	4	localRandomAccessFile	java.io.RandomAccessFile
    //   144	1	4	localIOException	java.io.IOException
    //   149	6	4	localObject1	Object
    //   159	8	4	localObject2	Object
    //   48	110	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	64	java/lang/Throwable
    //   39	50	64	java/lang/Throwable
    //   53	58	64	java/lang/Throwable
    //   61	64	64	java/lang/Throwable
    //   87	92	64	java/lang/Throwable
    //   95	102	64	java/lang/Throwable
    //   5	17	115	finally
    //   102	107	136	java/io/IOException
    //   70	75	140	java/io/IOException
    //   124	129	144	java/io/IOException
    //   20	26	149	finally
    //   39	50	149	finally
    //   53	58	149	finally
    //   61	64	149	finally
    //   87	92	149	finally
    //   95	102	149	finally
    //   5	17	164	java/lang/Throwable
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(207738);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(207738);
      return;
    }
    catch (Throwable paramCloseable)
    {
      AppMethodBeat.o(207738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.c.e
 * JD-Core Version:    0.7.0.1
 */