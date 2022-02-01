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
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "viewCallBackTag", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "(Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;)V", "floatState", "", "getFloatState", "()Z", "setFloatState", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1;", "tagViewRef", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "getTagViewRef", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "setTagViewRef", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getViewCallBackTag", "()Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "changeToDecorView", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "changeToItemView", "recylerView", "Landroid/support/v7/widget/RecyclerView;", "chekToAddFLoatTagViewWhenFling", "getLayoutId", "", "onAttachedToRecyclerView", "recyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class s
  extends com.tencent.mm.view.recyclerview.b<h>
{
  static String TAG;
  static int rbA;
  public static final s.a rbB;
  private static int rbz;
  boolean rbv;
  FinderTagView rbw;
  private final c rbx;
  final com.tencent.mm.plugin.finder.presenter.base.b rby;
  
  static
  {
    AppMethodBeat.i(201313);
    rbB = new s.a((byte)0);
    rbz = -2;
    TAG = "Finder.FinderFeedTagsConvert";
    rbA = 2131308027;
    AppMethodBeat.o(201313);
  }
  
  public s(com.tencent.mm.plugin.finder.presenter.base.b paramb)
  {
    AppMethodBeat.i(201312);
    this.rby = paramb;
    this.rbx = new c(this);
    AppMethodBeat.o(201312);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(201310);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.m)this.rbx);
    paramRecyclerView.a((RecyclerView.m)this.rbx);
    AppMethodBeat.o(201310);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201307);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    AppMethodBeat.o(201307);
  }
  
  public final void a(ViewGroup paramViewGroup, e parame, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201309);
    k.h(paramViewGroup, "parent");
    k.h(parame, "holder");
    k.h(paramRecyclerView, "recylerView");
    if (!this.rbv)
    {
      ac.d(TAG, "changeToItemView:return");
      AppMethodBeat.o(201309);
      return;
    }
    this.rbv = false;
    ac.d(TAG, "changeToItemView,in");
    v.f localf = new v.f();
    localf.KUQ = ((FrameLayout)parame.adJ(rbA));
    parame = new v.f();
    FinderTagView.a locala = FinderTagView.rYW;
    parame.KUQ = paramViewGroup.findViewById(FinderTagView.cFh());
    if (((View)parame.KUQ == null) || ((FrameLayout)localf.KUQ == null) || (((FrameLayout)localf.KUQ).getChildCount() != 0))
    {
      ac.d(TAG, "changeToItemView:item has been add,return ");
      AppMethodBeat.o(201309);
      return;
    }
    paramRecyclerView.post((Runnable)new s.b(paramViewGroup, parame, localf));
    AppMethodBeat.o(201309);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201311);
    k.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    AppMethodBeat.o(201311);
  }
  
  public final int getLayoutId()
  {
    return 2131496262;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    private final int[] rbE;
    private final int[] value;
    
    c()
    {
      AppMethodBeat.i(201306);
      this.value = new int[2];
      this.rbE = new int[2];
      AppMethodBeat.o(201306);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201304);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lS(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lS(paramInt2);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = s.rbB;
      Object localObject2;
      Object localObject3;
      if (s.csX() > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(201304);
          throw paramRecyclerView;
        }
        localObject2 = (StaggeredGridLayoutManager)localObject1;
        localObject1 = new int[((StaggeredGridLayoutManager)localObject2).jJ()];
        ((StaggeredGridLayoutManager)localObject2).n((int[])localObject1);
        localObject2 = s.rbB;
        localObject2 = s.access$getTAG$cp();
        localObject3 = new StringBuilder("visiablePosition:").append(localObject1[0]).append(",positionInListView:");
        s.a locala = s.rbB;
        ac.d((String)localObject2, s.csX());
        paramInt1 = localObject1[0];
        localObject1 = s.rbB;
        if (paramInt1 != s.csX()) {
          break label590;
        }
        localObject1 = s.rbB;
        localObject1 = paramRecyclerView.ci(s.csX());
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(201304);
          throw paramRecyclerView;
        }
        localObject1 = (e)localObject1;
        ((e)localObject1).asD.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.rbE);
        if (this.rbE[1] - this.value[1] <= 0) {
          break label502;
        }
        paramRecyclerView = s.rbB;
        ac.d(s.access$getTAG$cp(), "changeToDecorView:entrace 1");
        localObject2 = this.rbF;
        paramRecyclerView = this.rbF.rby.getRootView();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201304);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        k.h(paramRecyclerView, "parent");
        k.h(localObject1, "holder");
        if (!((s)localObject2).rbv) {
          break label381;
        }
        ac.d(s.TAG, "changeToDecorView:return");
      }
      label590:
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(201304);
        return;
        label381:
        ((s)localObject2).rbv = true;
        ac.d(s.TAG, "changeToDecorView,in");
        localObject2 = (FrameLayout)((e)localObject1).adJ(s.rbA);
        localObject3 = FinderTagView.rYW;
        localObject1 = ((e)localObject1).adJ(FinderTagView.cFh());
        k.g(localObject1, "tagView");
        ((View)localObject1).setVisibility(4);
        k.g(localObject2, "tagViewContainer");
        ((FrameLayout)localObject2).getLayoutParams().height = ((View)localObject1).getHeight();
        ((FrameLayout)localObject2).removeView((View)localObject1);
        localObject2 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 48;
        paramRecyclerView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setVisibility(0);
        continue;
        label502:
        if (this.rbE[1] - this.value[1] <= 0)
        {
          localObject2 = s.rbB;
          ac.d(s.access$getTAG$cp(), "changeToItemView:entrace 1");
          localObject2 = this.rbF;
          localObject3 = this.rbF.rby.getRootView();
          if (localObject3 == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(201304);
            throw paramRecyclerView;
          }
          ((s)localObject2).a((ViewGroup)localObject3, (e)localObject1, paramRecyclerView);
          continue;
          localObject1 = s.rbB;
          localObject1 = paramRecyclerView.ci(s.csX());
          if (localObject1 != null)
          {
            if (localObject1 == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
              AppMethodBeat.o(201304);
              throw paramRecyclerView;
            }
            localObject1 = (e)localObject1;
            localObject2 = s.rbB;
            ac.d(s.access$getTAG$cp(), "changeToItemView:entrace 2");
            localObject2 = this.rbF;
            localObject3 = this.rbF.rby.getRootView();
            if (localObject3 == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(201304);
              throw paramRecyclerView;
            }
            ((s)localObject2).a((ViewGroup)localObject3, (e)localObject1, paramRecyclerView);
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201305);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lS(paramInt);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      paramRecyclerView = s.rbB;
      ac.d(s.access$getTAG$cp(), "newState:".concat(String.valueOf(paramInt)));
      Object localObject2;
      if (paramInt == 2)
      {
        localObject1 = this.rbF;
        if (!((s)localObject1).rbv)
        {
          paramRecyclerView = ((s)localObject1).rby.getRootView();
          localObject2 = FinderTagView.rYW;
          if (paramRecyclerView.findViewById(FinderTagView.cFh()) == null) {
            break label146;
          }
        }
        ac.d(s.TAG, "chekToAddFLoatTagViewWhenFling:return");
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(201305);
        return;
        label146:
        ac.d(s.TAG, "chekToAddFLoatTagViewWhenFling: ");
        ((s)localObject1).rbv = true;
        paramRecyclerView = ((s)localObject1).rbw;
        if (paramRecyclerView != null) {}
        for (paramRecyclerView = paramRecyclerView.getParent(); paramRecyclerView == null; paramRecyclerView = null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201305);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        if (paramRecyclerView != null)
        {
          paramRecyclerView.removeView((View)((s)localObject1).rbw);
          paramRecyclerView = paramRecyclerView.getLayoutParams();
          localObject2 = ((s)localObject1).rbw;
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
          localObject2 = ((s)localObject1).rby.getRootView();
          if (localObject2 != null) {
            break;
          }
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201305);
          throw paramRecyclerView;
        }
        ((ViewGroup)localObject2).addView((View)((s)localObject1).rbw, (ViewGroup.LayoutParams)paramRecyclerView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.s
 * JD-Core Version:    0.7.0.1
 */