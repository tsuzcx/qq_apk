package android.support.design.bottomappbar;

import android.support.design.f.b;
import android.support.design.f.d;

public final class a
  extends b
{
  float ht;
  float hu;
  float hv;
  float hw;
  float hx;
  
  public a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.hu = paramFloat1;
    this.ht = paramFloat2;
    this.hw = paramFloat3;
    if (paramFloat3 < 0.0F) {
      throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }
    this.hx = 0.0F;
  }
  
  public final void a(float paramFloat1, float paramFloat2, d paramd)
  {
    if (this.hv == 0.0F)
    {
      paramd.j(paramFloat1);
      return;
    }
    float f1 = (this.hu * 2.0F + this.hv) / 2.0F;
    float f2 = paramFloat2 * this.ht;
    float f3 = paramFloat1 / 2.0F + this.hx;
    paramFloat2 = this.hw * paramFloat2 + (1.0F - paramFloat2) * f1;
    if (paramFloat2 / f1 >= 1.0F)
    {
      paramd.j(paramFloat1);
      return;
    }
    float f4 = f1 + f2;
    float f6 = paramFloat2 + f2;
    float f7 = (float)Math.sqrt(f4 * f4 - f6 * f6);
    f4 = f3 - f7;
    float f5 = f3 + f7;
    f6 = (float)Math.toDegrees(Math.atan(f7 / f6));
    f7 = 90.0F - f6;
    paramd.j(f4 - f2);
    paramd.addArc(f4 - f2, 0.0F, f4 + f2, f2 * 2.0F, 270.0F, f6);
    paramd.addArc(f3 - f1, -f1 - paramFloat2, f3 + f1, f1 - paramFloat2, 180.0F - f7, 2.0F * f7 - 180.0F);
    paramd.addArc(f5 - f2, 0.0F, f5 + f2, f2 * 2.0F, 270.0F - f6, f6);
    paramd.j(paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.bottomappbar.a
 * JD-Core Version:    0.7.0.1
 */