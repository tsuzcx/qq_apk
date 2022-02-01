package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.tv;
import com.tencent.mm.autogen.a.tv.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.h.c;
import com.tencent.mm.recoveryv2.j.a;
import com.tencent.mm.recoveryv2.k.a.b;
import com.tencent.mm.recoveryv2.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IAfterReport;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.y;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class PluginRecovery
  extends com.tencent.mm.kernel.b.f
  implements c
{
  private BroadcastReceiver bJm;
  private RecoveryLog.RecoveryLogImpl logImpl;
  private IListener<tv> oRp;
  
  public PluginRecovery()
  {
    AppMethodBeat.i(20580);
    this.oRp = new IListener(com.tencent.mm.app.f.hfK)
    {
      private static boolean a(tv paramAnonymoustv)
      {
        AppMethodBeat.i(231074);
        switch (paramAnonymoustv.hXK.action)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(231074);
          return false;
          b.bLJ();
          continue;
          paramAnonymoustv = MMApplicationContext.getContext();
          CommonOptions.Builder localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(BuildInfo.CLIENT_VERSION);
          localBuilder.setConfigUrl(String.format("file:///sdcard/test-recovery.conf", new Object[0]));
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymoustv));
          RecoveryLogic.startHandleService(paramAnonymoustv, localBuilder.build(), new RecoveryContext());
          continue;
          paramAnonymoustv = MMApplicationContext.getContext();
          localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(BuildInfo.CLIENT_VERSION);
          localBuilder.setConfigUrl("http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf");
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymoustv));
          RecoveryLogic.startHandleService(paramAnonymoustv, localBuilder.build(), new RecoveryContext());
        }
      }
    };
    this.bJm = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(231071);
        if (paramAnonymousIntent != null)
        {
          if ("com.tecent.recovery.intent.action.LOG".equals(paramAnonymousIntent.getAction()))
          {
            PluginRecovery.access$000(PluginRecovery.this);
            AppMethodBeat.o(231071);
            return;
          }
          if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramAnonymousIntent.getAction())) {
            PluginRecovery.access$100(PluginRecovery.this);
          }
        }
        AppMethodBeat.o(231071);
      }
    };
    this.logImpl = new RecoveryLog.RecoveryLogImpl()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231041);
        Log.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231041);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231049);
        Log.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231049);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231044);
        Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231044);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231051);
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231051);
      }
      
      public final void setDebugMode() {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231042);
        Log.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231042);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231048);
        Log.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231048);
      }
    };
    AppMethodBeat.o(20580);
  }
  
  private void postLog()
  {
    AppMethodBeat.i(20584);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231088);
        Log.i("MicroMsg.recovery.PluginRecovery", "postLog");
        b.bLJ();
        AppMethodBeat.o(231088);
      }
    }, "RecoveryWriteLogThread");
    AppMethodBeat.o(20584);
  }
  
  private void postReport()
  {
    AppMethodBeat.i(20585);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231076);
        Log.i("MicroMsg.recovery.PluginRecovery", "postReport");
        d.bLK();
        AppMethodBeat.o(231076);
      }
    }, "RecoveryReportStatusThread");
    AppMethodBeat.o(20585);
  }
  
  private void testRecoveryExceptionHandler() {}
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(20581);
    RecoveryLog.setLogImpl(this.logImpl);
    long l;
    if (paramg.FH(":sandbox"))
    {
      l = System.currentTimeMillis();
      paramg = new IntentFilter();
      paramg.addAction("com.tecent.recovery.intent.action.LOG");
      paramg.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
    }
    try
    {
      MMApplicationContext.getContext().registerReceiver(this.bJm, paramg);
      label58:
      paramg = new File(WXConstantsRecovery.RecoverySDCardDir);
      if (!paramg.exists()) {
        paramg.mkdir();
      }
      paramg = new File(paramg, "version.info");
      if (paramg.exists()) {
        paramg.delete();
      }
      try
      {
        paramg = paramg.getAbsolutePath();
        byte[] arrayOfByte = Integer.toHexString(com.tencent.mm.protocal.d.Yxh).getBytes();
        y.f(paramg, arrayOfByte, arrayOfByte.length);
        label130:
        Log.i("MicroMsg.recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(20581);
        return;
      }
      catch (Exception paramg)
      {
        break label130;
      }
    }
    catch (Exception paramg)
    {
      break label58;
    }
  }
  
  public void execute(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(231054);
    if (paramg.bbA())
    {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231056);
          for (;;)
          {
            long l;
            try
            {
              Object localObject = paramg.bGP;
              Log.i("MicroMsg.recovery.reporter", "do recovery report after recover from exception");
              localObject = com.tencent.mm.recoveryv2.i.lV((Context)localObject);
              if (((com.tencent.mm.recoveryv2.i)localObject).acks)
              {
                Log.i("MicroMsg.recovery.reporter", "not thing to report");
                h.c localc = h.c.lU(paramg.bGP);
                localc.iQN();
                String str = localc.iQO();
                localObject = str;
                if (TextUtils.isEmpty(str)) {
                  localObject = "nothing";
                }
                Log.i("MicroMsg.recovery.reporter", ">>>>>>> dump recovery internal log (:main) <<<<<<<");
                Log.i("MicroMsg.recovery.reporter", "\n".concat(String.valueOf(localObject)));
                Log.i("MicroMsg.recovery.reporter", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
                k.a.b.I(new File(localc.ackn));
                AppMethodBeat.o(231056);
                return;
              }
              i = ((com.tencent.mm.recoveryv2.i)localObject).acjW;
              Log.i("MicroMsg.recovery.reporter", "report crash count = ".concat(String.valueOf(i)));
              if ((i > 0) && (i <= 20))
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, i + 200, 1L, false);
                if (i >= 5) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, i + 220, 1L, false);
                }
                boolean bool = ((com.tencent.mm.recoveryv2.i)localObject).acko;
                Log.i("MicroMsg.recovery.reporter", "report recovery ui launch, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, 100L, 1L, false);
                }
                bool = ((com.tencent.mm.recoveryv2.i)localObject).ackp;
                Log.i("MicroMsg.recovery.reporter", "report recovery ui launch real, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, 102L, 1L, false);
                }
                bool = ((com.tencent.mm.recoveryv2.i)localObject).ackq;
                Log.i("MicroMsg.recovery.reporter", "report if recover from crash, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, 101L, 1L, false);
                }
                i = ((com.tencent.mm.recoveryv2.i)localObject).ackr;
                Log.i("MicroMsg.recovery.reporter", "recovery status = ".concat(String.valueOf(i)));
                if (i >= 0)
                {
                  if (i != 0) {
                    break label622;
                  }
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, 103L, 1L, false);
                }
                i = ((com.tencent.mm.recoveryv2.i)localObject).mFrom;
                Log.i("MicroMsg.recovery.reporter", "recovery from = ".concat(String.valueOf(i)));
                if ((i >= 0) && (i < 10)) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, i + 140, 1L, false);
                }
                i = ((com.tencent.mm.recoveryv2.i)localObject).ackt;
                Log.i("MicroMsg.recovery.reporter", "recovery internalStatus = ".concat(String.valueOf(i)));
                if ((i >= 0) && (i < 10)) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, i + 150, 1L, false);
                }
                l = ((com.tencent.mm.recoveryv2.i)localObject).acku;
                if (l <= 0L) {
                  break label803;
                }
                if (l > 10000L) {
                  break label655;
                }
                i = 0;
                if (i >= 0) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, i + 160, 1L, false);
                }
                ((com.tencent.mm.recoveryv2.i)localObject).acjW = 0;
                ((com.tencent.mm.recoveryv2.i)localObject).acko = false;
                ((com.tencent.mm.recoveryv2.i)localObject).ackp = false;
                ((com.tencent.mm.recoveryv2.i)localObject).ackq = false;
                ((com.tencent.mm.recoveryv2.i)localObject).ackr = -1;
                ((com.tencent.mm.recoveryv2.i)localObject).mFrom = 0;
                ((com.tencent.mm.recoveryv2.i)localObject).ackt = 0;
                ((com.tencent.mm.recoveryv2.i)localObject).acku = 0L;
                ((com.tencent.mm.recoveryv2.i)localObject).acks = false;
                ((com.tencent.mm.recoveryv2.i)localObject).acks = true;
                ((com.tencent.mm.recoveryv2.i)localObject).sz();
                continue;
              }
              if (i <= 20) {
                continue;
              }
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.recovery.PluginRecovery", localException, "post recovery fail", new Object[0]);
              AppMethodBeat.o(231056);
              return;
            }
            Log.w("MicroMsg.recovery.reporter", "abnormal crash count found, num = ".concat(String.valueOf(i)));
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, 105L, 1L, false);
            continue;
            label622:
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, 104L, 1L, false);
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1341L, i + 110, 1L, false);
            continue;
            label655:
            if (l <= 60000L)
            {
              l /= 10000L;
              if ((l >= 1L) && (l <= 6L)) {
                i = (int)(l + 0L);
              }
            }
            else if (l <= 600000L)
            {
              l /= 60000L;
              if ((l >= 1L) && (l <= 10L)) {
                i = (int)(l + 6L);
              }
            }
            else if (l <= 3600000L)
            {
              l /= 600000L;
              if ((l >= 1L) && (l <= 6L)) {
                i = (int)(l + 16L);
              }
            }
            else
            {
              l /= 3600000L;
              if (l >= 1L)
              {
                if (l <= 6L)
                {
                  i = (int)(l + 22L);
                  continue;
                }
                i = 29;
                continue;
              }
            }
            label803:
            int i = -1;
          }
        }
      });
      com.tencent.mm.kernel.h.baF().a(new com.tencent.mm.kernel.api.g()
      {
        public final void aDv()
        {
          AppMethodBeat.i(231047);
          com.tencent.mm.kernel.h.baF().b(this);
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 24
              //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: invokestatic 36	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
              //   8: getfield 40	com/tencent/mm/kernel/h:mDl	Lcom/tencent/mm/kernel/i;
              //   11: getfield 46	com/tencent/mm/kernel/i:mDG	Z
              //   14: ifeq +340 -> 354
              //   17: ldc 48
              //   19: ldc 50
              //   21: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   24: invokestatic 61	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
              //   27: astore 11
              //   29: ldc 63
              //   31: invokestatic 67	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
              //   34: checkcast 63	com/tencent/mm/plugin/expt/b/c
              //   37: astore 10
              //   39: aload 10
              //   41: ifnull +313 -> 354
              //   44: aload 11
              //   46: invokestatic 73	com/tencent/mm/recoveryv2/h$a:lS	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/h$a;
              //   49: astore 12
              //   51: aload 10
              //   53: getstatic 79	com/tencent/mm/plugin/expt/b/c$a:zlD	Lcom/tencent/mm/plugin/expt/b/c$a;
              //   56: iconst_1
              //   57: invokeinterface 83 3 0
              //   62: istore_1
              //   63: iload_1
              //   64: ifle +328 -> 392
              //   67: iconst_1
              //   68: istore_3
              //   69: aload 12
              //   71: iload_3
              //   72: putfield 86	com/tencent/mm/recoveryv2/h$a:mEnabled	Z
              //   75: aload 12
              //   77: getfield 90	com/tencent/mm/recoveryv2/h$a:ackj	Lcom/tencent/mm/recoveryv2/f;
              //   80: ldc 92
              //   82: aload 12
              //   84: getfield 86	com/tencent/mm/recoveryv2/h$a:mEnabled	Z
              //   87: invokeinterface 98 3 0
              //   92: invokeinterface 102 1 0
              //   97: pop
              //   98: ldc 104
              //   100: ldc 106
              //   102: iload_1
              //   103: invokestatic 112	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   106: invokevirtual 116	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   109: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   112: aload 11
              //   114: invokestatic 122	com/tencent/mm/recoveryv2/h:lR	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/h;
              //   117: astore 11
              //   119: aload 10
              //   121: getstatic 125	com/tencent/mm/plugin/expt/b/c$a:zlE	Lcom/tencent/mm/plugin/expt/b/c$a;
              //   124: aload 11
              //   126: getfield 129	com/tencent/mm/recoveryv2/h:ackd	I
              //   129: invokeinterface 83 3 0
              //   134: istore_1
              //   135: aload 10
              //   137: getstatic 132	com/tencent/mm/plugin/expt/b/c$a:zlF	Lcom/tencent/mm/plugin/expt/b/c$a;
              //   140: aload 11
              //   142: getfield 135	com/tencent/mm/recoveryv2/h:acke	I
              //   145: invokeinterface 83 3 0
              //   150: istore_2
              //   151: aload 10
              //   153: getstatic 138	com/tencent/mm/plugin/expt/b/c$a:zlG	Lcom/tencent/mm/plugin/expt/b/c$a;
              //   156: aload 11
              //   158: getfield 142	com/tencent/mm/recoveryv2/h:acki	J
              //   161: invokeinterface 145 4 0
              //   166: lstore 4
              //   168: aload 10
              //   170: getstatic 148	com/tencent/mm/plugin/expt/b/c$a:zlH	Lcom/tencent/mm/plugin/expt/b/c$a;
              //   173: aload 11
              //   175: getfield 151	com/tencent/mm/recoveryv2/h:ackf	J
              //   178: invokeinterface 145 4 0
              //   183: lstore 6
              //   185: aload 10
              //   187: getstatic 154	com/tencent/mm/plugin/expt/b/c$a:zlI	Lcom/tencent/mm/plugin/expt/b/c$a;
              //   190: aload 11
              //   192: getfield 157	com/tencent/mm/recoveryv2/h:ackg	J
              //   195: invokeinterface 145 4 0
              //   200: lstore 8
              //   202: iload_1
              //   203: iconst_2
              //   204: if_icmplt +23 -> 227
              //   207: ldc 104
              //   209: ldc 159
              //   211: iload_1
              //   212: invokestatic 112	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   215: invokevirtual 116	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   218: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   221: aload 11
              //   223: iload_1
              //   224: putfield 129	com/tencent/mm/recoveryv2/h:ackd	I
              //   227: iload_2
              //   228: aload 11
              //   230: getfield 129	com/tencent/mm/recoveryv2/h:ackd	I
              //   233: if_icmplt +23 -> 256
              //   236: ldc 104
              //   238: ldc 161
              //   240: iload_2
              //   241: invokestatic 112	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   244: invokevirtual 116	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   247: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   250: aload 11
              //   252: iload_2
              //   253: putfield 135	com/tencent/mm/recoveryv2/h:acke	I
              //   256: lload 4
              //   258: ldc2_w 162
              //   261: lcmp
              //   262: iflt +25 -> 287
              //   265: ldc 104
              //   267: ldc 165
              //   269: lload 4
              //   271: invokestatic 168	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   274: invokevirtual 116	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   277: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   280: aload 11
              //   282: lload 4
              //   284: putfield 142	com/tencent/mm/recoveryv2/h:acki	J
              //   287: lload 6
              //   289: ldc2_w 162
              //   292: lcmp
              //   293: iflt +25 -> 318
              //   296: ldc 104
              //   298: ldc 170
              //   300: lload 6
              //   302: invokestatic 168	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   305: invokevirtual 116	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   308: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   311: aload 11
              //   313: lload 6
              //   315: putfield 151	com/tencent/mm/recoveryv2/h:ackf	J
              //   318: lload 8
              //   320: ldc2_w 162
              //   323: lcmp
              //   324: iflt +25 -> 349
              //   327: ldc 104
              //   329: ldc 172
              //   331: lload 8
              //   333: invokestatic 168	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   336: invokevirtual 116	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   339: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   342: aload 11
              //   344: lload 8
              //   346: putfield 157	com/tencent/mm/recoveryv2/h:ackg	J
              //   349: aload 11
              //   351: invokevirtual 175	com/tencent/mm/recoveryv2/h:sz	()V
              //   354: aload_0
              //   355: getfield 17	com/tencent/mm/modelrecovery/PluginRecovery$2$1:oRr	Lcom/tencent/mm/modelrecovery/PluginRecovery$2;
              //   358: getfield 179	com/tencent/mm/modelrecovery/PluginRecovery$2:hge	Lcom/tencent/mm/kernel/b/g;
              //   361: getfield 185	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
              //   364: invokestatic 122	com/tencent/mm/recoveryv2/h:lR	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/h;
              //   367: getfield 142	com/tencent/mm/recoveryv2/h:acki	J
              //   370: invokestatic 191	java/lang/Thread:sleep	(J)V
              //   373: ldc 48
              //   375: ldc 193
              //   377: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   380: invokestatic 199	com/tencent/mm/recoveryv2/l:iRc	()Lcom/tencent/mm/recoveryv2/l;
              //   383: invokevirtual 202	com/tencent/mm/recoveryv2/l:unregister	()V
              //   386: ldc 24
              //   388: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   391: return
              //   392: iconst_0
              //   393: istore_3
              //   394: goto -325 -> 69
              //   397: astore 10
              //   399: ldc 104
              //   401: aload 10
              //   403: ldc 207
              //   405: iconst_0
              //   406: anewarray 4	java/lang/Object
              //   409: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   412: goto -58 -> 354
              //   415: astore 10
              //   417: ldc 48
              //   419: ldc 193
              //   421: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   424: invokestatic 199	com/tencent/mm/recoveryv2/l:iRc	()Lcom/tencent/mm/recoveryv2/l;
              //   427: invokevirtual 202	com/tencent/mm/recoveryv2/l:unregister	()V
              //   430: ldc 24
              //   432: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   435: return
              //   436: astore 10
              //   438: ldc 48
              //   440: ldc 193
              //   442: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   445: invokestatic 199	com/tencent/mm/recoveryv2/l:iRc	()Lcom/tencent/mm/recoveryv2/l;
              //   448: invokevirtual 202	com/tencent/mm/recoveryv2/l:unregister	()V
              //   451: ldc 24
              //   453: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   456: aload 10
              //   458: athrow
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	459	0	this	1
              //   62	162	1	i	int
              //   150	103	2	j	int
              //   68	326	3	bool	boolean
              //   166	117	4	l1	long
              //   183	131	6	l2	long
              //   200	145	8	l3	long
              //   37	149	10	localc	com.tencent.mm.plugin.expt.b.c
              //   397	5	10	localThrowable	Throwable
              //   415	1	10	localInterruptedException	java.lang.InterruptedException
              //   436	21	10	localObject1	Object
              //   27	323	11	localObject2	Object
              //   49	34	12	locala	com.tencent.mm.recoveryv2.h.a
              // Exception table:
              //   from	to	target	type
              //   29	39	397	finally
              //   44	63	397	finally
              //   69	202	397	finally
              //   207	227	397	finally
              //   227	256	397	finally
              //   265	287	397	finally
              //   296	318	397	finally
              //   327	349	397	finally
              //   349	354	397	finally
              //   354	373	415	java/lang/InterruptedException
              //   354	373	436	finally
            }
          });
          AppMethodBeat.o(231047);
        }
        
        public final void dZ(boolean paramAnonymousBoolean) {}
      });
      MMUncaughtExceptionHandler.setAfterReport(new MMUncaughtExceptionHandler.IAfterReport()
      {
        public final void afterReport()
        {
          AppMethodBeat.i(231046);
          l locall = l.iRc();
          int i;
          if (locall.ackR == null)
          {
            if (locall.mContext == null) {
              break label112;
            }
            i = RecoveryCrash.lK(locall.mContext).acjU.acjW;
          }
          for (;;)
          {
            Log.i("MicroMsg.recovery.PluginRecovery", "#afterReport, handling java crash with recovery, lastCrashCount = ".concat(String.valueOf(i)));
            Log.i("MicroMsg.recovery.reporter", "do recovery report directly");
            com.tencent.threadpool.h.ahAA.bm(new c.1(i));
            l.iRc().axS(3);
            AppMethodBeat.o(231046);
            return;
            if ((locall.ackR instanceof j.a)) {
              i = ((j.a)locall.ackR).iQQ();
            } else {
              label112:
              i = -1;
            }
          }
        }
      });
      testRecoveryExceptionHandler();
    }
    AppMethodBeat.o(231054);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(20582);
    this.oRp.alive();
    AppMethodBeat.o(20582);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20583);
    this.oRp.dead();
    AppMethodBeat.o(20583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */