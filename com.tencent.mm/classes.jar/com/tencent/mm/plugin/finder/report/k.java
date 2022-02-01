package com.tencent.mm.plugin.finder.report;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ai;
import com.tencent.mm.g.b.a.bb;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.g.b.a.bf;
import com.tencent.mm.g.b.a.bk;
import com.tencent.mm.g.b.a.bl;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.g.b.a.bs;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.g.b.a.bz;
import com.tencent.mm.g.b.a.cc;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.g.b.a.ci;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.cu;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.g.b.a.cx;
import com.tencent.mm.g.b.a.cz;
import com.tencent.mm.g.b.a.da;
import com.tencent.mm.g.b.a.db;
import com.tencent.mm.g.b.a.dd;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.b.a.dp;
import com.tencent.mm.g.b.a.ds;
import com.tencent.mm.g.b.a.du;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.g.b.a.dx;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.b.a.ef;
import com.tencent.mm.g.b.a.eg;
import com.tencent.mm.g.b.a.eh;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.g.b.a.gu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.live.h;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMFragmentActivity;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.u;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.NetworkUtil;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TWO_64", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFinderFeedCgiFetchTimeMap", "()Landroid/util/SparseArray;", "finderFeedFetchTimeMap", "Landroid/util/LongSparseArray;", "getFinderFeedFetchTimeMap", "()Landroid/util/LongSparseArray;", "megaVideoFeedFetchTimeMap", "getMegaVideoFeedFetchTimeMap", "megaVideoSessionBufferMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getMegaVideoSessionBufferMap", "()Ljava/util/HashMap;", "searchSessionId", "getSearchSessionId", "setSearchSessionId", "(Ljava/lang/String;)V", "sessionBufferMap", "getSessionBufferMap", "setSessionBufferMap", "(Ljava/util/HashMap;)V", "asUnsignedDecimalString", "l", "finderAvatarClick19405", "", "clickAvatarScene", "", "feedId", "commentScene", "finderRole", "clickFinderUsername", "finderBackToTop19995", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "tabType", "finderChangeRoleClick", "roleBeforeSwitch", "finderClickEntrance19025", "contextId", "redDotId", "finderClickMoreReport", "scene", "finderClickTopic19186", "topic", "topicType", "topicFeedCount", "finderClickTopicFeedReport", "finderCommentFlagReport", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderCreateContactReport", "success", "hadAvatar", "addSignature", "", "hadWechatCity", "hadWechatSex", "createScene", "wxProfile", "changeName", "finderDistrictAlertClick", "username", "finderExposeFeedReport", "finderFavReport", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "finderHotSearchReport", "itemId", "position", "accountType", "actionType", "finderLocationRequest19954", "context", "Landroid/content/Context;", "finderMegaVideoShareReport", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "shareType", "forwardResult", "receiver", "forwardUsrCount", "finderRealLikeAction19956", "finderRealLikeExpose19955", "exposeItems", "totalCount", "enterContextId", "finderRealLikeUserModify19957", "addUsernames", "delUsernames", "enterCount", "finderRedDot18948", "currUI", "redDotType", "showType", "redDotSubType", "count", "redDotWording", "currentTabType", "autoClick", "report_ext_info", "redDotBizType", "finderRedDotRevoke20223", "ctrType", "tipsId", "revokeId", "revokeStatus", "finderReportClickMention", "clickUsername", "finderReportEnterAtTimeline", "finderReportFav", "opType", "finderReportFlowClick19993", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "finderReportFollow", "finderUsername", "finderReportHitTabClick19998", "messageType", "index", "finderReportLikeAndComment", "likeAction", "replyUsername", "userScene", "isShowRecWording", "isPrivateAccount", "feedContentType", "megaVideoId", "finderReportMsgItemClick", "type", "isOverlap", "overlapCount", "finderReportOpenDrawer", "clickTabContextId", "clickType", "finderReportPostMentionInfo", "finderReportSysMsgClick", "redDotCount", "finderReportTabChange", "fromTab", "toTab", "source", "finderSaveNameCard", "finderSearchActionReport", "requestId", "query", "searchScene", "searchType", "searchResultType", "accountIsNull", "feedIsNull", "finderSearchClickReport", "requestType", "itemType", "finderSearchNewClickReport", "finderSelfUIEventReport", "enterTimeStamp", "redDotExistOnEnter", "eventType", "bannerType", "isHaveRedDot", "msgCnt", "finderSettingClickReport", "settingType", "finderSettingInfoEventReport", "hasReddot", "finderShareActivityReport", "forwardType", "activityId", "finderShareAlbumClickReport", "fromUser", "cardId", "finderShareAlbumReport", "finderShareFeedClick18944", "cardType", "isCgiEnd", "uiType", "finderShareFeedReport", "localFeedItem", "finderShareNameCardClickReport", "nameCardUser", "finderShareNameCardReport", "author", "followCount", "authType", "finderShareTopicClickReport", "finderShareTopicReport", "finderSubCommentExpand", "rootComment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "expandType", "finderTimelineMoreAction", "isFloat", "finderTraceAction", "finderUnlikeFeedReport", "page", "unlikeType", "finderVoiceFlagReport", "getCurrentTabRedDotUI", "getFeedCigFetchTime", "getFinderFeedFetchTime", "getFinderItem", "getFinderItemSessionBuffer", "getMegaVideoFetchTime", "getMegaVideoItem", "getMegaVideoItemSessionBuffer", "getReportNetTypeInt", "isMegaVideoComment", "newUUID", "optWxSubRedDotType", "commentCount", "likeCount", "likeLikeCount", "recommendLikeCount", "putFeedCgiFetchTime", "putFinderItemSessionBuffer", "sessionBuffer", "putMegaVideoItemSessionBuffer", "report20044", "isExplose", "clickAction", "isCollapse", "isTopic", "report20698", "profileUsername", "time", "profileType", "profileView", "report20699", "fromUsername", "report20717", "tabContextId", "sessionId", "actionScene", "report21077", "outcome", "(Landroid/content/Context;IILjava/lang/Integer;)V", "report21172", "profileUserName", "profileBizUin", "report21188", "isFirstOpen", "clickscene", "clickId", "appId", "preWarmPath", "ispresend", "ispreload", "liveid", "finderid", "shopwindowid", "sessionid", "report21206", "isSelf", "eventTarget", "report21235", "appuin", "report21237", "prewarmstartime", "prewarmendtime", "appVersion", "report21313", "liveRole", "shop", "prerenderType", "postTime", "shareLiveTime", "joinLiveTime", "enterRoomTime", "liveStates", "uiStates", "statistics", "cgiErrcode", "cgiErrtype", "cgiErrmsg", "liveEventCode", "liveEventSubCode", "liveEventMsg", "extra", "snn", "networkQuality", "report21345", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JLjava/lang/Integer;)V", "report21726", "report21834", "enterMs", "exitMs", "reason", "report21837", "setting", "report21851", "eventCode", "report21923", "target", "report22116", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Action;", "dynamicState", "poiClassifyId", "poiDetail", "sourceId", "duration", "reportDailyPaper", "paperId", "paperWording", "clickable", "reportExposeHotCard20585", "exposeFeedId", "posId", "reportIDKeyVideoPlayError", "what", "reportJumpHotCard20586", "actionFeedId", "actionFeedIndex", "totalFeedId", "reportPoiFilter19996", "poiText", "filterTextItems", "hasUnfoldBtn", "isUnfoldBtnClick", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "transformCommentSceneToTabType", "transformTabIndexToTabType", "tabIndex", "transformTabTypeToCommentScene", "plugin-finder_release"})
public final class k
{
  public static final String TAG = "Finder.FinderReportLogic";
  private static final BigInteger TWO_64;
  public static final k vfA;
  private static String vfu;
  private static final LongSparseArray<Long> vfv;
  private static HashMap<String, String> vfw;
  private static final LongSparseArray<Long> vfx;
  private static final HashMap<String, String> vfy;
  private static final SparseArray<Long> vfz;
  
  static
  {
    AppMethodBeat.i(166595);
    vfA = new k();
    TAG = "Finder.FinderReportLogic";
    vfu = "";
    vfv = new LongSparseArray();
    vfw = new HashMap();
    vfx = new LongSparseArray();
    vfy = new HashMap();
    vfz = new SparseArray();
    TWO_64 = BigInteger.ONE.shiftLeft(64);
    AppMethodBeat.o(166595);
  }
  
  public static FinderItem Fc(long paramLong)
  {
    AppMethodBeat.i(166576);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
    Object localObject2 = e.a.Fy(paramLong);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = i.vvu;
      localObject1 = (FinderItem)i.dqb().get(Long.valueOf(paramLong));
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = FinderTopicFeedUI.udw;
      localObject2 = (FinderItem)FinderTopicFeedUI.ddO().get(Long.valueOf(paramLong));
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = FinderAtTimelineUI.tZp;
      localObject1 = (FinderItem)FinderAtTimelineUI.ddO().get(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(166576);
    return localObject1;
  }
  
  public static com.tencent.mm.plugin.finder.model.bm Fd(long paramLong)
  {
    AppMethodBeat.i(250628);
    Object localObject = com.tencent.mm.plugin.finder.storage.data.e.vFX;
    localObject = e.a.FD(paramLong);
    if (localObject != null)
    {
      localObject = new com.tencent.mm.plugin.finder.model.bm((FinderObject)localObject);
      AppMethodBeat.o(250628);
      return localObject;
    }
    AppMethodBeat.o(250628);
    return null;
  }
  
  public static long Fe(long paramLong)
  {
    AppMethodBeat.i(250631);
    Long localLong = (Long)vfv.get(paramLong);
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(250631);
      return paramLong;
    }
    AppMethodBeat.o(250631);
    return 0L;
  }
  
  public static long Ff(long paramLong)
  {
    AppMethodBeat.i(250632);
    Long localLong = (Long)vfx.get(paramLong);
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(250632);
      return paramLong;
    }
    AppMethodBeat.o(250632);
    return 0L;
  }
  
  public static String Fg(long paramLong)
  {
    AppMethodBeat.i(166591);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(TWO_64);
    }
    localObject = ((BigInteger)localObject).toString();
    p.g(localObject, "b.toString()");
    AppMethodBeat.o(166591);
    return localObject;
  }
  
  public static String G(long paramLong, int paramInt)
  {
    AppMethodBeat.i(250629);
    String str2 = (String)vfw.get(paramLong + '_' + paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(250629);
    return str1;
  }
  
  public static String H(long paramLong, int paramInt)
  {
    AppMethodBeat.i(250630);
    String str = (String)vfy.get(paramLong + '_' + paramInt);
    AppMethodBeat.o(250630);
    return str;
  }
  
  public static void I(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166577);
    FinderItem localFinderItem = Fc(paramLong);
    if (localFinderItem != null)
    {
      bb localbb = new bb();
      String str2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localbb.iI(str1);
      localbb.iJ(com.tencent.mm.ac.d.zs(localFinderItem.getId()));
      localbb.dc(paramInt);
      localbb.cX(localFinderItem.getLikeCount());
      localbb.cY(localFinderItem.getCommentCount());
      localbb.cZ(localFinderItem.getFriendLikeCount());
      localbb.db(localFinderItem.getMediaType());
      localbb.iK("");
      localbb.da(paramInt);
      localbb.bfK();
      a((com.tencent.mm.plugin.report.a)localbb);
      AppMethodBeat.o(166577);
      return;
    }
    AppMethodBeat.o(166577);
  }
  
  public static void J(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166580);
    FinderItem localFinderItem = Fc(paramLong);
    if (localFinderItem != null)
    {
      dn localdn = new dn();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localdn.pg((String)localObject);
      localdn.kk(paramInt);
      localObject = w.vXp;
      localdn.ph(n.j(w.z(localFinderItem), ",", ";", false));
      localdn.pi("");
      localdn.pj(Fg(localFinderItem.getId()));
      localdn.kl(localFinderItem.getFeedObject().likeCount);
      localdn.bfK();
      a((com.tencent.mm.plugin.report.a)localdn);
      AppMethodBeat.o(166580);
      return;
    }
    AppMethodBeat.o(166580);
  }
  
  public static long Kt(int paramInt)
  {
    AppMethodBeat.i(250635);
    Long localLong = (Long)vfz.get(paramInt);
    if (localLong != null)
    {
      long l = localLong.longValue();
      AppMethodBeat.o(250635);
      return l;
    }
    AppMethodBeat.o(250635);
    return 0L;
  }
  
  public static void Ku(int paramInt)
  {
    AppMethodBeat.i(250636);
    vfz.put(paramInt, Long.valueOf(cl.aWA()));
    AppMethodBeat.o(250636);
  }
  
  public static void Kv(int paramInt)
  {
    AppMethodBeat.i(166594);
    switch (paramInt)
    {
    default: 
      locala = x.vig;
      x.a.pl(x.doN());
      AppMethodBeat.o(166594);
      return;
    case -1010: 
      locala = x.vig;
      x.a.pl(x.doA());
      AppMethodBeat.o(166594);
      return;
    case -1007: 
      locala = x.vig;
      x.a.pl(x.doB());
      AppMethodBeat.o(166594);
      return;
    case -1004: 
      locala = x.vig;
      x.a.pl(x.doC());
      AppMethodBeat.o(166594);
      return;
    case -10012: 
      locala = x.vig;
      x.a.pl(x.doD());
      AppMethodBeat.o(166594);
      return;
    case -10004: 
      locala = x.vig;
      x.a.pl(x.doE());
      AppMethodBeat.o(166594);
      return;
    case -21009: 
      locala = x.vig;
      x.a.pl(x.doF());
      AppMethodBeat.o(166594);
      return;
    case -21020: 
      locala = x.vig;
      x.a.pl(x.doG());
      AppMethodBeat.o(166594);
      return;
    case 404: 
      locala = x.vig;
      x.a.pl(x.doH());
      AppMethodBeat.o(166594);
      return;
    case 403: 
      locala = x.vig;
      x.a.pl(x.doI());
      AppMethodBeat.o(166594);
      return;
    case 503: 
      locala = x.vig;
      x.a.pl(x.doJ());
      AppMethodBeat.o(166594);
      return;
    case 502: 
      locala = x.vig;
      x.a.pl(x.doK());
      AppMethodBeat.o(166594);
      return;
    case 416: 
      locala = x.vig;
      x.a.pl(x.doL());
      AppMethodBeat.o(166594);
      return;
    }
    x.a locala = x.vig;
    x.a.pl(x.doM());
    AppMethodBeat.o(166594);
  }
  
  public static int Kw(int paramInt)
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
  
  public static int Kx(int paramInt)
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
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(250674);
    db localdb = new db();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localdb.oi(str1);
    localdb.iH(paramInt1);
    localdb.iK(paramInt2);
    localdb.iI(paramInt3);
    localdb.iJ(paramInt4);
    localdb.oj(u.Pb(u.Pc(paramLong)));
    localdb.bfK();
    a((com.tencent.mm.plugin.report.a)localdb);
    AppMethodBeat.o(250674);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, int paramInt5, String paramString1, int paramInt6, int paramInt7, String paramString2, int paramInt8, int paramInt9, String paramString3, String paramString4, String paramString5, long paramLong5, long paramLong6)
  {
    AppMethodBeat.i(250699);
    p.h(paramString1, "statistics");
    p.h(paramString2, "cgiErrmsg");
    p.h(paramString3, "liveEventMsg");
    p.h(paramString4, "extra");
    p.h(paramString5, "snn");
    cx localcx = new cx();
    if (BuildInfo.DEBUG) {}
    for (long l = 0L;; l = 1L)
    {
      localcx.iv(l);
      localcx.kq(paramInt1);
      localcx.kr(paramInt2);
      localcx.ks(paramInt3);
      h localh = h.ufY;
      localcx.kt(h.deY());
      localcx.iw(paramLong1);
      localcx.ix(paramLong2);
      localcx.iy(paramLong3);
      localcx.iz(paramLong4);
      localcx.ku(paramInt4);
      localcx.kv(paramInt5);
      localcx.nV(n.j(paramString1, ",", ";", false));
      localcx.kw(paramInt6);
      localcx.kx(paramInt7);
      localcx.nW(paramString2);
      localcx.ky(paramInt8);
      localcx.kz(paramInt9);
      localcx.nX(paramString3);
      localcx.nY(paramString4);
      localcx.nZ(paramString5);
      localcx.iA(paramLong5);
      localcx.iB(paramLong6);
      localcx.oa(MD5Util.getMD5String(com.tencent.mm.model.z.aTY() + com.tencent.mm.model.z.aUa() + paramLong1));
      localcx.bfK();
      a((com.tencent.mm.plugin.report.a)localcx);
      AppMethodBeat.o(250699);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, bbn parambbn)
  {
    AppMethodBeat.i(250653);
    p.h(parambbn, "contextObj");
    ci localci = new ci();
    localci.fT(parambbn.tCE);
    localci.lL(parambbn.sessionId);
    localci.lM(parambbn.sGQ);
    localci.lN(parambbn.sGE);
    localci.lL(parambbn.sessionId);
    localci.fV(cl.aWA());
    localci.fU(paramInt1);
    localci.fW(paramInt2);
    localci.fX(paramInt3);
    localci.adf();
    localci.bfK();
    a((com.tencent.mm.plugin.report.a)localci);
    AppMethodBeat.o(250653);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    AppMethodBeat.i(250652);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    localObject = new StringBuilder().append((String)localObject).append(',').append(paramInt1).append(',').append(paramInt2).append(',').append(paramInt3).append(',');
    if (paramBoolean1)
    {
      paramInt1 = 1;
      localObject = ((StringBuilder)localObject).append(paramInt1).append(',').append(paramInt4).append(',').append(paramInt5).append(',').append(paramInt6).append(',');
      if (!paramBoolean2) {
        break label199;
      }
      paramInt1 = 1;
      label127:
      localObject = ((StringBuilder)localObject).append(paramInt1).append(',');
      if (!paramBoolean3) {
        break label204;
      }
    }
    label199:
    label204:
    for (paramInt1 = i;; paramInt1 = 1)
    {
      localObject = paramInt1;
      Log.i(TAG, "18947 ".concat(String.valueOf(localObject)));
      com.tencent.mm.plugin.report.e.Cxv.kvStat(18947, (String)localObject);
      AppMethodBeat.o(250652);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label127;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, bbn parambbn, int paramInt3)
  {
    long l2 = 0L;
    AppMethodBeat.i(250676);
    p.h(parambbn, "contextObj");
    bz localbz = new bz();
    long l1;
    if (paramInt1 > 0)
    {
      l1 = paramInt1;
      localbz.fi(l1);
      l1 = l2;
      if (paramInt2 > 0) {
        l1 = paramInt2;
      }
      localbz.fj(l1);
      localbz.fk(cl.aWA());
      localbz.kF(parambbn.sessionId);
      localbz.kH(parambbn.sGQ);
      localbz.kG(parambbn.sGE);
      localbz.fl(paramInt3);
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localbz.bfK();
      a((com.tencent.mm.plugin.report.a)localbz);
      parambbn = g.aAh();
      p.g(parambbn, "MMKernel.storage()");
      parambbn.azQ().set(ar.a.Onc, localbz.acW());
      if (paramInt2 != 2)
      {
        parambbn = g.aAh();
        p.g(parambbn, "MMKernel.storage()");
        parambbn.azQ().set(ar.a.Ond, localbz.acW());
      }
      Log.i(TAG, "finderReportTabChange clickTabContextId [%s] toTab[%d]", new Object[] { localbz.acW(), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(250676);
      return;
      l1 = 0L;
      break;
      parambbn = g.ah(PluginFinder.class);
      p.g(parambbn, "MMKernel.plugin(PluginFinder::class.java)");
      if (((PluginFinder)parambbn).getRedDotManager().asW("TLFollow") != null)
      {
        localbz.acX();
        continue;
        parambbn = g.ah(PluginFinder.class);
        p.g(parambbn, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)parambbn).getRedDotManager().asW("TLRecommendTab") != null)
        {
          localbz.acX();
          continue;
          parambbn = g.ah(PluginFinder.class);
          p.g(parambbn, "MMKernel.plugin(PluginFinder::class.java)");
          if (((PluginFinder)parambbn).getRedDotManager().asW("finder_tl_hot_tab") != null)
          {
            localbz.acX();
            continue;
            parambbn = g.ah(PluginFinder.class);
            p.g(parambbn, "MMKernel.plugin(PluginFinder::class.java)");
            if (((PluginFinder)parambbn).getRedDotManager().asW("finder_tl_nearby_tab") != null) {
              localbz.acX();
            }
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    long l = 1L;
    AppMethodBeat.i(250668);
    bv localbv = new bv();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbv.kk(str1);
    localbv.kn(Fg(paramLong));
    localbv.eN(paramInt1);
    localbv.eM(paramInt2);
    switch (paramInt2)
    {
    default: 
      localbv.eJ(2L);
    }
    for (;;)
    {
      localbv.eI(paramInt3);
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      localbv.kl(str1);
      localbv.km(com.tencent.mm.model.z.aUg());
      paramString = Fc(paramLong);
      if (paramString != null)
      {
        localbv.eK(paramString.getLikeCount());
        localbv.eL(paramString.getCommentCount());
      }
      paramLong = l;
      if (BuildInfo.DEBUG) {
        paramLong = 0L;
      }
      localbv.eO(paramLong);
      localbv.bfK();
      a((com.tencent.mm.plugin.report.a)localbv);
      AppMethodBeat.o(250668);
      return;
      localbv.eJ(1L);
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, bbn parambbn)
  {
    AppMethodBeat.i(250656);
    p.h(paramString1, "actionFeedId");
    p.h(paramString2, "totalFeedId");
    p.h(parambbn, "contextObj");
    com.tencent.mm.plugin.report.e.Cxv.a(20586, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), Long.valueOf(cl.aWA()), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(parambbn.tCE), parambbn.sGE, parambbn.sessionId });
    AppMethodBeat.o(250656);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(250666);
    FinderItem localFinderItem = Fc(paramLong);
    if (localFinderItem != null)
    {
      bn localbn = new bn();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbn.jF((String)localObject);
      localbn.jG("");
      localbn.jH(Fg(paramLong));
      localbn.jI(localFinderItem.getUserName());
      localbn.eh(localFinderItem.getLikeCount());
      localbn.ei(localFinderItem.getCommentCount());
      localbn.ej(localFinderItem.getFriendLikeCount());
      localbn.jW(paramInt2);
      localbn.ek(paramInt1);
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsr().value()).intValue() == 1) {}
      for (paramLong = 1L;; paramLong = 0L)
      {
        localbn.el(paramLong);
        localbn.jJ(paramString1);
        localbn.jK(paramString2);
        localbn.bfK();
        a((com.tencent.mm.plugin.report.a)localbn);
        AppMethodBeat.o(250666);
        return;
      }
    }
    AppMethodBeat.o(250666);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(166579);
    p.h(paramString1, "topic");
    p.h(paramString2, "receiver");
    eh localeh = new eh();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localeh.qR((String)localObject);
    localeh.lP(paramInt1);
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localeh.lQ(l);
      localObject = w.vXp;
      localeh.qS(n.j(w.z(paramString1, paramInt2, paramLong), ",", ";", false));
      localeh.qT("");
      localeh.lR(paramLong);
      localeh.qU(paramString2);
      localeh.bfK();
      a((com.tencent.mm.plugin.report.a)localeh);
      AppMethodBeat.o(166579);
      return;
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean, String paramString1, long paramLong, String paramString2, bbn parambbn)
  {
    AppMethodBeat.i(250642);
    p.h(paramString1, "receiver");
    cf localcf = new cf();
    if (parambbn != null)
    {
      l = parambbn.tCE;
      localcf.fP(l);
      localcf.fJ(paramInt);
      if (!paramBoolean) {
        break label313;
      }
    }
    label260:
    label313:
    for (long l = 1L;; l = 2L)
    {
      localcf.fK(l);
      localcf.fQ(paramLong);
      localcf.lu(paramString1);
      String str;
      if (parambbn != null)
      {
        str = parambbn.sessionId;
        paramString1 = str;
        if (str != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localcf.lr(paramString1);
      if (parambbn != null)
      {
        str = parambbn.sGE;
        paramString1 = str;
        if (str != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localcf.ly(paramString1);
      if (parambbn != null)
      {
        str = parambbn.sGQ;
        paramString1 = str;
        if (str != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localcf.lz(paramString1);
      if (parambbn != null)
      {
        paramString1 = parambbn.extraInfo;
        if (paramString1 != null)
        {
          str = n.j(paramString1, ",", ";", false);
          paramString1 = str;
          if (str != null) {
            break label213;
          }
        }
      }
      paramString1 = "";
      label213:
      localcf.lB(paramString1);
      if (parambbn != null)
      {
        paramString1 = parambbn.sGH;
        if (paramString1 != null)
        {
          parambbn = n.j(paramString1, ",", ";", false);
          paramString1 = parambbn;
          if (parambbn != null) {
            break label260;
          }
        }
      }
      paramString1 = "";
      localcf.lC(paramString1);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localcf.lG(paramString1);
      localcf.bfK();
      a((com.tencent.mm.plugin.report.a)localcf);
      AppMethodBeat.o(250642);
      return;
      l = 0L;
      break;
    }
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(250693);
    paramString1 = com.tencent.mm.ac.d.zs(paramLong) + ',' + paramInt1 + ',' + paramInt2 + ',' + Util.nullAsNil(paramString1) + ',' + Util.nullAsNil(paramString2) + ',' + Util.nullAsNil(paramString3) + ',' + Util.nullAsNil(paramString4) + ',' + paramInt3;
    com.tencent.mm.plugin.report.e.Cxv.kvStat(20717, paramString1);
    AppMethodBeat.o(250693);
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(250646);
    p.h(paramString1, "fromUser");
    bq localbq = new bq();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbq.jP((String)localObject);
    localbq.eq(paramInt1);
    localbq.er(paramLong2);
    localbq.jQ(paramString1);
    localbq.jR(Fg(paramLong1));
    localbq.et(paramInt2);
    localbq.eu(paramInt3);
    if (paramString2 != null) {
      localbq.jW(paramString2);
    }
    paramString2 = Fc(paramLong1);
    if (paramString2 != null)
    {
      localbq.jS(paramString2.getFeedObject().username);
      paramString1 = w.vXp;
      localbq.jT(n.j(w.z(paramString2), ",", ";", false));
      localObject = (Iterable)paramString2.getMediaList();
      paramString1 = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        if (Util.isNullOrNil(((cjl)((Iterator)localObject).next()).coverUrl)) {}
        for (paramLong1 = 0L;; paramLong1 = 1L)
        {
          localbq.es(paramLong1);
          paramString1.add(kotlin.x.SXb);
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
      localbq.jU(paramString1);
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
      paramString1 = paramString1.wWb;
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
      localbq.ev(paramLong1);
      localbq.bfK();
      a((com.tencent.mm.plugin.report.a)localbq);
      AppMethodBeat.o(250646);
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
  
  public static void a(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3, bbn parambbn)
  {
    AppMethodBeat.i(250651);
    p.h(paramString, "receiver");
    cf localcf = new cf();
    long l;
    String str;
    if (parambbn != null)
    {
      l = parambbn.tCE;
      localcf.fP(l);
      localcf.fJ(paramInt);
      localcf.fK(paramLong2);
      localcf.fQ(paramLong3);
      localcf.lu(paramString);
      if (parambbn != null)
      {
        str = parambbn.sessionId;
        paramString = str;
        if (str != null) {}
      }
      else
      {
        paramString = "";
      }
      localcf.lr(paramString);
      if (parambbn == null) {
        break label342;
      }
    }
    label297:
    label342:
    for (paramInt = parambbn.tCE;; paramInt = 0)
    {
      localcf.lA(G(paramLong1, paramInt));
      if (parambbn != null)
      {
        str = parambbn.sGE;
        paramString = str;
        if (str != null) {}
      }
      else
      {
        paramString = "";
      }
      localcf.ly(paramString);
      if (parambbn != null)
      {
        str = parambbn.sGQ;
        paramString = str;
        if (str != null) {}
      }
      else
      {
        paramString = "";
      }
      localcf.lz(paramString);
      if (parambbn != null)
      {
        paramString = parambbn.extraInfo;
        if (paramString != null)
        {
          str = n.j(paramString, ",", ";", false);
          paramString = str;
          if (str != null) {
            break label244;
          }
        }
      }
      paramString = "";
      label244:
      localcf.lB(paramString);
      if (parambbn != null)
      {
        paramString = parambbn.sGH;
        if (paramString != null)
        {
          parambbn = n.j(paramString, ",", ";", false);
          paramString = parambbn;
          if (parambbn != null) {
            break label297;
          }
        }
      }
      paramString = "";
      localcf.lC(paramString);
      localcf.lF(com.tencent.mm.ac.d.zs(paramLong1));
      localcf.bfK();
      a((com.tencent.mm.plugin.report.a)localcf);
      AppMethodBeat.o(250651);
      return;
      l = 0L;
      break;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt)
  {
    AppMethodBeat.i(250643);
    p.h(paramString, "paperWording");
    ai localai = new ai();
    localai.il(Fg(paramLong1));
    localai.bZ(paramLong2);
    localai.im(Fg(paramLong3));
    localai.in(paramString);
    localai.ca(paramLong4);
    localai.bY(cl.aWA());
    localai.io(G(paramLong1, paramInt));
    localai.bfK();
    a((com.tencent.mm.plugin.report.a)localai);
    AppMethodBeat.o(250643);
  }
  
  public static void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250637);
    p.h(paramString, "topic");
    FinderItem localFinderItem = Fc(paramLong);
    if (localFinderItem != null)
    {
      eg localeg = new eg();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localeg.qM((String)localObject);
      localeg.qN("");
      localeg.lK(paramInt2);
      localeg.qO(Fg(localFinderItem.getId()));
      localeg.lL(localFinderItem.getMediaType());
      localObject = w.vXp;
      localeg.qP(n.j(w.z(paramString, paramInt1, 0L), ",", ";", false));
      localeg.qQ("");
      localeg.lM(localFinderItem.getFeedObject().likeCount);
      localeg.lN(localFinderItem.getFeedObject().commentCount);
      localeg.lO(localFinderItem.getFeedObject().friendLikeCount);
      localeg.bfK();
      a((com.tencent.mm.plugin.report.a)localeg);
      AppMethodBeat.o(250637);
      return;
    }
    AppMethodBeat.o(250637);
  }
  
  public static void a(long paramLong1, String paramString1, long paramLong2, String paramString2, bbn parambbn)
  {
    Object localObject = null;
    AppMethodBeat.i(250703);
    p.h(paramString1, "action");
    bc localbc = new bc();
    localbc.dd(paramLong1);
    localbc.iL(paramString1);
    localbc.df(paramLong2);
    localbc.iP(paramString2);
    if (parambbn != null)
    {
      paramLong1 = parambbn.tCE;
      localbc.de(paramLong1);
      if (parambbn == null) {
        break label156;
      }
      paramString1 = parambbn.sessionId;
      label84:
      localbc.iM(paramString1);
      if (parambbn == null) {
        break label161;
      }
    }
    label156:
    label161:
    for (paramString1 = parambbn.sGE;; paramString1 = null)
    {
      localbc.iN(paramString1);
      paramString1 = localObject;
      if (parambbn != null) {
        paramString1 = parambbn.sGQ;
      }
      localbc.iO(paramString1);
      localbc.bfK();
      a((com.tencent.mm.plugin.report.a)localbc);
      AppMethodBeat.o(250703);
      return;
      paramLong1 = 0L;
      break;
      paramString1 = null;
      break label84;
    }
  }
  
  public static void a(long paramLong, String paramString, bbn parambbn)
  {
    Object localObject = null;
    AppMethodBeat.i(250702);
    com.tencent.mm.g.b.a.a locala = new com.tencent.mm.g.b.a.a();
    locala.bE(paramLong);
    locala.hD(String.valueOf(cl.aWA()));
    locala.abU();
    locala.hE(paramString);
    if (parambbn != null)
    {
      paramLong = parambbn.tCE;
      locala.bD(paramLong);
      if (parambbn == null) {
        break label144;
      }
      paramString = parambbn.sessionId;
      label76:
      locala.hA(paramString);
      if (parambbn == null) {
        break label149;
      }
    }
    label144:
    label149:
    for (paramString = parambbn.sGE;; paramString = null)
    {
      locala.hB(paramString);
      paramString = localObject;
      if (parambbn != null) {
        paramString = parambbn.sGQ;
      }
      locala.hC(paramString);
      locala.bfK();
      a((com.tencent.mm.plugin.report.a)locala);
      AppMethodBeat.o(250702);
      return;
      paramLong = 0L;
      break;
      paramString = null;
      break label76;
    }
  }
  
  public static void a(long paramLong1, String paramString1, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(250701);
    p.h(paramString1, "appId");
    p.h(paramString2, "clickId");
    p.h(paramString3, "sessionid");
    p.h(paramString4, "setting");
    p.h(paramString5, "requestId");
    gu localgu = new gu();
    localgu.qE(System.currentTimeMillis());
    localgu.qF(paramLong1);
    localgu.uz(paramString1);
    localgu.uC(paramString2);
    localgu.qG(paramLong2);
    localgu.uB(com.tencent.mm.model.z.aUg());
    localgu.uA(paramString3);
    localgu.uy(paramString4);
    localgu.uD(paramString5);
    localgu.bfK();
    a((com.tencent.mm.plugin.report.a)localgu);
    AppMethodBeat.o(250701);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Integer paramInteger)
  {
    long l2 = 0L;
    AppMethodBeat.i(250694);
    p.h(paramContext, "context");
    Object localObject = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.dIx();
      localObject = new bl();
      ((bl)localObject).dP(System.currentTimeMillis());
      ((bl)localObject).dQ(paramInt1);
      ((bl)localObject).dR(paramInt2);
      if (paramContext == null) {
        break label129;
      }
    }
    label129:
    for (long l1 = paramContext.tCE;; l1 = 0L)
    {
      ((bl)localObject).dS(l1);
      l1 = l2;
      if (paramInteger != null) {
        l1 = paramInteger.intValue();
      }
      ((bl)localObject).dT(l1);
      ((bl)localObject).bfK();
      AppMethodBeat.o(250694);
      return;
      paramContext = null;
      break;
    }
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(250689);
    p.h(paramContext, "context");
    paramContext = new dy();
    paramContext.ld(paramLong1);
    paramContext.le(paramLong2);
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      paramContext.lf(paramLong1);
      paramContext.bfK();
      AppMethodBeat.o(250689);
      return;
    }
  }
  
  public static void a(Context paramContext, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2, long paramLong4)
  {
    AppMethodBeat.i(250687);
    p.h(paramContext, "context");
    Object localObject = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.dIx();
      localObject = new df();
      if (paramContext == null) {
        break label142;
      }
      paramContext = paramContext.sessionId;
      label50:
      ((df)localObject).ov(paramContext);
      ((df)localObject).jb(paramLong1);
      if (!paramBoolean1) {
        break label147;
      }
      paramLong1 = 1L;
      label70:
      ((df)localObject).jc(paramLong1);
      ((df)localObject).jd(paramLong2);
      ((df)localObject).je(paramLong3);
      ((df)localObject).jf(System.currentTimeMillis());
      if (!paramBoolean2) {
        break label152;
      }
    }
    label142:
    label147:
    label152:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      ((df)localObject).jg(paramLong1);
      ((df)localObject).jh(paramLong4);
      ((df)localObject).bfK();
      AppMethodBeat.o(250687);
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
    AppMethodBeat.i(250696);
    p.h(paramContext, "context");
    p.h(paramString1, "appuin");
    p.h(paramString2, "preWarmPath");
    p.h(paramString3, "liveid");
    p.h(paramString4, "finderid");
    p.h(paramString5, "shopwindowid");
    p.h(paramString6, "sessionid");
    cv localcv = new cv();
    localcv.nD(paramString1);
    localcv.aeo();
    localcv.aep();
    localcv.nF(paramString2);
    if (paramBoolean1)
    {
      i = 1;
      localcv.km(i);
      if (!paramBoolean2) {
        break label202;
      }
    }
    label202:
    for (int i = j;; i = 0)
    {
      localcv.kn(i);
      localcv.nG(paramString3);
      localcv.nH(paramString4);
      localcv.nI(paramString5);
      localcv.nJ(paramString6);
      localcv.nE(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)));
      localcv.hS(cl.aWA());
      localcv.bfK();
      AppMethodBeat.o(250696);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(250698);
    p.h(paramContext, "context");
    p.h(paramString1, "clickId");
    p.h(paramString2, "appId");
    p.h(paramString3, "preWarmPath");
    p.h(paramString4, "liveid");
    p.h(paramString5, "finderid");
    p.h(paramString6, "shopwindowid");
    p.h(paramString7, "sessionid");
    cs localcs = new cs();
    localcs.kh(paramInt2);
    if (paramBoolean1)
    {
      paramInt2 = 1;
      localcs.kf(paramInt2);
      localcs.kg(paramInt1);
      localcs.nt(paramString1);
      localcs.nm(paramString2);
      localcs.aek();
      localcs.no(paramString3);
      if (!paramBoolean2) {
        break label243;
      }
      paramInt1 = 1;
      label143:
      localcs.ki(paramInt1);
      if (!paramBoolean3) {
        break label248;
      }
    }
    label243:
    label248:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localcs.kj(paramInt1);
      localcs.np(paramString4);
      localcs.nq(paramString5);
      localcs.nr(paramString6);
      localcs.ns(paramString7);
      localcs.ael();
      localcs.nn(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)));
      localcs.hN(cl.aWA());
      localcs.bfK();
      AppMethodBeat.o(250698);
      return;
      paramInt2 = 0;
      break;
      paramInt1 = 0;
      break label143;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(250695);
    p.h(paramContext, "context");
    Object localObject = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    em localem;
    if (paramContext != null)
    {
      paramContext = paramContext.dIx();
      localem = new em();
      if (paramContext == null) {
        break label211;
      }
      l = paramContext.tCE;
      label52:
      localem.me(l);
      if (paramContext == null) {
        break label217;
      }
      localObject = paramContext.sessionId;
      label70:
      localem.rl((String)localObject);
      if (paramContext == null) {
        break label223;
      }
      localObject = paramContext.sGQ;
      label88:
      localem.rm((String)localObject);
      if (paramContext == null) {
        break label229;
      }
      localObject = paramContext.sGE;
      label106:
      localem.rn((String)localObject);
      if (paramContext == null) {
        break label235;
      }
      l = paramContext.wyW;
      label124:
      localem.ro(com.tencent.mm.ac.d.zs(l));
      if (!paramBoolean1) {
        break label241;
      }
      l = 1L;
      label142:
      localem.mf(l);
      localem.mg(paramInt);
      if (!paramBoolean2) {
        break label249;
      }
      l = 2L;
      label167:
      localem.mh(l);
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
      localem.mi(l);
      localem.bfK();
      AppMethodBeat.o(250695);
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
    AppMethodBeat.i(250697);
    p.h(paramContext, "context");
    p.h(paramString1, "liveid");
    p.h(paramString2, "finderid");
    p.h(paramString3, "shopwindowid");
    p.h(paramString4, "sessionid");
    p.h(paramString5, "appuin");
    p.h(paramString6, "appVersion");
    cu localcu = new cu();
    localcu.nw(paramString5);
    localcu.aem();
    localcu.nx(paramString6);
    if (paramBoolean1)
    {
      i = 1;
      localcu.kk(i);
      if (!paramBoolean2) {
        break label206;
      }
    }
    label206:
    for (int i = 1;; i = 0)
    {
      localcu.kl(i);
      localcu.nz(paramString1);
      localcu.nA(paramString2);
      localcu.nB(paramString3);
      localcu.nC(paramString4);
      localcu.aen();
      localcu.ny(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)));
      localcu.hQ(paramLong1);
      localcu.hR(paramLong2);
      localcu.bfK();
      AppMethodBeat.o(250697);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(FinderPoiFeedUI.a parama, long paramLong1, bbn parambbn, String paramString1, String paramString2, String paramString3, long paramLong2)
  {
    Object localObject = null;
    AppMethodBeat.i(250706);
    p.h(parama, "action");
    gm localgm = new gm();
    localgm.qt(parama.ordinal());
    localgm.qu(cl.aWA());
    localgm.qv(paramLong2);
    localgm.qw(paramLong1);
    if (parambbn != null) {}
    for (parama = parambbn.sGQ;; parama = null)
    {
      localgm.uk(parama);
      parama = localObject;
      if (parambbn != null) {
        parama = parambbn.sessionId;
      }
      localgm.ul(parama);
      localgm.um(paramString1);
      localgm.un(paramString2);
      localgm.uo(paramString3);
      localgm.bfK();
      a((com.tencent.mm.plugin.report.a)localgm);
      AppMethodBeat.o(250706);
      return;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.model.bm parambm, int paramInt, long paramLong1, String paramString, bbn parambbn, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(250649);
    p.h(parambm, "item");
    p.h(paramString, "receiver");
    cf localcf = new cf();
    String str;
    if (parambbn != null)
    {
      str = parambbn.sessionId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localcf.lr((String)localObject);
    localcf.fJ(paramInt);
    localcf.fK(paramLong1);
    localcf.ls(Fg(parambm.dkW()));
    Object localObject = parambm.contact;
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
    localcf.lt((String)localObject);
    localcf.lu(paramString);
    localcf.fL(parambm.getFeedObject().likeCount);
    localcf.lv("");
    paramString = w.vXp;
    localObject = parambm.tuP;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new cng();
    }
    localcf.lw(n.j(w.a(paramString), ",", ";", false));
    localcf.lx("");
    if (parambbn != null)
    {
      paramLong1 = parambbn.tCE;
      localcf.fP(paramLong1);
      if (parambbn != null)
      {
        localObject = parambbn.sGE;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localcf.ly(paramString);
      if (parambbn != null)
      {
        localObject = parambbn.sGQ;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localcf.lz(paramString);
      paramString = parambm.tuP;
      if (paramString == null) {
        break label518;
      }
      paramLong1 = paramString.id;
      label329:
      if (parambbn == null) {
        break label523;
      }
    }
    label518:
    label523:
    for (paramInt = parambbn.tCE;; paramInt = 0)
    {
      localcf.lA(H(paramLong1, paramInt));
      localcf.fQ(paramLong2);
      if (parambbn != null)
      {
        paramString = parambbn.extraInfo;
        if (paramString != null)
        {
          localObject = n.j(paramString, ",", ";", false);
          paramString = (String)localObject;
          if (localObject != null) {
            break label404;
          }
        }
      }
      paramString = "";
      label404:
      localcf.lB(paramString);
      if (parambbn != null)
      {
        paramString = parambbn.sGH;
        if (paramString != null)
        {
          parambbn = n.j(paramString, ",", ";", false);
          paramString = parambbn;
          if (parambbn != null) {
            break label457;
          }
        }
      }
      paramString = "";
      label457:
      localcf.lC(paramString);
      parambm = parambm.tuP;
      paramLong1 = l;
      if (parambm != null) {
        paramLong1 = parambm.id;
      }
      localcf.lD(Fg(paramLong1));
      localcf.bfK();
      a((com.tencent.mm.plugin.report.a)localcf);
      AppMethodBeat.o(250649);
      return;
      paramLong1 = 0L;
      break;
      paramLong1 = 0L;
      break label329;
    }
  }
  
  public static void a(s params, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178394);
    p.h(params, "rootComment");
    FinderItem localFinderItem = Fc(params.uOf.field_feedId);
    if (localFinderItem != null)
    {
      bs localbs = new bs();
      localbs.ex(paramInt1);
      localbs.ey(params.uOf.dyb().levelTwoComment.size());
      String str2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localbs.jZ(str1);
      localbs.ka(Fg(localFinderItem.getId()));
      localbs.kb(localFinderItem.getUserName());
      localbs.eA(System.currentTimeMillis());
      localbs.kc(params.uOf.getUsername());
      localbs.ez(params.uOf.dyb().likeCount);
      localbs.kd(Fg(params.lT()));
      localbs.eB(params.uOf.dyb().expandCommentCount);
      switch (paramInt2)
      {
      default: 
        localbs.eC(2L);
        if (((params.uOf.dyb().displayFlag & 0x8) <= 0) && ((params.uOf.dyb().displayFlag & 0x2) <= 0)) {
          break;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        localbs.eD(paramInt1);
        localbs.eE(paramInt2);
        localbs.bfK();
        a((com.tencent.mm.plugin.report.a)localbs);
        AppMethodBeat.o(178394);
        return;
        localbs.eC(1L);
        break;
      }
    }
    AppMethodBeat.o(178394);
  }
  
  public static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(250684);
    p.h(parama, "struct");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.abW();
    p.g(parama, "struct.toShowString()");
    Log.i(str, n.j(parama, "\r\n", " ", false));
    AppMethodBeat.o(250684);
  }
  
  public static void a(bbn parambbn, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250681);
    p.h(parambbn, "contextObj");
    be localbe = new be();
    localbe.dr(parambbn.tCE);
    localbe.jc(parambbn.sessionId);
    localbe.jd(parambbn.sGQ);
    localbe.je(parambbn.sGE);
    localbe.ds(paramInt1);
    if (paramInt2 != 0)
    {
      parambbn = com.tencent.mm.ui.component.a.PRN;
      if (!((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mr(paramInt2)) {
        break label131;
      }
    }
    label131:
    for (long l = 1L;; l = 0L)
    {
      localbe.dt(l);
      localbe.bfK();
      a((com.tencent.mm.plugin.report.a)localbe);
      AppMethodBeat.o(250681);
      return;
    }
  }
  
  public static void a(bbn parambbn, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, long paramLong2)
  {
    AppMethodBeat.i(250663);
    p.h(parambbn, "contextObj");
    p.h(paramString, "replyUsername");
    Object localObject = Fc(paramLong1);
    if (localObject != null)
    {
      com.tencent.mm.g.b.a.bm localbm = new com.tencent.mm.g.b.a.bm();
      localbm.jt(parambbn.sessionId);
      localbm.ju("");
      localbm.jv(Fg(paramLong1));
      localbm.jw(((FinderItem)localObject).getUserName());
      localbm.dU(paramInt1);
      localbm.dV(paramInt2);
      localbm.dW(paramInt3);
      localbm.jx(paramString);
      localbm.dX(paramInt4);
      localbm.dY(((FinderItem)localObject).getLikeCount());
      localbm.dZ(((FinderItem)localObject).getCommentCount());
      localbm.ea(((FinderItem)localObject).getFriendLikeCount());
      localbm.eb(((FinderItem)localObject).getMediaType());
      paramString = w.vXp;
      localbm.jy(n.j(w.z((FinderItem)localObject), ",", ";", false));
      localbm.jz("");
      localbm.ec(parambbn.tCE);
      long l;
      if (p.j(((FinderItem)localObject).getUserName(), com.tencent.mm.model.z.aUg()))
      {
        l = 1L;
        localbm.ed(l);
        if (!paramBoolean1) {
          break label519;
        }
        l = 1L;
        label251:
        localbm.ee(l);
        localObject = parambbn.sGQ;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localbm.jA(paramString);
        localObject = parambbn.sGE;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localbm.jB(paramString);
        paramInt1 = parambbn.tCE;
        if ((paramInt1 != 45) && (paramInt1 != 46) && (paramInt1 != 47) && (paramInt1 != 48) && (paramInt1 != 53) && (paramInt1 != 54)) {
          break label525;
        }
        paramInt1 = 1;
        label358:
        if (paramInt1 == 0) {
          break label530;
        }
        paramString = H(paramLong2, parambbn.tCE);
        label373:
        localbm.jC(paramString);
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
        localbm.ef(paramLong1);
        paramString = parambbn.extraInfo;
        if (paramString != null)
        {
          localObject = n.j(paramString, ",", ";", false);
          paramString = (String)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramString = "";
        }
        localbm.jD(paramString);
        parambbn = parambbn.sGH;
        if (parambbn != null)
        {
          paramString = n.j(parambbn, ",", ";", false);
          parambbn = paramString;
          if (paramString != null) {}
        }
        else
        {
          parambbn = "";
        }
        localbm.jE(parambbn);
        localbm.eg(paramInt5);
        localbm.bfK();
        a((com.tencent.mm.plugin.report.a)localbm);
        AppMethodBeat.o(250663);
        return;
        l = 0L;
        break;
        l = 0L;
        break label251;
        paramInt1 = 0;
        break label358;
        paramString = G(paramLong1, parambbn.tCE);
        break label373;
      }
    }
    AppMethodBeat.o(250663);
  }
  
  public static void a(bbn parambbn, long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(250679);
    p.h(parambbn, "contextObj");
    if (Fc(paramLong) != null)
    {
      dp localdp = new dp();
      localdp.kq(parambbn.tCE);
      localdp.pr(parambbn.sGQ);
      localdp.pt(parambbn.sGE);
      localdp.pq(parambbn.sessionId);
      localdp.pp(com.tencent.mm.ac.d.zs(paramLong));
      parambbn = paramString;
      if (paramString == null) {
        parambbn = "";
      }
      localdp.po(parambbn);
      localdp.kp(paramInt);
      localdp.bfK();
      a((com.tencent.mm.plugin.report.a)localdp);
    }
    AppMethodBeat.o(250679);
  }
  
  public static void a(bbn parambbn, long paramLong, RecyclerView paramRecyclerView)
  {
    long l = 2L;
    AppMethodBeat.i(250678);
    p.h(parambbn, "contextObj");
    p.h(paramRecyclerView, "recyclerView");
    FinderItem localFinderItem = Fc(paramLong);
    if (localFinderItem != null)
    {
      cc localcc = new cc();
      localcc.fp(parambbn.tCE);
      localcc.kQ(parambbn.sessionId);
      localcc.kR(parambbn.sGQ);
      localcc.kS(parambbn.sGE);
      localcc.kT(com.tencent.mm.ac.d.zs(paramLong));
      localcc.fr(cl.aWA());
      Object localObject = parambbn.wza;
      if (localObject != null)
      {
        String str = n.j((String)localObject, ",", ";", false);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localcc.kV((String)localObject);
      localcc.fs(localFinderItem.getMediaType());
      localObject = y.vXH;
      localObject = y.dCI().toString();
      p.g(localObject, "FinderUtil.getScreenInfo().toString()");
      localcc.kX(n.j((String)localObject, ",", ";", false));
      localObject = y.vXH;
      paramRecyclerView = y.r(paramRecyclerView).toString();
      p.g(paramRecyclerView, "FinderUtil.getCurrentScr…(recyclerView).toString()");
      localcc.kU(n.j(paramRecyclerView, ",", ";", false));
      localcc.fq(Kt(parambbn.tCE));
      localcc.kW(G(paramLong, parambbn.tCE));
      if (parambbn.tCE == 15) {}
      label465:
      label499:
      int i;
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
        localcc.ft(paramLong);
        paramRecyclerView = localFinderItem.getFeedObject().recommendReason;
        parambbn = paramRecyclerView;
        if (paramRecyclerView == null) {
          parambbn = "";
        }
        localcc.kY(parambbn);
        parambbn = localFinderItem.getFeedObject().objectDesc;
        if (parambbn != null)
        {
          parambbn = parambbn.event;
          if (parambbn != null)
          {
            localcc.la(com.tencent.mm.ac.d.zs(parambbn.twd));
            localcc.acY();
          }
        }
        parambbn = localFinderItem.getFeedObject().objectDesc;
        if (parambbn != null)
        {
          parambbn = parambbn.feedBgmInfo;
          if (parambbn != null)
          {
            paramRecyclerView = parambbn.groupId;
            parambbn = paramRecyclerView;
            if (paramRecyclerView != null) {
              break label465;
            }
          }
        }
        parambbn = "";
        localcc.kZ(parambbn);
        parambbn = localFinderItem.getFeedObject().objectDesc;
        if (parambbn != null)
        {
          parambbn = parambbn.feedBgmInfo;
          if (parambbn != null)
          {
            parambbn = parambbn.musicInfo;
            if (parambbn == null) {
              break label652;
            }
            parambbn = localFinderItem.getFeedObject().objectDesc;
            if (parambbn == null) {
              break label641;
            }
            parambbn = parambbn.feedBgmInfo;
            if (parambbn == null) {
              break label641;
            }
            parambbn = parambbn.musicInfo;
            if (parambbn == null) {
              break label641;
            }
            parambbn = parambbn.wWb;
            label539:
            parambbn = (CharSequence)parambbn;
            if ((parambbn != null) && (parambbn.length() != 0)) {
              break label646;
            }
            i = 1;
            label560:
            if (i != 0) {
              break label652;
            }
          }
        }
        break;
      }
      label641:
      label646:
      label652:
      for (paramLong = l;; paramLong = 1L)
      {
        localcc.fu(paramLong);
        localcc.bfK();
        a((com.tencent.mm.plugin.report.a)localcc);
        AppMethodBeat.o(250678);
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
        parambbn = null;
        break label499;
        parambbn = null;
        break label539;
        i = 0;
        break label560;
      }
    }
    AppMethodBeat.o(250678);
  }
  
  public static void a(bbn parambbn, long paramLong, Integer paramInteger)
  {
    AppMethodBeat.i(250700);
    p.h(parambbn, "contextObj");
    bf localbf = new bf();
    localbf.jf(com.tencent.mm.ac.d.zs(paramLong));
    localbf.acz();
    localbf.du(parambbn.tCE);
    if (paramInteger != null) {}
    for (paramLong = paramInteger.intValue();; paramLong = 0L)
    {
      localbf.dv(paramLong);
      localbf.bfK();
      AppMethodBeat.o(250700);
      return;
    }
  }
  
  public static void a(bbn parambbn, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(250665);
    p.h(parambbn, "contextObj");
    p.h(paramString, "finderUsername");
    com.tencent.mm.g.b.a.bm localbm = new com.tencent.mm.g.b.a.bm();
    localbm.jt(parambbn.sessionId);
    localbm.ju("");
    localbm.ec(parambbn.tCE);
    localbm.jw(paramString);
    localbm.dU(3L);
    localbm.dV(paramInt);
    localbm.jx("");
    localbm.dX(2L);
    localbm.jA(parambbn.sGQ);
    localbm.jB(parambbn.sGE);
    paramString = Fc(paramLong);
    Object localObject;
    if (paramString != null)
    {
      localbm.jv(Fg(paramLong));
      localbm.dY(paramString.getFeedObject().likeCount);
      localbm.dZ(paramString.getFeedObject().commentCount);
      localbm.ea(paramString.getFeedObject().friendLikeCount);
      localbm.eb(paramString.getMediaType());
      localObject = w.vXp;
      localbm.jy(n.j(w.z(paramString), ",", ";", false));
      localbm.jz("");
      localbm.jC(G(paramLong, parambbn.tyh));
    }
    for (;;)
    {
      paramString = parambbn.extraInfo;
      if (paramString != null)
      {
        localObject = n.j(paramString, ",", ";", false);
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localbm.jD(paramString);
      parambbn = parambbn.sGH;
      if (parambbn != null)
      {
        paramString = n.j(parambbn, ",", ";", false);
        parambbn = paramString;
        if (paramString != null) {}
      }
      else
      {
        parambbn = "";
      }
      localbm.jE(parambbn);
      localbm.bfK();
      a((com.tencent.mm.plugin.report.a)localbm);
      AppMethodBeat.o(250665);
      return;
      localbm.jv("0");
      localbm.jy("");
      localbm.jz("");
    }
  }
  
  public static void a(bbn parambbn, FinderItem paramFinderItem, String paramString)
  {
    AppMethodBeat.i(250670);
    p.h(parambbn, "contextObj");
    p.h(paramFinderItem, "finderItem");
    p.h(paramString, "clickUsername");
    bk localbk = new bk();
    localbk.jo(Fg(paramFinderItem.getId()));
    localbk.jp(((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD());
    localbk.jq(paramFinderItem.getFeedObject().username);
    localbk.jr(com.tencent.mm.model.z.aUg());
    localbk.js(paramString);
    localbk.dL(parambbn.tCE);
    localbk.dM(paramFinderItem.getFeedObject().orgRecommendType);
    localbk.dN(paramFinderItem.getFeedObject().likeCount);
    localbk.dO(paramFinderItem.getFeedObject().commentCount);
    localbk.bfK();
    a((com.tencent.mm.plugin.report.a)localbk);
    AppMethodBeat.o(250670);
  }
  
  public static void a(bbn parambbn, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250657);
    p.h(parambbn, "contextObj");
    p.h(paramString1, "poiText");
    p.h(paramString2, "filterTextItems");
    ej localej = new ej();
    localej.qW(parambbn.sessionId);
    localej.qX(parambbn.sGQ);
    localej.qY(parambbn.sGE);
    localej.lT(parambbn.tyh);
    localej.qZ(paramString1);
    localej.ra(paramString2);
    localej.lU(paramInt1);
    localej.lV(paramInt2);
    switch (parambbn.tCE)
    {
    }
    for (;;)
    {
      localej.lX(parambbn.tCE);
      localej.bfK();
      a((com.tencent.mm.plugin.report.a)localej);
      AppMethodBeat.o(250657);
      return;
      localej.lW(2L);
      continue;
      localej.lW(1L);
    }
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, long paramLong, bbn parambbn, int paramInt6, int paramInt7, String paramString4)
  {
    AppMethodBeat.i(250661);
    p.h(paramString1, "currUI");
    p.h(paramString3, "redDotWording");
    p.h(paramString4, "report_ext_info");
    du localdu = new du();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localdu.pS(str1);
    localdu.pT(paramString1);
    localdu.kL(paramInt1);
    localdu.kM(paramInt2);
    localdu.kO(paramInt3);
    long l;
    if (BuildInfo.DEBUG)
    {
      l = 0L;
      localdu.kP(l);
      localdu.kN(paramInt4);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localdu.pU(paramString1);
      localdu.kQ(paramInt5);
      localdu.pV(paramString3);
      localdu.pW(Fg(paramLong));
      if (parambbn != null)
      {
        paramString2 = parambbn.sGQ;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localdu.pX(paramString1);
      if (parambbn != null)
      {
        paramString2 = parambbn.sGE;
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localdu.pY(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() != 1) {
        break label389;
      }
      paramLong = 2L;
      label267:
      localdu.kR(paramLong);
      paramString1 = g.ah(aj.class);
      p.g(paramString1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramString1 = ((aj)paramString1).getRedDotManager();
      p.g(paramString1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!paramString1.daH()) {
        break label395;
      }
    }
    label389:
    label395:
    for (paramLong = 1L;; paramLong = 2L)
    {
      localdu.kS(paramLong);
      localdu.kT(paramInt6);
      localdu.kU(paramInt7);
      if (!Util.isNullOrNil(paramString4)) {
        localdu.pZ(paramString4);
      }
      localdu.bfK();
      a((com.tencent.mm.plugin.report.a)localdu);
      AppMethodBeat.o(250661);
      return;
      l = 2L;
      break;
      paramLong = 1L;
      break label267;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, bbn parambbn)
  {
    AppMethodBeat.i(250641);
    ch localch = new ch();
    if (parambbn != null)
    {
      localch.lI(parambbn.sessionId);
      localch.lJ(parambbn.sGE);
      localch.kb(parambbn.tCE);
    }
    localch.lK(paramString);
    localch.kc(paramInt1);
    localch.adc();
    localch.ade();
    localch.kd(paramInt2);
    localch.bfK();
    a((com.tencent.mm.plugin.report.a)localch);
    AppMethodBeat.o(250641);
  }
  
  public static void a(String paramString, int paramInt, bbn parambbn)
  {
    AppMethodBeat.i(250655);
    p.h(paramString, "exposeFeedId");
    p.h(parambbn, "contextObj");
    com.tencent.mm.plugin.report.e.Cxv.a(20585, new Object[] { paramString, Long.valueOf(cl.aWA()), Integer.valueOf(paramInt), Integer.valueOf(parambbn.tCE), parambbn.sGE, parambbn.sessionId });
    AppMethodBeat.o(250655);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4, String paramString4, int paramInt5, int paramInt6, bbn parambbn)
  {
    AppMethodBeat.i(250640);
    dd localdd = new dd();
    localdd.ol(paramString1);
    localdd.om(paramString2);
    localdd.kB(paramInt1);
    localdd.kC(paramInt2);
    localdd.on(paramString3);
    localdd.kD(paramInt3);
    localdd.kE(paramInt4);
    localdd.afc();
    if (parambbn != null)
    {
      localdd.oo(parambbn.sessionId);
      localdd.kF(parambbn.tCE);
      localdd.op(parambbn.sGE);
    }
    localdd.oq(paramString4);
    localdd.kG(paramInt5);
    localdd.kH(paramInt6);
    localdd.bfK();
    a((com.tencent.mm.plugin.report.a)localdd);
    AppMethodBeat.o(250640);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4, String paramString4, int paramInt5, bbn parambbn)
  {
    AppMethodBeat.i(250639);
    dw localdw = new dw();
    localdw.qf(paramString1);
    localdw.qg(paramString2);
    localdw.kX(paramInt1);
    localdw.kY(paramInt2);
    localdw.qh(paramString3);
    localdw.kZ(paramInt3);
    localdw.la(paramInt4);
    localdw.afi();
    if (parambbn != null)
    {
      localdw.qi(parambbn.sessionId);
      localdw.lb(parambbn.tCE);
      localdw.qj(parambbn.sGE);
    }
    localdw.qk(paramString4);
    localdw.afj();
    localdw.lc(paramInt5);
    localdw.bfK();
    a((com.tencent.mm.plugin.report.a)localdw);
    AppMethodBeat.o(250639);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bbn parambbn)
  {
    AppMethodBeat.i(250638);
    dv localdv = new dv();
    localdv.afh();
    localdv.qc(paramString1);
    localdv.qd(paramString2);
    localdv.qe(paramString3);
    localdv.kV(paramInt1);
    localdv.kW(paramInt2);
    localdv.kY(paramInt3);
    localdv.kZ(paramInt4);
    localdv.la(paramInt5);
    if (parambbn != null)
    {
      localdv.qa(parambbn.sessionId);
      localdv.kX(parambbn.tCE);
      localdv.qb(parambbn.sGE);
    }
    localdv.bfK();
    a((com.tencent.mm.plugin.report.a)localdv);
    AppMethodBeat.o(250638);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    AppMethodBeat.i(250667);
    com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.Cxv;
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
    paramString3 = com.tencent.mm.ac.d.zs(paramLong1);
    if (paramInt2 == 4) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      locale.a(21834, new Object[] { str, paramString1, paramString2, Integer.valueOf(paramInt1), paramString3, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(250667);
      return;
    }
  }
  
  public static void ac(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(250680);
    p.h(paramContext, "context");
    cz localcz = new cz();
    Object localObject = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    if (paramContext != null) {
      localcz.of(paramContext.sessionId);
    }
    for (;;)
    {
      localcz.iF(paramInt);
      localcz.bfK();
      a((com.tencent.mm.plugin.report.a)localcz);
      AppMethodBeat.o(250680);
      return;
      localObject = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      localcz.of(paramContext);
    }
  }
  
  public static void ad(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250692);
    p.h(paramString, "fromUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2;
    com.tencent.mm.plugin.report.e.Cxv.kvStat(20699, paramString);
    AppMethodBeat.o(250692);
  }
  
  public static void ai(int paramInt, long paramLong)
  {
    AppMethodBeat.i(250672);
    ef localef = new ef();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localef.qL(str1);
    localef.lI(paramInt);
    localef.lJ(paramLong);
    localef.bfK();
    a((com.tencent.mm.plugin.report.a)localef);
    AppMethodBeat.o(250672);
  }
  
  public static void auJ(String paramString)
  {
    vfu = paramString;
  }
  
  public static void auK(String paramString)
  {
    AppMethodBeat.i(166588);
    p.h(paramString, "username");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    paramString = str + ',' + paramString;
    Log.i(TAG, "18973 ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.e.Cxv.kvStat(18973, paramString);
    AppMethodBeat.o(166588);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(250691);
    p.h(paramString, "profileUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4;
    com.tencent.mm.plugin.report.e.Cxv.kvStat(20698, paramString);
    AppMethodBeat.o(250691);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(250673);
    db localdb = new db();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localdb.oi(str1);
    localdb.iH(paramInt1);
    localdb.iK(0L);
    localdb.iI(paramInt2);
    localdb.iJ(paramInt3);
    localdb.oj(u.Pb(u.Pc(paramLong)));
    localdb.bfK();
    a((com.tencent.mm.plugin.report.a)localdb);
    AppMethodBeat.o(250673);
  }
  
  public static void d(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(250633);
    if (paramString != null)
    {
      paramString = n.j(paramString, ",", ";", false);
      if (paramString != null) {
        switch (paramInt)
        {
        default: 
          ((Map)vfy).put(paramLong + '_' + paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      vfx.put(paramLong, Long.valueOf(cl.aWA()));
      AppMethodBeat.o(250633);
      return;
      ((Map)vfy).put(paramLong + "_46", paramString);
      continue;
      ((Map)vfy).put(paramLong + "_47", paramString);
      continue;
      ((Map)vfy).put(paramLong + "_48", paramString);
    }
  }
  
  public static void dA(String paramString, int paramInt)
  {
    AppMethodBeat.i(178395);
    p.h(paramString, "username");
    da localda = new da();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localda.oh(str1);
    localda.og(paramString);
    localda.iG(paramInt);
    localda.bfK();
    a((com.tencent.mm.plugin.report.a)localda);
    AppMethodBeat.o(178395);
  }
  
  public static String dob()
  {
    return vfu;
  }
  
  public static String doc()
  {
    AppMethodBeat.i(250671);
    String str = UUID.randomUUID().toString();
    p.g(str, "UUID.randomUUID().toString()");
    AppMethodBeat.o(250671);
    return str;
  }
  
  public static int dod()
  {
    AppMethodBeat.i(250686);
    int i = 0;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(250686);
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
  
  public static void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(166582);
    p.h(paramString1, "fromUser");
    p.h(paramString2, "topic");
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    paramString1 = new StringBuilder().append((String)localObject).append(',').append(paramInt1).append(",3,").append(paramString1).append(",0,,");
    localObject = w.vXp;
    paramString1 = w.dO(paramString2, paramInt2);
    com.tencent.mm.plugin.report.e.Cxv.kvStat(18944, paramString1);
    AppMethodBeat.o(166582);
  }
  
  public static void e(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(250634);
    if (paramString != null)
    {
      paramString = n.j(paramString, ",", ";", false);
      if (paramString != null) {
        switch (paramInt)
        {
        default: 
          ((Map)vfw).put(paramLong + '_' + paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      vfv.put(paramLong, Long.valueOf(cl.aWA()));
      AppMethodBeat.o(250634);
      return;
      ((Map)vfw).put(paramLong + "_6", paramString);
      ((Map)vfw).put(paramLong + "_23", paramString);
      continue;
      ((Map)vfw).put(paramLong + "_9", paramString);
      ((Map)vfw).put(paramLong + "_22", paramString);
      continue;
      ((Map)vfw).put(paramLong + "_15", paramString);
      ((Map)vfw).put(paramLong + "_16", paramString);
      continue;
      ((Map)vfw).put(paramLong + "_26", paramString);
      ((Map)vfw).put(paramLong + "_27", paramString);
      continue;
      ((Map)vfw).put(paramLong + "_24", paramString);
      ((Map)vfw).put(paramLong + "_21", paramString);
      continue;
      ((Map)vfw).put(paramLong + "_32", paramString);
      ((Map)vfw).put(paramLong + "_1", paramString);
      continue;
      ((Map)vfw).put(paramLong + "_33", paramString);
      ((Map)vfw).put(paramLong + "_8", paramString);
    }
  }
  
  public static void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(250683);
    p.h(paramString1, "tipsId");
    p.h(paramString2, "revokeId");
    ds localds = new ds();
    localds.kw(paramInt1);
    localds.kx(cl.aWB());
    localds.pG(paramString1);
    localds.pH(paramString2);
    paramString1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() == 1) {}
    for (long l = 2L;; l = 1L)
    {
      localds.ky(l);
      localds.kz(paramInt2);
      localds.bfK();
      a((com.tencent.mm.plugin.report.a)localds);
      AppMethodBeat.o(250683);
      return;
    }
  }
  
  public static void f(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(250704);
    p.h(paramContext, "context");
    Object localObject1 = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    do localdo;
    if (paramContext != null)
    {
      paramContext = paramContext.dIx();
      localdo = new do();
      if (paramContext == null) {
        break label173;
      }
      localObject1 = paramContext.sessionId;
      label54:
      localdo.pk((String)localObject1);
      if (paramContext == null) {
        break label179;
      }
      localObject1 = paramContext.sGE;
      label72:
      localdo.pl((String)localObject1);
      if (paramContext == null) {
        break label185;
      }
    }
    label173:
    label179:
    label185:
    for (long l = paramContext.tCE;; l = 0L)
    {
      localdo.km(l);
      localdo.pn(String.valueOf(System.currentTimeMillis()));
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = paramContext.sGQ;
      }
      localdo.pm((String)localObject1);
      localdo.kn(paramInt1);
      localdo.ko(paramInt2);
      localdo.bfK();
      a((com.tencent.mm.plugin.report.a)localdo);
      AppMethodBeat.o(250704);
      return;
      paramContext = null;
      break;
      localObject1 = null;
      break label54;
      localObject1 = null;
      break label72;
    }
  }
  
  public static void f(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166586);
    p.h(paramFinderItem, "finderItem");
    FinderObject localFinderObject = paramFinderItem.getFinderObject();
    String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    paramFinderItem = str + ',' + Fg(localFinderObject.id) + ',' + localFinderObject.username + ',' + paramFinderItem.getMediaType() + ',' + localFinderObject.recommendType + ',' + localFinderObject.likeCount + ',' + localFinderObject.commentCount + ',' + localFinderObject.friendLikeCount;
    Log.i(TAG, "18950 ".concat(String.valueOf(paramFinderItem)));
    com.tencent.mm.plugin.report.e.Cxv.kvStat(18950, paramFinderItem);
    AppMethodBeat.o(166586);
  }
  
  public static String fp(Context paramContext)
  {
    AppMethodBeat.i(250685);
    p.h(paramContext, "context");
    int i = 0;
    if ((paramContext instanceof MMFragmentActivity))
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      i = ((FinderHomeUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderHomeUIC.class)).dIf();
    }
    switch (i)
    {
    default: 
      paramContext = "2";
    }
    for (;;)
    {
      AppMethodBeat.o(250685);
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
    AppMethodBeat.i(250669);
    p.h(paramFinderItem, "finderItem");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null)
    {
      dh localdh = new dh();
      localdh.oC(Fg(paramFinderItem.getId()));
      localdh.oD(((FinderFeedReportObject)localObject).sessionId);
      localdh.oE(paramFinderItem.getFeedObject().username);
      localObject = com.tencent.mm.plugin.finder.utils.d.vVg;
      localdh.oF(n.j(com.tencent.mm.plugin.finder.utils.d.w(paramFinderItem), ",", ";", false));
      localdh.bfK();
      a((com.tencent.mm.plugin.report.a)localdh);
      AppMethodBeat.o(250669);
      return;
    }
    AppMethodBeat.o(250669);
  }
  
  public static void gS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178396);
    p.h(paramString1, "contextId");
    p.h(paramString2, "action");
    ek localek = new ek();
    localek.rc(paramString1);
    localek.rb(paramString2);
    localek.lY(cl.aWA());
    paramString2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localek.rd(paramString1);
    if (BuildInfo.DEBUG) {}
    for (long l = 0L;; l = 1L)
    {
      localek.lZ(l);
      localek.bfK();
      a((com.tencent.mm.plugin.report.a)localek);
      AppMethodBeat.o(178396);
      return;
    }
  }
  
  public static void ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250675);
    dx localdx = new dx();
    localdx.lb(paramInt1);
    localdx.lc(paramInt2);
    localdx.bfK();
    a((com.tencent.mm.plugin.report.a)localdx);
    AppMethodBeat.o(250675);
  }
  
  public static void h(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166585);
    p.h(paramFinderObject, "finderObject");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    paramFinderObject = str + ',' + 1 + ',' + Fg(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.recommendType;
    Log.i(TAG, "18953 ".concat(String.valueOf(paramFinderObject)));
    com.tencent.mm.plugin.report.e.Cxv.kvStat(18953, paramFinderObject);
    AppMethodBeat.o(166585);
  }
  
  public static void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166584);
    p.h(paramString1, "author");
    p.h(paramString2, "receiver");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    paramString1 = str + ',' + paramString1 + ',' + paramString2 + ',' + 0 + ',' + paramInt1 + ',' + paramInt2;
    Log.i(TAG, "18949 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.Cxv.kvStat(18949, paramString1);
    AppMethodBeat.o(166584);
  }
  
  public static void x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(166581);
    p.h(paramString1, "fromUser");
    p.h(paramString2, "nameCardUser");
    String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
    paramString1 = str + ',' + paramInt + ",2," + paramString1 + ",0," + paramString2;
    Log.i(TAG, "18944 ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.report.e.Cxv.kvStat(18944, paramString1);
    AppMethodBeat.o(166581);
  }
  
  public static void y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(250705);
    p.h(paramString1, "profileUserName");
    p.h(paramString2, "profileBizUin");
    paramString1 = new dm();
    paramString1.kj(paramInt);
    paramString1.pe(paramString1.aff());
    paramString1.pf(paramString2);
    paramString1.bfK();
    a((com.tencent.mm.plugin.report.a)paramString1);
    AppMethodBeat.o(250705);
  }
  
  public final void a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(250644);
    p.h(paramString, "fromUser");
    a(paramLong, paramInt1, 1L, paramString, paramInt2, paramInt3);
    AppMethodBeat.o(250644);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt3, String paramString5, int paramInt4)
  {
    AppMethodBeat.i(250658);
    p.h(paramString1, "currUI");
    p.h(paramString2, "redDotId");
    p.h(paramString3, "redDotWording");
    p.h(paramString4, "contextId");
    p.h(paramString5, "report_ext_info");
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() != 1) {
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(250658);
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
      localObject = new bbn();
      ((bbn)localObject).sGQ = paramString4;
      ((bbn)localObject).sGE = "";
      a(paramString1, paramInt1, paramInt2, paramInt3, i, 0, paramString2, paramString3, paramLong, (bbn)localObject, paramInt4, paramString5);
      AppMethodBeat.o(250658);
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
        AppMethodBeat.o(250658);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.k
 * JD-Core Version:    0.7.0.1
 */