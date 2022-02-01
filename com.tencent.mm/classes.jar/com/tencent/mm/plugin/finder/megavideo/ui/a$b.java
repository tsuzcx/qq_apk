package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.finder.model.cc;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "headerview", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getRootView", "getAdapter", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onItemClick", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onViewPrepared", "refreshWhenEnter", "", "showEmptyView", "showEmptyViewInternal", "emptyView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a$b
  implements c<a.a>
{
  private WxRecyclerAdapter<?> ALE;
  private final int ATI;
  private final int ATJ;
  public RecyclerView.LayoutManager ATK;
  private View ATL;
  public RefreshLoadMoreLayout ATx;
  public a.a EAc;
  private final MMActivity lzt;
  private final View rootView;
  
  public a$b(MMActivity paramMMActivity, View paramView)
  {
    this.lzt = paramMMActivity;
    this.rootView = paramView;
    paramMMActivity = this.rootView.findViewById(e.e.rl_layout);
    s.s(paramMMActivity, "rootView.findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)paramMMActivity);
    this.ATJ = -1;
  }
  
  public final void a(a.a parama)
  {
    s.u(parama, "<set-?>");
    this.EAc = parama;
  }
  
  public final void ae(final ArrayList<cc> paramArrayList)
  {
    s.u(paramArrayList, "data");
    RecyclerView localRecyclerView = this.ATx.getRecyclerView();
    Object localObject = (Context)this.lzt;
    s.u(localObject, "context");
    localObject = (RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)localObject);
    s.u(localObject, "<set-?>");
    this.ATK = ((RecyclerView.LayoutManager)localObject);
    localObject = this.ATK;
    if (localObject != null)
    {
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      this.ALE = ((WxRecyclerAdapter)new a(this, paramArrayList, eCN().dUK()));
      localObject = this.ALE;
      paramArrayList = (ArrayList<cc>)localObject;
      if (localObject == null)
      {
        s.bIx("adapter");
        paramArrayList = null;
      }
      localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
      paramArrayList = (Drawable)new ColorDrawable(c.a.a(this).getColor(e.b.FG_3));
      int i = (int)c.a.a(this).getDimension(e.c.feed_detail_divider);
      localObject = new int[4];
      localObject[0] = c.a.a(this).getDimensionPixelOffset(e.c.Edge_A);
      ah localah = ah.aiuX;
      localRecyclerView.a((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b(paramArrayList, i, (int[])localObject));
      paramArrayList = this.ALE;
      if (paramArrayList != null) {
        break label312;
      }
      s.bIx("adapter");
      paramArrayList = null;
    }
    label312:
    for (;;)
    {
      paramArrayList.agOe = ((i.c)new b(this));
      this.ATL = getHeaderView();
      if (this.ATL != null)
      {
        localObject = this.ALE;
        paramArrayList = (ArrayList<cc>)localObject;
        if (localObject == null)
        {
          s.bIx("adapter");
          paramArrayList = null;
        }
        paramArrayList = (com.tencent.mm.view.recyclerview.i)paramArrayList;
        localObject = this.ATL;
        s.checkNotNull(localObject);
        com.tencent.mm.view.recyclerview.i.a(paramArrayList, (View)localObject, this.ATI);
      }
      this.ATx.setActionCallback((RefreshLoadMoreLayout.b)new c(this));
      ebi();
      return;
      s.bIx("finderManager");
      localObject = null;
      break;
    }
  }
  
  public abstract void b(RecyclerView.a<?> parama, View paramView, int paramInt);
  
  public final void cul()
  {
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = this.ATx;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(e.e.empty_tip);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(e.e.progress);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(e.e.retry_tip);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public final MMActivity dSs()
  {
    return this.lzt;
  }
  
  public abstract void dUO();
  
  public final a.a eCN()
  {
    a.a locala = this.EAc;
    if (locala != null) {
      return locala;
    }
    s.bIx("present");
    return null;
  }
  
  public void ebi()
  {
    d.a(d.bbX(), (kotlin.g.a.b)new d(this));
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter2 = this.ALE;
    WxRecyclerAdapter localWxRecyclerAdapter1 = localWxRecyclerAdapter2;
    if (localWxRecyclerAdapter2 == null)
    {
      s.bIx("adapter");
      localWxRecyclerAdapter1 = null;
    }
    return localWxRecyclerAdapter1;
  }
  
  public abstract View getEmptyView();
  
  public abstract View getHeaderView();
  
  public final View getRootView()
  {
    return this.rootView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends WxRecyclerAdapter<cc>
  {
    a(a.b paramb, ArrayList<cc> paramArrayList, g paramg)
    {
      super(paramArrayList);
    }
    
    public final void p(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(341827);
      s.u(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(341827);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(a.b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    private boolean ATC = true;
    
    c(a.b paramb) {}
    
    private static final void a(View paramView1, a.b paramb, View paramView2)
    {
      AppMethodBeat.i(341842);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView1);
      localb.cH(paramb);
      localb.cH(paramView2);
      a.c("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramView1, "$this_apply");
      s.u(paramb, "this$0");
      paramView2.setVisibility(8);
      paramView1 = paramView1.findViewById(e.e.progress);
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      h.ahAA.bm(new a.b.c..ExternalSyntheticLambda1(paramb));
      a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341842);
    }
    
    private static final void b(a.b paramb)
    {
      AppMethodBeat.i(341829);
      s.u(paramb, "this$0");
      paramb.eCN().requestRefresh();
      AppMethodBeat.o(341829);
    }
    
    private static final void c(a.b paramb)
    {
      AppMethodBeat.i(341850);
      s.u(paramb, "this$0");
      paramb.eCN().requestRefresh();
      AppMethodBeat.o(341850);
    }
    
    private static final void d(a.b paramb)
    {
      AppMethodBeat.i(341855);
      s.u(paramb, "this$0");
      paramb.eCN().bXB();
      AppMethodBeat.o(341855);
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(341899);
      super.IH(paramInt);
      if (this.EAd.eCN().EzZ.getSize() == 0)
      {
        View localView = this.EAd.getEmptyView();
        if (localView != null)
        {
          Object localObject = this.EAd;
          localView.setVisibility(0);
          localObject = ((a.b)localObject).ATx;
          if (localObject != null) {
            ((RefreshLoadMoreLayout)localObject).setVisibility(8);
          }
          localView = localView.findViewById(e.e.progress);
          if (localView != null) {
            localView.setVisibility(0);
          }
        }
      }
      h.ahAA.bm(new a.b.c..ExternalSyntheticLambda2(this.EAd));
      AppMethodBeat.o(341899);
    }
    
    public final void ND(int paramInt)
    {
      if ((this.ATC) && (paramInt > 0)) {
        this.ATC = false;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(341913);
      s.u(paramd, "reason");
      super.a(paramd);
      AppMethodBeat.o(341913);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(341890);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      View localView = this.EAd.getEmptyView();
      if (localView != null)
      {
        a.b localb = this.EAd;
        Object localObject = localb.ATx.getRecyclerView().getAdapter();
        if ((localObject instanceof WxRecyclerAdapter))
        {
          localObject = (WxRecyclerAdapter)localObject;
          if (paramd.agJs == -1) {
            break label130;
          }
          if (localObject != null) {
            break label94;
          }
        }
        label94:
        for (int i = 0;; i = ((com.tencent.mm.view.recyclerview.i)localObject).jNl())
        {
          if (i > 0) {
            break label102;
          }
          localb.cul();
          AppMethodBeat.o(341890);
          return;
          localObject = null;
          break;
        }
        label102:
        localView.setVisibility(8);
        paramd = localb.ATx;
        if (paramd != null)
        {
          paramd.setVisibility(0);
          AppMethodBeat.o(341890);
          return;
          label130:
          localView.setVisibility(0);
          paramd = localb.ATx;
          if (paramd != null) {
            paramd.setVisibility(8);
          }
          paramd = (TextView)localView.findViewById(e.e.empty_tip);
          if (paramd != null) {
            paramd.setVisibility(8);
          }
          paramd = (TextView)localView.findViewById(e.e.retry_tip);
          if (paramd != null) {
            paramd.setVisibility(0);
          }
          paramd = localView.findViewById(e.e.progress);
          if (paramd != null) {
            paramd.setVisibility(8);
          }
          paramd = localView.findViewById(e.e.retry_tip);
          if (paramd != null) {
            paramd.setOnClickListener(new a.b.c..ExternalSyntheticLambda0(localView, localb));
          }
        }
      }
      AppMethodBeat.o(341890);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(341906);
      super.qI(paramInt);
      h.ahAA.bm(new a.b.c..ExternalSyntheticLambda3(this.EAd));
      AppMethodBeat.o(341906);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Void, ah>
  {
    d(a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.a.b
 * JD-Core Version:    0.7.0.1
 */