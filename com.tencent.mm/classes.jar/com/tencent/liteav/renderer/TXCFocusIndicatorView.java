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
    AppMethodBeat.i(16938);
    this.mSize = 0;
    this.mFocusAreaStroke = 2;
    this.mHideRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16750);
        TXCFocusIndicatorView.this.setVisibility(8);
        AppMethodBeat.o(16750);
      }
    };
    init(null, 0);
    AppMethodBeat.o(16938);
  }
  
  public TXCFocusIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(16939);
    this.mSize = 0;
    this.mFocusAreaStroke = 2;
    this.mHideRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16750);
        TXCFocusIndicatorView.this.setVisibility(8);
        AppMethodBeat.o(16750);
      }
    };
    init(paramAttributeSet, 0);
    AppMethodBeat.o(16939);
  }
  
  public TXCFocusIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(16940);
    this.mSize = 0;
    this.mFocusAreaStroke = 2;
    this.mHideRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16750);
        TXCFocusIndicatorView.this.setVisibility(8);
        AppMethodBeat.o(16750);
      }
    };
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(16940);
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(16941);
    this.mPaint = new Paint();
    this.mFocusAreaStroke = ((int)(getContext().getResources().getDisplayMetrics().density * 1.0F + 0.5F));
    this.mScaleAnimation = new ScaleAnimation(1.3F, 1.0F, 1.3F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.mScaleAnimation.setDuration(200L);
    AppMethodBeat.o(16941);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(16943);
    paramCanvas.save();
    int i = this.mFocusAreaStroke / 2;
    Rect localRect = new Rect(i, i, this.mSize - i, this.mSize - i);
    this.mPaint.setColor(-1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(i * 2);
    paramCanvas.drawRect(localRect, this.mPaint);
    paramCanvas.restore();
    super.onDraw(paramCanvas);
    AppMethodBeat.o(16943);
  }
  
  public void show(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16942);
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
    AppMethodBeat.o(16942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCFocusIndicatorView
 * JD-Core Version:    0.7.0.1
 */