package com.tencent.mm.plugin.finder.event;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.event.base.h;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/FinderEventSubscribers;", "Lcom/tencent/mm/plugin/finder/event/base/MultiEventSubscriber;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "dataChangeEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/DataChangeEventSubscriber;", "getDataChangeEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/base/DataChangeEventSubscriber;", "playEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "getPlayEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "scrollEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "register", "", "plugin-finder_release"})
public final class a
  extends h
{
  final RecyclerView fPw;
  private final com.tencent.mm.plugin.finder.event.base.j qrX;
  public final b qrY;
  public final com.tencent.mm.plugin.finder.event.base.b qrZ;
  
  public a(RecyclerView paramRecyclerView, d paramd)
  {
    super(paramd);
    AppMethodBeat.i(178137);
    this.fPw = paramRecyclerView;
    this.qrX = new com.tencent.mm.plugin.finder.event.base.j();
    this.qrY = new b();
    this.qrZ = new com.tencent.mm.plugin.finder.event.base.b(paramd, this.fPw);
    AppMethodBeat.o(178137);
  }
  
  public final void Bu()
  {
    AppMethodBeat.i(165512);
    this.qrX.v(this.fPw);
    Object localObject = this.fPw.getAdapter();
    if (localObject != null)
    {
      ((RecyclerView.a)localObject).a(this.qrZ.cle());
      if (localObject != null) {}
    }
    else
    {
      localObject = (a)this;
      ((a)localObject).fPw.addOnLayoutChangeListener((View.OnLayoutChangeListener)new a((a)localObject));
      localObject = y.JfV;
    }
    localObject = new g[3];
    localObject[0] = ((g)this.qrX);
    localObject[1] = ((g)this.qrY);
    localObject[2] = ((g)this.qrZ);
    k.h(localObject, "subscribes");
    int i = 0;
    while (i < 3)
    {
      localObject[i].qsx = this.qsz;
      i += 1;
    }
    d.a.j.addAll((Collection)this.qsy, (Object[])localObject);
    AppMethodBeat.o(165512);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/event/FinderEventSubscribers$register$2$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class a
    implements View.OnLayoutChangeListener
  {
    a(a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(165511);
      this.qsa.fPw.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramView = this.qsa.fPw.getAdapter();
      if (paramView == null) {
        k.fvU();
      }
      paramView.a(this.qsa.qrZ.cle());
      this.qsa.qrZ.cle().onChanged();
      AppMethodBeat.o(165511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.a
 * JD-Core Version:    0.7.0.1
 */