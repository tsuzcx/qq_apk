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
  private int Wk = 0;
  final int amU;
  final StateListDrawable amV;
  final Drawable amW;
  private final int amX;
  private final int amY;
  private final StateListDrawable amZ;
  private final Drawable ana;
  private final int anb;
  private final int anc;
  int and;
  int ane;
  float anf;
  int ang;
  int anh;
  float ani;
  int anj = 0;
  int ank = 0;
  RecyclerView anl;
  boolean anm = false;
  boolean ann = false;
  private final int[] ano = new int[2];
  private final int[] anp = new int[2];
  final ValueAnimator anq = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  int anr = 0;
  private final RecyclerView.m ans = new RecyclerView.m()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      z localz = z.this;
      paramAnonymousInt1 = paramAnonymousRecyclerView.computeHorizontalScrollOffset();
      paramAnonymousInt2 = paramAnonymousRecyclerView.computeVerticalScrollOffset();
      int i = localz.anl.computeVerticalScrollRange();
      int j = localz.ank;
      boolean bool;
      int k;
      int m;
      if ((i - j > 0) && (localz.ank >= localz.amU))
      {
        bool = true;
        localz.anm = bool;
        k = localz.anl.computeHorizontalScrollRange();
        m = localz.anj;
        if ((k - m <= 0) || (localz.anj < localz.amU)) {
          break label149;
        }
        bool = true;
        label105:
        localz.ann = bool;
        if ((localz.anm) || (localz.ann)) {
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
        if (localz.anm)
        {
          localz.ane = ((int)((paramAnonymousInt2 + j / 2.0F) * j / i));
          localz.and = Math.min(j, j * j / i);
        }
        if (localz.ann)
        {
          localz.anh = ((int)((paramAnonymousInt1 + m / 2.0F) * m / k));
          localz.ang = Math.min(m, m * m / k);
        }
      } while ((localz.mState != 0) && (localz.mState != 1));
      localz.setState(1);
    }
  };
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      z localz = z.this;
      switch (localz.anr)
      {
      default: 
        return;
      case 1: 
        localz.anq.cancel();
      }
      localz.anr = 3;
      localz.anq.setFloatValues(new float[] { ((Float)localz.anq.getAnimatedValue()).floatValue(), 0.0F });
      localz.anq.setDuration(500L);
      localz.anq.start();
    }
  };
  private final int mMargin;
  int mState = 0;
  
  z(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.amV = paramStateListDrawable1;
    this.amW = paramDrawable1;
    this.amZ = paramStateListDrawable2;
    this.ana = paramDrawable2;
    this.amX = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.amY = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.anb = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.anc = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.amU = paramInt2;
    this.mMargin = paramInt3;
    this.amV.setAlpha(255);
    this.amW.setAlpha(255);
    this.anq.addListener(new a());
    this.anq.addUpdateListener(new b());
    if (this.anl != paramRecyclerView)
    {
      if (this.anl != null)
      {
        this.anl.c(this);
        this.anl.b(this);
        this.anl.b(this.ans);
        jz();
      }
      this.anl = paramRecyclerView;
      if (this.anl != null)
      {
        this.anl.a(this);
        this.anl.a(this);
        this.anl.a(this.ans);
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
    jz();
    this.anl.postDelayed(this.mHideRunnable, paramInt);
  }
  
  private boolean jy()
  {
    return t.Y(this.anl) == 1;
  }
  
  private void jz()
  {
    this.anl.removeCallbacks(this.mHideRunnable);
  }
  
  private boolean m(float paramFloat1, float paramFloat2)
  {
    if (jy())
    {
      if (paramFloat1 > this.amX / 2) {}
    }
    else {
      while (paramFloat1 >= this.anj - this.amX)
      {
        if ((paramFloat2 < this.ane - this.and / 2) || (paramFloat2 > this.ane + this.and / 2)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean n(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.ank - this.anb) && (paramFloat1 >= this.anh - this.ang / 2) && (paramFloat1 <= this.anh + this.ang / 2);
  }
  
  private void show()
  {
    switch (this.anr)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.anq.cancel();
    }
    this.anr = 1;
    this.anq.setFloatValues(new float[] { ((Float)this.anq.getAnimatedValue()).floatValue(), 1.0F });
    this.anq.setDuration(500L);
    this.anq.setStartDelay(0L);
    this.anq.start();
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
          this.Wk = 1;
          this.ani = ((int)paramMotionEvent.getX());
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
          this.Wk = 2;
          this.anf = ((int)paramMotionEvent.getY());
        }
      }
      return false;
    }
    return false;
  }
  
  public final void ai(boolean paramBoolean) {}
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    if ((this.anj != this.anl.getWidth()) || (this.ank != this.anl.getHeight()))
    {
      this.anj = this.anl.getWidth();
      this.ank = this.anl.getHeight();
      setState(0);
    }
    for (;;)
    {
      return;
      if (this.anr != 0)
      {
        int i;
        int j;
        if (this.anm)
        {
          i = this.anj - this.amX;
          j = this.ane - this.and / 2;
          this.amV.setBounds(0, 0, this.amX, this.and);
          this.amW.setBounds(0, 0, this.amY, this.ank);
          if (!jy()) {
            break label301;
          }
          this.amW.draw(paramCanvas);
          paramCanvas.translate(this.amX, j);
          paramCanvas.scale(-1.0F, 1.0F);
          this.amV.draw(paramCanvas);
          paramCanvas.scale(1.0F, 1.0F);
          paramCanvas.translate(-this.amX, -j);
        }
        while (this.ann)
        {
          i = this.ank - this.anb;
          j = this.anh - this.ang / 2;
          this.amZ.setBounds(0, 0, this.ang, this.anb);
          this.ana.setBounds(0, 0, this.anj, this.anc);
          paramCanvas.translate(0.0F, i);
          this.ana.draw(paramCanvas);
          paramCanvas.translate(j, 0.0F);
          this.amZ.draw(paramCanvas);
          paramCanvas.translate(-j, -i);
          return;
          label301:
          paramCanvas.translate(i, 0.0F);
          this.amW.draw(paramCanvas);
          paramCanvas.translate(0.0F, j);
          this.amV.draw(paramCanvas);
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
            this.Wk = 1;
            this.ani = ((int)paramMotionEvent.getX());
          }
          for (;;)
          {
            setState(2);
            return;
            if (bool1)
            {
              this.Wk = 2;
              this.anf = ((int)paramMotionEvent.getY());
            }
          }
          if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
          {
            this.anf = 0.0F;
            this.ani = 0.0F;
            setState(1);
            this.Wk = 0;
            return;
          }
        } while ((paramMotionEvent.getAction() != 2) || (this.mState != 2));
        show();
        if (this.Wk == 1)
        {
          f = paramMotionEvent.getX();
          this.anp[0] = this.mMargin;
          this.anp[1] = (this.anj - this.mMargin);
          paramRecyclerView = this.anp;
          f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
          if (Math.abs(this.anh - f) >= 2.0F)
          {
            i = a(this.ani, f, paramRecyclerView, this.anl.computeHorizontalScrollRange(), this.anl.computeHorizontalScrollOffset(), this.anj);
            if (i != 0) {
              this.anl.scrollBy(i, 0);
            }
            this.ani = f;
          }
        }
      } while (this.Wk != 2);
      f = paramMotionEvent.getY();
      this.ano[0] = this.mMargin;
      this.ano[1] = (this.ank - this.mMargin);
      paramRecyclerView = this.ano;
      f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
    } while (Math.abs(this.ane - f) < 2.0F);
    int i = a(this.anf, f, paramRecyclerView, this.anl.computeVerticalScrollRange(), this.anl.computeVerticalScrollOffset(), this.ank);
    if (i != 0) {
      this.anl.scrollBy(0, i);
    }
    this.anf = f;
  }
  
  final void setState(int paramInt)
  {
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.amV.setState(PRESSED_STATE_SET);
      jz();
    }
    if (paramInt == 0)
    {
      this.anl.invalidate();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label83;
      }
      this.amV.setState(EMPTY_STATE_SET);
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
      if (((Float)z.this.anq.getAnimatedValue()).floatValue() == 0.0F)
      {
        z.this.anr = 0;
        z.this.setState(0);
        return;
      }
      z.this.anr = 2;
      z.this.anl.invalidate();
    }
  }
  
  final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      z.this.amV.setAlpha(i);
      z.this.amW.setAlpha(i);
      z.this.anl.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.z
 * JD-Core Version:    0.7.0.1
 */