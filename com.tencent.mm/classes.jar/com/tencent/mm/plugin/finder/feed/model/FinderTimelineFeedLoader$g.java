package com.tencent.mm.plugin.finder.feed.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$recyclerView$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
public final class FinderTimelineFeedLoader$g
  implements View.OnAttachStateChangeListener
{
  public FinderTimelineFeedLoader$g(RecyclerView paramRecyclerView) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(202947);
    p.h(paramView, "v");
    paramView = g.sKQ;
    Object localObject2 = this.skX.getAdapter();
    paramView = (View)localObject2;
    if (!(localObject2 instanceof WxRecyclerAdapter)) {
      paramView = null;
    }
    localObject2 = (WxRecyclerAdapter)paramView;
    paramView = localObject1;
    if (localObject2 != null) {
      paramView = ((WxRecyclerAdapter)localObject2).LSF;
    }
    g.c(paramView);
    AppMethodBeat.o(202947);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(202946);
    p.h(paramView, "v");
    paramView = g.sKQ;
    Object localObject2 = this.skX.getAdapter();
    paramView = (View)localObject2;
    if (!(localObject2 instanceof WxRecyclerAdapter)) {
      paramView = null;
    }
    localObject2 = (WxRecyclerAdapter)paramView;
    paramView = localObject1;
    if (localObject2 != null) {
      paramView = ((WxRecyclerAdapter)localObject2).LSF;
    }
    g.b(paramView);
    AppMethodBeat.o(202946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.g
 * JD-Core Version:    0.7.0.1
 */