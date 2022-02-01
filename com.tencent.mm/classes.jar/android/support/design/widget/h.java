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
  static final int[] oL;
  static final int[] oM;
  static final int[] oN;
  static final TimeInterpolator ov = android.support.design.a.a.dR;
  float elevation;
  android.support.design.a.h fQ;
  android.support.design.a.h fR;
  private final Rect jL = new Rect();
  private final RectF jM = new RectF();
  private final RectF jN = new RectF();
  private final o oA;
  l oB;
  Drawable oC;
  Drawable oD;
  b oE;
  Drawable oF;
  float oG;
  float oH;
  float oI = 1.0F;
  public ArrayList<Animator.AnimatorListener> oJ;
  public ArrayList<Animator.AnimatorListener> oK;
  final VisibilityAwareImageButton oO;
  final m oP;
  private final Matrix oQ = new Matrix();
  ViewTreeObserver.OnPreDrawListener oR;
  int oi;
  int ow = 0;
  Animator ox;
  android.support.design.a.h oy;
  android.support.design.a.h oz;
  float rotation;
  
  static
  {
    PRESSED_ENABLED_STATE_SET = new int[] { 16842919, 16842910 };
    oL = new int[] { 16843623, 16842908, 16842910 };
    oM = new int[] { 16842908, 16842910 };
    oN = new int[] { 16843623, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  h(VisibilityAwareImageButton paramVisibilityAwareImageButton, m paramm)
  {
    this.oO = paramVisibilityAwareImageButton;
    this.oP = paramm;
    this.oA = new o();
    this.oA.a(PRESSED_ENABLED_STATE_SET, a(new c()));
    this.oA.a(oL, a(new b()));
    this.oA.a(oM, a(new b()));
    this.oA.a(oN, a(new b()));
    this.oA.a(ENABLED_STATE_SET, a(new e()));
    this.oA.a(EMPTY_STATE_SET, a(new a()));
    this.rotation = this.oO.getRotation();
  }
  
  private static ValueAnimator a(f paramf)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(ov);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramf);
    localValueAnimator.addUpdateListener(paramf);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private void a(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.oO.getDrawable();
    if ((localDrawable != null) && (this.oi != 0))
    {
      RectF localRectF1 = this.jM;
      RectF localRectF2 = this.jN;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localRectF2.set(0.0F, 0.0F, this.oi, this.oi);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      paramMatrix.postScale(paramFloat, paramFloat, this.oi / 2.0F, this.oi / 2.0F);
    }
  }
  
  final AnimatorSet a(android.support.design.a.h paramh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.oO, View.ALPHA, new float[] { paramFloat1 });
    paramh.j("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.oO, View.SCALE_X, new float[] { paramFloat2 });
    paramh.j("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.oO, View.SCALE_Y, new float[] { paramFloat2 });
    paramh.j("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.oQ);
    localObjectAnimator = ObjectAnimator.ofObject(this.oO, new f(), new g(), new Matrix[] { new Matrix(this.oQ) });
    paramh.j("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramh = new AnimatorSet();
    android.support.design.a.b.a(paramh, localArrayList);
    return paramh;
  }
  
  final b a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.oO.getContext();
    b localb = ci();
    localb.b(android.support.v4.content.b.n(localContext, 2131100223), android.support.v4.content.b.n(localContext, 2131100222), android.support.v4.content.b.n(localContext, 2131100220), android.support.v4.content.b.n(localContext, 2131100221));
    localb.setBorderWidth(paramInt);
    localb.c(paramColorStateList);
    return localb;
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.oC = android.support.v4.graphics.drawable.a.i(cj());
    android.support.v4.graphics.drawable.a.a(this.oC, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.oC, paramMode);
    }
    this.oD = android.support.v4.graphics.drawable.a.i(cj());
    android.support.v4.graphics.drawable.a.a(this.oD, android.support.design.e.a.b(paramColorStateList2));
    if (paramInt > 0)
    {
      this.oE = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = this.oE;
      paramColorStateList1[1] = this.oC;
      paramColorStateList1[2] = this.oD;
    }
    for (;;)
    {
      this.oF = new LayerDrawable(paramColorStateList1);
      this.oB = new l(this.oO.getContext(), this.oF, this.oP.getRadius(), this.elevation, this.elevation + this.oH);
      paramColorStateList1 = this.oB;
      paramColorStateList1.qB = false;
      paramColorStateList1.invalidateSelf();
      this.oP.setBackgroundDrawable(this.oB);
      return;
      this.oE = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.oC;
      paramColorStateList1[1] = this.oD;
    }
  }
  
  final void cd()
  {
    p(this.oI);
  }
  
  void ce()
  {
    o localo = this.oA;
    if (localo.qP != null)
    {
      localo.qP.end();
      localo.qP = null;
    }
  }
  
  void cf() {}
  
  final void cg()
  {
    Rect localRect = this.jL;
    d(localRect);
    e(localRect);
    this.oP.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean ch()
  {
    return true;
  }
  
  b ci()
  {
    return new b();
  }
  
  final GradientDrawable cj()
  {
    GradientDrawable localGradientDrawable = ck();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  GradientDrawable ck()
  {
    return new GradientDrawable();
  }
  
  public final boolean cl()
  {
    if (this.oO.getVisibility() != 0) {
      if (this.ow != 2) {}
    }
    while (this.ow != 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  final boolean cm()
  {
    return (t.ay(this.oO)) && (!this.oO.isInEditMode());
  }
  
  void d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.oB != null)
    {
      this.oB.f(paramFloat1, this.oH + paramFloat1);
      cg();
    }
  }
  
  void d(Rect paramRect)
  {
    this.oB.getPadding(paramRect);
  }
  
  void d(int[] paramArrayOfInt)
  {
    o localo = this.oA;
    int j = localo.qN.size();
    int i = 0;
    o.a locala;
    if (i < j)
    {
      locala = (o.a)localo.qN.get(i);
      if (!StateSet.stateSetMatches(locala.qS, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = locala;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != localo.qO)
      {
        if ((localo.qO != null) && (localo.qP != null))
        {
          localo.qP.cancel();
          localo.qP = null;
        }
        localo.qO = paramArrayOfInt;
        if (paramArrayOfInt != null)
        {
          localo.qP = paramArrayOfInt.qT;
          localo.qP.start();
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
  
  final void n(float paramFloat)
  {
    if (this.oG != paramFloat)
    {
      this.oG = paramFloat;
      d(this.elevation, this.oG, this.oH);
    }
  }
  
  final void o(float paramFloat)
  {
    if (this.oH != paramFloat)
    {
      this.oH = paramFloat;
      d(this.elevation, this.oG, this.oH);
    }
  }
  
  final void p(float paramFloat)
  {
    this.oI = paramFloat;
    Matrix localMatrix = this.oQ;
    a(paramFloat, localMatrix);
    this.oO.setImageMatrix(localMatrix);
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.elevation != paramFloat)
    {
      this.elevation = paramFloat;
      d(this.elevation, this.oG, this.oH);
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.oD != null) {
      android.support.v4.graphics.drawable.a.a(this.oD, android.support.design.e.a.b(paramColorStateList));
    }
  }
  
  final class a
    extends h.f
  {
    a()
    {
      super((byte)0);
    }
    
    protected final float cn()
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
    
    protected final float cn()
    {
      return h.this.elevation + h.this.oG;
    }
  }
  
  final class c
    extends h.f
  {
    c()
    {
      super((byte)0);
    }
    
    protected final float cn()
    {
      return h.this.elevation + h.this.oH;
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
    
    protected final float cn()
    {
      return h.this.elevation;
    }
  }
  
  abstract class f
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private boolean oV;
    private float oW;
    private float oX;
    
    private f() {}
    
    protected abstract float cn();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      h.this.oB.r(this.oX);
      this.oV = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.oV)
      {
        this.oW = h.this.oB.qx;
        this.oX = cn();
        this.oV = true;
      }
      h.this.oB.r(this.oW + (this.oX - this.oW) * paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.h
 * JD-Core Version:    0.7.0.1
 */