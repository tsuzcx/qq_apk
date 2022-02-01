package androidx.compose.foundation.c;

import androidx.compose.ui.n.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "(IIII)V", "getCrossAxisMax", "()I", "getCrossAxisMin", "getMainAxisMax", "getMainAxisMin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "maxHeight", "maxWidth", "stretchCrossAxis", "toBoxConstraints", "toBoxConstraints-OenEA2s", "(Landroidx/compose/foundation/layout/LayoutOrientation;)J", "toString", "", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  final int acY;
  final int acZ;
  final int ada;
  final int adb;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.acY = paramInt1;
    this.acZ = paramInt2;
    this.ada = paramInt3;
    this.adb = paramInt4;
  }
  
  private q(long paramLong, m paramm) {}
  
  public final long a(m paramm)
  {
    AppMethodBeat.i(203936);
    s.u(paramm, "orientation");
    if (paramm == m.acP)
    {
      l = c.k(this.acY, this.acZ, this.ada, this.adb);
      AppMethodBeat.o(203936);
      return l;
    }
    long l = c.k(this.ada, this.adb, this.acY, this.acZ);
    AppMethodBeat.o(203936);
    return l;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof q)) {
        return false;
      }
      paramObject = (q)paramObject;
      if (this.acY != paramObject.acY) {
        return false;
      }
      if (this.acZ != paramObject.acZ) {
        return false;
      }
      if (this.ada != paramObject.ada) {
        return false;
      }
    } while (this.adb == paramObject.adb);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.acY * 31 + this.acZ) * 31 + this.ada) * 31 + this.adb;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203940);
    String str = "OrientationIndependentConstraints(mainAxisMin=" + this.acY + ", mainAxisMax=" + this.acZ + ", crossAxisMin=" + this.ada + ", crossAxisMax=" + this.adb + ')';
    AppMethodBeat.o(203940);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.q
 * JD-Core Version:    0.7.0.1
 */