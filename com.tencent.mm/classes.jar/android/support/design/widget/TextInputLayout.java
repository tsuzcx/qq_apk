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
import android.support.v4.view.t;
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
  private CharSequence hint;
  private final Rect kK = new Rect();
  final d nS = new d(this);
  private Typeface qC;
  private ValueAnimator rT;
  private final j tA = new j(this);
  boolean tB;
  private int tC;
  private boolean tD;
  private TextView tE;
  private final int tF;
  private final int tG;
  private boolean tH;
  boolean tI;
  private GradientDrawable tJ;
  private final int tK;
  private final int tL;
  private int tM;
  private final int tN;
  private float tO;
  private float tP;
  private float tQ;
  private float tR;
  private int tS;
  private final int tT;
  private final int tU;
  private int tV;
  private int tW;
  private Drawable tX;
  private final RectF tY = new RectF();
  private boolean tZ;
  private final FrameLayout tx;
  EditText ty;
  private CharSequence tz;
  private Drawable ua;
  private CharSequence ub;
  private CheckableImageButton uc;
  private boolean ud;
  private Drawable ue;
  private Drawable uf;
  private ColorStateList ug;
  private boolean uh;
  private PorterDuff.Mode uj;
  private boolean uk;
  private ColorStateList ul;
  private ColorStateList um;
  private final int un;
  private final int uo;
  private int up;
  private final int uq;
  private boolean ur;
  private boolean ut;
  private boolean uu;
  private boolean uv;
  private boolean uw;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969563);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.tx = new FrameLayout(paramContext);
    this.tx.setAddStatesFromChildren(true);
    addView(this.tx);
    this.nS.a(android.support.design.a.a.eP);
    Object localObject = this.nS;
    ((d)localObject).nz = android.support.design.a.a.eP;
    ((d)localObject).bX();
    this.nS.P(8388659);
    paramAttributeSet = android.support.design.internal.f.b(paramContext, paramAttributeSet, a.a.TextInputLayout, paramInt, 2131821642, new int[0]);
    this.tH = paramAttributeSet.getBoolean(21, true);
    setHint(paramAttributeSet.getText(1));
    this.ut = paramAttributeSet.getBoolean(20, true);
    this.tK = paramContext.getResources().getDimensionPixelOffset(2131166644);
    this.tL = paramContext.getResources().getDimensionPixelOffset(2131166647);
    this.tN = paramAttributeSet.getDimensionPixelOffset(4, 0);
    this.tO = paramAttributeSet.db(8);
    this.tP = paramAttributeSet.db(7);
    this.tQ = paramAttributeSet.db(5);
    this.tR = paramAttributeSet.db(6);
    this.tW = paramAttributeSet.getColor(2, 0);
    this.up = paramAttributeSet.getColor(9, 0);
    this.tT = paramContext.getResources().getDimensionPixelSize(2131166649);
    this.tU = paramContext.getResources().getDimensionPixelSize(2131166650);
    this.tS = this.tT;
    setBoxBackgroundMode(paramAttributeSet.getInt(3, 0));
    if (paramAttributeSet.hasValue(0))
    {
      localObject = paramAttributeSet.getColorStateList(0);
      this.um = ((ColorStateList)localObject);
      this.ul = ((ColorStateList)localObject);
    }
    this.un = b.n(paramContext, 2131100678);
    this.uq = b.n(paramContext, 2131100679);
    this.uo = b.n(paramContext, 2131100681);
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
    this.tG = paramAttributeSet.getResourceId(14, 0);
    this.tF = paramAttributeSet.getResourceId(13, 0);
    this.tZ = paramAttributeSet.getBoolean(25, false);
    this.ua = paramAttributeSet.getDrawable(24);
    this.ub = paramAttributeSet.getText(23);
    if (paramAttributeSet.hasValue(26))
    {
      this.uh = true;
      this.ug = paramAttributeSet.getColorStateList(26);
    }
    if (paramAttributeSet.hasValue(27))
    {
      this.uk = true;
      this.uj = android.support.design.internal.g.a(paramAttributeSet.getInt(27, -1), null);
    }
    paramAttributeSet.awJ.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(paramContext);
    setHelperTextTextAppearance(i);
    setErrorEnabled(bool1);
    setErrorTextAppearance(paramInt);
    setCounterEnabled(bool3);
    da();
    t.p(this, 2);
  }
  
  private void A(boolean paramBoolean)
  {
    if ((this.rT != null) && (this.rT.isRunning())) {
      this.rT.cancel();
    }
    if ((paramBoolean) && (this.ut)) {
      x(0.0F);
    }
    for (;;)
    {
      if ((db()) && (((e)this.tJ).ch())) {
        dd();
      }
      this.ur = true;
      return;
      this.nS.m(0.0F);
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
    paramRectF.left -= this.tL;
    paramRectF.top -= this.tL;
    paramRectF.right += this.tL;
    paramRectF.bottom += this.tL;
  }
  
  private void cM()
  {
    cN();
    if (this.tM != 0) {
      cO();
    }
    cP();
  }
  
  private void cN()
  {
    if (this.tM == 0) {
      this.tJ = null;
    }
    do
    {
      return;
      if ((this.tM == 2) && (this.tH) && (!(this.tJ instanceof e)))
      {
        this.tJ = new e();
        return;
      }
    } while ((this.tJ instanceof GradientDrawable));
    this.tJ = new GradientDrawable();
  }
  
  private void cO()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.tx.getLayoutParams();
    int i = cR();
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.tx.requestLayout();
    }
  }
  
  private void cP()
  {
    if ((this.tM == 0) || (this.tJ == null) || (this.ty == null) || (getRight() == 0)) {
      return;
    }
    int i3 = this.ty.getLeft();
    int i2 = cQ();
    int i1 = this.ty.getRight();
    int n = this.ty.getBottom() + this.tK;
    int m = n;
    int k = i1;
    int j = i2;
    int i = i3;
    if (this.tM == 2)
    {
      i = i3 + this.tU / 2;
      j = i2 - this.tU / 2;
      k = i1 - this.tU / 2;
      m = n + this.tU / 2;
    }
    this.tJ.setBounds(i, j, k, m);
    cU();
    cS();
  }
  
  private int cQ()
  {
    if (this.ty == null) {
      return 0;
    }
    switch (this.tM)
    {
    default: 
      return 0;
    case 1: 
      return this.ty.getTop();
    }
    return this.ty.getTop() + cR();
  }
  
  private int cR()
  {
    if (!this.tH) {
      return 0;
    }
    switch (this.tM)
    {
    default: 
      return 0;
    case 0: 
    case 1: 
      return (int)this.nS.bQ();
    }
    return (int)(this.nS.bQ() / 2.0F);
  }
  
  private void cS()
  {
    if (this.ty == null) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = this.ty.getBackground();
      } while (localObject2 == null);
      localObject1 = localObject2;
      if (x.t((Drawable)localObject2)) {
        localObject1 = ((Drawable)localObject2).mutate();
      }
      localObject2 = new Rect();
      f.a(this, this.ty, (Rect)localObject2);
      localObject2 = ((Drawable)localObject1).getBounds();
    } while (((Rect)localObject2).left == ((Rect)localObject2).right);
    Rect localRect = new Rect();
    ((Drawable)localObject1).getPadding(localRect);
    int i = ((Rect)localObject2).left;
    int j = localRect.left;
    int k = ((Rect)localObject2).right;
    int m = localRect.right;
    ((Drawable)localObject1).setBounds(i - j, ((Rect)localObject2).top, m * 2 + k, this.ty.getBottom());
  }
  
  private void cT()
  {
    switch (this.tM)
    {
    }
    do
    {
      return;
      this.tS = 0;
      return;
    } while (this.up != 0);
    this.up = this.um.getColorForState(getDrawableState(), this.um.getDefaultColor());
  }
  
  private void cU()
  {
    if (this.tJ == null) {
      return;
    }
    cT();
    if ((this.ty != null) && (this.tM == 2))
    {
      if (this.ty.getBackground() != null) {
        this.tX = this.ty.getBackground();
      }
      t.a(this.ty, null);
    }
    if ((this.ty != null) && (this.tM == 1) && (this.tX != null)) {
      t.a(this.ty, this.tX);
    }
    if ((this.tS >= 0) && (this.tV != 0)) {
      this.tJ.setStroke(this.tS, this.tV);
    }
    this.tJ.setCornerRadii(getCornerRadiiAsArray());
    this.tJ.setColor(this.tW);
    invalidate();
  }
  
  private void cW()
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
        localDrawable1 = this.ty.getBackground();
      } while ((localDrawable1 == null) || (this.uu));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.uu = g.a((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
    } while (this.uu);
    t.a(this.ty, localDrawable2);
    this.uu = true;
    cM();
  }
  
  private void cX()
  {
    if (this.ty == null) {}
    Drawable[] arrayOfDrawable;
    do
    {
      do
      {
        return;
        if (cZ())
        {
          if (this.uc == null)
          {
            this.uc = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(2131493705, this.tx, false));
            this.uc.setImageDrawable(this.ua);
            this.uc.setContentDescription(this.ub);
            this.tx.addView(this.uc);
            this.uc.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                TextInputLayout.this.y(false);
              }
            });
          }
          if ((this.ty != null) && (t.af(this.ty) <= 0)) {
            this.ty.setMinimumHeight(t.af(this.uc));
          }
          this.uc.setVisibility(0);
          this.uc.setChecked(this.ud);
          if (this.ue == null) {
            this.ue = new ColorDrawable();
          }
          this.ue.setBounds(0, 0, this.uc.getMeasuredWidth(), 1);
          arrayOfDrawable = q.c(this.ty);
          if (arrayOfDrawable[2] != this.ue) {
            this.uf = arrayOfDrawable[2];
          }
          q.a(this.ty, arrayOfDrawable[0], arrayOfDrawable[1], this.ue, arrayOfDrawable[3]);
          this.uc.setPadding(this.ty.getPaddingLeft(), this.ty.getPaddingTop(), this.ty.getPaddingRight(), this.ty.getPaddingBottom());
          return;
        }
        if ((this.uc != null) && (this.uc.getVisibility() == 0)) {
          this.uc.setVisibility(8);
        }
      } while (this.ue == null);
      arrayOfDrawable = q.c(this.ty);
    } while (arrayOfDrawable[2] != this.ue);
    q.a(this.ty, arrayOfDrawable[0], arrayOfDrawable[1], this.uf, arrayOfDrawable[3]);
    this.ue = null;
  }
  
  private boolean cY()
  {
    return (this.ty != null) && ((this.ty.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private boolean cZ()
  {
    return (this.tZ) && ((cY()) || (this.ud));
  }
  
  private void da()
  {
    if ((this.ua != null) && ((this.uh) || (this.uk)))
    {
      this.ua = android.support.v4.graphics.drawable.a.i(this.ua).mutate();
      if (this.uh) {
        android.support.v4.graphics.drawable.a.a(this.ua, this.ug);
      }
      if (this.uk) {
        android.support.v4.graphics.drawable.a.a(this.ua, this.uj);
      }
      if ((this.uc != null) && (this.uc.getDrawable() != this.ua)) {
        this.uc.setImageDrawable(this.ua);
      }
    }
  }
  
  private boolean db()
  {
    return (this.tH) && (!TextUtils.isEmpty(this.hint)) && ((this.tJ instanceof e));
  }
  
  private void dc()
  {
    if (!db()) {
      return;
    }
    RectF localRectF = this.tY;
    this.nS.a(localRectF);
    c(localRectF);
    ((e)this.tJ).b(localRectF);
  }
  
  private void dd()
  {
    if (db()) {
      ((e)this.tJ).a(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  private Drawable getBoxBackground()
  {
    if ((this.tM == 1) || (this.tM == 2)) {
      return this.tJ;
    }
    throw new IllegalStateException();
  }
  
  private float[] getCornerRadiiAsArray()
  {
    if (!android.support.design.internal.g.d(this)) {
      return new float[] { this.tO, this.tO, this.tP, this.tP, this.tQ, this.tQ, this.tR, this.tR };
    }
    return new float[] { this.tP, this.tP, this.tO, this.tO, this.tR, this.tR, this.tQ, this.tQ };
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.ty != null) {
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    }
    this.ty = paramEditText;
    cM();
    setTextInputAccessibilityDelegate(new a(this));
    if (!cY()) {
      this.nS.b(this.ty.getTypeface());
    }
    paramEditText = this.nS;
    float f = this.ty.getTextSize();
    if (paramEditText.nb != f)
    {
      paramEditText.nb = f;
      paramEditText.bX();
    }
    int i = this.ty.getGravity();
    this.nS.P(i & 0xFFFFFF8F | 0x30);
    this.nS.O(i);
    this.ty.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        TextInputLayout localTextInputLayout = TextInputLayout.this;
        if (!TextInputLayout.a(TextInputLayout.this)) {}
        for (boolean bool = true;; bool = false)
        {
          localTextInputLayout.d(bool, false);
          if (TextInputLayout.this.tB) {
            TextInputLayout.this.al(paramAnonymousEditable.length());
          }
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.ul == null) {
      this.ul = this.ty.getHintTextColors();
    }
    if (this.tH)
    {
      if (TextUtils.isEmpty(this.hint))
      {
        this.tz = this.ty.getHint();
        setHint(this.tz);
        this.ty.setHint(null);
      }
      this.tI = true;
    }
    if (this.tE != null) {
      al(this.ty.getText().length());
    }
    this.tA.cy();
    cX();
    d(false, true);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.hint))
    {
      this.hint = paramCharSequence;
      this.nS.setText(paramCharSequence);
      if (!this.ur) {
        dc();
      }
    }
  }
  
  private void x(float paramFloat)
  {
    if (this.nS.mT == paramFloat) {
      return;
    }
    if (this.rT == null)
    {
      this.rT = new ValueAnimator();
      this.rT.setInterpolator(android.support.design.a.a.eQ);
      this.rT.setDuration(167L);
      this.rT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TextInputLayout.this.nS.m(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        }
      });
    }
    this.rT.setFloatValues(new float[] { this.nS.mT, paramFloat });
    this.rT.start();
  }
  
  private void z(boolean paramBoolean)
  {
    if ((this.rT != null) && (this.rT.isRunning())) {
      this.rT.cancel();
    }
    if ((paramBoolean) && (this.ut)) {
      x(1.0F);
    }
    for (;;)
    {
      this.ur = false;
      if (db()) {
        dc();
      }
      return;
      this.nS.m(1.0F);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.tx.addView(paramView, localLayoutParams);
      this.tx.setLayoutParams(paramLayoutParams);
      cO();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  final void al(int paramInt)
  {
    boolean bool2 = this.tD;
    if (this.tC == -1)
    {
      this.tE.setText(String.valueOf(paramInt));
      this.tE.setContentDescription(null);
      this.tD = false;
      if ((this.ty != null) && (bool2 != this.tD))
      {
        d(false, false);
        de();
        cV();
      }
      return;
    }
    if (t.aa(this.tE) == 1) {
      t.r(this.tE, 0);
    }
    boolean bool1;
    label98:
    TextView localTextView;
    if (paramInt > this.tC)
    {
      bool1 = true;
      this.tD = bool1;
      if (bool2 != this.tD)
      {
        localTextView = this.tE;
        if (!this.tD) {
          break label236;
        }
      }
    }
    label236:
    for (int i = this.tF;; i = this.tG)
    {
      c(localTextView, i);
      if (this.tD) {
        t.r(this.tE, 1);
      }
      this.tE.setText(getContext().getString(2131757039, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tC) }));
      this.tE.setContentDescription(getContext().getString(2131757038, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tC) }));
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
      q.d(paramTextView, 2131821332);
      paramTextView.setTextColor(b.n(getContext(), 2131100216));
    }
  }
  
  final void cV()
  {
    if (this.ty == null) {}
    Drawable localDrawable2;
    do
    {
      return;
      localDrawable2 = this.ty.getBackground();
    } while (localDrawable2 == null);
    cW();
    Drawable localDrawable1 = localDrawable2;
    if (x.t(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if (this.tA.cz())
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.b(this.tA.cA(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((this.tD) && (this.tE != null))
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.b(this.tE.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    android.support.v4.graphics.drawable.a.h(localDrawable1);
    this.ty.refreshDrawableState();
  }
  
  final void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    boolean bool1 = isEnabled();
    int i;
    label48:
    boolean bool2;
    if ((this.ty != null) && (!TextUtils.isEmpty(this.ty.getText())))
    {
      i = 1;
      if ((this.ty == null) || (!this.ty.hasFocus())) {
        break label162;
      }
      bool2 = this.tA.cz();
      if (this.ul != null)
      {
        this.nS.d(this.ul);
        this.nS.e(this.ul);
      }
      if (bool1) {
        break label168;
      }
      this.nS.d(ColorStateList.valueOf(this.uq));
      this.nS.e(ColorStateList.valueOf(this.uq));
      label119:
      if ((i == 0) && ((!isEnabled()) || ((j == 0) && (!bool2)))) {
        break label247;
      }
      if ((paramBoolean2) || (this.ur)) {
        z(paramBoolean1);
      }
    }
    label162:
    label168:
    label247:
    while ((!paramBoolean2) && (this.ur))
    {
      return;
      i = 0;
      break;
      j = 0;
      break label48;
      if (bool2)
      {
        this.nS.d(this.tA.cB());
        break label119;
      }
      if ((this.tD) && (this.tE != null))
      {
        this.nS.d(this.tE.getTextColors());
        break label119;
      }
      if ((j == 0) || (this.um == null)) {
        break label119;
      }
      this.nS.d(this.um);
      break label119;
    }
    A(paramBoolean1);
  }
  
  final void de()
  {
    int j = 1;
    if ((this.tJ == null) || (this.tM == 0)) {
      return;
    }
    int i;
    if ((this.ty != null) && (this.ty.hasFocus()))
    {
      i = 1;
      label36:
      if ((this.ty == null) || (!this.ty.isHovered())) {
        break label109;
      }
      label53:
      if (this.tM != 2) {
        break label112;
      }
      if (isEnabled()) {
        break label114;
      }
      this.tV = this.uq;
      label76:
      if (((j == 0) && (i == 0)) || (!isEnabled())) {
        break label207;
      }
    }
    label207:
    for (this.tS = this.tU;; this.tS = this.tT)
    {
      cU();
      return;
      i = 0;
      break label36;
      label109:
      j = 0;
      break label53;
      label112:
      break;
      label114:
      if (this.tA.cz())
      {
        this.tV = this.tA.cA();
        break label76;
      }
      if ((this.tD) && (this.tE != null))
      {
        this.tV = this.tE.getCurrentTextColor();
        break label76;
      }
      if (i != 0)
      {
        this.tV = this.up;
        break label76;
      }
      if (j != 0)
      {
        this.tV = this.uo;
        break label76;
      }
      this.tV = this.un;
      break label76;
    }
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if ((this.tz == null) || (this.ty == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    boolean bool = this.tI;
    this.tI = false;
    CharSequence localCharSequence = this.ty.getHint();
    this.ty.setHint(this.tz);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.ty.setHint(localCharSequence);
      this.tI = bool;
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.uw = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.uw = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.tJ != null) {
      this.tJ.draw(paramCanvas);
    }
    super.draw(paramCanvas);
    if (this.tH) {
      this.nS.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    if (this.uv) {
      return;
    }
    this.uv = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((t.ay(this)) && (isEnabled()))
    {
      d(bool2, false);
      cV();
      cP();
      de();
      if (this.nS == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool1 = this.nS.setState(arrayOfInt) | false;; bool1 = false)
    {
      if (bool1) {
        invalidate();
      }
      this.uv = false;
      return;
      bool2 = false;
      break;
    }
  }
  
  public int getBoxBackgroundColor()
  {
    return this.tW;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.tQ;
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.tR;
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.tP;
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.tO;
  }
  
  public int getBoxStrokeColor()
  {
    return this.up;
  }
  
  public int getCounterMaxLength()
  {
    return this.tC;
  }
  
  CharSequence getCounterOverflowDescription()
  {
    if ((this.tB) && (this.tD) && (this.tE != null)) {
      return this.tE.getContentDescription();
    }
    return null;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.ul;
  }
  
  public EditText getEditText()
  {
    return this.ty;
  }
  
  public CharSequence getError()
  {
    if (this.tA.qv) {
      return this.tA.qu;
    }
    return null;
  }
  
  public int getErrorCurrentTextColors()
  {
    return this.tA.cA();
  }
  
  final int getErrorTextCurrentColor()
  {
    return this.tA.cA();
  }
  
  public CharSequence getHelperText()
  {
    if (this.tA.qz) {
      return this.tA.qy;
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    j localj = this.tA;
    if (localj.qA != null) {
      return localj.qA.getCurrentTextColor();
    }
    return -1;
  }
  
  public CharSequence getHint()
  {
    if (this.tH) {
      return this.hint;
    }
    return null;
  }
  
  final float getHintCollapsedTextHeight()
  {
    return this.nS.bQ();
  }
  
  final int getHintCurrentCollapsedTextColor()
  {
    return this.nS.bU();
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.ub;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.ua;
  }
  
  public Typeface getTypeface()
  {
    return this.qC;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.tJ != null) {
      cP();
    }
    Rect localRect;
    int i;
    if ((this.tH) && (this.ty != null))
    {
      localRect = this.kK;
      f.a(this, this.ty, localRect);
      paramInt1 = localRect.left;
      paramInt3 = this.ty.getCompoundPaddingLeft() + paramInt1;
      i = localRect.right - this.ty.getCompoundPaddingRight();
      switch (this.tM)
      {
      default: 
        paramInt1 = getPaddingTop();
      }
    }
    for (;;)
    {
      this.nS.c(paramInt3, localRect.top + this.ty.getCompoundPaddingTop(), i, localRect.bottom - this.ty.getCompoundPaddingBottom());
      this.nS.d(paramInt3, paramInt1, i, paramInt4 - paramInt2 - getPaddingBottom());
      this.nS.bX();
      if ((db()) && (!this.ur)) {
        dc();
      }
      return;
      paramInt1 = getBoxBackground().getBounds().top - cR();
      continue;
      paramInt1 = getBoxBackground().getBounds().top + this.tN;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    cX();
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
    super.onRestoreInstanceState(paramParcelable.Nj);
    setError(paramParcelable.uz);
    if (paramParcelable.uA) {
      y(true);
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.tA.cz()) {
      localSavedState.uz = getError();
    }
    localSavedState.uA = this.ud;
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    if (this.tW != paramInt)
    {
      this.tW = paramInt;
      cU();
    }
  }
  
  public void setBoxBackgroundColorResource(int paramInt)
  {
    setBoxBackgroundColor(b.n(getContext(), paramInt));
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.tM) {
      return;
    }
    this.tM = paramInt;
    cM();
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    if (this.up != paramInt)
    {
      this.up = paramInt;
      de();
    }
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.tB != paramBoolean)
    {
      if (!paramBoolean) {
        break label124;
      }
      this.tE = new AppCompatTextView(getContext());
      this.tE.setId(2131305751);
      if (this.qC != null) {
        this.tE.setTypeface(this.qC);
      }
      this.tE.setMaxLines(1);
      c(this.tE, this.tG);
      this.tA.a(this.tE, 2);
      if (this.ty != null) {
        break label105;
      }
      al(0);
    }
    for (;;)
    {
      this.tB = paramBoolean;
      return;
      label105:
      al(this.ty.getText().length());
      continue;
      label124:
      this.tA.b(this.tE, 2);
      this.tE = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.tC != paramInt)
    {
      if (paramInt <= 0) {
        break label39;
      }
      this.tC = paramInt;
      if (this.tB) {
        if (this.ty != null) {
          break label47;
        }
      }
    }
    label39:
    label47:
    for (paramInt = 0;; paramInt = this.ty.getText().length())
    {
      al(paramInt);
      return;
      this.tC = -1;
      break;
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    this.ul = paramColorStateList;
    this.um = paramColorStateList;
    if (this.ty != null) {
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
    if (!this.tA.qv)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      j localj = this.tA;
      localj.cx();
      localj.qu = paramCharSequence;
      localj.qw.setText(paramCharSequence);
      if (localj.qs != 1) {
        localj.qt = 1;
      }
      localj.a(localj.qs, localj.qt, localj.a(localj.qw, paramCharSequence));
      return;
    }
    this.tA.cw();
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    j localj = this.tA;
    if (localj.qv != paramBoolean)
    {
      localj.cx();
      if (!paramBoolean) {
        break label103;
      }
      localj.qw = new AppCompatTextView(localj.context);
      localj.qw.setId(2131305752);
      if (localj.qC != null) {
        localj.qw.setTypeface(localj.qC);
      }
      localj.setErrorTextAppearance(localj.qx);
      localj.qw.setVisibility(4);
      t.r(localj.qw, 1);
      localj.a(localj.qw, 0);
    }
    for (;;)
    {
      localj.qv = paramBoolean;
      return;
      label103:
      localj.cw();
      localj.b(localj.qw, 0);
      localj.qw = null;
      localj.qk.cV();
      localj.qk.de();
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.tA.setErrorTextAppearance(paramInt);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    j localj = this.tA;
    if (localj.qw != null) {
      localj.qw.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (this.tA.qz) {
        setHelperTextEnabled(false);
      }
      return;
    }
    if (!this.tA.qz) {
      setHelperTextEnabled(true);
    }
    j localj = this.tA;
    localj.cx();
    localj.qy = paramCharSequence;
    localj.qA.setText(paramCharSequence);
    if (localj.qs != 2) {
      localj.qt = 2;
    }
    localj.a(localj.qs, localj.qt, localj.a(localj.qA, paramCharSequence));
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    j localj = this.tA;
    if (localj.qA != null) {
      localj.qA.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    j localj = this.tA;
    if (localj.qz != paramBoolean)
    {
      localj.cx();
      if (!paramBoolean) {
        break label103;
      }
      localj.qA = new AppCompatTextView(localj.context);
      localj.qA.setId(2131305753);
      if (localj.qC != null) {
        localj.qA.setTypeface(localj.qC);
      }
      localj.qA.setVisibility(4);
      t.r(localj.qA, 1);
      localj.ab(localj.qB);
      localj.a(localj.qA, 1);
    }
    for (;;)
    {
      localj.qz = paramBoolean;
      return;
      label103:
      localj.cx();
      if (localj.qs == 2) {
        localj.qt = 0;
      }
      localj.a(localj.qs, localj.qt, localj.a(localj.qA, null));
      localj.b(localj.qA, 1);
      localj.qA = null;
      localj.qk.cV();
      localj.qk.de();
    }
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    this.tA.ab(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.tH)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.ut = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.tH)
    {
      this.tH = paramBoolean;
      if (this.tH) {
        break label76;
      }
      this.tI = false;
      if ((!TextUtils.isEmpty(this.hint)) && (TextUtils.isEmpty(this.ty.getHint()))) {
        this.ty.setHint(this.hint);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (this.ty != null) {
        cO();
      }
      return;
      label76:
      CharSequence localCharSequence = this.ty.getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.hint)) {
          setHint(localCharSequence);
        }
        this.ty.setHint(null);
      }
      this.tI = true;
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    this.nS.Q(paramInt);
    this.um = this.nS.ne;
    if (this.ty != null)
    {
      d(false, false);
      cO();
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
    this.ub = paramCharSequence;
    if (this.uc != null) {
      this.uc.setContentDescription(paramCharSequence);
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
    this.ua = paramDrawable;
    if (this.uc != null) {
      this.uc.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.tZ != paramBoolean)
    {
      this.tZ = paramBoolean;
      if ((!paramBoolean) && (this.ud) && (this.ty != null)) {
        this.ty.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      this.ud = false;
      cX();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.ug = paramColorStateList;
    this.uh = true;
    da();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.uj = paramMode;
    this.uk = true;
    da();
  }
  
  public void setTextInputAccessibilityDelegate(a parama)
  {
    if (this.ty != null) {
      t.a(this.ty, parama);
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != this.qC)
    {
      this.qC = paramTypeface;
      this.nS.b(paramTypeface);
      j localj = this.tA;
      if (paramTypeface != localj.qC)
      {
        localj.qC = paramTypeface;
        j.a(localj.qw, paramTypeface);
        j.a(localj.qA, paramTypeface);
      }
      if (this.tE != null) {
        this.tE.setTypeface(paramTypeface);
      }
    }
  }
  
  public final void y(boolean paramBoolean)
  {
    int i;
    if (this.tZ)
    {
      i = this.ty.getSelectionEnd();
      if (!cY()) {
        break label66;
      }
      this.ty.setTransformationMethod(null);
    }
    for (this.ud = true;; this.ud = false)
    {
      this.uc.setChecked(this.ud);
      if (paramBoolean) {
        this.uc.jumpDrawablesToCurrentState();
      }
      this.ty.setSelection(i);
      return;
      label66:
      this.ty.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean uA;
    CharSequence uz;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.uz = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      if (paramParcel.readInt() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.uA = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.uz + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.uz, paramParcel, paramInt);
      if (this.uA) {}
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
    private final TextInputLayout uy;
    
    public a(TextInputLayout paramTextInputLayout)
    {
      this.uy = paramTextInputLayout;
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      int n = 0;
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      paramView = this.uy.getEditText();
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
        localCharSequence3 = this.uy.getHint();
        localCharSequence1 = this.uy.getError();
        localCharSequence2 = this.uy.getCounterOverflowDescription();
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
          paramc.Pm.setHintText(localCharSequence3);
          label131:
          if ((i != 0) || (k == 0)) {
            break label273;
          }
          bool = true;
          label143:
          if (Build.VERSION.SDK_INT < 26) {
            break label279;
          }
          paramc.Pm.setShowingHintText(bool);
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
          paramc.Pm.setError(paramView);
        }
        if (Build.VERSION.SDK_INT >= 19) {
          paramc.Pm.setContentInvalid(true);
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
        paramc.Pm.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", localCharSequence3);
        break label131;
        bool = false;
        break label143;
        if (Build.VERSION.SDK_INT >= 19) {}
        for (paramView = paramc.Pm.getExtras();; paramView = new Bundle())
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
      paramView = this.uy.getEditText();
      if (paramView != null) {}
      for (paramView = paramView.getText();; paramView = null)
      {
        Object localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = this.uy.getHint();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramAccessibilityEvent.getText().add(localObject);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */