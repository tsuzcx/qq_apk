package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.cgi.m.b;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.a.j;
import d.g.b.q;
import d.l;
import d.o;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "", "tabType", "", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(ILcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "getCache", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getCore", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "isBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isInFindMoreFriendTab", "isInFinder", "", "()Z", "setInFinder", "(Z)V", "isLoading", "setLoading", "lastExitFindMoreFriendTab", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "outSideTimeoutRunnable", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "getOutSideTimeoutRunnable", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "getTabType", "()I", "timer", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "getTimer", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "clear", "isRecycle", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "getPullType", "source", "getReportKey", "isValid", "performBackground", "", "performChangeEnterTargetTab", "lastTab", "targetTab", "performEnterFindMoreFriendTab", "performEnterFinder", "performExitFindMoreFriendTab", "performExitFinder", "performForeground", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "report", "isHasCache", "pullType", "overCount", "requestCache", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setCache", "resp", "print", "Cache", "CacheTime", "PreloadSource", "plugin-finder_release"})
public abstract class f
{
  long INq;
  public boolean INr;
  public final a INs;
  final AtomicBoolean INt;
  final AtomicBoolean INu;
  private final d.f INv;
  public final a.a INw;
  final d.f INx;
  final a INy;
  final FinderStreamTabPreloadCore INz;
  public final String TAG;
  final Condition cPA;
  final ReentrantLock cPz;
  final int duh;
  boolean isLoading;
  
  public f(int paramInt, FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    this.duh = paramInt;
    this.INz = paramFinderStreamTabPreloadCore;
    this.TAG = ("Finder.TabPreloadWorker#" + this.duh);
    this.INs = new a(this.TAG);
    this.INt = new AtomicBoolean(true);
    this.INu = new AtomicBoolean(false);
    this.INv = d.g.O((d.g.a.a)g.LjR);
    this.INw = ((a.a)new d(this));
    this.INx = d.g.O((d.g.a.a)new f(this));
    this.cPz = new ReentrantLock();
    this.cPA = this.cPz.newCondition();
    this.INy = new a(this.duh);
  }
  
  private static long aaZ(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 0L;
    case 1: 
      return 20L;
    case 4: 
      return 40L;
    }
    return 60L;
  }
  
  private final com.tencent.mm.plugin.finder.extension.reddot.e getRedDotManager()
  {
    return (com.tencent.mm.plugin.finder.extension.reddot.e)this.INv.getValue();
  }
  
  public final boolean AB(boolean paramBoolean)
  {
    this.cPz.lock();
    boolean bool;
    for (;;)
    {
      try
      {
        if (this.INy.INA != null)
        {
          bool = true;
          if (!paramBoolean) {
            break label350;
          }
          LinkedList localLinkedList = new LinkedList();
          localObject2 = this.INy.INA;
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((m.f)localObject2).object;
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.syk;
          d.g.b.p.g(localObject3, "it");
          localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, com.tencent.mm.plugin.finder.utils.p.FT(this.duh));
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          localLinkedList.add(b.a.j((FinderItem)localObject3));
          continue;
        }
        bool = false;
      }
      finally
      {
        this.cPz.unlock();
      }
    }
    Object localObject2 = this.INy.INA;
    if (localObject2 != null)
    {
      localObject2 = ((m.f)localObject2).object;
      if (localObject2 != null)
      {
        this.INy.INC.addAll((Collection)localObject2);
        localObject2 = this.INy;
        ((a)localObject2).IND += 1L;
      }
    }
    localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
    int i = this.duh;
    List localList = (List)localObject1;
    localObject2 = new aqy();
    Object localObject3 = h.soM;
    ((aqy)localObject2).rTD = h.Fa(this.duh);
    com.tencent.mm.plugin.finder.utils.p.a(i, localList, (aqy)localObject2);
    for (;;)
    {
      if (bool) {
        ad.i(this.TAG, "[clear] tabType=" + this.duh + " cache=" + this.INy + " isRecycle=" + paramBoolean);
      }
      this.INy.INA = null;
      this.INy.INB = null;
      this.cPz.unlock();
      return bool;
      label350:
      this.INy.IND = 0L;
    }
  }
  
  public final m.f Go(int paramInt)
  {
    Object localObject1 = this.TAG;
    Object localObject3 = new StringBuilder("[request] scene=").append(this.duh).append(", isPreloading:").append(this.isLoading).append(" cache=").append(this.INy).append(" isLocked=").append(this.cPz.isLocked()).append(" fakeWaitForRefresh=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    ad.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.b.cHI().value()).longValue() + "ms ");
    this.cPz.lock();
    label522:
    for (;;)
    {
      long l;
      int i;
      int j;
      try
      {
        if (this.isLoading)
        {
          l = SystemClock.uptimeMillis();
          this.cPA.await(1L, TimeUnit.MINUTES);
          localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
          l = ((Number)com.tencent.mm.plugin.finder.storage.b.cHI().value()).longValue() - (SystemClock.uptimeMillis() - l);
          if (l > 0L) {
            this.cPA.await(l, TimeUnit.MILLISECONDS);
          }
          this.cPz.unlock();
          localObject1 = this.INy.INA;
          if (localObject1 != null)
          {
            i = 1;
            j = this.duh;
            l = this.INy.IND;
            if (paramInt != 0) {
              break label450;
            }
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 1L, 1L, false);
            if (i != 0) {
              break label428;
            }
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 2L, 1L, false);
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 7L, 1L, false);
            if (i != 0) {
              break label522;
            }
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 8L, 1L, false);
            if (localObject1 != null)
            {
              paramInt = this.INy.duh;
              localObject3 = ((m.f)localObject1).lastBuffer;
              d.g.b.p.g(localObject3, "result.lastBuffer");
              new com.tencent.mm.plugin.finder.cgi.c(paramInt, (com.tencent.mm.bx.b)localObject3).aED();
              AB(false);
            }
            return localObject1;
          }
        }
        else
        {
          if (this.INy.INA == null) {
            continue;
          }
          localObject1 = this.cPA;
          localObject3 = com.tencent.mm.plugin.finder.storage.b.sxa;
          ((Condition)localObject1).await(((Number)com.tencent.mm.plugin.finder.storage.b.cHI().value()).longValue(), TimeUnit.MILLISECONDS);
          continue;
        }
        i = 0;
      }
      finally
      {
        this.cPz.unlock();
      }
      continue;
      label428:
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 3L, 1L, false);
      continue;
      label450:
      if (paramInt == 1)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 4L, 1L, false);
        if (i == 0)
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 5L, 1L, false);
        }
        else
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 6L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 9L, 1L, false);
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1421L, aaZ(j) + 10L, 1L + l, false);
        }
      }
    }
  }
  
  public void a(int paramInt, arr paramarr)
  {
    d.g.b.p.h(paramarr, "serverConfig");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[performServerConfigChanged] fromTabType=").append(paramInt).append(" serverConfig=");
    d.g.b.p.h(paramarr, "$this$print");
    ad.i(str, new StringBuilder("[").append(paramarr.Gpv).append(", ").append(paramarr.Gpw).append(", ").append(paramarr.Gpx).append(", ").append(paramarr.Gpy).append(", ").append(paramarr.Gpz).append(", ").append(paramarr.GpA).append(", ").append(paramarr.GpB).append(", ").append(paramarr.GpC).append(", ").append(paramarr.GpD).append(", ").append(paramarr.GpE).append(", ").append(paramarr.GpF).append(", ").append(paramarr.GpG).append(", ").append(paramarr.GpH).append(", ").append(paramarr.GpI).append(", ").append(paramarr.GpJ).append(", ").append(paramarr.GpK).append(", ").append(paramarr.OeA).append(']').toString());
  }
  
  public boolean a(c paramc)
  {
    d.g.b.p.h(paramc, "source");
    ad.i(this.TAG, "[isValid] isInFindMoreFriendTab=" + this.INu + " isBackground=" + this.INt + " isInFinder=" + this.INr + " source=" + paramc);
    if ((paramc == c.ING) || (paramc == c.KuW) || (paramc == c.INI)) {
      if ((this.INr) || (!this.INu.get()) || (this.INt.get())) {}
    }
    while ((this.INr) && (this.INu.get()) && (!this.INt.get()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean b(final c paramc)
  {
    int k = 6;
    int j = 0;
    d.g.b.p.h(paramc, "source");
    if (this.isLoading)
    {
      ad.w(this.TAG, "isLoading=true");
      return false;
    }
    if (!FinderStreamTabPreloadCore.isEnable())
    {
      ad.w(this.TAG, "isEnable=false source=".concat(String.valueOf(paramc)));
      return false;
    }
    if (!a(paramc))
    {
      ad.w(this.TAG, "isValid=false source=".concat(String.valueOf(paramc)));
      return false;
    }
    this.cPz.lock();
    for (;;)
    {
      int i;
      final boolean bool;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        this.isLoading = true;
        i = k;
        if (paramc != c.ING)
        {
          if (paramc == c.INI) {
            i = k;
          }
        }
        else
        {
          if (this.INy.INA == null) {
            break label534;
          }
          bool = true;
          localObject1 = this.INy.INA;
          if (localObject1 != null)
          {
            localObject2 = ((m.f)localObject1).lastBuffer;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label288;
            }
          }
          localObject1 = (f)this;
          localObject2 = com.tencent.mm.kernel.g.ajC();
          d.g.b.p.g(localObject2, "MMKernel.storage()");
          localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl();
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject1 = ((ai)localObject2).get(com.tencent.mm.plugin.finder.utils.p.FS(((f)localObject1).duh), "");
          if (localObject1 != null) {
            break label275;
          }
          throw new v("null cannot be cast to non-null type kotlin.String");
        }
      }
      finally
      {
        this.cPz.unlock();
      }
      if (paramc == c.INH)
      {
        i = 7;
      }
      else if (paramc == c.INJ)
      {
        i = 5;
      }
      else
      {
        i = k;
        if (paramc == c.KuW)
        {
          i = 8;
          continue;
          label275:
          localObject1 = com.tencent.mm.bx.b.cj(bt.aRa((String)localObject1));
          label288:
          localObject2 = this.INy.INA;
          Object localObject4;
          StringBuilder localStringBuilder;
          if (localObject2 != null)
          {
            localObject2 = ((m.f)localObject2).object;
            if (localObject2 != null)
            {
              localObject2 = new LinkedList((Collection)localObject2);
              AB(true);
              localObject3 = new aqy();
              localObject4 = h.soM;
              ((aqy)localObject3).rTD = h.Fa(this.duh);
              localObject4 = this.TAG;
              localStringBuilder = new StringBuilder("[preload] tabType=").append(this.duh).append(", hasCache=").append(bool).append(", consumeFlag=");
              if (!bool) {
                break label529;
              }
            }
          }
          for (;;)
          {
            ad.i((String)localObject4, j + ", unread list size=" + ((LinkedList)localObject2).size() + ", pullType=" + i + ", source=" + paramc + ", cache=" + this.INy);
            new m(this.duh, i, (com.tencent.mm.bx.b)localObject1, (aqy)localObject3, (List)localObject2).a(null, (m.b)new e(this, bool, paramc), true);
            this.cPz.unlock();
            return true;
            localObject2 = new LinkedList();
            break;
            label529:
            j = 1;
          }
          label534:
          bool = false;
        }
      }
    }
  }
  
  public c bEg()
  {
    return c.INI;
  }
  
  public long bEh()
  {
    com.tencent.mm.plugin.finder.extension.reddot.e locale = getRedDotManager();
    getRedDotManager();
    if (locale.ahm(com.tencent.mm.plugin.finder.extension.reddot.e.Er(this.duh)) != null) {}
    for (boolean bool = true;; bool = false) {
      return FinderStreamTabPreloadCore.bu(this.duh, bool);
    }
  }
  
  public void ex(int paramInt1, int paramInt2)
  {
    ad.i(this.TAG, "[performChangeEnterTargetTab] lastTab=" + paramInt1 + " targetTab=" + paramInt2);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;I)V", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "overCount", "getOverCount", "setOverCount", "records", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "recycledList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRecycledList", "()Ljava/util/LinkedList;", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "getResp", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setResp", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;)V", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getSource", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "setSource", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;)V", "getTabType", "()I", "restoreTime", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshPreloadCacheList;", "storeTime", "", "toString", "", "print", "tag", "plugin-finder_release"})
  public final class a
  {
    m.f INA;
    f.c INB;
    final LinkedList<FinderObject> INC;
    long IND;
    final ConcurrentHashMap<Integer, f.b> INE;
    final int duh;
    long hfU;
    
    public a()
    {
      AppMethodBeat.i(221509);
      int i;
      this.duh = i;
      this.INC = new LinkedList();
      this.INE = new ConcurrentHashMap();
      this$1 = bEi();
      Object localObject1 = f.this.GoT;
      d.g.b.p.g(localObject1, "refreshPreloadCacheList.caches");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((aqw)localObject3).duh == this.duh) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label138;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aqw)((Iterator)localObject1).next();
        ((Map)this.INE).put(Integer.valueOf(((aqw)localObject2).dnh), new f.b(((aqw)localObject2).hXx));
      }
      a(f.this, "build");
      AppMethodBeat.o(221509);
    }
    
    public final void a(aqx paramaqx, String paramString)
    {
      AppMethodBeat.i(221508);
      d.g.b.p.h(paramaqx, "$this$print");
      d.g.b.p.h(paramString, "tag");
      String str = f.this.TAG;
      paramString = new StringBuilder("[FinderRefreshPreloadCacheList#print] tag=").append(paramString).append(' ');
      paramaqx = paramaqx.GoT;
      d.g.b.p.g(paramaqx, "this.caches");
      Object localObject1 = (Iterable)paramaqx;
      paramaqx = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      label137:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((aqw)localObject2).duh == this.duh) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label137;
          }
          paramaqx.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)paramaqx;
      paramaqx = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aqw)((Iterator)localObject1).next();
        paramaqx.add(((aqw)localObject2).duh + ':' + ((aqw)localObject2).dnh + "=>" + ((aqw)localObject2).hXx);
      }
      ad.i(str, (List)paramaqx);
      AppMethodBeat.o(221508);
    }
    
    final aqx bEi()
    {
      AppMethodBeat.i(221507);
      Object localObject1 = new aqx();
      Object localObject2 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IHA, "");
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(221507);
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
          ((aqx)localObject1).parseFrom(bt.aRa((String)localObject2));
          AppMethodBeat.o(221507);
          return localObject1;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace(f.this.TAG, (Throwable)localException, "", new Object[0]);
            com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(locale, "MMKernel.storage()");
            locale.ajl().set(al.a.IHA, null);
          }
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221506);
      Object localObject2 = new StringBuilder("[").append(this.INB).append(", resp=");
      Object localObject1 = this.INA;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((m.f)localObject1).hashCode());; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", lastTime=").append(this.hfU).append(", overCount=").append(this.IND).append(", recycledList=");
        Object localObject3 = (Iterable)this.INC;
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(com.tencent.mm.ad.c.rc(((FinderObject)((Iterator)localObject3).next()).id));
        }
      }
      localObject1 = (List)localObject2 + ']';
      AppMethodBeat.o(221506);
      return localObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "", "lastTime", "", "(J)V", "getLastTime", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    private final long hfU;
    
    public b(long paramLong)
    {
      this.hfU = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (this.hfU != paramObject.hfU) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.hfU;
      return (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221510);
      String str = "CacheTime(lastTime=" + this.hfU + ")";
      AppMethodBeat.o(221510);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OutSideRedDot", "InsideRedDot", "OutSideTimeout", "InsideConfigNotify", "OutSideJumpHot", "plugin-finder_release"})
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(221511);
      c localc1 = new c("OutSideRedDot", 0, 1);
      ING = localc1;
      c localc2 = new c("InsideRedDot", 1, 2);
      INH = localc2;
      c localc3 = new c("OutSideTimeout", 2, 3);
      INI = localc3;
      c localc4 = new c("InsideConfigNotify", 3, 4);
      INJ = localc4;
      c localc5 = new c("OutSideJumpHot", 4, 5);
      KuW = localc5;
      LjO = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(221511);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$outSideTimeoutRunnable$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
  public static final class d
    extends a.a
  {
    public final void run()
    {
      AppMethodBeat.i(221514);
      ad.i(this.INF.TAG, "outSideTimeoutRunnable run... isInFinder=" + this.INF.INr);
      if (!this.INF.INr)
      {
        this.INF.b(this.INF.bEg());
        this.INF.INs.a((a.a)this, this.INF.bEh(), "outSideTimeoutRunnable");
      }
      AppMethodBeat.o(221514);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$preload$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class e
    implements m.b
  {
    e(boolean paramBoolean, f.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, m.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.e> paramList)
    {
      AppMethodBeat.i(221517);
      d.g.b.p.h(paramf, "resp");
      d.g.b.p.h(paramList, "interceptors");
      this.INF.cPz.lock();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        try
        {
          this.INF.INy.INC.clear();
          if (!paramf.object.isEmpty())
          {
            f localf = this.INF;
            f.c localc = paramc;
            localf.INy.INA = paramf;
            localf.INy.INB = localc;
            Object localObject = localf.INy;
            d.g.b.p.h(localc, "source");
            ((f.a)localObject).hfU = System.currentTimeMillis();
            ((Map)((f.a)localObject).INE).put(Integer.valueOf(localc.value), new f.b(((f.a)localObject).hfU));
            aqx localaqx = ((f.a)localObject).bEi();
            paramString = localaqx.GoT;
            d.g.b.p.g(paramString, "list.caches");
            paramList = ((Iterable)paramString).iterator();
            if (paramList.hasNext())
            {
              paramString = paramList.next();
              if (((aqw)paramString).dnh == localc.value)
              {
                paramInt1 = 1;
                break label902;
                paramList = (aqw)paramString;
                paramString = paramList;
                if (paramList == null)
                {
                  paramString = new aqw();
                  localaqx.GoT.add(paramString);
                }
                paramString.dnh = localc.value;
                paramString.hXx = ((f.a)localObject).hfU;
                paramString.duh = ((f.a)localObject).duh;
                paramString = com.tencent.mm.kernel.g.ajC();
                d.g.b.p.g(paramString, "MMKernel.storage()");
                paramString.ajl().set(al.a.IHA, bt.cE(localaqx.toByteArray()));
                ((f.a)localObject).a(localaqx, "storeTime");
                paramString = com.tencent.mm.plugin.finder.storage.b.sxa;
                if (com.tencent.mm.plugin.finder.storage.b.cGJ())
                {
                  paramString = paramf.object;
                  d.g.b.p.g(paramString, "resp.`object`");
                  paramString = (FinderObject)j.jd((List)paramString);
                  if (paramString != null)
                  {
                    paramList = FinderItem.syk;
                    paramList = com.tencent.mm.plugin.finder.utils.p.sMo;
                    paramString = FinderItem.a.a(paramString, com.tencent.mm.plugin.finder.utils.p.FT(localf.duh));
                    paramList = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
                    paramString = b.a.j(paramString);
                    paramList = new LinkedList();
                    paramList.addAll((Collection)paramString.feedObject.getMediaList());
                    paramList = new o(paramString, j.s((Collection)paramList));
                    localObject = new LinkedList();
                    ((LinkedList)localObject).add(paramList);
                    ((com.tencent.mm.plugin.finder.preload.worker.b)localf.INx.getValue()).a(paramString, j.s((Collection)localObject), 0);
                  }
                }
                paramString = MediaPreloadCore.skO;
                if (MediaPreloadCore.cDb())
                {
                  paramString = com.tencent.mm.plugin.finder.storage.b.sxa;
                  if (com.tencent.mm.plugin.finder.storage.b.cGJ()) {
                    com.tencent.mm.ad.c.g((d.g.a.a)new f.h(localc));
                  }
                }
                ad.i(this.INF.TAG, "[onCgiBack] tabType=" + this.INF.duh + " preload successfully! size=" + paramf.object.size() + " cache=" + this.INF.INy);
                return;
              }
              paramInt1 = 0;
              break label902;
            }
            paramString = null;
            continue;
          }
          ad.e(this.INF.TAG, "[onCgiBack] tabType=" + this.INF.duh + " preload fail! list is empty! cache=" + this.INF.INy);
          continue;
          this.INF.AB(true);
        }
        finally
        {
          if (paramf.Gqc != null)
          {
            paramList = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(paramList, "MMKernel.storage()");
            paramList.ajl().set(al.a.IHz, bt.cE(paramf.Gqc.toByteArray()));
            this.INF.a(this.INF.duh, FinderStreamTabPreloadCore.bEf());
          }
          this.INF.isLoading = false;
          this.INF.cPA.signalAll();
          this.INF.cPz.unlock();
          AppMethodBeat.o(221517);
        }
        ad.e(this.INF.TAG, "[onCgiBack] tabType=" + this.INF.duh + " preload fail! errType=" + paramInt1 + " errCode=" + paramInt2 + " cache=" + this.INF.INy);
        continue;
        label902:
        if (paramInt1 == 0) {}
      }
    }
    
    public final void a(ars paramars)
    {
      AppMethodBeat.i(221516);
      d.g.b.p.h(paramars, "request");
      if (bool)
      {
        paramars.OeB = 0;
        AppMethodBeat.o(221516);
        return;
      }
      paramars.OeB = 1;
      AppMethodBeat.o(221516);
    }
    
    public final boolean a(cvp paramcvp)
    {
      AppMethodBeat.i(221515);
      d.g.b.p.h(paramcvp, "resp");
      AppMethodBeat.o(221515);
      return false;
    }
    
    public final boolean cxW()
    {
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.extension.reddot.e>
  {
    public static final g LjR;
    
    static
    {
      AppMethodBeat.i(221520);
      LjR = new g();
      AppMethodBeat.o(221520);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(f.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.f
 * JD-Core Version:    0.7.0.1
 */