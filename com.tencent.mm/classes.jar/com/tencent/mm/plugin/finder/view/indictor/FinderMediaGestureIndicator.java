package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.view.i;
import com.tencent.mm.view.i.a;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "count", "", "currentIndex", "isShowOnlyOneIndicator", "", "onSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "sliderAdapter", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "getSliderAdapter", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "sliderLayoutManager", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "getSliderLayoutManager", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "setCount", "", "setCurrentIndex", "index", "setOnSelectedPageListener", "listener", "setShowOnlyOneIndicator", "isShow", "SliderAdapter", "SliderItemViewHolder", "SliderLayoutManager", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMediaGestureIndicator
  extends RecyclerView
  implements i
{
  private i.a GHm;
  private boolean GHn;
  private final a GHp;
  private final SliderLayoutManager GHq;
  private int count;
  private int currentIndex;
  
  public FinderMediaGestureIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345498);
    this.GHp = new a();
    paramContext = getContext();
    s.s(paramContext, "context");
    this.GHq = new SliderLayoutManager(paramContext);
    setAdapter((RecyclerView.a)this.GHp);
    setLayoutManager((RecyclerView.LayoutManager)this.GHq);
    setHasFixedSize(true);
    setClipToPadding(false);
    this.GHn = true;
    AppMethodBeat.o(345498);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public final i.a getOnSelectedPageListener()
  {
    return this.GHm;
  }
  
  public final a getSliderAdapter()
  {
    return this.GHp;
  }
  
  public final SliderLayoutManager getSliderLayoutManager()
  {
    return this.GHq;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final void setCount(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(345524);
    this.count = paramInt;
    setCurrentIndex(0);
    ArrayList localArrayList = new ArrayList();
    if (paramInt > 0) {}
    for (;;)
    {
      int j = i + 1;
      localArrayList.add(Integer.valueOf(i));
      if (j >= paramInt)
      {
        a locala = this.GHp;
        s.u(localArrayList, "data");
        locala.data.clear();
        locala.data.addAll((Collection)localArrayList);
        locala.bZE.notifyChanged();
        AppMethodBeat.o(345524);
        return;
      }
      i = j;
    }
  }
  
  public final void setCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(345532);
    int i = this.currentIndex;
    this.GHp.fV(i);
    this.currentIndex = paramInt;
    this.GHp.currentIndex = paramInt;
    this.GHp.fV(paramInt);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(i + (paramInt - i), new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(this, locala.aYi(), "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator", "setCurrentIndex", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator", "setCurrentIndex", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(345532);
  }
  
  public final void setOnSelectedPageListener(i.a parama)
  {
    AppMethodBeat.i(345548);
    s.u(parama, "listener");
    this.GHm = parama;
    AppMethodBeat.o(345548);
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.GHn = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;", "setCallback", "(Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "getRecyclerViewCenterX", "", "onAttachedToWindow", "", "view", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onScrollStateChanged", "scaleDownView", "scrollHorizontallyBy", "dx", "smoothScrollToPosition", "position", "OnItemSelectedListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class SliderLayoutManager
    extends LinearLayoutManager
  {
    float GGx;
    private RecyclerView mkw;
    
    public SliderLayoutManager(Context paramContext)
    {
      AppMethodBeat.i(345479);
      setOrientation(0);
      this.GGx = 50.0F;
      AppMethodBeat.o(345479);
    }
    
    private final void flW()
    {
      AppMethodBeat.i(345487);
      float f1 = getWidth() / 2.0F;
      int i = 0;
      int k = getChildCount();
      if (k > 0) {}
      for (;;)
      {
        int j = i + 1;
        View localView = getChildAt(i);
        s.checkNotNull(localView);
        s.s(localView, "getChildAt(i)!!");
        float f2 = 1.0F - (float)Math.sqrt(Math.abs(f1 - (getDecoratedLeft(localView) + getDecoratedRight(localView)) / 2.0F) / getWidth()) * 0.66F;
        localView.setScaleX(f2);
        localView.setScaleY(f2);
        if (j >= k)
        {
          AppMethodBeat.o(345487);
          return;
        }
        i = j;
      }
    }
    
    public final void onAttachedToWindow(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(345493);
      super.onAttachedToWindow(paramRecyclerView);
      s.checkNotNull(paramRecyclerView);
      this.mkw = paramRecyclerView;
      p localp = new p();
      RecyclerView localRecyclerView = this.mkw;
      paramRecyclerView = localRecyclerView;
      if (localRecyclerView == null)
      {
        s.bIx("recyclerView");
        paramRecyclerView = null;
      }
      localp.a(paramRecyclerView);
      AppMethodBeat.o(345493);
    }
    
    public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
    {
      AppMethodBeat.i(345501);
      s.u(params, "state");
      super.onLayoutChildren(paramn, params);
      flW();
      AppMethodBeat.o(345501);
    }
    
    public final void onScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(345523);
      super.onScrollStateChanged(paramInt);
      int i;
      int n;
      int j;
      if (paramInt == 0)
      {
        RecyclerView localRecyclerView = this.mkw;
        Object localObject = localRecyclerView;
        if (localRecyclerView == null)
        {
          s.bIx("recyclerView");
          localObject = null;
        }
        paramInt = ((RecyclerView)localObject).getRight();
        localRecyclerView = this.mkw;
        localObject = localRecyclerView;
        if (localRecyclerView == null)
        {
          s.bIx("recyclerView");
          localObject = null;
        }
        int k = (paramInt - ((RecyclerView)localObject).getLeft()) / 2;
        localRecyclerView = this.mkw;
        localObject = localRecyclerView;
        if (localRecyclerView == null)
        {
          s.bIx("recyclerView");
          localObject = null;
        }
        int m = ((RecyclerView)localObject).getLeft();
        i = 0;
        localRecyclerView = this.mkw;
        localObject = localRecyclerView;
        if (localRecyclerView == null)
        {
          s.bIx("recyclerView");
          localObject = null;
        }
        n = ((RecyclerView)localObject).getChildCount();
        if (n > 0)
        {
          paramInt = 2147483647;
          j = i + 1;
          localRecyclerView = this.mkw;
          localObject = localRecyclerView;
          if (localRecyclerView == null)
          {
            s.bIx("recyclerView");
            localObject = null;
          }
          localObject = ((RecyclerView)localObject).getChildAt(i);
          i = Math.abs(getDecoratedLeft((View)localObject) + (getDecoratedRight((View)localObject) - getDecoratedLeft((View)localObject)) / 2 - (k + m));
          if (i >= paramInt) {
            break label256;
          }
          if (this.mkw == null) {
            s.bIx("recyclerView");
          }
          RecyclerView.bB((View)localObject);
          paramInt = i;
        }
      }
      label256:
      for (;;)
      {
        if (j >= n)
        {
          AppMethodBeat.o(345523);
          return;
        }
        i = j;
        break;
      }
    }
    
    public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
    {
      AppMethodBeat.i(345515);
      if (getOrientation() == 0)
      {
        paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
        flW();
        AppMethodBeat.o(345515);
        return paramInt;
      }
      AppMethodBeat.o(345515);
      return 0;
    }
    
    public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
    {
      AppMethodBeat.i(345510);
      s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = new a(this, paramRecyclerView.getContext());
      paramRecyclerView.cag = paramInt;
      startSmoothScroll((RecyclerView.r)paramRecyclerView);
      AppMethodBeat.o(345510);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends o
    {
      a(FinderMediaGestureIndicator.SliderLayoutManager paramSliderLayoutManager, Context paramContext)
      {
        super();
      }
      
      public final float c(DisplayMetrics paramDisplayMetrics)
      {
        AppMethodBeat.i(345502);
        s.u(paramDisplayMetrics, "displayMetrics");
        float f = this.GHt.GGx / paramDisplayMetrics.densityDpi;
        AppMethodBeat.o(345502);
        return f;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderItemViewHolder;", "()V", "callback", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;)V", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "Callback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.a<FinderMediaGestureIndicator.b>
  {
    private FinderMediaGestureIndicator.a.a GHr;
    int currentIndex;
    final ArrayList<Integer> data;
    
    public a()
    {
      AppMethodBeat.i(345483);
      this.data = new ArrayList();
      AppMethodBeat.o(345483);
    }
    
    private static final void a(a parama, FinderMediaGestureIndicator.b paramb, int paramInt, View paramView)
    {
      AppMethodBeat.i(345489);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parama);
      localb.cH(paramb);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(paramb, "$holder");
      if (parama.GHr != null) {
        s.s(paramb.caK, "holder.itemView");
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345489);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(345503);
      int i = this.data.size();
      AppMethodBeat.o(345503);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "circleView", "Landroid/widget/ImageView;", "getCircleView", "()Landroid/widget/ImageView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.v
  {
    final ImageView GHs;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(345478);
      this.GHs = ((ImageView)paramView.findViewById(e.e.circle));
      AppMethodBeat.o(345478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator
 * JD-Core Version:    0.7.0.1
 */