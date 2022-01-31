package com.tencent.mm.as;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.d;
import com.tencent.mm.model.bd;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class l$4$1
  implements Runnable
{
  l$4$1(l.4 param4, d paramd) {}
  
  public final void run()
  {
    l.o(this.epu.ept);
    l.p(this.epu.ept);
    l.q(this.epu.ept);
    Object localObject = l.d(this.epu.ept);
    ((e)localObject).iA(0);
    l.r(this.epu.ept).bg(bd.iK(l.r(this.epu.ept).field_talker));
    l.a(this.epu.ept, c.a("upimg", l.r(this.epu.ept).field_createTime, l.r(this.epu.ept).field_talker, l.r(this.epu.ept).field_msgId + "_" + l.c(this.epu.ept) + "_" + l.h(this.epu.ept)));
    boolean bool = l.a(this.epu.ept, (e)localObject, 0, 0L, 0, this.eiR);
    localObject = (cbh)l.s(this.epu.ept).ecE.ecN;
    if (localObject == null) {
      y.w(l.f(this.epu.ept), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
    }
    for (;;)
    {
      y.i(l.f(this.epu.ept), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(this.epu.ept)), Boolean.valueOf(bool), l.j(this.epu.ept), Long.valueOf(l.r(this.epu.ept).field_createTime) });
      this.epu.ept.a(l.t(this.epu.ept), l.g(this.epu.ept));
      return;
      ((cbh)localObject).tQp = new bml().YI(l.j(this.epu.ept));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.l.4.1
 * JD-Core Version:    0.7.0.1
 */