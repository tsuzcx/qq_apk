package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class k<T>
  extends Property<T, Float>
{
  private final PathMeasure wa;
  private final Property<T, PointF> zA;
  private final float zB;
  private final float[] zC = new float[2];
  private final PointF zD = new PointF();
  private float zE;
  
  k(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.zA = paramProperty;
    this.wa = new PathMeasure(paramPath, false);
    this.zB = this.wa.getLength();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.k
 * JD-Core Version:    0.7.0.1
 */