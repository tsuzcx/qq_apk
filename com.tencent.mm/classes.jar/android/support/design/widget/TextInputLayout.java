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
import android.support.design.a.a;
import android.support.v4.content.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.t;
import android.support.v4.widget.Space;
import android.support.v4.widget.q;
import android.support.v4.widget.u;
import android.support.v7.appcompat.R.color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.az;
import android.support.v7.widget.bi;
import android.support.v7.widget.x;
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
  implements bi
{
  private final Rect hV = new Rect();
  final f hW = new f(this);
  private ValueAnimator kO;
  private boolean mA;
  private boolean mB;
  private Drawable mC;
  private CharSequence mD;
  private CheckableImageButton mE;
  EditText mEditText;
  private boolean mF;
  private Drawable mG;
  private Drawable mH;
  private ColorStateList mI;
  private boolean mJ;
  private PorterDuff.Mode mK;
  private boolean mL;
  private ColorStateList mM;
  private ColorStateList mN;
  private boolean mO;
  private boolean mP;
  private boolean mQ;
  private boolean mR;
  private boolean mS;
  private final FrameLayout mi;
  private CharSequence mj;
  private boolean mk;
  private CharSequence ml;
  private Paint mm;
  private LinearLayout mn;
  private int mo;
  private Typeface mp;
  private boolean mq;
  TextView mr;
  private int ms;
  private boolean mt;
  private CharSequence mu;
  boolean mv;
  private TextView mw;
  private int mx;
  private int my;
  private int mz;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    n.F(paramContext);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.mi = new FrameLayout(paramContext);
    this.mi.setAddStatesFromChildren(true);
    addView(this.mi);
    this.hW.b(a.fj);
    f localf = this.hW;
    localf.hC = new AccelerateInterpolator();
    localf.bh();
    this.hW.z(8388659);
    paramContext = az.a(paramContext, paramAttributeSet, a.a.TextInputLayout, paramInt, 2131493843);
    this.mk = paramContext.getBoolean(3, true);
    setHint(paramContext.getText(1));
    this.mP = paramContext.getBoolean(10, true);
    if (paramContext.hasValue(0))
    {
      paramAttributeSet = paramContext.getColorStateList(0);
      this.mN = paramAttributeSet;
      this.mM = paramAttributeSet;
    }
    if (paramContext.getResourceId(2, -1) != -1) {
      setHintTextAppearance(paramContext.getResourceId(2, 0));
    }
    this.ms = paramContext.getResourceId(5, 0);
    boolean bool1 = paramContext.getBoolean(4, false);
    boolean bool2 = paramContext.getBoolean(6, false);
    setCounterMaxLength(paramContext.getInt(7, -1));
    this.my = paramContext.getResourceId(8, 0);
    this.mz = paramContext.getResourceId(9, 0);
    this.mB = paramContext.getBoolean(11, false);
    this.mC = paramContext.getDrawable(12);
    this.mD = paramContext.getText(13);
    if (paramContext.hasValue(14))
    {
      this.mJ = true;
      this.mI = paramContext.getColorStateList(14);
    }
    if (paramContext.hasValue(15))
    {
      this.mL = true;
      this.mK = p.R(paramContext.getInt(15, -1));
    }
    paramContext.aoo.recycle();
    setErrorEnabled(bool1);
    setCounterEnabled(bool2);
    bR();
    if (t.S(this) == 0) {
      t.o(this, 1);
    }
    t.a(this, new TextInputLayout.a(this));
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
    if (this.mn != null)
    {
      this.mn.removeView(paramTextView);
      int i = this.mo - 1;
      this.mo = i;
      if (i == 0) {
        this.mn.setVisibility(8);
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (this.mn == null)
    {
      this.mn = new LinearLayout(getContext());
      this.mn.setOrientation(0);
      addView(this.mn, -1, -2);
      Space localSpace = new Space(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.mn.addView(localSpace, localLayoutParams);
      if (this.mEditText != null) {
        bL();
      }
    }
    this.mn.setVisibility(0);
    this.mn.addView(paramTextView, paramInt);
    this.mo += 1;
  }
  
  private void bK()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mi.getLayoutParams();
    if (this.mk)
    {
      if (this.mm == null) {
        this.mm = new Paint();
      }
      this.mm.setTypeface(this.hW.ba());
      this.mm.setTextSize(this.hW.hg);
    }
    for (int i = (int)-this.mm.ascent();; i = 0)
    {
      if (i != localLayoutParams.topMargin)
      {
        localLayoutParams.topMargin = i;
        this.mi.requestLayout();
      }
      return;
    }
  }
  
  private void bL()
  {
    t.d(this.mn, t.W(this.mEditText), 0, t.X(this.mEditText), this.mEditText.getPaddingBottom());
  }
  
  private void bM()
  {
    if (this.mEditText == null) {}
    Drawable localDrawable2;
    do
    {
      return;
      localDrawable2 = this.mEditText.getBackground();
    } while (localDrawable2 == null);
    bN();
    Drawable localDrawable1 = localDrawable2;
    if (x.o(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if ((this.mt) && (this.mr != null))
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.a(this.mr.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((this.mA) && (this.mw != null))
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.a(this.mw.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    android.support.v4.graphics.drawable.a.d(localDrawable1);
    this.mEditText.refreshDrawableState();
  }
  
  private void bN()
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
        localDrawable1 = this.mEditText.getBackground();
      } while ((localDrawable1 == null) || (this.mQ));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.mQ = g.a((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
    } while (this.mQ);
    t.a(this.mEditText, localDrawable2);
    this.mQ = true;
  }
  
  private void bO()
  {
    if (this.mEditText == null) {}
    Drawable[] arrayOfDrawable;
    do
    {
      do
      {
        return;
        if (bQ())
        {
          if (this.mE == null)
          {
            this.mE = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(2130969317, this.mi, false));
            this.mE.setImageDrawable(this.mC);
            this.mE.setContentDescription(this.mD);
            this.mi.addView(this.mE);
            this.mE.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                TextInputLayout.b(TextInputLayout.this);
              }
            });
          }
          if ((this.mEditText != null) && (t.aa(this.mEditText) <= 0)) {
            this.mEditText.setMinimumHeight(t.aa(this.mE));
          }
          this.mE.setVisibility(0);
          this.mE.setChecked(this.mF);
          if (this.mG == null) {
            this.mG = new ColorDrawable();
          }
          this.mG.setBounds(0, 0, this.mE.getMeasuredWidth(), 1);
          arrayOfDrawable = q.c(this.mEditText);
          if (arrayOfDrawable[2] != this.mG) {
            this.mH = arrayOfDrawable[2];
          }
          q.a(this.mEditText, arrayOfDrawable[0], arrayOfDrawable[1], this.mG, arrayOfDrawable[3]);
          this.mE.setPadding(this.mEditText.getPaddingLeft(), this.mEditText.getPaddingTop(), this.mEditText.getPaddingRight(), this.mEditText.getPaddingBottom());
          return;
        }
        if ((this.mE != null) && (this.mE.getVisibility() == 0)) {
          this.mE.setVisibility(8);
        }
      } while (this.mG == null);
      arrayOfDrawable = q.c(this.mEditText);
    } while (arrayOfDrawable[2] != this.mG);
    q.a(this.mEditText, arrayOfDrawable[0], arrayOfDrawable[1], this.mH, arrayOfDrawable[3]);
    this.mG = null;
  }
  
  private boolean bP()
  {
    return (this.mEditText != null) && ((this.mEditText.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private boolean bQ()
  {
    return (this.mB) && ((bP()) || (this.mF));
  }
  
  private void bR()
  {
    if ((this.mC != null) && ((this.mJ) || (this.mL)))
    {
      this.mC = android.support.v4.graphics.drawable.a.e(this.mC).mutate();
      if (this.mJ) {
        android.support.v4.graphics.drawable.a.a(this.mC, this.mI);
      }
      if (this.mL) {
        android.support.v4.graphics.drawable.a.a(this.mC, this.mK);
      }
      if ((this.mE != null) && (this.mE.getDrawable() != this.mC)) {
        this.mE.setImageDrawable(this.mC);
      }
    }
  }
  
  private static boolean d(int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == 16842908) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void p(float paramFloat)
  {
    if (this.hW.gZ == paramFloat) {
      return;
    }
    if (this.kO == null)
    {
      this.kO = new ValueAnimator();
      this.kO.setInterpolator(a.fi);
      this.kO.setDuration(200L);
      this.kO.addUpdateListener(new TextInputLayout.5(this));
    }
    this.kO.setFloatValues(new float[] { this.hW.gZ, paramFloat });
    this.kO.start();
  }
  
  private void s(boolean paramBoolean)
  {
    int i;
    if (this.mB)
    {
      i = this.mEditText.getSelectionEnd();
      if (!bP()) {
        break label66;
      }
      this.mEditText.setTransformationMethod(null);
    }
    for (this.mF = true;; this.mF = false)
    {
      this.mE.setChecked(this.mF);
      if (paramBoolean) {
        this.mE.jumpDrawablesToCurrentState();
      }
      this.mEditText.setSelection(i);
      return;
      label66:
      this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.mEditText != null) {
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    }
    this.mEditText = paramEditText;
    if (!bP()) {
      this.hW.a(this.mEditText.getTypeface());
    }
    paramEditText = this.hW;
    float f = this.mEditText.getTextSize();
    if (paramEditText.hf != f)
    {
      paramEditText.hf = f;
      paramEditText.bh();
    }
    int i = this.mEditText.getGravity();
    this.hW.z(i & 0xFFFFFF8F | 0x30);
    this.hW.y(i);
    this.mEditText.addTextChangedListener(new TextInputLayout.1(this));
    if (this.mM == null) {
      this.mM = this.mEditText.getHintTextColors();
    }
    if ((this.mk) && (TextUtils.isEmpty(this.ml)))
    {
      this.mj = this.mEditText.getHint();
      setHint(this.mj);
      this.mEditText.setHint(null);
    }
    if (this.mw != null) {
      Q(this.mEditText.getText().length());
    }
    if (this.mn != null) {
      bL();
    }
    bO();
    d(false, true);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    this.ml = paramCharSequence;
    this.hW.setText(paramCharSequence);
  }
  
  private void t(boolean paramBoolean)
  {
    if ((this.kO != null) && (this.kO.isRunning())) {
      this.kO.cancel();
    }
    if ((paramBoolean) && (this.mP)) {
      p(1.0F);
    }
    for (;;)
    {
      this.mO = false;
      return;
      this.hW.h(1.0F);
    }
  }
  
  private void u(boolean paramBoolean)
  {
    if ((this.kO != null) && (this.kO.isRunning())) {
      this.kO.cancel();
    }
    if ((paramBoolean) && (this.mP)) {
      p(0.0F);
    }
    for (;;)
    {
      this.mO = true;
      return;
      this.hW.h(0.0F);
    }
  }
  
  final void Q(int paramInt)
  {
    boolean bool2 = this.mA;
    if (this.mx == -1)
    {
      this.mw.setText(String.valueOf(paramInt));
      this.mA = false;
      if ((this.mEditText != null) && (bool2 != this.mA))
      {
        d(false, false);
        bM();
      }
      return;
    }
    boolean bool1;
    label67:
    TextView localTextView;
    if (paramInt > this.mx)
    {
      bool1 = true;
      this.mA = bool1;
      if (bool2 != this.mA)
      {
        localTextView = this.mw;
        if (!this.mA) {
          break label151;
        }
      }
    }
    label151:
    for (int i = this.mz;; i = this.my)
    {
      q.b(localTextView, i);
      this.mw.setText(getContext().getString(2131306135, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mx) }));
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
      this.mi.addView(paramView, localLayoutParams);
      this.mi.setLayoutParams(paramLayoutParams);
      bK();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  final void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    boolean bool1 = isEnabled();
    int i;
    boolean bool2;
    if ((this.mEditText != null) && (!TextUtils.isEmpty(this.mEditText.getText())))
    {
      i = 1;
      bool2 = d(getDrawableState());
      if (TextUtils.isEmpty(getError())) {
        break label144;
      }
      label50:
      if (this.mM != null) {
        this.hW.c(this.mM);
      }
      if ((!bool1) || (!this.mA) || (this.mw == null)) {
        break label150;
      }
      this.hW.b(this.mw.getTextColors());
      label101:
      if ((i == 0) && ((!isEnabled()) || ((!bool2) && (j == 0)))) {
        break label202;
      }
      if ((paramBoolean2) || (this.mO)) {
        t(paramBoolean1);
      }
    }
    label144:
    label150:
    label202:
    while ((!paramBoolean2) && (this.mO))
    {
      return;
      i = 0;
      break;
      j = 0;
      break label50;
      if ((bool1) && (bool2) && (this.mN != null))
      {
        this.hW.b(this.mN);
        break label101;
      }
      if (this.mM == null) {
        break label101;
      }
      this.hW.b(this.mM);
      break label101;
    }
    u(paramBoolean1);
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if ((this.mj == null) || (this.mEditText == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    CharSequence localCharSequence = this.mEditText.getHint();
    this.mEditText.setHint(this.mj);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.mEditText.setHint(localCharSequence);
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.mS = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.mS = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.mk) {
      this.hW.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    if (this.mR) {
      return;
    }
    this.mR = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((t.as(this)) && (isEnabled()))
    {
      d(bool2, false);
      bM();
      if (this.hW == null) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = this.hW.setState(arrayOfInt) | false;; bool1 = false)
    {
      if (bool1) {
        invalidate();
      }
      this.mR = false;
      return;
      bool2 = false;
      break;
    }
  }
  
  public int getCounterMaxLength()
  {
    return this.mx;
  }
  
  public EditText getEditText()
  {
    return this.mEditText;
  }
  
  public CharSequence getError()
  {
    if (this.mq) {
      return this.mu;
    }
    return null;
  }
  
  public CharSequence getHint()
  {
    if (this.mk) {
      return this.ml;
    }
    return null;
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.mD;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.mC;
  }
  
  public Typeface getTypeface()
  {
    return this.mp;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mk) && (this.mEditText != null))
    {
      Rect localRect = this.hV;
      u.a(this, this.mEditText, localRect);
      paramInt1 = localRect.left + this.mEditText.getCompoundPaddingLeft();
      paramInt3 = localRect.right - this.mEditText.getCompoundPaddingRight();
      this.hW.c(paramInt1, localRect.top + this.mEditText.getCompoundPaddingTop(), paramInt3, localRect.bottom - this.mEditText.getCompoundPaddingBottom());
      this.hW.d(paramInt1, getPaddingTop(), paramInt3, paramInt4 - paramInt2 - getPaddingBottom());
      this.hW.bh();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    bO();
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
    super.onRestoreInstanceState(paramParcelable.Fo);
    setError(paramParcelable.mV);
    if (paramParcelable.mW) {
      s(true);
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    TextInputLayout.SavedState localSavedState = new TextInputLayout.SavedState(super.onSaveInstanceState());
    if (this.mt) {
      localSavedState.mV = getError();
    }
    localSavedState.mW = this.mF;
    return localSavedState;
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.mv != paramBoolean)
    {
      if (!paramBoolean) {
        break label151;
      }
      this.mw = new AppCompatTextView(getContext());
      this.mw.setId(2131820678);
      if (this.mp != null) {
        this.mw.setTypeface(this.mp);
      }
      this.mw.setMaxLines(1);
    }
    for (;;)
    {
      try
      {
        q.b(this.mw, this.my);
        a(this.mw, -1);
        if (this.mEditText == null)
        {
          Q(0);
          this.mv = paramBoolean;
          return;
        }
      }
      catch (Exception localException)
      {
        q.b(this.mw, 2131493607);
        this.mw.setTextColor(b.m(getContext(), R.color.error_color_material));
        continue;
        Q(this.mEditText.getText().length());
        continue;
      }
      label151:
      a(this.mw);
      this.mw = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.mx != paramInt)
    {
      if (paramInt <= 0) {
        break label39;
      }
      this.mx = paramInt;
      if (this.mv) {
        if (this.mEditText != null) {
          break label47;
        }
      }
    }
    label39:
    label47:
    for (paramInt = 0;; paramInt = this.mEditText.getText().length())
    {
      Q(paramInt);
      return;
      this.mx = -1;
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
    if ((t.as(this)) && (isEnabled()) && ((this.mr == null) || (!TextUtils.equals(this.mr.getText(), paramCharSequence))))
    {
      bool1 = true;
      this.mu = paramCharSequence;
      if (!this.mq)
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
        this.mt = bool2;
        this.mr.animate().cancel();
        if (!this.mt) {
          break label201;
        }
        this.mr.setText(paramCharSequence);
        this.mr.setVisibility(0);
        if (!bool1) {
          break label190;
        }
        if (this.mr.getAlpha() == 1.0F) {
          this.mr.setAlpha(0.0F);
        }
        this.mr.animate().alpha(1.0F).setDuration(200L).setInterpolator(a.fl).setListener(new TextInputLayout.2(this)).start();
      }
    }
    for (;;)
    {
      bM();
      d(bool1, false);
      return;
      bool1 = false;
      break;
      label185:
      bool2 = false;
      break label70;
      label190:
      this.mr.setAlpha(1.0F);
      continue;
      label201:
      if (this.mr.getVisibility() == 0) {
        if (bool1)
        {
          this.mr.animate().alpha(0.0F).setDuration(200L).setInterpolator(a.fk).setListener(new TextInputLayout.3(this, paramCharSequence)).start();
        }
        else
        {
          this.mr.setText(paramCharSequence);
          this.mr.setVisibility(4);
        }
      }
    }
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    i = 1;
    if (this.mq != paramBoolean)
    {
      if (this.mr != null) {
        this.mr.animate().cancel();
      }
      if (!paramBoolean) {
        break label172;
      }
      this.mr = new AppCompatTextView(getContext());
      this.mr.setId(2131820679);
      if (this.mp != null) {
        this.mr.setTypeface(this.mp);
      }
    }
    try
    {
      q.b(this.mr, this.ms);
      if (Build.VERSION.SDK_INT < 23) {
        break label202;
      }
      int j = this.mr.getTextColors().getDefaultColor();
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
      q.b(this.mr, 2131493607);
      this.mr.setTextColor(b.m(getContext(), R.color.error_color_material));
    }
    this.mr.setVisibility(4);
    t.V(this.mr);
    a(this.mr, 0);
    for (;;)
    {
      this.mq = paramBoolean;
      return;
      label172:
      this.mt = false;
      bM();
      a(this.mr);
      this.mr = null;
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.ms = paramInt;
    if (this.mr != null) {
      q.b(this.mr, paramInt);
    }
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.mk)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.mP = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    CharSequence localCharSequence;
    if (paramBoolean != this.mk)
    {
      this.mk = paramBoolean;
      localCharSequence = this.mEditText.getHint();
      if (this.mk) {
        break label73;
      }
      if ((!TextUtils.isEmpty(this.ml)) && (TextUtils.isEmpty(localCharSequence))) {
        this.mEditText.setHint(this.ml);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (this.mEditText != null) {
        bK();
      }
      return;
      label73:
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.ml)) {
          setHint(localCharSequence);
        }
        this.mEditText.setHint(null);
      }
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    this.hW.A(paramInt);
    this.mN = this.hW.hi;
    if (this.mEditText != null)
    {
      d(false, false);
      bK();
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
    this.mD = paramCharSequence;
    if (this.mE != null) {
      this.mE.setContentDescription(paramCharSequence);
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.k(getContext(), paramInt);; localDrawable = null)
    {
      setPasswordVisibilityToggleDrawable(localDrawable);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    this.mC = paramDrawable;
    if (this.mE != null) {
      this.mE.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.mB != paramBoolean)
    {
      this.mB = paramBoolean;
      if ((!paramBoolean) && (this.mF) && (this.mEditText != null)) {
        this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      this.mF = false;
      bO();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.mI = paramColorStateList;
    this.mJ = true;
    bR();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.mK = paramMode;
    this.mL = true;
    bR();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (((this.mp != null) && (!this.mp.equals(paramTypeface))) || ((this.mp == null) && (paramTypeface != null)))
    {
      this.mp = paramTypeface;
      this.hW.a(paramTypeface);
      if (this.mw != null) {
        this.mw.setTypeface(paramTypeface);
      }
      if (this.mr != null) {
        this.mr.setTypeface(paramTypeface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */