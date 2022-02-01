package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/DecayAnimationSpecImpl;", "T", "Landroidx/compose/animation/core/DecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "vectorize", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v<T>
  implements u<T>
{
  private final ac UO;
  
  public v(ac paramac)
  {
    AppMethodBeat.i(203288);
    this.UO = paramac;
    AppMethodBeat.o(203288);
  }
  
  public final <V extends k> bb<V> b(aw<T, V> paramaw)
  {
    AppMethodBeat.i(203291);
    s.u(paramaw, "typeConverter");
    paramaw = (bb)new bf(this.UO);
    AppMethodBeat.o(203291);
    return paramaw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.v
 * JD-Core Version:    0.7.0.1
 */