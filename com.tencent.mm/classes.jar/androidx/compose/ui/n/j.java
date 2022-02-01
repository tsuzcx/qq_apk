package androidx.compose.ui.n;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "div", "operand", "", "div-Bjo55l4", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "minus", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "rem", "rem-Bjo55l4", "(JI)J", "times", "times-Bjo55l4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-nOcc-ac", "Companion", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final long avn;
  public static final a beN;
  public final long avp;
  
  static
  {
    AppMethodBeat.i(204778);
    beN = new a((byte)0);
    avn = k.am(0, 0);
    AppMethodBeat.o(204778);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(204738);
    String str = "(" + (int)(paramLong >> 32) + ", " + (int)(0xFFFFFFFF & paramLong) + ')';
    AppMethodBeat.o(204738);
    return str;
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(204749);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(204749);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final int bf(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  public static final int bg(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.avp;
    if (!(paramObject instanceof j)) {}
    while (l != ((j)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204794);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(204794);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204786);
    String str = H(this.avp);
    AppMethodBeat.o(204786);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.j
 * JD-Core Version:    0.7.0.1
 */