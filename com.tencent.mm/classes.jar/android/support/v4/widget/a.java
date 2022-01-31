package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.q;
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
  private static final int IN = ;
  private float[] IA = { 3.4028235E+38F, 3.4028235E+38F };
  private int IB;
  private int IC;
  private float[] IE = { 0.0F, 0.0F };
  private float[] IF = { 0.0F, 0.0F };
  private float[] IG = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean IH;
  boolean II;
  boolean IJ;
  boolean IK;
  private boolean IL;
  private boolean IM;
  final a Iw = new a();
  private final Interpolator Ix = new AccelerateInterpolator();
  final View Iy;
  private float[] Iz = { 0.0F, 0.0F };
  private Runnable mRunnable;
  
  public a(View paramView)
  {
    this.Iy = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.IG[0] = (f / 1000.0F);
    this.IG[1] = (f / 1000.0F);
    f = j;
    this.IF[0] = (f / 1000.0F);
    this.IF[1] = (f / 1000.0F);
    this.IB = 1;
    this.IA[0] = 3.4028235E+38F;
    this.IA[1] = 3.4028235E+38F;
    this.Iz[0] = 0.2F;
    this.Iz[1] = 0.2F;
    this.IE[0] = 0.001F;
    this.IE[1] = 0.001F;
    this.IC = IN;
    this.Iw.IP = 500;
    this.Iw.IQ = 500;
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = d(this.Iz[paramInt] * paramFloat2, 0.0F, this.IA[paramInt]);
    float f2 = u(paramFloat1, f1);
    paramFloat1 = u(paramFloat2 - paramFloat1, f1) - f2;
    if (paramFloat1 < 0.0F) {
      paramFloat1 = -this.Ix.getInterpolation(-paramFloat1);
    }
    for (paramFloat1 = d(paramFloat1, -1.0F, 1.0F);; paramFloat1 = 0.0F)
    {
      if (paramFloat1 != 0.0F) {
        break label102;
      }
      return 0.0F;
      if (paramFloat1 > 0.0F)
      {
        paramFloat1 = this.Ix.getInterpolation(paramFloat1);
        break;
      }
    }
    label102:
    f2 = this.IE[paramInt];
    paramFloat2 = this.IF[paramInt];
    f1 = this.IG[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return d(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -d(-paramFloat1 * paramFloat3, paramFloat2, f1);
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
  
  private void dx()
  {
    if (this.II)
    {
      this.IK = false;
      return;
    }
    a locala = this.Iw;
    long l = AnimationUtils.currentAnimationTimeMillis();
    int i = (int)(l - locala.mStartTime);
    int j = locala.IQ;
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      locala.IW = i;
      locala.IV = locala.l(l);
      locala.IU = l;
      return;
      if (i < 0) {
        i = 0;
      }
    }
  }
  
  private float u(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (this.IB)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.IK) || (this.IB != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  public final a H(boolean paramBoolean)
  {
    if ((this.IL) && (!paramBoolean)) {
      dx();
    }
    this.IL = paramBoolean;
    return this;
  }
  
  public abstract void aC(int paramInt);
  
  public abstract boolean aD(int paramInt);
  
  final boolean ap()
  {
    a locala = this.Iw;
    int i = (int)(locala.IS / Math.abs(locala.IS));
    int j = (int)(locala.IR / Math.abs(locala.IR));
    if ((i == 0) || (!aD(i)))
    {
      if (j != 0) {}
      return false;
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.IL) {}
    for (;;)
    {
      return false;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      while ((this.IM) && (this.IK))
      {
        return true;
        this.IJ = true;
        this.IH = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.Iy.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.Iy.getHeight());
        paramView = this.Iw;
        paramView.IR = f1;
        paramView.IS = f2;
        if ((!this.IK) && (ap()))
        {
          if (this.mRunnable == null) {
            this.mRunnable = new b();
          }
          this.IK = true;
          this.II = true;
          if ((!this.IH) && (this.IC > 0)) {
            q.a(this.Iy, this.mRunnable, this.IC);
          }
          for (;;)
          {
            this.IH = true;
            break;
            this.mRunnable.run();
          }
          dx();
        }
      }
    }
  }
  
  private static final class a
  {
    int IP;
    int IQ;
    float IR;
    float IS;
    long IT = 0L;
    long IU = -1L;
    float IV;
    int IW;
    long mStartTime = -9223372036854775808L;
    int qP = 0;
    int qQ = 0;
    
    final float l(long paramLong)
    {
      if (paramLong < this.mStartTime) {
        return 0.0F;
      }
      if ((this.IU < 0L) || (paramLong < this.IU)) {
        return a.d((float)(paramLong - this.mStartTime) / this.IP, 0.0F, 1.0F) * 0.5F;
      }
      long l = this.IU;
      float f1 = this.IV;
      float f2 = this.IV;
      return a.d((float)(paramLong - l) / this.IW, 0.0F, 1.0F) * f2 + (1.0F - f1);
    }
  }
  
  private final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      if (!a.this.IK) {
        return;
      }
      if (a.this.II)
      {
        a.this.II = false;
        locala = a.this.Iw;
        locala.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        locala.IU = -1L;
        locala.IT = locala.mStartTime;
        locala.IV = 0.5F;
        locala.qP = 0;
        locala.qQ = 0;
      }
      a.a locala = a.this.Iw;
      if ((locala.IU > 0L) && (AnimationUtils.currentAnimationTimeMillis() > locala.IU + locala.IW)) {}
      for (int i = 1; (i != 0) || (!a.this.ap()); i = 0)
      {
        a.this.IK = false;
        return;
      }
      if (a.this.IJ)
      {
        a.this.IJ = false;
        a locala1 = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala1.Iy.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (locala.IT == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = locala.l(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - locala.IT;
      locala.IT = l1;
      locala.qP = ((int)((float)l2 * f * locala.IR));
      locala.qQ = ((int)((float)l2 * f * locala.IS));
      i = locala.qQ;
      a.this.aC(i);
      q.b(a.this.Iy, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.a
 * JD-Core Version:    0.7.0.1
 */