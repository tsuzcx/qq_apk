package androidx.compose.foundation.e;

import androidx.compose.ui.d.k;
import androidx.compose.ui.e.ak;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getBottomEnd", "()Landroidx/compose/foundation/shape/CornerSize;", "getBottomStart", "getTopEnd", "getTopStart", "copy", "all", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements ay
{
  private final b agC;
  private final b agD;
  private final b agE;
  private final b agF;
  
  public a(b paramb1, b paramb2, b paramb3, b paramb4)
  {
    this.agC = paramb1;
    this.agD = paramb2;
    this.agE = paramb3;
    this.agF = paramb4;
  }
  
  public abstract ak a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, n paramn);
  
  public final ak a(long paramLong, n paramn, d paramd)
  {
    s.u(paramn, "layoutDirection");
    s.u(paramd, "density");
    float f4 = this.agC.a(paramLong, paramd);
    float f6 = this.agD.a(paramLong, paramd);
    float f5 = this.agE.a(paramLong, paramd);
    float f3 = this.agF.a(paramLong, paramd);
    float f7 = k.T(paramLong);
    float f2 = f4;
    float f1 = f3;
    if (f4 + f3 > f7)
    {
      f1 = f7 / (f4 + f3);
      f2 = f4 * f1;
      f1 = f3 * f1;
    }
    f4 = f6;
    f3 = f5;
    if (f6 + f5 > f7)
    {
      f3 = f7 / (f6 + f5);
      f4 = f6 * f3;
      f3 = f5 * f3;
    }
    if ((f2 >= 0.0F) && (f4 >= 0.0F) && (f3 >= 0.0F) && (f1 >= 0.0F)) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + f2 + ", topEnd = " + f4 + ", bottomEnd = " + f3 + ", bottomStart = " + f1 + ")!").toString()));
    }
    return a(paramLong, f2, f4, f3, f1, paramn);
  }
  
  public final b mS()
  {
    return this.agC;
  }
  
  public final b mT()
  {
    return this.agD;
  }
  
  public final b mU()
  {
    return this.agE;
  }
  
  public final b mV()
  {
    return this.agF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.e.a
 * JD-Core Version:    0.7.0.1
 */