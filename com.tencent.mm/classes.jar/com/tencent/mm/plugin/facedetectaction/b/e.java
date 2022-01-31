package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  String jWi;
  float jWj;
  int jWp;
  int jWq;
  e.a jWu;
  int orientation;
  
  public e(String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jWi = paramString;
    this.jWj = paramFloat;
    this.orientation = paramInt1;
    this.jWp = paramInt2;
    this.jWq = paramInt3;
    y.i("MicroMsg.FaceCheckVideoRecordMgr", "create FaceCheckVideoRecordMgr, reductionRatio: %s, orientation: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  /* Error */
  static void N(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 61	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 61	java/io/File
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_1
    //   19: invokevirtual 68	java/io/File:exists	()Z
    //   22: ifeq +260 -> 282
    //   25: aload_1
    //   26: invokevirtual 71	java/io/File:isFile	()Z
    //   29: ifeq +253 -> 282
    //   32: aload_2
    //   33: invokevirtual 75	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 68	java/io/File:exists	()Z
    //   39: ifne +11 -> 50
    //   42: aload_2
    //   43: invokevirtual 75	java/io/File:getParentFile	()Ljava/io/File;
    //   46: invokevirtual 78	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload_2
    //   51: invokevirtual 81	java/io/File:createNewFile	()Z
    //   54: pop
    //   55: new 83	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: astore 4
    //   65: new 88	java/io/FileOutputStream
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore_2
    //   74: new 91	javax/crypto/spec/SecretKeySpec
    //   77: dup
    //   78: new 91	javax/crypto/spec/SecretKeySpec
    //   81: dup
    //   82: aload_0
    //   83: ldc 93
    //   85: invokevirtual 99	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   88: ldc 101
    //   90: invokespecial 104	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   93: invokeinterface 110 1 0
    //   98: ldc 101
    //   100: invokespecial 104	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   103: astore_1
    //   104: ldc 112
    //   106: invokestatic 118	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   109: astore 5
    //   111: aload 5
    //   113: iconst_1
    //   114: aload_1
    //   115: new 120	javax/crypto/spec/IvParameterSpec
    //   118: dup
    //   119: aload_0
    //   120: invokevirtual 122	java/lang/String:getBytes	()[B
    //   123: invokespecial 125	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   126: invokevirtual 129	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   129: new 131	javax/crypto/CipherInputStream
    //   132: dup
    //   133: aload 4
    //   135: aload 5
    //   137: invokespecial 134	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   140: astore_1
    //   141: aload_2
    //   142: astore 5
    //   144: aload 4
    //   146: astore 6
    //   148: aload_1
    //   149: astore_0
    //   150: sipush 1024
    //   153: newarray byte
    //   155: astore 7
    //   157: aload_2
    //   158: astore 5
    //   160: aload 4
    //   162: astore 6
    //   164: aload_1
    //   165: astore_0
    //   166: aload_1
    //   167: aload 7
    //   169: invokevirtual 138	javax/crypto/CipherInputStream:read	([B)I
    //   172: istore_3
    //   173: iload_3
    //   174: iconst_m1
    //   175: if_icmpeq +94 -> 269
    //   178: aload_2
    //   179: astore 5
    //   181: aload 4
    //   183: astore 6
    //   185: aload_1
    //   186: astore_0
    //   187: aload_2
    //   188: aload 7
    //   190: iconst_0
    //   191: iload_3
    //   192: invokevirtual 144	java/io/OutputStream:write	([BII)V
    //   195: aload_2
    //   196: astore 5
    //   198: aload 4
    //   200: astore 6
    //   202: aload_1
    //   203: astore_0
    //   204: aload_2
    //   205: invokevirtual 147	java/io/OutputStream:flush	()V
    //   208: goto -51 -> 157
    //   211: astore 5
    //   213: aload_1
    //   214: astore_0
    //   215: aload 5
    //   217: astore_1
    //   218: aload_2
    //   219: astore 5
    //   221: aload 4
    //   223: astore 6
    //   225: aload_1
    //   226: athrow
    //   227: astore 7
    //   229: aload_0
    //   230: astore_2
    //   231: aload 6
    //   233: astore 4
    //   235: aload 5
    //   237: astore_1
    //   238: aload 7
    //   240: astore_0
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 150	java/io/OutputStream:close	()V
    //   249: aload_2
    //   250: ifnull +7 -> 257
    //   253: aload_2
    //   254: invokevirtual 151	javax/crypto/CipherInputStream:close	()V
    //   257: aload 4
    //   259: ifnull +8 -> 267
    //   262: aload 4
    //   264: invokevirtual 154	java/io/InputStream:close	()V
    //   267: aload_0
    //   268: athrow
    //   269: aload_2
    //   270: invokevirtual 150	java/io/OutputStream:close	()V
    //   273: aload_1
    //   274: invokevirtual 151	javax/crypto/CipherInputStream:close	()V
    //   277: aload 4
    //   279: invokevirtual 154	java/io/InputStream:close	()V
    //   282: return
    //   283: astore_0
    //   284: aconst_null
    //   285: astore_1
    //   286: aconst_null
    //   287: astore 4
    //   289: aconst_null
    //   290: astore_2
    //   291: goto -50 -> 241
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_1
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -58 -> 241
    //   302: astore_0
    //   303: aconst_null
    //   304: astore 5
    //   306: aload_2
    //   307: astore_1
    //   308: aload 5
    //   310: astore_2
    //   311: goto -70 -> 241
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_2
    //   317: aconst_null
    //   318: astore 4
    //   320: aconst_null
    //   321: astore_0
    //   322: goto -104 -> 218
    //   325: astore_1
    //   326: aconst_null
    //   327: astore_2
    //   328: aconst_null
    //   329: astore_0
    //   330: goto -112 -> 218
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_0
    //   336: goto -118 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramString1	String
    //   0	339	1	paramString2	String
    //   0	339	2	paramString3	String
    //   172	20	3	i	int
    //   63	256	4	localObject1	Object
    //   109	88	5	localObject2	Object
    //   211	5	5	localException	java.lang.Exception
    //   219	90	5	str	String
    //   146	86	6	localObject3	Object
    //   155	34	7	arrayOfByte	byte[]
    //   227	12	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   150	157	211	java/lang/Exception
    //   166	173	211	java/lang/Exception
    //   187	195	211	java/lang/Exception
    //   204	208	211	java/lang/Exception
    //   150	157	227	finally
    //   166	173	227	finally
    //   187	195	227	finally
    //   204	208	227	finally
    //   225	227	227	finally
    //   55	65	283	finally
    //   65	74	294	finally
    //   74	141	302	finally
    //   55	65	314	java/lang/Exception
    //   65	74	325	java/lang/Exception
    //   74	141	333	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e
 * JD-Core Version:    0.7.0.1
 */