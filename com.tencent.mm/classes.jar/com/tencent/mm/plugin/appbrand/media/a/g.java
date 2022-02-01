package com.tencent.mm.plugin.appbrand.media.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

public final class g
{
  /* Error */
  public static String acs(String paramString)
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
    //   27: new 41	com/tencent/mm/vfs/u
    //   30: dup
    //   31: invokestatic 47	com/tencent/mm/audio/mix/h/a:aGD	()Lcom/tencent/mm/vfs/u;
    //   34: aload_1
    //   35: invokespecial 50	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   38: astore_3
    //   39: aload_3
    //   40: invokevirtual 54	com/tencent/mm/vfs/u:jKS	()Z
    //   43: ifeq +25 -> 68
    //   46: ldc 56
    //   48: ldc 58
    //   50: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_3
    //   54: invokevirtual 67	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   57: invokestatic 73	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   60: astore_0
    //   61: ldc 11
    //   63: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: aload_0
    //   69: iconst_0
    //   70: invokestatic 82	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +8 -> 83
    //   78: aload_1
    //   79: arraylength
    //   80: ifne +29 -> 109
    //   83: ldc 11
    //   85: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: ldc 84
    //   90: areturn
    //   91: astore_0
    //   92: ldc 84
    //   94: aload_0
    //   95: ldc 86
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aconst_null
    //   105: astore_1
    //   106: goto -32 -> 74
    //   109: aload_3
    //   110: invokestatic 96	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   113: astore_0
    //   114: aload_0
    //   115: astore_2
    //   116: aload_0
    //   117: aload_1
    //   118: invokevirtual 102	java/io/OutputStream:write	([B)V
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 106	java/io/OutputStream:close	()V
    //   129: aload_3
    //   130: invokevirtual 67	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   133: invokestatic 73	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   136: astore_0
    //   137: ldc 11
    //   139: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_0
    //   143: areturn
    //   144: astore_0
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 106	java/io/OutputStream:close	()V
    //   155: ldc 11
    //   157: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: ldc 84
    //   162: areturn
    //   163: astore_0
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 106	java/io/OutputStream:close	()V
    //   172: ldc 11
    //   174: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_0
    //   178: athrow
    //   179: astore_0
    //   180: goto -51 -> 129
    //   183: astore_0
    //   184: goto -29 -> 155
    //   187: astore_1
    //   188: goto -16 -> 172
    //   191: astore_1
    //   192: goto -45 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramString	String
    //   26	92	1	localObject	Object
    //   187	1	1	localIOException	java.io.IOException
    //   191	1	1	localException	java.lang.Exception
    //   1	168	2	str	String
    //   38	92	3	localu	u
    // Exception table:
    //   from	to	target	type
    //   68	74	91	java/lang/Exception
    //   109	114	144	java/lang/Exception
    //   109	114	163	finally
    //   116	121	163	finally
    //   125	129	179	java/io/IOException
    //   151	155	183	java/io/IOException
    //   168	172	187	java/io/IOException
    //   116	121	191	java/lang/Exception
  }
  
  public static boolean cBA()
  {
    return Build.VERSION.SDK_INT <= 19;
  }
  
  public static String k(f paramf, String paramString)
  {
    AppMethodBeat.i(323280);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
      AppMethodBeat.o(323280);
      return paramString;
    }
    if (paramf.getFileSystem() == null)
    {
      Log.e("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
      AppMethodBeat.o(323280);
      return paramString;
    }
    paramf = paramf.getFileSystem().Wm(paramString);
    if ((paramf == null) || (!paramf.jKS()))
    {
      Log.e("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
      AppMethodBeat.o(323280);
      return paramString;
    }
    paramf = ah.v(paramf.jKT());
    Log.i("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { paramf });
    AppMethodBeat.o(323280);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.g
 * JD-Core Version:    0.7.0.1
 */