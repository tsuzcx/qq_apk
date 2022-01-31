package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g
{
  /* Error */
  public static String a(File paramFile, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 23	java/io/File:exists	()Z
    //   9: ifeq +7 -> 16
    //   12: iload_1
    //   13: ifgt +10 -> 23
    //   16: ldc 11
    //   18: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 28	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 32	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: aload_0
    //   33: iload_1
    //   34: aload_2
    //   35: invokestatic 35	com/tencent/mm/c/g:a	(Ljava/io/InputStream;I[B)Ljava/lang/String;
    //   38: astore_2
    //   39: aload_0
    //   40: invokevirtual 39	java/io/FileInputStream:close	()V
    //   43: aload_0
    //   44: invokevirtual 39	java/io/FileInputStream:close	()V
    //   47: ldc 11
    //   49: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_2
    //   53: areturn
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_0
    //   58: ifnull +7 -> 65
    //   61: aload_0
    //   62: invokevirtual 39	java/io/FileInputStream:close	()V
    //   65: ldc 11
    //   67: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: ifnull +7 -> 83
    //   79: aload_0
    //   80: invokevirtual 39	java/io/FileInputStream:close	()V
    //   83: ldc 11
    //   85: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_2
    //   89: athrow
    //   90: astore_0
    //   91: goto -44 -> 47
    //   94: astore_0
    //   95: goto -30 -> 65
    //   98: astore_0
    //   99: goto -16 -> 83
    //   102: astore_2
    //   103: goto -28 -> 75
    //   106: astore_2
    //   107: goto -50 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramFile	File
    //   0	110	1	paramInt	int
    //   0	110	2	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	32	54	java/lang/Exception
    //   23	32	72	finally
    //   43	47	90	java/io/IOException
    //   61	65	94	java/io/IOException
    //   79	83	98	java/io/IOException
    //   32	43	102	finally
    //   32	43	106	java/lang/Exception
  }
  
  private static String a(InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte)
  {
    int j = 0;
    AppMethodBeat.i(125688);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(125688);
      return null;
    }
    try
    {
      long l = paramInputStream.skip(0L);
      if (l < 0L)
      {
        AppMethodBeat.o(125688);
        return null;
      }
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[102400];
      int i = 0;
      int k = paramInputStream.read(arrayOfByte);
      if ((k == -1) || (i >= paramInt))
      {
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
          localMessageDigest.update(paramArrayOfByte);
        }
        paramInputStream = localMessageDigest.digest();
        paramInt = j;
      }
      for (;;)
      {
        if (paramInt >= paramInputStream.length)
        {
          paramInputStream = localStringBuilder.toString();
          AppMethodBeat.o(125688);
          return paramInputStream;
          if (i + k <= paramInt)
          {
            localMessageDigest.update(arrayOfByte, 0, k);
            i += k;
            break;
          }
          localMessageDigest.update(arrayOfByte, 0, paramInt - i);
          i = paramInt;
          break;
        }
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      return null;
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(125688);
    }
  }
  
  private static String b(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(125689);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(125689);
      return null;
    }
    for (;;)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        StringBuilder localStringBuilder = new StringBuilder(32);
        byte[] arrayOfByte = new byte[paramInt];
        paramInt = paramInputStream.read(arrayOfByte);
        if (paramInt == -1)
        {
          paramInputStream = localMessageDigest.digest();
          paramInt = i;
          if (paramInt >= paramInputStream.length)
          {
            paramInputStream = localStringBuilder.toString();
            AppMethodBeat.o(125689);
            return paramInputStream;
          }
        }
        else
        {
          localMessageDigest.update(arrayOfByte, 0, paramInt);
          continue;
        }
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
      }
      catch (Exception paramInputStream)
      {
        AppMethodBeat.o(125689);
        return null;
      }
      paramInt += 1;
    }
  }
  
  public static String getMD5(String paramString)
  {
    AppMethodBeat.i(125690);
    if (paramString == null)
    {
      AppMethodBeat.o(125690);
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = r(paramString);
      AppMethodBeat.o(125690);
      return paramString;
    }
    AppMethodBeat.o(125690);
    return null;
  }
  
  /* Error */
  private static String r(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 108
    //   3: lstore_1
    //   4: ldc 110
    //   6: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 23	java/io/File:exists	()Z
    //   13: ifne +10 -> 23
    //   16: ldc 110
    //   18: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 28	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 32	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: ldc2_w 108
    //   35: aload_0
    //   36: invokevirtual 114	java/io/File:length	()J
    //   39: lcmp
    //   40: ifgt +25 -> 65
    //   43: aload_3
    //   44: lload_1
    //   45: l2i
    //   46: invokestatic 116	com/tencent/mm/c/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_3
    //   51: invokevirtual 39	java/io/FileInputStream:close	()V
    //   54: aload_3
    //   55: invokevirtual 39	java/io/FileInputStream:close	()V
    //   58: ldc 110
    //   60: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: aload_0
    //   66: invokevirtual 114	java/io/File:length	()J
    //   69: lstore_1
    //   70: goto -27 -> 43
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 39	java/io/FileInputStream:close	()V
    //   84: ldc 110
    //   86: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 39	java/io/FileInputStream:close	()V
    //   102: ldc 110
    //   104: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: athrow
    //   109: astore_3
    //   110: goto -52 -> 58
    //   113: astore_0
    //   114: goto -30 -> 84
    //   117: astore_3
    //   118: goto -16 -> 102
    //   121: astore_0
    //   122: goto -28 -> 94
    //   125: astore_0
    //   126: aload_3
    //   127: astore_0
    //   128: goto -52 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	File
    //   3	67	1	l	long
    //   31	68	3	localFileInputStream	java.io.FileInputStream
    //   109	1	3	localIOException1	java.io.IOException
    //   117	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   23	32	73	java/lang/Exception
    //   23	32	91	finally
    //   54	58	109	java/io/IOException
    //   80	84	113	java/io/IOException
    //   98	102	117	java/io/IOException
    //   32	43	121	finally
    //   43	54	121	finally
    //   65	70	121	finally
    //   32	43	125	java/lang/Exception
    //   43	54	125	java/lang/Exception
    //   65	70	125	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.c.g
 * JD-Core Version:    0.7.0.1
 */