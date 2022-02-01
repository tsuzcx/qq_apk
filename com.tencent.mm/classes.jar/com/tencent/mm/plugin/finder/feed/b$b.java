package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.ui.e;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.finder.model.cc;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;IIZ)V", "HEADER_COUNT", "getHEADER_COUNT", "()I", "setHEADER_COUNT", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "likeDrawer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "getActivity", "getAdapter", "getDrawer", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLikeDrawer", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRfLayout", "getSnapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "initView", "needScrollData", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b$b
  implements c<b.a>
{
  private final int AJo;
  private WxRecyclerAdapter<?> ALE;
  public FinderLikeDrawer ATA;
  public TouchMediaPreviewLayout ATB;
  final b.a ATv;
  private final boolean ATw;
  public RefreshLoadMoreLayout ATx;
  private com.tencent.mm.plugin.finder.view.f ATy;
  private FinderLikeDrawer ATz;
  protected final MMActivity lzt;
  private final int scene;
  int zJM;
  
  public b$b(MMActivity paramMMActivity, b.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.lzt = paramMMActivity;
    this.ATv = parama;
    this.scene = paramInt1;
    this.AJo = paramInt2;
    this.ATw = paramBoolean;
    paramMMActivity = this.lzt.findViewById(e.e.rl_layout);
    s.s(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)paramMMActivity);
  }
  
  public void ND(int paramInt) {}
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    s.u(paramArrayList, "data");
    Object localObject1 = com.tencent.mm.plugin.finder.view.f.GxF;
    localObject1 = (MMFragmentActivity)this.lzt;
    Object localObject2 = this.lzt.getWindow().getDecorView();
    s.s(localObject2, "getActivity().window.decorView");
    this.ATy = f.a.a((MMFragmentActivity)localObject1, (View)localObject2, this.scene, this.ATw, 0, 16);
    localObject1 = FinderLikeDrawer.GAf;
    localObject1 = (Context)this.lzt;
    localObject2 = this.lzt.getWindow();
    s.s(localObject2, "getActivity().window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.GAf;
    this.ATz = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fkN());
    localObject1 = FinderLikeDrawer.GAf;
    localObject1 = (Context)this.lzt;
    localObject2 = this.lzt.getWindow();
    s.s(localObject2, "getActivity().window");
    locala = FinderLikeDrawer.GAf;
    localObject1 = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fkM());
    s.u(localObject1, "<set-?>");
    this.ATA = ((FinderLikeDrawer)localObject1);
    af(paramArrayList);
  }
  
  public void af(ArrayList<cc> paramArrayList)
  {
    s.u(paramArrayList, "data");
    final RecyclerView localRecyclerView = this.ATx.getRecyclerView();
    Object localObject1 = new FinderLinearLayoutManager((Context)this.lzt);
    ((FinderLinearLayoutManager)localObject1).GGx = 25.0F;
    ((FinderLinearLayoutManager)localObject1).xwJ = 100;
    Object localObject2 = ah.aiuX;
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject1);
    if ((localRecyclerView instanceof FinderRecyclerView))
    {
      localObject2 = (FinderRecyclerView)localRecyclerView;
      localObject1 = ((FinderRecyclerView)localRecyclerView).getLayoutManager();
      if (!(localObject1 instanceof FinderLinearLayoutManager)) {
        break label229;
      }
    }
    label229:
    for (localObject1 = (FinderLinearLayoutManager)localObject1;; localObject1 = null)
    {
      ((FinderRecyclerView)localObject2).a((LinearLayoutManager)localObject1);
      this.ALE = new WxRecyclerAdapter(this.ATv.dUK(), paramArrayList, ebG());
      localObject1 = this.ALE;
      paramArrayList = (ArrayList<cc>)localObject1;
      if (localObject1 == null)
      {
        s.bIx("adapter");
        paramArrayList = null;
      }
      localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
      ((x)new e()).a(localRecyclerView);
      this.ATx.setActionCallback((RefreshLoadMoreLayout.b)new a(this, localRecyclerView));
      paramArrayList = k.aeZF;
      paramArrayList = k.d((AppCompatActivity)this.lzt).q(as.class);
      s.s(paramArrayList, "UICProvider.of(context).…rReporterUIC::class.java)");
      paramArrayList = as.b((as)paramArrayList);
      if (paramArrayList != null) {
        paramArrayList.o(localRecyclerView);
      }
      ebi();
      return;
    }
  }
  
  public final FinderLikeDrawer ebF()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.ATA;
    if (localFinderLikeDrawer != null) {
      return localFinderLikeDrawer;
    }
    s.bIx("friendLikeDrawer");
    return null;
  }
  
  public boolean ebG()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.view.f ebH()
  {
    com.tencent.mm.plugin.finder.view.f localf2 = this.ATy;
    com.tencent.mm.plugin.finder.view.f localf1 = localf2;
    if (localf2 == null)
    {
      s.bIx("drawer");
      localf1 = null;
    }
    return localf1;
  }
  
  public final FinderLikeDrawer ebI()
  {
    FinderLikeDrawer localFinderLikeDrawer2 = this.ATz;
    FinderLikeDrawer localFinderLikeDrawer1 = localFinderLikeDrawer2;
    if (localFinderLikeDrawer2 == null)
    {
      s.bIx("likeDrawer");
      localFinderLikeDrawer1 = null;
    }
    return localFinderLikeDrawer1;
  }
  
  public abstract void ebi();
  
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback$initRecyclerView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RefreshLoadMoreLayout.b
  {
    private boolean ATC = true;
    
    a(b.b paramb, RecyclerView paramRecyclerView) {}
    
    private static final void b(b.b paramb)
    {
      AppMethodBeat.i(363235);
      s.u(paramb, "this$0");
      paramb.ATv.requestRefresh();
      AppMethodBeat.o(363235);
    }
    
    private static final void c(b.b paramb)
    {
      AppMethodBeat.i(363246);
      s.u(paramb, "this$0");
      paramb.ATv.bXB();
      AppMethodBeat.o(363246);
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(363300);
      super.IH(paramInt);
      h.ahAA.bm(new b.b.a..ExternalSyntheticLambda1(this.ATD));
      AppMethodBeat.o(363300);
    }
    
    public final void ND(int paramInt)
    {
      AppMethodBeat.i(363332);
      this.ATD.ND(paramInt);
      if ((this.ATC) && (paramInt > 0))
      {
        Object localObject = k.aeZF;
        localObject = k.d((AppCompatActivity)this.ATD.lzt).q(as.class);
        s.s(localObject, "UICProvider.of(context).…rReporterUIC::class.java)");
        localObject = as.b((as)localObject);
        if (localObject != null)
        {
          RecyclerView localRecyclerView = localRecyclerView;
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dYJ().onScrollStateChanged(localRecyclerView, 5);
        }
        this.ATC = false;
      }
      AppMethodBeat.o(363332);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363319);
      s.u(paramd, "reason");
      this.ATD.ATv.a(paramd);
      AppMethodBeat.o(363319);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      Object localObject = null;
      AppMethodBeat.i(363289);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      View localView = this.ATD.getEmptyView();
      int i;
      if (localView != null)
      {
        paramd = this.ATD.ATx.getRecyclerView().getAdapter();
        if (!(paramd instanceof WxRecyclerAdapter)) {
          break label143;
        }
        paramd = (WxRecyclerAdapter)paramd;
        if (paramd != null) {
          break label148;
        }
        i = 0;
        label64:
        if (i > 0) {
          break label164;
        }
        localView.setVisibility(0);
        if (paramd != null) {
          break label156;
        }
        paramd = localObject;
        label80:
        if (paramd != null) {
          paramd.setVisibility(8);
        }
        paramd = localView.findViewById(e.e.retry_tip);
        if (paramd != null) {
          paramd.setVisibility(0);
        }
        paramd = localView.findViewById(e.e.progress);
        if (paramd != null) {
          paramd.setVisibility(8);
        }
      }
      label143:
      label148:
      label156:
      label164:
      label195:
      for (;;)
      {
        this.ATD.ATv.eby();
        AppMethodBeat.o(363289);
        return;
        paramd = null;
        break;
        i = paramd.jNl();
        break label64;
        paramd = paramd.getRecyclerView();
        break label80;
        localView.setVisibility(8);
        if (paramd == null) {}
        for (paramd = null;; paramd = paramd.getRecyclerView())
        {
          if (paramd == null) {
            break label195;
          }
          paramd.setVisibility(0);
          break;
        }
      }
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(363310);
      super.qI(paramInt);
      h.ahAA.bm(new b.b.a..ExternalSyntheticLambda0(this.ATD));
      AppMethodBeat.o(363310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.b
 * JD-Core Version:    0.7.0.1
 */