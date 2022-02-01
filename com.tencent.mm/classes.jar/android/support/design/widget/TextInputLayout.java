package android.support.design.widget;

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
import android.support.design.a.a;
import android.support.v4.content.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.az;
import android.support.v7.widget.x;
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
import java.util.List;

public class TextInputLayout
  extends LinearLayout
{
  private ValueAnimator animator;
  private CharSequence hint;
  private final Rect mC = new Rect();
  final d pP = new d(this);
  private Typeface sB;
  private final j vA = new j(this);
  boolean vB;
  private int vC;
  private boolean vD;
  private TextView vE;
  private final int vF;
  private final int vG;
  private boolean vH;
  boolean vI;
  private GradientDrawable vJ;
  private final int vK;
  private final int vL;
  private int vM;
  private final int vN;
  private float vO;
  private float vP;
  private float vQ;
  private float vR;
  private int vS;
  private final int vT;
  private final int vU;
  private int vV;
  private int vW;
  private Drawable vX;
  private final RectF vY = new RectF();
  private boolean vZ;
  private final FrameLayout vx;
  EditText vy;
  private CharSequence vz;
  private Drawable wa;
  private CharSequence wb;
  private CheckableImageButton wd;
  private boolean we;
  private Drawable wf;
  private Drawable wg;
  private ColorStateList wh;
  private boolean wi;
  private PorterDuff.Mode wj;
  private boolean wk;
  private ColorStateList wl;
  private ColorStateList wm;
  private final int wn;
  private final int wo;
  private int wp;
  private final int wq;
  private boolean wr;
  private boolean ws;
  private boolean wt;
  private boolean wv;
  private boolean ww;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969649);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.vx = new FrameLayout(paramContext);
    this.vx.setAddStatesFromChildren(true);
    addView(this.vx);
    this.pP.a(android.support.design.a.a.gK);
    Object localObject = this.pP;
    ((d)localObject).pw = android.support.design.a.a.gK;
    ((d)localObject).cp();
    this.pP.N(8388659);
    paramAttributeSet = android.support.design.internal.f.b(paramContext, paramAttributeSet, a.a.TextInputLayout, paramInt, 2131821690, new int[0]);
    this.vH = paramAttributeSet.getBoolean(21, true);
    setHint(paramAttributeSet.getText(1));
    this.ws = paramAttributeSet.getBoolean(20, true);
    this.vK = paramContext.getResources().getDimensionPixelOffset(2131166760);
    this.vL = paramContext.getResources().getDimensionPixelOffset(2131166763);
    this.vN = paramAttributeSet.getDimensionPixelOffset(4, 0);
    this.vO = paramAttributeSet.cV(8);
    this.vP = paramAttributeSet.cV(7);
    this.vQ = paramAttributeSet.cV(5);
    this.vR = paramAttributeSet.cV(6);
    this.vW = paramAttributeSet.getColor(2, 0);
    this.wp = paramAttributeSet.getColor(9, 0);
    this.vT = paramContext.getResources().getDimensionPixelSize(2131166765);
    this.vU = paramContext.getResources().getDimensionPixelSize(2131166766);
    this.vS = this.vT;
    setBoxBackgroundMode(paramAttributeSet.getInt(3, 0));
    if (paramAttributeSet.hasValue(0))
    {
      localObject = paramAttributeSet.getColorStateList(0);
      this.wm = ((ColorStateList)localObject);
      this.wl = ((ColorStateList)localObject);
    }
    this.wn = b.n(paramContext, 2131100848);
    this.wq = b.n(paramContext, 2131100849);
    this.wo = b.n(paramContext, 2131100851);
    if (paramAttributeSet.getResourceId(22, -1) != -1) {
      setHintTextAppearance(paramAttributeSet.getResourceId(22, 0));
    }
    paramInt = paramAttributeSet.getResourceId(16, 0);
    boolean bool1 = paramAttributeSet.getBoolean(15, false);
    int i = paramAttributeSet.getResourceId(19, 0);
    boolean bool2 = paramAttributeSet.getBoolean(18, false);
    paramContext = paramAttributeSet.getText(17);
    boolean bool3 = paramAttributeSet.getBoolean(11, false);
    setCounterMaxLength(paramAttributeSet.getInt(12, -1));
    this.vG = paramAttributeSet.getResourceId(14, 0);
    this.vF = paramAttributeSet.getResourceId(13, 0);
    this.vZ = paramAttributeSet.getBoolean(25, false);
    this.wa = paramAttributeSet.getDrawable(24);
    this.wb = paramAttributeSet.getText(23);
    if (paramAttributeSet.hasValue(26))
    {
      this.wi = true;
      this.wh = paramAttributeSet.getColorStateList(26);
    }
    if (paramAttributeSet.hasValue(27))
    {
      this.wk = true;
      this.wj = android.support.design.internal.g.a(paramAttributeSet.getInt(27, -1), null);
    }
    paramAttributeSet.ayy.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(paramContext);
    setHelperTextTextAppearance(i);
    setErrorEnabled(bool1);
    setErrorTextAppearance(paramInt);
    setCounterEnabled(bool3);
    ds();
    u.p(this, 2);
  }
  
  private void A(boolean paramBoolean)
  {
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.ws)) {
      v(0.0F);
    }
    for (;;)
    {
      if ((dt()) && (((e)this.vJ).cz())) {
        dv();
      }
      this.wr = true;
      return;
      this.pP.k(0.0F);
    }
  }
  
  private static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void c(RectF paramRectF)
  {
    paramRectF.left -= this.vL;
    paramRectF.top -= this.vL;
    paramRectF.right += this.vL;
    paramRectF.bottom += this.vL;
  }
  
  private void de()
  {
    df();
    if (this.vM != 0) {
      dg();
    }
    dh();
  }
  
  private void df()
  {
    if (this.vM == 0) {
      this.vJ = null;
    }
    do
    {
      return;
      if ((this.vM == 2) && (this.vH) && (!(this.vJ instanceof e)))
      {
        this.vJ = new e();
        return;
      }
    } while ((this.vJ instanceof GradientDrawable));
    this.vJ = new GradientDrawable();
  }
  
  private void dg()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vx.getLayoutParams();
    int i = dj();
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.vx.requestLayout();
    }
  }
  
  private void dh()
  {
    if ((this.vM == 0) || (this.vJ == null) || (this.vy == null) || (getRight() == 0)) {
      return;
    }
    int i3 = this.vy.getLeft();
    int i2 = di();
    int i1 = this.vy.getRight();
    int n = this.vy.getBottom() + this.vK;
    int m = n;
    int k = i1;
    int j = i2;
    int i = i3;
    if (this.vM == 2)
    {
      i = i3 + this.vU / 2;
      j = i2 - this.vU / 2;
      k = i1 - this.vU / 2;
      m = n + this.vU / 2;
    }
    this.vJ.setBounds(i, j, k, m);
    dm();
    dk();
  }
  
  private int di()
  {
    if (this.vy == null) {
      return 0;
    }
    switch (this.vM)
    {
    default: 
      return 0;
    case 1: 
      return this.vy.getTop();
    }
    return this.vy.getTop() + dj();
  }
  
  private int dj()
  {
    if (!this.vH) {
      return 0;
    }
    switch (this.vM)
    {
    default: 
      return 0;
    case 0: 
    case 1: 
      return (int)this.pP.ci();
    }
    return (int)(this.pP.ci() / 2.0F);
  }
  
  private void dk()
  {
    if (this.vy == null) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = this.vy.getBackground();
      } while (localObject2 == null);
      localObject1 = localObject2;
      if (x.t((Drawable)localObject2)) {
        localObject1 = ((Drawable)localObject2).mutate();
      }
      localObject2 = new Rect();
      f.a(this, this.vy, (Rect)localObject2);
      localObject2 = ((Drawable)localObject1).getBounds();
    } while (((Rect)localObject2).left == ((Rect)localObject2).right);
    Rect localRect = new Rect();
    ((Drawable)localObject1).getPadding(localRect);
    int i = ((Rect)localObject2).left;
    int j = localRect.left;
    int k = ((Rect)localObject2).right;
    int m = localRect.right;
    ((Drawable)localObject1).setBounds(i - j, ((Rect)localObject2).top, m * 2 + k, this.vy.getBottom());
  }
  
  private void dl()
  {
    switch (this.vM)
    {
    }
    do
    {
      return;
      this.vS = 0;
      return;
    } while (this.wp != 0);
    this.wp = this.wm.getColorForState(getDrawableState(), this.wm.getDefaultColor());
  }
  
  private void dm()
  {
    if (this.vJ == null) {
      return;
    }
    dl();
    if ((this.vy != null) && (this.vM == 2))
    {
      if (this.vy.getBackground() != null) {
        this.vX = this.vy.getBackground();
      }
      u.a(this.vy, null);
    }
    if ((this.vy != null) && (this.vM == 1) && (this.vX != null)) {
      u.a(this.vy, this.vX);
    }
    if ((this.vS >= 0) && (this.vV != 0)) {
      this.vJ.setStroke(this.vS, this.vV);
    }
    this.vJ.setCornerRadii(getCornerRadiiAsArray());
    this.vJ.setColor(this.vW);
    invalidate();
  }
  
  private void jdMethod_do()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22)) {}
    Drawable localDrawable2;
    do
    {
      Drawable localDrawable1;
      do
      {
        return;
        localDrawable1 = this.vy.getBackground();
      } while ((localDrawable1 == null) || (this.wt));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.wt = g.a((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
    } while (this.wt);
    u.a(this.vy, localDrawable2);
    this.wt = true;
    de();
  }
  
  private void dp()
  {
    if (this.vy == null) {}
    Drawable[] arrayOfDrawable;
    do
    {
      do
      {
        return;
        if (dr())
        {
          if (this.wd == null)
          {
            this.wd = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(2131493836, this.vx, false));
            this.wd.setImageDrawable(this.wa);
            this.wd.setContentDescription(this.wb);
            this.vx.addView(this.wd);
            this.wd.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                TextInputLayout.this.y(false);
              }
            });
          }
          if ((this.vy != null) && (u.ag(this.vy) <= 0)) {
            this.vy.setMinimumHeight(u.ag(this.wd));
          }
          this.wd.setVisibility(0);
          this.wd.setChecked(this.we);
          if (this.wf == null) {
            this.wf = new ColorDrawable();
          }
          this.wf.setBounds(0, 0, this.wd.getMeasuredWidth(), 1);
          arrayOfDrawable = q.c(this.vy);
          if (arrayOfDrawable[2] != this.wf) {
            this.wg = arrayOfDrawable[2];
          }
          q.a(this.vy, arrayOfDrawable[0], arrayOfDrawable[1], this.wf, arrayOfDrawable[3]);
          this.wd.setPadding(this.vy.getPaddingLeft(), this.vy.getPaddingTop(), this.vy.getPaddingRight(), this.vy.getPaddingBottom());
          return;
        }
        if ((this.wd != null) && (this.wd.getVisibility() == 0)) {
          this.wd.setVisibility(8);
        }
      } while (this.wf == null);
      arrayOfDrawable = q.c(this.vy);
    } while (arrayOfDrawable[2] != this.wf);
    q.a(this.vy, arrayOfDrawable[0], arrayOfDrawable[1], this.wg, arrayOfDrawable[3]);
    this.wf = null;
  }
  
  private boolean dq()
  {
    return (this.vy != null) && ((this.vy.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private boolean dr()
  {
    return (this.vZ) && ((dq()) || (this.we));
  }
  
  private void ds()
  {
    if ((this.wa != null) && ((this.wi) || (this.wk)))
    {
      this.wa = android.support.v4.graphics.drawable.a.i(this.wa).mutate();
      if (this.wi) {
        android.support.v4.graphics.drawable.a.a(this.wa, this.wh);
      }
      if (this.wk) {
        android.support.v4.graphics.drawable.a.a(this.wa, this.wj);
      }
      if ((this.wd != null) && (this.wd.getDrawable() != this.wa)) {
        this.wd.setImageDrawable(this.wa);
      }
    }
  }
  
  private boolean dt()
  {
    return (this.vH) && (!TextUtils.isEmpty(this.hint)) && ((this.vJ instanceof e));
  }
  
  private void du()
  {
    if (!dt()) {
      return;
    }
    RectF localRectF = this.vY;
    this.pP.a(localRectF);
    c(localRectF);
    ((e)this.vJ).b(localRectF);
  }
  
  private void dv()
  {
    if (dt()) {
      ((e)this.vJ).a(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  private Drawable getBoxBackground()
  {
    if ((this.vM == 1) || (this.vM == 2)) {
      return this.vJ;
    }
    throw new IllegalStateException();
  }
  
  private float[] getCornerRadiiAsArray()
  {
    if (!android.support.design.internal.g.d(this)) {
      return new float[] { this.vO, this.vO, this.vP, this.vP, this.vQ, this.vQ, this.vR, this.vR };
    }
    return new float[] { this.vP, this.vP, this.vO, this.vO, this.vR, this.vR, this.vQ, this.vQ };
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.vy != null) {
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    }
    this.vy = paramEditText;
    de();
    setTextInputAccessibilityDelegate(new a(this));
    if (!dq()) {
      this.pP.b(this.vy.getTypeface());
    }
    paramEditText = this.pP;
    float f = this.vy.getTextSize();
    if (paramEditText.oX != f)
    {
      paramEditText.oX = f;
      paramEditText.cp();
    }
    int i = this.vy.getGravity();
    this.pP.N(i & 0xFFFFFF8F | 0x30);
    this.pP.M(i);
    this.vy.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        TextInputLayout localTextInputLayout = TextInputLayout.this;
        if (!TextInputLayout.a(TextInputLayout.this)) {}
        for (boolean bool = true;; bool = false)
        {
          localTextInputLayout.d(bool, false);
          if (TextInputLayout.this.vB) {
            TextInputLayout.this.ak(paramAnonymousEditable.length());
          }
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.wl == null) {
      this.wl = this.vy.getHintTextColors();
    }
    if (this.vH)
    {
      if (TextUtils.isEmpty(this.hint))
      {
        this.vz = this.vy.getHint();
        setHint(this.vz);
        this.vy.setHint(null);
      }
      this.vI = true;
    }
    if (this.vE != null) {
      ak(this.vy.getText().length());
    }
    this.vA.cQ();
    dp();
    d(false, true);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.hint))
    {
      this.hint = paramCharSequence;
      this.pP.setText(paramCharSequence);
      if (!this.wr) {
        du();
      }
    }
  }
  
  private void v(float paramFloat)
  {
    if (this.pP.oR == paramFloat) {
      return;
    }
    if (this.animator == null)
    {
      this.animator = new ValueAnimator();
      this.animator.setInterpolator(android.support.design.a.a.gL);
      this.animator.setDuration(167L);
      this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TextInputLayout.this.pP.k(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        }
      });
    }
    this.animator.setFloatValues(new float[] { this.pP.oR, paramFloat });
    this.animator.start();
  }
  
  private void z(boolean paramBoolean)
  {
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.ws)) {
      v(1.0F);
    }
    for (;;)
    {
      this.wr = false;
      if (dt()) {
        du();
      }
      return;
      this.pP.k(1.0F);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.vx.addView(paramView, localLayoutParams);
      this.vx.setLayoutParams(paramLayoutParams);
      dg();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  final void ak(int paramInt)
  {
    boolean bool2 = this.vD;
    if (this.vC == -1)
    {
      this.vE.setText(String.valueOf(paramInt));
      this.vE.setContentDescription(null);
      this.vD = false;
      if ((this.vy != null) && (bool2 != this.vD))
      {
        d(false, false);
        dw();
        dn();
      }
      return;
    }
    if (u.ab(this.vE) == 1) {
      u.r(this.vE, 0);
    }
    boolean bool1;
    label98:
    TextView localTextView;
    if (paramInt > this.vC)
    {
      bool1 = true;
      this.vD = bool1;
      if (bool2 != this.vD)
      {
        localTextView = this.vE;
        if (!this.vD) {
          break label236;
        }
      }
    }
    label236:
    for (int i = this.vF;; i = this.vG)
    {
      c(localTextView, i);
      if (this.vD) {
        u.r(this.vE, 1);
      }
      this.vE.setText(getContext().getString(2131757211, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vC) }));
      this.vE.setContentDescription(getContext().getString(2131757210, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vC) }));
      break;
      bool1 = false;
      break label98;
    }
  }
  
  final void c(TextView paramTextView, int paramInt)
  {
    i = 1;
    try
    {
      q.d(paramTextView, paramInt);
      if (Build.VERSION.SDK_INT < 23) {
        break label65;
      }
      paramInt = paramTextView.getTextColors().getDefaultColor();
      if (paramInt != -65281) {
        break label65;
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
      q.d(paramTextView, 2131821376);
      paramTextView.setTextColor(b.n(getContext(), 2131100250));
    }
  }
  
  final void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    boolean bool1 = isEnabled();
    int i;
    label48:
    boolean bool2;
    if ((this.vy != null) && (!TextUtils.isEmpty(this.vy.getText())))
    {
      i = 1;
      if ((this.vy == null) || (!this.vy.hasFocus())) {
        break label162;
      }
      bool2 = this.vA.cR();
      if (this.wl != null)
      {
        this.pP.d(this.wl);
        this.pP.e(this.wl);
      }
      if (bool1) {
        break label168;
      }
      this.pP.d(ColorStateList.valueOf(this.wq));
      this.pP.e(ColorStateList.valueOf(this.wq));
      label119:
      if ((i == 0) && ((!isEnabled()) || ((j == 0) && (!bool2)))) {
        break label247;
      }
      if ((paramBoolean2) || (this.wr)) {
        z(paramBoolean1);
      }
    }
    label162:
    label168:
    label247:
    while ((!paramBoolean2) && (this.wr))
    {
      return;
      i = 0;
      break;
      j = 0;
      break label48;
      if (bool2)
      {
        this.pP.d(this.vA.cT());
        break label119;
      }
      if ((this.vD) && (this.vE != null))
      {
        this.pP.d(this.vE.getTextColors());
        break label119;
      }
      if ((j == 0) || (this.wm == null)) {
        break label119;
      }
      this.pP.d(this.wm);
      break label119;
    }
    A(paramBoolean1);
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if ((this.vz == null) || (this.vy == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    boolean bool = this.vI;
    this.vI = false;
    CharSequence localCharSequence = this.vy.getHint();
    this.vy.setHint(this.vz);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.vy.setHint(localCharSequence);
      this.vI = bool;
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.ww = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.ww = false;
  }
  
  final void dn()
  {
    if (this.vy == null) {}
    Drawable localDrawable2;
    do
    {
      return;
      localDrawable2 = this.vy.getBackground();
    } while (localDrawable2 == null);
    jdMethod_do();
    Drawable localDrawable1 = localDrawable2;
    if (x.t(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if (this.vA.cR())
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.b(this.vA.cS(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((this.vD) && (this.vE != null))
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.b(this.vE.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    android.support.v4.graphics.drawable.a.h(localDrawable1);
    this.vy.refreshDrawableState();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.vJ != null) {
      this.vJ.draw(paramCanvas);
    }
    super.draw(paramCanvas);
    if (this.vH) {
      this.pP.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    if (this.wv) {
      return;
    }
    this.wv = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((u.az(this)) && (isEnabled()))
    {
      d(bool2, false);
      dn();
      dh();
      dw();
      if (this.pP == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool1 = this.pP.setState(arrayOfInt) | false;; bool1 = false)
    {
      if (bool1) {
        invalidate();
      }
      this.wv = false;
      return;
      bool2 = false;
      break;
    }
  }
  
  final void dw()
  {
    int j = 1;
    if ((this.vJ == null) || (this.vM == 0)) {
      return;
    }
    int i;
    if ((this.vy != null) && (this.vy.hasFocus()))
    {
      i = 1;
      label36:
      if ((this.vy == null) || (!this.vy.isHovered())) {
        break label109;
      }
      label53:
      if (this.vM != 2) {
        break label112;
      }
      if (isEnabled()) {
        break label114;
      }
      this.vV = this.wq;
      label76:
      if (((j == 0) && (i == 0)) || (!isEnabled())) {
        break label207;
      }
    }
    label207:
    for (this.vS = this.vU;; this.vS = this.vT)
    {
      dm();
      return;
      i = 0;
      break label36;
      label109:
      j = 0;
      break label53;
      label112:
      break;
      label114:
      if (this.vA.cR())
      {
        this.vV = this.vA.cS();
        break label76;
      }
      if ((this.vD) && (this.vE != null))
      {
        this.vV = this.vE.getCurrentTextColor();
        break label76;
      }
      if (i != 0)
      {
        this.vV = this.wp;
        break label76;
      }
      if (j != 0)
      {
        this.vV = this.wo;
        break label76;
      }
      this.vV = this.wn;
      break label76;
    }
  }
  
  public int getBoxBackgroundColor()
  {
    return this.vW;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.vQ;
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.vR;
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.vP;
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.vO;
  }
  
  public int getBoxStrokeColor()
  {
    return this.wp;
  }
  
  public int getCounterMaxLength()
  {
    return this.vC;
  }
  
  CharSequence getCounterOverflowDescription()
  {
    if ((this.vB) && (this.vD) && (this.vE != null)) {
      return this.vE.getContentDescription();
    }
    return null;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.wl;
  }
  
  public EditText getEditText()
  {
    return this.vy;
  }
  
  public CharSequence getError()
  {
    if (this.vA.st) {
      return this.vA.ss;
    }
    return null;
  }
  
  public int getErrorCurrentTextColors()
  {
    return this.vA.cS();
  }
  
  final int getErrorTextCurrentColor()
  {
    return this.vA.cS();
  }
  
  public CharSequence getHelperText()
  {
    if (this.vA.sy) {
      return this.vA.sx;
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    j localj = this.vA;
    if (localj.sz != null) {
      return localj.sz.getCurrentTextColor();
    }
    return -1;
  }
  
  public CharSequence getHint()
  {
    if (this.vH) {
      return this.hint;
    }
    return null;
  }
  
  final float getHintCollapsedTextHeight()
  {
    return this.pP.ci();
  }
  
  final int getHintCurrentCollapsedTextColor()
  {
    return this.pP.cm();
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.wb;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.wa;
  }
  
  public Typeface getTypeface()
  {
    return this.sB;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.vJ != null) {
      dh();
    }
    Rect localRect;
    int i;
    if ((this.vH) && (this.vy != null))
    {
      localRect = this.mC;
      f.a(this, this.vy, localRect);
      paramInt1 = localRect.left;
      paramInt3 = this.vy.getCompoundPaddingLeft() + paramInt1;
      i = localRect.right - this.vy.getCompoundPaddingRight();
      switch (this.vM)
      {
      default: 
        paramInt1 = getPaddingTop();
      }
    }
    for (;;)
    {
      this.pP.c(paramInt3, localRect.top + this.vy.getCompoundPaddingTop(), i, localRect.bottom - this.vy.getCompoundPaddingBottom());
      this.pP.d(paramInt3, paramInt1, i, paramInt4 - paramInt2 - getPaddingBottom());
      this.pP.cp();
      if ((dt()) && (!this.wr)) {
        du();
      }
      return;
      paramInt1 = getBoxBackground().getBounds().top - dj();
      continue;
      paramInt1 = getBoxBackground().getBounds().top + this.vN;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    dp();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Pm);
    setError(paramParcelable.wz);
    if (paramParcelable.wA) {
      y(true);
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.vA.cR()) {
      localSavedState.wz = getError();
    }
    localSavedState.wA = this.we;
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    if (this.vW != paramInt)
    {
      this.vW = paramInt;
      dm();
    }
  }
  
  public void setBoxBackgroundColorResource(@android.support.annotation.a int paramInt)
  {
    setBoxBackgroundColor(b.n(getContext(), paramInt));
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.vM) {
      return;
    }
    this.vM = paramInt;
    de();
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    if (this.wp != paramInt)
    {
      this.wp = paramInt;
      dw();
    }
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.vB != paramBoolean)
    {
      if (!paramBoolean) {
        break label124;
      }
      this.vE = new AppCompatTextView(getContext());
      this.vE.setId(2131309021);
      if (this.sB != null) {
        this.vE.setTypeface(this.sB);
      }
      this.vE.setMaxLines(1);
      c(this.vE, this.vG);
      this.vA.a(this.vE, 2);
      if (this.vy != null) {
        break label105;
      }
      ak(0);
    }
    for (;;)
    {
      this.vB = paramBoolean;
      return;
      label105:
      ak(this.vy.getText().length());
      continue;
      label124:
      this.vA.b(this.vE, 2);
      this.vE = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.vC != paramInt)
    {
      if (paramInt <= 0) {
        break label39;
      }
      this.vC = paramInt;
      if (this.vB) {
        if (this.vy != null) {
          break label47;
        }
      }
    }
    label39:
    label47:
    for (paramInt = 0;; paramInt = this.vy.getText().length())
    {
      ak(paramInt);
      return;
      this.vC = -1;
      break;
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    this.wl = paramColorStateList;
    this.wm = paramColorStateList;
    if (this.vy != null) {
      d(false, false);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    a(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    if (!this.vA.st)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      j localj = this.vA;
      localj.cP();
      localj.ss = paramCharSequence;
      localj.su.setText(paramCharSequence);
      if (localj.sq != 1) {
        localj.sr = 1;
      }
      localj.a(localj.sq, localj.sr, localj.a(localj.su, paramCharSequence));
      return;
    }
    this.vA.cO();
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    j localj = this.vA;
    if (localj.st != paramBoolean)
    {
      localj.cP();
      if (!paramBoolean) {
        break label103;
      }
      localj.su = new AppCompatTextView(localj.context);
      localj.su.setId(2131309022);
      if (localj.sB != null) {
        localj.su.setTypeface(localj.sB);
      }
      localj.setErrorTextAppearance(localj.sv);
      localj.su.setVisibility(4);
      u.r(localj.su, 1);
      localj.a(localj.su, 0);
    }
    for (;;)
    {
      localj.st = paramBoolean;
      return;
      label103:
      localj.cO();
      localj.b(localj.su, 0);
      localj.su = null;
      localj.si.dn();
      localj.si.dw();
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.vA.setErrorTextAppearance(paramInt);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    j localj = this.vA;
    if (localj.su != null) {
      localj.su.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (this.vA.sy) {
        setHelperTextEnabled(false);
      }
      return;
    }
    if (!this.vA.sy) {
      setHelperTextEnabled(true);
    }
    j localj = this.vA;
    localj.cP();
    localj.sx = paramCharSequence;
    localj.sz.setText(paramCharSequence);
    if (localj.sq != 2) {
      localj.sr = 2;
    }
    localj.a(localj.sq, localj.sr, localj.a(localj.sz, paramCharSequence));
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    j localj = this.vA;
    if (localj.sz != null) {
      localj.sz.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    j localj = this.vA;
    if (localj.sy != paramBoolean)
    {
      localj.cP();
      if (!paramBoolean) {
        break label103;
      }
      localj.sz = new AppCompatTextView(localj.context);
      localj.sz.setId(2131309023);
      if (localj.sB != null) {
        localj.sz.setTypeface(localj.sB);
      }
      localj.sz.setVisibility(4);
      u.r(localj.sz, 1);
      localj.Y(localj.sA);
      localj.a(localj.sz, 1);
    }
    for (;;)
    {
      localj.sy = paramBoolean;
      return;
      label103:
      localj.cP();
      if (localj.sq == 2) {
        localj.sr = 0;
      }
      localj.a(localj.sq, localj.sr, localj.a(localj.sz, null));
      localj.b(localj.sz, 1);
      localj.sz = null;
      localj.si.dn();
      localj.si.dw();
    }
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    this.vA.Y(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.vH)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.ws = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.vH)
    {
      this.vH = paramBoolean;
      if (this.vH) {
        break label76;
      }
      this.vI = false;
      if ((!TextUtils.isEmpty(this.hint)) && (TextUtils.isEmpty(this.vy.getHint()))) {
        this.vy.setHint(this.hint);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (this.vy != null) {
        dg();
      }
      return;
      label76:
      CharSequence localCharSequence = this.vy.getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.hint)) {
          setHint(localCharSequence);
        }
        this.vy.setHint(null);
      }
      this.vI = true;
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    this.pP.O(paramInt);
    this.wm = this.pP.pa;
    if (this.vy != null)
    {
      d(false, false);
      dg();
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getResources().getText(paramInt);; localCharSequence = null)
    {
      setPasswordVisibilityToggleContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence)
  {
    this.wb = paramCharSequence;
    if (this.wd != null) {
      this.wd.setContentDescription(paramCharSequence);
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(getContext(), paramInt);; localDrawable = null)
    {
      setPasswordVisibilityToggleDrawable(localDrawable);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    this.wa = paramDrawable;
    if (this.wd != null) {
      this.wd.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.vZ != paramBoolean)
    {
      this.vZ = paramBoolean;
      if ((!paramBoolean) && (this.we) && (this.vy != null)) {
        this.vy.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      this.we = false;
      dp();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.wh = paramColorStateList;
    this.wi = true;
    ds();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.wj = paramMode;
    this.wk = true;
    ds();
  }
  
  public void setTextInputAccessibilityDelegate(a parama)
  {
    if (this.vy != null) {
      u.a(this.vy, parama);
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != this.sB)
    {
      this.sB = paramTypeface;
      this.pP.b(paramTypeface);
      j localj = this.vA;
      if (paramTypeface != localj.sB)
      {
        localj.sB = paramTypeface;
        j.a(localj.su, paramTypeface);
        j.a(localj.sz, paramTypeface);
      }
      if (this.vE != null) {
        this.vE.setTypeface(paramTypeface);
      }
    }
  }
  
  public final void y(boolean paramBoolean)
  {
    int i;
    if (this.vZ)
    {
      i = this.vy.getSelectionEnd();
      if (!dq()) {
        break label66;
      }
      this.vy.setTransformationMethod(null);
    }
    for (this.we = true;; this.we = false)
    {
      this.wd.setChecked(this.we);
      if (paramBoolean) {
        this.wd.jumpDrawablesToCurrentState();
      }
      this.vy.setSelection(i);
      return;
      label66:
      this.vy.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean wA;
    CharSequence wz;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.wz = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      if (paramParcel.readInt() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.wA = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.wz + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.wz, paramParcel, paramInt);
      if (this.wA) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  public static final class a
    extends android.support.v4.view.a
  {
    private final TextInputLayout wy;
    
    public a(TextInputLayout paramTextInputLayout)
    {
      this.wy = paramTextInputLayout;
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      int n = 0;
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      paramView = this.wy.getEditText();
      CharSequence localCharSequence3;
      CharSequence localCharSequence1;
      CharSequence localCharSequence2;
      int i;
      label62:
      int k;
      label73:
      int j;
      label84:
      int m;
      label100:
      label109:
      boolean bool;
      if (paramView != null)
      {
        paramView = paramView.getText();
        localCharSequence3 = this.wy.getHint();
        localCharSequence1 = this.wy.getError();
        localCharSequence2 = this.wy.getCounterOverflowDescription();
        if (TextUtils.isEmpty(paramView)) {
          break label211;
        }
        i = 1;
        if (TextUtils.isEmpty(localCharSequence3)) {
          break label216;
        }
        k = 1;
        if (TextUtils.isEmpty(localCharSequence1)) {
          break label222;
        }
        j = 1;
        if ((j == 0) && (TextUtils.isEmpty(localCharSequence2))) {
          break label228;
        }
        m = 1;
        if (i == 0) {
          break label234;
        }
        paramc.setText(paramView);
        if (k != 0)
        {
          if (Build.VERSION.SDK_INT < 26) {
            break label248;
          }
          paramc.Ro.setHintText(localCharSequence3);
          label131:
          if ((i != 0) || (k == 0)) {
            break label273;
          }
          bool = true;
          label143:
          if (Build.VERSION.SDK_INT < 26) {
            break label279;
          }
          paramc.Ro.setShowingHintText(bool);
        }
        label160:
        if (m != 0) {
          if (j == 0) {
            break label345;
          }
        }
      }
      label211:
      label216:
      label345:
      for (paramView = localCharSequence1;; paramView = localCharSequence2)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramc.Ro.setError(paramView);
        }
        if (Build.VERSION.SDK_INT >= 19) {
          paramc.Ro.setContentInvalid(true);
        }
        return;
        paramView = null;
        break;
        i = 0;
        break label62;
        k = 0;
        break label73;
        label222:
        j = 0;
        break label84;
        label228:
        m = 0;
        break label100;
        label234:
        if (k == 0) {
          break label109;
        }
        paramc.setText(localCharSequence3);
        break label109;
        label248:
        if (Build.VERSION.SDK_INT < 19) {
          break label131;
        }
        paramc.Ro.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", localCharSequence3);
        break label131;
        bool = false;
        break label143;
        if (Build.VERSION.SDK_INT >= 19) {}
        for (paramView = paramc.Ro.getExtras();; paramView = new Bundle())
        {
          if (paramView == null) {
            break label343;
          }
          k = paramView.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
          i = n;
          if (bool) {
            i = 4;
          }
          paramView.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", k & 0xFFFFFFFB | i);
          break;
        }
        break label160;
      }
    }
    
    public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = this.wy.getEditText();
      if (paramView != null) {}
      for (paramView = paramView.getText();; paramView = null)
      {
        Object localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = this.wy.getHint();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramAccessibilityEvent.getText().add(localObject);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */