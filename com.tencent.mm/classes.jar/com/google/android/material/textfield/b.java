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
import androidx.core.g.z;
import androidx.core.widget.j;
import androidx.legacy.widget.Space;
import com.google.android.material.a.d;
import com.google.android.material.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class b
{
  Typeface bbO;
  final Context context;
  final TextInputLayout dza;
  private LinearLayout dzb;
  private int dzc;
  private FrameLayout dzd;
  private int dze;
  Animator dzf;
  private final float dzg;
  int dzh;
  int dzi;
  CharSequence dzj;
  boolean dzk;
  TextView dzl;
  CharSequence dzm;
  boolean dzn;
  TextView dzo;
  int errorTextAppearance;
  int helperTextTextAppearance;
  
  public b(TextInputLayout paramTextInputLayout)
  {
    AppMethodBeat.i(209710);
    this.context = paramTextInputLayout.getContext();
    this.dza = paramTextInputLayout;
    this.dzg = this.context.getResources().getDimensionPixelSize(a.d.design_textinput_caption_translate_y);
    AppMethodBeat.o(209710);
  }
  
  private static ObjectAnimator a(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(209754);
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
      paramTextView.setDuration(167L);
      paramTextView.setInterpolator(a.dnq);
      AppMethodBeat.o(209754);
      return paramTextView;
    }
  }
  
  static void a(TextView paramTextView, Typeface paramTypeface)
  {
    AppMethodBeat.i(209800);
    if (paramTextView != null) {
      paramTextView.setTypeface(paramTypeface);
    }
    AppMethodBeat.o(209800);
  }
  
  private void a(List<Animator> paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209741);
    if ((paramTextView == null) || (!paramBoolean))
    {
      AppMethodBeat.o(209741);
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
        paramList.add(g(paramTextView));
      }
      AppMethodBeat.o(209741);
      return;
    }
  }
  
  private void cB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209720);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(209720);
      return;
    }
    TextView localTextView;
    if (paramInt2 != 0)
    {
      localTextView = jy(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = jy(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.dzh = paramInt2;
    AppMethodBeat.o(209720);
  }
  
  private static void d(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(209788);
    if (paramInt == 0) {
      paramViewGroup.setVisibility(8);
    }
    AppMethodBeat.o(209788);
  }
  
  private ObjectAnimator g(TextView paramTextView)
  {
    AppMethodBeat.i(209763);
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.dzg, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(a.dnt);
    AppMethodBeat.o(209763);
    return paramTextView;
  }
  
  private static boolean jx(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  private TextView jy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.dzl;
    }
    return this.dzo;
  }
  
  final void Xh()
  {
    AppMethodBeat.i(209809);
    this.dzj = null;
    Xi();
    if (this.dzh == 1) {
      if ((!this.dzn) || (TextUtils.isEmpty(this.dzm))) {
        break label71;
      }
    }
    label71:
    for (this.dzi = 2;; this.dzi = 0)
    {
      i(this.dzh, this.dzi, b(this.dzl, null));
      AppMethodBeat.o(209809);
      return;
    }
  }
  
  final void Xi()
  {
    AppMethodBeat.i(209832);
    if (this.dzf != null) {
      this.dzf.cancel();
    }
    AppMethodBeat.o(209832);
  }
  
  final void Xj()
  {
    AppMethodBeat.i(209842);
    if ((this.dzb != null) && (this.dza.getEditText() != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        z.g(this.dzb, z.X(this.dza.getEditText()), 0, z.Y(this.dza.getEditText()), 0);
      }
      AppMethodBeat.o(209842);
      return;
    }
  }
  
  final boolean Xk()
  {
    AppMethodBeat.i(209863);
    if ((this.dzi == 1) && (this.dzl != null) && (!TextUtils.isEmpty(this.dzj)))
    {
      AppMethodBeat.o(209863);
      return true;
    }
    AppMethodBeat.o(209863);
    return false;
  }
  
  final int Xl()
  {
    AppMethodBeat.i(209869);
    if (this.dzl != null)
    {
      int i = this.dzl.getCurrentTextColor();
      AppMethodBeat.o(209869);
      return i;
    }
    AppMethodBeat.o(209869);
    return -1;
  }
  
  final ColorStateList Xm()
  {
    AppMethodBeat.i(209875);
    if (this.dzl != null)
    {
      ColorStateList localColorStateList = this.dzl.getTextColors();
      AppMethodBeat.o(209875);
      return localColorStateList;
    }
    AppMethodBeat.o(209875);
    return null;
  }
  
  final boolean b(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209817);
    if ((z.au(this.dza)) && (this.dza.isEnabled()) && ((this.dzi != this.dzh) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence))))
    {
      AppMethodBeat.o(209817);
      return true;
    }
    AppMethodBeat.o(209817);
    return false;
  }
  
  final void f(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(209849);
    if ((this.dzb == null) && (this.dzd == null))
    {
      this.dzb = new LinearLayout(this.context);
      this.dzb.setOrientation(0);
      this.dza.addView(this.dzb, -1, -2);
      this.dzd = new FrameLayout(this.context);
      this.dzb.addView(this.dzd, -1, new FrameLayout.LayoutParams(-2, -2));
      Space localSpace = new Space(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.dzb.addView(localSpace, localLayoutParams);
      if (this.dza.getEditText() != null) {
        Xj();
      }
    }
    if (jx(paramInt))
    {
      this.dzd.setVisibility(0);
      this.dzd.addView(paramTextView);
      this.dze += 1;
    }
    for (;;)
    {
      this.dzb.setVisibility(0);
      this.dzc += 1;
      AppMethodBeat.o(209849);
      return;
      this.dzb.addView(paramTextView, paramInt);
    }
  }
  
  final void g(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(209857);
    if (this.dzb == null)
    {
      AppMethodBeat.o(209857);
      return;
    }
    if ((jx(paramInt)) && (this.dzd != null))
    {
      this.dze -= 1;
      d(this.dzd, this.dze);
      this.dzd.removeView(paramTextView);
    }
    for (;;)
    {
      this.dzc -= 1;
      d(this.dzb, this.dzc);
      AppMethodBeat.o(209857);
      return;
      this.dzb.removeView(paramTextView);
    }
  }
  
  final void i(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(209828);
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.dzf = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.dzn, this.dzo, 2, paramInt1, paramInt2);
      a(localArrayList, this.dzk, this.dzl, 1, paramInt1, paramInt2);
      com.google.android.material.a.b.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(209732);
          b.this.dzh = paramInt2;
          b.this.dzf = null;
          if (this.dzq != null)
          {
            this.dzq.setVisibility(4);
            if ((paramInt1 == 1) && (b.this.dzl != null)) {
              b.this.dzl.setText(null);
            }
          }
          AppMethodBeat.o(209732);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(209744);
          if (this.dzs != null) {
            this.dzs.setVisibility(0);
          }
          AppMethodBeat.o(209744);
        }
      });
      localAnimatorSet.start();
    }
    for (;;)
    {
      this.dza.Xw();
      this.dza.k(paramBoolean, false);
      this.dza.XF();
      AppMethodBeat.o(209828);
      return;
      cB(paramInt1, paramInt2);
    }
  }
  
  final void jz(int paramInt)
  {
    AppMethodBeat.i(209885);
    this.helperTextTextAppearance = paramInt;
    if (this.dzo != null) {
      j.a(this.dzo, paramInt);
    }
    AppMethodBeat.o(209885);
  }
  
  final void setErrorTextAppearance(int paramInt)
  {
    AppMethodBeat.i(209881);
    this.errorTextAppearance = paramInt;
    if (this.dzl != null) {
      this.dza.h(this.dzl, paramInt);
    }
    AppMethodBeat.o(209881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.textfield.b
 * JD-Core Version:    0.7.0.1
 */