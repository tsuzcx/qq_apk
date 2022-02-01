package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k<T>
  extends Property<T, Float>
{
  private final Property<T, PointF> cfA;
  private final PathMeasure cfB;
  private final float cfC;
  private final float[] cfD;
  private final PointF cfE;
  private float cfF;
  
  k(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    AppMethodBeat.i(201632);
    this.cfD = new float[2];
    this.cfE = new PointF();
    this.cfA = paramProperty;
    this.cfB = new PathMeasure(paramPath, false);
    this.cfC = this.cfB.getLength();
    AppMethodBeat.o(201632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.k
 * JD-Core Version:    0.7.0.1
 */