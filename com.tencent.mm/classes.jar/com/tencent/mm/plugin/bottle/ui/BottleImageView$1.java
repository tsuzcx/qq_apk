package com.tencent.mm.plugin.bottle.ui;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

final class BottleImageView$1
  extends Animation
{
  private float hYA = -1.0F;
  private float hYB = 1.0F;
  private float hYC = 0.1F;
  private float hYx = -1.0F;
  private float hYy = -1.0F;
  private float hYz = -1.0F;
  private boolean hZA = false;
  private float hZB = 0.0F;
  private float hZC = -850.0F;
  private float hZD = 1.0F;
  private float hZE = 0.3F;
  private float hZz;
  private float x0;
  private float x1;
  private float y0;
  private float y1;
  
  BottleImageView$1(BottleImageView paramBottleImageView) {}
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.hYx == -1.0F)
    {
      this.hYx = BottleImageView.c(this.hZF);
      this.hYy = BottleImageView.d(this.hZF);
      this.hYz = BottleImageView.e(this.hZF);
      this.hYA = BottleImageView.f(this.hZF);
      this.x0 = (this.hYx + (this.hYy - this.hYx) / 5.0F);
      this.x1 = (this.hYx + (this.hYy - this.hYx) * 3.0F / 5.0F);
      this.y0 = ((this.x0 - this.hYx) / (this.hYy - this.hYx) * (this.hYA - this.hYz) + this.hYz - BackwardSupportUtil.b.b(BottleImageView.g(this.hZF), 67.0F));
      this.y1 = ((this.x1 - this.hYx) / (this.hYy - this.hYx) * (this.hYA - this.hYz) + this.hYz - BackwardSupportUtil.b.b(BottleImageView.g(this.hZF), 53.0F));
    }
    paramTransformation.setAlpha(this.hZD + (this.hZE - this.hZD) * paramFloat);
    float f1 = this.hYB + (this.hYC - this.hYB) * paramFloat;
    paramTransformation.getMatrix().setScale(f1, f1, BottleImageView.a(this.hZF) / 2, BottleImageView.b(this.hZF) / 2);
    f1 = this.hZB;
    float f2 = this.hZC;
    float f3 = this.hZB;
    paramTransformation.getMatrix().postRotate(f1 + (f2 - f3) * paramFloat, BottleImageView.a(this.hZF) / 2, BottleImageView.b(this.hZF) / 2);
    f1 = this.hYx;
    f2 = (this.hYy - this.hYx) * paramFloat + f1;
    if (f2 >= this.x0) {
      f1 = (f2 - this.hYx) / (this.x0 - this.hYx) * (this.y0 - this.hYz) + this.hYz;
    }
    for (;;)
    {
      this.hZz = f1;
      paramTransformation.getMatrix().postTranslate(f2, f1);
      if (paramFloat == 1.0F)
      {
        this.hYx = -1.0F;
        this.hYy = -1.0F;
        this.hYz = -1.0F;
        this.hYA = -1.0F;
        this.hZA = false;
      }
      return;
      if (f2 >= this.x1)
      {
        if (!this.hZA)
        {
          this.hZA = true;
          this.y0 = this.hZz;
        }
        f1 = (f2 - this.x0) / (this.x1 - this.x0) * (this.y1 - this.y0) + this.y0;
      }
      else
      {
        f1 = (f2 - this.x1) / (this.hYy - this.x1) * (this.hYA - this.y1) + this.y1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleImageView.1
 * JD-Core Version:    0.7.0.1
 */