package com.tencent.mm.plugin.luckymoney.particles;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.Interpolator;

public final class e
{
  private static final Paint lST;
  private static Interpolator lSU;
  
  static
  {
    Paint localPaint = new Paint();
    lST = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
  }
  
  public static Interpolator bfT()
  {
    if (lSU == null) {
      lSU = new e.1();
    }
    return lSU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.e
 * JD-Core Version:    0.7.0.1
 */