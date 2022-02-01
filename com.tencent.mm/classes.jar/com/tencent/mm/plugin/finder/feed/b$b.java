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
import android.support.v7.widget.RecyclerView.w;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.finder.view.d.a;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;IIZ)V", "HEADER_COUNT", "getHEADER_COUNT", "()I", "setHEADER_COUNT", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "likeDrawer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "getActivity", "getAdapter", "getDrawer", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLikeDrawer", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "initView", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
public abstract class b$b
  implements c<b.a>
{
  final MMActivity iMV;
  int qpm;
  private final int rfR;
  public RefreshLoadMoreLayout rfT;
  private d rfU;
  private FinderLikeDrawer rfV;
  public FinderLikeDrawer rfW;
  private WxRecyclerAdapter<?> rfX;
  TouchMediaPreviewLayout rfY;
  final b.a rfZ;
  private final boolean rga;
  private final int scene;
  
  public b$b(MMActivity paramMMActivity, b.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.iMV = paramMMActivity;
    this.rfZ = parama;
    this.scene = paramInt1;
    this.rfR = paramInt2;
    this.rga = paramBoolean;
    paramMMActivity = this.iMV.findViewById(2131304203);
    k.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.rfT = ((RefreshLoadMoreLayout)paramMMActivity);
  }
  
  public void DE(int paramInt) {}
  
  public void T(ArrayList<BaseFinderFeed> paramArrayList)
  {
    k.h(paramArrayList, "data");
    final RecyclerView localRecyclerView = this.rfT.getRecyclerView();
    localRecyclerView.setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    this.rfX = new WxRecyclerAdapter(this.rfZ.cut(), paramArrayList);
    paramArrayList = this.rfX;
    if (paramArrayList == null) {
      k.aVY("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
    localRecyclerView.b(getItemDecoration());
    this.rfT.setActionCallback((RefreshLoadMoreLayout.a)new a(this, localRecyclerView));
    paramArrayList = com.tencent.mm.ui.component.a.IrY;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class));
    if (paramArrayList != null) {
      paramArrayList.s(localRecyclerView);
    }
    cuy();
  }
  
  public final void U(ArrayList<BaseFinderFeed> paramArrayList)
  {
    k.h(paramArrayList, "data");
    Object localObject1 = d.rVR;
    localObject1 = this.iMV;
    Object localObject2 = this.iMV.getWindow();
    k.g(localObject2, "getActivity().window");
    localObject2 = ((Window)localObject2).getDecorView();
    k.g(localObject2, "getActivity().window.decorView");
    this.rfU = d.a.a((MMActivity)localObject1, (View)localObject2, this.scene, this.rga);
    localObject1 = FinderLikeDrawer.rXU;
    localObject1 = (Context)this.iMV;
    localObject2 = this.iMV.getWindow();
    k.g(localObject2, "getActivity().window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.rXU;
    this.rfV = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cFa());
    localObject1 = FinderLikeDrawer.rXU;
    localObject1 = (Context)this.iMV;
    localObject2 = this.iMV.getWindow();
    k.g(localObject2, "getActivity().window");
    locala = FinderLikeDrawer.rXU;
    this.rfW = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cEZ());
    T(paramArrayList);
    this.rfY = new TouchMediaPreviewLayout((Context)this.iMV);
    paramArrayList = this.rfY;
    if (paramArrayList != null)
    {
      localObject1 = this.iMV.getWindow();
      k.g(localObject1, "context.window");
      localObject1 = ((Window)localObject1).getDecorView();
      k.g(localObject1, "context.window.decorView");
      paramArrayList.gG((View)localObject1);
    }
    paramArrayList = this.rfY;
    if (paramArrayList != null) {
      paramArrayList.setScaleListener((TouchMediaPreviewLayout.b)new b(this));
    }
  }
  
  public final FinderLikeDrawer cuA()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.rfV;
    if (localFinderLikeDrawer == null) {
      k.aVY("likeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public abstract void cuy();
  
  public final d cuz()
  {
    d locald = this.rfU;
    if (locald == null) {
      k.aVY("drawer");
    }
    return locald;
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.rfX;
    if (localWxRecyclerAdapter == null) {
      k.aVY("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public RecyclerView.h getItemDecoration()
  {
    return (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a(this).getColor(2131099648)), (int)c.a.a(this).getDimension(2131166294));
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onRefreshBegin", "refreshType", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    private boolean rgb = true;
    
    a(RecyclerView paramRecyclerView) {}
    
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201518);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      h.JZN.aS((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201518);
    }
    
    public final void DE(int paramInt)
    {
      AppMethodBeat.i(165623);
      this.rgc.DE(paramInt);
      if ((this.rgb) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.IrY;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.rgc.iMV).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((f)localObject).ctt().b(localRecyclerView, 5);
        }
        this.rgb = false;
      }
      AppMethodBeat.o(165623);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(201519);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201519);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165620);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165620);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(165622);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      h.JZN.aS((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165622);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(165618);
        this.rgd.rgc.rfZ.aQh();
        AppMethodBeat.o(165618);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(b.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(165619);
        this.rgd.rgc.rfZ.requestRefresh();
        AppMethodBeat.o(165619);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private final RecyclerView fTr;
    private FinderMediaBanner rge;
    
    b()
    {
      AppMethodBeat.i(165627);
      this.fTr = localObject.rfT.getRecyclerView();
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
      paramScaleGestureDetector = this.fTr.o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      if (paramScaleGestureDetector != null) {}
      Object localObject;
      for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
      {
        this.rge = paramScaleGestureDetector;
        paramScaleGestureDetector = this.rge;
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        localObject = this.rge;
        if (localObject == null) {
          k.fOy();
        }
        paramScaleGestureDetector = paramScaleGestureDetector.ci(((FinderMediaBanner)localObject).getFocusPosition());
        if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.ly() != 2)) {
          break label157;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (!com.tencent.mm.plugin.finder.storage.b.cyY()) {
          break;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.asD.findViewById(2131299974);
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        localObject = this.rgc.rfY;
        if (localObject != null) {
          ((TouchMediaPreviewLayout)localObject).gF(paramScaleGestureDetector);
        }
        AppMethodBeat.o(165624);
        return true;
      }
      AppMethodBeat.o(165624);
      return false;
      label157:
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.ly() == 4))
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.cyZ())
        {
          paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.asD.findViewById(2131299975);
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
              localObject = this.rgc.rfY;
              if (localObject != null) {
                ((TouchMediaPreviewLayout)localObject).gF(paramScaleGestureDetector.getVideoView());
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
      paramScaleGestureDetector = this.rgc.rfY;
      if (paramScaleGestureDetector != null)
      {
        paramScaleGestureDetector = paramScaleGestureDetector.getTouchView();
        if (!(paramScaleGestureDetector instanceof o)) {
          break label102;
        }
        paramScaleGestureDetector = this.rgc.rfY;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.b
 * JD-Core Version:    0.7.0.1
 */