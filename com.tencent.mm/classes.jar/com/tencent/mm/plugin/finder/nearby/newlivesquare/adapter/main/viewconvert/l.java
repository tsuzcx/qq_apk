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
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.live.play.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.m;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.g;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h.a;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h.a.a;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/SpecialColumnListConvertData;", "outsideEventListener", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "audience21053Report", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "nearbyLiveViewItemClick", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/NewEntranceViewItemClick;", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clear", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getLayoutId", "", "gotoMoreLiveImpl", "context", "Landroid/content/Context;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "handleClickReport", "activity", "Landroid/app/Activity;", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "position", "item", "handleExposeReport", "record", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "Companion", "SpacesItemDecoration", "TagObject", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends f<m>
{
  public static final a EOx;
  private com.tencent.mm.plugin.finder.live.report.a EJr;
  private com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a EMS;
  private final h ENC;
  private bui ENE;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  
  static
  {
    AppMethodBeat.i(340583);
    EOx = new a((byte)0);
    AppMethodBeat.o(340583);
  }
  
  public l(h paramh, com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb)
  {
    AppMethodBeat.i(340514);
    this.ENC = paramh;
    this.ENg = paramb;
    this.EJr = new com.tencent.mm.plugin.finder.live.report.a();
    AppMethodBeat.o(340514);
  }
  
  private final void F(j paramj)
  {
    AppMethodBeat.i(340521);
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
          AppMethodBeat.o(340521);
          throw paramj;
        }
        ((WxRecyclerView)localObject2).setAdapter((RecyclerView.a)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.k(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.l((MMActivity)localObject3, this.ENg), new ArrayList()));
      }
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
      localObject2 = ((c)localObject1).EIX;
      if (localObject2 != null) {
        ((e)localObject2).detach();
      }
      ((c)localObject1).EIX = null;
      localObject2 = ((c)localObject1).ENK;
      if (localObject2 != null)
      {
        localObject1 = MMApplicationContext.getContext().getApplicationContext();
        if (!(localObject1 instanceof Application)) {
          break label231;
        }
      }
    }
    label231:
    for (localObject1 = (Application)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((Application)localObject1).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject2);
      }
      paramj.tag = null;
      AppMethodBeat.o(340521);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340597);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
    paramRecyclerView = paramj.context;
    s.s(paramRecyclerView, "holder.context");
    paramRecyclerView = ((as)com.tencent.mm.ui.component.k.nq(paramRecyclerView).q(as.class)).fou();
    Object localObject = paramj.context;
    if (localObject == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(340597);
      throw paramRecyclerView;
    }
    this.EMS = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a(paramRecyclerView, (MMActivity)localObject, null, this.ENg);
    localObject = ah.aiuX;
    this.ENE = paramRecyclerView;
    paramRecyclerView = paramj.caK.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB = true;
    }
    paramRecyclerView = (WxRecyclerView)paramj.UH(f.d.EGw);
    if (paramRecyclerView != null) {
      com.tencent.mm.view.recyclerview.c.a((RecyclerView)paramRecyclerView, (d)new h(this), (kotlin.g.a.b)i.akhZ);
    }
    AppMethodBeat.o(340597);
  }
  
  public final int getLayoutId()
  {
    return f.e.EGZ;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(340607);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.i("Finder.SpecialColumnListConvert", s.X("#onViewRecycled holder=", paramj));
    F(paramj);
    AppMethodBeat.o(340607);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "left", "", "right", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    private final int left;
    private final int right;
    
    public b(int paramInt)
    {
      this.left = paramInt;
      this.right = 0;
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(340445);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramRect.left = this.left;
      paramRect.right = this.right;
      AppMethodBeat.o(340445);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$TagObject;", "", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert;)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;)V", "caller", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "getCaller", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "setCaller", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;)V", "lifeCallback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getLifeCallback", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setLifeCallback", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "rvScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getRvScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "setRvScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class c
  {
    WxRecyclerView Bog;
    e EIX;
    h.a ENJ;
    Application.ActivityLifecycleCallbacks ENK;
    RecyclerView.l ENX;
    
    public c()
    {
      AppMethodBeat.i(340440);
      AppMethodBeat.o(340440);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isLoadingMore", "", "()Z", "setLoadingMore", "(Z)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    boolean isLoadingMore;
    
    d(m paramm, l paraml) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(340456);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(340456);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(340447);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      l locall;
      if (paramRecyclerView != null)
      {
        localObject = this.EOz;
        locall = this.EOy;
        if (!(paramRecyclerView instanceof FinderStaggeredGridLayoutManager))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(340447);
          return;
        }
        int[] arrayOfInt = new int[1];
        ((FinderStaggeredGridLayoutManager)paramRecyclerView).o(arrayOfInt);
        if (arrayOfInt[0] == ((m)localObject).EML.size() - 1) {}
        for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(340447);
          return;
        }
        if (((m)localObject).ENs.BeA <= 0) {
          break label252;
        }
      }
      label252:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((paramInt1 != 0) && (!this.isLoadingMore))
        {
          Log.i("Finder.SpecialColumnListConvert", "#rvScrollListener-onScrollStateChanged ready to load");
          this.isLoadingMore = true;
          l.a(locall).d(((m)localObject).ENs.Zpm, (kotlin.g.a.b)new a(this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(340447);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<b.a<bqr>, ah>
    {
      a(l.d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$5", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller$SampleCaller;", "append", "", "containerId", "", "cards", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamCard;", "checkPlayer", "whichContainer", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scrollToLiveIdPosition", "liveId", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends h.a.a
  {
    e(m paramm, com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.k paramk, l paraml, l.c paramc, WxRecyclerView paramWxRecyclerView) {}
    
    public final void E(int paramInt, List<? extends bmz> paramList)
    {
      AppMethodBeat.i(340449);
      s.u(paramList, "cards");
      if (paramInt != this.EOz.ENs.Zpm)
      {
        AppMethodBeat.o(340449);
        return;
      }
      Object localObject1 = i.EOv;
      i.a.a(this.EOz.EML, (WxRecyclerAdapter)this.EOB);
      this.EOz.ENs.YBg.addAll((Collection)paramList);
      Object localObject2 = (Iterable)paramList;
      paramList = this.EOz;
      localObject1 = this.EOy;
      com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.k localk = this.EOB;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bmz localbmz = (bmz)((Iterator)localObject2).next();
        g localg = g.ENe;
        if (g.a((List)paramList.EML, localbmz, paramList, l.b((l)localObject1))) {
          localk.fW(paramList.EML.size() - 1);
        }
      }
      paramList = i.EOv;
      i.a.a(this.EOz.EML, (WxRecyclerAdapter)this.EOB, this.EOz.ENs.BeA);
      AppMethodBeat.o(340449);
    }
    
    public final void bz(int paramInt, long paramLong)
    {
      AppMethodBeat.i(370511);
      if (this.EOz.ENs.Zpm != paramInt)
      {
        AppMethodBeat.o(370511);
        return;
      }
      Object localObject1 = this.EOz.ENs.YBg;
      if (localObject1 != null)
      {
        Object localObject2 = (Iterable)localObject1;
        localObject1 = this.EOc;
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
              break label211;
            }
            localObject3 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$5", "scrollToLiveIdPosition", "(IJ)V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((WxRecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$5", "scrollToLiveIdPosition", "(IJ)V", "Undefined", "smoothScrollToPosition", "(I)V");
            paramInt = i;
            break;
          }
          label211:
          paramInt = i;
        }
      }
      AppMethodBeat.o(370511);
    }
    
    public final void f(cc paramcc)
    {
      AppMethodBeat.i(340459);
      s.u(paramcc, "whichContainer");
      if (((paramcc instanceof m)) && (((m)paramcc).ENs.Zpm == this.EOz.ENs.Zpm))
      {
        Log.i("Finder.SpecialColumnListConvert", "caller.checkPlayer is me! turn on check");
        paramcc = this.EOC.EIX;
        if (paramcc != null)
        {
          paramcc.sP(true);
          AppMethodBeat.o(340459);
        }
      }
      else
      {
        Log.i("Finder.SpecialColumnListConvert", "caller.checkPlayer isn't me! turn off check");
        paramcc = this.EOC.EIX;
        if (paramcc != null) {
          paramcc.sP(false);
        }
      }
      AppMethodBeat.o(340459);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$7", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/tools/SampleLifecycleCallbacks;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.tools.a
  {
    f(l.c paramc, l paraml, j paramj) {}
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(340455);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("Finder.SpecialColumnListConvert", s.X("#lifeCallback-onActivityDestroyed autoPlayManager=", this.EOC.EIX));
        l.a(this.EOy, this.wHm);
      }
      AppMethodBeat.o(340455);
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(340446);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("Finder.SpecialColumnListConvert", s.X("#lifeCallback-onActivityStopped autoPlayManager=", this.EOC.EIX));
        paramActivity = this.EOC.EIX;
        if (paramActivity != null) {
          paramActivity.EKF.clear();
        }
        paramActivity = this.EOC.EIX;
        if (paramActivity != null) {
          paramActivity.eET();
        }
      }
      AppMethodBeat.o(340446);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(340442);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("Finder.SpecialColumnListConvert", s.X("#lifeCallback-onActivityStarted autoPlayManager=", this.EOC.EIX));
        paramActivity = this.EOC.EIX;
        if ((paramActivity != null) && (!paramActivity.EKz)) {
          paramActivity.eES();
        }
      }
      AppMethodBeat.o(340442);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onBindViewHolder$adapter$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements i.c<j>
  {
    g(m paramm, l paraml, WxRecyclerView paramWxRecyclerView) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/SpecialColumnListConvert$onCreateViewHolder$3", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends d<com.tencent.mm.view.recyclerview.a>
  {
    h(l paraml) {}
    
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(340463);
      s.u(paramb, "item");
      AppMethodBeat.o(340463);
    }
    
    public final void s(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(340453);
      s.u(paramSet, "recordsSet");
      Log.i("Finder.SpecialColumnListConvert", s.X("onExposeTimeRecorded: size = ", Integer.valueOf(paramSet.size())));
      Object localObject2 = (Iterable)paramSet;
      Object localObject1 = this.EOy;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        l.a((l)localObject1, (com.tencent.mm.view.recyclerview.b)((Iterator)localObject2).next());
      }
      localObject1 = com.tencent.mm.plugin.finder.nearby.newlivesquare.i.akhB;
      com.tencent.mm.plugin.finder.nearby.newlivesquare.i.R(paramSet);
      AppMethodBeat.o(340453);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<View, Boolean>
  {
    public static final i akhZ;
    
    static
    {
      AppMethodBeat.i(370502);
      akhZ = new i();
      AppMethodBeat.o(370502);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.l
 * JD-Core Version:    0.7.0.1
 */