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
  private static final int Pv = ;
  boolean CS;
  final a Ph = new a();
  private final Interpolator Pi = new AccelerateInterpolator();
  final View Pj;
  private float[] Pk = { 0.0F, 0.0F };
  private float[] Pl = { 3.4028235E+38F, 3.4028235E+38F };
  private int Pm;
  private int Pn;
  private float[] Po = { 0.0F, 0.0F };
  private float[] Pp = { 0.0F, 0.0F };
  private float[] Pq = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean Pr;
  boolean Ps;
  boolean Pt;
  private boolean Pu;
  private boolean mEnabled;
  private Runnable mRunnable;
  
  public a(View paramView)
  {
    this.Pj = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.Pq[0] = (f / 1000.0F);
    this.Pq[1] = (f / 1000.0F);
    f = j;
    this.Pp[0] = (f / 1000.0F);
    this.Pp[1] = (f / 1000.0F);
    this.Pm = 1;
    this.Pl[0] = 3.4028235E+38F;
    this.Pl[1] = 3.4028235E+38F;
    this.Pk[0] = 0.2F;
    this.Pk[1] = 0.2F;
    this.Po[0] = 0.001F;
    this.Po[1] = 0.001F;
    this.Pn = Pv;
    this.Ph.Pw = 500;
    this.Ph.Px = 500;
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = f(this.Pk[paramInt], paramFloat2, this.Pl[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.Po[paramInt];
    paramFloat2 = this.Pp[paramInt];
    float f1 = this.Pq[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return f(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -f(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  static float f(float paramFloat1, float paramFloat2, float paramFloat3)
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
    paramFloat1 = f(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = k(paramFloat4, paramFloat1);
    paramFloat2 = k(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat2 < 0.0F) {}
    for (paramFloat1 = -this.Pi.getInterpolation(-paramFloat2);; paramFloat1 = this.Pi.getInterpolation(paramFloat2))
    {
      paramFloat1 = f(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  private void fe()
  {
    if (this.Ps)
    {
      this.CS = false;
      return;
    }
    this.Ph.fe();
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
          switch (this.Pm)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.CS) || (this.Pm != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  static int u(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  public final a M(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      fe();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public abstract void aR(int paramInt);
  
  public abstract boolean aS(int paramInt);
  
  final boolean bB()
  {
    a locala = this.Ph;
    int i = locala.fg();
    int j = locala.ff();
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
      while ((this.Pu) && (this.CS))
      {
        return true;
        this.Pt = true;
        this.Pr = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.Pj.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.Pj.getHeight());
        paramView = this.Ph;
        paramView.Py = f1;
        paramView.Pz = f2;
        if ((!this.CS) && (bB()))
        {
          if (this.mRunnable == null) {
            this.mRunnable = new b();
          }
          this.CS = true;
          this.Ps = true;
          if ((!this.Pr) && (this.Pn > 0)) {
            t.a(this.Pj, this.mRunnable, this.Pn);
          }
          for (;;)
          {
            this.Pr = true;
            break;
            this.mRunnable.run();
          }
          fe();
        }
      }
    }
  }
  
  static final class a
  {
    long PA = 0L;
    long PB = -1L;
    float PC;
    int PD;
    int Pw;
    int Px;
    float Py;
    float Pz;
    long mStartTime = -9223372036854775808L;
    int yl = 0;
    int ym = 0;
    
    public final void fe()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.PD = a.u((int)(l - this.mStartTime), this.Px);
      this.PC = j(l);
      this.PB = l;
    }
    
    public final int ff()
    {
      return (int)(this.Py / Math.abs(this.Py));
    }
    
    public final int fg()
    {
      return (int)(this.Pz / Math.abs(this.Pz));
    }
    
    final float j(long paramLong)
    {
      if (paramLong < this.mStartTime) {
        return 0.0F;
      }
      if ((this.PB < 0L) || (paramLong < this.PB)) {
        return a.f((float)(paramLong - this.mStartTime) / this.Pw, 0.0F, 1.0F) * 0.5F;
      }
      long l = this.PB;
      float f1 = this.PC;
      float f2 = this.PC;
      return a.f((float)(paramLong - l) / this.PD, 0.0F, 1.0F) * f2 + (1.0F - f1);
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      if (!a.this.CS) {
        return;
      }
      if (a.this.Ps)
      {
        a.this.Ps = false;
        locala = a.this.Ph;
        locala.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        locala.PB = -1L;
        locala.PA = locala.mStartTime;
        locala.PC = 0.5F;
        locala.yl = 0;
        locala.ym = 0;
      }
      a.a locala = a.this.Ph;
      if ((locala.PB > 0L) && (AnimationUtils.currentAnimationTimeMillis() > locala.PB + locala.PD)) {}
      for (int i = 1; (i != 0) || (!a.this.bB()); i = 0)
      {
        a.this.CS = false;
        return;
      }
      if (a.this.Pt)
      {
        a.this.Pt = false;
        a locala1 = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala1.Pj.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (locala.PA == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = locala.j(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - locala.PA;
      locala.PA = l1;
      locala.yl = ((int)((float)l2 * f * locala.Py));
      locala.ym = ((int)((float)l2 * f * locala.Pz));
      i = locala.ym;
      a.this.aR(i);
      t.b(a.this.Pj, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.a
 * JD-Core Version:    0.7.0.1
 */