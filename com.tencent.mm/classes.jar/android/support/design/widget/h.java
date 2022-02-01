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
  static final int[] rE;
  static final int[] rF;
  static final int[] rG;
  static final TimeInterpolator rn = android.support.design.a.a.gK;
  float elevation;
  android.support.design.a.h iK;
  android.support.design.a.h iL;
  private final Rect mA = new Rect();
  private final RectF mB = new RectF();
  private final RectF mC = new RectF();
  float rA;
  float rB = 1.0F;
  public ArrayList<Animator.AnimatorListener> rC;
  public ArrayList<Animator.AnimatorListener> rD;
  final VisibilityAwareImageButton rH;
  final m rI;
  private final Matrix rJ = new Matrix();
  ViewTreeObserver.OnPreDrawListener rK;
  int rc;
  int ro = 0;
  float rotation;
  Animator rp;
  android.support.design.a.h rq;
  android.support.design.a.h rs;
  private final o rt;
  l ru;
  Drawable rv;
  Drawable rw;
  b rx;
  Drawable ry;
  float rz;
  
  static
  {
    PRESSED_ENABLED_STATE_SET = new int[] { 16842919, 16842910 };
    rE = new int[] { 16843623, 16842908, 16842910 };
    rF = new int[] { 16842908, 16842910 };
    rG = new int[] { 16843623, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  h(VisibilityAwareImageButton paramVisibilityAwareImageButton, m paramm)
  {
    this.rH = paramVisibilityAwareImageButton;
    this.rI = paramm;
    this.rt = new o();
    this.rt.a(PRESSED_ENABLED_STATE_SET, a(new c()));
    this.rt.a(rE, a(new b()));
    this.rt.a(rF, a(new b()));
    this.rt.a(rG, a(new b()));
    this.rt.a(ENABLED_STATE_SET, a(new e()));
    this.rt.a(EMPTY_STATE_SET, a(new a()));
    this.rotation = this.rH.getRotation();
  }
  
  private static ValueAnimator a(f paramf)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(rn);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramf);
    localValueAnimator.addUpdateListener(paramf);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private void a(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.rH.getDrawable();
    if ((localDrawable != null) && (this.rc != 0))
    {
      RectF localRectF1 = this.mB;
      RectF localRectF2 = this.mC;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localRectF2.set(0.0F, 0.0F, this.rc, this.rc);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      paramMatrix.postScale(paramFloat, paramFloat, this.rc / 2.0F, this.rc / 2.0F);
    }
  }
  
  final AnimatorSet a(android.support.design.a.h paramh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.rH, View.ALPHA, new float[] { paramFloat1 });
    paramh.j("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.rH, View.SCALE_X, new float[] { paramFloat2 });
    paramh.j("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.rH, View.SCALE_Y, new float[] { paramFloat2 });
    paramh.j("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.rJ);
    localObjectAnimator = ObjectAnimator.ofObject(this.rH, new f(), new g(), new Matrix[] { new Matrix(this.rJ) });
    paramh.j("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramh = new AnimatorSet();
    android.support.design.a.b.a(paramh, localArrayList);
    return paramh;
  }
  
  final b a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.rH.getContext();
    b localb = cF();
    localb.b(android.support.v4.content.b.n(localContext, 2131100223), android.support.v4.content.b.n(localContext, 2131100222), android.support.v4.content.b.n(localContext, 2131100220), android.support.v4.content.b.n(localContext, 2131100221));
    localb.setBorderWidth(paramInt);
    localb.c(paramColorStateList);
    return localb;
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.rv = android.support.v4.graphics.drawable.a.i(cG());
    android.support.v4.graphics.drawable.a.a(this.rv, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.rv, paramMode);
    }
    this.rw = android.support.v4.graphics.drawable.a.i(cG());
    android.support.v4.graphics.drawable.a.a(this.rw, android.support.design.e.a.b(paramColorStateList2));
    if (paramInt > 0)
    {
      this.rx = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = this.rx;
      paramColorStateList1[1] = this.rv;
      paramColorStateList1[2] = this.rw;
    }
    for (;;)
    {
      this.ry = new LayerDrawable(paramColorStateList1);
      this.ru = new l(this.rH.getContext(), this.ry, this.rI.getRadius(), this.elevation, this.elevation + this.rA);
      paramColorStateList1 = this.ru;
      paramColorStateList1.tv = false;
      paramColorStateList1.invalidateSelf();
      this.rI.setBackgroundDrawable(this.ru);
      return;
      this.rx = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.rv;
      paramColorStateList1[1] = this.rw;
    }
  }
  
  void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.ru != null)
    {
      this.ru.f(paramFloat1, this.rA + paramFloat1);
      cD();
    }
  }
  
  final void cA()
  {
    r(this.rB);
  }
  
  void cB()
  {
    o localo = this.rt;
    if (localo.tJ != null)
    {
      localo.tJ.end();
      localo.tJ = null;
    }
  }
  
  void cC() {}
  
  final void cD()
  {
    Rect localRect = this.mA;
    d(localRect);
    e(localRect);
    this.rI.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean cE()
  {
    return true;
  }
  
  b cF()
  {
    return new b();
  }
  
  final GradientDrawable cG()
  {
    GradientDrawable localGradientDrawable = cH();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  GradientDrawable cH()
  {
    return new GradientDrawable();
  }
  
  public final boolean cI()
  {
    if (this.rH.getVisibility() != 0) {
      if (this.ro != 2) {}
    }
    while (this.ro != 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  final boolean cJ()
  {
    return (t.ay(this.rH)) && (!this.rH.isInEditMode());
  }
  
  void d(Rect paramRect)
  {
    this.ru.getPadding(paramRect);
  }
  
  void d(int[] paramArrayOfInt)
  {
    o localo = this.rt;
    int j = localo.tH.size();
    int i = 0;
    o.a locala;
    if (i < j)
    {
      locala = (o.a)localo.tH.get(i);
      if (!StateSet.stateSetMatches(locala.tM, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = locala;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != localo.tI)
      {
        if ((localo.tI != null) && (localo.tJ != null))
        {
          localo.tJ.cancel();
          localo.tJ = null;
        }
        localo.tI = paramArrayOfInt;
        if (paramArrayOfInt != null)
        {
          localo.tJ = paramArrayOfInt.animator;
          localo.tJ.start();
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
  
  final void p(float paramFloat)
  {
    if (this.rz != paramFloat)
    {
      this.rz = paramFloat;
      c(this.elevation, this.rz, this.rA);
    }
  }
  
  final void q(float paramFloat)
  {
    if (this.rA != paramFloat)
    {
      this.rA = paramFloat;
      c(this.elevation, this.rz, this.rA);
    }
  }
  
  final void r(float paramFloat)
  {
    this.rB = paramFloat;
    Matrix localMatrix = this.rJ;
    a(paramFloat, localMatrix);
    this.rH.setImageMatrix(localMatrix);
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.elevation != paramFloat)
    {
      this.elevation = paramFloat;
      c(this.elevation, this.rz, this.rA);
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.rw != null) {
      android.support.v4.graphics.drawable.a.a(this.rw, android.support.design.e.a.b(paramColorStateList));
    }
  }
  
  final class a
    extends h.f
  {
    a()
    {
      super((byte)0);
    }
    
    protected final float cK()
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
    
    protected final float cK()
    {
      return h.this.elevation + h.this.rz;
    }
  }
  
  final class c
    extends h.f
  {
    c()
    {
      super((byte)0);
    }
    
    protected final float cK()
    {
      return h.this.elevation + h.this.rA;
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
    
    protected final float cK()
    {
      return h.this.elevation;
    }
  }
  
  abstract class f
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private boolean rO;
    private float rP;
    private float rQ;
    
    private f() {}
    
    protected abstract float cK();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      h.this.ru.t(this.rQ);
      this.rO = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.rO)
      {
        this.rP = h.this.ru.tr;
        this.rQ = cK();
        this.rO = true;
      }
      h.this.ru.t(this.rP + (this.rQ - this.rP) * paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.h
 * JD-Core Version:    0.7.0.1
 */