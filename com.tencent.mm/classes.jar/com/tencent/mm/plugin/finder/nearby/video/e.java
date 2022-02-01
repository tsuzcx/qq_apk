package com.tencent.mm.plugin.finder.nearby.video;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.b;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Set<Lcom.tencent.mm.view.recyclerview.b<Lcom.tencent.mm.view.recyclerview.a;>;>;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;Landroid/view/View;)V", "clickPosition", "", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "nearbyLiveViewItemClick", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewItemClick;", "getActivity", "getClickPosition", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "jumpToFinderFeed", "intent", "Landroid/content/Intent;", "it", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "clickTabContextId", "", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements a.b<cc>
{
  public static final a ERT;
  private final MMActivity AZo;
  private final bui Auc;
  private com.tencent.mm.plugin.finder.storage.as AxD;
  private final AbsNearByFragment EJl;
  private final com.tencent.mm.plugin.finder.nearby.live.g EJs;
  private final a.a<cc> ERU;
  int ERV;
  private final View nma;
  
  static
  {
    AppMethodBeat.i(340190);
    ERT = new a((byte)0);
    AppMethodBeat.o(340190);
  }
  
  public e(bui parambui, MMActivity paramMMActivity, AbsNearByFragment paramAbsNearByFragment, a.a<cc> parama, View paramView)
  {
    AppMethodBeat.i(340128);
    this.Auc = parambui;
    this.AZo = paramMMActivity;
    this.EJl = paramAbsNearByFragment;
    this.ERU = parama;
    this.nma = paramView;
    this.AxD = ((com.tencent.mm.plugin.finder.storage.as)new c(this.AZo));
    this.ERV = -1;
    this.EJs = new com.tencent.mm.plugin.finder.nearby.live.g(this.Auc, this.AZo, this.EJl, 15, null);
    AppMethodBeat.o(340128);
  }
  
  public final RefreshLoadMoreLayout aNL()
  {
    AppMethodBeat.i(340219);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.nma.findViewById(f.d.rl_layout);
    s.s(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(340219);
    return localRefreshLoadMoreLayout;
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(340210);
    s.u(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.nma.findViewById(f.d.rl_layout);
    Object localObject1 = MMApplicationContext.getContext().getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(f.b.finder_timeline_refresh_height) - (int)((Resources)localObject1).getDimension(f.b.Edge_12A));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(f.b.Edge_7A) - (int)((Resources)localObject1).getDimension(f.b.finder_timeline_refresh_height));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.AxD;
    Context localContext = this.nma.getContext();
    s.s(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((com.tencent.mm.plugin.finder.storage.as)localObject2).fT(localContext));
    ((RecyclerView)localObject1).a(this.AxD.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.AxD.j(this.AZo));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).bZL = 0L;
    }
    localObject2 = new e(paramArrayList, this.AxD.au((kotlin.g.a.b)new f(this)));
    ((i)localObject2).agOe = ((i.c)new b(paramArrayList, this, (RecyclerView)localObject1, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.d.eSQ().bmg()).intValue());
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.b)new c(this));
    paramArrayList = k.aeZF;
    paramArrayList = k.y((Fragment)this.EJl).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
    s.s(paramArrayList, "UICProvider.of(fragment)…rReporterUIC::class.java)");
    paramArrayList = com.tencent.mm.plugin.finder.viewmodel.component.as.b((com.tencent.mm.plugin.finder.viewmodel.component.as)paramArrayList);
    if (paramArrayList != null) {
      paramArrayList.o((RecyclerView)localObject1);
    }
    com.tencent.mm.view.recyclerview.c.a((RecyclerView)localObject1, (com.tencent.mm.view.recyclerview.d)new d(this));
    AppMethodBeat.o(340210);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(340216);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.nma.findViewById(f.d.rl_layout)).getRecyclerView();
    AppMethodBeat.o(340216);
    return localRecyclerView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(ArrayList<cc> paramArrayList, e parame, RecyclerView paramRecyclerView, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    c(e parame) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(340029);
      super.IH(paramInt);
      e.a(this.ERW).onRefresh();
      AppMethodBeat.o(340029);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(340050);
      s.u(paramd, "reason");
      super.a(paramd);
      AppMethodBeat.o(340050);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(340038);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      e.a(this.ERW).onRefreshEnd(paramd);
      AppMethodBeat.o(340038);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(340044);
      super.qI(paramInt);
      e.a(this.ERW).onLoadMore();
      AppMethodBeat.o(340044);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    d(e parame) {}
    
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(340063);
      s.u(paramb, "item");
      if ((paramb.agNK instanceof com.tencent.mm.plugin.finder.model.ah))
      {
        dmk localdmk = new dmk();
        com.tencent.mm.plugin.finder.model.ah localah = (com.tencent.mm.plugin.finder.model.ah)paramb.agNK;
        localdmk.hKN = localah.bZA();
        localdmk.aaSu = ((int)paramb.startTime);
        paramb = ay.EDk;
        ay.a(localdmk, e.a(this.ERW).getCommentScene());
        paramb = com.tencent.mm.plugin.finder.nearby.report.e.EQU;
        com.tencent.mm.plugin.finder.nearby.report.e.a(e.a(this.ERW).getCommentScene(), localdmk);
        Log.d("FinderTimelineLbsContract", "onItemExposeStart id:" + localdmk.hKN + " nick:" + localah.feedObject.getFeedObject().nickname);
      }
      AppMethodBeat.o(340063);
    }
    
    public final void s(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(340058);
      s.u(paramSet, "recordsSet");
      Log.i("FinderTimelineLbsContract", s.X("onExposeTimeRecorded: size = ", Integer.valueOf(paramSet.size())));
      LinkedList localLinkedList = new LinkedList();
      paramSet = (Iterable)paramSet;
      e locale = this.ERW;
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)localIterator.next();
        Object localObject1;
        Object localObject2;
        if ((localb.agNK instanceof com.tencent.mm.plugin.finder.model.ah))
        {
          paramSet = new dmk();
          localObject1 = (com.tencent.mm.plugin.finder.model.ah)localb.agNK;
          paramSet.hKN = ((com.tencent.mm.plugin.finder.model.ah)localObject1).bZA();
          localObject2 = ay.EDk;
          ay.a(paramSet, e.a(locale).getCommentScene());
          paramSet.aaSu = ((int)localb.HsA);
          paramSet.sessionBuffer = ((com.tencent.mm.plugin.finder.model.ah)localObject1).getSessionBuffer();
          localLinkedList.add(paramSet);
          Log.d("FinderTimelineLbsContract", "onExposeTimeRecorded pos:" + localb.afqR + " exposeTime:" + localb.HsA + " nick:" + ((BaseFinderFeed)localObject1).feedObject.getFeedObject().nickname);
        }
        else
        {
          if ((localb.agNK instanceof x))
          {
            localObject2 = new com.tencent.mm.plugin.finder.live.report.a();
            cc localcc = (cc)localb.agNK;
            int i = localb.afqR;
            q.w localw = q.w.DwP;
            String str = q.n.DtM.scene;
            paramSet = e.c(locale);
            if (paramSet == null) {
              paramSet = "";
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.finder.live.report.a)localObject2).a(localcc, i, localw, str, paramSet, e.d(locale).a(localb.afqR, localb.view, "onExpose"));
              break;
              localObject1 = paramSet.eEv();
              paramSet = (Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>>)localObject1;
              if (localObject1 == null) {
                paramSet = "";
              }
            }
          }
          Log.d("FinderTimelineLbsContract", "onExposeTimeRecorded pos:" + localb.afqR + " exposeTime:" + localb.HsA);
        }
      }
      paramSet = com.tencent.mm.plugin.finder.nearby.report.e.EQU;
      com.tencent.mm.plugin.finder.nearby.report.e.F(e.a(this.ERW).getCommentScene(), (List)localLinkedList);
      paramSet = ay.EDk;
      ay.aN(localLinkedList);
      AppMethodBeat.o(340058);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends WxRecyclerAdapter<cc>
  {
    e(ArrayList<cc> paramArrayList, com.tencent.mm.view.recyclerview.g paramg)
    {
      super(paramArrayList);
    }
    
    public final void v(j paramj)
    {
      AppMethodBeat.i(340051);
      s.u(paramj, "holder");
      super.v(paramj);
      Object localObject = paramj.caK.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (paramj.caO != -1) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).cbB = bool;
        AppMethodBeat.o(340051);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<Integer, com.tencent.mm.view.recyclerview.f<?>>
  {
    f(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.e
 * JD-Core Version:    0.7.0.1
 */