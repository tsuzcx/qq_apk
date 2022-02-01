package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.cgi.aa.b;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.feed.model.internal.e.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.h.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.dpc;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "", "tabType", "", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(ILcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "getCache", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getCore", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "isBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isInFindMoreFriendTab", "isInFinder", "", "()Z", "setInFinder", "(Z)V", "isLoading", "setLoading", "lastExitFindMoreFriendTab", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "outSideTimeoutRunnable", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "getOutSideTimeoutRunnable", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "getTabType", "()I", "timer", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "getTimer", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "clear", "isRecycle", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "getPullType", "source", "getReportKey", "isAcceptCgiBack", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "performBackground", "", "performChangeEnterTargetTab", "lastTab", "targetTab", "performEnterFindMoreFriendTab", "performEnterFinder", "performEnterFinderLoad", "intent", "Landroid/content/Intent;", "performExitFindMoreFriendTab", "performExitFinder", "performForeground", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "report", "isHasCache", "pullType", "overCount", "requestCache", "setCache", "updateCacheStatus", "print", "Cache", "CacheTime", "PreloadSource", "Ret", "plugin-finder_release"})
public abstract class f
{
  public final String TAG;
  public final int dLS;
  final ReentrantLock dgE;
  final Condition dgF;
  volatile boolean isLoading;
  final kotlin.f tGg;
  long uUZ;
  public boolean uVa;
  public final a uVb;
  final AtomicBoolean uVc;
  final AtomicBoolean uVd;
  private final kotlin.f uVe;
  public final a.a uVf;
  public final a uVg;
  public final FinderStreamTabPreloadCore uVh;
  
  public f(int paramInt, FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    this.dLS = paramInt;
    this.uVh = paramFinderStreamTabPreloadCore;
    this.TAG = ("Finder.TabPreloadWorker#" + this.dLS);
    this.uVb = new a(this.TAG);
    this.uVc = new AtomicBoolean(true);
    this.uVd = new AtomicBoolean(false);
    this.uVe = kotlin.g.ah((kotlin.g.a.a)i.uVD);
    this.uVf = ((a.a)new e(this));
    this.tGg = kotlin.g.ah((kotlin.g.a.a)new h(this));
    this.dgE = new ReentrantLock();
    this.dgF = this.dgE.newCondition();
    this.uVg = new a(this.dLS);
  }
  
  private static long JQ(int paramInt)
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
  
  private final com.tencent.mm.plugin.finder.extension.reddot.f getRedDotManager()
  {
    return (com.tencent.mm.plugin.finder.extension.reddot.f)this.uVe.getValue();
  }
  
  public final aa.f JP(int paramInt)
  {
    Object localObject1 = this.TAG;
    Object localObject4 = new StringBuilder("[request] scene=").append(this.dLS).append(", isPreloading:").append(this.isLoading).append(" cache=").append(this.uVg).append(" isLocked=").append(this.dgE.isLocked()).append(" fakeWaitForRefresh=");
    Object localObject5 = com.tencent.mm.plugin.finder.storage.c.vCb;
    Log.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue() + "ms ");
    this.dgE.lock();
    label675:
    label680:
    label818:
    for (;;)
    {
      long l;
      int j;
      try
      {
        if (this.isLoading)
        {
          l = SystemClock.uptimeMillis();
          this.dgF.await(1L, TimeUnit.MINUTES);
          localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
          l = ((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue() - (SystemClock.uptimeMillis() - l);
          Log.i(this.TAG, "requestCache: loading delay = ".concat(String.valueOf(l)));
          if (l > 0L) {
            this.dgF.await(l, TimeUnit.MILLISECONDS);
          }
          this.dgE.unlock();
          localObject4 = new z.f();
          ((z.f)localObject4).SYG = this.uVg.uVi;
          if (this.uVg.uVj == c.uVt)
          {
            i = 1;
            if (i == 0)
            {
              localObject1 = (aa.f)((z.f)localObject4).SYG;
              if (localObject1 != null)
              {
                localObject5 = com.tencent.mm.ui.component.a.PRN;
                localObject5 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
                p.g(localObject5, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
                localObject5 = (FinderTabStreamUnreadVM)localObject5;
                LinkedList localLinkedList = ((aa.f)localObject1).object;
                p.g(localLinkedList, "it.`object`");
                d.a(localLinkedList, (kotlin.g.a.b)new j((FinderTabStreamUnreadVM)localObject5, this, (z.f)localObject4));
                if (((aa.f)localObject1).object.size() < 3)
                {
                  Log.w(this.TAG, "requestCache: cache after filter read feed is less than 3, abandon it");
                  nM(true);
                  ((z.f)localObject4).SYG = null;
                }
              }
              if ((aa.f)((z.f)localObject4).SYG == null) {
                break label675;
              }
              i = 1;
              j = this.dLS;
              l = this.uVg.uVl;
              if (paramInt != 0) {
                break label702;
              }
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 1L, 1L, false);
              if (i != 0) {
                break label680;
              }
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 2L, 1L, false);
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 7L, 1L, false);
              if (i != 0) {
                break label774;
              }
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 8L, 1L, false);
              if ((aa.f)((z.f)localObject4).SYG != null)
              {
                paramInt = this.uVg.dLS;
                localObject1 = (aa.f)((z.f)localObject4).SYG;
                if (localObject1 == null) {
                  break label818;
                }
                localObject1 = ((aa.f)localObject1).lastBuffer;
                new com.tencent.mm.plugin.finder.cgi.g(paramInt, (com.tencent.mm.bw.b)localObject1).aYI();
              }
            }
            nM(false);
            return (aa.f)((z.f)localObject4).SYG;
          }
        }
        else
        {
          if (this.uVg.uVi == null) {
            continue;
          }
          localObject1 = this.TAG;
          localObject4 = new StringBuilder("requestCache: force wait ");
          localObject5 = com.tencent.mm.plugin.finder.storage.c.vCb;
          Log.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue() + "ms");
          localObject1 = this.dgF;
          localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
          ((Condition)localObject1).await(((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue(), TimeUnit.MILLISECONDS);
          continue;
        }
        i = 0;
      }
      finally
      {
        this.dgE.unlock();
      }
      continue;
      int i = 0;
      continue;
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 3L, 1L, false);
      continue;
      label702:
      if (paramInt == 1)
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 4L, 1L, false);
        if (i == 0)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 5L, 1L, false);
        }
        else
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 6L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 9L, 1L, false);
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(j) + 10L, 1L + l, false);
          continue;
          Object localObject3 = null;
        }
      }
    }
  }
  
  public void a(int paramInt, bcy parambcy)
  {
    p.h(parambcy, "serverConfig");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[performServerConfigChanged] fromTabType=").append(paramInt).append(" serverConfig=");
    p.h(parambcy, "$this$print");
    Log.i(str, new StringBuilder("[").append(parambcy.LMf).append(", ").append(parambcy.LMg).append(", ").append(parambcy.LMh).append(", ").append(parambcy.LMi).append(", ").append(parambcy.LMj).append(", ").append(parambcy.LMk).append(", ").append(parambcy.LMl).append(", ").append(parambcy.LMm).append(", ").append(parambcy.LMn).append(", ").append(parambcy.LMo).append(", ").append(parambcy.LMp).append(", ").append(parambcy.LMq).append(", ").append(parambcy.LMr).append(", ").append(parambcy.LMs).append(", ").append(parambcy.LMt).append(", ").append(parambcy.LMu).append(", ").append(parambcy.LMv).append(']').toString());
  }
  
  public void a(final c paramc, Intent paramIntent, final kotlin.g.a.b<? super d, x> paramb)
  {
    p.h(paramc, "source");
    p.h(paramb, "call");
    if (this.isLoading)
    {
      Log.w(this.TAG, "isLoading=true");
      paramb.invoke(d.uVv);
      return;
    }
    if (!FinderStreamTabPreloadCore.a(paramc))
    {
      Log.w(this.TAG, "isEnable=false source=".concat(String.valueOf(paramc)));
      paramb.invoke(d.uVw);
      return;
    }
    if (!a(this, paramc))
    {
      Log.w(this.TAG, "isValid=false source=".concat(String.valueOf(paramc)));
      paramb.invoke(d.uVx);
      return;
    }
    this.dgE.lock();
    final boolean bool;
    label155:
    Object localObject3;
    label255:
    int i;
    label322:
    long l;
    label610:
    int j;
    for (;;)
    {
      try
      {
        this.isLoading = true;
        if (paramc == c.uVo) {
          break label1082;
        }
        if (paramc != c.uVq) {
          break label255;
        }
      }
      finally
      {
        this.dgE.unlock();
      }
      if (this.uVg.uVi == null) {
        break label1096;
      }
      bool = true;
      Object localObject1 = this.uVg.uVi;
      if (localObject1 != null)
      {
        localObject1 = ((aa.f)localObject1).lastBuffer;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = (f)this;
        Object localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).azQ();
        localObject3 = y.vXH;
        localObject1 = ((ao)localObject2).get(y.LK(((f)localObject1).dLS), "");
        if (localObject1 == null)
        {
          throw new t("null cannot be cast to non-null type kotlin.String");
          if (paramc == c.uVp)
          {
            i = 7;
            continue;
          }
          if (paramc == c.uVr)
          {
            i = 5;
            continue;
          }
          if (paramc == c.uVs)
          {
            i = 8;
            continue;
          }
          if (paramc != c.uVt) {
            break label1089;
          }
          i = 0;
          continue;
        }
        localObject1 = com.tencent.mm.bw.b.cD(Util.decodeHexString((String)localObject1));
        localObject2 = this.uVg.uVi;
        if (localObject2 != null)
        {
          localObject2 = ((aa.f)localObject2).object;
          if (localObject2 != null) {
            localObject2 = new LinkedList((Collection)localObject2);
          }
        }
        Object localObject4;
        while ((i == 0) && ((this.dLS == 1) || (this.dLS == 3)))
        {
          localObject3 = y.vXH;
          localObject3 = y.vXH;
          localObject4 = com.tencent.mm.plugin.finder.feed.model.internal.e.tYB;
          localObject3 = y.a(y.a((y)localObject3, e.a.IO(this.dLS).value, null, 0, true, this.dLS, 6), BaseFinderFeed.class);
          localObject4 = y.vXH;
          localObject4 = (Iterable)y.u((List)localObject3, this.dLS);
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
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
          localObject4 = new StringBuilder("[preload] tabType=").append(this.dLS).append(", unreadList=").append(((LinkedList)localObject2).size()).append(" first=");
          localObject5 = (FinderObject)j.kv((List)localObject2);
          if (localObject5 == null) {
            break label1056;
          }
          l = ((FinderObject)localObject5).id;
          Log.i((String)localObject3, d.zs(l));
        }
        nM(true);
        Object localObject5 = new bbn();
        localObject3 = k.vfA;
        ((bbn)localObject5).tCE = k.Kw(this.dLS);
        if (paramc == c.uVt)
        {
          localObject3 = FinderReporterUIC.wzC;
          ((bbn)localObject5).sGE = FinderReporterUIC.a.MG(this.dLS);
          if (paramIntent != null)
          {
            localObject4 = paramIntent.getStringExtra("key_context_id");
            localObject3 = localObject4;
            if (localObject4 != null) {}
          }
          else
          {
            localObject3 = k.vfA;
            localObject3 = k.doc();
          }
          ((bbn)localObject5).sGQ = ((String)localObject3);
          localObject4 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          ((bbn)localObject5).sessionId = ((String)localObject3);
          if (paramIntent == null) {
            break label1102;
          }
          localObject4 = paramIntent.getStringExtra("key_extra_info");
          localObject3 = localObject4;
          if (localObject4 == null) {
            break label1102;
          }
          label784:
          ((bbn)localObject5).extraInfo = ((String)localObject3);
          if (paramIntent == null) {
            break label1109;
          }
          localObject3 = paramIntent.getStringExtra("key_enter_source_info");
          paramIntent = (Intent)localObject3;
          if (localObject3 == null) {
            break label1109;
          }
          label815:
          ((bbn)localObject5).sGH = paramIntent;
        }
        paramIntent = this.TAG;
        localObject3 = new StringBuilder("[preload] tabType=").append(this.dLS).append(", hasCache=").append(bool).append(", consumeFlag=");
        if (bool)
        {
          j = 0;
          label870:
          Log.i(paramIntent, j + ", unread list size=" + ((LinkedList)localObject2).size() + ", pullType=" + i + ", source=" + paramc + ", cache=" + this.uVg);
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1421L, JQ(this.dLS) + 11L, 1L, false);
          new aa(this.dLS, i, (com.tencent.mm.bw.b)localObject1, (bbn)localObject5, (List)localObject2, true).a(null, (aa.b)new g(this, bool, paramc, paramb));
          if (paramc == c.uVt)
          {
            paramc = h.veu;
            paramc = h.Kd(this.dLS);
            if (paramc != null)
            {
              if ((!paramc.ZA) || (paramc.vev)) {
                break label1068;
              }
              i = 1;
              break label1115;
            }
          }
        }
      }
    }
    for (;;)
    {
      label1039:
      if (paramc != null) {
        paramc.vfh = 1;
      }
      this.dgE.unlock();
      return;
      label1056:
      l = 0L;
      break label610;
      j = 1;
      break label870;
      label1068:
      i = 0;
      label1082:
      label1089:
      label1096:
      label1102:
      label1109:
      label1115:
      while (i == 0)
      {
        paramc = null;
        break label1039;
        break label322;
        i = 6;
        break;
        i = 6;
        break;
        bool = false;
        break label155;
        localObject3 = "";
        break label784;
        paramIntent = "";
        break label815;
      }
    }
  }
  
  public boolean a(c paramc, aa.f paramf)
  {
    p.h(paramc, "source");
    p.h(paramf, "resp");
    return true;
  }
  
  public boolean a(c paramc, String paramString)
  {
    p.h(paramc, "source");
    p.h(paramString, "log");
    Log.i(this.TAG, "[isValid] isInFindMoreFriendTab=" + this.uVd + " isBackground=" + this.uVc + " isInFinder=" + this.uVa + " source=" + paramc + ' ' + paramString);
    if ((paramc == c.uVo) || (paramc == c.uVs) || (paramc == c.uVq) || (paramc == c.uVt)) {
      if ((this.uVa) || (!this.uVd.get()) || (this.uVc.get())) {}
    }
    while ((this.uVa) && (this.uVd.get()) && (!this.uVc.get()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public c dlJ()
  {
    return c.uVq;
  }
  
  public long dlK()
  {
    com.tencent.mm.plugin.finder.extension.reddot.f localf = getRedDotManager();
    getRedDotManager();
    if (localf.asW(com.tencent.mm.plugin.finder.extension.reddot.f.Ix(this.dLS)) != null) {}
    for (boolean bool = true;; bool = false) {
      return FinderStreamTabPreloadCore.al(this.dLS, bool);
    }
  }
  
  public void gc(int paramInt1, int paramInt2)
  {
    Log.i(this.TAG, "[performChangeEnterTargetTab] lastTab=" + paramInt1 + " targetTab=" + paramInt2);
  }
  
  public final boolean nM(boolean paramBoolean)
  {
    this.dgE.lock();
    boolean bool;
    for (;;)
    {
      try
      {
        if (this.uVg.uVi != null)
        {
          bool = true;
          if (!paramBoolean) {
            break label350;
          }
          LinkedList localLinkedList = new LinkedList();
          localObject2 = this.uVg.uVi;
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((aa.f)localObject2).object;
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.Companion;
          p.g(localObject3, "it");
          localObject4 = y.vXH;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, y.LL(this.dLS));
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          localLinkedList.add(c.a.s((FinderItem)localObject3));
          continue;
        }
        bool = false;
      }
      finally
      {
        this.dgE.unlock();
      }
    }
    Object localObject2 = this.uVg.uVi;
    if (localObject2 != null)
    {
      localObject2 = ((aa.f)localObject2).object;
      if (localObject2 != null)
      {
        this.uVg.uVk.addAll((Collection)localObject2);
        localObject2 = this.uVg;
        ((a)localObject2).uVl += 1L;
      }
    }
    localObject2 = y.vXH;
    int i = this.dLS;
    List localList = (List)localObject1;
    localObject2 = new bbn();
    Object localObject3 = k.vfA;
    ((bbn)localObject2).tCE = k.Kw(this.dLS);
    y.a(i, localList, (bbn)localObject2);
    for (;;)
    {
      if (bool) {
        Log.i(this.TAG, "[clear] tabType=" + this.dLS + " cache=" + this.uVg + " isRecycle=" + paramBoolean);
      }
      this.uVg.uVi = null;
      this.uVg.uVj = null;
      this.dgE.unlock();
      return bool;
      label350:
      this.uVg.uVl = 0L;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;I)V", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "overCount", "getOverCount", "setOverCount", "records", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "recycledList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRecycledList", "()Ljava/util/LinkedList;", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "getResp", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setResp", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;)V", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getSource", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "setSource", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;)V", "getTabType", "()I", "restoreTime", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshPreloadCacheList;", "storeTime", "", "toString", "", "print", "tag", "plugin-finder_release"})
  public final class a
  {
    final int dLS;
    long hwQ;
    public aa.f uVi;
    f.c uVj;
    final LinkedList<FinderObject> uVk;
    long uVl;
    final ConcurrentHashMap<Integer, f.b> uVm;
    
    public a()
    {
      AppMethodBeat.i(249592);
      int i;
      this.dLS = i;
      this.uVk = new LinkedList();
      this.uVm = new ConcurrentHashMap();
      this$1 = dlL();
      Object localObject1 = f.this.LKS;
      p.g(localObject1, "refreshPreloadCacheList.caches");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((bbk)localObject3).dLS == this.dLS) {}
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
        localObject2 = (bbk)((Iterator)localObject1).next();
        ((Map)this.uVm).put(Integer.valueOf(((bbk)localObject2).source), new f.b(((bbk)localObject2).iVn));
      }
      a(f.this, "build");
      AppMethodBeat.o(249592);
    }
    
    public final void a(bbl parambbl, String paramString)
    {
      AppMethodBeat.i(249591);
      p.h(parambbl, "$this$print");
      p.h(paramString, "tag");
      String str = f.this.TAG;
      paramString = new StringBuilder("[FinderRefreshPreloadCacheList#print] tag=").append(paramString).append(' ');
      parambbl = parambbl.LKS;
      p.g(parambbl, "this.caches");
      Object localObject1 = (Iterable)parambbl;
      parambbl = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      label137:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((bbk)localObject2).dLS == this.dLS) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label137;
          }
          parambbl.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)parambbl;
      parambbl = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bbk)((Iterator)localObject1).next();
        parambbl.add(((bbk)localObject2).dLS + ':' + ((bbk)localObject2).source + "=>" + ((bbk)localObject2).iVn);
      }
      Log.i(str, (List)parambbl);
      AppMethodBeat.o(249591);
    }
    
    final bbl dlL()
    {
      AppMethodBeat.i(249590);
      Object localObject1 = new bbl();
      Object localObject2 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).azQ().get(ar.a.Ole, "");
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(249590);
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
          ((bbl)localObject1).parseFrom(Util.decodeHexString((String)localObject2));
          AppMethodBeat.o(249590);
          return localObject1;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace(f.this.TAG, (Throwable)localException, "", new Object[0]);
            com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
            p.g(locale, "MMKernel.storage()");
            locale.azQ().set(ar.a.Ole, null);
          }
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(249589);
      Object localObject2 = new StringBuilder("[").append(this.uVj).append(", resp=");
      Object localObject1 = this.uVi;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((aa.f)localObject1).hashCode());; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", lastTime=").append(this.hwQ).append(", overCount=").append(this.uVl).append(", recycledList=");
        Object localObject3 = (Iterable)this.uVk;
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(d.zs(((FinderObject)((Iterator)localObject3).next()).id));
        }
      }
      localObject1 = (List)localObject2 + ']';
      AppMethodBeat.o(249589);
      return localObject1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OutSideRedDot", "InsideRedDot", "OutSideTimeout", "InsideConfigNotify", "OutSideJumpHot", "EnterLoad", "plugin-finder_release"})
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(249594);
      c localc1 = new c("OutSideRedDot", 0, 1);
      uVo = localc1;
      c localc2 = new c("InsideRedDot", 1, 2);
      uVp = localc2;
      c localc3 = new c("OutSideTimeout", 2, 3);
      uVq = localc3;
      c localc4 = new c("InsideConfigNotify", 3, 4);
      uVr = localc4;
      c localc5 = new c("OutSideJumpHot", 4, 5);
      uVs = localc5;
      c localc6 = new c("EnterLoad", 5, 6);
      uVt = localc6;
      uVu = new c[] { localc1, localc2, localc3, localc4, localc5, localc6 };
      AppMethodBeat.o(249594);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "", "(Ljava/lang/String;I)V", "LOADING", "DISABLE", "INVALID", "OK", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(249597);
      d locald1 = new d("LOADING", 0);
      uVv = locald1;
      d locald2 = new d("DISABLE", 1);
      uVw = locald2;
      d locald3 = new d("INVALID", 2);
      uVx = locald3;
      d locald4 = new d("OK", 3);
      uVy = locald4;
      uVz = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(249597);
    }
    
    private d() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$outSideTimeoutRunnable$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
  public static final class e
    extends a.a
  {
    public final void run()
    {
      AppMethodBeat.i(249601);
      Log.i(this.uVn.TAG, "outSideTimeoutRunnable run... isInFinder=" + this.uVn.uVa);
      if (!this.uVn.uVa) {
        this.uVn.a(this.uVn.dlJ(), null, (kotlin.g.a.b)new a(this));
      }
      AppMethodBeat.o(249601);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<f.d, x>
    {
      a(f.e parame)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
  public static final class f
    extends q
    implements kotlin.g.a.b<f.d, x>
  {
    public f(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$preload$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class g
    implements aa.b
  {
    g(boolean paramBoolean, f.c paramc, kotlin.g.a.b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aa.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> paramList)
    {
      AppMethodBeat.i(249605);
      p.h(paramf, "resp");
      p.h(paramList, "interceptors");
      this.uVn.dgE.lock();
      Object localObject1;
      label197:
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        try
        {
          this.uVn.uVg.uVk.clear();
          if (!this.uVn.a(paramc, paramf)) {
            Log.i(this.uVn.TAG, "[onCgiBack] tabType=" + this.uVn.dLS + " throw this preload, size=" + paramf.object.size() + " cache=" + this.uVn.uVg);
          }
          for (;;)
          {
            f.b(this.uVn, paramc);
            paramb.invoke(f.d.uVy);
            if (paramf.LMO != null)
            {
              paramString = com.tencent.mm.kernel.g.aAh();
              p.g(paramString, "MMKernel.storage()");
              paramList = paramString.azQ();
              localObject1 = ar.a.Old;
              paramString = paramf.LMO;
              if (paramString == null) {
                break label868;
              }
              paramString = paramString.toByteArray();
              paramList.set((ar.a)localObject1, Util.encodeHexString(paramString));
              this.uVn.a(this.uVn.dLS, FinderStreamTabPreloadCore.dlI());
            }
            this.uVn.isLoading = false;
            this.uVn.dgF.signalAll();
            this.uVn.dgE.unlock();
            AppMethodBeat.o(249605);
            return;
            if (paramf.object.isEmpty()) {
              break;
            }
            paramList = this.uVn;
            paramString = paramc;
            paramList.uVg.uVi = paramf;
            localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsm())
            {
              localObject1 = paramf.object;
              p.g(localObject1, "resp.`object`");
              localObject1 = (FinderObject)j.kt((List)localObject1);
              if (localObject1 != null)
              {
                localObject2 = FinderItem.Companion;
                localObject2 = y.vXH;
                localObject1 = FinderItem.a.a((FinderObject)localObject1, y.LL(paramList.dLS));
                localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                localObject1 = c.a.s((FinderItem)localObject1);
                localObject2 = new LinkedList();
                ((LinkedList)localObject2).addAll((Collection)((BaseFinderFeed)localObject1).feedObject.getMediaList());
                Object localObject3 = new o(localObject1, j.v((Collection)localObject2));
                localObject2 = new LinkedList();
                ((LinkedList)localObject2).add(localObject3);
                ((BaseFinderFeed)localObject1).feedObject.setReplaceLongVideoToNormal(y.a(y.vXH, paramList.dLS, 0, 2));
                paramList = (com.tencent.mm.plugin.finder.preload.worker.b)paramList.tGg.getValue();
                localObject3 = FeedData.Companion;
                paramList.a(FeedData.a.i(((BaseFinderFeed)localObject1).feedObject), j.v((Collection)localObject2), 0);
              }
            }
            paramList = MediaPreloadCore.uTV;
            if (MediaPreloadCore.dlF())
            {
              paramList = com.tencent.mm.plugin.finder.storage.c.vCb;
              if (com.tencent.mm.plugin.finder.storage.c.dsm()) {
                d.h((kotlin.g.a.a)new f.k(paramString));
              }
            }
            Log.i(this.uVn.TAG, "[onCgiBack] tabType=" + this.uVn.dLS + " preload successfully! size=" + paramf.object.size() + " cache=" + this.uVn.uVg);
          }
          paramString = com.tencent.mm.kernel.g.aAh();
        }
        finally
        {
          f.b(this.uVn, paramc);
          paramb.invoke(f.d.uVy);
          if (paramf.LMO == null) {
            break label700;
          }
        }
        p.g(paramString, "MMKernel.storage()");
        localObject1 = paramString.azQ();
        localObject2 = ar.a.Old;
        paramString = paramf.LMO;
        if (paramString == null) {
          break label873;
        }
      }
      label700:
      label868:
      label873:
      for (paramString = paramString.toByteArray();; paramString = null)
      {
        ((ao)localObject1).set((ar.a)localObject2, Util.encodeHexString(paramString));
        this.uVn.a(this.uVn.dLS, FinderStreamTabPreloadCore.dlI());
        this.uVn.isLoading = false;
        this.uVn.dgF.signalAll();
        this.uVn.dgE.unlock();
        AppMethodBeat.o(249605);
        throw paramList;
        Log.e(this.uVn.TAG, "[onCgiBack] tabType=" + this.uVn.dLS + " preload fail! list is empty! cache=" + this.uVn.uVg);
        break;
        this.uVn.nM(true);
        Log.e(this.uVn.TAG, "[onCgiBack] tabType=" + this.uVn.dLS + " preload fail! errType=" + paramInt1 + " errCode=" + paramInt2 + " cache=" + this.uVn.uVg);
        break;
        paramString = null;
        break label197;
      }
    }
    
    public final void a(bcz parambcz)
    {
      AppMethodBeat.i(249604);
      p.h(parambcz, "request");
      if (bool)
      {
        parambcz.LMw = 0;
        AppMethodBeat.o(249604);
        return;
      }
      parambcz.LMw = 1;
      AppMethodBeat.o(249604);
    }
    
    public final boolean a(dpc paramdpc)
    {
      AppMethodBeat.i(249603);
      p.h(paramdpc, "resp");
      AppMethodBeat.o(249603);
      return false;
    }
    
    public final boolean cXU()
    {
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.extension.reddot.f>
  {
    public static final i uVD;
    
    static
    {
      AppMethodBeat.i(249608);
      uVD = new i();
      AppMethodBeat.o(249608);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$requestCache$1$1"})
  static final class j
    extends q
    implements kotlin.g.a.b<FinderObject, Boolean>
  {
    j(FinderTabStreamUnreadVM paramFinderTabStreamUnreadVM, f paramf, z.f paramf1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.f
 * JD-Core Version:    0.7.0.1
 */