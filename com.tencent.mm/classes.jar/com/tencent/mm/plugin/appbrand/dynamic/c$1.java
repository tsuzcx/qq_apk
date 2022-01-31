package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.j.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

final class c$1
  implements b.a
{
  c$1(c paramc) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(10660);
    ab.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.appbrand.widget.f localf = this.hno.hnf;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.qsU.idkeyStat(638L, 0L, 1L, false);
      if ((this.hno.hnd == 1) && (!this.hno.hnk))
      {
        v.kS(18);
        paramString = new af().fB(u.qn(this.hno.equ));
        paramString.cUl = u.qm(this.hno.equ);
        paramString.cUh = 10L;
        paramString.cUj = 2L;
        paramString = paramString.fA(this.hno.equ);
        paramString.cUi = System.currentTimeMillis();
        paramString.fC(at.gU(ah.getContext())).ake();
      }
      if (localf != null) {}
      for (long l = localf.field_interval;; l = 10L)
      {
        b.l(this.hno.hnn, l * 1000L);
        if ((this.hno.hnf == null) || (TextUtils.isEmpty(this.hno.hnf.field_data))) {
          j.azD().O(this.hno.equ, 627, 2);
        }
        AppMethodBeat.o(10660);
        return;
      }
    }
    if ((this.hno.hnd == 1) && (!this.hno.hnk))
    {
      this.hno.hnk = true;
      v.kS(17);
      paramString = new af().fB(u.qn(this.hno.equ));
      paramString.cUl = u.qm(this.hno.equ);
      paramString.cUh = 10L;
      paramString.cUj = 1L;
      paramString = paramString.fA(this.hno.equ);
      paramString.cUi = System.currentTimeMillis();
      paramString.fC(at.gU(ah.getContext())).ake();
    }
    paramb = (zb)paramb.fsW.fta;
    if (paramb.wPX != null) {}
    for (paramString = paramb.wPX.dqj(); localf == null; paramString = "")
    {
      AppMethodBeat.o(10660);
      return;
    }
    if (!bo.isNullOrNil(paramString)) {
      localf.field_data = paramString;
    }
    for (;;)
    {
      localf.field_interval = paramb.eAS;
      localf.field_updateTime = System.currentTimeMillis();
      paramString = (Bundle)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", localf.convertTo(), b.b.class);
      if (paramString != null) {
        paramString.getBoolean("result", false);
      }
      if (this.hno.ajS) {
        break;
      }
      ab.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
      AppMethodBeat.o(10660);
      return;
      if ((this.hno.hnf == null) || (TextUtils.isEmpty(this.hno.hnf.field_data))) {
        j.azD().O(this.hno.equ, 627, 4);
      }
    }
    this.hno.a(this.hno.eGt, localf);
    if ((this.hno.hnd == 1) && (!this.hno.hnl)) {
      this.hno.hnl = true;
    }
    if (localf.field_interval > 0) {
      this.hno.azw();
    }
    AppMethodBeat.o(10660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.1
 * JD-Core Version:    0.7.0.1
 */