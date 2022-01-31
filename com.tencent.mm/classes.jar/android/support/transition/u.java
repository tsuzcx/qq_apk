package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class u<T>
  extends Property<T, Float>
{
  private final PathMeasure nC;
  private final Property<T, PointF> ri;
  private final float rj;
  private final float[] rk = new float[2];
  private final PointF rl = new PointF();
  private float rm;
  
  u(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.ri = paramProperty;
    this.nC = new PathMeasure(paramPath, false);
    this.rj = this.nC.getLength();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.u
 * JD-Core Version:    0.7.0.1
 */