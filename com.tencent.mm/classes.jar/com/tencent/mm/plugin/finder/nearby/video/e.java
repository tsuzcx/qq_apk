package com.tencent.mm.plugin.finder.nearby.video;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.b;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "plugin-finder-nearby_release"})
public final class e
  implements a.b<bu>
{
  public static final a zJV;
  private final View kJC;
  private final MMActivity xCd;
  private ak xwa;
  private final AbsNearByFragment zEI;
  private final a.a<bu> zJU;
  
  static
  {
    AppMethodBeat.i(201451);
    zJV = new a((byte)0);
    AppMethodBeat.o(201451);
  }
  
  public e(MMActivity paramMMActivity, AbsNearByFragment paramAbsNearByFragment, a.a<bu> parama, View paramView)
  {
    AppMethodBeat.i(201450);
    this.xCd = paramMMActivity;
    this.zEI = paramAbsNearByFragment;
    this.zJU = parama;
    this.kJC = paramView;
    this.xwa = ((ak)new c(this.xCd));
    AppMethodBeat.o(201450);
  }
  
  public final void ab(final ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(201446);
    p.k(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.kJC.findViewById(f.d.rl_layout);
    Object localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(f.b.finder_timeline_refresh_height) - (int)((Resources)localObject1).getDimension(f.b.Edge_12A));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(f.b.Edge_7A) - (int)((Resources)localObject1).getDimension(f.b.finder_timeline_refresh_height));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.xwa;
    Context localContext = this.kJC.getContext();
    p.j(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((ak)localObject2).eW(localContext));
    ((RecyclerView)localObject1).b(this.xwa.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.xwa.g(this.xCd));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).n(0L);
    }
    localObject2 = new e(this, paramArrayList, this.xwa.O((kotlin.g.a.b)new f(this)), paramArrayList);
    ((h)localObject2).YSn = ((h.c)new b(this, paramArrayList, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    if (localObject1 == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(201446);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.d.dUr().aSr()).intValue());
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = g.Xox;
    paramArrayList = aj.d((aj)g.h((Fragment)this.zEI).i(aj.class));
    if (paramArrayList != null) {
      paramArrayList.k((RecyclerView)localObject1);
    }
    com.tencent.mm.view.recyclerview.c.a((RecyclerView)localObject1, (com.tencent.mm.view.recyclerview.d)new d(this));
    AppMethodBeat.o(201446);
  }
  
  public final RefreshLoadMoreLayout dtq()
  {
    AppMethodBeat.i(201449);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.kJC.findViewById(f.d.rl_layout);
    p.j(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(201449);
    return localRefreshLoadMoreLayout;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(201448);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.kJC.findViewById(f.d.rl_layout)).getRecyclerView();
    AppMethodBeat.o(201448);
    return localRecyclerView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"})
  public static final class b
    implements h.c<i>
  {
    b(ArrayList paramArrayList, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<bu, Boolean>
    {
      public static final a zJX;
      
      static
      {
        AppMethodBeat.i(201074);
        zJX = new a();
        AppMethodBeat.o(201074);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder-nearby_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(199812);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      e.a(this.zJW).onRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(199812);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(199822);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(199822);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(199818);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      e.a(this.zJW).onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(199818);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(199815);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      e.a(this.zJW).onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(199815);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder-nearby_release"})
  public static final class d
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(201145);
      p.k(paramb, "item");
      if ((paramb.YRY instanceof af))
      {
        cve localcve = new cve();
        Object localObject = paramb.YRY;
        if (localObject == null)
        {
          paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedVideo");
          AppMethodBeat.o(201145);
          throw paramb;
        }
        localObject = (af)localObject;
        localcve.xbk = ((af)localObject).mf();
        localcve.TCN = ((int)paramb.startTime);
        paramb = au.zBf;
        au.a(localcve, e.a(this.zJW).getCommentScene());
        paramb = com.tencent.mm.plugin.finder.nearby.report.d.zJm;
        com.tencent.mm.plugin.finder.nearby.report.d.a(e.a(this.zJW).getCommentScene(), localcve);
        Log.d("FinderTimelineLbsContract", "onItemExposeStart id:" + localcve.xbk + " nick:" + ((BaseFinderFeed)localObject).feedObject.getFeedObject().nickname);
      }
      AppMethodBeat.o(201145);
    }
    
    public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(201143);
      p.k(paramSet, "recordsSet");
      Log.i("FinderTimelineLbsContract", "onExposeTimeRecorded: size = " + paramSet.size());
      LinkedList localLinkedList = new LinkedList();
      paramSet = ((Iterable)paramSet).iterator();
      while (paramSet.hasNext())
      {
        com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)paramSet.next();
        if ((localb.YRY instanceof af))
        {
          cve localcve = new cve();
          Object localObject = localb.YRY;
          if (localObject == null)
          {
            paramSet = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedVideo");
            AppMethodBeat.o(201143);
            throw paramSet;
          }
          localObject = (af)localObject;
          localcve.xbk = ((af)localObject).mf();
          au localau = au.zBf;
          au.a(localcve, e.a(this.zJW).getCommentScene());
          localcve.TCN = ((int)localb.BHT);
          localcve.sessionBuffer = ((af)localObject).getSessionBuffer();
          localLinkedList.add(localcve);
          Log.d("FinderTimelineLbsContract", "onExposeTimeRecorded pos:" + localb.XDo + " exposeTime:" + localb.BHT + " nick:" + ((BaseFinderFeed)localObject).feedObject.getFeedObject().nickname);
        }
        else
        {
          Log.d("FinderTimelineLbsContract", "onExposeTimeRecorded pos:" + localb.XDo + " exposeTime:" + localb.BHT);
        }
      }
      paramSet = com.tencent.mm.plugin.finder.nearby.report.d.zJm;
      com.tencent.mm.plugin.finder.nearby.report.d.k(e.a(this.zJW).getCommentScene(), (List)localLinkedList);
      paramSet = au.zBf;
      au.aI(localLinkedList);
      AppMethodBeat.o(201143);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder-nearby_release"})
  public static final class e
    extends WxRecyclerAdapter<bu>
  {
    e(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void p(i parami)
    {
      AppMethodBeat.i(199944);
      p.k(parami, "holder");
      super.p(parami);
      Object localObject = parami.amk;
      p.j(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (parami.mg() != -1) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aA(bool);
        AppMethodBeat.o(199944);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Integer, com.tencent.mm.view.recyclerview.e<?>>
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