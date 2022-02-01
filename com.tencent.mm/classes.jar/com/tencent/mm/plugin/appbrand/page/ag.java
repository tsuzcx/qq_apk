package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class ag
  extends FrameLayout
{
  private int Bm;
  View lDm;
  FrameLayout lDn;
  FrameLayout lDo;
  public boolean lDp;
  private boolean lDq;
  private boolean lDr;
  private boolean lDs;
  private boolean lDt;
  private int lDu;
  private int lDv;
  private boolean lDw;
  private ObjectAnimator lDx;
  private int mTouchSlop;
  
  public ag(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135211);
    this.lDp = true;
    this.lDq = false;
    this.lDr = false;
    this.lDs = false;
    this.lDt = false;
    this.lDw = false;
    this.lDx = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(135211);
  }
  
  private int getMaxOverScrollDistance()
  {
    AppMethodBeat.i(135217);
    int i = getHeight();
    AppMethodBeat.o(135217);
    return i;
  }
  
  private void un(int paramInt)
  {
    AppMethodBeat.i(135220);
    int i = (int)this.lDo.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(135220);
      return;
    }
    ac.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.lDx != null) {
      this.lDx.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.lDo, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135210);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ag.this.um((int)f);
        AppMethodBeat.o(135210);
      }
    });
    this.lDx = localObjectAnimator;
    AppMethodBeat.o(135220);
  }
  
  protected boolean BP()
  {
    return false;
  }
  
  protected final void bqY()
  {
    AppMethodBeat.i(135214);
    un(getStayHeight());
    if (!this.lDr) {
      bra();
    }
    this.lDs = true;
    this.lDr = true;
    this.lDt = true;
    AppMethodBeat.o(135214);
  }
  
  protected final void bqZ()
  {
    AppMethodBeat.i(135215);
    un(0);
    if (this.lDr) {
      brb();
    }
    this.lDs = false;
    this.lDr = false;
    this.lDt = false;
    AppMethodBeat.o(135215);
  }
  
  protected void bra() {}
  
  protected void brb() {}
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(135218);
    int i = this.lDm.getHeight();
    AppMethodBeat.o(135218);
    return i;
  }
  
  public int getPullDownBackgroundColor()
  {
    AppMethodBeat.i(178618);
    Drawable localDrawable = this.lDn.getBackground();
    if ((localDrawable instanceof ColorDrawable))
    {
      int i = ((ColorDrawable)localDrawable).getColor();
      AppMethodBeat.o(178618);
      return i;
    }
    AppMethodBeat.o(178618);
    return 0;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(135219);
    int i = this.lDm.getHeight();
    AppMethodBeat.o(135219);
    return i;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135212);
    if (this.lDp)
    {
      boolean bool = this.lDt;
      AppMethodBeat.o(135212);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.lDs = false;
      this.lDw = false;
      AppMethodBeat.o(135212);
      return false;
    }
    if ((i == 2) && (this.lDs))
    {
      AppMethodBeat.o(135212);
      return true;
    }
    switch (i)
    {
    }
    while ((this.lDs) || (this.lDt))
    {
      AppMethodBeat.o(135212);
      return true;
      if (BP())
      {
        this.lDu = ((int)paramMotionEvent.getX());
        this.lDv = ((int)paramMotionEvent.getY());
        this.Bm = ((int)paramMotionEvent.getY());
        this.lDs = false;
        this.lDw = true;
        continue;
        if (BP())
        {
          if (!this.lDw)
          {
            this.lDu = ((int)paramMotionEvent.getX());
            this.lDv = ((int)paramMotionEvent.getY());
            this.Bm = ((int)paramMotionEvent.getY());
            this.lDs = false;
            this.lDw = true;
            AppMethodBeat.o(135212);
            return false;
          }
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          int k = this.lDu;
          int m = j - this.lDv;
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (m > 0))
          {
            this.lDu = i;
            this.lDv = j;
            this.lDs = true;
            this.lDw = false;
            AppMethodBeat.o(135212);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(135212);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135213);
    if (this.lDp)
    {
      if (this.lDt) {
        bqZ();
      }
      boolean bool = this.lDt;
      AppMethodBeat.o(135213);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      AppMethodBeat.o(135213);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(135213);
          return false;
        } while ((!BP()) && (!this.lDt));
        this.lDv = ((int)paramMotionEvent.getY());
        this.lDu = ((int)paramMotionEvent.getX());
        this.Bm = ((int)paramMotionEvent.getY());
        this.lDw = true;
        AppMethodBeat.o(135213);
        return true;
      } while ((!this.lDs) && (!this.lDt));
      if (!this.lDw)
      {
        this.lDv = ((int)paramMotionEvent.getY());
        this.lDu = ((int)paramMotionEvent.getX());
        this.Bm = ((int)paramMotionEvent.getY());
        this.lDw = true;
        AppMethodBeat.o(135213);
        return true;
      }
      int k = (int)paramMotionEvent.getY() - this.Bm;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.lDr) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ac.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.lDo.setTranslationY(j);
        um(i);
        AppMethodBeat.o(135213);
        return true;
      }
      this.lDw = false;
      if ((this.lDo.getTranslationY() > getOpenHeight()) && (this.lDq))
      {
        bqY();
        AppMethodBeat.o(135213);
        return true;
      }
    } while ((!this.lDs) && (!this.lDt));
    bqZ();
    AppMethodBeat.o(135213);
    return true;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.lDq = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135216);
    this.lDn.setBackgroundColor(paramInt);
    AppMethodBeat.o(135216);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.lDp = paramBoolean;
      return;
    }
  }
  
  protected void um(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag
 * JD-Core Version:    0.7.0.1
 */