package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ba;
import com.tencent.mm.autogen.mmdata.rpt.ci;
import com.tencent.mm.autogen.mmdata.rpt.ck;
import com.tencent.mm.autogen.mmdata.rpt.cl;
import com.tencent.mm.autogen.mmdata.rpt.co;
import com.tencent.mm.autogen.mmdata.rpt.ct;
import com.tencent.mm.autogen.mmdata.rpt.cz;
import com.tencent.mm.autogen.mmdata.rpt.da;
import com.tencent.mm.autogen.mmdata.rpt.db;
import com.tencent.mm.autogen.mmdata.rpt.dh;
import com.tencent.mm.autogen.mmdata.rpt.dj;
import com.tencent.mm.autogen.mmdata.rpt.dm;
import com.tencent.mm.autogen.mmdata.rpt.dn;
import com.tencent.mm.autogen.mmdata.rpt.dq;
import com.tencent.mm.autogen.mmdata.rpt.dw;
import com.tencent.mm.autogen.mmdata.rpt.ea;
import com.tencent.mm.autogen.mmdata.rpt.eb;
import com.tencent.mm.autogen.mmdata.rpt.eo;
import com.tencent.mm.autogen.mmdata.rpt.et;
import com.tencent.mm.autogen.mmdata.rpt.eu;
import com.tencent.mm.autogen.mmdata.rpt.ey;
import com.tencent.mm.autogen.mmdata.rpt.ez;
import com.tencent.mm.autogen.mmdata.rpt.fa;
import com.tencent.mm.autogen.mmdata.rpt.fg;
import com.tencent.mm.autogen.mmdata.rpt.fk;
import com.tencent.mm.autogen.mmdata.rpt.fr;
import com.tencent.mm.autogen.mmdata.rpt.fs;
import com.tencent.mm.autogen.mmdata.rpt.ft;
import com.tencent.mm.autogen.mmdata.rpt.fu;
import com.tencent.mm.autogen.mmdata.rpt.fy;
import com.tencent.mm.autogen.mmdata.rpt.gc;
import com.tencent.mm.autogen.mmdata.rpt.ge;
import com.tencent.mm.autogen.mmdata.rpt.gf;
import com.tencent.mm.autogen.mmdata.rpt.gg;
import com.tencent.mm.autogen.mmdata.rpt.gh;
import com.tencent.mm.autogen.mmdata.rpt.gi;
import com.tencent.mm.autogen.mmdata.rpt.gk;
import com.tencent.mm.autogen.mmdata.rpt.gr;
import com.tencent.mm.autogen.mmdata.rpt.gs;
import com.tencent.mm.autogen.mmdata.rpt.gt;
import com.tencent.mm.autogen.mmdata.rpt.gu;
import com.tencent.mm.autogen.mmdata.rpt.gw;
import com.tencent.mm.autogen.mmdata.rpt.gx;
import com.tencent.mm.autogen.mmdata.rpt.gz;
import com.tencent.mm.autogen.mmdata.rpt.ja;
import com.tencent.mm.autogen.mmdata.rpt.ju;
import com.tencent.mm.autogen.mmdata.rpt.lb;
import com.tencent.mm.autogen.mmdata.rpt.lj;
import com.tencent.mm.autogen.mmdata.rpt.ls;
import com.tencent.mm.autogen.mmdata.rpt.sd;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.bm;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.j;
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
import kotlin.Metadata;
import kotlin.ab;
import kotlin.ah;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.NetworkUtil;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderReportLogic;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderReportLogic;", "()V", "KEY_JUMPICON_INFO", "", "KEY_OPERATIONAL_JUMPINFO", "KEY_UNIVERSAL_JUMPINFO", "KEY_VIDEO_PLAY_INFO", "TAG", "getTAG", "()Ljava/lang/String;", "TWO_64", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFinderFeedCgiFetchTimeMap", "()Landroid/util/SparseArray;", "finderFeedFetchTimeMap", "Landroid/util/LongSparseArray;", "getFinderFeedFetchTimeMap", "()Landroid/util/LongSparseArray;", "isProfileHasFeed", "", "()Z", "setProfileHasFeed", "(Z)V", "isShowingProfileFeedFooterEntranceSnsAlbumPicker", "setShowingProfileFeedFooterEntranceSnsAlbumPicker", "megaVideoFeedFetchTimeMap", "getMegaVideoFeedFetchTimeMap", "searchSessionId", "getSearchSessionId", "setSearchSessionId", "(Ljava/lang/String;)V", "sessionBufferMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/report/SessionBufferEx;", "Lkotlin/collections/HashMap;", "getSessionBufferMap", "()Ljava/util/HashMap;", "setSessionBufferMap", "(Ljava/util/HashMap;)V", "videoPlayTimeMap", "Landroid/util/ArrayMap;", "", "getVideoPlayTimeMap", "()Landroid/util/ArrayMap;", "setVideoPlayTimeMap", "(Landroid/util/ArrayMap;)V", "addJumpInfoClientUdfKv", "", "context", "Landroid/content/Context;", "feedId", "key", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "addVideoPlayInfo", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "asUnsignedDecimalString", "l", "commentExposeReport", "sessionId", "contextId", "clickTabContextId", "commentScene", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "finderAvatarClick19405", "clickAvatarScene", "finderRole", "clickFinderUsername", "finderBackToTop19995", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "tabType", "finderChangeRoleClick", "roleBeforeSwitch", "finderClickEntrance19025", "redDotId", "finderClickMoreReport", "scene", "finderClickTopic19186", "topic", "topicType", "topicFeedCount", "finderClickTopicFeedReport", "finderCommentFlagReport", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderCommonExposeReport", "eventCode", "eid", "udfKv", "finderCreateContactReport", "success", "hadAvatar", "addSignature", "hadWechatCity", "hadWechatSex", "createScene", "wxProfile", "changeName", "finderDistrictAlertClick", "username", "finderExposeFeedReport", "finderFavReport", "finderItem", "finderHotSearchReport", "itemId", "reasonId", "position", "accountType", "actionType", "hotWordId", "requestId", "finderLocationRequest19954", "finderMegaVideoShareReport", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "shareType", "forwardResult", "receiver", "forwardUsrCount", "finderMessageModReport", "identity", "notificationType", "finderRealLikeAction19956", "finderRealLikeExpose19955", "exposeItems", "totalCount", "enterContextId", "finderRealLikeUserModify19957", "addUsernames", "delUsernames", "enterCount", "finderRedDot18948", "currUI", "redDotType", "showType", "redDotSubType", "count", "redDotWording", "currentTabType", "autoClick", "report_ext_info", "redDotBizType", "finderRedDotRevoke20223", "ctrType", "tipsId", "revokeId", "revokeStatus", "finderReportClickMention", "clickUsername", "finderReportEnterAtTimeline", "finderReportFav", "opType", "finderReportFlowClick19993", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "finderReportFollow", "finderUsername", "finderReportHitTabClick19998", "messageType", "index", "finderReportLikeAndComment", "likeAction", "replyUsername", "userScene", "isShowRecWording", "isPrivateAccount", "feedContentType", "megaVideoId", "finderReportMsgItemClick", "type", "isOverlap", "overlapCount", "finderReportOpenDrawer", "clickType", "finderReportPostMentionInfo", "finderReportSysMsgClick", "redDotCount", "finderReportTabChange", "fromTab", "toTab", "source", "finderSaveNameCard", "finderSearchActionReport", "query", "searchScene", "searchType", "searchResultType", "accountIsNull", "feedIsNull", "finderSearchClickReport", "requestType", "itemType", "finderSearchNewClickReport", "finderSelfUIEventReport", "enterTimeStamp", "redDotExistOnEnter", "eventType", "bannerType", "isHaveRedDot", "msgCnt", "finderSettingClickReport", "settingType", "finderSettingInfoEventReport", "hasReddot", "finderShareActivityReport", "forwardType", "activityId", "finderShareAlbumClickReport", "fromUser", "cardId", "finderShareAlbumReport", "finderShareFeedClick18944", "cardType", "isCgiEnd", "uiType", "finderShareFeedReport", "localFeedItem", "finderShareNameCardClickReport", "nameCardUser", "finderShareNameCardReport", "author", "followCount", "authType", "finderShareTopicClickReport", "finderShareTopicReport", "finderSubCommentExpand", "rootComment", "expandType", "finderTimelineMoreAction", "isFloat", "finderTraceAction", "finderUnlikeFeedReport", "page", "unlikeType", "finderVoiceFlagReport", "getCurrentTabRedDotUI", "getFeedCigFetchTime", "getFinderFeedFetchTime", "getFinderItem", "getFinderItemSessionBuffer", "getFinderItemSessionBufferEx", "getMegaVideoFetchTime", "getMegaVideoItem", "getMegaVideoItemSessionBuffer", "getReportNetTypeInt", "getStr", "ids", "", "split", "getVideoPlayInfo", "getVideoPlayTime", "isMegaVideoComment", "newUUID", "optWxSubRedDotType", "commentCount", "likeCount", "likeLikeCount", "recommendLikeCount", "putFeedCgiFetchTime", "putFinderItemSessionBuffer", "sessionBuffer", "clientRecTime", "putMegaVideoItemSessionBuffer", "putVideoPlayTime", "recordFinderObjectRevTime", "report20044", "isExplose", "clickAction", "isCollapse", "isTopic", "report20698", "profileUsername", "time", "profileType", "profileView", "report20699", "fromUsername", "report20717", "tabContextId", "actionScene", "report20849", "msgType", "msgId", "report21077", "outcome", "(Landroid/content/Context;IILjava/lang/Integer;)V", "report21172", "userName", "profileBizUin", "appId", "report21188", "isFirstOpen", "clickscene", "clickId", "preWarmPath", "ispresend", "ispreload", "liveid", "finderid", "shopwindowid", "sessionid", "report21206", "isSelf", "eventTarget", "report21235", "appuin", "report21237", "prewarmstartime", "prewarmendtime", "appVersion", "report21313", "liveRole", "shop", "prerenderType", "postTime", "shareLiveTime", "joinLiveTime", "enterRoomTime", "liveStates", "uiStates", "statistics", "cgiErrcode", "cgiErrtype", "cgiErrmsg", "liveEventCode", "liveEventSubCode", "liveEventMsg", "extra", "snn", "networkQuality", "report21345", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JLjava/lang/Integer;)V", "report21726", "report21834", "enterMs", "exitMs", "reason", "report21837", "setting", "report21851", "report21923", "target", "report22116", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Action;", "dynamicState", "poiClassifyId", "poiDetail", "sourceId", "duration", "report22265", "currentObj", "resId", "report22623", "newIds", "oldIds", "report22657", "report22955", "iconType", "curPos", "mutualAdInfo", "reportDailyPaper", "paperId", "paperWording", "clickable", "reportDropRedDot", "showInfoPath", "ctrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "text", "reportText", "dropReason", "reportEntranceSnsAlbumPickerExpose21875", "isClick", "hasFeed", "reportExposeHotCard20585", "exposeFeedId", "posId", "reportFinderAdMutual", "isViewable", "data", "Lcom/tencent/mm/json/JSONObject;", "adW", "adH", "clickPos", "posX", "posY", "adPosId", "aid", "enterPageTime", "reportIDKeyVideoPlayError", "what", "reportJumpHotCard20586", "actionFeedId", "actionFeedIndex", "totalFeedId", "reportPoiFilter19996", "poiText", "filterTextItems", "hasUnfoldBtn", "isUnfoldBtnClick", "reportTeensTips21875", "reportTextStatus21875", "reportTopicMsg21875", "finderJumpInfoEx", "fieldId", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "transformCommentSceneToTabType", "transformTabIndexToTabType", "tabIndex", "transformTabTypeToCommentScene", "updateFeedSessionBuffer", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  implements bm
{
  public static final z FrZ;
  private static String Fsa;
  private static final LongSparseArray<Long> Fsb;
  private static HashMap<String, bd> Fsc;
  private static ArrayMap<Long, Integer> Fsd;
  public static final LongSparseArray<Long> Fse;
  private static final SparseArray<Long> Fsf;
  private static boolean Fsg;
  private static boolean Fsh;
  public static final String TAG;
  private static final BigInteger TWO_64;
  
  static
  {
    AppMethodBeat.i(166595);
    FrZ = new z();
    TAG = "Finder.FinderReportLogic";
    Fsa = "";
    Fsb = new LongSparseArray();
    Fsc = new HashMap();
    Fsd = new ArrayMap();
    Fse = new LongSparseArray();
    Fsf = new SparseArray();
    TWO_64 = BigInteger.ONE.shiftLeft(64);
    AppMethodBeat.o(166595);
  }
  
  public static void G(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(166581);
    kotlin.g.b.s.u(paramString1, "fromUser");
    kotlin.g.b.s.u(paramString2, "nameCardUser");
    String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramString1 = str + ',' + paramInt + ",2," + paramString1 + ",0," + paramString2;
    Log.i(TAG, kotlin.g.b.s.X("18944 ", paramString1));
    com.tencent.mm.plugin.report.f.Ozc.kvStat(18944, paramString1);
    AppMethodBeat.o(166581);
  }
  
  public static void SB(int paramInt)
  {
    AppMethodBeat.i(331739);
    Fsf.put(paramInt, Long.valueOf(com.tencent.mm.model.cn.bDw()));
    AppMethodBeat.o(331739);
  }
  
  public static void SC(int paramInt)
  {
    AppMethodBeat.i(166594);
    switch (paramInt)
    {
    default: 
      locala = ap.FtP;
      ap.a.rG(ap.eNP());
      AppMethodBeat.o(166594);
      return;
    case -1010: 
      locala = ap.FtP;
      ap.a.rG(ap.eNC());
      AppMethodBeat.o(166594);
      return;
    case -1007: 
      locala = ap.FtP;
      ap.a.rG(ap.eND());
      AppMethodBeat.o(166594);
      return;
    case -1004: 
      locala = ap.FtP;
      ap.a.rG(ap.eNE());
      AppMethodBeat.o(166594);
      return;
    case -10012: 
      locala = ap.FtP;
      ap.a.rG(ap.eNF());
      AppMethodBeat.o(166594);
      return;
    case -10004: 
      locala = ap.FtP;
      ap.a.rG(ap.eNG());
      AppMethodBeat.o(166594);
      return;
    case -21009: 
      locala = ap.FtP;
      ap.a.rG(ap.eNH());
      AppMethodBeat.o(166594);
      return;
    case -21020: 
      locala = ap.FtP;
      ap.a.rG(ap.eNI());
      AppMethodBeat.o(166594);
      return;
    case 404: 
      locala = ap.FtP;
      ap.a.rG(ap.eNJ());
      AppMethodBeat.o(166594);
      return;
    case 403: 
      locala = ap.FtP;
      ap.a.rG(ap.eNK());
      AppMethodBeat.o(166594);
      return;
    case 503: 
      locala = ap.FtP;
      ap.a.rG(ap.eNL());
      AppMethodBeat.o(166594);
      return;
    case 502: 
      locala = ap.FtP;
      ap.a.rG(ap.eNM());
      AppMethodBeat.o(166594);
      return;
    case 416: 
      locala = ap.FtP;
      ap.a.rG(ap.eNN());
      AppMethodBeat.o(166594);
      return;
    }
    ap.a locala = ap.FtP;
    ap.a.rG(ap.eNO());
    AppMethodBeat.o(166594);
  }
  
  public static int SD(int paramInt)
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
  
  public static int SE(int paramInt)
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
    AppMethodBeat.i(332215);
    fa localfa = new fa();
    String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localfa.px(str1);
    localfa.ixB = paramInt1;
    localfa.iGr = paramInt2;
    localfa.iGp = paramInt3;
    localfa.iGq = paramInt4;
    localfa.py(z..ExternalSyntheticBackport0.m(ab.J(paramLong)));
    localfa.bMH();
    a((a)localfa);
    AppMethodBeat.o(332215);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, bui parambui)
  {
    AppMethodBeat.i(331993);
    kotlin.g.b.s.u(parambui, "contextObj");
    eb localeb = new eb();
    localeb.iqr = parambui.AJo;
    localeb.oi(parambui.sessionId);
    localeb.iwI = localeb.F("Contextid", parambui.zIO, true);
    localeb.ijl = localeb.F("ClickTabContextid", parambui.zIB, true);
    localeb.oi(parambui.sessionId);
    localeb.iBR = com.tencent.mm.model.cn.bDw();
    localeb.ila = paramInt1;
    localeb.iBS = paramInt2;
    localeb.iBT = paramInt3;
    localeb.iBV = 1L;
    localeb.bMH();
    a((a)localeb);
    AppMethodBeat.o(331993);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3, bui parambui)
  {
    AppMethodBeat.i(331970);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localObject1 = localStringBuilder1.append(localObject1).append(',').append(paramInt1).append(',').append(paramInt2).append(',').append(paramInt3).append(',');
    label128:
    label148:
    label171:
    Object localObject2;
    if (paramBoolean1)
    {
      paramInt1 = 1;
      localObject1 = ((StringBuilder)localObject1).append(paramInt1).append(',').append(paramInt4).append(',').append(paramInt5).append(',').append(paramInt6).append(',');
      if (!paramBoolean2) {
        break label247;
      }
      paramInt1 = 1;
      localObject1 = ((StringBuilder)localObject1).append(paramInt1).append(',');
      if (!paramBoolean3) {
        break label252;
      }
      paramInt1 = 0;
      StringBuilder localStringBuilder2 = ((StringBuilder)localObject1).append(paramInt1).append(',');
      if (parambui != null) {
        break label257;
      }
      localObject1 = "";
      localObject2 = localStringBuilder2.append((String)localObject1).append(',');
      if (parambui != null) {
        break label281;
      }
      parambui = "";
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append(parambui);
      parambui = localStringBuilder1.toString();
      Log.i(TAG, kotlin.g.b.s.X("18947 ", parambui));
      com.tencent.mm.plugin.report.f.Ozc.kvStat(18947, parambui);
      AppMethodBeat.o(331970);
      return;
      paramInt1 = 0;
      break;
      label247:
      paramInt1 = 0;
      break label128;
      label252:
      paramInt1 = 1;
      break label148;
      label257:
      localObject2 = parambui.zIO;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label171;
      }
      localObject1 = "";
      break label171;
      label281:
      localObject1 = parambui.zIB;
      parambui = (bui)localObject1;
      if (localObject1 == null) {
        parambui = "";
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, bui parambui, int paramInt3)
  {
    long l2 = 0L;
    AppMethodBeat.i(332229);
    kotlin.g.b.s.u(parambui, "contextObj");
    dq localdq = new dq();
    long l1;
    if (paramInt1 > 0)
    {
      l1 = paramInt1;
      localdq.iAj = l1;
      l1 = l2;
      if (paramInt2 > 0) {
        l1 = paramInt2;
      }
      localdq.iAk = l1;
      localdq.izR = com.tencent.mm.model.cn.bDw();
      localdq.ixm = localdq.F("Sessionid", parambui.sessionId, true);
      localdq.iqP = localdq.F("ContextID", parambui.zIO, true);
      localdq.iAl = localdq.F("ClickContextid", parambui.zIB, true);
      localdq.iAn = paramInt3;
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localdq.bMH();
      a((a)localdq);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adeW, localdq.iAl);
      if (paramInt2 != 2) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adeX, localdq.iAl);
      }
      Log.i(TAG, "finderReportTabChange clickTabContextId [%s] toTab[%d]", new Object[] { localdq.iAl, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(332229);
      return;
      l1 = 0L;
      break;
      if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLFollow") != null)
      {
        localdq.iAm = 1L;
        continue;
        if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLRecommendTab") != null)
        {
          localdq.iAm = 1L;
          continue;
          if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("finder_tl_hot_tab") != null)
          {
            localdq.iAm = 1L;
            continue;
            if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("finder_tl_nearby_tab") != null) {
              localdq.iAm = 1L;
            }
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    long l = 1L;
    AppMethodBeat.i(332150);
    dm localdm = new dm();
    String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localdm.ijk = localdm.F("SessionId", str1, true);
    localdm.ivZ = localdm.F("FeedId", pL(paramLong), true);
    localdm.izO = paramInt1;
    localdm.izC = paramInt2;
    switch (paramInt2)
    {
    }
    for (localdm.imY = 2L;; localdm.imY = 1L)
    {
      localdm.izN = paramInt3;
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      localdm.izM = localdm.F("FinderUsername", str1, true);
      localdm.imU = localdm.F("Username", com.tencent.mm.model.z.bAW(), true);
      paramString = jm(paramLong);
      if (paramString != null)
      {
        localdm.iwa = paramString.getLikeCount();
        localdm.iwb = paramString.getCommentCount();
      }
      paramLong = l;
      if (BuildInfo.DEBUG) {
        paramLong = 0L;
      }
      localdm.iwf = paramLong;
      localdm.bMH();
      a((a)localdm);
      AppMethodBeat.o(332150);
      return;
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, bui parambui)
  {
    AppMethodBeat.i(332012);
    kotlin.g.b.s.u(paramString1, "actionFeedId");
    kotlin.g.b.s.u(paramString2, "totalFeedId");
    kotlin.g.b.s.u(parambui, "contextObj");
    com.tencent.mm.plugin.report.f.Ozc.b(20586, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), Long.valueOf(com.tencent.mm.model.cn.bDw()), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(parambui.AJo), parambui.zIB, parambui.sessionId });
    AppMethodBeat.o(332012);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(332110);
    FinderItem localFinderItem = jm(paramLong);
    com.tencent.mm.autogen.mmdata.rpt.dc localdc;
    if (localFinderItem != null)
    {
      localdc = new com.tencent.mm.autogen.mmdata.rpt.dc();
      String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localdc.ijk = localdc.F("SessionId", (String)localObject, true);
      localdc.iys = localdc.F("ClickUI", "", true);
      localdc.ivZ = localdc.F("FeedId", pL(paramLong), true);
      localdc.iyt = localdc.F("FeedUsr", localFinderItem.getUserName(), true);
      localdc.iwa = localFinderItem.getLikeCount();
      localdc.iwb = localFinderItem.getCommentCount();
      localdc.iwc = localFinderItem.getFriendLikeCount();
      localdc.iyI = paramInt2;
      localdc.iqr = paramInt1;
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eRX().bmg()).intValue() != 1) {
        break label253;
      }
    }
    label253:
    for (paramLong = 1L;; paramLong = 0L)
    {
      localdc.iyJ = paramLong;
      localdc.ipT = localdc.F("ContextId", paramString1, true);
      localdc.ipU = localdc.F("ClickTabContextId", paramString2, true);
      localdc.bMH();
      a((a)localdc);
      AppMethodBeat.o(332110);
      return;
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, bui parambui)
  {
    AppMethodBeat.i(331763);
    kotlin.g.b.s.u(paramString1, "eid");
    kotlin.g.b.s.u(paramString2, "udfKv");
    ju localju = new ju();
    localju.iGK = paramInt;
    localju.iGL = localju.F("event_time", String.valueOf(com.tencent.mm.model.cn.bDw()), true);
    localju.ixw = localju.F("eid", paramString1, true);
    localju.iAN = localju.F("udf_kv", n.m(paramString2, ",", ";", false), true);
    if (parambui != null)
    {
      localju.inx = localju.F("sessionid", parambui.sessionId, true);
      localju.iGJ = localju.F("findercontextid", parambui.zIB, true);
    }
    localju.bMH();
    a((a)localju);
    AppMethodBeat.o(331763);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, bui parambui)
  {
    AppMethodBeat.i(332451);
    kotlin.g.b.s.u(paramString1, "userName");
    kotlin.g.b.s.u(paramString2, "profileBizUin");
    kotlin.g.b.s.u(parambui, "contextObj");
    fr localfr = new fr();
    localfr.ioV = paramInt;
    localfr.iJm = localfr.F("ProfileUsername", paramString1, true);
    localfr.iJn = localfr.F("ProfileBizUin", paramString2, true);
    localfr.iIg = localfr.F("ExtInfo", paramString3, true);
    localfr.iwI = localfr.F("Contextid", parambui.zIO, true);
    paramString1 = parambui.extraInfo;
    if (paramString1 == null)
    {
      paramString1 = "";
      localfr.iwJ = localfr.F("ExtraInfo", paramString1, true);
      paramString1 = parambui.zIE;
      if (paramString1 != null) {
        break label212;
      }
      paramString1 = "";
    }
    for (;;)
    {
      localfr.iJo = localfr.F("EnterSourceInfo", paramString1, true);
      localfr.bMH();
      a((a)localfr);
      AppMethodBeat.o(332451);
      return;
      paramString2 = n.m(paramString1, ",", ";", false);
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString1 = "";
      break;
      label212:
      paramString2 = n.m(paramString1, ",", ";", false);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
    }
  }
  
  public static void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(166579);
    kotlin.g.b.s.u(paramString1, "topic");
    kotlin.g.b.s.u(paramString2, "receiver");
    gu localgu = new gu();
    String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localgu.ijk = localgu.F("SessionId", (String)localObject, true);
    localgu.iAZ = paramInt1;
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localgu.iBa = l;
      localObject = com.tencent.mm.plugin.finder.utils.as.GiG;
      localgu.iyA = localgu.F("Tag", n.m(com.tencent.mm.plugin.finder.utils.as.C(paramString1, paramInt2, paramLong), ",", ";", false), true);
      localgu.iyB = localgu.F("TagId", "", true);
      localgu.iyD = paramLong;
      localgu.iBc = localgu.F("ForwardToUsr", paramString2, true);
      localgu.bMH();
      a((a)localgu);
      AppMethodBeat.o(166579);
      return;
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean, String paramString1, long paramLong, String paramString2, bui parambui)
  {
    AppMethodBeat.i(331835);
    kotlin.g.b.s.u(paramString1, "receiver");
    dw localdw = new dw();
    long l;
    if (parambui == null)
    {
      l = 0L;
      localdw.iuA = l;
      localdw.iAZ = paramInt;
      if (!paramBoolean) {
        break label226;
      }
      l = 1L;
      label51:
      localdw.iBa = l;
      localdw.iBd = paramLong;
      localdw.nN(paramString1);
      if (parambui != null) {
        break label234;
      }
      paramString1 = "";
      label80:
      localdw.nK(paramString1);
      if (parambui != null) {
        break label256;
      }
      paramString1 = "";
      label96:
      localdw.nR(paramString1);
      if (parambui != null) {
        break label278;
      }
      paramString1 = "";
      label112:
      localdw.nS(paramString1);
      if (parambui != null) {
        break label300;
      }
      paramString1 = "";
      label128:
      localdw.nU(paramString1);
      if (parambui != null) {
        break label345;
      }
      paramString1 = "";
      label144:
      localdw.nV(paramString1);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localdw.izp = localdw.F("ActivityID", paramString1, true);
      if (parambui != null) {
        break label390;
      }
      paramString1 = "";
    }
    for (;;)
    {
      localdw.nX(paramString1);
      localdw.bMH();
      a((a)localdw);
      AppMethodBeat.o(331835);
      return;
      l = parambui.AJo;
      break;
      label226:
      l = 2L;
      break label51;
      label234:
      String str = parambui.sessionId;
      paramString1 = str;
      if (str != null) {
        break label80;
      }
      paramString1 = "";
      break label80;
      label256:
      str = parambui.zIB;
      paramString1 = str;
      if (str != null) {
        break label96;
      }
      paramString1 = "";
      break label96;
      label278:
      str = parambui.zIO;
      paramString1 = str;
      if (str != null) {
        break label112;
      }
      paramString1 = "";
      break label112;
      label300:
      paramString1 = parambui.extraInfo;
      if (paramString1 == null)
      {
        paramString1 = "";
        break label128;
      }
      str = n.m(paramString1, ",", ";", false);
      paramString1 = str;
      if (str != null) {
        break label128;
      }
      paramString1 = "";
      break label128;
      label345:
      paramString1 = parambui.zIE;
      if (paramString1 == null)
      {
        paramString1 = "";
        break label144;
      }
      str = n.m(paramString1, ",", ";", false);
      paramString1 = str;
      if (str != null) {
        break label144;
      }
      paramString1 = "";
      break label144;
      label390:
      paramString2 = parambui.DUN;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
    }
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, bui parambui)
  {
    AppMethodBeat.i(331787);
    kotlin.g.b.s.u(paramString, "mutualAdInfo");
    ck localck = new ck();
    localck.ipW = localck.F("feedid", pL(paramLong), true);
    localck.iwE = paramInt1;
    localck.iqW = paramInt2;
    Object localObject;
    if (paramInt2 == 2)
    {
      localObject = new com.tencent.mm.ad.i();
      ((com.tencent.mm.ad.i)localObject).au("duration", paramInt4);
      ((com.tencent.mm.ad.i)localObject).au("playpercent", (int)(paramInt3 * 1.0F / paramInt4 * 100.0F));
      localObject = ((com.tencent.mm.ad.i)localObject).toString();
      kotlin.g.b.s.s(localObject, "playInfo.toString()");
      localck.iwF = localck.F("feedplayinfo", n.m((String)localObject, ",", ";", false), true);
    }
    localck.iwG = localck.F("MutualAdInfo", n.m(paramString, ",", ";", false), true);
    if (parambui != null)
    {
      paramString = parambui.extraInfo;
      if (paramString != null) {
        break label329;
      }
      paramString = "";
      localck.iwJ = localck.F("ExtraInfo", paramString, true);
      paramString = parambui.zIE;
      if (paramString != null) {
        break label360;
      }
      paramString = "";
      label225:
      localck.iwK = localck.F("enterSourceInfo", paramString, true);
      paramString = p(paramLong, parambui.AJo);
      if (paramString != null) {
        break label391;
      }
      paramString = "";
    }
    for (;;)
    {
      localck.iwH = localck.F("sessionbuffer", paramString, true);
      localck.iwI = localck.F("Contextid", parambui.zIO, true);
      localck.iwD = parambui.AJo;
      localck.bMH();
      a((a)localck);
      AppMethodBeat.o(331787);
      return;
      label329:
      localObject = n.m(paramString, ",", ";", false);
      paramString = (String)localObject;
      if (localObject != null) {
        break;
      }
      paramString = "";
      break;
      label360:
      localObject = n.m(paramString, ",", ";", false);
      paramString = (String)localObject;
      if (localObject != null) {
        break label225;
      }
      paramString = "";
      break label225;
      label391:
      localObject = n.m(paramString, ",", ";", false);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
    }
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(331870);
    kotlin.g.b.s.u(paramString1, "fromUser");
    dh localdh = new dh();
    String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localdh.ni(str1);
    localdh.izg = paramInt1;
    localdh.izh = paramLong2;
    localdh.nj(paramString1);
    localdh.nk(pL(paramLong1));
    localdh.izk = paramInt2;
    localdh.izl = paramInt3;
    if (paramString3 != null) {
      localdh.np(paramString3);
    }
    if (paramString2 != null) {
      localdh.no(paramString2);
    }
    paramString2 = jm(paramLong1);
    if (paramString2 != null)
    {
      localdh.nl(paramString2.getFeedObject().username);
      paramString1 = com.tencent.mm.plugin.finder.utils.as.GiG;
      localdh.nm(n.m(com.tencent.mm.plugin.finder.utils.as.F(paramString2), ",", ";", false));
      paramString3 = (Iterable)paramString2.getMediaList();
      paramString1 = (Collection)new ArrayList(kotlin.a.p.a(paramString3, 10));
      paramString3 = paramString3.iterator();
      if (paramString3.hasNext())
      {
        if (Util.isNullOrNil(((dji)paramString3.next()).coverUrl)) {}
        for (paramLong1 = 0L;; paramLong1 = 1L)
        {
          localdh.izj = paramLong1;
          paramString1.add(ah.aiuX);
          break;
        }
      }
      paramString1 = paramString2.getFinderObject().objectDesc;
      if (paramString1 != null) {
        break label405;
      }
      paramString1 = null;
      localdh.nn(paramString1);
      paramString1 = paramString2.getFeedObject().objectDesc;
      if (paramString1 != null) {
        break label433;
      }
      paramString1 = null;
      label323:
      if (paramString1 == null) {
        break label512;
      }
      paramString1 = paramString2.getFeedObject().objectDesc;
      if (paramString1 != null) {
        break label461;
      }
      paramString1 = null;
      label346:
      paramString1 = (CharSequence)paramString1;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label507;
      }
      paramInt1 = 1;
      label370:
      if (paramInt1 != 0) {
        break label512;
      }
    }
    label512:
    for (paramLong1 = 2L;; paramLong1 = 1L)
    {
      localdh.izn = paramLong1;
      localdh.bMH();
      a((a)localdh);
      AppMethodBeat.o(331870);
      return;
      label405:
      paramString1 = paramString1.feedBgmInfo;
      if (paramString1 == null)
      {
        paramString1 = null;
        break;
      }
      paramString1 = paramString1.groupId;
      break;
      label433:
      paramString1 = paramString1.feedBgmInfo;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label323;
      }
      paramString1 = paramString1.musicInfo;
      break label323;
      label461:
      paramString1 = paramString1.feedBgmInfo;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label346;
      }
      paramString1 = paramString1.musicInfo;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label346;
      }
      paramString1 = paramString1.HsD;
      break label346;
      label507:
      paramInt1 = 0;
      break label370;
    }
  }
  
  public static void a(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3, bui parambui)
  {
    AppMethodBeat.i(331934);
    kotlin.g.b.s.u(paramString, "receiver");
    dw localdw = new dw();
    long l;
    if (parambui == null)
    {
      l = 0L;
      localdw.iuA = l;
      localdw.iAZ = paramInt;
      localdw.iBa = paramLong2;
      localdw.iBd = paramLong3;
      localdw.nN(paramString);
      if (parambui != null) {
        break label242;
      }
      paramString = "";
      label76:
      localdw.nK(paramString);
      if (parambui != null) {
        break label266;
      }
      paramInt = 0;
      label91:
      localdw.nT(p(paramLong1, paramInt));
      if (parambui != null) {
        break label275;
      }
      paramString = "";
      label112:
      localdw.nR(paramString);
      if (parambui != null) {
        break label299;
      }
      paramString = "";
      label130:
      localdw.nS(paramString);
      if (parambui != null) {
        break label323;
      }
      paramString = "";
      label148:
      localdw.nU(paramString);
      if (parambui != null) {
        break label374;
      }
      paramString = "";
      label166:
      localdw.nV(paramString);
      localdw.izo = localdw.F("ColumnId", com.tencent.mm.ae.d.hF(paramLong1), true);
      if (parambui != null) {
        break label425;
      }
      paramString = "";
    }
    for (;;)
    {
      localdw.nX(paramString);
      localdw.bMH();
      a((a)localdw);
      AppMethodBeat.o(331934);
      return;
      l = parambui.AJo;
      break;
      label242:
      String str = parambui.sessionId;
      paramString = str;
      if (str != null) {
        break label76;
      }
      paramString = "";
      break label76;
      label266:
      paramInt = parambui.AJo;
      break label91;
      label275:
      str = parambui.zIB;
      paramString = str;
      if (str != null) {
        break label112;
      }
      paramString = "";
      break label112;
      label299:
      str = parambui.zIO;
      paramString = str;
      if (str != null) {
        break label130;
      }
      paramString = "";
      break label130;
      label323:
      paramString = parambui.extraInfo;
      if (paramString == null)
      {
        paramString = "";
        break label148;
      }
      str = n.m(paramString, ",", ";", false);
      paramString = str;
      if (str != null) {
        break label148;
      }
      paramString = "";
      break label148;
      label374:
      paramString = parambui.zIE;
      if (paramString == null)
      {
        paramString = "";
        break label166;
      }
      str = n.m(paramString, ",", ";", false);
      paramString = str;
      if (str != null) {
        break label166;
      }
      paramString = "";
      break label166;
      label425:
      parambui = parambui.DUN;
      paramString = parambui;
      if (parambui == null) {
        paramString = "";
      }
    }
  }
  
  public static void a(long paramLong, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(331855);
    kotlin.g.b.s.u(paramString1, "fromUser");
    a(paramLong, paramInt1, 1L, paramString1, paramInt2, paramInt3, null, paramString2);
    AppMethodBeat.o(331855);
  }
  
  private static void a(long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    bd localbd = null;
    AppMethodBeat.i(331728);
    if (paramString != null)
    {
      Object localObject = n.m(paramString, ",", ";", false);
      if (localObject != null)
      {
        paramString = q(paramLong1, paramInt);
        if (paramString != null) {
          break label337;
        }
        paramString = localbd;
        localbd = new bd((String)localObject);
        localbd.AJo = paramInt;
        localbd.FuM.id = paramLong1;
        localObject = localbd.FuM;
        if (paramLong2 <= 0L) {
          break label360;
        }
        label84:
        ((bra)localObject).ZZb = paramLong2;
        localbd.FuM.ZZe = paramString;
        switch (paramInt)
        {
        default: 
          ((Map)Fsc).put(paramLong1 + '_' + paramInt, localbd);
        }
      }
    }
    for (;;)
    {
      Fsb.put(paramLong1, Long.valueOf(com.tencent.mm.model.cn.bDw()));
      AppMethodBeat.o(331728);
      return;
      label337:
      bra localbra = paramString.FuM;
      paramString = localbd;
      if (localbra == null) {
        break;
      }
      paramString = localbra.ZZe;
      break;
      label360:
      paramLong2 = com.tencent.mm.model.cn.bDv();
      break label84;
      ((Map)Fsc).put(paramLong1 + "_6", localbd);
      ((Map)Fsc).put(paramLong1 + "_23", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_9", localbd);
      ((Map)Fsc).put(paramLong1 + "_22", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_15", localbd);
      ((Map)Fsc).put(paramLong1 + "_16", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_26", localbd);
      ((Map)Fsc).put(paramLong1 + "_27", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_24", localbd);
      ((Map)Fsc).put(paramLong1 + "_21", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_32", localbd);
      ((Map)Fsc).put(paramLong1 + "_1", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_33", localbd);
      ((Map)Fsc).put(paramLong1 + "_8", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_59", localbd);
      ((Map)Fsc).put(paramLong1 + "_60", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_35", localbd);
      ((Map)Fsc).put(paramLong1 + "_2", localbd);
      continue;
      ((Map)Fsc).put(paramLong1 + "_119", localbd);
      ((Map)Fsc).put(paramLong1 + "_120", localbd);
    }
  }
  
  public static void a(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(332397);
    paramString1 = com.tencent.mm.ae.d.hF(paramLong) + ',' + 2 + ',' + paramInt1 + ',' + Util.nullAsNil(paramString1) + ',' + Util.nullAsNil(paramString2) + ',' + Util.nullAsNil(paramString3) + ',' + Util.nullAsNil(paramString4) + ',' + paramInt2;
    com.tencent.mm.plugin.report.f.Ozc.kvStat(20717, paramString1);
    AppMethodBeat.o(332397);
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt)
  {
    AppMethodBeat.i(331839);
    kotlin.g.b.s.u(paramString, "paperWording");
    ba localba = new ba();
    localba.iqk = localba.F("Feedid", pL(paramLong1), true);
    localba.iqm = paramLong2;
    localba.iqn = localba.F("DailyPaperId", pL(paramLong3), true);
    localba.iqo = localba.F("DailyPaperWording", paramString, true);
    localba.iqq = paramLong4;
    localba.ev(com.tencent.mm.model.cn.bDw());
    localba.iqp = localba.F("SessionBuffer", p(paramLong1, paramInt), true);
    localba.bMH();
    a((a)localba);
    AppMethodBeat.o(331839);
  }
  
  public static void a(long paramLong1, long paramLong2, bui parambui)
  {
    Object localObject = null;
    AppMethodBeat.i(332426);
    com.tencent.mm.autogen.mmdata.rpt.b localb = new com.tencent.mm.autogen.mmdata.rpt.b();
    localb.ijo = paramLong1;
    localb.ijp = localb.F("EventTime", String.valueOf(com.tencent.mm.model.cn.bDw()), true);
    localb.ijq = 1L;
    localb.ijr = localb.F("ActivityId", com.tencent.mm.ae.d.hF(paramLong2), true);
    String str;
    if (parambui == null)
    {
      paramLong1 = 0L;
      localb.ijn = paramLong1;
      if (parambui != null) {
        break label185;
      }
      str = null;
      label89:
      localb.ijk = localb.F("SessionId", str, true);
      if (parambui != null) {
        break label195;
      }
      str = null;
      label113:
      localb.ijl = localb.F("ClickTabContextid", str, true);
      if (parambui != null) {
        break label205;
      }
    }
    label185:
    label195:
    label205:
    for (parambui = localObject;; parambui = parambui.zIO)
    {
      localb.ijm = localb.F("FinderContexId", parambui, true);
      localb.bMH();
      a((a)localb);
      AppMethodBeat.o(332426);
      return;
      paramLong1 = parambui.AJo;
      break;
      str = parambui.sessionId;
      break label89;
      str = parambui.zIB;
      break label113;
    }
  }
  
  public static void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331751);
    kotlin.g.b.s.u(paramString, "topic");
    FinderItem localFinderItem = jm(paramLong);
    if (localFinderItem != null)
    {
      gt localgt = new gt();
      String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localgt.ijk = localgt.F("SessionId", (String)localObject, true);
      localgt.iwd = localgt.F("CurrentPageName", "", true);
      localgt.iuA = paramInt2;
      localgt.ipW = localgt.F("feedid", pL(localFinderItem.getId()), true);
      localgt.iLB = localFinderItem.getMediaType();
      localObject = com.tencent.mm.plugin.finder.utils.as.GiG;
      localgt.iyA = localgt.F("Tag", n.m(com.tencent.mm.plugin.finder.utils.as.C(paramString, paramInt1, 0L), ",", ";", false), true);
      localgt.iyB = localgt.F("TagId", "", true);
      localgt.iwa = localFinderItem.getFeedObject().likeCount;
      localgt.iwb = localFinderItem.getFeedObject().commentCount;
      localgt.iwc = localFinderItem.getFeedObject().friendLikeCount;
      localgt.bMH();
      a((a)localgt);
    }
    AppMethodBeat.o(331751);
  }
  
  public static void a(long paramLong1, String paramString1, long paramLong2, String paramString2, bui parambui)
  {
    Object localObject = null;
    AppMethodBeat.i(332434);
    kotlin.g.b.s.u(paramString1, "action");
    cl localcl = new cl();
    localcl.iwL = paramLong1;
    localcl.iwM = localcl.F("Action", paramString1, true);
    localcl.ijq = paramLong2;
    localcl.ijr = localcl.F("ActivityId", paramString2, true);
    if (parambui == null)
    {
      paramLong1 = 0L;
      localcl.ijn = paramLong1;
      if (parambui != null) {
        break label179;
      }
      paramString1 = null;
      label88:
      localcl.ijk = localcl.F("SessionId", paramString1, true);
      if (parambui != null) {
        break label188;
      }
      paramString1 = null;
      label110:
      localcl.ijl = localcl.F("ClickTabContextid", paramString1, true);
      if (parambui != null) {
        break label197;
      }
    }
    label179:
    label188:
    label197:
    for (paramString1 = localObject;; paramString1 = parambui.zIO)
    {
      localcl.ijm = localcl.F("FinderContexId", paramString1, true);
      localcl.bMH();
      a((a)localcl);
      AppMethodBeat.o(332434);
      return;
      paramLong1 = parambui.AJo;
      break;
      paramString1 = parambui.sessionId;
      break label88;
      paramString1 = parambui.zIB;
      break label110;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Integer paramInteger)
  {
    long l2 = 0L;
    AppMethodBeat.i(332406);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramContext = as.a.hu(paramContext);
    if (paramContext == null)
    {
      paramContext = null;
      localObject = new da();
      ((da)localObject).iyp = System.currentTimeMillis();
      ((da)localObject).iyq = paramInt1;
      ((da)localObject).iyr = paramInt2;
      if (paramContext != null) {
        break label113;
      }
      l1 = 0L;
      label70:
      ((da)localObject).ijn = l1;
      if (paramInteger != null) {
        break label123;
      }
    }
    label113:
    label123:
    for (long l1 = l2;; l1 = paramInteger.intValue())
    {
      ((da)localObject).ixC = l1;
      ((da)localObject).bMH();
      AppMethodBeat.o(332406);
      return;
      paramContext = paramContext.fou();
      break;
      l1 = paramContext.AJo;
      break label70;
    }
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(332375);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = new gi();
    paramContext.ixD = paramLong1;
    paramContext.ila = paramLong2;
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      paramContext.iKS = paramLong1;
      paramContext.bMH();
      AppMethodBeat.o(332375);
      return;
    }
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, com.tencent.mm.plugin.finder.feed.jumper.k paramk)
  {
    int j = 0;
    AppMethodBeat.i(331708);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "key");
    kotlin.g.b.s.u(paramk, "infoEx");
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramContext = as.a.hu(paramContext);
    int i;
    if (paramContext == null) {
      i = 0;
    }
    for (;;)
    {
      paramContext = q(paramLong, i);
      if (paramContext == null)
      {
        paramContext = null;
        label61:
        if (paramContext == null) {}
      }
      else
      {
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("jumpinfoType", paramk.hVf.jumpinfo_type);
          localObject = paramk.hVf.native_info;
          if (localObject == null)
          {
            localObject = null;
            label109:
            localJSONObject2.put("nativeType", localObject);
            localJSONObject2.put("wording", paramk.hVf.wording);
            localObject = paramContext.ZZe;
            paramk = (com.tencent.mm.plugin.finder.feed.jumper.k)localObject;
            if (localObject == null) {
              paramk = "";
            }
            i = j;
            if (((CharSequence)paramk).length() == 0) {
              i = 1;
            }
            if (i == 0) {
              break label300;
            }
          }
          label300:
          for (paramk = new JSONObject();; paramk = new JSONObject(paramk))
          {
            JSONObject localJSONObject1 = paramk.optJSONObject("jumpicon_info");
            localObject = localJSONObject1;
            if (localJSONObject1 == null) {
              localObject = new JSONObject();
            }
            ((JSONObject)localObject).put("jumpicon_info", localJSONObject2);
            paramk.put(paramString, localObject);
            paramContext.ZZe = paramk.toString();
            AppMethodBeat.o(331708);
            return;
            paramContext = paramContext.fou();
            if (paramContext == null)
            {
              i = 0;
              break;
            }
            i = paramContext.AJo;
            break;
            paramContext = paramContext.FuM;
            break label61;
            localObject = Integer.valueOf(((NativeInfo)localObject).native_type);
            break label109;
          }
          AppMethodBeat.o(331708);
        }
        catch (JSONException paramContext)
        {
          Log.e(TAG, paramContext.getMessage());
        }
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2, long paramLong4)
  {
    AppMethodBeat.i(332365);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramContext = as.a.hu(paramContext);
    if (paramContext == null)
    {
      paramContext = null;
      localObject = new fg();
      if (paramContext != null) {
        break label141;
      }
      paramContext = null;
      label44:
      ((fg)localObject).inx = ((fg)localObject).F("sessionid", paramContext, true);
      ((fg)localObject).eV(paramLong1);
      if (!paramBoolean1) {
        break label149;
      }
      paramLong1 = 1L;
      label72:
      ((fg)localObject).iGO = paramLong1;
      ((fg)localObject).inc = paramLong2;
      ((fg)localObject).iGP = paramLong3;
      ((fg)localObject).iGQ = System.currentTimeMillis();
      if (!paramBoolean2) {
        break label154;
      }
    }
    label141:
    label149:
    label154:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      ((fg)localObject).iGR = paramLong1;
      ((fg)localObject).iGS = paramLong4;
      ((fg)localObject).bMH();
      AppMethodBeat.o(332365);
      return;
      paramContext = paramContext.fou();
      break;
      paramContext = paramContext.sessionId;
      break label44;
      paramLong1 = 0L;
      break label72;
    }
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.finder.feed.jumper.k paramk, long paramLong, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(332531);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramk, "finderJumpInfoEx");
    label74:
    int i;
    if (3 == paramk.hVf.jumpinfo_type)
    {
      paramk = paramk.hVf.native_info;
      if (paramk == null)
      {
        paramk = null;
        if (paramk != null) {
          break label74;
        }
      }
      for (;;)
      {
        if (paramk == null)
        {
          AppMethodBeat.o(332531);
          return;
          paramk = Integer.valueOf(paramk.native_type);
          break;
          if (paramk.intValue() == 4)
          {
            paramk = new JSONObject();
            paramk.put("msgId", paramLong);
            if (!paramBoolean) {
              break label176;
            }
            i = 1;
            label107:
            paramk = paramk.toString();
            kotlin.g.b.s.s(paramk, "kvJson.toString()");
            paramk = n.bV(paramk, ",", ";");
            as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
            paramContext = as.a.hu(paramContext);
            if (paramContext != null) {
              break label182;
            }
          }
        }
      }
    }
    label176:
    label182:
    for (paramContext = localObject;; paramContext = paramContext.fou())
    {
      b(i, "link_msg_topic", paramk, paramContext);
      do
      {
        AppMethodBeat.o(332531);
        return;
      } while (paramk.intValue() != 8);
      break;
      i = 0;
      break label107;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l2 = 2L;
    Object localObject2 = null;
    AppMethodBeat.i(332413);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramContext = as.a.hu(paramContext);
    gz localgz;
    if (paramContext == null)
    {
      paramContext = null;
      localgz = new gz();
      if (paramContext != null) {
        break label230;
      }
      l1 = 0L;
      label53:
      localgz.iqr = l1;
      if (paramContext != null) {
        break label240;
      }
      localObject1 = null;
      label67:
      localgz.ixm = localgz.F("Sessionid", (String)localObject1, true);
      if (paramContext != null) {
        break label249;
      }
      localObject1 = null;
      label90:
      localgz.iwI = localgz.F("Contextid", (String)localObject1, true);
      if (paramContext != null) {
        break label258;
      }
      localObject1 = localObject2;
      label114:
      localgz.ijl = localgz.F("ClickTabContextid", (String)localObject1, true);
      if (paramContext != null) {
        break label267;
      }
      l1 = 0L;
      label137:
      localgz.ipW = localgz.F("feedid", com.tencent.mm.ae.d.hF(l1), true);
      if (!paramBoolean1) {
        break label276;
      }
      l1 = 1L;
      label163:
      localgz.ila = l1;
      localgz.iLN = paramInt;
      if (!paramBoolean2) {
        break label284;
      }
      l1 = 2L;
      label186:
      localgz.iLO = l1;
      if (!paramBoolean3) {
        break label290;
      }
    }
    label258:
    label267:
    label276:
    label284:
    label290:
    for (long l1 = l2;; l1 = 1L)
    {
      localgz.iLP = l1;
      localgz.bMH();
      AppMethodBeat.o(332413);
      return;
      paramContext = paramContext.fou();
      break;
      label230:
      l1 = paramContext.AJo;
      break label53;
      label240:
      localObject1 = paramContext.sessionId;
      break label67;
      label249:
      localObject1 = paramContext.zIO;
      break label90;
      localObject1 = paramContext.zIB;
      break label114;
      l1 = paramContext.ADF;
      break label137;
      l1 = 2L;
      break label163;
      l1 = 1L;
      break label186;
    }
  }
  
  public static void a(FinderPoiFeedUI.a parama, long paramLong1, bui parambui, String paramString1, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(332462);
    kotlin.g.b.s.u(parama, "action");
    lb locallb = new lb();
    locallb.ila = parama.ordinal();
    locallb.inE = com.tencent.mm.model.cn.bDw();
    locallb.iNh = paramLong2;
    locallb.iYG = paramLong1;
    if (parambui == null)
    {
      parama = null;
      locallb.iwI = locallb.F("Contextid", parama, true);
      if (parambui != null) {
        break label172;
      }
    }
    label172:
    for (parama = null;; parama = parambui.sessionId)
    {
      locallb.ixm = locallb.F("Sessionid", parama, true);
      locallb.iYH = locallb.F("POIID", paramString1, true);
      locallb.iYI = locallb.F("POIDetail", paramString2, true);
      locallb.iYJ = locallb.F("sourceid", paramString3, true);
      locallb.bMH();
      a((a)locallb);
      AppMethodBeat.o(332462);
      return;
      parama = parambui.zIO;
      break;
    }
  }
  
  public static void a(ca paramca, int paramInt, long paramLong1, String paramString, bui parambui, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(331917);
    kotlin.g.b.s.u(paramca, "item");
    kotlin.g.b.s.u(paramString, "receiver");
    dw localdw = new dw();
    Object localObject;
    if (parambui == null)
    {
      localObject = "";
      localdw.nK((String)localObject);
      localdw.iAZ = paramInt;
      localdw.iBa = paramLong1;
      localdw.nL(pL(paramca.eDF()));
      localObject = paramca.contact;
      if (localObject != null) {
        break label363;
      }
      localObject = "";
      label93:
      localdw.nM((String)localObject);
      localdw.nN(paramString);
      localdw.iwa = paramca.getFeedObject().likeCount;
      localdw.nO("");
      localdw.nP("");
      localdw.nQ("");
      if (parambui != null) {
        break label387;
      }
      paramLong1 = 0L;
      label156:
      localdw.iuA = paramLong1;
      if (parambui != null) {
        break label397;
      }
      paramString = "";
      label172:
      localdw.nR(paramString);
      if (parambui != null) {
        break label421;
      }
      paramString = "";
      label190:
      localdw.nS(paramString);
      paramString = paramca.ABK;
      if (paramString != null) {
        break label445;
      }
      paramLong1 = 0L;
      label211:
      if (parambui != null) {
        break label454;
      }
      paramInt = 0;
      label218:
      localdw.nT(p(paramLong1, paramInt));
      localdw.iBd = paramLong2;
      if (parambui != null) {
        break label463;
      }
      paramString = "";
      label246:
      localdw.nU(paramString);
      if (parambui != null) {
        break label514;
      }
      paramString = "";
      label264:
      localdw.nV(paramString);
      paramca = paramca.ABK;
      if (paramca != null) {
        break label565;
      }
      paramLong1 = l;
      label284:
      localdw.izY = localdw.F("LongVideoId", pL(paramLong1), true);
      if (parambui != null) {
        break label573;
      }
      paramca = "";
    }
    for (;;)
    {
      localdw.nX(paramca);
      localdw.bMH();
      a((a)localdw);
      AppMethodBeat.o(331917);
      return;
      String str = parambui.sessionId;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label363:
      str = ((FinderContact)localObject).username;
      localObject = str;
      if (str != null) {
        break label93;
      }
      localObject = "";
      break label93;
      label387:
      paramLong1 = parambui.AJo;
      break label156;
      label397:
      localObject = parambui.zIB;
      paramString = (String)localObject;
      if (localObject != null) {
        break label172;
      }
      paramString = "";
      break label172;
      label421:
      localObject = parambui.zIO;
      paramString = (String)localObject;
      if (localObject != null) {
        break label190;
      }
      paramString = "";
      break label190;
      label445:
      paramLong1 = paramString.id;
      break label211;
      label454:
      paramInt = parambui.AJo;
      break label218;
      label463:
      paramString = parambui.extraInfo;
      if (paramString == null)
      {
        paramString = "";
        break label246;
      }
      localObject = n.m(paramString, ",", ";", false);
      paramString = (String)localObject;
      if (localObject != null) {
        break label246;
      }
      paramString = "";
      break label246;
      label514:
      paramString = parambui.zIE;
      if (paramString == null)
      {
        paramString = "";
        break label264;
      }
      localObject = n.m(paramString, ",", ";", false);
      paramString = (String)localObject;
      if (localObject != null) {
        break label264;
      }
      paramString = "";
      break label264;
      label565:
      paramLong1 = paramca.id;
      break label284;
      label573:
      paramString = parambui.DUN;
      paramca = paramString;
      if (paramString == null) {
        paramca = "";
      }
    }
  }
  
  public static void a(t paramt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178394);
    kotlin.g.b.s.u(paramt, "rootComment");
    FinderItem localFinderItem = jm(paramt.ECu.field_feedId);
    dj localdj;
    if (localFinderItem != null)
    {
      localdj = new dj();
      localdj.izt = paramInt1;
      localdj.izu = paramt.ECu.eZI().levelTwoComment.size();
      String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localdj.ijk = localdj.F("SessionId", str1, true);
      localdj.ivZ = localdj.F("FeedId", pL(localFinderItem.getId()), true);
      localdj.izv = localdj.F("FeedUsername", localFinderItem.getUserName(), true);
      localdj.izy = System.currentTimeMillis();
      localdj.izw = localdj.F("CommentUsername", paramt.ECu.getUsername(), true);
      localdj.izx = paramt.ECu.eZI().likeCount;
      localdj.izz = localdj.F("CommentId", pL(paramt.bZA()), true);
      localdj.izA = paramt.ECu.eZI().expandCommentCount;
      switch (paramInt2)
      {
      default: 
        localdj.imY = 2L;
        if (((paramt.ECu.eZI().displayFlag & 0x8) <= 0) && ((paramt.ECu.eZI().displayFlag & 0x2) <= 0)) {
          break;
        }
      }
    }
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      localdj.izB = paramInt1;
      localdj.izC = paramInt2;
      localdj.bMH();
      a((a)localdj);
      AppMethodBeat.o(178394);
      return;
      localdj.imY = 1L;
      break;
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(332325);
    kotlin.g.b.s.u(parama, "struct");
    Object localObject3;
    if ((parama instanceof dn)) {
      localObject3 = ((dn)parama).izF;
    }
    for (;;)
    {
      try
      {
        Object localObject4 = (dn)parama;
        localObject1 = (CharSequence)((dn)parama).izF;
        if (localObject1 == null) {
          break label232;
        }
        if (((CharSequence)localObject1).length() == 0)
        {
          break label232;
          ((dn)localObject4).nx((String)localObject1);
          localObject1 = TAG;
          localObject4 = new StringBuilder("report18054 ");
          String str2 = parama.aIF();
          kotlin.g.b.s.s(str2, "struct.toShowString()");
          Log.i((String)localObject1, n.bV(str2, "\r\n", " "));
          return;
        }
        i = 0;
      }
      finally
      {
        Object localObject1;
        ((dn)parama).nx((String)localObject3);
        AppMethodBeat.o(332325);
      }
      localObject1 = localObject3;
      continue;
      String str1 = TAG;
      localObject3 = new StringBuilder("report").append(parama.getId()).append(' ');
      parama = parama.aIF();
      kotlin.g.b.s.s(parama, "struct.toShowString()");
      Log.i(str1, n.bV(parama, "\r\n", " "));
      AppMethodBeat.o(332325);
      return;
      label232:
      int i = 1;
      if (i == 0) {
        str1 = "...";
      }
    }
  }
  
  public static void a(FinderObject paramFinderObject, int paramInt)
  {
    AppMethodBeat.i(331719);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    p(paramFinderObject);
    long l2 = paramFinderObject.id;
    String str = paramFinderObject.sessionBuffer;
    paramFinderObject = paramFinderObject.client_local_buffer;
    if (paramFinderObject == null) {}
    for (long l1 = 0L;; l1 = paramFinderObject.ZZf)
    {
      a(l2, paramInt, str, l1);
      AppMethodBeat.o(331719);
      return;
    }
  }
  
  public static void a(FinderObject paramFinderObject, bui parambui)
  {
    AppMethodBeat.i(332485);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    if (parambui != null) {
      a(paramFinderObject, parambui.AJo);
    }
    AppMethodBeat.o(332485);
  }
  
  public static void a(bui parambui, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(332293);
    kotlin.g.b.s.u(parambui, "contextObj");
    co localco = new co();
    localco.iqr = parambui.AJo;
    localco.ixm = localco.F("Sessionid", parambui.sessionId, true);
    localco.iwI = localco.F("Contextid", parambui.zIO, true);
    localco.ipU = localco.F("ClickTabContextId", parambui.zIB, true);
    localco.ikE = paramInt1;
    if (paramInt2 != 0)
    {
      parambui = com.tencent.mm.ui.component.k.aeZF;
      if (!((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UW(paramInt2)) {
        break label152;
      }
    }
    label152:
    for (long l = 1L;; l = 0L)
    {
      localco.ixn = l;
      localco.bMH();
      a((a)localco);
      AppMethodBeat.o(332293);
      return;
    }
  }
  
  public static void a(bui parambui, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, long paramLong2)
  {
    AppMethodBeat.i(332073);
    kotlin.g.b.s.u(parambui, "contextObj");
    kotlin.g.b.s.u(paramString, "replyUsername");
    Object localObject = jm(paramLong1);
    db localdb;
    long l;
    if (localObject != null)
    {
      localdb = new db();
      localdb.mV(parambui.sessionId);
      localdb.mW("");
      localdb.mX(pL(paramLong1));
      localdb.mY(((FinderItem)localObject).getUserName());
      localdb.iyq = paramInt1;
      localdb.ioV = paramInt2;
      localdb.iyu = paramInt3;
      localdb.mZ(paramString);
      localdb.iyw = paramInt4;
      localdb.iwa = ((FinderItem)localObject).getLikeCount();
      localdb.iwb = ((FinderItem)localObject).getCommentCount();
      localdb.iwc = ((FinderItem)localObject).getFriendLikeCount();
      localdb.iwe = ((FinderItem)localObject).getMediaType();
      paramString = com.tencent.mm.plugin.finder.utils.as.GiG;
      localdb.na(n.m(com.tencent.mm.plugin.finder.utils.as.F((FinderItem)localObject), ",", ";", false));
      localdb.nb("");
      localdb.iuA = parambui.AJo;
      if (!kotlin.g.b.s.p(((FinderItem)localObject).getUserName(), com.tencent.mm.model.z.bAW())) {
        break label456;
      }
      l = 1L;
      localdb.iyE = l;
      if (!paramBoolean1) {
        break label462;
      }
      l = 1L;
      label241:
      localdb.iyF = l;
      localObject = parambui.zIO;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localdb.nc(paramString);
      localObject = parambui.zIB;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localdb.nd(paramString);
      paramInt1 = parambui.AJo;
      if ((paramInt1 != 45) && (paramInt1 != 46) && (paramInt1 != 47) && (paramInt1 != 48) && (paramInt1 != 53) && (paramInt1 != 54)) {
        break label468;
      }
      paramInt1 = 1;
      label347:
      if (paramInt1 == 0) {
        break label473;
      }
      paramString = p(paramLong2, parambui.AJo);
      label362:
      localdb.ne(paramString);
      if (!paramBoolean2) {
        break label486;
      }
      paramLong1 = 1L;
      label377:
      localdb.iyG = paramLong1;
      paramString = parambui.extraInfo;
      if (paramString != null) {
        break label491;
      }
      paramString = "";
      label399:
      localdb.nf(paramString);
      parambui = parambui.zIE;
      if (parambui != null) {
        break label522;
      }
      parambui = "";
    }
    for (;;)
    {
      localdb.ng(parambui);
      localdb.iyH = paramInt5;
      localdb.bMH();
      a((a)localdb);
      AppMethodBeat.o(332073);
      return;
      label456:
      l = 0L;
      break;
      label462:
      l = 0L;
      break label241;
      label468:
      paramInt1 = 0;
      break label347;
      label473:
      paramString = p(paramLong1, parambui.AJo);
      break label362;
      label486:
      paramLong1 = 0L;
      break label377;
      label491:
      localObject = n.m(paramString, ",", ";", false);
      paramString = (String)localObject;
      if (localObject != null) {
        break label399;
      }
      paramString = "";
      break label399;
      label522:
      paramString = n.m(parambui, ",", ";", false);
      parambui = paramString;
      if (paramString == null) {
        parambui = "";
      }
    }
  }
  
  public static void a(bui parambui, long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(332267);
    kotlin.g.b.s.u(parambui, "contextObj");
    if (jm(paramLong) != null)
    {
      fu localfu = new fu();
      localfu.ipV = parambui.AJo;
      localfu.ipT = localfu.F("ContextId", parambui.zIO, true);
      localfu.ipU = localfu.F("ClickTabContextId", parambui.zIB, true);
      localfu.ijk = localfu.F("SessionId", parambui.sessionId, true);
      localfu.iqk = localfu.F("Feedid", com.tencent.mm.ae.d.hF(paramLong), true);
      parambui = paramString;
      if (paramString == null) {
        parambui = "";
      }
      localfu.imU = localfu.F("Username", parambui, true);
      localfu.ikE = paramInt;
      localfu.bMH();
      a((a)localfu);
    }
    AppMethodBeat.o(332267);
  }
  
  public static void a(bui parambui, long paramLong, Integer paramInteger)
  {
    long l = 0L;
    AppMethodBeat.i(332418);
    kotlin.g.b.s.u(parambui, "contextObj");
    ct localct = new ct();
    localct.iqk = localct.F("Feedid", com.tencent.mm.ae.d.hF(paramLong), true);
    localct.ixB = 0L;
    localct.iqr = parambui.AJo;
    if (paramInteger == null) {}
    for (paramLong = l;; paramLong = paramInteger.intValue())
    {
      localct.ixC = paramLong;
      localct.bMH();
      AppMethodBeat.o(332418);
      return;
    }
  }
  
  public static void a(bui parambui, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(332098);
    kotlin.g.b.s.u(parambui, "contextObj");
    kotlin.g.b.s.u(paramString, "finderUsername");
    db localdb = new db();
    localdb.mV(parambui.sessionId);
    localdb.mW("");
    localdb.iuA = parambui.AJo;
    localdb.mY(paramString);
    localdb.iyq = 3L;
    localdb.ioV = paramInt;
    localdb.mZ("");
    localdb.iyw = 2L;
    localdb.nc(parambui.zIO);
    localdb.nd(parambui.zIB);
    paramString = jm(paramLong);
    if (paramString == null)
    {
      paramString = null;
      if (paramString == null)
      {
        localdb.mX("0");
        localdb.na("");
        localdb.nb("");
      }
      paramString = parambui.extraInfo;
      if (paramString != null) {
        break label335;
      }
      paramString = "";
      label173:
      localdb.nf(paramString);
      parambui = parambui.zIE;
      if (parambui != null) {
        break label363;
      }
      parambui = "";
    }
    for (;;)
    {
      localdb.ng(parambui);
      localdb.bMH();
      a((a)localdb);
      AppMethodBeat.o(332098);
      return;
      localdb.mX(pL(paramLong));
      localdb.iwa = paramString.getFeedObject().likeCount;
      localdb.iwb = paramString.getFeedObject().commentCount;
      localdb.iwc = paramString.getFeedObject().friendLikeCount;
      localdb.iwe = paramString.getMediaType();
      Object localObject = com.tencent.mm.plugin.finder.utils.as.GiG;
      localdb.na(n.m(com.tencent.mm.plugin.finder.utils.as.F(paramString), ",", ";", false));
      localdb.nb("");
      localdb.ne(p(paramLong, parambui.hLK));
      paramString = ah.aiuX;
      break;
      label335:
      localObject = n.m(paramString, ",", ";", false);
      paramString = (String)localObject;
      if (localObject != null) {
        break label173;
      }
      paramString = "";
      break label173;
      label363:
      paramString = n.m(parambui, ",", ";", false);
      parambui = paramString;
      if (paramString == null) {
        parambui = "";
      }
    }
  }
  
  public static void a(bui parambui, FinderItem paramFinderItem, String paramString)
  {
    AppMethodBeat.i(332187);
    kotlin.g.b.s.u(parambui, "contextObj");
    kotlin.g.b.s.u(paramFinderItem, "finderItem");
    kotlin.g.b.s.u(paramString, "clickUsername");
    cz localcz = new cz();
    localcz.ivZ = localcz.F("FeedId", pL(paramFinderItem.getId()), true);
    localcz.ijk = localcz.F("SessionId", ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN(), true);
    localcz.iyj = localcz.F("PosterUsername", paramFinderItem.getFeedObject().username, true);
    localcz.iyk = localcz.F("ViewerUsername", com.tencent.mm.model.z.bAW(), true);
    localcz.iyl = localcz.F("MentionedUsername", paramString, true);
    localcz.iuA = parambui.AJo;
    localcz.iym = paramFinderItem.getFeedObject().orgRecommendType;
    localcz.iyn = paramFinderItem.getFeedObject().likeCount;
    localcz.iyo = paramFinderItem.getFeedObject().commentCount;
    localcz.bMH();
    a((a)localcz);
    AppMethodBeat.o(332187);
  }
  
  public static void a(bui parambui, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(332026);
    kotlin.g.b.s.u(parambui, "contextObj");
    kotlin.g.b.s.u(paramString1, "poiText");
    kotlin.g.b.s.u(paramString2, "filterTextItems");
    gw localgw = new gw();
    localgw.ixm = localgw.F("Sessionid", parambui.sessionId, true);
    localgw.iwI = localgw.F("Contextid", parambui.zIO, true);
    localgw.ijl = localgw.F("ClickTabContextid", parambui.zIB, true);
    localgw.iqr = parambui.hLK;
    localgw.iLE = localgw.F("PoiText", paramString1, true);
    localgw.iLF = localgw.F("FilterTextItems", paramString2, true);
    localgw.iLG = paramInt1;
    localgw.iLH = paramInt2;
    switch (parambui.AJo)
    {
    }
    for (;;)
    {
      localgw.ipV = parambui.AJo;
      localgw.bMH();
      a((a)localgw);
      AppMethodBeat.o(332026);
      return;
      localgw.iLI = 2L;
      continue;
      localgw.iLI = 1L;
    }
  }
  
  public static void a(j paramj, long paramLong, FinderItem paramFinderItem)
  {
    int k = 0;
    AppMethodBeat.i(331711);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramFinderItem, "feedObject");
    Object localObject = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
    int j;
    if (localObject == null) {
      j = 0;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      int i;
      if (paramj == null)
      {
        i = 0;
        label72:
        paramj = q(paramLong, i);
        if (paramj != null) {
          break label250;
        }
        paramj = null;
        label85:
        if (paramj == null) {
          break label290;
        }
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramFinderItem = (dji)kotlin.a.p.oL((List)paramFinderItem.getMediaList());
        if (paramFinderItem == null)
        {
          i = 0;
          label119:
          localJSONObject.put("video_duration", i);
          localJSONObject.put("current_play_sec", j);
          localObject = paramj.ZZe;
          paramFinderItem = (FinderItem)localObject;
          if (localObject == null) {
            paramFinderItem = "";
          }
          i = k;
          if (((CharSequence)paramFinderItem).length() == 0) {
            i = 1;
          }
          if (i == 0) {
            break label267;
          }
        }
        label267:
        for (paramFinderItem = new JSONObject();; paramFinderItem = new JSONObject(paramFinderItem))
        {
          paramFinderItem.put("video_play_info", localJSONObject);
          paramj.ZZe = paramFinderItem.toString();
          AppMethodBeat.o(331711);
          return;
          j = ((FinderVideoLayout)localObject).getCurrentPosSec();
          break;
          paramj = paramj.fou();
          if (paramj == null)
          {
            i = 0;
            break label72;
          }
          i = paramj.AJo;
          break label72;
          label250:
          paramj = paramj.FuM;
          break label85;
          i = paramFinderItem.videoDuration;
          break label119;
        }
        AppMethodBeat.o(331711);
      }
      catch (JSONException paramj)
      {
        Log.e(TAG, paramj.getMessage());
      }
    }
    label290:
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, long paramLong, bui parambui, int paramInt6, int paramInt7, String paramString4)
  {
    AppMethodBeat.i(332044);
    kotlin.g.b.s.u(paramString1, "currUI");
    kotlin.g.b.s.u(paramString3, "redDotWording");
    kotlin.g.b.s.u(paramString4, "report_ext_info");
    gc localgc = new gc();
    String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localgc.qJ(str1);
    localgc.qK(paramString1);
    localgc.iKn = paramInt1;
    localgc.ikE = paramInt2;
    localgc.iKp = paramInt3;
    long l;
    if (BuildInfo.DEBUG)
    {
      l = 0L;
      localgc.iwf = l;
      localgc.iKo = paramInt4;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localgc.qL(paramString1);
      localgc.iKq = paramInt5;
      localgc.qM(paramString3);
      localgc.qN(pL(paramLong));
      if (parambui != null) {
        break label331;
      }
      paramString1 = "";
      label183:
      localgc.qO(paramString1);
      if (parambui != null) {
        break label353;
      }
      paramString1 = "";
      label199:
      localgc.qP(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
        break label375;
      }
      paramLong = 2L;
      label231:
      localgc.iGr = paramLong;
      if (!((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZs()) {
        break label381;
      }
    }
    label331:
    label353:
    label375:
    label381:
    for (paramLong = 1L;; paramLong = 2L)
    {
      localgc.iJV = paramLong;
      localgc.iKa = paramInt6;
      localgc.iKu = paramInt7;
      if (!Util.isNullOrNil(paramString4)) {
        localgc.qQ(paramString4);
      }
      localgc.bMH();
      a((a)localgc);
      AppMethodBeat.o(332044);
      return;
      l = 2L;
      break;
      paramString2 = parambui.zIO;
      paramString1 = paramString2;
      if (paramString2 != null) {
        break label183;
      }
      paramString1 = "";
      break label183;
      paramString2 = parambui.zIB;
      paramString1 = paramString2;
      if (paramString2 != null) {
        break label199;
      }
      paramString1 = "";
      break label199;
      paramLong = 1L;
      break label231;
    }
  }
  
  public static void a(String paramString, int paramInt, bui parambui)
  {
    AppMethodBeat.i(332007);
    kotlin.g.b.s.u(paramString, "exposeFeedId");
    kotlin.g.b.s.u(parambui, "contextObj");
    com.tencent.mm.plugin.report.f.Ozc.b(20585, new Object[] { paramString, Long.valueOf(com.tencent.mm.model.cn.bDw()), Integer.valueOf(paramInt), Integer.valueOf(parambui.AJo), parambui.zIB, parambui.sessionId });
    AppMethodBeat.o(332007);
  }
  
  public static void a(String paramString1, int paramInt, bui parambui, String paramString2)
  {
    AppMethodBeat.i(332475);
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "resId");
    sd localsd = new sd();
    localsd.jrH = localsd.F("AppID", paramString1, true);
    localsd.ioV = paramInt;
    localsd.jxv = localsd.F("pageResrouceID", paramString2, true);
    if (parambui != null)
    {
      localsd.ipT = localsd.F("ContextId", parambui.zIO, true);
      localsd.ipV = parambui.AJo;
      localsd.jxu = localsd.F("click_tab_context_id", parambui.zIB, true);
      localsd.izT = localsd.F("sessionID", parambui.sessionId, true);
    }
    localsd.bMH();
    a((a)localsd);
    AppMethodBeat.o(332475);
  }
  
  public static void a(String paramString1, btw parambtw, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(332286);
    kotlin.g.b.s.u(paramString1, "showInfoPath");
    kotlin.g.b.s.u(parambtw, "ctrlInfo");
    ls localls = new ls();
    localls.jao = parambtw.type;
    localls.jap = localls.F("redDotTipsId", parambtw.ZYN, true);
    localls.ipW = localls.F("feedid", com.tencent.mm.ae.d.hF(paramLong), true);
    parambtw = paramString3;
    if (paramString3 == null) {
      parambtw = "";
    }
    localls.jaq = localls.F("reportText", parambtw, true);
    parambtw = paramString2;
    if (paramString2 == null) {
      parambtw = "";
    }
    localls.jar = localls.F("title", parambtw, true);
    localls.iFe = 1L;
    localls.jas = 1L;
    localls.jat = localls.F("showInfoPath", paramString1, true);
    localls.bMH();
    a((a)localls);
    AppMethodBeat.o(332286);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, bui parambui, String paramString3, String paramString4)
  {
    AppMethodBeat.i(331815);
    ea localea = new ea();
    if (parambui != null)
    {
      localea.inx = localea.F("sessionid", parambui.sessionId, true);
      localea.inz = localea.F("clickTabContextid", parambui.zIB, true);
      localea.iBK = parambui.AJo;
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      localea.iBO = localea.F("reasonId", paramString2, true);
      localea.iBL = localea.F("ItemId", paramString1, true);
      localea.iBM = paramInt1;
      localea.imW = 1;
      localea.iBN = 1;
      localea.iuv = paramInt2;
      localea.iBP = localea.F("hotWordId", paramString3, true);
      localea.iBQ = localea.F("requestId", paramString4, true);
      localea.bMH();
      a((a)localea);
      AppMethodBeat.o(331815);
      return;
      parambui = n.m(paramString2, ",", ";", false);
      paramString2 = parambui;
      if (parambui == null) {
        paramString2 = "";
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4, String paramString4, int paramInt5, int paramInt6, bui parambui, String paramString5)
  {
    AppMethodBeat.i(331803);
    gg localgg = new gg();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localgg.ioY = localgg.F("RequestId", str, true);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localgg.iuQ = localgg.F("Query", paramString1, true);
    localgg.iKH = paramInt1;
    localgg.iKI = paramInt2;
    localgg.iBL = localgg.F("ItemId", paramString3, true);
    localgg.iKL = paramInt3;
    localgg.iKM = paramInt4;
    localgg.iKN = 1;
    if (parambui != null)
    {
      localgg.ijk = localgg.F("SessionId", parambui.sessionId, true);
      localgg.iKP = parambui.AJo;
      localgg.iKO = localgg.F("ClicktabcontextId", parambui.zIB, true);
    }
    localgg.iKQ = localgg.F("SearchSessionid", paramString4, true);
    localgg.ipH = paramInt5;
    localgg.iKR = paramInt6;
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    localgg.iBP = localgg.F("hotWordId", paramString1, true);
    localgg.bMH();
    a((a)localgg);
    AppMethodBeat.o(331803);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4, String paramString4, int paramInt5, bui parambui)
  {
    AppMethodBeat.i(331796);
    gf localgf = new gf();
    localgf.ioY = localgf.F("RequestId", paramString1, true);
    localgf.iuQ = localgf.F("Query", paramString2, true);
    localgf.iKH = paramInt1;
    localgf.iKI = paramInt2;
    localgf.iBL = localgf.F("ItemId", paramString3, true);
    localgf.iBM = paramInt3;
    localgf.imW = paramInt4;
    localgf.iBN = 1;
    if (parambui != null)
    {
      localgf.inx = localgf.F("sessionid", parambui.sessionId, true);
      localgf.iBK = parambui.AJo;
      localgf.ixK = localgf.F("clicktabcontextid", parambui.zIB, true);
    }
    localgf.iKJ = localgf.F("searchSessionid", paramString4, true);
    localgf.iuv = 2;
    localgf.iKK = paramInt5;
    localgf.bMH();
    a((a)localgf);
    AppMethodBeat.o(331796);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, bui parambui)
  {
    AppMethodBeat.i(331755);
    ge localge = new ge();
    localge.ixI = 1L;
    localge.iKA = localge.F("searchSessionId", paramString1, true);
    localge.iBQ = localge.F("requestId", paramString2, true);
    localge.iKB = localge.F("query", paramString3, true);
    localge.iKC = paramInt1;
    localge.iKD = paramInt2;
    localge.iKE = paramInt3;
    localge.iKF = paramInt4;
    localge.iKG = paramInt5;
    if (parambui != null)
    {
      localge.ilK = localge.F("sessionId", parambui.sessionId, true);
      localge.ijn = parambui.AJo;
      localge.ipU = localge.F("ClickTabContextId", parambui.zIB, true);
    }
    localge.bMH();
    a((a)localge);
    AppMethodBeat.o(331755);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    AppMethodBeat.i(332117);
    com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Ozc;
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
    paramString3 = com.tencent.mm.ae.d.hF(paramLong1);
    if (paramInt2 == 4) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      localf.b(21834, new Object[] { str, paramString1, paramString2, Integer.valueOf(paramInt1), paramString3, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(332117);
      return;
    }
  }
  
  public static void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.ad.i parami, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, long paramLong1, long paramLong2, int paramInt5)
  {
    AppMethodBeat.i(331773);
    kotlin.g.b.s.u(paramString1, "contextId");
    kotlin.g.b.s.u(parami, "data");
    kotlin.g.b.s.u(paramString2, "adPosId");
    try
    {
      com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
      int i;
      Object localObject;
      if (paramBoolean2)
      {
        i = 2;
        locali.au("report_type", i);
        locali.m("advert_group_id", parami.optString("group_id"));
        locali.m("trace_id", parami.optString("traceid"));
        localObject = parami.optString("apurl");
        String str = parami.optString("rl");
        if (!paramBoolean2) {
          break label467;
        }
        localObject = str;
        label113:
        locali.m("report_link", localObject);
        locali.au("pos_type", parami.optInt("pos_type"));
        locali.au("click_pos", 0);
        locali.au("ad_w", paramInt1);
        locali.au("ad_h", paramInt2);
        locali.m("pt", parami.opt("pt"));
        locali.A("viewable", paramBoolean1);
        locali.au("screen_cnt", 1);
        locali.au("from_h5", 0);
        locali.au("from_game", 0);
        if (!paramBoolean1) {
          break label470;
        }
      }
      label467:
      label470:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        locali.au("exposure_type", paramInt1);
        parami = new com.tencent.mm.ad.i();
        parami.au("screen_x", paramInt3);
        parami.au("screen_y", paramInt4);
        parami.au("ad_unit_number", 1);
        parami.au("ad_number", 1);
        parami.au("ad_index", 0);
        parami.t("page_enter_time", paramLong2);
        localObject = at.GiI;
        parami.au("phone_screen_width", at.getScreenWidth());
        localObject = at.GiI;
        parami.au("phone_screen_height", at.getScreenHeight());
        localObject = ah.aiuX;
        locali.m("wxa_report_detail", parami);
        locali.m("pos_id", paramString2);
        locali.t("aid", paramLong1);
        parami = new com.tencent.mm.ad.i();
        parami.m("context_id", paramString1);
        parami.au("pos", paramInt5);
        locali.m("channels_extra_data", parami.toString());
        paramString1 = locali.toString();
        kotlin.g.b.s.s(paramString1, "json.toString()");
        paramString1 = new com.tencent.mm.plugin.finder.cgi.dc(paramString1);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString1, 0);
        AppMethodBeat.o(331773);
        return;
        i = 1;
        break;
        break label113;
      }
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString1, "reportExpose", new Object[0]);
      AppMethodBeat.o(331773);
    }
  }
  
  public static void aF(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(331951);
    ez localez = new ez();
    localez.iGn = paramInt1;
    localez.iFe = paramInt2;
    localez.iGo = paramInt3;
    localez.bMH();
    a((a)localez);
    AppMethodBeat.o(331951);
  }
  
  public static void aa(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166577);
    FinderItem localFinderItem = jm(paramLong);
    if (localFinderItem != null)
    {
      ci localci = new ci();
      String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localci.ijk = localci.F("SessionId", str1, true);
      localci.ivZ = localci.F("FeedId", com.tencent.mm.ae.d.hF(localFinderItem.getId()), true);
      localci.ipV = paramInt;
      localci.iwa = localFinderItem.getLikeCount();
      localci.iwb = localFinderItem.getCommentCount();
      localci.iwc = localFinderItem.getFriendLikeCount();
      localci.iwe = localFinderItem.getMediaType();
      localci.iwd = localci.F("CurrentPageName", "", true);
      localci.iuA = paramInt;
      localci.bMH();
      a((a)localci);
    }
    AppMethodBeat.o(166577);
  }
  
  public static void ab(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166580);
    FinderItem localFinderItem = jm(paramLong);
    if (localFinderItem != null)
    {
      fs localfs = new fs();
      String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localfs.ijk = localfs.F("SessionId", (String)localObject, true);
      localfs.iuA = paramInt;
      localObject = com.tencent.mm.plugin.finder.utils.as.GiG;
      localfs.iyA = localfs.F("Tag", n.m(com.tencent.mm.plugin.finder.utils.as.F(localFinderItem), ",", ";", false), true);
      localfs.iyB = localfs.F("TagId", "", true);
      localfs.ipW = localfs.F("feedid", pL(localFinderItem.getId()), true);
      localfs.iwa = localFinderItem.getFeedObject().likeCount;
      localfs.bMH();
      a((a)localfs);
    }
    AppMethodBeat.o(166580);
  }
  
  public static void ak(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(332390);
    kotlin.g.b.s.u(paramString, "fromUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2;
    com.tencent.mm.plugin.report.f.Ozc.kvStat(20699, paramString);
    AppMethodBeat.o(332390);
  }
  
  public static void ar(int paramInt, long paramLong)
  {
    AppMethodBeat.i(332201);
    gs localgs = new gs();
    String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localgs.ijk = localgs.F("SessionId", str1, true);
    localgs.iKq = paramInt;
    localgs.ikE = paramLong;
    localgs.bMH();
    a((a)localgs);
    AppMethodBeat.o(332201);
  }
  
  public static void av(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(332275);
    kotlin.g.b.s.u(paramContext, "context");
    ey localey = new ey();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramContext = as.a.hu(paramContext);
    if (paramContext != null) {
      localey.pw(paramContext.sessionId);
    }
    for (;;)
    {
      localey.ikE = paramInt;
      localey.bMH();
      a((a)localey);
      AppMethodBeat.o(332275);
      return;
      localObject = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      localey.pw(paramContext);
    }
  }
  
  public static void azT(String paramString)
  {
    Fsa = paramString;
  }
  
  public static void azU(String paramString)
  {
    AppMethodBeat.i(166588);
    kotlin.g.b.s.u(paramString, "username");
    String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramString = str + ',' + paramString;
    Log.i(TAG, kotlin.g.b.s.X("18973 ", paramString));
    com.tencent.mm.plugin.report.f.Ozc.kvStat(18973, paramString);
    AppMethodBeat.o(166588);
  }
  
  public static void b(int paramInt, String paramString1, String paramString2, bui parambui)
  {
    AppMethodBeat.i(331822);
    kotlin.g.b.s.u(paramString1, "eid");
    kotlin.g.b.s.u(paramString2, "udfKv");
    gk localgk = new gk();
    localgk.iGK = paramInt;
    localgk.qX(String.valueOf(com.tencent.mm.model.cn.bDw()));
    localgk.qY(paramString1);
    localgk.qZ(paramString2);
    if (parambui != null)
    {
      paramString2 = parambui.sessionId;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localgk.qU(paramString1);
      paramString2 = parambui.zIO;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localgk.qV(paramString1);
      localgk.qW(String.valueOf(parambui.AJo));
      paramString2 = parambui.zIB;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localgk.ra(paramString1);
    }
    localgk.bMH();
    a((a)localgk);
    AppMethodBeat.o(331822);
  }
  
  public static void bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(332471);
    kotlin.g.b.s.u(paramString, "msgId");
    gr localgr = new gr();
    localgr.iLz = 5L;
    localgr.iFe = paramInt;
    localgr.iLA = localgr.F("msgId", paramString, true);
    localgr.bMH();
    a((a)localgr);
    AppMethodBeat.o(332471);
  }
  
  public static int bUg()
  {
    AppMethodBeat.i(332358);
    int i = 0;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(332358);
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
  
  public static String bUm()
  {
    AppMethodBeat.i(332192);
    String str = UUID.randomUUID().toString();
    kotlin.g.b.s.s(str, "randomUUID().toString()");
    AppMethodBeat.o(332192);
    return str;
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(332384);
    kotlin.g.b.s.u(paramString, "profileUsername");
    paramString = paramString + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4;
    com.tencent.mm.plugin.report.f.Ozc.kvStat(20698, paramString);
    AppMethodBeat.o(332384);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(332210);
    fa localfa = new fa();
    String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localfa.px(str1);
    localfa.ixB = paramInt1;
    localfa.iGr = 0L;
    localfa.iGp = paramInt2;
    localfa.iGq = paramInt3;
    localfa.py(z..ExternalSyntheticBackport1.m(ab.J(paramLong)));
    localfa.bMH();
    a((a)localfa);
    AppMethodBeat.o(332210);
  }
  
  public static void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(166582);
    kotlin.g.b.s.u(paramString1, "fromUser");
    kotlin.g.b.s.u(paramString2, "topic");
    Object localObject = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramString1 = new StringBuilder().append(localObject).append(',').append(paramInt1).append(",3,").append(paramString1).append(",0,,");
    localObject = com.tencent.mm.plugin.finder.utils.as.GiG;
    paramString1 = com.tencent.mm.plugin.finder.utils.as.eW(paramString2, paramInt2);
    com.tencent.mm.plugin.report.f.Ozc.kvStat(18944, paramString1);
    AppMethodBeat.o(166582);
  }
  
  public static void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(332313);
    kotlin.g.b.s.u(paramString1, "tipsId");
    kotlin.g.b.s.u(paramString2, "revokeId");
    fy localfy = new fy();
    localfy.iJH = paramInt1;
    localfy.iJI = com.tencent.mm.model.cn.getSyncServerTimeSecond();
    localfy.ikf = localfy.F("TipsId", paramString1, true);
    localfy.iJJ = localfy.F("RevokeId", paramString2, true);
    paramString1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() == 1) {}
    for (long l = 2L;; l = 1L)
    {
      localfy.iGr = l;
      localfy.iJK = paramInt2;
      localfy.bMH();
      a((a)localfy);
      AppMethodBeat.o(332313);
      return;
    }
  }
  
  public static String eMW()
  {
    return Fsa;
  }
  
  public static HashMap<String, bd> eMX()
  {
    return Fsc;
  }
  
  public static boolean eMY()
  {
    return Fsg;
  }
  
  public static void f(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(332516);
    kotlin.g.b.s.u(paramContext, "context");
    if (!Fsg)
    {
      AppMethodBeat.o(332516);
      return;
    }
    int i;
    Object localObject;
    if (paramBoolean1)
    {
      i = 1;
      localObject = new com.tencent.mm.ad.i();
      if (!paramBoolean2) {
        break label126;
      }
      label48:
      ((com.tencent.mm.ad.i)localObject).au("hasfeed", j);
      localObject = ((com.tencent.mm.ad.i)localObject).toString();
      kotlin.g.b.s.s(localObject, "kvJson.toString()");
      localObject = n.m((String)localObject, ",", ";", false);
      as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext != null) {
        break label132;
      }
    }
    label132:
    for (paramContext = null;; paramContext = paramContext.fou())
    {
      b(i, "post_moment", (String)localObject, paramContext);
      AppMethodBeat.o(332516);
      return;
      i = 0;
      break;
      label126:
      j = 0;
      break label48;
    }
  }
  
  public static String gO(Context paramContext)
  {
    AppMethodBeat.i(332346);
    kotlin.g.b.s.u(paramContext, "context");
    int i = 0;
    if ((paramContext instanceof MMFragmentActivity))
    {
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      i = ((FinderHomeUIC)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramContext).q(FinderHomeUIC.class)).fnX();
    }
    switch (i)
    {
    default: 
      paramContext = "2";
    }
    for (;;)
    {
      AppMethodBeat.o(332346);
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
  
  public static void gP(Context paramContext)
  {
    AppMethodBeat.i(332500);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    paramContext = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.nq(paramContext).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    localObject = new gk();
    ((gk)localObject).qU(paramContext.sessionId);
    ((gk)localObject).qV(paramContext.zIO);
    ((gk)localObject).qW(String.valueOf(paramContext.AJo));
    ((gk)localObject).ra(paramContext.zIB);
    ((gk)localObject).iGK = 0;
    ((gk)localObject).qY("teenagemode_set");
    ((gk)localObject).qX(String.valueOf(com.tencent.mm.model.cn.bDw()));
    ((gk)localObject).bMH();
    a((a)localObject);
    AppMethodBeat.o(332500);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void h(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(332440);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramContext = as.a.hu(paramContext);
    ft localft;
    label48:
    label71:
    long l;
    if (paramContext == null)
    {
      paramContext = null;
      localft = new ft();
      if (paramContext != null) {
        break label184;
      }
      localObject1 = null;
      localft.ijk = localft.F("SessionId", (String)localObject1, true);
      if (paramContext != null) {
        break label193;
      }
      localObject1 = null;
      localft.ijl = localft.F("ClickTabContextid", (String)localObject1, true);
      if (paramContext != null) {
        break label202;
      }
      l = 0L;
      label93:
      localft.ipV = l;
      localft.ijp = localft.F("EventTime", String.valueOf(System.currentTimeMillis()), true);
      if (paramContext != null) {
        break label211;
      }
    }
    label184:
    label193:
    label202:
    label211:
    for (paramContext = localObject2;; paramContext = paramContext.zIO)
    {
      localft.ijm = localft.F("FinderContexId", paramContext, true);
      localft.ijo = paramInt1;
      localft.ijq = paramInt2;
      localft.bMH();
      a((a)localft);
      AppMethodBeat.o(332440);
      return;
      paramContext = paramContext.fou();
      break;
      localObject1 = paramContext.sessionId;
      break label48;
      localObject1 = paramContext.zIB;
      break label71;
      l = paramContext.AJo;
      break label93;
    }
  }
  
  public static void ic(String paramString1, String paramString2)
  {
    long l2 = 1L;
    AppMethodBeat.i(332130);
    kotlin.g.b.s.u(paramString1, "contextId");
    com.tencent.mm.autogen.mmdata.rpt.bd localbd = new com.tencent.mm.autogen.mmdata.rpt.bd();
    localbd.ipT = localbd.F("ContextId", paramString1, true);
    Object localObject = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = "";
    }
    localbd.ijk = localbd.F("SessionId", paramString1, true);
    paramString1 = com.tencent.mm.ui.component.k.aeZF;
    paramString1 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    kotlin.g.b.s.s(paramString1, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    localObject = (com.tencent.mm.plugin.finder.viewmodel.d)paramString1;
    localbd.iqK = ((com.tencent.mm.plugin.finder.viewmodel.d)localObject).fmM();
    paramString1 = com.tencent.mm.ui.component.k.aeZF;
    paramString1 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class);
    kotlin.g.b.s.s(paramString1, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    paramString1 = (com.tencent.mm.plugin.finder.viewmodel.b)paramString1;
    long l1;
    if (paramString1.dUi())
    {
      l1 = 1L;
      localbd.iqF = l1;
      if (paramString1.GJZ != null) {
        break label340;
      }
      paramString1 = null;
      label177:
      if (paramString1 == null) {
        localbd.iqE = 0L;
      }
      if (paramString2 != null) {
        break label353;
      }
    }
    for (paramString1 = null;; paramString1 = ah.aiuX)
    {
      if (paramString1 == null)
      {
        localbd.iqD = 0L;
        localbd.kW("");
        l1 = l2;
        if (((com.tencent.mm.plugin.finder.viewmodel.d)localObject).Rp(((com.tencent.mm.plugin.finder.viewmodel.d)localObject).fmM())) {
          l1 = 2L;
        }
        localbd.iqM = l1;
        localbd.iqG = kotlin.k.k.bR(((com.tencent.mm.plugin.finder.viewmodel.d)localObject).UV(3).GKx, 0L);
        localbd.iqI = kotlin.k.k.bR(((com.tencent.mm.plugin.finder.viewmodel.d)localObject).UV(2).GKx, 0L);
        localbd.iqH = kotlin.k.k.bR(((com.tencent.mm.plugin.finder.viewmodel.d)localObject).UV(1).GKx, 0L);
        localbd.iqJ = kotlin.k.k.bR(((com.tencent.mm.plugin.finder.viewmodel.d)localObject).UV(4).GKx, 0L);
      }
      localbd.bMH();
      a((a)localbd);
      AppMethodBeat.o(332130);
      return;
      l1 = 0L;
      break;
      label340:
      localbd.iqE = 1L;
      paramString1 = ah.aiuX;
      break label177;
      label353:
      localbd.iqD = 1L;
      localbd.kW(paramString2);
      localbd.iqJ = 0L;
      localbd.iqI = 0L;
      localbd.iqG = 0L;
      localbd.iqH = 0L;
      localbd.iqM = 1L;
    }
  }
  
  public static void id(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178396);
    kotlin.g.b.s.u(paramString1, "contextId");
    kotlin.g.b.s.u(paramString2, "action");
    gx localgx = new gx();
    localgx.ipT = localgx.F("ContextId", paramString1, true);
    localgx.iwM = localgx.F("Action", paramString2, true);
    localgx.izy = com.tencent.mm.model.cn.bDw();
    paramString2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localgx.ijk = localgx.F("SessionId", paramString1, true);
    if (BuildInfo.DEBUG) {}
    for (long l = 0L;; l = 1L)
    {
      localgx.iwf = l;
      localgx.bMH();
      a((a)localgx);
      AppMethodBeat.o(178396);
      return;
    }
  }
  
  public static void ig(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(332220);
    gh localgh = new gh();
    localgh.ixB = paramInt1;
    localgh.ikE = paramInt2;
    localgh.bMH();
    a((a)localgh);
    AppMethodBeat.o(332220);
  }
  
  public static void j(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(332493);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    paramContext = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.nq(paramContext).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    localObject = new gk();
    ((gk)localObject).qU(paramContext.sessionId);
    ((gk)localObject).qV(paramContext.zIO);
    ((gk)localObject).qW(String.valueOf(paramContext.AJo));
    ((gk)localObject).iGK = 0;
    ((gk)localObject).qY("textstatus_in_menu");
    ((gk)localObject).qX(String.valueOf(com.tencent.mm.model.cn.bDw()));
    ((gk)localObject).qZ(new com.tencent.mm.ad.i().m("feedid", com.tencent.mm.ae.d.hF(paramLong)).toString());
    ((gk)localObject).bMH();
    AppMethodBeat.o(332493);
  }
  
  public static void j(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166586);
    kotlin.g.b.s.u(paramFinderItem, "finderItem");
    FinderObject localFinderObject = paramFinderItem.getFinderObject();
    String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramFinderItem = str + ',' + pL(localFinderObject.id) + ',' + localFinderObject.username + ',' + paramFinderItem.getMediaType() + ',' + localFinderObject.recommendType + ',' + localFinderObject.likeCount + ',' + localFinderObject.commentCount + ',' + localFinderObject.friendLikeCount;
    Log.i(TAG, kotlin.g.b.s.X("18950 ", paramFinderItem));
    com.tencent.mm.plugin.report.f.Ozc.kvStat(18950, paramFinderItem);
    AppMethodBeat.o(166586);
  }
  
  public static FinderItem jm(long paramLong)
  {
    AppMethodBeat.i(166576);
    Object localObject = e.FMN;
    localObject = e.a.jn(paramLong);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.finder.search.k.FxZ;
      localObject = (FinderItem)com.tencent.mm.plugin.finder.search.k.ePf().get(Long.valueOf(paramLong));
      if (localObject == null)
      {
        localObject = FinderTopicFeedUI.Bst;
        localObject = (FinderItem)FinderTopicFeedUI.eeA().get(Long.valueOf(paramLong));
        if (localObject == null)
        {
          localObject = FinderAtTimelineUI.BlG;
          localObject = (FinderItem)FinderAtTimelineUI.eeA().get(Long.valueOf(paramLong));
          AppMethodBeat.o(166576);
          return localObject;
        }
        AppMethodBeat.o(166576);
        return localObject;
      }
      AppMethodBeat.o(166576);
      return localObject;
    }
    AppMethodBeat.o(166576);
    return localObject;
  }
  
  public static void k(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(332179);
    kotlin.g.b.s.u(paramFinderItem, "finderItem");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null)
    {
      fk localfk = new fk();
      localfk.ivZ = localfk.F("FeedId", pL(paramFinderItem.getId()), true);
      localfk.ijk = localfk.F("SessionId", ((FinderFeedReportObject)localObject).sessionId, true);
      localfk.iHI = localfk.F("PostUsername", paramFinderItem.getFeedObject().username, true);
      localObject = com.tencent.mm.plugin.finder.utils.h.Gga;
      localfk.iHJ = localfk.F("mentionedDetailInfo", n.m(com.tencent.mm.plugin.finder.utils.h.B(paramFinderItem), ",", ";", false), true);
      localfk.bMH();
      a((a)localfk);
    }
    AppMethodBeat.o(332179);
  }
  
  public static void l(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166584);
    kotlin.g.b.s.u(paramString1, "author");
    kotlin.g.b.s.u(paramString2, "receiver");
    String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramString1 = str + ',' + paramString1 + ',' + paramString2 + ',' + 0 + ',' + paramInt1 + ',' + paramInt2;
    Log.i(TAG, kotlin.g.b.s.X("18949 ", paramString1));
    com.tencent.mm.plugin.report.f.Ozc.kvStat(18949, paramString1);
    AppMethodBeat.o(166584);
  }
  
  public static String p(long paramLong, int paramInt)
  {
    AppMethodBeat.i(331676);
    Object localObject = (bd)Fsc.get(paramLong + '_' + paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(331676);
      return "";
    }
    localObject = ((bd)localObject).FuM;
    if (localObject == null)
    {
      AppMethodBeat.o(331676);
      return "";
    }
    localObject = ((bra)localObject).ZJK;
    if (localObject == null)
    {
      AppMethodBeat.o(331676);
      return "";
    }
    AppMethodBeat.o(331676);
    return localObject;
  }
  
  public static void p(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(331695);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    if (paramFinderObject.client_local_buffer == null)
    {
      paramFinderObject.client_local_buffer = new brb();
      paramFinderObject = paramFinderObject.client_local_buffer;
      if (paramFinderObject != null) {
        paramFinderObject.ZZf = com.tencent.mm.model.cn.bDv();
      }
    }
    AppMethodBeat.o(331695);
  }
  
  public static ca pH(long paramLong)
  {
    AppMethodBeat.i(331650);
    Object localObject = e.FMN;
    localObject = e.a.qh(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(331650);
      return null;
    }
    localObject = new ca((FinderObject)localObject);
    AppMethodBeat.o(331650);
    return localObject;
  }
  
  public static long pI(long paramLong)
  {
    AppMethodBeat.i(331682);
    Long localLong = (Long)Fsb.get(paramLong);
    if (localLong == null)
    {
      AppMethodBeat.o(331682);
      return 0L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(331682);
    return paramLong;
  }
  
  public static long pJ(long paramLong)
  {
    AppMethodBeat.i(331687);
    Long localLong = (Long)Fse.get(paramLong);
    if (localLong == null)
    {
      AppMethodBeat.o(331687);
      return 0L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(331687);
    return paramLong;
  }
  
  public static void pK(long paramLong)
  {
    AppMethodBeat.i(331976);
    Object localObject = jm(paramLong);
    if (localObject != null)
    {
      FinderObject localFinderObject = ((FinderItem)localObject).getFeedObject();
      String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      localObject = str + ',' + pL(localFinderObject.id) + ',' + localFinderObject.username + ',' + localFinderObject.recommendType + ',' + ((FinderItem)localObject).getMediaType();
      Log.i(TAG, kotlin.g.b.s.X("18974 ", localObject));
      com.tencent.mm.plugin.report.f.Ozc.kvStat(18974, (String)localObject);
    }
    AppMethodBeat.o(331976);
  }
  
  public static String pL(long paramLong)
  {
    AppMethodBeat.i(166591);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(TWO_64);
    }
    localObject = ((BigInteger)localObject).toString();
    kotlin.g.b.s.s(localObject, "b.toString()");
    AppMethodBeat.o(166591);
    return localObject;
  }
  
  public static bd q(long paramLong, int paramInt)
  {
    AppMethodBeat.i(331670);
    bd localbd = (bd)Fsc.get(paramLong + '_' + paramInt);
    AppMethodBeat.o(331670);
    return localbd;
  }
  
  private static String q(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(332480);
    StringBuilder localStringBuilder = new StringBuilder("");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((String)paramList.next()).append(paramString);
    }
    paramList = localStringBuilder.toString();
    kotlin.g.b.s.s(paramList, "builder.toString()");
    paramList = n.d(paramList, (CharSequence)paramString);
    AppMethodBeat.o(332480);
    return paramList;
  }
  
  public static void tN(boolean paramBoolean)
  {
    Fsg = paramBoolean;
  }
  
  public static void tO(boolean paramBoolean)
  {
    Fsh = paramBoolean;
  }
  
  public final void A(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(332589);
    kotlin.g.b.s.u(paramList1, "newIds");
    kotlin.g.b.s.u(paramList2, "oldIds");
    ja localja = new ja();
    localja.iRn = paramList1.size();
    localja.iRo = paramList2.size();
    localja.iRp = localja.F("NewTipsIDs", q(paramList1, "|"), true);
    localja.iRq = localja.F("DeleteTipsIDs", q(paramList2, "|"), true);
    localja.bMH();
    a((a)localja);
    AppMethodBeat.o(332589);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(332565);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appuin");
    kotlin.g.b.s.u(paramString2, "preWarmPath");
    kotlin.g.b.s.u(paramString3, "liveid");
    kotlin.g.b.s.u(paramString4, "finderid");
    kotlin.g.b.s.u(paramString5, "shopwindowid");
    kotlin.g.b.s.u(paramString6, "sessionid");
    eu localeu = new eu();
    localeu.iFp = localeu.F("appuin", paramString1, true);
    localeu.iFA = 0L;
    localeu.iFr = 10;
    localeu.iFB = localeu.F("prewarmpath", paramString2, true);
    if (paramBoolean1)
    {
      i = 1;
      localeu.iFw = i;
      if (!paramBoolean2) {
        break label253;
      }
    }
    label253:
    for (int i = 1;; i = 0)
    {
      localeu.iFx = i;
      localeu.ixk = localeu.F("liveid", paramString3, true);
      localeu.iFt = localeu.F("finderid", paramString4, true);
      localeu.iFu = localeu.F("shopwindowid", paramString5, true);
      localeu.inx = localeu.F("sessionid", paramString6, true);
      localeu.iFs = localeu.F("networktype", String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)), true);
      localeu.iFC = com.tencent.mm.model.cn.bDw();
      localeu.bMH();
      AppMethodBeat.o(332565);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(332579);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "clickId");
    kotlin.g.b.s.u(paramString2, "appId");
    kotlin.g.b.s.u(paramString3, "preWarmPath");
    kotlin.g.b.s.u(paramString4, "liveid");
    kotlin.g.b.s.u(paramString5, "finderid");
    kotlin.g.b.s.u(paramString6, "shopwindowid");
    kotlin.g.b.s.u(paramString7, "sessionid");
    eo localeo = new eo();
    localeo.iuF = paramInt2;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      localeo.iEu = paramInt2;
      localeo.iEv = paramInt1;
      localeo.iEG = localeo.F("clickId", paramString1, true);
      localeo.ilF = localeo.F("appId", paramString2, true);
      localeo.iEw = 0L;
      localeo.iEz = localeo.F("preWarmPath", paramString3, true);
      if (!paramBoolean2) {
        break label304;
      }
      paramInt1 = 1;
      label166:
      localeo.iEA = paramInt1;
      if (!paramBoolean3) {
        break label309;
      }
    }
    label304:
    label309:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localeo.iEB = paramInt1;
      localeo.iEC = localeo.F("liveId", paramString4, true);
      localeo.iED = localeo.F("finderId", paramString5, true);
      localeo.iEE = localeo.F("shopwindowId", paramString6, true);
      localeo.ilK = localeo.F("sessionId", paramString7, true);
      localeo.iEx = 10;
      localeo.iEy = localeo.F("networkType", String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)), true);
      localeo.iEF = com.tencent.mm.model.cn.bDw();
      localeo.bMH();
      AppMethodBeat.o(332579);
      return;
      paramInt2 = 0;
      break;
      paramInt1 = 0;
      break label166;
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6)
  {
    AppMethodBeat.i(332573);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "liveid");
    kotlin.g.b.s.u(paramString2, "finderid");
    kotlin.g.b.s.u(paramString3, "shopwindowid");
    kotlin.g.b.s.u(paramString4, "sessionid");
    kotlin.g.b.s.u(paramString5, "appuin");
    kotlin.g.b.s.u(paramString6, "appVersion");
    et localet = new et();
    localet.iFp = localet.F("appuin", paramString5, true);
    localet.iFr = 10;
    localet.iFq = localet.F("appversion", paramString6, true);
    if (paramBoolean1)
    {
      i = 1;
      localet.iFw = i;
      if (!paramBoolean2) {
        break label261;
      }
    }
    label261:
    for (int i = 1;; i = 0)
    {
      localet.iFx = i;
      localet.ixk = localet.F("liveid", paramString1, true);
      localet.iFt = localet.F("finderid", paramString2, true);
      localet.iFu = localet.F("shopwindowid", paramString3, true);
      localet.inx = localet.F("sessionid", paramString4, true);
      localet.iFv = 0L;
      localet.iFs = localet.F("networktype", String.valueOf(NetworkUtil.getCurrentNetWorkStatus(paramContext)), true);
      localet.iFy = paramLong1;
      localet.iFz = paramLong2;
      localet.bMH();
      AppMethodBeat.o(332573);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt3, String paramString5, int paramInt4)
  {
    AppMethodBeat.i(332559);
    kotlin.g.b.s.u(paramString1, "currUI");
    kotlin.g.b.s.u(paramString2, "redDotId");
    kotlin.g.b.s.u(paramString3, "redDotWording");
    kotlin.g.b.s.u(paramString4, "contextId");
    kotlin.g.b.s.u(paramString5, "report_ext_info");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(332559);
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
      localObject = new bui();
      ((bui)localObject).zIO = paramString4;
      ((bui)localObject).zIB = "";
      a(paramString1, paramInt1, paramInt2, paramInt3, i, 0, paramString2, paramString3, paramLong, (bui)localObject, paramInt4, paramString5);
      AppMethodBeat.o(332559);
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
        AppMethodBeat.o(332559);
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
  
  public final void b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(332583);
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "clickId");
    kotlin.g.b.s.u(paramString3, "sessionid");
    kotlin.g.b.s.u(paramString4, "setting");
    kotlin.g.b.s.u(paramString5, "requestId");
    lj locallj = new lj();
    locallj.inE = System.currentTimeMillis();
    locallj.ila = paramLong;
    locallj.uh(paramString1);
    locallj.uk(paramString2);
    locallj.iuA = 1176L;
    locallj.uj(com.tencent.mm.model.z.bAW());
    locallj.ui(paramString3);
    locallj.ug(paramString4);
    locallj.ul(paramString5);
    locallj.bMH();
    a((a)locallj);
    AppMethodBeat.o(332583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.z
 * JD-Core Version:    0.7.0.1
 */