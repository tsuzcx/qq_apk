package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.z;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.ui.e;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c<Ljava.lang.Object;>;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;IIZ)V", "HEADER_COUNT", "getHEADER_COUNT", "()I", "setHEADER_COUNT", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "isEnableFullScreenEnjoy", "isEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "likeDrawer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "getActivity", "getAdapter", "getDrawer", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLikeDrawer", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRfLayout", "getSnapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "initView", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
public abstract class b$b
  implements c<b.a>
{
  final MMActivity iXq;
  private final int scene;
  int wnI;
  public final int xkX;
  private WxRecyclerAdapter<?> xnR;
  public RefreshLoadMoreLayout xvJ;
  private com.tencent.mm.plugin.finder.view.f xvK;
  private FinderLikeDrawer xvL;
  public FinderLikeDrawer xvM;
  public TouchMediaPreviewLayout xvN;
  private final kotlin.f xvO;
  final b.a xvP;
  private final boolean xvQ;
  
  public b$b(MMActivity paramMMActivity, b.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.iXq = paramMMActivity;
    this.xvP = parama;
    this.scene = paramInt1;
    this.xkX = paramInt2;
    this.xvQ = paramBoolean;
    paramMMActivity = this.iXq.findViewById(b.f.rl_layout);
    p.j(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)paramMMActivity);
    this.xvO = kotlin.g.ar((kotlin.g.a.a)new b(this));
  }
  
  public void Mw(int paramInt) {}
  
  public void aa(ArrayList<bu> paramArrayList)
  {
    p.k(paramArrayList, "data");
    final RecyclerView localRecyclerView = this.xvJ.getRecyclerView();
    Object localObject = new FinderLinearLayoutManager((Context)this.iXq);
    if (dsA())
    {
      ((FinderLinearLayoutManager)localObject).BdV = 25.0F;
      ((FinderLinearLayoutManager)localObject).uqm = 100;
    }
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    if (dsA()) {}
    for (localObject = (z)new e();; localObject = null)
    {
      if (localObject != null) {
        ((z)localObject).a(localRecyclerView);
      }
      this.xnR = new WxRecyclerAdapter(this.xvP.dsu(), paramArrayList);
      paramArrayList = this.xnR;
      if (paramArrayList == null) {
        p.bGy("adapter");
      }
      localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
      if (!dsA()) {
        localRecyclerView.b(getItemDecoration());
      }
      this.xvJ.setActionCallback((RefreshLoadMoreLayout.a)new a(this, localRecyclerView));
      paramArrayList = com.tencent.mm.ui.component.g.Xox;
      paramArrayList = aj.d((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(aj.class));
      if (paramArrayList != null) {
        paramArrayList.k(localRecyclerView);
      }
      dsm();
      return;
    }
  }
  
  public final void ab(ArrayList<bu> paramArrayList)
  {
    p.k(paramArrayList, "data");
    Object localObject1 = com.tencent.mm.plugin.finder.view.f.AVu;
    localObject1 = (MMFragmentActivity)this.iXq;
    Object localObject2 = this.iXq.getWindow();
    p.j(localObject2, "getActivity().window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.j(localObject2, "getActivity().window.decorView");
    this.xvK = f.a.a((MMFragmentActivity)localObject1, (View)localObject2, this.scene, this.xvQ, 0, 16);
    localObject1 = FinderLikeDrawer.AYs;
    localObject1 = (Context)this.iXq;
    localObject2 = this.iXq.getWindow();
    p.j(localObject2, "getActivity().window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.AYs;
    this.xvL = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.eiP());
    localObject1 = FinderLikeDrawer.AYs;
    localObject1 = (Context)this.iXq;
    localObject2 = this.iXq.getWindow();
    p.j(localObject2, "getActivity().window");
    locala = FinderLikeDrawer.AYs;
    this.xvM = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.eiO());
    aa(paramArrayList);
  }
  
  public final boolean dsA()
  {
    return ((Boolean)this.xvO.getValue()).booleanValue();
  }
  
  public final com.tencent.mm.plugin.finder.view.f dsC()
  {
    com.tencent.mm.plugin.finder.view.f localf = this.xvK;
    if (localf == null) {
      p.bGy("drawer");
    }
    return localf;
  }
  
  public final FinderLikeDrawer dsD()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.xvL;
    if (localFinderLikeDrawer == null) {
      p.bGy("likeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public abstract void dsm();
  
  public final FinderLikeDrawer dsz()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.xvM;
    if (localFinderLikeDrawer == null) {
      p.bGy("friendLikeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public abstract View getEmptyView();
  
  public RecyclerView.h getItemDecoration()
  {
    return (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a(this).getColor(b.c.BG_0)), (int)c.a.a(this).getDimension(b.d.feed_divider));
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    private boolean xvR = true;
    
    a(RecyclerView paramRecyclerView) {}
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(286868);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.e.h.ZvG.be((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(286868);
    }
    
    public final void Mw(int paramInt)
    {
      AppMethodBeat.i(286871);
      this.xvS.Mw(paramInt);
      if ((this.xvR) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.g.Xox;
        localObject = aj.d((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.xvS.iXq).i(aj.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dqn().onScrollStateChanged(localRecyclerView, 5);
        }
        this.xvR = false;
      }
      AppMethodBeat.o(286871);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(286870);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      this.xvS.xvP.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(286870);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(286869);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      com.tencent.e.h.ZvG.be((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(286869);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(286867);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      View localView = this.xvS.getEmptyView();
      int i;
      if (localView != null)
      {
        localObject = this.xvS.xvJ.getRecyclerView().getAdapter();
        paramc = (RefreshLoadMoreLayout.c<Object>)localObject;
        if (!(localObject instanceof WxRecyclerAdapter)) {
          paramc = null;
        }
        paramc = (WxRecyclerAdapter)paramc;
        if (paramc == null) {
          break label192;
        }
        i = paramc.ihV();
        if (i > 0) {
          break label197;
        }
        localView.setVisibility(0);
        if (paramc != null)
        {
          paramc = paramc.getRecyclerView();
          if (paramc != null) {
            paramc.setVisibility(8);
          }
        }
        paramc = localView.findViewById(b.f.retry_tip);
        if (paramc != null) {
          paramc.setVisibility(0);
        }
        paramc = localView.findViewById(b.f.progress);
        if (paramc != null) {
          paramc.setVisibility(8);
        }
      }
      for (;;)
      {
        this.xvS.xvP.dst();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(286867);
        return;
        label192:
        i = 0;
        break;
        label197:
        localView.setVisibility(8);
        if (paramc != null)
        {
          paramc = paramc.getRecyclerView();
          if (paramc != null) {
            paramc.setVisibility(0);
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(290826);
        this.xvT.xvS.xvP.byN();
        AppMethodBeat.o(290826);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(b.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(291125);
        this.xvT.xvS.xvP.requestRefresh();
        AppMethodBeat.o(291125);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    b(b.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.b
 * JD-Core Version:    0.7.0.1
 */