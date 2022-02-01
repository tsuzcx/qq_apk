package com.tencent.mm.plugin.finder.report.live;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.d.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.d;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig;", "", "()V", "TAG", "", "addProductAction", "", "getAddProductAction", "()Z", "setAddProductAction", "(Z)V", "bookLiveSrc", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$BookLiveSrc;", "getBookLiveSrc", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$BookLiveSrc;", "setBookLiveSrc", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$BookLiveSrc;)V", "cacheExitEvent_21024", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;", "getCacheExitEvent_21024", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;", "setCacheExitEvent_21024", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;)V", "closeLinkMicAudioByVisitor", "getCloseLinkMicAudioByVisitor", "setCloseLinkMicAudioByVisitor", "closeLinkMicVideoByVisitor", "getCloseLinkMicVideoByVisitor", "setCloseLinkMicVideoByVisitor", "commentSceneOnFinderHome", "", "getCommentSceneOnFinderHome", "()I", "setCommentSceneOnFinderHome", "(I)V", "coverType", "getCoverType", "setCoverType", "curLikeNumber", "", "getCurLikeNumber", "()J", "setCurLikeNumber", "(J)V", "curLiveDuration", "getCurLiveDuration", "setCurLiveDuration", "curLiveNumber", "getCurLiveNumber", "setCurLiveNumber", "curProductIds", "Ljava/util/LinkedList;", "getCurProductIds", "()Ljava/util/LinkedList;", "setCurProductIds", "(Ljava/util/LinkedList;)V", "curRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "getCurRecyclerViewRef", "()Ljava/lang/ref/WeakReference;", "setCurRecyclerViewRef", "(Ljava/lang/ref/WeakReference;)V", "desc", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "description", "getDescription", "enterSessionId", "getEnterSessionId", "setEnterSessionId", "errCode", "getErrCode", "setErrCode", "filterType", "getFilterType", "setFilterType", "filterValue", "getFilterValue", "setFilterValue", "fromWeconHotUI", "getFromWeconHotUI", "setFromWeconHotUI", "gCurCommentscene_temp", "getGCurCommentscene_temp", "setGCurCommentscene_temp", "gCurLiveFeedPos", "getGCurLiveFeedPos", "setGCurLiveFeedPos", "gCurShopAppId", "gCurShopSessionId", "gLinkMicCount", "getGLinkMicCount", "setGLinkMicCount", "gLinkMicTimeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/vending/tuple/Tuple3;", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkType;", "Lkotlin/collections/ArrayList;", "getGLinkMicTimeList", "()Ljava/util/ArrayList;", "gLiveFeedFragmentPageMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGLiveFeedFragmentPageMap", "()Ljava/util/HashMap;", "gLiveFeedPageMap", "getGLiveFeedPageMap", "gSceneNote", "getGSceneNote", "setGSceneNote", "getContactFromMemberList", "getGetContactFromMemberList", "setGetContactFromMemberList", "isEnterFromFloat", "setEnterFromFloat", "isExitToFloat", "setExitToFloat", "isGift", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$IsGift;", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$IsGift;", "setGift", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$IsGift;)V", "launcherSrc", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartLiveSource;", "getLauncherSrc", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartLiveSource;", "setLauncherSrc", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartLiveSource;)V", "linkMicStateOnPre", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkSwitch;", "getLinkMicStateOnPre", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkSwitch;", "setLinkMicStateOnPre", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkSwitch;)V", "livePageTypeWhenEnter", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyPageType;", "getLivePageTypeWhenEnter", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyPageType;", "setLivePageTypeWhenEnter", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyPageType;)V", "liveStaticsData_21056", "Lcom/tencent/mm/plugin/finder/report/live/LiveStaticsData_21056;", "getLiveStaticsData_21056", "()Lcom/tencent/mm/plugin/finder/report/live/LiveStaticsData_21056;", "setLiveStaticsData_21056", "(Lcom/tencent/mm/plugin/finder/report/live/LiveStaticsData_21056;)V", "mAnchorLotteryCount", "getMAnchorLotteryCount", "setMAnchorLotteryCount", "mClickLotteryHistroy", "getMClickLotteryHistroy", "setMClickLotteryHistroy", "mClickLotteryIcon", "getMClickLotteryIcon", "setMClickLotteryIcon", "morpyEyes", "getMorpyEyes", "setMorpyEyes", "morpyFace", "getMorpyFace", "setMorpyFace", "nearbyCommenScene", "getNearbyCommenScene", "setNearbyCommenScene", "poiJSONObject", "Lorg/json/JSONObject;", "getPoiJSONObject", "()Lorg/json/JSONObject;", "setPoiJSONObject", "(Lorg/json/JSONObject;)V", "positionLiveFeedOnfull", "getPositionLiveFeedOnfull", "setPositionLiveFeedOnfull", "promoting", "getPromoting", "setPromoting", "rosy", "getRosy", "setRosy", "ruleType", "getRuleType", "setRuleType", "sessionBufOnTemp2", "getSessionBufOnTemp2", "setSessionBufOnTemp2", "shopAppId", "getShopAppId", "skinWhitening", "getSkinWhitening", "setSkinWhitening", "smoothFace", "getSmoothFace", "setSmoothFace", "startLiveSource", "getStartLiveSource", "setStartLiveSource", "startLiveVideo", "getStartLiveVideo", "setStartLiveVideo", "subTag", "getSubTag", "setSubTag", "tag", "getTag", "setTag", "timestampOfEnterLiveAnchorUI", "getTimestampOfEnterLiveAnchorUI", "setTimestampOfEnterLiveAnchorUI", "visibleRange", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisibleRangeType;", "getVisibleRange", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisibleRangeType;", "setVisibleRange", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisibleRangeType;)V", "visibleRangeNum", "getVisibleRangeNum", "setVisibleRangeNum", "visitorEnterType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "getVisitorEnterType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "setVisitorEnterType", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;)V", "getAnchorFeedId", "getAnchorLiveId", "getEnterIconType", "commenScene", "defVal", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FilterType;", "filterPath", "getFinderUserName", "getPoi", "getPromoteGoodsStr", "getSessionPageId", "getdesc", "isPrivate", "isPrivateAccount4Visitor", "userName", "resetSomeData", "", "setShopParams", "shopSessionId", "clickType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "stopPromoteGood", "productId", "stopPromoteGoods", "ActionType", "AllCommentType", "AnchorActionType", "AnchorFloatAction", "AnchorLiveClose", "AnchorLotteryType", "BookLiveSrc", "ClearScreenAction", "CloseUISeeGiftList", "CommentSceneExtend", "ComplaintVisitorSource", "CoverType", "CoverType2", "EnterRoomStatus", "ExitType", "ExploreType", "FilterType", "FloatActionType", "FollowState", "GIFT_SWITCCH", "GiftSwitch", "IsGift", "JspiCommenScene", "LinkOp", "LinkSwitch", "LinkType", "LiveAnchorCommerceAction", "LiveBookAction", "LivePersonalAction", "LiveVerified", "Live_Enter_Type", "NearbyAction2", "NearbyMoreActionResult", "NearbyPageType", "RuleType", "SCREEN_SWITCH_ACTION", "SEE_GIFT_LIST", "ScreenBtnEvent", "ScreenDirection", "ShopPermitAction", "StartLiveSource", "StartType", "VisibleRangeType", "VisitorAction", "VisitorAuthAction", "VisitorCloseType", "VisitorCommerceAction", "VisitorEnterType", "VisitorGift", "VisitorLinkMicAction", "VisitorLotteryType", "VisitorNoticeAction", "VisitorShareType", "VisitorShopBtnState", "VisitorWinResult", "plugin-finder_release"})
public final class s
{
  private final String TAG;
  String desc;
  int errCode;
  int hDg;
  int hDk;
  String tag;
  final ArrayList<d<z, Long, Boolean>> vkW;
  long vlA;
  public boolean vlB;
  public boolean vlC;
  int vlD;
  int vlE;
  int vlF;
  int vlG;
  int vlH;
  int vlI;
  public String vlJ;
  public boolean vlK;
  y vlL;
  public boolean vlM;
  v vlN;
  long vlO;
  boolean vlP;
  public int vlQ;
  public int vlR;
  public String vlS;
  String vlT;
  ao vlU;
  public String vlV;
  aq vlW;
  public long vlX;
  public final HashMap<String, String> vlY;
  public final HashMap<String, String> vlZ;
  public String vlv;
  public long vlw;
  public boolean vlx;
  public String vly;
  public String vlz;
  public av vma;
  o vmb;
  long vmc;
  long vmd;
  JSONObject vme;
  int vmf;
  public long vmg;
  public long vmh;
  public long vmi;
  public u vmj;
  public boolean vmk;
  public boolean vml;
  public boolean vmm;
  public boolean vmn;
  public boolean vmo;
  public LinkedList<Long> vmp;
  public WeakReference<RecyclerView> vmq;
  ah vmr;
  ao vms;
  public g vmt;
  
  public s()
  {
    AppMethodBeat.i(251205);
    this.TAG = "HABBYGE-MALI.LiveReportConfig";
    this.vlv = "";
    this.vly = "";
    this.vlz = "";
    this.vkW = new ArrayList();
    this.vlJ = "";
    this.vlL = y.vpC;
    this.vlN = v.vpo;
    this.vlS = "";
    this.tag = "";
    this.vlT = "";
    this.vlU = ao.vqX;
    this.vlV = "";
    this.vlW = aq.vre;
    this.vlY = ae.g(new kotlin.o[] { new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", "1"), new kotlin.o("FinderProfileTimeLineUI", "1"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI", "16"), new kotlin.o("FinderLbsStreamListUI", "16"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderFollowListUI", "12"), new kotlin.o("FinderFollowListUI", "12"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", "27"), new kotlin.o("FinderTopicTimelineUI", "27"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "25"), new kotlin.o("FinderShareFeedRelUI", "25"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", "2"), new kotlin.o("FinderLikedFeedUI", "2"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", "21"), new kotlin.o("FinderFavTimelineUI", "21"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI", "40"), new kotlin.o("FinderFeedRelatedTimelineUI", "40"), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "23"), new kotlin.o("FinderMixSearchUI", "23"), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderContactSearchUI", j.vnP.scene), new kotlin.o("FinderContactSearchUI", j.vnP.scene), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", "6"), new kotlin.o("FinderFeedSearchUI", "6") });
    this.vlZ = ae.g(new kotlin.o[] { new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", "17"), new kotlin.o("FinderFollowTabFragment", "17"), new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", "18"), new kotlin.o("FinderFriendTabFragment", "18"), new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", "20"), new kotlin.o("FinderMachineTabFragment", "20") });
    this.vma = av.vsc;
    this.vmb = o.vox;
    this.vmd = 1L;
    this.vmf = m.vol.type;
    this.vmj = new u();
    this.vmp = new LinkedList();
    this.vmr = ah.vqu;
    this.vms = ao.vqX;
    this.vmt = g.vnC;
    AppMethodBeat.o(251205);
  }
  
  public static long as(String paramString, long paramLong)
  {
    AppMethodBeat.i(251204);
    if ((p.j(paramString, j.voa.scene)) || (p.j(paramString, j.vob.scene)) || (p.j(paramString, w.vpq.type)) || (p.j(paramString, w.vpr.type)) || (p.j(paramString, w.vpu.type)) || (p.j(paramString, w.vps.type)))
    {
      paramLong = av.vsg.type;
      AppMethodBeat.o(251204);
      return paramLong;
    }
    p.j(paramString, w.vpt.type);
    AppMethodBeat.o(251204);
    return paramLong;
  }
  
  public static q auT(String paramString)
  {
    AppMethodBeat.i(251191);
    a locala = a.hEN;
    int i = a.GD(paramString);
    paramString = e.e.hxP;
    if (i == e.e.aCF())
    {
      paramString = q.voM;
      AppMethodBeat.o(251191);
      return paramString;
    }
    paramString = e.e.hxP;
    if (i == e.e.aCG())
    {
      paramString = q.voN;
      AppMethodBeat.o(251191);
      return paramString;
    }
    paramString = e.e.hxP;
    if (i == e.e.aCM())
    {
      paramString = q.voO;
      AppMethodBeat.o(251191);
      return paramString;
    }
    paramString = e.e.hxP;
    if (i == e.e.aCH())
    {
      paramString = q.voP;
      AppMethodBeat.o(251191);
      return paramString;
    }
    paramString = e.e.hxP;
    if (i == e.e.aCI())
    {
      paramString = q.voQ;
      AppMethodBeat.o(251191);
      return paramString;
    }
    paramString = e.e.hxP;
    if (i == e.e.aCK())
    {
      paramString = q.voS;
      AppMethodBeat.o(251191);
      return paramString;
    }
    paramString = e.e.hxP;
    if (i == e.e.aCL())
    {
      paramString = q.voT;
      AppMethodBeat.o(251191);
      return paramString;
    }
    paramString = e.e.hxP;
    if (i == e.e.aCJ())
    {
      paramString = q.voR;
      AppMethodBeat.o(251191);
      return paramString;
    }
    paramString = q.voL;
    AppMethodBeat.o(251191);
    return paramString;
  }
  
  public static int auU(String paramString)
  {
    AppMethodBeat.i(251198);
    if (paramString == null)
    {
      AppMethodBeat.o(251198);
      return 0;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.c.tsp;
    paramString = c.a.asG(paramString);
    localObject = y.vXH;
    if (y.i(paramString))
    {
      AppMethodBeat.o(251198);
      return 1;
    }
    AppMethodBeat.o(251198);
    return 0;
  }
  
  public static String dps()
  {
    AppMethodBeat.i(251197);
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(251197);
    return str1;
  }
  
  public static String dpt()
  {
    AppMethodBeat.i(251199);
    String str2 = z.aUg();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(251199);
    return str1;
  }
  
  public static int dpu()
  {
    AppMethodBeat.i(251200);
    Object localObject1 = dpt();
    Object localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
    localObject1 = c.a.asG((String)localObject1);
    localObject2 = y.vXH;
    if (y.i((com.tencent.mm.plugin.finder.api.g)localObject1))
    {
      AppMethodBeat.o(251200);
      return 1;
    }
    AppMethodBeat.o(251200);
    return 0;
  }
  
  public static String getDescription()
  {
    AppMethodBeat.i(251192);
    Object localObject = com.tencent.mm.plugin.finder.live.model.o.ujN;
    localObject = com.tencent.mm.plugin.finder.live.model.o.dfZ();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDm;
      if (localObject != null)
      {
        String str = ((FinderObjectDesc)localObject).description;
        localObject = str;
        if (str != null) {
          break label42;
        }
      }
    }
    localObject = "";
    label42:
    p.g(localObject, "FinderLiveService.curLiv…Object?.description ?: \"\"");
    localObject = q.encode((String)localObject, "UTF-8");
    p.g(localObject, "URLEncoder.encode(text, \"UTF-8\")");
    AppMethodBeat.o(251192);
    return localObject;
  }
  
  public final void a(ah paramah)
  {
    AppMethodBeat.i(251202);
    p.h(paramah, "<set-?>");
    this.vmr = paramah;
    AppMethodBeat.o(251202);
  }
  
  public final void a(ao paramao)
  {
    AppMethodBeat.i(251188);
    p.h(paramao, "<set-?>");
    this.vlU = paramao;
    AppMethodBeat.o(251188);
  }
  
  public final void a(aq paramaq)
  {
    AppMethodBeat.i(251189);
    p.h(paramaq, "<set-?>");
    this.vlW = paramaq;
    AppMethodBeat.o(251189);
  }
  
  public final void a(p paramp, String paramString)
  {
    AppMethodBeat.i(251190);
    p.h(paramp, "clickType");
    p.h(paramString, "commenScene");
    switch (t.$EnumSwitchMapping$0[paramp.ordinal()])
    {
    default: 
      this.vma = av.vsb;
      AppMethodBeat.o(251190);
      return;
    case 1: 
    case 2: 
    case 3: 
      if ((p.j(paramString, "37")) || (p.j(paramString, String.valueOf(j.vnY))))
      {
        this.vma = av.vsg;
        AppMethodBeat.o(251190);
        return;
      }
      this.vma = av.vsc;
      AppMethodBeat.o(251190);
      return;
    case 4: 
      this.vma = av.vsf;
      AppMethodBeat.o(251190);
      return;
    case 5: 
      this.vma = av.vsd;
      AppMethodBeat.o(251190);
      return;
    }
    this.vma = av.vse;
    AppMethodBeat.o(251190);
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(251185);
    p.h(paramv, "<set-?>");
    this.vlN = paramv;
    AppMethodBeat.o(251185);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(251184);
    p.h(paramy, "<set-?>");
    this.vlL = paramy;
    AppMethodBeat.o(251184);
  }
  
  public final void auQ(String paramString)
  {
    AppMethodBeat.i(251182);
    p.h(paramString, "<set-?>");
    this.vlv = paramString;
    AppMethodBeat.o(251182);
  }
  
  public final void auR(String paramString)
  {
    AppMethodBeat.i(251183);
    p.h(paramString, "<set-?>");
    this.vlJ = paramString;
    AppMethodBeat.o(251183);
  }
  
  public final void auS(String paramString)
  {
    AppMethodBeat.i(251187);
    p.h(paramString, "<set-?>");
    this.vlT = paramString;
    AppMethodBeat.o(251187);
  }
  
  public final void b(ao paramao)
  {
    AppMethodBeat.i(251203);
    p.h(paramao, "<set-?>");
    this.vms = paramao;
    AppMethodBeat.o(251203);
  }
  
  public final void c(o paramo)
  {
    AppMethodBeat.i(251194);
    p.h(paramo, "<set-?>");
    this.vmb = paramo;
    AppMethodBeat.o(251194);
  }
  
  public final String dpp()
  {
    AppMethodBeat.i(251193);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
    localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEl;
      if (localObject1 != null)
      {
        localObject2 = ((awc)localObject1).LGz;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
          localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
          if (localObject1 == null) {
            break label118;
          }
        }
      }
    }
    label118:
    for (Object localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEq;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.vly;
      }
      Log.i(this.TAG, "get shopAppid=".concat(String.valueOf(localObject1)));
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      AppMethodBeat.o(251193);
      return localObject2;
      localObject2 = null;
      break;
    }
  }
  
  public final String dpq()
  {
    AppMethodBeat.i(251195);
    Object localObject = com.tencent.mm.plugin.finder.live.model.o.ujN;
    localObject = com.tencent.mm.plugin.finder.live.model.o.dfZ();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
      if (localObject == null) {}
    }
    for (long l = ((awe)localObject).liveId; l == -1L; l = -1L)
    {
      localObject = this.vmj.hJs;
      AppMethodBeat.o(251195);
      return localObject;
    }
    localObject = b.zs(l);
    p.g(localObject, "HellhoundUtil.long2UnsignedString(liveId)");
    AppMethodBeat.o(251195);
    return localObject;
  }
  
  public final String dpr()
  {
    AppMethodBeat.i(251196);
    Object localObject = com.tencent.mm.plugin.finder.live.model.o.ujN;
    localObject = com.tencent.mm.plugin.finder.live.model.o.dfZ();
    if (localObject != null) {}
    for (long l = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).hFK; l == 0L; l = 0L)
    {
      localObject = this.vmj.feedId;
      AppMethodBeat.o(251196);
      return localObject;
    }
    localObject = b.zs(l);
    p.g(localObject, "HellhoundUtil.long2UnsignedString(feedId)");
    AppMethodBeat.o(251196);
    return localObject;
  }
  
  public final void dpv()
  {
    AppMethodBeat.i(251201);
    Object localObject = this.vmj.vtA;
    if (((HashMap)localObject).isEmpty())
    {
      AppMethodBeat.o(251201);
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
        if (!localo.vlm)
        {
          localo.vlm = true;
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
    AppMethodBeat.o(251201);
  }
  
  public final void setTag(String paramString)
  {
    AppMethodBeat.i(251186);
    p.h(paramString, "<set-?>");
    this.tag = paramString;
    AppMethodBeat.o(251186);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ActionType;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "PROFILE_LIVE_BTN_EXPOSE", "PROFILE_LIVE_BTN_CLICK", "LIVE_ENTER_UI", "LIVE_BTN_CLICK", "LIVE_EXCHANGE_CAMERA", "LIVE_COMMERCE", "LIVE_EDIT_COVER", "LIVE_DESCRIPTION", "LIVE_POI", "LIVE_RULE", "LIVE_TIMER", "LIVE_SUCCESS", "LIVE_OUT", "LIVE_CLICK_BTN_MENU", "LINKMIC_SWITCH", "GIFT_SWITCCH", "plugin-finder_release"})
  public static enum a
  {
    public final long hlf;
    
    static
    {
      AppMethodBeat.i(251016);
      a locala1 = new a("PROFILE_LIVE_BTN_EXPOSE", 0, 1L);
      vmu = locala1;
      a locala2 = new a("PROFILE_LIVE_BTN_CLICK", 1, 2L);
      vmv = locala2;
      a locala3 = new a("LIVE_ENTER_UI", 2, 3L);
      vmw = locala3;
      a locala4 = new a("LIVE_BTN_CLICK", 3, 4L);
      vmx = locala4;
      a locala5 = new a("LIVE_EXCHANGE_CAMERA", 4, 5L);
      vmy = locala5;
      a locala6 = new a("LIVE_COMMERCE", 5, 6L);
      vmz = locala6;
      a locala7 = new a("LIVE_EDIT_COVER", 6, 7L);
      vmA = locala7;
      a locala8 = new a("LIVE_DESCRIPTION", 7, 8L);
      vmB = locala8;
      a locala9 = new a("LIVE_POI", 8, 9L);
      vmC = locala9;
      a locala10 = new a("LIVE_RULE", 9, 10L);
      vmD = locala10;
      a locala11 = new a("LIVE_TIMER", 10, 11L);
      vmE = locala11;
      a locala12 = new a("LIVE_SUCCESS", 11, 12L);
      vmF = locala12;
      a locala13 = new a("LIVE_OUT", 12, 13L);
      vmG = locala13;
      a locala14 = new a("LIVE_CLICK_BTN_MENU", 13, 14L);
      vmH = locala14;
      a locala15 = new a("LINKMIC_SWITCH", 14, 15L);
      vmI = locala15;
      a locala16 = new a("GIFT_SWITCCH", 15, 16L);
      vmJ = locala16;
      vmK = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16 };
      AppMethodBeat.o(251016);
    }
    
    private a(long paramLong)
    {
      this.hlf = paramLong;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveAnchorCommerceAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_ENTER_SHOP", "LIVE_ADD_GOODS", "LIVE_CLICK_GOODS", "LIVE_DELETE_GOODS", "LIVE_SET_TOP_GOODS", "LIVE_START_PROMOTE_GOODS", "LIVE_FINISH_PROMOTE_GOODS", "LIVE_CLICK_PROMOTE_GOODS", "plugin-finder_release"})
  public static enum aa
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251094);
      aa localaa1 = new aa("LIVE_ENTER_SHOP", 0, 1);
      vpJ = localaa1;
      aa localaa2 = new aa("LIVE_ADD_GOODS", 1, 2);
      vpK = localaa2;
      aa localaa3 = new aa("LIVE_CLICK_GOODS", 2, 3);
      vpL = localaa3;
      aa localaa4 = new aa("LIVE_DELETE_GOODS", 3, 4);
      vpM = localaa4;
      aa localaa5 = new aa("LIVE_SET_TOP_GOODS", 4, 5);
      vpN = localaa5;
      aa localaa6 = new aa("LIVE_START_PROMOTE_GOODS", 5, 7);
      vpO = localaa6;
      aa localaa7 = new aa("LIVE_FINISH_PROMOTE_GOODS", 6, 8);
      vpP = localaa7;
      aa localaa8 = new aa("LIVE_CLICK_PROMOTE_GOODS", 7, 9);
      vpQ = localaa8;
      vpR = new aa[] { localaa1, localaa2, localaa3, localaa4, localaa5, localaa6, localaa7, localaa8 };
      AppMethodBeat.o(251094);
    }
    
    private aa(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveBookAction;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "LIVE_SELF_PAGE_CLICK_BOOK_ITEM", "LIVE_ENTER_CRAETE_BOOK_PAGE", "LIVE_CREATE_BOOK_SUCC", "LIVE_JUMP_PROFILE_PAGE", "LIVE_CANCEL_BOOK", "plugin-finder_release"})
  public static enum ab
  {
    final long hlf;
    
    static
    {
      AppMethodBeat.i(251097);
      ab localab1 = new ab("LIVE_SELF_PAGE_CLICK_BOOK_ITEM", 0, 1L);
      vpS = localab1;
      ab localab2 = new ab("LIVE_ENTER_CRAETE_BOOK_PAGE", 1, 2L);
      vpT = localab2;
      ab localab3 = new ab("LIVE_CREATE_BOOK_SUCC", 2, 3L);
      vpU = localab3;
      ab localab4 = new ab("LIVE_JUMP_PROFILE_PAGE", 3, 4L);
      vpV = localab4;
      ab localab5 = new ab("LIVE_CANCEL_BOOK", 4, 5L);
      vpW = localab5;
      vpX = new ab[] { localab1, localab2, localab3, localab4, localab5 };
      AppMethodBeat.o(251097);
    }
    
    private ab(long paramLong)
    {
      this.hlf = paramLong;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LivePersonalAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_PERSONAL_VIEW_SHOW", "LIVE_PERSONAL_COMMENT_CLOSE", "LIVE_PERSONAL_COMMENT_OPEN", "LIVE_PERSONAL_COMPLAIN", "LIVE_PERSONAL_KICK_OUT", "plugin-finder_release"})
  public static enum ac
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251100);
      ac localac1 = new ac("LIVE_PERSONAL_VIEW_SHOW", 0, 1);
      vpY = localac1;
      ac localac2 = new ac("LIVE_PERSONAL_COMMENT_CLOSE", 1, 2);
      vpZ = localac2;
      ac localac3 = new ac("LIVE_PERSONAL_COMMENT_OPEN", 2, 3);
      vqa = localac3;
      ac localac4 = new ac("LIVE_PERSONAL_COMPLAIN", 3, 4);
      vqb = localac4;
      ac localac5 = new ac("LIVE_PERSONAL_KICK_OUT", 4, 5);
      vqc = localac5;
      vqd = new ac[] { localac1, localac2, localac3, localac4, localac5 };
      AppMethodBeat.o(251100);
    }
    
    private ac(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveVerified;", "", "action", "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "LIVE_VERIFIED_PAGE_EXPOSURE", "LIVE_ENTER_VERIFIED_PAGE", "LIVE_PASS_VERIFIED_SUCC", "LIVE_PASS_VERIFIED_FAIL", "plugin-finder_release"})
  public static enum ad
  {
    final long hlf;
    
    static
    {
      AppMethodBeat.i(251103);
      ad localad1 = new ad("LIVE_VERIFIED_PAGE_EXPOSURE", 0, 1L);
      vqe = localad1;
      ad localad2 = new ad("LIVE_ENTER_VERIFIED_PAGE", 1, 2L);
      vqf = localad2;
      ad localad3 = new ad("LIVE_PASS_VERIFIED_SUCC", 2, 3L);
      vqg = localad3;
      ad localad4 = new ad("LIVE_PASS_VERIFIED_FAIL", 3, 4L);
      vqh = localad4;
      vqi = new ad[] { localad1, localad2, localad3, localad4 };
      AppMethodBeat.o(251103);
    }
    
    private ad(long paramLong)
    {
      this.hlf = paramLong;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$Live_Enter_Type;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ORDINARY_LAUNCH_UI", "INNER_NOTICE_TIME_LAUNCH_UI", "RETURN_LIVE_ROOM", "plugin-finder_release"})
  public static enum ae
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251106);
      ae localae1 = new ae("ORDINARY_LAUNCH_UI", 0, 1);
      vqj = localae1;
      ae localae2 = new ae("INNER_NOTICE_TIME_LAUNCH_UI", 1, 2);
      vqk = localae2;
      ae localae3 = new ae("RETURN_LIVE_ROOM", 2, 3);
      vql = localae3;
      vqm = new ae[] { localae1, localae2, localae3 };
      AppMethodBeat.o(251106);
    }
    
    private ae(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyAction2;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ENTER_PAGE_EXPLORE", "CLICK_CANCEL_RETURN", "CLICK_START_LIVE", "plugin-finder_release"})
  public static enum af
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251109);
      af localaf1 = new af("ENTER_PAGE_EXPLORE", 0, 1);
      vqn = localaf1;
      af localaf2 = new af("CLICK_CANCEL_RETURN", 1, 2);
      vqo = localaf2;
      af localaf3 = new af("CLICK_START_LIVE", 2, 3);
      vqp = localaf3;
      vqq = new af[] { localaf1, localaf2, localaf3 };
      AppMethodBeat.o(251109);
    }
    
    private af(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyMoreActionResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "EXPLORE_MORE_LIVE", "CLICK_MORE_LIVE", "plugin-finder_release"})
  public static enum ag
  {
    final int result;
    
    static
    {
      AppMethodBeat.i(251112);
      ag localag1 = new ag("EXPLORE_MORE_LIVE", 0, 1);
      vqr = localag1;
      ag localag2 = new ag("CLICK_MORE_LIVE", 1, 2);
      vqs = localag2;
      vqt = new ag[] { localag1, localag2 };
      AppMethodBeat.o(251112);
    }
    
    private ag(int paramInt)
    {
      this.result = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyPageType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "START_LIVE_BY_FINDER_IDENTITY", "CREATE_FINDER", "WECHAT_REALNAME_AUTH", "plugin-finder_release"})
  public static enum ah
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251115);
      ah localah1 = new ah("START_LIVE_BY_FINDER_IDENTITY", 0, 1);
      vqu = localah1;
      ah localah2 = new ah("CREATE_FINDER", 1, 2);
      vqv = localah2;
      ah localah3 = new ah("WECHAT_REALNAME_AUTH", 2, 3);
      vqw = localah3;
      vqx = new ah[] { localah1, localah2, localah3 };
      AppMethodBeat.o(251115);
    }
    
    private ah(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$RuleType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_RULE_ALREADY_OK", "LIVE_RULE_SHOW", "LIVE_RULE_CHECK_YES", "LIVE_RULE_CHECK_NO", "plugin-finder_release"})
  public static enum ai
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251118);
      ai localai1 = new ai("LIVE_RULE_ALREADY_OK", 0, 1);
      vqy = localai1;
      ai localai2 = new ai("LIVE_RULE_SHOW", 1, 2);
      vqz = localai2;
      ai localai3 = new ai("LIVE_RULE_CHECK_YES", 2, 3);
      vqA = localai3;
      ai localai4 = new ai("LIVE_RULE_CHECK_NO", 3, 4);
      vqB = localai4;
      vqC = new ai[] { localai1, localai2, localai3, localai4 };
      AppMethodBeat.o(251118);
    }
    
    private ai(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$SCREEN_SWITCH_ACTION;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "HORIZONTAL_BY_CLICK_BTN", "HORIZONTAL_BY_ROTATE_PHONE", "PORTRAIT_BY_CLICK_BTN", "PORTRAIT_BY_ROTATE_PHONE", "plugin-finder_release"})
  public static enum aj
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251121);
      aj localaj1 = new aj("HORIZONTAL_BY_CLICK_BTN", 0, 1);
      vqD = localaj1;
      aj localaj2 = new aj("HORIZONTAL_BY_ROTATE_PHONE", 1, 2);
      vqE = localaj2;
      aj localaj3 = new aj("PORTRAIT_BY_CLICK_BTN", 2, 3);
      vqF = localaj3;
      aj localaj4 = new aj("PORTRAIT_BY_ROTATE_PHONE", 3, 4);
      vqG = localaj4;
      vqH = new aj[] { localaj1, localaj2, localaj3, localaj4 };
      AppMethodBeat.o(251121);
    }
    
    private aj(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$SEE_GIFT_LIST;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE", "CLICK_HELF_PAGE_INSTRUCTION", "RETURN_LIVE_ROOM", "plugin-finder_release"})
  public static enum ak
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251124);
      ak localak1 = new ak("CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE", 0, 1);
      vqI = localak1;
      ak localak2 = new ak("CLICK_HELF_PAGE_INSTRUCTION", 1, 2);
      vqJ = localak2;
      ak localak3 = new ak("RETURN_LIVE_ROOM", 2, 3);
      vqK = localak3;
      vqL = new ak[] { localak1, localak2, localak3 };
      AppMethodBeat.o(251124);
    }
    
    private ak(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ScreenBtnEvent;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "FROM_ONCREATE", "FROM_ONRESUME", "FROM_ONPLUGIN", "plugin-finder_release"})
  public static enum al
  {
    private final int action;
    
    static
    {
      AppMethodBeat.i(251127);
      al localal1 = new al("FROM_ONCREATE", 0, 0);
      vqM = localal1;
      al localal2 = new al("FROM_ONRESUME", 1, 1);
      vqN = localal2;
      al localal3 = new al("FROM_ONPLUGIN", 2, 2);
      vqO = localal3;
      vqP = new al[] { localal1, localal2, localal3 };
      AppMethodBeat.o(251127);
    }
    
    private al(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ScreenDirection;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_SCREEN_PORTRAIT", "LIVE_SCREEN_HORIZONTAL", "plugin-finder_release"})
  public static enum am
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251130);
      am localam1 = new am("LIVE_SCREEN_PORTRAIT", 0, 1);
      vqQ = localam1;
      am localam2 = new am("LIVE_SCREEN_HORIZONTAL", 1, 2);
      vqR = localam2;
      vqS = new am[] { localam1, localam2 };
      AppMethodBeat.o(251130);
    }
    
    private am(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ShopPermitAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_NO_SHOP_PERMIT", "LIVE_SHOP_PERMIT_NO_SMALL_STORE", "LIVE_SHOP_PERMIT_SMALL_STORE", "plugin-finder_release"})
  public static enum an
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251133);
      an localan1 = new an("LIVE_NO_SHOP_PERMIT", 0, 1);
      vqT = localan1;
      an localan2 = new an("LIVE_SHOP_PERMIT_NO_SMALL_STORE", 1, 2);
      vqU = localan2;
      an localan3 = new an("LIVE_SHOP_PERMIT_SMALL_STORE", 2, 3);
      vqV = localan3;
      vqW = new an[] { localan1, localan2, localan3 };
      AppMethodBeat.o(251133);
    }
    
    private an(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartLiveSource;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "FINDER_PROFILE", "NEARBY_LIVE", "FINDER_PROFILE_RIGHT_CORNER", "plugin-finder_release"})
  public static enum ao
  {
    final int source;
    
    static
    {
      AppMethodBeat.i(251136);
      ao localao1 = new ao("FINDER_PROFILE", 0, 1);
      vqX = localao1;
      ao localao2 = new ao("NEARBY_LIVE", 1, 2);
      vqY = localao2;
      ao localao3 = new ao("FINDER_PROFILE_RIGHT_CORNER", 2, 3);
      vqZ = localao3;
      vra = new ao[] { localao1, localao2, localao3 };
      AppMethodBeat.o(251136);
    }
    
    private ao(int paramInt)
    {
      this.source = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_START_NETWORK_ERROR", "LIVE_START_OK", "plugin-finder_release"})
  public static enum ap
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(251139);
      ap localap1 = new ap("LIVE_START_NETWORK_ERROR", 0, 1);
      vrb = localap1;
      ap localap2 = new ap("LIVE_START_OK", 1, 2);
      vrc = localap2;
      vrd = new ap[] { localap1, localap2 };
      AppMethodBeat.o(251139);
    }
    
    private ap(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisibleRangeType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "PUBLIC", "NUMBER_TO_SEE", "ONLY_ANCHOR_SHARE", "plugin-finder_release"})
  public static enum aq
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251142);
      aq localaq1 = new aq("PUBLIC", 0, 0);
      vre = localaq1;
      aq localaq2 = new aq("NUMBER_TO_SEE", 1, 1);
      vrf = localaq2;
      aq localaq3 = new aq("ONLY_ANCHOR_SHARE", 2, 2);
      vrg = localaq3;
      vrh = new aq[] { localaq1, localaq2, localaq3 };
      AppMethodBeat.o(251142);
    }
    
    private aq(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "EnterRoom", "Message", "Like", "CommentExpose", "ComplaintEntry", "Float", "Share", "HideOpearation", "EnterProfile", "CopyComment", "SlideEnter", "Commerce", "QuitRoom", "Auth", "EXPLORE_SCREEN_SWITCH_BTN", "SWITCH_SCREEN", "REPLY", "LOTTERY", "GIFT", "LINKMIC", "NEARBY_LIVE_MORE", "plugin-finder_release"})
  public static enum ar
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251145);
      ar localar1 = new ar("EnterRoom", 0, 1);
      vri = localar1;
      ar localar2 = new ar("Message", 1, 2);
      vrj = localar2;
      ar localar3 = new ar("Like", 2, 3);
      vrk = localar3;
      ar localar4 = new ar("CommentExpose", 3, 4);
      vrl = localar4;
      ar localar5 = new ar("ComplaintEntry", 4, 5);
      vrm = localar5;
      ar localar6 = new ar("Float", 5, 6);
      vrn = localar6;
      ar localar7 = new ar("Share", 6, 7);
      vro = localar7;
      ar localar8 = new ar("HideOpearation", 7, 8);
      vrp = localar8;
      ar localar9 = new ar("EnterProfile", 8, 9);
      vrq = localar9;
      ar localar10 = new ar("CopyComment", 9, 10);
      vrr = localar10;
      ar localar11 = new ar("SlideEnter", 10, 11);
      vrs = localar11;
      ar localar12 = new ar("Commerce", 11, 12);
      vrt = localar12;
      ar localar13 = new ar("QuitRoom", 12, 13);
      vru = localar13;
      ar localar14 = new ar("Auth", 13, 14);
      vrv = localar14;
      ar localar15 = new ar("EXPLORE_SCREEN_SWITCH_BTN", 14, 15);
      vrw = localar15;
      ar localar16 = new ar("SWITCH_SCREEN", 15, 16);
      vrx = localar16;
      ar localar17 = new ar("REPLY", 16, 17);
      vry = localar17;
      ar localar18 = new ar("LOTTERY", 17, 18);
      vrz = localar18;
      ar localar19 = new ar("GIFT", 18, 19);
      vrA = localar19;
      ar localar20 = new ar("LINKMIC", 19, 20);
      vrB = localar20;
      ar localar21 = new ar("NEARBY_LIVE_MORE", 20, 21);
      vrC = localar21;
      vrD = new ar[] { localar1, localar2, localar3, localar4, localar5, localar6, localar7, localar8, localar9, localar10, localar11, localar12, localar13, localar14, localar15, localar16, localar17, localar18, localar19, localar20, localar21 };
      AppMethodBeat.o(251145);
    }
    
    private ar(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorAuthAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "AuthExposure", "AuthEnter", "AuthSucc", "AuthFail", "plugin-finder_release"})
  public static enum as
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251148);
      as localas1 = new as("AuthExposure", 0, 1);
      vrE = localas1;
      as localas2 = new as("AuthEnter", 1, 2);
      vrF = localas2;
      as localas3 = new as("AuthSucc", 2, 3);
      vrG = localas3;
      as localas4 = new as("AuthFail", 3, 4);
      vrH = localas4;
      vrI = new as[] { localas1, localas2, localas3, localas4 };
      AppMethodBeat.o(251148);
    }
    
    private as(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorCloseType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CloseTypeFloat", "CloseTypeFull", "CloseTypeKickedOut", "CloseTypeSlide", "CloseTypeOtherRoom", "CloseTypeLiveOver", "plugin-finder_release"})
  public static enum at
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251151);
      at localat1 = new at("CloseTypeFloat", 0, 1);
      vrJ = localat1;
      at localat2 = new at("CloseTypeFull", 1, 2);
      vrK = localat2;
      at localat3 = new at("CloseTypeKickedOut", 2, 3);
      vrL = localat3;
      at localat4 = new at("CloseTypeSlide", 3, 4);
      vrM = localat4;
      at localat5 = new at("CloseTypeOtherRoom", 4, 5);
      vrN = localat5;
      at localat6 = new at("CloseTypeLiveOver", 5, 6);
      vrO = localat6;
      vrP = new at[] { localat1, localat2, localat3, localat4, localat5, localat6 };
      AppMethodBeat.o(251151);
    }
    
    private at(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorCommerceAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CommerceActionBubbleTipShow", "CommerceActionBubbleTipClick", "CommerceActionShoppingButtonClick", "CommerceActionGoodsOrderButtonClick", "CommerceActionGoodsItemClick", "CommerceActionPurchaseButtonClick", "CommerceActionGoodsItemShow", "CommerceActionBubbleTipClose", "CommerceActionAnchorCloseBubble", "CommerceActionExitHalfPage", "plugin-finder_release"})
  public static enum au
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251154);
      au localau1 = new au("CommerceActionBubbleTipShow", 0, 1);
      vrQ = localau1;
      au localau2 = new au("CommerceActionBubbleTipClick", 1, 2);
      vrR = localau2;
      au localau3 = new au("CommerceActionShoppingButtonClick", 2, 3);
      vrS = localau3;
      au localau4 = new au("CommerceActionGoodsOrderButtonClick", 3, 4);
      vrT = localau4;
      au localau5 = new au("CommerceActionGoodsItemClick", 4, 5);
      vrU = localau5;
      au localau6 = new au("CommerceActionPurchaseButtonClick", 5, 6);
      vrV = localau6;
      au localau7 = new au("CommerceActionGoodsItemShow", 6, 7);
      vrW = localau7;
      au localau8 = new au("CommerceActionBubbleTipClose", 7, 8);
      vrX = localau8;
      au localau9 = new au("CommerceActionAnchorCloseBubble", 8, 9);
      vrY = localau9;
      au localau10 = new au("CommerceActionExitHalfPage", 9, 10);
      vrZ = localau10;
      vsa = new au[] { localau1, localau2, localau3, localau4, localau5, localau6, localau7, localau8, localau9, localau10 };
      AppMethodBeat.o(251154);
    }
    
    private au(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_LIVE_DEFAULT", "CLICK_LIVE_CARD", "CLICK_LIVE_CARD_AVATAR_LIVING", "CLICK_CARD_AVATAR_LIVING", "CLICK_AVATAR_LIVING", "CLICK_SNSAD_ENTER_LIVE_ROOM", "plugin-finder_release"})
  public static enum av
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(251157);
      av localav1 = new av("CLICK_LIVE_DEFAULT", 0, 0);
      vsb = localav1;
      av localav2 = new av("CLICK_LIVE_CARD", 1, 1);
      vsc = localav2;
      av localav3 = new av("CLICK_LIVE_CARD_AVATAR_LIVING", 2, 2);
      vsd = localav3;
      av localav4 = new av("CLICK_CARD_AVATAR_LIVING", 3, 3);
      vse = localav4;
      av localav5 = new av("CLICK_AVATAR_LIVING", 4, 4);
      vsf = localav5;
      av localav6 = new av("CLICK_SNSAD_ENTER_LIVE_ROOM", 5, 5);
      vsg = localav6;
      vsh = new av[] { localav1, localav2, localav3, localav4, localav5, localav6 };
      AppMethodBeat.o(251157);
    }
    
    private av(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorGift;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD", "CLICK_GIFT_BOARD_INNER_GITF", "SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND", "CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI", "SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE", "SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI", "GIFT_ICON_EXPOSURE", "CLICK_HOT_LIST_SEE_CUR_DOU_YOU", "RETURN_GIFT_BOARD_FROM_EXCHARGE_UI", "RETURN_LIVE_ROOM_FROM_GIFT_BOARD", "GIFT_BOARD_TURN_PAGE", "CLICK_VISITOR_IN_HOT_LIST", "CLICK_Y_IN_HOT_LIST", "plugin-finder_release"})
  public static enum aw
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251160);
      aw localaw1 = new aw("CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD", 0, 1);
      vsi = localaw1;
      aw localaw2 = new aw("CLICK_GIFT_BOARD_INNER_GITF", 1, 2);
      vsj = localaw2;
      aw localaw3 = new aw("SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND", 2, 3);
      vsk = localaw3;
      aw localaw4 = new aw("CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI", 3, 4);
      vsl = localaw4;
      aw localaw5 = new aw("SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE", 4, 5);
      vsm = localaw5;
      aw localaw6 = new aw("SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI", 5, 6);
      vsn = localaw6;
      aw localaw7 = new aw("GIFT_ICON_EXPOSURE", 6, 7);
      vso = localaw7;
      aw localaw8 = new aw("CLICK_HOT_LIST_SEE_CUR_DOU_YOU", 7, 8);
      vsp = localaw8;
      aw localaw9 = new aw("RETURN_GIFT_BOARD_FROM_EXCHARGE_UI", 8, 9);
      vsq = localaw9;
      aw localaw10 = new aw("RETURN_LIVE_ROOM_FROM_GIFT_BOARD", 9, 10);
      vsr = localaw10;
      aw localaw11 = new aw("GIFT_BOARD_TURN_PAGE", 10, 11);
      vss = localaw11;
      aw localaw12 = new aw("CLICK_VISITOR_IN_HOT_LIST", 11, 12);
      vst = localaw12;
      aw localaw13 = new aw("CLICK_Y_IN_HOT_LIST", 12, 13);
      vsu = localaw13;
      vsv = new aw[] { localaw1, localaw2, localaw3, localaw4, localaw5, localaw6, localaw7, localaw8, localaw9, localaw10, localaw11, localaw12, localaw13 };
      AppMethodBeat.o(251160);
    }
    
    private aw(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorLinkMicAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "INVALIDATE", "APPLY_LINKMIC", "APPLY_AUDIO_LINKMIC", "APPLY_VIDEO_LINKMIC", "ANCHOR_PASS_LINKMIC_REQUEST", "TIMEOUT_NO_LINK_HUNG_UP", "POPUP_ANCHOR_LINKING_CONFLICT", "ACTIVE_STOP_AUDIO_LINKMIC", "ACTIVE_STOP_VIDEO_LINKMIC", "LINKMIC_ICON_EXPLORE", "plugin-finder_release"})
  public static enum ax
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251163);
      ax localax1 = new ax("INVALIDATE", 0, 0);
      vsw = localax1;
      ax localax2 = new ax("APPLY_LINKMIC", 1, 1);
      vsx = localax2;
      ax localax3 = new ax("APPLY_AUDIO_LINKMIC", 2, 2);
      vsy = localax3;
      ax localax4 = new ax("APPLY_VIDEO_LINKMIC", 3, 3);
      vsz = localax4;
      ax localax5 = new ax("ANCHOR_PASS_LINKMIC_REQUEST", 4, 4);
      vsA = localax5;
      ax localax6 = new ax("TIMEOUT_NO_LINK_HUNG_UP", 5, 5);
      vsB = localax6;
      ax localax7 = new ax("POPUP_ANCHOR_LINKING_CONFLICT", 6, 6);
      vsC = localax7;
      ax localax8 = new ax("ACTIVE_STOP_AUDIO_LINKMIC", 7, 7);
      vsD = localax8;
      ax localax9 = new ax("ACTIVE_STOP_VIDEO_LINKMIC", 8, 8);
      vsE = localax9;
      ax localax10 = new ax("LINKMIC_ICON_EXPLORE", 9, 9);
      vsF = localax10;
      vsG = new ax[] { localax1, localax2, localax3, localax4, localax5, localax6, localax7, localax8, localax9, localax10 };
      AppMethodBeat.o(251163);
    }
    
    private ax(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorLotteryType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EXPOSURE_BLESS_BAG", "CLICK_LUCKY_BAG", "CLICK_JOIN_LOTTERY", "SEND_SUCC_COMMENT", "POPUP_TOAST_JOINED", "SHOW_WIN_RESULT_CARD", "CLICK_WIN_LIST", "ENTER_WIN_RECORD_BY_RIGHH_CORNER", "CLICK_WIN_ITEM_ENTER_DETAIL", "CLICK_WIN_DETAIL_ENTER_PRIVATE_UI", "plugin-finder_release"})
  public static enum ay
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251166);
      ay localay1 = new ay("EXPOSURE_BLESS_BAG", 0, 1);
      vsH = localay1;
      ay localay2 = new ay("CLICK_LUCKY_BAG", 1, 2);
      vsI = localay2;
      ay localay3 = new ay("CLICK_JOIN_LOTTERY", 2, 3);
      vsJ = localay3;
      ay localay4 = new ay("SEND_SUCC_COMMENT", 3, 4);
      vsK = localay4;
      ay localay5 = new ay("POPUP_TOAST_JOINED", 4, 5);
      vsL = localay5;
      ay localay6 = new ay("SHOW_WIN_RESULT_CARD", 5, 6);
      vsM = localay6;
      ay localay7 = new ay("CLICK_WIN_LIST", 6, 7);
      vsN = localay7;
      ay localay8 = new ay("ENTER_WIN_RECORD_BY_RIGHH_CORNER", 7, 8);
      vsO = localay8;
      ay localay9 = new ay("CLICK_WIN_ITEM_ENTER_DETAIL", 8, 9);
      vsP = localay9;
      ay localay10 = new ay("CLICK_WIN_DETAIL_ENTER_PRIVATE_UI", 9, 10);
      vsQ = localay10;
      vsR = new ay[] { localay1, localay2, localay3, localay4, localay5, localay6, localay7, localay8, localay9, localay10 };
      AppMethodBeat.o(251166);
    }
    
    private ay(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorNoticeAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ExposeProfile", "Book", "Cancle", "ExposeMsg", "Click", "plugin-finder_release"})
  public static enum az
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251169);
      az localaz1 = new az("ExposeProfile", 0, 1);
      vsS = localaz1;
      az localaz2 = new az("Book", 1, 2);
      vsT = localaz2;
      az localaz3 = new az("Cancle", 2, 3);
      vsU = localaz3;
      az localaz4 = new az("ExposeMsg", 3, 4);
      vsV = localaz4;
      az localaz5 = new az("Click", 4, 5);
      vsW = localaz5;
      vsX = new az[] { localaz1, localaz2, localaz3, localaz4, localaz5 };
      AppMethodBeat.o(251169);
    }
    
    private az(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AllCommentType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_ALL_COMMENT_CLOSE", "LIVE_ALL_COMMENT_OPEN", "plugin-finder_release"})
  public static enum b
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(251019);
      b localb1 = new b("LIVE_ALL_COMMENT_CLOSE", 0, 1);
      vmL = localb1;
      b localb2 = new b("LIVE_ALL_COMMENT_OPEN", 1, 2);
      vmM = localb2;
      vmN = new b[] { localb1, localb2 };
      AppMethodBeat.o(251019);
    }
    
    private b(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "Chat", "Timeline", "PERSIONAL_STATE_SHARE_SUCC", "plugin-finder_release"})
  public static enum ba
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251172);
      ba localba1 = new ba("Chat", 0, 1);
      vsY = localba1;
      ba localba2 = new ba("Timeline", 1, 2);
      vsZ = localba2;
      ba localba3 = new ba("PERSIONAL_STATE_SHARE_SUCC", 2, 5);
      vta = localba3;
      vtb = new ba[] { localba1, localba2, localba3 };
      AppMethodBeat.o(251172);
    }
    
    private ba(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorShopBtnState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "NO_EXPOSURE", "EXPOSURE", "plugin-finder_release"})
  public static enum bb
  {
    final int state;
    
    static
    {
      AppMethodBeat.i(251175);
      bb localbb1 = new bb("NO_EXPOSURE", 0, 0);
      vtc = localbb1;
      bb localbb2 = new bb("EXPOSURE", 1, 1);
      vtd = localbb2;
      vte = new bb[] { localbb1, localbb2 };
      AppMethodBeat.o(251175);
    }
    
    private bb(int paramInt)
    {
      this.state = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorWinResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "WIN", "NO_WIN", "NO_JOIN", "plugin-finder_release"})
  public static enum bc
  {
    public final int result;
    
    static
    {
      AppMethodBeat.i(251178);
      bc localbc1 = new bc("WIN", 0, 1);
      vtf = localbc1;
      bc localbc2 = new bc("NO_WIN", 1, 2);
      vtg = localbc2;
      bc localbc3 = new bc("NO_JOIN", 2, 3);
      vth = localbc3;
      vti = new bc[] { localbc1, localbc2, localbc3 };
      AppMethodBeat.o(251178);
    }
    
    private bc(int paramInt)
    {
      this.result = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorActionType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_ANCHOR_ACTION_BEGIN", "LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA", "LIVE_ANCHOR_ACTION_MINIMIZE", "LIVE_ANCHOR_ACTION_COMMENT", "LIVE_ANCHOR_ACTION_BARRAGE", "LIVE_ANCHOR_ACTION_SHARE", "LIVE_ANCHOR_ACTION_AUDIENCE", "LIVE_ANCHOR_ACTION_COMMERCE", "LIVE_ANCHOR_ACTION_OUT", "LIVE_ANCHOR_TOP_COMMENT", "LIVE_ANCHOR_TICKLE", "LIVE_ANCHOR_LOTTERY", "CLICK_FAIRY_STICK", "BEAUTY", "FILTER", "CLICK_MIRROR", "LINKMIC_SWITCH", "LINKMIC_OP", "GIFT_SWITCH", "SEE_GIFT_LIST", "plugin-finder_release"})
  public static enum c
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251022);
      c localc1 = new c("LIVE_ANCHOR_ACTION_BEGIN", 0, 1);
      vmO = localc1;
      c localc2 = new c("LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA", 1, 2);
      vmP = localc2;
      c localc3 = new c("LIVE_ANCHOR_ACTION_MINIMIZE", 2, 3);
      vmQ = localc3;
      c localc4 = new c("LIVE_ANCHOR_ACTION_COMMENT", 3, 4);
      vmR = localc4;
      c localc5 = new c("LIVE_ANCHOR_ACTION_BARRAGE", 4, 5);
      vmS = localc5;
      c localc6 = new c("LIVE_ANCHOR_ACTION_SHARE", 5, 6);
      vmT = localc6;
      c localc7 = new c("LIVE_ANCHOR_ACTION_AUDIENCE", 6, 7);
      vmU = localc7;
      c localc8 = new c("LIVE_ANCHOR_ACTION_COMMERCE", 7, 8);
      vmV = localc8;
      c localc9 = new c("LIVE_ANCHOR_ACTION_OUT", 8, 9);
      vmW = localc9;
      c localc10 = new c("LIVE_ANCHOR_TOP_COMMENT", 9, 10);
      vmX = localc10;
      c localc11 = new c("LIVE_ANCHOR_TICKLE", 10, 11);
      vmY = localc11;
      c localc12 = new c("LIVE_ANCHOR_LOTTERY", 11, 12);
      vmZ = localc12;
      c localc13 = new c("CLICK_FAIRY_STICK", 12, 13);
      vna = localc13;
      c localc14 = new c("BEAUTY", 13, 14);
      vnb = localc14;
      c localc15 = new c("FILTER", 14, 15);
      vnc = localc15;
      c localc16 = new c("CLICK_MIRROR", 15, 16);
      vnd = localc16;
      c localc17 = new c("LINKMIC_SWITCH", 16, 17);
      vne = localc17;
      c localc18 = new c("LINKMIC_OP", 17, 18);
      vnf = localc18;
      c localc19 = new c("GIFT_SWITCH", 18, 19);
      vng = localc19;
      c localc20 = new c("SEE_GIFT_LIST", 19, 20);
      vnh = localc20;
      vni = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localc9, localc10, localc11, localc12, localc13, localc14, localc15, localc16, localc17, localc18, localc19, localc20 };
      AppMethodBeat.o(251022);
    }
    
    private c(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorFloatAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_ENTER_LOTTERY_RECORD", "plugin-finder_release"})
  public static enum d
  {
    public final int action = 6;
    
    static
    {
      AppMethodBeat.i(251025);
      d locald = new d("CLICK_ENTER_LOTTERY_RECORD");
      vnj = locald;
      vnk = new d[] { locald };
      AppMethodBeat.o(251025);
    }
    
    private d(int paramInt) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorLiveClose;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ENTER_LIVE_CLOSE_UI", "SEE_GIFT_LIST", "CLICK_FINISH", "plugin-finder_release"})
  public static enum e
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251028);
      e locale1 = new e("ENTER_LIVE_CLOSE_UI", 0, 1);
      vnl = locale1;
      e locale2 = new e("SEE_GIFT_LIST", 1, 2);
      vnm = locale2;
      e locale3 = new e("CLICK_FINISH", 2, 3);
      vnn = locale3;
      vno = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(251028);
    }
    
    private e(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorLotteryType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "setType", "(I)V", "CLICK_LOTTERY_ICON", "CLICK_JOIN_CONDITION", "CLICK_ANY_COMMENT", "CLICK_SPECIFY_COMMENT_CONTENT", "CLICK_LIKE", "WRITE_SPECIFY_COMMENT_CONTENT_SUCC", "START_LOTTERY_SUCCESS", "CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT", "CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI", "CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI", "CLICK_LUCKY_BAG", "CANCEL_LOTTERY", "plugin-finder_release"})
  public static enum f
  {
    int type;
    
    static
    {
      AppMethodBeat.i(251031);
      f localf1 = new f("CLICK_LOTTERY_ICON", 0, 1);
      vnp = localf1;
      f localf2 = new f("CLICK_JOIN_CONDITION", 1, 2);
      vnq = localf2;
      f localf3 = new f("CLICK_ANY_COMMENT", 2, 3);
      vnr = localf3;
      f localf4 = new f("CLICK_SPECIFY_COMMENT_CONTENT", 3, 4);
      vns = localf4;
      f localf5 = new f("CLICK_LIKE", 4, 5);
      vnt = localf5;
      f localf6 = new f("WRITE_SPECIFY_COMMENT_CONTENT_SUCC", 5, 6);
      vnu = localf6;
      f localf7 = new f("START_LOTTERY_SUCCESS", 6, 7);
      vnv = localf7;
      f localf8 = new f("CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT", 7, 8);
      vnw = localf8;
      f localf9 = new f("CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI", 8, 9);
      vnx = localf9;
      f localf10 = new f("CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI", 9, 10);
      vny = localf10;
      f localf11 = new f("CLICK_LUCKY_BAG", 10, 11);
      vnz = localf11;
      f localf12 = new f("CANCEL_LOTTERY", 11, 12);
      vnA = localf12;
      vnB = new f[] { localf1, localf2, localf3, localf4, localf5, localf6, localf7, localf8, localf9, localf10, localf11, localf12 };
      AppMethodBeat.o(251031);
    }
    
    private f(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$BookLiveSrc;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "PROFILE", "PROFILE_RIGHT_CORNER", "plugin-finder_release"})
  public static enum g
  {
    final int source;
    
    static
    {
      AppMethodBeat.i(251034);
      g localg1 = new g("PROFILE", 0, 1);
      vnC = localg1;
      g localg2 = new g("PROFILE_RIGHT_CORNER", 1, 2);
      vnD = localg2;
      vnE = new g[] { localg1, localg2 };
      AppMethodBeat.o(251034);
    }
    
    private g(int paramInt)
    {
      this.source = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ClearScreenAction;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_CLEAR_SCREEN", "CLICK_CLEAR_SCREEN_CANCEL", "CLICK_CLEAR_SCREEN_MENU", "plugin-finder_release"})
  public static enum h
  {
    final int action;
    
    static
    {
      AppMethodBeat.i(251037);
      h localh1 = new h("CLICK_CLEAR_SCREEN", 0, 1);
      vnF = localh1;
      h localh2 = new h("CLICK_CLEAR_SCREEN_CANCEL", 1, 2);
      vnG = localh2;
      h localh3 = new h("CLICK_CLEAR_SCREEN_MENU", 2, 3);
      vnH = localh3;
      vnI = new h[] { localh1, localh2, localh3 };
      AppMethodBeat.o(251037);
    }
    
    private h(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CloseUISeeGiftList;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "ENTER_UI", "CLICK_FETCH_INCOME", "RETRUN_LIVE_CLOSE_UI", "plugin-finder_release"})
  public static enum i
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251040);
      i locali1 = new i("ENTER_UI", 0, 1);
      vnJ = locali1;
      i locali2 = new i("CLICK_FETCH_INCOME", 1, 2);
      vnK = locali2;
      i locali3 = new i("RETRUN_LIVE_CLOSE_UI", 2, 3);
      vnL = locali3;
      vnM = new i[] { locali1, locali2, locali3 };
      AppMethodBeat.o(251040);
    }
    
    private i(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CommentSceneExtend;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW", "COMMENT_SCENE_LIVE_ROOM_SLIDE", "COMMENT_SCENE_SEARCH_MORE_CONTACT", "COMMENT_SCENE_SEARCH_RESULT_FLOW", "COMMENT_SCENE_PROFILE_PAGE", "COMMENT_SCENE_SHARE_PAGE", "COMMENT_SCENE_BOOK_NOTIFY", "COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW", "COMMENT_SCENE_LBS_TOP_LIVE_CARD", "COMMENT_SCENE_SEARCH_1_SEARCH", "COMMENT_SCENE_PUBLIC_NUMBER", "COMMENT_SCENE_APPBRAN", "COMMENT_SCENE_SEE_1_SEE", "COMMENT_SCENE_PULLDOWN_MENU", "COMMENT_SCENE_SLEF_STATUS", "plugin-finder_release"})
  public static enum j
  {
    public final String scene;
    
    static
    {
      AppMethodBeat.i(251043);
      j localj1 = new j("COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW", 0, "temp_1");
      vnN = localj1;
      j localj2 = new j("COMMENT_SCENE_LIVE_ROOM_SLIDE", 1, "temp_2");
      vnO = localj2;
      j localj3 = new j("COMMENT_SCENE_SEARCH_MORE_CONTACT", 2, "temp_3");
      vnP = localj3;
      j localj4 = new j("COMMENT_SCENE_SEARCH_RESULT_FLOW", 3, "temp_4");
      vnQ = localj4;
      j localj5 = new j("COMMENT_SCENE_PROFILE_PAGE", 4, "temp_5");
      vnR = localj5;
      j localj6 = new j("COMMENT_SCENE_SHARE_PAGE", 5, "temp_6");
      vnS = localj6;
      j localj7 = new j("COMMENT_SCENE_BOOK_NOTIFY", 6, "temp_7");
      vnT = localj7;
      j localj8 = new j("COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW", 7, "temp_9");
      vnU = localj8;
      j localj9 = new j("COMMENT_SCENE_LBS_TOP_LIVE_CARD", 8, "temp_10");
      vnV = localj9;
      j localj10 = new j("COMMENT_SCENE_SEARCH_1_SEARCH", 9, "temp_11");
      vnW = localj10;
      j localj11 = new j("COMMENT_SCENE_PUBLIC_NUMBER", 10, "temp_12");
      vnX = localj11;
      j localj12 = new j("COMMENT_SCENE_APPBRAN", 11, "temp_13");
      vnY = localj12;
      j localj13 = new j("COMMENT_SCENE_SEE_1_SEE", 12, "temp_14");
      vnZ = localj13;
      j localj14 = new j("COMMENT_SCENE_PULLDOWN_MENU", 13, "temp_15");
      voa = localj14;
      j localj15 = new j("COMMENT_SCENE_SLEF_STATUS", 14, "temp_16");
      vob = localj15;
      voc = new j[] { localj1, localj2, localj3, localj4, localj5, localj6, localj7, localj8, localj9, localj10, localj11, localj12, localj13, localj14, localj15 };
      AppMethodBeat.o(251043);
    }
    
    private j(String paramString)
    {
      this.scene = paramString;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ComplaintVisitorSource;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "COMMENT_ZONE", "HOT_LIST", "plugin-finder_release"})
  public static enum k
  {
    final int source;
    
    static
    {
      AppMethodBeat.i(251046);
      k localk1 = new k("COMMENT_ZONE", 0, 1);
      vod = localk1;
      k localk2 = new k("HOT_LIST", 1, 2);
      voe = localk2;
      vof = new k[] { localk1, localk2 };
      AppMethodBeat.o(251046);
    }
    
    private k(int paramInt)
    {
      this.source = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CoverType;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_COVER_ALBUM_CANCEL", "LIVE_COVER_SHOOT_FRONT_TAKEN", "LIVE_COVER_SHOOT_BACK_TAKEN", "LIVE_COVER_ALBUM_TAKEN", "plugin-finder_release"})
  public static enum l
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251049);
      l locall1 = new l("LIVE_COVER_ALBUM_CANCEL", 0, 5);
      vog = locall1;
      l locall2 = new l("LIVE_COVER_SHOOT_FRONT_TAKEN", 1, 6);
      voh = locall2;
      l locall3 = new l("LIVE_COVER_SHOOT_BACK_TAKEN", 2, 7);
      voi = locall3;
      l locall4 = new l("LIVE_COVER_ALBUM_TAKEN", 3, 8);
      voj = locall4;
      vok = new l[] { locall1, locall2, locall3, locall4 };
      AppMethodBeat.o(251049);
    }
    
    private l(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CoverType2;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_COVER_DEFAULT", "LIVE_COVER_FRONT_CAMERA", "LIVE_COVER_ALBUM", "plugin-finder_release"})
  public static enum m
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(251052);
      m localm1 = new m("LIVE_COVER_DEFAULT", 0, 0);
      vol = localm1;
      m localm2 = new m("LIVE_COVER_FRONT_CAMERA", 1, 6);
      vom = localm2;
      m localm3 = new m("LIVE_COVER_ALBUM", 2, 8);
      von = localm3;
      voo = new m[] { localm1, localm2, localm3 };
      AppMethodBeat.o(251052);
    }
    
    private m(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$EnterRoomStatus;", "", "status", "", "(Ljava/lang/String;IJ)V", "getStatus", "()J", "LIVE_LIVING", "LIVE_STOPPED", "LIVE_IN_BLACK_LIST", "LIVE_NO_ACCESS_PERMISSION", "plugin-finder_release"})
  public static enum n
  {
    public final long jii;
    
    static
    {
      AppMethodBeat.i(251055);
      n localn1 = new n("LIVE_LIVING", 0, 1L);
      vop = localn1;
      n localn2 = new n("LIVE_STOPPED", 1, 2L);
      voq = localn2;
      n localn3 = new n("LIVE_IN_BLACK_LIST", 2, 5L);
      vor = localn3;
      n localn4 = new n("LIVE_NO_ACCESS_PERMISSION", 3, 6L);
      vos = localn4;
      vot = new n[] { localn1, localn2, localn3, localn4 };
      AppMethodBeat.o(251055);
    }
    
    private n(long paramLong)
    {
      this.jii = paramLong;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "LIVE_EXIT_OK", "LIVE_EXIT_ERROR", "LIVE_EXIT_CANCEL_TIMER", "LIVE_EXIT_NOTHING", "plugin-finder_release"})
  public static enum o
  {
    final long dDw;
    
    static
    {
      AppMethodBeat.i(251058);
      o localo1 = new o("LIVE_EXIT_OK", 0, 1L);
      vou = localo1;
      o localo2 = new o("LIVE_EXIT_ERROR", 1, 2L);
      vov = localo2;
      o localo3 = new o("LIVE_EXIT_CANCEL_TIMER", 2, 3L);
      vow = localo3;
      o localo4 = new o("LIVE_EXIT_NOTHING", 3, 4L);
      vox = localo4;
      voy = new o[] { localo1, localo2, localo3, localo4 };
      AppMethodBeat.o(251058);
    }
    
    private o(long paramLong)
    {
      this.dDw = paramLong;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR", "LIVE_AUDIENCE_EXPLORE_FEED_CARD", "LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR", "LIVE_AUDIENCE_CLICK_SINGLE_AVATAR", "LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR", "LIVE_AUDIENCE_ENTER_LIVE_ROOM", "LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL", "LIVE_AUDIENCE_CLICK_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING", "plugin-finder_release"})
  public static enum p
  {
    public final long dDw;
    
    static
    {
      AppMethodBeat.i(251061);
      p localp1 = new p("LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR", 0, 1L);
      voz = localp1;
      p localp2 = new p("LIVE_AUDIENCE_EXPLORE_FEED_CARD", 1, 2L);
      voA = localp2;
      p localp3 = new p("LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR", 2, 3L);
      voB = localp3;
      p localp4 = new p("LIVE_AUDIENCE_CLICK_SINGLE_AVATAR", 3, 4L);
      voC = localp4;
      p localp5 = new p("LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING", 4, 5L);
      voD = localp5;
      p localp6 = new p("LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR", 5, 6L);
      voE = localp6;
      p localp7 = new p("LIVE_AUDIENCE_ENTER_LIVE_ROOM", 6, 7L);
      voF = localp7;
      p localp8 = new p("LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL", 7, 8L);
      voG = localp8;
      p localp9 = new p("LIVE_AUDIENCE_CLICK_AVATAR_LIVING", 8, 9L);
      voH = localp9;
      p localp10 = new p("LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING", 9, 10L);
      voI = localp10;
      p localp11 = new p("LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING", 10, 11L);
      voJ = localp11;
      voK = new p[] { localp1, localp2, localp3, localp4, localp5, localp6, localp7, localp8, localp9, localp10, localp11 };
      AppMethodBeat.o(251061);
    }
    
    private p(long paramLong)
    {
      this.dDw = paramLong;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FilterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ORIGINAL_FILM", "NATURAL", "WHITE", "NOSTALGIA", "AUTUMN", "DELICIOUS", "BLUE", "FILM", "HONGKKONG_STYLE", "plugin-finder_release"})
  public static enum q
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251064);
      q localq1 = new q("ORIGINAL_FILM", 0, 1);
      voL = localq1;
      q localq2 = new q("NATURAL", 1, 2);
      voM = localq2;
      q localq3 = new q("WHITE", 2, 3);
      voN = localq3;
      q localq4 = new q("NOSTALGIA", 3, 4);
      voO = localq4;
      q localq5 = new q("AUTUMN", 4, 5);
      voP = localq5;
      q localq6 = new q("DELICIOUS", 5, 6);
      voQ = localq6;
      q localq7 = new q("BLUE", 6, 7);
      voR = localq7;
      q localq8 = new q("FILM", 7, 8);
      voS = localq8;
      q localq9 = new q("HONGKKONG_STYLE", 8, 9);
      voT = localq9;
      voU = new q[] { localq1, localq2, localq3, localq4, localq5, localq6, localq7, localq8, localq9 };
      AppMethodBeat.o(251064);
    }
    
    private q(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FloatActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_FLOAT_ACTION_UNKNOWN", "LIVE_FLOAT_ACTION_MAXIMIZE", "LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION", "LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE", "LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP", "LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG", "LIVE_FLOAT_ACTION_ENTER_PROFILE", "VISITOR_CLICK_ENTER_LOTTERY_RECORD", "plugin-finder_release"})
  public static enum r
  {
    public final int type;
    
    static
    {
      AppMethodBeat.i(251067);
      r localr1 = new r("LIVE_FLOAT_ACTION_UNKNOWN", 0, 0);
      voV = localr1;
      r localr2 = new r("LIVE_FLOAT_ACTION_MAXIMIZE", 1, 1);
      voW = localr2;
      r localr3 = new r("LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION", 2, 2);
      voX = localr3;
      r localr4 = new r("LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE", 3, 3);
      voY = localr4;
      r localr5 = new r("LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP", 4, 4);
      voZ = localr5;
      r localr6 = new r("LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG", 5, 5);
      vpa = localr6;
      r localr7 = new r("LIVE_FLOAT_ACTION_ENTER_PROFILE", 6, 6);
      vpb = localr7;
      r localr8 = new r("VISITOR_CLICK_ENTER_LOTTERY_RECORD", 7, 7);
      vpc = localr8;
      vpd = new r[] { localr1, localr2, localr3, localr4, localr5, localr6, localr7, localr8 };
      AppMethodBeat.o(251067);
    }
    
    private r(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FollowState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "UNFOLLOW", "FOLLOWED", "plugin-finder_release"})
  public static enum s
  {
    public final int state;
    
    static
    {
      AppMethodBeat.i(251070);
      s locals1 = new s("UNFOLLOW", 0, 0);
      vpe = locals1;
      s locals2 = new s("FOLLOWED", 1, 1);
      vpf = locals2;
      vpg = new s[] { locals1, locals2 };
      AppMethodBeat.o(251070);
    }
    
    private s(int paramInt)
    {
      this.state = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$GIFT_SWITCCH;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLOSE_SEND_GIFT_BY_MORE", "OPEN_SEND_GIFT_BY_MORE", "plugin-finder_release"})
  public static enum t
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251073);
      t localt1 = new t("CLOSE_SEND_GIFT_BY_MORE", 0, 1);
      vph = localt1;
      t localt2 = new t("OPEN_SEND_GIFT_BY_MORE", 1, 2);
      vpi = localt2;
      vpj = new t[] { localt1, localt2 };
      AppMethodBeat.o(251073);
    }
    
    private t(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$GiftSwitch;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "BY_MORE_CLOSE_GIFT", "BY_MORE_OPEN_GIFT", "plugin-finder_release"})
  public static enum u
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251076);
      u localu1 = new u("BY_MORE_CLOSE_GIFT", 0, 1);
      vpk = localu1;
      u localu2 = new u("BY_MORE_OPEN_GIFT", 1, 2);
      vpl = localu2;
      vpm = new u[] { localu1, localu2 };
      AppMethodBeat.o(251076);
    }
    
    private u(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$IsGift;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "YES", "NO", "plugin-finder_release"})
  public static enum v
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251079);
      v localv1 = new v("YES", 0, 1);
      vpn = localv1;
      v localv2 = new v("NO", 1, 2);
      vpo = localv2;
      vpp = new v[] { localv1, localv2 };
      AppMethodBeat.o(251079);
    }
    
    private v(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$JspiCommenScene;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PUBLIC_NUMBER", "SEARCH_1_SEARCH", "SEE_1_SEE", "GAME_CENTER", "LITTLE_APP", "plugin-finder_release"})
  public static enum w
  {
    final String type;
    
    static
    {
      AppMethodBeat.i(251082);
      w localw1 = new w("PUBLIC_NUMBER", 0, "5");
      vpq = localw1;
      w localw2 = new w("SEARCH_1_SEARCH", 1, "6");
      vpr = localw2;
      w localw3 = new w("SEE_1_SEE", 2, "7");
      vps = localw3;
      w localw4 = new w("GAME_CENTER", 3, "9");
      vpt = localw4;
      w localw5 = new w("LITTLE_APP", 4, "15");
      vpu = localw5;
      vpv = new w[] { localw1, localw2, localw3, localw4, localw5 };
      AppMethodBeat.o(251082);
    }
    
    private w(String paramString)
    {
      this.type = paramString;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkOp;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_LINKMIC_LOGO", "CONNECT_VOICE_TO_LINKMIC", "CONNECT_VIDEO_TO_LINKMIC", "DISCONNECT_VOICE_TO_LINKMIC", "DISCONNECT_VIDEO_TO_LINKMIC", "plugin-finder_release"})
  public static enum x
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251085);
      x localx1 = new x("CLICK_LINKMIC_LOGO", 0, 1);
      vpw = localx1;
      x localx2 = new x("CONNECT_VOICE_TO_LINKMIC", 1, 2);
      vpx = localx2;
      x localx3 = new x("CONNECT_VIDEO_TO_LINKMIC", 2, 3);
      vpy = localx3;
      x localx4 = new x("DISCONNECT_VOICE_TO_LINKMIC", 3, 4);
      vpz = localx4;
      x localx5 = new x("DISCONNECT_VIDEO_TO_LINKMIC", 4, 5);
      vpA = localx5;
      vpB = new x[] { localx1, localx2, localx3, localx4, localx5 };
      AppMethodBeat.o(251085);
    }
    
    private x(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkSwitch;", "", "action", "", "(Ljava/lang/String;II)V", "getAction", "()I", "OPEN", "CLOSE", "plugin-finder_release"})
  public static enum y
  {
    public final int action;
    
    static
    {
      AppMethodBeat.i(251088);
      y localy1 = new y("OPEN", 0, 1);
      vpC = localy1;
      y localy2 = new y("CLOSE", 1, 2);
      vpD = localy2;
      vpE = new y[] { localy1, localy2 };
      AppMethodBeat.o(251088);
    }
    
    private y(int paramInt)
    {
      this.action = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "INVALIDATE", "AUDIO", "VIDEO", "plugin-finder_release"})
  public static enum z
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(251091);
      z localz1 = new z("INVALIDATE", 0, 0);
      vpF = localz1;
      z localz2 = new z("AUDIO", 1, 1);
      vpG = localz2;
      z localz3 = new z("VIDEO", 2, 2);
      vpH = localz3;
      vpI = new z[] { localz1, localz2, localz3 };
      AppMethodBeat.o(251091);
    }
    
    private z(int paramInt)
    {
      this.type = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.s
 * JD-Core Version:    0.7.0.1
 */