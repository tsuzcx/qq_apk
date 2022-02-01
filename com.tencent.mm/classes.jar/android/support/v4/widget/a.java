package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.t;
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
  private static final int Sf = ;
  boolean FH;
  final a RR = new a();
  private final Interpolator RS = new AccelerateInterpolator();
  final View RT;
  private float[] RU = { 0.0F, 0.0F };
  private float[] RV = { 3.4028235E+38F, 3.4028235E+38F };
  private int RW;
  private int RX;
  private float[] RY = { 0.0F, 0.0F };
  private float[] RZ = { 0.0F, 0.0F };
  private float[] Sa = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean Sb;
  boolean Sc;
  boolean Sd;
  private boolean Se;
  private boolean mEnabled;
  private Runnable mRunnable;
  
  public a(View paramView)
  {
    this.RT = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.Sa[0] = (f / 1000.0F);
    this.Sa[1] = (f / 1000.0F);
    f = j;
    this.RZ[0] = (f / 1000.0F);
    this.RZ[1] = (f / 1000.0F);
    this.RW = 1;
    this.RV[0] = 3.4028235E+38F;
    this.RV[1] = 3.4028235E+38F;
    this.RU[0] = 0.2F;
    this.RU[1] = 0.2F;
    this.RY[0] = 0.001F;
    this.RY[1] = 0.001F;
    this.RX = Sf;
    this.RR.Sg = 500;
    this.RR.Sh = 500;
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
    paramFloat1 = f(this.RU[paramInt], paramFloat2, this.RV[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.RY[paramInt];
    paramFloat2 = this.RZ[paramInt];
    float f1 = this.Sa[paramInt];
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
    for (paramFloat1 = -this.RS.getInterpolation(-paramFloat2);; paramFloat1 = this.RS.getInterpolation(paramFloat2))
    {
      paramFloat1 = e(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  private void fD()
  {
    if (this.Sc)
    {
      this.FH = false;
      return;
    }
    this.RR.fD();
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
          switch (this.RW)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.FH) || (this.RW != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  public final a M(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      fD();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public abstract void aR(int paramInt);
  
  public abstract boolean aS(int paramInt);
  
  final boolean bX()
  {
    a locala = this.RR;
    int i = locala.fF();
    int j = locala.fE();
    if ((i == 0) || (!aS(i)))
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
      while ((this.Se) && (this.FH))
      {
        return true;
        this.Sd = true;
        this.Sb = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.RT.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.RT.getHeight());
        paramView = this.RR;
        paramView.Si = f1;
        paramView.Sj = f2;
        if ((!this.FH) && (bX()))
        {
          if (this.mRunnable == null) {
            this.mRunnable = new b();
          }
          this.FH = true;
          this.Sc = true;
          if ((!this.Sb) && (this.RX > 0)) {
            t.a(this.RT, this.mRunnable, this.RX);
          }
          for (;;)
          {
            this.Sb = true;
            break;
            this.mRunnable.run();
          }
          fD();
        }
      }
    }
  }
  
  static final class a
  {
    int Bc = 0;
    int Bd = 0;
    int Sg;
    int Sh;
    float Si;
    float Sj;
    long Sk = 0L;
    long Sl = -1L;
    float Sm;
    int Sn;
    long mStartTime = -9223372036854775808L;
    
    public final void fD()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.Sn = a.B((int)(l - this.mStartTime), this.Sh);
      this.Sm = l(l);
      this.Sl = l;
    }
    
    public final int fE()
    {
      return (int)(this.Si / Math.abs(this.Si));
    }
    
    public final int fF()
    {
      return (int)(this.Sj / Math.abs(this.Sj));
    }
    
    final float l(long paramLong)
    {
      if (paramLong < this.mStartTime) {
        return 0.0F;
      }
      if ((this.Sl < 0L) || (paramLong < this.Sl)) {
        return a.e((float)(paramLong - this.mStartTime) / this.Sg, 0.0F, 1.0F) * 0.5F;
      }
      long l = this.Sl;
      float f1 = this.Sm;
      float f2 = this.Sm;
      return a.e((float)(paramLong - l) / this.Sn, 0.0F, 1.0F) * f2 + (1.0F - f1);
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      if (!a.this.FH) {
        return;
      }
      if (a.this.Sc)
      {
        a.this.Sc = false;
        locala = a.this.RR;
        locala.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        locala.Sl = -1L;
        locala.Sk = locala.mStartTime;
        locala.Sm = 0.5F;
        locala.Bc = 0;
        locala.Bd = 0;
      }
      a.a locala = a.this.RR;
      if ((locala.Sl > 0L) && (AnimationUtils.currentAnimationTimeMillis() > locala.Sl + locala.Sn)) {}
      for (int i = 1; (i != 0) || (!a.this.bX()); i = 0)
      {
        a.this.FH = false;
        return;
      }
      if (a.this.Sd)
      {
        a.this.Sd = false;
        a locala1 = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala1.RT.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (locala.Sk == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = locala.l(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - locala.Sk;
      locala.Sk = l1;
      locala.Bc = ((int)((float)l2 * f * locala.Si));
      locala.Bd = ((int)((float)l2 * f * locala.Sj));
      i = locala.Bd;
      a.this.aR(i);
      t.b(a.this.RT, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.a
 * JD-Core Version:    0.7.0.1
 */