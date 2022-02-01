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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentItem", "hasInit", "", "outListener", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "pageChangeCallback", "scrollEventAdapter", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderScrollEventAdapter;", "getScrollState", "init", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "needNotify", "oldIndex", "currentIndex", "setPageChangeListener", "Companion", "OnPageChangeCallback", "plugin-finder-base_release"})
public class FinderRecyclerView
  extends WxRecyclerView
{
  public static final a xrz;
  private boolean hasInit;
  private b xrv;
  private int xrw;
  private a xrx;
  private final b xry;
  
  static
  {
    AppMethodBeat.i(258477);
    xrz = new a((byte)0);
    AppMethodBeat.o(258477);
  }
  
  public FinderRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(258474);
    this.xrw = -1;
    this.xry = ((b)new c(this));
    AppMethodBeat.o(258474);
  }
  
  public FinderRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(258476);
    this.xrw = -1;
    this.xry = ((b)new c(this));
    AppMethodBeat.o(258476);
  }
  
  public final void a(LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(258472);
    if (paramLinearLayoutManager == null)
    {
      Log.e("FinderRecyclerView", "init: params null");
      AppMethodBeat.o(258472);
      return;
    }
    setLayoutManager((RecyclerView.LayoutManager)paramLinearLayoutManager);
    this.xrx = new a((RecyclerView)this);
    paramLinearLayoutManager = this.xrx;
    if (paramLinearLayoutManager == null) {
      p.bGy("scrollEventAdapter");
    }
    paramLinearLayoutManager.xrB = this.xry;
    paramLinearLayoutManager = this.xrx;
    if (paramLinearLayoutManager == null) {
      p.bGy("scrollEventAdapter");
    }
    a((RecyclerView.l)paramLinearLayoutManager);
    this.hasInit = true;
    AppMethodBeat.o(258472);
  }
  
  public int getScrollState()
  {
    AppMethodBeat.i(258473);
    if (this.hasInit)
    {
      a locala = this.xrx;
      if (locala == null) {
        p.bGy("scrollEventAdapter");
      }
      i = locala.mScrollState;
      AppMethodBeat.o(258473);
      return i;
    }
    int i = super.getScrollState();
    AppMethodBeat.o(258473);
    return i;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.xrv = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$Companion;", "", "()V", "POSITION_FIRST", "", "POSITION_UNKNOWN", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "", "onPageScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder-base_release"})
  public static abstract interface b
  {
    public abstract void a(RecyclerView paramRecyclerView, int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void h(RecyclerView paramRecyclerView, int paramInt);
    
    public abstract void i(RecyclerView paramRecyclerView, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$pageChangeCallback$1", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "onPageScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder-base_release"})
  public static final class c
    implements FinderRecyclerView.b
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(259092);
      p.k(paramRecyclerView, "recyclerView");
      FinderRecyclerView.b localb = FinderRecyclerView.a(this.xrA);
      if (localb != null)
      {
        localb.a(paramRecyclerView, paramInt1, paramFloat, paramInt2);
        AppMethodBeat.o(259092);
        return;
      }
      AppMethodBeat.o(259092);
    }
    
    public final void h(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(259093);
      p.k(paramRecyclerView, "recyclerView");
      boolean bool = FinderRecyclerView.gz(FinderRecyclerView.b(this.xrA), paramInt);
      Log.i("FinderRecyclerView", "onPageSelected position:" + paramInt + ", currentItem:" + FinderRecyclerView.b(this.xrA) + ", needNotify:" + bool);
      if (FinderRecyclerView.b(this.xrA) != paramInt)
      {
        FinderRecyclerView.a(this.xrA, paramInt);
        if ((FinderRecyclerView.a(this.xrA) != null) && (bool))
        {
          FinderRecyclerView.b localb = FinderRecyclerView.a(this.xrA);
          if (localb != null)
          {
            localb.h(paramRecyclerView, paramInt);
            AppMethodBeat.o(259093);
            return;
          }
        }
      }
      AppMethodBeat.o(259093);
    }
    
    public final void i(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(259094);
      p.k(paramRecyclerView, "recyclerView");
      Log.i("FinderRecyclerView", "onPageScrollStateChanged state = ".concat(String.valueOf(paramInt)));
      FinderRecyclerView.b localb = FinderRecyclerView.a(this.xrA);
      if (localb != null)
      {
        localb.i(paramRecyclerView, paramInt);
        AppMethodBeat.o(259094);
        return;
      }
      AppMethodBeat.o(259094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView
 * JD-Core Version:    0.7.0.1
 */