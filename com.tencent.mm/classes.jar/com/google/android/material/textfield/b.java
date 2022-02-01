package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.g.w;
import androidx.core.widget.i;
import androidx.legacy.widget.Space;
import com.google.android.material.a.d;
import com.google.android.material.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class b
{
  final TextInputLayout bGa;
  private LinearLayout bGb;
  private int bGc;
  private FrameLayout bGd;
  private int bGe;
  Animator bGf;
  private final float bGg;
  int bGh;
  int bGi;
  CharSequence bGj;
  boolean bGk;
  TextView bGl;
  CharSequence bGm;
  boolean bGn;
  TextView bGo;
  Typeface bGp;
  final Context context;
  int errorTextAppearance;
  int helperTextTextAppearance;
  
  public b(TextInputLayout paramTextInputLayout)
  {
    AppMethodBeat.i(240142);
    this.context = paramTextInputLayout.getContext();
    this.bGa = paramTextInputLayout;
    this.bGg = this.context.getResources().getDimensionPixelSize(a.d.design_textinput_caption_translate_y);
    AppMethodBeat.o(240142);
  }
  
  private static ObjectAnimator a(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(240161);
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
      paramTextView.setDuration(167L);
      paramTextView.setInterpolator(a.bum);
      AppMethodBeat.o(240161);
      return paramTextView;
    }
  }
  
  static void a(TextView paramTextView, Typeface paramTypeface)
  {
    AppMethodBeat.i(240180);
    if (paramTextView != null) {
      paramTextView.setTypeface(paramTypeface);
    }
    AppMethodBeat.o(240180);
  }
  
  private void a(List<Animator> paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(240158);
    if ((paramTextView == null) || (!paramBoolean))
    {
      AppMethodBeat.o(240158);
      return;
    }
    if ((paramInt1 == paramInt3) || (paramInt1 == paramInt2)) {
      if (paramInt3 != paramInt1) {
        break label79;
      }
    }
    label79:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramList.add(a(paramTextView, paramBoolean));
      if (paramInt3 == paramInt1) {
        paramList.add(f(paramTextView));
      }
      AppMethodBeat.o(240158);
      return;
    }
  }
  
  private void bG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240154);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(240154);
      return;
    }
    TextView localTextView;
    if (paramInt2 != 0)
    {
      localTextView = gm(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = gm(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.bGh = paramInt2;
    AppMethodBeat.o(240154);
  }
  
  private static void d(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(240177);
    if (paramInt == 0) {
      paramViewGroup.setVisibility(8);
    }
    AppMethodBeat.o(240177);
  }
  
  private ObjectAnimator f(TextView paramTextView)
  {
    AppMethodBeat.i(240164);
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.bGg, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(a.bup);
    AppMethodBeat.o(240164);
    return paramTextView;
  }
  
  private static boolean gl(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  private TextView gm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.bGl;
    }
    return this.bGo;
  }
  
  final boolean b(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240148);
    if ((w.ah(this.bGa)) && (this.bGa.isEnabled()) && ((this.bGi != this.bGh) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence))))
    {
      AppMethodBeat.o(240148);
      return true;
    }
    AppMethodBeat.o(240148);
    return false;
  }
  
  final void e(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(240172);
    if ((this.bGb == null) && (this.bGd == null))
    {
      this.bGb = new LinearLayout(this.context);
      this.bGb.setOrientation(0);
      this.bGa.addView(this.bGb, -1, -2);
      this.bGd = new FrameLayout(this.context);
      this.bGb.addView(this.bGd, -1, new FrameLayout.LayoutParams(-2, -2));
      Space localSpace = new Space(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.bGb.addView(localSpace, localLayoutParams);
      if (this.bGa.getEditText() != null) {
        xM();
      }
    }
    if (gl(paramInt))
    {
      this.bGd.setVisibility(0);
      this.bGd.addView(paramTextView);
      this.bGe += 1;
    }
    for (;;)
    {
      this.bGb.setVisibility(0);
      this.bGc += 1;
      AppMethodBeat.o(240172);
      return;
      this.bGb.addView(paramTextView, paramInt);
    }
  }
  
  final void f(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(240174);
    if (this.bGb == null)
    {
      AppMethodBeat.o(240174);
      return;
    }
    if ((gl(paramInt)) && (this.bGd != null))
    {
      this.bGe -= 1;
      d(this.bGd, this.bGe);
      this.bGd.removeView(paramTextView);
    }
    for (;;)
    {
      this.bGc -= 1;
      d(this.bGb, this.bGc);
      AppMethodBeat.o(240174);
      return;
      this.bGb.removeView(paramTextView);
    }
  }
  
  final void g(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(240152);
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.bGf = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.bGn, this.bGo, 2, paramInt1, paramInt2);
      a(localArrayList, this.bGk, this.bGl, 1, paramInt1, paramInt2);
      com.google.android.material.a.b.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(240130);
          b.this.bGh = paramInt2;
          b.this.bGf = null;
          if (this.bGr != null)
          {
            this.bGr.setVisibility(4);
            if ((paramInt1 == 1) && (b.this.bGl != null)) {
              b.this.bGl.setText(null);
            }
          }
          AppMethodBeat.o(240130);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(240132);
          if (this.bGt != null) {
            this.bGt.setVisibility(0);
          }
          AppMethodBeat.o(240132);
        }
      });
      localAnimatorSet.start();
    }
    for (;;)
    {
      this.bGa.xZ();
      this.bGa.i(paramBoolean, false);
      this.bGa.yi();
      AppMethodBeat.o(240152);
      return;
      bG(paramInt1, paramInt2);
    }
  }
  
  final void gn(int paramInt)
  {
    AppMethodBeat.i(240190);
    this.helperTextTextAppearance = paramInt;
    if (this.bGo != null) {
      i.a(this.bGo, paramInt);
    }
    AppMethodBeat.o(240190);
  }
  
  final void setErrorTextAppearance(int paramInt)
  {
    AppMethodBeat.i(240188);
    this.errorTextAppearance = paramInt;
    if (this.bGl != null) {
      this.bGa.g(this.bGl, paramInt);
    }
    AppMethodBeat.o(240188);
  }
  
  final void xK()
  {
    AppMethodBeat.i(240144);
    this.bGj = null;
    xL();
    if (this.bGh == 1) {
      if ((!this.bGn) || (TextUtils.isEmpty(this.bGm))) {
        break label73;
      }
    }
    label73:
    for (this.bGi = 2;; this.bGi = 0)
    {
      g(this.bGh, this.bGi, b(this.bGl, null));
      AppMethodBeat.o(240144);
      return;
    }
  }
  
  final void xL()
  {
    AppMethodBeat.i(240165);
    if (this.bGf != null) {
      this.bGf.cancel();
    }
    AppMethodBeat.o(240165);
  }
  
  final void xM()
  {
    AppMethodBeat.i(240169);
    if ((this.bGb != null) && (this.bGa.getEditText() != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        w.g(this.bGb, w.L(this.bGa.getEditText()), 0, w.M(this.bGa.getEditText()), 0);
      }
      AppMethodBeat.o(240169);
      return;
    }
  }
  
  final boolean xN()
  {
    AppMethodBeat.i(240179);
    if ((this.bGi == 1) && (this.bGl != null) && (!TextUtils.isEmpty(this.bGj)))
    {
      AppMethodBeat.o(240179);
      return true;
    }
    AppMethodBeat.o(240179);
    return false;
  }
  
  final int xO()
  {
    AppMethodBeat.i(240182);
    if (this.bGl != null)
    {
      int i = this.bGl.getCurrentTextColor();
      AppMethodBeat.o(240182);
      return i;
    }
    AppMethodBeat.o(240182);
    return -1;
  }
  
  final ColorStateList xP()
  {
    AppMethodBeat.i(240184);
    if (this.bGl != null)
    {
      ColorStateList localColorStateList = this.bGl.getTextColors();
      AppMethodBeat.o(240184);
      return localColorStateList;
    }
    AppMethodBeat.o(240184);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.textfield.b
 * JD-Core Version:    0.7.0.1
 */