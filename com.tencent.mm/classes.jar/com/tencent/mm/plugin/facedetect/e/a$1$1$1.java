package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$1$1$1
  implements Runnable
{
  a$1$1$1(a.1.1 param1, long paramLong) {}
  
  public final void run()
  {
    synchronized (a.a(this.jTp.jTn.jTm))
    {
      y.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", new Object[] { Long.valueOf(bk.cp(this.jTo)) });
      long l = bk.UZ();
      a.a(this.jTp.jTn.jTm, a.e(this.jTp.jTn.jTm).YU());
      a.g(this.jTp.jTn.jTm).setFilePath(a.f(this.jTp.jTn.jTm));
      a.g(this.jTp.jTn.jTm).In(a.h(this.jTp.jTn.jTm));
      a.g(this.jTp.jTn.jTm).hu(this.jTp.jTn.jTj);
      a.g(this.jTp.jTn.jTm).u(a.i(this.jTp.jTn.jTm), a.j(this.jTp.jTn.jTm), this.jTp.jTn.jTk, this.jTp.jTn.jTl);
      a.g(this.jTp.jTn.jTm).ua(a.k(this.jTp.jTn.jTm));
      a.g(this.jTp.jTn.jTm).a(a.l(this.jTp.jTn.jTm));
      a.a(this.jTp.jTn.jTm, a.a.jTz);
      y.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.1.1.1
 * JD-Core Version:    0.7.0.1
 */