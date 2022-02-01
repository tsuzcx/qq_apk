package androidx.compose.ui.g.c.a;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "", "pixelsPerSecond", "Landroidx/compose/ui/geometry/Offset;", "confidence", "", "durationMillis", "", "offset", "(JFJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConfidence", "()F", "getDurationMillis", "()J", "getOffset-F1C5BW0", "J", "getPixelsPerSecond-F1C5BW0", "component1", "component1-F1C5BW0", "component2", "component3", "component4", "component4-F1C5BW0", "copy", "copy-PZAlG8E", "(JFJJ)Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
{
  public static final e.a aMs;
  private static final e aMv;
  private final float aMq;
  final long aMt;
  private final long aMu;
  private final long offset;
  
  static
  {
    AppMethodBeat.i(205872);
    aMs = new e.a((byte)0);
    androidx.compose.ui.d.e.a locala = androidx.compose.ui.d.e.avo;
    long l = androidx.compose.ui.d.e.su();
    locala = androidx.compose.ui.d.e.avo;
    aMv = new e(l, 1.0F, 0L, androidx.compose.ui.d.e.su(), (byte)0);
    AppMethodBeat.o(205872);
  }
  
  private e(long paramLong1, float paramFloat, long paramLong2, long paramLong3)
  {
    this.aMt = paramLong1;
    this.aMq = paramFloat;
    this.aMu = paramLong2;
    this.offset = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205892);
    if (this == paramObject)
    {
      AppMethodBeat.o(205892);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(205892);
      return false;
    }
    paramObject = (e)paramObject;
    if (!androidx.compose.ui.d.e.e(this.aMt, paramObject.aMt))
    {
      AppMethodBeat.o(205892);
      return false;
    }
    if (!s.p(Float.valueOf(this.aMq), Float.valueOf(paramObject.aMq)))
    {
      AppMethodBeat.o(205892);
      return false;
    }
    if (this.aMu != paramObject.aMu)
    {
      AppMethodBeat.o(205892);
      return false;
    }
    if (!androidx.compose.ui.d.e.e(this.offset, paramObject.offset))
    {
      AppMethodBeat.o(205892);
      return false;
    }
    AppMethodBeat.o(205892);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205884);
    int i = androidx.compose.ui.d.e.I(this.aMt);
    int j = Float.floatToIntBits(this.aMq);
    int k = q.a..ExternalSyntheticBackport0.m(this.aMu);
    int m = androidx.compose.ui.d.e.I(this.offset);
    AppMethodBeat.o(205884);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205878);
    String str = "VelocityEstimate(pixelsPerSecond=" + androidx.compose.ui.d.e.H(this.aMt) + ", confidence=" + this.aMq + ", durationMillis=" + this.aMu + ", offset=" + androidx.compose.ui.d.e.H(this.offset) + ')';
    AppMethodBeat.o(205878);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.a.e
 * JD-Core Version:    0.7.0.1
 */