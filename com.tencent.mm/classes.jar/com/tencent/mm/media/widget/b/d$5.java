package com.tencent.mm.media.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.sdk.platformtools.ab;

final class d$5
  implements c.a
{
  d$5(d paramd) {}
  
  public final void XF()
  {
    AppMethodBeat.i(12784);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
    if (this.fcZ.Xw() != d.c.oIN)
    {
      ab.w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
      AppMethodBeat.o(12784);
      return;
    }
    this.fcZ.fcm.a(d.c.oIG);
    AppMethodBeat.o(12784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d.5
 * JD-Core Version:    0.7.0.1
 */