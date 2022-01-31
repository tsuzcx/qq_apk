package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_1
    //   4: invokestatic 14	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   7: ifeq +13 -> 20
    //   10: new 16	java/security/InvalidParameterException
    //   13: dup
    //   14: ldc 18
    //   16: invokespecial 22	java/security/InvalidParameterException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: new 24	java/io/File
    //   23: dup
    //   24: aload_2
    //   25: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_2
    //   29: new 24	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 7
    //   39: iload 6
    //   41: istore 5
    //   43: aload_2
    //   44: invokevirtual 29	java/io/File:exists	()Z
    //   47: ifeq +253 -> 300
    //   50: iload 6
    //   52: istore 5
    //   54: aload_2
    //   55: invokevirtual 32	java/io/File:isFile	()Z
    //   58: ifeq +242 -> 300
    //   61: aload 7
    //   63: invokevirtual 36	java/io/File:getParentFile	()Ljava/io/File;
    //   66: invokevirtual 29	java/io/File:exists	()Z
    //   69: ifne +12 -> 81
    //   72: aload 7
    //   74: invokevirtual 36	java/io/File:getParentFile	()Ljava/io/File;
    //   77: invokevirtual 39	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload 7
    //   83: invokevirtual 42	java/io/File:createNewFile	()Z
    //   86: pop
    //   87: new 44	java/io/FileInputStream
    //   90: dup
    //   91: aload_2
    //   92: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore_3
    //   96: new 49	java/io/FileOutputStream
    //   99: dup
    //   100: aload 7
    //   102: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   105: astore_2
    //   106: aload_0
    //   107: invokevirtual 56	java/lang/String:getBytes	()[B
    //   110: iconst_0
    //   111: invokestatic 62	android/util/Base64:decode	([BI)[B
    //   114: astore_0
    //   115: new 64	javax/crypto/spec/SecretKeySpec
    //   118: dup
    //   119: aload_0
    //   120: ldc 66
    //   122: invokespecial 69	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   125: astore 7
    //   127: aload_1
    //   128: invokestatic 75	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   131: astore_1
    //   132: aload_1
    //   133: iconst_2
    //   134: aload 7
    //   136: new 77	javax/crypto/spec/IvParameterSpec
    //   139: dup
    //   140: aload_0
    //   141: aload_0
    //   142: arraylength
    //   143: invokestatic 82	java/util/Arrays:copyOf	([BI)[B
    //   146: invokespecial 85	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   149: invokevirtual 89	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   152: new 91	javax/crypto/CipherOutputStream
    //   155: dup
    //   156: aload_2
    //   157: aload_1
    //   158: invokespecial 94	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   161: astore_1
    //   162: aload_1
    //   163: astore_0
    //   164: aload_2
    //   165: astore 7
    //   167: aload_3
    //   168: astore 8
    //   170: sipush 1024
    //   173: newarray byte
    //   175: astore 9
    //   177: aload_1
    //   178: astore_0
    //   179: aload_2
    //   180: astore 7
    //   182: aload_3
    //   183: astore 8
    //   185: aload_3
    //   186: aload 9
    //   188: invokevirtual 98	java/io/FileInputStream:read	([B)I
    //   191: istore 4
    //   193: iload 4
    //   195: iconst_m1
    //   196: if_icmpeq +89 -> 285
    //   199: aload_1
    //   200: astore_0
    //   201: aload_2
    //   202: astore 7
    //   204: aload_3
    //   205: astore 8
    //   207: aload_1
    //   208: aload 9
    //   210: iconst_0
    //   211: iload 4
    //   213: invokevirtual 102	javax/crypto/CipherOutputStream:write	([BII)V
    //   216: aload_1
    //   217: astore_0
    //   218: aload_2
    //   219: astore 7
    //   221: aload_3
    //   222: astore 8
    //   224: aload_1
    //   225: invokevirtual 106	javax/crypto/CipherOutputStream:flush	()V
    //   228: goto -51 -> 177
    //   231: astore 7
    //   233: aload_1
    //   234: astore_0
    //   235: aload 7
    //   237: astore_1
    //   238: aload_2
    //   239: astore 7
    //   241: aload_3
    //   242: astore 8
    //   244: aload_1
    //   245: athrow
    //   246: astore 9
    //   248: aload 8
    //   250: astore_3
    //   251: aload 7
    //   253: astore_2
    //   254: aload_0
    //   255: astore_1
    //   256: aload 9
    //   258: astore_0
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 109	javax/crypto/CipherOutputStream:close	()V
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   275: aload_3
    //   276: ifnull +7 -> 283
    //   279: aload_3
    //   280: invokevirtual 111	java/io/FileInputStream:close	()V
    //   283: aload_0
    //   284: athrow
    //   285: aload_1
    //   286: invokevirtual 109	javax/crypto/CipherOutputStream:close	()V
    //   289: aload_2
    //   290: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   293: aload_3
    //   294: invokevirtual 111	java/io/FileInputStream:close	()V
    //   297: iconst_1
    //   298: istore 5
    //   300: iload 5
    //   302: ireturn
    //   303: astore_0
    //   304: aconst_null
    //   305: astore_1
    //   306: aconst_null
    //   307: astore_2
    //   308: aconst_null
    //   309: astore_3
    //   310: goto -51 -> 259
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_1
    //   316: aconst_null
    //   317: astore_2
    //   318: goto -59 -> 259
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_1
    //   324: goto -65 -> 259
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_3
    //   334: goto -96 -> 238
    //   337: astore_1
    //   338: aconst_null
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_2
    //   342: goto -104 -> 238
    //   345: astore_1
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -110 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramString1	String
    //   0	351	1	paramString2	String
    //   0	351	2	paramString3	String
    //   0	351	3	paramString4	String
    //   191	21	4	i	int
    //   41	260	5	bool1	boolean
    //   1	50	6	bool2	boolean
    //   37	183	7	localObject1	Object
    //   231	5	7	localException	Exception
    //   239	13	7	str1	String
    //   168	81	8	str2	String
    //   175	34	9	arrayOfByte	byte[]
    //   246	11	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   170	177	231	java/lang/Exception
    //   185	193	231	java/lang/Exception
    //   207	216	231	java/lang/Exception
    //   224	228	231	java/lang/Exception
    //   170	177	246	finally
    //   185	193	246	finally
    //   207	216	246	finally
    //   224	228	246	finally
    //   244	246	246	finally
    //   87	96	303	finally
    //   96	106	313	finally
    //   106	162	321	finally
    //   87	96	327	java/lang/Exception
    //   96	106	337	java/lang/Exception
    //   106	162	345	java/lang/Exception
  }
  
  private static byte[] bH(String paramString)
  {
    if (paramString.length() <= 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < paramString.length() / 2)
    {
      arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(i * 2, i * 2 + 1), 16) * 16 + Integer.parseInt(paramString.substring(i * 2 + 1, i * 2 + 2), 16)));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static boolean e(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, "AES/CBC/PKCS7Padding", paramString2, paramString3);
  }
  
  private static byte[] e(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      localCipher.init(2, paramString);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.AESUtils", bk.j(paramArrayOfByte));
    }
    return null;
  }
  
  public static String q(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return "";
    }
    try
    {
      paramString2 = new String(e(bH(paramString1), paramString2));
      return paramString2;
    }
    catch (Exception paramString2)
    {
      y.e("MicroMsg.AESUtils", bk.j(paramString2));
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.a
 * JD-Core Version:    0.7.0.1
 */