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
  private static final int Qq = ;
  boolean DQ;
  final a Qc = new a();
  private final Interpolator Qd = new AccelerateInterpolator();
  final View Qe;
  private float[] Qf = { 0.0F, 0.0F };
  private float[] Qg = { 3.4028235E+38F, 3.4028235E+38F };
  private int Qh;
  private int Qi;
  private float[] Qj = { 0.0F, 0.0F };
  private float[] Qk = { 0.0F, 0.0F };
  private float[] Ql = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean Qm;
  boolean Qn;
  boolean Qo;
  private boolean Qp;
  private boolean mEnabled;
  private Runnable mRunnable;
  
  public a(View paramView)
  {
    this.Qe = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.Ql[0] = (f / 1000.0F);
    this.Ql[1] = (f / 1000.0F);
    f = j;
    this.Qk[0] = (f / 1000.0F);
    this.Qk[1] = (f / 1000.0F);
    this.Qh = 1;
    this.Qg[0] = 3.4028235E+38F;
    this.Qg[1] = 3.4028235E+38F;
    this.Qf[0] = 0.2F;
    this.Qf[1] = 0.2F;
    this.Qj[0] = 0.001F;
    this.Qj[1] = 0.001F;
    this.Qi = Qq;
    this.Qc.Qr = 500;
    this.Qc.Qs = 500;
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = f(this.Qf[paramInt], paramFloat2, this.Qg[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.Qj[paramInt];
    paramFloat2 = this.Qk[paramInt];
    float f1 = this.Ql[paramInt];
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
    for (paramFloat1 = -this.Qd.getInterpolation(-paramFloat2);; paramFloat1 = this.Qd.getInterpolation(paramFloat2))
    {
      paramFloat1 = e(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  private void fm()
  {
    if (this.Qn)
    {
      this.DQ = false;
      return;
    }
    this.Qc.fm();
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
          switch (this.Qh)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.DQ) || (this.Qh != 1));
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
      fm();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public abstract void aR(int paramInt);
  
  public abstract boolean aS(int paramInt);
  
  final boolean bI()
  {
    a locala = this.Qc;
    int i = locala.fo();
    int j = locala.fn();
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
      while ((this.Qp) && (this.DQ))
      {
        return true;
        this.Qo = true;
        this.Qm = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.Qe.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.Qe.getHeight());
        paramView = this.Qc;
        paramView.Qt = f1;
        paramView.Qu = f2;
        if ((!this.DQ) && (bI()))
        {
          if (this.mRunnable == null) {
            this.mRunnable = new b();
          }
          this.DQ = true;
          this.Qn = true;
          if ((!this.Qm) && (this.Qi > 0)) {
            t.a(this.Qe, this.mRunnable, this.Qi);
          }
          for (;;)
          {
            this.Qm = true;
            break;
            this.mRunnable.run();
          }
          fm();
        }
      }
    }
  }
  
  static final class a
  {
    int Qr;
    int Qs;
    float Qt;
    float Qu;
    long Qv = 0L;
    long Qw = -1L;
    float Qx;
    int Qy;
    long mStartTime = -9223372036854775808L;
    int zk = 0;
    int zl = 0;
    
    public final void fm()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.Qy = a.u((int)(l - this.mStartTime), this.Qs);
      this.Qx = l(l);
      this.Qw = l;
    }
    
    public final int fn()
    {
      return (int)(this.Qt / Math.abs(this.Qt));
    }
    
    public final int fo()
    {
      return (int)(this.Qu / Math.abs(this.Qu));
    }
    
    final float l(long paramLong)
    {
      if (paramLong < this.mStartTime) {
        return 0.0F;
      }
      if ((this.Qw < 0L) || (paramLong < this.Qw)) {
        return a.e((float)(paramLong - this.mStartTime) / this.Qr, 0.0F, 1.0F) * 0.5F;
      }
      long l = this.Qw;
      float f1 = this.Qx;
      float f2 = this.Qx;
      return a.e((float)(paramLong - l) / this.Qy, 0.0F, 1.0F) * f2 + (1.0F - f1);
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      if (!a.this.DQ) {
        return;
      }
      if (a.this.Qn)
      {
        a.this.Qn = false;
        locala = a.this.Qc;
        locala.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        locala.Qw = -1L;
        locala.Qv = locala.mStartTime;
        locala.Qx = 0.5F;
        locala.zk = 0;
        locala.zl = 0;
      }
      a.a locala = a.this.Qc;
      if ((locala.Qw > 0L) && (AnimationUtils.currentAnimationTimeMillis() > locala.Qw + locala.Qy)) {}
      for (int i = 1; (i != 0) || (!a.this.bI()); i = 0)
      {
        a.this.DQ = false;
        return;
      }
      if (a.this.Qo)
      {
        a.this.Qo = false;
        a locala1 = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala1.Qe.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (locala.Qv == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = locala.l(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - locala.Qv;
      locala.Qv = l1;
      locala.zk = ((int)((float)l2 * f * locala.Qt));
      locala.zl = ((int)((float)l2 * f * locala.Qu));
      i = locala.zl;
      a.this.aR(i);
      t.b(a.this.Qe, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.a
 * JD-Core Version:    0.7.0.1
 */