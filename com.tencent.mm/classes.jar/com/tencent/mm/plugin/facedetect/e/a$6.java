package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.sdk.platformtools.y;

final class a$6
  implements Runnable
{
  a$6(a parama) {}
  
  public final void run()
  {
    synchronized (a.a(this.jTm))
    {
      if (a.n(this.jTm) == a.a.jTy)
      {
        y.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
        a.d(this.jTm);
        return;
      }
      if (a.n(this.jTm) == a.a.jTA)
      {
        y.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
        return;
      }
    }
    y.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
    com.tencent.mm.plugin.facedetect.model.d.aOf().a(a.o(this.jTm));
    a.g(this.jTm).d(a.k(this.jTm), a.p(this.jTm), a.q(this.jTm));
    a.a(this.jTm, a.a.jTA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.6
 * JD-Core Version:    0.7.0.1
 */