package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$8
  implements Runnable
{
  a$8(a parama, a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(553);
    synchronized (a.a(this.mnI))
    {
      a.a(this.mnI, this.mnQ);
      if (a.n(this.mnI) == a.a.mnS)
      {
        ab.e("MicroMsg.FaceVideoRecorder", "hy: not initialized. should not happen");
        a.d(this.mnI);
        if (a.r(this.mnI) != null) {
          a.r(this.mnI).Ns(null);
        }
        AppMethodBeat.o(553);
        return;
      }
      if ((a.n(this.mnI) == a.a.mnX) || (a.n(this.mnI) == a.a.mnT))
      {
        ab.w("MicroMsg.FaceVideoRecorder", "hy: cancelled or not started capturing.");
        a.d(this.mnI);
        if (a.r(this.mnI) != null) {
          a.r(this.mnI).Ns(null);
        }
        AppMethodBeat.o(553);
        return;
      }
      if (a.n(this.mnI) == a.a.mnW)
      {
        ab.i("MicroMsg.FaceVideoRecorder", "hy: already stopped");
        if (a.r(this.mnI) != null) {
          a.r(this.mnI).Ns(a.g(this.mnI).getFilePath());
        }
        AppMethodBeat.o(553);
        return;
      }
      if (a.n(this.mnI) == a.a.mnV)
      {
        ab.i("MicroMsg.FaceVideoRecorder", "hy: stopping. wait");
        AppMethodBeat.o(553);
        return;
      }
      ab.i("MicroMsg.FaceVideoRecorder", "hy: stop record and release" + Thread.currentThread().getName());
      com.tencent.mm.plugin.facedetect.model.d.bui().b(a.o(this.mnI));
      a.a(this.mnI, a.a.mnV);
      a.g(this.mnI).u(new a.8.1(this));
      AppMethodBeat.o(553);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.8
 * JD-Core Version:    0.7.0.1
 */