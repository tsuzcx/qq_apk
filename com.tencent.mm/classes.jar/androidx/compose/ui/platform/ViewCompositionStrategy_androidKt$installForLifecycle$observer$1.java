package androidx.compose.ui.platform;

import androidx.lifecycle.j.a;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;"}, k=3, mv={1, 5, 1}, xi=48)
final class ViewCompositionStrategy_androidKt$installForLifecycle$observer$1
  implements o
{
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(206908);
    s.u(paramq, "$noName_0");
    s.u(parama, "event");
    if (parama == j.a.ON_DESTROY) {
      this.aVo.yt();
    }
    AppMethodBeat.o(206908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.platform.ViewCompositionStrategy_androidKt.installForLifecycle.observer.1
 * JD-Core Version:    0.7.0.1
 */