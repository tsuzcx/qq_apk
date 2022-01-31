package com.tencent.mm.insane_statistic;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.as.e;
import com.tencent.mm.as.g;
import com.tencent.mm.as.r.a;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.net.URLEncoder;
import java.util.Map;

public final class b
  implements r.a
{
  public final void a(long paramLong, bi parambi, com.tencent.mm.ah.b paramb, int paramInt, boolean paramBoolean, com.tencent.mm.j.d paramd)
  {
    parambi = new b.a(paramLong, parambi, paramb, paramBoolean, paramInt);
    paramb = com.tencent.mm.model.c.c.IX().fJ("100131");
    if (paramb.isValid()) {
      parambi.dFZ = ah.getInt((String)paramb.ctr().get("needUploadData"), 1);
    }
    if ((parambi.dFX) || ((!parambi.dGb) && (parambi.dFZ == 0))) {
      return;
    }
    parambi.dGa = paramd;
    parambi.dFX = true;
    paramb = ((cbh)parambi.dmK.ecE.ecN).svG.tFO;
    if ((!bk.bl(paramb)) && (s.fn(paramb)))
    {
      paramInt = 1;
      label133:
      paramb = new StringBuilder("2,");
      if (paramInt == 0) {
        break label284;
      }
    }
    label284:
    for (paramInt = 2;; paramInt = 1)
    {
      parambi.dFW = (paramInt + ",,");
      if (parambi.dFV == null) {
        parambi.dFV = com.tencent.mm.as.o.OJ().b(Long.valueOf(parambi.dFT));
      }
      paramb = parambi.dFV;
      if (paramb == null) {
        break;
      }
      paramd = new mz();
      a.udP.c(parambi.dGc);
      a.udP.c(parambi.dGd);
      parambi.dFY = com.tencent.mm.as.o.OJ().o(paramb.enq, "", "");
      paramd.bWF.filePath = parambi.dFY;
      a.udP.m(paramd);
      return;
      paramInt = 0;
      break label133;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */