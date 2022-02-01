package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aq.a;
import com.tencent.mm.plugin.finder.cgi.aq.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.cgi.aq.e;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k.b;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "", "tabType", "", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(ILcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "getCache", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getCore", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "isBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isInFindMoreFriendTab", "isInFinder", "", "()Z", "setInFinder", "(Z)V", "lastExitFindMoreFriendTab", "", "loadingState", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$LoadingState;", "getLoadingState", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$LoadingState;", "setLoadingState", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$LoadingState;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "outSideDelayRunnable", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "getOutSideDelayRunnable", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "getTabType", "()I", "timer", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "getTimer", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "cancel", "", "checkCacheValid", "clear", "isRecycle", "fetchEnterLoad", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "unread", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "hasCache", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "getNextTime", "getOutTimeOutPreloadSource", "getOutsideIntervalTime", "preloadSource", "getOutsidePreloadSource", "getPullType", "getReportKey", "isAcceptCgiBack", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "performBackground", "performChangeEnterTargetTab", "lastTab", "targetTab", "performEnterFindMoreFriendTab", "performEnterFinderLoad", "intent", "Landroid/content/Intent;", "performExitFindMoreFriendTab", "performFinderBackground", "performFinderForeground", "performForeground", "performInsidePreload", "performServerConfigChanged", "fromTabType", "preload", "putCache", "pullType", "extInfo", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$ExtInfo;", "timestamp", "recycleObjects", "objectList", "", "report", "isHasCache", "overCount", "requestCache", "setCacheWithPreload", "entranceCtrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "setLoading", "load", "updateCacheStatus", "print", "Cache", "CacheTime", "Companion", "ExtInfo", "LoadingState", "PreloadSource", "Ret", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class g
{
  public static final c EWa = new c((byte)0);
  private static final kotlin.j<Boolean> EWn = kotlin.k.cm((kotlin.g.a.a)d.EWv);
  private final kotlin.j AMt;
  public final c EWb;
  long EWc;
  public boolean EWd;
  public final a EWe;
  public final AtomicBoolean EWf;
  public final AtomicBoolean EWg;
  private final kotlin.j EWh;
  private bwf EWi;
  public final a.a EWj;
  public final a EWk;
  com.tencent.mm.plugin.finder.cgi.aq EWl;
  public f EWm;
  public final String TAG;
  final ReentrantLock bKF;
  public final int hJx;
  private final Condition hbM;
  
  public g(int paramInt, c paramc)
  {
    this.hJx = paramInt;
    this.EWb = paramc;
    this.TAG = s.X("Finder.TabPreloadWorker#", Integer.valueOf(this.hJx));
    this.EWe = new a(this.TAG);
    this.EWf = new AtomicBoolean(true);
    this.EWg = new AtomicBoolean(false);
    this.EWh = kotlin.k.cm((kotlin.g.a.a)r.EWS);
    this.EWi = c.eHN();
    this.EWj = ((a.a)new k(this));
    this.AMt = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.bKF = new ReentrantLock();
    this.hbM = this.bKF.newCondition();
    this.EWk = new a(this.hJx);
    this.EWm = new f();
  }
  
  private static long Rt(int paramInt)
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
  
  private long b(g paramg)
  {
    boolean bool2 = true;
    s.u(paramg, "preloadSource");
    int i = this.hJx;
    boolean bool1;
    if (paramg == g.EWz)
    {
      bool1 = true;
      if (this.EWk.BeG == null) {
        break label47;
      }
    }
    for (;;)
    {
      return c.i(i, bool1, bool2);
      bool1 = false;
      break;
      label47:
      bool2 = false;
    }
  }
  
  private final void hm(List<? extends FinderObject> paramList)
  {
    Object localObject1 = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (FinderObject)paramList.next();
      Object localObject3 = FinderItem.Companion;
      localObject3 = av.GiL;
      localObject2 = FinderItem.a.e((FinderObject)localObject2, av.Ui(this.hJx));
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject2));
    }
    paramList = av.GiL;
    int i = this.hJx;
    paramList = (List)localObject1;
    localObject1 = new bui();
    Object localObject2 = z.FrZ;
    ((bui)localObject1).AJo = z.SD(this.hJx);
    localObject2 = ah.aiuX;
    av.a(i, paramList, (bui)localObject1);
  }
  
  public final aq.d Rs(int paramInt)
  {
    Object localObject1 = this.TAG;
    Object localObject4 = new StringBuilder("[request] scene=").append(this.hJx).append(", isPreloading:").append(this.EWm).append(" cache=").append(this.EWk).append(" isLocked=").append(this.bKF.isLocked()).append(" fakeWaitForRefresh=");
    Object localObject5 = com.tencent.mm.plugin.finder.storage.d.FAy;
    Log.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue() + "ms ");
    this.bKF.lock();
    long l;
    int i;
    Object localObject6;
    label502:
    int j;
    label540:
    label582:
    label623:
    int k;
    try
    {
      if (this.EWm.isLoading)
      {
        l = SystemClock.uptimeMillis();
        this.hbM.await(1L, TimeUnit.MINUTES);
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue() - (SystemClock.uptimeMillis() - l);
        Log.i(this.TAG, "requestCache: loading delay = " + l + ", tabType = " + this.hJx + ", pullType = " + paramInt);
        if (l > 0L) {
          this.hbM.await(l, TimeUnit.MILLISECONDS);
        }
      }
      for (;;)
      {
        this.bKF.unlock();
        localObject5 = new ah.f();
        ((ah.f)localObject5).aqH = this.EWk.BeG;
        Log.i(this.TAG, "requestCache: source = " + this.EWk.EWo + ", result = " + ((ah.f)localObject5).aqH + " tabType = " + this.hJx + ", pullType = " + paramInt);
        if (this.EWk.EWo != g.EWE) {
          break label1003;
        }
        i = 1;
        if (i != 0) {
          break label1286;
        }
        localObject1 = (aq.d)((ah.f)localObject5).aqH;
        if (localObject1 != null)
        {
          localObject4 = com.tencent.mm.ui.component.k.aeZF;
          localObject4 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.h.class);
          s.s(localObject4, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
          localObject4 = (com.tencent.mm.plugin.finder.viewmodel.h)localObject4;
          localObject6 = ((aq.d)localObject1).object;
          s.s(localObject6, "it.`object`");
          com.tencent.mm.ae.d.a((LinkedList)localObject6, (kotlin.g.a.b)new s((ah.f)localObject5, (com.tencent.mm.plugin.finder.viewmodel.h)localObject4, this));
          i = ((aq.d)localObject1).object.size();
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (i < ((Number)com.tencent.mm.plugin.finder.storage.d.eSk().bmg()).intValue())
          {
            Log.w(this.TAG, "requestCache: cache after filter read feed is less than 3, abandon it");
            ta(true);
            ((ah.f)localObject5).aqH = null;
          }
        }
        if (((ah.f)localObject5).aqH == null) {
          break label1008;
        }
        i = 1;
        j = this.hJx;
        l = this.EWk.EWs;
        switch (paramInt)
        {
        default: 
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 7L, 1L, false);
          if (i != 0) {
            break label1145;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 8L, 1L, false);
          localObject4 = (aq.d)((ah.f)localObject5).aqH;
          if (localObject4 == null) {
            break label1286;
          }
          paramInt = this.EWk.hJx;
          localObject1 = (aq.d)((ah.f)localObject5).aqH;
          if (localObject1 != null) {
            break label1189;
          }
          localObject1 = null;
          new com.tencent.mm.plugin.finder.cgi.h(paramInt, (com.tencent.mm.bx.b)localObject1).bFJ();
          localObject1 = b.EVP;
          b.c(0, 2, 0, false, 123);
          paramInt = this.EWk.hJx;
          localObject1 = ((aq.d)localObject4).object;
          s.s(localObject1, "`object`");
          localObject6 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject6, 10));
          localObject6 = ((Iterable)localObject6).iterator();
          while (((Iterator)localObject6).hasNext()) {
            ((Collection)localObject1).add(Long.valueOf(((FinderObject)((Iterator)localObject6).next()).id));
          }
          if (this.EWk.BeG != null) {
            break label884;
          }
          k = 0;
          label759:
          if (k != 0)
          {
            localObject1 = this.TAG;
            localObject4 = new StringBuilder("requestCache: force wait ");
            localObject5 = com.tencent.mm.plugin.finder.storage.d.FAy;
            Log.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue() + "ms, tabType = " + this.hJx + ", pullType = " + paramInt);
            localObject1 = this.hbM;
            localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
            ((Condition)localObject1).await(((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue(), TimeUnit.MILLISECONDS);
          }
          break;
        }
      }
      if (cn.bDw() - this.EWk.mJI <= c.Rq(this.hJx)) {
        break label1301;
      }
    }
    finally
    {
      this.bKF.unlock();
    }
    label884:
    if (this.EWk.mJI == 0L) {
      break label1301;
    }
    for (;;)
    {
      Log.i(this.TAG, "checkCacheValid: isCacheValid = " + bool + ", tabType = " + this.hJx + ", cache.lastTime = " + this.EWk.mJI);
      k = bool;
      if (bool) {
        break label759;
      }
      ta(true);
      k = bool;
      break label759;
      boolean bool = false;
      continue;
      label1003:
      i = 0;
      break;
      label1008:
      i = 0;
      break label502;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 1L, 1L, false);
      if (i == 0)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 2L, 1L, false);
        break label540;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 3L, 1L, false);
      break label540;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 4L, 1L, false);
      if (i == 0)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 5L, 1L, false);
        break label540;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 6L, 1L, false);
      break label540;
      label1145:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 9L, 1L, false);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(j) + 10L, 1L + l, false);
      break label582;
      label1189:
      Object localObject3 = localObject2.lastBuffer;
      break label623;
      new com.tencent.mm.plugin.finder.cgi.b(paramInt, (List)localObject3, ((aq.d)localObject4).lastBuffer).bFJ();
      localObject3 = com.tencent.mm.plugin.finder.preload.d.EUv;
      localObject6 = com.tencent.mm.plugin.finder.preload.d.a.EUy;
      g localg = this.EWk.EWo;
      paramInt = this.hJx;
      localObject4 = this.EWk.EWp;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new e();
      }
      com.tencent.mm.plugin.finder.preload.d.a((com.tencent.mm.plugin.finder.preload.d.a)localObject6, localg, paramInt, (e)localObject3, this.EWi);
      label1286:
      ta(false);
      return (aq.d)((ah.f)localObject5).aqH;
      label1301:
      bool = true;
    }
  }
  
  public void a(int paramInt, bwf parambwf)
  {
    s.u(parambwf, "serverConfig");
    String str = this.TAG;
    StringBuilder localStringBuilder1 = new StringBuilder("[performServerConfigChanged] fromTabType=").append(paramInt).append(" serverConfig=");
    s.u(parambwf, "<this>");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append('[').append(parambwf.aaej).append(", ").append(parambwf.aaek).append(", ").append(parambwf.aael).append(", ").append(parambwf.aaem).append(", ").append(parambwf.aaen).append(", ").append(parambwf.aaeo).append(", ").append(parambwf.aaep).append(", ").append(parambwf.aaeq).append(", ").append(parambwf.aaer).append(", ").append(parambwf.aaes).append(", ").append(parambwf.aaet).append(", ");
    localStringBuilder2.append(parambwf.aaeu).append(", ").append(parambwf.aaev).append(", ").append(parambwf.aaew).append(", ").append(parambwf.aaex).append(", ").append(parambwf.aaey).append(", ").append(parambwf.aaez).append(", new: ").append(parambwf.aaeD).append(", ").append(parambwf.aaeE).append(", ").append(parambwf.aaeF).append(", ").append(parambwf.aaeG).append(", valid: ").append(parambwf.aaeH).append(", ").append(parambwf.aaeI);
    localStringBuilder2.append(", ").append(parambwf.aaeJ).append(", ").append(parambwf.aaeK).append(']');
    Log.i(str, localStringBuilder2.toString());
    this.EWi = parambwf;
  }
  
  public final void a(aq.d paramd, g paramg, int paramInt, e parame)
  {
    s.u(paramd, "resp");
    s.u(paramg, "source");
    Log.i(this.TAG, "[putCache] source=" + paramg + " pullType=" + paramInt);
    this.bKF.lock();
    try
    {
      this.EWk.BeG = paramd;
      this.EWk.EWo = paramg;
      this.EWk.EWp = parame;
      this.EWk.mJI = 0L;
      return;
    }
    finally
    {
      this.EWm.isLoading = false;
      this.EWm.EWo = paramg;
      this.hbM.signalAll();
      this.bKF.unlock();
    }
  }
  
  public void a(final g paramg, final Intent paramIntent, final kotlin.g.a.b<? super h, ah> paramb)
  {
    s.u(paramg, "source");
    s.u(paramb, "call");
    if (this.EWm.isLoading)
    {
      Log.w(this.TAG, "isLoading=true");
      paramb.invoke(h.EWI);
      return;
    }
    if (!c.a(paramg))
    {
      Log.w(this.TAG, s.X("isEnable=false source=", paramg));
      paramb.invoke(h.EWJ);
      return;
    }
    if (!a(this, paramg))
    {
      Log.w(this.TAG, s.X("isValid=false source=", paramg));
      paramb.invoke(h.EWK);
      return;
    }
    this.bKF.lock();
    final boolean bool;
    label197:
    Object localObject3;
    final int i;
    for (;;)
    {
      try
      {
        this.EWm.isLoading = true;
        this.EWm.EWo = paramg;
        switch (i.$EnumSwitchMapping$0[paramg.ordinal()])
        {
        case 1: 
          if (this.EWk.BeG == null) {
            break label1585;
          }
          bool = true;
          localObject1 = this.EWk.BeG;
          if (localObject1 != null) {
            break label322;
          }
          localObject1 = null;
          if (localObject1 != null) {
            break label1591;
          }
          localObject1 = (g)this;
          localObject2 = com.tencent.mm.kernel.h.baE().ban();
          localObject3 = av.GiL;
          localObject1 = ((com.tencent.mm.storage.aq)localObject2).get(av.Uh(((g)localObject1).hJx), "");
          if (localObject1 != null) {
            break label332;
          }
          throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
      }
      finally
      {
        this.bKF.unlock();
      }
      i = 6;
      continue;
      localObject1 = getRedDotManager().Su("FinderEntrance");
      if (localObject1 == null)
      {
        bool = false;
        break label1540;
      }
      bool = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).eay();
      break label1540;
      label322:
      localObject1 = ((aq.d)localObject1).lastBuffer;
    }
    label332:
    Object localObject2 = com.tencent.mm.bx.b.cX(Util.decodeHexString((String)localObject1));
    label345:
    Object localObject1 = this.EWk.BeG;
    if (localObject1 == null) {
      localObject1 = null;
    }
    final com.tencent.mm.plugin.finder.extension.reddot.p localp;
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new LinkedList();
      }
      localp = getRedDotManager().Su("FinderEntrance");
      if ((i != 0) || ((this.hJx != 1) && (this.hJx != 3))) {
        break label672;
      }
      localObject1 = av.GiL;
      localObject1 = av.GiL;
      localObject1 = com.tencent.mm.plugin.finder.feed.model.internal.g.Bkb;
      localObject1 = av.a(av.a(com.tencent.mm.plugin.finder.feed.model.internal.g.a.Od(this.hJx).value, null, 0, true, false, 22), BaseFinderFeed.class);
      localObject4 = av.GiL;
      localObject4 = (Iterable)av.M((List)localObject1, this.hJx);
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject1).add(((BaseFinderFeed)((Iterator)localObject4).next()).feedObject.getFeedObject());
      }
      localObject1 = ((aq.d)localObject1).object;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = new LinkedList((Collection)localObject1);
      }
    }
    ((LinkedList)localObject3).addAll((Collection)localObject1);
    localObject1 = this.TAG;
    Object localObject4 = new StringBuilder("[preload] tabType=").append(this.hJx).append(", unreadList=").append(((LinkedList)localObject3).size()).append(" first=");
    Object localObject5 = (FinderObject)kotlin.a.p.oN((List)localObject3);
    long l;
    if (localObject5 == null)
    {
      l = 0L;
      Log.i((String)localObject1, com.tencent.mm.ae.d.hF(l));
      label672:
      if ((ta(true)) && (paramg != g.EWE))
      {
        localObject1 = b.EVP;
        b.c(0, 3, 2, false, 115);
      }
      localObject5 = new bui();
      localObject1 = z.FrZ;
      ((bui)localObject5).AJo = z.SD(this.hJx);
      if (paramg == g.EWE)
      {
        localObject1 = as.GSQ;
        ((bui)localObject5).zIB = as.a.Vs(this.hJx);
        if (paramIntent != null) {
          break label1203;
        }
        localObject1 = null;
        label758:
        localObject4 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = z.FrZ;
          localObject4 = z.bUm();
        }
        ((bui)localObject5).zIO = ((String)localObject4);
        localObject4 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
        ((bui)localObject5).sessionId = ((String)localObject1);
        if (paramIntent != null) {
          break label1215;
        }
        localObject1 = "";
        label830:
        ((bui)localObject5).extraInfo = ((String)localObject1);
        if (paramIntent != null) {
          break label1241;
        }
        paramIntent = "";
        label845:
        ((bui)localObject5).zIE = paramIntent;
      }
      paramIntent = ah.aiuX;
      paramIntent = this.TAG;
      localObject1 = new StringBuilder("[preload] tabType=").append(this.hJx).append(", hasCache=").append(bool).append(", consumeFlag=");
      if (!bool) {
        break label1598;
      }
    }
    label1033:
    label1048:
    label1203:
    label1591:
    label1598:
    for (int j = 0;; j = 1)
    {
      Log.i(paramIntent, j + ", unread list size=" + ((LinkedList)localObject3).size() + ", pullType=" + i + ", source=" + paramg + ", cache=" + this.EWk);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1421L, Rt(this.hJx) + 11L, 1L, false);
      if (paramg != g.EWE)
      {
        paramIntent = com.tencent.mm.plugin.finder.preload.d.EUv;
        paramIntent = com.tencent.mm.plugin.finder.preload.d.a.EUx;
        int k = this.hJx;
        localObject1 = new e();
        ((e)localObject1).pullType = i;
        if (localp == null)
        {
          l = 0L;
          ((e)localObject1).EWw = l;
          if (localp != null) {
            break label1293;
          }
          j = -1;
          ((e)localObject1).EWy = j;
          if (localp != null) {
            break label1321;
          }
        }
        for (l = 0L;; l = localp.field_aiScene)
        {
          ((e)localObject1).EWx = l;
          localObject4 = ah.aiuX;
          com.tencent.mm.plugin.finder.preload.d.a(paramIntent, paramg, k, (e)localObject1, this.EWi);
          paramIntent = new com.tencent.mm.plugin.finder.cgi.aq(this.hJx, i, (com.tencent.mm.bx.b)localObject2, (bui)localObject5, (List)localObject3, true, 448);
          paramIntent.a((com.tencent.mm.plugin.finder.cgi.interceptor.g)new com.tencent.mm.plugin.finder.cgi.interceptor.c(), 1);
          paramIntent.a((aq.e)new o(bool, paramg, i, this, paramIntent)).a((aq.a)new p(this, paramg, paramIntent, i, localp, paramb)).run();
          paramg = ah.aiuX;
          this.EWl = paramIntent;
          this.bKF.unlock();
          return;
          l = ((FinderObject)localObject5).id;
          break;
          localObject1 = paramIntent.getStringExtra("key_context_id");
          break label758;
          label1215:
          localObject4 = paramIntent.getStringExtra("key_extra_info");
          localObject1 = localObject4;
          if (localObject4 != null) {
            break label830;
          }
          localObject1 = "";
          break label830;
          label1241:
          localObject1 = paramIntent.getStringExtra("key_enter_source_info");
          paramIntent = (Intent)localObject1;
          if (localObject1 != null) {
            break label845;
          }
          paramIntent = "";
          break label845;
          localObject4 = localp.ASz;
          if (localObject4 == null)
          {
            l = 0L;
            break label1033;
          }
          l = ((btx)localObject4).object_id;
          break label1033;
          localObject4 = localp.ASz;
          if (localObject4 == null)
          {
            j = -1;
            break label1048;
          }
          j = ((btx)localObject4).aabO;
          break label1048;
        }
      }
      s.s(localObject2, "lastBuf");
      kotlinx.coroutines.j.a(ar.d((kotlin.d.f)bg.kCi()), null, null, (m)new j(paramb, this, paramg, (com.tencent.mm.bx.b)localObject2, (bui)localObject5, (LinkedList)localObject3, bool, null), 3);
      paramIntent = com.tencent.mm.plugin.finder.preload.d.EUv;
      paramIntent = com.tencent.mm.plugin.finder.preload.d.a.EUw;
      j = this.hJx;
      paramb = new e();
      paramb.pullType = i;
      if (localp == null)
      {
        l = 0L;
        paramb.EWw = l;
        if (localp != null) {
          break label1495;
        }
        i = -1;
        paramb.EWy = i;
        if (localp != null) {
          break label1523;
        }
      }
      label1495:
      label1523:
      for (l = 0L;; l = localp.field_aiScene)
      {
        paramb.EWx = l;
        localObject1 = ah.aiuX;
        com.tencent.mm.plugin.finder.preload.d.a(paramIntent, paramg, j, paramb, this.EWi);
        break;
        localObject1 = localp.ASz;
        if (localObject1 == null)
        {
          l = 0L;
          break label1413;
        }
        l = ((btx)localObject1).object_id;
        break label1413;
        localObject1 = localp.ASz;
        if (localObject1 == null)
        {
          i = -1;
          break label1427;
        }
        i = ((btx)localObject1).aabO;
        break label1427;
      }
      do
      {
        i = 9;
        break;
      } while (bool);
      i = 6;
      break;
      i = 7;
      break;
      i = 5;
      break;
      i = 8;
      break;
      i = 0;
      break;
      i = 17;
      break;
      bool = false;
      break label197;
      localObject2 = localObject1;
      break label345;
    }
  }
  
  public final void a(boolean paramBoolean, g paramg)
  {
    s.u(paramg, "source");
    Log.i(this.TAG, s.X("[setLoading] load=", Boolean.valueOf(paramBoolean)));
    this.bKF.lock();
    try
    {
      this.EWm.isLoading = paramBoolean;
      this.EWm.EWo = paramg;
      return;
    }
    finally
    {
      this.bKF.unlock();
    }
  }
  
  public boolean a(g paramg, aq.d paramd)
  {
    s.u(paramg, "source");
    s.u(paramd, "resp");
    return true;
  }
  
  public boolean a(g paramg, String paramString)
  {
    s.u(paramg, "source");
    s.u(paramString, "log");
    Log.i(this.TAG, "[isValid] isInFindMoreFriendTab=" + this.EWg + " isBackground=" + this.EWf + " isInFinder=" + this.EWd + " source=" + paramg + ' ' + paramString);
    if ((paramg == g.EWz) || (paramg == g.EWD) || (paramg == g.EWB) || (paramg == g.EWE)) {
      if ((this.EWd) || (!this.EWg.get()) || (this.EWf.get())) {}
    }
    while ((this.EWd) && (this.EWg.get()) && (!this.EWf.get()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public g eHO()
  {
    return g.EWB;
  }
  
  public final g eHP()
  {
    boolean bool = true;
    Object localObject3 = null;
    getRedDotManager();
    Object localObject2 = i.Nu(this.hJx);
    Object localObject4 = getRedDotManager().Su((String)localObject2);
    Object localObject1;
    label42:
    label83:
    StringBuilder localStringBuilder;
    if (localObject4 == null)
    {
      localObject1 = null;
      if (localObject4 != null) {
        break label167;
      }
      localObject2 = null;
      if ((localObject4 == null) || (localObject2 == null) || (localObject1 == null) || ((!c.eHT()) && (((com.tencent.mm.plugin.finder.extension.reddot.p)localObject4).ASz.aabO != 1)) || (this.EWk.BeG != null)) {
        break label177;
      }
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("getOutsidePreloadSource: isRedDotPreload = ").append(bool).append(", redDotExt.pre_load = ");
      if (localObject4 != null) {
        break label182;
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      Log.i((String)localObject2, localObject1 + ", cache.resp = " + this.EWk.BeG);
      if (!bool) {
        break label209;
      }
      return g.EWz;
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject4).avK("FinderEntrance");
      break;
      label167:
      localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject4).avK((String)localObject2);
      break label42;
      label177:
      bool = false;
      break label83;
      label182:
      localObject4 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject4).ASz;
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = Integer.valueOf(((btx)localObject4).aabO);
      }
    }
    label209:
    return eHO();
  }
  
  public final long eHQ()
  {
    g localg = eHP();
    long l1 = b(localg);
    com.tencent.mm.plugin.finder.extension.reddot.p localp = getRedDotManager().Su("FinderEntrance");
    if (localp == null) {}
    long l2;
    for (boolean bool = false;; bool = localp.eay())
    {
      Log.i(this.TAG, "getNextTime: preloadSource = " + localg + ", isAiRedDot = " + bool);
      l2 = cn.bDw();
      if ((!bool) || (localg != g.EWz)) {
        break label130;
      }
      if ((this.EWk.EWr > 0L) || (l1 == 9223372036854775807L)) {
        break;
      }
      return 0L;
    }
    return l1 - (l2 - this.EWk.EWr);
    label130:
    if ((this.EWk.mJI <= 0L) && (l1 != 9223372036854775807L)) {
      return 0L;
    }
    return l1 - (l2 - this.EWk.mJI);
  }
  
  final i getRedDotManager()
  {
    return (i)this.EWh.getValue();
  }
  
  /* Error */
  public final boolean ta(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 329	com/tencent/mm/plugin/finder/preload/tabPreload/g:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 754	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   11: getfield 357	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:BeG	Lcom/tencent/mm/plugin/finder/cgi/aq$d;
    //   14: ifnull +260 -> 274
    //   17: iconst_1
    //   18: istore_3
    //   19: iload_1
    //   20: ifeq +259 -> 279
    //   23: aload_0
    //   24: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   27: getfield 357	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:BeG	Lcom/tencent/mm/plugin/finder/cgi/aq$d;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +49 -> 83
    //   37: aload 4
    //   39: getfield 393	com/tencent/mm/plugin/finder/cgi/aq$d:object	Ljava/util/LinkedList;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +37 -> 83
    //   49: aload_0
    //   50: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   53: getfield 1371	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:EWq	Ljava/util/LinkedList;
    //   56: aload 4
    //   58: checkcast 454	java/util/Collection
    //   61: invokevirtual 458	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   64: pop
    //   65: aload_0
    //   66: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   69: astore 4
    //   71: aload 4
    //   73: aload 4
    //   75: getfield 855	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:EWs	J
    //   78: lconst_1
    //   79: ladd
    //   80: putfield 855	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:EWs	J
    //   83: aload_0
    //   84: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   87: getfield 357	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:BeG	Lcom/tencent/mm/plugin/finder/cgi/aq$d;
    //   90: astore 4
    //   92: aload 4
    //   94: ifnull +24 -> 118
    //   97: aload 4
    //   99: getfield 393	com/tencent/mm/plugin/finder/cgi/aq$d:object	Ljava/util/LinkedList;
    //   102: astore 4
    //   104: aload 4
    //   106: ifnull +12 -> 118
    //   109: aload_0
    //   110: aload 4
    //   112: checkcast 400	java/util/List
    //   115: invokespecial 544	com/tencent/mm/plugin/finder/preload/tabPreload/g:hm	(Ljava/util/List;)V
    //   118: iload_3
    //   119: ifeq +68 -> 187
    //   122: getstatic 951	com/tencent/mm/plugin/finder/preload/d:EUv	Lcom/tencent/mm/plugin/finder/preload/d;
    //   125: astore 4
    //   127: getstatic 1374	com/tencent/mm/plugin/finder/preload/d$a:EUz	Lcom/tencent/mm/plugin/finder/preload/d$a;
    //   130: astore 6
    //   132: aload_0
    //   133: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   136: getfield 566	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:EWo	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
    //   139: astore 7
    //   141: aload_0
    //   142: getfield 269	com/tencent/mm/plugin/finder/preload/tabPreload/g:hJx	I
    //   145: istore_2
    //   146: aload_0
    //   147: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   150: getfield 379	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:EWp	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$e;
    //   153: astore 5
    //   155: aload 5
    //   157: astore 4
    //   159: aload 5
    //   161: ifnonnull +12 -> 173
    //   164: new 16	com/tencent/mm/plugin/finder/preload/tabPreload/g$e
    //   167: dup
    //   168: invokespecial 358	com/tencent/mm/plugin/finder/preload/tabPreload/g$e:<init>	()V
    //   171: astore 4
    //   173: aload 6
    //   175: aload 7
    //   177: iload_2
    //   178: aload 4
    //   180: aload_0
    //   181: getfield 314	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWi	Lcom/tencent/mm/protocal/protobuf/bwf;
    //   184: invokestatic 960	com/tencent/mm/plugin/finder/preload/d:a	(Lcom/tencent/mm/plugin/finder/preload/d$a;Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;ILcom/tencent/mm/plugin/finder/preload/tabPreload/g$e;Lcom/tencent/mm/protocal/protobuf/bwf;)V
    //   187: iload_3
    //   188: ifeq +53 -> 241
    //   191: aload_0
    //   192: getfield 285	com/tencent/mm/plugin/finder/preload/tabPreload/g:TAG	Ljava/lang/String;
    //   195: new 698	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 1376
    //   202: invokespecial 701	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: aload_0
    //   206: getfield 269	com/tencent/mm/plugin/finder/preload/tabPreload/g:hJx	I
    //   209: invokevirtual 705	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 715
    //   215: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   222: invokevirtual 713	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: ldc_w 1378
    //   228: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload_1
    //   232: invokevirtual 723	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   235: invokevirtual 747	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 752	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   245: aconst_null
    //   246: putfield 357	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:BeG	Lcom/tencent/mm/plugin/finder/cgi/aq$d;
    //   249: aload_0
    //   250: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   253: aconst_null
    //   254: putfield 566	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:EWo	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
    //   257: aload_0
    //   258: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   261: aconst_null
    //   262: putfield 379	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:EWp	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$e;
    //   265: aload_0
    //   266: getfield 329	com/tencent/mm/plugin/finder/preload/tabPreload/g:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   269: invokevirtual 786	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   272: iload_3
    //   273: ireturn
    //   274: iconst_0
    //   275: istore_3
    //   276: goto -257 -> 19
    //   279: aload_0
    //   280: getfield 340	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWk	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$a;
    //   283: lconst_0
    //   284: putfield 855	com/tencent/mm/plugin/finder/preload/tabPreload/g$a:EWs	J
    //   287: goto -100 -> 187
    //   290: astore 4
    //   292: aload_0
    //   293: getfield 329	com/tencent/mm/plugin/finder/preload/tabPreload/g:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   296: invokevirtual 786	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   299: aload 4
    //   301: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	g
    //   0	302	1	paramBoolean	boolean
    //   145	33	2	i	int
    //   18	258	3	bool	boolean
    //   30	149	4	localObject1	Object
    //   290	10	4	localObject2	Object
    //   153	7	5	locale	e
    //   130	44	6	locala	com.tencent.mm.plugin.finder.preload.d.a
    //   139	37	7	localg	g
    // Exception table:
    //   from	to	target	type
    //   7	17	290	finally
    //   23	32	290	finally
    //   37	44	290	finally
    //   49	83	290	finally
    //   83	92	290	finally
    //   97	104	290	finally
    //   109	118	290	finally
    //   122	155	290	finally
    //   164	173	290	finally
    //   173	187	290	finally
    //   191	241	290	finally
    //   241	265	290	finally
    //   279	287	290	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;I)V", "extInfo", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$ExtInfo;", "getExtInfo", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$ExtInfo;", "setExtInfo", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$ExtInfo;)V", "lastRedDotPreloadTime", "", "getLastRedDotPreloadTime", "()J", "setLastRedDotPreloadTime", "(J)V", "lastTime", "getLastTime", "setLastTime", "overCount", "getOverCount", "setOverCount", "records", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "recycledList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRecycledList", "()Ljava/util/LinkedList;", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "getResp", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setResp", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;)V", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getSource", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "setSource", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;)V", "getTabType", "()I", "restoreTime", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshPreloadCacheList;", "storeTime", "", "toString", "", "print", "tag", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    public aq.d BeG;
    public g.g EWo;
    g.e EWp;
    final LinkedList<FinderObject> EWq;
    long EWr;
    long EWs;
    final ConcurrentHashMap<Integer, g.b> EWt;
    final int hJx;
    long mJI;
    
    public a()
    {
      AppMethodBeat.i(346193);
      int i;
      this.hJx = i;
      this.EWq = new LinkedList();
      this.EWt = new ConcurrentHashMap();
      this$1 = eHS();
      Object localObject1 = g.this.aabR;
      s.s(localObject1, "refreshPreloadCacheList.caches");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label144:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((bty)localObject3).hJx == this.hJx) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label144;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bty)((Iterator)localObject1).next();
        ((Map)this.EWt).put(Integer.valueOf(((bty)localObject2).source), new g.b(((bty)localObject2).oEj));
      }
      a(g.this, "build");
      AppMethodBeat.o(346193);
    }
    
    public final void a(btz parambtz, String paramString)
    {
      AppMethodBeat.i(346215);
      s.u(parambtz, "<this>");
      s.u(paramString, "tag");
      String str = g.this.TAG;
      paramString = new StringBuilder("[FinderRefreshPreloadCacheList#print] tag=").append(paramString).append(' ');
      parambtz = parambtz.aabR;
      s.s(parambtz, "this.caches");
      Object localObject1 = (Iterable)parambtz;
      parambtz = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      label137:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((bty)localObject2).hJx == this.hJx) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label137;
          }
          parambtz.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)parambtz;
      parambtz = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bty)((Iterator)localObject1).next();
        parambtz.add(((bty)localObject2).hJx + ':' + ((bty)localObject2).source + "=>" + ((bty)localObject2).oEj);
      }
      Log.i(str, (List)parambtz);
      AppMethodBeat.o(346215);
    }
    
    final btz eHS()
    {
      AppMethodBeat.i(346207);
      Object localObject1 = new btz();
      Object localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adco, "");
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(346207);
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
          ((btz)localObject1).parseFrom(Util.decodeHexString((String)localObject2));
          AppMethodBeat.o(346207);
          return localObject1;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace(g.this.TAG, (Throwable)localException, "", new Object[0]);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adco, null);
          }
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(346198);
      Object localObject2 = new StringBuilder("[").append(this.EWo).append(", resp=");
      Object localObject1 = this.BeG;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = Integer.valueOf(((aq.d)localObject1).hashCode()))
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", lastTime=").append(this.mJI).append(", lastRedDotPreloadTime=").append(this.EWr).append(", overCount=").append(this.EWs).append(", recycledList=");
        Object localObject3 = (Iterable)this.EWq;
        localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(com.tencent.mm.ae.d.hF(((FinderObject)((Iterator)localObject3).next()).id));
        }
      }
      localObject1 = (List)localObject2 + ']';
      AppMethodBeat.o(346198);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Companion;", "", "()V", "IGNORE_RED_DOT_PRELOAD_FLAG", "", "getIGNORE_RED_DOT_PRELOAD_FLAG", "()Z", "IGNORE_RED_DOT_PRELOAD_FLAG$delegate", "Lkotlin/Lazy;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static boolean eHT()
    {
      AppMethodBeat.i(346202);
      boolean bool = ((Boolean)g.eHR().getValue()).booleanValue();
      AppMethodBeat.o(346202);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final d EWv;
    
    static
    {
      AppMethodBeat.i(346197);
      EWv = new d();
      AppMethodBeat.o(346197);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$ExtInfo;", "", "()V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "redDotPreloadFlag", "getRedDotPreloadFlag", "setRedDotPreloadFlag", "redDotScene", "", "getRedDotScene", "()J", "setRedDotScene", "(J)V", "tabTipsObjectId", "getTabTipsObjectId", "setTabTipsObjectId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    public long EWw;
    public long EWx;
    public int EWy;
    public int pullType;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$LoadingState;", "", "isLoading", "", "(Z)V", "()Z", "setLoading", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getSource", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "setSource", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;)V", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
  {
    public g.g EWo;
    public boolean isLoading = false;
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof f)) {
          return false;
        }
        paramObject = (f)paramObject;
      } while (this.isLoading == paramObject.isLoading);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(346199);
      String str = this.isLoading + '@' + this.EWo;
      AppMethodBeat.o(346199);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OutSideRedDot", "InsideRedDot", "OutSideTimeout", "InsideConfigNotify", "OutSideJumpHot", "EnterLoad", "InsideTimeout", "RefreshContinue", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum g
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(346208);
      EWz = new g("OutSideRedDot", 0, 1);
      EWA = new g("InsideRedDot", 1, 2);
      EWB = new g("OutSideTimeout", 2, 3);
      EWC = new g("InsideConfigNotify", 3, 4);
      EWD = new g("OutSideJumpHot", 4, 5);
      EWE = new g("EnterLoad", 5, 6);
      EWF = new g("InsideTimeout", 6, 7);
      EWG = new g("RefreshContinue", 7, 8);
      EWH = new g[] { EWz, EWA, EWB, EWC, EWD, EWE, EWF, EWG };
      AppMethodBeat.o(346208);
    }
    
    private g(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "", "(Ljava/lang/String;I)V", "LOADING", "DISABLE", "INVALID", "OK", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum h
  {
    static
    {
      AppMethodBeat.i(346203);
      EWI = new h("LOADING", 0);
      EWJ = new h("DISABLE", 1);
      EWK = new h("INVALID", 2);
      EWL = new h("OK", 3);
      EWM = new h[] { EWI, EWJ, EWK, EWL };
      AppMethodBeat.o(346203);
    }
    
    private h() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.k
    implements m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    int label;
    
    j(kotlin.g.a.b<? super g.h, ah> paramb, g paramg, g.g paramg1, com.tencent.mm.bx.b paramb1, bui parambui, LinkedList<FinderObject> paramLinkedList, boolean paramBoolean, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(346238);
      paramd = new j(this.ADV, jdField_this, paramg, this.EWO, this.EWP, this.EWQ, bool, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(346238);
      return paramObject;
    }
    
    /* Error */
    public final Object invokeSuspend(Object paramObject)
    {
      // Byte code:
      //   0: ldc 110
      //   2: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 116	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
      //   8: astore 4
      //   10: aload_0
      //   11: getfield 118	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:label	I
      //   14: tableswitch	default:+22 -> 36, 0:+39->53, 1:+188->202
      //   37: nop
      //   38: ishl
      //   39: dup
      //   40: ldc 122
      //   42: invokespecial 125	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   45: astore_1
      //   46: ldc 110
      //   48: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   51: aload_1
      //   52: athrow
      //   53: aload_1
      //   54: invokestatic 131	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   57: aload_0
      //   58: getfield 86	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:L$0	Ljava/lang/Object;
      //   61: checkcast 97	kotlinx/coroutines/aq
      //   64: astore_3
      //   65: new 11	com/tencent/mm/plugin/finder/preload/tabPreload/g$j$a
      //   68: dup
      //   69: aload_0
      //   70: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   73: aload_0
      //   74: getfield 61	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWO	Lcom/tencent/mm/bx/b;
      //   77: aload_0
      //   78: getfield 63	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWP	Lcom/tencent/mm/protocal/protobuf/bui;
      //   81: aload_0
      //   82: getfield 65	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWQ	Ljava/util/LinkedList;
      //   85: aload_0
      //   86: getfield 67	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:wdu	Z
      //   89: invokespecial 134	com/tencent/mm/plugin/finder/preload/tabPreload/g$j$a:<init>	(Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;Lcom/tencent/mm/bx/b;Lcom/tencent/mm/protocal/protobuf/bui;Ljava/util/LinkedList;Z)V
      //   92: checkcast 136	kotlin/g/a/a
      //   95: astore 5
      //   97: new 138	kotlin/g/b/ah$f
      //   100: dup
      //   101: invokespecial 141	kotlin/g/b/ah$f:<init>	()V
      //   104: astore_1
      //   105: new 138	kotlin/g/b/ah$f
      //   108: dup
      //   109: invokespecial 141	kotlin/g/b/ah$f:<init>	()V
      //   112: astore_2
      //   113: aload_2
      //   114: new 143	com/tencent/mm/plugin/finder/cgi/loadertask/b
      //   117: dup
      //   118: aload 5
      //   120: aload_3
      //   121: invokeinterface 147 1 0
      //   126: getstatic 153	kotlinx/coroutines/cb:ajws	Lkotlinx/coroutines/cb$b;
      //   129: checkcast 155	kotlin/d/f$c
      //   132: invokeinterface 161 2 0
      //   137: checkcast 149	kotlinx/coroutines/cb
      //   140: iconst_0
      //   141: invokespecial 164	com/tencent/mm/plugin/finder/cgi/loadertask/b:<init>	(Lkotlin/g/a/a;Lkotlinx/coroutines/cb;B)V
      //   144: putfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   147: aload_2
      //   148: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   151: checkcast 143	com/tencent/mm/plugin/finder/cgi/loadertask/b
      //   154: astore_3
      //   155: aload_0
      //   156: checkcast 88	kotlin/d/d
      //   159: astore 5
      //   161: aload_0
      //   162: aload_1
      //   163: putfield 86	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:L$0	Ljava/lang/Object;
      //   166: aload_0
      //   167: aload_2
      //   168: putfield 169	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:Uf	Ljava/lang/Object;
      //   171: aload_0
      //   172: aload_1
      //   173: putfield 171	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:VC	Ljava/lang/Object;
      //   176: aload_0
      //   177: iconst_1
      //   178: putfield 118	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:label	I
      //   181: aload_3
      //   182: aload 5
      //   184: invokevirtual 175	com/tencent/mm/plugin/finder/cgi/loadertask/b:X	(Lkotlin/d/d;)Ljava/lang/Object;
      //   187: astore_3
      //   188: aload_3
      //   189: aload 4
      //   191: if_acmpne +506 -> 697
      //   194: ldc 110
      //   196: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   199: aload 4
      //   201: areturn
      //   202: aload_0
      //   203: getfield 171	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:VC	Ljava/lang/Object;
      //   206: checkcast 138	kotlin/g/b/ah$f
      //   209: astore 4
      //   211: aload_0
      //   212: getfield 169	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:Uf	Ljava/lang/Object;
      //   215: checkcast 138	kotlin/g/b/ah$f
      //   218: astore_3
      //   219: aload_0
      //   220: getfield 86	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:L$0	Ljava/lang/Object;
      //   223: checkcast 138	kotlin/g/b/ah$f
      //   226: astore_2
      //   227: aload_1
      //   228: invokestatic 131	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   231: aload_1
      //   232: astore 5
      //   234: aload_3
      //   235: astore_1
      //   236: aload 4
      //   238: aload 5
      //   240: putfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   243: aload_0
      //   244: getfield 55	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:ADV	Lkotlin/g/a/b;
      //   247: getstatic 181	com/tencent/mm/plugin/finder/preload/tabPreload/g$h:EWL	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$h;
      //   250: invokeinterface 185 2 0
      //   255: pop
      //   256: aload_0
      //   257: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   260: getfield 189	com/tencent/mm/plugin/finder/preload/tabPreload/g:TAG	Ljava/lang/String;
      //   263: ldc 191
      //   265: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   268: aload_0
      //   269: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   272: getfield 200	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWm	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$f;
      //   275: getfield 205	com/tencent/mm/plugin/finder/preload/tabPreload/g$f:isLoading	Z
      //   278: ifeq +159 -> 437
      //   281: aload_0
      //   282: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   285: getfield 200	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWm	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$f;
      //   288: getfield 208	com/tencent/mm/plugin/finder/preload/tabPreload/g$f:EWo	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   291: getstatic 213	com/tencent/mm/plugin/finder/preload/tabPreload/g$g:EWG	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   294: if_acmpne +143 -> 437
      //   297: aload_0
      //   298: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   301: getfield 189	com/tencent/mm/plugin/finder/preload/tabPreload/g:TAG	Ljava/lang/String;
      //   304: ldc 215
      //   306: aload_2
      //   307: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   310: invokestatic 220	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   313: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   316: aload_2
      //   317: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   320: checkcast 222	com/tencent/mm/plugin/finder/cgi/aq$d
      //   323: astore_3
      //   324: aload_3
      //   325: ifnull +90 -> 415
      //   328: aload_0
      //   329: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   332: astore 4
      //   334: getstatic 213	com/tencent/mm/plugin/finder/preload/tabPreload/g$g:EWG	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   337: astore 5
      //   339: new 224	com/tencent/mm/plugin/finder/preload/tabPreload/g$e
      //   342: dup
      //   343: invokespecial 225	com/tencent/mm/plugin/finder/preload/tabPreload/g$e:<init>	()V
      //   346: astore 6
      //   348: aload 6
      //   350: aload_2
      //   351: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   354: checkcast 222	com/tencent/mm/plugin/finder/cgi/aq$d
      //   357: invokevirtual 229	com/tencent/mm/plugin/finder/cgi/aq$d:dVm	()Lcom/tencent/mm/plugin/finder/cgi/aq$c;
      //   360: getfield 235	com/tencent/mm/plugin/finder/cgi/aq$c:EWw	J
      //   363: putfield 236	com/tencent/mm/plugin/finder/preload/tabPreload/g$e:EWw	J
      //   366: aload 6
      //   368: aload_2
      //   369: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   372: checkcast 222	com/tencent/mm/plugin/finder/cgi/aq$d
      //   375: invokevirtual 229	com/tencent/mm/plugin/finder/cgi/aq$d:dVm	()Lcom/tencent/mm/plugin/finder/cgi/aq$c;
      //   378: getfield 239	com/tencent/mm/plugin/finder/cgi/aq$c:pullType	I
      //   381: putfield 240	com/tencent/mm/plugin/finder/preload/tabPreload/g$e:pullType	I
      //   384: getstatic 105	kotlin/ah:aiuX	Lkotlin/ah;
      //   387: astore_2
      //   388: aload 4
      //   390: aload_3
      //   391: aload 5
      //   393: iconst_0
      //   394: aload 6
      //   396: invokevirtual 244	com/tencent/mm/plugin/finder/preload/tabPreload/g:a	(Lcom/tencent/mm/plugin/finder/cgi/aq$d;Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;ILcom/tencent/mm/plugin/finder/preload/tabPreload/g$e;)V
      //   399: aload_1
      //   400: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   403: checkcast 143	com/tencent/mm/plugin/finder/cgi/loadertask/b
      //   406: astore_1
      //   407: aload_1
      //   408: ifnull +7 -> 415
      //   411: aload_1
      //   412: invokestatic 247	com/tencent/mm/plugin/finder/cgi/loadertask/b:a	(Lcom/tencent/mm/plugin/finder/cgi/loadertask/b;)V
      //   415: aload_0
      //   416: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   419: getfield 200	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWm	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$f;
      //   422: iconst_0
      //   423: putfield 205	com/tencent/mm/plugin/finder/preload/tabPreload/g$f:isLoading	Z
      //   426: getstatic 105	kotlin/ah:aiuX	Lkotlin/ah;
      //   429: astore_1
      //   430: ldc 110
      //   432: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   435: aload_1
      //   436: areturn
      //   437: aload_0
      //   438: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   441: getfield 200	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWm	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$f;
      //   444: aload_0
      //   445: getfield 59	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWN	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   448: putfield 208	com/tencent/mm/plugin/finder/preload/tabPreload/g$f:EWo	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   451: goto -36 -> 415
      //   454: astore 4
      //   456: aload_1
      //   457: astore_3
      //   458: aload_2
      //   459: astore_1
      //   460: aload 4
      //   462: astore_2
      //   463: aload_0
      //   464: getfield 55	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:ADV	Lkotlin/g/a/b;
      //   467: getstatic 181	com/tencent/mm/plugin/finder/preload/tabPreload/g$h:EWL	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$h;
      //   470: invokeinterface 185 2 0
      //   475: pop
      //   476: aload_0
      //   477: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   480: getfield 189	com/tencent/mm/plugin/finder/preload/tabPreload/g:TAG	Ljava/lang/String;
      //   483: ldc 191
      //   485: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   488: aload_0
      //   489: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   492: getfield 200	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWm	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$f;
      //   495: getfield 205	com/tencent/mm/plugin/finder/preload/tabPreload/g$f:isLoading	Z
      //   498: ifeq +158 -> 656
      //   501: aload_0
      //   502: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   505: getfield 200	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWm	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$f;
      //   508: getfield 208	com/tencent/mm/plugin/finder/preload/tabPreload/g$f:EWo	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   511: getstatic 213	com/tencent/mm/plugin/finder/preload/tabPreload/g$g:EWG	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   514: if_acmpne +142 -> 656
      //   517: aload_0
      //   518: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   521: getfield 189	com/tencent/mm/plugin/finder/preload/tabPreload/g:TAG	Ljava/lang/String;
      //   524: ldc 215
      //   526: aload_3
      //   527: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   530: invokestatic 220	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   533: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   536: aload_3
      //   537: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   540: checkcast 222	com/tencent/mm/plugin/finder/cgi/aq$d
      //   543: astore 4
      //   545: aload 4
      //   547: ifnull +91 -> 638
      //   550: aload_0
      //   551: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   554: astore 5
      //   556: getstatic 213	com/tencent/mm/plugin/finder/preload/tabPreload/g$g:EWG	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   559: astore 6
      //   561: new 224	com/tencent/mm/plugin/finder/preload/tabPreload/g$e
      //   564: dup
      //   565: invokespecial 225	com/tencent/mm/plugin/finder/preload/tabPreload/g$e:<init>	()V
      //   568: astore 7
      //   570: aload 7
      //   572: aload_3
      //   573: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   576: checkcast 222	com/tencent/mm/plugin/finder/cgi/aq$d
      //   579: invokevirtual 229	com/tencent/mm/plugin/finder/cgi/aq$d:dVm	()Lcom/tencent/mm/plugin/finder/cgi/aq$c;
      //   582: getfield 235	com/tencent/mm/plugin/finder/cgi/aq$c:EWw	J
      //   585: putfield 236	com/tencent/mm/plugin/finder/preload/tabPreload/g$e:EWw	J
      //   588: aload 7
      //   590: aload_3
      //   591: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   594: checkcast 222	com/tencent/mm/plugin/finder/cgi/aq$d
      //   597: invokevirtual 229	com/tencent/mm/plugin/finder/cgi/aq$d:dVm	()Lcom/tencent/mm/plugin/finder/cgi/aq$c;
      //   600: getfield 239	com/tencent/mm/plugin/finder/cgi/aq$c:pullType	I
      //   603: putfield 240	com/tencent/mm/plugin/finder/preload/tabPreload/g$e:pullType	I
      //   606: getstatic 105	kotlin/ah:aiuX	Lkotlin/ah;
      //   609: astore_3
      //   610: aload 5
      //   612: aload 4
      //   614: aload 6
      //   616: iconst_0
      //   617: aload 7
      //   619: invokevirtual 244	com/tencent/mm/plugin/finder/preload/tabPreload/g:a	(Lcom/tencent/mm/plugin/finder/cgi/aq$d;Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;ILcom/tencent/mm/plugin/finder/preload/tabPreload/g$e;)V
      //   622: aload_1
      //   623: getfield 167	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
      //   626: checkcast 143	com/tencent/mm/plugin/finder/cgi/loadertask/b
      //   629: astore_1
      //   630: aload_1
      //   631: ifnull +7 -> 638
      //   634: aload_1
      //   635: invokestatic 247	com/tencent/mm/plugin/finder/cgi/loadertask/b:a	(Lcom/tencent/mm/plugin/finder/cgi/loadertask/b;)V
      //   638: aload_0
      //   639: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   642: getfield 200	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWm	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$f;
      //   645: iconst_0
      //   646: putfield 205	com/tencent/mm/plugin/finder/preload/tabPreload/g$f:isLoading	Z
      //   649: ldc 110
      //   651: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   654: aload_2
      //   655: athrow
      //   656: aload_0
      //   657: getfield 57	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWu	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g;
      //   660: getfield 200	com/tencent/mm/plugin/finder/preload/tabPreload/g:EWm	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$f;
      //   663: aload_0
      //   664: getfield 59	com/tencent/mm/plugin/finder/preload/tabPreload/g$j:EWN	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   667: putfield 208	com/tencent/mm/plugin/finder/preload/tabPreload/g$f:EWo	Lcom/tencent/mm/plugin/finder/preload/tabPreload/g$g;
      //   670: goto -32 -> 638
      //   673: astore_1
      //   674: aload_2
      //   675: astore 4
      //   677: aload_1
      //   678: astore_2
      //   679: aload_3
      //   680: astore_1
      //   681: aload 4
      //   683: astore_3
      //   684: goto -221 -> 463
      //   687: astore 4
      //   689: aload_2
      //   690: astore_3
      //   691: aload 4
      //   693: astore_2
      //   694: goto -231 -> 463
      //   697: aload_2
      //   698: astore 5
      //   700: aload_1
      //   701: astore_2
      //   702: aload_1
      //   703: astore 4
      //   705: aload 5
      //   707: astore_1
      //   708: aload_3
      //   709: astore 5
      //   711: goto -475 -> 236
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	714	0	this	j
      //   0	714	1	paramObject	Object
      //   112	590	2	localObject1	Object
      //   64	645	3	localObject2	Object
      //   8	381	4	localObject3	Object
      //   454	7	4	localObject4	Object
      //   543	139	4	localObject5	Object
      //   687	5	4	localObject6	Object
      //   703	1	4	localObject7	Object
      //   95	615	5	localObject8	Object
      //   346	269	6	localObject9	Object
      //   568	50	7	locale	g.e
      // Exception table:
      //   from	to	target	type
      //   113	188	454	finally
      //   227	231	673	finally
      //   236	243	687	finally
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.cgi.aq>
    {
      a(g paramg, com.tencent.mm.bx.b paramb, bui parambui, LinkedList<FinderObject> paramLinkedList, boolean paramBoolean)
      {
        super();
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$fetchEnterLoad$1$initTask$1$cgi$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$IConfig;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "onLoadFinish", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements aq.e
      {
        a(boolean paramBoolean, g paramg) {}
        
        public final boolean a(esc paramesc)
        {
          AppMethodBeat.i(346214);
          s.u(paramesc, "resp");
          AppMethodBeat.o(346214);
          return false;
        }
        
        public final void b(aq.c paramc)
        {
          boolean bool2 = true;
          AppMethodBeat.i(346225);
          s.u(paramc, "request");
          Object localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.APW;
          com.tencent.mm.plugin.finder.extension.reddot.d.c(paramc);
          boolean bool1;
          if (this.wdu)
          {
            paramc.aaeM = 0;
            localObject1 = new bwj();
            Object localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
            if (((i)localObject2).Su("TLRecommendTab") == null) {
              break label190;
            }
            bool1 = true;
            label68:
            ((bwj)localObject1).aafq = bool1;
            if (((i)localObject2).Su("TLFollow") == null) {
              break label195;
            }
            bool1 = true;
            label86:
            ((bwj)localObject1).aafp = bool1;
            if (((i)localObject2).Su("finder_tl_hot_tab") == null) {
              break label200;
            }
            bool1 = true;
            label104:
            ((bwj)localObject1).aafo = bool1;
            if (((i)localObject2).Su("FinderEntrance") == null) {
              break label205;
            }
            bool1 = bool2;
            label122:
            ((bwj)localObject1).aafn = bool1;
            ((bwj)localObject1).aafs = 0;
            localObject2 = ah.aiuX;
            paramc.aaeY = ((bwj)localObject1);
            localObject1 = this.EWu.TAG;
            paramc = paramc.aaeY;
            if (paramc != null) {
              break label210;
            }
          }
          label190:
          label195:
          label200:
          label205:
          label210:
          for (paramc = null;; paramc = com.tencent.mm.ae.f.dh(paramc))
          {
            Log.i((String)localObject1, s.X("fetchEnterLoad: [onBuildRequest] scene_status = ", paramc));
            AppMethodBeat.o(346225);
            return;
            paramc.aaeM = 1;
            break;
            bool1 = false;
            break label68;
            bool1 = false;
            break label86;
            bool1 = false;
            break label104;
            bool1 = false;
            break label122;
          }
        }
        
        public final boolean dVn()
        {
          return false;
        }
        
        public final void dVo() {}
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$fetchEnterLoad$1$initTask$1$cgi$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class b
        implements aq.a
      {
        b(g paramg) {}
        
        public final void a(int paramInt1, int paramInt2, String paramString, aq.d paramd, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.g> paramList)
        {
          AppMethodBeat.i(346211);
          s.u(paramd, "resp");
          s.u(paramList, "interceptors");
          Log.i(this.EWu.TAG, "onCgiBack: enter load cgi back");
          AppMethodBeat.o(346211);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$outSideDelayRunnable$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends a.a
  {
    k(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(346189);
      Log.i(this.EWu.TAG, s.X("outSideDelayRunnable run... isInFinder=", Boolean.valueOf(this.EWu.EWd)));
      if (!this.EWu.EWd) {
        g.a(this.EWu, this.EWu.eHP(), (kotlin.g.a.b)new a(this.EWu));
      }
      AppMethodBeat.o(346189);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<g.h, ah>
    {
      a(g paramg)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.b<g.h, ah>
  {
    l(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class m
    extends u
    implements kotlin.g.a.b<g.h, ah>
  {
    public m(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class n
    extends u
    implements kotlin.g.a.b<g.h, ah>
  {
    public n(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$preload$3$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$IConfig;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "onLoadFinish", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements aq.e
  {
    o(boolean paramBoolean, g.g paramg, int paramInt, g paramg1, com.tencent.mm.plugin.finder.cgi.aq paramaq) {}
    
    public final boolean a(esc paramesc)
    {
      AppMethodBeat.i(346180);
      s.u(paramesc, "resp");
      AppMethodBeat.o(346180);
      return false;
    }
    
    public final void b(aq.c paramc)
    {
      boolean bool3 = true;
      boolean bool2 = true;
      AppMethodBeat.i(346191);
      s.u(paramc, "request");
      Object localObject1;
      int i;
      boolean bool1;
      label60:
      label101:
      i locali;
      if (this.wdu)
      {
        paramc.aaeM = 0;
        if (paramg != g.g.EWE)
        {
          localObject1 = b.EVP;
          i = i;
          if (paramc.EWw == 0L) {
            break label254;
          }
          bool1 = true;
          b.c(i, 1, 0, bool1, 106);
        }
        if ((paramg != g.g.EWC) && (paramg != g.g.EWF) && (paramg != g.g.EWA)) {
          break label259;
        }
        i = 1;
        localObject1 = new bwj();
        Object localObject2 = paramIntent;
        locali = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
        if (i == 0) {
          break label279;
        }
        if (locali.Su("TLRecommendTab") == null) {
          break label264;
        }
        bool1 = true;
        label145:
        ((bwj)localObject1).aafq = bool1;
        if (locali.Su("TLFollow") == null) {
          break label269;
        }
        bool1 = true;
        label163:
        ((bwj)localObject1).aafp = bool1;
        if (locali.Su("finder_tl_hot_tab") == null) {
          break label274;
        }
        bool1 = bool2;
        label182:
        ((bwj)localObject1).aafo = bool1;
        ((bwj)localObject1).aafs = ((com.tencent.mm.plugin.finder.cgi.aq)localObject2).hJx;
        localObject2 = ah.aiuX;
        paramc.aaeY = ((bwj)localObject1);
        localObject1 = jdField_this.TAG;
        paramc = paramc.aaeY;
        if (paramc != null) {
          break label312;
        }
      }
      label259:
      label264:
      label269:
      label274:
      label279:
      label312:
      for (paramc = null;; paramc = com.tencent.mm.ae.f.dh(paramc))
      {
        Log.i((String)localObject1, s.X("preload: [onBuildRequest] scene_status = ", paramc));
        AppMethodBeat.o(346191);
        return;
        paramc.aaeM = 1;
        break;
        label254:
        bool1 = false;
        break label60;
        i = 0;
        break label101;
        bool1 = false;
        break label145;
        bool1 = false;
        break label163;
        bool1 = false;
        break label182;
        if (locali.Su("FinderEntrance") != null) {}
        for (bool1 = bool3;; bool1 = false)
        {
          ((bwj)localObject1).aafn = bool1;
          ((bwj)localObject1).aafs = 0;
          break;
        }
      }
    }
    
    public final boolean dVn()
    {
      return false;
    }
    
    public final void dVo() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$preload$3$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements aq.a
  {
    p(g paramg, g.g paramg1, com.tencent.mm.plugin.finder.cgi.aq paramaq, int paramInt, com.tencent.mm.plugin.finder.extension.reddot.p paramp, kotlin.g.a.b<? super g.h, ah> paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aq.d paramd, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.g> paramList)
    {
      AppMethodBeat.i(346192);
      s.u(paramd, "resp");
      s.u(paramList, "interceptors");
      g.a(this.EWu).lock();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        Object localObject1;
        try
        {
          this.EWu.EWk.EWq.clear();
          if (this.EWu.a(paramg, paramd))
          {
            paramString = g.b(this.EWu);
            if ((paramString != null) && (paramString.otq.get() == true))
            {
              paramInt1 = 1;
              break label1030;
            }
          }
          else
          {
            paramString = this.EWu.TAG;
            paramList = new StringBuilder("[onCgiBack] tabType=").append(paramIntent.hJx).append(" throw this preload, size=").append(paramd.object.size()).append(" cache=").append(this.EWu.EWk).append(", isCancel = ");
            localObject1 = g.b(this.EWu);
            if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.cgi.aq)localObject1).otq.get() != true)) {
              continue;
            }
            bool = true;
            Log.i(paramString, bool);
            paramString = paramd.object;
            if (paramString != null)
            {
              if (((Collection)paramString).isEmpty()) {
                continue;
              }
              paramInt1 = 1;
              break label1037;
              if (paramString != null) {
                g.a(this.EWu, (List)paramString);
              }
            }
            paramString = g.b(this.EWu);
            if ((paramString == null) || (paramString.otq.get() != true)) {
              continue;
            }
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              paramString = com.tencent.mm.plugin.finder.preload.d.EUv;
              paramString = com.tencent.mm.plugin.finder.preload.d.a.EUA;
              paramList = paramg;
              paramInt2 = paramIntent.hJx;
              localObject1 = new g.e();
              paramInt1 = i;
              localObject2 = localp;
              ((g.e)localObject1).pullType = paramInt1;
              if (localObject2 != null) {
                continue;
              }
              l = 0L;
              ((g.e)localObject1).EWw = l;
              if (localObject2 != null) {
                continue;
              }
              paramInt1 = -1;
              ((g.e)localObject1).EWy = paramInt1;
              if (localObject2 != null) {
                continue;
              }
              l = 0L;
              ((g.e)localObject1).EWx = l;
              localObject2 = ah.aiuX;
              com.tencent.mm.plugin.finder.preload.d.a(paramString, paramList, paramInt2, (g.e)localObject1, g.c(this.EWu));
            }
            g.b(this.EWu, paramg);
            paramb.invoke(g.h.EWL);
            if (paramd.aafk != null)
            {
              paramList = this.EWu;
              localObject1 = paramIntent;
              localObject2 = com.tencent.mm.kernel.h.baE().ban();
              localObject3 = at.a.adcn;
              paramString = paramd.aafk;
              if (paramString != null) {
                break label1014;
              }
              paramString = null;
              label454:
              ((com.tencent.mm.storage.aq)localObject2).set((at.a)localObject3, Util.encodeHexString(paramString));
              paramList.a(((com.tencent.mm.plugin.finder.cgi.aq)localObject1).hJx, c.eHN());
            }
            this.EWu.EWm.isLoading = false;
            this.EWu.EWm.EWo = paramg;
            g.d(this.EWu);
            g.e(this.EWu).signalAll();
            g.a(this.EWu).unlock();
            AppMethodBeat.o(346192);
            return;
          }
          paramInt1 = 0;
          break label1030;
          boolean bool = false;
          continue;
          paramInt1 = 0;
          break label1037;
          paramString = null;
          continue;
          paramInt1 = 0;
          continue;
          localObject3 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2).ASz;
          if (localObject3 == null)
          {
            l = 0L;
            continue;
          }
          long l = ((btx)localObject3).object_id;
          continue;
          localObject3 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2).ASz;
          if (localObject3 == null)
          {
            paramInt1 = -1;
            continue;
          }
          paramInt1 = ((btx)localObject3).aabO;
          continue;
          l = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2).field_aiScene;
          continue;
          if (paramd.object.isEmpty()) {
            break label884;
          }
          g.a(this.EWu, paramd, paramg, i, localp);
          Log.i(this.EWu.TAG, "[onCgiBack] tabType=" + paramIntent.hJx + " preload successfully! size=" + paramd.object.size() + " cache=" + this.EWu.EWk);
          continue;
          localObject1 = this.EWu;
        }
        finally
        {
          g.b(this.EWu, paramg);
          paramb.invoke(g.h.EWL);
          if (paramd.aafk == null) {
            break label822;
          }
        }
        Object localObject2 = paramIntent;
        Object localObject3 = com.tencent.mm.kernel.h.baE().ban();
        at.a locala = at.a.adcn;
        paramString = paramd.aafk;
        if (paramString == null) {}
        for (paramString = null;; paramString = paramString.toByteArray())
        {
          ((com.tencent.mm.storage.aq)localObject3).set(locala, Util.encodeHexString(paramString));
          ((g)localObject1).a(((com.tencent.mm.plugin.finder.cgi.aq)localObject2).hJx, c.eHN());
          label822:
          this.EWu.EWm.isLoading = false;
          this.EWu.EWm.EWo = paramg;
          g.d(this.EWu);
          g.e(this.EWu).signalAll();
          g.a(this.EWu).unlock();
          AppMethodBeat.o(346192);
          throw paramList;
          label884:
          Log.e(this.EWu.TAG, "[onCgiBack] tabType=" + paramIntent.hJx + " preload fail! list is empty! cache=" + this.EWu.EWk);
          break;
          this.EWu.ta(true);
          Log.e(this.EWu.TAG, "[onCgiBack] tabType=" + paramIntent.hJx + " preload fail! errType=" + paramInt1 + " errCode=" + paramInt2 + " cache=" + this.EWu.EWk);
          break;
          label1014:
          paramString = paramString.toByteArray();
          break label454;
        }
        label1030:
        if (paramInt1 != 0)
        {
          continue;
          label1037:
          if (paramInt1 == 0) {}
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    q(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<i>
  {
    public static final r EWS;
    
    static
    {
      AppMethodBeat.i(346172);
      EWS = new r();
      AppMethodBeat.o(346172);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.b<FinderObject, Boolean>
  {
    s(ah.f<aq.d> paramf, com.tencent.mm.plugin.finder.viewmodel.h paramh, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.g
 * JD-Core Version:    0.7.0.1
 */