package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.qk.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.recoveryv2.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
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
  private com.tencent.mm.sdk.b.c<qk> ijH;
  private RecoveryLog.RecoveryLogImpl logImpl;
  private BroadcastReceiver receiver;
  
  public PluginRecovery()
  {
    AppMethodBeat.i(20580);
    this.ijH = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qk paramAnonymousqk)
      {
        AppMethodBeat.i(193125);
        switch (paramAnonymousqk.dFf.action)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(193125);
          return false;
          b.aKb();
          continue;
          paramAnonymousqk = aj.getContext();
          CommonOptions.Builder localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(com.tencent.mm.sdk.platformtools.i.hgG);
          localBuilder.setConfigUrl(String.format("file:///sdcard/test-recovery.conf", new Object[0]));
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymousqk));
          RecoveryLogic.startHandleService(paramAnonymousqk, localBuilder.build(), new RecoveryContext());
          continue;
          paramAnonymousqk = aj.getContext();
          localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(com.tencent.mm.sdk.platformtools.i.hgG);
          localBuilder.setConfigUrl("http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf");
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymousqk));
          RecoveryLogic.startHandleService(paramAnonymousqk, localBuilder.build(), new RecoveryContext());
        }
      }
    };
    this.receiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(193127);
        if (paramAnonymousIntent != null)
        {
          if ("com.tecent.recovery.intent.action.LOG".equals(paramAnonymousIntent.getAction()))
          {
            PluginRecovery.access$000(PluginRecovery.this);
            AppMethodBeat.o(193127);
            return;
          }
          if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramAnonymousIntent.getAction())) {
            PluginRecovery.access$100(PluginRecovery.this);
          }
        }
        AppMethodBeat.o(193127);
      }
    };
    this.logImpl = new RecoveryLog.RecoveryLogImpl()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(193130);
        ad.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(193130);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(193134);
        ad.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(193134);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(193132);
        ad.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(193132);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(193135);
        ad.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(193135);
      }
      
      public final void setDebugMode() {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(193131);
        ad.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(193131);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(193133);
        ad.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(193133);
      }
    };
    AppMethodBeat.o(20580);
  }
  
  private void postLog()
  {
    AppMethodBeat.i(20584);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193128);
        ad.i("MicroMsg.recovery.PluginRecovery", "postLog");
        b.aKb();
        AppMethodBeat.o(193128);
      }
    }, "RecoveryWriteLogThread");
    AppMethodBeat.o(20584);
  }
  
  private void postReport()
  {
    AppMethodBeat.i(20585);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193129);
        ad.i("MicroMsg.recovery.PluginRecovery", "postReport");
        c.aKc();
        AppMethodBeat.o(193129);
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
    if (paramg.xf(":sandbox"))
    {
      l = System.currentTimeMillis();
      paramg = new IntentFilter();
      paramg.addAction("com.tecent.recovery.intent.action.LOG");
      paramg.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
    }
    try
    {
      aj.getContext().registerReceiver(this.receiver, paramg);
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
        byte[] arrayOfByte = Integer.toHexString(d.Fnj).getBytes();
        com.tencent.mm.vfs.i.f(paramg, arrayOfByte, arrayOfByte.length);
        label130:
        ad.i("MicroMsg.recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    AppMethodBeat.i(193136);
    if (paramg.akw())
    {
      h.LTJ.aR(new PluginRecovery.1(this, paramg));
      com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
      {
        public final void MP()
        {
          AppMethodBeat.i(193122);
          com.tencent.mm.kernel.g.ajD().b(this);
          h.LTJ.aR(new PluginRecovery.2.1(this));
          AppMethodBeat.o(193122);
        }
        
        public final void cg(boolean paramAnonymousBoolean) {}
      });
      au.a(new au.a()
      {
        public final void LU()
        {
          AppMethodBeat.i(193123);
          ad.i("MicroMsg.recovery.PluginRecovery", "#afterReport, handling java crash with recovery");
          k.fhu().aac(3);
          AppMethodBeat.o(193123);
        }
      });
    }
    AppMethodBeat.o(193136);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(20582);
    this.ijH.alive();
    AppMethodBeat.o(20582);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20583);
    this.ijH.dead();
    AppMethodBeat.o(20583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */