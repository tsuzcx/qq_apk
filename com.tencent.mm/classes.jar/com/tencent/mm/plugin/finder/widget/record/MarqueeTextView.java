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
import com.tencent.mm.plugin.finder.b.l;

@SuppressLint({"AppCompatCustomView"})
public class MarqueeTextView
  extends TextView
{
  private int BuA;
  private int BuB;
  private int Bux;
  private int Buy;
  private boolean Buz;
  private boolean arU;
  private Scroller mScroller;
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276550);
    this.Buy = 0;
    this.arU = true;
    this.Buz = true;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.MarqueeTextView);
    this.Bux = paramContext.getInt(b.l.MarqueeTextView_scroll_interval, 10000);
    this.BuA = paramContext.getInt(b.l.MarqueeTextView_scroll_mode, 100);
    this.BuB = paramContext.getInt(b.l.MarqueeTextView_scroll_first_delay, 1000);
    paramContext.recycle();
    setSingleLine();
    setEllipsize(null);
    AppMethodBeat.o(276550);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(276551);
    super.computeScroll();
    if (this.mScroller == null)
    {
      AppMethodBeat.o(276551);
      return;
    }
    if ((this.mScroller.isFinished()) && (!this.arU))
    {
      if (this.BuA == 101)
      {
        if (this.mScroller == null)
        {
          AppMethodBeat.o(276551);
          return;
        }
        this.Buy = 0;
        this.arU = true;
        this.Buz = true;
        this.mScroller.startScroll(0, 0, 0, 0, 0);
        invalidate();
        AppMethodBeat.o(276551);
        return;
      }
      this.arU = true;
      this.Buy = (getWidth() * -1);
      this.Buz = false;
      if (this.arU)
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
        final int i = j - this.Buy;
        j = Double.valueOf(this.Bux * i * 1.0D / j).intValue();
        if (this.Buz)
        {
          new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(269023);
              MarqueeTextView.b(MarqueeTextView.this).startScroll(MarqueeTextView.a(MarqueeTextView.this), 0, i, 0, j);
              MarqueeTextView.this.invalidate();
              MarqueeTextView.c(MarqueeTextView.this);
              AppMethodBeat.o(269023);
            }
          }, this.BuB);
          AppMethodBeat.o(276551);
          return;
        }
        this.mScroller.startScroll(this.Buy, 0, i, 0, j);
        invalidate();
        this.arU = false;
      }
    }
    AppMethodBeat.o(276551);
  }
  
  public int getRndDuration()
  {
    return this.Bux;
  }
  
  public int getScrollFirstDelay()
  {
    return this.BuB;
  }
  
  public int getScrollMode()
  {
    return this.BuA;
  }
  
  public void setRndDuration(int paramInt)
  {
    this.Bux = paramInt;
  }
  
  public void setScrollFirstDelay(int paramInt)
  {
    this.BuB = paramInt;
  }
  
  public void setScrollMode(int paramInt)
  {
    this.BuA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.record.MarqueeTextView
 * JD-Core Version:    0.7.0.1
 */