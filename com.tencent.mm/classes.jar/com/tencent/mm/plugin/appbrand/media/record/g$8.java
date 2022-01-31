package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class g$8
  implements ap.a
{
  g$8(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(141597);
    ab.i("MicroMsg.Record.AudioRecordMgr", "timer, onTimerExpired to stop record");
    this.ipI.Et();
    AppMethodBeat.o(141597);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.8
 * JD-Core Version:    0.7.0.1
 */