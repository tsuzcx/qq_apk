package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3) {}
  
  public final void run()
  {
    final long l = bk.UZ();
    a.m(this.jTs.jTm).connect(new Runnable()
    {
      public final void run()
      {
        synchronized (a.a(a.3.1.this.jTs.jTm))
        {
          y.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", new Object[] { Long.valueOf(bk.cp(l)) });
          long l = bk.UZ();
          a.a(a.3.1.this.jTs.jTm, a.e(a.3.1.this.jTs.jTm).YU());
          a.g(a.3.1.this.jTs.jTm).setFilePath(a.f(a.3.1.this.jTs.jTm));
          a.g(a.3.1.this.jTs.jTm).In(a.h(a.3.1.this.jTs.jTm));
          a.g(a.3.1.this.jTs.jTm).hu(true);
          a.g(a.3.1.this.jTs.jTm).u(a.i(a.3.1.this.jTs.jTm), a.j(a.3.1.this.jTs.jTm), a.3.1.this.jTs.jTk, a.3.1.this.jTs.jTl);
          a.g(a.3.1.this.jTs.jTm).ua(a.k(a.3.1.this.jTs.jTm));
          a.g(a.3.1.this.jTs.jTm).a(a.l(a.3.1.this.jTs.jTm));
          a.a(a.3.1.this.jTs.jTm, a.a.jTz);
          y.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
          if (a.3.1.this.jTs.jTr != null) {
            a.3.1.this.jTs.jTr.run();
          }
          return;
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.3.1
 * JD-Core Version:    0.7.0.1
 */