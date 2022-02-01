package androidx.compose.foundation;

import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"background", "Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "shape", "Landroidx/compose/ui/graphics/Shape;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "background-bw27NRU", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final f a(f paramf, long paramLong, ay paramay)
  {
    AppMethodBeat.i(203583);
    kotlin.g.b.s.u(paramf, "$this$background");
    kotlin.g.b.s.u(paramay, "shape");
    z localz = z.ad(paramLong);
    if (ab.zi()) {}
    for (kotlin.g.a.b localb = (kotlin.g.a.b)new b(paramLong, paramay);; localb = ab.zh())
    {
      paramf = paramf.a((f)new a(localz, null, 0.0F, paramay, localb, 6));
      AppMethodBeat.o(203583);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.b<ad, ah>
  {
    public a(androidx.compose.ui.e.s params, ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.b<ad, ah>
  {
    public b(long paramLong, ay paramay)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.b
 * JD-Core Version:    0.7.0.1
 */