package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class a$8$1
  implements Runnable
{
  a$8$1(a.8 param8) {}
  
  public final void run()
  {
    synchronized (a.a(this.jTx.jTm))
    {
      y.i("MicroMsg.FaceVideoRecorder", "carson: begin to stop" + a.g(this.jTx.jTm).bjl());
      a.a(this.jTx.jTm, a.a.jTC);
      e.deleteFile(a.h(this.jTx.jTm));
      if (a.r(this.jTx.jTm) != null) {
        a.r(this.jTx.jTm).Cr(a.g(this.jTx.jTm).bjl());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.8.1
 * JD-Core Version:    0.7.0.1
 */