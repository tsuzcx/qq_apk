package com.google.android.material.floatingactionbutton;

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
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class b
  extends a
{
  private InsetDrawable duh;
  
  b(VisibilityAwareImageButton paramVisibilityAwareImageButton, com.google.android.material.g.b paramb)
  {
    super(paramVisibilityAwareImageButton, paramb);
  }
  
  private Animator W(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(209871);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.dtV, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.dtV, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(dtA);
    AppMethodBeat.o(209871);
    return localAnimatorSet;
  }
  
  final com.google.android.material.internal.a WA()
  {
    AppMethodBeat.i(209971);
    com.google.android.material.internal.b localb = new com.google.android.material.internal.b();
    AppMethodBeat.o(209971);
    return localb;
  }
  
  final GradientDrawable WC()
  {
    AppMethodBeat.i(209982);
    a locala = new a();
    AppMethodBeat.o(209982);
    return locala;
  }
  
  final void Ww() {}
  
  final void Wx()
  {
    AppMethodBeat.i(209923);
    Wy();
    AppMethodBeat.o(209923);
  }
  
  final boolean Wz()
  {
    return false;
  }
  
  final void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    AppMethodBeat.i(209884);
    this.dtH = androidx.core.graphics.drawable.a.s(WB());
    androidx.core.graphics.drawable.a.a(this.dtH, paramColorStateList1);
    if (paramMode != null) {
      androidx.core.graphics.drawable.a.a(this.dtH, paramMode);
    }
    if (paramInt > 0) {
      this.dtJ = a(paramInt, paramColorStateList1);
    }
    for (paramColorStateList1 = new LayerDrawable(new Drawable[] { this.dtJ, this.dtH });; paramColorStateList1 = this.dtH)
    {
      this.dtI = new RippleDrawable(com.google.android.material.f.a.g(paramColorStateList2), paramColorStateList1, null);
      this.dtK = this.dtI;
      this.dtW.setBackgroundDrawable(this.dtI);
      AppMethodBeat.o(209884);
      return;
      this.dtJ = null;
    }
  }
  
  final void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(209905);
    if (Build.VERSION.SDK_INT == 21) {
      this.dtV.refreshDrawableState();
    }
    for (;;)
    {
      if (this.dtW.Wu()) {
        Wy();
      }
      AppMethodBeat.o(209905);
      return;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(dtQ, W(paramFloat1, paramFloat3));
      localStateListAnimator.addState(dtR, W(paramFloat1, paramFloat2));
      localStateListAnimator.addState(dtS, W(paramFloat1, paramFloat2));
      localStateListAnimator.addState(dtT, W(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.dtV, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.dtV, View.TRANSLATION_Z, new float[] { this.dtV.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.dtV, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(dtA);
      localStateListAnimator.addState(dtU, localAnimatorSet);
      localStateListAnimator.addState(xr, W(0.0F, 0.0F));
      this.dtV.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void q(Rect paramRect)
  {
    AppMethodBeat.i(209991);
    if (this.dtW.Wu())
    {
      float f1 = this.dtW.getRadius();
      float f2 = this.dtV.getElevation() + this.dtM;
      int i = (int)Math.ceil(com.google.android.material.g.a.e(f2, f1, false));
      int j = (int)Math.ceil(com.google.android.material.g.a.d(f2, f1, false));
      paramRect.set(i, j, i, j);
      AppMethodBeat.o(209991);
      return;
    }
    paramRect.set(0, 0, 0, 0);
    AppMethodBeat.o(209991);
  }
  
  final void r(Rect paramRect)
  {
    AppMethodBeat.i(209933);
    if (this.dtW.Wu())
    {
      this.duh = new InsetDrawable(this.dtI, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.dtW.setBackgroundDrawable(this.duh);
      AppMethodBeat.o(209933);
      return;
    }
    this.dtW.setBackgroundDrawable(this.dtI);
    AppMethodBeat.o(209933);
  }
  
  final void s(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209945);
    if (Build.VERSION.SDK_INT == 21)
    {
      if (this.dtV.isEnabled())
      {
        this.dtV.setElevation(this.bmA);
        if (this.dtV.isPressed())
        {
          this.dtV.setTranslationZ(this.dtM);
          AppMethodBeat.o(209945);
          return;
        }
        if ((this.dtV.isFocused()) || (this.dtV.isHovered()))
        {
          this.dtV.setTranslationZ(this.dtL);
          AppMethodBeat.o(209945);
          return;
        }
        this.dtV.setTranslationZ(0.0F);
        AppMethodBeat.o(209945);
        return;
      }
      this.dtV.setElevation(0.0F);
      this.dtV.setTranslationZ(0.0F);
    }
    AppMethodBeat.o(209945);
  }
  
  final void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209891);
    if ((this.dtI instanceof RippleDrawable))
    {
      ((RippleDrawable)this.dtI).setColor(com.google.android.material.f.a.g(paramColorStateList));
      AppMethodBeat.o(209891);
      return;
    }
    super.setRippleColor(paramColorStateList);
    AppMethodBeat.o(209891);
  }
  
  public final float za()
  {
    AppMethodBeat.i(209913);
    float f = this.dtV.getElevation();
    AppMethodBeat.o(209913);
    return f;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.b
 * JD-Core Version:    0.7.0.1
 */