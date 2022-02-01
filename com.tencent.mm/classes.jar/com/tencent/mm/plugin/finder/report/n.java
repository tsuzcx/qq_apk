package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.aq;
import com.tencent.mm.f.b.a.ar;
import com.tencent.mm.f.b.a.bl;
import com.tencent.mm.f.b.a.bn;
import com.tencent.mm.f.b.a.bo;
import com.tencent.mm.f.b.a.bq;
import com.tencent.mm.f.b.a.bv;
import com.tencent.mm.f.b.a.ca;
import com.tencent.mm.f.b.a.cb;
import com.tencent.mm.f.b.a.cc;
import com.tencent.mm.f.b.a.cg;
import com.tencent.mm.f.b.a.ci;
import com.tencent.mm.f.b.a.cn;
import com.tencent.mm.f.b.a.cq;
import com.tencent.mm.f.b.a.ct;
import com.tencent.mm.f.b.a.cw;
import com.tencent.mm.f.b.a.cy;
import com.tencent.mm.f.b.a.cz;
import com.tencent.mm.f.b.a.dj;
import com.tencent.mm.f.b.a.dm;
import com.tencent.mm.f.b.a.dn;
import com.tencent.mm.f.b.a.dq;
import com.tencent.mm.f.b.a.dr;
import com.tencent.mm.f.b.a.ds;
import com.tencent.mm.f.b.a.dw;
import com.tencent.mm.f.b.a.dz;
import com.tencent.mm.f.b.a.ef;
import com.tencent.mm.f.b.a.eg;
import com.tencent.mm.f.b.a.eh;
import com.tencent.mm.f.b.a.ei;
import com.tencent.mm.f.b.a.em;
import com.tencent.mm.f.b.a.eo;
import com.tencent.mm.f.b.a.eq;
import com.tencent.mm.f.b.a.er;
import com.tencent.mm.f.b.a.es;
import com.tencent.mm.f.b.a.et;
import com.tencent.mm.f.b.a.eu;
import com.tencent.mm.f.b.a.ew;
import com.tencent.mm.f.b.a.fc;
import com.tencent.mm.f.b.a.fd;
import com.tencent.mm.f.b.a.fe;
import com.tencent.mm.f.b.a.ff;
import com.tencent.mm.f.b.a.fh;
import com.tencent.mm.f.b.a.fi;
import com.tencent.mm.f.b.a.fk;
import com.tencent.mm.f.b.a.hs;
import com.tencent.mm.f.b.a.ir;
import com.tencent.mm.f.b.a.iz;
import com.tencent.mm.f.b.a.ok;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.utils.ah;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.b.c.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.u;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.NetworkUtil;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TWO_64", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFinderFeedCgiFetchTimeMap", "()Landroid/util/SparseArray;", "finderFeedFetchTimeMap", "Landroid/util/LongSparseArray;", "getFinderFeedFetchTimeMap", "()Landroid/util/LongSparseArray;", "megaVideoFeedFetchTimeMap", "getMegaVideoFeedFetchTimeMap", "searchSessionId", "getSearchSessionId", "setSearchSessionId", "(Ljava/lang/String;)V", "sessionBufferMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/report/SessionBufferEx;", "Lkotlin/collections/HashMap;", "getSessionBufferMap", "()Ljava/util/HashMap;", "setSessionBufferMap", "(Ljava/util/HashMap;)V", "asUnsignedDecimalString", "l", "commentExposeReport", "", "sessionId", "contextId", "clickTabContextId", "commentScene", "", "feedId", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "finderAvatarClick19405", "clickAvatarScene", "finderRole", "clickFinderUsername", "finderBackToTop19995", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "tabType", "finderChangeRoleClick", "roleBeforeSwitch", "finderClickEntrance19025", "redDotId", "finderClickMoreReport", "scene", "finderClickTopic19186", "topic", "topicType", "topicFeedCount", "finderClickTopicFeedReport", "finderCommentFlagReport", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderCommonExposeReport", "eventCode", "eid", "udfKv", "finderCreateContactReport", "success", "hadAvatar", "addSignature", "", "hadWechatCity", "hadWechatSex", "createScene", "wxProfile", "changeName", "finderDistrictAlertClick", "username", "finderExposeFeedReport", "finderFavReport", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "finderHotSearchReport", "itemId", "reasonId", "position", "accountType", "actionType", "finderLocationRequest19954", "context", "Landroid/content/Context;", "finderMegaVideoShareReport", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "shareType", "forwardResult", "receiver", "forwardUsrCount", "finderMessageModReport", "identity", "notificationType", "finderRealLikeAction19956", "finderRealLikeExpose19955", "exposeItems", "totalCount", "enterContextId", "finderRealLikeUserModify19957", "addUsernames", "delUsernames", "enterCount", "finderRedDot18948", "currUI", "redDotType", "showType", "redDotSubType", "count", "redDotWording", "currentTabType", "autoClick", "report_ext_info", "redDotBizType", "finderRedDotRevoke20223", "ctrType", "tipsId", "revokeId", "revokeStatus", "finderReportClickMention", "clickUsername", "finderReportEnterAtTimeline", "finderReportFav", "opType", "finderReportFlowClick19993", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "finderReportFollow", "finderUsername", "finderReportHitTabClick19998", "messageType", "index", "finderReportLikeAndComment", "likeAction", "replyUsername", "userScene", "isShowRecWording", "isPrivateAccount", "feedContentType", "megaVideoId", "finderReportMsgItemClick", "type", "isOverlap", "overlapCount", "finderReportOpenDrawer", "clickType", "finderReportPostMentionInfo", "finderReportSysMsgClick", "redDotCount", "finderReportTabChange", "fromTab", "toTab", "source", "finderSaveNameCard", "finderSearchActionReport", "requestId", "query", "searchScene", "searchType", "searchResultType", "accountIsNull", "feedIsNull", "finderSearchClickReport", "requestType", "itemType", "finderSearchNewClickReport", "finderSelfUIEventReport", "enterTimeStamp", "redDotExistOnEnter", "eventType", "bannerType", "isHaveRedDot", "msgCnt", "finderSettingClickReport", "settingType", "finderSettingInfoEventReport", "hasReddot", "finderShareActivityReport", "forwardType", "activityId", "finderShareAlbumClickReport", "fromUser", "cardId", "finderShareAlbumReport", "finderShareFeedClick18944", "cardType", "isCgiEnd", "uiType", "finderShareFeedReport", "localFeedItem", "finderShareNameCardClickReport", "nameCardUser", "finderShareNameCardReport", "author", "followCount", "authType", "finderShareTopicClickReport", "finderShareTopicReport", "finderSubCommentExpand", "rootComment", "expandType", "finderTimelineMoreAction", "isFloat", "finderTraceAction", "finderUnlikeFeedReport", "page", "unlikeType", "finderVoiceFlagReport", "getCurrentTabRedDotUI", "getFeedCigFetchTime", "getFinderFeedFetchTime", "getFinderItem", "getFinderItemSessionBuffer", "getFinderItemSessionBufferEx", "getMegaVideoFetchTime", "getMegaVideoItem", "getMegaVideoItemSessionBuffer", "getReportNetTypeInt", "getStr", "ids", "", "split", "isMegaVideoComment", "newUUID", "optWxSubRedDotType", "commentCount", "likeCount", "likeLikeCount", "recommendLikeCount", "putFeedCgiFetchTime", "putFinderItemSessionBuffer", "sessionBuffer", "clientRecTime", "putMegaVideoItemSessionBuffer", "recordFinderObjectRevTime", "report20044", "isExplose", "clickAction", "isCollapse", "isTopic", "report20698", "profileUsername", "time", "profileType", "profileView", "report20699", "fromUsername", "report20717", "tabContextId", "actionScene", "report20849", "msgType", "msgId", "report21077", "outcome", "(Landroid/content/Context;IILjava/lang/Integer;)V", "report21172", "userName", "profileBizUin", "appId", "report21188", "isFirstOpen", "clickscene", "clickId", "preWarmPath", "ispresend", "ispreload", "liveid", "finderid", "shopwindowid", "sessionid", "report21206", "isSelf", "eventTarget", "report21235", "appuin", "report21237", "prewarmstartime", "prewarmendtime", "appVersion", "report21313", "liveRole", "shop", "prerenderType", "postTime", "shareLiveTime", "joinLiveTime", "enterRoomTime", "liveStates", "uiStates", "statistics", "cgiErrcode", "cgiErrtype", "cgiErrmsg", "liveEventCode", "liveEventSubCode", "liveEventMsg", "extra", "snn", "networkQuality", "report21345", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JLjava/lang/Integer;)V", "report21726", "report21834", "enterMs", "exitMs", "reason", "report21837", "setting", "report21851", "report21923", "target", "report22116", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Action;", "dynamicState", "poiClassifyId", "poiDetail", "sourceId", "duration", "report22265", "currentObj", "resId", "report22623", "newIds", "oldIds", "report22657", "report22955", "iconType", "curPos", "mutualAdInfo", "reportDailyPaper", "paperId", "paperWording", "clickable", "reportExposeHotCard20585", "exposeFeedId", "posId", "reportFinderAdMutual", "isViewable", "isClick", "data", "Lcom/tencent/mm/json/JSONObject;", "adW", "adH", "clickPos", "posX", "posY", "adPosId", "reportIDKeyVideoPlayError", "what", "reportJumpHotCard20586", "actionFeedId", "actionFeedIndex", "totalFeedId", "reportPoiFilter19996", "poiText", "filterTextItems", "hasUnfoldBtn", "isUnfoldBtnClick", "reportTeensTips21875", "reportTextStatus21875", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "transformCommentSceneToTabType", "transformTabIndexToTabType", "tabIndex", "transformTabTypeToCommentScene", "updateFeedSessionBuffer", "plugin-finder_release"})
public final class n
{
  public static final String TAG = "Finder.FinderReportLogic";
  private static final BigInteger TWO_64;
  private static String zWA;
  private static final LongSparseArray<Long> zWB;
  public static HashMap<String, ao> zWC;
  public static final LongSparseArray<Long> zWD;
  private static final SparseArray<Long> zWE;
  public static final n zWF;
  
  static
  {
    AppMethodBeat.i(166595);
    zWF = new n();
    TAG = "Finder.FinderReportLogic";
    zWA = "";
    zWB = new LongSparseArray();
    zWC = new HashMap();
    zWD = new LongSparseArray();
    zWE = new SparseArray();
    TWO_64 = BigInteger.ONE.shiftLeft(64);
    AppMethodBeat.o(166595);
  }
  
  public static void C(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(166581);
    p.k(paramString1, "fromUser");
    p.k(paramString2, "nameCardUser");
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramString1 = str + ',' + paramInt + ",2," + paramString1 + ",0," + paramString2;
    Log.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.f.Iyx.kvStat(18944, paramString1);
    AppMethodBeat.o(166581);
  }
  
  public static FinderItem Hc(long paramLong)
  {
    AppMethodBeat.i(166576);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.e.AmW;
    Object localObject2 = e.a.MH(paramLong);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = com.tencent.mm.plugin.finder.search.j.Acs;
      localObject1 = (FinderItem)com.tencent.mm.plugin.finder.search.j.dRi().get(Long.valueOf(paramLong));
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = FinderTopicFeedUI.xTd;
      localObject2 = (FinderItem)FinderTopicFeedUI.duS().get(Long.valueOf(paramLong));
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = FinderAtTimelineUI.xLF;
      localObject1 = (FinderItem)FinderAtTimelineUI.duS().get(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(166576);
    return localObject1;
  }
  
  public static bs Mm(long paramLong)
  {
    AppMethodBeat.i(219978);
    Object localObject = com.tencent.mm.plugin.finder.storage.data.e.AmW;
    localObject = e.a.MM(paramLong);
    if (localObject != null)
    {
      localObject = new bs((FinderObject)localObject);
      AppMethodBeat.o(219978);
      return localObject;
    }
    AppMethodBeat.o(219978);
    return null;
  }
  
  public static long Mn(long paramLong)
  {
    AppMethodBeat.i(219984);
    Long localLong = (Long)zWB.get(paramLong);
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(219984);
      return paramLong;
    }
    AppMethodBeat.o(219984);
    return 0L;
  }
  
  public static long Mo(long paramLong)
  {
    AppMethodBeat.i(219985);
    Long localLong = (Long)zWD.get(paramLong);
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(219985);
      return paramLong;
    }
    AppMethodBeat.o(219985);
    return 0L;
  }
  
  public static String Mp(long paramLong)
  {
    AppMethodBeat.i(166591);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(TWO_64);
    }
    localObject = ((BigInteger)localObject).toString();
    p.j(localObject, "b.toString()");
    AppMethodBeat.o(166591);
    return localObject;
  }
  
  public static String N(long paramLong, int paramInt)
  {
    AppMethodBeat.i(219983);
    Object localObject = (ao)zWC.get(paramLong + '_' + paramInt);
    if (localObject != null)
    {
      localObject = ((ao)localObject).zZQ;
      if (localObject != null)
      {
        String str = ((bft)localObject).SHp;
        localObject = str;
        if (str != null) {
          break label70;
        }
      }
    }
    localObject = "";
    label70:
    AppMethodBeat.o(219983);
    return localObject;
  }
  
  public static void O(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166577);
    FinderItem localFinderItem = Hc(paramLong);
    if (localFinderItem != null)
    {
      bl localbl = new bl();
      String str2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localbl.jR(str1);
      localbl.jS(com.tencent.mm.ae.d.Fw(localFinderItem.getId()));
      localbl.dI(paramInt);
      localbl.dD(localFinderItem.getLikeCount());
      localbl.dE(localFinderItem.getCommentCount());
      localbl.dF(localFinderItem.getFriendLikeCount());
      localbl.dH(localFinderItem.getMediaType());
      localbl.jT("");
      localbl.dG(paramInt);
      localbl.bpa();
      a((com.tencent.mm.plugin.report.a)localbl);
      AppMethodBeat.o(166577);
      return;
    }
    AppMethodBeat.o(166577);
  }
  
  public static void P(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166580);
    FinderItem localFinderItem = Hc(paramLong);
    if (localFinderItem != null)
    {
      eg localeg = new eg();
      String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localeg.rS((String)localObject);
      localeg.lm(paramInt);
      localObject = ag.AFH;
      localeg.rT(kotlin.n.n.l(ag.A(localFinderItem), ",", ";", false));
      localeg.rU("");
      localeg.rV(Mp(localFinderItem.getId()));
      localeg.ln(localFinderItem.getFeedObject().likeCount);
      localeg.bpa();
      a((com.tencent.mm.plugin.report.a)localeg);
      AppMethodBeat.o(166580);
      return;
    }
    AppMethodBeat.o(166580);
  }
  
  public static int PA(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 0;
    case 17: 
      return 3;
    case 18: 
      return 1;
    case 15: 
      return 2;
    }
    return 4;
  }
  
  public static void Px(int paramInt)
  {
    AppMethodBeat.i(220001);
    zWE.put(paramInt, Long.valueOf(com.tencent.mm.model.cm.bfE()));
    AppMethodBeat.o(220001);
  }
  
  public static void Py(int paramInt)
  {
    AppMethodBeat.i(166594);
    switch (paramInt)
    {
    default: 
      locala = ab.zZn;
      ab.a.rE(ab.dQv());
      AppMethodBeat.o(166594);
      return;
    case -1010: 
      locala = ab.zZn;
      ab.a.rE(ab.dQi());
      AppMethodBeat.o(166594);
      return;
    case -1007: 
      locala = ab.zZn;
      ab.a.rE(ab.dQj());
      AppMethodBeat.o(166594);
      return;
    case -1004: 
      locala = ab.zZn;
      ab.a.rE(ab.dQk());
      AppMethodBeat.o(166594);
      return;
    case -10012: 
      locala = ab.zZn;
      ab.a.rE(ab.dQl());
      AppMethodBeat.o(166594);
      return;
    case -10004: 
      locala = ab.zZn;
      ab.a.rE(ab.dQm());
      AppMethodBeat.o(166594);
      return;
    case -21009: 
      locala = ab.zZn;
      ab.a.rE(ab.dQn());
      AppMethodBeat.o(166594);
      return;
    case -21020: 
      locala = ab.zZn;
      ab.a.rE(ab.dQo());
      AppMethodBeat.o(166594);
      return;
    case 404: 
      locala = ab.zZn;
      ab.a.rE(ab.dQp());
      AppMethodBeat.o(166594);
      return;
    case 403: 
      locala = ab.zZn;
      ab.a.rE(ab.dQq());
      AppMethodBeat.o(166594);
      return;
    case 503: 
      locala = ab.zZn;
      ab.a.rE(ab.dQr());
      AppMethodBeat.o(166594);
      return;
    case 502: 
      locala = ab.zZn;
      ab.a.rE(ab.dQs());
      AppMethodBeat.o(166594);
      return;
    case 416: 
      locala = ab.zZn;
      ab.a.rE(ab.dQt());
      AppMethodBeat.o(166594);
      return;
    }
    ab.a locala = ab.zZn;
    ab.a.rE(ab.dQu());
    AppMethodBeat.o(166594);
  }
  
  public static int Pz(int paramInt)
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
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(220297);
    ds localds = new ds();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localds.qL(str1);
    localds.jB(paramInt1);
    localds.jE(paramInt2);
    localds.jC(paramInt3);
    localds.jD(paramInt4);
    localds.qM(u.Xs(u.Xt(paramLong)));
    localds.bpa();
    a((com.tencent.mm.plugin.report.a)localds);
    AppMethodBeat.o(220297);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, bid parambid)
  {
    AppMethodBeat.i(220181);
    p.k(parambid, "contextObj");
    cz localcz = new cz();
    localcz.gL(parambid.xkX);
    localcz.oe(parambid.sessionId);
    localcz.of(parambid.wmL);
    localcz.og(parambid.wmz);
    localcz.oe(parambid.sessionId);
    localcz.gN(com.tencent.mm.model.cm.bfE());
    localcz.gM(paramInt1);
    localcz.gO(paramInt2);
    localcz.gP(paramInt3);
    localcz.ahU();
    localcz.bpa();
    a((com.tencent.mm.plugin.report.a)localcz);
    AppMethodBeat.o(220181);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3, bid parambid)
  {
    int i = 0;
    AppMethodBeat.i(220171);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    localObject1 = new StringBuilder().append((String)localObject1).append(',').append(paramInt1).append(',').append(paramInt2).append(',').append(paramInt3).append(',');
    if (paramBoolean1)
    {
      paramInt1 = 1;
      localObject1 = ((StringBuilder)localObject1).append(paramInt1).append(',').append(paramInt4).append(',').append(paramInt5).append(',').append(paramInt6).append(',');
      if (!paramBoolean2) {
        break label279;
      }
      paramInt1 = 1;
      label127:
      localObject1 = ((StringBuilder)localObject1).append(paramInt1).append(',');
      if (!paramBoolean3) {
        break label284;
      }
    }
    label279:
    label284:
    for (paramInt1 = i;; paramInt1 = 1)
    {
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(paramInt1).append(',');
      if (parambid != null)
      {
        localObject2 = parambid.wmL;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localStringBuilder.append((String)localObject1).append(',');
      if (parambid != null)
      {
        localObject1 = parambid.wmz;
        parambid = (bid)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parambid = "";
      }
      parambid = parambid;
      Log.i(TAG, "18947 ".concat(String.valueOf(parambid)));
      com.tencent.mm.plugin.report.f.Iyx.kvStat(18947, parambid);
      AppMethodBeat.o(220171);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label127;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, bid parambid, int paramInt3)
  {
    long l2 = 0L;
    AppMethodBeat.i(220306);
    p.k(parambid, "contextObj");
    cq localcq = new cq();
    long l1;
    if (paramInt1 > 0)
    {
      l1 = paramInt1;
      localcq.fY(l1);
      l1 = l2;
      if (paramInt2 > 0) {
        l1 = paramInt2;
      }
      localcq.fZ(l1);
      localcq.ga(com.tencent.mm.model.cm.bfE());
      localcq.mV(parambid.sessionId);
      localcq.mX(parambid.wmL);
      localcq.mW(parambid.wmz);
      localcq.gb(paramInt3);
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localcq.bpa();
      a((com.tencent.mm.plugin.report.a)localcq);
      parambid = h.aHG();
      p.j(parambid, "MMKernel.storage()");
      parambid.aHp().set(ar.a.VCi, localcq.ahO());
      if (paramInt2 != 2)
      {
        parambid = h.aHG();
        p.j(parambid, "MMKernel.storage()");
        parambid.aHp().set(ar.a.VCj, localcq.ahO());
      }
      Log.i(TAG, "finderReportTabChange clickTabContextId [%s] toTab[%d]", new Object[] { localcq.ahO(), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(220306);
      return;
      l1 = 0L;
      break;
      parambid = h.ag(PluginFinder.class);
      p.j(parambid, "MMKernel.plugin(PluginFinder::class.java)");
      if (((PluginFinder)parambid).getRedDotManager().aBe("TLFollow") != null)
      {
        localcq.ahP();
        continue;
        parambid = h.ag(PluginFinder.class);
        p.j(parambid, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)parambid).getRedDotManager().aBe("TLRecommendTab") != null)
        {
          localcq.ahP();
          continue;
          parambid = h.ag(PluginFinder.class);
          p.j(parambid, "MMKernel.plugin(PluginFinder::class.java)");
          if (((PluginFinder)parambid).getRedDotManager().aBe("finder_tl_hot_tab") != null)
          {
            localcq.ahP();
            continue;
            parambid = h.ag(PluginFinder.class);
            p.j(parambid, "MMKernel.plugin(PluginFinder::class.java)");
            if (((PluginFinder)parambid).getRedDotManager().aBe("finder_tl_nearby_tab") != null) {
              localcq.ahP();
            }
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    long l = 1L;
    AppMethodBeat.i(220264);
    com.tencent.mm.f.b.a.cm localcm = new com.tencent.mm.f.b.a.cm();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcm.mA(str1);
    localcm.mD(Mp(paramLong));
    localcm.fD(paramInt1);
    localcm.fC(paramInt2);
    switch (paramInt2)
    {
    default: 
      localcm.fz(2L);
    }
    for (;;)
    {
      localcm.fy(paramInt3);
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      localcm.mB(str1);
      localcm.mC(com.tencent.mm.model.z.bdh());
      paramString = Hc(paramLong);
      if (paramString != null)
      {
        localcm.fA(paramString.getLikeCount());
        localcm.fB(paramString.getCommentCount());
      }
      paramLong = l;
      if (BuildInfo.DEBUG) {
        paramLong = 0L;
      }
      localcm.fE(paramLong);
      localcm.bpa();
      a((com.tencent.mm.plugin.report.a)localcm);
      AppMethodBeat.o(220264);
      return;
      localcm.fz(1L);
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, bid parambid)
  {
    AppMethodBeat.i(220196);
    p.k(paramString1, "actionFeedId");
    p.k(paramString2, "totalFeedId");
    p.k(parambid, "contextObj");
    com.tencent.mm.plugin.report.f.Iyx.a(20586, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), Long.valueOf(com.tencent.mm.model.cm.bfE()), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(parambid.xkX), parambid.wmz, parambid.sessionId });
    AppMethodBeat.o(220196);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(220250);
    FinderItem localFinderItem = Hc(paramLong);
    if (localFinderItem != null)
    {
      com.tencent.mm.f.b.a.cd localcd = new com.tencent.mm.f.b.a.cd();
      String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localcd.lP((String)localObject);
      localcd.lQ("");
      localcd.lR(Mp(paramLong));
      localcd.lS(localFinderItem.getUserName());
      localcd.eV(localFinderItem.getLikeCount());
      localcd.eW(localFinderItem.getCommentCount());
      localcd.eX(localFinderItem.getFriendLikeCount());
      localcd.lq(paramInt2);
      localcd.eY(paramInt1);
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTG().aSr()).intValue() == 1) {}
      for (paramLong = 1L;; paramLong = 0L)
      {
        localcd.eZ(paramLong);
        localcd.lT(paramString1);
        localcd.lU(paramString2);
        localcd.bpa();
        a((com.tencent.mm.plugin.report.a)localcd);
        AppMethodBeat.o(220250);
        return;
      }
    }
    AppMethodBeat.o(220250);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, bid parambid)
  {
    AppMethodBeat.i(220015);
    p.k(paramString1, "eid");
    p.k(paramString2, "udfKv");
    hs localhs = new hs();
    localhs.nf(paramInt);
    localhs.xa(String.valueOf(com.tencent.mm.model.cm.bfE()));
    localhs.xb(paramString1);
    localhs.xc(kotlin.n.n.l(paramString2, ",", ";", false));
    if (parambid != null)
    {
      localhs.wY(parambid.sessionId);
      localhs.wZ(parambid.wmz);
    }
    localhs.bpa();
    a((com.tencent.mm.plugin.report.a)localhs);
    AppMethodBeat.o(220015);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, bid parambid)
  {
    AppMethodBeat.i(220445);
    p.k(paramString1, "userName");
    p.k(paramString2, "profileBizUin");
    p.k(parambid, "contextObj");
    ef localef = new ef();
    localef.ll(paramInt);
    localef.rM(paramString1);
    localef.rN(paramString2);
    localef.rO(paramString3);
    localef.rP(parambid.wmL);
    paramString1 = parambid.extraInfo;
    if (paramString1 != null)
    {
      paramString2 = kotlin.n.n.l(paramString1, ",", ";", false);
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    localef.rQ(paramString1);
    paramString1 = parambid.wmC;
    if (paramString1 != null)
    {
      paramString2 = kotlin.n.n.l(paramString1, ",", ";", false);
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    localef.rR(paramString1);
    localef.bpa();
    a((com.tencent.mm.plugin.report.a)localef);
    AppMethodBeat.o(220445);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(166579);
    p.k(paramString1, "topic");
    p.k(paramString2, "receiver");
    ff localff = new ff();
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localff.tV((String)localObject);
    localff.nc(paramInt1);
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localff.nd(l);
      localObject = ag.AFH;
      localff.tW(kotlin.n.n.l(ag.B(paramString1, paramInt2, paramLong), ",", ";", false));
      localff.tX("");
      localff.ne(paramLong);
      localff.tY(paramString2);
      localff.bpa();
      a((com.tencent.mm.plugin.report.a)localff);
      AppMethodBeat.o(166579);
      return;
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean, String paramString1, long paramLong, String paramString2, bid parambid)
  {
    AppMethodBeat.i(220063);
    p.k(paramString1, "receiver");
    cw localcw = new cw();
    if (parambid != null)
    {
      l = parambid.xkX;
      localcw.gH(l);
      localcw.gB(paramInt);
      if (!paramBoolean) {
        break label313;
      }
    }
    label260:
    label313:
    for (long l = 1L;; l = 2L)
    {
      localcw.gC(l);
      localcw.gI(paramLong);
      localcw.nK(paramString1);
      String str;
      if (parambid != null)
      {
        str = parambid.sessionId;
        paramString1 = str;
        if (str != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localcw.nH(paramString1);
      if (parambid != null)
      {
        str = parambid.wmz;
        paramString1 = str;
        if (str != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localcw.nO(paramString1);
      if (parambid != null)
      {
        str = parambid.wmL;
        paramString1 = str;
        if (str != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localcw.nP(paramString1);
      if (parambid != null)
      {
        paramString1 = parambid.extraInfo;
        if (paramString1 != null)
        {
          str = kotlin.n.n.l(paramString1, ",", ";", false);
          paramString1 = str;
          if (str != null) {
            break label213;
          }
        }
      }
      paramString1 = "";
      label213:
      localcw.nR(paramString1);
      if (parambid != null)
      {
        paramString1 = parambid.wmC;
        if (paramString1 != null)
        {
          parambid = kotlin.n.n.l(paramString1, ",", ";", false);
          paramString1 = parambid;
          if (parambid != null) {
            break label260;
          }
        }
      }
      paramString1 = "";
      localcw.nS(paramString1);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localcw.nW(paramString1);
      localcw.bpa();
      a((com.tencent.mm.plugin.report.a)localcw);
      AppMethodBeat.o(220063);
      return;
      l = 0L;
      break;
    }
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, bid parambid)
  {
    AppMethodBeat.i(220029);
    p.k(paramString, "mutualAdInfo");
    bn localbn = new bn();
    localbn.jU(Mp(paramLong));
    localbn.dK(paramInt1);
    localbn.dL(paramInt2);
    Object localObject;
    if (paramInt2 == 2)
    {
      localObject = new com.tencent.mm.ad.i();
      ((com.tencent.mm.ad.i)localObject).al("duration", paramInt4);
      ((com.tencent.mm.ad.i)localObject).al("playpercent", (int)(paramInt3 * 1.0F / paramInt4 * 100.0F));
      localObject = ((com.tencent.mm.ad.i)localObject).toString();
      p.j(localObject, "playInfo.toString()");
      localbn.jV(kotlin.n.n.l((String)localObject, ",", ";", false));
    }
    localbn.jW(kotlin.n.n.l(paramString, ",", ";", false));
    if (parambid != null)
    {
      paramString = parambid.extraInfo;
      if (paramString != null)
      {
        localObject = kotlin.n.n.l(paramString, ",", ";", false);
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localbn.jZ(paramString);
      paramString = parambid.wmC;
      if (paramString != null)
      {
        localObject = kotlin.n.n.l(paramString, ",", ";", false);
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localbn.ka(paramString);
      paramString = N(paramLong, parambid.xkX);
      if (paramString != null)
      {
        localObject = kotlin.n.n.l(paramString, ",", ";", false);
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localbn.jX(paramString);
      localbn.jY(parambid.wmL);
      localbn.dJ(parambid.xkX);
    }
    localbn.bpa();
    a((com.tencent.mm.plugin.report.a)localbn);
    AppMethodBeat.o(220029);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(220393);
    paramString1 = com.tencent.mm.ae.d.Fw(paramLong) + ',' + paramInt1 + ',' + paramInt2 + ',' + Util.nullAsNil(paramString1) + ',' + Util.nullAsNil(paramString2) + ',' + Util.nullAsNil(paramString3) + ',' + Util.nullAsNil(paramString4) + ',' + paramInt3;
    com.tencent.mm.plugin.report.f.Iyx.kvStat(20717, paramString1);
    AppMethodBeat.o(220393);
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(220086);
    p.k(paramString1, "fromUser");
    cg localcg = new cg();
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localcg.lZ((String)localObject);
    localcg.fe(paramInt1);
    localcg.ff(paramLong2);
    localcg.ma(paramString1);
    localcg.mb(Mp(paramLong1));
    localcg.fh(paramInt2);
    localcg.fi(paramInt3);
    if (paramString2 != null) {
      localcg.mg(paramString2);
    }
    paramString2 = Hc(paramLong1);
    if (paramString2 != null)
    {
      localcg.mc(paramString2.getFeedObject().username);
      paramString1 = ag.AFH;
      localcg.md(kotlin.n.n.l(ag.A(paramString2), ",", ";", false));
      localObject = (Iterable)paramString2.getMediaList();
      paramString1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        if (Util.isNullOrNil(((csg)((Iterator)localObject).next()).coverUrl)) {}
        for (paramLong1 = 0L;; paramLong1 = 1L)
        {
          localcg.fg(paramLong1);
          paramString1.add(x.aazN);
          break;
        }
      }
      paramString1 = paramString2.getFinderObject().objectDesc;
      if (paramString1 == null) {
        break label458;
      }
      paramString1 = paramString1.feedBgmInfo;
      if (paramString1 == null) {
        break label458;
      }
      paramString1 = paramString1.groupId;
      localcg.me(paramString1);
      paramString1 = paramString2.getFeedObject().objectDesc;
      if (paramString1 == null) {
        break label464;
      }
      paramString1 = paramString1.feedBgmInfo;
      if (paramString1 == null) {
        break label464;
      }
      paramString1 = paramString1.musicInfo;
      label347:
      if (paramString1 == null) {
        break label481;
      }
      paramString1 = paramString2.getFeedObject().objectDesc;
      if (paramString1 == null) {
        break label470;
      }
      paramString1 = paramString1.feedBgmInfo;
      if (paramString1 == null) {
        break label470;
      }
      paramString1 = paramString1.musicInfo;
      if (paramString1 == null) {
        break label470;
      }
      paramString1 = paramString1.BHW;
      label398:
      paramString1 = (CharSequence)paramString1;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label476;
      }
      paramInt1 = 1;
      label422:
      if (paramInt1 != 0) {
        break label481;
      }
    }
    label458:
    label464:
    label470:
    label476:
    label481:
    for (paramLong1 = 2L;; paramLong1 = 1L)
    {
      localcg.fj(paramLong1);
      localcg.bpa();
      a((com.tencent.mm.plugin.report.a)localcg);
      AppMethodBeat.o(220086);
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label347;
      paramString1 = null;
      break label398;
      paramInt1 = 0;
      break label422;
    }
  }
  
  public static void a(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3, bid parambid)
  {
    AppMethodBeat.i(220146);
    p.k(paramString, "receiver");
    cw localcw = new cw();
    long l;
    String str;
    if (parambid != null)
    {
      l = parambid.xkX;
      localcw.gH(l);
      localcw.gB(paramInt);
      localcw.gC(paramLong2);
      localcw.gI(paramLong3);
      localcw.nK(paramString);
      if (parambid != null)
      {
        str = parambid.sessionId;
        paramString = str;
        if (str != null) {}
      }
      else
      {
        paramString = "";
      }
      localcw.nH(paramString);
      if (parambid == null) {
        break label342;
      }
    }
    label297:
    label342:
    for (paramInt = parambid.xkX;; paramInt = 0)
    {
      localcw.nQ(N(paramLong1, paramInt));
      if (parambid != null)
      {
        str = parambid.wmz;
        paramString = str;
        if (str != null) {}
      }
      else
      {
        paramString = "";
      }
      localcw.nO(paramString);
      if (parambid != null)
      {
        str = parambid.wmL;
        paramString = str;
        if (str != null) {}
      }
      else
      {
        paramString = "";
      }
      localcw.nP(paramString);
      if (parambid != null)
      {
        paramString = parambid.extraInfo;
        if (paramString != null)
        {
          str = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = str;
          if (str != null) {
            break label244;
          }
        }
      }
      paramString = "";
      label244:
      localcw.nR(paramString);
      if (parambid != null)
      {
        paramString = parambid.wmC;
        if (paramString != null)
        {
          parambid = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = parambid;
          if (parambid != null) {
            break label297;
          }
        }
      }
      paramString = "";
      localcw.nS(paramString);
      localcw.nV(com.tencent.mm.ae.d.Fw(paramLong1));
      localcw.bpa();
      a((com.tencent.mm.plugin.report.a)localcw);
      AppMethodBeat.o(220146);
      return;
      l = 0L;
      break;
    }
  }
  
  private static void a(long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    AppMethodBeat.i(219999);
    if (paramString != null)
    {
      paramString = kotlin.n.n.l(paramString, ",", ";", false);
      if (paramString != null)
      {
        paramString = new ao(paramString);
        paramString.xkX = paramInt;
        paramString.zZQ.id = paramLong1;
        bft localbft = paramString.zZQ;
        if (paramLong2 <= 0L) {
          break label288;
        }
        localbft.SQw = paramLong2;
        switch (paramInt)
        {
        default: 
          ((Map)zWC).put(paramLong1 + '_' + paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      zWB.put(paramLong1, Long.valueOf(com.tencent.mm.model.cm.bfE()));
      AppMethodBeat.o(219999);
      return;
      label288:
      paramLong2 = com.tencent.mm.model.cm.bfD();
      break;
      ((Map)zWC).put(paramLong1 + "_6", paramString);
      ((Map)zWC).put(paramLong1 + "_23", paramString);
      continue;
      ((Map)zWC).put(paramLong1 + "_9", paramString);
      ((Map)zWC).put(paramLong1 + "_22", paramString);
      continue;
      ((Map)zWC).put(paramLong1 + "_15", paramString);
      ((Map)zWC).put(paramLong1 + "_16", paramString);
      continue;
      ((Map)zWC).put(paramLong1 + "_26", paramString);
      ((Map)zWC).put(paramLong1 + "_27", paramString);
      continue;
      ((Map)zWC).put(paramLong1 + "_24", paramString);
      ((Map)zWC).put(paramLong1 + "_21", paramString);
      continue;
      ((Map)zWC).put(paramLong1 + "_32", paramString);
      ((Map)zWC).put(paramLong1 + "_1", paramString);
      continue;
      ((Map)zWC).put(paramLong1 + "_33", paramString);
      ((Map)zWC).put(paramLong1 + "_8", paramString);
      continue;
      ((Map)zWC).put(paramLong1 + "_59", paramString);
      ((Map)zWC).put(paramLong1 + "_60", paramString);
      continue;
      ((Map)zWC).put(paramLong1 + "_35", paramString);
      ((Map)zWC).put(paramLong1 + "_2", paramString);
    }
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt)
  {
    AppMethodBeat.i(220066);
    p.k(paramString, "paperWording");
    aq localaq = new aq();
    localaq.jk(Mp(paramLong1));
    localaq.cu(paramLong2);
    localaq.jl(Mp(paramLong3));
    localaq.jm(paramString);
    localaq.cv(paramLong4);
    localaq.ct(com.tencent.mm.model.cm.bfE());
    localaq.jn(N(paramLong1, paramInt));
    localaq.bpa();
    a((com.tencent.mm.plugin.report.a)localaq);
    AppMethodBeat.o(220066);
  }
  
  public static void a(long paramLong1, long paramLong2, bid parambid)
  {
    Object localObject2 = null;
    AppMethodBeat.i(220422);
    com.tencent.mm.f.b.a.b localb = new com.tencent.mm.f.b.a.b();
    localb.bT(paramLong1);
    localb.it(String.valueOf(com.tencent.mm.model.cm.bfE()));
    localb.agJ();
    localb.iu(com.tencent.mm.ae.d.Fw(paramLong2));
    if (parambid != null)
    {
      paramLong1 = parambid.xkX;
      localb.bS(paramLong1);
      if (parambid == null) {
        break label162;
      }
      localObject1 = parambid.sessionId;
      label84:
      localb.iq((String)localObject1);
      if (parambid == null) {
        break label168;
      }
    }
    label162:
    label168:
    for (Object localObject1 = parambid.wmz;; localObject1 = null)
    {
      localb.ir((String)localObject1);
      localObject1 = localObject2;
      if (parambid != null) {
        localObject1 = parambid.wmL;
      }
      localb.is((String)localObject1);
      localb.bpa();
      a((com.tencent.mm.plugin.report.a)localb);
      AppMethodBeat.o(220422);
      return;
      paramLong1 = 0L;
      break;
      localObject1 = null;
      break label84;
    }
  }
  
  public static void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220004);
    p.k(paramString, "topic");
    FinderItem localFinderItem = Hc(paramLong);
    if (localFinderItem != null)
    {
      fe localfe = new fe();
      String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localfe.tQ((String)localObject);
      localfe.tR("");
      localfe.mX(paramInt2);
      localfe.tS(Mp(localFinderItem.getId()));
      localfe.mY(localFinderItem.getMediaType());
      localObject = ag.AFH;
      localfe.tT(kotlin.n.n.l(ag.B(paramString, paramInt1, 0L), ",", ";", false));
      localfe.tU("");
      localfe.mZ(localFinderItem.getFeedObject().likeCount);
      localfe.na(localFinderItem.getFeedObject().commentCount);
      localfe.nb(localFinderItem.getFeedObject().friendLikeCount);
      localfe.bpa();
      a((com.tencent.mm.plugin.report.a)localfe);
      AppMethodBeat.o(220004);
      return;
    }
    AppMethodBeat.o(220004);
  }
  
  public static void a(long paramLong1, String paramString1, long paramLong2, String paramString2, bid parambid)
  {
    Object localObject = null;
    AppMethodBeat.i(220426);
    p.k(paramString1, "action");
    bo localbo = new bo();
    localbo.dM(paramLong1);
    localbo.kb(paramString1);
    localbo.dO(paramLong2);
    localbo.kf(paramString2);
    if (parambid != null)
    {
      paramLong1 = parambid.xkX;
      localbo.dN(paramLong1);
      if (parambid == null) {
        break label156;
      }
      paramString1 = parambid.sessionId;
      label84:
      localbo.kc(paramString1);
      if (parambid == null) {
        break label161;
      }
    }
    label156:
    label161:
    for (paramString1 = parambid.wmz;; paramString1 = null)
    {
      localbo.kd(paramString1);
      paramString1 = localObject;
      if (parambid != null) {
        paramString1 = parambid.wmL;
      }
      localbo.ke(paramString1);
      localbo.bpa();
      a((com.tencent.mm.plugin.report.a)localbo);
      AppMethodBeat.o(220426);
      return;
      paramLong1 = 0L;
      break;
      paramString1 = null;
      break label84;
    }
  }
  
  public static void a(long paramLong1, String paramString1, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(220416);
    p.k(paramString1, "appId");
    p.k(paramString2, "clickId");
    p.k(paramString3, "sessionid");
    p.k(paramString4, "setting");
    p.k(paramString5, "requestId");
    iz localiz = new iz();
    localiz.ul(System.currentTimeMillis());
    localiz.um(paramLong1);
    localiz.zW(paramString1);
    localiz.zZ(paramString2);
    localiz.un(paramLong2);
    localiz.zY(com.tencent.mm.model.z.bdh());
    localiz.zX(paramString3);
    localiz.zV(paramString4);
    localiz.Aa(paramString5);
    localiz.bpa();
    a((com.tencent.mm.plugin.report.a)localiz);
    AppMethodBeat.o(220416);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Integer paramInteger)
  {
    long l2 = 0L;
    AppMethodBeat.i(220395);
    p.k(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramContext = aj.a.fZ(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.ekY();
      localObject = new cb();
      ((cb)localObject).eD(System.currentTimeMillis());
      ((cb)localObject).eE(paramInt1);
      ((cb)localObject).eF(paramInt2);
      if (paramContext == null) {
        break label129;
      }
    }
    label129:
    for (long l1 = paramContext.xkX;; l1 = 0L)
    {
      ((cb)localObject).eG(l1);
      l1 = l2;
      if (paramInteger != null) {
        l1 = paramInteger.intValue();
      }
      ((cb)localObject).eH(l1);
      ((cb)localObject).bpa();
      AppMethodBeat.o(220395);
      return;
      paramContext = null;
      break;
    }
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(220382);
    p.k(paramContext, "context");
    paramContext = new eu();
    paramContext.mp(paramLong1);
    paramContext.mq(paramLong2);
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      paramContext.mr(paramLong1);
      paramContext.bpa();
      AppMethodBeat.o(220382);
      return;
    }
  }
  
  public static void a(Context paramContext, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2, long paramLong4)
  {
    AppMethodBeat.i(220375);
    p.k(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramContext = aj.a.fZ(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.ekY();
      localObject = new dw();
      if (paramContext == null) {
        break label142;
      }
      paramContext = paramContext.sessionId;
      label50:
      ((dw)localObject).qY(paramContext);
      ((dw)localObject).jW(paramLong1);
      if (!paramBoolean1) {
        break label147;
      }
      paramLong1 = 1L;
      label70:
      ((dw)localObject).jX(paramLong1);
      ((dw)localObject).jY(paramLong2);
      ((dw)localObject).jZ(paramLong3);
      ((dw)localObject).ka(System.currentTimeMillis());
      if (!paramBoolean2) {
        break label152;
      }
    }
    label142:
    label147:
    label152:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      ((dw)localObject).kb(paramLong1);
      ((dw)localObject).kc(paramLong4);
      ((dw)localObject).bpa();
      AppMethodBeat.o(220375);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label50;
      paramLong1 = 0L;
      break label70;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    int j = 1;
    AppMethodBeat.i(220400);
    p.k(paramContext, "context");
    p.k(paramString1, "appuin");
    p.k(paramString2, "preWarmPath");
    p.k(paramString3, "liveid");
    p.k(paramString4, "finderid");
    p.k(paramString5, "shopwindowid");
    p.k(paramString6, "sessionid");
    dn localdn = new dn();
    localdn.qm(paramString1);
    localdn.ajh();
    localdn.aji();
    localdn.qo(paramString2);
    if (paramBoolean1)
    {
      i = 1;
      localdn.lG(i);
      if (!paramBoolean2) {
        break label202;
      }
    }
    label202:
    for (int i = j;; i = 0)
    {
      localdn.lH(i);
      localdn.qp(paramString3);
      localdn.qq(paramString4);
      localdn.qr(paramString5);
      localdn.qs(paramString6);
      localdn.qn(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)));
      localdn.iR(com.tencent.mm.model.cm.bfE());
      localdn.bpa();
      AppMethodBeat.o(220400);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(220413);
    p.k(paramContext, "context");
    p.k(paramString1, "clickId");
    p.k(paramString2, "appId");
    p.k(paramString3, "preWarmPath");
    p.k(paramString4, "liveid");
    p.k(paramString5, "finderid");
    p.k(paramString6, "shopwindowid");
    p.k(paramString7, "sessionid");
    dj localdj = new dj();
    localdj.lB(paramInt2);
    if (paramBoolean1)
    {
      paramInt2 = 1;
      localdj.lz(paramInt2);
      localdj.lA(paramInt1);
      localdj.pU(paramString1);
      localdj.pN(paramString2);
      localdj.ajd();
      localdj.pP(paramString3);
      if (!paramBoolean2) {
        break label243;
      }
      paramInt1 = 1;
      label143:
      localdj.lC(paramInt1);
      if (!paramBoolean3) {
        break label248;
      }
    }
    label243:
    label248:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localdj.lD(paramInt1);
      localdj.pQ(paramString4);
      localdj.pR(paramString5);
      localdj.pS(paramString6);
      localdj.pT(paramString7);
      localdj.aje();
      localdj.pO(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)));
      localdj.iH(com.tencent.mm.model.cm.bfE());
      localdj.bpa();
      AppMethodBeat.o(220413);
      return;
      paramInt2 = 0;
      break;
      paramInt1 = 0;
      break label143;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(220398);
    p.k(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramContext = aj.a.fZ(paramContext);
    fk localfk;
    if (paramContext != null)
    {
      paramContext = paramContext.ekY();
      localfk = new fk();
      if (paramContext == null) {
        break label211;
      }
      l = paramContext.xkX;
      label52:
      localfk.nr(l);
      if (paramContext == null) {
        break label217;
      }
      localObject = paramContext.sessionId;
      label70:
      localfk.up((String)localObject);
      if (paramContext == null) {
        break label223;
      }
      localObject = paramContext.wmL;
      label88:
      localfk.uq((String)localObject);
      if (paramContext == null) {
        break label229;
      }
      localObject = paramContext.wmz;
      label106:
      localfk.ur((String)localObject);
      if (paramContext == null) {
        break label235;
      }
      l = paramContext.BmO;
      label124:
      localfk.us(com.tencent.mm.ae.d.Fw(l));
      if (!paramBoolean1) {
        break label241;
      }
      l = 1L;
      label142:
      localfk.ns(l);
      localfk.nt(paramInt);
      if (!paramBoolean2) {
        break label249;
      }
      l = 2L;
      label167:
      localfk.nu(l);
      if (!paramBoolean3) {
        break label255;
      }
    }
    label211:
    label217:
    label223:
    label229:
    label235:
    label241:
    label249:
    label255:
    for (long l = 2L;; l = 1L)
    {
      localfk.nv(l);
      localfk.bpa();
      AppMethodBeat.o(220398);
      return;
      paramContext = null;
      break;
      l = 0L;
      break label52;
      localObject = null;
      break label70;
      localObject = null;
      break label88;
      localObject = null;
      break label106;
      l = 0L;
      break label124;
      l = 2L;
      break label142;
      l = 1L;
      break label167;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6)
  {
    AppMethodBeat.i(220407);
    p.k(paramContext, "context");
    p.k(paramString1, "liveid");
    p.k(paramString2, "finderid");
    p.k(paramString3, "shopwindowid");
    p.k(paramString4, "sessionid");
    p.k(paramString5, "appuin");
    p.k(paramString6, "appVersion");
    dm localdm = new dm();
    localdm.qf(paramString5);
    localdm.ajf();
    localdm.qg(paramString6);
    if (paramBoolean1)
    {
      i = 1;
      localdm.lE(i);
      if (!paramBoolean2) {
        break label206;
      }
    }
    label206:
    for (int i = 1;; i = 0)
    {
      localdm.lF(i);
      localdm.qi(paramString1);
      localdm.qj(paramString2);
      localdm.qk(paramString3);
      localdm.ql(paramString4);
      localdm.ajg();
      localdm.qh(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)));
      localdm.iP(paramLong1);
      localdm.iQ(paramLong2);
      localdm.bpa();
      AppMethodBeat.o(220407);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(FinderPoiFeedUI.a parama, long paramLong1, bid parambid, String paramString1, String paramString2, String paramString3, long paramLong2)
  {
    Object localObject = null;
    AppMethodBeat.i(220459);
    p.k(parama, "action");
    ir localir = new ir();
    localir.ua(parama.ordinal());
    localir.ub(com.tencent.mm.model.cm.bfE());
    localir.uc(paramLong2);
    localir.ud(paramLong1);
    if (parambid != null) {}
    for (parama = parambid.wmL;; parama = null)
    {
      localir.zJ(parama);
      parama = localObject;
      if (parambid != null) {
        parama = parambid.sessionId;
      }
      localir.zK(parama);
      localir.zL(paramString1);
      localir.zM(paramString2);
      localir.zN(paramString3);
      localir.bpa();
      a((com.tencent.mm.plugin.report.a)localir);
      AppMethodBeat.o(220459);
      return;
    }
  }
  
  public static void a(bs parambs, int paramInt, long paramLong1, String paramString, bid parambid, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(220137);
    p.k(parambs, "item");
    p.k(paramString, "receiver");
    cw localcw = new cw();
    String str;
    if (parambid != null)
    {
      str = parambid.sessionId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localcw.nH((String)localObject);
    localcw.gB(paramInt);
    localcw.gC(paramLong1);
    localcw.nI(Mp(parambs.dKW()));
    Object localObject = parambs.contact;
    if (localObject != null)
    {
      str = ((FinderContact)localObject).username;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localcw.nJ((String)localObject);
    localcw.nK(paramString);
    localcw.gD(parambs.getFeedObject().likeCount);
    localcw.nL("");
    localcw.nM("");
    localcw.nN("");
    if (parambid != null)
    {
      paramLong1 = parambid.xkX;
      localcw.gH(paramLong1);
      if (parambid != null)
      {
        localObject = parambid.wmz;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localcw.nO(paramString);
      if (parambid != null)
      {
        localObject = parambid.wmL;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localcw.nP(paramString);
      paramString = parambs.xcy;
      if (paramString == null) {
        break label477;
      }
      paramLong1 = paramString.id;
      label288:
      if (parambid == null) {
        break label482;
      }
    }
    label416:
    label477:
    label482:
    for (paramInt = parambid.xkX;; paramInt = 0)
    {
      localcw.nQ(N(paramLong1, paramInt));
      localcw.gI(paramLong2);
      if (parambid != null)
      {
        paramString = parambid.extraInfo;
        if (paramString != null)
        {
          localObject = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = (String)localObject;
          if (localObject != null) {
            break label363;
          }
        }
      }
      paramString = "";
      label363:
      localcw.nR(paramString);
      if (parambid != null)
      {
        paramString = parambid.wmC;
        if (paramString != null)
        {
          parambid = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = parambid;
          if (parambid != null) {
            break label416;
          }
        }
      }
      paramString = "";
      localcw.nS(paramString);
      parambs = parambs.xcy;
      paramLong1 = l;
      if (parambs != null) {
        paramLong1 = parambs.id;
      }
      localcw.nT(Mp(paramLong1));
      localcw.bpa();
      a((com.tencent.mm.plugin.report.a)localcw);
      AppMethodBeat.o(220137);
      return;
      paramLong1 = 0L;
      break;
      paramLong1 = 0L;
      break label288;
    }
  }
  
  public static void a(s params, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178394);
    p.k(params, "rootComment");
    FinderItem localFinderItem = Hc(params.zAt.field_feedId);
    if (localFinderItem != null)
    {
      ci localci = new ci();
      localci.fl(paramInt1);
      localci.fm(params.zAt.dYY().levelTwoComment.size());
      String str2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localci.mj(str1);
      localci.mk(Mp(localFinderItem.getId()));
      localci.ml(localFinderItem.getUserName());
      localci.fo(System.currentTimeMillis());
      localci.mm(params.zAt.getUsername());
      localci.fn(params.zAt.dYY().likeCount);
      localci.mn(Mp(params.mf()));
      localci.fp(params.zAt.dYY().expandCommentCount);
      switch (paramInt2)
      {
      default: 
        localci.fq(2L);
        if (((params.zAt.dYY().displayFlag & 0x8) <= 0) && ((params.zAt.dYY().displayFlag & 0x2) <= 0)) {
          break;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        localci.fr(paramInt1);
        localci.fs(paramInt2);
        localci.bpa();
        a((com.tencent.mm.plugin.report.a)localci);
        AppMethodBeat.o(178394);
        return;
        localci.fq(1L);
        break;
      }
    }
    AppMethodBeat.o(178394);
  }
  
  public static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(220355);
    p.k(parama, "struct");
    Object localObject3;
    if ((parama instanceof cn)) {
      localObject3 = ((cn)parama).getSessionBuffer();
    }
    for (;;)
    {
      try
      {
        Object localObject4 = (cn)parama;
        localObject1 = (CharSequence)((cn)parama).getSessionBuffer();
        if (localObject1 == null) {
          break label249;
        }
        if (((CharSequence)localObject1).length() == 0)
        {
          break label249;
          ((cn)localObject4).mH((String)localObject1);
          localObject1 = TAG;
          localObject4 = new StringBuilder("report").append(((cn)parama).getId()).append(' ');
          String str2 = parama.agI();
          p.j(str2, "struct.toShowString()");
          Log.i((String)localObject1, kotlin.n.n.l(str2, "\r\n", " ", false));
          return;
        }
        i = 0;
      }
      finally
      {
        Object localObject1;
        ((cn)parama).mH((String)localObject3);
        AppMethodBeat.o(220355);
      }
      localObject1 = localObject3;
      continue;
      String str1 = TAG;
      localObject3 = new StringBuilder("report").append(parama.getId()).append(' ');
      parama = parama.agI();
      p.j(parama, "struct.toShowString()");
      Log.i(str1, kotlin.n.n.l(parama, "\r\n", " ", false));
      AppMethodBeat.o(220355);
      return;
      label249:
      int i = 1;
      if (i == 0) {
        str1 = "...";
      }
    }
  }
  
  public static void a(FinderObject paramFinderObject, int paramInt)
  {
    AppMethodBeat.i(219988);
    p.k(paramFinderObject, "finderObject");
    l(paramFinderObject);
    long l2 = paramFinderObject.id;
    String str = paramFinderObject.sessionBuffer;
    paramFinderObject = paramFinderObject.client_local_buffer;
    if (paramFinderObject != null) {}
    for (long l1 = paramFinderObject.SQz;; l1 = 0L)
    {
      a(l2, paramInt, str, l1);
      AppMethodBeat.o(219988);
      return;
    }
  }
  
  public static void a(bid parambid, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220338);
    p.k(parambid, "contextObj");
    bq localbq = new bq();
    localbq.eb(parambid.xkX);
    localbq.ku(parambid.sessionId);
    localbq.kv(parambid.wmL);
    localbq.kw(parambid.wmz);
    localbq.ec(paramInt1);
    if (paramInt2 != 0)
    {
      parambid = g.Xox;
      if (!((com.tencent.mm.plugin.finder.viewmodel.b)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RJ(paramInt2)) {
        break label131;
      }
    }
    label131:
    for (long l = 1L;; l = 0L)
    {
      localbq.ed(l);
      localbq.bpa();
      a((com.tencent.mm.plugin.report.a)localbq);
      AppMethodBeat.o(220338);
      return;
    }
  }
  
  public static void a(bid parambid, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, long paramLong2)
  {
    AppMethodBeat.i(220231);
    p.k(parambid, "contextObj");
    p.k(paramString, "replyUsername");
    Object localObject = Hc(paramLong1);
    if (localObject != null)
    {
      cc localcc = new cc();
      localcc.lD(parambid.sessionId);
      localcc.lE("");
      localcc.lF(Mp(paramLong1));
      localcc.lG(((FinderItem)localObject).getUserName());
      localcc.eI(paramInt1);
      localcc.eJ(paramInt2);
      localcc.eK(paramInt3);
      localcc.lH(paramString);
      localcc.eL(paramInt4);
      localcc.eM(((FinderItem)localObject).getLikeCount());
      localcc.eN(((FinderItem)localObject).getCommentCount());
      localcc.eO(((FinderItem)localObject).getFriendLikeCount());
      localcc.eP(((FinderItem)localObject).getMediaType());
      paramString = ag.AFH;
      localcc.lI(kotlin.n.n.l(ag.A((FinderItem)localObject), ",", ";", false));
      localcc.lJ("");
      localcc.eQ(parambid.xkX);
      long l;
      if (p.h(((FinderItem)localObject).getUserName(), com.tencent.mm.model.z.bdh()))
      {
        l = 1L;
        localcc.eR(l);
        if (!paramBoolean1) {
          break label519;
        }
        l = 1L;
        label251:
        localcc.eS(l);
        localObject = parambid.wmL;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localcc.lK(paramString);
        localObject = parambid.wmz;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localcc.lL(paramString);
        paramInt1 = parambid.xkX;
        if ((paramInt1 != 45) && (paramInt1 != 46) && (paramInt1 != 47) && (paramInt1 != 48) && (paramInt1 != 53) && (paramInt1 != 54)) {
          break label525;
        }
        paramInt1 = 1;
        label358:
        if (paramInt1 == 0) {
          break label530;
        }
        paramString = N(paramLong2, parambid.xkX);
        label373:
        localcc.lM(paramString);
        if (!paramBoolean2) {
          break label543;
        }
      }
      label519:
      label525:
      label530:
      label543:
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        localcc.eT(paramLong1);
        paramString = parambid.extraInfo;
        if (paramString != null)
        {
          localObject = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = (String)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramString = "";
        }
        localcc.lN(paramString);
        parambid = parambid.wmC;
        if (parambid != null)
        {
          paramString = kotlin.n.n.l(parambid, ",", ";", false);
          parambid = paramString;
          if (paramString != null) {}
        }
        else
        {
          parambid = "";
        }
        localcc.lO(parambid);
        localcc.eU(paramInt5);
        localcc.bpa();
        a((com.tencent.mm.plugin.report.a)localcc);
        AppMethodBeat.o(220231);
        return;
        l = 0L;
        break;
        l = 0L;
        break label251;
        paramInt1 = 0;
        break label358;
        paramString = N(paramLong1, parambid.xkX);
        break label373;
      }
    }
    AppMethodBeat.o(220231);
  }
  
  public static void a(bid parambid, long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(220330);
    p.k(parambid, "contextObj");
    if (Hc(paramLong) != null)
    {
      ei localei = new ei();
      localei.ls(parambid.xkX);
      localei.sd(parambid.wmL);
      localei.se(parambid.wmz);
      localei.sc(parambid.sessionId);
      localei.sb(com.tencent.mm.ae.d.Fw(paramLong));
      parambid = paramString;
      if (paramString == null) {
        parambid = "";
      }
      localei.sa(parambid);
      localei.lr(paramInt);
      localei.bpa();
      a((com.tencent.mm.plugin.report.a)localei);
    }
    AppMethodBeat.o(220330);
  }
  
  public static void a(bid parambid, long paramLong, RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(220320);
    p.k(parambid, "contextObj");
    p.k(paramRecyclerView, "recyclerView");
    FinderItem localFinderItem = Hc(paramLong);
    if (localFinderItem != null)
    {
      ct localct = new ct();
      localct.gf(parambid.xkX);
      localct.ng(parambid.sessionId);
      localct.nh(parambid.wmL);
      localct.ni(parambid.wmz);
      localct.nj(com.tencent.mm.ae.d.Fw(paramLong));
      localct.gh(com.tencent.mm.model.cm.bfE());
      Object localObject = parambid.BmS;
      if (localObject != null)
      {
        String str = kotlin.n.n.l((String)localObject, ",", ";", false);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localct.nl((String)localObject);
      localct.gi(localFinderItem.getMediaType());
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject = com.tencent.mm.plugin.finder.utils.aj.eef().toString();
      p.j(localObject, "FinderUtil.getScreenInfo().toString()");
      localct.nn(kotlin.n.n.l((String)localObject, ",", ";", false));
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      paramRecyclerView = com.tencent.mm.plugin.finder.utils.aj.r(paramRecyclerView).toString();
      p.j(paramRecyclerView, "FinderUtil.getCurrentScr…(recyclerView).toString()");
      localct.nk(kotlin.n.n.l(paramRecyclerView, ",", ";", false));
      paramRecyclerView = com.tencent.mm.plugin.findersdk.b.c.BvA;
      localct.gg(c.a.Sh(parambid.xkX));
      localct.nm(N(paramLong, parambid.xkX));
      if (parambid.xkX == 15) {}
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
        localct.gj(paramLong);
        paramRecyclerView = localFinderItem.getFeedObject().recommendReason;
        parambid = paramRecyclerView;
        if (paramRecyclerView == null) {
          parambid = "";
        }
        localct.no(parambid);
        parambid = localFinderItem.getFeedObject().objectDesc;
        if (parambid != null)
        {
          parambid = parambid.event;
          if (parambid != null)
          {
            localct.nq(com.tencent.mm.ae.d.Fw(parambid.xdR));
            localct.gl(paramInt);
          }
        }
        parambid = localFinderItem.getFeedObject().objectDesc;
        if (parambid != null)
        {
          parambid = parambid.feedBgmInfo;
          if (parambid != null)
          {
            paramRecyclerView = parambid.groupId;
            parambid = paramRecyclerView;
            if (paramRecyclerView != null) {
              break label464;
            }
          }
        }
        parambid = "";
        label464:
        localct.np(parambid);
        parambid = localFinderItem.getFeedObject().objectDesc;
        if (parambid != null)
        {
          parambid = parambid.feedBgmInfo;
          if (parambid != null)
          {
            parambid = parambid.musicInfo;
            label498:
            if (parambid == null) {
              break label652;
            }
            parambid = localFinderItem.getFeedObject().objectDesc;
            if (parambid == null) {
              break label641;
            }
            parambid = parambid.feedBgmInfo;
            if (parambid == null) {
              break label641;
            }
            parambid = parambid.musicInfo;
            if (parambid == null) {
              break label641;
            }
            parambid = parambid.BHW;
            label538:
            parambid = (CharSequence)parambid;
            if ((parambid != null) && (parambid.length() != 0)) {
              break label646;
            }
            paramInt = 1;
            label559:
            if (paramInt != 0) {
              break label652;
            }
          }
        }
        break;
      }
      label641:
      label646:
      label652:
      for (paramLong = 2L;; paramLong = 1L)
      {
        localct.gk(paramLong);
        localct.bpa();
        a((com.tencent.mm.plugin.report.a)localct);
        AppMethodBeat.o(220320);
        return;
        paramLong = 1L;
        break;
        paramLong = 2L;
        break;
        paramLong = 3L;
        break;
        paramLong = 4L;
        break;
        paramLong = 5L;
        break;
        paramLong = 6L;
        break;
        parambid = null;
        break label498;
        parambid = null;
        break label538;
        paramInt = 0;
        break label559;
      }
    }
    AppMethodBeat.o(220320);
  }
  
  public static void a(bid parambid, long paramLong, Integer paramInteger)
  {
    AppMethodBeat.i(220414);
    p.k(parambid, "contextObj");
    bv localbv = new bv();
    localbv.lp(com.tencent.mm.ae.d.Fw(paramLong));
    localbv.ahp();
    localbv.ei(parambid.xkX);
    if (paramInteger != null) {}
    for (paramLong = paramInteger.intValue();; paramLong = 0L)
    {
      localbv.ej(paramLong);
      localbv.bpa();
      AppMethodBeat.o(220414);
      return;
    }
  }
  
  public static void a(bid parambid, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(220244);
    p.k(parambid, "contextObj");
    p.k(paramString, "finderUsername");
    cc localcc = new cc();
    localcc.lD(parambid.sessionId);
    localcc.lE("");
    localcc.eQ(parambid.xkX);
    localcc.lG(paramString);
    localcc.eI(3L);
    localcc.eJ(paramInt);
    localcc.lH("");
    localcc.eL(2L);
    localcc.lK(parambid.wmL);
    localcc.lL(parambid.wmz);
    paramString = Hc(paramLong);
    Object localObject;
    if (paramString != null)
    {
      localcc.lF(Mp(paramLong));
      localcc.eM(paramString.getFeedObject().likeCount);
      localcc.eN(paramString.getFeedObject().commentCount);
      localcc.eO(paramString.getFeedObject().friendLikeCount);
      localcc.eP(paramString.getMediaType());
      localObject = ag.AFH;
      localcc.lI(kotlin.n.n.l(ag.A(paramString), ",", ";", false));
      localcc.lJ("");
      localcc.lM(N(paramLong, parambid.fGo));
    }
    for (;;)
    {
      paramString = parambid.extraInfo;
      if (paramString != null)
      {
        localObject = kotlin.n.n.l(paramString, ",", ";", false);
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localcc.lN(paramString);
      parambid = parambid.wmC;
      if (parambid != null)
      {
        paramString = kotlin.n.n.l(parambid, ",", ";", false);
        parambid = paramString;
        if (paramString != null) {}
      }
      else
      {
        parambid = "";
      }
      localcc.lO(parambid);
      localcc.bpa();
      a((com.tencent.mm.plugin.report.a)localcc);
      AppMethodBeat.o(220244);
      return;
      localcc.lF("0");
      localcc.lI("");
      localcc.lJ("");
    }
  }
  
  public static void a(bid parambid, FinderItem paramFinderItem, String paramString)
  {
    AppMethodBeat.i(220288);
    p.k(parambid, "contextObj");
    p.k(paramFinderItem, "finderItem");
    p.k(paramString, "clickUsername");
    ca localca = new ca();
    localca.ly(Mp(paramFinderItem.getId()));
    localca.lz(((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr());
    localca.lA(paramFinderItem.getFeedObject().username);
    localca.lB(com.tencent.mm.model.z.bdh());
    localca.lC(paramString);
    localca.ez(parambid.xkX);
    localca.eA(paramFinderItem.getFeedObject().orgRecommendType);
    localca.eB(paramFinderItem.getFeedObject().likeCount);
    localca.eC(paramFinderItem.getFeedObject().commentCount);
    localca.bpa();
    a((com.tencent.mm.plugin.report.a)localca);
    AppMethodBeat.o(220288);
  }
  
  public static void a(bid parambid, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220202);
    p.k(parambid, "contextObj");
    p.k(paramString1, "poiText");
    p.k(paramString2, "filterTextItems");
    fh localfh = new fh();
    localfh.ua(parambid.sessionId);
    localfh.ub(parambid.wmL);
    localfh.uc(parambid.wmz);
    localfh.ng(parambid.fGo);
    localfh.ud(paramString1);
    localfh.ue(paramString2);
    localfh.nh(paramInt1);
    localfh.ni(paramInt2);
    switch (parambid.xkX)
    {
    }
    for (;;)
    {
      localfh.nk(parambid.xkX);
      localfh.bpa();
      a((com.tencent.mm.plugin.report.a)localfh);
      AppMethodBeat.o(220202);
      return;
      localfh.nj(2L);
      continue;
      localfh.nj(1L);
    }
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, long paramLong, bid parambid, int paramInt6, int paramInt7, String paramString4)
  {
    AppMethodBeat.i(220217);
    p.k(paramString1, "currUI");
    p.k(paramString3, "redDotWording");
    p.k(paramString4, "report_ext_info");
    eo localeo = new eo();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localeo.sF(str1);
    localeo.sG(paramString1);
    localeo.lX(paramInt1);
    localeo.lY(paramInt2);
    localeo.ma(paramInt3);
    long l;
    if (BuildInfo.DEBUG)
    {
      l = 0L;
      localeo.mb(l);
      localeo.lZ(paramInt4);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localeo.sH(paramString1);
      localeo.mc(paramInt5);
      localeo.sI(paramString3);
      localeo.sJ(Mp(paramLong));
      if (parambid != null)
      {
        paramString2 = parambid.wmL;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localeo.sK(paramString1);
      if (parambid != null)
      {
        paramString2 = parambid.wmz;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localeo.sL(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
        break label389;
      }
      paramLong = 2L;
      label267:
      localeo.md(paramLong);
      paramString1 = h.ag(ak.class);
      p.j(paramString1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramString1 = ((ak)paramString1).getRedDotManager();
      p.j(paramString1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!paramString1.dqI()) {
        break label395;
      }
    }
    label389:
    label395:
    for (paramLong = 1L;; paramLong = 2L)
    {
      localeo.me(paramLong);
      localeo.mf(paramInt6);
      localeo.mg(paramInt7);
      if (!Util.isNullOrNil(paramString4)) {
        localeo.sM(paramString4);
      }
      localeo.bpa();
      a((com.tencent.mm.plugin.report.a)localeo);
      AppMethodBeat.o(220217);
      return;
      l = 2L;
      break;
      paramLong = 1L;
      break label267;
    }
  }
  
  public static void a(String paramString, int paramInt, bid parambid)
  {
    AppMethodBeat.i(220186);
    p.k(paramString, "exposeFeedId");
    p.k(parambid, "contextObj");
    com.tencent.mm.plugin.report.f.Iyx.a(20585, new Object[] { paramString, Long.valueOf(com.tencent.mm.model.cm.bfE()), Integer.valueOf(paramInt), Integer.valueOf(parambid.xkX), parambid.wmz, parambid.sessionId });
    AppMethodBeat.o(220186);
  }
  
  public static void a(String paramString1, int paramInt, bid parambid, String paramString2)
  {
    AppMethodBeat.i(220469);
    p.k(paramString1, "appId");
    p.k(paramString2, "resId");
    ok localok = new ok();
    localok.Fu(paramString1);
    localok.AQ(paramInt);
    localok.Fy(paramString2);
    if (parambid != null)
    {
      localok.Fw(parambid.wmL);
      localok.AR(parambid.xkX);
      localok.Fx(parambid.wmz);
      localok.Fv(parambid.sessionId);
    }
    localok.bpa();
    a((com.tencent.mm.plugin.report.a)localok);
    AppMethodBeat.o(220469);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, bid parambid)
  {
    AppMethodBeat.i(220047);
    cy localcy = new cy();
    if (parambid != null)
    {
      localcy.oa(parambid.sessionId);
      localcy.ob(parambid.wmz);
      localcy.lv(parambid.xkX);
    }
    if (paramString2 != null)
    {
      parambid = kotlin.n.n.l(paramString2, ",", ";", false);
      paramString2 = parambid;
      if (parambid != null) {}
    }
    else
    {
      paramString2 = "";
    }
    localcy.od(paramString2);
    localcy.oc(paramString1);
    localcy.lw(paramInt1);
    localcy.ahS();
    localcy.ahT();
    localcy.lx(paramInt2);
    localcy.bpa();
    a((com.tencent.mm.plugin.report.a)localcy);
    AppMethodBeat.o(220047);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4, String paramString4, int paramInt5, int paramInt6, bid parambid)
  {
    AppMethodBeat.i(220042);
    es locales = new es();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    locales.ta(str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    locales.tb(paramString1);
    locales.mj(paramInt1);
    locales.mk(paramInt2);
    locales.tc(paramString3);
    locales.ml(paramInt3);
    locales.mm(paramInt4);
    locales.akg();
    if (parambid != null)
    {
      locales.td(parambid.sessionId);
      locales.mn(parambid.xkX);
      locales.te(parambid.wmz);
    }
    locales.tf(paramString4);
    locales.mo(paramInt5);
    locales.mp(paramInt6);
    locales.bpa();
    a((com.tencent.mm.plugin.report.a)locales);
    AppMethodBeat.o(220042);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4, String paramString4, int paramInt5, bid parambid)
  {
    AppMethodBeat.i(220036);
    er localer = new er();
    localer.sU(paramString1);
    localer.sV(paramString2);
    localer.md(paramInt1);
    localer.me(paramInt2);
    localer.sW(paramString3);
    localer.mf(paramInt3);
    localer.mg(paramInt4);
    localer.ake();
    if (parambid != null)
    {
      localer.sX(parambid.sessionId);
      localer.mh(parambid.xkX);
      localer.sY(parambid.wmz);
    }
    localer.sZ(paramString4);
    localer.akf();
    localer.mi(paramInt5);
    localer.bpa();
    a((com.tencent.mm.plugin.report.a)localer);
    AppMethodBeat.o(220036);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bid parambid)
  {
    AppMethodBeat.i(220011);
    eq localeq = new eq();
    localeq.akd();
    localeq.sR(paramString1);
    localeq.sS(paramString2);
    localeq.sT(paramString3);
    localeq.mh(paramInt1);
    localeq.mi(paramInt2);
    localeq.mk(paramInt3);
    localeq.ml(paramInt4);
    localeq.mm(paramInt5);
    if (parambid != null)
    {
      localeq.sP(parambid.sessionId);
      localeq.mj(parambid.xkX);
      localeq.sQ(parambid.wmz);
    }
    localeq.bpa();
    a((com.tencent.mm.plugin.report.a)localeq);
    AppMethodBeat.o(220011);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    AppMethodBeat.i(220253);
    com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Iyx;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    paramString3 = com.tencent.mm.ae.d.Fw(paramLong1);
    if (paramInt2 == 4) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      localf.a(21834, new Object[] { str, paramString1, paramString2, Integer.valueOf(paramInt1), paramString3, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(220253);
      return;
    }
  }
  
  public static void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.ad.i parami, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(220023);
    p.k(paramString1, "contextId");
    p.k(parami, "data");
    p.k(paramString2, "adPosId");
    try
    {
      com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
      locali.al("report_type", 1);
      locali.g("advert_group_id", parami.optString("group_id"));
      locali.g("trace_id", parami.optString("traceid"));
      Object localObject = parami.optString("apurl");
      String str = parami.optString("rl");
      if (paramBoolean2)
      {
        localObject = str;
        locali.g("report_link", localObject);
        locali.g("pos_type", parami.optString("pos_type"));
        locali.al("click_pos", 0);
        locali.al("wxa_report_detail.screen_x", paramInt3);
        locali.al("wxa_report_detail.screen_y", paramInt4);
        locali.al("ad_w", paramInt1);
        locali.al("ad_h", paramInt2);
        locali.g("pt", parami.opt("pt"));
        locali.y("viewable", paramBoolean1);
        locali.al("screen_cnt", 1);
        locali.al("from_h5", 0);
        locali.al("from_game", 0);
        if (!paramBoolean1) {
          break label413;
        }
      }
      label413:
      for (paramInt1 = i;; paramInt1 = 0)
      {
        locali.al("exposure_type", paramInt1);
        locali.al("wxa_report_detail.ad_unit_number", 1);
        locali.al("wxa_report_detail.ad_number", 1);
        locali.al("wxa_report_detail.ad_index", 0);
        locali.al("wxa_report_detail.page_enter_time", 0);
        parami = ah.AFI;
        locali.al("wxa_report_detail.phone_screen_width", ah.getScreenWidth());
        parami = ah.AFI;
        locali.al("wxa_report_detail.phone_screen_height", ah.getScreenHeight());
        locali.g("pos_id", paramString2);
        locali.g("channels_extra_data", new com.tencent.mm.ad.i().g("context_id", paramString1));
        paramString1 = locali.toString();
        p.j(paramString1, "json.toString()");
        paramString1 = new com.tencent.mm.plugin.finder.cgi.cd(paramString1);
        h.aGY().b((q)paramString1);
        AppMethodBeat.o(220023);
        return;
        break;
      }
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString1, "reportExpose", new Object[0]);
      AppMethodBeat.o(220023);
    }
  }
  
  public static void aEc(String paramString)
  {
    zWA = paramString;
  }
  
  public static void aEd(String paramString)
  {
    AppMethodBeat.i(166588);
    p.k(paramString, "username");
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramString = str + ',' + paramString;
    Log.i(TAG, "18973 ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.f.Iyx.kvStat(18973, paramString);
    AppMethodBeat.o(166588);
  }
  
  public static void aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(220464);
    p.k(paramString, "msgId");
    fc localfc = new fc();
    localfc.akw();
    localfc.mU(paramInt);
    localfc.tO(paramString);
    localfc.bpa();
    a((com.tencent.mm.plugin.report.a)localfc);
    AppMethodBeat.o(220464);
  }
  
  public static void af(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220391);
    p.k(paramString, "fromUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2;
    com.tencent.mm.plugin.report.f.Iyx.kvStat(20699, paramString);
    AppMethodBeat.o(220391);
  }
  
  public static void ai(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(220149);
    dr localdr = new dr();
    localdr.jy(paramInt1);
    localdr.jz(paramInt2);
    localdr.jA(paramInt3);
    localdr.bpa();
    a((com.tencent.mm.plugin.report.a)localdr);
    AppMethodBeat.o(220149);
  }
  
  public static void al(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220293);
    fd localfd = new fd();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localfd.tP(str1);
    localfd.mV(paramInt);
    localfd.mW(paramLong);
    localfd.bpa();
    a((com.tencent.mm.plugin.report.a)localfd);
    AppMethodBeat.o(220293);
  }
  
  public static void al(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(220334);
    p.k(paramContext, "context");
    dq localdq = new dq();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramContext = aj.a.fZ(paramContext);
    if (paramContext != null) {
      localdq.qK(paramContext.sessionId);
    }
    for (;;)
    {
      localdq.jx(paramInt);
      localdq.bpa();
      a((com.tencent.mm.plugin.report.a)localdq);
      AppMethodBeat.o(220334);
      return;
      localObject = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      localdq.qK(paramContext);
    }
  }
  
  public static void b(int paramInt, String paramString1, String paramString2, bid parambid)
  {
    AppMethodBeat.i(220053);
    p.k(paramString1, "eid");
    p.k(paramString2, "udfKv");
    ew localew = new ew();
    localew.mq(paramInt);
    localew.tk(String.valueOf(com.tencent.mm.model.cm.bfE()));
    localew.tl(paramString1);
    localew.tm(paramString2);
    if (parambid != null)
    {
      paramString2 = parambid.sessionId;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localew.th(paramString1);
      paramString2 = parambid.wmL;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localew.ti(paramString1);
      localew.tj(String.valueOf(parambid.xkX));
      paramString2 = parambid.wmz;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localew.tn(paramString1);
    }
    localew.bpa();
    a((com.tencent.mm.plugin.report.a)localew);
    AppMethodBeat.o(220053);
  }
  
  public static int bvR()
  {
    AppMethodBeat.i(220371);
    int i = 0;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(220371);
      return i;
      if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
        i = 2;
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        i = 3;
      } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
        i = 4;
      } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
        i = 5;
      }
    }
  }
  
  public static void c(FinderObject paramFinderObject, bid parambid)
  {
    AppMethodBeat.i(220474);
    p.k(paramFinderObject, "finderObject");
    if (parambid != null)
    {
      a(paramFinderObject, parambid.xkX);
      AppMethodBeat.o(220474);
      return;
    }
    AppMethodBeat.o(220474);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(220389);
    p.k(paramString, "profileUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4;
    com.tencent.mm.plugin.report.f.Iyx.kvStat(20698, paramString);
    AppMethodBeat.o(220389);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(220295);
    ds localds = new ds();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localds.qL(str1);
    localds.jB(paramInt1);
    localds.jE(0L);
    localds.jC(paramInt2);
    localds.jD(paramInt3);
    localds.qM(u.Xs(u.Xt(paramLong)));
    localds.bpa();
    a((com.tencent.mm.plugin.report.a)localds);
    AppMethodBeat.o(220295);
  }
  
  public static String dPC()
  {
    return zWA;
  }
  
  public static String dPD()
  {
    AppMethodBeat.i(220290);
    String str = UUID.randomUUID().toString();
    p.j(str, "UUID.randomUUID().toString()");
    AppMethodBeat.o(220290);
    return str;
  }
  
  public static void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(166582);
    p.k(paramString1, "fromUser");
    p.k(paramString2, "topic");
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramString1 = new StringBuilder().append((String)localObject).append(',').append(paramInt1).append(",3,").append(paramString1).append(",0,,");
    localObject = ag.AFH;
    paramString1 = ag.ek(paramString2, paramInt2);
    com.tencent.mm.plugin.report.f.Iyx.kvStat(18944, paramString1);
    AppMethodBeat.o(166582);
  }
  
  public static void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(220343);
    p.k(paramString1, "tipsId");
    p.k(paramString2, "revokeId");
    em localem = new em();
    localem.lH(paramInt1);
    localem.lI(com.tencent.mm.model.cm.bfF());
    localem.sr(paramString1);
    localem.ss(paramString2);
    paramString1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() == 1) {}
    for (long l = 2L;; l = 1L)
    {
      localem.lJ(l);
      localem.lK(paramInt2);
      localem.bpa();
      a((com.tencent.mm.plugin.report.a)localem);
      AppMethodBeat.o(220343);
      return;
    }
  }
  
  public static void f(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(220432);
    p.k(paramContext, "context");
    Object localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramContext = aj.a.fZ(paramContext);
    eh localeh;
    if (paramContext != null)
    {
      paramContext = paramContext.ekY();
      localeh = new eh();
      if (paramContext == null) {
        break label173;
      }
      localObject1 = paramContext.sessionId;
      label54:
      localeh.rW((String)localObject1);
      if (paramContext == null) {
        break label179;
      }
      localObject1 = paramContext.wmz;
      label72:
      localeh.rX((String)localObject1);
      if (paramContext == null) {
        break label185;
      }
    }
    label173:
    label179:
    label185:
    for (long l = paramContext.xkX;; l = 0L)
    {
      localeh.lo(l);
      localeh.rZ(String.valueOf(System.currentTimeMillis()));
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = paramContext.wmL;
      }
      localeh.rY((String)localObject1);
      localeh.lp(paramInt1);
      localeh.lq(paramInt2);
      localeh.bpa();
      a((com.tencent.mm.plugin.report.a)localeh);
      AppMethodBeat.o(220432);
      return;
      paramContext = null;
      break;
      localObject1 = null;
      break label54;
      localObject1 = null;
      break label72;
    }
  }
  
  public static String fC(Context paramContext)
  {
    AppMethodBeat.i(220366);
    p.k(paramContext, "context");
    int i = 0;
    if ((paramContext instanceof MMFragmentActivity))
    {
      g localg = g.Xox;
      i = ((FinderHomeUIC)g.b((AppCompatActivity)paramContext).i(FinderHomeUIC.class)).ekL();
    }
    switch (i)
    {
    default: 
      paramContext = "2";
    }
    for (;;)
    {
      AppMethodBeat.o(220366);
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
  
  public static void g(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166586);
    p.k(paramFinderItem, "finderItem");
    FinderObject localFinderObject = paramFinderItem.getFinderObject();
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramFinderItem = str + ',' + Mp(localFinderObject.id) + ',' + localFinderObject.username + ',' + paramFinderItem.getMediaType() + ',' + localFinderObject.recommendType + ',' + localFinderObject.likeCount + ',' + localFinderObject.commentCount + ',' + localFinderObject.friendLikeCount;
    Log.i(TAG, "18950 ".concat(String.valueOf(paramFinderItem)));
    com.tencent.mm.plugin.report.f.Iyx.kvStat(18950, paramFinderItem);
    AppMethodBeat.o(166586);
  }
  
  public static void gQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220299);
    et localet = new et();
    localet.mn(paramInt1);
    localet.mo(paramInt2);
    localet.bpa();
    a((com.tencent.mm.plugin.report.a)localet);
    AppMethodBeat.o(220299);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static ao h(long paramLong, int paramInt)
  {
    AppMethodBeat.i(219982);
    ao localao = (ao)zWC.get(paramLong + '_' + paramInt);
    AppMethodBeat.o(219982);
    return localao;
  }
  
  public static void h(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(220280);
    p.k(paramFinderItem, "finderItem");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null)
    {
      dz localdz = new dz();
      localdz.rj(Mp(paramFinderItem.getId()));
      localdz.rk(((FinderFeedReportObject)localObject).sessionId);
      localdz.rl(paramFinderItem.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.e.ACV;
      localdz.rm(kotlin.n.n.l(com.tencent.mm.plugin.finder.utils.e.y(paramFinderItem), ",", ";", false));
      localdz.bpa();
      a((com.tencent.mm.plugin.report.a)localdz);
      AppMethodBeat.o(220280);
      return;
    }
    AppMethodBeat.o(220280);
  }
  
  public static void hi(String paramString1, String paramString2)
  {
    long l2 = 1L;
    AppMethodBeat.i(220258);
    p.k(paramString1, "contextId");
    ar localar = new ar();
    localar.jq(paramString1);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = "";
    }
    localar.jp(paramString1);
    paramString1 = g.Xox;
    paramString1 = g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    p.j(paramString1, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    paramString1 = (com.tencent.mm.plugin.finder.viewmodel.b)paramString1;
    localar.cD(paramString1.ekb());
    localObject = g.Xox;
    localObject = g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class);
    p.j(localObject, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    localObject = (com.tencent.mm.plugin.finder.viewmodel.a)localObject;
    long l1;
    if (com.tencent.mm.plugin.finder.viewmodel.a.ejZ())
    {
      l1 = 1L;
      localar.cy(l1);
      if (((com.tencent.mm.plugin.finder.viewmodel.a)localObject).Bgf == null) {
        break label250;
      }
      localar.cx(1L);
      label171:
      if (paramString2 == null) {
        break label260;
      }
      localar.cw(1L);
      localar.jo(paramString2);
      localar.cC(0L);
      localar.cB(0L);
      localar.cz(0L);
      localar.cA(0L);
      localar.cE(1L);
    }
    for (;;)
    {
      localar.bpa();
      a((com.tencent.mm.plugin.report.a)localar);
      AppMethodBeat.o(220258);
      return;
      l1 = 0L;
      break;
      label250:
      localar.cx(0L);
      break label171;
      label260:
      localar.cw(0L);
      localar.jo("");
      l1 = l2;
      if (paramString1.OO(paramString1.ekb())) {
        l1 = 2L;
      }
      localar.cE(l1);
      localar.cz(kotlin.k.i.be(paramString1.RI(3).Bgy, 0L));
      localar.cB(kotlin.k.i.be(paramString1.RI(2).Bgy, 0L));
      localar.cA(kotlin.k.i.be(paramString1.RI(1).Bgy, 0L));
      localar.cC(kotlin.k.i.be(paramString1.RI(4).Bgy, 0L));
    }
  }
  
  public static void hj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178396);
    p.k(paramString1, "contextId");
    p.k(paramString2, "action");
    fi localfi = new fi();
    localfi.ug(paramString1);
    localfi.uf(paramString2);
    localfi.nl(com.tencent.mm.model.cm.bfE());
    paramString2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localfi.uh(paramString1);
    if (BuildInfo.DEBUG) {}
    for (long l = 0L;; l = 1L)
    {
      localfi.nm(l);
      localfi.bpa();
      a((com.tencent.mm.plugin.report.a)localfi);
      AppMethodBeat.o(178396);
      return;
    }
  }
  
  public static void j(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(220480);
    p.k(paramContext, "context");
    Object localObject = g.Xox;
    paramContext = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.lm(paramContext).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    localObject = new ew();
    ((ew)localObject).th(paramContext.sessionId);
    ((ew)localObject).ti(paramContext.wmL);
    ((ew)localObject).tj(String.valueOf(paramContext.xkX));
    ((ew)localObject).mq(0);
    ((ew)localObject).tl("textstatus_in_menu");
    ((ew)localObject).tk(String.valueOf(com.tencent.mm.model.cm.bfE()));
    ((ew)localObject).tm(new com.tencent.mm.ad.i().g("feedid", com.tencent.mm.ae.d.Fw(paramLong)).toString());
    ((ew)localObject).bpa();
    AppMethodBeat.o(220480);
  }
  
  public static void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166584);
    p.k(paramString1, "author");
    p.k(paramString2, "receiver");
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramString1 = str + ',' + paramString1 + ',' + paramString2 + ',' + 0 + ',' + paramInt1 + ',' + paramInt2;
    Log.i(TAG, "18949 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.f.Iyx.kvStat(18949, paramString1);
    AppMethodBeat.o(166584);
  }
  
  public static String l(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(220473);
    StringBuilder localStringBuilder = new StringBuilder("");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((String)paramList.next()).append(paramString);
    }
    paramList = localStringBuilder.toString();
    p.j(paramList, "builder.toString()");
    paramList = kotlin.n.n.c(paramList, (CharSequence)paramString);
    AppMethodBeat.o(220473);
    return paramList;
  }
  
  public static void l(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(219987);
    p.k(paramFinderObject, "finderObject");
    if (paramFinderObject.client_local_buffer == null)
    {
      paramFinderObject.client_local_buffer = new bfu();
      paramFinderObject = paramFinderObject.client_local_buffer;
      if (paramFinderObject != null)
      {
        paramFinderObject.SQz = com.tencent.mm.model.cm.bfD();
        AppMethodBeat.o(219987);
        return;
      }
    }
    AppMethodBeat.o(219987);
  }
  
  public static void m(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166585);
    p.k(paramFinderObject, "finderObject");
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    paramFinderObject = str + ',' + 1 + ',' + Mp(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.recommendType;
    Log.i(TAG, "18953 ".concat(String.valueOf(paramFinderObject)));
    com.tencent.mm.plugin.report.f.Iyx.kvStat(18953, paramFinderObject);
    AppMethodBeat.o(166585);
  }
  
  public final void a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(220078);
    p.k(paramString, "fromUser");
    a(paramLong, paramInt1, 1L, paramString, paramInt2, paramInt3);
    AppMethodBeat.o(220078);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt3, String paramString5, int paramInt4)
  {
    AppMethodBeat.i(220206);
    p.k(paramString1, "currUI");
    p.k(paramString2, "redDotId");
    p.k(paramString3, "redDotWording");
    p.k(paramString4, "contextId");
    p.k(paramString5, "report_ext_info");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(220206);
        return;
      case -1: 
      case 1002: 
        paramInt1 = 2;
        i = 1;
        paramInt3 = 6;
      }
    }
    for (;;)
    {
      localObject = new bid();
      ((bid)localObject).wmL = paramString4;
      ((bid)localObject).wmz = "";
      a(paramString1, paramInt1, paramInt2, paramInt3, i, 0, paramString2, paramString3, paramLong, (bid)localObject, paramInt4, paramString5);
      AppMethodBeat.o(220206);
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
        AppMethodBeat.o(220206);
        return;
      case -1: 
      case 1002: 
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.n
 * JD-Core Version:    0.7.0.1
 */