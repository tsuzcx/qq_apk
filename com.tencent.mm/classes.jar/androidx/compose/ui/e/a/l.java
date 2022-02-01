package androidx.compose.ui.e.a;

import androidx.compose.a.a.q..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "(DDDDDDD)V", "getA", "()D", "getB", "getC", "getD", "getE", "getF", "getGamma", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  final double a;
  final double aAi;
  final double b;
  final double c;
  final double d;
  final double e;
  final double f;
  
  private l(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    AppMethodBeat.i(206191);
    this.aAi = paramDouble1;
    this.a = paramDouble2;
    this.b = paramDouble3;
    this.c = paramDouble4;
    this.d = paramDouble5;
    this.e = 0.0D;
    this.f = 0.0D;
    IllegalArgumentException localIllegalArgumentException;
    if ((Double.isNaN(this.a)) || (Double.isNaN(this.b)) || (Double.isNaN(this.c)) || (Double.isNaN(this.d)) || (Double.isNaN(this.e)) || (Double.isNaN(this.f)) || (Double.isNaN(this.aAi)))
    {
      localIllegalArgumentException = new IllegalArgumentException("Parameters cannot be NaN");
      AppMethodBeat.o(206191);
      throw localIllegalArgumentException;
    }
    if ((this.d < 0.0D) || (this.d > 1.0D))
    {
      localIllegalArgumentException = new IllegalArgumentException(s.X("Parameter d must be in the range [0..1], was ", Double.valueOf(this.d)));
      AppMethodBeat.o(206191);
      throw localIllegalArgumentException;
    }
    if (this.d == 0.0D)
    {
      i = 1;
      if (i == 0) {
        break label271;
      }
      if (this.a != 0.0D) {
        break label259;
      }
      i = 1;
      label212:
      if (i == 0) {
        if (this.aAi != 0.0D) {
          break label265;
        }
      }
    }
    label259:
    label265:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label271;
      }
      localIllegalArgumentException = new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
      AppMethodBeat.o(206191);
      throw localIllegalArgumentException;
      i = 0;
      break;
      i = 0;
      break label212;
    }
    label271:
    if (this.d >= 1.0D)
    {
      if (this.c == 0.0D) {}
      for (i = 1; i != 0; i = 0)
      {
        localIllegalArgumentException = new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
        AppMethodBeat.o(206191);
        throw localIllegalArgumentException;
      }
    }
    if (this.a == 0.0D)
    {
      i = 1;
      if (i == 0)
      {
        if (this.aAi != 0.0D) {
          break label398;
        }
        i = 1;
        label351:
        if (i == 0) {
          break label410;
        }
      }
      if (this.c != 0.0D) {
        break label404;
      }
    }
    label398:
    label404:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label410;
      }
      localIllegalArgumentException = new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
      AppMethodBeat.o(206191);
      throw localIllegalArgumentException;
      i = 0;
      break;
      i = 0;
      break label351;
    }
    label410:
    if (this.c < 0.0D)
    {
      localIllegalArgumentException = new IllegalArgumentException("The transfer function must be increasing");
      AppMethodBeat.o(206191);
      throw localIllegalArgumentException;
    }
    if ((this.a < 0.0D) || (this.aAi < 0.0D))
    {
      localIllegalArgumentException = new IllegalArgumentException("The transfer function must be positive or increasing");
      AppMethodBeat.o(206191);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(206191);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206212);
    if (this == paramObject)
    {
      AppMethodBeat.o(206212);
      return true;
    }
    if (!(paramObject instanceof l))
    {
      AppMethodBeat.o(206212);
      return false;
    }
    paramObject = (l)paramObject;
    if (!s.p(Double.valueOf(this.aAi), Double.valueOf(paramObject.aAi)))
    {
      AppMethodBeat.o(206212);
      return false;
    }
    if (!s.p(Double.valueOf(this.a), Double.valueOf(paramObject.a)))
    {
      AppMethodBeat.o(206212);
      return false;
    }
    if (!s.p(Double.valueOf(this.b), Double.valueOf(paramObject.b)))
    {
      AppMethodBeat.o(206212);
      return false;
    }
    if (!s.p(Double.valueOf(this.c), Double.valueOf(paramObject.c)))
    {
      AppMethodBeat.o(206212);
      return false;
    }
    if (!s.p(Double.valueOf(this.d), Double.valueOf(paramObject.d)))
    {
      AppMethodBeat.o(206212);
      return false;
    }
    if (!s.p(Double.valueOf(this.e), Double.valueOf(paramObject.e)))
    {
      AppMethodBeat.o(206212);
      return false;
    }
    if (!s.p(Double.valueOf(this.f), Double.valueOf(paramObject.f)))
    {
      AppMethodBeat.o(206212);
      return false;
    }
    AppMethodBeat.o(206212);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206205);
    int i = q..ExternalSyntheticBackport0.m(this.aAi);
    int j = q..ExternalSyntheticBackport0.m(this.a);
    int k = q..ExternalSyntheticBackport0.m(this.b);
    int m = q..ExternalSyntheticBackport0.m(this.c);
    int n = q..ExternalSyntheticBackport0.m(this.d);
    int i1 = q..ExternalSyntheticBackport0.m(this.e);
    int i2 = q..ExternalSyntheticBackport0.m(this.f);
    AppMethodBeat.o(206205);
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206201);
    String str = "TransferParameters(gamma=" + this.aAi + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    AppMethodBeat.o(206201);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.l
 * JD-Core Version:    0.7.0.1
 */