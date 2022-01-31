package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.v4.view.AbsSavedState;
import android.support.v4.widget.Space;
import android.support.v4.widget.s;
import android.support.v7.a.a.c;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ax;
import android.support.v7.widget.bg;
import android.support.v7.widget.h;
import android.support.v7.widget.y;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStructure;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TextInputLayout
  extends LinearLayout
  implements bg
{
  private final Rect hc = new Rect();
  final f hd = new f(this);
  private ValueAnimator jQ;
  boolean lA;
  private TextView lB;
  private int lC;
  private int lD;
  private int lE;
  private boolean lF;
  private boolean lG;
  private Drawable lH;
  private CharSequence lI;
  private CheckableImageButton lJ;
  private boolean lK;
  private Drawable lL;
  private Drawable lM;
  private ColorStateList lN;
  private boolean lO;
  private PorterDuff.Mode lP;
  private boolean lQ;
  private ColorStateList lR;
  private ColorStateList lS;
  private boolean lT;
  private boolean lU;
  private boolean lV;
  private boolean lW;
  private boolean lX;
  private final FrameLayout lm;
  EditText ln;
  private CharSequence lo;
  private boolean lp;
  private CharSequence lq;
  private Paint lr;
  private LinearLayout ls;
  private int lt;
  private Typeface lu;
  private boolean lv;
  TextView lw;
  private int lx;
  private boolean ly;
  private CharSequence lz;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    o.G(paramContext);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.lm = new FrameLayout(paramContext);
    this.lm.setAddStatesFromChildren(true);
    addView(this.lm);
    this.hd.b(a.el);
    f localf = this.hd;
    localf.gJ = new AccelerateInterpolator();
    localf.az();
    this.hd.A(8388659);
    paramContext = ax.a(paramContext, paramAttributeSet, a.k.TextInputLayout, paramInt, a.j.Widget_Design_TextInputLayout);
    this.lp = paramContext.getBoolean(a.k.TextInputLayout_hintEnabled, true);
    setHint(paramContext.getText(a.k.TextInputLayout_android_hint));
    this.lU = paramContext.getBoolean(a.k.TextInputLayout_hintAnimationEnabled, true);
    if (paramContext.hasValue(a.k.TextInputLayout_android_textColorHint))
    {
      paramAttributeSet = paramContext.getColorStateList(a.k.TextInputLayout_android_textColorHint);
      this.lS = paramAttributeSet;
      this.lR = paramAttributeSet;
    }
    if (paramContext.getResourceId(a.k.TextInputLayout_hintTextAppearance, -1) != -1) {
      setHintTextAppearance(paramContext.getResourceId(a.k.TextInputLayout_hintTextAppearance, 0));
    }
    this.lx = paramContext.getResourceId(a.k.TextInputLayout_errorTextAppearance, 0);
    boolean bool1 = paramContext.getBoolean(a.k.TextInputLayout_errorEnabled, false);
    boolean bool2 = paramContext.getBoolean(a.k.TextInputLayout_counterEnabled, false);
    setCounterMaxLength(paramContext.getInt(a.k.TextInputLayout_counterMaxLength, -1));
    this.lD = paramContext.getResourceId(a.k.TextInputLayout_counterTextAppearance, 0);
    this.lE = paramContext.getResourceId(a.k.TextInputLayout_counterOverflowTextAppearance, 0);
    this.lG = paramContext.getBoolean(a.k.TextInputLayout_passwordToggleEnabled, false);
    this.lH = paramContext.getDrawable(a.k.TextInputLayout_passwordToggleDrawable);
    this.lI = paramContext.getText(a.k.TextInputLayout_passwordToggleContentDescription);
    if (paramContext.hasValue(a.k.TextInputLayout_passwordToggleTint))
    {
      this.lO = true;
      this.lN = paramContext.getColorStateList(a.k.TextInputLayout_passwordToggleTint);
    }
    if (paramContext.hasValue(a.k.TextInputLayout_passwordToggleTintMode))
    {
      this.lQ = true;
      this.lP = q.T(paramContext.getInt(a.k.TextInputLayout_passwordToggleTintMode, -1));
    }
    paramContext.alZ.recycle();
    setErrorEnabled(bool1);
    setCounterEnabled(bool2);
    bg();
    if (android.support.v4.view.q.P(this) == 0) {
      android.support.v4.view.q.n(this, 1);
    }
    android.support.v4.view.q.a(this, new TextInputLayout.a(this));
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
  
  private void a(TextView paramTextView)
  {
    if (this.ls != null)
    {
      this.ls.removeView(paramTextView);
      int i = this.lt - 1;
      this.lt = i;
      if (i == 0) {
        this.ls.setVisibility(8);
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (this.ls == null)
    {
      this.ls = new LinearLayout(getContext());
      this.ls.setOrientation(0);
      addView(this.ls, -1, -2);
      Space localSpace = new Space(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.ls.addView(localSpace, localLayoutParams);
      if (this.ln != null) {
        bb();
      }
    }
    this.ls.setVisibility(0);
    this.ls.addView(paramTextView, paramInt);
    this.lt += 1;
  }
  
  private void ba()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.lm.getLayoutParams();
    if (this.lp)
    {
      if (this.lr == null) {
        this.lr = new Paint();
      }
      this.lr.setTypeface(this.hd.aw());
      this.lr.setTextSize(this.hd.gm);
    }
    for (int i = (int)-this.lr.ascent();; i = 0)
    {
      if (i != localLayoutParams.topMargin)
      {
        localLayoutParams.topMargin = i;
        this.lm.requestLayout();
      }
      return;
    }
  }
  
  private void bb()
  {
    android.support.v4.view.q.d(this.ls, android.support.v4.view.q.T(this.ln), 0, android.support.v4.view.q.U(this.ln), this.ln.getPaddingBottom());
  }
  
  private void bc()
  {
    if (this.ln == null) {}
    Drawable localDrawable1;
    do
    {
      return;
      localDrawable1 = this.ln.getBackground();
    } while (localDrawable1 == null);
    int i = Build.VERSION.SDK_INT;
    if ((i == 21) || (i == 22))
    {
      Drawable localDrawable2 = this.ln.getBackground();
      if ((localDrawable2 != null) && (!this.lV))
      {
        Drawable localDrawable3 = localDrawable2.getConstantState().newDrawable();
        if ((localDrawable2 instanceof DrawableContainer)) {
          this.lV = g.a((DrawableContainer)localDrawable2, localDrawable3.getConstantState());
        }
        if (!this.lV)
        {
          android.support.v4.view.q.a(this.ln, localDrawable3);
          this.lV = true;
        }
      }
    }
    if (y.m(localDrawable1)) {
      localDrawable1 = localDrawable1.mutate();
    }
    for (;;)
    {
      if ((this.ly) && (this.lw != null))
      {
        localDrawable1.setColorFilter(h.a(this.lw.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
      }
      if ((this.lF) && (this.lB != null))
      {
        localDrawable1.setColorFilter(h.a(this.lB.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
      }
      android.support.v4.a.a.a.e(localDrawable1);
      this.ln.refreshDrawableState();
      return;
    }
  }
  
  private void bd()
  {
    if (this.ln == null) {}
    Drawable[] arrayOfDrawable;
    do
    {
      do
      {
        return;
        if ((this.lG) && ((bf()) || (this.lK))) {}
        for (int i = 1; i != 0; i = 0)
        {
          if (this.lJ == null)
          {
            this.lJ = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(a.h.design_text_input_password_icon, this.lm, false));
            this.lJ.setImageDrawable(this.lH);
            this.lJ.setContentDescription(this.lI);
            this.lm.addView(this.lJ);
            this.lJ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                TextInputLayout.b(TextInputLayout.this);
              }
            });
          }
          if ((this.ln != null) && (android.support.v4.view.q.X(this.ln) <= 0)) {
            this.ln.setMinimumHeight(android.support.v4.view.q.X(this.lJ));
          }
          this.lJ.setVisibility(0);
          this.lJ.setChecked(this.lK);
          if (this.lL == null) {
            this.lL = new ColorDrawable();
          }
          this.lL.setBounds(0, 0, this.lJ.getMeasuredWidth(), 1);
          arrayOfDrawable = android.support.v4.widget.o.c(this.ln);
          if (arrayOfDrawable[2] != this.lL) {
            this.lM = arrayOfDrawable[2];
          }
          android.support.v4.widget.o.a(this.ln, arrayOfDrawable[0], arrayOfDrawable[1], this.lL, arrayOfDrawable[3]);
          this.lJ.setPadding(this.ln.getPaddingLeft(), this.ln.getPaddingTop(), this.ln.getPaddingRight(), this.ln.getPaddingBottom());
          return;
        }
        if ((this.lJ != null) && (this.lJ.getVisibility() == 0)) {
          this.lJ.setVisibility(8);
        }
      } while (this.lL == null);
      arrayOfDrawable = android.support.v4.widget.o.c(this.ln);
    } while (arrayOfDrawable[2] != this.lL);
    android.support.v4.widget.o.a(this.ln, arrayOfDrawable[0], arrayOfDrawable[1], this.lM, arrayOfDrawable[3]);
    this.lL = null;
  }
  
  private boolean bf()
  {
    return (this.ln != null) && ((this.ln.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private void bg()
  {
    if ((this.lH != null) && ((this.lO) || (this.lQ)))
    {
      this.lH = android.support.v4.a.a.a.f(this.lH).mutate();
      if (this.lO) {
        android.support.v4.a.a.a.a(this.lH, this.lN);
      }
      if (this.lQ) {
        android.support.v4.a.a.a.a(this.lH, this.lP);
      }
      if ((this.lJ != null) && (this.lJ.getDrawable() != this.lH)) {
        this.lJ.setImageDrawable(this.lH);
      }
    }
  }
  
  private void o(float paramFloat)
  {
    if (this.hd.gf == paramFloat) {
      return;
    }
    if (this.jQ == null)
    {
      this.jQ = new ValueAnimator();
      this.jQ.setInterpolator(a.ek);
      this.jQ.setDuration(200L);
      this.jQ.addUpdateListener(new TextInputLayout.5(this));
    }
    this.jQ.setFloatValues(new float[] { this.hd.gf, paramFloat });
    this.jQ.start();
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.ln != null) {
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    }
    this.ln = paramEditText;
    if (!bf()) {
      this.hd.a(this.ln.getTypeface());
    }
    paramEditText = this.hd;
    float f = this.ln.getTextSize();
    if (paramEditText.gl != f)
    {
      paramEditText.gl = f;
      paramEditText.az();
    }
    int i = this.ln.getGravity();
    this.hd.A(i & 0xFFFFFF8F | 0x30);
    this.hd.z(i);
    this.ln.addTextChangedListener(new TextInputLayout.1(this));
    if (this.lR == null) {
      this.lR = this.ln.getHintTextColors();
    }
    if ((this.lp) && (TextUtils.isEmpty(this.lq)))
    {
      this.lo = this.ln.getHint();
      setHint(this.lo);
      this.ln.setHint(null);
    }
    if (this.lB != null) {
      S(this.ln.getText().length());
    }
    if (this.ls != null) {
      bb();
    }
    bd();
    d(false, true);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    this.lq = paramCharSequence;
    this.hd.setText(paramCharSequence);
  }
  
  private void t(boolean paramBoolean)
  {
    int i;
    if (this.lG)
    {
      i = this.ln.getSelectionEnd();
      if (!bf()) {
        break label66;
      }
      this.ln.setTransformationMethod(null);
    }
    for (this.lK = true;; this.lK = false)
    {
      this.lJ.setChecked(this.lK);
      if (paramBoolean) {
        this.lJ.jumpDrawablesToCurrentState();
      }
      this.ln.setSelection(i);
      return;
      label66:
      this.ln.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  final void S(int paramInt)
  {
    boolean bool2 = this.lF;
    if (this.lC == -1)
    {
      this.lB.setText(String.valueOf(paramInt));
      this.lF = false;
      if ((this.ln != null) && (bool2 != this.lF))
      {
        d(false, false);
        bc();
      }
      return;
    }
    boolean bool1;
    label67:
    TextView localTextView;
    if (paramInt > this.lC)
    {
      bool1 = true;
      this.lF = bool1;
      if (bool2 != this.lF)
      {
        localTextView = this.lB;
        if (!this.lF) {
          break label151;
        }
      }
    }
    label151:
    for (int i = this.lE;; i = this.lD)
    {
      android.support.v4.widget.o.b(localTextView, i);
      this.lB.setText(getContext().getString(android.support.design.a.i.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lC) }));
      break;
      bool1 = false;
      break label67;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.lm.addView(paramView, localLayoutParams);
      this.lm.setLayoutParams(paramLayoutParams);
      ba();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  final void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = isEnabled();
    int i;
    int k;
    int j;
    if ((this.ln != null) && (!TextUtils.isEmpty(this.ln.getText())))
    {
      i = 1;
      int[] arrayOfInt = getDrawableState();
      k = arrayOfInt.length;
      j = 0;
      label42:
      if (j >= k) {
        break label219;
      }
      if (arrayOfInt[j] != 16842908) {
        break label210;
      }
      j = 1;
      label63:
      if (TextUtils.isEmpty(getError())) {
        break label225;
      }
      k = 1;
      label76:
      if (this.lR != null) {
        this.hd.c(this.lR);
      }
      if ((!bool) || (!this.lF) || (this.lB == null)) {
        break label231;
      }
      this.hd.b(this.lB.getTextColors());
      label127:
      if ((i == 0) && ((!isEnabled()) || ((j == 0) && (k == 0)))) {
        break label294;
      }
      if ((paramBoolean2) || (this.lT))
      {
        if ((this.jQ != null) && (this.jQ.isRunning())) {
          this.jQ.cancel();
        }
        if ((!paramBoolean1) || (!this.lU)) {
          break label283;
        }
        o(1.0F);
        this.lT = false;
      }
    }
    label210:
    label219:
    label225:
    label231:
    while ((!paramBoolean2) && (this.lT)) {
      for (;;)
      {
        return;
        i = 0;
        break;
        j += 1;
        break label42;
        j = 0;
        break label63;
        k = 0;
        break label76;
        if ((bool) && (j != 0) && (this.lS != null))
        {
          this.hd.b(this.lS);
          break label127;
        }
        if (this.lR == null) {
          break label127;
        }
        this.hd.b(this.lR);
        break label127;
        this.hd.h(1.0F);
      }
    }
    label283:
    label294:
    if ((this.jQ != null) && (this.jQ.isRunning())) {
      this.jQ.cancel();
    }
    if ((paramBoolean1) && (this.lU)) {
      o(0.0F);
    }
    for (;;)
    {
      this.lT = true;
      return;
      this.hd.h(0.0F);
    }
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if ((this.lo == null) || (this.ln == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    CharSequence localCharSequence = this.ln.getHint();
    this.ln.setHint(this.lo);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.ln.setHint(localCharSequence);
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.lX = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.lX = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.lp) {
      this.hd.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    if (this.lW) {
      return;
    }
    this.lW = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((android.support.v4.view.q.al(this)) && (isEnabled()))
    {
      d(bool2, false);
      bc();
      if (this.hd == null) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = this.hd.setState(arrayOfInt) | false;; bool1 = false)
    {
      if (bool1) {
        invalidate();
      }
      this.lW = false;
      return;
      bool2 = false;
      break;
    }
  }
  
  public int getCounterMaxLength()
  {
    return this.lC;
  }
  
  public EditText getEditText()
  {
    return this.ln;
  }
  
  public CharSequence getError()
  {
    if (this.lv) {
      return this.lz;
    }
    return null;
  }
  
  public CharSequence getHint()
  {
    if (this.lp) {
      return this.lq;
    }
    return null;
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.lI;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.lH;
  }
  
  public Typeface getTypeface()
  {
    return this.lu;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.lp) && (this.ln != null))
    {
      Rect localRect = this.hc;
      s.a(this, this.ln, localRect);
      paramInt1 = localRect.left + this.ln.getCompoundPaddingLeft();
      paramInt3 = localRect.right - this.ln.getCompoundPaddingRight();
      this.hd.b(paramInt1, localRect.top + this.ln.getCompoundPaddingTop(), paramInt3, localRect.bottom - this.ln.getCompoundPaddingBottom());
      this.hd.c(paramInt1, getPaddingTop(), paramInt3, paramInt4 - paramInt2 - getPaddingBottom());
      this.hd.az();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    bd();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof TextInputLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (TextInputLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.EA);
    setError(paramParcelable.ma);
    if (paramParcelable.mb) {
      t(true);
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    TextInputLayout.SavedState localSavedState = new TextInputLayout.SavedState(super.onSaveInstanceState());
    if (this.ly) {
      localSavedState.ma = getError();
    }
    localSavedState.mb = this.lK;
    return localSavedState;
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.lA != paramBoolean)
    {
      if (!paramBoolean) {
        break label151;
      }
      this.lB = new AppCompatTextView(getContext());
      this.lB.setId(a.f.textinput_counter);
      if (this.lu != null) {
        this.lB.setTypeface(this.lu);
      }
      this.lB.setMaxLines(1);
    }
    for (;;)
    {
      try
      {
        android.support.v4.widget.o.b(this.lB, this.lD);
        a(this.lB, -1);
        if (this.ln == null)
        {
          S(0);
          this.lA = paramBoolean;
          return;
        }
      }
      catch (Exception localException)
      {
        android.support.v4.widget.o.b(this.lB, android.support.v7.a.a.i.TextAppearance_AppCompat_Caption);
        this.lB.setTextColor(android.support.v4.content.b.i(getContext(), a.c.error_color_material));
        continue;
        S(this.ln.getText().length());
        continue;
      }
      label151:
      a(this.lB);
      this.lB = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.lC != paramInt)
    {
      if (paramInt <= 0) {
        break label39;
      }
      this.lC = paramInt;
      if (this.lA) {
        if (this.ln != null) {
          break label47;
        }
      }
    }
    label39:
    label47:
    for (paramInt = 0;; paramInt = this.ln.getText().length())
    {
      S(paramInt);
      return;
      this.lC = -1;
      break;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    a(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((android.support.v4.view.q.al(this)) && (isEnabled()) && ((this.lw == null) || (!TextUtils.equals(this.lw.getText(), paramCharSequence))))
    {
      bool1 = true;
      this.lz = paramCharSequence;
      if (!this.lv)
      {
        if (!TextUtils.isEmpty(paramCharSequence)) {
          setErrorEnabled(true);
        }
      }
      else
      {
        if (TextUtils.isEmpty(paramCharSequence)) {
          break label185;
        }
        label70:
        this.ly = bool2;
        this.lw.animate().cancel();
        if (!this.ly) {
          break label201;
        }
        this.lw.setText(paramCharSequence);
        this.lw.setVisibility(0);
        if (!bool1) {
          break label190;
        }
        if (this.lw.getAlpha() == 1.0F) {
          this.lw.setAlpha(0.0F);
        }
        this.lw.animate().alpha(1.0F).setDuration(200L).setInterpolator(a.eo).setListener(new TextInputLayout.2(this)).start();
      }
    }
    for (;;)
    {
      bc();
      d(bool1, false);
      return;
      bool1 = false;
      break;
      label185:
      bool2 = false;
      break label70;
      label190:
      this.lw.setAlpha(1.0F);
      continue;
      label201:
      if (this.lw.getVisibility() == 0) {
        if (bool1)
        {
          this.lw.animate().alpha(0.0F).setDuration(200L).setInterpolator(a.em).setListener(new TextInputLayout.3(this, paramCharSequence)).start();
        }
        else
        {
          this.lw.setText(paramCharSequence);
          this.lw.setVisibility(4);
        }
      }
    }
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    i = 1;
    if (this.lv != paramBoolean)
    {
      if (this.lw != null) {
        this.lw.animate().cancel();
      }
      if (!paramBoolean) {
        break label172;
      }
      this.lw = new AppCompatTextView(getContext());
      this.lw.setId(a.f.textinput_error);
      if (this.lu != null) {
        this.lw.setTypeface(this.lu);
      }
    }
    try
    {
      android.support.v4.widget.o.b(this.lw, this.lx);
      if (Build.VERSION.SDK_INT < 23) {
        break label202;
      }
      int j = this.lw.getTextColors().getDefaultColor();
      if (j != -65281) {
        break label202;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        i = 0;
      }
    }
    if (i != 0)
    {
      android.support.v4.widget.o.b(this.lw, android.support.v7.a.a.i.TextAppearance_AppCompat_Caption);
      this.lw.setTextColor(android.support.v4.content.b.i(getContext(), a.c.error_color_material));
    }
    this.lw.setVisibility(4);
    android.support.v4.view.q.S(this.lw);
    a(this.lw, 0);
    for (;;)
    {
      this.lv = paramBoolean;
      return;
      label172:
      this.ly = false;
      bc();
      a(this.lw);
      this.lw = null;
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.lx = paramInt;
    if (this.lw != null) {
      android.support.v4.widget.o.b(this.lw, paramInt);
    }
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.lp)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.lU = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    CharSequence localCharSequence;
    if (paramBoolean != this.lp)
    {
      this.lp = paramBoolean;
      localCharSequence = this.ln.getHint();
      if (this.lp) {
        break label73;
      }
      if ((!TextUtils.isEmpty(this.lq)) && (TextUtils.isEmpty(localCharSequence))) {
        this.ln.setHint(this.lq);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (this.ln != null) {
        ba();
      }
      return;
      label73:
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.lq)) {
          setHint(localCharSequence);
        }
        this.ln.setHint(null);
      }
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    this.hd.B(paramInt);
    this.lS = this.hd.go;
    if (this.ln != null)
    {
      d(false, false);
      ba();
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
    this.lI = paramCharSequence;
    if (this.lJ != null) {
      this.lJ.setContentDescription(paramCharSequence);
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.b.g(getContext(), paramInt);; localDrawable = null)
    {
      setPasswordVisibilityToggleDrawable(localDrawable);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    this.lH = paramDrawable;
    if (this.lJ != null) {
      this.lJ.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.lG != paramBoolean)
    {
      this.lG = paramBoolean;
      if ((!paramBoolean) && (this.lK) && (this.ln != null)) {
        this.ln.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      this.lK = false;
      bd();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.lN = paramColorStateList;
    this.lO = true;
    bg();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.lP = paramMode;
    this.lQ = true;
    bg();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (((this.lu != null) && (!this.lu.equals(paramTypeface))) || ((this.lu == null) && (paramTypeface != null)))
    {
      this.lu = paramTypeface;
      this.hd.a(paramTypeface);
      if (this.lB != null) {
        this.lB.setTypeface(paramTypeface);
      }
      if (this.lw != null) {
        this.lw.setTypeface(paramTypeface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */