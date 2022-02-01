package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.u;
import android.view.MotionEvent;

final class z
  extends RecyclerView.h
  implements RecyclerView.k
{
  private static final int[] EMPTY_STATE_SET = new int[0];
  private static final int[] PRESSED_STATE_SET = { 16842919 };
  private int Wx = 0;
  private final int[] anA = new int[2];
  private final int[] anB = new int[2];
  final ValueAnimator anC = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  int anD = 0;
  private final RecyclerView.l anE = new RecyclerView.l()
  {
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      z localz = z.this;
      paramAnonymousInt1 = paramAnonymousRecyclerView.computeHorizontalScrollOffset();
      paramAnonymousInt2 = paramAnonymousRecyclerView.computeVerticalScrollOffset();
      int i = localz.mRecyclerView.computeVerticalScrollRange();
      int j = localz.anx;
      boolean bool;
      int k;
      int m;
      if ((i - j > 0) && (localz.anx >= localz.anh))
      {
        bool = true;
        localz.any = bool;
        k = localz.mRecyclerView.computeHorizontalScrollRange();
        m = localz.anw;
        if ((k - m <= 0) || (localz.anw < localz.anh)) {
          break label149;
        }
        bool = true;
        label105:
        localz.anz = bool;
        if ((localz.any) || (localz.anz)) {
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
        if (localz.any)
        {
          localz.anr = ((int)((paramAnonymousInt2 + j / 2.0F) * j / i));
          localz.anq = Math.min(j, j * j / i);
        }
        if (localz.anz)
        {
          localz.anu = ((int)((paramAnonymousInt1 + m / 2.0F) * m / k));
          localz.ant = Math.min(m, m * m / k);
        }
      } while ((localz.mState != 0) && (localz.mState != 1));
      localz.setState(1);
    }
  };
  final int anh;
  final StateListDrawable ani;
  final Drawable anj;
  private final int ank;
  private final int anl;
  private final StateListDrawable anm;
  private final Drawable ann;
  private final int ano;
  private final int anp;
  int anq;
  int anr;
  float ans;
  int ant;
  int anu;
  float anv;
  int anw = 0;
  int anx = 0;
  boolean any = false;
  boolean anz = false;
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      z localz = z.this;
      switch (localz.anD)
      {
      default: 
        return;
      case 1: 
        localz.anC.cancel();
      }
      localz.anD = 3;
      localz.anC.setFloatValues(new float[] { ((Float)localz.anC.getAnimatedValue()).floatValue(), 0.0F });
      localz.anC.setDuration(500L);
      localz.anC.start();
    }
  };
  private final int mMargin;
  RecyclerView mRecyclerView;
  int mState = 0;
  
  z(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.ani = paramStateListDrawable1;
    this.anj = paramDrawable1;
    this.anm = paramStateListDrawable2;
    this.ann = paramDrawable2;
    this.ank = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.anl = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.ano = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.anp = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.anh = paramInt2;
    this.mMargin = paramInt3;
    this.ani.setAlpha(255);
    this.anj.setAlpha(255);
    this.anC.addListener(new a());
    this.anC.addUpdateListener(new b());
    if (this.mRecyclerView != paramRecyclerView)
    {
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.c(this);
        this.mRecyclerView.b(this);
        this.mRecyclerView.b(this.anE);
        jI();
      }
      this.mRecyclerView = paramRecyclerView;
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.a(this);
        this.mRecyclerView.a(this);
        this.mRecyclerView.a(this.anE);
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
  
  private void bO(int paramInt)
  {
    jI();
    this.mRecyclerView.postDelayed(this.mHideRunnable, paramInt);
  }
  
  private boolean jH()
  {
    return u.Z(this.mRecyclerView) == 1;
  }
  
  private void jI()
  {
    this.mRecyclerView.removeCallbacks(this.mHideRunnable);
  }
  
  private boolean m(float paramFloat1, float paramFloat2)
  {
    if (jH())
    {
      if (paramFloat1 > this.ank / 2) {}
    }
    else {
      while (paramFloat1 >= this.anw - this.ank)
      {
        if ((paramFloat2 < this.anr - this.anq / 2) || (paramFloat2 > this.anr + this.anq / 2)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean n(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.anx - this.ano) && (paramFloat1 >= this.anu - this.ant / 2) && (paramFloat1 <= this.anu + this.ant / 2);
  }
  
  private void show()
  {
    switch (this.anD)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.anC.cancel();
    }
    this.anD = 1;
    this.anC.setFloatValues(new float[] { ((Float)this.anC.getAnimatedValue()).floatValue(), 1.0F });
    this.anC.setDuration(500L);
    this.anC.setStartDelay(0L);
    this.anC.start();
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
          this.Wx = 1;
          this.anv = ((int)paramMotionEvent.getX());
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
          this.Wx = 2;
          this.ans = ((int)paramMotionEvent.getY());
        }
      }
      return false;
    }
    return false;
  }
  
  public final void ah(boolean paramBoolean) {}
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    if ((this.anw != this.mRecyclerView.getWidth()) || (this.anx != this.mRecyclerView.getHeight()))
    {
      this.anw = this.mRecyclerView.getWidth();
      this.anx = this.mRecyclerView.getHeight();
      setState(0);
    }
    for (;;)
    {
      return;
      if (this.anD != 0)
      {
        int i;
        int j;
        if (this.any)
        {
          i = this.anw - this.ank;
          j = this.anr - this.anq / 2;
          this.ani.setBounds(0, 0, this.ank, this.anq);
          this.anj.setBounds(0, 0, this.anl, this.anx);
          if (!jH()) {
            break label301;
          }
          this.anj.draw(paramCanvas);
          paramCanvas.translate(this.ank, j);
          paramCanvas.scale(-1.0F, 1.0F);
          this.ani.draw(paramCanvas);
          paramCanvas.scale(1.0F, 1.0F);
          paramCanvas.translate(-this.ank, -j);
        }
        while (this.anz)
        {
          i = this.anx - this.ano;
          j = this.anu - this.ant / 2;
          this.anm.setBounds(0, 0, this.ant, this.ano);
          this.ann.setBounds(0, 0, this.anw, this.anp);
          paramCanvas.translate(0.0F, i);
          this.ann.draw(paramCanvas);
          paramCanvas.translate(j, 0.0F);
          this.anm.draw(paramCanvas);
          paramCanvas.translate(-j, -i);
          return;
          label301:
          paramCanvas.translate(i, 0.0F);
          this.anj.draw(paramCanvas);
          paramCanvas.translate(0.0F, j);
          this.ani.draw(paramCanvas);
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
            this.Wx = 1;
            this.anv = ((int)paramMotionEvent.getX());
          }
          for (;;)
          {
            setState(2);
            return;
            if (bool1)
            {
              this.Wx = 2;
              this.ans = ((int)paramMotionEvent.getY());
            }
          }
          if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
          {
            this.ans = 0.0F;
            this.anv = 0.0F;
            setState(1);
            this.Wx = 0;
            return;
          }
        } while ((paramMotionEvent.getAction() != 2) || (this.mState != 2));
        show();
        if (this.Wx == 1)
        {
          f = paramMotionEvent.getX();
          this.anB[0] = this.mMargin;
          this.anB[1] = (this.anw - this.mMargin);
          paramRecyclerView = this.anB;
          f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
          if (Math.abs(this.anu - f) >= 2.0F)
          {
            i = a(this.anv, f, paramRecyclerView, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.anw);
            if (i != 0) {
              this.mRecyclerView.scrollBy(i, 0);
            }
            this.anv = f;
          }
        }
      } while (this.Wx != 2);
      f = paramMotionEvent.getY();
      this.anA[0] = this.mMargin;
      this.anA[1] = (this.anx - this.mMargin);
      paramRecyclerView = this.anA;
      f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
    } while (Math.abs(this.anr - f) < 2.0F);
    int i = a(this.ans, f, paramRecyclerView, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.anx);
    if (i != 0) {
      this.mRecyclerView.scrollBy(0, i);
    }
    this.ans = f;
  }
  
  final void setState(int paramInt)
  {
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.ani.setState(PRESSED_STATE_SET);
      jI();
    }
    if (paramInt == 0)
    {
      this.mRecyclerView.invalidate();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label83;
      }
      this.ani.setState(EMPTY_STATE_SET);
      bO(1200);
    }
    for (;;)
    {
      this.mState = paramInt;
      return;
      show();
      break;
      label83:
      if (paramInt == 1) {
        bO(1500);
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
      if (((Float)z.this.anC.getAnimatedValue()).floatValue() == 0.0F)
      {
        z.this.anD = 0;
        z.this.setState(0);
        return;
      }
      z.this.anD = 2;
      z.this.mRecyclerView.invalidate();
    }
  }
  
  final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      z.this.ani.setAlpha(i);
      z.this.anj.setAlpha(i);
      z.this.mRecyclerView.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.z
 * JD-Core Version:    0.7.0.1
 */