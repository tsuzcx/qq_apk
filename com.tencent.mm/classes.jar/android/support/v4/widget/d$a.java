package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;

final class d$a
{
  int[] Aq;
  int Bi;
  final RectF IU = new RectF();
  final Paint IV = new Paint();
  final Paint IW = new Paint();
  float IX = 0.0F;
  float IY = 0.0F;
  int IZ;
  float Ja;
  float Jb;
  float Jc;
  boolean Jd;
  Path Je;
  float Jf = 1.0F;
  float Jg;
  int Jh;
  int Ji;
  float gV = 0.0F;
  int mAlpha = 255;
  final Paint mPaint = new Paint();
  float nX = 5.0F;
  
  d$a()
  {
    this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.IV.setStyle(Paint.Style.FILL);
    this.IV.setAntiAlias(true);
    this.IW.setColor(0);
  }
  
  final void I(boolean paramBoolean)
  {
    if (this.Jd != paramBoolean) {
      this.Jd = paramBoolean;
    }
  }
  
  final void aD(int paramInt)
  {
    this.IZ = paramInt;
    this.Bi = this.Aq[this.IZ];
  }
  
  final int dQ()
  {
    return (this.IZ + 1) % this.Aq.length;
  }
  
  final int dR()
  {
    return this.Aq[this.IZ];
  }
  
  final void dS()
  {
    this.Ja = this.IX;
    this.Jb = this.IY;
    this.Jc = this.gV;
  }
  
  final void dT()
  {
    this.Ja = 0.0F;
    this.Jb = 0.0F;
    this.Jc = 0.0F;
    this.IX = 0.0F;
    this.IY = 0.0F;
    this.gV = 0.0F;
  }
  
  final void setColors(int[] paramArrayOfInt)
  {
    this.Aq = paramArrayOfInt;
    aD(0);
  }
  
  final void setStrokeWidth(float paramFloat)
  {
    this.nX = paramFloat;
    this.mPaint.setStrokeWidth(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.d.a
 * JD-Core Version:    0.7.0.1
 */