package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.rf.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.recoveryv2.h.c;
import com.tencent.mm.recoveryv2.k;
import com.tencent.mm.recoveryv2.l.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IAfterReport;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
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
  extends f
  implements com.tencent.mm.kernel.api.bucket.c
{
  private IListener<rf> jhI;
  private RecoveryLog.RecoveryLogImpl logImpl;
  private BroadcastReceiver receiver;
  
  public PluginRecovery()
  {
    AppMethodBeat.i(20580);
    this.jhI = new IListener()
    {
      private static boolean a(rf paramAnonymousrf)
      {
        AppMethodBeat.i(231553);
        switch (paramAnonymousrf.dXV.action)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(231553);
          return false;
          b.bex();
          continue;
          paramAnonymousrf = MMApplicationContext.getContext();
          CommonOptions.Builder localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(BuildInfo.CLIENT_VERSION);
          localBuilder.setConfigUrl(String.format("file:///sdcard/test-recovery.conf", new Object[0]));
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymousrf));
          RecoveryLogic.startHandleService(paramAnonymousrf, localBuilder.build(), new RecoveryContext());
          continue;
          paramAnonymousrf = MMApplicationContext.getContext();
          localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(BuildInfo.CLIENT_VERSION);
          localBuilder.setConfigUrl("http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf");
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymousrf));
          RecoveryLogic.startHandleService(paramAnonymousrf, localBuilder.build(), new RecoveryContext());
        }
      }
    };
    this.receiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(231555);
        if (paramAnonymousIntent != null)
        {
          if ("com.tecent.recovery.intent.action.LOG".equals(paramAnonymousIntent.getAction()))
          {
            PluginRecovery.access$000(PluginRecovery.this);
            AppMethodBeat.o(231555);
            return;
          }
          if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramAnonymousIntent.getAction())) {
            PluginRecovery.access$100(PluginRecovery.this);
          }
        }
        AppMethodBeat.o(231555);
      }
    };
    this.logImpl = new RecoveryLog.RecoveryLogImpl()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231558);
        Log.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231558);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231562);
        Log.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231562);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231560);
        Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231560);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231563);
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231563);
      }
      
      public final void setDebugMode() {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231559);
        Log.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231559);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(231561);
        Log.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(231561);
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
        AppMethodBeat.i(231556);
        Log.i("MicroMsg.recovery.PluginRecovery", "postLog");
        b.bex();
        AppMethodBeat.o(231556);
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
        AppMethodBeat.i(231557);
        Log.i("MicroMsg.recovery.PluginRecovery", "postReport");
        c.bey();
        AppMethodBeat.o(231557);
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
    if (paramg.FY(":sandbox"))
    {
      l = System.currentTimeMillis();
      paramg = new IntentFilter();
      paramg.addAction("com.tecent.recovery.intent.action.LOG");
      paramg.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
    }
    try
    {
      MMApplicationContext.getContext().registerReceiver(this.receiver, paramg);
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
        byte[] arrayOfByte = Integer.toHexString(d.KyO).getBytes();
        s.f(paramg, arrayOfByte, arrayOfByte.length);
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
    AppMethodBeat.i(231564);
    if (paramg.aBb())
    {
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231548);
          for (;;)
          {
            long l;
            try
            {
              Object localObject = paramg.ca;
              Log.i("MicroMsg.recovery.reporter", "do recovery report");
              localObject = com.tencent.mm.recoveryv2.i.iQ((Context)localObject);
              if (((com.tencent.mm.recoveryv2.i)localObject).NBY)
              {
                Log.i("MicroMsg.recovery.reporter", "not thing to report");
                h.c localc = h.c.iP(paramg.ca);
                localc.guM();
                String str = localc.guN();
                localObject = str;
                if (TextUtils.isEmpty(str)) {
                  localObject = "nothing";
                }
                Log.i("MicroMsg.recovery.reporter", ">>>>>>> dump recovery internal log (:main) <<<<<<<");
                Log.i("MicroMsg.recovery.reporter", "\n".concat(String.valueOf(localObject)));
                Log.i("MicroMsg.recovery.reporter", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
                l.b.M(new File(localc.NBT));
                AppMethodBeat.o(231548);
                return;
              }
              i = ((com.tencent.mm.recoveryv2.i)localObject).NBC;
              Log.i("MicroMsg.recovery.reporter", "report crash count = ".concat(String.valueOf(i)));
              if ((i > 0) && (i <= 20))
              {
                e.Cxv.idkeyStat(1341L, i + 200, 1L, false);
                if (i >= 5) {
                  e.Cxv.idkeyStat(1341L, i + 220, 1L, false);
                }
                boolean bool = ((com.tencent.mm.recoveryv2.i)localObject).NBU;
                Log.i("MicroMsg.recovery.reporter", "report recovery ui launch, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  e.Cxv.idkeyStat(1341L, 100L, 1L, false);
                }
                bool = ((com.tencent.mm.recoveryv2.i)localObject).NBV;
                Log.i("MicroMsg.recovery.reporter", "report recovery ui launch real, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  e.Cxv.idkeyStat(1341L, 102L, 1L, false);
                }
                bool = ((com.tencent.mm.recoveryv2.i)localObject).NBW;
                Log.i("MicroMsg.recovery.reporter", "report if recover from crash, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  e.Cxv.idkeyStat(1341L, 101L, 1L, false);
                }
                i = ((com.tencent.mm.recoveryv2.i)localObject).NBX;
                Log.i("MicroMsg.recovery.reporter", "recovery status = ".concat(String.valueOf(i)));
                if (i >= 0)
                {
                  if (i != 0) {
                    break label622;
                  }
                  e.Cxv.idkeyStat(1341L, 103L, 1L, false);
                }
                i = ((com.tencent.mm.recoveryv2.i)localObject).mFrom;
                Log.i("MicroMsg.recovery.reporter", "recovery from = ".concat(String.valueOf(i)));
                if ((i >= 0) && (i < 10)) {
                  e.Cxv.idkeyStat(1341L, i + 140, 1L, false);
                }
                i = ((com.tencent.mm.recoveryv2.i)localObject).NBZ;
                Log.i("MicroMsg.recovery.reporter", "recovery internalStatus = ".concat(String.valueOf(i)));
                if ((i >= 0) && (i < 10)) {
                  e.Cxv.idkeyStat(1341L, i + 150, 1L, false);
                }
                l = ((com.tencent.mm.recoveryv2.i)localObject).NCa;
                if (l <= 0L) {
                  break label803;
                }
                if (l > 10000L) {
                  break label655;
                }
                i = 0;
                if (i >= 0) {
                  e.Cxv.idkeyStat(1341L, i + 160, 1L, false);
                }
                ((com.tencent.mm.recoveryv2.i)localObject).NBC = 0;
                ((com.tencent.mm.recoveryv2.i)localObject).NBU = false;
                ((com.tencent.mm.recoveryv2.i)localObject).NBV = false;
                ((com.tencent.mm.recoveryv2.i)localObject).NBW = false;
                ((com.tencent.mm.recoveryv2.i)localObject).NBX = -1;
                ((com.tencent.mm.recoveryv2.i)localObject).mFrom = 0;
                ((com.tencent.mm.recoveryv2.i)localObject).NBZ = 0;
                ((com.tencent.mm.recoveryv2.i)localObject).NCa = 0L;
                ((com.tencent.mm.recoveryv2.i)localObject).NBY = false;
                ((com.tencent.mm.recoveryv2.i)localObject).NBY = true;
                ((com.tencent.mm.recoveryv2.i)localObject).save();
                continue;
              }
              if (i <= 20) {
                continue;
              }
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.recovery.PluginRecovery", localException, "post recovery fail", new Object[0]);
              AppMethodBeat.o(231548);
              return;
            }
            Log.w("MicroMsg.recovery.reporter", "abnormal crash count found, num = ".concat(String.valueOf(i)));
            e.Cxv.idkeyStat(1341L, 105L, 1L, false);
            continue;
            label622:
            e.Cxv.idkeyStat(1341L, 104L, 1L, false);
            e.Cxv.idkeyStat(1341L, i + 110, 1L, false);
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
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(231550);
          com.tencent.mm.kernel.g.aAi().b(this);
          h.RTc.aX(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 26
              //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: invokestatic 38	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
              //   8: getfield 42	com/tencent/mm/kernel/g:hrh	Lcom/tencent/mm/kernel/h;
              //   11: getfield 48	com/tencent/mm/kernel/h:hrB	Z
              //   14: ifeq +418 -> 432
              //   17: ldc 50
              //   19: ldc 52
              //   21: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   24: invokestatic 63	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
              //   27: astore 11
              //   29: ldc 65
              //   31: invokestatic 69	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
              //   34: checkcast 65	com/tencent/mm/plugin/expt/b/b
              //   37: astore 10
              //   39: aload 10
              //   41: ifnull +391 -> 432
              //   44: aload 11
              //   46: invokestatic 75	com/tencent/mm/recoveryv2/h$a:iN	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/h$a;
              //   49: astore 12
              //   51: aload 10
              //   53: getstatic 81	com/tencent/mm/plugin/expt/b/b$a:siS	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   56: iconst_1
              //   57: invokeinterface 85 3 0
              //   62: istore_1
              //   63: iload_1
              //   64: ifle +406 -> 470
              //   67: iconst_1
              //   68: istore_3
              //   69: aload 12
              //   71: iload_3
              //   72: putfield 88	com/tencent/mm/recoveryv2/h$a:mEnabled	Z
              //   75: aload 12
              //   77: getfield 92	com/tencent/mm/recoveryv2/h$a:NBQ	Lcom/tencent/mm/recoveryv2/g;
              //   80: ldc 94
              //   82: aload 12
              //   84: getfield 88	com/tencent/mm/recoveryv2/h$a:mEnabled	Z
              //   87: invokeinterface 100 3 0
              //   92: invokeinterface 104 1 0
              //   97: pop
              //   98: ldc 106
              //   100: ldc 108
              //   102: iload_1
              //   103: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   106: invokevirtual 118	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   109: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   112: aload 11
              //   114: invokestatic 124	com/tencent/mm/recoveryv2/h:iM	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/h;
              //   117: astore 11
              //   119: aload 10
              //   121: getstatic 127	com/tencent/mm/plugin/expt/b/b$a:siT	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   124: aload 11
              //   126: getfield 131	com/tencent/mm/recoveryv2/h:NBK	I
              //   129: invokeinterface 85 3 0
              //   134: istore_1
              //   135: aload 10
              //   137: getstatic 134	com/tencent/mm/plugin/expt/b/b$a:siU	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   140: aload 11
              //   142: getfield 137	com/tencent/mm/recoveryv2/h:NBL	I
              //   145: invokeinterface 85 3 0
              //   150: istore_2
              //   151: aload 10
              //   153: getstatic 140	com/tencent/mm/plugin/expt/b/b$a:siV	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   156: aload 11
              //   158: getfield 144	com/tencent/mm/recoveryv2/h:NBP	J
              //   161: invokeinterface 147 4 0
              //   166: lstore 4
              //   168: aload 10
              //   170: getstatic 150	com/tencent/mm/plugin/expt/b/b$a:siW	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   173: aload 11
              //   175: getfield 153	com/tencent/mm/recoveryv2/h:NBM	J
              //   178: invokeinterface 147 4 0
              //   183: lstore 6
              //   185: aload 10
              //   187: getstatic 156	com/tencent/mm/plugin/expt/b/b$a:siX	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   190: aload 11
              //   192: getfield 159	com/tencent/mm/recoveryv2/h:NBN	J
              //   195: invokeinterface 147 4 0
              //   200: lstore 8
              //   202: iload_1
              //   203: iconst_2
              //   204: if_icmplt +23 -> 227
              //   207: ldc 106
              //   209: ldc 161
              //   211: iload_1
              //   212: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   215: invokevirtual 118	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   218: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   221: aload 11
              //   223: iload_1
              //   224: putfield 131	com/tencent/mm/recoveryv2/h:NBK	I
              //   227: iload_2
              //   228: aload 11
              //   230: getfield 131	com/tencent/mm/recoveryv2/h:NBK	I
              //   233: if_icmplt +23 -> 256
              //   236: ldc 106
              //   238: ldc 163
              //   240: iload_2
              //   241: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   244: invokevirtual 118	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   247: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   250: aload 11
              //   252: iload_2
              //   253: putfield 137	com/tencent/mm/recoveryv2/h:NBL	I
              //   256: lload 4
              //   258: ldc2_w 164
              //   261: lcmp
              //   262: iflt +25 -> 287
              //   265: ldc 106
              //   267: ldc 167
              //   269: lload 4
              //   271: invokestatic 170	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   274: invokevirtual 118	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   277: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   280: aload 11
              //   282: lload 4
              //   284: putfield 144	com/tencent/mm/recoveryv2/h:NBP	J
              //   287: lload 6
              //   289: ldc2_w 164
              //   292: lcmp
              //   293: iflt +25 -> 318
              //   296: ldc 106
              //   298: ldc 172
              //   300: lload 6
              //   302: invokestatic 170	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   305: invokevirtual 118	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   308: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   311: aload 11
              //   313: lload 6
              //   315: putfield 153	com/tencent/mm/recoveryv2/h:NBM	J
              //   318: lload 8
              //   320: ldc2_w 164
              //   323: lcmp
              //   324: iflt +25 -> 349
              //   327: ldc 106
              //   329: ldc 174
              //   331: lload 8
              //   333: invokestatic 170	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   336: invokevirtual 118	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   339: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   342: aload 11
              //   344: lload 8
              //   346: putfield 159	com/tencent/mm/recoveryv2/h:NBN	J
              //   349: aload 11
              //   351: getfield 175	com/tencent/mm/recoveryv2/h:NBQ	Lcom/tencent/mm/recoveryv2/g;
              //   354: ldc 177
              //   356: aload 11
              //   358: getfield 131	com/tencent/mm/recoveryv2/h:NBK	I
              //   361: invokeinterface 181 3 0
              //   366: ldc 183
              //   368: aload 11
              //   370: getfield 137	com/tencent/mm/recoveryv2/h:NBL	I
              //   373: invokeinterface 181 3 0
              //   378: ldc 185
              //   380: aload 11
              //   382: getfield 153	com/tencent/mm/recoveryv2/h:NBM	J
              //   385: invokeinterface 189 4 0
              //   390: ldc 191
              //   392: aload 11
              //   394: getfield 159	com/tencent/mm/recoveryv2/h:NBN	J
              //   397: invokeinterface 189 4 0
              //   402: ldc 193
              //   404: aload 11
              //   406: getfield 196	com/tencent/mm/recoveryv2/h:NBO	J
              //   409: invokeinterface 189 4 0
              //   414: ldc 198
              //   416: aload 11
              //   418: getfield 144	com/tencent/mm/recoveryv2/h:NBP	J
              //   421: invokeinterface 189 4 0
              //   426: invokeinterface 104 1 0
              //   431: pop
              //   432: aload_0
              //   433: getfield 17	com/tencent/mm/modelrecovery/PluginRecovery$2$1:jhK	Lcom/tencent/mm/modelrecovery/PluginRecovery$2;
              //   436: getfield 202	com/tencent/mm/modelrecovery/PluginRecovery$2:dkN	Lcom/tencent/mm/kernel/b/g;
              //   439: getfield 208	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
              //   442: invokestatic 124	com/tencent/mm/recoveryv2/h:iM	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/h;
              //   445: getfield 144	com/tencent/mm/recoveryv2/h:NBP	J
              //   448: invokestatic 214	java/lang/Thread:sleep	(J)V
              //   451: ldc 50
              //   453: ldc 216
              //   455: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   458: invokestatic 222	com/tencent/mm/recoveryv2/k:guX	()Lcom/tencent/mm/recoveryv2/k;
              //   461: invokevirtual 225	com/tencent/mm/recoveryv2/k:unregister	()V
              //   464: ldc 26
              //   466: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   469: return
              //   470: iconst_0
              //   471: istore_3
              //   472: goto -403 -> 69
              //   475: astore 10
              //   477: ldc 106
              //   479: aload 10
              //   481: ldc 230
              //   483: iconst_0
              //   484: anewarray 4	java/lang/Object
              //   487: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   490: goto -58 -> 432
              //   493: astore 10
              //   495: ldc 50
              //   497: ldc 216
              //   499: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   502: invokestatic 222	com/tencent/mm/recoveryv2/k:guX	()Lcom/tencent/mm/recoveryv2/k;
              //   505: invokevirtual 225	com/tencent/mm/recoveryv2/k:unregister	()V
              //   508: ldc 26
              //   510: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   513: return
              //   514: astore 10
              //   516: ldc 50
              //   518: ldc 216
              //   520: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   523: invokestatic 222	com/tencent/mm/recoveryv2/k:guX	()Lcom/tencent/mm/recoveryv2/k;
              //   526: invokevirtual 225	com/tencent/mm/recoveryv2/k:unregister	()V
              //   529: ldc 26
              //   531: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   534: aload 10
              //   536: athrow
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	537	0	this	1
              //   62	162	1	i	int
              //   150	103	2	j	int
              //   68	404	3	bool	boolean
              //   166	117	4	l1	long
              //   183	131	6	l2	long
              //   200	145	8	l3	long
              //   37	149	10	localb	com.tencent.mm.plugin.expt.b.b
              //   475	5	10	localThrowable	Throwable
              //   493	1	10	localInterruptedException	java.lang.InterruptedException
              //   514	21	10	localObject1	Object
              //   27	390	11	localObject2	Object
              //   49	34	12	locala	com.tencent.mm.recoveryv2.h.a
              // Exception table:
              //   from	to	target	type
              //   29	39	475	java/lang/Throwable
              //   44	63	475	java/lang/Throwable
              //   69	202	475	java/lang/Throwable
              //   207	227	475	java/lang/Throwable
              //   227	256	475	java/lang/Throwable
              //   265	287	475	java/lang/Throwable
              //   296	318	475	java/lang/Throwable
              //   327	349	475	java/lang/Throwable
              //   349	432	475	java/lang/Throwable
              //   432	451	493	java/lang/InterruptedException
              //   432	451	514	finally
            }
          });
          AppMethodBeat.o(231550);
        }
        
        public final void cQ(boolean paramAnonymousBoolean) {}
      });
      MMUncaughtExceptionHandler.setAfterReport(new MMUncaughtExceptionHandler.IAfterReport()
      {
        public final void afterReport()
        {
          AppMethodBeat.i(231551);
          Log.i("MicroMsg.recovery.PluginRecovery", "#afterReport, handling java crash with recovery");
          k.guX().ajx(3);
          AppMethodBeat.o(231551);
        }
      });
    }
    AppMethodBeat.o(231564);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(20582);
    this.jhI.alive();
    AppMethodBeat.o(20582);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20583);
    this.jhI.dead();
    AppMethodBeat.o(20583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */