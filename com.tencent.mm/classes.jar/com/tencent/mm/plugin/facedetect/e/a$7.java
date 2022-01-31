package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.sdk.platformtools.y;

final class a$7
  implements Runnable
{
  a$7(a parama) {}
  
  public final void run()
  {
    synchronized (a.a(this.jTm))
    {
      if (a.n(this.jTm) == a.a.jTy)
      {
        y.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
        a.d(this.jTm);
        return;
      }
      y.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
      a.g(this.jTm).cancel();
      a.d(this.jTm);
      com.tencent.mm.plugin.facedetect.model.d.aOf().b(a.o(this.jTm));
      a.a(this.jTm, a.a.jTD);
      a.m(this.jTm).release();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.7
 * JD-Core Version:    0.7.0.1
 */