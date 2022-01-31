package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class o
  extends a
{
  private static final int CTRL_INDEX = 278;
  private static final String NAME = "getFileInfo";
  
  /* Error */
  static String y(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: new 34	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 37	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_0
    //   15: sipush 8192
    //   18: newarray byte
    //   20: astore_3
    //   21: aload_0
    //   22: aload_3
    //   23: invokevirtual 43	java/io/InputStream:read	([B)I
    //   26: istore_1
    //   27: iload_1
    //   28: ifle +59 -> 87
    //   31: aload_2
    //   32: aload_3
    //   33: iconst_0
    //   34: iload_1
    //   35: invokevirtual 47	java/security/MessageDigest:update	([BII)V
    //   38: goto -17 -> 21
    //   41: astore_2
    //   42: aload_0
    //   43: invokevirtual 50	java/io/InputStream:close	()V
    //   46: ldc 52
    //   48: areturn
    //   49: astore_0
    //   50: ldc 54
    //   52: ldc 56
    //   54: iconst_1
    //   55: anewarray 58	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: aastore
    //   62: invokestatic 64	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: ldc 52
    //   67: areturn
    //   68: astore_0
    //   69: ldc 54
    //   71: ldc 66
    //   73: iconst_1
    //   74: anewarray 58	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: invokestatic 64	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc 52
    //   86: areturn
    //   87: new 68	java/math/BigInteger
    //   90: dup
    //   91: iconst_1
    //   92: aload_2
    //   93: invokevirtual 72	java/security/MessageDigest:digest	()[B
    //   96: invokespecial 75	java/math/BigInteger:<init>	(I[B)V
    //   99: bipush 16
    //   101: invokevirtual 79	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   104: astore_2
    //   105: aload_0
    //   106: invokevirtual 50	java/io/InputStream:close	()V
    //   109: aload_2
    //   110: areturn
    //   111: astore_0
    //   112: ldc 54
    //   114: ldc 81
    //   116: iconst_1
    //   117: anewarray 58	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: aastore
    //   124: invokestatic 64	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: areturn
    //   129: astore_0
    //   130: ldc 54
    //   132: ldc 81
    //   134: iconst_1
    //   135: anewarray 58	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: aastore
    //   142: invokestatic 64	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: ldc 52
    //   147: areturn
    //   148: astore_2
    //   149: aload_0
    //   150: invokevirtual 50	java/io/InputStream:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore_0
    //   156: ldc 54
    //   158: ldc 81
    //   160: iconst_1
    //   161: anewarray 58	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_0
    //   167: aastore
    //   168: invokestatic 64	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -18 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramFile	java.io.File
    //   26	9	1	i	int
    //   5	27	2	localMessageDigest	java.security.MessageDigest
    //   41	52	2	localIOException	java.io.IOException
    //   104	24	2	str	String
    //   148	6	2	localObject	java.lang.Object
    //   20	13	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	27	41	java/io/IOException
    //   31	38	41	java/io/IOException
    //   87	105	41	java/io/IOException
    //   0	6	49	java/security/NoSuchAlgorithmException
    //   6	15	68	java/io/FileNotFoundException
    //   105	109	111	java/io/IOException
    //   42	46	129	java/io/IOException
    //   21	27	148	finally
    //   31	38	148	finally
    //   87	105	148	finally
    //   149	153	155	java/io/IOException
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("filePath", "");
    if (!"sha1".equalsIgnoreCase(paramJSONObject.optString("digestAlgorithm", "md5"))) {}
    for (paramJSONObject = "md5"; bk.bl(str); paramJSONObject = "sha1")
    {
      paramc.C(paramInt, h("fail:invalid data", null));
      return;
    }
    e.post(new o.1(this, paramc, str, paramInt, paramJSONObject), "AppBrandJsApiGetFileInfo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.o
 * JD-Core Version:    0.7.0.1
 */