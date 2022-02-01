package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class k<T>
  extends Property<T, Float>
{
  private final Property<T, PointF> Br;
  private final float Bs;
  private final float[] Bt = new float[2];
  private final PointF Bu = new PointF();
  private float Bv;
  private final PathMeasure xT;
  
  k(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.Br = paramProperty;
    this.xT = new PathMeasure(paramPath, false);
    this.Bs = this.xT.getLength();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.k
 * JD-Core Version:    0.7.0.1
 */