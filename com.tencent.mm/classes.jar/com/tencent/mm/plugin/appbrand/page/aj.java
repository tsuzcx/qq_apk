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
  private int asF;
  public boolean mDisabled;
  private int mTouchSlop;
  private FrameLayout qoa;
  private boolean qtA;
  private boolean qtB;
  private int qtC;
  private int qtD;
  private boolean qtE;
  private ObjectAnimator qtF;
  private View qtw;
  private FrameLayout qtx;
  private boolean qty;
  private boolean qtz;
  
  public aj(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135211);
    this.mDisabled = true;
    this.qty = false;
    this.qtz = false;
    this.qtA = false;
    this.qtB = false;
    this.qtE = false;
    this.qtF = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(135211);
  }
  
  private void Cr(int paramInt)
  {
    AppMethodBeat.i(135220);
    int i = (int)this.qoa.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(135220);
      return;
    }
    Log.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.qtF != null) {
      this.qtF.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.qoa, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135210);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        aj.this.Cq((int)f);
        AppMethodBeat.o(135210);
      }
    });
    this.qtF = localObjectAnimator;
    AppMethodBeat.o(135220);
  }
  
  private int getMaxOverScrollDistance()
  {
    AppMethodBeat.i(135217);
    int i = getHeight();
    AppMethodBeat.o(135217);
    return i;
  }
  
  protected void Cq(int paramInt) {}
  
  protected boolean PF()
  {
    return false;
  }
  
  protected final void ceM()
  {
    AppMethodBeat.i(135214);
    Cr(getStayHeight());
    if (!this.qtz) {
      ceO();
    }
    this.qtA = true;
    this.qtz = true;
    this.qtB = true;
    AppMethodBeat.o(135214);
  }
  
  protected final void ceN()
  {
    AppMethodBeat.i(135215);
    Cr(0);
    if (this.qtz) {
      ceP();
    }
    this.qtA = false;
    this.qtz = false;
    this.qtB = false;
    AppMethodBeat.o(135215);
  }
  
  protected void ceO() {}
  
  protected void ceP() {}
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(135218);
    int i = this.qtw.getHeight();
    AppMethodBeat.o(135218);
    return i;
  }
  
  public int getPullDownBackgroundColor()
  {
    AppMethodBeat.i(178618);
    Drawable localDrawable = this.qtx.getBackground();
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
    int i = this.qtw.getHeight();
    AppMethodBeat.o(135219);
    return i;
  }
  
  public final void h(View paramView1, View paramView2)
  {
    AppMethodBeat.i(243545);
    this.qtw = paramView1;
    this.qtx = new FrameLayout(getContext());
    this.qtx.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.qtx.addView(paramView1);
    this.qoa = new FrameLayout(getContext());
    this.qoa.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.qoa.addView(paramView2);
    addView(this.qtx);
    addView(this.qoa);
    AppMethodBeat.o(243545);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135212);
    if (this.mDisabled)
    {
      boolean bool = this.qtB;
      AppMethodBeat.o(135212);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.qtA = false;
      this.qtE = false;
      AppMethodBeat.o(135212);
      return false;
    }
    if ((i == 2) && (this.qtA))
    {
      AppMethodBeat.o(135212);
      return true;
    }
    switch (i)
    {
    }
    while ((this.qtA) || (this.qtB))
    {
      AppMethodBeat.o(135212);
      return true;
      if (PF())
      {
        this.qtC = ((int)paramMotionEvent.getX());
        this.qtD = ((int)paramMotionEvent.getY());
        this.asF = ((int)paramMotionEvent.getY());
        this.qtA = false;
        this.qtE = true;
        continue;
        if (PF())
        {
          if (!this.qtE)
          {
            this.qtC = ((int)paramMotionEvent.getX());
            this.qtD = ((int)paramMotionEvent.getY());
            this.asF = ((int)paramMotionEvent.getY());
            this.qtA = false;
            this.qtE = true;
            AppMethodBeat.o(135212);
            return false;
          }
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          int k = this.qtC;
          int m = j - this.qtD;
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (m > 0))
          {
            this.qtC = i;
            this.qtD = j;
            this.qtA = true;
            this.qtE = false;
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
      if (this.qtB) {
        ceN();
      }
      boolean bool = this.qtB;
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
        } while ((!PF()) && (!this.qtB));
        this.qtD = ((int)paramMotionEvent.getY());
        this.qtC = ((int)paramMotionEvent.getX());
        this.asF = ((int)paramMotionEvent.getY());
        this.qtE = true;
        AppMethodBeat.o(135213);
        return true;
      } while ((!this.qtA) && (!this.qtB));
      if (!this.qtE)
      {
        this.qtD = ((int)paramMotionEvent.getY());
        this.qtC = ((int)paramMotionEvent.getX());
        this.asF = ((int)paramMotionEvent.getY());
        this.qtE = true;
        AppMethodBeat.o(135213);
        return true;
      }
      int k = (int)paramMotionEvent.getY() - this.asF;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.qtz) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        Log.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.qoa.setTranslationY(j);
        Cq(i);
        AppMethodBeat.o(135213);
        return true;
      }
      this.qtE = false;
      if ((this.qoa.getTranslationY() > getOpenHeight()) && (this.qty))
      {
        ceM();
        AppMethodBeat.o(135213);
        return true;
      }
    } while ((!this.qtA) && (!this.qtB));
    ceN();
    AppMethodBeat.o(135213);
    return true;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.qty = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135216);
    this.qtx.setBackgroundColor(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aj
 * JD-Core Version:    0.7.0.1
 */