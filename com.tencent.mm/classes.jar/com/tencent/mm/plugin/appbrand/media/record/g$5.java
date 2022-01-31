package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class g$5
  implements e
{
  g$5(g paramg) {}
  
  public final void aHO()
  {
    AppMethodBeat.i(141592);
    if (!g.l(this.ipI))
    {
      this.ipI.aHY();
      AppMethodBeat.o(141592);
      return;
    }
    ab.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
    AppMethodBeat.o(141592);
  }
  
  public final void aHP()
  {
    AppMethodBeat.i(141593);
    if (g.l(this.ipI))
    {
      g localg = this.ipI;
      localg.ipE = false;
      ab.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
      mg localmg = new mg();
      localmg.cCp.action = 7;
      localmg.cCp.state = "interruptionEnd";
      if (localg.ipw != null) {
        localmg.cCp.appId = localg.ipw.appId;
      }
      a.ymk.a(localmg, Looper.getMainLooper());
      AppMethodBeat.o(141593);
      return;
    }
    ab.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
    AppMethodBeat.o(141593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.5
 * JD-Core Version:    0.7.0.1
 */