package com.tencent.mm.plugin.finder.report;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ad;
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
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.search.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import d.l;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TWO_64", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFinderFeedCgiFetchTimeMap", "()Landroid/util/SparseArray;", "finderFeedFetchTimeMap", "Landroid/util/LongSparseArray;", "getFinderFeedFetchTimeMap", "()Landroid/util/LongSparseArray;", "sessionBufferMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSessionBufferMap", "()Ljava/util/HashMap;", "setSessionBufferMap", "(Ljava/util/HashMap;)V", "asUnsignedDecimalString", "l", "finderAvatarClick19405", "", "clickAvatarScene", "", "feedId", "commentScene", "finderRole", "clickFinderUsername", "finderBackToTop19995", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "tabType", "finderChangeRoleClick", "roleBeforeSwitch", "finderClickEntrance19025", "contextId", "redDotId", "finderClickMoreReport", "scene", "finderClickTopic19186", "topic", "topicType", "topicFeedCount", "finderClickTopicFeedReport", "finderCommentFlagReport", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderCreateContactReport", "success", "addHeadIcon", "", "addSignature", "finderDistrictAlertClick", "username", "finderExposeFeedReport", "finderFavReport", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "finderLocationRequest19954", "context", "Landroid/content/Context;", "finderRealLikeAction19956", "finderRealLikeExpose19955", "exposeItems", "totalCount", "enterContextId", "finderRealLikeUserModify19957", "addUsernames", "delUsernames", "enterCount", "finderRedDot18948", "currUI", "redDotType", "showType", "redDotSubType", "count", "redDotWording", "currentTabType", "autoClick", "report_ext_info", "redDotBizType", "finderRedDotRevoke20223", "ctrType", "tipsId", "revokeId", "revokeStatus", "finderReportClickMention", "clickUsername", "finderReportEnterAtTimeline", "finderReportFav", "opType", "finderReportFlowClick19993", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "finderReportFollow", "finderUsername", "finderReportHitTabClick19998", "messageType", "index", "finderReportLikeAndComment", "actionType", "likeAction", "replyUsername", "userScene", "isShowRecWording", "isPrivateAccount", "finderReportMsgItemClick", "type", "isOverlap", "overlapCount", "finderReportOpenDrawer", "clickType", "finderReportPostMentionInfo", "finderReportSysMsgClick", "redDotCount", "finderReportTabChange", "fromTab", "toTab", "source", "finderSaveNameCard", "finderSelfUIEventReport", "enterTimeStamp", "redDotExistOnEnter", "eventType", "bannerType", "isHaveRedDot", "msgCnt", "finderSettingClickReport", "settingType", "finderSettingInfoEventReport", "hasReddot", "finderShareFeedClick18944", "cardType", "fromUser", "isCgiEnd", "uiType", "finderShareFeedReport", "shareType", "forwardResult", "receiver", "forwardUsrCount", "finderShareNameCardClickReport", "nameCardUser", "finderShareNameCardReport", "author", "followCount", "authType", "finderShareTopicClickReport", "finderShareTopicReport", "finderSubCommentExpand", "rootComment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "expandType", "finderTimelineMoreAction", "isFloat", "finderTraceAction", "finderUnlikeFeedReport", "page", "unlikeType", "finderVoiceFlagReport", "getCurrentTabRedDotUI", "getFeedCigFetchTime", "getFinderFeedFetchTime", "getFinderItem", "getFinderItemSessionBuffer", "getReportNetTypeInt", "newUUID", "putFeedCgiFetchTime", "putFinderItemSessionBuffer", "sessionBuffer", "report20698", "profileUsername", "time", "profileType", "profileView", "report20699", "fromUsername", "report20717", "tabContextId", "sessionId", "reportExposeHotCard20585", "exposeFeedId", "posId", "reportIDKeyVideoPlayError", "what", "reportJumpHotCard20586", "actionFeedId", "actionFeedIndex", "totalFeedId", "reportPoiFilter19996", "poiText", "filterTextItems", "hasUnfoldBtn", "isUnfoldBtnClick", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "transformTabIndexToTabType", "tabIndex", "transformTabTypeToCommentScene", "plugin-finder_release"})
public final class i
{
  public static final String TAG = "Finder.FinderReportLogic";
  private static final LongSparseArray<Long> syP;
  private static HashMap<String, String> syQ;
  private static final SparseArray<Long> syR;
  private static final BigInteger syS;
  public static final i syT;
  
  static
  {
    AppMethodBeat.i(166595);
    syT = new i();
    TAG = "Finder.FinderReportLogic";
    syP = new LongSparseArray();
    syQ = new HashMap();
    syR = new SparseArray();
    syS = BigInteger.ONE.shiftLeft(64);
    AppMethodBeat.o(166595);
  }
  
  public static long Ft(int paramInt)
  {
    AppMethodBeat.i(203810);
    Long localLong = (Long)syR.get(paramInt);
    if (localLong != null)
    {
      long l = localLong.longValue();
      AppMethodBeat.o(203810);
      return l;
    }
    AppMethodBeat.o(203810);
    return 0L;
  }
  
  public static void Fu(int paramInt)
  {
    AppMethodBeat.i(203811);
    syR.put(paramInt, Long.valueOf(ch.aDc()));
    AppMethodBeat.o(203811);
  }
  
  public static void Fv(int paramInt)
  {
    AppMethodBeat.i(166594);
    switch (paramInt)
    {
    default: 
      locala = t.sCk;
      t.a.md(t.cGq());
      AppMethodBeat.o(166594);
      return;
    case -1010: 
      locala = t.sCk;
      t.a.md(t.cGd());
      AppMethodBeat.o(166594);
      return;
    case -1007: 
      locala = t.sCk;
      t.a.md(t.cGe());
      AppMethodBeat.o(166594);
      return;
    case -1004: 
      locala = t.sCk;
      t.a.md(t.cGf());
      AppMethodBeat.o(166594);
      return;
    case -10012: 
      locala = t.sCk;
      t.a.md(t.cGg());
      AppMethodBeat.o(166594);
      return;
    case -10004: 
      locala = t.sCk;
      t.a.md(t.cGh());
      AppMethodBeat.o(166594);
      return;
    case -21009: 
      locala = t.sCk;
      t.a.md(t.cGi());
      AppMethodBeat.o(166594);
      return;
    case -21020: 
      locala = t.sCk;
      t.a.md(t.cGj());
      AppMethodBeat.o(166594);
      return;
    case 404: 
      locala = t.sCk;
      t.a.md(t.cGk());
      AppMethodBeat.o(166594);
      return;
    case 403: 
      locala = t.sCk;
      t.a.md(t.cGl());
      AppMethodBeat.o(166594);
      return;
    case 503: 
      locala = t.sCk;
      t.a.md(t.cGm());
      AppMethodBeat.o(166594);
      return;
    case 502: 
      locala = t.sCk;
      t.a.md(t.cGn());
      AppMethodBeat.o(166594);
      return;
    case 416: 
      locala = t.sCk;
      t.a.md(t.cGo());
      AppMethodBeat.o(166594);
      return;
    }
    t.a locala = t.sCk;
    t.a.md(t.cGp());
    AppMethodBeat.o(166594);
  }
  
  public static int Fw(int paramInt)
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
    AppMethodBeat.i(203807);
    String str2 = (String)syQ.get(paramLong + '_' + paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(203807);
    return str1;
  }
  
  public static void J(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166577);
    FinderItem localFinderItem = wJ(paramLong);
    if (localFinderItem != null)
    {
      ad localad = new ad();
      String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localad.hf(str1);
      localad.hg(com.tencent.mm.ac.c.rp(localFinderItem.getId()));
      localad.cq(paramInt);
      localad.cl(localFinderItem.getLikeCount());
      localad.cm(localFinderItem.getCommentCount());
      localad.cn(localFinderItem.getFriendLikeCount());
      localad.cp(localFinderItem.getMediaType());
      localad.hh("");
      localad.co(paramInt);
      localad.aLH();
      a((com.tencent.mm.plugin.report.a)localad);
      AppMethodBeat.o(166577);
      return;
    }
    AppMethodBeat.o(166577);
  }
  
  public static void K(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166580);
    FinderItem localFinderItem = wJ(paramLong);
    if (localFinderItem != null)
    {
      bk localbk = new bk();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbk.kg((String)localObject);
      localbk.fU(paramInt);
      localObject = com.tencent.mm.plugin.finder.utils.o.sXt;
      localbk.kh(d.n.n.h(com.tencent.mm.plugin.finder.utils.o.p(localFinderItem), ",", ";", false));
      localbk.ki("");
      localbk.kj(wL(localFinderItem.getId()));
      localbk.fV(localFinderItem.getFeedObject().likeCount);
      localbk.aLH();
      a((com.tencent.mm.plugin.report.a)localbk);
      AppMethodBeat.o(166580);
      return;
    }
    AppMethodBeat.o(166580);
  }
  
  public static void W(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(203840);
    d.g.b.p.h(paramContext, "context");
    bd localbd = new bd();
    Object localObject = FinderReporterUIC.tnG;
    paramContext = FinderReporterUIC.a.fc(paramContext);
    if (paramContext != null) {
      localbd.jH(paramContext.sessionId);
    }
    for (;;)
    {
      localbd.fc(paramInt);
      localbd.aLH();
      a((com.tencent.mm.plugin.report.a)localbd);
      AppMethodBeat.o(203840);
      return;
      localObject = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      localbd.jH(paramContext);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, arn paramarn)
  {
    AppMethodBeat.i(203819);
    d.g.b.p.h(paramarn, "contextObj");
    bb localbb = new bb();
    localbb.eA(paramarn.sch);
    localbb.jr(paramarn.sessionId);
    localbb.js(paramarn.rfA);
    localbb.jt(paramarn.rfo);
    localbb.jr(paramarn.sessionId);
    localbb.eC(ch.aDc());
    localbb.eB(paramInt1);
    localbb.eD(paramInt2);
    localbb.eE(paramInt3);
    localbb.Sc();
    localbb.aLH();
    a((com.tencent.mm.plugin.report.a)localbb);
    AppMethodBeat.o(203819);
  }
  
  public static void a(int paramInt1, int paramInt2, arn paramarn, int paramInt3)
  {
    long l2 = 0L;
    AppMethodBeat.i(203836);
    d.g.b.p.h(paramarn, "contextObj");
    au localau = new au();
    long l1;
    if (paramInt1 > 0)
    {
      l1 = paramInt1;
      localau.dT(l1);
      l1 = l2;
      if (paramInt2 > 0) {
        l1 = paramInt2;
      }
      localau.dU(l1);
      localau.dV(ch.aDc());
      localau.ix(paramarn.sessionId);
      localau.iz(paramarn.rfA);
      localau.iy(paramarn.rfo);
      localau.dW(paramInt3);
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localau.aLH();
      a((com.tencent.mm.plugin.report.a)localau);
      paramarn = g.ajR();
      d.g.b.p.g(paramarn, "MMKernel.storage()");
      paramarn.ajA().set(am.a.Jdz, localau.RZ());
      if (paramInt2 != 2)
      {
        paramarn = g.ajR();
        d.g.b.p.g(paramarn, "MMKernel.storage()");
        paramarn.ajA().set(am.a.JdA, localau.RZ());
      }
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "finderReportTabChange clickTabContextId [%s] toTab[%d]", new Object[] { localau.RZ(), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(203836);
      return;
      l1 = 0L;
      break;
      paramarn = g.ad(PluginFinder.class);
      d.g.b.p.g(paramarn, "MMKernel.plugin(PluginFinder::class.java)");
      if (((PluginFinder)paramarn).getRedDotManager().aii("TLFollow") != null)
      {
        localau.Sa();
        continue;
        paramarn = g.ad(PluginFinder.class);
        d.g.b.p.g(paramarn, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)paramarn).getRedDotManager().aii("TLRecommendTab") != null)
        {
          localau.Sa();
          continue;
          paramarn = g.ad(PluginFinder.class);
          d.g.b.p.g(paramarn, "MMKernel.plugin(PluginFinder::class.java)");
          if (((PluginFinder)paramarn).getRedDotManager().aii("TLMachineTab") != null)
          {
            localau.Sa();
            continue;
            paramarn = g.ad(PluginFinder.class);
            d.g.b.p.g(paramarn, "MMKernel.plugin(PluginFinder::class.java)");
            if (((PluginFinder)paramarn).getRedDotManager().aii("TLLbsTab") != null) {
              localau.Sa();
            }
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(203830);
    FinderItem localFinderItem = wJ(paramLong);
    if (localFinderItem != null)
    {
      al localal = new al();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localal.hK((String)localObject);
      localal.hL("");
      localal.hM(wL(paramLong));
      localal.hN(localFinderItem.getUserName());
      localal.cZ(localFinderItem.getLikeCount());
      localal.da(localFinderItem.getCommentCount());
      localal.db(localFinderItem.getFriendLikeCount());
      localal.ip(paramInt2);
      localal.dc(paramInt1);
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIL().value()).intValue() == 1) {}
      for (paramLong = 1L;; paramLong = 0L)
      {
        localal.dd(paramLong);
        localal.aLH();
        a((com.tencent.mm.plugin.report.a)localal);
        AppMethodBeat.o(203830);
        return;
      }
    }
    AppMethodBeat.o(203830);
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    long l = 1L;
    AppMethodBeat.i(203831);
    aq localaq = new aq();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localaq.ic(str1);
    localaq.ig(wL(paramLong));
    localaq.dz(paramInt1);
    localaq.dy(paramInt2);
    switch (paramInt2)
    {
    default: 
      localaq.dv(2L);
    }
    for (;;)
    {
      localaq.du(paramInt3);
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      localaq.ie(str1);
      localaq.jdMethod_if(v.aAK());
      paramString = wJ(paramLong);
      if (paramString != null)
      {
        localaq.dw(paramString.getLikeCount());
        localaq.dx(paramString.getCommentCount());
      }
      paramLong = l;
      if (com.tencent.mm.sdk.platformtools.j.DEBUG) {
        paramLong = 0L;
      }
      localaq.dA(paramLong);
      localaq.aLH();
      a((com.tencent.mm.plugin.report.a)localaq);
      AppMethodBeat.o(203831);
      return;
      localaq.dv(1L);
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, arn paramarn)
  {
    AppMethodBeat.i(203822);
    d.g.b.p.h(paramString1, "actionFeedId");
    d.g.b.p.h(paramString2, "totalFeedId");
    d.g.b.p.h(paramarn, "contextObj");
    com.tencent.mm.plugin.report.e.ywz.f(20586, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), Long.valueOf(ch.aDc()), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramarn.sch), paramarn.rfo, paramarn.sessionId });
    AppMethodBeat.o(203822);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(166579);
    d.g.b.p.h(paramString1, "topic");
    d.g.b.p.h(paramString2, "receiver");
    bx localbx = new bx();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbx.lh((String)localObject);
    localbx.gY(paramInt1);
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localbx.gZ(l);
      localObject = com.tencent.mm.plugin.finder.utils.o.sXt;
      localbx.li(d.n.n.h(com.tencent.mm.plugin.finder.utils.o.A(paramString1, paramInt2, paramLong), ",", ";", false));
      localbx.lj("");
      localbx.ha(paramLong);
      localbx.lk(paramString2);
      localbx.aLH();
      a((com.tencent.mm.plugin.report.a)localbx);
      AppMethodBeat.o(166579);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(203853);
    paramString1 = com.tencent.mm.ac.c.rp(paramLong) + ',' + paramInt1 + ',' + paramInt2 + ',' + bu.nullAsNil(paramString1) + ',' + bu.nullAsNil(paramString2) + ',' + bu.nullAsNil(paramString3) + ',' + bu.nullAsNil(paramString4);
    com.tencent.mm.plugin.report.e.ywz.kvStat(20717, paramString1);
    AppMethodBeat.o(203853);
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203815);
    d.g.b.p.h(paramString, "fromUser");
    ao localao = new ao();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localao.hS((String)localObject);
    localao.dh(paramInt1);
    localao.di(paramLong2);
    localao.hT(paramString);
    localao.hU(wL(paramLong1));
    localao.dk(paramInt2);
    localao.dl(paramInt3);
    paramString = wJ(paramLong1);
    if (paramString != null)
    {
      localao.hV(paramString.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.o.sXt;
      localao.hW(d.n.n.h(com.tencent.mm.plugin.finder.utils.o.p(paramString), ",", ";", false));
      localObject = (Iterable)paramString.getMediaList();
      paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        if (bu.isNullOrNil(((bvz)((Iterator)localObject).next()).coverUrl)) {}
        for (paramLong1 = 0L;; paramLong1 = 1L)
        {
          localao.dj(paramLong1);
          paramString.add(z.Nhr);
          break;
        }
      }
    }
    localao.aLH();
    a((com.tencent.mm.plugin.report.a)localao);
    AppMethodBeat.o(203815);
  }
  
  public static void a(long paramLong1, int paramInt, long paramLong2, String paramString, arn paramarn, long paramLong3)
  {
    AppMethodBeat.i(203816);
    d.g.b.p.h(paramString, "receiver");
    FinderItem localFinderItem = wJ(paramLong1);
    if (localFinderItem != null)
    {
      ba localba = new ba();
      String str1;
      if (paramarn != null)
      {
        String str2 = paramarn.sessionId;
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "";
      }
      localba.jf(str1);
      localba.es(paramInt);
      localba.et(paramLong2);
      localba.jg(wL(localFinderItem.getId()));
      localba.jh(localFinderItem.getFeedObject().username);
      localba.ji(paramString);
      localba.eu(localFinderItem.getLikeCount());
      localba.ev(localFinderItem.getCommentCount());
      localba.ew(localFinderItem.getFriendLikeCount());
      localba.jj("");
      localba.ex(localFinderItem.getMediaType());
      paramString = com.tencent.mm.plugin.finder.utils.o.sXt;
      localba.jk(d.n.n.h(com.tencent.mm.plugin.finder.utils.o.p(localFinderItem), ",", ";", false));
      localba.jl("");
      if (paramarn != null)
      {
        paramLong2 = paramarn.sch;
        localba.ey(paramLong2);
        if (paramarn != null)
        {
          str1 = paramarn.rfo;
          paramString = str1;
          if (str1 != null) {}
        }
        else
        {
          paramString = "";
        }
        localba.jm(paramString);
        if (paramarn != null)
        {
          str1 = paramarn.rfA;
          paramString = str1;
          if (str1 != null) {}
        }
        else
        {
          paramString = "";
        }
        localba.jn(paramString);
        if (paramarn == null) {
          break label460;
        }
      }
      label426:
      label460:
      for (paramInt = paramarn.sch;; paramInt = 0)
      {
        localba.jo(I(paramLong1, paramInt));
        localba.ez(paramLong3);
        if (paramarn != null)
        {
          paramString = paramarn.extraInfo;
          if (paramString != null)
          {
            str1 = d.n.n.h(paramString, ",", ";", false);
            paramString = str1;
            if (str1 != null) {
              break label373;
            }
          }
        }
        paramString = "";
        label373:
        localba.jp(paramString);
        if (paramarn != null)
        {
          paramString = paramarn.rfr;
          if (paramString != null)
          {
            paramarn = d.n.n.h(paramString, ",", ";", false);
            paramString = paramarn;
            if (paramarn != null) {
              break label426;
            }
          }
        }
        paramString = "";
        localba.jq(paramString);
        localba.aLH();
        a((com.tencent.mm.plugin.report.a)localba);
        AppMethodBeat.o(203816);
        return;
        paramLong2 = 0L;
        break;
      }
    }
    AppMethodBeat.o(203816);
  }
  
  public static void a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203813);
    d.g.b.p.h(paramString, "fromUser");
    a(paramLong, paramInt1, 1L, paramString, paramInt2, paramInt3);
    AppMethodBeat.o(203813);
  }
  
  public static void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203812);
    d.g.b.p.h(paramString, "topic");
    FinderItem localFinderItem = wJ(paramLong);
    if (localFinderItem != null)
    {
      bw localbw = new bw();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbw.lc((String)localObject);
      localbw.ld("");
      localbw.gT(paramInt2);
      localbw.le(wL(localFinderItem.getId()));
      localbw.gU(localFinderItem.getMediaType());
      localObject = com.tencent.mm.plugin.finder.utils.o.sXt;
      localbw.lf(d.n.n.h(com.tencent.mm.plugin.finder.utils.o.A(paramString, paramInt1, 0L), ",", ";", false));
      localbw.lg("");
      localbw.gV(localFinderItem.getFeedObject().likeCount);
      localbw.gW(localFinderItem.getFeedObject().commentCount);
      localbw.gX(localFinderItem.getFeedObject().friendLikeCount);
      localbw.aLH();
      a((com.tencent.mm.plugin.report.a)localbw);
      AppMethodBeat.o(203812);
      return;
    }
    AppMethodBeat.o(203812);
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(203849);
    d.g.b.p.h(paramContext, "context");
    paramContext = new bs();
    paramContext.gC(paramLong1);
    paramContext.gD(paramLong2);
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      paramContext.gE(paramLong1);
      paramContext.aLH();
      AppMethodBeat.o(203849);
      return;
    }
  }
  
  public static void a(Context paramContext, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2, long paramLong4)
  {
    AppMethodBeat.i(203847);
    d.g.b.p.h(paramContext, "context");
    Object localObject = FinderReporterUIC.tnG;
    paramContext = FinderReporterUIC.a.fc(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.cQZ();
      localObject = new bh();
      if (paramContext == null) {
        break label142;
      }
      paramContext = paramContext.sessionId;
      label50:
      ((bh)localObject).jN(paramContext);
      ((bh)localObject).ft(paramLong1);
      if (!paramBoolean1) {
        break label147;
      }
      paramLong1 = 1L;
      label70:
      ((bh)localObject).fu(paramLong1);
      ((bh)localObject).fv(paramLong2);
      ((bh)localObject).fw(paramLong3);
      ((bh)localObject).fx(System.currentTimeMillis());
      if (!paramBoolean2) {
        break label152;
      }
    }
    label142:
    label147:
    label152:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      ((bh)localObject).fy(paramLong1);
      ((bh)localObject).fz(paramLong4);
      ((bh)localObject).aLH();
      AppMethodBeat.o(203847);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label50;
      paramLong1 = 0L;
      break label70;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.model.n paramn, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178394);
    d.g.b.p.h(paramn, "rootComment");
    FinderItem localFinderItem = wJ(paramn.ste.field_feedId);
    if (localFinderItem != null)
    {
      ap localap = new ap();
      localap.dm(paramInt1);
      localap.dn(paramn.ste.cLl().levelTwoComment.size());
      String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localap.hX(str1);
      localap.hY(wL(localFinderItem.getId()));
      localap.hZ(localFinderItem.getUserName());
      localap.dp(System.currentTimeMillis());
      localap.ia(paramn.ste.getUsername());
      localap.jdMethod_do(paramn.ste.cLl().likeCount);
      localap.ib(wL(paramn.lP()));
      localap.dq(paramn.ste.cLl().expandCommentCount);
      switch (paramInt2)
      {
      default: 
        localap.dr(2L);
        if (((paramn.ste.cLl().displayFlag & 0x8) <= 0) && ((paramn.ste.cLl().displayFlag & 0x2) <= 0)) {
          break;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        localap.ds(paramInt1);
        localap.dt(paramInt2);
        localap.aLH();
        a((com.tencent.mm.plugin.report.a)localap);
        AppMethodBeat.o(178394);
        return;
        localap.dr(1L);
        break;
      }
    }
    AppMethodBeat.o(178394);
  }
  
  public static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(203844);
    d.g.b.p.h(parama, "struct");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.RD();
    d.g.b.p.g(parama, "struct.toShowString()");
    com.tencent.mm.sdk.platformtools.ae.i(str, d.n.n.h(parama, "\r\n", " ", false));
    AppMethodBeat.o(203844);
  }
  
  public static void a(arn paramarn, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203841);
    d.g.b.p.h(paramarn, "contextObj");
    com.tencent.mm.g.b.a.ae localae = new com.tencent.mm.g.b.a.ae();
    localae.cr(paramarn.sch);
    localae.hi(paramarn.sessionId);
    localae.hj(paramarn.rfA);
    localae.hk(paramarn.rfo);
    localae.cs(paramInt1);
    if (paramInt2 != 0)
    {
      paramarn = com.tencent.mm.ui.component.a.KEX;
      if (!((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).GI(paramInt2)) {
        break label131;
      }
    }
    label131:
    for (long l = 1L;; l = 0L)
    {
      localae.ct(l);
      localae.aLH();
      a((com.tencent.mm.plugin.report.a)localae);
      AppMethodBeat.o(203841);
      return;
    }
  }
  
  public static void a(arn paramarn, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203828);
    d.g.b.p.h(paramarn, "contextObj");
    d.g.b.p.h(paramString, "replyUsername");
    Object localObject = wJ(paramLong);
    if (localObject != null)
    {
      com.tencent.mm.g.b.a.ak localak = new com.tencent.mm.g.b.a.ak();
      localak.hy(paramarn.sessionId);
      localak.hz("");
      localak.hA(wL(paramLong));
      localak.hB(((FinderItem)localObject).getUserName());
      localak.cN(paramInt1);
      localak.cO(paramInt2);
      localak.cP(paramInt3);
      localak.hC(paramString);
      localak.cQ(paramInt4);
      localak.cR(((FinderItem)localObject).getLikeCount());
      localak.cS(((FinderItem)localObject).getCommentCount());
      localak.cT(((FinderItem)localObject).getFriendLikeCount());
      localak.cU(((FinderItem)localObject).getMediaType());
      paramString = com.tencent.mm.plugin.finder.utils.o.sXt;
      localak.hD(d.n.n.h(com.tencent.mm.plugin.finder.utils.o.p((FinderItem)localObject), ",", ";", false));
      localak.hE("");
      localak.cV(paramarn.sch);
      long l;
      if (d.g.b.p.i(((FinderItem)localObject).getUserName(), v.aAK()))
      {
        l = 1L;
        localak.cW(l);
        if (!paramBoolean1) {
          break label458;
        }
        l = 1L;
        label251:
        localak.cX(l);
        localObject = paramarn.rfA;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localak.hF(paramString);
        localObject = paramarn.rfo;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localak.hG(paramString);
        localak.hH(I(paramLong, paramarn.sch));
        if (!paramBoolean2) {
          break label464;
        }
      }
      label458:
      label464:
      for (paramLong = 1L;; paramLong = 0L)
      {
        localak.cY(paramLong);
        paramString = paramarn.extraInfo;
        if (paramString != null)
        {
          localObject = d.n.n.h(paramString, ",", ";", false);
          paramString = (String)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramString = "";
        }
        localak.hI(paramString);
        paramarn = paramarn.rfr;
        if (paramarn != null)
        {
          paramString = d.n.n.h(paramarn, ",", ";", false);
          paramarn = paramString;
          if (paramString != null) {}
        }
        else
        {
          paramarn = "";
        }
        localak.hJ(paramarn);
        localak.aLH();
        a((com.tencent.mm.plugin.report.a)localak);
        AppMethodBeat.o(203828);
        return;
        l = 0L;
        break;
        l = 0L;
        break label251;
      }
    }
    AppMethodBeat.o(203828);
  }
  
  public static void a(arn paramarn, long paramLong, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(203838);
    d.g.b.p.h(paramarn, "contextObj");
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    FinderItem localFinderItem = wJ(paramLong);
    if (localFinderItem != null)
    {
      ax localax = new ax();
      localax.ea(paramarn.sch);
      localax.iI(paramarn.sessionId);
      localax.iJ(paramarn.rfA);
      localax.iK(paramarn.rfo);
      localax.iL(com.tencent.mm.ac.c.rp(paramLong));
      localax.ec(ch.aDc());
      Object localObject = paramarn.tni;
      if (localObject != null)
      {
        String str = d.n.n.h((String)localObject, ",", ";", false);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localax.iN((String)localObject);
      localax.ed(localFinderItem.getMediaType());
      localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject = com.tencent.mm.plugin.finder.utils.p.cOk().toString();
      d.g.b.p.g(localObject, "FinderUtil.getScreenInfo().toString()");
      localax.iP(d.n.n.h((String)localObject, ",", ";", false));
      localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      paramRecyclerView = com.tencent.mm.plugin.finder.utils.p.x(paramRecyclerView).toString();
      d.g.b.p.g(paramRecyclerView, "FinderUtil.getCurrentScr…(recyclerView).toString()");
      localax.iM(d.n.n.h(paramRecyclerView, ",", ";", false));
      localax.eb(Ft(paramarn.sch));
      localax.iO(I(paramLong, paramarn.sch));
      if (paramarn.sch == 15) {
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
        localax.ee(paramLong);
        paramRecyclerView = localFinderItem.getFeedObject().recommendReason;
        paramarn = paramRecyclerView;
        if (paramRecyclerView == null) {
          paramarn = "";
        }
        localax.iQ(paramarn);
        localax.aLH();
        a((com.tencent.mm.plugin.report.a)localax);
        AppMethodBeat.o(203838);
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
    AppMethodBeat.o(203838);
  }
  
  public static void a(arn paramarn, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203823);
    d.g.b.p.h(paramarn, "contextObj");
    d.g.b.p.h(paramString1, "poiText");
    d.g.b.p.h(paramString2, "filterTextItems");
    bz localbz = new bz();
    localbz.lm(paramarn.sessionId);
    localbz.ln(paramarn.rfA);
    localbz.lo(paramarn.rfo);
    localbz.hc(paramarn.tnf);
    localbz.lp(paramString1);
    localbz.lq(paramString2);
    localbz.hd(paramInt1);
    localbz.he(paramInt2);
    switch (paramarn.sch)
    {
    }
    for (;;)
    {
      localbz.hg(paramarn.sch);
      localbz.aLH();
      a((com.tencent.mm.plugin.report.a)localbz);
      AppMethodBeat.o(203823);
      return;
      localbz.hf(2L);
      continue;
      localbz.hf(1L);
    }
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, long paramLong, arn paramarn, int paramInt6, int paramInt7, String paramString4)
  {
    AppMethodBeat.i(203827);
    d.g.b.p.h(paramString1, "currUI");
    d.g.b.p.h(paramString3, "redDotWording");
    d.g.b.p.h(paramString4, "report_ext_info");
    bq localbq = new bq();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbq.kN(str1);
    localbq.kO(paramString1);
    localbq.gq(paramInt1);
    localbq.gr(paramInt2);
    localbq.gt(paramInt3);
    long l;
    if (com.tencent.mm.sdk.platformtools.j.DEBUG)
    {
      l = 0L;
      localbq.gu(l);
      localbq.gs(paramInt4);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localbq.kP(paramString1);
      localbq.gv(paramInt5);
      localbq.kQ(paramString3);
      localbq.kR(wL(paramLong));
      if (paramarn != null)
      {
        paramString2 = paramarn.rfA;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localbq.kS(paramString1);
      if (paramarn != null)
      {
        paramString2 = paramarn.rfo;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localbq.kT(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() != 1) {
        break label389;
      }
      paramLong = 2L;
      label267:
      localbq.gw(paramLong);
      paramString1 = g.ad(com.tencent.mm.plugin.i.a.t.class);
      d.g.b.p.g(paramString1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramString1 = ((com.tencent.mm.plugin.i.a.t)paramString1).getRedDotManager();
      d.g.b.p.g(paramString1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!paramString1.cBv()) {
        break label395;
      }
    }
    label389:
    label395:
    for (paramLong = 1L;; paramLong = 2L)
    {
      localbq.gx(paramLong);
      localbq.gy(paramInt6);
      localbq.gz(paramInt7);
      if (!bu.isNullOrNil(paramString4)) {
        localbq.kU(paramString4);
      }
      localbq.aLH();
      a((com.tencent.mm.plugin.report.a)localbq);
      AppMethodBeat.o(203827);
      return;
      l = 2L;
      break;
      paramLong = 1L;
      break label267;
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt3, String paramString5, int paramInt4)
  {
    AppMethodBeat.i(203824);
    d.g.b.p.h(paramString1, "currUI");
    d.g.b.p.h(paramString2, "redDotId");
    d.g.b.p.h(paramString3, "redDotWording");
    d.g.b.p.h(paramString4, "contextId");
    d.g.b.p.h(paramString5, "report_ext_info");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() != 1) {
      switch (paramInt1)
      {
      case 0: 
      case 6: 
      default: 
        AppMethodBeat.o(203824);
        return;
      case -1: 
        paramInt1 = 2;
        i = 1;
        paramInt3 = 6;
      }
    }
    for (;;)
    {
      localObject = new arn();
      ((arn)localObject).rfA = paramString4;
      ((arn)localObject).rfo = "";
      a(paramString1, paramInt1, paramInt2, paramInt3, i, 0, paramString2, paramString3, paramLong, (arn)localObject, 0, paramInt4, paramString5);
      AppMethodBeat.o(203824);
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
        AppMethodBeat.o(203824);
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
  
  public static void a(String paramString, int paramInt, arn paramarn)
  {
    AppMethodBeat.i(203821);
    d.g.b.p.h(paramString, "exposeFeedId");
    d.g.b.p.h(paramarn, "contextObj");
    com.tencent.mm.plugin.report.e.ywz.f(20585, new Object[] { paramString, Long.valueOf(ch.aDc()), Integer.valueOf(paramInt), Integer.valueOf(paramarn.sch), paramarn.rfo, paramarn.sessionId });
    AppMethodBeat.o(203821);
  }
  
  public static void ab(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203852);
    d.g.b.p.h(paramString, "fromUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2;
    com.tencent.mm.plugin.report.e.ywz.kvStat(20699, paramString);
    AppMethodBeat.o(203852);
  }
  
  public static void aiL(String paramString)
  {
    AppMethodBeat.i(166588);
    d.g.b.p.h(paramString, "username");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    paramString = str + ',' + paramString;
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "18973 ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.e.ywz.kvStat(18973, paramString);
    AppMethodBeat.o(166588);
  }
  
  public static void b(arn paramarn, long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(203839);
    d.g.b.p.h(paramarn, "contextObj");
    if (wJ(paramLong) != null)
    {
      bl localbl = new bl();
      localbl.fX(paramarn.sch);
      localbl.kn(paramarn.rfA);
      localbl.ko(paramarn.rfo);
      localbl.km(paramarn.sessionId);
      localbl.kl(com.tencent.mm.ac.c.rp(paramLong));
      paramarn = paramString;
      if (paramString == null) {
        paramarn = "";
      }
      localbl.kk(paramarn);
      localbl.fW(paramInt);
      localbl.aLH();
      a((com.tencent.mm.plugin.report.a)localbl);
    }
    AppMethodBeat.o(203839);
  }
  
  public static void c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166586);
    d.g.b.p.h(paramFinderItem, "finderItem");
    FinderObject localFinderObject = paramFinderItem.getFinderObject();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    paramFinderItem = str + ',' + wL(localFinderObject.id) + ',' + localFinderObject.username + ',' + paramFinderItem.getMediaType() + ',' + localFinderObject.recommendType + ',' + localFinderObject.likeCount + ',' + localFinderObject.commentCount + ',' + localFinderObject.friendLikeCount;
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "18950 ".concat(String.valueOf(paramFinderItem)));
    com.tencent.mm.plugin.report.e.ywz.kvStat(18950, paramFinderItem);
    AppMethodBeat.o(166586);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(203851);
    d.g.b.p.h(paramString, "profileUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4;
    com.tencent.mm.plugin.report.e.ywz.kvStat(20698, paramString);
    AppMethodBeat.o(203851);
  }
  
  public static String cFt()
  {
    AppMethodBeat.i(203833);
    String str = UUID.randomUUID().toString();
    d.g.b.p.g(str, "UUID.randomUUID().toString()");
    AppMethodBeat.o(203833);
    return str;
  }
  
  public static int cFu()
  {
    AppMethodBeat.i(203846);
    int i = 0;
    if (az.isWifi(com.tencent.mm.sdk.platformtools.ak.getContext())) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(203846);
      return i;
      if (az.is2G(com.tencent.mm.sdk.platformtools.ak.getContext())) {
        i = 2;
      } else if (az.is3G(com.tencent.mm.sdk.platformtools.ak.getContext())) {
        i = 3;
      } else if (az.is4G(com.tencent.mm.sdk.platformtools.ak.getContext())) {
        i = 4;
      } else if (az.is5G(com.tencent.mm.sdk.platformtools.ak.getContext())) {
        i = 5;
      }
    }
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(203834);
    bf localbf = new bf();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbf.jK(str1);
    localbf.fe(paramInt1);
    localbf.ff(paramInt2);
    localbf.fg(paramInt3);
    localbf.jL(w.FT(w.FU(paramLong)));
    localbf.aLH();
    a((com.tencent.mm.plugin.report.a)localbf);
    AppMethodBeat.o(203834);
  }
  
  public static void d(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(203809);
    if (paramString != null)
    {
      paramString = d.n.n.h(paramString, ",", ";", false);
      if (paramString != null) {
        switch (paramInt)
        {
        default: 
          ((Map)syQ).put(paramLong + '_' + paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      syP.put(paramLong, Long.valueOf(ch.aDc()));
      AppMethodBeat.o(203809);
      return;
      ((Map)syQ).put(paramLong + "_6", paramString);
      ((Map)syQ).put(paramLong + "_23", paramString);
      continue;
      ((Map)syQ).put(paramLong + "_9", paramString);
      ((Map)syQ).put(paramLong + "_22", paramString);
      continue;
      ((Map)syQ).put(paramLong + "_15", paramString);
      ((Map)syQ).put(paramLong + "_16", paramString);
      continue;
      ((Map)syQ).put(paramLong + "_26", paramString);
      ((Map)syQ).put(paramLong + "_27", paramString);
      continue;
      ((Map)syQ).put(paramLong + "_24", paramString);
      ((Map)syQ).put(paramLong + "_21", paramString);
      continue;
      ((Map)syQ).put(paramLong + "_32", paramString);
      ((Map)syQ).put(paramLong + "_1", paramString);
      continue;
      ((Map)syQ).put(paramLong + "_33", paramString);
      ((Map)syQ).put(paramLong + "_8", paramString);
    }
  }
  
  public static void d(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203832);
    d.g.b.p.h(paramFinderItem, "finderItem");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null)
    {
      bi localbi = new bi();
      localbi.jO(wL(paramFinderItem.getId()));
      localbi.jP(((FinderFeedReportObject)localObject).sessionId);
      localbi.jQ(paramFinderItem.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.b.sWa;
      localbi.jR(d.n.n.h(com.tencent.mm.plugin.finder.utils.b.n(paramFinderItem), ",", ";", false));
      localbi.aLH();
      a((com.tencent.mm.plugin.report.a)localbi);
      AppMethodBeat.o(203832);
      return;
    }
    AppMethodBeat.o(203832);
  }
  
  public static void dr(String paramString, int paramInt)
  {
    AppMethodBeat.i(178395);
    d.g.b.p.h(paramString, "username");
    be localbe = new be();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbe.jJ(str1);
    localbe.jI(paramString);
    localbe.fd(paramInt);
    localbe.aLH();
    a((com.tencent.mm.plugin.report.a)localbe);
    AppMethodBeat.o(178395);
  }
  
  public static void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(166582);
    d.g.b.p.h(paramString1, "fromUser");
    d.g.b.p.h(paramString2, "topic");
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    paramString1 = new StringBuilder().append((String)localObject).append(',').append(paramInt1).append(",3,").append(paramString1).append(",0,,");
    localObject = com.tencent.mm.plugin.finder.utils.o.sXt;
    paramString1 = com.tencent.mm.plugin.finder.utils.o.dB(paramString2, paramInt2);
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.ywz.kvStat(18944, paramString1);
    AppMethodBeat.o(166582);
  }
  
  public static String eR(Context paramContext)
  {
    AppMethodBeat.i(203845);
    d.g.b.p.h(paramContext, "context");
    int i = 0;
    if ((paramContext instanceof MMActivity))
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
      i = ((FinderHomeUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderHomeUIC.class)).cQU();
    }
    switch (i)
    {
    default: 
      paramContext = "2";
    }
    for (;;)
    {
      AppMethodBeat.o(203845);
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
    AppMethodBeat.i(203843);
    d.g.b.p.h(paramString1, "tipsId");
    d.g.b.p.h(paramString2, "revokeId");
    bo localbo = new bo();
    localbo.gd(paramInt1);
    localbo.ge(ch.aDd());
    localbo.kB(paramString1);
    localbo.kC(paramString2);
    paramString1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1) {}
    for (long l = 2L;; l = 1L)
    {
      localbo.gf(l);
      localbo.gg(paramInt2);
      localbo.aLH();
      a((com.tencent.mm.plugin.report.a)localbo);
      AppMethodBeat.o(203843);
      return;
    }
  }
  
  public static void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203835);
    br localbr = new br();
    localbr.gA(paramInt1);
    localbr.gB(paramInt2);
    localbr.aLH();
    a((com.tencent.mm.plugin.report.a)localbr);
    AppMethodBeat.o(203835);
  }
  
  public static void g(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166585);
    d.g.b.p.h(paramFinderObject, "finderObject");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    paramFinderObject = str + ',' + 1 + ',' + wL(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.recommendType;
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "18953 ".concat(String.valueOf(paramFinderObject)));
    com.tencent.mm.plugin.report.e.ywz.kvStat(18953, paramFinderObject);
    AppMethodBeat.o(166585);
  }
  
  public static void gs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178396);
    d.g.b.p.h(paramString1, "contextId");
    d.g.b.p.h(paramString2, "action");
    ca localca = new ca();
    localca.ls(paramString1);
    localca.lr(paramString2);
    localca.hh(ch.aDc());
    paramString2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localca.lt(paramString1);
    if (com.tencent.mm.sdk.platformtools.j.DEBUG) {}
    for (long l = 0L;; l = 1L)
    {
      localca.hi(l);
      localca.aLH();
      a((com.tencent.mm.plugin.report.a)localca);
      AppMethodBeat.o(178396);
      return;
    }
  }
  
  public static void h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(203818);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
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
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "18947 ".concat(String.valueOf(localObject)));
      com.tencent.mm.plugin.report.e.ywz.kvStat(18947, (String)localObject);
      AppMethodBeat.o(203818);
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
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    paramString1 = str + ',' + paramString1 + ',' + paramString2 + ',' + 0 + ',' + paramInt1 + ',' + paramInt2;
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "18949 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.ywz.kvStat(18949, paramString1);
    AppMethodBeat.o(166584);
  }
  
  public static FinderItem wJ(long paramLong)
  {
    AppMethodBeat.i(166576);
    Object localObject1 = d.sKD;
    Object localObject2 = d.a.xk(paramLong);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = h.sEe;
      localObject1 = (FinderItem)h.cGM().get(Long.valueOf(paramLong));
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = FinderTopicFeedUI.sqP;
      localObject2 = (FinderItem)FinderTopicFeedUI.cDM().get(Long.valueOf(paramLong));
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = FinderAtTimelineUI.smg;
      localObject1 = (FinderItem)FinderAtTimelineUI.cDM().get(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(166576);
    return localObject1;
  }
  
  public static long wK(long paramLong)
  {
    AppMethodBeat.i(203808);
    Long localLong = (Long)syP.get(paramLong);
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(203808);
      return paramLong;
    }
    AppMethodBeat.o(203808);
    return 0L;
  }
  
  public static String wL(long paramLong)
  {
    AppMethodBeat.i(166591);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(syS);
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
    String str = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
    paramString1 = str + ',' + paramInt + ",2," + paramString1 + ",0," + paramString2;
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.ywz.kvStat(18944, paramString1);
    AppMethodBeat.o(166581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i
 * JD-Core Version:    0.7.0.1
 */