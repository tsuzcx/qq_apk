package androidx.compose.ui.n;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/Velocity;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OhffZ5M", "(JFF)J", "div", "operand", "div-adjELrA", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-AH228Gc", "(JJ)J", "plus", "plus-AH228Gc", "rem", "rem-adjELrA", "times", "times-adjELrA", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-9UxMQ8M", "Companion", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  private static final long avn;
  public static final r.a beY;
  public final long avp;
  
  static
  {
    AppMethodBeat.i(204742);
    beY = new r.a((byte)0);
    avn = s.K(0.0F, 0.0F);
    AppMethodBeat.o(204742);
  }
  
  public static final float F(long paramLong)
  {
    AppMethodBeat.i(204704);
    m localm = m.aiwV;
    float f = Float.intBitsToFloat((int)(paramLong >> 32));
    AppMethodBeat.o(204704);
    return f;
  }
  
  public static final float G(long paramLong)
  {
    AppMethodBeat.i(204708);
    m localm = m.aiwV;
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(204708);
    return f;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final long t(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(204711);
    paramLong1 = s.K(F(paramLong1) - F(paramLong2), G(paramLong1) - G(paramLong2));
    AppMethodBeat.o(204711);
    return paramLong1;
  }
  
  public static final long u(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(204719);
    paramLong1 = s.K(F(paramLong1) + F(paramLong2), G(paramLong1) + G(paramLong2));
    AppMethodBeat.o(204719);
    return paramLong1;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.avp;
    if (!(paramObject instanceof r)) {}
    while (l != ((r)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204763);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(204763);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204755);
    long l = this.avp;
    String str = "(" + F(l) + ", " + G(l) + ") px/sec";
    AppMethodBeat.o(204755);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.r
 * JD-Core Version:    0.7.0.1
 */