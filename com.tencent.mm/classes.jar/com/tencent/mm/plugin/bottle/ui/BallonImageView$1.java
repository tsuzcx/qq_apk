package com.tencent.mm.plugin.bottle.ui;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class BallonImageView$1
  extends Animation
{
  private int fSw;
  private int fSx;
  private float hYA = L(0.1F, 0.3F);
  private float hYB = 1.0F;
  private float hYC = L(0.7F, 1.0F);
  private float hYD;
  private float hYE;
  private float hYF;
  private float hYG;
  private float hYx = 0.1F;
  private float hYy = L(0.1F, 0.8F);
  private float hYz = 0.1F;
  
  BallonImageView$1(BallonImageView paramBallonImageView) {}
  
  private static float L(float paramFloat1, float paramFloat2)
  {
    return (float)Math.random() * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private void awP()
  {
    this.hYD = (this.hYx * this.fSw);
    this.hYE = (this.hYy * this.fSw);
    this.hYF = (this.hYz * this.fSx);
    this.hYG = (this.hYA * this.fSx);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.hYD;
    float f2 = this.hYF;
    if (this.hYD != this.hYE) {
      f1 = this.hYD + (this.hYE - this.hYD) * paramFloat;
    }
    if (this.hYF != this.hYG) {
      f2 = this.hYF + (this.hYG - this.hYF) * paramFloat;
    }
    paramTransformation.getMatrix().setTranslate(f1, f2);
    f1 = this.hYB + (this.hYC - this.hYB) * paramFloat;
    paramTransformation.getMatrix().postScale(f1, f1);
    if (paramFloat == 1.0F)
    {
      this.hYx = this.hYy;
      this.hYz = this.hYA;
      this.hYy = L(0.1F, 0.8F);
      this.hYA = L(0.1F, 0.3F);
      this.hYB = this.hYC;
      this.hYC = L(0.7F, 1.0F);
      awP();
    }
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.fSw = paramInt3;
    this.fSx = paramInt4;
    awP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BallonImageView.1
 * JD-Core Version:    0.7.0.1
 */