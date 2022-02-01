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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/app/Activity;Landroid/support/v4/app/Fragment;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mClickStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "mDisAppearType", "", "mDisAppearTypeOnRefreshBegin", "mFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "Lkotlin/collections/HashMap;", "mFeedMapOnRefreshBegin", "mFeedParamCatcher", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "mLayoutManagerRef", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "mPageEntryTimestamp", "", "mRecyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "mRefreshEndTimestampLatested", "mRefreshTimestampOnRefresBegin", "mScene", "mScreenArea", "", "mScreenBottom", "mScreenMidX", "mScreenTop", "mScreenWidth", "mSessionPageId", "computeOnLoadMoreEnd", "", "computeOnRefreshBegin", "computeOnRefreshEnd", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "computeOnScrolled", "recyclerView", "layoutManager", "fillFeedExposureAreaWeigth", "feed", "fillItemArrayIndex", "fillItemPosition", "fillTimestamp", "timestamp", "fuckNoScrollWhenEnterActivity", "getFeedParams", "feedView", "Landroid/view/View;", "position", "getFeedWhenClick", "getFeedsOfScreen", "", "initActivityFeedParamsCatcher", "initFeedParamsCatcher", "initFragmentFeedParamsCatcher", "initScreen", "isFeedAppear", "", "isFeedDisappear", "isFeedGone", "isFeedShow", "reGetViewParams", "reGetViewsParams", "feedMap", "report19944", "reportLeftFeed", "visitingFeedIdList", "", "startCompute", "eventId", "startStatisticsByHand", "page", "statisticsFeed", "stopCompute", "stopStatisticsByHand", "Companion", "plugin-expt_release"})
public final class j
{
  public static final a KIU;
  public static int qui;
  public final HashMap<String, i> KIF;
  private String KIG;
  public long KIH;
  public final long KII;
  public int KIJ;
  private float KIK;
  private float KIL;
  public float KIM;
  public float KIN;
  private float KIO;
  public final c KIP;
  public WeakReference<StaggeredGridLayoutManager> KIQ;
  public HashMap<String, i> KIR;
  public long KIS;
  public int KIT;
  private WeakReference<Activity> mActivityRef;
  private int mScene;
  public WeakReference<RecyclerView> pFP;
  com.tencent.mm.plugin.expt.hellhound.a.a.a.b pFp;
  
  static
  {
    AppMethodBeat.i(205333);
    KIU = new a((byte)0);
    AppMethodBeat.o(205333);
  }
  
  public j(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(205332);
    this.KIF = new HashMap();
    this.KII = System.currentTimeMillis();
    if (paramActivity != null) {
      this.mActivityRef = new WeakReference(paramActivity);
    }
    this.KIG = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
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
          AppMethodBeat.o(205332);
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
        this.KIK = localPoint1.x;
        this.KIL = (this.KIK / 2.0F);
        float f1 = localPoint1.y;
        i = localPoint2.y;
        float f2 = com.tencent.mm.plugin.expt.hellhound.core.b.bs(paramActivity);
        int j = Math.max(com.tencent.mm.plugin.expt.hellhound.core.b.u(paramActivity), paramActivity.getResources().getDimensionPixelSize(2131165252));
        this.KIM = (j + f2);
        this.KIN = f1;
        this.KIO = (this.KIK * (this.KIN - this.KIM));
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.bY(this.KIO);
        ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "initScreen:\nmScreenMid=" + this.KIL + '\n' + "mScreenWidth=" + this.KIK + '\n' + "screenRealHeight=" + i + '\n' + "screenHeight=" + f1 + '\n' + "statusBarHeight=" + f2 + '\n' + "actionBarHeight=" + j + '\n' + "mScreenTop=" + this.KIM + '\n' + "mScreenBottom=" + this.KIN + '\n' + "mScreenArea=" + this.KIO);
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
      this.KIP = new c(this);
      this.KIR = new HashMap();
      this.KIS = -1L;
      this.KIT = -1;
      AppMethodBeat.o(205332);
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
        this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        qui = 0;
        this.mScene = c.d.KGU.value;
        break;
      case 395150120: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI")) {
          break;
        }
        this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new g(paramActivity));
        qui = 1;
        this.mScene = c.d.KGY.value;
        break;
      case -1570624296: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI")) {
          break;
        }
        this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new b());
        qui = 0;
        this.mScene = c.d.KGZ.value;
        break;
      case 1251839313: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.search.FinderMixSearchUI")) {
          break;
        }
        this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new e(paramActivity));
        qui = 5;
        this.mScene = c.d.KGX.value;
        break;
      case 782364972: 
        if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
          break;
        }
        this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new h());
        qui = 1;
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
        if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRJ() != c.c.KGS.value) {}
      case 786042180: 
      case -1577760806: 
        for (i = c.d.KGW.value;; i = c.d.KGV.value)
        {
          this.mScene = i;
          break label500;
          if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC")) {
            break;
          }
          this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
          qui = 0;
          this.mScene = c.d.KGU.value;
          break label500;
          if (!paramFragment.equals("com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2")) {
            break;
          }
          this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
          qui = 0;
          this.mScene = c.d.KGU.value;
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
        this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)new f());
        qui = 0;
        this.mScene = c.d.KGU.value;
      }
    }
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(205324);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
    if (d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRA(), parami.feedId)) {
      if (parami.hj >= 0) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRA();
        String str = parami.feedId;
        if (str == null) {
          k.fvU();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      parami.hj = d.a.j.b(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRA(), parami.feedId);
      AppMethodBeat.o(205324);
      return;
      AppMethodBeat.o(205324);
      return;
    }
  }
  
  public static void fRP()
  {
    AppMethodBeat.i(205321);
    ad.d("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnLoadMoreEnd");
    AppMethodBeat.o(205321);
  }
  
  final void Bp(long paramLong)
  {
    AppMethodBeat.i(205331);
    Object localObject1 = this.KIQ;
    StaggeredGridLayoutManager localStaggeredGridLayoutManager;
    if (localObject1 != null)
    {
      localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localStaggeredGridLayoutManager != null) {}
    }
    else
    {
      AppMethodBeat.o(205331);
      return;
    }
    k.g(localStaggeredGridLayoutManager, "mLayoutManagerRef?.get() ?: return");
    localObject1 = this.pFP;
    RecyclerView localRecyclerView;
    if (localObject1 != null)
    {
      localRecyclerView = (RecyclerView)((WeakReference)localObject1).get();
      if (localRecyclerView != null) {}
    }
    else
    {
      AppMethodBeat.o(205331);
      return;
    }
    k.g(localRecyclerView, "mRecyclerViewRef?.get() ?: return");
    localObject1 = localStaggeredGridLayoutManager.x(null);
    int i = Math.min(localObject1[0], localObject1[1]);
    localObject1 = localStaggeredGridLayoutManager.ma();
    int j = Math.max(Math.max(localObject1[0], localObject1[1]) - qui, 0);
    i = Math.max(i, qui);
    int k = qui;
    List localList = (List)new ArrayList();
    i -= k;
    if (i < j + 1)
    {
      Object localObject3 = localStaggeredGridLayoutManager.bY(qui + i);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.gM((View)localObject3);
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
            k.fvU();
          }
          localList.add(str);
          if (this.KIH <= 0L) {}
          for (l = this.KII;; l = this.KIH)
          {
            ((i)localObject3).KHZ = l;
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
            localObject1 = (Map)this.KIF;
            localObject2 = ((i)localObject3).feedId;
            if (localObject1 != null) {
              break;
            }
            localObject1 = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            AppMethodBeat.o(205331);
            throw ((Throwable)localObject1);
          }
          aa.eP(localObject1).remove(localObject2);
        }
      }
      label439:
      ((i)localObject3).KIA = this.KII;
      ((i)localObject3).KIB = paramLong;
      localObject1 = this.pFp;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).agS(((i)localObject3).position);
        label479:
        ((i)localObject3).KIg = com.tencent.mm.plugin.expt.hellhound.core.b.aUO((String)localObject1);
        ((i)localObject3).KID = (((i)localObject3).KIB - ((i)localObject3).KIA);
        ((i)localObject3).cEL = true;
        this.KIJ = 1;
        ((i)localObject3).KIC = 1;
        if (((i)localObject3).KHZ <= 0L) {
          if (this.KIH > 0L) {
            break label610;
          }
        }
      }
      label610:
      for (long l = this.KII;; l = this.KIH)
      {
        ((i)localObject3).KHZ = l;
        localObject2 = this.KIG;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
        }
        ((i)localObject3).sessionId = ((String)localObject1);
        ((i)localObject3).scene = this.mScene;
        ((i)localObject3).qwV = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
        break;
        localObject1 = null;
        break label479;
      }
    }
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
    c.a.fRL();
    AppMethodBeat.o(205331);
  }
  
  public final i a(View paramView, int paramInt, RecyclerView paramRecyclerView)
  {
    com.tencent.mm.plugin.expt.hellhound.a.a.a.b localb = null;
    String str = null;
    AppMethodBeat.i(205323);
    Object localObject = this.pFp;
    if (localObject != null) {
      ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).setRecyclerView(paramRecyclerView);
    }
    paramRecyclerView = this.pFp;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.ab(paramView, paramInt); paramRecyclerView == null; paramRecyclerView = null)
    {
      AppMethodBeat.o(205323);
      return null;
    }
    i locali = (i)this.KIF.get(paramRecyclerView);
    if (locali == null)
    {
      locali = new i((byte)0);
      locali.feedId = paramRecyclerView;
      localObject = this.pFp;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ac(paramView, paramInt);
        locali.userName = ((String)localObject);
        localObject = this.pFp;
        if (localObject == null) {
          break label331;
        }
        localObject = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).ad(paramView, paramInt);
        label151:
        locali.bNK = ((String)localObject);
        localb = this.pFp;
        localObject = str;
        if (localb != null) {
          localObject = localb.agS(paramInt);
        }
        locali.KIg = com.tencent.mm.plugin.expt.hellhound.core.b.aUO((String)localObject);
        str = this.KIG;
        localObject = str;
        if (str == null) {
          localObject = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
        }
        locali.sessionId = ((String)localObject);
        locali.scene = this.mScene;
        locali.qwV = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.gN(paramView);
        localObject = paramView.first;
        k.g(localObject, "widthHeightPair.first");
        locali.width = ((Number)localObject).floatValue();
        paramView = paramView.second;
        k.g(paramView, "widthHeightPair.second");
        locali.height = ((Number)paramView).floatValue();
        ((Map)this.KIF).put(paramRecyclerView, locali);
        localObject = locali;
      }
    }
    label331:
    do
    {
      AppMethodBeat.o(205323);
      return localObject;
      localObject = null;
      break;
      localObject = null;
      break label151;
      if ((locali.KIg == null) || (locali.height <= 0.0F)) {
        break label367;
      }
      localObject = locali;
    } while (locali.y > 0);
    label367:
    locali.feedId = paramRecyclerView;
    paramRecyclerView = this.pFp;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.ac(paramView, paramInt);
      label391:
      locali.userName = paramRecyclerView;
      paramRecyclerView = this.pFp;
      if (paramRecyclerView == null) {
        break label562;
      }
    }
    label562:
    for (paramRecyclerView = paramRecyclerView.ad(paramView, paramInt);; paramRecyclerView = null)
    {
      locali.bNK = paramRecyclerView;
      localObject = this.pFp;
      paramRecyclerView = localb;
      if (localObject != null) {
        paramRecyclerView = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject).agS(paramInt);
      }
      locali.KIg = com.tencent.mm.plugin.expt.hellhound.core.b.aUO(paramRecyclerView);
      localObject = this.KIG;
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
      }
      locali.sessionId = paramRecyclerView;
      locali.scene = this.mScene;
      locali.qwV = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.gN(paramView);
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
    AppMethodBeat.i(205326);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
    if (paramObject == null) {
      localObject = null;
    }
    int i;
    while (localObject == null)
    {
      AppMethodBeat.o(205326);
      return;
      i = paramObject.hashCode();
      Map localMap = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRx().get(Integer.valueOf(i));
      localObject = localMap;
      if (localMap == null) {
        localObject = (Map)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRy().get(paramObject.getClass().getName());
      }
    }
    ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "startStatisticsByHand, lastFeedMap: " + ((Map)localObject).size());
    if (!((Map)localObject).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label310;
      }
      this.KIF.clear();
      this.KIF.putAll((Map)localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      if (paramObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRx().remove(Integer.valueOf(paramObject.hashCode()));
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRy().remove(paramObject.getClass().getName());
      }
      paramObject = ((Map)this.KIF).entrySet().iterator();
      label208:
      do
      {
        if (!paramObject.hasNext()) {
          break;
        }
        localObject = (i)((Map.Entry)paramObject.next()).getValue();
        ((i)localObject).KIA = paramLong;
        ((i)localObject).KIB = 0L;
        ((i)localObject).KID = 0L;
        ((i)localObject).KIC = 0;
      } while (((i)localObject).KHZ > 0L);
      if (this.KIH > 0L) {
        break label301;
      }
    }
    label301:
    for (long l = this.KII;; l = this.KIH)
    {
      ((i)localObject).KHZ = l;
      break label208;
      i = 0;
      break;
    }
    label310:
    AppMethodBeat.o(205326);
  }
  
  public final void a(Map<String, i> paramMap, long paramLong)
  {
    AppMethodBeat.i(205328);
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)((Map.Entry)localIterator.next()).getValue();
      locali.KIB = paramLong;
      locali.KID = (locali.KIB - locali.KIA);
      locali.KIC = this.KIJ;
      if (locali.KHZ <= 0L) {
        if (this.KIH > 0L) {
          break label125;
        }
      }
      label125:
      for (long l = this.KII;; l = this.KIH)
      {
        locali.KHZ = l;
        a.a locala = a.KHO;
        a.a.a(locali);
        break;
      }
    }
    paramMap.clear();
    AppMethodBeat.o(205328);
  }
  
  public final void b(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(205327);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)this.KIF);
    Object localObject1 = ((Map)localHashMap).entrySet().iterator();
    Object localObject2;
    label132:
    label294:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      i locali = (i)((Map.Entry)localObject2).getValue();
      Object localObject3 = this.KIQ;
      if (localObject3 != null)
      {
        localObject3 = (StaggeredGridLayoutManager)((WeakReference)localObject3).get();
        if (localObject3 != null) {
          break label132;
        }
      }
      for (;;)
      {
        if (((i)((Map.Entry)localObject2).getValue()).KIb > 0.0F) {
          break label294;
        }
        ((Iterator)localObject1).remove();
        break;
        k.g(localObject3, "mLayoutManagerRef?.get() ?: return");
        localObject3 = ((StaggeredGridLayoutManager)localObject3).bY(qui + locali.position);
        if (localObject3 != null)
        {
          Object localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.gM((View)localObject3);
          Object localObject5 = ((Pair)localObject4).first;
          k.g(localObject5, "xy.first");
          locali.x = ((Number)localObject5).intValue();
          localObject4 = ((Pair)localObject4).second;
          k.g(localObject4, "xy.second");
          locali.y = ((Number)localObject4).intValue();
          localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.gN((View)localObject3);
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
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
    localObject1 = (Map)localHashMap;
    k.h(localObject1, "feedMap");
    if (paramObject != null)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRx().put(Integer.valueOf(paramObject.hashCode()), localObject1);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRy();
      paramObject = paramObject.getClass().getName();
      k.g(paramObject, "page.javaClass.name");
      ((Map)localObject2).put(paramObject, localObject1);
    }
    ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "stopStatisticsByHand, realFeedMap=" + localHashMap.size() + ", mFeedMap=" + this.KIF.size());
    a((Map)this.KIF, paramLong);
    AppMethodBeat.o(205327);
  }
  
  public final void bZ(Map<String, i> paramMap)
  {
    AppMethodBeat.i(205330);
    Object localObject1 = this.KIQ;
    if (localObject1 != null)
    {
      localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(205330);
      return;
    }
    k.g(localObject1, "mLayoutManagerRef?.get() ?: return");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int i = qui;
      Object localObject2 = ((StaggeredGridLayoutManager)localObject1).bY(((i)localEntry.getValue()).position + i);
      if (localObject2 != null)
      {
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.gM((View)localObject2);
        Object localObject4 = (i)localEntry.getValue();
        Object localObject5 = ((Pair)localObject3).first;
        k.g(localObject5, "xy.first");
        ((i)localObject4).x = ((Number)localObject5).intValue();
        localObject4 = (i)localEntry.getValue();
        localObject3 = ((Pair)localObject3).second;
        k.g(localObject3, "xy.second");
        ((i)localObject4).y = ((Number)localObject3).intValue();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.gN((View)localObject2);
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
    AppMethodBeat.o(205330);
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(205325);
    Object localObject;
    String str;
    if (parami.x <= this.KIL)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      if (!d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRB(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRB();
        str = parami.feedId;
        if (str == null) {
          k.fvU();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      parami.KIh = d.a.j.b(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRB(), parami.feedId);
    }
    for (int i = 0;; i = 1)
    {
      parami.KIE = i;
      AppMethodBeat.o(205325);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      if (!d.a.j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRC(), parami.feedId))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRC();
        str = parami.feedId;
        if (str == null) {
          k.fvU();
        }
        ((List)localObject).add(str);
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      parami.KIh = d.a.j.b(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRC(), parami.feedId);
    }
  }
  
  public final void d(i parami)
  {
    float f1 = 0.0F;
    int i = parami.y;
    float f2 = i + parami.height;
    if (i < this.KIM) {
      if (f2 > this.KIN) {
        f1 = this.KIN - this.KIM;
      }
    }
    for (;;)
    {
      parami.KIb = (f1 * 100.0F / parami.height);
      parami.KIc = (f1 * parami.width * 100.0F / this.KIO);
      return;
      if (f2 > this.KIM)
      {
        f1 = f2 - this.KIM;
        continue;
        if (f2 > this.KIN)
        {
          if (i < this.KIN) {
            f1 = this.KIN - i;
          }
        }
        else {
          f1 = parami.height;
        }
      }
    }
  }
  
  public final void e(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(205322);
    if (this.KIF.isEmpty())
    {
      AppMethodBeat.o(205322);
      return;
    }
    Iterator localIterator = ((Map)this.KIF).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (i)((Map.Entry)localObject2).getValue();
      if ((!paramList.contains(localObject1)) && (((i)localObject2).KIA > 0L))
      {
        ((i)localObject2).KIB = paramLong;
        ((i)localObject2).KID = (((i)localObject2).KIB - ((i)localObject2).KIA);
        this.KIJ = 0;
        ((i)localObject2).KIC = this.KIJ;
        if (((i)localObject2).KHZ <= 0L) {
          if (this.KIH > 0L) {
            break label197;
          }
        }
        label197:
        for (long l = this.KII;; l = this.KIH)
        {
          ((i)localObject2).KHZ = l;
          localObject1 = a.KHO;
          a.a.a((i)localObject2);
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(205322);
  }
  
  public final boolean e(i parami)
  {
    int i = parami.y;
    float f1 = i;
    float f2 = parami.height;
    return (i < this.KIN) && (f1 + f2 > this.KIM);
  }
  
  public final Map<String, i> fRQ()
  {
    AppMethodBeat.i(205329);
    Object localObject = new HashMap();
    ((HashMap)localObject).putAll((Map)this.KIF);
    bZ((Map)localObject);
    localObject = (Map)localObject;
    AppMethodBeat.o(205329);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics$Companion;", "", "()V", "HEADER_COUNT", "", "TAG", "", "WATERFALLS_FLOW_COUNT", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.j
 * JD-Core Version:    0.7.0.1
 */