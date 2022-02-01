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
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.view.FinderTagView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "viewCallBackTag", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "(Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;)V", "floatState", "", "getFloatState", "()Z", "setFloatState", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1;", "tagViewRef", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "getTagViewRef", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "setTagViewRef", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getViewCallBackTag", "()Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "changeToDecorView", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "changeToItemView", "recylerView", "Landroidx/recyclerview/widget/RecyclerView;", "chekToAddFLoatTagViewWhenFling", "getLayoutId", "", "onAttachedToRecyclerView", "recyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends f<com.tencent.mm.plugin.finder.model.j>
{
  public static final a AKF;
  private static int AKK;
  static int AKL;
  static String TAG;
  final com.tencent.mm.plugin.finder.presenter.base.b AKG;
  boolean AKH;
  FinderTagView AKI;
  private final b AKJ;
  
  static
  {
    AppMethodBeat.i(350272);
    AKF = new a((byte)0);
    AKK = -2;
    TAG = "Finder.FinderFeedTagsConvert";
    AKL = e.e.tag_layout_container;
    AppMethodBeat.o(350272);
  }
  
  public af(com.tencent.mm.plugin.finder.presenter.base.b paramb)
  {
    AppMethodBeat.i(350258);
    this.AKG = paramb;
    this.AKJ = new b(this);
    AppMethodBeat.o(350258);
  }
  
  private static final void a(ViewGroup paramViewGroup, ah.f paramf1, ah.f paramf2)
  {
    AppMethodBeat.i(350263);
    s.u(paramViewGroup, "$parent");
    s.u(paramf1, "$itemTagView");
    s.u(paramf2, "$tagViewContainer");
    paramViewGroup.removeView((View)paramf1.aqH);
    ((FrameLayout)paramf2.aqH).getLayoutParams().height = -2;
    paramViewGroup = new FrameLayout.LayoutParams(-1, -2);
    paramViewGroup.gravity = 48;
    ((FrameLayout)paramf2.aqH).addView((View)paramf1.aqH, (ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(350263);
  }
  
  public final void a(ViewGroup paramViewGroup, com.tencent.mm.view.recyclerview.j paramj, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350290);
    s.u(paramViewGroup, "parent");
    s.u(paramj, "holder");
    s.u(paramRecyclerView, "recylerView");
    if (!this.AKH)
    {
      Log.d(TAG, "changeToItemView:return");
      AppMethodBeat.o(350290);
      return;
    }
    this.AKH = false;
    Log.d(TAG, "changeToItemView,in");
    ah.f localf = new ah.f();
    localf.aqH = paramj.UH(AKL);
    paramj = new ah.f();
    FinderTagView.a locala = FinderTagView.GCE;
    paramj.aqH = paramViewGroup.findViewById(FinderTagView.flo());
    if ((paramj.aqH == null) || (localf.aqH == null) || (((FrameLayout)localf.aqH).getChildCount() != 0))
    {
      Log.d(TAG, "changeToItemView:item has been add,return ");
      AppMethodBeat.o(350290);
      return;
    }
    paramRecyclerView.post(new af..ExternalSyntheticLambda0(paramViewGroup, paramj, localf));
    AppMethodBeat.o(350290);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(350293);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.l)this.AKJ);
    paramRecyclerView.a((RecyclerView.l)this.AKJ);
    AppMethodBeat.o(350293);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350282);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350282);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350297);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    AppMethodBeat.o(350297);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_tag_item_dummy_holder_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$Companion;", "", "()V", "ITEM_CONTAINER_ID", "", "getITEM_CONTAINER_ID", "()I", "setITEM_CONTAINER_ID", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "positionInListView", "getPositionInListView", "setPositionInListView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onScrollStateChanged", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.l
  {
    private final int[] AKM;
    private final int[] value;
    
    b(af paramaf)
    {
      AppMethodBeat.i(349979);
      this.value = new int[2];
      this.AKM = new int[2];
      AppMethodBeat.o(349979);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(350006);
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      a.c("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      paramRecyclerView = af.AKF;
      Log.d(af.access$getTAG$cp(), s.X("newState:", Integer.valueOf(paramInt)));
      if (paramInt == 2)
      {
        localObject2 = this.AKN;
        if (!((af)localObject2).AKH)
        {
          paramRecyclerView = ((af)localObject2).AKG.getRootView();
          FinderTagView.a locala = FinderTagView.GCE;
          if (paramRecyclerView.findViewById(FinderTagView.flo()) == null) {}
        }
        else
        {
          Log.d(af.TAG, "chekToAddFLoatTagViewWhenFling:return");
        }
      }
      else
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(350006);
        return;
      }
      Log.d(af.TAG, "chekToAddFLoatTagViewWhenFling: ");
      ((af)localObject2).AKH = true;
      paramRecyclerView = ((af)localObject2).AKI;
      if (paramRecyclerView == null)
      {
        paramRecyclerView = null;
        label173:
        if ((paramRecyclerView instanceof ViewGroup)) {
          localObject1 = (ViewGroup)paramRecyclerView;
        }
        if (localObject1 != null)
        {
          ((ViewGroup)localObject1).removeView((View)((af)localObject2).AKI);
          paramRecyclerView = ((ViewGroup)localObject1).getLayoutParams();
          localObject1 = ((af)localObject2).AKI;
          if (localObject1 != null) {
            break label280;
          }
        }
      }
      label280:
      for (paramInt = -2;; paramInt = ((FinderTagView)localObject1).getHeight())
      {
        paramRecyclerView.height = paramInt;
        paramRecyclerView = new FrameLayout.LayoutParams(-1, -2);
        paramRecyclerView.gravity = 48;
        ((ViewGroup)((af)localObject2).AKG.getRootView()).addView((View)((af)localObject2).AKI, (ViewGroup.LayoutParams)paramRecyclerView);
        break;
        paramRecyclerView = paramRecyclerView.getParent();
        break label173;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(349996);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt2);
      a.c("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = af.AKF;
      Object localObject2;
      Object localObject3;
      if (af.dXI() > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(349996);
          throw paramRecyclerView;
        }
        localObject2 = (StaggeredGridLayoutManager)localObject1;
        localObject1 = new int[((StaggeredGridLayoutManager)localObject2).bWl];
        ((StaggeredGridLayoutManager)localObject2).n((int[])localObject1);
        localObject2 = af.AKF;
        localObject2 = af.access$getTAG$cp();
        localObject3 = new StringBuilder("visiablePosition:").append(localObject1[0]).append(",positionInListView:");
        af.a locala = af.AKF;
        Log.d((String)localObject2, af.dXI());
        paramInt1 = localObject1[0];
        localObject1 = af.AKF;
        if (paramInt1 != af.dXI()) {
          break label529;
        }
        localObject1 = af.AKF;
        localObject1 = paramRecyclerView.fU(af.dXI());
        if (localObject1 == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(349996);
          throw paramRecyclerView;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
        ((com.tencent.mm.view.recyclerview.j)localObject1).caK.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.AKM);
        if (this.AKM[1] - this.value[1] <= 0) {
          break label471;
        }
        paramRecyclerView = af.AKF;
        Log.d(af.access$getTAG$cp(), "changeToDecorView:entrace 1");
        localObject2 = this.AKN;
        paramRecyclerView = (ViewGroup)this.AKN.AKG.getRootView();
        s.u(paramRecyclerView, "parent");
        s.u(localObject1, "holder");
        if (!((af)localObject2).AKH) {
          break label363;
        }
        Log.d(af.TAG, "changeToDecorView:return");
      }
      label529:
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(349996);
        return;
        label363:
        ((af)localObject2).AKH = true;
        Log.d(af.TAG, "changeToDecorView,in");
        localObject2 = (FrameLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(af.AKL);
        localObject3 = FinderTagView.GCE;
        localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(FinderTagView.flo());
        ((View)localObject1).setVisibility(4);
        ((FrameLayout)localObject2).getLayoutParams().height = ((View)localObject1).getHeight();
        ((FrameLayout)localObject2).removeView((View)localObject1);
        localObject2 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 48;
        paramRecyclerView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setVisibility(0);
        continue;
        label471:
        if (this.AKM[1] - this.value[1] <= 0)
        {
          localObject2 = af.AKF;
          Log.d(af.access$getTAG$cp(), "changeToItemView:entrace 1");
          this.AKN.a((ViewGroup)this.AKN.AKG.getRootView(), (com.tencent.mm.view.recyclerview.j)localObject1, paramRecyclerView);
          continue;
          localObject1 = af.AKF;
          localObject2 = paramRecyclerView.fU(af.dXI());
          if (localObject2 != null)
          {
            localObject1 = this.AKN;
            if (localObject2 == null)
            {
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
              AppMethodBeat.o(349996);
              throw paramRecyclerView;
            }
            localObject2 = (com.tencent.mm.view.recyclerview.j)localObject2;
            localObject3 = af.AKF;
            Log.d(af.access$getTAG$cp(), "changeToItemView:entrace 2");
            ((af)localObject1).a((ViewGroup)((af)localObject1).AKG.getRootView(), (com.tencent.mm.view.recyclerview.j)localObject2, paramRecyclerView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.af
 * JD-Core Version:    0.7.0.1
 */