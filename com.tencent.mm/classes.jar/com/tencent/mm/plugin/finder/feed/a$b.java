package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.b.a;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;IIZ)V", "HEADER_COUNT", "getHEADER_COUNT", "()I", "setHEADER_COUNT", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "likeDrawer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "getActivity", "getAdapter", "getDrawer", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLikeDrawer", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "initView", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
public abstract class a$b
  implements com.tencent.mm.plugin.finder.presenter.base.b<a.a>
{
  private f KMN;
  private FinderLikeDrawer KMO;
  public FinderLikeDrawer KMP;
  final MMActivity imP;
  private final int qqE;
  int qui;
  public RefreshLoadMoreLayout quj;
  private WxRecyclerAdapter<?> qul;
  TouchMediaPreviewLayout qum;
  final a.a qun;
  private final boolean quo;
  private final int scene;
  
  public a$b(MMActivity paramMMActivity, a.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.imP = paramMMActivity;
    this.qun = parama;
    this.scene = paramInt1;
    this.qqE = paramInt2;
    this.quo = paramBoolean;
    paramMMActivity = this.imP.findViewById(2131304203);
    k.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)paramMMActivity);
  }
  
  public void CC(int paramInt) {}
  
  public final void N(ArrayList<BaseFinderFeed> paramArrayList)
  {
    k.h(paramArrayList, "data");
    Object localObject1 = f.LeE;
    localObject1 = this.imP;
    Object localObject2 = this.imP.getWindow();
    k.g(localObject2, "getActivity().window");
    localObject2 = ((Window)localObject2).getDecorView();
    k.g(localObject2, "getActivity().window.decorView");
    this.KMN = f.a.a((MMActivity)localObject1, (View)localObject2, this.scene, this.quo);
    localObject1 = FinderLikeDrawer.Lfb;
    localObject1 = (Context)this.imP;
    localObject2 = this.imP.getWindow();
    k.g(localObject2, "getActivity().window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.Lfb;
    this.KMO = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fWR());
    localObject1 = FinderLikeDrawer.Lfb;
    localObject1 = (Context)this.imP;
    localObject2 = this.imP.getWindow();
    k.g(localObject2, "getActivity().window");
    locala = FinderLikeDrawer.Lfb;
    this.KMP = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fWQ());
    O(paramArrayList);
    this.qum = new TouchMediaPreviewLayout((Context)this.imP);
    paramArrayList = this.qum;
    if (paramArrayList != null)
    {
      localObject1 = this.imP.getWindow();
      k.g(localObject1, "context.window");
      localObject1 = ((Window)localObject1).getDecorView();
      k.g(localObject1, "context.window.decorView");
      paramArrayList.gr((View)localObject1);
    }
    paramArrayList = this.qum;
    if (paramArrayList != null) {
      paramArrayList.setScaleListener((TouchMediaPreviewLayout.b)new b(this));
    }
  }
  
  public void O(ArrayList<BaseFinderFeed> paramArrayList)
  {
    k.h(paramArrayList, "data");
    final RecyclerView localRecyclerView = this.quj.getRecyclerView();
    localRecyclerView.setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    this.qul = new WxRecyclerAdapter(this.qun.clL(), paramArrayList);
    paramArrayList = this.qul;
    if (paramArrayList == null) {
      k.aPZ("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
    localRecyclerView.b(getItemDecoration());
    this.quj.setActionCallback((RefreshLoadMoreLayout.a)new a(this, localRecyclerView));
    paramArrayList = com.tencent.mm.ui.component.a.LCX;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class));
    if (paramArrayList != null) {
      paramArrayList.v(localRecyclerView);
    }
    clP();
  }
  
  public abstract void clP();
  
  public final f fSY()
  {
    f localf = this.KMN;
    if (localf == null) {
      k.aPZ("drawer");
    }
    return localf;
  }
  
  public final FinderLikeDrawer fSZ()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.KMO;
    if (localFinderLikeDrawer == null) {
      k.aPZ("likeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public final MMActivity getActivity()
  {
    return this.imP;
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.qul;
    if (localWxRecyclerAdapter == null) {
      k.aPZ("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public RecyclerView.h getItemDecoration()
  {
    return (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(b.a.a(this).getColor(2131099648)), (int)b.a.a(this).getDimension(2131166294));
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onRefreshBegin", "refreshType", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    private boolean qup = true;
    
    a(RecyclerView paramRecyclerView) {}
    
    public final void CC(int paramInt)
    {
      AppMethodBeat.i(165623);
      this.quq.CC(paramInt);
      if ((this.qup) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.LCX;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.quq.imP).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((e)localObject).fSD().b(localRecyclerView, 5);
        }
        this.qup = false;
      }
      AppMethodBeat.o(165623);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(197622);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(197622);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(197621);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      h.Iye.aP((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(197621);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165620);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165620);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(165622);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bMu();
      h.Iye.aP((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165622);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(165618);
        this.qur.quq.qun.aJq();
        AppMethodBeat.o(165618);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(165619);
        this.qur.quq.qun.requestRefresh();
        AppMethodBeat.o(165619);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private final RecyclerView fPw;
    private FinderMediaBanner qus;
    
    b()
    {
      AppMethodBeat.i(165627);
      this.fPw = localObject.quj.getRecyclerView();
      AppMethodBeat.o(165627);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(165626);
      k.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(165626);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(165624);
      k.h(paramScaleGestureDetector, "detector");
      paramScaleGestureDetector = this.fPw.o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      if (paramScaleGestureDetector != null) {}
      Object localObject;
      for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
      {
        this.qus = paramScaleGestureDetector;
        paramScaleGestureDetector = this.qus;
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        localObject = this.qus;
        if (localObject == null) {
          k.fvU();
        }
        paramScaleGestureDetector = paramScaleGestureDetector.cj(((FinderMediaBanner)localObject).getFocusPosition());
        if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.lp() != 2)) {
          break label157;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (!com.tencent.mm.plugin.finder.storage.b.cpB()) {
          break;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.arI.findViewById(2131299974);
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        localObject = this.quq.qum;
        if (localObject != null) {
          ((TouchMediaPreviewLayout)localObject).gq(paramScaleGestureDetector);
        }
        AppMethodBeat.o(165624);
        return true;
      }
      AppMethodBeat.o(165624);
      return false;
      label157:
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lp() == 4))
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.cpC())
        {
          paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.arI.findViewById(2131299975);
          if (paramScaleGestureDetector != null)
          {
            localObject = paramScaleGestureDetector.getVideoView();
            if ((localObject != null) && (!((o)localObject).isPlaying()))
            {
              AppMethodBeat.o(165624);
              return false;
            }
            paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
            if (paramScaleGestureDetector != null)
            {
              paramScaleGestureDetector.setPreview(true);
              paramScaleGestureDetector.setInterceptDetach(true);
              localObject = this.quq.qum;
              if (localObject != null) {
                ((TouchMediaPreviewLayout)localObject).gq(paramScaleGestureDetector.getVideoView());
              }
              AppMethodBeat.o(165624);
              return true;
            }
          }
        }
        else
        {
          AppMethodBeat.o(165624);
          return false;
        }
      }
      label280:
      AppMethodBeat.o(165624);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(165625);
      k.h(paramScaleGestureDetector, "detector");
      paramScaleGestureDetector = this.quq.qum;
      if (paramScaleGestureDetector != null)
      {
        paramScaleGestureDetector = paramScaleGestureDetector.getTouchView();
        if (!(paramScaleGestureDetector instanceof o)) {
          break label102;
        }
        paramScaleGestureDetector = this.quq.qum;
        if (paramScaleGestureDetector == null) {
          break label78;
        }
      }
      label78:
      for (paramScaleGestureDetector = paramScaleGestureDetector.getTouchView();; paramScaleGestureDetector = null)
      {
        if (paramScaleGestureDetector != null) {
          break label83;
        }
        paramScaleGestureDetector = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
        AppMethodBeat.o(165625);
        throw paramScaleGestureDetector;
        paramScaleGestureDetector = null;
        break;
      }
      label83:
      paramScaleGestureDetector = (o)paramScaleGestureDetector;
      paramScaleGestureDetector.setInterceptDetach(false);
      paramScaleGestureDetector.setPreview(false);
      label102:
      AppMethodBeat.o(165625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.b
 * JD-Core Version:    0.7.0.1
 */