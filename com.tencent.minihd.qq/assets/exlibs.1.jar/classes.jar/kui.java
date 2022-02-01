import android.graphics.PointF;

public final class kui
  implements kuj
{
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF1.y;
    return new PointF(f1 + (paramPointF2.x - f1) * paramFloat, f2 + (paramPointF2.y - f2) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kui
 * JD-Core Version:    0.7.0.1
 */