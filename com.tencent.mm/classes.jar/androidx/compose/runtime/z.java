package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/DynamicProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "Lkotlin/Function0;", "(Landroidx/compose/runtime/SnapshotMutationPolicy;Lkotlin/jvm/functions/Function0;)V", "provided", "Landroidx/compose/runtime/State;", "value", "provided$runtime_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z<T>
  extends as<T>
{
  private final bi<T> anV;
  
  public z(bi<T> parambi, a<? extends T> parama)
  {
    super(parama);
    AppMethodBeat.i(202201);
    this.anV = parambi;
    AppMethodBeat.o(202201);
  }
  
  public final bm<T> a(T paramT, h paramh)
  {
    AppMethodBeat.i(202211);
    paramh.bx(-1007657376);
    paramh.bx(-3687241);
    Object localObject2 = paramh.or();
    Object localObject1 = h.alD;
    localObject1 = localObject2;
    if (localObject2 == h.a.ox())
    {
      localObject1 = bj.b(paramT, this.anV);
      paramh.F(localObject1);
    }
    paramh.od();
    ((an)localObject1).setValue(paramT);
    paramT = (an)localObject1;
    paramh.od();
    paramT = (bm)paramT;
    AppMethodBeat.o(202211);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.z
 * JD-Core Version:    0.7.0.1
 */