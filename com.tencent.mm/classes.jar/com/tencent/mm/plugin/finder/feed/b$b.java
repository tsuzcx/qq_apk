package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.at;
import android.view.View;
import android.view.Window;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;IIZ)V", "HEADER_COUNT", "getHEADER_COUNT", "()I", "setHEADER_COUNT", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "isEnableFullScreenEnjoy", "isEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "likeDrawer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "getActivity", "getAdapter", "getDrawer", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLikeDrawer", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRfLayout", "getSnapHelper", "Landroid/support/v7/widget/SnapHelper;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "initView", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
public abstract class b$b
  implements c<b.a>
{
  final MMActivity gte;
  int sHN;
  private final int scene;
  public final int tCE;
  private WxRecyclerAdapter<?> tFp;
  public RefreshLoadMoreLayout tLS;
  private com.tencent.mm.plugin.finder.view.e tLT;
  private FinderLikeDrawer tLU;
  public FinderLikeDrawer tLV;
  public TouchMediaPreviewLayout tLW;
  private final kotlin.f tLX;
  final b.a tLY;
  private final boolean tLZ;
  
  public b$b(MMActivity paramMMActivity, b.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.gte = paramMMActivity;
    this.tLY = parama;
    this.scene = paramInt1;
    this.tCE = paramInt2;
    this.tLZ = paramBoolean;
    paramMMActivity = this.gte.findViewById(2131307118);
    p.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.tLS = ((RefreshLoadMoreLayout)paramMMActivity);
    this.tLX = kotlin.g.ah((kotlin.g.a.a)new b(this));
  }
  
  public void IF(int paramInt) {}
  
  public void aa(ArrayList<bo> paramArrayList)
  {
    p.h(paramArrayList, "data");
    final RecyclerView localRecyclerView = this.tLS.getRecyclerView();
    Object localObject = new FinderLinearLayoutManager((Context)this.gte);
    if (dck()) {
      ((FinderLinearLayoutManager)localObject).wsx = 40.0F;
    }
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    if (dck()) {}
    for (localObject = (at)new com.tencent.mm.plugin.finder.ui.e();; localObject = null)
    {
      if (localObject != null) {
        ((at)localObject).f(localRecyclerView);
      }
      this.tFp = new WxRecyclerAdapter(this.tLY.dce(), paramArrayList);
      paramArrayList = this.tFp;
      if (paramArrayList == null) {
        p.btv("adapter");
      }
      localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
      if (!dck()) {
        localRecyclerView.b(getItemDecoration());
      }
      this.tLS.setActionCallback((RefreshLoadMoreLayout.a)new a(this, localRecyclerView));
      paramArrayList = com.tencent.mm.ui.component.a.PRN;
      paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class));
      if (paramArrayList != null) {
        paramArrayList.m(localRecyclerView);
      }
      dbY();
      return;
    }
  }
  
  public final void ab(ArrayList<bo> paramArrayList)
  {
    p.h(paramArrayList, "data");
    Object localObject1 = com.tencent.mm.plugin.finder.view.e.wky;
    localObject1 = (MMFragmentActivity)this.gte;
    Object localObject2 = this.gte.getWindow();
    p.g(localObject2, "getActivity().window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.g(localObject2, "getActivity().window.decorView");
    this.tLT = e.a.a((MMFragmentActivity)localObject1, (View)localObject2, this.scene, this.tLZ, 0, 16);
    localObject1 = FinderLikeDrawer.wnm;
    localObject1 = (Context)this.gte;
    localObject2 = this.gte.getWindow();
    p.g(localObject2, "getActivity().window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.wnm;
    this.tLU = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.dGQ());
    localObject1 = FinderLikeDrawer.wnm;
    localObject1 = (Context)this.gte;
    localObject2 = this.gte.getWindow();
    p.g(localObject2, "getActivity().window");
    locala = FinderLikeDrawer.wnm;
    this.tLV = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.dGP());
    aa(paramArrayList);
  }
  
  public abstract void dbY();
  
  public final FinderLikeDrawer dcj()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.tLV;
    if (localFinderLikeDrawer == null) {
      p.btv("friendLikeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public final boolean dck()
  {
    return ((Boolean)this.tLX.getValue()).booleanValue();
  }
  
  public final com.tencent.mm.plugin.finder.view.e dcm()
  {
    com.tencent.mm.plugin.finder.view.e locale = this.tLT;
    if (locale == null) {
      p.btv("drawer");
    }
    return locale;
  }
  
  public final FinderLikeDrawer dcn()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.tLU;
    if (localFinderLikeDrawer == null) {
      p.btv("likeDrawer");
    }
    return localFinderLikeDrawer;
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
  
  public RecyclerView.h getItemDecoration()
  {
    return (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a(this).getColor(2131099648)), (int)c.a.a(this).getDimension(2131166341));
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    private boolean tMa = true;
    
    a(RecyclerView paramRecyclerView) {}
    
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(243680);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      h.RTc.aX((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(243680);
    }
    
    public final void IF(int paramInt)
    {
      AppMethodBeat.i(243683);
      this.tMb.IF(paramInt);
      if ((this.tMa) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.tMb.gte).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dap().onScrollStateChanged(localRecyclerView, 5);
        }
        this.tMa = false;
      }
      AppMethodBeat.o(243683);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243682);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      this.tMb.tLY.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(243682);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(243681);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      h.RTc.aX((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(243681);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243679);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      View localView = this.tMb.getEmptyView();
      int i;
      if (localView != null)
      {
        localObject = this.tMb.tLS.getRecyclerView().getAdapter();
        paramc = (RefreshLoadMoreLayout.c<Object>)localObject;
        if (!(localObject instanceof WxRecyclerAdapter)) {
          paramc = null;
        }
        paramc = (WxRecyclerAdapter)paramc;
        if (paramc == null) {
          break label190;
        }
        i = paramc.hgt();
        if (i > 0) {
          break label195;
        }
        localView.setVisibility(0);
        if (paramc != null)
        {
          paramc = paramc.getRecyclerView();
          if (paramc != null) {
            paramc.setVisibility(8);
          }
        }
        paramc = localView.findViewById(2131307047);
        if (paramc != null) {
          paramc.setVisibility(0);
        }
        paramc = localView.findViewById(2131306281);
        if (paramc != null) {
          paramc.setVisibility(8);
        }
      }
      for (;;)
      {
        this.tMb.tLY.dcd();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(243679);
        return;
        label190:
        i = 0;
        break;
        label195:
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(243677);
        this.tMc.tMb.tLY.boE();
        AppMethodBeat.o(243677);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(b.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(243678);
        this.tMc.tMb.tLY.requestRefresh();
        AppMethodBeat.o(243678);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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