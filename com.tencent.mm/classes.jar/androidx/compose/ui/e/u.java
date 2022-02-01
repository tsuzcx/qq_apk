package androidx.compose.ui.e;

import androidx.compose.ui.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Canvas;", "", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "clipRect-mtrdD-E", "(Landroidx/compose/ui/geometry/Rect;I)V", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawArcRad", "startAngleRad", "sweepAngleRad", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "scale", "sx", "sy", "skew", "skewRad", "sxRad", "syRad", "translate", "dx", "dy", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface u
{
  public abstract void A(float paramFloat1, float paramFloat2);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, am paramam);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, am paramam);
  
  public abstract void a(long paramLong, float paramFloat, am paramam);
  
  public abstract void a(g paramg, int paramInt);
  
  public abstract void a(g paramg, am paramam);
  
  public abstract void a(af paramaf, long paramLong1, long paramLong2, long paramLong3, long paramLong4, am paramam);
  
  public abstract void a(ao paramao, int paramInt);
  
  public abstract void a(ao paramao, am paramam);
  
  public abstract void b(g paramg, am paramam);
  
  public abstract void c(float[] paramArrayOfFloat);
  
  public abstract void restore();
  
  public abstract void sA();
  
  public abstract void sB();
  
  public abstract void sz();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(u paramu, g paramg, int paramInt)
    {
      AppMethodBeat.i(206144);
      s.u(paramu, "this");
      s.u(paramg, "rect");
      paramu.a(paramg.left, paramg.top, paramg.right, paramg.bottom, paramInt);
      AppMethodBeat.o(206144);
    }
    
    public static void a(u paramu, g paramg, am paramam)
    {
      AppMethodBeat.i(206152);
      s.u(paramu, "this");
      s.u(paramg, "rect");
      s.u(paramam, "paint");
      paramu.a(paramg.left, paramg.top, paramg.right, paramg.bottom, paramam);
      AppMethodBeat.o(206152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.u
 * JD-Core Version:    0.7.0.1
 */