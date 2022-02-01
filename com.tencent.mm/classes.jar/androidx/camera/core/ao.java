package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;

public abstract class ao
{
  private Rational Ix = null;
  
  public ao()
  {
    this((byte)0);
  }
  
  private ao(byte paramByte) {}
  
  protected abstract PointF n(float paramFloat1, float paramFloat2);
  
  public final an o(float paramFloat1, float paramFloat2)
  {
    PointF localPointF = n(paramFloat1, paramFloat2);
    return new an(localPointF.x, localPointF.y, this.Ix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.ao
 * JD-Core Version:    0.7.0.1
 */