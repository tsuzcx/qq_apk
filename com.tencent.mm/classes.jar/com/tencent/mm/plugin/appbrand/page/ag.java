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

public class ag
  extends FrameLayout
{
  private int De;
  private int mTouchSlop;
  View mcP;
  FrameLayout mcQ;
  FrameLayout mcR;
  public boolean mcS;
  private boolean mcT;
  private boolean mcU;
  private boolean mcV;
  private boolean mcW;
  private int mcX;
  private int mcY;
  private boolean mcZ;
  private ObjectAnimator mda;
  
  public ag(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135211);
    this.mcS = true;
    this.mcT = false;
    this.mcU = false;
    this.mcV = false;
    this.mcW = false;
    this.mcZ = false;
    this.mda = null;
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
  
  private void uR(int paramInt)
  {
    AppMethodBeat.i(135220);
    int i = (int)this.mcR.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(135220);
      return;
    }
    ad.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.mda != null) {
      this.mda.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mcR, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(135210);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ag.this.uQ((int)f);
        AppMethodBeat.o(135210);
      }
    });
    this.mda = localObjectAnimator;
    AppMethodBeat.o(135220);
  }
  
  protected boolean Do()
  {
    return false;
  }
  
  protected final void buZ()
  {
    AppMethodBeat.i(135214);
    uR(getStayHeight());
    if (!this.mcU) {
      bvb();
    }
    this.mcV = true;
    this.mcU = true;
    this.mcW = true;
    AppMethodBeat.o(135214);
  }
  
  protected final void bva()
  {
    AppMethodBeat.i(135215);
    uR(0);
    if (this.mcU) {
      bvc();
    }
    this.mcV = false;
    this.mcU = false;
    this.mcW = false;
    AppMethodBeat.o(135215);
  }
  
  protected void bvb() {}
  
  protected void bvc() {}
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(135218);
    int i = this.mcP.getHeight();
    AppMethodBeat.o(135218);
    return i;
  }
  
  public int getPullDownBackgroundColor()
  {
    AppMethodBeat.i(178618);
    Drawable localDrawable = this.mcQ.getBackground();
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
    int i = this.mcP.getHeight();
    AppMethodBeat.o(135219);
    return i;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(135212);
    if (this.mcS)
    {
      boolean bool = this.mcW;
      AppMethodBeat.o(135212);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.mcV = false;
      this.mcZ = false;
      AppMethodBeat.o(135212);
      return false;
    }
    if ((i == 2) && (this.mcV))
    {
      AppMethodBeat.o(135212);
      return true;
    }
    switch (i)
    {
    }
    while ((this.mcV) || (this.mcW))
    {
      AppMethodBeat.o(135212);
      return true;
      if (Do())
      {
        this.mcX = ((int)paramMotionEvent.getX());
        this.mcY = ((int)paramMotionEvent.getY());
        this.De = ((int)paramMotionEvent.getY());
        this.mcV = false;
        this.mcZ = true;
        continue;
        if (Do())
        {
          if (!this.mcZ)
          {
            this.mcX = ((int)paramMotionEvent.getX());
            this.mcY = ((int)paramMotionEvent.getY());
            this.De = ((int)paramMotionEvent.getY());
            this.mcV = false;
            this.mcZ = true;
            AppMethodBeat.o(135212);
            return false;
          }
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          int k = this.mcX;
          int m = j - this.mcY;
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (m > 0))
          {
            this.mcX = i;
            this.mcY = j;
            this.mcV = true;
            this.mcZ = false;
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
    if (this.mcS)
    {
      if (this.mcW) {
        bva();
      }
      boolean bool = this.mcW;
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
        } while ((!Do()) && (!this.mcW));
        this.mcY = ((int)paramMotionEvent.getY());
        this.mcX = ((int)paramMotionEvent.getX());
        this.De = ((int)paramMotionEvent.getY());
        this.mcZ = true;
        AppMethodBeat.o(135213);
        return true;
      } while ((!this.mcV) && (!this.mcW));
      if (!this.mcZ)
      {
        this.mcY = ((int)paramMotionEvent.getY());
        this.mcX = ((int)paramMotionEvent.getX());
        this.De = ((int)paramMotionEvent.getY());
        this.mcZ = true;
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
        if (this.mcU) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ad.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.mcR.setTranslationY(j);
        uQ(i);
        AppMethodBeat.o(135213);
        return true;
      }
      this.mcZ = false;
      if ((this.mcR.getTranslationY() > getOpenHeight()) && (this.mcT))
      {
        buZ();
        AppMethodBeat.o(135213);
        return true;
      }
    } while ((!this.mcV) && (!this.mcW));
    bva();
    AppMethodBeat.o(135213);
    return true;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.mcT = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135216);
    this.mcQ.setBackgroundColor(paramInt);
    AppMethodBeat.o(135216);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mcS = paramBoolean;
      return;
    }
  }
  
  protected void uQ(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag
 * JD-Core Version:    0.7.0.1
 */