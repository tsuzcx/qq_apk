package com.tencent.mm.b;

import java.security.PublicKey;
import javax.crypto.Cipher;

public final class m
{
  public static byte[] a(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPublicKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, PublicKey paramPublicKey, String paramString)
  {
    paramString = Cipher.getInstance(paramString);
    paramString.init(1, paramPublicKey);
    return paramString.doFinal(paramArrayOfByte);
  }
  
  /* Error */
  public static PublicKey u(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 34	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: invokevirtual 40	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   9: aload_1
    //   10: invokevirtual 46	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: astore_2
    //   16: aload_0
    //   17: invokevirtual 52	java/io/InputStream:available	()I
    //   20: newarray byte
    //   22: astore_1
    //   23: aload_0
    //   24: astore_2
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 56	java/io/InputStream:read	([B)I
    //   30: pop
    //   31: aload_0
    //   32: astore_2
    //   33: aload_0
    //   34: invokevirtual 60	java/io/InputStream:close	()V
    //   37: aload_0
    //   38: ifnull +7 -> 45
    //   41: aload_0
    //   42: invokevirtual 60	java/io/InputStream:close	()V
    //   45: new 62	java/security/spec/X509EncodedKeySpec
    //   48: dup
    //   49: new 64	java/lang/String
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 68	java/lang/String:<init>	([B)V
    //   57: ldc 70
    //   59: ldc 72
    //   61: invokevirtual 76	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   64: ldc 78
    //   66: ldc 72
    //   68: invokevirtual 76	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   71: ldc 80
    //   73: ldc 72
    //   75: invokevirtual 76	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   78: iconst_0
    //   79: invokestatic 86	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   82: invokespecial 87	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   85: astore_0
    //   86: ldc 89
    //   88: invokestatic 94	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   91: aload_0
    //   92: invokevirtual 98	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   95: areturn
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 60	java/io/InputStream:close	()V
    //   105: aload_0
    //   106: athrow
    //   107: astore_0
    //   108: goto -63 -> 45
    //   111: astore_1
    //   112: goto -7 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	android.content.Context
    //   0	115	1	paramString	String
    //   1	101	2	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   2	14	96	finally
    //   16	23	96	finally
    //   25	31	96	finally
    //   33	37	96	finally
    //   41	45	107	java/io/IOException
    //   101	105	111	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.b.m
 * JD-Core Version:    0.7.0.1
 */