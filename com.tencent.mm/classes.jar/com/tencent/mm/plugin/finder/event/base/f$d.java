package com.tencent.mm.plugin.finder.event.base;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.j;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$onBindRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"})
public final class f$d
  implements RecyclerView.j
{
  private boolean isFirst = true;
  
  f$d(RecyclerView paramRecyclerView) {}
  
  public final void bQ(View paramView)
  {
    AppMethodBeat.i(201420);
    k.h(paramView, "view");
    if (this.isFirst)
    {
      this.isFirst = false;
      this.rbu.post((Runnable)new f.d.a(this));
    }
    AppMethodBeat.o(201420);
  }
  
  public final void bR(View paramView)
  {
    AppMethodBeat.i(201419);
    k.h(paramView, "view");
    AppMethodBeat.o(201419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f.d
 * JD-Core Version:    0.7.0.1
 */