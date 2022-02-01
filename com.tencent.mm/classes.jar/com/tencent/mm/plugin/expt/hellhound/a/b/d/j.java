package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/app/Activity;Landroid/support/v4/app/Fragment;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mClickStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "mDisAppearType", "", "mDisAppearTypeOnRefreshBegin", "mFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "Lkotlin/collections/HashMap;", "mFeedMapOnRefreshBegin", "mFeedParamCatcher", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "mLayoutManagerRef", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "mPageEntryTimestamp", "", "mRecyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "mRefreshEndTimestampLatested", "mRefreshTimestampOnRefresBegin", "mScene", "mScreenArea", "", "mScreenBottom", "mScreenMidX", "mScreenTop", "mScreenWidth", "mSessionPageId", "computeOnLoadMoreEnd", "", "computeOnRefreshBegin", "computeOnRefreshEnd", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "computeOnScrolled", "recyclerView", "layoutManager", "fillFeedExposureAreaWeigth", "feed", "fillItemArrayIndex", "fillItemPosition", "fillTimestamp", "timestamp", "fuckNoScrollWhenEnterActivity", "getFeedParams", "feedView", "Landroid/view/View;", "position", "getFeedWhenClick", "getFeedsOfScreen", "", "initActivityFeedParamsCatcher", "initFeedParamsCatcher", "initFragmentFeedParamsCatcher", "initScreen", "isFeedAppear", "", "isFeedDisappear", "isFeedGone", "isFeedShow", "reGetViewParams", "reGetViewsParams", "feedMap", "report19944", "reportLeftFeed", "visitingFeedIdList", "", "startCompute", "eventId", "startStatisticsByHand", "page", "statisticsFeed", "stopCompute", "stopStatisticsByHand", "Companion", "plugin-expt_release"})
public final class j
{
  public static int sHN;
  public static final j.a sHO;
  private WeakReference<Activity> mActivityRef;
  private int mScene;
  com.tencent.mm.plugin.expt.hellhound.a.a.a.b sBo;
  public WeakReference<RecyclerView> sCb;
  public long sHA;
  public final long sHB;
  public int sHC;
  private float sHD;
  private float sHE;
  public float sHF;
  public float sHG;
  private float sHH;
  public final c sHI;
  public WeakReference<StaggeredGridLayoutManager> sHJ;
  public HashMap<String, i> sHK;
  public long sHL;
  public int sHM;
  public final HashMap<String, i> sHy;
  private String sHz;
  
  static
  {
    AppMethodBeat.i(221113);
    sHO = new j.a((byte)0);
    AppMethodBeat.o(221113);
  }
  
  public j(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(221112);
    this.sHy = new HashMap();
    this.sHB = System.currentTimeMillis();
    if (paramActivity != null) {
      this.mActivityRef = new WeakReference(paramActivity);
    }
    this.sHz = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
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
          AppMethodBeat.o(221112);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          localObject2 = paramActivity.getWindowManager();
          p.g(localObject2, "activity.windowManager");
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
        this.sHD = localPoint1.x;
        this.sHE = (this.sHD / 2.0F);
        float f1 = localPoint1.y;
        i = localPoint2.y;
        float f2 = com.tencent.mm.plugin.expt.hellhound.core.b.O(paramActivity);
        int j = Math.max(com.tencent.mm.plugin.expt.hellhound.core.b.u(paramActivity), paramActivity.getResources().getDimensionPixelSize(2131165256));
        this.sHF = (j + f2);
        this.sHG = f1;
        this.sHH = (this.sHD * (this.sHG - this.sHF));
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.bg(this.sHH);
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "initScreen:\nmScreenMid=" + this.sHE + '\n' + "mScreenWidth=" + this.sHD + '\n' + "screenRealHeight=" + i + '\n' + "screenHeight=" + f1 + '\n' + "statusBarHeight=" + f2 + '\n' + "actionBarHeight=" + j + '\n' + "mScreenTop=" + this.sHF + '\n' + "mScreenBottom=" + this.sHG + '\n' + "mScreenArea=" + this.sHH);
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
      this.sHI = new c(this);
      this.sHK = new HashMap();
      this.sHL = -1L;
      this.sHM = -1;
      AppMethodBeat.o(221112);
      return;
      paramActivity = null;
      break;
      label611:
      localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
      break label132;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI")) {
        break label536;
      }
      this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
      sHN = 0;
      this.mScene = c.f.sFt.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI")) {
        break label536;
      }
      this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new g(paramActivity));
      sHN = 1;
      this.mScene = c.f.sFx.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI")) {
        break label536;
      }
      this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new b());
      sHN = 0;
      this.mScene = c.f.sFy.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.search.FinderMixSearchUI")) {
        break label536;
      }
      this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new e(paramActivity));
      sHN = 5;
      this.mScene = c.f.sFw.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
        break label536;
      }
      this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new h());
      sHN = 1;
      paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPf() == c.d.sFl.value) {}
      for (i = c.f.sFv.value;; i = c.f.sFu.value)
      {
        this.mScene = i;
        break label565;
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC")) {
          break;
        }
        this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        sHN = 0;
        this.mScene = c.f.sFt.value;
        break label565;
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2")) {
          break;
        }
        this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        sHN = 0;
        this.mScene = c.f.sFt.value;
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
      this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
      sHN = 0;
      this.mScene = c.f.sFt.value;
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(221104);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
    if (kotlin.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOW(), parami.feedId)) {
      if (parami.kf >= 0) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOW();
        String str = parami.feedId;
        if (str == null) {
          p.hyc();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      parami.kf = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOW(), parami.feedId);
      AppMethodBeat.o(221104);
      return;
      AppMethodBeat.o(221104);
      return;
    }
  }
  
  public static void cPu()
  {
    AppMethodBeat.i(221101);
    Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnLoadMoreEnd");
    AppMethodBeat.o(221101);
  }
  
  final void Do(long paramLong)
  {
    AppMethodBeat.i(221111);
    Object localObject1 = this.sHJ;
    StaggeredGridLayoutManager localStaggeredGridLayoutManager;
    if (localObject1 != null)
    {
      localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localStaggeredGridLayoutManager != null) {}
    }
    else
    {
      AppMethodBeat.o(221111);
      return;
    }
    p.g(localStaggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
    localObject1 = this.sCb;
    RecyclerView localRecyclerView;
    if (localObject1 != null)
    {
      localRecyclerView = (RecyclerView)((WeakReference)localObject1).get();
      if (localRecyclerView != null) {}
    }
    else
    {
      AppMethodBeat.o(221111);
      return;
    }
    p.g(localRecyclerView, "mRecyclerViewRef?.get() ?: return");
    localObject1 = localStaggeredGridLayoutManager.n(null);
    int i = Math.min(localObject1[0], localObject1[1]);
    localObject1 = localStaggeredGridLayoutManager.o(null);
    int j = Math.max(Math.max(localObject1[0], localObject1[1]) - sHN, 0);
    i = Math.max(i, sHN);
    int k = sHN;
    List localList = (List)new ArrayList();
    i -= k;
    if (i < j + 1)
    {
      Object localObject3 = localStaggeredGridLayoutManager.findViewByPosition(sHN + i);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.dJ((View)localObject3);
        p.g(localObject2, "HellhoundUtil.getCoordinateOnScreen(feedView)");
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
            p.hyc();
          }
          localList.add(str);
          if (this.sHA <= 0L) {}
          for (l = this.sHB;; l = this.sHA)
          {
            ((i)localObject3).sGJ = l;
            p.g(localObject1, "x");
            ((i)localObject3).x = ((Integer)localObject1).intValue();
            p.g(localObject2, "y");
            ((i)localObject3).y = ((Integer)localObject2).intValue();
            ((i)localObject3).position = i;
            b((i)localObject3);
            c((i)localObject3);
            d((i)localObject3);
            if (e((i)localObject3)) {
              break label440;
            }
            localObject1 = (Map)this.sHy;
            localObject2 = ((i)localObject3).feedId;
            if (localObject1 != null) {
              break;
            }
            localObject1 = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            AppMethodBeat.o(221111);
            throw ((Throwable)localObject1);
          }
          af.fd(localObject1).remove(localObject2);
        }
      }
      label440:
      ((i)localObject3).sHt = this.sHB;
      ((i)localObject3).sHu = paramLong;
      localObject1 = this.sBo;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).GY(((i)localObject3).position);
        label480:
        ((i)localObject3).sGR = com.tencent.mm.plugin.expt.hellhound.core.b.aoU((String)localObject1);
        ((i)localObject3).sHw = (((i)localObject3).sHu - ((i)localObject3).sHt);
        ((i)localObject3).ddZ = true;
        this.sHC = 1;
        ((i)localObject3).sHv = 1;
        if (((i)localObject3).sGJ <= 0L) {
          if (this.sHA > 0L) {
            break label611;
          }
        }
      }
      label611:
      for (long l = this.sHB;; l = this.sHA)
      {
        ((i)localObject3).sGJ = l;
        localObject2 = this.sHz;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
        }
        ((i)localObject3).sessionId = ((String)localObject1);
        ((i)localObject3).scene = this.mScene;
        ((i)localObject3).sGQ = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
        break;
        localObject1 = null;
        break label480;
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
    c.a.cPk();
    AppMethodBeat.o(221111);
  }
  
  public final i a(View paramView, int paramInt, RecyclerView paramRecyclerView)
  {
    com.tencent.mm.plugin.expt.hellhound.a.a.a.b localb = null;
    String str = null;
    AppMethodBeat.i(221103);
    Object localObject = this.sBo;
    if (localObject != null) {
      ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).setRecyclerView(paramRecyclerView);
    }
    paramRecyclerView = this.sBo;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.ac(paramView, paramInt); paramRecyclerView == null; paramRecyclerView = null)
    {
      AppMethodBeat.o(221103);
      return null;
    }
    i locali = (i)this.sHy.get(paramRecyclerView);
    if (locali == null)
    {
      locali = new i((byte)0);
      locali.feedId = paramRecyclerView;
      localObject = this.sBo;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ad(paramView, paramInt);
        locali.userName = ((String)localObject);
        localObject = this.sBo;
        if (localObject == null) {
          break label331;
        }
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ae(paramView, paramInt);
        label151:
        locali.nickName = ((String)localObject);
        localb = this.sBo;
        localObject = str;
        if (localb != null) {
          localObject = localb.GY(paramInt);
        }
        locali.sGR = com.tencent.mm.plugin.expt.hellhound.core.b.aoU((String)localObject);
        str = this.sHz;
        localObject = str;
        if (str == null) {
          localObject = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
        }
        locali.sessionId = ((String)localObject);
        locali.scene = this.mScene;
        locali.sGQ = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.dK(paramView);
        localObject = paramView.first;
        p.g(localObject, "widthHeightPair.first");
        locali.width = ((Number)localObject).floatValue();
        paramView = paramView.second;
        p.g(paramView, "widthHeightPair.second");
        locali.height = ((Number)paramView).floatValue();
        ((Map)this.sHy).put(paramRecyclerView, locali);
        localObject = locali;
      }
    }
    label331:
    do
    {
      AppMethodBeat.o(221103);
      return localObject;
      localObject = null;
      break;
      localObject = null;
      break label151;
      if ((locali.sGR == null) || (locali.height <= 0.0F)) {
        break label367;
      }
      localObject = locali;
    } while (locali.y > 0);
    label367:
    locali.feedId = paramRecyclerView;
    paramRecyclerView = this.sBo;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.ad(paramView, paramInt);
      label391:
      locali.userName = paramRecyclerView;
      paramRecyclerView = this.sBo;
      if (paramRecyclerView == null) {
        break label562;
      }
    }
    label562:
    for (paramRecyclerView = paramRecyclerView.ae(paramView, paramInt);; paramRecyclerView = null)
    {
      locali.nickName = paramRecyclerView;
      localObject = this.sBo;
      paramRecyclerView = localb;
      if (localObject != null) {
        paramRecyclerView = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).GY(paramInt);
      }
      locali.sGR = com.tencent.mm.plugin.expt.hellhound.core.b.aoU(paramRecyclerView);
      localObject = this.sHz;
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
      }
      locali.sessionId = paramRecyclerView;
      locali.scene = this.mScene;
      locali.sGQ = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.dK(paramView);
      paramRecyclerView = paramView.first;
      p.g(paramRecyclerView, "widthHeightPair.first");
      locali.width = ((Number)paramRecyclerView).floatValue();
      paramView = paramView.second;
      p.g(paramView, "widthHeightPair.second");
      locali.height = ((Number)paramView).floatValue();
      localObject = locali;
      break;
      paramRecyclerView = null;
      break label391;
    }
  }
  
  public final void a(Map<String, i> paramMap, long paramLong)
  {
    AppMethodBeat.i(221108);
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)((Map.Entry)localIterator.next()).getValue();
      locali.sHu = paramLong;
      locali.sHw = (locali.sHu - locali.sHt);
      locali.sHv = this.sHC;
      if (locali.sGJ <= 0L) {
        if (this.sHA > 0L) {
          break label125;
        }
      }
      label125:
      for (long l = this.sHB;; l = this.sHA)
      {
        locali.sGJ = l;
        a.a locala = a.sGv;
        a.a.a(locali);
        break;
      }
    }
    paramMap.clear();
    AppMethodBeat.o(221108);
  }
  
  public final void af(Map<String, i> paramMap)
  {
    AppMethodBeat.i(221110);
    Object localObject1 = this.sHJ;
    if (localObject1 != null)
    {
      localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(221110);
      return;
    }
    p.g(localObject1, "mLayoutManagerRef?.get() ?: return");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int i = sHN;
      Object localObject2 = ((StaggeredGridLayoutManager)localObject1).findViewByPosition(((i)localEntry.getValue()).position + i);
      if (localObject2 != null)
      {
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.dJ((View)localObject2);
        Object localObject4 = (i)localEntry.getValue();
        Object localObject5 = ((Pair)localObject3).first;
        p.g(localObject5, "xy.first");
        ((i)localObject4).x = ((Number)localObject5).intValue();
        localObject4 = (i)localEntry.getValue();
        localObject3 = ((Pair)localObject3).second;
        p.g(localObject3, "xy.second");
        ((i)localObject4).y = ((Number)localObject3).intValue();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.dK((View)localObject2);
        localObject3 = (i)localEntry.getValue();
        localObject4 = ((Pair)localObject2).first;
        p.g(localObject4, "widthHeightPair.first");
        ((i)localObject3).width = ((Number)localObject4).floatValue();
        localObject3 = (i)localEntry.getValue();
        localObject2 = ((Pair)localObject2).second;
        p.g(localObject2, "widthHeightPair.second");
        ((i)localObject3).height = ((Number)localObject2).floatValue();
        d((i)localEntry.getValue());
      }
    }
    AppMethodBeat.o(221110);
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(221105);
    Object localObject;
    String str;
    if (parami.x <= this.sHE)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      if (!kotlin.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOX(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOX();
        str = parami.feedId;
        if (str == null) {
          p.hyc();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      parami.sGS = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOX(), parami.feedId);
    }
    for (int i = 0;; i = 1)
    {
      parami.sHx = i;
      AppMethodBeat.o(221105);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      if (!kotlin.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOY(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOY();
        str = parami.feedId;
        if (str == null) {
          p.hyc();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      parami.sGS = kotlin.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOY(), parami.feedId);
    }
  }
  
  public final void c(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(221102);
    if (this.sHy.isEmpty())
    {
      AppMethodBeat.o(221102);
      return;
    }
    Iterator localIterator = ((Map)this.sHy).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (i)((Map.Entry)localObject2).getValue();
      if ((!paramList.contains(localObject1)) && (((i)localObject2).sHt > 0L))
      {
        ((i)localObject2).sHu = paramLong;
        ((i)localObject2).sHw = (((i)localObject2).sHu - ((i)localObject2).sHt);
        this.sHC = 0;
        ((i)localObject2).sHv = this.sHC;
        if (((i)localObject2).sGJ <= 0L) {
          if (this.sHA > 0L) {
            break label197;
          }
        }
        label197:
        for (long l = this.sHB;; l = this.sHA)
        {
          ((i)localObject2).sGJ = l;
          localObject1 = a.sGv;
          a.a.a((i)localObject2);
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(221102);
  }
  
  public final Map<String, i> cPv()
  {
    AppMethodBeat.i(221109);
    Object localObject = new HashMap();
    ((HashMap)localObject).putAll((Map)this.sHy);
    af((Map)localObject);
    localObject = (Map)localObject;
    AppMethodBeat.o(221109);
    return localObject;
  }
  
  public final void d(i parami)
  {
    float f1 = 0.0F;
    int i = parami.y;
    float f2 = i + parami.height;
    if (i < this.sHF) {
      if (f2 > this.sHG) {
        f1 = this.sHG - this.sHF;
      }
    }
    for (;;)
    {
      parami.sGL = (f1 * 100.0F / parami.height);
      parami.sGM = (f1 * parami.width * 100.0F / this.sHH);
      return;
      if (f2 > this.sHF)
      {
        f1 = f2 - this.sHF;
        continue;
        if (f2 > this.sHG)
        {
          if (i < this.sHG) {
            f1 = this.sHG - i;
          }
        }
        else {
          f1 = parami.height;
        }
      }
    }
  }
  
  public final boolean e(i parami)
  {
    int i = parami.y;
    float f1 = i;
    float f2 = parami.height;
    return (i < this.sHG) && (f1 + f2 > this.sHF);
  }
  
  public final void n(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(221106);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
    if (paramObject == null) {
      localObject = null;
    }
    int i;
    while (localObject == null)
    {
      AppMethodBeat.o(221106);
      return;
      i = paramObject.hashCode();
      Map localMap = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOT().get(Integer.valueOf(i));
      localObject = localMap;
      if (localMap == null) {
        localObject = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOU().get(paramObject.getClass().getName());
      }
    }
    Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startStatisticsByHand, lastFeedMap: " + ((Map)localObject).size());
    if (!((Map)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label310;
      }
      this.sHy.clear();
      this.sHy.putAll((Map)localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      if (paramObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOT().remove(Integer.valueOf(paramObject.hashCode()));
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOU().remove(paramObject.getClass().getName());
      }
      paramObject = ((Map)this.sHy).entrySet().iterator();
      label208:
      do
      {
        if (!paramObject.hasNext()) {
          break;
        }
        localObject = (i)((Map.Entry)paramObject.next()).getValue();
        ((i)localObject).sHt = paramLong;
        ((i)localObject).sHu = 0L;
        ((i)localObject).sHw = 0L;
        ((i)localObject).sHv = 0;
      } while (((i)localObject).sGJ > 0L);
      if (this.sHA > 0L) {
        break label301;
      }
    }
    label301:
    for (long l = this.sHB;; l = this.sHA)
    {
      ((i)localObject).sGJ = l;
      break label208;
      i = 0;
      break;
    }
    label310:
    AppMethodBeat.o(221106);
  }
  
  public final void o(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(221107);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)this.sHy);
    Object localObject1 = ((Map)localHashMap).entrySet().iterator();
    Object localObject2;
    label132:
    label294:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      i locali = (i)((Map.Entry)localObject2).getValue();
      Object localObject3 = this.sHJ;
      if (localObject3 != null)
      {
        localObject3 = (StaggeredGridLayoutManager)((WeakReference)localObject3).get();
        if (localObject3 != null) {
          break label132;
        }
      }
      for (;;)
      {
        if (((i)((Map.Entry)localObject2).getValue()).sGL > 0.0F) {
          break label294;
        }
        ((Iterator)localObject1).remove();
        break;
        p.g(localObject3, "mLayoutManagerRef?.get() ?: return");
        localObject3 = ((StaggeredGridLayoutManager)localObject3).findViewByPosition(sHN + locali.position);
        if (localObject3 != null)
        {
          Object localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.dJ((View)localObject3);
          Object localObject5 = ((Pair)localObject4).first;
          p.g(localObject5, "xy.first");
          locali.x = ((Number)localObject5).intValue();
          localObject4 = ((Pair)localObject4).second;
          p.g(localObject4, "xy.second");
          locali.y = ((Number)localObject4).intValue();
          localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.dK((View)localObject3);
          localObject4 = ((Pair)localObject3).first;
          p.g(localObject4, "widthHeightPair.first");
          locali.width = ((Number)localObject4).floatValue();
          localObject3 = ((Pair)localObject3).second;
          p.g(localObject3, "widthHeightPair.second");
          locali.height = ((Number)localObject3).floatValue();
          d(locali);
        }
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
    localObject1 = (Map)localHashMap;
    p.h(localObject1, "feedMap");
    if (paramObject != null)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOT().put(Integer.valueOf(paramObject.hashCode()), localObject1);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOU();
      paramObject = paramObject.getClass().getName();
      p.g(paramObject, "page.javaClass.name");
      ((Map)localObject2).put(paramObject, localObject1);
    }
    Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "stopStatisticsByHand, realFeedMap=" + localHashMap.size() + ", mFeedMap=" + this.sHy.size());
    a((Map)this.sHy, paramLong);
    AppMethodBeat.o(221107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.j
 * JD-Core Version:    0.7.0.1
 */