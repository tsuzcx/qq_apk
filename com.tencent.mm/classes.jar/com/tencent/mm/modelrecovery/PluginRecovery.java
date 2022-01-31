package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.wx.WXConstantsRecovery;

public class PluginRecovery
  extends f
  implements com.tencent.mm.kernel.api.bucket.c
{
  private com.tencent.mm.sdk.b.c<oc> fMV;
  private RecoveryLog.RecoveryLogImpl fMW;
  private BroadcastReceiver receiver;
  
  public PluginRecovery()
  {
    AppMethodBeat.i(16535);
    this.fMV = new PluginRecovery.1(this);
    this.receiver = new PluginRecovery.2(this);
    this.fMW = new RecoveryLog.RecoveryLogImpl()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(16529);
        ab.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(16529);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(16533);
        ab.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(16533);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(16531);
        ab.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(16531);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(16534);
        ab.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(16534);
      }
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(16530);
        ab.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(16530);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(16532);
        ab.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(16532);
      }
    };
    AppMethodBeat.o(16535);
  }
  
  private void postLog()
  {
    AppMethodBeat.i(16539);
    com.tencent.mm.sdk.g.d.post(new PluginRecovery.3(this), "RecoveryWriteLogThread");
    AppMethodBeat.o(16539);
  }
  
  private void postReport()
  {
    AppMethodBeat.i(16540);
    com.tencent.mm.sdk.g.d.post(new PluginRecovery.4(this), "RecoveryReportStatusThread");
    AppMethodBeat.o(16540);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(16536);
    RecoveryLog.a(this.fMW);
    long l;
    if (paramg.mI(":sandbox"))
    {
      l = System.currentTimeMillis();
      paramg = new IntentFilter();
      paramg.addAction("com.tecent.recovery.intent.action.LOG");
      paramg.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
      ah.getContext().registerReceiver(this.receiver, paramg);
      paramg = new b(WXConstantsRecovery.BiJ);
      if (!paramg.exists()) {
        paramg.mkdirs();
      }
      paramg = new b(paramg, "version.info");
      if (paramg.exists()) {
        paramg.delete();
      }
    }
    try
    {
      paramg = j.p(paramg.dQJ());
      byte[] arrayOfByte = Integer.toHexString(com.tencent.mm.protocal.d.whH).getBytes();
      e.b(paramg, arrayOfByte, arrayOfByte.length);
      label133:
      ab.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(16536);
      return;
    }
    catch (Exception paramg)
    {
      break label133;
    }
  }
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(16537);
    this.fMV.alive();
    AppMethodBeat.o(16537);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(16538);
    this.fMV.dead();
    AppMethodBeat.o(16538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */