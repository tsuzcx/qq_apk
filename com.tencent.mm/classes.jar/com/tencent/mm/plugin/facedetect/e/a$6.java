package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$6
  implements Runnable
{
  a$6(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(550);
    synchronized (a.a(this.mnI))
    {
      if (a.n(this.mnI) == a.a.mnS)
      {
        ab.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
        a.d(this.mnI);
        AppMethodBeat.o(550);
        return;
      }
      if (a.n(this.mnI) == a.a.mnU)
      {
        ab.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
        AppMethodBeat.o(550);
        return;
      }
      ab.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
      com.tencent.mm.plugin.facedetect.model.d.bui().a(a.o(this.mnI));
      a.g(this.mnI).b(a.k(this.mnI), a.p(this.mnI), a.q(this.mnI));
      a.a(this.mnI, a.a.mnU);
      AppMethodBeat.o(550);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.6
 * JD-Core Version:    0.7.0.1
 */