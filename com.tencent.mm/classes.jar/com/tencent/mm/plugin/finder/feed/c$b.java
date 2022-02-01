package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "()I", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "headerview", "Landroid/view/View;", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "spanCount", "getSpanCount", "setSpanCount", "(I)V", "findViewById", "T", "id", "(I)Landroid/view/View;", "getAdapter", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getRootView", "getTitleStringId", "handleLoadMoreEnd", "", "handleRefreshEnd", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isHandleRefreshEndBySelf", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onTopicOnRefreshEnd", "onViewPrepared", "otherFullSpan", "refreshWhenEnter", "requestLoadMore", "showEmptyView", "showEmptyViewInternal", "emptyView", "showHeaderOnDataEmpty", "plugin-finder_release"})
public abstract class c$b
  implements c<c.a>
{
  final String TAG;
  protected final MMActivity iXq;
  private final int scene;
  private int spanCount;
  private final int xkX;
  private WxRecyclerAdapter<?> xnR;
  public RefreshLoadMoreLayout xvJ;
  public FinderLikeDrawer xvM;
  private final boolean xvQ;
  public c.a xvX;
  final int xvY;
  final int xvZ;
  private ak xwa;
  public RecyclerView.LayoutManager xwb;
  public View xwc;
  
  public c$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.iXq = paramMMActivity;
    this.scene = paramInt1;
    this.xkX = paramInt2;
    this.xvQ = paramBoolean;
    this.TAG = "Finder.FinderBaseGridFeedUIContract.ViewCallback";
    this.spanCount = 3;
    paramMMActivity = findViewById(b.f.rl_layout);
    if (paramMMActivity == null) {
      p.iCn();
    }
    this.xvJ = ((RefreshLoadMoreLayout)paramMMActivity);
    this.xvZ = -1;
    this.xwa = ((ak)new ag());
  }
  
  public abstract void a(RecyclerView.a<?> parama, View paramView, int paramInt);
  
  public final void a(c.a parama)
  {
    p.k(parama, "<set-?>");
    this.xvX = parama;
  }
  
  public void ab(final ArrayList<bu> paramArrayList)
  {
    p.k(paramArrayList, "data");
    RecyclerView localRecyclerView = this.xvJ.getRecyclerView();
    this.xwb = eW((Context)this.iXq);
    Object localObject = FinderLikeDrawer.AYs;
    localObject = (Context)this.iXq;
    Window localWindow = this.iXq.getWindow();
    p.j(localWindow, "context.window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.AYs;
    this.xvM = FinderLikeDrawer.a.a((Context)localObject, localWindow, FinderLikeDrawer.eiO());
    localObject = this.xwb;
    if (localObject == null) {
      p.bGy("finderManager");
    }
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.xnR = ((WxRecyclerAdapter)new a(this, paramArrayList, dsG().dsu(), paramArrayList));
    paramArrayList = this.xnR;
    if (paramArrayList == null) {
      p.bGy("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
    localRecyclerView.b(getItemDecoration());
    paramArrayList = this.xnR;
    if (paramArrayList == null) {
      p.bGy("adapter");
    }
    paramArrayList.YSn = ((h.c)new b(this));
    this.xwc = getHeaderView();
    if (this.xwc != null)
    {
      paramArrayList = this.xnR;
      if (paramArrayList == null) {
        p.bGy("adapter");
      }
      if (paramArrayList != null)
      {
        localObject = this.xwc;
        if (localObject == null) {
          p.iCn();
        }
        com.tencent.mm.view.recyclerview.h.a(paramArrayList, (View)localObject, this.xvY);
      }
    }
    this.xvJ.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = g.Xox;
    paramArrayList = aj.d((aj)g.b((AppCompatActivity)this.iXq).i(aj.class));
    if (paramArrayList != null) {
      paramArrayList.k(localRecyclerView);
    }
    dsm();
  }
  
  public void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    p.k(paramc, "reason");
  }
  
  public void bTY()
  {
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = this.xvJ;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(b.f.empty_tip);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(b.f.progress);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(b.f.retry_tip);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public boolean c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    p.k(paramc, "reason");
    return false;
  }
  
  public void d(RefreshLoadMoreLayout.c<Object> paramc)
  {
    p.k(paramc, "reason");
  }
  
  public final c.a dsG()
  {
    c.a locala = this.xvX;
    if (locala == null) {
      p.bGy("present");
    }
    return locala;
  }
  
  public final c.a dsH()
  {
    c.a locala = this.xvX;
    if (locala == null) {
      p.bGy("present");
    }
    return locala;
  }
  
  public ak dsI()
  {
    return this.xwa;
  }
  
  public boolean dsJ()
  {
    return true;
  }
  
  public boolean dsK()
  {
    return false;
  }
  
  public abstract void dsL();
  
  public final void dsm()
  {
    com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new d(this));
  }
  
  public final FinderLikeDrawer dsz()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.xvM;
    if (localFinderLikeDrawer == null) {
      p.bGy("friendLikeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public void e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    p.k(paramc, "reason");
  }
  
  public abstract RecyclerView.LayoutManager eW(Context paramContext);
  
  public abstract String f(RefreshLoadMoreLayout.c<Object> paramc);
  
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
      localObject = this.iXq.findViewById(paramInt);
    }
    return localObject;
  }
  
  public abstract String g(RefreshLoadMoreLayout.c<Object> paramc);
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
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
  
  public final int ku()
  {
    return this.spanCount;
  }
  
  public boolean n(com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(parami, "holder");
    return false;
  }
  
  public void o(com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(parami, "holder");
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "onViewAttachedToWindow", "plugin-finder_release"})
  public static final class a
    extends WxRecyclerAdapter<bu>
  {
    a(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void l(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(279703);
      p.k(paramRecyclerView, "recyclerView");
      Object localObject = aj.Bnu;
      localObject = aj.a.fZ((Context)this.xwd.iXq);
      if (localObject != null)
      {
        localObject = aj.d((aj)localObject);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dqn().onScrollStateChanged(paramRecyclerView, 5);
          AppMethodBeat.o(279703);
          return;
        }
      }
      AppMethodBeat.o(279703);
    }
    
    public final void p(com.tencent.mm.view.recyclerview.i parami)
    {
      AppMethodBeat.i(279701);
      p.k(parami, "holder");
      super.p(parami);
      Object localObject = parami.amk;
      p.j(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if ((parami.mg() == this.xwd.xvY) || (parami.mg() == this.xwd.xvZ))
        {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aA(true);
          AppMethodBeat.o(279701);
          return;
        }
        if (this.xwd.n(parami)) {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aA(true);
        }
      }
      AppMethodBeat.o(279701);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    private boolean xvR = true;
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(273085);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      a.c("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      super.Ie(paramInt);
      if (this.xwd.dsG().xnX.getSize() == 0)
      {
        localObject = this.xwd.getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xwd.xvJ;
          if (localRefreshLoadMoreLayout != null) {
            localRefreshLoadMoreLayout.setVisibility(8);
          }
          localObject = ((View)localObject).findViewById(b.f.progress);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
      com.tencent.e.h.ZvG.be((Runnable)new b(this));
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(273085);
    }
    
    public final void Mw(int paramInt)
    {
      if ((this.xvR) && (paramInt > 0)) {
        this.xvR = false;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(273088);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      a.c("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      this.xwd.e(paramc);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(273088);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(273087);
      a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      com.tencent.e.h.ZvG.be((Runnable)new a(this));
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(273087);
    }
    
    public final void onRefreshEnd(final RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(273084);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramc);
      a.c("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      if (this.xwd.c(paramc))
      {
        Log.i(this.xwd.TAG, "onRefreshEnd handleBySelf");
        this.xwd.d(paramc);
        a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(273084);
        return;
      }
      View localView = this.xwd.getEmptyView();
      Object localObject2;
      int i;
      if (localView != null)
      {
        localObject2 = this.xwd.xvJ.getRecyclerView().getAdapter();
        localObject1 = localObject2;
        if (!(localObject2 instanceof WxRecyclerAdapter)) {
          localObject1 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject1;
        if (paramc.YND == -1) {
          break label312;
        }
        if (localObject1 == null) {
          break label205;
        }
        i = ((com.tencent.mm.view.recyclerview.h)localObject1).ihV();
        if ((i > 0) || (this.xwd.dsK())) {
          break label210;
        }
        this.xwd.bTY();
      }
      for (;;)
      {
        this.xwd.b(paramc);
        a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(273084);
        return;
        label205:
        i = 0;
        break;
        label210:
        localView.setVisibility(8);
        localObject1 = this.xwd.xwc;
        if (localObject1 != null)
        {
          localObject2 = (TextView)((View)localObject1).findViewById(b.f.title);
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)this.xwd.f(paramc));
          }
          localObject1 = (TextView)((View)localObject1).findViewById(b.f.desc);
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)this.xwd.g(paramc));
          }
        }
        localObject1 = this.xwd.xvJ;
        if (localObject1 != null)
        {
          ((RefreshLoadMoreLayout)localObject1).setVisibility(0);
          continue;
          label312:
          localView.setVisibility(0);
          localObject1 = this.xwd.xvJ;
          if (localObject1 != null) {
            ((RefreshLoadMoreLayout)localObject1).setVisibility(8);
          }
          localObject1 = (TextView)localView.findViewById(b.f.empty_tip);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localObject1 = (TextView)localView.findViewById(b.f.retry_tip);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(0);
          }
          localObject1 = localView.findViewById(b.f.progress);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = localView.findViewById(b.f.retry_tip);
          if (localObject1 != null) {
            ((View)localObject1).setOnClickListener((View.OnClickListener)new c(localView, this, paramc));
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(257958);
        this.xwf.xwd.dsH().byN();
        AppMethodBeat.o(257958);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(c.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(291702);
        this.xwf.xwd.dsH().requestRefresh();
        AppMethodBeat.o(291702);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$1$2"})
    static final class c
      implements View.OnClickListener
    {
      c(View paramView, c.b.c paramc, RefreshLoadMoreLayout.c paramc1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(291240);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        a.c("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        p.j(paramView, "it");
        paramView.setVisibility(8);
        paramView = this.xkv.findViewById(b.f.progress);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        com.tencent.e.h.ZvG.be((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(289297);
            com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dRP().aSr()).intValue() == 3)
            {
              locald = com.tencent.mm.plugin.finder.storage.d.AjH;
              com.tencent.mm.plugin.finder.storage.d.dRP().reset();
            }
            this.xwh.xwf.xwd.dsH().requestRefresh();
            AppMethodBeat.o(289297);
          }
        });
        a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291240);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
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