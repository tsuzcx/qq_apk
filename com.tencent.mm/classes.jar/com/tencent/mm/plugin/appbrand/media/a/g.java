package com.tencent.mm.plugin.appbrand.media.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;

public final class g
{
  /* Error */
  public static String ajr(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 11
    //   4: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 19	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 21
    //   13: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 31	java/lang/String:hashCode	()I
    //   20: invokevirtual 35	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore_1
    //   27: new 41	com/tencent/mm/vfs/q
    //   30: dup
    //   31: invokestatic 47	com/tencent/mm/audio/mix/h/a:aeF	()Lcom/tencent/mm/vfs/q;
    //   34: aload_1
    //   35: invokespecial 50	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   38: astore_3
    //   39: aload_3
    //   40: invokevirtual 54	com/tencent/mm/vfs/q:ifE	()Z
    //   43: ifeq +22 -> 65
    //   46: ldc 56
    //   48: ldc 58
    //   50: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_3
    //   54: invokevirtual 66	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   57: astore_0
    //   58: ldc 11
    //   60: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: aload_0
    //   66: iconst_0
    //   67: invokestatic 75	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +8 -> 80
    //   75: aload_1
    //   76: arraylength
    //   77: ifne +29 -> 106
    //   80: ldc 11
    //   82: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: ldc 77
    //   87: areturn
    //   88: astore_0
    //   89: ldc 77
    //   91: aload_0
    //   92: ldc 79
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aconst_null
    //   102: astore_1
    //   103: goto -32 -> 71
    //   106: aload_3
    //   107: invokestatic 89	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   110: astore_0
    //   111: aload_0
    //   112: astore_2
    //   113: aload_0
    //   114: aload_1
    //   115: invokevirtual 95	java/io/OutputStream:write	([B)V
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 99	java/io/OutputStream:close	()V
    //   126: aload_3
    //   127: invokevirtual 66	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   130: astore_0
    //   131: ldc 11
    //   133: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_0
    //   137: areturn
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 99	java/io/OutputStream:close	()V
    //   149: ldc 11
    //   151: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: ldc 77
    //   156: areturn
    //   157: astore_0
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 99	java/io/OutputStream:close	()V
    //   166: ldc 11
    //   168: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: goto -48 -> 126
    //   177: astore_0
    //   178: goto -29 -> 149
    //   181: astore_1
    //   182: goto -16 -> 166
    //   185: astore_1
    //   186: goto -45 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString	String
    //   26	89	1	localObject	Object
    //   181	1	1	localIOException	java.io.IOException
    //   185	1	1	localException	java.lang.Exception
    //   1	162	2	str	String
    //   38	89	3	localq	q
    // Exception table:
    //   from	to	target	type
    //   65	71	88	java/lang/Exception
    //   106	111	138	java/lang/Exception
    //   106	111	157	finally
    //   113	118	157	finally
    //   122	126	173	java/io/IOException
    //   145	149	177	java/io/IOException
    //   162	166	181	java/io/IOException
    //   113	118	185	java/lang/Exception
  }
  
  public static boolean cbg()
  {
    return Build.VERSION.SDK_INT <= 19;
  }
  
  public static String l(e parame, String paramString)
  {
    AppMethodBeat.i(225914);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
      AppMethodBeat.o(225914);
      return paramString;
    }
    if (parame.getFileSystem() == null)
    {
      Log.e("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
      AppMethodBeat.o(225914);
      return paramString;
    }
    parame = parame.getFileSystem().adL(paramString);
    if ((parame == null) || (!parame.ifE()))
    {
      Log.e("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
      AppMethodBeat.o(225914);
      return paramString;
    }
    parame = parame.bOF();
    Log.i("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { parame });
    AppMethodBeat.o(225914);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.g
 * JD-Core Version:    0.7.0.1
 */