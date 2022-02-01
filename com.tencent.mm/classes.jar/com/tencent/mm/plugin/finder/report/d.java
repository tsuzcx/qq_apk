package com.tencent.mm.plugin.finder.report;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.g.b.a.ag;
import com.tencent.mm.g.b.a.ah;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.g.b.a.am;
import com.tencent.mm.g.b.a.ap;
import com.tencent.mm.g.b.a.aq;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.g.b.a.az;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.g.b.a.bk;
import com.tencent.mm.g.b.a.bl;
import com.tencent.mm.g.b.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.y;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TWO_64", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFinderFeedCgiFetchTimeMap", "()Landroid/util/SparseArray;", "finderFeedFetchTimeMap", "Landroid/util/LongSparseArray;", "getFinderFeedFetchTimeMap", "()Landroid/util/LongSparseArray;", "sessionBufferMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSessionBufferMap", "()Ljava/util/HashMap;", "setSessionBufferMap", "(Ljava/util/HashMap;)V", "asUnsignedDecimalString", "l", "finderAvatarClick19405", "", "clickAvatarScene", "", "feedId", "commentScene", "finderRole", "clickFinderUsername", "finderBackToTop19995", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "tabType", "finderChangeRoleClick", "roleBeforeSwitch", "finderClickEntrance19025", "contextId", "redDotId", "finderClickMoreReport", "scene", "finderClickTopic19186", "topic", "topicType", "topicFeedCount", "finderClickTopicFeedReport", "finderCommentFlagReport", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderCreateContactReport", "success", "", "addHeadIcon", "addSignature", "finderDistrictAlertClick", "username", "finderExposeFeedReport", "finderFavReport", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "finderLocationRequest19954", "context", "Landroid/content/Context;", "finderRealLikeAction19956", "finderRealLikeExpose19955", "exposeItems", "totalCount", "enterContextId", "finderRealLikeUserModify19957", "addUsernames", "delUsernames", "finderRedDot18948", "currUI", "redDotType", "showType", "redDotSubType", "count", "redDotWording", "currentTabType", "autoClick", "redDotBizType", "finderRedDotRevoke20223", "ctrType", "tipsId", "revokeId", "revokeStatus", "finderReportClickMention", "clickUsername", "finderReportEnterAtTimeline", "finderReportFav", "opType", "finderReportFlowClick19993", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "finderReportFollow", "finderUsername", "finderReportHitTabClick19998", "finderReportLikeAndComment", "actionType", "likeAction", "replyUsername", "userScene", "isShowRecWording", "finderReportMsgItemClick", "type", "isOverlap", "overlapCount", "finderReportOpenDrawer", "clickType", "finderReportPostMentionInfo", "finderReportSysMsgClick", "redDotCount", "finderReportTabChange", "fromTab", "toTab", "finderSaveNameCard", "finderSettingClickReport", "settingType", "finderShareFeedClick18944", "fromUser", "isCgiEnd", "finderShareFeedReport", "shareType", "receiver", "finderShareNameCardClickReport", "nameCardUser", "finderShareNameCardReport", "author", "followCount", "authType", "finderShareTopicClickReport", "finderShareTopicReport", "finderSubCommentExpand", "rootComment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "expandType", "finderTimelineMoreAction", "messageType", "isFloat", "finderTraceAction", "finderUnlikeFeedReport", "page", "unlikeType", "finderVoiceFlagReport", "getCurrentTabRedDotUI", "getFeedCigFetchTime", "getFinderFeedFetchTime", "getFinderItem", "getFinderItemSessionBuffer", "getReportNetTypeInt", "newUUID", "putFeedCgiFetchTime", "putFinderItemSessionBuffer", "sessionBuffer", "reportIDKeyVideoPlayError", "what", "reportPoiFilter19996", "poiText", "filterTextItems", "hasUnfoldBtn", "isUnfoldBtnClick", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "transformTabIndexToTabType", "tabIndex", "transformTabTypeToCommentScene", "plugin-finder_release"})
public final class d
{
  public static final String TAG = "Finder.FinderReportLogic";
  private static final LongSparseArray<Long> rxn;
  private static HashMap<String, String> rxo;
  private static final SparseArray<Long> rxp;
  private static final BigInteger rxq;
  public static final d rxr;
  
  static
  {
    AppMethodBeat.i(166595);
    rxr = new d();
    TAG = "Finder.FinderReportLogic";
    rxn = new LongSparseArray();
    rxo = new HashMap();
    rxp = new SparseArray();
    rxq = BigInteger.ONE.shiftLeft(64);
    AppMethodBeat.o(166595);
  }
  
  public static void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(202745);
    bj localbj = new bj();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbj.jl(str1);
    localbj.fA(paramInt1);
    localbj.fB(paramInt2);
    localbj.fC(paramInt3);
    localbj.fD(paramInt4);
    localbj.aHZ();
    a((com.tencent.mm.plugin.report.a)localbj);
    AppMethodBeat.o(202745);
  }
  
  public static long DT(int paramInt)
  {
    AppMethodBeat.i(202731);
    Long localLong = (Long)rxp.get(paramInt);
    if (localLong != null)
    {
      long l = localLong.longValue();
      AppMethodBeat.o(202731);
      return l;
    }
    AppMethodBeat.o(202731);
    return 0L;
  }
  
  public static void DU(int paramInt)
  {
    AppMethodBeat.i(202732);
    rxp.put(paramInt, Long.valueOf(ce.azJ()));
    AppMethodBeat.o(202732);
  }
  
  public static void DV(int paramInt)
  {
    AppMethodBeat.i(166594);
    switch (paramInt)
    {
    default: 
      locala = n.rAp;
      n.a.lA(n.cxD());
      AppMethodBeat.o(166594);
      return;
    case -1010: 
      locala = n.rAp;
      n.a.lA(n.cxq());
      AppMethodBeat.o(166594);
      return;
    case -1007: 
      locala = n.rAp;
      n.a.lA(n.cxr());
      AppMethodBeat.o(166594);
      return;
    case -1004: 
      locala = n.rAp;
      n.a.lA(n.cxs());
      AppMethodBeat.o(166594);
      return;
    case -10012: 
      locala = n.rAp;
      n.a.lA(n.cxt());
      AppMethodBeat.o(166594);
      return;
    case -10004: 
      locala = n.rAp;
      n.a.lA(n.cxu());
      AppMethodBeat.o(166594);
      return;
    case -21009: 
      locala = n.rAp;
      n.a.lA(n.cxv());
      AppMethodBeat.o(166594);
      return;
    case -21020: 
      locala = n.rAp;
      n.a.lA(n.cxw());
      AppMethodBeat.o(166594);
      return;
    case 404: 
      locala = n.rAp;
      n.a.lA(n.cxx());
      AppMethodBeat.o(166594);
      return;
    case 403: 
      locala = n.rAp;
      n.a.lA(n.cxy());
      AppMethodBeat.o(166594);
      return;
    case 503: 
      locala = n.rAp;
      n.a.lA(n.cxz());
      AppMethodBeat.o(166594);
      return;
    case 502: 
      locala = n.rAp;
      n.a.lA(n.cxA());
      AppMethodBeat.o(166594);
      return;
    case 416: 
      locala = n.rAp;
      n.a.lA(n.cxB());
      AppMethodBeat.o(166594);
      return;
    }
    n.a locala = n.rAp;
    n.a.lA(n.cxC());
    AppMethodBeat.o(166594);
  }
  
  public static int DW(int paramInt)
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
  
  public static String G(long paramLong, int paramInt)
  {
    AppMethodBeat.i(202728);
    String str2 = (String)rxo.get(paramLong + '_' + paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(202728);
    return str1;
  }
  
  public static void H(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166577);
    FinderItem localFinderItem = ur(paramLong);
    if (localFinderItem != null)
    {
      z localz = new z();
      String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localz.fX(str1);
      localz.fY(com.tencent.mm.ac.c.pb(localFinderItem.getId()));
      localz.cl(paramInt);
      localz.cg(localFinderItem.getLikeCount());
      localz.ch(localFinderItem.getCommentCount());
      localz.ci(localFinderItem.getFriendLikeCount());
      localz.ck(localFinderItem.getMediaType());
      localz.fZ("");
      localz.cj(paramInt);
      localz.aHZ();
      a((com.tencent.mm.plugin.report.a)localz);
      AppMethodBeat.o(166577);
      return;
    }
    AppMethodBeat.o(166577);
  }
  
  public static void I(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166580);
    FinderItem localFinderItem = ur(paramLong);
    if (localFinderItem != null)
    {
      ay localay = new ay();
      String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localay.iv((String)localObject);
      localay.eO(paramInt);
      localObject = m.rPH;
      localay.iw(d.n.n.h(m.n(localFinderItem), ",", ";", false));
      localay.ix("");
      localay.iy(ut(localFinderItem.getId()));
      localay.eP(localFinderItem.getFeedObject().likeCount);
      localay.aHZ();
      a((com.tencent.mm.plugin.report.a)localay);
      AppMethodBeat.o(166580);
      return;
    }
    AppMethodBeat.o(166580);
  }
  
  public static void V(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(202753);
    k.h(paramContext, "context");
    as localas = new as();
    Object localObject = FinderReporterUIC.seQ;
    paramContext = FinderReporterUIC.a.eV(paramContext);
    if (paramContext != null) {
      localas.hY(paramContext.sessionId);
    }
    for (;;)
    {
      localas.ee(paramInt);
      localas.aHZ();
      a((com.tencent.mm.plugin.report.a)localas);
      AppMethodBeat.o(202753);
      return;
      localObject = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      localas.hY(paramContext);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, anm paramanm)
  {
    long l2 = 0L;
    AppMethodBeat.i(202750);
    k.h(paramanm, "contextObj");
    ak localak = new ak();
    long l1;
    if (paramInt1 > 0)
    {
      l1 = paramInt1;
      localak.dh(l1);
      l1 = l2;
      if (paramInt2 > 0) {
        l1 = paramInt2;
      }
      localak.di(l1);
      localak.dj(ce.azJ());
      localak.gW(paramanm.sessionId);
      localak.gY(paramanm.qox);
      localak.gX(paramanm.qom);
      localak.Qf();
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localak.aHZ();
      a((com.tencent.mm.plugin.report.a)localak);
      paramanm = g.agR();
      k.g(paramanm, "MMKernel.storage()");
      paramanm.agA().set(ah.a.GVY, localak.Qd());
      if (paramInt2 != 2)
      {
        paramanm = g.agR();
        k.g(paramanm, "MMKernel.storage()");
        paramanm.agA().set(ah.a.GVZ, localak.Qd());
      }
      com.tencent.mm.sdk.platformtools.ac.i(TAG, "finderReportTabChange clickTabContextId [%s] toTab[%d]", new Object[] { localak.Qd(), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(202750);
      return;
      l1 = 0L;
      break;
      paramanm = g.ad(PluginFinder.class);
      k.g(paramanm, "MMKernel.plugin(PluginFinder::class.java)");
      if (((PluginFinder)paramanm).getRedDotManager().adw("TLFollow") != null)
      {
        localak.Qe();
        continue;
        paramanm = g.ad(PluginFinder.class);
        k.g(paramanm, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)paramanm).getRedDotManager().adw("TLRecommendTab") != null)
        {
          localak.Qe();
          continue;
          paramanm = g.ad(PluginFinder.class);
          k.g(paramanm, "MMKernel.plugin(PluginFinder::class.java)");
          if (((PluginFinder)paramanm).getRedDotManager().adw("TLMachineTab") != null)
          {
            localak.Qe();
            continue;
            paramanm = g.ad(PluginFinder.class);
            k.g(paramanm, "MMKernel.plugin(PluginFinder::class.java)");
            if (((PluginFinder)paramanm).getRedDotManager().adw("TLLbsTab") != null) {
              localak.Qe();
            }
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(202743);
    FinderItem localFinderItem = ur(paramLong);
    if (localFinderItem != null)
    {
      ad localad = new ad();
      String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localad.gs((String)localObject);
      localad.gt("");
      localad.gu(ut(paramLong));
      localad.gv(localFinderItem.getUserName());
      localad.cE(localFinderItem.getLikeCount());
      localad.cF(localFinderItem.getCommentCount());
      localad.cG(localFinderItem.getFriendLikeCount());
      localad.ic(paramInt2);
      localad.cH(paramInt1);
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czM()) {}
      for (paramLong = 1L;; paramLong = 0L)
      {
        localad.cI(paramLong);
        localad.aHZ();
        a((com.tencent.mm.plugin.report.a)localad);
        AppMethodBeat.o(202743);
        return;
      }
    }
    AppMethodBeat.o(202743);
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    long l = 1L;
    AppMethodBeat.i(202744);
    k.h(paramString, "clickFinderUsername");
    com.tencent.mm.g.b.a.ai localai = new com.tencent.mm.g.b.a.ai();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localai.gK(str1);
    localai.gN(ut(paramLong));
    localai.dc(paramInt1);
    localai.db(paramInt2);
    switch (paramInt2)
    {
    default: 
      localai.cY(2L);
    }
    for (;;)
    {
      localai.cX(paramInt3);
      localai.gL(paramString);
      localai.gM(u.axE());
      paramString = ur(paramLong);
      if (paramString != null)
      {
        localai.cZ(paramString.getLikeCount());
        localai.da(paramString.getCommentCount());
      }
      paramLong = l;
      if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
        paramLong = 0L;
      }
      localai.dd(paramLong);
      localai.aHZ();
      a((com.tencent.mm.plugin.report.a)localai);
      AppMethodBeat.o(202744);
      return;
      localai.cY(1L);
    }
  }
  
  public static void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(166579);
    k.h(paramString1, "topic");
    k.h(paramString2, "receiver");
    bi localbi = new bi();
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbi.jh((String)localObject);
    localbi.fx(paramInt1);
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localbi.fy(l);
      localObject = m.rPH;
      localbi.ji(d.n.n.h(m.f(paramString1, paramInt2, paramLong), ",", ";", false));
      localbi.jj("");
      localbi.fz(paramLong);
      localbi.jk(paramString2);
      localbi.aHZ();
      a((com.tencent.mm.plugin.report.a)localbi);
      AppMethodBeat.o(166579);
      return;
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    AppMethodBeat.i(166587);
    Object localObject = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    localObject = new StringBuilder().append((String)localObject).append(',').append(paramInt).append(',');
    if (paramBoolean1)
    {
      paramInt = 1;
      localObject = ((StringBuilder)localObject).append(paramInt).append(',');
      if (!paramBoolean2) {
        break label148;
      }
      paramInt = 1;
      label77:
      localObject = ((StringBuilder)localObject).append(paramInt).append(',');
      if (!paramBoolean3) {
        break label153;
      }
    }
    label148:
    label153:
    for (paramInt = i;; paramInt = 0)
    {
      localObject = paramInt;
      com.tencent.mm.sdk.platformtools.ac.i(TAG, "18947 ".concat(String.valueOf(localObject)));
      com.tencent.mm.plugin.report.e.wTc.kvStat(18947, (String)localObject);
      AppMethodBeat.o(166587);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label77;
    }
  }
  
  public static void a(long paramLong, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(202734);
    k.h(paramString, "fromUser");
    ag localag = new ag();
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localag.gA((String)localObject);
    localag.cM(paramInt1);
    localag.Qc();
    localag.gB(paramString);
    localag.gC(ut(paramLong));
    localag.cO(paramInt2);
    paramString = ur(paramLong);
    if (paramString != null)
    {
      localag.gD(paramString.getFeedObject().username);
      localObject = m.rPH;
      localag.gE(d.n.n.h(m.n(paramString), ",", ";", false));
      localObject = (Iterable)paramString.getMediaList();
      paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        if (bs.isNullOrNil(((bqs)((Iterator)localObject).next()).coverUrl)) {}
        for (paramLong = 0L;; paramLong = 1L)
        {
          localag.cN(paramLong);
          paramString.add(y.KTp);
          break;
        }
      }
    }
    localag.aHZ();
    a((com.tencent.mm.plugin.report.a)localag);
    AppMethodBeat.o(202734);
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean, String paramString, anm paramanm)
  {
    AppMethodBeat.i(202735);
    k.h(paramString, "receiver");
    k.h(paramanm, "contextObj");
    FinderItem localFinderItem = ur(paramLong);
    if (localFinderItem != null)
    {
      ap localap = new ap();
      String str2 = paramanm.sessionId;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localap.hy(str1);
      localap.dA(paramInt);
      if (paramBoolean) {}
      for (long l = 1L;; l = 2L)
      {
        localap.dB(l);
        localap.hz(ut(localFinderItem.getId()));
        localap.hA(localFinderItem.getFeedObject().username);
        localap.hB(paramString);
        localap.dC(localFinderItem.getLikeCount());
        localap.dD(localFinderItem.getCommentCount());
        localap.dE(localFinderItem.getFriendLikeCount());
        localap.hC("");
        localap.dF(localFinderItem.getMediaType());
        paramString = m.rPH;
        localap.hD(d.n.n.h(m.n(localFinderItem), ",", ";", false));
        localap.hE("");
        localap.dG(paramanm.rfR);
        str1 = paramanm.qom;
        paramString = str1;
        if (str1 == null) {
          paramString = "";
        }
        localap.hF(paramString);
        str1 = paramanm.qox;
        paramString = str1;
        if (str1 == null) {
          paramString = "";
        }
        localap.hG(paramString);
        localap.hH(G(paramLong, paramanm.rfR));
        localap.aHZ();
        a((com.tencent.mm.plugin.report.a)localap);
        AppMethodBeat.o(202735);
        return;
      }
    }
    AppMethodBeat.o(202735);
  }
  
  public static void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202733);
    k.h(paramString, "topic");
    FinderItem localFinderItem = ur(paramLong);
    if (localFinderItem != null)
    {
      bh localbh = new bh();
      String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbh.jc((String)localObject);
      localbh.jd("");
      localbh.fs(paramInt2);
      localbh.je(ut(localFinderItem.getId()));
      localbh.ft(localFinderItem.getMediaType());
      localObject = m.rPH;
      localbh.jf(d.n.n.h(m.f(paramString, paramInt1, 0L), ",", ";", false));
      localbh.jg("");
      localbh.fu(localFinderItem.getFeedObject().likeCount);
      localbh.fv(localFinderItem.getFeedObject().commentCount);
      localbh.fw(localFinderItem.getFeedObject().friendLikeCount);
      localbh.aHZ();
      a((com.tencent.mm.plugin.report.a)localbh);
      AppMethodBeat.o(202733);
      return;
    }
    AppMethodBeat.o(202733);
  }
  
  public static void a(com.tencent.mm.plugin.finder.model.l paraml, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178394);
    k.h(paraml, "rootComment");
    FinderItem localFinderItem = ur(paraml.ruO.field_feedId);
    if (localFinderItem != null)
    {
      ah localah = new ah();
      localah.cP(paramInt1);
      localah.cQ(paraml.ruO.field_actionInfo.EDq.levelTwoComment.size());
      String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localah.gF(str1);
      localah.gG(ut(localFinderItem.getId()));
      localah.gH(localFinderItem.getUserName());
      localah.cS(System.currentTimeMillis());
      localah.gI(paraml.ruO.getUsername());
      localah.cR(paraml.ruO.field_actionInfo.EDq.likeCount);
      localah.gJ(ut(paraml.lx()));
      localah.cT(paraml.ruO.field_actionInfo.EDq.expandCommentCount);
      switch (paramInt2)
      {
      default: 
        localah.cU(2L);
        if (((paraml.ruO.field_actionInfo.EDq.displayFlag & 0x8) <= 0) && ((paraml.ruO.field_actionInfo.EDq.displayFlag & 0x2) <= 0)) {
          break;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        localah.cV(paramInt1);
        localah.cW(paramInt2);
        localah.aHZ();
        a((com.tencent.mm.plugin.report.a)localah);
        AppMethodBeat.o(178394);
        return;
        localah.cU(1L);
        break;
      }
    }
    AppMethodBeat.o(178394);
  }
  
  public static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(202757);
    k.h(parama, "struct");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.PS();
    k.g(parama, "struct.toShowString()");
    com.tencent.mm.sdk.platformtools.ac.i(str, d.n.n.h(parama, "\r\n", " ", false));
    AppMethodBeat.o(202757);
  }
  
  public static void a(anm paramanm, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202754);
    k.h(paramanm, "contextObj");
    aa localaa = new aa();
    localaa.cm(paramanm.rfR);
    localaa.ga(paramanm.sessionId);
    localaa.gb(paramanm.qox);
    localaa.gc(paramanm.qom);
    localaa.cn(paramInt1);
    if (paramInt2 != 0)
    {
      paramanm = com.tencent.mm.ui.component.a.IrY;
      if (!((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)).EV(paramInt2)) {
        break label131;
      }
    }
    label131:
    for (long l = 1L;; l = 0L)
    {
      localaa.co(l);
      localaa.aHZ();
      a((com.tencent.mm.plugin.report.a)localaa);
      AppMethodBeat.o(202754);
      return;
    }
  }
  
  public static void a(anm paramanm, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(202741);
    k.h(paramanm, "contextObj");
    k.h(paramString, "replyUsername");
    Object localObject = ur(paramLong);
    if (localObject != null)
    {
      com.tencent.mm.g.b.a.ac localac = new com.tencent.mm.g.b.a.ac();
      localac.gi(paramanm.sessionId);
      localac.gj("");
      localac.gk(ut(paramLong));
      localac.gl(((FinderItem)localObject).getUserName());
      localac.ct(paramInt1);
      localac.cu(paramInt2);
      localac.cv(paramInt3);
      localac.gm(paramString);
      localac.cw(paramInt4);
      localac.cx(((FinderItem)localObject).getLikeCount());
      localac.cy(((FinderItem)localObject).getCommentCount());
      localac.cz(((FinderItem)localObject).getFriendLikeCount());
      localac.cA(((FinderItem)localObject).getMediaType());
      paramString = m.rPH;
      localac.gn(d.n.n.h(m.n((FinderItem)localObject), ",", ";", false));
      localac.go("");
      localac.cB(paramanm.rfR);
      if (k.g(((FinderItem)localObject).getUserName(), u.axE()))
      {
        l = 1L;
        localac.cC(l);
        if (!paramBoolean) {
          break label356;
        }
      }
      label356:
      for (long l = 1L;; l = 0L)
      {
        localac.cD(l);
        localObject = paramanm.qox;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localac.gp(paramString);
        localObject = paramanm.qom;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localac.gq(paramString);
        localac.gr(G(paramLong, paramanm.rfR));
        localac.aHZ();
        a((com.tencent.mm.plugin.report.a)localac);
        AppMethodBeat.o(202741);
        return;
        l = 0L;
        break;
      }
    }
    AppMethodBeat.o(202741);
  }
  
  public static void a(anm paramanm, long paramLong, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202751);
    k.h(paramanm, "contextObj");
    k.h(paramRecyclerView, "recyclerView");
    FinderItem localFinderItem = ur(paramLong);
    if (localFinderItem != null)
    {
      am localam = new am();
      localam.dk(paramanm.rfR);
      localam.hd(paramanm.sessionId);
      localam.he(paramanm.qox);
      localam.hf(paramanm.qom);
      localam.hg(com.tencent.mm.ac.c.pb(paramLong));
      localam.dm(ce.azJ());
      Object localObject = paramanm.ses;
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
      localam.hi((String)localObject);
      localam.dn(localFinderItem.getMediaType());
      localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
      localObject = com.tencent.mm.plugin.finder.utils.n.cDl().toString();
      k.g(localObject, "FinderUtil.getScreenInfo().toString()");
      localam.hk(d.n.n.h((String)localObject, ",", ";", false));
      localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
      paramRecyclerView = com.tencent.mm.plugin.finder.utils.n.y(paramRecyclerView).toString();
      k.g(paramRecyclerView, "FinderUtil.getCurrentScr…(recyclerView).toString()");
      localam.hh(d.n.n.h(paramRecyclerView, ",", ";", false));
      localam.dl(DT(paramanm.rfR));
      localam.hj(G(paramLong, paramanm.rfR));
      localam.aHZ();
      a((com.tencent.mm.plugin.report.a)localam);
      AppMethodBeat.o(202751);
      return;
    }
    AppMethodBeat.o(202751);
  }
  
  public static void a(anm paramanm, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202737);
    k.h(paramanm, "contextObj");
    k.h(paramString1, "poiText");
    k.h(paramString2, "filterTextItems");
    bk localbk = new bk();
    localbk.jm(paramanm.sessionId);
    localbk.jn(paramanm.qox);
    localbk.jo(paramanm.qom);
    localbk.fE(paramanm.seo);
    localbk.jp(paramString1);
    localbk.jq(paramString2);
    localbk.fF(paramInt1);
    localbk.fG(paramInt2);
    switch (paramanm.rfR)
    {
    }
    for (;;)
    {
      localbk.fI(paramanm.rfR);
      localbk.aHZ();
      a((com.tencent.mm.plugin.report.a)localbk);
      AppMethodBeat.o(202737);
      return;
      localbk.fH(2L);
      continue;
      localbk.fH(1L);
    }
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, long paramLong, anm paramanm, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(202739);
    k.h(paramString1, "currUI");
    k.h(paramString2, "redDotId");
    k.h(paramString3, "redDotWording");
    bd localbd = new bd();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbd.iS(str1);
    localbd.iT(paramString1);
    localbd.fa(paramInt1);
    localbd.fb(paramInt2);
    localbd.fd(paramInt3);
    long l;
    if (com.tencent.mm.sdk.platformtools.h.DEBUG)
    {
      l = 0L;
      localbd.fe(l);
      localbd.fc(paramInt4);
      localbd.iU(paramString2);
      localbd.ff(paramInt5);
      localbd.iV(paramString3);
      localbd.iW(ut(paramLong));
      if (paramanm != null)
      {
        paramString2 = paramanm.qox;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localbd.iX(paramString1);
      if (paramanm != null)
      {
        paramString2 = paramanm.qom;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localbd.iY(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czT()) {
        break label351;
      }
      paramLong = 2L;
      label245:
      localbd.fg(paramLong);
      paramString1 = g.ad(com.tencent.mm.plugin.i.a.l.class);
      k.g(paramString1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramString1 = ((com.tencent.mm.plugin.i.a.l)paramString1).getRedDotManager();
      k.g(paramString1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!paramString1.ctK()) {
        break label357;
      }
    }
    label351:
    label357:
    for (paramLong = 1L;; paramLong = 2L)
    {
      localbd.fh(paramLong);
      localbd.fi(paramInt6);
      localbd.fj(paramInt7);
      localbd.aHZ();
      a((com.tencent.mm.plugin.report.a)localbd);
      AppMethodBeat.o(202739);
      return;
      l = 2L;
      break;
      paramLong = 1L;
      break label245;
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(202738);
    k.h(paramString1, "currUI");
    k.h(paramString2, "redDotId");
    k.h(paramString3, "redDotWording");
    k.h(paramString4, "contextId");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    int i;
    if (!com.tencent.mm.plugin.finder.storage.b.czT()) {
      switch (paramInt1)
      {
      case 0: 
      case 6: 
      default: 
        AppMethodBeat.o(202738);
        return;
      case -1: 
        paramInt1 = 2;
        i = 1;
        paramInt3 = 6;
      }
    }
    for (;;)
    {
      localObject = new anm();
      ((anm)localObject).qox = paramString4;
      ((anm)localObject).qom = "";
      a(paramString1, paramInt1, paramInt2, paramInt3, i, 0, paramString2, paramString3, paramLong, (anm)localObject, 0, 0, 3072);
      AppMethodBeat.o(202738);
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
        AppMethodBeat.o(202738);
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
        paramInt3 = 4;
        break;
      case 7: 
        paramInt1 = 8;
        i = 0;
        paramInt3 = 3;
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
  
  public static void ab(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202748);
    au localau = new au();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localau.ib(str1);
    localau.eg(paramInt1);
    localau.eh(paramInt2);
    localau.ei(paramInt3);
    localau.aHZ();
    a((com.tencent.mm.plugin.report.a)localau);
    AppMethodBeat.o(202748);
  }
  
  public static void adO(String paramString)
  {
    AppMethodBeat.i(166588);
    k.h(paramString, "username");
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    paramString = str + ',' + paramString;
    com.tencent.mm.sdk.platformtools.ac.i(TAG, "18973 ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.e.wTc.kvStat(18973, paramString);
    AppMethodBeat.o(166588);
  }
  
  public static void b(int paramInt, anm paramanm)
  {
    AppMethodBeat.i(202736);
    k.h(paramanm, "contextObj");
    aq localaq = new aq();
    localaq.dH(paramanm.rfR);
    localaq.hI(paramanm.sessionId);
    localaq.hJ(paramanm.qox);
    localaq.hK(paramanm.qom);
    localaq.hI(paramanm.sessionId);
    localaq.dJ(ce.azJ());
    localaq.dI(paramInt);
    localaq.aHZ();
    a((com.tencent.mm.plugin.report.a)localaq);
    AppMethodBeat.o(202736);
  }
  
  public static void b(anm paramanm, long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(202752);
    k.h(paramanm, "contextObj");
    k.h(paramString, "username");
    if (ur(paramLong) != null)
    {
      az localaz = new az();
      localaz.eR(paramanm.rfR);
      localaz.iC(paramanm.qox);
      localaz.iD(paramanm.qom);
      localaz.iB(paramanm.sessionId);
      localaz.iA(com.tencent.mm.ac.c.pb(paramLong));
      localaz.iz(paramString);
      localaz.eQ(paramInt);
      localaz.aHZ();
      a((com.tencent.mm.plugin.report.a)localaz);
    }
    AppMethodBeat.o(202752);
  }
  
  public static void c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166586);
    k.h(paramFinderItem, "finderItem");
    FinderObject localFinderObject = paramFinderItem.getFinderObject();
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    paramFinderItem = str + ',' + ut(localFinderObject.id) + ',' + localFinderObject.username + ',' + paramFinderItem.getMediaType() + ',' + localFinderObject.recommendType + ',' + localFinderObject.likeCount + ',' + localFinderObject.commentCount + ',' + localFinderObject.friendLikeCount;
    com.tencent.mm.sdk.platformtools.ac.i(TAG, "18950 ".concat(String.valueOf(paramFinderItem)));
    com.tencent.mm.plugin.report.e.wTc.kvStat(18950, paramFinderItem);
    AppMethodBeat.o(166586);
  }
  
  public static String cwT()
  {
    AppMethodBeat.i(202747);
    String str = UUID.randomUUID().toString();
    k.g(str, "UUID.randomUUID().toString()");
    AppMethodBeat.o(202747);
    return str;
  }
  
  public static int cwU()
  {
    AppMethodBeat.i(202759);
    int i = 0;
    if (ax.isWifi(com.tencent.mm.sdk.platformtools.ai.getContext())) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(202759);
      return i;
      if (ax.is2G(com.tencent.mm.sdk.platformtools.ai.getContext())) {
        i = 2;
      } else if (ax.is3G(com.tencent.mm.sdk.platformtools.ai.getContext())) {
        i = 3;
      } else if (ax.is4G(com.tencent.mm.sdk.platformtools.ai.getContext())) {
        i = 4;
      } else if (ax.is5G(com.tencent.mm.sdk.platformtools.ai.getContext())) {
        i = 5;
      }
    }
  }
  
  public static void d(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(202730);
    if (paramString != null)
    {
      paramString = d.n.n.h(paramString, ",", ";", false);
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
          ((Map)rxo).put(paramLong + '_' + paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      rxn.put(paramLong, Long.valueOf(ce.azJ()));
      AppMethodBeat.o(202730);
      return;
      ((Map)rxo).put(paramLong + "_6", paramString);
      ((Map)rxo).put(paramLong + "_23", paramString);
      continue;
      ((Map)rxo).put(paramLong + "_9", paramString);
      ((Map)rxo).put(paramLong + "_22", paramString);
      continue;
      ((Map)rxo).put(paramLong + "_15", paramString);
      ((Map)rxo).put(paramLong + "_16", paramString);
      continue;
      ((Map)rxo).put(paramLong + "_26", paramString);
      ((Map)rxo).put(paramLong + "_27", paramString);
      continue;
      ((Map)rxo).put(paramLong + "_24", paramString);
      ((Map)rxo).put(paramLong + "_21", paramString);
      continue;
      ((Map)rxo).put(paramLong + "_32", paramString);
      ((Map)rxo).put(paramLong + "_1", paramString);
      continue;
      ((Map)rxo).put(paramLong + "_33", paramString);
      ((Map)rxo).put(paramLong + "_8", paramString);
    }
  }
  
  public static void d(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(202746);
    k.h(paramFinderItem, "finderItem");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null)
    {
      aw localaw = new aw();
      localaw.ie(ut(paramFinderItem.getId()));
      localaw.jdMethod_if(((FinderFeedReportObject)localObject).sessionId);
      localaw.ig(paramFinderItem.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.b.rOw;
      localaw.ih(d.n.n.h(com.tencent.mm.plugin.finder.utils.b.l(paramFinderItem), ",", ";", false));
      localaw.aHZ();
      a((com.tencent.mm.plugin.report.a)localaw);
      AppMethodBeat.o(202746);
      return;
    }
    AppMethodBeat.o(202746);
  }
  
  public static void db(String paramString, int paramInt)
  {
    AppMethodBeat.i(178395);
    k.h(paramString, "username");
    at localat = new at();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localat.ia(str1);
    localat.hZ(paramString);
    localat.ef(paramInt);
    localat.aHZ();
    a((com.tencent.mm.plugin.report.a)localat);
    AppMethodBeat.o(178395);
  }
  
  public static void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(166582);
    k.h(paramString1, "fromUser");
    k.h(paramString2, "topic");
    Object localObject = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    paramString1 = new StringBuilder().append((String)localObject).append(',').append(paramInt1).append(",3,").append(paramString1).append(",0,,");
    localObject = m.rPH;
    paramString1 = m.dg(paramString2, paramInt2);
    com.tencent.mm.sdk.platformtools.ac.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.wTc.kvStat(18944, paramString1);
    AppMethodBeat.o(166582);
  }
  
  public static String eN(Context paramContext)
  {
    AppMethodBeat.i(202758);
    k.h(paramContext, "context");
    int i = 0;
    if ((paramContext instanceof MMActivity))
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
      i = ((FinderHomeUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderHomeUIC.class)).cFV();
    }
    switch (i)
    {
    default: 
      paramContext = "2";
    }
    for (;;)
    {
      AppMethodBeat.o(202758);
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
    AppMethodBeat.i(202756);
    k.h(paramString1, "tipsId");
    k.h(paramString2, "revokeId");
    bc localbc = new bc();
    localbc.eW(paramInt1);
    localbc.eX(ce.azK());
    localbc.iQ(paramString1);
    localbc.iR(paramString2);
    paramString1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czT()) {}
    for (long l = 2L;; l = 1L)
    {
      localbc.eY(l);
      localbc.eZ(paramInt2);
      localbc.aHZ();
      a((com.tencent.mm.plugin.report.a)localbc);
      AppMethodBeat.o(202756);
      return;
    }
  }
  
  public static void f(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166585);
    k.h(paramFinderObject, "finderObject");
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    paramFinderObject = str + ',' + 1 + ',' + ut(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.recommendType;
    com.tencent.mm.sdk.platformtools.ac.i(TAG, "18953 ".concat(String.valueOf(paramFinderObject)));
    com.tencent.mm.plugin.report.e.wTc.kvStat(18953, paramFinderObject);
    AppMethodBeat.o(166585);
  }
  
  public static void fy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202749);
    be localbe = new be();
    localbe.fk(paramInt1);
    localbe.fl(paramInt2);
    localbe.aHZ();
    a((com.tencent.mm.plugin.report.a)localbe);
    AppMethodBeat.o(202749);
  }
  
  public static void ge(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178396);
    k.h(paramString1, "contextId");
    k.h(paramString2, "action");
    bl localbl = new bl();
    localbl.js(paramString1);
    localbl.jr(paramString2);
    localbl.fJ(ce.azJ());
    paramString2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localbl.jt(paramString1);
    if (com.tencent.mm.sdk.platformtools.h.DEBUG) {}
    for (long l = 0L;; l = 1L)
    {
      localbl.fK(l);
      localbl.aHZ();
      a((com.tencent.mm.plugin.report.a)localbl);
      AppMethodBeat.o(178396);
      return;
    }
  }
  
  public static void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166584);
    k.h(paramString1, "author");
    k.h(paramString2, "receiver");
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    paramString1 = str + ',' + paramString1 + ',' + paramString2 + ',' + 0 + ',' + paramInt1 + ',' + paramInt2;
    com.tencent.mm.sdk.platformtools.ac.i(TAG, "18949 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.wTc.kvStat(18949, paramString1);
    AppMethodBeat.o(166584);
  }
  
  public static FinderItem ur(long paramLong)
  {
    AppMethodBeat.i(166576);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.d.rEF;
    Object localObject2 = d.a.uS(paramLong);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = com.tencent.mm.plugin.finder.search.h.rBC;
      localObject1 = (FinderItem)com.tencent.mm.plugin.finder.search.h.cxT().get(Long.valueOf(paramLong));
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = FinderTopicFeedUI.rsI;
      localObject2 = (FinderItem)FinderTopicFeedUI.cvK().get(Long.valueOf(paramLong));
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = FinderAtTimelineUI.roG;
      localObject1 = (FinderItem)FinderAtTimelineUI.cvK().get(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(166576);
    return localObject1;
  }
  
  public static long us(long paramLong)
  {
    AppMethodBeat.i(202729);
    Long localLong = (Long)rxn.get(paramLong);
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(202729);
      return paramLong;
    }
    AppMethodBeat.o(202729);
    return 0L;
  }
  
  public static String ut(long paramLong)
  {
    AppMethodBeat.i(166591);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(rxq);
    }
    localObject = ((BigInteger)localObject).toString();
    k.g(localObject, "b.toString()");
    AppMethodBeat.o(166591);
    return localObject;
  }
  
  public static void y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(166581);
    k.h(paramString1, "fromUser");
    k.h(paramString2, "nameCardUser");
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
    paramString1 = str + ',' + paramInt + ",2," + paramString1 + ",0," + paramString2;
    com.tencent.mm.sdk.platformtools.ac.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.wTc.kvStat(18944, paramString1);
    AppMethodBeat.o(166581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.d
 * JD-Core Version:    0.7.0.1
 */