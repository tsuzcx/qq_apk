package coil.util;

import androidx.lifecycle.e;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"coil/util/-Lifecycles$observeStarted$2$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onStart", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class -Lifecycles$observeStarted$2$1
  implements e
{
  -Lifecycles$observeStarted$2$1(p<? super ah> paramp) {}
  
  public final void onStart(q paramq)
  {
    AppMethodBeat.i(188095);
    s.u(paramq, "owner");
    paramq = (d)this.bPv;
    ah localah = ah.aiuX;
    Result.Companion localCompanion = Result.Companion;
    paramq.resumeWith(Result.constructor-impl(localah));
    AppMethodBeat.o(188095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.util.-Lifecycles.observeStarted.2.1
 * JD-Core Version:    0.7.0.1
 */