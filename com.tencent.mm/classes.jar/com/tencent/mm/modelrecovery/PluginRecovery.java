package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.pz.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
  private com.tencent.mm.sdk.b.c<pz> hQt;
  private RecoveryLog.RecoveryLogImpl logImpl;
  private BroadcastReceiver receiver;
  
  public PluginRecovery()
  {
    AppMethodBeat.i(20580);
    this.hQt = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(pz paramAnonymouspz)
      {
        AppMethodBeat.i(195943);
        switch (paramAnonymouspz.dtd.action)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(195943);
          return false;
          b.aGQ();
          continue;
          paramAnonymouspz = ai.getContext();
          CommonOptions.Builder localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(com.tencent.mm.sdk.platformtools.h.gMJ);
          localBuilder.setConfigUrl(String.format("file:///sdcard/test-recovery.conf", new Object[0]));
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymouspz));
          RecoveryLogic.startHandleService(paramAnonymouspz, localBuilder.build(), new RecoveryContext());
          continue;
          paramAnonymouspz = ai.getContext();
          localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(com.tencent.mm.sdk.platformtools.h.gMJ);
          localBuilder.setConfigUrl("http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf");
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymouspz));
          RecoveryLogic.startHandleService(paramAnonymouspz, localBuilder.build(), new RecoveryContext());
        }
      }
    };
    this.receiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(195945);
        if (paramAnonymousIntent != null)
        {
          if ("com.tecent.recovery.intent.action.LOG".equals(paramAnonymousIntent.getAction()))
          {
            PluginRecovery.access$000(PluginRecovery.this);
            AppMethodBeat.o(195945);
            return;
          }
          if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramAnonymousIntent.getAction())) {
            PluginRecovery.access$100(PluginRecovery.this);
          }
        }
        AppMethodBeat.o(195945);
      }
    };
    this.logImpl = new RecoveryLog.RecoveryLogImpl()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(195948);
        ac.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(195948);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(195952);
        ac.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(195952);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(195950);
        ac.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(195950);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(195953);
        ac.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(195953);
      }
      
      public final void setDebugMode() {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(195949);
        ac.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(195949);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(195951);
        ac.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(195951);
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
        AppMethodBeat.i(195946);
        ac.i("MicroMsg.Recovery.PluginRecovery", "postLog");
        b.aGQ();
        AppMethodBeat.o(195946);
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
        AppMethodBeat.i(195947);
        ac.i("MicroMsg.Recovery.PluginRecovery", "postReport");
        c.aGR();
        AppMethodBeat.o(195947);
      }
    }, "RecoveryReportStatusThread");
    AppMethodBeat.o(20585);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(20581);
    RecoveryLog.setLogImpl(this.logImpl);
    long l;
    if (paramg.up(":sandbox"))
    {
      l = System.currentTimeMillis();
      paramg = new IntentFilter();
      paramg.addAction("com.tecent.recovery.intent.action.LOG");
      paramg.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
    }
    try
    {
      ai.getContext().registerReceiver(this.receiver, paramg);
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
        byte[] arrayOfByte = Integer.toHexString(d.DIc).getBytes();
        com.tencent.mm.vfs.i.f(paramg, arrayOfByte, arrayOfByte.length);
        label130:
        ac.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    AppMethodBeat.i(195954);
    if (paramg.ahL())
    {
      com.tencent.e.h.JZN.aS(new PluginRecovery.1(this));
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(195941);
          com.tencent.mm.kernel.g.agS().b(this);
          com.tencent.e.h.JZN.aS(new PluginRecovery.2.1(this));
          AppMethodBeat.o(195941);
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
    }
    AppMethodBeat.o(195954);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(20582);
    this.hQt.alive();
    AppMethodBeat.o(20582);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20583);
    this.hQt.dead();
    AppMethodBeat.o(20583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */