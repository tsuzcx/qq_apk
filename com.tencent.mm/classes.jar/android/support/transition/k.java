package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class k<T>
  extends Property<T, Float>
{
  private final PointF BA = new PointF();
  private float BB;
  private final Property<T, PointF> Bx;
  private final float By;
  private final float[] Bz = new float[2];
  private final PathMeasure xZ;
  
  k(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.Bx = paramProperty;
    this.xZ = new PathMeasure(paramPath, false);
    this.By = this.xZ.getLength();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.k
 * JD-Core Version:    0.7.0.1
 */