package android.support.design.widget;

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
import android.support.design.a.f;
import android.support.design.a.g;
import android.support.design.a.i;
import android.support.v4.view.t;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;

public class h
{
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] ENABLED_STATE_SET;
  static final int[] PRESSED_ENABLED_STATE_SET;
  static final int[] pK;
  static final int[] pL;
  static final int[] pM;
  static final TimeInterpolator pu = android.support.design.a.a.eR;
  float elevation;
  android.support.design.a.h gP;
  android.support.design.a.h gQ;
  private final Rect kK = new Rect();
  private final RectF kL = new RectF();
  private final RectF kM = new RectF();
  l pA;
  Drawable pB;
  Drawable pC;
  b pD;
  Drawable pE;
  float pF;
  float pG;
  float pH = 1.0F;
  public ArrayList<Animator.AnimatorListener> pI;
  public ArrayList<Animator.AnimatorListener> pJ;
  final VisibilityAwareImageButton pN;
  final m pO;
  private final Matrix pP = new Matrix();
  ViewTreeObserver.OnPreDrawListener pQ;
  int pj;
  int pv = 0;
  Animator pw;
  android.support.design.a.h px;
  android.support.design.a.h py;
  private final o pz;
  float rotation;
  
  static
  {
    PRESSED_ENABLED_STATE_SET = new int[] { 16842919, 16842910 };
    pK = new int[] { 16843623, 16842908, 16842910 };
    pL = new int[] { 16842908, 16842910 };
    pM = new int[] { 16843623, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  h(VisibilityAwareImageButton paramVisibilityAwareImageButton, m paramm)
  {
    this.pN = paramVisibilityAwareImageButton;
    this.pO = paramm;
    this.pz = new o();
    this.pz.a(PRESSED_ENABLED_STATE_SET, a(new c()));
    this.pz.a(pK, a(new b()));
    this.pz.a(pL, a(new b()));
    this.pz.a(pM, a(new b()));
    this.pz.a(ENABLED_STATE_SET, a(new e()));
    this.pz.a(EMPTY_STATE_SET, a(new a()));
    this.rotation = this.pN.getRotation();
  }
  
  private static ValueAnimator a(f paramf)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(pu);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramf);
    localValueAnimator.addUpdateListener(paramf);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private void a(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.pN.getDrawable();
    if ((localDrawable != null) && (this.pj != 0))
    {
      RectF localRectF1 = this.kL;
      RectF localRectF2 = this.kM;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localRectF2.set(0.0F, 0.0F, this.pj, this.pj);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      paramMatrix.postScale(paramFloat, paramFloat, this.pj / 2.0F, this.pj / 2.0F);
    }
  }
  
  final AnimatorSet a(android.support.design.a.h paramh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.pN, View.ALPHA, new float[] { paramFloat1 });
    paramh.k("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.pN, View.SCALE_X, new float[] { paramFloat2 });
    paramh.k("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.pN, View.SCALE_Y, new float[] { paramFloat2 });
    paramh.k("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.pP);
    localObjectAnimator = ObjectAnimator.ofObject(this.pN, new f(), new g(), new Matrix[] { new Matrix(this.pP) });
    paramh.k("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramh = new AnimatorSet();
    android.support.design.a.b.a(paramh, localArrayList);
    return paramh;
  }
  
  final b a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.pN.getContext();
    b localb = cp();
    localb.b(android.support.v4.content.b.n(localContext, 2131100223), android.support.v4.content.b.n(localContext, 2131100222), android.support.v4.content.b.n(localContext, 2131100220), android.support.v4.content.b.n(localContext, 2131100221));
    localb.setBorderWidth(paramInt);
    localb.c(paramColorStateList);
    return localb;
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.pB = android.support.v4.graphics.drawable.a.i(cq());
    android.support.v4.graphics.drawable.a.a(this.pB, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.pB, paramMode);
    }
    this.pC = android.support.v4.graphics.drawable.a.i(cq());
    android.support.v4.graphics.drawable.a.a(this.pC, android.support.design.e.a.b(paramColorStateList2));
    if (paramInt > 0)
    {
      this.pD = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = this.pD;
      paramColorStateList1[1] = this.pB;
      paramColorStateList1[2] = this.pC;
    }
    for (;;)
    {
      this.pE = new LayerDrawable(paramColorStateList1);
      this.pA = new l(this.pN.getContext(), this.pE, this.pO.getRadius(), this.elevation, this.elevation + this.pG);
      paramColorStateList1 = this.pA;
      paramColorStateList1.rB = false;
      paramColorStateList1.invalidateSelf();
      this.pO.setBackgroundDrawable(this.pA);
      return;
      this.pD = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.pB;
      paramColorStateList1[1] = this.pC;
    }
  }
  
  void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.pA != null)
    {
      this.pA.f(paramFloat1, this.pG + paramFloat1);
      cn();
    }
  }
  
  final void ck()
  {
    t(this.pH);
  }
  
  void cl()
  {
    o localo = this.pz;
    if (localo.rP != null)
    {
      localo.rP.end();
      localo.rP = null;
    }
  }
  
  void cm() {}
  
  final void cn()
  {
    Rect localRect = this.kK;
    d(localRect);
    e(localRect);
    this.pO.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean co()
  {
    return true;
  }
  
  b cp()
  {
    return new b();
  }
  
  final GradientDrawable cq()
  {
    GradientDrawable localGradientDrawable = cr();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  GradientDrawable cr()
  {
    return new GradientDrawable();
  }
  
  public final boolean cs()
  {
    if (this.pN.getVisibility() != 0) {
      if (this.pv != 2) {}
    }
    while (this.pv != 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  final boolean ct()
  {
    return (t.ay(this.pN)) && (!this.pN.isInEditMode());
  }
  
  void d(Rect paramRect)
  {
    this.pA.getPadding(paramRect);
  }
  
  void d(int[] paramArrayOfInt)
  {
    o localo = this.pz;
    int j = localo.rN.size();
    int i = 0;
    o.a locala;
    if (i < j)
    {
      locala = (o.a)localo.rN.get(i);
      if (!StateSet.stateSetMatches(locala.rS, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = locala;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != localo.rO)
      {
        if ((localo.rO != null) && (localo.rP != null))
        {
          localo.rP.cancel();
          localo.rP = null;
        }
        localo.rO = paramArrayOfInt;
        if (paramArrayOfInt != null)
        {
          localo.rP = paramArrayOfInt.rT;
          localo.rP.start();
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  void e(Rect paramRect) {}
  
  float getElevation()
  {
    return this.elevation;
  }
  
  final void r(float paramFloat)
  {
    if (this.pF != paramFloat)
    {
      this.pF = paramFloat;
      c(this.elevation, this.pF, this.pG);
    }
  }
  
  final void s(float paramFloat)
  {
    if (this.pG != paramFloat)
    {
      this.pG = paramFloat;
      c(this.elevation, this.pF, this.pG);
    }
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.elevation != paramFloat)
    {
      this.elevation = paramFloat;
      c(this.elevation, this.pF, this.pG);
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.pC != null) {
      android.support.v4.graphics.drawable.a.a(this.pC, android.support.design.e.a.b(paramColorStateList));
    }
  }
  
  final void t(float paramFloat)
  {
    this.pH = paramFloat;
    Matrix localMatrix = this.pP;
    a(paramFloat, localMatrix);
    this.pN.setImageMatrix(localMatrix);
  }
  
  final class a
    extends h.f
  {
    a()
    {
      super((byte)0);
    }
    
    protected final float cu()
    {
      return 0.0F;
    }
  }
  
  final class b
    extends h.f
  {
    b()
    {
      super((byte)0);
    }
    
    protected final float cu()
    {
      return h.this.elevation + h.this.pF;
    }
  }
  
  final class c
    extends h.f
  {
    c()
    {
      super((byte)0);
    }
    
    protected final float cu()
    {
      return h.this.elevation + h.this.pG;
    }
  }
  
  static abstract interface d {}
  
  final class e
    extends h.f
  {
    e()
    {
      super((byte)0);
    }
    
    protected final float cu()
    {
      return h.this.elevation;
    }
  }
  
  abstract class f
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private boolean pU;
    private float pV;
    private float pW;
    
    private f() {}
    
    protected abstract float cu();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      h.this.pA.v(this.pW);
      this.pU = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.pU)
      {
        this.pV = h.this.pA.rx;
        this.pW = cu();
        this.pU = true;
      }
      h.this.pA.v(this.pV + (this.pW - this.pV) * paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.h
 * JD-Core Version:    0.7.0.1
 */