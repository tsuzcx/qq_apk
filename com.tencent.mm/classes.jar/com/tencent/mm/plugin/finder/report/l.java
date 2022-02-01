package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.f.b.a.en;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkn;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderRedDotReporter;", "", "()V", "INNER_VERSION", "", "makeCountDetail", "", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "report20411", "", "currUI", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "action", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "autoClick", "currentTabType", "clickSubTabContextid", "contextId", "clickTabContextId", "report20951", "revokeState", "revokeType", "whiteListReddotList", "overwriteTipsId", "plugin-finder_release"})
public final class l
{
  public static final l zWx;
  
  static
  {
    AppMethodBeat.i(238153);
    zWx = new l();
    AppMethodBeat.o(238153);
  }
  
  private static void a(String paramString1, com.tencent.mm.plugin.finder.extension.reddot.l paraml, bkn parambkn, int paramInt1, bid parambid, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(238144);
    p.k(paramString1, "currUI");
    p.k(paraml, "ctrInfo");
    p.k(parambkn, "showInfo");
    p.k(paramString2, "clickSubTabContextid");
    en localen = new en();
    localen.lL(paraml.field_ctrInfo.type);
    localen.st(paraml.field_tipsId);
    localen.su(parambkn.path);
    localen.sv(parambkn.HpB);
    localen.lM(parambkn.CKC);
    localen.lN(parambkn.count);
    localen.sw(parambkn.title);
    Object localObject = g.bN(paraml.drG());
    ((JSONObject)localObject).put("object_id", com.tencent.mm.ae.d.Fw(paraml.drG().object_id));
    localObject = ((JSONObject)localObject).toString();
    p.j(localObject, "extInfo.toString()");
    localen.sx(kotlin.n.n.l((String)localObject, ",", ";", false));
    localen.lO(paramInt1);
    localen.sy(paramString1);
    label216:
    label246:
    label506:
    int i;
    if (parambid != null)
    {
      paramString1 = parambid.wmL;
      localen.sz(paramString1);
      if (parambid == null) {
        break label746;
      }
      paramString1 = parambid.wmz;
      localen.sA(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
        break label751;
      }
      l = 1L;
      localen.lP(l);
      paramString1 = h.ag(ak.class);
      p.j(paramString1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramString1 = ((ak)paramString1).getRedDotManager();
      p.j(paramString1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!paramString1.dqI()) {
        break label757;
      }
      l = 1L;
      label297:
      localen.lQ(l);
      if (paramInt2 != 0) {
        break label763;
      }
      l = 1L;
      label313:
      localen.lR(l);
      localen.akc();
      if (parambid == null) {
        break label769;
      }
      paramString1 = parambid.sessionId;
      label338:
      localen.sB(paramString1);
      localen.lS(paraml.field_time);
      localen.sC(parambkn.ufC);
      localen.lT(paramInt3);
      paramString1 = aj.AGc;
      if (!aj.edY()) {
        break label774;
      }
      l = 1L;
      label387:
      localen.lU(l);
      localen.lV(cm.bfE());
      paramInt1 = paraml.field_ctrInfo.type;
      if ((paramInt1 != 2) && (paramInt1 != 1006) && (paramInt1 != 1007)) {
        break label805;
      }
      paramString1 = h.ag(PluginFinder.class);
      p.j(paramString1, "MMKernel.plugin(PluginFinder::class.java)");
      paramString1 = ((PluginFinder)paramString1).getRedDotManager().aBe("NotificationCenterLike");
      if (paramString1 == null) {
        break label782;
      }
      paramInt1 = paramString1.count;
      label468:
      paramString1 = h.ag(PluginFinder.class);
      p.j(paramString1, "MMKernel.plugin(PluginFinder::class.java)");
      paramString1 = ((PluginFinder)paramString1).getRedDotManager().aBe("NotificationCenterComment");
      if (paramString1 == null) {
        break label787;
      }
      paramInt2 = paramString1.count;
      paramString1 = h.ag(PluginFinder.class);
      p.j(paramString1, "MMKernel.plugin(PluginFinder::class.java)");
      paramString1 = ((PluginFinder)paramString1).getRedDotManager().aBe("NotificationCenterFollow");
      if (paramString1 == null) {
        break label793;
      }
      paramInt3 = paramString1.count;
      label544:
      paramString1 = h.ag(PluginFinder.class);
      p.j(paramString1, "MMKernel.plugin(PluginFinder::class.java)");
      paramString1 = ((PluginFinder)paramString1).getRedDotManager().aBe("finder_private_msg_entrance");
      if (paramString1 == null) {
        break label799;
      }
      i = paramString1.count;
      label582:
      paramString1 = new JSONObject();
      paramString1.put("PrivateMsg", i);
      paraml = new JSONObject();
      paraml.put("unreadFollowCnt", paramInt3);
      paraml.put("unreadCommentCnt", paramInt2);
      paraml.put("unreadLikeCount", paramInt1);
      paraml.put("totalCnt", paramInt1 + paramInt2 + paramInt3);
      paramString1.put("FinderMsg", paraml);
      paramString1 = paramString1.toString();
      p.j(paramString1, "json.toString()");
      paramString1 = kotlin.n.n.l(paramString1, ",", ";", false);
      label683:
      localen.sD(paramString1);
      if (!com.tencent.mm.q.a.aAp()) {
        break label811;
      }
    }
    label769:
    label774:
    label782:
    label787:
    label793:
    label799:
    label805:
    label811:
    for (long l = 2L;; l = 1L)
    {
      localen.lW(l);
      localen.sE(paramString2);
      localen.bpa();
      paramString1 = n.zWF;
      n.a((com.tencent.mm.plugin.report.a)localen);
      AppMethodBeat.o(238144);
      return;
      paramString1 = null;
      break;
      label746:
      paramString1 = null;
      break label216;
      label751:
      l = 0L;
      break label246;
      label757:
      l = 0L;
      break label297;
      label763:
      l = 0L;
      break label313;
      paramString1 = null;
      break label338;
      l = 2L;
      break label387;
      paramInt1 = 0;
      break label468;
      paramInt2 = 0;
      break label506;
      paramInt3 = 0;
      break label544;
      i = 0;
      break label582;
      paramString1 = "";
      break label683;
    }
  }
  
  public final void a(String paramString1, com.tencent.mm.plugin.finder.extension.reddot.l paraml, bkn parambkn, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(238136);
    p.k(paramString1, "currUI");
    p.k(paraml, "ctrInfo");
    p.k(parambkn, "showInfo");
    p.k(paramString2, "contextId");
    bid localbid = new bid();
    String str2 = ((c)h.ae(c.class)).dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbid.sessionId = str1;
    localbid.wmL = paramString2;
    localbid.wmz = "";
    a(paramString1, paraml, parambkn, paramInt1, localbid, paramInt2, 0, null, 192);
    AppMethodBeat.o(238136);
  }
  
  public final void a(String paramString1, com.tencent.mm.plugin.finder.extension.reddot.l paraml, bkn parambkn, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(238134);
    p.k(paramString1, "currUI");
    p.k(paraml, "ctrInfo");
    p.k(parambkn, "showInfo");
    p.k(paramString2, "contextId");
    p.k(paramString3, "clickTabContextId");
    p.k(paramString4, "clickSubTabContextid");
    bid localbid = new bid();
    String str2 = ((c)h.ae(c.class)).dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbid.sessionId = str1;
    localbid.wmL = paramString2;
    localbid.wmz = paramString3;
    a(paramString1, paraml, parambkn, paramInt1, localbid, paramInt2, 0, paramString4, 64);
    AppMethodBeat.o(238134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.l
 * JD-Core Version:    0.7.0.1
 */