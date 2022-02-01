package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.g.w;
import com.google.android.material.a.f;
import com.google.android.material.a.g;
import com.google.android.material.a.h;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class a
{
  static final int[] bAO = { 16842919, 16842910 };
  static final int[] bAP = { 16843623, 16842908, 16842910 };
  static final int[] bAQ = { 16842908, 16842910 };
  static final int[] bAR = { 16843623, 16842910 };
  static final int[] bAS = { 16842910 };
  static final TimeInterpolator bAy = com.google.android.material.a.a.buo;
  static final int[] ww = new int[0];
  float Gw;
  Animator bAA;
  h bAB;
  h bAC;
  private final com.google.android.material.internal.i bAD;
  com.google.android.material.g.a bAE;
  Drawable bAF;
  Drawable bAG;
  com.google.android.material.internal.a bAH;
  Drawable bAI;
  float bAJ;
  float bAK;
  float bAL;
  public ArrayList<Animator.AnimatorListener> bAM;
  public ArrayList<Animator.AnimatorListener> bAN;
  final VisibilityAwareImageButton bAT;
  final com.google.android.material.g.b bAU;
  private final RectF bAV;
  private final RectF bAW;
  private final Matrix bAX;
  ViewTreeObserver.OnPreDrawListener bAY;
  int bAz;
  private final Rect bvn;
  h bze;
  h bzf;
  int maxImageSize;
  float rotation;
  
  a(VisibilityAwareImageButton paramVisibilityAwareImageButton, com.google.android.material.g.b paramb)
  {
    AppMethodBeat.i(237441);
    this.bAz = 0;
    this.bAL = 1.0F;
    this.bvn = new Rect();
    this.bAV = new RectF();
    this.bAW = new RectF();
    this.bAX = new Matrix();
    this.bAT = paramVisibilityAwareImageButton;
    this.bAU = paramb;
    this.bAD = new com.google.android.material.internal.i();
    this.bAD.a(bAO, a(new a.c(this)));
    this.bAD.a(bAP, a(new a.b(this)));
    this.bAD.a(bAQ, a(new a.b(this)));
    this.bAD.a(bAR, a(new a.b(this)));
    this.bAD.a(bAS, a(new a.e(this)));
    this.bAD.a(ww, a(new a.a(this)));
    this.rotation = this.bAT.getRotation();
    AppMethodBeat.o(237441);
  }
  
  private static ValueAnimator a(a.f paramf)
  {
    AppMethodBeat.i(237487);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(bAy);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramf);
    localValueAnimator.addUpdateListener(paramf);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    AppMethodBeat.o(237487);
    return localValueAnimator;
  }
  
  private void a(float paramFloat, Matrix paramMatrix)
  {
    AppMethodBeat.i(237460);
    paramMatrix.reset();
    Drawable localDrawable = this.bAT.getDrawable();
    if ((localDrawable != null) && (this.maxImageSize != 0))
    {
      RectF localRectF1 = this.bAV;
      RectF localRectF2 = this.bAW;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localRectF2.set(0.0F, 0.0F, this.maxImageSize, this.maxImageSize);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      paramMatrix.postScale(paramFloat, paramFloat, this.maxImageSize / 2.0F, this.maxImageSize / 2.0F);
    }
    AppMethodBeat.o(237460);
  }
  
  final void Q(float paramFloat)
  {
    AppMethodBeat.i(237453);
    if (this.bAJ != paramFloat)
    {
      this.bAJ = paramFloat;
      l(this.Gw, this.bAJ, this.bAK);
    }
    AppMethodBeat.o(237453);
  }
  
  final void R(float paramFloat)
  {
    AppMethodBeat.i(237455);
    if (this.bAK != paramFloat)
    {
      this.bAK = paramFloat;
      l(this.Gw, this.bAJ, this.bAK);
    }
    AppMethodBeat.o(237455);
  }
  
  final void S(float paramFloat)
  {
    AppMethodBeat.i(237458);
    this.bAL = paramFloat;
    Matrix localMatrix = this.bAX;
    a(paramFloat, localMatrix);
    this.bAT.setImageMatrix(localMatrix);
    AppMethodBeat.o(237458);
  }
  
  final AnimatorSet a(h paramh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(237468);
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.bAT, View.ALPHA, new float[] { paramFloat1 });
    paramh.bX("opacity").b(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.bAT, View.SCALE_X, new float[] { paramFloat2 });
    paramh.bX("scale").b(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.bAT, View.SCALE_Y, new float[] { paramFloat2 });
    paramh.bX("scale").b(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.bAX);
    localObjectAnimator = ObjectAnimator.ofObject(this.bAT, new f(), new g(), new Matrix[] { new Matrix(this.bAX) });
    paramh.bX("iconScale").b(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramh = new AnimatorSet();
    com.google.android.material.a.b.a(paramh, localArrayList);
    AppMethodBeat.o(237468);
    return paramh;
  }
  
  final com.google.android.material.internal.a a(int paramInt, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237478);
    Context localContext = this.bAT.getContext();
    com.google.android.material.internal.a locala = xc();
    locala.o(androidx.core.content.a.w(localContext, com.google.android.material.a.c.design_fab_stroke_top_outer_color), androidx.core.content.a.w(localContext, com.google.android.material.a.c.design_fab_stroke_top_inner_color), androidx.core.content.a.w(localContext, com.google.android.material.a.c.design_fab_stroke_end_inner_color), androidx.core.content.a.w(localContext, com.google.android.material.a.c.design_fab_stroke_end_outer_color));
    locala.setBorderWidth(paramInt);
    locala.d(paramColorStateList);
    AppMethodBeat.o(237478);
    return locala;
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    AppMethodBeat.i(237446);
    this.bAF = androidx.core.graphics.drawable.a.p(xd());
    androidx.core.graphics.drawable.a.a(this.bAF, paramColorStateList1);
    if (paramMode != null) {
      androidx.core.graphics.drawable.a.a(this.bAF, paramMode);
    }
    this.bAG = androidx.core.graphics.drawable.a.p(xd());
    androidx.core.graphics.drawable.a.a(this.bAG, com.google.android.material.f.a.g(paramColorStateList2));
    if (paramInt > 0)
    {
      this.bAH = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = this.bAH;
      paramColorStateList1[1] = this.bAF;
      paramColorStateList1[2] = this.bAG;
    }
    for (;;)
    {
      this.bAI = new LayerDrawable(paramColorStateList1);
      this.bAE = new com.google.android.material.g.a(this.bAT.getContext(), this.bAI, this.bAU.getRadius(), this.Gw, this.Gw + this.bAK);
      paramColorStateList1 = this.bAE;
      paramColorStateList1.bDR = false;
      paramColorStateList1.invalidateSelf();
      this.bAU.setBackgroundDrawable(this.bAE);
      AppMethodBeat.o(237446);
      return;
      this.bAH = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.bAF;
      paramColorStateList1[1] = this.bAG;
    }
  }
  
  final void e(float paramFloat)
  {
    AppMethodBeat.i(237450);
    if (this.Gw != paramFloat)
    {
      this.Gw = paramFloat;
      l(this.Gw, this.bAJ, this.bAK);
    }
    AppMethodBeat.o(237450);
  }
  
  void k(Rect paramRect)
  {
    AppMethodBeat.i(237472);
    this.bAE.getPadding(paramRect);
    AppMethodBeat.o(237472);
  }
  
  void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(237462);
    if (this.bAE != null)
    {
      this.bAE.b(paramFloat1, this.bAK + paramFloat1);
      xa();
    }
    AppMethodBeat.o(237462);
  }
  
  void l(Rect paramRect) {}
  
  void p(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237464);
    com.google.android.material.internal.i locali = this.bAD;
    int j = locali.bCV.size();
    int i = 0;
    i.a locala;
    if (i < j)
    {
      locala = (i.a)locali.bCV.get(i);
      if (!StateSet.stateSetMatches(locala.bDa, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = locala;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != locali.bCW)
      {
        if ((locali.bCW != null) && (locali.bCX != null))
        {
          locali.bCX.cancel();
          locali.bCX = null;
        }
        locali.bCW = paramArrayOfInt;
        if (paramArrayOfInt != null)
        {
          locali.bCX = paramArrayOfInt.animator;
          locali.bCX.start();
        }
      }
      AppMethodBeat.o(237464);
      return;
      i += 1;
      break;
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237448);
    if (this.bAG != null) {
      androidx.core.graphics.drawable.a.a(this.bAG, com.google.android.material.f.a.g(paramColorStateList));
    }
    AppMethodBeat.o(237448);
  }
  
  float wW()
  {
    return this.Gw;
  }
  
  final void wX()
  {
    AppMethodBeat.i(237457);
    S(this.bAL);
    AppMethodBeat.o(237457);
  }
  
  void wY()
  {
    AppMethodBeat.i(237465);
    com.google.android.material.internal.i locali = this.bAD;
    if (locali.bCX != null)
    {
      locali.bCX.end();
      locali.bCX = null;
    }
    AppMethodBeat.o(237465);
  }
  
  void wZ() {}
  
  final void xa()
  {
    AppMethodBeat.i(237471);
    Rect localRect = this.bvn;
    k(localRect);
    l(localRect);
    this.bAU.c(localRect.left, localRect.top, localRect.right, localRect.bottom);
    AppMethodBeat.o(237471);
  }
  
  boolean xb()
  {
    return true;
  }
  
  com.google.android.material.internal.a xc()
  {
    AppMethodBeat.i(237480);
    com.google.android.material.internal.a locala = new com.google.android.material.internal.a();
    AppMethodBeat.o(237480);
    return locala;
  }
  
  final GradientDrawable xd()
  {
    AppMethodBeat.i(237481);
    GradientDrawable localGradientDrawable = xe();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    AppMethodBeat.o(237481);
    return localGradientDrawable;
  }
  
  GradientDrawable xe()
  {
    AppMethodBeat.i(237483);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    AppMethodBeat.o(237483);
    return localGradientDrawable;
  }
  
  public final boolean xf()
  {
    AppMethodBeat.i(237485);
    if (this.bAT.getVisibility() != 0)
    {
      if (this.bAz == 2)
      {
        AppMethodBeat.o(237485);
        return true;
      }
      AppMethodBeat.o(237485);
      return false;
    }
    if (this.bAz != 1)
    {
      AppMethodBeat.o(237485);
      return true;
    }
    AppMethodBeat.o(237485);
    return false;
  }
  
  final boolean xg()
  {
    AppMethodBeat.i(237488);
    if ((w.ah(this.bAT)) && (!this.bAT.isInEditMode()))
    {
      AppMethodBeat.o(237488);
      return true;
    }
    AppMethodBeat.o(237488);
    return false;
  }
  
  static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.a
 * JD-Core Version:    0.7.0.1
 */