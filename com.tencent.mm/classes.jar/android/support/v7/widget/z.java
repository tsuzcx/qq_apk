package android.support.v7.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.t;
import android.view.MotionEvent;

final class z
  extends RecyclerView.h
  implements RecyclerView.l
{
  private static final int[] EMPTY_STATE_SET = new int[0];
  private static final int[] PRESSED_STATE_SET = { 16842919 };
  private int Mw = 0;
  private final RecyclerView.m adA = new z.2(this);
  final int adc;
  private final StateListDrawable add;
  private final Drawable ade;
  private final int adf;
  private final int adg;
  private final StateListDrawable adh;
  private final Drawable adi;
  private final int adj;
  private final int adk;
  int adl;
  int adm;
  float adn;
  int ado;
  int adp;
  float adq;
  int adr = 0;
  int ads = 0;
  RecyclerView adt;
  boolean adu = false;
  boolean adv = false;
  private final int[] adw = new int[2];
  private final int[] adx = new int[2];
  final ValueAnimator ady = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  int adz = 0;
  private final Runnable mHideRunnable = new z.1(this);
  private final int mMargin;
  int mState = 0;
  
  z(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.add = paramStateListDrawable1;
    this.ade = paramDrawable1;
    this.adh = paramStateListDrawable2;
    this.adi = paramDrawable2;
    this.adf = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.adg = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.adj = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.adk = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.adc = paramInt2;
    this.mMargin = paramInt3;
    this.add.setAlpha(255);
    this.ade.setAlpha(255);
    this.ady.addListener(new z.a(this, (byte)0));
    this.ady.addUpdateListener(new z.b(this, (byte)0));
    if (this.adt != paramRecyclerView)
    {
      if (this.adt != null)
      {
        this.adt.c(this);
        this.adt.b(this);
        this.adt.b(this.adA);
        hF();
      }
      this.adt = paramRecyclerView;
      if (this.adt != null)
      {
        this.adt.a(this);
        this.adt.a(this);
        this.adt.a(this.adA);
      }
    }
  }
  
  private static int a(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i == 0) {}
    do
    {
      return 0;
      paramFloat1 = (paramFloat2 - paramFloat1) / i;
      paramInt1 -= paramInt3;
      paramInt3 = (int)(paramFloat1 * paramInt1);
      paramInt2 += paramInt3;
    } while ((paramInt2 >= paramInt1) || (paramInt2 < 0));
    return paramInt3;
  }
  
  private void bw(int paramInt)
  {
    hF();
    this.adt.postDelayed(this.mHideRunnable, paramInt);
  }
  
  private boolean hE()
  {
    return t.T(this.adt) == 1;
  }
  
  private void hF()
  {
    this.adt.removeCallbacks(this.mHideRunnable);
  }
  
  private void show()
  {
    switch (this.adz)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.ady.cancel();
    }
    this.adz = 1;
    this.ady.setFloatValues(new float[] { ((Float)this.ady.getAnimatedValue()).floatValue(), 1.0F });
    this.ady.setDuration(500L);
    this.ady.setStartDelay(0L);
    this.ady.start();
  }
  
  private boolean v(float paramFloat1, float paramFloat2)
  {
    if (hE())
    {
      if (paramFloat1 > this.adf / 2) {}
    }
    else {
      while (paramFloat1 >= this.adr - this.adf)
      {
        if ((paramFloat2 < this.adm - this.adl / 2) || (paramFloat2 > this.adm + this.adl / 2)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean w(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.ads - this.adj) && (paramFloat1 >= this.adp - this.ado / 2) && (paramFloat1 <= this.adp + this.ado / 2);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    if ((this.adr != this.adt.getWidth()) || (this.ads != this.adt.getHeight()))
    {
      this.adr = this.adt.getWidth();
      this.ads = this.adt.getHeight();
      setState(0);
    }
    for (;;)
    {
      return;
      if (this.adz != 0)
      {
        int i;
        int j;
        if (this.adu)
        {
          i = this.adr - this.adf;
          j = this.adm - this.adl / 2;
          this.add.setBounds(0, 0, this.adf, this.adl);
          this.ade.setBounds(0, 0, this.adg, this.ads);
          if (!hE()) {
            break label297;
          }
          this.ade.draw(paramCanvas);
          paramCanvas.translate(this.adf, j);
          paramCanvas.scale(-1.0F, 1.0F);
          this.add.draw(paramCanvas);
          paramCanvas.scale(1.0F, 1.0F);
          paramCanvas.translate(-this.adf, -j);
        }
        while (this.adv)
        {
          i = this.ads - this.adj;
          j = this.adp - this.ado / 2;
          this.adh.setBounds(0, 0, this.ado, this.adj);
          this.adi.setBounds(0, 0, this.adr, this.adk);
          paramCanvas.translate(0.0F, i);
          this.adi.draw(paramCanvas);
          paramCanvas.translate(j, 0.0F);
          this.adh.draw(paramCanvas);
          paramCanvas.translate(-j, -i);
          return;
          label297:
          paramCanvas.translate(i, 0.0F);
          this.ade.draw(paramCanvas);
          paramCanvas.translate(0.0F, j);
          this.add.draw(paramCanvas);
          paramCanvas.translate(-i, -j);
        }
      }
    }
  }
  
  public final void ac(boolean paramBoolean) {}
  
  public final boolean h(MotionEvent paramMotionEvent)
  {
    if (this.mState == 1)
    {
      bool1 = v(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool2 = w(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() == 0) && ((bool1) || (bool2))) {
        if (bool2)
        {
          this.Mw = 1;
          this.adq = ((int)paramMotionEvent.getX());
          setState(2);
        }
      }
    }
    while (this.mState == 2)
    {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        return true;
        if (bool1)
        {
          this.Mw = 2;
          this.adn = ((int)paramMotionEvent.getY());
        }
      }
      return false;
    }
    return false;
  }
  
  public final void i(MotionEvent paramMotionEvent)
  {
    if (this.mState == 0) {}
    float f;
    do
    {
      do
      {
        do
        {
          boolean bool1;
          boolean bool2;
          do
          {
            return;
            if (paramMotionEvent.getAction() != 0) {
              break;
            }
            bool1 = v(paramMotionEvent.getX(), paramMotionEvent.getY());
            bool2 = w(paramMotionEvent.getX(), paramMotionEvent.getY());
          } while ((!bool1) && (!bool2));
          if (bool2)
          {
            this.Mw = 1;
            this.adq = ((int)paramMotionEvent.getX());
          }
          for (;;)
          {
            setState(2);
            return;
            if (bool1)
            {
              this.Mw = 2;
              this.adn = ((int)paramMotionEvent.getY());
            }
          }
          if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
          {
            this.adn = 0.0F;
            this.adq = 0.0F;
            setState(1);
            this.Mw = 0;
            return;
          }
        } while ((paramMotionEvent.getAction() != 2) || (this.mState != 2));
        show();
        if (this.Mw == 1)
        {
          f = paramMotionEvent.getX();
          this.adx[0] = this.mMargin;
          this.adx[1] = (this.adr - this.mMargin);
          int[] arrayOfInt = this.adx;
          f = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], f));
          if (Math.abs(this.adp - f) >= 2.0F)
          {
            i = a(this.adq, f, arrayOfInt, this.adt.computeHorizontalScrollRange(), this.adt.computeHorizontalScrollOffset(), this.adr);
            if (i != 0) {
              this.adt.scrollBy(i, 0);
            }
            this.adq = f;
          }
        }
      } while (this.Mw != 2);
      f = paramMotionEvent.getY();
      this.adw[0] = this.mMargin;
      this.adw[1] = (this.ads - this.mMargin);
      paramMotionEvent = this.adw;
      f = Math.max(paramMotionEvent[0], Math.min(paramMotionEvent[1], f));
    } while (Math.abs(this.adm - f) < 2.0F);
    int i = a(this.adn, f, paramMotionEvent, this.adt.computeVerticalScrollRange(), this.adt.computeVerticalScrollOffset(), this.ads);
    if (i != 0) {
      this.adt.scrollBy(0, i);
    }
    this.adn = f;
  }
  
  final void setState(int paramInt)
  {
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.add.setState(PRESSED_STATE_SET);
      hF();
    }
    if (paramInt == 0)
    {
      this.adt.invalidate();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label83;
      }
      this.add.setState(EMPTY_STATE_SET);
      bw(1200);
    }
    for (;;)
    {
      this.mState = paramInt;
      return;
      show();
      break;
      label83:
      if (paramInt == 1) {
        bw(1500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.z
 * JD-Core Version:    0.7.0.1
 */