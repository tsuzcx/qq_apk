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
import android.os.Bundle;
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
import android.view.accessibility.AccessibilityNodeInfo;
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
import androidx.core.g.w;
import androidx.core.widget.i;
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
  private boolean bGA;
  private TextView bGB;
  private boolean bGC;
  private CharSequence bGD;
  boolean bGE;
  private GradientDrawable bGF;
  private final int bGG;
  private final int bGH;
  private final int bGI;
  private float bGJ;
  private float bGK;
  private float bGL;
  private float bGM;
  private int bGN;
  private final int bGO;
  private final int bGP;
  private Drawable bGQ;
  private final RectF bGR;
  private boolean bGS;
  private Drawable bGT;
  private CharSequence bGU;
  private CheckableImageButton bGV;
  private boolean bGW;
  private Drawable bGX;
  private Drawable bGY;
  private ColorStateList bGZ;
  private Typeface bGp;
  private final FrameLayout bGv;
  EditText bGw;
  private CharSequence bGx;
  private final b bGy;
  boolean bGz;
  private boolean bHa;
  private PorterDuff.Mode bHb;
  private boolean bHc;
  private ColorStateList bHd;
  private ColorStateList bHe;
  private final int bHf;
  private final int bHg;
  private int bHh;
  private final int bHi;
  private boolean bHj;
  private boolean bHk;
  private boolean bHl;
  private boolean bHm;
  private boolean bHn;
  private int boxBackgroundColor;
  private int boxBackgroundMode;
  private int boxStrokeColor;
  private final Rect bvn;
  final c bvo;
  private int counterMaxLength;
  private final int counterOverflowTextAppearance;
  private final int counterTextAppearance;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.textInputStyle);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240442);
    this.bGy = new b(this);
    this.bvn = new Rect();
    this.bGR = new RectF();
    this.bvo = new c(this);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.bGv = new FrameLayout(paramContext);
    this.bGv.setAddStatesFromChildren(true);
    addView(this.bGv);
    this.bvo.c(com.google.android.material.a.a.bum);
    Object localObject = this.bvo;
    ((c)localObject).bBZ = com.google.android.material.a.a.bum;
    ((c)localObject).xq();
    this.bvo.fW(8388659);
    paramAttributeSet = k.b(paramContext, paramAttributeSet, a.k.TextInputLayout, paramInt, a.j.Widget_Design_TextInputLayout, new int[0]);
    this.bGC = paramAttributeSet.c(a.k.TextInputLayout_hintEnabled, true);
    setHint(paramAttributeSet.getText(a.k.TextInputLayout_android_hint));
    this.bHk = paramAttributeSet.c(a.k.TextInputLayout_hintAnimationEnabled, true);
    this.bGG = paramContext.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_bottom_offset);
    this.bGH = paramContext.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_label_cutout_padding);
    this.bGI = paramAttributeSet.o(a.k.TextInputLayout_boxCollapsedPaddingTop, 0);
    this.bGJ = paramAttributeSet.aB(a.k.TextInputLayout_boxCornerRadiusTopStart);
    this.bGK = paramAttributeSet.aB(a.k.TextInputLayout_boxCornerRadiusTopEnd);
    this.bGL = paramAttributeSet.aB(a.k.TextInputLayout_boxCornerRadiusBottomEnd);
    this.bGM = paramAttributeSet.aB(a.k.TextInputLayout_boxCornerRadiusBottomStart);
    this.boxBackgroundColor = paramAttributeSet.m(a.k.TextInputLayout_boxBackgroundColor, 0);
    this.bHh = paramAttributeSet.m(a.k.TextInputLayout_boxStrokeColor, 0);
    this.bGO = paramContext.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_default);
    this.bGP = paramContext.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_focused);
    this.bGN = this.bGO;
    setBoxBackgroundMode(paramAttributeSet.getInt(a.k.TextInputLayout_boxBackgroundMode, 0));
    if (paramAttributeSet.aC(a.k.TextInputLayout_android_textColorHint))
    {
      localObject = paramAttributeSet.getColorStateList(a.k.TextInputLayout_android_textColorHint);
      this.bHe = ((ColorStateList)localObject);
      this.bHd = ((ColorStateList)localObject);
    }
    this.bHf = androidx.core.content.a.w(paramContext, a.c.mtrl_textinput_default_box_stroke_color);
    this.bHi = androidx.core.content.a.w(paramContext, a.c.mtrl_textinput_disabled_color);
    this.bHg = androidx.core.content.a.w(paramContext, a.c.mtrl_textinput_hovered_box_stroke_color);
    if (paramAttributeSet.r(a.k.TextInputLayout_hintTextAppearance, -1) != -1) {
      setHintTextAppearance(paramAttributeSet.r(a.k.TextInputLayout_hintTextAppearance, 0));
    }
    paramInt = paramAttributeSet.r(a.k.TextInputLayout_errorTextAppearance, 0);
    boolean bool1 = paramAttributeSet.c(a.k.TextInputLayout_errorEnabled, false);
    int i = paramAttributeSet.r(a.k.TextInputLayout_helperTextTextAppearance, 0);
    boolean bool2 = paramAttributeSet.c(a.k.TextInputLayout_helperTextEnabled, false);
    paramContext = paramAttributeSet.getText(a.k.TextInputLayout_helperText);
    boolean bool3 = paramAttributeSet.c(a.k.TextInputLayout_counterEnabled, false);
    setCounterMaxLength(paramAttributeSet.getInt(a.k.TextInputLayout_counterMaxLength, -1));
    this.counterTextAppearance = paramAttributeSet.r(a.k.TextInputLayout_counterTextAppearance, 0);
    this.counterOverflowTextAppearance = paramAttributeSet.r(a.k.TextInputLayout_counterOverflowTextAppearance, 0);
    this.bGS = paramAttributeSet.c(a.k.TextInputLayout_passwordToggleEnabled, false);
    this.bGT = paramAttributeSet.getDrawable(a.k.TextInputLayout_passwordToggleDrawable);
    this.bGU = paramAttributeSet.getText(a.k.TextInputLayout_passwordToggleContentDescription);
    if (paramAttributeSet.aC(a.k.TextInputLayout_passwordToggleTint))
    {
      this.bHa = true;
      this.bGZ = paramAttributeSet.getColorStateList(a.k.TextInputLayout_passwordToggleTint);
    }
    if (paramAttributeSet.aC(a.k.TextInputLayout_passwordToggleTintMode))
    {
      this.bHc = true;
      this.bHb = l.c(paramAttributeSet.getInt(a.k.TextInputLayout_passwordToggleTintMode, -1), null);
    }
    paramAttributeSet.wA.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(paramContext);
    setHelperTextTextAppearance(i);
    setErrorEnabled(bool1);
    setErrorTextAppearance(paramInt);
    setCounterEnabled(bool3);
    ye();
    w.p(this, 2);
    AppMethodBeat.o(240442);
  }
  
  private void ab(float paramFloat)
  {
    AppMethodBeat.i(240615);
    if (this.bvo.bBv == paramFloat)
    {
      AppMethodBeat.o(240615);
      return;
    }
    if (this.animator == null)
    {
      this.animator = new ValueAnimator();
      this.animator.setInterpolator(com.google.android.material.a.a.bun);
      this.animator.setDuration(167L);
      this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(240297);
          TextInputLayout.this.bvo.T(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          AppMethodBeat.o(240297);
        }
      });
    }
    this.animator.setFloatValues(new float[] { this.bvo.bBv, paramFloat });
    this.animator.start();
    AppMethodBeat.o(240615);
  }
  
  private void bk(boolean paramBoolean)
  {
    AppMethodBeat.i(240602);
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.bHk)) {
      ab(1.0F);
    }
    for (;;)
    {
      this.bHj = false;
      if (yf()) {
        yg();
      }
      AppMethodBeat.o(240602);
      return;
      this.bvo.T(1.0F);
    }
  }
  
  private void bl(boolean paramBoolean)
  {
    AppMethodBeat.i(240613);
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.bHk)) {
      ab(0.0F);
    }
    for (;;)
    {
      if ((yf()) && (((a)this.bGF).xJ())) {
        yh();
      }
      this.bHj = true;
      AppMethodBeat.o(240613);
      return;
      this.bvo.T(0.0F);
    }
  }
  
  private void d(RectF paramRectF)
  {
    paramRectF.left -= this.bGH;
    paramRectF.top -= this.bGH;
    paramRectF.right += this.bGH;
    paramRectF.bottom += this.bGH;
  }
  
  private static void d(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(240534);
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
    AppMethodBeat.o(240534);
  }
  
  private Drawable getBoxBackground()
  {
    AppMethodBeat.i(240451);
    if ((this.boxBackgroundMode == 1) || (this.boxBackgroundMode == 2))
    {
      localObject = this.bGF;
      AppMethodBeat.o(240451);
      return localObject;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(240451);
    throw ((Throwable)localObject);
  }
  
  private float[] getCornerRadiiAsArray()
  {
    AppMethodBeat.i(240471);
    if (!l.s(this))
    {
      f1 = this.bGJ;
      f2 = this.bGJ;
      f3 = this.bGK;
      f4 = this.bGK;
      f5 = this.bGL;
      f6 = this.bGL;
      f7 = this.bGM;
      f8 = this.bGM;
      AppMethodBeat.o(240471);
      return new float[] { f1, f2, f3, f4, f5, f6, f7, f8 };
    }
    float f1 = this.bGK;
    float f2 = this.bGK;
    float f3 = this.bGJ;
    float f4 = this.bGJ;
    float f5 = this.bGM;
    float f6 = this.bGM;
    float f7 = this.bGL;
    float f8 = this.bGL;
    AppMethodBeat.o(240471);
    return new float[] { f1, f2, f3, f4, f5, f6, f7, f8 };
  }
  
  private void setEditText(EditText paramEditText)
  {
    AppMethodBeat.i(240477);
    if (this.bGw != null)
    {
      paramEditText = new IllegalArgumentException("We already have an EditText, can only have one");
      AppMethodBeat.o(240477);
      throw paramEditText;
    }
    this.bGw = paramEditText;
    xQ();
    setTextInputAccessibilityDelegate(new a(this));
    if (!yc()) {
      this.bvo.c(this.bGw.getTypeface());
    }
    paramEditText = this.bvo;
    float f = this.bGw.getTextSize();
    if (paramEditText.bBB != f)
    {
      paramEditText.bBB = f;
      paramEditText.xq();
    }
    int i = this.bGw.getGravity();
    this.bvo.fW(i & 0xFFFFFF8F | 0x30);
    this.bvo.fV(i);
    this.bGw.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(240278);
        TextInputLayout localTextInputLayout = TextInputLayout.this;
        if (!TextInputLayout.a(TextInputLayout.this)) {}
        for (boolean bool = true;; bool = false)
        {
          localTextInputLayout.i(bool, false);
          if (TextInputLayout.this.bGz) {
            TextInputLayout.this.go(paramAnonymousEditable.length());
          }
          AppMethodBeat.o(240278);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.bHd == null) {
      this.bHd = this.bGw.getHintTextColors();
    }
    if (this.bGC)
    {
      if (TextUtils.isEmpty(this.bGD))
      {
        this.bGx = this.bGw.getHint();
        setHint(this.bGx);
        this.bGw.setHint(null);
      }
      this.bGE = true;
    }
    if (this.bGB != null) {
      go(this.bGw.getText().length());
    }
    this.bGy.xM();
    yb();
    i(false, true);
    AppMethodBeat.o(240477);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240489);
    if (!TextUtils.equals(paramCharSequence, this.bGD))
    {
      this.bGD = paramCharSequence;
      this.bvo.setText(paramCharSequence);
      if (!this.bHj) {
        yg();
      }
    }
    AppMethodBeat.o(240489);
  }
  
  private void xQ()
  {
    AppMethodBeat.i(240457);
    xR();
    if (this.boxBackgroundMode != 0) {
      xS();
    }
    xT();
    AppMethodBeat.o(240457);
  }
  
  private void xR()
  {
    AppMethodBeat.i(240460);
    if (this.boxBackgroundMode == 0)
    {
      this.bGF = null;
      AppMethodBeat.o(240460);
      return;
    }
    if ((this.boxBackgroundMode == 2) && (this.bGC) && (!(this.bGF instanceof a)))
    {
      this.bGF = new a();
      AppMethodBeat.o(240460);
      return;
    }
    if (!(this.bGF instanceof GradientDrawable)) {
      this.bGF = new GradientDrawable();
    }
    AppMethodBeat.o(240460);
  }
  
  private void xS()
  {
    AppMethodBeat.i(240479);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.bGv.getLayoutParams();
    int i = xV();
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.bGv.requestLayout();
    }
    AppMethodBeat.o(240479);
  }
  
  private void xT()
  {
    AppMethodBeat.i(240544);
    if ((this.boxBackgroundMode == 0) || (this.bGF == null) || (this.bGw == null) || (getRight() == 0))
    {
      AppMethodBeat.o(240544);
      return;
    }
    int i3 = this.bGw.getLeft();
    int i2 = xU();
    int i1 = this.bGw.getRight();
    int n = this.bGw.getBottom() + this.bGG;
    int m = n;
    int k = i1;
    int j = i2;
    int i = i3;
    if (this.boxBackgroundMode == 2)
    {
      i = i3 + this.bGP / 2;
      j = i2 - this.bGP / 2;
      k = i1 - this.bGP / 2;
      m = n + this.bGP / 2;
    }
    this.bGF.setBounds(i, j, k, m);
    xY();
    xW();
    AppMethodBeat.o(240544);
  }
  
  private int xU()
  {
    AppMethodBeat.i(240545);
    if (this.bGw == null)
    {
      AppMethodBeat.o(240545);
      return 0;
    }
    switch (this.boxBackgroundMode)
    {
    default: 
      AppMethodBeat.o(240545);
      return 0;
    case 1: 
      i = this.bGw.getTop();
      AppMethodBeat.o(240545);
      return i;
    }
    int i = this.bGw.getTop();
    int j = xV();
    AppMethodBeat.o(240545);
    return i + j;
  }
  
  private int xV()
  {
    AppMethodBeat.i(240547);
    if (!this.bGC)
    {
      AppMethodBeat.o(240547);
      return 0;
    }
    switch (this.boxBackgroundMode)
    {
    default: 
      AppMethodBeat.o(240547);
      return 0;
    case 2: 
      i = (int)(this.bvo.xj() / 2.0F);
      AppMethodBeat.o(240547);
      return i;
    }
    int i = (int)this.bvo.xj();
    AppMethodBeat.o(240547);
    return i;
  }
  
  private void xW()
  {
    AppMethodBeat.i(240551);
    if (this.bGw == null)
    {
      AppMethodBeat.o(240551);
      return;
    }
    Object localObject2 = this.bGw.getBackground();
    if (localObject2 == null)
    {
      AppMethodBeat.o(240551);
      return;
    }
    Object localObject1 = localObject2;
    if (o.i((Drawable)localObject2)) {
      localObject1 = ((Drawable)localObject2).mutate();
    }
    localObject2 = new Rect();
    com.google.android.material.internal.d.a(this, this.bGw, (Rect)localObject2);
    localObject2 = ((Drawable)localObject1).getBounds();
    if (((Rect)localObject2).left != ((Rect)localObject2).right)
    {
      Rect localRect = new Rect();
      ((Drawable)localObject1).getPadding(localRect);
      int i = ((Rect)localObject2).left;
      int j = localRect.left;
      int k = ((Rect)localObject2).right;
      int m = localRect.right;
      ((Drawable)localObject1).setBounds(i - j, ((Rect)localObject2).top, m * 2 + k, this.bGw.getBottom());
    }
    AppMethodBeat.o(240551);
  }
  
  private void xX()
  {
    AppMethodBeat.i(240553);
    switch (this.boxBackgroundMode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(240553);
      return;
      this.bGN = 0;
      AppMethodBeat.o(240553);
      return;
      if (this.bHh == 0) {
        this.bHh = this.bHe.getColorForState(getDrawableState(), this.bHe.getDefaultColor());
      }
    }
  }
  
  private void xY()
  {
    AppMethodBeat.i(240555);
    if (this.bGF == null)
    {
      AppMethodBeat.o(240555);
      return;
    }
    xX();
    if ((this.bGw != null) && (this.boxBackgroundMode == 2))
    {
      if (this.bGw.getBackground() != null) {
        this.bGQ = this.bGw.getBackground();
      }
      w.a(this.bGw, null);
    }
    if ((this.bGw != null) && (this.boxBackgroundMode == 1) && (this.bGQ != null)) {
      w.a(this.bGw, this.bGQ);
    }
    if ((this.bGN >= 0) && (this.boxStrokeColor != 0)) {
      this.bGF.setStroke(this.bGN, this.boxStrokeColor);
    }
    this.bGF.setCornerRadii(getCornerRadiiAsArray());
    this.bGF.setColor(this.boxBackgroundColor);
    invalidate();
    AppMethodBeat.o(240555);
  }
  
  private void ya()
  {
    AppMethodBeat.i(240557);
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22))
    {
      AppMethodBeat.o(240557);
      return;
    }
    Drawable localDrawable1 = this.bGw.getBackground();
    if (localDrawable1 == null)
    {
      AppMethodBeat.o(240557);
      return;
    }
    if (!this.bHl)
    {
      Drawable localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.bHl = e.a((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
      if (!this.bHl)
      {
        w.a(this.bGw, localDrawable2);
        this.bHl = true;
        xQ();
      }
    }
    AppMethodBeat.o(240557);
  }
  
  private void yb()
  {
    AppMethodBeat.i(240571);
    if (this.bGw == null)
    {
      AppMethodBeat.o(240571);
      return;
    }
    Drawable[] arrayOfDrawable;
    if (yd())
    {
      if (this.bGV == null)
      {
        this.bGV = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(a.h.design_text_input_password_icon, this.bGv, false));
        this.bGV.setImageDrawable(this.bGT);
        this.bGV.setContentDescription(this.bGU);
        this.bGv.addView(this.bGV);
        this.bGV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(240291);
            TextInputLayout.this.bj(false);
            AppMethodBeat.o(240291);
          }
        });
      }
      if ((this.bGw != null) && (w.P(this.bGw) <= 0)) {
        this.bGw.setMinimumHeight(w.P(this.bGV));
      }
      this.bGV.setVisibility(0);
      this.bGV.setChecked(this.bGW);
      if (this.bGX == null) {
        this.bGX = new ColorDrawable();
      }
      this.bGX.setBounds(0, 0, this.bGV.getMeasuredWidth(), 1);
      arrayOfDrawable = i.b(this.bGw);
      if (arrayOfDrawable[2] != this.bGX) {
        this.bGY = arrayOfDrawable[2];
      }
      i.a(this.bGw, arrayOfDrawable[0], arrayOfDrawable[1], this.bGX, arrayOfDrawable[3]);
      this.bGV.setPadding(this.bGw.getPaddingLeft(), this.bGw.getPaddingTop(), this.bGw.getPaddingRight(), this.bGw.getPaddingBottom());
      AppMethodBeat.o(240571);
      return;
    }
    if ((this.bGV != null) && (this.bGV.getVisibility() == 0)) {
      this.bGV.setVisibility(8);
    }
    if (this.bGX != null)
    {
      arrayOfDrawable = i.b(this.bGw);
      if (arrayOfDrawable[2] == this.bGX)
      {
        i.a(this.bGw, arrayOfDrawable[0], arrayOfDrawable[1], this.bGY, arrayOfDrawable[3]);
        this.bGX = null;
      }
    }
    AppMethodBeat.o(240571);
  }
  
  private boolean yc()
  {
    AppMethodBeat.i(240592);
    if ((this.bGw != null) && ((this.bGw.getTransformationMethod() instanceof PasswordTransformationMethod)))
    {
      AppMethodBeat.o(240592);
      return true;
    }
    AppMethodBeat.o(240592);
    return false;
  }
  
  private boolean yd()
  {
    AppMethodBeat.i(240595);
    if ((this.bGS) && ((yc()) || (this.bGW)))
    {
      AppMethodBeat.o(240595);
      return true;
    }
    AppMethodBeat.o(240595);
    return false;
  }
  
  private void ye()
  {
    AppMethodBeat.i(240597);
    if ((this.bGT != null) && ((this.bHa) || (this.bHc)))
    {
      this.bGT = androidx.core.graphics.drawable.a.p(this.bGT).mutate();
      if (this.bHa) {
        androidx.core.graphics.drawable.a.a(this.bGT, this.bGZ);
      }
      if (this.bHc) {
        androidx.core.graphics.drawable.a.a(this.bGT, this.bHb);
      }
      if ((this.bGV != null) && (this.bGV.getDrawable() != this.bGT)) {
        this.bGV.setImageDrawable(this.bGT);
      }
    }
    AppMethodBeat.o(240597);
  }
  
  private boolean yf()
  {
    AppMethodBeat.i(240604);
    if ((this.bGC) && (!TextUtils.isEmpty(this.bGD)) && ((this.bGF instanceof a)))
    {
      AppMethodBeat.o(240604);
      return true;
    }
    AppMethodBeat.o(240604);
    return false;
  }
  
  private void yg()
  {
    AppMethodBeat.i(240606);
    if (!yf())
    {
      AppMethodBeat.o(240606);
      return;
    }
    RectF localRectF = this.bGR;
    this.bvo.b(localRectF);
    d(localRectF);
    ((a)this.bGF).c(localRectF);
    AppMethodBeat.o(240606);
  }
  
  private void yh()
  {
    AppMethodBeat.i(240607);
    if (yf()) {
      ((a)this.bGF).k(0.0F, 0.0F, 0.0F, 0.0F);
    }
    AppMethodBeat.o(240607);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(240448);
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.bGv.addView(paramView, localLayoutParams);
      this.bGv.setLayoutParams(paramLayoutParams);
      xS();
      setEditText((EditText)paramView);
      AppMethodBeat.o(240448);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(240448);
  }
  
  public final void bj(boolean paramBoolean)
  {
    AppMethodBeat.i(240588);
    int i;
    if (this.bGS)
    {
      i = this.bGw.getSelectionEnd();
      if (!yc()) {
        break label78;
      }
      this.bGw.setTransformationMethod(null);
    }
    for (this.bGW = true;; this.bGW = false)
    {
      this.bGV.setChecked(this.bGW);
      if (paramBoolean) {
        this.bGV.jumpDrawablesToCurrentState();
      }
      this.bGw.setSelection(i);
      AppMethodBeat.o(240588);
      return;
      label78:
      this.bGw.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(240475);
    if ((this.bGx == null) || (this.bGw == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      AppMethodBeat.o(240475);
      return;
    }
    boolean bool = this.bGE;
    this.bGE = false;
    CharSequence localCharSequence = this.bGw.getHint();
    this.bGw.setHint(this.bGx);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.bGw.setHint(localCharSequence);
      this.bGE = bool;
      AppMethodBeat.o(240475);
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    AppMethodBeat.i(240561);
    this.bHn = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.bHn = false;
    AppMethodBeat.o(240561);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(240565);
    if (this.bGF != null) {
      this.bGF.draw(paramCanvas);
    }
    super.draw(paramCanvas);
    if (this.bGC) {
      this.bvo.draw(paramCanvas);
    }
    AppMethodBeat.o(240565);
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    AppMethodBeat.i(240609);
    if (this.bHm)
    {
      AppMethodBeat.o(240609);
      return;
    }
    this.bHm = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((w.ah(this)) && (isEnabled()))
    {
      i(bool2, false);
      xZ();
      xT();
      yi();
      if (this.bvo == null) {
        break label111;
      }
    }
    label111:
    for (boolean bool1 = this.bvo.setState(arrayOfInt) | false;; bool1 = false)
    {
      if (bool1) {
        invalidate();
      }
      this.bHm = false;
      AppMethodBeat.o(240609);
      return;
      bool2 = false;
      break;
    }
  }
  
  final void g(TextView paramTextView, int paramInt)
  {
    i = 1;
    AppMethodBeat.i(240542);
    try
    {
      i.a(paramTextView, paramInt);
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
      i.a(paramTextView, a.j.TextAppearance_AppCompat_Caption);
      paramTextView.setTextColor(androidx.core.content.a.w(getContext(), a.c.design_error));
    }
    AppMethodBeat.o(240542);
  }
  
  public int getBoxBackgroundColor()
  {
    return this.boxBackgroundColor;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.bGL;
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.bGM;
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.bGK;
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.bGJ;
  }
  
  public int getBoxStrokeColor()
  {
    return this.bHh;
  }
  
  public int getCounterMaxLength()
  {
    return this.counterMaxLength;
  }
  
  CharSequence getCounterOverflowDescription()
  {
    AppMethodBeat.i(240537);
    if ((this.bGz) && (this.bGA) && (this.bGB != null))
    {
      CharSequence localCharSequence = this.bGB.getContentDescription();
      AppMethodBeat.o(240537);
      return localCharSequence;
    }
    AppMethodBeat.o(240537);
    return null;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.bHd;
  }
  
  public EditText getEditText()
  {
    return this.bGw;
  }
  
  public CharSequence getError()
  {
    if (this.bGy.bGk) {
      return this.bGy.bGj;
    }
    return null;
  }
  
  public int getErrorCurrentTextColors()
  {
    AppMethodBeat.i(240506);
    int i = this.bGy.xO();
    AppMethodBeat.o(240506);
    return i;
  }
  
  final int getErrorTextCurrentColor()
  {
    AppMethodBeat.i(240623);
    int i = this.bGy.xO();
    AppMethodBeat.o(240623);
    return i;
  }
  
  public CharSequence getHelperText()
  {
    if (this.bGy.bGn) {
      return this.bGy.bGm;
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    AppMethodBeat.i(240516);
    b localb = this.bGy;
    if (localb.bGo != null)
    {
      int i = localb.bGo.getCurrentTextColor();
      AppMethodBeat.o(240516);
      return i;
    }
    AppMethodBeat.o(240516);
    return -1;
  }
  
  public CharSequence getHint()
  {
    if (this.bGC) {
      return this.bGD;
    }
    return null;
  }
  
  final float getHintCollapsedTextHeight()
  {
    AppMethodBeat.i(240620);
    float f = this.bvo.xj();
    AppMethodBeat.o(240620);
    return f;
  }
  
  final int getHintCurrentCollapsedTextColor()
  {
    AppMethodBeat.i(240617);
    int i = this.bvo.xn();
    AppMethodBeat.o(240617);
    return i;
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.bGU;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.bGT;
  }
  
  public Typeface getTypeface()
  {
    return this.bGp;
  }
  
  final void go(int paramInt)
  {
    AppMethodBeat.i(240540);
    boolean bool2 = this.bGA;
    if (this.counterMaxLength == -1)
    {
      this.bGB.setText(String.valueOf(paramInt));
      this.bGB.setContentDescription(null);
      this.bGA = false;
      if ((this.bGw != null) && (bool2 != this.bGA))
      {
        i(false, false);
        yi();
        xZ();
      }
      AppMethodBeat.o(240540);
      return;
    }
    if (w.K(this.bGB) == 1) {
      w.r(this.bGB, 0);
    }
    boolean bool1;
    label110:
    TextView localTextView;
    if (paramInt > this.counterMaxLength)
    {
      bool1 = true;
      this.bGA = bool1;
      if (bool2 != this.bGA)
      {
        localTextView = this.bGB;
        if (!this.bGA) {
          break label248;
        }
      }
    }
    label248:
    for (int i = this.counterOverflowTextAppearance;; i = this.counterTextAppearance)
    {
      g(localTextView, i);
      if (this.bGA) {
        w.r(this.bGB, 1);
      }
      this.bGB.setText(getContext().getString(a.i.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.counterMaxLength) }));
      this.bGB.setContentDescription(getContext().getString(a.i.character_counter_content_description, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.counterMaxLength) }));
      break;
      bool1 = false;
      break label110;
    }
  }
  
  final void i(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(240483);
    boolean bool1 = isEnabled();
    int i;
    label54:
    boolean bool2;
    if ((this.bGw != null) && (!TextUtils.isEmpty(this.bGw.getText())))
    {
      i = 1;
      if ((this.bGw == null) || (!this.bGw.hasFocus())) {
        break label174;
      }
      bool2 = this.bGy.xN();
      if (this.bHd != null)
      {
        this.bvo.e(this.bHd);
        this.bvo.f(this.bHd);
      }
      if (bool1) {
        break label180;
      }
      this.bvo.e(ColorStateList.valueOf(this.bHi));
      this.bvo.f(ColorStateList.valueOf(this.bHi));
    }
    for (;;)
    {
      if ((i == 0) && ((!isEnabled()) || ((j == 0) && (!bool2)))) {
        break label259;
      }
      if ((!paramBoolean2) && (!this.bHj)) {
        break label275;
      }
      bk(paramBoolean1);
      AppMethodBeat.o(240483);
      return;
      i = 0;
      break;
      label174:
      j = 0;
      break label54;
      label180:
      if (bool2) {
        this.bvo.e(this.bGy.xP());
      } else if ((this.bGA) && (this.bGB != null)) {
        this.bvo.e(this.bGB.getTextColors());
      } else if ((j != 0) && (this.bHe != null)) {
        this.bvo.e(this.bHe);
      }
    }
    label259:
    if ((paramBoolean2) || (!this.bHj)) {
      bl(paramBoolean1);
    }
    label275:
    AppMethodBeat.o(240483);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240599);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.bGF != null) {
      xT();
    }
    Rect localRect;
    int i;
    if ((this.bGC) && (this.bGw != null))
    {
      localRect = this.bvn;
      com.google.android.material.internal.d.a(this, this.bGw, localRect);
      paramInt1 = localRect.left;
      paramInt3 = this.bGw.getCompoundPaddingLeft() + paramInt1;
      i = localRect.right - this.bGw.getCompoundPaddingRight();
      switch (this.boxBackgroundMode)
      {
      default: 
        paramInt1 = getPaddingTop();
      }
    }
    for (;;)
    {
      this.bvo.p(paramInt3, localRect.top + this.bGw.getCompoundPaddingTop(), i, localRect.bottom - this.bGw.getCompoundPaddingBottom());
      this.bvo.q(paramInt3, paramInt1, i, paramInt4 - paramInt2 - getPaddingBottom());
      this.bvo.xq();
      if ((yf()) && (!this.bHj)) {
        yg();
      }
      AppMethodBeat.o(240599);
      return;
      paramInt1 = getBoxBackground().getBounds().top - xV();
      continue;
      paramInt1 = getBoxBackground().getBounds().top + this.bGI;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240567);
    yb();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(240567);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(240560);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(240560);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    setError(paramParcelable.bHq);
    if (paramParcelable.bHr) {
      bj(true);
    }
    requestLayout();
    AppMethodBeat.o(240560);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(240558);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.bGy.xN()) {
      localSavedState.bHq = getError();
    }
    localSavedState.bHr = this.bGW;
    AppMethodBeat.o(240558);
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(240465);
    if (this.boxBackgroundColor != paramInt)
    {
      this.boxBackgroundColor = paramInt;
      xY();
    }
    AppMethodBeat.o(240465);
  }
  
  public void setBoxBackgroundColorResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(240463);
    setBoxBackgroundColor(androidx.core.content.a.w(getContext(), paramInt));
    AppMethodBeat.o(240463);
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    AppMethodBeat.i(240455);
    if (paramInt == this.boxBackgroundMode)
    {
      AppMethodBeat.o(240455);
      return;
    }
    this.boxBackgroundMode = paramInt;
    xQ();
    AppMethodBeat.o(240455);
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    AppMethodBeat.i(240462);
    if (this.bHh != paramInt)
    {
      this.bHh = paramInt;
      yi();
    }
    AppMethodBeat.o(240462);
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(240523);
    if (this.bGz != paramBoolean)
    {
      if (!paramBoolean) {
        break label136;
      }
      this.bGB = new AppCompatTextView(getContext());
      this.bGB.setId(a.f.textinput_counter);
      if (this.bGp != null) {
        this.bGB.setTypeface(this.bGp);
      }
      this.bGB.setMaxLines(1);
      g(this.bGB, this.counterTextAppearance);
      this.bGy.e(this.bGB, 2);
      if (this.bGw != null) {
        break label117;
      }
      go(0);
    }
    for (;;)
    {
      this.bGz = paramBoolean;
      AppMethodBeat.o(240523);
      return;
      label117:
      go(this.bGw.getText().length());
      continue;
      label136:
      this.bGy.f(this.bGB, 2);
      this.bGB = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    AppMethodBeat.i(240526);
    if (this.counterMaxLength != paramInt)
    {
      if (paramInt <= 0) {
        break label51;
      }
      this.counterMaxLength = paramInt;
      if (this.bGz) {
        if (this.bGw != null) {
          break label59;
        }
      }
    }
    label51:
    label59:
    for (paramInt = 0;; paramInt = this.bGw.getText().length())
    {
      go(paramInt);
      AppMethodBeat.o(240526);
      return;
      this.counterMaxLength = -1;
      break;
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240500);
    this.bHd = paramColorStateList;
    this.bHe = paramColorStateList;
    if (this.bGw != null) {
      i(false, false);
    }
    AppMethodBeat.o(240500);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(240530);
    d(this, paramBoolean);
    super.setEnabled(paramBoolean);
    AppMethodBeat.o(240530);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240519);
    if (!this.bGy.bGk)
    {
      if (TextUtils.isEmpty(paramCharSequence))
      {
        AppMethodBeat.o(240519);
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      b localb = this.bGy;
      localb.xL();
      localb.bGj = paramCharSequence;
      localb.bGl.setText(paramCharSequence);
      if (localb.bGh != 1) {
        localb.bGi = 1;
      }
      localb.g(localb.bGh, localb.bGi, localb.b(localb.bGl, paramCharSequence));
      AppMethodBeat.o(240519);
      return;
    }
    this.bGy.xK();
    AppMethodBeat.o(240519);
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(240502);
    b localb = this.bGy;
    if (localb.bGk != paramBoolean)
    {
      localb.xL();
      if (!paramBoolean) {
        break label115;
      }
      localb.bGl = new AppCompatTextView(localb.context);
      localb.bGl.setId(a.f.textinput_error);
      if (localb.bGp != null) {
        localb.bGl.setTypeface(localb.bGp);
      }
      localb.setErrorTextAppearance(localb.errorTextAppearance);
      localb.bGl.setVisibility(4);
      w.r(localb.bGl, 1);
      localb.e(localb.bGl, 0);
    }
    for (;;)
    {
      localb.bGk = paramBoolean;
      AppMethodBeat.o(240502);
      return;
      label115:
      localb.xK();
      localb.f(localb.bGl, 0);
      localb.bGl = null;
      localb.bGa.xZ();
      localb.bGa.yi();
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    AppMethodBeat.i(240504);
    this.bGy.setErrorTextAppearance(paramInt);
    AppMethodBeat.o(240504);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240505);
    b localb = this.bGy;
    if (localb.bGl != null) {
      localb.bGl.setTextColor(paramColorStateList);
    }
    AppMethodBeat.o(240505);
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240512);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (this.bGy.bGn)
      {
        setHelperTextEnabled(false);
        AppMethodBeat.o(240512);
      }
    }
    else
    {
      if (!this.bGy.bGn) {
        setHelperTextEnabled(true);
      }
      b localb = this.bGy;
      localb.xL();
      localb.bGm = paramCharSequence;
      localb.bGo.setText(paramCharSequence);
      if (localb.bGh != 2) {
        localb.bGi = 2;
      }
      localb.g(localb.bGh, localb.bGi, localb.b(localb.bGo, paramCharSequence));
    }
    AppMethodBeat.o(240512);
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240514);
    b localb = this.bGy;
    if (localb.bGo != null) {
      localb.bGo.setTextColor(paramColorStateList);
    }
    AppMethodBeat.o(240514);
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(240510);
    b localb = this.bGy;
    if (localb.bGn != paramBoolean)
    {
      localb.xL();
      if (!paramBoolean) {
        break label115;
      }
      localb.bGo = new AppCompatTextView(localb.context);
      localb.bGo.setId(a.f.textinput_helper_text);
      if (localb.bGp != null) {
        localb.bGo.setTypeface(localb.bGp);
      }
      localb.bGo.setVisibility(4);
      w.r(localb.bGo, 1);
      localb.gn(localb.helperTextTextAppearance);
      localb.e(localb.bGo, 1);
    }
    for (;;)
    {
      localb.bGn = paramBoolean;
      AppMethodBeat.o(240510);
      return;
      label115:
      localb.xL();
      if (localb.bGh == 2) {
        localb.bGi = 0;
      }
      localb.g(localb.bGh, localb.bGi, localb.b(localb.bGo, null));
      localb.f(localb.bGo, 1);
      localb.bGo = null;
      localb.bGa.xZ();
      localb.bGa.yi();
    }
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    AppMethodBeat.i(240507);
    this.bGy.gn(paramInt);
    AppMethodBeat.o(240507);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240487);
    if (this.bGC)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
    AppMethodBeat.o(240487);
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.bHk = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(240492);
    if (paramBoolean != this.bGC)
    {
      this.bGC = paramBoolean;
      if (this.bGC) {
        break label88;
      }
      this.bGE = false;
      if ((!TextUtils.isEmpty(this.bGD)) && (TextUtils.isEmpty(this.bGw.getHint()))) {
        this.bGw.setHint(this.bGD);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (this.bGw != null) {
        xS();
      }
      AppMethodBeat.o(240492);
      return;
      label88:
      CharSequence localCharSequence = this.bGw.getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.bGD)) {
          setHint(localCharSequence);
        }
        this.bGw.setHint(null);
      }
      this.bGE = true;
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    AppMethodBeat.i(240496);
    this.bvo.fX(paramInt);
    this.bHe = this.bvo.bBE;
    if (this.bGw != null)
    {
      i(false, false);
      xS();
    }
    AppMethodBeat.o(240496);
  }
  
  public void setPasswordVisibilityToggleContentDescription(int paramInt)
  {
    AppMethodBeat.i(240577);
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getResources().getText(paramInt);; localCharSequence = null)
    {
      setPasswordVisibilityToggleContentDescription(localCharSequence);
      AppMethodBeat.o(240577);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(240578);
    this.bGU = paramCharSequence;
    if (this.bGV != null) {
      this.bGV.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(240578);
  }
  
  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    AppMethodBeat.i(240573);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.appcompat.a.a.a.m(getContext(), paramInt);; localDrawable = null)
    {
      setPasswordVisibilityToggleDrawable(localDrawable);
      AppMethodBeat.o(240573);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240575);
    this.bGT = paramDrawable;
    if (this.bGV != null) {
      this.bGV.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(240575);
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(240581);
    if (this.bGS != paramBoolean)
    {
      this.bGS = paramBoolean;
      if ((!paramBoolean) && (this.bGW) && (this.bGw != null)) {
        this.bGw.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      this.bGW = false;
      yb();
    }
    AppMethodBeat.o(240581);
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240583);
    this.bGZ = paramColorStateList;
    this.bHa = true;
    ye();
    AppMethodBeat.o(240583);
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240585);
    this.bHb = paramMode;
    this.bHc = true;
    ye();
    AppMethodBeat.o(240585);
  }
  
  public void setTextInputAccessibilityDelegate(a parama)
  {
    AppMethodBeat.i(240590);
    if (this.bGw != null) {
      w.a(this.bGw, parama);
    }
    AppMethodBeat.o(240590);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(240472);
    if (paramTypeface != this.bGp)
    {
      this.bGp = paramTypeface;
      this.bvo.c(paramTypeface);
      b localb = this.bGy;
      if (paramTypeface != localb.bGp)
      {
        localb.bGp = paramTypeface;
        b.a(localb.bGl, paramTypeface);
        b.a(localb.bGo, paramTypeface);
      }
      if (this.bGB != null) {
        this.bGB.setTypeface(paramTypeface);
      }
    }
    AppMethodBeat.o(240472);
  }
  
  final void xZ()
  {
    AppMethodBeat.i(240556);
    if (this.bGw == null)
    {
      AppMethodBeat.o(240556);
      return;
    }
    Drawable localDrawable2 = this.bGw.getBackground();
    if (localDrawable2 == null)
    {
      AppMethodBeat.o(240556);
      return;
    }
    ya();
    Drawable localDrawable1 = localDrawable2;
    if (o.i(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if (this.bGy.xN())
    {
      localDrawable1.setColorFilter(f.a(this.bGy.xO(), PorterDuff.Mode.SRC_IN));
      AppMethodBeat.o(240556);
      return;
    }
    if ((this.bGA) && (this.bGB != null))
    {
      localDrawable1.setColorFilter(f.a(this.bGB.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      AppMethodBeat.o(240556);
      return;
    }
    androidx.core.graphics.drawable.a.o(localDrawable1);
    this.bGw.refreshDrawableState();
    AppMethodBeat.o(240556);
  }
  
  final void yi()
  {
    int j = 1;
    AppMethodBeat.i(240611);
    if ((this.bGF == null) || (this.boxBackgroundMode == 0))
    {
      AppMethodBeat.o(240611);
      return;
    }
    int i;
    if ((this.bGw != null) && (this.bGw.hasFocus()))
    {
      i = 1;
      if ((this.bGw == null) || (!this.bGw.isHovered())) {
        break label127;
      }
      label65:
      if (this.boxBackgroundMode == 2)
      {
        if (isEnabled()) {
          break label132;
        }
        this.boxStrokeColor = this.bHi;
        label88:
        if (((j == 0) && (i == 0)) || (!isEnabled())) {
          break label225;
        }
      }
    }
    label132:
    label225:
    for (this.bGN = this.bGP;; this.bGN = this.bGO)
    {
      xY();
      AppMethodBeat.o(240611);
      return;
      i = 0;
      break;
      label127:
      j = 0;
      break label65;
      if (this.bGy.xN())
      {
        this.boxStrokeColor = this.bGy.xO();
        break label88;
      }
      if ((this.bGA) && (this.bGB != null))
      {
        this.boxStrokeColor = this.bGB.getCurrentTextColor();
        break label88;
      }
      if (i != 0)
      {
        this.boxStrokeColor = this.bHh;
        break label88;
      }
      if (j != 0)
      {
        this.boxStrokeColor = this.bHg;
        break label88;
      }
      this.boxStrokeColor = this.bHf;
      break label88;
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    CharSequence bHq;
    boolean bHr;
    
    static
    {
      AppMethodBeat.i(240339);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(240339);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(240332);
      this.bHq = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      if (paramParcel.readInt() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.bHr = bool;
        AppMethodBeat.o(240332);
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(240337);
      String str = "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.bHq + "}";
      AppMethodBeat.o(240337);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(240334);
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.bHq, paramParcel, paramInt);
      if (this.bHr) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(240334);
        return;
      }
    }
  }
  
  public static class a
    extends androidx.core.g.a
  {
    private final TextInputLayout bHp;
    
    public a(TextInputLayout paramTextInputLayout)
    {
      this.bHp = paramTextInputLayout;
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, androidx.core.g.a.d paramd)
    {
      AppMethodBeat.i(240315);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      paramView = this.bHp.getEditText();
      CharSequence localCharSequence3;
      CharSequence localCharSequence1;
      CharSequence localCharSequence2;
      int i;
      label64:
      int j;
      label75:
      int k;
      label86:
      int m;
      label102:
      label111:
      boolean bool;
      if (paramView != null)
      {
        paramView = paramView.getText();
        localCharSequence3 = this.bHp.getHint();
        localCharSequence1 = this.bHp.getError();
        localCharSequence2 = this.bHp.getCounterOverflowDescription();
        if (TextUtils.isEmpty(paramView)) {
          break label218;
        }
        i = 1;
        if (TextUtils.isEmpty(localCharSequence3)) {
          break label223;
        }
        j = 1;
        if (TextUtils.isEmpty(localCharSequence1)) {
          break label229;
        }
        k = 1;
        if ((k == 0) && (TextUtils.isEmpty(localCharSequence2))) {
          break label235;
        }
        m = 1;
        if (i == 0) {
          break label241;
        }
        paramd.setText(paramView);
        if (j != 0)
        {
          if (Build.VERSION.SDK_INT < 26) {
            break label255;
          }
          paramd.Ov.setHintText(localCharSequence3);
          label133:
          if ((i != 0) || (j == 0)) {
            break label280;
          }
          bool = true;
          label145:
          if (Build.VERSION.SDK_INT < 26) {
            break label286;
          }
          paramd.Ov.setShowingHintText(bool);
        }
        label162:
        if (m != 0) {
          if (k == 0) {
            break label296;
          }
        }
      }
      label280:
      label286:
      label296:
      for (paramView = localCharSequence1;; paramView = localCharSequence2)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramd.Ov.setError(paramView);
        }
        if (Build.VERSION.SDK_INT >= 19) {
          paramd.Ov.setContentInvalid(true);
        }
        AppMethodBeat.o(240315);
        return;
        paramView = null;
        break;
        label218:
        i = 0;
        break label64;
        label223:
        j = 0;
        break label75;
        label229:
        k = 0;
        break label86;
        label235:
        m = 0;
        break label102;
        label241:
        if (j == 0) {
          break label111;
        }
        paramd.setText(localCharSequence3);
        break label111;
        label255:
        if (Build.VERSION.SDK_INT < 19) {
          break label133;
        }
        paramd.Ov.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", localCharSequence3);
        break label133;
        bool = false;
        break label145;
        paramd.f(4, bool);
        break label162;
      }
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(240318);
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = this.bHp.getEditText();
      if (paramView != null) {}
      for (paramView = paramView.getText();; paramView = null)
      {
        Object localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = this.bHp.getHint();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramAccessibilityEvent.getText().add(localObject);
        }
        AppMethodBeat.o(240318);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */