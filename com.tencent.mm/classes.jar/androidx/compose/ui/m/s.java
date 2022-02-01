package androidx.compose.ui.m;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/TextRange;", "", "packedValue", "", "constructor-impl", "(J)J", "collapsed", "", "getCollapsed-impl", "(J)Z", "end", "", "getEnd-impl", "(J)I", "length", "getLength-impl", "max", "getMax-impl", "min", "getMin-impl", "reversed", "getReversed-impl", "start", "getStart-impl", "contains", "other", "contains-5zc-tL8", "(JJ)Z", "offset", "contains-impl", "(JI)Z", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "intersects", "intersects-5zc-tL8", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  private static final long avn;
  public static final s.a baA;
  public final long avp;
  
  static
  {
    AppMethodBeat.i(205077);
    baA = new s.a((byte)0);
    avn = t.ai(0, 0);
    AppMethodBeat.o(205077);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(205028);
    String str = "TextRange(" + (int)(paramLong >> 32) + ", " + (int)(0xFFFFFFFF & paramLong) + ')';
    AppMethodBeat.o(205028);
    return str;
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(205035);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(205035);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final int aN(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  public static final int aO(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public static final int aP(long paramLong)
  {
    if ((int)(paramLong >> 32) > (int)(paramLong & 0xFFFFFFFF)) {
      return (int)(paramLong & 0xFFFFFFFF);
    }
    return (int)(paramLong >> 32);
  }
  
  public static final int aQ(long paramLong)
  {
    if ((int)(paramLong >> 32) > (int)(paramLong & 0xFFFFFFFF)) {
      return (int)(paramLong >> 32);
    }
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public static final boolean aR(long paramLong)
  {
    return (int)(paramLong >> 32) == (int)(0xFFFFFFFF & paramLong);
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.avp;
    if (!(paramObject instanceof s)) {}
    while (l != ((s)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205095);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(205095);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205086);
    String str = H(this.avp);
    AppMethodBeat.o(205086);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.s
 * JD-Core Version:    0.7.0.1
 */