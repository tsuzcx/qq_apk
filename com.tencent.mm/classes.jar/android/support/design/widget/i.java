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
  private InsetDrawable oY;
  
  i(VisibilityAwareImageButton paramVisibilityAwareImageButton, m paramm)
  {
    super(paramVisibilityAwareImageButton, paramm);
  }
  
  private Animator d(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.oO, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.oO, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(ov);
    return localAnimatorSet;
  }
  
  final void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.oC = android.support.v4.graphics.drawable.a.i(cj());
    android.support.v4.graphics.drawable.a.a(this.oC, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.oC, paramMode);
    }
    if (paramInt > 0) {
      this.oE = a(paramInt, paramColorStateList1);
    }
    for (paramColorStateList1 = new LayerDrawable(new Drawable[] { this.oE, this.oC });; paramColorStateList1 = this.oC)
    {
      this.oD = new RippleDrawable(android.support.design.e.a.b(paramColorStateList2), paramColorStateList1, null);
      this.oF = this.oD;
      this.oP.setBackgroundDrawable(this.oD);
      return;
      this.oE = null;
    }
  }
  
  final void ce() {}
  
  final void cf()
  {
    cg();
  }
  
  final boolean ch()
  {
    return false;
  }
  
  final b ci()
  {
    return new c();
  }
  
  final GradientDrawable ck()
  {
    return new a();
  }
  
  final void d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21) {
      this.oO.refreshDrawableState();
    }
    for (;;)
    {
      if (this.oP.cc()) {
        cg();
      }
      return;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, d(paramFloat1, paramFloat3));
      localStateListAnimator.addState(oL, d(paramFloat1, paramFloat2));
      localStateListAnimator.addState(oM, d(paramFloat1, paramFloat2));
      localStateListAnimator.addState(oN, d(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.oO, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.oO, View.TRANSLATION_Z, new float[] { this.oO.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.oO, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(ov);
      localStateListAnimator.addState(ENABLED_STATE_SET, localAnimatorSet);
      localStateListAnimator.addState(EMPTY_STATE_SET, d(0.0F, 0.0F));
      this.oO.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void d(Rect paramRect)
  {
    if (this.oP.cc())
    {
      float f1 = this.oP.getRadius();
      float f2 = this.oO.getElevation() + this.oH;
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
      if (!this.oO.isEnabled()) {
        break label92;
      }
      this.oO.setElevation(this.elevation);
      if (this.oO.isPressed()) {
        this.oO.setTranslationZ(this.oH);
      }
    }
    else
    {
      return;
    }
    if ((this.oO.isFocused()) || (this.oO.isHovered()))
    {
      this.oO.setTranslationZ(this.oG);
      return;
    }
    this.oO.setTranslationZ(0.0F);
    return;
    label92:
    this.oO.setElevation(0.0F);
    this.oO.setTranslationZ(0.0F);
  }
  
  final void e(Rect paramRect)
  {
    if (this.oP.cc())
    {
      this.oY = new InsetDrawable(this.oD, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.oP.setBackgroundDrawable(this.oY);
      return;
    }
    this.oP.setBackgroundDrawable(this.oD);
  }
  
  public final float getElevation()
  {
    return this.oO.getElevation();
  }
  
  final void setRippleColor(ColorStateList paramColorStateList)
  {
    if ((this.oD instanceof RippleDrawable))
    {
      ((RippleDrawable)this.oD).setColor(android.support.design.e.a.b(paramColorStateList));
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