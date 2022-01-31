package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class n$3
  implements c.a
{
  n$3(n paramn) {}
  
  public final void XF()
  {
    AppMethodBeat.i(76631);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
    if (this.oJA.Xw() != d.c.oIN)
    {
      ab.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
      AppMethodBeat.o(76631);
      return;
    }
    this.oJA.oJw.start();
    this.oJA.fcm.a(d.c.oIG);
    AppMethodBeat.o(76631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.3
 * JD-Core Version:    0.7.0.1
 */