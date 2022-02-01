package com.tencent.mm.b;

import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g
{
  public static final byte[] U(byte[] paramArrayOfByte)
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
  
  /* Error */
  public static String a(u paramu, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: iload_1
    //   5: ifle +10 -> 15
    //   8: aload_0
    //   9: invokevirtual 35	com/tencent/mm/vfs/u:jKS	()Z
    //   12: ifne +7 -> 19
    //   15: aconst_null
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    //   19: aload_0
    //   20: invokestatic 41	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   23: astore 4
    //   25: iload_1
    //   26: i2l
    //   27: lstore_2
    //   28: lload_2
    //   29: aload_0
    //   30: invokevirtual 45	com/tencent/mm/vfs/u:length	()J
    //   33: lcmp
    //   34: ifgt +40 -> 74
    //   37: iload_1
    //   38: i2l
    //   39: lstore_2
    //   40: aload 4
    //   42: lload_2
    //   43: l2i
    //   44: invokestatic 49	com/tencent/mm/b/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   47: astore 5
    //   49: aload 4
    //   51: invokevirtual 55	java/io/InputStream:close	()V
    //   54: aload 5
    //   56: astore_0
    //   57: aload 4
    //   59: ifnull -42 -> 17
    //   62: aload 4
    //   64: invokevirtual 55	java/io/InputStream:close	()V
    //   67: aload 5
    //   69: areturn
    //   70: astore_0
    //   71: aload 5
    //   73: areturn
    //   74: aload_0
    //   75: invokevirtual 45	com/tencent/mm/vfs/u:length	()J
    //   78: lstore_2
    //   79: goto -39 -> 40
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 55	java/io/InputStream:close	()V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore 4
    //   99: aload 4
    //   101: ifnull +8 -> 109
    //   104: aload 4
    //   106: invokevirtual 55	java/io/InputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: goto -19 -> 93
    //   115: astore 4
    //   117: goto -8 -> 109
    //   120: astore_0
    //   121: goto -22 -> 99
    //   124: astore_0
    //   125: aload 4
    //   127: astore_0
    //   128: goto -43 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramu	u
    //   0	131	1	paramInt	int
    //   27	52	2	l	long
    //   23	82	4	localInputStream	InputStream
    //   115	11	4	localIOException	java.io.IOException
    //   47	25	5	str	String
    // Exception table:
    //   from	to	target	type
    //   62	67	70	java/io/IOException
    //   19	25	82	java/lang/Exception
    //   19	25	95	finally
    //   89	93	111	java/io/IOException
    //   104	109	115	java/io/IOException
    //   28	37	120	finally
    //   40	54	120	finally
    //   74	79	120	finally
    //   28	37	124	java/lang/Exception
    //   40	54	124	java/lang/Exception
    //   74	79	124	java/lang/Exception
  }
  
  /* Error */
  private static String b(u paramu)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 35	com/tencent/mm/vfs/u:jKS	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 41	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: iconst_0
    //   16: sipush 256
    //   19: invokestatic 60	com/tencent/mm/b/g:b	(Ljava/io/InputStream;II)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: invokevirtual 55	java/io/InputStream:close	()V
    //   27: aload_0
    //   28: ifnull +7 -> 35
    //   31: aload_0
    //   32: invokevirtual 55	java/io/InputStream:close	()V
    //   35: aload_1
    //   36: areturn
    //   37: astore_0
    //   38: aconst_null
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull -34 -> 7
    //   44: aload_0
    //   45: invokevirtual 55	java/io/InputStream:close	()V
    //   48: aconst_null
    //   49: areturn
    //   50: astore_0
    //   51: aconst_null
    //   52: areturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 55	java/io/InputStream:close	()V
    //   64: aload_1
    //   65: athrow
    //   66: astore_0
    //   67: goto -32 -> 35
    //   70: astore_0
    //   71: goto -7 -> 64
    //   74: astore_1
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: goto -39 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramu	u
    //   22	14	1	str	String
    //   53	12	1	localObject1	Object
    //   74	1	1	localObject2	Object
    //   78	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	14	37	java/lang/Exception
    //   44	48	50	java/io/IOException
    //   9	14	53	finally
    //   31	35	66	java/io/IOException
    //   60	64	70	java/io/IOException
    //   14	27	74	finally
    //   14	27	78	java/lang/Exception
  }
  
  public static final String b(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    return c(paramInputStream, 0, 256);
  }
  
  private static String c(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInputStream == null) || (paramInt1 < 0) || (paramInt2 <= 0)) {}
    for (;;)
    {
      return null;
      long l = paramInt1;
      try
      {
        if (paramInputStream.skip(l) >= paramInt1)
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          StringBuilder localStringBuilder = new StringBuilder(32);
          byte[] arrayOfByte = new byte[102400];
          paramInt1 = 0;
          for (;;)
          {
            int j = paramInputStream.read(arrayOfByte);
            if ((j == -1) || (paramInt1 >= paramInt2)) {
              break;
            }
            if (paramInt1 + j <= paramInt2)
            {
              localMessageDigest.update(arrayOfByte, 0, j);
              paramInt1 += j;
            }
            else
            {
              localMessageDigest.update(arrayOfByte, 0, paramInt2 - paramInt1);
              paramInt1 = paramInt2;
            }
          }
          paramInputStream = localMessageDigest.digest();
          paramInt1 = i;
          while (paramInt1 < paramInputStream.length)
          {
            localStringBuilder.append(Integer.toString((paramInputStream[paramInt1] & 0xFF) + 256, 16).substring(1));
            paramInt1 += 1;
          }
          paramInputStream = localStringBuilder.toString();
          return paramInputStream;
        }
      }
      catch (Exception paramInputStream) {}
    }
    return null;
  }
  
  public static final String e(InputStream paramInputStream, int paramInt)
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
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new u(paramString);
    } while (!paramString.jKS());
    return a(paramString, 102400);
  }
  
  public static final String getMessageDigest(byte[] paramArrayOfByte)
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
  
  public static String hu(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new u(paramString);
    } while (!paramString.jKS());
    return b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.g
 * JD-Core Version:    0.7.0.1
 */