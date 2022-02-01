package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.commonview.IndicatorView;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h.a;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h.a.a;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.i;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/BigBannerListConvertData;", "outsideEventListener", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "audience21053Report", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "nearbyLiveViewItemClick", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/NewEntranceViewItemClick;", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clear", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "findFirstVisibleItemPositions", "", "lm", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "getLayoutId", "handleClickReport", "activity", "Landroid/app/Activity;", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "position", "handleExposeReport", "record", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onBindViewHolder", "item", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "runAutoSwitchCard", "tagObject", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$TagObject;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Companion", "SpacesItemDecoration", "TagObject", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f<com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d>
{
  public static final a ENI;
  private com.tencent.mm.plugin.finder.live.report.a EJr;
  private com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a EMS;
  private final h ENC;
  private bui ENE;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  
  static
  {
    AppMethodBeat.i(340612);
    ENI = new a((byte)0);
    AppMethodBeat.o(340612);
  }
  
  public c(h paramh, com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb)
  {
    AppMethodBeat.i(340555);
    this.ENC = paramh;
    this.ENg = paramb;
    this.EJr = new com.tencent.mm.plugin.finder.live.report.a();
    AppMethodBeat.o(340555);
  }
  
  private final void F(j paramj)
  {
    AppMethodBeat.i(340565);
    Object localObject1 = paramj.tag;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof c)))
    {
      localObject2 = ((c)localObject1).Bog;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = paramj.context;
        if (localObject3 == null)
        {
          paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(340565);
          throw paramj;
        }
        ((WxRecyclerView)localObject2).setAdapter((RecyclerView.a)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.d(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.e((MMActivity)localObject3, this.ENg), new ArrayList()));
      }
      ar.a(((c)localObject1).scope, null);
      localObject2 = ((c)localObject1).ENJ;
      if (localObject2 != null) {
        this.ENC.listeners.remove(localObject2);
      }
      localObject2 = ((c)localObject1).ENX;
      if (localObject2 != null)
      {
        localObject3 = ((c)localObject1).Bog;
        if (localObject3 != null) {
          ((WxRecyclerView)localObject3).b((RecyclerView.l)localObject2);
        }
      }
      ((c)localObject1).CVn.a(null);
      localObject2 = ((c)localObject1).EIX;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.nearby.live.play.e)localObject2).detach();
      }
      ((c)localObject1).EIX = null;
      localObject2 = ((c)localObject1).ENK;
      if (localObject2 != null)
      {
        localObject1 = MMApplicationContext.getContext().getApplicationContext();
        if (!(localObject1 instanceof Application)) {
          break label253;
        }
      }
    }
    label253:
    for (localObject1 = (Application)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((Application)localObject1).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject2);
      }
      paramj.tag = null;
      AppMethodBeat.o(340565);
      return;
    }
  }
  
  public static int a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager)
  {
    AppMethodBeat.i(370501);
    s.u(paramStaggeredGridLayoutManager, "lm");
    int[] arrayOfInt = new int[1];
    paramStaggeredGridLayoutManager.n(arrayOfInt);
    int i = arrayOfInt[0];
    AppMethodBeat.o(370501);
    return i;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340625);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = k.aeZF;
    paramRecyclerView = paramj.context;
    s.s(paramRecyclerView, "holder.context");
    paramRecyclerView = ((as)k.nq(paramRecyclerView).q(as.class)).fou();
    Object localObject = paramj.context;
    if (localObject == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(340625);
      throw paramRecyclerView;
    }
    this.EMS = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a(paramRecyclerView, (MMActivity)localObject, null, this.ENg);
    localObject = ah.aiuX;
    this.ENE = paramRecyclerView;
    paramRecyclerView = paramj.caK.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB = true;
    }
    paramRecyclerView = (WxRecyclerView)paramj.UH(f.d.EGu);
    if (paramRecyclerView != null) {
      com.tencent.mm.view.recyclerview.c.a((RecyclerView)paramRecyclerView, (com.tencent.mm.view.recyclerview.d)new g(this), (kotlin.g.a.b)i.akhQ);
    }
    AppMethodBeat.o(340625);
  }
  
  public final int getLayoutId()
  {
    return f.e.EGS;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(340631);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.i("BigBannerListConvert", s.X("#onViewRecycled holder=", paramj));
    F(paramj);
    AppMethodBeat.o(340631);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "left", "", "right", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    private final int left;
    private final int right;
    
    public b(int paramInt1, int paramInt2)
    {
      this.left = paramInt1;
      this.right = paramInt2;
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(340504);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramRect.left = this.left;
      paramRect.right = this.right;
      AppMethodBeat.o(340504);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$TagObject;", "", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert;)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;)V", "caller", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "getCaller", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "setCaller", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;)V", "lifeCallback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getLifeCallback", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setLifeCallback", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "pagerSnapHelper", "Landroidx/recyclerview/widget/PagerSnapHelper;", "getPagerSnapHelper", "()Landroidx/recyclerview/widget/PagerSnapHelper;", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "rvScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getRvScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "setRvScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class c
  {
    WxRecyclerView Bog;
    final t CVn;
    com.tencent.mm.plugin.finder.nearby.live.play.e EIX;
    h.a ENJ;
    Application.ActivityLifecycleCallbacks ENK;
    RecyclerView.l ENX;
    final aq scope;
    
    public c()
    {
      AppMethodBeat.i(340498);
      this.scope = ar.kBZ();
      this.CVn = new t();
      AppMethodBeat.o(340498);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements i.c<j>
  {
    d(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d paramd, c paramc, ah.f<WxRecyclerView> paramf) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$4", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(c paramc, IndicatorView paramIndicatorView) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(370549);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView == null) || (!(paramRecyclerView instanceof StaggeredGridLayoutManager)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(370549);
          return;
        }
        paramInt = c.a((StaggeredGridLayoutManager)paramRecyclerView);
        paramRecyclerView = this.akhP;
        if (paramRecyclerView != null) {
          paramRecyclerView.setSelectPoint(paramInt);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(370549);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(370552);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(370552);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$6", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller$SampleCaller;", "checkPlayer", "", "whichContainer", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scrollToLiveIdPosition", "", "liveId", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends h.a.a
  {
    f(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d paramd, c.c paramc, ah.f<WxRecyclerView> paramf) {}
    
    public final void bz(int paramInt, long paramLong)
    {
      AppMethodBeat.i(370547);
      if (this.ENM.ENs.Zpm != paramInt)
      {
        AppMethodBeat.o(370547);
        return;
      }
      Object localObject1 = this.ENM.ENs.YBg;
      if (localObject1 != null)
      {
        Object localObject2 = (Iterable)localObject1;
        localObject1 = this.ENH;
        paramInt = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          int i = paramInt + 1;
          if (paramInt < 0) {
            p.kkW();
          }
          localObject3 = ((bmz)localObject3).ZIo;
          if ((localObject3 != null) && (((FinderObject)localObject3).id == paramLong)) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label221;
            }
            localObject3 = (WxRecyclerView)((ah.f)localObject1).aqH;
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject3, locala.aYi(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$6", "scrollToLiveIdPosition", "(IJ)V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((WxRecyclerView)localObject3).smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$6", "scrollToLiveIdPosition", "(IJ)V", "Undefined", "smoothScrollToPosition", "(I)V");
            paramInt = i;
            break;
          }
          label221:
          paramInt = i;
        }
      }
      AppMethodBeat.o(370547);
    }
    
    public final void f(cc paramcc)
    {
      AppMethodBeat.i(370543);
      s.u(paramcc, "whichContainer");
      if (((paramcc instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d)) && (((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d)paramcc).ENs.Zpm == this.ENM.ENs.Zpm))
      {
        Log.i("BigBannerListConvert", "caller.checkPlayer is me! turn on check");
        paramcc = this.ENN.EIX;
        if (paramcc != null)
        {
          paramcc.sP(true);
          AppMethodBeat.o(370543);
        }
      }
      else
      {
        Log.i("BigBannerListConvert", "caller.checkPlayer isn't me! turn off check");
        paramcc = this.ENN.EIX;
        if (paramcc != null) {
          paramcc.sP(false);
        }
      }
      AppMethodBeat.o(370543);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onCreateViewHolder$3", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    g(c paramc) {}
    
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(340526);
      s.u(paramb, "item");
      AppMethodBeat.o(340526);
    }
    
    public final void s(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(340519);
      s.u(paramSet, "recordsSet");
      Log.i("BigBannerListConvert", s.X("onExposeTimeRecorded: size = ", Integer.valueOf(paramSet.size())));
      Object localObject2 = (Iterable)paramSet;
      Object localObject1 = this.ENL;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        c.a((c)localObject1, (com.tencent.mm.view.recyclerview.b)((Iterator)localObject2).next());
      }
      localObject1 = i.akhB;
      i.R(paramSet);
      AppMethodBeat.o(340519);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$onBindViewHolder$8", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/tools/SampleLifecycleCallbacks;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.tools.a
  {
    h(c.c paramc, c paramc1, j paramj) {}
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(370546);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("BigBannerListConvert", s.X("#lifeCallback-onActivityDestroyed autoPlayManager=", this.ENN.EIX));
        c.a(this.ENL, this.wHm);
      }
      AppMethodBeat.o(370546);
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(370541);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("BigBannerListConvert", s.X("#lifeCallback-onActivityStopped autoPlayManager=", this.ENN.EIX));
        paramActivity = this.ENN.EIX;
        if (paramActivity != null) {
          paramActivity.EKF.clear();
        }
        paramActivity = this.ENN.EIX;
        if (paramActivity != null) {
          paramActivity.eET();
        }
      }
      AppMethodBeat.o(370541);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(370537);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("BigBannerListConvert", s.X("#lifeCallback-onActivityStarted autoPlayManager=", this.ENN.EIX));
        paramActivity = this.ENN.EIX;
        if ((paramActivity != null) && (!paramActivity.EKz)) {
          paramActivity.eES();
        }
      }
      AppMethodBeat.o(370537);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<View, Boolean>
  {
    public static final i akhQ;
    
    static
    {
      AppMethodBeat.i(370538);
      akhQ = new i();
      AppMethodBeat.o(370538);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.c
 * JD-Core Version:    0.7.0.1
 */