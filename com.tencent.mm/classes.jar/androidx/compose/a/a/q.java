package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/ComplexDouble;", "", "_real", "", "_imaginary", "(DD)V", "imaginary", "getImaginary", "()D", "real", "getReal", "component1", "component2", "copy", "div", "other", "equals", "", "hashCode", "", "minus", "plus", "times", "toString", "", "unaryMinus", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  double UE;
  double UF;
  
  public q(double paramDouble1, double paramDouble2)
  {
    this.UE = paramDouble1;
    this.UF = paramDouble2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203286);
    if (this == paramObject)
    {
      AppMethodBeat.o(203286);
      return true;
    }
    if (!(paramObject instanceof q))
    {
      AppMethodBeat.o(203286);
      return false;
    }
    paramObject = (q)paramObject;
    if (!s.p(Double.valueOf(this.UE), Double.valueOf(paramObject.UE)))
    {
      AppMethodBeat.o(203286);
      return false;
    }
    if (!s.p(Double.valueOf(this.UF), Double.valueOf(paramObject.UF)))
    {
      AppMethodBeat.o(203286);
      return false;
    }
    AppMethodBeat.o(203286);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203283);
    int i = q..ExternalSyntheticBackport0.m(this.UE);
    int j = q..ExternalSyntheticBackport0.m(this.UF);
    AppMethodBeat.o(203283);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203277);
    String str = "ComplexDouble(_real=" + this.UE + ", _imaginary=" + this.UF + ')';
    AppMethodBeat.o(203277);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.q
 * JD-Core Version:    0.7.0.1
 */