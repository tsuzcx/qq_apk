package androidx.compose.ui.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "compareTo", "", "other", "compareTo-0680j_4", "(FF)I", "div", "div-0680j_4", "(FF)F", "div-u2uoSUM", "(FI)F", "equals", "", "", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(F)I", "minus", "minus-5rwHm24", "plus", "plus-5rwHm24", "times", "times-u2uoSUM", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "unaryMinus", "unaryMinus-D9Ej5fM", "Companion", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements Comparable<g>
{
  public static final g.a beI;
  private static final float beJ;
  private static final float beK;
  private static final float beL;
  public final float value;
  
  static
  {
    AppMethodBeat.i(204795);
    beI = new g.a((byte)0);
    beJ = 0.0F;
    beK = (1.0F / 1.0F);
    beL = (0.0F / 0.0F);
    AppMethodBeat.o(204795);
  }
  
  public static final boolean G(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204777);
    boolean bool = s.p(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
    AppMethodBeat.o(204777);
    return bool;
  }
  
  public static int I(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204743);
    int i = Float.compare(paramFloat1, paramFloat2);
    AppMethodBeat.o(204743);
    return i;
  }
  
  public static int ah(float paramFloat)
  {
    AppMethodBeat.i(204762);
    int i = Float.floatToIntBits(paramFloat);
    AppMethodBeat.o(204762);
    return i;
  }
  
  public static float ai(float paramFloat)
  {
    return paramFloat;
  }
  
  public static String ak(float paramFloat)
  {
    AppMethodBeat.i(204754);
    if (Float.isNaN(paramFloat))
    {
      AppMethodBeat.o(204754);
      return "Dp.Unspecified";
    }
    String str = paramFloat + ".dp";
    AppMethodBeat.o(204754);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204821);
    float f = this.value;
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(204821);
      return false;
    }
    if (!s.p(Float.valueOf(f), Float.valueOf(((g)paramObject).value)))
    {
      AppMethodBeat.o(204821);
      return false;
    }
    AppMethodBeat.o(204821);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204812);
    int i = Float.floatToIntBits(this.value);
    AppMethodBeat.o(204812);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204803);
    String str = ak(this.value);
    AppMethodBeat.o(204803);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.g
 * JD-Core Version:    0.7.0.1
 */