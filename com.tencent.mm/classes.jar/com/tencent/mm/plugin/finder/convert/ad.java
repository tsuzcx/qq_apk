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
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "viewCallBackTag", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "(Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;)V", "floatState", "", "getFloatState", "()Z", "setFloatState", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1;", "tagViewRef", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "getTagViewRef", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "setTagViewRef", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getViewCallBackTag", "()Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "changeToDecorView", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "changeToItemView", "recylerView", "Landroid/support/v7/widget/RecyclerView;", "chekToAddFLoatTagViewWhenFling", "getLayoutId", "", "onAttachedToRecyclerView", "recyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class ad
  extends com.tencent.mm.view.recyclerview.b<x>
{
  private static int KKY;
  static int KKZ;
  public static final a KLa;
  static String TAG;
  boolean KKU;
  FinderTagView KKV;
  private final c KKW;
  final c KKX;
  
  static
  {
    AppMethodBeat.i(197438);
    KLa = new a((byte)0);
    KKY = -2;
    TAG = "Finder.FinderFeedTagsConvert";
    KKZ = 2131307890;
    AppMethodBeat.o(197438);
  }
  
  public ad(c paramc)
  {
    AppMethodBeat.i(197437);
    this.KKX = paramc;
    this.KKW = new c(this);
    AppMethodBeat.o(197437);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(197435);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.m)this.KKW);
    paramRecyclerView.a((RecyclerView.m)this.KKW);
    AppMethodBeat.o(197435);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(197432);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    AppMethodBeat.o(197432);
  }
  
  public final void a(ViewGroup paramViewGroup, final e parame, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(197434);
    k.h(paramViewGroup, "parent");
    k.h(parame, "holder");
    k.h(paramRecyclerView, "recylerView");
    if (!this.KKU)
    {
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "changeToItemView:return");
      AppMethodBeat.o(197434);
      return;
    }
    this.KKU = false;
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "changeToItemView,in");
    final v.e locale = new v.e();
    locale.Jhw = ((FrameLayout)parame.abq(KKZ));
    parame = new v.e();
    FinderTagView.a locala = FinderTagView.LfB;
    parame.Jhw = paramViewGroup.findViewById(FinderTagView.fWW());
    if (((View)parame.Jhw == null) || ((FrameLayout)locale.Jhw == null) || (((FrameLayout)locale.Jhw).getChildCount() != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "changeToItemView:item has been add,return ");
      AppMethodBeat.o(197434);
      return;
    }
    paramRecyclerView.post((Runnable)new b(paramViewGroup, parame, locale));
    AppMethodBeat.o(197434);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(197436);
    k.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    AppMethodBeat.o(197436);
  }
  
  public final int getLayoutId()
  {
    return 2131496261;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$Companion;", "", "()V", "ITEM_CONTAINER_ID", "", "getITEM_CONTAINER_ID", "()I", "setITEM_CONTAINER_ID", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "positionInListView", "getPositionInListView", "setPositionInListView", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ViewGroup paramViewGroup, v.e parame1, v.e parame2) {}
    
    public final void run()
    {
      AppMethodBeat.i(197428);
      this.Kzj.removeView((View)parame.Jhw);
      ((FrameLayout)locale.Jhw).getLayoutParams().height = -2;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 48;
      ((FrameLayout)locale.Jhw).addView((View)parame.Jhw, (ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(197428);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    private final int[] KLd;
    private final int[] value;
    
    c()
    {
      AppMethodBeat.i(197431);
      this.value = new int[2];
      this.KLd = new int[2];
      AppMethodBeat.o(197431);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197429);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lT(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lT(paramInt2);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = ad.KLa;
      Object localObject2;
      Object localObject3;
      if (ad.fSh() > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(197429);
          throw paramRecyclerView;
        }
        localObject2 = (StaggeredGridLayoutManager)localObject1;
        localObject1 = new int[((StaggeredGridLayoutManager)localObject2).jB()];
        ((StaggeredGridLayoutManager)localObject2).x((int[])localObject1);
        localObject2 = ad.KLa;
        localObject2 = ad.access$getTAG$cp();
        localObject3 = new StringBuilder("visiablePosition:").append(localObject1[0]).append(",positionInListView:");
        ad.a locala = ad.KLa;
        com.tencent.mm.sdk.platformtools.ad.d((String)localObject2, ad.fSh());
        paramInt1 = localObject1[0];
        localObject1 = ad.KLa;
        if (paramInt1 != ad.fSh()) {
          break label590;
        }
        localObject1 = ad.KLa;
        localObject1 = paramRecyclerView.cj(ad.fSh());
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(197429);
          throw paramRecyclerView;
        }
        localObject1 = (e)localObject1;
        ((e)localObject1).arI.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.KLd);
        if (this.KLd[1] - this.value[1] <= 0) {
          break label502;
        }
        paramRecyclerView = ad.KLa;
        com.tencent.mm.sdk.platformtools.ad.d(ad.access$getTAG$cp(), "changeToDecorView:entrace 1");
        localObject2 = this.KLe;
        paramRecyclerView = this.KLe.KKX.getRootView();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(197429);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        k.h(paramRecyclerView, "parent");
        k.h(localObject1, "holder");
        if (!((ad)localObject2).KKU) {
          break label381;
        }
        com.tencent.mm.sdk.platformtools.ad.d(ad.TAG, "changeToDecorView:return");
      }
      label590:
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(197429);
        return;
        label381:
        ((ad)localObject2).KKU = true;
        com.tencent.mm.sdk.platformtools.ad.d(ad.TAG, "changeToDecorView,in");
        localObject2 = (FrameLayout)((e)localObject1).abq(ad.KKZ);
        localObject3 = FinderTagView.LfB;
        localObject1 = ((e)localObject1).abq(FinderTagView.fWW());
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
        if (this.KLd[1] - this.value[1] <= 0)
        {
          localObject2 = ad.KLa;
          com.tencent.mm.sdk.platformtools.ad.d(ad.access$getTAG$cp(), "changeToItemView:entrace 1");
          localObject2 = this.KLe;
          localObject3 = this.KLe.KKX.getRootView();
          if (localObject3 == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(197429);
            throw paramRecyclerView;
          }
          ((ad)localObject2).a((ViewGroup)localObject3, (e)localObject1, paramRecyclerView);
          continue;
          localObject1 = ad.KLa;
          localObject1 = paramRecyclerView.cj(ad.fSh());
          if (localObject1 != null)
          {
            if (localObject1 == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
              AppMethodBeat.o(197429);
              throw paramRecyclerView;
            }
            localObject1 = (e)localObject1;
            localObject2 = ad.KLa;
            com.tencent.mm.sdk.platformtools.ad.d(ad.access$getTAG$cp(), "changeToItemView:entrace 2");
            localObject2 = this.KLe;
            localObject3 = this.KLe.KKX.getRootView();
            if (localObject3 == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(197429);
              throw paramRecyclerView;
            }
            ((ad)localObject2).a((ViewGroup)localObject3, (e)localObject1, paramRecyclerView);
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(197430);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lT(paramInt);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ado());
      k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      paramRecyclerView = ad.KLa;
      com.tencent.mm.sdk.platformtools.ad.d(ad.access$getTAG$cp(), "newState:".concat(String.valueOf(paramInt)));
      Object localObject2;
      if (paramInt == 2)
      {
        localObject1 = this.KLe;
        if (!((ad)localObject1).KKU)
        {
          paramRecyclerView = ((ad)localObject1).KKX.getRootView();
          localObject2 = FinderTagView.LfB;
          if (paramRecyclerView.findViewById(FinderTagView.fWW()) == null) {
            break label146;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.d(ad.TAG, "chekToAddFLoatTagViewWhenFling:return");
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(197430);
        return;
        label146:
        com.tencent.mm.sdk.platformtools.ad.d(ad.TAG, "chekToAddFLoatTagViewWhenFling: ");
        ((ad)localObject1).KKU = true;
        paramRecyclerView = ((ad)localObject1).KKV;
        if (paramRecyclerView != null) {}
        for (paramRecyclerView = paramRecyclerView.getParent(); paramRecyclerView == null; paramRecyclerView = null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(197430);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        if (paramRecyclerView != null)
        {
          paramRecyclerView.removeView((View)((ad)localObject1).KKV);
          paramRecyclerView = paramRecyclerView.getLayoutParams();
          localObject2 = ((ad)localObject1).KKV;
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
          localObject2 = ((ad)localObject1).KKX.getRootView();
          if (localObject2 != null) {
            break;
          }
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(197430);
          throw paramRecyclerView;
        }
        ((ViewGroup)localObject2).addView((View)((ad)localObject1).KKV, (ViewGroup.LayoutParams)paramRecyclerView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ad
 * JD-Core Version:    0.7.0.1
 */