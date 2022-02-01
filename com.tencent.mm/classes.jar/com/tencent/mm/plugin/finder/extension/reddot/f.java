package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRedDotManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;)V", "careExptKey", "", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enterSource", "", "enterTabTipsExtInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$EnterTabTipsExtInfo;", "enterTime", "", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1;", "hasRedDotWhenEnter", "", "msgRedDotHandler", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "getMsgRedDotHandler", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "newTipsTransform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "noFoundRevokeIdSet", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTipsInfo;", "pathToCtrInfoMap", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "revokeIdToCtrInfoMap", "stateCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stayDuration", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "getTransform", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "addNewRedDotCtrlInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "changePathSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "isClearOldSameType", "clearedEntrancePair", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "buildPathWithCtrInfo", "local", "checkRedDotOverride", "", "path", "ctrlInfo", "lastCtrlInfo", "lastShowInfo", "clearCtrlInfo", "ctrInfo", "type", "filter", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "clearEnterTabTipsExtInfo", "enterCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "containsTabTipsExtInfo", "tabType", "ctrlInfoAtPath", "disposeRedDotAtPath", "call", "ctrlType", "", "enterFinder", "exitFinder", "exitFinderBefore", "filterNotifyTabTip", "tabTip", "Lcom/tencent/mm/protocal/protobuf/FinderTabTipsInfo;", "findByRevokeId", "revokeId", "findExtInfoAtCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "generateFullScreenRedDot", "getAliveTabType", "getAllCtrlInfo", "", "getCtrlInfoByPath", "getCtrlInfoMap", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "getDiffExitTimeMs", "getEnterTabTipsExtInfo", "getEnterTabTypeInCtrlInfo", "getLastCtrlInfo", "ctrlInfoMap", "getLatestCtrlInfo", "ctrlInfo1", "ctrlInfo2", "getNearbyAliveTabType", "getNearbyDiffExitTimeMs", "getTabPathByTabType", "getTabTipsExtInfo", "getTabTypeByPath", "getTipsShowInfoAtPath", "increaseRedDotExpose", "insertDataForTest", "count", "isEnableShowEntranceRedDot", "mergeFinderMentionCtrlInfo", "notifyFinderFansAddCount", "notifyFinderMsgCount", "likeCount", "commentCount", "followCount", "notifyRedDot", "redDot", "Lcom/tencent/mm/protocal/protobuf/FinderRedDot;", "notifyTabTip", "tabTips", "Lcom/tencent/mm/protocal/protobuf/FinderTabTips;", "notifyWxMentionCount", "wxMention", "Lcom/tencent/mm/protocal/protobuf/FinderWxMentionCount;", "onExptChange", "key", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "printCtrInfo", "printTipsShowInfo", "index", "reBuildPathWithCtrInfo", "recordCtrlInfo", "clearedCtrlInfo", "removeFinderEntrance", "removeNearbyEntrance", "reportOverride", "beforePair", "resetNotifyAllPathWithCrlInfo", "revokePathRedDot", "revoke", "Lcom/tencent/mm/protocal/protobuf/FinderRevokePathRedDot;", "revokeTabTips", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTips;", "saveEnterTabTipsExtInfo", "setEnableShowEntranceRedDot", "isEnable", "updateFindMoreFriendUI", "Companion", "EnterTabTipsExtInfo", "FinderTipsShowTabExt", "plugin-finder_release"})
public final class f
  implements i, z
{
  private static boolean tJO;
  public static final a tJP;
  private long enterTime;
  public final j tJA;
  public final a tJB;
  private final b tJC;
  private final FinderHomeTabStateVM tJD;
  private final List<com.tencent.mm.plugin.expt.b.b.a> tJE;
  private final l tJF;
  private long tJG;
  private int tJH;
  private boolean tJI;
  public final ConcurrentHashMap<String, List<k>> tJJ;
  private final ConcurrentHashMap<String, k> tJK;
  private final ConcurrentHashMap<String, b> tJL;
  private final ConcurrentHashMap<String, bbr> tJM;
  public final c tJN;
  
  static
  {
    AppMethodBeat.i(178166);
    tJP = new a((byte)0);
    AppMethodBeat.o(178166);
  }
  
  public f(c paramc)
  {
    AppMethodBeat.i(178184);
    this.tJN = paramc;
    this.tJA = new j(this);
    this.tJB = new a(this);
    this.tJC = new b(this);
    paramc = com.tencent.mm.ui.component.a.PRN;
    paramc = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramc, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tJD = ((FinderHomeTabStateVM)paramc);
    this.tJE = kotlin.a.j.listOf(com.tencent.mm.plugin.expt.b.b.a.scU);
    this.tJF = new l(this);
    this.tJJ = new ConcurrentHashMap();
    this.tJK = new ConcurrentHashMap();
    this.tJL = new ConcurrentHashMap();
    this.tJM = new ConcurrentHashMap();
    AppMethodBeat.o(178184);
  }
  
  public static String Ix(int paramInt)
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
  
  public static int a(k paramk)
  {
    AppMethodBeat.i(243588);
    if ((paramk.atl("TLWxPrivateMsgBubble") != null) || (paramk.atl("TLWxBubble") != null))
    {
      AppMethodBeat.o(243588);
      return 1;
    }
    if (paramk.atl("TLFollow") != null)
    {
      i = asY("TLFollow");
      AppMethodBeat.o(243588);
      return i;
    }
    if (paramk.atl("TLRecommendTab") != null)
    {
      i = asY("TLRecommendTab");
      AppMethodBeat.o(243588);
      return i;
    }
    if (paramk.atl("finder_tl_hot_tab") != null)
    {
      i = asY("finder_tl_hot_tab");
      AppMethodBeat.o(243588);
      return i;
    }
    if (paramk.atl("finder_tl_nearby_tab") != null)
    {
      i = asY("finder_tl_nearby_tab");
      AppMethodBeat.o(243588);
      return i;
    }
    if (paramk.atl("NearbyFeedTab") != null)
    {
      i = asY("NearbyFeedTab");
      AppMethodBeat.o(243588);
      return i;
    }
    if (paramk.atl("NearbyLiveTab") != null)
    {
      i = asY("NearbyLiveTab");
      AppMethodBeat.o(243588);
      return i;
    }
    if (paramk.atl("NearbyPeopleTab") != null)
    {
      i = asY("NearbyPeopleTab");
      AppMethodBeat.o(243588);
      return i;
    }
    int i = paramk.tLm.tab_type;
    if (i != 0)
    {
      AppMethodBeat.o(243588);
      return i;
    }
    AppMethodBeat.o(243588);
    return -1;
  }
  
  private k a(bbi parambbi, String paramString, HashSet<String> paramHashSet, boolean paramBoolean, o<k, ? extends bdo> paramo)
  {
    AppMethodBeat.i(243568);
    p.h(paramString, "source");
    p.h(paramHashSet, "changePathSet");
    if (parambbi == null)
    {
      AppMethodBeat.o(243568);
      return null;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    if (paramo != null)
    {
      localObject1 = (k)paramo.first;
      localObject3 = null;
      localObject2 = localObject3;
      if (parambbi != null)
      {
        localObject2 = parambbi.GaM;
        p.g(localObject2, "show_infos");
        localObject4 = ((Iterable)localObject2).iterator();
        do
        {
          localObject2 = localObject3;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
        } while (!p.j("FinderEntrance", ((bdo)((Iterator)localObject4).next()).path));
        localObject3 = asX("FinderEntrance");
        if (!p.j(localObject3, localObject1)) {
          break label345;
        }
        localObject2 = localObject3;
      }
      label143:
      if (paramo == null) {
        break label433;
      }
      localObject1 = (k)paramo.first;
      label158:
      if (!p.j(localObject2, localObject1)) {
        break label445;
      }
      if (paramo == null) {
        break label439;
      }
      paramo = (bdo)paramo.second;
    }
    for (;;)
    {
      if (paramBoolean) {
        Iy(parambbi.type);
      }
      if (!daH())
      {
        localObject1 = parambbi.GaM;
        p.g(localObject1, "info.show_infos");
        com.tencent.mm.ac.d.a((LinkedList)localObject1, (kotlin.g.a.b)d.tJU);
        Log.i("Finder.RedDotManager", "[addNewRedDotCtrlInfo] remove DISCOVERY_TAB");
      }
      localObject4 = new k().f(parambbi);
      ConcurrentHashMap localConcurrentHashMap = this.tJM;
      localObject3 = ((k)localObject4).field_revokeId;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      if (!localConcurrentHashMap.contains(localObject1)) {
        break label469;
      }
      Log.e("Finder.RedDotManager", "[addNewRedDotCtrlInfo] has revoke. " + ((k)localObject4).field_revokeId + ' ' + c(((k)localObject4).field_ctrInfo));
      AppMethodBeat.o(243568);
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
        if (((k)localObject3).field_ctrInfo.priority >= ((k)localObject1).field_ctrInfo.priority)
        {
          localObject2 = localObject3;
          if (((k)localObject3).field_ctrInfo.priority != ((k)localObject3).field_ctrInfo.priority) {
            break label143;
          }
          localObject2 = localObject3;
          if (((k)localObject3).field_time >= ((k)localObject1).field_time) {
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
        paramo = ((k)localObject2).atl("FinderEntrance");
      } else {
        paramo = null;
      }
    }
    label469:
    if (k.a((k)localObject4, this.tJN))
    {
      paramHashSet.addAll((Collection)a((k)localObject4, paramString));
      paramHashSet = new o(localObject2, paramo);
      paramString = atb("FinderEntrance");
      if (paramString != null)
      {
        paramString = (k)paramString.first;
        paramo = (k)paramHashSet.first;
        localObject1 = (bdo)paramHashSet.second;
        if (!Util.isNullOrNil("FinderEntrance")) {
          break label781;
        }
        Log.e("Finder.RedDotManager", "path: " + "FinderEntrance" + " is empty!");
        paramString = m.tLw;
        p.h(parambbi, "ctrlInfo");
        Log.i("Finder.ThreeDayTwoDay", "checkRedDotFilter");
        if (!paramString.dbV()) {
          break label968;
        }
        parambbi = com.tencent.mm.kernel.g.aAh();
        p.g(parambbi, "MMKernel.storage()");
        long l1 = parambbi.azQ().a(ar.a.OmA, 0L);
        if (l1 == 0L) {
          break label968;
        }
        long l2 = cl.aWA() - l1;
        parambbi = com.tencent.mm.plugin.finder.storage.c.vCb;
        i = ((Number)com.tencent.mm.plugin.finder.storage.c.duK().value()).intValue();
        if (i < l2) {
          break label956;
        }
        paramBoolean = true;
        Log.i("Finder.ThreeDayTwoDay", "[checkInLimitTwoDay] isInLimit=" + paramBoolean + " twoDayThreshold=" + i + " diffTime=" + l2 + " hitThreeDayTime=" + l1);
        if (!paramBoolean) {
          break label962;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          parambbi = m.toy;
          if (parambbi != null) {
            parambbi.asV("FinderEntrance");
          }
        }
        AppMethodBeat.o(243568);
        return localObject4;
        paramString = null;
        break;
        if ((paramo == null) || (!(p.j(paramo, paramString) ^ true))) {
          break label586;
        }
        localObject2 = new StringBuilder("20951, ").append(paramo.field_ctrInfo.type).append(" show_type:");
        if (localObject1 != null)
        {
          paramHashSet = Integer.valueOf(((bdo)localObject1).xGz);
          localObject2 = ((StringBuilder)localObject2).append(paramHashSet).append(" field_tipsId: ").append(paramo.field_tipsId).append(" ctrlInfo.field_tipsId: ");
          if (paramString == null) {
            break label951;
          }
        }
        for (paramHashSet = paramString.field_tipsId;; paramHashSet = null)
        {
          Log.i("Finder.RedDotManager", paramHashSet);
          paramHashSet = y.vXH;
          if ((paramo == null) || (localObject1 == null)) {
            break;
          }
          paramHashSet = com.tencent.mm.plugin.finder.report.j.vft;
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
          com.tencent.mm.plugin.finder.report.j.a(paramo, (bdo)localObject1, 6, 0, null, paramString, 24);
          break;
          paramHashSet = null;
          break label840;
        }
        paramBoolean = false;
        break label682;
        m.reset(cl.aWA());
      }
    }
    label586:
    AppMethodBeat.o(243568);
    label682:
    label840:
    return null;
  }
  
  private static String a(bdo parambdo, int paramInt)
  {
    AppMethodBeat.i(178181);
    if (parambdo == null)
    {
      AppMethodBeat.o(178181);
      return "[empty]";
    }
    Object localObject1 = null;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject2 = new bdp();
      com.tencent.mm.bw.b localb = parambdo.LNo;
      localObject1 = localObject2;
      if (localb != null)
      {
        ((bdp)localObject2).parseFrom(localb.toByteArray());
        localObject1 = localObject2;
      }
    }
    Object localObject2 = new StringBuilder("#").append(paramInt).append("{showType=").append(parambdo.xGz).append(" count=").append(parambdo.count).append(" title=").append(parambdo.title).append(' ').append("clearType=").append(parambdo.LNm).append(" iconUrl=").append(parambdo.qGB).append(" path=").append(parambdo.path).append(" show_ext_info_type=").append(parambdo.LNn).append(" parent=").append(parambdo.Bvg).append(' ');
    if (localObject1 != null) {}
    for (parambdo = "jumpPriority=" + localObject1.LNr;; parambdo = "")
    {
      parambdo = parambdo + "} ";
      AppMethodBeat.o(178181);
      return parambdo;
    }
  }
  
  private final boolean a(bdj parambdj)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    int i = -1;
    AppMethodBeat.i(243583);
    Object localObject1 = parambdj.LNi;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((bbi)localObject1).type);
      if (localObject1 != null) {
        break label74;
      }
      label40:
      if (localObject1 != null) {
        break label283;
      }
      if (localObject1 != null) {
        break label296;
      }
      label50:
      if (localObject1 != null) {
        break label309;
      }
      label55:
      if (localObject1 != null) {
        break label322;
      }
    }
    label60:
    label74:
    label84:
    Object localObject5;
    int j;
    label169:
    label222:
    label227:
    label358:
    label363:
    label378:
    do
    {
      AppMethodBeat.o(243583);
      return true;
      localObject1 = null;
      break;
      if (((Integer)localObject1).intValue() != 8) {
        break label40;
      }
      if (tJO)
      {
        localObject5 = parambdj.LNi;
        if (localObject5 != null)
        {
          localObject5 = ((bbi)localObject5).GaM;
          if (localObject5 != null) {
            kotlin.a.j.c((List)localObject5, (kotlin.g.a.b)m.tKd);
          }
        }
        tJO = false;
      }
      localObject5 = parambdj.LNi;
      if (localObject5 != null)
      {
        localObject5 = ((bbi)localObject5).GaM;
        if (localObject5 != null)
        {
          localObject5 = ((List)localObject5).iterator();
          j = 0;
          if (((Iterator)localObject5).hasNext())
          {
            bdo localbdo = (bdo)((Iterator)localObject5).next();
            if ((p.j(localbdo.path, "FinderEntrance")) || (p.j(localbdo.path, "NearbyEntrance")))
            {
              k = 1;
              if (k == 0) {
                break label341;
              }
              if (j < 0) {
                break label363;
              }
              localObject1 = new StringBuilder("[filterNotifyTabTip] has FINDER_ENTRANCE or NEARBY_ENTRANCE this tabTip type=");
              parambdj = parambdj.LNi;
              if (parambdj == null) {
                break label358;
              }
            }
          }
        }
      }
      for (parambdj = Integer.valueOf(parambdj.type);; parambdj = null)
      {
        Log.i("Finder.RedDotManager", parambdj);
        AppMethodBeat.o(243583);
        return true;
        if (((Integer)localObject1).intValue() == 7) {
          break label84;
        }
        break;
        if (((Integer)localObject1).intValue() == 9) {
          break label84;
        }
        break label50;
        if (((Integer)localObject1).intValue() == 13) {
          break label84;
        }
        break label55;
        if (((Integer)localObject1).intValue() != 16) {
          break label60;
        }
        break label84;
        k = 0;
        break label222;
        j += 1;
        break label169;
        j = -1;
        break label227;
        j = -1;
        break label227;
      }
      if (localObject1 != null) {
        break label569;
      }
      if (localObject1 != null) {
        break label722;
      }
      if (localObject1 != null) {
        break label784;
      }
      if (localObject1 != null) {
        break label970;
      }
    } while ((localObject1 == null) || (((Integer)localObject1).intValue() != 16));
    label283:
    label296:
    label309:
    label322:
    label341:
    localObject1 = (List)this.tJJ.get("NearbyEntrance");
    int k = i;
    if (localObject1 != null) {}
    label770:
    label776:
    label784:
    label794:
    label1061:
    for (;;)
    {
      try
      {
        label569:
        label579:
        label722:
        label874:
        StringBuilder localStringBuilder;
        for (;;)
        {
          localObject4 = ((List)localObject1).iterator();
          j = 0;
          k = i;
          if (((Iterator)localObject4).hasNext())
          {
            k = ((k)((Iterator)localObject4).next()).field_ctrInfo.type;
            if (k != 16) {
              break label1036;
            }
            k = 1;
            if (k == 0) {
              break label1042;
            }
            k = j;
          }
          if (k < 0) {
            break label1061;
          }
          bool = true;
          localObject1 = new StringBuilder("[filterNotifyTabTip] ignore[").append(bool).append("] this tabTip type=");
          localObject4 = parambdj.LNi;
          parambdj = (bdj)localObject3;
          if (localObject4 != null) {
            parambdj = Integer.valueOf(((bbi)localObject4).type);
          }
          Log.i("Finder.RedDotManager", parambdj);
          if (bool) {
            break label1067;
          }
          AppMethodBeat.o(243583);
          return true;
          if (((Integer)localObject1).intValue() != 8) {
            break;
          }
          parambdj = (List)this.tJJ.get("FinderEntrance");
          if (parambdj != null) {}
          for (;;)
          {
            try
            {
              localObject3 = parambdj.iterator();
              i = 0;
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (k)((Iterator)localObject3).next();
                if (((k)localObject4).field_ctrInfo.type != 8)
                {
                  j = ((k)localObject4).field_ctrInfo.type;
                  if (j != 9) {}
                }
                else
                {
                  j = 1;
                  if (j == 0) {
                    continue;
                  }
                  if (i < 0) {
                    break label770;
                  }
                  bool = true;
                  Log.i("Finder.RedDotManager", "[filterNotifyTabTip] ignore[" + bool + "] this tabTip type=" + localObject1);
                  if (bool) {
                    break label776;
                  }
                  AppMethodBeat.o(243583);
                  return true;
                  if (((Integer)localObject1).intValue() != 9) {
                    break;
                  }
                  break label579;
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
            bool = false;
          }
          AppMethodBeat.o(243583);
          return false;
          if (localObject2.intValue() != 7) {
            break label378;
          }
          localObject3 = (List)this.tJJ.get("FinderEntrance");
          k = i;
          if (localObject3 != null) {}
          try
          {
            localObject5 = ((List)localObject3).iterator();
            j = 0;
            for (;;)
            {
              k = i;
              if (((Iterator)localObject5).hasNext())
              {
                k = ((k)((Iterator)localObject5).next()).field_ctrInfo.type;
                if (k == 7) {
                  break label997;
                }
                if (localObject2 != null) {
                  break label983;
                }
              }
              label970:
              label983:
              label997:
              for (k = 0;; k = 1)
              {
                if (k == 0) {
                  break label1003;
                }
                k = j;
                if (k < 0) {
                  break label1022;
                }
                bool = true;
                localStringBuilder = new StringBuilder("[filterNotifyTabTip] ignore[").append(bool).append("] this tabTip type=");
                localObject3 = parambdj.LNi;
                parambdj = (bdj)localObject4;
                if (localObject3 != null) {
                  parambdj = Integer.valueOf(((bbi)localObject3).type);
                }
                Log.i("Finder.RedDotManager", parambdj);
                if (bool) {
                  break label1028;
                }
                AppMethodBeat.o(243583);
                return true;
                if (localStringBuilder.intValue() != 13) {
                  break;
                }
                break label794;
                k = localStringBuilder.intValue();
                if (k != 13) {
                  break label874;
                }
              }
              label1003:
              j += 1;
            }
            bool = false;
          }
          finally {}
        }
        label1022:
        continue;
        AppMethodBeat.o(243583);
        return false;
        k = 0;
        continue;
        j += 1;
        continue;
        boolean bool = false;
      }
      finally
      {
        AppMethodBeat.o(243583);
      }
    }
    label1028:
    label1036:
    label1042:
    label1067:
    AppMethodBeat.o(243583);
    return false;
  }
  
  private static int asY(String paramString)
  {
    AppMethodBeat.i(243576);
    p.h(paramString, "path");
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
                  AppMethodBeat.o(243576);
                  return -1;
                } while (!paramString.equals("NearbyFeedTab"));
                AppMethodBeat.o(243576);
                return 1002;
              } while (!paramString.equals("TLFollow"));
              AppMethodBeat.o(243576);
              return 3;
            } while (!paramString.equals("NearbyLiveTab"));
            AppMethodBeat.o(243576);
            return 1001;
          } while (!paramString.equals("finder_tl_hot_tab"));
          AppMethodBeat.o(243576);
          return 4;
        } while (!paramString.equals("NearbyPeopleTab"));
        AppMethodBeat.o(243576);
        return 1003;
      } while (!paramString.equals("finder_tl_nearby_tab"));
      AppMethodBeat.o(243576);
      return 2;
    } while (!paramString.equals("TLRecommendTab"));
    AppMethodBeat.o(243576);
    return 1;
  }
  
  private final o<k, bdo> atb(String paramString)
  {
    AppMethodBeat.i(243601);
    paramString = asX(paramString);
    if (paramString != null)
    {
      paramString = new o(paramString, paramString.atl("FinderEntrance"));
      AppMethodBeat.o(243601);
      return paramString;
    }
    AppMethodBeat.o(243601);
    return null;
  }
  
  private final HashMap<String, LinkedList<k>> b(int paramInt, kotlin.g.a.b<? super k, Boolean> paramb)
  {
    AppMethodBeat.i(243580);
    Log.i("Finder.RedDotManager", "getCtrlInfoMap type:".concat(String.valueOf(paramInt)));
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = ((Map)this.tJJ).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (Map.Entry)localIterator1.next();
      String str = (String)((Map.Entry)localObject).getKey();
      synchronized ((Iterable)((Map.Entry)localObject).getValue())
      {
        Iterator localIterator2 = ???.iterator();
        while (localIterator2.hasNext())
        {
          k localk = (k)localIterator2.next();
          if (((localk.field_ctrInfo.type == paramInt) || (paramInt == -2147483648)) && (((Boolean)paramb.invoke(localk)).booleanValue()))
          {
            LinkedList localLinkedList = (LinkedList)localHashMap.get(str);
            localObject = localLinkedList;
            if (localLinkedList == null)
            {
              localObject = new LinkedList();
              ((Map)localHashMap).put(str, localObject);
            }
            p.g(localObject, "ctrlInfoMap[path] ?: run…ist\n                    }");
            ((LinkedList)localObject).add(localk);
          }
        }
      }
      localObject = x.SXb;
    }
    AppMethodBeat.o(243580);
    return localHashMap;
  }
  
  private final o<k, bdo> b(bbi parambbi)
  {
    AppMethodBeat.i(243574);
    parambbi = parambbi.GaM;
    if (parambbi != null)
    {
      parambbi = ((Iterable)parambbi).iterator();
      while (parambbi.hasNext()) {
        if (p.j(((bdo)parambbi.next()).path, "FinderEntrance"))
        {
          parambbi = atb("FinderEntrance");
          AppMethodBeat.o(243574);
          return parambbi;
        }
      }
    }
    AppMethodBeat.o(243574);
    return null;
  }
  
  public static String c(bbi parambbi)
  {
    AppMethodBeat.i(178180);
    if (parambbi == null)
    {
      AppMethodBeat.o(178180);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = parambbi.GaM;
    p.g(localObject1, "info.show_infos");
    localObject1 = (Iterable)localObject1;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localStringBuilder.append(a((bdo)localObject2, i));
      i += 1;
    }
    parambbi = "CtrlInfo{tipsId=" + parambbi.LKM + " priority=" + parambbi.priority + " type=" + parambbi.type + " expired=" + parambbi.pRN + " tipsShowInfo=" + localStringBuilder + '}';
    AppMethodBeat.o(178180);
    return parambbi;
  }
  
  public static void d(bbi parambbi)
  {
    AppMethodBeat.i(243599);
    Object localObject1;
    Object localObject2;
    if (parambbi != null)
    {
      localObject1 = parambbi.GaM;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (p.j(((bdo)localObject1).path, "FinderEntrance"))
          {
            localObject1 = (bdo)localObject1;
            label66:
            if (parambbi == null) {
              break label148;
            }
            localObject2 = parambbi.GaM;
            if (localObject2 == null) {
              break label148;
            }
          }
        }
      }
    }
    label148:
    for (boolean bool = com.tencent.mm.ac.d.a((LinkedList)localObject2, (kotlin.g.a.b)u.tKk);; bool = false)
    {
      if (bool)
      {
        localObject2 = y.vXH;
        if ((parambbi != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.j.vft;
          com.tencent.mm.plugin.finder.report.j.a(new k().f(parambbi), (bdo)localObject1, 5, 2, null, null, 48);
        }
      }
      AppMethodBeat.o(243599);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label66;
    }
  }
  
  private static long daD()
  {
    AppMethodBeat.i(243566);
    long l1 = cl.aWA();
    l locall = l.tLu;
    long l2 = l.dbO();
    AppMethodBeat.o(243566);
    return l1 - l2;
  }
  
  private static long daE()
  {
    AppMethodBeat.i(243567);
    long l1 = cl.aWA();
    l locall = l.tLu;
    long l2 = l.dbP();
    AppMethodBeat.o(243567);
    return l1 - l2;
  }
  
  private static void e(bbi parambbi)
  {
    AppMethodBeat.i(243600);
    Object localObject1;
    Object localObject2;
    if (parambbi != null)
    {
      localObject1 = parambbi.GaM;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (p.j(((bdo)localObject1).path, "NearbyEntrance"))
          {
            localObject1 = (bdo)localObject1;
            label66:
            if (parambbi == null) {
              break label148;
            }
            localObject2 = parambbi.GaM;
            if (localObject2 == null) {
              break label148;
            }
          }
        }
      }
    }
    label148:
    for (boolean bool = com.tencent.mm.ac.d.a((LinkedList)localObject2, (kotlin.g.a.b)v.tKl);; bool = false)
    {
      if (bool)
      {
        localObject2 = y.vXH;
        if ((parambbi != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.j.vft;
          com.tencent.mm.plugin.finder.report.j.a(new k().f(parambbi), (bdo)localObject1, 5, 2, null, null, 48);
        }
      }
      AppMethodBeat.o(243600);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label66;
    }
  }
  
  private void i(String paramString, kotlin.g.a.b<? super k, Boolean> paramb)
  {
    AppMethodBeat.i(243572);
    p.h(paramString, "path");
    p.h(paramb, "call");
    Object localObject1 = new HashSet();
    k localk1 = asX(paramString);
    bdo localbdo;
    Object localObject2;
    boolean bool;
    Object localObject3;
    if (localk1 != null)
    {
      localbdo = localk1.atl(paramString);
      localObject2 = com.tencent.mm.kernel.g.af(ad.class);
      p.g(localObject2, "MMKernel.service(IFinder…enModeConfig::class.java)");
      bool = ((ad)localObject2).dxX();
      localObject2 = (List)this.tJJ.get(paramString);
      if (localObject2 != null) {
        p.g(localObject2, "this");
      }
    }
    else
    {
      for (;;)
      {
        k localk2;
        try
        {
          localObject3 = ((List)localObject2).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label272;
          }
          localk2 = (k)((Iterator)localObject3).next();
          if ((!bool) || (localk2.field_ctrInfo.type == 8)) {
            break label206;
          }
          Log.i("Finder.RedDotManager", "[disposeRedDotAtPath] 青少年模式且只看关注的模式下只dispose关注的红点展示, ctrlType:" + localk2.field_ctrInfo.type);
          continue;
          localbdo = null;
        }
        finally
        {
          AppMethodBeat.o(243572);
        }
        break;
        label206:
        if (((Boolean)paramb.invoke(localk2)).booleanValue())
        {
          LinkedList localLinkedList = localk2.atm(paramString);
          if (k.a(localk2, this.tJN)) {
            ((HashSet)localObject1).addAll((Collection)localLinkedList);
          }
          if (localk2.dbz()) {
            ((Iterator)localObject3).remove();
          }
        }
      }
      label272:
      paramb = x.SXb;
    }
    paramb = new StringBuilder("[disposeRedDotAtPath] path=").append(paramString).append(" tipsId=");
    if (localk1 != null)
    {
      paramString = localk1.field_tipsId;
      Log.i("Finder.RedDotManager", paramString + " removePathSet=" + localObject1 + " maybeRemoveShowInfo=" + a(localbdo, 0));
      paramString = ((Iterable)localObject1).iterator();
    }
    for (;;)
    {
      label362:
      if (!paramString.hasNext()) {
        break label487;
      }
      paramb = (String)paramString.next();
      localObject1 = asX(paramb);
      if (localObject1 != null)
      {
        localObject2 = ((k)localObject1).atl(paramb);
        if (localObject2 != null) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label453;
          }
          localObject3 = h.tKR;
          h.a(false, paramb, localbdo, localk1);
          localObject3 = h.tKR;
          h.a(true, paramb, (bdo)localObject2, (k)localObject1);
          break label362;
          paramString = null;
          break;
        }
        label453:
        localObject1 = h.tKR;
        h.a(false, paramb, localbdo, localk1);
      }
      else
      {
        localObject1 = h.tKR;
        h.a(false, paramb, localbdo, localk1);
      }
    }
    label487:
    AppMethodBeat.o(243572);
  }
  
  private static k j(HashMap<String, LinkedList<k>> paramHashMap)
  {
    AppMethodBeat.i(243570);
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
          paramHashMap = (k)paramHashMap;
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
    AppMethodBeat.o(243570);
    return paramHashMap;
  }
  
  private List<k> j(String paramString, kotlin.g.a.b<? super k, Boolean> paramb)
  {
    AppMethodBeat.i(243581);
    p.h(paramString, "path");
    p.h(paramb, "filter");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Map)this.tJJ).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      synchronized (((Map.Entry)localObject2).getValue())
      {
        localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          k localk = (k)((Iterator)localObject2).next();
          if ((((Boolean)paramb.invoke(localk)).booleanValue()) && (localk.atl(paramString) != null)) {
            localHashSet.add(localk);
          }
        }
      }
      localObject2 = x.SXb;
    }
    paramString = kotlin.a.j.p((Iterable)localHashSet);
    AppMethodBeat.o(243581);
    return paramString;
  }
  
  public final FinderTipsShowEntranceExtInfo IA(int paramInt)
  {
    AppMethodBeat.i(243587);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = asZ(Ix(paramInt));
    Log.i("Finder.RedDotManager", "[getTabTipsExtInfo] tabType=" + paramInt + " ext=" + g.a(localFinderTipsShowEntranceExtInfo));
    AppMethodBeat.o(243587);
    return localFinderTipsShowEntranceExtInfo;
  }
  
  public final void Iw(int paramInt)
  {
    AppMethodBeat.i(178170);
    Object localObject = asX("FinderEntrance");
    if ((localObject != null) && (((k)localObject).atl("FinderEntrance") != null))
    {
      this.tJI = true;
      b((k)localObject);
    }
    for (;;)
    {
      this.tJH = paramInt;
      this.enterTime = cl.aWA();
      asV("FinderEntrance");
      asV("Discovery");
      localObject = m.tLw;
      Log.i("Finder.ThreeDayTwoDay", "enterFinder");
      m.dbX();
      this.tJA.dbq();
      Log.i("Finder.RedDotManager", "[enterFinder] hasRedDotWhenEnter=" + this.tJI);
      AppMethodBeat.o(178170);
      return;
      this.tJI = false;
    }
  }
  
  public final void Iy(int paramInt)
  {
    AppMethodBeat.i(243578);
    a(paramInt, (kotlin.g.a.b)i.tKb);
    AppMethodBeat.o(243578);
  }
  
  public final boolean Iz(int paramInt)
  {
    AppMethodBeat.i(243586);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = IA(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("[containsTabTipsExtInfo] tabType=").append(paramInt).append(" isContains=");
    if (localFinderTipsShowEntranceExtInfo.tab_type != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.RedDotManager", bool);
      if (localFinderTipsShowEntranceExtInfo.tab_type == 0) {
        break;
      }
      AppMethodBeat.o(243586);
      return true;
    }
    AppMethodBeat.o(243586);
    return false;
  }
  
  public final HashSet<String> a(final k paramk, String paramString)
  {
    AppMethodBeat.i(243575);
    Log.i("Finder.RedDotManager", "[buildPathWithCtrInfo] source=" + paramString + ' ' + c(paramk.field_ctrInfo) + " revokeId=" + paramk.field_revokeId);
    final HashSet localHashSet = new HashSet();
    Object localObject1 = ((Map)paramk.tLk).entrySet().iterator();
    Map.Entry localEntry;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject1).next();
      paramString = (List)this.tJJ.get(localEntry.getKey());
      if (paramString != null) {
        break label367;
      }
      localObject2 = (f)this;
      paramString = Collections.synchronizedList((List)new LinkedList());
      localObject2 = (Map)((f)localObject2).tJJ;
      Object localObject3 = localEntry.getKey();
      p.g(paramString, "list");
      ((Map)localObject2).put(localObject3, paramString);
    }
    label367:
    for (;;)
    {
      p.g(paramString, "crlInfoList");
      com.tencent.mm.ac.d.a(paramString, (kotlin.g.a.b)new e(this, paramk, localHashSet));
      paramString.add(paramk);
      localObject2 = new kotlin.g.a.b[2];
      localObject2[0] = ((kotlin.g.a.b)f.tJY);
      localObject2[1] = ((kotlin.g.a.b)g.tJZ);
      p.h(localObject2, "selectors");
      kotlin.a.j.a(paramString, (Comparator)new kotlin.b.b.a((kotlin.g.a.b[])localObject2));
      localHashSet.add(localEntry.getKey());
      break;
      paramString = paramk.field_revokeId;
      if (paramString != null) {
        ((Map)this.tJK).put(paramString, paramk);
      }
      paramk = ((Iterable)localHashSet).iterator();
      while (paramk.hasNext())
      {
        paramString = (String)paramk.next();
        localObject1 = h.tKR;
        h.a(true, paramString, asW(paramString), asX(paramString));
      }
      AppMethodBeat.o(243575);
      return localHashSet;
    }
  }
  
  public final void a(bbh parambbh)
  {
    AppMethodBeat.i(178171);
    p.h(parambbh, "redDot");
    long l = cl.aWA();
    Object localObject = l.tLu;
    l -= l.dbO();
    Log.i("Finder.RedDotManager", "[notifyRedDot] diffTime=" + l + " newMsgTipsEnterInterval=" + l.tLu.dbH() + " showRed=" + parambbh.LKI + ' ' + c(parambbh.LKJ));
    if (l < l.tLu.dbH())
    {
      d(parambbh.LKJ);
      localObject = parambbh.LKJ;
      if (localObject != null)
      {
        localObject = ((bbi)localObject).GaM;
        if (localObject != null) {
          com.tencent.mm.ac.d.a((LinkedList)localObject, (kotlin.g.a.b)q.tKg);
        }
      }
    }
    parambbh = parambbh.LKK;
    p.g(parambbh, "redDot.ctrl_info_list");
    parambbh = ((Iterable)parambbh).iterator();
    while (parambbh.hasNext())
    {
      localObject = (bbi)parambbh.next();
      if (((bbi)localObject).type == 2)
      {
        p.g(localObject, "it");
        a((bbi)localObject);
      }
      a(this, (bbi)localObject, "notifyRedDot", null, true, null, 20);
    }
    AppMethodBeat.o(178171);
  }
  
  public final void a(bbi parambbi)
  {
    AppMethodBeat.i(243565);
    Log.i("Finder.RedDotManager", "mergeFinderMentionCtrlInfo enter:" + parambbi.type);
    k localk = j(b(2, (kotlin.g.a.b)o.tKf));
    Object localObject2 = new StringBuilder("mergeFinderMentionCtrlInfo :");
    if (localk != null)
    {
      ??? = Integer.valueOf(localk.field_ctrInfo.type);
      Log.i("Finder.RedDotManager", ???);
      if (localk != null)
      {
        ??? = localk.tLk.keySet();
        p.g(???, "showInfoMap.keys");
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
            break label292;
          }
          Object localObject3 = (String)((Iterator)localObject2).next();
          Object localObject4 = parambbi.GaM;
          p.g(localObject4, "ctrlInfo.show_infos");
          localObject4 = (Iterable)localObject4;
          if (((localObject4 instanceof Collection)) && (((Collection)localObject4).isEmpty())) {
            break label287;
          }
          localObject4 = ((Iterable)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label287;
          }
          if (!p.j(((bdo)((Iterator)localObject4).next()).path, localObject3)) {
            continue;
          }
          i = 0;
          if (i == 0) {
            continue;
          }
          localObject3 = (bdo)localk.tLk.get(localObject3);
          if (localObject3 == null) {
            continue;
          }
          parambbi.GaM.add(localObject3);
        }
        ??? = null;
        break;
        label287:
        int i = 1;
      }
      label292:
      parambbi = x.SXb;
      AppMethodBeat.o(243565);
      return;
    }
    AppMethodBeat.o(243565);
  }
  
  public final void a(bbi parambbi, String paramString)
  {
    AppMethodBeat.i(243573);
    p.h(parambbi, "local");
    p.h(paramString, "source");
    int j = parambbi.type;
    Object localObject3 = b(parambbi);
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = ((Map)this.tJJ).entrySet().iterator();
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
          k localk = (k)localIterator2.next();
          if (localk.field_ctrInfo.type == j)
          {
            localObject2 = (LinkedList)localHashMap.get(str);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new LinkedList();
              ((Map)localHashMap).put(str, localObject1);
            }
            p.g(localObject1, "clearMap[path] ?: run {\n…                        }");
            ((LinkedList)localObject1).add(localk);
            localIterator2.remove();
          }
        }
      }
      localObject1 = x.SXb;
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
          k.b((k)((Iterator)localObject2).next(), this.tJN);
        }
      }
    }
    Object localObject1 = new HashSet();
    a(parambbi, paramString, (HashSet)localObject1, false, (o)localObject3);
    paramString = (Map)localHashMap;
    parambbi = (Map)new LinkedHashMap();
    paramString = paramString.entrySet().iterator();
    label523:
    while (paramString.hasNext())
    {
      localObject2 = (Map.Entry)paramString.next();
      if (!((HashSet)localObject1).contains(((Map.Entry)localObject2).getKey())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label523;
        }
        parambbi.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        break;
      }
    }
    parambbi = parambbi.entrySet().iterator();
    while (parambbi.hasNext())
    {
      localObject1 = (Map.Entry)parambbi.next();
      paramString = (String)((Map.Entry)localObject1).getKey();
      localObject1 = ((Iterable)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject1).hasNext()) {
        k.b((k)((Iterator)localObject1).next(), this.tJN);
      }
      localObject1 = asX(paramString);
      if (localObject1 != null)
      {
        localObject2 = ((k)localObject1).atl(paramString);
        if (localObject2 != null) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label681;
          }
          localObject3 = h.tKR;
          h.a(false, paramString, null, null);
          localObject3 = h.tKR;
          h.a(true, paramString, (bdo)localObject2, (k)localObject1);
          break;
        }
        label681:
        localObject1 = h.tKR;
        h.a(false, paramString, null, null);
      }
      else
      {
        localObject1 = h.tKR;
        h.a(false, paramString, null, null);
      }
    }
    AppMethodBeat.o(243573);
  }
  
  public final void a(bbo parambbo)
  {
    AppMethodBeat.i(243598);
    p.h(parambbo, "revoke");
    Object localObject1 = new StringBuilder("[revokePathRedDot] ");
    Object localObject2 = parambbo.LKU;
    p.g(localObject2, "revoke.revoke_ctrl_info");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    bbp localbbp;
    while (((Iterator)localObject3).hasNext())
    {
      localbbp = (bbp)((Iterator)localObject3).next();
      ((Collection)localObject2).add(localbbp.path + '_' + localbbp.LKV + '_' + localbbp.LKW);
    }
    Log.i("Finder.RedDotManager", (List)localObject2);
    parambbo = parambbo.LKU;
    p.g(parambbo, "revoke.revoke_ctrl_info");
    localObject3 = ((Iterable)parambbo).iterator();
    k localk;
    label268:
    label364:
    Object localObject4;
    label434:
    final z.a locala;
    while (((Iterator)localObject3).hasNext())
    {
      localbbp = (bbp)((Iterator)localObject3).next();
      if (localbbp != null)
      {
        localObject1 = localbbp.path;
        parambbo = (bbo)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parambbo = "";
      }
      localk = asX(parambbo);
      if (localk != null)
      {
        if (localbbp != null)
        {
          localObject1 = localbbp.path;
          parambbo = (bbo)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          parambbo = "";
        }
        parambbo = localk.atl(parambbo);
        if (localbbp.LKV != 0) {
          break label434;
        }
        if (parambbo == null) {
          break label364;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.j.vft;
        com.tencent.mm.plugin.finder.report.j.a(localk, parambbo, 1, localbbp.LKV, null, null, 48);
      }
      for (;;)
      {
        if (localbbp != null)
        {
          localObject1 = localbbp.path;
          parambbo = (bbo)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          parambbo = "";
        }
        gI(parambbo, "revokePathRedDot#0");
        if (localbbp != null)
        {
          localObject1 = localbbp.path;
          parambbo = (bbo)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          parambbo = "";
        }
        asV(parambbo);
        break;
        parambbo = null;
        break label268;
        com.tencent.mm.plugin.report.service.h.CyF.a(20951, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), "", localbbp.path, Integer.valueOf(localbbp.LKV), "" });
      }
      if (localbbp.LKV == 1)
      {
        localObject1 = "";
        localObject2 = localbbp.LKW;
        p.g(localObject2, "it.tips_id_list");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject1 = (String)localObject1 + (String)localObject4 + ';';
        }
        n.b((String)localObject1, (CharSequence)";");
        localObject4 = new z.a();
        ((z.a)localObject4).SYB = true;
        locala = new z.a();
        locala.SYB = false;
        if (localbbp != null)
        {
          localObject2 = localbbp.path;
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
      i((String)localObject2, (kotlin.g.a.b)new w(localbbp, (z.a)localObject4, locala, this));
      Log.i("Finder.RedDotManager", "[revokePathRedDot] isHasDisposed=" + locala.SYB + " isAllDisposed=" + ((z.a)localObject4).SYB + " tipsList=" + (String)localObject1);
      if ((locala.SYB) && (((z.a)localObject4).SYB))
      {
        localObject2 = y.vXH;
        if ((localk == null) || (parambbo == null)) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.finder.report.j.vft;
        com.tencent.mm.plugin.finder.report.j.a(localk, parambbo, 1, localbbp.LKV, (String)localObject1, null, 32);
        break;
      }
      if ((locala.SYB) && (!((z.a)localObject4).SYB))
      {
        localObject2 = y.vXH;
        if ((localk == null) || (parambbo == null)) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.finder.report.j.vft;
        com.tencent.mm.plugin.finder.report.j.a(localk, parambbo, 2, localbbp.LKV, (String)localObject1, null, 32);
        break;
      }
      if (locala.SYB) {
        break;
      }
      localObject2 = y.vXH;
      if ((localk == null) || (parambbo == null)) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.j.vft;
      com.tencent.mm.plugin.finder.report.j.a(localk, parambbo, 4, localbbp.LKV, (String)localObject1, null, 32);
      break;
      AppMethodBeat.o(243598);
      return;
    }
  }
  
  public final void a(final bbq parambbq)
  {
    AppMethodBeat.i(243597);
    p.h(parambbq, "revoke");
    StringBuilder localStringBuilder = new StringBuilder("[revokeTabTips] ");
    Object localObject1 = parambbq.LKX;
    p.g(localObject1, "revoke.revoke_tab_tips_info");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((bbr)((Iterator)localObject2).next()).LKO);
    }
    Log.i("Finder.RedDotManager", (List)localObject1);
    com.tencent.mm.ac.d.c("Finder.RedDotManager", (kotlin.g.a.a)new x(this, parambbq));
    AppMethodBeat.o(243597);
  }
  
  public final void a(bdh parambdh, String paramString)
  {
    AppMethodBeat.i(243584);
    p.h(parambdh, "tabTips");
    p.h(paramString, "source");
    long l2 = daD();
    parambdh = parambdh.LKY;
    p.g(parambdh, "tabTips.tab_tips_info");
    Object localObject1 = (Iterable)parambdh;
    parambdh = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    bdj localbdj;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localbdj = (bdj)localObject2;
      p.g(localbdj, "it");
      if (a(localbdj)) {
        parambdh.add(localObject2);
      }
    }
    Object localObject2 = ((Iterable)parambdh).iterator();
    label259:
    label263:
    label413:
    label674:
    label1188:
    label1573:
    if (((Iterator)localObject2).hasNext())
    {
      localbdj = (bdj)((Iterator)localObject2).next();
      parambdh = localbdj.LNi;
      if (parambdh != null)
      {
        parambdh = parambdh.GaM;
        if (parambdh != null) {
          kotlin.a.j.c((List)parambdh, (kotlin.g.a.b)r.tKh);
        }
      }
      Log.i("Finder.RedDotManager", "[notifyTabTip] " + c(localbdj.LNi));
      parambdh = localbdj.LNi;
      label235:
      label239:
      label243:
      label247:
      label251:
      boolean bool2;
      label340:
      label624:
      boolean bool1;
      label454:
      label595:
      label631:
      long l1;
      label558:
      int i;
      if (parambdh != null)
      {
        parambdh = Integer.valueOf(parambdh.type);
        if (parambdh != null) {
          break label864;
        }
        if (parambdh != null) {
          break label1034;
        }
        if (parambdh != null) {
          break label1111;
        }
        if (parambdh != null) {
          break label1188;
        }
        if (parambdh != null) {
          break label1265;
        }
        if (parambdh != null) {
          break label1277;
        }
        if (parambdh != null) {
          break label1354;
        }
        bool2 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).isInFinder();
        if (bool2)
        {
          d(localbdj.LNi);
          localObject3 = new StringBuilder("[notifyTabTip] it is in finder now. just remove path of FINDER_ENTRANCE, currentTabType=").append(this.tJD.wtW).append(" type=");
          localObject1 = localbdj.LNi;
          if (localObject1 == null) {
            break label1436;
          }
          localObject1 = Integer.valueOf(((bbi)localObject1).type);
          Log.w("Finder.RedDotManager", localObject1);
        }
        if (((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).isInNearby())
        {
          e(localbdj.LNi);
          localObject3 = new StringBuilder("[notifyTabTip] it is in nearby now. just remove path of NEARBY_ENTRANCE, type=");
          localObject1 = localbdj.LNi;
          if (localObject1 == null) {
            break label1442;
          }
          localObject1 = Integer.valueOf(((bbi)localObject1).type);
          Log.w("Finder.RedDotManager", localObject1);
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if ((((Number)com.tencent.mm.plugin.finder.storage.c.dwB().value()).intValue() == 1) && (parambdh != null)) {
          break label1448;
        }
        parambdh = null;
        localObject1 = localbdj.LNi;
        if (localObject1 != null)
        {
          p.g(localObject1, "info");
          parambdh = b((bbi)localObject1);
          Iy(((bbi)localObject1).type);
        }
        b(localbdj.LNi, "notifyTabTip");
        localObject1 = a(this, localbdj.LNi, "notifyTabTip#".concat(String.valueOf(paramString)), null, true, parambdh, 4);
        Object localObject3 = new StringBuilder("[notifyTabTip] successfully! ctrlType=");
        if (localObject1 == null) {
          break label1563;
        }
        parambdh = Integer.valueOf(((k)localObject1).field_ctrInfo.type);
        localObject3 = ((StringBuilder)localObject3).append(parambdh).append(" tabType=");
        if (localObject1 == null) {
          break label1568;
        }
        parambdh = ((k)localObject1).tLm;
        if (parambdh == null) {
          break label1568;
        }
        parambdh = Integer.valueOf(parambdh.tab_type);
        localObject3 = ((StringBuilder)localObject3).append(parambdh).append(" extInfo=");
        parambdh = localbdj.LNi;
        if (parambdh == null) {
          break label1573;
        }
        parambdh = parambdh.LKL;
        if (parambdh == null) {
          break label1578;
        }
        bool1 = true;
        parambdh = ((StringBuilder)localObject3).append(bool1).append(' ').append("objectId=");
        if (localObject1 == null) {
          break label1584;
        }
        localObject3 = ((k)localObject1).field_ctrInfo;
        if (localObject3 == null) {
          break label1584;
        }
        l1 = ((bbi)localObject3).feedId;
        parambdh = parambdh.append(com.tencent.mm.ac.d.zs(l1)).append(' ').append("diffTime=").append(l2).append("ms isInFinder=").append(bool2).append(" currentTabType=").append(this.tJD.wtW).append(" showInfoSize=");
        localObject3 = localbdj.LNi;
        if (localObject3 == null) {
          break label1590;
        }
        localObject3 = ((bbi)localObject3).GaM;
        if (localObject3 == null) {
          break label1590;
        }
        i = ((LinkedList)localObject3).size();
        label763:
        localObject3 = parambdh.append(i).append(' ').append("tabTipsByPassInfo=");
        if (localObject1 == null) {
          break label1595;
        }
        parambdh = ((k)localObject1).tLm;
        if (parambdh == null) {
          break label1595;
        }
        parambdh = parambdh.tabTipsByPassInfo;
        if (parambdh == null) {
          break label1600;
        }
        bool1 = true;
        label808:
        localObject1 = ((StringBuilder)localObject3).append(bool1).append(" expiredTime=");
        parambdh = localbdj.LNi;
        if (parambdh == null) {
          break label1606;
        }
      }
      label1448:
      label1578:
      label1584:
      label1590:
      label1595:
      label1600:
      label1606:
      for (parambdh = Integer.valueOf(parambdh.pRN);; parambdh = null)
      {
        Log.i("Finder.RedDotManager", parambdh);
        break;
        parambdh = null;
        break label235;
        label864:
        if (parambdh.intValue() != 8) {
          break label239;
        }
        if (l2 <= l.tLu.dbB())
        {
          localObject1 = localbdj.LNi;
          if (localObject1 != null)
          {
            localObject1 = ((bbi)localObject1).GaM;
            if (localObject1 != null) {
              com.tencent.mm.ac.d.a((LinkedList)localObject1, (kotlin.g.a.b)s.tKi);
            }
          }
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFollowTabTimeMs=" + l.tLu.dbB() + "ms, remove this ctrInfo");
        }
        if (l2 > l.tLu.dbA()) {
          break label263;
        }
        d(localbdj.LNi);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFollowTabTimeMs=" + l.tLu.dbA() + "ms, remove entrance path red dot");
        break label263;
        if (parambdh.intValue() != 7) {
          break label243;
        }
        if (l2 > l.tLu.dbC()) {
          break label263;
        }
        d(localbdj.LNi);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabFriendEntranceTimeMs=" + l.tLu.dbC() + "ms, remove entrance path red dot");
        break label263;
        label1111:
        if (parambdh.intValue() != 10) {
          break label247;
        }
        if (l2 > l.tLu.dbD()) {
          break label263;
        }
        d(localbdj.LNi);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabHotEntranceTimeMs=" + l.tLu.dbD() + "ms, remove entrance path red dot");
        break label263;
        if (parambdh.intValue() != 9) {
          break label251;
        }
        for (;;)
        {
          if (l2 > l.tLu.dbF()) {
            break label1275;
          }
          d(localbdj.LNi);
          Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabLiveEntranceTimeMs=" + l.tLu.dbF() + "ms, remove entrance path red dot");
          break label263;
          label1265:
          if (parambdh.intValue() != 13) {
            break;
          }
        }
        label1275:
        break label263;
        label1277:
        if (parambdh.intValue() != 14) {
          break label259;
        }
        if (l2 > l.tLu.dbE()) {
          break label263;
        }
        d(localbdj.LNi);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l2 + "ms, moreTabHotEntranceTimeMs=" + l.tLu.dbE() + "ms, remove entrance path red dot");
        break label263;
        label1354:
        if (parambdh.intValue() != 16) {
          break label263;
        }
        l1 = daE();
        if (l1 > l.tLu.dbG()) {
          break label263;
        }
        e(localbdj.LNi);
        Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + l1 + "ms, moreTabNearbyEntranceTimeMs=" + l.tLu.dbG() + "ms, remove entrance path red dot");
        break label263;
        localObject1 = null;
        break label340;
        localObject1 = null;
        break label413;
        if ((parambdh.intValue() != 10) || ((!bool2) && (l2 > this.tJD.wtX))) {
          break label454;
        }
        localObject1 = new StringBuilder("ignore this reddot.ctrlType=").append(parambdh).append(" tips_id=");
        parambdh = localbdj.LNi;
        if (parambdh != null) {}
        for (parambdh = parambdh.LKM;; parambdh = null)
        {
          Log.w("Finder.RedDotManager", parambdh + " diffTime=" + l2 + " limit=" + this.tJD.wtX);
          break;
        }
        parambdh = null;
        break label558;
        parambdh = null;
        break label595;
        parambdh = null;
        break label624;
        bool1 = false;
        break label631;
        l1 = 0L;
        break label674;
        i = 0;
        break label763;
        parambdh = null;
        break label801;
        bool1 = false;
        break label808;
      }
    }
    label801:
    label1442:
    AppMethodBeat.o(243584);
    label1034:
    label1436:
    label1568:
    return;
  }
  
  public final boolean a(int paramInt, kotlin.g.a.b<? super k, Boolean> paramb)
  {
    AppMethodBeat.i(243579);
    p.h(paramb, "filter");
    Object localObject1 = com.tencent.mm.kernel.g.af(ad.class);
    p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if ((((ad)localObject1).dxX()) && (paramInt != 8))
    {
      Log.i("Finder.RedDotManager", "[clearCtrlInfo] 青少年模式且只看关注的模式下只clear关注的红点展示");
      AppMethodBeat.o(243579);
      return false;
    }
    paramb = b(paramInt, paramb);
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
      Object localObject3 = (List)this.tJJ.get(str);
      if (localObject3 != null) {
        com.tencent.mm.ac.d.a((List)localObject3, (kotlin.g.a.b)new j((Map.Entry)localObject2));
      }
      localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          k.b((k)((Iterator)localObject2).next(), this.tJN);
          continue;
          i = 0;
          break;
        }
      }
      localObject2 = asX(str);
      if (localObject2 != null)
      {
        localObject3 = ((k)localObject2).atl(str);
        if (localObject3 != null) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label332;
          }
          h localh = h.tKR;
          h.a(false, str, null, null);
          localh = h.tKR;
          h.a(true, str, (bdo)localObject3, (k)localObject2);
          break;
        }
        label332:
        localObject2 = h.tKR;
        h.a(false, str, null, null);
      }
      else
      {
        localObject2 = h.tKR;
        h.a(false, str, null, null);
      }
    }
    label364:
    if (!((Map)paramb).isEmpty())
    {
      AppMethodBeat.o(243579);
      return true;
    }
    AppMethodBeat.o(243579);
    return false;
  }
  
  public final void asV(String paramString)
  {
    AppMethodBeat.i(178176);
    p.h(paramString, "path");
    e(paramString, null);
    AppMethodBeat.o(178176);
  }
  
  public final bdo asW(String paramString)
  {
    AppMethodBeat.i(178178);
    p.h(paramString, "path");
    k localk = asX(paramString);
    if (localk != null)
    {
      paramString = localk.atl(paramString);
      AppMethodBeat.o(178178);
      return paramString;
    }
    AppMethodBeat.o(178178);
    return null;
  }
  
  public final k asX(String paramString)
  {
    AppMethodBeat.i(178179);
    p.h(paramString, "path");
    ??? = (List)this.tJJ.get(paramString);
    if (??? != null)
    {
      Object localObject3;
      Object localObject4;
      int i;
      for (;;)
      {
        synchronized ((Iterable)???)
        {
          localObject2 = (Collection)new ArrayList();
          localObject3 = ((Iterable)???).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = ((Iterator)localObject3).next();
          k localk = (k)localObject4;
          com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(ad.class);
          p.g(locala, "MMKernel.service(IFinder…enModeConfig::class.java)");
          if ((((ad)locala).dxX()) && (localk.field_ctrInfo.type != 8))
          {
            i = 0;
            if (i == 0) {
              continue;
            }
            ((Collection)localObject2).add(localObject4);
          }
        }
        i = 1;
      }
      Object localObject2 = (List)localObject2;
      try
      {
        localObject3 = ((List)localObject2).listIterator(((List)localObject2).size());
        if (((ListIterator)localObject3).hasPrevious())
        {
          ??? = ((ListIterator)localObject3).previous();
          localObject4 = ((k)???).atl(paramString);
          if (localObject4 != null)
          {
            i = 1;
            label222:
            if (i == 0) {
              break label247;
            }
          }
        }
        for (paramString = (String)???;; paramString = null)
        {
          paramString = (k)paramString;
          AppMethodBeat.o(178179);
          return paramString;
          i = 0;
          break label222;
          label247:
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
  
  public final FinderTipsShowEntranceExtInfo asZ(String paramString)
  {
    AppMethodBeat.i(243585);
    p.h(paramString, "path");
    paramString = asX(paramString);
    if (paramString != null)
    {
      FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = paramString.dbx();
      paramString = localFinderTipsShowEntranceExtInfo;
      if (localFinderTipsShowEntranceExtInfo != null) {}
    }
    else
    {
      paramString = new FinderTipsShowEntranceExtInfo();
    }
    AppMethodBeat.o(243585);
    return paramString;
  }
  
  public final bbj ata(String paramString)
  {
    AppMethodBeat.i(243591);
    p.h(paramString, "path");
    paramString = (b)this.tJL.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.tJQ;
      AppMethodBeat.o(243591);
      return paramString;
    }
    AppMethodBeat.o(243591);
    return null;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(243589);
    p.h(paramk, "enterCtrlInfo");
    String str = Ix(a(paramk));
    Log.i("Finder.RedDotManager", "[saveEnterTabTipsExtInfo] PATH=" + str + '=' + paramk.tLm);
    Map localMap = (Map)this.tJL;
    bbj localbbj = paramk.tLm;
    paramk = paramk.field_tipsId;
    p.g(paramk, "enterCtrlInfo.field_tipsId");
    localMap.put(str, new b(localbbj, paramk));
    AppMethodBeat.o(243589);
  }
  
  public final void b(bbi parambbi, String paramString)
  {
    AppMethodBeat.i(243590);
    p.h(paramString, "source");
    if (parambbi != null)
    {
      String str = Ix(a(new k().f(parambbi)));
      b localb = (b)this.tJL.get(str);
      if (localb != null)
      {
        if (p.j(localb.tJR, parambbi.LKM)) {}
        while (localb != null)
        {
          this.tJL.remove(str);
          Log.i("Finder.RedDotManager", "[clearEnterTabTipsExtInfo] PATH=" + str + " tips_id=" + parambbi.LKM + " source=" + paramString);
          AppMethodBeat.o(243590);
          return;
          localb = null;
        }
      }
      AppMethodBeat.o(243590);
      return;
    }
    AppMethodBeat.o(243590);
  }
  
  public final void daA()
  {
    AppMethodBeat.i(178169);
    Object localObject = m.tLw;
    Log.i("Finder.ThreeDayTwoDay", "enterFindMoreFriendTab");
    if (((m)localObject).dbV())
    {
      localObject = m.toy;
      if (localObject != null)
      {
        localObject = ((f)localObject).asX("FinderEntrance");
        if (localObject != null)
        {
          bdo localbdo = ((k)localObject).atl("FinderEntrance");
          if (localbdo != null) {
            com.tencent.mm.plugin.finder.report.j.a(com.tencent.mm.plugin.finder.report.j.vft, "1", (k)localObject, localbdo, 4);
          }
        }
      }
      localObject = m.toy;
      if (localObject != null)
      {
        ((f)localObject).asV("FinderEntrance");
        AppMethodBeat.o(178169);
        return;
      }
    }
    AppMethodBeat.o(178169);
  }
  
  public final void daB()
  {
    AppMethodBeat.i(243563);
    asV("FinderEntrance");
    asV("Discovery");
    AppMethodBeat.o(243563);
  }
  
  public final void daC()
  {
    AppMethodBeat.i(243564);
    this.tJG = (cl.aWA() - this.enterTime);
    long l;
    l locall;
    if ((this.tJI) && (this.tJH == 2))
    {
      l = this.tJG;
      locall = l.tLu;
      if (l <= l.dbI())
      {
        locall = l.tLu;
        int i = kotlin.k.j.na(l.dbM() + 1, 3);
        Log.w("Finder.RedDotManager", "[exitFinder] current fastLevel=".concat(String.valueOf(i)));
        locall = l.tLu;
        l.ID(i);
      }
    }
    for (;;)
    {
      locall = l.tLu;
      l.dbQ();
      AppMethodBeat.o(243564);
      return;
      l = this.tJG;
      locall = l.tLu;
      if (l > l.dbI())
      {
        Log.w("Finder.RedDotManager", "[exitFinder] revert fastLevel=0");
        locall = l.tLu;
        l.ID(0);
      }
    }
  }
  
  public final int daF()
  {
    AppMethodBeat.i(243577);
    long l = System.currentTimeMillis();
    Object localObject2 = asX("FinderEntrance");
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      localObject1 = ((k)localObject2).atl("FinderEntrance");
      if ((localObject1 != null) && (((k)localObject2).atl("finder_private_msg_entrance") == null)) {
        break label431;
      }
      localObject1 = c.tJT;
      localObject1 = f.c.a.a(1, this);
      localObject2 = c.tJT;
      localObject2 = f.c.a.a(3, this);
      localObject3 = c.tJT;
      localObject3 = kotlin.a.j.listOf(new c[] { localObject1, localObject2, f.c.a.a(4, this) });
      localObject4 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject4).hasNext()) {
        break label316;
      }
      localObject1 = null;
    }
    label159:
    label316:
    do
    {
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = (c)localObject1;
      if (((c)localObject1).tJS.LNr > 0) {
        break label395;
      }
      i = -1;
      localObject1 = new StringBuilder("[getAliveTabType] cost=").append(System.currentTimeMillis() - l).append("ms aliveType=").append(i).append(" maxPriorityTabType=").append(((c)localObject1).dLS).append(' ');
      localObject3 = (Iterable)localObject3;
      localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (c)((Iterator)localObject3).next();
        ((Collection)localObject2).add(((c)localObject4).dLS + '=' + ((c)localObject4).tJS.LNr);
      }
      localObject1 = null;
      break;
      localObject1 = ((Iterator)localObject4).next();
    } while (!((Iterator)localObject4).hasNext());
    int i = ((c)localObject1).tJS.LNr;
    label350:
    localObject2 = ((Iterator)localObject4).next();
    int j = ((c)localObject2).tJS.LNr;
    if (i < j)
    {
      localObject1 = localObject2;
      i = j;
    }
    for (;;)
    {
      if (!((Iterator)localObject4).hasNext())
      {
        break;
        label395:
        i = ((c)localObject1).dLS;
        break label159;
        Log.i("Finder.RedDotManager", (List)localObject2);
        AppMethodBeat.o(243577);
        return i;
        label431:
        i = a((k)localObject2);
        Log.i("Finder.RedDotManager", "[getAliveTabType] getTabTypeInCtrlInfo=".concat(String.valueOf(i)));
        if (i != -1)
        {
          AppMethodBeat.o(243577);
          return i;
        }
        Log.i("Finder.RedDotManager", "[getAliveTabType] TAB_TYPE_INVALID");
        AppMethodBeat.o(243577);
        return -1;
      }
      break label350;
    }
  }
  
  public final Set<k> daG()
  {
    AppMethodBeat.i(243593);
    Object localObject = new HashSet();
    Iterator localIterator = ((Map)this.tJJ).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((HashSet)localObject).addAll((Collection)((Map.Entry)localIterator.next()).getValue());
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(243593);
    return localObject;
  }
  
  public final boolean daH()
  {
    AppMethodBeat.i(243594);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    boolean bool = locale.azQ().getBoolean(ar.a.Omz, true);
    AppMethodBeat.o(243594);
    return bool;
  }
  
  public final void e(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(243571);
    p.h(paramString, "path");
    i(paramString, (kotlin.g.a.b)new k(paramArrayOfInt));
    AppMethodBeat.o(243571);
  }
  
  public final bbj gI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243592);
    p.h(paramString1, "path");
    p.h(paramString2, "source");
    paramString1 = (b)this.tJL.remove(paramString1);
    Log.i("Finder.RedDotManager", "[clearEnterTabTipsExtInfo] result=" + paramString1 + " source=" + paramString2);
    if (paramString1 != null)
    {
      paramString1 = paramString1.tJQ;
      AppMethodBeat.o(243592);
      return paramString1;
    }
    AppMethodBeat.o(243592);
    return null;
  }
  
  public final void mS(boolean paramBoolean)
  {
    AppMethodBeat.i(243595);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).azQ().set(ar.a.Omz, Boolean.valueOf(paramBoolean));
    localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.finder.report.k.ge(1, i);
      AppMethodBeat.o(243595);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(243596);
    Log.i("Finder.RedDotManager", "scene = ".concat(String.valueOf(paramq)));
    if (paramq != null) {
      switch (paramq.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(243596);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.tJA.dbq();
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
    Object localObject1 = this.tJN.daw();
    int i = ((LinkedList)localObject1).size();
    Object localObject2 = d.tJq;
    boolean bool = d.a((LinkedList)localObject1, this.tJN);
    int j = ((LinkedList)localObject1).size();
    Log.i("Finder.RedDotManager", "[prepare] checkRet=" + bool + " beforeCheckCount=" + i + " afterCheckCount=" + j);
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (k)((Iterator)localObject1).next();
      if (((k)localObject2).dbz())
      {
        Log.w("Finder.RedDotManager", "[prepare] showInfo is empty! ".concat(String.valueOf(localObject2)));
        ((k)localObject2).b(this.tJN, false);
      }
      else
      {
        localObject3 = ((k)localObject2).field_ctrInfo;
        p.g(localObject3, "it.field_ctrInfo");
        a(((k)localObject2).f((bbi)localObject3), "prepare");
      }
    }
    this.tJF.alive();
    localObject1 = this.tJC;
    com.tencent.mm.plugin.newtips.a.exk().a("FinderNewTipsTransform", (l.a)localObject1);
    localObject2 = this.tJA;
    localObject1 = ((j)localObject2).tJh.asX("FinderEntrance");
    if ((localObject1 != null) && (((k)localObject1).field_ctrInfo.type == -1))
    {
      localObject1 = ((k)localObject1).atl("FinderEntrance");
      if (localObject1 == null) {
        break label684;
      }
      localObject1 = Integer.valueOf(((bdo)localObject1).LNm);
      if (localObject1 != null) {
        break label690;
      }
    }
    for (;;)
    {
      ((j)localObject2).tJh.Iy(1001);
      Log.i("Finder.RedDotTransform", "[checkPostRedDot] has old fav red dot, ret=".concat(String.valueOf(x.SXb)));
      Iy(1005);
      localObject1 = m.tLw;
      p.h(this, "redDotManager");
      m.toy = this;
      Log.i("Finder.ThreeDayTwoDay", "INIT");
      ((m)localObject1).dbW();
      localObject1 = new e(this);
      ((e)localObject1).tJr.alive();
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new e.f((e)localObject1));
      e.a((e)localObject1, "setup");
      Log.i("Finder.RedDotManager", "[prepare] " + (System.currentTimeMillis() - l) + "ms");
      localObject1 = y.vXH;
      if (y.dCR() == 1)
      {
        Log.i("Finder.RedDotManager", "FINDER_GLOBAL_FULLSCREEN_ENJOY");
        localObject1 = l.tLu;
        if (!l.dbN())
        {
          Log.i("Finder.RedDotManager", "fullScreenTabShowed showed");
          Log.i("Finder.RedDotManager", "generateFullScreenRedDot");
          localObject1 = new bbi();
          ((bbi)localObject1).LKM = String.valueOf(cl.aWA());
          ((bbi)localObject1).priority = 10011000;
          ((bbi)localObject1).type = 1012;
          ((bbi)localObject1).pRN = 604800;
          localObject2 = new bbj();
          localObject3 = new bdi();
          ((bdi)localObject3).LNf = 7;
          ((bbj)localObject2).tabTipsByPassInfo = new com.tencent.mm.bw.b(((bdi)localObject3).toByteArray());
          ((bbj)localObject2).tab_type = 4;
          ((bbi)localObject1).LKL = new com.tencent.mm.bw.b(((bbj)localObject2).toByteArray());
          localObject2 = new bdo();
          ((bdo)localObject2).xGz = 6;
          ((bdo)localObject2).title = "NEW";
          ((bdo)localObject2).LNm = 1;
          ((bdo)localObject2).path = "finder_tl_hot_tab";
          ((bbi)localObject1).GaM.add(localObject2);
          a(this, (bbi)localObject1, "generateFullScreenRedDot", null, true, null, 20);
          localObject1 = l.tLu;
          l.mU(true);
        }
      }
      AppMethodBeat.o(178168);
      return;
      label684:
      localObject1 = null;
      break;
      label690:
      if (((Integer)localObject1).intValue() == 2)
      {
        ((j)localObject2).tJh.Iy(-1);
        Log.i("Finder.RedDotTransform", "[checkPostRedDot] has old post red dot, ret=".concat(String.valueOf(x.SXb)));
        ((j)localObject2).dbr();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$Companion;", "", "()V", "TAB_TIPS_TEST", "", "getTAB_TIPS_TEST", "()Z", "setTAB_TIPS_TEST", "(Z)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$EnterTabTipsExtInfo;", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "tipsId", "", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;Ljava/lang/String;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getTipsId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class b
  {
    final bbj tJQ;
    final String tJR;
    
    public b(bbj parambbj, String paramString)
    {
      AppMethodBeat.i(243528);
      this.tJQ = parambbj;
      this.tJR = paramString;
      AppMethodBeat.o(243528);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(243531);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.tJQ, paramObject.tJQ)) || (!p.j(this.tJR, paramObject.tJR))) {}
        }
      }
      else
      {
        AppMethodBeat.o(243531);
        return true;
      }
      AppMethodBeat.o(243531);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(243530);
      Object localObject = this.tJQ;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.tJR;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(243530);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243529);
      String str = "EnterTabTipsExtInfo(ext=" + this.tJQ + ", tipsId=" + this.tJR + ")";
      AppMethodBeat.o(243529);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "", "tabType", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "getTabType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class c
  {
    public static final a tJT;
    final int dLS;
    final bdp tJS;
    
    static
    {
      AppMethodBeat.i(243534);
      tJT = new a((byte)0);
      AppMethodBeat.o(243534);
    }
    
    public c(int paramInt, bdp parambdp)
    {
      AppMethodBeat.i(243533);
      this.dLS = paramInt;
      this.tJS = parambdp;
      AppMethodBeat.o(243533);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(243537);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.dLS != paramObject.dLS) || (!p.j(this.tJS, paramObject.tJS))) {}
        }
      }
      else
      {
        AppMethodBeat.o(243537);
        return true;
      }
      AppMethodBeat.o(243537);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(243536);
      int j = this.dLS;
      bdp localbdp = this.tJS;
      if (localbdp != null) {}
      for (int i = localbdp.hashCode();; i = 0)
      {
        AppMethodBeat.o(243536);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243535);
      String str = "FinderTipsShowTabExt(tabType=" + this.dLS + ", ext=" + this.tJS + ")";
      AppMethodBeat.o(243535);
      return str;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt$Companion;", "", "()V", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "tabType", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "plugin-finder_release"})
    public static final class a
    {
      public static f.c a(int paramInt, f paramf)
      {
        int j = 0;
        Object localObject2 = null;
        AppMethodBeat.i(243532);
        p.h(paramf, "manager");
        Object localObject1 = f.Ix(paramInt);
        paramf = paramf.asX((String)localObject1);
        bdp localbdp;
        label92:
        label116:
        boolean bool;
        if (paramf != null)
        {
          paramf = paramf.atl((String)localObject1);
          localbdp = new bdp();
          StringBuilder localStringBuilder = new StringBuilder("[FinderTipsShowTabExt#transform] tabType=").append(paramInt).append(" path=").append((String)localObject1).append(" show_ext_info_type=");
          if (paramf == null) {
            break label242;
          }
          localObject1 = Integer.valueOf(paramf.LNn);
          localStringBuilder = localStringBuilder.append(localObject1).append(" show_ext_info=");
          if (paramf == null) {
            break label248;
          }
          localObject1 = paramf.LNo;
          if (localObject1 == null) {
            break label254;
          }
          bool = true;
          label124:
          Log.i("Finder.RedDotManager", bool);
          if ((paramf == null) || (paramf.LNn != 2) || (paramf.LNo == null)) {
            break label260;
          }
          localObject1 = paramf.LNo;
          paramf = localObject2;
          if (localObject1 != null) {
            paramf = ((com.tencent.mm.bw.b)localObject1).toByteArray();
          }
          localbdp.parseFrom(paramf);
          Log.i("Finder.RedDotManager", "tabType=" + paramInt + " serverJumpPriority=" + localbdp.LNr);
        }
        label242:
        label248:
        label254:
        while (paramf == null)
        {
          paramf = new f.c(paramInt, localbdp);
          AppMethodBeat.o(243532);
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
          localbdp.LNr = i;
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    public static final d tJU;
    
    static
    {
      AppMethodBeat.i(243539);
      tJU = new d();
      AppMethodBeat.o(243539);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$buildPathWithCtrInfo$1$1"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Boolean>
  {
    e(f paramf, k paramk, HashSet paramHashSet)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Integer>
  {
    public static final f tJY;
    
    static
    {
      AppMethodBeat.i(178152);
      tJY = new f();
      AppMethodBeat.o(178152);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Long>
  {
    public static final g tJZ;
    
    static
    {
      AppMethodBeat.i(178154);
      tJZ = new g();
      AppMethodBeat.o(178154);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$clearCtrlInfo$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Boolean>
  {
    h(f paramf, k paramk)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Boolean>
  {
    public static final i tKb;
    
    static
    {
      AppMethodBeat.i(243542);
      tKb = new i();
      AppMethodBeat.o(243542);
    }
    
    i()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Boolean>
  {
    j(Map.Entry paramEntry)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Boolean>
  {
    k(int[] paramArrayOfInt)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class l
    extends IListener<fp>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    public static final m tKd;
    
    static
    {
      AppMethodBeat.i(243547);
      tKd = new m();
      AppMethodBeat.o(243547);
    }
    
    m()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Boolean>
  {
    public static final n tKe;
    
    static
    {
      AppMethodBeat.i(243549);
      tKe = new n();
      AppMethodBeat.o(243549);
    }
    
    n()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Boolean>
  {
    public static final o tKf;
    
    static
    {
      AppMethodBeat.i(243551);
      tKf = new o();
      AppMethodBeat.o(243551);
    }
    
    o()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class p<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(243552);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((k)paramT1).field_time), (Comparable)Long.valueOf(((k)paramT2).field_time));
      AppMethodBeat.o(243552);
      return i;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    public static final q tKg;
    
    static
    {
      AppMethodBeat.i(178161);
      tKg = new q();
      AppMethodBeat.o(178161);
    }
    
    q()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    public static final r tKh;
    
    static
    {
      AppMethodBeat.i(243554);
      tKh = new r();
      AppMethodBeat.o(243554);
    }
    
    r()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    public static final s tKi;
    
    static
    {
      AppMethodBeat.i(243556);
      tKi = new s();
      AppMethodBeat.o(243556);
    }
    
    s()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    public static final t tKj;
    
    static
    {
      AppMethodBeat.i(178163);
      tKj = new t();
      AppMethodBeat.o(178163);
    }
    
    t()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    public static final u tKk;
    
    static
    {
      AppMethodBeat.i(243558);
      tKk = new u();
      AppMethodBeat.o(243558);
    }
    
    u()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    public static final v tKl;
    
    static
    {
      AppMethodBeat.i(243560);
      tKl = new v();
      AppMethodBeat.o(243560);
    }
    
    v()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$revokePathRedDot$2$2"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.b<k, Boolean>
  {
    w(bbp parambbp, z.a parama1, z.a parama2, f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    x(f paramf, bbq parambbq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.f
 * JD-Core Version:    0.7.0.1
 */