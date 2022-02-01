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
  private InsetDrawable rU;
  
  i(VisibilityAwareImageButton paramVisibilityAwareImageButton, m paramm)
  {
    super(paramVisibilityAwareImageButton, paramm);
  }
  
  private Animator d(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.rK, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.rK, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(rq);
    return localAnimatorSet;
  }
  
  final void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.ry = android.support.v4.graphics.drawable.a.i(cI());
    android.support.v4.graphics.drawable.a.a(this.ry, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.ry, paramMode);
    }
    if (paramInt > 0) {
      this.rA = a(paramInt, paramColorStateList1);
    }
    for (paramColorStateList1 = new LayerDrawable(new Drawable[] { this.rA, this.ry });; paramColorStateList1 = this.ry)
    {
      this.rz = new RippleDrawable(android.support.design.e.a.b(paramColorStateList2), paramColorStateList1, null);
      this.rB = this.rz;
      this.rL.setBackgroundDrawable(this.rz);
      return;
      this.rA = null;
    }
  }
  
  final void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21) {
      this.rK.refreshDrawableState();
    }
    for (;;)
    {
      if (this.rL.cB()) {
        cF();
      }
      return;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, d(paramFloat1, paramFloat3));
      localStateListAnimator.addState(rH, d(paramFloat1, paramFloat2));
      localStateListAnimator.addState(rI, d(paramFloat1, paramFloat2));
      localStateListAnimator.addState(rJ, d(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.rK, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.rK, View.TRANSLATION_Z, new float[] { this.rK.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.rK, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(rq);
      localStateListAnimator.addState(ENABLED_STATE_SET, localAnimatorSet);
      localStateListAnimator.addState(EMPTY_STATE_SET, d(0.0F, 0.0F));
      this.rK.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void cD() {}
  
  final void cE()
  {
    cF();
  }
  
  final boolean cG()
  {
    return false;
  }
  
  final b cH()
  {
    return new c();
  }
  
  final GradientDrawable cJ()
  {
    return new a();
  }
  
  final void d(Rect paramRect)
  {
    if (this.rL.cB())
    {
      float f1 = this.rL.getRadius();
      float f2 = this.rK.getElevation() + this.rD;
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
      if (!this.rK.isEnabled()) {
        break label92;
      }
      this.rK.setElevation(this.elevation);
      if (this.rK.isPressed()) {
        this.rK.setTranslationZ(this.rD);
      }
    }
    else
    {
      return;
    }
    if ((this.rK.isFocused()) || (this.rK.isHovered()))
    {
      this.rK.setTranslationZ(this.rC);
      return;
    }
    this.rK.setTranslationZ(0.0F);
    return;
    label92:
    this.rK.setElevation(0.0F);
    this.rK.setTranslationZ(0.0F);
  }
  
  final void e(Rect paramRect)
  {
    if (this.rL.cB())
    {
      this.rU = new InsetDrawable(this.rz, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.rL.setBackgroundDrawable(this.rU);
      return;
    }
    this.rL.setBackgroundDrawable(this.rz);
  }
  
  public final float getElevation()
  {
    return this.rK.getElevation();
  }
  
  final void setRippleColor(ColorStateList paramColorStateList)
  {
    if ((this.rz instanceof RippleDrawable))
    {
      ((RippleDrawable)this.rz).setColor(android.support.design.e.a.b(paramColorStateList));
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