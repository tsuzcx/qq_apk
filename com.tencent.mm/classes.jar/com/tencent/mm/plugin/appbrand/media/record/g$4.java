package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.mm.h.a.lq;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class g$4
  implements e
{
  g$4(g paramg) {}
  
  public final void amh()
  {
    if (!g.l(this.gNX))
    {
      this.gNX.amt();
      return;
    }
    y.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
  }
  
  public final void ami()
  {
    if (g.l(this.gNX))
    {
      g localg = this.gNX;
      localg.gNS = false;
      y.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
      lq locallq = new lq();
      locallq.bUI.action = 7;
      locallq.bUI.state = "interruptionEnd";
      if (localg.gNJ != null) {
        locallq.bUI.appId = localg.gNJ.appId;
      }
      a.udP.a(locallq, Looper.getMainLooper());
      return;
    }
    y.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.4
 * JD-Core Version:    0.7.0.1
 */