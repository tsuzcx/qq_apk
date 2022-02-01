package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.cb;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "<anonymous parameter 1>", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged"}, k=3, mv={1, 4, 1})
final class LifecycleController$observer$1
  implements o
{
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(194346);
    s.u(paramq, "source");
    s.u(parama, "<anonymous parameter 1>");
    parama = paramq.getLifecycle();
    s.s(parama, "source.lifecycle");
    if (parama.getCurrentState() == j.b.bHg)
    {
      this.bHm.a(null);
      AppMethodBeat.o(194346);
      throw null;
    }
    paramq = paramq.getLifecycle();
    s.s(paramq, "source.lifecycle");
    paramq.getCurrentState();
    AppMethodBeat.o(194346);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.lifecycle.LifecycleController.observer.1
 * JD-Core Version:    0.7.0.1
 */