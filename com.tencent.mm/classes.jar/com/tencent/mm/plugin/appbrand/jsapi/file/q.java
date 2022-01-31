package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class q
  extends a
{
  private static final int CTRL_INDEX = 278;
  private static final String NAME = "getFileInfo";
  
  /* Error */
  static String F(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 33
    //   7: invokestatic 39	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   10: astore_2
    //   11: new 41	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_0
    //   20: sipush 8192
    //   23: newarray byte
    //   25: astore_3
    //   26: aload_0
    //   27: aload_3
    //   28: invokevirtual 50	java/io/InputStream:read	([B)I
    //   31: istore_1
    //   32: iload_1
    //   33: ifle +74 -> 107
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: iload_1
    //   40: invokevirtual 54	java/security/MessageDigest:update	([BII)V
    //   43: goto -17 -> 26
    //   46: astore_2
    //   47: aload_0
    //   48: invokevirtual 57	java/io/InputStream:close	()V
    //   51: ldc 25
    //   53: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: ldc 62
    //   58: areturn
    //   59: astore_0
    //   60: ldc 64
    //   62: ldc 66
    //   64: iconst_1
    //   65: anewarray 68	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_0
    //   71: aastore
    //   72: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: ldc 25
    //   77: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: ldc 62
    //   82: areturn
    //   83: astore_0
    //   84: ldc 64
    //   86: ldc 76
    //   88: iconst_1
    //   89: anewarray 68	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_0
    //   95: aastore
    //   96: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: ldc 25
    //   101: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: ldc 62
    //   106: areturn
    //   107: aload_2
    //   108: invokevirtual 80	java/security/MessageDigest:digest	()[B
    //   111: invokestatic 84	com/tencent/mm/plugin/appbrand/jsapi/file/q:bytesToHexString	([B)Ljava/lang/String;
    //   114: astore_2
    //   115: aload_0
    //   116: invokevirtual 57	java/io/InputStream:close	()V
    //   119: ldc 25
    //   121: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_2
    //   125: areturn
    //   126: astore_0
    //   127: ldc 64
    //   129: ldc 86
    //   131: iconst_1
    //   132: anewarray 68	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: aastore
    //   139: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: goto -23 -> 119
    //   145: astore_0
    //   146: ldc 64
    //   148: ldc 86
    //   150: iconst_1
    //   151: anewarray 68	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_0
    //   157: aastore
    //   158: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: goto -110 -> 51
    //   164: astore_2
    //   165: aload_0
    //   166: invokevirtual 57	java/io/InputStream:close	()V
    //   169: ldc 25
    //   171: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_2
    //   175: athrow
    //   176: astore_0
    //   177: ldc 64
    //   179: ldc 86
    //   181: iconst_1
    //   182: anewarray 68	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: aastore
    //   189: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: goto -23 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramFile	java.io.File
    //   31	9	1	i	int
    //   10	27	2	localMessageDigest	java.security.MessageDigest
    //   46	62	2	localIOException	java.io.IOException
    //   114	11	2	str	String
    //   164	11	2	localObject	java.lang.Object
    //   25	13	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	32	46	java/io/IOException
    //   36	43	46	java/io/IOException
    //   107	115	46	java/io/IOException
    //   5	11	59	java/security/NoSuchAlgorithmException
    //   11	20	83	java/io/FileNotFoundException
    //   115	119	126	java/io/IOException
    //   47	51	145	java/io/IOException
    //   26	32	164	finally
    //   36	43	164	finally
    //   107	115	164	finally
    //   165	169	176	java/io/IOException
  }
  
  private static String bytesToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102787);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(102787);
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toLowerCase());
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(102787);
    return paramArrayOfByte;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(102785);
    String str = paramJSONObject.optString("filePath", "");
    if (!"sha1".equalsIgnoreCase(paramJSONObject.optString("digestAlgorithm", "md5"))) {}
    for (paramJSONObject = "md5"; bo.isNullOrNil(str); paramJSONObject = "sha1")
    {
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(102785);
      return;
    }
    d.post(new q.1(this, paramc, str, paramInt, paramJSONObject), "AppBrandJsApiGetFileInfo");
    AppMethodBeat.o(102785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.q
 * JD-Core Version:    0.7.0.1
 */