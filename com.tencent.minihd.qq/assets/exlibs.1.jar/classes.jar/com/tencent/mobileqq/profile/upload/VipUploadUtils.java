package com.tencent.mobileqq.profile.upload;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import java.io.File;
import mqq.manager.TicketManager;

public class VipUploadUtils
{
  public static final int a = 0;
  public static final String a = "qqprofile";
  public static final boolean a = false;
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final int b = 1;
  public static final String b = "180.153.160.39";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 0;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 19994;
  public static final int p = 13;
  public static final int q = 640;
  public static final int r = 1136;
  public static final int s = 100;
  public static final int t = 80;
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_1
    //   4: aload_0
    //   5: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +49 -> 57
    //   11: new 81	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_2
    //   21: astore_1
    //   22: aload_0
    //   23: invokevirtual 88	java/io/File:exists	()Z
    //   26: ifeq +31 -> 57
    //   29: new 90	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokestatic 99	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull +9 -> 57
    //   51: aload_0
    //   52: invokevirtual 102	java/io/FileInputStream:close	()V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_2
    //   63: astore_1
    //   64: aload_0
    //   65: ifnull -8 -> 57
    //   68: aload_0
    //   69: invokevirtual 102	java/io/FileInputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull -26 -> 57
    //   86: aload_0
    //   87: invokevirtual 102	java/io/FileInputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_0
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 102	java/io/FileInputStream:close	()V
    //   106: aload_1
    //   107: athrow
    //   108: astore_0
    //   109: aload_2
    //   110: areturn
    //   111: astore_0
    //   112: goto -6 -> 106
    //   115: astore_1
    //   116: goto -18 -> 98
    //   119: astore_1
    //   120: goto -40 -> 80
    //   123: astore_1
    //   124: goto -62 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   3	79	1	localObject1	Object
    //   95	12	1	localObject2	Object
    //   115	1	1	localObject3	Object
    //   119	1	1	localException	java.lang.Exception
    //   123	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1	109	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   29	38	59	java/lang/OutOfMemoryError
    //   68	72	74	java/lang/Exception
    //   29	38	77	java/lang/Exception
    //   86	90	92	java/lang/Exception
    //   29	38	95	finally
    //   51	55	108	java/lang/Exception
    //   102	106	111	java/lang/Exception
    //   38	43	115	finally
    //   38	43	119	java/lang/Exception
    //   38	43	123	java/lang/OutOfMemoryError
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append(paramAppInterface.a());
    paramString.append(System.currentTimeMillis());
    return paramString.toString();
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 136
    //   4: invokestatic 142	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 145	java/security/MessageDigest:reset	()V
    //   12: new 90	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual 149	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   26: getstatic 155	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   29: lconst_0
    //   30: aload_0
    //   31: invokevirtual 158	java/io/File:length	()J
    //   34: invokevirtual 164	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   37: invokevirtual 168	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   40: aload_3
    //   41: invokevirtual 172	java/security/MessageDigest:digest	()[B
    //   44: invokestatic 175	com/tencent/mobileqq/profile/upload/VipUploadUtils:a	([B)Ljava/lang/String;
    //   47: astore_0
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 102	java/io/FileInputStream:close	()V
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: aload_2
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 102	java/io/FileInputStream:close	()V
    //   69: ldc 177
    //   71: areturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull -7 -> 69
    //   79: aload_1
    //   80: invokevirtual 102	java/io/FileInputStream:close	()V
    //   83: goto -14 -> 69
    //   86: astore_0
    //   87: goto -18 -> 69
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -25 -> 69
    //   97: aload_1
    //   98: invokevirtual 102	java/io/FileInputStream:close	()V
    //   101: goto -32 -> 69
    //   104: astore_0
    //   105: goto -36 -> 69
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 102	java/io/FileInputStream:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: astore_1
    //   122: aload_0
    //   123: areturn
    //   124: astore_0
    //   125: goto -56 -> 69
    //   128: astore_1
    //   129: goto -10 -> 119
    //   132: astore_0
    //   133: goto -22 -> 111
    //   136: astore_0
    //   137: goto -44 -> 93
    //   140: astore_0
    //   141: goto -66 -> 75
    //   144: astore_0
    //   145: aload_1
    //   146: astore_0
    //   147: goto -86 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramFile	File
    //   20	96	1	localFileInputStream	java.io.FileInputStream
    //   121	1	1	localIOException1	java.io.IOException
    //   128	18	1	localIOException2	java.io.IOException
    //   1	59	2	localObject	Object
    //   7	34	3	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   2	21	58	java/security/NoSuchAlgorithmException
    //   2	21	72	java/io/FileNotFoundException
    //   79	83	86	java/io/IOException
    //   2	21	90	java/io/IOException
    //   97	101	104	java/io/IOException
    //   2	21	108	finally
    //   52	56	121	java/io/IOException
    //   65	69	124	java/io/IOException
    //   115	119	128	java/io/IOException
    //   21	48	132	finally
    //   21	48	136	java/io/IOException
    //   21	48	140	java/io/FileNotFoundException
    //   21	48	144	java/security/NoSuchAlgorithmException
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.length() < 204800L) {}
      for (paramString = a(paramString);; paramString = b(paramString))
      {
        String str = paramString;
        if ("".equals(paramString)) {
          str = null;
        }
        return str;
      }
    }
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i1] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i1] & 0xF)]);
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] a(AppInterface paramAppInterface)
  {
    return HexUtil.hexStr2Bytes(((TicketManager)paramAppInterface.getManager(2)).getA2(paramAppInterface.a()));
  }
  
  /* Error */
  private static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 88	java/io/File:exists	()Z
    //   14: ifne +10 -> 24
    //   17: ldc 177
    //   19: astore 5
    //   21: aload 5
    //   23: areturn
    //   24: aload_0
    //   25: invokevirtual 158	java/io/File:length	()J
    //   28: lstore_2
    //   29: lload_2
    //   30: ldc2_w 213
    //   33: lcmp
    //   34: ifle +141 -> 175
    //   37: lload_2
    //   38: ldc2_w 215
    //   41: ldiv
    //   42: lstore_2
    //   43: bipush 32
    //   45: newarray byte
    //   47: astore 5
    //   49: new 90	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: astore_0
    //   58: aload_0
    //   59: lload_2
    //   60: invokevirtual 220	java/io/FileInputStream:skip	(J)J
    //   63: pop2
    //   64: iconst_0
    //   65: istore_1
    //   66: iload_1
    //   67: iconst_4
    //   68: if_icmpge +33 -> 101
    //   71: aload_0
    //   72: aload 5
    //   74: iload_1
    //   75: bipush 8
    //   77: imul
    //   78: bipush 8
    //   80: invokevirtual 224	java/io/FileInputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: lload_2
    //   86: ldc2_w 225
    //   89: lsub
    //   90: invokevirtual 220	java/io/FileInputStream:skip	(J)J
    //   93: pop2
    //   94: iload_1
    //   95: iconst_1
    //   96: iadd
    //   97: istore_1
    //   98: goto -32 -> 66
    //   101: aload 5
    //   103: invokestatic 175	com/tencent/mobileqq/profile/upload/VipUploadUtils:a	([B)Ljava/lang/String;
    //   106: astore 4
    //   108: aload 4
    //   110: astore 5
    //   112: aload_0
    //   113: ifnull -92 -> 21
    //   116: aload_0
    //   117: invokevirtual 102	java/io/FileInputStream:close	()V
    //   120: aload 4
    //   122: areturn
    //   123: astore_0
    //   124: aload 4
    //   126: areturn
    //   127: astore_0
    //   128: aload 4
    //   130: astore_0
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 102	java/io/FileInputStream:close	()V
    //   139: ldc 177
    //   141: areturn
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull -7 -> 139
    //   149: aload_0
    //   150: invokevirtual 102	java/io/FileInputStream:close	()V
    //   153: goto -14 -> 139
    //   156: astore_0
    //   157: goto -18 -> 139
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 102	java/io/FileInputStream:close	()V
    //   172: aload 4
    //   174: athrow
    //   175: ldc 136
    //   177: invokestatic 142	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   180: astore 6
    //   182: aload 6
    //   184: invokevirtual 145	java/security/MessageDigest:reset	()V
    //   187: new 90	java/io/FileInputStream
    //   190: dup
    //   191: aload_0
    //   192: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   195: astore 4
    //   197: aload 6
    //   199: aload 4
    //   201: invokevirtual 149	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   204: getstatic 155	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   207: lconst_0
    //   208: aload_0
    //   209: invokevirtual 158	java/io/File:length	()J
    //   212: invokevirtual 164	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   215: invokevirtual 168	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   218: aload 6
    //   220: invokevirtual 172	java/security/MessageDigest:digest	()[B
    //   223: invokestatic 175	com/tencent/mobileqq/profile/upload/VipUploadUtils:a	([B)Ljava/lang/String;
    //   226: astore_0
    //   227: aload_0
    //   228: astore 5
    //   230: aload 4
    //   232: ifnull -211 -> 21
    //   235: aload 4
    //   237: invokevirtual 102	java/io/FileInputStream:close	()V
    //   240: aload_0
    //   241: areturn
    //   242: astore 4
    //   244: aload_0
    //   245: areturn
    //   246: astore_0
    //   247: aload 5
    //   249: astore_0
    //   250: aload_0
    //   251: ifnull -112 -> 139
    //   254: aload_0
    //   255: invokevirtual 102	java/io/FileInputStream:close	()V
    //   258: goto -119 -> 139
    //   261: astore_0
    //   262: goto -123 -> 139
    //   265: astore_0
    //   266: aconst_null
    //   267: astore 4
    //   269: aload 4
    //   271: ifnull -132 -> 139
    //   274: aload 4
    //   276: invokevirtual 102	java/io/FileInputStream:close	()V
    //   279: goto -140 -> 139
    //   282: astore_0
    //   283: goto -144 -> 139
    //   286: astore_0
    //   287: aconst_null
    //   288: astore 4
    //   290: aload 4
    //   292: ifnull -153 -> 139
    //   295: aload 4
    //   297: invokevirtual 102	java/io/FileInputStream:close	()V
    //   300: goto -161 -> 139
    //   303: astore_0
    //   304: goto -165 -> 139
    //   307: astore_0
    //   308: aconst_null
    //   309: astore 4
    //   311: aload 4
    //   313: ifnull +8 -> 321
    //   316: aload 4
    //   318: invokevirtual 102	java/io/FileInputStream:close	()V
    //   321: aload_0
    //   322: athrow
    //   323: astore_0
    //   324: goto -185 -> 139
    //   327: astore_0
    //   328: goto -156 -> 172
    //   331: astore 4
    //   333: goto -12 -> 321
    //   336: astore_0
    //   337: goto -26 -> 311
    //   340: astore_0
    //   341: goto -51 -> 290
    //   344: astore_0
    //   345: goto -76 -> 269
    //   348: astore_0
    //   349: aload 4
    //   351: astore_0
    //   352: goto -102 -> 250
    //   355: astore 4
    //   357: goto -193 -> 164
    //   360: astore 4
    //   362: goto -217 -> 145
    //   365: astore 4
    //   367: goto -236 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramFile	File
    //   65	33	1	i1	int
    //   28	58	2	l1	long
    //   4	125	4	str	String
    //   160	13	4	localObject1	Object
    //   195	41	4	localFileInputStream	java.io.FileInputStream
    //   242	1	4	localIOException1	java.io.IOException
    //   267	50	4	localObject2	Object
    //   331	19	4	localIOException2	java.io.IOException
    //   355	1	4	localObject3	Object
    //   360	1	4	localIOException3	java.io.IOException
    //   365	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   1	247	5	localObject4	Object
    //   180	39	6	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   116	120	123	java/io/IOException
    //   49	58	127	java/io/FileNotFoundException
    //   49	58	142	java/io/IOException
    //   149	153	156	java/io/IOException
    //   49	58	160	finally
    //   235	240	242	java/io/IOException
    //   175	197	246	java/security/NoSuchAlgorithmException
    //   254	258	261	java/io/IOException
    //   175	197	265	java/io/FileNotFoundException
    //   274	279	282	java/io/IOException
    //   175	197	286	java/io/IOException
    //   295	300	303	java/io/IOException
    //   175	197	307	finally
    //   135	139	323	java/io/IOException
    //   168	172	327	java/io/IOException
    //   316	321	331	java/io/IOException
    //   197	227	336	finally
    //   197	227	340	java/io/IOException
    //   197	227	344	java/io/FileNotFoundException
    //   197	227	348	java/security/NoSuchAlgorithmException
    //   58	64	355	finally
    //   71	94	355	finally
    //   101	108	355	finally
    //   58	64	360	java/io/IOException
    //   71	94	360	java/io/IOException
    //   101	108	360	java/io/IOException
    //   58	64	365	java/io/FileNotFoundException
    //   71	94	365	java/io/FileNotFoundException
    //   101	108	365	java/io/FileNotFoundException
  }
  
  protected int a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return (str + System.currentTimeMillis()).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.VipUploadUtils
 * JD-Core Version:    0.7.0.1
 */