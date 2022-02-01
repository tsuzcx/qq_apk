package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.cgi.aa.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.j.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "", "tabType", "", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(ILcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "getCache", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getCore", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "isBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isInFindMoreFriendTab", "isInFinder", "", "()Z", "setInFinder", "(Z)V", "isLoading", "setLoading", "lastExitFindMoreFriendTab", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "outSideTimeoutRunnable", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "getOutSideTimeoutRunnable", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "getTabType", "()I", "timer", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "getTimer", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "clear", "isRecycle", "getNextTime", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "getPullType", "source", "getReportKey", "isAcceptCgiBack", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "performBackground", "", "performChangeEnterTargetTab", "lastTab", "targetTab", "performEnterFindMoreFriendTab", "performEnterFinder", "performEnterFinderLoad", "intent", "Landroid/content/Intent;", "performExitFindMoreFriendTab", "performExitFinder", "performForeground", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "report", "isHasCache", "pullType", "overCount", "requestCache", "setCache", "updateCacheStatus", "print", "Cache", "CacheTime", "PreloadSource", "Ret", "plugin-finder_release"})
public abstract class g
{
  public final String TAG;
  final ReentrantLock eYl;
  final Condition eYm;
  public final int fEH;
  volatile boolean isLoading;
  final kotlin.f xoT;
  long zLr;
  public boolean zLs;
  public final a zLt;
  final AtomicBoolean zLu;
  public final AtomicBoolean zLv;
  private final kotlin.f zLw;
  public final a.a zLx;
  public final a zLy;
  public final c zLz;
  
  public g(int paramInt, c paramc)
  {
    this.fEH = paramInt;
    this.zLz = paramc;
    this.TAG = ("Finder.TabPreloadWorker#" + this.fEH);
    this.zLt = new a(this.TAG);
    this.zLu = new AtomicBoolean(true);
    this.zLv = new AtomicBoolean(false);
    this.zLw = kotlin.g.ar((kotlin.g.a.a)i.zLU);
    this.zLx = ((a.a)new e(this));
    this.xoT = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.eYl = new ReentrantLock();
    this.eYm = this.eYl.newCondition();
    this.zLy = new a(this.fEH);
  }
  
  private static long OR(int paramInt)
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
  
  public final com.tencent.mm.plugin.finder.cgi.aa.f OQ(int paramInt)
  {
    Object localObject1 = this.TAG;
    Object localObject4 = new StringBuilder("[request] scene=").append(this.fEH).append(", isPreloading:").append(this.isLoading).append(" cache=").append(this.zLy).append(" isLocked=").append(this.eYl.isLocked()).append(" fakeWaitForRefresh=");
    Object localObject5 = com.tencent.mm.plugin.finder.storage.d.AjH;
    Log.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue() + "ms ");
    this.eYl.lock();
    label707:
    label712:
    label850:
    for (;;)
    {
      long l;
      int j;
      try
      {
        if (this.isLoading)
        {
          l = SystemClock.uptimeMillis();
          this.eYm.await(1L, TimeUnit.MINUTES);
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          l = ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue() - (SystemClock.uptimeMillis() - l);
          Log.i(this.TAG, "requestCache: loading delay = ".concat(String.valueOf(l)));
          if (l > 0L) {
            this.eYm.await(l, TimeUnit.MILLISECONDS);
          }
          this.eYl.unlock();
          localObject4 = new kotlin.g.b.aa.f();
          ((kotlin.g.b.aa.f)localObject4).aaBC = this.zLy.zLA;
          if (this.zLy.zLB == c.zLL)
          {
            i = 1;
            if (i == 0)
            {
              localObject1 = (com.tencent.mm.plugin.finder.cgi.aa.f)((kotlin.g.b.aa.f)localObject4).aaBC;
              if (localObject1 != null)
              {
                localObject5 = com.tencent.mm.ui.component.g.Xox;
                localObject5 = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.f.class);
                p.j(localObject5, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
                localObject5 = (com.tencent.mm.plugin.finder.viewmodel.f)localObject5;
                LinkedList localLinkedList = ((com.tencent.mm.plugin.finder.cgi.aa.f)localObject1).object;
                p.j(localLinkedList, "it.`object`");
                com.tencent.mm.ae.d.a(localLinkedList, (kotlin.g.a.b)new j((com.tencent.mm.plugin.finder.viewmodel.f)localObject5, this, (kotlin.g.b.aa.f)localObject4));
                i = ((com.tencent.mm.plugin.finder.cgi.aa.f)localObject1).object.size();
                localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
                if (i < ((Number)com.tencent.mm.plugin.finder.storage.d.dTS().aSr()).intValue())
                {
                  Log.w(this.TAG, "requestCache: cache after filter read feed is less than 3, abandon it");
                  pV(true);
                  ((kotlin.g.b.aa.f)localObject4).aaBC = null;
                }
              }
              if ((com.tencent.mm.plugin.finder.cgi.aa.f)((kotlin.g.b.aa.f)localObject4).aaBC == null) {
                break label707;
              }
              i = 1;
              j = this.fEH;
              l = this.zLy.zLD;
              if (paramInt != 0) {
                break label734;
              }
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 1L, 1L, false);
              if (i != 0) {
                break label712;
              }
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 2L, 1L, false);
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 7L, 1L, false);
              if (i != 0) {
                break label806;
              }
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 8L, 1L, false);
              if ((com.tencent.mm.plugin.finder.cgi.aa.f)((kotlin.g.b.aa.f)localObject4).aaBC != null)
              {
                paramInt = this.zLy.fEH;
                localObject1 = (com.tencent.mm.plugin.finder.cgi.aa.f)((kotlin.g.b.aa.f)localObject4).aaBC;
                if (localObject1 == null) {
                  break label850;
                }
                localObject1 = ((com.tencent.mm.plugin.finder.cgi.aa.f)localObject1).lastBuffer;
                new com.tencent.mm.plugin.finder.cgi.h(paramInt, (com.tencent.mm.cd.b)localObject1).bhW();
                localObject1 = b.zLe;
                b.c(0, 2, 0, false, 123);
              }
            }
            pV(false);
            return (com.tencent.mm.plugin.finder.cgi.aa.f)((kotlin.g.b.aa.f)localObject4).aaBC;
          }
        }
        else
        {
          if (this.zLy.zLA == null) {
            continue;
          }
          localObject1 = this.TAG;
          localObject4 = new StringBuilder("requestCache: force wait ");
          localObject5 = com.tencent.mm.plugin.finder.storage.d.AjH;
          Log.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue() + "ms");
          localObject1 = this.eYm;
          localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
          ((Condition)localObject1).await(((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue(), TimeUnit.MILLISECONDS);
          continue;
        }
        i = 0;
      }
      finally
      {
        this.eYl.unlock();
      }
      continue;
      int i = 0;
      continue;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 3L, 1L, false);
      continue;
      label734:
      if (paramInt == 1)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 4L, 1L, false);
        if (i == 0)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 5L, 1L, false);
        }
        else
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 6L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 9L, 1L, false);
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(j) + 10L, 1L + l, false);
          continue;
          Object localObject3 = null;
        }
      }
    }
  }
  
  public void a(int paramInt, bju parambju)
  {
    p.k(parambju, "serverConfig");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[performServerConfigChanged] fromTabType=").append(paramInt).append(" serverConfig=");
    p.k(parambju, "$this$print");
    Log.i(str, new StringBuilder("[").append(parambju.SUb).append(", ").append(parambju.SUc).append(", ").append(parambju.SUd).append(", ").append(parambju.SUe).append(", ").append(parambju.SUf).append(", ").append(parambju.SUg).append(", ").append(parambju.SUh).append(", ").append(parambju.SUi).append(", ").append(parambju.SUj).append(", ").append(parambju.SUk).append(", ").append(parambju.SUl).append(", ").append(parambju.SUm).append(", ").append(parambju.SUn).append(", ").append(parambju.SUo).append(", ").append(parambju.SUp).append(", ").append(parambju.SUq).append(", ").append(parambju.SUr).append(']').toString());
  }
  
  public void a(final c paramc, Intent paramIntent, final kotlin.g.a.b<? super d, x> paramb)
  {
    p.k(paramc, "source");
    p.k(paramb, "call");
    if (this.isLoading)
    {
      Log.w(this.TAG, "isLoading=true");
      paramb.invoke(d.zLN);
      return;
    }
    if (!c.a(paramc))
    {
      Log.w(this.TAG, "isEnable=false source=".concat(String.valueOf(paramc)));
      paramb.invoke(d.zLO);
      return;
    }
    if (!a(this, paramc))
    {
      Log.w(this.TAG, "isValid=false source=".concat(String.valueOf(paramc)));
      paramb.invoke(d.zLP);
      return;
    }
    this.eYl.lock();
    final boolean bool;
    label155:
    Object localObject3;
    label256:
    final int i;
    label323:
    long l;
    label611:
    int j;
    for (;;)
    {
      try
      {
        this.isLoading = true;
        if (paramc == c.zLG) {
          break label1109;
        }
        if (paramc != c.zLI) {
          break label256;
        }
      }
      finally
      {
        this.eYl.unlock();
      }
      if (this.zLy.zLA == null) {
        break label1123;
      }
      bool = true;
      Object localObject1 = this.zLy.zLA;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.cgi.aa.f)localObject1).lastBuffer;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = (g)this;
        Object localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp();
        localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = ((ao)localObject2).get(com.tencent.mm.plugin.finder.utils.aj.QX(((g)localObject1).fEH), "");
        if (localObject1 == null)
        {
          throw new t("null cannot be cast to non-null type kotlin.String");
          if (paramc == c.zLH)
          {
            i = 7;
            continue;
          }
          if (paramc == c.zLJ)
          {
            i = 5;
            continue;
          }
          if (paramc == c.zLK)
          {
            i = 8;
            continue;
          }
          if (paramc != c.zLL) {
            break label1116;
          }
          i = 0;
          continue;
        }
        localObject1 = com.tencent.mm.cd.b.cU(Util.decodeHexString((String)localObject1));
        localObject2 = this.zLy.zLA;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.cgi.aa.f)localObject2).object;
          if (localObject2 != null) {
            localObject2 = new LinkedList((Collection)localObject2);
          }
        }
        Object localObject4;
        while ((i == 0) && ((this.fEH == 1) || (this.fEH == 3)))
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject4 = com.tencent.mm.plugin.finder.feed.model.internal.g.xKI;
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.a(com.tencent.mm.plugin.finder.utils.aj.a((com.tencent.mm.plugin.finder.utils.aj)localObject3, com.tencent.mm.plugin.finder.feed.model.internal.g.a.MG(this.fEH).value, null, 0, true, this.fEH, 6), BaseFinderFeed.class);
          localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject4 = (Iterable)com.tencent.mm.plugin.finder.utils.aj.t((List)localObject3, this.fEH);
          localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              ((Collection)localObject3).add(((BaseFinderFeed)((Iterator)localObject4).next()).feedObject.getFeedObject());
              continue;
              localObject2 = new LinkedList();
              break;
            }
          }
          ((LinkedList)localObject2).addAll((Collection)localObject3);
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("[preload] tabType=").append(this.fEH).append(", unreadList=").append(((LinkedList)localObject2).size()).append(" first=");
          localObject5 = (FinderObject)kotlin.a.j.lr((List)localObject2);
          if (localObject5 == null) {
            break label1083;
          }
          l = ((FinderObject)localObject5).id;
          Log.i((String)localObject3, com.tencent.mm.ae.d.Fw(l));
        }
        if ((pV(true)) && (paramc != c.zLL))
        {
          localObject3 = b.zLe;
          b.c(0, 3, 2, false, 115);
        }
        Object localObject5 = new bid();
        localObject3 = n.zWF;
        ((bid)localObject5).xkX = n.Pz(this.fEH);
        if (paramc == c.zLL)
        {
          localObject3 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          ((bid)localObject5).wmz = aj.a.Sa(this.fEH);
          if (paramIntent != null)
          {
            localObject4 = paramIntent.getStringExtra("key_context_id");
            localObject3 = localObject4;
            if (localObject4 != null) {}
          }
          else
          {
            localObject3 = n.zWF;
            localObject3 = n.dPD();
          }
          ((bid)localObject5).wmL = ((String)localObject3);
          localObject4 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          ((bid)localObject5).sessionId = ((String)localObject3);
          if (paramIntent == null) {
            break label1129;
          }
          localObject4 = paramIntent.getStringExtra("key_extra_info");
          localObject3 = localObject4;
          if (localObject4 == null) {
            break label1129;
          }
          label809:
          ((bid)localObject5).extraInfo = ((String)localObject3);
          if (paramIntent == null) {
            break label1137;
          }
          localObject3 = paramIntent.getStringExtra("key_enter_source_info");
          paramIntent = (Intent)localObject3;
          if (localObject3 == null) {
            break label1137;
          }
          label840:
          ((bid)localObject5).wmC = paramIntent;
        }
        paramIntent = this.TAG;
        localObject3 = new StringBuilder("[preload] tabType=").append(this.fEH).append(", hasCache=").append(bool).append(", consumeFlag=");
        if (bool)
        {
          j = 0;
          label895:
          Log.i(paramIntent, j + ", unread list size=" + ((LinkedList)localObject2).size() + ", pullType=" + i + ", source=" + paramc + ", cache=" + this.zLy);
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1421L, OR(this.fEH) + 11L, 1L, false);
          new aa(this.fEH, i, (com.tencent.mm.cd.b)localObject1, (bid)localObject5, (List)localObject2, true).a(null, (aa.b)new g(this, bool, paramc, i, paramb));
          if (paramc == c.zLL)
          {
            paramc = com.tencent.mm.plugin.finder.report.j.zVy;
            paramc = com.tencent.mm.plugin.finder.report.j.Ph(this.fEH);
            if (paramc != null)
            {
              if ((!paramc.gX) || (paramc.zVz)) {
                break label1095;
              }
              i = 1;
              break label1144;
            }
          }
        }
      }
    }
    for (;;)
    {
      label1066:
      if (paramc != null) {
        paramc.zWl = 1;
      }
      this.eYl.unlock();
      return;
      label1083:
      l = 0L;
      break label611;
      j = 1;
      break label895;
      label1095:
      i = 0;
      label1109:
      label1116:
      label1123:
      label1129:
      label1137:
      label1144:
      while (i == 0)
      {
        paramc = null;
        break label1066;
        break label323;
        i = 6;
        break;
        i = 6;
        break;
        bool = false;
        break label155;
        localObject3 = "";
        break label809;
        paramIntent = "";
        break label840;
      }
    }
  }
  
  public boolean a(c paramc, com.tencent.mm.plugin.finder.cgi.aa.f paramf)
  {
    p.k(paramc, "source");
    p.k(paramf, "resp");
    return true;
  }
  
  public boolean a(c paramc, String paramString)
  {
    p.k(paramc, "source");
    p.k(paramString, "log");
    Log.i(this.TAG, "[isValid] isInFindMoreFriendTab=" + this.zLv + " isBackground=" + this.zLu + " isInFinder=" + this.zLs + " source=" + paramc + ' ' + paramString);
    if ((paramc == c.zLG) || (paramc == c.zLK) || (paramc == c.zLI) || (paramc == c.zLL)) {
      if ((this.zLs) || (!this.zLv.get()) || (this.zLu.get())) {}
    }
    while ((this.zLs) && (this.zLv.get()) && (!this.zLu.get()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public c dML()
  {
    return c.zLI;
  }
  
  public long dMM()
  {
    com.tencent.mm.plugin.finder.extension.reddot.f localf = getRedDotManager();
    getRedDotManager();
    if (localf.aBe(com.tencent.mm.plugin.finder.extension.reddot.f.Mo(this.fEH)) != null) {}
    for (boolean bool = true;; bool = false) {
      return c.an(this.fEH, bool);
    }
  }
  
  public final long dMN()
  {
    long l = dMM();
    if (c.dMK())
    {
      if (this.zLy.kje <= 0L) {
        return 0L;
      }
      return l - (cm.bfE() - this.zLy.kje);
    }
    return l;
  }
  
  public void gO(int paramInt1, int paramInt2)
  {
    Log.i(this.TAG, "[performChangeEnterTargetTab] lastTab=" + paramInt1 + " targetTab=" + paramInt2);
  }
  
  final com.tencent.mm.plugin.finder.extension.reddot.f getRedDotManager()
  {
    return (com.tencent.mm.plugin.finder.extension.reddot.f)this.zLw.getValue();
  }
  
  public final boolean pV(boolean paramBoolean)
  {
    this.eYl.lock();
    boolean bool;
    for (;;)
    {
      try
      {
        if (this.zLy.zLA != null)
        {
          bool = true;
          if (!paramBoolean) {
            break label350;
          }
          LinkedList localLinkedList = new LinkedList();
          localObject2 = this.zLy.zLA;
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.cgi.aa.f)localObject2).object;
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.Companion;
          p.j(localObject3, "it");
          localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject3 = FinderItem.a.b((FinderObject)localObject3, com.tencent.mm.plugin.finder.utils.aj.QY(this.fEH));
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          localLinkedList.add(c.a.a((FinderItem)localObject3));
          continue;
        }
        bool = false;
      }
      finally
      {
        this.eYl.unlock();
      }
    }
    Object localObject2 = this.zLy.zLA;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.cgi.aa.f)localObject2).object;
      if (localObject2 != null)
      {
        this.zLy.zLC.addAll((Collection)localObject2);
        localObject2 = this.zLy;
        ((a)localObject2).zLD += 1L;
      }
    }
    localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    int i = this.fEH;
    List localList = (List)localObject1;
    localObject2 = new bid();
    Object localObject3 = n.zWF;
    ((bid)localObject2).xkX = n.Pz(this.fEH);
    com.tencent.mm.plugin.finder.utils.aj.a(i, localList, (bid)localObject2);
    for (;;)
    {
      if (bool) {
        Log.i(this.TAG, "[clear] tabType=" + this.fEH + " cache=" + this.zLy + " isRecycle=" + paramBoolean);
      }
      this.zLy.zLA = null;
      this.zLy.zLB = null;
      this.eYl.unlock();
      return bool;
      label350:
      this.zLy.zLD = 0L;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;I)V", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "overCount", "getOverCount", "setOverCount", "records", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "recycledList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRecycledList", "()Ljava/util/LinkedList;", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "getResp", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setResp", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;)V", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getSource", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "setSource", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;)V", "getTabType", "()I", "restoreTime", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshPreloadCacheList;", "storeTime", "", "toString", "", "print", "tag", "plugin-finder_release"})
  public final class a
  {
    final int fEH;
    long kje;
    public com.tencent.mm.plugin.finder.cgi.aa.f zLA;
    g.c zLB;
    final LinkedList<FinderObject> zLC;
    long zLD;
    final ConcurrentHashMap<Integer, g.b> zLE;
    
    public a()
    {
      AppMethodBeat.i(285171);
      int i;
      this.fEH = i;
      this.zLC = new LinkedList();
      this.zLE = new ConcurrentHashMap();
      this$1 = dMO();
      Object localObject1 = g.this.SSB;
      p.j(localObject1, "refreshPreloadCacheList.caches");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((bhy)localObject3).fEH == this.fEH) {}
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
        localObject2 = (bhy)((Iterator)localObject1).next();
        ((Map)this.zLE).put(Integer.valueOf(((bhy)localObject2).source), new g.b(((bhy)localObject2).lLH));
      }
      a(g.this, "build");
      AppMethodBeat.o(285171);
    }
    
    public final void a(bhz parambhz, String paramString)
    {
      AppMethodBeat.i(285170);
      p.k(parambhz, "$this$print");
      p.k(paramString, "tag");
      String str = g.this.TAG;
      paramString = new StringBuilder("[FinderRefreshPreloadCacheList#print] tag=").append(paramString).append(' ');
      parambhz = parambhz.SSB;
      p.j(parambhz, "this.caches");
      Object localObject1 = (Iterable)parambhz;
      parambhz = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      label137:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((bhy)localObject2).fEH == this.fEH) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label137;
          }
          parambhz.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)parambhz;
      parambhz = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bhy)((Iterator)localObject1).next();
        parambhz.add(((bhy)localObject2).fEH + ':' + ((bhy)localObject2).source + "=>" + ((bhy)localObject2).lLH);
      }
      Log.i(str, (List)parambhz);
      AppMethodBeat.o(285170);
    }
    
    final bhz dMO()
    {
      AppMethodBeat.i(285169);
      Object localObject1 = new bhz();
      Object localObject2 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.VzZ, "");
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(285169);
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
          ((bhz)localObject1).parseFrom(Util.decodeHexString((String)localObject2));
          AppMethodBeat.o(285169);
          return localObject1;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace(g.this.TAG, (Throwable)localException, "", new Object[0]);
            com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
            p.j(localf, "MMKernel.storage()");
            localf.aHp().set(ar.a.VzZ, null);
          }
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(285168);
      Object localObject2 = new StringBuilder("[").append(this.zLB).append(", resp=");
      Object localObject1 = this.zLA;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.aa.f)localObject1).hashCode());; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", lastTime=").append(this.kje).append(", overCount=").append(this.zLD).append(", recycledList=");
        Object localObject3 = (Iterable)this.zLC;
        localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(com.tencent.mm.ae.d.Fw(((FinderObject)((Iterator)localObject3).next()).id));
        }
      }
      localObject1 = (List)localObject2 + ']';
      AppMethodBeat.o(285168);
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "", "lastTime", "", "(J)V", "getLastTime", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    private final long kje;
    
    public b(long paramLong)
    {
      this.kje = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (this.kje != paramObject.kje) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.kje;
      return (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(262089);
      String str = "CacheTime(lastTime=" + this.kje + ")";
      AppMethodBeat.o(262089);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OutSideRedDot", "InsideRedDot", "OutSideTimeout", "InsideConfigNotify", "OutSideJumpHot", "EnterLoad", "plugin-finder_release"})
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(273541);
      c localc1 = new c("OutSideRedDot", 0, 1);
      zLG = localc1;
      c localc2 = new c("InsideRedDot", 1, 2);
      zLH = localc2;
      c localc3 = new c("OutSideTimeout", 2, 3);
      zLI = localc3;
      c localc4 = new c("InsideConfigNotify", 3, 4);
      zLJ = localc4;
      c localc5 = new c("OutSideJumpHot", 4, 5);
      zLK = localc5;
      c localc6 = new c("EnterLoad", 5, 6);
      zLL = localc6;
      zLM = new c[] { localc1, localc2, localc3, localc4, localc5, localc6 };
      AppMethodBeat.o(273541);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "", "(Ljava/lang/String;I)V", "LOADING", "DISABLE", "INVALID", "OK", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(268495);
      d locald1 = new d("LOADING", 0);
      zLN = locald1;
      d locald2 = new d("DISABLE", 1);
      zLO = locald2;
      d locald3 = new d("INVALID", 2);
      zLP = locald3;
      d locald4 = new d("OK", 3);
      zLQ = locald4;
      zLR = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(268495);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$outSideTimeoutRunnable$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
  public static final class e
    extends a.a
  {
    public final void run()
    {
      AppMethodBeat.i(286010);
      Log.i(this.zLF.TAG, "outSideTimeoutRunnable run... isInFinder=" + this.zLF.zLs);
      if (!this.zLF.zLs) {
        this.zLF.a(this.zLF.dML(), null, (kotlin.g.a.b)new a(this));
      }
      AppMethodBeat.o(286010);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<g.d, x>
    {
      a(g.e parame)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
  public static final class f
    extends q
    implements kotlin.g.a.b<g.d, x>
  {
    public f(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$preload$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class g
    implements aa.b
  {
    g(boolean paramBoolean, g.c paramc, int paramInt, kotlin.g.a.b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.plugin.finder.cgi.aa.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> paramList)
    {
      AppMethodBeat.i(246640);
      p.k(paramf, "resp");
      p.k(paramList, "interceptors");
      this.zLF.eYl.lock();
      Object localObject1;
      label197:
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        try
        {
          this.zLF.zLy.zLC.clear();
          if (!this.zLF.a(paramc, paramf)) {
            Log.i(this.zLF.TAG, "[onCgiBack] tabType=" + this.zLF.fEH + " throw this preload, size=" + paramf.object.size() + " cache=" + this.zLF.zLy);
          }
          for (;;)
          {
            g.b(this.zLF, paramc);
            paramb.invoke(g.d.zLQ);
            if (paramf.SUR != null)
            {
              paramString = com.tencent.mm.kernel.h.aHG();
              p.j(paramString, "MMKernel.storage()");
              paramList = paramString.aHp();
              localObject1 = ar.a.VzY;
              paramString = paramf.SUR;
              if (paramString == null) {
                break label883;
              }
              paramString = paramString.toByteArray();
              paramList.set((ar.a)localObject1, Util.encodeHexString(paramString));
              this.zLF.a(this.zLF.fEH, c.dMJ());
            }
            this.zLF.isLoading = false;
            this.zLF.eYm.signalAll();
            this.zLF.eYl.unlock();
            AppMethodBeat.o(246640);
            return;
            if (paramf.object.isEmpty()) {
              break;
            }
            paramList = this.zLF;
            paramString = paramc;
            paramList.zLy.zLA = paramf;
            localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (com.tencent.mm.plugin.finder.storage.d.dTB())
            {
              localObject1 = paramf.object;
              p.j(localObject1, "resp.`object`");
              localObject1 = (FinderObject)kotlin.a.j.lp((List)localObject1);
              if (localObject1 != null)
              {
                localObject2 = FinderItem.Companion;
                localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
                localObject1 = FinderItem.a.b((FinderObject)localObject1, com.tencent.mm.plugin.finder.utils.aj.QY(paramList.fEH));
                localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
                localObject1 = c.a.a((FinderItem)localObject1);
                localObject2 = new LinkedList();
                ((LinkedList)localObject2).addAll((Collection)((BaseFinderFeed)localObject1).feedObject.getMediaList());
                Object localObject3 = new o(localObject1, kotlin.a.j.t((Collection)localObject2));
                localObject2 = new LinkedList();
                ((LinkedList)localObject2).add(localObject3);
                ((BaseFinderFeed)localObject1).feedObject.setReplaceLongVideoToNormal(com.tencent.mm.plugin.finder.utils.aj.a(com.tencent.mm.plugin.finder.utils.aj.AGc, paramList.fEH, 0, 2));
                localObject3 = (com.tencent.mm.plugin.finder.preload.worker.b)paramList.xoT.getValue();
                com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
                paramInt1 = com.tencent.mm.plugin.finder.utils.aj.QP(paramList.fEH);
                paramList = FeedData.Companion;
                ((com.tencent.mm.plugin.finder.preload.worker.b)localObject3).a(paramInt1, FeedData.a.j(((BaseFinderFeed)localObject1).feedObject), kotlin.a.j.t((Collection)localObject2), 0);
              }
            }
            paramList = com.tencent.mm.plugin.finder.preload.c.zKl;
            if (com.tencent.mm.plugin.finder.preload.c.dMG())
            {
              paramList = com.tencent.mm.plugin.finder.storage.d.AjH;
              if (com.tencent.mm.plugin.finder.storage.d.dTB()) {
                com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g.k(paramString));
              }
            }
            Log.i(this.zLF.TAG, "[onCgiBack] tabType=" + this.zLF.fEH + " preload successfully! size=" + paramf.object.size() + " cache=" + this.zLF.zLy);
          }
          paramString = com.tencent.mm.kernel.h.aHG();
        }
        finally
        {
          g.b(this.zLF, paramc);
          paramb.invoke(g.d.zLQ);
          if (paramf.SUR == null) {
            break label715;
          }
        }
        p.j(paramString, "MMKernel.storage()");
        localObject1 = paramString.aHp();
        localObject2 = ar.a.VzY;
        paramString = paramf.SUR;
        if (paramString == null) {
          break label888;
        }
      }
      label715:
      label883:
      label888:
      for (paramString = paramString.toByteArray();; paramString = null)
      {
        ((ao)localObject1).set((ar.a)localObject2, Util.encodeHexString(paramString));
        this.zLF.a(this.zLF.fEH, c.dMJ());
        this.zLF.isLoading = false;
        this.zLF.eYm.signalAll();
        this.zLF.eYl.unlock();
        AppMethodBeat.o(246640);
        throw paramList;
        Log.e(this.zLF.TAG, "[onCgiBack] tabType=" + this.zLF.fEH + " preload fail! list is empty! cache=" + this.zLF.zLy);
        break;
        this.zLF.pV(true);
        Log.e(this.zLF.TAG, "[onCgiBack] tabType=" + this.zLF.fEH + " preload fail! errType=" + paramInt1 + " errCode=" + paramInt2 + " cache=" + this.zLF.zLy);
        break;
        paramString = null;
        break label197;
      }
    }
    
    public final void a(bjv parambjv)
    {
      AppMethodBeat.i(246635);
      p.k(parambjv, "request");
      int i;
      if (bool)
      {
        parambjv.SUv = 0;
        if (paramc != g.c.zLL)
        {
          b localb = b.zLe;
          i = i;
          if (parambjv.SUw == 0L) {
            break label80;
          }
        }
      }
      label80:
      for (boolean bool = true;; bool = false)
      {
        b.c(i, 1, 0, bool, 106);
        AppMethodBeat.o(246635);
        return;
        parambjv.SUv = 1;
        break;
      }
    }
    
    public final boolean a(dyy paramdyy)
    {
      AppMethodBeat.i(246634);
      p.k(paramdyy, "resp");
      AppMethodBeat.o(246634);
      return false;
    }
    
    public final boolean dnH()
    {
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.extension.reddot.f>
  {
    public static final i zLU;
    
    static
    {
      AppMethodBeat.i(222946);
      zLU = new i();
      AppMethodBeat.o(222946);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$requestCache$1$1"})
  static final class j
    extends q
    implements kotlin.g.a.b<FinderObject, Boolean>
  {
    j(com.tencent.mm.plugin.finder.viewmodel.f paramf, g paramg, kotlin.g.b.aa.f paramf1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(g.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.g
 * JD-Core Version:    0.7.0.1
 */