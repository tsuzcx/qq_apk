package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRedDotManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;)V", "enterSource", "", "enterTime", "", "hasRedDotWhenEnter", "", "newTipsTransform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "noFoundRevokeIdSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTipsInfo;", "pathToCtrInfoMap", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "preFetchToken", "Ljava/util/concurrent/atomic/AtomicInteger;", "revokeIdToCtrInfoMap", "singleTaskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "getSingleTaskExecutor", "()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "singleTaskExecutor$delegate", "Lkotlin/Lazy;", "stateCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stayDuration", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "getTransform", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "addNewRedDotCtrlInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "tipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "buildPathWithCtrInfo", "", "local", "checkPreFetchNow", "clearCtrlInfo", "type", "containsTabTipsExtInfo", "tabType", "ctrlInfoAtPath", "path", "deleteCtrlInfo", "ctrInfo", "disposeRedDotAtPath", "enterFinder", "exitFinder", "findByRevokeId", "revokeId", "findExtInfoAtCtrlInfo", "getDiffExitTimeMs", "getPathByTabType", "getTabTipsExtInfo", "getTipsShowInfoAtPath", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "hasPrefetch", "isEnableShowEntranceRedDot", "isShowInteractionRedDot", "lastPreFetchTime", "needToRefreshForPrefetch", "notifyPrefetch", "prefetch", "Lcom/tencent/mm/protocal/protobuf/FinderPreFetch;", "notifyRedDot", "redDot", "Lcom/tencent/mm/protocal/protobuf/FinderRedDot;", "notifyTabTip", "tabTips", "Lcom/tencent/mm/protocal/protobuf/FinderTabTips;", "notifyWxMentionCount", "wxMention", "Lcom/tencent/mm/protocal/protobuf/FinderWxMentionCount;", "onPreFetchDone", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "needShowRedDot", "isInFinder", "token", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseExtInfo", "showInfoList", "", "prepare", "printCtrInfo", "printTipsShowInfo", "index", "resetPreFetchTime", "revokeRedDot", "revoke", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTips;", "setEnableShowEntranceRedDot", "isEnable", "storeLastPreFetchTime", "takeTabTipsExtInfo", "updateFindMoreFriendUI", "Companion", "plugin-finder_release"})
public final class d
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.i.a.j
{
  public static final d.a reB;
  private long enterTime;
  final b reA;
  public final g ren;
  private final a reo;
  private final AtomicInteger rep;
  private final FinderHomeTabStateVM rer;
  private final d.f res;
  private long reu;
  private int rev;
  private boolean rew;
  final ConcurrentHashMap<String, List<h>> rex;
  private final ConcurrentHashMap<String, h> rey;
  private final ConcurrentHashMap<String, ano> rez;
  
  static
  {
    AppMethodBeat.i(178166);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(d.class), "singleTaskExecutor", "getSingleTaskExecutor()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;")) };
    reB = new d.a((byte)0);
    AppMethodBeat.o(178166);
  }
  
  public d(b paramb)
  {
    AppMethodBeat.i(178184);
    this.reA = paramb;
    this.ren = new g(this);
    this.reo = new a(this);
    this.rep = new AtomicInteger();
    paramb = com.tencent.mm.ui.component.a.IrY;
    paramb = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(paramb, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rer = ((FinderHomeTabStateVM)paramb);
    this.res = d.g.K((d.g.a.a)p.reV);
    this.rex = new ConcurrentHashMap();
    this.rey = new ConcurrentHashMap();
    this.rez = new ConcurrentHashMap();
    AppMethodBeat.o(178184);
  }
  
  private static String Dx(int paramInt)
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
  
  private static String a(ani paramani)
  {
    AppMethodBeat.i(178180);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = paramani.EGs;
    d.g.b.k.g(localObject1, "info.show_infos");
    localObject1 = (Iterable)localObject1;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.fOc();
      }
      localStringBuilder.append(a((aon)localObject2, i));
      i += 1;
    }
    paramani = "CtrlInfo{tipsId=" + paramani.EGt + " priority=" + paramani.priority + " type=" + paramani.type + " tipsShowInfo=" + localStringBuilder + '}';
    AppMethodBeat.o(178180);
    return paramani;
  }
  
  private static String a(aon paramaon, int paramInt)
  {
    AppMethodBeat.i(178181);
    if (paramaon == null)
    {
      AppMethodBeat.o(178181);
      return "[empty]";
    }
    paramaon = "#" + paramInt + "{showType=" + paramaon.tfk + " count=" + paramaon.count + " title=" + paramaon.title + ' ' + "clearType=" + paramaon.EHC + " iconUrl=" + paramaon.oGN + " path=" + paramaon.path + " show_ext_info_type=" + paramaon.EHD + " parent=" + paramaon.vXx + "} ";
    AppMethodBeat.o(178181);
    return paramaon;
  }
  
  private final void a(h paramh, String paramString)
  {
    AppMethodBeat.i(178177);
    paramString = new StringBuilder("[buildPathWithCtrInfo] source=").append(paramString).append(' ');
    Object localObject1 = paramh.field_ctrInfo;
    d.g.b.k.g(localObject1, "local.field_ctrInfo");
    ac.i("Finder.RedDotManager", a((ani)localObject1) + " revokeId=" + paramh.field_revokeId);
    localObject1 = new HashSet();
    Iterator localIterator = ((Map)paramh.rft).entrySet().iterator();
    Map.Entry localEntry;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      paramString = (List)this.rex.get(localEntry.getKey());
      if (paramString != null) {
        break label355;
      }
      Object localObject2 = (d)this;
      paramString = Collections.synchronizedList((List)new LinkedList());
      localObject2 = (Map)((d)localObject2).rex;
      Object localObject3 = localEntry.getKey();
      d.g.b.k.g(paramString, "list");
      ((Map)localObject2).put(localObject3, paramString);
    }
    label355:
    for (;;)
    {
      d.g.b.k.g(paramString, "crlInfoList");
      d.a.j.a(paramString, (d.g.a.b)new d.c(this, paramh, (HashSet)localObject1));
      paramString.add(paramh);
      d.a.j.a(paramString, d.b.a.a(new d.g.a.b[] { (d.g.a.b)d.d.reG, (d.g.a.b)e.reH }));
      ((HashSet)localObject1).add(localEntry.getKey());
      break;
      paramString = paramh.field_revokeId;
      if (paramString != null) {
        ((Map)this.rey).put(paramString, paramh);
      }
      paramh = ((Iterable)localObject1).iterator();
      while (paramh.hasNext())
      {
        paramString = (String)paramh.next();
        localObject1 = f.rfl;
        f.a(true, paramString, adw(paramString), adx(paramString));
      }
      AppMethodBeat.o(178177);
      return;
    }
  }
  
  private boolean a(ani paramani, String paramString, aom paramaom)
  {
    AppMethodBeat.i(201466);
    d.g.b.k.h(paramani, "info");
    d.g.b.k.h(paramString, "source");
    d.g.b.k.h(paramaom, "tipsShowEntranceExtInfo");
    if (!ctK())
    {
      localObject = paramani.EGs;
      d.g.b.k.g(localObject, "info.show_infos");
      c.a((LinkedList)localObject, (d.g.a.b)d.b.reC);
      ac.i("Finder.RedDotManager", "[addNewRedDotCtrlInfo] remove DISCOVERY_TAB");
    }
    Object localObject = new h().b(paramani);
    ((h)localObject).field_tipsShowEntranceExtInfo = paramaom;
    ConcurrentHashMap localConcurrentHashMap = this.rez;
    paramaom = ((h)localObject).field_revokeId;
    paramani = paramaom;
    if (paramaom == null) {
      paramani = "";
    }
    if (localConcurrentHashMap.contains(paramani))
    {
      paramani = new StringBuilder("[addNewRedDotCtrlInfo] has revoke. ").append(((h)localObject).field_revokeId).append(' ');
      paramString = ((h)localObject).field_ctrInfo;
      d.g.b.k.g(paramString, "local.field_ctrInfo");
      ac.e("Finder.RedDotManager", a(paramString));
      AppMethodBeat.o(201466);
      return false;
    }
    if (((h)localObject).a(this.reA))
    {
      a((h)localObject, paramString);
      AppMethodBeat.o(201466);
      return true;
    }
    AppMethodBeat.o(201466);
    return false;
  }
  
  private final aom ady(String paramString)
  {
    AppMethodBeat.i(201471);
    paramString = adx(paramString);
    if (paramString != null)
    {
      aom localaom = paramString.ctY();
      paramString = localaom;
      if (localaom != null) {}
    }
    else
    {
      paramString = new aom();
    }
    AppMethodBeat.o(201471);
    return paramString;
  }
  
  private final r ctF()
  {
    AppMethodBeat.i(178167);
    r localr = (r)this.res.getValue();
    AppMethodBeat.o(178167);
    return localr;
  }
  
  private static long ctI()
  {
    AppMethodBeat.i(201465);
    long l1 = ce.azJ();
    i locali = i.rfA;
    long l2 = i.cul();
    AppMethodBeat.o(201465);
    return l1 - l2;
  }
  
  public static long ctJ()
  {
    AppMethodBeat.i(178182);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).agA().get(ah.a.GUH, Long.valueOf(0L));
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
  
  private static aom dx(List<? extends aon> paramList)
  {
    AppMethodBeat.i(201470);
    aom localaom = new aom();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      aon localaon = (aon)paramList.next();
      int i = localaon.EHD;
      if (i == 1)
      {
        com.tencent.mm.bw.b localb = localaon.EHE;
        d.g.b.k.g(localb, "it.show_ext_info");
        localaom.parseFrom(localb.getBytes());
        ac.i("Finder.RedDotManager", "[parseExtInfo] path=" + localaon.path + " objectId=" + c.pb(localaom.EHA) + " tabType=" + localaom.EHv + " showExtInfoType=" + i);
      }
    }
    AppMethodBeat.o(201470);
    return localaom;
  }
  
  public final aom DA(int paramInt)
  {
    AppMethodBeat.i(201473);
    aom localaom = ady(Dx(paramInt));
    ac.i("Finder.RedDotManager", "[getTabTipsExtInfo] tabType=" + paramInt + " ext=" + e.a(localaom));
    AppMethodBeat.o(201473);
    return localaom;
  }
  
  public final void Dw(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(178170);
    Object localObject = adx("FinderEntrance");
    int i;
    if ((localObject != null) && (((h)localObject).adz("FinderEntrance") != null))
    {
      localObject = ((h)localObject).field_ctrInfo;
      if (localObject != null)
      {
        i = ((ani)localObject).type;
        if (i != -1) {
          bool = true;
        }
      }
    }
    for (this.rew = bool;; this.rew = false)
    {
      this.rev = paramInt;
      this.enterTime = ce.azJ();
      adv("FinderEntrance");
      adv("Discovery");
      ac.i("Finder.RedDotManager", "[enterFinder] hasRedDotWhenEnter=" + this.rew);
      AppMethodBeat.o(178170);
      return;
      i = 0;
      break;
    }
  }
  
  public final boolean Dy(int paramInt)
  {
    AppMethodBeat.i(201468);
    HashMap localHashMap = new HashMap();
    Object localObject3 = ((Map)this.rex).entrySet().iterator();
    Object localObject1;
    Object localObject4;
    Object localObject5;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      localObject4 = (String)((Map.Entry)localObject1).getKey();
      localObject5 = ((List)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        h localh = (h)((Iterator)localObject5).next();
        if (localh.field_ctrInfo.type == paramInt)
        {
          localObject2 = (LinkedList)localHashMap.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new LinkedList();
            ((Map)localHashMap).put(localObject4, localObject1);
          }
          d.g.b.k.g(localObject1, "clearMap[path] ?: run {\n…ist\n                    }");
          ((LinkedList)localObject1).add(localh);
          ((Iterator)localObject5).remove();
        }
      }
    }
    int i;
    if (!((Map)localHashMap).isEmpty())
    {
      i = 1;
      if (i != 0) {
        ac.i("Finder.RedDotManager", "[clearCtrlInfo] type=" + paramInt + " clearMap=" + localHashMap);
      }
      localObject1 = ((Map)localHashMap).entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label437;
      }
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = ((Iterable)((Map.Entry)localObject3).getValue()).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          ((h)((Iterator)localObject3).next()).b(this.reA);
          continue;
          i = 0;
          break;
        }
      }
      localObject3 = adx((String)localObject2);
      if (localObject3 != null)
      {
        localObject4 = ((h)localObject3).adz((String)localObject2);
        if (localObject4 != null) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label405;
          }
          localObject5 = f.rfl;
          f.a(false, (String)localObject2, null, null);
          localObject5 = f.rfl;
          f.a(true, (String)localObject2, (aon)localObject4, (h)localObject3);
          break;
        }
        label405:
        localObject3 = f.rfl;
        f.a(false, (String)localObject2, null, null);
      }
      else
      {
        localObject3 = f.rfl;
        f.a(false, (String)localObject2, null, null);
      }
    }
    label437:
    if (!((Map)localHashMap).isEmpty())
    {
      AppMethodBeat.o(201468);
      return true;
    }
    AppMethodBeat.o(201468);
    return false;
  }
  
  public final boolean Dz(int paramInt)
  {
    AppMethodBeat.i(201472);
    aom localaom = DA(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("[containsTabTipsExtInfo] tabType=").append(paramInt).append(" isContains=");
    if (localaom.EHv != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("Finder.RedDotManager", bool);
      if (localaom.EHv == 0) {
        break;
      }
      AppMethodBeat.o(201472);
      return true;
    }
    AppMethodBeat.o(201472);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.finder.feed.model.a parama, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(201464);
    d.g.b.k.h(parama, "info");
    ac.i("Finder.RedDotManager", "[onPreFetchDone] needShowRedDot=" + paramInt1 + " isInFinder=" + paramBoolean + " token=" + paramInt2 + ' ' + "isForceChangePrefetchResult=" + parama.rmu + " size=" + parama.incrementList.size());
    if (paramBoolean)
    {
      AppMethodBeat.o(201464);
      return;
    }
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(201464);
      return;
    }
    if (parama.rmu)
    {
      Dy(3);
      Dy(4);
    }
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUH, Long.valueOf(ce.azJ()));
    localObject = (BaseFinderFeed)d.a.j.iP(parama.incrementList);
    if (localObject != null) {}
    for (long l = ((BaseFinderFeed)localObject).lx(); l == 0L; l = 0L)
    {
      ac.e("Finder.RedDotManager", "feedId is invalid.");
      AppMethodBeat.o(201464);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject = (BaseFinderFeed)d.a.j.iP(parama.incrementList);
    boolean bool;
    ani localani;
    aon localaon;
    if (localObject != null)
    {
      localObject = ((BaseFinderFeed)localObject).feedObject;
      if (localObject != null)
      {
        localObject = ((FinderItem)localObject).getUserName();
        bool = b.a.adk((String)localObject);
        localani = new ani();
        localani.EGt = String.valueOf(ce.azJ());
        localaon = new aon();
        localani.EGs.add(localaon);
        localaon.path = "FinderEntrance";
        localaon.EHC = 1;
        if (!bool) {
          break label630;
        }
        localani.type = 3;
        localani.priority = 300000;
        localaon.tfk = 4;
        localObject = (BaseFinderFeed)d.a.j.iP(parama.incrementList);
        if (localObject == null) {
          break label624;
        }
        localObject = ((BaseFinderFeed)localObject).contact;
        if (localObject == null) {
          break label624;
        }
        localObject = ((com.tencent.mm.plugin.finder.api.f)localObject).crZ();
        label380:
        localaon.oGN = ((String)localObject);
        l = ctI();
        parama = ((BaseFinderFeed)d.a.j.iO(parama.incrementList)).feedObject;
        localObject = new StringBuilder("[onPreFetchDone] ret=");
        i locali = i.rfA;
        if (l < i.cub()) {
          break label714;
        }
      }
    }
    label714:
    for (paramBoolean = true;; paramBoolean = false)
    {
      parama = ((StringBuilder)localObject).append(paramBoolean).append(" isFollow=").append(bool).append(" firstFeed=").append(parama.getExpectId()).append("nickname=").append(parama.getNickName()).append(" desc=").append(parama.getDescription().subSequence(0, d.k.h.lb(6, parama.getDescription().length()))).append(" diffTime=").append(l).append(" newFollowTipsEnterInterval=");
      localObject = i.rfA;
      parama = parama.append(i.cub()).append(' ').append("newUnFollowTipsEnterInterval=");
      localObject = i.rfA;
      ac.i("Finder.RedDotManager", i.cuf() + " tipsShowInfo.title=" + localaon.title);
      if (!bool) {
        break label719;
      }
      parama = i.rfA;
      if (l < i.cub()) {
        break label719;
      }
      a(this, localani, "prefetch#follow");
      AppMethodBeat.o(201464);
      return;
      localObject = null;
      break;
      label624:
      localObject = null;
      break label380;
      label630:
      localani.type = 4;
      localani.priority = 200000;
      localaon.tfk = 3;
      localObject = (BaseFinderFeed)d.a.j.iP(parama.incrementList);
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
        localaon.title = ((String)localObject);
        break;
      }
    }
    label719:
    if (!bool)
    {
      parama = (CharSequence)localaon.title;
      if ((parama != null) && (parama.length() != 0)) {
        break label782;
      }
    }
    label782:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        parama = i.rfA;
        if (l >= i.cuf()) {
          a(this, localani, "prefetch#unFollow");
        }
      }
      AppMethodBeat.o(201464);
      return;
    }
  }
  
  public final void a(final amz paramamz)
  {
    AppMethodBeat.i(178173);
    d.g.b.k.h(paramamz, "prefetch");
    final int i = this.rep.incrementAndGet();
    boolean bool1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    boolean bool2 = com.tencent.mm.plugin.finder.storage.b.czT();
    ac.i("Finder.RedDotManager", "[prefetch] isInFinder=" + bool1 + " needPrefetch=" + paramamz.EGb + " needShowRedDot=" + paramamz.EGc + ' ' + "triggerScene=" + paramamz.EGd + " token=" + i + " isMoreTabEnable=" + bool2);
    if (bool2)
    {
      AppMethodBeat.o(178173);
      return;
    }
    if ((!bool1) && (paramamz.EGb > 0))
    {
      ctF().clean();
      ctF().a(new q((d.g.a.b)new h(this, paramamz, i)));
    }
    AppMethodBeat.o(178173);
  }
  
  public final void a(anh paramanh)
  {
    AppMethodBeat.i(178171);
    d.g.b.k.h(paramanh, "redDot");
    long l = ce.azJ();
    Object localObject1 = i.rfA;
    l -= i.cul();
    localObject1 = new StringBuilder("[notifyRedDot] diffTime=").append(l).append(" newMsgTipsEnterInterval=");
    Object localObject2 = i.rfA;
    localObject1 = ((StringBuilder)localObject1).append(i.cue()).append(" showRed=").append(paramanh.EGp).append(' ');
    localObject2 = paramanh.EGq;
    d.g.b.k.g(localObject2, "redDot.ctrlInfo");
    ac.i("Finder.RedDotManager", a((ani)localObject2));
    localObject1 = i.rfA;
    if (l < i.cue())
    {
      localObject1 = paramanh.EGq.EGs;
      d.g.b.k.g(localObject1, "redDot.ctrlInfo.show_infos");
      c.a((LinkedList)localObject1, (d.g.a.b)d.i.reO);
    }
    paramanh = paramanh.EGq;
    d.g.b.k.g(paramanh, "redDot.ctrlInfo");
    a(this, paramanh, "notifyRedDot");
    AppMethodBeat.o(178171);
  }
  
  public final void a(final ann paramann)
  {
    AppMethodBeat.i(201477);
    d.g.b.k.h(paramann, "revoke");
    ac.i("Finder.RedDotManager", "[revokeRedDot] " + paramann.EGx.size());
    c.b(null, (d.g.a.a)new o(this, paramann));
    AppMethodBeat.o(201477);
  }
  
  public final void a(aoj paramaoj, String paramString)
  {
    AppMethodBeat.i(201469);
    d.g.b.k.h(paramaoj, "tabTips");
    d.g.b.k.h(paramString, "source");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (!com.tencent.mm.plugin.finder.storage.b.czT())
    {
      AppMethodBeat.o(201469);
      return;
    }
    long l = ctI();
    paramaoj = paramaoj.EHx;
    d.g.b.k.g(paramaoj, "tabTips.tab_tips_info");
    paramaoj = ((Iterable)paramaoj).iterator();
    if (paramaoj.hasNext())
    {
      localObject1 = (aok)paramaoj.next();
      Object localObject2 = new StringBuilder("[notifyTabTip] ");
      Object localObject3 = ((aok)localObject1).EHy;
      d.g.b.k.g(localObject3, "tipsInfo.ctrl_info");
      ac.i("Finder.RedDotManager", a((ani)localObject3));
      localObject2 = ((aok)localObject1).EHy.EGs;
      d.g.b.k.g(localObject2, "tipsInfo.ctrl_info.show_infos");
      localObject2 = dx((List)localObject2);
      i locali;
      if (((aok)localObject1).EHy.type == 8)
      {
        localObject3 = i.rfA;
        if (l <= i.cuc())
        {
          localObject3 = ((aok)localObject1).EHy.EGs;
          d.g.b.k.g(localObject3, "tipsInfo.ctrl_info.show_infos");
          c.a((LinkedList)localObject3, (d.g.a.b)d.j.reP);
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFollowTabTimeMs=");
          locali = i.rfA;
          ac.w("Finder.RedDotManager", i.cuc() + "ms, remove this ctrInfo");
        }
        localObject3 = i.rfA;
        if (l <= i.cua())
        {
          localObject3 = ((aok)localObject1).EHy.EGs;
          d.g.b.k.g(localObject3, "tipsInfo.ctrl_info.show_infos");
          c.a((LinkedList)localObject3, (d.g.a.b)d.k.reQ);
          localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFollowTabTimeMs=");
          locali = i.rfA;
          ac.w("Finder.RedDotManager", i.cua() + "ms, remove entrance path red dot");
        }
      }
      for (;;)
      {
        boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
        if (bool)
        {
          if (this.rer.sbQ == ((aom)localObject2).EHv)
          {
            ac.w("Finder.RedDotManager", "[notifyTabTip] it is in finder " + ((aom)localObject2).EHv + " now. currentTabType=" + this.rer.sbQ + " extTab_type=" + ((aom)localObject2).EHv);
            ((aok)localObject1).EHy.EGu = 1L;
          }
          localObject3 = ((aok)localObject1).EHy.EGs;
          d.g.b.k.g(localObject3, "tipsInfo.ctrl_info.show_infos");
          c.a((LinkedList)localObject3, (d.g.a.b)m.reS);
          ac.w("Finder.RedDotManager", "[notifyTabTip] it is in finder now. just remove path of FINDER_ENTRANCE, currentTabType=" + this.rer.sbQ + " extTab_type=" + ((aom)localObject2).EHv);
        }
        Dy(((aok)localObject1).EHy.type);
        ((aok)localObject1).EHy.dig = ((aom)localObject2).EHA;
        localObject3 = ((aok)localObject1).EHy;
        d.g.b.k.g(localObject3, "tipsInfo.ctrl_info");
        a((ani)localObject3, "notifyTabTip#".concat(String.valueOf(paramString)), (aom)localObject2);
        int i = ady("FinderEntrance").EHv;
        if ((i != 0) && ((i == 3) || (i == 1) || (i == 4))) {
          FinderHomeTabStateVM.a(i, FinderHomeTabStateVM.c.scb);
        }
        ac.i("Finder.RedDotManager", "[notifyTabTip] successfully! tabType=" + ((aom)localObject2).EHv + " objectId=" + ((aom)localObject2).EHA + " diffTime=" + l + "ms isInFinder=" + bool + " currentTabType=" + this.rer.sbQ + " showInfoSize=" + ((aok)localObject1).EHy.EGs.size() + " currentShowTabType=" + i);
        break;
        if (((aok)localObject1).EHy.type == 7)
        {
          localObject3 = i.rfA;
          if (l <= i.cud())
          {
            localObject3 = ((aok)localObject1).EHy.EGs;
            d.g.b.k.g(localObject3, "tipsInfo.ctrl_info.show_infos");
            c.a((LinkedList)localObject3, (d.g.a.b)d.l.reR);
            localObject3 = new StringBuilder("[notifyTabTip] diffTime=").append(l).append("ms, moreTabFriendEntranceTimeMs=");
            locali = i.rfA;
            ac.w("Finder.RedDotManager", i.cud() + "ms, remove entrance path red dot");
          }
        }
      }
    }
    AppMethodBeat.o(201469);
  }
  
  public final void a(apb paramapb)
  {
    AppMethodBeat.i(178172);
    d.g.b.k.h(paramapb, "wxMention");
    long l = ce.azJ();
    Object localObject = i.rfA;
    l -= i.cul();
    if ((paramapb.count <= 0) && (paramapb.EHY <= 0) && (paramapb.EHX <= 0) && (paramapb.EDV <= 0) && (paramapb.EDU <= 0) && (paramapb.EHW <= 0))
    {
      ac.e("Finder.RedDotManager", "[notifyWxMentionCount] server error.");
      AppMethodBeat.o(178172);
      return;
    }
    localObject = new StringBuilder("[notifyWxMentionCount] diffTime=").append(l).append(' ');
    ani localani = paramapb.EHy;
    d.g.b.k.g(localani, "wxMention.ctrl_info");
    ac.i("Finder.RedDotManager", a(localani) + " count=" + paramapb.count);
    localObject = i.rfA;
    if (l < i.cue())
    {
      localObject = paramapb.EHy.EGs;
      d.g.b.k.g(localObject, "wxMention.ctrl_info.show_infos");
      c.a((LinkedList)localObject, (d.g.a.b)n.reT);
    }
    paramapb = paramapb.EHy;
    d.g.b.k.g(paramapb, "wxMention.ctrl_info");
    a(this, paramapb, "notifyWxMentionCount");
    AppMethodBeat.o(178172);
  }
  
  public final void adv(String paramString)
  {
    AppMethodBeat.i(178176);
    d.g.b.k.h(paramString, "path");
    Object localObject1 = new HashSet();
    h localh = adx(paramString);
    if (localh != null) {}
    Object localObject2;
    Object localObject3;
    Object localObject4;
    for (aon localaon = localh.adz(paramString);; localaon = null)
    {
      localObject2 = (List)this.rex.get(paramString);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      if (localObject2 == null) {
        break;
      }
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (h)((Iterator)localObject2).next();
        localObject4 = ((h)localObject3).adA(paramString);
        if (((h)localObject3).a(this.reA)) {
          ((HashSet)localObject1).addAll((Collection)localObject4);
        }
        if (((h)localObject3).ctZ()) {
          ((Iterator)localObject2).remove();
        }
      }
    }
    ac.i("Finder.RedDotManager", "[disposeRedDotAtPath] path=" + paramString + " removePathSet=" + localObject1 + " maybeRemoveShowInfo=" + a(localaon, 0));
    paramString = ((Iterable)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (String)paramString.next();
      localObject2 = adx((String)localObject1);
      if (localObject2 != null)
      {
        localObject3 = ((h)localObject2).adz((String)localObject1);
        if (localObject3 != null) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label298;
          }
          localObject4 = f.rfl;
          f.a(false, (String)localObject1, localaon, localh);
          localObject4 = f.rfl;
          f.a(true, (String)localObject1, (aon)localObject3, (h)localObject2);
          break;
        }
        label298:
        localObject2 = f.rfl;
        f.a(false, (String)localObject1, localaon, localh);
      }
      else
      {
        localObject2 = f.rfl;
        f.a(false, (String)localObject1, localaon, localh);
      }
    }
    AppMethodBeat.o(178176);
  }
  
  public final aon adw(String paramString)
  {
    AppMethodBeat.i(178178);
    d.g.b.k.h(paramString, "path");
    h localh = adx(paramString);
    if (localh != null)
    {
      paramString = localh.adz(paramString);
      AppMethodBeat.o(178178);
      return paramString;
    }
    AppMethodBeat.o(178178);
    return null;
  }
  
  public final h adx(String paramString)
  {
    AppMethodBeat.i(178179);
    d.g.b.k.h(paramString, "path");
    Object localObject = (List)this.rex.get(paramString);
    if (localObject != null)
    {
      ListIterator localListIterator = ((List)localObject).listIterator(((List)localObject).size());
      int i;
      if (localListIterator.hasPrevious())
      {
        localObject = localListIterator.previous();
        if (((h)localObject).adz(paramString) != null)
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
        paramString = (h)paramString;
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
  
  public final void ctG()
  {
    AppMethodBeat.i(178169);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    long l2;
    long l1;
    boolean bool2;
    if (!com.tencent.mm.plugin.finder.storage.b.czT())
    {
      l2 = ctJ();
      if (l2 <= 0L)
      {
        ac.i("Finder.RedDotManager", "[checkPreFetchNow] it's not preFetch yet.");
        AppMethodBeat.o(178169);
        return;
      }
      localObject = i.rfA;
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
      d.g.b.k.g(localObject, "MMKernel.service(IConfigService::class.java)");
      l1 = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getInt("FinderRefreshDiscoveryInterval", 1200) * 1000L / i.cuo();
      bool2 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder();
      l2 = ce.azJ() - l2;
      localObject = new StringBuilder("[checkPreFetchNow] isInFinder=").append(bool2).append(" diffTime=").append(l2).append(" expired=").append(l1).append(" ret=");
      if (l2 < l1) {
        break label224;
      }
    }
    label224:
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("Finder.RedDotManager", bool1);
      if ((!bool2) && (l2 >= l1)) {
        ctF().a(new q((d.g.a.b)new f(this)));
      }
      AppMethodBeat.o(178169);
      return;
    }
  }
  
  public final void ctH()
  {
    AppMethodBeat.i(178183);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUH, Long.valueOf(0L));
    ac.i("Finder.RedDotManager", "[resetPreFetchTime] done.");
    this.reu = (ce.azJ() - this.enterTime);
    long l;
    if ((this.rew) && (this.rev == 2))
    {
      l = this.reu;
      localObject = i.rfA;
      if (l <= i.cug())
      {
        localObject = i.rfA;
        int i = d.k.h.lb(i.cuk() + 1, 3);
        ac.w("Finder.RedDotManager", "[exitFinder] current fastLevel=".concat(String.valueOf(i)));
        localObject = i.rfA;
        i.DC(i);
      }
    }
    for (;;)
    {
      localObject = i.rfA;
      i.cum();
      AppMethodBeat.o(178183);
      return;
      l = this.reu;
      localObject = i.rfA;
      if (l > i.cug())
      {
        ac.w("Finder.RedDotManager", "[exitFinder] revert fastLevel=0");
        localObject = i.rfA;
        i.DC(0);
      }
    }
  }
  
  public final boolean ctK()
  {
    AppMethodBeat.i(201474);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    boolean bool = locale.agA().getBoolean(ah.a.GVR, true);
    AppMethodBeat.o(201474);
    return bool;
  }
  
  public final void lt(boolean paramBoolean)
  {
    AppMethodBeat.i(201475);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVR, Boolean.valueOf(paramBoolean));
    localObject = com.tencent.mm.plugin.finder.report.d.rxr;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.finder.report.d.fy(1, i);
      AppMethodBeat.o(201475);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = true;
    AppMethodBeat.i(201476);
    ac.i("Finder.RedDotManager", "scene = ".concat(String.valueOf(paramn)));
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    do
    {
      AppMethodBeat.o(201476);
      return;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.ren;
    boolean bool1;
    if (!bs.isNullOrNil(com.tencent.mm.model.u.axE()))
    {
      bool1 = true;
      label88:
      paramn = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramn, "MMKernel.storage()");
      paramInt2 = paramn.agA().getInt(ah.a.GVt, g.ctX());
      paramn = com.tencent.mm.plugin.finder.storage.b.rCU;
      if ((!com.tencent.mm.plugin.finder.storage.b.cyP()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
        break label324;
      }
      paramInt1 = 1;
      label143:
      if ((paramInt1 == 0) || (!g.DB(paramInt2)) || (bool1)) {
        break label329;
      }
    }
    for (;;)
    {
      ac.i("Finder.RedDotTransform", "[isShowLocalRedDot] ret=" + bool2 + " local=" + paramInt2 + " hasCreatedIdentity=" + bool1);
      if (!bool2) {
        break;
      }
      paramString.ctV();
      paramString = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.agA().getInt(ah.a.GVt, g.ctX());
      paramInt2 = paramInt1 & 0xFFFFFFFD;
      if (paramInt2 != paramInt1)
      {
        paramString = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramString, "MMKernel.storage()");
        paramString.agA().set(ah.a.GVt, Integer.valueOf(paramInt2));
      }
      ac.i("Finder.RedDotTransform", "[setLocalRedDot] flag=2 unset=true newLocal=" + paramInt2 + " local=" + paramInt1);
      ac.i("Finder.RedDotTransform", "[transformPostRedDot] done");
      break;
      bool1 = false;
      break label88;
      label324:
      paramInt1 = 0;
      break label143;
      label329:
      bool2 = false;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(178168);
    if (!ai.cin())
    {
      AppMethodBeat.o(178168);
      return;
    }
    com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("Finder.RedDotManager");
    Object localObject1 = this.reo;
    com.tencent.mm.plugin.newtips.a.dka().a("FinderNewTipsTransform", (com.tencent.mm.plugin.newtips.a.l.a)localObject1);
    localObject1 = ((Iterable)this.reA.ctx()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (h)((Iterator)localObject1).next();
      ani localani = ((h)localObject2).field_ctrInfo;
      d.g.b.k.g(localani, "it.field_ctrInfo");
      a(((h)localObject2).b(localani), "prepare");
    }
    Object localObject2 = this.ren;
    localObject1 = ((g)localObject2).rfr.adx("FinderEntrance");
    if ((localObject1 != null) && (((h)localObject1).field_ctrInfo.type == -1))
    {
      localObject1 = ((h)localObject1).adz("FinderEntrance");
      if (localObject1 == null) {
        break label229;
      }
      localObject1 = Integer.valueOf(((aon)localObject1).EHC);
      if (localObject1 != null) {
        break label234;
      }
    }
    for (;;)
    {
      if (((g)localObject2).rfr.adx("FinderFirstFav") != null)
      {
        localObject1 = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(localObject1, "MMKernel.storage()");
        localObject1 = ((com.tencent.mm.kernel.e)localObject1).agA().get(ah.a.GWg, Boolean.FALSE);
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(178168);
          throw ((Throwable)localObject1);
          label229:
          localObject1 = null;
          break;
          label234:
          if (((Integer)localObject1).intValue() != 2) {
            continue;
          }
          ac.i("Finder.RedDotTransform", "[checkPostRedDot] has old post red dot, ret=".concat(String.valueOf(((g)localObject2).rfr.Dy(-1))));
          ((g)localObject2).ctV();
          continue;
        }
        if (!((Boolean)localObject1).booleanValue())
        {
          ac.i("Finder.RedDotTransform", "[checkPostRedDot] has old fav red dot, ret=".concat(String.valueOf(((g)localObject2).rfr.Dy(1001))));
          localObject1 = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GWf, Boolean.FALSE);
          ((g)localObject2).ctW();
        }
      }
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (!com.tencent.mm.plugin.finder.storage.b.czT())
    {
      Dy(7);
      Dy(8);
      Dy(1004);
      Dy(1003);
    }
    Dy(1005);
    localb.aic();
    AppMethodBeat.o(178168);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<h, Long>
  {
    public static final e reH;
    
    static
    {
      AppMethodBeat.i(178154);
      reH = new e();
      AppMethodBeat.o(178154);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<q, y>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$deleteCtrlInfo$1$1"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<h, Boolean>
  {
    g(d paramd, h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<q, y>
  {
    h(d paramd, amz paramamz, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<aon, Boolean>
  {
    public static final m reS;
    
    static
    {
      AppMethodBeat.i(201462);
      reS = new m();
      AppMethodBeat.o(201462);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.b<aon, Boolean>
  {
    public static final n reT;
    
    static
    {
      AppMethodBeat.i(178163);
      reT = new n();
      AppMethodBeat.o(178163);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    o(d paramd, ann paramann)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.a<r>
  {
    public static final p reV;
    
    static
    {
      AppMethodBeat.i(178165);
      reV = new p();
      AppMethodBeat.o(178165);
    }
    
    p()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d
 * JD-Core Version:    0.7.0.1
 */