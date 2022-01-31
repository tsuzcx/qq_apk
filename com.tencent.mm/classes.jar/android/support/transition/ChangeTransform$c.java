package android.support.transition;

import android.support.v4.view.q;
import android.view.View;

final class ChangeTransform$c
{
  final float mScaleX;
  final float mScaleY;
  final float qp;
  final float qr;
  final float qs;
  final float qt;
  final float qu;
  final float qv;
  
  ChangeTransform$c(View paramView)
  {
    this.qp = paramView.getTranslationX();
    this.qr = paramView.getTranslationY();
    this.qs = q.aa(paramView);
    this.mScaleX = paramView.getScaleX();
    this.mScaleY = paramView.getScaleY();
    this.qt = paramView.getRotationX();
    this.qu = paramView.getRotationY();
    this.qv = paramView.getRotation();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {}
    do
    {
      return false;
      paramObject = (c)paramObject;
    } while ((paramObject.qp != this.qp) || (paramObject.qr != this.qr) || (paramObject.qs != this.qs) || (paramObject.mScaleX != this.mScaleX) || (paramObject.mScaleY != this.mScaleY) || (paramObject.qt != this.qt) || (paramObject.qu != this.qu) || (paramObject.qv != this.qv));
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
    if (this.qp != 0.0F)
    {
      i = Float.floatToIntBits(this.qp);
      if (this.qr == 0.0F) {
        break label191;
      }
      j = Float.floatToIntBits(this.qr);
      if (this.qs == 0.0F) {
        break label196;
      }
      k = Float.floatToIntBits(this.qs);
      if (this.mScaleX == 0.0F) {
        break label201;
      }
      m = Float.floatToIntBits(this.mScaleX);
      if (this.mScaleY == 0.0F) {
        break label207;
      }
      n = Float.floatToIntBits(this.mScaleY);
      if (this.qt == 0.0F) {
        break label213;
      }
      i1 = Float.floatToIntBits(this.qt);
      label108:
      if (this.qu == 0.0F) {
        break label219;
      }
    }
    label191:
    label196:
    label201:
    label207:
    label213:
    label219:
    for (int i2 = Float.floatToIntBits(this.qu);; i2 = 0)
    {
      if (this.qv != 0.0F) {
        i3 = Float.floatToIntBits(this.qv);
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
  
  public final void v(View paramView)
  {
    ChangeTransform.b(paramView, this.qp, this.qr, this.qs, this.mScaleX, this.mScaleY, this.qt, this.qu, this.qv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ChangeTransform.c
 * JD-Core Version:    0.7.0.1
 */