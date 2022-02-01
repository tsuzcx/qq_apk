package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.view.h;
import com.tencent.mm.view.h.a;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "count", "", "currentIndex", "isShowOnlyOneIndicator", "", "onSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "sliderAdapter", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "getSliderAdapter", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "sliderLayoutManager", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "getSliderLayoutManager", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "setCount", "", "setCurrentIndex", "index", "setOnSelectedPageListener", "listener", "setShowOnlyOneIndicator", "isShow", "SliderAdapter", "SliderItemViewHolder", "SliderLayoutManager", "plugin-finder_release"})
public final class FinderMediaGestureIndicator
  extends RecyclerView
  implements h
{
  private h.a BeG;
  private boolean BeH;
  private final a BeJ;
  private final SliderLayoutManager BeK;
  private int count;
  private int currentIndex;
  
  public FinderMediaGestureIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272451);
    this.BeJ = new a();
    paramContext = getContext();
    kotlin.g.b.p.j(paramContext, "context");
    this.BeK = new SliderLayoutManager(paramContext);
    setAdapter((RecyclerView.a)this.BeJ);
    setLayoutManager((RecyclerView.LayoutManager)this.BeK);
    setHasFixedSize(true);
    setClipToPadding(false);
    this.BeH = true;
    AppMethodBeat.o(272451);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public final h.a getOnSelectedPageListener()
  {
    return this.BeG;
  }
  
  public final a getSliderAdapter()
  {
    return this.BeJ;
  }
  
  public final SliderLayoutManager getSliderLayoutManager()
  {
    return this.BeK;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final void setCount(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(272448);
    this.count = paramInt;
    setCurrentIndex(0);
    ArrayList localArrayList = new ArrayList();
    while (i < paramInt)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    a locala = this.BeJ;
    kotlin.g.b.p.k(localArrayList, "data");
    locala.data.clear();
    locala.data.addAll((Collection)localArrayList);
    locala.notifyDataSetChanged();
    AppMethodBeat.o(272448);
  }
  
  public final void setCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(272449);
    int i = this.currentIndex;
    this.BeJ.cL(i);
    this.currentIndex = paramInt;
    this.BeJ.currentIndex = paramInt;
    this.BeJ.cL(paramInt);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(i + (paramInt - i), new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(this, locala.aFh(), "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator", "setCurrentIndex", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator", "setCurrentIndex", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(272449);
  }
  
  public final void setOnSelectedPageListener(h.a parama)
  {
    AppMethodBeat.i(272450);
    kotlin.g.b.p.k(parama, "listener");
    this.BeG = parama;
    AppMethodBeat.o(272450);
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.BeH = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;", "setCallback", "(Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "getRecyclerViewCenterX", "", "onAttachedToWindow", "", "view", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onScrollStateChanged", "scaleDownView", "scrollHorizontallyBy", "dx", "smoothScrollToPosition", "position", "OnItemSelectedListener", "plugin-finder_release"})
  public static final class SliderLayoutManager
    extends LinearLayoutManager
  {
    float BdV;
    private RecyclerView jLl;
    
    public SliderLayoutManager(Context paramContext)
    {
      AppMethodBeat.i(287300);
      setOrientation(0);
      this.BdV = 50.0F;
      AppMethodBeat.o(287300);
    }
    
    private final void ejJ()
    {
      AppMethodBeat.i(287298);
      float f1 = getWidth() / 2.0F;
      int i = 0;
      int j = getChildCount();
      while (i < j)
      {
        View localView = getChildAt(i);
        if (localView == null) {
          kotlin.g.b.p.iCn();
        }
        kotlin.g.b.p.j(localView, "getChildAt(i)!!");
        float f2 = 1.0F - (float)Math.sqrt(Math.abs(f1 - (getDecoratedLeft(localView) + getDecoratedRight(localView)) / 2.0F) / getWidth()) * 0.66F;
        localView.setScaleX(f2);
        localView.setScaleY(f2);
        i += 1;
      }
      AppMethodBeat.o(287298);
    }
    
    public final void onAttachedToWindow(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(287294);
      super.onAttachedToWindow(paramRecyclerView);
      if (paramRecyclerView == null) {
        kotlin.g.b.p.iCn();
      }
      this.jLl = paramRecyclerView;
      paramRecyclerView = new q();
      RecyclerView localRecyclerView = this.jLl;
      if (localRecyclerView == null) {
        kotlin.g.b.p.bGy("recyclerView");
      }
      paramRecyclerView.a(localRecyclerView);
      AppMethodBeat.o(287294);
    }
    
    public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
    {
      AppMethodBeat.i(287295);
      kotlin.g.b.p.k(params, "state");
      super.onLayoutChildren(paramn, params);
      ejJ();
      AppMethodBeat.o(287295);
    }
    
    public final void onScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(287299);
      super.onScrollStateChanged(paramInt);
      int i;
      if (paramInt == 0)
      {
        Object localObject = this.jLl;
        if (localObject == null) {
          kotlin.g.b.p.bGy("recyclerView");
        }
        paramInt = ((RecyclerView)localObject).getRight();
        localObject = this.jLl;
        if (localObject == null) {
          kotlin.g.b.p.bGy("recyclerView");
        }
        int k = (paramInt - ((RecyclerView)localObject).getLeft()) / 2;
        localObject = this.jLl;
        if (localObject == null) {
          kotlin.g.b.p.bGy("recyclerView");
        }
        int m = ((RecyclerView)localObject).getLeft();
        paramInt = 2147483647;
        localObject = this.jLl;
        if (localObject == null) {
          kotlin.g.b.p.bGy("recyclerView");
        }
        int n = ((RecyclerView)localObject).getChildCount();
        i = 0;
        if (i < n)
        {
          localObject = this.jLl;
          if (localObject == null) {
            kotlin.g.b.p.bGy("recyclerView");
          }
          localObject = ((RecyclerView)localObject).getChildAt(i);
          int j = Math.abs(getDecoratedLeft((View)localObject) + (getDecoratedRight((View)localObject) - getDecoratedLeft((View)localObject)) / 2 - (k + m));
          if (j >= paramInt) {
            break label214;
          }
          if (this.jLl == null) {
            kotlin.g.b.p.bGy("recyclerView");
          }
          RecyclerView.bi((View)localObject);
          paramInt = j;
        }
      }
      label214:
      for (;;)
      {
        i += 1;
        break;
        AppMethodBeat.o(287299);
        return;
      }
    }
    
    public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
    {
      AppMethodBeat.i(287297);
      if (getOrientation() == 0)
      {
        paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
        ejJ();
        AppMethodBeat.o(287297);
        return paramInt;
      }
      AppMethodBeat.o(287297);
      return 0;
    }
    
    public final void smoothScrollToPosition(final RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
    {
      AppMethodBeat.i(287296);
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      paramRecyclerView = new a(this, paramRecyclerView, paramRecyclerView.getContext());
      paramRecyclerView.cV(paramInt);
      startSmoothScroll((RecyclerView.r)paramRecyclerView);
      AppMethodBeat.o(287296);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
    public static final class a
      extends androidx.recyclerview.widget.p
    {
      a(RecyclerView paramRecyclerView, Context paramContext)
      {
        super();
      }
      
      public final float a(DisplayMetrics paramDisplayMetrics)
      {
        AppMethodBeat.i(291082);
        kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
        float f = this.BeP.BdV / paramDisplayMetrics.densityDpi;
        AppMethodBeat.o(291082);
        return f;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderItemViewHolder;", "()V", "callback", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;)V", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "Callback", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.a<FinderMediaGestureIndicator.b>
  {
    a BeL;
    int currentIndex;
    final ArrayList<Integer> data;
    
    public a()
    {
      AppMethodBeat.i(286281);
      this.data = new ArrayList();
      AppMethodBeat.o(286281);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(286279);
      int i = this.data.size();
      AppMethodBeat.o(286279);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "", "onItemClicked", "", "view", "Landroid/view/View;", "index", "", "plugin-finder_release"})
    public static abstract interface a {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(FinderMediaGestureIndicator.a parama, FinderMediaGestureIndicator.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(279385);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.BeM.BeL != null) {
          kotlin.g.b.p.j(this.BeN.amk, "holder.itemView");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279385);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "circleView", "Landroid/widget/ImageView;", "getCircleView", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.v
  {
    final ImageView BeO;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(287951);
      this.BeO = ((ImageView)paramView.findViewById(b.f.circle));
      AppMethodBeat.o(287951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator
 * JD-Core Version:    0.7.0.1
 */