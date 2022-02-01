package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a
  implements View.OnTouchListener
{
  private static final int Ss = ;
  boolean FR;
  final a Se = new a();
  private final Interpolator Sf = new AccelerateInterpolator();
  final View Sg;
  private float[] Sh = { 0.0F, 0.0F };
  private float[] Si = { 3.4028235E+38F, 3.4028235E+38F };
  private int Sj;
  private int Sk;
  private float[] Sl = { 0.0F, 0.0F };
  private float[] Sm = { 0.0F, 0.0F };
  private float[] Sn = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean So;
  boolean Sp;
  boolean Sq;
  private boolean Sr;
  private boolean mEnabled;
  private Runnable mRunnable;
  
  public a(View paramView)
  {
    this.Sg = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.Sn[0] = (f / 1000.0F);
    this.Sn[1] = (f / 1000.0F);
    f = j;
    this.Sm[0] = (f / 1000.0F);
    this.Sm[1] = (f / 1000.0F);
    this.Sj = 1;
    this.Si[0] = 3.4028235E+38F;
    this.Si[1] = 3.4028235E+38F;
    this.Sh[0] = 0.2F;
    this.Sh[1] = 0.2F;
    this.Sl[0] = 0.001F;
    this.Sl[1] = 0.001F;
    this.Sk = Ss;
    this.Se.St = 500;
    this.Se.Su = 500;
  }
  
  static int B(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = f(this.Sh[paramInt], paramFloat2, this.Si[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.Sl[paramInt];
    paramFloat2 = this.Sm[paramInt];
    float f1 = this.Sn[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return e(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -e(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  private float f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = 0.0F;
    paramFloat1 = e(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = k(paramFloat4, paramFloat1);
    paramFloat2 = k(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat2 < 0.0F) {}
    for (paramFloat1 = -this.Sf.getInterpolation(-paramFloat2);; paramFloat1 = this.Sf.getInterpolation(paramFloat2))
    {
      paramFloat1 = e(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  private void fK()
  {
    if (this.Sp)
    {
      this.FR = false;
      return;
    }
    this.Se.fK();
  }
  
  private float k(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (this.Sj)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.FR) || (this.Sj != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  public final a L(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      fK();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public abstract void aS(int paramInt);
  
  public abstract boolean aT(int paramInt);
  
  final boolean bZ()
  {
    a locala = this.Se;
    int i = locala.fM();
    int j = locala.fL();
    if ((i == 0) || (!aT(i)))
    {
      if (j != 0) {}
      return false;
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.mEnabled) {}
    for (;;)
    {
      return false;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      while ((this.Sr) && (this.FR))
      {
        return true;
        this.Sq = true;
        this.So = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.Sg.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.Sg.getHeight());
        paramView = this.Se;
        paramView.Sv = f1;
        paramView.Sw = f2;
        if ((!this.FR) && (bZ()))
        {
          if (this.mRunnable == null) {
            this.mRunnable = new b();
          }
          this.FR = true;
          this.Sp = true;
          if ((!this.So) && (this.Sk > 0)) {
            u.a(this.Sg, this.mRunnable, this.Sk);
          }
          for (;;)
          {
            this.So = true;
            break;
            this.mRunnable.run();
          }
          fK();
        }
      }
    }
  }
  
  static final class a
  {
    int Bi = 0;
    int Bj = 0;
    int SA;
    int St;
    int Su;
    float Sv;
    float Sw;
    long Sx = 0L;
    long Sy = -1L;
    float Sz;
    long mStartTime = -9223372036854775808L;
    
    public final void fK()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.SA = a.B((int)(l - this.mStartTime), this.Su);
      this.Sz = l(l);
      this.Sy = l;
    }
    
    public final int fL()
    {
      return (int)(this.Sv / Math.abs(this.Sv));
    }
    
    public final int fM()
    {
      return (int)(this.Sw / Math.abs(this.Sw));
    }
    
    final float l(long paramLong)
    {
      if (paramLong < this.mStartTime) {
        return 0.0F;
      }
      if ((this.Sy < 0L) || (paramLong < this.Sy)) {
        return a.e((float)(paramLong - this.mStartTime) / this.St, 0.0F, 1.0F) * 0.5F;
      }
      long l = this.Sy;
      float f1 = this.Sz;
      float f2 = this.Sz;
      return a.e((float)(paramLong - l) / this.SA, 0.0F, 1.0F) * f2 + (1.0F - f1);
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      if (!a.this.FR) {
        return;
      }
      if (a.this.Sp)
      {
        a.this.Sp = false;
        locala = a.this.Se;
        locala.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        locala.Sy = -1L;
        locala.Sx = locala.mStartTime;
        locala.Sz = 0.5F;
        locala.Bi = 0;
        locala.Bj = 0;
      }
      a.a locala = a.this.Se;
      if ((locala.Sy > 0L) && (AnimationUtils.currentAnimationTimeMillis() > locala.Sy + locala.SA)) {}
      for (int i = 1; (i != 0) || (!a.this.bZ()); i = 0)
      {
        a.this.FR = false;
        return;
      }
      if (a.this.Sq)
      {
        a.this.Sq = false;
        a locala1 = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala1.Sg.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (locala.Sx == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = locala.l(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - locala.Sx;
      locala.Sx = l1;
      locala.Bi = ((int)((float)l2 * f * locala.Sv));
      locala.Bj = ((int)((float)l2 * f * locala.Sw));
      i = locala.Bj;
      a.this.aS(i);
      u.b(a.this.Sg, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.a
 * JD-Core Version:    0.7.0.1
 */