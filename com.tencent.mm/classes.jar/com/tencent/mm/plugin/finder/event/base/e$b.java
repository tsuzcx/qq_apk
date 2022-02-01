package com.tencent.mm.plugin.finder.event.base;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$onBindRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"})
public final class e$b
  implements RecyclerView.j
{
  private boolean isFirst = true;
  
  e$b(RecyclerView paramRecyclerView) {}
  
  public final void bQ(View paramView)
  {
    AppMethodBeat.i(197539);
    k.h(paramView, "view");
    if (this.isFirst)
    {
      this.isFirst = false;
      this.qrn.post((Runnable)new a(this));
    }
    AppMethodBeat.o(197539);
  }
  
  public final void bR(View paramView)
  {
    AppMethodBeat.i(197538);
    k.h(paramView, "view");
    AppMethodBeat.o(197538);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(e.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(197537);
      this.KMg.KMf.fSD().b(this.KMg.qrn, 4);
      AppMethodBeat.o(197537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.e.b
 * JD-Core Version:    0.7.0.1
 */