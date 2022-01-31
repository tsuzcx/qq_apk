package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class a$2
  implements d.a
{
  a$2(a parama) {}
  
  public final void asO()
  {
    AppMethodBeat.i(544);
    ab.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", new Object[] { Integer.valueOf(1) });
    a.s(this.mnI).ac(new a.2.1(this));
    AppMethodBeat.o(544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.2
 * JD-Core Version:    0.7.0.1
 */