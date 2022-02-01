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

public class ai
  extends FrameLayout
{
  private int Dn;
  public boolean mDisabled;
  private int mTouchSlop;
  FrameLayout nms;
  View nrE;
  FrameLayout nrF;
  private boolean nrG;
  private boolean nrH;
  private boolean nrI;
  private boolean nrJ;
  private int nrK;
  private int nrL;
  private boolean nrM;
  private ObjectAnimator nrN;
  
  public ai(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135211);
    this.mDisabled = true;
    this.nrG = false;
    this.nrH = false;
    this.nrI = false;
    this.nrJ = false;
    this.nrM = false;
    this.nrN = null;
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
  
  private void yN(int paramInt)
  {
    AppMethodBeat.i(135220);
    int i = (int)this.nms.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(135220);
      return;
    }
    Log.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.nrN != null) {
      this.nrN.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.nms, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135210);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ai.this.yM((int)f);
        AppMethodBeat.o(135210);
      }
    });
    this.nrN = localObjectAnimator;
    AppMethodBeat.o(135220);
  }
  
  protected boolean MN()
  {
    return false;
  }
  
  protected final void bRP()
  {
    AppMethodBeat.i(135214);
    yN(getStayHeight());
    if (!this.nrH) {
      bRR();
    }
    this.nrI = true;
    this.nrH = true;
    this.nrJ = true;
    AppMethodBeat.o(135214);
  }
  
  protected final void bRQ()
  {
    AppMethodBeat.i(135215);
    yN(0);
    if (this.nrH) {
      bRS();
    }
    this.nrI = false;
    this.nrH = false;
    this.nrJ = false;
    AppMethodBeat.o(135215);
  }
  
  protected void bRR() {}
  
  protected void bRS() {}
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(135218);
    int i = this.nrE.getHeight();
    AppMethodBeat.o(135218);
    return i;
  }
  
  public int getPullDownBackgroundColor()
  {
    AppMethodBeat.i(178618);
    Drawable localDrawable = this.nrF.getBackground();
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
    int i = this.nrE.getHeight();
    AppMethodBeat.o(135219);
    return i;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135212);
    if (this.mDisabled)
    {
      boolean bool = this.nrJ;
      AppMethodBeat.o(135212);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.nrI = false;
      this.nrM = false;
      AppMethodBeat.o(135212);
      return false;
    }
    if ((i == 2) && (this.nrI))
    {
      AppMethodBeat.o(135212);
      return true;
    }
    switch (i)
    {
    }
    while ((this.nrI) || (this.nrJ))
    {
      AppMethodBeat.o(135212);
      return true;
      if (MN())
      {
        this.nrK = ((int)paramMotionEvent.getX());
        this.nrL = ((int)paramMotionEvent.getY());
        this.Dn = ((int)paramMotionEvent.getY());
        this.nrI = false;
        this.nrM = true;
        continue;
        if (MN())
        {
          if (!this.nrM)
          {
            this.nrK = ((int)paramMotionEvent.getX());
            this.nrL = ((int)paramMotionEvent.getY());
            this.Dn = ((int)paramMotionEvent.getY());
            this.nrI = false;
            this.nrM = true;
            AppMethodBeat.o(135212);
            return false;
          }
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          int k = this.nrK;
          int m = j - this.nrL;
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (m > 0))
          {
            this.nrK = i;
            this.nrL = j;
            this.nrI = true;
            this.nrM = false;
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
      if (this.nrJ) {
        bRQ();
      }
      boolean bool = this.nrJ;
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
        } while ((!MN()) && (!this.nrJ));
        this.nrL = ((int)paramMotionEvent.getY());
        this.nrK = ((int)paramMotionEvent.getX());
        this.Dn = ((int)paramMotionEvent.getY());
        this.nrM = true;
        AppMethodBeat.o(135213);
        return true;
      } while ((!this.nrI) && (!this.nrJ));
      if (!this.nrM)
      {
        this.nrL = ((int)paramMotionEvent.getY());
        this.nrK = ((int)paramMotionEvent.getX());
        this.Dn = ((int)paramMotionEvent.getY());
        this.nrM = true;
        AppMethodBeat.o(135213);
        return true;
      }
      int k = (int)paramMotionEvent.getY() - this.Dn;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.nrH) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        Log.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.nms.setTranslationY(j);
        yM(i);
        AppMethodBeat.o(135213);
        return true;
      }
      this.nrM = false;
      if ((this.nms.getTranslationY() > getOpenHeight()) && (this.nrG))
      {
        bRP();
        AppMethodBeat.o(135213);
        return true;
      }
    } while ((!this.nrI) && (!this.nrJ));
    bRQ();
    AppMethodBeat.o(135213);
    return true;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.nrG = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135216);
    this.nrF.setBackgroundColor(paramInt);
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
  
  protected void yM(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ai
 * JD-Core Version:    0.7.0.1
 */