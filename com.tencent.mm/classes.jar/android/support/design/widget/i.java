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
  private InsetDrawable rR;
  
  i(VisibilityAwareImageButton paramVisibilityAwareImageButton, m paramm)
  {
    super(paramVisibilityAwareImageButton, paramm);
  }
  
  private Animator d(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.rH, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.rH, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(rn);
    return localAnimatorSet;
  }
  
  final void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.rv = android.support.v4.graphics.drawable.a.i(cG());
    android.support.v4.graphics.drawable.a.a(this.rv, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.graphics.drawable.a.a(this.rv, paramMode);
    }
    if (paramInt > 0) {
      this.rx = a(paramInt, paramColorStateList1);
    }
    for (paramColorStateList1 = new LayerDrawable(new Drawable[] { this.rx, this.rv });; paramColorStateList1 = this.rv)
    {
      this.rw = new RippleDrawable(android.support.design.e.a.b(paramColorStateList2), paramColorStateList1, null);
      this.ry = this.rw;
      this.rI.setBackgroundDrawable(this.rw);
      return;
      this.rx = null;
    }
  }
  
  final void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21) {
      this.rH.refreshDrawableState();
    }
    for (;;)
    {
      if (this.rI.cz()) {
        cD();
      }
      return;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, d(paramFloat1, paramFloat3));
      localStateListAnimator.addState(rE, d(paramFloat1, paramFloat2));
      localStateListAnimator.addState(rF, d(paramFloat1, paramFloat2));
      localStateListAnimator.addState(rG, d(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.rH, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.rH, View.TRANSLATION_Z, new float[] { this.rH.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.rH, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(rn);
      localStateListAnimator.addState(ENABLED_STATE_SET, localAnimatorSet);
      localStateListAnimator.addState(EMPTY_STATE_SET, d(0.0F, 0.0F));
      this.rH.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void cB() {}
  
  final void cC()
  {
    cD();
  }
  
  final boolean cE()
  {
    return false;
  }
  
  final b cF()
  {
    return new c();
  }
  
  final GradientDrawable cH()
  {
    return new a();
  }
  
  final void d(Rect paramRect)
  {
    if (this.rI.cz())
    {
      float f1 = this.rI.getRadius();
      float f2 = this.rH.getElevation() + this.rA;
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
      if (!this.rH.isEnabled()) {
        break label92;
      }
      this.rH.setElevation(this.elevation);
      if (this.rH.isPressed()) {
        this.rH.setTranslationZ(this.rA);
      }
    }
    else
    {
      return;
    }
    if ((this.rH.isFocused()) || (this.rH.isHovered()))
    {
      this.rH.setTranslationZ(this.rz);
      return;
    }
    this.rH.setTranslationZ(0.0F);
    return;
    label92:
    this.rH.setElevation(0.0F);
    this.rH.setTranslationZ(0.0F);
  }
  
  final void e(Rect paramRect)
  {
    if (this.rI.cz())
    {
      this.rR = new InsetDrawable(this.rw, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.rI.setBackgroundDrawable(this.rR);
      return;
    }
    this.rI.setBackgroundDrawable(this.rw);
  }
  
  public final float getElevation()
  {
    return this.rH.getElevation();
  }
  
  final void setRippleColor(ColorStateList paramColorStateList)
  {
    if ((this.rw instanceof RippleDrawable))
    {
      ((RippleDrawable)this.rw).setColor(android.support.design.e.a.b(paramColorStateList));
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