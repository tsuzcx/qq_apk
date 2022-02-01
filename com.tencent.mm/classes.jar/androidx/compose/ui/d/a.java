package androidx.compose.ui.d;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/geometry/CornerRadius;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OHQCggk", "(JFF)J", "div", "operand", "div-Bz7bX_o", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-vF7b-mM", "(JJ)J", "plus", "plus-vF7b-mM", "times", "times-Bz7bX_o", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-kKHJgLs", "Companion", "ui-geometry_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a avm;
  private static final long avn;
  
  static
  {
    AppMethodBeat.i(205582);
    avm = new a.a((byte)0);
    avn = b.v(0.0F, 0.0F);
    AppMethodBeat.o(205582);
  }
  
  public static final float F(long paramLong)
  {
    AppMethodBeat.i(205533);
    m localm = m.aiwV;
    float f = Float.intBitsToFloat((int)(paramLong >> 32));
    AppMethodBeat.o(205533);
    return f;
  }
  
  public static final float G(long paramLong)
  {
    AppMethodBeat.i(205540);
    m localm = m.aiwV;
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(205540);
    return f;
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(205550);
    if (F(paramLong) == G(paramLong)) {}
    for (int i = 1; i != 0; i = 0)
    {
      str = "CornerRadius.circular(" + c.I(F(paramLong)) + ')';
      AppMethodBeat.o(205550);
      return str;
    }
    String str = "CornerRadius.elliptical(" + c.I(F(paramLong)) + ", " + c.I(G(paramLong)) + ')';
    AppMethodBeat.o(205550);
    return str;
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(205561);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(205561);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.a
 * JD-Core Version:    0.7.0.1
 */