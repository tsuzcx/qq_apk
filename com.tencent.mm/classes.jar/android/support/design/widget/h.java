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
import android.support.v4.view.u;
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
  static final int[] rH;
  static final int[] rI;
  static final int[] rJ;
  static final TimeInterpolator rq = android.support.design.a.a.gM;
  float elevation;
  android.support.design.a.h iM;
  android.support.design.a.h iN;
  private final Rect mC = new Rect();
  private final RectF mD = new RectF();
  private final RectF mE = new RectF();
  b rA;
  Drawable rB;
  float rC;
  float rD;
  float rE = 1.0F;
  public ArrayList<Animator.AnimatorListener> rF;
  public ArrayList<Animator.AnimatorListener> rG;
  final VisibilityAwareImageButton rK;
  final m rL;
  private final Matrix rM = new Matrix();
  ViewTreeObserver.OnPreDrawListener rN;
  int rf;
  float rotation;
  int rs = 0;
  Animator rt;
  android.support.design.a.h ru;
  android.support.design.a.h rv;
  private final o rw;
  l rx;
  Drawable ry;
  Drawable rz;
  
  static
  {
    PRESSED_ENABLED_STATE_SET = new int[] { 16842919, 16842910 };
    rH = new int[] { 16843623, 16842908, 16842910 };
    rI = new int[] { 16842908, 16842910 };
    rJ = new int[] { 16843623, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  h(VisibilityAwareImageButton paramVisibilityAwareImageButton, m paramm)
  {
    this.rK = paramVisibilityAwareImageButton;
    this.rL = paramm;
    this.rw = new o();
    this.rw.a(PRESSED_ENABLED_STATE_SET, a(new c()));
    this.rw.a(rH, a(new b()));
    this.rw.a(rI, a(new b()));
    this.rw.a(rJ, a(new b()));
    this.rw.a(ENABLED_STATE_SET, a(new e()));
    this.rw.a(EMPTY_STATE_SET, a(new a()));
    this.rotation = this.rK.getRotation();
  }
  
  private static ValueAnimator a(f paramf)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(rq);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramf);
    localValueAnimator.addUpdateListener(paramf);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private void a(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.rK.getDrawable();
    if ((localDrawable != null) && (this.rf != 0))
    {
      RectF localRectF1 = this.mD;
      RectF localRectF2 = this.mE;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localRectF2.set(0.0F, 0.0F, this.rf, this.rf);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      paramMatrix.postScale(paramFloat, paramFloat, this.rf / 2.0F, this.rf / 2.0F);
    }
  }
  
  final AnimatorSet a(android.support.design.a.h paramh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.rK, View.ALPHA, new float[] { paramFloat1 });
    paramh.j("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.rK, View.SCALE_X, new float[] { paramFloat2 });
    paramh.j("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.rK, View.SCALE_Y, new float[] { paramFloat2 });
    paramh.j("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.rM);
    localObjectAnimator = ObjectAnimator.ofObject(this.rK, new f(), new g(), new Matrix[] { new Matrix(this.rM) });
    paramh.j("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramh = new AnimatorSet();
    android.support.design.a.b.a(paramh, localArrayList);
    return paramh;
  }
  
  final b a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.rK.getContext();
    b localb = cH();
    localb.b(android.support.v4.content.b.n(localContext, 2131100257), android.support.v4.content.b.n(localContext, 2131100256), android.support.v4.content.b.n(localContext, 2131100254), android.support.v4.content.b.n(localContext, 2131100255));
    localb.setBorderWidth(paramInt);
    localb.c(paramColorStateList);
    return localb;
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.ry = android.support.v4.graphics.drawable.a.i(cI());
    android.support.v4.graphics.drawable.a.a(this.ry, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.ry, paramMode);
    }
    this.rz = android.support.v4.graphics.drawable.a.i(cI());
    android.support.v4.graphics.drawable.a.a(this.rz, android.support.design.e.a.b(paramColorStateList2));
    if (paramInt > 0)
    {
      this.rA = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = this.rA;
      paramColorStateList1[1] = this.ry;
      paramColorStateList1[2] = this.rz;
    }
    for (;;)
    {
      this.rB = new LayerDrawable(paramColorStateList1);
      this.rx = new l(this.rK.getContext(), this.rB, this.rL.getRadius(), this.elevation, this.elevation + this.rD);
      paramColorStateList1 = this.rx;
      paramColorStateList1.tC = false;
      paramColorStateList1.invalidateSelf();
      this.rL.setBackgroundDrawable(this.rx);
      return;
      this.rA = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.ry;
      paramColorStateList1[1] = this.rz;
    }
  }
  
  void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.rx != null)
    {
      this.rx.f(paramFloat1, this.rD + paramFloat1);
      cF();
    }
  }
  
  final void cC()
  {
    r(this.rE);
  }
  
  void cD()
  {
    o localo = this.rw;
    if (localo.tQ != null)
    {
      localo.tQ.end();
      localo.tQ = null;
    }
  }
  
  void cE() {}
  
  final void cF()
  {
    Rect localRect = this.mC;
    d(localRect);
    e(localRect);
    this.rL.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean cG()
  {
    return true;
  }
  
  b cH()
  {
    return new b();
  }
  
  final GradientDrawable cI()
  {
    GradientDrawable localGradientDrawable = cJ();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  GradientDrawable cJ()
  {
    return new GradientDrawable();
  }
  
  public final boolean cK()
  {
    if (this.rK.getVisibility() != 0) {
      if (this.rs != 2) {}
    }
    while (this.rs != 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  final boolean cL()
  {
    return (u.az(this.rK)) && (!this.rK.isInEditMode());
  }
  
  void d(Rect paramRect)
  {
    this.rx.getPadding(paramRect);
  }
  
  void d(int[] paramArrayOfInt)
  {
    o localo = this.rw;
    int j = localo.tO.size();
    int i = 0;
    o.a locala;
    if (i < j)
    {
      locala = (o.a)localo.tO.get(i);
      if (!StateSet.stateSetMatches(locala.tT, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = locala;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != localo.tP)
      {
        if ((localo.tP != null) && (localo.tQ != null))
        {
          localo.tQ.cancel();
          localo.tQ = null;
        }
        localo.tP = paramArrayOfInt;
        if (paramArrayOfInt != null)
        {
          localo.tQ = paramArrayOfInt.animator;
          localo.tQ.start();
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
    if (this.rC != paramFloat)
    {
      this.rC = paramFloat;
      c(this.elevation, this.rC, this.rD);
    }
  }
  
  final void q(float paramFloat)
  {
    if (this.rD != paramFloat)
    {
      this.rD = paramFloat;
      c(this.elevation, this.rC, this.rD);
    }
  }
  
  final void r(float paramFloat)
  {
    this.rE = paramFloat;
    Matrix localMatrix = this.rM;
    a(paramFloat, localMatrix);
    this.rK.setImageMatrix(localMatrix);
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.elevation != paramFloat)
    {
      this.elevation = paramFloat;
      c(this.elevation, this.rC, this.rD);
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.rz != null) {
      android.support.v4.graphics.drawable.a.a(this.rz, android.support.design.e.a.b(paramColorStateList));
    }
  }
  
  final class a
    extends h.f
  {
    a()
    {
      super((byte)0);
    }
    
    protected final float cM()
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
    
    protected final float cM()
    {
      return h.this.elevation + h.this.rC;
    }
  }
  
  final class c
    extends h.f
  {
    c()
    {
      super((byte)0);
    }
    
    protected final float cM()
    {
      return h.this.elevation + h.this.rD;
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
    
    protected final float cM()
    {
      return h.this.elevation;
    }
  }
  
  abstract class f
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private boolean rR;
    private float rS;
    private float rT;
    
    private f() {}
    
    protected abstract float cM();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      h.this.rx.t(this.rT);
      this.rR = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.rR)
      {
        this.rS = h.this.rx.ty;
        this.rT = cM();
        this.rR = true;
      }
      h.this.rx.t(this.rS + (this.rT - this.rS) * paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.h
 * JD-Core Version:    0.7.0.1
 */