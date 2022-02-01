package androidx.compose.ui.e.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode;", "", "isCurve", "", "isQuad", "(ZZ)V", "()Z", "ArcTo", "Close", "CurveTo", "HorizontalTo", "LineTo", "MoveTo", "QuadTo", "ReflectiveCurveTo", "ReflectiveQuadTo", "RelativeArcTo", "RelativeCurveTo", "RelativeHorizontalTo", "RelativeLineTo", "RelativeMoveTo", "RelativeQuadTo", "RelativeReflectiveCurveTo", "RelativeReflectiveQuadTo", "RelativeVerticalTo", "VerticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  final boolean aBE;
  final boolean aBF;
  
  private f(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aBE = paramBoolean1;
    this.aBF = paramBoolean2;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartX", "arcStartY", "(FFFZZFF)V", "getArcStartX", "()F", "getArcStartY", "getHorizontalEllipseRadius", "()Z", "getTheta", "getVerticalEllipseRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends f
  {
    final float aBG;
    final float aBH;
    final float aBI;
    final boolean aBJ;
    final boolean aBK;
    final float aBL;
    final float aBM;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      super(false, 3);
      this.aBG = paramFloat1;
      this.aBH = paramFloat2;
      this.aBI = paramFloat3;
      this.aBJ = paramBoolean1;
      this.aBK = paramBoolean2;
      this.aBL = paramFloat4;
      this.aBM = paramFloat5;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206300);
      if (this == paramObject)
      {
        AppMethodBeat.o(206300);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(206300);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(Float.valueOf(this.aBG), Float.valueOf(paramObject.aBG)))
      {
        AppMethodBeat.o(206300);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBH), Float.valueOf(paramObject.aBH)))
      {
        AppMethodBeat.o(206300);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBI), Float.valueOf(paramObject.aBI)))
      {
        AppMethodBeat.o(206300);
        return false;
      }
      if (this.aBJ != paramObject.aBJ)
      {
        AppMethodBeat.o(206300);
        return false;
      }
      if (this.aBK != paramObject.aBK)
      {
        AppMethodBeat.o(206300);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBL), Float.valueOf(paramObject.aBL)))
      {
        AppMethodBeat.o(206300);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBM), Float.valueOf(paramObject.aBM)))
      {
        AppMethodBeat.o(206300);
        return false;
      }
      AppMethodBeat.o(206300);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206284);
      String str = "ArcTo(horizontalEllipseRadius=" + this.aBG + ", verticalEllipseRadius=" + this.aBH + ", theta=" + this.aBI + ", isMoreThanHalf=" + this.aBJ + ", isPositiveArc=" + this.aBK + ", arcStartX=" + this.aBL + ", arcStartY=" + this.aBM + ')';
      AppMethodBeat.o(206284);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode;", "()V", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends f
  {
    public static final b aBN;
    
    static
    {
      AppMethodBeat.i(206277);
      aBN = new b();
      AppMethodBeat.o(206277);
    }
    
    private b()
    {
      super(false, 3);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "x3", "y3", "(FFFFFF)V", "getX1", "()F", "getX2", "getX3", "getY1", "getY2", "getY3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends f
  {
    final float x1;
    final float x2;
    final float x3;
    final float y1;
    final float y2;
    final float y3;
    
    public c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      super(false, 2);
      this.x1 = paramFloat1;
      this.y1 = paramFloat2;
      this.x2 = paramFloat3;
      this.y2 = paramFloat4;
      this.x3 = paramFloat5;
      this.y3 = paramFloat6;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206330);
      if (this == paramObject)
      {
        AppMethodBeat.o(206330);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(206330);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(Float.valueOf(this.x1), Float.valueOf(paramObject.x1)))
      {
        AppMethodBeat.o(206330);
        return false;
      }
      if (!s.p(Float.valueOf(this.y1), Float.valueOf(paramObject.y1)))
      {
        AppMethodBeat.o(206330);
        return false;
      }
      if (!s.p(Float.valueOf(this.x2), Float.valueOf(paramObject.x2)))
      {
        AppMethodBeat.o(206330);
        return false;
      }
      if (!s.p(Float.valueOf(this.y2), Float.valueOf(paramObject.y2)))
      {
        AppMethodBeat.o(206330);
        return false;
      }
      if (!s.p(Float.valueOf(this.x3), Float.valueOf(paramObject.x3)))
      {
        AppMethodBeat.o(206330);
        return false;
      }
      if (!s.p(Float.valueOf(this.y3), Float.valueOf(paramObject.y3)))
      {
        AppMethodBeat.o(206330);
        return false;
      }
      AppMethodBeat.o(206330);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206322);
      int i = Float.floatToIntBits(this.x1);
      int j = Float.floatToIntBits(this.y1);
      int k = Float.floatToIntBits(this.x2);
      int m = Float.floatToIntBits(this.y2);
      int n = Float.floatToIntBits(this.x3);
      int i1 = Float.floatToIntBits(this.y3);
      AppMethodBeat.o(206322);
      return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206313);
      String str = "CurveTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ", x3=" + this.x3 + ", y3=" + this.y3 + ')';
      AppMethodBeat.o(206313);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "(F)V", "getX", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends f
  {
    final float x;
    
    public d(float paramFloat)
    {
      super(false, 3);
      this.x = paramFloat;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206297);
      if (this == paramObject)
      {
        AppMethodBeat.o(206297);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        AppMethodBeat.o(206297);
        return false;
      }
      paramObject = (d)paramObject;
      if (!s.p(Float.valueOf(this.x), Float.valueOf(paramObject.x)))
      {
        AppMethodBeat.o(206297);
        return false;
      }
      AppMethodBeat.o(206297);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206295);
      int i = Float.floatToIntBits(this.x);
      AppMethodBeat.o(206295);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206287);
      String str = "HorizontalTo(x=" + this.x + ')';
      AppMethodBeat.o(206287);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends f
  {
    final float x;
    final float y;
    
    public e(float paramFloat1, float paramFloat2)
    {
      super(false, 3);
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206298);
      if (this == paramObject)
      {
        AppMethodBeat.o(206298);
        return true;
      }
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(206298);
        return false;
      }
      paramObject = (e)paramObject;
      if (!s.p(Float.valueOf(this.x), Float.valueOf(paramObject.x)))
      {
        AppMethodBeat.o(206298);
        return false;
      }
      if (!s.p(Float.valueOf(this.y), Float.valueOf(paramObject.y)))
      {
        AppMethodBeat.o(206298);
        return false;
      }
      AppMethodBeat.o(206298);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206293);
      int i = Float.floatToIntBits(this.x);
      int j = Float.floatToIntBits(this.y);
      AppMethodBeat.o(206293);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206286);
      String str = "LineTo(x=" + this.x + ", y=" + this.y + ')';
      AppMethodBeat.o(206286);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends f
  {
    final float x;
    final float y;
    
    public f(float paramFloat1, float paramFloat2)
    {
      super(false, 3);
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206299);
      if (this == paramObject)
      {
        AppMethodBeat.o(206299);
        return true;
      }
      if (!(paramObject instanceof f))
      {
        AppMethodBeat.o(206299);
        return false;
      }
      paramObject = (f)paramObject;
      if (!s.p(Float.valueOf(this.x), Float.valueOf(paramObject.x)))
      {
        AppMethodBeat.o(206299);
        return false;
      }
      if (!s.p(Float.valueOf(this.y), Float.valueOf(paramObject.y)))
      {
        AppMethodBeat.o(206299);
        return false;
      }
      AppMethodBeat.o(206299);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206294);
      int i = Float.floatToIntBits(this.x);
      int j = Float.floatToIntBits(this.y);
      AppMethodBeat.o(206294);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206288);
      String str = "MoveTo(x=" + this.x + ", y=" + this.y + ')';
      AppMethodBeat.o(206288);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends f
  {
    final float x1;
    final float x2;
    final float y1;
    final float y2;
    
    public g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      super(true, 1);
      this.x1 = paramFloat1;
      this.y1 = paramFloat2;
      this.x2 = paramFloat3;
      this.y2 = paramFloat4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206319);
      if (this == paramObject)
      {
        AppMethodBeat.o(206319);
        return true;
      }
      if (!(paramObject instanceof g))
      {
        AppMethodBeat.o(206319);
        return false;
      }
      paramObject = (g)paramObject;
      if (!s.p(Float.valueOf(this.x1), Float.valueOf(paramObject.x1)))
      {
        AppMethodBeat.o(206319);
        return false;
      }
      if (!s.p(Float.valueOf(this.y1), Float.valueOf(paramObject.y1)))
      {
        AppMethodBeat.o(206319);
        return false;
      }
      if (!s.p(Float.valueOf(this.x2), Float.valueOf(paramObject.x2)))
      {
        AppMethodBeat.o(206319);
        return false;
      }
      if (!s.p(Float.valueOf(this.y2), Float.valueOf(paramObject.y2)))
      {
        AppMethodBeat.o(206319);
        return false;
      }
      AppMethodBeat.o(206319);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206311);
      int i = Float.floatToIntBits(this.x1);
      int j = Float.floatToIntBits(this.y1);
      int k = Float.floatToIntBits(this.x2);
      int m = Float.floatToIntBits(this.y2);
      AppMethodBeat.o(206311);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206306);
      String str = "QuadTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ')';
      AppMethodBeat.o(206306);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends f
  {
    final float x1;
    final float x2;
    final float y1;
    final float y2;
    
    public h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      super(false, 2);
      this.x1 = paramFloat1;
      this.y1 = paramFloat2;
      this.x2 = paramFloat3;
      this.y2 = paramFloat4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206324);
      if (this == paramObject)
      {
        AppMethodBeat.o(206324);
        return true;
      }
      if (!(paramObject instanceof h))
      {
        AppMethodBeat.o(206324);
        return false;
      }
      paramObject = (h)paramObject;
      if (!s.p(Float.valueOf(this.x1), Float.valueOf(paramObject.x1)))
      {
        AppMethodBeat.o(206324);
        return false;
      }
      if (!s.p(Float.valueOf(this.y1), Float.valueOf(paramObject.y1)))
      {
        AppMethodBeat.o(206324);
        return false;
      }
      if (!s.p(Float.valueOf(this.x2), Float.valueOf(paramObject.x2)))
      {
        AppMethodBeat.o(206324);
        return false;
      }
      if (!s.p(Float.valueOf(this.y2), Float.valueOf(paramObject.y2)))
      {
        AppMethodBeat.o(206324);
        return false;
      }
      AppMethodBeat.o(206324);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206318);
      int i = Float.floatToIntBits(this.x1);
      int j = Float.floatToIntBits(this.y1);
      int k = Float.floatToIntBits(this.x2);
      int m = Float.floatToIntBits(this.y2);
      AppMethodBeat.o(206318);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206310);
      String str = "ReflectiveCurveTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ')';
      AppMethodBeat.o(206310);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends f
  {
    final float x;
    final float y;
    
    public i(float paramFloat1, float paramFloat2)
    {
      super(true, 1);
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206325);
      if (this == paramObject)
      {
        AppMethodBeat.o(206325);
        return true;
      }
      if (!(paramObject instanceof i))
      {
        AppMethodBeat.o(206325);
        return false;
      }
      paramObject = (i)paramObject;
      if (!s.p(Float.valueOf(this.x), Float.valueOf(paramObject.x)))
      {
        AppMethodBeat.o(206325);
        return false;
      }
      if (!s.p(Float.valueOf(this.y), Float.valueOf(paramObject.y)))
      {
        AppMethodBeat.o(206325);
        return false;
      }
      AppMethodBeat.o(206325);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206317);
      int i = Float.floatToIntBits(this.x);
      int j = Float.floatToIntBits(this.y);
      AppMethodBeat.o(206317);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206305);
      String str = "ReflectiveQuadTo(x=" + this.x + ", y=" + this.y + ')';
      AppMethodBeat.o(206305);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartDx", "arcStartDy", "(FFFZZFF)V", "getArcStartDx", "()F", "getArcStartDy", "getHorizontalEllipseRadius", "()Z", "getTheta", "getVerticalEllipseRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends f
  {
    final float aBG;
    final float aBH;
    final float aBI;
    final boolean aBJ;
    final boolean aBK;
    final float aBO;
    final float aBP;
    
    public j(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      super(false, 3);
      this.aBG = paramFloat1;
      this.aBH = paramFloat2;
      this.aBI = paramFloat3;
      this.aBJ = paramBoolean1;
      this.aBK = paramBoolean2;
      this.aBO = paramFloat4;
      this.aBP = paramFloat5;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206323);
      if (this == paramObject)
      {
        AppMethodBeat.o(206323);
        return true;
      }
      if (!(paramObject instanceof j))
      {
        AppMethodBeat.o(206323);
        return false;
      }
      paramObject = (j)paramObject;
      if (!s.p(Float.valueOf(this.aBG), Float.valueOf(paramObject.aBG)))
      {
        AppMethodBeat.o(206323);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBH), Float.valueOf(paramObject.aBH)))
      {
        AppMethodBeat.o(206323);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBI), Float.valueOf(paramObject.aBI)))
      {
        AppMethodBeat.o(206323);
        return false;
      }
      if (this.aBJ != paramObject.aBJ)
      {
        AppMethodBeat.o(206323);
        return false;
      }
      if (this.aBK != paramObject.aBK)
      {
        AppMethodBeat.o(206323);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBO), Float.valueOf(paramObject.aBO)))
      {
        AppMethodBeat.o(206323);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBP), Float.valueOf(paramObject.aBP)))
      {
        AppMethodBeat.o(206323);
        return false;
      }
      AppMethodBeat.o(206323);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206307);
      String str = "RelativeArcTo(horizontalEllipseRadius=" + this.aBG + ", verticalEllipseRadius=" + this.aBH + ", theta=" + this.aBI + ", isMoreThanHalf=" + this.aBJ + ", isPositiveArc=" + this.aBK + ", arcStartDx=" + this.aBO + ", arcStartDy=" + this.aBP + ')';
      AppMethodBeat.o(206307);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "dx3", "dy3", "(FFFFFF)V", "getDx1", "()F", "getDx2", "getDx3", "getDy1", "getDy2", "getDy3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends f
  {
    final float aBQ;
    final float aBR;
    final float aBS;
    final float aBT;
    final float aBU;
    final float aBV;
    
    public k(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      super(false, 2);
      this.aBQ = paramFloat1;
      this.aBR = paramFloat2;
      this.aBS = paramFloat3;
      this.aBT = paramFloat4;
      this.aBU = paramFloat5;
      this.aBV = paramFloat6;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206352);
      if (this == paramObject)
      {
        AppMethodBeat.o(206352);
        return true;
      }
      if (!(paramObject instanceof k))
      {
        AppMethodBeat.o(206352);
        return false;
      }
      paramObject = (k)paramObject;
      if (!s.p(Float.valueOf(this.aBQ), Float.valueOf(paramObject.aBQ)))
      {
        AppMethodBeat.o(206352);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBR), Float.valueOf(paramObject.aBR)))
      {
        AppMethodBeat.o(206352);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBS), Float.valueOf(paramObject.aBS)))
      {
        AppMethodBeat.o(206352);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBT), Float.valueOf(paramObject.aBT)))
      {
        AppMethodBeat.o(206352);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBU), Float.valueOf(paramObject.aBU)))
      {
        AppMethodBeat.o(206352);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBV), Float.valueOf(paramObject.aBV)))
      {
        AppMethodBeat.o(206352);
        return false;
      }
      AppMethodBeat.o(206352);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206345);
      int i = Float.floatToIntBits(this.aBQ);
      int j = Float.floatToIntBits(this.aBR);
      int k = Float.floatToIntBits(this.aBS);
      int m = Float.floatToIntBits(this.aBT);
      int n = Float.floatToIntBits(this.aBU);
      int i1 = Float.floatToIntBits(this.aBV);
      AppMethodBeat.o(206345);
      return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206337);
      String str = "RelativeCurveTo(dx1=" + this.aBQ + ", dy1=" + this.aBR + ", dx2=" + this.aBS + ", dy2=" + this.aBT + ", dx3=" + this.aBU + ", dy3=" + this.aBV + ')';
      AppMethodBeat.o(206337);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "(F)V", "getDx", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    extends f
  {
    final float aBW;
    
    public l(float paramFloat)
    {
      super(false, 3);
      this.aBW = paramFloat;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206346);
      if (this == paramObject)
      {
        AppMethodBeat.o(206346);
        return true;
      }
      if (!(paramObject instanceof l))
      {
        AppMethodBeat.o(206346);
        return false;
      }
      paramObject = (l)paramObject;
      if (!s.p(Float.valueOf(this.aBW), Float.valueOf(paramObject.aBW)))
      {
        AppMethodBeat.o(206346);
        return false;
      }
      AppMethodBeat.o(206346);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206338);
      int i = Float.floatToIntBits(this.aBW);
      AppMethodBeat.o(206338);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206332);
      String str = "RelativeHorizontalTo(dx=" + this.aBW + ')';
      AppMethodBeat.o(206332);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends f
  {
    final float aBW;
    final float aBX;
    
    public m(float paramFloat1, float paramFloat2)
    {
      super(false, 3);
      this.aBW = paramFloat1;
      this.aBX = paramFloat2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206326);
      if (this == paramObject)
      {
        AppMethodBeat.o(206326);
        return true;
      }
      if (!(paramObject instanceof m))
      {
        AppMethodBeat.o(206326);
        return false;
      }
      paramObject = (m)paramObject;
      if (!s.p(Float.valueOf(this.aBW), Float.valueOf(paramObject.aBW)))
      {
        AppMethodBeat.o(206326);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBX), Float.valueOf(paramObject.aBX)))
      {
        AppMethodBeat.o(206326);
        return false;
      }
      AppMethodBeat.o(206326);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206320);
      int i = Float.floatToIntBits(this.aBW);
      int j = Float.floatToIntBits(this.aBX);
      AppMethodBeat.o(206320);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206314);
      String str = "RelativeLineTo(dx=" + this.aBW + ", dy=" + this.aBX + ')';
      AppMethodBeat.o(206314);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    extends f
  {
    final float aBW;
    final float aBX;
    
    public n(float paramFloat1, float paramFloat2)
    {
      super(false, 3);
      this.aBW = paramFloat1;
      this.aBX = paramFloat2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206344);
      if (this == paramObject)
      {
        AppMethodBeat.o(206344);
        return true;
      }
      if (!(paramObject instanceof n))
      {
        AppMethodBeat.o(206344);
        return false;
      }
      paramObject = (n)paramObject;
      if (!s.p(Float.valueOf(this.aBW), Float.valueOf(paramObject.aBW)))
      {
        AppMethodBeat.o(206344);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBX), Float.valueOf(paramObject.aBX)))
      {
        AppMethodBeat.o(206344);
        return false;
      }
      AppMethodBeat.o(206344);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206334);
      int i = Float.floatToIntBits(this.aBW);
      int j = Float.floatToIntBits(this.aBX);
      AppMethodBeat.o(206334);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206327);
      String str = "RelativeMoveTo(dx=" + this.aBW + ", dy=" + this.aBX + ')';
      AppMethodBeat.o(206327);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "(FFFF)V", "getDx1", "()F", "getDx2", "getDy1", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    extends f
  {
    final float aBQ;
    final float aBR;
    final float aBS;
    final float aBT;
    
    public o(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      super(true, 1);
      this.aBQ = paramFloat1;
      this.aBR = paramFloat2;
      this.aBS = paramFloat3;
      this.aBT = paramFloat4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206348);
      if (this == paramObject)
      {
        AppMethodBeat.o(206348);
        return true;
      }
      if (!(paramObject instanceof o))
      {
        AppMethodBeat.o(206348);
        return false;
      }
      paramObject = (o)paramObject;
      if (!s.p(Float.valueOf(this.aBQ), Float.valueOf(paramObject.aBQ)))
      {
        AppMethodBeat.o(206348);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBR), Float.valueOf(paramObject.aBR)))
      {
        AppMethodBeat.o(206348);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBS), Float.valueOf(paramObject.aBS)))
      {
        AppMethodBeat.o(206348);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBT), Float.valueOf(paramObject.aBT)))
      {
        AppMethodBeat.o(206348);
        return false;
      }
      AppMethodBeat.o(206348);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206339);
      int i = Float.floatToIntBits(this.aBQ);
      int j = Float.floatToIntBits(this.aBR);
      int k = Float.floatToIntBits(this.aBS);
      int m = Float.floatToIntBits(this.aBT);
      AppMethodBeat.o(206339);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206333);
      String str = "RelativeQuadTo(dx1=" + this.aBQ + ", dy1=" + this.aBR + ", dx2=" + this.aBS + ", dy2=" + this.aBT + ')';
      AppMethodBeat.o(206333);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "(FFFF)V", "getDx1", "()F", "getDx2", "getDy1", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    extends f
  {
    final float aBQ;
    final float aBR;
    final float aBS;
    final float aBT;
    
    public p(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      super(false, 2);
      this.aBQ = paramFloat1;
      this.aBR = paramFloat2;
      this.aBS = paramFloat3;
      this.aBT = paramFloat4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206356);
      if (this == paramObject)
      {
        AppMethodBeat.o(206356);
        return true;
      }
      if (!(paramObject instanceof p))
      {
        AppMethodBeat.o(206356);
        return false;
      }
      paramObject = (p)paramObject;
      if (!s.p(Float.valueOf(this.aBQ), Float.valueOf(paramObject.aBQ)))
      {
        AppMethodBeat.o(206356);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBR), Float.valueOf(paramObject.aBR)))
      {
        AppMethodBeat.o(206356);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBS), Float.valueOf(paramObject.aBS)))
      {
        AppMethodBeat.o(206356);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBT), Float.valueOf(paramObject.aBT)))
      {
        AppMethodBeat.o(206356);
        return false;
      }
      AppMethodBeat.o(206356);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206347);
      int i = Float.floatToIntBits(this.aBQ);
      int j = Float.floatToIntBits(this.aBR);
      int k = Float.floatToIntBits(this.aBS);
      int m = Float.floatToIntBits(this.aBT);
      AppMethodBeat.o(206347);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206340);
      String str = "RelativeReflectiveCurveTo(dx1=" + this.aBQ + ", dy1=" + this.aBR + ", dx2=" + this.aBS + ", dy2=" + this.aBT + ')';
      AppMethodBeat.o(206340);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    extends f
  {
    final float aBW;
    final float aBX;
    
    public q(float paramFloat1, float paramFloat2)
    {
      super(true, 1);
      this.aBW = paramFloat1;
      this.aBX = paramFloat2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206364);
      if (this == paramObject)
      {
        AppMethodBeat.o(206364);
        return true;
      }
      if (!(paramObject instanceof q))
      {
        AppMethodBeat.o(206364);
        return false;
      }
      paramObject = (q)paramObject;
      if (!s.p(Float.valueOf(this.aBW), Float.valueOf(paramObject.aBW)))
      {
        AppMethodBeat.o(206364);
        return false;
      }
      if (!s.p(Float.valueOf(this.aBX), Float.valueOf(paramObject.aBX)))
      {
        AppMethodBeat.o(206364);
        return false;
      }
      AppMethodBeat.o(206364);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206358);
      int i = Float.floatToIntBits(this.aBW);
      int j = Float.floatToIntBits(this.aBX);
      AppMethodBeat.o(206358);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206351);
      String str = "RelativeReflectiveQuadTo(dx=" + this.aBW + ", dy=" + this.aBX + ')';
      AppMethodBeat.o(206351);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dy", "", "(F)V", "getDy", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    extends f
  {
    final float aBX;
    
    public r(float paramFloat)
    {
      super(false, 3);
      this.aBX = paramFloat;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206342);
      if (this == paramObject)
      {
        AppMethodBeat.o(206342);
        return true;
      }
      if (!(paramObject instanceof r))
      {
        AppMethodBeat.o(206342);
        return false;
      }
      paramObject = (r)paramObject;
      if (!s.p(Float.valueOf(this.aBX), Float.valueOf(paramObject.aBX)))
      {
        AppMethodBeat.o(206342);
        return false;
      }
      AppMethodBeat.o(206342);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206335);
      int i = Float.floatToIntBits(this.aBX);
      AppMethodBeat.o(206335);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206329);
      String str = "RelativeVerticalTo(dy=" + this.aBX + ')';
      AppMethodBeat.o(206329);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "y", "", "(F)V", "getY", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    extends f
  {
    final float y;
    
    public s(float paramFloat)
    {
      super(false, 3);
      this.y = paramFloat;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206349);
      if (this == paramObject)
      {
        AppMethodBeat.o(206349);
        return true;
      }
      if (!(paramObject instanceof s))
      {
        AppMethodBeat.o(206349);
        return false;
      }
      paramObject = (s)paramObject;
      if (!s.p(Float.valueOf(this.y), Float.valueOf(paramObject.y)))
      {
        AppMethodBeat.o(206349);
        return false;
      }
      AppMethodBeat.o(206349);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206343);
      int i = Float.floatToIntBits(this.y);
      AppMethodBeat.o(206343);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206336);
      String str = "VerticalTo(y=" + this.y + ')';
      AppMethodBeat.o(206336);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.f
 * JD-Core Version:    0.7.0.1
 */