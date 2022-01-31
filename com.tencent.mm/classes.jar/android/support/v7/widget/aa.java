package android.support.v7.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.q;
import android.view.MotionEvent;

final class aa
  extends RecyclerView.h
  implements RecyclerView.l
{
  private static final int[] EMPTY_STATE_SET = new int[0];
  private static final int[] PRESSED_STATE_SET = { 16842919 };
  private int MI = 0;
  int acA;
  int acB;
  float acC;
  int acD;
  int acE;
  float acF;
  int acG = 0;
  int acH = 0;
  RecyclerView acI;
  boolean acJ = false;
  boolean acK = false;
  private final int[] acL = new int[2];
  private final int[] acM = new int[2];
  final ValueAnimator acN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  int acO = 0;
  private final Runnable acP = new aa.1(this);
  private final RecyclerView.m acQ = new aa.2(this);
  final int acq;
  private final int acr;
  private final StateListDrawable acs;
  private final Drawable act;
  private final int acu;
  private final int acv;
  private final StateListDrawable acw;
  private final Drawable acx;
  private final int acy;
  private final int acz;
  int mState = 0;
  
  aa(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.acs = paramStateListDrawable1;
    this.act = paramDrawable1;
    this.acw = paramStateListDrawable2;
    this.acx = paramDrawable2;
    this.acu = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.acv = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.acy = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.acz = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.acq = paramInt2;
    this.acr = paramInt3;
    this.acs.setAlpha(255);
    this.act.setAlpha(255);
    this.acN.addListener(new aa.a(this, (byte)0));
    this.acN.addUpdateListener(new aa.b(this, (byte)0));
    if (this.acI != paramRecyclerView)
    {
      if (this.acI != null)
      {
        this.acI.b(this);
        this.acI.b(this);
        this.acI.b(this.acQ);
        gF();
      }
      this.acI = paramRecyclerView;
      if (this.acI != null)
      {
        this.acI.a(this);
        this.acI.a(this);
        this.acI.a(this.acQ);
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
    gF();
    this.acI.postDelayed(this.acP, paramInt);
  }
  
  private boolean gE()
  {
    return q.Q(this.acI) == 1;
  }
  
  private void gF()
  {
    this.acI.removeCallbacks(this.acP);
  }
  
  private void show()
  {
    switch (this.acO)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.acN.cancel();
    }
    this.acO = 1;
    this.acN.setFloatValues(new float[] { ((Float)this.acN.getAnimatedValue()).floatValue(), 1.0F });
    this.acN.setDuration(500L);
    this.acN.setStartDelay(0L);
    this.acN.start();
  }
  
  private boolean w(float paramFloat1, float paramFloat2)
  {
    if (gE())
    {
      if (paramFloat1 > this.acu / 2) {}
    }
    else {
      while (paramFloat1 >= this.acG - this.acu)
      {
        if ((paramFloat2 < this.acB - this.acA / 2) || (paramFloat2 > this.acB + this.acA / 2)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean x(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.acH - this.acy) && (paramFloat1 >= this.acE - this.acD / 2) && (paramFloat1 <= this.acE + this.acD / 2);
  }
  
  public final void Z(boolean paramBoolean) {}
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    if ((this.acG != this.acI.getWidth()) || (this.acH != this.acI.getHeight()))
    {
      this.acG = this.acI.getWidth();
      this.acH = this.acI.getHeight();
      setState(0);
    }
    for (;;)
    {
      return;
      if (this.acO != 0)
      {
        int i;
        int j;
        if (this.acJ)
        {
          i = this.acG - this.acu;
          j = this.acB - this.acA / 2;
          this.acs.setBounds(0, 0, this.acu, this.acA);
          this.act.setBounds(0, 0, this.acv, this.acH);
          if (!gE()) {
            break label297;
          }
          this.act.draw(paramCanvas);
          paramCanvas.translate(this.acu, j);
          paramCanvas.scale(-1.0F, 1.0F);
          this.acs.draw(paramCanvas);
          paramCanvas.scale(1.0F, 1.0F);
          paramCanvas.translate(-this.acu, -j);
        }
        while (this.acK)
        {
          i = this.acH - this.acy;
          j = this.acE - this.acD / 2;
          this.acw.setBounds(0, 0, this.acD, this.acy);
          this.acx.setBounds(0, 0, this.acG, this.acz);
          paramCanvas.translate(0.0F, i);
          this.acx.draw(paramCanvas);
          paramCanvas.translate(j, 0.0F);
          this.acw.draw(paramCanvas);
          paramCanvas.translate(-j, -i);
          return;
          label297:
          paramCanvas.translate(i, 0.0F);
          this.act.draw(paramCanvas);
          paramCanvas.translate(0.0F, j);
          this.acs.draw(paramCanvas);
          paramCanvas.translate(-i, -j);
        }
      }
    }
  }
  
  public final boolean h(MotionEvent paramMotionEvent)
  {
    if (this.mState == 1)
    {
      bool1 = w(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool2 = x(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() == 0) && ((bool1) || (bool2))) {
        if (bool2)
        {
          this.MI = 1;
          this.acF = ((int)paramMotionEvent.getX());
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
          this.MI = 2;
          this.acC = ((int)paramMotionEvent.getY());
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
            bool1 = w(paramMotionEvent.getX(), paramMotionEvent.getY());
            bool2 = x(paramMotionEvent.getX(), paramMotionEvent.getY());
          } while ((!bool1) && (!bool2));
          if (bool2)
          {
            this.MI = 1;
            this.acF = ((int)paramMotionEvent.getX());
          }
          for (;;)
          {
            setState(2);
            return;
            if (bool1)
            {
              this.MI = 2;
              this.acC = ((int)paramMotionEvent.getY());
            }
          }
          if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
          {
            this.acC = 0.0F;
            this.acF = 0.0F;
            setState(1);
            this.MI = 0;
            return;
          }
        } while ((paramMotionEvent.getAction() != 2) || (this.mState != 2));
        show();
        if (this.MI == 1)
        {
          f = paramMotionEvent.getX();
          this.acM[0] = this.acr;
          this.acM[1] = (this.acG - this.acr);
          int[] arrayOfInt = this.acM;
          f = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], f));
          if (Math.abs(this.acE - f) >= 2.0F)
          {
            i = a(this.acF, f, arrayOfInt, this.acI.computeHorizontalScrollRange(), this.acI.computeHorizontalScrollOffset(), this.acG);
            if (i != 0) {
              this.acI.scrollBy(i, 0);
            }
            this.acF = f;
          }
        }
      } while (this.MI != 2);
      f = paramMotionEvent.getY();
      this.acL[0] = this.acr;
      this.acL[1] = (this.acH - this.acr);
      paramMotionEvent = this.acL;
      f = Math.max(paramMotionEvent[0], Math.min(paramMotionEvent[1], f));
    } while (Math.abs(this.acB - f) < 2.0F);
    int i = a(this.acC, f, paramMotionEvent, this.acI.computeVerticalScrollRange(), this.acI.computeVerticalScrollOffset(), this.acH);
    if (i != 0) {
      this.acI.scrollBy(0, i);
    }
    this.acC = f;
  }
  
  final void setState(int paramInt)
  {
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.acs.setState(PRESSED_STATE_SET);
      gF();
    }
    if (paramInt == 0)
    {
      this.acI.invalidate();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label83;
      }
      this.acs.setState(EMPTY_STATE_SET);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.aa
 * JD-Core Version:    0.7.0.1
 */