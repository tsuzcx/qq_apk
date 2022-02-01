package androidx.compose.ui.e.b;

import androidx.compose.ui.d.k;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.af;
import androidx.compose.ui.e.am;
import androidx.compose.ui.e.an;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.bb;
import androidx.compose.ui.e.bc;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.z;
import androidx.compose.ui.n.d.a;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "()V", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "strokePaint", "configurePaint", "brush", "Landroidx/compose/ui/graphics/Brush;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "configurePaint-UXdrQoc", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "configurePaint-46ZPVWY", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "strokeWidth", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "configureStrokePaint-ApHOwBQ", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-TuZ1BDo", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)Landroidx/compose/ui/graphics/Paint;", "draw", "", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "start", "end", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements e
{
  public final a aAj;
  public final d aAk;
  private am aAl;
  private am aAm;
  
  public a()
  {
    AppMethodBeat.i(206143);
    this.aAj = new a();
    this.aAk = ((d)new b(this));
    AppMethodBeat.o(206143);
  }
  
  private final am a(long paramLong, f paramf, float paramFloat, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206159);
    paramf = a(paramf);
    paramLong = h(paramLong, paramFloat);
    if (!z.e(paramf.sF(), paramLong)) {
      paramf.W(paramLong);
    }
    if (paramf.sK() != null) {
      paramf.a(null);
    }
    if (!kotlin.g.b.s.p(paramf.sL(), paramaa)) {
      paramf.b(paramaa);
    }
    if (!androidx.compose.ui.e.p.C(paramf.sG(), paramInt)) {
      paramf.cB(paramInt);
    }
    AppMethodBeat.o(206159);
    return paramf;
  }
  
  private final am a(f paramf)
  {
    AppMethodBeat.i(206150);
    Object localObject1;
    if (kotlin.g.b.s.p(paramf, i.aAu))
    {
      paramf = this.aAl;
      if (paramf == null)
      {
        paramf = androidx.compose.ui.e.i.sN();
        localObject1 = an.axO;
        paramf.cC(an.tG());
        this.aAl = paramf;
        AppMethodBeat.o(206150);
        return paramf;
      }
      AppMethodBeat.o(206150);
      return paramf;
    }
    if ((paramf instanceof j))
    {
      Object localObject2 = this.aAm;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = androidx.compose.ui.e.i.sN();
        localObject2 = an.axO;
        ((am)localObject1).cC(an.tH());
        this.aAm = ((am)localObject1);
      }
      if (((am)localObject1).getStrokeWidth() == ((j)paramf).width)
      {
        i = 1;
        if (i == 0) {
          ((am)localObject1).setStrokeWidth(((j)paramf).width);
        }
        if (!bb.C(((am)localObject1).sH(), ((j)paramf).aAx)) {
          ((am)localObject1).cD(((j)paramf).aAx);
        }
        if (((am)localObject1).sJ() != ((j)paramf).aAw) {
          break label284;
        }
      }
      label284:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          ((am)localObject1).J(((j)paramf).aAw);
        }
        if (!bc.C(((am)localObject1).sI(), ((j)paramf).aAy)) {
          ((am)localObject1).cE(((j)paramf).aAy);
        }
        if (!kotlin.g.b.s.p(((am)localObject1).sM(), ((j)paramf).avL)) {
          ((am)localObject1).a(((j)paramf).avL);
        }
        AppMethodBeat.o(206150);
        return localObject1;
        i = 0;
        break;
      }
    }
    paramf = new kotlin.p();
    AppMethodBeat.o(206150);
    throw paramf;
  }
  
  private final am a(androidx.compose.ui.e.s params, f paramf, float paramFloat, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206155);
    paramf = a(paramf);
    if (params != null) {
      params.a(e.b.a(this), paramf, paramFloat);
    }
    label111:
    for (;;)
    {
      if (!kotlin.g.b.s.p(paramf.sL(), paramaa)) {
        paramf.b(paramaa);
      }
      if (!androidx.compose.ui.e.p.C(paramf.sG(), paramInt)) {
        paramf.cB(paramInt);
      }
      AppMethodBeat.o(206155);
      return paramf;
      if (paramf.getAlpha() == paramFloat) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label111;
        }
        paramf.setAlpha(paramFloat);
        break;
      }
    }
  }
  
  private static long h(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(206162);
    if (paramFloat == 1.0F) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramLong = z.g(paramLong, z.ac(paramLong) * paramFloat);
      AppMethodBeat.o(206162);
      return paramLong;
    }
    AppMethodBeat.o(206162);
    return paramLong;
  }
  
  public final void a(long paramLong1, float paramFloat1, long paramLong2, float paramFloat2, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206206);
    kotlin.g.b.s.u(paramf, "style");
    this.aAj.XT.a(paramLong2, paramFloat1, a(paramLong1, paramf, paramFloat2, paramaa, paramInt));
    AppMethodBeat.o(206206);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206188);
    kotlin.g.b.s.u(paramf, "style");
    this.aAj.XT.a(androidx.compose.ui.d.e.F(paramLong2), androidx.compose.ui.d.e.G(paramLong2), androidx.compose.ui.d.e.F(paramLong2) + k.Q(paramLong3), androidx.compose.ui.d.e.G(paramLong2) + k.R(paramLong3), a(paramLong1, paramf, paramFloat, paramaa, paramInt));
    AppMethodBeat.o(206188);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, f paramf, float paramFloat, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206202);
    kotlin.g.b.s.u(paramf, "style");
    this.aAj.XT.a(androidx.compose.ui.d.e.F(paramLong2), androidx.compose.ui.d.e.G(paramLong2), androidx.compose.ui.d.e.F(paramLong2) + k.Q(paramLong3), androidx.compose.ui.d.e.G(paramLong2) + k.R(paramLong3), androidx.compose.ui.d.a.F(paramLong4), androidx.compose.ui.d.a.G(paramLong4), a(paramLong1, paramf, paramFloat, paramaa, paramInt));
    AppMethodBeat.o(206202);
  }
  
  public final void a(af paramaf, long paramLong1, long paramLong2, long paramLong3, long paramLong4, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206192);
    kotlin.g.b.s.u(paramaf, "image");
    kotlin.g.b.s.u(paramf, "style");
    this.aAj.XT.a(paramaf, paramLong1, paramLong2, paramLong3, paramLong4, a(null, paramf, paramFloat, paramaa, paramInt));
    AppMethodBeat.o(206192);
  }
  
  public final void a(ao paramao, long paramLong, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206211);
    kotlin.g.b.s.u(paramao, "path");
    kotlin.g.b.s.u(paramf, "style");
    this.aAj.XT.a(paramao, a(paramLong, paramf, paramFloat, paramaa, paramInt));
    AppMethodBeat.o(206211);
  }
  
  public final void a(ao paramao, androidx.compose.ui.e.s params, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206215);
    kotlin.g.b.s.u(paramao, "path");
    kotlin.g.b.s.u(params, "brush");
    kotlin.g.b.s.u(paramf, "style");
    this.aAj.XT.a(paramao, a(params, paramf, paramFloat, paramaa, paramInt));
    AppMethodBeat.o(206215);
  }
  
  public final void a(androidx.compose.ui.e.s params, long paramLong1, long paramLong2, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206185);
    kotlin.g.b.s.u(params, "brush");
    kotlin.g.b.s.u(paramf, "style");
    this.aAj.XT.a(androidx.compose.ui.d.e.F(paramLong1), androidx.compose.ui.d.e.G(paramLong1), androidx.compose.ui.d.e.F(paramLong1) + k.Q(paramLong2), androidx.compose.ui.d.e.G(paramLong1) + k.R(paramLong2), a(params, paramf, paramFloat, paramaa, paramInt));
    AppMethodBeat.o(206185);
  }
  
  public final void a(androidx.compose.ui.e.s params, long paramLong1, long paramLong2, long paramLong3, float paramFloat, f paramf, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(206196);
    kotlin.g.b.s.u(params, "brush");
    kotlin.g.b.s.u(paramf, "style");
    this.aAj.XT.a(androidx.compose.ui.d.e.F(paramLong1), androidx.compose.ui.d.e.G(paramLong1), androidx.compose.ui.d.e.F(paramLong1) + k.Q(paramLong2), androidx.compose.ui.d.e.G(paramLong1) + k.R(paramLong2), androidx.compose.ui.d.a.F(paramLong3), androidx.compose.ui.d.a.G(paramLong3), a(params, paramf, paramFloat, paramaa, paramInt));
    AppMethodBeat.o(206196);
  }
  
  public final float bs(int paramInt)
  {
    AppMethodBeat.i(206240);
    e locale = (e)this;
    kotlin.g.b.s.u(locale, "this");
    float f = d.a.a((androidx.compose.ui.n.d)locale, paramInt);
    AppMethodBeat.o(206240);
    return f;
  }
  
  public final n getLayoutDirection()
  {
    return this.aAj.agm;
  }
  
  public final float mn()
  {
    AppMethodBeat.i(206172);
    float f = this.aAj.TD.mn();
    AppMethodBeat.o(206172);
    return f;
  }
  
  public final float mo()
  {
    AppMethodBeat.i(206177);
    float f = this.aAj.TD.mo();
    AppMethodBeat.o(206177);
    return f;
  }
  
  public final long sf()
  {
    AppMethodBeat.i(369519);
    long l = e.b.a(this);
    AppMethodBeat.o(369519);
    return l;
  }
  
  public final long sx()
  {
    AppMethodBeat.i(206243);
    kotlin.g.b.s.u(this, "this");
    long l = uG().sf();
    l = androidx.compose.ui.d.f.x(k.Q(l) / 2.0F, k.R(l) / 2.0F);
    AppMethodBeat.o(206243);
    return l;
  }
  
  public final float t(long paramLong)
  {
    AppMethodBeat.i(206235);
    e locale = (e)this;
    kotlin.g.b.s.u(locale, "this");
    float f = d.a.a((androidx.compose.ui.n.d)locale, paramLong);
    AppMethodBeat.o(206235);
    return f;
  }
  
  public final d uG()
  {
    return this.aAk;
  }
  
  public final int v(float paramFloat)
  {
    AppMethodBeat.i(206221);
    e locale = (e)this;
    kotlin.g.b.s.u(locale, "this");
    int i = d.a.b((androidx.compose.ui.n.d)locale, paramFloat);
    AppMethodBeat.o(206221);
    return i;
  }
  
  public final float w(float paramFloat)
  {
    AppMethodBeat.i(206225);
    e locale = (e)this;
    kotlin.g.b.s.u(locale, "this");
    paramFloat = d.a.a((androidx.compose.ui.n.d)locale, paramFloat);
    AppMethodBeat.o(206225);
    return paramFloat;
  }
  
  public final long x(float paramFloat)
  {
    AppMethodBeat.i(206228);
    e locale = (e)this;
    kotlin.g.b.s.u(locale, "this");
    long l = d.a.c((androidx.compose.ui.n.d)locale, paramFloat);
    AppMethodBeat.o(206228);
    return l;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public androidx.compose.ui.n.d TD;
    public u XT;
    public n agm;
    public long size;
    
    private a(androidx.compose.ui.n.d paramd, n paramn, u paramu, long paramLong)
    {
      this.TD = paramd;
      this.agm = paramn;
      this.XT = paramu;
      this.size = paramLong;
    }
    
    public final void b(u paramu)
    {
      AppMethodBeat.i(206145);
      kotlin.g.b.s.u(paramu, "<set-?>");
      this.XT = paramu;
      AppMethodBeat.o(206145);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206160);
      if (this == paramObject)
      {
        AppMethodBeat.o(206160);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(206160);
        return false;
      }
      paramObject = (a)paramObject;
      if (!kotlin.g.b.s.p(this.TD, paramObject.TD))
      {
        AppMethodBeat.o(206160);
        return false;
      }
      if (this.agm != paramObject.agm)
      {
        AppMethodBeat.o(206160);
        return false;
      }
      if (!kotlin.g.b.s.p(this.XT, paramObject.XT))
      {
        AppMethodBeat.o(206160);
        return false;
      }
      if (!k.e(this.size, paramObject.size))
      {
        AppMethodBeat.o(206160);
        return false;
      }
      AppMethodBeat.o(206160);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206157);
      int i = this.TD.hashCode();
      int j = this.agm.hashCode();
      int k = this.XT.hashCode();
      int m = k.I(this.size);
      AppMethodBeat.o(206157);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final void setDensity(androidx.compose.ui.n.d paramd)
    {
      AppMethodBeat.i(206133);
      kotlin.g.b.s.u(paramd, "<set-?>");
      this.TD = paramd;
      AppMethodBeat.o(206133);
    }
    
    public final void setLayoutDirection(n paramn)
    {
      AppMethodBeat.i(206140);
      kotlin.g.b.s.u(paramn, "<set-?>");
      this.agm = paramn;
      AppMethodBeat.o(206140);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206151);
      String str = "DrawParams(density=" + this.TD + ", layoutDirection=" + this.agm + ", canvas=" + this.XT + ", size=" + k.H(this.size) + ')';
      AppMethodBeat.o(206151);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/graphics/drawscope/CanvasDrawScope$drawContext$1", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "transform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "getTransform", "()Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d
  {
    private final g aAn;
    
    b(a parama)
    {
      AppMethodBeat.i(206084);
      this.aAn = b.a((d)this);
      AppMethodBeat.o(206084);
    }
    
    public final void ao(long paramLong)
    {
      this.aAo.aAj.size = paramLong;
    }
    
    public final long sf()
    {
      return this.aAo.aAj.size;
    }
    
    public final u uH()
    {
      return this.aAo.aAj.XT;
    }
    
    public final g uI()
    {
      return this.aAn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.b.a
 * JD-Core Version:    0.7.0.1
 */