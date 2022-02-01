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
import com.tencent.mm.plugin.finder.model.am;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;IIZ)V", "HEADER_COUNT", "getHEADER_COUNT", "()I", "setHEADER_COUNT", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "likeDrawer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "getActivity", "getAdapter", "getDrawer", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLikeDrawer", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "initView", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
public abstract class a$b
  implements c<a.a>
{
  protected final MMActivity fNT;
  private WxRecyclerAdapter<?> rXV;
  int rgr;
  private final int scene;
  private final int sch;
  public RefreshLoadMoreLayout scj;
  private e sck;
  private FinderLikeDrawer scl;
  public FinderLikeDrawer scm;
  public TouchMediaPreviewLayout scn;
  final a.a sco;
  private final boolean scp;
  
  public a$b(MMActivity paramMMActivity, a.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.fNT = paramMMActivity;
    this.sco = parama;
    this.scene = paramInt1;
    this.sch = paramInt2;
    this.scp = paramBoolean;
    paramMMActivity = this.fNT.findViewById(2131304203);
    p.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.scj = ((RefreshLoadMoreLayout)paramMMActivity);
  }
  
  public void EK(int paramInt) {}
  
  public void T(ArrayList<am> paramArrayList)
  {
    p.h(paramArrayList, "data");
    final RecyclerView localRecyclerView = this.scj.getRecyclerView();
    localRecyclerView.setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    this.rXV = new WxRecyclerAdapter(this.sco.cCq(), paramArrayList);
    paramArrayList = this.rXV;
    if (paramArrayList == null) {
      p.bdF("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
    localRecyclerView.b(getItemDecoration());
    this.scj.setActionCallback((RefreshLoadMoreLayout.a)new a(this, localRecyclerView));
    paramArrayList = com.tencent.mm.ui.component.a.KEX;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fNT).get(FinderReporterUIC.class));
    if (paramArrayList != null) {
      paramArrayList.s(localRecyclerView);
    }
    cCw();
  }
  
  public final void U(ArrayList<am> paramArrayList)
  {
    p.h(paramArrayList, "data");
    Object localObject1 = e.tdM;
    localObject1 = this.fNT;
    Object localObject2 = this.fNT.getWindow();
    p.g(localObject2, "getActivity().window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.g(localObject2, "getActivity().window.decorView");
    this.sck = e.a.a((MMActivity)localObject1, (View)localObject2, this.scene, this.scp);
    localObject1 = FinderLikeDrawer.tgd;
    localObject1 = (Context)this.fNT;
    localObject2 = this.fNT.getWindow();
    p.g(localObject2, "getActivity().window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.tgd;
    this.scl = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cQe());
    localObject1 = FinderLikeDrawer.tgd;
    localObject1 = (Context)this.fNT;
    localObject2 = this.fNT.getWindow();
    p.g(localObject2, "getActivity().window");
    locala = FinderLikeDrawer.tgd;
    this.scm = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cQd());
    T(paramArrayList);
    this.scn = new TouchMediaPreviewLayout((Context)this.fNT);
    paramArrayList = this.scn;
    if (paramArrayList != null)
    {
      localObject1 = this.fNT.getWindow();
      p.g(localObject1, "context.window");
      localObject1 = ((Window)localObject1).getDecorView();
      p.g(localObject1, "context.window.decorView");
      paramArrayList.hc((View)localObject1);
    }
    paramArrayList = this.scn;
    if (paramArrayList != null) {
      paramArrayList.setScaleListener((TouchMediaPreviewLayout.b)new b(this));
    }
  }
  
  public final FinderLikeDrawer cCv()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.scm;
    if (localFinderLikeDrawer == null) {
      p.bdF("friendLikeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public abstract void cCw();
  
  public final e cCx()
  {
    e locale = this.sck;
    if (locale == null) {
      p.bdF("drawer");
    }
    return locale;
  }
  
  public final FinderLikeDrawer cCy()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.scl;
    if (localFinderLikeDrawer == null) {
      p.bdF("likeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.rXV;
    if (localWxRecyclerAdapter == null) {
      p.bdF("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public RecyclerView.h getItemDecoration()
  {
    return (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a(this).getColor(2131099648)), (int)c.a.a(this).getDimension(2131166294));
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    private boolean scq = true;
    
    a(RecyclerView paramRecyclerView) {}
    
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(202142);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      h.MqF.aO((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202142);
    }
    
    public final void EK(int paramInt)
    {
      AppMethodBeat.i(165623);
      this.scr.EK(paramInt);
      if ((this.scq) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.KEX;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.scr.fNT).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((f)localObject).cBd().b(localRecyclerView, 5);
        }
        this.scq = false;
      }
      AppMethodBeat.o(165623);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202143);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      this.scr.sco.cCp();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202143);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165620);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      super.b(paramc);
      this.scr.sco.cCo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165620);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(165622);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bZA();
      h.MqF.aO((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165622);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(165618);
        this.scs.scr.sco.aTS();
        AppMethodBeat.o(165618);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.b.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(165619);
        this.scs.scr.sco.requestRefresh();
        AppMethodBeat.o(165619);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private final RecyclerView gpr;
    private FinderMediaBanner sct;
    
    b()
    {
      AppMethodBeat.i(165627);
      this.gpr = localObject.scj.getRecyclerView();
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
      paramScaleGestureDetector = this.gpr.o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      if (paramScaleGestureDetector != null) {}
      Object localObject;
      for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
      {
        this.sct = paramScaleGestureDetector;
        paramScaleGestureDetector = this.sct;
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        localObject = this.sct;
        if (localObject == null) {
          p.gkB();
        }
        paramScaleGestureDetector = paramScaleGestureDetector.ci(((FinderMediaBanner)localObject).getFocusPosition());
        if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.lQ() != 2)) {
          break label157;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (!com.tencent.mm.plugin.finder.storage.b.cHQ()) {
          break;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.auu.findViewById(2131299974);
        if (paramScaleGestureDetector == null) {
          break label280;
        }
        localObject = this.scr.scn;
        if (localObject != null) {
          ((TouchMediaPreviewLayout)localObject).hb(paramScaleGestureDetector);
        }
        AppMethodBeat.o(165624);
        return true;
      }
      AppMethodBeat.o(165624);
      return false;
      label157:
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lQ() == 4))
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cHR())
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
              localObject = this.scr.scn;
              if (localObject != null) {
                ((TouchMediaPreviewLayout)localObject).hb(paramScaleGestureDetector.getVideoView());
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
      paramScaleGestureDetector = this.scr.scn;
      if (paramScaleGestureDetector != null)
      {
        paramScaleGestureDetector = paramScaleGestureDetector.getTouchView();
        if (!(paramScaleGestureDetector instanceof o)) {
          break label102;
        }
        paramScaleGestureDetector = this.scr.scn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.b
 * JD-Core Version:    0.7.0.1
 */