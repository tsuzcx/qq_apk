package com.tencent.mm.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$8
  implements ValueAnimator.AnimatorUpdateListener
{
  int bVP;
  float bVQ;
  int cdJ;
  float cdK;
  float cdL;
  float cdM;
  float cdN;
  float cdO;
  float cdP;
  
  public c$8(c paramc, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(116162);
    this.cdJ = 0;
    this.cdL = 0.0F;
    this.cdN = 0.0F;
    this.cdO = this.cdQ;
    this.cdP = this.cdR;
    this.bVQ = ((float)Math.pow(this.cdS, 0.0833333358168602D));
    this.bVP = 0;
    AppMethodBeat.o(116162);
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(116163);
    if (this.bVP < 12)
    {
      this.cdH.getMainMatrix().postScale(this.bVQ, this.bVQ, c.d(this.cdH).centerX() + this.cdL, c.d(this.cdH).centerY() + this.cdN);
      c.e(this.cdH).postScale(this.bVQ, this.bVQ, c.d(this.cdH).centerX() + this.cdL, c.d(this.cdH).centerY() + this.cdN);
      this.bVP += 1;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue("rotation")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("deltaX")).intValue();
    int k = ((Integer)paramValueAnimator.getAnimatedValue("deltaY")).intValue();
    this.cdH.getMainMatrix().postRotate(i - this.cdJ, this.cdQ + this.cdL, this.cdR + this.cdN);
    c.e(this.cdH).postRotate(i - this.cdJ, this.cdQ + this.cdL, this.cdR + this.cdN);
    paramValueAnimator = new RectF();
    paramValueAnimator.set(c.d(this.cdH));
    c.e(this.cdH).mapRect(paramValueAnimator);
    this.cdO += j - this.cdK;
    this.cdP += k - this.cdM;
    this.cdL = (this.cdO - paramValueAnimator.centerX());
    this.cdN = (this.cdP - paramValueAnimator.centerY());
    this.cdH.getMainMatrix().postTranslate(this.cdL, this.cdN);
    c.e(this.cdH).postTranslate(this.cdL, this.cdN);
    this.cdH.CI();
    this.cdJ = i;
    this.cdK = j;
    this.cdM = k;
    AppMethodBeat.o(116163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.c.8
 * JD-Core Version:    0.7.0.1
 */