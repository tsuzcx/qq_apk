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
import android.support.v4.graphics.drawable.a;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class i
  extends h
{
  private InsetDrawable jP;
  
  i(VisibilityAwareImageButton paramVisibilityAwareImageButton, k paramk)
  {
    super(paramVisibilityAwareImageButton, paramk);
  }
  
  final void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.jz = a.e(bx());
    a.a(this.jz, paramColorStateList);
    if (paramMode != null) {
      a.a(this.jz, paramMode);
    }
    if (paramInt2 > 0) {
      this.jB = a(paramInt2, paramColorStateList);
    }
    for (paramColorStateList = new LayerDrawable(new Drawable[] { this.jB, this.jz });; paramColorStateList = this.jz)
    {
      this.jA = new RippleDrawable(ColorStateList.valueOf(paramInt1), paramColorStateList, null);
      this.jC = this.jA;
      this.jH.setBackgroundDrawable(this.jA);
      return;
      this.jB = null;
    }
  }
  
  final void bs() {}
  
  final void bt()
  {
    bu();
  }
  
  final boolean bv()
  {
    return false;
  }
  
  final d bw()
  {
    return new e();
  }
  
  final GradientDrawable by()
  {
    return new i.a();
  }
  
  final void c(int[] paramArrayOfInt) {}
  
  final void d(Rect paramRect)
  {
    if (this.jH.br())
    {
      float f1 = this.jH.getRadius();
      float f2 = this.jG.getElevation() + this.jE;
      int i = (int)Math.ceil(j.d(f2, f1, false));
      int j = (int)Math.ceil(j.c(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  final void e(Rect paramRect)
  {
    if (this.jH.br())
    {
      this.jP = new InsetDrawable(this.jA, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.jH.setBackgroundDrawable(this.jP);
      return;
    }
    this.jH.setBackgroundDrawable(this.jA);
  }
  
  public final float getElevation()
  {
    return this.jG.getElevation();
  }
  
  final void o(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT == 21) {
      if (this.jG.isEnabled())
      {
        this.jG.setElevation(paramFloat1);
        if ((this.jG.isFocused()) || (this.jG.isPressed())) {
          this.jG.setTranslationZ(paramFloat2);
        }
      }
    }
    for (;;)
    {
      if (this.jH.br()) {
        bu();
      }
      return;
      this.jG.setTranslationZ(0.0F);
      continue;
      this.jG.setElevation(0.0F);
      this.jG.setTranslationZ(0.0F);
      continue;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(ObjectAnimator.ofFloat(this.jG, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.jG, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
      localAnimatorSet.setInterpolator(jv);
      localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, localAnimatorSet);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(ObjectAnimator.ofFloat(this.jG, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.jG, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
      localAnimatorSet.setInterpolator(jv);
      localStateListAnimator.addState(jF, localAnimatorSet);
      localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.jG, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.jG, View.TRANSLATION_Z, new float[] { this.jG.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.jG, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new ObjectAnimator[0]));
      localAnimatorSet.setInterpolator(jv);
      localStateListAnimator.addState(ENABLED_STATE_SET, localAnimatorSet);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(ObjectAnimator.ofFloat(this.jG, "elevation", new float[] { 0.0F }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.jG, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(0L));
      localAnimatorSet.setInterpolator(jv);
      localStateListAnimator.addState(EMPTY_STATE_SET, localAnimatorSet);
      this.jG.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void setRippleColor(int paramInt)
  {
    if ((this.jA instanceof RippleDrawable))
    {
      ((RippleDrawable)this.jA).setColor(ColorStateList.valueOf(paramInt));
      return;
    }
    super.setRippleColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.i
 * JD-Core Version:    0.7.0.1
 */