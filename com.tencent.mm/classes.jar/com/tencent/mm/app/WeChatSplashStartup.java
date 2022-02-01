package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.sa;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.splash.n.a;
import com.tencent.mm.splash.p.a;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vfs.ag;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class WeChatSplashStartup
  implements n.a
{
  private Application app;
  com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  private void b(final p.a parama)
  {
    AppMethodBeat.i(160091);
    com.tencent.mm.blink.a.qd(2);
    final boolean bool;
    Object localObject;
    if (parama == null)
    {
      bool = true;
      this.profile.onCreate();
      if ((!this.profile.FH(":tools")) && (!this.profile.FH(":toolsmp"))) {
        break label238;
      }
      localObject = new an(this.profile.FH(":toolsmp"));
    }
    for (;;)
    {
      this.profile.mCB.a((com.tencent.mm.kernel.a.b)localObject);
      if ((!bool) && (com.tencent.mm.splash.i.iVL()))
      {
        new WeChatSplashStartup.1(this, f.hfK).alive();
        new IListener(f.hfK) {}.alive();
      }
      com.tencent.mm.kernel.h.baF().a(dY(bool));
      com.tencent.mm.splash.i.a(new WeChatSplashStartup.5(this));
      com.tencent.mm.splash.i.a(ab.hhy);
      com.tencent.mm.kernel.h.baF().a(new com.tencent.mm.kernel.api.g()
      {
        public final void aDv()
        {
          AppMethodBeat.i(160049);
          com.tencent.mm.kernel.h.baF().b(this);
          if (!bool)
          {
            parama.done();
            AppMethodBeat.o(160049);
            return;
          }
          com.tencent.mm.splash.i.g("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
          Object localObject = com.tencent.mm.splash.a.iVB();
          if (!new u((String)localObject).jKS())
          {
            com.tencent.mm.splash.i.g("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
            AppMethodBeat.o(160049);
            return;
          }
          localObject = new u((String)localObject + "/main-process-blocking");
          if (((u)localObject).jKS()) {
            com.tencent.mm.splash.i.g("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[] { Boolean.valueOf(((u)localObject).diJ()) });
          }
          AppMethodBeat.o(160049);
        }
        
        public final void dZ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.h.baF().a(new com.tencent.mm.kernel.api.g()
      {
        public final void aDv()
        {
          AppMethodBeat.i(160075);
          com.tencent.mm.kernel.h.baF().b(this);
          com.tencent.mm.blink.a.aDs();
          WeChatSplashStartup.a(WeChatSplashStartup.this);
          ag.jLD();
          ExtStorageMigrateMonitor.iSP();
          com.tencent.mm.sdcard_migrate.b.iTm();
          ExtStorageMigrateRoutine.triggerMediaRescanOnDemand();
          if (WeChatSplashStartup.this.profile.bbA()) {}
          try
          {
            MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
            if (WeChatSplashStartup.this.profile.bbA())
            {
              com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.h.baC();
              Log.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[] { Boolean.valueOf(localb.aZN()), Integer.valueOf(localb.mBQ), Util.getStack() });
              if ((localb.aZN()) && (localb.mBQ != 0))
              {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, localb.mBQ);
                Log.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(localb.mBQ), Util.getStack() });
                localb.mBQ = 0;
              }
            }
            AppMethodBeat.o(160075);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WeChatSplashStartup", localException, "%s", new Object[] { localException.getMessage() });
            }
          }
        }
        
        public final void dZ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.h.baF().a(new WeChatSplashStartup.8(this));
      com.tencent.mm.kernel.h.baF().a(new com.tencent.mm.kernel.api.g()
      {
        public final void aDv()
        {
          AppMethodBeat.i(160117);
          b.f(WeChatSplashStartup.b(WeChatSplashStartup.this));
          AppMethodBeat.o(160117);
        }
        
        public final void dZ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.h.baF().a(new com.tencent.mm.kernel.api.g()
      {
        private final PeriodRecorder REPORT_FREQ_LIMIT;
        private final int hjr;
        private final int hjs;
        private final int hjt;
        private final int hju;
        private final int hjv;
        private final int hjw;
        private final int hjx;
        private final int hjy;
        private final int hjz;
        
        /* Error */
        private static void d(File paramAnonymousFile1, File paramAnonymousFile2)
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
          //   88: invokestatic 171	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
          //   91: aload_3
          //   92: invokestatic 171	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
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
          //   124: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   127: aload 4
          //   129: invokestatic 171	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
          //   132: aload_3
          //   133: invokestatic 171	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
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
        
        public final void aDv()
        {
          AppMethodBeat.i(160116);
          if (!MMApplicationContext.isMainProcess())
          {
            AppMethodBeat.o(160116);
            return;
          }
          com.tencent.threadpool.h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(239276);
              File localFile1 = new File(com.tencent.mm.loader.i.b.bmv(), "/MicroMsg/WeiXin/");
              File localFile2 = new File(com.tencent.mm.loader.i.b.bmv(), "/MicroMsg/WeChat/");
              File localFile3 = new File(com.tencent.mm.loader.i.b.bmK());
              if (localFile1.exists())
              {
                WeChatSplashStartup.10.e(localFile1, localFile3);
                if (localFile3.exists()) {
                  break label112;
                }
                WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 170, 174);
              }
              while (localFile2.exists())
              {
                WeChatSplashStartup.10.e(localFile2, localFile3);
                if (!localFile3.exists())
                {
                  WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 171, 177);
                  AppMethodBeat.o(239276);
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
                    AppMethodBeat.o(239276);
                    return;
                  }
                  WeChatSplashStartup.10.a(WeChatSplashStartup.10.this, 171, 176);
                }
              }
              AppMethodBeat.o(239276);
            }
          }, "FixMigrate");
          AppMethodBeat.o(160116);
        }
        
        public final void dZ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.h.baF().a(new WeChatSplashStartup.11(this));
      AppMethodBeat.o(160091);
      return;
      bool = false;
      break;
      label238:
      if (this.profile.FI(":appbrand")) {
        localObject = new c();
      } else if (this.profile.FI(":magic_emoji")) {
        localObject = new y();
      } else if (this.profile.FH(":support")) {
        localObject = new aj();
      } else {
        localObject = new k();
      }
    }
  }
  
  private d dY(boolean paramBoolean)
  {
    AppMethodBeat.i(160092);
    if (!paramBoolean)
    {
      Object localObject = s.aCt();
      ((s)localObject).setHighPriority();
      com.tencent.mm.kernel.h.baF().a(new com.tencent.mm.kernel.api.g()
      {
        public final void aDv()
        {
          AppMethodBeat.i(239236);
          this.hjl.hgw.quit();
          com.tencent.mm.kernel.h.baF().b(this);
          AppMethodBeat.o(239236);
        }
        
        public final void dZ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.a.c.baR().h(((s)localObject).hgw.getLooper());
      localObject = ((s)localObject).mScheduler;
      AppMethodBeat.o(160092);
      return localObject;
    }
    AppMethodBeat.o(160092);
    return null;
  }
  
  public final void a(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(160088);
    this.app = paramApplication;
    this.thisProcess = paramString;
    this.profile = ap.hji;
    com.tencent.mm.kernel.h.a(this.profile);
    paramApplication = this.profile;
    paramString = this.app;
    paramApplication.mFU.a(new h.6(paramApplication, paramString));
    AppMethodBeat.o(160088);
  }
  
  public final void a(p.a parama)
  {
    AppMethodBeat.i(160089);
    b(parama);
    AppMethodBeat.o(160089);
  }
  
  public final void aDu()
  {
    AppMethodBeat.i(160090);
    b(null);
    AppMethodBeat.o(160090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup
 * JD-Core Version:    0.7.0.1
 */