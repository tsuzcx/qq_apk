package androidx.compose.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/geometry/Rect;", "", "left", "", "top", "right", "bottom", "(FFFF)V", "getBottom$annotations", "()V", "getBottom", "()F", "bottomCenter", "Landroidx/compose/ui/geometry/Offset;", "getBottomCenter-F1C5BW0", "()J", "bottomLeft", "getBottomLeft-F1C5BW0", "bottomRight", "getBottomRight-F1C5BW0", "center", "getCenter-F1C5BW0", "centerLeft", "getCenterLeft-F1C5BW0", "centerRight", "getCenterRight-F1C5BW0", "height", "getHeight$annotations", "getHeight", "isEmpty", "", "isEmpty$annotations", "()Z", "isFinite", "isFinite$annotations", "isInfinite", "isInfinite$annotations", "getLeft$annotations", "getLeft", "maxDimension", "getMaxDimension", "minDimension", "getMinDimension", "getRight$annotations", "getRight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc$annotations", "getSize-NH-jbRc", "getTop$annotations", "getTop", "topCenter", "getTopCenter-F1C5BW0", "topLeft", "getTopLeft-F1C5BW0", "topRight", "getTopRight-F1C5BW0", "width", "getWidth$annotations", "getWidth", "component1", "component2", "component3", "component4", "contains", "offset", "contains-k-4lQ0M", "(J)Z", "copy", "deflate", "delta", "equals", "other", "hashCode", "", "inflate", "intersect", "overlaps", "toString", "", "translate", "translate-k-4lQ0M", "(J)Landroidx/compose/ui/geometry/Rect;", "translateX", "translateY", "Companion", "ui-geometry_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a avs;
  private static final g avt;
  public final float bottom;
  public final float left;
  public final float right;
  public final float top;
  
  static
  {
    AppMethodBeat.i(205570);
    avs = new g.a((byte)0);
    avt = new g(0.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(205570);
  }
  
  public g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = paramFloat3;
    this.bottom = paramFloat4;
  }
  
  public final g P(long paramLong)
  {
    AppMethodBeat.i(205584);
    g localg = new g(this.left + e.F(paramLong), this.top + e.G(paramLong), this.right + e.F(paramLong), this.bottom + e.G(paramLong));
    AppMethodBeat.o(205584);
    return localg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205617);
    if (this == paramObject)
    {
      AppMethodBeat.o(205617);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(205617);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(Float.valueOf(this.left), Float.valueOf(paramObject.left)))
    {
      AppMethodBeat.o(205617);
      return false;
    }
    if (!s.p(Float.valueOf(this.top), Float.valueOf(paramObject.top)))
    {
      AppMethodBeat.o(205617);
      return false;
    }
    if (!s.p(Float.valueOf(this.right), Float.valueOf(paramObject.right)))
    {
      AppMethodBeat.o(205617);
      return false;
    }
    if (!s.p(Float.valueOf(this.bottom), Float.valueOf(paramObject.bottom)))
    {
      AppMethodBeat.o(205617);
      return false;
    }
    AppMethodBeat.o(205617);
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
    AppMethodBeat.i(205610);
    int i = Float.floatToIntBits(this.left);
    int j = Float.floatToIntBits(this.top);
    int k = Float.floatToIntBits(this.right);
    int m = Float.floatToIntBits(this.bottom);
    AppMethodBeat.o(205610);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final long sx()
  {
    AppMethodBeat.i(205598);
    long l = f.x(this.left + getWidth() / 2.0F, this.top + getHeight() / 2.0F);
    AppMethodBeat.o(205598);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205606);
    String str = "Rect.fromLTRB(" + c.I(this.left) + ", " + c.I(this.top) + ", " + c.I(this.right) + ", " + c.I(this.bottom) + ')';
    AppMethodBeat.o(205606);
    return str;
  }
  
  public final g y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205589);
    g localg = new g(this.left + paramFloat1, this.top + paramFloat2, this.right + paramFloat1, this.bottom + paramFloat2);
    AppMethodBeat.o(205589);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.g
 * JD-Core Version:    0.7.0.1
 */