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
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.e.a;
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
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;IIZ)V", "HEADER_COUNT", "getHEADER_COUNT", "()I", "setHEADER_COUNT", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "likeDrawer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "getActivity", "getAdapter", "getDrawer", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLikeDrawer", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "initView", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
public abstract class a$b
  implements c<a.a>
{
  final MMActivity fLP;
  int qYl;
  private WxRecyclerAdapter<?> rPu;
  private final int rTD;
  public RefreshLoadMoreLayout rTF;
  private e rTG;
  private FinderLikeDrawer rTH;
  public FinderLikeDrawer rTI;
  public TouchMediaPreviewLayout rTJ;
  final a.a rTK;
  private final boolean rTL;
  private final int scene;
  
  public a$b(MMActivity paramMMActivity, a.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.fLP = paramMMActivity;
    this.rTK = parama;
    this.scene = paramInt1;
    this.rTD = paramInt2;
    this.rTL = paramBoolean;
    paramMMActivity = this.fLP.findViewById(2131304203);
    p.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.rTF = ((RefreshLoadMoreLayout)paramMMActivity);
  }
  
  public void Ex(int paramInt) {}
  
  public void T(ArrayList<al> paramArrayList)
  {
    p.h(paramArrayList, "data");
    final RecyclerView localRecyclerView = this.rTF.getRecyclerView();
    localRecyclerView.setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    this.rPu = new WxRecyclerAdapter(this.rTK.cAE(), paramArrayList);
    paramArrayList = this.rPu;
    if (paramArrayList == null) {
      p.bcb("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
    localRecyclerView.b(getItemDecoration());
    this.rTF.setActionCallback((RefreshLoadMoreLayout.a)new a(this, localRecyclerView));
    paramArrayList = com.tencent.mm.ui.component.a.KiD;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fLP).get(FinderReporterUIC.class));
    if (paramArrayList != null) {
      paramArrayList.s(localRecyclerView);
    }
    cAK();
  }
  
  public final void U(ArrayList<al> paramArrayList)
  {
    p.h(paramArrayList, "data");
    Object localObject1 = e.sSA;
    localObject1 = this.fLP;
    Object localObject2 = this.fLP.getWindow();
    p.g(localObject2, "getActivity().window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.g(localObject2, "getActivity().window.decorView");
    this.rTG = e.a.a((MMActivity)localObject1, (View)localObject2, this.scene, this.rTL);
    localObject1 = FinderLikeDrawer.sUO;
    localObject1 = (Context)this.fLP;
    localObject2 = this.fLP.getWindow();
    p.g(localObject2, "getActivity().window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.sUO;
    this.rTH = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cNu());
    localObject1 = FinderLikeDrawer.sUO;
    localObject1 = (Context)this.fLP;
    localObject2 = this.fLP.getWindow();
    p.g(localObject2, "getActivity().window");
    locala = FinderLikeDrawer.sUO;
    this.rTI = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cNt());
    T(paramArrayList);
    this.rTJ = new TouchMediaPreviewLayout((Context)this.fLP);
    paramArrayList = this.rTJ;
    if (paramArrayList != null)
    {
      localObject1 = this.fLP.getWindow();
      p.g(localObject1, "context.window");
      localObject1 = ((Window)localObject1).getDecorView();
      p.g(localObject1, "context.window.decorView");
      paramArrayList.gX((View)localObject1);
    }
    paramArrayList = this.rTJ;
    if (paramArrayList != null) {
      paramArrayList.setScaleListener((TouchMediaPreviewLayout.b)new b(this));
    }
  }
  
  public final FinderLikeDrawer cAJ()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.rTI;
    if (localFinderLikeDrawer == null) {
      p.bcb("friendLikeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public abstract void cAK();
  
  public final e cAL()
  {
    e locale = this.rTG;
    if (locale == null) {
      p.bcb("drawer");
    }
    return locale;
  }
  
  public final FinderLikeDrawer cAM()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.rTH;
    if (localFinderLikeDrawer == null) {
      p.bcb("likeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.rPu;
    if (localWxRecyclerAdapter == null) {
      p.bcb("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public RecyclerView.h getItemDecoration()
  {
    return (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a(this).getColor(2131099648)), (int)c.a.a(this).getDimension(2131166294));
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    private boolean rTM = true;
    
    a(RecyclerView paramRecyclerView) {}
    
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(201683);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      h.LTJ.aR((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201683);
    }
    
    public final void Ex(int paramInt)
    {
      AppMethodBeat.i(165623);
      this.rTN.Ex(paramInt);
      if ((this.rTM) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.KiD;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.rTN.fLP).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((f)localObject).czz().b(localRecyclerView, 5);
        }
        this.rTM = false;
      }
      AppMethodBeat.o(165623);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201684);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      this.rTN.rTK.cAD();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201684);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165620);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.b(paramc);
      this.rTN.rTK.cAC();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165620);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(165622);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      h.LTJ.aR((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165622);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(165618);
        this.rTO.rTN.rTK.aTt();
        AppMethodBeat.o(165618);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(165619);
        this.rTO.rTN.rTK.requestRefresh();
        AppMethodBeat.o(165619);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private final RecyclerView gmV;
    private FinderMediaBanner rTP;
    
    b()
    {
      AppMethodBeat.i(165627);
      this.gmV = localObject.rTF.getRecyclerView();
      AppMethodBeat.o(165627);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(165626);
      p.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(165626);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(165624);
      p.h(paramScaleGestureDetector, "detector");
      paramScaleGestureDetector = this.gmV.o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      if (paramScaleGestureDetector != null) {}
      Object localObject;
      for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
      {
        this.rTP = paramScaleGestureDetector;
        paramScaleGestureDetector = this.rTP;
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        localObject = this.rTP;
        if (localObject == null) {
          p.gfZ();
        }
        paramScaleGestureDetector = paramScaleGestureDetector.ci(((FinderMediaBanner)localObject).getFocusPosition());
        if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.lQ() != 2)) {
          break label157;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (!com.tencent.mm.plugin.finder.storage.b.cFT()) {
          break;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.auu.findViewById(2131299974);
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        localObject = this.rTN.rTJ;
        if (localObject != null) {
          ((TouchMediaPreviewLayout)localObject).gW(paramScaleGestureDetector);
        }
        AppMethodBeat.o(165624);
        return true;
      }
      AppMethodBeat.o(165624);
      return false;
      label157:
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lQ() == 4))
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (com.tencent.mm.plugin.finder.storage.b.cFU())
        {
          paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.auu.findViewById(2131299975);
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
              localObject = this.rTN.rTJ;
              if (localObject != null) {
                ((TouchMediaPreviewLayout)localObject).gW(paramScaleGestureDetector.getVideoView());
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
      p.h(paramScaleGestureDetector, "detector");
      paramScaleGestureDetector = this.rTN.rTJ;
      if (paramScaleGestureDetector != null)
      {
        paramScaleGestureDetector = paramScaleGestureDetector.getTouchView();
        if (!(paramScaleGestureDetector instanceof o)) {
          break label102;
        }
        paramScaleGestureDetector = this.rTN.rTJ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.b
 * JD-Core Version:    0.7.0.1
 */