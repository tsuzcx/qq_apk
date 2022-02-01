package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.protocal.protobuf.eku;
import com.tencent.mm.protocal.protobuf.ekv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRedDotManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;)V", "careExptKey", "", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enterSource", "", "enterTime", "", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1;", "hasRedDotWhenEnter", "", "msgRedDotHandler", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "getMsgRedDotHandler", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "newTipsTransform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "noFoundRevokeIdSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTipsInfo;", "pathToCtrInfoMap", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "revokeIdToCtrInfoMap", "singleTaskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getSingleTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "singleTaskExecutor$delegate", "Lkotlin/Lazy;", "stateCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stayDuration", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "getTransform", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "addNewRedDotCtrlInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "tipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "changePathSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "isClearOldSameType", "buildPathWithCtrInfo", "local", "checkPreFetchNow", "", "clearCtrlInfo", "type", "filter", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ctrlInfo", "containsTabTipsExtInfo", "tabType", "ctrlInfoAtPath", "path", "deleteCtrlInfo", "ctrInfo", "disposeRedDotAtPath", "call", "ctrlType", "", "enterFinder", "exitFinder", "exitFinderBefore", "filterNotifyTabTip", "tabTip", "Lcom/tencent/mm/protocal/protobuf/FinderTabTipsInfo;", "findByRevokeId", "revokeId", "findExtInfoAtCtrlInfo", "getAliveTabType", "getDiffExitTimeMs", "getPathByTabType", "getTabTipsExtInfo", "getTabTypeByPath", "getTipsShowInfoAtPath", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "hasPrefetch", "isEnableShowEntranceRedDot", "isShowInteractionRedDot", "lastPreFetchTime", "needToRefreshForPrefetch", "notifyFinderFansAddCount", "count", "notifyFinderMsgCount", "normalCount", "systemCount", "notifyRedDot", "redDot", "Lcom/tencent/mm/protocal/protobuf/FinderRedDot;", "notifyTabTip", "tabTips", "Lcom/tencent/mm/protocal/protobuf/FinderTabTips;", "notifyWxMentionCount", "wxMention", "Lcom/tencent/mm/protocal/protobuf/FinderWxMentionCount;", "onExptChange", "key", "onPreFetchDone", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "needShowRedDot", "isInFinder", "token", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseEntranceExtInfo", "showInfoList", "prepare", "printCtrInfo", "printTipsShowInfo", "index", "reBuildPathWithCtrInfo", "resetPreFetchTime", "revokePathRedDot", "revoke", "Lcom/tencent/mm/protocal/protobuf/FinderRevokePathRedDot;", "revokeTabTips", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTips;", "setEnableShowEntranceRedDot", "isEnable", "storeLastPreFetchTime", "updateFindMoreFriendUI", "Companion", "FinderTipsShowTabExt", "plugin-finder_release"})
public final class e
  implements com.tencent.mm.ak.f, o
{
  private static boolean saK;
  public static final a saL;
  public long enterTime;
  private final d.f saA;
  private final List<com.tencent.mm.plugin.expt.b.b.a> saB;
  private final h saC;
  public long saD;
  public int saE;
  public boolean saF;
  private final ConcurrentHashMap<String, List<i>> saG;
  private final ConcurrentHashMap<String, i> saH;
  private final ConcurrentHashMap<String, arp> saI;
  private final c saJ;
  private final h saw;
  public final a sax;
  private final b say;
  private final FinderHomeTabStateVM saz;
  
  static
  {
    AppMethodBeat.i(178166);
    saL = new a((byte)0);
    AppMethodBeat.o(178166);
  }
  
  public e(c paramc)
  {
    AppMethodBeat.i(178184);
    this.saJ = paramc;
    this.saw = new h(this);
    this.sax = new a(this);
    this.say = new b(this);
    paramc = com.tencent.mm.ui.component.a.KEX;
    paramc = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramc, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.saz = ((FinderHomeTabStateVM)paramc);
    this.saA = d.g.O((d.g.a.a)q.sbc);
    this.saB = d.a.j.listOf(com.tencent.mm.plugin.expt.b.b.a.qIt);
    this.saC = new h(this);
    this.saG = new ConcurrentHashMap();
    this.saH = new ConcurrentHashMap();
    this.saI = new ConcurrentHashMap();
    AppMethodBeat.o(178184);
  }
  
  public static String EE(int paramInt)
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
      return "TLMachineTab";
    }
    return "TLLbsTab";
  }
  
  private static String a(arj paramarj)
  {
    AppMethodBeat.i(178180);
    if (paramarj == null)
    {
      AppMethodBeat.o(178180);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = paramarj.GIf;
    p.g(localObject1, "info.show_infos");
    localObject1 = (Iterable)localObject1;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.gkd();
      }
      localStringBuilder.append(a((ast)localObject2, i));
      i += 1;
    }
    paramarj = "CtrlInfo{tipsId=" + paramarj.GIg + " priority=" + paramarj.priority + " type=" + paramarj.type + " tipsShowInfo=" + localStringBuilder + '}';
    AppMethodBeat.o(178180);
    return paramarj;
  }
  
  private static String a(ast paramast, int paramInt)
  {
    AppMethodBeat.i(178181);
    if (paramast == null)
    {
      AppMethodBeat.o(178181);
      return "[empty]";
    }
    paramast = "#" + paramInt + "{showType=" + paramast.uoi + " count=" + paramast.count + " title=" + paramast.title + ' ' + "clearType=" + paramast.GJM + " iconUrl=" + paramast.pqW + " path=" + paramast.path + " show_ext_info_type=" + paramast.GJN + " parent=" + paramast.xvd + "} ";
    AppMethodBeat.o(178181);
    return paramast;
  }
  
  private final HashSet<String> a(final i parami, String paramString)
  {
    AppMethodBeat.i(202079);
    ae.i("Finder.RedDotManager", "[buildPathWithCtrInfo] source=" + paramString + ' ' + a(parami.field_ctrInfo) + " revokeId=" + parami.field_revokeId);
    final HashSet localHashSet = new HashSet();
    Object localObject1 = ((Map)parami.sbE).entrySet().iterator();
    Map.Entry localEntry;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject1).next();
      paramString = (List)this.saG.get(localEntry.getKey());
      if (paramString != null) {
        break label367;
      }
      localObject2 = (e)this;
      paramString = Collections.synchronizedList((List)new LinkedList());
      localObject2 = (Map)((e)localObject2).saG;
      Object localObject3 = localEntry.getKey();
      p.g(paramString, "list");
      ((Map)localObject2).put(localObject3, paramString);
    }
    label367:
    for (;;)
    {
      p.g(paramString, "crlInfoList");
      d.a.j.c(paramString, (d.g.a.b)new c(this, parami, localHashSet));
      paramString.add(parami);
      localObject2 = new d.g.a.b[2];
      localObject2[0] = ((d.g.a.b)d.saQ);
      localObject2[1] = ((d.g.a.b)e.saR);
      p.h(localObject2, "selectors");
      d.a.j.a(paramString, (Comparator)new d.b.b.a((d.g.a.b[])localObject2));
      localHashSet.add(localEntry.getKey());
      break;
      paramString = parami.field_revokeId;
      if (paramString != null) {
        ((Map)this.saH).put(paramString, parami);
      }
      parami = ((Iterable)localHashSet).iterator();
      while (parami.hasNext())
      {
        paramString = (String)parami.next();
        localObject1 = g.sbw;
        g.a(true, paramString, aii(paramString), aij(paramString));
      }
      AppMethodBeat.o(202079);
      return localHashSet;
    }
  }
  
  private boolean a(arj paramarj, String paramString, ass paramass, HashSet<String> paramHashSet, boolean paramBoolean)
  {
    AppMethodBeat.i(224288);
    p.h(paramString, "source");
    p.h(paramass, "tipsShowEntranceExtInfo");
    p.h(paramHashSet, "changePathSet");
    if (paramarj == null)
    {
      AppMethodBeat.o(224288);
      return false;
    }
    if (paramBoolean) {
      a(this, paramarj.type);
    }
    if (!cBv())
    {
      localObject = paramarj.GIf;
      p.g(localObject, "info.show_infos");
      com.tencent.mm.ac.c.a((LinkedList)localObject, (d.g.a.b)b.saM);
      ae.i("Finder.RedDotManager", "[addNewRedDotCtrlInfo] remove DISCOVERY_TAB");
    }
    i locali = new i().b(paramarj);
    locali.field_tipsShowEntranceExtInfo = paramass;
    ConcurrentHashMap localConcurrentHashMap = this.saI;
    Object localObject = locali.field_revokeId;
    paramass = (ass)localObject;
    if (localObject == null) {
      paramass = "";
    }
    if (localConcurrentHashMap.contains(paramass))
    {
      ae.e("Finder.RedDotManager", "[addNewRedDotCtrlInfo] has revoke. " + locali.field_revokeId + ' ' + a(locali.field_ctrInfo));
      AppMethodBeat.o(224288);
      return false;
    }
    if (i.a(locali, this.saJ))
    {
      paramHashSet.addAll((Collection)a(locali, paramString));
      paramString = k.sbO;
      p.h(paramarj, "ctrlInfo");
      ae.i("Finder.ThreeDayTwoDay", "checkRedDotFilter");
      if (k.cCi())
      {
        paramarj = com.tencent.mm.kernel.g.ajR();
        p.g(paramarj, "MMKernel.storage()");
        long l1 = paramarj.ajA().a(am.a.Jdl, 0L);
        if (l1 != 0L)
        {
          long l2 = ch.aDc() - l1;
          paramarj = com.tencent.mm.plugin.finder.storage.b.sHP;
          i = ((Number)com.tencent.mm.plugin.finder.storage.b.cKP().value()).intValue();
          if (i >= l2)
          {
            paramBoolean = true;
            ae.i("Finder.ThreeDayTwoDay", "[checkInLimitTwoDay] isInLimit=" + paramBoolean + " twoDayThreshold=" + i + " diffTime=" + l2 + " hitThreeDayTime=" + l1);
            if (!paramBoolean) {
              break label422;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramarj = k.rOC;
          if (paramarj != null) {
            paramarj.aih("FinderEntrance");
          }
        }
        AppMethodBeat.o(224288);
        return true;
        paramBoolean = false;
        break;
        label422:
        k.reset(ch.aDc());
      }
    }
    AppMethodBeat.o(224288);
    return false;
  }
  
  private final boolean a(aso paramaso)
  {
    int i = -1;
    AppMethodBeat.i(202084);
    Object localObject1 = paramaso.GJF;
    int j;
    if ((localObject1 == null) || (((arj)localObject1).type != 8))
    {
      localObject1 = paramaso.GJF;
      if ((localObject1 == null) || (((arj)localObject1).type != 7)) {}
    }
    else
    {
      if (saK)
      {
        localObject1 = paramaso.GJF;
        if (localObject1 != null)
        {
          localObject1 = ((arj)localObject1).GIf;
          if (localObject1 != null) {
            d.a.j.c((List)localObject1, (d.g.a.b)i.saU);
          }
        }
        saK = false;
      }
      localObject1 = paramaso.GJF;
      if (localObject1 != null)
      {
        localObject1 = ((arj)localObject1).GIf;
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          j = 0;
          if (((Iterator)localObject1).hasNext()) {
            if (p.i(((ast)((Iterator)localObject1).next()).path, "FinderEntrance"))
            {
              label167:
              localObject1 = paramaso.GJF;
              if (localObject1 == null) {
                break label261;
              }
              localObject1 = Integer.valueOf(((arj)localObject1).type);
              label188:
              if (j < 0) {
                break label272;
              }
              localObject1 = new StringBuilder("[filterNotifyTabTip] has FINDER_ENTRANCE this tabTip type=");
              paramaso = paramaso.GJF;
              if (paramaso == null) {
                break label267;
              }
            }
          }
        }
      }
      label261:
      label267:
      for (paramaso = Integer.valueOf(paramaso.type);; paramaso = null)
      {
        ae.i("Finder.RedDotManager", paramaso);
        AppMethodBeat.o(202084);
        return true;
        j += 1;
        break;
        j = -1;
        break label167;
        j = -1;
        break label167;
        localObject1 = null;
        break label188;
      }
      label272:
      if (localObject1 != null) {
        break label295;
      }
      if (localObject1 != null) {
        break label462;
      }
      if (localObject1 != null) {
        break label515;
      }
    }
    label295:
    label305:
    Iterator localIterator;
    boolean bool;
    label462:
    label501:
    label507:
    while (localObject2.intValue() != 7)
    {
      AppMethodBeat.o(202084);
      return true;
      if (((Integer)localObject1).intValue() != 8) {
        break;
      }
      paramaso = (List)this.saG.get("FinderEntrance");
      k = i;
      if (paramaso != null) {}
      for (;;)
      {
        try
        {
          localIterator = paramaso.iterator();
          j = 0;
          k = i;
          if (localIterator.hasNext())
          {
            i locali = (i)localIterator.next();
            if (locali.field_ctrInfo.type != 8)
            {
              k = locali.field_ctrInfo.type;
              if (k != 9) {}
            }
            else
            {
              k = 1;
              if (k == 0) {
                continue;
              }
              k = j;
            }
          }
          else
          {
            if (k < 0) {
              break label501;
            }
            bool = true;
            ae.i("Finder.RedDotManager", "[filterNotifyTabTip] ignore[" + bool + "] this tabTip type=" + localObject1);
            if (bool) {
              break label507;
            }
            AppMethodBeat.o(202084);
            return true;
            if (((Integer)localObject1).intValue() != 9) {
              break;
            }
            break label305;
          }
          k = 0;
          continue;
          j += 1;
          continue;
          bool = false;
        }
        finally
        {
          AppMethodBeat.o(202084);
        }
      }
      AppMethodBeat.o(202084);
      return false;
    }
    label515:
    Object localObject3 = (List)this.saG.get("FinderEntrance");
    int k = i;
    if (localObject3 != null) {}
    for (;;)
    {
      try
      {
        localIterator = ((List)localObject3).iterator();
        j = 0;
        k = i;
        if (localIterator.hasNext())
        {
          k = ((i)localIterator.next()).field_ctrInfo.type;
          if (k == 7)
          {
            k = 1;
            if (k == 0) {
              continue;
            }
            k = j;
          }
        }
        else
        {
          if (k < 0) {
            break label715;
          }
          bool = true;
          localObject3 = new StringBuilder("[filterNotifyTabTip] ignore[").append(bool).append("] this tabTip type=");
          paramaso = paramaso.GJF;
          if (paramaso == null) {
            break label721;
          }
          paramaso = Integer.valueOf(paramaso.type);
          ae.i("Finder.RedDotManager", paramaso);
          if (bool) {
            break;
          }
          AppMethodBeat.o(202084);
          return true;
        }
        k = 0;
        continue;
        j += 1;
        continue;
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(202084);
      }
      label715:
      continue;
      label721:
      paramaso = null;
    }
    AppMethodBeat.o(202084);
    return false;
  }
  
  private static int aJi(String paramString)
  {
    AppMethodBeat.i(224291);
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
          AppMethodBeat.o(224291);
          return -1;
        } while (!paramString.equals("TLFollow"));
        AppMethodBeat.o(224291);
        return 3;
      } while (!paramString.equals("TLMachineTab"));
      AppMethodBeat.o(224291);
      return 4;
    } while (!paramString.equals("TLRecommendTab"));
    AppMethodBeat.o(224291);
    return 1;
  }
  
  private static long cBs()
  {
    AppMethodBeat.i(202074);
    long l1 = ch.aDc();
    j localj = j.sbM;
    long l2 = j.cCc();
    AppMethodBeat.o(202074);
    return l1 - l2;
  }
  
  public static long cBu()
  {
    AppMethodBeat.i(178182);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.JbQ, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(178182);
      throw ((Throwable)localObject);
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(178182);
    return l;
  }
  
  private static ass dF(List<? extends ast> paramList)
  {
    AppMethodBeat.i(224292);
    ass localass = new ass();
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        ast localast = (ast)localIterator.next();
        int i = localast.GJN;
        if (i == 1)
        {
          paramList = localast.GJO;
          if (paramList != null) {}
          for (paramList = paramList.getBytes();; paramList = null)
          {
            localass.parseFrom(paramList);
            ae.i("Finder.RedDotManager", "[parseExtInfo] path=" + localast.path + " objectId=" + com.tencent.mm.ac.c.rp(localass.GJI) + " tabType=" + localass.GEB + " report_ext_info=" + localass.GJL + " showExtInfoType=" + i);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(224292);
    return localass;
  }
  
  private void k(String paramString, d.g.a.b<? super i, Boolean> paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(224290);
    p.h(paramString, "path");
    p.h(paramb, "call");
    Object localObject2 = new HashSet();
    i locali1 = aij(paramString);
    if (locali1 != null) {}
    Object localObject3;
    for (ast localast = locali1.aim(paramString);; localast = null)
    {
      localObject3 = (List)this.saG.get(paramString);
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((List)localObject3).iterator();
      if (localObject3 == null) {
        break;
      }
      while (((Iterator)localObject3).hasNext())
      {
        i locali2 = (i)((Iterator)localObject3).next();
        if (((Boolean)paramb.invoke(locali2)).booleanValue())
        {
          LinkedList localLinkedList = locali2.ain(paramString);
          if (i.a(locali2, this.saJ)) {
            ((HashSet)localObject2).addAll((Collection)localLinkedList);
          }
          if (locali2.cBS()) {
            ((Iterator)localObject3).remove();
          }
        }
      }
    }
    paramb = new StringBuilder("[disposeRedDotAtPath] path=").append(paramString).append(" tipsId=");
    paramString = (String)localObject1;
    if (locali1 != null) {
      paramString = locali1.field_tipsId;
    }
    ae.i("Finder.RedDotManager", paramString + " removePathSet=" + localObject2 + " maybeRemoveShowInfo=" + a(localast, 0));
    paramString = ((Iterable)localObject2).iterator();
    while (paramString.hasNext())
    {
      paramb = (String)paramString.next();
      localObject1 = aij(paramb);
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).aim(paramb);
        if (localObject2 != null) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label350;
          }
          localObject3 = g.sbw;
          g.a(false, paramb, localast, locali1);
          localObject3 = g.sbw;
          g.a(true, paramb, (ast)localObject2, (i)localObject1);
          break;
        }
        label350:
        localObject1 = g.sbw;
        g.a(false, paramb, localast, locali1);
      }
      else
      {
        localObject1 = g.sbw;
        g.a(false, paramb, localast, locali1);
      }
    }
    AppMethodBeat.o(224290);
  }
  
  public final void EC(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(178170);
    Object localObject = aij("FinderEntrance");
    int i;
    if ((localObject != null) && (((i)localObject).aim("FinderEntrance") != null))
    {
      localObject = ((i)localObject).field_ctrInfo;
      if (localObject != null)
      {
        i = ((arj)localObject).type;
        if (i != -1) {
          bool = true;
        }
      }
    }
    for (this.saF = bool;; this.saF = false)
    {
      this.saE = paramInt;
      this.enterTime = ch.aDc();
      aih("FinderEntrance");
      aih("Discovery");
      localObject = k.sbO;
      ae.i("Finder.ThreeDayTwoDay", "enterFinder");
      k.cCk();
      this.saw.cBM();
      ae.i("Finder.RedDotManager", "[enterFinder] hasRedDotWhenEnter=" + this.saF);
      AppMethodBeat.o(178170);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ED(int paramInt)
  {
    AppMethodBeat.i(202073);
    if (paramInt <= 0)
    {
      ae.i("Finder.RedDotManager", "[notifyFinderFansAddCount] server error.");
      AppMethodBeat.o(202073);
      return;
    }
    ae.i("Finder.RedDotManager", "[notifyFinderFansAddCount] count = ".concat(String.valueOf(paramInt)));
    arj localarj = new arj();
    localarj.GIg = String.valueOf(ch.aDc());
    localarj.priority = 100000;
    localarj.type = 2;
    ast localast = new ast();
    localast.uoi = 2;
    localast.GJM = 1;
    localast.path = "AuthorProfileFans";
    localast.count = paramInt;
    localarj.GIf.add(localast);
    a(this, localarj, "notifyFinderFansAddCount", null, null, true, 12);
    AppMethodBeat.o(202073);
  }
  
  public final boolean EF(int paramInt)
  {
    AppMethodBeat.i(202088);
    ass localass = EG(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("[containsTabTipsExtInfo] tabType=").append(paramInt).append(" isContains=");
    if (localass.GEB != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("Finder.RedDotManager", bool);
      if (localass.GEB == 0) {
        break;
      }
      AppMethodBeat.o(202088);
      return true;
    }
    AppMethodBeat.o(202088);
    return false;
  }
  
  public final ass EG(int paramInt)
  {
    AppMethodBeat.i(202089);
    ass localass = aik(EE(paramInt));
    ae.i("Finder.RedDotManager", "[getTabTipsExtInfo] tabType=" + paramInt + " ext=" + f.a(localass));
    AppMethodBeat.o(202089);
    return localass;
  }
  
  public final void a(ari paramari)
  {
    AppMethodBeat.i(178171);
    p.h(paramari, "redDot");
    long l = ch.aDc();
    Object localObject = j.sbM;
    l -= j.cCc();
    localObject = new StringBuilder("[notifyRedDot] diffTime=").append(l).append(" newMsgTipsEnterInterval=");
    j localj = j.sbM;
    ae.i("Finder.RedDotManager", j.cBW() + " showRed=" + paramari.GIc + ' ' + a(paramari.GId));
    localObject = j.sbM;
    if (l < j.cBW())
    {
      localObject = paramari.GId;
      if (localObject != null)
      {
        localObject = ((arj)localObject).GIf;
        if (localObject != null) {
          com.tencent.mm.ac.c.a((LinkedList)localObject, (d.g.a.b)j.saV);
        }
      }
    }
    a(this, paramari.GId, "notifyRedDot", null, null, true, 12);
    AppMethodBeat.o(178171);
  }
  
  public final void a(arj paramarj, String paramString)
  {
    AppMethodBeat.i(202078);
    p.h(paramarj, "local");
    p.h(paramString, "source");
    int j = paramarj.type;
    Object localObject3 = new HashMap();
    Iterator localIterator1 = ((Map)this.saG).entrySet().iterator();
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localObject1 = (Map.Entry)localIterator1.next();
      String str = (String)((Map.Entry)localObject1).getKey();
      Iterator localIterator2 = ((List)((Map.Entry)localObject1).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        i locali = (i)localIterator2.next();
        if (locali.field_ctrInfo.type == j)
        {
          localObject2 = (LinkedList)((HashMap)localObject3).get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new LinkedList();
            ((Map)localObject3).put(str, localObject1);
          }
          p.g(localObject1, "clearMap[path] ?: run {\n…ist\n                    }");
          ((LinkedList)localObject1).add(locali);
          localIterator2.remove();
        }
      }
    }
    if (!((Map)localObject3).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ae.i("Finder.RedDotManager", "[reBuildPathWithCtrInfo] type=" + j + " clearMap=" + localObject3 + " source=" + paramString);
      }
      localObject1 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterable)((Map.Entry)((Iterator)localObject1).next()).getValue()).iterator();
        while (((Iterator)localObject2).hasNext()) {
          i.b((i)((Iterator)localObject2).next(), this.saJ);
        }
      }
    }
    Object localObject1 = new HashSet();
    a(this, paramarj, paramString, null, (HashSet)localObject1, false, 4);
    paramString = (Map)localObject3;
    paramarj = (Map)new LinkedHashMap();
    paramString = paramString.entrySet().iterator();
    label481:
    while (paramString.hasNext())
    {
      localObject2 = (Map.Entry)paramString.next();
      if (!((HashSet)localObject1).contains(((Map.Entry)localObject2).getKey())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label481;
        }
        paramarj.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        break;
      }
    }
    paramarj = paramarj.entrySet().iterator();
    while (paramarj.hasNext())
    {
      localObject1 = (Map.Entry)paramarj.next();
      paramString = (String)((Map.Entry)localObject1).getKey();
      localObject1 = ((Iterable)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject1).hasNext()) {
        i.b((i)((Iterator)localObject1).next(), this.saJ);
      }
      localObject1 = aij(paramString);
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).aim(paramString);
        if (localObject2 != null) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label639;
          }
          localObject3 = g.sbw;
          g.a(false, paramString, null, null);
          localObject3 = g.sbw;
          g.a(true, paramString, (ast)localObject2, (i)localObject1);
          break;
        }
        label639:
        localObject1 = g.sbw;
        g.a(false, paramString, null, null);
      }
      else
      {
        localObject1 = g.sbw;
        g.a(false, paramString, null, null);
      }
    }
    AppMethodBeat.o(202078);
  }
  
  public final void a(final aro paramaro)
  {
    AppMethodBeat.i(224293);
    p.h(paramaro, "revoke");
    StringBuilder localStringBuilder = new StringBuilder("[revokeTabTips] ");
    Object localObject1 = paramaro.GIk;
    p.g(localObject1, "revoke.revoke_tab_tips_info");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((arp)((Iterator)localObject2).next()).GIi);
    }
    ae.i("Finder.RedDotManager", (List)localObject1);
    com.tencent.mm.ac.c.c("Finder.RedDotManager", (d.g.a.a)new t(this, paramaro));
    AppMethodBeat.o(224293);
  }
  
  public final void a(asn paramasn, String paramString)
  {
    AppMethodBeat.i(202085);
    p.h(paramasn, "tabTips");
    p.h(paramString, "source");
    long l = cBs();
    paramasn = paramasn.GIl;
    p.g(paramasn, "tabTips.tab_tips_info");
    Object localObject1 = (Iterable)paramasn;
    paramasn = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (aso)localObject2;
      p.g(localObject3, "it");
      if (a((aso)localObject3)) {
        paramasn.add(localObject2);
      }
    }
    localObject1 = ((Iterable)paramasn).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aso)((Iterator)localObject1).next();
      ae.i("Finder.RedDotManager", "[notifyTabTip] " + a(((aso)localObject2).GJF));
      paramasn = ((aso)localObject2).GJF;
      label198:
      j localj;
      if (paramasn != null)
      {
        paramasn = paramasn.GIf;
        paramasn = dF((List)paramasn);
        localObject3 = ((aso)localObject2).GJF;
        if ((localObject3 == null) || (((arj)localObject3).type != 8)) {
          break label806;
        }
        localObject3 = j.sbM;
        if (l <= j.cBU())
        {
          localObject3 = ((aso)localObject2).GJF;
          if (localObject3 != null)
          {
            localObject3 = ((arj)localObject3).GIf;
            if (localObject3 != null) {
              com.tencent.mm.ac.c.a((LinkedList)localObject3, (d.g.a.b)k.saW);
            }
          }
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFollowTabTimeMs=");
          localj = j.sbM;
          ae.w("Finder.RedDotManager", j.cBU() + "ms, remove this ctrInfo");
        }
        localObject3 = j.sbM;
        if (l <= j.cBT())
        {
          localObject3 = ((aso)localObject2).GJF;
          if (localObject3 != null)
          {
            localObject3 = ((arj)localObject3).GIf;
            if (localObject3 != null) {
              com.tencent.mm.ac.c.a((LinkedList)localObject3, (d.g.a.b)l.saX);
            }
          }
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFollowTabTimeMs=");
          localj = j.sbM;
          ae.w("Finder.RedDotManager", j.cBT() + "ms, remove entrance path red dot");
        }
        label426:
        boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
        if (bool)
        {
          if (this.saz.tku == paramasn.GEB)
          {
            ae.w("Finder.RedDotManager", "[notifyTabTip] it is in finder " + paramasn.GEB + " now. currentTabType=" + this.saz.tku + " extTab_type=" + paramasn.GEB);
            localObject3 = ((aso)localObject2).GJF;
            if (localObject3 != null) {
              ((arj)localObject3).GIh = 1L;
            }
          }
          localObject3 = ((aso)localObject2).GJF;
          if (localObject3 != null)
          {
            localObject3 = ((arj)localObject3).GIf;
            if (localObject3 != null) {
              com.tencent.mm.ac.c.a((LinkedList)localObject3, (d.g.a.b)n.saZ);
            }
          }
          ae.w("Finder.RedDotManager", "[notifyTabTip] it is in finder now. just remove path of FINDER_ENTRANCE, currentTabType=" + this.saz.tku + " extTab_type=" + paramasn.GEB);
        }
        localObject3 = ((aso)localObject2).GJF;
        if (localObject3 != null) {
          a(this, ((arj)localObject3).type);
        }
        localObject3 = ((aso)localObject2).GJF;
        if (localObject3 != null) {
          ((arj)localObject3).duw = paramasn.GJI;
        }
        a(this, ((aso)localObject2).GJF, "notifyTabTip#".concat(String.valueOf(paramString)), paramasn, null, true, 8);
        localObject3 = new StringBuilder("[notifyTabTip] successfully! tabType=").append(paramasn.GEB).append(" objectId=").append(com.tencent.mm.ac.c.rp(paramasn.GJI)).append(" diffTime=").append(l).append("ms isInFinder=").append(bool).append(" currentTabType=").append(this.saz.tku).append(" showInfoSize=");
        paramasn = ((aso)localObject2).GJF;
        if (paramasn == null) {
          break label964;
        }
        paramasn = paramasn.GIf;
        if (paramasn == null) {
          break label964;
        }
      }
      label806:
      label964:
      for (paramasn = Integer.valueOf(paramasn.size());; paramasn = null)
      {
        ae.i("Finder.RedDotManager", paramasn);
        break;
        paramasn = null;
        break label198;
        localObject3 = ((aso)localObject2).GJF;
        if ((localObject3 != null) && (((arj)localObject3).type == 7))
        {
          localObject3 = j.sbM;
          if (l > j.cBV()) {
            break label426;
          }
          localObject3 = ((aso)localObject2).GJF;
          if (localObject3 != null)
          {
            localObject3 = ((arj)localObject3).GIf;
            if (localObject3 != null) {
              com.tencent.mm.ac.c.a((LinkedList)localObject3, (d.g.a.b)m.saY);
            }
          }
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFriendEntranceTimeMs=");
          localj = j.sbM;
          ae.w("Finder.RedDotManager", j.cBV() + "ms, remove entrance path red dot");
          break label426;
        }
        localObject3 = ((aso)localObject2).GJF;
        if ((localObject3 == null) || (((arj)localObject3).type != 9)) {
          break label426;
        }
        ae.w("Finder.RedDotManager", "[notifyTabTip】");
        break label426;
      }
    }
    AppMethodBeat.o(202085);
  }
  
  public final void a(atm paramatm)
  {
    AppMethodBeat.i(178172);
    p.h(paramatm, "wxMention");
    long l = ch.aDc();
    Object localObject = j.sbM;
    l -= j.cCc();
    if ((paramatm.count <= 0) && (paramatm.GKp <= 0) && (paramatm.GKo <= 0) && (paramatm.GEM <= 0) && (paramatm.GEL <= 0) && (paramatm.GKn <= 0) && (paramatm.GKq <= 0))
    {
      ae.e("Finder.RedDotManager", "[notifyWxMentionCount] server error.");
      AppMethodBeat.o(178172);
      return;
    }
    ae.i("Finder.RedDotManager", "[notifyWxMentionCount] diffTime=" + l + ' ' + a(paramatm.GJF) + " count=" + paramatm.count);
    localObject = j.sbM;
    if (l < j.cBW())
    {
      localObject = paramatm.GJF;
      if (localObject != null)
      {
        localObject = ((arj)localObject).GIf;
        if (localObject != null) {
          com.tencent.mm.ac.c.a((LinkedList)localObject, (d.g.a.b)o.sba);
        }
      }
    }
    a(this, paramatm.GJF, "notifyWxMentionCount", null, null, true, 12);
    AppMethodBeat.o(178172);
  }
  
  public final void a(ekt paramekt)
  {
    AppMethodBeat.i(224294);
    p.h(paramekt, "revoke");
    Object localObject1 = new StringBuilder("[revokePathRedDot] ");
    Object localObject2 = paramekt.LGq;
    p.g(localObject2, "revoke.revoke_ctrl_info");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (eku)((Iterator)localObject3).next();
      ((Collection)localObject2).add(((eku)localObject4).path + '_' + ((eku)localObject4).LGr + '_' + ((eku)localObject4).LGs);
    }
    ae.i("Finder.RedDotManager", (List)localObject2);
    paramekt = paramekt.LGq;
    p.g(paramekt, "revoke.revoke_ctrl_info");
    Object localObject4 = ((Iterable)paramekt).iterator();
    eku localeku;
    label268:
    label463:
    Object localObject5;
    label393:
    final y.a locala;
    while (((Iterator)localObject4).hasNext())
    {
      localeku = (eku)((Iterator)localObject4).next();
      if (localeku != null)
      {
        localObject1 = localeku.path;
        paramekt = (ekt)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramekt = "";
      }
      localObject3 = aij(paramekt);
      if (localObject3 != null)
      {
        if (localeku != null)
        {
          localObject1 = localeku.path;
          paramekt = (ekt)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramekt = "";
        }
        localObject1 = ((i)localObject3).aim(paramekt);
        if (localeku.LGr != 0) {
          break label463;
        }
        if (localObject1 == null) {
          break label393;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(20951, new Object[] { Integer.valueOf(((i)localObject3).field_ctrInfo.type), Integer.valueOf(((ast)localObject1).uoi), Integer.valueOf(1), ((i)localObject3).field_tipsId, localeku.path, Integer.valueOf(localeku.LGr), "" });
      }
      for (;;)
      {
        if (localeku != null)
        {
          localObject1 = localeku.path;
          paramekt = (ekt)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramekt = "";
        }
        aih(paramekt);
        break;
        localObject1 = null;
        break label268;
        com.tencent.mm.plugin.report.service.g.yxI.f(20951, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), "", localeku.path, Integer.valueOf(localeku.LGr), "" });
      }
      if (localeku.LGr == 1)
      {
        paramekt = "";
        localObject2 = localeku.LGs;
        p.g(localObject2, "it.tips_id_list");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (String)((Iterator)localObject2).next();
          paramekt = paramekt + (String)localObject5 + ';';
        }
        d.n.n.b(paramekt, (CharSequence)";");
        localObject5 = new y.a();
        ((y.a)localObject5).NiT = true;
        locala = new y.a();
        locala.NiT = false;
        if (localeku != null)
        {
          localObject2 = localeku.path;
          if (localObject2 != null) {
            break label1092;
          }
        }
        localObject2 = "";
      }
    }
    label806:
    label811:
    label944:
    label949:
    label1079:
    label1092:
    for (;;)
    {
      k((String)localObject2, (d.g.a.b)new s(localeku, (y.a)localObject5, locala));
      ae.i("Finder.RedDotManager", "[revokePathRedDot] isHasDisposed=" + locala.NiT + " isAllDisposed=" + ((y.a)localObject5).NiT + " tipsList=" + paramekt);
      if ((locala.NiT) && (((y.a)localObject5).NiT))
      {
        localObject5 = com.tencent.mm.plugin.report.service.g.yxI;
        if (localObject3 != null)
        {
          localObject2 = Integer.valueOf(((i)localObject3).field_ctrInfo.type);
          label717:
          if (localObject1 == null) {
            break label806;
          }
          localObject1 = Integer.valueOf(((ast)localObject1).uoi);
          label729:
          if (localObject3 == null) {
            break label811;
          }
        }
        for (localObject3 = ((i)localObject3).field_tipsId;; localObject3 = null)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject5).f(20951, new Object[] { localObject2, localObject1, Integer.valueOf(1), localObject3, localeku.path, Integer.valueOf(localeku.LGr), paramekt });
          break;
          localObject2 = null;
          break label717;
          localObject1 = null;
          break label729;
        }
      }
      if ((locala.NiT) && (!((y.a)localObject5).NiT))
      {
        localObject5 = com.tencent.mm.plugin.report.service.g.yxI;
        if (localObject3 != null)
        {
          localObject2 = Integer.valueOf(((i)localObject3).field_ctrInfo.type);
          label855:
          if (localObject1 == null) {
            break label944;
          }
          localObject1 = Integer.valueOf(((ast)localObject1).uoi);
          label867:
          if (localObject3 == null) {
            break label949;
          }
        }
        for (localObject3 = ((i)localObject3).field_tipsId;; localObject3 = null)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject5).f(20951, new Object[] { localObject2, localObject1, Integer.valueOf(2), localObject3, localeku.path, Integer.valueOf(localeku.LGr), paramekt });
          break;
          localObject2 = null;
          break label855;
          localObject1 = null;
          break label867;
        }
      }
      if (locala.NiT) {
        break;
      }
      localObject5 = com.tencent.mm.plugin.report.service.g.yxI;
      if (localObject3 != null)
      {
        localObject2 = Integer.valueOf(((i)localObject3).field_ctrInfo.type);
        label985:
        if (localObject1 == null) {
          break label1074;
        }
        localObject1 = Integer.valueOf(((ast)localObject1).uoi);
        label997:
        if (localObject3 == null) {
          break label1079;
        }
      }
      for (localObject3 = ((i)localObject3).field_tipsId;; localObject3 = null)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject5).f(20951, new Object[] { localObject2, localObject1, Integer.valueOf(4), localObject3, localeku.path, Integer.valueOf(localeku.LGr), paramekt });
        break;
        localObject2 = null;
        break label985;
        localObject1 = null;
        break label997;
      }
      AppMethodBeat.o(224294);
      return;
    }
  }
  
  public final boolean a(int paramInt, d.g.a.b<? super i, Boolean> paramb)
  {
    AppMethodBeat.i(202082);
    p.h(paramb, "filter");
    HashMap localHashMap = new HashMap();
    Object localObject3 = ((Map)this.saG).entrySet().iterator();
    Object localObject1;
    Object localObject4;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      localObject4 = (String)((Map.Entry)localObject1).getKey();
      Iterator localIterator = ((List)((Map.Entry)localObject1).getValue()).iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if ((locali.field_ctrInfo.type == paramInt) && (((Boolean)paramb.invoke(locali)).booleanValue()))
        {
          localObject2 = (LinkedList)localHashMap.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new LinkedList();
            ((Map)localHashMap).put(localObject4, localObject1);
          }
          p.g(localObject1, "clearMap[path] ?: run {\n…ist\n                    }");
          ((LinkedList)localObject1).add(locali);
          localIterator.remove();
        }
      }
    }
    int i;
    if (!((Map)localHashMap).isEmpty())
    {
      i = 1;
      if (i != 0) {
        ae.i("Finder.RedDotManager", "[clearCtrlInfo] type=" + paramInt + " clearMap=" + localHashMap);
      }
      paramb = ((Map)localHashMap).entrySet().iterator();
    }
    for (;;)
    {
      if (!paramb.hasNext()) {
        break label469;
      }
      localObject2 = (Map.Entry)paramb.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          i.b((i)((Iterator)localObject2).next(), this.saJ);
          continue;
          i = 0;
          break;
        }
      }
      localObject2 = aij((String)localObject1);
      if (localObject2 != null)
      {
        localObject3 = ((i)localObject2).aim((String)localObject1);
        if (localObject3 != null) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label437;
          }
          localObject4 = g.sbw;
          g.a(false, (String)localObject1, null, null);
          localObject4 = g.sbw;
          g.a(true, (String)localObject1, (ast)localObject3, (i)localObject2);
          break;
        }
        label437:
        localObject2 = g.sbw;
        g.a(false, (String)localObject1, null, null);
      }
      else
      {
        localObject2 = g.sbw;
        g.a(false, (String)localObject1, null, null);
      }
    }
    label469:
    if (!((Map)localHashMap).isEmpty())
    {
      AppMethodBeat.o(202082);
      return true;
    }
    AppMethodBeat.o(202082);
    return false;
  }
  
  public final void aih(String paramString)
  {
    AppMethodBeat.i(178176);
    p.h(paramString, "path");
    e(paramString, null);
    AppMethodBeat.o(178176);
  }
  
  public final ast aii(String paramString)
  {
    AppMethodBeat.i(178178);
    p.h(paramString, "path");
    i locali = aij(paramString);
    if (locali != null)
    {
      paramString = locali.aim(paramString);
      AppMethodBeat.o(178178);
      return paramString;
    }
    AppMethodBeat.o(178178);
    return null;
  }
  
  public final i aij(String paramString)
  {
    AppMethodBeat.i(178179);
    p.h(paramString, "path");
    List localList = (List)this.saG.get(paramString);
    if (localList != null) {
      try
      {
        ListIterator localListIterator = localList.listIterator(localList.size());
        Object localObject;
        int i;
        if (localListIterator.hasPrevious())
        {
          localObject = localListIterator.previous();
          ast localast = ((i)localObject).aim(paramString);
          if (localast != null)
          {
            i = 1;
            label85:
            if (i == 0) {
              break label110;
            }
          }
        }
        for (paramString = localObject;; paramString = null)
        {
          paramString = (i)paramString;
          AppMethodBeat.o(178179);
          return paramString;
          i = 0;
          break label85;
          label110:
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
  
  public final ass aik(String paramString)
  {
    AppMethodBeat.i(202087);
    p.h(paramString, "path");
    paramString = aij(paramString);
    if (paramString != null)
    {
      ass localass = paramString.cBR();
      paramString = localass;
      if (localass != null) {}
    }
    else
    {
      paramString = new ass();
    }
    AppMethodBeat.o(202087);
    return paramString;
  }
  
  public final void cBr()
  {
    AppMethodBeat.i(178169);
    Object localObject = k.sbO;
    ae.i("Finder.ThreeDayTwoDay", "enterFindMoreFriendTab");
    if (k.cCi())
    {
      localObject = k.rOC;
      if (localObject != null)
      {
        localObject = ((e)localObject).aij("FinderEntrance");
        if (localObject != null)
        {
          ast localast = ((i)localObject).aim("FinderEntrance");
          if (localast != null)
          {
            com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.syO;
            com.tencent.mm.plugin.finder.report.h.a("1", (i)localObject, localast, 4);
          }
        }
      }
      localObject = k.rOC;
      if (localObject != null)
      {
        ((e)localObject).aih("FinderEntrance");
        AppMethodBeat.o(178169);
        return;
      }
    }
    AppMethodBeat.o(178169);
  }
  
  public final int cBt()
  {
    AppMethodBeat.i(202080);
    long l = System.currentTimeMillis();
    Object localObject2 = aij("FinderEntrance");
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      localObject1 = ((i)localObject2).aim("FinderEntrance");
      if (localObject1 != null) {
        break label420;
      }
      localObject1 = p.DqP;
      localObject1 = e.p.a.a(1, this);
      localObject2 = p.DqP;
      localObject2 = e.p.a.a(3, this);
      localObject3 = p.DqP;
      localObject3 = d.a.j.listOf(new p[] { localObject1, localObject2, e.p.a.a(4, this) });
      localObject4 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject4).hasNext()) {
        break label305;
      }
      localObject1 = null;
    }
    label148:
    label305:
    do
    {
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = (p)localObject1;
      if (((p)localObject1).DqO.OzL > 0) {
        break label384;
      }
      i = -1;
      localObject1 = new StringBuilder("[getAliveTabType] cost=").append(System.currentTimeMillis() - l).append("ms aliveType=").append(i).append(" maxPriorityTabType=").append(((p)localObject1).dvm).append(' ');
      localObject3 = (Iterable)localObject3;
      localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (p)((Iterator)localObject3).next();
        ((Collection)localObject2).add(((p)localObject4).dvm + '=' + ((p)localObject4).DqO.OzL);
      }
      localObject1 = null;
      break;
      localObject1 = ((Iterator)localObject4).next();
    } while (!((Iterator)localObject4).hasNext());
    int i = ((p)localObject1).DqO.OzL;
    label339:
    localObject2 = ((Iterator)localObject4).next();
    int j = ((p)localObject2).DqO.OzL;
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
        label384:
        i = ((p)localObject1).dvm;
        break label148;
        ae.i("Finder.RedDotManager", (List)localObject2);
        AppMethodBeat.o(202080);
        return i;
        label420:
        if (((i)localObject2).aim("TLFollow") != null)
        {
          ae.i("Finder.RedDotManager", "[getAliveTabType] FINDER_TL_TAB_FOLLOW");
          i = aJi("TLFollow");
          AppMethodBeat.o(202080);
          return i;
        }
        if (((i)localObject2).aim("TLRecommendTab") != null)
        {
          ae.i("Finder.RedDotManager", "[getAliveTabType] FINDER_TL_TAB_FRIEND");
          i = aJi("TLRecommendTab");
          AppMethodBeat.o(202080);
          return i;
        }
        if (((i)localObject2).aim("TLMachineTab") != null)
        {
          ae.i("Finder.RedDotManager", "[getAliveTabType] FINDER_TL_TAB_MACHINE");
          i = aJi("TLMachineTab");
          AppMethodBeat.o(202080);
          return i;
        }
        ae.i("Finder.RedDotManager", "[getAliveTabType] TAB_TYPE_INVALID");
        AppMethodBeat.o(202080);
        return -1;
      }
      break label339;
    }
  }
  
  public final boolean cBv()
  {
    AppMethodBeat.i(202090);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    boolean bool = locale.ajA().getBoolean(am.a.Jdk, true);
    AppMethodBeat.o(202090);
    return bool;
  }
  
  public final void e(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(202077);
    p.h(paramString, "path");
    k(paramString, (d.g.a.b)new r(paramArrayOfInt));
    AppMethodBeat.o(202077);
  }
  
  public final void fH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202072);
    if ((paramInt1 <= 0) && (paramInt2 <= 0))
    {
      ae.i("Finder.RedDotManager", "[notifyFinderMsgCount] server error.");
      AppMethodBeat.o(202072);
      return;
    }
    ae.i("Finder.RedDotManager", "[notifyFinderMsgCount] normalCount = " + paramInt1 + ", systemCount = " + paramInt2);
    arj localarj = new arj();
    localarj.GIg = String.valueOf(ch.aDc());
    localarj.priority = 100000;
    localarj.type = 2;
    ast localast = new ast();
    localast.uoi = 2;
    localast.GJM = 1;
    localast.path = "AuthorProfileNotify";
    localast.count = (paramInt1 + paramInt2);
    localarj.GIf.add(localast);
    if (paramInt2 > 0)
    {
      localast = new ast();
      localast.uoi = 2;
      localast.GJM = 1;
      localast.path = "NotificitionCenterNotify";
      localast.count = paramInt2;
      localarj.GIf.add(localast);
    }
    a(this, localarj, "notifyFinderMsgCount", null, null, true, 12);
    AppMethodBeat.o(202072);
  }
  
  public final void lN(boolean paramBoolean)
  {
    AppMethodBeat.i(202091);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdk, Boolean.valueOf(paramBoolean));
    localObject = com.tencent.mm.plugin.finder.report.i.syT;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.finder.report.i.fK(1, i);
      AppMethodBeat.o(202091);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(202092);
    ae.i("Finder.RedDotManager", "scene = ".concat(String.valueOf(paramn)));
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(202092);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.saw.cBM();
      }
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(178168);
    if (!ak.coh())
    {
      AppMethodBeat.o(178168);
      return;
    }
    com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("Finder.RedDotManager");
    Object localObject1 = ((Iterable)this.saJ.coU()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      if (((i)localObject2).cBS())
      {
        ae.w("Finder.RedDotManager", "[prepare] showInfo is empty! ".concat(String.valueOf(localObject2)));
        ((i)localObject2).b(this.saJ, false);
      }
      arj localarj = ((i)localObject2).field_ctrInfo;
      p.g(localarj, "it.field_ctrInfo");
      a(((i)localObject2).b(localarj), "prepare");
    }
    this.saC.alive();
    localObject1 = this.say;
    com.tencent.mm.plugin.newtips.a.dxC().a("FinderNewTipsTransform", (l.a)localObject1);
    Object localObject2 = this.saw;
    localObject1 = ((h)localObject2).sai.aij("FinderEntrance");
    if ((localObject1 != null) && (((i)localObject1).field_ctrInfo.type == -1))
    {
      localObject1 = ((i)localObject1).aim("FinderEntrance");
      if (localObject1 == null) {
        break label281;
      }
      localObject1 = Integer.valueOf(((ast)localObject1).GJM);
      if (localObject1 != null) {
        break label286;
      }
    }
    for (;;)
    {
      ae.i("Finder.RedDotTransform", "[checkPostRedDot] has old fav red dot, ret=".concat(String.valueOf(a(((h)localObject2).sai, 1001))));
      a(this, 1005);
      localObject1 = k.sbO;
      p.h(this, "redDotManager");
      k.rOC = this;
      ae.i("Finder.ThreeDayTwoDay", "INIT");
      k.cCj();
      localb.ald();
      AppMethodBeat.o(178168);
      return;
      label281:
      localObject1 = null;
      break;
      label286:
      if (((Integer)localObject1).intValue() == 2)
      {
        ae.i("Finder.RedDotTransform", "[checkPostRedDot] has old post red dot, ret=".concat(String.valueOf(a(((h)localObject2).sai, -1))));
        ((h)localObject2).cBN();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$Companion;", "", "()V", "TAB_TIPS_TEST", "", "getTAB_TIPS_TEST", "()Z", "setTAB_TIPS_TEST", "(Z)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    public static final b saM;
    
    static
    {
      AppMethodBeat.i(202056);
      saM = new b();
      AppMethodBeat.o(202056);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$buildPathWithCtrInfo$1$1"})
  static final class c
    extends q
    implements d.g.a.b<i, Boolean>
  {
    c(e parame, i parami, HashSet paramHashSet)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<i, Integer>
  {
    public static final d saQ;
    
    static
    {
      AppMethodBeat.i(178152);
      saQ = new d();
      AppMethodBeat.o(178152);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<i, Long>
  {
    public static final e saR;
    
    static
    {
      AppMethodBeat.i(178154);
      saR = new e();
      AppMethodBeat.o(178154);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<i, Boolean>
  {
    public static final f saS;
    
    static
    {
      AppMethodBeat.i(202058);
      saS = new f();
      AppMethodBeat.o(202058);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$deleteCtrlInfo$1$1"})
  static final class g
    extends q
    implements d.g.a.b<i, Boolean>
  {
    g(e parame, i parami)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.sdk.b.c<fm>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    public static final i saU;
    
    static
    {
      AppMethodBeat.i(202062);
      saU = new i();
      AppMethodBeat.o(202062);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    public static final j saV;
    
    static
    {
      AppMethodBeat.i(178161);
      saV = new j();
      AppMethodBeat.o(178161);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    public static final k saW;
    
    static
    {
      AppMethodBeat.i(202064);
      saW = new k();
      AppMethodBeat.o(202064);
    }
    
    k()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    public static final l saX;
    
    static
    {
      AppMethodBeat.i(202066);
      saX = new l();
      AppMethodBeat.o(202066);
    }
    
    l()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    public static final m saY;
    
    static
    {
      AppMethodBeat.i(202068);
      saY = new m();
      AppMethodBeat.o(202068);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    public static final n saZ;
    
    static
    {
      AppMethodBeat.i(202070);
      saZ = new n();
      AppMethodBeat.o(202070);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    public static final o sba;
    
    static
    {
      AppMethodBeat.i(178163);
      sba = new o();
      AppMethodBeat.o(178163);
    }
    
    o()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "", "tabType", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "getTabType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class p
  {
    public static final a DqP;
    final ekv DqO;
    final int dvm;
    
    static
    {
      AppMethodBeat.i(224281);
      DqP = new a((byte)0);
      AppMethodBeat.o(224281);
    }
    
    public p(int paramInt, ekv paramekv)
    {
      AppMethodBeat.i(224280);
      this.dvm = paramInt;
      this.DqO = paramekv;
      AppMethodBeat.o(224280);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(224284);
      if (this != paramObject)
      {
        if ((paramObject instanceof p))
        {
          paramObject = (p)paramObject;
          if ((this.dvm != paramObject.dvm) || (!p.i(this.DqO, paramObject.DqO))) {}
        }
      }
      else
      {
        AppMethodBeat.o(224284);
        return true;
      }
      AppMethodBeat.o(224284);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(224283);
      int j = this.dvm;
      ekv localekv = this.DqO;
      if (localekv != null) {}
      for (int i = localekv.hashCode();; i = 0)
      {
        AppMethodBeat.o(224283);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(224282);
      String str = "FinderTipsShowTabExt(tabType=" + this.dvm + ", ext=" + this.DqO + ")";
      AppMethodBeat.o(224282);
      return str;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt$Companion;", "", "()V", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "tabType", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "plugin-finder_release"})
    public static final class a
    {
      public static e.p a(int paramInt, e parame)
      {
        AppMethodBeat.i(224279);
        p.h(parame, "manager");
        Object localObject = e.EE(paramInt);
        parame = parame.aij((String)localObject);
        int i;
        if (parame != null)
        {
          parame = parame.aim((String)localObject);
          localObject = new ekv();
          if (parame != null) {
            switch (paramInt)
            {
            case 2: 
            default: 
              i = 0;
            }
          }
        }
        for (;;)
        {
          ((ekv)localObject).OzL = i;
          parame = new e.p(paramInt, (ekv)localObject);
          AppMethodBeat.o(224279);
          return parame;
          parame = null;
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<com.tencent.mm.loader.g.i>
  {
    public static final q sbc;
    
    static
    {
      AppMethodBeat.i(178165);
      sbc = new q();
      AppMethodBeat.o(178165);
    }
    
    q()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class r
    extends q
    implements d.g.a.b<i, Boolean>
  {
    r(int[] paramArrayOfInt)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class s
    extends q
    implements d.g.a.b<i, Boolean>
  {
    s(eku parameku, y.a parama1, y.a parama2)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements d.g.a.a<z>
  {
    t(e parame, aro paramaro)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.e
 * JD-Core Version:    0.7.0.1
 */