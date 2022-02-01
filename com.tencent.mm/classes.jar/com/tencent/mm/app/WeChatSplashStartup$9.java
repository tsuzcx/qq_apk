package com.tencent.mm.app;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ba;
import java.io.File;
import java.util.concurrent.TimeUnit;

final class WeChatSplashStartup$9
  implements g
{
  private final int cWA;
  private final int cWB;
  private final int cWC;
  private final ba cWt;
  private final int cWu;
  private final int cWv;
  private final int cWw;
  private final int cWx;
  private final int cWy;
  private final int cWz;
  
  WeChatSplashStartup$9(WeChatSplashStartup paramWeChatSplashStartup)
  {
    AppMethodBeat.i(224054);
    this.cWt = new ba("FixMigrate", TimeUnit.DAYS.toMillis(1L));
    this.cWu = 1315;
    this.cWv = 170;
    this.cWw = 171;
    this.cWx = 172;
    this.cWy = 173;
    this.cWz = 174;
    this.cWA = 175;
    this.cWB = 176;
    this.cWC = 177;
    AppMethodBeat.o(224054);
  }
  
  /* Error */
  private static void e(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 128	java/io/File:exists	()Z
    //   9: ifne +11 -> 20
    //   12: aload_1
    //   13: invokevirtual 132	java/io/File:getParentFile	()Ljava/io/File;
    //   16: invokevirtual 135	java/io/File:mkdirs	()Z
    //   19: pop
    //   20: new 137	java/io/BufferedInputStream
    //   23: dup
    //   24: new 139	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: invokespecial 145	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_3
    //   36: new 147	java/io/BufferedOutputStream
    //   39: dup
    //   40: new 149	java/io/FileOutputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 153	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: astore 4
    //   53: sipush 4096
    //   56: newarray byte
    //   58: astore 5
    //   60: aload_3
    //   61: aload 5
    //   63: invokevirtual 159	java/io/InputStream:read	([B)I
    //   66: istore_2
    //   67: iload_2
    //   68: ifle +34 -> 102
    //   71: aload 4
    //   73: aload 5
    //   75: iconst_0
    //   76: iload_2
    //   77: invokevirtual 165	java/io/OutputStream:write	([BII)V
    //   80: goto -20 -> 60
    //   83: astore_0
    //   84: aload 4
    //   86: astore_1
    //   87: aload_1
    //   88: invokestatic 171	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   91: aload_3
    //   92: invokestatic 171	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   95: ldc 122
    //   97: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: athrow
    //   102: ldc 173
    //   104: ldc 175
    //   106: iconst_2
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: invokevirtual 178	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: aload_1
    //   120: invokevirtual 178	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 183	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload 4
    //   129: invokestatic 171	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   132: aload_3
    //   133: invokestatic 171	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   136: ldc 122
    //   138: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: return
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_3
    //   147: goto -60 -> 87
    //   150: astore_0
    //   151: aconst_null
    //   152: astore_1
    //   153: goto -66 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramFile1	File
    //   0	156	1	paramFile2	File
    //   66	11	2	i	int
    //   35	112	3	localBufferedInputStream	java.io.BufferedInputStream
    //   51	77	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   58	16	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   53	60	83	finally
    //   60	67	83	finally
    //   71	80	83	finally
    //   102	127	83	finally
    //   20	36	142	finally
    //   36	53	150	finally
  }
  
  public final void ML()
  {
    AppMethodBeat.i(160116);
    if (!ak.coh())
    {
      AppMethodBeat.o(160116);
      return;
    }
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224058);
        File localFile1 = new File(b.asf(), "/MicroMsg/WeiXin/");
        File localFile2 = new File(b.asf(), "/MicroMsg/WeChat/");
        File localFile3 = new File(b.asu());
        if (localFile1.exists())
        {
          WeChatSplashStartup.9.f(localFile1, localFile3);
          if (localFile3.exists()) {
            break label112;
          }
          WeChatSplashStartup.9.a(WeChatSplashStartup.9.this, 170, 174);
        }
        while (localFile2.exists())
        {
          WeChatSplashStartup.9.f(localFile2, localFile3);
          if (!localFile3.exists())
          {
            WeChatSplashStartup.9.a(WeChatSplashStartup.9.this, 171, 177);
            AppMethodBeat.o(224058);
            return;
            label112:
            if (!localFile1.exists()) {
              WeChatSplashStartup.9.a(WeChatSplashStartup.9.this, 170, 172);
            } else {
              WeChatSplashStartup.9.a(WeChatSplashStartup.9.this, 170, 173);
            }
          }
          else
          {
            if (!localFile2.exists())
            {
              WeChatSplashStartup.9.a(WeChatSplashStartup.9.this, 171, 175);
              AppMethodBeat.o(224058);
              return;
            }
            WeChatSplashStartup.9.a(WeChatSplashStartup.9.this, 171, 176);
          }
        }
        AppMethodBeat.o(224058);
      }
    }, "FixMigrate");
    AppMethodBeat.o(160116);
  }
  
  public final void ch(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.9
 * JD-Core Version:    0.7.0.1
 */