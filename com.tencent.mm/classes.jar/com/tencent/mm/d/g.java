package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g
{
  /* Error */
  private static String A(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 11
    //   3: lstore_1
    //   4: sipush 951
    //   7: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 24	java/io/File:exists	()Z
    //   14: ifne +11 -> 25
    //   17: sipush 951
    //   20: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: new 29	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_3
    //   34: ldc2_w 11
    //   37: aload_0
    //   38: invokevirtual 37	java/io/File:length	()J
    //   41: lcmp
    //   42: ifgt +26 -> 68
    //   45: aload_3
    //   46: lload_1
    //   47: l2i
    //   48: invokestatic 41	com/tencent/mm/d/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   51: astore_0
    //   52: aload_3
    //   53: invokevirtual 45	java/io/FileInputStream:close	()V
    //   56: aload_3
    //   57: invokevirtual 45	java/io/FileInputStream:close	()V
    //   60: sipush 951
    //   63: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: aload_0
    //   69: invokevirtual 37	java/io/File:length	()J
    //   72: lstore_1
    //   73: goto -28 -> 45
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 45	java/io/FileInputStream:close	()V
    //   87: sipush 951
    //   90: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 45	java/io/FileInputStream:close	()V
    //   106: sipush 951
    //   109: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_0
    //   113: athrow
    //   114: astore_3
    //   115: goto -55 -> 60
    //   118: astore_0
    //   119: goto -32 -> 87
    //   122: astore_3
    //   123: goto -17 -> 106
    //   126: astore_0
    //   127: goto -29 -> 98
    //   130: astore_0
    //   131: aload_3
    //   132: astore_0
    //   133: goto -54 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramFile	File
    //   3	70	1	l	long
    //   33	70	3	localFileInputStream	java.io.FileInputStream
    //   114	1	3	localIOException1	java.io.IOException
    //   122	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   25	34	76	java/lang/Exception
    //   25	34	95	finally
    //   56	60	114	java/io/IOException
    //   83	87	118	java/io/IOException
    //   102	106	122	java/io/IOException
    //   34	45	126	finally
    //   45	56	126	finally
    //   68	73	126	finally
    //   34	45	130	java/lang/Exception
    //   45	56	130	java/lang/Exception
    //   68	73	130	java/lang/Exception
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 952
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 24	java/io/File:exists	()Z
    //   10: ifeq +7 -> 17
    //   13: iload_1
    //   14: ifgt +11 -> 25
    //   17: sipush 952
    //   20: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: new 29	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_0
    //   34: aload_0
    //   35: iload_1
    //   36: aload_2
    //   37: invokestatic 51	com/tencent/mm/d/g:a	(Ljava/io/InputStream;I[B)Ljava/lang/String;
    //   40: astore_2
    //   41: aload_0
    //   42: invokevirtual 45	java/io/FileInputStream:close	()V
    //   45: aload_0
    //   46: invokevirtual 45	java/io/FileInputStream:close	()V
    //   49: sipush 952
    //   52: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_2
    //   56: areturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_0
    //   60: aload_0
    //   61: ifnull +7 -> 68
    //   64: aload_0
    //   65: invokevirtual 45	java/io/FileInputStream:close	()V
    //   68: sipush 952
    //   71: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 45	java/io/FileInputStream:close	()V
    //   87: sipush 952
    //   90: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_0
    //   96: goto -47 -> 49
    //   99: astore_0
    //   100: goto -32 -> 68
    //   103: astore_0
    //   104: goto -17 -> 87
    //   107: astore_2
    //   108: goto -29 -> 79
    //   111: astore_2
    //   112: goto -52 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramFile	File
    //   0	115	1	paramInt	int
    //   0	115	2	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	34	57	java/lang/Exception
    //   25	34	76	finally
    //   45	49	95	java/io/IOException
    //   64	68	99	java/io/IOException
    //   83	87	103	java/io/IOException
    //   34	45	107	finally
    //   34	45	111	java/lang/Exception
  }
  
  private static String a(InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte)
  {
    int j = 0;
    AppMethodBeat.i(948);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(948);
      return null;
    }
    try
    {
      long l = paramInputStream.skip(0L);
      if (l < 0L)
      {
        AppMethodBeat.o(948);
        return null;
      }
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[102400];
      int i = 0;
      for (;;)
      {
        int k = paramInputStream.read(arrayOfByte);
        if ((k == -1) || (i >= paramInt)) {
          break;
        }
        if (i + k <= paramInt)
        {
          localMessageDigest.update(arrayOfByte, 0, k);
          i += k;
        }
        else
        {
          localMessageDigest.update(arrayOfByte, 0, paramInt - i);
          i = paramInt;
        }
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localMessageDigest.update(paramArrayOfByte);
      }
      paramInputStream = localMessageDigest.digest();
      paramInt = j;
      while (paramInt < paramInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      paramInputStream = localStringBuilder.toString();
      AppMethodBeat.o(948);
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(948);
    }
    return null;
  }
  
  private static String e(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(949);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(949);
      return null;
    }
    StringBuilder localStringBuilder;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt];
      for (;;)
      {
        paramInt = paramInputStream.read(arrayOfByte);
        if (paramInt == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, paramInt);
      }
      paramInputStream = localMessageDigest.digest();
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(949);
      return null;
    }
    paramInt = i;
    while (paramInt < paramInputStream.length)
    {
      localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
      paramInt += 1;
    }
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(949);
    return paramInputStream;
  }
  
  public static String getMD5(String paramString)
  {
    AppMethodBeat.i(950);
    if (paramString == null)
    {
      AppMethodBeat.o(950);
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = A(paramString);
      AppMethodBeat.o(950);
      return paramString;
    }
    AppMethodBeat.o(950);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.d.g
 * JD-Core Version:    0.7.0.1
 */