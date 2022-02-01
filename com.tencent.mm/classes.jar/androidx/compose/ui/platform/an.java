package androidx.compose.ui.platform;

import androidx.compose.ui.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInPath", "path", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class an
{
  static final boolean a(float paramFloat1, float paramFloat2, long paramLong, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(206728);
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    paramFloat3 = a.F(paramLong);
    paramFloat4 = a.G(paramLong);
    if (paramFloat1 * paramFloat1 / (paramFloat3 * paramFloat3) + paramFloat2 * paramFloat2 / (paramFloat4 * paramFloat4) <= 1.0F)
    {
      AppMethodBeat.o(206728);
      return true;
    }
    AppMethodBeat.o(206728);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.an
 * JD-Core Version:    0.7.0.1
 */