package com.tencent.mm.plugin.finder.report;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.autogen.mmdata.rpt.bg;
import com.tencent.mm.autogen.mmdata.rpt.ga;
import com.tencent.mm.autogen.mmdata.rpt.gb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.protocal.protobuf.FinderTipsShowDiscoveryExtInfo;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.apt;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderRedDotReporter;", "", "()V", "INNER_VERSION", "", "TAG", "", "appPushContextId", "getAppPushContextId", "()Ljava/lang/String;", "setAppPushContextId", "(Ljava/lang/String;)V", "makeCountDetail", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "parseDiscoveryExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowDiscoveryExtInfo;", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "report20411", "", "currUI", "action", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "autoClick", "currentTabType", "clickSubTabContextid", "showNum", "autoTriggerType", "title", "dropStatus", "contextId", "clickTabContextId", "report20411TriggerType", "report20951", "revokeState", "revokeType", "whiteListReddotList", "overwriteTipsId", "report23587", "ctrlInfo", "actionType", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "reportCurrentEntranceRedDot", "reportDiscoveryTabRedDot", "businessType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w FrV;
  private static String FrW;
  
  static
  {
    AppMethodBeat.i(331568);
    FrV = new w();
    FrW = "";
    AppMethodBeat.o(331568);
  }
  
  public static void a(int paramInt, long paramLong, com.tencent.mm.plugin.finder.extension.reddot.p paramp, bxq parambxq)
  {
    AppMethodBeat.i(331550);
    bg localbg = new bg();
    localbg.iqW = paramInt;
    localbg.iqZ = paramLong;
    localbg.irc = com.tencent.mm.model.cn.bDw();
    if (paramp != null)
    {
      localbg.iqU = paramp.field_ctrInfo.type;
      localbg.ipW = localbg.F("feedid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramp.eav().object_id), true);
      localbg.iqX = localbg.F("username", paramp.ASz.YIZ, true);
      localbg.ira = localbg.F("RedDotTipsID", paramp.field_tipsId, true);
    }
    FinderTipsShowDiscoveryExtInfo localFinderTipsShowDiscoveryExtInfo;
    if (parambxq != null)
    {
      localFinderTipsShowDiscoveryExtInfo = new FinderTipsShowDiscoveryExtInfo();
      if (parambxq.aagr == 3)
      {
        paramp = parambxq.aags;
        if (paramp != null) {
          break label232;
        }
      }
    }
    label232:
    for (paramp = null;; paramp = paramp.toByteArray())
    {
      localFinderTipsShowDiscoveryExtInfo.parseFrom(paramp);
      paramp = localFinderTipsShowDiscoveryExtInfo.show_ext_info;
      localbg.iqV = localbg.F("showinfopath", parambxq.path, true);
      localbg.ird = parambxq.aagq;
      localbg.iqY = localbg.F("reportext", paramp, true);
      localbg.irb = localbg.F("RedDotShowInfoTitle", parambxq.title, true);
      localbg.bMH();
      AppMethodBeat.o(331550);
      return;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.extension.reddot.p paramp, bxq parambxq, int paramInt, String paramString)
  {
    AppMethodBeat.i(331507);
    gb localgb = new gb();
    if (paramp != null)
    {
      localgb.iJM = paramp.field_ctrType;
      localgb.qC(paramp.field_tipsId);
      localgb.qF(com.tencent.mm.ae.d.hF(paramp.eav().object_id));
      localgb.qG(paramp.eav().username);
      paramp = f.dg(paramp.eav()).toString();
      kotlin.g.b.s.s(paramp, "extInfo.toString()");
      localgb.qH(n.m(paramp, ",", ";", false));
    }
    if (parambxq != null)
    {
      localgb.qD(parambxq.path);
      localgb.qE(parambxq.Nnp);
      localgb.iKi = localgb.F("RedDotShowInfoType", String.valueOf(parambxq.show_type), true);
    }
    localgb.iKl = paramInt;
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      localgb.qI(paramString);
      localgb.ilI = 1L;
      localgb.iKm = com.tencent.mm.model.cn.bDw();
      localgb.bMH();
      paramp = z.FrZ;
      z.a((com.tencent.mm.plugin.report.a)localgb);
      AppMethodBeat.o(331507);
      return;
      paramString = FrW;
    }
  }
  
  private static void a(String paramString1, com.tencent.mm.plugin.finder.extension.reddot.p paramp, bxq parambxq, int paramInt1, bui parambui, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, String paramString3, int paramInt6)
  {
    AppMethodBeat.i(331486);
    kotlin.g.b.s.u(paramString1, "currUI");
    kotlin.g.b.s.u(paramp, "ctrInfo");
    kotlin.g.b.s.u(parambxq, "showInfo");
    kotlin.g.b.s.u(paramString2, "clickSubTabContextid");
    kotlin.g.b.s.u(paramString3, "title");
    ga localga = new ga();
    localga.iJM = paramp.field_ctrInfo.type;
    localga.qs(paramp.field_tipsId);
    localga.qt(parambxq.path);
    localga.qu(parambxq.Nnp);
    localga.iJP = parambxq.show_type;
    localga.iJQ = parambxq.count;
    Object localObject = paramString3;
    if (Util.isNullOrNil(paramString3)) {
      localObject = parambxq.title;
    }
    localga.qv((String)localObject);
    paramString3 = f.dg(paramp.eav());
    paramString3.put("object_id", com.tencent.mm.ae.d.hF(paramp.eav().object_id));
    paramString3 = paramString3.toString();
    kotlin.g.b.s.s(paramString3, "extInfo.toString()");
    localga.qw(n.m(paramString3, ",", ";", false));
    paramString3 = new JSONArray();
    localObject = paramp.eav().multi_username.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString3.put((String)((Iterator)localObject).next());
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("multi_usernames", paramString3);
    if (paramInt6 == 1) {
      ((JSONObject)localObject).put("isClientTextLimitFallbackDot", 1);
    }
    paramString3 = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(paramString3, "reportExt2Json.toString()");
    paramString3 = paramString3.getBytes(kotlin.n.d.UTF_8);
    kotlin.g.b.s.s(paramString3, "(this as java.lang.String).getBytes(charset)");
    localga.iKh = localga.F("ReportExtInfo2", Base64.encodeToString(paramString3, 2), true);
    localga.iJS = paramInt1;
    localga.qx(paramString1);
    label377:
    long l;
    if (parambui == null)
    {
      paramString3 = null;
      localga.qy(paramString3);
      if (parambui != null) {
        break label757;
      }
      paramString3 = null;
      localga.qz(paramString3);
      paramString3 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
        break label767;
      }
      l = 1L;
      label409:
      localga.iGr = l;
      if (!((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZs()) {
        break label773;
      }
      l = 1L;
      label441:
      localga.iJV = l;
      if (paramInt2 != 0) {
        break label779;
      }
      l = 1L;
      label456:
      localga.iJW = l;
      localga.iJX = 1L;
      if (parambui != null) {
        break label785;
      }
      parambui = null;
      label477:
      localga.qA(parambui);
      localga.iJY = paramp.field_time;
      localga.qB(parambxq.icon_url);
      localga.iKa = paramInt3;
      parambxq = av.GiL;
      if (!av.ffR()) {
        break label795;
      }
      l = 1L;
      label525:
      localga.iKb = l;
      localga.irc = com.tencent.mm.model.cn.bDw();
      switch (paramp.field_ctrInfo.type)
      {
      default: 
        parambxq = "";
        localga.iKc = localga.F("RedDotCountNumDetail", parambxq, true);
        if (com.tencent.mm.n.a.aTk())
        {
          l = 2L;
          label609:
          localga.iKd = l;
          localga.iKe = localga.F("ClickSubTabContextid", paramString2, true);
          localga.iKg = paramInt5;
          if (kotlin.g.b.s.p(paramString1, "1"))
          {
            paramString1 = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager();
            if (!(paramString1 instanceof i)) {
              break label1058;
            }
            paramString1 = (i)paramString1;
            label677:
            if (paramString1 != null) {
              break label1063;
            }
            paramString1 = null;
            label683:
            if (paramString1 != null) {
              break label1071;
            }
            parambxq = null;
            label689:
            if (!kotlin.g.b.s.p(parambxq, paramp.field_tipsId)) {
              break label1120;
            }
            if (paramString1 != null) {
              break label1082;
            }
            paramString1 = null;
            label706:
            if (paramString1 != null) {
              break label1111;
            }
            l = paramInt4;
          }
        }
        break;
      }
    }
    label715:
    label854:
    label1111:
    label1120:
    for (localga.iKf = l;; localga.iKf = paramInt4)
    {
      localga.bMH();
      paramString1 = z.FrZ;
      z.a((com.tencent.mm.plugin.report.a)localga);
      AppMethodBeat.o(331486);
      return;
      paramString3 = parambui.zIO;
      break;
      label757:
      paramString3 = parambui.zIB;
      break label377;
      label767:
      l = 0L;
      break label409;
      l = 0L;
      break label441;
      l = 0L;
      break label456;
      parambui = parambui.sessionId;
      break label477;
      l = 2L;
      break label525;
      parambxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("NotificationCenterLike");
      if (parambxq == null)
      {
        paramInt1 = 0;
        parambxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("NotificationCenterComment");
        if (parambxq != null) {
          break label1025;
        }
        paramInt2 = 0;
        parambxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("NotificationCenterFollow");
        if (parambxq != null) {
          break label1034;
        }
        paramInt3 = 0;
        label880:
        parambxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("finder_private_msg_entrance");
        if (parambxq != null) {
          break label1043;
        }
      }
      for (paramInt6 = 0;; paramInt6 = parambxq.count)
      {
        parambxq = new JSONObject();
        parambxq.put("PrivateMsg", paramInt6);
        parambui = new JSONObject();
        parambui.put("unreadFollowCnt", paramInt3);
        parambui.put("unreadCommentCnt", paramInt2);
        parambui.put("unreadLikeCount", paramInt1);
        parambui.put("totalCnt", paramInt1 + paramInt2 + paramInt3);
        parambxq.put("FinderMsg", parambui);
        parambxq = parambxq.toString();
        kotlin.g.b.s.s(parambxq, "json.toString()");
        parambxq = n.bV(parambxq, ",", ";");
        break;
        paramInt1 = parambxq.count;
        break label828;
        paramInt2 = parambxq.count;
        break label854;
        paramInt3 = parambxq.count;
        break label880;
      }
      l = 1L;
      break label609;
      paramString1 = null;
      break label677;
      paramString1 = paramString1.AQw;
      break label683;
      parambxq = (String)paramString1.bsC;
      break label689;
      paramString1 = (Integer)paramString1.bsD;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label706;
      }
      paramString1 = Long.valueOf(paramString1.intValue());
      break label706;
      l = paramString1.longValue();
      break label715;
    }
  }
  
  public static void azS(String paramString)
  {
    AppMethodBeat.i(331498);
    kotlin.g.b.s.u(paramString, "<set-?>");
    FrW = paramString;
    AppMethodBeat.o(331498);
  }
  
  public static void g(com.tencent.mm.plugin.finder.extension.reddot.p paramp)
  {
    AppMethodBeat.i(331561);
    kotlin.g.b.s.u(paramp, "ctrInfo");
    Object localObject1 = paramp.eav();
    if (((FinderTipsShowEntranceExtInfo)localObject1).object_id == 0L)
    {
      AppMethodBeat.o(331561);
      return;
    }
    paramp = new aps();
    paramp.hKN = ((FinderTipsShowEntranceExtInfo)localObject1).object_id;
    Object localObject2 = new apt();
    ((apt)localObject2).ZwY = ((FinderTipsShowEntranceExtInfo)localObject1).tabTipsByPassInfo;
    ((apt)localObject2).ZwZ = ((FinderTipsShowEntranceExtInfo)localObject1).tab_type;
    ah localah = ah.aiuX;
    paramp.ZwX = ((apt)localObject2);
    localObject2 = new StringBuilder("[reportCurrentEntranceRedDot] objectId=").append(com.tencent.mm.ae.d.hF(paramp.hKN)).append(" jump_tab_type=").append(((FinderTipsShowEntranceExtInfo)localObject1).tab_type).append(" tab_tips_by_pass_info=");
    if (((FinderTipsShowEntranceExtInfo)localObject1).tabTipsByPassInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderRedDotReporter", bool);
      localObject1 = ah.aiuX;
      paramp = new bu(null, 2, paramp);
      h.aZW().a((com.tencent.mm.am.p)paramp, 0);
      AppMethodBeat.o(331561);
      return;
    }
  }
  
  public final void a(String paramString1, com.tencent.mm.plugin.finder.extension.reddot.p paramp, bxq parambxq, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(331575);
    kotlin.g.b.s.u(paramString1, "currUI");
    kotlin.g.b.s.u(paramp, "ctrInfo");
    kotlin.g.b.s.u(parambxq, "showInfo");
    kotlin.g.b.s.u(paramString2, "contextId");
    bui localbui = new bui();
    String str2 = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbui.sessionId = str1;
    localbui.zIO = paramString2;
    localbui.zIB = "";
    a(paramString1, paramp, parambxq, paramInt1, localbui, paramInt2, 0, null, paramInt3, 0, null, paramInt4, 1728);
    AppMethodBeat.o(331575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.w
 * JD-Core Version:    0.7.0.1
 */