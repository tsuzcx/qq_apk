package com.tencent.mm.plugin.finder.live.report;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig;", "", "()V", "TAG", "", "addProductAction", "", "getAddProductAction", "()Z", "setAddProductAction", "(Z)V", "anchorUsername", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "bookLiveSrc", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BookLiveSrc;", "getBookLiveSrc", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BookLiveSrc;", "setBookLiveSrc", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BookLiveSrc;)V", "cacheExitEvent_21024", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;", "getCacheExitEvent_21024", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;", "setCacheExitEvent_21024", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;)V", "closeLinkMicAudioByVisitor", "getCloseLinkMicAudioByVisitor", "setCloseLinkMicAudioByVisitor", "closeLinkMicVideoByVisitor", "getCloseLinkMicVideoByVisitor", "setCloseLinkMicVideoByVisitor", "commentSceneOnFinderHome", "", "getCommentSceneOnFinderHome", "()I", "setCommentSceneOnFinderHome", "(I)V", "coverType", "getCoverType", "setCoverType", "curLikeNumber", "", "getCurLikeNumber", "()J", "setCurLikeNumber", "(J)V", "curLiveDuration", "getCurLiveDuration", "setCurLiveDuration", "curLiveNumber", "getCurLiveNumber", "setCurLiveNumber", "curProductIds", "Ljava/util/LinkedList;", "getCurProductIds", "()Ljava/util/LinkedList;", "setCurProductIds", "(Ljava/util/LinkedList;)V", "curRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getCurRecyclerViewRef", "()Ljava/lang/ref/WeakReference;", "setCurRecyclerViewRef", "(Ljava/lang/ref/WeakReference;)V", "desc", "getDesc", "setDesc", "description", "getDescription", "enterSessionId", "getEnterSessionId", "setEnterSessionId", "errCode", "getErrCode", "setErrCode", "filterType", "getFilterType", "setFilterType", "filterValue", "getFilterValue", "setFilterValue", "fromWeconHotUI", "getFromWeconHotUI", "setFromWeconHotUI", "gAnchorLinkMicSucdess", "getGAnchorLinkMicSucdess", "setGAnchorLinkMicSucdess", "gAnchorLinkMicTimeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/vending/tuple/Tuple3;", "Lkotlin/collections/ArrayList;", "getGAnchorLinkMicTimeList", "()Ljava/util/ArrayList;", "gCurCommentscene_temp", "getGCurCommentscene_temp", "setGCurCommentscene_temp", "gCurLiveFeedPos", "getGCurLiveFeedPos", "setGCurLiveFeedPos", "gCurShopAppId", "gCurShopSessionId", "gLinkMicCount", "getGLinkMicCount", "setGLinkMicCount", "gLinkMicTimeList", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkType;", "getGLinkMicTimeList", "gLiveFeedFragmentPageMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGLiveFeedFragmentPageMap", "()Ljava/util/HashMap;", "gLiveFeedPageMap", "getGLiveFeedPageMap", "gSceneNote", "getGSceneNote", "setGSceneNote", "getContactFromMemberList", "getGetContactFromMemberList", "setGetContactFromMemberList", "isEnterFromFloat", "setEnterFromFloat", "isExitToFloat", "setExitToFloat", "isGift", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$IsGift;", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$IsGift;", "setGift", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$IsGift;)V", "launcherSrc", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartLiveSource;", "getLauncherSrc", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartLiveSource;", "setLauncherSrc", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartLiveSource;)V", "linkMicStateOnPre", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkSwitch;", "getLinkMicStateOnPre", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkSwitch;", "setLinkMicStateOnPre", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkSwitch;)V", "liveId", "getLiveId", "setLiveId", "livePageTypeWhenEnter", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyPageType;", "getLivePageTypeWhenEnter", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyPageType;", "setLivePageTypeWhenEnter", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyPageType;)V", "liveStaticsData_21056", "Lcom/tencent/mm/plugin/finder/live/report/LiveStaticsData_21056;", "getLiveStaticsData_21056", "()Lcom/tencent/mm/plugin/finder/live/report/LiveStaticsData_21056;", "setLiveStaticsData_21056", "(Lcom/tencent/mm/plugin/finder/live/report/LiveStaticsData_21056;)V", "mAnchorLotteryCount", "getMAnchorLotteryCount", "setMAnchorLotteryCount", "mClickLotteryHistroy", "getMClickLotteryHistroy", "setMClickLotteryHistroy", "mClickLotteryIcon", "getMClickLotteryIcon", "setMClickLotteryIcon", "morpyEyes", "getMorpyEyes", "setMorpyEyes", "morpyFace", "getMorpyFace", "setMorpyFace", "nearbyCommenScene", "getNearbyCommenScene", "setNearbyCommenScene", "objectId", "getObjectId", "setObjectId", "poiJSONObject", "Lorg/json/JSONObject;", "getPoiJSONObject", "()Lorg/json/JSONObject;", "setPoiJSONObject", "(Lorg/json/JSONObject;)V", "positionLiveFeedOnfull", "getPositionLiveFeedOnfull", "setPositionLiveFeedOnfull", "promoting", "getPromoting", "setPromoting", "rosy", "getRosy", "setRosy", "ruleType", "getRuleType", "setRuleType", "screenShareHistory", "Lcom/tencent/mm/json/JSONArray;", "getScreenShareHistory", "()Lcom/tencent/mm/json/JSONArray;", "setScreenShareHistory", "(Lcom/tencent/mm/json/JSONArray;)V", "sessionBufOnTemp2", "getSessionBufOnTemp2", "setSessionBufOnTemp2", "shareId", "getShareId", "setShareId", "shopAppId", "getShopAppId", "skinWhitening", "getSkinWhitening", "setSkinWhitening", "smoothFace", "getSmoothFace", "setSmoothFace", "startLiveSource", "getStartLiveSource", "setStartLiveSource", "startLiveVideo", "getStartLiveVideo", "setStartLiveVideo", "startScreenShareTime", "getStartScreenShareTime", "setStartScreenShareTime", "subTag", "getSubTag", "setSubTag", "tag", "getTag", "setTag", "timestampOfEnterLiveAnchorUI", "getTimestampOfEnterLiveAnchorUI", "setTimestampOfEnterLiveAnchorUI", "visibleRange", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisibleRangeType;", "getVisibleRange", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisibleRangeType;", "setVisibleRange", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisibleRangeType;)V", "visibleRangeNum", "getVisibleRangeNum", "setVisibleRangeNum", "visitorEnterType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "getVisitorEnterType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "setVisitorEnterType", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;)V", "convert21919Action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CloseUISeeGiftList;", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$SEE_GIFT_LIST;", "genShareId", "", "getAnchorFeedId", "getAnchorLiveId", "getEnterIconType", "commenScene", "defVal", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FilterType;", "filterPath", "getFinderUserName", "getPoi", "getPromoteGoodsStr", "getSessionPageId", "getdesc", "initShareReport", "isPrivate", "isPrivateAccount4Visitor", "userName", "resetShareData", "resetSomeData", "setShopParams", "shopSessionId", "clickType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "stopPromoteGood", "productId", "stopPromoteGoods", "ActionType", "AllCommentType", "AnchorActionType", "AnchorDescActionJsonKey", "AnchorDescActionType", "AnchorFloatAction", "AnchorLiveClose", "AnchorLotteryType", "BattleActionType", "BookLiveSrc", "CastScreenResult", "ClearScreenAction", "CloseUISeeGiftList", "CommentSceneExtend", "ComplaintVisitorSource", "CoverType", "CoverType2", "EldUdfKVAnchorStatus", "ElementClickId", "ElementExposeId", "EnterRoomStatus", "ExitType", "ExploreType", "FilterType", "FinderAudienceHistoryLiveActionLogAction", "FloatActionType", "FollowBtnAction", "FollowState", "GIFT_SWITCCH", "GameWelfareType", "GiftAllowanceAnchor", "GiftAllowanceVisitor", "GiftSwitch", "HalfProfileAnchorResult", "HalfProfileScene", "HalfProfileType", "HalfProfileVisitorResult", "IdentityType", "InviteType", "IsGift", "JspiCommenScene", "LikeSwitchType", "LinkOp", "LinkSwitch", "LinkType", "LiveAnchorCommerceAction", "LiveAnchorMusicEditAction", "LiveAnchorScreenShareAction", "LiveBookAction", "LivePersonalAction", "LiveVerified", "Live_Enter_Type", "MicType", "ModifyPayGameTeam", "MusicType", "NET_SPEED_LOW_ACTION", "NearbyAction2", "NearbyMoreActionResult", "NearbyPageType", "OpenHandOffResult", "RedPacketSrc", "RedPacketType", "ReplayEvent", "RuleType", "SCREEN_SWITCH_ACTION", "SEE_GIFT_LIST", "ScreenBtnEvent", "ScreenDirection", "ShareType", "ShopPermitAction", "StartLiveSource", "StartType", "VisibleRangeType", "VisitorAction", "VisitorAuthAction", "VisitorCloseType", "VisitorCommerceAction", "VisitorDescActionJsonKey", "VisitorDescActionType", "VisitorEnterType", "VisitorFansClub", "VisitorGift", "VisitorLinkMicAction", "VisitorLotteryAttendType", "VisitorLotteryType", "VisitorNoticeAction", "VisitorShareType", "VisitorShopBtnState", "VisitorWinResult", "VrModeAction", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public boolean DpA;
  public String DpB;
  public String DpC;
  long DpD;
  public boolean DpE;
  public boolean DpF;
  int DpG;
  int DpH;
  int DpI;
  int DpJ;
  int DpK;
  int DpL;
  int DpM;
  boolean DpN;
  final ArrayList<com.tencent.mm.vending.j.d<String, Long, Boolean>> DpO;
  public String DpP;
  public boolean DpQ;
  aq DpR;
  boolean DpS;
  am DpT;
  long DpU;
  boolean DpV;
  public int DpW;
  public int DpX;
  String DpY;
  String DpZ;
  final ArrayList<com.tencent.mm.vending.j.d<q.ar, Long, Boolean>> Dpa;
  public String Dpy;
  public long Dpz;
  public q.j DqA;
  public long DqB;
  public com.tencent.mm.ad.f DqC;
  br Dqa;
  public String Dqb;
  bt Dqc;
  long Dqd;
  String Dqe;
  public final HashMap<String, String> Dqf;
  public final HashMap<String, String> Dqg;
  public ca Dqh;
  v Dqi;
  long Dqj;
  long Dqk;
  JSONObject Dql;
  int Dqm;
  public long Dqn;
  public long Dqo;
  public long Dqp;
  public r Dqq;
  public boolean Dqr;
  public boolean Dqs;
  public boolean Dqt;
  public boolean Dqu;
  public boolean Dqv;
  public LinkedList<Long> Dqw;
  public WeakReference<RecyclerView> Dqx;
  bf Dqy;
  br Dqz;
  private final String TAG;
  String desc;
  int errCode;
  String liveId;
  String mIC;
  int mUZ;
  String objectId;
  String tag;
  
  public q()
  {
    AppMethodBeat.i(351849);
    this.TAG = "HABBYGE-MALI.LiveReportConfig";
    this.Dpy = "";
    this.DpB = "";
    this.DpC = "";
    this.Dpa = new ArrayList();
    this.DpO = new ArrayList();
    this.DpP = "";
    this.DpR = aq.Dzb;
    this.DpT = am.DyA;
    this.DpY = "";
    this.tag = "";
    this.DpZ = "";
    this.Dqa = br.DBW;
    this.Dqb = "";
    this.Dqc = bt.DCd;
    this.mIC = "";
    this.liveId = "";
    this.objectId = "";
    this.Dqe = "";
    this.Dqf = ak.g(new kotlin.r[] { new kotlin.r("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", "1"), new kotlin.r("FinderProfileTimeLineUI", "1"), new kotlin.r("com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI", "16"), new kotlin.r("FinderLbsStreamListUI", "16"), new kotlin.r("com.tencent.mm.plugin.finder.ui.FinderFollowListUI", "12"), new kotlin.r("FinderFollowListUI", "12"), new kotlin.r("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", "27"), new kotlin.r("FinderTopicTimelineUI", "27"), new kotlin.r("com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "25"), new kotlin.r("FinderShareFeedRelUI", "25"), new kotlin.r("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", "2"), new kotlin.r("FinderLikedFeedUI", "2"), new kotlin.r("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", "21"), new kotlin.r("FinderFavTimelineUI", "21"), new kotlin.r("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI", "40"), new kotlin.r("FinderFeedRelatedTimelineUI", "40"), new kotlin.r("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "23"), new kotlin.r("FinderMixSearchUI", "23"), new kotlin.r("com.tencent.mm.plugin.finder.search.FinderContactSearchUI", n.Dtv.scene), new kotlin.r("FinderContactSearchUI", n.Dtv.scene), new kotlin.r("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", "6"), new kotlin.r("FinderFeedSearchUI", "6") });
    this.Dqg = ak.g(new kotlin.r[] { new kotlin.r("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", "17"), new kotlin.r("FinderFollowTabFragment", "17"), new kotlin.r("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", "18"), new kotlin.r("FinderFriendTabFragment", "18"), new kotlin.r("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", "20"), new kotlin.r("FinderMachineTabFragment", "20") });
    this.Dqh = ca.DDZ;
    this.Dqi = v.DwM;
    this.Dqk = 1L;
    this.Dqm = q.q.Dua.type;
    this.Dqq = new r();
    this.Dqw = new LinkedList();
    this.Dqy = bf.DAJ;
    this.Dqz = br.DBW;
    this.DqA = q.j.DsU;
    this.DqC = new com.tencent.mm.ad.f();
    AppMethodBeat.o(351849);
  }
  
  public static long aB(String paramString, long paramLong)
  {
    boolean bool2 = true;
    AppMethodBeat.i(351908);
    if (s.p(paramString, n.DtC.scene))
    {
      bool1 = true;
      if (!bool1) {
        break label89;
      }
      bool1 = true;
      label30:
      if (!bool1) {
        break label103;
      }
      bool1 = true;
      label36:
      if (!bool1) {
        break label117;
      }
      bool1 = true;
      label42:
      if (!bool1) {
        break label131;
      }
      bool1 = true;
      label48:
      if (!bool1) {
        break label145;
      }
    }
    label131:
    label145:
    for (boolean bool1 = bool2;; bool1 = s.p(paramString, an.DyE.type))
    {
      if (!bool1) {
        break label159;
      }
      paramLong = ca.DEd.type;
      AppMethodBeat.o(351908);
      return paramLong;
      bool1 = s.p(paramString, n.DtG.scene);
      break;
      label89:
      bool1 = s.p(paramString, n.DtH.scene);
      break label30;
      label103:
      bool1 = s.p(paramString, an.DyC.type);
      break label36;
      label117:
      bool1 = s.p(paramString, an.DyD.type);
      break label42;
      bool1 = s.p(paramString, an.DyG.type);
      break label48;
    }
    label159:
    s.p(paramString, an.DyF.type);
    AppMethodBeat.o(351908);
    return paramLong;
  }
  
  public static x axC(String paramString)
  {
    AppMethodBeat.i(351856);
    com.tencent.mm.live.core.d.b localb = com.tencent.mm.live.core.d.b.mWI;
    switch (com.tencent.mm.live.core.d.b.Ge(paramString))
    {
    default: 
      paramString = x.Dxd;
      AppMethodBeat.o(351856);
      return paramString;
    case 0: 
      paramString = x.Dxe;
      AppMethodBeat.o(351856);
      return paramString;
    case 1: 
      paramString = x.Dxf;
      AppMethodBeat.o(351856);
      return paramString;
    case 2: 
      paramString = x.Dxm;
      AppMethodBeat.o(351856);
      return paramString;
    case 3: 
      paramString = x.Dxn;
      AppMethodBeat.o(351856);
      return paramString;
    case 4: 
      paramString = x.Dxo;
      AppMethodBeat.o(351856);
      return paramString;
    case 5: 
      paramString = x.Dxp;
      AppMethodBeat.o(351856);
      return paramString;
    case 6: 
      paramString = x.Dxq;
      AppMethodBeat.o(351856);
      return paramString;
    case 7: 
      paramString = x.Dxh;
      AppMethodBeat.o(351856);
      return paramString;
    case 8: 
      paramString = x.Dxi;
      AppMethodBeat.o(351856);
      return paramString;
    case 9: 
      paramString = x.Dxj;
      AppMethodBeat.o(351856);
      return paramString;
    }
    paramString = x.Dxd;
    AppMethodBeat.o(351856);
    return paramString;
  }
  
  public static int axD(String paramString)
  {
    AppMethodBeat.i(351885);
    if (paramString == null)
    {
      AppMethodBeat.o(351885);
      return 0;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    paramString = d.a.auT(paramString);
    localObject = aw.Gjk;
    if (aw.n(paramString))
    {
      AppMethodBeat.o(351885);
      return 1;
    }
    AppMethodBeat.o(351885);
    return 0;
  }
  
  public static m b(bm parambm)
  {
    AppMethodBeat.i(351920);
    s.u(parambm, "action");
    switch (cl.avl[parambm.ordinal()])
    {
    default: 
      parambm = m.Dtj;
    }
    for (;;)
    {
      AppMethodBeat.o(351920);
      return parambm;
      parambm = m.Dtn;
      continue;
      parambm = m.Dto;
      continue;
      parambm = m.Dtp;
      continue;
      parambm = m.Dtq;
      continue;
      parambm = m.Dtr;
    }
  }
  
  public static String egv()
  {
    AppMethodBeat.i(351892);
    String str = z.bAW();
    if (str == null)
    {
      AppMethodBeat.o(351892);
      return "";
    }
    AppMethodBeat.o(351892);
    return str;
  }
  
  public static String ety()
  {
    AppMethodBeat.i(351876);
    String str = c.dLD().dHN();
    if (str == null)
    {
      AppMethodBeat.o(351876);
      return "";
    }
    AppMethodBeat.o(351876);
    return str;
  }
  
  public static int etz()
  {
    AppMethodBeat.i(351901);
    Object localObject1 = egv();
    Object localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = d.a.auT((String)localObject1);
    localObject2 = aw.Gjk;
    if (aw.n((com.tencent.mm.plugin.finder.api.m)localObject1))
    {
      AppMethodBeat.o(351901);
      return 1;
    }
    AppMethodBeat.o(351901);
    return 0;
  }
  
  public static String getDescription()
  {
    AppMethodBeat.i(351866);
    Object localObject = a.CMm;
    localObject = a.emY();
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localObject = com.tencent.mm.compatible.util.r.as((String)localObject, "UTF-8");
      s.s(localObject, "encode(text, \"UTF-8\")");
      AppMethodBeat.o(351866);
      return localObject;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).EeY;
        if (localObject == null)
        {
          localObject = "";
        }
        else
        {
          String str = ((FinderObjectDesc)localObject).description;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.ad.f paramf)
  {
    AppMethodBeat.i(352049);
    s.u(paramf, "<set-?>");
    this.DqC = paramf;
    AppMethodBeat.o(352049);
  }
  
  public final void a(am paramam)
  {
    AppMethodBeat.i(351950);
    s.u(paramam, "<set-?>");
    this.DpT = paramam;
    AppMethodBeat.o(351950);
  }
  
  public final void a(aq paramaq)
  {
    AppMethodBeat.i(351942);
    s.u(paramaq, "<set-?>");
    this.DpR = paramaq;
    AppMethodBeat.o(351942);
  }
  
  public final void a(bf parambf)
  {
    AppMethodBeat.i(352040);
    s.u(parambf, "<set-?>");
    this.Dqy = parambf;
    AppMethodBeat.o(352040);
  }
  
  public final void a(br parambr)
  {
    AppMethodBeat.i(351974);
    s.u(parambr, "<set-?>");
    this.Dqa = parambr;
    AppMethodBeat.o(351974);
  }
  
  public final void a(bt parambt)
  {
    AppMethodBeat.i(351981);
    s.u(parambt, "<set-?>");
    this.Dqc = parambt;
    AppMethodBeat.o(351981);
  }
  
  public final void a(w paramw, String paramString)
  {
    AppMethodBeat.i(351987);
    s.u(paramw, "clickType");
    s.u(paramString, "commenScene");
    switch (cl.$EnumSwitchMapping$0[paramw.ordinal()])
    {
    default: 
      this.Dqh = ca.DDY;
      AppMethodBeat.o(351987);
      return;
    case 1: 
    case 2: 
    case 3: 
      if ((s.p(paramString, "37")) || (s.p(paramString, String.valueOf(n.DtE))) || (s.p(paramString, String.valueOf(n.DtC))))
      {
        this.Dqh = ca.DEd;
        AppMethodBeat.o(351987);
        return;
      }
      this.Dqh = ca.DDZ;
      AppMethodBeat.o(351987);
      return;
    case 4: 
      this.Dqh = ca.DEc;
      AppMethodBeat.o(351987);
      return;
    case 5: 
      this.Dqh = ca.DEa;
      AppMethodBeat.o(351987);
      return;
    }
    this.Dqh = ca.DEb;
    AppMethodBeat.o(351987);
  }
  
  public final void axA(String paramString)
  {
    AppMethodBeat.i(351936);
    s.u(paramString, "<set-?>");
    this.DpP = paramString;
    AppMethodBeat.o(351936);
  }
  
  public final void axB(String paramString)
  {
    AppMethodBeat.i(351966);
    s.u(paramString, "<set-?>");
    this.DpZ = paramString;
    AppMethodBeat.o(351966);
  }
  
  public final void axz(String paramString)
  {
    AppMethodBeat.i(351926);
    s.u(paramString, "<set-?>");
    this.Dpy = paramString;
    AppMethodBeat.o(351926);
  }
  
  public final void b(br parambr)
  {
    AppMethodBeat.i(352045);
    s.u(parambr, "<set-?>");
    this.Dqz = parambr;
    AppMethodBeat.o(352045);
  }
  
  public final void c(v paramv)
  {
    AppMethodBeat.i(352004);
    s.u(paramv, "<set-?>");
    this.Dqi = paramv;
    AppMethodBeat.o(352004);
  }
  
  public final void etA()
  {
    AppMethodBeat.i(352029);
    Object localObject = this.Dqq.DGi;
    if (((HashMap)localObject).isEmpty())
    {
      AppMethodBeat.o(352029);
      return;
    }
    long l2 = System.currentTimeMillis();
    localObject = ((Map)localObject).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((LinkedList)((Map.Entry)((Iterator)localObject).next()).getValue()).iterator();
      label84:
      m localm;
      long l1;
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if (!localm.Dpq)
        {
          localm.Dpq = true;
          l1 = l2 - localm.time;
          if (l1 <= 0L) {
            break label143;
          }
        }
      }
      for (;;)
      {
        localm.time = l1;
        break label84;
        break;
        label143:
        l1 = 0L;
      }
    }
    AppMethodBeat.o(352029);
  }
  
  public final String etv()
  {
    String str = null;
    AppMethodBeat.i(351996);
    Object localObject = a.CMm;
    localObject = a.emY();
    if (localObject == null) {}
    for (;;)
    {
      localObject = str;
      if (TextUtils.isEmpty((CharSequence)str)) {
        localObject = this.DpB;
      }
      Log.i(this.TAG, s.X("get shopAppid=", localObject));
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(351996);
      return "";
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)((a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (localObject != null) {
        str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eii;
      }
    }
    AppMethodBeat.o(351996);
    return localObject;
  }
  
  public final String etw()
  {
    AppMethodBeat.i(352013);
    Object localObject = a.CMm;
    localObject = a.emY();
    long l;
    if (localObject == null) {
      l = -1L;
    }
    while (l == -1L)
    {
      localObject = this.Dqq.liveId;
      AppMethodBeat.o(352013);
      return localObject;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject == null)
      {
        l = -1L;
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).liveInfo;
        if (localObject == null) {
          l = -1L;
        } else {
          l = ((bip)localObject).liveId;
        }
      }
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l);
    s.s(localObject, "{\n            HellhoundU…dString(liveId)\n        }");
    AppMethodBeat.o(352013);
    return localObject;
  }
  
  public final String etx()
  {
    AppMethodBeat.i(352018);
    Object localObject = a.CMm;
    localObject = a.emY();
    long l;
    if (localObject == null) {
      l = 0L;
    }
    while (l == 0L)
    {
      localObject = this.Dqq.feedId;
      AppMethodBeat.o(352018);
      return localObject;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject == null) {
        l = 0L;
      } else {
        l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).hKN;
      }
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l);
    s.s(localObject, "{\n            HellhoundU…dString(feedId)\n        }");
    AppMethodBeat.o(352018);
    return localObject;
  }
  
  public final void setTag(String paramString)
  {
    AppMethodBeat.i(351959);
    s.u(paramString, "<set-?>");
    this.tag = paramString;
    AppMethodBeat.o(351959);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ActionType;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "PROFILE_LIVE_BTN_EXPOSE", "PROFILE_LIVE_BTN_CLICK", "LIVE_ENTER_UI", "LIVE_BTN_CLICK", "LIVE_EXCHANGE_CAMERA", "LIVE_COMMERCE", "LIVE_EDIT_COVER", "LIVE_DESCRIPTION", "LIVE_POI", "LIVE_RULE", "LIVE_TIMER", "LIVE_SUCCESS", "LIVE_OUT", "LIVE_CLICK_BTN_MENU", "LINKMIC_SWITCH", "GIFT_SWITCCH", "GAME_LIVE", "LIVE_AUDIO_MODE", "ANCHOR_MUSIC_BEFORE_LIVE", "LIVE_BEAUTY", "LIVE_LIKE", "MINI_GAME_LIVE", "NET_SPEED_LOW", "FANS_CLUB", "PROMOTE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    public final long mwI;
    
    static
    {
      AppMethodBeat.i(351722);
      DqD = new a("PROFILE_LIVE_BTN_EXPOSE", 0, 1L);
      DqE = new a("PROFILE_LIVE_BTN_CLICK", 1, 2L);
      DqF = new a("LIVE_ENTER_UI", 2, 3L);
      DqG = new a("LIVE_BTN_CLICK", 3, 4L);
      DqH = new a("LIVE_EXCHANGE_CAMERA", 4, 5L);
      DqI = new a("LIVE_COMMERCE", 5, 6L);
      DqJ = new a("LIVE_EDIT_COVER", 6, 7L);
      DqK = new a("LIVE_DESCRIPTION", 7, 8L);
      DqL = new a("LIVE_POI", 8, 9L);
      DqM = new a("LIVE_RULE", 9, 10L);
      DqN = new a("LIVE_TIMER", 10, 11L);
      DqO = new a("LIVE_SUCCESS", 11, 12L);
      DqP = new a("LIVE_OUT", 12, 13L);
      DqQ = new a("LIVE_CLICK_BTN_MENU", 13, 14L);
      DqR = new a("LINKMIC_SWITCH", 14, 15L);
      DqS = new a("GIFT_SWITCCH", 15, 16L);
      DqT = new a("GAME_LIVE", 16, 18L);
      DqU = new a("LIVE_AUDIO_MODE", 17, 20L);
      DqV = new a("ANCHOR_MUSIC_BEFORE_LIVE", 18, 21L);
      DqW = new a("LIVE_BEAUTY", 19, 23L);
      DqX = new a("LIVE_LIKE", 20, 24L);
      DqY = new a("MINI_GAME_LIVE", 21, 25L);
      DqZ = new a("NET_SPEED_LOW", 22, 26L);
      Dra = new a("FANS_CLUB", 23, 27L);
      Drb = new a("PROMOTE", 24, 29L);
      Drc = new a[] { DqD, DqE, DqF, DqG, DqH, DqI, DqJ, DqK, DqL, DqM, DqN, DqO, DqP, DqQ, DqR, DqS, DqT, DqU, DqV, DqW, DqX, DqY, DqZ, Dra, Drb };
      AppMethodBeat.o(351722);
    }
    
    private a(long paramLong)
    {
      this.mwI = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FollowBtnAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "EXPOSE", "CLICK_2_FOLLOW", "CLICK_2_PROFILE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum aa
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351626);
      DxF = new aa("EXPOSE", 0, 1);
      DxG = new aa("CLICK_2_FOLLOW", 1, 2);
      DxH = new aa("CLICK_2_PROFILE", 2, 3);
      DxI = new aa[] { DxF, DxG, DxH };
      AppMethodBeat.o(351626);
    }
    
    private aa(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FollowState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "UNFOLLOW", "FOLLOWED", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ab
  {
    final int state;
    
    static
    {
      AppMethodBeat.i(351627);
      DxJ = new ab("UNFOLLOW", 0, 0);
      DxK = new ab("FOLLOWED", 1, 1);
      DxL = new ab[] { DxJ, DxK };
      AppMethodBeat.o(351627);
    }
    
    private ab(int paramInt)
    {
      this.state = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GIFT_SWITCCH;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLOSE_SEND_GIFT_BY_MORE", "OPEN_SEND_GIFT_BY_MORE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ac
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351649);
      DxM = new ac("CLOSE_SEND_GIFT_BY_MORE", 0, 1);
      DxN = new ac("OPEN_SEND_GIFT_BY_MORE", 1, 2);
      DxO = new ac[] { DxM, DxN };
      AppMethodBeat.o(351649);
    }
    
    private ac(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GameWelfareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "TASK_EXPOSURE", "GET_EXPOSURE", "TASK_CLICK", "GET_CLICK", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ad
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351648);
      DxP = new ad("TASK_EXPOSURE", 0, 1);
      DxQ = new ad("GET_EXPOSURE", 1, 2);
      DxR = new ad("TASK_CLICK", 2, 3);
      DxS = new ad("GET_CLICK", 3, 4);
      DxT = new ad[] { DxP, DxQ, DxR, DxS };
      AppMethodBeat.o(351648);
    }
    
    private ad(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GiftAllowanceAnchor;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ICON_EXPOSE", "ICON_CLICK", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ae
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351664);
      DxU = new ae("ICON_EXPOSE", 0, 1);
      DxV = new ae("ICON_CLICK", 1, 2);
      DxW = new ae[] { DxU, DxV };
      AppMethodBeat.o(351664);
    }
    
    private ae(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GiftAllowanceVisitor;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ICON_EXPOSE", "ICON_CLICK", "GET_SUCCESS", "GET_FAIL", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum af
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351632);
      DxX = new af("ICON_EXPOSE", 0, 1);
      DxY = new af("ICON_CLICK", 1, 2);
      DxZ = new af("GET_SUCCESS", 2, 3);
      Dya = new af("GET_FAIL", 3, 4);
      Dyb = new af[] { DxX, DxY, DxZ, Dya };
      AppMethodBeat.o(351632);
    }
    
    private af(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GiftSwitch;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "BY_MORE_CLOSE_GIFT", "BY_MORE_OPEN_GIFT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ag
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351589);
      Dyc = new ag("BY_MORE_CLOSE_GIFT", 0, 1);
      Dyd = new ag("BY_MORE_OPEN_GIFT", 1, 2);
      Dye = new ag[] { Dyc, Dyd };
      AppMethodBeat.o(351589);
    }
    
    private ag(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$HalfProfileAnchorResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SHOW", "CLICK_GO_FINDER", "CLICK_CHAT", "CLICK_FOLLOW", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ah
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(351599);
      Dyf = new ah("SHOW", 0, 1);
      Dyg = new ah("CLICK_GO_FINDER", 1, 2);
      Dyh = new ah("CLICK_CHAT", 2, 3);
      Dyi = new ah("CLICK_FOLLOW", 3, 4);
      Dyj = new ah[] { Dyf, Dyg, Dyh, Dyi };
      AppMethodBeat.o(351599);
    }
    
    private ah(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$HalfProfileScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "MEMBER_LIST", "COMMENT_LIST", "LINK_MIC", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ai
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(351619);
      Dyk = new ai("MEMBER_LIST", 0, 1);
      Dyl = new ai("COMMENT_LIST", 1, 2);
      Dym = new ai("LINK_MIC", 2, 3);
      Dyn = new ai[] { Dyk, Dyl, Dym };
      AppMethodBeat.o(351619);
    }
    
    private ai(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$HalfProfileType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FINDER", "ALIAS", "WECHAT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum aj
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(351583);
      Dyo = new aj("FINDER", 0, 1);
      Dyp = new aj("ALIAS", 1, 2);
      Dyq = new aj("WECHAT", 2, 3);
      Dyr = new aj[] { Dyo, Dyp, Dyq };
      AppMethodBeat.o(351583);
    }
    
    private aj(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$HalfProfileVisitorResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SHOW", "CLICK_GO_FINDER", "CLICK_GIFT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ak
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(351582);
      Dys = new ak("SHOW", 0, 1);
      Dyt = new ak("CLICK_GO_FINDER", 1, 2);
      Dyu = new ak("CLICK_GIFT", 2, 3);
      Dyv = new ak[] { Dys, Dyt, Dyu };
      AppMethodBeat.o(351582);
    }
    
    private ak(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$InviteType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "INITIATIVE", "PASSIVE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum al
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351616);
      Dyw = new al("INITIATIVE", 0, 1);
      Dyx = new al("PASSIVE", 1, 2);
      Dyy = new al[] { Dyw, Dyx };
      AppMethodBeat.o(351616);
    }
    
    private al(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$IsGift;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "YES", "NO", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum am
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351605);
      Dyz = new am("YES", 0, 1);
      DyA = new am("NO", 1, 2);
      DyB = new am[] { Dyz, DyA };
      AppMethodBeat.o(351605);
    }
    
    private am(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$JspiCommenScene;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PUBLIC_NUMBER", "SEARCH_1_SEARCH", "SEE_1_SEE", "GAME_CENTER", "LITTLE_APP", "DAILY_TIP", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum an
  {
    final String type;
    
    static
    {
      AppMethodBeat.i(351607);
      DyC = new an("PUBLIC_NUMBER", 0, "5");
      DyD = new an("SEARCH_1_SEARCH", 1, "6");
      DyE = new an("SEE_1_SEE", 2, "7");
      DyF = new an("GAME_CENTER", 3, "9");
      DyG = new an("LITTLE_APP", 4, "15");
      DyH = new an("DAILY_TIP", 5, "30");
      DyI = new an[] { DyC, DyD, DyE, DyF, DyG, DyH };
      AppMethodBeat.o(351607);
    }
    
    private an(String paramString)
    {
      this.type = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LikeSwitchType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_LIKE_SWITCH_ENABLE", "LIVE_LIKE_SWITCH_DISABLE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ao
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351602);
      DyJ = new ao("LIVE_LIKE_SWITCH_ENABLE", 0, 1);
      DyK = new ao("LIVE_LIKE_SWITCH_DISABLE", 1, 2);
      DyL = new ao[] { DyJ, DyK };
      AppMethodBeat.o(351602);
    }
    
    private ao(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkOp;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_LINKMIC_LOGO", "CONNECT_VOICE_TO_LINKMIC", "CONNECT_VIDEO_TO_LINKMIC", "DISCONNECT_VOICE_TO_LINKMIC", "DISCONNECT_VIDEO_TO_LINKMIC", "LINKMIC_ICON_READDOT_EXPOSE", "ENTER_VISITOR_LINKMIC_TAB", "ENTER_ANCHOR_LINKMIC_TAB", "ENTER_INVITE_ANCHOR_LINKMIC_TAB", "INVITE_ANCHOR_LINKMIC", "LINKMIC_CONNECT_SUCCESS", "STOP_LINKMIC_WHEN_WAITING_CONNECT", "STOP_LINKMIC_WHEN_SHOW_CONNECTING", "LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ap
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351694);
      DyM = new ap("CLICK_LINKMIC_LOGO", 0, 1);
      DyN = new ap("CONNECT_VOICE_TO_LINKMIC", 1, 2);
      DyO = new ap("CONNECT_VIDEO_TO_LINKMIC", 2, 3);
      DyP = new ap("DISCONNECT_VOICE_TO_LINKMIC", 3, 4);
      DyQ = new ap("DISCONNECT_VIDEO_TO_LINKMIC", 4, 5);
      DyR = new ap("LINKMIC_ICON_READDOT_EXPOSE", 5, 6);
      DyS = new ap("ENTER_VISITOR_LINKMIC_TAB", 6, 7);
      DyT = new ap("ENTER_ANCHOR_LINKMIC_TAB", 7, 8);
      DyU = new ap("ENTER_INVITE_ANCHOR_LINKMIC_TAB", 8, 9);
      DyV = new ap("INVITE_ANCHOR_LINKMIC", 9, 10);
      DyW = new ap("LINKMIC_CONNECT_SUCCESS", 10, 11);
      DyX = new ap("STOP_LINKMIC_WHEN_WAITING_CONNECT", 11, 12);
      DyY = new ap("STOP_LINKMIC_WHEN_SHOW_CONNECTING", 12, 13);
      DyZ = new ap("LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW", 13, 14);
      Dza = new ap[] { DyM, DyN, DyO, DyP, DyQ, DyR, DyS, DyT, DyU, DyV, DyW, DyX, DyY, DyZ };
      AppMethodBeat.o(351694);
    }
    
    private ap(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkSwitch;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "OPEN", "CLOSE", "MIC_SETTING_NO", "MIC_SETTING_REWARD", "MIC_SETTING_FOLLOW", "MIC_SETTING_BUY_PRODUCT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum aq
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351684);
      Dzb = new aq("OPEN", 0, 1);
      Dzc = new aq("CLOSE", 1, 2);
      Dzd = new aq("MIC_SETTING_NO", 2, 3);
      Dze = new aq("MIC_SETTING_REWARD", 3, 4);
      Dzf = new aq("MIC_SETTING_FOLLOW", 4, 5);
      Dzg = new aq("MIC_SETTING_BUY_PRODUCT", 5, 7);
      Dzh = new aq[] { Dzb, Dzc, Dzd, Dze, Dzf, Dzg };
      AppMethodBeat.o(351684);
    }
    
    private aq(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveAnchorCommerceAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_ENTER_SHOP", "LIVE_ADD_GOODS", "LIVE_CLICK_GOODS", "LIVE_DELETE_GOODS", "LIVE_SET_TOP_GOODS", "LIVE_START_PROMOTE_GOODS", "LIVE_FINISH_PROMOTE_GOODS", "LIVE_CLICK_PROMOTE_GOODS", "LIVE_CLICK_SHOPPING_ADD_PRODUCT", "LIVE_CLICK_ISSUE_COUPON", "LIVE_CLICK_UNISSUE_COUPON", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum as
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351681);
      Dzm = new as("LIVE_ENTER_SHOP", 0, 1);
      Dzn = new as("LIVE_ADD_GOODS", 1, 2);
      Dzo = new as("LIVE_CLICK_GOODS", 2, 3);
      Dzp = new as("LIVE_DELETE_GOODS", 3, 4);
      Dzq = new as("LIVE_SET_TOP_GOODS", 4, 5);
      Dzr = new as("LIVE_START_PROMOTE_GOODS", 5, 7);
      Dzs = new as("LIVE_FINISH_PROMOTE_GOODS", 6, 8);
      Dzt = new as("LIVE_CLICK_PROMOTE_GOODS", 7, 9);
      Dzu = new as("LIVE_CLICK_SHOPPING_ADD_PRODUCT", 8, 10);
      Dzv = new as("LIVE_CLICK_ISSUE_COUPON", 9, 11);
      Dzw = new as("LIVE_CLICK_UNISSUE_COUPON", 10, 12);
      Dzx = new as[] { Dzm, Dzn, Dzo, Dzp, Dzq, Dzr, Dzs, Dzt, Dzu, Dzv, Dzw };
      AppMethodBeat.o(351681);
    }
    
    private as(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveAnchorMusicEditAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "SEARCH_MUSIC", "ADD_MUSIC", "CLICK_VOLUME", "DELETE_MUSIC_ITEM", "CLICK_MENU", "DELETE_MUSIC_LIST", "FINISH_EDIT", "PLAY_MUSIC", "PAUSE_MUSIC", "CLICK_CANCEL", "SHOW_MUSIC_PANEL", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum at
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351700);
      Dzy = new at("SEARCH_MUSIC", 0, 1);
      Dzz = new at("ADD_MUSIC", 1, 2);
      DzA = new at("CLICK_VOLUME", 2, 3);
      DzB = new at("DELETE_MUSIC_ITEM", 3, 4);
      DzC = new at("CLICK_MENU", 4, 5);
      DzD = new at("DELETE_MUSIC_LIST", 5, 6);
      DzE = new at("FINISH_EDIT", 6, 7);
      DzF = new at("PLAY_MUSIC", 7, 8);
      DzG = new at("PAUSE_MUSIC", 8, 9);
      DzH = new at("CLICK_CANCEL", 9, 10);
      DzI = new at("SHOW_MUSIC_PANEL", 10, 11);
      DzJ = new at[] { Dzy, Dzz, DzA, DzB, DzC, DzD, DzE, DzF, DzG, DzH, DzI };
      AppMethodBeat.o(351700);
    }
    
    private at(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveAnchorScreenShareAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "EXPOSE", "CLICK", "START", "FINISH", "CLOSE_CAMERA", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum au
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351696);
      DzK = new au("EXPOSE", 0, 1);
      DzL = new au("CLICK", 1, 2);
      DzM = new au("START", 2, 3);
      DzN = new au("FINISH", 3, 4);
      DzO = new au("CLOSE_CAMERA", 4, 5);
      DzP = new au[] { DzK, DzL, DzM, DzN, DzO };
      AppMethodBeat.o(351696);
    }
    
    private au(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveBookAction;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "LIVE_SELF_PAGE_CLICK_BOOK_ITEM", "LIVE_ENTER_CRAETE_BOOK_PAGE", "LIVE_CREATE_BOOK_SUCC", "LIVE_JUMP_PROFILE_PAGE", "LIVE_CANCEL_BOOK", "LIVE_CREATE_QRCODE", "LIVE_CHECK_NOTICE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum av
  {
    final long mwI;
    
    static
    {
      AppMethodBeat.i(351695);
      DzQ = new av("LIVE_SELF_PAGE_CLICK_BOOK_ITEM", 0, 1L);
      DzR = new av("LIVE_ENTER_CRAETE_BOOK_PAGE", 1, 2L);
      DzS = new av("LIVE_CREATE_BOOK_SUCC", 2, 3L);
      DzT = new av("LIVE_JUMP_PROFILE_PAGE", 3, 4L);
      DzU = new av("LIVE_CANCEL_BOOK", 4, 5L);
      DzV = new av("LIVE_CREATE_QRCODE", 5, 6L);
      DzW = new av("LIVE_CHECK_NOTICE", 6, 7L);
      DzX = new av[] { DzQ, DzR, DzS, DzT, DzU, DzV, DzW };
      AppMethodBeat.o(351695);
    }
    
    private av(long paramLong)
    {
      this.mwI = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LivePersonalAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_PERSONAL_VIEW_SHOW", "LIVE_PERSONAL_COMMENT_CLOSE", "LIVE_PERSONAL_COMMENT_OPEN", "LIVE_PERSONAL_COMPLAIN", "LIVE_PERSONAL_KICK_OUT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum aw
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351691);
      DzY = new aw("LIVE_PERSONAL_VIEW_SHOW", 0, 1);
      DzZ = new aw("LIVE_PERSONAL_COMMENT_CLOSE", 1, 2);
      DAa = new aw("LIVE_PERSONAL_COMMENT_OPEN", 2, 3);
      DAb = new aw("LIVE_PERSONAL_COMPLAIN", 3, 4);
      DAc = new aw("LIVE_PERSONAL_KICK_OUT", 4, 5);
      DAd = new aw[] { DzY, DzZ, DAa, DAb, DAc };
      AppMethodBeat.o(351691);
    }
    
    private aw(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveVerified;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "LIVE_VERIFIED_PAGE_EXPOSURE", "LIVE_ENTER_VERIFIED_PAGE", "LIVE_PASS_VERIFIED_SUCC", "LIVE_PASS_VERIFIED_FAIL", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ax
  {
    final long mwI;
    
    static
    {
      AppMethodBeat.i(351672);
      DAe = new ax("LIVE_VERIFIED_PAGE_EXPOSURE", 0, 1L);
      DAf = new ax("LIVE_ENTER_VERIFIED_PAGE", 1, 2L);
      DAg = new ax("LIVE_PASS_VERIFIED_SUCC", 2, 3L);
      DAh = new ax("LIVE_PASS_VERIFIED_FAIL", 3, 4L);
      DAi = new ax[] { DAe, DAf, DAg, DAh };
      AppMethodBeat.o(351672);
    }
    
    private ax(long paramLong)
    {
      this.mwI = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$MicType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ANCHOR_ANCHOR", "ANCHOR_VISITOR", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum az
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351690);
      DAn = new az("ANCHOR_ANCHOR", 0, 1);
      DAo = new az("ANCHOR_VISITOR", 1, 2);
      DAp = new az[] { DAn, DAo };
      AppMethodBeat.o(351690);
    }
    
    private az(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AllCommentType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_ALL_COMMENT_CLOSE", "LIVE_ALL_COMMENT_OPEN", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351730);
      Drd = new b("LIVE_ALL_COMMENT_CLOSE", 0, 1);
      Dre = new b("LIVE_ALL_COMMENT_OPEN", 1, 2);
      Drf = new b[] { Drd, Dre };
      AppMethodBeat.o(351730);
    }
    
    private b(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ModifyPayGameTeam;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLOSE", "OPEN", "MODIFY", "FAIL", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ba
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351674);
      DAq = new ba("CLOSE", 0, 1);
      DAr = new ba("OPEN", 1, 2);
      DAs = new ba("MODIFY", 2, 3);
      DAt = new ba("FAIL", 3, 4);
      DAu = new ba[] { DAq, DAr, DAs, DAt };
      AppMethodBeat.o(351674);
    }
    
    private ba(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$MusicType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_MUSIC_ENTRANCE", "CLICK_QQ_MUSIC", "CLICK_GOTO_QQ_MUSIC", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bb
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351761);
      DAv = new bb("CLICK_MUSIC_ENTRANCE", 0, 1);
      DAw = new bb("CLICK_QQ_MUSIC", 1, 2);
      DAx = new bb("CLICK_GOTO_QQ_MUSIC", 2, 3);
      DAy = new bb[] { DAv, DAw, DAx };
      AppMethodBeat.o(351761);
    }
    
    private bb(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NET_SPEED_LOW_ACTION;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "NET_SPEED_LOW_EXPOSE", "NET_SPEED_LOW_CLICK", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bc
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351741);
      DAz = new bc("NET_SPEED_LOW_EXPOSE", 0, 1);
      DAA = new bc("NET_SPEED_LOW_CLICK", 1, 2);
      DAB = new bc[] { DAz, DAA };
      AppMethodBeat.o(351741);
    }
    
    private bc(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyAction2;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ENTER_PAGE_EXPLORE", "CLICK_CANCEL_RETURN", "CLICK_START_LIVE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bd
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351745);
      DAC = new bd("ENTER_PAGE_EXPLORE", 0, 1);
      DAD = new bd("CLICK_CANCEL_RETURN", 1, 2);
      DAE = new bd("CLICK_START_LIVE", 2, 3);
      DAF = new bd[] { DAC, DAD, DAE };
      AppMethodBeat.o(351745);
    }
    
    private bd(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyMoreActionResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "EXPLORE_MORE_LIVE", "CLICK_MORE_LIVE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum be
  {
    final int result;
    
    static
    {
      AppMethodBeat.i(351737);
      DAG = new be("EXPLORE_MORE_LIVE", 0, 1);
      DAH = new be("CLICK_MORE_LIVE", 1, 2);
      DAI = new be[] { DAG, DAH };
      AppMethodBeat.o(351737);
    }
    
    private be(int paramInt)
    {
      this.result = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyPageType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "START_LIVE_BY_FINDER_IDENTITY", "CREATE_FINDER", "WECHAT_REALNAME_AUTH", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bf
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351768);
      DAJ = new bf("START_LIVE_BY_FINDER_IDENTITY", 0, 1);
      DAK = new bf("CREATE_FINDER", 1, 2);
      DAL = new bf("WECHAT_REALNAME_AUTH", 2, 3);
      DAM = new bf[] { DAJ, DAK, DAL };
      AppMethodBeat.o(351768);
    }
    
    private bf(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$OpenHandOffResult;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EXPOSE", "CLICK", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bg
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351770);
      DAN = new bg("EXPOSE", 0, 1);
      DAO = new bg("CLICK", 1, 2);
      DAP = new bg[] { DAN, DAO };
      AppMethodBeat.o(351770);
    }
    
    private bg(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketSrc;", "", "src", "", "(Ljava/lang/String;II)V", "getSrc", "()I", "UNKNOWN", "ANCHOR", "LINKMIC_VISITOR", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bh
  {
    final int src;
    
    static
    {
      AppMethodBeat.i(351790);
      DAQ = new bh("UNKNOWN", 0, -1);
      DAR = new bh("ANCHOR", 1, 1);
      DAS = new bh("LINKMIC_VISITOR", 2, 2);
      DAT = new bh[] { DAQ, DAR, DAS };
      AppMethodBeat.o(351790);
    }
    
    private bh(int paramInt)
    {
      this.src = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EXPOSE_RIGHT_UP_CORNER_RED_PACKET_", "CLICK_RED_PACKET", "CLICK_COMMENT_AREA_RED_PACKET_SYS_MSG", "EXPOSE_RED_PACKET_UI", "CLICK_OPEN_RED_PACKET", "EXPOSE_RED_PACKET_OVER_INTERCEPT_UI", "EXPOSE_ONLY_PART_USER_INTERCEPT_UI", "RED_PACKET_EXPIRED_NOTIFY", "ONLY_WX_IDENTIFY_INTERRUPT_NOTIFY", "SEE_DETAIL", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bi
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351766);
      DAU = new bi("EXPOSE_RIGHT_UP_CORNER_RED_PACKET_", 0, 1);
      DAV = new bi("CLICK_RED_PACKET", 1, 2);
      DAW = new bi("CLICK_COMMENT_AREA_RED_PACKET_SYS_MSG", 2, 3);
      DAX = new bi("EXPOSE_RED_PACKET_UI", 3, 4);
      DAZ = new bi("CLICK_OPEN_RED_PACKET", 4, 5);
      DBa = new bi("EXPOSE_RED_PACKET_OVER_INTERCEPT_UI", 5, 6);
      DBb = new bi("EXPOSE_ONLY_PART_USER_INTERCEPT_UI", 6, 7);
      DBc = new bi("RED_PACKET_EXPIRED_NOTIFY", 7, 8);
      DBd = new bi("ONLY_WX_IDENTIFY_INTERRUPT_NOTIFY", 8, 9);
      DBe = new bi("SEE_DETAIL", 9, 10);
      DBf = new bi[] { DAU, DAV, DAW, DAX, DAZ, DBa, DBb, DBc, DBd, DBe };
      AppMethodBeat.o(351766);
    }
    
    private bi(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ReplayEvent;", "", "event", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "WATCH_LIVE_RECORD", "PAY_LIVE_RECORD", "LIVE_RECORD_DURATION", "SHARE_RECORD_DURATION", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bj
  {
    public final String event;
    
    static
    {
      AppMethodBeat.i(351765);
      DBg = new bj("WATCH_LIVE_RECORD", 0, "watch_live_record");
      DBh = new bj("PAY_LIVE_RECORD", 1, "pay_live_record");
      DBi = new bj("LIVE_RECORD_DURATION", 2, "live_record_duration");
      DBj = new bj("SHARE_RECORD_DURATION", 3, "share_record_duration");
      DBk = new bj[] { DBg, DBh, DBi, DBj };
      AppMethodBeat.o(351765);
    }
    
    private bj(String paramString)
    {
      this.event = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RuleType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_RULE_ALREADY_OK", "LIVE_RULE_SHOW", "LIVE_RULE_CHECK_YES", "LIVE_RULE_CHECK_NO", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bk
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351742);
      DBl = new bk("LIVE_RULE_ALREADY_OK", 0, 1);
      DBm = new bk("LIVE_RULE_SHOW", 1, 2);
      DBn = new bk("LIVE_RULE_CHECK_YES", 2, 3);
      DBo = new bk("LIVE_RULE_CHECK_NO", 3, 4);
      DBp = new bk[] { DBl, DBm, DBn, DBo };
      AppMethodBeat.o(351742);
    }
    
    private bk(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$SCREEN_SWITCH_ACTION;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "HORIZONTAL_BY_CLICK_BTN", "HORIZONTAL_BY_ROTATE_PHONE", "PORTRAIT_BY_CLICK_BTN", "PORTRAIT_BY_ROTATE_PHONE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bl
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351726);
      DBq = new bl("HORIZONTAL_BY_CLICK_BTN", 0, 1);
      DBr = new bl("HORIZONTAL_BY_ROTATE_PHONE", 1, 2);
      DBs = new bl("PORTRAIT_BY_CLICK_BTN", 2, 3);
      DBt = new bl("PORTRAIT_BY_ROTATE_PHONE", 3, 4);
      DBu = new bl[] { DBq, DBr, DBs, DBt };
      AppMethodBeat.o(351726);
    }
    
    private bl(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$SEE_GIFT_LIST;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE", "CLICK_HELF_PAGE_INSTRUCTION", "RETURN_LIVE_ROOM", "CLICK_LIST_ITEM_USER", "EXPOSE_USER_FINDER_HALF_BOARD", "CLICK_PRIVATE_MSG_USER", "CLICK_FOLLOW_USER", "CLICK_COMPLAIN_USER", "CLICK_FORBITTEN_USER", "CLICK_BLACK_USER", "CLICK_ENTER_USER_PROFILE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bm
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351712);
      DBv = new bm("CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE", 0, 1);
      DBw = new bm("CLICK_HELF_PAGE_INSTRUCTION", 1, 2);
      DBx = new bm("RETURN_LIVE_ROOM", 2, 3);
      DBy = new bm("CLICK_LIST_ITEM_USER", 3, 4);
      DBz = new bm("EXPOSE_USER_FINDER_HALF_BOARD", 4, 5);
      DBA = new bm("CLICK_PRIVATE_MSG_USER", 5, 6);
      DBB = new bm("CLICK_FOLLOW_USER", 6, 7);
      DBC = new bm("CLICK_COMPLAIN_USER", 7, 8);
      DBD = new bm("CLICK_FORBITTEN_USER", 8, 9);
      DBE = new bm("CLICK_BLACK_USER", 9, 10);
      DBF = new bm("CLICK_ENTER_USER_PROFILE", 10, 11);
      DBG = new bm[] { DBv, DBw, DBx, DBy, DBz, DBA, DBB, DBC, DBD, DBE, DBF };
      AppMethodBeat.o(351712);
    }
    
    private bm(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenBtnEvent;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "FROM_ONCREATE", "FROM_ONRESUME", "FROM_ONPLUGIN", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bn
  {
    private final int action;
    
    static
    {
      AppMethodBeat.i(351702);
      DBH = new bn("FROM_ONCREATE", 0, 0);
      DBI = new bn("FROM_ONRESUME", 1, 1);
      DBJ = new bn("FROM_ONPLUGIN", 2, 2);
      DBK = new bn[] { DBH, DBI, DBJ };
      AppMethodBeat.o(351702);
    }
    
    private bn(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenDirection;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_SCREEN_PORTRAIT", "LIVE_SCREEN_HORIZONTAL", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bo
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351736);
      DBL = new bo("LIVE_SCREEN_PORTRAIT", 0, 1);
      DBM = new bo("LIVE_SCREEN_HORIZONTAL", 1, 2);
      DBN = new bo[] { DBL, DBM };
      AppMethodBeat.o(351736);
    }
    
    private bo(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CHAT", "CHAT_GROUP", "SNS", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bp
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351734);
      DBO = new bp("CHAT", 0, 1);
      DBP = new bp("CHAT_GROUP", 1, 2);
      DBQ = new bp("SNS", 2, 3);
      DBR = new bp[] { DBO, DBP, DBQ };
      AppMethodBeat.o(351734);
    }
    
    private bp(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ShopPermitAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_NO_SHOP_PERMIT", "LIVE_SHOP_PERMIT_NO_SMALL_STORE", "LIVE_SHOP_PERMIT_SMALL_STORE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bq
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351740);
      DBS = new bq("LIVE_NO_SHOP_PERMIT", 0, 1);
      DBT = new bq("LIVE_SHOP_PERMIT_NO_SMALL_STORE", 1, 2);
      DBU = new bq("LIVE_SHOP_PERMIT_SMALL_STORE", 2, 3);
      DBV = new bq[] { DBS, DBT, DBU };
      AppMethodBeat.o(351740);
    }
    
    private bq(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartLiveSource;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "FINDER_PROFILE", "NEARBY_LIVE", "FINDER_PROFILE_RIGHT_CORNER", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum br
  {
    final int source;
    
    static
    {
      AppMethodBeat.i(351750);
      DBW = new br("FINDER_PROFILE", 0, 1);
      DBX = new br("NEARBY_LIVE", 1, 2);
      DBY = new br("FINDER_PROFILE_RIGHT_CORNER", 2, 3);
      DBZ = new br[] { DBW, DBX, DBY };
      AppMethodBeat.o(351750);
    }
    
    private br(int paramInt)
    {
      this.source = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_START_NETWORK_ERROR", "LIVE_START_OK", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bs
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351886);
      DCa = new bs("LIVE_START_NETWORK_ERROR", 0, 1);
      DCb = new bs("LIVE_START_OK", 1, 2);
      DCc = new bs[] { DCa, DCb };
      AppMethodBeat.o(351886);
    }
    
    private bs(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisibleRangeType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "PUBLIC", "NUMBER_TO_SEE", "ONLY_ANCHOR_SHARE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bt
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351887);
      DCd = new bt("PUBLIC", 0, 0);
      DCe = new bt("NUMBER_TO_SEE", 1, 1);
      DCf = new bt("ONLY_ANCHOR_SHARE", 2, 2);
      DCg = new bt[] { DCd, DCe, DCf };
      AppMethodBeat.o(351887);
    }
    
    private bt(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "EnterRoom", "Message", "Like", "CommentExpose", "ComplaintEntry", "Float", "Share", "HideOpearation", "EnterProfile", "CopyComment", "SlideEnter", "Commerce", "QuitRoom", "Auth", "EXPLORE_SCREEN_SWITCH_BTN", "SWITCH_SCREEN", "REPLY", "LOTTERY", "GIFT", "LINKMIC", "NEARBY_LIVE_MORE", "FOLLOW_LIVE", "CLICK_LINKMIC_ANCHOR_AVATAR_TO_LIVING_ROOM", "RED_PACKET", "GAME_TEAM", "CAST_SCREEN", "VISITOR_MUSIC", "ANCHOR_PAUSE_LIVE", "JUMP_TO_OFFICIAL_ACCOUNT", "OPEN_HANDOFF", "JUMP_GAME", "COMMENT_OPTION", "PROMOTE_BANNER", "PROFILE_HALF_SCREEN", "MODIFY_VIDEO_DEFINITION", "FANS_CLUB", "LIVE_DESC", "GIFT_ALLOWANCE", "BIZ_NAME", "GAME_WELFARE", "BIZ_HEAD", "SCROLL_GUIDE", "SIDE_BAR", "ASSISTANT_LOTTERY", "ASSISTANT_SHOP", "ASSISTANT_MORE", "VR_MODE", "PROMOTE_VISITOR", "OUTER_FLOAT_MODE", "INNER_FLOAT_MODE", "GAME_RANK", "CHARGE_LIVE", "BOX_LIVE", "PREVIEW_LIVE", "EXIT_BEFORE_JOIN_RESP", "PLUS_BTN_CLICK", "AT_BTN_EXPOSE", "AT_WX_SOMEONE", "SOMEONE_AT_ME_CLICK", "AT_BTN_CLICK", "SEND_LOCATION_BTN_CLICK", "GET_CITY_INFO_FAIL", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bu
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351888);
      DCh = new bu("EnterRoom", 0, 1);
      DCi = new bu("Message", 1, 2);
      DCj = new bu("Like", 2, 3);
      DCk = new bu("CommentExpose", 3, 4);
      DCl = new bu("ComplaintEntry", 4, 5);
      DCm = new bu("Float", 5, 6);
      DCn = new bu("Share", 6, 7);
      DCo = new bu("HideOpearation", 7, 8);
      DCp = new bu("EnterProfile", 8, 9);
      DCq = new bu("CopyComment", 9, 10);
      DCr = new bu("SlideEnter", 10, 11);
      DCs = new bu("Commerce", 11, 12);
      DCt = new bu("QuitRoom", 12, 13);
      DCu = new bu("Auth", 13, 14);
      DCv = new bu("EXPLORE_SCREEN_SWITCH_BTN", 14, 15);
      DCw = new bu("SWITCH_SCREEN", 15, 16);
      DCx = new bu("REPLY", 16, 17);
      DCy = new bu("LOTTERY", 17, 18);
      DCz = new bu("GIFT", 18, 19);
      DCA = new bu("LINKMIC", 19, 20);
      DCB = new bu("NEARBY_LIVE_MORE", 20, 21);
      DCC = new bu("FOLLOW_LIVE", 21, 22);
      DCD = new bu("CLICK_LINKMIC_ANCHOR_AVATAR_TO_LIVING_ROOM", 22, 23);
      DCE = new bu("RED_PACKET", 23, 24);
      DCF = new bu("GAME_TEAM", 24, 25);
      DCG = new bu("CAST_SCREEN", 25, 26);
      DCH = new bu("VISITOR_MUSIC", 26, 27);
      DCI = new bu("ANCHOR_PAUSE_LIVE", 27, 28);
      DCJ = new bu("JUMP_TO_OFFICIAL_ACCOUNT", 28, 29);
      DCK = new bu("OPEN_HANDOFF", 29, 30);
      DCL = new bu("JUMP_GAME", 30, 31);
      DCM = new bu("COMMENT_OPTION", 31, 32);
      DCN = new bu("PROMOTE_BANNER", 32, 33);
      DCO = new bu("PROFILE_HALF_SCREEN", 33, 34);
      DCP = new bu("MODIFY_VIDEO_DEFINITION", 34, 35);
      DCQ = new bu("FANS_CLUB", 35, 36);
      DCR = new bu("LIVE_DESC", 36, 37);
      DCS = new bu("GIFT_ALLOWANCE", 37, 38);
      DCT = new bu("BIZ_NAME", 38, 39);
      DCU = new bu("GAME_WELFARE", 39, 46);
      DCV = new bu("BIZ_HEAD", 40, 40);
      DCW = new bu("SCROLL_GUIDE", 41, 45);
      DCX = new bu("SIDE_BAR", 42, 47);
      DCY = new bu("ASSISTANT_LOTTERY", 43, 53);
      DCZ = new bu("ASSISTANT_SHOP", 44, 54);
      DDa = new bu("ASSISTANT_MORE", 45, 55);
      DDb = new bu("VR_MODE", 46, 41);
      DDc = new bu("PROMOTE_VISITOR", 47, 42);
      DDd = new bu("OUTER_FLOAT_MODE", 48, 60);
      DDe = new bu("INNER_FLOAT_MODE", 49, 61);
      DDf = new bu("GAME_RANK", 50, 62);
      DDg = new bu("CHARGE_LIVE", 51, 66);
      akfs = new bu("BOX_LIVE", 52, 67);
      DDj = new bu("PREVIEW_LIVE", 53, 998);
      DDk = new bu("EXIT_BEFORE_JOIN_RESP", 54, 999);
      DDl = new bu("PLUS_BTN_CLICK", 55, 1000);
      DDm = new bu("AT_BTN_EXPOSE", 56, 1001);
      DDn = new bu("AT_WX_SOMEONE", 57, 1002);
      DDo = new bu("SOMEONE_AT_ME_CLICK", 58, 1003);
      DDp = new bu("AT_BTN_CLICK", 59, 1004);
      DDq = new bu("SEND_LOCATION_BTN_CLICK", 60, 1005);
      DDr = new bu("GET_CITY_INFO_FAIL", 61, 1006);
      DDs = new bu[] { DCh, DCi, DCj, DCk, DCl, DCm, DCn, DCo, DCp, DCq, DCr, DCs, DCt, DCu, DCv, DCw, DCx, DCy, DCz, DCA, DCB, DCC, DCD, DCE, DCF, DCG, DCH, DCI, DCJ, DCK, DCL, DCM, DCN, DCO, DCP, DCQ, DCR, DCS, DCT, DCU, DCV, DCW, DCX, DCY, DCZ, DDa, DDb, DDc, DDd, DDe, DDf, DDg, akfs, DDj, DDk, DDl, DDm, DDn, DDo, DDp, DDq, DDr };
      AppMethodBeat.o(351888);
    }
    
    private bu(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorAuthAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "AuthExposure", "AuthEnter", "AuthSucc", "AuthFail", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bv
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351873);
      DDt = new bv("AuthExposure", 0, 1);
      DDu = new bv("AuthEnter", 1, 2);
      DDv = new bv("AuthSucc", 2, 3);
      DDw = new bv("AuthFail", 3, 4);
      DDx = new bv[] { DDt, DDu, DDv, DDw };
      AppMethodBeat.o(351873);
    }
    
    private bv(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCloseType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CloseTypeFloat", "CloseTypeFull", "CloseTypeKickedOut", "CloseTypeSlide", "CloseTypeOtherRoom", "CloseTypeLiveOver", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bw
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351914);
      DDy = new bw("CloseTypeFloat", 0, 1);
      DDz = new bw("CloseTypeFull", 1, 2);
      DDA = new bw("CloseTypeKickedOut", 2, 3);
      DDB = new bw("CloseTypeSlide", 3, 4);
      DDC = new bw("CloseTypeOtherRoom", 4, 5);
      DDD = new bw("CloseTypeLiveOver", 5, 6);
      DDE = new bw[] { DDy, DDz, DDA, DDB, DDC, DDD };
      AppMethodBeat.o(351914);
    }
    
    private bw(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCommerceAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CommerceActionBubbleTipShow", "CommerceActionBubbleTipClick", "CommerceActionShoppingButtonClick", "CommerceActionGoodsOrderButtonClick", "CommerceActionGoodsItemClick", "CommerceActionPurchaseButtonClick", "CommerceActionGoodsItemShow", "CommerceActionBubbleTipClose", "CommerceActionAnchorCloseBubble", "CommerceActionExitHalfPage", "CommerceActionPromotingVideo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bx
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351903);
      DDF = new bx("CommerceActionBubbleTipShow", 0, 1);
      DDG = new bx("CommerceActionBubbleTipClick", 1, 2);
      DDH = new bx("CommerceActionShoppingButtonClick", 2, 3);
      DDI = new bx("CommerceActionGoodsOrderButtonClick", 3, 4);
      DDJ = new bx("CommerceActionGoodsItemClick", 4, 5);
      DDK = new bx("CommerceActionPurchaseButtonClick", 5, 6);
      DDL = new bx("CommerceActionGoodsItemShow", 6, 7);
      DDM = new bx("CommerceActionBubbleTipClose", 7, 8);
      DDN = new bx("CommerceActionAnchorCloseBubble", 8, 9);
      DDO = new bx("CommerceActionExitHalfPage", 9, 10);
      DDP = new bx("CommerceActionPromotingVideo", 10, 12);
      DDQ = new bx[] { DDF, DDG, DDH, DDI, DDJ, DDK, DDL, DDM, DDN, DDO, DDP };
      AppMethodBeat.o(351903);
    }
    
    private bx(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorDescActionJsonKey;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "TYPE", "DOC", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum by
  {
    public final String key;
    
    static
    {
      AppMethodBeat.i(351889);
      DDR = new by("TYPE", 0, "type");
      DDS = new by("DOC", 1, "doc");
      DDT = new by[] { DDR, DDS };
      AppMethodBeat.o(351889);
    }
    
    private by(String paramString)
    {
      this.key = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorDescActionType;", "", "descAction", "", "(Ljava/lang/String;II)V", "getDescAction", "()I", "DESC_STICKY", "UNFOLD_BTN_SHOW", "UNFOLD_BTN_CLICK", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum bz
  {
    public final int Dsd;
    
    static
    {
      AppMethodBeat.i(351895);
      DDU = new bz("DESC_STICKY", 0, 1);
      DDV = new bz("UNFOLD_BTN_SHOW", 1, 2);
      DDW = new bz("UNFOLD_BTN_CLICK", 2, 3);
      DDX = new bz[] { DDU, DDV, DDW };
      AppMethodBeat.o(351895);
    }
    
    private bz(int paramInt)
    {
      this.Dsd = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorActionType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_ANCHOR_ACTION_BEGIN", "LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA", "LIVE_ANCHOR_ACTION_MINIMIZE", "LIVE_ANCHOR_ACTION_COMMENT", "LIVE_ANCHOR_ACTION_BARRAGE", "LIVE_ANCHOR_ACTION_SHARE", "LIVE_ANCHOR_ACTION_AUDIENCE", "LIVE_ANCHOR_ACTION_COMMERCE", "LIVE_ANCHOR_ACTION_OUT", "LIVE_ANCHOR_TOP_COMMENT", "LIVE_ANCHOR_TICKLE", "LIVE_ANCHOR_LOTTERY", "CLICK_FAIRY_STICK", "BEAUTY", "FILTER", "CLICK_MIRROR", "LINKMIC_SWITCH", "LINKMIC_OP", "GIFT_SWITCH", "SEE_GIFT_LIST", "CLICK_LINKMIC_ANCHOR_PROFILE", "LIVE_AUDIO_MODE", "ANCHOR_MUSIC", "ALERT_INFO", "ANCHOR_PAUSE_LIVE", "ANCHOR_BATTLE", "SCREEN_SHARE", "LIVE_BEAUTY", "LIVE_ANCHOR_ACTION_LIKE", "OPEN_HANDOFF", "COMMENT_OPTION", "NET_SPEED_LOW", "PROMOTE_BANNER", "PROFILE_HALF_SCREEN", "FANS_CLUB", "GIFT_ALLOWANCE", "ANCHOR_APPLAUD", "LIVE_DESC", "MODIFY_PAY_GAME_TEAM", "PROMOTE_ANCHOR", "ANCHOR_COMMENT", "GameLive_PLAY_GAME_SETTING", "PRODUCT_RECORD_ACTION", "PRODUCT_SET_RECOMMEND", "LIVE_ANCHOR_FAST_COMMENT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351748);
      Drg = new c("LIVE_ANCHOR_ACTION_BEGIN", 0, 1);
      Drh = new c("LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA", 1, 2);
      Dri = new c("LIVE_ANCHOR_ACTION_MINIMIZE", 2, 3);
      Drj = new c("LIVE_ANCHOR_ACTION_COMMENT", 3, 4);
      Drk = new c("LIVE_ANCHOR_ACTION_BARRAGE", 4, 5);
      Drl = new c("LIVE_ANCHOR_ACTION_SHARE", 5, 6);
      Drm = new c("LIVE_ANCHOR_ACTION_AUDIENCE", 6, 7);
      Drn = new c("LIVE_ANCHOR_ACTION_COMMERCE", 7, 8);
      Dro = new c("LIVE_ANCHOR_ACTION_OUT", 8, 9);
      Drp = new c("LIVE_ANCHOR_TOP_COMMENT", 9, 10);
      Drq = new c("LIVE_ANCHOR_TICKLE", 10, 11);
      Drr = new c("LIVE_ANCHOR_LOTTERY", 11, 12);
      Drs = new c("CLICK_FAIRY_STICK", 12, 13);
      Drt = new c("BEAUTY", 13, 14);
      Dru = new c("FILTER", 14, 15);
      Drv = new c("CLICK_MIRROR", 15, 16);
      Drw = new c("LINKMIC_SWITCH", 16, 17);
      Drx = new c("LINKMIC_OP", 17, 18);
      Dry = new c("GIFT_SWITCH", 18, 19);
      Drz = new c("SEE_GIFT_LIST", 19, 20);
      DrA = new c("CLICK_LINKMIC_ANCHOR_PROFILE", 20, 21);
      DrB = new c("LIVE_AUDIO_MODE", 21, 23);
      DrC = new c("ANCHOR_MUSIC", 22, 24);
      DrD = new c("ALERT_INFO", 23, 26);
      DrE = new c("ANCHOR_PAUSE_LIVE", 24, 27);
      DrF = new c("ANCHOR_BATTLE", 25, 28);
      DrG = new c("SCREEN_SHARE", 26, 29);
      DrH = new c("LIVE_BEAUTY", 27, 30);
      DrI = new c("LIVE_ANCHOR_ACTION_LIKE", 28, 31);
      DrJ = new c("OPEN_HANDOFF", 29, 32);
      DrK = new c("COMMENT_OPTION", 30, 33);
      DrL = new c("NET_SPEED_LOW", 31, 34);
      DrM = new c("PROMOTE_BANNER", 32, 35);
      DrN = new c("PROFILE_HALF_SCREEN", 33, 36);
      DrO = new c("FANS_CLUB", 34, 37);
      DrP = new c("GIFT_ALLOWANCE", 35, 40);
      DrQ = new c("ANCHOR_APPLAUD", 36, 38);
      DrR = new c("LIVE_DESC", 37, 39);
      DrS = new c("MODIFY_PAY_GAME_TEAM", 38, 41);
      DrT = new c("PROMOTE_ANCHOR", 39, 43);
      DrU = new c("ANCHOR_COMMENT", 40, 45);
      DrV = new c("GameLive_PLAY_GAME_SETTING", 41, 44);
      DrW = new c("PRODUCT_RECORD_ACTION", 42, 45);
      DrX = new c("PRODUCT_SET_RECOMMEND", 43, 47);
      DrY = new c("LIVE_ANCHOR_FAST_COMMENT", 44, 53);
      DrZ = new c[] { Drg, Drh, Dri, Drj, Drk, Drl, Drm, Drn, Dro, Drp, Drq, Drr, Drs, Drt, Dru, Drv, Drw, Drx, Dry, Drz, DrA, DrB, DrC, DrD, DrE, DrF, DrG, DrH, DrI, DrJ, DrK, DrL, DrM, DrN, DrO, DrP, DrQ, DrR, DrS, DrT, DrU, DrV, DrW, DrX, DrY };
      AppMethodBeat.o(351748);
    }
    
    private c(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_LIVE_DEFAULT", "CLICK_LIVE_CARD", "CLICK_LIVE_CARD_AVATAR_LIVING", "CLICK_CARD_AVATAR_LIVING", "CLICK_AVATAR_LIVING", "CLICK_SNSAD_ENTER_LIVE_ROOM", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ca
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351853);
      DDY = new ca("CLICK_LIVE_DEFAULT", 0, 0);
      DDZ = new ca("CLICK_LIVE_CARD", 1, 1);
      DEa = new ca("CLICK_LIVE_CARD_AVATAR_LIVING", 2, 2);
      DEb = new ca("CLICK_CARD_AVATAR_LIVING", 3, 3);
      DEc = new ca("CLICK_AVATAR_LIVING", 4, 4);
      DEd = new ca("CLICK_SNSAD_ENTER_LIVE_ROOM", 5, 5);
      DEe = new ca[] { DDY, DDZ, DEa, DEb, DEc, DEd };
      AppMethodBeat.o(351853);
    }
    
    private ca(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorFansClub;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "JOIN_EXPOSE", "JOIN_CLICK", "FOLLOW_JOIN_EXP", "FOLLOW_JOIN_CLICK", "JOIN_PANEL_EXP", "JOIN_PANEL_CLICK", "JOIN_GIFT_EXP", "JOIN_GIFT_CLICK", "HELP_CLICK", "FANS_ENTRANCE_CLICK", "FANS_CLUB_CLICK", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum cb
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351852);
      DEf = new cb("JOIN_EXPOSE", 0, 1);
      DEg = new cb("JOIN_CLICK", 1, 2);
      DEh = new cb("FOLLOW_JOIN_EXP", 2, 3);
      DEi = new cb("FOLLOW_JOIN_CLICK", 3, 4);
      DEj = new cb("JOIN_PANEL_EXP", 4, 5);
      DEk = new cb("JOIN_PANEL_CLICK", 5, 6);
      DEl = new cb("JOIN_GIFT_EXP", 6, 7);
      DEm = new cb("JOIN_GIFT_CLICK", 7, 8);
      DEn = new cb("HELP_CLICK", 8, 9);
      DEo = new cb("FANS_ENTRANCE_CLICK", 9, 10);
      DEp = new cb("FANS_CLUB_CLICK", 10, 11);
      DEq = new cb[] { DEf, DEg, DEh, DEi, DEj, DEk, DEl, DEm, DEn, DEo, DEp };
      AppMethodBeat.o(351852);
    }
    
    private cb(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorGift;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD", "CLICK_GIFT_BOARD_INNER_GITF", "SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND", "CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI", "SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE", "SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI", "GIFT_ICON_EXPOSURE", "CLICK_HOT_LIST_SEE_CUR_DOU_YOU", "RETURN_GIFT_BOARD_FROM_EXCHARGE_UI", "RETURN_LIVE_ROOM_FROM_GIFT_BOARD", "GIFT_BOARD_TURN_PAGE", "CLICK_VISITOR_IN_HOT_LIST", "CLICK_Y_IN_HOT_LIST", "CLICK_READ_BTN_HOT_LIST", "EXPOSE_HALF_BOARD_HOT_LIST", "CLICK_PROFILE_HOT_LIST", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum cc
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351847);
      DEr = new cc("CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD", 0, 1);
      DEs = new cc("CLICK_GIFT_BOARD_INNER_GITF", 1, 2);
      DEt = new cc("SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND", 2, 3);
      DEu = new cc("CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI", 3, 4);
      DEv = new cc("SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE", 4, 5);
      DEw = new cc("SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI", 5, 6);
      DEx = new cc("GIFT_ICON_EXPOSURE", 6, 7);
      DEy = new cc("CLICK_HOT_LIST_SEE_CUR_DOU_YOU", 7, 8);
      DEz = new cc("RETURN_GIFT_BOARD_FROM_EXCHARGE_UI", 8, 9);
      DEA = new cc("RETURN_LIVE_ROOM_FROM_GIFT_BOARD", 9, 10);
      DEB = new cc("GIFT_BOARD_TURN_PAGE", 10, 11);
      DEC = new cc("CLICK_VISITOR_IN_HOT_LIST", 11, 12);
      DED = new cc("CLICK_Y_IN_HOT_LIST", 12, 13);
      DEE = new cc("CLICK_READ_BTN_HOT_LIST", 13, 14);
      DEF = new cc("EXPOSE_HALF_BOARD_HOT_LIST", 14, 15);
      DEG = new cc("CLICK_PROFILE_HOT_LIST", 15, 18);
      DEH = new cc[] { DEr, DEs, DEt, DEu, DEv, DEw, DEx, DEy, DEz, DEA, DEB, DEC, DED, DEE, DEF, DEG };
      AppMethodBeat.o(351847);
    }
    
    private cc(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLinkMicAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "INVALIDATE", "APPLY_LINKMIC", "APPLY_AUDIO_LINKMIC", "APPLY_VIDEO_LINKMIC", "ANCHOR_PASS_LINKMIC_REQUEST", "TIMEOUT_NO_LINK_HUNG_UP", "POPUP_ANCHOR_LINKING_CONFLICT", "ACTIVE_STOP_AUDIO_LINKMIC", "ACTIVE_STOP_VIDEO_LINKMIC", "LINKMIC_ICON_EXPLORE", "CLICK_RED_PACKET", "LINKEMIC_RED_PACKET_SUCCESS", "FAIL_BY_REWARD_SETTING", "FAIL_BY_FOLLOW_SETTING", "FAIL_BY_BUY_PRODUCT_SETTING", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum cd
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351844);
      DEI = new cd("INVALIDATE", 0, 0);
      DEJ = new cd("APPLY_LINKMIC", 1, 1);
      DEK = new cd("APPLY_AUDIO_LINKMIC", 2, 2);
      DEL = new cd("APPLY_VIDEO_LINKMIC", 3, 3);
      DEM = new cd("ANCHOR_PASS_LINKMIC_REQUEST", 4, 4);
      DEN = new cd("TIMEOUT_NO_LINK_HUNG_UP", 5, 5);
      DEO = new cd("POPUP_ANCHOR_LINKING_CONFLICT", 6, 6);
      DEP = new cd("ACTIVE_STOP_AUDIO_LINKMIC", 7, 7);
      DEQ = new cd("ACTIVE_STOP_VIDEO_LINKMIC", 8, 8);
      DER = new cd("LINKMIC_ICON_EXPLORE", 9, 9);
      DES = new cd("CLICK_RED_PACKET", 10, 10);
      DET = new cd("LINKEMIC_RED_PACKET_SUCCESS", 11, 11);
      DEU = new cd("FAIL_BY_REWARD_SETTING", 12, 14);
      DEW = new cd("FAIL_BY_FOLLOW_SETTING", 13, 15);
      DEX = new cd("FAIL_BY_BUY_PRODUCT_SETTING", 14, 16);
      DEY = new cd[] { DEI, DEJ, DEK, DEL, DEM, DEN, DEO, DEP, DEQ, DER, DES, DET, DEU, DEW, DEX };
      AppMethodBeat.o(351844);
    }
    
    private cd(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLotteryAttendType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIKE", "COMMENT", "FOLLOW", "FAN", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ce
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351934);
      DEZ = new ce("LIKE", 0, 1);
      DFa = new ce("COMMENT", 1, 2);
      DFb = new ce("FOLLOW", 2, 3);
      DFc = new ce("FAN", 3, 4);
      DFd = new ce[] { DEZ, DFa, DFb, DFc };
      AppMethodBeat.o(351934);
    }
    
    private ce(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ExposeProfile", "Book", "Cancle", "ExposeMsg", "Click", "Replace", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum cg
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351933);
      DFr = new cg("ExposeProfile", 0, 1);
      DFs = new cg("Book", 1, 2);
      DFt = new cg("Cancle", 2, 3);
      DFu = new cg("ExposeMsg", 3, 4);
      DFv = new cg("Click", 4, 5);
      DFw = new cg("Replace", 5, 6);
      DFx = new cg[] { DFr, DFs, DFt, DFu, DFv, DFw };
      AppMethodBeat.o(351933);
    }
    
    private cg(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorShopBtnState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "NO_EXPOSURE", "EXPOSURE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ci
  {
    final int state;
    
    static
    {
      AppMethodBeat.i(351965);
      DFC = new ci("NO_EXPOSURE", 0, 0);
      DFD = new ci("EXPOSURE", 1, 1);
      DFE = new ci[] { DFC, DFD };
      AppMethodBeat.o(351965);
    }
    
    private ci(int paramInt)
    {
      this.state = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorWinResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "WIN", "NO_WIN", "NO_JOIN", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum cj
  {
    public final int result;
    
    static
    {
      AppMethodBeat.i(351945);
      DFF = new cj("WIN", 0, 1);
      DFG = new cj("NO_WIN", 1, 2);
      DFH = new cj("NO_JOIN", 2, 3);
      DFI = new cj[] { DFF, DFG, DFH };
      AppMethodBeat.o(351945);
    }
    
    private cj(int paramInt)
    {
      this.result = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VrModeAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "VR_MODE_ICON_EXPOSE", "VR_MODE_ICON_CLICK", "VR_BUBBLE_TIP_EXPOSE", "VR_BUBBLE_TIP_CLOSE", "VR_MODE_ENTER", "VR_MODE_TOUCH", "VR_GUIDE_EXPOSE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ck
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351967);
      DFJ = new ck("VR_MODE_ICON_EXPOSE", 0, 1);
      DFK = new ck("VR_MODE_ICON_CLICK", 1, 2);
      DFL = new ck("VR_BUBBLE_TIP_EXPOSE", 2, 3);
      DFM = new ck("VR_BUBBLE_TIP_CLOSE", 3, 4);
      DFN = new ck("VR_MODE_ENTER", 4, 5);
      DFO = new ck("VR_MODE_TOUCH", 5, 6);
      DFP = new ck("VR_GUIDE_EXPOSE", 6, 7);
      DFQ = new ck[] { DFJ, DFK, DFL, DFM, DFN, DFO, DFP };
      AppMethodBeat.o(351967);
    }
    
    private ck(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorDescActionJsonKey;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "TYPE", "DOC", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    public final String key;
    
    static
    {
      AppMethodBeat.i(351713);
      Dsa = new d("TYPE", 0, "type");
      Dsb = new d("DOC", 1, "doc");
      Dsc = new d[] { Dsa, Dsb };
      AppMethodBeat.o(351713);
    }
    
    private d(String paramString)
    {
      this.key = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorDescActionType;", "", "descAction", "", "(Ljava/lang/String;II)V", "getDescAction", "()I", "EDIT_MENU_SHOW", "EDIT_MENU_CLICK", "EDIT_DONE", "TOP_COMMENT_MENU_SHOW", "TOP_COMMENT_MENU_CLICK", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum e
  {
    public final int Dsd;
    
    static
    {
      AppMethodBeat.i(351570);
      Dse = new e("EDIT_MENU_SHOW", 0, 1);
      Dsf = new e("EDIT_MENU_CLICK", 1, 2);
      Dsg = new e("EDIT_DONE", 2, 3);
      Dsh = new e("TOP_COMMENT_MENU_SHOW", 3, 4);
      Dsi = new e("TOP_COMMENT_MENU_CLICK", 4, 5);
      Dsj = new e[] { Dse, Dsf, Dsg, Dsh, Dsi };
      AppMethodBeat.o(351570);
    }
    
    private e(int paramInt)
    {
      this.Dsd = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorFloatAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_ENTER_LOTTERY_RECORD", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum f
  {
    public final int action = 6;
    
    static
    {
      AppMethodBeat.i(351560);
      Dsk = new f("CLICK_ENTER_LOTTERY_RECORD");
      Dsl = new f[] { Dsk };
      AppMethodBeat.o(351560);
    }
    
    private f() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorLiveClose;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ENTER_LIVE_CLOSE_UI", "SEE_GIFT_LIST", "CLICK_FINISH", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum g
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351578);
      Dsm = new g("ENTER_LIVE_CLOSE_UI", 0, 1);
      Dsn = new g("SEE_GIFT_LIST", 1, 2);
      Dso = new g("CLICK_FINISH", 2, 3);
      Dsp = new g[] { Dsm, Dsn, Dso };
      AppMethodBeat.o(351578);
    }
    
    private g(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorLotteryType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "setType", "(I)V", "CLICK_LOTTERY_ICON", "CLICK_JOIN_CONDITION", "CLICK_ANY_COMMENT", "CLICK_SPECIFY_COMMENT_CONTENT", "CLICK_LIKE", "WRITE_SPECIFY_COMMENT_CONTENT_SUCC", "START_LOTTERY_SUCCESS", "CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT", "CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI", "CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI", "CLICK_LUCKY_BAG", "CANCEL_LOTTERY", "CLICK_FANS_MEMBER", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum h
  {
    int type;
    
    static
    {
      AppMethodBeat.i(351580);
      Dsq = new h("CLICK_LOTTERY_ICON", 0, 1);
      Dsr = new h("CLICK_JOIN_CONDITION", 1, 2);
      Dss = new h("CLICK_ANY_COMMENT", 2, 3);
      Dst = new h("CLICK_SPECIFY_COMMENT_CONTENT", 3, 4);
      Dsu = new h("CLICK_LIKE", 4, 5);
      Dsv = new h("WRITE_SPECIFY_COMMENT_CONTENT_SUCC", 5, 6);
      Dsw = new h("START_LOTTERY_SUCCESS", 6, 7);
      Dsx = new h("CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT", 7, 8);
      Dsy = new h("CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI", 8, 9);
      Dsz = new h("CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI", 9, 10);
      DsA = new h("CLICK_LUCKY_BAG", 10, 11);
      DsB = new h("CANCEL_LOTTERY", 11, 12);
      DsC = new h("CLICK_FANS_MEMBER", 12, 13);
      DsD = new h[] { Dsq, Dsr, Dss, Dst, Dsu, Dsv, Dsw, Dsx, Dsy, Dsz, DsA, DsB, DsC };
      AppMethodBeat.o(351580);
    }
    
    private h(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BattleActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "BATTLE_ACTION_PK_EXPOSE", "BATTLE_ACTION_PK_CLICK", "BATTLE_ACTION_PK_ACCEPT_FROM_TIP", "BATTLE_ACTION_PK_ACCEPT_FROM_PANEL", "BATTLE_ACTION_PK_CANCEL", "BATTLE_ACTION_PK_CANCEL_BY_TIMEOUT", "BATTLE_ACTION_PK_END_RESULT", "BATTLE_ACTION_PK_END_MIC_BREAK", "BATTLE_ACTION_PK_END_LIVE_CLOSE", "BATTLE_ACTION_PK_APPLY_FAIL_BY_VERSION", "BATTLE_ACTION_RANDOM_MATCH_EXPOSE", "BATTLE_ACTION_RANDOM_MATCH_CLICK", "BATTLE_ACTION_RANDOM_MATCH_SUCCESS", "BATTLE_ACTION_RANDOM_MATCH_CANCEL", "BATTLE_ACTION_RANDOM_MATCH_TIMEOUT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum i
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(351557);
      DsE = new i("BATTLE_ACTION_PK_EXPOSE", 0, 1);
      DsF = new i("BATTLE_ACTION_PK_CLICK", 1, 2);
      DsG = new i("BATTLE_ACTION_PK_ACCEPT_FROM_TIP", 2, 3);
      DsH = new i("BATTLE_ACTION_PK_ACCEPT_FROM_PANEL", 3, 4);
      DsI = new i("BATTLE_ACTION_PK_CANCEL", 4, 5);
      DsJ = new i("BATTLE_ACTION_PK_CANCEL_BY_TIMEOUT", 5, 6);
      DsK = new i("BATTLE_ACTION_PK_END_RESULT", 6, 7);
      DsL = new i("BATTLE_ACTION_PK_END_MIC_BREAK", 7, 8);
      DsM = new i("BATTLE_ACTION_PK_END_LIVE_CLOSE", 8, 9);
      DsN = new i("BATTLE_ACTION_PK_APPLY_FAIL_BY_VERSION", 9, 10);
      DsO = new i("BATTLE_ACTION_RANDOM_MATCH_EXPOSE", 10, 11);
      DsP = new i("BATTLE_ACTION_RANDOM_MATCH_CLICK", 11, 12);
      DsQ = new i("BATTLE_ACTION_RANDOM_MATCH_SUCCESS", 12, 13);
      DsR = new i("BATTLE_ACTION_RANDOM_MATCH_CANCEL", 13, 14);
      DsS = new i("BATTLE_ACTION_RANDOM_MATCH_TIMEOUT", 14, 15);
      DsT = new i[] { DsE, DsF, DsG, DsH, DsI, DsJ, DsK, DsL, DsM, DsN, DsO, DsP, DsQ, DsR, DsS };
      AppMethodBeat.o(351557);
    }
    
    private i(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CastScreenResult;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CAST_SCREEN_EXPOSE", "CAST_SCREEN_CLICK_MENU", "CAST_SCREEN_DEVICE_EXPOSE", "CAST_SCREEN_CLICK_DEVICE", "CAST_SCREEN_SUCCESS", "CAST_SCREEN_BREAK", "CAST_SCREEN_TIMEOUT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum k
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351534);
      DsX = new k("CAST_SCREEN_EXPOSE", 0, 1);
      DsY = new k("CAST_SCREEN_CLICK_MENU", 1, 2);
      DsZ = new k("CAST_SCREEN_DEVICE_EXPOSE", 2, 3);
      Dta = new k("CAST_SCREEN_CLICK_DEVICE", 3, 4);
      Dtb = new k("CAST_SCREEN_SUCCESS", 4, 5);
      Dtc = new k("CAST_SCREEN_BREAK", 5, 6);
      Dtd = new k("CAST_SCREEN_TIMEOUT", 6, 7);
      Dte = new k[] { DsX, DsY, DsZ, Dta, Dtb, Dtc, Dtd };
      AppMethodBeat.o(351534);
    }
    
    private k(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ClearScreenAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_CLEAR_SCREEN", "CLICK_CLEAR_SCREEN_CANCEL", "CLICK_CLEAR_SCREEN_MENU", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum l
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351592);
      Dtf = new l("CLICK_CLEAR_SCREEN", 0, 1);
      Dtg = new l("CLICK_CLEAR_SCREEN_CANCEL", 1, 2);
      Dth = new l("CLICK_CLEAR_SCREEN_MENU", 2, 3);
      Dti = new l[] { Dtf, Dtg, Dth };
      AppMethodBeat.o(351592);
    }
    
    private l(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CloseUISeeGiftList;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "UNDEFINE", "ENTER_UI", "CLICK_FETCH_INCOME", "RETRUN_LIVE_CLOSE_UI", "CLICK_LIST_ITEM_USER", "EXPOSE_USER_FINDER_HALF_BOARD", "CLICK_PRIVATE_MSG_USER", "CLICK_FOLLOW_USER", "CLICK_ENTER_USER_PROFILE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum m
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351555);
      Dtj = new m("UNDEFINE", 0, -1);
      Dtk = new m("ENTER_UI", 1, 1);
      Dtl = new m("CLICK_FETCH_INCOME", 2, 2);
      Dtm = new m("RETRUN_LIVE_CLOSE_UI", 3, 3);
      Dtn = new m("CLICK_LIST_ITEM_USER", 4, 4);
      Dto = new m("EXPOSE_USER_FINDER_HALF_BOARD", 5, 5);
      Dtp = new m("CLICK_PRIVATE_MSG_USER", 6, 6);
      Dtq = new m("CLICK_FOLLOW_USER", 7, 7);
      Dtr = new m("CLICK_ENTER_USER_PROFILE", 8, 8);
      Dts = new m[] { Dtj, Dtk, Dtl, Dtm, Dtn, Dto, Dtp, Dtq, Dtr };
      AppMethodBeat.o(351555);
    }
    
    private m(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CommentSceneExtend;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW", "COMMENT_SCENE_LIVE_ROOM_SLIDE", "COMMENT_SCENE_SEARCH_MORE_CONTACT", "COMMENT_SCENE_SEARCH_RESULT_FLOW", "COMMENT_SCENE_PROFILE_PAGE", "COMMENT_SCENE_SHARE_PAGE", "COMMENT_SCENE_BOOK_NOTIFY", "COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW", "COMMENT_SCENE_LBS_TOP_LIVE_CARD", "COMMENT_SCENE_SEARCH_1_SEARCH", "COMMENT_SCENE_PUBLIC_NUMBER", "COMMENT_SCENE_APPBRAN", "COMMENT_SCENE_SEE_1_SEE", "COMMENT_SCENE_PULLDOWN_MENU", "COMMENT_SCENE_SLEF_STATUS", "COMMENT_SCENE_RED_PACKET_MSG_IN_GOUR_CHAT", "COMMENT_SCENE_NEARBY_LIVE_REDDOT", "COMMENT_SCENE_DAILY_TIP", "COMMENT_SCENE_LIVE_END_PAGE", "COMMENT_SCENE_LIVE_LOCAL_VIDEO", "COMMENT_SCENE_SIDE_BAR", "COMMENT_SCENE_OLYMPICS_STATUS", "COMMENT_SCENE_OLYMPICS_SPORT", "COMMENT_SCENE_OLYMPICS_PROFILE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum n
  {
    public final String scene;
    
    static
    {
      AppMethodBeat.i(351535);
      Dtt = new n("COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW", 0, "temp_1");
      Dtu = new n("COMMENT_SCENE_LIVE_ROOM_SLIDE", 1, "temp_2");
      Dtv = new n("COMMENT_SCENE_SEARCH_MORE_CONTACT", 2, "temp_3");
      Dtw = new n("COMMENT_SCENE_SEARCH_RESULT_FLOW", 3, "temp_4");
      Dtx = new n("COMMENT_SCENE_PROFILE_PAGE", 4, "temp_5");
      Dty = new n("COMMENT_SCENE_SHARE_PAGE", 5, "temp_6");
      Dtz = new n("COMMENT_SCENE_BOOK_NOTIFY", 6, "temp_7");
      DtA = new n("COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW", 7, "temp_9");
      DtB = new n("COMMENT_SCENE_LBS_TOP_LIVE_CARD", 8, "temp_10");
      DtC = new n("COMMENT_SCENE_SEARCH_1_SEARCH", 9, "temp_11");
      DtD = new n("COMMENT_SCENE_PUBLIC_NUMBER", 10, "temp_12");
      DtE = new n("COMMENT_SCENE_APPBRAN", 11, "temp_13");
      DtF = new n("COMMENT_SCENE_SEE_1_SEE", 12, "temp_14");
      DtG = new n("COMMENT_SCENE_PULLDOWN_MENU", 13, "temp_15");
      DtH = new n("COMMENT_SCENE_SLEF_STATUS", 14, "temp_16");
      DtI = new n("COMMENT_SCENE_RED_PACKET_MSG_IN_GOUR_CHAT", 15, "temp_17");
      DtJ = new n("COMMENT_SCENE_NEARBY_LIVE_REDDOT", 16, "temp_18");
      DtK = new n("COMMENT_SCENE_DAILY_TIP", 17, "temp_20");
      DtL = new n("COMMENT_SCENE_LIVE_END_PAGE", 18, "temp_30");
      DtM = new n("COMMENT_SCENE_LIVE_LOCAL_VIDEO", 19, "temp_32");
      DtN = new n("COMMENT_SCENE_SIDE_BAR", 20, "temp_33");
      DtO = new n("COMMENT_SCENE_OLYMPICS_STATUS", 21, "temp_997");
      DtP = new n("COMMENT_SCENE_OLYMPICS_SPORT", 22, "temp_998");
      DtQ = new n("COMMENT_SCENE_OLYMPICS_PROFILE", 23, "temp_999");
      DtR = new n[] { Dtt, Dtu, Dtv, Dtw, Dtx, Dty, Dtz, DtA, DtB, DtC, DtD, DtE, DtF, DtG, DtH, DtI, DtJ, DtK, DtL, DtM, DtN, DtO, DtP, DtQ };
      AppMethodBeat.o(351535);
    }
    
    private n(String paramString)
    {
      this.scene = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ComplaintVisitorSource;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "COMMENT_ZONE", "HOT_LIST", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum o
  {
    public final int source;
    
    static
    {
      AppMethodBeat.i(351522);
      DtS = new o("COMMENT_ZONE", 0, 1);
      DtT = new o("HOT_LIST", 1, 2);
      DtU = new o[] { DtS, DtT };
      AppMethodBeat.o(351522);
    }
    
    private o(int paramInt)
    {
      this.source = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CoverType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_COVER_ALBUM_CANCEL", "LIVE_COVER_SHOOT_FRONT_TAKEN", "LIVE_COVER_SHOOT_BACK_TAKEN", "LIVE_COVER_ALBUM_TAKEN", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum p
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(351532);
      DtV = new p("LIVE_COVER_ALBUM_CANCEL", 0, 5);
      DtW = new p("LIVE_COVER_SHOOT_FRONT_TAKEN", 1, 6);
      DtX = new p("LIVE_COVER_SHOOT_BACK_TAKEN", 2, 7);
      DtY = new p("LIVE_COVER_ALBUM_TAKEN", 3, 8);
      DtZ = new p[] { DtV, DtW, DtX, DtY };
      AppMethodBeat.o(351532);
    }
    
    private p(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EldUdfKVAnchorStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "BEFORE", "LIVING", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum r
  {
    final int status;
    
    static
    {
      AppMethodBeat.i(351509);
      Due = new r("BEFORE", 0, 1);
      Duf = new r("LIVING", 1, 2);
      Dug = new r[] { Due, Duf };
      AppMethodBeat.o(351509);
    }
    
    private r(int paramInt)
    {
      this.status = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementExposeId;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "MORE", "FOLLOW_ICON", "FOLLOW_GUIDE_PAGE", "FOLLOW_GUIDE_LEAVE_ICON", "FOLLOW_GUIDE_LEAVE_FOLLOW", "SEND_TO_FRIEND", "SEND_TO_MOMENT", "SET_AS_MY_STATUS", "MINIMIZE", "RECENTLY_FORWARD", "SHARE_SEND_RECENT", "MINIMIZE_LIVE", "LIVE_PLAY_SETTING", "LIVE_PLAY_SETTING_SWITCH", "MOMENT_POST", "SELECT_CHAT_BAR", "FLOATING_BUTTON", "ROTATING_BUTTON", "SHARE_SEND", "LIVE_GIFT", "LIVE_CALL", "LIVE_ENTER_BIZ", "MUTE_OPEN", "MUTE_CLOSE", "PAUSE_OPEN", "PAUSE_CLOSE", "COMMENT_OPEN", "COMMENT_CLOSE", "WHEAT_OPEN", "WHEAT_CLOSE", "GIFT_OPEN", "GIFT_CLOSE", "LIKE_OPEN", "LIKE_CLOSE", "ANNOUNCEMENT", "QUICK_REPLY_BUTTON", "QUICK_REPLY", "FAN_GROUP", "SHOP", "WHEAT", "MUSIC", "LUCKDRAW", "REDPACKET", "LOTTERY", "FRAME", "BEAUTY", "FILTER", "IMAGE", "FLIP", "HIDE_AUDIENCE_NICKNAME", "SHOW_AUDIENCE_NICKNAME", "SWITCH", "MOREFUNCTION", "DOCUMENT", "TIMELINE_BTN_SHOW", "SIDEBAR_BANNER", "SIDEBAR_CARD", "LIVE_PAGE_BANNER", "WO_WECHAT_SPORTS_WARRANT", "WO_WECHAT_SPORTS_TAB", "WO_BANNER", "WO_SHARE_BANNER", "WO_SHARE_SET_STATUS", "WO_RELAY_BANNER", "WO_SHARE_BANNER_CHANNEL", "GROUP_CHAT_BUTTON", "BOX_SWITCH", "LIVE_ELASTIC_LAYER", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum t
  {
    public final String id;
    
    static
    {
      AppMethodBeat.i(351545);
      Dvq = new t("MORE", 0, "more");
      Dvr = new t("FOLLOW_ICON", 1, "follow_icon");
      Dvs = new t("FOLLOW_GUIDE_PAGE", 2, "follow_guide_page");
      Dvt = new t("FOLLOW_GUIDE_LEAVE_ICON", 3, "follow_guide_leave_icon");
      Dvu = new t("FOLLOW_GUIDE_LEAVE_FOLLOW", 4, "follow_guide_leave_follow");
      Dvv = new t("SEND_TO_FRIEND", 5, "send_to_friend");
      Dvw = new t("SEND_TO_MOMENT", 6, "share_to_moment");
      Dvx = new t("SET_AS_MY_STATUS", 7, "set_as_my_status");
      Dvy = new t("MINIMIZE", 8, "minimize");
      Dvz = new t("RECENTLY_FORWARD", 9, "recently_forward");
      DvA = new t("SHARE_SEND_RECENT", 10, "share_send_recent");
      DvB = new t("MINIMIZE_LIVE", 11, "minimize_button");
      DvC = new t("LIVE_PLAY_SETTING", 12, "pic_set_button");
      DvD = new t("LIVE_PLAY_SETTING_SWITCH", 13, "pic_set_button_switch");
      DvE = new t("MOMENT_POST", 14, "moment_post");
      DvF = new t("SELECT_CHAT_BAR", 15, "select_chat_bar");
      DvG = new t("FLOATING_BUTTON", 16, "floating_button");
      DvH = new t("ROTATING_BUTTON", 17, "rotating_button");
      DvI = new t("SHARE_SEND", 18, "share_send");
      DvJ = new t("LIVE_GIFT", 19, "live_gift");
      DvK = new t("LIVE_CALL", 20, "live_call");
      DvL = new t("LIVE_ENTER_BIZ", 21, "live_enter_mmbiz");
      DvM = new t("MUTE_OPEN", 22, "mute_open");
      DvN = new t("MUTE_CLOSE", 23, "mute_close");
      DvO = new t("PAUSE_OPEN", 24, "pause_open");
      DvP = new t("PAUSE_CLOSE", 25, "pause_close");
      DvQ = new t("COMMENT_OPEN", 26, "comment_open");
      DvR = new t("COMMENT_CLOSE", 27, "comment_close");
      DvS = new t("WHEAT_OPEN", 28, "wheat_open");
      DvT = new t("WHEAT_CLOSE", 29, "wheat_close");
      DvU = new t("GIFT_OPEN", 30, "gift_open");
      DvV = new t("GIFT_CLOSE", 31, "gift_close");
      DvW = new t("LIKE_OPEN", 32, "like_open");
      DvX = new t("LIKE_CLOSE", 33, "like_close");
      DvY = new t("ANNOUNCEMENT", 34, "announcement");
      DvZ = new t("QUICK_REPLY_BUTTON", 35, "quick_reply_button");
      Dwa = new t("QUICK_REPLY", 36, "quick_reply");
      Dwb = new t("FAN_GROUP", 37, "fan_group");
      Dwc = new t("SHOP", 38, "shop");
      Dwd = new t("WHEAT", 39, "wheat");
      Dwe = new t("MUSIC", 40, "music");
      Dwf = new t("LUCKDRAW", 41, "luckdraw");
      Dwg = new t("REDPACKET", 42, "redpacket");
      Dwh = new t("LOTTERY", 43, "lottery");
      Dwi = new t("FRAME", 44, "frame");
      Dwj = new t("BEAUTY", 45, "beauty");
      Dwk = new t("FILTER", 46, "filter");
      Dwl = new t("IMAGE", 47, "image");
      Dwm = new t("FLIP", 48, "flip");
      Dwn = new t("HIDE_AUDIENCE_NICKNAME", 49, "hide_audience_nickname");
      Dwo = new t("SHOW_AUDIENCE_NICKNAME", 50, "show_audience_nickname");
      Dwp = new t("SWITCH", 51, "switch");
      Dwq = new t("MOREFUNCTION", 52, "morefunction");
      Dwr = new t("DOCUMENT", 53, "document");
      Dws = new t("TIMELINE_BTN_SHOW", 54, "timeline_button_show");
      Dwt = new t("SIDEBAR_BANNER", 55, "active_banner_icon");
      Dwu = new t("SIDEBAR_CARD", 56, "active_card_list");
      Dwv = new t("LIVE_PAGE_BANNER", 57, "live_page_banner");
      Dww = new t("WO_WECHAT_SPORTS_WARRANT", 58, "wo_wechat_sports_warrant");
      Dwx = new t("WO_WECHAT_SPORTS_TAB", 59, "wo_wechat_sports_tab");
      Dwy = new t("WO_BANNER", 60, "wo_banner");
      Dwz = new t("WO_SHARE_BANNER", 61, "wo_share_banner");
      DwA = new t("WO_SHARE_SET_STATUS", 62, "wo_share_set_status");
      DwB = new t("WO_RELAY_BANNER", 63, "wo_relay_banner");
      DwC = new t("WO_SHARE_BANNER_CHANNEL", 64, "wo_share_banner_channel");
      akfo = new t("GROUP_CHAT_BUTTON", 65, "group_chat_button");
      akfp = new t("BOX_SWITCH", 66, "box_switch");
      akfq = new t("LIVE_ELASTIC_LAYER", 67, "live_elastic_layer");
      DwD = new t[] { Dvq, Dvr, Dvs, Dvt, Dvu, Dvv, Dvw, Dvx, Dvy, Dvz, DvA, DvB, DvC, DvD, DvE, DvF, DvG, DvH, DvI, DvJ, DvK, DvL, DvM, DvN, DvO, DvP, DvQ, DvR, DvS, DvT, DvU, DvV, DvW, DvX, DvY, DvZ, Dwa, Dwb, Dwc, Dwd, Dwe, Dwf, Dwg, Dwh, Dwi, Dwj, Dwk, Dwl, Dwm, Dwn, Dwo, Dwp, Dwq, Dwr, Dws, Dwt, Dwu, Dwv, Dww, Dwx, Dwy, Dwz, DwA, DwB, DwC, akfo, akfp, akfq };
      AppMethodBeat.o(351545);
    }
    
    private t(String paramString)
    {
      this.id = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EnterRoomStatus;", "", "status", "", "(Ljava/lang/String;IJ)V", "getStatus", "()J", "LIVE_LIVING", "LIVE_STOPPED", "LIVE_IN_BLACK_LIST", "LIVE_NO_ACCESS_PERMISSION", "LIVE_OVERLOAD", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum u
  {
    public final long status;
    
    static
    {
      AppMethodBeat.i(351517);
      DwE = new u("LIVE_LIVING", 0, 1L);
      DwF = new u("LIVE_STOPPED", 1, 2L);
      DwG = new u("LIVE_IN_BLACK_LIST", 2, 5L);
      DwH = new u("LIVE_NO_ACCESS_PERMISSION", 3, 6L);
      akfr = new u("LIVE_OVERLOAD", 4, 7L);
      DwI = new u[] { DwE, DwF, DwG, DwH, akfr };
      AppMethodBeat.o(351517);
    }
    
    private u(long paramLong)
    {
      this.status = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "LIVE_EXIT_OK", "LIVE_EXIT_ERROR", "LIVE_EXIT_CANCEL_TIMER", "LIVE_EXIT_NOTHING", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum v
  {
    final long beV;
    
    static
    {
      AppMethodBeat.i(351646);
      DwJ = new v("LIVE_EXIT_OK", 0, 1L);
      DwK = new v("LIVE_EXIT_ERROR", 1, 2L);
      DwL = new v("LIVE_EXIT_CANCEL_TIMER", 2, 3L);
      DwM = new v("LIVE_EXIT_NOTHING", 3, 4L);
      DwN = new v[] { DwJ, DwK, DwL, DwM };
      AppMethodBeat.o(351646);
    }
    
    private v(long paramLong)
    {
      this.beV = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR", "LIVE_AUDIENCE_EXPLORE_FEED_CARD", "LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR", "LIVE_AUDIENCE_CLICK_SINGLE_AVATAR", "LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR", "LIVE_AUDIENCE_ENTER_LIVE_ROOM", "LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL", "LIVE_AUDIENCE_CLICK_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING", "CLICK_ENTER_LINKMIC_ANCHOR_PROFILE", "LIVE_EXPOSE_MORE_LIVE", "LIVE_CLICK_MORE_LIVE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum w
  {
    public final long beV;
    
    static
    {
      AppMethodBeat.i(351642);
      DwO = new w("LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR", 0, 1L);
      DwP = new w("LIVE_AUDIENCE_EXPLORE_FEED_CARD", 1, 2L);
      DwQ = new w("LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR", 2, 3L);
      DwR = new w("LIVE_AUDIENCE_CLICK_SINGLE_AVATAR", 3, 4L);
      DwS = new w("LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING", 4, 5L);
      DwT = new w("LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR", 5, 6L);
      DwU = new w("LIVE_AUDIENCE_ENTER_LIVE_ROOM", 6, 7L);
      DwV = new w("LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL", 7, 8L);
      DwW = new w("LIVE_AUDIENCE_CLICK_AVATAR_LIVING", 8, 9L);
      DwX = new w("LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING", 9, 10L);
      DwY = new w("LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING", 10, 11L);
      DwZ = new w("CLICK_ENTER_LINKMIC_ANCHOR_PROFILE", 11, 23L);
      Dxa = new w("LIVE_EXPOSE_MORE_LIVE", 12, 12L);
      Dxb = new w("LIVE_CLICK_MORE_LIVE", 13, 13L);
      Dxc = new w[] { DwO, DwP, DwQ, DwR, DwS, DwT, DwU, DwV, DwW, DwX, DwY, DwZ, Dxa, Dxb };
      AppMethodBeat.o(351642);
    }
    
    private w(long paramLong)
    {
      this.beV = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FilterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ORIGINAL_FILM", "DEFAULT", "BAIXI", "HUAIJIU", "QIURI", "MEISHI", "FANCHALENG", "JIAOJUAN", "GANGFENG", "YUANQI", "FENNEN", "QINGCHE", "LUORI", "SHENSUI", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum x
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(351663);
      Dxd = new x("ORIGINAL_FILM", 0, 1);
      Dxe = new x("DEFAULT", 1, 2);
      Dxf = new x("BAIXI", 2, 3);
      Dxg = new x("HUAIJIU", 3, 4);
      Dxh = new x("QIURI", 4, 5);
      Dxi = new x("MEISHI", 5, 6);
      Dxj = new x("FANCHALENG", 6, 7);
      Dxk = new x("JIAOJUAN", 7, 8);
      Dxl = new x("GANGFENG", 8, 9);
      Dxm = new x("YUANQI", 9, 10);
      Dxn = new x("FENNEN", 10, 11);
      Dxo = new x("QINGCHE", 11, 12);
      Dxp = new x("LUORI", 12, 13);
      Dxq = new x("SHENSUI", 13, 14);
      Dxr = new x[] { Dxd, Dxe, Dxf, Dxg, Dxh, Dxi, Dxj, Dxk, Dxl, Dxm, Dxn, Dxo, Dxp, Dxq };
      AppMethodBeat.o(351663);
    }
    
    private x(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FinderAudienceHistoryLiveActionLogAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "AppendToHistory", "ExposureEmpty", "InHistory", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum y
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(351650);
      Dxs = new y("AppendToHistory", 0, 1);
      Dxt = new y("ExposureEmpty", 1, 2);
      Dxu = new y("InHistory", 2, 3);
      Dxv = new y[] { Dxs, Dxt, Dxu };
      AppMethodBeat.o(351650);
    }
    
    private y(int paramInt)
    {
      this.action = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q
 * JD-Core Version:    0.7.0.1
 */