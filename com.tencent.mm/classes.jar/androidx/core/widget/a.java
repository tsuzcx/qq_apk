package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a
  implements View.OnTouchListener
{
  private static final int bwd = ;
  final a bvO = new a();
  private final Interpolator bvP = new AccelerateInterpolator();
  final View bvQ;
  private float[] bvR = { 0.0F, 0.0F };
  private float[] bvS = { 3.4028235E+38F, 3.4028235E+38F };
  private int bvT;
  private int bvU;
  private float[] bvV = { 0.0F, 0.0F };
  private float[] bvW = { 0.0F, 0.0F };
  private float[] bvX = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean bvY;
  boolean bvZ;
  boolean bwa;
  boolean bwb;
  private boolean bwc;
  private boolean mEnabled;
  private Runnable mRunnable;
  
  public a(View paramView)
  {
    this.bvQ = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.bvX[0] = (f / 1000.0F);
    this.bvX[1] = (f / 1000.0F);
    f = j;
    this.bvW[0] = (f / 1000.0F);
    this.bvW[1] = (f / 1000.0F);
    this.bvT = 1;
    this.bvS[0] = 3.4028235E+38F;
    this.bvS[1] = 3.4028235E+38F;
    this.bvR[0] = 0.2F;
    this.bvR[1] = 0.2F;
    this.bvV[0] = 0.001F;
    this.bvV[1] = 0.001F;
    this.bvU = bwd;
    this.bvO.bwe = 500;
    this.bvO.bwf = 500;
  }
  
  private void Fc()
  {
    if (this.bvZ)
    {
      this.bwb = false;
      return;
    }
    this.bvO.Fc();
  }
  
  private float M(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (this.bvT)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.bwb) || (this.bvT != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = e(this.bvR[paramInt], paramFloat2, this.bvS[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.bvV[paramInt];
    paramFloat2 = this.bvW[paramInt];
    float f1 = this.bvX[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return h(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -h(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  static int aB(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  private float e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = 0.0F;
    paramFloat1 = h(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = M(paramFloat4, paramFloat1);
    paramFloat2 = M(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat2 < 0.0F) {}
    for (paramFloat1 = -this.bvP.getInterpolation(-paramFloat2);; paramFloat1 = this.bvP.getInterpolation(paramFloat2))
    {
      paramFloat1 = h(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  static float h(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  final boolean Fb()
  {
    a locala = this.bvO;
    int i = locala.Ff();
    int j = locala.Fe();
    return ((i != 0) && (eD(i))) || ((j != 0) && (Fd()));
  }
  
  public abstract boolean Fd();
  
  public final a aM(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      Fc();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public abstract void eC(int paramInt);
  
  public abstract boolean eD(int paramInt);
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.mEnabled) {}
    for (;;)
    {
      return false;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      while ((this.bwc) && (this.bwb))
      {
        return true;
        this.bwa = true;
        this.bvY = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.bvQ.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.bvQ.getHeight());
        paramView = this.bvO;
        paramView.bwg = f1;
        paramView.bwh = f2;
        if ((!this.bwb) && (Fb()))
        {
          if (this.mRunnable == null) {
            this.mRunnable = new b();
          }
          this.bwb = true;
          this.bvZ = true;
          if ((!this.bvY) && (this.bvU > 0)) {
            z.a(this.bvQ, this.mRunnable, this.bvU);
          }
          for (;;)
          {
            this.bvY = true;
            break;
            this.mRunnable.run();
          }
          Fc();
        }
      }
    }
  }
  
  static final class a
  {
    int bwe;
    int bwf;
    float bwg;
    float bwh;
    long bwi = 0L;
    int bwj = 0;
    int bwk = 0;
    long bwl = -1L;
    float bwm;
    int bwn;
    long mStartTime = -9223372036854775808L;
    
    public final void Fc()
    {
      AppMethodBeat.i(195410);
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.bwn = a.aB((int)(l - this.mStartTime), this.bwf);
      this.bwm = bw(l);
      this.bwl = l;
      AppMethodBeat.o(195410);
    }
    
    public final int Fe()
    {
      AppMethodBeat.i(195420);
      int i = (int)(this.bwg / Math.abs(this.bwg));
      AppMethodBeat.o(195420);
      return i;
    }
    
    public final int Ff()
    {
      AppMethodBeat.i(195425);
      int i = (int)(this.bwh / Math.abs(this.bwh));
      AppMethodBeat.o(195425);
      return i;
    }
    
    final float bw(long paramLong)
    {
      AppMethodBeat.i(195417);
      if (paramLong < this.mStartTime)
      {
        AppMethodBeat.o(195417);
        return 0.0F;
      }
      if ((this.bwl < 0L) || (paramLong < this.bwl))
      {
        f1 = a.h((float)(paramLong - this.mStartTime) / this.bwe, 0.0F, 1.0F);
        AppMethodBeat.o(195417);
        return f1 * 0.5F;
      }
      long l = this.bwl;
      float f1 = this.bwm;
      float f2 = this.bwm;
      float f3 = a.h((float)(paramLong - l) / this.bwn, 0.0F, 1.0F);
      AppMethodBeat.o(195417);
      return f3 * f2 + (1.0F - f1);
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(195402);
      if (!a.this.bwb)
      {
        AppMethodBeat.o(195402);
        return;
      }
      if (a.this.bvZ)
      {
        a.this.bvZ = false;
        localObject = a.this.bvO;
        ((a.a)localObject).mStartTime = AnimationUtils.currentAnimationTimeMillis();
        ((a.a)localObject).bwl = -1L;
        ((a.a)localObject).bwi = ((a.a)localObject).mStartTime;
        ((a.a)localObject).bwm = 0.5F;
        ((a.a)localObject).bwj = 0;
        ((a.a)localObject).bwk = 0;
      }
      Object localObject = a.this.bvO;
      if ((((a.a)localObject).bwl > 0L) && (AnimationUtils.currentAnimationTimeMillis() > ((a.a)localObject).bwl + ((a.a)localObject).bwn)) {}
      for (int i = 1; (i != 0) || (!a.this.Fb()); i = 0)
      {
        a.this.bwb = false;
        AppMethodBeat.o(195402);
        return;
      }
      if (a.this.bwa)
      {
        a.this.bwa = false;
        a locala = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala.bvQ.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (((a.a)localObject).bwi == 0L)
      {
        localObject = new RuntimeException("Cannot compute scroll delta before calling start()");
        AppMethodBeat.o(195402);
        throw ((Throwable)localObject);
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = ((a.a)localObject).bw(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - ((a.a)localObject).bwi;
      ((a.a)localObject).bwi = l1;
      ((a.a)localObject).bwj = ((int)((float)l2 * f * ((a.a)localObject).bwg));
      ((a.a)localObject).bwk = ((int)((float)l2 * f * ((a.a)localObject).bwh));
      i = ((a.a)localObject).bwk;
      a.this.eC(i);
      z.b(a.this.bvQ, this);
      AppMethodBeat.o(195402);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.a
 * JD-Core Version:    0.7.0.1
 */