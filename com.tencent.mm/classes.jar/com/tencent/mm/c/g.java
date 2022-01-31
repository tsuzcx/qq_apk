package com.tencent.mm.c;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g
{
  /* Error */
  public static String a(File paramFile, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 16	java/io/File:exists	()Z
    //   4: ifeq +7 -> 11
    //   7: iload_1
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 18	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 22	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: aload_0
    //   23: iload_1
    //   24: aload_2
    //   25: invokestatic 25	com/tencent/mm/c/g:a	(Ljava/io/InputStream;I[B)Ljava/lang/String;
    //   28: astore_2
    //   29: aload_0
    //   30: invokevirtual 29	java/io/FileInputStream:close	()V
    //   33: aload_0
    //   34: invokevirtual 29	java/io/FileInputStream:close	()V
    //   37: aload_2
    //   38: areturn
    //   39: astore_0
    //   40: aload_2
    //   41: areturn
    //   42: astore_0
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 29	java/io/FileInputStream:close	()V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull +7 -> 66
    //   62: aload_0
    //   63: invokevirtual 29	java/io/FileInputStream:close	()V
    //   66: aload_2
    //   67: athrow
    //   68: astore_0
    //   69: goto -16 -> 53
    //   72: astore_0
    //   73: goto -7 -> 66
    //   76: astore_2
    //   77: goto -19 -> 58
    //   80: astore_2
    //   81: goto -36 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramFile	File
    //   0	84	1	paramInt	int
    //   0	84	2	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	37	39	java/io/IOException
    //   13	22	42	java/lang/Exception
    //   13	22	55	finally
    //   49	53	68	java/io/IOException
    //   62	66	72	java/io/IOException
    //   22	33	76	finally
    //   22	33	80	java/lang/Exception
  }
  
  private static String a(InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte)
  {
    int j = 0;
    if (paramInt <= 0) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramInputStream.skip(0L) < 0L) {
          continue;
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
            return localStringBuilder.toString();
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
      catch (Exception paramInputStream) {}
    }
  }
  
  private static String b(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    if (paramInt <= 0) {
      return null;
    }
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
      }
      for (;;)
      {
        if (paramInt >= paramInputStream.length)
        {
          return localStringBuilder.toString();
          localMessageDigest.update(arrayOfByte, 0, paramInt);
          break;
        }
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      return null;
    }
    catch (Exception paramInputStream) {}
  }
  
  public static String bQ(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return m(paramString);
  }
  
  /* Error */
  private static String m(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 96
    //   3: lstore_1
    //   4: aload_0
    //   5: invokevirtual 16	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 18	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 22	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_3
    //   22: ldc2_w 96
    //   25: aload_0
    //   26: invokevirtual 101	java/io/File:length	()J
    //   29: lcmp
    //   30: ifgt +20 -> 50
    //   33: aload_3
    //   34: lload_1
    //   35: l2i
    //   36: invokestatic 103	com/tencent/mm/c/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_3
    //   41: invokevirtual 29	java/io/FileInputStream:close	()V
    //   44: aload_3
    //   45: invokevirtual 29	java/io/FileInputStream:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: aload_0
    //   51: invokevirtual 101	java/io/File:length	()J
    //   54: lstore_1
    //   55: goto -22 -> 33
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull -51 -> 11
    //   65: aload_0
    //   66: invokevirtual 29	java/io/FileInputStream:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 29	java/io/FileInputStream:close	()V
    //   85: aload_0
    //   86: athrow
    //   87: astore_3
    //   88: goto -40 -> 48
    //   91: astore_3
    //   92: goto -7 -> 85
    //   95: astore_0
    //   96: goto -19 -> 77
    //   99: astore_0
    //   100: aload_3
    //   101: astore_0
    //   102: goto -41 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   3	52	1	l	long
    //   21	61	3	localFileInputStream	java.io.FileInputStream
    //   87	1	3	localIOException1	java.io.IOException
    //   91	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   13	22	58	java/lang/Exception
    //   65	69	71	java/io/IOException
    //   13	22	74	finally
    //   44	48	87	java/io/IOException
    //   81	85	91	java/io/IOException
    //   22	33	95	finally
    //   33	44	95	finally
    //   50	55	95	finally
    //   22	33	99	java/lang/Exception
    //   33	44	99	java/lang/Exception
    //   50	55	99	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.c.g
 * JD-Core Version:    0.7.0.1
 */