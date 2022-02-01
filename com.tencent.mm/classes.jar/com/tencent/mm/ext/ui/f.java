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
import androidx.core.g.j;
import androidx.core.g.y;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class f
{
  private static final Interpolator sInterpolator;
  float[] bxA;
  float[] bxB;
  float[] bxC;
  int[] bxD;
  private int[] bxE;
  private int[] bxF;
  int bxG;
  float bxH;
  float bxI;
  private int bxJ;
  int bxK;
  View bxM;
  boolean bxN;
  final ViewGroup bxO;
  final Runnable bxP;
  int bxy;
  float[] bxz;
  int mActivePointerId;
  private int mTouchSlop;
  VelocityTracker mVelocityTracker;
  i mri;
  final a mrj;
  
  static
  {
    AppMethodBeat.i(235410);
    sInterpolator = new f.1();
    AppMethodBeat.o(235410);
  }
  
  private f(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(235351);
    this.mActivePointerId = -1;
    this.bxP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235342);
        f.this.eM(0);
        AppMethodBeat.o(235342);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(235351);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(235351);
      throw paramContext;
    }
    this.bxO = paramViewGroup;
    this.mrj = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.bxJ = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.bxH = paramViewGroup.getScaledMaximumFlingVelocity();
    this.bxI = paramViewGroup.getScaledMinimumFlingVelocity();
    this.mri = i.a(paramContext, paramInterpolator);
    AppMethodBeat.o(235351);
  }
  
  private void B(View paramView, int paramInt)
  {
    AppMethodBeat.i(235355);
    if (paramView.getParent() != this.bxO)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.bxO + ")");
      AppMethodBeat.o(235355);
      throw paramView;
    }
    this.bxM = paramView;
    this.mActivePointerId = paramInt;
    eM(1);
    AppMethodBeat.o(235355);
  }
  
  public static f a(ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(235341);
    paramViewGroup = new f(paramViewGroup.getContext(), paramViewGroup, parama, paramInterpolator);
    AppMethodBeat.o(235341);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235391);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.bxD[paramInt1] & paramInt2) != paramInt2) || ((this.bxK & paramInt2) == 0) || ((this.bxF[paramInt1] & paramInt2) == paramInt2) || ((this.bxE[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(235391);
      return false;
    }
    if (((this.bxE[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(235391);
      return true;
    }
    AppMethodBeat.o(235391);
    return false;
  }
  
  private void aXq()
  {
    AppMethodBeat.i(235378);
    if (this.bxz == null)
    {
      AppMethodBeat.o(235378);
      return;
    }
    Arrays.fill(this.bxz, 0.0F);
    Arrays.fill(this.bxA, 0.0F);
    Arrays.fill(this.bxB, 0.0F);
    Arrays.fill(this.bxC, 0.0F);
    Arrays.fill(this.bxD, 0);
    Arrays.fill(this.bxE, 0);
    Arrays.fill(this.bxF, 0);
    this.bxG = 0;
    AppMethodBeat.o(235378);
  }
  
  private int dT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235402);
    int j = 0;
    if (paramInt1 < this.bxO.getLeft() + this.bxJ) {
      j = 1;
    }
    int i = j;
    if (paramInt2 < this.bxO.getTop() + this.bxJ) {
      i = j | 0x4;
    }
    j = i;
    if (paramInt1 > this.bxO.getRight() - this.bxJ) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > this.bxO.getBottom() - this.bxJ) {
      paramInt1 = j | 0x8;
    }
    AppMethodBeat.o(235402);
    return paramInt1;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(235373);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(235373);
    return paramFloat;
  }
  
  public static boolean g(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235397);
    if (paramView == null)
    {
      AppMethodBeat.o(235397);
      return false;
    }
    if ((paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom()))
    {
      AppMethodBeat.o(235397);
      return true;
    }
    AppMethodBeat.o(235397);
    return false;
  }
  
  private static float i(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(235366);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(235366);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(235366);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(235366);
      return paramFloat1;
    }
    AppMethodBeat.o(235366);
    return paramFloat1;
  }
  
  private void rU(int paramInt)
  {
    AppMethodBeat.i(235384);
    if ((this.bxz == null) || (this.bxz.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.bxz != null)
      {
        System.arraycopy(this.bxz, 0, arrayOfFloat1, 0, this.bxz.length);
        System.arraycopy(this.bxA, 0, arrayOfFloat2, 0, this.bxA.length);
        System.arraycopy(this.bxB, 0, arrayOfFloat3, 0, this.bxB.length);
        System.arraycopy(this.bxC, 0, arrayOfFloat4, 0, this.bxC.length);
        System.arraycopy(this.bxD, 0, arrayOfInt1, 0, this.bxD.length);
        System.arraycopy(this.bxE, 0, arrayOfInt2, 0, this.bxE.length);
        System.arraycopy(this.bxF, 0, arrayOfInt3, 0, this.bxF.length);
      }
      this.bxz = arrayOfFloat1;
      this.bxA = arrayOfFloat2;
      this.bxB = arrayOfFloat3;
      this.bxC = arrayOfFloat4;
      this.bxD = arrayOfInt1;
      this.bxE = arrayOfInt2;
      this.bxF = arrayOfInt3;
    }
    AppMethodBeat.o(235384);
  }
  
  static int t(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235359);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(235359);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(235359);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(235359);
      return paramInt1;
    }
    AppMethodBeat.o(235359);
    return paramInt1;
  }
  
  final boolean C(View paramView, int paramInt)
  {
    AppMethodBeat.i(235457);
    if ((paramView == this.bxM) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(235457);
      return true;
    }
    if ((paramView != null) && (this.mrj.rT(paramInt)))
    {
      this.mActivePointerId = paramInt;
      B(paramView, paramInt);
      AppMethodBeat.o(235457);
      return true;
    }
    AppMethodBeat.o(235457);
    return false;
  }
  
  final void Fy()
  {
    AppMethodBeat.i(235473);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.bxH);
    N(i(y.a(this.mVelocityTracker, this.mActivePointerId), this.bxI, this.bxH), i(y.b(this.mVelocityTracker, this.mActivePointerId), this.bxI, this.bxH));
    AppMethodBeat.o(235473);
  }
  
  final void N(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(235429);
    this.bxN = true;
    this.mrj.b(this.bxM, paramFloat1, paramFloat2);
    this.bxN = false;
    if (this.bxy == 1) {
      eM(0);
    }
    AppMethodBeat.o(235429);
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(235440);
    rU(paramInt);
    float[] arrayOfFloat = this.bxz;
    this.bxB[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.bxA;
    this.bxC[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.bxD[paramInt] = dT((int)paramFloat1, (int)paramFloat2);
    this.bxG |= 1 << paramInt;
    AppMethodBeat.o(235440);
  }
  
  public final View aF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235480);
    int i = this.bxO.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.bxO.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(235480);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(235480);
    return null;
  }
  
  final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(235459);
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
        int[] arrayOfInt = this.bxE;
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      AppMethodBeat.o(235459);
      return;
      j = 0;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(235415);
    this.mActivePointerId = -1;
    aXq();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(235415);
  }
  
  final void eK(int paramInt)
  {
    if (this.bxz == null) {
      return;
    }
    this.bxz[paramInt] = 0.0F;
    this.bxA[paramInt] = 0.0F;
    this.bxB[paramInt] = 0.0F;
    this.bxC[paramInt] = 0.0F;
    this.bxD[paramInt] = 0;
    this.bxE[paramInt] = 0;
    this.bxF[paramInt] = 0;
    this.bxG &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void eM(int paramInt)
  {
    AppMethodBeat.i(235453);
    if (this.bxy != paramInt)
    {
      this.bxy = paramInt;
      this.mrj.F(paramInt);
      if (paramInt == 0) {
        this.bxM = null;
      }
    }
    AppMethodBeat.o(235453);
  }
  
  final void h(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235446);
    int j = j.f(paramMotionEvent);
    int i = 0;
    while (i < j)
    {
      int k = j.e(paramMotionEvent, i);
      float f1 = j.f(paramMotionEvent, i);
      float f2 = j.g(paramMotionEvent, i);
      this.bxB[k] = f1;
      this.bxC[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(235446);
  }
  
  final int s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235423);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(235423);
      return 0;
    }
    int i = this.bxO.getWidth();
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
      AppMethodBeat.o(235423);
      return paramInt1;
    }
  }
  
  final boolean s(View paramView, float paramFloat)
  {
    AppMethodBeat.i(235467);
    if (paramView == null)
    {
      AppMethodBeat.o(235467);
      return false;
    }
    int i;
    if (this.mrj.aXi() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.mTouchSlop)
      {
        AppMethodBeat.o(235467);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(235467);
        return false;
      }
    }
    AppMethodBeat.o(235467);
    return false;
  }
  
  public static abstract class a
  {
    public void F(int paramInt) {}
    
    public int aXi()
    {
      return 0;
    }
    
    public void b(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void dS(int paramInt1, int paramInt2) {}
    
    public abstract boolean rT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ext.ui.f
 * JD-Core Version:    0.7.0.1
 */