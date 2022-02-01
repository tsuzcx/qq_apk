package com.qcloud.qvb.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class b
{
  /* Error */
  public static final String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 19	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 23	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 4
    //   14: new 25	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_0
    //   23: sipush 8192
    //   26: newarray byte
    //   28: astore_2
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   34: istore_1
    //   35: iload_1
    //   36: iconst_m1
    //   37: if_icmpeq +35 -> 72
    //   40: aload 4
    //   42: aload_2
    //   43: iconst_0
    //   44: iload_1
    //   45: invokevirtual 36	java/io/ByteArrayOutputStream:write	([BII)V
    //   48: goto -19 -> 29
    //   51: astore_2
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 39	java/io/FileInputStream:close	()V
    //   60: aload 4
    //   62: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   65: ldc 11
    //   67: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: areturn
    //   72: aload 4
    //   74: invokevirtual 47	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: invokestatic 50	com/qcloud/qvb/a/b:a	([B)Ljava/lang/String;
    //   80: astore_2
    //   81: aload_0
    //   82: invokevirtual 39	java/io/FileInputStream:close	()V
    //   85: aload 4
    //   87: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   90: ldc 11
    //   92: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_2
    //   96: areturn
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 39	java/io/FileInputStream:close	()V
    //   108: aload 4
    //   110: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   113: ldc 11
    //   115: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: ifnull +7 -> 131
    //   127: aload_0
    //   128: invokevirtual 39	java/io/FileInputStream:close	()V
    //   131: aload 4
    //   133: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   136: ldc 11
    //   138: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_0
    //   146: goto -94 -> 52
    //   149: astore_3
    //   150: aload_0
    //   151: astore_2
    //   152: aload_3
    //   153: astore_0
    //   154: goto -54 -> 100
    //   157: astore_2
    //   158: goto -45 -> 113
    //   161: astore_0
    //   162: goto -97 -> 65
    //   165: astore_0
    //   166: goto -30 -> 136
    //   169: astore_2
    //   170: goto -47 -> 123
    //   173: astore_0
    //   174: goto -84 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramFile	java.io.File
    //   34	11	1	i	int
    //   28	15	2	arrayOfByte	byte[]
    //   51	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   80	72	2	localObject1	Object
    //   157	1	2	localIOException1	java.io.IOException
    //   169	1	2	localIOException2	java.io.IOException
    //   149	4	3	localObject2	Object
    //   12	120	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   23	29	51	java/io/FileNotFoundException
    //   29	35	51	java/io/FileNotFoundException
    //   40	48	51	java/io/FileNotFoundException
    //   72	81	51	java/io/FileNotFoundException
    //   14	23	97	finally
    //   14	23	120	java/io/IOException
    //   14	23	143	java/io/FileNotFoundException
    //   23	29	149	finally
    //   29	35	149	finally
    //   40	48	149	finally
    //   72	81	149	finally
    //   104	108	157	java/io/IOException
    //   108	113	157	java/io/IOException
    //   56	60	161	java/io/IOException
    //   60	65	161	java/io/IOException
    //   127	131	165	java/io/IOException
    //   131	136	165	java/io/IOException
    //   23	29	169	java/io/IOException
    //   29	35	169	java/io/IOException
    //   40	48	169	java/io/IOException
    //   72	81	169	java/io/IOException
    //   81	90	173	java/io/IOException
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207441);
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = '0';
    arrayOfChar[1] = '1';
    arrayOfChar[2] = '2';
    arrayOfChar[3] = '3';
    arrayOfChar[4] = '4';
    arrayOfChar[5] = '5';
    arrayOfChar[6] = '6';
    arrayOfChar[7] = '7';
    arrayOfChar[8] = '8';
    arrayOfChar[9] = '9';
    arrayOfChar[10] = 'A';
    arrayOfChar[11] = 'B';
    arrayOfChar[12] = 'C';
    arrayOfChar[13] = 'D';
    arrayOfChar[14] = 'E';
    arrayOfChar[15] = 'F';
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
        AppMethodBeat.o(207441);
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      AppMethodBeat.o(207441);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.qcloud.qvb.a.b
 * JD-Core Version:    0.7.0.1
 */