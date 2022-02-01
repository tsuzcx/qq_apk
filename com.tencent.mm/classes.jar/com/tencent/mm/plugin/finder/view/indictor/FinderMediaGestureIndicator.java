package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.view.h;
import com.tencent.mm.view.h.a;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator;", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "count", "", "currentIndex", "isShowOnlyOneIndicator", "", "onSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "sliderAdapter", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "getSliderAdapter", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "sliderLayoutManager", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "getSliderLayoutManager", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "setCount", "", "setCurrentIndex", "index", "setOnSelectedPageListener", "listener", "setShowOnlyOneIndicator", "isShow", "SliderAdapter", "SliderItemViewHolder", "SliderLayoutManager", "plugin-finder_release"})
public final class FinderMediaGestureIndicator
  extends RecyclerView
  implements h
{
  private int count;
  private int currentIndex;
  private h.a wso;
  private boolean wsp;
  private final a wsr;
  private final FinderMediaGestureIndicator.SliderLayoutManager wss;
  
  public FinderMediaGestureIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255241);
    this.wsr = new a();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.wss = new FinderMediaGestureIndicator.SliderLayoutManager(paramContext);
    setAdapter((RecyclerView.a)this.wsr);
    setLayoutManager((RecyclerView.LayoutManager)this.wss);
    setHasFixedSize(true);
    setClipToPadding(false);
    this.wsp = true;
    AppMethodBeat.o(255241);
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
    return this.wso;
  }
  
  public final a getSliderAdapter()
  {
    return this.wsr;
  }
  
  public final FinderMediaGestureIndicator.SliderLayoutManager getSliderLayoutManager()
  {
    return this.wss;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final void setCount(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(255238);
    this.count = paramInt;
    setCurrentIndex(0);
    ArrayList localArrayList = new ArrayList();
    while (i < paramInt)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    a locala = this.wsr;
    p.h(localArrayList, "data");
    locala.data.clear();
    locala.data.addAll((Collection)localArrayList);
    locala.notifyDataSetChanged();
    AppMethodBeat.o(255238);
  }
  
  public final void setCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(255239);
    int i = this.currentIndex;
    this.wsr.ci(i);
    this.currentIndex = paramInt;
    this.wsr.currentIndex = paramInt;
    this.wsr.ci(paramInt);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(i + (paramInt - i), new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(this, locala.axQ(), "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator", "setCurrentIndex", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator", "setCurrentIndex", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(255239);
  }
  
  public final void setOnSelectedPageListener(h.a parama)
  {
    AppMethodBeat.i(255240);
    p.h(parama, "listener");
    this.wso = parama;
    AppMethodBeat.o(255240);
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.wsp = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderItemViewHolder;", "()V", "callback", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;)V", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "Callback", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.a<FinderMediaGestureIndicator.b>
  {
    int currentIndex;
    final ArrayList<Integer> data;
    a wst;
    
    public a()
    {
      AppMethodBeat.i(255228);
      this.data = new ArrayList();
      AppMethodBeat.o(255228);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(255226);
      int i = this.data.size();
      AppMethodBeat.o(255226);
      return i;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "", "onItemClicked", "", "view", "Landroid/view/View;", "index", "", "plugin-finder_release"})
    public static abstract interface a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(FinderMediaGestureIndicator.a parama, FinderMediaGestureIndicator.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(255224);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.wsu.wst != null) {
          p.g(this.wsv.aus, "holder.itemView");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255224);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "circleView", "Landroid/widget/ImageView;", "getCircleView", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.v
  {
    final ImageView wsw;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(255229);
      this.wsw = ((ImageView)paramView.findViewById(2131298729));
      AppMethodBeat.o(255229);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator
 * JD-Core Version:    0.7.0.1
 */