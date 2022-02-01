package androidx.compose.b;

import androidx.compose.ui.e.ab;
import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/material/DefaultElevationOverlay;", "Landroidx/compose/material/ElevationOverlay;", "()V", "apply", "Landroidx/compose/ui/graphics/Color;", "color", "elevation", "Landroidx/compose/ui/unit/Dp;", "apply-7g2Lkgo", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k=1, mv={1, 5, 1}, xi=48)
final class f
  implements h
{
  public static final f aiw;
  
  static
  {
    AppMethodBeat.i(201706);
    aiw = new f();
    AppMethodBeat.o(201706);
  }
  
  public final long a(long paramLong, float paramFloat, androidx.compose.runtime.h paramh, int paramInt)
  {
    AppMethodBeat.i(201708);
    Object localObject = m.aiH;
    localObject = m.j(paramh);
    if ((g.I(paramFloat, g.ai(0.0F)) > 0) && (!((a)localObject).nr()))
    {
      paramh.bx(-1272525241);
      paramLong = ab.i(i.a(paramLong, paramFloat, paramh), paramLong);
      paramh.od();
      AppMethodBeat.o(201708);
      return paramLong;
    }
    paramh.bx(-1272525098);
    paramh.od();
    AppMethodBeat.o(201708);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.f
 * JD-Core Version:    0.7.0.1
 */