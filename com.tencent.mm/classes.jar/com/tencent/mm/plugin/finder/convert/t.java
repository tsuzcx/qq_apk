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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "viewCallBackTag", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "(Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;)V", "floatState", "", "getFloatState", "()Z", "setFloatState", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1;", "tagViewRef", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "getTagViewRef", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "setTagViewRef", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getViewCallBackTag", "()Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "changeToDecorView", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "changeToItemView", "recylerView", "Landroid/support/v7/widget/RecyclerView;", "chekToAddFLoatTagViewWhenFling", "getLayoutId", "", "onAttachedToRecyclerView", "recyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class t
  extends com.tencent.mm.view.recyclerview.b<i>
{
  static String TAG;
  private static int rWP;
  static int rWQ;
  public static final t.a rWR;
  boolean rWL;
  FinderTagView rWM;
  private final c rWN;
  final com.tencent.mm.plugin.finder.presenter.base.b rWO;
  
  static
  {
    AppMethodBeat.i(201842);
    rWR = new t.a((byte)0);
    rWP = -2;
    TAG = "Finder.FinderFeedTagsConvert";
    rWQ = 2131308027;
    AppMethodBeat.o(201842);
  }
  
  public t(com.tencent.mm.plugin.finder.presenter.base.b paramb)
  {
    AppMethodBeat.i(201841);
    this.rWO = paramb;
    this.rWN = new c(this);
    AppMethodBeat.o(201841);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(201839);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.m)this.rWN);
    paramRecyclerView.a((RecyclerView.m)this.rWN);
    AppMethodBeat.o(201839);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201836);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    AppMethodBeat.o(201836);
  }
  
  public final void a(ViewGroup paramViewGroup, e parame, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201838);
    p.h(paramViewGroup, "parent");
    p.h(parame, "holder");
    p.h(paramRecyclerView, "recylerView");
    if (!this.rWL)
    {
      ae.d(TAG, "changeToItemView:return");
      AppMethodBeat.o(201838);
      return;
    }
    this.rWL = false;
    ae.d(TAG, "changeToItemView,in");
    y.f localf = new y.f();
    localf.NiY = ((FrameLayout)parame.GD(rWQ));
    parame = new y.f();
    FinderTagView.a locala = FinderTagView.thj;
    parame.NiY = paramViewGroup.findViewById(FinderTagView.cQl());
    if (((View)parame.NiY == null) || ((FrameLayout)localf.NiY == null) || (((FrameLayout)localf.NiY).getChildCount() != 0))
    {
      ae.d(TAG, "changeToItemView:item has been add,return ");
      AppMethodBeat.o(201838);
      return;
    }
    paramRecyclerView.post((Runnable)new t.b(paramViewGroup, parame, localf));
    AppMethodBeat.o(201838);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201840);
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    AppMethodBeat.o(201840);
  }
  
  public final int getLayoutId()
  {
    return 2131496262;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    private final int[] rWU;
    private final int[] value;
    
    c()
    {
      AppMethodBeat.i(201835);
      this.value = new int[2];
      this.rWU = new int[2];
      AppMethodBeat.o(201835);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201833);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramInt2);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = t.rWR;
      Object localObject2;
      Object localObject3;
      if (t.cAD() > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(201833);
          throw paramRecyclerView;
        }
        localObject2 = (StaggeredGridLayoutManager)localObject1;
        localObject1 = new int[((StaggeredGridLayoutManager)localObject2).jZ()];
        ((StaggeredGridLayoutManager)localObject2).n((int[])localObject1);
        localObject2 = t.rWR;
        localObject2 = t.access$getTAG$cp();
        localObject3 = new StringBuilder("visiablePosition:").append(localObject1[0]).append(",positionInListView:");
        t.a locala = t.rWR;
        ae.d((String)localObject2, t.cAD());
        paramInt1 = localObject1[0];
        localObject1 = t.rWR;
        if (paramInt1 != t.cAD()) {
          break label590;
        }
        localObject1 = t.rWR;
        localObject1 = paramRecyclerView.ci(t.cAD());
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(201833);
          throw paramRecyclerView;
        }
        localObject1 = (e)localObject1;
        ((e)localObject1).auu.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.rWU);
        if (this.rWU[1] - this.value[1] <= 0) {
          break label502;
        }
        paramRecyclerView = t.rWR;
        ae.d(t.access$getTAG$cp(), "changeToDecorView:entrace 1");
        localObject2 = this.rWV;
        paramRecyclerView = this.rWV.rWO.getRootView();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201833);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        p.h(paramRecyclerView, "parent");
        p.h(localObject1, "holder");
        if (!((t)localObject2).rWL) {
          break label381;
        }
        ae.d(t.TAG, "changeToDecorView:return");
      }
      label590:
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(201833);
        return;
        label381:
        ((t)localObject2).rWL = true;
        ae.d(t.TAG, "changeToDecorView,in");
        localObject2 = (FrameLayout)((e)localObject1).GD(t.rWQ);
        localObject3 = FinderTagView.thj;
        localObject1 = ((e)localObject1).GD(FinderTagView.cQl());
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
        if (this.rWU[1] - this.value[1] <= 0)
        {
          localObject2 = t.rWR;
          ae.d(t.access$getTAG$cp(), "changeToItemView:entrace 1");
          localObject2 = this.rWV;
          localObject3 = this.rWV.rWO.getRootView();
          if (localObject3 == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(201833);
            throw paramRecyclerView;
          }
          ((t)localObject2).a((ViewGroup)localObject3, (e)localObject1, paramRecyclerView);
          continue;
          localObject1 = t.rWR;
          localObject1 = paramRecyclerView.ci(t.cAD());
          if (localObject1 != null)
          {
            if (localObject1 == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
              AppMethodBeat.o(201833);
              throw paramRecyclerView;
            }
            localObject1 = (e)localObject1;
            localObject2 = t.rWR;
            ae.d(t.access$getTAG$cp(), "changeToItemView:entrace 2");
            localObject2 = this.rWV;
            localObject3 = this.rWV.rWO.getRootView();
            if (localObject3 == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(201833);
              throw paramRecyclerView;
            }
            ((t)localObject2).a((ViewGroup)localObject3, (e)localObject1, paramRecyclerView);
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201834);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramInt);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      paramRecyclerView = t.rWR;
      ae.d(t.access$getTAG$cp(), "newState:".concat(String.valueOf(paramInt)));
      Object localObject2;
      if (paramInt == 2)
      {
        localObject1 = this.rWV;
        if (!((t)localObject1).rWL)
        {
          paramRecyclerView = ((t)localObject1).rWO.getRootView();
          localObject2 = FinderTagView.thj;
          if (paramRecyclerView.findViewById(FinderTagView.cQl()) == null) {
            break label146;
          }
        }
        ae.d(t.TAG, "chekToAddFLoatTagViewWhenFling:return");
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(201834);
        return;
        label146:
        ae.d(t.TAG, "chekToAddFLoatTagViewWhenFling: ");
        ((t)localObject1).rWL = true;
        paramRecyclerView = ((t)localObject1).rWM;
        if (paramRecyclerView != null) {}
        for (paramRecyclerView = paramRecyclerView.getParent(); paramRecyclerView == null; paramRecyclerView = null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201834);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        if (paramRecyclerView != null)
        {
          paramRecyclerView.removeView((View)((t)localObject1).rWM);
          paramRecyclerView = paramRecyclerView.getLayoutParams();
          localObject2 = ((t)localObject1).rWM;
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
          localObject2 = ((t)localObject1).rWO.getRootView();
          if (localObject2 != null) {
            break;
          }
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201834);
          throw paramRecyclerView;
        }
        ((ViewGroup)localObject2).addView((View)((t)localObject1).rWM, (ViewGroup.LayoutParams)paramRecyclerView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.t
 * JD-Core Version:    0.7.0.1
 */