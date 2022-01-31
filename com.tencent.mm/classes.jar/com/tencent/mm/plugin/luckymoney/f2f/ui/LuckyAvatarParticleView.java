package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class LuckyAvatarParticleView
  extends View
{
  public static DisplayMetrics eRM;
  private long duration;
  private Paint gaZ = new Paint();
  private ValueAnimator hsF;
  private int lNC;
  private int lND;
  private List<Rect> lNE = new ArrayList();
  private List<Integer> lNF = new ArrayList();
  private List<Integer> lNG = new ArrayList();
  private int lNH;
  private int lNI;
  private int lNJ;
  private int lNK;
  
  public LuckyAvatarParticleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getRandomRectWidth()
  {
    return this.lNJ + (int)(Math.random() * (this.lNK - this.lNJ));
  }
  
  private int getRandomVelocity()
  {
    return this.lNH + (int)(Math.random() * (this.lNI - this.lNH));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    while (i < this.lNE.size())
    {
      paramCanvas.drawRect((Rect)this.lNE.get(i), this.gaZ);
      i += 1;
    }
  }
  
  public void setColor(int paramInt)
  {
    this.gaZ.setColor(paramInt);
    this.gaZ.setStyle(Paint.Style.FILL);
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
    this.hsF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(this.duration);
    this.hsF.addUpdateListener(new LuckyAvatarParticleView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyAvatarParticleView
 * JD-Core Version:    0.7.0.1
 */