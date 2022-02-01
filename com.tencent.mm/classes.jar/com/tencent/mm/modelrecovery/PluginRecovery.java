package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.a.pq.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
  private com.tencent.mm.sdk.b.c<pq> hpR;
  private RecoveryLog.RecoveryLogImpl logImpl;
  private BroadcastReceiver receiver;
  
  public PluginRecovery()
  {
    AppMethodBeat.i(20580);
    this.hpR = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(pq paramAnonymouspq)
      {
        AppMethodBeat.i(191141);
        switch (paramAnonymouspq.dvr.action)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(191141);
          return false;
          b.aAa();
          continue;
          paramAnonymouspq = aj.getContext();
          CommonOptions.Builder localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(com.tencent.mm.sdk.platformtools.h.glW);
          localBuilder.setConfigUrl(String.format("file:///sdcard/test-recovery.conf", new Object[0]));
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymouspq));
          RecoveryLogic.startHandleService(paramAnonymouspq, localBuilder.build(), new RecoveryContext());
          continue;
          paramAnonymouspq = aj.getContext();
          localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(com.tencent.mm.sdk.platformtools.h.glW);
          localBuilder.setConfigUrl("http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf");
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymouspq));
          RecoveryLogic.startHandleService(paramAnonymouspq, localBuilder.build(), new RecoveryContext());
        }
      }
    };
    this.receiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(191143);
        if (paramAnonymousIntent != null)
        {
          if ("com.tecent.recovery.intent.action.LOG".equals(paramAnonymousIntent.getAction()))
          {
            PluginRecovery.access$000(PluginRecovery.this);
            AppMethodBeat.o(191143);
            return;
          }
          if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramAnonymousIntent.getAction())) {
            PluginRecovery.access$100(PluginRecovery.this);
          }
        }
        AppMethodBeat.o(191143);
      }
    };
    this.logImpl = new RecoveryLog.RecoveryLogImpl()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(191146);
        ad.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(191146);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(191150);
        ad.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(191150);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(191148);
        ad.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(191148);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(191151);
        ad.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(191151);
      }
      
      public final void setDebugMode() {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(191147);
        ad.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(191147);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(191149);
        ad.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(191149);
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
        AppMethodBeat.i(191144);
        ad.i("MicroMsg.Recovery.PluginRecovery", "postLog");
        b.aAa();
        AppMethodBeat.o(191144);
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
        AppMethodBeat.i(191145);
        ad.i("MicroMsg.Recovery.PluginRecovery", "postReport");
        c.aAb();
        AppMethodBeat.o(191145);
      }
    }, "RecoveryReportStatusThread");
    AppMethodBeat.o(20585);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(20581);
    RecoveryLog.setLogImpl(this.logImpl);
    long l;
    if (paramg.ra(":sandbox"))
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
        byte[] arrayOfByte = Integer.toHexString(d.CpK).getBytes();
        com.tencent.mm.vfs.i.f(paramg, arrayOfByte, arrayOfByte.length);
        label130:
        ad.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(191152);
    if (paramg.agu())
    {
      com.tencent.e.h.Iye.aP(new PluginRecovery.1(this));
      com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lk()
        {
          AppMethodBeat.i(191139);
          com.tencent.mm.kernel.g.afC().b(this);
          com.tencent.e.h.Iye.aP(new PluginRecovery.2.1(this));
          AppMethodBeat.o(191139);
        }
        
        public final void ce(boolean paramAnonymousBoolean) {}
      });
    }
    AppMethodBeat.o(191152);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(20582);
    this.hpR.alive();
    AppMethodBeat.o(20582);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20583);
    this.hpR.dead();
    AppMethodBeat.o(20583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */