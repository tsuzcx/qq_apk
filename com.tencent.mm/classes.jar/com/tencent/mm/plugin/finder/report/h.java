package com.tencent.mm.plugin.finder.report;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ae;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.g.b.a.al;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.g.b.a.ap;
import com.tencent.mm.g.b.a.aq;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.g.b.a.bb;
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.g.b.a.bf;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.g.b.a.bk;
import com.tencent.mm.g.b.a.bl;
import com.tencent.mm.g.b.a.bo;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.g.b.a.bs;
import com.tencent.mm.g.b.a.bw;
import com.tencent.mm.g.b.a.bx;
import com.tencent.mm.g.b.a.bz;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.l;
import d.n.n;
import d.w;
import d.z;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TWO_64", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFinderFeedCgiFetchTimeMap", "()Landroid/util/SparseArray;", "finderFeedFetchTimeMap", "Landroid/util/LongSparseArray;", "getFinderFeedFetchTimeMap", "()Landroid/util/LongSparseArray;", "sessionBufferMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSessionBufferMap", "()Ljava/util/HashMap;", "setSessionBufferMap", "(Ljava/util/HashMap;)V", "asUnsignedDecimalString", "l", "finderAvatarClick19405", "", "clickAvatarScene", "", "feedId", "commentScene", "finderRole", "clickFinderUsername", "finderBackToTop19995", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "tabType", "finderChangeRoleClick", "roleBeforeSwitch", "finderClickEntrance19025", "contextId", "redDotId", "finderClickMoreReport", "scene", "finderClickTopic19186", "topic", "topicType", "topicFeedCount", "finderClickTopicFeedReport", "finderCommentFlagReport", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderCreateContactReport", "success", "addHeadIcon", "", "addSignature", "finderDistrictAlertClick", "username", "finderExposeFeedReport", "finderFavReport", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "finderLocationRequest19954", "context", "Landroid/content/Context;", "finderRealLikeAction19956", "finderRealLikeExpose19955", "exposeItems", "totalCount", "enterContextId", "finderRealLikeUserModify19957", "addUsernames", "delUsernames", "enterCount", "finderRedDot18948", "currUI", "redDotType", "showType", "redDotSubType", "count", "redDotWording", "currentTabType", "autoClick", "report_ext_info", "redDotBizType", "finderRedDotRevoke20223", "ctrType", "tipsId", "revokeId", "revokeStatus", "finderReportClickMention", "clickUsername", "finderReportEnterAtTimeline", "finderReportFav", "opType", "finderReportFlowClick19993", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "finderReportFollow", "finderUsername", "finderReportHitTabClick19998", "messageType", "index", "finderReportLikeAndComment", "actionType", "likeAction", "replyUsername", "userScene", "isShowRecWording", "isPrivateAccount", "finderReportMsgItemClick", "type", "isOverlap", "overlapCount", "finderReportOpenDrawer", "clickType", "finderReportPostMentionInfo", "finderReportSysMsgClick", "redDotCount", "finderReportTabChange", "fromTab", "toTab", "source", "finderSaveNameCard", "finderSelfUIEventReport", "enterTimeStamp", "redDotExistOnEnter", "eventType", "bannerType", "isHaveRedDot", "msgCnt", "finderSettingClickReport", "settingType", "finderSettingInfoEventReport", "finderShareFeedClick18944", "fromUser", "isCgiEnd", "uiType", "finderShareFeedReport", "shareType", "forwardResult", "receiver", "forwardUsrCount", "finderShareNameCardClickReport", "nameCardUser", "finderShareNameCardReport", "author", "followCount", "authType", "finderShareTopicClickReport", "finderShareTopicReport", "finderSubCommentExpand", "rootComment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "expandType", "finderTimelineMoreAction", "isFloat", "finderTraceAction", "finderUnlikeFeedReport", "page", "unlikeType", "finderVoiceFlagReport", "getCurrentTabRedDotUI", "getFeedCigFetchTime", "getFinderFeedFetchTime", "getFinderItem", "getFinderItemSessionBuffer", "getReportNetTypeInt", "newUUID", "putFeedCgiFetchTime", "putFinderItemSessionBuffer", "sessionBuffer", "report20698", "profileUsername", "time", "profileType", "profileView", "report20699", "fromUsername", "report20717", "tabContextId", "sessionId", "reportExposeHotCard20585", "exposeFeedId", "posId", "reportIDKeyVideoPlayError", "what", "reportJumpHotCard20586", "actionFeedId", "actionFeedIndex", "totalFeedId", "reportPoiFilter19996", "poiText", "filterTextItems", "hasUnfoldBtn", "isUnfoldBtnClick", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "transformTabIndexToTabType", "tabIndex", "transformTabTypeToCommentScene", "plugin-finder_release"})
public final class h
{
  public static final String TAG = "Finder.FinderReportLogic";
  private static final LongSparseArray<Long> soI;
  private static HashMap<String, String> soJ;
  private static final SparseArray<Long> soK;
  private static final BigInteger soL;
  public static final h soM;
  
  static
  {
    AppMethodBeat.i(166595);
    soM = new h();
    TAG = "Finder.FinderReportLogic";
    soI = new LongSparseArray();
    soJ = new HashMap();
    soK = new SparseArray();
    soL = BigInteger.ONE.shiftLeft(64);
    AppMethodBeat.o(166595);
  }
  
  public static long EX(int paramInt)
  {
    AppMethodBeat.i(203256);
    Long localLong = (Long)soK.get(paramInt);
    if (localLong != null)
    {
      long l = localLong.longValue();
      AppMethodBeat.o(203256);
      return l;
    }
    AppMethodBeat.o(203256);
    return 0L;
  }
  
  public static void EY(int paramInt)
  {
    AppMethodBeat.i(203257);
    soK.put(paramInt, Long.valueOf(cf.aCM()));
    AppMethodBeat.o(203257);
  }
  
  public static void EZ(int paramInt)
  {
    AppMethodBeat.i(166594);
    switch (paramInt)
    {
    default: 
      locala = s.ssa;
      s.a.ma(s.cEu());
      AppMethodBeat.o(166594);
      return;
    case -1010: 
      locala = s.ssa;
      s.a.ma(s.cEh());
      AppMethodBeat.o(166594);
      return;
    case -1007: 
      locala = s.ssa;
      s.a.ma(s.cEi());
      AppMethodBeat.o(166594);
      return;
    case -1004: 
      locala = s.ssa;
      s.a.ma(s.cEj());
      AppMethodBeat.o(166594);
      return;
    case -10012: 
      locala = s.ssa;
      s.a.ma(s.cEk());
      AppMethodBeat.o(166594);
      return;
    case -10004: 
      locala = s.ssa;
      s.a.ma(s.cEl());
      AppMethodBeat.o(166594);
      return;
    case -21009: 
      locala = s.ssa;
      s.a.ma(s.cEm());
      AppMethodBeat.o(166594);
      return;
    case -21020: 
      locala = s.ssa;
      s.a.ma(s.cEn());
      AppMethodBeat.o(166594);
      return;
    case 404: 
      locala = s.ssa;
      s.a.ma(s.cEo());
      AppMethodBeat.o(166594);
      return;
    case 403: 
      locala = s.ssa;
      s.a.ma(s.cEp());
      AppMethodBeat.o(166594);
      return;
    case 503: 
      locala = s.ssa;
      s.a.ma(s.cEq());
      AppMethodBeat.o(166594);
      return;
    case 502: 
      locala = s.ssa;
      s.a.ma(s.cEr());
      AppMethodBeat.o(166594);
      return;
    case 416: 
      locala = s.ssa;
      s.a.ma(s.cEs());
      AppMethodBeat.o(166594);
      return;
    }
    s.a locala = s.ssa;
    s.a.ma(s.cEt());
    AppMethodBeat.o(166594);
  }
  
  public static int Fa(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 3;
    case 3: 
      return 17;
    case 1: 
      return 18;
    case 2: 
      return 15;
    }
    return 20;
  }
  
  public static String I(long paramLong, int paramInt)
  {
    AppMethodBeat.i(203253);
    String str2 = (String)soJ.get(paramLong + '_' + paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(203253);
    return str1;
  }
  
  public static void J(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166577);
    FinderItem localFinderItem = ws(paramLong);
    if (localFinderItem != null)
    {
      com.tencent.mm.g.b.a.ad localad = new com.tencent.mm.g.b.a.ad();
      String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localad.gZ(str1);
      localad.ha(com.tencent.mm.ad.c.rc(localFinderItem.getId()));
      localad.cq(paramInt);
      localad.cl(localFinderItem.getLikeCount());
      localad.cm(localFinderItem.getCommentCount());
      localad.cn(localFinderItem.getFriendLikeCount());
      localad.cp(localFinderItem.getMediaType());
      localad.hb("");
      localad.co(paramInt);
      localad.aLk();
      a((com.tencent.mm.plugin.report.a)localad);
      AppMethodBeat.o(166577);
      return;
    }
    AppMethodBeat.o(166577);
  }
  
  public static void K(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166580);
    FinderItem localFinderItem = ws(paramLong);
    if (localFinderItem != null)
    {
      bk localbk = new bk();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbk.jT((String)localObject);
      localbk.fR(paramInt);
      localObject = com.tencent.mm.plugin.finder.utils.o.sMi;
      localbk.jU(n.h(com.tencent.mm.plugin.finder.utils.o.p(localFinderItem), ",", ";", false));
      localbk.jV("");
      localbk.jW(wu(localFinderItem.getId()));
      localbk.fS(localFinderItem.getFeedObject().likeCount);
      localbk.aLk();
      a((com.tencent.mm.plugin.report.a)localbk);
      AppMethodBeat.o(166580);
      return;
    }
    AppMethodBeat.o(166580);
  }
  
  public static void W(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(203284);
    d.g.b.p.h(paramContext, "context");
    bd localbd = new bd();
    Object localObject = FinderReporterUIC.tcM;
    paramContext = FinderReporterUIC.a.eY(paramContext);
    if (paramContext != null) {
      localbd.jv(paramContext.sessionId);
    }
    for (;;)
    {
      localbd.eZ(paramInt);
      localbd.aLk();
      a((com.tencent.mm.plugin.report.a)localbd);
      AppMethodBeat.o(203284);
      return;
      localObject = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      localbd.jv(paramContext);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, aqy paramaqy)
  {
    AppMethodBeat.i(203264);
    d.g.b.p.h(paramaqy, "contextObj");
    bb localbb = new bb();
    localbb.ez(paramaqy.rTD);
    localbb.jf(paramaqy.sessionId);
    localbb.jg(paramaqy.qXu);
    localbb.jh(paramaqy.qXj);
    localbb.jf(paramaqy.sessionId);
    localbb.eB(cf.aCM());
    localbb.eA(paramInt1);
    localbb.eC(paramInt2);
    localbb.eD(paramInt3);
    localbb.Se();
    localbb.aLk();
    a((com.tencent.mm.plugin.report.a)localbb);
    AppMethodBeat.o(203264);
  }
  
  public static void a(int paramInt1, int paramInt2, aqy paramaqy, int paramInt3)
  {
    long l2 = 0L;
    AppMethodBeat.i(203280);
    d.g.b.p.h(paramaqy, "contextObj");
    au localau = new au();
    long l1;
    if (paramInt1 > 0)
    {
      l1 = paramInt1;
      localau.dS(l1);
      l1 = l2;
      if (paramInt2 > 0) {
        l1 = paramInt2;
      }
      localau.dT(l1);
      localau.dU(cf.aCM());
      localau.in(paramaqy.sessionId);
      localau.ip(paramaqy.qXu);
      localau.io(paramaqy.qXj);
      localau.dV(paramInt3);
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localau.aLk();
      a((com.tencent.mm.plugin.report.a)localau);
      paramaqy = g.ajC();
      d.g.b.p.g(paramaqy, "MMKernel.storage()");
      paramaqy.ajl().set(al.a.IIT, localau.Sb());
      if (paramInt2 != 2)
      {
        paramaqy = g.ajC();
        d.g.b.p.g(paramaqy, "MMKernel.storage()");
        paramaqy.ajl().set(al.a.IIU, localau.Sb());
      }
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "finderReportTabChange clickTabContextId [%s] toTab[%d]", new Object[] { localau.Sb(), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(203280);
      return;
      l1 = 0L;
      break;
      paramaqy = g.ad(PluginFinder.class);
      d.g.b.p.g(paramaqy, "MMKernel.plugin(PluginFinder::class.java)");
      if (((PluginFinder)paramaqy).getRedDotManager().ahm("TLFollow") != null)
      {
        localau.Sc();
        continue;
        paramaqy = g.ad(PluginFinder.class);
        d.g.b.p.g(paramaqy, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)paramaqy).getRedDotManager().ahm("TLRecommendTab") != null)
        {
          localau.Sc();
          continue;
          paramaqy = g.ad(PluginFinder.class);
          d.g.b.p.g(paramaqy, "MMKernel.plugin(PluginFinder::class.java)");
          if (((PluginFinder)paramaqy).getRedDotManager().ahm("TLMachineTab") != null)
          {
            localau.Sc();
            continue;
            paramaqy = g.ad(PluginFinder.class);
            d.g.b.p.g(paramaqy, "MMKernel.plugin(PluginFinder::class.java)");
            if (((PluginFinder)paramaqy).getRedDotManager().ahm("TLLbsTab") != null) {
              localau.Sc();
            }
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(203274);
    FinderItem localFinderItem = ws(paramLong);
    if (localFinderItem != null)
    {
      al localal = new al();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localal.hC((String)localObject);
      localal.hD("");
      localal.hE(wu(paramLong));
      localal.hF(localFinderItem.getUserName());
      localal.cZ(localFinderItem.getLikeCount());
      localal.da(localFinderItem.getCommentCount());
      localal.db(localFinderItem.getFriendLikeCount());
      localal.in(paramInt2);
      localal.dc(paramInt1);
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGM().value()).intValue() == 1) {}
      for (paramLong = 1L;; paramLong = 0L)
      {
        localal.dd(paramLong);
        localal.aLk();
        a((com.tencent.mm.plugin.report.a)localal);
        AppMethodBeat.o(203274);
        return;
      }
    }
    AppMethodBeat.o(203274);
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    long l = 1L;
    AppMethodBeat.i(203275);
    d.g.b.p.h(paramString, "clickFinderUsername");
    aq localaq = new aq();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localaq.hU(str1);
    localaq.hX(wu(paramLong));
    localaq.dy(paramInt1);
    localaq.dx(paramInt2);
    switch (paramInt2)
    {
    default: 
      localaq.du(2L);
    }
    for (;;)
    {
      localaq.dt(paramInt3);
      localaq.hV(paramString);
      localaq.hW(u.aAu());
      paramString = ws(paramLong);
      if (paramString != null)
      {
        localaq.dv(paramString.getLikeCount());
        localaq.dw(paramString.getCommentCount());
      }
      paramLong = l;
      if (i.DEBUG) {
        paramLong = 0L;
      }
      localaq.dz(paramLong);
      localaq.aLk();
      a((com.tencent.mm.plugin.report.a)localaq);
      AppMethodBeat.o(203275);
      return;
      localaq.du(1L);
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, aqy paramaqy)
  {
    AppMethodBeat.i(203267);
    d.g.b.p.h(paramString1, "actionFeedId");
    d.g.b.p.h(paramString2, "totalFeedId");
    d.g.b.p.h(paramaqy, "contextObj");
    com.tencent.mm.plugin.report.e.ygI.f(20586, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), Long.valueOf(cf.aCM()), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramaqy.rTD), paramaqy.qXj, paramaqy.sessionId });
    AppMethodBeat.o(203267);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(166579);
    d.g.b.p.h(paramString1, "topic");
    d.g.b.p.h(paramString2, "receiver");
    bx localbx = new bx();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbx.kU((String)localObject);
    localbx.gT(paramInt1);
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localbx.gU(l);
      localObject = com.tencent.mm.plugin.finder.utils.o.sMi;
      localbx.kV(n.h(com.tencent.mm.plugin.finder.utils.o.B(paramString1, paramInt2, paramLong), ",", ";", false));
      localbx.kW("");
      localbx.gV(paramLong);
      localbx.kX(paramString2);
      localbx.aLk();
      a((com.tencent.mm.plugin.report.a)localbx);
      AppMethodBeat.o(166579);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(203296);
    paramString1 = com.tencent.mm.ad.c.rc(paramLong) + ',' + paramInt1 + ',' + paramInt2 + ',' + bt.nullAsNil(paramString1) + ',' + bt.nullAsNil(paramString2) + ',' + bt.nullAsNil(paramString3) + ',' + bt.nullAsNil(paramString4);
    com.tencent.mm.plugin.report.e.ygI.kvStat(20717, paramString1);
    AppMethodBeat.o(203296);
  }
  
  public static void a(long paramLong1, int paramInt, long paramLong2, String paramString, aqy paramaqy, long paramLong3)
  {
    AppMethodBeat.i(203261);
    d.g.b.p.h(paramString, "receiver");
    FinderItem localFinderItem = ws(paramLong1);
    if (localFinderItem != null)
    {
      ba localba = new ba();
      String str1;
      if (paramaqy != null)
      {
        String str2 = paramaqy.sessionId;
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "";
      }
      localba.iV(str1);
      localba.er(paramInt);
      localba.es(paramLong2);
      localba.iW(wu(localFinderItem.getId()));
      localba.iX(localFinderItem.getFeedObject().username);
      localba.iY(paramString);
      localba.et(localFinderItem.getLikeCount());
      localba.eu(localFinderItem.getCommentCount());
      localba.ev(localFinderItem.getFriendLikeCount());
      localba.iZ("");
      localba.ew(localFinderItem.getMediaType());
      paramString = com.tencent.mm.plugin.finder.utils.o.sMi;
      localba.ja(n.h(com.tencent.mm.plugin.finder.utils.o.p(localFinderItem), ",", ";", false));
      localba.jb("");
      if (paramaqy != null)
      {
        paramLong2 = paramaqy.rTD;
        localba.ex(paramLong2);
        if (paramaqy != null)
        {
          str1 = paramaqy.qXj;
          paramString = str1;
          if (str1 != null) {}
        }
        else
        {
          paramString = "";
        }
        localba.jc(paramString);
        if (paramaqy != null)
        {
          str1 = paramaqy.qXu;
          paramString = str1;
          if (str1 != null) {}
        }
        else
        {
          paramString = "";
        }
        localba.jd(paramString);
        if (paramaqy == null) {
          break label354;
        }
      }
      label354:
      for (paramInt = paramaqy.rTD;; paramInt = 0)
      {
        localba.je(I(paramLong1, paramInt));
        localba.ey(paramLong3);
        localba.aLk();
        a((com.tencent.mm.plugin.report.a)localba);
        AppMethodBeat.o(203261);
        return;
        paramLong2 = 0L;
        break;
      }
    }
    AppMethodBeat.o(203261);
  }
  
  public static void a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203259);
    d.g.b.p.h(paramString, "fromUser");
    ao localao = new ao();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localao.hK((String)localObject);
    localao.dh(paramInt1);
    localao.RQ();
    localao.hL(paramString);
    localao.hM(wu(paramLong));
    localao.dj(paramInt2);
    localao.dk(paramInt3);
    paramString = ws(paramLong);
    if (paramString != null)
    {
      localao.hN(paramString.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.o.sMi;
      localao.hO(n.h(com.tencent.mm.plugin.finder.utils.o.p(paramString), ",", ";", false));
      localObject = (Iterable)paramString.getMediaList();
      paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        if (bt.isNullOrNil(((bvf)((Iterator)localObject).next()).coverUrl)) {}
        for (paramLong = 0L;; paramLong = 1L)
        {
          localao.di(paramLong);
          paramString.add(z.MKo);
          break;
        }
      }
    }
    localao.aLk();
    a((com.tencent.mm.plugin.report.a)localao);
    AppMethodBeat.o(203259);
  }
  
  public static void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203258);
    d.g.b.p.h(paramString, "topic");
    FinderItem localFinderItem = ws(paramLong);
    if (localFinderItem != null)
    {
      bw localbw = new bw();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbw.kP((String)localObject);
      localbw.kQ("");
      localbw.gO(paramInt2);
      localbw.kR(wu(localFinderItem.getId()));
      localbw.gP(localFinderItem.getMediaType());
      localObject = com.tencent.mm.plugin.finder.utils.o.sMi;
      localbw.kS(n.h(com.tencent.mm.plugin.finder.utils.o.B(paramString, paramInt1, 0L), ",", ";", false));
      localbw.kT("");
      localbw.gQ(localFinderItem.getFeedObject().likeCount);
      localbw.gR(localFinderItem.getFeedObject().commentCount);
      localbw.gS(localFinderItem.getFeedObject().friendLikeCount);
      localbw.aLk();
      a((com.tencent.mm.plugin.report.a)localbw);
      AppMethodBeat.o(203258);
      return;
    }
    AppMethodBeat.o(203258);
  }
  
  public static void a(Context paramContext, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2, long paramLong4)
  {
    AppMethodBeat.i(203291);
    d.g.b.p.h(paramContext, "context");
    Object localObject = FinderReporterUIC.tcM;
    paramContext = FinderReporterUIC.a.eY(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.cOu();
      localObject = new bh();
      if (paramContext == null) {
        break label142;
      }
      paramContext = paramContext.sessionId;
      label50:
      ((bh)localObject).jB(paramContext);
      ((bh)localObject).fq(paramLong1);
      if (!paramBoolean1) {
        break label147;
      }
      paramLong1 = 1L;
      label70:
      ((bh)localObject).fr(paramLong1);
      ((bh)localObject).fs(paramLong2);
      ((bh)localObject).ft(paramLong3);
      ((bh)localObject).fu(System.currentTimeMillis());
      if (!paramBoolean2) {
        break label152;
      }
    }
    label142:
    label147:
    label152:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      ((bh)localObject).fv(paramLong1);
      ((bh)localObject).fw(paramLong4);
      ((bh)localObject).aLk();
      AppMethodBeat.o(203291);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label50;
      paramLong1 = 0L;
      break label70;
    }
  }
  
  public static void a(m paramm, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178394);
    d.g.b.p.h(paramm, "rootComment");
    FinderItem localFinderItem = ws(paramm.skh.field_feedId);
    if (localFinderItem != null)
    {
      ap localap = new ap();
      localap.dl(paramInt1);
      localap.dm(paramm.skh.field_actionInfo.Gla.levelTwoComment.size());
      String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localap.hP(str1);
      localap.hQ(wu(localFinderItem.getId()));
      localap.hR(localFinderItem.getUserName());
      localap.jdMethod_do(System.currentTimeMillis());
      localap.hS(paramm.skh.getUsername());
      localap.dn(paramm.skh.field_actionInfo.Gla.likeCount);
      localap.hT(wu(paramm.lP()));
      localap.dp(paramm.skh.field_actionInfo.Gla.expandCommentCount);
      switch (paramInt2)
      {
      default: 
        localap.dq(2L);
        if (((paramm.skh.field_actionInfo.Gla.displayFlag & 0x8) <= 0) && ((paramm.skh.field_actionInfo.Gla.displayFlag & 0x2) <= 0)) {
          break;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        localap.dr(paramInt1);
        localap.ds(paramInt2);
        localap.aLk();
        a((com.tencent.mm.plugin.report.a)localap);
        AppMethodBeat.o(178394);
        return;
        localap.dq(1L);
        break;
      }
    }
    AppMethodBeat.o(178394);
  }
  
  public static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(203288);
    d.g.b.p.h(parama, "struct");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.RE();
    d.g.b.p.g(parama, "struct.toShowString()");
    com.tencent.mm.sdk.platformtools.ad.i(str, n.h(parama, "\r\n", " ", false));
    AppMethodBeat.o(203288);
  }
  
  public static void a(aqy paramaqy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203285);
    d.g.b.p.h(paramaqy, "contextObj");
    ae localae = new ae();
    localae.cr(paramaqy.rTD);
    localae.hc(paramaqy.sessionId);
    localae.hd(paramaqy.qXu);
    localae.he(paramaqy.qXj);
    localae.cs(paramInt1);
    if (paramInt2 != 0)
    {
      paramaqy = com.tencent.mm.ui.component.a.KiD;
      if (!((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Gj(paramInt2)) {
        break label131;
      }
    }
    label131:
    for (long l = 1L;; l = 0L)
    {
      localae.ct(l);
      localae.aLk();
      a((com.tencent.mm.plugin.report.a)localae);
      AppMethodBeat.o(203285);
      return;
    }
  }
  
  public static void a(aqy paramaqy, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203272);
    d.g.b.p.h(paramaqy, "contextObj");
    d.g.b.p.h(paramString, "replyUsername");
    Object localObject = ws(paramLong);
    if (localObject != null)
    {
      ak localak = new ak();
      localak.hs(paramaqy.sessionId);
      localak.ht("");
      localak.hu(wu(paramLong));
      localak.hv(((FinderItem)localObject).getUserName());
      localak.cN(paramInt1);
      localak.cO(paramInt2);
      localak.cP(paramInt3);
      localak.hw(paramString);
      localak.cQ(paramInt4);
      localak.cR(((FinderItem)localObject).getLikeCount());
      localak.cS(((FinderItem)localObject).getCommentCount());
      localak.cT(((FinderItem)localObject).getFriendLikeCount());
      localak.cU(((FinderItem)localObject).getMediaType());
      paramString = com.tencent.mm.plugin.finder.utils.o.sMi;
      localak.hx(n.h(com.tencent.mm.plugin.finder.utils.o.p((FinderItem)localObject), ",", ";", false));
      localak.hy("");
      localak.cV(paramaqy.rTD);
      long l;
      if (d.g.b.p.i(((FinderItem)localObject).getUserName(), u.aAu()))
      {
        l = 1L;
        localak.cW(l);
        if (!paramBoolean1) {
          break label370;
        }
        l = 1L;
        label251:
        localak.cX(l);
        localObject = paramaqy.qXu;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localak.hz(paramString);
        localObject = paramaqy.qXj;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localak.hA(paramString);
        localak.hB(I(paramLong, paramaqy.rTD));
        if (!paramBoolean2) {
          break label376;
        }
      }
      label370:
      label376:
      for (paramLong = 1L;; paramLong = 0L)
      {
        localak.cY(paramLong);
        localak.aLk();
        a((com.tencent.mm.plugin.report.a)localak);
        AppMethodBeat.o(203272);
        return;
        l = 0L;
        break;
        l = 0L;
        break label251;
      }
    }
    AppMethodBeat.o(203272);
  }
  
  public static void a(aqy paramaqy, long paramLong, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(203282);
    d.g.b.p.h(paramaqy, "contextObj");
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    FinderItem localFinderItem = ws(paramLong);
    if (localFinderItem != null)
    {
      ax localax = new ax();
      localax.dZ(paramaqy.rTD);
      localax.iy(paramaqy.sessionId);
      localax.iz(paramaqy.qXu);
      localax.iA(paramaqy.qXj);
      localax.iB(com.tencent.mm.ad.c.rc(paramLong));
      localax.eb(cf.aCM());
      Object localObject = paramaqy.tco;
      if (localObject != null)
      {
        String str = n.h((String)localObject, ",", ";", false);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localax.iD((String)localObject);
      localax.ec(localFinderItem.getMediaType());
      localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject = com.tencent.mm.plugin.finder.utils.p.cLD().toString();
      d.g.b.p.g(localObject, "FinderUtil.getScreenInfo().toString()");
      localax.iF(n.h((String)localObject, ",", ";", false));
      localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      paramRecyclerView = com.tencent.mm.plugin.finder.utils.p.x(paramRecyclerView).toString();
      d.g.b.p.g(paramRecyclerView, "FinderUtil.getCurrentScr…(recyclerView).toString()");
      localax.iC(n.h(paramRecyclerView, ",", ";", false));
      localax.ea(EX(paramaqy.rTD));
      localax.iE(I(paramLong, paramaqy.rTD));
      if (paramaqy.rTD == 15) {
        switch (localFinderItem.getFeedObject().recommendReasonType)
        {
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          paramLong = 0L;
        }
      }
      for (;;)
      {
        localax.ed(paramLong);
        paramRecyclerView = localFinderItem.getFeedObject().recommendReason;
        paramaqy = paramRecyclerView;
        if (paramRecyclerView == null) {
          paramaqy = "";
        }
        localax.iG(paramaqy);
        localax.aLk();
        a((com.tencent.mm.plugin.report.a)localax);
        AppMethodBeat.o(203282);
        return;
        paramLong = 1L;
        continue;
        paramLong = 2L;
        continue;
        paramLong = 3L;
        continue;
        paramLong = 4L;
        continue;
        paramLong = 5L;
        continue;
        paramLong = 6L;
      }
    }
    AppMethodBeat.o(203282);
  }
  
  public static void a(aqy paramaqy, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203268);
    d.g.b.p.h(paramaqy, "contextObj");
    d.g.b.p.h(paramString1, "poiText");
    d.g.b.p.h(paramString2, "filterTextItems");
    bz localbz = new bz();
    localbz.kZ(paramaqy.sessionId);
    localbz.la(paramaqy.qXu);
    localbz.lb(paramaqy.qXj);
    localbz.gX(paramaqy.tcl);
    localbz.lc(paramString1);
    localbz.ld(paramString2);
    localbz.gY(paramInt1);
    localbz.gZ(paramInt2);
    switch (paramaqy.rTD)
    {
    }
    for (;;)
    {
      localbz.hb(paramaqy.rTD);
      localbz.aLk();
      a((com.tencent.mm.plugin.report.a)localbz);
      AppMethodBeat.o(203268);
      return;
      localbz.ha(2L);
      continue;
      localbz.ha(1L);
    }
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, long paramLong, aqy paramaqy, int paramInt6, int paramInt7, String paramString4)
  {
    AppMethodBeat.i(203271);
    d.g.b.p.h(paramString1, "currUI");
    d.g.b.p.h(paramString2, "redDotId");
    d.g.b.p.h(paramString3, "redDotWording");
    d.g.b.p.h(paramString4, "report_ext_info");
    bq localbq = new bq();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbq.kA(str1);
    localbq.kB(paramString1);
    localbq.gn(paramInt1);
    localbq.go(paramInt2);
    localbq.gq(paramInt3);
    long l;
    if (i.DEBUG)
    {
      l = 0L;
      localbq.gr(l);
      localbq.gp(paramInt4);
      localbq.kC(paramString2);
      localbq.gs(paramInt5);
      localbq.kD(paramString3);
      localbq.kE(wu(paramLong));
      if (paramaqy != null)
      {
        paramString2 = paramaqy.qXu;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localbq.kF(paramString1);
      if (paramaqy != null)
      {
        paramString2 = paramaqy.qXj;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localbq.kG(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1) {
        break label386;
      }
      paramLong = 2L;
      label264:
      localbq.gt(paramLong);
      paramString1 = g.ad(t.class);
      d.g.b.p.g(paramString1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramString1 = ((t)paramString1).getRedDotManager();
      d.g.b.p.g(paramString1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!paramString1.czR()) {
        break label392;
      }
    }
    label386:
    label392:
    for (paramLong = 1L;; paramLong = 2L)
    {
      localbq.gu(paramLong);
      localbq.gv(paramInt6);
      localbq.gw(paramInt7);
      if (!bt.isNullOrNil(paramString4)) {
        localbq.kH(paramString4);
      }
      localbq.aLk();
      a((com.tencent.mm.plugin.report.a)localbq);
      AppMethodBeat.o(203271);
      return;
      l = 2L;
      break;
      paramLong = 1L;
      break label264;
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt3, String paramString5)
  {
    AppMethodBeat.i(203269);
    d.g.b.p.h(paramString1, "currUI");
    d.g.b.p.h(paramString2, "redDotId");
    d.g.b.p.h(paramString3, "redDotWording");
    d.g.b.p.h(paramString4, "contextId");
    d.g.b.p.h(paramString5, "report_ext_info");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1) {
      switch (paramInt1)
      {
      case 0: 
      case 6: 
      default: 
        AppMethodBeat.o(203269);
        return;
      case -1: 
        paramInt1 = 2;
        i = 1;
        paramInt3 = 6;
      }
    }
    for (;;)
    {
      localObject = new aqy();
      ((aqy)localObject).qXu = paramString4;
      ((aqy)localObject).qXj = "";
      a(paramString1, paramInt1, paramInt2, paramInt3, i, 0, paramString2, paramString3, paramLong, (aqy)localObject, 0, 0, paramString5);
      AppMethodBeat.o(203269);
      return;
      paramInt1 = 1;
      i = 1;
      paramInt3 = 3;
      continue;
      paramInt1 = 1;
      i = 2;
      paramInt3 = 3;
      continue;
      paramInt1 = 3;
      i = 1;
      paramInt3 = 4;
      continue;
      paramInt1 = 3;
      i = 2;
      paramInt3 = 4;
      continue;
      paramInt1 = 1;
      i = 2;
      paramInt3 = 1;
      continue;
      paramInt1 = 7;
      i = 0;
      paramInt3 = 4;
      continue;
      paramInt1 = 8;
      i = 0;
      paramInt3 = 3;
      continue;
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(203269);
        return;
      case -1: 
        paramInt1 = 2;
        i = 1;
        break;
      case 1: 
        paramInt1 = 5;
        i = 0;
        paramInt3 = 3;
        break;
      case 2: 
        paramInt1 = 1;
        i = 0;
        paramInt3 = 3;
        break;
      case 5: 
        paramInt1 = 1;
        i = 0;
        paramInt3 = 1;
        break;
      case 8: 
        paramInt1 = 7;
        i = 0;
        break;
      case 7: 
        paramInt1 = 8;
        i = 0;
        break;
      case 1003: 
        paramInt1 = 3;
        i = 1;
        paramInt3 = 3;
        break;
      case 1004: 
        paramInt1 = 3;
        i = 2;
        paramInt3 = 3;
        break;
      case 1001: 
        paramInt1 = 6;
        i = 0;
        paramInt3 = 1;
        break;
      case 1005: 
        paramInt1 = 9;
        i = 0;
        paramInt3 = 100;
      }
    }
  }
  
  public static void a(String paramString, int paramInt, aqy paramaqy)
  {
    AppMethodBeat.i(203266);
    d.g.b.p.h(paramString, "exposeFeedId");
    d.g.b.p.h(paramaqy, "contextObj");
    com.tencent.mm.plugin.report.e.ygI.f(20585, new Object[] { paramString, Long.valueOf(cf.aCM()), Integer.valueOf(paramInt), Integer.valueOf(paramaqy.rTD), paramaqy.qXj, paramaqy.sessionId });
    AppMethodBeat.o(203266);
  }
  
  public static void ab(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203295);
    d.g.b.p.h(paramString, "fromUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2;
    com.tencent.mm.plugin.report.e.ygI.kvStat(20699, paramString);
    AppMethodBeat.o(203295);
  }
  
  public static void ahN(String paramString)
  {
    AppMethodBeat.i(166588);
    d.g.b.p.h(paramString, "username");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    paramString = str + ',' + paramString;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "18973 ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.e.ygI.kvStat(18973, paramString);
    AppMethodBeat.o(166588);
  }
  
  public static void b(aqy paramaqy, long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(203283);
    d.g.b.p.h(paramaqy, "contextObj");
    d.g.b.p.h(paramString, "username");
    if (ws(paramLong) != null)
    {
      bl localbl = new bl();
      localbl.fU(paramaqy.rTD);
      localbl.ka(paramaqy.qXu);
      localbl.kb(paramaqy.qXj);
      localbl.jZ(paramaqy.sessionId);
      localbl.jY(com.tencent.mm.ad.c.rc(paramLong));
      localbl.jX(paramString);
      localbl.fT(paramInt);
      localbl.aLk();
      a((com.tencent.mm.plugin.report.a)localbl);
    }
    AppMethodBeat.o(203283);
  }
  
  public static void c(Context paramContext, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(203293);
    d.g.b.p.h(paramContext, "context");
    paramContext = new bs();
    paramContext.gz(paramLong1);
    paramContext.gA(paramLong2);
    paramContext.aLk();
    AppMethodBeat.o(203293);
  }
  
  public static void c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166586);
    d.g.b.p.h(paramFinderItem, "finderItem");
    FinderObject localFinderObject = paramFinderItem.getFinderObject();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    paramFinderItem = str + ',' + wu(localFinderObject.id) + ',' + localFinderObject.username + ',' + paramFinderItem.getMediaType() + ',' + localFinderObject.recommendType + ',' + localFinderObject.likeCount + ',' + localFinderObject.commentCount + ',' + localFinderObject.friendLikeCount;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "18950 ".concat(String.valueOf(paramFinderItem)));
    com.tencent.mm.plugin.report.e.ygI.kvStat(18950, paramFinderItem);
    AppMethodBeat.o(166586);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(203294);
    d.g.b.p.h(paramString, "profileUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4;
    com.tencent.mm.plugin.report.e.ygI.kvStat(20698, paramString);
    AppMethodBeat.o(203294);
  }
  
  public static String cDy()
  {
    AppMethodBeat.i(203277);
    String str = UUID.randomUUID().toString();
    d.g.b.p.g(str, "UUID.randomUUID().toString()");
    AppMethodBeat.o(203277);
    return str;
  }
  
  public static int cDz()
  {
    AppMethodBeat.i(203290);
    int i = 0;
    if (ay.isWifi(aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(203290);
      return i;
      if (ay.is2G(aj.getContext())) {
        i = 2;
      } else if (ay.is3G(aj.getContext())) {
        i = 3;
      } else if (ay.is4G(aj.getContext())) {
        i = 4;
      } else if (ay.is5G(aj.getContext())) {
        i = 5;
      }
    }
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(203278);
    bf localbf = new bf();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbf.jy(str1);
    localbf.fb(paramInt1);
    localbf.fc(paramInt2);
    localbf.fd(paramInt3);
    localbf.jz(w.Fr(w.Fs(paramLong)));
    localbf.aLk();
    a((com.tencent.mm.plugin.report.a)localbf);
    AppMethodBeat.o(203278);
  }
  
  public static void d(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(203255);
    if (paramString != null)
    {
      paramString = n.h(paramString, ",", ";", false);
      if (paramString != null) {
        switch (paramInt)
        {
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 7: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 25: 
        case 28: 
        case 29: 
        case 30: 
        case 31: 
        default: 
          ((Map)soJ).put(paramLong + '_' + paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      soI.put(paramLong, Long.valueOf(cf.aCM()));
      AppMethodBeat.o(203255);
      return;
      ((Map)soJ).put(paramLong + "_6", paramString);
      ((Map)soJ).put(paramLong + "_23", paramString);
      continue;
      ((Map)soJ).put(paramLong + "_9", paramString);
      ((Map)soJ).put(paramLong + "_22", paramString);
      continue;
      ((Map)soJ).put(paramLong + "_15", paramString);
      ((Map)soJ).put(paramLong + "_16", paramString);
      continue;
      ((Map)soJ).put(paramLong + "_26", paramString);
      ((Map)soJ).put(paramLong + "_27", paramString);
      continue;
      ((Map)soJ).put(paramLong + "_24", paramString);
      ((Map)soJ).put(paramLong + "_21", paramString);
      continue;
      ((Map)soJ).put(paramLong + "_32", paramString);
      ((Map)soJ).put(paramLong + "_1", paramString);
      continue;
      ((Map)soJ).put(paramLong + "_33", paramString);
      ((Map)soJ).put(paramLong + "_8", paramString);
    }
  }
  
  public static void d(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203276);
    d.g.b.p.h(paramFinderItem, "finderItem");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null)
    {
      bi localbi = new bi();
      localbi.jC(wu(paramFinderItem.getId()));
      localbi.jD(((FinderFeedReportObject)localObject).sessionId);
      localbi.jE(paramFinderItem.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.b.sKO;
      localbi.jF(n.h(com.tencent.mm.plugin.finder.utils.b.n(paramFinderItem), ",", ";", false));
      localbi.aLk();
      a((com.tencent.mm.plugin.report.a)localbi);
      AppMethodBeat.o(203276);
      return;
    }
    AppMethodBeat.o(203276);
  }
  
  public static void dm(String paramString, int paramInt)
  {
    AppMethodBeat.i(178395);
    d.g.b.p.h(paramString, "username");
    be localbe = new be();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbe.jx(str1);
    localbe.jw(paramString);
    localbe.fa(paramInt);
    localbe.aLk();
    a((com.tencent.mm.plugin.report.a)localbe);
    AppMethodBeat.o(178395);
  }
  
  public static void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(166582);
    d.g.b.p.h(paramString1, "fromUser");
    d.g.b.p.h(paramString2, "topic");
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    paramString1 = new StringBuilder().append((String)localObject).append(',').append(paramInt1).append(",3,").append(paramString1).append(",0,,");
    localObject = com.tencent.mm.plugin.finder.utils.o.sMi;
    paramString1 = com.tencent.mm.plugin.finder.utils.o.dw(paramString2, paramInt2);
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.ygI.kvStat(18944, paramString1);
    AppMethodBeat.o(166582);
  }
  
  public static String eN(Context paramContext)
  {
    AppMethodBeat.i(203289);
    d.g.b.p.h(paramContext, "context");
    int i = 0;
    if ((paramContext instanceof MMActivity))
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
      i = ((FinderHomeUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderHomeUIC.class)).cOp();
    }
    switch (i)
    {
    default: 
      paramContext = "2";
    }
    for (;;)
    {
      AppMethodBeat.o(203289);
      return paramContext;
      paramContext = "6";
      continue;
      paramContext = "7";
      continue;
      paramContext = "8";
      continue;
      paramContext = "9";
    }
  }
  
  public static void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(203287);
    d.g.b.p.h(paramString1, "tipsId");
    d.g.b.p.h(paramString2, "revokeId");
    bo localbo = new bo();
    localbo.ga(paramInt1);
    localbo.gb(cf.aCN());
    localbo.ko(paramString1);
    localbo.kp(paramString2);
    paramString1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1) {}
    for (long l = 2L;; l = 1L)
    {
      localbo.gc(l);
      localbo.gd(paramInt2);
      localbo.aLk();
      a((com.tencent.mm.plugin.report.a)localbo);
      AppMethodBeat.o(203287);
      return;
    }
  }
  
  public static void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203279);
    br localbr = new br();
    localbr.gx(paramInt1);
    localbr.gy(paramInt2);
    localbr.aLk();
    a((com.tencent.mm.plugin.report.a)localbr);
    AppMethodBeat.o(203279);
  }
  
  public static void g(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166585);
    d.g.b.p.h(paramFinderObject, "finderObject");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    paramFinderObject = str + ',' + 1 + ',' + wu(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.recommendType;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "18953 ".concat(String.valueOf(paramFinderObject)));
    com.tencent.mm.plugin.report.e.ygI.kvStat(18953, paramFinderObject);
    AppMethodBeat.o(166585);
  }
  
  public static void gn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178396);
    d.g.b.p.h(paramString1, "contextId");
    d.g.b.p.h(paramString2, "action");
    ca localca = new ca();
    localca.lf(paramString1);
    localca.le(paramString2);
    localca.hc(cf.aCM());
    paramString2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localca.lg(paramString1);
    if (i.DEBUG) {}
    for (long l = 0L;; l = 1L)
    {
      localca.hd(l);
      localca.aLk();
      a((com.tencent.mm.plugin.report.a)localca);
      AppMethodBeat.o(178396);
      return;
    }
  }
  
  public static void h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(203263);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    localObject = new StringBuilder().append((String)localObject).append(',').append(paramInt1).append(',').append(paramInt2).append(',');
    if (paramBoolean1)
    {
      paramInt1 = 1;
      localObject = ((StringBuilder)localObject).append(paramInt1).append(',');
      if (!paramBoolean2) {
        break label139;
      }
    }
    label139:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localObject = paramInt1;
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "18947 ".concat(String.valueOf(localObject)));
      com.tencent.mm.plugin.report.e.ygI.kvStat(18947, (String)localObject);
      AppMethodBeat.o(203263);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public static void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166584);
    d.g.b.p.h(paramString1, "author");
    d.g.b.p.h(paramString2, "receiver");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    paramString1 = str + ',' + paramString1 + ',' + paramString2 + ',' + 0 + ',' + paramInt1 + ',' + paramInt2;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "18949 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.ygI.kvStat(18949, paramString1);
    AppMethodBeat.o(166584);
  }
  
  public static FinderItem ws(long paramLong)
  {
    AppMethodBeat.i(166576);
    Object localObject1 = d.szI;
    Object localObject2 = d.a.wT(paramLong);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = com.tencent.mm.plugin.finder.search.h.stT;
      localObject1 = (FinderItem)com.tencent.mm.plugin.finder.search.h.cEQ().get(Long.valueOf(paramLong));
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = FinderTopicFeedUI.shU;
      localObject2 = (FinderItem)FinderTopicFeedUI.cCa().get(Long.valueOf(paramLong));
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = FinderAtTimelineUI.sdp;
      localObject1 = (FinderItem)FinderAtTimelineUI.cCa().get(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(166576);
    return localObject1;
  }
  
  public static long wt(long paramLong)
  {
    AppMethodBeat.i(203254);
    Long localLong = (Long)soI.get(paramLong);
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(203254);
      return paramLong;
    }
    AppMethodBeat.o(203254);
    return 0L;
  }
  
  public static String wu(long paramLong)
  {
    AppMethodBeat.i(166591);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(soL);
    }
    localObject = ((BigInteger)localObject).toString();
    d.g.b.p.g(localObject, "b.toString()");
    AppMethodBeat.o(166591);
    return localObject;
  }
  
  public static void x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(166581);
    d.g.b.p.h(paramString1, "fromUser");
    d.g.b.p.h(paramString2, "nameCardUser");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
    paramString1 = str + ',' + paramInt + ",2," + paramString1 + ",0," + paramString2;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.ygI.kvStat(18944, paramString1);
    AppMethodBeat.o(166581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.h
 * JD-Core Version:    0.7.0.1
 */