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
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCFocusIndicatorView
  extends View
{
  private static final int FOCUS_AREA_STROKE = 1;
  private int mFocusAreaStroke;
  private Runnable mHideRunnable;
  private Paint mPaint;
  private ScaleAnimation mScaleAnimation;
  private int mSize;
  
  public TXCFocusIndicatorView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(67232);
    this.mSize = 0;
    this.mFocusAreaStroke = 2;
    this.mHideRunnable = new TXCFocusIndicatorView.1(this);
    init(null, 0);
    AppMethodBeat.o(67232);
  }
  
  public TXCFocusIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67233);
    this.mSize = 0;
    this.mFocusAreaStroke = 2;
    this.mHideRunnable = new TXCFocusIndicatorView.1(this);
    init(paramAttributeSet, 0);
    AppMethodBeat.o(67233);
  }
  
  public TXCFocusIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67234);
    this.mSize = 0;
    this.mFocusAreaStroke = 2;
    this.mHideRunnable = new TXCFocusIndicatorView.1(this);
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(67234);
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(67235);
    this.mPaint = new Paint();
    this.mFocusAreaStroke = ((int)(getContext().getResources().getDisplayMetrics().density * 1.0F + 0.5F));
    this.mScaleAnimation = new ScaleAnimation(1.3F, 1.0F, 1.3F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.mScaleAnimation.setDuration(200L);
    AppMethodBeat.o(67235);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(67237);
    paramCanvas.save();
    Rect localRect = new Rect(0, 0, this.mSize, this.mSize);
    this.mPaint.setColor(-1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(this.mFocusAreaStroke);
    paramCanvas.drawRect(localRect, this.mPaint);
    paramCanvas.restore();
    super.onDraw(paramCanvas);
    AppMethodBeat.o(67237);
  }
  
  public void show(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(67236);
    removeCallbacks(this.mHideRunnable);
    this.mScaleAnimation.cancel();
    this.mSize = paramInt3;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.width = this.mSize;
    localLayoutParams.height = this.mSize;
    setVisibility(0);
    requestLayout();
    this.mScaleAnimation.reset();
    startAnimation(this.mScaleAnimation);
    postDelayed(this.mHideRunnable, 1000L);
    AppMethodBeat.o(67236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCFocusIndicatorView
 * JD-Core Version:    0.7.0.1
 */