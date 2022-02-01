package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.a.ql.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.recoveryv2.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.o;
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
  private com.tencent.mm.sdk.b.c<ql> imA;
  private RecoveryLog.RecoveryLogImpl logImpl;
  private BroadcastReceiver receiver;
  
  public PluginRecovery()
  {
    AppMethodBeat.i(20580);
    this.imA = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(ql paramAnonymousql)
      {
        AppMethodBeat.i(186370);
        switch (paramAnonymousql.dGk.action)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(186370);
          return false;
          b.aKu();
          continue;
          paramAnonymousql = ak.getContext();
          CommonOptions.Builder localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(j.hju);
          localBuilder.setConfigUrl(String.format("file:///sdcard/test-recovery.conf", new Object[0]));
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymousql));
          RecoveryLogic.startHandleService(paramAnonymousql, localBuilder.build(), new RecoveryContext());
          continue;
          paramAnonymousql = ak.getContext();
          localBuilder = new CommonOptions.Builder();
          localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
          localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
          localBuilder.setClientVersion(j.hju);
          localBuilder.setConfigUrl("http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf");
          localBuilder.setUUID(WXUtil.getWXUin(paramAnonymousql));
          RecoveryLogic.startHandleService(paramAnonymousql, localBuilder.build(), new RecoveryContext());
        }
      }
    };
    this.receiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(186372);
        if (paramAnonymousIntent != null)
        {
          if ("com.tecent.recovery.intent.action.LOG".equals(paramAnonymousIntent.getAction()))
          {
            PluginRecovery.access$000(PluginRecovery.this);
            AppMethodBeat.o(186372);
            return;
          }
          if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(paramAnonymousIntent.getAction())) {
            PluginRecovery.access$100(PluginRecovery.this);
          }
        }
        AppMethodBeat.o(186372);
      }
    };
    this.logImpl = new RecoveryLog.RecoveryLogImpl()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(186375);
        ae.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(186375);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(186379);
        ae.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(186379);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(186377);
        ae.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(186377);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(186380);
        ae.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(186380);
      }
      
      public final void setDebugMode() {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(186376);
        ae.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(186376);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(186378);
        ae.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(186378);
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
        AppMethodBeat.i(186373);
        ae.i("MicroMsg.recovery.PluginRecovery", "postLog");
        b.aKu();
        AppMethodBeat.o(186373);
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
        AppMethodBeat.i(186374);
        ae.i("MicroMsg.recovery.PluginRecovery", "postReport");
        c.aKv();
        AppMethodBeat.o(186374);
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
    if (paramg.xO(":sandbox"))
    {
      l = System.currentTimeMillis();
      paramg = new IntentFilter();
      paramg.addAction("com.tecent.recovery.intent.action.LOG");
      paramg.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
    }
    try
    {
      ak.getContext().registerReceiver(this.receiver, paramg);
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
        byte[] arrayOfByte = Integer.toHexString(d.FFH).getBytes();
        o.f(paramg, arrayOfByte, arrayOfByte.length);
        label130:
        ae.i("MicroMsg.recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    AppMethodBeat.i(186381);
    if (paramg.akL())
    {
      h.MqF.aO(new PluginRecovery.1(this, paramg));
      com.tencent.mm.kernel.g.ajS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void ML()
        {
          AppMethodBeat.i(186367);
          com.tencent.mm.kernel.g.ajS().b(this);
          h.MqF.aO(new PluginRecovery.2.1(this));
          AppMethodBeat.o(186367);
        }
        
        public final void ch(boolean paramAnonymousBoolean) {}
      });
      av.a(new av.a()
      {
        public final void Mc()
        {
          AppMethodBeat.i(186368);
          ae.i("MicroMsg.recovery.PluginRecovery", "#afterReport, handling java crash with recovery");
          k.flm().aaI(3);
          AppMethodBeat.o(186368);
        }
      });
    }
    AppMethodBeat.o(186381);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(20582);
    this.imA.alive();
    AppMethodBeat.o(20582);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20583);
    this.imA.dead();
    AppMethodBeat.o(20583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */