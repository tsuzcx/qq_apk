package com.tencent.mm.plugin.finder.widget.record;

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
import com.tencent.mm.plugin.finder.e.j;

public class MarqueeTextView
  extends TextView
{
  private int Hbi;
  private int Hbj;
  private boolean Hbk;
  private int Hbl;
  private int Hbm;
  private boolean cgD;
  private Scroller mScroller;
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(330644);
    this.Hbj = 0;
    this.cgD = true;
    this.Hbk = true;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e.j.MarqueeTextView);
    this.Hbi = paramContext.getInt(e.j.MarqueeTextView_scroll_interval, 10000);
    this.Hbl = paramContext.getInt(e.j.MarqueeTextView_scroll_mode, 100);
    this.Hbm = paramContext.getInt(e.j.MarqueeTextView_scroll_first_delay, 1000);
    paramContext.recycle();
    setSingleLine();
    setEllipsize(null);
    AppMethodBeat.o(330644);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(330675);
    super.computeScroll();
    if (this.mScroller == null)
    {
      AppMethodBeat.o(330675);
      return;
    }
    if ((this.mScroller.isFinished()) && (!this.cgD))
    {
      if (this.Hbl == 101)
      {
        if (this.mScroller == null)
        {
          AppMethodBeat.o(330675);
          return;
        }
        this.Hbj = 0;
        this.cgD = true;
        this.Hbk = true;
        this.mScroller.startScroll(0, 0, 0, 0, 0);
        invalidate();
        AppMethodBeat.o(330675);
        return;
      }
      this.cgD = true;
      this.Hbj = (getWidth() * -1);
      this.Hbk = false;
      if (this.cgD)
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
        final int i = j - this.Hbj;
        j = Double.valueOf(this.Hbi * i * 1.0D / j).intValue();
        if (this.Hbk)
        {
          new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(330640);
              MarqueeTextView.b(MarqueeTextView.this).startScroll(MarqueeTextView.a(MarqueeTextView.this), 0, i, 0, j);
              MarqueeTextView.this.invalidate();
              MarqueeTextView.c(MarqueeTextView.this);
              AppMethodBeat.o(330640);
            }
          }, this.Hbm);
          AppMethodBeat.o(330675);
          return;
        }
        this.mScroller.startScroll(this.Hbj, 0, i, 0, j);
        invalidate();
        this.cgD = false;
      }
    }
    AppMethodBeat.o(330675);
  }
  
  public int getRndDuration()
  {
    return this.Hbi;
  }
  
  public int getScrollFirstDelay()
  {
    return this.Hbm;
  }
  
  public int getScrollMode()
  {
    return this.Hbl;
  }
  
  public void setRndDuration(int paramInt)
  {
    this.Hbi = paramInt;
  }
  
  public void setScrollFirstDelay(int paramInt)
  {
    this.Hbm = paramInt;
  }
  
  public void setScrollMode(int paramInt)
  {
    this.Hbl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.record.MarqueeTextView
 * JD-Core Version:    0.7.0.1
 */