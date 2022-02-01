package androidx.compose.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final boolean a(i parami)
  {
    AppMethodBeat.i(205528);
    s.u(parami, "<this>");
    if (a.F(parami.avv) == a.G(parami.avv))
    {
      i = 1;
      if (i == 0) {
        break label221;
      }
      if (a.F(parami.avv) != a.F(parami.avw)) {
        break label191;
      }
      i = 1;
      label55:
      if (i == 0) {
        break label221;
      }
      if (a.F(parami.avv) != a.G(parami.avw)) {
        break label196;
      }
      i = 1;
      label79:
      if (i == 0) {
        break label221;
      }
      if (a.F(parami.avv) != a.F(parami.avx)) {
        break label201;
      }
      i = 1;
      label103:
      if (i == 0) {
        break label221;
      }
      if (a.F(parami.avv) != a.G(parami.avx)) {
        break label206;
      }
      i = 1;
      label127:
      if (i == 0) {
        break label221;
      }
      if (a.F(parami.avv) != a.F(parami.avy)) {
        break label211;
      }
      i = 1;
      label151:
      if (i == 0) {
        break label221;
      }
      if (a.F(parami.avv) != a.G(parami.avy)) {
        break label216;
      }
    }
    label191:
    label196:
    label201:
    label206:
    label211:
    label216:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label221;
      }
      AppMethodBeat.o(205528);
      return true;
      i = 0;
      break;
      i = 0;
      break label55;
      i = 0;
      break label79;
      i = 0;
      break label103;
      i = 0;
      break label127;
      i = 0;
      break label151;
    }
    label221:
    AppMethodBeat.o(205528);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.j
 * JD-Core Version:    0.7.0.1
 */