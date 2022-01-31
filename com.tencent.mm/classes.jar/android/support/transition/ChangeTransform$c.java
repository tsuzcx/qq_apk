package android.support.transition;

import android.support.v4.view.t;
import android.view.View;

final class ChangeTransform$c
{
  final float mScaleX;
  final float mScaleY;
  final float rm;
  final float rn;
  final float ro;
  final float rp;
  final float rq;
  final float rs;
  
  ChangeTransform$c(View paramView)
  {
    this.rm = paramView.getTranslationX();
    this.rn = paramView.getTranslationY();
    this.ro = t.ah(paramView);
    this.mScaleX = paramView.getScaleX();
    this.mScaleY = paramView.getScaleY();
    this.rp = paramView.getRotationX();
    this.rq = paramView.getRotationY();
    this.rs = paramView.getRotation();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {}
    do
    {
      return false;
      paramObject = (c)paramObject;
    } while ((paramObject.rm != this.rm) || (paramObject.rn != this.rn) || (paramObject.ro != this.ro) || (paramObject.mScaleX != this.mScaleX) || (paramObject.mScaleY != this.mScaleY) || (paramObject.rp != this.rp) || (paramObject.rq != this.rq) || (paramObject.rs != this.rs));
    return true;
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    int i;
    int j;
    label37:
    int k;
    label54:
    int m;
    label72:
    int n;
    label90:
    int i1;
    if (this.rm != 0.0F)
    {
      i = Float.floatToIntBits(this.rm);
      if (this.rn == 0.0F) {
        break label191;
      }
      j = Float.floatToIntBits(this.rn);
      if (this.ro == 0.0F) {
        break label196;
      }
      k = Float.floatToIntBits(this.ro);
      if (this.mScaleX == 0.0F) {
        break label201;
      }
      m = Float.floatToIntBits(this.mScaleX);
      if (this.mScaleY == 0.0F) {
        break label207;
      }
      n = Float.floatToIntBits(this.mScaleY);
      if (this.rp == 0.0F) {
        break label213;
      }
      i1 = Float.floatToIntBits(this.rp);
      label108:
      if (this.rq == 0.0F) {
        break label219;
      }
    }
    label191:
    label196:
    label201:
    label207:
    label213:
    label219:
    for (int i2 = Float.floatToIntBits(this.rq);; i2 = 0)
    {
      if (this.rs != 0.0F) {
        i3 = Float.floatToIntBits(this.rs);
      }
      return (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
      i = 0;
      break;
      j = 0;
      break label37;
      k = 0;
      break label54;
      m = 0;
      break label72;
      n = 0;
      break label90;
      i1 = 0;
      break label108;
    }
  }
  
  public final void y(View paramView)
  {
    ChangeTransform.b(paramView, this.rm, this.rn, this.ro, this.mScaleX, this.mScaleY, this.rp, this.rq, this.rs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeTransform.c
 * JD-Core Version:    0.7.0.1
 */