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
import com.tencent.mm.sdk.platformtools.ak;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/app/Activity;Landroid/support/v4/app/Fragment;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mClickStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "mDisAppearType", "", "mDisAppearTypeOnRefreshBegin", "mFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "Lkotlin/collections/HashMap;", "mFeedMapOnRefreshBegin", "mFeedParamCatcher", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "mLayoutManagerRef", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "mPageEntryTimestamp", "", "mRecyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "mRefreshEndTimestampLatested", "mRefreshTimestampOnRefresBegin", "mScene", "mScreenArea", "", "mScreenBottom", "mScreenMidX", "mScreenTop", "mScreenWidth", "mSessionPageId", "computeOnLoadMoreEnd", "", "computeOnRefreshBegin", "computeOnRefreshEnd", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "computeOnScrolled", "recyclerView", "layoutManager", "fillFeedExposureAreaWeigth", "feed", "fillItemArrayIndex", "fillItemPosition", "fillTimestamp", "timestamp", "fuckNoScrollWhenEnterActivity", "getFeedParams", "feedView", "Landroid/view/View;", "position", "getFeedWhenClick", "getFeedsOfScreen", "", "initActivityFeedParamsCatcher", "initFeedParamsCatcher", "initFragmentFeedParamsCatcher", "initScreen", "isFeedAppear", "", "isFeedDisappear", "isFeedGone", "isFeedShow", "reGetViewParams", "reGetViewsParams", "feedMap", "report19944", "reportLeftFeed", "visitingFeedIdList", "", "startCompute", "eventId", "startStatisticsByHand", "page", "statisticsFeed", "stopCompute", "stopStatisticsByHand", "Companion", "plugin-expt_release"})
public final class j
{
  public static int rgr;
  public static final j.a rgs;
  private WeakReference<Activity> mActivityRef;
  private int mScene;
  com.tencent.mm.plugin.expt.hellhound.a.a.a.b raX;
  public WeakReference<RecyclerView> rbC;
  public final HashMap<String, i> rgc;
  private String rgd;
  public long rge;
  public final long rgf;
  public int rgg;
  private float rgh;
  private float rgi;
  public float rgj;
  public float rgk;
  private float rgl;
  public final c rgm;
  public WeakReference<StaggeredGridLayoutManager> rgn;
  public HashMap<String, i> rgo;
  public long rgp;
  public int rgq;
  
  static
  {
    AppMethodBeat.i(196621);
    rgs = new j.a((byte)0);
    AppMethodBeat.o(196621);
  }
  
  public j(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(196620);
    this.rgc = new HashMap();
    this.rgf = System.currentTimeMillis();
    if (paramActivity != null) {
      this.mActivityRef = new WeakReference(paramActivity);
    }
    this.rgd = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
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
          Object localObject1 = ak.getContext().getSystemService("window");
          if (localObject1 != null) {
            break label546;
          }
          localObject1 = new v("null cannot be cast to non-null type android.view.WindowManager");
          AppMethodBeat.o(196620);
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
        this.rgh = localPoint1.x;
        this.rgi = (this.rgh / 2.0F);
        float f1 = localPoint1.y;
        i = localPoint2.y;
        float f2 = com.tencent.mm.plugin.expt.hellhound.core.b.Q(paramActivity);
        int j = Math.max(com.tencent.mm.plugin.expt.hellhound.core.b.u(paramActivity), paramActivity.getResources().getDimensionPixelSize(2131165252));
        this.rgj = (j + f2);
        this.rgk = f1;
        this.rgl = (this.rgh * (this.rgk - this.rgj));
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aZ(this.rgl);
        com.tencent.mm.sdk.platformtools.ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "initScreen:\nmScreenMid=" + this.rgi + '\n' + "mScreenWidth=" + this.rgh + '\n' + "screenRealHeight=" + i + '\n' + "screenHeight=" + f1 + '\n' + "statusBarHeight=" + f2 + '\n' + "actionBarHeight=" + j + '\n' + "mScreenTop=" + this.rgj + '\n' + "mScreenBottom=" + this.rgk + '\n' + "mScreenArea=" + this.rgl);
        if (paramFragment != null) {
          break label955;
        }
        paramFragment = paramActivity.getClass().getName();
        if (paramFragment != null) {
          break label561;
        }
        com.tencent.mm.sdk.platformtools.ae.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + paramActivity.getClass().getName());
      }
    }
    for (;;)
    {
      label500:
      this.rgm = new c(this);
      this.rgo = new HashMap();
      this.rgp = -1L;
      this.rgq = -1;
      AppMethodBeat.o(196620);
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
        this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        rgr = 0;
        this.mScene = c.d.reg.value;
        break;
      case 395150120: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI")) {
          break;
        }
        this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new g(paramActivity));
        rgr = 1;
        this.mScene = c.d.rek.value;
        break;
      case -1570624296: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI")) {
          break;
        }
        this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new b());
        rgr = 0;
        this.mScene = c.d.rel.value;
        break;
      case 1251839313: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.search.FinderMixSearchUI")) {
          break;
        }
        this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new e(paramActivity));
        rgr = 5;
        this.mScene = c.d.rej.value;
        break;
      case 782364972: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
          break;
        }
        this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new h());
        rgr = 1;
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
        if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqD() != c.c.red.value) {}
      case 786042180: 
      case -1577760806: 
        for (i = c.d.rei.value;; i = c.d.reh.value)
        {
          this.mScene = i;
          break label500;
          if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC")) {
            break;
          }
          this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
          rgr = 0;
          this.mScene = c.d.reg.value;
          break label500;
          if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2")) {
            break;
          }
          this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
          rgr = 0;
          this.mScene = c.d.reg.value;
          break label500;
        }
        label955:
        paramActivity = paramFragment.getClass().getName();
        if (paramActivity == null) {}
        do
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("initFragmentFeedParamsCatcher miss !!"), "initFragmentFeedParamsCatcher miss !!", new Object[0]);
            break;
            switch (paramActivity.hashCode())
            {
            }
          }
        } while (!paramActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment"));
        this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        rgr = 0;
        this.mScene = c.d.reg.value;
      }
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(196612);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
    if (d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqu(), parami.feedId)) {
      if (parami.kd >= 0) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqu();
        String str = parami.feedId;
        if (str == null) {
          p.gkB();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
      parami.kd = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqu(), parami.feedId);
      AppMethodBeat.o(196612);
      return;
      AppMethodBeat.o(196612);
      return;
    }
  }
  
  public static void cqM()
  {
    AppMethodBeat.i(196609);
    com.tencent.mm.sdk.platformtools.ae.d("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnLoadMoreEnd");
    AppMethodBeat.o(196609);
  }
  
  public final i a(View paramView, int paramInt, RecyclerView paramRecyclerView)
  {
    com.tencent.mm.plugin.expt.hellhound.a.a.a.b localb = null;
    String str = null;
    AppMethodBeat.i(196611);
    Object localObject = this.raX;
    if (localObject != null) {
      ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).setRecyclerView(paramRecyclerView);
    }
    paramRecyclerView = this.raX;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.ad(paramView, paramInt); paramRecyclerView == null; paramRecyclerView = null)
    {
      AppMethodBeat.o(196611);
      return null;
    }
    i locali = (i)this.rgc.get(paramRecyclerView);
    if (locali == null)
    {
      locali = new i((byte)0);
      locali.feedId = paramRecyclerView;
      localObject = this.raX;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ae(paramView, paramInt);
        locali.userName = ((String)localObject);
        localObject = this.raX;
        if (localObject == null) {
          break label331;
        }
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).af(paramView, paramInt);
        label151:
        locali.bVF = ((String)localObject);
        localb = this.raX;
        localObject = str;
        if (localb != null) {
          localObject = localb.Dn(paramInt);
        }
        locali.rfB = com.tencent.mm.plugin.expt.hellhound.core.b.aeH((String)localObject);
        str = this.rgd;
        localObject = str;
        if (str == null) {
          localObject = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
        }
        locali.sessionId = ((String)localObject);
        locali.scene = this.mScene;
        locali.rfA = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.dS(paramView);
        localObject = paramView.first;
        p.g(localObject, "widthHeightPair.first");
        locali.width = ((Number)localObject).floatValue();
        paramView = paramView.second;
        p.g(paramView, "widthHeightPair.second");
        locali.height = ((Number)paramView).floatValue();
        ((Map)this.rgc).put(paramRecyclerView, locali);
        localObject = locali;
      }
    }
    label331:
    do
    {
      AppMethodBeat.o(196611);
      return localObject;
      localObject = null;
      break;
      localObject = null;
      break label151;
      if ((locali.rfB == null) || (locali.height <= 0.0F)) {
        break label367;
      }
      localObject = locali;
    } while (locali.y > 0);
    label367:
    locali.feedId = paramRecyclerView;
    paramRecyclerView = this.raX;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.ae(paramView, paramInt);
      label391:
      locali.userName = paramRecyclerView;
      paramRecyclerView = this.raX;
      if (paramRecyclerView == null) {
        break label562;
      }
    }
    label562:
    for (paramRecyclerView = paramRecyclerView.af(paramView, paramInt);; paramRecyclerView = null)
    {
      locali.bVF = paramRecyclerView;
      localObject = this.raX;
      paramRecyclerView = localb;
      if (localObject != null) {
        paramRecyclerView = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).Dn(paramInt);
      }
      locali.rfB = com.tencent.mm.plugin.expt.hellhound.core.b.aeH(paramRecyclerView);
      localObject = this.rgd;
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
      }
      locali.sessionId = paramRecyclerView;
      locali.scene = this.mScene;
      locali.rfA = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
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
    AppMethodBeat.i(196614);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
    if (paramObject == null) {
      localObject = null;
    }
    int i;
    while (localObject == null)
    {
      AppMethodBeat.o(196614);
      return;
      i = paramObject.hashCode();
      Map localMap = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqr().get(Integer.valueOf(i));
      localObject = localMap;
      if (localMap == null) {
        localObject = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqs().get(paramObject.getClass().getName());
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startStatisticsByHand, lastFeedMap: " + ((Map)localObject).size());
    if (!((Map)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label310;
      }
      this.rgc.clear();
      this.rgc.putAll((Map)localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
      if (paramObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqr().remove(Integer.valueOf(paramObject.hashCode()));
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqs().remove(paramObject.getClass().getName());
      }
      paramObject = ((Map)this.rgc).entrySet().iterator();
      label208:
      do
      {
        if (!paramObject.hasNext()) {
          break;
        }
        localObject = (i)((Map.Entry)paramObject.next()).getValue();
        ((i)localObject).rfX = paramLong;
        ((i)localObject).rfY = 0L;
        ((i)localObject).rga = 0L;
        ((i)localObject).rfZ = 0;
      } while (((i)localObject).rft > 0L);
      if (this.rge > 0L) {
        break label301;
      }
    }
    label301:
    for (long l = this.rgf;; l = this.rge)
    {
      ((i)localObject).rft = l;
      break label208;
      i = 0;
      break;
    }
    label310:
    AppMethodBeat.o(196614);
  }
  
  public final void a(Map<String, i> paramMap, long paramLong)
  {
    AppMethodBeat.i(196616);
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)((Map.Entry)localIterator.next()).getValue();
      locali.rfY = paramLong;
      locali.rga = (locali.rfY - locali.rfX);
      locali.rfZ = this.rgg;
      if (locali.rft <= 0L) {
        if (this.rge > 0L) {
          break label125;
        }
      }
      label125:
      for (long l = this.rgf;; l = this.rge)
      {
        locali.rft = l;
        a.a locala = a.rff;
        a.a.a(locali);
        break;
      }
    }
    paramMap.clear();
    AppMethodBeat.o(196616);
  }
  
  public final void ac(Map<String, i> paramMap)
  {
    AppMethodBeat.i(196618);
    Object localObject1 = this.rgn;
    if (localObject1 != null)
    {
      localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(196618);
      return;
    }
    p.g(localObject1, "mLayoutManagerRef?.get() ?: return");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int i = rgr;
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
    AppMethodBeat.o(196618);
  }
  
  public final void b(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(196615);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)this.rgc);
    Object localObject1 = ((Map)localHashMap).entrySet().iterator();
    Object localObject2;
    label132:
    label294:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      i locali = (i)((Map.Entry)localObject2).getValue();
      Object localObject3 = this.rgn;
      if (localObject3 != null)
      {
        localObject3 = (StaggeredGridLayoutManager)((WeakReference)localObject3).get();
        if (localObject3 != null) {
          break label132;
        }
      }
      for (;;)
      {
        if (((i)((Map.Entry)localObject2).getValue()).rfv > 0.0F) {
          break label294;
        }
        ((Iterator)localObject1).remove();
        break;
        p.g(localObject3, "mLayoutManagerRef?.get() ?: return");
        localObject3 = ((StaggeredGridLayoutManager)localObject3).bY(rgr + locali.position);
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
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
    localObject1 = (Map)localHashMap;
    p.h(localObject1, "feedMap");
    if (paramObject != null)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqr().put(Integer.valueOf(paramObject.hashCode()), localObject1);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqs();
      paramObject = paramObject.getClass().getName();
      p.g(paramObject, "page.javaClass.name");
      ((Map)localObject2).put(paramObject, localObject1);
    }
    com.tencent.mm.sdk.platformtools.ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "stopStatisticsByHand, realFeedMap=" + localHashMap.size() + ", mFeedMap=" + this.rgc.size());
    a((Map)this.rgc, paramLong);
    AppMethodBeat.o(196615);
  }
  
  public final void b(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(196610);
    if (this.rgc.isEmpty())
    {
      AppMethodBeat.o(196610);
      return;
    }
    Iterator localIterator = ((Map)this.rgc).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (i)((Map.Entry)localObject2).getValue();
      if ((!paramList.contains(localObject1)) && (((i)localObject2).rfX > 0L))
      {
        ((i)localObject2).rfY = paramLong;
        ((i)localObject2).rga = (((i)localObject2).rfY - ((i)localObject2).rfX);
        this.rgg = 0;
        ((i)localObject2).rfZ = this.rgg;
        if (((i)localObject2).rft <= 0L) {
          if (this.rge > 0L) {
            break label197;
          }
        }
        label197:
        for (long l = this.rgf;; l = this.rge)
        {
          ((i)localObject2).rft = l;
          localObject1 = a.rff;
          a.a.a((i)localObject2);
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(196610);
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(196613);
    Object localObject;
    String str;
    if (parami.x <= this.rgi)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
      if (!d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqv(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqv();
        str = parami.feedId;
        if (str == null) {
          p.gkB();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
      parami.rfC = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqv(), parami.feedId);
    }
    for (int i = 0;; i = 1)
    {
      parami.rgb = i;
      AppMethodBeat.o(196613);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
      if (!d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqw(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqw();
        str = parami.feedId;
        if (str == null) {
          p.gkB();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
      parami.rfC = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqw(), parami.feedId);
    }
  }
  
  public final Map<String, i> cqN()
  {
    AppMethodBeat.i(196617);
    Object localObject = new HashMap();
    ((HashMap)localObject).putAll((Map)this.rgc);
    ac((Map)localObject);
    localObject = (Map)localObject;
    AppMethodBeat.o(196617);
    return localObject;
  }
  
  public final void d(i parami)
  {
    float f1 = 0.0F;
    int i = parami.y;
    float f2 = i + parami.height;
    if (i < this.rgj) {
      if (f2 > this.rgk) {
        f1 = this.rgk - this.rgj;
      }
    }
    for (;;)
    {
      parami.rfv = (f1 * 100.0F / parami.height);
      parami.rfw = (f1 * parami.width * 100.0F / this.rgl);
      return;
      if (f2 > this.rgj)
      {
        f1 = f2 - this.rgj;
        continue;
        if (f2 > this.rgk)
        {
          if (i < this.rgk) {
            f1 = this.rgk - i;
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
    return (i < this.rgk) && (f1 + f2 > this.rgj);
  }
  
  final void vk(long paramLong)
  {
    AppMethodBeat.i(196619);
    Object localObject1 = this.rgn;
    StaggeredGridLayoutManager localStaggeredGridLayoutManager;
    if (localObject1 != null)
    {
      localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localStaggeredGridLayoutManager != null) {}
    }
    else
    {
      AppMethodBeat.o(196619);
      return;
    }
    p.g(localStaggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
    localObject1 = this.rbC;
    RecyclerView localRecyclerView;
    if (localObject1 != null)
    {
      localRecyclerView = (RecyclerView)((WeakReference)localObject1).get();
      if (localRecyclerView != null) {}
    }
    else
    {
      AppMethodBeat.o(196619);
      return;
    }
    p.g(localRecyclerView, "mRecyclerViewRef?.get() ?: return");
    localObject1 = localStaggeredGridLayoutManager.n(null);
    int i = Math.min(localObject1[0], localObject1[1]);
    localObject1 = localStaggeredGridLayoutManager.mA();
    int j = Math.max(Math.max(localObject1[0], localObject1[1]) - rgr, 0);
    i = Math.max(i, rgr);
    int k = rgr;
    List localList = (List)new ArrayList();
    i -= k;
    if (i < j + 1)
    {
      Object localObject3 = localStaggeredGridLayoutManager.bY(rgr + i);
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
            p.gkB();
          }
          localList.add(str);
          if (this.rge <= 0L) {}
          for (l = this.rgf;; l = this.rge)
          {
            ((i)localObject3).rft = l;
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
            localObject1 = (Map)this.rgc;
            localObject2 = ((i)localObject3).feedId;
            if (localObject1 != null) {
              break;
            }
            localObject1 = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            AppMethodBeat.o(196619);
            throw ((Throwable)localObject1);
          }
          d.g.b.ae.eY(localObject1).remove(localObject2);
        }
      }
      label439:
      ((i)localObject3).rfX = this.rgf;
      ((i)localObject3).rfY = paramLong;
      localObject1 = this.raX;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).Dn(((i)localObject3).position);
        label479:
        ((i)localObject3).rfB = com.tencent.mm.plugin.expt.hellhound.core.b.aeH((String)localObject1);
        ((i)localObject3).rga = (((i)localObject3).rfY - ((i)localObject3).rfX);
        ((i)localObject3).cNB = true;
        this.rgg = 1;
        ((i)localObject3).rfZ = 1;
        if (((i)localObject3).rft <= 0L) {
          if (this.rge > 0L) {
            break label610;
          }
        }
      }
      label610:
      for (long l = this.rgf;; l = this.rge)
      {
        ((i)localObject3).rft = l;
        localObject2 = this.rgd;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
        }
        ((i)localObject3).sessionId = ((String)localObject1);
        ((i)localObject3).scene = this.mScene;
        ((i)localObject3).rfA = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
        break;
        localObject1 = null;
        break label479;
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
    c.a.cqF();
    AppMethodBeat.o(196619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.j
 * JD-Core Version:    0.7.0.1
 */