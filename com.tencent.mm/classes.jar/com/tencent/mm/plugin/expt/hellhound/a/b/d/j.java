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
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/app/Activity;Landroid/support/v4/app/Fragment;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mClickStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "mDisAppearType", "", "mDisAppearTypeOnRefreshBegin", "mFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "Lkotlin/collections/HashMap;", "mFeedMapOnRefreshBegin", "mFeedParamCatcher", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "mLayoutManagerRef", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "mPageEntryTimestamp", "", "mRecyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "mRefreshEndTimestampLatested", "mRefreshTimestampOnRefresBegin", "mScene", "mScreenArea", "", "mScreenBottom", "mScreenMidX", "mScreenTop", "mScreenWidth", "mSessionPageId", "computeOnLoadMoreEnd", "", "computeOnRefreshBegin", "computeOnRefreshEnd", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "computeOnScrolled", "recyclerView", "layoutManager", "fillFeedExposureAreaWeigth", "feed", "fillItemArrayIndex", "fillItemPosition", "fillTimestamp", "timestamp", "fuckNoScrollWhenEnterActivity", "getFeedParams", "feedView", "Landroid/view/View;", "position", "getFeedWhenClick", "getFeedsOfScreen", "", "initActivityFeedParamsCatcher", "initFeedParamsCatcher", "initFragmentFeedParamsCatcher", "initScreen", "isFeedAppear", "", "isFeedDisappear", "isFeedGone", "isFeedShow", "reGetViewParams", "reGetViewsParams", "feedMap", "report19944", "reportLeftFeed", "visitingFeedIdList", "", "startCompute", "eventId", "startStatisticsByHand", "page", "statisticsFeed", "stopCompute", "stopStatisticsByHand", "Companion", "plugin-expt_release"})
public final class j
{
  public static int qYl;
  public static final j.a qYm;
  private WeakReference<Activity> mActivityRef;
  private int mScene;
  com.tencent.mm.plugin.expt.hellhound.a.a.a.b qSZ;
  public WeakReference<RecyclerView> qTE;
  public final HashMap<String, i> qXW;
  private String qXX;
  public long qXY;
  public final long qXZ;
  public int qYa;
  private float qYb;
  private float qYc;
  public float qYd;
  public float qYe;
  private float qYf;
  public final c qYg;
  public WeakReference<StaggeredGridLayoutManager> qYh;
  public HashMap<String, i> qYi;
  public long qYj;
  public int qYk;
  
  static
  {
    AppMethodBeat.i(210950);
    qYm = new j.a((byte)0);
    AppMethodBeat.o(210950);
  }
  
  public j(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(210949);
    this.qXW = new HashMap();
    this.qXZ = System.currentTimeMillis();
    if (paramActivity != null) {
      this.mActivityRef = new WeakReference(paramActivity);
    }
    this.qXX = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
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
          Object localObject1 = aj.getContext().getSystemService("window");
          if (localObject1 != null) {
            break label546;
          }
          localObject1 = new v("null cannot be cast to non-null type android.view.WindowManager");
          AppMethodBeat.o(210949);
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
        this.qYb = localPoint1.x;
        this.qYc = (this.qYb / 2.0F);
        float f1 = localPoint1.y;
        i = localPoint2.y;
        float f2 = com.tencent.mm.plugin.expt.hellhound.core.b.P(paramActivity);
        int j = Math.max(com.tencent.mm.plugin.expt.hellhound.core.b.u(paramActivity), paramActivity.getResources().getDimensionPixelSize(2131165252));
        this.qYd = (j + f2);
        this.qYe = f1;
        this.qYf = (this.qYb * (this.qYe - this.qYd));
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aZ(this.qYf);
        ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "initScreen:\nmScreenMid=" + this.qYc + '\n' + "mScreenWidth=" + this.qYb + '\n' + "screenRealHeight=" + i + '\n' + "screenHeight=" + f1 + '\n' + "statusBarHeight=" + f2 + '\n' + "actionBarHeight=" + j + '\n' + "mScreenTop=" + this.qYd + '\n' + "mScreenBottom=" + this.qYe + '\n' + "mScreenArea=" + this.qYf);
        if (paramFragment != null) {
          break label955;
        }
        paramFragment = paramActivity.getClass().getName();
        if (paramFragment != null) {
          break label561;
        }
        ad.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + paramActivity.getClass().getName());
      }
    }
    for (;;)
    {
      label500:
      this.qYg = new c(this);
      this.qYi = new HashMap();
      this.qYj = -1L;
      this.qYk = -1;
      AppMethodBeat.o(210949);
      return;
      paramActivity = null;
      break;
      label546:
      localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
      break label132;
      label561:
      switch (paramFragment.hashCode())
      {
      default: 
        break;
      case -1796598533: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI")) {
          break;
        }
        this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        qYl = 0;
        this.mScene = c.d.qWg.value;
        break;
      case 395150120: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI")) {
          break;
        }
        this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new g(paramActivity));
        qYl = 1;
        this.mScene = c.d.qWk.value;
        break;
      case -1570624296: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI")) {
          break;
        }
        this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new b());
        qYl = 0;
        this.mScene = c.d.qWl.value;
        break;
      case 1251839313: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.search.FinderMixSearchUI")) {
          break;
        }
        this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new e(paramActivity));
        qYl = 5;
        this.mScene = c.d.qWj.value;
        break;
      case 782364972: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
          break;
        }
        this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new h());
        qYl = 1;
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
        if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cpb() != c.c.qWe.value) {}
      case 786042180: 
      case -1577760806: 
        for (i = c.d.qWi.value;; i = c.d.qWh.value)
        {
          this.mScene = i;
          break label500;
          if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC")) {
            break;
          }
          this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
          qYl = 0;
          this.mScene = c.d.qWg.value;
          break label500;
          if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2")) {
            break;
          }
          this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
          qYl = 0;
          this.mScene = c.d.qWg.value;
          break label500;
        }
        label955:
        paramActivity = paramFragment.getClass().getName();
        if (paramActivity == null) {}
        do
        {
          for (;;)
          {
            ad.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("initFragmentFeedParamsCatcher miss !!"), "initFragmentFeedParamsCatcher miss !!", new Object[0]);
            break;
            switch (paramActivity.hashCode())
            {
            }
          }
        } while (!paramActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment"));
        this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        qYl = 0;
        this.mScene = c.d.qWg.value;
      }
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(210941);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
    if (d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coS(), parami.feedId)) {
      if (parami.kd >= 0) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coS();
        String str = parami.feedId;
        if (str == null) {
          p.gfZ();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
      parami.kd = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coS(), parami.feedId);
      AppMethodBeat.o(210941);
      return;
      AppMethodBeat.o(210941);
      return;
    }
  }
  
  public static void cpk()
  {
    AppMethodBeat.i(210938);
    ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnLoadMoreEnd");
    AppMethodBeat.o(210938);
  }
  
  public final void W(Map<String, i> paramMap)
  {
    AppMethodBeat.i(210947);
    Object localObject1 = this.qYh;
    if (localObject1 != null)
    {
      localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(210947);
      return;
    }
    p.g(localObject1, "mLayoutManagerRef?.get() ?: return");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int i = qYl;
      Object localObject2 = ((StaggeredGridLayoutManager)localObject1).bY(((i)localEntry.getValue()).position + i);
      if (localObject2 != null)
      {
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.dR((View)localObject2);
        Object localObject4 = (i)localEntry.getValue();
        Object localObject5 = ((Pair)localObject3).first;
        p.g(localObject5, "xy.first");
        ((i)localObject4).x = ((Number)localObject5).intValue();
        localObject4 = (i)localEntry.getValue();
        localObject3 = ((Pair)localObject3).second;
        p.g(localObject3, "xy.second");
        ((i)localObject4).y = ((Number)localObject3).intValue();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.dS((View)localObject2);
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
    AppMethodBeat.o(210947);
  }
  
  public final i a(View paramView, int paramInt, RecyclerView paramRecyclerView)
  {
    com.tencent.mm.plugin.expt.hellhound.a.a.a.b localb = null;
    String str = null;
    AppMethodBeat.i(210940);
    Object localObject = this.qSZ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).setRecyclerView(paramRecyclerView);
    }
    paramRecyclerView = this.qSZ;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.ad(paramView, paramInt); paramRecyclerView == null; paramRecyclerView = null)
    {
      AppMethodBeat.o(210940);
      return null;
    }
    i locali = (i)this.qXW.get(paramRecyclerView);
    if (locali == null)
    {
      locali = new i((byte)0);
      locali.feedId = paramRecyclerView;
      localObject = this.qSZ;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ae(paramView, paramInt);
        locali.userName = ((String)localObject);
        localObject = this.qSZ;
        if (localObject == null) {
          break label331;
        }
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).af(paramView, paramInt);
        label151:
        locali.bVF = ((String)localObject);
        localb = this.qSZ;
        localObject = str;
        if (localb != null) {
          localObject = localb.Da(paramInt);
        }
        locali.qXv = com.tencent.mm.plugin.expt.hellhound.core.b.adN((String)localObject);
        str = this.qXX;
        localObject = str;
        if (str == null) {
          localObject = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
        }
        locali.sessionId = ((String)localObject);
        locali.scene = this.mScene;
        locali.qXu = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.dS(paramView);
        localObject = paramView.first;
        p.g(localObject, "widthHeightPair.first");
        locali.width = ((Number)localObject).floatValue();
        paramView = paramView.second;
        p.g(paramView, "widthHeightPair.second");
        locali.height = ((Number)paramView).floatValue();
        ((Map)this.qXW).put(paramRecyclerView, locali);
        localObject = locali;
      }
    }
    label331:
    do
    {
      AppMethodBeat.o(210940);
      return localObject;
      localObject = null;
      break;
      localObject = null;
      break label151;
      if ((locali.qXv == null) || (locali.height <= 0.0F)) {
        break label367;
      }
      localObject = locali;
    } while (locali.y > 0);
    label367:
    locali.feedId = paramRecyclerView;
    paramRecyclerView = this.qSZ;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.ae(paramView, paramInt);
      label391:
      locali.userName = paramRecyclerView;
      paramRecyclerView = this.qSZ;
      if (paramRecyclerView == null) {
        break label562;
      }
    }
    label562:
    for (paramRecyclerView = paramRecyclerView.af(paramView, paramInt);; paramRecyclerView = null)
    {
      locali.bVF = paramRecyclerView;
      localObject = this.qSZ;
      paramRecyclerView = localb;
      if (localObject != null) {
        paramRecyclerView = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).Da(paramInt);
      }
      locali.qXv = com.tencent.mm.plugin.expt.hellhound.core.b.adN(paramRecyclerView);
      localObject = this.qXX;
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
      }
      locali.sessionId = paramRecyclerView;
      locali.scene = this.mScene;
      locali.qXu = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.dS(paramView);
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
  
  public final void a(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(210943);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
    if (paramObject == null) {
      localObject = null;
    }
    int i;
    while (localObject == null)
    {
      AppMethodBeat.o(210943);
      return;
      i = paramObject.hashCode();
      Map localMap = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coP().get(Integer.valueOf(i));
      localObject = localMap;
      if (localMap == null) {
        localObject = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coQ().get(paramObject.getClass().getName());
      }
    }
    ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startStatisticsByHand, lastFeedMap: " + ((Map)localObject).size());
    if (!((Map)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label310;
      }
      this.qXW.clear();
      this.qXW.putAll((Map)localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
      if (paramObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coP().remove(Integer.valueOf(paramObject.hashCode()));
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coQ().remove(paramObject.getClass().getName());
      }
      paramObject = ((Map)this.qXW).entrySet().iterator();
      label208:
      do
      {
        if (!paramObject.hasNext()) {
          break;
        }
        localObject = (i)((Map.Entry)paramObject.next()).getValue();
        ((i)localObject).qXR = paramLong;
        ((i)localObject).qXS = 0L;
        ((i)localObject).qXU = 0L;
        ((i)localObject).qXT = 0;
      } while (((i)localObject).qXn > 0L);
      if (this.qXY > 0L) {
        break label301;
      }
    }
    label301:
    for (long l = this.qXZ;; l = this.qXY)
    {
      ((i)localObject).qXn = l;
      break label208;
      i = 0;
      break;
    }
    label310:
    AppMethodBeat.o(210943);
  }
  
  public final void a(Map<String, i> paramMap, long paramLong)
  {
    AppMethodBeat.i(210945);
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)((Map.Entry)localIterator.next()).getValue();
      locali.qXS = paramLong;
      locali.qXU = (locali.qXS - locali.qXR);
      locali.qXT = this.qYa;
      if (locali.qXn <= 0L) {
        if (this.qXY > 0L) {
          break label125;
        }
      }
      label125:
      for (long l = this.qXZ;; l = this.qXY)
      {
        locali.qXn = l;
        a.a locala = a.qXa;
        a.a.a(locali);
        break;
      }
    }
    paramMap.clear();
    AppMethodBeat.o(210945);
  }
  
  public final void b(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(210944);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)this.qXW);
    Object localObject1 = ((Map)localHashMap).entrySet().iterator();
    Object localObject2;
    label132:
    label294:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      i locali = (i)((Map.Entry)localObject2).getValue();
      Object localObject3 = this.qYh;
      if (localObject3 != null)
      {
        localObject3 = (StaggeredGridLayoutManager)((WeakReference)localObject3).get();
        if (localObject3 != null) {
          break label132;
        }
      }
      for (;;)
      {
        if (((i)((Map.Entry)localObject2).getValue()).qXp > 0.0F) {
          break label294;
        }
        ((Iterator)localObject1).remove();
        break;
        p.g(localObject3, "mLayoutManagerRef?.get() ?: return");
        localObject3 = ((StaggeredGridLayoutManager)localObject3).bY(qYl + locali.position);
        if (localObject3 != null)
        {
          Object localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.dR((View)localObject3);
          Object localObject5 = ((Pair)localObject4).first;
          p.g(localObject5, "xy.first");
          locali.x = ((Number)localObject5).intValue();
          localObject4 = ((Pair)localObject4).second;
          p.g(localObject4, "xy.second");
          locali.y = ((Number)localObject4).intValue();
          localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.dS((View)localObject3);
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
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
    localObject1 = (Map)localHashMap;
    p.h(localObject1, "feedMap");
    if (paramObject != null)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coP().put(Integer.valueOf(paramObject.hashCode()), localObject1);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coQ();
      paramObject = paramObject.getClass().getName();
      p.g(paramObject, "page.javaClass.name");
      ((Map)localObject2).put(paramObject, localObject1);
    }
    ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "stopStatisticsByHand, realFeedMap=" + localHashMap.size() + ", mFeedMap=" + this.qXW.size());
    a((Map)this.qXW, paramLong);
    AppMethodBeat.o(210944);
  }
  
  public final void b(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(210939);
    if (this.qXW.isEmpty())
    {
      AppMethodBeat.o(210939);
      return;
    }
    Iterator localIterator = ((Map)this.qXW).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (i)((Map.Entry)localObject2).getValue();
      if ((!paramList.contains(localObject1)) && (((i)localObject2).qXR > 0L))
      {
        ((i)localObject2).qXS = paramLong;
        ((i)localObject2).qXU = (((i)localObject2).qXS - ((i)localObject2).qXR);
        this.qYa = 0;
        ((i)localObject2).qXT = this.qYa;
        if (((i)localObject2).qXn <= 0L) {
          if (this.qXY > 0L) {
            break label197;
          }
        }
        label197:
        for (long l = this.qXZ;; l = this.qXY)
        {
          ((i)localObject2).qXn = l;
          localObject1 = a.qXa;
          a.a.a((i)localObject2);
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(210939);
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(210942);
    Object localObject;
    String str;
    if (parami.x <= this.qYc)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
      if (!d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coT(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coT();
        str = parami.feedId;
        if (str == null) {
          p.gfZ();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
      parami.qXw = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coT(), parami.feedId);
    }
    for (int i = 0;; i = 1)
    {
      parami.qXV = i;
      AppMethodBeat.o(210942);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
      if (!d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coU(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coU();
        str = parami.feedId;
        if (str == null) {
          p.gfZ();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
      parami.qXw = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coU(), parami.feedId);
    }
  }
  
  public final Map<String, i> cpl()
  {
    AppMethodBeat.i(210946);
    Object localObject = new HashMap();
    ((HashMap)localObject).putAll((Map)this.qXW);
    W((Map)localObject);
    localObject = (Map)localObject;
    AppMethodBeat.o(210946);
    return localObject;
  }
  
  public final void d(i parami)
  {
    float f1 = 0.0F;
    int i = parami.y;
    float f2 = i + parami.height;
    if (i < this.qYd) {
      if (f2 > this.qYe) {
        f1 = this.qYe - this.qYd;
      }
    }
    for (;;)
    {
      parami.qXp = (f1 * 100.0F / parami.height);
      parami.qXq = (f1 * parami.width * 100.0F / this.qYf);
      return;
      if (f2 > this.qYd)
      {
        f1 = f2 - this.qYd;
        continue;
        if (f2 > this.qYe)
        {
          if (i < this.qYe) {
            f1 = this.qYe - i;
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
    return (i < this.qYe) && (f1 + f2 > this.qYd);
  }
  
  final void uT(long paramLong)
  {
    AppMethodBeat.i(210948);
    Object localObject1 = this.qYh;
    StaggeredGridLayoutManager localStaggeredGridLayoutManager;
    if (localObject1 != null)
    {
      localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localStaggeredGridLayoutManager != null) {}
    }
    else
    {
      AppMethodBeat.o(210948);
      return;
    }
    p.g(localStaggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
    localObject1 = this.qTE;
    RecyclerView localRecyclerView;
    if (localObject1 != null)
    {
      localRecyclerView = (RecyclerView)((WeakReference)localObject1).get();
      if (localRecyclerView != null) {}
    }
    else
    {
      AppMethodBeat.o(210948);
      return;
    }
    p.g(localRecyclerView, "mRecyclerViewRef?.get() ?: return");
    localObject1 = localStaggeredGridLayoutManager.n(null);
    int i = Math.min(localObject1[0], localObject1[1]);
    localObject1 = localStaggeredGridLayoutManager.mA();
    int j = Math.max(Math.max(localObject1[0], localObject1[1]) - qYl, 0);
    i = Math.max(i, qYl);
    int k = qYl;
    List localList = (List)new ArrayList();
    i -= k;
    if (i < j + 1)
    {
      Object localObject3 = localStaggeredGridLayoutManager.bY(qYl + i);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.dR((View)localObject3);
        p.g(localObject2, "HellhoundUtil.getCoordinateOnScreen(feedView)");
        localObject1 = (Integer)((Pair)localObject2).first;
        localObject2 = (Integer)((Pair)localObject2).second;
        localObject3 = a((View)localObject3, i, localRecyclerView);
        if (localObject3 != null) {
          break label249;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label249:
        if (((i)localObject3).feedId != null)
        {
          String str = ((i)localObject3).feedId;
          if (str == null) {
            p.gfZ();
          }
          localList.add(str);
          if (this.qXY <= 0L) {}
          for (l = this.qXZ;; l = this.qXY)
          {
            ((i)localObject3).qXn = l;
            p.g(localObject1, "x");
            ((i)localObject3).x = ((Integer)localObject1).intValue();
            p.g(localObject2, "y");
            ((i)localObject3).y = ((Integer)localObject2).intValue();
            ((i)localObject3).position = i;
            b((i)localObject3);
            c((i)localObject3);
            d((i)localObject3);
            if (e((i)localObject3)) {
              break label439;
            }
            localObject1 = (Map)this.qXW;
            localObject2 = ((i)localObject3).feedId;
            if (localObject1 != null) {
              break;
            }
            localObject1 = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            AppMethodBeat.o(210948);
            throw ((Throwable)localObject1);
          }
          ae.eV(localObject1).remove(localObject2);
        }
      }
      label439:
      ((i)localObject3).qXR = this.qXZ;
      ((i)localObject3).qXS = paramLong;
      localObject1 = this.qSZ;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).Da(((i)localObject3).position);
        label479:
        ((i)localObject3).qXv = com.tencent.mm.plugin.expt.hellhound.core.b.adN((String)localObject1);
        ((i)localObject3).qXU = (((i)localObject3).qXS - ((i)localObject3).qXR);
        ((i)localObject3).cMS = true;
        this.qYa = 1;
        ((i)localObject3).qXT = 1;
        if (((i)localObject3).qXn <= 0L) {
          if (this.qXY > 0L) {
            break label610;
          }
        }
      }
      label610:
      for (long l = this.qXZ;; l = this.qXY)
      {
        ((i)localObject3).qXn = l;
        localObject2 = this.qXX;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
        }
        ((i)localObject3).sessionId = ((String)localObject1);
        ((i)localObject3).scene = this.mScene;
        ((i)localObject3).qXu = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
        break;
        localObject1 = null;
        break label479;
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
    c.a.cpd();
    AppMethodBeat.o(210948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.j
 * JD-Core Version:    0.7.0.1
 */