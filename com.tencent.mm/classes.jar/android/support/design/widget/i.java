package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class i
  extends h
{
  private InsetDrawable pX;
  
  i(VisibilityAwareImageButton paramVisibilityAwareImageButton, m paramm)
  {
    super(paramVisibilityAwareImageButton, paramm);
  }
  
  private Animator d(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.pN, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.pN, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(pu);
    return localAnimatorSet;
  }
  
  final void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.pB = android.support.v4.graphics.drawable.a.i(cq());
    android.support.v4.graphics.drawable.a.a(this.pB, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.pB, paramMode);
    }
    if (paramInt > 0) {
      this.pD = a(paramInt, paramColorStateList1);
    }
    for (paramColorStateList1 = new LayerDrawable(new Drawable[] { this.pD, this.pB });; paramColorStateList1 = this.pB)
    {
      this.pC = new RippleDrawable(android.support.design.e.a.b(paramColorStateList2), paramColorStateList1, null);
      this.pE = this.pC;
      this.pO.setBackgroundDrawable(this.pC);
      return;
      this.pD = null;
    }
  }
  
  final void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21) {
      this.pN.refreshDrawableState();
    }
    for (;;)
    {
      if (this.pO.cj()) {
        cn();
      }
      return;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, d(paramFloat1, paramFloat3));
      localStateListAnimator.addState(pK, d(paramFloat1, paramFloat2));
      localStateListAnimator.addState(pL, d(paramFloat1, paramFloat2));
      localStateListAnimator.addState(pM, d(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.pN, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.pN, View.TRANSLATION_Z, new float[] { this.pN.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.pN, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(pu);
      localStateListAnimator.addState(ENABLED_STATE_SET, localAnimatorSet);
      localStateListAnimator.addState(EMPTY_STATE_SET, d(0.0F, 0.0F));
      this.pN.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void cl() {}
  
  final void cm()
  {
    cn();
  }
  
  final boolean co()
  {
    return false;
  }
  
  final b cp()
  {
    return new c();
  }
  
  final GradientDrawable cr()
  {
    return new a();
  }
  
  final void d(Rect paramRect)
  {
    if (this.pO.cj())
    {
      float f1 = this.pO.getRadius();
      float f2 = this.pN.getElevation() + this.pG;
      int i = (int)Math.ceil(l.b(f2, f1, false));
      int j = (int)Math.ceil(l.a(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  final void d(int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      if (!this.pN.isEnabled()) {
        break label92;
      }
      this.pN.setElevation(this.elevation);
      if (this.pN.isPressed()) {
        this.pN.setTranslationZ(this.pG);
      }
    }
    else
    {
      return;
    }
    if ((this.pN.isFocused()) || (this.pN.isHovered()))
    {
      this.pN.setTranslationZ(this.pF);
      return;
    }
    this.pN.setTranslationZ(0.0F);
    return;
    label92:
    this.pN.setElevation(0.0F);
    this.pN.setTranslationZ(0.0F);
  }
  
  final void e(Rect paramRect)
  {
    if (this.pO.cj())
    {
      this.pX = new InsetDrawable(this.pC, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.pO.setBackgroundDrawable(this.pX);
      return;
    }
    this.pO.setBackgroundDrawable(this.pC);
  }
  
  public final float getElevation()
  {
    return this.pN.getElevation();
  }
  
  final void setRippleColor(ColorStateList paramColorStateList)
  {
    if ((this.pC instanceof RippleDrawable))
    {
      ((RippleDrawable)this.pC).setColor(android.support.design.e.a.b(paramColorStateList));
      return;
    }
    super.setRippleColor(paramColorStateList);
  }
  
  static final class a
    extends GradientDrawable
  {
    public final boolean isStateful()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.i
 * JD-Core Version:    0.7.0.1
 */