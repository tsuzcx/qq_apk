package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.os.Build.VERSION;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.g.z;
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
  static final TimeInterpolator dtA = com.google.android.material.a.a.dns;
  static final int[] dtQ = { 16842919, 16842910 };
  static final int[] dtR = { 16843623, 16842908, 16842910 };
  static final int[] dtS = { 16842908, 16842910 };
  static final int[] dtT = { 16843623, 16842910 };
  static final int[] dtU = { 16842910 };
  static final int[] xr = new int[0];
  float bmA;
  h dse;
  h dsf;
  int dtB;
  Animator dtC;
  h dtD;
  h dtE;
  private final com.google.android.material.internal.i dtF;
  com.google.android.material.g.a dtG;
  Drawable dtH;
  Drawable dtI;
  com.google.android.material.internal.a dtJ;
  Drawable dtK;
  float dtL;
  float dtM;
  float dtN;
  public ArrayList<Animator.AnimatorListener> dtO;
  public ArrayList<Animator.AnimatorListener> dtP;
  final VisibilityAwareImageButton dtV;
  final com.google.android.material.g.b dtW;
  private final RectF dtX;
  private final RectF dtY;
  private final Matrix dtZ;
  ViewTreeObserver.OnPreDrawListener dua;
  int maxImageSize;
  float rotation;
  private final Rect tmpRect;
  
  a(VisibilityAwareImageButton paramVisibilityAwareImageButton, com.google.android.material.g.b paramb)
  {
    AppMethodBeat.i(209883);
    this.dtB = 0;
    this.dtN = 1.0F;
    this.tmpRect = new Rect();
    this.dtX = new RectF();
    this.dtY = new RectF();
    this.dtZ = new Matrix();
    this.dtV = paramVisibilityAwareImageButton;
    this.dtW = paramb;
    this.dtF = new com.google.android.material.internal.i();
    this.dtF.a(dtQ, a(new c()));
    this.dtF.a(dtR, a(new b()));
    this.dtF.a(dtS, a(new b()));
    this.dtF.a(dtT, a(new b()));
    this.dtF.a(dtU, a(new e()));
    this.dtF.a(xr, a(new a()));
    this.rotation = this.dtV.getRotation();
    AppMethodBeat.o(209883);
  }
  
  private static ValueAnimator a(f paramf)
  {
    AppMethodBeat.i(209901);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(dtA);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramf);
    localValueAnimator.addUpdateListener(paramf);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    AppMethodBeat.o(209901);
    return localValueAnimator;
  }
  
  private void a(float paramFloat, Matrix paramMatrix)
  {
    AppMethodBeat.i(209892);
    paramMatrix.reset();
    Drawable localDrawable = this.dtV.getDrawable();
    if ((localDrawable != null) && (this.maxImageSize != 0))
    {
      RectF localRectF1 = this.dtX;
      RectF localRectF2 = this.dtY;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localRectF2.set(0.0F, 0.0F, this.maxImageSize, this.maxImageSize);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      paramMatrix.postScale(paramFloat, paramFloat, this.maxImageSize / 2.0F, this.maxImageSize / 2.0F);
    }
    AppMethodBeat.o(209892);
  }
  
  com.google.android.material.internal.a WA()
  {
    AppMethodBeat.i(210108);
    com.google.android.material.internal.a locala = new com.google.android.material.internal.a();
    AppMethodBeat.o(210108);
    return locala;
  }
  
  final GradientDrawable WB()
  {
    AppMethodBeat.i(210119);
    GradientDrawable localGradientDrawable = WC();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    AppMethodBeat.o(210119);
    return localGradientDrawable;
  }
  
  GradientDrawable WC()
  {
    AppMethodBeat.i(210126);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    AppMethodBeat.o(210126);
    return localGradientDrawable;
  }
  
  public final boolean WD()
  {
    AppMethodBeat.i(210135);
    if (this.dtV.getVisibility() != 0)
    {
      if (this.dtB == 2)
      {
        AppMethodBeat.o(210135);
        return true;
      }
      AppMethodBeat.o(210135);
      return false;
    }
    if (this.dtB != 1)
    {
      AppMethodBeat.o(210135);
      return true;
    }
    AppMethodBeat.o(210135);
    return false;
  }
  
  final boolean WE()
  {
    AppMethodBeat.i(210142);
    if ((z.au(this.dtV)) && (!this.dtV.isInEditMode()))
    {
      AppMethodBeat.o(210142);
      return true;
    }
    AppMethodBeat.o(210142);
    return false;
  }
  
  final void Wv()
  {
    AppMethodBeat.i(209992);
    aT(this.dtN);
    AppMethodBeat.o(209992);
  }
  
  void Ww()
  {
    AppMethodBeat.i(210029);
    com.google.android.material.internal.i locali = this.dtF;
    if (locali.dvY != null)
    {
      locali.dvY.end();
      locali.dvY = null;
    }
    AppMethodBeat.o(210029);
  }
  
  void Wx() {}
  
  final void Wy()
  {
    AppMethodBeat.i(210060);
    Rect localRect = this.tmpRect;
    q(localRect);
    r(localRect);
    this.dtW.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
    AppMethodBeat.o(210060);
  }
  
  boolean Wz()
  {
    return true;
  }
  
  final AnimatorSet a(h paramh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(210045);
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.dtV, View.ALPHA, new float[] { paramFloat1 });
    paramh.dx("opacity").b(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.dtV, View.SCALE_X, new float[] { paramFloat2 });
    paramh.dx("scale").b(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.dtV, View.SCALE_Y, new float[] { paramFloat2 });
    paramh.dx("scale").b(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.dtZ);
    localObjectAnimator = ObjectAnimator.ofObject(this.dtV, new f(), new g(), new Matrix[] { new Matrix(this.dtZ) });
    paramh.dx("iconScale").b(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramh = new AnimatorSet();
    com.google.android.material.a.b.a(paramh, localArrayList);
    AppMethodBeat.o(210045);
    return paramh;
  }
  
  final com.google.android.material.internal.a a(int paramInt, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210100);
    Context localContext = this.dtV.getContext();
    com.google.android.material.internal.a locala = WA();
    locala.x(androidx.core.content.a.w(localContext, com.google.android.material.a.c.design_fab_stroke_top_outer_color), androidx.core.content.a.w(localContext, com.google.android.material.a.c.design_fab_stroke_top_inner_color), androidx.core.content.a.w(localContext, com.google.android.material.a.c.design_fab_stroke_end_inner_color), androidx.core.content.a.w(localContext, com.google.android.material.a.c.design_fab_stroke_end_outer_color));
    locala.setBorderWidth(paramInt);
    locala.d(paramColorStateList);
    AppMethodBeat.o(210100);
    return locala;
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    AppMethodBeat.i(209930);
    this.dtH = androidx.core.graphics.drawable.a.s(WB());
    androidx.core.graphics.drawable.a.a(this.dtH, paramColorStateList1);
    if (paramMode != null) {
      androidx.core.graphics.drawable.a.a(this.dtH, paramMode);
    }
    this.dtI = androidx.core.graphics.drawable.a.s(WB());
    androidx.core.graphics.drawable.a.a(this.dtI, com.google.android.material.f.a.g(paramColorStateList2));
    if (paramInt > 0)
    {
      this.dtJ = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = this.dtJ;
      paramColorStateList1[1] = this.dtH;
      paramColorStateList1[2] = this.dtI;
    }
    for (;;)
    {
      this.dtK = new LayerDrawable(paramColorStateList1);
      this.dtG = new com.google.android.material.g.a(this.dtV.getContext(), this.dtK, this.dtW.getRadius(), this.bmA, this.bmA + this.dtM);
      paramColorStateList1 = this.dtG;
      paramColorStateList1.dwS = false;
      paramColorStateList1.invalidateSelf();
      this.dtW.setBackgroundDrawable(this.dtG);
      AppMethodBeat.o(209930);
      return;
      this.dtJ = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.dtH;
      paramColorStateList1[1] = this.dtI;
    }
  }
  
  final void aR(float paramFloat)
  {
    AppMethodBeat.i(209972);
    if (this.dtL != paramFloat)
    {
      this.dtL = paramFloat;
      o(this.bmA, this.dtL, this.dtM);
    }
    AppMethodBeat.o(209972);
  }
  
  final void aS(float paramFloat)
  {
    AppMethodBeat.i(209983);
    if (this.dtM != paramFloat)
    {
      this.dtM = paramFloat;
      o(this.bmA, this.dtL, this.dtM);
    }
    AppMethodBeat.o(209983);
  }
  
  final void aT(float paramFloat)
  {
    AppMethodBeat.i(210003);
    this.dtN = paramFloat;
    Matrix localMatrix = this.dtZ;
    a(paramFloat, localMatrix);
    this.dtV.setImageMatrix(localMatrix);
    AppMethodBeat.o(210003);
  }
  
  final void g(float paramFloat)
  {
    AppMethodBeat.i(209954);
    if (this.bmA != paramFloat)
    {
      this.bmA = paramFloat;
      o(this.bmA, this.dtL, this.dtM);
    }
    AppMethodBeat.o(209954);
  }
  
  void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(210013);
    if (this.dtG != null)
    {
      this.dtG.p(paramFloat1, this.dtM + paramFloat1);
      Wy();
    }
    AppMethodBeat.o(210013);
  }
  
  void q(Rect paramRect)
  {
    AppMethodBeat.i(210072);
    this.dtG.getPadding(paramRect);
    AppMethodBeat.o(210072);
  }
  
  void r(Rect paramRect) {}
  
  void s(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(210022);
    com.google.android.material.internal.i locali = this.dtF;
    int j = locali.dvW.size();
    int i = 0;
    i.a locala;
    if (i < j)
    {
      locala = (i.a)locali.dvW.get(i);
      if (!StateSet.stateSetMatches(locala.dwb, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = locala;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != locali.dvX)
      {
        if ((locali.dvX != null) && (locali.dvY != null))
        {
          locali.dvY.cancel();
          locali.dvY = null;
        }
        locali.dvX = paramArrayOfInt;
        if (paramArrayOfInt != null)
        {
          locali.dvY = paramArrayOfInt.animator;
          locali.dvY.start();
        }
      }
      AppMethodBeat.o(210022);
      return;
      i += 1;
      break;
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209941);
    if (this.dtI != null) {
      androidx.core.graphics.drawable.a.a(this.dtI, com.google.android.material.f.a.g(paramColorStateList));
    }
    AppMethodBeat.o(209941);
  }
  
  float za()
  {
    return this.bmA;
  }
  
  final class a
    extends a.f
  {
    a()
    {
      super((byte)0);
    }
    
    protected final float WF()
    {
      return 0.0F;
    }
  }
  
  final class b
    extends a.f
  {
    b()
    {
      super((byte)0);
    }
    
    protected final float WF()
    {
      return a.this.bmA + a.this.dtL;
    }
  }
  
  final class c
    extends a.f
  {
    c()
    {
      super((byte)0);
    }
    
    protected final float WF()
    {
      return a.this.bmA + a.this.dtM;
    }
  }
  
  static abstract interface d {}
  
  final class e
    extends a.f
  {
    e()
    {
      super((byte)0);
    }
    
    protected final float WF()
    {
      return a.this.bmA;
    }
  }
  
  abstract class f
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private boolean due;
    private float duf;
    private float dug;
    
    private f() {}
    
    protected abstract float WF();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      a.this.dtG.aZ(this.dug);
      this.due = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.due)
      {
        this.duf = a.this.dtG.dwO;
        this.dug = WF();
        this.due = true;
      }
      a.this.dtG.aZ(this.duf + (this.dug - this.duf) * paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.a
 * JD-Core Version:    0.7.0.1
 */