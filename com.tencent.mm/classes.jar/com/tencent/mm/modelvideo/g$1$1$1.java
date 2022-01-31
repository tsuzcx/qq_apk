package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$1$1$1
  implements Runnable
{
  g$1$1$1(g.1.1 param1) {}
  
  public final void run()
  {
    g.m(this.eGs.eGr.eGq);
    g.g(this.eGs.eGr.eGq).status = 104;
    g.g(this.eGs.eGr.eGq).createTime = bk.UX();
    g.g(this.eGs.eGr.eGq).eHF = bk.UX();
    g.g(this.eGs.eGr.eGq).eGk = 0;
    g.g(this.eGs.eGr.eGq).bcw = 1800;
    boolean bool = u.f(g.g(this.eGs.eGr.eGq));
    y.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.a(this.eGs.eGr.eGq), Boolean.valueOf(g.h(this.eGs.eGr.eGq)), Boolean.valueOf(bool), Long.valueOf(g.g(this.eGs.eGr.eGq).createTime) });
    this.eGs.eGr.eGq.a(g.n(this.eGs.eGr.eGq), g.f(this.eGs.eGr.eGq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g.1.1.1
 * JD-Core Version:    0.7.0.1
 */