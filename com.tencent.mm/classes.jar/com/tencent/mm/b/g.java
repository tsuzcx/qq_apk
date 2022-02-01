package com.tencent.mm.b;

import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g
{
  public static final byte[] C(byte[] paramArrayOfByte)
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
  private static String b(e parame)
  {
    // Byte code:
    //   0: ldc2_w 30
    //   3: lstore_1
    //   4: aload_0
    //   5: invokevirtual 37	com/tencent/mm/vfs/e:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_0
    //   14: invokestatic 43	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   17: astore_3
    //   18: ldc2_w 30
    //   21: aload_0
    //   22: invokevirtual 47	com/tencent/mm/vfs/e:length	()J
    //   25: lcmp
    //   26: ifgt +24 -> 50
    //   29: aload_3
    //   30: lload_1
    //   31: l2i
    //   32: invokestatic 50	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: invokevirtual 56	java/io/InputStream:close	()V
    //   40: aload_3
    //   41: ifnull +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 56	java/io/InputStream:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: aload_0
    //   51: invokevirtual 47	com/tencent/mm/vfs/e:length	()J
    //   54: lstore_1
    //   55: goto -26 -> 29
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull -51 -> 11
    //   65: aload_0
    //   66: invokevirtual 56	java/io/InputStream:close	()V
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
    //   82: invokevirtual 56	java/io/InputStream:close	()V
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
    //   0	105	0	parame	e
    //   3	52	1	l	long
    //   17	65	3	localInputStream	InputStream
    //   87	1	3	localIOException1	java.io.IOException
    //   91	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   13	18	58	java/lang/Exception
    //   65	69	71	java/io/IOException
    //   13	18	74	finally
    //   44	48	87	java/io/IOException
    //   81	85	91	java/io/IOException
    //   18	29	95	finally
    //   29	40	95	finally
    //   50	55	95	finally
    //   18	29	99	java/lang/Exception
    //   29	40	99	java/lang/Exception
    //   50	55	99	java/lang/Exception
  }
  
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
  
  /* Error */
  private static String c(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 37	com/tencent/mm/vfs/e:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 43	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 93	com/tencent/mm/b/g:r	(Ljava/io/InputStream;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: invokevirtual 56	java/io/InputStream:close	()V
    //   23: aload_0
    //   24: ifnull +7 -> 31
    //   27: aload_0
    //   28: invokevirtual 56	java/io/InputStream:close	()V
    //   31: aload_1
    //   32: areturn
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull -30 -> 7
    //   40: aload_0
    //   41: invokevirtual 56	java/io/InputStream:close	()V
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
    //   57: invokevirtual 56	java/io/InputStream:close	()V
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
    //   0	78	0	parame	e
    //   18	14	1	str	String
    //   49	12	1	localObject1	Object
    //   70	1	1	localObject2	Object
    //   74	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	14	33	java/lang/Exception
    //   40	44	46	java/io/IOException
    //   9	14	49	finally
    //   27	31	62	java/io/IOException
    //   56	60	66	java/io/IOException
    //   14	23	70	finally
    //   14	23	74	java/lang/Exception
  }
  
  public static String ep(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new e(paramString);
    } while (!paramString.exists());
    return c(paramString);
  }
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new e(paramString);
    } while (!paramString.exists());
    return b(paramString);
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
  
  public static String r(InputStream paramInputStream)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.g
 * JD-Core Version:    0.7.0.1
 */