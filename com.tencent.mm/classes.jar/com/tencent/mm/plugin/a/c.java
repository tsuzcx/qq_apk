package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.y;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c
{
  public static long K(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 56 | (paramArrayOfByte[1] & 0xFF) << 48 | (paramArrayOfByte[2] & 0xFF) << 40 | (paramArrayOfByte[3] & 0xFF) << 32 | (paramArrayOfByte[4] & 0xFF) << 24 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[6] & 0xFF) << 8 | paramArrayOfByte[7] & 0xFF;
  }
  
  public static a a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, int paramInt)
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      long l;
      try
      {
        i = paramRandomAccessFile.read(paramArrayOfByte);
        if (i < 8) {
          break;
        }
        j = readInt(paramArrayOfByte, 0);
        k = readInt(paramArrayOfByte, 4);
        if (k != paramInt) {
          break label163;
        }
        l = paramRandomAccessFile.getFilePointer() - i;
        if (k == a.aAn) {
          return new i(j, l, k);
        }
        if (k == a.aAo)
        {
          paramRandomAccessFile = new e(j, l, k);
          return paramRandomAccessFile;
        }
      }
      catch (Exception paramRandomAccessFile)
      {
        y.printErrStackTrace("MicroMsg.AtomUtil", paramRandomAccessFile, "", new Object[0]);
        y.e("MicroMsg.AtomUtil", "find Atom error: " + paramRandomAccessFile.toString());
        return null;
      }
      if (k == a.aAq) {
        return new h(j, l, k);
      }
      return new a(j, l, k, 0L);
      label163:
      if ((k == a.aAl) || (k == a.aAp))
      {
        i = paramRandomAccessFile.read(paramArrayOfByte);
      }
      else
      {
        if (!a(paramRandomAccessFile, j - 8)) {
          break;
        }
        i = paramRandomAccessFile.read(paramArrayOfByte);
      }
    }
    return null;
  }
  
  public static boolean a(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    long l = 0L;
    while (paramLong > 2147483647L)
    {
      l += paramRandomAccessFile.skipBytes(2147483647);
      paramLong -= 2147483647L;
    }
    l += paramRandomAccessFile.skipBytes((int)paramLong);
    if (l != paramLong)
    {
      y.w("MicroMsg.AtomUtil", "can not skip.skip: " + paramLong + " trueSkip : " + l);
      return false;
    }
    return true;
  }
  
  public static int aG(String paramString)
  {
    int k = paramString.length();
    int j = 0;
    int m;
    for (int i = 0; j < k; i = i << 8 | m)
    {
      m = paramString.charAt(j);
      j += 1;
    }
    return i;
  }
  
  public static boolean bl(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  /* Error */
  public static boolean pp(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 129	com/tencent/mm/plugin/a/c:bl	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 131	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: astore_0
    //   22: bipush 8
    //   24: newarray byte
    //   26: astore 5
    //   28: aload 4
    //   30: astore_0
    //   31: aload 4
    //   33: aload 5
    //   35: iconst_0
    //   36: bipush 8
    //   38: invokevirtual 137	java/io/InputStream:read	([BII)I
    //   41: istore_1
    //   42: iload_1
    //   43: bipush 8
    //   45: if_icmpge +25 -> 70
    //   48: aload 4
    //   50: invokevirtual 141	java/io/InputStream:close	()V
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_0
    //   56: ldc 47
    //   58: aload_0
    //   59: ldc 49
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 55	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: iconst_0
    //   69: ireturn
    //   70: aload 4
    //   72: astore_0
    //   73: aload 5
    //   75: iconst_0
    //   76: invokestatic 23	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   79: istore_1
    //   80: aload 4
    //   82: astore_0
    //   83: aload 5
    //   85: iconst_4
    //   86: invokestatic 23	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   89: istore_2
    //   90: aload 4
    //   92: astore_0
    //   93: getstatic 144	com/tencent/mm/plugin/a/a:azK	I
    //   96: istore_3
    //   97: iload_2
    //   98: iload_3
    //   99: if_icmpne +30 -> 129
    //   102: iload_1
    //   103: ifle +26 -> 129
    //   106: aload 4
    //   108: invokevirtual 141	java/io/InputStream:close	()V
    //   111: iconst_1
    //   112: ireturn
    //   113: astore_0
    //   114: ldc 47
    //   116: aload_0
    //   117: ldc 49
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 55	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -15 -> 111
    //   129: aload 4
    //   131: invokevirtual 141	java/io/InputStream:close	()V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_0
    //   137: ldc 47
    //   139: aload_0
    //   140: ldc 49
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 55	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore 5
    //   153: aconst_null
    //   154: astore 4
    //   156: aload 4
    //   158: astore_0
    //   159: ldc 47
    //   161: aload 5
    //   163: ldc 49
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 55	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload 4
    //   174: ifnull -167 -> 7
    //   177: aload 4
    //   179: invokevirtual 141	java/io/InputStream:close	()V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore_0
    //   185: ldc 47
    //   187: aload_0
    //   188: ldc 49
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 55	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_0
    //   204: ifnull +7 -> 211
    //   207: aload_0
    //   208: invokevirtual 141	java/io/InputStream:close	()V
    //   211: aload 4
    //   213: athrow
    //   214: astore_0
    //   215: ldc 47
    //   217: aload_0
    //   218: ldc 49
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 55	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: goto -16 -> 211
    //   230: astore 4
    //   232: goto -29 -> 203
    //   235: astore 5
    //   237: goto -81 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   41	62	1	i	int
    //   89	11	2	j	int
    //   96	4	3	k	int
    //   17	161	4	localFileInputStream	java.io.FileInputStream
    //   199	13	4	localObject1	Object
    //   230	1	4	localObject2	Object
    //   26	58	5	arrayOfByte	byte[]
    //   151	11	5	localException1	Exception
    //   235	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	53	55	java/io/IOException
    //   106	111	113	java/io/IOException
    //   129	134	136	java/io/IOException
    //   9	19	151	java/lang/Exception
    //   177	182	184	java/io/IOException
    //   9	19	199	finally
    //   207	211	214	java/io/IOException
    //   22	28	230	finally
    //   31	42	230	finally
    //   73	80	230	finally
    //   83	90	230	finally
    //   93	97	230	finally
    //   159	172	230	finally
    //   22	28	235	java/lang/Exception
    //   31	42	235	java/lang/Exception
    //   73	80	235	java/lang/Exception
    //   83	90	235	java/lang/Exception
    //   93	97	235	java/lang/Exception
  }
  
  public static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int j = i + 1;
    return (paramArrayOfByte[i] & 0xFF) << 16 | (paramInt & 0xFF) << 24 | (paramArrayOfByte[j] & 0xFF) << 8 | paramArrayOfByte[(j + 1)] & 0xFF;
  }
  
  public static long z(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[8];
    Arrays.fill(arrayOfByte, (byte)0);
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 4, 4);
    return K(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.a.c
 * JD-Core Version:    0.7.0.1
 */