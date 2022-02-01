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
  private InsetDrawable bBf;
  
  b(VisibilityAwareImageButton paramVisibilityAwareImageButton, com.google.android.material.g.b paramb)
  {
    super(paramVisibilityAwareImageButton, paramb);
  }
  
  private Animator q(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237503);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.bAT, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.bAT, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(bAy);
    AppMethodBeat.o(237503);
    return localAnimatorSet;
  }
  
  final void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    AppMethodBeat.i(237500);
    this.bAF = androidx.core.graphics.drawable.a.p(xd());
    androidx.core.graphics.drawable.a.a(this.bAF, paramColorStateList1);
    if (paramMode != null) {
      androidx.core.graphics.drawable.a.a(this.bAF, paramMode);
    }
    if (paramInt > 0) {
      this.bAH = a(paramInt, paramColorStateList1);
    }
    for (paramColorStateList1 = new LayerDrawable(new Drawable[] { this.bAH, this.bAF });; paramColorStateList1 = this.bAF)
    {
      this.bAG = new RippleDrawable(com.google.android.material.f.a.g(paramColorStateList2), paramColorStateList1, null);
      this.bAI = this.bAG;
      this.bAU.setBackgroundDrawable(this.bAG);
      AppMethodBeat.o(237500);
      return;
      this.bAH = null;
    }
  }
  
  final void k(Rect paramRect)
  {
    AppMethodBeat.i(237511);
    if (this.bAU.wV())
    {
      float f1 = this.bAU.getRadius();
      float f2 = this.bAT.getElevation() + this.bAK;
      int i = (int)Math.ceil(com.google.android.material.g.a.b(f2, f1, false));
      int j = (int)Math.ceil(com.google.android.material.g.a.a(f2, f1, false));
      paramRect.set(i, j, i, j);
      AppMethodBeat.o(237511);
      return;
    }
    paramRect.set(0, 0, 0, 0);
    AppMethodBeat.o(237511);
  }
  
  final void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(237502);
    if (Build.VERSION.SDK_INT == 21) {
      this.bAT.refreshDrawableState();
    }
    for (;;)
    {
      if (this.bAU.wV()) {
        xa();
      }
      AppMethodBeat.o(237502);
      return;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(bAO, q(paramFloat1, paramFloat3));
      localStateListAnimator.addState(bAP, q(paramFloat1, paramFloat2));
      localStateListAnimator.addState(bAQ, q(paramFloat1, paramFloat2));
      localStateListAnimator.addState(bAR, q(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.bAT, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.bAT, View.TRANSLATION_Z, new float[] { this.bAT.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.bAT, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(bAy);
      localStateListAnimator.addState(bAS, localAnimatorSet);
      localStateListAnimator.addState(ww, q(0.0F, 0.0F));
      this.bAT.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void l(Rect paramRect)
  {
    AppMethodBeat.i(237506);
    if (this.bAU.wV())
    {
      this.bBf = new InsetDrawable(this.bAG, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.bAU.setBackgroundDrawable(this.bBf);
      AppMethodBeat.o(237506);
      return;
    }
    this.bAU.setBackgroundDrawable(this.bAG);
    AppMethodBeat.o(237506);
  }
  
  final void p(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237507);
    if (Build.VERSION.SDK_INT == 21)
    {
      if (this.bAT.isEnabled())
      {
        this.bAT.setElevation(this.Gw);
        if (this.bAT.isPressed())
        {
          this.bAT.setTranslationZ(this.bAK);
          AppMethodBeat.o(237507);
          return;
        }
        if ((this.bAT.isFocused()) || (this.bAT.isHovered()))
        {
          this.bAT.setTranslationZ(this.bAJ);
          AppMethodBeat.o(237507);
          return;
        }
        this.bAT.setTranslationZ(0.0F);
        AppMethodBeat.o(237507);
        return;
      }
      this.bAT.setElevation(0.0F);
      this.bAT.setTranslationZ(0.0F);
    }
    AppMethodBeat.o(237507);
  }
  
  final void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237501);
    if ((this.bAG instanceof RippleDrawable))
    {
      ((RippleDrawable)this.bAG).setColor(com.google.android.material.f.a.g(paramColorStateList));
      AppMethodBeat.o(237501);
      return;
    }
    super.setRippleColor(paramColorStateList);
    AppMethodBeat.o(237501);
  }
  
  public final float wW()
  {
    AppMethodBeat.i(237504);
    float f = this.bAT.getElevation();
    AppMethodBeat.o(237504);
    return f;
  }
  
  final void wY() {}
  
  final void wZ()
  {
    AppMethodBeat.i(237505);
    xa();
    AppMethodBeat.o(237505);
  }
  
  final boolean xb()
  {
    return false;
  }
  
  final com.google.android.material.internal.a xc()
  {
    AppMethodBeat.i(237508);
    com.google.android.material.internal.b localb = new com.google.android.material.internal.b();
    AppMethodBeat.o(237508);
    return localb;
  }
  
  final GradientDrawable xe()
  {
    AppMethodBeat.i(237509);
    a locala = new a();
    AppMethodBeat.o(237509);
    return locala;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.b
 * JD-Core Version:    0.7.0.1
 */