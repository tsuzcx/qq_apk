package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.m.a;
import com.tencent.mm.splash.o.a;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vfs.z;
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
    com.tencent.mm.f.a.bT(this.app);
    com.tencent.mm.blink.a.nO(2);
    final boolean bool;
    Object localObject;
    if (parama == null)
    {
      bool = true;
      this.profile.onCreate();
      if ((!this.profile.FY(":tools")) && (!this.profile.FY(":toolsmp"))) {
        break label216;
      }
      localObject = new ah();
    }
    for (;;)
    {
      this.profile.hqy.a((com.tencent.mm.kernel.a.b)localObject);
      if (!bool)
      {
        com.tencent.mm.splash.h.gyi();
        new IListener() {}.alive();
        new IListener() {}.alive();
      }
      com.tencent.mm.kernel.g.aAi().a(cP(bool));
      com.tencent.mm.splash.h.a(new e()
      {
        com.tencent.mm.ui.o dmS;
        
        public final boolean WX()
        {
          AppMethodBeat.i(169426);
          boolean bool = com.tencent.mm.ui.o.gIz();
          AppMethodBeat.o(169426);
          return bool;
        }
        
        public final boolean a(Activity paramAnonymousActivity, int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(160068);
          boolean bool = this.dmS.a(paramAnonymousActivity, paramAnonymousInt, paramAnonymousArrayOfString, paramAnonymousArrayOfInt);
          AppMethodBeat.o(160068);
          return bool;
        }
        
        public final boolean a(Activity paramAnonymousActivity, final Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(160066);
          com.tencent.mm.kernel.g.aAf();
          boolean bool = com.tencent.mm.kernel.a.azo();
          String str = bf.iDu.aA("login_user_name", "");
          if ((!bool) && (str.equals(""))) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(160066);
            return false;
          }
          if (ChannelUtil.shouldShowGprsAlert)
          {
            bool = MMAppMgr.a(paramAnonymousActivity, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(160107);
                paramAnonymousRunnable.run();
                AppMethodBeat.o(160107);
              }
            });
            AppMethodBeat.o(160066);
            return bool;
          }
          AppMethodBeat.o(160066);
          return false;
        }
        
        public final boolean n(Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(160065);
          if ((paramAnonymousIntent != null) && (IntentUtil.getIntExtra(paramAnonymousIntent, "absolutely_exit_pid", 0) == Process.myPid()))
          {
            Log.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
            MMAppMgr.Bj(IntentUtil.getBooleanExtra(paramAnonymousIntent, "kill_service", true));
            AppMethodBeat.o(160065);
            return true;
          }
          AppMethodBeat.o(160065);
          return false;
        }
      });
      com.tencent.mm.splash.h.a(y.dme);
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(160049);
          com.tencent.mm.kernel.g.aAi().b(this);
          if (!bool)
          {
            parama.done();
            AppMethodBeat.o(160049);
            return;
          }
          com.tencent.mm.splash.h.c("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
          Object localObject = com.tencent.mm.splash.a.gya();
          if (!new com.tencent.mm.vfs.o((String)localObject).exists())
          {
            com.tencent.mm.splash.h.c("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
            AppMethodBeat.o(160049);
            return;
          }
          localObject = new com.tencent.mm.vfs.o((String)localObject + "/main-process-blocking");
          if (((com.tencent.mm.vfs.o)localObject).exists()) {
            com.tencent.mm.splash.h.c("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.o)localObject).delete()) });
          }
          AppMethodBeat.o(160049);
        }
        
        public final void cQ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(160075);
          com.tencent.mm.kernel.g.aAi().b(this);
          com.tencent.mm.blink.a.WU();
          WeChatSplashStartup.a(WeChatSplashStartup.this);
          z.bUV();
          ExtStorageMigrateMonitor.gwL();
          com.tencent.mm.sdcard_migrate.b.gxh();
          ExtStorageMigrateRoutine.triggerMediaRescanOnDemand();
          if (WeChatSplashStartup.this.profile.aBb()) {}
          try
          {
            MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
            if (WeChatSplashStartup.this.profile.aBb())
            {
              com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.aAf();
              Log.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[] { Boolean.valueOf(locala.azp()), Integer.valueOf(locala.hpP), Util.getStack() });
              if ((locala.azp()) && (locala.hpP != 0))
              {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, locala.hpP);
                Log.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(locala.hpP), Util.getStack() });
                locala.hpP = 0;
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
        
        public final void cQ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(160071);
          if (!MMApplicationContext.isToolsIsolatedProcess()) {
            ag.a.dmC.WM();
          }
          x.execute();
          AppMethodBeat.o(160071);
        }
        
        public final void cQ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(160117);
          b.c(WeChatSplashStartup.b(WeChatSplashStartup.this));
          AppMethodBeat.o(160117);
        }
        
        public final void cQ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        private final int IDKEY_ID;
        private final PeriodRecorder dmV;
        private final int dmW;
        private final int dmX;
        private final int dmY;
        private final int dmZ;
        private final int dna;
        private final int dnb;
        private final int dnc;
        private final int dnd;
        
        /* Error */
        private static void e(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          // Byte code:
          //   0: ldc 121
          //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_1
          //   6: invokevirtual 127	java/io/File:exists	()Z
          //   9: ifne +11 -> 20
          //   12: aload_1
          //   13: invokevirtual 131	java/io/File:getParentFile	()Ljava/io/File;
          //   16: invokevirtual 134	java/io/File:mkdirs	()Z
          //   19: pop
          //   20: new 136	java/io/BufferedInputStream
          //   23: dup
          //   24: new 138	java/io/FileInputStream
          //   27: dup
          //   28: aload_0
          //   29: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
          //   32: invokespecial 144	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
          //   35: astore_3
          //   36: new 146	java/io/BufferedOutputStream
          //   39: dup
          //   40: new 148	java/io/FileOutputStream
          //   43: dup
          //   44: aload_1
          //   45: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
          //   48: invokespecial 152	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
          //   51: astore 4
          //   53: sipush 4096
          //   56: newarray byte
          //   58: astore 5
          //   60: aload_3
          //   61: aload 5
          //   63: invokevirtual 158	java/io/InputStream:read	([B)I
          //   66: istore_2
          //   67: iload_2
          //   68: ifle +34 -> 102
          //   71: aload 4
          //   73: aload 5
          //   75: iconst_0
          //   76: iload_2
          //   77: invokevirtual 164	java/io/OutputStream:write	([BII)V
          //   80: goto -20 -> 60
          //   83: astore_0
          //   84: aload 4
          //   86: astore_1
          //   87: aload_1
          //   88: invokestatic 170	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
          //   91: aload_3
          //   92: invokestatic 170	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
          //   95: ldc 121
          //   97: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   100: aload_0
          //   101: athrow
          //   102: ldc 172
          //   104: ldc 174
          //   106: iconst_2
          //   107: anewarray 4	java/lang/Object
          //   110: dup
          //   111: iconst_0
          //   112: aload_0
          //   113: invokevirtual 177	java/io/File:getAbsolutePath	()Ljava/lang/String;
          //   116: aastore
          //   117: dup
          //   118: iconst_1
          //   119: aload_1
          //   120: invokevirtual 177	java/io/File:getAbsolutePath	()Ljava/lang/String;
          //   123: aastore
          //   124: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   127: aload 4
          //   129: invokestatic 170	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
          //   132: aload_3
          //   133: invokestatic 170	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
          //   136: ldc 121
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
        
        public final void WY()
        {
          AppMethodBeat.i(160116);
          if (!MMApplicationContext.isMainProcess())
          {
            AppMethodBeat.o(160116);
            return;
          }
          com.tencent.f.h.RTc.b(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(257917);
              File localFile1 = new File(com.tencent.mm.loader.j.b.aKF(), "/MicroMsg/WeiXin/");
              File localFile2 = new File(com.tencent.mm.loader.j.b.aKF(), "/MicroMsg/WeChat/");
              File localFile3 = new File(com.tencent.mm.loader.j.b.aKU());
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
                  AppMethodBeat.o(257917);
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
                    AppMethodBeat.o(257917);
                    return;
                  }
                  WeChatSplashStartup.9.a(WeChatSplashStartup.9.this, 171, 176);
                }
              }
              AppMethodBeat.o(257917);
            }
          }, "FixMigrate");
          AppMethodBeat.o(160116);
        }
        
        public final void cQ(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(160091);
      return;
      bool = false;
      break;
      label216:
      if (this.profile.FZ(":appbrand")) {
        localObject = new c();
      } else {
        localObject = new i();
      }
    }
  }
  
  private d cP(boolean paramBoolean)
  {
    AppMethodBeat.i(160092);
    if (!paramBoolean)
    {
      Object localObject = q.Ws();
      ((q)localObject).setHighPriority();
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(257912);
          this.dnf.dli.quit();
          com.tencent.mm.kernel.g.aAi().b(this);
          AppMethodBeat.o(257912);
        }
        
        public final void cQ(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.a.c.aAu().f(((q)localObject).dli.getLooper());
      localObject = ((q)localObject).mScheduler;
      AppMethodBeat.o(160092);
      return localObject;
    }
    AppMethodBeat.o(160092);
    return null;
  }
  
  public final void WW()
  {
    AppMethodBeat.i(160090);
    b(null);
    AppMethodBeat.o(160090);
  }
  
  public final void a(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(160088);
    this.app = paramApplication;
    this.thisProcess = paramString;
    this.profile = aj.dmN;
    com.tencent.mm.kernel.g.a(this.profile);
    paramApplication = this.profile;
    paramString = this.app;
    paramApplication.htA.a(new h.6(paramApplication, paramString));
    AppMethodBeat.o(160088);
  }
  
  public final void a(o.a parama)
  {
    AppMethodBeat.i(160089);
    b(parama);
    AppMethodBeat.o(160089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup
 * JD-Core Version:    0.7.0.1
 */