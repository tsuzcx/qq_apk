package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class k<T>
  extends Property<T, Float>
{
  private final PathMeasure vc;
  private final Property<T, PointF> yA;
  private final float yB;
  private final float[] yC = new float[2];
  private final PointF yD = new PointF();
  private float yE;
  
  k(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.yA = paramProperty;
    this.vc = new PathMeasure(paramPath, false);
    this.yB = this.vc.getLength();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.k
 * JD-Core Version:    0.7.0.1
 */