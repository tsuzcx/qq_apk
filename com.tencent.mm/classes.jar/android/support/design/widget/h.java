package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.b;
import android.support.v4.view.t;
import android.util.StateSet;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class h
{
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] ENABLED_STATE_SET;
  static final int[] PRESSED_ENABLED_STATE_SET;
  static final int[] jF;
  static final Interpolator jv = a.fk;
  float gV;
  private final Rect hV = new Rect();
  Drawable jA;
  d jB;
  Drawable jC;
  float jD;
  float jE;
  final VisibilityAwareImageButton jG;
  final k jH;
  ViewTreeObserver.OnPreDrawListener jI;
  int jw = 0;
  private final m jx;
  j jy;
  Drawable jz;
  
  static
  {
    PRESSED_ENABLED_STATE_SET = new int[] { 16842919, 16842910 };
    jF = new int[] { 16842908, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  h(VisibilityAwareImageButton paramVisibilityAwareImageButton, k paramk)
  {
    this.jG = paramVisibilityAwareImageButton;
    this.jH = paramk;
    this.jx = new m();
    this.jx.a(PRESSED_ENABLED_STATE_SET, a(new h.b(this)));
    this.jx.a(jF, a(new h.b(this)));
    this.jx.a(ENABLED_STATE_SET, a(new h.d(this)));
    this.jx.a(EMPTY_STATE_SET, a(new h.a(this)));
    this.gV = this.jG.getRotation();
  }
  
  private static ColorStateList I(int paramInt)
  {
    return new ColorStateList(new int[][] { jF, PRESSED_ENABLED_STATE_SET, new int[0] }, new int[] { paramInt, paramInt, 0 });
  }
  
  private static ValueAnimator a(h.e parame)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(jv);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(parame);
    localValueAnimator.addUpdateListener(parame);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  final d a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.jG.getContext();
    d locald = bw();
    locald.b(b.m(localContext, 2131689937), b.m(localContext, 2131689936), b.m(localContext, 2131689934), b.m(localContext, 2131689935));
    locald.setBorderWidth(paramInt);
    locald.a(paramColorStateList);
    return locald;
  }
  
  void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.jz = android.support.v4.graphics.drawable.a.e(bx());
    android.support.v4.graphics.drawable.a.a(this.jz, paramColorStateList);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.jz, paramMode);
    }
    this.jA = android.support.v4.graphics.drawable.a.e(bx());
    android.support.v4.graphics.drawable.a.a(this.jA, I(paramInt1));
    if (paramInt2 > 0)
    {
      this.jB = a(paramInt2, paramColorStateList);
      paramColorStateList = new Drawable[3];
      paramColorStateList[0] = this.jB;
      paramColorStateList[1] = this.jz;
      paramColorStateList[2] = this.jA;
    }
    for (;;)
    {
      this.jC = new LayerDrawable(paramColorStateList);
      this.jy = new j(this.jG.getContext(), this.jC, this.jH.getRadius(), this.jD, this.jD + this.jE);
      paramColorStateList = this.jy;
      paramColorStateList.kA = false;
      paramColorStateList.invalidateSelf();
      this.jH.setBackgroundDrawable(this.jy);
      return;
      this.jB = null;
      paramColorStateList = new Drawable[2];
      paramColorStateList[0] = this.jz;
      paramColorStateList[1] = this.jA;
    }
  }
  
  void bs()
  {
    m localm = this.jx;
    if (localm.kK != null)
    {
      localm.kK.end();
      localm.kK = null;
    }
  }
  
  void bt() {}
  
  final void bu()
  {
    Rect localRect = this.hV;
    d(localRect);
    e(localRect);
    this.jH.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean bv()
  {
    return true;
  }
  
  d bw()
  {
    return new d();
  }
  
  final GradientDrawable bx()
  {
    GradientDrawable localGradientDrawable = by();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  GradientDrawable by()
  {
    return new GradientDrawable();
  }
  
  final boolean bz()
  {
    return (t.as(this.jG)) && (!this.jG.isInEditMode());
  }
  
  void c(int[] paramArrayOfInt)
  {
    m localm = this.jx;
    int j = localm.kI.size();
    int i = 0;
    m.a locala;
    if (i < j)
    {
      locala = (m.a)localm.kI.get(i);
      if (!StateSet.stateSetMatches(locala.kN, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = locala;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != localm.kJ)
      {
        if ((localm.kJ != null) && (localm.kK != null))
        {
          localm.kK.cancel();
          localm.kK = null;
        }
        localm.kJ = paramArrayOfInt;
        if (paramArrayOfInt != null)
        {
          localm.kK = paramArrayOfInt.kO;
          localm.kK.start();
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  void d(Rect paramRect)
  {
    this.jy.getPadding(paramRect);
  }
  
  void e(Rect paramRect) {}
  
  float getElevation()
  {
    return this.jD;
  }
  
  void o(float paramFloat1, float paramFloat2)
  {
    if (this.jy != null)
    {
      this.jy.p(paramFloat1, this.jE + paramFloat1);
      bu();
    }
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.jD != paramFloat)
    {
      this.jD = paramFloat;
      o(paramFloat, this.jE);
    }
  }
  
  void setRippleColor(int paramInt)
  {
    if (this.jA != null) {
      android.support.v4.graphics.drawable.a.a(this.jA, I(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.h
 * JD-Core Version:    0.7.0.1
 */