package com.tencent.mm.a;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g
{
  public static final String b(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    if ((paramInputStream == null) || (paramInt <= 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
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
      paramInt = i;
      while (paramInt < paramInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
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
  
  public static String bR(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return n(paramString);
  }
  
  public static String l(InputStream paramInputStream)
  {
    int j = 0;
    if (paramInputStream == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramInputStream.skip(0L) >= 0L)
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          StringBuilder localStringBuilder = new StringBuilder(32);
          byte[] arrayOfByte = new byte[102400];
          int i = 0;
          for (;;)
          {
            int k = paramInputStream.read(arrayOfByte);
            if ((k == -1) || (i >= 256)) {
              break;
            }
            if (i + k <= 256)
            {
              localMessageDigest.update(arrayOfByte, 0, k);
              i += k;
            }
            else
            {
              localMessageDigest.update(arrayOfByte, 0, 256 - i);
              i = 256;
            }
          }
          paramInputStream = localMessageDigest.digest();
          i = j;
          while (i < paramInputStream.length)
          {
            localStringBuilder.append(Integer.toString((paramInputStream[i] & 0xFF) + 256, 16).substring(1));
            i += 1;
          }
          paramInputStream = localStringBuilder.toString();
          return paramInputStream;
        }
      }
      catch (Exception paramInputStream) {}
    }
    return null;
  }
  
  /* Error */
  public static String m(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 85
    //   3: lstore_1
    //   4: aload_0
    //   5: ifnull +10 -> 15
    //   8: aload_0
    //   9: invokevirtual 67	java/io/File:exists	()Z
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 88	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_3
    //   26: ldc2_w 85
    //   29: aload_0
    //   30: invokevirtual 95	java/io/File:length	()J
    //   33: lcmp
    //   34: ifgt +23 -> 57
    //   37: aload_3
    //   38: lload_1
    //   39: l2i
    //   40: invokestatic 97	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   43: astore_0
    //   44: aload_3
    //   45: invokevirtual 101	java/io/FileInputStream:close	()V
    //   48: aload_3
    //   49: invokevirtual 101	java/io/FileInputStream:close	()V
    //   52: aload_0
    //   53: areturn
    //   54: astore_3
    //   55: aload_0
    //   56: areturn
    //   57: aload_0
    //   58: invokevirtual 95	java/io/File:length	()J
    //   61: lstore_1
    //   62: goto -25 -> 37
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_0
    //   69: ifnull +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 101	java/io/FileInputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_3
    //   82: ifnull +7 -> 89
    //   85: aload_3
    //   86: invokevirtual 101	java/io/FileInputStream:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: goto -16 -> 76
    //   95: astore_3
    //   96: goto -7 -> 89
    //   99: astore_0
    //   100: goto -19 -> 81
    //   103: astore_0
    //   104: aload_3
    //   105: astore_0
    //   106: goto -38 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramFile	File
    //   3	59	1	l	long
    //   25	24	3	localFileInputStream	java.io.FileInputStream
    //   54	1	3	localIOException1	java.io.IOException
    //   80	6	3	localObject	Object
    //   95	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   48	52	54	java/io/IOException
    //   17	26	65	java/lang/Exception
    //   17	26	78	finally
    //   72	76	91	java/io/IOException
    //   85	89	95	java/io/IOException
    //   26	37	99	finally
    //   37	48	99	finally
    //   57	62	99	finally
    //   26	37	103	java/lang/Exception
    //   37	48	103	java/lang/Exception
    //   57	62	103	java/lang/Exception
  }
  
  /* Error */
  private static String n(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 67	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 88	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokestatic 103	com/tencent/mm/a/g:l	(Ljava/io/InputStream;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: invokevirtual 101	java/io/FileInputStream:close	()V
    //   27: aload_0
    //   28: invokevirtual 101	java/io/FileInputStream:close	()V
    //   31: aload_1
    //   32: areturn
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull -30 -> 7
    //   40: aload_0
    //   41: invokevirtual 101	java/io/FileInputStream:close	()V
    //   44: aconst_null
    //   45: areturn
    //   46: astore_0
    //   47: aconst_null
    //   48: areturn
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 101	java/io/FileInputStream:close	()V
    //   60: aload_1
    //   61: athrow
    //   62: astore_0
    //   63: goto -32 -> 31
    //   66: astore_0
    //   67: goto -7 -> 60
    //   70: astore_1
    //   71: goto -19 -> 52
    //   74: astore_1
    //   75: goto -39 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramFile	File
    //   22	10	1	str	String
    //   49	12	1	localObject1	Object
    //   70	1	1	localObject2	Object
    //   74	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	18	33	java/lang/Exception
    //   40	44	46	java/io/IOException
    //   9	18	49	finally
    //   27	31	62	java/io/IOException
    //   56	60	66	java/io/IOException
    //   18	27	70	finally
    //   18	27	74	java/lang/Exception
  }
  
  public static final String o(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    for (;;)
    {
      Object localObject;
      int k;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < k)
      {
        int n = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(n >>> 4 & 0xF)];
        localObject[m] = arrayOfChar[(n & 0xF)];
        i += 1;
        j = m + 1;
      }
    }
  }
  
  public static final byte[] p(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.g
 * JD-Core Version:    0.7.0.1
 */