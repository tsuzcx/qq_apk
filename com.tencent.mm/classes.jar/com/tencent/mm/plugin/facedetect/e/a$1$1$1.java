package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$1$1$1
  implements Runnable
{
  a$1$1$1(a.1.1 param1, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(540);
    synchronized (a.a(this.mnK.mnJ.mnI))
    {
      ab.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", new Object[] { Long.valueOf(bo.av(this.htx)) });
      long l = bo.yB();
      a.a(this.mnK.mnJ.mnI, a.e(this.mnK.mnJ.mnI).asE());
      a.g(this.mnK.mnJ.mnI).setFilePath(a.f(this.mnK.mnJ.mnI));
      a.g(this.mnK.mnJ.mnI).mV(a.h(this.mnK.mnJ.mnI));
      a.g(this.mnK.mnJ.mnI).cG(this.mnK.mnJ.mnF);
      a.g(this.mnK.mnJ.mnI).s(a.i(this.mnK.mnJ.mnI), a.j(this.mnK.mnJ.mnI), this.mnK.mnJ.mnG, this.mnK.mnJ.mnH);
      a.g(this.mnK.mnJ.mnI).km(a.k(this.mnK.mnJ.mnI));
      a.g(this.mnK.mnJ.mnI).a(a.l(this.mnK.mnJ.mnI));
      a.a(this.mnK.mnJ.mnI, a.a.mnT);
      ab.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(540);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.1.1.1
 * JD-Core Version:    0.7.0.1
 */