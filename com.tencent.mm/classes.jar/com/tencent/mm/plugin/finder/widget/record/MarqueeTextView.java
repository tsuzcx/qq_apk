package com.tencent.mm.plugin.finder.widget.record;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.a;

@SuppressLint({"AppCompatCustomView"})
public class MarqueeTextView
  extends TextView
{
  private boolean CA;
  private Scroller mScroller;
  private int wDP;
  private int wDQ;
  private boolean wDR;
  private int wDS;
  private int wDT;
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(241823);
    this.wDQ = 0;
    this.CA = true;
    this.wDR = true;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.MarqueeTextView);
    this.wDP = paramContext.getInt(1, 10000);
    this.wDS = paramContext.getInt(2, 100);
    this.wDT = paramContext.getInt(0, 1000);
    paramContext.recycle();
    setSingleLine();
    setEllipsize(null);
    AppMethodBeat.o(241823);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(241824);
    super.computeScroll();
    if (this.mScroller == null)
    {
      AppMethodBeat.o(241824);
      return;
    }
    if ((this.mScroller.isFinished()) && (!this.CA))
    {
      if (this.wDS == 101)
      {
        if (this.mScroller == null)
        {
          AppMethodBeat.o(241824);
          return;
        }
        this.wDQ = 0;
        this.CA = true;
        this.wDR = true;
        this.mScroller.startScroll(0, 0, 0, 0, 0);
        invalidate();
        AppMethodBeat.o(241824);
        return;
      }
      this.CA = true;
      this.wDQ = (getWidth() * -1);
      this.wDR = false;
      if (this.CA)
      {
        setHorizontallyScrolling(true);
        if (this.mScroller == null)
        {
          this.mScroller = new Scroller(getContext(), new LinearInterpolator());
          setScroller(this.mScroller);
        }
        TextPaint localTextPaint = getPaint();
        Rect localRect = new Rect();
        String str = getText().toString();
        localTextPaint.getTextBounds(str, 0, str.length(), localRect);
        final int j = localRect.width();
        final int i = j - this.wDQ;
        j = Double.valueOf(this.wDP * i * 1.0D / j).intValue();
        if (this.wDR)
        {
          new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(241822);
              MarqueeTextView.b(MarqueeTextView.this).startScroll(MarqueeTextView.a(MarqueeTextView.this), 0, i, 0, j);
              MarqueeTextView.this.invalidate();
              MarqueeTextView.c(MarqueeTextView.this);
              AppMethodBeat.o(241822);
            }
          }, this.wDT);
          AppMethodBeat.o(241824);
          return;
        }
        this.mScroller.startScroll(this.wDQ, 0, i, 0, j);
        invalidate();
        this.CA = false;
      }
    }
    AppMethodBeat.o(241824);
  }
  
  public int getRndDuration()
  {
    return this.wDP;
  }
  
  public int getScrollFirstDelay()
  {
    return this.wDT;
  }
  
  public int getScrollMode()
  {
    return this.wDS;
  }
  
  public void setRndDuration(int paramInt)
  {
    this.wDP = paramInt;
  }
  
  public void setScrollFirstDelay(int paramInt)
  {
    this.wDT = paramInt;
  }
  
  public void setScrollMode(int paramInt)
  {
    this.wDS = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.record.MarqueeTextView
 * JD-Core Version:    0.7.0.1
 */