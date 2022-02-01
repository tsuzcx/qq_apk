package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRedDotManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;)V", "careExptKey", "", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "ctrlInfoAtPathFilterList", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "", "disposeRedDotAtPathIgnoreList", "enterSource", "", "enterTabTipsExtInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$EnterTabTipsExtInfo;", "enterTime", "", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1;", "finderRedDotTrigger", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTrigger;", "getFinderRedDotTrigger", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTrigger;", "hasRedDotWhenEnter", "msgRedDotHandler", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "getMsgRedDotHandler", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "newTipsTransform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "noFoundRevokeIdSet", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTipsInfo;", "pathToCtrInfoMap", "", "revokeIdToCtrInfoMap", "stateCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stayDuration", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "getTransform", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "addNewRedDotCtrlInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "changePathSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "isClearOldSameType", "clearedEntrancePair", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "extraWork", "", "buildPathWithCtrInfo", "local", "checkInsertLiveTaskRedDot", "checkRedDotOverride", "path", "ctrlInfo", "lastCtrlInfo", "lastShowInfo", "clearCtrlInfo", "ctrInfo", "type", "filter", "Lkotlin/ParameterName;", "name", "clearEnterTabTipsExtInfo", "enterCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "containsTabTipsExtInfo", "tabType", "convertEnterActionToTabType", "enterAction", "ctrlInfoAtPath", "disposeRedDotAtPath", "call", "ctrlType", "", "enterFinder", "exitFinder", "exitFinderBefore", "filterNotifyTabTip", "tabTip", "Lcom/tencent/mm/protocal/protobuf/FinderTabTipsInfo;", "findByRevokeId", "revokeId", "findExtInfoAtCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "generateFullScreenRedDot", "getAliveTabType", "getAllCtrlInfo", "", "getCtrlInfoByPath", "getCtrlInfoMap", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "getDiffExitTimeMs", "getEnterAction", "getEnterTabTipsExtInfo", "getEnterTabTypeInCtrlInfo", "getFinderLiveDiffExitTimeMs", "getLastCtrlInfo", "ctrlInfoMap", "getLatestCtrlInfo", "ctrlInfo1", "ctrlInfo2", "getNearbyDiffExitTimeMs", "getTabPathByTabType", "getTabTipsExtInfo", "getTabTypeByPath", "getTipsShowInfoAtPath", "increaseRedDotExpose", "insertDataForTest", "count", "isContainsPath", "isEnableShowEntranceRedDot", "isEnableShowFinderLiveEntranceRedDot", "isEnableShowNearByEntranceRedDot", "isEnableShowNearbyV3EntryRedDot", "mergeFinderMentionCtrlInfo", "notifyFinderFansAddCount", "notifyFinderLiveFirstReward", "notifyFinderMsgCount", "likeCount", "commentCount", "followCount", "notifyRedDot", "redDot", "Lcom/tencent/mm/protocal/protobuf/FinderRedDot;", "notifyTabTip", "tabTips", "Lcom/tencent/mm/protocal/protobuf/FinderTabTips;", "notifyWxMentionCount", "wxMention", "Lcom/tencent/mm/protocal/protobuf/FinderWxMentionCount;", "onExptChange", "key", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "printCtrInfo", "printTipsShowInfo", "index", "reBuildPathWithCtrInfo", "recordCtrlInfo", "clearedCtrlInfo", "removeFinderEntrance", "reportOverride", "beforePair", "resetNotifyAllPathWithCrlInfo", "revokePathRedDot", "revoke", "Lcom/tencent/mm/protocal/protobuf/FinderRevokePathRedDot;", "revokeTabTips", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTips;", "saveEnterTabTipsExtInfo", "setEnableShowEntranceRedDot", "isEnable", "setEnableShowFinderLiveEntranceRedDot", "setEnableShowNearByEntranceRedDot", "setEnableShowNearbyV3EntryRedDot", "updateFindMoreFriendUI", "updateFinderEntryCount", "Companion", "EnterTabTipsExtInfo", "FinderTipsShowTabExt", "plugin-finder_release"})
public final class f
  implements i, z
{
  private static boolean xtc;
  public static final a xtd;
  public long enterTime;
  public final j xsL;
  public final a xsM;
  private final b xsN;
  private final com.tencent.mm.plugin.finder.viewmodel.b xsO;
  private final k xsP;
  private final List<com.tencent.mm.plugin.expt.b.b.a> xsQ;
  private final r xsR;
  public long xsS;
  public int xsT;
  public boolean xsU;
  public final ConcurrentHashMap<String, List<l>> xsV;
  private final ConcurrentHashMap<String, l> xsW;
  private final List<kotlin.g.a.b<l, Boolean>> xsX;
  private final List<o<kotlin.g.a.b<l, Boolean>, kotlin.g.a.b<l, Boolean>>> xsY;
  private final ConcurrentHashMap<String, b> xsZ;
  private final ConcurrentHashMap<String, bih> xta;
  public final c xtb;
  
  static
  {
    AppMethodBeat.i(178166);
    xtd = new a((byte)0);
    AppMethodBeat.o(178166);
  }
  
  public f(c paramc)
  {
    AppMethodBeat.i(178184);
    this.xtb = paramc;
    this.xsL = new j(this);
    this.xsM = new a(this);
    this.xsN = new b(this);
    paramc = com.tencent.mm.ui.component.g.Xox;
    paramc = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    p.j(paramc, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.xsO = ((com.tencent.mm.plugin.finder.viewmodel.b)paramc);
    this.xsP = new k();
    this.xsQ = kotlin.a.j.listOf(com.tencent.mm.plugin.expt.b.b.a.vLM);
    this.xsR = new r(this);
    this.xsV = new ConcurrentHashMap();
    this.xsW = new ConcurrentHashMap();
    this.xsX = kotlin.a.j.listOf(new kotlin.g.a.b[] { (kotlin.g.a.b)p.xtv, (kotlin.g.a.b)q.xtw });
    this.xsY = kotlin.a.j.listOf(new o[] { new o(k.xtq, l.xtr), new o(m.xts, n.xtt) });
    this.xsZ = new ConcurrentHashMap();
    this.xta = new ConcurrentHashMap();
    AppMethodBeat.o(178184);
  }
  
  public static String Mo(int paramInt)
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
  
  public static int a(l paraml)
  {
    AppMethodBeat.i(284402);
    p.k(paraml, "ctrlInfo");
    if ((paraml.aBy("TLWxPrivateMsgBubble") != null) || (paraml.aBy("TLWxBubble") != null))
    {
      AppMethodBeat.o(284402);
      return 1;
    }
    if (paraml.aBy("TLFollow") != null)
    {
      i = aBg("TLFollow");
      AppMethodBeat.o(284402);
      return i;
    }
    if (paraml.aBy("TLRecommendTab") != null)
    {
      i = aBg("TLRecommendTab");
      AppMethodBeat.o(284402);
      return i;
    }
    if (paraml.aBy("finder_tl_hot_tab") != null)
    {
      i = aBg("finder_tl_hot_tab");
      AppMethodBeat.o(284402);
      return i;
    }
    if (paraml.aBy("finder_tl_nearby_tab") != null)
    {
      i = aBg("finder_tl_nearby_tab");
      AppMethodBeat.o(284402);
      return i;
    }
    if (paraml.aBy("NearbyFeedTab") != null)
    {
      i = aBg("NearbyFeedTab");
      AppMethodBeat.o(284402);
      return i;
    }
    if (paraml.aBy("NearbyLiveTab") != null)
    {
      i = aBg("NearbyLiveTab");
      AppMethodBeat.o(284402);
      return i;
    }
    if (paraml.aBy("NearbyPeopleTab") != null)
    {
      i = aBg("NearbyPeopleTab");
      AppMethodBeat.o(284402);
      return i;
    }
    int i = paraml.xuM.tab_type;
    if (i != 0)
    {
      AppMethodBeat.o(284402);
      return i;
    }
    AppMethodBeat.o(284402);
    return -1;
  }
  
  private l a(bhw parambhw, String paramString, HashSet<String> paramHashSet, boolean paramBoolean, o<l, ? extends bkn> paramo, kotlin.g.a.b<? super l, kotlin.x> paramb)
  {
    AppMethodBeat.i(284380);
    p.k(paramString, "source");
    p.k(paramHashSet, "changePathSet");
    if (parambhw == null)
    {
      AppMethodBeat.o(284380);
      return null;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    if (paramo != null)
    {
      localObject1 = (l)paramo.Mx;
      localObject3 = null;
      localObject2 = localObject3;
      if (parambhw != null)
      {
        localObject2 = parambhw.MFx;
        p.j(localObject2, "show_infos");
        localObject4 = ((Iterable)localObject2).iterator();
        do
        {
          localObject2 = localObject3;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
        } while (!p.h("FinderEntrance", ((bkn)((Iterator)localObject4).next()).path));
        localObject3 = aBf("FinderEntrance");
        if (!p.h(localObject3, localObject1)) {
          break label345;
        }
        localObject2 = localObject3;
      }
      label143:
      if (paramo == null) {
        break label433;
      }
      localObject1 = (l)paramo.Mx;
      label158:
      if (!p.h(localObject2, localObject1)) {
        break label445;
      }
      if (paramo == null) {
        break label439;
      }
      paramo = (bkn)paramo.My;
    }
    for (;;)
    {
      if (paramBoolean) {
        Mp(parambhw.type);
      }
      if (!dqI())
      {
        localObject1 = parambhw.MFx;
        p.j(localObject1, "info.show_infos");
        com.tencent.mm.ae.d.a((LinkedList)localObject1, (kotlin.g.a.b)d.xti);
        Log.i("Finder.RedDotManager", "[addNewRedDotCtrlInfo] remove DISCOVERY_TAB");
      }
      localObject4 = new l().e(parambhw);
      ConcurrentHashMap localConcurrentHashMap = this.xta;
      localObject3 = ((l)localObject4).field_revokeId;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      if (!localConcurrentHashMap.contains(localObject1)) {
        break label469;
      }
      Log.e("Finder.RedDotManager", "[addNewRedDotCtrlInfo] has revoke. " + ((l)localObject4).field_revokeId + ' ' + c(((l)localObject4).field_ctrInfo));
      AppMethodBeat.o(284380);
      return null;
      localObject1 = null;
      break;
      label345:
      localObject2 = localObject3;
      if (localObject1 == null) {
        break label143;
      }
      if (localObject3 != null)
      {
        if (((l)localObject3).field_ctrInfo.priority >= ((l)localObject1).field_ctrInfo.priority)
        {
          localObject2 = localObject3;
          if (((l)localObject3).field_ctrInfo.priority != ((l)localObject3).field_ctrInfo.priority) {
            break label143;
          }
          localObject2 = localObject3;
          if (((l)localObject3).field_time >= ((l)localObject1).field_time) {
            break label143;
          }
        }
        localObject2 = localObject1;
        break label143;
      }
      localObject2 = localObject1;
      break label143;
      label433:
      localObject1 = null;
      break label158;
      label439:
      paramo = null;
      continue;
      label445:
      if (localObject2 != null) {
        paramo = ((l)localObject2).aBy("FinderEntrance");
      } else {
        paramo = null;
      }
    }
    label469:
    if (paramb != null) {
      paramb.invoke(localObject4);
    }
    if (l.a((l)localObject4, this.xtb))
    {
      paramHashSet.addAll((Collection)a((l)localObject4, paramString));
      paramHashSet = new o(localObject2, paramo);
      paramString = aBj("FinderEntrance");
      if (paramString != null)
      {
        paramString = (l)paramString.Mx;
        paramo = (l)paramHashSet.Mx;
        paramb = (bkn)paramHashSet.My;
        if (!Util.isNullOrNil("FinderEntrance")) {
          break label796;
        }
        Log.e("Finder.RedDotManager", "path: " + "FinderEntrance" + " is empty!");
        label601:
        paramString = n.xuW;
        p.k(parambhw, "ctrlInfo");
        Log.i("Finder.ThreeDayTwoDay", "checkRedDotFilter");
        if (!paramString.dsi()) {
          break label983;
        }
        parambhw = com.tencent.mm.kernel.h.aHG();
        p.j(parambhw, "MMKernel.storage()");
        long l1 = parambhw.aHp().a(ar.a.VBz, 0L);
        if (l1 == 0L) {
          break label983;
        }
        long l2 = cm.bfE() - l1;
        parambhw = com.tencent.mm.plugin.finder.storage.d.AjH;
        i = ((Number)com.tencent.mm.plugin.finder.storage.d.dVR().aSr()).intValue();
        if (i < l2) {
          break label971;
        }
        paramBoolean = true;
        label697:
        Log.i("Finder.ThreeDayTwoDay", "[checkInLimitTwoDay] isInLimit=" + paramBoolean + " twoDayThreshold=" + i + " diffTime=" + l2 + " hitThreeDayTime=" + l1);
        if (!paramBoolean) {
          break label977;
        }
      }
      label796:
      label966:
      label971:
      label977:
      label983:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          parambhw = n.wVw;
          if (parambhw != null) {
            parambhw.aBd("FinderEntrance");
          }
        }
        AppMethodBeat.o(284380);
        return localObject4;
        paramString = null;
        break;
        if ((paramo == null) || (!(p.h(paramo, paramString) ^ true))) {
          break label601;
        }
        localObject1 = new StringBuilder("20951, ").append(paramo.field_ctrInfo.type).append(" show_type:");
        if (paramb != null)
        {
          paramHashSet = Integer.valueOf(paramb.CKC);
          label855:
          localObject1 = ((StringBuilder)localObject1).append(paramHashSet).append(" field_tipsId: ").append(paramo.field_tipsId).append(" ctrlInfo.field_tipsId: ");
          if (paramString == null) {
            break label966;
          }
        }
        for (paramHashSet = paramString.field_tipsId;; paramHashSet = null)
        {
          Log.i("Finder.RedDotManager", paramHashSet);
          paramHashSet = aj.AGc;
          if ((paramo == null) || (paramb == null)) {
            break;
          }
          paramHashSet = com.tencent.mm.plugin.finder.report.l.zWx;
          if (paramString != null)
          {
            paramHashSet = paramString.field_tipsId;
            paramString = paramHashSet;
            if (paramHashSet != null) {}
          }
          else
          {
            paramString = "";
          }
          com.tencent.mm.plugin.finder.report.l.a(paramo, paramb, 6, 0, null, paramString, 24);
          break;
          paramHashSet = null;
          break label855;
        }
        paramBoolean = false;
        break label697;
        n.reset(cm.bfE());
      }
    }
    AppMethodBeat.o(284380);
    return null;
  }
  
  private static String a(bkn parambkn, int paramInt)
  {
    AppMethodBeat.i(178181);
    if (parambkn == null)
    {
      AppMethodBeat.o(178181);
      return "[empty]";
    }
    Object localObject1 = null;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject2 = new bko();
      com.tencent.mm.cd.b localb = parambkn.SVu;
      localObject1 = localObject2;
      if (localb != null)
      {
        ((bko)localObject2).parseFrom(localb.toByteArray());
        localObject1 = localObject2;
      }
    }
    Object localObject2 = new StringBuilder("#").append(paramInt).append("{showType=").append(parambkn.CKC).append(" count=").append(parambkn.count).append(" title=").append(parambkn.title).append(' ').append("clearType=").append(parambkn.SVs).append(" iconUrl=").append(parambkn.ufC).append(" path=").append(parambkn.path).append(" show_ext_info_type=").append(parambkn.SVt).append(" parent=").append(parambkn.HpB).append(' ');
    if (localObject1 != null) {}
    for (localObject1 = "jumpPriority=" + ((bko)localObject1).SVB;; localObject1 = "")
    {
      parambkn = (String)localObject1 + " ignore_freq_limit=" + parambkn.SVy + "} ";
      AppMethodBeat.o(178181);
      return parambkn;
    }
  }
  
  private final void a(bhw parambhw)
  {
    AppMethodBeat.i(284374);
    Log.i("Finder.RedDotManager", "mergeFinderMentionCtrlInfo enter:" + parambhw.type);
    l locall = k(a(this));
    Object localObject2 = new StringBuilder("mergeFinderMentionCtrlInfo :");
    if (locall != null)
    {
      ??? = Integer.valueOf(locall.field_ctrInfo.type);
      Log.i("Finder.RedDotManager", ???);
      if (locall != null)
      {
        ??? = locall.xuK.keySet();
        p.j(???, "showInfoMap.keys");
      }
    }
    else
    {
      for (;;)
      {
        synchronized ((Iterable)???)
        {
          localObject2 = ((Iterable)???).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label285;
          }
          Object localObject3 = (String)((Iterator)localObject2).next();
          Object localObject4 = parambhw.MFx;
          p.j(localObject4, "ctrlInfo.show_infos");
          localObject4 = (Iterable)localObject4;
          if (((localObject4 instanceof Collection)) && (((Collection)localObject4).isEmpty())) {
            break label280;
          }
          localObject4 = ((Iterable)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label280;
          }
          if (!p.h(((bkn)((Iterator)localObject4).next()).path, localObject3)) {
            continue;
          }
          i = 0;
          if (i == 0) {
            continue;
          }
          localObject3 = (bkn)locall.xuK.get(localObject3);
          if (localObject3 == null) {
            continue;
          }
          parambhw.MFx.add(localObject3);
        }
        ??? = null;
        break;
        label280:
        int i = 1;
      }
      label285:
      parambhw = kotlin.x.aazN;
      AppMethodBeat.o(284374);
      return;
    }
    AppMethodBeat.o(284374);
  }
  
  private final boolean a(bkg parambkg)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Iterator localIterator = null;
    int i = -1;
    AppMethodBeat.i(284396);
    Object localObject1 = parambkg.SVk;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((bhw)localObject1).type);
      if (localObject1 != null) {
        break label82;
      }
      label43:
      if (localObject1 != null) {
        break label359;
      }
      if (localObject1 != null) {
        break label372;
      }
      label53:
      if (localObject1 != null) {
        break label385;
      }
      label58:
      if (localObject1 != null) {
        break label398;
      }
      label63:
      if (localObject1 != null) {
        break label411;
      }
    }
    label68:
    label82:
    label92:
    int j;
    int k;
    boolean bool;
    label359:
    label372:
    label633:
    do
    {
      AppMethodBeat.o(284396);
      return true;
      localObject1 = null;
      break;
      if (((Integer)localObject1).intValue() != 8) {
        break label43;
      }
      if (xtc)
      {
        localObject6 = parambkg.SVk;
        if (localObject6 != null)
        {
          localObject6 = ((bhw)localObject6).MFx;
          if (localObject6 != null) {
            kotlin.a.j.c((List)localObject6, (kotlin.g.a.b)s.xtx);
          }
        }
        xtc = false;
      }
      Object localObject6 = parambkg.SVk;
      if ((localObject6 != null) && (((bhw)localObject6).SSm > 0))
      {
        j = this.xsO.Bgq;
        k = this.xsO.Bgp;
        bool = this.xsO.OO(((bhw)localObject6).SSm);
        Log.i("Finder.RedDotManager", "[filterNotifyTabTip] currentTabType=" + k + " lastTabType=" + j + "  ignore_tab_type=" + ((bhw)localObject6).SSm + " isAutoRefresh=" + bool);
        if ((((bhw)localObject6).SSn) && (((k <= 0) && (((bhw)localObject6).SSm == j) && (!bool)) || (k == ((bhw)localObject6).SSm)))
        {
          localObject1 = new StringBuilder("[filterNotifyTabTip] remove this ctrlInfo type=");
          parambkg = parambkg.SVk;
          if (parambkg != null) {}
          for (parambkg = Integer.valueOf(parambkg.type);; parambkg = null)
          {
            Log.i("Finder.RedDotManager", parambkg + " currentTabType=" + k + " lastTabType=" + j);
            AppMethodBeat.o(284396);
            return false;
            if (((Integer)localObject1).intValue() == 7) {
              break label92;
            }
            break;
            if (((Integer)localObject1).intValue() == 17) {
              break label92;
            }
            break label53;
            if (((Integer)localObject1).intValue() == 9) {
              break label92;
            }
            break label58;
            if (((Integer)localObject1).intValue() == 13) {
              break label92;
            }
            break label63;
            if (((Integer)localObject1).intValue() != 16) {
              break label68;
            }
            break label92;
          }
        }
      }
      localObject6 = parambkg.SVk;
      if (localObject6 != null)
      {
        localObject6 = ((bhw)localObject6).MFx;
        if (localObject6 != null)
        {
          localObject6 = ((List)localObject6).iterator();
          j = 0;
          if (((Iterator)localObject6).hasNext())
          {
            bkn localbkn = (bkn)((Iterator)localObject6).next();
            Log.i("Finder.RedDotManager", "[filterNotifyTabTip] path:" + localbkn.path);
            if ((p.h(localbkn.path, "FinderEntrance")) || (p.h(localbkn.path, "NearbyEntrance")) || (p.h(localbkn.path, "FinderLiveEntrance")))
            {
              k = 1;
              if (k == 0) {
                break label633;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (j < 0) {
          break label650;
        }
        localObject1 = new StringBuilder("[filterNotifyTabTip] has FINDER_ENTRANCE or NEARBY_ENTRANCE or FINDER_LIVE_ENTRANCE type=");
        localObject4 = parambkg.SVk;
        parambkg = localIterator;
        if (localObject4 != null) {
          parambkg = Integer.valueOf(((bhw)localObject4).type);
        }
        Log.i("Finder.RedDotManager", parambkg);
        AppMethodBeat.o(284396);
        return true;
        k = 0;
        break label560;
        j += 1;
        break;
        j = -1;
        continue;
        j = -1;
      }
      if (localObject1 != null) {
        break label880;
      }
      if (localObject1 != null) {
        break label1033;
      }
      if (localObject1 != null) {
        break label1095;
      }
      if (localObject1 != null) {
        break label1286;
      }
      if (localObject1 != null) {
        break label1299;
      }
    } while ((localObject1 == null) || (((Integer)localObject1).intValue() != 16));
    label385:
    label398:
    label411:
    label560:
    localObject5 = this.xsV;
    label650:
    label665:
    label675:
    localObject1 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      localObject1 = "FinderLiveEntrance";
      label712:
      localObject1 = (List)((ConcurrentHashMap)localObject5).get(localObject1);
      k = i;
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          localObject5 = ((List)localObject1).iterator();
          j = 0;
          k = i;
          if (((Iterator)localObject5).hasNext())
          {
            k = ((l)((Iterator)localObject5).next()).field_ctrInfo.type;
            if (k != 16) {
              break label1383;
            }
            k = 1;
            if (k == 0) {
              break label1389;
            }
            k = j;
          }
          if (k < 0) {
            break label1408;
          }
          bool = true;
          localObject1 = new StringBuilder("[filterNotifyTabTip] ignore[").append(bool).append("] this tabTip type=");
          localObject5 = parambkg.SVk;
          parambkg = (bkg)localObject4;
          if (localObject5 != null) {
            parambkg = Integer.valueOf(((bhw)localObject5).type);
          }
          Log.i("Finder.RedDotManager", parambkg);
          if (bool) {
            break label1414;
          }
          AppMethodBeat.o(284396);
          return true;
          label880:
          if (((Integer)localObject1).intValue() != 8) {
            break;
          }
          label890:
          parambkg = (List)this.xsV.get("FinderEntrance");
          if (parambkg != null) {}
          for (;;)
          {
            try
            {
              localObject4 = parambkg.iterator();
              i = 0;
              if (((Iterator)localObject4).hasNext())
              {
                localObject5 = (l)((Iterator)localObject4).next();
                if (((l)localObject5).field_ctrInfo.type != 8)
                {
                  j = ((l)localObject5).field_ctrInfo.type;
                  if (j != 9) {}
                }
                else
                {
                  j = 1;
                  if (j == 0) {
                    continue;
                  }
                  if (i < 0) {
                    break label1081;
                  }
                  bool = true;
                  Log.i("Finder.RedDotManager", "[filterNotifyTabTip] ignore[" + bool + "] this tabTip type=" + localObject1);
                  if (bool) {
                    break label1087;
                  }
                  AppMethodBeat.o(284396);
                  return true;
                  label1033:
                  if (((Integer)localObject1).intValue() != 9) {
                    break;
                  }
                  break label890;
                }
                j = 0;
                continue;
                i += 1;
                continue;
              }
              i = -1;
              continue;
              i = -1;
            }
            finally {}
            continue;
            label1081:
            bool = false;
          }
          label1087:
          AppMethodBeat.o(284396);
          return false;
          label1095:
          if (localObject2.intValue() != 7) {
            break label665;
          }
          label1105:
          localObject4 = (List)this.xsV.get("FinderEntrance");
          k = i;
          if (localObject4 != null) {}
          try
          {
            localIterator = ((List)localObject4).iterator();
            j = 0;
            for (;;)
            {
              k = i;
              if (localIterator.hasNext())
              {
                k = ((l)localIterator.next()).field_ctrInfo.type;
                if (k == 7) {
                  break label1422;
                }
                if (localObject2 != null) {
                  break label1312;
                }
                label1185:
                if (localObject2 != null) {
                  break label1325;
                }
              }
              label1286:
              label1299:
              label1312:
              label1325:
              do
              {
                k = 0;
                if (k == 0) {
                  break label1342;
                }
                k = j;
                if (k < 0) {
                  break label1361;
                }
                bool = true;
                localObject3 = new StringBuilder("[filterNotifyTabTip] ignore[").append(bool).append("] this tabTip type=");
                localObject4 = parambkg.SVk;
                parambkg = (bkg)localObject5;
                if (localObject4 != null) {
                  parambkg = Integer.valueOf(((bhw)localObject4).type);
                }
                Log.i("Finder.RedDotManager", parambkg);
                if (bool) {
                  break label1367;
                }
                AppMethodBeat.o(284396);
                return true;
                if (((Integer)localObject3).intValue() == 13) {
                  break label1105;
                }
                break;
                if (((Integer)localObject3).intValue() != 17) {
                  break label675;
                }
                break label1105;
                if (((Integer)localObject3).intValue() != 13) {
                  break label1185;
                }
                break label1422;
                k = ((Integer)localObject3).intValue();
              } while (k != 17);
              break label1422;
              label1342:
              j += 1;
            }
            bool = false;
          }
          finally {}
        }
        label1361:
        continue;
        label1367:
        AppMethodBeat.o(284396);
        return false;
        Object localObject3 = "NearbyEntrance";
        break label712;
        label1383:
        k = 0;
        continue;
        label1389:
        j += 1;
        continue;
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(284396);
      }
      label1408:
      continue;
      label1414:
      AppMethodBeat.o(284396);
      return false;
      label1422:
      k = 1;
    }
  }
  
  private static int aBg(String paramString)
  {
    AppMethodBeat.i(284388);
    p.k(paramString, "path");
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
                  AppMethodBeat.o(284388);
                  return -1;
                } while (!paramString.equals("NearbyFeedTab"));
                AppMethodBeat.o(284388);
                return 1002;
              } while (!paramString.equals("TLFollow"));
              AppMethodBeat.o(284388);
              return 3;
            } while (!paramString.equals("NearbyLiveTab"));
            AppMethodBeat.o(284388);
            return 1001;
          } while (!paramString.equals("finder_tl_hot_tab"));
          AppMethodBeat.o(284388);
          return 4;
        } while (!paramString.equals("NearbyPeopleTab"));
        AppMethodBeat.o(284388);
        return 1003;
      } while (!paramString.equals("finder_tl_nearby_tab"));
      AppMethodBeat.o(284388);
      return 2;
    } while (!paramString.equals("TLRecommendTab"));
    AppMethodBeat.o(284388);
    return 1;
  }
  
  private final o<l, bkn> aBj(String paramString)
  {
    AppMethodBeat.i(284422);
    paramString = aBf(paramString);
    if (paramString != null)
    {
      paramString = new o(paramString, paramString.aBy("FinderEntrance"));
      AppMethodBeat.o(284422);
      return paramString;
    }
    AppMethodBeat.o(284422);
    return null;
  }
  
  private final o<l, bkn> b(bhw parambhw)
  {
    AppMethodBeat.i(284386);
    parambhw = parambhw.MFx;
    if (parambhw != null)
    {
      parambhw = ((Iterable)parambhw).iterator();
      while (parambhw.hasNext()) {
        if (p.h(((bkn)parambhw.next()).path, "FinderEntrance"))
        {
          parambhw = aBj("FinderEntrance");
          AppMethodBeat.o(284386);
          return parambhw;
        }
      }
    }
    AppMethodBeat.o(284386);
    return null;
  }
  
  public static String c(bhw parambhw)
  {
    AppMethodBeat.i(178180);
    if (parambhw == null)
    {
      AppMethodBeat.o(178180);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = parambhw.MFx;
    p.j(localObject1, "info.show_infos");
    localObject1 = (Iterable)localObject1;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localStringBuilder.append(a((bkn)localObject2, i));
      i += 1;
    }
    parambhw = "CtrlInfo{tipsId=" + parambhw.SQm + " priority=" + parambhw.priority + " type=" + parambhw.type + " starttime=" + parambhw.SRZ + " expired=" + parambhw.tnN + " tipsShowInfo=" + localStringBuilder + '}';
    AppMethodBeat.o(178180);
    return parambhw;
  }
  
  private final HashMap<String, LinkedList<l>> c(int paramInt, kotlin.g.a.b<? super l, Boolean> paramb)
  {
    AppMethodBeat.i(284392);
    Log.i("Finder.RedDotManager", "getCtrlInfoMap type:".concat(String.valueOf(paramInt)));
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = ((Map)this.xsV).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (Map.Entry)localIterator1.next();
      String str = (String)((Map.Entry)localObject).getKey();
      synchronized ((Iterable)((Map.Entry)localObject).getValue())
      {
        Iterator localIterator2 = ???.iterator();
        while (localIterator2.hasNext())
        {
          l locall = (l)localIterator2.next();
          if (((locall.field_ctrInfo.type == paramInt) || (paramInt == -2147483648)) && (((Boolean)paramb.invoke(locall)).booleanValue()))
          {
            LinkedList localLinkedList = (LinkedList)localHashMap.get(str);
            localObject = localLinkedList;
            if (localLinkedList == null)
            {
              localObject = new LinkedList();
              ((Map)localHashMap).put(str, localObject);
            }
            p.j(localObject, "ctrlInfoMap[path] ?: run…ist\n                    }");
            ((LinkedList)localObject).add(locall);
          }
        }
      }
      localObject = kotlin.x.aazN;
    }
    AppMethodBeat.o(284392);
    return localHashMap;
  }
  
  private static boolean c(bhw parambhw, String paramString)
  {
    AppMethodBeat.i(284424);
    if (parambhw != null)
    {
      parambhw = parambhw.MFx;
      if (parambhw != null)
      {
        Iterator localIterator = ((Iterable)parambhw).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          parambhw = localIterator.next();
        } while (!p.h(((bkn)parambhw).path, paramString));
      }
    }
    for (parambhw = (bkn)parambhw;; parambhw = null)
    {
      if (parambhw == null) {
        break label86;
      }
      AppMethodBeat.o(284424);
      return true;
      parambhw = null;
      break;
    }
    label86:
    AppMethodBeat.o(284424);
    return false;
  }
  
  public static void d(bhw parambhw)
  {
    AppMethodBeat.i(284420);
    Object localObject1;
    Object localObject2;
    if (parambhw != null)
    {
      localObject1 = parambhw.MFx;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (p.h(((bkn)localObject1).path, "FinderEntrance"))
          {
            localObject1 = (bkn)localObject1;
            label66:
            if (parambhw == null) {
              break label148;
            }
            localObject2 = parambhw.MFx;
            if (localObject2 == null) {
              break label148;
            }
          }
        }
      }
    }
    label148:
    for (boolean bool = com.tencent.mm.ae.d.a((LinkedList)localObject2, (kotlin.g.a.b)ab.xtF);; bool = false)
    {
      if (bool)
      {
        localObject2 = aj.AGc;
        if ((parambhw != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
          com.tencent.mm.plugin.finder.report.l.a(new l().e(parambhw), (bkn)localObject1, 5, 2, null, null, 48);
        }
      }
      AppMethodBeat.o(284420);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label66;
    }
  }
  
  private static long dqD()
  {
    AppMethodBeat.i(284375);
    long l1 = cm.bfE();
    m localm = m.xuU;
    long l2 = m.drZ();
    AppMethodBeat.o(284375);
    return l1 - l2;
  }
  
  private static long dqE()
  {
    AppMethodBeat.i(284376);
    long l1 = cm.bfE();
    m localm = m.xuU;
    long l2 = m.dsa();
    AppMethodBeat.o(284376);
    return l1 - l2;
  }
  
  private static long dqF()
  {
    AppMethodBeat.i(284377);
    long l1 = cm.bfE();
    m localm = m.xuU;
    long l2 = m.dsb();
    AppMethodBeat.o(284377);
    return l1 - l2;
  }
  
  public static void dqL()
  {
    int i = 0;
    AppMethodBeat.i(284423);
    Object localObject = aj.AGc;
    if (!aj.edY())
    {
      Log.i("Finder.RedDotManager", "[checkInsertLiveTaskRedDot] hasFinderAccount = false");
      AppMethodBeat.o(284423);
      return;
    }
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.Vyi, 0) == 1) {
      i = 1;
    }
    if (i != 0)
    {
      Log.i("Finder.RedDotManager", "[checkInsertLiveTaskRedDot] hasShow = true");
      AppMethodBeat.o(284423);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    if (!d.a.aAQ("Entrance_PrimarySetting"))
    {
      Log.i("Finder.RedDotManager", "[checkInsertLiveTaskRedDot] getLiveTaskEnable = false");
      AppMethodBeat.o(284423);
      return;
    }
    localObject = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager();
    bhw localbhw = new bhw();
    localbhw.SQm = String.valueOf(cm.bfE());
    localbhw.priority = 50000;
    localbhw.type = 1019;
    bkn localbkn = new bkn();
    localbkn.CKC = 1;
    localbkn.SVs = 1;
    localbkn.path = "TLPersonalCenter";
    localbhw.MFx.add(localbkn);
    localbkn = new bkn();
    localbkn.CKC = 1;
    localbkn.SVs = 1;
    localbkn.path = "FinderPosterEntrance";
    localbhw.MFx.add(localbkn);
    localbkn = new bkn();
    localbkn.CKC = 1;
    localbkn.SVs = 1;
    localbkn.path = "FinderSettingLiveTask";
    localbhw.MFx.add(localbkn);
    a((f)localObject, localbhw, "checkInsertLiveTaskRedDot", null, true, null, null, 52);
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vyi, Integer.valueOf(1));
    Log.i("Finder.RedDotManager", "checkInsertLiveTaskRedDot");
    AppMethodBeat.o(284423);
  }
  
  private void i(String paramString, kotlin.g.a.b<? super l, Boolean> paramb)
  {
    bkn localbkn2 = null;
    AppMethodBeat.i(284384);
    p.k(paramString, "path");
    p.k(paramb, "call");
    Object localObject2 = new HashSet();
    l locall1 = aBf(paramString);
    bkn localbkn1;
    List localList;
    Object localObject1;
    if (locall1 != null)
    {
      localbkn1 = locall1.aBy(paramString);
      localList = (List)this.xsV.get(paramString);
      if (localList != null) {
        p.j(localList, "this");
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          Iterator localIterator1 = localList.iterator();
          if (!localIterator1.hasNext()) {
            break label264;
          }
          l locall2 = (l)localIterator1.next();
          Iterator localIterator2 = ((Iterable)this.xsX).iterator();
          if (!localIterator2.hasNext()) {
            break label258;
          }
          localObject1 = localIterator2.next();
          if (!((Boolean)((kotlin.g.a.b)localObject1).invoke(locall2)).booleanValue()) {
            continue;
          }
          if (((kotlin.g.a.b)localObject1 != null) || (!((Boolean)paramb.invoke(locall2)).booleanValue())) {
            continue;
          }
          localObject1 = locall2.aBz(paramString);
          if (l.a(locall2, this.xtb)) {
            ((HashSet)localObject2).addAll((Collection)localObject1);
          }
          if (!locall2.drI()) {
            continue;
          }
          localIterator1.remove();
          continue;
          localbkn1 = null;
        }
        finally
        {
          AppMethodBeat.o(284384);
        }
        break;
        label258:
        localObject1 = null;
      }
      label264:
      paramb = kotlin.x.aazN;
    }
    paramb = new StringBuilder("[disposeRedDotAtPath] path=").append(paramString).append(" tipsId=");
    paramString = localbkn2;
    if (locall1 != null) {
      paramString = locall1.field_tipsId;
    }
    Log.i("Finder.RedDotManager", paramString + " removePathSet=" + localObject2 + " maybeRemoveShowInfo=" + a(localbkn1, 0));
    paramString = ((Iterable)localObject2).iterator();
    while (paramString.hasNext())
    {
      paramb = (String)paramString.next();
      localObject1 = aBf(paramb);
      if (localObject1 != null)
      {
        localbkn2 = ((l)localObject1).aBy(paramb);
        if (localbkn2 != null) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label443;
          }
          localObject2 = h.xup;
          h.a(false, paramb, localbkn1, locall1);
          localObject2 = h.xup;
          h.a(true, paramb, localbkn2, (l)localObject1);
          break;
        }
        label443:
        localObject1 = h.xup;
        h.a(false, paramb, localbkn1, locall1);
      }
      else
      {
        localObject1 = h.xup;
        h.a(false, paramb, localbkn1, locall1);
      }
    }
    AppMethodBeat.o(284384);
  }
  
  private List<l> j(String paramString, kotlin.g.a.b<? super l, Boolean> paramb)
  {
    AppMethodBeat.i(284394);
    p.k(paramString, "path");
    p.k(paramb, "filter");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Map)this.xsV).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      synchronized (((Map.Entry)localObject2).getValue())
      {
        localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l locall = (l)((Iterator)localObject2).next();
          if ((((Boolean)paramb.invoke(locall)).booleanValue()) && (locall.aBy(paramString) != null)) {
            localHashSet.add(locall);
          }
        }
      }
      localObject2 = kotlin.x.aazN;
    }
    paramString = kotlin.a.j.p((Iterable)localHashSet);
    AppMethodBeat.o(284394);
    return paramString;
  }
  
  private static l k(HashMap<String, LinkedList<l>> paramHashMap)
  {
    AppMethodBeat.i(284382);
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
          paramHashMap = (l)paramHashMap;
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
    AppMethodBeat.o(284382);
    return paramHashMap;
  }
  
  public final void Mn(int paramInt)
  {
    AppMethodBeat.i(178170);
    Object localObject = aBf("FinderEntrance");
    if ((localObject != null) && (((l)localObject).aBy("FinderEntrance") != null))
    {
      this.xsU = true;
      b((l)localObject);
    }
    for (;;)
    {
      this.xsT = paramInt;
      this.enterTime = cm.bfE();
      aBd("FinderEntrance");
      aBd("Discovery");
      localObject = n.xuW;
      Log.i("Finder.ThreeDayTwoDay", "enterFinder");
      n.dsk();
      this.xsL.drz();
      Log.i("Finder.RedDotManager", "[enterFinder] hasRedDotWhenEnter=" + this.xsU);
      AppMethodBeat.o(178170);
      return;
      this.xsU = false;
    }
  }
  
  public final void Mp(int paramInt)
  {
    AppMethodBeat.i(284390);
    b(paramInt, (kotlin.g.a.b)i.xtp);
    AppMethodBeat.o(284390);
  }
  
  public final boolean Mq(int paramInt)
  {
    AppMethodBeat.i(284400);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = Mr(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("[containsTabTipsExtInfo] tabType=").append(paramInt).append(" isContains=");
    if (localFinderTipsShowEntranceExtInfo.tab_type != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.RedDotManager", bool);
      if (localFinderTipsShowEntranceExtInfo.tab_type == 0) {
        break;
      }
      AppMethodBeat.o(284400);
      return true;
    }
    AppMethodBeat.o(284400);
    return false;
  }
  
  public final FinderTipsShowEntranceExtInfo Mr(int paramInt)
  {
    AppMethodBeat.i(284401);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = aBh(Mo(paramInt));
    Log.i("Finder.RedDotManager", "[getTabTipsExtInfo] tabType=" + paramInt + " ext=" + g.a(localFinderTipsShowEntranceExtInfo));
    AppMethodBeat.o(284401);
    return localFinderTipsShowEntranceExtInfo;
  }
  
  public final HashSet<String> a(final l paraml, String paramString)
  {
    AppMethodBeat.i(284387);
    Log.i("Finder.RedDotManager", "[buildPathWithCtrInfo] source=" + paramString + ' ' + c(paraml.field_ctrInfo) + " revokeId=" + paraml.field_revokeId);
    final HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Map)paraml.xuK).entrySet().iterator();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      paramString = (List)this.xsV.get(((Map.Entry)localObject1).getKey());
      if (paramString != null) {
        break label451;
      }
      localObject2 = (f)this;
      paramString = Collections.synchronizedList((List)new LinkedList());
      localObject2 = (Map)((f)localObject2).xsV;
      localObject3 = ((Map.Entry)localObject1).getKey();
      p.j(paramString, "list");
      ((Map)localObject2).put(localObject3, paramString);
    }
    label438:
    label451:
    for (;;)
    {
      p.j(paramString, "crlInfoList");
      com.tencent.mm.ae.d.a(paramString, (kotlin.g.a.b)new e(this, paraml, localHashSet));
      paramString.add(paraml);
      localObject2 = new kotlin.g.a.b[2];
      localObject2[0] = ((kotlin.g.a.b)f.xtm);
      localObject2[1] = ((kotlin.g.a.b)g.xtn);
      p.k(localObject2, "selectors");
      kotlin.a.j.a(paramString, (Comparator)new kotlin.b.b.a((kotlin.g.a.b[])localObject2));
      localHashSet.add(((Map.Entry)localObject1).getKey());
      break;
      paramString = paraml.field_revokeId;
      if (paramString != null) {
        ((Map)this.xsW).put(paramString, paraml);
      }
      localIterator = ((Iterable)localHashSet).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        localObject2 = aBf((String)localObject1);
        if (localObject2 != null)
        {
          paraml = ((l)localObject2).aBy((String)localObject1);
          label361:
          localObject3 = new StringBuilder("[buildPathWithCtrInfo] ctrlInfo:").append(localObject2).append(" ,path:");
          if (paraml == null) {
            break label438;
          }
        }
        for (paramString = paraml.path;; paramString = null)
        {
          Log.i("Finder.RedDotManager", paramString);
          if ((localObject2 == null) || (paraml == null)) {
            break;
          }
          paramString = h.xup;
          h.a(true, (String)localObject1, paraml, (l)localObject2);
          break;
          paraml = null;
          break label361;
        }
      }
      AppMethodBeat.o(284387);
      return localHashSet;
    }
  }
  
  public final void a(bhv parambhv)
  {
    AppMethodBeat.i(178171);
    p.k(parambhv, "redDot");
    long l = cm.bfE();
    Object localObject = m.xuU;
    l -= m.drZ();
    Log.i("Finder.RedDotManager", "[notifyRedDot] diffTime=" + l + " newMsgTipsEnterInterval=" + m.xuU.drS() + " showRed=" + parambhv.SSi + ' ' + c(parambhv.SSj));
    if (l < m.xuU.drS())
    {
      d(parambhv.SSj);
      localObject = parambhv.SSj;
      if (localObject != null)
      {
        localObject = ((bhw)localObject).MFx;
        if (localObject != null) {
          com.tencent.mm.ae.d.a((LinkedList)localObject, (kotlin.g.a.b)x.xtB);
        }
      }
    }
    localObject = parambhv.SSj;
    int i;
    if (localObject != null) {
      i = ((bhw)localObject).type;
    }
    while (i == 2)
    {
      final boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).isInFinder();
      parambhv = parambhv.SSj;
      if (parambhv != null)
      {
        if (bool)
        {
          localObject = parambhv.MFx;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            if ((localObject != null) && (((Iterator)localObject).hasNext()) && (p.h(((bkn)((Iterator)localObject).next()).path, "FinderEntrance"))) {
              ((Iterator)localObject).remove();
            }
          }
        }
        p.j(parambhv, "it");
        a(parambhv);
        a(this, parambhv, "notifyRedDot", null, true, null, (kotlin.g.a.b)new w(this, bool), 20);
        AppMethodBeat.o(178171);
        return;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(178171);
        return;
      }
    }
    parambhv = parambhv.SSk;
    p.j(parambhv, "redDot.ctrl_info_list");
    parambhv = ((Iterable)parambhv).iterator();
    while (parambhv.hasNext())
    {
      localObject = (bhw)parambhv.next();
      if (((bhw)localObject).type == 2)
      {
        p.j(localObject, "it");
        a((bhw)localObject);
      }
      a(this, (bhw)localObject, "notifyRedDot", null, true, null, null, 52);
    }
    AppMethodBeat.o(178171);
  }
  
  public final void a(bhw parambhw, String paramString)
  {
    AppMethodBeat.i(284385);
    p.k(parambhw, "local");
    p.k(paramString, "source");
    int j = parambhw.type;
    Object localObject3 = b(parambhw);
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = ((Map)this.xsV).entrySet().iterator();
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
          l locall = (l)localIterator2.next();
          if (locall.field_ctrInfo.type == j)
          {
            localObject2 = (LinkedList)localHashMap.get(str);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new LinkedList();
              ((Map)localHashMap).put(str, localObject1);
            }
            p.j(localObject1, "clearMap[path] ?: run {\n…                        }");
            ((LinkedList)localObject1).add(locall);
            localIterator2.remove();
          }
        }
      }
      localObject1 = kotlin.x.aazN;
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
          l.b((l)((Iterator)localObject2).next(), this.xtb);
        }
      }
    }
    Object localObject1 = new HashSet();
    a(this, parambhw, paramString, (HashSet)localObject1, false, (o)localObject3, null, 32);
    paramString = (Map)localHashMap;
    parambhw = (Map)new LinkedHashMap();
    paramString = paramString.entrySet().iterator();
    label526:
    while (paramString.hasNext())
    {
      localObject2 = (Map.Entry)paramString.next();
      if (!((HashSet)localObject1).contains(((Map.Entry)localObject2).getKey())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label526;
        }
        parambhw.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        break;
      }
    }
    parambhw = parambhw.entrySet().iterator();
    while (parambhw.hasNext())
    {
      localObject1 = (Map.Entry)parambhw.next();
      paramString = (String)((Map.Entry)localObject1).getKey();
      localObject1 = ((Iterable)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject1).hasNext()) {
        l.b((l)((Iterator)localObject1).next(), this.xtb);
      }
      localObject1 = aBf(paramString);
      if (localObject1 != null)
      {
        localObject2 = ((l)localObject1).aBy(paramString);
        if (localObject2 != null) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label684;
          }
          localObject3 = h.xup;
          h.a(false, paramString, null, null);
          localObject3 = h.xup;
          h.a(true, paramString, (bkn)localObject2, (l)localObject1);
          break;
        }
        label684:
        localObject1 = h.xup;
        h.a(false, paramString, null, null);
      }
      else
      {
        localObject1 = h.xup;
        h.a(false, paramString, null, null);
      }
    }
    AppMethodBeat.o(284385);
  }
  
  public final void a(bie parambie)
  {
    AppMethodBeat.i(284418);
    p.k(parambie, "revoke");
    Object localObject1 = new StringBuilder("[revokePathRedDot] ");
    Object localObject2 = parambie.SSF;
    p.j(localObject2, "revoke.revoke_ctrl_info");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    bif localbif;
    while (((Iterator)localObject3).hasNext())
    {
      localbif = (bif)((Iterator)localObject3).next();
      ((Collection)localObject2).add(localbif.path + '_' + localbif.SSG + '_' + localbif.SSH);
    }
    Log.i("Finder.RedDotManager", (List)localObject2);
    parambie = parambie.SSF;
    p.j(parambie, "revoke.revoke_ctrl_info");
    localObject3 = ((Iterable)parambie).iterator();
    l locall;
    label268:
    label364:
    Object localObject4;
    label434:
    final aa.a locala;
    while (((Iterator)localObject3).hasNext())
    {
      localbif = (bif)((Iterator)localObject3).next();
      if (localbif != null)
      {
        localObject1 = localbif.path;
        parambie = (bie)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parambie = "";
      }
      locall = aBf(parambie);
      if (locall != null)
      {
        if (localbif != null)
        {
          localObject1 = localbif.path;
          parambie = (bie)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          parambie = "";
        }
        parambie = locall.aBy(parambie);
        if (localbif.SSG != 0) {
          break label434;
        }
        if (parambie == null) {
          break label364;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
        com.tencent.mm.plugin.finder.report.l.a(locall, parambie, 1, localbif.SSG, null, null, 48);
      }
      for (;;)
      {
        if (localbif != null)
        {
          localObject1 = localbif.path;
          parambie = (bie)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          parambie = "";
        }
        gW(parambie, "revokePathRedDot#0");
        if (localbif != null)
        {
          localObject1 = localbif.path;
          parambie = (bie)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          parambie = "";
        }
        aBd(parambie);
        break;
        parambie = null;
        break label268;
        com.tencent.mm.plugin.report.service.h.IzE.a(20951, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), "", localbif.path, Integer.valueOf(localbif.SSG), "" });
      }
      if (localbif.SSG == 1)
      {
        localObject1 = "";
        localObject2 = localbif.SSH;
        p.j(localObject2, "it.tips_id_list");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject1 = (String)localObject1 + (String)localObject4 + ';';
        }
        kotlin.n.n.b((String)localObject1, (CharSequence)";");
        localObject4 = new aa.a();
        ((aa.a)localObject4).aaBx = true;
        locala = new aa.a();
        locala.aaBx = false;
        if (localbif != null)
        {
          localObject2 = localbif.path;
          if (localObject2 != null) {
            break label806;
          }
        }
        localObject2 = "";
      }
    }
    label806:
    for (;;)
    {
      i((String)localObject2, (kotlin.g.a.b)new ac(localbif, (aa.a)localObject4, locala, this));
      Log.i("Finder.RedDotManager", "[revokePathRedDot] isHasDisposed=" + locala.aaBx + " isAllDisposed=" + ((aa.a)localObject4).aaBx + " tipsList=" + (String)localObject1);
      if ((locala.aaBx) && (((aa.a)localObject4).aaBx))
      {
        localObject2 = aj.AGc;
        if ((locall == null) || (parambie == null)) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
        com.tencent.mm.plugin.finder.report.l.a(locall, parambie, 1, localbif.SSG, (String)localObject1, null, 32);
        break;
      }
      if ((locala.aaBx) && (!((aa.a)localObject4).aaBx))
      {
        localObject2 = aj.AGc;
        if ((locall == null) || (parambie == null)) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
        com.tencent.mm.plugin.finder.report.l.a(locall, parambie, 2, localbif.SSG, (String)localObject1, null, 32);
        break;
      }
      if (locala.aaBx) {
        break;
      }
      localObject2 = aj.AGc;
      if ((locall == null) || (parambie == null)) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
      com.tencent.mm.plugin.finder.report.l.a(locall, parambie, 4, localbif.SSG, (String)localObject1, null, 32);
      break;
      AppMethodBeat.o(284418);
      return;
    }
  }
  
  public final void a(final big parambig)
  {
    AppMethodBeat.i(284416);
    p.k(parambig, "revoke");
    StringBuilder localStringBuilder = new StringBuilder("[revokeTabTips] ");
    Object localObject1 = parambig.SSI;
    p.j(localObject1, "revoke.revoke_tab_tips_info");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((bih)((Iterator)localObject2).next()).SSp);
    }
    Log.i("Finder.RedDotManager", (List)localObject1);
    com.tencent.mm.ae.d.c("Finder.RedDotManager", (kotlin.g.a.a)new ad(this, parambig));
    AppMethodBeat.o(284416);
  }
  
  public final void a(bke parambke, String paramString)
  {
    AppMethodBeat.i(284397);
    p.k(parambke, "tabTips");
    p.k(paramString, "source");
    long l2 = dqD();
    parambke = parambke.SSJ;
    p.j(parambke, "tabTips.tab_tips_info");
    Object localObject1 = (Iterable)parambke;
    parambke = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    bkg localbkg;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localbkg = (bkg)localObject2;
      p.j(localbkg, "it");
      if (a(localbkg)) {
        parambke.add(localObject2);
      }
    }
    Object localObject2 = ((Iterable)parambke).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localbkg = (bkg)((Iterator)localObject2).next();
      parambke = localbkg.SVk;
      if (parambke != null)
      {
        parambke = parambke.MFx;
        if (parambke != null) {
          kotlin.a.j.c((List)parambke, (kotlin.g.a.b)y.xtC);
        }
      }
      Log.i("Finder.RedDotManager", "[notifyTabTip] " + c(localbkg.SVk));
      parambke = localbkg.SVk;
      label235:
      Object localObject4;
      label314:
      label321:
      label325:
      label329:
      label333:
      label337:
      label341:
      label349:
      label353:
      boolean bool3;
      label430:
      label510:
      boolean bool1;
      label590:
      label728:
      boolean bool4;
      label641:
      label706:
      boolean bool2;
      if (parambke != null)
      {
        parambke = Integer.valueOf(parambke.type);
        localObject3 = localbkg.SVk;
        localObject1 = localbkg.SVk;
        if (localObject1 == null) {
          break label887;
        }
        localObject1 = ((bhw)localObject1).MFx;
        if (localObject1 == null) {
          break label887;
        }
        localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject1 = ((Iterator)localObject4).next();
          if (p.h(((bkn)localObject1).path, "FinderEntrance"))
          {
            localObject1 = (bkn)localObject1;
            if (parambke != null) {
              break label893;
            }
            if (parambke != null) {
              break label1077;
            }
            if (parambke != null) {
              break label1168;
            }
            if (parambke != null) {
              break label1259;
            }
            if (parambke != null) {
              break label1350;
            }
            if (parambke != null) {
              break label1441;
            }
            if (parambke != null) {
              break label1453;
            }
            if (parambke != null) {
              break label1544;
            }
            bool3 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).isInFinder();
            if (bool3)
            {
              d(localbkg.SVk);
              localObject4 = new StringBuilder("[notifyTabTip] it is in finder now. just remove path of FINDER_ENTRANCE, currentTabType=").append(this.xsO.Bgp).append(" type=");
              localObject1 = localbkg.SVk;
              if (localObject1 == null) {
                break label1944;
              }
              localObject1 = Integer.valueOf(((bhw)localObject1).type);
              Log.w("Finder.RedDotManager", localObject1);
            }
            if (((com.tencent.c.a.b.a.e)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.e.class)).isInNearby())
            {
              localObject1 = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
              com.tencent.mm.plugin.finder.extension.reddot.nearby.a.g(localbkg.SVk);
              localObject4 = new StringBuilder("[notifyTabTip] it is in nearby now. just remove path of NEARBY_ENTRANCE, type=");
              localObject1 = localbkg.SVk;
              if (localObject1 == null) {
                break label1950;
              }
              localObject1 = Integer.valueOf(((bhw)localObject1).type);
              Log.w("Finder.RedDotManager", localObject1);
            }
            if (((com.tencent.c.a.b.a.e)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.e.class)).isInFinderLiveSquareFindPageUI())
            {
              localObject1 = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
              com.tencent.mm.plugin.finder.extension.reddot.nearby.a.h(localbkg.SVk);
              localObject4 = new StringBuilder("[notifyTabTip] it is in finderLiveSquare now. just remove path of FinderLiveEntrance, type=");
              localObject1 = localbkg.SVk;
              if (localObject1 == null) {
                break label1956;
              }
              localObject1 = Integer.valueOf(((bhw)localObject1).type);
              Log.w("Finder.RedDotManager", localObject1);
            }
            if (!c((bhw)localObject3, "finder_tl_hot_tab")) {
              break label2412;
            }
            localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dWM().aSr()).intValue() != 1) {
              break label1962;
            }
            bool1 = true;
            if (localObject3 == null) {
              break label1974;
            }
            localObject1 = ((bhw)localObject3).MFx;
            if (localObject1 == null) {
              break label1974;
            }
            localObject3 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              if (p.h(((bkn)localObject1).path, "finder_tl_hot_tab"))
              {
                localObject1 = (bkn)localObject1;
                if (localObject1 == null) {
                  break label1974;
                }
                localObject1 = Integer.valueOf(((bkn)localObject1).SVy);
                bool4 = this.xsO.OO(4);
                if (this.xsO.Bgp != 4) {
                  break label1980;
                }
                bool2 = true;
                label752:
                if (localObject1 != null) {
                  break label1986;
                }
              }
            }
          }
        }
      }
      label809:
      label887:
      label893:
      long l1;
      label1077:
      label1259:
      while (((Integer)localObject1).intValue() != 1)
      {
        if ((!bool1) || ((!bool2) && (bool4))) {
          break label1995;
        }
        localObject1 = new StringBuilder("ignore this reddot.ctrlType=").append(parambke).append(" tips_id=");
        parambke = localbkg.SVk;
        if (parambke == null) {
          break label2407;
        }
        parambke = parambke.SQm;
        Log.w("Finder.RedDotManager", parambke + " isInFinder=" + bool3 + ' ' + "isFilter=" + bool1 + " isInSelfTab=" + bool2 + " isAutoRefresh=" + bool4);
        break;
        parambke = null;
        break label235;
        localObject1 = null;
        break label314;
        localObject1 = null;
        break label321;
        if (parambke.intValue() != 8) {
          break label325;
        }
        if (l2 <= m.xuU.drK())
        {
          localObject4 = localbkg.SVk;
          if (localObject4 != null)
          {
            localObject4 = ((bhw)localObject4).MFx;
            if (localObject4 != null) {
              com.tencent.mm.ae.d.a((LinkedList)localObject4, (kotlin.g.a.b)z.xtD);
            }
          }
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFollowTabTimeMs=" + m.xuU.drK() + "ms, remove this ctrInfo");
        }
        if (((localObject1 != null) && (((bkn)localObject1).SVy == 1)) || (l2 > m.xuU.drJ())) {
          break label353;
        }
        d(localbkg.SVk);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFollowTabTimeMs=" + m.xuU.drJ() + "ms, remove entrance path red dot");
        break label353;
        if (parambke.intValue() != 7) {
          break label329;
        }
        if (((localObject1 != null) && (((bkn)localObject1).SVy == 1)) || (l2 > m.xuU.drL())) {
          break label353;
        }
        d(localbkg.SVk);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFriendEntranceTimeMs=" + m.xuU.drL() + "ms, remove entrance path red dot");
        break label353;
        if (parambke.intValue() != 17) {
          break label333;
        }
        if (((localObject1 != null) && (((bkn)localObject1).SVy == 1)) || (l2 > m.xuU.drM())) {
          break label353;
        }
        d(localbkg.SVk);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFriendEntranceTimeMs=" + m.xuU.drM() + "ms, remove entrance path red dot");
        break label353;
        if (parambke.intValue() != 10) {
          break label337;
        }
        if (((localObject1 != null) && (((bkn)localObject1).SVy == 1)) || (l2 > m.xuU.drN())) {
          break label353;
        }
        d(localbkg.SVk);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabHotEntranceTimeMs=" + m.xuU.drN() + "ms, remove entrance path red dot");
        break label353;
        if (parambke.intValue() != 9) {
          break label341;
        }
        for (;;)
        {
          if (((localObject1 != null) && (((bkn)localObject1).SVy == 1)) || (l2 > m.xuU.drP())) {
            break label1451;
          }
          d(localbkg.SVk);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabLiveEntranceTimeMs=" + m.xuU.drP() + "ms, remove entrance path red dot");
          break label353;
          if (parambke.intValue() != 13) {
            break;
          }
        }
        break label353;
        if (parambke.intValue() != 14) {
          break label349;
        }
        if (((localObject1 != null) && (((bkn)localObject1).SVy == 1)) || (l2 > m.xuU.drO())) {
          break label353;
        }
        d(localbkg.SVk);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabHotEntranceTimeMs=" + m.xuU.drO() + "ms, remove entrance path red dot");
        break label353;
        if (parambke.intValue() != 16) {
          break label353;
        }
        localObject1 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
        if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
        {
          localObject1 = localbkg.SVk;
          if (localObject1 != null)
          {
            localObject1 = ((bhw)localObject1).MFx;
            if (localObject1 != null)
            {
              localObject4 = ((Iterable)localObject1).iterator();
              do
              {
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject1 = ((Iterator)localObject4).next();
              } while (!p.h(((bkn)localObject1).path, "NearbyEntrance"));
            }
          }
          for (localObject1 = (bkn)localObject1;; localObject1 = null)
          {
            l1 = dqE();
            if (((localObject1 != null) && (((bkn)localObject1).SVy == 1)) || ((l1 > m.xuU.drQ()) && (dqJ()))) {
              break;
            }
            localObject1 = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
            com.tencent.mm.plugin.finder.extension.reddot.nearby.a.g(localbkg.SVk);
            Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l1 + "ms, moreTabNearbyEntranceTimeMs=" + m.xuU.drQ() + "ms, remove entrance path red dot");
            break;
            localObject1 = null;
            break label1636;
          }
        }
        localObject1 = localbkg.SVk;
        if (localObject1 != null)
        {
          localObject1 = ((bhw)localObject1).MFx;
          if (localObject1 != null)
          {
            localObject4 = ((Iterable)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject1 = ((Iterator)localObject4).next();
            } while (!p.h(((bkn)localObject1).path, "FinderLiveEntrance"));
          }
        }
        for (localObject1 = (bkn)localObject1;; localObject1 = null)
        {
          l1 = dqF();
          if (((localObject1 != null) && (((bkn)localObject1).SVy == 1)) || ((l1 > m.xuU.drR()) && (dqK()))) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
          com.tencent.mm.plugin.finder.extension.reddot.nearby.a.h(localbkg.SVk);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l1 + "ms, finderLiveEntranceEntranceTimeMs=" + m.xuU.drR() + "ms, remove entrance path red dot");
          break;
          localObject1 = null;
          break label1826;
        }
        localObject1 = null;
        break label430;
        localObject1 = null;
        break label510;
        localObject1 = null;
        break label590;
        bool1 = false;
        break label641;
        localObject1 = null;
        break label706;
        localObject1 = null;
        break label728;
        bool2 = false;
        break label752;
      }
      label1168:
      label1350:
      label1636:
      parambke = null;
      label1441:
      label1451:
      label1453:
      label1974:
      label1980:
      label1986:
      label1995:
      localObject1 = localbkg.SVk;
      label1544:
      label1826:
      label1956:
      label1962:
      if (localObject1 != null)
      {
        p.j(localObject1, "info");
        parambke = b((bhw)localObject1);
        Mp(((bhw)localObject1).type);
        localObject1 = kotlin.x.aazN;
      }
      label1944:
      label1950:
      b(localbkg.SVk, "notifyTabTip");
      localObject1 = a(this, localbkg.SVk, "notifyTabTip#".concat(String.valueOf(paramString)), null, true, parambke, null, 36);
      Object localObject3 = new StringBuilder("[notifyTabTip] successfully! ctrlType=");
      label2106:
      label2143:
      label2172:
      int i;
      if (localObject1 != null)
      {
        parambke = Integer.valueOf(((l)localObject1).field_ctrInfo.type);
        localObject3 = ((StringBuilder)localObject3).append(parambke).append(" tabType=");
        if (localObject1 == null) {
          break label3039;
        }
        parambke = ((l)localObject1).xuM;
        if (parambke == null) {
          break label3039;
        }
        parambke = Integer.valueOf(parambke.tab_type);
        localObject3 = ((StringBuilder)localObject3).append(parambke).append(" extInfo=");
        parambke = localbkg.SVk;
        if (parambke == null) {
          break label3044;
        }
        parambke = parambke.SSl;
        if (parambke == null) {
          break label3049;
        }
        bool1 = true;
        label2179:
        parambke = ((StringBuilder)localObject3).append(bool1).append(' ').append("objectId=");
        if (localObject1 == null) {
          break label3055;
        }
        localObject3 = ((l)localObject1).field_ctrInfo;
        if (localObject3 == null) {
          break label3055;
        }
        l1 = ((bhw)localObject3).feedId;
        label2222:
        parambke = parambke.append(com.tencent.mm.ae.d.Fw(l1)).append(' ').append("diffTime=").append(l2).append("ms isInFinder=").append(bool3).append(" currentTabType=").append(this.xsO.Bgp).append(" showInfoSize=");
        localObject3 = localbkg.SVk;
        if (localObject3 == null) {
          break label3061;
        }
        localObject3 = ((bhw)localObject3).MFx;
        if (localObject3 == null) {
          break label3061;
        }
        i = ((LinkedList)localObject3).size();
        label2311:
        localObject3 = parambke.append(i).append(' ').append("tabTipsByPassInfo=");
        if (localObject1 == null) {
          break label3066;
        }
        parambke = ((l)localObject1).xuM;
        if (parambke == null) {
          break label3066;
        }
        parambke = parambke.tabTipsByPassInfo;
        label2349:
        if (parambke == null) {
          break label3071;
        }
        bool1 = true;
        label2356:
        localObject1 = ((StringBuilder)localObject3).append(bool1).append(" expiredTime=");
        parambke = localbkg.SVk;
        if (parambke == null) {
          break label3077;
        }
      }
      label2563:
      label3077:
      for (parambke = Integer.valueOf(parambke.tnN);; parambke = null)
      {
        Log.i("Finder.RedDotManager", parambke);
        break;
        label2407:
        parambke = null;
        break label809;
        label2412:
        if (c((bhw)localObject3, "TLRecommendTab"))
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dWN().aSr()).intValue() == 1)
          {
            bool1 = true;
            if (localObject3 == null) {
              break label2694;
            }
            localObject1 = ((bhw)localObject3).MFx;
            if (localObject1 == null) {
              break label2694;
            }
            localObject3 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              if (p.h(((bkn)localObject1).path, "TLRecommendTab"))
              {
                localObject1 = (bkn)localObject1;
                if (localObject1 == null) {
                  break label2694;
                }
                localObject1 = Integer.valueOf(((bkn)localObject1).SVy);
                bool4 = this.xsO.OO(1);
                if (this.xsO.Bgp != 1) {
                  break label2700;
                }
                bool2 = true;
                label2558:
                if (localObject1 != null) {
                  break label2706;
                }
                if ((!bool1) || ((!bool2) && (bool4))) {
                  break label2716;
                }
                localObject1 = new StringBuilder("ignore this reddot.ctrlType=").append(parambke).append(" tips_id=");
                parambke = localbkg.SVk;
                if (parambke == null) {
                  break label2718;
                }
              }
            }
          }
          for (parambke = parambke.SQm;; parambke = null)
          {
            Log.w("Finder.RedDotManager", parambke + " isInFinder=" + bool3 + ' ' + "isFilter=" + bool1 + " isInSelfTab=" + bool2 + " isAutoRefresh=" + bool4);
            break;
            bool1 = false;
            break label2447;
            localObject1 = null;
            break label2512;
            localObject1 = null;
            break label2534;
            bool2 = false;
            break label2558;
            if (((Integer)localObject1).intValue() == 1) {
              break label1995;
            }
            break label2563;
            break label1995;
          }
        }
        label2447:
        label2512:
        label2534:
        if (!c((bhw)localObject3, "TLFollow")) {
          break label1995;
        }
        label2694:
        label2700:
        label2706:
        label2716:
        label2718:
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dWO().aSr()).intValue() == 1)
        {
          bool1 = true;
          label2758:
          if (localObject3 == null) {
            break label3005;
          }
          localObject1 = ((bhw)localObject3).MFx;
          if (localObject1 == null) {
            break label3005;
          }
          localObject3 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (p.h(((bkn)localObject1).path, "TLFollow"))
            {
              label2823:
              localObject1 = (bkn)localObject1;
              if (localObject1 == null) {
                break label3005;
              }
              localObject1 = Integer.valueOf(((bkn)localObject1).SVy);
              label2845:
              bool4 = this.xsO.OO(3);
              if (this.xsO.Bgp != 3) {
                break label3011;
              }
              bool2 = true;
              label2869:
              if (localObject1 != null) {
                break label3017;
              }
              label2874:
              if ((!bool1) || ((!bool2) && (bool4))) {
                break label3027;
              }
              localObject1 = new StringBuilder("ignore this reddot.ctrlType=").append(parambke).append(" tips_id=");
              parambke = localbkg.SVk;
              if (parambke == null) {
                break label3029;
              }
            }
          }
        }
        label3005:
        label3011:
        label3017:
        label3027:
        label3029:
        for (parambke = parambke.SQm;; parambke = null)
        {
          Log.w("Finder.RedDotManager", parambke + " isInFinder=" + bool3 + ' ' + "isFilter=" + bool1 + " isInSelfTab=" + bool2 + " isAutoRefresh=" + bool4);
          break;
          bool1 = false;
          break label2758;
          localObject1 = null;
          break label2823;
          localObject1 = null;
          break label2845;
          bool2 = false;
          break label2869;
          if (((Integer)localObject1).intValue() == 1) {
            break label1995;
          }
          break label2874;
          break label1995;
        }
        parambke = null;
        break label2106;
        label3039:
        parambke = null;
        break label2143;
        label3044:
        parambke = null;
        break label2172;
        label3049:
        bool1 = false;
        break label2179;
        label3055:
        l1 = 0L;
        break label2222;
        label3061:
        i = 0;
        break label2311;
        label3066:
        parambke = null;
        break label2349;
        label3071:
        bool1 = false;
        break label2356;
      }
    }
    AppMethodBeat.o(284397);
  }
  
  public final void aBd(String paramString)
  {
    AppMethodBeat.i(178176);
    p.k(paramString, "path");
    d(paramString, null);
    AppMethodBeat.o(178176);
  }
  
  public final bkn aBe(String paramString)
  {
    AppMethodBeat.i(178178);
    p.k(paramString, "path");
    l locall = aBf(paramString);
    if (locall != null)
    {
      paramString = locall.aBy(paramString);
      AppMethodBeat.o(178178);
      return paramString;
    }
    AppMethodBeat.o(178178);
    return null;
  }
  
  public final l aBf(String paramString)
  {
    AppMethodBeat.i(178179);
    p.k(paramString, "path");
    Object localObject1 = (List)this.xsV.get(paramString);
    if (localObject1 != null)
    {
      Object localObject4;
      for (;;)
      {
        synchronized ((Iterable)localObject1)
        {
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)???).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          Object localObject5 = ((Iterator)localObject4).next();
          l locall = (l)localObject5;
          Iterator localIterator = ((Iterable)this.xsY).iterator();
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (!((Boolean)((kotlin.g.a.b)((o)localObject1).Mx).invoke(locall)).booleanValue()) {
              continue;
            }
            localObject1 = (o)localObject1;
            if (localObject1 == null) {
              break label235;
            }
            localObject1 = (kotlin.g.a.b)((o)localObject1).My;
            if (localObject1 == null) {
              break label235;
            }
            localObject1 = (Boolean)((kotlin.g.a.b)localObject1).invoke(locall);
            if (localObject1 == null) {
              break label235;
            }
            bool = ((Boolean)localObject1).booleanValue();
            if (!bool) {
              continue;
            }
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject1 = null;
        continue;
        label235:
        boolean bool = true;
      }
      Object localObject3 = (List)localObject3;
      try
      {
        ??? = ((List)localObject3).listIterator(((List)localObject3).size());
        int i;
        if (((ListIterator)???).hasPrevious())
        {
          localObject1 = ((ListIterator)???).previous();
          localObject4 = ((l)localObject1).aBy(paramString);
          if (localObject4 != null)
          {
            i = 1;
            label306:
            if (i == 0) {
              break label332;
            }
          }
        }
        for (paramString = (String)localObject1;; paramString = null)
        {
          paramString = (l)paramString;
          AppMethodBeat.o(178179);
          return paramString;
          i = 0;
          break label306;
          label332:
          break;
        }
        AppMethodBeat.o(178179);
      }
      finally
      {
        AppMethodBeat.o(178179);
      }
    }
    return null;
  }
  
  public final FinderTipsShowEntranceExtInfo aBh(String paramString)
  {
    AppMethodBeat.i(284399);
    p.k(paramString, "path");
    paramString = aBf(paramString);
    if (paramString != null)
    {
      FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = paramString.drG();
      paramString = localFinderTipsShowEntranceExtInfo;
      if (localFinderTipsShowEntranceExtInfo != null) {}
    }
    else
    {
      paramString = new FinderTipsShowEntranceExtInfo();
    }
    AppMethodBeat.o(284399);
    return paramString;
  }
  
  public final bhx aBi(String paramString)
  {
    AppMethodBeat.i(284406);
    p.k(paramString, "path");
    paramString = (b)this.xsZ.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.xte;
      AppMethodBeat.o(284406);
      return paramString;
    }
    AppMethodBeat.o(284406);
    return null;
  }
  
  public final void af(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(284372);
    if ((paramInt1 <= 0) && (paramInt2 <= 0) && (paramInt3 <= 0))
    {
      Log.i("Finder.RedDotManager", "[notifyFinderMsgCount] server error.");
      AppMethodBeat.o(284372);
      return;
    }
    bhw localbhw = new bhw();
    localbhw.SQm = String.valueOf(cm.bfE());
    localbhw.priority = 400000;
    localbhw.type = 2;
    Object localObject1 = new bkn();
    ((bkn)localObject1).CKC = 2;
    ((bkn)localObject1).SVs = 1;
    ((bkn)localObject1).path = "AuthorProfileNotify";
    ((bkn)localObject1).count = (paramInt1 + paramInt2 + paramInt3);
    localbhw.MFx.add(localObject1);
    if (paramInt1 > 0)
    {
      localObject1 = new bkn();
      ((bkn)localObject1).CKC = 2;
      ((bkn)localObject1).SVs = 1;
      ((bkn)localObject1).path = "NotificationCenterLike";
      ((bkn)localObject1).count = paramInt1;
      localbhw.MFx.add(localObject1);
    }
    if (paramInt2 > 0)
    {
      localObject1 = new bkn();
      ((bkn)localObject1).CKC = 2;
      ((bkn)localObject1).SVs = 1;
      ((bkn)localObject1).path = "NotificationCenterComment";
      ((bkn)localObject1).count = paramInt2;
      localbhw.MFx.add(localObject1);
    }
    if (paramInt3 > 0)
    {
      localObject1 = new bkn();
      ((bkn)localObject1).CKC = 2;
      ((bkn)localObject1).SVs = 1;
      ((bkn)localObject1).path = "NotificationCenterFollow";
      ((bkn)localObject1).count = paramInt3;
      localbhw.MFx.add(localObject1);
    }
    a(localbhw);
    localObject1 = localbhw.MFx;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (p.h(((bkn)localObject3).path, "TLPersonalCenter")) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      if (((Collection)localObject1).isEmpty()) {
        break label518;
      }
      i = 1;
      if (i == 0) {
        break label524;
      }
      label391:
      if (localObject1 != null)
      {
        localObject1 = (bkn)((List)localObject1).get(0);
        if ((localObject1 != null) && (((bkn)localObject1).CKC == 2))
        {
          localObject2 = aBe("finder_private_msg_entrance");
          if (localObject2 == null) {
            break label530;
          }
        }
      }
    }
    label518:
    label524:
    label530:
    for (int i = ((bkn)localObject2).count;; i = 0)
    {
      ((bkn)localObject1).count = (paramInt1 + paramInt2 + paramInt3 + i);
      Log.i("Finder.RedDotManager", "count :" + ((bkn)localObject1).count + " finderMessageCount:" + i);
      a(this, localbhw, "notifyFinderTabMsgCount", null, false, null, null, 60);
      AppMethodBeat.o(284372);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label391;
    }
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(284403);
    p.k(paraml, "enterCtrlInfo");
    String str = Mo(a(paraml));
    Log.i("Finder.RedDotManager", "[saveEnterTabTipsExtInfo] PATH=" + str + '=' + paraml.xuM);
    Map localMap = (Map)this.xsZ;
    bhx localbhx = paraml.xuM;
    paraml = paraml.field_tipsId;
    p.j(paraml, "enterCtrlInfo.field_tipsId");
    localMap.put(str, new b(localbhx, paraml));
    AppMethodBeat.o(284403);
  }
  
  public final void b(bhw parambhw, String paramString)
  {
    AppMethodBeat.i(284405);
    p.k(paramString, "source");
    if (parambhw != null)
    {
      String str = Mo(a(new l().e(parambhw)));
      b localb = (b)this.xsZ.get(str);
      if (localb != null)
      {
        if (p.h(localb.xtf, parambhw.SQm)) {}
        while (localb != null)
        {
          this.xsZ.remove(str);
          Log.i("Finder.RedDotManager", "[clearEnterTabTipsExtInfo] PATH=" + str + " tips_id=" + parambhw.SQm + " source=" + paramString);
          AppMethodBeat.o(284405);
          return;
          localb = null;
        }
      }
      AppMethodBeat.o(284405);
      return;
    }
    AppMethodBeat.o(284405);
  }
  
  public final boolean b(int paramInt, kotlin.g.a.b<? super l, Boolean> paramb)
  {
    AppMethodBeat.i(284391);
    p.k(paramb, "filter");
    Object localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if ((((ae)localObject1).dYT()) && (paramInt != 8))
    {
      Log.i("Finder.RedDotManager", "[clearCtrlInfo] 青少年模式且只看关注的模式下只clear关注的红点展示");
      AppMethodBeat.o(284391);
      return false;
    }
    paramb = c(paramInt, paramb);
    int i;
    if (!((Map)paramb).isEmpty())
    {
      i = 1;
      if (i != 0) {
        Log.i("Finder.RedDotManager", "[clearCtrlInfo] type=" + paramInt + " clearMap=" + paramb);
      }
      localObject1 = ((Map)paramb).entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label364;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      Object localObject3 = (List)this.xsV.get(str);
      if (localObject3 != null) {
        com.tencent.mm.ae.d.a((List)localObject3, (kotlin.g.a.b)new j((Map.Entry)localObject2));
      }
      localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          l.b((l)((Iterator)localObject2).next(), this.xtb);
          continue;
          i = 0;
          break;
        }
      }
      localObject2 = aBf(str);
      if (localObject2 != null)
      {
        localObject3 = ((l)localObject2).aBy(str);
        if (localObject3 != null) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label332;
          }
          h localh = h.xup;
          h.a(false, str, null, null);
          localh = h.xup;
          h.a(true, str, (bkn)localObject3, (l)localObject2);
          break;
        }
        label332:
        localObject2 = h.xup;
        h.a(false, str, null, null);
      }
      else
      {
        localObject2 = h.xup;
        h.a(false, str, null, null);
      }
    }
    label364:
    if (!((Map)paramb).isEmpty())
    {
      AppMethodBeat.o(284391);
      return true;
    }
    AppMethodBeat.o(284391);
    return false;
  }
  
  public final void d(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(284383);
    p.k(paramString, "path");
    i(paramString, (kotlin.g.a.b)new o(paramArrayOfInt));
    AppMethodBeat.o(284383);
  }
  
  public final void dqB()
  {
    AppMethodBeat.i(178169);
    Object localObject = n.xuW;
    Log.i("Finder.ThreeDayTwoDay", "enterFindMoreFriendTab");
    if (((n)localObject).dsi())
    {
      localObject = n.wVw;
      if (localObject != null)
      {
        localObject = ((f)localObject).aBf("FinderEntrance");
        if (localObject != null)
        {
          bkn localbkn = ((l)localObject).aBy("FinderEntrance");
          if (localbkn != null) {
            com.tencent.mm.plugin.finder.report.l.a(com.tencent.mm.plugin.finder.report.l.zWx, "1", (l)localObject, localbkn, 4);
          }
        }
      }
      localObject = n.wVw;
      if (localObject != null)
      {
        ((f)localObject).aBd("FinderEntrance");
        AppMethodBeat.o(178169);
        return;
      }
    }
    AppMethodBeat.o(178169);
  }
  
  public final void dqC()
  {
    AppMethodBeat.i(284373);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    if (!((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.VCo, false))
    {
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VCo, Boolean.TRUE);
      localObject = new bhw();
      ((bhw)localObject).SQm = String.valueOf(cm.bfE());
      ((bhw)localObject).priority = 0;
      ((bhw)localObject).type = 1018;
      bkn localbkn = new bkn();
      localbkn.CKC = 1;
      localbkn.SVs = 1;
      localbkn.path = "TLPersonalCenter";
      ((bhw)localObject).MFx.add(localbkn);
      localbkn = new bkn();
      localbkn.CKC = 1;
      localbkn.SVs = 1;
      localbkn.path = "FinderPosterEntrance";
      ((bhw)localObject).MFx.add(localbkn);
      localbkn = new bkn();
      localbkn.CKC = 1;
      localbkn.SVs = 1;
      localbkn.path = "FinderLiveIncomeEntrance";
      localbkn.HpB = "TLPersonalCenter";
      ((bhw)localObject).MFx.add(localbkn);
      a(this, (bhw)localObject, "notifyFinderLiveFirstReward", null, false, null, null, 60);
      Log.i("Finder.RedDotManager", "notifyFinderLiveFirstReward");
    }
    AppMethodBeat.o(284373);
  }
  
  public final int dqG()
  {
    int j = -1;
    AppMethodBeat.i(284389);
    long l = System.currentTimeMillis();
    Object localObject2 = aBf("FinderEntrance");
    Object localObject1;
    int k;
    int i;
    if (localObject2 != null)
    {
      localObject1 = ((l)localObject2).aBy("FinderEntrance");
      if (localObject1 == null) {
        break label149;
      }
      k = ((l)localObject2).xuM.SSw;
      switch (k)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      Log.i("Finder.RedDotManager", "[getAliveTabType] -- enterAction: " + k + "  tabType:" + i);
      if (i == -1) {
        break label149;
      }
      AppMethodBeat.o(284389);
      return i;
      localObject1 = null;
      break;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 4;
    }
    label149:
    Object localObject4;
    if ((localObject1 == null) || (((l)localObject2).aBy("finder_private_msg_entrance") != null))
    {
      i = this.xsO.Bgq;
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.dUi().aSr()).intValue() == 1) && (i == 4))
      {
        Log.i("Finder.RedDotManager", "[getAliveTabType] IS_HARD_JUMP_HOT_WITHOUT_ENTRANCE_REDDOT = true");
        AppMethodBeat.o(284389);
        return 4;
      }
      localObject1 = c.xth;
      localObject1 = f.c.a.a(1, this);
      localObject2 = c.xth;
      localObject2 = f.c.a.a(3, this);
      Object localObject3 = c.xth;
      localObject3 = kotlin.a.j.listOf(new c[] { localObject1, localObject2, f.c.a.a(4, this) });
      localObject4 = ((Iterable)localObject3).iterator();
      if (!((Iterator)localObject4).hasNext()) {
        localObject1 = null;
      }
      label325:
      do
      {
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = (c)localObject1;
        if (((c)localObject1).xtg.SVB > 0) {
          break;
        }
        i = j;
        localObject1 = new StringBuilder("[getAliveTabType] cost=").append(System.currentTimeMillis() - l).append("ms aliveType=").append(i).append(" maxPriorityTabType=").append(((c)localObject1).fEH).append(' ');
        localObject3 = (Iterable)localObject3;
        localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((Collection)localObject2).add(((c)localObject4).fEH + '=' + ((c)localObject4).xtg.SVB);
        }
        localObject1 = ((Iterator)localObject4).next();
      } while (!((Iterator)localObject4).hasNext());
      i = ((c)localObject1).xtg.SVB;
      label511:
      localObject2 = ((Iterator)localObject4).next();
      k = ((c)localObject2).xtg.SVB;
      if (i >= k) {
        break label647;
      }
      localObject1 = localObject2;
      i = k;
    }
    label647:
    for (;;)
    {
      if (!((Iterator)localObject4).hasNext())
      {
        break;
        i = ((c)localObject1).fEH;
        break label325;
        Log.i("Finder.RedDotManager", (List)localObject2);
        AppMethodBeat.o(284389);
        return i;
        i = a((l)localObject2);
        Log.i("Finder.RedDotManager", "[getAliveTabType] getTabTypeInCtrlInfo=".concat(String.valueOf(i)));
        if (i != -1)
        {
          AppMethodBeat.o(284389);
          return i;
        }
        Log.i("Finder.RedDotManager", "[getAliveTabType] TAB_TYPE_INVALID");
        AppMethodBeat.o(284389);
        return -1;
      }
      break label511;
    }
  }
  
  public final Set<l> dqH()
  {
    AppMethodBeat.i(284408);
    Object localObject = new HashSet();
    Iterator localIterator = ((Map)this.xsV).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((HashSet)localObject).addAll((Collection)((Map.Entry)localIterator.next()).getValue());
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(284408);
    return localObject;
  }
  
  public final boolean dqI()
  {
    AppMethodBeat.i(284409);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    boolean bool = localf.aHp().getBoolean(ar.a.VBw, true);
    AppMethodBeat.o(284409);
    return bool;
  }
  
  public final boolean dqJ()
  {
    AppMethodBeat.i(284411);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    boolean bool = localf.aHp().getBoolean(ar.a.VBx, true);
    AppMethodBeat.o(284411);
    return bool;
  }
  
  public final boolean dqK()
  {
    AppMethodBeat.i(284413);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    boolean bool = localf.aHp().getBoolean(ar.a.VBy, true);
    AppMethodBeat.o(284413);
    return bool;
  }
  
  public final bhx gW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(284407);
    p.k(paramString1, "path");
    p.k(paramString2, "source");
    paramString1 = (b)this.xsZ.remove(paramString1);
    Log.i("Finder.RedDotManager", "[clearEnterTabTipsExtInfo] result=" + paramString1 + " source=" + paramString2);
    if (paramString1 != null)
    {
      paramString1 = paramString1.xte;
      AppMethodBeat.o(284407);
      return paramString1;
    }
    AppMethodBeat.o(284407);
    return null;
  }
  
  public final void ok(boolean paramBoolean)
  {
    AppMethodBeat.i(284410);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBw, Boolean.valueOf(paramBoolean));
    localObject = com.tencent.mm.plugin.finder.report.n.zWF;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.finder.report.n.gQ(1, i);
      AppMethodBeat.o(284410);
      return;
    }
  }
  
  public final void ol(boolean paramBoolean)
  {
    AppMethodBeat.i(284412);
    if (!paramBoolean)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
      com.tencent.mm.plugin.finder.extension.reddot.nearby.a.aBA("#setEnableShowEntranceRedDot");
    }
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBx, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(284412);
  }
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(284414);
    if (!paramBoolean)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
      com.tencent.mm.plugin.finder.extension.reddot.nearby.a.aBC("#setEnableShowFinderLiveEntranceRedDot");
    }
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBy, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(284414);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(284415);
    Log.i("Finder.RedDotManager", "scene = ".concat(String.valueOf(paramq)));
    if (paramq != null) {
      switch (paramq.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(284415);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.xsL.drz();
      }
    }
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
    Object localObject1 = this.xtb.dqx();
    int i = ((LinkedList)localObject1).size();
    Object localObject2 = d.xsB;
    boolean bool = d.a((LinkedList)localObject1, this.xtb);
    int j = ((LinkedList)localObject1).size();
    Log.i("Finder.RedDotManager", "[prepare] checkRet=" + bool + " beforeCheckCount=" + i + " afterCheckCount=" + j);
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (l)((Iterator)localObject1).next();
      if (((l)localObject2).drI())
      {
        Log.w("Finder.RedDotManager", "[prepare] showInfo is empty! ".concat(String.valueOf(localObject2)));
        ((l)localObject2).b(this.xtb, false);
      }
      else
      {
        localObject3 = ((l)localObject2).field_ctrInfo;
        p.j(localObject3, "it.field_ctrInfo");
        a(((l)localObject2).e((bhw)localObject3), "prepare");
      }
    }
    this.xsR.alive();
    localObject1 = this.xsN;
    com.tencent.mm.plugin.newtips.a.fiN().a("FinderNewTipsTransform", (l.a)localObject1);
    localObject2 = this.xsL;
    localObject1 = ((j)localObject2).xsq.aBf("FinderEntrance");
    if ((localObject1 != null) && (((l)localObject1).field_ctrInfo.type == -1))
    {
      localObject1 = ((l)localObject1).aBy("FinderEntrance");
      if (localObject1 == null) {
        break label705;
      }
      localObject1 = Integer.valueOf(((bkn)localObject1).SVs);
      if (localObject1 != null) {
        break label711;
      }
    }
    for (;;)
    {
      ((j)localObject2).xsq.Mp(1001);
      Log.i("Finder.RedDotTransform", "[checkPostRedDot] has old fav red dot, ret=".concat(String.valueOf(kotlin.x.aazN)));
      localObject1 = com.tencent.mm.plugin.finder.utils.x.AEe;
      com.tencent.mm.plugin.finder.utils.x.d(((j)localObject2).xsq);
      Mp(1005);
      localObject1 = n.xuW;
      p.k(this, "redDotManager");
      n.wVw = this;
      Log.i("Finder.ThreeDayTwoDay", "INIT");
      ((n)localObject1).dsj();
      localObject1 = new e(this);
      ((e)localObject1).xsC.alive();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e.f((e)localObject1));
      e.a((e)localObject1, "setup");
      this.xsP.init();
      Log.i("Finder.RedDotManager", "[prepare] " + (System.currentTimeMillis() - l) + "ms");
      localObject1 = aj.AGc;
      if (aj.eeo() == 1)
      {
        Log.i("Finder.RedDotManager", "FINDER_GLOBAL_FULLSCREEN_ENJOY");
        localObject1 = m.xuU;
        if (!m.drY())
        {
          Log.i("Finder.RedDotManager", "fullScreenTabShowed showed");
          Log.i("Finder.RedDotManager", "generateFullScreenRedDot");
          localObject1 = new bhw();
          ((bhw)localObject1).SQm = String.valueOf(cm.bfE());
          ((bhw)localObject1).priority = 10011000;
          ((bhw)localObject1).type = 1012;
          ((bhw)localObject1).tnN = 604800;
          localObject2 = new bhx();
          localObject3 = new bkf();
          ((bkf)localObject3).SVh = 7;
          ((bhx)localObject2).tabTipsByPassInfo = new com.tencent.mm.cd.b(((bkf)localObject3).toByteArray());
          ((bhx)localObject2).tab_type = 4;
          ((bhw)localObject1).SSl = new com.tencent.mm.cd.b(((bhx)localObject2).toByteArray());
          localObject2 = new bkn();
          ((bkn)localObject2).CKC = 6;
          ((bkn)localObject2).title = "NEW";
          ((bkn)localObject2).SVs = 1;
          ((bkn)localObject2).path = "finder_tl_hot_tab";
          ((bhw)localObject1).MFx.add(localObject2);
          a(this, (bhw)localObject1, "generateFullScreenRedDot", null, true, null, null, 52);
          localObject1 = m.xuU;
          m.oo(true);
        }
      }
      AppMethodBeat.o(178168);
      return;
      label705:
      localObject1 = null;
      break;
      label711:
      if (((Integer)localObject1).intValue() == 2)
      {
        ((j)localObject2).xsq.Mp(-1);
        Log.i("Finder.RedDotTransform", "[checkPostRedDot] has old post red dot, ret=".concat(String.valueOf(kotlin.x.aazN)));
        ((j)localObject2).drA();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$Companion;", "", "()V", "TAB_TIPS_TEST", "", "getTAB_TIPS_TEST", "()Z", "setTAB_TIPS_TEST", "(Z)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    public static final aa xtE;
    
    static
    {
      AppMethodBeat.i(178163);
      xtE = new aa();
      AppMethodBeat.o(178163);
    }
    
    aa()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    public static final ab xtF;
    
    static
    {
      AppMethodBeat.i(220946);
      xtF = new ab();
      AppMethodBeat.o(220946);
    }
    
    ab()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$revokePathRedDot$2$2"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    ac(bif parambif, aa.a parama1, aa.a parama2, f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ad
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    ad(f paramf, big parambig)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$EnterTabTipsExtInfo;", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "tipsId", "", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;Ljava/lang/String;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getTipsId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class b
  {
    final bhx xte;
    final String xtf;
    
    public b(bhx parambhx, String paramString)
    {
      AppMethodBeat.i(285891);
      this.xte = parambhx;
      this.xtf = paramString;
      AppMethodBeat.o(285891);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(285894);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.xte, paramObject.xte)) || (!p.h(this.xtf, paramObject.xtf))) {}
        }
      }
      else
      {
        AppMethodBeat.o(285894);
        return true;
      }
      AppMethodBeat.o(285894);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(285893);
      Object localObject = this.xte;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.xtf;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(285893);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(285892);
      String str = "EnterTabTipsExtInfo(ext=" + this.xte + ", tipsId=" + this.xtf + ")";
      AppMethodBeat.o(285892);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "", "tabType", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "getTabType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class c
  {
    public static final a xth;
    final int fEH;
    final bko xtg;
    
    static
    {
      AppMethodBeat.i(282632);
      xth = new a((byte)0);
      AppMethodBeat.o(282632);
    }
    
    public c(int paramInt, bko parambko)
    {
      AppMethodBeat.i(282631);
      this.fEH = paramInt;
      this.xtg = parambko;
      AppMethodBeat.o(282631);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(282635);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.fEH != paramObject.fEH) || (!p.h(this.xtg, paramObject.xtg))) {}
        }
      }
      else
      {
        AppMethodBeat.o(282635);
        return true;
      }
      AppMethodBeat.o(282635);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(282634);
      int j = this.fEH;
      bko localbko = this.xtg;
      if (localbko != null) {}
      for (int i = localbko.hashCode();; i = 0)
      {
        AppMethodBeat.o(282634);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(282633);
      String str = "FinderTipsShowTabExt(tabType=" + this.fEH + ", ext=" + this.xtg + ")";
      AppMethodBeat.o(282633);
      return str;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt$Companion;", "", "()V", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "tabType", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "plugin-finder_release"})
    public static final class a
    {
      public static f.c a(int paramInt, f paramf)
      {
        int j = 0;
        Object localObject2 = null;
        AppMethodBeat.i(288871);
        p.k(paramf, "manager");
        Object localObject1 = f.Mo(paramInt);
        paramf = paramf.aBf((String)localObject1);
        bko localbko;
        label92:
        label116:
        boolean bool;
        if (paramf != null)
        {
          paramf = paramf.aBy((String)localObject1);
          localbko = new bko();
          StringBuilder localStringBuilder = new StringBuilder("[FinderTipsShowTabExt#transform] tabType=").append(paramInt).append(" path=").append((String)localObject1).append(" show_ext_info_type=");
          if (paramf == null) {
            break label242;
          }
          localObject1 = Integer.valueOf(paramf.SVt);
          localStringBuilder = localStringBuilder.append(localObject1).append(" show_ext_info=");
          if (paramf == null) {
            break label248;
          }
          localObject1 = paramf.SVu;
          if (localObject1 == null) {
            break label254;
          }
          bool = true;
          label124:
          Log.i("Finder.RedDotManager", bool);
          if ((paramf == null) || (paramf.SVt != 2) || (paramf.SVu == null)) {
            break label260;
          }
          localObject1 = paramf.SVu;
          paramf = localObject2;
          if (localObject1 != null) {
            paramf = ((com.tencent.mm.cd.b)localObject1).toByteArray();
          }
          localbko.parseFrom(paramf);
          Log.i("Finder.RedDotManager", "tabType=" + paramInt + " serverJumpPriority=" + localbko.SVB);
        }
        label242:
        label248:
        label254:
        while (paramf == null)
        {
          paramf = new f.c(paramInt, localbko);
          AppMethodBeat.o(288871);
          return paramf;
          paramf = null;
          break;
          localObject1 = null;
          break label92;
          localObject1 = null;
          break label116;
          bool = false;
          break label124;
        }
        label260:
        int i = j;
        switch (paramInt)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          localbko.SVB = i;
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    public static final d xti;
    
    static
    {
      AppMethodBeat.i(280096);
      xti = new d();
      AppMethodBeat.o(280096);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$buildPathWithCtrInfo$1$1"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    e(f paramf, l paraml, HashSet paramHashSet)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Integer>
  {
    public static final f xtm;
    
    static
    {
      AppMethodBeat.i(178152);
      xtm = new f();
      AppMethodBeat.o(178152);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Long>
  {
    public static final g xtn;
    
    static
    {
      AppMethodBeat.i(178154);
      xtn = new g();
      AppMethodBeat.o(178154);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$clearCtrlInfo$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    h(f paramf, l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final i xtp;
    
    static
    {
      AppMethodBeat.i(279092);
      xtp = new i();
      AppMethodBeat.o(279092);
    }
    
    i()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    j(Map.Entry paramEntry)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final k xtq;
    
    static
    {
      AppMethodBeat.i(228408);
      xtq = new k();
      AppMethodBeat.o(228408);
    }
    
    k()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final l xtr;
    
    static
    {
      AppMethodBeat.i(266031);
      xtr = new l();
      AppMethodBeat.o(266031);
    }
    
    l()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final m xts;
    
    static
    {
      AppMethodBeat.i(287330);
      xts = new m();
      AppMethodBeat.o(287330);
    }
    
    m()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final n xtt;
    
    static
    {
      AppMethodBeat.i(285245);
      xtt = new n();
      AppMethodBeat.o(285245);
    }
    
    n()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    o(int[] paramArrayOfInt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final p xtv;
    
    static
    {
      AppMethodBeat.i(278373);
      xtv = new p();
      AppMethodBeat.o(278373);
    }
    
    p()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final q xtw;
    
    static
    {
      AppMethodBeat.i(257056);
      xtw = new q();
      AppMethodBeat.o(257056);
    }
    
    q()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class r
    extends IListener<fw>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    public static final s xtx;
    
    static
    {
      AppMethodBeat.i(285178);
      xtx = new s();
      AppMethodBeat.o(285178);
    }
    
    s()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final t xty;
    
    static
    {
      AppMethodBeat.i(275886);
      xty = new t();
      AppMethodBeat.o(275886);
    }
    
    t()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, Boolean>
  {
    public static final u xtz;
    
    static
    {
      AppMethodBeat.i(288626);
      xtz = new u();
      AppMethodBeat.o(288626);
    }
    
    u()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class v<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(249983);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((l)paramT1).field_time), (Comparable)Long.valueOf(((l)paramT2).field_time));
      AppMethodBeat.o(249983);
      return i;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "local", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$notifyRedDot$2$2"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.b<l, kotlin.x>
  {
    w(f paramf, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    public static final x xtB;
    
    static
    {
      AppMethodBeat.i(178161);
      xtB = new x();
      AppMethodBeat.o(178161);
    }
    
    x()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    public static final y xtC;
    
    static
    {
      AppMethodBeat.i(288469);
      xtC = new y();
      AppMethodBeat.o(288469);
    }
    
    y()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    public static final z xtD;
    
    static
    {
      AppMethodBeat.i(264947);
      xtD = new z();
      AppMethodBeat.o(264947);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.f
 * JD-Core Version:    0.7.0.1
 */