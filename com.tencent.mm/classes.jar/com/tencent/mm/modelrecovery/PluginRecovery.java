package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.sf;
import com.tencent.mm.f.a.sf.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.recoveryv2.i.c;
import com.tencent.mm.recoveryv2.j;
import com.tencent.mm.recoveryv2.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IAfterReport;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.u;
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
  implements com.tencent.mm.kernel.api.bucket.c
{
  private IListener<sf> lYl;
  private RecoveryLog.RecoveryLogImpl logImpl;
  private BroadcastReceiver receiver;
  
  public PluginRecovery()
  {
    AppMethodBeat.i(20580);
    this.lYl = new IListener()
    {
      private static boolean a(sf paramAnonymoussf)
      {
        AppMethodBeat.i(216023);
        switch (paramAnonymoussf.fRM.action)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(216023);
          return false;
          b.bnW();
          continue;
          paramAnonymoussf = MMApplicationContext.getContext();
          CommonOptions.Builder localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(BuildInfo.CLIENT_VERSION);
          localBuilder.setConfigUrl(String.format("file:///sdcard/test-recovery.conf", new Object[0]));
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymoussf));
          RecoveryLogic.startHandleService(paramAnonymoussf, localBuilder.build(), new RecoveryContext());
          continue;
          paramAnonymoussf = MMApplicationContext.getContext();
          localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(BuildInfo.CLIENT_VERSION);
          localBuilder.setConfigUrl("http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf");
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymoussf));
          RecoveryLogic.startHandleService(paramAnonymoussf, localBuilder.build(), new RecoveryContext());
        }
      }
    };
    this.receiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(203754);
        if (paramAnonymousIntent != null)
        {
          if ("com.tecent.recovery.intent.action.LOG".equals(paramAnonymousIntent.getAction()))
          {
            PluginRecovery.access$000(PluginRecovery.this);
            AppMethodBeat.o(203754);
            return;
          }
          if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramAnonymousIntent.getAction())) {
            PluginRecovery.access$100(PluginRecovery.this);
          }
        }
        AppMethodBeat.o(203754);
      }
    };
    this.logImpl = new RecoveryLog.RecoveryLogImpl()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(275771);
        Log.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(275771);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(275776);
        Log.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(275776);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(275773);
        Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(275773);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(275777);
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(275777);
      }
      
      public final void setDebugMode() {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(275772);
        Log.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(275772);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(275774);
        Log.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(275774);
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
        AppMethodBeat.i(290209);
        Log.i("MicroMsg.recovery.PluginRecovery", "postLog");
        b.bnW();
        AppMethodBeat.o(290209);
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
        AppMethodBeat.i(270809);
        Log.i("MicroMsg.recovery.PluginRecovery", "postReport");
        c.bnX();
        AppMethodBeat.o(270809);
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
    if (paramg.MY(":sandbox"))
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
        u.H(paramg.getAbsolutePath(), Integer.toHexString(d.RAD).getBytes());
        label121:
        Log.i("MicroMsg.recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(20581);
        return;
      }
      catch (Exception paramg)
      {
        break label121;
      }
    }
    catch (Exception paramg)
    {
      break label58;
    }
  }
  
  public void execute(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(276681);
    if (paramg.aIE())
    {
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(279438);
          for (;;)
          {
            long l;
            try
            {
              Object localObject = paramg.Zw;
              Log.i("MicroMsg.recovery.reporter", "do recovery report");
              localObject = j.jT((Context)localObject);
              if (((j)localObject).hqG())
              {
                Log.i("MicroMsg.recovery.reporter", "not thing to report");
                i.c localc = i.c.jS(paramg.Zw);
                localc.hqu();
                String str = localc.hqv();
                localObject = str;
                if (TextUtils.isEmpty(str)) {
                  localObject = "nothing";
                }
                Log.i("MicroMsg.recovery.reporter", ">>>>>>> dump recovery internal log (:main) <<<<<<<");
                Log.i("MicroMsg.recovery.reporter", "\n".concat(String.valueOf(localObject)));
                Log.i("MicroMsg.recovery.reporter", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
                localc.hqw();
                AppMethodBeat.o(279438);
                return;
              }
              i = ((j)localObject).hqb();
              Log.i("MicroMsg.recovery.reporter", "report crash count = ".concat(String.valueOf(i)));
              if ((i > 0) && (i <= 20))
              {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, i + 200, 1L, false);
                if (i >= 5) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, i + 220, 1L, false);
                }
                boolean bool = ((j)localObject).hqx();
                Log.i("MicroMsg.recovery.reporter", "report recovery ui launch, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, 100L, 1L, false);
                }
                bool = ((j)localObject).hqy();
                Log.i("MicroMsg.recovery.reporter", "report recovery ui launch real, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, 102L, 1L, false);
                }
                bool = ((j)localObject).hqA();
                Log.i("MicroMsg.recovery.reporter", "report if recover from crash, result = ".concat(String.valueOf(bool)));
                if (bool) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, 101L, 1L, false);
                }
                i = ((j)localObject).hqC();
                Log.i("MicroMsg.recovery.reporter", "recovery status = ".concat(String.valueOf(i)));
                if (i >= 0)
                {
                  if (i != 0) {
                    break label558;
                  }
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, 103L, 1L, false);
                }
                i = ((j)localObject).hqD();
                Log.i("MicroMsg.recovery.reporter", "recovery from = ".concat(String.valueOf(i)));
                if ((i >= 0) && (i < 10)) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, i + 140, 1L, false);
                }
                i = ((j)localObject).hqE();
                Log.i("MicroMsg.recovery.reporter", "recovery internalStatus = ".concat(String.valueOf(i)));
                if ((i >= 0) && (i < 10)) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, i + 150, 1L, false);
                }
                l = ((j)localObject).hqF();
                if (l <= 0L) {
                  break label739;
                }
                if (l > 10000L) {
                  break label591;
                }
                i = 0;
                if (i >= 0) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, i + 160, 1L, false);
                }
                ((j)localObject).hqH().EA(true).arg();
                continue;
              }
              if (i <= 20) {
                continue;
              }
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.recovery.PluginRecovery", localException, "post recovery fail", new Object[0]);
              AppMethodBeat.o(279438);
              return;
            }
            Log.w("MicroMsg.recovery.reporter", "abnormal crash count found, num = ".concat(String.valueOf(i)));
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, 105L, 1L, false);
            continue;
            label558:
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, 104L, 1L, false);
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1341L, i + 110, 1L, false);
            continue;
            label591:
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
            label739:
            int i = -1;
          }
        }
      });
      com.tencent.mm.kernel.h.aHH().a(new com.tencent.mm.kernel.api.g()
      {
        public final void abB()
        {
          AppMethodBeat.i(284067);
          com.tencent.mm.kernel.h.aHH().b(this);
          com.tencent.e.h.ZvG.be(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 26
              //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: invokestatic 38	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
              //   8: getfield 42	com/tencent/mm/kernel/h:kdc	Lcom/tencent/mm/kernel/i;
              //   11: getfield 48	com/tencent/mm/kernel/i:kdw	Z
              //   14: ifeq +325 -> 339
              //   17: ldc 50
              //   19: ldc 52
              //   21: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   24: invokestatic 63	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
              //   27: astore 11
              //   29: ldc 65
              //   31: invokestatic 69	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
              //   34: checkcast 65	com/tencent/mm/plugin/expt/b/b
              //   37: astore 10
              //   39: aload 10
              //   41: ifnull +298 -> 339
              //   44: aload 11
              //   46: invokestatic 75	com/tencent/mm/recoveryv2/i$a:jQ	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/i$a;
              //   49: astore 12
              //   51: aload 10
              //   53: getstatic 81	com/tencent/mm/plugin/expt/b/b$a:vSZ	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   56: iconst_1
              //   57: invokeinterface 85 3 0
              //   62: istore_1
              //   63: iload_1
              //   64: ifle +313 -> 377
              //   67: iconst_1
              //   68: istore_3
              //   69: aload 12
              //   71: iload_3
              //   72: invokevirtual 89	com/tencent/mm/recoveryv2/i$a:Ez	(Z)Lcom/tencent/mm/recoveryv2/i$a;
              //   75: invokevirtual 92	com/tencent/mm/recoveryv2/i$a:arg	()V
              //   78: ldc 94
              //   80: ldc 96
              //   82: iload_1
              //   83: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   86: invokevirtual 106	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   89: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   92: aload 11
              //   94: invokestatic 112	com/tencent/mm/recoveryv2/i:jP	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/i;
              //   97: astore 11
              //   99: aload 10
              //   101: getstatic 115	com/tencent/mm/plugin/expt/b/b$a:vTa	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   104: aload 11
              //   106: invokevirtual 119	com/tencent/mm/recoveryv2/i:hqp	()I
              //   109: invokeinterface 85 3 0
              //   114: istore_1
              //   115: aload 10
              //   117: getstatic 122	com/tencent/mm/plugin/expt/b/b$a:vTb	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   120: aload 11
              //   122: invokevirtual 125	com/tencent/mm/recoveryv2/i:hqq	()I
              //   125: invokeinterface 85 3 0
              //   130: istore_2
              //   131: aload 10
              //   133: getstatic 128	com/tencent/mm/plugin/expt/b/b$a:vTc	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   136: aload 11
              //   138: invokevirtual 132	com/tencent/mm/recoveryv2/i:hqr	()J
              //   141: invokeinterface 135 4 0
              //   146: lstore 4
              //   148: aload 10
              //   150: getstatic 138	com/tencent/mm/plugin/expt/b/b$a:vTd	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   153: aload 11
              //   155: invokevirtual 141	com/tencent/mm/recoveryv2/i:hqn	()J
              //   158: invokeinterface 135 4 0
              //   163: lstore 6
              //   165: aload 10
              //   167: getstatic 144	com/tencent/mm/plugin/expt/b/b$a:vTe	Lcom/tencent/mm/plugin/expt/b/b$a;
              //   170: aload 11
              //   172: invokevirtual 147	com/tencent/mm/recoveryv2/i:hqo	()J
              //   175: invokeinterface 135 4 0
              //   180: lstore 8
              //   182: iload_1
              //   183: iconst_2
              //   184: if_icmplt +24 -> 208
              //   187: ldc 94
              //   189: ldc 149
              //   191: iload_1
              //   192: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   195: invokevirtual 106	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   198: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   201: aload 11
              //   203: iload_1
              //   204: invokevirtual 153	com/tencent/mm/recoveryv2/i:arH	(I)Lcom/tencent/mm/recoveryv2/i;
              //   207: pop
              //   208: iload_2
              //   209: aload 11
              //   211: invokevirtual 119	com/tencent/mm/recoveryv2/i:hqp	()I
              //   214: if_icmplt +24 -> 238
              //   217: ldc 94
              //   219: ldc 155
              //   221: iload_2
              //   222: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
              //   225: invokevirtual 106	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   228: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   231: aload 11
              //   233: iload_2
              //   234: invokevirtual 158	com/tencent/mm/recoveryv2/i:arI	(I)Lcom/tencent/mm/recoveryv2/i;
              //   237: pop
              //   238: lload 4
              //   240: ldc2_w 159
              //   243: lcmp
              //   244: iflt +26 -> 270
              //   247: ldc 94
              //   249: ldc 162
              //   251: lload 4
              //   253: invokestatic 165	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   256: invokevirtual 106	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   259: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   262: aload 11
              //   264: lload 4
              //   266: invokevirtual 169	com/tencent/mm/recoveryv2/i:Ui	(J)Lcom/tencent/mm/recoveryv2/i;
              //   269: pop
              //   270: lload 6
              //   272: ldc2_w 159
              //   275: lcmp
              //   276: iflt +26 -> 302
              //   279: ldc 94
              //   281: ldc 171
              //   283: lload 6
              //   285: invokestatic 165	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   288: invokevirtual 106	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   291: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   294: aload 11
              //   296: lload 6
              //   298: invokevirtual 174	com/tencent/mm/recoveryv2/i:Ug	(J)Lcom/tencent/mm/recoveryv2/i;
              //   301: pop
              //   302: lload 8
              //   304: ldc2_w 159
              //   307: lcmp
              //   308: iflt +26 -> 334
              //   311: ldc 94
              //   313: ldc 176
              //   315: lload 8
              //   317: invokestatic 165	java/lang/String:valueOf	(J)Ljava/lang/String;
              //   320: invokevirtual 106	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   323: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   326: aload 11
              //   328: lload 8
              //   330: invokevirtual 179	com/tencent/mm/recoveryv2/i:Uh	(J)Lcom/tencent/mm/recoveryv2/i;
              //   333: pop
              //   334: aload 11
              //   336: invokevirtual 180	com/tencent/mm/recoveryv2/i:arg	()V
              //   339: aload_0
              //   340: getfield 17	com/tencent/mm/modelrecovery/PluginRecovery$2$1:lYn	Lcom/tencent/mm/modelrecovery/PluginRecovery$2;
              //   343: getfield 184	com/tencent/mm/modelrecovery/PluginRecovery$2:fcw	Lcom/tencent/mm/kernel/b/g;
              //   346: getfield 190	com/tencent/mm/kernel/b/g:Zw	Landroid/app/Application;
              //   349: invokestatic 112	com/tencent/mm/recoveryv2/i:jP	(Landroid/content/Context;)Lcom/tencent/mm/recoveryv2/i;
              //   352: invokevirtual 132	com/tencent/mm/recoveryv2/i:hqr	()J
              //   355: invokestatic 196	java/lang/Thread:sleep	(J)V
              //   358: ldc 50
              //   360: ldc 198
              //   362: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   365: invokestatic 204	com/tencent/mm/recoveryv2/l:hqR	()Lcom/tencent/mm/recoveryv2/l;
              //   368: invokevirtual 207	com/tencent/mm/recoveryv2/l:unregister	()V
              //   371: ldc 26
              //   373: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   376: return
              //   377: iconst_0
              //   378: istore_3
              //   379: goto -310 -> 69
              //   382: astore 10
              //   384: ldc 94
              //   386: aload 10
              //   388: ldc 212
              //   390: iconst_0
              //   391: anewarray 4	java/lang/Object
              //   394: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   397: goto -58 -> 339
              //   400: astore 10
              //   402: ldc 50
              //   404: ldc 198
              //   406: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   409: invokestatic 204	com/tencent/mm/recoveryv2/l:hqR	()Lcom/tencent/mm/recoveryv2/l;
              //   412: invokevirtual 207	com/tencent/mm/recoveryv2/l:unregister	()V
              //   415: ldc 26
              //   417: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   420: return
              //   421: astore 10
              //   423: ldc 50
              //   425: ldc 198
              //   427: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   430: invokestatic 204	com/tencent/mm/recoveryv2/l:hqR	()Lcom/tencent/mm/recoveryv2/l;
              //   433: invokevirtual 207	com/tencent/mm/recoveryv2/l:unregister	()V
              //   436: ldc 26
              //   438: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   441: aload 10
              //   443: athrow
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	444	0	this	1
              //   62	142	1	i	int
              //   130	104	2	j	int
              //   68	311	3	bool	boolean
              //   146	119	4	l1	long
              //   163	134	6	l2	long
              //   180	149	8	l3	long
              //   37	129	10	localb	com.tencent.mm.plugin.expt.b.b
              //   382	5	10	localThrowable	Throwable
              //   400	1	10	localInterruptedException	java.lang.InterruptedException
              //   421	21	10	localObject1	Object
              //   27	308	11	localObject2	Object
              //   49	21	12	locala	com.tencent.mm.recoveryv2.i.a
              // Exception table:
              //   from	to	target	type
              //   29	39	382	java/lang/Throwable
              //   44	63	382	java/lang/Throwable
              //   69	182	382	java/lang/Throwable
              //   187	208	382	java/lang/Throwable
              //   208	238	382	java/lang/Throwable
              //   247	270	382	java/lang/Throwable
              //   279	302	382	java/lang/Throwable
              //   311	334	382	java/lang/Throwable
              //   334	339	382	java/lang/Throwable
              //   339	358	400	java/lang/InterruptedException
              //   339	358	421	finally
            }
          });
          AppMethodBeat.o(284067);
        }
        
        public final void dn(boolean paramAnonymousBoolean) {}
      });
      MMUncaughtExceptionHandler.setAfterReport(new MMUncaughtExceptionHandler.IAfterReport()
      {
        public final void afterReport()
        {
          AppMethodBeat.i(287306);
          Log.i("MicroMsg.recovery.PluginRecovery", "#afterReport, handling java crash with recovery");
          l.hqR().arP(3);
          AppMethodBeat.o(287306);
        }
      });
    }
    AppMethodBeat.o(276681);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(20582);
    this.lYl.alive();
    AppMethodBeat.o(20582);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20583);
    this.lYl.dead();
    AppMethodBeat.o(20583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */