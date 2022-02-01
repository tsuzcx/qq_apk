package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.b.b.a;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRedDotManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;)V", "careExptKey", "", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "ctrlInfoAtPathFilterList", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "", "disposeRedDotAtPathIgnoreList", "dynamicTimeHelper", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderDynamicTimeHelper;", "getDynamicTimeHelper", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderDynamicTimeHelper;", "enterSource", "", "enterTabTipsExtInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$EnterTabTipsExtInfo;", "enterTime", "", "entranceCtrlTypeWhenEnter", "getEntranceCtrlTypeWhenEnter", "()I", "setEntranceCtrlTypeWhenEnter", "(I)V", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1;", "expireHandler", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler;", "getExpireHandler", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler;", "setExpireHandler", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler;)V", "finderRedDotTrigger", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTrigger;", "getFinderRedDotTrigger", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTrigger;", "hasRedDotWhenEnter", "msgRedDotHandler", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "getMsgRedDotHandler", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "newTipsTransform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "noFoundRevokeIdSet", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTipsInfo;", "notifyTabTipsListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$notifyTabTipsListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$notifyTabTipsListener$1;", "pathToCtrInfoMap", "", "revokeIdToCtrInfoMap", "stateCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stayDuration", "textInfoPair", "getTextInfoPair", "()Lkotlin/Pair;", "setTextInfoPair", "(Lkotlin/Pair;)V", "throwRedDotIncludesPath", "Ljava/util/concurrent/ConcurrentSkipListSet;", "getThrowRedDotIncludesPath", "()Ljava/util/concurrent/ConcurrentSkipListSet;", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "getTransform", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "addNewRedDotCtrlInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "changePathSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "isClearOldSameType", "clearedEntrancePair", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "extraWork", "", "aiScene", "allowRedDotTypeInTeenMode", "type", "(Ljava/lang/Integer;)Z", "buildPathWithCtrInfo", "local", "checkClearDiscoveryRedDot", "checkColdTimeExpired", "path", "checkIgnoreForAppPush", "checkInsertLiveTaskRedDot", "checkRedDotOverride", "ctrlInfo", "lastCtrlInfo", "lastShowInfo", "clearCtrlInfo", "ctrInfo", "filter", "Lkotlin/ParameterName;", "name", "clearEnterTabTipsExtInfo", "enterCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "clearShowInfoAtCtrlInfo", "isForceRemove", "containsTabTipsExtInfo", "tabType", "convertEnterActionToTabType", "enterAction", "ctrlInfoAtPath", "disposeRedDotAtPath", "call", "ctrlType", "", "enterFinder", "exitFinder", "exitFinderBefore", "activity", "Landroid/app/Activity;", "filterNotifyTabTip", "tabTip", "Lcom/tencent/mm/protocal/protobuf/FinderTabTipsInfo;", "findByRevokeId", "revokeId", "findExtInfoAtCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "generateFullScreenRedDot", "getAliveTabType", "getAllCtrlInfo", "", "getCtrlInfoByPath", "getCtrlInfoMap", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "getDiffExitTimeMs", "getEnterAction", "getEnterTabTipsExtInfo", "getEnterTabTipsId", "getEnterTabTypeInCtrlInfo", "getFinderLiveDiffExitTimeMs", "getLastCtrlInfo", "ctrlInfoMap", "getLatestCtrlInfo", "ctrlInfo1", "ctrlInfo2", "getNearbyDiffExitTimeMs", "getShowInfoPathsFromCtrlInfo", "getTabPathByTabType", "getTabTipsExtInfo", "getTabTypeByPath", "getTipsShowInfoAtPath", "handleClearDiscoveryRedDot", "priority", "handleCreatorCenterRedDot", "handleShowInfoForAppPushByPath", "isIgnoreDependency", "isReportAllPath", "increaseRedDotExpose", "insertDataForTest", "count", "isContainsPath", "isEnableShowEntranceRedDot", "isEnableShowFinderLiveEntranceRedDot", "isEnableShowNearByEntranceRedDot", "isEnableShowNearbyV3EntryRedDot", "isExpired", "isForRefreshTab", "mergeFinderMentionCtrlInfo", "mockTopicRedDot", "notifyFinderFansAddCount", "notifyFinderLiveFirstReward", "notifyFinderMsgCount", "likeCount", "commentCount", "followCount", "notifyRedDot", "redDot", "Lcom/tencent/mm/protocal/protobuf/FinderRedDot;", "notifyTabTip", "tabTips", "Lcom/tencent/mm/protocal/protobuf/FinderTabTips;", "notifyWxMentionCount", "wxMention", "Lcom/tencent/mm/protocal/protobuf/FinderWxMentionCount;", "notifyWxMsgCount", "onExptChange", "key", "onFinderBackground", "onFinderForeground", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "printCtrInfo", "printTipsShowInfo", "index", "reBuildPathWithCtrInfo", "recordCtrlInfo", "clearedCtrlInfo", "removeFinderEntrance", "removeShowInfo", "reportOverride", "beforePair", "resetNotifyAllPathWithCrlInfo", "revokePathRedDot", "revoke", "Lcom/tencent/mm/protocal/protobuf/FinderRevokePathRedDot;", "revokeTabTips", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTips;", "saveEnterTabTipsExtInfo", "setEnableShowEntranceRedDot", "isEnable", "setEnableShowFinderLiveEntranceRedDot", "setEnableShowNearByEntranceRedDot", "setEnableShowNearbyV3EntryRedDot", "storeTextRedDotInfo", "tipsId", "textLines", "unPrepare", "updateFindMoreFriendUI", "updateFinderEntryCount", "Companion", "EnterTabTipsExtInfo", "FinderTipsShowTabExt", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements com.tencent.mm.am.h, bl
{
  private static boolean AQO;
  public static final a AQs;
  private final a AQA;
  private final List<c.a> AQB;
  private final FinderRedDotManager.entryConfigChangeListener.1 AQC;
  private final FinderRedDotManager.notifyTabTipsListener.1 AQD;
  public long AQE;
  public int AQF;
  public boolean AQG;
  public int AQH;
  private final ConcurrentHashMap<String, List<p>> AQI;
  private final ConcurrentHashMap<String, p> AQJ;
  private final List<kotlin.g.a.b<p, Boolean>> AQK;
  private final List<kotlin.r<kotlin.g.a.b<p, Boolean>, kotlin.g.a.b<p, Boolean>>> AQL;
  public final ConcurrentHashMap<String, b> AQM;
  private final ConcurrentHashMap<String, bum> AQN;
  public final f AQt;
  public final n AQu;
  public final b AQv;
  public kotlin.r<String, Integer> AQw;
  private final c AQx;
  private final com.tencent.mm.plugin.finder.viewmodel.d AQy;
  private final o AQz;
  public final ConcurrentSkipListSet<String> DIg;
  public h DJe;
  public long enterTime;
  
  static
  {
    AppMethodBeat.i(178166);
    AQs = new a((byte)0);
    AppMethodBeat.o(178166);
  }
  
  public i(f paramf)
  {
    AppMethodBeat.i(178184);
    this.AQt = paramf;
    this.AQu = new n(this);
    this.AQv = new b(this);
    this.AQx = new c(this);
    paramf = k.aeZF;
    paramf = k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    s.s(paramf, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.AQy = ((com.tencent.mm.plugin.finder.viewmodel.d)paramf);
    this.AQz = new o();
    this.AQA = new a();
    this.DIg = new ConcurrentSkipListSet();
    this.AQB = kotlin.a.p.listOf(c.a.zcp);
    this.AQC = new FinderRedDotManager.entryConfigChangeListener.1(this, com.tencent.mm.app.f.hfK);
    this.AQD = new FinderRedDotManager.notifyTabTipsListener.1(this, com.tencent.mm.app.f.hfK);
    this.AQI = new ConcurrentHashMap();
    this.AQJ = new ConcurrentHashMap();
    this.AQK = kotlin.a.p.listOf(new kotlin.g.a.b[] { (kotlin.g.a.b)new p(this), (kotlin.g.a.b)q.ARe });
    this.AQL = kotlin.a.p.listOf(new kotlin.r[] { new kotlin.r(k.AQZ, new l(this)), new kotlin.r(m.ARb, n.ARc) });
    this.AQM = new ConcurrentHashMap();
    this.AQN = new ConcurrentHashMap();
    AppMethodBeat.o(178184);
  }
  
  public static String Nu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 3: 
      return "TLFollow";
    case 1: 
      return "TLRecommendTab";
    case 4: 
      return "finder_tl_hot_tab";
    case 2: 
      return "finder_tl_nearby_tab";
    case 1002: 
      return "NearbyFeedTab";
    case 1001: 
      return "NearbyLiveTab";
    }
    return "NearbyPeopleTab";
  }
  
  private p a(btw parambtw, String paramString, HashSet<String> paramHashSet, boolean paramBoolean, kotlin.r<p, ? extends bxq> paramr, kotlin.g.a.b<? super p, ah> paramb, long paramLong)
  {
    AppMethodBeat.i(366906);
    s.u(paramString, "source");
    s.u(paramHashSet, "changePathSet");
    if (parambtw == null)
    {
      AppMethodBeat.o(366906);
      return null;
    }
    Object localObject1 = k.aeZF;
    int i;
    if (!((com.tencent.mm.plugin.finder.viewmodel.d)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(4).GKD) {
      i = 0;
    }
    while (i != 0)
    {
      Log.w("Finder.RedDotManager", s.X("[addNewRedDotCtrlInfo] ignore this reddot ", e(parambtw)));
      AppMethodBeat.o(366906);
      return null;
      if ((a(parambtw, "TLFollow", false, true, 4)) || (a(parambtw, "TLRecommendTab", false, true, 4)) || (a(parambtw, "finder_tl_hot_tab", false, true, 4)))
      {
        i = 1;
      }
      else
      {
        a(parambtw, "TLPersonalCenter", false, false, 8);
        a(parambtw, "FinderEntrance", false, false, 8);
        a(parambtw, "Discovery", false, false, 8);
        i = 0;
      }
    }
    if (paramr == null) {}
    Object localObject2;
    Object localObject4;
    for (localObject1 = null;; localObject1 = (p)paramr.bsC)
    {
      localObject3 = null;
      localObject2 = localObject3;
      if (parambtw != null)
      {
        localObject2 = parambtw.aabA;
        s.s(localObject2, "show_infos");
        localObject4 = ((Iterable)localObject2).iterator();
        do
        {
          localObject2 = localObject3;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
        } while (!s.p("FinderEntrance", ((bxq)((Iterator)localObject4).next()).path));
        localObject2 = Su("FinderEntrance");
        if (!s.p(localObject2, localObject1)) {
          break;
        }
      }
      if (paramr != null) {
        break label587;
      }
      localObject1 = null;
      label289:
      if (!s.p(localObject2, localObject1)) {
        break label613;
      }
      if (paramr != null) {
        break label600;
      }
      paramr = null;
      label307:
      if (paramBoolean) {
        Nv(parambtw.type);
      }
      if (!dZs())
      {
        localObject1 = parambtw.aabA;
        s.s(localObject1, "info.show_infos");
        com.tencent.mm.ae.d.a((LinkedList)localObject1, (kotlin.g.a.b)d.AQT);
        Log.i("Finder.RedDotManager", "[addNewRedDotCtrlInfo] remove DISCOVERY_TAB");
      }
      localObject4 = new p().a(parambtw, paramLong);
      ConcurrentHashMap localConcurrentHashMap = this.AQN;
      localObject3 = ((p)localObject4).field_revokeId;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      if (!localConcurrentHashMap.contains(localObject1)) {
        break label637;
      }
      Log.e("Finder.RedDotManager", "[addNewRedDotCtrlInfo] has revoke. " + ((p)localObject4).field_revokeId + ' ' + e(((p)localObject4).field_ctrInfo));
      AppMethodBeat.o(366906);
      return null;
    }
    Object localObject3 = localObject2;
    if (localObject1 != null) {
      if (localObject2 == null)
      {
        localObject4 = null;
        label495:
        localObject3 = localObject2;
        if (localObject4 != null) {
          break label1262;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      if (((p)localObject2).field_ctrInfo.priority >= ((p)localObject1).field_ctrInfo.priority)
      {
        localObject3 = localObject2;
        if (((p)localObject2).field_ctrInfo.priority == ((p)localObject2).field_ctrInfo.priority)
        {
          localObject3 = localObject2;
          if (((p)localObject2).field_time >= ((p)localObject1).field_time) {}
        }
      }
      else
      {
        localObject3 = localObject1;
      }
      localObject4 = ah.aiuX;
      localObject2 = localObject3;
      break label495;
      label587:
      localObject1 = (p)paramr.bsC;
      break label289;
      label600:
      paramr = (bxq)paramr.bsD;
      break label307;
      label613:
      if (localObject2 == null)
      {
        paramr = null;
        break label307;
      }
      paramr = ((p)localObject2).avK("FinderEntrance");
      break label307;
      label637:
      if ((c(parambtw, "FinderEntrance")) && (!c(parambtw, "Discovery")))
      {
        ev("FinderEntrance", parambtw.priority);
        if (paramb != null) {
          paramb.invoke(localObject4);
        }
        if (!p.a((p)localObject4, (MAutoStorage)this.AQt)) {
          break label1254;
        }
        paramHashSet.addAll((Collection)a((p)localObject4, paramString));
        paramHashSet = new kotlin.r(localObject2, paramr);
        paramString = avt("FinderEntrance");
        if (paramString != null) {
          break label1046;
        }
        paramString = null;
        paramr = (p)paramHashSet.bsC;
        paramb = (bxq)paramHashSet.bsD;
        if (!Util.isNullOrNil("FinderEntrance")) {
          break label1057;
        }
        Log.e("Finder.RedDotManager", "path: " + "FinderEntrance" + " is empty!");
        paramString = r.ASG;
        s.u(parambtw, "ctrlInfo");
        Log.i("Finder.ThreeDayTwoDay", "checkRedDotFilter");
        if (!paramString.ebe()) {
          break label1248;
        }
        paramLong = com.tencent.mm.kernel.h.baE().ban().a(at.a.addV, 0L);
        if (paramLong == 0L) {
          break label1248;
        }
        long l = cn.bDw() - paramLong;
        parambtw = com.tencent.mm.plugin.finder.storage.d.FAy;
        i = ((Number)com.tencent.mm.plugin.finder.storage.d.eUt().bmg()).intValue();
        if (i < l) {
          break label1236;
        }
        paramBoolean = true;
        Log.i("Finder.ThreeDayTwoDay", "[checkInLimitTwoDay] isInLimit=" + paramBoolean + " twoDayThreshold=" + i + " diffTime=" + l + " hitThreeDayTime=" + paramLong);
        if (!paramBoolean) {
          break label1242;
        }
      }
      label739:
      label884:
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          parambtw = r.Asl;
          if (parambtw != null) {
            parambtw.TL("FinderEntrance");
          }
        }
        AppMethodBeat.o(366906);
        return localObject4;
        if ((c(parambtw, "FinderLiveEntrance")) && (!c(parambtw, "Discovery")))
        {
          ev("FinderLiveEntrance", parambtw.priority);
          break;
        }
        if ((!c(parambtw, "NearbyEntrance")) || (c(parambtw, "Discovery"))) {
          break;
        }
        ev("NearbyEntrance", parambtw.priority);
        break;
        paramString = (p)paramString.bsC;
        break label739;
        if ((paramr == null) || (s.p(paramr, paramString))) {
          break label797;
        }
        localObject1 = new StringBuilder("20951, ").append(paramr.field_ctrInfo.type).append(" show_type:");
        if (paramb == null)
        {
          paramHashSet = null;
          localObject1 = ((StringBuilder)localObject1).append(paramHashSet).append(" field_tipsId: ").append(paramr.field_tipsId).append(" ctrlInfo.field_tipsId: ");
          if (paramString != null) {
            break label1210;
          }
          paramHashSet = null;
          label1141:
          Log.i("Finder.RedDotManager", paramHashSet);
          paramHashSet = av.GiL;
          paramHashSet = aw.Gjk;
          if (paramb == null) {
            break label797;
          }
          paramHashSet = w.FrV;
          if (paramString != null) {
            break label1218;
          }
          paramString = "";
        }
        for (;;)
        {
          w.a(paramr, paramb, 6, 0, null, paramString, 24);
          break;
          paramHashSet = Integer.valueOf(paramb.show_type);
          break label1107;
          paramHashSet = paramString.field_tipsId;
          break label1141;
          paramHashSet = paramString.field_tipsId;
          paramString = paramHashSet;
          if (paramHashSet == null) {
            paramString = "";
          }
        }
        paramBoolean = false;
        break label884;
        r.reset(cn.bDw());
      }
      label797:
      label1057:
      label1107:
      label1236:
      label1242:
      label1248:
      label1254:
      AppMethodBeat.o(366906);
      label1046:
      label1210:
      label1218:
      return null;
      label1262:
      localObject1 = localObject3;
    }
  }
  
  private static String a(bxq parambxq, int paramInt)
  {
    AppMethodBeat.i(178181);
    if (parambxq == null)
    {
      AppMethodBeat.o(178181);
      return "[empty]";
    }
    Object localObject1 = null;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject2 = new bxr();
      localObject3 = parambxq.aags;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (parambxq.aagr == 2)
        {
          ((bxr)localObject2).parseFrom(((com.tencent.mm.bx.b)localObject3).toByteArray());
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = new StringBuilder();
    Object localObject3 = ((StringBuilder)localObject2).append('#').append(paramInt).append("{showType=").append(parambxq.show_type).append(" count=").append(parambxq.count).append(" title=").append(parambxq.title).append(" clearType=").append(parambxq.aagq).append(" iconUrl=").append(parambxq.icon_url).append(" path=").append(parambxq.path).append(" show_ext_info_type=").append(parambxq.aagr).append(" parent=").append(parambxq.Nnp).append(' ');
    if (localObject1 != null) {}
    for (localObject1 = s.X("jumpPriority=", Integer.valueOf(((bxr)localObject1).aagC));; localObject1 = "")
    {
      ((StringBuilder)localObject3).append((String)localObject1).append(" ignore_freq_limit=").append(parambxq.aagw).append("} ");
      parambxq = ((StringBuilder)localObject2).toString();
      AppMethodBeat.o(178181);
      return parambxq;
    }
  }
  
  private final HashSet<String> a(p paramp, String paramString)
  {
    AppMethodBeat.i(366937);
    Log.i("Finder.RedDotManager", "[buildPathWithCtrInfo] source=" + paramString + ' ' + e(paramp.field_ctrInfo) + " revokeId=" + paramp.field_revokeId);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Map)paramp.ASx).entrySet().iterator();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      paramString = (List)this.AQI.get(((Map.Entry)localObject1).getKey());
      if (paramString != null) {
        break label442;
      }
      localObject2 = (i)this;
      paramString = Collections.synchronizedList((List)new LinkedList());
      localObject2 = (Map)((i)localObject2).AQI;
      localObject3 = ((Map.Entry)localObject1).getKey();
      s.s(paramString, "list");
      ((Map)localObject2).put(localObject3, paramString);
    }
    label426:
    label442:
    for (;;)
    {
      com.tencent.mm.ae.d.a(paramString, (kotlin.g.a.b)new i.e(paramp));
      paramString.add(paramp);
      localObject2 = new kotlin.g.a.b[2];
      localObject2[0] = ((kotlin.g.a.b)f.AQU);
      localObject2[1] = ((kotlin.g.a.b)i.g.AQV);
      s.u(localObject2, "selectors");
      kotlin.a.p.a(paramString, (Comparator)new b.a((kotlin.g.a.b[])localObject2));
      localHashSet.add(((Map.Entry)localObject1).getKey());
      break;
      paramString = paramp.field_revokeId;
      if (paramString != null) {
        ((Map)this.AQJ).put(paramString, paramp);
      }
      localIterator = ((Iterable)localHashSet).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        localObject2 = Su((String)localObject1);
        if (localObject2 == null)
        {
          paramp = null;
          label346:
          localObject3 = new StringBuilder("[buildPathWithCtrInfo] ctrlInfo:").append(localObject2).append(" ,path:");
          if (paramp != null) {
            break label426;
          }
        }
        for (paramString = null;; paramString = paramp.path)
        {
          Log.i("Finder.RedDotManager", paramString);
          if ((localObject2 == null) || (paramp == null)) {
            break;
          }
          paramString = l.ARA;
          l.a(true, (String)localObject1, paramp, (p)localObject2);
          break;
          paramp = ((p)localObject2).avK((String)localObject1);
          break label346;
        }
      }
      AppMethodBeat.o(366937);
      return localHashSet;
    }
  }
  
  private static boolean a(btw parambtw, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(366923);
    Object localObject3 = parambtw.aabA.iterator();
    s.s(localObject3, "info.show_infos.iterator()");
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject1 = (bxq)((Iterator)localObject3).next();
    } while (!s.p(((bxq)localObject1).path, paramString));
    ((Iterator)localObject3).remove();
    if ((localObject1 != null) && (!paramBoolean1))
    {
      localObject2 = parambtw.aabA.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bxq)((Iterator)localObject2).next();
        if (s.p(((bxq)localObject3).Nnp, paramString)) {
          ((bxq)localObject3).Nnp = "";
        }
      }
    }
    Log.i("Finder.RedDotManager", "handleShowInfoForAppPushByPath path:" + paramString + " isIgnoreDependency:" + paramBoolean1 + " showInfo:" + localObject1);
    if (localObject1 != null)
    {
      paramString = w.FrV;
      w.a(parambtw, (bxq)localObject1);
      if (paramBoolean2)
      {
        paramString = parambtw.aabA;
        s.s(paramString, "info.show_infos");
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext())
        {
          localObject2 = (bxq)paramString.next();
          localObject3 = w.FrV;
          s.s(localObject2, "it");
          w.a(parambtw, (bxq)localObject2);
        }
      }
    }
    if (localObject1 != null)
    {
      AppMethodBeat.o(366923);
      return true;
    }
    AppMethodBeat.o(366923);
    return false;
  }
  
  private final boolean a(bxi parambxi)
  {
    Iterator localIterator = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    int i = -1;
    AppMethodBeat.i(366954);
    Object localObject1 = parambxi.aagf;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label85;
      }
    }
    label49:
    label54:
    label59:
    label64:
    label85:
    label95:
    boolean bool;
    for (;;)
    {
      if (localObject1 == null)
      {
        if (localObject1 != null) {
          break label281;
        }
        if (localObject1 != null) {
          break label294;
        }
        if (localObject1 != null) {
          break label307;
        }
        if (localObject1 != null) {
          break label320;
        }
        break label783;
        AppMethodBeat.o(366954);
        return true;
        localObject1 = Integer.valueOf(((btw)localObject1).type);
        break;
        if (((Integer)localObject1).intValue() == 8)
        {
          if (AQO)
          {
            localObject7 = parambxi.aagf;
            if (localObject7 != null)
            {
              localObject7 = ((btw)localObject7).aabA;
              if (localObject7 != null) {
                kotlin.a.p.e((List)localObject7, (kotlin.g.a.b)r.ARf);
              }
            }
            AQO = false;
          }
          bool = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUe();
          localObject7 = parambxi.aagf;
          if (localObject7 == null) {
            break label341;
          }
          localObject7 = ((btw)localObject7).aabA;
          if (localObject7 == null) {
            break label341;
          }
          localObject7 = ((Iterable)localObject7).iterator();
          bxq localbxq;
          do
          {
            if (!((Iterator)localObject7).hasNext()) {
              break;
            }
            localbxq = (bxq)((Iterator)localObject7).next();
          } while ((!bool) || (!this.DIg.contains(localbxq.path)));
          parambxi = parambxi.aagf;
          if (parambxi != null) {
            break label333;
          }
        }
      }
    }
    label281:
    label294:
    label307:
    label320:
    label333:
    for (parambxi = null;; parambxi = parambxi.ZYN)
    {
      Log.i("Finder.RedDotManager", s.X("[filterNotifyTabTip] FinderFriendTabLikeTipsView isShowing, ignore this tabTip ", parambxi));
      AppMethodBeat.o(366954);
      return false;
      if (((Integer)localObject1).intValue() == 7) {
        break label95;
      }
      break;
      if (((Integer)localObject1).intValue() == 17) {
        break label95;
      }
      break label49;
      if (((Integer)localObject1).intValue() == 9) {
        break label95;
      }
      break label54;
      if (((Integer)localObject1).intValue() == 13) {
        break label95;
      }
      break label59;
      if (((Integer)localObject1).intValue() != 16) {
        break label64;
      }
      break label95;
    }
    label341:
    Object localObject7 = parambxi.aagf;
    int j;
    int k;
    if ((localObject7 != null) && (((btw)localObject7).aabB > 0))
    {
      j = this.AQy.GKq;
      k = this.AQy.GKp;
      bool = this.AQy.Rp(((btw)localObject7).aabB);
      Log.i("Finder.RedDotManager", "[filterNotifyTabTip] currentTabType=" + k + " lastTabType=" + j + "  ignore_tab_type=" + ((btw)localObject7).aabB + " isAutoRefresh=" + bool);
      if ((((btw)localObject7).aabC) && (((k <= 0) && (((btw)localObject7).aabB == j) && (!bool)) || (k == ((btw)localObject7).aabB)))
      {
        localObject1 = new StringBuilder("[filterNotifyTabTip] remove this ctrlInfo type=");
        parambxi = parambxi.aagf;
        if (parambxi == null) {}
        for (parambxi = (bxi)localObject6;; parambxi = Integer.valueOf(parambxi.type))
        {
          Log.i("Finder.RedDotManager", parambxi + " currentTabType=" + k + " lastTabType=" + j);
          AppMethodBeat.o(366954);
          return false;
        }
      }
    }
    localObject6 = parambxi.aagf;
    if (localObject6 != null)
    {
      localObject6 = ((btw)localObject6).aabA;
      if (localObject6 != null)
      {
        localObject6 = ((List)localObject6).iterator();
        j = 0;
        if (((Iterator)localObject6).hasNext())
        {
          localObject7 = (bxq)((Iterator)localObject6).next();
          Log.i("Finder.RedDotManager", s.X("[filterNotifyTabTip] path:", ((bxq)localObject7).path));
          if ((s.p(((bxq)localObject7).path, "FinderEntrance")) || (s.p(((bxq)localObject7).path, "NearbyEntrance")) || (s.p(((bxq)localObject7).path, "FinderLiveEntrance")))
          {
            k = 1;
            label687:
            if (k == 0) {
              break label735;
            }
            label692:
            if (j < 0) {
              break label758;
            }
            parambxi = parambxi.aagf;
            if (parambxi != null) {
              break label747;
            }
          }
        }
      }
    }
    label735:
    label747:
    for (parambxi = localIterator;; parambxi = Integer.valueOf(parambxi.type))
    {
      Log.i("Finder.RedDotManager", s.X("[filterNotifyTabTip] has FINDER_ENTRANCE or NEARBY_ENTRANCE or FINDER_LIVE_ENTRANCE type=", parambxi));
      AppMethodBeat.o(366954);
      return true;
      k = 0;
      break label687;
      j += 1;
      break;
      j = -1;
      break label692;
    }
    label758:
    if (localObject1 == null)
    {
      label763:
      if (localObject1 != null) {
        break label990;
      }
      if (localObject1 != null) {
        break label1120;
      }
    }
    label778:
    label783:
    label844:
    label879:
    label1015:
    while (localObject2.intValue() != 7)
    {
      if (localObject1 != null) {
        break label1220;
      }
      if (localObject1 != null) {
        break label1233;
      }
      if ((localObject1 == null) || (((Integer)localObject1).intValue() != 16)) {
        break;
      }
      localObject5 = this.AQI;
      localObject1 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
        break label1402;
      }
      localObject1 = "FinderLiveEntrance";
      localObject1 = (List)((ConcurrentHashMap)localObject5).get(localObject1);
      if (localObject1 != null) {
        break label1410;
      }
      if (i < 0) {
        break label1507;
      }
      bool = true;
      localObject1 = new StringBuilder("[filterNotifyTabTip] ignore[").append(bool).append("] this tabTip type=");
      parambxi = parambxi.aagf;
      if (parambxi != null) {
        break label1513;
      }
      parambxi = (bxi)localObject4;
      Log.i("Finder.RedDotManager", parambxi);
      if (bool) {
        break label1524;
      }
      AppMethodBeat.o(366954);
      return true;
      if (((Integer)localObject1).intValue() != 8) {
        break label763;
      }
      parambxi = (List)this.AQI.get("FinderEntrance");
      if (parambxi == null)
      {
        if (i < 0) {
          break label1106;
        }
        bool = true;
      }
      for (;;)
      {
        for (;;)
        {
          Log.i("Finder.RedDotManager", "[filterNotifyTabTip] ignore[" + bool + "] this tabTip type=" + localObject1);
          if (bool) {
            break label1112;
          }
          AppMethodBeat.o(366954);
          return true;
          if (((Integer)localObject1).intValue() != 9) {
            break;
          }
          break label917;
          try
          {
            localObject4 = parambxi.iterator();
            i = 0;
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = (p)((Iterator)localObject4).next();
              if (((p)localObject5).field_ctrInfo.type != 8)
              {
                j = ((p)localObject5).field_ctrInfo.type;
                if (j != 9) {}
              }
              else
              {
                j = 1;
                if (j == 0) {
                  break label1081;
                }
              }
            }
            for (;;)
            {
              break;
              j = 0;
              break label1067;
              i += 1;
              break label1015;
              i = -1;
            }
            bool = false;
          }
          finally
          {
            AppMethodBeat.o(366954);
          }
        }
      }
      AppMethodBeat.o(366954);
      return false;
    }
    label917:
    label990:
    label1120:
    label1150:
    Object localObject3;
    for (;;)
    {
      label1067:
      label1081:
      label1106:
      label1112:
      localObject4 = (List)this.AQI.get("FinderEntrance");
      if (localObject4 != null) {
        break label1246;
      }
      if (i < 0) {
        break label1377;
      }
      bool = true;
      label1157:
      localObject3 = new StringBuilder("[filterNotifyTabTip] ignore[").append(bool).append("] this tabTip type=");
      parambxi = parambxi.aagf;
      if (parambxi != null) {
        break label1383;
      }
      parambxi = (bxi)localObject5;
      label1192:
      Log.i("Finder.RedDotManager", parambxi);
      if (bool) {
        break label1394;
      }
      AppMethodBeat.o(366954);
      return true;
      label1220:
      if (((Integer)localObject3).intValue() != 13)
      {
        break label778;
        label1233:
        if (((Integer)localObject3).intValue() != 17) {
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          label1246:
          localIterator = ((List)localObject4).iterator();
          j = 0;
          k = i;
          if (localIterator.hasNext())
          {
            k = ((p)localIterator.next()).field_ctrInfo.type;
            if (k == 7) {
              break label1532;
            }
            if (localObject3 == null)
            {
              if (localObject3 != null) {
                continue;
              }
              k = 0;
              if (k == 0) {
                continue;
              }
              k = j;
            }
          }
          else
          {
            i = k;
            break label1150;
          }
          if (((Integer)localObject3).intValue() != 13) {
            continue;
          }
          break label1532;
          k = ((Integer)localObject3).intValue();
          if (k != 17) {
            continue;
          }
          break label1532;
          j += 1;
          continue;
          bool = false;
        }
        finally
        {
          AppMethodBeat.o(366954);
        }
        label1377:
        break label1157;
        label1383:
        parambxi = Integer.valueOf(parambxi.type);
        break label1192;
        label1394:
        AppMethodBeat.o(366954);
        return false;
        label1402:
        localObject3 = "NearbyEntrance";
        break;
        try
        {
          label1410:
          localObject5 = ((List)localObject3).iterator();
          j = 0;
          for (;;)
          {
            k = i;
            if (((Iterator)localObject5).hasNext())
            {
              k = ((p)((Iterator)localObject5).next()).field_ctrInfo.type;
              if (k != 16) {
                break label1482;
              }
            }
            label1482:
            for (k = 1;; k = 0)
            {
              if (k == 0) {
                break label1488;
              }
              k = j;
              i = k;
              break;
            }
            label1488:
            j += 1;
          }
          bool = false;
        }
        finally
        {
          AppMethodBeat.o(366954);
        }
      }
      label1507:
      break label844;
      label1513:
      parambxi = Integer.valueOf(parambxi.type);
      break label879;
      label1524:
      AppMethodBeat.o(366954);
      return false;
      label1532:
      k = 1;
    }
  }
  
  private static int avq(String paramString)
  {
    AppMethodBeat.i(366940);
    s.u(paramString, "path");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  AppMethodBeat.o(366940);
                  return -1;
                } while (!paramString.equals("NearbyFeedTab"));
                AppMethodBeat.o(366940);
                return 1002;
              } while (!paramString.equals("TLFollow"));
              AppMethodBeat.o(366940);
              return 3;
            } while (!paramString.equals("NearbyLiveTab"));
            AppMethodBeat.o(366940);
            return 1001;
          } while (!paramString.equals("finder_tl_hot_tab"));
          AppMethodBeat.o(366940);
          return 4;
        } while (!paramString.equals("NearbyPeopleTab"));
        AppMethodBeat.o(366940);
        return 1003;
      } while (!paramString.equals("finder_tl_nearby_tab"));
      AppMethodBeat.o(366940);
      return 2;
    } while (!paramString.equals("TLRecommendTab"));
    AppMethodBeat.o(366940);
    return 1;
  }
  
  private final kotlin.r<p, bxq> avt(String paramString)
  {
    AppMethodBeat.i(366961);
    paramString = Su(paramString);
    if (paramString != null)
    {
      paramString = new kotlin.r(paramString, paramString.avK("FinderEntrance"));
      AppMethodBeat.o(366961);
      return paramString;
    }
    AppMethodBeat.o(366961);
    return null;
  }
  
  private final HashMap<String, LinkedList<p>> c(int paramInt, kotlin.g.a.b<? super p, Boolean> paramb)
  {
    AppMethodBeat.i(366941);
    Log.i("Finder.RedDotManager", s.X("getCtrlInfoMap type:", Integer.valueOf(paramInt)));
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = ((Map)this.AQI).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (Map.Entry)localIterator1.next();
      String str = (String)((Map.Entry)localObject).getKey();
      synchronized ((Iterable)((Map.Entry)localObject).getValue())
      {
        Iterator localIterator2 = ???.iterator();
        while (localIterator2.hasNext())
        {
          p localp = (p)localIterator2.next();
          if (((localp.field_ctrInfo.type == paramInt) || (paramInt == -2147483648)) && (((Boolean)paramb.invoke(localp)).booleanValue()))
          {
            LinkedList localLinkedList = (LinkedList)localHashMap.get(str);
            localObject = localLinkedList;
            if (localLinkedList == null)
            {
              localObject = new LinkedList();
              ((Map)localHashMap).put(str, localObject);
            }
            ((LinkedList)localObject).add(localp);
          }
        }
      }
      localObject = ah.aiuX;
    }
    AppMethodBeat.o(366941);
    return localHashMap;
  }
  
  private final void c(btw parambtw)
  {
    AppMethodBeat.i(366864);
    Log.i("Finder.RedDotManager", s.X("mergeFinderMentionCtrlInfo enter:", Integer.valueOf(parambtw.type)));
    p localp = o(a(this, 2));
    if (localp == null)
    {
      ??? = null;
      Log.i("Finder.RedDotManager", s.X("mergeFinderMentionCtrlInfo :", ???));
      if (localp != null)
      {
        ??? = localp.ASx.keySet();
        s.s(???, "showInfoMap.keys");
      }
    }
    else
    {
      for (;;)
      {
        synchronized ((Iterable)???)
        {
          Iterator localIterator = ((Iterable)???).iterator();
          if (!localIterator.hasNext()) {
            break label265;
          }
          Object localObject2 = (String)localIterator.next();
          Object localObject3 = parambtw.aabA;
          s.s(localObject3, "ctrlInfo.show_infos");
          localObject3 = (Iterable)localObject3;
          if (((localObject3 instanceof Collection)) && (((Collection)localObject3).isEmpty())) {
            break label260;
          }
          localObject3 = ((Iterable)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label260;
          }
          if (!s.p(((bxq)((Iterator)localObject3).next()).path, localObject2)) {
            continue;
          }
          i = 0;
          if (i == 0) {
            continue;
          }
          localObject2 = (bxq)localp.ASx.get(localObject2);
          if (localObject2 == null) {
            continue;
          }
          parambtw.aabA.add(localObject2);
        }
        ??? = Integer.valueOf(localp.field_ctrInfo.type);
        break;
        label260:
        int i = 1;
      }
      label265:
      parambtw = ah.aiuX;
      AppMethodBeat.o(366864);
      return;
    }
    AppMethodBeat.o(366864);
  }
  
  private static boolean c(btw parambtw, String paramString)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(366967);
    if (parambtw == null) {
      parambtw = localIterator;
    }
    while (parambtw != null)
    {
      AppMethodBeat.o(366967);
      return true;
      LinkedList localLinkedList = parambtw.aabA;
      parambtw = localIterator;
      if (localLinkedList != null)
      {
        localIterator = ((Iterable)localLinkedList).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          parambtw = localIterator.next();
        } while (!s.p(((bxq)parambtw).path, paramString));
        for (;;)
        {
          parambtw = (bxq)parambtw;
          break;
          parambtw = null;
        }
      }
    }
    AppMethodBeat.o(366967);
    return false;
  }
  
  public static int d(p paramp)
  {
    AppMethodBeat.i(366957);
    s.u(paramp, "ctrlInfo");
    if ((paramp.avK("TLWxPrivateMsgBubble") != null) || (paramp.avK("TLWxBubble") != null))
    {
      AppMethodBeat.o(366957);
      return 4;
    }
    if (paramp.avK("TLFollow") != null)
    {
      if (paramp.ASz.tab_type != -1)
      {
        i = paramp.ASz.tab_type;
        AppMethodBeat.o(366957);
        return i;
      }
      i = avq("TLFollow");
      AppMethodBeat.o(366957);
      return i;
    }
    if (paramp.avK("TLRecommendTab") != null)
    {
      if (paramp.ASz.tab_type != -1)
      {
        i = paramp.ASz.tab_type;
        AppMethodBeat.o(366957);
        return i;
      }
      i = avq("TLRecommendTab");
      AppMethodBeat.o(366957);
      return i;
    }
    if (paramp.avK("finder_tl_hot_tab") != null)
    {
      if (paramp.ASz.tab_type != -1)
      {
        i = paramp.ASz.tab_type;
        AppMethodBeat.o(366957);
        return i;
      }
      i = avq("finder_tl_hot_tab");
      AppMethodBeat.o(366957);
      return i;
    }
    if (paramp.avK("finder_tl_nearby_tab") != null)
    {
      i = avq("finder_tl_nearby_tab");
      AppMethodBeat.o(366957);
      return i;
    }
    if (paramp.avK("NearbyFeedTab") != null)
    {
      i = avq("NearbyFeedTab");
      AppMethodBeat.o(366957);
      return i;
    }
    if (paramp.avK("NearbyLiveTab") != null)
    {
      i = avq("NearbyLiveTab");
      AppMethodBeat.o(366957);
      return i;
    }
    if (paramp.avK("NearbyPeopleTab") != null)
    {
      i = avq("NearbyPeopleTab");
      AppMethodBeat.o(366957);
      return i;
    }
    int i = paramp.ASz.tab_type;
    if (i != 0)
    {
      AppMethodBeat.o(366957);
      return i;
    }
    AppMethodBeat.o(366957);
    return -1;
  }
  
  private final kotlin.r<p, bxq> d(btw parambtw)
  {
    AppMethodBeat.i(366934);
    parambtw = parambtw.aabA;
    if (parambtw != null)
    {
      parambtw = ((Iterable)parambtw).iterator();
      while (parambtw.hasNext()) {
        if (s.p(((bxq)parambtw.next()).path, "FinderEntrance"))
        {
          parambtw = avt("FinderEntrance");
          AppMethodBeat.o(366934);
          return parambtw;
        }
      }
    }
    AppMethodBeat.o(366934);
    return null;
  }
  
  public static void dZk()
  {
    AppMethodBeat.i(366848);
    q localq = q.ASF;
    q.eaU();
    AppMethodBeat.o(366848);
  }
  
  private static long dZm()
  {
    AppMethodBeat.i(366869);
    long l1 = cn.bDw();
    q localq = q.ASF;
    long l2 = q.eaP();
    AppMethodBeat.o(366869);
    return l1 - l2;
  }
  
  private static long dZn()
  {
    AppMethodBeat.i(366876);
    long l1 = cn.bDw();
    q localq = q.ASF;
    long l2 = q.eaR();
    AppMethodBeat.o(366876);
    return l1 - l2;
  }
  
  private static long dZo()
  {
    AppMethodBeat.i(366883);
    long l1 = cn.bDw();
    q localq = q.ASF;
    long l2 = q.eaS();
    AppMethodBeat.o(366883);
    return l1 - l2;
  }
  
  public static void dZw()
  {
    int i = 0;
    AppMethodBeat.i(366964);
    Object localObject = av.GiL;
    if (!av.ffR())
    {
      Log.i("Finder.RedDotManager", "[checkInsertLiveTaskRedDot] hasFinderAccount = false");
      AppMethodBeat.o(366964);
      return;
    }
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adad, 0) == 1) {
      i = 1;
    }
    if (i != 0)
    {
      Log.i("Finder.RedDotManager", "[checkInsertLiveTaskRedDot] hasShow = true");
      AppMethodBeat.o(366964);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    if (!com.tencent.mm.plugin.finder.api.d.a.auX("Entrance_PrimarySetting"))
    {
      Log.i("Finder.RedDotManager", "[checkInsertLiveTaskRedDot] getLiveTaskEnable = false");
      AppMethodBeat.o(366964);
      return;
    }
    localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
    btw localbtw = new btw();
    localbtw.ZYN = String.valueOf(cn.bDw());
    localbtw.priority = 50000;
    localbtw.type = 1019;
    bxq localbxq = new bxq();
    localbxq.show_type = 1;
    localbxq.aagq = 1;
    localbxq.path = "TLPersonalCenter";
    localbtw.aabA.add(localbxq);
    localbxq = new bxq();
    localbxq.show_type = 1;
    localbxq.aagq = 1;
    localbxq.path = "FinderPosterEntrance";
    localbtw.aabA.add(localbxq);
    localbxq = new bxq();
    localbxq.show_type = 1;
    localbxq.aagq = 1;
    localbxq.path = "FinderSettingLiveTask";
    localbtw.aabA.add(localbxq);
    a((i)localObject, localbtw, "checkInsertLiveTaskRedDot", null, true, null, null, 0L, 116);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adad, Integer.valueOf(1));
    Log.i("Finder.RedDotManager", "checkInsertLiveTaskRedDot");
    AppMethodBeat.o(366964);
  }
  
  private static String e(btw parambtw)
  {
    AppMethodBeat.i(178180);
    if (parambtw == null)
    {
      AppMethodBeat.o(178180);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = parambtw.aabA;
    s.s(localObject1, "info.show_infos");
    localObject1 = (Iterable)localObject1;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localStringBuilder.append(a((bxq)localObject2, i));
      i += 1;
    }
    parambtw = "CtrlInfo{tipsId=" + parambtw.ZYN + " priority=" + parambtw.priority + " type=" + parambtw.type + " starttime=" + parambtw.start_time + " expired=" + parambtw.wso + " tipsShowInfo=" + localStringBuilder + '}';
    AppMethodBeat.o(178180);
    return parambtw;
  }
  
  private final void ev(String paramString, int paramInt)
  {
    AppMethodBeat.i(366918);
    List localList = a(this, "Discovery");
    label281:
    label284:
    label287:
    label290:
    for (;;)
    {
      synchronized ((Iterable)localList)
      {
        localObject = ???.iterator();
        bool2 = false;
        bool1 = false;
        p localp;
        if (((Iterator)localObject).hasNext())
        {
          localp = (p)((Iterator)localObject).next();
          if (!localp.avJ(paramString)) {
            break label287;
          }
          if (localp.field_ctrInfo.priority > paramInt) {
            break label284;
          }
          bool1 = true;
          continue;
        }
        localObject = ah.aiuX;
        if ((!bool2) || (!bool1)) {
          break label281;
        }
        synchronized ((Iterable)localList)
        {
          localObject = ???.iterator();
          if (((Iterator)localObject).hasNext())
          {
            localp = (p)((Iterator)localObject).next();
            if (!localp.avJ(paramString)) {
              continue;
            }
            a(localp, "Discovery", true);
          }
        }
      }
      Object localObject = ah.aiuX;
      boolean bool1 = false;
      for (;;)
      {
        Log.i("Finder.RedDotManager", "handleClearDiscoveryRedDot isClear:" + bool1 + ", hasOtherPath:" + bool2 + ", ctrlInfoByPath:" + localList + ", path:" + paramString);
        if (bool1) {
          a("Discovery", (kotlin.g.a.b)i.v.ARi, true);
        }
        AppMethodBeat.o(366918);
        return;
      }
      break label290;
      boolean bool2 = true;
    }
  }
  
  private final void f(btw parambtw)
  {
    AppMethodBeat.i(366955);
    if (parambtw.type == 15)
    {
      HashSet localHashSet = new HashSet();
      Object localObject3 = parambtw.aabA.iterator();
      Object localObject2;
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = ((bxq)((Iterator)localObject3).next()).path;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localHashSet.add(localObject1);
      }
      Object localObject1 = o(a(this, 15));
      if (localObject1 != null)
      {
        localObject2 = ((p)localObject1).ASx.keys();
        s.s(localObject2, "showInfoMap.keys()");
        localObject2 = kotlin.a.p.a((Enumeration)localObject2);
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (!localHashSet.contains(localObject3)) {
            parambtw.aabA.add(((p)localObject1).ASx.get(localObject3));
          }
        }
      }
    }
    AppMethodBeat.o(366955);
  }
  
  private static void g(btw parambtw)
  {
    AppMethodBeat.i(366960);
    Object localObject1;
    boolean bool;
    if (parambtw == null)
    {
      localObject1 = null;
      if (parambtw != null) {
        break label173;
      }
      bool = false;
    }
    for (;;)
    {
      if (bool)
      {
        localObject2 = av.GiL;
        localObject2 = aw.Gjk;
        if ((parambtw != null) && (localObject1 != null))
        {
          localObject2 = w.FrV;
          w.a(p.a(new p(), parambtw), (bxq)localObject1, 5, 2, null, null, 48);
          if (s.p("Discovery", ((bxq)localObject1).Nnp))
          {
            localObject2 = w.FrV;
            w.a(5, 1L, p.a(new p(), parambtw), (bxq)localObject1);
          }
        }
      }
      AppMethodBeat.o(366960);
      return;
      localObject1 = parambtw.aabA;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      Object localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
      } while (!s.p(((bxq)localObject1).path, "FinderEntrance"));
      for (;;)
      {
        localObject1 = (bxq)localObject1;
        break;
        localObject1 = null;
      }
      label173:
      localObject2 = parambtw.aabA;
      if (localObject2 == null) {
        bool = false;
      } else {
        bool = com.tencent.mm.ae.d.a((LinkedList)localObject2, (kotlin.g.a.b)ab.ARn);
      }
    }
  }
  
  private List<p> n(String paramString, kotlin.g.a.b<? super p, Boolean> paramb)
  {
    AppMethodBeat.i(366944);
    s.u(paramString, "path");
    s.u(paramb, "filter");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Map)this.AQI).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      synchronized (((Map.Entry)localObject2).getValue())
      {
        localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          p localp = (p)((Iterator)localObject2).next();
          if ((((Boolean)paramb.invoke(localp)).booleanValue()) && (localp.avK(paramString) != null)) {
            localHashSet.add(localp);
          }
        }
      }
      localObject2 = ah.aiuX;
    }
    paramString = kotlin.a.p.p((Iterable)localHashSet);
    AppMethodBeat.o(366944);
    return paramString;
  }
  
  private static p o(HashMap<String, LinkedList<p>> paramHashMap)
  {
    AppMethodBeat.i(366929);
    Set localSet = (Set)new LinkedHashSet();
    Iterator localIterator = ((Map)paramHashMap).entrySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {}
      synchronized ((List)((Map.Entry)localIterator.next()).getValue())
      {
        paramHashMap = ???.listIterator(???.size());
        if (paramHashMap.hasPrevious())
        {
          paramHashMap = paramHashMap.previous();
          paramHashMap = (p)paramHashMap;
          if (paramHashMap != null) {
            localSet.add(paramHashMap);
          }
        }
        else
        {
          paramHashMap = null;
        }
      }
    }
    AppMethodBeat.o(366929);
    return paramHashMap;
  }
  
  public static boolean p(Integer paramInteger)
  {
    AppMethodBeat.i(366969);
    if (paramInteger == null) {}
    label18:
    label22:
    while (paramInteger.intValue() != 8)
    {
      if (paramInteger != null) {
        break;
      }
      if (paramInteger != null) {
        break label58;
      }
      if (paramInteger != null) {
        break label69;
      }
      AppMethodBeat.o(366969);
      return false;
    }
    for (;;)
    {
      AppMethodBeat.o(366969);
      return true;
      if (paramInteger.intValue() != 1)
      {
        break;
        label58:
        if (paramInteger.intValue() != 2)
        {
          break label18;
          label69:
          if (paramInteger.intValue() != 7) {
            break label22;
          }
        }
      }
    }
  }
  
  public final void Ns(int paramInt)
  {
    AppMethodBeat.i(178170);
    Object localObject1 = Su("FinderEntrance");
    boolean bool;
    if (paramInt == 6)
    {
      bool = true;
      if (!bool)
      {
        localObject2 = d.APW;
        d.c((p)localObject1);
      }
      if (localObject1 == null) {
        break label224;
      }
      Object localObject2 = w.FrV;
      w.g((p)localObject1);
      if (((p)localObject1).avK("FinderEntrance") == null) {
        break label224;
      }
      this.AQG = true;
      this.AQH = ((p)localObject1).field_ctrInfo.type;
      if (!bool) {
        e((p)localObject1);
      }
    }
    for (;;)
    {
      this.AQF = paramInt;
      this.enterTime = cn.bDw();
      localObject1 = k.aeZF;
      paramInt = ((com.tencent.mm.plugin.finder.viewmodel.d)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).fmM();
      if (!bool)
      {
        TL("FinderEntrance");
        TL("Discovery");
      }
      localObject1 = r.ASG;
      Log.i("Finder.ThreeDayTwoDay", "enterFinder");
      r.ebg();
      this.AQu.eao();
      localObject1 = q.ASF;
      q.eaV();
      Log.i("Finder.RedDotManager", "[enterFinder] hasRedDotWhenEnter=" + this.AQG + " isSourceFromShareToTimeline=" + bool + " tabType=" + paramInt);
      AppMethodBeat.o(178170);
      return;
      bool = false;
      break;
      label224:
      this.AQH = 0;
      this.AQG = false;
    }
  }
  
  public final void Nt(int paramInt)
  {
    AppMethodBeat.i(366983);
    if (paramInt <= 0)
    {
      Log.i("Finder.RedDotManager", "[notifyFinderFansAddCount] server error.");
      AppMethodBeat.o(366983);
      return;
    }
    Log.i("Finder.RedDotManager", s.X("[notifyFinderFansAddCount] count = ", Integer.valueOf(paramInt)));
    btw localbtw = new btw();
    localbtw.ZYN = String.valueOf(cn.bDw());
    localbtw.priority = 100000;
    localbtw.type = 2;
    bxq localbxq = new bxq();
    localbxq.show_type = 2;
    localbxq.aagq = 1;
    localbxq.path = "AuthorProfileFans";
    localbxq.count = paramInt;
    localbtw.aabA.add(localbxq);
    c(localbtw);
    a(this, localbtw, "notifyFinderFansAddCount", null, true, null, null, 0L, 116);
    AppMethodBeat.o(366983);
  }
  
  public final void Nv(int paramInt)
  {
    AppMethodBeat.i(367018);
    b(paramInt, (kotlin.g.a.b)i.i.AQX);
    AppMethodBeat.o(367018);
  }
  
  public final boolean Nw(int paramInt)
  {
    AppMethodBeat.i(367038);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = Nx(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("[containsTabTipsExtInfo] tabType=").append(paramInt).append(" isContains=");
    if (localFinderTipsShowEntranceExtInfo.tab_type != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.RedDotManager", bool);
      if (localFinderTipsShowEntranceExtInfo.tab_type == 0) {
        break;
      }
      AppMethodBeat.o(367038);
      return true;
    }
    AppMethodBeat.o(367038);
    return false;
  }
  
  public final FinderTipsShowEntranceExtInfo Nx(int paramInt)
  {
    AppMethodBeat.i(367041);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = avr(Nu(paramInt));
    Log.i("Finder.RedDotManager", "[getTabTipsExtInfo] tabType=" + paramInt + " ext=" + j.a(localFinderTipsShowEntranceExtInfo));
    AppMethodBeat.o(367041);
    return localFinderTipsShowEntranceExtInfo;
  }
  
  public final void Ny(int paramInt)
  {
    AppMethodBeat.i(367096);
    btw localbtw = new btw();
    localbtw.wso = 3600;
    localbtw.priority = 400000;
    localbtw.feedId = -4758357817339078452L;
    localbtw.type = 10;
    localbtw.aabC = false;
    Object localObject1 = localbtw.aabA;
    Object localObject2 = new bxq();
    ((bxq)localObject2).show_type = 3;
    ((bxq)localObject2).title = "test_title_v5";
    ((bxq)localObject2).count = 0;
    ((bxq)localObject2).icon_url = "";
    ((bxq)localObject2).path = "FinderEntrance";
    ((bxq)localObject2).aagq = 1;
    ((bxq)localObject2).aagr = 1;
    Object localObject3 = new FinderTipsShowEntranceExtInfo();
    ((FinderTipsShowEntranceExtInfo)localObject3).object_id = -4758357817339078452L;
    ((FinderTipsShowEntranceExtInfo)localObject3).report_ext_info = "eyJzaG93X3R5cGUiOjMsInR5cGUiOjEwLCJ0b3BpY19pZCI6IjEzNjM1NDcxODEyMTUzNzcyMDY4IiwiZW50ZXJfYWN0aW9uIjo4LCJyZXF1ZXN0X2lkIjoxNjM0MjIyNjg4NDk3NjYxLCJmaW5kZXJfdXNlcm5hbWUiOiIifQ==";
    ah localah = ah.aiuX;
    ((bxq)localObject2).aags = new com.tencent.mm.bx.b(((FinderTipsShowEntranceExtInfo)localObject3).toByteArray());
    localObject3 = ah.aiuX;
    ((LinkedList)localObject1).add(localObject2);
    localbtw.ZYN = "tipsid_1634133544815022";
    localObject1 = new btx();
    ((btx)localObject1).tab_type = paramInt;
    localObject2 = new FinderJumpInfo();
    ((FinderJumpInfo)localObject2).jumpinfo_type = 3;
    localObject3 = new NativeInfo();
    ((NativeInfo)localObject3).native_type = 8;
    ((NativeInfo)localObject3).necessary_params = "{\"topic_id\": \"13635471812153772068\"; \"by_pass_info\": \"test\"}";
    localah = ah.aiuX;
    ((FinderJumpInfo)localObject2).native_info = ((NativeInfo)localObject3);
    localObject3 = ah.aiuX;
    ((btx)localObject1).ZNl = ((FinderJumpInfo)localObject2);
    localObject2 = ah.aiuX;
    localbtw.aabz = new com.tencent.mm.bx.b(((btx)localObject1).toByteArray());
    a(this, localbtw, "mockTopicRedDot", null, true, null, null, 0L, 116);
    AppMethodBeat.o(367096);
  }
  
  /* Error */
  public final p Su(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1616
    //   3: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 1199
    //   10: invokestatic 370	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 467	com/tencent/mm/plugin/finder/extension/reddot/i:AQI	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 981	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 983	java/util/List
    //   24: astore 4
    //   26: aload 4
    //   28: ifnonnull +11 -> 39
    //   31: ldc_w 1616
    //   34: invokestatic 361	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: aload 4
    //   41: checkcast 578	java/lang/Iterable
    //   44: astore 5
    //   46: aload 5
    //   48: monitorenter
    //   49: new 1618	java/util/ArrayList
    //   52: dup
    //   53: invokespecial 1619	java/util/ArrayList:<init>	()V
    //   56: checkcast 711	java/util/Collection
    //   59: astore 6
    //   61: aload 5
    //   63: invokeinterface 582 1 0
    //   68: astore 7
    //   70: aload 7
    //   72: invokeinterface 588 1 0
    //   77: ifeq +181 -> 258
    //   80: aload 7
    //   82: invokeinterface 592 1 0
    //   87: astore 8
    //   89: aload 8
    //   91: checkcast 630	com/tencent/mm/plugin/finder/extension/reddot/p
    //   94: astore 9
    //   96: aload_0
    //   97: getfield 501	com/tencent/mm/plugin/finder/extension/reddot/i:AQL	Ljava/util/List;
    //   100: checkcast 578	java/lang/Iterable
    //   103: invokeinterface 582 1 0
    //   108: astore 10
    //   110: aload 10
    //   112: invokeinterface 588 1 0
    //   117: ifeq +82 -> 199
    //   120: aload 10
    //   122: invokeinterface 592 1 0
    //   127: astore 4
    //   129: aload 4
    //   131: checkcast 483	kotlin/r
    //   134: getfield 672	kotlin/r:bsC	Ljava/lang/Object;
    //   137: checkcast 471	kotlin/g/a/b
    //   140: aload 9
    //   142: invokeinterface 701 2 0
    //   147: checkcast 1222	java/lang/Boolean
    //   150: invokevirtual 1225	java/lang/Boolean:booleanValue	()Z
    //   153: ifeq -43 -> 110
    //   156: aload 4
    //   158: checkcast 483	kotlin/r
    //   161: astore 4
    //   163: aload 4
    //   165: ifnonnull +40 -> 205
    //   168: iconst_1
    //   169: istore_3
    //   170: iload_3
    //   171: ifeq -101 -> 70
    //   174: aload 6
    //   176: aload 8
    //   178: invokeinterface 1620 2 0
    //   183: pop
    //   184: goto -114 -> 70
    //   187: astore_1
    //   188: aload 5
    //   190: monitorexit
    //   191: ldc_w 1616
    //   194: invokestatic 361	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_1
    //   198: athrow
    //   199: aconst_null
    //   200: astore 4
    //   202: goto -46 -> 156
    //   205: aload 4
    //   207: getfield 686	kotlin/r:bsD	Ljava/lang/Object;
    //   210: checkcast 471	kotlin/g/a/b
    //   213: astore 4
    //   215: aload 4
    //   217: ifnonnull +8 -> 225
    //   220: iconst_1
    //   221: istore_3
    //   222: goto -52 -> 170
    //   225: aload 4
    //   227: aload 9
    //   229: invokeinterface 701 2 0
    //   234: checkcast 1222	java/lang/Boolean
    //   237: astore 4
    //   239: aload 4
    //   241: ifnonnull +8 -> 249
    //   244: iconst_1
    //   245: istore_3
    //   246: goto -76 -> 170
    //   249: aload 4
    //   251: invokevirtual 1225	java/lang/Boolean:booleanValue	()Z
    //   254: istore_3
    //   255: goto -85 -> 170
    //   258: aload 6
    //   260: checkcast 983	java/util/List
    //   263: astore 6
    //   265: aload 5
    //   267: monitorexit
    //   268: aload 6
    //   270: monitorenter
    //   271: aload 6
    //   273: aload 6
    //   275: invokeinterface 1442 1 0
    //   280: invokeinterface 1446 2 0
    //   285: astore 5
    //   287: aload 5
    //   289: invokeinterface 1451 1 0
    //   294: ifeq +58 -> 352
    //   297: aload 5
    //   299: invokeinterface 1454 1 0
    //   304: astore 4
    //   306: aload 4
    //   308: checkcast 630	com/tencent/mm/plugin/finder/extension/reddot/p
    //   311: aload_1
    //   312: invokevirtual 690	com/tencent/mm/plugin/finder/extension/reddot/p:avK	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/bxq;
    //   315: astore 7
    //   317: aload 7
    //   319: ifnull +28 -> 347
    //   322: iconst_1
    //   323: istore_2
    //   324: iload_2
    //   325: ifeq -38 -> 287
    //   328: aload 4
    //   330: astore_1
    //   331: aload 6
    //   333: monitorexit
    //   334: aload_1
    //   335: checkcast 630	com/tencent/mm/plugin/finder/extension/reddot/p
    //   338: astore_1
    //   339: ldc_w 1616
    //   342: invokestatic 361	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: aload_1
    //   346: areturn
    //   347: iconst_0
    //   348: istore_2
    //   349: goto -25 -> 324
    //   352: aconst_null
    //   353: astore_1
    //   354: goto -23 -> 331
    //   357: astore_1
    //   358: aload 6
    //   360: monitorexit
    //   361: ldc_w 1616
    //   364: invokestatic 361	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: aload_1
    //   368: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	i
    //   0	369	1	paramString	String
    //   323	26	2	i	int
    //   169	86	3	bool	boolean
    //   24	305	4	localObject1	Object
    //   44	254	5	localObject2	Object
    //   59	300	6	localObject3	Object
    //   68	250	7	localObject4	Object
    //   87	90	8	localObject5	Object
    //   94	134	9	localp	p
    //   108	13	10	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   49	70	187	finally
    //   70	110	187	finally
    //   110	156	187	finally
    //   156	163	187	finally
    //   174	184	187	finally
    //   205	215	187	finally
    //   225	239	187	finally
    //   249	255	187	finally
    //   258	265	187	finally
    //   271	287	357	finally
    //   287	317	357	finally
  }
  
  public final void TL(String paramString)
  {
    AppMethodBeat.i(178176);
    s.u(paramString, "path");
    d(paramString, null);
    AppMethodBeat.o(178176);
  }
  
  public final void a(p paramp, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(366985);
    s.u(paramp, "info");
    s.u(paramString, "path");
    Object localObject1 = new HashSet();
    bxq localbxq1 = paramp.avK(paramString);
    Object localObject2 = paramp.bt(paramString, paramBoolean);
    if (p.a(paramp, (MAutoStorage)this.AQt)) {
      ((HashSet)localObject1).addAll((Collection)localObject2);
    }
    if (paramp.eax())
    {
      localObject2 = (List)this.AQI.get(paramString);
      if (localObject2 != null) {
        ((List)localObject2).remove(paramp);
      }
    }
    Log.i("Finder.RedDotManager", "[clearShowInfoAtCtrlInfo] path=" + paramString + " tipsId=" + paramp.field_tipsId + " removePathSet=" + localObject1 + " maybeRemoveShowInfo=" + a(localbxq1, 0));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramString = Su((String)localObject2);
      label212:
      int i;
      if (paramString == null)
      {
        paramString = null;
        if (paramString == null)
        {
          paramString = l.ARA;
          l.a(false, (String)localObject2, localbxq1, paramp);
        }
      }
      else
      {
        bxq localbxq2 = paramString.avK((String)localObject2);
        if (localbxq2 == null) {
          break label288;
        }
        i = 1;
        label248:
        if (i == 0) {
          break label294;
        }
        l locall = l.ARA;
        l.a(false, (String)localObject2, localbxq1, paramp);
        locall = l.ARA;
        l.a(true, (String)localObject2, localbxq2, paramString);
      }
      for (;;)
      {
        paramString = ah.aiuX;
        break label212;
        break;
        label288:
        i = 0;
        break label248;
        label294:
        paramString = l.ARA;
        l.a(false, (String)localObject2, localbxq1, paramp);
      }
    }
    AppMethodBeat.o(366985);
  }
  
  public final void a(btv parambtv)
  {
    AppMethodBeat.i(178171);
    s.u(parambtv, "redDot");
    long l = cn.bDw();
    Object localObject = q.ASF;
    l -= q.eaP();
    Log.i("Finder.RedDotManager", "[notifyRedDot] diffTime=" + l + " newMsgTipsEnterInterval=" + q.ASF.eaI() + " showRed=" + parambtv.aabw + ' ' + e(parambtv.aabx));
    if (l < q.ASF.eaI())
    {
      g(parambtv.aabx);
      localObject = parambtv.aabx;
      if (localObject != null)
      {
        localObject = ((btw)localObject).aabA;
        if (localObject != null) {
          com.tencent.mm.ae.d.a((LinkedList)localObject, (kotlin.g.a.b)w.ARj);
        }
      }
    }
    localObject = parambtv.aabx;
    if (localObject == null) {}
    for (int i = 0; i == 2; i = ((btw)localObject).type)
    {
      boolean bool = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUe();
      parambtv = parambtv.aabx;
      if (parambtv == null) {
        break label389;
      }
      if (bool)
      {
        localObject = parambtv.aabA;
        if (localObject != null)
        {
          localObject = ((LinkedList)localObject).iterator();
          if ((localObject != null) && (((Iterator)localObject).hasNext()) && (s.p(((bxq)((Iterator)localObject).next()).path, "FinderEntrance"))) {
            ((Iterator)localObject).remove();
          }
        }
      }
      c(parambtv);
      a(this, parambtv, "notifyRedDot", null, true, null, (kotlin.g.a.b)new x(this), 0L, 84);
      AppMethodBeat.o(178171);
      return;
    }
    parambtv = parambtv.aaby;
    s.s(parambtv, "redDot.ctrl_info_list");
    parambtv = ((Iterable)parambtv).iterator();
    while (parambtv.hasNext())
    {
      localObject = (btw)parambtv.next();
      if (((btw)localObject).type == 2)
      {
        s.s(localObject, "it");
        c((btw)localObject);
      }
      a(this, (btw)localObject, "notifyRedDot", null, true, null, null, 0L, 116);
    }
    label389:
    AppMethodBeat.o(178171);
  }
  
  public final void a(btw parambtw, String paramString)
  {
    AppMethodBeat.i(367003);
    s.u(parambtw, "local");
    s.u(paramString, "source");
    int j = parambtw.type;
    Object localObject3 = d(parambtw);
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = ((Map)this.AQI).entrySet().iterator();
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localObject1 = (Map.Entry)localIterator1.next();
      synchronized (((Map.Entry)localObject1).getValue())
      {
        String str = (String)((Map.Entry)localObject1).getKey();
        Iterator localIterator2 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          p localp = (p)localIterator2.next();
          if (localp.field_ctrInfo.type == j)
          {
            localObject2 = (LinkedList)localHashMap.get(str);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new LinkedList();
              ((Map)localHashMap).put(str, localObject1);
            }
            ((LinkedList)localObject1).add(localp);
            localIterator2.remove();
          }
        }
      }
      localObject1 = ah.aiuX;
    }
    if (!((Map)localHashMap).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.i("Finder.RedDotManager", "[reBuildPathWithCtrInfo] type=" + j + " clearMap=" + localHashMap + " source=" + paramString);
      }
      localObject1 = ((Map)localHashMap).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterable)((Map.Entry)((Iterator)localObject1).next()).getValue()).iterator();
        while (((Iterator)localObject2).hasNext()) {
          p.b((p)((Iterator)localObject2).next(), (MAutoStorage)this.AQt);
        }
      }
    }
    Object localObject1 = new HashSet();
    a(this, parambtw, paramString, (HashSet)localObject1, false, (kotlin.r)localObject3, null, 0L, 96);
    paramString = (Map)localHashMap;
    parambtw = (Map)new LinkedHashMap();
    paramString = paramString.entrySet().iterator();
    label522:
    while (paramString.hasNext())
    {
      localObject2 = (Map.Entry)paramString.next();
      if (!((HashSet)localObject1).contains(((Map.Entry)localObject2).getKey())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label522;
        }
        parambtw.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        break;
      }
    }
    paramString = parambtw.entrySet().iterator();
    while (paramString.hasNext())
    {
      parambtw = (Map.Entry)paramString.next();
      localObject1 = (String)parambtw.getKey();
      parambtw = ((Iterable)parambtw.getValue()).iterator();
      while (parambtw.hasNext()) {
        p.b((p)parambtw.next(), (MAutoStorage)this.AQt);
      }
      parambtw = Su((String)localObject1);
      if (parambtw == null)
      {
        parambtw = null;
        label626:
        if (parambtw == null)
        {
          parambtw = l.ARA;
          l.a(false, (String)localObject1, null, null);
        }
      }
      else
      {
        localObject2 = parambtw.avK((String)localObject1);
        if (localObject2 == null) {
          break label698;
        }
        i = 1;
        label660:
        if (i == 0) {
          break label703;
        }
        localObject3 = l.ARA;
        l.a(false, (String)localObject1, null, null);
        localObject3 = l.ARA;
        l.a(true, (String)localObject1, (bxq)localObject2, parambtw);
      }
      for (;;)
      {
        parambtw = ah.aiuX;
        break label626;
        break;
        label698:
        i = 0;
        break label660;
        label703:
        parambtw = l.ARA;
        l.a(false, (String)localObject1, null, null);
      }
    }
    AppMethodBeat.o(367003);
  }
  
  public final void a(buj parambuj)
  {
    AppMethodBeat.i(367094);
    s.u(parambuj, "revoke");
    Object localObject1 = parambuj.aaca;
    s.s(localObject1, "revoke.revoke_ctrl_info");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (buk)((Iterator)localObject2).next();
      ((Collection)localObject1).add(((buk)localObject3).path + '_' + ((buk)localObject3).aacb + '_' + ((buk)localObject3).aacc);
    }
    Log.i("Finder.RedDotManager", s.X("[revokePathRedDot] ", (List)localObject1));
    parambuj = parambuj.aaca;
    s.s(parambuj, "revoke.revoke_ctrl_info");
    Object localObject3 = ((Iterable)parambuj).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      buk localbuk = (buk)((Iterator)localObject3).next();
      label198:
      p localp;
      if (localbuk == null)
      {
        parambuj = "";
        localp = Su(parambuj);
        if (localp != null) {
          break label298;
        }
        localObject1 = null;
        if (localbuk.aacb != 0) {
          break label444;
        }
        if (localObject1 == null) {
          break label336;
        }
        parambuj = w.FrV;
        w.a(localp, (bxq)localObject1, 1, localbuk.aacb, null, null, 48);
        label244:
        if (localbuk != null) {
          break label406;
        }
        parambuj = "";
        label253:
        hH(parambuj, "revokePathRedDot#0");
        if (localbuk != null) {
          break label425;
        }
        parambuj = "";
      }
      for (;;)
      {
        TL(parambuj);
        break;
        localObject1 = localbuk.path;
        parambuj = (buj)localObject1;
        if (localObject1 != null) {
          break label198;
        }
        parambuj = "";
        break label198;
        label298:
        if (localbuk == null) {
          parambuj = "";
        }
        for (;;)
        {
          localObject1 = localp.avK(parambuj);
          break;
          localObject1 = localbuk.path;
          parambuj = (buj)localObject1;
          if (localObject1 == null) {
            parambuj = "";
          }
        }
        label336:
        com.tencent.mm.plugin.report.service.h.OAn.b(20951, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), "", localbuk.path, Integer.valueOf(localbuk.aacb), "" });
        break label244;
        label406:
        localObject1 = localbuk.path;
        parambuj = (buj)localObject1;
        if (localObject1 != null) {
          break label253;
        }
        parambuj = "";
        break label253;
        label425:
        localObject1 = localbuk.path;
        parambuj = (buj)localObject1;
        if (localObject1 == null) {
          parambuj = "";
        }
      }
      label444:
      if (localbuk.aacb == 1)
      {
        localObject2 = "";
        parambuj = localbuk.aacc;
        s.s(parambuj, "it.tips_id_list");
        parambuj = ((Iterable)parambuj).iterator();
        while (parambuj.hasNext())
        {
          localObject4 = (String)parambuj.next();
          localObject2 = (String)localObject2 + localObject4 + ';';
        }
        kotlin.n.n.c((String)localObject2, (CharSequence)";");
        Object localObject4 = new ah.a();
        ((ah.a)localObject4).aiwY = true;
        final ah.a locala = new ah.a();
        if (localbuk == null) {
          parambuj = "";
        }
        for (;;)
        {
          a(this, parambuj, (kotlin.g.a.b)new ac(localbuk, (ah.a)localObject4, locala, this));
          Log.i("Finder.RedDotManager", "[revokePathRedDot] isHasDisposed=" + locala.aiwY + " isAllDisposed=" + ((ah.a)localObject4).aiwY + " tipsList=" + (String)localObject2);
          if ((!locala.aiwY) || (!((ah.a)localObject4).aiwY)) {
            break label721;
          }
          parambuj = av.GiL;
          parambuj = aw.Gjk;
          if ((localp == null) || (localObject1 == null)) {
            break;
          }
          parambuj = w.FrV;
          w.a(localp, (bxq)localObject1, 1, localbuk.aacb, (String)localObject2, null, 32);
          break;
          parambuj = localbuk.path;
          if (parambuj == null) {
            parambuj = "";
          }
        }
        label721:
        if ((locala.aiwY) && (!((ah.a)localObject4).aiwY))
        {
          parambuj = av.GiL;
          parambuj = aw.Gjk;
          if ((localp != null) && (localObject1 != null))
          {
            parambuj = w.FrV;
            w.a(localp, (bxq)localObject1, 2, localbuk.aacb, (String)localObject2, null, 32);
          }
        }
        else if (!locala.aiwY)
        {
          parambuj = av.GiL;
          parambuj = aw.Gjk;
          if ((localp != null) && (localObject1 != null))
          {
            parambuj = w.FrV;
            w.a(localp, (bxq)localObject1, 4, localbuk.aacb, (String)localObject2, null, 32);
          }
        }
      }
    }
    AppMethodBeat.o(367094);
  }
  
  public final void a(bul parambul)
  {
    AppMethodBeat.i(367090);
    s.u(parambul, "revoke");
    Object localObject1 = parambul.aacd;
    s.s(localObject1, "revoke.revoke_tab_tips_info");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((bum)((Iterator)localObject2).next()).aabE);
    }
    Log.i("Finder.RedDotManager", s.X("[revokeTabTips] ", (List)localObject1));
    com.tencent.mm.ae.d.e("Finder.RedDotManager", (kotlin.g.a.a)new ad(parambul, this));
    AppMethodBeat.o(367090);
  }
  
  public final void a(bxh parambxh, String paramString)
  {
    AppMethodBeat.i(367022);
    s.u(parambxh, "tabTips");
    s.u(paramString, "source");
    a(parambxh, paramString, 0L);
    AppMethodBeat.o(367022);
  }
  
  public final void a(bxh parambxh, String paramString, long paramLong)
  {
    AppMethodBeat.i(367032);
    s.u(parambxh, "tabTips");
    s.u(paramString, "source");
    long l2 = dZm();
    parambxh = parambxh.aace;
    s.s(parambxh, "tabTips.tab_tips_info");
    Object localObject1 = (Iterable)parambxh;
    parambxh = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    bxi localbxi;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localbxi = (bxi)localObject2;
      s.s(localbxi, "it");
      if (a(localbxi)) {
        parambxh.add(localObject2);
      }
    }
    Object localObject2 = ((Iterable)parambxh).iterator();
    label265:
    label270:
    label275:
    label280:
    label285:
    label290:
    label300:
    label305:
    label484:
    label616:
    label1390:
    label2287:
    label3056:
    label3187:
    if (((Iterator)localObject2).hasNext())
    {
      localbxi = (bxi)((Iterator)localObject2).next();
      parambxh = localbxi.aagf;
      if (parambxh != null)
      {
        parambxh = parambxh.aabA;
        if (parambxh != null) {
          kotlin.a.p.e((List)parambxh, (kotlin.g.a.b)y.ARk);
        }
      }
      Log.i("Finder.RedDotManager", "[notifyTabTip] " + e(localbxi.aagf) + " currentTabType=" + this.AQy.GKp);
      parambxh = localbxi.aagf;
      label246:
      boolean bool3;
      Object localObject4;
      label374:
      boolean bool1;
      boolean bool4;
      boolean bool2;
      if (parambxh == null)
      {
        localObject1 = null;
        localObject3 = localbxi.aagf;
        parambxh = localbxi.aagf;
        if (parambxh != null) {
          break label690;
        }
        parambxh = null;
        if (localObject1 != null) {
          break label762;
        }
        if (localObject1 != null) {
          break label966;
        }
        if (localObject1 != null) {
          break label1077;
        }
        if (localObject1 != null) {
          break label1181;
        }
        if (localObject1 != null) {
          break label1292;
        }
        if (localObject1 != null) {
          break label1390;
        }
        if (localObject1 != null) {
          break label1409;
        }
        if (localObject1 != null) {
          break label1513;
        }
        bool3 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUe();
        if (bool3)
        {
          g(localbxi.aagf);
          localObject4 = new StringBuilder("[notifyTabTip] it is in finder now. just remove path of FINDER_ENTRANCE, currentTabType=").append(this.AQy.GKp).append(" type=");
          parambxh = localbxi.aagf;
          if (parambxh != null) {
            break label1945;
          }
          parambxh = null;
          Log.w("Finder.RedDotManager", parambxh);
        }
        if (((e)com.tencent.mm.kernel.h.az(e.class)).isInNearby())
        {
          parambxh = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
          com.tencent.mm.plugin.finder.extension.reddot.nearby.a.i(localbxi.aagf);
          parambxh = localbxi.aagf;
          if (parambxh != null) {
            break label1956;
          }
          parambxh = null;
          Log.w("Finder.RedDotManager", s.X("[notifyTabTip] it is in nearby now. just remove path of NEARBY_ENTRANCE, type=", parambxh));
        }
        if (((e)com.tencent.mm.kernel.h.az(e.class)).isInFinderLiveSquareFindPageUI())
        {
          parambxh = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
          com.tencent.mm.plugin.finder.extension.reddot.nearby.a.j(localbxi.aagf);
          parambxh = localbxi.aagf;
          if (parambxh != null) {
            break label1967;
          }
          parambxh = null;
          Log.w("Finder.RedDotManager", s.X("[notifyTabTip] it is in finderLiveSquare now. just remove path of FinderLiveEntrance, type=", parambxh));
        }
        if (!c((btw)localObject3, "finder_tl_hot_tab")) {
          break label2437;
        }
        parambxh = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eVx().bmg()).intValue() != 1) {
          break label1978;
        }
        bool1 = true;
        if (localObject3 != null) {
          break label1984;
        }
        parambxh = null;
        bool4 = this.AQy.Rp(4);
        if (this.AQy.GKp != 4) {
          break label2074;
        }
        bool2 = true;
        if (parambxh != null) {
          break label2080;
        }
      }
      label762:
      int i;
      label1407:
      long l1;
      while (parambxh.intValue() != 1)
      {
        if ((!bool1) || ((!bool2) && (bool4))) {
          break label2088;
        }
        localObject1 = new StringBuilder("ignore this reddot.ctrlType=").append(localObject1).append(" tips_id=");
        parambxh = localbxi.aagf;
        if (parambxh != null) {
          break label2429;
        }
        parambxh = null;
        Log.w("Finder.RedDotManager", parambxh + " isInFinder=" + bool3 + " isFilter=" + bool1 + " isInSelfTab=" + bool2 + " isAutoRefresh=" + bool4);
        break;
        localObject1 = Integer.valueOf(parambxh.type);
        break label246;
        parambxh = parambxh.aabA;
        if (parambxh == null)
        {
          parambxh = null;
          break label265;
        }
        localObject4 = ((Iterable)parambxh).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          parambxh = ((Iterator)localObject4).next();
        } while (!s.p(((bxq)parambxh).path, "FinderEntrance"));
        for (;;)
        {
          parambxh = (bxq)parambxh;
          break;
          parambxh = null;
        }
        if (((Integer)localObject1).intValue() != 8) {
          break label270;
        }
        if (l2 <= q.ASF.eaA())
        {
          localObject4 = localbxi.aagf;
          if (localObject4 != null)
          {
            localObject4 = ((btw)localObject4).aabA;
            if (localObject4 != null) {
              com.tencent.mm.ae.d.a((LinkedList)localObject4, (kotlin.g.a.b)z.ARl);
            }
          }
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFollowTabTimeMs=" + q.ASF.eaA() + "ms, remove this ctrInfo");
        }
        if ((parambxh != null) && (parambxh.aagw == 1)) {}
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (!this.AQA.a(l2, 8, localbxi.aagf))) {
            break label964;
          }
          g(localbxi.aagf);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFollowTabTimeMs=" + q.ASF.eaz() + "ms, remove entrance path red dot");
          break;
        }
        break label305;
        if (((Integer)localObject1).intValue() != 7) {
          break label275;
        }
        if ((parambxh != null) && (parambxh.aagw == 1)) {}
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (!this.AQA.a(l2, 7, localbxi.aagf))) {
            break label1075;
          }
          g(localbxi.aagf);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFriendEntranceTimeMs=" + q.ASF.eaB() + "ms, remove entrance path red dot");
          break;
        }
        break label305;
        if (((Integer)localObject1).intValue() != 17) {
          break label280;
        }
        if ((parambxh != null) && (parambxh.aagw == 1)) {}
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (l2 > q.ASF.eaC())) {
            break label1179;
          }
          g(localbxi.aagf);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFriendEntranceTimeMs=" + q.ASF.eaC() + "ms, remove entrance path red dot");
          break;
        }
        break label305;
        if (((Integer)localObject1).intValue() != 10) {
          break label285;
        }
        if ((parambxh != null) && (parambxh.aagw == 1)) {}
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (!this.AQA.a(l2, 10, localbxi.aagf))) {
            break label1290;
          }
          g(localbxi.aagf);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabHotEntranceTimeMs=" + q.ASF.eaD() + "ms, remove entrance path red dot");
          break;
        }
        break label305;
        if (((Integer)localObject1).intValue() != 9) {
          break label290;
        }
        if ((parambxh != null) && (parambxh.aagw == 1)) {}
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (l2 > q.ASF.eaF())) {
            break label1407;
          }
          g(localbxi.aagf);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabLiveEntranceTimeMs=" + q.ASF.eaF() + "ms, remove entrance path red dot");
          break label305;
          if (((Integer)localObject1).intValue() != 13) {
            break;
          }
          break label1302;
        }
        break label305;
        if (((Integer)localObject1).intValue() != 14) {
          break label300;
        }
        if ((parambxh != null) && (parambxh.aagw == 1)) {}
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (l2 > q.ASF.eaE())) {
            break label1511;
          }
          g(localbxi.aagf);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabHotEntranceTimeMs=" + q.ASF.eaE() + "ms, remove entrance path red dot");
          break;
        }
        break label305;
        if (((Integer)localObject1).intValue() != 16) {
          break label305;
        }
        parambxh = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
        {
          parambxh = localbxi.aagf;
          if (parambxh == null)
          {
            parambxh = null;
            l1 = dZn();
            if ((parambxh == null) || (parambxh.aagw != 1)) {
              break label1733;
            }
          }
          for (i = 1;; i = 0)
          {
            if ((i != 0) || ((l1 > q.ASF.eaG()) && (dZt()))) {
              break label1737;
            }
            parambxh = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
            com.tencent.mm.plugin.finder.extension.reddot.nearby.a.i(localbxi.aagf);
            parambxh = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
            com.tencent.mm.plugin.finder.extension.reddot.nearby.a.k(localbxi.aagf);
            Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l1 + "ms, moreTabNearbyEntranceTimeMs=" + q.ASF.eaG() + "ms, remove entrance path red dot");
            break;
            parambxh = parambxh.aabA;
            if (parambxh == null)
            {
              parambxh = null;
              break label1545;
            }
            localObject4 = ((Iterable)parambxh).iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              parambxh = ((Iterator)localObject4).next();
            } while (!s.p(((bxq)parambxh).path, "NearbyEntrance"));
            for (;;)
            {
              parambxh = (bxq)parambxh;
              break;
              parambxh = null;
            }
          }
          break label305;
        }
        parambxh = localbxi.aagf;
        if (parambxh == null)
        {
          parambxh = null;
          l1 = dZo();
          if ((parambxh == null) || (parambxh.aagw != 1)) {
            break label1939;
          }
        }
        for (i = 1;; i = 0)
        {
          if ((i != 0) || ((l1 > q.ASF.eaH()) && (dZv()))) {
            break label1943;
          }
          parambxh = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
          com.tencent.mm.plugin.finder.extension.reddot.nearby.a.j(localbxi.aagf);
          parambxh = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
          com.tencent.mm.plugin.finder.extension.reddot.nearby.a.k(localbxi.aagf);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l1 + "ms, finderLiveEntranceEntranceTimeMs=" + q.ASF.eaH() + "ms, remove entrance path red dot");
          break;
          parambxh = parambxh.aabA;
          if (parambxh == null)
          {
            parambxh = null;
            break label1751;
          }
          localObject4 = ((Iterable)parambxh).iterator();
          do
          {
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            parambxh = ((Iterator)localObject4).next();
          } while (!s.p(((bxq)parambxh).path, "FinderLiveEntrance"));
          for (;;)
          {
            parambxh = (bxq)parambxh;
            break;
            parambxh = null;
          }
        }
        break label305;
        parambxh = Integer.valueOf(parambxh.type);
        break label374;
        parambxh = Integer.valueOf(parambxh.type);
        break label430;
        parambxh = Integer.valueOf(parambxh.type);
        break label484;
        bool1 = false;
        break label531;
        parambxh = ((btw)localObject3).aabA;
        if (parambxh == null)
        {
          parambxh = null;
          break label538;
        }
        localObject3 = ((Iterable)parambxh).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          parambxh = ((Iterator)localObject3).next();
        } while (!s.p(((bxq)parambxh).path, "finder_tl_hot_tab"));
        for (;;)
        {
          parambxh = (bxq)parambxh;
          if (parambxh != null) {
            break label2063;
          }
          parambxh = null;
          break;
          parambxh = null;
        }
        parambxh = Integer.valueOf(parambxh.aagw);
        break label538;
        bool2 = false;
        break label562;
      }
      parambxh = null;
      localObject1 = localbxi.aagf;
      if (localObject1 != null)
      {
        f((btw)localObject1);
        parambxh = d((btw)localObject1);
        Nv(((btw)localObject1).type);
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      b(localbxi.aagf, "notifyTabTip");
      localObject1 = a(this, localbxi.aagf, s.X("notifyTabTip#", paramString), null, true, parambxh, null, paramLong, 36);
      Object localObject3 = new StringBuilder("[notifyTabTip] successfully! ctrlType=");
      if (localObject1 == null)
      {
        parambxh = null;
        localObject3 = ((StringBuilder)localObject3).append(parambxh).append(" tabType=");
        if (localObject1 != null) {
          break label3056;
        }
        parambxh = null;
        localObject3 = ((StringBuilder)localObject3).append(parambxh).append(" isAiRedDot=");
        if (localObject1 != null) {
          break label3082;
        }
        parambxh = null;
        localObject3 = ((StringBuilder)localObject3).append(parambxh).append(" extInfo=");
        parambxh = localbxi.aagf;
        if (parambxh != null) {
          break label3094;
        }
        parambxh = null;
        if (parambxh == null) {
          break label3102;
        }
        bool1 = true;
        parambxh = ((StringBuilder)localObject3).append(bool1).append(" objectId=");
        if (localObject1 != null) {
          break label3108;
        }
        l1 = 0L;
        parambxh = parambxh.append(com.tencent.mm.ae.d.hF(l1)).append(" diffTime=").append(l2).append("ms isInFinder=").append(bool3).append(" currentTabType=").append(this.AQy.GKp).append(" showInfoSize=");
        localObject3 = localbxi.aagf;
        if (localObject3 != null) {
          break label3136;
        }
        i = 0;
        localObject3 = parambxh.append(i).append(" tabTipsByPassInfo=");
        if (localObject1 != null) {
          break label3164;
        }
        parambxh = null;
        if (parambxh == null) {
          break label3187;
        }
        bool1 = true;
        localObject1 = ((StringBuilder)localObject3).append(bool1).append(" expiredTime=");
        parambxh = localbxi.aagf;
        if (parambxh != null) {
          break label3193;
        }
      }
      label2804:
      label2808:
      label3193:
      for (parambxh = null;; parambxh = Integer.valueOf(parambxh.wso))
      {
        Log.i("Finder.RedDotManager", parambxh);
        break;
        label2429:
        parambxh = parambxh.ZYN;
        break label616;
        if (c((btw)localObject3, "TLRecommendTab"))
        {
          parambxh = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eVy().bmg()).intValue() == 1)
          {
            bool1 = true;
            if (localObject3 != null) {
              break label2624;
            }
            parambxh = null;
            bool4 = this.AQy.Rp(1);
            if (this.AQy.GKp != 1) {
              break label2714;
            }
            bool2 = true;
            if (parambxh != null) {
              break label2720;
            }
            if ((!bool1) || ((!bool2) && (bool4))) {
              break label2729;
            }
            localObject1 = new StringBuilder("ignore this reddot.ctrlType=").append(localObject1).append(" tips_id=");
            parambxh = localbxi.aagf;
            if (parambxh != null) {
              break label2731;
            }
          }
          for (parambxh = null;; parambxh = parambxh.ZYN)
          {
            Log.w("Finder.RedDotManager", parambxh + " isInFinder=" + bool3 + " isFilter=" + bool1 + " isInSelfTab=" + bool2 + " isAutoRefresh=" + bool4);
            break;
            bool1 = false;
            break label2471;
            parambxh = ((btw)localObject3).aabA;
            if (parambxh == null)
            {
              parambxh = null;
              break label2478;
            }
            localObject3 = ((Iterable)parambxh).iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              parambxh = ((Iterator)localObject3).next();
            } while (!s.p(((bxq)parambxh).path, "TLRecommendTab"));
            for (;;)
            {
              parambxh = (bxq)parambxh;
              if (parambxh != null) {
                break label2703;
              }
              parambxh = null;
              break;
              parambxh = null;
            }
            parambxh = Integer.valueOf(parambxh.aagw);
            break label2478;
            bool2 = false;
            break label2502;
            if (parambxh.intValue() == 1) {
              break label2088;
            }
            break label2506;
            break label2088;
          }
        }
        if (!c((btw)localObject3, "TLFollow")) {
          break label2088;
        }
        parambxh = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eVz().bmg()).intValue() == 1)
        {
          bool1 = true;
          if (localObject3 != null) {
            break label2926;
          }
          parambxh = null;
          bool4 = this.AQy.Rp(3);
          if (this.AQy.GKp != 3) {
            break label3016;
          }
          bool2 = true;
          if (parambxh != null) {
            break label3022;
          }
          if ((!bool1) || ((!bool2) && (bool4))) {
            break label3031;
          }
          localObject1 = new StringBuilder("ignore this reddot.ctrlType=").append(localObject1).append(" tips_id=");
          parambxh = localbxi.aagf;
          if (parambxh != null) {
            break label3033;
          }
        }
        for (parambxh = null;; parambxh = parambxh.ZYN)
        {
          Log.w("Finder.RedDotManager", parambxh + " isInFinder=" + bool3 + " isFilter=" + bool1 + " isInSelfTab=" + bool2 + " isAutoRefresh=" + bool4);
          break;
          bool1 = false;
          break label2773;
          parambxh = ((btw)localObject3).aabA;
          if (parambxh == null)
          {
            parambxh = null;
            break label2780;
          }
          localObject3 = ((Iterable)parambxh).iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            parambxh = ((Iterator)localObject3).next();
          } while (!s.p(((bxq)parambxh).path, "TLFollow"));
          for (;;)
          {
            parambxh = (bxq)parambxh;
            if (parambxh != null) {
              break label3005;
            }
            parambxh = null;
            break;
            parambxh = null;
          }
          parambxh = Integer.valueOf(parambxh.aagw);
          break label2780;
          bool2 = false;
          break label2804;
          if (parambxh.intValue() == 1) {
            break label2088;
          }
          break label2808;
          break label2088;
        }
        parambxh = Integer.valueOf(((p)localObject1).field_ctrInfo.type);
        break label2190;
        parambxh = ((p)localObject1).ASz;
        if (parambxh == null)
        {
          parambxh = null;
          break label2211;
        }
        parambxh = Integer.valueOf(parambxh.tab_type);
        break label2211;
        parambxh = Boolean.valueOf(((p)localObject1).eay());
        break label2232;
        parambxh = parambxh.aabz;
        break label2258;
        bool1 = false;
        break label2265;
        localObject3 = ((p)localObject1).field_ctrInfo;
        if (localObject3 == null)
        {
          l1 = 0L;
          break label2287;
        }
        l1 = ((btw)localObject3).feedId;
        break label2287;
        localObject3 = ((btw)localObject3).aabA;
        if (localObject3 == null)
        {
          i = 0;
          break label2356;
        }
        i = ((LinkedList)localObject3).size();
        break label2356;
        parambxh = ((p)localObject1).ASz;
        if (parambxh == null)
        {
          parambxh = null;
          break label2377;
        }
        parambxh = parambxh.tabTipsByPassInfo;
        break label2377;
        bool1 = false;
        break label2384;
      }
    }
    label430:
    label562:
    label964:
    label966:
    label1511:
    label1513:
    label2926:
    AppMethodBeat.o(367032);
    label531:
    label538:
    label690:
    label1075:
    label1077:
    label1733:
    label1737:
    label1751:
    label2265:
    label2780:
    return;
  }
  
  public final void a(bze parambze)
  {
    AppMethodBeat.i(178172);
    s.u(parambze, "wxMention");
    long l = cn.bDw();
    Object localObject = q.ASF;
    l -= q.eaP();
    if ((parambze.count <= 0) && (parambze.aaio <= 0) && (parambze.aain <= 0) && (parambze.ZFR <= 0) && (parambze.ZFQ <= 0) && (parambze.aaim <= 0) && (parambze.aaip <= 0) && (parambze.aair <= 0))
    {
      Log.e("Finder.RedDotManager", "[notifyWxMentionCount] server error.");
      AppMethodBeat.o(178172);
      return;
    }
    Log.i("Finder.RedDotManager", "[notifyWxMentionCount] diffTime=" + l + " newMsgEntranceInterval=" + q.ASF.eaI() + ' ' + e(parambze.aagf) + " count=" + parambze.count);
    localObject = parambze.aagf;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label359;
      }
      i = 0;
      label187:
      if (i != 1) {
        break label368;
      }
    }
    label359:
    label368:
    for (int i = 1;; i = 0)
    {
      if (l < q.ASF.eaI())
      {
        if (i == 0) {
          g(parambze.aagf);
        }
        localObject = parambze.aagf;
        if (localObject != null)
        {
          localObject = ((btw)localObject).aabA;
          if (localObject != null) {
            com.tencent.mm.ae.d.a((LinkedList)localObject, (kotlin.g.a.b)aa.ARm);
          }
        }
      }
      a(this, parambze.aagf, "notifyWxMentionCount", null, true, null, null, 0L, 116);
      AppMethodBeat.o(178172);
      return;
      localObject = ((btw)localObject).aabA;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      Iterator localIterator = ((Iterable)localObject).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!s.p(((bxq)localObject).path, "FinderEntrance"));
      for (;;)
      {
        localObject = (bxq)localObject;
        break;
        localObject = null;
      }
      i = ((bxq)localObject).aagw;
      break label187;
    }
  }
  
  public final void a(String paramString, kotlin.g.a.b<? super p, Boolean> paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(366989);
    s.u(paramString, "path");
    s.u(paramb, "call");
    Object localObject2 = new HashSet();
    ((HashSet)localObject2).add(paramString);
    p localp1 = Su(paramString);
    bxq localbxq;
    Object localObject3;
    Object localObject1;
    if (localp1 == null)
    {
      localbxq = null;
      localObject3 = (List)this.AQI.get(paramString);
      if (localObject3 == null) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          Iterator localIterator1 = ((List)localObject3).iterator();
          if (!localIterator1.hasNext()) {
            break label264;
          }
          p localp2 = (p)localIterator1.next();
          Iterator localIterator2 = ((Iterable)this.AQK).iterator();
          if (!localIterator2.hasNext()) {
            break label258;
          }
          localObject1 = localIterator2.next();
          if (!((Boolean)((kotlin.g.a.b)localObject1).invoke(localp2)).booleanValue()) {
            continue;
          }
          if (((kotlin.g.a.b)localObject1 != null) || (!((Boolean)paramb.invoke(localp2)).booleanValue())) {
            continue;
          }
          localObject1 = localp2.bt(paramString, paramBoolean);
          if (p.a(localp2, (MAutoStorage)this.AQt)) {
            ((HashSet)localObject2).addAll((Collection)localObject1);
          }
          if (!localp2.eax()) {
            continue;
          }
          localIterator1.remove();
          continue;
          localbxq = localp1.avK(paramString);
        }
        finally
        {
          AppMethodBeat.o(366989);
        }
        break;
        label258:
        localObject1 = null;
      }
      label264:
      paramb = ah.aiuX;
    }
    paramb = new StringBuilder("[disposeRedDotAtPath] path=").append(paramString).append(" tipsId=");
    if (localp1 == null) {}
    for (paramString = null;; paramString = localp1.field_tipsId)
    {
      Log.i("Finder.RedDotManager", paramString + " removePathSet=" + localObject2 + " maybeRemoveShowInfo=" + a(localbxq, 0) + " hash=" + hashCode());
      paramb = ((Iterable)localObject2).iterator();
      for (;;)
      {
        if (!paramb.hasNext()) {
          break label506;
        }
        localObject1 = (String)paramb.next();
        paramString = Su((String)localObject1);
        if (paramString != null) {
          break;
        }
        paramString = null;
        label396:
        if (paramString != null) {
          break label481;
        }
        paramString = l.ARA;
        l.a(false, (String)localObject1, localbxq, localp1);
      }
    }
    localObject2 = paramString.avK((String)localObject1);
    int i;
    if (localObject2 != null)
    {
      i = 1;
      label442:
      if (i == 0) {
        break label489;
      }
      localObject3 = l.ARA;
      l.a(false, (String)localObject1, localbxq, localp1);
      localObject3 = l.ARA;
      l.a(true, (String)localObject1, (bxq)localObject2, paramString);
    }
    for (;;)
    {
      paramString = ah.aiuX;
      break label396;
      label481:
      break;
      i = 0;
      break label442;
      label489:
      paramString = l.ARA;
      l.a(false, (String)localObject1, localbxq, localp1);
    }
    label506:
    AppMethodBeat.o(366989);
  }
  
  public final bxq avp(String paramString)
  {
    AppMethodBeat.i(178178);
    s.u(paramString, "path");
    p localp = Su(paramString);
    if (localp == null)
    {
      AppMethodBeat.o(178178);
      return null;
    }
    paramString = localp.avK(paramString);
    AppMethodBeat.o(178178);
    return paramString;
  }
  
  public final FinderTipsShowEntranceExtInfo avr(String paramString)
  {
    AppMethodBeat.i(367035);
    s.u(paramString, "path");
    paramString = Su(paramString);
    if (paramString == null) {}
    for (paramString = null; paramString == null; paramString = paramString.eav())
    {
      paramString = new FinderTipsShowEntranceExtInfo();
      AppMethodBeat.o(367035);
      return paramString;
    }
    AppMethodBeat.o(367035);
    return paramString;
  }
  
  public final btx avs(String paramString)
  {
    AppMethodBeat.i(367051);
    s.u(paramString, "path");
    paramString = (b)this.AQM.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(367051);
      return null;
    }
    paramString = paramString.AQP;
    AppMethodBeat.o(367051);
    return paramString;
  }
  
  public final void aw(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(366975);
    if ((paramInt1 <= 0) && (paramInt2 <= 0) && (paramInt3 <= 0))
    {
      Log.i("Finder.RedDotManager", "[notifyFinderMsgCount] server error.");
      AppMethodBeat.o(366975);
      return;
    }
    btw localbtw = new btw();
    localbtw.ZYN = String.valueOf(cn.bDw());
    localbtw.priority = 400000;
    localbtw.type = 2;
    Object localObject1 = new bxq();
    ((bxq)localObject1).show_type = 2;
    ((bxq)localObject1).aagq = 1;
    ((bxq)localObject1).path = "AuthorProfileNotify";
    ((bxq)localObject1).count = (paramInt1 + paramInt2 + paramInt3);
    localbtw.aabA.add(localObject1);
    if (paramInt1 > 0)
    {
      localObject1 = new bxq();
      ((bxq)localObject1).show_type = 2;
      ((bxq)localObject1).aagq = 1;
      ((bxq)localObject1).path = "NotificationCenterLike";
      ((bxq)localObject1).count = paramInt1;
      localbtw.aabA.add(localObject1);
    }
    if (paramInt2 > 0)
    {
      localObject1 = new bxq();
      ((bxq)localObject1).show_type = 2;
      ((bxq)localObject1).aagq = 1;
      ((bxq)localObject1).path = "NotificationCenterComment";
      ((bxq)localObject1).count = paramInt2;
      localbtw.aabA.add(localObject1);
    }
    if (paramInt3 > 0)
    {
      localObject1 = new bxq();
      ((bxq)localObject1).show_type = 2;
      ((bxq)localObject1).aagq = 1;
      ((bxq)localObject1).path = "NotificationCenterFollow";
      ((bxq)localObject1).count = paramInt3;
      localbtw.aabA.add(localObject1);
    }
    c(localbtw);
    localObject1 = localbtw.aabA;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (s.p(((bxq)localObject3).path, "TLPersonalCenter")) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      if (((Collection)localObject1).isEmpty()) {
        break label515;
      }
      i = 1;
      if (i == 0) {
        break label521;
      }
      label391:
      if (localObject1 != null)
      {
        localObject1 = (bxq)((List)localObject1).get(0);
        if ((localObject1 != null) && (((bxq)localObject1).show_type == 2))
        {
          localObject2 = avp("finder_private_msg_entrance");
          if (localObject2 != null) {
            break label527;
          }
        }
      }
    }
    label515:
    label521:
    label527:
    for (int i = 0;; i = ((bxq)localObject2).count)
    {
      ((bxq)localObject1).count = (paramInt1 + paramInt2 + paramInt3 + i);
      Log.i("Finder.RedDotManager", "count :" + ((bxq)localObject1).count + " finderMessageCount:" + i);
      a(this, localbtw, "notifyFinderTabMsgCount", null, false, null, null, 0L, 124);
      AppMethodBeat.o(366975);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label391;
    }
  }
  
  public final void b(btw parambtw, String paramString)
  {
    AppMethodBeat.i(367049);
    s.u(paramString, "source");
    String str;
    b localb;
    int i;
    if (parambtw != null)
    {
      str = Nu(d(p.a(new p(), parambtw)));
      localb = (b)this.AQM.get(str);
      if (localb != null)
      {
        if ((!s.p(localb.AQQ, parambtw.ZYN)) && (!s.p(paramString, "notifyTabTip"))) {
          break label155;
        }
        i = 1;
        if (i == 0) {
          break label160;
        }
      }
    }
    for (;;)
    {
      if (localb != null)
      {
        this.AQM.remove(str);
        Log.i("Finder.RedDotManager", "[clearEnterTabTipsExtInfo] PATH=" + str + " tips_id=" + parambtw.ZYN + " source=" + paramString);
      }
      AppMethodBeat.o(367049);
      return;
      label155:
      i = 0;
      break;
      label160:
      localb = null;
    }
  }
  
  public final boolean b(int paramInt, kotlin.g.a.b<? super p, Boolean> paramb)
  {
    AppMethodBeat.i(367020);
    s.u(paramb, "filter");
    if ((((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZE()) && (!p(Integer.valueOf(paramInt))))
    {
      Log.i("Finder.RedDotManager", "[clearCtrlInfo] 青少年模式且只看关注的模式下只clear关注的红点展示");
      AppMethodBeat.o(367020);
      return false;
    }
    HashMap localHashMap = c(paramInt, paramb);
    int i;
    Iterator localIterator;
    if (!((Map)localHashMap).isEmpty())
    {
      i = 1;
      if (i != 0) {
        Log.i("Finder.RedDotManager", "[clearCtrlInfo] type=" + paramInt + " clearMap=" + localHashMap);
      }
      localIterator = ((Map)localHashMap).entrySet().iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramb = (Map.Entry)localIterator.next();
        String str = (String)paramb.getKey();
        Object localObject = (List)this.AQI.get(str);
        if (localObject != null) {
          com.tencent.mm.ae.d.a((List)localObject, (kotlin.g.a.b)new i.j(paramb));
        }
        paramb = ((Iterable)paramb.getValue()).iterator();
        for (;;)
        {
          if (paramb.hasNext())
          {
            p.b((p)paramb.next(), (MAutoStorage)this.AQt);
            continue;
            i = 0;
            break;
          }
        }
        paramb = Su(str);
        if (paramb == null)
        {
          paramb = null;
          label268:
          if (paramb == null)
          {
            paramb = l.ARA;
            l.a(false, str, null, null);
          }
        }
        else
        {
          localObject = paramb.avK(str);
          if (localObject == null) {
            break label340;
          }
          paramInt = 1;
          label302:
          if (paramInt == 0) {
            break label345;
          }
          l locall = l.ARA;
          l.a(false, str, null, null);
          locall = l.ARA;
          l.a(true, str, (bxq)localObject, paramb);
        }
        for (;;)
        {
          paramb = ah.aiuX;
          break label268;
          break;
          label340:
          paramInt = 0;
          break label302;
          label345:
          paramb = l.ARA;
          l.a(false, str, null, null);
        }
      }
    }
    if (!((Map)localHashMap).isEmpty())
    {
      AppMethodBeat.o(367020);
      return true;
    }
    AppMethodBeat.o(367020);
    return false;
  }
  
  public final void d(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(366986);
    s.u(paramString, "path");
    a(paramString, (kotlin.g.a.b)new o(paramArrayOfInt), false);
    AppMethodBeat.o(366986);
  }
  
  public final void dZj()
  {
    AppMethodBeat.i(178169);
    Object localObject = r.ASG;
    Log.i("Finder.ThreeDayTwoDay", "enterFindMoreFriendTab");
    if (((r)localObject).ebe())
    {
      localObject = r.Asl;
      if (localObject != null)
      {
        localObject = ((i)localObject).Su("FinderEntrance");
        if (localObject != null)
        {
          bxq localbxq = ((p)localObject).avK("FinderEntrance");
          if (localbxq != null) {
            w.a(w.FrV, "1", (p)localObject, localbxq, 4, null, 0, 0, 0, 240);
          }
        }
      }
      localObject = r.Asl;
      if (localObject != null) {
        ((i)localObject).TL("FinderEntrance");
      }
    }
    AppMethodBeat.o(178169);
  }
  
  public final void dZl()
  {
    AppMethodBeat.i(366979);
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adfd, false))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfd, Boolean.TRUE);
      btw localbtw = new btw();
      localbtw.ZYN = String.valueOf(cn.bDw());
      localbtw.priority = 0;
      localbtw.type = 1018;
      bxq localbxq = new bxq();
      localbxq.show_type = 1;
      localbxq.aagq = 1;
      localbxq.path = "TLPersonalCenter";
      localbtw.aabA.add(localbxq);
      localbxq = new bxq();
      localbxq.show_type = 1;
      localbxq.aagq = 1;
      localbxq.path = "FinderPosterEntrance";
      localbtw.aabA.add(localbxq);
      localbxq = new bxq();
      localbxq.show_type = 1;
      localbxq.aagq = 1;
      localbxq.path = "FinderLiveIncomeEntrance";
      localbxq.Nnp = "TLPersonalCenter";
      localbtw.aabA.add(localbxq);
      a(this, localbtw, "notifyFinderLiveFirstReward", null, false, null, null, 0L, 124);
      Log.i("Finder.RedDotManager", "notifyFinderLiveFirstReward");
    }
    AppMethodBeat.o(366979);
  }
  
  public final void dZp()
  {
    AppMethodBeat.i(366995);
    Object localObject1 = this.AQI.keys();
    s.s(localObject1, "pathToCtrInfoMap.keys()");
    localObject1 = Collections.list((Enumeration)localObject1);
    s.s(localObject1, "java.util.Collections.list(this)");
    localObject1 = (List)localObject1;
    Log.i("Finder.RedDotManager", s.X("resetNotifyAllPathWithCrlInfo#reset, list:", localObject1));
    HashMap localHashMap = new HashMap((Map)this.AQI);
    this.AQI.clear();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject1 = (List)localHashMap.get(str);
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = l.ARA;
        s.s(str, "path");
        if (localObject1 != null) {
          break label245;
        }
        localObject2 = null;
        label142:
        l.a(false, str, (bxq)localObject2, (p)localObject1);
        localObject2 = w.FrV;
        if (localObject1 != null) {
          break label255;
        }
      }
      label181:
      label223:
      label238:
      label245:
      label255:
      for (Object localObject2 = null;; localObject2 = ((p)localObject1).avK(str))
      {
        w.a((p)localObject1, (bxq)localObject2);
        break;
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        int i;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          p localp = (p)localObject1;
          s.s(str, "path");
          if (localp.avK(str) != null)
          {
            i = 1;
            if (i == 0) {
              break label238;
            }
          }
        }
        for (;;)
        {
          localObject1 = (p)localObject1;
          break;
          i = 0;
          break label223;
          break label181;
          localObject1 = null;
        }
        localObject2 = ((p)localObject1).avK(str);
        break label142;
      }
    }
    AppMethodBeat.o(366995);
  }
  
  public final int dZq()
  {
    int j = -1;
    AppMethodBeat.i(367015);
    long l = System.currentTimeMillis();
    Object localObject2 = Su("FinderEntrance");
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = null;
    }
    int i;
    int k;
    while (localObject1 != null)
    {
      if (((bxq)localObject1).aagw == 1)
      {
        if (((bxq)localObject1).akkS == 0)
        {
          AppMethodBeat.o(367015);
          return -100;
          localObject1 = ((p)localObject2).avK("FinderEntrance");
          continue;
        }
        if (((bxq)localObject1).akkS == 1)
        {
          i = d((p)localObject2);
          AppMethodBeat.o(367015);
          return i;
        }
      }
      k = ((p)localObject2).ASz.tab_type;
      int m = ((p)localObject2).ASz.aabL;
      if (k != -1) {
        i = k;
      }
      for (;;)
      {
        Log.i("Finder.RedDotManager", "[getAliveTabType] -- displayTabType: " + k + " enterAction: " + m + "  tabType:" + i);
        if (i == -1) {
          break;
        }
        AppMethodBeat.o(367015);
        return i;
        switch (m)
        {
        default: 
          i = -1;
          break;
        case 2: 
          i = 1;
          break;
        case 3: 
          i = 3;
          break;
        case 4: 
          i = 4;
        }
      }
    }
    Object localObject4;
    if ((localObject1 == null) || (((p)localObject2).avK("finder_private_msg_entrance") != null))
    {
      i = this.AQy.GKq;
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eSB().bmg()).intValue() == 1) && (i == 4))
      {
        Log.i("Finder.RedDotManager", "[getAliveTabType] IS_HARD_JUMP_HOT_WITHOUT_ENTRANCE_REDDOT = true");
        AppMethodBeat.o(367015);
        return 4;
      }
      localObject1 = c.AQR;
      localObject1 = i.c.a.a(1, this);
      localObject2 = c.AQR;
      localObject2 = i.c.a.a(3, this);
      Object localObject3 = c.AQR;
      localObject3 = kotlin.a.p.listOf(new c[] { localObject1, localObject2, i.c.a.a(4, this) });
      localObject4 = ((Iterable)localObject3).iterator();
      if (!((Iterator)localObject4).hasNext()) {
        localObject1 = null;
      }
      label401:
      do
      {
        s.checkNotNull(localObject1);
        localObject1 = (c)localObject1;
        if (((c)localObject1).AQS.aagC > 0) {
          break;
        }
        i = j;
        localObject1 = new StringBuilder("[getAliveTabType] cost=").append(System.currentTimeMillis() - l).append("ms aliveType=").append(i).append(" maxPriorityTabType=").append(((c)localObject1).hJx).append(' ');
        localObject3 = (Iterable)localObject3;
        localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((Collection)localObject2).add(((c)localObject4).hJx + '=' + ((c)localObject4).AQS.aagC);
        }
        localObject1 = ((Iterator)localObject4).next();
      } while (!((Iterator)localObject4).hasNext());
      i = ((c)localObject1).AQS.aagC;
      label587:
      localObject2 = ((Iterator)localObject4).next();
      k = ((c)localObject2).AQS.aagC;
      if (i >= k) {
        break label723;
      }
      localObject1 = localObject2;
      i = k;
    }
    label723:
    for (;;)
    {
      if (!((Iterator)localObject4).hasNext())
      {
        break;
        i = ((c)localObject1).hJx;
        break label401;
        Log.i("Finder.RedDotManager", (List)localObject2);
        AppMethodBeat.o(367015);
        return i;
        i = d((p)localObject2);
        Log.i("Finder.RedDotManager", s.X("[getAliveTabType] getTabTypeInCtrlInfo=", Integer.valueOf(i)));
        if (i != -1)
        {
          AppMethodBeat.o(367015);
          return i;
        }
        Log.i("Finder.RedDotManager", "[getAliveTabType] TAB_TYPE_INVALID");
        AppMethodBeat.o(367015);
        return -1;
      }
      break label587;
    }
  }
  
  public final Set<p> dZr()
  {
    AppMethodBeat.i(367060);
    Object localObject = new HashSet();
    Iterator localIterator = ((Map)this.AQI).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((HashSet)localObject).addAll((Collection)((Map.Entry)localIterator.next()).getValue());
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(367060);
    return localObject;
  }
  
  public final boolean dZs()
  {
    AppMethodBeat.i(367065);
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.addS, true);
    AppMethodBeat.o(367065);
    return bool;
  }
  
  public final boolean dZt()
  {
    AppMethodBeat.i(367075);
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.addT, true);
    AppMethodBeat.o(367075);
    return bool;
  }
  
  public final boolean dZu()
  {
    return true;
  }
  
  public final boolean dZv()
  {
    AppMethodBeat.i(367080);
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.addU, true);
    AppMethodBeat.o(367080);
    return bool;
  }
  
  public final void e(p paramp)
  {
    AppMethodBeat.i(367045);
    s.u(paramp, "enterCtrlInfo");
    int i = d(paramp);
    String str = Nu(i);
    Log.i("Finder.RedDotManager", "[saveEnterTabTipsExtInfo] tabType=" + i + " PATH=" + str + " ctrlType=" + paramp.field_ctrInfo.type + " feedId=" + com.tencent.mm.ae.d.hF(paramp.ASz.object_id));
    Map localMap = (Map)this.AQM;
    btx localbtx = paramp.ASz;
    paramp = paramp.field_tipsId;
    s.s(paramp, "enterCtrlInfo.field_tipsId");
    localMap.put(str, new b(localbtx, paramp));
    AppMethodBeat.o(367045);
  }
  
  public final boolean eFD()
  {
    AppMethodBeat.i(371886);
    Object localObject = Su("FinderEntrance");
    if (localObject == null) {}
    for (localObject = null; (localObject != null) && (((bxq)localObject).aagw == 1); localObject = ((p)localObject).avK("FinderEntrance"))
    {
      AppMethodBeat.o(371886);
      return true;
    }
    AppMethodBeat.o(371886);
    return false;
  }
  
  public final btx hH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(367056);
    s.u(paramString1, "path");
    s.u(paramString2, "source");
    b localb = (b)this.AQM.remove(paramString1);
    Log.i("Finder.RedDotManager", "[clearEnterTabTipsExtInfo] path=" + paramString1 + " result=" + localb + " source=" + paramString2);
    if (localb == null)
    {
      AppMethodBeat.o(367056);
      return null;
    }
    paramString1 = localb.AQP;
    AppMethodBeat.o(367056);
    return paramString1;
  }
  
  public final void hs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(366974);
    if ((paramInt1 <= 0) && (paramInt2 <= 0))
    {
      Log.i("Finder.RedDotManager", "[notifyWxMsgCount] server error.");
      AppMethodBeat.o(366974);
      return;
    }
    btw localbtw = new btw();
    localbtw.ZYN = String.valueOf(cn.bDw());
    localbtw.priority = 400000;
    localbtw.type = 1021;
    bxq localbxq;
    if (paramInt1 > 0)
    {
      localbxq = new bxq();
      localbxq.show_type = 2;
      localbxq.aagq = 1;
      localbxq.path = "WxMessageLike";
      localbxq.count = paramInt1;
      localbtw.aabA.add(localbxq);
    }
    if (paramInt2 > 0)
    {
      localbxq = new bxq();
      localbxq.show_type = 2;
      localbxq.aagq = 1;
      localbxq.path = "WxMessageComment";
      localbxq.count = paramInt2;
      localbtw.aabA.add(localbxq);
    }
    a(this, localbtw, "notifyWxMsgCount", null, false, null, null, 0L, 124);
    AppMethodBeat.o(366974);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(367086);
    Log.i("Finder.RedDotManager", s.X("scene = ", paramp));
    if ((paramp != null) && (paramp.getType() == 3930) && (paramInt1 == 0) && (paramInt2 == 0)) {
      this.AQu.eao();
    }
    AppMethodBeat.o(367086);
  }
  
  public final void pN(boolean paramBoolean)
  {
    AppMethodBeat.i(367069);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addS, Boolean.valueOf(paramBoolean));
    z localz = z.FrZ;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      z.ig(1, i);
      AppMethodBeat.o(367069);
      return;
    }
  }
  
  public final void pO(boolean paramBoolean)
  {
    AppMethodBeat.i(367078);
    if (!paramBoolean)
    {
      com.tencent.mm.plugin.finder.extension.reddot.nearby.a locala = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
      com.tencent.mm.plugin.finder.extension.reddot.nearby.a.avL("#setEnableShowEntranceRedDot");
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addT, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(367078);
  }
  
  public final void pP(boolean paramBoolean)
  {
    AppMethodBeat.i(367081);
    if (!paramBoolean)
    {
      com.tencent.mm.plugin.finder.extension.reddot.nearby.a locala = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
      com.tencent.mm.plugin.finder.extension.reddot.nearby.a.avN("#setEnableShowFinderLiveEntranceRedDot");
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addU, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(367081);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(178168);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(178168);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = this.AQt.dZg();
    int i = ((LinkedList)localObject1).size();
    Object localObject3 = g.AQm;
    boolean bool = g.a((LinkedList)localObject1, this.AQt);
    int j = ((LinkedList)localObject1).size();
    Log.i("Finder.RedDotManager", "[prepare] checkRet=" + bool + " beforeCheckCount=" + i + " afterCheckCount=" + j);
    try
    {
      localObject3 = Result.Companion;
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label668;
        }
        localObject3 = (p)((Iterator)localObject1).next();
        if (!((p)localObject3).eax()) {
          break;
        }
        Log.w("Finder.RedDotManager", s.X("[prepare] showInfo is empty! ", localObject3));
        ((p)localObject3).b((MAutoStorage)this.AQt, false);
      }
      localObject2 = Result.exceptionOrNull-impl(localObject2);
    }
    finally
    {
      localObject3 = Result.Companion;
      localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
    }
    label199:
    if (localObject2 != null) {
      Log.printErrStackTrace("Finder.RedDotManager", (Throwable)localObject2, "", new Object[0]);
    }
    this.AQC.alive();
    this.AQD.alive();
    localObject3 = this.AQx;
    Object localObject2 = com.tencent.mm.plugin.newtips.a.gte();
    localObject3 = (l.a)localObject3;
    ((com.tencent.mm.plugin.newtips.a.l)localObject2).MsS.put("FinderNewTipsTransform", localObject3);
    localObject3 = this.AQu;
    localObject2 = ((n)localObject3).APO.Su("FinderEntrance");
    if ((localObject2 != null) && (((p)localObject2).field_ctrInfo.type == -1))
    {
      localObject2 = ((p)localObject2).avK("FinderEntrance");
      if (localObject2 == null)
      {
        localObject2 = null;
        label326:
        if (localObject2 != null) {
          break label692;
        }
      }
    }
    else
    {
      label331:
      ((n)localObject3).APO.Nv(1001);
      Log.i("Finder.RedDotTransform", s.X("[checkPostRedDot] has old fav red dot, ret=", ah.aiuX));
      localObject2 = ae.Ghi;
      ae.d(((n)localObject3).APO);
      Nv(1005);
      localObject2 = r.ASG;
      r.c(this);
      localObject2 = new h(this);
      ((h)localObject2).AQo.alive();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h.c((h)localObject2));
      h.a((h)localObject2, "setup");
      AppForegroundDelegate.heY.a((com.tencent.mm.app.q)localObject2);
      localObject3 = ah.aiuX;
      this.DJe = ((h)localObject2);
      localObject2 = this.AQz;
      ((o)localObject2).qmT.alive();
      ((o)localObject2).qmS.alive();
      localObject2 = this.AQA;
      ((a)localObject2).bZN();
      ((a)localObject2).qnf.alive();
      ((a)localObject2).qlY.alive();
      ((a)localObject2).APL.alive();
      ((a)localObject2).qnK.alive();
      Log.i("Finder.RedDotManager", "[prepare] " + (System.currentTimeMillis() - l) + "ms hashCode=" + hashCode());
      AppMethodBeat.o(178168);
      return;
      if ((((p)localObject3).field_expiredTime <= 0L) || (((p)localObject3).field_expiredTime * 1000L + ((p)localObject3).field_time > cn.bDw())) {
        break label733;
      }
    }
    label668:
    label692:
    label733:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.w("Finder.RedDotManager", s.X("[prepare] isExpired! ", localObject3));
        ((p)localObject3).b((MAutoStorage)this.AQt, false);
        break;
      }
      btw localbtw = ((p)localObject3).field_ctrInfo;
      s.s(localbtw, "it.field_ctrInfo");
      a(((p)localObject3).a(localbtw, ((p)localObject3).field_aiScene), "prepare");
      break;
      localObject2 = Result.constructor-impl(ah.aiuX);
      break label199;
      localObject2 = Integer.valueOf(((bxq)localObject2).aagq);
      break label326;
      if (((Integer)localObject2).intValue() != 2) {
        break label331;
      }
      ((n)localObject3).APO.Nv(-1);
      Log.i("Finder.RedDotTransform", s.X("[checkPostRedDot] has old post red dot, ret=", ah.aiuX));
      ((n)localObject3).eap();
      break label331;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$Companion;", "", "()V", "TAB_TIPS_TEST", "", "getTAB_TIPS_TEST", "()Z", "setTAB_TIPS_TEST", "(Z)V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    public static final aa ARm;
    
    static
    {
      AppMethodBeat.i(178163);
      ARm = new aa();
      AppMethodBeat.o(178163);
    }
    
    aa()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    public static final ab ARn;
    
    static
    {
      AppMethodBeat.i(366745);
      ARn = new ab();
      AppMethodBeat.o(366745);
    }
    
    ab()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends u
    implements kotlin.g.a.b<p, Boolean>
  {
    ac(buk parambuk, ah.a parama1, ah.a parama2, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends u
    implements kotlin.g.a.a<ah>
  {
    ad(bul parambul, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$EnterTabTipsExtInfo;", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "tipsId", "", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;Ljava/lang/String;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getTipsId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final btx AQP;
    public final String AQQ;
    
    public b(btx parambtx, String paramString)
    {
      AppMethodBeat.i(366878);
      this.AQP = parambtx;
      this.AQQ = paramString;
      AppMethodBeat.o(366878);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(366896);
      if (this == paramObject)
      {
        AppMethodBeat.o(366896);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(366896);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.AQP, paramObject.AQP))
      {
        AppMethodBeat.o(366896);
        return false;
      }
      if (!s.p(this.AQQ, paramObject.AQQ))
      {
        AppMethodBeat.o(366896);
        return false;
      }
      AppMethodBeat.o(366896);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(366893);
      int i = this.AQP.hashCode();
      int j = this.AQQ.hashCode();
      AppMethodBeat.o(366893);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(366885);
      String str = "EnterTabTipsExtInfo(ext=" + this.AQP + ", tipsId=" + this.AQQ + ')';
      AppMethodBeat.o(366885);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "", "tabType", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "getTabType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static final a AQR;
    final bxr AQS;
    final int hJx;
    
    static
    {
      AppMethodBeat.i(366889);
      AQR = new a((byte)0);
      AppMethodBeat.o(366889);
    }
    
    public c(int paramInt, bxr parambxr)
    {
      AppMethodBeat.i(366882);
      this.hJx = paramInt;
      this.AQS = parambxr;
      AppMethodBeat.o(366882);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(366902);
      if (this == paramObject)
      {
        AppMethodBeat.o(366902);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(366902);
        return false;
      }
      paramObject = (c)paramObject;
      if (this.hJx != paramObject.hJx)
      {
        AppMethodBeat.o(366902);
        return false;
      }
      if (!s.p(this.AQS, paramObject.AQS))
      {
        AppMethodBeat.o(366902);
        return false;
      }
      AppMethodBeat.o(366902);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(366897);
      int i = this.hJx;
      int j = this.AQS.hashCode();
      AppMethodBeat.o(366897);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(366895);
      String str = "FinderTipsShowTabExt(tabType=" + this.hJx + ", ext=" + this.AQS + ')';
      AppMethodBeat.o(366895);
      return str;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt$Companion;", "", "()V", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "tabType", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static i.c a(int paramInt, i parami)
      {
        int i = 1;
        int j = 0;
        Object localObject2 = null;
        AppMethodBeat.i(366913);
        s.u(parami, "manager");
        Object localObject1 = i.Nu(paramInt);
        parami = parami.Su((String)localObject1);
        bxr localbxr;
        label83:
        label104:
        boolean bool;
        if (parami == null)
        {
          parami = null;
          localbxr = new bxr();
          StringBuilder localStringBuilder = new StringBuilder("[FinderTipsShowTabExt#transform] tabType=").append(paramInt).append(" path=").append((String)localObject1).append(" show_ext_info_type=");
          if (parami != null) {
            break label231;
          }
          localObject1 = null;
          localStringBuilder = localStringBuilder.append(localObject1).append(" show_ext_info=");
          if (parami != null) {
            break label243;
          }
          localObject1 = null;
          if (localObject1 == null) {
            break label252;
          }
          bool = true;
          label112:
          Log.i("Finder.RedDotManager", bool);
          if ((parami == null) || (parami.aagr != 2)) {
            break label258;
          }
          label139:
          if ((i == 0) || (parami.aags == null)) {
            break label271;
          }
          parami = parami.aags;
          if (parami != null) {
            break label263;
          }
          parami = localObject2;
          localbxr.parseFrom(parami);
          Log.i("Finder.RedDotManager", "tabType=" + paramInt + " serverJumpPriority=" + localbxr.aagC);
        }
        label231:
        label243:
        label252:
        while (parami == null) {
          for (;;)
          {
            parami = new i.c(paramInt, localbxr);
            AppMethodBeat.o(366913);
            return parami;
            parami = parami.avK((String)localObject1);
            break;
            localObject1 = Integer.valueOf(parami.aagr);
            break label83;
            localObject1 = parami.aags;
            break label104;
            bool = false;
            break label112;
            i = 0;
            break label139;
            parami = parami.toByteArray();
          }
        }
        label258:
        label263:
        label271:
        i = j;
        switch (paramInt)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          localbxr.aagC = i;
          break;
          i = 700000;
          continue;
          i = 600000;
          continue;
          i = 500000;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    public static final d AQT;
    
    static
    {
      AppMethodBeat.i(366886);
      AQT = new d();
      AppMethodBeat.o(366886);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<p, Comparable<?>>
  {
    public static final f AQU;
    
    static
    {
      AppMethodBeat.i(178152);
      AQU = new f();
      AppMethodBeat.o(178152);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<p, Boolean>
  {
    public static final k AQZ;
    
    static
    {
      AppMethodBeat.i(366907);
      AQZ = new k();
      AppMethodBeat.o(366907);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.b<p, Boolean>
  {
    l(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<p, Boolean>
  {
    public static final m ARb;
    
    static
    {
      AppMethodBeat.i(366916);
      ARb = new m();
      AppMethodBeat.o(366916);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<p, Boolean>
  {
    public static final n ARc;
    
    static
    {
      AppMethodBeat.i(366708);
      ARc = new n();
      AppMethodBeat.o(366708);
    }
    
    n()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.b<p, Boolean>
  {
    o(int[] paramArrayOfInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.b<p, Boolean>
  {
    p(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.b<p, Boolean>
  {
    public static final q ARe;
    
    static
    {
      AppMethodBeat.i(366717);
      ARe = new q();
      AppMethodBeat.o(366717);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    public static final r ARf;
    
    static
    {
      AppMethodBeat.i(366719);
      ARf = new r();
      AppMethodBeat.o(366719);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    public static final w ARj;
    
    static
    {
      AppMethodBeat.i(178161);
      ARj = new w();
      AppMethodBeat.o(178161);
    }
    
    w()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "local", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements kotlin.g.a.b<p, ah>
  {
    x(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    public static final y ARk;
    
    static
    {
      AppMethodBeat.i(366733);
      ARk = new y();
      AppMethodBeat.o(366733);
    }
    
    y()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    public static final z ARl;
    
    static
    {
      AppMethodBeat.i(366734);
      ARl = new z();
      AppMethodBeat.o(366734);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.i
 * JD-Core Version:    0.7.0.1
 */