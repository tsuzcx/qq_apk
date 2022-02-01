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
  private int Uu = 0;
  int alA = 0;
  private final RecyclerView.m alB = new RecyclerView.m()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      z localz = z.this;
      paramAnonymousInt1 = paramAnonymousRecyclerView.computeHorizontalScrollOffset();
      paramAnonymousInt2 = paramAnonymousRecyclerView.computeVerticalScrollOffset();
      int i = localz.alu.computeVerticalScrollRange();
      int j = localz.alt;
      boolean bool;
      int k;
      int m;
      if ((i - j > 0) && (localz.alt >= localz.ald))
      {
        bool = true;
        localz.alv = bool;
        k = localz.alu.computeHorizontalScrollRange();
        m = localz.als;
        if ((k - m <= 0) || (localz.als < localz.ald)) {
          break label149;
        }
        bool = true;
        label105:
        localz.alw = bool;
        if ((localz.alv) || (localz.alw)) {
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
        if (localz.alv)
        {
          localz.aln = ((int)((paramAnonymousInt2 + j / 2.0F) * j / i));
          localz.alm = Math.min(j, j * j / i);
        }
        if (localz.alw)
        {
          localz.alq = ((int)((paramAnonymousInt1 + m / 2.0F) * m / k));
          localz.alp = Math.min(m, m * m / k);
        }
      } while ((localz.mState != 0) && (localz.mState != 1));
      localz.setState(1);
    }
  };
  final int ald;
  final StateListDrawable ale;
  final Drawable alf;
  private final int alg;
  private final int alh;
  private final StateListDrawable ali;
  private final Drawable alj;
  private final int alk;
  private final int all;
  int alm;
  int aln;
  float alo;
  int alp;
  int alq;
  float alr;
  int als = 0;
  int alt = 0;
  RecyclerView alu;
  boolean alv = false;
  boolean alw = false;
  private final int[] alx = new int[2];
  private final int[] aly = new int[2];
  final ValueAnimator alz = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      z localz = z.this;
      switch (localz.alA)
      {
      default: 
        return;
      case 1: 
        localz.alz.cancel();
      }
      localz.alA = 3;
      localz.alz.setFloatValues(new float[] { ((Float)localz.alz.getAnimatedValue()).floatValue(), 0.0F });
      localz.alz.setDuration(500L);
      localz.alz.start();
    }
  };
  private final int mMargin;
  int mState = 0;
  
  z(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.ale = paramStateListDrawable1;
    this.alf = paramDrawable1;
    this.ali = paramStateListDrawable2;
    this.alj = paramDrawable2;
    this.alg = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.alh = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.alk = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.all = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.ald = paramInt2;
    this.mMargin = paramInt3;
    this.ale.setAlpha(255);
    this.alf.setAlpha(255);
    this.alz.addListener(new a());
    this.alz.addUpdateListener(new b());
    if (this.alu != paramRecyclerView)
    {
      if (this.alu != null)
      {
        this.alu.c(this);
        this.alu.b(this);
        this.alu.b(this.alB);
        jj();
      }
      this.alu = paramRecyclerView;
      if (this.alu != null)
      {
        this.alu.a(this);
        this.alu.a(this);
        this.alu.a(this.alB);
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
    jj();
    this.alu.postDelayed(this.mHideRunnable, paramInt);
  }
  
  private boolean ji()
  {
    return t.Y(this.alu) == 1;
  }
  
  private void jj()
  {
    this.alu.removeCallbacks(this.mHideRunnable);
  }
  
  private boolean m(float paramFloat1, float paramFloat2)
  {
    if (ji())
    {
      if (paramFloat1 > this.alg / 2) {}
    }
    else {
      while (paramFloat1 >= this.als - this.alg)
      {
        if ((paramFloat2 < this.aln - this.alm / 2) || (paramFloat2 > this.aln + this.alm / 2)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean n(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.alt - this.alk) && (paramFloat1 >= this.alq - this.alp / 2) && (paramFloat1 <= this.alq + this.alp / 2);
  }
  
  private void show()
  {
    switch (this.alA)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.alz.cancel();
    }
    this.alA = 1;
    this.alz.setFloatValues(new float[] { ((Float)this.alz.getAnimatedValue()).floatValue(), 1.0F });
    this.alz.setDuration(500L);
    this.alz.setStartDelay(0L);
    this.alz.start();
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
          this.Uu = 1;
          this.alr = ((int)paramMotionEvent.getX());
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
          this.Uu = 2;
          this.alo = ((int)paramMotionEvent.getY());
        }
      }
      return false;
    }
    return false;
  }
  
  public final void ai(boolean paramBoolean) {}
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    if ((this.als != this.alu.getWidth()) || (this.alt != this.alu.getHeight()))
    {
      this.als = this.alu.getWidth();
      this.alt = this.alu.getHeight();
      setState(0);
    }
    for (;;)
    {
      return;
      if (this.alA != 0)
      {
        int i;
        int j;
        if (this.alv)
        {
          i = this.als - this.alg;
          j = this.aln - this.alm / 2;
          this.ale.setBounds(0, 0, this.alg, this.alm);
          this.alf.setBounds(0, 0, this.alh, this.alt);
          if (!ji()) {
            break label301;
          }
          this.alf.draw(paramCanvas);
          paramCanvas.translate(this.alg, j);
          paramCanvas.scale(-1.0F, 1.0F);
          this.ale.draw(paramCanvas);
          paramCanvas.scale(1.0F, 1.0F);
          paramCanvas.translate(-this.alg, -j);
        }
        while (this.alw)
        {
          i = this.alt - this.alk;
          j = this.alq - this.alp / 2;
          this.ali.setBounds(0, 0, this.alp, this.alk);
          this.alj.setBounds(0, 0, this.als, this.all);
          paramCanvas.translate(0.0F, i);
          this.alj.draw(paramCanvas);
          paramCanvas.translate(j, 0.0F);
          this.ali.draw(paramCanvas);
          paramCanvas.translate(-j, -i);
          return;
          label301:
          paramCanvas.translate(i, 0.0F);
          this.alf.draw(paramCanvas);
          paramCanvas.translate(0.0F, j);
          this.ale.draw(paramCanvas);
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
            this.Uu = 1;
            this.alr = ((int)paramMotionEvent.getX());
          }
          for (;;)
          {
            setState(2);
            return;
            if (bool1)
            {
              this.Uu = 2;
              this.alo = ((int)paramMotionEvent.getY());
            }
          }
          if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
          {
            this.alo = 0.0F;
            this.alr = 0.0F;
            setState(1);
            this.Uu = 0;
            return;
          }
        } while ((paramMotionEvent.getAction() != 2) || (this.mState != 2));
        show();
        if (this.Uu == 1)
        {
          f = paramMotionEvent.getX();
          this.aly[0] = this.mMargin;
          this.aly[1] = (this.als - this.mMargin);
          paramRecyclerView = this.aly;
          f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
          if (Math.abs(this.alq - f) >= 2.0F)
          {
            i = a(this.alr, f, paramRecyclerView, this.alu.computeHorizontalScrollRange(), this.alu.computeHorizontalScrollOffset(), this.als);
            if (i != 0) {
              this.alu.scrollBy(i, 0);
            }
            this.alr = f;
          }
        }
      } while (this.Uu != 2);
      f = paramMotionEvent.getY();
      this.alx[0] = this.mMargin;
      this.alx[1] = (this.alt - this.mMargin);
      paramRecyclerView = this.alx;
      f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
    } while (Math.abs(this.aln - f) < 2.0F);
    int i = a(this.alo, f, paramRecyclerView, this.alu.computeVerticalScrollRange(), this.alu.computeVerticalScrollOffset(), this.alt);
    if (i != 0) {
      this.alu.scrollBy(0, i);
    }
    this.alo = f;
  }
  
  final void setState(int paramInt)
  {
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.ale.setState(PRESSED_STATE_SET);
      jj();
    }
    if (paramInt == 0)
    {
      this.alu.invalidate();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label83;
      }
      this.ale.setState(EMPTY_STATE_SET);
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
      if (((Float)z.this.alz.getAnimatedValue()).floatValue() == 0.0F)
      {
        z.this.alA = 0;
        z.this.setState(0);
        return;
      }
      z.this.alA = 2;
      z.this.alu.invalidate();
    }
  }
  
  final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      z.this.ale.setAlpha(i);
      z.this.alf.setAlpha(i);
      z.this.alu.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.z
 * JD-Core Version:    0.7.0.1
 */