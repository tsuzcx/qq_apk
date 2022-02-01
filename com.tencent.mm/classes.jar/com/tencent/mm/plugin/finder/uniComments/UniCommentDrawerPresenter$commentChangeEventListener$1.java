package com.tencent.mm.plugin.finder.uniComments;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abj;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/UniCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UniCommentDrawerPresenter$commentChangeEventListener$1
  extends IListener<abj>
{
  UniCommentDrawerPresenter$commentChangeEventListener$1(f paramf, com.tencent.mm.app.f paramf1)
  {
    super((q)paramf1);
    AppMethodBeat.i(341458);
    AppMethodBeat.o(341458);
  }
  
  private static final void aP(a parama)
  {
    AppMethodBeat.i(341466);
    s.u(parama, "$func");
    parama.invoke();
    AppMethodBeat.o(341466);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(abj paramabj, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.UniCommentDrawerPresenter.commentChangeEventListener.1
 * JD-Core Version:    0.7.0.1
 */