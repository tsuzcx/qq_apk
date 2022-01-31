package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.y;

public class t
  extends FrameLayout
{
  View QR;
  View gUB;
  FrameLayout gUC;
  FrameLayout gUD;
  public boolean gUE = true;
  private boolean gUF = false;
  private boolean gUG = false;
  private boolean gUH = false;
  private boolean gUI = false;
  private int gUJ;
  private int gUK;
  private ObjectAnimator gUL = null;
  private int jb;
  private int sU;
  
  public t(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jb = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private int getMaxOverScrollDistance()
  {
    return getHeight();
  }
  
  private void ma(int paramInt)
  {
    int i = (int)this.gUD.getTranslationY();
    if (i == paramInt) {
      return;
    }
    y.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.gUL != null) {
      this.gUL.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.gUD, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new t.1(this));
    this.gUL = localObjectAnimator;
  }
  
  protected boolean agD()
  {
    return this.QR.getScrollY() == 0;
  }
  
  protected void anA() {}
  
  protected void anB() {}
  
  protected final void any()
  {
    ma(getStayHeight());
    if (!this.gUG) {
      anA();
    }
    this.gUH = true;
    this.gUG = true;
    this.gUI = true;
  }
  
  protected final void anz()
  {
    ma(0);
    if (this.gUG) {
      anB();
    }
    this.gUH = false;
    this.gUG = false;
    this.gUI = false;
  }
  
  protected int getOpenHeight()
  {
    return this.gUB.getHeight();
  }
  
  protected int getStayHeight()
  {
    return this.gUB.getHeight();
  }
  
  protected void lZ(int paramInt) {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.gUE) {
      bool = this.gUI;
    }
    int i;
    do
    {
      return bool;
      i = paramMotionEvent.getAction();
      if ((i == 3) || (i == 1)) {
        return false;
      }
    } while (this.gUH);
    switch (i)
    {
    }
    int k;
    int j;
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (agD())
          {
            this.gUJ = ((int)paramMotionEvent.getX());
            this.gUK = ((int)paramMotionEvent.getY());
            this.sU = ((int)paramMotionEvent.getY());
          }
        }
      } while (!agD());
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      j = this.gUJ;
      k -= this.gUK;
    } while ((Math.abs(k) <= this.jb) || (Math.abs(k) <= Math.abs(i - j)) || (k <= 0));
    this.gUH = true;
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.gUE)
    {
      if (this.gUI) {
        anz();
      }
      return this.gUI;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.sU = ((int)paramMotionEvent.getY());
      return true;
    case 2: 
      int k = (int)paramMotionEvent.getY() - this.sU;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.gUG) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        y.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.gUD.setTranslationY(j);
        lZ(i);
        return true;
      }
    }
    if ((this.gUD.getTranslationY() > getOpenHeight()) && (this.gUF)) {
      any();
    }
    for (;;)
    {
      return true;
      anz();
    }
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.gUF = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    this.gUC.setBackgroundColor(paramInt);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.gUE = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t
 * JD-Core Version:    0.7.0.1
 */