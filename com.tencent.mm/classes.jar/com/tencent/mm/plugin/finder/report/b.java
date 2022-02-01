package com.tencent.mm.plugin.finder.report;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.g.b.a.ae;
import com.tencent.mm.g.b.a.ag;
import com.tencent.mm.g.b.a.ah;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.g.b.a.al;
import com.tencent.mm.g.b.a.am;
import com.tencent.mm.g.b.a.he;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.g.b.a.hj;
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.g.b.a.hm;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.g.b.a.hq;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.g.b.a.hx;
import com.tencent.mm.g.b.a.hz;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.g.b.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.b.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import d.l;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TWO_64", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFinderFeedCgiFetchTimeMap", "()Landroid/util/SparseArray;", "finderFeedFetchTimeMap", "Landroid/util/LongSparseArray;", "getFinderFeedFetchTimeMap", "()Landroid/util/LongSparseArray;", "sessionBufferMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSessionBufferMap", "()Ljava/util/HashMap;", "setSessionBufferMap", "(Ljava/util/HashMap;)V", "asUnsignedDecimalString", "l", "finderAvatarClick19405", "", "clickAvatarScene", "", "feedId", "commentScene", "finderRole", "clickFinderUsername", "finderBackToTop19995", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "tabType", "finderChangeRoleClick", "roleBeforeSwitch", "finderClickEntrance19025", "contextId", "redDotId", "finderClickMoreReport", "scene", "finderClickTopic19186", "topic", "topicType", "topicFeedCount", "finderClickTopicFeedReport", "finderCommentFlagReport", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderCreateContactReport", "success", "", "addHeadIcon", "addSignature", "finderDistrictAlertClick", "username", "finderExposeFeedReport", "finderFavReport", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "finderLocationRequest19954", "context", "Landroid/content/Context;", "finderRealLikeAction19956", "finderRealLikeExpose19955", "exposeItems", "totalCount", "enterContextId", "finderRealLikeUserModify19957", "addUsernames", "delUsernames", "finderRedDot18948", "currUI", "redDotType", "showType", "redDotSubType", "count", "redDotWording", "currentTabType", "redDotBizType", "finderReportClickMention", "clickUsername", "finderReportEnterAtTimeline", "finderReportFav", "opType", "finderReportFlowClick19993", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "finderReportFollow", "finderUsername", "finderReportHitTabClick19998", "finderReportLikeAndComment", "actionType", "likeAction", "replyUsername", "userScene", "isShowRecWording", "finderReportMsgItemClick", "type", "isOverlap", "overlapCount", "finderReportOpenDrawer", "clickType", "finderReportPostMentionInfo", "finderReportSysMsgClick", "redDotCount", "finderReportTabChange", "fromTab", "toTab", "finderSaveNameCard", "finderSettingClickReport", "settingType", "finderShareFeedClick18944", "fromUser", "isCgiEnd", "finderShareFeedReport", "shareType", "receiver", "finderShareNameCardClickReport", "nameCardUser", "finderShareNameCardReport", "author", "followCount", "authType", "finderShareTopicClickReport", "finderShareTopicReport", "finderSubCommentExpand", "rootComment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "expandType", "finderTimelineMoreAction", "messageType", "isFloat", "finderTraceAction", "finderUnlikeFeedReport", "page", "unlikeType", "finderVoiceFlagReport", "getCurrentTabRedDotUI", "getFeedCigFetchTime", "getFinderFeedFetchTime", "getFinderItem", "getFinderItemSessionBuffer", "getReportNetTypeInt", "newUUID", "putFeedCgiFetchTime", "putFinderItemSessionBuffer", "sessionBuffer", "reportIDKeyVideoPlayError", "what", "reportPoiFilter19996", "poiText", "filterTextItems", "hasUnfoldBtn", "isUnfoldBtnClick", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "transformTabIndexToTabType", "tabIndex", "transformTabTypeToCommentScene", "plugin-finder_release"})
public final class b
{
  private static final LongSparseArray<Long> KUF;
  private static HashMap<String, String> KUG;
  private static final SparseArray<Long> KUH;
  public static final String TAG = "Finder.FinderReportLogic";
  private static final BigInteger qFp;
  public static final b qFq;
  
  static
  {
    AppMethodBeat.i(166595);
    qFq = new b();
    TAG = "Finder.FinderReportLogic";
    KUF = new LongSparseArray();
    KUG = new HashMap();
    KUH = new SparseArray();
    qFp = BigInteger.ONE.shiftLeft(64);
    AppMethodBeat.o(166595);
  }
  
  public static long BN(long paramLong)
  {
    AppMethodBeat.i(198786);
    Long localLong = (Long)KUF.get(paramLong);
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(198786);
      return paramLong;
    }
    AppMethodBeat.o(198786);
    return 0L;
  }
  
  public static void CM(int paramInt)
  {
    AppMethodBeat.i(166594);
    switch (paramInt)
    {
    default: 
      locala = h.qHu;
      h.a.lI(h.coh());
      AppMethodBeat.o(166594);
      return;
    case -1010: 
      locala = h.qHu;
      h.a.lI(h.cnU());
      AppMethodBeat.o(166594);
      return;
    case -1007: 
      locala = h.qHu;
      h.a.lI(h.cnV());
      AppMethodBeat.o(166594);
      return;
    case -1004: 
      locala = h.qHu;
      h.a.lI(h.cnW());
      AppMethodBeat.o(166594);
      return;
    case -10012: 
      locala = h.qHu;
      h.a.lI(h.cnX());
      AppMethodBeat.o(166594);
      return;
    case -10004: 
      locala = h.qHu;
      h.a.lI(h.cnY());
      AppMethodBeat.o(166594);
      return;
    case -21009: 
      locala = h.qHu;
      h.a.lI(h.cnZ());
      AppMethodBeat.o(166594);
      return;
    case -21020: 
      locala = h.qHu;
      h.a.lI(h.coa());
      AppMethodBeat.o(166594);
      return;
    case 404: 
      locala = h.qHu;
      h.a.lI(h.cob());
      AppMethodBeat.o(166594);
      return;
    case 403: 
      locala = h.qHu;
      h.a.lI(h.coc());
      AppMethodBeat.o(166594);
      return;
    case 503: 
      locala = h.qHu;
      h.a.lI(h.cod());
      AppMethodBeat.o(166594);
      return;
    case 502: 
      locala = h.qHu;
      h.a.lI(h.coe());
      AppMethodBeat.o(166594);
      return;
    case 416: 
      locala = h.qHu;
      h.a.lI(h.cof());
      AppMethodBeat.o(166594);
      return;
    }
    h.a locala = h.qHu;
    h.a.lI(h.cog());
    AppMethodBeat.o(166594);
  }
  
  public static void E(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166577);
    FinderItem localFinderItem = qh(paramLong);
    if (localFinderItem != null)
    {
      he localhe = new he();
      String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localhe.BJ(str1);
      localhe.CJ(com.tencent.mm.ad.c.ly(localFinderItem.getId()));
      localhe.mC(paramInt);
      localhe.cE(localFinderItem.getLikeCount());
      localhe.cR(localFinderItem.getCommentCount());
      localhe.dU(localFinderItem.getFriendLikeCount());
      localhe.lD(localFinderItem.getMediaType());
      localhe.CK("");
      localhe.ew(paramInt);
      localhe.aBj();
      a((com.tencent.mm.plugin.report.a)localhe);
      AppMethodBeat.o(166577);
      return;
    }
    AppMethodBeat.o(166577);
  }
  
  public static void F(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166580);
    FinderItem localFinderItem = qh(paramLong);
    if (localFinderItem != null)
    {
      ag localag = new ag();
      String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localag.hc((String)localObject);
      localag.du(paramInt);
      localObject = com.tencent.mm.plugin.finder.utils.h.qSR;
      localag.hd(d.n.n.h(com.tencent.mm.plugin.finder.utils.h.l(localFinderItem), ",", ";", false));
      localag.he("");
      localag.hf(qi(localFinderItem.getId()));
      localag.dv(localFinderItem.getFeedObject().likeCount);
      localag.aBj();
      a((com.tencent.mm.plugin.report.a)localag);
      AppMethodBeat.o(166580);
      return;
    }
    AppMethodBeat.o(166580);
  }
  
  public static void W(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(198802);
    al localal = new al();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localal.hx(str1);
    localal.dP(paramInt1);
    localal.dQ(paramInt2);
    localal.dR(paramInt3);
    localal.zr(paramInt4);
    localal.aBj();
    a((com.tencent.mm.plugin.report.a)localal);
    AppMethodBeat.o(198802);
  }
  
  public static void Zi(String paramString)
  {
    AppMethodBeat.i(166588);
    d.g.b.k.h(paramString, "username");
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    paramString = str + ',' + paramString;
    ad.i(TAG, "18973 ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.e.vIY.kvStat(18973, paramString);
    AppMethodBeat.o(166588);
  }
  
  public static void a(int paramInt1, int paramInt2, dzp paramdzp)
  {
    long l2 = 0L;
    AppMethodBeat.i(198807);
    d.g.b.k.h(paramdzp, "contextObj");
    hl localhl = new hl();
    long l1;
    if (paramInt1 > 0)
    {
      l1 = paramInt1;
      localhl.yj(l1);
      l1 = l2;
      if (paramInt2 > 0) {
        l1 = paramInt2;
      }
      localhl.yk(l1);
      localhl.yl(ce.asS());
      localhl.Zh(paramdzp.sessionId);
      localhl.Zk(paramdzp.qwV);
      localhl.Zj(paramdzp.KHW);
      localhl.ajr();
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localhl.aBj();
      a((com.tencent.mm.plugin.report.a)localhl);
      paramdzp = g.afB();
      d.g.b.k.g(paramdzp, "MMKernel.storage()");
      paramdzp.afk().set(ae.a.LBA, localhl.ahP());
      if (paramInt2 != 2)
      {
        paramdzp = g.afB();
        d.g.b.k.g(paramdzp, "MMKernel.storage()");
        paramdzp.afk().set(ae.a.LBB, localhl.ahP());
      }
      ad.i(TAG, "finderReportTabChange clickTabContextId [%s] toTab[%d]", new Object[] { localhl.ahP(), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(198807);
      return;
      l1 = 0L;
      break;
      paramdzp = g.ad(PluginFinder.class);
      d.g.b.k.g(paramdzp, "MMKernel.plugin(PluginFinder::class.java)");
      if (((PluginFinder)paramdzp).getRedDotManager().YV("TLFollow") != null)
      {
        localhl.ahR();
        continue;
        paramdzp = g.ad(PluginFinder.class);
        d.g.b.k.g(paramdzp, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)paramdzp).getRedDotManager().YV("TLRecommendTab") != null)
        {
          localhl.ahR();
          continue;
          paramdzp = g.ad(PluginFinder.class);
          d.g.b.k.g(paramdzp, "MMKernel.plugin(PluginFinder::class.java)");
          if (((PluginFinder)paramdzp).getRedDotManager().YV("TLMachineTab") != null)
          {
            localhl.ahR();
            continue;
            paramdzp = g.ad(PluginFinder.class);
            d.g.b.k.g(paramdzp, "MMKernel.plugin(PluginFinder::class.java)");
            if (((PluginFinder)paramdzp).getRedDotManager().YV("TLLbsTab") != null) {
              localhl.ahR();
            }
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    long l = 1L;
    AppMethodBeat.i(198801);
    d.g.b.k.h(paramString, "clickFinderUsername");
    aa localaa = new aa();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localaa.gw(str1);
    localaa.gz(qi(paramLong));
    localaa.ye(paramInt1);
    localaa.cI(paramInt2);
    switch (paramInt2)
    {
    default: 
      localaa.cF(2L);
    }
    for (;;)
    {
      localaa.yd(paramInt3);
      localaa.gx(paramString);
      localaa.gy(u.aqO());
      paramString = qh(paramLong);
      if (paramString != null)
      {
        localaa.cG(paramString.getLikeCount());
        localaa.cH(paramString.getCommentCount());
      }
      paramLong = l;
      if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
        paramLong = 0L;
      }
      localaa.yf(paramLong);
      localaa.aBj();
      a((com.tencent.mm.plugin.report.a)localaa);
      AppMethodBeat.o(198801);
      return;
      localaa.cF(1L);
    }
  }
  
  public static void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(166579);
    d.g.b.k.h(paramString1, "topic");
    d.g.b.k.h(paramString2, "receiver");
    ak localak = new ak();
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localak.ht((String)localObject);
    localak.dM(paramInt1);
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localak.dN(l);
      localObject = com.tencent.mm.plugin.finder.utils.h.qSR;
      localak.hu(d.n.n.h(com.tencent.mm.plugin.finder.utils.h.f(paramString1, paramInt2, paramLong), ",", ";", false));
      localak.hv("");
      localak.dO(paramLong);
      localak.hw(paramString2);
      localak.aBj();
      a((com.tencent.mm.plugin.report.a)localak);
      AppMethodBeat.o(166579);
      return;
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    AppMethodBeat.i(166587);
    Object localObject = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    localObject = new StringBuilder().append((String)localObject).append(',').append(paramInt).append(',');
    if (paramBoolean1)
    {
      paramInt = 1;
      localObject = ((StringBuilder)localObject).append(paramInt).append(',');
      if (!paramBoolean2) {
        break label149;
      }
      paramInt = 1;
      label78:
      localObject = ((StringBuilder)localObject).append(paramInt).append(',');
      if (!paramBoolean3) {
        break label154;
      }
    }
    label149:
    label154:
    for (paramInt = i;; paramInt = 0)
    {
      localObject = paramInt;
      ad.i(TAG, "18947 ".concat(String.valueOf(localObject)));
      com.tencent.mm.plugin.report.e.vIY.kvStat(18947, (String)localObject);
      AppMethodBeat.o(166587);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label78;
    }
  }
  
  public static void a(long paramLong, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(198791);
    d.g.b.k.h(paramString, "fromUser");
    hj localhj = new hj();
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localhj.Wb((String)localObject);
    localhj.ya(paramInt1);
    localhj.Vs();
    localhj.Wc(paramString);
    localhj.Wd(qi(paramLong));
    localhj.yc(paramInt2);
    paramString = qh(paramLong);
    if (paramString != null)
    {
      localhj.We(paramString.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.h.qSR;
      localhj.Wf(d.n.n.h(com.tencent.mm.plugin.finder.utils.h.l(paramString), ",", ";", false));
      localObject = (Iterable)paramString.getMediaList();
      paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        if (bt.isNullOrNil(((bmd)((Iterator)localObject).next()).coverUrl)) {}
        for (paramLong = 0L;; paramLong = 1L)
        {
          localhj.yb(paramLong);
          paramString.add(d.y.JfV);
          break;
        }
      }
    }
    localhj.aBj();
    a((com.tencent.mm.plugin.report.a)localhj);
    AppMethodBeat.o(198791);
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean, String paramString, dzp paramdzp)
  {
    AppMethodBeat.i(198792);
    d.g.b.k.h(paramString, "receiver");
    d.g.b.k.h(paramdzp, "contextObj");
    FinderItem localFinderItem = qh(paramLong);
    if (localFinderItem != null)
    {
      ac localac = new ac();
      String str2 = paramdzp.sessionId;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localac.gE(str1);
      localac.cJ(paramInt);
      if (paramBoolean) {}
      for (long l = 1L;; l = 2L)
      {
        localac.cK(l);
        localac.gF(qi(localFinderItem.getId()));
        localac.gG(localFinderItem.getFeedObject().username);
        localac.gH(paramString);
        localac.cL(localFinderItem.getLikeCount());
        localac.cM(localFinderItem.getCommentCount());
        localac.cN(localFinderItem.getFriendLikeCount());
        localac.gI("");
        localac.cO(localFinderItem.getMediaType());
        paramString = com.tencent.mm.plugin.finder.utils.h.qSR;
        localac.gJ(d.n.n.h(com.tencent.mm.plugin.finder.utils.h.l(localFinderItem), ",", ";", false));
        localac.gK("");
        localac.cP(paramdzp.qqE);
        str1 = paramdzp.KHW;
        paramString = str1;
        if (str1 == null) {
          paramString = "";
        }
        localac.aRM(paramString);
        str1 = paramdzp.qwV;
        paramString = str1;
        if (str1 == null) {
          paramString = "";
        }
        localac.aRN(paramString);
        localac.aRO(am(paramLong, paramdzp.qqE));
        localac.aBj();
        a((com.tencent.mm.plugin.report.a)localac);
        AppMethodBeat.o(198792);
        return;
      }
    }
    AppMethodBeat.o(198792);
  }
  
  public static void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198790);
    d.g.b.k.h(paramString, "topic");
    FinderItem localFinderItem = qh(paramLong);
    if (localFinderItem != null)
    {
      com.tencent.mm.g.b.a.aj localaj = new com.tencent.mm.g.b.a.aj();
      String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localaj.ho((String)localObject);
      localaj.hp("");
      localaj.dH(paramInt2);
      localaj.hq(qi(localFinderItem.getId()));
      localaj.dI(localFinderItem.getMediaType());
      localObject = com.tencent.mm.plugin.finder.utils.h.qSR;
      localaj.hr(d.n.n.h(com.tencent.mm.plugin.finder.utils.h.f(paramString, paramInt1, 0L), ",", ";", false));
      localaj.hs("");
      localaj.dJ(localFinderItem.getFeedObject().likeCount);
      localaj.dK(localFinderItem.getFeedObject().commentCount);
      localaj.dL(localFinderItem.getFeedObject().friendLikeCount);
      localaj.aBj();
      a((com.tencent.mm.plugin.report.a)localaj);
      AppMethodBeat.o(198790);
      return;
    }
    AppMethodBeat.o(198790);
  }
  
  public static void a(com.tencent.mm.plugin.finder.model.h paramh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178394);
    d.g.b.k.h(paramh, "rootComment");
    FinderItem localFinderItem = qh(paramh.qDA.field_feedId);
    if (localFinderItem != null)
    {
      z localz = new z();
      localz.cw(paramInt1);
      localz.cx(paramh.qDA.field_actionInfo.Dkk.levelTwoComment.size());
      String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localz.gr(str1);
      localz.gs(qi(localFinderItem.getId()));
      localz.gt(localFinderItem.getUserName());
      localz.cz(System.currentTimeMillis());
      localz.gu(paramh.qDA.getUsername());
      localz.cy(paramh.qDA.field_actionInfo.Dkk.likeCount);
      localz.gv(qi(paramh.bMs()));
      localz.cA(paramh.qDA.field_actionInfo.Dkk.expandCommentCount);
      switch (paramInt2)
      {
      default: 
        localz.cB(2L);
        if (((paramh.qDA.field_actionInfo.Dkk.displayFlag & 0x8) <= 0) && ((paramh.qDA.field_actionInfo.Dkk.displayFlag & 0x2) <= 0)) {
          break;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        localz.cC(paramInt1);
        localz.cD(paramInt2);
        localz.aBj();
        a((com.tencent.mm.plugin.report.a)localz);
        AppMethodBeat.o(178394);
        return;
        localz.cB(1L);
        break;
      }
    }
    AppMethodBeat.o(178394);
  }
  
  public static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(198813);
    d.g.b.k.h(parama, "struct");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.PW();
    d.g.b.k.g(parama, "struct.toShowString()");
    ad.i(str, d.n.n.h(parama, "\r\n", " ", false));
    AppMethodBeat.o(198813);
  }
  
  public static void a(dzp paramdzp, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198811);
    d.g.b.k.h(paramdzp, "contextObj");
    hf localhf = new hf();
    localhf.nc(paramdzp.qqE);
    localhf.EG(paramdzp.sessionId);
    localhf.EH(paramdzp.qwV);
    localhf.EI(paramdzp.KHW);
    localhf.nd(paramInt1);
    if (paramInt2 != 0)
    {
      paramdzp = com.tencent.mm.ui.component.a.LCX;
      if (!((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class)).ahP(paramInt2)) {
        break label131;
      }
    }
    label131:
    for (long l = 1L;; l = 0L)
    {
      localhf.qc(l);
      localhf.aBj();
      a((com.tencent.mm.plugin.report.a)localhf);
      AppMethodBeat.o(198811);
      return;
    }
  }
  
  public static void a(dzp paramdzp, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(198798);
    d.g.b.k.h(paramdzp, "contextObj");
    d.g.b.k.h(paramString, "replyUsername");
    Object localObject = qh(paramLong);
    if (localObject != null)
    {
      x localx = new x();
      localx.gg(paramdzp.sessionId);
      localx.gh("");
      localx.gi(qi(paramLong));
      localx.gj(((FinderItem)localObject).getUserName());
      localx.cj(paramInt1);
      localx.ck(paramInt2);
      localx.cl(paramInt3);
      localx.gk(paramString);
      localx.cm(paramInt4);
      localx.cn(((FinderItem)localObject).getLikeCount());
      localx.co(((FinderItem)localObject).getCommentCount());
      localx.cp(((FinderItem)localObject).getFriendLikeCount());
      localx.cq(((FinderItem)localObject).getMediaType());
      paramString = com.tencent.mm.plugin.finder.utils.h.qSR;
      localx.gl(d.n.n.h(com.tencent.mm.plugin.finder.utils.h.l((FinderItem)localObject), ",", ";", false));
      localx.gm("");
      localx.cr(paramdzp.qqE);
      if (d.g.b.k.g(((FinderItem)localObject).getUserName(), u.aqO()))
      {
        l = 1L;
        localx.vB(l);
        if (!paramBoolean) {
          break label356;
        }
      }
      label356:
      for (long l = 1L;; l = 0L)
      {
        localx.xc(l);
        localObject = paramdzp.qwV;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localx.NG(paramString);
        localObject = paramdzp.KHW;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localx.NH(paramString);
        localx.NI(am(paramLong, paramdzp.qqE));
        localx.aBj();
        a((com.tencent.mm.plugin.report.a)localx);
        AppMethodBeat.o(198798);
        return;
        l = 0L;
        break;
      }
    }
    AppMethodBeat.o(198798);
  }
  
  public static void a(dzp paramdzp, long paramLong, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(198808);
    d.g.b.k.h(paramdzp, "contextObj");
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    FinderItem localFinderItem = qh(paramLong);
    if (localFinderItem != null)
    {
      hm localhm = new hm();
      localhm.ym(paramdzp.qqE);
      localhm.Zx(paramdzp.sessionId);
      localhm.Zz(paramdzp.qwV);
      localhm.ZA(paramdzp.KHW);
      localhm.ZF(com.tencent.mm.ad.c.ly(paramLong));
      localhm.yo(ce.asS());
      Object localObject = paramdzp.LiO;
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
      localhm.awx((String)localObject);
      localhm.yp(localFinderItem.getMediaType());
      localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
      localObject = com.tencent.mm.plugin.finder.utils.i.fWg().toString();
      d.g.b.k.g(localObject, "FinderUtil.getScreenInfo().toString()");
      localhm.awz(d.n.n.h((String)localObject, ",", ";", false));
      localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
      paramRecyclerView = com.tencent.mm.plugin.finder.utils.i.B(paramRecyclerView).toString();
      d.g.b.k.g(paramRecyclerView, "FinderUtil.getCurrentScr…(recyclerView).toString()");
      localhm.ZO(d.n.n.h(paramRecyclerView, ",", ";", false));
      localhm.yn(aho(paramdzp.qqE));
      localhm.awy(am(paramLong, paramdzp.qqE));
      localhm.aBj();
      a((com.tencent.mm.plugin.report.a)localhm);
      AppMethodBeat.o(198808);
      return;
    }
    AppMethodBeat.o(198808);
  }
  
  public static void a(dzp paramdzp, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198794);
    d.g.b.k.h(paramdzp, "contextObj");
    d.g.b.k.h(paramString1, "poiText");
    d.g.b.k.h(paramString2, "filterTextItems");
    hz localhz = new hz();
    localhz.aSD(paramdzp.sessionId);
    localhz.aSE(paramdzp.qwV);
    localhz.aSF(paramdzp.KHW);
    localhz.zs(paramdzp.LiL);
    localhz.aSG(paramString1);
    localhz.aSH(paramString2);
    localhz.zt(paramInt1);
    localhz.zu(paramInt2);
    switch (paramdzp.qqE)
    {
    }
    for (;;)
    {
      localhz.zw(paramdzp.qqE);
      localhz.aBj();
      a((com.tencent.mm.plugin.report.a)localhz);
      AppMethodBeat.o(198794);
      return;
      localhz.zv(2L);
      continue;
      localhz.zv(1L);
    }
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, long paramLong, dzp paramdzp, int paramInt6)
  {
    AppMethodBeat.i(198796);
    d.g.b.k.h(paramString1, "currUI");
    d.g.b.k.h(paramString2, "redDotId");
    d.g.b.k.h(paramString3, "redDotWording");
    ah localah = new ah();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localah.hg(str1);
    localah.hh(paramString1);
    localah.dw(paramInt1);
    localah.dx(paramInt2);
    localah.dz(paramInt3);
    long l;
    if (com.tencent.mm.sdk.platformtools.h.DEBUG)
    {
      l = 0L;
      localah.dA(l);
      localah.dy(paramInt4);
      localah.hi(paramString2);
      localah.dB(paramInt5);
      localah.hj(paramString3);
      localah.hk(qi(paramLong));
      if (paramdzp != null)
      {
        paramString2 = paramdzp.qwV;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localah.hl(paramString1);
      if (paramdzp != null)
      {
        paramString2 = paramdzp.KHW;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localah.aSB(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUw()) {
        break label343;
      }
      paramLong = 2L;
      label246:
      localah.zl(paramLong);
      paramString1 = g.ad(com.tencent.mm.plugin.i.a.j.class);
      d.g.b.k.g(paramString1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramString1 = ((com.tencent.mm.plugin.i.a.j)paramString1).getRedDotManager();
      d.g.b.k.g(paramString1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!paramString1.fSK()) {
        break label349;
      }
    }
    label343:
    label349:
    for (paramLong = 1L;; paramLong = 2L)
    {
      localah.zm(paramLong);
      localah.zn(paramInt6);
      localah.aBj();
      a((com.tencent.mm.plugin.report.a)localah);
      AppMethodBeat.o(198796);
      return;
      l = 2L;
      break;
      paramLong = 1L;
      break label246;
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    AppMethodBeat.i(198795);
    d.g.b.k.h(paramString1, "currUI");
    d.g.b.k.h(paramString2, "redDotId");
    d.g.b.k.h(paramString3, "redDotWording");
    d.g.b.k.h(paramString4, "contextId");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    int j;
    int i;
    if (!com.tencent.mm.plugin.finder.storage.b.fUw()) {
      switch (paramInt1)
      {
      case 0: 
      case 6: 
      default: 
        AppMethodBeat.o(198795);
        return;
      case -1: 
        paramInt1 = 2;
        j = 1;
        i = 6;
      }
    }
    for (;;)
    {
      localObject = new dzp();
      ((dzp)localObject).qwV = paramString4;
      ((dzp)localObject).KHW = "";
      a(paramString1, paramInt1, paramInt2, i, j, 0, paramString2, paramString3, paramLong, (dzp)localObject, 0, 1024);
      AppMethodBeat.o(198795);
      return;
      paramInt1 = 1;
      j = 1;
      i = 3;
      continue;
      paramInt1 = 1;
      j = 2;
      i = 3;
      continue;
      paramInt1 = 3;
      j = 1;
      i = 4;
      continue;
      paramInt1 = 3;
      j = 2;
      i = 4;
      continue;
      paramInt1 = 1;
      j = 2;
      i = 1;
      continue;
      paramInt1 = 7;
      j = 0;
      i = 4;
      continue;
      paramInt1 = 8;
      j = 0;
      i = 3;
      continue;
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(198795);
        return;
      case -1: 
        paramInt1 = 2;
        j = 1;
        i = 1;
        break;
      case 1: 
        paramInt1 = 5;
        j = 0;
        i = 3;
        break;
      case 2: 
        paramInt1 = 1;
        j = 0;
        i = 3;
        break;
      case 5: 
        paramInt1 = 1;
        j = 0;
        i = 1;
        break;
      case 8: 
        paramInt1 = 7;
        j = 0;
        i = 4;
        break;
      case 7: 
        paramInt1 = 8;
        j = 0;
        i = 3;
        break;
      case 1003: 
        paramInt1 = 3;
        j = 1;
        i = 3;
        break;
      case 1004: 
        paramInt1 = 3;
        j = 2;
        i = 3;
        break;
      case 1001: 
        paramInt1 = 6;
        j = 0;
        i = 1;
      }
    }
  }
  
  public static void aS(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(198810);
    d.g.b.k.h(paramContext, "context");
    hq localhq = new hq();
    Object localObject = FinderReporterUIC.Ljl;
    paramContext = FinderReporterUIC.a.lB(paramContext);
    if (paramContext != null) {
      localhq.aRZ(paramContext.sessionId);
    }
    for (;;)
    {
      localhq.yM(paramInt);
      localhq.aBj();
      a((com.tencent.mm.plugin.report.a)localhq);
      AppMethodBeat.o(198810);
      return;
      localObject = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      localhq.aRZ(paramContext);
    }
  }
  
  public static void aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(198805);
    hr localhr = new hr();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localhr.aSa(str1);
    localhr.yN(paramInt1);
    localhr.yO(paramInt2);
    localhr.yP(paramInt3);
    localhr.aBj();
    a((com.tencent.mm.plugin.report.a)localhr);
    AppMethodBeat.o(198805);
  }
  
  public static long aho(int paramInt)
  {
    AppMethodBeat.i(198788);
    Long localLong = (Long)KUH.get(paramInt);
    if (localLong != null)
    {
      long l = localLong.longValue();
      AppMethodBeat.o(198788);
      return l;
    }
    AppMethodBeat.o(198788);
    return 0L;
  }
  
  public static void ahp(int paramInt)
  {
    AppMethodBeat.i(198789);
    KUH.put(paramInt, Long.valueOf(ce.asS()));
    AppMethodBeat.o(198789);
  }
  
  public static int ahq(int paramInt)
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
  
  public static String am(long paramLong, int paramInt)
  {
    AppMethodBeat.i(198785);
    String str2 = (String)KUG.get(paramLong + '_' + paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(198785);
    return str1;
  }
  
  public static void b(int paramInt, dzp paramdzp)
  {
    AppMethodBeat.i(198793);
    d.g.b.k.h(paramdzp, "contextObj");
    hp localhp = new hp();
    localhp.yC(paramdzp.qqE);
    localhp.aRP(paramdzp.sessionId);
    localhp.aRQ(paramdzp.qwV);
    localhp.aRR(paramdzp.KHW);
    localhp.aRP(paramdzp.sessionId);
    localhp.yE(ce.asS());
    localhp.yD(paramInt);
    localhp.aBj();
    a((com.tencent.mm.plugin.report.a)localhp);
    AppMethodBeat.o(198793);
  }
  
  public static void b(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166585);
    d.g.b.k.h(paramFinderObject, "finderObject");
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    paramFinderObject = str + ',' + 1 + ',' + qi(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.recommendType;
    ad.i(TAG, "18953 ".concat(String.valueOf(paramFinderObject)));
    com.tencent.mm.plugin.report.e.vIY.kvStat(18953, paramFinderObject);
    AppMethodBeat.o(166585);
  }
  
  public static void b(dzp paramdzp, long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(198809);
    d.g.b.k.h(paramdzp, "contextObj");
    d.g.b.k.h(paramString, "username");
    if (qh(paramLong) != null)
    {
      hu localhu = new hu();
      localhu.zg(paramdzp.qqE);
      localhu.aSn(paramdzp.qwV);
      localhu.aSo(paramdzp.KHW);
      localhu.aSm(paramdzp.sessionId);
      localhu.aSl(com.tencent.mm.ad.c.ly(paramLong));
      localhu.aSk(paramString);
      localhu.zf(paramInt);
      localhu.aBj();
      a((com.tencent.mm.plugin.report.a)localhu);
    }
    AppMethodBeat.o(198809);
  }
  
  public static void c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166586);
    d.g.b.k.h(paramFinderItem, "finderItem");
    FinderObject localFinderObject = paramFinderItem.getFinderObject();
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    paramFinderItem = str + ',' + qi(localFinderObject.id) + ',' + localFinderObject.username + ',' + paramFinderItem.getMediaType() + ',' + localFinderObject.recommendType + ',' + localFinderObject.likeCount + ',' + localFinderObject.commentCount + ',' + localFinderObject.friendLikeCount;
    ad.i(TAG, "18950 ".concat(String.valueOf(paramFinderItem)));
    com.tencent.mm.plugin.report.e.vIY.kvStat(18950, paramFinderItem);
    AppMethodBeat.o(166586);
  }
  
  public static void cV(String paramString, int paramInt)
  {
    AppMethodBeat.i(178395);
    d.g.b.k.h(paramString, "username");
    ae localae = new ae();
    String str2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localae.gS(str1);
    localae.gR(paramString);
    localae.de(paramInt);
    localae.aBj();
    a((com.tencent.mm.plugin.report.a)localae);
    AppMethodBeat.o(178395);
  }
  
  public static void d(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(198800);
    FinderItem localFinderItem = qh(paramLong);
    if (localFinderItem != null)
    {
      com.tencent.mm.g.b.a.y localy = new com.tencent.mm.g.b.a.y();
      String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localy.gn((String)localObject);
      localy.go("");
      localy.gp(qi(paramLong));
      localy.gq(localFinderItem.getUserName());
      localy.cs(localFinderItem.getLikeCount());
      localy.ct(localFinderItem.getCommentCount());
      localy.cu(localFinderItem.getFriendLikeCount());
      localy.is(paramInt2);
      localy.cv(paramInt1);
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUp()) {}
      for (paramLong = 1L;; paramLong = 0L)
      {
        localy.xC(paramLong);
        localy.aBj();
        a((com.tencent.mm.plugin.report.a)localy);
        AppMethodBeat.o(198800);
        return;
      }
    }
    AppMethodBeat.o(198800);
  }
  
  public static void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(166582);
    d.g.b.k.h(paramString1, "fromUser");
    d.g.b.k.h(paramString2, "topic");
    Object localObject = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    paramString1 = new StringBuilder().append((String)localObject).append(',').append(paramInt1).append(",3,").append(paramString1).append(",0,,");
    localObject = com.tencent.mm.plugin.finder.utils.h.qSR;
    paramString1 = com.tencent.mm.plugin.finder.utils.h.da(paramString2, paramInt2);
    ad.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.vIY.kvStat(18944, paramString1);
    AppMethodBeat.o(166582);
  }
  
  public static void fQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178396);
    d.g.b.k.h(paramString1, "contextId");
    d.g.b.k.h(paramString2, "action");
    am localam = new am();
    localam.hz(paramString1);
    localam.hy(paramString2);
    localam.dS(ce.asS());
    paramString2 = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localam.hA(paramString1);
    if (com.tencent.mm.sdk.platformtools.h.DEBUG) {}
    for (long l = 0L;; l = 1L)
    {
      localam.dT(l);
      localam.aBj();
      a((com.tencent.mm.plugin.report.a)localam);
      AppMethodBeat.o(178396);
      return;
    }
  }
  
  public static String fTV()
  {
    AppMethodBeat.i(198804);
    String str = UUID.randomUUID().toString();
    d.g.b.k.g(str, "UUID.randomUUID().toString()");
    AppMethodBeat.o(198804);
    return str;
  }
  
  public static int fTW()
  {
    AppMethodBeat.i(198815);
    int i = 0;
    if (ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(198815);
      return i;
      if (ay.is2G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
        i = 2;
      } else if (ay.is3G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
        i = 3;
      } else if (ay.is4G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
        i = 4;
      } else if (ay.is5G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
        i = 5;
      }
    }
  }
  
  public static void j(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(198787);
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
          ((Map)KUG).put(paramLong + '_' + paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      KUF.put(paramLong, Long.valueOf(ce.asS()));
      AppMethodBeat.o(198787);
      return;
      ((Map)KUG).put(paramLong + "_6", paramString);
      ((Map)KUG).put(paramLong + "_23", paramString);
      continue;
      ((Map)KUG).put(paramLong + "_9", paramString);
      ((Map)KUG).put(paramLong + "_22", paramString);
      continue;
      ((Map)KUG).put(paramLong + "_15", paramString);
      ((Map)KUG).put(paramLong + "_16", paramString);
      continue;
      ((Map)KUG).put(paramLong + "_26", paramString);
      ((Map)KUG).put(paramLong + "_27", paramString);
      continue;
      ((Map)KUG).put(paramLong + "_24", paramString);
      ((Map)KUG).put(paramLong + "_21", paramString);
      continue;
      ((Map)KUG).put(paramLong + "_32", paramString);
      ((Map)KUG).put(paramLong + "_1", paramString);
      continue;
      ((Map)KUG).put(paramLong + "_33", paramString);
      ((Map)KUG).put(paramLong + "_8", paramString);
    }
  }
  
  public static void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166584);
    d.g.b.k.h(paramString1, "author");
    d.g.b.k.h(paramString2, "receiver");
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    paramString1 = str + ',' + paramString1 + ',' + paramString2 + ',' + 0 + ',' + paramInt1 + ',' + paramInt2;
    ad.i(TAG, "18949 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.vIY.kvStat(18949, paramString1);
    AppMethodBeat.o(166584);
  }
  
  public static void la(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198806);
    hx localhx = new hx();
    localhx.zo(paramInt1);
    localhx.zp(paramInt2);
    localhx.aBj();
    a((com.tencent.mm.plugin.report.a)localhx);
    AppMethodBeat.o(198806);
  }
  
  public static String lx(Context paramContext)
  {
    AppMethodBeat.i(198814);
    d.g.b.k.h(paramContext, "context");
    int i = 0;
    if ((paramContext instanceof MMActivity))
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
      i = ((FinderHomeUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderHomeUIC.class)).fXm();
    }
    switch (i)
    {
    default: 
      paramContext = "2";
    }
    for (;;)
    {
      AppMethodBeat.o(198814);
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
  
  public static void n(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(198803);
    d.g.b.k.h(paramFinderItem, "finderItem");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null)
    {
      ht localht = new ht();
      localht.aSc(qi(paramFinderItem.getId()));
      localht.aSd(((FinderFeedReportObject)localObject).sessionId);
      localht.aSe(paramFinderItem.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.n.LaC;
      localht.aSf(d.n.n.h(com.tencent.mm.plugin.finder.utils.n.o(paramFinderItem), ",", ";", false));
      localht.aBj();
      a((com.tencent.mm.plugin.report.a)localht);
      AppMethodBeat.o(198803);
      return;
    }
    AppMethodBeat.o(198803);
  }
  
  public static FinderItem qh(long paramLong)
  {
    AppMethodBeat.i(166576);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.b.qKl;
    Object localObject2 = b.a.qC(paramLong);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = com.tencent.mm.plugin.finder.search.i.qIB;
      localObject1 = (FinderItem)com.tencent.mm.plugin.finder.search.i.cow().get(Long.valueOf(paramLong));
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = FinderTopicFeedUI.qBH;
      localObject2 = (FinderItem)FinderTopicFeedUI.cmQ().get(Long.valueOf(paramLong));
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = FinderAtTimelineUI.KRb;
      localObject1 = (FinderItem)FinderAtTimelineUI.cmQ().get(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(166576);
    return localObject1;
  }
  
  public static String qi(long paramLong)
  {
    AppMethodBeat.i(166591);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(qFp);
    }
    localObject = ((BigInteger)localObject).toString();
    d.g.b.k.g(localObject, "b.toString()");
    AppMethodBeat.o(166591);
    return localObject;
  }
  
  public static void y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(166581);
    d.g.b.k.h(paramString1, "fromUser");
    d.g.b.k.h(paramString2, "nameCardUser");
    String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
    paramString1 = str + ',' + paramInt + ",2," + paramString1 + ",0," + paramString2;
    ad.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.vIY.kvStat(18944, paramString1);
    AppMethodBeat.o(166581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.b
 * JD-Core Version:    0.7.0.1
 */