package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k<T>
  extends Property<T, Float>
{
  private final Property<T, PointF> aqR;
  private final PathMeasure aqS;
  private final float aqT;
  private final float[] aqU;
  private final PointF aqV;
  private float aqW;
  
  k(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    AppMethodBeat.i(192430);
    this.aqU = new float[2];
    this.aqV = new PointF();
    this.aqR = paramProperty;
    this.aqS = new PathMeasure(paramPath, false);
    this.aqT = this.aqS.getLength();
    AppMethodBeat.o(192430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.k
 * JD-Core Version:    0.7.0.1
 */