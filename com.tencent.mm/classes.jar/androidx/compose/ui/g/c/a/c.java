package androidx.compose.ui.g.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/util/PolynomialFit;", "", "coefficients", "", "", "confidence", "(Ljava/util/List;F)V", "getCoefficients", "()Ljava/util/List;", "getConfidence", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final List<Float> aMp;
  final float aMq;
  
  public c(List<Float> paramList, float paramFloat)
  {
    AppMethodBeat.i(205862);
    this.aMp = paramList;
    this.aMq = paramFloat;
    AppMethodBeat.o(205862);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205887);
    if (this == paramObject)
    {
      AppMethodBeat.o(205887);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(205887);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.aMp, paramObject.aMp))
    {
      AppMethodBeat.o(205887);
      return false;
    }
    if (!s.p(Float.valueOf(this.aMq), Float.valueOf(paramObject.aMq)))
    {
      AppMethodBeat.o(205887);
      return false;
    }
    AppMethodBeat.o(205887);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205879);
    int i = this.aMp.hashCode();
    int j = Float.floatToIntBits(this.aMq);
    AppMethodBeat.o(205879);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205869);
    String str = "PolynomialFit(coefficients=" + this.aMp + ", confidence=" + this.aMq + ')';
    AppMethodBeat.o(205869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.g.c.a.c
 * JD-Core Version:    0.7.0.1
 */