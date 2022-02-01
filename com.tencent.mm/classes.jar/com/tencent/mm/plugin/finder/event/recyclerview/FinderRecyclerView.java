package com.tencent.mm.plugin.finder.event.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentItem", "hasInit", "", "outListener", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "pageChangeCallback", "scrollEventAdapter", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter;", "getScrollEventAdapter", "()Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter;", "setScrollEventAdapter", "(Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter;)V", "getScrollState", "init", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "needNotify", "oldIndex", "currentIndex", "setPageChangeListener", "Companion", "OnPageChangeCallback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderRecyclerView
  extends WxRecyclerView
{
  public static final FinderRecyclerView.a AOF;
  private b AOG;
  private int AOH;
  public b AOI;
  private final b AOJ;
  private boolean hasInit;
  
  static
  {
    AppMethodBeat.i(330418);
    AOF = new FinderRecyclerView.a((byte)0);
    AppMethodBeat.o(330418);
  }
  
  public FinderRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(330393);
    this.AOH = -1;
    this.AOJ = ((b)new c(this));
    AppMethodBeat.o(330393);
  }
  
  public FinderRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(330396);
    this.AOH = -1;
    this.AOJ = ((b)new c(this));
    AppMethodBeat.o(330396);
  }
  
  public final void a(LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(330451);
    if (paramLinearLayoutManager == null)
    {
      Log.e("FinderRecyclerView", "init: params null");
      AppMethodBeat.o(330451);
      return;
    }
    if (this.AOI != null)
    {
      Log.w("FinderRecyclerView", "init: scrollEventAdapter has init");
      AppMethodBeat.o(330451);
      return;
    }
    setLayoutManager((RecyclerView.LayoutManager)paramLinearLayoutManager);
    setScrollEventAdapter(new b((RecyclerView)this));
    getScrollEventAdapter().AOM = this.AOJ;
    a((RecyclerView.l)getScrollEventAdapter());
    this.hasInit = true;
    AppMethodBeat.o(330451);
  }
  
  public final b getScrollEventAdapter()
  {
    AppMethodBeat.i(330432);
    b localb = this.AOI;
    if (localb != null)
    {
      AppMethodBeat.o(330432);
      return localb;
    }
    s.bIx("scrollEventAdapter");
    AppMethodBeat.o(330432);
    return null;
  }
  
  public int getScrollState()
  {
    AppMethodBeat.i(330460);
    if (this.hasInit)
    {
      i = getScrollEventAdapter().mScrollState;
      AppMethodBeat.o(330460);
      return i;
    }
    int i = super.getScrollState();
    AppMethodBeat.o(330460);
    return i;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.AOG = paramb;
  }
  
  public final void setScrollEventAdapter(b paramb)
  {
    AppMethodBeat.i(330442);
    s.u(paramb, "<set-?>");
    this.AOI = paramb;
    AppMethodBeat.o(330442);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "", "onPageScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(RecyclerView paramRecyclerView, int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void j(RecyclerView paramRecyclerView, int paramInt);
    
    public abstract void k(RecyclerView paramRecyclerView, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$pageChangeCallback$1", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "onPageScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements FinderRecyclerView.b
  {
    c(FinderRecyclerView paramFinderRecyclerView) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(330376);
      s.u(paramRecyclerView, "recyclerView");
      FinderRecyclerView.b localb = FinderRecyclerView.a(this.AOK);
      if (localb != null) {
        localb.a(paramRecyclerView, paramInt1, paramFloat, paramInt2);
      }
      AppMethodBeat.o(330376);
    }
    
    public final void j(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(330388);
      s.u(paramRecyclerView, "recyclerView");
      boolean bool = FinderRecyclerView.hr(FinderRecyclerView.b(this.AOK), paramInt);
      Log.i("FinderRecyclerView", "onPageSelected position:" + paramInt + ", currentItem:" + FinderRecyclerView.b(this.AOK) + ", needNotify:" + bool);
      if (FinderRecyclerView.b(this.AOK) != paramInt)
      {
        FinderRecyclerView.a(this.AOK, paramInt);
        if ((FinderRecyclerView.a(this.AOK) != null) && (bool))
        {
          FinderRecyclerView.b localb = FinderRecyclerView.a(this.AOK);
          if (localb != null) {
            localb.j(paramRecyclerView, paramInt);
          }
        }
      }
      AppMethodBeat.o(330388);
    }
    
    public final void k(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(330394);
      s.u(paramRecyclerView, "recyclerView");
      Log.i("FinderRecyclerView", s.X("onPageScrollStateChanged state = ", Integer.valueOf(paramInt)));
      FinderRecyclerView.b localb = FinderRecyclerView.a(this.AOK);
      if (localb != null) {
        localb.k(paramRecyclerView, paramInt);
      }
      AppMethodBeat.o(330394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView
 * JD-Core Version:    0.7.0.1
 */