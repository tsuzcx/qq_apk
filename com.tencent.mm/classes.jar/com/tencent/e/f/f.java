package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;

public final class f
{
  /* Error */
  public static java.lang.String ae(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 17
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_1
    //   10: new 19	java/io/BufferedReader
    //   13: dup
    //   14: new 21	java/io/FileReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 25	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   22: invokespecial 28	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 32	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +14 -> 46
    //   35: aload_0
    //   36: invokestatic 36	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   39: ldc 9
    //   41: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: invokestatic 36	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   50: aload_1
    //   51: astore_0
    //   52: ldc 9
    //   54: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_2
    //   63: astore_0
    //   64: aload_1
    //   65: ifnull -13 -> 52
    //   68: aload_1
    //   69: invokestatic 36	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   72: aload_2
    //   73: astore_0
    //   74: goto -22 -> 52
    //   77: astore_0
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokestatic 36	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   86: ldc 9
    //   88: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: athrow
    //   93: astore_2
    //   94: aload_0
    //   95: astore_1
    //   96: aload_2
    //   97: astore_0
    //   98: goto -20 -> 78
    //   101: astore_1
    //   102: aload_0
    //   103: astore_1
    //   104: goto -42 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile	java.io.File
    //   9	87	1	localObject1	Object
    //   101	1	1	localThrowable	Throwable
    //   103	1	1	localFile	java.io.File
    //   7	66	2	str	java.lang.String
    //   93	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	26	59	java/lang/Throwable
    //   10	26	77	finally
    //   26	31	93	finally
    //   26	31	101	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] af(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 45
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 47	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 49
    //   12: invokespecial 52	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: astore_0
    //   20: aload 4
    //   22: invokevirtual 56	java/io/RandomAccessFile:length	()J
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
    //   39: new 44	java/io/IOException
    //   42: dup
    //   43: ldc 17
    //   45: invokespecial 59	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: astore 5
    //   50: aload 4
    //   52: astore_0
    //   53: ldc 45
    //   55: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload 4
    //   60: astore_0
    //   61: aload 5
    //   63: athrow
    //   64: astore_0
    //   65: aload 4
    //   67: ifnull +8 -> 75
    //   70: aload 4
    //   72: invokevirtual 63	java/io/RandomAccessFile:close	()V
    //   75: ldc 45
    //   77: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   99: invokevirtual 67	java/io/RandomAccessFile:readFully	([B)V
    //   102: aload 4
    //   104: invokevirtual 63	java/io/RandomAccessFile:close	()V
    //   107: ldc 45
    //   109: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload 5
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: astore 4
    //   119: aload 4
    //   121: ifnull +8 -> 129
    //   124: aload 4
    //   126: invokevirtual 63	java/io/RandomAccessFile:close	()V
    //   129: ldc 45
    //   131: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(114615);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(114615);
      return;
    }
    catch (Throwable paramCloseable)
    {
      AppMethodBeat.o(114615);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.e.f.f
 * JD-Core Version:    0.7.0.1
 */