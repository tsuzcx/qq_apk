package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/LinkedList;)V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishInserted", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMore", "isSmooth", "", "onPreFinishRefresh", "plugin-finder_release"})
public final class d<R extends i>
{
  final LinkedList<j> viewCallbacks;
  
  public d(LinkedList<j> paramLinkedList)
  {
    AppMethodBeat.i(245021);
    this.viewCallbacks = paramLinkedList;
    AppMethodBeat.o(245021);
  }
  
  public final void IN(final int paramInt)
  {
    AppMethodBeat.i(245015);
    com.tencent.mm.ac.d.h((a)new b(this, paramInt));
    AppMethodBeat.o(245015);
  }
  
  public final void f(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(245020);
    p.h(paramc, "reason");
    com.tencent.mm.ac.d.h((a)new f(this, true, paramc));
    AppMethodBeat.o(245020);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(245014);
    com.tencent.mm.ac.d.h((a)new a(this));
    AppMethodBeat.o(245014);
  }
  
  public final void onItemRangeChanged(final int paramInt1, final int paramInt2, final Object paramObject)
  {
    AppMethodBeat.i(245016);
    com.tencent.mm.ac.d.h((a)new c(this, paramInt1, paramInt2, paramObject));
    AppMethodBeat.o(245016);
  }
  
  public final void onItemRangeInserted(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(245017);
    com.tencent.mm.ac.d.h((a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(245017);
  }
  
  public final void onItemRangeRemoved(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(245018);
    com.tencent.mm.ac.d.h((a)new e(this, paramInt1, paramInt2));
    AppMethodBeat.o(245018);
  }
  
  public final void onPreFinishRefresh(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(245019);
    p.h(paramc, "reason");
    com.tencent.mm.ac.d.h((a)new g(this, paramc));
    AppMethodBeat.o(245019);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(d paramd, int paramInt1, int paramInt2, Object paramObject)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(d paramd, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(d paramd, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(d paramd, boolean paramBoolean, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(d paramd, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.d
 * JD-Core Version:    0.7.0.1
 */