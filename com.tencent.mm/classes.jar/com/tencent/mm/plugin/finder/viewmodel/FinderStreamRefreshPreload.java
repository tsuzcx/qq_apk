package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.Observer;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.k.a;
import com.tencent.mm.plugin.finder.cgi.k.d;
import com.tencent.mm.plugin.finder.extension.reddot.f.a;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.f;
import d.g.a.a;
import d.g.b.w;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "appBackgroundTime", "", "currentIndexInMainUI", "", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$mainUiIndexChangeListener$1;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "redDotCtrInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "getServerConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "servers", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Server;", "stateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stateVM$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "get", "tabType", "getOuterTime", "withRedDot", "", "isEnable", "onAppBackground", "", "activity", "onAppForeground", "onChanged", "result", "onEnterFinder", "onExitFinder", "onRedDotRevoke", "ctrInfo", "run", "setup", "print", "Cache", "Companion", "Server", "Source", "plugin-finder_release"})
public final class FinderStreamRefreshPreload
  extends UIComponentPlugin<PluginFinder>
  implements Observer<f.a>, com.tencent.mm.app.n, Runnable
{
  private static boolean cuo;
  public static final FinderStreamRefreshPreload.b scx;
  public final ao rvb;
  private final ConcurrentHashMap<Integer, c> scq;
  private final f scr;
  private final f scs;
  private int sct;
  public final e scu;
  private final ConcurrentHashMap<String, h> scv;
  private long scw;
  
  static
  {
    AppMethodBeat.i(204424);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(FinderStreamRefreshPreload.class), "preloadVideoWorker", "getPreloadVideoWorker()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;")), (d.l.k)w.a(new d.g.b.u(w.bn(FinderStreamRefreshPreload.class), "stateVM", "getStateVM()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;")) };
    scx = new FinderStreamRefreshPreload.b((byte)0);
    AppMethodBeat.o(204424);
  }
  
  public FinderStreamRefreshPreload()
  {
    AppMethodBeat.i(204435);
    this.scq = new ConcurrentHashMap();
    this.rvb = new ao("StreamRefreshPreload");
    this.scr = d.g.K((a)f.scK);
    this.scs = d.g.K((a)g.scL);
    this.sct = -1;
    this.scu = new e(this);
    this.scv = new ConcurrentHashMap();
    AppMethodBeat.o(204435);
  }
  
  public static String a(aoc paramaoc)
  {
    AppMethodBeat.i(204427);
    d.g.b.k.h(paramaoc, "$this$print");
    paramaoc = "[" + paramaoc.EGM + ", " + paramaoc.EGN + ", " + paramaoc.EGO + ", " + paramaoc.EGP + ", " + paramaoc.EGQ + ", " + paramaoc.EGR + ", " + paramaoc.EGS + ", " + paramaoc.EGT + ']';
    AppMethodBeat.o(204427);
    return paramaoc;
  }
  
  private static int ag(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204434);
    int i;
    switch (paramInt)
    {
    default: 
      i = 2147483647;
    }
    for (;;)
    {
      ac.i("Finder.StreamRefreshPreload", "[getOuterTime] tabType=" + paramInt + " withRedDot=" + paramBoolean + " time=" + i + "s isDebug=" + cuo);
      if (!cuo) {
        break;
      }
      AppMethodBeat.o(204434);
      return 1;
      if (!paramBoolean)
      {
        i = cFN().EGQ;
      }
      else
      {
        i = cFN().EGM;
        continue;
        if (!paramBoolean)
        {
          i = cFN().EGR;
        }
        else
        {
          i = cFN().EGN;
          continue;
          if (!paramBoolean)
          {
            i = cFN().EGS;
          }
          else
          {
            i = cFN().EGO;
            continue;
            if (!paramBoolean) {
              i = cFN().EGT;
            } else {
              i = cFN().EGP;
            }
          }
        }
      }
    }
    AppMethodBeat.o(204434);
    return i;
  }
  
  private static aoc cFN()
  {
    AppMethodBeat.i(204426);
    aoc localaoc = new aoc();
    try
    {
      Object localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agA().get(ah.a.GUS, "");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(204426);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("Finder.StreamRefreshPreload", (Throwable)localException, "", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(204426);
      return localaoc;
      localaoc.parseFrom(bs.aLu((String)localException));
      ac.i("Finder.StreamRefreshPreload", "[get] serverConfig=" + a(localaoc));
    }
  }
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(204433);
    if (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showFinderEntry())
    {
      ac.i("Finder.StreamRefreshPreload", "finder entry close then return");
      AppMethodBeat.o(204433);
      return false;
    }
    if ((com.tencent.mm.model.u.axB() & 0x0) != 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.i("Finder.StreamRefreshPreload", "finder find more ui entry close then return");
      AppMethodBeat.o(204433);
      return false;
    }
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (!com.tencent.mm.plugin.finder.storage.b.cAp())
    {
      ac.i("Finder.StreamRefreshPreload", "isEnablePreloadStreamRefresh false then return");
      AppMethodBeat.o(204433);
      return false;
    }
    AppMethodBeat.o(204433);
    return true;
  }
  
  public final c EY(int paramInt)
  {
    AppMethodBeat.i(204428);
    c localc2 = (c)this.scq.get(Integer.valueOf(paramInt));
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c(paramInt);
      ((Map)this.scq).put(Integer.valueOf(paramInt), localc1);
    }
    AppMethodBeat.o(204428);
    return localc1;
  }
  
  public final FinderHomeTabStateVM cFM()
  {
    AppMethodBeat.i(204425);
    FinderHomeTabStateVM localFinderHomeTabStateVM = (FinderHomeTabStateVM)this.scs.getValue();
    AppMethodBeat.o(204425);
    return localFinderHomeTabStateVM;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(204431);
    this.scw = SystemClock.uptimeMillis();
    this.rvb.removeCallbacksAndMessages(null);
    AppMethodBeat.o(204431);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(204430);
    if (isEnable())
    {
      if (this.sct != 2)
      {
        ac.i("Finder.StreamRefreshPreload", "currentIndexInMainUI=" + this.sct + " then return");
        AppMethodBeat.o(204430);
        return;
      }
      long l1 = SystemClock.uptimeMillis() - this.scw;
      paramString = com.tencent.mm.plugin.finder.storage.b.rCU;
      long l2 = Math.max(0L, com.tencent.mm.plugin.finder.storage.b.cAr() - l1);
      paramString = new StringBuilder("[onAppForeground] stay=").append(l1).append("ms delay=").append(l2).append("ms checkPreloadStreamRefreshTime=");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      ac.i("Finder.StreamRefreshPreload", com.tencent.mm.plugin.finder.storage.b.cAr() + "ms");
      this.rvb.postDelayed((Runnable)this, l2);
    }
    AppMethodBeat.o(204430);
  }
  
  public final void run()
  {
    AppMethodBeat.i(204432);
    if (!isEnable())
    {
      AppMethodBeat.o(204432);
      return;
    }
    if (this.sct != 2)
    {
      ac.i("Finder.StreamRefreshPreload", "currentIndexInMainUI=" + this.sct + " then return");
      AppMethodBeat.o(204432);
      return;
    }
    Object localObject1 = this.scq.values();
    d.g.b.k.g(localObject1, "servers.values");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((c)((Iterator)localObject1).next()).diw;
      int j = ag(i, false);
      localObject2 = EY(i);
      if (((c)localObject2).a(j, d.scH)) {
        ((c)localObject2).a(d.scH);
      } else {
        ac.i("Finder.StreamRefreshPreload", "[check] it not need to preload. lastTabType=".concat(String.valueOf(i)));
      }
    }
    localObject1 = this.rvb;
    Object localObject2 = (Runnable)this;
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    ((ao)localObject1).postDelayed((Runnable)localObject2, com.tencent.mm.plugin.finder.storage.b.cAr());
    AppMethodBeat.o(204432);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Cache;", "", "tabType", "", "(I)V", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "records", "Ljava/util/concurrent/ConcurrentHashMap;", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "getResp", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setResp", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;)V", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Source;", "getSource", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Source;", "setSource", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Source;)V", "getTabType", "()I", "component1", "copy", "equals", "", "other", "hashCode", "isCanPreload", "expired", "restore", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshPreloadCacheList;", "storeTime", "", "toString", "", "print", "tag", "plugin-finder_release"})
  public static final class a
  {
    final int diw;
    final ConcurrentHashMap<Integer, Long> scA;
    k.d scy;
    FinderStreamRefreshPreload.d scz;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(204403);
      this.diw = paramInt;
      this.scA = new ConcurrentHashMap();
      anl localanl = cFR();
      Object localObject1 = localanl.EGw;
      d.g.b.k.g(localObject1, "list.caches");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label121:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((ank)localObject3).diw == this.diw) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label121;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ank)((Iterator)localObject1).next();
        ((Map)this.scA).put(Integer.valueOf(((ank)localObject2).dbL), Long.valueOf(((ank)localObject2).hES));
      }
      a(localanl, "build");
      AppMethodBeat.o(204403);
    }
    
    public static void a(anl paramanl, String paramString)
    {
      AppMethodBeat.i(204401);
      d.g.b.k.h(paramanl, "$this$print");
      d.g.b.k.h(paramString, "tag");
      paramString = new StringBuilder("[FinderRefreshPreloadCacheList#print] tag=").append(paramString).append(' ');
      paramanl = paramanl.EGw;
      d.g.b.k.g(paramanl, "this.caches");
      Object localObject = (Iterable)paramanl;
      paramanl = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ank localank = (ank)((Iterator)localObject).next();
        paramanl.add(localank.diw + ':' + localank.dbL + "=>" + localank.hES);
      }
      ac.i("Finder.StreamRefreshPreload", (List)paramanl);
      AppMethodBeat.o(204401);
    }
    
    static anl cFR()
    {
      AppMethodBeat.i(204400);
      Object localObject1 = new anl();
      Object localObject2 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA().get(ah.a.GUT, "");
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(204400);
        throw ((Throwable)localObject1);
      }
      localObject2 = (String)localObject2;
      int i;
      if (((CharSequence)localObject2).length() > 0) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {}
        try
        {
          ((anl)localObject1).parseFrom(bs.aLu((String)localObject2));
          AppMethodBeat.o(204400);
          return localObject1;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("Finder.StreamRefreshPreload", (Throwable)localException, "", new Object[0]);
            com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(locale, "MMKernel.storage()");
            locale.agA().set(ah.a.GUT, null);
          }
        }
      }
    }
    
    public final boolean a(long paramLong, FinderStreamRefreshPreload.d paramd)
    {
      AppMethodBeat.i(204402);
      d.g.b.k.h(paramd, "source");
      if (paramLong <= 0L)
      {
        AppMethodBeat.o(204402);
        return false;
      }
      long l = ce.azJ();
      Long localLong = (Long)this.scA.get(Integer.valueOf(paramd.value));
      paramd = localLong;
      if (localLong == null) {
        paramd = Long.valueOf(0L);
      }
      if (l - paramd.longValue() >= paramLong)
      {
        AppMethodBeat.o(204402);
        return true;
      }
      AppMethodBeat.o(204402);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.diw != paramObject.diw) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.diw;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204404);
      String str = "Cache(tabType=" + this.diw + ")";
      AppMethodBeat.o(204404);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Server;", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload;I)V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Cache;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "isLoading", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getTabType", "()I", "setTabType", "(I)V", "clear", "", "isRecycle", "isCanPreload", "expired", "source", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Source;", "preload", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setCache", "resp", "plugin-finder_release"})
  public final class c
  {
    final ReentrantLock cEu;
    final Condition cEv;
    int diw;
    boolean isLoading;
    private FinderStreamRefreshPreload.a scB;
    
    public c()
    {
      AppMethodBeat.i(204415);
      int i;
      this.diw = i;
      this.scB = new FinderStreamRefreshPreload.a(this.diw);
      this.cEu = new ReentrantLock();
      this.cEv = this.cEu.newCondition();
      AppMethodBeat.o(204415);
    }
    
    public final void a(k.d paramd, final FinderStreamRefreshPreload.d paramd1)
    {
      AppMethodBeat.i(204412);
      d.g.b.k.h(paramd, "resp");
      d.g.b.k.h(paramd1, "source");
      Object localObject1 = MediaPreloadCore.rvo;
      if (MediaPreloadCore.cwJ()) {
        com.tencent.mm.ac.c.g((a)new b(this, paramd1));
      }
      this.scB.scy = paramd;
      this.scB.scz = paramd1;
      FinderStreamRefreshPreload.a locala = this.scB;
      d.g.b.k.h(paramd1, "source");
      long l = ce.azJ();
      ((Map)locala.scA).put(Integer.valueOf(paramd1.value), Long.valueOf(l));
      anl localanl = FinderStreamRefreshPreload.a.cFR();
      localObject1 = localanl.EGw;
      d.g.b.k.g(localObject1, "list.caches");
      Object localObject2 = ((Iterable)localObject1).iterator();
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (((ank)localObject1).dbL == paramd1.value)
        {
          i = 1;
          label169:
          if (i == 0) {
            break label429;
          }
        }
      }
      for (;;)
      {
        localObject2 = (ank)localObject1;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ank();
          localanl.EGw.add(localObject1);
        }
        ((ank)localObject1).dbL = paramd1.value;
        ((ank)localObject1).hES = l;
        ((ank)localObject1).diw = locala.diw;
        paramd1 = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramd1, "MMKernel.storage()");
        paramd1.agA().set(ah.a.GUT, bs.cx(localanl.toByteArray()));
        FinderStreamRefreshPreload.a.a(localanl, "storeTime");
        paramd1 = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (!com.tencent.mm.plugin.finder.storage.b.cAq()) {
          break label437;
        }
        ac.i("Finder.StreamRefreshPreload", "[setCache] preload video...");
        paramd = paramd.object;
        d.g.b.k.g(paramd, "resp.`object`");
        paramd = (FinderObject)j.iP((List)paramd);
        if (paramd == null) {
          break label437;
        }
        paramd1 = FinderItem.rDA;
        paramd1 = com.tencent.mm.plugin.finder.utils.n.rPN;
        paramd = FinderItem.a.a(paramd, com.tencent.mm.plugin.finder.utils.n.EJ(this.diw));
        paramd1 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        paramd = b.a.i(paramd);
        paramd1 = new LinkedList();
        paramd1.addAll((Collection)paramd.feedObject.getMediaList());
        paramd1 = new o(paramd, j.r((Collection)paramd1));
        localObject1 = new LinkedList();
        ((LinkedList)localObject1).add(paramd1);
        FinderStreamRefreshPreload.a(FinderStreamRefreshPreload.this).a(paramd, j.r((Collection)localObject1), 0);
        AppMethodBeat.o(204412);
        return;
        i = 0;
        break label169;
        label429:
        break;
        localObject1 = null;
      }
      label437:
      AppMethodBeat.o(204412);
    }
    
    public final void a(final FinderStreamRefreshPreload.d paramd)
    {
      Object localObject1 = null;
      int j = 6;
      AppMethodBeat.i(204413);
      d.g.b.k.h(paramd, "source");
      if (!FinderStreamRefreshPreload.cFO())
      {
        AppMethodBeat.o(204413);
        return;
      }
      if (this.diw != 4)
      {
        ac.w("Finder.StreamRefreshPreload", "[preload] not care tabType(" + this.diw + "), just return.");
        AppMethodBeat.o(204413);
        return;
      }
      this.cEu.lock();
      this.isLoading = true;
      int i = j;
      Object localObject3;
      for (;;)
      {
        try
        {
          if (paramd != FinderStreamRefreshPreload.d.scF)
          {
            if (paramd == FinderStreamRefreshPreload.d.scH) {
              i = j;
            }
          }
          else
          {
            Object localObject2 = new StringBuilder("[preload] scene=").append(this.diw).append(", last cache=");
            localObject3 = this.scB.scy;
            if (localObject3 != null) {
              localObject1 = Integer.valueOf(((k.d)localObject3).hashCode());
            }
            ac.i("Finder.StreamRefreshPreload", localObject1 + ", pullType=" + i + " source=" + paramd);
            localObject3 = new anm();
            localObject1 = d.rxr;
            ((anm)localObject3).rfR = d.DW(this.diw);
            localObject1 = this.scB.scy;
            if (localObject1 != null)
            {
              localObject2 = ((k.d)localObject1).lastBuffer;
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label386;
              }
            }
            localObject1 = (c)this;
            localObject2 = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(localObject2, "MMKernel.storage()");
            localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA();
            com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
            localObject1 = ((ae)localObject2).get(com.tencent.mm.plugin.finder.utils.n.EI(((c)localObject1).diw), "");
            if (localObject1 != null) {
              break;
            }
            paramd = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(204413);
            throw paramd;
          }
        }
        finally
        {
          this.cEu.unlock();
          AppMethodBeat.o(204413);
        }
        if (paramd == FinderStreamRefreshPreload.d.scG)
        {
          i = 7;
        }
        else
        {
          i = j;
          if (paramd != FinderStreamRefreshPreload.d.scH)
          {
            i = j;
            if (paramd == FinderStreamRefreshPreload.d.scI) {
              i = 5;
            }
          }
        }
      }
      localObject1 = com.tencent.mm.bw.b.cc(bs.aLu((String)localObject1));
      label386:
      new com.tencent.mm.plugin.finder.cgi.k(this.diw, i, (com.tencent.mm.bw.b)localObject1, (anm)localObject3).a(null, (k.a)new a(this, paramd), true);
      this.cEu.unlock();
      AppMethodBeat.o(204413);
    }
    
    public final boolean a(int paramInt, FinderStreamRefreshPreload.d paramd)
    {
      AppMethodBeat.i(204411);
      d.g.b.k.h(paramd, "source");
      if ((this.scB.diw != 4) && (this.scB.diw != 2) && (this.scB.scz == FinderStreamRefreshPreload.d.scF) && (paramd != FinderStreamRefreshPreload.d.scF))
      {
        ac.w("Finder.StreamRefreshPreload", "[isCanPreload] expired=" + paramInt + "s source=" + paramd + " cacheSource=" + this.scB.scz);
        AppMethodBeat.o(204411);
        return false;
      }
      boolean bool = this.scB.a(paramInt * 1000L, paramd);
      ac.i("Finder.StreamRefreshPreload", "[isCanPreload] expired=" + paramInt + "s source=" + paramd + " cacheSource=" + this.scB.scz);
      AppMethodBeat.o(204411);
      return bool;
    }
    
    public final k.d cFS()
    {
      AppMethodBeat.i(204414);
      Object localObject3 = new StringBuilder("[request] scene=").append(this.diw).append(", cache=");
      Object localObject1 = this.scB.scy;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((k.d)localObject1).hashCode());
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" isLocked=").append(this.cEu.isLocked()).append(" fakeWaitForRefresh=");
        localObject3 = com.tencent.mm.plugin.finder.storage.b.rCU;
        ac.i("Finder.StreamRefreshPreload", com.tencent.mm.plugin.finder.storage.b.cAs() + "ms isPreloading:" + this.isLoading);
        this.cEu.lock();
      }
      label285:
      for (;;)
      {
        try
        {
          if (this.isLoading)
          {
            long l = SystemClock.uptimeMillis();
            this.cEv.await();
            localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
            l = com.tencent.mm.plugin.finder.storage.b.cAs() - (SystemClock.uptimeMillis() - l);
            if (l > 0L) {
              this.cEv.await(l, TimeUnit.MILLISECONDS);
            }
            this.cEu.unlock();
            localObject1 = this.scB.scy;
            a(this);
            if (this.diw == 4)
            {
              if (localObject1 != null) {
                break label285;
              }
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 100L, 1L, false);
            }
            AppMethodBeat.o(204414);
            return localObject1;
            localObject1 = null;
            break;
          }
          if (this.scB.scy != null)
          {
            localObject1 = this.cEv;
            localObject3 = com.tencent.mm.plugin.finder.storage.b.rCU;
            ((Condition)localObject1).await(com.tencent.mm.plugin.finder.storage.b.cAs(), TimeUnit.MILLISECONDS);
            continue;
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 101L, 1L, false);
          }
        }
        finally
        {
          this.cEu.unlock();
          AppMethodBeat.o(204414);
        }
      }
    }
    
    public final void clear(boolean paramBoolean)
    {
      Object localObject1 = null;
      AppMethodBeat.i(204409);
      this.cEu.lock();
      if (paramBoolean)
      {
        try
        {
          localObject3 = new StringBuilder("[clear] tabType=").append(this.diw).append(" cache=");
          localObject4 = this.scB.scy;
          if (localObject4 != null) {
            localObject1 = Integer.valueOf(((k.d)localObject4).hashCode());
          }
          ac.i("Finder.StreamRefreshPreload", localObject1 + " isRecycle=" + paramBoolean);
          localObject1 = new LinkedList();
          localObject3 = this.scB.scy;
          if (localObject3 != null)
          {
            localObject3 = ((k.d)localObject3).object;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (FinderObject)((Iterator)localObject3).next();
                Object localObject5 = FinderItem.rDA;
                d.g.b.k.g(localObject4, "it");
                localObject5 = com.tencent.mm.plugin.finder.utils.n.rPN;
                localObject4 = FinderItem.a.a((FinderObject)localObject4, com.tencent.mm.plugin.finder.utils.n.EJ(this.diw));
                localObject5 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
                ((LinkedList)localObject1).add(b.a.i((FinderItem)localObject4));
              }
            }
          }
          localObject3 = com.tencent.mm.plugin.finder.utils.n.rPN;
        }
        finally
        {
          this.cEu.unlock();
          AppMethodBeat.o(204409);
        }
        int i = this.diw;
        List localList = (List)localObject2;
        Object localObject3 = new anm();
        Object localObject4 = d.rxr;
        ((anm)localObject3).rfR = d.DW(this.diw);
        com.tencent.mm.plugin.finder.utils.n.a(i, localList, (anm)localObject3);
      }
      this.scB.scy = null;
      this.scB.scz = null;
      this.cEu.unlock();
      AppMethodBeat.o(204409);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Server$preload$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "plugin-finder_release"})
    public static final class a
      implements k.a
    {
      a(FinderStreamRefreshPreload.d paramd) {}
      
      public final void a(int paramInt1, int paramInt2, String paramString, k.d paramd)
      {
        AppMethodBeat.i(204407);
        d.g.b.k.h(paramd, "resp");
        this.scD.cEu.lock();
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (;;)
        {
          try
          {
            if (paramd.EHp != null)
            {
              paramString = com.tencent.mm.kernel.g.agR();
              d.g.b.k.g(paramString, "MMKernel.storage()");
              paramString.agA().set(ah.a.GUS, bs.cx(paramd.EHp.toByteArray()));
            }
            ac.i("Finder.StreamRefreshPreload", "[onCgiBack] preload successfully! scene=" + this.scD.diw + " config=" + FinderStreamRefreshPreload.a(FinderStreamRefreshPreload.cFP()));
            this.scD.clear(true);
            this.scD.a(paramd, paramd);
            return;
          }
          finally
          {
            this.scD.isLoading = false;
            this.scD.cEv.signalAll();
            this.scD.cEu.unlock();
            AppMethodBeat.o(204407);
          }
          this.scD.clear(true);
          ac.e("Finder.StreamRefreshPreload", "[onCgiBack] preload fail! scene=" + this.scD.diw + " config=" + FinderStreamRefreshPreload.a(FinderStreamRefreshPreload.cFP()));
        }
      }
      
      public final void a(aod paramaod)
      {
        AppMethodBeat.i(204406);
        d.g.b.k.h(paramaod, "request");
        AppMethodBeat.o(204406);
      }
      
      public final boolean b(int paramInt1, int paramInt2, cqk paramcqk)
      {
        AppMethodBeat.i(204405);
        d.g.b.k.h(paramcqk, "resp");
        AppMethodBeat.o(204405);
        return false;
      }
      
      public final boolean csh()
      {
        return false;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements a<y>
    {
      b(FinderStreamRefreshPreload.c paramc, FinderStreamRefreshPreload.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$Source;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OutRedDot", "InsideRedDot", "OutTimeout", "Enter", "plugin-finder_release"})
  public static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(204416);
      d locald1 = new d("OutRedDot", 0, 1);
      scF = locald1;
      d locald2 = new d("InsideRedDot", 1, 2);
      scG = locald2;
      d locald3 = new d("OutTimeout", 2, 3);
      scH = locald3;
      d locald4 = new d("Enter", 3, 4);
      scI = locald4;
      scJ = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(204416);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/FinderStreamRefreshPreload$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<jv>
  {
    private long gLX;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    public static final f scK;
    
    static
    {
      AppMethodBeat.i(204421);
      scK = new f();
      AppMethodBeat.o(204421);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<FinderHomeTabStateVM>
  {
    public static final g scL;
    
    static
    {
      AppMethodBeat.i(204423);
      scL = new g();
      AppMethodBeat.o(204423);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderStreamRefreshPreload
 * JD-Core Version:    0.7.0.1
 */