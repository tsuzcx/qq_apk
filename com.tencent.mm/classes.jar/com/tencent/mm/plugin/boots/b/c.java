package com.tencent.mm.plugin.boots.b;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public final class c
{
  private static final char[] bsU = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private String hXW = null;
  private final HashMap<String, String> hXX;
  private final HashMap<String, String> hXY;
  
  public c(Context paramContext)
  {
    try
    {
      this.hXW = ac(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray());
      if (this.hXW == null) {
        throw new a("LuggageSecurityChecker get public key md5 is null");
      }
    }
    catch (Exception paramContext)
    {
      throw new a("LuggageSecurityChecker init public key fail", paramContext);
    }
    finally
    {
      SharePatchFileUtil.S(null);
    }
    SharePatchFileUtil.S(null);
    this.hXX = new HashMap();
    this.hXY = new HashMap();
  }
  
  private static void S(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof Closeable)) {
      try
      {
        ((Closeable)paramObject).close();
        return;
      }
      catch (Throwable paramObject)
      {
        return;
      }
    }
    if ((Build.VERSION.SDK_INT >= 19) && ((paramObject instanceof AutoCloseable))) {
      try
      {
        ((AutoCloseable)paramObject).close();
        return;
      }
      catch (Throwable paramObject)
      {
        return;
      }
    }
    if ((paramObject instanceof ZipFile)) {
      try
      {
        ((ZipFile)paramObject).close();
        return;
      }
      catch (Throwable paramObject)
      {
        return;
      }
    }
    throw new IllegalArgumentException("obj: " + paramObject + " cannot be closed.");
  }
  
  private static String a(JarFile paramJarFile, JarEntry paramJarEntry)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramJarEntry = paramJarFile.getInputStream(paramJarEntry);
      paramJarFile = new byte[16384];
      paramJarEntry = new BufferedInputStream(paramJarEntry);
      try
      {
        for (;;)
        {
          int i = paramJarEntry.read(paramJarFile);
          if (i <= 0) {
            break;
          }
          localStringBuilder.append(new String(paramJarFile, 0, i));
        }
        S(paramJarEntry);
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        paramJarEntry = null;
      }
    }
    throw paramJarFile;
    S(paramJarEntry);
    return localStringBuilder.toString();
  }
  
  private boolean a(File paramFile, Certificate[] paramArrayOfCertificate)
  {
    if (paramArrayOfCertificate.length > 0) {
      try
      {
        int i = paramArrayOfCertificate.length - 1;
        while (i >= 0)
        {
          boolean bool = this.hXW.equals(ac(paramArrayOfCertificate[i].getEncoded()));
          if (bool) {
            return true;
          }
          i -= 1;
        }
        return false;
      }
      catch (Exception paramArrayOfCertificate)
      {
        y.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", paramArrayOfCertificate, "LuggageSecurityChecker check file %s", new Object[] { paramFile });
      }
    }
  }
  
  private static String ac(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      int k = paramArrayOfByte.length;
      localObject = new char[k * 2];
      int i = 0;
      int m;
      for (int j = 0; i < k; j = m + 1)
      {
        int n = paramArrayOfByte[i];
        m = j + 1;
        localObject[j] = bsU[(n >>> 4 & 0xF)];
        localObject[m] = bsU[(n & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  public final boolean B(File paramFile)
  {
    // Byte code:
    //   0: new 142	java/util/jar/JarFile
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 208	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 212	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   13: astore 4
    //   15: aload 4
    //   17: invokeinterface 218 1 0
    //   22: ifeq +99 -> 121
    //   25: aload 4
    //   27: invokeinterface 222 1 0
    //   32: checkcast 224	java/util/jar/JarEntry
    //   35: astore 5
    //   37: aload 5
    //   39: ifnull -24 -> 15
    //   42: aload 5
    //   44: invokevirtual 227	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   47: astore 6
    //   49: aload 6
    //   51: ldc 229
    //   53: invokevirtual 233	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   56: ifne -41 -> 15
    //   59: aload_0
    //   60: getfield 96	com/tencent/mm/plugin/boots/b/c:hXX	Ljava/util/HashMap;
    //   63: aload 6
    //   65: aload_3
    //   66: aload 5
    //   68: invokestatic 235	com/tencent/mm/plugin/boots/b/c:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)Ljava/lang/String;
    //   71: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload 5
    //   77: invokevirtual 243	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnull +15 -> 99
    //   87: aload_0
    //   88: aload_1
    //   89: aload 5
    //   91: invokespecial 245	com/tencent/mm/plugin/boots/b/c:a	(Ljava/io/File;[Ljava/security/cert/Certificate;)Z
    //   94: istore_2
    //   95: iload_2
    //   96: ifne -81 -> 15
    //   99: aload_3
    //   100: invokevirtual 246	java/util/jar/JarFile:close	()V
    //   103: iconst_0
    //   104: ireturn
    //   105: astore_1
    //   106: ldc 175
    //   108: aload_1
    //   109: ldc 248
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 183	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: goto -15 -> 103
    //   121: aload_3
    //   122: invokevirtual 246	java/util/jar/JarFile:close	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_1
    //   128: ldc 175
    //   130: aload_1
    //   131: ldc 248
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 183	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: goto -15 -> 125
    //   143: astore 4
    //   145: aconst_null
    //   146: astore_3
    //   147: ldc 175
    //   149: aload 4
    //   151: ldc 250
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 183	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: new 75	com/tencent/mm/plugin/boots/b/a
    //   163: dup
    //   164: ldc 252
    //   166: iconst_2
    //   167: anewarray 4	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_1
    //   173: invokevirtual 258	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload_1
    //   180: invokevirtual 262	java/io/File:length	()J
    //   183: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: invokestatic 272	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: aload 4
    //   192: invokespecial 85	com/tencent/mm/plugin/boots/b/a:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: athrow
    //   196: astore_1
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 246	java/util/jar/JarFile:close	()V
    //   205: aload_1
    //   206: athrow
    //   207: astore_3
    //   208: ldc 175
    //   210: aload_3
    //   211: ldc 248
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 183	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: goto -15 -> 205
    //   223: astore_1
    //   224: aconst_null
    //   225: astore_3
    //   226: goto -29 -> 197
    //   229: astore_1
    //   230: goto -33 -> 197
    //   233: astore 4
    //   235: goto -88 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	c
    //   0	238	1	paramFile	File
    //   94	2	2	bool	boolean
    //   8	194	3	localJarFile	JarFile
    //   207	4	3	localIOException	java.io.IOException
    //   225	1	3	localObject1	Object
    //   13	13	4	localEnumeration	java.util.Enumeration
    //   143	48	4	localException1	Exception
    //   233	1	4	localException2	Exception
    //   35	55	5	localObject2	Object
    //   47	17	6	str	String
    // Exception table:
    //   from	to	target	type
    //   99	103	105	java/io/IOException
    //   121	125	127	java/io/IOException
    //   0	9	143	java/lang/Exception
    //   147	196	196	finally
    //   201	205	207	java/io/IOException
    //   0	9	223	finally
    //   9	15	229	finally
    //   15	37	229	finally
    //   42	82	229	finally
    //   87	95	229	finally
    //   9	15	233	java/lang/Exception
    //   15	37	233	java/lang/Exception
    //   42	82	233	java/lang/Exception
    //   87	95	233	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b.c
 * JD-Core Version:    0.7.0.1
 */