package androidx.compose.ui.m.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/style/BaselineShift;", "", "multiplier", "", "constructor-impl", "(F)F", "getMultiplier", "()F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a bdZ;
  private static final float bea;
  private static final float beb;
  private static final float bec;
  public final float bby;
  
  static
  {
    AppMethodBeat.i(205079);
    bdZ = new a.a((byte)0);
    bea = 0.5F;
    beb = -0.5F;
    bec = 0.0F;
    AppMethodBeat.o(205079);
  }
  
  public static final boolean G(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205069);
    boolean bool = s.p(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
    AppMethodBeat.o(205069);
    return bool;
  }
  
  public static int ah(float paramFloat)
  {
    AppMethodBeat.i(205053);
    int i = Float.floatToIntBits(paramFloat);
    AppMethodBeat.o(205053);
    return i;
  }
  
  public static float ai(float paramFloat)
  {
    return paramFloat;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205098);
    float f = this.bby;
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(205098);
      return false;
    }
    if (!s.p(Float.valueOf(f), Float.valueOf(((a)paramObject).bby)))
    {
      AppMethodBeat.o(205098);
      return false;
    }
    AppMethodBeat.o(205098);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205090);
    int i = Float.floatToIntBits(this.bby);
    AppMethodBeat.o(205090);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205083);
    float f = this.bby;
    String str = "BaselineShift(multiplier=" + f + ')';
    AppMethodBeat.o(205083);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.f.a
 * JD-Core Version:    0.7.0.1
 */