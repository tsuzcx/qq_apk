package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.cgi.m.b;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "", "tabType", "", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(ILcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "getCache", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getCore", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "isBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isInFindMoreFriendTab", "isInFinder", "", "()Z", "setInFinder", "(Z)V", "isLoading", "setLoading", "lastExitFindMoreFriendTab", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "outSideTimeoutRunnable", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "getOutSideTimeoutRunnable", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "getTabType", "()I", "timer", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "getTimer", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "clear", "isRecycle", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "getPullType", "source", "getReportKey", "isAcceptCgiBack", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "performBackground", "", "performChangeEnterTargetTab", "lastTab", "targetTab", "performEnterFindMoreFriendTab", "performEnterFinder", "performExitFindMoreFriendTab", "performExitFinder", "performForeground", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "report", "isHasCache", "pullType", "overCount", "requestCache", "setCache", "updateCacheStatus", "print", "Cache", "CacheTime", "PreloadSource", "Ret", "plugin-finder_release"})
public abstract class f
{
  public final String TAG;
  final ReentrantLock cQj;
  final Condition cQk;
  final int dvm;
  volatile boolean isLoading;
  long suM;
  public boolean suN;
  public final a suO;
  final AtomicBoolean suP;
  final AtomicBoolean suQ;
  private final d.f suR;
  public final a.a suS;
  final d.f suT;
  final a suU;
  final FinderStreamTabPreloadCore suV;
  
  public f(int paramInt, FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    this.dvm = paramInt;
    this.suV = paramFinderStreamTabPreloadCore;
    this.TAG = ("Finder.TabPreloadWorker#" + this.dvm);
    this.suO = new a(this.TAG);
    this.suP = new AtomicBoolean(true);
    this.suQ = new AtomicBoolean(false);
    this.suR = d.g.O((d.g.a.a)h.svq);
    this.suS = ((a.a)new e(this));
    this.suT = d.g.O((d.g.a.a)new g(this));
    this.cQj = new ReentrantLock();
    this.cQk = this.cQj.newCondition();
    this.suU = new a(this.dvm);
  }
  
  private static long Fa(int paramInt)
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
    return (com.tencent.mm.plugin.finder.extension.reddot.e)this.suR.getValue();
  }
  
  public final m.f EZ(int paramInt)
  {
    Object localObject1 = this.TAG;
    Object localObject3 = new StringBuilder("[request] scene=").append(this.dvm).append(", isPreloading:").append(this.isLoading).append(" cache=").append(this.suU).append(" isLocked=").append(this.cQj.isLocked()).append(" fakeWaitForRefresh=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    ae.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.b.cJH().value()).longValue() + "ms ");
    this.cQj.lock();
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
          this.cQk.await(1L, TimeUnit.MINUTES);
          localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
          l = ((Number)com.tencent.mm.plugin.finder.storage.b.cJH().value()).longValue() - (SystemClock.uptimeMillis() - l);
          if (l > 0L) {
            this.cQk.await(l, TimeUnit.MILLISECONDS);
          }
          this.cQj.unlock();
          localObject1 = this.suU.suW;
          if (localObject1 != null)
          {
            i = 1;
            j = this.dvm;
            l = this.suU.suZ;
            if (paramInt != 0) {
              break label436;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 1L, 1L, false);
            if (i != 0) {
              break label414;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 2L, 1L, false);
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 7L, 1L, false);
            if (i != 0) {
              break label508;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 8L, 1L, false);
            if (localObject1 != null)
            {
              new com.tencent.mm.plugin.finder.cgi.c(this.suU.dvm, ((m.f)localObject1).lastBuffer).aET();
              lX(false);
            }
            return localObject1;
          }
        }
        else
        {
          if (this.suU.suW == null) {
            continue;
          }
          localObject1 = this.cQk;
          localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
          ((Condition)localObject1).await(((Number)com.tencent.mm.plugin.finder.storage.b.cJH().value()).longValue(), TimeUnit.MILLISECONDS);
          continue;
        }
        i = 0;
      }
      finally
      {
        this.cQj.unlock();
      }
      continue;
      label414:
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 3L, 1L, false);
      continue;
      label436:
      if (paramInt == 1)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 4L, 1L, false);
        if (i == 0)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 5L, 1L, false);
        }
        else
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 6L, 1L, false);
          continue;
          label508:
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 9L, 1L, false);
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(j) + 10L, 1L + l, false);
        }
      }
    }
  }
  
  public void a(int paramInt, asg paramasg)
  {
    d.g.b.p.h(paramasg, "serverConfig");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[performServerConfigChanged] fromTabType=").append(paramInt).append(" serverConfig=");
    d.g.b.p.h(paramasg, "$this$print");
    ae.i(str, new StringBuilder("[").append(paramasg.GIP).append(", ").append(paramasg.GIQ).append(", ").append(paramasg.GIR).append(", ").append(paramasg.GIS).append(", ").append(paramasg.GIT).append(", ").append(paramasg.GIU).append(", ").append(paramasg.GIV).append(", ").append(paramasg.GIW).append(", ").append(paramasg.GIX).append(", ").append(paramasg.GIY).append(", ").append(paramasg.GIZ).append(", ").append(paramasg.GJa).append(", ").append(paramasg.GJb).append(", ").append(paramasg.GJc).append(", ").append(paramasg.GJd).append(", ").append(paramasg.GJe).append(", ").append(paramasg.GJf).append(']').toString());
  }
  
  public void a(final c paramc, final d.g.a.b<? super d, z> paramb)
  {
    d.g.b.p.h(paramc, "source");
    d.g.b.p.h(paramb, "call");
    if (this.isLoading)
    {
      ae.w(this.TAG, "isLoading=true");
      paramb.invoke(d.svi);
      return;
    }
    if (!FinderStreamTabPreloadCore.isEnable())
    {
      ae.w(this.TAG, "isEnable=false source=".concat(String.valueOf(paramc)));
      paramb.invoke(d.svj);
      return;
    }
    if (!a(this, paramc))
    {
      ae.w(this.TAG, "isValid=false source=".concat(String.valueOf(paramc)));
      paramb.invoke(d.svk);
      return;
    }
    this.cQj.lock();
    try
    {
      this.isLoading = true;
      if (paramc == c.svc) {
        break label581;
      }
      if (paramc != c.sve) {
        break label254;
      }
    }
    finally
    {
      this.cQj.unlock();
    }
    if (this.suU.suW != null) {}
    for (final boolean bool = true;; bool = false)
    {
      Object localObject1 = this.suU.suW;
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((m.f)localObject1).lastBuffer;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = (f)this;
        localObject2 = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA();
        localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject1 = ((aj)localObject2).get(com.tencent.mm.plugin.finder.utils.p.Gr(((f)localObject1).dvm), "");
        if (localObject1 == null)
        {
          throw new v("null cannot be cast to non-null type kotlin.String");
          label254:
          if (paramc == c.svd)
          {
            i = 7;
            break;
          }
          if (paramc == c.svf)
          {
            i = 5;
            break;
          }
          if (paramc != c.svg) {
            break label587;
          }
          i = 8;
          break;
        }
        localObject1 = com.tencent.mm.bw.b.cm(bu.aSx((String)localObject1));
      }
      for (;;)
      {
        localObject2 = this.suU.suW;
        Object localObject4;
        StringBuilder localStringBuilder;
        if (localObject2 != null)
        {
          localObject2 = ((m.f)localObject2).object;
          if (localObject2 != null)
          {
            localObject2 = new LinkedList((Collection)localObject2);
            lX(true);
            localObject3 = new arn();
            localObject4 = i.syT;
            ((arn)localObject3).sch = i.Fw(this.dvm);
            localObject4 = this.TAG;
            localStringBuilder = new StringBuilder("[preload] tabType=").append(this.dvm).append(", hasCache=").append(bool).append(", consumeFlag=");
            if (!bool) {
              break label572;
            }
          }
        }
        label572:
        for (int j = 0;; j = 1)
        {
          ae.i((String)localObject4, j + ", unread list size=" + ((LinkedList)localObject2).size() + ", pullType=" + i + ", source=" + paramc + ", cache=" + this.suU);
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1421L, Fa(this.dvm) + 11L, 1L, false);
          new m(this.dvm, i, (com.tencent.mm.bw.b)localObject1, (arn)localObject3, (List)localObject2).a(null, (m.b)new f(this, bool, paramc, paramb), true);
          this.cQj.unlock();
          return;
          localObject2 = new LinkedList();
          break;
        }
      }
      label581:
      int i = 6;
      break;
      label587:
      i = 6;
      break;
    }
  }
  
  public boolean a(c paramc, m.f paramf)
  {
    d.g.b.p.h(paramc, "source");
    d.g.b.p.h(paramf, "resp");
    return true;
  }
  
  public boolean a(c paramc, String paramString)
  {
    d.g.b.p.h(paramc, "source");
    d.g.b.p.h(paramString, "log");
    ae.i(this.TAG, "[isValid] isInFindMoreFriendTab=" + this.suQ + " isBackground=" + this.suP + " isInFinder=" + this.suN + " source=" + paramc + ' ' + paramString);
    if ((paramc == c.svc) || (paramc == c.svg) || (paramc == c.sve)) {
      if ((this.suN) || (!this.suQ.get()) || (this.suP.get())) {}
    }
    while ((this.suN) && (this.suQ.get()) && (!this.suP.get()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public c cES()
  {
    return c.sve;
  }
  
  public long cET()
  {
    com.tencent.mm.plugin.finder.extension.reddot.e locale = getRedDotManager();
    getRedDotManager();
    if (locale.aii(com.tencent.mm.plugin.finder.extension.reddot.e.EE(this.dvm)) != null) {}
    for (boolean bool = true;; bool = false) {
      return FinderStreamTabPreloadCore.ag(this.dvm, bool);
    }
  }
  
  public void fI(int paramInt1, int paramInt2)
  {
    ae.i(this.TAG, "[performChangeEnterTargetTab] lastTab=" + paramInt1 + " targetTab=" + paramInt2);
  }
  
  public final boolean lX(boolean paramBoolean)
  {
    this.cQj.lock();
    boolean bool;
    for (;;)
    {
      try
      {
        if (this.suU.suW != null)
        {
          bool = true;
          if (!paramBoolean) {
            break label350;
          }
          LinkedList localLinkedList = new LinkedList();
          localObject2 = this.suU.suW;
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
          Object localObject4 = FinderItem.sJb;
          d.g.b.p.g(localObject3, "it");
          localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, com.tencent.mm.plugin.finder.utils.p.Gs(this.dvm));
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          localLinkedList.add(b.a.j((FinderItem)localObject3));
          continue;
        }
        bool = false;
      }
      finally
      {
        this.cQj.unlock();
      }
    }
    Object localObject2 = this.suU.suW;
    if (localObject2 != null)
    {
      localObject2 = ((m.f)localObject2).object;
      if (localObject2 != null)
      {
        this.suU.suY.addAll((Collection)localObject2);
        localObject2 = this.suU;
        ((a)localObject2).suZ += 1L;
      }
    }
    localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
    int i = this.dvm;
    List localList = (List)localObject1;
    localObject2 = new arn();
    Object localObject3 = i.syT;
    ((arn)localObject2).sch = i.Fw(this.dvm);
    com.tencent.mm.plugin.finder.utils.p.a(i, localList, (arn)localObject2);
    for (;;)
    {
      if (bool) {
        ae.i(this.TAG, "[clear] tabType=" + this.dvm + " cache=" + this.suU + " isRecycle=" + paramBoolean);
      }
      this.suU.suW = null;
      this.suU.suX = null;
      this.cQj.unlock();
      return bool;
      label350:
      this.suU.suZ = 0L;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;I)V", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "overCount", "getOverCount", "setOverCount", "records", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "recycledList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRecycledList", "()Ljava/util/LinkedList;", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "getResp", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setResp", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;)V", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getSource", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "setSource", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;)V", "getTabType", "()I", "restoreTime", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshPreloadCacheList;", "storeTime", "", "toString", "", "print", "tag", "plugin-finder_release"})
  public final class a
  {
    final int dvm;
    long hiI;
    m.f suW;
    f.c suX;
    final LinkedList<FinderObject> suY;
    long suZ;
    final ConcurrentHashMap<Integer, f.b> sva;
    
    public a()
    {
      AppMethodBeat.i(203580);
      int i;
      this.dvm = i;
      this.suY = new LinkedList();
      this.sva = new ConcurrentHashMap();
      this$1 = cEU();
      Object localObject1 = f.this.GIj;
      d.g.b.p.g(localObject1, "refreshPreloadCacheList.caches");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((arl)localObject3).dvm == this.dvm) {}
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
        localObject2 = (arl)((Iterator)localObject1).next();
        ((Map)this.sva).put(Integer.valueOf(((arl)localObject2).doj), new f.b(((arl)localObject2).iap));
      }
      a(f.this, "build");
      AppMethodBeat.o(203580);
    }
    
    public final void a(arm paramarm, String paramString)
    {
      AppMethodBeat.i(203579);
      d.g.b.p.h(paramarm, "$this$print");
      d.g.b.p.h(paramString, "tag");
      String str = f.this.TAG;
      paramString = new StringBuilder("[FinderRefreshPreloadCacheList#print] tag=").append(paramString).append(' ');
      paramarm = paramarm.GIj;
      d.g.b.p.g(paramarm, "this.caches");
      Object localObject1 = (Iterable)paramarm;
      paramarm = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      label137:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((arl)localObject2).dvm == this.dvm) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label137;
          }
          paramarm.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)paramarm;
      paramarm = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (arl)((Iterator)localObject1).next();
        paramarm.add(((arl)localObject2).dvm + ':' + ((arl)localObject2).doj + "=>" + ((arl)localObject2).iap);
      }
      ae.i(str, (List)paramarm);
      AppMethodBeat.o(203579);
    }
    
    final arm cEU()
    {
      AppMethodBeat.i(203578);
      Object localObject1 = new arm();
      Object localObject2 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA().get(am.a.Jcd, "");
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(203578);
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
          ((arm)localObject1).parseFrom(bu.aSx((String)localObject2));
          AppMethodBeat.o(203578);
          return localObject1;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace(f.this.TAG, (Throwable)localException, "", new Object[0]);
            com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
            d.g.b.p.g(locale, "MMKernel.storage()");
            locale.ajA().set(am.a.Jcd, null);
          }
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203577);
      Object localObject2 = new StringBuilder("[").append(this.suX).append(", resp=");
      Object localObject1 = this.suW;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((m.f)localObject1).hashCode());; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", lastTime=").append(this.hiI).append(", overCount=").append(this.suZ).append(", recycledList=");
        Object localObject3 = (Iterable)this.suY;
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(com.tencent.mm.ac.c.rp(((FinderObject)((Iterator)localObject3).next()).id));
        }
      }
      localObject1 = (List)localObject2 + ']';
      AppMethodBeat.o(203577);
      return localObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OutSideRedDot", "InsideRedDot", "OutSideTimeout", "InsideConfigNotify", "OutSideJumpHot", "plugin-finder_release"})
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(203582);
      c localc1 = new c("OutSideRedDot", 0, 1);
      svc = localc1;
      c localc2 = new c("InsideRedDot", 1, 2);
      svd = localc2;
      c localc3 = new c("OutSideTimeout", 2, 3);
      sve = localc3;
      c localc4 = new c("InsideConfigNotify", 3, 4);
      svf = localc4;
      c localc5 = new c("OutSideJumpHot", 4, 5);
      svg = localc5;
      svh = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(203582);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "", "(Ljava/lang/String;I)V", "LOADING", "DISABLE", "INVALID", "OK", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(203585);
      d locald1 = new d("LOADING", 0);
      svi = locald1;
      d locald2 = new d("DISABLE", 1);
      svj = locald2;
      d locald3 = new d("INVALID", 2);
      svk = locald3;
      d locald4 = new d("OK", 3);
      svl = locald4;
      svm = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(203585);
    }
    
    private d() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$outSideTimeoutRunnable$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
  public static final class e
    extends a.a
  {
    public final void run()
    {
      AppMethodBeat.i(203589);
      ae.i(this.svb.TAG, "outSideTimeoutRunnable run... isInFinder=" + this.svb.suN);
      if (!this.svb.suN) {
        this.svb.a(this.svb.cES(), (d.g.a.b)new a(this));
      }
      AppMethodBeat.o(203589);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<f.d, z>
    {
      a(f.e parame)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$preload$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class f
    implements m.b
  {
    f(boolean paramBoolean, f.c paramc, d.g.a.b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, m.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> paramList)
    {
      paramString = null;
      AppMethodBeat.i(203592);
      d.g.b.p.h(paramf, "resp");
      d.g.b.p.h(paramList, "interceptors");
      this.svb.cQj.lock();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        try
        {
          this.svb.suU.suY.clear();
          Object localObject1;
          if (!this.svb.a(paramc, paramf))
          {
            ae.i(this.svb.TAG, "[onCgiBack] tabType=" + this.svb.dvm + " throw this preload, size=" + paramf.object.size() + " cache=" + this.svb.suU);
            f.b(this.svb, paramc);
            paramb.invoke(f.d.svl);
            if (paramf.GJx != null)
            {
              paramString = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramString, "MMKernel.storage()");
              paramList = paramString.ajA();
              localObject1 = am.a.Jcc;
              paramString = paramf.GJx;
              if (paramString == null) {
                break label842;
              }
              paramString = paramString.toByteArray();
              paramList.set((am.a)localObject1, bu.cH(paramString));
              this.svb.a(this.svb.dvm, FinderStreamTabPreloadCore.cER());
            }
            this.svb.isLoading = false;
            this.svb.cQk.signalAll();
            this.svb.cQj.unlock();
            AppMethodBeat.o(203592);
            return;
          }
          Object localObject2;
          if (!paramf.object.isEmpty())
          {
            localObject1 = this.svb;
            paramList = paramc;
            ((f)localObject1).suU.suW = paramf;
            localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (com.tencent.mm.plugin.finder.storage.b.cIG())
            {
              localObject2 = paramf.object;
              d.g.b.p.g(localObject2, "resp.`object`");
              localObject2 = (FinderObject)j.jm((List)localObject2);
              if (localObject2 != null)
              {
                Object localObject3 = FinderItem.sJb;
                localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
                localObject2 = FinderItem.a.a((FinderObject)localObject2, com.tencent.mm.plugin.finder.utils.p.Gs(((f)localObject1).dvm));
                localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
                localObject2 = b.a.j((FinderItem)localObject2);
                localObject3 = new LinkedList();
                ((LinkedList)localObject3).addAll((Collection)((BaseFinderFeed)localObject2).feedObject.getMediaList());
                localObject3 = new o(localObject2, j.s((Collection)localObject3));
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(localObject3);
                ((com.tencent.mm.plugin.finder.preload.worker.b)((f)localObject1).suT.getValue()).a((BaseFinderFeed)localObject2, j.s((Collection)localLinkedList), 0);
              }
            }
            localObject1 = MediaPreloadCore.stL;
            if (MediaPreloadCore.cEO())
            {
              localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
              if (com.tencent.mm.plugin.finder.storage.b.cIG()) {
                com.tencent.mm.ac.c.h((d.g.a.a)new f.i(paramList));
              }
            }
            ae.i(this.svb.TAG, "[onCgiBack] tabType=" + this.svb.dvm + " preload successfully! size=" + paramf.object.size() + " cache=" + this.svb.suU);
            continue;
          }
          ae.e(this.svb.TAG, "[onCgiBack] tabType=" + this.svb.dvm + " preload fail! list is empty! cache=" + this.svb.suU);
        }
        finally
        {
          f.b(this.svb, paramc);
          paramb.invoke(f.d.svl);
          if (paramf.GJx != null)
          {
            localObject1 = com.tencent.mm.kernel.g.ajR();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajA();
            localObject2 = am.a.Jcc;
            paramf = paramf.GJx;
            if (paramf != null) {
              paramString = paramf.toByteArray();
            }
            ((aj)localObject1).set((am.a)localObject2, bu.cH(paramString));
            this.svb.a(this.svb.dvm, FinderStreamTabPreloadCore.cER());
          }
          this.svb.isLoading = false;
          this.svb.cQk.signalAll();
          this.svb.cQj.unlock();
          AppMethodBeat.o(203592);
        }
        continue;
        this.svb.lX(true);
        ae.e(this.svb.TAG, "[onCgiBack] tabType=" + this.svb.dvm + " preload fail! errType=" + paramInt1 + " errCode=" + paramInt2 + " cache=" + this.svb.suU);
        continue;
        label842:
        paramString = null;
      }
    }
    
    public final void a(ash paramash)
    {
      AppMethodBeat.i(203591);
      d.g.b.p.h(paramash, "request");
      if (bool)
      {
        paramash.GJg = 0;
        AppMethodBeat.o(203591);
        return;
      }
      paramash.GJg = 1;
      AppMethodBeat.o(203591);
    }
    
    public final boolean a(cwj paramcwj)
    {
      AppMethodBeat.i(203590);
      d.g.b.p.h(paramcwj, "resp");
      AppMethodBeat.o(203590);
      return false;
    }
    
    public final boolean czx()
    {
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    g(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.extension.reddot.e>
  {
    public static final h svq;
    
    static
    {
      AppMethodBeat.i(203595);
      svq = new h();
      AppMethodBeat.o(203595);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.f
 * JD-Core Version:    0.7.0.1
 */