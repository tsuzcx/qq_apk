package com.tencent.mm.media.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.a;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements f
{
  d$1(d paramd) {}
  
  public final boolean N(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12778);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ab.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
      AppMethodBeat.o(12778);
      return false;
    }
    if ((this.fcZ.fcm.oJP == d.c.oIG) || (this.fcZ.fcm.oJP == d.c.oIH))
    {
      if (this.fcZ.fcm.oJP == d.c.oIH)
      {
        this.fcZ.fcm.oJP = d.c.oII;
        ab.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
      }
      this.fcZ.fct.kH(1L);
      if (this.fcZ.fcf != null) {
        this.fcZ.fcf.bRk();
      }
      this.fcZ.fcG.a(paramArrayOfByte, System.nanoTime(), new d.1.1(this));
      this.fcZ.fcs.kH(1L);
      AppMethodBeat.o(12778);
      return true;
    }
    AppMethodBeat.o(12778);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d.1
 * JD-Core Version:    0.7.0.1
 */