package com.tencent.liteav.renderer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;

public class a
  extends View
{
  private Paint a;
  private int b = 0;
  private int c = 2;
  private ScaleAnimation d;
  private Runnable e = new a.1(this);
  
  public a(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    this.a = new Paint();
    this.c = ((int)(getContext().getResources().getDisplayMetrics().density * 1.0F + 0.5F));
    this.d = new ScaleAnimation(1.3F, 1.0F, 1.3F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.d.setDuration(200L);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    removeCallbacks(this.e);
    this.d.cancel();
    this.b = paramInt3;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.width = this.b;
    localLayoutParams.height = this.b;
    setVisibility(0);
    requestLayout();
    this.d.reset();
    startAnimation(this.d);
    postDelayed(this.e, 1000L);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    Rect localRect = new Rect(0, 0, this.b, this.b);
    this.a.setColor(-1);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.c);
    paramCanvas.drawRect(localRect, this.a);
    paramCanvas.restore();
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.renderer.a
 * JD-Core Version:    0.7.0.1
 */