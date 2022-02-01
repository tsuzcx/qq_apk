package androidx.compose.foundation.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"ZeroCornerSize", "Landroidx/compose/foundation/shape/CornerSize;", "getZeroCornerSize$annotations", "()V", "getZeroCornerSize", "()Landroidx/compose/foundation/shape/CornerSize;", "CornerSize", "size", "Landroidx/compose/ui/unit/Dp;", "CornerSize-0680j_4", "(F)Landroidx/compose/foundation/shape/CornerSize;", "", "percent", "", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final b agG;
  
  static
  {
    AppMethodBeat.i(203663);
    agG = (b)new a();
    AppMethodBeat.o(203663);
  }
  
  public static final b F(float paramFloat)
  {
    AppMethodBeat.i(203655);
    b localb = (b)new d(paramFloat, (byte)0);
    AppMethodBeat.o(203655);
    return localb;
  }
  
  public static final b mW()
  {
    AppMethodBeat.i(203658);
    b localb = (b)new e(50.0F);
    AppMethodBeat.o(203658);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/shape/CornerSizeKt$ZeroCornerSize$1", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "valueOverride", "", "getValueOverride", "()Ljava/lang/String;", "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b
  {
    public final float a(long paramLong, androidx.compose.ui.n.d paramd)
    {
      AppMethodBeat.i(203670);
      s.u(paramd, "density");
      AppMethodBeat.o(203670);
      return 0.0F;
    }
    
    public final String toString()
    {
      return "ZeroCornerSize";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.e.c
 * JD-Core Version:    0.7.0.1
 */