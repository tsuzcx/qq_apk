package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.at.e;
import com.tencent.mm.at.g;
import com.tencent.mm.at.r.a;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.net.URLEncoder;
import java.util.Map;

public final class b
  implements r.a
{
  public final void a(long paramLong, bi parambi, com.tencent.mm.ai.b paramb, int paramInt, boolean paramBoolean, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(16182);
    parambi = new b.a(paramLong, parambi, paramb, paramBoolean, paramInt);
    paramb = com.tencent.mm.model.c.c.abU().me("100131");
    if (paramb.isValid()) {
      parambi.eDB = ah.getInt((String)paramb.dvN().get("needUploadData"), 1);
    }
    if ((parambi.eDz) || ((!parambi.eDD) && (parambi.eDB == 0)))
    {
      AppMethodBeat.o(16182);
      return;
    }
    parambi.eDC = paramd;
    parambi.eDz = true;
    paramb = ((con)parambi.rr.fsV.fta).woQ.xJE;
    if ((!bo.isNullOrNil(paramb)) && (t.lA(paramb)))
    {
      paramInt = 1;
      paramb = new StringBuilder("2,");
      if (paramInt == 0) {
        break label302;
      }
    }
    label302:
    for (paramInt = 2;; paramInt = 1)
    {
      parambi.eDy = (paramInt + ",,");
      if (parambi.eDx == null) {
        parambi.eDx = com.tencent.mm.at.o.ahC().b(Long.valueOf(parambi.eDv));
      }
      paramb = parambi.eDx;
      if (paramb != null)
      {
        paramd = new nw();
        a.ymk.c(parambi.eDE);
        a.ymk.c(parambi.eDF);
        parambi.eDA = com.tencent.mm.at.o.ahC().q(paramb.fDM, "", "");
        paramd.cEv.filePath = parambi.eDA;
        a.ymk.l(paramd);
      }
      AppMethodBeat.o(16182);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */