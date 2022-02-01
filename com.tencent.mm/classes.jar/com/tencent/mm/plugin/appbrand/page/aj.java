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
import com.tencent.mm.sdk.platformtools.Log;

public class aj
  extends FrameLayout
{
  private boolean cCE;
  private int cho;
  public boolean mDisabled;
  private int mTouchSlop;
  private FrameLayout tsH;
  private View tyc;
  private FrameLayout tyd;
  private boolean tye;
  private boolean tyf;
  private boolean tyg;
  private int tyh;
  private int tyi;
  private boolean tyj;
  private ObjectAnimator tyk;
  
  public aj(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135211);
    this.mDisabled = true;
    this.tye = false;
    this.tyf = false;
    this.tyg = false;
    this.cCE = false;
    this.tyj = false;
    this.tyk = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(135211);
  }
  
  private void CH(int paramInt)
  {
    AppMethodBeat.i(135220);
    int i = (int)this.tsH.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(135220);
      return;
    }
    Log.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.tyk != null) {
      this.tyk.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.tsH, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135210);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        aj.this.CG((int)f);
        AppMethodBeat.o(135210);
      }
    });
    this.tyk = localObjectAnimator;
    AppMethodBeat.o(135220);
  }
  
  private int getMaxOverScrollDistance()
  {
    AppMethodBeat.i(135217);
    int i = getHeight();
    AppMethodBeat.o(135217);
    return i;
  }
  
  protected void CG(int paramInt) {}
  
  protected boolean apP()
  {
    return false;
  }
  
  protected final void cFp()
  {
    AppMethodBeat.i(135214);
    CH(getStayHeight());
    if (!this.tyf) {
      cFr();
    }
    this.tyg = true;
    this.tyf = true;
    this.cCE = true;
    AppMethodBeat.o(135214);
  }
  
  protected final void cFq()
  {
    AppMethodBeat.i(135215);
    CH(0);
    if (this.tyf) {
      cFs();
    }
    this.tyg = false;
    this.tyf = false;
    this.cCE = false;
    AppMethodBeat.o(135215);
  }
  
  protected void cFr() {}
  
  protected void cFs() {}
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(135218);
    int i = this.tyc.getHeight();
    AppMethodBeat.o(135218);
    return i;
  }
  
  public int getPullDownBackgroundColor()
  {
    AppMethodBeat.i(178618);
    Drawable localDrawable = this.tyd.getBackground();
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
    int i = this.tyc.getHeight();
    AppMethodBeat.o(135219);
    return i;
  }
  
  public final void h(View paramView1, View paramView2)
  {
    AppMethodBeat.i(325214);
    this.tyc = paramView1;
    this.tyd = new FrameLayout(getContext());
    this.tyd.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.tyd.addView(paramView1);
    this.tsH = new FrameLayout(getContext());
    this.tsH.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.tsH.addView(paramView2);
    addView(this.tyd);
    addView(this.tsH);
    AppMethodBeat.o(325214);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135212);
    if (this.mDisabled)
    {
      boolean bool = this.cCE;
      AppMethodBeat.o(135212);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.tyg = false;
      this.tyj = false;
      AppMethodBeat.o(135212);
      return false;
    }
    if ((i == 2) && (this.tyg))
    {
      AppMethodBeat.o(135212);
      return true;
    }
    switch (i)
    {
    }
    while ((this.tyg) || (this.cCE))
    {
      AppMethodBeat.o(135212);
      return true;
      if (apP())
      {
        this.tyh = ((int)paramMotionEvent.getX());
        this.tyi = ((int)paramMotionEvent.getY());
        this.cho = ((int)paramMotionEvent.getY());
        this.tyg = false;
        this.tyj = true;
        continue;
        if (apP())
        {
          if (!this.tyj)
          {
            this.tyh = ((int)paramMotionEvent.getX());
            this.tyi = ((int)paramMotionEvent.getY());
            this.cho = ((int)paramMotionEvent.getY());
            this.tyg = false;
            this.tyj = true;
            AppMethodBeat.o(135212);
            return false;
          }
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          int k = this.tyh;
          int m = j - this.tyi;
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (m > 0))
          {
            this.tyh = i;
            this.tyi = j;
            this.tyg = true;
            this.tyj = false;
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
    if (this.mDisabled)
    {
      if (this.cCE) {
        cFq();
      }
      boolean bool = this.cCE;
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
        } while ((!apP()) && (!this.cCE));
        this.tyi = ((int)paramMotionEvent.getY());
        this.tyh = ((int)paramMotionEvent.getX());
        this.cho = ((int)paramMotionEvent.getY());
        this.tyj = true;
        AppMethodBeat.o(135213);
        return true;
      } while ((!this.tyg) && (!this.cCE));
      if (!this.tyj)
      {
        this.tyi = ((int)paramMotionEvent.getY());
        this.tyh = ((int)paramMotionEvent.getX());
        this.cho = ((int)paramMotionEvent.getY());
        this.tyj = true;
        AppMethodBeat.o(135213);
        return true;
      }
      int k = (int)paramMotionEvent.getY() - this.cho;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.tyf) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        Log.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.tsH.setTranslationY(j);
        CG(i);
        AppMethodBeat.o(135213);
        return true;
      }
      this.tyj = false;
      if ((this.tsH.getTranslationY() > getOpenHeight()) && (this.tye))
      {
        cFp();
        AppMethodBeat.o(135213);
        return true;
      }
    } while ((!this.tyg) && (!this.cCE));
    cFq();
    AppMethodBeat.o(135213);
    return true;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.tye = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135216);
    this.tyd.setBackgroundColor(paramInt);
    AppMethodBeat.o(135216);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mDisabled = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aj
 * JD-Core Version:    0.7.0.1
 */