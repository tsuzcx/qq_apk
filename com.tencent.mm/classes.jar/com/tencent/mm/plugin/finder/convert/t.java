package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "viewCallBackTag", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "(Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;)V", "floatState", "", "getFloatState", "()Z", "setFloatState", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1;", "tagViewRef", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "getTagViewRef", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "setTagViewRef", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getViewCallBackTag", "()Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "changeToDecorView", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "changeToItemView", "recylerView", "Landroid/support/v7/widget/RecyclerView;", "chekToAddFLoatTagViewWhenFling", "getLayoutId", "", "onAttachedToRecyclerView", "recyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class t
  extends com.tencent.mm.view.recyclerview.b<i>
{
  static String TAG;
  private static int rOp;
  static int rOq;
  public static final t.a rOr;
  boolean rOl;
  FinderTagView rOm;
  private final c rOn;
  final com.tencent.mm.plugin.finder.presenter.base.b rOo;
  
  static
  {
    AppMethodBeat.i(201404);
    rOr = new t.a((byte)0);
    rOp = -2;
    TAG = "Finder.FinderFeedTagsConvert";
    rOq = 2131308027;
    AppMethodBeat.o(201404);
  }
  
  public t(com.tencent.mm.plugin.finder.presenter.base.b paramb)
  {
    AppMethodBeat.i(201403);
    this.rOo = paramb;
    this.rOn = new c(this);
    AppMethodBeat.o(201403);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(201401);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.m)this.rOn);
    paramRecyclerView.a((RecyclerView.m)this.rOn);
    AppMethodBeat.o(201401);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201398);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    AppMethodBeat.o(201398);
  }
  
  public final void a(ViewGroup paramViewGroup, e parame, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201400);
    p.h(paramViewGroup, "parent");
    p.h(parame, "holder");
    p.h(paramRecyclerView, "recylerView");
    if (!this.rOl)
    {
      ad.d(TAG, "changeToItemView:return");
      AppMethodBeat.o(201400);
      return;
    }
    this.rOl = false;
    ad.d(TAG, "changeToItemView,in");
    y.f localf = new y.f();
    localf.MLV = ((FrameLayout)parame.Gd(rOq));
    parame = new y.f();
    FinderTagView.a locala = FinderTagView.sVS;
    parame.MLV = paramViewGroup.findViewById(FinderTagView.cNB());
    if (((View)parame.MLV == null) || ((FrameLayout)localf.MLV == null) || (((FrameLayout)localf.MLV).getChildCount() != 0))
    {
      ad.d(TAG, "changeToItemView:item has been add,return ");
      AppMethodBeat.o(201400);
      return;
    }
    paramRecyclerView.post((Runnable)new t.b(paramViewGroup, parame, localf));
    AppMethodBeat.o(201400);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201402);
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    AppMethodBeat.o(201402);
  }
  
  public final int getLayoutId()
  {
    return 2131496262;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    private final int[] rOu;
    private final int[] value;
    
    c()
    {
      AppMethodBeat.i(201397);
      this.value = new int[2];
      this.rOu = new int[2];
      AppMethodBeat.o(201397);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201395);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramInt2);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = t.rOr;
      Object localObject2;
      Object localObject3;
      if (t.cyZ() > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(201395);
          throw paramRecyclerView;
        }
        localObject2 = (StaggeredGridLayoutManager)localObject1;
        localObject1 = new int[((StaggeredGridLayoutManager)localObject2).jZ()];
        ((StaggeredGridLayoutManager)localObject2).n((int[])localObject1);
        localObject2 = t.rOr;
        localObject2 = t.access$getTAG$cp();
        localObject3 = new StringBuilder("visiablePosition:").append(localObject1[0]).append(",positionInListView:");
        t.a locala = t.rOr;
        ad.d((String)localObject2, t.cyZ());
        paramInt1 = localObject1[0];
        localObject1 = t.rOr;
        if (paramInt1 != t.cyZ()) {
          break label590;
        }
        localObject1 = t.rOr;
        localObject1 = paramRecyclerView.ci(t.cyZ());
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(201395);
          throw paramRecyclerView;
        }
        localObject1 = (e)localObject1;
        ((e)localObject1).auu.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.rOu);
        if (this.rOu[1] - this.value[1] <= 0) {
          break label502;
        }
        paramRecyclerView = t.rOr;
        ad.d(t.access$getTAG$cp(), "changeToDecorView:entrace 1");
        localObject2 = this.rOv;
        paramRecyclerView = this.rOv.rOo.getRootView();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201395);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        p.h(paramRecyclerView, "parent");
        p.h(localObject1, "holder");
        if (!((t)localObject2).rOl) {
          break label381;
        }
        ad.d(t.TAG, "changeToDecorView:return");
      }
      label590:
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(201395);
        return;
        label381:
        ((t)localObject2).rOl = true;
        ad.d(t.TAG, "changeToDecorView,in");
        localObject2 = (FrameLayout)((e)localObject1).Gd(t.rOq);
        localObject3 = FinderTagView.sVS;
        localObject1 = ((e)localObject1).Gd(FinderTagView.cNB());
        p.g(localObject1, "tagView");
        ((View)localObject1).setVisibility(4);
        p.g(localObject2, "tagViewContainer");
        ((FrameLayout)localObject2).getLayoutParams().height = ((View)localObject1).getHeight();
        ((FrameLayout)localObject2).removeView((View)localObject1);
        localObject2 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 48;
        paramRecyclerView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setVisibility(0);
        continue;
        label502:
        if (this.rOu[1] - this.value[1] <= 0)
        {
          localObject2 = t.rOr;
          ad.d(t.access$getTAG$cp(), "changeToItemView:entrace 1");
          localObject2 = this.rOv;
          localObject3 = this.rOv.rOo.getRootView();
          if (localObject3 == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(201395);
            throw paramRecyclerView;
          }
          ((t)localObject2).a((ViewGroup)localObject3, (e)localObject1, paramRecyclerView);
          continue;
          localObject1 = t.rOr;
          localObject1 = paramRecyclerView.ci(t.cyZ());
          if (localObject1 != null)
          {
            if (localObject1 == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
              AppMethodBeat.o(201395);
              throw paramRecyclerView;
            }
            localObject1 = (e)localObject1;
            localObject2 = t.rOr;
            ad.d(t.access$getTAG$cp(), "changeToItemView:entrace 2");
            localObject2 = this.rOv;
            localObject3 = this.rOv.rOo.getRootView();
            if (localObject3 == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(201395);
              throw paramRecyclerView;
            }
            ((t)localObject2).a((ViewGroup)localObject3, (e)localObject1, paramRecyclerView);
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201396);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramInt);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      paramRecyclerView = t.rOr;
      ad.d(t.access$getTAG$cp(), "newState:".concat(String.valueOf(paramInt)));
      Object localObject2;
      if (paramInt == 2)
      {
        localObject1 = this.rOv;
        if (!((t)localObject1).rOl)
        {
          paramRecyclerView = ((t)localObject1).rOo.getRootView();
          localObject2 = FinderTagView.sVS;
          if (paramRecyclerView.findViewById(FinderTagView.cNB()) == null) {
            break label146;
          }
        }
        ad.d(t.TAG, "chekToAddFLoatTagViewWhenFling:return");
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(201396);
        return;
        label146:
        ad.d(t.TAG, "chekToAddFLoatTagViewWhenFling: ");
        ((t)localObject1).rOl = true;
        paramRecyclerView = ((t)localObject1).rOm;
        if (paramRecyclerView != null) {}
        for (paramRecyclerView = paramRecyclerView.getParent(); paramRecyclerView == null; paramRecyclerView = null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201396);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        if (paramRecyclerView != null)
        {
          paramRecyclerView.removeView((View)((t)localObject1).rOm);
          paramRecyclerView = paramRecyclerView.getLayoutParams();
          localObject2 = ((t)localObject1).rOm;
          if (localObject2 == null) {
            break label299;
          }
        }
        label299:
        for (paramInt = ((FinderTagView)localObject2).getHeight();; paramInt = -2)
        {
          paramRecyclerView.height = paramInt;
          paramRecyclerView = new FrameLayout.LayoutParams(-1, -2);
          paramRecyclerView.gravity = 48;
          localObject2 = ((t)localObject1).rOo.getRootView();
          if (localObject2 != null) {
            break;
          }
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201396);
          throw paramRecyclerView;
        }
        ((ViewGroup)localObject2).addView((View)((t)localObject1).rOm, (ViewGroup.LayoutParams)paramRecyclerView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.t
 * JD-Core Version:    0.7.0.1
 */