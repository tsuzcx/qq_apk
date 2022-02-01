package com.tencent.mm.app;

import android.app.Application;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.splash.m.a;
import com.tencent.mm.splash.o.a;
import com.tencent.mm.vending.h.d;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class WeChatSplashStartup
  implements m.a
{
  private Application app;
  com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  private void b(final o.a parama)
  {
    AppMethodBeat.i(160091);
    com.tencent.mm.f.a.bw(this.app);
    com.tencent.mm.blink.a.kJ(2);
    boolean bool;
    Object localObject;
    if (parama == null)
    {
      bool = true;
      this.profile.onCreate();
      if ((!this.profile.xf(":tools")) && (!this.profile.xf(":toolsmp"))) {
        break label216;
      }
      localObject = new ah();
    }
    for (;;)
    {
      this.profile.gBe.a((com.tencent.mm.kernel.a.b)localObject);
      if (!bool)
      {
        com.tencent.mm.splash.h.fnp();
        new com.tencent.mm.sdk.b.c() {}.alive();
        new com.tencent.mm.sdk.b.c() {}.alive();
      }
      com.tencent.mm.kernel.g.ajD().a(cf(bool));
      com.tencent.mm.splash.h.a(new WeChatSplashStartup.5(this));
      com.tencent.mm.splash.h.a(y.cUN);
      com.tencent.mm.kernel.g.ajD().a(new WeChatSplashStartup.6(this, bool, parama));
      com.tencent.mm.kernel.g.ajD().a(new WeChatSplashStartup.7(this));
      com.tencent.mm.kernel.g.ajD().a(new WeChatSplashStartup.8(this));
      com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
      {
        public final void MP()
        {
          AppMethodBeat.i(160117);
          b.c(WeChatSplashStartup.b(WeChatSplashStartup.this));
          AppMethodBeat.o(160117);
        }
        
        public final void cg(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
      {
        private final az cUH;
        private final int cVA;
        private final int cVB;
        private final int cVC;
        private final int cVD;
        private final int cVE;
        private final int cVF;
        private final int cVr;
        private final int cVy;
        private final int cVz;
        
        /* Error */
        private static void e(File paramAnonymousFile1, File paramAnonymousFile2)
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
          //   88: invokestatic 171	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
          //   91: aload_3
          //   92: invokestatic 171	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
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
          //   124: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   127: aload 4
          //   129: invokestatic 171	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
          //   132: aload_3
          //   133: invokestatic 171	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
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
          //   0	156	0	paramAnonymousFile1	File
          //   0	156	1	paramAnonymousFile2	File
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
        
        public final void MP()
        {
          AppMethodBeat.i(160116);
          if (!aj.cmR())
          {
            AppMethodBeat.o(160116);
            return;
          }
          com.tencent.e.h.LTJ.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221758);
              File localFile1 = new File(com.tencent.mm.loader.j.b.arQ(), "/MicroMsg/WeiXin/");
              File localFile2 = new File(com.tencent.mm.loader.j.b.arQ(), "/MicroMsg/WeChat/");
              File localFile3 = new File(com.tencent.mm.loader.j.b.asf());
              if (localFile1.exists())
              {
                WeChatSplashStartup.10.f(localFile1, localFile3);
                if (localFile3.exists()) {
                  break label112;
                }
                WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 170, 174);
              }
              while (localFile2.exists())
              {
                WeChatSplashStartup.10.f(localFile2, localFile3);
                if (!localFile3.exists())
                {
                  WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 171, 177);
                  AppMethodBeat.o(221758);
                  return;
                  label112:
                  if (!localFile1.exists()) {
                    WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 170, 172);
                  } else {
                    WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 170, 173);
                  }
                }
                else
                {
                  if (!localFile2.exists())
                  {
                    WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 171, 175);
                    AppMethodBeat.o(221758);
                    return;
                  }
                  WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 171, 176);
                }
              }
              AppMethodBeat.o(221758);
            }
          }, "FixMigrate");
          AppMethodBeat.o(160116);
        }
        
        public final void cg(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(160091);
      return;
      bool = false;
      break;
      label216:
      if ((this.profile.xg(":appbrand")) && (fv(com.tencent.mm.plugin.appbrand.api.a.jCL))) {
        localObject = new c();
      } else {
        localObject = new i();
      }
    }
  }
  
  private d cf(boolean paramBoolean)
  {
    AppMethodBeat.i(160092);
    if (!paramBoolean)
    {
      Object localObject = p.LY();
      ((p)localObject).LZ();
      com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
      {
        public final void MP()
        {
          AppMethodBeat.i(221127);
          this.cVG.cTP.quit();
          com.tencent.mm.kernel.g.ajD().b(this);
          AppMethodBeat.o(221127);
        }
        
        public final void cg(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.a.c.ajP().f(((p)localObject).cTP.getLooper());
      localObject = ((p)localObject).cTQ;
      AppMethodBeat.o(160092);
      return localObject;
    }
    AppMethodBeat.o(160092);
    return null;
  }
  
  private static boolean fv(String paramString)
  {
    AppMethodBeat.i(177509);
    if (paramString == null)
    {
      AppMethodBeat.o(177509);
      return false;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(177509);
      return true;
    }
    AppMethodBeat.o(177509);
    return false;
  }
  
  public final void MO()
  {
    AppMethodBeat.i(160090);
    b(null);
    AppMethodBeat.o(160090);
  }
  
  public final void a(o.a parama)
  {
    AppMethodBeat.i(160089);
    b(parama);
    AppMethodBeat.o(160089);
  }
  
  public final void b(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(160088);
    this.app = paramApplication;
    this.thisProcess = paramString;
    this.profile = ai.cVo;
    com.tencent.mm.kernel.g.a(this.profile);
    paramApplication = this.profile;
    paramString = this.app;
    paramApplication.gEf.a(new h.6(paramApplication, paramString));
    AppMethodBeat.o(160088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup
 * JD-Core Version:    0.7.0.1
 */