package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.sdk.platformtools.y;

final class a$8
  implements Runnable
{
  a$8(a parama, a.b paramb) {}
  
  public final void run()
  {
    synchronized (a.a(this.jTm))
    {
      a.a(this.jTm, this.jTw);
      if (a.n(this.jTm) == a.a.jTy)
      {
        y.e("MicroMsg.FaceVideoRecorder", "hy: not initialized. should not happen");
        a.d(this.jTm);
        if (a.r(this.jTm) != null) {
          a.r(this.jTm).Cr(null);
        }
        return;
      }
      if ((a.n(this.jTm) == a.a.jTD) || (a.n(this.jTm) == a.a.jTz))
      {
        y.w("MicroMsg.FaceVideoRecorder", "hy: cancelled or not started capturing.");
        a.d(this.jTm);
        if (a.r(this.jTm) != null) {
          a.r(this.jTm).Cr(null);
        }
        return;
      }
    }
    if (a.n(this.jTm) == a.a.jTC)
    {
      y.i("MicroMsg.FaceVideoRecorder", "hy: already stopped");
      if (a.r(this.jTm) != null) {
        a.r(this.jTm).Cr(a.g(this.jTm).bjl());
      }
      return;
    }
    if (a.n(this.jTm) == a.a.jTB)
    {
      y.i("MicroMsg.FaceVideoRecorder", "hy: stopping. wait");
      return;
    }
    y.i("MicroMsg.FaceVideoRecorder", "hy: stop record and release" + Thread.currentThread().getName());
    com.tencent.mm.plugin.facedetect.model.d.aOf().b(a.o(this.jTm));
    a.a(this.jTm, a.a.jTB);
    a.g(this.jTm).M(new a.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.8
 * JD-Core Version:    0.7.0.1
 */