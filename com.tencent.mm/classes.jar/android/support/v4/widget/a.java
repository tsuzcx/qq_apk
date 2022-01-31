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
  private static final int Iv = ;
  final a Ih = new a();
  private final Interpolator Ii = new AccelerateInterpolator();
  final View Ij;
  private float[] Ik = { 0.0F, 0.0F };
  private float[] Il = { 3.4028235E+38F, 3.4028235E+38F };
  private int Im;
  private int In;
  private float[] Io = { 0.0F, 0.0F };
  private float[] Ip = { 0.0F, 0.0F };
  private float[] Iq = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean Ir;
  boolean Is;
  boolean It;
  private boolean Iu;
  private boolean mEnabled;
  private Runnable mRunnable;
  boolean wu;
  
  public a(View paramView)
  {
    this.Ij = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.Iq[0] = (f / 1000.0F);
    this.Iq[1] = (f / 1000.0F);
    f = j;
    this.Ip[0] = (f / 1000.0F);
    this.Ip[1] = (f / 1000.0F);
    this.Im = 1;
    this.Il[0] = 3.4028235E+38F;
    this.Il[1] = 3.4028235E+38F;
    this.Ik[0] = 0.2F;
    this.Ik[1] = 0.2F;
    this.Io[0] = 0.001F;
    this.Io[1] = 0.001F;
    this.In = Iv;
    this.Ih.Iw = 500;
    this.Ih.Ix = 500;
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = c(this.Ik[paramInt], paramFloat2, this.Il[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.Io[paramInt];
    paramFloat2 = this.Ip[paramInt];
    float f1 = this.Iq[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return d(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -d(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  private float c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = 0.0F;
    paramFloat1 = d(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = t(paramFloat4, paramFloat1);
    paramFloat2 = t(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat2 < 0.0F) {}
    for (paramFloat1 = -this.Ii.getInterpolation(-paramFloat2);; paramFloat1 = this.Ii.getInterpolation(paramFloat2))
    {
      paramFloat1 = d(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  static float d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  private void dM()
  {
    if (this.Is)
    {
      this.wu = false;
      return;
    }
    this.Ih.dM();
  }
  
  static int s(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  private float t(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (this.Im)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.wu) || (this.Im != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  public final a G(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      dM();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public abstract boolean aA(int paramInt);
  
  final boolean aT()
  {
    a locala = this.Ih;
    int i = locala.dO();
    int j = locala.dN();
    if ((i == 0) || (!aA(i)))
    {
      if (j != 0) {}
      return false;
    }
    return true;
  }
  
  public abstract void az(int paramInt);
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.mEnabled) {}
    for (;;)
    {
      return false;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      while ((this.Iu) && (this.wu))
      {
        return true;
        this.It = true;
        this.Ir = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.Ij.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.Ij.getHeight());
        paramView = this.Ih;
        paramView.Iy = f1;
        paramView.Iz = f2;
        if ((!this.wu) && (aT()))
        {
          if (this.mRunnable == null) {
            this.mRunnable = new b();
          }
          this.wu = true;
          this.Is = true;
          if ((!this.Ir) && (this.In > 0)) {
            t.a(this.Ij, this.mRunnable, this.In);
          }
          for (;;)
          {
            this.Ir = true;
            break;
            this.mRunnable.run();
          }
          dM();
        }
      }
    }
  }
  
  static final class a
  {
    long IA = 0L;
    long IB = -1L;
    float IC;
    int IE;
    int Iw;
    int Ix;
    float Iy;
    float Iz;
    long mStartTime = -9223372036854775808L;
    int rM = 0;
    int rN = 0;
    
    public final void dM()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.IE = a.s((int)(l - this.mStartTime), this.Ix);
      this.IC = j(l);
      this.IB = l;
    }
    
    public final int dN()
    {
      return (int)(this.Iy / Math.abs(this.Iy));
    }
    
    public final int dO()
    {
      return (int)(this.Iz / Math.abs(this.Iz));
    }
    
    final float j(long paramLong)
    {
      if (paramLong < this.mStartTime) {
        return 0.0F;
      }
      if ((this.IB < 0L) || (paramLong < this.IB)) {
        return a.d((float)(paramLong - this.mStartTime) / this.Iw, 0.0F, 1.0F) * 0.5F;
      }
      long l = this.IB;
      float f1 = this.IC;
      float f2 = this.IC;
      return a.d((float)(paramLong - l) / this.IE, 0.0F, 1.0F) * f2 + (1.0F - f1);
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      if (!a.this.wu) {
        return;
      }
      if (a.this.Is)
      {
        a.this.Is = false;
        locala = a.this.Ih;
        locala.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        locala.IB = -1L;
        locala.IA = locala.mStartTime;
        locala.IC = 0.5F;
        locala.rM = 0;
        locala.rN = 0;
      }
      a.a locala = a.this.Ih;
      if ((locala.IB > 0L) && (AnimationUtils.currentAnimationTimeMillis() > locala.IB + locala.IE)) {}
      for (int i = 1; (i != 0) || (!a.this.aT()); i = 0)
      {
        a.this.wu = false;
        return;
      }
      if (a.this.It)
      {
        a.this.It = false;
        a locala1 = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala1.Ij.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (locala.IA == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = locala.j(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - locala.IA;
      locala.IA = l1;
      locala.rM = ((int)((float)l2 * f * locala.Iy));
      locala.rN = ((int)((float)l2 * f * locala.Iz));
      i = locala.rN;
      a.this.az(i);
      t.b(a.this.Ij, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.a
 * JD-Core Version:    0.7.0.1
 */