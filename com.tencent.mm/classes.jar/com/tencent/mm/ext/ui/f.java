package com.tencent.mm.ext.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class f
{
  private static final Interpolator sInterpolator;
  int Rh;
  float[] Ri;
  float[] Rj;
  float[] Rk;
  float[] Rl;
  int[] Rm;
  private int[] Rn;
  private int[] Ro;
  int Rp;
  float Rq;
  float Rr;
  private int Rs;
  int Rt;
  View Rv;
  boolean Rw;
  final ViewGroup Rx;
  final Runnable Ry;
  h jRY;
  final a jRZ;
  int mActivePointerId;
  private int mTouchSlop;
  VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(259082);
    sInterpolator = new f.1();
    AppMethodBeat.o(259082);
  }
  
  private f(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(259049);
    this.mActivePointerId = -1;
    this.Ry = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(259033);
        f.this.bR(0);
        AppMethodBeat.o(259033);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(259049);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(259049);
      throw paramContext;
    }
    this.Rx = paramViewGroup;
    this.jRZ = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.Rs = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.Rq = paramViewGroup.getScaledMaximumFlingVelocity();
    this.Rr = paramViewGroup.getScaledMinimumFlingVelocity();
    this.jRY = h.a(paramContext, paramInterpolator);
    AppMethodBeat.o(259049);
  }
  
  public static f a(ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(259047);
    paramViewGroup = new f(paramViewGroup.getContext(), paramViewGroup, parama, paramInterpolator);
    AppMethodBeat.o(259047);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259071);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.Rm[paramInt1] & paramInt2) != paramInt2) || ((this.Rt & paramInt2) == 0) || ((this.Ro[paramInt1] & paramInt2) == paramInt2) || ((this.Rn[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(259071);
      return false;
    }
    if (((this.Rn[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(259071);
      return true;
    }
    AppMethodBeat.o(259071);
    return false;
  }
  
  private void aEm()
  {
    AppMethodBeat.i(259060);
    if (this.Ri == null)
    {
      AppMethodBeat.o(259060);
      return;
    }
    Arrays.fill(this.Ri, 0.0F);
    Arrays.fill(this.Rj, 0.0F);
    Arrays.fill(this.Rk, 0.0F);
    Arrays.fill(this.Rl, 0.0F);
    Arrays.fill(this.Rm, 0);
    Arrays.fill(this.Rn, 0);
    Arrays.fill(this.Ro, 0);
    this.Rp = 0;
    AppMethodBeat.o(259060);
  }
  
  private int dg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259079);
    int j = 0;
    if (paramInt1 < this.Rx.getLeft() + this.Rs) {
      j = 1;
    }
    int i = j;
    if (paramInt2 < this.Rx.getTop() + this.Rs) {
      i = j | 0x4;
    }
    j = i;
    if (paramInt1 > this.Rx.getRight() - this.Rs) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > this.Rx.getBottom() - this.Rs) {
      paramInt1 = j | 0x8;
    }
    AppMethodBeat.o(259079);
    return paramInt1;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(259057);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(259057);
    return paramFloat;
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(259056);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(259056);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(259056);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(259056);
      return paramFloat1;
    }
    AppMethodBeat.o(259056);
    return paramFloat1;
  }
  
  static int f(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(259055);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(259055);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(259055);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(259055);
      return paramInt1;
    }
    AppMethodBeat.o(259055);
    return paramInt1;
  }
  
  public static boolean g(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259075);
    if (paramView == null)
    {
      AppMethodBeat.o(259075);
      return false;
    }
    if ((paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom()))
    {
      AppMethodBeat.o(259075);
      return true;
    }
    AppMethodBeat.o(259075);
    return false;
  }
  
  private void rT(int paramInt)
  {
    AppMethodBeat.i(259061);
    if ((this.Ri == null) || (this.Ri.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Ri != null)
      {
        System.arraycopy(this.Ri, 0, arrayOfFloat1, 0, this.Ri.length);
        System.arraycopy(this.Rj, 0, arrayOfFloat2, 0, this.Rj.length);
        System.arraycopy(this.Rk, 0, arrayOfFloat3, 0, this.Rk.length);
        System.arraycopy(this.Rl, 0, arrayOfFloat4, 0, this.Rl.length);
        System.arraycopy(this.Rm, 0, arrayOfInt1, 0, this.Rm.length);
        System.arraycopy(this.Rn, 0, arrayOfInt2, 0, this.Rn.length);
        System.arraycopy(this.Ro, 0, arrayOfInt3, 0, this.Ro.length);
      }
      this.Ri = arrayOfFloat1;
      this.Rj = arrayOfFloat2;
      this.Rk = arrayOfFloat3;
      this.Rl = arrayOfFloat4;
      this.Rm = arrayOfInt1;
      this.Rn = arrayOfInt2;
      this.Ro = arrayOfInt3;
    }
    AppMethodBeat.o(259061);
  }
  
  private void x(View paramView, int paramInt)
  {
    AppMethodBeat.i(259051);
    if (paramView.getParent() != this.Rx)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Rx + ")");
      AppMethodBeat.o(259051);
      throw paramView;
    }
    this.Rv = paramView;
    this.mActivePointerId = paramInt;
    bR(1);
    AppMethodBeat.o(259051);
  }
  
  public final View K(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259077);
    int i = this.Rx.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.Rx.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(259077);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(259077);
    return null;
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(259062);
    rT(paramInt);
    float[] arrayOfFloat = this.Ri;
    this.Rk[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.Rj;
    this.Rl[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.Rm[paramInt] = dg((int)paramFloat1, (int)paramFloat2);
    this.Rp |= 1 << paramInt;
    AppMethodBeat.o(259062);
  }
  
  final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(259070);
    if (a(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 4)) {
        i = j | 0x4;
      }
      j = i;
      if (a(paramFloat1, paramFloat2, paramInt, 2)) {
        j = i | 0x2;
      }
      i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 8)) {
        i = j | 0x8;
      }
      if (i != 0)
      {
        int[] arrayOfInt = this.Rn;
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      AppMethodBeat.o(259070);
      return;
      j = 0;
    }
  }
  
  final void bP(int paramInt)
  {
    if (this.Ri == null) {
      return;
    }
    this.Ri[paramInt] = 0.0F;
    this.Rj[paramInt] = 0.0F;
    this.Rk[paramInt] = 0.0F;
    this.Rl[paramInt] = 0.0F;
    this.Rm[paramInt] = 0;
    this.Rn[paramInt] = 0;
    this.Ro[paramInt] = 0;
    this.Rp &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void bR(int paramInt)
  {
    AppMethodBeat.i(259068);
    if (this.Rh != paramInt)
    {
      this.Rh = paramInt;
      this.jRZ.G(paramInt);
      if (paramInt == 0) {
        this.Rv = null;
      }
    }
    AppMethodBeat.o(259068);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(259053);
    this.mActivePointerId = -1;
    aEm();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(259053);
  }
  
  final int e(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(259054);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(259054);
      return 0;
    }
    int i = this.Rx.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      AppMethodBeat.o(259054);
      return paramInt1;
    }
  }
  
  final void e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(259058);
    this.Rw = true;
    this.jRZ.a(this.Rv, paramFloat1, paramFloat2);
    this.Rw = false;
    if (this.Rh == 1) {
      bR(0);
    }
    AppMethodBeat.o(259058);
  }
  
  final void h(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(259067);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.Rk[k] = f1;
      this.Rl[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(259067);
  }
  
  final void hN()
  {
    AppMethodBeat.i(259073);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.Rq);
    e(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.Rr, this.Rq), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.Rr, this.Rq));
    AppMethodBeat.o(259073);
  }
  
  final boolean r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(259072);
    if (paramView == null)
    {
      AppMethodBeat.o(259072);
      return false;
    }
    int i;
    if (this.jRZ.aEe() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.mTouchSlop)
      {
        AppMethodBeat.o(259072);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(259072);
        return false;
      }
    }
    AppMethodBeat.o(259072);
    return false;
  }
  
  final boolean y(View paramView, int paramInt)
  {
    AppMethodBeat.i(259069);
    if ((paramView == this.Rv) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(259069);
      return true;
    }
    if ((paramView != null) && (this.jRZ.rS(paramInt)))
    {
      this.mActivePointerId = paramInt;
      x(paramView, paramInt);
      AppMethodBeat.o(259069);
      return true;
    }
    AppMethodBeat.o(259069);
    return false;
  }
  
  public static abstract class a
  {
    public void G(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int aEe()
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void df(int paramInt1, int paramInt2) {}
    
    public abstract boolean rS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ext.ui.f
 * JD-Core Version:    0.7.0.1
 */