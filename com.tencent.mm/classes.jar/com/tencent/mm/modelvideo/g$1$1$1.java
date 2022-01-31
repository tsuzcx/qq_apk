package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class g$1$1$1
  implements Runnable
{
  g$1$1$1(g.1.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(50693);
    g.m(this.fWi.fWh.fWg);
    g.g(this.fWi.fWh.fWg).status = 104;
    g.g(this.fWi.fWh.fWg).createTime = bo.aox();
    g.g(this.fWi.fWh.fWg).fXv = bo.aox();
    g.g(this.fWi.fWh.fWg).fWa = 0;
    g.g(this.fWi.fWh.fWg).bsY = 1800;
    boolean bool = u.f(g.g(this.fWi.fWh.fWg));
    ab.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.a(this.fWi.fWh.fWg), Boolean.valueOf(g.h(this.fWi.fWh.fWg)), Boolean.valueOf(bool), Long.valueOf(g.g(this.fWi.fWh.fWg).createTime) });
    this.fWi.fWh.fWg.doScene(g.n(this.fWi.fWh.fWg), g.f(this.fWi.fWh.fWg));
    AppMethodBeat.o(50693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g.1.1.1
 * JD-Core Version:    0.7.0.1
 */