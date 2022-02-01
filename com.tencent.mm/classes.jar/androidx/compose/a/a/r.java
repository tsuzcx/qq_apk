package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final q n(double paramDouble)
  {
    AppMethodBeat.i(203255);
    if (paramDouble < 0.0D)
    {
      localq = new q(0.0D, Math.sqrt(Math.abs(paramDouble)));
      AppMethodBeat.o(203255);
      return localq;
    }
    q localq = new q(Math.sqrt(paramDouble), 0.0D);
    AppMethodBeat.o(203255);
    return localq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.r
 * JD-Core Version:    0.7.0.1
 */