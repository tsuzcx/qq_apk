package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$3$1$1
  implements Runnable
{
  a$3$1$1(a.3.1 param1, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(545);
    synchronized (a.a(this.mnO.mnN.mnI))
    {
      ab.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", new Object[] { Long.valueOf(bo.av(this.htx)) });
      long l = bo.yB();
      a.a(this.mnO.mnN.mnI, a.e(this.mnO.mnN.mnI).asE());
      a.g(this.mnO.mnN.mnI).setFilePath(a.f(this.mnO.mnN.mnI));
      a.g(this.mnO.mnN.mnI).mV(a.h(this.mnO.mnN.mnI));
      a.g(this.mnO.mnN.mnI).cG(true);
      a.g(this.mnO.mnN.mnI).s(a.i(this.mnO.mnN.mnI), a.j(this.mnO.mnN.mnI), this.mnO.mnN.mnG, this.mnO.mnN.mnH);
      a.g(this.mnO.mnN.mnI).km(a.k(this.mnO.mnN.mnI));
      a.g(this.mnO.mnN.mnI).a(a.l(this.mnO.mnN.mnI));
      a.a(this.mnO.mnN.mnI, a.a.mnT);
      ab.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[] { Long.valueOf(bo.av(l)) });
      if (this.mnO.mnN.mnM != null) {
        this.mnO.mnN.mnM.run();
      }
      AppMethodBeat.o(545);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.3.1.1
 * JD-Core Version:    0.7.0.1
 */