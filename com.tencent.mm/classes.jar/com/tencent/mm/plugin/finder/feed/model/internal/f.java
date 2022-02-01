package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/LinkedList;)V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishInserted", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMore", "isSmooth", "", "onPreFinishRefresh", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<R extends k>
{
  private final LinkedList<com.tencent.mm.view.k> viewCallbacks;
  
  public f(LinkedList<com.tencent.mm.view.k> paramLinkedList)
  {
    AppMethodBeat.i(366557);
    this.viewCallbacks = paramLinkedList;
    AppMethodBeat.o(366557);
  }
  
  public final void Oc(final int paramInt)
  {
    AppMethodBeat.i(366586);
    d.uiThread((a)new b(this, paramInt));
    AppMethodBeat.o(366586);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(366581);
    d.uiThread((a)new a(this));
    AppMethodBeat.o(366581);
  }
  
  public final void onItemRangeChanged(final int paramInt1, final int paramInt2, final Object paramObject)
  {
    AppMethodBeat.i(366591);
    d.uiThread((a)new c(this, paramInt1, paramInt2, paramObject));
    AppMethodBeat.o(366591);
  }
  
  public final void onItemRangeInserted(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(366594);
    d.uiThread((a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(366594);
  }
  
  public final void onItemRangeRemoved(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(366599);
    d.uiThread((a)new e(this, paramInt1, paramInt2));
    AppMethodBeat.o(366599);
  }
  
  public final void onPreFinishRefresh(final RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(366604);
    s.u(paramd, "reason");
    d.uiThread((a)new g(this, paramd));
    AppMethodBeat.o(366604);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(f<R> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(f<R> paramf, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(f<R> paramf, int paramInt1, int paramInt2, Object paramObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(f<R> paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(f<R> paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ah>
  {
    f(f<R> paramf, RefreshLoadMoreLayout.d<Object> paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<ah>
  {
    g(f<R> paramf, RefreshLoadMoreLayout.d<Object> paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.f
 * JD-Core Version:    0.7.0.1
 */