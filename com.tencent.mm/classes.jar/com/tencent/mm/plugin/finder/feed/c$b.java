package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.storage.ah;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.c;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "()I", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "headerview", "Landroid/view/View;", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "spanCount", "getSpanCount", "setSpanCount", "(I)V", "findViewById", "T", "id", "(I)Landroid/view/View;", "getAdapter", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getRootView", "getTitleStringId", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onViewPrepared", "otherFullSpan", "refreshWhenEnter", "requestLoadMore", "showEmptyView", "showEmptyViewInternal", "emptyView", "showHeaderOnDataEmpty", "plugin-finder_release"})
public abstract class c$b
  implements c<c.a>
{
  private final String TAG;
  int att;
  final MMActivity gte;
  private final int scene;
  private final int tCE;
  private WxRecyclerAdapter<?> tFp;
  public RefreshLoadMoreLayout tLS;
  public FinderLikeDrawer tLV;
  private final boolean tLZ;
  public c.a tMg;
  final int tMh;
  final int tMi;
  private al tMj;
  public RecyclerView.LayoutManager tMk;
  public View tMl;
  
  public c$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.gte = paramMMActivity;
    this.scene = paramInt1;
    this.tCE = paramInt2;
    this.tLZ = paramBoolean;
    this.TAG = "Finder.FinderBaseGridFeedUIContract.ViewCallback";
    this.att = 3;
    this.tLS = ((RefreshLoadMoreLayout)findViewById(2131307118));
    this.tMi = -1;
    this.tMj = ((al)new ah());
  }
  
  public abstract void a(RecyclerView.a<?> parama, View paramView, int paramInt);
  
  public final void a(c.a parama)
  {
    p.h(parama, "<set-?>");
    this.tMg = parama;
  }
  
  public void ab(final ArrayList<bo> paramArrayList)
  {
    p.h(paramArrayList, "data");
    RecyclerView localRecyclerView = this.tLS.getRecyclerView();
    this.tMk = eS((Context)this.gte);
    Object localObject = FinderLikeDrawer.wnm;
    localObject = (Context)this.gte;
    Window localWindow = this.gte.getWindow();
    p.g(localWindow, "context.window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.wnm;
    this.tLV = FinderLikeDrawer.a.a((Context)localObject, localWindow, FinderLikeDrawer.dGP());
    localObject = this.tMk;
    if (localObject == null) {
      p.btv("finderManager");
    }
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.tFp = ((WxRecyclerAdapter)new a(this, paramArrayList, dcq().dce(), paramArrayList));
    paramArrayList = this.tFp;
    if (paramArrayList == null) {
      p.btv("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
    localRecyclerView.b(getItemDecoration());
    paramArrayList = this.tFp;
    if (paramArrayList == null) {
      p.btv("adapter");
    }
    paramArrayList.RqP = ((g.c)new b(this));
    this.tMl = getHeaderView();
    if (this.tMl != null)
    {
      paramArrayList = this.tFp;
      if (paramArrayList == null) {
        p.btv("adapter");
      }
      if (paramArrayList != null)
      {
        localObject = this.tMl;
        if (localObject == null) {
          p.hyc();
        }
        g.a(paramArrayList, (View)localObject, this.tMh);
      }
    }
    this.tLS.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.PRN;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class));
    if (paramArrayList != null) {
      paramArrayList.m(localRecyclerView);
    }
    dbY();
  }
  
  public abstract String b(RefreshLoadMoreLayout.c<Object> paramc);
  
  public void bIo()
  {
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = this.tLS;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(2131300101);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(2131306281);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(2131307047);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public abstract String c(RefreshLoadMoreLayout.c<Object> paramc);
  
  public final void dbY()
  {
    d.a(d.aBx(), (kotlin.g.a.b)new d(this));
  }
  
  public final FinderLikeDrawer dcj()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.tLV;
    if (localFinderLikeDrawer == null) {
      p.btv("friendLikeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public final c.a dcq()
  {
    c.a locala = this.tMg;
    if (locala == null) {
      p.btv("present");
    }
    return locala;
  }
  
  public final c.a dcr()
  {
    c.a locala = this.tMg;
    if (locala == null) {
      p.btv("present");
    }
    return locala;
  }
  
  public al dcs()
  {
    return this.tMj;
  }
  
  public boolean dct()
  {
    return true;
  }
  
  public boolean dcu()
  {
    return false;
  }
  
  public abstract void dcv();
  
  public abstract RecyclerView.LayoutManager eS(Context paramContext);
  
  protected final <T extends View> T findViewById(int paramInt)
  {
    Object localObject = getRootView();
    if (localObject != null)
    {
      View localView = ((View)localObject).findViewById(paramInt);
      localObject = localView;
      if (localView != null) {}
    }
    else
    {
      localObject = this.gte.findViewById(paramInt);
      p.g(localObject, "context.findViewById(id)");
    }
    return localObject;
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
    if (localWxRecyclerAdapter == null) {
      p.btv("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public abstract View getEmptyView();
  
  public abstract View getHeaderView();
  
  public abstract RecyclerView.h getItemDecoration();
  
  public View getRootView()
  {
    return null;
  }
  
  public boolean l(com.tencent.mm.view.recyclerview.h paramh)
  {
    p.h(paramh, "holder");
    return false;
  }
  
  public void m(com.tencent.mm.view.recyclerview.h paramh)
  {
    p.h(paramh, "holder");
  }
  
  public final void setRlLayout(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    p.h(paramRefreshLoadMoreLayout, "<set-?>");
    this.tLS = paramRefreshLoadMoreLayout;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "onViewAttachedToWindow", "plugin-finder_release"})
  public static final class a
    extends WxRecyclerAdapter<bo>
  {
    a(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void n(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(243695);
      p.h(paramRecyclerView, "recyclerView");
      Object localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)this.tMm.gte);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.d((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dap().onScrollStateChanged(paramRecyclerView, 5);
          AppMethodBeat.o(243695);
          return;
        }
      }
      AppMethodBeat.o(243695);
    }
    
    public final void n(com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(243693);
      p.h(paramh, "holder");
      super.n(paramh);
      Object localObject = paramh.aus;
      p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if ((paramh.lU() == this.tMm.tMh) || (paramh.lU() == this.tMm.tMi))
        {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aC(true);
          AppMethodBeat.o(243693);
          return;
        }
        if (this.tMm.l(paramh)) {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aC(true);
        }
      }
      AppMethodBeat.o(243693);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements g.c<com.tencent.mm.view.recyclerview.h>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    private boolean tMa = true;
    
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(243703);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      super.ED(paramInt);
      if (this.tMm.dcq().tFM.getSize() == 0)
      {
        localObject = this.tMm.getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tMm.tLS;
          if (localRefreshLoadMoreLayout != null) {
            localRefreshLoadMoreLayout.setVisibility(8);
          }
          localObject = ((View)localObject).findViewById(2131306281);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
      com.tencent.f.h.RTc.aX((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(243703);
    }
    
    public final void IF(int paramInt)
    {
      if ((this.tMa) && (paramInt > 0)) {
        this.tMa = false;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243705);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(243705);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(243704);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      com.tencent.f.h.RTc.aX((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(243704);
    }
    
    public final void onRefreshEnd(final RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243702);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      View localView = this.tMm.getEmptyView();
      Object localObject2;
      int i;
      if (localView != null)
      {
        localObject2 = this.tMm.tLS.getRecyclerView().getAdapter();
        localObject1 = localObject2;
        if (!(localObject2 instanceof WxRecyclerAdapter)) {
          localObject1 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject1;
        if (paramc.Rmh == -1) {
          break label253;
        }
        if (localObject1 == null) {
          break label148;
        }
        i = ((g)localObject1).hgt();
        if ((i > 0) || (this.tMm.dcu())) {
          break label153;
        }
        this.tMm.bIo();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(243702);
        return;
        label148:
        i = 0;
        break;
        label153:
        localView.setVisibility(8);
        localObject1 = this.tMm.tMl;
        if (localObject1 != null)
        {
          localObject2 = (TextView)((View)localObject1).findViewById(2131309195);
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)this.tMm.b(paramc));
          }
          localObject1 = (TextView)((View)localObject1).findViewById(2131299495);
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)this.tMm.c(paramc));
          }
        }
        paramc = this.tMm.tLS;
        if (paramc != null)
        {
          paramc.setVisibility(0);
          continue;
          label253:
          localView.setVisibility(0);
          localObject1 = this.tMm.tLS;
          if (localObject1 != null) {
            ((RefreshLoadMoreLayout)localObject1).setVisibility(8);
          }
          localObject1 = (TextView)localView.findViewById(2131300101);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localObject1 = (TextView)localView.findViewById(2131307047);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(0);
          }
          localObject1 = localView.findViewById(2131306281);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = localView.findViewById(2131307047);
          if (localObject1 != null) {
            ((View)localObject1).setOnClickListener((View.OnClickListener)new c(localView, this, paramc));
          }
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(243698);
        this.tMo.tMm.dcr().boE();
        AppMethodBeat.o(243698);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(c.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(243699);
        this.tMo.tMm.dcr().requestRefresh();
        AppMethodBeat.o(243699);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$1$2"})
    static final class c
      implements View.OnClickListener
    {
      c(View paramView, c.b.c paramc, RefreshLoadMoreLayout.c paramc1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(243701);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        p.g(paramView, "it");
        paramView.setVisibility(8);
        paramView = this.tCl.findViewById(2131306281);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        com.tencent.f.h.RTc.aX((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243700);
            this.tMq.tMo.tMm.dcr().requestRefresh();
            AppMethodBeat.o(243700);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243701);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Void, x>
  {
    d(c.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c.b
 * JD-Core Version:    0.7.0.1
 */