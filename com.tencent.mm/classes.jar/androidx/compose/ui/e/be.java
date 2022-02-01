package androidx.compose.ui.e;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/TransformOrigin;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "pivotFractionX", "", "getPivotFractionX-impl", "(J)F", "pivotFractionY", "getPivotFractionY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-zey9I6w", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
{
  public static final be.a ayC;
  private static final long ayD;
  private final long avp;
  
  static
  {
    AppMethodBeat.i(206063);
    ayC = new be.a((byte)0);
    ayD = Float.floatToIntBits(0.5F) << 32 | Float.floatToIntBits(0.5F) & 0xFFFFFFFF;
    AppMethodBeat.o(206063);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(206037);
    String str = "TransformOrigin(packedValue=" + paramLong + ')';
    AppMethodBeat.o(206037);
    return str;
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(206041);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(206041);
    return i;
  }
  
  public static final float ak(long paramLong)
  {
    AppMethodBeat.i(206025);
    m localm = m.aiwV;
    float f = Float.intBitsToFloat((int)(paramLong >> 32));
    AppMethodBeat.o(206025);
    return f;
  }
  
  public static final float al(long paramLong)
  {
    AppMethodBeat.i(206030);
    m localm = m.aiwV;
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(206030);
    return f;
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.avp;
    if (!(paramObject instanceof be)) {}
    while (l != ((be)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206075);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(206075);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206068);
    String str = H(this.avp);
    AppMethodBeat.o(206068);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.be
 * JD-Core Version:    0.7.0.1
 */