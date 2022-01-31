package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.h.a.nf;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.wx.WXConstantsRecovery;

public class PluginRecovery
  extends f
  implements com.tencent.mm.kernel.api.bucket.c
{
  private com.tencent.mm.sdk.b.c<nf> exf = new PluginRecovery.1(this);
  private RecoveryLog.RecoveryLogImpl exg = new PluginRecovery.5(this);
  private BroadcastReceiver zm = new PluginRecovery.2(this);
  
  private void postLog()
  {
    com.tencent.mm.sdk.f.e.post(new PluginRecovery.3(this), "RecoveryWriteLogThread");
  }
  
  private void postReport()
  {
    com.tencent.mm.sdk.f.e.post(new PluginRecovery.4(this), "RecoveryReportStatusThread");
  }
  
  public void configure(g paramg)
  {
    RecoveryLog.a(this.exg);
    long l;
    if (paramg.gn(":sandbox"))
    {
      l = System.currentTimeMillis();
      paramg = new IntentFilter();
      paramg.addAction("com.tecent.recovery.intent.action.LOG");
      paramg.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
      ae.getContext().registerReceiver(this.zm, paramg);
      paramg = new b(WXConstantsRecovery.wLk);
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
      paramg = j.n(paramg.cLr());
      byte[] arrayOfByte = Integer.toHexString(d.spa).getBytes();
      com.tencent.mm.vfs.e.b(paramg, arrayOfByte, arrayOfByte.length);
      label127:
      y.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Exception paramg)
    {
      break label127;
    }
  }
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    this.exf.cqo();
  }
  
  public void onAccountRelease()
  {
    this.exf.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery
 * JD-Core Version:    0.7.0.1
 */