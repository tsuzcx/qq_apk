package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "viewCallBackTag", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "(Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;)V", "floatState", "", "getFloatState", "()Z", "setFloatState", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1;", "tagViewRef", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "getTagViewRef", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "setTagViewRef", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getViewCallBackTag", "()Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "changeToDecorView", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "changeToItemView", "recylerView", "Landroid/support/v7/widget/RecyclerView;", "chekToAddFLoatTagViewWhenFling", "getLayoutId", "", "onAttachedToRecyclerView", "recyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class ah
  extends e<j>
{
  static String TAG;
  private static int tDR;
  static int tDS;
  public static final a tDT;
  boolean tDN;
  FinderTagView tDO;
  private final c tDP;
  final com.tencent.mm.plugin.finder.presenter.base.b tDQ;
  
  static
  {
    AppMethodBeat.i(243107);
    tDT = new a((byte)0);
    tDR = -2;
    TAG = "Finder.FinderFeedTagsConvert";
    tDS = 2131308870;
    AppMethodBeat.o(243107);
  }
  
  public ah(com.tencent.mm.plugin.finder.presenter.base.b paramb)
  {
    AppMethodBeat.i(243106);
    this.tDQ = paramb;
    this.tDP = new c(this);
    AppMethodBeat.o(243106);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(243104);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.l)this.tDP);
    paramRecyclerView.a((RecyclerView.l)this.tDP);
    AppMethodBeat.o(243104);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243101);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(243101);
  }
  
  public final void a(ViewGroup paramViewGroup, final h paramh, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(243103);
    p.h(paramViewGroup, "parent");
    p.h(paramh, "holder");
    p.h(paramRecyclerView, "recylerView");
    if (!this.tDN)
    {
      Log.d(TAG, "changeToItemView:return");
      AppMethodBeat.o(243103);
      return;
    }
    this.tDN = false;
    Log.d(TAG, "changeToItemView,in");
    final z.f localf = new z.f();
    localf.SYG = ((FrameLayout)paramh.Mn(tDS));
    paramh = new z.f();
    FinderTagView.a locala = FinderTagView.wpv;
    paramh.SYG = paramViewGroup.findViewById(FinderTagView.dHk());
    if (((View)paramh.SYG == null) || ((FrameLayout)localf.SYG == null) || (((FrameLayout)localf.SYG).getChildCount() != 0))
    {
      Log.d(TAG, "changeToItemView:item has been add,return ");
      AppMethodBeat.o(243103);
      return;
    }
    paramRecyclerView.post((Runnable)new b(paramViewGroup, paramh, localf));
    AppMethodBeat.o(243103);
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(243105);
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    AppMethodBeat.o(243105);
  }
  
  public final int getLayoutId()
  {
    return 2131494646;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$Companion;", "", "()V", "ITEM_CONTAINER_ID", "", "getITEM_CONTAINER_ID", "()I", "setITEM_CONTAINER_ID", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "positionInListView", "getPositionInListView", "setPositionInListView", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ViewGroup paramViewGroup, z.f paramf1, z.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(243097);
      this.hVi.removeView((View)paramh.SYG);
      ((FrameLayout)localf.SYG).getLayoutParams().height = -2;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 48;
      ((FrameLayout)localf.SYG).addView((View)paramh.SYG, (ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(243097);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    private final int[] tDW;
    private final int[] value;
    
    c()
    {
      AppMethodBeat.i(243100);
      this.value = new int[2];
      this.tDW = new int[2];
      AppMethodBeat.o(243100);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(243099);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      paramRecyclerView = ah.tDT;
      Log.d(ah.access$getTAG$cp(), "newState:".concat(String.valueOf(paramInt)));
      ah localah;
      if (paramInt == 2)
      {
        localah = this.tDX;
        if (!localah.tDN)
        {
          paramRecyclerView = localah.tDQ.getRootView();
          localObject = FinderTagView.wpv;
          if (paramRecyclerView.findViewById(FinderTagView.dHk()) == null) {
            break label140;
          }
        }
        Log.d(ah.TAG, "chekToAddFLoatTagViewWhenFling:return");
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(243099);
        return;
        label140:
        Log.d(ah.TAG, "chekToAddFLoatTagViewWhenFling: ");
        localah.tDN = true;
        paramRecyclerView = localah.tDO;
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
            paramRecyclerView.removeView((View)localah.tDO);
            paramRecyclerView = paramRecyclerView.getLayoutParams();
            localObject = localah.tDO;
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
          localObject = localah.tDQ.getRootView();
          if (localObject != null) {
            break label286;
          }
          paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(243099);
          throw paramRecyclerView;
          paramRecyclerView = null;
          break;
        }
        label286:
        ((ViewGroup)localObject).addView((View)localah.tDO, (ViewGroup.LayoutParams)paramRecyclerView);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243098);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt2);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = ah.tDT;
      Object localObject2;
      Object localObject3;
      if (ah.cZH() > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(243098);
          throw paramRecyclerView;
        }
        localObject2 = (StaggeredGridLayoutManager)localObject1;
        localObject1 = new int[((StaggeredGridLayoutManager)localObject2).ki()];
        ((StaggeredGridLayoutManager)localObject2).n((int[])localObject1);
        localObject2 = ah.tDT;
        localObject2 = ah.access$getTAG$cp();
        localObject3 = new StringBuilder("visiablePosition:").append(localObject1[0]).append(",positionInListView:");
        ah.a locala = ah.tDT;
        Log.d((String)localObject2, ah.cZH());
        paramInt1 = localObject1[0];
        localObject1 = ah.tDT;
        if (paramInt1 != ah.cZH()) {
          break label598;
        }
        localObject1 = ah.tDT;
        localObject1 = paramRecyclerView.ch(ah.cZH());
        if (localObject1 == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(243098);
          throw paramRecyclerView;
        }
        localObject1 = (h)localObject1;
        ((h)localObject1).aus.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.tDW);
        if (this.tDW[1] - this.value[1] <= 0) {
          break label510;
        }
        paramRecyclerView = ah.tDT;
        Log.d(ah.access$getTAG$cp(), "changeToDecorView:entrace 1");
        localObject2 = this.tDX;
        paramRecyclerView = this.tDX.tDQ.getRootView();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(243098);
          throw paramRecyclerView;
        }
        paramRecyclerView = (ViewGroup)paramRecyclerView;
        p.h(paramRecyclerView, "parent");
        p.h(localObject1, "holder");
        if (!((ah)localObject2).tDN) {
          break label386;
        }
        Log.d(ah.TAG, "changeToDecorView:return");
      }
      label386:
      label598:
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(243098);
        return;
        ((ah)localObject2).tDN = true;
        Log.d(ah.TAG, "changeToDecorView,in");
        localObject2 = (FrameLayout)((h)localObject1).Mn(ah.tDS);
        localObject3 = FinderTagView.wpv;
        localObject1 = ((h)localObject1).Mn(FinderTagView.dHk());
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
        label510:
        if (this.tDW[1] - this.value[1] <= 0)
        {
          localObject2 = ah.tDT;
          Log.d(ah.access$getTAG$cp(), "changeToItemView:entrace 1");
          localObject2 = this.tDX;
          localObject3 = this.tDX.tDQ.getRootView();
          if (localObject3 == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(243098);
            throw paramRecyclerView;
          }
          ((ah)localObject2).a((ViewGroup)localObject3, (h)localObject1, paramRecyclerView);
          continue;
          localObject1 = ah.tDT;
          localObject1 = paramRecyclerView.ch(ah.cZH());
          if (localObject1 != null)
          {
            if (localObject1 == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
              AppMethodBeat.o(243098);
              throw paramRecyclerView;
            }
            localObject1 = (h)localObject1;
            localObject2 = ah.tDT;
            Log.d(ah.access$getTAG$cp(), "changeToItemView:entrace 2");
            localObject2 = this.tDX;
            localObject3 = this.tDX.tDQ.getRootView();
            if (localObject3 == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(243098);
              throw paramRecyclerView;
            }
            ((ah)localObject2).a((ViewGroup)localObject3, (h)localObject1, paramRecyclerView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ah
 * JD-Core Version:    0.7.0.1
 */