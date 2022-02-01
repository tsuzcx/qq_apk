package com.tencent.mm.ext.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.p;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class f
{
  private static final Interpolator sInterpolator;
  float[] WA;
  float[] WB;
  int[] WC;
  private int[] WD;
  private int[] WE;
  int WF;
  float WG;
  float WH;
  private int WI;
  int WJ;
  View WL;
  boolean WM;
  final ViewGroup WN;
  final Runnable WO;
  int Wx;
  float[] Wy;
  float[] Wz;
  p hgg;
  final a hgh;
  int mActivePointerId;
  private int mTouchSlop;
  VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(197902);
    sInterpolator = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    AppMethodBeat.o(197902);
  }
  
  private f(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(197881);
    this.mActivePointerId = -1;
    this.WO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197879);
        f.this.bf(0);
        AppMethodBeat.o(197879);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(197881);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(197881);
      throw paramContext;
    }
    this.WN = paramViewGroup;
    this.hgh = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.WI = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.WG = paramViewGroup.getScaledMaximumFlingVelocity();
    this.WH = paramViewGroup.getScaledMinimumFlingVelocity();
    this.hgg = p.a(paramContext, paramInterpolator);
    AppMethodBeat.o(197881);
  }
  
  public static f a(ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(197880);
    paramViewGroup = new f(paramViewGroup.getContext(), paramViewGroup, parama, paramInterpolator);
    AppMethodBeat.o(197880);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197896);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.WC[paramInt1] & paramInt2) != paramInt2) || ((this.WJ & paramInt2) == 0) || ((this.WE[paramInt1] & paramInt2) == paramInt2) || ((this.WD[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(197896);
      return false;
    }
    if (((this.WD[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(197896);
      return true;
    }
    AppMethodBeat.o(197896);
    return false;
  }
  
  private int cM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197901);
    int j = 0;
    if (paramInt1 < this.WN.getLeft() + this.WI) {
      j = 1;
    }
    int i = j;
    if (paramInt2 < this.WN.getTop() + this.WI) {
      i = j | 0x4;
    }
    j = i;
    if (paramInt1 > this.WN.getRight() - this.WI) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > this.WN.getBottom() - this.WI) {
      paramInt1 = j | 0x8;
    }
    AppMethodBeat.o(197901);
    return paramInt1;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(197887);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(197887);
    return paramFloat;
  }
  
  private static float f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(197886);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(197886);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(197886);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(197886);
      return paramFloat1;
    }
    AppMethodBeat.o(197886);
    return paramFloat1;
  }
  
  private void gp()
  {
    AppMethodBeat.i(197889);
    if (this.Wy == null)
    {
      AppMethodBeat.o(197889);
      return;
    }
    Arrays.fill(this.Wy, 0.0F);
    Arrays.fill(this.Wz, 0.0F);
    Arrays.fill(this.WA, 0.0F);
    Arrays.fill(this.WB, 0.0F);
    Arrays.fill(this.WC, 0);
    Arrays.fill(this.WD, 0);
    Arrays.fill(this.WE, 0);
    this.WF = 0;
    AppMethodBeat.o(197889);
  }
  
  static int i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197885);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(197885);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(197885);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(197885);
      return paramInt1;
    }
    AppMethodBeat.o(197885);
    return paramInt1;
  }
  
  public static boolean i(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197899);
    if (paramView == null)
    {
      AppMethodBeat.o(197899);
      return false;
    }
    if ((paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom()))
    {
      AppMethodBeat.o(197899);
      return true;
    }
    AppMethodBeat.o(197899);
    return false;
  }
  
  private void pw(int paramInt)
  {
    AppMethodBeat.i(197890);
    if ((this.Wy == null) || (this.Wy.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Wy != null)
      {
        System.arraycopy(this.Wy, 0, arrayOfFloat1, 0, this.Wy.length);
        System.arraycopy(this.Wz, 0, arrayOfFloat2, 0, this.Wz.length);
        System.arraycopy(this.WA, 0, arrayOfFloat3, 0, this.WA.length);
        System.arraycopy(this.WB, 0, arrayOfFloat4, 0, this.WB.length);
        System.arraycopy(this.WC, 0, arrayOfInt1, 0, this.WC.length);
        System.arraycopy(this.WD, 0, arrayOfInt2, 0, this.WD.length);
        System.arraycopy(this.WE, 0, arrayOfInt3, 0, this.WE.length);
      }
      this.Wy = arrayOfFloat1;
      this.Wz = arrayOfFloat2;
      this.WA = arrayOfFloat3;
      this.WB = arrayOfFloat4;
      this.WC = arrayOfInt1;
      this.WD = arrayOfInt2;
      this.WE = arrayOfInt3;
    }
    AppMethodBeat.o(197890);
  }
  
  private void y(View paramView, int paramInt)
  {
    AppMethodBeat.i(197882);
    if (paramView.getParent() != this.WN)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WN + ")");
      AppMethodBeat.o(197882);
      throw paramView;
    }
    this.WL = paramView;
    this.mActivePointerId = paramInt;
    bf(1);
    AppMethodBeat.o(197882);
  }
  
  public final View J(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197900);
    int i = this.WN.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.WN.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(197900);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(197900);
    return null;
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(197891);
    pw(paramInt);
    float[] arrayOfFloat = this.Wy;
    this.WA[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.Wz;
    this.WB[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.WC[paramInt] = cM((int)paramFloat1, (int)paramFloat2);
    this.WF |= 1 << paramInt;
    AppMethodBeat.o(197891);
  }
  
  final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(197895);
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
        int[] arrayOfInt = this.WD;
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      AppMethodBeat.o(197895);
      return;
      j = 0;
    }
  }
  
  final void bd(int paramInt)
  {
    if (this.Wy == null) {
      return;
    }
    this.Wy[paramInt] = 0.0F;
    this.Wz[paramInt] = 0.0F;
    this.WA[paramInt] = 0.0F;
    this.WB[paramInt] = 0.0F;
    this.WC[paramInt] = 0;
    this.WD[paramInt] = 0;
    this.WE[paramInt] = 0;
    this.WF &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void bf(int paramInt)
  {
    AppMethodBeat.i(197893);
    if (this.Wx != paramInt)
    {
      this.Wx = paramInt;
      this.hgh.L(paramInt);
      if (paramInt == 0) {
        this.WL = null;
      }
    }
    AppMethodBeat.o(197893);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(197883);
    this.mActivePointerId = -1;
    gp();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(197883);
  }
  
  final void gq()
  {
    AppMethodBeat.i(197898);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.WG);
    l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.WH, this.WG), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.WH, this.WG));
    AppMethodBeat.o(197898);
  }
  
  final int h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197884);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(197884);
      return 0;
    }
    int i = this.WN.getWidth();
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
      AppMethodBeat.o(197884);
      return paramInt1;
    }
  }
  
  final void i(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197892);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.WA[k] = f1;
      this.WB[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(197892);
  }
  
  final void l(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197888);
    this.WM = true;
    this.hgh.a(this.WL, paramFloat1, paramFloat2);
    this.WM = false;
    if (this.Wx == 1) {
      bf(0);
    }
    AppMethodBeat.o(197888);
  }
  
  final boolean r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(197897);
    if (paramView == null)
    {
      AppMethodBeat.o(197897);
      return false;
    }
    int i;
    if (this.hgh.awM() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.mTouchSlop)
      {
        AppMethodBeat.o(197897);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(197897);
        return false;
      }
    }
    AppMethodBeat.o(197897);
    return false;
  }
  
  final boolean z(View paramView, int paramInt)
  {
    AppMethodBeat.i(197894);
    if ((paramView == this.WL) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(197894);
      return true;
    }
    if ((paramView != null) && (this.hgh.pv(paramInt)))
    {
      this.mActivePointerId = paramInt;
      y(paramView, paramInt);
      AppMethodBeat.o(197894);
      return true;
    }
    AppMethodBeat.o(197894);
    return false;
  }
  
  public static abstract class a
  {
    public void L(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int awM()
    {
      return 0;
    }
    
    public void cL(int paramInt1, int paramInt2) {}
    
    public int e(View paramView, int paramInt)
    {
      return 0;
    }
    
    public abstract boolean pv(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ext.ui.f
 * JD-Core Version:    0.7.0.1
 */