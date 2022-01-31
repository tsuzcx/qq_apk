package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.d;
import com.tencent.mm.model.bf;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

final class l$4$1
  implements Runnable
{
  l$4$1(l.4 param4, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(78322);
    l.o(this.fFU.fFT);
    l.p(this.fFU.fFT);
    l.q(this.fFU.fFT);
    Object localObject = l.d(this.fFU.fFT);
    ((e)localObject).lo(0);
    l.r(this.fFU.fFT).fQ(bf.py(l.r(this.fFU.fFT).field_talker));
    l.a(this.fFU.fFT, c.a("upimg", l.r(this.fFU.fFT).field_createTime, l.r(this.fFU.fFT).field_talker, l.r(this.fFU.fFT).field_msgId + "_" + l.c(this.fFU.fFT) + "_" + l.h(this.fFU.fFT)));
    boolean bool = l.a(this.fFU.fFT, (e)localObject, 0, 0L, 0, this.fyV);
    localObject = (con)l.s(this.fFU.fFT).fsV.fta;
    if (localObject == null) {
      ab.w(l.f(this.fFU.fFT), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
    }
    for (;;)
    {
      ab.i(l.f(this.fFU.fFT), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(this.fFU.fFT)), Boolean.valueOf(bool), l.j(this.fFU.fFT), Long.valueOf(l.r(this.fFU.fFT).field_createTime) });
      this.fFU.fFT.doScene(l.t(this.fFU.fFT), l.g(this.fFU.fFT));
      AppMethodBeat.o(78322);
      return;
      ((con)localObject).xXk = new bwc().aoF(l.j(this.fFU.fFT));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.l.4.1
 * JD-Core Version:    0.7.0.1
 */