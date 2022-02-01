package androidx.compose.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_scaledRadiiRect", "getBottom", "()F", "getBottomLeftCornerRadius-kKHJgLs", "()J", "J", "getBottomRightCornerRadius-kKHJgLs", "height", "getHeight", "getLeft", "getRight", "getTop", "getTopLeftCornerRadius-kKHJgLs", "getTopRightCornerRadius-kKHJgLs", "width", "getWidth", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "minRadius", "min", "radius1", "radius2", "limit", "scaledRadiiRect", "toString", "", "Companion", "ui-geometry_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a avu;
  private static final i avz;
  public final long avv;
  public final long avw;
  public final long avx;
  public final long avy;
  public final float bottom;
  public final float left;
  public final float right;
  public final float top;
  
  static
  {
    AppMethodBeat.i(205567);
    avu = new i.a((byte)0);
    a.a locala = a.avm;
    long l = a.su();
    l = b.v(a.F(l), a.G(l));
    avz = new i(0.0F, 0.0F, 0.0F, 0.0F, l, l, l, l, (byte)0);
    AppMethodBeat.o(205567);
  }
  
  private i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = paramFloat3;
    this.bottom = paramFloat4;
    this.avv = paramLong1;
    this.avw = paramLong2;
    this.avx = paramLong3;
    this.avy = paramLong4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205600);
    if (this == paramObject)
    {
      AppMethodBeat.o(205600);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(Float.valueOf(this.left), Float.valueOf(paramObject.left)))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    if (!s.p(Float.valueOf(this.top), Float.valueOf(paramObject.top)))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    if (!s.p(Float.valueOf(this.right), Float.valueOf(paramObject.right)))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    if (!s.p(Float.valueOf(this.bottom), Float.valueOf(paramObject.bottom)))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    if (!a.e(this.avv, paramObject.avv))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    if (!a.e(this.avw, paramObject.avw))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    if (!a.e(this.avx, paramObject.avx))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    if (!a.e(this.avy, paramObject.avy))
    {
      AppMethodBeat.o(205600);
      return false;
    }
    AppMethodBeat.o(205600);
    return true;
  }
  
  public final float getHeight()
  {
    return this.bottom - this.top;
  }
  
  public final float getWidth()
  {
    return this.right - this.left;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205591);
    int i = Float.floatToIntBits(this.left);
    int j = Float.floatToIntBits(this.top);
    int k = Float.floatToIntBits(this.right);
    int m = Float.floatToIntBits(this.bottom);
    int n = a.I(this.avv);
    int i1 = a.I(this.avw);
    int i2 = a.I(this.avx);
    int i3 = a.I(this.avy);
    AppMethodBeat.o(205591);
    return ((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205583);
    long l1 = this.avv;
    long l2 = this.avw;
    long l3 = this.avx;
    long l4 = this.avy;
    String str = c.I(this.left) + ", " + c.I(this.top) + ", " + c.I(this.right) + ", " + c.I(this.bottom);
    if ((a.e(l1, l2)) && (a.e(l2, l3)) && (a.e(l3, l4)))
    {
      if (a.F(l1) == a.G(l1)) {}
      for (int i = 1; i != 0; i = 0)
      {
        str = "RoundRect(rect=" + str + ", radius=" + c.I(a.F(l1)) + ')';
        AppMethodBeat.o(205583);
        return str;
      }
      str = "RoundRect(rect=" + str + ", x=" + c.I(a.F(l1)) + ", y=" + c.I(a.G(l1)) + ')';
      AppMethodBeat.o(205583);
      return str;
    }
    str = "RoundRect(rect=" + str + ", topLeft=" + a.H(l1) + ", topRight=" + a.H(l2) + ", bottomRight=" + a.H(l3) + ", bottomLeft=" + a.H(l4) + ')';
    AppMethodBeat.o(205583);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.i
 * JD-Core Version:    0.7.0.1
 */