package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.o;
import androidx.core.g.z;
import androidx.core.widget.j;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.b;
import com.google.android.material.a.c;
import com.google.android.material.a.d;
import com.google.android.material.a.f;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.c;
import com.google.android.material.internal.e;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class TextInputLayout
  extends LinearLayout
{
  private ValueAnimator animator;
  private Typeface bbO;
  private int boxBackgroundColor;
  private int boxBackgroundMode;
  private int boxStrokeColor;
  private int counterMaxLength;
  private final int counterOverflowTextAppearance;
  private final int counterTextAppearance;
  private PorterDuff.Mode dAa;
  private boolean dAb;
  private ColorStateList dAc;
  private ColorStateList dAd;
  private final int dAe;
  private final int dAf;
  private int dAg;
  private final int dAh;
  private boolean dAi;
  private boolean dAj;
  private boolean dAk;
  private boolean dAl;
  private boolean dAm;
  final c doq;
  private TextView dzA;
  private boolean dzB;
  private CharSequence dzC;
  boolean dzD;
  private GradientDrawable dzE;
  private final int dzF;
  private final int dzG;
  private final int dzH;
  private float dzI;
  private float dzJ;
  private float dzK;
  private float dzL;
  private int dzM;
  private final int dzN;
  private final int dzO;
  private Drawable dzP;
  private final RectF dzQ;
  private boolean dzR;
  private Drawable dzS;
  private CharSequence dzT;
  private CheckableImageButton dzU;
  private boolean dzV;
  private Drawable dzW;
  private Drawable dzX;
  private ColorStateList dzY;
  private boolean dzZ;
  private final FrameLayout dzu;
  EditText dzv;
  private CharSequence dzw;
  private final b dzx;
  boolean dzy;
  private boolean dzz;
  private final Rect tmpRect;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.textInputStyle);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209723);
    this.dzx = new b(this);
    this.tmpRect = new Rect();
    this.dzQ = new RectF();
    this.doq = new c(this);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.dzu = new FrameLayout(paramContext);
    this.dzu.setAddStatesFromChildren(true);
    addView(this.dzu);
    this.doq.c(com.google.android.material.a.a.dnq);
    Object localObject = this.doq;
    ((c)localObject).dvb = com.google.android.material.a.a.dnq;
    ((c)localObject).xQ();
    this.doq.jl(8388659);
    paramAttributeSet = k.b(paramContext, paramAttributeSet, a.k.TextInputLayout, paramInt, a.j.Widget_Design_TextInputLayout, new int[0]);
    this.dzB = paramAttributeSet.m(a.k.TextInputLayout_hintEnabled, true);
    setHint(paramAttributeSet.getText(a.k.TextInputLayout_android_hint));
    this.dAj = paramAttributeSet.m(a.k.TextInputLayout_hintAnimationEnabled, true);
    this.dzF = paramContext.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_bottom_offset);
    this.dzG = paramContext.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_label_cutout_padding);
    this.dzH = paramAttributeSet.t(a.k.TextInputLayout_boxCollapsedPaddingTop, 0);
    this.dzI = paramAttributeSet.ay(a.k.TextInputLayout_boxCornerRadiusTopStart);
    this.dzJ = paramAttributeSet.ay(a.k.TextInputLayout_boxCornerRadiusTopEnd);
    this.dzK = paramAttributeSet.ay(a.k.TextInputLayout_boxCornerRadiusBottomEnd);
    this.dzL = paramAttributeSet.ay(a.k.TextInputLayout_boxCornerRadiusBottomStart);
    this.boxBackgroundColor = paramAttributeSet.r(a.k.TextInputLayout_boxBackgroundColor, 0);
    this.dAg = paramAttributeSet.r(a.k.TextInputLayout_boxStrokeColor, 0);
    this.dzN = paramContext.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_default);
    this.dzO = paramContext.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_focused);
    this.dzM = this.dzN;
    setBoxBackgroundMode(paramAttributeSet.getInt(a.k.TextInputLayout_boxBackgroundMode, 0));
    if (paramAttributeSet.az(a.k.TextInputLayout_android_textColorHint))
    {
      localObject = paramAttributeSet.getColorStateList(a.k.TextInputLayout_android_textColorHint);
      this.dAd = ((ColorStateList)localObject);
      this.dAc = ((ColorStateList)localObject);
    }
    this.dAe = androidx.core.content.a.w(paramContext, a.c.mtrl_textinput_default_box_stroke_color);
    this.dAh = androidx.core.content.a.w(paramContext, a.c.mtrl_textinput_disabled_color);
    this.dAf = androidx.core.content.a.w(paramContext, a.c.mtrl_textinput_hovered_box_stroke_color);
    if (paramAttributeSet.w(a.k.TextInputLayout_hintTextAppearance, -1) != -1) {
      setHintTextAppearance(paramAttributeSet.w(a.k.TextInputLayout_hintTextAppearance, 0));
    }
    paramInt = paramAttributeSet.w(a.k.TextInputLayout_errorTextAppearance, 0);
    boolean bool1 = paramAttributeSet.m(a.k.TextInputLayout_errorEnabled, false);
    int i = paramAttributeSet.w(a.k.TextInputLayout_helperTextTextAppearance, 0);
    boolean bool2 = paramAttributeSet.m(a.k.TextInputLayout_helperTextEnabled, false);
    paramContext = paramAttributeSet.getText(a.k.TextInputLayout_helperText);
    boolean bool3 = paramAttributeSet.m(a.k.TextInputLayout_counterEnabled, false);
    setCounterMaxLength(paramAttributeSet.getInt(a.k.TextInputLayout_counterMaxLength, -1));
    this.counterTextAppearance = paramAttributeSet.w(a.k.TextInputLayout_counterTextAppearance, 0);
    this.counterOverflowTextAppearance = paramAttributeSet.w(a.k.TextInputLayout_counterOverflowTextAppearance, 0);
    this.dzR = paramAttributeSet.m(a.k.TextInputLayout_passwordToggleEnabled, false);
    this.dzS = paramAttributeSet.getDrawable(a.k.TextInputLayout_passwordToggleDrawable);
    this.dzT = paramAttributeSet.getText(a.k.TextInputLayout_passwordToggleContentDescription);
    if (paramAttributeSet.az(a.k.TextInputLayout_passwordToggleTint))
    {
      this.dzZ = true;
      this.dzY = paramAttributeSet.getColorStateList(a.k.TextInputLayout_passwordToggleTint);
    }
    if (paramAttributeSet.az(a.k.TextInputLayout_passwordToggleTintMode))
    {
      this.dAb = true;
      this.dAa = l.c(paramAttributeSet.getInt(a.k.TextInputLayout_passwordToggleTintMode, -1), null);
    }
    paramAttributeSet.xv.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(paramContext);
    setHelperTextTextAppearance(i);
    setErrorEnabled(bool1);
    setErrorTextAppearance(paramInt);
    setCounterEnabled(bool3);
    XB();
    z.p(this, 2);
    AppMethodBeat.o(209723);
  }
  
  private boolean XA()
  {
    AppMethodBeat.i(209963);
    if ((this.dzR) && ((Xz()) || (this.dzV)))
    {
      AppMethodBeat.o(209963);
      return true;
    }
    AppMethodBeat.o(209963);
    return false;
  }
  
  private void XB()
  {
    AppMethodBeat.i(209974);
    if ((this.dzS != null) && ((this.dzZ) || (this.dAb)))
    {
      this.dzS = androidx.core.graphics.drawable.a.s(this.dzS).mutate();
      if (this.dzZ) {
        androidx.core.graphics.drawable.a.a(this.dzS, this.dzY);
      }
      if (this.dAb) {
        androidx.core.graphics.drawable.a.a(this.dzS, this.dAa);
      }
      if ((this.dzU != null) && (this.dzU.getDrawable() != this.dzS)) {
        this.dzU.setImageDrawable(this.dzS);
      }
    }
    AppMethodBeat.o(209974);
  }
  
  private boolean XC()
  {
    AppMethodBeat.i(209999);
    if ((this.dzB) && (!TextUtils.isEmpty(this.dzC)) && ((this.dzE instanceof a)))
    {
      AppMethodBeat.o(209999);
      return true;
    }
    AppMethodBeat.o(209999);
    return false;
  }
  
  private void XD()
  {
    AppMethodBeat.i(210010);
    if (!XC())
    {
      AppMethodBeat.o(210010);
      return;
    }
    RectF localRectF = this.dzQ;
    this.doq.b(localRectF);
    d(localRectF);
    ((a)this.dzE).c(localRectF);
    AppMethodBeat.o(210010);
  }
  
  private void XE()
  {
    AppMethodBeat.i(210017);
    if (XC()) {
      ((a)this.dzE).m(0.0F, 0.0F, 0.0F, 0.0F);
    }
    AppMethodBeat.o(210017);
  }
  
  private void Xn()
  {
    AppMethodBeat.i(209748);
    Xo();
    if (this.boxBackgroundMode != 0) {
      Xp();
    }
    Xq();
    AppMethodBeat.o(209748);
  }
  
  private void Xo()
  {
    AppMethodBeat.i(209762);
    if (this.boxBackgroundMode == 0)
    {
      this.dzE = null;
      AppMethodBeat.o(209762);
      return;
    }
    if ((this.boxBackgroundMode == 2) && (this.dzB) && (!(this.dzE instanceof a)))
    {
      this.dzE = new a();
      AppMethodBeat.o(209762);
      return;
    }
    if (!(this.dzE instanceof GradientDrawable)) {
      this.dzE = new GradientDrawable();
    }
    AppMethodBeat.o(209762);
  }
  
  private void Xp()
  {
    AppMethodBeat.i(209814);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.dzu.getLayoutParams();
    int i = Xs();
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.dzu.requestLayout();
    }
    AppMethodBeat.o(209814);
  }
  
  private void Xq()
  {
    AppMethodBeat.i(209852);
    if ((this.boxBackgroundMode == 0) || (this.dzE == null) || (this.dzv == null) || (getRight() == 0))
    {
      AppMethodBeat.o(209852);
      return;
    }
    int i3 = this.dzv.getLeft();
    int i2 = Xr();
    int i1 = this.dzv.getRight();
    int n = this.dzv.getBottom() + this.dzF;
    int m = n;
    int k = i1;
    int j = i2;
    int i = i3;
    if (this.boxBackgroundMode == 2)
    {
      i = i3 + this.dzO / 2;
      j = i2 - this.dzO / 2;
      k = i1 - this.dzO / 2;
      m = n + this.dzO / 2;
    }
    this.dzE.setBounds(i, j, k, m);
    Xv();
    Xt();
    AppMethodBeat.o(209852);
  }
  
  private int Xr()
  {
    AppMethodBeat.i(209865);
    if (this.dzv == null)
    {
      AppMethodBeat.o(209865);
      return 0;
    }
    switch (this.boxBackgroundMode)
    {
    default: 
      AppMethodBeat.o(209865);
      return 0;
    case 1: 
      i = this.dzv.getTop();
      AppMethodBeat.o(209865);
      return i;
    }
    int i = this.dzv.getTop();
    int j = Xs();
    AppMethodBeat.o(209865);
    return i + j;
  }
  
  private int Xs()
  {
    AppMethodBeat.i(209876);
    if (!this.dzB)
    {
      AppMethodBeat.o(209876);
      return 0;
    }
    switch (this.boxBackgroundMode)
    {
    default: 
      AppMethodBeat.o(209876);
      return 0;
    case 2: 
      i = (int)(this.doq.WH() / 2.0F);
      AppMethodBeat.o(209876);
      return i;
    }
    int i = (int)this.doq.WH();
    AppMethodBeat.o(209876);
    return i;
  }
  
  private void Xt()
  {
    AppMethodBeat.i(209887);
    if (this.dzv == null)
    {
      AppMethodBeat.o(209887);
      return;
    }
    Object localObject2 = this.dzv.getBackground();
    if (localObject2 == null)
    {
      AppMethodBeat.o(209887);
      return;
    }
    Object localObject1 = localObject2;
    if (o.j((Drawable)localObject2)) {
      localObject1 = ((Drawable)localObject2).mutate();
    }
    localObject2 = new Rect();
    com.google.android.material.internal.d.a(this, this.dzv, (Rect)localObject2);
    localObject2 = ((Drawable)localObject1).getBounds();
    if (((Rect)localObject2).left != ((Rect)localObject2).right)
    {
      Rect localRect = new Rect();
      ((Drawable)localObject1).getPadding(localRect);
      int i = ((Rect)localObject2).left;
      int j = localRect.left;
      int k = ((Rect)localObject2).right;
      int m = localRect.right;
      ((Drawable)localObject1).setBounds(i - j, ((Rect)localObject2).top, m * 2 + k, this.dzv.getBottom());
    }
    AppMethodBeat.o(209887);
  }
  
  private void Xu()
  {
    AppMethodBeat.i(209897);
    switch (this.boxBackgroundMode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(209897);
      return;
      this.dzM = 0;
      AppMethodBeat.o(209897);
      return;
      if (this.dAg == 0) {
        this.dAg = this.dAd.getColorForState(getDrawableState(), this.dAd.getDefaultColor());
      }
    }
  }
  
  private void Xv()
  {
    AppMethodBeat.i(209909);
    if (this.dzE == null)
    {
      AppMethodBeat.o(209909);
      return;
    }
    Xu();
    if ((this.dzv != null) && (this.boxBackgroundMode == 2))
    {
      if (this.dzv.getBackground() != null) {
        this.dzP = this.dzv.getBackground();
      }
      z.a(this.dzv, null);
    }
    if ((this.dzv != null) && (this.boxBackgroundMode == 1) && (this.dzP != null)) {
      z.a(this.dzv, this.dzP);
    }
    if ((this.dzM >= 0) && (this.boxStrokeColor != 0)) {
      this.dzE.setStroke(this.dzM, this.boxStrokeColor);
    }
    this.dzE.setCornerRadii(getCornerRadiiAsArray());
    this.dzE.setColor(this.boxBackgroundColor);
    invalidate();
    AppMethodBeat.o(209909);
  }
  
  private void Xx()
  {
    AppMethodBeat.i(209921);
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22))
    {
      AppMethodBeat.o(209921);
      return;
    }
    Drawable localDrawable1 = this.dzv.getBackground();
    if (localDrawable1 == null)
    {
      AppMethodBeat.o(209921);
      return;
    }
    if (!this.dAk)
    {
      Drawable localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.dAk = e.a((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
      if (!this.dAk)
      {
        z.a(this.dzv, localDrawable2);
        this.dAk = true;
        Xn();
      }
    }
    AppMethodBeat.o(209921);
  }
  
  private void Xy()
  {
    AppMethodBeat.i(209940);
    if (this.dzv == null)
    {
      AppMethodBeat.o(209940);
      return;
    }
    Drawable[] arrayOfDrawable;
    if (XA())
    {
      if (this.dzU == null)
      {
        this.dzU = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(a.h.design_text_input_password_icon, this.dzu, false));
        this.dzU.setImageDrawable(this.dzS);
        this.dzU.setContentDescription(this.dzT);
        this.dzu.addView(this.dzU);
        this.dzU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(209688);
            TextInputLayout.this.bQ(false);
            AppMethodBeat.o(209688);
          }
        });
      }
      if ((this.dzv != null) && (z.ab(this.dzv) <= 0)) {
        this.dzv.setMinimumHeight(z.ab(this.dzU));
      }
      this.dzU.setVisibility(0);
      this.dzU.setChecked(this.dzV);
      if (this.dzW == null) {
        this.dzW = new ColorDrawable();
      }
      this.dzW.setBounds(0, 0, this.dzU.getMeasuredWidth(), 1);
      arrayOfDrawable = j.b(this.dzv);
      if (arrayOfDrawable[2] != this.dzW) {
        this.dzX = arrayOfDrawable[2];
      }
      j.a(this.dzv, arrayOfDrawable[0], arrayOfDrawable[1], this.dzW, arrayOfDrawable[3]);
      this.dzU.setPadding(this.dzv.getPaddingLeft(), this.dzv.getPaddingTop(), this.dzv.getPaddingRight(), this.dzv.getPaddingBottom());
      AppMethodBeat.o(209940);
      return;
    }
    if ((this.dzU != null) && (this.dzU.getVisibility() == 0)) {
      this.dzU.setVisibility(8);
    }
    if (this.dzW != null)
    {
      arrayOfDrawable = j.b(this.dzv);
      if (arrayOfDrawable[2] == this.dzW)
      {
        j.a(this.dzv, arrayOfDrawable[0], arrayOfDrawable[1], this.dzX, arrayOfDrawable[3]);
        this.dzW = null;
      }
    }
    AppMethodBeat.o(209940);
  }
  
  private boolean Xz()
  {
    AppMethodBeat.i(209952);
    if ((this.dzv != null) && ((this.dzv.getTransformationMethod() instanceof PasswordTransformationMethod)))
    {
      AppMethodBeat.o(209952);
      return true;
    }
    AppMethodBeat.o(209952);
    return false;
  }
  
  private void bR(boolean paramBoolean)
  {
    AppMethodBeat.i(209987);
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.dAj)) {
      bc(1.0F);
    }
    for (;;)
    {
      this.dAi = false;
      if (XC()) {
        XD();
      }
      AppMethodBeat.o(209987);
      return;
      this.doq.aU(1.0F);
    }
  }
  
  private void bS(boolean paramBoolean)
  {
    AppMethodBeat.i(210032);
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.dAj)) {
      bc(0.0F);
    }
    for (;;)
    {
      if ((XC()) && (((a)this.dzE).Xg())) {
        XE();
      }
      this.dAi = true;
      AppMethodBeat.o(210032);
      return;
      this.doq.aU(0.0F);
    }
  }
  
  private void bc(float paramFloat)
  {
    AppMethodBeat.i(210048);
    if (this.doq.dux == paramFloat)
    {
      AppMethodBeat.o(210048);
      return;
    }
    if (this.animator == null)
    {
      this.animator = new ValueAnimator();
      this.animator.setInterpolator(com.google.android.material.a.a.dnr);
      this.animator.setDuration(167L);
      this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(209690);
          TextInputLayout.this.doq.aU(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          AppMethodBeat.o(209690);
        }
      });
    }
    this.animator.setFloatValues(new float[] { this.doq.dux, paramFloat });
    this.animator.start();
    AppMethodBeat.o(210048);
  }
  
  private void d(RectF paramRectF)
  {
    paramRectF.left -= this.dzG;
    paramRectF.top -= this.dzG;
    paramRectF.right += this.dzG;
    paramRectF.bottom += this.dzG;
  }
  
  private static void d(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(209839);
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup)) {
        d((ViewGroup)localView, paramBoolean);
      }
      i += 1;
    }
    AppMethodBeat.o(209839);
  }
  
  private Drawable getBoxBackground()
  {
    AppMethodBeat.i(209738);
    if ((this.boxBackgroundMode == 1) || (this.boxBackgroundMode == 2))
    {
      localObject = this.dzE;
      AppMethodBeat.o(209738);
      return localObject;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(209738);
    throw ((Throwable)localObject);
  }
  
  private float[] getCornerRadiiAsArray()
  {
    AppMethodBeat.i(209778);
    if (!l.s(this))
    {
      f1 = this.dzI;
      f2 = this.dzI;
      f3 = this.dzJ;
      f4 = this.dzJ;
      f5 = this.dzK;
      f6 = this.dzK;
      f7 = this.dzL;
      f8 = this.dzL;
      AppMethodBeat.o(209778);
      return new float[] { f1, f2, f3, f4, f5, f6, f7, f8 };
    }
    float f1 = this.dzJ;
    float f2 = this.dzJ;
    float f3 = this.dzI;
    float f4 = this.dzI;
    float f5 = this.dzL;
    float f6 = this.dzL;
    float f7 = this.dzK;
    float f8 = this.dzK;
    AppMethodBeat.o(209778);
    return new float[] { f1, f2, f3, f4, f5, f6, f7, f8 };
  }
  
  private void setEditText(EditText paramEditText)
  {
    AppMethodBeat.i(209797);
    if (this.dzv != null)
    {
      paramEditText = new IllegalArgumentException("We already have an EditText, can only have one");
      AppMethodBeat.o(209797);
      throw paramEditText;
    }
    this.dzv = paramEditText;
    Xn();
    setTextInputAccessibilityDelegate(new a(this));
    if (!Xz()) {
      this.doq.f(this.dzv.getTypeface());
    }
    paramEditText = this.doq;
    float f = this.dzv.getTextSize();
    if (paramEditText.duD != f)
    {
      paramEditText.duD = f;
      paramEditText.xQ();
    }
    int i = this.dzv.getGravity();
    this.doq.jl(i & 0xFFFFFF8F | 0x30);
    this.doq.jk(i);
    this.dzv.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(209709);
        TextInputLayout localTextInputLayout = TextInputLayout.this;
        if (!TextInputLayout.a(TextInputLayout.this)) {}
        for (boolean bool = true;; bool = false)
        {
          localTextInputLayout.k(bool, false);
          if (TextInputLayout.this.dzy) {
            TextInputLayout.this.jA(paramAnonymousEditable.length());
          }
          AppMethodBeat.o(209709);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.dAc == null) {
      this.dAc = this.dzv.getHintTextColors();
    }
    if (this.dzB)
    {
      if (TextUtils.isEmpty(this.dzC))
      {
        this.dzw = this.dzv.getHint();
        setHint(this.dzw);
        this.dzv.setHint(null);
      }
      this.dzD = true;
    }
    if (this.dzA != null) {
      jA(this.dzv.getText().length());
    }
    this.dzx.Xj();
    Xy();
    k(false, true);
    AppMethodBeat.o(209797);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209826);
    if (!TextUtils.equals(paramCharSequence, this.dzC))
    {
      this.dzC = paramCharSequence;
      this.doq.setText(paramCharSequence);
      if (!this.dAi) {
        XD();
      }
    }
    AppMethodBeat.o(209826);
  }
  
  final void XF()
  {
    int j = 1;
    AppMethodBeat.i(210310);
    if ((this.dzE == null) || (this.boxBackgroundMode == 0))
    {
      AppMethodBeat.o(210310);
      return;
    }
    int i;
    if ((this.dzv != null) && (this.dzv.hasFocus()))
    {
      i = 1;
      if ((this.dzv == null) || (!this.dzv.isHovered())) {
        break label127;
      }
      label65:
      if (this.boxBackgroundMode == 2)
      {
        if (isEnabled()) {
          break label132;
        }
        this.boxStrokeColor = this.dAh;
        label88:
        if (((j == 0) && (i == 0)) || (!isEnabled())) {
          break label225;
        }
      }
    }
    label132:
    label225:
    for (this.dzM = this.dzO;; this.dzM = this.dzN)
    {
      Xv();
      AppMethodBeat.o(210310);
      return;
      i = 0;
      break;
      label127:
      j = 0;
      break label65;
      if (this.dzx.Xk())
      {
        this.boxStrokeColor = this.dzx.Xl();
        break label88;
      }
      if ((this.dzz) && (this.dzA != null))
      {
        this.boxStrokeColor = this.dzA.getCurrentTextColor();
        break label88;
      }
      if (i != 0)
      {
        this.boxStrokeColor = this.dAg;
        break label88;
      }
      if (j != 0)
      {
        this.boxStrokeColor = this.dAf;
        break label88;
      }
      this.boxStrokeColor = this.dAe;
      break label88;
    }
  }
  
  final void Xw()
  {
    AppMethodBeat.i(210291);
    if (this.dzv == null)
    {
      AppMethodBeat.o(210291);
      return;
    }
    Drawable localDrawable2 = this.dzv.getBackground();
    if (localDrawable2 == null)
    {
      AppMethodBeat.o(210291);
      return;
    }
    Xx();
    Drawable localDrawable1 = localDrawable2;
    if (o.j(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if (this.dzx.Xk())
    {
      localDrawable1.setColorFilter(f.a(this.dzx.Xl(), PorterDuff.Mode.SRC_IN));
      AppMethodBeat.o(210291);
      return;
    }
    if ((this.dzz) && (this.dzA != null))
    {
      localDrawable1.setColorFilter(f.a(this.dzA.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      AppMethodBeat.o(210291);
      return;
    }
    androidx.core.graphics.drawable.a.r(localDrawable1);
    this.dzv.refreshDrawableState();
    AppMethodBeat.o(210291);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(210062);
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.dzu.addView(paramView, localLayoutParams);
      this.dzu.setLayoutParams(paramLayoutParams);
      Xp();
      setEditText((EditText)paramView);
      AppMethodBeat.o(210062);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(210062);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    AppMethodBeat.i(210305);
    int i;
    if (this.dzR)
    {
      i = this.dzv.getSelectionEnd();
      if (!Xz()) {
        break label78;
      }
      this.dzv.setTransformationMethod(null);
    }
    for (this.dzV = true;; this.dzV = false)
    {
      this.dzU.setChecked(this.dzV);
      if (paramBoolean) {
        this.dzU.jumpDrawablesToCurrentState();
      }
      this.dzv.setSelection(i);
      AppMethodBeat.o(210305);
      return;
      label78:
      this.dzv.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(210170);
    if ((this.dzw == null) || (this.dzv == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      AppMethodBeat.o(210170);
      return;
    }
    boolean bool = this.dzD;
    this.dzD = false;
    CharSequence localCharSequence = this.dzv.getHint();
    this.dzv.setHint(this.dzw);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.dzv.setHint(localCharSequence);
      this.dzD = bool;
      AppMethodBeat.o(210170);
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    AppMethodBeat.i(210294);
    this.dAm = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.dAm = false;
    AppMethodBeat.o(210294);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(210296);
    if (this.dzE != null) {
      this.dzE.draw(paramCanvas);
    }
    super.draw(paramCanvas);
    if (this.dzB) {
      this.doq.draw(paramCanvas);
    }
    AppMethodBeat.o(210296);
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    AppMethodBeat.i(210309);
    if (this.dAl)
    {
      AppMethodBeat.o(210309);
      return;
    }
    this.dAl = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((z.au(this)) && (isEnabled()))
    {
      k(bool2, false);
      Xw();
      Xq();
      XF();
      if (this.doq == null) {
        break label111;
      }
    }
    label111:
    for (boolean bool1 = this.doq.setState(arrayOfInt) | false;; bool1 = false)
    {
      if (bool1) {
        invalidate();
      }
      this.dAl = false;
      AppMethodBeat.o(210309);
      return;
      bool2 = false;
      break;
    }
  }
  
  public int getBoxBackgroundColor()
  {
    return this.boxBackgroundColor;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.dzK;
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.dzL;
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.dzJ;
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.dzI;
  }
  
  public int getBoxStrokeColor()
  {
    return this.dAg;
  }
  
  public int getCounterMaxLength()
  {
    return this.counterMaxLength;
  }
  
  CharSequence getCounterOverflowDescription()
  {
    AppMethodBeat.i(210282);
    if ((this.dzy) && (this.dzz) && (this.dzA != null))
    {
      CharSequence localCharSequence = this.dzA.getContentDescription();
      AppMethodBeat.o(210282);
      return localCharSequence;
    }
    AppMethodBeat.o(210282);
    return null;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.dAc;
  }
  
  public EditText getEditText()
  {
    return this.dzv;
  }
  
  public CharSequence getError()
  {
    if (this.dzx.dzk) {
      return this.dzx.dzj;
    }
    return null;
  }
  
  public int getErrorCurrentTextColors()
  {
    AppMethodBeat.i(210250);
    int i = this.dzx.Xl();
    AppMethodBeat.o(210250);
    return i;
  }
  
  final int getErrorTextCurrentColor()
  {
    AppMethodBeat.i(210313);
    int i = this.dzx.Xl();
    AppMethodBeat.o(210313);
    return i;
  }
  
  public CharSequence getHelperText()
  {
    if (this.dzx.dzn) {
      return this.dzx.dzm;
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    AppMethodBeat.i(210269);
    b localb = this.dzx;
    if (localb.dzo != null)
    {
      int i = localb.dzo.getCurrentTextColor();
      AppMethodBeat.o(210269);
      return i;
    }
    AppMethodBeat.o(210269);
    return -1;
  }
  
  public CharSequence getHint()
  {
    if (this.dzB) {
      return this.dzC;
    }
    return null;
  }
  
  final float getHintCollapsedTextHeight()
  {
    AppMethodBeat.i(210312);
    float f = this.doq.WH();
    AppMethodBeat.o(210312);
    return f;
  }
  
  final int getHintCurrentCollapsedTextColor()
  {
    AppMethodBeat.i(210311);
    int i = this.doq.WL();
    AppMethodBeat.o(210311);
    return i;
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.dzT;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.dzS;
  }
  
  public Typeface getTypeface()
  {
    return this.bbO;
  }
  
  final void h(TextView paramTextView, int paramInt)
  {
    i = 1;
    AppMethodBeat.i(210288);
    try
    {
      j.a(paramTextView, paramInt);
      if (Build.VERSION.SDK_INT < 23) {
        break label77;
      }
      paramInt = paramTextView.getTextColors().getDefaultColor();
      if (paramInt != -65281) {
        break label77;
      }
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramInt = i;
        continue;
        paramInt = 0;
      }
    }
    if (paramInt != 0)
    {
      j.a(paramTextView, a.j.TextAppearance_AppCompat_Caption);
      paramTextView.setTextColor(androidx.core.content.a.w(getContext(), a.c.design_error));
    }
    AppMethodBeat.o(210288);
  }
  
  final void jA(int paramInt)
  {
    AppMethodBeat.i(210285);
    boolean bool2 = this.dzz;
    if (this.counterMaxLength == -1)
    {
      this.dzA.setText(String.valueOf(paramInt));
      this.dzA.setContentDescription(null);
      this.dzz = false;
      if ((this.dzv != null) && (bool2 != this.dzz))
      {
        k(false, false);
        XF();
        Xw();
      }
      AppMethodBeat.o(210285);
      return;
    }
    if (z.W(this.dzA) == 1) {
      z.r(this.dzA, 0);
    }
    boolean bool1;
    label110:
    TextView localTextView;
    if (paramInt > this.counterMaxLength)
    {
      bool1 = true;
      this.dzz = bool1;
      if (bool2 != this.dzz)
      {
        localTextView = this.dzA;
        if (!this.dzz) {
          break label248;
        }
      }
    }
    label248:
    for (int i = this.counterOverflowTextAppearance;; i = this.counterTextAppearance)
    {
      h(localTextView, i);
      if (this.dzz) {
        z.r(this.dzA, 1);
      }
      this.dzA.setText(getContext().getString(a.i.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.counterMaxLength) }));
      this.dzA.setContentDescription(getContext().getString(a.i.character_counter_content_description, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.counterMaxLength) }));
      break;
      bool1 = false;
      break label110;
    }
  }
  
  final void k(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(210180);
    boolean bool1 = isEnabled();
    int i;
    label54:
    boolean bool2;
    if ((this.dzv != null) && (!TextUtils.isEmpty(this.dzv.getText())))
    {
      i = 1;
      if ((this.dzv == null) || (!this.dzv.hasFocus())) {
        break label174;
      }
      bool2 = this.dzx.Xk();
      if (this.dAc != null)
      {
        this.doq.e(this.dAc);
        this.doq.f(this.dAc);
      }
      if (bool1) {
        break label180;
      }
      this.doq.e(ColorStateList.valueOf(this.dAh));
      this.doq.f(ColorStateList.valueOf(this.dAh));
    }
    for (;;)
    {
      if ((i == 0) && ((!isEnabled()) || ((j == 0) && (!bool2)))) {
        break label259;
      }
      if ((!paramBoolean2) && (!this.dAi)) {
        break label275;
      }
      bR(paramBoolean1);
      AppMethodBeat.o(210180);
      return;
      i = 0;
      break;
      label174:
      j = 0;
      break label54;
      label180:
      if (bool2) {
        this.doq.e(this.dzx.Xm());
      } else if ((this.dzz) && (this.dzA != null)) {
        this.doq.e(this.dzA.getTextColors());
      } else if ((j != 0) && (this.dAd != null)) {
        this.doq.e(this.dAd);
      }
    }
    label259:
    if ((paramBoolean2) || (!this.dAi)) {
      bS(paramBoolean1);
    }
    label275:
    AppMethodBeat.o(210180);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(210307);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.dzE != null) {
      Xq();
    }
    Rect localRect;
    int i;
    if ((this.dzB) && (this.dzv != null))
    {
      localRect = this.tmpRect;
      com.google.android.material.internal.d.a(this, this.dzv, localRect);
      paramInt1 = localRect.left;
      paramInt3 = this.dzv.getCompoundPaddingLeft() + paramInt1;
      i = localRect.right - this.dzv.getCompoundPaddingRight();
      switch (this.boxBackgroundMode)
      {
      default: 
        paramInt1 = getPaddingTop();
      }
    }
    for (;;)
    {
      this.doq.y(paramInt3, localRect.top + this.dzv.getCompoundPaddingTop(), i, localRect.bottom - this.dzv.getCompoundPaddingBottom());
      this.doq.z(paramInt3, paramInt1, i, paramInt4 - paramInt2 - getPaddingBottom());
      this.doq.xQ();
      if ((XC()) && (!this.dAi)) {
        XD();
      }
      AppMethodBeat.o(210307);
      return;
      paramInt1 = getBoxBackground().getBounds().top - Xs();
      continue;
      paramInt1 = getBoxBackground().getBounds().top + this.dzH;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210297);
    Xy();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(210297);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(210293);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(210293);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.bxs);
    setError(paramParcelable.dAp);
    if (paramParcelable.dAq) {
      bQ(true);
    }
    requestLayout();
    AppMethodBeat.o(210293);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(210292);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.dzx.Xk()) {
      localSavedState.dAp = getError();
    }
    localSavedState.dAq = this.dzV;
    AppMethodBeat.o(210292);
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(210110);
    if (this.boxBackgroundColor != paramInt)
    {
      this.boxBackgroundColor = paramInt;
      Xv();
    }
    AppMethodBeat.o(210110);
  }
  
  public void setBoxBackgroundColorResource(int paramInt)
  {
    AppMethodBeat.i(210097);
    setBoxBackgroundColor(androidx.core.content.a.w(getContext(), paramInt));
    AppMethodBeat.o(210097);
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    AppMethodBeat.i(210071);
    if (paramInt == this.boxBackgroundMode)
    {
      AppMethodBeat.o(210071);
      return;
    }
    this.boxBackgroundMode = paramInt;
    Xn();
    AppMethodBeat.o(210071);
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    AppMethodBeat.i(210080);
    if (this.dAg != paramInt)
    {
      this.dAg = paramInt;
      XF();
    }
    AppMethodBeat.o(210080);
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(210273);
    if (this.dzy != paramBoolean)
    {
      if (!paramBoolean) {
        break label136;
      }
      this.dzA = new AppCompatTextView(getContext());
      this.dzA.setId(a.f.textinput_counter);
      if (this.bbO != null) {
        this.dzA.setTypeface(this.bbO);
      }
      this.dzA.setMaxLines(1);
      h(this.dzA, this.counterTextAppearance);
      this.dzx.f(this.dzA, 2);
      if (this.dzv != null) {
        break label117;
      }
      jA(0);
    }
    for (;;)
    {
      this.dzy = paramBoolean;
      AppMethodBeat.o(210273);
      return;
      label117:
      jA(this.dzv.getText().length());
      continue;
      label136:
      this.dzx.g(this.dzA, 2);
      this.dzA = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    AppMethodBeat.i(210275);
    if (this.counterMaxLength != paramInt)
    {
      if (paramInt <= 0) {
        break label51;
      }
      this.counterMaxLength = paramInt;
      if (this.dzy) {
        if (this.dzv != null) {
          break label59;
        }
      }
    }
    label51:
    label59:
    for (paramInt = 0;; paramInt = this.dzv.getText().length())
    {
      jA(paramInt);
      AppMethodBeat.o(210275);
      return;
      this.counterMaxLength = -1;
      break;
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210221);
    this.dAc = paramColorStateList;
    this.dAd = paramColorStateList;
    if (this.dzv != null) {
      k(false, false);
    }
    AppMethodBeat.o(210221);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(210277);
    d(this, paramBoolean);
    super.setEnabled(paramBoolean);
    AppMethodBeat.o(210277);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(210271);
    if (!this.dzx.dzk)
    {
      if (TextUtils.isEmpty(paramCharSequence))
      {
        AppMethodBeat.o(210271);
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      b localb = this.dzx;
      localb.Xi();
      localb.dzj = paramCharSequence;
      localb.dzl.setText(paramCharSequence);
      if (localb.dzh != 1) {
        localb.dzi = 1;
      }
      localb.i(localb.dzh, localb.dzi, localb.b(localb.dzl, paramCharSequence));
      AppMethodBeat.o(210271);
      return;
    }
    this.dzx.Xh();
    AppMethodBeat.o(210271);
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(210235);
    b localb = this.dzx;
    if (localb.dzk != paramBoolean)
    {
      localb.Xi();
      if (!paramBoolean) {
        break label115;
      }
      localb.dzl = new AppCompatTextView(localb.context);
      localb.dzl.setId(a.f.textinput_error);
      if (localb.bbO != null) {
        localb.dzl.setTypeface(localb.bbO);
      }
      localb.setErrorTextAppearance(localb.errorTextAppearance);
      localb.dzl.setVisibility(4);
      z.r(localb.dzl, 1);
      localb.f(localb.dzl, 0);
    }
    for (;;)
    {
      localb.dzk = paramBoolean;
      AppMethodBeat.o(210235);
      return;
      label115:
      localb.Xh();
      localb.g(localb.dzl, 0);
      localb.dzl = null;
      localb.dza.Xw();
      localb.dza.XF();
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    AppMethodBeat.i(210240);
    this.dzx.setErrorTextAppearance(paramInt);
    AppMethodBeat.o(210240);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210245);
    b localb = this.dzx;
    if (localb.dzl != null) {
      localb.dzl.setTextColor(paramColorStateList);
    }
    AppMethodBeat.o(210245);
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(210264);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (this.dzx.dzn)
      {
        setHelperTextEnabled(false);
        AppMethodBeat.o(210264);
      }
    }
    else
    {
      if (!this.dzx.dzn) {
        setHelperTextEnabled(true);
      }
      b localb = this.dzx;
      localb.Xi();
      localb.dzm = paramCharSequence;
      localb.dzo.setText(paramCharSequence);
      if (localb.dzh != 2) {
        localb.dzi = 2;
      }
      localb.i(localb.dzh, localb.dzi, localb.b(localb.dzo, paramCharSequence));
    }
    AppMethodBeat.o(210264);
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210266);
    b localb = this.dzx;
    if (localb.dzo != null) {
      localb.dzo.setTextColor(paramColorStateList);
    }
    AppMethodBeat.o(210266);
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(210259);
    b localb = this.dzx;
    if (localb.dzn != paramBoolean)
    {
      localb.Xi();
      if (!paramBoolean) {
        break label115;
      }
      localb.dzo = new AppCompatTextView(localb.context);
      localb.dzo.setId(a.f.textinput_helper_text);
      if (localb.bbO != null) {
        localb.dzo.setTypeface(localb.bbO);
      }
      localb.dzo.setVisibility(4);
      z.r(localb.dzo, 1);
      localb.jz(localb.helperTextTextAppearance);
      localb.f(localb.dzo, 1);
    }
    for (;;)
    {
      localb.dzn = paramBoolean;
      AppMethodBeat.o(210259);
      return;
      label115:
      localb.Xi();
      if (localb.dzh == 2) {
        localb.dzi = 0;
      }
      localb.i(localb.dzh, localb.dzi, localb.b(localb.dzo, null));
      localb.g(localb.dzo, 1);
      localb.dzo = null;
      localb.dza.Xw();
      localb.dza.XF();
    }
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    AppMethodBeat.i(210253);
    this.dzx.jz(paramInt);
    AppMethodBeat.o(210253);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(210191);
    if (this.dzB)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
    AppMethodBeat.o(210191);
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.dAj = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(210204);
    if (paramBoolean != this.dzB)
    {
      this.dzB = paramBoolean;
      if (this.dzB) {
        break label88;
      }
      this.dzD = false;
      if ((!TextUtils.isEmpty(this.dzC)) && (TextUtils.isEmpty(this.dzv.getHint()))) {
        this.dzv.setHint(this.dzC);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (this.dzv != null) {
        Xp();
      }
      AppMethodBeat.o(210204);
      return;
      label88:
      CharSequence localCharSequence = this.dzv.getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.dzC)) {
          setHint(localCharSequence);
        }
        this.dzv.setHint(null);
      }
      this.dzD = true;
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    AppMethodBeat.i(210213);
    this.doq.jm(paramInt);
    this.dAd = this.doq.duG;
    if (this.dzv != null)
    {
      k(false, false);
      Xp();
    }
    AppMethodBeat.o(210213);
  }
  
  public void setPasswordVisibilityToggleContentDescription(int paramInt)
  {
    AppMethodBeat.i(210300);
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getResources().getText(paramInt);; localCharSequence = null)
    {
      setPasswordVisibilityToggleContentDescription(localCharSequence);
      AppMethodBeat.o(210300);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(210301);
    this.dzT = paramCharSequence;
    if (this.dzU != null) {
      this.dzU.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(210301);
  }
  
  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    AppMethodBeat.i(210298);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.appcompat.a.a.a.m(getContext(), paramInt);; localDrawable = null)
    {
      setPasswordVisibilityToggleDrawable(localDrawable);
      AppMethodBeat.o(210298);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(210299);
    this.dzS = paramDrawable;
    if (this.dzU != null) {
      this.dzU.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(210299);
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(210302);
    if (this.dzR != paramBoolean)
    {
      this.dzR = paramBoolean;
      if ((!paramBoolean) && (this.dzV) && (this.dzv != null)) {
        this.dzv.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      this.dzV = false;
      Xy();
    }
    AppMethodBeat.o(210302);
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210303);
    this.dzY = paramColorStateList;
    this.dzZ = true;
    XB();
    AppMethodBeat.o(210303);
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(210304);
    this.dAa = paramMode;
    this.dAb = true;
    XB();
    AppMethodBeat.o(210304);
  }
  
  public void setTextInputAccessibilityDelegate(a parama)
  {
    AppMethodBeat.i(210306);
    if (this.dzv != null) {
      z.a(this.dzv, parama);
    }
    AppMethodBeat.o(210306);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(210154);
    if (paramTypeface != this.bbO)
    {
      this.bbO = paramTypeface;
      this.doq.f(paramTypeface);
      b localb = this.dzx;
      if (paramTypeface != localb.bbO)
      {
        localb.bbO = paramTypeface;
        b.a(localb.dzl, paramTypeface);
        b.a(localb.dzo, paramTypeface);
      }
      if (this.dzA != null) {
        this.dzA.setTypeface(paramTypeface);
      }
    }
    AppMethodBeat.o(210154);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    CharSequence dAp;
    boolean dAq;
    
    static
    {
      AppMethodBeat.i(209687);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(209687);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(209680);
      this.dAp = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      if (paramParcel.readInt() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.dAq = bool;
        AppMethodBeat.o(209680);
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(209705);
      String str = "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.dAp + "}";
      AppMethodBeat.o(209705);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(209696);
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.dAp, paramParcel, paramInt);
      if (this.dAq) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(209696);
        return;
      }
    }
  }
  
  public static class a
    extends androidx.core.g.a
  {
    private final TextInputLayout dAo;
    
    public a(TextInputLayout paramTextInputLayout)
    {
      this.dAo = paramTextInputLayout;
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, androidx.core.g.a.d paramd)
    {
      boolean bool = true;
      AppMethodBeat.i(209695);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      paramView = this.dAo.getEditText();
      CharSequence localCharSequence3;
      CharSequence localCharSequence1;
      CharSequence localCharSequence2;
      int i;
      label67:
      int j;
      label78:
      int k;
      label89:
      int m;
      if (paramView != null)
      {
        paramView = paramView.getText();
        localCharSequence3 = this.dAo.getHint();
        localCharSequence1 = this.dAo.getError();
        localCharSequence2 = this.dAo.getCounterOverflowDescription();
        if (TextUtils.isEmpty(paramView)) {
          break label173;
        }
        i = 1;
        if (TextUtils.isEmpty(localCharSequence3)) {
          break label178;
        }
        j = 1;
        if (TextUtils.isEmpty(localCharSequence1)) {
          break label184;
        }
        k = 1;
        if ((k == 0) && (TextUtils.isEmpty(localCharSequence2))) {
          break label190;
        }
        m = 1;
        label105:
        if (i == 0) {
          break label196;
        }
        paramd.setText(paramView);
        label114:
        if (j != 0)
        {
          paramd.y(localCharSequence3);
          if ((i != 0) || (j == 0)) {
            break label210;
          }
          paramd.aK(bool);
        }
        label134:
        if (m != 0) {
          if (k == 0) {
            break label216;
          }
        }
      }
      label173:
      label178:
      label184:
      label190:
      label196:
      label210:
      label216:
      for (paramView = localCharSequence1;; paramView = localCharSequence2)
      {
        paramd.setError(paramView);
        paramd.EV();
        AppMethodBeat.o(209695);
        return;
        paramView = null;
        break;
        i = 0;
        break label67;
        j = 0;
        break label78;
        k = 0;
        break label89;
        m = 0;
        break label105;
        if (j == 0) {
          break label114;
        }
        paramd.setText(localCharSequence3);
        break label114;
        bool = false;
        break label134;
      }
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(209703);
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = this.dAo.getEditText();
      if (paramView != null) {}
      for (paramView = paramView.getText();; paramView = null)
      {
        Object localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = this.dAo.getHint();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramAccessibilityEvent.getText().add(localObject);
        }
        AppMethodBeat.o(209703);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */