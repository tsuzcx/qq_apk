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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.aa;
import d.g.b.k;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/app/Activity;Landroid/support/v4/app/Fragment;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mClickStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "mDisAppearType", "", "mDisAppearTypeOnRefreshBegin", "mFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "Lkotlin/collections/HashMap;", "mFeedMapOnRefreshBegin", "mFeedParamCatcher", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "mLayoutManagerRef", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "mPageEntryTimestamp", "", "mRecyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "mRefreshEndTimestampLatested", "mRefreshTimestampOnRefresBegin", "mScene", "mScreenArea", "", "mScreenBottom", "mScreenMidX", "mScreenTop", "mScreenWidth", "mSessionPageId", "computeOnLoadMoreEnd", "", "computeOnRefreshBegin", "computeOnRefreshEnd", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "computeOnScrolled", "recyclerView", "layoutManager", "fillFeedExposureAreaWeigth", "feed", "fillItemArrayIndex", "fillItemPosition", "fillTimestamp", "timestamp", "fuckNoScrollWhenEnterActivity", "getFeedParams", "feedView", "Landroid/view/View;", "position", "getFeedWhenClick", "getFeedsOfScreen", "", "initActivityFeedParamsCatcher", "initFeedParamsCatcher", "initFragmentFeedParamsCatcher", "initScreen", "isFeedAppear", "", "isFeedDisappear", "isFeedGone", "isFeedShow", "reGetViewParams", "reGetViewsParams", "feedMap", "report19944", "reportLeftFeed", "visitingFeedIdList", "", "startCompute", "eventId", "startStatisticsByHand", "page", "statisticsFeed", "stopCompute", "stopStatisticsByHand", "Companion", "plugin-expt_release"})
public final class j
{
  public static int qpm;
  public static final j.a qpn;
  private WeakReference<Activity> mActivityRef;
  private int mScene;
  public WeakReference<RecyclerView> qkI;
  com.tencent.mm.plugin.expt.hellhound.a.a.a.b qkd;
  public final HashMap<String, i> qoX;
  private String qoY;
  public long qoZ;
  public final long qpa;
  public int qpb;
  private float qpc;
  private float qpd;
  public float qpe;
  public float qpf;
  private float qpg;
  public final c qph;
  public WeakReference<StaggeredGridLayoutManager> qpi;
  public HashMap<String, i> qpj;
  public long qpk;
  public int qpl;
  
  static
  {
    AppMethodBeat.i(195592);
    qpn = new j.a((byte)0);
    AppMethodBeat.o(195592);
  }
  
  public j(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(195591);
    this.qoX = new HashMap();
    this.qpa = System.currentTimeMillis();
    if (paramActivity != null) {
      this.mActivityRef = new WeakReference(paramActivity);
    }
    this.qoY = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
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
          Object localObject1 = ai.getContext().getSystemService("window");
          if (localObject1 != null) {
            break label546;
          }
          localObject1 = new v("null cannot be cast to non-null type android.view.WindowManager");
          AppMethodBeat.o(195591);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          localObject2 = paramActivity.getWindowManager();
          k.g(localObject2, "activity.windowManager");
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
        this.qpc = localPoint1.x;
        this.qpd = (this.qpc / 2.0F);
        float f1 = localPoint1.y;
        i = localPoint2.y;
        float f2 = com.tencent.mm.plugin.expt.hellhound.core.b.P(paramActivity);
        int j = Math.max(com.tencent.mm.plugin.expt.hellhound.core.b.u(paramActivity), paramActivity.getResources().getDimensionPixelSize(2131165252));
        this.qpe = (j + f2);
        this.qpf = f1;
        this.qpg = (this.qpc * (this.qpf - this.qpe));
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aW(this.qpg);
        ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "initScreen:\nmScreenMid=" + this.qpd + '\n' + "mScreenWidth=" + this.qpc + '\n' + "screenRealHeight=" + i + '\n' + "screenHeight=" + f1 + '\n' + "statusBarHeight=" + f2 + '\n' + "actionBarHeight=" + j + '\n' + "mScreenTop=" + this.qpe + '\n' + "mScreenBottom=" + this.qpf + '\n' + "mScreenArea=" + this.qpg);
        if (paramFragment != null) {
          break label955;
        }
        paramFragment = paramActivity.getClass().getName();
        if (paramFragment != null) {
          break label561;
        }
        ac.e("HABBYGE-MALI.WaterfallsFlowStatistics", "initFeedParamsCatcher, miss page: " + paramActivity.getClass().getName());
      }
    }
    for (;;)
    {
      label500:
      this.qph = new c(this);
      this.qpj = new HashMap();
      this.qpk = -1L;
      this.qpl = -1;
      AppMethodBeat.o(195591);
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
        this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        qpm = 0;
        this.mScene = c.d.qni.value;
        break;
      case 395150120: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI")) {
          break;
        }
        this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new g(paramActivity));
        qpm = 1;
        this.mScene = c.d.qnm.value;
        break;
      case -1570624296: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI")) {
          break;
        }
        this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new b());
        qpm = 0;
        this.mScene = c.d.qnn.value;
        break;
      case 1251839313: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.search.FinderMixSearchUI")) {
          break;
        }
        this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new e(paramActivity));
        qpm = 5;
        this.mScene = c.d.qnl.value;
        break;
      case 782364972: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
          break;
        }
        this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new h());
        qpm = 1;
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
        if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjQ() != c.c.qng.value) {}
      case 786042180: 
      case -1577760806: 
        for (i = c.d.qnk.value;; i = c.d.qnj.value)
        {
          this.mScene = i;
          break label500;
          if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC")) {
            break;
          }
          this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
          qpm = 0;
          this.mScene = c.d.qni.value;
          break label500;
          if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2")) {
            break;
          }
          this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
          qpm = 0;
          this.mScene = c.d.qni.value;
          break label500;
        }
        label955:
        paramActivity = paramFragment.getClass().getName();
        if (paramActivity == null) {}
        do
        {
          for (;;)
          {
            ac.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("initFragmentFeedParamsCatcher miss !!"), "initFragmentFeedParamsCatcher miss !!", new Object[0]);
            break;
            switch (paramActivity.hashCode())
            {
            }
          }
        } while (!paramActivity.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment"));
        this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        qpm = 0;
        this.mScene = c.d.qni.value;
      }
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(195583);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
    if (d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjH(), parami.feedId)) {
      if (parami.ij >= 0) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjH();
        String str = parami.feedId;
        if (str == null) {
          k.fOy();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      parami.ij = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjH(), parami.feedId);
      AppMethodBeat.o(195583);
      return;
      AppMethodBeat.o(195583);
      return;
    }
  }
  
  public static void cjW()
  {
    AppMethodBeat.i(195580);
    ac.d("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnLoadMoreEnd");
    AppMethodBeat.o(195580);
  }
  
  public final void U(Map<String, i> paramMap)
  {
    AppMethodBeat.i(195589);
    Object localObject1 = this.qpi;
    if (localObject1 != null)
    {
      localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(195589);
      return;
    }
    k.g(localObject1, "mLayoutManagerRef?.get() ?: return");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int i = qpm;
      Object localObject2 = ((StaggeredGridLayoutManager)localObject1).bY(((i)localEntry.getValue()).position + i);
      if (localObject2 != null)
      {
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.dO((View)localObject2);
        Object localObject4 = (i)localEntry.getValue();
        Object localObject5 = ((Pair)localObject3).first;
        k.g(localObject5, "xy.first");
        ((i)localObject4).x = ((Number)localObject5).intValue();
        localObject4 = (i)localEntry.getValue();
        localObject3 = ((Pair)localObject3).second;
        k.g(localObject3, "xy.second");
        ((i)localObject4).y = ((Number)localObject3).intValue();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.dP((View)localObject2);
        localObject3 = (i)localEntry.getValue();
        localObject4 = ((Pair)localObject2).first;
        k.g(localObject4, "widthHeightPair.first");
        ((i)localObject3).width = ((Number)localObject4).floatValue();
        localObject3 = (i)localEntry.getValue();
        localObject2 = ((Pair)localObject2).second;
        k.g(localObject2, "widthHeightPair.second");
        ((i)localObject3).height = ((Number)localObject2).floatValue();
        d((i)localEntry.getValue());
      }
    }
    AppMethodBeat.o(195589);
  }
  
  public final i a(View paramView, int paramInt, RecyclerView paramRecyclerView)
  {
    com.tencent.mm.plugin.expt.hellhound.a.a.a.b localb = null;
    String str = null;
    AppMethodBeat.i(195582);
    Object localObject = this.qkd;
    if (localObject != null) {
      ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).setRecyclerView(paramRecyclerView);
    }
    paramRecyclerView = this.qkd;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.ac(paramView, paramInt); paramRecyclerView == null; paramRecyclerView = null)
    {
      AppMethodBeat.o(195582);
      return null;
    }
    i locali = (i)this.qoX.get(paramRecyclerView);
    if (locali == null)
    {
      locali = new i((byte)0);
      locali.feedId = paramRecyclerView;
      localObject = this.qkd;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ad(paramView, paramInt);
        locali.userName = ((String)localObject);
        localObject = this.qkd;
        if (localObject == null) {
          break label331;
        }
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ae(paramView, paramInt);
        label151:
        locali.bLs = ((String)localObject);
        localb = this.qkd;
        localObject = str;
        if (localb != null) {
          localObject = localb.Cn(paramInt);
        }
        locali.qoy = com.tencent.mm.plugin.expt.hellhound.core.b.aaa((String)localObject);
        str = this.qoY;
        localObject = str;
        if (str == null) {
          localObject = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
        }
        locali.sessionId = ((String)localObject);
        locali.scene = this.mScene;
        locali.qox = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.dP(paramView);
        localObject = paramView.first;
        k.g(localObject, "widthHeightPair.first");
        locali.width = ((Number)localObject).floatValue();
        paramView = paramView.second;
        k.g(paramView, "widthHeightPair.second");
        locali.height = ((Number)paramView).floatValue();
        ((Map)this.qoX).put(paramRecyclerView, locali);
        localObject = locali;
      }
    }
    label331:
    do
    {
      AppMethodBeat.o(195582);
      return localObject;
      localObject = null;
      break;
      localObject = null;
      break label151;
      if ((locali.qoy == null) || (locali.height <= 0.0F)) {
        break label367;
      }
      localObject = locali;
    } while (locali.y > 0);
    label367:
    locali.feedId = paramRecyclerView;
    paramRecyclerView = this.qkd;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.ad(paramView, paramInt);
      label391:
      locali.userName = paramRecyclerView;
      paramRecyclerView = this.qkd;
      if (paramRecyclerView == null) {
        break label562;
      }
    }
    label562:
    for (paramRecyclerView = paramRecyclerView.ae(paramView, paramInt);; paramRecyclerView = null)
    {
      locali.bLs = paramRecyclerView;
      localObject = this.qkd;
      paramRecyclerView = localb;
      if (localObject != null) {
        paramRecyclerView = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).Cn(paramInt);
      }
      locali.qoy = com.tencent.mm.plugin.expt.hellhound.core.b.aaa(paramRecyclerView);
      localObject = this.qoY;
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
      }
      locali.sessionId = paramRecyclerView;
      locali.scene = this.mScene;
      locali.qox = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.dP(paramView);
      paramRecyclerView = paramView.first;
      k.g(paramRecyclerView, "widthHeightPair.first");
      locali.width = ((Number)paramRecyclerView).floatValue();
      paramView = paramView.second;
      k.g(paramView, "widthHeightPair.second");
      locali.height = ((Number)paramView).floatValue();
      localObject = locali;
      break;
      paramRecyclerView = null;
      break label391;
    }
  }
  
  public final void a(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(195585);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
    if (paramObject == null) {
      localObject = null;
    }
    int i;
    while (localObject == null)
    {
      AppMethodBeat.o(195585);
      return;
      i = paramObject.hashCode();
      Map localMap = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjE().get(Integer.valueOf(i));
      localObject = localMap;
      if (localMap == null) {
        localObject = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjF().get(paramObject.getClass().getName());
      }
    }
    ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startStatisticsByHand, lastFeedMap: " + ((Map)localObject).size());
    if (!((Map)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label310;
      }
      this.qoX.clear();
      this.qoX.putAll((Map)localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      if (paramObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjE().remove(Integer.valueOf(paramObject.hashCode()));
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjF().remove(paramObject.getClass().getName());
      }
      paramObject = ((Map)this.qoX).entrySet().iterator();
      label208:
      do
      {
        if (!paramObject.hasNext()) {
          break;
        }
        localObject = (i)((Map.Entry)paramObject.next()).getValue();
        ((i)localObject).qoS = paramLong;
        ((i)localObject).qoT = 0L;
        ((i)localObject).qoV = 0L;
        ((i)localObject).qoU = 0;
      } while (((i)localObject).qoq > 0L);
      if (this.qoZ > 0L) {
        break label301;
      }
    }
    label301:
    for (long l = this.qpa;; l = this.qoZ)
    {
      ((i)localObject).qoq = l;
      break label208;
      i = 0;
      break;
    }
    label310:
    AppMethodBeat.o(195585);
  }
  
  public final void a(Map<String, i> paramMap, long paramLong)
  {
    AppMethodBeat.i(195587);
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)((Map.Entry)localIterator.next()).getValue();
      locali.qoT = paramLong;
      locali.qoV = (locali.qoT - locali.qoS);
      locali.qoU = this.qpb;
      if (locali.qoq <= 0L) {
        if (this.qoZ > 0L) {
          break label125;
        }
      }
      label125:
      for (long l = this.qpa;; l = this.qoZ)
      {
        locali.qoq = l;
        a.a locala = a.qoc;
        a.a.a(locali);
        break;
      }
    }
    paramMap.clear();
    AppMethodBeat.o(195587);
  }
  
  public final void b(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(195586);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)this.qoX);
    Object localObject1 = ((Map)localHashMap).entrySet().iterator();
    Object localObject2;
    label132:
    label294:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      i locali = (i)((Map.Entry)localObject2).getValue();
      Object localObject3 = this.qpi;
      if (localObject3 != null)
      {
        localObject3 = (StaggeredGridLayoutManager)((WeakReference)localObject3).get();
        if (localObject3 != null) {
          break label132;
        }
      }
      for (;;)
      {
        if (((i)((Map.Entry)localObject2).getValue()).qos > 0.0F) {
          break label294;
        }
        ((Iterator)localObject1).remove();
        break;
        k.g(localObject3, "mLayoutManagerRef?.get() ?: return");
        localObject3 = ((StaggeredGridLayoutManager)localObject3).bY(qpm + locali.position);
        if (localObject3 != null)
        {
          Object localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.dO((View)localObject3);
          Object localObject5 = ((Pair)localObject4).first;
          k.g(localObject5, "xy.first");
          locali.x = ((Number)localObject5).intValue();
          localObject4 = ((Pair)localObject4).second;
          k.g(localObject4, "xy.second");
          locali.y = ((Number)localObject4).intValue();
          localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.dP((View)localObject3);
          localObject4 = ((Pair)localObject3).first;
          k.g(localObject4, "widthHeightPair.first");
          locali.width = ((Number)localObject4).floatValue();
          localObject3 = ((Pair)localObject3).second;
          k.g(localObject3, "widthHeightPair.second");
          locali.height = ((Number)localObject3).floatValue();
          d(locali);
        }
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
    localObject1 = (Map)localHashMap;
    k.h(localObject1, "feedMap");
    if (paramObject != null)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjE().put(Integer.valueOf(paramObject.hashCode()), localObject1);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjF();
      paramObject = paramObject.getClass().getName();
      k.g(paramObject, "page.javaClass.name");
      ((Map)localObject2).put(paramObject, localObject1);
    }
    ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "stopStatisticsByHand, realFeedMap=" + localHashMap.size() + ", mFeedMap=" + this.qoX.size());
    a((Map)this.qoX, paramLong);
    AppMethodBeat.o(195586);
  }
  
  public final void b(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(195581);
    if (this.qoX.isEmpty())
    {
      AppMethodBeat.o(195581);
      return;
    }
    Iterator localIterator = ((Map)this.qoX).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (i)((Map.Entry)localObject2).getValue();
      if ((!paramList.contains(localObject1)) && (((i)localObject2).qoS > 0L))
      {
        ((i)localObject2).qoT = paramLong;
        ((i)localObject2).qoV = (((i)localObject2).qoT - ((i)localObject2).qoS);
        this.qpb = 0;
        ((i)localObject2).qoU = this.qpb;
        if (((i)localObject2).qoq <= 0L) {
          if (this.qoZ > 0L) {
            break label197;
          }
        }
        label197:
        for (long l = this.qpa;; l = this.qoZ)
        {
          ((i)localObject2).qoq = l;
          localObject1 = a.qoc;
          a.a.a((i)localObject2);
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(195581);
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(195584);
    Object localObject;
    String str;
    if (parami.x <= this.qpd)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      if (!d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjI(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjI();
        str = parami.feedId;
        if (str == null) {
          k.fOy();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      parami.qoz = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjI(), parami.feedId);
    }
    for (int i = 0;; i = 1)
    {
      parami.qoW = i;
      AppMethodBeat.o(195584);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      if (!d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjJ(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjJ();
        str = parami.feedId;
        if (str == null) {
          k.fOy();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      parami.qoz = d.a.j.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjJ(), parami.feedId);
    }
  }
  
  public final Map<String, i> cjX()
  {
    AppMethodBeat.i(195588);
    Object localObject = new HashMap();
    ((HashMap)localObject).putAll((Map)this.qoX);
    U((Map)localObject);
    localObject = (Map)localObject;
    AppMethodBeat.o(195588);
    return localObject;
  }
  
  public final void d(i parami)
  {
    float f1 = 0.0F;
    int i = parami.y;
    float f2 = i + parami.height;
    if (i < this.qpe) {
      if (f2 > this.qpf) {
        f1 = this.qpf - this.qpe;
      }
    }
    for (;;)
    {
      parami.qos = (f1 * 100.0F / parami.height);
      parami.qot = (f1 * parami.width * 100.0F / this.qpg);
      return;
      if (f2 > this.qpe)
      {
        f1 = f2 - this.qpe;
        continue;
        if (f2 > this.qpf)
        {
          if (i < this.qpf) {
            f1 = this.qpf - i;
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
    return (i < this.qpf) && (f1 + f2 > this.qpe);
  }
  
  final void sW(long paramLong)
  {
    AppMethodBeat.i(195590);
    Object localObject1 = this.qpi;
    StaggeredGridLayoutManager localStaggeredGridLayoutManager;
    if (localObject1 != null)
    {
      localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localStaggeredGridLayoutManager != null) {}
    }
    else
    {
      AppMethodBeat.o(195590);
      return;
    }
    k.g(localStaggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
    localObject1 = this.qkI;
    RecyclerView localRecyclerView;
    if (localObject1 != null)
    {
      localRecyclerView = (RecyclerView)((WeakReference)localObject1).get();
      if (localRecyclerView != null) {}
    }
    else
    {
      AppMethodBeat.o(195590);
      return;
    }
    k.g(localRecyclerView, "mRecyclerViewRef?.get() ?: return");
    localObject1 = localStaggeredGridLayoutManager.n(null);
    int i = Math.min(localObject1[0], localObject1[1]);
    localObject1 = localStaggeredGridLayoutManager.mi();
    int j = Math.max(Math.max(localObject1[0], localObject1[1]) - qpm, 0);
    i = Math.max(i, qpm);
    int k = qpm;
    List localList = (List)new ArrayList();
    i -= k;
    if (i < j + 1)
    {
      Object localObject3 = localStaggeredGridLayoutManager.bY(qpm + i);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.dO((View)localObject3);
        k.g(localObject2, "HellhoundUtil.getCoordinateOnScreen(feedView)");
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
            k.fOy();
          }
          localList.add(str);
          if (this.qoZ <= 0L) {}
          for (l = this.qpa;; l = this.qoZ)
          {
            ((i)localObject3).qoq = l;
            k.g(localObject1, "x");
            ((i)localObject3).x = ((Integer)localObject1).intValue();
            k.g(localObject2, "y");
            ((i)localObject3).y = ((Integer)localObject2).intValue();
            ((i)localObject3).position = i;
            b((i)localObject3);
            c((i)localObject3);
            d((i)localObject3);
            if (e((i)localObject3)) {
              break label439;
            }
            localObject1 = (Map)this.qoX;
            localObject2 = ((i)localObject3).feedId;
            if (localObject1 != null) {
              break;
            }
            localObject1 = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            AppMethodBeat.o(195590);
            throw ((Throwable)localObject1);
          }
          aa.eS(localObject1).remove(localObject2);
        }
      }
      label439:
      ((i)localObject3).qoS = this.qpa;
      ((i)localObject3).qoT = paramLong;
      localObject1 = this.qkd;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).Cn(((i)localObject3).position);
        label479:
        ((i)localObject3).qoy = com.tencent.mm.plugin.expt.hellhound.core.b.aaa((String)localObject1);
        ((i)localObject3).qoV = (((i)localObject3).qoT - ((i)localObject3).qoS);
        ((i)localObject3).cBT = true;
        this.qpb = 1;
        ((i)localObject3).qoU = 1;
        if (((i)localObject3).qoq <= 0L) {
          if (this.qoZ > 0L) {
            break label610;
          }
        }
      }
      label610:
      for (long l = this.qpa;; l = this.qoZ)
      {
        ((i)localObject3).qoq = l;
        localObject2 = this.qoY;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
        }
        ((i)localObject3).sessionId = ((String)localObject1);
        ((i)localObject3).scene = this.mScene;
        ((i)localObject3).qox = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
        break;
        localObject1 = null;
        break label479;
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
    c.a.cjS();
    AppMethodBeat.o(195590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.j
 * JD-Core Version:    0.7.0.1
 */