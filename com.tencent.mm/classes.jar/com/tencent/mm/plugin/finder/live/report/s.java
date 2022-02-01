package com.tencent.mm.plugin.finder.live.report;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.live.core.core.e.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig;", "", "()V", "TAG", "", "addProductAction", "", "getAddProductAction", "()Z", "setAddProductAction", "(Z)V", "bookLiveSrc", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BookLiveSrc;", "getBookLiveSrc", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BookLiveSrc;", "setBookLiveSrc", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BookLiveSrc;)V", "cacheExitEvent_21024", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;", "getCacheExitEvent_21024", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;", "setCacheExitEvent_21024", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;)V", "closeLinkMicAudioByVisitor", "getCloseLinkMicAudioByVisitor", "setCloseLinkMicAudioByVisitor", "closeLinkMicVideoByVisitor", "getCloseLinkMicVideoByVisitor", "setCloseLinkMicVideoByVisitor", "commentSceneOnFinderHome", "", "getCommentSceneOnFinderHome", "()I", "setCommentSceneOnFinderHome", "(I)V", "coverType", "getCoverType", "setCoverType", "curLikeNumber", "", "getCurLikeNumber", "()J", "setCurLikeNumber", "(J)V", "curLiveDuration", "getCurLiveDuration", "setCurLiveDuration", "curLiveNumber", "getCurLiveNumber", "setCurLiveNumber", "curProductIds", "Ljava/util/LinkedList;", "getCurProductIds", "()Ljava/util/LinkedList;", "setCurProductIds", "(Ljava/util/LinkedList;)V", "curRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getCurRecyclerViewRef", "()Ljava/lang/ref/WeakReference;", "setCurRecyclerViewRef", "(Ljava/lang/ref/WeakReference;)V", "desc", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "description", "getDescription", "enterSessionId", "getEnterSessionId", "setEnterSessionId", "errCode", "getErrCode", "setErrCode", "filterType", "getFilterType", "setFilterType", "filterValue", "getFilterValue", "setFilterValue", "fromWeconHotUI", "getFromWeconHotUI", "setFromWeconHotUI", "gAnchorLinkMicSucdess", "getGAnchorLinkMicSucdess", "setGAnchorLinkMicSucdess", "gAnchorLinkMicTimeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/vending/tuple/Tuple3;", "Lkotlin/collections/ArrayList;", "getGAnchorLinkMicTimeList", "()Ljava/util/ArrayList;", "gCurCommentscene_temp", "getGCurCommentscene_temp", "setGCurCommentscene_temp", "gCurLiveFeedPos", "getGCurLiveFeedPos", "setGCurLiveFeedPos", "gCurShopAppId", "gCurShopSessionId", "gLinkMicCount", "getGLinkMicCount", "setGLinkMicCount", "gLinkMicTimeList", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkType;", "getGLinkMicTimeList", "gLiveFeedFragmentPageMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGLiveFeedFragmentPageMap", "()Ljava/util/HashMap;", "gLiveFeedPageMap", "getGLiveFeedPageMap", "gSceneNote", "getGSceneNote", "setGSceneNote", "getContactFromMemberList", "getGetContactFromMemberList", "setGetContactFromMemberList", "isEnterFromFloat", "setEnterFromFloat", "isExitToFloat", "setExitToFloat", "isGift", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$IsGift;", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$IsGift;", "setGift", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$IsGift;)V", "launcherSrc", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartLiveSource;", "getLauncherSrc", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartLiveSource;", "setLauncherSrc", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartLiveSource;)V", "linkMicStateOnPre", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkSwitch;", "getLinkMicStateOnPre", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkSwitch;", "setLinkMicStateOnPre", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkSwitch;)V", "livePageTypeWhenEnter", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyPageType;", "getLivePageTypeWhenEnter", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyPageType;", "setLivePageTypeWhenEnter", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyPageType;)V", "liveStaticsData_21056", "Lcom/tencent/mm/plugin/finder/live/report/LiveStaticsData_21056;", "getLiveStaticsData_21056", "()Lcom/tencent/mm/plugin/finder/live/report/LiveStaticsData_21056;", "setLiveStaticsData_21056", "(Lcom/tencent/mm/plugin/finder/live/report/LiveStaticsData_21056;)V", "mAnchorLotteryCount", "getMAnchorLotteryCount", "setMAnchorLotteryCount", "mClickLotteryHistroy", "getMClickLotteryHistroy", "setMClickLotteryHistroy", "mClickLotteryIcon", "getMClickLotteryIcon", "setMClickLotteryIcon", "morpyEyes", "getMorpyEyes", "setMorpyEyes", "morpyFace", "getMorpyFace", "setMorpyFace", "nearbyCommenScene", "getNearbyCommenScene", "setNearbyCommenScene", "poiJSONObject", "Lorg/json/JSONObject;", "getPoiJSONObject", "()Lorg/json/JSONObject;", "setPoiJSONObject", "(Lorg/json/JSONObject;)V", "positionLiveFeedOnfull", "getPositionLiveFeedOnfull", "setPositionLiveFeedOnfull", "promoting", "getPromoting", "setPromoting", "rosy", "getRosy", "setRosy", "ruleType", "getRuleType", "setRuleType", "screenShareHistory", "Lcom/tencent/mm/json/JSONArray;", "getScreenShareHistory", "()Lcom/tencent/mm/json/JSONArray;", "setScreenShareHistory", "(Lcom/tencent/mm/json/JSONArray;)V", "sessionBufOnTemp2", "getSessionBufOnTemp2", "setSessionBufOnTemp2", "shopAppId", "getShopAppId", "skinWhitening", "getSkinWhitening", "setSkinWhitening", "smoothFace", "getSmoothFace", "setSmoothFace", "startLiveSource", "getStartLiveSource", "setStartLiveSource", "startScreenShareTime", "getStartScreenShareTime", "setStartScreenShareTime", "subTag", "getSubTag", "setSubTag", "tag", "getTag", "setTag", "timestampOfEnterLiveAnchorUI", "getTimestampOfEnterLiveAnchorUI", "setTimestampOfEnterLiveAnchorUI", "visibleRange", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisibleRangeType;", "getVisibleRange", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisibleRangeType;", "setVisibleRange", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisibleRangeType;)V", "visibleRangeNum", "getVisibleRangeNum", "setVisibleRangeNum", "visitorEnterType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "getVisitorEnterType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "setVisitorEnterType", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;)V", "convert21919Action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CloseUISeeGiftList;", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$SEE_GIFT_LIST;", "getAnchorFeedId", "getAnchorLiveId", "getEnterIconType", "commenScene", "defVal", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FilterType;", "filterPath", "getFinderUserName", "getPoi", "getPromoteGoodsStr", "getSessionPageId", "getdesc", "isPrivate", "isPrivateAccount4Visitor", "userName", "resetSomeData", "", "setShopParams", "shopSessionId", "clickType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "stopPromoteGood", "productId", "stopPromoteGoods", "ActionType", "AllCommentType", "AnchorActionType", "AnchorFloatAction", "AnchorLiveClose", "AnchorLotteryType", "BattleActionType", "BookLiveSrc", "CastScreenResult", "ClearScreenAction", "CloseUISeeGiftList", "CommentSceneExtend", "ComplaintVisitorSource", "CoverType", "CoverType2", "ElementClickId", "ElementExposeId", "EnterRoomStatus", "ExitType", "ExploreType", "FilterType", "FloatActionType", "FollowBtnAction", "FollowState", "GIFT_SWITCCH", "GiftSwitch", "IdentityType", "InviteType", "IsGift", "JspiCommenScene", "LikeSwitchType", "LinkOp", "LinkSwitch", "LinkType", "LiveAnchorCommerceAction", "LiveAnchorMusicEditAction", "LiveAnchorScreenShareAction", "LiveBookAction", "LivePersonalAction", "LiveVerified", "Live_Enter_Type", "MicType", "MusicType", "NearbyAction2", "NearbyMoreActionResult", "NearbyPageType", "RedPacketSrc", "RedPacketType", "RuleType", "SCREEN_SWITCH_ACTION", "SEE_GIFT_LIST", "ScreenBtnEvent", "ScreenDirection", "ShareType", "ShopPermitAction", "StartLiveSource", "StartType", "VisibleRangeType", "VisitorAction", "VisitorAuthAction", "VisitorCloseType", "VisitorCommerceAction", "VisitorEnterType", "VisitorGift", "VisitorLinkMicAction", "VisitorLotteryType", "VisitorNoticeAction", "VisitorShareType", "VisitorShopBtnState", "VisitorWinResult", "plugin-finder_release"})
public final class s
{
  private final String TAG;
  String desc;
  int errCode;
  int krd;
  String tag;
  public String yCF;
  public long yCG;
  public String yCI;
  public String yCJ;
  long yCK;
  public boolean yCL;
  public boolean yCM;
  int yCN;
  int yCO;
  int yCP;
  int yCQ;
  int yCR;
  int yCS;
  int yCT;
  boolean yCU;
  final ArrayList<com.tencent.mm.vending.j.d<String, Long, Boolean>> yCV;
  public String yCW;
  public boolean yCX;
  af yCY;
  boolean yCZ;
  final ArrayList<com.tencent.mm.vending.j.d<ag, Long, Boolean>> yCe;
  public boolean yDA;
  public boolean yDB;
  public LinkedList<Long> yDC;
  public WeakReference<RecyclerView> yDD;
  as yDE;
  bc yDF;
  public h yDG;
  public long yDH;
  public f yDI;
  ab yDa;
  long yDb;
  boolean yDc;
  public int yDd;
  public int yDe;
  String yDf;
  String yDg;
  bc yDh;
  public String yDi;
  be yDj;
  long yDk;
  public final HashMap<String, String> yDl;
  public final HashMap<String, String> yDm;
  public bj yDn;
  s yDo;
  long yDp;
  long yDq;
  JSONObject yDr;
  int yDs;
  public long yDt;
  public long yDu;
  public long yDv;
  public u yDw;
  public boolean yDx;
  public boolean yDy;
  public boolean yDz;
  
  public s()
  {
    AppMethodBeat.i(269920);
    this.TAG = "HABBYGE-MALI.LiveReportConfig";
    this.yCF = "";
    this.yCI = "";
    this.yCJ = "";
    this.yCe = new ArrayList();
    this.yCV = new ArrayList();
    this.yCW = "";
    this.yCY = af.yIl;
    this.yDa = ab.yHL;
    this.yDf = "";
    this.tag = "";
    this.yDg = "";
    this.yDh = bc.yKN;
    this.yDi = "";
    this.yDj = be.yKU;
    this.yDl = ae.g(new kotlin.o[] { new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", "1"), new kotlin.o("FinderProfileTimeLineUI", "1"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI", "16"), new kotlin.o("FinderLbsStreamListUI", "16"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderFollowListUI", "12"), new kotlin.o("FinderFollowListUI", "12"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", "27"), new kotlin.o("FinderTopicTimelineUI", "27"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "25"), new kotlin.o("FinderShareFeedRelUI", "25"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", "2"), new kotlin.o("FinderLikedFeedUI", "2"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", "21"), new kotlin.o("FinderFavTimelineUI", "21"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI", "40"), new kotlin.o("FinderFeedRelatedTimelineUI", "40"), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "23"), new kotlin.o("FinderMixSearchUI", "23"), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderContactSearchUI", l.yFR.scene), new kotlin.o("FinderContactSearchUI", l.yFR.scene), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", "6"), new kotlin.o("FinderFeedSearchUI", "6") });
    this.yDm = ae.g(new kotlin.o[] { new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", "17"), new kotlin.o("FinderFollowTabFragment", "17"), new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", "18"), new kotlin.o("FinderFriendTabFragment", "18"), new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", "20"), new kotlin.o("FinderMachineTabFragment", "20") });
    this.yDn = bj.yMa;
    this.yDo = s.yGK;
    this.yDq = 1L;
    this.yDs = o.yGp.type;
    this.yDw = new u();
    this.yDC = new LinkedList();
    this.yDE = as.yJJ;
    this.yDF = bc.yKN;
    this.yDG = h.yFq;
    this.yDI = new f();
    AppMethodBeat.o(269920);
  }
  
  public static u aCF(String paramString)
  {
    AppMethodBeat.i(269904);
    com.tencent.mm.live.core.d.a locala = com.tencent.mm.live.core.d.a.ksS;
    int i = com.tencent.mm.live.core.d.a.NQ(paramString);
    paramString = e.f.kkj;
    if (i == e.f.aKj())
    {
      paramString = u.yHc;
      AppMethodBeat.o(269904);
      return paramString;
    }
    paramString = e.f.kkj;
    if (i == e.f.aKk())
    {
      paramString = u.yHd;
      AppMethodBeat.o(269904);
      return paramString;
    }
    paramString = e.f.kkj;
    if (i == e.f.aKq())
    {
      paramString = u.yHe;
      AppMethodBeat.o(269904);
      return paramString;
    }
    paramString = e.f.kkj;
    if (i == e.f.aKl())
    {
      paramString = u.yHf;
      AppMethodBeat.o(269904);
      return paramString;
    }
    paramString = e.f.kkj;
    if (i == e.f.aKm())
    {
      paramString = u.yHg;
      AppMethodBeat.o(269904);
      return paramString;
    }
    paramString = e.f.kkj;
    if (i == e.f.aKo())
    {
      paramString = u.yHi;
      AppMethodBeat.o(269904);
      return paramString;
    }
    paramString = e.f.kkj;
    if (i == e.f.aKp())
    {
      paramString = u.yHj;
      AppMethodBeat.o(269904);
      return paramString;
    }
    paramString = e.f.kkj;
    if (i == e.f.aKn())
    {
      paramString = u.yHh;
      AppMethodBeat.o(269904);
      return paramString;
    }
    paramString = u.yHb;
    AppMethodBeat.o(269904);
    return paramString;
  }
  
  public static int aCG(String paramString)
  {
    AppMethodBeat.i(269911);
    if (paramString == null)
    {
      AppMethodBeat.o(269911);
      return 0;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    paramString = d.a.aAK(paramString);
    localObject = aj.AGc;
    if (aj.j(paramString))
    {
      AppMethodBeat.o(269911);
      return 1;
    }
    AppMethodBeat.o(269911);
    return 0;
  }
  
  public static long at(String paramString, long paramLong)
  {
    AppMethodBeat.i(269917);
    if ((p.h(paramString, l.yFY.scene)) || (p.h(paramString, l.yGc.scene)) || (p.h(paramString, l.yGd.scene)) || (p.h(paramString, ac.yHN.type)) || (p.h(paramString, ac.yHO.type)) || (p.h(paramString, ac.yHR.type)) || (p.h(paramString, ac.yHP.type)))
    {
      paramLong = bj.yMe.type;
      AppMethodBeat.o(269917);
      return paramLong;
    }
    p.h(paramString, ac.yHQ.type);
    AppMethodBeat.o(269917);
    return paramLong;
  }
  
  public static String dDv()
  {
    AppMethodBeat.i(269910);
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(269910);
    return str1;
  }
  
  public static String dDw()
  {
    AppMethodBeat.i(269912);
    String str2 = z.bdh();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(269912);
    return str1;
  }
  
  public static int dDx()
  {
    AppMethodBeat.i(269913);
    Object localObject1 = dDw();
    Object localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject1 = d.a.aAK((String)localObject1);
    localObject2 = aj.AGc;
    if (aj.j((i)localObject1))
    {
      AppMethodBeat.o(269913);
      return 1;
    }
    AppMethodBeat.o(269913);
    return 0;
  }
  
  public static String getDescription()
  {
    AppMethodBeat.i(269905);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).zgW;
        if (localObject != null)
        {
          String str = ((FinderObjectDesc)localObject).description;
          localObject = str;
          if (str != null) {
            break label57;
          }
        }
      }
    }
    localObject = "";
    label57:
    p.j(localObject, "LivingBuContext?.busines…Object?.description ?: \"\"");
    localObject = q.an((String)localObject, "UTF-8");
    p.j(localObject, "URLEncoder.encode(text, \"UTF-8\")");
    AppMethodBeat.o(269905);
    return localObject;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(269918);
    p.k(paramf, "<set-?>");
    this.yDI = paramf;
    AppMethodBeat.o(269918);
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(269898);
    p.k(paramab, "<set-?>");
    this.yDa = paramab;
    AppMethodBeat.o(269898);
  }
  
  public final void a(af paramaf)
  {
    AppMethodBeat.i(269897);
    p.k(paramaf, "<set-?>");
    this.yCY = paramaf;
    AppMethodBeat.o(269897);
  }
  
  public final void a(as paramas)
  {
    AppMethodBeat.i(269915);
    p.k(paramas, "<set-?>");
    this.yDE = paramas;
    AppMethodBeat.o(269915);
  }
  
  public final void a(bc parambc)
  {
    AppMethodBeat.i(269901);
    p.k(parambc, "<set-?>");
    this.yDh = parambc;
    AppMethodBeat.o(269901);
  }
  
  public final void a(be parambe)
  {
    AppMethodBeat.i(269902);
    p.k(parambe, "<set-?>");
    this.yDj = parambe;
    AppMethodBeat.o(269902);
  }
  
  public final void a(t paramt, String paramString)
  {
    AppMethodBeat.i(269903);
    p.k(paramt, "clickType");
    p.k(paramString, "commenScene");
    switch (t.$EnumSwitchMapping$0[paramt.ordinal()])
    {
    default: 
      this.yDn = bj.yLZ;
      AppMethodBeat.o(269903);
      return;
    case 1: 
    case 2: 
    case 3: 
      if ((p.h(paramString, "37")) || (p.h(paramString, String.valueOf(l.yGa))) || (p.h(paramString, String.valueOf(l.yFY))))
      {
        this.yDn = bj.yMe;
        AppMethodBeat.o(269903);
        return;
      }
      this.yDn = bj.yMa;
      AppMethodBeat.o(269903);
      return;
    case 4: 
      this.yDn = bj.yMd;
      AppMethodBeat.o(269903);
      return;
    case 5: 
      this.yDn = bj.yMb;
      AppMethodBeat.o(269903);
      return;
    }
    this.yDn = bj.yMc;
    AppMethodBeat.o(269903);
  }
  
  public final void aCC(String paramString)
  {
    AppMethodBeat.i(269895);
    p.k(paramString, "<set-?>");
    this.yCF = paramString;
    AppMethodBeat.o(269895);
  }
  
  public final void aCD(String paramString)
  {
    AppMethodBeat.i(269896);
    p.k(paramString, "<set-?>");
    this.yCW = paramString;
    AppMethodBeat.o(269896);
  }
  
  public final void aCE(String paramString)
  {
    AppMethodBeat.i(269900);
    p.k(paramString, "<set-?>");
    this.yDg = paramString;
    AppMethodBeat.o(269900);
  }
  
  public final void b(bc parambc)
  {
    AppMethodBeat.i(269916);
    p.k(parambc, "<set-?>");
    this.yDF = parambc;
    AppMethodBeat.o(269916);
  }
  
  public final void c(s params)
  {
    AppMethodBeat.i(269907);
    p.k(params, "<set-?>");
    this.yDo = params;
    AppMethodBeat.o(269907);
  }
  
  public final String dDs()
  {
    AppMethodBeat.i(269906);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null)
    {
      localObject1 = (j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(j.class);
      if (localObject1 == null) {}
    }
    for (Object localObject2 = ((j)localObject1).ziN;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.yCI;
      }
      Log.i(this.TAG, "get shopAppid=".concat(String.valueOf(localObject1)));
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      AppMethodBeat.o(269906);
      return localObject2;
    }
  }
  
  public final String dDt()
  {
    AppMethodBeat.i(269908);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).liveInfo;
        if (localObject == null) {}
      }
    }
    for (long l = ((bac)localObject).liveId; l == -1L; l = -1L)
    {
      localObject = this.yDw.kwM;
      AppMethodBeat.o(269908);
      return localObject;
    }
    localObject = b.Fw(l);
    p.j(localObject, "HellhoundUtil.long2UnsignedString(liveId)");
    AppMethodBeat.o(269908);
    return localObject;
  }
  
  public final String dDu()
  {
    AppMethodBeat.i(269909);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject == null) {}
    }
    for (long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).xbk; l == 0L; l = 0L)
    {
      localObject = this.yDw.feedId;
      AppMethodBeat.o(269909);
      return localObject;
    }
    localObject = b.Fw(l);
    p.j(localObject, "HellhoundUtil.long2UnsignedString(feedId)");
    AppMethodBeat.o(269909);
    return localObject;
  }
  
  public final void dDy()
  {
    AppMethodBeat.i(269914);
    Object localObject = this.yDw.yNH;
    if (((HashMap)localObject).isEmpty())
    {
      AppMethodBeat.o(269914);
      return;
    }
    long l2 = System.currentTimeMillis();
    localObject = ((Map)localObject).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((LinkedList)((Map.Entry)((Iterator)localObject).next()).getValue()).iterator();
      label84:
      o localo;
      long l1;
      while (localIterator.hasNext())
      {
        localo = (o)localIterator.next();
        if (!localo.yCw)
        {
          localo.yCw = true;
          l1 = l2 - localo.time;
          if (l1 <= 0L) {
            break label143;
          }
        }
      }
      for (;;)
      {
        localo.time = l1;
        break label84;
        break;
        label143:
        l1 = 0L;
      }
    }
    AppMethodBeat.o(269914);
  }
  
  public final void setTag(String paramString)
  {
    AppMethodBeat.i(269899);
    p.k(paramString, "<set-?>");
    this.tag = paramString;
    AppMethodBeat.o(269899);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ActionType;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "PROFILE_LIVE_BTN_EXPOSE", "PROFILE_LIVE_BTN_CLICK", "LIVE_ENTER_UI", "LIVE_BTN_CLICK", "LIVE_EXCHANGE_CAMERA", "LIVE_COMMERCE", "LIVE_EDIT_COVER", "LIVE_DESCRIPTION", "LIVE_POI", "LIVE_RULE", "LIVE_TIMER", "LIVE_SUCCESS", "LIVE_OUT", "LIVE_CLICK_BTN_MENU", "LINKMIC_SWITCH", "GIFT_SWITCCH", "LIVE_AUDIO_MODE", "ANCHOR_MUSIC_BEFORE_LIVE", "LIVE_BEAUTY", "LIVE_LIKE", "MINI_GAME_LIVE", "plugin-finder_release"})
  public static enum a
  {
    public final long jWO;
    
    static
    {
      AppMethodBeat.i(263435);
      a locala1 = new a("PROFILE_LIVE_BTN_EXPOSE", 0, 1L);
      yDJ = locala1;
      a locala2 = new a("PROFILE_LIVE_BTN_CLICK", 1, 2L);
      yDK = locala2;
      a locala3 = new a("LIVE_ENTER_UI", 2, 3L);
      yDL = locala3;
      a locala4 = new a("LIVE_BTN_CLICK", 3, 4L);
      yDM = locala4;
      a locala5 = new a("LIVE_EXCHANGE_CAMERA", 4, 5L);
      yDN = locala5;
      a locala6 = new a("LIVE_COMMERCE", 5, 6L);
      yDO = locala6;
      a locala7 = new a("LIVE_EDIT_COVER", 6, 7L);
      yDP = locala7;
      a locala8 = new a("LIVE_DESCRIPTION", 7, 8L);
      yDQ = locala8;
      a locala9 = new a("LIVE_POI", 8, 9L);
      yDR = locala9;
      a locala10 = new a("LIVE_RULE", 9, 10L);
      yDS = locala10;
      a locala11 = new a("LIVE_TIMER", 10, 11L);
      yDT = locala11;
      a locala12 = new a("LIVE_SUCCESS", 11, 12L);
      yDU = locala12;
      a locala13 = new a("LIVE_OUT", 12, 13L);
      yDV = locala13;
      a locala14 = new a("LIVE_CLICK_BTN_MENU", 13, 14L);
      yDW = locala14;
      a locala15 = new a("LINKMIC_SWITCH", 14, 15L);
      yDX = locala15;
      a locala16 = new a("GIFT_SWITCCH", 15, 16L);
      yDY = locala16;
      a locala17 = new a("LIVE_AUDIO_MODE", 16, 20L);
      yDZ = locala17;
      a locala18 = new a("ANCHOR_MUSIC_BEFORE_LIVE", 17, 21L);
      yEa = locala18;
      a locala19 = new a("LIVE_BEAUTY", 18, 23L);
      yEb = locala19;
      a locala20 = new a("LIVE_LIKE", 19, 24L);
      yEc = locala20;
      a locala21 = new a("MINI_GAME_LIVE", 20, 25L);
      yEd = locala21;
      yEe = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21 };
      AppMethodBeat.o(263435);
    }
    
    private a(long paramLong)
    {
      this.jWO = paramLong;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$InviteType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "INITIATIVE", "PASSIVE", "plugin-finder_release"})
  public static enum aa
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(284297);
      aa localaa1 = new aa("INITIATIVE", 0, 1);
      yHH = localaa1;
      aa localaa2 = new aa("PASSIVE", 1, 2);
      yHI = localaa2;
      yHJ = new aa[] { localaa1, localaa2 };
      AppMethodBeat.o(284297);
    }
    
    private aa(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$IsGift;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "YES", "NO", "plugin-finder_release"})
  public static enum ab
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(228674);
      ab localab1 = new ab("YES", 0, 1);
      yHK = localab1;
      ab localab2 = new ab("NO", 1, 2);
      yHL = localab2;
      yHM = new ab[] { localab1, localab2 };
      AppMethodBeat.o(228674);
    }
    
    private ab(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$JspiCommenScene;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PUBLIC_NUMBER", "SEARCH_1_SEARCH", "SEE_1_SEE", "GAME_CENTER", "LITTLE_APP", "plugin-finder_release"})
  public static enum ac
  {
    final String type;
    
    static
    {
      AppMethodBeat.i(285258);
      ac localac1 = new ac("PUBLIC_NUMBER", 0, "5");
      yHN = localac1;
      ac localac2 = new ac("SEARCH_1_SEARCH", 1, "6");
      yHO = localac2;
      ac localac3 = new ac("SEE_1_SEE", 2, "7");
      yHP = localac3;
      ac localac4 = new ac("GAME_CENTER", 3, "9");
      yHQ = localac4;
      ac localac5 = new ac("LITTLE_APP", 4, "15");
      yHR = localac5;
      yHS = new ac[] { localac1, localac2, localac3, localac4, localac5 };
      AppMethodBeat.o(285258);
    }
    
    private ac(String paramString)
    {
      this.type = paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LikeSwitchType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_LIKE_SWITCH_ENABLE", "LIVE_LIKE_SWITCH_DISABLE", "plugin-finder_release"})
  public static enum ad
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(256397);
      ad localad1 = new ad("LIVE_LIKE_SWITCH_ENABLE", 0, 1);
      yHT = localad1;
      ad localad2 = new ad("LIVE_LIKE_SWITCH_DISABLE", 1, 2);
      yHU = localad2;
      yHV = new ad[] { localad1, localad2 };
      AppMethodBeat.o(256397);
    }
    
    private ad(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkOp;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_LINKMIC_LOGO", "CONNECT_VOICE_TO_LINKMIC", "CONNECT_VIDEO_TO_LINKMIC", "DISCONNECT_VOICE_TO_LINKMIC", "DISCONNECT_VIDEO_TO_LINKMIC", "LINKMIC_ICON_READDOT_EXPOSE", "ENTER_VISITOR_LINKMIC_TAB", "ENTER_ANCHOR_LINKMIC_TAB", "ENTER_INVITE_ANCHOR_LINKMIC_TAB", "INVITE_ANCHOR_LINKMIC", "LINKMIC_CONNECT_SUCCESS", "STOP_LINKMIC_WHEN_WAITING_CONNECT", "STOP_LINKMIC_WHEN_SHOW_CONNECTING", "LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW", "plugin-finder_release"})
  public static enum ae
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(285914);
      ae localae1 = new ae("CLICK_LINKMIC_LOGO", 0, 1);
      yHW = localae1;
      ae localae2 = new ae("CONNECT_VOICE_TO_LINKMIC", 1, 2);
      yHX = localae2;
      ae localae3 = new ae("CONNECT_VIDEO_TO_LINKMIC", 2, 3);
      yHY = localae3;
      ae localae4 = new ae("DISCONNECT_VOICE_TO_LINKMIC", 3, 4);
      yHZ = localae4;
      ae localae5 = new ae("DISCONNECT_VIDEO_TO_LINKMIC", 4, 5);
      yIa = localae5;
      ae localae6 = new ae("LINKMIC_ICON_READDOT_EXPOSE", 5, 6);
      yIb = localae6;
      ae localae7 = new ae("ENTER_VISITOR_LINKMIC_TAB", 6, 7);
      yIc = localae7;
      ae localae8 = new ae("ENTER_ANCHOR_LINKMIC_TAB", 7, 8);
      yId = localae8;
      ae localae9 = new ae("ENTER_INVITE_ANCHOR_LINKMIC_TAB", 8, 9);
      yIe = localae9;
      ae localae10 = new ae("INVITE_ANCHOR_LINKMIC", 9, 10);
      yIf = localae10;
      ae localae11 = new ae("LINKMIC_CONNECT_SUCCESS", 10, 11);
      yIg = localae11;
      ae localae12 = new ae("STOP_LINKMIC_WHEN_WAITING_CONNECT", 11, 12);
      yIh = localae12;
      ae localae13 = new ae("STOP_LINKMIC_WHEN_SHOW_CONNECTING", 12, 13);
      yIi = localae13;
      ae localae14 = new ae("LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW", 13, 14);
      yIj = localae14;
      yIk = new ae[] { localae1, localae2, localae3, localae4, localae5, localae6, localae7, localae8, localae9, localae10, localae11, localae12, localae13, localae14 };
      AppMethodBeat.o(285914);
    }
    
    private ae(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkSwitch;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "OPEN", "CLOSE", "MIC_SETTING_NO", "MIC_SETTING_REWARD", "MIC_SETTING_FOLLOW", "MIC_SETTING_BUY_PRODUCT", "plugin-finder_release"})
  public static enum af
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(278707);
      af localaf1 = new af("OPEN", 0, 1);
      yIl = localaf1;
      af localaf2 = new af("CLOSE", 1, 2);
      yIm = localaf2;
      af localaf3 = new af("MIC_SETTING_NO", 2, 3);
      yIn = localaf3;
      af localaf4 = new af("MIC_SETTING_REWARD", 3, 4);
      yIo = localaf4;
      af localaf5 = new af("MIC_SETTING_FOLLOW", 4, 5);
      yIp = localaf5;
      af localaf6 = new af("MIC_SETTING_BUY_PRODUCT", 5, 7);
      yIq = localaf6;
      yIr = new af[] { localaf1, localaf2, localaf3, localaf4, localaf5, localaf6 };
      AppMethodBeat.o(278707);
    }
    
    private af(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "INVALIDATE", "AUDIO", "VIDEO", "plugin-finder_release"})
  public static enum ag
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(223722);
      ag localag1 = new ag("INVALIDATE", 0, 0);
      yIs = localag1;
      ag localag2 = new ag("AUDIO", 1, 1);
      yIt = localag2;
      ag localag3 = new ag("VIDEO", 2, 2);
      yIu = localag3;
      yIv = new ag[] { localag1, localag2, localag3 };
      AppMethodBeat.o(223722);
    }
    
    private ag(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveAnchorCommerceAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_ENTER_SHOP", "LIVE_ADD_GOODS", "LIVE_CLICK_GOODS", "LIVE_DELETE_GOODS", "LIVE_SET_TOP_GOODS", "LIVE_START_PROMOTE_GOODS", "LIVE_FINISH_PROMOTE_GOODS", "LIVE_CLICK_PROMOTE_GOODS", "LIVE_CLICK_SHOPPING_ADD_PRODUCT", "plugin-finder_release"})
  public static enum ah
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(268780);
      ah localah1 = new ah("LIVE_ENTER_SHOP", 0, 1);
      yIw = localah1;
      ah localah2 = new ah("LIVE_ADD_GOODS", 1, 2);
      yIx = localah2;
      ah localah3 = new ah("LIVE_CLICK_GOODS", 2, 3);
      yIy = localah3;
      ah localah4 = new ah("LIVE_DELETE_GOODS", 3, 4);
      yIz = localah4;
      ah localah5 = new ah("LIVE_SET_TOP_GOODS", 4, 5);
      yIA = localah5;
      ah localah6 = new ah("LIVE_START_PROMOTE_GOODS", 5, 7);
      yIB = localah6;
      ah localah7 = new ah("LIVE_FINISH_PROMOTE_GOODS", 6, 8);
      yIC = localah7;
      ah localah8 = new ah("LIVE_CLICK_PROMOTE_GOODS", 7, 9);
      yID = localah8;
      ah localah9 = new ah("LIVE_CLICK_SHOPPING_ADD_PRODUCT", 8, 10);
      yIE = localah9;
      yIF = new ah[] { localah1, localah2, localah3, localah4, localah5, localah6, localah7, localah8, localah9 };
      AppMethodBeat.o(268780);
    }
    
    private ah(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveAnchorMusicEditAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "SEARCH_MUSIC", "ADD_MUSIC", "CLICK_VOLUME", "DELETE_MUSIC_ITEM", "CLICK_MENU", "DELETE_MUSIC_LIST", "FINISH_EDIT", "PLAY_MUSIC", "PAUSE_MUSIC", "CLICK_CANCEL", "SHOW_MUSIC_PANEL", "plugin-finder_release"})
  public static enum ai
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(256346);
      ai localai1 = new ai("SEARCH_MUSIC", 0, 1);
      yIG = localai1;
      ai localai2 = new ai("ADD_MUSIC", 1, 2);
      yIH = localai2;
      ai localai3 = new ai("CLICK_VOLUME", 2, 3);
      yII = localai3;
      ai localai4 = new ai("DELETE_MUSIC_ITEM", 3, 4);
      yIJ = localai4;
      ai localai5 = new ai("CLICK_MENU", 4, 5);
      yIK = localai5;
      ai localai6 = new ai("DELETE_MUSIC_LIST", 5, 6);
      yIL = localai6;
      ai localai7 = new ai("FINISH_EDIT", 6, 7);
      yIM = localai7;
      ai localai8 = new ai("PLAY_MUSIC", 7, 8);
      yIN = localai8;
      ai localai9 = new ai("PAUSE_MUSIC", 8, 9);
      yIO = localai9;
      ai localai10 = new ai("CLICK_CANCEL", 9, 10);
      yIP = localai10;
      ai localai11 = new ai("SHOW_MUSIC_PANEL", 10, 11);
      yIQ = localai11;
      yIR = new ai[] { localai1, localai2, localai3, localai4, localai5, localai6, localai7, localai8, localai9, localai10, localai11 };
      AppMethodBeat.o(256346);
    }
    
    private ai(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveAnchorScreenShareAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "EXPOSE", "CLICK", "START", "FINISH", "CLOSE_CAMERA", "plugin-finder_release"})
  public static enum aj
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(289599);
      aj localaj1 = new aj("EXPOSE", 0, 1);
      yIS = localaj1;
      aj localaj2 = new aj("CLICK", 1, 2);
      yIT = localaj2;
      aj localaj3 = new aj("START", 2, 3);
      yIU = localaj3;
      aj localaj4 = new aj("FINISH", 3, 4);
      yIV = localaj4;
      aj localaj5 = new aj("CLOSE_CAMERA", 4, 5);
      yIW = localaj5;
      yIX = new aj[] { localaj1, localaj2, localaj3, localaj4, localaj5 };
      AppMethodBeat.o(289599);
    }
    
    private aj(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveBookAction;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "LIVE_SELF_PAGE_CLICK_BOOK_ITEM", "LIVE_ENTER_CRAETE_BOOK_PAGE", "LIVE_CREATE_BOOK_SUCC", "LIVE_JUMP_PROFILE_PAGE", "LIVE_CANCEL_BOOK", "LIVE_CREATE_QRCODE", "LIVE_CHECK_NOTICE", "plugin-finder_release"})
  public static enum ak
  {
    final long jWO;
    
    static
    {
      AppMethodBeat.i(231907);
      ak localak1 = new ak("LIVE_SELF_PAGE_CLICK_BOOK_ITEM", 0, 1L);
      yIY = localak1;
      ak localak2 = new ak("LIVE_ENTER_CRAETE_BOOK_PAGE", 1, 2L);
      yIZ = localak2;
      ak localak3 = new ak("LIVE_CREATE_BOOK_SUCC", 2, 3L);
      yJa = localak3;
      ak localak4 = new ak("LIVE_JUMP_PROFILE_PAGE", 3, 4L);
      yJb = localak4;
      ak localak5 = new ak("LIVE_CANCEL_BOOK", 4, 5L);
      yJc = localak5;
      ak localak6 = new ak("LIVE_CREATE_QRCODE", 5, 6L);
      yJd = localak6;
      ak localak7 = new ak("LIVE_CHECK_NOTICE", 6, 7L);
      yJe = localak7;
      yJf = new ak[] { localak1, localak2, localak3, localak4, localak5, localak6, localak7 };
      AppMethodBeat.o(231907);
    }
    
    private ak(long paramLong)
    {
      this.jWO = paramLong;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LivePersonalAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_PERSONAL_VIEW_SHOW", "LIVE_PERSONAL_COMMENT_CLOSE", "LIVE_PERSONAL_COMMENT_OPEN", "LIVE_PERSONAL_COMPLAIN", "LIVE_PERSONAL_KICK_OUT", "plugin-finder_release"})
  public static enum al
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(268360);
      al localal1 = new al("LIVE_PERSONAL_VIEW_SHOW", 0, 1);
      yJg = localal1;
      al localal2 = new al("LIVE_PERSONAL_COMMENT_CLOSE", 1, 2);
      yJh = localal2;
      al localal3 = new al("LIVE_PERSONAL_COMMENT_OPEN", 2, 3);
      yJi = localal3;
      al localal4 = new al("LIVE_PERSONAL_COMPLAIN", 3, 4);
      yJj = localal4;
      al localal5 = new al("LIVE_PERSONAL_KICK_OUT", 4, 5);
      yJk = localal5;
      yJl = new al[] { localal1, localal2, localal3, localal4, localal5 };
      AppMethodBeat.o(268360);
    }
    
    private al(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveVerified;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "LIVE_VERIFIED_PAGE_EXPOSURE", "LIVE_ENTER_VERIFIED_PAGE", "LIVE_PASS_VERIFIED_SUCC", "LIVE_PASS_VERIFIED_FAIL", "plugin-finder_release"})
  public static enum am
  {
    final long jWO;
    
    static
    {
      AppMethodBeat.i(272566);
      am localam1 = new am("LIVE_VERIFIED_PAGE_EXPOSURE", 0, 1L);
      yJm = localam1;
      am localam2 = new am("LIVE_ENTER_VERIFIED_PAGE", 1, 2L);
      yJn = localam2;
      am localam3 = new am("LIVE_PASS_VERIFIED_SUCC", 2, 3L);
      yJo = localam3;
      am localam4 = new am("LIVE_PASS_VERIFIED_FAIL", 3, 4L);
      yJp = localam4;
      yJq = new am[] { localam1, localam2, localam3, localam4 };
      AppMethodBeat.o(272566);
    }
    
    private am(long paramLong)
    {
      this.jWO = paramLong;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$Live_Enter_Type;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ORDINARY_LAUNCH_UI", "INNER_NOTICE_TIME_LAUNCH_UI", "RETURN_LIVE_ROOM", "plugin-finder_release"})
  public static enum an
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(288249);
      an localan1 = new an("ORDINARY_LAUNCH_UI", 0, 1);
      yJr = localan1;
      an localan2 = new an("INNER_NOTICE_TIME_LAUNCH_UI", 1, 2);
      yJs = localan2;
      an localan3 = new an("RETURN_LIVE_ROOM", 2, 3);
      yJt = localan3;
      yJu = new an[] { localan1, localan2, localan3 };
      AppMethodBeat.o(288249);
    }
    
    private an(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$MicType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ANCHOR_ANCHOR", "ANCHOR_VISITOR", "plugin-finder_release"})
  public static enum ao
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(223531);
      ao localao1 = new ao("ANCHOR_ANCHOR", 0, 1);
      yJv = localao1;
      ao localao2 = new ao("ANCHOR_VISITOR", 1, 2);
      yJw = localao2;
      yJx = new ao[] { localao1, localao2 };
      AppMethodBeat.o(223531);
    }
    
    private ao(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$MusicType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_MUSIC_ENTRANCE", "CLICK_QQ_MUSIC", "CLICK_GOTO_QQ_MUSIC", "plugin-finder_release"})
  public static enum ap
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(225324);
      ap localap1 = new ap("CLICK_MUSIC_ENTRANCE", 0, 1);
      yJy = localap1;
      ap localap2 = new ap("CLICK_QQ_MUSIC", 1, 2);
      yJz = localap2;
      ap localap3 = new ap("CLICK_GOTO_QQ_MUSIC", 2, 3);
      yJA = localap3;
      yJB = new ap[] { localap1, localap2, localap3 };
      AppMethodBeat.o(225324);
    }
    
    private ap(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyAction2;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ENTER_PAGE_EXPLORE", "CLICK_CANCEL_RETURN", "CLICK_START_LIVE", "plugin-finder_release"})
  public static enum aq
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(273419);
      aq localaq1 = new aq("ENTER_PAGE_EXPLORE", 0, 1);
      yJC = localaq1;
      aq localaq2 = new aq("CLICK_CANCEL_RETURN", 1, 2);
      yJD = localaq2;
      aq localaq3 = new aq("CLICK_START_LIVE", 2, 3);
      yJE = localaq3;
      yJF = new aq[] { localaq1, localaq2, localaq3 };
      AppMethodBeat.o(273419);
    }
    
    private aq(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyMoreActionResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "EXPLORE_MORE_LIVE", "CLICK_MORE_LIVE", "plugin-finder_release"})
  public static enum ar
  {
    final int result;
    
    static
    {
      AppMethodBeat.i(273616);
      ar localar1 = new ar("EXPLORE_MORE_LIVE", 0, 1);
      yJG = localar1;
      ar localar2 = new ar("CLICK_MORE_LIVE", 1, 2);
      yJH = localar2;
      yJI = new ar[] { localar1, localar2 };
      AppMethodBeat.o(273616);
    }
    
    private ar(int paramInt)
    {
      this.result = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyPageType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "START_LIVE_BY_FINDER_IDENTITY", "CREATE_FINDER", "WECHAT_REALNAME_AUTH", "plugin-finder_release"})
  public static enum as
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(254339);
      as localas1 = new as("START_LIVE_BY_FINDER_IDENTITY", 0, 1);
      yJJ = localas1;
      as localas2 = new as("CREATE_FINDER", 1, 2);
      yJK = localas2;
      as localas3 = new as("WECHAT_REALNAME_AUTH", 2, 3);
      yJL = localas3;
      yJM = new as[] { localas1, localas2, localas3 };
      AppMethodBeat.o(254339);
    }
    
    private as(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketSrc;", "", "src", "", "(Ljava/lang/String;II)V", "getSrc", "()I", "UNKNOWN", "ANCHOR", "LINKMIC_VISITOR", "plugin-finder_release"})
  public static enum at
  {
    final int src;
    
    static
    {
      AppMethodBeat.i(291657);
      at localat1 = new at("UNKNOWN", 0, -1);
      yJN = localat1;
      at localat2 = new at("ANCHOR", 1, 1);
      yJO = localat2;
      at localat3 = new at("LINKMIC_VISITOR", 2, 2);
      yJP = localat3;
      yJQ = new at[] { localat1, localat2, localat3 };
      AppMethodBeat.o(291657);
    }
    
    private at(int paramInt)
    {
      this.src = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EXPOSE_RIGHT_UP_CORNER_RED_PACKET_", "CLICK_RED_PACKET", "CLICK_COMMENT_AREA_RED_PACKET_SYS_MSG", "EXPOSE_RED_PACKET_UI", "CLICK_OPEN_RED_PACKET", "EXPOSE_RED_PACKET_OVER_INTERCEPT_UI", "EXPOSE_ONLY_PART_USER_INTERCEPT_UI", "RED_PACKET_EXPIRED_NOTIFY", "ONLY_WX_IDENTIFY_INTERRUPT_NOTIFY", "SEE_DETAIL", "plugin-finder_release"})
  public static enum au
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(266905);
      au localau1 = new au("EXPOSE_RIGHT_UP_CORNER_RED_PACKET_", 0, 1);
      yJR = localau1;
      au localau2 = new au("CLICK_RED_PACKET", 1, 2);
      yJS = localau2;
      au localau3 = new au("CLICK_COMMENT_AREA_RED_PACKET_SYS_MSG", 2, 3);
      yJT = localau3;
      au localau4 = new au("EXPOSE_RED_PACKET_UI", 3, 4);
      yJU = localau4;
      au localau5 = new au("CLICK_OPEN_RED_PACKET", 4, 5);
      yJV = localau5;
      au localau6 = new au("EXPOSE_RED_PACKET_OVER_INTERCEPT_UI", 5, 6);
      yJW = localau6;
      au localau7 = new au("EXPOSE_ONLY_PART_USER_INTERCEPT_UI", 6, 7);
      yJX = localau7;
      au localau8 = new au("RED_PACKET_EXPIRED_NOTIFY", 7, 8);
      yJY = localau8;
      au localau9 = new au("ONLY_WX_IDENTIFY_INTERRUPT_NOTIFY", 8, 9);
      yJZ = localau9;
      au localau10 = new au("SEE_DETAIL", 9, 10);
      yKa = localau10;
      yKb = new au[] { localau1, localau2, localau3, localau4, localau5, localau6, localau7, localau8, localau9, localau10 };
      AppMethodBeat.o(266905);
    }
    
    private au(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RuleType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_RULE_ALREADY_OK", "LIVE_RULE_SHOW", "LIVE_RULE_CHECK_YES", "LIVE_RULE_CHECK_NO", "plugin-finder_release"})
  public static enum av
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(280160);
      av localav1 = new av("LIVE_RULE_ALREADY_OK", 0, 1);
      yKc = localav1;
      av localav2 = new av("LIVE_RULE_SHOW", 1, 2);
      yKd = localav2;
      av localav3 = new av("LIVE_RULE_CHECK_YES", 2, 3);
      yKe = localav3;
      av localav4 = new av("LIVE_RULE_CHECK_NO", 3, 4);
      yKf = localav4;
      yKg = new av[] { localav1, localav2, localav3, localav4 };
      AppMethodBeat.o(280160);
    }
    
    private av(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$SCREEN_SWITCH_ACTION;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "HORIZONTAL_BY_CLICK_BTN", "HORIZONTAL_BY_ROTATE_PHONE", "PORTRAIT_BY_CLICK_BTN", "PORTRAIT_BY_ROTATE_PHONE", "plugin-finder_release"})
  public static enum aw
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(287846);
      aw localaw1 = new aw("HORIZONTAL_BY_CLICK_BTN", 0, 1);
      yKh = localaw1;
      aw localaw2 = new aw("HORIZONTAL_BY_ROTATE_PHONE", 1, 2);
      yKi = localaw2;
      aw localaw3 = new aw("PORTRAIT_BY_CLICK_BTN", 2, 3);
      yKj = localaw3;
      aw localaw4 = new aw("PORTRAIT_BY_ROTATE_PHONE", 3, 4);
      yKk = localaw4;
      yKl = new aw[] { localaw1, localaw2, localaw3, localaw4 };
      AppMethodBeat.o(287846);
    }
    
    private aw(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$SEE_GIFT_LIST;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE", "CLICK_HELF_PAGE_INSTRUCTION", "RETURN_LIVE_ROOM", "CLICK_LIST_ITEM_USER", "EXPOSE_USER_FINDER_HALF_BOARD", "CLICK_PRIVATE_MSG_USER", "CLICK_FOLLOW_USER", "CLICK_COMPLAIN_USER", "CLICK_FORBITTEN_USER", "CLICK_BLACK_USER", "CLICK_ENTER_USER_PROFILE", "plugin-finder_release"})
  public static enum ax
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(250364);
      ax localax1 = new ax("CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE", 0, 1);
      yKm = localax1;
      ax localax2 = new ax("CLICK_HELF_PAGE_INSTRUCTION", 1, 2);
      yKn = localax2;
      ax localax3 = new ax("RETURN_LIVE_ROOM", 2, 3);
      yKo = localax3;
      ax localax4 = new ax("CLICK_LIST_ITEM_USER", 3, 4);
      yKp = localax4;
      ax localax5 = new ax("EXPOSE_USER_FINDER_HALF_BOARD", 4, 5);
      yKq = localax5;
      ax localax6 = new ax("CLICK_PRIVATE_MSG_USER", 5, 6);
      yKr = localax6;
      ax localax7 = new ax("CLICK_FOLLOW_USER", 6, 7);
      yKs = localax7;
      ax localax8 = new ax("CLICK_COMPLAIN_USER", 7, 8);
      yKt = localax8;
      ax localax9 = new ax("CLICK_FORBITTEN_USER", 8, 9);
      yKu = localax9;
      ax localax10 = new ax("CLICK_BLACK_USER", 9, 10);
      yKv = localax10;
      ax localax11 = new ax("CLICK_ENTER_USER_PROFILE", 10, 11);
      yKw = localax11;
      yKx = new ax[] { localax1, localax2, localax3, localax4, localax5, localax6, localax7, localax8, localax9, localax10, localax11 };
      AppMethodBeat.o(250364);
    }
    
    private ax(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenBtnEvent;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "FROM_ONCREATE", "FROM_ONRESUME", "FROM_ONPLUGIN", "plugin-finder_release"})
  public static enum ay
  {
    private final int action;
    
    static
    {
      AppMethodBeat.i(276852);
      ay localay1 = new ay("FROM_ONCREATE", 0, 0);
      yKy = localay1;
      ay localay2 = new ay("FROM_ONRESUME", 1, 1);
      yKz = localay2;
      ay localay3 = new ay("FROM_ONPLUGIN", 2, 2);
      yKA = localay3;
      yKB = new ay[] { localay1, localay2, localay3 };
      AppMethodBeat.o(276852);
    }
    
    private ay(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenDirection;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_SCREEN_PORTRAIT", "LIVE_SCREEN_HORIZONTAL", "plugin-finder_release"})
  public static enum az
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(276410);
      az localaz1 = new az("LIVE_SCREEN_PORTRAIT", 0, 1);
      yKC = localaz1;
      az localaz2 = new az("LIVE_SCREEN_HORIZONTAL", 1, 2);
      yKD = localaz2;
      yKE = new az[] { localaz1, localaz2 };
      AppMethodBeat.o(276410);
    }
    
    private az(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AllCommentType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_ALL_COMMENT_CLOSE", "LIVE_ALL_COMMENT_OPEN", "plugin-finder_release"})
  public static enum b
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(289200);
      b localb1 = new b("LIVE_ALL_COMMENT_CLOSE", 0, 1);
      yEf = localb1;
      b localb2 = new b("LIVE_ALL_COMMENT_OPEN", 1, 2);
      yEg = localb2;
      yEh = new b[] { localb1, localb2 };
      AppMethodBeat.o(289200);
    }
    
    private b(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CHAT", "CHAT_GROUP", "SNS", "plugin-finder_release"})
  public static enum ba
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(289533);
      ba localba1 = new ba("CHAT", 0, 1);
      yKF = localba1;
      ba localba2 = new ba("CHAT_GROUP", 1, 2);
      yKG = localba2;
      ba localba3 = new ba("SNS", 2, 3);
      yKH = localba3;
      yKI = new ba[] { localba1, localba2, localba3 };
      AppMethodBeat.o(289533);
    }
    
    private ba(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ShopPermitAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_NO_SHOP_PERMIT", "LIVE_SHOP_PERMIT_NO_SMALL_STORE", "LIVE_SHOP_PERMIT_SMALL_STORE", "plugin-finder_release"})
  public static enum bb
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(282684);
      bb localbb1 = new bb("LIVE_NO_SHOP_PERMIT", 0, 1);
      yKJ = localbb1;
      bb localbb2 = new bb("LIVE_SHOP_PERMIT_NO_SMALL_STORE", 1, 2);
      yKK = localbb2;
      bb localbb3 = new bb("LIVE_SHOP_PERMIT_SMALL_STORE", 2, 3);
      yKL = localbb3;
      yKM = new bb[] { localbb1, localbb2, localbb3 };
      AppMethodBeat.o(282684);
    }
    
    private bb(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartLiveSource;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "FINDER_PROFILE", "NEARBY_LIVE", "FINDER_PROFILE_RIGHT_CORNER", "plugin-finder_release"})
  public static enum bc
  {
    final int source;
    
    static
    {
      AppMethodBeat.i(282773);
      bc localbc1 = new bc("FINDER_PROFILE", 0, 1);
      yKN = localbc1;
      bc localbc2 = new bc("NEARBY_LIVE", 1, 2);
      yKO = localbc2;
      bc localbc3 = new bc("FINDER_PROFILE_RIGHT_CORNER", 2, 3);
      yKP = localbc3;
      yKQ = new bc[] { localbc1, localbc2, localbc3 };
      AppMethodBeat.o(282773);
    }
    
    private bc(int paramInt)
    {
      this.source = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$StartType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_START_NETWORK_ERROR", "LIVE_START_OK", "plugin-finder_release"})
  public static enum bd
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(288338);
      bd localbd1 = new bd("LIVE_START_NETWORK_ERROR", 0, 1);
      yKR = localbd1;
      bd localbd2 = new bd("LIVE_START_OK", 1, 2);
      yKS = localbd2;
      yKT = new bd[] { localbd1, localbd2 };
      AppMethodBeat.o(288338);
    }
    
    private bd(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisibleRangeType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "PUBLIC", "NUMBER_TO_SEE", "ONLY_ANCHOR_SHARE", "plugin-finder_release"})
  public static enum be
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(291071);
      be localbe1 = new be("PUBLIC", 0, 0);
      yKU = localbe1;
      be localbe2 = new be("NUMBER_TO_SEE", 1, 1);
      yKV = localbe2;
      be localbe3 = new be("ONLY_ANCHOR_SHARE", 2, 2);
      yKW = localbe3;
      yKX = new be[] { localbe1, localbe2, localbe3 };
      AppMethodBeat.o(291071);
    }
    
    private be(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "EnterRoom", "Message", "Like", "CommentExpose", "ComplaintEntry", "Float", "Share", "HideOpearation", "EnterProfile", "CopyComment", "SlideEnter", "Commerce", "QuitRoom", "Auth", "EXPLORE_SCREEN_SWITCH_BTN", "SWITCH_SCREEN", "REPLY", "LOTTERY", "GIFT", "LINKMIC", "NEARBY_LIVE_MORE", "FOLLOW_LIVE", "CLICK_LINKMIC_ANCHOR_AVATAR_TO_LIVING_ROOM", "RED_PACKET", "GAME_TEAM", "CAST_SCREEN", "VISITOR_MUSIC", "ANCHOR_PAUSE_LIVE", "JUMP_TO_OFFICIAL_ACCOUNT", "plugin-finder_release"})
  public static enum bf
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(278377);
      bf localbf1 = new bf("EnterRoom", 0, 1);
      yKY = localbf1;
      bf localbf2 = new bf("Message", 1, 2);
      yKZ = localbf2;
      bf localbf3 = new bf("Like", 2, 3);
      yLa = localbf3;
      bf localbf4 = new bf("CommentExpose", 3, 4);
      yLb = localbf4;
      bf localbf5 = new bf("ComplaintEntry", 4, 5);
      yLc = localbf5;
      bf localbf6 = new bf("Float", 5, 6);
      yLd = localbf6;
      bf localbf7 = new bf("Share", 6, 7);
      yLe = localbf7;
      bf localbf8 = new bf("HideOpearation", 7, 8);
      yLf = localbf8;
      bf localbf9 = new bf("EnterProfile", 8, 9);
      yLg = localbf9;
      bf localbf10 = new bf("CopyComment", 9, 10);
      yLh = localbf10;
      bf localbf11 = new bf("SlideEnter", 10, 11);
      yLi = localbf11;
      bf localbf12 = new bf("Commerce", 11, 12);
      yLj = localbf12;
      bf localbf13 = new bf("QuitRoom", 12, 13);
      yLk = localbf13;
      bf localbf14 = new bf("Auth", 13, 14);
      yLl = localbf14;
      bf localbf15 = new bf("EXPLORE_SCREEN_SWITCH_BTN", 14, 15);
      yLm = localbf15;
      bf localbf16 = new bf("SWITCH_SCREEN", 15, 16);
      yLn = localbf16;
      bf localbf17 = new bf("REPLY", 16, 17);
      yLo = localbf17;
      bf localbf18 = new bf("LOTTERY", 17, 18);
      yLp = localbf18;
      bf localbf19 = new bf("GIFT", 18, 19);
      yLq = localbf19;
      bf localbf20 = new bf("LINKMIC", 19, 20);
      yLr = localbf20;
      bf localbf21 = new bf("NEARBY_LIVE_MORE", 20, 21);
      yLs = localbf21;
      bf localbf22 = new bf("FOLLOW_LIVE", 21, 22);
      yLt = localbf22;
      bf localbf23 = new bf("CLICK_LINKMIC_ANCHOR_AVATAR_TO_LIVING_ROOM", 22, 23);
      yLu = localbf23;
      bf localbf24 = new bf("RED_PACKET", 23, 24);
      yLv = localbf24;
      bf localbf25 = new bf("GAME_TEAM", 24, 25);
      yLw = localbf25;
      bf localbf26 = new bf("CAST_SCREEN", 25, 26);
      yLx = localbf26;
      bf localbf27 = new bf("VISITOR_MUSIC", 26, 27);
      yLy = localbf27;
      bf localbf28 = new bf("ANCHOR_PAUSE_LIVE", 27, 28);
      yLz = localbf28;
      bf localbf29 = new bf("JUMP_TO_OFFICIAL_ACCOUNT", 28, 29);
      yLA = localbf29;
      yLB = new bf[] { localbf1, localbf2, localbf3, localbf4, localbf5, localbf6, localbf7, localbf8, localbf9, localbf10, localbf11, localbf12, localbf13, localbf14, localbf15, localbf16, localbf17, localbf18, localbf19, localbf20, localbf21, localbf22, localbf23, localbf24, localbf25, localbf26, localbf27, localbf28, localbf29 };
      AppMethodBeat.o(278377);
    }
    
    private bf(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorAuthAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "AuthExposure", "AuthEnter", "AuthSucc", "AuthFail", "plugin-finder_release"})
  public static enum bg
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(291265);
      bg localbg1 = new bg("AuthExposure", 0, 1);
      yLC = localbg1;
      bg localbg2 = new bg("AuthEnter", 1, 2);
      yLD = localbg2;
      bg localbg3 = new bg("AuthSucc", 2, 3);
      yLE = localbg3;
      bg localbg4 = new bg("AuthFail", 3, 4);
      yLF = localbg4;
      yLG = new bg[] { localbg1, localbg2, localbg3, localbg4 };
      AppMethodBeat.o(291265);
    }
    
    private bg(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCloseType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CloseTypeFloat", "CloseTypeFull", "CloseTypeKickedOut", "CloseTypeSlide", "CloseTypeOtherRoom", "CloseTypeLiveOver", "plugin-finder_release"})
  public static enum bh
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(267289);
      bh localbh1 = new bh("CloseTypeFloat", 0, 1);
      yLH = localbh1;
      bh localbh2 = new bh("CloseTypeFull", 1, 2);
      yLI = localbh2;
      bh localbh3 = new bh("CloseTypeKickedOut", 2, 3);
      yLJ = localbh3;
      bh localbh4 = new bh("CloseTypeSlide", 3, 4);
      yLK = localbh4;
      bh localbh5 = new bh("CloseTypeOtherRoom", 4, 5);
      yLL = localbh5;
      bh localbh6 = new bh("CloseTypeLiveOver", 5, 6);
      yLM = localbh6;
      yLN = new bh[] { localbh1, localbh2, localbh3, localbh4, localbh5, localbh6 };
      AppMethodBeat.o(267289);
    }
    
    private bh(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCommerceAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CommerceActionBubbleTipShow", "CommerceActionBubbleTipClick", "CommerceActionShoppingButtonClick", "CommerceActionGoodsOrderButtonClick", "CommerceActionGoodsItemClick", "CommerceActionPurchaseButtonClick", "CommerceActionGoodsItemShow", "CommerceActionBubbleTipClose", "CommerceActionAnchorCloseBubble", "CommerceActionExitHalfPage", "plugin-finder_release"})
  public static enum bi
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(268555);
      bi localbi1 = new bi("CommerceActionBubbleTipShow", 0, 1);
      yLO = localbi1;
      bi localbi2 = new bi("CommerceActionBubbleTipClick", 1, 2);
      yLP = localbi2;
      bi localbi3 = new bi("CommerceActionShoppingButtonClick", 2, 3);
      yLQ = localbi3;
      bi localbi4 = new bi("CommerceActionGoodsOrderButtonClick", 3, 4);
      yLR = localbi4;
      bi localbi5 = new bi("CommerceActionGoodsItemClick", 4, 5);
      yLS = localbi5;
      bi localbi6 = new bi("CommerceActionPurchaseButtonClick", 5, 6);
      yLT = localbi6;
      bi localbi7 = new bi("CommerceActionGoodsItemShow", 6, 7);
      yLU = localbi7;
      bi localbi8 = new bi("CommerceActionBubbleTipClose", 7, 8);
      yLV = localbi8;
      bi localbi9 = new bi("CommerceActionAnchorCloseBubble", 8, 9);
      yLW = localbi9;
      bi localbi10 = new bi("CommerceActionExitHalfPage", 9, 10);
      yLX = localbi10;
      yLY = new bi[] { localbi1, localbi2, localbi3, localbi4, localbi5, localbi6, localbi7, localbi8, localbi9, localbi10 };
      AppMethodBeat.o(268555);
    }
    
    private bi(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_LIVE_DEFAULT", "CLICK_LIVE_CARD", "CLICK_LIVE_CARD_AVATAR_LIVING", "CLICK_CARD_AVATAR_LIVING", "CLICK_AVATAR_LIVING", "CLICK_SNSAD_ENTER_LIVE_ROOM", "plugin-finder_release"})
  public static enum bj
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(289711);
      bj localbj1 = new bj("CLICK_LIVE_DEFAULT", 0, 0);
      yLZ = localbj1;
      bj localbj2 = new bj("CLICK_LIVE_CARD", 1, 1);
      yMa = localbj2;
      bj localbj3 = new bj("CLICK_LIVE_CARD_AVATAR_LIVING", 2, 2);
      yMb = localbj3;
      bj localbj4 = new bj("CLICK_CARD_AVATAR_LIVING", 3, 3);
      yMc = localbj4;
      bj localbj5 = new bj("CLICK_AVATAR_LIVING", 4, 4);
      yMd = localbj5;
      bj localbj6 = new bj("CLICK_SNSAD_ENTER_LIVE_ROOM", 5, 5);
      yMe = localbj6;
      yMf = new bj[] { localbj1, localbj2, localbj3, localbj4, localbj5, localbj6 };
      AppMethodBeat.o(289711);
    }
    
    private bj(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorGift;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD", "CLICK_GIFT_BOARD_INNER_GITF", "SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND", "CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI", "SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE", "SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI", "GIFT_ICON_EXPOSURE", "CLICK_HOT_LIST_SEE_CUR_DOU_YOU", "RETURN_GIFT_BOARD_FROM_EXCHARGE_UI", "RETURN_LIVE_ROOM_FROM_GIFT_BOARD", "GIFT_BOARD_TURN_PAGE", "CLICK_VISITOR_IN_HOT_LIST", "CLICK_Y_IN_HOT_LIST", "CLICK_READ_BTN_HOT_LIST", "EXPOSE_HALF_BOARD_HOT_LIST", "CLICK_PROFILE_HOT_LIST", "plugin-finder_release"})
  public static enum bk
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(272151);
      bk localbk1 = new bk("CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD", 0, 1);
      yMg = localbk1;
      bk localbk2 = new bk("CLICK_GIFT_BOARD_INNER_GITF", 1, 2);
      yMh = localbk2;
      bk localbk3 = new bk("SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND", 2, 3);
      yMi = localbk3;
      bk localbk4 = new bk("CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI", 3, 4);
      yMj = localbk4;
      bk localbk5 = new bk("SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE", 4, 5);
      yMk = localbk5;
      bk localbk6 = new bk("SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI", 5, 6);
      yMl = localbk6;
      bk localbk7 = new bk("GIFT_ICON_EXPOSURE", 6, 7);
      yMm = localbk7;
      bk localbk8 = new bk("CLICK_HOT_LIST_SEE_CUR_DOU_YOU", 7, 8);
      yMn = localbk8;
      bk localbk9 = new bk("RETURN_GIFT_BOARD_FROM_EXCHARGE_UI", 8, 9);
      yMo = localbk9;
      bk localbk10 = new bk("RETURN_LIVE_ROOM_FROM_GIFT_BOARD", 9, 10);
      yMp = localbk10;
      bk localbk11 = new bk("GIFT_BOARD_TURN_PAGE", 10, 11);
      yMq = localbk11;
      bk localbk12 = new bk("CLICK_VISITOR_IN_HOT_LIST", 11, 12);
      yMr = localbk12;
      bk localbk13 = new bk("CLICK_Y_IN_HOT_LIST", 12, 13);
      yMs = localbk13;
      bk localbk14 = new bk("CLICK_READ_BTN_HOT_LIST", 13, 14);
      yMt = localbk14;
      bk localbk15 = new bk("EXPOSE_HALF_BOARD_HOT_LIST", 14, 15);
      yMu = localbk15;
      bk localbk16 = new bk("CLICK_PROFILE_HOT_LIST", 15, 18);
      yMv = localbk16;
      yMw = new bk[] { localbk1, localbk2, localbk3, localbk4, localbk5, localbk6, localbk7, localbk8, localbk9, localbk10, localbk11, localbk12, localbk13, localbk14, localbk15, localbk16 };
      AppMethodBeat.o(272151);
    }
    
    private bk(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLinkMicAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "INVALIDATE", "APPLY_LINKMIC", "APPLY_AUDIO_LINKMIC", "APPLY_VIDEO_LINKMIC", "ANCHOR_PASS_LINKMIC_REQUEST", "TIMEOUT_NO_LINK_HUNG_UP", "POPUP_ANCHOR_LINKING_CONFLICT", "ACTIVE_STOP_AUDIO_LINKMIC", "ACTIVE_STOP_VIDEO_LINKMIC", "LINKMIC_ICON_EXPLORE", "CLICK_RED_PACKET", "LINKEMIC_RED_PACKET_SUCCESS", "FAIL_BY_REWARD_SETTING", "FAIL_BY_FOLLOW_SETTING", "FAIL_BY_BUY_PRODUCT_SETTING", "plugin-finder_release"})
  public static enum bl
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(278388);
      bl localbl1 = new bl("INVALIDATE", 0, 0);
      yMx = localbl1;
      bl localbl2 = new bl("APPLY_LINKMIC", 1, 1);
      yMy = localbl2;
      bl localbl3 = new bl("APPLY_AUDIO_LINKMIC", 2, 2);
      yMz = localbl3;
      bl localbl4 = new bl("APPLY_VIDEO_LINKMIC", 3, 3);
      yMA = localbl4;
      bl localbl5 = new bl("ANCHOR_PASS_LINKMIC_REQUEST", 4, 4);
      yMB = localbl5;
      bl localbl6 = new bl("TIMEOUT_NO_LINK_HUNG_UP", 5, 5);
      yMC = localbl6;
      bl localbl7 = new bl("POPUP_ANCHOR_LINKING_CONFLICT", 6, 6);
      yMD = localbl7;
      bl localbl8 = new bl("ACTIVE_STOP_AUDIO_LINKMIC", 7, 7);
      yME = localbl8;
      bl localbl9 = new bl("ACTIVE_STOP_VIDEO_LINKMIC", 8, 8);
      yMF = localbl9;
      bl localbl10 = new bl("LINKMIC_ICON_EXPLORE", 9, 9);
      yMG = localbl10;
      bl localbl11 = new bl("CLICK_RED_PACKET", 10, 10);
      yMH = localbl11;
      bl localbl12 = new bl("LINKEMIC_RED_PACKET_SUCCESS", 11, 11);
      yMI = localbl12;
      bl localbl13 = new bl("FAIL_BY_REWARD_SETTING", 12, 14);
      yMJ = localbl13;
      bl localbl14 = new bl("FAIL_BY_FOLLOW_SETTING", 13, 15);
      yMK = localbl14;
      bl localbl15 = new bl("FAIL_BY_BUY_PRODUCT_SETTING", 14, 16);
      yML = localbl15;
      yMM = new bl[] { localbl1, localbl2, localbl3, localbl4, localbl5, localbl6, localbl7, localbl8, localbl9, localbl10, localbl11, localbl12, localbl13, localbl14, localbl15 };
      AppMethodBeat.o(278388);
    }
    
    private bl(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLotteryType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EXPOSURE_BLESS_BAG", "CLICK_LUCKY_BAG", "CLICK_JOIN_LOTTERY", "SEND_SUCC_COMMENT", "POPUP_TOAST_JOINED", "SHOW_WIN_RESULT_CARD", "CLICK_WIN_LIST", "ENTER_WIN_RECORD_BY_RIGHH_CORNER", "CLICK_WIN_ITEM_ENTER_DETAIL", "CLICK_WIN_DETAIL_ENTER_PRIVATE_UI", "plugin-finder_release"})
  public static enum bm
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(283763);
      bm localbm1 = new bm("EXPOSURE_BLESS_BAG", 0, 1);
      yMN = localbm1;
      bm localbm2 = new bm("CLICK_LUCKY_BAG", 1, 2);
      yMO = localbm2;
      bm localbm3 = new bm("CLICK_JOIN_LOTTERY", 2, 3);
      yMP = localbm3;
      bm localbm4 = new bm("SEND_SUCC_COMMENT", 3, 4);
      yMQ = localbm4;
      bm localbm5 = new bm("POPUP_TOAST_JOINED", 4, 5);
      yMR = localbm5;
      bm localbm6 = new bm("SHOW_WIN_RESULT_CARD", 5, 6);
      yMS = localbm6;
      bm localbm7 = new bm("CLICK_WIN_LIST", 6, 7);
      yMT = localbm7;
      bm localbm8 = new bm("ENTER_WIN_RECORD_BY_RIGHH_CORNER", 7, 8);
      yMU = localbm8;
      bm localbm9 = new bm("CLICK_WIN_ITEM_ENTER_DETAIL", 8, 9);
      yMV = localbm9;
      bm localbm10 = new bm("CLICK_WIN_DETAIL_ENTER_PRIVATE_UI", 9, 10);
      yMW = localbm10;
      yMX = new bm[] { localbm1, localbm2, localbm3, localbm4, localbm5, localbm6, localbm7, localbm8, localbm9, localbm10 };
      AppMethodBeat.o(283763);
    }
    
    private bm(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ExposeProfile", "Book", "Cancle", "ExposeMsg", "Click", "Replace", "plugin-finder_release"})
  public static enum bn
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(286847);
      bn localbn1 = new bn("ExposeProfile", 0, 1);
      yMY = localbn1;
      bn localbn2 = new bn("Book", 1, 2);
      yMZ = localbn2;
      bn localbn3 = new bn("Cancle", 2, 3);
      yNa = localbn3;
      bn localbn4 = new bn("ExposeMsg", 3, 4);
      yNb = localbn4;
      bn localbn5 = new bn("Click", 4, 5);
      yNc = localbn5;
      bn localbn6 = new bn("Replace", 5, 6);
      yNd = localbn6;
      yNe = new bn[] { localbn1, localbn2, localbn3, localbn4, localbn5, localbn6 };
      AppMethodBeat.o(286847);
    }
    
    private bn(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "Chat", "Timeline", "PERSIONAL_STATE_SHARE_SUCC", "plugin-finder_release"})
  public static enum bo
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(267570);
      bo localbo1 = new bo("Chat", 0, 1);
      yNf = localbo1;
      bo localbo2 = new bo("Timeline", 1, 2);
      yNg = localbo2;
      bo localbo3 = new bo("PERSIONAL_STATE_SHARE_SUCC", 2, 5);
      yNh = localbo3;
      yNi = new bo[] { localbo1, localbo2, localbo3 };
      AppMethodBeat.o(267570);
    }
    
    private bo(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorShopBtnState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "NO_EXPOSURE", "EXPOSURE", "plugin-finder_release"})
  public static enum bp
  {
    final int state;
    
    static
    {
      AppMethodBeat.i(257817);
      bp localbp1 = new bp("NO_EXPOSURE", 0, 0);
      yNj = localbp1;
      bp localbp2 = new bp("EXPOSURE", 1, 1);
      yNk = localbp2;
      yNl = new bp[] { localbp1, localbp2 };
      AppMethodBeat.o(257817);
    }
    
    private bp(int paramInt)
    {
      this.state = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorWinResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "WIN", "NO_WIN", "NO_JOIN", "plugin-finder_release"})
  public static enum bq
  {
    public final int result;
    
    static
    {
      AppMethodBeat.i(279467);
      bq localbq1 = new bq("WIN", 0, 1);
      yNm = localbq1;
      bq localbq2 = new bq("NO_WIN", 1, 2);
      yNn = localbq2;
      bq localbq3 = new bq("NO_JOIN", 2, 3);
      yNo = localbq3;
      yNp = new bq[] { localbq1, localbq2, localbq3 };
      AppMethodBeat.o(279467);
    }
    
    private bq(int paramInt)
    {
      this.result = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorActionType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_ANCHOR_ACTION_BEGIN", "LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA", "LIVE_ANCHOR_ACTION_MINIMIZE", "LIVE_ANCHOR_ACTION_COMMENT", "LIVE_ANCHOR_ACTION_BARRAGE", "LIVE_ANCHOR_ACTION_SHARE", "LIVE_ANCHOR_ACTION_AUDIENCE", "LIVE_ANCHOR_ACTION_COMMERCE", "LIVE_ANCHOR_ACTION_OUT", "LIVE_ANCHOR_TOP_COMMENT", "LIVE_ANCHOR_TICKLE", "LIVE_ANCHOR_LOTTERY", "CLICK_FAIRY_STICK", "BEAUTY", "FILTER", "CLICK_MIRROR", "LINKMIC_SWITCH", "LINKMIC_OP", "GIFT_SWITCH", "SEE_GIFT_LIST", "CLICK_LINKMIC_ANCHOR_PROFILE", "LIVE_AUDIO_MODE", "ANCHOR_MUSIC", "ALERT_INFO", "ANCHOR_PAUSE_LIVE", "ANCHOR_BATTLE", "SCREEN_SHARE", "LIVE_BEAUTY", "LIVE_ANCHOR_ACTION_LIKE", "plugin-finder_release"})
  public static enum c
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(280913);
      c localc1 = new c("LIVE_ANCHOR_ACTION_BEGIN", 0, 1);
      yEi = localc1;
      c localc2 = new c("LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA", 1, 2);
      yEj = localc2;
      c localc3 = new c("LIVE_ANCHOR_ACTION_MINIMIZE", 2, 3);
      yEk = localc3;
      c localc4 = new c("LIVE_ANCHOR_ACTION_COMMENT", 3, 4);
      yEl = localc4;
      c localc5 = new c("LIVE_ANCHOR_ACTION_BARRAGE", 4, 5);
      yEm = localc5;
      c localc6 = new c("LIVE_ANCHOR_ACTION_SHARE", 5, 6);
      yEn = localc6;
      c localc7 = new c("LIVE_ANCHOR_ACTION_AUDIENCE", 6, 7);
      yEo = localc7;
      c localc8 = new c("LIVE_ANCHOR_ACTION_COMMERCE", 7, 8);
      yEp = localc8;
      c localc9 = new c("LIVE_ANCHOR_ACTION_OUT", 8, 9);
      yEq = localc9;
      c localc10 = new c("LIVE_ANCHOR_TOP_COMMENT", 9, 10);
      yEr = localc10;
      c localc11 = new c("LIVE_ANCHOR_TICKLE", 10, 11);
      yEs = localc11;
      c localc12 = new c("LIVE_ANCHOR_LOTTERY", 11, 12);
      yEt = localc12;
      c localc13 = new c("CLICK_FAIRY_STICK", 12, 13);
      yEu = localc13;
      c localc14 = new c("BEAUTY", 13, 14);
      yEv = localc14;
      c localc15 = new c("FILTER", 14, 15);
      yEw = localc15;
      c localc16 = new c("CLICK_MIRROR", 15, 16);
      yEx = localc16;
      c localc17 = new c("LINKMIC_SWITCH", 16, 17);
      yEy = localc17;
      c localc18 = new c("LINKMIC_OP", 17, 18);
      yEz = localc18;
      c localc19 = new c("GIFT_SWITCH", 18, 19);
      yEA = localc19;
      c localc20 = new c("SEE_GIFT_LIST", 19, 20);
      yEB = localc20;
      c localc21 = new c("CLICK_LINKMIC_ANCHOR_PROFILE", 20, 21);
      yEC = localc21;
      c localc22 = new c("LIVE_AUDIO_MODE", 21, 23);
      yED = localc22;
      c localc23 = new c("ANCHOR_MUSIC", 22, 24);
      yEE = localc23;
      c localc24 = new c("ALERT_INFO", 23, 26);
      yEF = localc24;
      c localc25 = new c("ANCHOR_PAUSE_LIVE", 24, 27);
      yEG = localc25;
      c localc26 = new c("ANCHOR_BATTLE", 25, 28);
      yEH = localc26;
      c localc27 = new c("SCREEN_SHARE", 26, 29);
      yEI = localc27;
      c localc28 = new c("LIVE_BEAUTY", 27, 30);
      yEJ = localc28;
      c localc29 = new c("LIVE_ANCHOR_ACTION_LIKE", 28, 31);
      yEK = localc29;
      yEL = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localc9, localc10, localc11, localc12, localc13, localc14, localc15, localc16, localc17, localc18, localc19, localc20, localc21, localc22, localc23, localc24, localc25, localc26, localc27, localc28, localc29 };
      AppMethodBeat.o(280913);
    }
    
    private c(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorFloatAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_ENTER_LOTTERY_RECORD", "plugin-finder_release"})
  public static enum d
  {
    public final int action = 6;
    
    static
    {
      AppMethodBeat.i(268018);
      d locald = new d("CLICK_ENTER_LOTTERY_RECORD");
      yEM = locald;
      yEN = new d[] { locald };
      AppMethodBeat.o(268018);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorLiveClose;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ENTER_LIVE_CLOSE_UI", "SEE_GIFT_LIST", "CLICK_FINISH", "plugin-finder_release"})
  public static enum e
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(286423);
      e locale1 = new e("ENTER_LIVE_CLOSE_UI", 0, 1);
      yEO = locale1;
      e locale2 = new e("SEE_GIFT_LIST", 1, 2);
      yEP = locale2;
      e locale3 = new e("CLICK_FINISH", 2, 3);
      yEQ = locale3;
      yER = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(286423);
    }
    
    private e(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorLotteryType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "setType", "(I)V", "CLICK_LOTTERY_ICON", "CLICK_JOIN_CONDITION", "CLICK_ANY_COMMENT", "CLICK_SPECIFY_COMMENT_CONTENT", "CLICK_LIKE", "WRITE_SPECIFY_COMMENT_CONTENT_SUCC", "START_LOTTERY_SUCCESS", "CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT", "CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI", "CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI", "CLICK_LUCKY_BAG", "CANCEL_LOTTERY", "plugin-finder_release"})
  public static enum f
  {
    int type;
    
    static
    {
      AppMethodBeat.i(221743);
      f localf1 = new f("CLICK_LOTTERY_ICON", 0, 1);
      yES = localf1;
      f localf2 = new f("CLICK_JOIN_CONDITION", 1, 2);
      yET = localf2;
      f localf3 = new f("CLICK_ANY_COMMENT", 2, 3);
      yEU = localf3;
      f localf4 = new f("CLICK_SPECIFY_COMMENT_CONTENT", 3, 4);
      yEV = localf4;
      f localf5 = new f("CLICK_LIKE", 4, 5);
      yEW = localf5;
      f localf6 = new f("WRITE_SPECIFY_COMMENT_CONTENT_SUCC", 5, 6);
      yEX = localf6;
      f localf7 = new f("START_LOTTERY_SUCCESS", 6, 7);
      yEY = localf7;
      f localf8 = new f("CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT", 7, 8);
      yEZ = localf8;
      f localf9 = new f("CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI", 8, 9);
      yFa = localf9;
      f localf10 = new f("CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI", 9, 10);
      yFb = localf10;
      f localf11 = new f("CLICK_LUCKY_BAG", 10, 11);
      yFc = localf11;
      f localf12 = new f("CANCEL_LOTTERY", 11, 12);
      yFd = localf12;
      yFe = new f[] { localf1, localf2, localf3, localf4, localf5, localf6, localf7, localf8, localf9, localf10, localf11, localf12 };
      AppMethodBeat.o(221743);
    }
    
    private f(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BattleActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "BATTLE_ACTION_PK_EXPOSE", "BATTLE_ACTION_PK_CLICK", "BATTLE_ACTION_PK_ACCEPT_FROM_TIP", "BATTLE_ACTION_PK_ACCEPT_FROM_PANEL", "BATTLE_ACTION_PK_CANCEL", "BATTLE_ACTION_PK_CANCEL_BY_TIMEOUT", "BATTLE_ACTION_PK_END_RESULT", "BATTLE_ACTION_PK_END_MIC_BREAK", "BATTLE_ACTION_PK_END_LIVE_CLOSE", "BATTLE_ACTION_PK_APPLY_FAIL_BY_VERSION", "plugin-finder_release"})
  public static enum g
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(225024);
      g localg1 = new g("BATTLE_ACTION_PK_EXPOSE", 0, 1);
      yFf = localg1;
      g localg2 = new g("BATTLE_ACTION_PK_CLICK", 1, 2);
      yFg = localg2;
      g localg3 = new g("BATTLE_ACTION_PK_ACCEPT_FROM_TIP", 2, 3);
      yFh = localg3;
      g localg4 = new g("BATTLE_ACTION_PK_ACCEPT_FROM_PANEL", 3, 4);
      yFi = localg4;
      g localg5 = new g("BATTLE_ACTION_PK_CANCEL", 4, 5);
      yFj = localg5;
      g localg6 = new g("BATTLE_ACTION_PK_CANCEL_BY_TIMEOUT", 5, 6);
      yFk = localg6;
      g localg7 = new g("BATTLE_ACTION_PK_END_RESULT", 6, 7);
      yFl = localg7;
      g localg8 = new g("BATTLE_ACTION_PK_END_MIC_BREAK", 7, 8);
      yFm = localg8;
      g localg9 = new g("BATTLE_ACTION_PK_END_LIVE_CLOSE", 8, 9);
      yFn = localg9;
      g localg10 = new g("BATTLE_ACTION_PK_APPLY_FAIL_BY_VERSION", 9, 10);
      yFo = localg10;
      yFp = new g[] { localg1, localg2, localg3, localg4, localg5, localg6, localg7, localg8, localg9, localg10 };
      AppMethodBeat.o(225024);
    }
    
    private g(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BookLiveSrc;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "PROFILE", "PROFILE_RIGHT_CORNER", "plugin-finder_release"})
  public static enum h
  {
    final int source;
    
    static
    {
      AppMethodBeat.i(281539);
      h localh1 = new h("PROFILE", 0, 1);
      yFq = localh1;
      h localh2 = new h("PROFILE_RIGHT_CORNER", 1, 2);
      yFr = localh2;
      yFs = new h[] { localh1, localh2 };
      AppMethodBeat.o(281539);
    }
    
    private h(int paramInt)
    {
      this.source = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CastScreenResult;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CAST_SCREEN_EXPOSE", "CAST_SCREEN_CLICK_MENU", "CAST_SCREEN_DEVICE_EXPOSE", "CAST_SCREEN_CLICK_DEVICE", "CAST_SCREEN_SUCCESS", "CAST_SCREEN_BREAK", "CAST_SCREEN_TIMEOUT", "plugin-finder_release"})
  public static enum i
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(288852);
      i locali1 = new i("CAST_SCREEN_EXPOSE", 0, 1);
      yFt = locali1;
      i locali2 = new i("CAST_SCREEN_CLICK_MENU", 1, 2);
      yFu = locali2;
      i locali3 = new i("CAST_SCREEN_DEVICE_EXPOSE", 2, 3);
      yFv = locali3;
      i locali4 = new i("CAST_SCREEN_CLICK_DEVICE", 3, 4);
      yFw = locali4;
      i locali5 = new i("CAST_SCREEN_SUCCESS", 4, 5);
      yFx = locali5;
      i locali6 = new i("CAST_SCREEN_BREAK", 5, 6);
      yFy = locali6;
      i locali7 = new i("CAST_SCREEN_TIMEOUT", 6, 7);
      yFz = locali7;
      yFA = new i[] { locali1, locali2, locali3, locali4, locali5, locali6, locali7 };
      AppMethodBeat.o(288852);
    }
    
    private i(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ClearScreenAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_CLEAR_SCREEN", "CLICK_CLEAR_SCREEN_CANCEL", "CLICK_CLEAR_SCREEN_MENU", "plugin-finder_release"})
  public static enum j
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(269380);
      j localj1 = new j("CLICK_CLEAR_SCREEN", 0, 1);
      yFB = localj1;
      j localj2 = new j("CLICK_CLEAR_SCREEN_CANCEL", 1, 2);
      yFC = localj2;
      j localj3 = new j("CLICK_CLEAR_SCREEN_MENU", 2, 3);
      yFD = localj3;
      yFE = new j[] { localj1, localj2, localj3 };
      AppMethodBeat.o(269380);
    }
    
    private j(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CloseUISeeGiftList;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "UNDEFINE", "ENTER_UI", "CLICK_FETCH_INCOME", "RETRUN_LIVE_CLOSE_UI", "CLICK_LIST_ITEM_USER", "EXPOSE_USER_FINDER_HALF_BOARD", "CLICK_PRIVATE_MSG_USER", "CLICK_FOLLOW_USER", "CLICK_ENTER_USER_PROFILE", "plugin-finder_release"})
  public static enum k
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(290925);
      k localk1 = new k("UNDEFINE", 0, -1);
      yFF = localk1;
      k localk2 = new k("ENTER_UI", 1, 1);
      yFG = localk2;
      k localk3 = new k("CLICK_FETCH_INCOME", 2, 2);
      yFH = localk3;
      k localk4 = new k("RETRUN_LIVE_CLOSE_UI", 3, 3);
      yFI = localk4;
      k localk5 = new k("CLICK_LIST_ITEM_USER", 4, 4);
      yFJ = localk5;
      k localk6 = new k("EXPOSE_USER_FINDER_HALF_BOARD", 5, 5);
      yFK = localk6;
      k localk7 = new k("CLICK_PRIVATE_MSG_USER", 6, 6);
      yFL = localk7;
      k localk8 = new k("CLICK_FOLLOW_USER", 7, 7);
      yFM = localk8;
      k localk9 = new k("CLICK_ENTER_USER_PROFILE", 8, 8);
      yFN = localk9;
      yFO = new k[] { localk1, localk2, localk3, localk4, localk5, localk6, localk7, localk8, localk9 };
      AppMethodBeat.o(290925);
    }
    
    private k(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CommentSceneExtend;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW", "COMMENT_SCENE_LIVE_ROOM_SLIDE", "COMMENT_SCENE_SEARCH_MORE_CONTACT", "COMMENT_SCENE_SEARCH_RESULT_FLOW", "COMMENT_SCENE_PROFILE_PAGE", "COMMENT_SCENE_SHARE_PAGE", "COMMENT_SCENE_BOOK_NOTIFY", "COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW", "COMMENT_SCENE_LBS_TOP_LIVE_CARD", "COMMENT_SCENE_SEARCH_1_SEARCH", "COMMENT_SCENE_PUBLIC_NUMBER", "COMMENT_SCENE_APPBRAN", "COMMENT_SCENE_SEE_1_SEE", "COMMENT_SCENE_PULLDOWN_MENU", "COMMENT_SCENE_SLEF_STATUS", "COMMENT_SCENE_RED_PACKET_MSG_IN_GOUR_CHAT", "COMMENT_SCENE_NEARBY_LIVE_REDDOT", "plugin-finder_release"})
  public static enum l
  {
    public final String scene;
    
    static
    {
      AppMethodBeat.i(282053);
      l locall1 = new l("COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW", 0, "temp_1");
      yFP = locall1;
      l locall2 = new l("COMMENT_SCENE_LIVE_ROOM_SLIDE", 1, "temp_2");
      yFQ = locall2;
      l locall3 = new l("COMMENT_SCENE_SEARCH_MORE_CONTACT", 2, "temp_3");
      yFR = locall3;
      l locall4 = new l("COMMENT_SCENE_SEARCH_RESULT_FLOW", 3, "temp_4");
      yFS = locall4;
      l locall5 = new l("COMMENT_SCENE_PROFILE_PAGE", 4, "temp_5");
      yFT = locall5;
      l locall6 = new l("COMMENT_SCENE_SHARE_PAGE", 5, "temp_6");
      yFU = locall6;
      l locall7 = new l("COMMENT_SCENE_BOOK_NOTIFY", 6, "temp_7");
      yFV = locall7;
      l locall8 = new l("COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW", 7, "temp_9");
      yFW = locall8;
      l locall9 = new l("COMMENT_SCENE_LBS_TOP_LIVE_CARD", 8, "temp_10");
      yFX = locall9;
      l locall10 = new l("COMMENT_SCENE_SEARCH_1_SEARCH", 9, "temp_11");
      yFY = locall10;
      l locall11 = new l("COMMENT_SCENE_PUBLIC_NUMBER", 10, "temp_12");
      yFZ = locall11;
      l locall12 = new l("COMMENT_SCENE_APPBRAN", 11, "temp_13");
      yGa = locall12;
      l locall13 = new l("COMMENT_SCENE_SEE_1_SEE", 12, "temp_14");
      yGb = locall13;
      l locall14 = new l("COMMENT_SCENE_PULLDOWN_MENU", 13, "temp_15");
      yGc = locall14;
      l locall15 = new l("COMMENT_SCENE_SLEF_STATUS", 14, "temp_16");
      yGd = locall15;
      l locall16 = new l("COMMENT_SCENE_RED_PACKET_MSG_IN_GOUR_CHAT", 15, "temp_17");
      yGe = locall16;
      l locall17 = new l("COMMENT_SCENE_NEARBY_LIVE_REDDOT", 16, "temp_18");
      yGf = locall17;
      yGg = new l[] { locall1, locall2, locall3, locall4, locall5, locall6, locall7, locall8, locall9, locall10, locall11, locall12, locall13, locall14, locall15, locall16, locall17 };
      AppMethodBeat.o(282053);
    }
    
    private l(String paramString)
    {
      this.scene = paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ComplaintVisitorSource;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "COMMENT_ZONE", "HOT_LIST", "plugin-finder_release"})
  public static enum m
  {
    public final int source;
    
    static
    {
      AppMethodBeat.i(281434);
      m localm1 = new m("COMMENT_ZONE", 0, 1);
      yGh = localm1;
      m localm2 = new m("HOT_LIST", 1, 2);
      yGi = localm2;
      yGj = new m[] { localm1, localm2 };
      AppMethodBeat.o(281434);
    }
    
    private m(int paramInt)
    {
      this.source = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CoverType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_COVER_ALBUM_CANCEL", "LIVE_COVER_SHOOT_FRONT_TAKEN", "LIVE_COVER_SHOOT_BACK_TAKEN", "LIVE_COVER_ALBUM_TAKEN", "plugin-finder_release"})
  public static enum n
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(223453);
      n localn1 = new n("LIVE_COVER_ALBUM_CANCEL", 0, 5);
      yGk = localn1;
      n localn2 = new n("LIVE_COVER_SHOOT_FRONT_TAKEN", 1, 6);
      yGl = localn2;
      n localn3 = new n("LIVE_COVER_SHOOT_BACK_TAKEN", 2, 7);
      yGm = localn3;
      n localn4 = new n("LIVE_COVER_ALBUM_TAKEN", 3, 8);
      yGn = localn4;
      yGo = new n[] { localn1, localn2, localn3, localn4 };
      AppMethodBeat.o(223453);
    }
    
    private n(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CoverType2;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_COVER_DEFAULT", "LIVE_COVER_FRONT_CAMERA", "LIVE_COVER_ALBUM", "plugin-finder_release"})
  public static enum o
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(286498);
      o localo1 = new o("LIVE_COVER_DEFAULT", 0, 0);
      yGp = localo1;
      o localo2 = new o("LIVE_COVER_FRONT_CAMERA", 1, 6);
      yGq = localo2;
      o localo3 = new o("LIVE_COVER_ALBUM", 2, 8);
      yGr = localo3;
      yGs = new o[] { localo1, localo2, localo3 };
      AppMethodBeat.o(286498);
    }
    
    private o(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementClickId;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "FOLLOW_ICON", "FOLLOW_GUIDE_LEAVE_ICON", "FOLLOW_GUIDE_LEAVE_FOLLOW", "plugin-finder_release"})
  public static enum p
  {
    final String id;
    
    static
    {
      AppMethodBeat.i(289736);
      p localp1 = new p("FOLLOW_ICON", 0, "follow_icon");
      yGt = localp1;
      p localp2 = new p("FOLLOW_GUIDE_LEAVE_ICON", 1, "follow_guide_leave_icon");
      yGu = localp2;
      p localp3 = new p("FOLLOW_GUIDE_LEAVE_FOLLOW", 2, "follow_guide_leave_follow");
      yGv = localp3;
      yGw = new p[] { localp1, localp2, localp3 };
      AppMethodBeat.o(289736);
    }
    
    private p(String paramString)
    {
      this.id = paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementExposeId;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "FOLLOW_ICON", "FOLLOW_GUIDE_PAGE", "FOLLOW_GUIDE_LEAVE_ICON", "FOLLOW_GUIDE_LEAVE_FOLLOW", "plugin-finder_release"})
  public static enum q
  {
    final String id;
    
    static
    {
      AppMethodBeat.i(253608);
      q localq1 = new q("FOLLOW_ICON", 0, "follow_icon");
      yGx = localq1;
      q localq2 = new q("FOLLOW_GUIDE_PAGE", 1, "follow_guide_page");
      yGy = localq2;
      q localq3 = new q("FOLLOW_GUIDE_LEAVE_ICON", 2, "follow_guide_leave_icon");
      yGz = localq3;
      q localq4 = new q("FOLLOW_GUIDE_LEAVE_FOLLOW", 3, "follow_guide_leave_follow");
      yGA = localq4;
      yGB = new q[] { localq1, localq2, localq3, localq4 };
      AppMethodBeat.o(253608);
    }
    
    private q(String paramString)
    {
      this.id = paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EnterRoomStatus;", "", "status", "", "(Ljava/lang/String;IJ)V", "getStatus", "()J", "LIVE_LIVING", "LIVE_STOPPED", "LIVE_IN_BLACK_LIST", "LIVE_NO_ACCESS_PERMISSION", "plugin-finder_release"})
  public static enum r
  {
    public final long status;
    
    static
    {
      AppMethodBeat.i(285005);
      r localr1 = new r("LIVE_LIVING", 0, 1L);
      yGC = localr1;
      r localr2 = new r("LIVE_STOPPED", 1, 2L);
      yGD = localr2;
      r localr3 = new r("LIVE_IN_BLACK_LIST", 2, 5L);
      yGE = localr3;
      r localr4 = new r("LIVE_NO_ACCESS_PERMISSION", 3, 6L);
      yGF = localr4;
      yGG = new r[] { localr1, localr2, localr3, localr4 };
      AppMethodBeat.o(285005);
    }
    
    private r(long paramLong)
    {
      this.status = paramLong;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "LIVE_EXIT_OK", "LIVE_EXIT_ERROR", "LIVE_EXIT_CANCEL_TIMER", "LIVE_EXIT_NOTHING", "plugin-finder_release"})
  public static enum s
  {
    final long fwf;
    
    static
    {
      AppMethodBeat.i(291126);
      s locals1 = new s("LIVE_EXIT_OK", 0, 1L);
      yGH = locals1;
      s locals2 = new s("LIVE_EXIT_ERROR", 1, 2L);
      yGI = locals2;
      s locals3 = new s("LIVE_EXIT_CANCEL_TIMER", 2, 3L);
      yGJ = locals3;
      s locals4 = new s("LIVE_EXIT_NOTHING", 3, 4L);
      yGK = locals4;
      yGL = new s[] { locals1, locals2, locals3, locals4 };
      AppMethodBeat.o(291126);
    }
    
    private s(long paramLong)
    {
      this.fwf = paramLong;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR", "LIVE_AUDIENCE_EXPLORE_FEED_CARD", "LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR", "LIVE_AUDIENCE_CLICK_SINGLE_AVATAR", "LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR", "LIVE_AUDIENCE_ENTER_LIVE_ROOM", "LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL", "LIVE_AUDIENCE_CLICK_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING", "CLICK_ENTER_LINKMIC_ANCHOR_PROFILE", "LIVE_EXPOSE_MORE_LIVE", "LIVE_CLICK_MORE_LIVE", "plugin-finder_release"})
  public static enum t
  {
    public final long fwf;
    
    static
    {
      AppMethodBeat.i(284854);
      t localt1 = new t("LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR", 0, 1L);
      yGM = localt1;
      t localt2 = new t("LIVE_AUDIENCE_EXPLORE_FEED_CARD", 1, 2L);
      yGN = localt2;
      t localt3 = new t("LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR", 2, 3L);
      yGO = localt3;
      t localt4 = new t("LIVE_AUDIENCE_CLICK_SINGLE_AVATAR", 3, 4L);
      yGP = localt4;
      t localt5 = new t("LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING", 4, 5L);
      yGQ = localt5;
      t localt6 = new t("LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR", 5, 6L);
      yGR = localt6;
      t localt7 = new t("LIVE_AUDIENCE_ENTER_LIVE_ROOM", 6, 7L);
      yGS = localt7;
      t localt8 = new t("LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL", 7, 8L);
      yGT = localt8;
      t localt9 = new t("LIVE_AUDIENCE_CLICK_AVATAR_LIVING", 8, 9L);
      yGU = localt9;
      t localt10 = new t("LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING", 9, 10L);
      yGV = localt10;
      t localt11 = new t("LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING", 10, 11L);
      yGW = localt11;
      t localt12 = new t("CLICK_ENTER_LINKMIC_ANCHOR_PROFILE", 11, 23L);
      yGX = localt12;
      t localt13 = new t("LIVE_EXPOSE_MORE_LIVE", 12, 12L);
      yGY = localt13;
      t localt14 = new t("LIVE_CLICK_MORE_LIVE", 13, 13L);
      yGZ = localt14;
      yHa = new t[] { localt1, localt2, localt3, localt4, localt5, localt6, localt7, localt8, localt9, localt10, localt11, localt12, localt13, localt14 };
      AppMethodBeat.o(284854);
    }
    
    private t(long paramLong)
    {
      this.fwf = paramLong;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FilterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ORIGINAL_FILM", "NATURAL", "WHITE", "NOSTALGIA", "AUTUMN", "DELICIOUS", "BLUE", "FILM", "HONGKKONG_STYLE", "plugin-finder_release"})
  public static enum u
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(280235);
      u localu1 = new u("ORIGINAL_FILM", 0, 1);
      yHb = localu1;
      u localu2 = new u("NATURAL", 1, 2);
      yHc = localu2;
      u localu3 = new u("WHITE", 2, 3);
      yHd = localu3;
      u localu4 = new u("NOSTALGIA", 3, 4);
      yHe = localu4;
      u localu5 = new u("AUTUMN", 4, 5);
      yHf = localu5;
      u localu6 = new u("DELICIOUS", 5, 6);
      yHg = localu6;
      u localu7 = new u("BLUE", 6, 7);
      yHh = localu7;
      u localu8 = new u("FILM", 7, 8);
      yHi = localu8;
      u localu9 = new u("HONGKKONG_STYLE", 8, 9);
      yHj = localu9;
      yHk = new u[] { localu1, localu2, localu3, localu4, localu5, localu6, localu7, localu8, localu9 };
      AppMethodBeat.o(280235);
    }
    
    private u(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FloatActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_FLOAT_ACTION_UNKNOWN", "LIVE_FLOAT_ACTION_MAXIMIZE", "LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION", "LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE", "LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP", "LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG", "LIVE_FLOAT_ACTION_ENTER_PROFILE", "VISITOR_CLICK_ENTER_LOTTERY_RECORD", "plugin-finder_release"})
  public static enum v
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(275842);
      v localv1 = new v("LIVE_FLOAT_ACTION_UNKNOWN", 0, 0);
      yHl = localv1;
      v localv2 = new v("LIVE_FLOAT_ACTION_MAXIMIZE", 1, 1);
      yHm = localv2;
      v localv3 = new v("LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION", 2, 2);
      yHn = localv3;
      v localv4 = new v("LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE", 3, 3);
      yHo = localv4;
      v localv5 = new v("LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP", 4, 4);
      yHp = localv5;
      v localv6 = new v("LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG", 5, 5);
      yHq = localv6;
      v localv7 = new v("LIVE_FLOAT_ACTION_ENTER_PROFILE", 6, 6);
      yHr = localv7;
      v localv8 = new v("VISITOR_CLICK_ENTER_LOTTERY_RECORD", 7, 7);
      yHs = localv8;
      yHt = new v[] { localv1, localv2, localv3, localv4, localv5, localv6, localv7, localv8 };
      AppMethodBeat.o(275842);
    }
    
    private v(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FollowBtnAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "EXPOSE", "CLICK_2_FOLLOW", "CLICK_2_PROFILE", "plugin-finder_release"})
  public static enum w
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(277518);
      w localw1 = new w("EXPOSE", 0, 1);
      yHu = localw1;
      w localw2 = new w("CLICK_2_FOLLOW", 1, 2);
      yHv = localw2;
      w localw3 = new w("CLICK_2_PROFILE", 2, 3);
      yHw = localw3;
      yHx = new w[] { localw1, localw2, localw3 };
      AppMethodBeat.o(277518);
    }
    
    private w(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FollowState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "UNFOLLOW", "FOLLOWED", "plugin-finder_release"})
  public static enum x
  {
    public final int state;
    
    static
    {
      AppMethodBeat.i(248448);
      x localx1 = new x("UNFOLLOW", 0, 0);
      yHy = localx1;
      x localx2 = new x("FOLLOWED", 1, 1);
      yHz = localx2;
      yHA = new x[] { localx1, localx2 };
      AppMethodBeat.o(248448);
    }
    
    private x(int paramInt)
    {
      this.state = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GIFT_SWITCCH;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLOSE_SEND_GIFT_BY_MORE", "OPEN_SEND_GIFT_BY_MORE", "plugin-finder_release"})
  public static enum y
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(244969);
      y localy1 = new y("CLOSE_SEND_GIFT_BY_MORE", 0, 1);
      yHB = localy1;
      y localy2 = new y("OPEN_SEND_GIFT_BY_MORE", 1, 2);
      yHC = localy2;
      yHD = new y[] { localy1, localy2 };
      AppMethodBeat.o(244969);
    }
    
    private y(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GiftSwitch;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "BY_MORE_CLOSE_GIFT", "BY_MORE_OPEN_GIFT", "plugin-finder_release"})
  public static enum z
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(276471);
      z localz1 = new z("BY_MORE_CLOSE_GIFT", 0, 1);
      yHE = localz1;
      z localz2 = new z("BY_MORE_OPEN_GIFT", 1, 2);
      yHF = localz2;
      yHG = new z[] { localz1, localz2 };
      AppMethodBeat.o(276471);
    }
    
    private z(int paramInt)
    {
      this.action = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.s
 * JD-Core Version:    0.7.0.1
 */