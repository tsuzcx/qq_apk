package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/LinkedList;)V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishInserted", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMore", "onPreFinishRefresh", "plugin-finder_release"})
public final class d<R extends i>
{
  final LinkedList<com.tencent.mm.view.d> viewCallbacks;
  
  public d(LinkedList<com.tencent.mm.view.d> paramLinkedList)
  {
    AppMethodBeat.i(202580);
    this.viewCallbacks = paramLinkedList;
    AppMethodBeat.o(202580);
  }
  
  public final void au(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(202576);
    c.g((a)new c(this, paramInt1, paramInt2));
    AppMethodBeat.o(202576);
  }
  
  public final void av(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(202577);
    c.g((a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(202577);
  }
  
  public final void c(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202578);
    p.h(paramc, "reason");
    c.g((a)new f(this, paramc));
    AppMethodBeat.o(202578);
  }
  
  public final void f(final int paramInt1, final int paramInt2, final Object paramObject)
  {
    AppMethodBeat.i(202575);
    c.g((a)new b(this, paramInt1, paramInt2, paramObject));
    AppMethodBeat.o(202575);
  }
  
  public final void i(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202579);
    p.h(paramc, "reason");
    c.g((a)new e(this, paramc));
    AppMethodBeat.o(202579);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(202574);
    c.g((a)new a(this));
    AppMethodBeat.o(202574);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(d paramd, int paramInt1, int paramInt2, Object paramObject)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(d paramd, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(d paramd, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(d paramd, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class f
    extends q
    implements a<z>
  {
    f(d paramd, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.d
 * JD-Core Version:    0.7.0.1
 */