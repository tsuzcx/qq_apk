package androidx.compose.ui.n;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private static final long avn;
  public static final i.a beM;
  public final long avp;
  
  static
  {
    AppMethodBeat.i(204739);
    beM = new i.a((byte)0);
    avn = h.J(g.ai(0.0F), g.ai(0.0F));
    AppMethodBeat.o(204739);
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final float bc(long paramLong)
  {
    AppMethodBeat.i(204720);
    m localm = m.aiwV;
    float f = g.ai(Float.intBitsToFloat((int)(paramLong >> 32)));
    AppMethodBeat.o(204720);
    return f;
  }
  
  public static final float bd(long paramLong)
  {
    AppMethodBeat.i(204723);
    m localm = m.aiwV;
    float f = g.ai(Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong)));
    AppMethodBeat.o(204723);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.avp;
    if (!(paramObject instanceof i)) {}
    while (l != ((i)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204761);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(204761);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204752);
    long l = this.avp;
    String str = "(" + g.ak(bc(l)) + ", " + g.ak(bd(l)) + ')';
    AppMethodBeat.o(204752);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.i
 * JD-Core Version:    0.7.0.1
 */