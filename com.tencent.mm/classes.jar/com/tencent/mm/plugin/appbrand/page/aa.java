package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class aa
  extends FrameLayout
{
  View Qz;
  View ixK;
  FrameLayout ixL;
  FrameLayout ixM;
  public boolean ixN;
  private boolean ixO;
  private boolean ixP;
  private boolean ixQ;
  private boolean ixR;
  private int ixS;
  private int ixT;
  private boolean ixU;
  private ObjectAnimator ixV;
  private int mTouchSlop;
  private int tW;
  
  public aa(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(87278);
    this.ixN = true;
    this.ixO = false;
    this.ixP = false;
    this.ixQ = false;
    this.ixR = false;
    this.ixU = false;
    this.ixV = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(87278);
  }
  
  private int getMaxOverScrollDistance()
  {
    AppMethodBeat.i(87285);
    int i = getHeight();
    AppMethodBeat.o(87285);
    return i;
  }
  
  private void pe(int paramInt)
  {
    AppMethodBeat.i(87288);
    int i = (int)this.ixM.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(87288);
      return;
    }
    ab.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.ixV != null) {
      this.ixV.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ixM, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new aa.1(this));
    this.ixV = localObjectAnimator;
    AppMethodBeat.o(87288);
  }
  
  protected final void aJC()
  {
    AppMethodBeat.i(87281);
    pe(getStayHeight());
    if (!this.ixP) {
      aJE();
    }
    this.ixQ = true;
    this.ixP = true;
    this.ixR = true;
    AppMethodBeat.o(87281);
  }
  
  protected final void aJD()
  {
    AppMethodBeat.i(87282);
    pe(0);
    if (this.ixP) {
      aJF();
    }
    this.ixQ = false;
    this.ixP = false;
    this.ixR = false;
    AppMethodBeat.o(87282);
  }
  
  protected void aJE() {}
  
  protected void aJF() {}
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(87286);
    int i = this.ixK.getHeight();
    AppMethodBeat.o(87286);
    return i;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(87287);
    int i = this.ixK.getHeight();
    AppMethodBeat.o(87287);
    return i;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(87279);
    if (this.ixN)
    {
      boolean bool = this.ixR;
      AppMethodBeat.o(87279);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.ixQ = false;
      this.ixU = false;
      AppMethodBeat.o(87279);
      return false;
    }
    if ((i == 2) && (this.ixQ))
    {
      AppMethodBeat.o(87279);
      return true;
    }
    switch (i)
    {
    }
    while ((this.ixQ) || (this.ixR))
    {
      AppMethodBeat.o(87279);
      return true;
      if (vq())
      {
        this.ixS = ((int)paramMotionEvent.getX());
        this.ixT = ((int)paramMotionEvent.getY());
        this.tW = ((int)paramMotionEvent.getY());
        this.ixQ = false;
        this.ixU = true;
        continue;
        if (vq())
        {
          if (!this.ixU)
          {
            this.ixS = ((int)paramMotionEvent.getX());
            this.ixT = ((int)paramMotionEvent.getY());
            this.tW = ((int)paramMotionEvent.getY());
            this.ixQ = false;
            this.ixU = true;
            AppMethodBeat.o(87279);
            return false;
          }
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          int k = this.ixS;
          int m = j - this.ixT;
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (m > 0))
          {
            this.ixS = i;
            this.ixT = j;
            this.ixQ = true;
            this.ixU = false;
            AppMethodBeat.o(87279);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(87279);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(87280);
    if (this.ixN)
    {
      if (this.ixR) {
        aJD();
      }
      boolean bool = this.ixR;
      AppMethodBeat.o(87280);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      AppMethodBeat.o(87280);
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
          AppMethodBeat.o(87280);
          return false;
        } while ((!vq()) && (!this.ixR));
        this.ixT = ((int)paramMotionEvent.getY());
        this.ixS = ((int)paramMotionEvent.getX());
        this.tW = ((int)paramMotionEvent.getY());
        this.ixU = true;
        AppMethodBeat.o(87280);
        return true;
      } while ((!this.ixQ) && (!this.ixR));
      if (!this.ixU)
      {
        this.ixT = ((int)paramMotionEvent.getY());
        this.ixS = ((int)paramMotionEvent.getX());
        this.tW = ((int)paramMotionEvent.getY());
        this.ixU = true;
        AppMethodBeat.o(87280);
        return true;
      }
      int k = (int)paramMotionEvent.getY() - this.tW;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.ixP) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ab.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.ixM.setTranslationY(j);
        pd(i);
        AppMethodBeat.o(87280);
        return true;
      }
      this.ixU = false;
      if ((this.ixM.getTranslationY() > getOpenHeight()) && (this.ixO))
      {
        aJC();
        AppMethodBeat.o(87280);
        return true;
      }
    } while ((!this.ixQ) && (!this.ixR));
    aJD();
    AppMethodBeat.o(87280);
    return true;
  }
  
  protected void pd(int paramInt) {}
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.ixO = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(87283);
    this.ixL.setBackgroundColor(paramInt);
    AppMethodBeat.o(87283);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ixN = paramBoolean;
      return;
    }
  }
  
  protected boolean vq()
  {
    AppMethodBeat.i(87284);
    if (this.Qz.getScrollY() == 0)
    {
      AppMethodBeat.o(87284);
      return true;
    }
    AppMethodBeat.o(87284);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa
 * JD-Core Version:    0.7.0.1
 */