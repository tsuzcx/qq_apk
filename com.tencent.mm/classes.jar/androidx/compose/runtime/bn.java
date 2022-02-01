package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/StaticProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "provided", "Landroidx/compose/runtime/State;", "value", "provided$runtime_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bn<T>
  extends as<T>
{
  public bn(a<? extends T> parama)
  {
    super(parama);
    AppMethodBeat.i(201962);
    AppMethodBeat.o(201962);
  }
  
  public final bm<T> a(T paramT, h paramh)
  {
    AppMethodBeat.i(201966);
    paramh.bx(-1119569479);
    paramT = new bo(paramT);
    paramh.od();
    paramT = (bm)paramT;
    AppMethodBeat.o(201966);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bn
 * JD-Core Version:    0.7.0.1
 */