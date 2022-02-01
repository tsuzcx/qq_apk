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
import com.tencent.mm.sdk.platformtools.ad;

public class al
  extends FrameLayout
{
  private int Ao;
  private boolean ldA;
  private boolean ldB;
  private boolean ldC;
  private int ldD;
  private int ldE;
  private boolean ldF;
  private ObjectAnimator ldG;
  View ldv;
  FrameLayout ldw;
  FrameLayout ldx;
  public boolean ldy;
  private boolean ldz;
  private int mTouchSlop;
  
  public al(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135211);
    this.ldy = true;
    this.ldz = false;
    this.ldA = false;
    this.ldB = false;
    this.ldC = false;
    this.ldF = false;
    this.ldG = null;
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
  
  private void tx(int paramInt)
  {
    AppMethodBeat.i(135220);
    int i = (int)this.ldx.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(135220);
      return;
    }
    ad.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.ldG != null) {
      this.ldG.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ldx, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135210);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        al.this.tw((int)f);
        AppMethodBeat.o(135210);
      }
    });
    this.ldG = localObjectAnimator;
    AppMethodBeat.o(135220);
  }
  
  protected boolean Cl()
  {
    return false;
  }
  
  protected final void bkj()
  {
    AppMethodBeat.i(135214);
    tx(getStayHeight());
    if (!this.ldA) {
      bkl();
    }
    this.ldB = true;
    this.ldA = true;
    this.ldC = true;
    AppMethodBeat.o(135214);
  }
  
  protected final void bkk()
  {
    AppMethodBeat.i(135215);
    tx(0);
    if (this.ldA) {
      bkm();
    }
    this.ldB = false;
    this.ldA = false;
    this.ldC = false;
    AppMethodBeat.o(135215);
  }
  
  protected void bkl() {}
  
  protected void bkm() {}
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(135218);
    int i = this.ldv.getHeight();
    AppMethodBeat.o(135218);
    return i;
  }
  
  public int getPullDownBackgroundColor()
  {
    AppMethodBeat.i(178618);
    Drawable localDrawable = this.ldw.getBackground();
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
    int i = this.ldv.getHeight();
    AppMethodBeat.o(135219);
    return i;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135212);
    if (this.ldy)
    {
      boolean bool = this.ldC;
      AppMethodBeat.o(135212);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.ldB = false;
      this.ldF = false;
      AppMethodBeat.o(135212);
      return false;
    }
    if ((i == 2) && (this.ldB))
    {
      AppMethodBeat.o(135212);
      return true;
    }
    switch (i)
    {
    }
    while ((this.ldB) || (this.ldC))
    {
      AppMethodBeat.o(135212);
      return true;
      if (Cl())
      {
        this.ldD = ((int)paramMotionEvent.getX());
        this.ldE = ((int)paramMotionEvent.getY());
        this.Ao = ((int)paramMotionEvent.getY());
        this.ldB = false;
        this.ldF = true;
        continue;
        if (Cl())
        {
          if (!this.ldF)
          {
            this.ldD = ((int)paramMotionEvent.getX());
            this.ldE = ((int)paramMotionEvent.getY());
            this.Ao = ((int)paramMotionEvent.getY());
            this.ldB = false;
            this.ldF = true;
            AppMethodBeat.o(135212);
            return false;
          }
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          int k = this.ldD;
          int m = j - this.ldE;
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (m > 0))
          {
            this.ldD = i;
            this.ldE = j;
            this.ldB = true;
            this.ldF = false;
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
    if (this.ldy)
    {
      if (this.ldC) {
        bkk();
      }
      boolean bool = this.ldC;
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
        } while ((!Cl()) && (!this.ldC));
        this.ldE = ((int)paramMotionEvent.getY());
        this.ldD = ((int)paramMotionEvent.getX());
        this.Ao = ((int)paramMotionEvent.getY());
        this.ldF = true;
        AppMethodBeat.o(135213);
        return true;
      } while ((!this.ldB) && (!this.ldC));
      if (!this.ldF)
      {
        this.ldE = ((int)paramMotionEvent.getY());
        this.ldD = ((int)paramMotionEvent.getX());
        this.Ao = ((int)paramMotionEvent.getY());
        this.ldF = true;
        AppMethodBeat.o(135213);
        return true;
      }
      int k = (int)paramMotionEvent.getY() - this.Ao;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.ldA) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ad.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.ldx.setTranslationY(j);
        tw(i);
        AppMethodBeat.o(135213);
        return true;
      }
      this.ldF = false;
      if ((this.ldx.getTranslationY() > getOpenHeight()) && (this.ldz))
      {
        bkj();
        AppMethodBeat.o(135213);
        return true;
      }
    } while ((!this.ldB) && (!this.ldC));
    bkk();
    AppMethodBeat.o(135213);
    return true;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.ldz = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135216);
    this.ldw.setBackgroundColor(paramInt);
    AppMethodBeat.o(135216);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ldy = paramBoolean;
      return;
    }
  }
  
  protected void tw(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al
 * JD-Core Version:    0.7.0.1
 */