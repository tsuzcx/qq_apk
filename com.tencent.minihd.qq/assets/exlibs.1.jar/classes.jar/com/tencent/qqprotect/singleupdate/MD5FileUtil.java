package com.tencent.qqprotect.singleupdate;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5FileUtil
{
  protected static MessageDigest a;
  protected static char[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    jdField_a_of_type_JavaSecurityMessageDigest = null;
    try
    {
      jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  public static String a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() > 0L))
    {
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(paramFile);
        paramFile = localFileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, paramFile.length());
        jdField_a_of_type_JavaSecurityMessageDigest.update(paramFile);
        paramFile = b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localFileInputStream.close();
          return paramFile;
        }
        catch (Throwable localThrowable2)
        {
          break label71;
        }
        localThrowable1 = localThrowable1;
        paramFile = null;
      }
      label71:
      return paramFile;
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 103
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 9
    //   7: ldc 33
    //   9: invokestatic 39	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 10
    //   14: new 58	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore 8
    //   24: aload 8
    //   26: astore 7
    //   28: new 48	java/io/File
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 56	java/io/File:length	()J
    //   39: lstore 5
    //   41: lload 5
    //   43: ldc2_w 103
    //   46: lcmp
    //   47: ifle +276 -> 323
    //   50: aload 8
    //   52: astore 7
    //   54: sipush 4096
    //   57: newarray byte
    //   59: astore_0
    //   60: lload_3
    //   61: lconst_0
    //   62: lcmp
    //   63: ifle +78 -> 141
    //   66: aload 8
    //   68: astore 7
    //   70: aload 8
    //   72: aload_0
    //   73: invokevirtual 114	java/io/InputStream:read	([B)I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_m1
    //   79: if_icmpeq +62 -> 141
    //   82: iload_2
    //   83: istore_1
    //   84: iload_2
    //   85: i2l
    //   86: lload_3
    //   87: lcmp
    //   88: ifle +6 -> 94
    //   91: lload_3
    //   92: l2i
    //   93: istore_1
    //   94: lload_3
    //   95: iload_1
    //   96: i2l
    //   97: lsub
    //   98: lstore_3
    //   99: aload 8
    //   101: astore 7
    //   103: aload 10
    //   105: aload_0
    //   106: iconst_0
    //   107: iload_1
    //   108: invokevirtual 117	java/security/MessageDigest:update	([BII)V
    //   111: goto -51 -> 60
    //   114: astore_0
    //   115: aload 8
    //   117: astore 7
    //   119: aload_0
    //   120: invokevirtual 118	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   123: aload 9
    //   125: astore_0
    //   126: aload 8
    //   128: ifnull +11 -> 139
    //   131: aload 8
    //   133: invokevirtual 119	java/io/InputStream:close	()V
    //   136: aload 9
    //   138: astore_0
    //   139: aload_0
    //   140: areturn
    //   141: aload 8
    //   143: astore 7
    //   145: aload 8
    //   147: invokevirtual 119	java/io/InputStream:close	()V
    //   150: aload 8
    //   152: astore 7
    //   154: aload 10
    //   156: invokevirtual 85	java/security/MessageDigest:digest	()[B
    //   159: invokestatic 89	com/tencent/qqprotect/singleupdate/MD5FileUtil:b	([B)Ljava/lang/String;
    //   162: astore_0
    //   163: aload_0
    //   164: astore 7
    //   166: aload 7
    //   168: astore_0
    //   169: aload 8
    //   171: ifnull -32 -> 139
    //   174: aload 8
    //   176: invokevirtual 119	java/io/InputStream:close	()V
    //   179: aload 7
    //   181: areturn
    //   182: astore_0
    //   183: aload 7
    //   185: areturn
    //   186: astore_0
    //   187: aconst_null
    //   188: astore 8
    //   190: aload 8
    //   192: astore 7
    //   194: aload_0
    //   195: invokevirtual 120	java/io/FileNotFoundException:printStackTrace	()V
    //   198: aload 9
    //   200: astore_0
    //   201: aload 8
    //   203: ifnull -64 -> 139
    //   206: aload 8
    //   208: invokevirtual 119	java/io/InputStream:close	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aconst_null
    //   215: areturn
    //   216: astore_0
    //   217: aconst_null
    //   218: astore 8
    //   220: aload 8
    //   222: astore 7
    //   224: aload_0
    //   225: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   228: aload 9
    //   230: astore_0
    //   231: aload 8
    //   233: ifnull -94 -> 139
    //   236: aload 8
    //   238: invokevirtual 119	java/io/InputStream:close	()V
    //   241: aconst_null
    //   242: areturn
    //   243: astore_0
    //   244: aconst_null
    //   245: areturn
    //   246: astore_0
    //   247: aconst_null
    //   248: astore 8
    //   250: aload 8
    //   252: astore 7
    //   254: aload_0
    //   255: invokevirtual 95	java/lang/Throwable:printStackTrace	()V
    //   258: aload 9
    //   260: astore_0
    //   261: aload 8
    //   263: ifnull -124 -> 139
    //   266: aload 8
    //   268: invokevirtual 119	java/io/InputStream:close	()V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_0
    //   274: aconst_null
    //   275: areturn
    //   276: astore_0
    //   277: aconst_null
    //   278: astore 7
    //   280: aload 7
    //   282: ifnull +8 -> 290
    //   285: aload 7
    //   287: invokevirtual 119	java/io/InputStream:close	()V
    //   290: aload_0
    //   291: athrow
    //   292: astore_0
    //   293: aconst_null
    //   294: areturn
    //   295: astore 7
    //   297: goto -7 -> 290
    //   300: astore_0
    //   301: goto -21 -> 280
    //   304: astore_0
    //   305: goto -55 -> 250
    //   308: astore_0
    //   309: goto -89 -> 220
    //   312: astore_0
    //   313: goto -123 -> 190
    //   316: astore_0
    //   317: aconst_null
    //   318: astore 8
    //   320: goto -205 -> 115
    //   323: lload 5
    //   325: lstore_3
    //   326: goto -276 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramString	String
    //   83	25	1	i	int
    //   76	9	2	j	int
    //   3	323	3	l1	long
    //   39	285	5	l2	long
    //   26	260	7	localObject1	Object
    //   295	1	7	localException	java.lang.Exception
    //   22	297	8	localFileInputStream	FileInputStream
    //   5	254	9	localObject2	Object
    //   12	143	10	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   28	41	114	java/security/NoSuchAlgorithmException
    //   54	60	114	java/security/NoSuchAlgorithmException
    //   70	77	114	java/security/NoSuchAlgorithmException
    //   103	111	114	java/security/NoSuchAlgorithmException
    //   145	150	114	java/security/NoSuchAlgorithmException
    //   154	163	114	java/security/NoSuchAlgorithmException
    //   174	179	182	java/lang/Exception
    //   7	24	186	java/io/FileNotFoundException
    //   206	211	213	java/lang/Exception
    //   7	24	216	java/io/IOException
    //   236	241	243	java/lang/Exception
    //   7	24	246	java/lang/Throwable
    //   266	271	273	java/lang/Exception
    //   7	24	276	finally
    //   131	136	292	java/lang/Exception
    //   285	290	295	java/lang/Exception
    //   28	41	300	finally
    //   54	60	300	finally
    //   70	77	300	finally
    //   103	111	300	finally
    //   119	123	300	finally
    //   145	150	300	finally
    //   154	163	300	finally
    //   194	198	300	finally
    //   224	228	300	finally
    //   254	258	300	finally
    //   28	41	304	java/lang/Throwable
    //   54	60	304	java/lang/Throwable
    //   70	77	304	java/lang/Throwable
    //   103	111	304	java/lang/Throwable
    //   145	150	304	java/lang/Throwable
    //   154	163	304	java/lang/Throwable
    //   28	41	308	java/io/IOException
    //   54	60	308	java/io/IOException
    //   70	77	308	java/io/IOException
    //   103	111	308	java/io/IOException
    //   145	150	308	java/io/IOException
    //   154	163	308	java/io/IOException
    //   28	41	312	java/io/FileNotFoundException
    //   54	60	312	java/io/FileNotFoundException
    //   70	77	312	java/io/FileNotFoundException
    //   103	111	312	java/io/FileNotFoundException
    //   145	150	312	java/io/FileNotFoundException
    //   154	163	312	java/io/FileNotFoundException
    //   7	24	316	java/security/NoSuchAlgorithmException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    jdField_a_of_type_JavaSecurityMessageDigest.update(paramArrayOfByte);
    return b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = jdField_a_of_type_ArrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = jdField_a_of_type_ArrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return b(paramString1).equals(paramString2);
  }
  
  public static String b(String paramString)
  {
    return a(paramString.getBytes());
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.MD5FileUtil
 * JD-Core Version:    0.7.0.1
 */