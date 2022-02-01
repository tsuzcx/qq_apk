package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "viewCallBackTag", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "(Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;)V", "floatState", "", "getFloatState", "()Z", "setFloatState", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1;", "tagViewRef", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "getTagViewRef", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "setTagViewRef", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getViewCallBackTag", "()Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "changeToDecorView", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "changeToItemView", "recylerView", "Landroidx/recyclerview/widget/RecyclerView;", "chekToAddFLoatTagViewWhenFling", "getLayoutId", "", "onAttachedToRecyclerView", "recyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class aj
  extends e<j>
{
  static String TAG;
  private static int xmt;
  static int xmu;
  public static final aj.a xmv;
  boolean xmp;
  FinderTagView xmq;
  private final c xmr;
  final com.tencent.mm.plugin.finder.presenter.base.b xms;
  
  static
  {
    AppMethodBeat.i(289745);
    xmv = new aj.a((byte)0);
    xmt = -2;
    TAG = "Finder.FinderFeedTagsConvert";
    xmu = b.f.tag_layout_container;
    AppMethodBeat.o(289745);
  }
  
  public aj(com.tencent.mm.plugin.finder.presenter.base.b paramb)
  {
    AppMethodBeat.i(289744);
    this.xms = paramb;
    this.xmr = new c(this);
    AppMethodBeat.o(289744);
  }
  
  public final void a(ViewGroup paramViewGroup, i parami, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(289741);
    p.k(paramViewGroup, "parent");
    p.k(parami, "holder");
    p.k(paramRecyclerView, "recylerView");
    if (!this.xmp)
    {
      Log.d(TAG, "changeToItemView:return");
      AppMethodBeat.o(289741);
      return;
    }
    this.xmp = false;
    Log.d(TAG, "changeToItemView,in");
    aa.f localf = new aa.f();
    localf.aaBC = ((FrameLayout)parami.RD(xmu));
    parami = new aa.f();
    FinderTagView.a locala = FinderTagView.BaE;
    parami.aaBC = paramViewGroup.findViewById(FinderTagView.ejl());
    if (((View)parami.aaBC == null) || ((FrameLayout)localf.aaBC == null) || (((FrameLayout)localf.aaBC).getChildCount() != 0))
    {
      Log.d(TAG, "changeToItemView:item has been add,return ");
      AppMethodBeat.o(289741);
      return;
    }
    paramRecyclerView.post((Runnable)new aj.b(paramViewGroup, parami, localf));
    AppMethodBeat.o(289741);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(289742);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.l)this.xmr);
    paramRecyclerView.a((RecyclerView.l)this.xmr);
    AppMethodBeat.o(289742);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(289739);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(289739);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(289743);
    p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    AppMethodBeat.o(289743);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_tag_item_dummy_holder_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onScrollStateChanged", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    private final int[] value;
    private final int[] xmy;
    
    c()
    {
      AppMethodBeat.i(268771);
      this.value = new int[2];
      this.xmy = new int[2];
      AppMethodBeat.o(268771);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(268770);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      a.c("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      paramRecyclerView = aj.xmv;
      Log.d(aj.access$getTAG$cp(), "newState:".concat(String.valueOf(paramInt)));
      aj localaj;
      if (paramInt == 2)
      {
        localaj = this.xmz;
        if (!localaj.xmp)
        {
          paramRecyclerView = localaj.xms.getRootView();
          localObject = FinderTagView.BaE;
          if (paramRecyclerView.findViewById(FinderTagView.ejl()) == null) {
            break label140;
          }
        }
        Log.d(aj.TAG, "chekToAddFLoatTagViewWhenFling:return");
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(268770);
        return;
        label140:
        Log.d(aj.TAG, "chekToAddFLoatTagViewWhenFling: ");
        localaj.xmp = true;
        paramRecyclerView = localaj.xmq;
        if (paramRecyclerView != null)
        {
          paramRecyclerView = paramRecyclerView.getParent();
          localObject = paramRecyclerView;
          if (!(paramRecyclerView instanceof ViewGroup)) {
            localObject = null;
          }
          paramRecyclerView = (ViewGroup)localObject;
          if (paramRecyclerView != null)
          {
            paramRecyclerView.removeView((View)localaj.xmq);
            paramRecyclerView = paramRecyclerView.getLayoutParams();
            localObject = localaj.xmq;
            if (localObject == null) {
              break label280;
            }
          }
        }
        label280:
        for (paramInt = ((FinderTagView)localObject).getHeight();; paramInt = -2)
        {
          paramRecyclerView.height = paramInt;
          paramRecyclerView = new FrameLayout.LayoutParams(-1, -2);
          paramRecyclerView.gravity = 48;
          localObject = localaj.xms.getRootView();
          if (localObject != null) {
            break label286;
          }
          paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(268770);
          throw paramRecyclerView;
          paramRecyclerView = null;
          break;
        }
        label286:
        ((ViewGroup)localObject).addView((View)localaj.xmq, (ViewGroup.LayoutParams)paramRecyclerView);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(268769);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt2);
      a.c("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = aj.xmv;
      Object localObject2;
      Object localObject3;
      if (aj.dpD() > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(268769);
          throw paramRecyclerView;
        }
        localObject2 = (StaggeredGridLayoutManager)localObject1;
        localObject1 = new int[((StaggeredGridLayoutManager)localObject2).ku()];
        ((StaggeredGridLayoutManager)localObject2).k((int[])localObject1);
        localObject2 = aj.xmv;
        localObject2 = aj.access$getTAG$cp();
        localObject3 = new StringBuilder("visiablePosition:").append(localObject1[0]).append(",positionInListView:");
        aj.a locala = aj.xmv;
        Log.d((String)localObject2, aj.dpD());
        paramInt1 = localObject1[0];
        localObject1 = aj.xmv;
        if (paramInt1 != aj.dpD()) {
          break label598;
        }
        localObject1 = aj.xmv;
        localObject1 = paramRecyclerView.cK(aj.dpD());
        if (localObject1 == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(268769);
          throw paramRecyclerView;
        }
        localObject1 = (i)localObject1;
        ((i)localObject1).amk.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.xmy);
        if (this.xmy[1] - this.value[1] <= 0) {
          break label510;
        }
        paramRecyclerView = aj.xmv;
        Log.d(aj.access$getTAG$cp(), "changeToDecorView:entrace 1");
        localObject2 = this.xmz;
        paramRecyclerView = this.xmz.xms.getRootView();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(268769);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        p.k(paramRecyclerView, "parent");
        p.k(localObject1, "holder");
        if (!((aj)localObject2).xmp) {
          break label386;
        }
        Log.d(aj.TAG, "changeToDecorView:return");
      }
      label386:
      label598:
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(268769);
        return;
        ((aj)localObject2).xmp = true;
        Log.d(aj.TAG, "changeToDecorView,in");
        localObject2 = (FrameLayout)((i)localObject1).RD(aj.xmu);
        localObject3 = FinderTagView.BaE;
        localObject1 = ((i)localObject1).RD(FinderTagView.ejl());
        p.j(localObject1, "tagView");
        ((View)localObject1).setVisibility(4);
        p.j(localObject2, "tagViewContainer");
        ((FrameLayout)localObject2).getLayoutParams().height = ((View)localObject1).getHeight();
        ((FrameLayout)localObject2).removeView((View)localObject1);
        localObject2 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 48;
        paramRecyclerView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setVisibility(0);
        continue;
        label510:
        if (this.xmy[1] - this.value[1] <= 0)
        {
          localObject2 = aj.xmv;
          Log.d(aj.access$getTAG$cp(), "changeToItemView:entrace 1");
          localObject2 = this.xmz;
          localObject3 = this.xmz.xms.getRootView();
          if (localObject3 == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(268769);
            throw paramRecyclerView;
          }
          ((aj)localObject2).a((ViewGroup)localObject3, (i)localObject1, paramRecyclerView);
          continue;
          localObject1 = aj.xmv;
          localObject1 = paramRecyclerView.cK(aj.dpD());
          if (localObject1 != null)
          {
            if (localObject1 == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
              AppMethodBeat.o(268769);
              throw paramRecyclerView;
            }
            localObject1 = (i)localObject1;
            localObject2 = aj.xmv;
            Log.d(aj.access$getTAG$cp(), "changeToItemView:entrace 2");
            localObject2 = this.xmz;
            localObject3 = this.xmz.xms.getRootView();
            if (localObject3 == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(268769);
              throw paramRecyclerView;
            }
            ((aj)localObject2).a((ViewGroup)localObject3, (i)localObject1, paramRecyclerView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aj
 * JD-Core Version:    0.7.0.1
 */