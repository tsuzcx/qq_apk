package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;

final class d$a
{
  int Aw;
  int JA;
  int JB = 255;
  final RectF Jl = new RectF();
  final Paint Jm = new Paint();
  final Paint Jn = new Paint();
  float Jo = 0.0F;
  float Jp = 0.0F;
  int[] Jq;
  int Jr;
  float Js;
  float Jt;
  float Ju;
  boolean Jv;
  Path Jw;
  float Jx = 1.0F;
  float Jy;
  int Jz;
  float gb = 0.0F;
  final Paint mPaint = new Paint();
  float na = 5.0F;
  
  d$a()
  {
    this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.Jm.setStyle(Paint.Style.FILL);
    this.Jm.setAntiAlias(true);
    this.Jn.setColor(0);
  }
  
  final void J(boolean paramBoolean)
  {
    if (this.Jv != paramBoolean) {
      this.Jv = paramBoolean;
    }
  }
  
  final void aG(int paramInt)
  {
    this.Jr = paramInt;
    this.Aw = this.Jq[this.Jr];
  }
  
  final int dA()
  {
    return this.Jq[this.Jr];
  }
  
  final void dB()
  {
    this.Js = this.Jo;
    this.Jt = this.Jp;
    this.Ju = this.gb;
  }
  
  final void dC()
  {
    this.Js = 0.0F;
    this.Jt = 0.0F;
    this.Ju = 0.0F;
    this.Jo = 0.0F;
    this.Jp = 0.0F;
    this.gb = 0.0F;
  }
  
  final int dz()
  {
    return (this.Jr + 1) % this.Jq.length;
  }
  
  final void setColors(int[] paramArrayOfInt)
  {
    this.Jq = paramArrayOfInt;
    aG(0);
  }
  
  final void setStrokeWidth(float paramFloat)
  {
    this.na = paramFloat;
    this.mPaint.setStrokeWidth(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.d.a
 * JD-Core Version:    0.7.0.1
 */