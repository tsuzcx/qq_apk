package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.on;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.splash.o.a;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class WeChatSplashStartup
  implements com.tencent.mm.splash.m.a
{
  private Application app;
  com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  private void b(final o.a parama)
  {
    AppMethodBeat.i(160091);
    com.tencent.mm.f.a.bx(this.app);
    com.tencent.mm.blink.a.km(2);
    final boolean bool;
    Object localObject;
    if (parama == null)
    {
      bool = true;
      this.profile.onCreate();
      if ((!this.profile.up(":tools")) && (!this.profile.up(":toolsmp"))) {
        break label230;
      }
      localObject = new ah();
    }
    for (;;)
    {
      this.profile.ghu.a((com.tencent.mm.kernel.a.b)localObject);
      if (!bool)
      {
        com.tencent.mm.splash.h.eXF();
        new com.tencent.mm.sdk.b.c() {}.alive();
        new com.tencent.mm.sdk.b.c() {}.alive();
      }
      com.tencent.mm.kernel.g.agS().a(ce(bool));
      com.tencent.mm.splash.h.a(new WeChatSplashStartup.5(this));
      com.tencent.mm.splash.h.a(y.cJA);
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(160049);
          com.tencent.mm.kernel.g.agS().b(this);
          if (!bool)
          {
            parama.done();
            AppMethodBeat.o(160049);
            return;
          }
          com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
          Object localObject = com.tencent.mm.splash.a.eXx();
          if (!new e((String)localObject).exists())
          {
            com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
            AppMethodBeat.o(160049);
            return;
          }
          localObject = new e((String)localObject + "/main-process-blocking");
          if (((e)localObject).exists()) {
            com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[] { Boolean.valueOf(((e)localObject).delete()) });
          }
          AppMethodBeat.o(160049);
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(160075);
          com.tencent.mm.kernel.g.agS().b(this);
          com.tencent.mm.blink.a.Le();
          WeChatSplashStartup.a(WeChatSplashStartup.this);
          com.tencent.mm.vfs.p.btF();
          ExtStorageMigrateMonitor.eTD();
          com.tencent.mm.sdcard_migrate.b.eUa();
          ExtStorageMigrateRoutine.triggerMediaRescanOnDemand();
          if (WeChatSplashStartup.this.profile.ahL()) {}
          try
          {
            com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
            if (WeChatSplashStartup.this.profile.ahL())
            {
              com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.agP();
              ac.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[] { Boolean.valueOf(locala.afY()), Integer.valueOf(locala.ggK), bs.eWi() });
              if ((locala.afY()) && (locala.ggK != 0))
              {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, locala.ggK);
                ac.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(locala.ggK), bs.eWi() });
                locala.ggK = 0;
              }
            }
            AppMethodBeat.o(160075);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.WeChatSplashStartup", localException, "%s", new Object[] { localException.getMessage() });
            }
          }
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(160071);
          if (!com.tencent.mm.sdk.platformtools.ai.eVc()) {
            ag.a.cJV.KV();
          }
          if (com.tencent.mm.sdk.platformtools.ai.cin()) {
            x.execute();
          }
          AppMethodBeat.o(160071);
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(160117);
          b.c(WeChatSplashStartup.b(WeChatSplashStartup.this));
          AppMethodBeat.o(160117);
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(160116);
          if (!com.tencent.mm.sdk.platformtools.ai.cin())
          {
            AppMethodBeat.o(160116);
            return;
          }
          if (!w.KF())
          {
            ac.i("MicroMsg.WeChatSplashStartup", "[+] Do not need to do patch lag fix.");
            AppMethodBeat.o(160116);
            return;
          }
          ac.i("MicroMsg.WeChatSplashStartup", "[+] Register app foreground listener for patch lag fixing.");
          AppForegroundDelegate.cHM.a(new n()
          {
            public final void onAppBackground(String paramAnonymous2String)
            {
              AppMethodBeat.i(210000);
              ac.i("MicroMsg.WeChatSplashStartup", "[+] PatchLagFixing: app goes to background now.");
              w.br(com.tencent.mm.sdk.platformtools.ai.getContext());
              AppMethodBeat.o(210000);
            }
            
            public final void onAppForeground(String paramAnonymous2String) {}
          });
          ac.i("MicroMsg.WeChatSplashStartup", "[+] Register screen state for patch lag fixing.");
          new m(com.tencent.mm.sdk.platformtools.ai.getContext(), new com.tencent.mm.modelmulti.m.a()
          {
            public final void cg(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(209999);
              if (!paramAnonymous2Boolean)
              {
                ac.i("MicroMsg.WeChatSplashStartup", "[+] PatchLagFixing: screen is off now.");
                if (!com.tencent.tinker.lib.e.b.c(d.cIg))
                {
                  ac.w("MicroMsg.WeChatSplashStartup", "[!] No patch was loaded, skip lag fixing and suicide.");
                  AppMethodBeat.o(209999);
                  return;
                }
                if (w.KG())
                {
                  ac.i("MicroMsg.WeChatSplashStartup", "[+] DexOpt is done, do restart WeChat now.");
                  w.KH();
                }
              }
              AppMethodBeat.o(209999);
            }
          });
          AppMethodBeat.o(160116);
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        private final ay cJs;
        private final int cKl;
        private final int cKm;
        private final int cKn;
        private final int cKo;
        private final int cKp;
        private final int cKq;
        private final int cKr;
        private final int cKs;
        private final int cKt;
        
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
          //   124: invokestatic 183	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        
        public final void Lh()
        {
          AppMethodBeat.i(209994);
          if (!com.tencent.mm.sdk.platformtools.ai.cin())
          {
            AppMethodBeat.o(209994);
            return;
          }
          com.tencent.e.h.JZN.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209998);
              File localFile1 = new File(com.tencent.mm.loader.j.b.apd(), "/MicroMsg/WeiXin/");
              File localFile2 = new File(com.tencent.mm.loader.j.b.apd(), "/MicroMsg/WeChat/");
              File localFile3 = new File(com.tencent.mm.loader.j.b.apr());
              if (localFile1.exists())
              {
                WeChatSplashStartup.11.f(localFile1, localFile3);
                if (localFile3.exists()) {
                  break label112;
                }
                WeChatSplashStartup.11.a(WeChatSplashStartup.11.this, 170, 174);
              }
              while (localFile2.exists())
              {
                WeChatSplashStartup.11.f(localFile2, localFile3);
                if (!localFile3.exists())
                {
                  WeChatSplashStartup.11.a(WeChatSplashStartup.11.this, 171, 177);
                  AppMethodBeat.o(209998);
                  return;
                  label112:
                  if (!localFile1.exists()) {
                    WeChatSplashStartup.11.a(WeChatSplashStartup.11.this, 170, 172);
                  } else {
                    WeChatSplashStartup.11.a(WeChatSplashStartup.11.this, 170, 173);
                  }
                }
                else
                {
                  if (!localFile2.exists())
                  {
                    WeChatSplashStartup.11.a(WeChatSplashStartup.11.this, 171, 175);
                    AppMethodBeat.o(209998);
                    return;
                  }
                  WeChatSplashStartup.11.a(WeChatSplashStartup.11.this, 171, 176);
                }
              }
              AppMethodBeat.o(209998);
            }
          }, "FixMigrate");
          AppMethodBeat.o(209994);
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(160091);
      return;
      bool = false;
      break;
      label230:
      if ((this.profile.uq(":appbrand")) && (eA(com.tencent.mm.plugin.appbrand.a.a.jjd))) {
        localObject = new c();
      } else {
        localObject = new i();
      }
    }
  }
  
  private com.tencent.mm.vending.h.d ce(boolean paramBoolean)
  {
    AppMethodBeat.i(160092);
    if (!paramBoolean)
    {
      Object localObject = p.Kv();
      ((p)localObject).Kw();
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(209992);
          this.cKe.cIH.quit();
          com.tencent.mm.kernel.g.agS().b(this);
          AppMethodBeat.o(209992);
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.a.c.ahe().f(((p)localObject).cIH.getLooper());
      localObject = ((p)localObject).cII;
      AppMethodBeat.o(160092);
      return localObject;
    }
    AppMethodBeat.o(160092);
    return null;
  }
  
  private static boolean eA(String paramString)
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
  
  public final void Lg()
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
    this.profile = ai.cKb;
    com.tencent.mm.kernel.g.a(this.profile);
    paramApplication = this.profile;
    paramString = this.app;
    paramApplication.gkv.a(new h.6(paramApplication, paramString));
    AppMethodBeat.o(160088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup
 * JD-Core Version:    0.7.0.1
 */