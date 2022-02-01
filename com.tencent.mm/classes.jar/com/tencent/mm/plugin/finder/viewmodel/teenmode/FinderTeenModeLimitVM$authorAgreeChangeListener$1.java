package com.tencent.mm.plugin.finder.viewmodel.teenmode;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.l;
import com.tencent.mm.autogen.a.l.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeLimitVM$authorAgreeChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AgreeAuthorizationChangeEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTeenModeLimitVM$authorAgreeChangeListener$1
  extends IListener<l>
{
  FinderTeenModeLimitVM$authorAgreeChangeListener$1(d paramd, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(337307);
    AppMethodBeat.o(337307);
  }
  
  private boolean a(l paraml)
  {
    AppMethodBeat.i(337316);
    s.u(paraml, "event");
    if (d.fpE())
    {
      av localav = av.GiL;
      if ((av.fgl()) && (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu() != null))
      {
        if (paraml.hyX.hyY == 6)
        {
          this.GWR.vs(true);
          AppMethodBeat.o(337316);
          return true;
        }
        if (paraml.hyX.hyY == 5)
        {
          this.GWR.vs(false);
          AppMethodBeat.o(337316);
          return true;
        }
      }
    }
    AppMethodBeat.o(337316);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.teenmode.FinderTeenModeLimitVM.authorAgreeChangeListener.1
 * JD-Core Version:    0.7.0.1
 */