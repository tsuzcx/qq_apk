package com.tencent.mm.media.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.sdk.platformtools.ab;

final class c$6
  implements c.a
{
  c$6(c paramc) {}
  
  public final void XF()
  {
    AppMethodBeat.i(12746);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "onPcmReady");
    if (this.fcQ.Xw() != d.c.oIN)
    {
      ab.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
      AppMethodBeat.o(12746);
      return;
    }
    this.fcQ.fcm.a(d.c.oIG);
    AppMethodBeat.o(12746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.c.6
 * JD-Core Version:    0.7.0.1
 */