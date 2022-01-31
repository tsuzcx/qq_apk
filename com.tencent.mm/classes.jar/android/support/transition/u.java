package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class u<T>
  extends Property<T, Float>
{
  private final PathMeasure oA;
  private final Property<T, PointF> sg;
  private final float si;
  private final float[] sj = new float[2];
  private final PointF sk = new PointF();
  private float sl;
  
  u(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.sg = paramProperty;
    this.oA = new PathMeasure(paramPath, false);
    this.si = this.oA.getLength();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.u
 * JD-Core Version:    0.7.0.1
 */