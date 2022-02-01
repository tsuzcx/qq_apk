package androidx.compose.ui.n;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/IntSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)I", "getPackedValue$annotations", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "div", "other", "div-YEO4UFw", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "times", "times-YEO4UFw", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  private static final long avn;
  public static final a beO;
  public final long avp;
  
  static
  {
    AppMethodBeat.i(204804);
    beO = new a((byte)0);
    avn = 0L;
    AppMethodBeat.o(204804);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(204766);
    String str = (int)(paramLong >> 32) + " x " + (int)(0xFFFFFFFF & paramLong);
    AppMethodBeat.o(204766);
    return str;
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(204772);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(204772);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final int bi(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  public static final int bj(long paramLong)
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
    if (!(paramObject instanceof l)) {}
    while (l != ((l)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204819);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(204819);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204810);
    String str = H(this.avp);
    AppMethodBeat.o(204810);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/IntSize$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntSize;", "getZero-YbymL2g", "()J", "J", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.l
 * JD-Core Version:    0.7.0.1
 */