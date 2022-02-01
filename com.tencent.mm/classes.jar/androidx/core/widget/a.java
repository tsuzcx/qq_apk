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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a
  implements View.OnTouchListener
{
  private static final int PL = ;
  private float[] PA = { 3.4028235E+38F, 3.4028235E+38F };
  private int PB;
  private int PC;
  private float[] PD = { 0.0F, 0.0F };
  private float[] PE = { 0.0F, 0.0F };
  private float[] PF = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean PG;
  boolean PH;
  boolean PI;
  boolean PJ;
  private boolean PK;
  final a Pw = new a();
  private final Interpolator Px = new AccelerateInterpolator();
  final View Py;
  private float[] Pz = { 0.0F, 0.0F };
  private boolean mEnabled;
  private Runnable mRunnable;
  
  public a(View paramView)
  {
    this.Py = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.PF[0] = (f / 1000.0F);
    this.PF[1] = (f / 1000.0F);
    f = j;
    this.PE[0] = (f / 1000.0F);
    this.PE[1] = (f / 1000.0F);
    this.PB = 1;
    this.PA[0] = 3.4028235E+38F;
    this.PA[1] = 3.4028235E+38F;
    this.Pz[0] = 0.2F;
    this.Pz[1] = 0.2F;
    this.PD[0] = 0.001F;
    this.PD[1] = 0.001F;
    this.PC = PL;
    this.Pw.PM = 500;
    this.Pw.PN = 500;
  }
  
  static int G(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = 0.0F;
    paramFloat1 = d(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = d(paramFloat4, paramFloat1);
    paramFloat2 = d(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat2 < 0.0F) {}
    for (paramFloat1 = -this.Px.getInterpolation(-paramFloat2);; paramFloat1 = this.Px.getInterpolation(paramFloat2))
    {
      paramFloat1 = d(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = a(this.Pz[paramInt], paramFloat2, this.PA[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.PD[paramInt];
    paramFloat2 = this.PE[paramInt];
    float f1 = this.PF[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return d(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -d(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  private float d(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (this.PB)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.PJ) || (this.PB != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
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
  
  private void hz()
  {
    if (this.PH)
    {
      this.PJ = false;
      return;
    }
    this.Pw.hz();
  }
  
  public final a ad(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      hz();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public abstract void bH(int paramInt);
  
  public abstract boolean bI(int paramInt);
  
  final boolean hy()
  {
    a locala = this.Pw;
    int i = locala.hB();
    int j = locala.hA();
    if ((i == 0) || (!bI(i)))
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
      while ((this.PK) && (this.PJ))
      {
        return true;
        this.PI = true;
        this.PG = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.Py.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.Py.getHeight());
        paramView = this.Pw;
        paramView.PO = f1;
        paramView.PP = f2;
        if ((!this.PJ) && (hy()))
        {
          if (this.mRunnable == null) {
            this.mRunnable = new b();
          }
          this.PJ = true;
          this.PH = true;
          if ((!this.PG) && (this.PC > 0)) {
            w.a(this.Py, this.mRunnable, this.PC);
          }
          for (;;)
          {
            this.PG = true;
            break;
            this.mRunnable.run();
          }
          hz();
        }
      }
    }
  }
  
  static final class a
  {
    int PM;
    int PN;
    float PO;
    float PP;
    long PQ = 0L;
    int PR = 0;
    int PS = 0;
    long PT = -1L;
    float PU;
    int PV;
    long mStartTime = -9223372036854775808L;
    
    final float h(long paramLong)
    {
      AppMethodBeat.i(252318);
      if (paramLong < this.mStartTime)
      {
        AppMethodBeat.o(252318);
        return 0.0F;
      }
      if ((this.PT < 0L) || (paramLong < this.PT))
      {
        f1 = a.d((float)(paramLong - this.mStartTime) / this.PM, 0.0F, 1.0F);
        AppMethodBeat.o(252318);
        return f1 * 0.5F;
      }
      long l = this.PT;
      float f1 = this.PU;
      float f2 = this.PU;
      float f3 = a.d((float)(paramLong - l) / this.PV, 0.0F, 1.0F);
      AppMethodBeat.o(252318);
      return f3 * f2 + (1.0F - f1);
    }
    
    public final int hA()
    {
      AppMethodBeat.i(252319);
      int i = (int)(this.PO / Math.abs(this.PO));
      AppMethodBeat.o(252319);
      return i;
    }
    
    public final int hB()
    {
      AppMethodBeat.i(252320);
      int i = (int)(this.PP / Math.abs(this.PP));
      AppMethodBeat.o(252320);
      return i;
    }
    
    public final void hz()
    {
      AppMethodBeat.i(252316);
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.PV = a.G((int)(l - this.mStartTime), this.PN);
      this.PU = h(l);
      this.PT = l;
      AppMethodBeat.o(252316);
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(252330);
      if (!a.this.PJ)
      {
        AppMethodBeat.o(252330);
        return;
      }
      if (a.this.PH)
      {
        a.this.PH = false;
        localObject = a.this.Pw;
        ((a.a)localObject).mStartTime = AnimationUtils.currentAnimationTimeMillis();
        ((a.a)localObject).PT = -1L;
        ((a.a)localObject).PQ = ((a.a)localObject).mStartTime;
        ((a.a)localObject).PU = 0.5F;
        ((a.a)localObject).PR = 0;
        ((a.a)localObject).PS = 0;
      }
      Object localObject = a.this.Pw;
      if ((((a.a)localObject).PT > 0L) && (AnimationUtils.currentAnimationTimeMillis() > ((a.a)localObject).PT + ((a.a)localObject).PV)) {}
      for (int i = 1; (i != 0) || (!a.this.hy()); i = 0)
      {
        a.this.PJ = false;
        AppMethodBeat.o(252330);
        return;
      }
      if (a.this.PI)
      {
        a.this.PI = false;
        a locala = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala.Py.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (((a.a)localObject).PQ == 0L)
      {
        localObject = new RuntimeException("Cannot compute scroll delta before calling start()");
        AppMethodBeat.o(252330);
        throw ((Throwable)localObject);
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = ((a.a)localObject).h(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - ((a.a)localObject).PQ;
      ((a.a)localObject).PQ = l1;
      ((a.a)localObject).PR = ((int)((float)l2 * f * ((a.a)localObject).PO));
      ((a.a)localObject).PS = ((int)((float)l2 * f * ((a.a)localObject).PP));
      i = ((a.a)localObject).PS;
      a.this.bH(i);
      w.a(a.this.Py, this);
      AppMethodBeat.o(252330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.a
 * JD-Core Version:    0.7.0.1
 */