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
import com.tencent.mm.sdk.platformtools.ae;

public class af
  extends FrameLayout
{
  private int De;
  private int mTouchSlop;
  View mhh;
  FrameLayout mhi;
  FrameLayout mhj;
  public boolean mhk;
  private boolean mhl;
  private boolean mhm;
  private boolean mhn;
  private boolean mho;
  private int mhp;
  private int mhq;
  private boolean mhr;
  private ObjectAnimator mhs;
  
  public af(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135211);
    this.mhk = true;
    this.mhl = false;
    this.mhm = false;
    this.mhn = false;
    this.mho = false;
    this.mhr = false;
    this.mhs = null;
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
  
  private void uV(int paramInt)
  {
    AppMethodBeat.i(135220);
    int i = (int)this.mhj.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(135220);
      return;
    }
    ae.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.mhs != null) {
      this.mhs.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mhj, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135210);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        af.this.uU((int)f);
        AppMethodBeat.o(135210);
      }
    });
    this.mhs = localObjectAnimator;
    AppMethodBeat.o(135220);
  }
  
  protected boolean Dr()
  {
    return false;
  }
  
  protected final void bvK()
  {
    AppMethodBeat.i(135214);
    uV(getStayHeight());
    if (!this.mhm) {
      bvM();
    }
    this.mhn = true;
    this.mhm = true;
    this.mho = true;
    AppMethodBeat.o(135214);
  }
  
  protected final void bvL()
  {
    AppMethodBeat.i(135215);
    uV(0);
    if (this.mhm) {
      bvN();
    }
    this.mhn = false;
    this.mhm = false;
    this.mho = false;
    AppMethodBeat.o(135215);
  }
  
  protected void bvM() {}
  
  protected void bvN() {}
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(135218);
    int i = this.mhh.getHeight();
    AppMethodBeat.o(135218);
    return i;
  }
  
  public int getPullDownBackgroundColor()
  {
    AppMethodBeat.i(178618);
    Drawable localDrawable = this.mhi.getBackground();
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
    int i = this.mhh.getHeight();
    AppMethodBeat.o(135219);
    return i;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135212);
    if (this.mhk)
    {
      boolean bool = this.mho;
      AppMethodBeat.o(135212);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.mhn = false;
      this.mhr = false;
      AppMethodBeat.o(135212);
      return false;
    }
    if ((i == 2) && (this.mhn))
    {
      AppMethodBeat.o(135212);
      return true;
    }
    switch (i)
    {
    }
    while ((this.mhn) || (this.mho))
    {
      AppMethodBeat.o(135212);
      return true;
      if (Dr())
      {
        this.mhp = ((int)paramMotionEvent.getX());
        this.mhq = ((int)paramMotionEvent.getY());
        this.De = ((int)paramMotionEvent.getY());
        this.mhn = false;
        this.mhr = true;
        continue;
        if (Dr())
        {
          if (!this.mhr)
          {
            this.mhp = ((int)paramMotionEvent.getX());
            this.mhq = ((int)paramMotionEvent.getY());
            this.De = ((int)paramMotionEvent.getY());
            this.mhn = false;
            this.mhr = true;
            AppMethodBeat.o(135212);
            return false;
          }
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          int k = this.mhp;
          int m = j - this.mhq;
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (m > 0))
          {
            this.mhp = i;
            this.mhq = j;
            this.mhn = true;
            this.mhr = false;
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
    if (this.mhk)
    {
      if (this.mho) {
        bvL();
      }
      boolean bool = this.mho;
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
        } while ((!Dr()) && (!this.mho));
        this.mhq = ((int)paramMotionEvent.getY());
        this.mhp = ((int)paramMotionEvent.getX());
        this.De = ((int)paramMotionEvent.getY());
        this.mhr = true;
        AppMethodBeat.o(135213);
        return true;
      } while ((!this.mhn) && (!this.mho));
      if (!this.mhr)
      {
        this.mhq = ((int)paramMotionEvent.getY());
        this.mhp = ((int)paramMotionEvent.getX());
        this.De = ((int)paramMotionEvent.getY());
        this.mhr = true;
        AppMethodBeat.o(135213);
        return true;
      }
      int k = (int)paramMotionEvent.getY() - this.De;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.mhm) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ae.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.mhj.setTranslationY(j);
        uU(i);
        AppMethodBeat.o(135213);
        return true;
      }
      this.mhr = false;
      if ((this.mhj.getTranslationY() > getOpenHeight()) && (this.mhl))
      {
        bvK();
        AppMethodBeat.o(135213);
        return true;
      }
    } while ((!this.mhn) && (!this.mho));
    bvL();
    AppMethodBeat.o(135213);
    return true;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.mhl = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135216);
    this.mhi.setBackgroundColor(paramInt);
    AppMethodBeat.o(135216);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mhk = paramBoolean;
      return;
    }
  }
  
  protected void uU(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */