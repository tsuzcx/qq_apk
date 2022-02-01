package com.tencent.mm.plugin.expt.hellhound.ext.b.d;

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
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.f;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.f;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mClickStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "mDisAppearType", "", "mDisAppearTypeOnRefreshBegin", "mFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "Lkotlin/collections/HashMap;", "mFeedMapOnRefreshBegin", "mFeedParamCatcher", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "mLayoutManagerRef", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "mPageEntryTimestamp", "", "mRecyclerViewRef", "Landroidx/recyclerview/widget/RecyclerView;", "mRefreshEndTimestampLatested", "mRefreshTimestampOnRefresBegin", "mScene", "mScreenArea", "", "mScreenBottom", "mScreenMidX", "mScreenTop", "mScreenWidth", "mSessionPageId", "computeOnLoadMoreEnd", "", "computeOnRefreshBegin", "computeOnRefreshEnd", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "computeOnScrolled", "recyclerView", "layoutManager", "fillFeedExposureAreaWeigth", "feed", "fillItemArrayIndex", "fillItemPosition", "fillTimestamp", "timestamp", "fuckNoScrollWhenEnterActivity", "getFeedParams", "feedView", "Landroid/view/View;", "position", "getFeedWhenClick", "getFeedsOfScreen", "", "initActivityFeedParamsCatcher", "initFeedParamsCatcher", "initFragmentFeedParamsCatcher", "initScreen", "isFeedAppear", "", "isFeedDisappear", "isFeedGone", "isFeedShow", "reGetViewParams", "reGetViewsParams", "feedMap", "report19944", "reportLeftFeed", "visitingFeedIdList", "", "startCompute", "eventId", "startStatisticsByHand", "page", "statisticsFeed", "stopCompute", "stopStatisticsByHand", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static int zJM;
  public static final j.a zJw;
  private WeakReference<Activity> mActivityRef;
  private int mScene;
  public WeakReference<RecyclerView> zDZ;
  com.tencent.mm.plugin.expt.hellhound.ext.a.a.b zDk;
  public final long zJA;
  public int zJB;
  private float zJC;
  private float zJD;
  public float zJE;
  public float zJF;
  private float zJG;
  public final c zJH;
  public WeakReference<StaggeredGridLayoutManager> zJI;
  public HashMap<String, i> zJJ;
  public long zJK;
  public int zJL;
  public final HashMap<String, i> zJx;
  private String zJy;
  public long zJz;
  
  static
  {
    AppMethodBeat.i(300399);
    zJw = new j.a((byte)0);
    AppMethodBeat.o(300399);
  }
  
  public j(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(300347);
    this.zJx = new HashMap();
    this.zJA = System.currentTimeMillis();
    if (paramActivity != null) {
      this.mActivityRef = new WeakReference(paramActivity);
    }
    this.zJy = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
    paramActivity = this.mActivityRef;
    Object localObject2;
    label115:
    int i;
    if (paramActivity == null)
    {
      paramActivity = null;
      if (paramActivity != null)
      {
        try
        {
          Object localObject1 = MMApplicationContext.getContext().getSystemService("window");
          if (localObject1 != null) {
            break label555;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
          AppMethodBeat.o(300347);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          localObject2 = paramActivity.getWindowManager().getDefaultDisplay();
        }
        Point localPoint1 = new Point();
        if ((Build.VERSION.SDK_INT >= 13) && (localObject2 != null)) {
          ((Display)localObject2).getSize(localPoint1);
        }
        Point localPoint2 = new Point();
        if ((Build.VERSION.SDK_INT >= 17) && (localObject2 != null)) {
          ((Display)localObject2).getRealSize(localPoint2);
        }
        this.zJC = localPoint1.x;
        this.zJD = (this.zJC / 2.0F);
        float f1 = localPoint1.y;
        i = localPoint2.y;
        float f2 = com.tencent.mm.plugin.expt.hellhound.core.b.Y(paramActivity);
        int j = Math.max(com.tencent.mm.plugin.expt.hellhound.core.b.v(paramActivity), paramActivity.getResources().getDimensionPixelSize(b.b.DefaultActionbarHeightPort));
        this.zJE = (j + f2);
        this.zJF = f1;
        this.zJG = (this.zJC * (this.zJF - this.zJE));
        localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.ci(this.zJG);
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "initScreen:\nmScreenMid=" + this.zJD + "\nmScreenWidth=" + this.zJC + "\nscreenRealHeight=" + i + "\nscreenHeight=" + f1 + "\nstatusBarHeight=" + f2 + "\nactionBarHeight=" + j + "\nmScreenTop=" + this.zJE + "\nmScreenBottom=" + this.zJF + "\nmScreenArea=" + this.zJG);
        if (paramFragment != null) {
          break label890;
        }
        paramFragment = paramActivity.getClass().getName();
        if (paramFragment != null) {}
        switch (paramFragment.hashCode())
        {
        default: 
          label484:
          Log.e("HABBYGE-MALI.WaterfallsFlowStatistics", s.X("initFeedParamsCatcher, miss page: ", paramActivity.getClass().getName()));
        }
      }
    }
    for (;;)
    {
      label503:
      this.zJH = new c(this);
      this.zJJ = new HashMap();
      this.zJK = -1L;
      this.zJL = -1;
      AppMethodBeat.o(300347);
      return;
      paramActivity = (Activity)paramActivity.get();
      break;
      label555:
      localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
      break label115;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI")) {
        break label484;
      }
      this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)new f());
      zJM = 0;
      this.mScene = c.f.zHt.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI")) {
        break label484;
      }
      this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)new g(paramActivity));
      zJM = 1;
      this.mScene = c.f.zHx.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI")) {
        break label484;
      }
      this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)new b());
      zJM = 0;
      this.mScene = c.f.zHy.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.search.FinderMixSearchUI")) {
        break label484;
      }
      this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)new e(paramActivity));
      zJM = 5;
      this.mScene = c.f.zHw.value;
      continue;
      if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
        break label484;
      }
      this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)new h());
      zJM = 1;
      paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      if (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKI() == c.d.zHl.value) {}
      for (i = c.f.zHv.value;; i = c.f.zHu.value)
      {
        this.mScene = i;
        break label503;
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC")) {
          break;
        }
        this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)new f());
        zJM = 0;
        this.mScene = c.f.zHt.value;
        break label503;
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2")) {
          break;
        }
        this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)new f());
        zJM = 0;
        this.mScene = c.f.zHt.value;
        break label503;
      }
      label890:
      if (s.p(paramFragment.getClass().getName(), "com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment"))
      {
        this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)new f());
        zJM = 0;
        this.mScene = c.f.zHt.value;
      }
      else
      {
        Log.printErrStackTrace("HABBYGE-MALI.WaterfallsFlowStatistics", (Throwable)new NullPointerException("initFragmentFeedParamsCatcher miss !!"), "initFragmentFeedParamsCatcher miss !!", new Object[0]);
      }
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(300370);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
    if (p.a((Iterable)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKz(), parami.feedId)) {
      if (parami.dpP >= 0) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKz();
        String str = parami.feedId;
        s.checkNotNull(str);
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      parami.dpP = p.a(com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKz(), parami.feedId);
      AppMethodBeat.o(300370);
      return;
      AppMethodBeat.o(300370);
      return;
    }
  }
  
  public static void dLd()
  {
    AppMethodBeat.i(300357);
    Log.d("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnLoadMoreEnd");
    AppMethodBeat.o(300357);
  }
  
  private final void f(i parami)
  {
    AppMethodBeat.i(300386);
    Object localObject1 = this.zJI;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get())
    {
      AppMethodBeat.o(300386);
      return;
    }
    localObject1 = ((StaggeredGridLayoutManager)localObject1).findViewByPosition(zJM + parami.position);
    if (localObject1 == null)
    {
      AppMethodBeat.o(300386);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.fb((View)localObject1);
    Object localObject3 = ((Pair)localObject2).first;
    s.s(localObject3, "xy.first");
    parami.x = ((Number)localObject3).intValue();
    localObject2 = ((Pair)localObject2).second;
    s.s(localObject2, "xy.second");
    parami.y = ((Number)localObject2).intValue();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.fc((View)localObject1);
    localObject2 = ((Pair)localObject1).first;
    s.s(localObject2, "widthHeightPair.first");
    parami.width = ((Number)localObject2).floatValue();
    localObject1 = ((Pair)localObject1).second;
    s.s(localObject1, "widthHeightPair.second");
    parami.height = ((Number)localObject1).floatValue();
    d(parami);
    AppMethodBeat.o(300386);
  }
  
  public final i a(View paramView, int paramInt, RecyclerView paramRecyclerView)
  {
    Object localObject2 = null;
    String str = null;
    AppMethodBeat.i(300436);
    Object localObject1 = this.zDk;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)localObject1).setRecyclerView(paramRecyclerView);
    }
    paramRecyclerView = this.zDk;
    if (paramRecyclerView == null) {}
    for (paramRecyclerView = null; paramRecyclerView == null; paramRecyclerView = paramRecyclerView.aj(paramView, paramInt))
    {
      AppMethodBeat.o(300436);
      return null;
    }
    i locali = (i)this.zJx.get(paramRecyclerView);
    if (locali == null)
    {
      locali = new i((byte)0);
      locali.feedId = paramRecyclerView;
      localObject1 = this.zDk;
      if (localObject1 == null)
      {
        localObject1 = null;
        locali.userName = ((String)localObject1);
        localObject1 = this.zDk;
        if (localObject1 != null) {
          break label313;
        }
        localObject1 = null;
        label135:
        locali.nickName = ((String)localObject1);
        localObject1 = this.zDk;
        if (localObject1 != null) {
          break label327;
        }
        localObject1 = str;
        label157:
        locali.zIP = com.tencent.mm.plugin.expt.hellhound.core.b.aqX((String)localObject1);
        str = this.zJy;
        localObject1 = str;
        if (str == null) {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
        }
        locali.sessionId = ((String)localObject1);
        locali.scene = this.mScene;
        locali.zIO = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.fc(paramView);
        localObject1 = paramView.first;
        s.s(localObject1, "widthHeightPair.first");
        locali.width = ((Number)localObject1).floatValue();
        paramView = paramView.second;
        s.s(paramView, "widthHeightPair.second");
        locali.height = ((Number)paramView).floatValue();
        ((Map)this.zJx).put(paramRecyclerView, locali);
        localObject1 = locali;
      }
    }
    label313:
    label327:
    do
    {
      AppMethodBeat.o(300436);
      return localObject1;
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)localObject1).ak(paramView, paramInt);
      break;
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)localObject1).al(paramView, paramInt);
      break label135;
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)localObject1).LH(paramInt);
      break label157;
      if ((locali.zIP == null) || (locali.height <= 0.0F)) {
        break label370;
      }
      localObject1 = locali;
    } while (locali.y > 0);
    label370:
    locali.feedId = paramRecyclerView;
    paramRecyclerView = this.zDk;
    if (paramRecyclerView == null)
    {
      paramRecyclerView = null;
      label387:
      locali.userName = paramRecyclerView;
      paramRecyclerView = this.zDk;
      if (paramRecyclerView != null) {
        break label547;
      }
      paramRecyclerView = null;
      label404:
      locali.nickName = paramRecyclerView;
      paramRecyclerView = this.zDk;
      if (paramRecyclerView != null) {
        break label559;
      }
    }
    label547:
    label559:
    for (paramRecyclerView = localObject2;; paramRecyclerView = paramRecyclerView.LH(paramInt))
    {
      locali.zIP = com.tencent.mm.plugin.expt.hellhound.core.b.aqX(paramRecyclerView);
      localObject1 = this.zJy;
      paramRecyclerView = (RecyclerView)localObject1;
      if (localObject1 == null) {
        paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      }
      locali.sessionId = paramRecyclerView;
      locali.scene = this.mScene;
      locali.zIO = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.fc(paramView);
      paramRecyclerView = paramView.first;
      s.s(paramRecyclerView, "widthHeightPair.first");
      locali.width = ((Number)paramRecyclerView).floatValue();
      paramView = paramView.second;
      s.s(paramView, "widthHeightPair.second");
      locali.height = ((Number)paramView).floatValue();
      localObject1 = locali;
      break;
      paramRecyclerView = paramRecyclerView.ak(paramView, paramInt);
      break label387;
      paramRecyclerView = paramRecyclerView.al(paramView, paramInt);
      break label404;
    }
  }
  
  public final void a(Map<String, i> paramMap, long paramLong)
  {
    AppMethodBeat.i(300506);
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)((Map.Entry)localIterator.next()).getValue();
      locali.zJs = paramLong;
      locali.zJu = (locali.zJs - locali.zJr);
      locali.zJt = this.zJB;
      if (locali.zIH <= 0L) {
        if (this.zJz > 0L) {
          break label125;
        }
      }
      label125:
      for (long l = this.zJA;; l = this.zJz)
      {
        locali.zIH = l;
        a.a locala = a.zIv;
        a.a.a(locali);
        break;
      }
    }
    paramMap.clear();
    AppMethodBeat.o(300506);
  }
  
  public final void ah(Map<String, i> paramMap)
  {
    AppMethodBeat.i(300536);
    Object localObject1 = this.zJI;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get())
    {
      AppMethodBeat.o(300536);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int i = zJM;
      Object localObject2 = ((StaggeredGridLayoutManager)localObject1).findViewByPosition(((i)localEntry.getValue()).position + i);
      if (localObject2 != null)
      {
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.fb((View)localObject2);
        Object localObject4 = (i)localEntry.getValue();
        Object localObject5 = ((Pair)localObject3).first;
        s.s(localObject5, "xy.first");
        ((i)localObject4).x = ((Number)localObject5).intValue();
        localObject4 = (i)localEntry.getValue();
        localObject3 = ((Pair)localObject3).second;
        s.s(localObject3, "xy.second");
        ((i)localObject4).y = ((Number)localObject3).intValue();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.fc((View)localObject2);
        localObject3 = (i)localEntry.getValue();
        localObject4 = ((Pair)localObject2).first;
        s.s(localObject4, "widthHeightPair.first");
        ((i)localObject3).width = ((Number)localObject4).floatValue();
        localObject3 = (i)localEntry.getValue();
        localObject2 = ((Pair)localObject2).second;
        s.s(localObject2, "widthHeightPair.second");
        ((i)localObject3).height = ((Number)localObject2).floatValue();
        d((i)localEntry.getValue());
      }
    }
    AppMethodBeat.o(300536);
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(300452);
    Object localObject;
    String str;
    if (parami.x <= this.zJD)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      if (!p.a((Iterable)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKA(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKA();
        str = parami.feedId;
        s.checkNotNull(str);
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      parami.zIQ = p.a(com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKA(), parami.feedId);
    }
    for (int i = 0;; i = 1)
    {
      parami.zJv = i;
      AppMethodBeat.o(300452);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      if (!p.a((Iterable)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKB(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKB();
        str = parami.feedId;
        s.checkNotNull(str);
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      parami.zIQ = p.a(com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKB(), parami.feedId);
    }
  }
  
  public final void c(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(300416);
    if (this.zJx.isEmpty())
    {
      AppMethodBeat.o(300416);
      return;
    }
    Iterator localIterator = ((Map)this.zJx).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (i)((Map.Entry)localObject2).getValue();
      if ((!paramList.contains(localObject1)) && (((i)localObject2).zJr > 0L))
      {
        ((i)localObject2).zJs = paramLong;
        ((i)localObject2).zJu = (((i)localObject2).zJs - ((i)localObject2).zJr);
        this.zJB = 0;
        ((i)localObject2).zJt = this.zJB;
        if (((i)localObject2).zIH <= 0L) {
          if (this.zJz > 0L) {
            break label197;
          }
        }
        label197:
        for (long l = this.zJA;; l = this.zJz)
        {
          ((i)localObject2).zIH = l;
          localObject1 = a.zIv;
          a.a.a((i)localObject2);
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(300416);
  }
  
  public final void d(i parami)
  {
    float f1 = 0.0F;
    int i = parami.y;
    float f2 = i + parami.height;
    if (i < this.zJE) {
      if (f2 > this.zJF) {
        f1 = this.zJF - this.zJE;
      }
    }
    for (;;)
    {
      parami.zIJ = (f1 * 100.0F / parami.height);
      parami.zIK = (f1 * parami.width * 100.0F / this.zJG);
      return;
      if (f2 > this.zJE)
      {
        f1 = f2 - this.zJE;
        continue;
        if (f2 > this.zJF)
        {
          if (i < this.zJF) {
            f1 = this.zJF - i;
          }
        }
        else {
          f1 = parami.height;
        }
      }
    }
  }
  
  public final Map<String, i> dLe()
  {
    AppMethodBeat.i(300525);
    Object localObject = new HashMap();
    ((HashMap)localObject).putAll((Map)this.zJx);
    ah((Map)localObject);
    localObject = (Map)localObject;
    AppMethodBeat.o(300525);
    return localObject;
  }
  
  public final boolean e(i parami)
  {
    int i = parami.y;
    float f1 = i;
    float f2 = parami.height;
    return (i < this.zJF) && (f1 + f2 > this.zJE);
  }
  
  final void ma(long paramLong)
  {
    AppMethodBeat.i(300551);
    Object localObject1 = this.zJI;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get())
    {
      AppMethodBeat.o(300551);
      return;
    }
    Object localObject2 = this.zDZ;
    if (localObject2 == null) {}
    for (localObject2 = null; localObject2 == null; localObject2 = (RecyclerView)((WeakReference)localObject2).get())
    {
      AppMethodBeat.o(300551);
      return;
    }
    Object localObject3 = ((StaggeredGridLayoutManager)localObject1).n(null);
    int i = Math.min(localObject3[0], localObject3[1]);
    localObject3 = ((StaggeredGridLayoutManager)localObject1).o(null);
    int j = Math.max(Math.max(localObject3[0], localObject3[1]) - zJM, 0);
    i = Math.max(i, zJM) - zJM;
    List localList = (List)new ArrayList();
    int k = j + 1;
    if (i < k) {}
    for (;;)
    {
      j = i + 1;
      Object localObject5 = ((StaggeredGridLayoutManager)localObject1).findViewByPosition(zJM + i);
      Object localObject4;
      long l;
      if (localObject5 != null)
      {
        localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.fb((View)localObject5);
        s.s(localObject4, "getCoordinateOnScreen(feedView)");
        localObject3 = (Integer)((Pair)localObject4).first;
        localObject4 = (Integer)((Pair)localObject4).second;
        localObject5 = a((View)localObject5, i, (RecyclerView)localObject2);
        if ((localObject5 != null) && (((i)localObject5).feedId != null))
        {
          String str = ((i)localObject5).feedId;
          s.checkNotNull(str);
          localList.add(str);
          if (this.zJz <= 0L) {}
          for (l = this.zJA;; l = this.zJz)
          {
            ((i)localObject5).zIH = l;
            s.s(localObject3, "x");
            ((i)localObject5).x = ((Integer)localObject3).intValue();
            s.s(localObject4, "y");
            ((i)localObject5).y = ((Integer)localObject4).intValue();
            ((i)localObject5).position = i;
            b((i)localObject5);
            c((i)localObject5);
            d((i)localObject5);
            if (e((i)localObject5)) {
              break label448;
            }
            localObject3 = (Map)this.zJx;
            localObject4 = ((i)localObject5).feedId;
            if (localObject3 != null) {
              break;
            }
            localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            AppMethodBeat.o(300551);
            throw ((Throwable)localObject1);
          }
          an.hJ(localObject3).remove(localObject4);
        }
      }
      if (j >= k)
      {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        c.a.dKO();
        AppMethodBeat.o(300551);
        return;
        label448:
        ((i)localObject5).zJr = this.zJA;
        ((i)localObject5).zJs = paramLong;
        localObject3 = this.zDk;
        if (localObject3 == null)
        {
          localObject3 = null;
          label477:
          ((i)localObject5).zIP = com.tencent.mm.plugin.expt.hellhound.core.b.aqX((String)localObject3);
          ((i)localObject5).zJu = (((i)localObject5).zJs - ((i)localObject5).zJr);
          ((i)localObject5).fhR = true;
          this.zJB = 1;
          ((i)localObject5).zJt = 1;
          if (((i)localObject5).zIH <= 0L) {
            if (this.zJz > 0L) {
              break label619;
            }
          }
        }
        label619:
        for (l = this.zJA;; l = this.zJz)
        {
          ((i)localObject5).zIH = l;
          localObject4 = this.zJy;
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
          }
          ((i)localObject5).sessionId = ((String)localObject3);
          ((i)localObject5).scene = this.mScene;
          ((i)localObject5).zIO = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
          break;
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)localObject3).LH(((i)localObject5).position);
          break label477;
        }
      }
      i = j;
    }
  }
  
  public final void s(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(300483);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
    localObject = c.a.fc(paramObject);
    if (localObject == null)
    {
      AppMethodBeat.o(300483);
      return;
    }
    Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", s.X("startStatisticsByHand, lastFeedMap: ", Integer.valueOf(((Map)localObject).size())));
    int i;
    if (!((Map)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label214;
      }
      this.zJx.clear();
      this.zJx.putAll((Map)localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      c.a.fd(paramObject);
      paramObject = ((Map)this.zJx).entrySet().iterator();
      label112:
      do
      {
        if (!paramObject.hasNext()) {
          break;
        }
        localObject = (i)((Map.Entry)paramObject.next()).getValue();
        ((i)localObject).zJr = paramLong;
        ((i)localObject).zJs = 0L;
        ((i)localObject).zJu = 0L;
        ((i)localObject).zJt = 0;
      } while (((i)localObject).zIH > 0L);
      if (this.zJz > 0L) {
        break label205;
      }
    }
    label205:
    for (long l = this.zJA;; l = this.zJz)
    {
      ((i)localObject).zIH = l;
      break label112;
      i = 0;
      break;
    }
    label214:
    AppMethodBeat.o(300483);
  }
  
  public final void t(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(300494);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)this.zJx);
    Object localObject = ((Map)localHashMap).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      f((i)localEntry.getValue());
      if (((i)localEntry.getValue()).zIJ <= 0.0F) {
        ((Iterator)localObject).remove();
      }
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
    c.a.b(paramObject, (Map)localHashMap);
    Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "stopStatisticsByHand, realFeedMap=" + localHashMap.size() + ", mFeedMap=" + this.zJx.size());
    a((Map)this.zJx, paramLong);
    AppMethodBeat.o(300494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.j
 * JD-Core Version:    0.7.0.1
 */