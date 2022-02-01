package androidx.f.a.a;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float[] Zt;
  private final float Zu;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.Zt = paramArrayOfFloat;
    this.Zu = (1.0F / (this.Zt.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.Zt.length - 1) * paramFloat), this.Zt.length - 2);
    paramFloat = (paramFloat - i * this.Zu) / this.Zu;
    float f = this.Zt[i];
    return (this.Zt[(i + 1)] - this.Zt[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.f.a.a.d
 * JD-Core Version:    0.7.0.1
 */