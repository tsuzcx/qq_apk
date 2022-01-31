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
import android.support.v4.a.a.a;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class i
  extends h
{
  private InsetDrawable iW;
  
  i(VisibilityAwareImageButton paramVisibilityAwareImageButton, k paramk)
  {
    super(paramVisibilityAwareImageButton, paramk);
  }
  
  final void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.iG = a.f(aO());
    a.a(this.iG, paramColorStateList);
    if (paramMode != null) {
      a.a(this.iG, paramMode);
    }
    if (paramInt2 > 0) {
      this.iI = a(paramInt2, paramColorStateList);
    }
    for (paramColorStateList = new LayerDrawable(new Drawable[] { this.iI, this.iG });; paramColorStateList = this.iG)
    {
      this.iH = new RippleDrawable(ColorStateList.valueOf(paramInt1), paramColorStateList, null);
      this.iJ = this.iH;
      this.iO.setBackgroundDrawable(this.iH);
      return;
      this.iI = null;
    }
  }
  
  final void aJ() {}
  
  final void aK()
  {
    aL();
  }
  
  final boolean aM()
  {
    return false;
  }
  
  final d aN()
  {
    return new e();
  }
  
  final GradientDrawable aP()
  {
    return new i.a();
  }
  
  final void c(int[] paramArrayOfInt) {}
  
  final void d(Rect paramRect)
  {
    if (this.iO.aI())
    {
      float f1 = this.iO.getRadius();
      float f2 = this.iN.getElevation() + this.iL;
      int i = (int)Math.ceil(j.d(f2, f1, false));
      int j = (int)Math.ceil(j.c(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  final void e(Rect paramRect)
  {
    if (this.iO.aI())
    {
      this.iW = new InsetDrawable(this.iH, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.iO.setBackgroundDrawable(this.iW);
      return;
    }
    this.iO.setBackgroundDrawable(this.iH);
  }
  
  public final float getElevation()
  {
    return this.iN.getElevation();
  }
  
  final void o(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT == 21) {
      if (this.iN.isEnabled())
      {
        this.iN.setElevation(paramFloat1);
        if ((this.iN.isFocused()) || (this.iN.isPressed())) {
          this.iN.setTranslationZ(paramFloat2);
        }
      }
    }
    for (;;)
    {
      if (this.iO.aI()) {
        aL();
      }
      return;
      this.iN.setTranslationZ(0.0F);
      continue;
      this.iN.setElevation(0.0F);
      this.iN.setTranslationZ(0.0F);
      continue;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(ObjectAnimator.ofFloat(this.iN, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.iN, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
      localAnimatorSet.setInterpolator(iC);
      localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, localAnimatorSet);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(ObjectAnimator.ofFloat(this.iN, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.iN, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
      localAnimatorSet.setInterpolator(iC);
      localStateListAnimator.addState(iM, localAnimatorSet);
      localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.iN, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.iN, View.TRANSLATION_Z, new float[] { this.iN.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.iN, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new ObjectAnimator[0]));
      localAnimatorSet.setInterpolator(iC);
      localStateListAnimator.addState(ENABLED_STATE_SET, localAnimatorSet);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(ObjectAnimator.ofFloat(this.iN, "elevation", new float[] { 0.0F }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.iN, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(0L));
      localAnimatorSet.setInterpolator(iC);
      localStateListAnimator.addState(EMPTY_STATE_SET, localAnimatorSet);
      this.iN.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void setRippleColor(int paramInt)
  {
    if ((this.iH instanceof RippleDrawable))
    {
      ((RippleDrawable)this.iH).setColor(ColorStateList.valueOf(paramInt));
      return;
    }
    super.setRippleColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.design.widget.i
 * JD-Core Version:    0.7.0.1
 */