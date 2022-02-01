package androidx.compose.ui.i;

import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.af;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.b.a;
import androidx.compose.ui.e.b.a.a;
import androidx.compose.ui.e.b.c;
import androidx.compose.ui.e.b.d;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.e.b.f;
import androidx.compose.ui.e.u;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "LayoutNodeWrapper", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/LayoutNodeWrapper;Lkotlin/jvm/functions/Function1;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements c
{
  private final a XU;
  private j aNN;
  
  private h(a parama)
  {
    AppMethodBeat.i(204554);
    this.XU = parama;
    AppMethodBeat.o(204554);
  }
  
  public final void a(long paramLong1, float paramFloat1, long paramLong2, float paramFloat2, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(204619);
    kotlin.g.b.s.u(paramf, "style");
    this.XU.a(paramLong1, paramFloat1, paramLong2, paramFloat2, paramf, paramaa, paramInt);
    AppMethodBeat.o(204619);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(204647);
    kotlin.g.b.s.u(paramf, "style");
    this.XU.a(paramLong1, paramLong2, paramLong3, paramFloat, paramf, paramaa, paramInt);
    AppMethodBeat.o(204647);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, f paramf, float paramFloat, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(204658);
    kotlin.g.b.s.u(paramf, "style");
    this.XU.a(paramLong1, paramLong2, paramLong3, paramLong4, paramf, paramFloat, paramaa, paramInt);
    AppMethodBeat.o(204658);
  }
  
  public final void a(af paramaf, long paramLong1, long paramLong2, long paramLong3, long paramLong4, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(204623);
    kotlin.g.b.s.u(paramaf, "image");
    kotlin.g.b.s.u(paramf, "style");
    this.XU.a(paramaf, paramLong1, paramLong2, paramLong3, paramLong4, paramFloat, paramf, paramaa, paramInt);
    AppMethodBeat.o(204623);
  }
  
  public final void a(ao paramao, long paramLong, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(204635);
    kotlin.g.b.s.u(paramao, "path");
    kotlin.g.b.s.u(paramf, "style");
    this.XU.a(paramao, paramLong, paramFloat, paramf, paramaa, paramInt);
    AppMethodBeat.o(204635);
  }
  
  public final void a(ao paramao, androidx.compose.ui.e.s params, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(204628);
    kotlin.g.b.s.u(paramao, "path");
    kotlin.g.b.s.u(params, "brush");
    kotlin.g.b.s.u(paramf, "style");
    this.XU.a(paramao, params, paramFloat, paramf, paramaa, paramInt);
    AppMethodBeat.o(204628);
  }
  
  public final void a(androidx.compose.ui.e.s params, long paramLong1, long paramLong2, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(204641);
    kotlin.g.b.s.u(params, "brush");
    kotlin.g.b.s.u(paramf, "style");
    this.XU.a(params, paramLong1, paramLong2, paramFloat, paramf, paramaa, paramInt);
    AppMethodBeat.o(204641);
  }
  
  public final void a(androidx.compose.ui.e.s params, long paramLong1, long paramLong2, long paramLong3, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(204652);
    kotlin.g.b.s.u(params, "brush");
    kotlin.g.b.s.u(paramf, "style");
    this.XU.a(params, paramLong1, paramLong2, paramLong3, paramFloat, paramf, paramaa, paramInt);
    AppMethodBeat.o(204652);
  }
  
  public final float bs(int paramInt)
  {
    AppMethodBeat.i(204600);
    float f = this.XU.bs(paramInt);
    AppMethodBeat.o(204600);
    return f;
  }
  
  public final n getLayoutDirection()
  {
    return this.XU.aAj.agm;
  }
  
  public final float mn()
  {
    AppMethodBeat.i(204610);
    float f = this.XU.mn();
    AppMethodBeat.o(204610);
    return f;
  }
  
  public final float mo()
  {
    AppMethodBeat.i(204615);
    float f = this.XU.mo();
    AppMethodBeat.o(204615);
    return f;
  }
  
  public final long sf()
  {
    AppMethodBeat.i(204675);
    long l = e.b.a(this.XU);
    AppMethodBeat.o(204675);
    return l;
  }
  
  public final long sx()
  {
    AppMethodBeat.i(204660);
    long l = this.XU.sx();
    AppMethodBeat.o(204660);
    return l;
  }
  
  public final float t(long paramLong)
  {
    AppMethodBeat.i(204592);
    float f = this.XU.t(paramLong);
    AppMethodBeat.o(204592);
    return f;
  }
  
  public final d uG()
  {
    return this.XU.aAk;
  }
  
  public final void uK()
  {
    AppMethodBeat.i(204679);
    u localu = ((e)this).uG().uH();
    j localj = this.aNN;
    if (localj != null) {
      localj.e(localu);
    }
    AppMethodBeat.o(204679);
  }
  
  public final int v(float paramFloat)
  {
    AppMethodBeat.i(204574);
    int i = this.XU.v(paramFloat);
    AppMethodBeat.o(204574);
    return i;
  }
  
  public final float w(float paramFloat)
  {
    AppMethodBeat.i(204580);
    paramFloat = this.XU.w(paramFloat);
    AppMethodBeat.o(204580);
    return paramFloat;
  }
  
  public final long x(float paramFloat)
  {
    AppMethodBeat.i(204587);
    long l = this.XU.x(paramFloat);
    AppMethodBeat.o(204587);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.h
 * JD-Core Version:    0.7.0.1
 */