package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
  private int Tz = 0;
  RecyclerView akA;
  boolean akB = false;
  boolean akC = false;
  private final int[] akD = new int[2];
  private final int[] akE = new int[2];
  final ValueAnimator akF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  int akG = 0;
  private final RecyclerView.m akH = new RecyclerView.m()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      z localz = z.this;
      paramAnonymousInt1 = paramAnonymousRecyclerView.computeHorizontalScrollOffset();
      paramAnonymousInt2 = paramAnonymousRecyclerView.computeVerticalScrollOffset();
      int i = localz.akA.computeVerticalScrollRange();
      int j = localz.akz;
      boolean bool;
      int k;
      int m;
      if ((i - j > 0) && (localz.akz >= localz.akj))
      {
        bool = true;
        localz.akB = bool;
        k = localz.akA.computeHorizontalScrollRange();
        m = localz.aky;
        if ((k - m <= 0) || (localz.aky < localz.akj)) {
          break label149;
        }
        bool = true;
        label105:
        localz.akC = bool;
        if ((localz.akB) || (localz.akC)) {
          break label155;
        }
        if (localz.mState != 0) {
          localz.setState(0);
        }
      }
      label149:
      label155:
      do
      {
        return;
        bool = false;
        break;
        bool = false;
        break label105;
        if (localz.akB)
        {
          localz.akt = ((int)((paramAnonymousInt2 + j / 2.0F) * j / i));
          localz.aks = Math.min(j, j * j / i);
        }
        if (localz.akC)
        {
          localz.akw = ((int)((paramAnonymousInt1 + m / 2.0F) * m / k));
          localz.akv = Math.min(m, m * m / k);
        }
      } while ((localz.mState != 0) && (localz.mState != 1));
      localz.setState(1);
    }
  };
  final int akj;
  final StateListDrawable akk;
  final Drawable akl;
  private final int akm;
  private final int akn;
  private final StateListDrawable ako;
  private final Drawable akp;
  private final int akq;
  private final int akr;
  int aks;
  int akt;
  float aku;
  int akv;
  int akw;
  float akx;
  int aky = 0;
  int akz = 0;
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      z localz = z.this;
      switch (localz.akG)
      {
      default: 
        return;
      case 1: 
        localz.akF.cancel();
      }
      localz.akG = 3;
      localz.akF.setFloatValues(new float[] { ((Float)localz.akF.getAnimatedValue()).floatValue(), 0.0F });
      localz.akF.setDuration(500L);
      localz.akF.start();
    }
  };
  private final int mMargin;
  int mState = 0;
  
  z(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.akk = paramStateListDrawable1;
    this.akl = paramDrawable1;
    this.ako = paramStateListDrawable2;
    this.akp = paramDrawable2;
    this.akm = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.akn = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.akq = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.akr = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.akj = paramInt2;
    this.mMargin = paramInt3;
    this.akk.setAlpha(255);
    this.akl.setAlpha(255);
    this.akF.addListener(new a());
    this.akF.addUpdateListener(new b());
    if (this.akA != paramRecyclerView)
    {
      if (this.akA != null)
      {
        this.akA.c(this);
        this.akA.b(this);
        this.akA.b(this.akH);
        jb();
      }
      this.akA = paramRecyclerView;
      if (this.akA != null)
      {
        this.akA.a(this);
        this.akA.a(this);
        this.akA.a(this.akH);
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
  
  private void bN(int paramInt)
  {
    jb();
    this.akA.postDelayed(this.mHideRunnable, paramInt);
  }
  
  private boolean ja()
  {
    return t.Y(this.akA) == 1;
  }
  
  private void jb()
  {
    this.akA.removeCallbacks(this.mHideRunnable);
  }
  
  private boolean m(float paramFloat1, float paramFloat2)
  {
    if (ja())
    {
      if (paramFloat1 > this.akm / 2) {}
    }
    else {
      while (paramFloat1 >= this.aky - this.akm)
      {
        if ((paramFloat2 < this.akt - this.aks / 2) || (paramFloat2 > this.akt + this.aks / 2)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean n(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.akz - this.akq) && (paramFloat1 >= this.akw - this.akv / 2) && (paramFloat1 <= this.akw + this.akv / 2);
  }
  
  private void show()
  {
    switch (this.akG)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.akF.cancel();
    }
    this.akG = 1;
    this.akF.setFloatValues(new float[] { ((Float)this.akF.getAnimatedValue()).floatValue(), 1.0F });
    this.akF.setDuration(500L);
    this.akF.setStartDelay(0L);
    this.akF.start();
  }
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (this.mState == 1)
    {
      bool1 = m(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool2 = n(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() == 0) && ((bool1) || (bool2))) {
        if (bool2)
        {
          this.Tz = 1;
          this.akx = ((int)paramMotionEvent.getX());
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
          this.Tz = 2;
          this.aku = ((int)paramMotionEvent.getY());
        }
      }
      return false;
    }
    return false;
  }
  
  public final void ai(boolean paramBoolean) {}
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    if ((this.aky != this.akA.getWidth()) || (this.akz != this.akA.getHeight()))
    {
      this.aky = this.akA.getWidth();
      this.akz = this.akA.getHeight();
      setState(0);
    }
    for (;;)
    {
      return;
      if (this.akG != 0)
      {
        int i;
        int j;
        if (this.akB)
        {
          i = this.aky - this.akm;
          j = this.akt - this.aks / 2;
          this.akk.setBounds(0, 0, this.akm, this.aks);
          this.akl.setBounds(0, 0, this.akn, this.akz);
          if (!ja()) {
            break label301;
          }
          this.akl.draw(paramCanvas);
          paramCanvas.translate(this.akm, j);
          paramCanvas.scale(-1.0F, 1.0F);
          this.akk.draw(paramCanvas);
          paramCanvas.scale(1.0F, 1.0F);
          paramCanvas.translate(-this.akm, -j);
        }
        while (this.akC)
        {
          i = this.akz - this.akq;
          j = this.akw - this.akv / 2;
          this.ako.setBounds(0, 0, this.akv, this.akq);
          this.akp.setBounds(0, 0, this.aky, this.akr);
          paramCanvas.translate(0.0F, i);
          this.akp.draw(paramCanvas);
          paramCanvas.translate(j, 0.0F);
          this.ako.draw(paramCanvas);
          paramCanvas.translate(-j, -i);
          return;
          label301:
          paramCanvas.translate(i, 0.0F);
          this.akl.draw(paramCanvas);
          paramCanvas.translate(0.0F, j);
          this.akk.draw(paramCanvas);
          paramCanvas.translate(-i, -j);
        }
      }
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
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
            bool1 = m(paramMotionEvent.getX(), paramMotionEvent.getY());
            bool2 = n(paramMotionEvent.getX(), paramMotionEvent.getY());
          } while ((!bool1) && (!bool2));
          if (bool2)
          {
            this.Tz = 1;
            this.akx = ((int)paramMotionEvent.getX());
          }
          for (;;)
          {
            setState(2);
            return;
            if (bool1)
            {
              this.Tz = 2;
              this.aku = ((int)paramMotionEvent.getY());
            }
          }
          if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
          {
            this.aku = 0.0F;
            this.akx = 0.0F;
            setState(1);
            this.Tz = 0;
            return;
          }
        } while ((paramMotionEvent.getAction() != 2) || (this.mState != 2));
        show();
        if (this.Tz == 1)
        {
          f = paramMotionEvent.getX();
          this.akE[0] = this.mMargin;
          this.akE[1] = (this.aky - this.mMargin);
          paramRecyclerView = this.akE;
          f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
          if (Math.abs(this.akw - f) >= 2.0F)
          {
            i = a(this.akx, f, paramRecyclerView, this.akA.computeHorizontalScrollRange(), this.akA.computeHorizontalScrollOffset(), this.aky);
            if (i != 0) {
              this.akA.scrollBy(i, 0);
            }
            this.akx = f;
          }
        }
      } while (this.Tz != 2);
      f = paramMotionEvent.getY();
      this.akD[0] = this.mMargin;
      this.akD[1] = (this.akz - this.mMargin);
      paramRecyclerView = this.akD;
      f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
    } while (Math.abs(this.akt - f) < 2.0F);
    int i = a(this.aku, f, paramRecyclerView, this.akA.computeVerticalScrollRange(), this.akA.computeVerticalScrollOffset(), this.akz);
    if (i != 0) {
      this.akA.scrollBy(0, i);
    }
    this.aku = f;
  }
  
  final void setState(int paramInt)
  {
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.akk.setState(PRESSED_STATE_SET);
      jb();
    }
    if (paramInt == 0)
    {
      this.akA.invalidate();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label83;
      }
      this.akk.setState(EMPTY_STATE_SET);
      bN(1200);
    }
    for (;;)
    {
      this.mState = paramInt;
      return;
      show();
      break;
      label83:
      if (paramInt == 1) {
        bN(1500);
      }
    }
  }
  
  final class a
    extends AnimatorListenerAdapter
  {
    private boolean mCanceled = false;
    
    a() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      if (this.mCanceled)
      {
        this.mCanceled = false;
        return;
      }
      if (((Float)z.this.akF.getAnimatedValue()).floatValue() == 0.0F)
      {
        z.this.akG = 0;
        z.this.setState(0);
        return;
      }
      z.this.akG = 2;
      z.this.akA.invalidate();
    }
  }
  
  final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      z.this.akk.setAlpha(i);
      z.this.akl.setAlpha(i);
      z.this.akA.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.z
 * JD-Core Version:    0.7.0.1
 */