package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/LazyValueHolder;", "T", "Landroidx/compose/runtime/State;", "valueProducer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "current", "getCurrent", "()Ljava/lang/Object;", "current$delegate", "Lkotlin/Lazy;", "value", "getValue", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak<T>
  implements bm<T>
{
  private final j aos;
  
  public ak(a<? extends T> parama)
  {
    AppMethodBeat.i(201899);
    this.aos = k.cm(parama);
    AppMethodBeat.o(201899);
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(369511);
    Object localObject = nN();
    AppMethodBeat.o(369511);
    return localObject;
  }
  
  final T nN()
  {
    AppMethodBeat.i(201902);
    Object localObject = this.aos.getValue();
    AppMethodBeat.o(201902);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.ak
 * JD-Core Version:    0.7.0.1
 */