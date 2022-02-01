package androidx.compose.ui.e.b;

import androidx.compose.ui.d.k;
import androidx.compose.ui.d.l;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.af;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.p;
import androidx.compose.ui.e.p.a;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "drawArc", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "offsetSize", "offset", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
  extends androidx.compose.ui.n.d
{
  public static final a aAr = a.aAs;
  
  public abstract void a(long paramLong1, float paramFloat1, long paramLong2, float paramFloat2, f paramf, aa paramaa, int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3, float paramFloat, f paramf, aa paramaa, int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, f paramf, float paramFloat, aa paramaa, int paramInt);
  
  public abstract void a(af paramaf, long paramLong1, long paramLong2, long paramLong3, long paramLong4, float paramFloat, f paramf, aa paramaa, int paramInt);
  
  public abstract void a(ao paramao, long paramLong, float paramFloat, f paramf, aa paramaa, int paramInt);
  
  public abstract void a(ao paramao, androidx.compose.ui.e.s params, float paramFloat, f paramf, aa paramaa, int paramInt);
  
  public abstract void a(androidx.compose.ui.e.s params, long paramLong1, long paramLong2, float paramFloat, f paramf, aa paramaa, int paramInt);
  
  public abstract void a(androidx.compose.ui.e.s params, long paramLong1, long paramLong2, long paramLong3, float paramFloat, f paramf, aa paramaa, int paramInt);
  
  public abstract n getLayoutDirection();
  
  public abstract long sf();
  
  public abstract long sx();
  
  public abstract d uG();
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final int aAt;
    
    static
    {
      AppMethodBeat.i(206086);
      aAs = new a();
      p.a locala = p.avT;
      aAt = p.sU();
      AppMethodBeat.o(206086);
    }
    
    public static int uL()
    {
      return aAt;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static long a(e parame)
    {
      AppMethodBeat.i(206064);
      kotlin.g.b.s.u(parame, "this");
      long l = parame.uG().sf();
      AppMethodBeat.o(206064);
      return l;
    }
    
    private static long j(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(206110);
      paramLong1 = l.z(k.Q(paramLong1) - androidx.compose.ui.d.e.F(paramLong2), k.R(paramLong1) - androidx.compose.ui.d.e.G(paramLong2));
      AppMethodBeat.o(206110);
      return paramLong1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.b.e
 * JD-Core Version:    0.7.0.1
 */