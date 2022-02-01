package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.cgi.g.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.a.j;
import d.g.b.w;
import d.v;
import d.y;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRedDotManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;)V", "enterSource", "", "enterTime", "", "hasRedDotWhenEnter", "", "newTipsTransform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "pathToCtrInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "preFetchToken", "Ljava/util/concurrent/atomic/AtomicInteger;", "singleTaskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "getSingleTaskExecutor", "()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "singleTaskExecutor$delegate", "Lkotlin/Lazy;", "stateCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stayDuration", "tempTabTipsRecord", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "getTransform", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "addNewRedDotCtrlInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "buildPathWithCtrInfo", "", "local", "checkPreFetchNow", "clearCtrlInfo", "type", "containsTabTipsExtInfo", "tabType", "ctrlInfoAtPath", "path", "disposeRedDotAtPath", "enterFinder", "exitFinder", "findExtInfoAtCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getDiffExitTimeMs", "getPathByTabType", "getTabTipsExtInfo", "getTipsShowInfoAtPath", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "hasPrefetch", "isEnableShowEntranceRedDot", "isShowInteractionRedDot", "lastPreFetchTime", "needToRefreshForPrefetch", "notifyPrefetch", "prefetch", "Lcom/tencent/mm/protocal/protobuf/FinderPreFetch;", "notifyRedDot", "redDot", "Lcom/tencent/mm/protocal/protobuf/FinderRedDot;", "notifyTabTip", "tabTips", "Lcom/tencent/mm/protocal/protobuf/FinderTabTips;", "notifyWxMentionCount", "wxMention", "Lcom/tencent/mm/protocal/protobuf/FinderWxMentionCount;", "onPreFetchDone", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "needShowRedDot", "isInFinder", "token", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseExtInfo", "showInfoList", "", "prepare", "printCtrInfo", "printTipsShowInfo", "index", "resetPreFetchTime", "setEnableShowEntranceRedDot", "isEnable", "storeLastPreFetchTime", "takeTabTipsExtInfo", "updateFindMoreFriendUI", "Companion", "plugin-finder_release"})
public final class c
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.i.a.h
{
  public static final a qtk;
  private final h KMt;
  private final FinderHomeTabStateVM KMu;
  private final HashSet<Integer> KMv;
  private long enterTime;
  public final e qtc;
  private final AtomicInteger qtd;
  private final d.f qte;
  private long qtf;
  private int qtg;
  private boolean qth;
  private final ConcurrentHashMap<String, List<f>> qti;
  private final a qtj;
  
  static
  {
    AppMethodBeat.i(178166);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(c.class), "singleTaskExecutor", "getSingleTaskExecutor()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;")) };
    qtk = new a((byte)0);
    AppMethodBeat.o(178166);
  }
  
  public c(a parama)
  {
    AppMethodBeat.i(178184);
    this.qtj = parama;
    this.qtc = new e(this);
    this.KMt = new h(this);
    this.qtd = new AtomicInteger();
    parama = com.tencent.mm.ui.component.a.LCX;
    parama = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(parama, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.KMu = ((FinderHomeTabStateVM)parama);
    this.qte = d.g.E((d.g.a.a)i.qtx);
    this.KMv = new HashSet();
    this.qti = new ConcurrentHashMap();
    AppMethodBeat.o(178184);
  }
  
  private static String a(akv paramakv)
  {
    AppMethodBeat.i(178180);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = paramakv.Dmt;
    d.g.b.k.g(localObject1, "info.show_infos");
    localObject1 = (Iterable)localObject1;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.fvx();
      }
      localStringBuilder.append(a((aln)localObject2, i));
      i += 1;
    }
    paramakv = "CtrlInfo{tipsId=" + paramakv.Dmu + " priority=" + paramakv.priority + " type=" + paramakv.type + " tipsShowInfo=" + localStringBuilder + '}';
    AppMethodBeat.o(178180);
    return paramakv;
  }
  
  private static String a(aln paramaln, int paramInt)
  {
    AppMethodBeat.i(178181);
    if (paramaln == null)
    {
      AppMethodBeat.o(178181);
      return "[empty]";
    }
    paramaln = "#" + paramInt + "{showType=" + paramaln.rXs + " count=" + paramaln.count + " title=" + paramaln.title + ' ' + "clearType=" + paramaln.DmL + " iconUrl=" + paramaln.odo + " path=" + paramaln.path + " show_ext_info_type=" + paramaln.LyB + " parent=" + paramaln.uOH + "} ";
    AppMethodBeat.o(178181);
    return paramaln;
  }
  
  private final void a(final f paramf, String paramString)
  {
    AppMethodBeat.i(178177);
    paramString = new StringBuilder("[buildPathWithCtrInfo] source=").append(paramString).append(' ');
    Object localObject1 = paramf.field_ctrInfo;
    d.g.b.k.g(localObject1, "local.field_ctrInfo");
    ad.i("Finder.RedDotManager", a((akv)localObject1));
    localObject1 = new HashSet();
    Iterator localIterator = ((Map)paramf.qtL).entrySet().iterator();
    Map.Entry localEntry;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      paramString = (List)this.qti.get(localEntry.getKey());
      if (paramString != null) {
        break label318;
      }
      Object localObject2 = (c)this;
      paramString = Collections.synchronizedList((List)new LinkedList());
      localObject2 = (Map)((c)localObject2).qti;
      Object localObject3 = localEntry.getKey();
      d.g.b.k.g(paramString, "list");
      ((Map)localObject2).put(localObject3, paramString);
    }
    label318:
    for (;;)
    {
      d.g.b.k.g(paramString, "crlInfoList");
      j.a(paramString, (d.g.a.b)new b(this, paramf, (HashSet)localObject1));
      paramString.add(paramf);
      j.a(paramString, d.b.a.a(new d.g.a.b[] { (d.g.a.b)c.qto, (d.g.a.b)d.qtp }));
      ((HashSet)localObject1).add(localEntry.getKey());
      break;
      paramf = ((Iterable)localObject1).iterator();
      while (paramf.hasNext())
      {
        paramString = (String)paramf.next();
        localObject1 = d.qtG;
        d.a(true, paramString, YV(paramString), YW(paramString));
      }
      AppMethodBeat.o(178177);
      return;
    }
  }
  
  private final dzv aVk(String paramString)
  {
    AppMethodBeat.i(197582);
    dzv localdzv = new dzv();
    paramString = YW(paramString);
    if (paramString != null)
    {
      com.tencent.mm.bx.b localb = paramString.field_ctrInfo.Dms;
      paramString = localb;
      if (localb == null) {
        paramString = null;
      }
      if (paramString == null) {}
    }
    try
    {
      localdzv.parseFrom(paramString.toByteArray());
      AppMethodBeat.o(197582);
      return localdzv;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("Finder.RedDotManager", (Throwable)paramString, "", new Object[0]);
        paramString = y.JfV;
      }
    }
  }
  
  private static String ahf(int paramInt)
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
  
  private final m cll()
  {
    AppMethodBeat.i(178167);
    m localm = (m)this.qte.getValue();
    AppMethodBeat.o(178167);
    return localm;
  }
  
  public static long cln()
  {
    AppMethodBeat.i(178182);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fww, Long.valueOf(0L));
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
  
  private static dzv dO(List<? extends aln> paramList)
  {
    AppMethodBeat.i(197581);
    dzv localdzv = new dzv();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      aln localaln = (aln)paramList.next();
      int i = localaln.LyB;
      if (i == 1)
      {
        com.tencent.mm.bx.b localb = localaln.LyC;
        d.g.b.k.g(localb, "it.show_ext_info");
        localdzv.parseFrom(localb.getBytes());
        ad.i("Finder.RedDotManager", "[parseExtInfo] path=" + localaln.path + " objectId=" + com.tencent.mm.ad.c.ly(localdzv.Lyz) + " tabType=" + localdzv.Lyv + " showExtInfoType=" + i);
      }
    }
    AppMethodBeat.o(197581);
    return localdzv;
  }
  
  private static long fSJ()
  {
    AppMethodBeat.i(197578);
    long l1 = ce.asS();
    g localg = g.qtS;
    long l2 = g.clC();
    AppMethodBeat.o(197578);
    return l1 - l2;
  }
  
  public final void Cy(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(178170);
    Object localObject = YW("FinderEntrance");
    int i;
    if ((localObject != null) && (((f)localObject).YX("FinderEntrance") != null))
    {
      localObject = ((f)localObject).field_ctrInfo;
      if (localObject != null)
      {
        i = ((akv)localObject).type;
        if (i != -1) {
          bool = true;
        }
      }
    }
    for (this.qth = bool;; this.qth = false)
    {
      this.qtg = paramInt;
      this.enterTime = ce.asS();
      YU("FinderEntrance");
      YU("Discovery");
      ad.i("Finder.RedDotManager", "[enterFinder] hasRedDotWhenEnter=" + this.qth);
      AppMethodBeat.o(178170);
      return;
      i = 0;
      break;
    }
  }
  
  public final void YU(String paramString)
  {
    AppMethodBeat.i(178176);
    d.g.b.k.h(paramString, "path");
    Object localObject1 = new HashSet();
    f localf = YW(paramString);
    if (localf != null) {}
    Object localObject2;
    Object localObject3;
    Object localObject4;
    for (aln localaln = localf.YX(paramString);; localaln = null)
    {
      localObject2 = (List)this.qti.get(paramString);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      if (localObject2 == null) {
        break;
      }
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (f)((Iterator)localObject2).next();
        localObject4 = ((f)localObject3).YY(paramString);
        if (((f)localObject3).a(this.qtj)) {
          ((HashSet)localObject1).addAll((Collection)localObject4);
        }
        if (((f)localObject3).clt()) {
          ((Iterator)localObject2).remove();
        }
      }
    }
    ad.i("Finder.RedDotManager", "[disposeRedDotAtPath] path=" + paramString + " removePathSet=" + localObject1 + " maybeRemoveShowInfo=" + a(localaln, 0));
    paramString = ((Iterable)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (String)paramString.next();
      localObject2 = YW((String)localObject1);
      if (localObject2 != null)
      {
        localObject3 = ((f)localObject2).YX((String)localObject1);
        if (localObject3 != null) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label298;
          }
          localObject4 = d.qtG;
          d.a(false, (String)localObject1, localaln, localf);
          localObject4 = d.qtG;
          d.a(true, (String)localObject1, (aln)localObject3, (f)localObject2);
          break;
        }
        label298:
        localObject2 = d.qtG;
        d.a(false, (String)localObject1, localaln, localf);
      }
      else
      {
        localObject2 = d.qtG;
        d.a(false, (String)localObject1, localaln, localf);
      }
    }
    AppMethodBeat.o(178176);
  }
  
  public final aln YV(String paramString)
  {
    AppMethodBeat.i(178178);
    d.g.b.k.h(paramString, "path");
    f localf = YW(paramString);
    if (localf != null)
    {
      paramString = localf.YX(paramString);
      AppMethodBeat.o(178178);
      return paramString;
    }
    AppMethodBeat.o(178178);
    return null;
  }
  
  public final f YW(String paramString)
  {
    AppMethodBeat.i(178179);
    d.g.b.k.h(paramString, "path");
    Object localObject = (List)this.qti.get(paramString);
    if (localObject != null)
    {
      ListIterator localListIterator = ((List)localObject).listIterator(((List)localObject).size());
      int i;
      if (localListIterator.hasPrevious())
      {
        localObject = localListIterator.previous();
        if (((f)localObject).YX(paramString) != null)
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
        paramString = (f)paramString;
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
  
  public final void a(com.tencent.mm.plugin.finder.feed.model.c paramc, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(178174);
    d.g.b.k.h(paramc, "info");
    ad.i("Finder.RedDotManager", "[onPreFetchDone] needShowRedDot=" + paramInt1 + " isInFinder=" + paramBoolean + " token=" + paramInt2 + ' ' + "isForceChangePrefetchResult=" + paramc.KPG + " size=" + paramc.incrementList.size());
    if (paramBoolean)
    {
      AppMethodBeat.o(178174);
      return;
    }
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(178174);
      return;
    }
    if (paramc.KPG)
    {
      ahg(3);
      ahg(4);
    }
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fww, Long.valueOf(ce.asS()));
    localObject = (BaseFinderFeed)j.iz(paramc.incrementList);
    if (localObject != null) {}
    for (long l = ((BaseFinderFeed)localObject).bMs(); l == 0L; l = 0L)
    {
      ad.e("Finder.RedDotManager", "feedId is invalid.");
      AppMethodBeat.o(178174);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject = (BaseFinderFeed)j.iz(paramc.incrementList);
    boolean bool;
    akv localakv;
    aln localaln;
    if (localObject != null)
    {
      localObject = ((BaseFinderFeed)localObject).feedObject;
      if (localObject != null)
      {
        localObject = ((FinderItem)localObject).getUserName();
        bool = b.a.YO((String)localObject);
        localakv = new akv();
        localakv.Dmu = String.valueOf(ce.asS());
        localaln = new aln();
        localakv.Dmt.add(localaln);
        localaln.path = "FinderEntrance";
        localaln.DmL = 1;
        if (!bool) {
          break label628;
        }
        localakv.type = 3;
        localakv.priority = 300000;
        localaln.rXs = 4;
        localObject = (BaseFinderFeed)j.iz(paramc.incrementList);
        if (localObject == null) {
          break label622;
        }
        localObject = ((BaseFinderFeed)localObject).contact;
        if (localObject == null) {
          break label622;
        }
        localObject = ((com.tencent.mm.plugin.finder.api.f)localObject).cks();
        label378:
        localaln.odo = ((String)localObject);
        l = fSJ();
        paramc = ((BaseFinderFeed)j.iy(paramc.incrementList)).feedObject;
        localObject = new StringBuilder("[onPreFetchDone] ret=");
        g localg = g.qtS;
        if (l < g.clv()) {
          break label712;
        }
      }
    }
    label712:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramc = ((StringBuilder)localObject).append(paramBoolean).append(" isFollow=").append(bool).append(" firstFeed=").append(paramc.getExpectId()).append("nickname=").append(paramc.getNickName()).append(" desc=").append(paramc.getDescription().subSequence(0, d.k.h.kL(6, paramc.getDescription().length()))).append(" diffTime=").append(l).append(" newFollowTipsEnterInterval=");
      localObject = g.qtS;
      paramc = paramc.append(g.clv()).append(' ').append("newUnFollowTipsEnterInterval=");
      localObject = g.qtS;
      ad.i("Finder.RedDotManager", g.clw() + " tipsShowInfo.title=" + localaln.title);
      if (!bool) {
        break label717;
      }
      paramc = g.qtS;
      if (l < g.clv()) {
        break label717;
      }
      a(localakv, "prefetch#follow");
      AppMethodBeat.o(178174);
      return;
      localObject = null;
      break;
      label622:
      localObject = null;
      break label378;
      label628:
      localakv.type = 4;
      localakv.priority = 200000;
      localaln.rXs = 3;
      localObject = (BaseFinderFeed)j.iz(paramc.incrementList);
      if (localObject != null)
      {
        localObject = ((BaseFinderFeed)localObject).feedObject;
        if (localObject != null)
        {
          localObject = ((FinderItem)localObject).getFeedObject();
          if (localObject == null) {}
        }
      }
      for (localObject = ((FinderObject)localObject).tipsWording;; localObject = null)
      {
        localaln.title = ((String)localObject);
        break;
      }
    }
    label717:
    if (!bool)
    {
      paramc = (CharSequence)localaln.title;
      if ((paramc != null) && (paramc.length() != 0)) {
        break label780;
      }
    }
    label780:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        paramc = g.qtS;
        if (l >= g.clw()) {
          a(localakv, "prefetch#unFollow");
        }
      }
      AppMethodBeat.o(178174);
      return;
    }
  }
  
  public final void a(final akn paramakn)
  {
    AppMethodBeat.i(178173);
    d.g.b.k.h(paramakn, "prefetch");
    final int i = this.qtd.incrementAndGet();
    boolean bool1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    boolean bool2 = com.tencent.mm.plugin.finder.storage.b.fUw();
    ad.i("Finder.RedDotManager", "[prefetch] isInFinder=" + bool1 + " needPrefetch=" + paramakn.Dmc + " needShowRedDot=" + paramakn.Dmd + ' ' + "triggerScene=" + paramakn.Dme + " token=" + i + " isMoreTabEnable=" + bool2);
    if (bool2)
    {
      AppMethodBeat.o(178173);
      return;
    }
    if ((!bool1) && (paramakn.Dmc > 0))
    {
      cll().clean();
      cll().a(new com.tencent.mm.plugin.finder.utils.l((d.g.a.b)new f(this, paramakn, i)));
    }
    AppMethodBeat.o(178173);
  }
  
  public final void a(aku paramaku)
  {
    AppMethodBeat.i(178171);
    d.g.b.k.h(paramaku, "redDot");
    long l = ce.asS();
    Object localObject1 = g.qtS;
    l -= g.clC();
    localObject1 = new StringBuilder("[notifyRedDot] diffTime=").append(l).append(" newMsgTipsEnterInterval=");
    Object localObject2 = g.qtS;
    localObject1 = ((StringBuilder)localObject1).append(g.fSU()).append(" showRed=").append(paramaku.Dmq).append(' ');
    localObject2 = paramaku.Dmr;
    d.g.b.k.g(localObject2, "redDot.ctrlInfo");
    ad.i("Finder.RedDotManager", a((akv)localObject2));
    localObject1 = g.qtS;
    if (l < g.fSU())
    {
      localObject1 = paramaku.Dmr.Dmt;
      d.g.b.k.g(localObject1, "redDot.ctrlInfo.show_infos");
      com.tencent.mm.ad.c.a((LinkedList)localObject1, (d.g.a.b)g.qtv);
    }
    paramaku = paramaku.Dmr;
    d.g.b.k.g(paramaku, "redDot.ctrlInfo");
    a(paramaku, "notifyRedDot");
    AppMethodBeat.o(178171);
  }
  
  public final void a(aly paramaly)
  {
    AppMethodBeat.i(178172);
    d.g.b.k.h(paramaly, "wxMention");
    long l = ce.asS();
    Object localObject = g.qtS;
    l -= g.clC();
    if ((paramaly.count <= 0) && (paramaly.LyL <= 0) && (paramaly.LyK <= 0) && (paramaly.DkE <= 0) && (paramaly.DkD <= 0) && (paramaly.DmX <= 0))
    {
      ad.e("Finder.RedDotManager", "[notifyWxMentionCount] server error.");
      AppMethodBeat.o(178172);
      return;
    }
    localObject = new StringBuilder("[notifyWxMentionCount] diffTime=").append(l).append(' ');
    akv localakv = paramaly.DmY;
    d.g.b.k.g(localakv, "wxMention.ctrl_info");
    ad.i("Finder.RedDotManager", a(localakv) + " count=" + paramaly.count);
    localObject = g.qtS;
    if (l < g.fSU())
    {
      localObject = paramaly.DmY.Dmt;
      d.g.b.k.g(localObject, "wxMention.ctrl_info.show_infos");
      com.tencent.mm.ad.c.a((LinkedList)localObject, (d.g.a.b)h.qtw);
    }
    paramaly = paramaly.DmY;
    d.g.b.k.g(paramaly, "wxMention.ctrl_info");
    a(paramaly, "notifyWxMentionCount");
    AppMethodBeat.o(178172);
  }
  
  public final void a(dzs paramdzs, String paramString)
  {
    AppMethodBeat.i(197580);
    d.g.b.k.h(paramdzs, "tabTips");
    d.g.b.k.h(paramString, "source");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.fUw())
    {
      AppMethodBeat.o(197580);
      return;
    }
    long l = fSJ();
    paramdzs = paramdzs.Lyx;
    d.g.b.k.g(paramdzs, "tabTips.tab_tips_info");
    paramdzs = ((Iterable)paramdzs).iterator();
    while (paramdzs.hasNext())
    {
      localObject1 = (dzt)paramdzs.next();
      Object localObject2 = new StringBuilder("[notifyTabTip] ");
      Object localObject3 = ((dzt)localObject1).DmY;
      d.g.b.k.g(localObject3, "tipsInfo.ctrl_info");
      ad.i("Finder.RedDotManager", a((akv)localObject3));
      localObject2 = ((dzt)localObject1).DmY.Dmt;
      d.g.b.k.g(localObject2, "tipsInfo.ctrl_info.show_infos");
      localObject2 = dO((List)localObject2);
      g localg;
      if (((dzt)localObject1).DmY.type == 8)
      {
        localObject3 = g.qtS;
        if (l <= g.fSS())
        {
          localObject3 = ((dzt)localObject1).DmY.Dmt;
          d.g.b.k.g(localObject3, "tipsInfo.ctrl_info.show_infos");
          com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)k.KMx);
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFollowTabTimeMs=");
          localg = g.qtS;
          ad.w("Finder.RedDotManager", g.fSS() + "ms, remove this ctrInfo");
        }
        localObject3 = g.qtS;
        if (l <= g.fSR())
        {
          localObject3 = ((dzt)localObject1).DmY.Dmt;
          d.g.b.k.g(localObject3, "tipsInfo.ctrl_info.show_infos");
          com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)l.KMy);
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFollowTabTimeMs=");
          localg = g.qtS;
          ad.w("Finder.RedDotManager", g.fSR() + "ms, remove entrance path red dot");
        }
      }
      boolean bool;
      for (;;)
      {
        bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
        if (!bool) {
          break label729;
        }
        if (this.KMu.Lha != ((dzv)localObject2).Lyv) {
          break label580;
        }
        ad.w("Finder.RedDotManager", "[notifyTabTip] it is in finder " + ((dzv)localObject2).Lyv + " now. just pass it, ext=" + i.a((dzv)localObject2) + " currentTabType=" + this.KMu.Lha + " extTab_type=" + ((dzv)localObject2).Lyv);
        break;
        if (((dzt)localObject1).DmY.type == 7)
        {
          localObject3 = g.qtS;
          if (l <= g.fST())
          {
            localObject3 = ((dzt)localObject1).DmY.Dmt;
            d.g.b.k.g(localObject3, "tipsInfo.ctrl_info.show_infos");
            com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)m.KMz);
            localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFriendEntranceTimeMs=");
            localg = g.qtS;
            ad.w("Finder.RedDotManager", g.fST() + "ms, remove entrance path red dot");
          }
        }
      }
      label580:
      if (this.KMv.contains(Integer.valueOf(((dzv)localObject2).Lyv)))
      {
        ad.w("Finder.RedDotManager", "[notifyTabTip] has shown in finder " + ((dzv)localObject2).Lyv + ". just pass it, ext=" + i.a((dzv)localObject2) + " extTab_type=" + ((dzv)localObject2).Lyv);
      }
      else
      {
        localObject3 = ((dzt)localObject1).DmY.Dmt;
        d.g.b.k.g(localObject3, "tipsInfo.ctrl_info.show_infos");
        com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)n.KMA);
        ad.w("Finder.RedDotManager", "[notifyTabTip] it is in finder now. just remove path of FINDER_ENTRANCE, currentTabType=" + this.KMu.Lha + " extTab_type=" + ((dzv)localObject2).Lyv);
        label729:
        ahg(((dzt)localObject1).DmY.type);
        ((dzt)localObject1).DmY.Dms = new com.tencent.mm.bx.b(((dzv)localObject2).toByteArray());
        ((dzt)localObject1).DmY.feedId = ((dzv)localObject2).Lyz;
        localObject3 = ((dzt)localObject1).DmY;
        d.g.b.k.g(localObject3, "tipsInfo.ctrl_info");
        a((akv)localObject3, "notifyTabTip#".concat(String.valueOf(paramString)));
        this.KMv.add(Integer.valueOf(((dzv)localObject2).Lyv));
        int i = aVk("FinderEntrance").Lyv;
        if ((i != 0) && ((i == 3) || (i == 1) || (i == 4))) {
          this.KMu.a(i, FinderHomeTabStateVM.c.Lhl);
        }
        ad.i("Finder.RedDotManager", "[notifyTabTip] successfully! tabType=" + ((dzv)localObject2).Lyv + " objectId=" + ((dzv)localObject2).Lyz + " diffTime=" + l + "ms isInFinder=" + bool + " currentTabType=" + this.KMu.Lha + " showInfoSize=" + ((dzt)localObject1).DmY.Dmt.size() + " currentShowTabType=" + i);
      }
    }
    AppMethodBeat.o(197580);
  }
  
  public final boolean a(akv paramakv, String paramString)
  {
    AppMethodBeat.i(178175);
    d.g.b.k.h(paramakv, "info");
    d.g.b.k.h(paramString, "source");
    if (!fSK())
    {
      LinkedList localLinkedList = paramakv.Dmt;
      d.g.b.k.g(localLinkedList, "info.show_infos");
      com.tencent.mm.ad.c.a(localLinkedList, (d.g.a.b)j.KMw);
      ad.i("Finder.RedDotManager", "[addNewRedDotCtrlInfo] remove DISCOVERY_TAB");
    }
    paramakv = new f().b(paramakv);
    if (paramakv.a(this.qtj))
    {
      a(paramakv, paramString);
      AppMethodBeat.o(178175);
      return true;
    }
    AppMethodBeat.o(178175);
    return false;
  }
  
  public final void ahg(int paramInt)
  {
    AppMethodBeat.i(197579);
    Object localObject3 = new HashMap();
    Object localObject4 = ((Map)this.qti).entrySet().iterator();
    Object localObject1;
    Object localObject5;
    Object localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject4).next();
      localObject5 = (String)((Map.Entry)localObject1).getKey();
      Iterator localIterator = ((List)((Map.Entry)localObject1).getValue()).iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.field_ctrInfo.type == paramInt)
        {
          localObject2 = (LinkedList)((HashMap)localObject3).get(localObject5);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new LinkedList();
            ((Map)localObject3).put(localObject5, localObject1);
          }
          d.g.b.k.g(localObject1, "clearMap[path] ?: run {\n…ist\n                    }");
          ((LinkedList)localObject1).add(localf);
          localIterator.remove();
        }
      }
    }
    int i;
    if (!((Map)localObject3).isEmpty())
    {
      i = 1;
      if (i != 0) {
        ad.i("Finder.RedDotManager", "[clearCtrlInfo] type=" + paramInt + " clearMap=" + localObject3);
      }
      localObject1 = ((Map)localObject3).entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label436;
      }
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = ((Iterable)((Map.Entry)localObject3).getValue()).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          ((f)((Iterator)localObject3).next()).b(this.qtj);
          continue;
          i = 0;
          break;
        }
      }
      localObject3 = YW((String)localObject2);
      if (localObject3 != null)
      {
        localObject4 = ((f)localObject3).YX((String)localObject2);
        if (localObject4 != null) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label404;
          }
          localObject5 = d.qtG;
          d.a(false, (String)localObject2, null, null);
          localObject5 = d.qtG;
          d.a(true, (String)localObject2, (aln)localObject4, (f)localObject3);
          break;
        }
        label404:
        localObject3 = d.qtG;
        d.a(false, (String)localObject2, null, null);
      }
      else
      {
        localObject3 = d.qtG;
        d.a(false, (String)localObject2, null, null);
      }
    }
    label436:
    AppMethodBeat.o(197579);
  }
  
  public final boolean ahh(int paramInt)
  {
    AppMethodBeat.i(197583);
    dzv localdzv = ahi(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("[containsTabTipsExtInfo] tabType=").append(paramInt).append(" isContains=");
    if (localdzv.Lyv != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("Finder.RedDotManager", bool);
      if (localdzv.Lyv == 0) {
        break;
      }
      AppMethodBeat.o(197583);
      return true;
    }
    AppMethodBeat.o(197583);
    return false;
  }
  
  public final dzv ahi(int paramInt)
  {
    AppMethodBeat.i(197584);
    dzv localdzv = aVk(ahf(paramInt));
    ad.i("Finder.RedDotManager", "[getTabTipsExtInfo] tabType=" + paramInt + " ext=" + i.a(localdzv));
    AppMethodBeat.o(197584);
    return localdzv;
  }
  
  public final void clm()
  {
    AppMethodBeat.i(178169);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    long l2;
    long l1;
    boolean bool2;
    if (!com.tencent.mm.plugin.finder.storage.b.fUw())
    {
      l2 = cln();
      if (l2 <= 0L)
      {
        ad.i("Finder.RedDotManager", "[checkPreFetchNow] it's not preFetch yet.");
        AppMethodBeat.o(178169);
        return;
      }
      localObject = g.qtS;
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
      d.g.b.k.g(localObject, "MMKernel.service(IConfigService::class.java)");
      l1 = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getInt("FinderRefreshDiscoveryInterval", 1200) * 1000L / g.clF();
      bool2 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
      l2 = ce.asS() - l2;
      localObject = new StringBuilder("[checkPreFetchNow] isInFinder=").append(bool2).append(" diffTime=").append(l2).append(" expired=").append(l1).append(" ret=");
      if (l2 < l1) {
        break label224;
      }
    }
    label224:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("Finder.RedDotManager", bool1);
      if ((!bool2) && (l2 >= l1)) {
        cll().a(new com.tencent.mm.plugin.finder.utils.l((d.g.a.b)new e(this)));
      }
      AppMethodBeat.o(178169);
      return;
    }
  }
  
  public final void fSI()
  {
    AppMethodBeat.i(178183);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fww, Long.valueOf(0L));
    ad.i("Finder.RedDotManager", "[resetPreFetchTime] done.");
    this.qtf = (ce.asS() - this.enterTime);
    long l;
    if ((this.qth) && (this.qtg == 2))
    {
      l = this.qtf;
      localObject = g.qtS;
      if (l <= g.clx())
      {
        localObject = g.qtS;
        int i = d.k.h.kL(g.clB() + 1, 3);
        ad.w("Finder.RedDotManager", "[exitFinder] current fastLevel=".concat(String.valueOf(i)));
        localObject = g.qtS;
        g.CA(i);
        localObject = g.qtS;
        g.clD();
        switch (this.KMu.Lha)
        {
        }
      }
    }
    for (;;)
    {
      this.KMv.clear();
      AppMethodBeat.o(178183);
      return;
      l = this.qtf;
      localObject = g.qtS;
      if (l <= g.clx()) {
        break;
      }
      ad.w("Finder.RedDotManager", "[exitFinder] revert fastLevel=0");
      localObject = g.qtS;
      g.CA(0);
      break;
      ahg(7);
      continue;
      ahg(8);
      continue;
      ahg(1004);
    }
  }
  
  public final boolean fSK()
  {
    AppMethodBeat.i(197585);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    boolean bool = locale.afk().getBoolean(ae.a.LBt, true);
    AppMethodBeat.o(197585);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool3 = false;
    AppMethodBeat.i(197587);
    ad.i("Finder.RedDotManager", "scene = ".concat(String.valueOf(paramn)));
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    do
    {
      AppMethodBeat.o(197587);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.qtc;
    boolean bool1;
    if (!bt.isNullOrNil(com.tencent.mm.model.u.aqO()))
    {
      bool1 = true;
      label88:
      paramn = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramn, "MMKernel.storage()");
      paramInt2 = paramn.afk().getInt(ae.a.Fxd, e.getLocalRedDotDefault());
      paramn = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((!com.tencent.mm.plugin.finder.storage.b.cps()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
        break label519;
      }
    }
    label519:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      boolean bool2 = bool3;
      if (paramInt1 != 0)
      {
        bool2 = bool3;
        if (e.Cz(paramInt2))
        {
          bool2 = bool3;
          if (!bool1) {
            bool2 = true;
          }
        }
      }
      ad.i("Finder.RedDotTransform", "[isShowLocalRedDot] ret=" + bool2 + " local=" + paramInt2 + " hasCreatedIdentity=" + bool1);
      if (!bool2) {
        break;
      }
      paramn = new akv();
      paramn.Dmu = String.valueOf(ce.asS());
      paramn.priority = 100000;
      paramn.type = -1;
      aln localaln = new aln();
      localaln.rXs = 100;
      localaln.DmL = 1;
      localaln.path = "FinderEntrance";
      paramn.Dmt.add(localaln);
      localaln = new aln();
      localaln.rXs = 1;
      localaln.DmL = 2;
      localaln.path = "TLPersonalCenter";
      localaln.uOH = "FinderEntrance";
      paramn.Dmt.add(localaln);
      localaln = new aln();
      localaln.rXs = 1;
      localaln.DmL = 1;
      localaln.path = "TLCamera";
      localaln.uOH = "TLPersonalCenter";
      paramn.Dmt.add(localaln);
      paramString.qtJ.a(paramn, "checkPostRedDot");
      paramString = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.afk().getInt(ae.a.Fxd, e.getLocalRedDotDefault());
      paramInt2 = paramInt1 & 0xFFFFFFFD;
      if (paramInt2 != paramInt1)
      {
        paramString = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramString, "MMKernel.storage()");
        paramString.afk().set(ae.a.Fxd, Integer.valueOf(paramInt2));
      }
      ad.i("Finder.RedDotTransform", "[setLocalRedDot] flag=2 unset=true newLocal=" + paramInt2 + " local=" + paramInt1);
      ad.i("Finder.RedDotTransform", "[transformPostRedDot] done.");
      break;
      bool1 = false;
      break label88;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(178168);
    if (!aj.cbe())
    {
      AppMethodBeat.o(178168);
      return;
    }
    com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("Finder.RedDotManager");
    Object localObject = this.KMt;
    com.tencent.mm.plugin.newtips.a.fXX().a("FinderNewTipsTransform", (l.a)localObject);
    localObject = ((Iterable)this.qtj.clj()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      akv localakv = localf.field_ctrInfo;
      d.g.b.k.g(localakv, "it.field_ctrInfo");
      a(localf.b(localakv), "prepare");
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.fUw())
    {
      ahg(7);
      ahg(8);
      ahg(1004);
      ahg(1003);
    }
    localb.agL();
    AppMethodBeat.o(178168);
  }
  
  public final void yA(boolean paramBoolean)
  {
    AppMethodBeat.i(197586);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBt, Boolean.valueOf(paramBoolean));
    localObject = com.tencent.mm.plugin.finder.report.b.qFq;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.finder.report.b.la(1, i);
      AppMethodBeat.o(197586);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$buildPathWithCtrInfo$1$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<f, Boolean>
  {
    b(c paramc, f paramf, HashSet paramHashSet)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<f, Integer>
  {
    public static final c qto;
    
    static
    {
      AppMethodBeat.i(178152);
      qto = new c();
      AppMethodBeat.o(178152);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<f, Long>
  {
    public static final d qtp;
    
    static
    {
      AppMethodBeat.i(178154);
      qtp = new d();
      AppMethodBeat.o(178154);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
  {
    f(c paramc, akn paramakn, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<aln, Boolean>
  {
    public static final g qtv;
    
    static
    {
      AppMethodBeat.i(178161);
      qtv = new g();
      AppMethodBeat.o(178161);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<aln, Boolean>
  {
    public static final h qtw;
    
    static
    {
      AppMethodBeat.i(178163);
      qtw = new h();
      AppMethodBeat.o(178163);
    }
    
    h()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<m>
  {
    public static final i qtx;
    
    static
    {
      AppMethodBeat.i(178165);
      qtx = new i();
      AppMethodBeat.o(178165);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<aln, Boolean>
  {
    public static final j KMw;
    
    static
    {
      AppMethodBeat.i(197569);
      KMw = new j();
      AppMethodBeat.o(197569);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.b<aln, Boolean>
  {
    public static final k KMx;
    
    static
    {
      AppMethodBeat.i(197571);
      KMx = new k();
      AppMethodBeat.o(197571);
    }
    
    k()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<aln, Boolean>
  {
    public static final l KMy;
    
    static
    {
      AppMethodBeat.i(197573);
      KMy = new l();
      AppMethodBeat.o(197573);
    }
    
    l()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<aln, Boolean>
  {
    public static final m KMz;
    
    static
    {
      AppMethodBeat.i(197575);
      KMz = new m();
      AppMethodBeat.o(197575);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.b<aln, Boolean>
  {
    public static final n KMA;
    
    static
    {
      AppMethodBeat.i(197577);
      KMA = new n();
      AppMethodBeat.o(197577);
    }
    
    n()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.c
 * JD-Core Version:    0.7.0.1
 */