package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/LinkedList;)V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishInserted", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMore", "isSmooth", "", "onPreFinishRefresh", "plugin-finder-base_release"})
public final class f<R extends k>
{
  private final LinkedList<j> viewCallbacks;
  
  public f(LinkedList<j> paramLinkedList)
  {
    AppMethodBeat.i(259646);
    this.viewCallbacks = paramLinkedList;
    AppMethodBeat.o(259646);
  }
  
  public final void MF(final int paramInt)
  {
    AppMethodBeat.i(259635);
    d.uiThread((a)new b(this, paramInt));
    AppMethodBeat.o(259635);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(259634);
    d.uiThread((a)new a(this));
    AppMethodBeat.o(259634);
  }
  
  public final void onItemRangeChanged(final int paramInt1, final int paramInt2, final Object paramObject)
  {
    AppMethodBeat.i(259636);
    d.uiThread((a)new c(this, paramInt1, paramInt2, paramObject));
    AppMethodBeat.o(259636);
  }
  
  public final void onItemRangeInserted(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(259637);
    d.uiThread((a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(259637);
  }
  
  public final void onItemRangeRemoved(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(259639);
    d.uiThread((a)new e(this, paramInt1, paramInt2));
    AppMethodBeat.o(259639);
  }
  
  public final void onPreFinishRefresh(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(259642);
    p.k(paramc, "reason");
    d.uiThread((a)new g(this, paramc));
    AppMethodBeat.o(259642);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(f paramf, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(f paramf, int paramInt1, int paramInt2, Object paramObject)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(f paramf, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(f paramf, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.f
 * JD-Core Version:    0.7.0.1
 */