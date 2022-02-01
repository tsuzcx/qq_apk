package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.b.b.a;
import d.g.b.p;
import d.g.b.q;
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
import java.util.concurrent.atomic.AtomicInteger;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRedDotManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;)V", "enterSource", "", "enterTime", "", "hasRedDotWhenEnter", "", "msgRedDotHandler", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "getMsgRedDotHandler", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "newTipsTransform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "noFoundRevokeIdSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTipsInfo;", "pathToCtrInfoMap", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "preFetchToken", "Ljava/util/concurrent/atomic/AtomicInteger;", "revokeIdToCtrInfoMap", "singleTaskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getSingleTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "singleTaskExecutor$delegate", "Lkotlin/Lazy;", "stateCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stayDuration", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "getTransform", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "addNewRedDotCtrlInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "tipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "changePathSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "buildPathWithCtrInfo", "local", "checkPreFetchNow", "", "clearCtrlInfo", "type", "filter", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ctrlInfo", "containsTabTipsExtInfo", "tabType", "ctrlInfoAtPath", "path", "deleteCtrlInfo", "ctrInfo", "disposeRedDotAtPath", "ctrlType", "", "enterFinder", "exitFinder", "exitFinderBefore", "filterNotifyTabTip", "tabTip", "Lcom/tencent/mm/protocal/protobuf/FinderTabTipsInfo;", "findByRevokeId", "revokeId", "findExtInfoAtCtrlInfo", "getAliveTabType", "getDiffExitTimeMs", "getPathByTabType", "getTabTipsExtInfo", "getTipsShowInfoAtPath", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "hasPrefetch", "isEnableShowEntranceRedDot", "isShowInteractionRedDot", "lastPreFetchTime", "needToRefreshForPrefetch", "notifyFinderFansAddCount", "count", "notifyFinderMsgCount", "normalCount", "systemCount", "notifyRedDot", "redDot", "Lcom/tencent/mm/protocal/protobuf/FinderRedDot;", "notifyTabTip", "tabTips", "Lcom/tencent/mm/protocal/protobuf/FinderTabTips;", "notifyWxMentionCount", "wxMention", "Lcom/tencent/mm/protocal/protobuf/FinderWxMentionCount;", "onPreFetchDone", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "needShowRedDot", "isInFinder", "token", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseExtInfo", "showInfoList", "", "prepare", "printCtrInfo", "printTipsShowInfo", "index", "reBuildPathWithCtrInfo", "resetPreFetchTime", "revokeRedDot", "revoke", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTips;", "setEnableShowEntranceRedDot", "isEnable", "storeLastPreFetchTime", "updateFindMoreFriendUI", "Companion", "plugin-finder_release"})
public final class e
  implements com.tencent.mm.al.f, o
{
  private static boolean rSh;
  public static final a rSi;
  public long enterTime;
  private final h rRU;
  public final a rRV;
  private final b rRW;
  private final AtomicInteger rRX;
  private final FinderHomeTabStateVM rRY;
  private final d.f rRZ;
  public long rSa;
  public int rSb;
  public boolean rSc;
  private final ConcurrentHashMap<String, List<i>> rSd;
  private final ConcurrentHashMap<String, i> rSe;
  private final ConcurrentHashMap<String, ara> rSf;
  private final c rSg;
  
  static
  {
    AppMethodBeat.i(178166);
    rSi = new a((byte)0);
    AppMethodBeat.o(178166);
  }
  
  public e(c paramc)
  {
    AppMethodBeat.i(178184);
    this.rSg = paramc;
    this.rRU = new h(this);
    this.rRV = new a(this);
    this.rRW = new b(this);
    this.rRX = new AtomicInteger();
    paramc = com.tencent.mm.ui.component.a.KiD;
    paramc = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramc, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rRY = ((FinderHomeTabStateVM)paramc);
    this.rRZ = d.g.O((d.g.a.a)q.rSB);
    this.rSd = new ConcurrentHashMap();
    this.rSe = new ConcurrentHashMap();
    this.rSf = new ConcurrentHashMap();
    AppMethodBeat.o(178184);
  }
  
  public static String Er(int paramInt)
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
  
  private static String a(aqu paramaqu)
  {
    AppMethodBeat.i(178180);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = paramaqu.GoP;
    p.g(localObject1, "info.show_infos");
    localObject1 = (Iterable)localObject1;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.gfB();
      }
      localStringBuilder.append(a((ase)localObject2, i));
      i += 1;
    }
    paramaqu = "CtrlInfo{tipsId=" + paramaqu.GoQ + " priority=" + paramaqu.priority + " type=" + paramaqu.type + " tipsShowInfo=" + localStringBuilder + '}';
    AppMethodBeat.o(178180);
    return paramaqu;
  }
  
  private static String a(ase paramase, int paramInt)
  {
    AppMethodBeat.i(178181);
    if (paramase == null)
    {
      AppMethodBeat.o(178181);
      return "[empty]";
    }
    paramase = "#" + paramInt + "{showType=" + paramase.uda + " count=" + paramase.count + " title=" + paramase.title + ' ' + "clearType=" + paramase.Gqr + " iconUrl=" + paramase.pkr + " path=" + paramase.path + " show_ext_info_type=" + paramase.Gqs + " parent=" + paramase.xfl + "} ";
    AppMethodBeat.o(178181);
    return paramase;
  }
  
  private final HashSet<String> a(final i parami, String paramString)
  {
    AppMethodBeat.i(201631);
    paramString = new StringBuilder("[buildPathWithCtrInfo] source=").append(paramString).append(' ');
    Object localObject1 = parami.field_ctrInfo;
    p.g(localObject1, "local.field_ctrInfo");
    ad.i("Finder.RedDotManager", a((aqu)localObject1) + " revokeId=" + parami.field_revokeId);
    localObject1 = new HashSet();
    Object localObject2 = ((Map)parami.rTc).entrySet().iterator();
    Map.Entry localEntry;
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject2).next();
      paramString = (List)this.rSd.get(localEntry.getKey());
      if (paramString != null) {
        break label378;
      }
      localObject3 = (e)this;
      paramString = Collections.synchronizedList((List)new LinkedList());
      localObject3 = (Map)((e)localObject3).rSd;
      Object localObject4 = localEntry.getKey();
      p.g(paramString, "list");
      ((Map)localObject3).put(localObject4, paramString);
    }
    label378:
    for (;;)
    {
      p.g(paramString, "crlInfoList");
      d.a.j.b(paramString, (d.g.a.b)new c(this, parami, (HashSet)localObject1));
      paramString.add(parami);
      localObject3 = new d.g.a.b[2];
      localObject3[0] = ((d.g.a.b)d.rSn);
      localObject3[1] = ((d.g.a.b)e.rSo);
      p.h(localObject3, "selectors");
      d.a.j.a(paramString, (Comparator)new b.a((d.g.a.b[])localObject3));
      ((HashSet)localObject1).add(localEntry.getKey());
      break;
      paramString = parami.field_revokeId;
      if (paramString != null) {
        ((Map)this.rSe).put(paramString, parami);
      }
      parami = ((Iterable)localObject1).iterator();
      while (parami.hasNext())
      {
        paramString = (String)parami.next();
        localObject2 = g.rSU;
        g.a(true, paramString, ahm(paramString), ahn(paramString));
      }
      AppMethodBeat.o(201631);
      return localObject1;
    }
  }
  
  private boolean a(aqu paramaqu, String paramString, asd paramasd, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(201627);
    p.h(paramaqu, "info");
    p.h(paramString, "source");
    p.h(paramasd, "tipsShowEntranceExtInfo");
    p.h(paramHashSet, "changePathSet");
    if (!czR())
    {
      localObject = paramaqu.GoP;
      p.g(localObject, "info.show_infos");
      com.tencent.mm.ad.c.a((LinkedList)localObject, (d.g.a.b)b.rSj);
      ad.i("Finder.RedDotManager", "[addNewRedDotCtrlInfo] remove DISCOVERY_TAB");
    }
    Object localObject = new i().b(paramaqu);
    ((i)localObject).field_tipsShowEntranceExtInfo = paramasd;
    ConcurrentHashMap localConcurrentHashMap = this.rSf;
    paramasd = ((i)localObject).field_revokeId;
    paramaqu = paramasd;
    if (paramasd == null) {
      paramaqu = "";
    }
    if (localConcurrentHashMap.contains(paramaqu))
    {
      paramaqu = new StringBuilder("[addNewRedDotCtrlInfo] has revoke. ").append(((i)localObject).field_revokeId).append(' ');
      paramString = ((i)localObject).field_ctrInfo;
      p.g(paramString, "local.field_ctrInfo");
      ad.e("Finder.RedDotManager", a(paramString));
      AppMethodBeat.o(201627);
      return false;
    }
    if (i.a((i)localObject, this.rSg))
    {
      paramHashSet.addAll((Collection)a((i)localObject, paramString));
      if (((i)localObject).field_ctrInfo.priority > 350000) {
        this.rRY.a(-1, FinderHomeTabStateVM.c.sZt);
      }
      AppMethodBeat.o(201627);
      return true;
    }
    AppMethodBeat.o(201627);
    return false;
  }
  
  private final boolean a(arz paramarz)
  {
    int k = -1;
    AppMethodBeat.i(201636);
    if ((paramarz.Gqk.type == 8) || (paramarz.Gqk.type == 7))
    {
      if (rSh)
      {
        localObject = paramarz.Gqk.GoP;
        p.g(localObject, "tabTip.ctrl_info.show_infos");
        d.a.j.b((List)localObject, (d.g.a.b)i.rSt);
        rSh = false;
      }
      Object localObject = paramarz.Gqk.GoP;
      p.g(localObject, "tabTip.ctrl_info.show_infos");
      localObject = ((List)localObject).iterator();
      int i = 0;
      if (((Iterator)localObject).hasNext()) {
        if (!p.i(((ase)((Iterator)localObject).next()).path, "FinderEntrance")) {}
      }
      for (;;)
      {
        if (i < 0) {
          break label191;
        }
        ad.i("Finder.RedDotManager", "[filterNotifyTabTip] has FINDER_ENTRANCE this tabTip type=" + paramarz.Gqk.type);
        AppMethodBeat.o(201636);
        return true;
        i += 1;
        break;
        i = -1;
      }
      label191:
      int j;
      label273:
      boolean bool;
      if (paramarz.Gqk.type == 8)
      {
        localObject = (List)this.rSd.get("FinderEntrance");
        j = k;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          i = 0;
          j = k;
          if (((Iterator)localObject).hasNext())
          {
            if (((i)((Iterator)localObject).next()).field_ctrInfo.type != 8) {
              break label339;
            }
            j = 1;
            if (j == 0) {
              break label344;
            }
            j = i;
          }
        }
        if (j >= 0) {}
        for (bool = true;; bool = false)
        {
          ad.i("Finder.RedDotManager", "[filterNotifyTabTip] ignore[" + bool + "] this tabTip type=" + paramarz.Gqk.type);
          if (bool) {
            break label357;
          }
          AppMethodBeat.o(201636);
          return true;
          label339:
          j = 0;
          break label273;
          label344:
          i += 1;
          break;
        }
        label357:
        AppMethodBeat.o(201636);
        return false;
      }
      if (paramarz.Gqk.type == 7)
      {
        localObject = (List)this.rSd.get("FinderEntrance");
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          i = 0;
          if (((Iterator)localObject).hasNext()) {
            if (((i)((Iterator)localObject).next()).field_ctrInfo.type == 7)
            {
              j = 1;
              label441:
              if (j == 0) {
                break label510;
              }
              label445:
              if (i < 0) {
                break label527;
              }
            }
          }
        }
        label527:
        for (bool = true;; bool = false)
        {
          ad.i("Finder.RedDotManager", "[filterNotifyTabTip] ignore[" + bool + "] this tabTip type=" + paramarz.Gqk.type);
          if (bool) {
            break label533;
          }
          AppMethodBeat.o(201636);
          return true;
          j = 0;
          break label441;
          label510:
          i += 1;
          break;
          i = -1;
          break label445;
          i = -1;
          break label445;
        }
        label533:
        AppMethodBeat.o(201636);
        return false;
      }
    }
    AppMethodBeat.o(201636);
    return true;
  }
  
  static long czO()
  {
    AppMethodBeat.i(201626);
    long l1 = cf.aCM();
    j localj = j.rTk;
    long l2 = j.cAv();
    AppMethodBeat.o(201626);
    return l1 - l2;
  }
  
  public static long czQ()
  {
    AppMethodBeat.i(178182);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IHn, Long.valueOf(0L));
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
  
  private static asd dC(List<? extends ase> paramList)
  {
    AppMethodBeat.i(201638);
    asd localasd = new asd();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      ase localase = (ase)paramList.next();
      int i = localase.Gqs;
      if (i == 1)
      {
        com.tencent.mm.bx.b localb = localase.Gqt;
        p.g(localb, "it.show_ext_info");
        localasd.parseFrom(localb.getBytes());
        ad.i("Finder.RedDotManager", "[parseExtInfo] path=" + localase.path + " objectId=" + com.tencent.mm.ad.c.rc(localasd.Gqn) + " tabType=" + localasd.Glz + " report_ext_info=" + localasd.Gqq + " showExtInfoType=" + i);
      }
    }
    AppMethodBeat.o(201638);
    return localasd;
  }
  
  public final void Ep(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(178170);
    Object localObject = ahn("FinderEntrance");
    int i;
    if ((localObject != null) && (((i)localObject).ahq("FinderEntrance") != null))
    {
      localObject = ((i)localObject).field_ctrInfo;
      if (localObject != null)
      {
        i = ((aqu)localObject).type;
        if (i != -1) {
          bool = true;
        }
      }
    }
    for (this.rSc = bool;; this.rSc = false)
    {
      this.rSb = paramInt;
      this.enterTime = cf.aCM();
      ahl("FinderEntrance");
      ahl("Discovery");
      ad.i("Finder.RedDotManager", "[enterFinder] hasRedDotWhenEnter=" + this.rSc);
      AppMethodBeat.o(178170);
      return;
      i = 0;
      break;
    }
  }
  
  public final void Eq(int paramInt)
  {
    AppMethodBeat.i(201625);
    if (paramInt <= 0)
    {
      ad.i("Finder.RedDotManager", "[notifyFinderFansAddCount] server error.");
      AppMethodBeat.o(201625);
      return;
    }
    ad.i("Finder.RedDotManager", "[notifyFinderFansAddCount] count = ".concat(String.valueOf(paramInt)));
    aqu localaqu = new aqu();
    localaqu.GoQ = String.valueOf(cf.aCM());
    localaqu.priority = 100000;
    localaqu.type = 2;
    ase localase = new ase();
    localase.uda = 2;
    localase.Gqr = 1;
    localase.path = "AuthorProfileFans";
    localase.count = paramInt;
    localaqu.GoP.add(localase);
    a(this, localaqu, "notifyFinderFansAddCount", null, null, 12);
    AppMethodBeat.o(201625);
  }
  
  public final boolean Es(int paramInt)
  {
    AppMethodBeat.i(201640);
    asd localasd = Et(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("[containsTabTipsExtInfo] tabType=").append(paramInt).append(" isContains=");
    if (localasd.Glz != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("Finder.RedDotManager", bool);
      if (localasd.Glz == 0) {
        break;
      }
      AppMethodBeat.o(201640);
      return true;
    }
    AppMethodBeat.o(201640);
    return false;
  }
  
  public final asd Et(int paramInt)
  {
    AppMethodBeat.i(201641);
    asd localasd = aho(Er(paramInt));
    ad.i("Finder.RedDotManager", "[getTabTipsExtInfo] tabType=" + paramInt + " ext=" + f.a(localasd));
    AppMethodBeat.o(201641);
    return localasd;
  }
  
  public final void a(aqt paramaqt)
  {
    AppMethodBeat.i(178171);
    p.h(paramaqt, "redDot");
    long l = cf.aCM();
    Object localObject1 = j.rTk;
    l -= j.cAv();
    localObject1 = new StringBuilder("[notifyRedDot] diffTime=").append(l).append(" newMsgTipsEnterInterval=");
    Object localObject2 = j.rTk;
    localObject1 = ((StringBuilder)localObject1).append(j.cAo()).append(" showRed=").append(paramaqt.GoM).append(' ');
    localObject2 = paramaqt.GoN;
    p.g(localObject2, "redDot.ctrlInfo");
    ad.i("Finder.RedDotManager", a((aqu)localObject2));
    localObject1 = j.rTk;
    if (l < j.cAo())
    {
      localObject1 = paramaqt.GoN.GoP;
      p.g(localObject1, "redDot.ctrlInfo.show_infos");
      com.tencent.mm.ad.c.a((LinkedList)localObject1, (d.g.a.b)j.rSu);
    }
    paramaqt = paramaqt.GoN;
    p.g(paramaqt, "redDot.ctrlInfo");
    a(this, paramaqt, "notifyRedDot", null, null, 12);
    AppMethodBeat.o(178171);
  }
  
  public final void a(aqu paramaqu, String paramString)
  {
    AppMethodBeat.i(201630);
    p.h(paramaqu, "local");
    p.h(paramString, "source");
    int j = paramaqu.type;
    Object localObject3 = new HashMap();
    Iterator localIterator1 = ((Map)this.rSd).entrySet().iterator();
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
        ad.i("Finder.RedDotManager", "[reBuildPathWithCtrInfo] type=" + j + " clearMap=" + localObject3 + " source=" + paramString);
      }
      localObject1 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterable)((Map.Entry)((Iterator)localObject1).next()).getValue()).iterator();
        while (((Iterator)localObject2).hasNext()) {
          i.b((i)((Iterator)localObject2).next(), this.rSg);
        }
      }
    }
    Object localObject1 = new HashSet();
    a(this, paramaqu, paramString, null, (HashSet)localObject1, 4);
    paramString = (Map)localObject3;
    paramaqu = (Map)new LinkedHashMap();
    paramString = paramString.entrySet().iterator();
    label480:
    while (paramString.hasNext())
    {
      localObject2 = (Map.Entry)paramString.next();
      if (!((HashSet)localObject1).contains(((Map.Entry)localObject2).getKey())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label480;
        }
        paramaqu.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        break;
      }
    }
    paramaqu = paramaqu.entrySet().iterator();
    while (paramaqu.hasNext())
    {
      localObject1 = (Map.Entry)paramaqu.next();
      paramString = (String)((Map.Entry)localObject1).getKey();
      localObject1 = ((Iterable)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject1).hasNext()) {
        i.b((i)((Iterator)localObject1).next(), this.rSg);
      }
      localObject1 = ahn(paramString);
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).ahq(paramString);
        if (localObject2 != null) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label638;
          }
          localObject3 = g.rSU;
          g.a(false, paramString, null, null);
          localObject3 = g.rSU;
          g.a(true, paramString, (ase)localObject2, (i)localObject1);
          break;
        }
        label638:
        localObject1 = g.rSU;
        g.a(false, paramString, null, null);
      }
      else
      {
        localObject1 = g.rSU;
        g.a(false, paramString, null, null);
      }
    }
    AppMethodBeat.o(201630);
  }
  
  public final void a(final aqz paramaqz)
  {
    AppMethodBeat.i(201645);
    p.h(paramaqz, "revoke");
    ad.i("Finder.RedDotManager", "[revokeRedDot] " + paramaqz.GoU.size());
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new p(this, paramaqz));
    AppMethodBeat.o(201645);
  }
  
  public final void a(ary paramary, String paramString)
  {
    AppMethodBeat.i(201637);
    p.h(paramary, "tabTips");
    p.h(paramString, "source");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1)
    {
      AppMethodBeat.o(201637);
      return;
    }
    long l = czO();
    paramary = paramary.GoV;
    p.g(paramary, "tabTips.tab_tips_info");
    localObject1 = (Iterable)paramary;
    paramary = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (arz)localObject2;
      p.g(localObject3, "it");
      if (a((arz)localObject3)) {
        paramary.add(localObject2);
      }
    }
    paramary = ((Iterable)paramary).iterator();
    if (paramary.hasNext())
    {
      localObject1 = (arz)paramary.next();
      localObject2 = new StringBuilder("[notifyTabTip] ");
      localObject3 = ((arz)localObject1).Gqk;
      p.g(localObject3, "tipsInfo.ctrl_info");
      ad.i("Finder.RedDotManager", a((aqu)localObject3));
      localObject2 = ((arz)localObject1).Gqk.GoP;
      p.g(localObject2, "tipsInfo.ctrl_info.show_infos");
      localObject2 = dC((List)localObject2);
      j localj;
      if (((arz)localObject1).Gqk.type == 8)
      {
        localObject3 = j.rTk;
        if (l <= j.cAm())
        {
          localObject3 = ((arz)localObject1).Gqk.GoP;
          p.g(localObject3, "tipsInfo.ctrl_info.show_infos");
          com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)k.rSv);
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFollowTabTimeMs=");
          localj = j.rTk;
          ad.w("Finder.RedDotManager", j.cAm() + "ms, remove this ctrInfo");
        }
        localObject3 = j.rTk;
        if (l <= j.cAk())
        {
          localObject3 = ((arz)localObject1).Gqk.GoP;
          p.g(localObject3, "tipsInfo.ctrl_info.show_infos");
          com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)l.rSw);
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFollowTabTimeMs=");
          localj = j.rTk;
          ad.w("Finder.RedDotManager", j.cAk() + "ms, remove entrance path red dot");
        }
      }
      for (;;)
      {
        boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
        if (bool)
        {
          if (this.rRY.sZg == ((asd)localObject2).Glz)
          {
            ad.w("Finder.RedDotManager", "[notifyTabTip] it is in finder " + ((asd)localObject2).Glz + " now. currentTabType=" + this.rRY.sZg + " extTab_type=" + ((asd)localObject2).Glz);
            ((arz)localObject1).Gqk.GoR = 1L;
          }
          localObject3 = ((arz)localObject1).Gqk.GoP;
          p.g(localObject3, "tipsInfo.ctrl_info.show_infos");
          com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)n.rSy);
          ad.w("Finder.RedDotManager", "[notifyTabTip] it is in finder now. just remove path of FINDER_ENTRANCE, currentTabType=" + this.rRY.sZg + " extTab_type=" + ((asd)localObject2).Glz);
        }
        a(this, ((arz)localObject1).Gqk.type);
        ((arz)localObject1).Gqk.dtq = ((asd)localObject2).Gqn;
        localObject3 = ((arz)localObject1).Gqk;
        p.g(localObject3, "tipsInfo.ctrl_info");
        a(this, (aqu)localObject3, "notifyTabTip#".concat(String.valueOf(paramString)), (asd)localObject2, null, 8);
        int i = aho("FinderEntrance").Glz;
        if ((i != 0) && ((i == 3) || (i == 1) || (i == 4))) {
          this.rRY.a(i, FinderHomeTabStateVM.c.sZt);
        }
        ad.i("Finder.RedDotManager", "[notifyTabTip] successfully! tabType=" + ((asd)localObject2).Glz + " objectId=" + ((asd)localObject2).Gqn + " diffTime=" + l + "ms isInFinder=" + bool + " currentTabType=" + this.rRY.sZg + " showInfoSize=" + ((arz)localObject1).Gqk.GoP.size());
        break;
        if (((arz)localObject1).Gqk.type == 7)
        {
          localObject3 = j.rTk;
          if (l <= j.cAn())
          {
            localObject3 = ((arz)localObject1).Gqk.GoP;
            p.g(localObject3, "tipsInfo.ctrl_info.show_infos");
            com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)m.rSx);
            localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFriendEntranceTimeMs=");
            localj = j.rTk;
            ad.w("Finder.RedDotManager", j.cAn() + "ms, remove entrance path red dot");
          }
        }
      }
    }
    AppMethodBeat.o(201637);
  }
  
  public final void a(asw paramasw)
  {
    AppMethodBeat.i(178172);
    p.h(paramasw, "wxMention");
    long l = cf.aCM();
    Object localObject = j.rTk;
    l -= j.cAv();
    if ((paramasw.count <= 0) && (paramasw.GqR <= 0) && (paramasw.GqQ <= 0) && (paramasw.GlK <= 0) && (paramasw.GlJ <= 0) && (paramasw.GqP <= 0) && (paramasw.GqS <= 0))
    {
      ad.e("Finder.RedDotManager", "[notifyWxMentionCount] server error.");
      AppMethodBeat.o(178172);
      return;
    }
    localObject = new StringBuilder("[notifyWxMentionCount] diffTime=").append(l).append(' ');
    aqu localaqu = paramasw.Gqk;
    p.g(localaqu, "wxMention.ctrl_info");
    ad.i("Finder.RedDotManager", a(localaqu) + " count=" + paramasw.count);
    localObject = j.rTk;
    if (l < j.cAo())
    {
      localObject = paramasw.Gqk.GoP;
      p.g(localObject, "wxMention.ctrl_info.show_infos");
      com.tencent.mm.ad.c.a((LinkedList)localObject, (d.g.a.b)o.rSz);
    }
    paramasw = paramasw.Gqk;
    p.g(paramasw, "wxMention.ctrl_info");
    a(this, paramasw, "notifyWxMentionCount", null, null, 12);
    AppMethodBeat.o(178172);
  }
  
  public final boolean a(int paramInt, d.g.a.b<? super i, Boolean> paramb)
  {
    AppMethodBeat.i(201634);
    p.h(paramb, "filter");
    HashMap localHashMap = new HashMap();
    Object localObject3 = ((Map)this.rSd).entrySet().iterator();
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
        ad.i("Finder.RedDotManager", "[clearCtrlInfo] type=" + paramInt + " clearMap=" + localHashMap);
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
          i.b((i)((Iterator)localObject2).next(), this.rSg);
          continue;
          i = 0;
          break;
        }
      }
      localObject2 = ahn((String)localObject1);
      if (localObject2 != null)
      {
        localObject3 = ((i)localObject2).ahq((String)localObject1);
        if (localObject3 != null) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label437;
          }
          localObject4 = g.rSU;
          g.a(false, (String)localObject1, null, null);
          localObject4 = g.rSU;
          g.a(true, (String)localObject1, (ase)localObject3, (i)localObject2);
          break;
        }
        label437:
        localObject2 = g.rSU;
        g.a(false, (String)localObject1, null, null);
      }
      else
      {
        localObject2 = g.rSU;
        g.a(false, (String)localObject1, null, null);
      }
    }
    label469:
    if (!((Map)localHashMap).isEmpty())
    {
      AppMethodBeat.o(201634);
      return true;
    }
    AppMethodBeat.o(201634);
    return false;
  }
  
  public final boolean a(final i parami)
  {
    AppMethodBeat.i(201633);
    p.h(parami, "ctrInfo");
    Object localObject1 = parami.rTc.keySet();
    p.g(localObject1, "ctrInfo.showInfoMap.keys");
    localObject1 = ((Iterable)localObject1).iterator();
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = (List)this.rSd.get(str);
      if (localObject2 != null) {
        d.a.j.b((List)localObject2, (d.g.a.b)new h(this, parami));
      }
      p.g(str, "removePath");
      localObject2 = ahn(str);
      if (localObject2 != null)
      {
        ase localase = ((i)localObject2).ahq(str);
        if (localase != null) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label172;
          }
          g localg = g.rSU;
          g.a(false, str, null, null);
          localg = g.rSU;
          g.a(true, str, localase, (i)localObject2);
          break;
        }
        label172:
        localObject2 = g.rSU;
        g.a(false, str, null, null);
      }
      else
      {
        localObject2 = g.rSU;
        g.a(false, str, null, null);
      }
    }
    if (i.b(parami, this.rSg))
    {
      localObject1 = com.tencent.mm.ui.component.a.KiD;
      localObject1 = (FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class);
      p.h(parami, "ctrInfo");
      switch (parami.field_ctrInfo.type)
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        parami = ((FinderStreamTabPreloadCore)localObject1).EQ(i);
        if (parami != null) {
          parami.AB(true);
        }
        ad.i("Finder.StreamTabPreloadCore", "[onRedDotRevoke] tabType=".concat(String.valueOf(i)));
        AppMethodBeat.o(201633);
        return true;
        i = 3;
        continue;
        i = 1;
        continue;
        i = 4;
        continue;
        i = 2;
      }
    }
    AppMethodBeat.o(201633);
    return false;
  }
  
  public final void ahl(String paramString)
  {
    AppMethodBeat.i(178176);
    p.h(paramString, "path");
    e(paramString, null);
    AppMethodBeat.o(178176);
  }
  
  public final ase ahm(String paramString)
  {
    AppMethodBeat.i(178178);
    p.h(paramString, "path");
    i locali = ahn(paramString);
    if (locali != null)
    {
      paramString = locali.ahq(paramString);
      AppMethodBeat.o(178178);
      return paramString;
    }
    AppMethodBeat.o(178178);
    return null;
  }
  
  public final i ahn(String paramString)
  {
    AppMethodBeat.i(178179);
    p.h(paramString, "path");
    Object localObject = (List)this.rSd.get(paramString);
    if (localObject != null)
    {
      ListIterator localListIterator = ((List)localObject).listIterator(((List)localObject).size());
      int i;
      if (localListIterator.hasPrevious())
      {
        localObject = localListIterator.previous();
        if (((i)localObject).ahq(paramString) != null)
        {
          i = 1;
          label74:
          if (i == 0) {
            break label96;
          }
        }
      }
      for (paramString = (String)localObject;; paramString = null)
      {
        paramString = (i)paramString;
        AppMethodBeat.o(178179);
        return paramString;
        i = 0;
        break label74;
        label96:
        break;
      }
    }
    AppMethodBeat.o(178179);
    return null;
  }
  
  public final asd aho(String paramString)
  {
    AppMethodBeat.i(201639);
    p.h(paramString, "path");
    paramString = ahn(paramString);
    if (paramString != null)
    {
      asd localasd = paramString.cAi();
      paramString = localasd;
      if (localasd != null) {}
    }
    else
    {
      paramString = new asd();
    }
    AppMethodBeat.o(201639);
    return paramString;
  }
  
  public final void czN()
  {
    AppMethodBeat.i(178169);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    long l2;
    long l1;
    boolean bool2;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1)
    {
      l2 = czQ();
      if (l2 <= 0L)
      {
        ad.i("Finder.RedDotManager", "[checkPreFetchNow] it's not preFetch yet.");
        AppMethodBeat.o(178169);
        return;
      }
      localObject = j.rTk;
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject, "MMKernel.service(IConfigService::class.java)");
      l1 = ((com.tencent.mm.plugin.zero.b.a)localObject).acA().getInt("FinderRefreshDiscoveryInterval", 1200) * 1000L / j.cAy();
      bool2 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
      l2 = cf.aCM() - l2;
      localObject = new StringBuilder("[checkPreFetchNow] isInFinder=").append(bool2).append(" diffTime=").append(l2).append(" expired=").append(l1).append(" ret=");
      if (l2 < l1) {
        break label243;
      }
    }
    label243:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("Finder.RedDotManager", bool1);
      if ((!bool2) && (l2 >= l1)) {
        ((com.tencent.mm.loader.g.i)this.rRZ.getValue()).a(new com.tencent.mm.loader.g.h((d.g.a.b)new f(this)));
      }
      AppMethodBeat.o(178169);
      return;
    }
  }
  
  public final int czP()
  {
    AppMethodBeat.i(201632);
    String str = Er(1);
    i locali = ahn(str);
    if ((locali != null) && (locali.ahp(str) == true))
    {
      AppMethodBeat.o(201632);
      return 1;
    }
    str = Er(3);
    locali = ahn(str);
    if ((locali != null) && (locali.ahp(str) == true))
    {
      AppMethodBeat.o(201632);
      return 3;
    }
    str = Er(4);
    locali = ahn(str);
    if ((locali != null) && (locali.ahp(str) == true))
    {
      AppMethodBeat.o(201632);
      return 4;
    }
    AppMethodBeat.o(201632);
    return -1;
  }
  
  public final boolean czR()
  {
    AppMethodBeat.i(201642);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    boolean bool = locale.ajl().getBoolean(al.a.IIH, true);
    AppMethodBeat.o(201642);
    return bool;
  }
  
  public final void e(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(201629);
    p.h(paramString, "path");
    Object localObject1 = new HashSet();
    i locali = ahn(paramString);
    if (locali != null) {}
    Object localObject2;
    Object localObject3;
    for (ase localase = locali.ahq(paramString);; localase = null)
    {
      localObject2 = (List)this.rSd.get(paramString);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      if (localObject2 == null) {
        break;
      }
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (i)((Iterator)localObject2).next();
        if ((paramArrayOfInt == null) || (d.a.e.contains(paramArrayOfInt, ((i)localObject3).field_ctrInfo.type)))
        {
          LinkedList localLinkedList = ((i)localObject3).ahr(paramString);
          if (i.a((i)localObject3, this.rSg)) {
            ((HashSet)localObject1).addAll((Collection)localLinkedList);
          }
          if (((i)localObject3).cAj()) {
            ((Iterator)localObject2).remove();
          }
        }
      }
    }
    ad.i("Finder.RedDotManager", "[disposeRedDotAtPath] path=" + paramString + " ctrlType=" + paramArrayOfInt + " removePathSet=" + localObject1 + " maybeRemoveShowInfo=" + a(localase, 0));
    paramString = ((Iterable)localObject1).iterator();
    while (paramString.hasNext())
    {
      paramArrayOfInt = (String)paramString.next();
      localObject1 = ahn(paramArrayOfInt);
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).ahq(paramArrayOfInt);
        if (localObject2 != null) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label326;
          }
          localObject3 = g.rSU;
          g.a(false, paramArrayOfInt, localase, locali);
          localObject3 = g.rSU;
          g.a(true, paramArrayOfInt, (ase)localObject2, (i)localObject1);
          break;
        }
        label326:
        localObject1 = g.rSU;
        g.a(false, paramArrayOfInt, localase, locali);
      }
      else
      {
        localObject1 = g.rSU;
        g.a(false, paramArrayOfInt, localase, locali);
      }
    }
    AppMethodBeat.o(201629);
  }
  
  public final void fJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201624);
    if ((paramInt1 <= 0) && (paramInt2 <= 0))
    {
      ad.i("Finder.RedDotManager", "[notifyFinderMsgCount] server error.");
      AppMethodBeat.o(201624);
      return;
    }
    ad.i("Finder.RedDotManager", "[notifyFinderMsgCount] normalCount = " + paramInt1 + ", systemCount = " + paramInt2);
    aqu localaqu = new aqu();
    localaqu.GoQ = String.valueOf(cf.aCM());
    localaqu.priority = 100000;
    localaqu.type = 2;
    ase localase = new ase();
    localase.uda = 2;
    localase.Gqr = 1;
    localase.path = "AuthorProfileNotify";
    localase.count = (paramInt1 + paramInt2);
    localaqu.GoP.add(localase);
    if (paramInt2 > 0)
    {
      localase = new ase();
      localase.uda = 2;
      localase.Gqr = 1;
      localase.path = "NotificitionCenterNotify";
      localase.count = paramInt2;
      localaqu.GoP.add(localase);
    }
    a(this, localaqu, "notifyFinderMsgCount", null, null, 12);
    AppMethodBeat.o(201624);
  }
  
  public final void lN(boolean paramBoolean)
  {
    AppMethodBeat.i(201643);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIH, Boolean.valueOf(paramBoolean));
    localObject = com.tencent.mm.plugin.finder.report.h.soM;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.finder.report.h.fK(1, i);
      AppMethodBeat.o(201643);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = true;
    AppMethodBeat.i(201644);
    ad.i("Finder.RedDotManager", "scene = ".concat(String.valueOf(paramn)));
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    do
    {
      AppMethodBeat.o(201644);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.rRU;
    boolean bool1;
    if (!bt.isNullOrNil(u.aAu()))
    {
      bool1 = true;
      label88:
      paramn = com.tencent.mm.kernel.g.ajC();
      p.g(paramn, "MMKernel.storage()");
      paramInt2 = paramn.ajl().getInt(al.a.IIb, h.cAh());
      paramn = com.tencent.mm.plugin.finder.storage.b.sxa;
      if ((!com.tencent.mm.plugin.finder.storage.b.cFK()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
        break label325;
      }
      paramInt1 = 1;
      label144:
      if ((paramInt1 == 0) || (!h.Eu(paramInt2)) || (bool1)) {
        break label330;
      }
    }
    for (;;)
    {
      ad.i("Finder.RedDotTransform", "[isShowLocalRedDot] ret=" + bool2 + " local=" + paramInt2 + " hasCreatedIdentity=" + bool1);
      if (!bool2) {
        break;
      }
      paramString.cAg();
      paramString = com.tencent.mm.kernel.g.ajC();
      p.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.ajl().getInt(al.a.IIb, h.cAh());
      paramInt2 = paramInt1 & 0xFFFFFFFD;
      if (paramInt2 != paramInt1)
      {
        paramString = com.tencent.mm.kernel.g.ajC();
        p.g(paramString, "MMKernel.storage()");
        paramString.ajl().set(al.a.IIb, Integer.valueOf(paramInt2));
      }
      ad.i("Finder.RedDotTransform", "[setLocalRedDot] flag=2 unset=true newLocal=" + paramInt2 + " local=" + paramInt1);
      ad.i("Finder.RedDotTransform", "[transformPostRedDot] done");
      break;
      bool1 = false;
      break label88;
      label325:
      paramInt1 = 0;
      break label144;
      label330:
      bool2 = false;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(178168);
    if (!aj.cmR())
    {
      AppMethodBeat.o(178168);
      return;
    }
    com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("Finder.RedDotManager");
    Object localObject1 = this.rRW;
    com.tencent.mm.plugin.newtips.a.dum().a("FinderNewTipsTransform", (l.a)localObject1);
    localObject1 = ((Iterable)this.rSg.cns()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      if (((i)localObject2).cAj())
      {
        ad.w("Finder.RedDotManager", "[prepare] showInfo is empty! ".concat(String.valueOf(localObject2)));
        ((i)localObject2).b(this.rSg, false);
      }
      aqu localaqu = ((i)localObject2).field_ctrInfo;
      p.g(localaqu, "it.field_ctrInfo");
      a(((i)localObject2).b(localaqu), "prepare");
    }
    Object localObject2 = this.rRU;
    localObject1 = ((h)localObject2).rRG.ahn("FinderEntrance");
    if ((localObject1 != null) && (((i)localObject1).field_ctrInfo.type == -1))
    {
      localObject1 = ((i)localObject1).ahq("FinderEntrance");
      if (localObject1 == null) {
        break label296;
      }
      localObject1 = Integer.valueOf(((ase)localObject1).Gqr);
      if (localObject1 != null) {
        break label301;
      }
    }
    for (;;)
    {
      ad.i("Finder.RedDotTransform", "[checkPostRedDot] has old fav red dot, ret=".concat(String.valueOf(a(((h)localObject2).rRG, 1001))));
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1)
      {
        a(this, 7);
        a(this, 8);
        a(this, 1004);
        a(this, 1003);
      }
      a(this, 1005);
      localb.akO();
      AppMethodBeat.o(178168);
      return;
      label296:
      localObject1 = null;
      break;
      label301:
      if (((Integer)localObject1).intValue() == 2)
      {
        ad.i("Finder.RedDotTransform", "[checkPostRedDot] has old post red dot, ret=".concat(String.valueOf(a(((h)localObject2).rRG, -1))));
        ((h)localObject2).cAg();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$Companion;", "", "()V", "TAB_TIPS_TEST", "", "getTAB_TIPS_TEST", "()Z", "setTAB_TIPS_TEST", "(Z)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final b rSj;
    
    static
    {
      AppMethodBeat.i(201608);
      rSj = new b();
      AppMethodBeat.o(201608);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$buildPathWithCtrInfo$1$1"})
  static final class c
    extends q
    implements d.g.a.b<i, Boolean>
  {
    c(e parame, i parami, HashSet paramHashSet)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<i, Integer>
  {
    public static final d rSn;
    
    static
    {
      AppMethodBeat.i(178152);
      rSn = new d();
      AppMethodBeat.o(178152);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<i, Long>
  {
    public static final e rSo;
    
    static
    {
      AppMethodBeat.i(178154);
      rSo = new e();
      AppMethodBeat.o(178154);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<i, Boolean>
  {
    public static final g rSr;
    
    static
    {
      AppMethodBeat.i(201611);
      rSr = new g();
      AppMethodBeat.o(201611);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$deleteCtrlInfo$1$1"})
  static final class h
    extends q
    implements d.g.a.b<i, Boolean>
  {
    h(e parame, i parami)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final i rSt;
    
    static
    {
      AppMethodBeat.i(201614);
      rSt = new i();
      AppMethodBeat.o(201614);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final j rSu;
    
    static
    {
      AppMethodBeat.i(178161);
      rSu = new j();
      AppMethodBeat.o(178161);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final k rSv;
    
    static
    {
      AppMethodBeat.i(201616);
      rSv = new k();
      AppMethodBeat.o(201616);
    }
    
    k()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final l rSw;
    
    static
    {
      AppMethodBeat.i(201618);
      rSw = new l();
      AppMethodBeat.o(201618);
    }
    
    l()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final m rSx;
    
    static
    {
      AppMethodBeat.i(201620);
      rSx = new m();
      AppMethodBeat.o(201620);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final n rSy;
    
    static
    {
      AppMethodBeat.i(201622);
      rSy = new n();
      AppMethodBeat.o(201622);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    public static final o rSz;
    
    static
    {
      AppMethodBeat.i(178163);
      rSz = new o();
      AppMethodBeat.o(178163);
    }
    
    o()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<z>
  {
    p(e parame, aqz paramaqz)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<com.tencent.mm.loader.g.i>
  {
    public static final q rSB;
    
    static
    {
      AppMethodBeat.i(178165);
      rSB = new q();
      AppMethodBeat.o(178165);
    }
    
    q()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.e
 * JD-Core Version:    0.7.0.1
 */