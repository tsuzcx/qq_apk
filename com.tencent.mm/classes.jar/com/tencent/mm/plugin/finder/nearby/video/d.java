package com.tencent.mm.plugin.finder.nearby.video;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "plugin-finder_release"})
public final class d
  implements a.b<bo>
{
  public static final a uTJ;
  private final View hVd;
  private al tMj;
  private final MMActivity tRl;
  private final AbsNearByFragment uTH;
  private final a.a<bo> uTI;
  
  static
  {
    AppMethodBeat.i(249497);
    uTJ = new a((byte)0);
    AppMethodBeat.o(249497);
  }
  
  public d(MMActivity paramMMActivity, AbsNearByFragment paramAbsNearByFragment, a.a<bo> parama, View paramView)
  {
    AppMethodBeat.i(249496);
    this.tRl = paramMMActivity;
    this.uTH = paramAbsNearByFragment;
    this.uTI = parama;
    this.hVd = paramView;
    this.tMj = ((al)new c(this.tRl));
    AppMethodBeat.o(249496);
  }
  
  public final void ab(final ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(249493);
    p.h(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hVd.findViewById(2131307118);
    Object localObject1 = MMApplicationContext.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166379) - (int)((Resources)localObject1).getDimension(2131165281));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165310) - (int)((Resources)localObject1).getDimension(2131166379));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.tMj;
    Context localContext = this.hVd.getContext();
    p.g(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((al)localObject2).eS(localContext));
    ((RecyclerView)localObject1).b(this.tMj.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.tMj.f(this.tRl));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lB();
    }
    localObject2 = new e(this, paramArrayList, this.tMj.G((kotlin.g.a.b)new f(this)), paramArrayList);
    ((g)localObject2).RqP = ((g.c)new b(this, paramArrayList, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    if (localObject1 == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(249493);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.c.dsZ().value()).intValue());
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.PRN;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.of((Fragment)this.uTH).get(FinderReporterUIC.class));
    if (paramArrayList != null) {
      paramArrayList.m((RecyclerView)localObject1);
    }
    com.tencent.mm.view.recyclerview.c.a((RecyclerView)localObject1, (com.tencent.mm.view.recyclerview.d)new d(this));
    AppMethodBeat.o(249493);
  }
  
  public final RefreshLoadMoreLayout dcQ()
  {
    AppMethodBeat.i(249495);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hVd.findViewById(2131307118);
    p.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(249495);
    return localRefreshLoadMoreLayout;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(249494);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.hVd.findViewById(2131307118)).getRecyclerView();
    AppMethodBeat.o(249494);
    return localRecyclerView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements g.c<h>
  {
    b(ArrayList paramArrayList, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(249482);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      d.a(this.uTK).onRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(249482);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(249485);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(249485);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(249484);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      d.a(this.uTK).onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(249484);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(249483);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      d.a(this.uTK).onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(249483);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(249487);
      p.h(paramb, "item");
      if ((paramb.RqA instanceof ad))
      {
        cmm localcmm = new cmm();
        Object localObject = paramb.RqA;
        if (localObject == null)
        {
          paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedVideo");
          AppMethodBeat.o(249487);
          throw paramb;
        }
        localObject = (ad)localObject;
        localcmm.hFK = ((ad)localObject).lT();
        localcmm.MrJ = ((int)paramb.startTime);
        paramb = as.uOL;
        as.a(localcmm, d.a(this.uTK).getCommentScene());
        paramb = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
        com.tencent.mm.plugin.finder.nearby.report.c.a(d.a(this.uTK).getCommentScene(), localcmm);
        Log.d("FinderTimelineLbsContract", "onItemExposeStart id:" + localcmm.hFK + " nick:" + ((BaseFinderFeed)localObject).feedObject.getFeedObject().nickname);
      }
      AppMethodBeat.o(249487);
    }
    
    public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(249486);
      p.h(paramSet, "recordsSet");
      Log.i("FinderTimelineLbsContract", "onExposeTimeRecorded: size = " + paramSet.size());
      LinkedList localLinkedList = new LinkedList();
      paramSet = ((Iterable)paramSet).iterator();
      while (paramSet.hasNext())
      {
        com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)paramSet.next();
        if ((localb.RqA instanceof ad))
        {
          cmm localcmm = new cmm();
          Object localObject = localb.RqA;
          if (localObject == null)
          {
            paramSet = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedVideo");
            AppMethodBeat.o(249486);
            throw paramSet;
          }
          localObject = (ad)localObject;
          localcmm.hFK = ((ad)localObject).lT();
          as localas = as.uOL;
          as.a(localcmm, d.a(this.uTK).getCommentScene());
          localcmm.MrJ = ((int)localb.wVY);
          localcmm.sessionBuffer = ((ad)localObject).getSessionBuffer();
          localLinkedList.add(localcmm);
          Log.d("FinderTimelineLbsContract", "onExposeTimeRecorded pos:" + localb.Qgj + " exposeTime:" + localb.wVY + " nick:" + ((BaseFinderFeed)localObject).feedObject.getFeedObject().nickname);
        }
        else
        {
          Log.d("FinderTimelineLbsContract", "onExposeTimeRecorded pos:" + localb.Qgj + " exposeTime:" + localb.wVY);
        }
      }
      paramSet = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
      com.tencent.mm.plugin.finder.nearby.report.c.i(d.a(this.uTK).getCommentScene(), (List)localLinkedList);
      paramSet = as.uOL;
      as.ar(localLinkedList);
      AppMethodBeat.o(249486);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class e
    extends WxRecyclerAdapter<bo>
  {
    e(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void n(h paramh)
    {
      AppMethodBeat.i(249488);
      p.h(paramh, "holder");
      super.n(paramh);
      Object localObject = paramh.aus;
      p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (paramh.lU() != -1) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aC(bool);
        AppMethodBeat.o(249488);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Integer, e<?>>
  {
    f(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.d
 * JD-Core Version:    0.7.0.1
 */