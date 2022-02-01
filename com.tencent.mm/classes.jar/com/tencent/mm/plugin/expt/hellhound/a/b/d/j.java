package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mClickStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "mDisAppearType", "", "mDisAppearTypeOnRefreshBegin", "mFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "Lkotlin/collections/HashMap;", "mFeedMapOnRefreshBegin", "mFeedParamCatcher", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "mLayoutManagerRef", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "mPageEntryTimestamp", "", "mRecyclerViewRef", "Landroidx/recyclerview/widget/RecyclerView;", "mRefreshEndTimestampLatested", "mRefreshTimestampOnRefresBegin", "mScene", "mScreenArea", "", "mScreenBottom", "mScreenMidX", "mScreenTop", "mScreenWidth", "mSessionPageId", "computeOnLoadMoreEnd", "", "computeOnRefreshBegin", "computeOnRefreshEnd", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "computeOnScrolled", "recyclerView", "layoutManager", "fillFeedExposureAreaWeigth", "feed", "fillItemArrayIndex", "fillItemPosition", "fillTimestamp", "timestamp", "fuckNoScrollWhenEnterActivity", "getFeedParams", "feedView", "Landroid/view/View;", "position", "getFeedWhenClick", "getFeedsOfScreen", "", "initActivityFeedParamsCatcher", "initFeedParamsCatcher", "initFragmentFeedParamsCatcher", "initScreen", "isFeedAppear", "", "isFeedDisappear", "isFeedGone", "isFeedShow", "reGetViewParams", "reGetViewsParams", "feedMap", "report19944", "reportLeftFeed", "visitingFeedIdList", "", "startCompute", "eventId", "startStatisticsByHand", "page", "statisticsFeed", "stopCompute", "stopStatisticsByHand", "Companion", "plugin-expt_release"})
public final class j
{
  public static int wnI;
  public static final j.a wnJ;
  private WeakReference<Activity> mActivityRef;
  private int mScene;
  public WeakReference<RecyclerView> whW;
  com.tencent.mm.plugin.expt.hellhound.a.a.a.b whi;
  public float wnA;
  public float wnB;
  private float wnC;
  public final c wnD;
  public WeakReference<StaggeredGridLayoutManager> wnE;
  public HashMap<String, i> wnF;
  public long wnG;
  public int wnH;
  public final HashMap<String, i> wnt;
  private String wnu;
  public long wnv;
  public final long wnw;
  public int wnx;
  private float wny;
  private float wnz;
  
  static
  {
    AppMethodBeat.i(255106);
    wnJ = new j.a((byte)0);
    AppMethodBeat.o(255106);
  }
  
  public j(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(255105);
    this.wnt = new HashMap();
    this.wnw = System.currentTimeMillis();
    if (paramActivity != null) {
      this.mActivityRef = new WeakReference(paramActivity);
    }
    this.wnu = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
    paramActivity = this.mActivityRef;
    Object localObject2;
    label132:
    int i;
    if (paramActivity != null)
    {
      paramActivity = (Activity)paramActivity.get();
      if (paramActivity != null)
      {
        try
        {
          Object localObject1 = MMApplicationContext.getContext().getSystemService("window");
          if (localObject1 != null) {
            break label611;
          }
          localObject1 = new t("null cannot be cast to non-null type android.view.WindowManager");
          AppMethodBeat.o(255105);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          localObject2 = paramActivity.getWindowManager();
          p.j(localObject2, "activity.windowManager");
          localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
        }
        Point localPoint1 = new Point();
        if ((Build.VERSION.SDK_INT >= 13) && (localObject2 != null)) {
          ((Display)localObject2).getSize(localPoint1);
        }
        Point localPoint2 = new Point();
        if ((Build.VERSION.SDK_INT >= 17) && (localObject2 != null)) {
          ((Display)localObject2).getRealSize(localPoint2);
        }
        this.wny = localPoint1.x;
        this.wnz = (this.wny / 2.0F);
        float f1 = localPoint1.y;
        i = localPoint2.y;
        float f2 = com.tencent.mm.plugin.expt.hellhound.core.b.P(paramActivity);
        int j = Math.max(com.tencent.mm.plugin.expt.hellhound.core.b.t(paramActivity), paramActivity.getResources().getDimensionPixelSize(b.b.DefaultActionbarHeightPort));
        this.wnA = (j + f2);
        this.wnB = f1;
        this.wnC = (this.wny * (this.wnB - this.wnA));
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.bf(this.wnC);
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "initScreen:\nmScreenMid=" + this.wnz + '\n' + "mScreenWidth=" + this.wny + '\n' + "screenRealHeight=" + i + '\n' + "screenHeight=" + f1 + '\n' + "statusBarHeight=" + f2 + '\n' + "actionBarHeight=" + j + '\n' + "mScreenTop=" + this.wnA + '\n' + "mScreenBottom=" + this.wnB + '\n' + "mScreenArea=" + this.wnC);
        if (paramFragment != null) {
          break label946;
        }
        paramFragment = paramActivity.getClass().getName();
        switch (paramFragment.hashCode())
        {
        default: 
          label536:
          Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + paramActivity.getClass().getName());
        }
      }
    }
    for (;;)
    {
      label565:
      this.wnD = new c(this);
      this.wnF = new HashMap();
      this.wnG = -1L;
      this.wnH = -1;
      AppMethodBeat.o(255105);
      return;
      paramActivity = null;
      break;
      label611:
      localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
      break label132;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI")) {
        break label536;
      }
      this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
      wnI = 0;
      this.mScene = c.f.wlo.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI")) {
        break label536;
      }
      this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new g(paramActivity));
      wnI = 1;
      this.mScene = c.f.wls.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI")) {
        break label536;
      }
      this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new b());
      wnI = 0;
      this.mScene = c.f.wlt.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.search.FinderMixSearchUI")) {
        break label536;
      }
      this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new e(paramActivity));
      wnI = 5;
      this.mScene = c.f.wlr.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
        break label536;
      }
      this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new h());
      wnI = 1;
      paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddY() == c.d.wlg.value) {}
      for (i = c.f.wlq.value;; i = c.f.wlp.value)
      {
        this.mScene = i;
        break label565;
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC")) {
          break;
        }
        this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        wnI = 0;
        this.mScene = c.f.wlo.value;
        break label565;
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2")) {
          break;
        }
        this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        wnI = 0;
        this.mScene = c.f.wlo.value;
        break label565;
      }
      label946:
      paramActivity = paramFragment.getClass().getName();
      switch (paramActivity.hashCode())
      {
      }
      do
      {
        Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("initFragmentFeedParamsCatcher miss !!"), "initFragmentFeedParamsCatcher miss !!", new Object[0]);
        break;
      } while (!paramActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment"));
      this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
      wnI = 0;
      this.mScene = c.f.wlo.value;
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(255090);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    if (kotlin.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddP(), parami.feedId)) {
      if (parami.bwM >= 0) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddP();
        String str = parami.feedId;
        if (str == null) {
          p.iCn();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      parami.bwM = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddP(), parami.feedId);
      AppMethodBeat.o(255090);
      return;
      AppMethodBeat.o(255090);
      return;
    }
  }
  
  public static void deo()
  {
    AppMethodBeat.i(255085);
    Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnLoadMoreEnd");
    AppMethodBeat.o(255085);
  }
  
  final void JC(long paramLong)
  {
    AppMethodBeat.i(255103);
    Object localObject1 = this.wnE;
    StaggeredGridLayoutManager localStaggeredGridLayoutManager;
    if (localObject1 != null)
    {
      localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localStaggeredGridLayoutManager != null) {}
    }
    else
    {
      AppMethodBeat.o(255103);
      return;
    }
    p.j(localStaggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
    localObject1 = this.whW;
    RecyclerView localRecyclerView;
    if (localObject1 != null)
    {
      localRecyclerView = (RecyclerView)((WeakReference)localObject1).get();
      if (localRecyclerView != null) {}
    }
    else
    {
      AppMethodBeat.o(255103);
      return;
    }
    p.j(localRecyclerView, "mRecyclerViewRef?.get() ?: return");
    localObject1 = localStaggeredGridLayoutManager.k(null);
    int i = Math.min(localObject1[0], localObject1[1]);
    localObject1 = localStaggeredGridLayoutManager.l(null);
    int j = Math.max(Math.max(localObject1[0], localObject1[1]) - wnI, 0);
    i = Math.max(i, wnI);
    int k = wnI;
    List localList = (List)new ArrayList();
    i -= k;
    if (i < j + 1)
    {
      Object localObject3 = localStaggeredGridLayoutManager.findViewByPosition(wnI + i);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.eh((View)localObject3);
        p.j(localObject2, "HellhoundUtil.getCoordinateOnScreen(feedView)");
        localObject1 = (Integer)((Pair)localObject2).first;
        localObject2 = (Integer)((Pair)localObject2).second;
        localObject3 = a((View)localObject3, i, localRecyclerView);
        if (localObject3 != null) {
          break label250;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label250:
        if (((i)localObject3).feedId != null)
        {
          String str = ((i)localObject3).feedId;
          if (str == null) {
            p.iCn();
          }
          localList.add(str);
          if (this.wnv <= 0L) {}
          for (l = this.wnw;; l = this.wnv)
          {
            ((i)localObject3).wmE = l;
            p.j(localObject1, "x");
            ((i)localObject3).x = ((Integer)localObject1).intValue();
            p.j(localObject2, "y");
            ((i)localObject3).y = ((Integer)localObject2).intValue();
            ((i)localObject3).position = i;
            b((i)localObject3);
            c((i)localObject3);
            d((i)localObject3);
            if (e((i)localObject3)) {
              break label440;
            }
            localObject1 = (Map)this.wnt;
            localObject2 = ((i)localObject3).feedId;
            if (localObject1 != null) {
              break;
            }
            localObject1 = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            AppMethodBeat.o(255103);
            throw ((Throwable)localObject1);
          }
          ag.fk(localObject1).remove(localObject2);
        }
      }
      label440:
      ((i)localObject3).wno = this.wnw;
      ((i)localObject3).wnp = paramLong;
      localObject1 = this.whi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).KI(((i)localObject3).position);
        label480:
        ((i)localObject3).wmM = com.tencent.mm.plugin.expt.hellhound.core.b.awT((String)localObject1);
        ((i)localObject3).wnr = (((i)localObject3).wnp - ((i)localObject3).wno);
        ((i)localObject3).dic = true;
        this.wnx = 1;
        ((i)localObject3).wnq = 1;
        if (((i)localObject3).wmE <= 0L) {
          if (this.wnv > 0L) {
            break label611;
          }
        }
      }
      label611:
      for (long l = this.wnw;; l = this.wnv)
      {
        ((i)localObject3).wmE = l;
        localObject2 = this.wnu;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
        }
        ((i)localObject3).sessionId = ((String)localObject1);
        ((i)localObject3).scene = this.mScene;
        ((i)localObject3).wmL = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
        break;
        localObject1 = null;
        break label480;
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    c.a.dee();
    AppMethodBeat.o(255103);
  }
  
  public final void X(Map<String, i> paramMap)
  {
    AppMethodBeat.i(255102);
    Object localObject1 = this.wnE;
    if (localObject1 != null)
    {
      localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(255102);
      return;
    }
    p.j(localObject1, "mLayoutManagerRef?.get() ?: return");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int i = wnI;
      Object localObject2 = ((StaggeredGridLayoutManager)localObject1).findViewByPosition(((i)localEntry.getValue()).position + i);
      if (localObject2 != null)
      {
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.eh((View)localObject2);
        Object localObject4 = (i)localEntry.getValue();
        Object localObject5 = ((Pair)localObject3).first;
        p.j(localObject5, "xy.first");
        ((i)localObject4).x = ((Number)localObject5).intValue();
        localObject4 = (i)localEntry.getValue();
        localObject3 = ((Pair)localObject3).second;
        p.j(localObject3, "xy.second");
        ((i)localObject4).y = ((Number)localObject3).intValue();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.ei((View)localObject2);
        localObject3 = (i)localEntry.getValue();
        localObject4 = ((Pair)localObject2).first;
        p.j(localObject4, "widthHeightPair.first");
        ((i)localObject3).width = ((Number)localObject4).floatValue();
        localObject3 = (i)localEntry.getValue();
        localObject2 = ((Pair)localObject2).second;
        p.j(localObject2, "widthHeightPair.second");
        ((i)localObject3).height = ((Number)localObject2).floatValue();
        d((i)localEntry.getValue());
      }
    }
    AppMethodBeat.o(255102);
  }
  
  public final i a(View paramView, int paramInt, RecyclerView paramRecyclerView)
  {
    com.tencent.mm.plugin.expt.hellhound.a.a.a.b localb = null;
    String str = null;
    AppMethodBeat.i(255089);
    Object localObject = this.whi;
    if (localObject != null) {
      ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).setRecyclerView(paramRecyclerView);
    }
    paramRecyclerView = this.whi;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.ae(paramView, paramInt); paramRecyclerView == null; paramRecyclerView = null)
    {
      AppMethodBeat.o(255089);
      return null;
    }
    i locali = (i)this.wnt.get(paramRecyclerView);
    if (locali == null)
    {
      locali = new i((byte)0);
      locali.feedId = paramRecyclerView;
      localObject = this.whi;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).af(paramView, paramInt);
        locali.userName = ((String)localObject);
        localObject = this.whi;
        if (localObject == null) {
          break label331;
        }
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ag(paramView, paramInt);
        label151:
        locali.nickName = ((String)localObject);
        localb = this.whi;
        localObject = str;
        if (localb != null) {
          localObject = localb.KI(paramInt);
        }
        locali.wmM = com.tencent.mm.plugin.expt.hellhound.core.b.awT((String)localObject);
        str = this.wnu;
        localObject = str;
        if (str == null) {
          localObject = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
        }
        locali.sessionId = ((String)localObject);
        locali.scene = this.mScene;
        locali.wmL = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.ei(paramView);
        localObject = paramView.first;
        p.j(localObject, "widthHeightPair.first");
        locali.width = ((Number)localObject).floatValue();
        paramView = paramView.second;
        p.j(paramView, "widthHeightPair.second");
        locali.height = ((Number)paramView).floatValue();
        ((Map)this.wnt).put(paramRecyclerView, locali);
        localObject = locali;
      }
    }
    label331:
    do
    {
      AppMethodBeat.o(255089);
      return localObject;
      localObject = null;
      break;
      localObject = null;
      break label151;
      if ((locali.wmM == null) || (locali.height <= 0.0F)) {
        break label367;
      }
      localObject = locali;
    } while (locali.y > 0);
    label367:
    locali.feedId = paramRecyclerView;
    paramRecyclerView = this.whi;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.af(paramView, paramInt);
      label391:
      locali.userName = paramRecyclerView;
      paramRecyclerView = this.whi;
      if (paramRecyclerView == null) {
        break label562;
      }
    }
    label562:
    for (paramRecyclerView = paramRecyclerView.ag(paramView, paramInt);; paramRecyclerView = null)
    {
      locali.nickName = paramRecyclerView;
      localObject = this.whi;
      paramRecyclerView = localb;
      if (localObject != null) {
        paramRecyclerView = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).KI(paramInt);
      }
      locali.wmM = com.tencent.mm.plugin.expt.hellhound.core.b.awT(paramRecyclerView);
      localObject = this.wnu;
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
      }
      locali.sessionId = paramRecyclerView;
      locali.scene = this.mScene;
      locali.wmL = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.ei(paramView);
      paramRecyclerView = paramView.first;
      p.j(paramRecyclerView, "widthHeightPair.first");
      locali.width = ((Number)paramRecyclerView).floatValue();
      paramView = paramView.second;
      p.j(paramView, "widthHeightPair.second");
      locali.height = ((Number)paramView).floatValue();
      localObject = locali;
      break;
      paramRecyclerView = null;
      break label391;
    }
  }
  
  public final void a(Map<String, i> paramMap, long paramLong)
  {
    AppMethodBeat.i(255099);
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)((Map.Entry)localIterator.next()).getValue();
      locali.wnp = paramLong;
      locali.wnr = (locali.wnp - locali.wno);
      locali.wnq = this.wnx;
      if (locali.wmE <= 0L) {
        if (this.wnv > 0L) {
          break label125;
        }
      }
      label125:
      for (long l = this.wnw;; l = this.wnv)
      {
        locali.wmE = l;
        a.a locala = a.wmq;
        a.a.a(locali);
        break;
      }
    }
    paramMap.clear();
    AppMethodBeat.o(255099);
  }
  
  public final void b(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(255087);
    if (this.wnt.isEmpty())
    {
      AppMethodBeat.o(255087);
      return;
    }
    Iterator localIterator = ((Map)this.wnt).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (i)((Map.Entry)localObject2).getValue();
      if ((!paramList.contains(localObject1)) && (((i)localObject2).wno > 0L))
      {
        ((i)localObject2).wnp = paramLong;
        ((i)localObject2).wnr = (((i)localObject2).wnp - ((i)localObject2).wno);
        this.wnx = 0;
        ((i)localObject2).wnq = this.wnx;
        if (((i)localObject2).wmE <= 0L) {
          if (this.wnv > 0L) {
            break label197;
          }
        }
        label197:
        for (long l = this.wnw;; l = this.wnv)
        {
          ((i)localObject2).wmE = l;
          localObject1 = a.wmq;
          a.a.a((i)localObject2);
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(255087);
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(255091);
    Object localObject;
    String str;
    if (parami.x <= this.wnz)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      if (!kotlin.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddQ(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddQ();
        str = parami.feedId;
        if (str == null) {
          p.iCn();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      parami.wmN = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddQ(), parami.feedId);
    }
    for (int i = 0;; i = 1)
    {
      parami.wns = i;
      AppMethodBeat.o(255091);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      if (!kotlin.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddR(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddR();
        str = parami.feedId;
        if (str == null) {
          p.iCn();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      parami.wmN = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddR(), parami.feedId);
    }
  }
  
  public final void d(i parami)
  {
    float f1 = 0.0F;
    int i = parami.y;
    float f2 = i + parami.height;
    if (i < this.wnA) {
      if (f2 > this.wnB) {
        f1 = this.wnB - this.wnA;
      }
    }
    for (;;)
    {
      parami.wmG = (f1 * 100.0F / parami.height);
      parami.wmH = (f1 * parami.width * 100.0F / this.wnC);
      return;
      if (f2 > this.wnA)
      {
        f1 = f2 - this.wnA;
        continue;
        if (f2 > this.wnB)
        {
          if (i < this.wnB) {
            f1 = this.wnB - i;
          }
        }
        else {
          f1 = parami.height;
        }
      }
    }
  }
  
  public final Map<String, i> dep()
  {
    AppMethodBeat.i(255101);
    Object localObject = new HashMap();
    ((HashMap)localObject).putAll((Map)this.wnt);
    X((Map)localObject);
    localObject = (Map)localObject;
    AppMethodBeat.o(255101);
    return localObject;
  }
  
  public final boolean e(i parami)
  {
    int i = parami.y;
    float f1 = i;
    float f2 = parami.height;
    return (i < this.wnB) && (f1 + f2 > this.wnA);
  }
  
  public final void k(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(255095);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    if (paramObject == null) {
      localObject = null;
    }
    int i;
    while (localObject == null)
    {
      AppMethodBeat.o(255095);
      return;
      i = paramObject.hashCode();
      Map localMap = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddM().get(Integer.valueOf(i));
      localObject = localMap;
      if (localMap == null) {
        localObject = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddN().get(paramObject.getClass().getName());
      }
    }
    Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startStatisticsByHand, lastFeedMap: " + ((Map)localObject).size());
    if (!((Map)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label310;
      }
      this.wnt.clear();
      this.wnt.putAll((Map)localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      if (paramObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddM().remove(Integer.valueOf(paramObject.hashCode()));
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddN().remove(paramObject.getClass().getName());
      }
      paramObject = ((Map)this.wnt).entrySet().iterator();
      label208:
      do
      {
        if (!paramObject.hasNext()) {
          break;
        }
        localObject = (i)((Map.Entry)paramObject.next()).getValue();
        ((i)localObject).wno = paramLong;
        ((i)localObject).wnp = 0L;
        ((i)localObject).wnr = 0L;
        ((i)localObject).wnq = 0;
      } while (((i)localObject).wmE > 0L);
      if (this.wnv > 0L) {
        break label301;
      }
    }
    label301:
    for (long l = this.wnw;; l = this.wnv)
    {
      ((i)localObject).wmE = l;
      break label208;
      i = 0;
      break;
    }
    label310:
    AppMethodBeat.o(255095);
  }
  
  public final void l(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(255097);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)this.wnt);
    Object localObject1 = ((Map)localHashMap).entrySet().iterator();
    Object localObject2;
    label132:
    label294:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      i locali = (i)((Map.Entry)localObject2).getValue();
      Object localObject3 = this.wnE;
      if (localObject3 != null)
      {
        localObject3 = (StaggeredGridLayoutManager)((WeakReference)localObject3).get();
        if (localObject3 != null) {
          break label132;
        }
      }
      for (;;)
      {
        if (((i)((Map.Entry)localObject2).getValue()).wmG > 0.0F) {
          break label294;
        }
        ((Iterator)localObject1).remove();
        break;
        p.j(localObject3, "mLayoutManagerRef?.get() ?: return");
        localObject3 = ((StaggeredGridLayoutManager)localObject3).findViewByPosition(wnI + locali.position);
        if (localObject3 != null)
        {
          Object localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.eh((View)localObject3);
          Object localObject5 = ((Pair)localObject4).first;
          p.j(localObject5, "xy.first");
          locali.x = ((Number)localObject5).intValue();
          localObject4 = ((Pair)localObject4).second;
          p.j(localObject4, "xy.second");
          locali.y = ((Number)localObject4).intValue();
          localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.ei((View)localObject3);
          localObject4 = ((Pair)localObject3).first;
          p.j(localObject4, "widthHeightPair.first");
          locali.width = ((Number)localObject4).floatValue();
          localObject3 = ((Pair)localObject3).second;
          p.j(localObject3, "widthHeightPair.second");
          locali.height = ((Number)localObject3).floatValue();
          d(locali);
        }
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    localObject1 = (Map)localHashMap;
    p.k(localObject1, "feedMap");
    if (paramObject != null)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddM().put(Integer.valueOf(paramObject.hashCode()), localObject1);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddN();
      paramObject = paramObject.getClass().getName();
      p.j(paramObject, "page.javaClass.name");
      ((Map)localObject2).put(paramObject, localObject1);
    }
    Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "stopStatisticsByHand, realFeedMap=" + localHashMap.size() + ", mFeedMap=" + this.wnt.size());
    a((Map)this.wnt, paramLong);
    AppMethodBeat.o(255097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.j
 * JD-Core Version:    0.7.0.1
 */