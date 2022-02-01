package androidx.compose.foundation;

import androidx.compose.runtime.h;
import androidx.compose.ui.d.a;
import androidx.compose.ui.e.ak.a;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.ba;
import androidx.compose.ui.i.ac;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"createInsetRoundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "widthPx", "", "roundedRect", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "strokeWidth", "fillArea", "", "border", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawGenericBorder", "borderCacheRef", "Landroidx/compose/ui/node/Ref;", "Landroidx/compose/foundation/BorderCache;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "strokeWidthPx", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "drawRoundRectBorder-SYlcjDY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/node/Ref;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "obtain", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final androidx.compose.ui.f a(androidx.compose.ui.f paramf, float paramFloat, long paramLong, ay paramay)
  {
    AppMethodBeat.i(203614);
    kotlin.g.b.s.u(paramf, "$this$border");
    kotlin.g.b.s.u(paramay, "shape");
    paramf = a(paramf, paramFloat, (androidx.compose.ui.e.s)new ba(paramLong, (byte)0), paramay);
    AppMethodBeat.o(203614);
    return paramf;
  }
  
  private static androidx.compose.ui.f a(androidx.compose.ui.f paramf, float paramFloat, final androidx.compose.ui.e.s params, final ay paramay)
  {
    AppMethodBeat.i(203621);
    kotlin.g.b.s.u(paramf, "$this$border");
    kotlin.g.b.s.u(params, "brush");
    kotlin.g.b.s.u(paramay, "shape");
    if (ab.zi()) {}
    for (kotlin.g.a.b localb = (kotlin.g.a.b)new b(paramFloat, params, paramay);; localb = ab.zh())
    {
      paramf = androidx.compose.ui.e.a(paramf, localb, (q)new a(paramFloat, paramay, params));
      AppMethodBeat.o(203621);
      return paramf;
    }
  }
  
  public static final androidx.compose.ui.f a(androidx.compose.ui.f paramf, e parame, ay paramay)
  {
    AppMethodBeat.i(203605);
    kotlin.g.b.s.u(paramf, "<this>");
    kotlin.g.b.s.u(parame, "border");
    kotlin.g.b.s.u(paramay, "shape");
    paramf = a(paramf, parame.width, parame.XJ, paramay);
    AppMethodBeat.o(203605);
    return paramf;
  }
  
  static final long c(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(203625);
    paramLong = androidx.compose.ui.d.b.v(Math.max(0.0F, a.F(paramLong) - paramFloat), Math.max(0.0F, a.G(paramLong) - paramFloat));
    AppMethodBeat.o(203625);
    return paramLong;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<androidx.compose.ui.f, h, Integer, androidx.compose.ui.f>
  {
    a(float paramFloat, ay paramay, androidx.compose.ui.e.s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.b<ad, ah>
  {
    public b(float paramFloat, androidx.compose.ui.e.s params, ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<androidx.compose.ui.e.b.c, ah>
  {
    public static final c Yb;
    
    static
    {
      AppMethodBeat.i(203669);
      Yb = new c();
      AppMethodBeat.o(203669);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<androidx.compose.ui.e.b.c, ah>
  {
    d(ak.a parama, androidx.compose.ui.e.s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<androidx.compose.ui.e.b.c, ah>
  {
    e(androidx.compose.ui.e.s params, long paramLong1, long paramLong2, androidx.compose.ui.e.b.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<androidx.compose.ui.e.b.c, ah>
  {
    f(boolean paramBoolean, androidx.compose.ui.e.s params, long paramLong1, float paramFloat1, float paramFloat2, long paramLong2, long paramLong3, androidx.compose.ui.e.b.j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<androidx.compose.ui.e.b.c, ah>
  {
    g(ao paramao, androidx.compose.ui.e.s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.d
 * JD-Core Version:    0.7.0.1
 */