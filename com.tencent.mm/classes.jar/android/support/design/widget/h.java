package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.design.a.c;
import android.support.v4.content.b;
import android.support.v4.view.q;
import android.util.StateSet;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class h
{
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] ENABLED_STATE_SET;
  static final int[] PRESSED_ENABLED_STATE_SET;
  static final Interpolator iC = a.em;
  static final int[] iM;
  float gb;
  private final Rect hc = new Rect();
  int iD = 0;
  private final m iE;
  j iF;
  Drawable iG;
  Drawable iH;
  d iI;
  Drawable iJ;
  float iK;
  float iL;
  final VisibilityAwareImageButton iN;
  final k iO;
  ViewTreeObserver.OnPreDrawListener iP;
  
  static
  {
    PRESSED_ENABLED_STATE_SET = new int[] { 16842919, 16842910 };
    iM = new int[] { 16842908, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  h(VisibilityAwareImageButton paramVisibilityAwareImageButton, k paramk)
  {
    this.iN = paramVisibilityAwareImageButton;
    this.iO = paramk;
    this.iE = new m();
    this.iE.a(PRESSED_ENABLED_STATE_SET, a(new h.b(this)));
    this.iE.a(iM, a(new h.b(this)));
    this.iE.a(ENABLED_STATE_SET, a(new h.d(this)));
    this.iE.a(EMPTY_STATE_SET, a(new a()));
    this.gb = this.iN.getRotation();
  }
  
  private static ColorStateList J(int paramInt)
  {
    return new ColorStateList(new int[][] { iM, PRESSED_ENABLED_STATE_SET, new int[0] }, new int[] { paramInt, paramInt, 0 });
  }
  
  private static ValueAnimator a(h.e parame)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(iC);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(parame);
    localValueAnimator.addUpdateListener(parame);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  final d a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.iN.getContext();
    d locald = aN();
    int i = b.i(localContext, a.c.design_fab_stroke_top_outer_color);
    int j = b.i(localContext, a.c.design_fab_stroke_top_inner_color);
    int k = b.i(localContext, a.c.design_fab_stroke_end_inner_color);
    int m = b.i(localContext, a.c.design_fab_stroke_end_outer_color);
    locald.fU = i;
    locald.fV = j;
    locald.fW = k;
    locald.fX = m;
    float f = paramInt;
    if (locald.fT != f)
    {
      locald.fT = f;
      locald.mPaint.setStrokeWidth(f * 1.3333F);
      locald.ga = true;
      locald.invalidateSelf();
    }
    locald.a(paramColorStateList);
    return locald;
  }
  
  void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.iG = android.support.v4.a.a.a.f(aO());
    android.support.v4.a.a.a.a(this.iG, paramColorStateList);
    if (paramMode != null) {
      android.support.v4.a.a.a.a(this.iG, paramMode);
    }
    this.iH = android.support.v4.a.a.a.f(aO());
    android.support.v4.a.a.a.a(this.iH, J(paramInt1));
    if (paramInt2 > 0)
    {
      this.iI = a(paramInt2, paramColorStateList);
      paramColorStateList = new Drawable[3];
      paramColorStateList[0] = this.iI;
      paramColorStateList[1] = this.iG;
      paramColorStateList[2] = this.iH;
    }
    for (;;)
    {
      this.iJ = new LayerDrawable(paramColorStateList);
      this.iF = new j(this.iN.getContext(), this.iJ, this.iO.getRadius(), this.iK, this.iK + this.iL);
      paramColorStateList = this.iF;
      paramColorStateList.jC = false;
      paramColorStateList.invalidateSelf();
      this.iO.setBackgroundDrawable(this.iF);
      return;
      this.iI = null;
      paramColorStateList = new Drawable[2];
      paramColorStateList[0] = this.iG;
      paramColorStateList[1] = this.iH;
    }
  }
  
  void aJ()
  {
    m localm = this.iE;
    if (localm.jM != null)
    {
      localm.jM.end();
      localm.jM = null;
    }
  }
  
  void aK() {}
  
  final void aL()
  {
    Rect localRect = this.hc;
    d(localRect);
    e(localRect);
    this.iO.d(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean aM()
  {
    return true;
  }
  
  d aN()
  {
    return new d();
  }
  
  final GradientDrawable aO()
  {
    GradientDrawable localGradientDrawable = aP();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  GradientDrawable aP()
  {
    return new GradientDrawable();
  }
  
  final boolean aQ()
  {
    return (q.al(this.iN)) && (!this.iN.isInEditMode());
  }
  
  void c(int[] paramArrayOfInt)
  {
    m localm = this.iE;
    int j = localm.jK.size();
    int i = 0;
    m.a locala;
    if (i < j)
    {
      locala = (m.a)localm.jK.get(i);
      if (!StateSet.stateSetMatches(locala.jP, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = locala;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != localm.jL)
      {
        if ((localm.jL != null) && (localm.jM != null))
        {
          localm.jM.cancel();
          localm.jM = null;
        }
        localm.jL = paramArrayOfInt;
        if (paramArrayOfInt != null)
        {
          localm.jM = paramArrayOfInt.jQ;
          localm.jM.start();
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  void d(Rect paramRect)
  {
    this.iF.getPadding(paramRect);
  }
  
  void e(Rect paramRect) {}
  
  float getElevation()
  {
    return this.iK;
  }
  
  void o(float paramFloat1, float paramFloat2)
  {
    if (this.iF != null)
    {
      this.iF.p(paramFloat1, this.iL + paramFloat1);
      aL();
    }
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.iK != paramFloat)
    {
      this.iK = paramFloat;
      o(paramFloat, this.iL);
    }
  }
  
  void setRippleColor(int paramInt)
  {
    if (this.iH != null) {
      android.support.v4.a.a.a.a(this.iH, J(paramInt));
    }
  }
  
  private final class a
    extends h.e
  {
    a()
    {
      super((byte)0);
    }
    
    protected final float aR()
    {
      return 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.h
 * JD-Core Version:    0.7.0.1
 */