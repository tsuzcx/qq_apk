package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderRedDotReporter;", "", "()V", "INNER_VERSION", "", "report20411", "", "currUI", "", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "action", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "autoClick", "currentTabType", "contextId", "report20951", "revokeState", "revokeType", "whiteListReddotList", "overwriteTipsId", "plugin-finder_release"})
public final class j
{
  public static final j vft;
  
  static
  {
    AppMethodBeat.i(250627);
    vft = new j();
    AppMethodBeat.o(250627);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.extension.reddot.k paramk, bdo parambdo, int paramInt1, bbn parambbn, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(250624);
    p.h(paramString, "currUI");
    p.h(paramk, "ctrInfo");
    p.h(parambdo, "showInfo");
    dt localdt = new dt();
    localdt.kA(paramk.field_ctrInfo.type);
    localdt.pI(paramk.field_tipsId);
    localdt.pJ(parambdo.path);
    localdt.pK(parambdo.Bvg);
    localdt.kB(parambdo.xGz);
    localdt.kC(parambdo.count);
    localdt.pL(parambdo.title);
    Object localObject = com.tencent.mm.ac.g.bN(paramk.dbx());
    ((JSONObject)localObject).put("object_id", d.zs(paramk.dbx().object_id));
    localObject = ((JSONObject)localObject).toString();
    p.g(localObject, "extInfo.toString()");
    localdt.pM(n.j((String)localObject, ",", ";", false));
    localdt.kD(paramInt1);
    localdt.pN(paramString);
    if (parambbn != null)
    {
      paramString = parambbn.sGQ;
      localdt.pO(paramString);
      if (parambbn == null) {
        break label426;
      }
      paramString = parambbn.sGE;
      label209:
      localdt.pP(paramString);
      paramString = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() != 1) {
        break label431;
      }
      l = 1L;
      label239:
      localdt.kE(l);
      paramString = com.tencent.mm.kernel.g.ah(aj.class);
      p.g(paramString, "MMKernel.plugin(IPluginFinder::class.java)");
      paramString = ((aj)paramString).getRedDotManager();
      p.g(paramString, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!paramString.daH()) {
        break label437;
      }
      l = 1L;
      label290:
      localdt.kF(l);
      if (paramInt2 != 0) {
        break label443;
      }
      l = 1L;
      label306:
      localdt.kG(l);
      localdt.afg();
      if (parambbn == null) {
        break label449;
      }
      paramString = parambbn.sessionId;
      label331:
      localdt.pQ(paramString);
      localdt.kH(paramk.field_time);
      localdt.pR(parambdo.qGB);
      localdt.kI(paramInt3);
      paramString = y.vXH;
      if (!y.dCB()) {
        break label454;
      }
    }
    label426:
    label431:
    label437:
    label443:
    label449:
    label454:
    for (long l = 1L;; l = 2L)
    {
      localdt.kJ(l);
      localdt.kK(cl.aWA());
      localdt.bfK();
      paramString = k.vfA;
      k.a((a)localdt);
      AppMethodBeat.o(250624);
      return;
      paramString = null;
      break;
      paramString = null;
      break label209;
      l = 0L;
      break label239;
      l = 0L;
      break label290;
      l = 0L;
      break label306;
      paramString = null;
      break label331;
    }
  }
  
  public static void a(String paramString1, com.tencent.mm.plugin.finder.extension.reddot.k paramk, bdo parambdo, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(250622);
    p.h(paramString1, "currUI");
    p.h(paramk, "ctrInfo");
    p.h(parambdo, "showInfo");
    p.h(paramString2, "contextId");
    bbn localbbn = new bbn();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbbn.sessionId = str1;
    localbbn.sGQ = paramString2;
    localbbn.sGE = "";
    a(paramString1, paramk, parambdo, paramInt1, localbbn, paramInt2, 0, 64);
    AppMethodBeat.o(250622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.j
 * JD-Core Version:    0.7.0.1
 */