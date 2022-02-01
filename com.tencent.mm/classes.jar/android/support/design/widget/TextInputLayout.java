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
  private final Rect jL = new Rect();
  final d mR = new d(this);
  private Typeface pC;
  private ValueAnimator qT;
  private CharSequence sA;
  private final j sB = new j(this);
  boolean sC;
  private int sD;
  private boolean sE;
  private TextView sF;
  private final int sG;
  private final int sH;
  private boolean sI;
  boolean sJ;
  private GradientDrawable sK;
  private final int sL;
  private final int sM;
  private int sN;
  private final int sO;
  private float sP;
  private float sQ;
  private float sR;
  private float sS;
  private int sT;
  private final int sU;
  private final int sV;
  private int sW;
  private int sX;
  private Drawable sY;
  private final RectF sZ = new RectF();
  private final FrameLayout sy;
  EditText sz;
  private boolean ta;
  private Drawable tb;
  private CharSequence tc;
  private CheckableImageButton td;
  private boolean te;
  private Drawable tf;
  private Drawable tg;
  private ColorStateList th;
  private boolean ti;
  private PorterDuff.Mode tj;
  private boolean tk;
  private ColorStateList tl;
  private ColorStateList tm;
  private final int tn;
  private final int to;
  private int tp;
  private final int tq;
  private boolean tr;
  private boolean ts;
  private boolean tt;
  private boolean tu;
  private boolean tv;
  
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
    this.sy = new FrameLayout(paramContext);
    this.sy.setAddStatesFromChildren(true);
    addView(this.sy);
    this.mR.a(android.support.design.a.a.dP);
    Object localObject = this.mR;
    ((d)localObject).my = android.support.design.a.a.dP;
    ((d)localObject).bQ();
    this.mR.P(8388659);
    paramAttributeSet = android.support.design.internal.f.b(paramContext, paramAttributeSet, a.a.TextInputLayout, paramInt, 2131821642, new int[0]);
    this.sI = paramAttributeSet.getBoolean(21, true);
    setHint(paramAttributeSet.getText(1));
    this.ts = paramAttributeSet.getBoolean(20, true);
    this.sL = paramContext.getResources().getDimensionPixelOffset(2131166644);
    this.sM = paramContext.getResources().getDimensionPixelOffset(2131166647);
    this.sO = paramAttributeSet.getDimensionPixelOffset(4, 0);
    this.sP = paramAttributeSet.dc(8);
    this.sQ = paramAttributeSet.dc(7);
    this.sR = paramAttributeSet.dc(5);
    this.sS = paramAttributeSet.dc(6);
    this.sX = paramAttributeSet.getColor(2, 0);
    this.tp = paramAttributeSet.getColor(9, 0);
    this.sU = paramContext.getResources().getDimensionPixelSize(2131166649);
    this.sV = paramContext.getResources().getDimensionPixelSize(2131166650);
    this.sT = this.sU;
    setBoxBackgroundMode(paramAttributeSet.getInt(3, 0));
    if (paramAttributeSet.hasValue(0))
    {
      localObject = paramAttributeSet.getColorStateList(0);
      this.tm = ((ColorStateList)localObject);
      this.tl = ((ColorStateList)localObject);
    }
    this.tn = b.n(paramContext, 2131100678);
    this.tq = b.n(paramContext, 2131100679);
    this.to = b.n(paramContext, 2131100681);
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
    this.sH = paramAttributeSet.getResourceId(14, 0);
    this.sG = paramAttributeSet.getResourceId(13, 0);
    this.ta = paramAttributeSet.getBoolean(25, false);
    this.tb = paramAttributeSet.getDrawable(24);
    this.tc = paramAttributeSet.getText(23);
    if (paramAttributeSet.hasValue(26))
    {
      this.ti = true;
      this.th = paramAttributeSet.getColorStateList(26);
    }
    if (paramAttributeSet.hasValue(27))
    {
      this.tk = true;
      this.tj = android.support.design.internal.g.a(paramAttributeSet.getInt(27, -1), null);
    }
    paramAttributeSet.avP.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(paramContext);
    setHelperTextTextAppearance(i);
    setErrorEnabled(bool1);
    setErrorTextAppearance(paramInt);
    setCounterEnabled(bool3);
    cT();
    t.p(this, 2);
  }
  
  private void A(boolean paramBoolean)
  {
    if ((this.qT != null) && (this.qT.isRunning())) {
      this.qT.cancel();
    }
    if ((paramBoolean) && (this.ts)) {
      t(0.0F);
    }
    for (;;)
    {
      if ((cU()) && (((e)this.sK).ca())) {
        cW();
      }
      this.tr = true;
      return;
      this.mR.i(0.0F);
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
    paramRectF.left -= this.sM;
    paramRectF.top -= this.sM;
    paramRectF.right += this.sM;
    paramRectF.bottom += this.sM;
  }
  
  private void cF()
  {
    cG();
    if (this.sN != 0) {
      cH();
    }
    cI();
  }
  
  private void cG()
  {
    if (this.sN == 0) {
      this.sK = null;
    }
    do
    {
      return;
      if ((this.sN == 2) && (this.sI) && (!(this.sK instanceof e)))
      {
        this.sK = new e();
        return;
      }
    } while ((this.sK instanceof GradientDrawable));
    this.sK = new GradientDrawable();
  }
  
  private void cH()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.sy.getLayoutParams();
    int i = cK();
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.sy.requestLayout();
    }
  }
  
  private void cI()
  {
    if ((this.sN == 0) || (this.sK == null) || (this.sz == null) || (getRight() == 0)) {
      return;
    }
    int i3 = this.sz.getLeft();
    int i2 = cJ();
    int i1 = this.sz.getRight();
    int n = this.sz.getBottom() + this.sL;
    int m = n;
    int k = i1;
    int j = i2;
    int i = i3;
    if (this.sN == 2)
    {
      i = i3 + this.sV / 2;
      j = i2 - this.sV / 2;
      k = i1 - this.sV / 2;
      m = n + this.sV / 2;
    }
    this.sK.setBounds(i, j, k, m);
    cN();
    cL();
  }
  
  private int cJ()
  {
    if (this.sz == null) {
      return 0;
    }
    switch (this.sN)
    {
    default: 
      return 0;
    case 1: 
      return this.sz.getTop();
    }
    return this.sz.getTop() + cK();
  }
  
  private int cK()
  {
    if (!this.sI) {
      return 0;
    }
    switch (this.sN)
    {
    default: 
      return 0;
    case 0: 
    case 1: 
      return (int)this.mR.bJ();
    }
    return (int)(this.mR.bJ() / 2.0F);
  }
  
  private void cL()
  {
    if (this.sz == null) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = this.sz.getBackground();
      } while (localObject2 == null);
      localObject1 = localObject2;
      if (x.t((Drawable)localObject2)) {
        localObject1 = ((Drawable)localObject2).mutate();
      }
      localObject2 = new Rect();
      f.a(this, this.sz, (Rect)localObject2);
      localObject2 = ((Drawable)localObject1).getBounds();
    } while (((Rect)localObject2).left == ((Rect)localObject2).right);
    Rect localRect = new Rect();
    ((Drawable)localObject1).getPadding(localRect);
    int i = ((Rect)localObject2).left;
    int j = localRect.left;
    int k = ((Rect)localObject2).right;
    int m = localRect.right;
    ((Drawable)localObject1).setBounds(i - j, ((Rect)localObject2).top, m * 2 + k, this.sz.getBottom());
  }
  
  private void cM()
  {
    switch (this.sN)
    {
    }
    do
    {
      return;
      this.sT = 0;
      return;
    } while (this.tp != 0);
    this.tp = this.tm.getColorForState(getDrawableState(), this.tm.getDefaultColor());
  }
  
  private void cN()
  {
    if (this.sK == null) {
      return;
    }
    cM();
    if ((this.sz != null) && (this.sN == 2))
    {
      if (this.sz.getBackground() != null) {
        this.sY = this.sz.getBackground();
      }
      t.a(this.sz, null);
    }
    if ((this.sz != null) && (this.sN == 1) && (this.sY != null)) {
      t.a(this.sz, this.sY);
    }
    if ((this.sT >= 0) && (this.sW != 0)) {
      this.sK.setStroke(this.sT, this.sW);
    }
    this.sK.setCornerRadii(getCornerRadiiAsArray());
    this.sK.setColor(this.sX);
    invalidate();
  }
  
  private void cP()
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
        localDrawable1 = this.sz.getBackground();
      } while ((localDrawable1 == null) || (this.tt));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.tt = g.a((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
    } while (this.tt);
    t.a(this.sz, localDrawable2);
    this.tt = true;
    cF();
  }
  
  private void cQ()
  {
    if (this.sz == null) {}
    Drawable[] arrayOfDrawable;
    do
    {
      do
      {
        return;
        if (cS())
        {
          if (this.td == null)
          {
            this.td = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(2131493705, this.sy, false));
            this.td.setImageDrawable(this.tb);
            this.td.setContentDescription(this.tc);
            this.sy.addView(this.td);
            this.td.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                TextInputLayout.this.y(false);
              }
            });
          }
          if ((this.sz != null) && (t.af(this.sz) <= 0)) {
            this.sz.setMinimumHeight(t.af(this.td));
          }
          this.td.setVisibility(0);
          this.td.setChecked(this.te);
          if (this.tf == null) {
            this.tf = new ColorDrawable();
          }
          this.tf.setBounds(0, 0, this.td.getMeasuredWidth(), 1);
          arrayOfDrawable = q.c(this.sz);
          if (arrayOfDrawable[2] != this.tf) {
            this.tg = arrayOfDrawable[2];
          }
          q.a(this.sz, arrayOfDrawable[0], arrayOfDrawable[1], this.tf, arrayOfDrawable[3]);
          this.td.setPadding(this.sz.getPaddingLeft(), this.sz.getPaddingTop(), this.sz.getPaddingRight(), this.sz.getPaddingBottom());
          return;
        }
        if ((this.td != null) && (this.td.getVisibility() == 0)) {
          this.td.setVisibility(8);
        }
      } while (this.tf == null);
      arrayOfDrawable = q.c(this.sz);
    } while (arrayOfDrawable[2] != this.tf);
    q.a(this.sz, arrayOfDrawable[0], arrayOfDrawable[1], this.tg, arrayOfDrawable[3]);
    this.tf = null;
  }
  
  private boolean cR()
  {
    return (this.sz != null) && ((this.sz.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private boolean cS()
  {
    return (this.ta) && ((cR()) || (this.te));
  }
  
  private void cT()
  {
    if ((this.tb != null) && ((this.ti) || (this.tk)))
    {
      this.tb = android.support.v4.graphics.drawable.a.i(this.tb).mutate();
      if (this.ti) {
        android.support.v4.graphics.drawable.a.a(this.tb, this.th);
      }
      if (this.tk) {
        android.support.v4.graphics.drawable.a.a(this.tb, this.tj);
      }
      if ((this.td != null) && (this.td.getDrawable() != this.tb)) {
        this.td.setImageDrawable(this.tb);
      }
    }
  }
  
  private boolean cU()
  {
    return (this.sI) && (!TextUtils.isEmpty(this.hint)) && ((this.sK instanceof e));
  }
  
  private void cV()
  {
    if (!cU()) {
      return;
    }
    RectF localRectF = this.sZ;
    this.mR.a(localRectF);
    c(localRectF);
    ((e)this.sK).b(localRectF);
  }
  
  private void cW()
  {
    if (cU()) {
      ((e)this.sK).a(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  private Drawable getBoxBackground()
  {
    if ((this.sN == 1) || (this.sN == 2)) {
      return this.sK;
    }
    throw new IllegalStateException();
  }
  
  private float[] getCornerRadiiAsArray()
  {
    if (!android.support.design.internal.g.d(this)) {
      return new float[] { this.sP, this.sP, this.sQ, this.sQ, this.sR, this.sR, this.sS, this.sS };
    }
    return new float[] { this.sQ, this.sQ, this.sP, this.sP, this.sS, this.sS, this.sR, this.sR };
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.sz != null) {
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    }
    this.sz = paramEditText;
    cF();
    setTextInputAccessibilityDelegate(new a(this));
    if (!cR()) {
      this.mR.b(this.sz.getTypeface());
    }
    paramEditText = this.mR;
    float f = this.sz.getTextSize();
    if (paramEditText.ma != f)
    {
      paramEditText.ma = f;
      paramEditText.bQ();
    }
    int i = this.sz.getGravity();
    this.mR.P(i & 0xFFFFFF8F | 0x30);
    this.mR.O(i);
    this.sz.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        TextInputLayout localTextInputLayout = TextInputLayout.this;
        if (!TextInputLayout.a(TextInputLayout.this)) {}
        for (boolean bool = true;; bool = false)
        {
          localTextInputLayout.d(bool, false);
          if (TextInputLayout.this.sC) {
            TextInputLayout.this.al(paramAnonymousEditable.length());
          }
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.tl == null) {
      this.tl = this.sz.getHintTextColors();
    }
    if (this.sI)
    {
      if (TextUtils.isEmpty(this.hint))
      {
        this.sA = this.sz.getHint();
        setHint(this.sA);
        this.sz.setHint(null);
      }
      this.sJ = true;
    }
    if (this.sF != null) {
      al(this.sz.getText().length());
    }
    this.sB.cr();
    cQ();
    d(false, true);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.hint))
    {
      this.hint = paramCharSequence;
      this.mR.setText(paramCharSequence);
      if (!this.tr) {
        cV();
      }
    }
  }
  
  private void t(float paramFloat)
  {
    if (this.mR.lU == paramFloat) {
      return;
    }
    if (this.qT == null)
    {
      this.qT = new ValueAnimator();
      this.qT.setInterpolator(android.support.design.a.a.dQ);
      this.qT.setDuration(167L);
      this.qT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TextInputLayout.this.mR.i(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        }
      });
    }
    this.qT.setFloatValues(new float[] { this.mR.lU, paramFloat });
    this.qT.start();
  }
  
  private void z(boolean paramBoolean)
  {
    if ((this.qT != null) && (this.qT.isRunning())) {
      this.qT.cancel();
    }
    if ((paramBoolean) && (this.ts)) {
      t(1.0F);
    }
    for (;;)
    {
      this.tr = false;
      if (cU()) {
        cV();
      }
      return;
      this.mR.i(1.0F);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.sy.addView(paramView, localLayoutParams);
      this.sy.setLayoutParams(paramLayoutParams);
      cH();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  final void al(int paramInt)
  {
    boolean bool2 = this.sE;
    if (this.sD == -1)
    {
      this.sF.setText(String.valueOf(paramInt));
      this.sF.setContentDescription(null);
      this.sE = false;
      if ((this.sz != null) && (bool2 != this.sE))
      {
        d(false, false);
        cX();
        cO();
      }
      return;
    }
    if (t.aa(this.sF) == 1) {
      t.r(this.sF, 0);
    }
    boolean bool1;
    label98:
    TextView localTextView;
    if (paramInt > this.sD)
    {
      bool1 = true;
      this.sE = bool1;
      if (bool2 != this.sE)
      {
        localTextView = this.sF;
        if (!this.sE) {
          break label236;
        }
      }
    }
    label236:
    for (int i = this.sG;; i = this.sH)
    {
      c(localTextView, i);
      if (this.sE) {
        t.r(this.sF, 1);
      }
      this.sF.setText(getContext().getString(2131757039, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sD) }));
      this.sF.setContentDescription(getContext().getString(2131757038, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sD) }));
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
  
  final void cO()
  {
    if (this.sz == null) {}
    Drawable localDrawable2;
    do
    {
      return;
      localDrawable2 = this.sz.getBackground();
    } while (localDrawable2 == null);
    cP();
    Drawable localDrawable1 = localDrawable2;
    if (x.t(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if (this.sB.cs())
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.b(this.sB.ct(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((this.sE) && (this.sF != null))
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.b(this.sF.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    android.support.v4.graphics.drawable.a.h(localDrawable1);
    this.sz.refreshDrawableState();
  }
  
  final void cX()
  {
    int j = 1;
    if ((this.sK == null) || (this.sN == 0)) {
      return;
    }
    int i;
    if ((this.sz != null) && (this.sz.hasFocus()))
    {
      i = 1;
      label36:
      if ((this.sz == null) || (!this.sz.isHovered())) {
        break label109;
      }
      label53:
      if (this.sN != 2) {
        break label112;
      }
      if (isEnabled()) {
        break label114;
      }
      this.sW = this.tq;
      label76:
      if (((j == 0) && (i == 0)) || (!isEnabled())) {
        break label207;
      }
    }
    label207:
    for (this.sT = this.sV;; this.sT = this.sU)
    {
      cN();
      return;
      i = 0;
      break label36;
      label109:
      j = 0;
      break label53;
      label112:
      break;
      label114:
      if (this.sB.cs())
      {
        this.sW = this.sB.ct();
        break label76;
      }
      if ((this.sE) && (this.sF != null))
      {
        this.sW = this.sF.getCurrentTextColor();
        break label76;
      }
      if (i != 0)
      {
        this.sW = this.tp;
        break label76;
      }
      if (j != 0)
      {
        this.sW = this.to;
        break label76;
      }
      this.sW = this.tn;
      break label76;
    }
  }
  
  final void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    boolean bool1 = isEnabled();
    int i;
    label48:
    boolean bool2;
    if ((this.sz != null) && (!TextUtils.isEmpty(this.sz.getText())))
    {
      i = 1;
      if ((this.sz == null) || (!this.sz.hasFocus())) {
        break label162;
      }
      bool2 = this.sB.cs();
      if (this.tl != null)
      {
        this.mR.d(this.tl);
        this.mR.e(this.tl);
      }
      if (bool1) {
        break label168;
      }
      this.mR.d(ColorStateList.valueOf(this.tq));
      this.mR.e(ColorStateList.valueOf(this.tq));
      label119:
      if ((i == 0) && ((!isEnabled()) || ((j == 0) && (!bool2)))) {
        break label247;
      }
      if ((paramBoolean2) || (this.tr)) {
        z(paramBoolean1);
      }
    }
    label162:
    label168:
    label247:
    while ((!paramBoolean2) && (this.tr))
    {
      return;
      i = 0;
      break;
      j = 0;
      break label48;
      if (bool2)
      {
        this.mR.d(this.sB.cu());
        break label119;
      }
      if ((this.sE) && (this.sF != null))
      {
        this.mR.d(this.sF.getTextColors());
        break label119;
      }
      if ((j == 0) || (this.tm == null)) {
        break label119;
      }
      this.mR.d(this.tm);
      break label119;
    }
    A(paramBoolean1);
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if ((this.sA == null) || (this.sz == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    boolean bool = this.sJ;
    this.sJ = false;
    CharSequence localCharSequence = this.sz.getHint();
    this.sz.setHint(this.sA);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.sz.setHint(localCharSequence);
      this.sJ = bool;
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.tv = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.tv = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.sK != null) {
      this.sK.draw(paramCanvas);
    }
    super.draw(paramCanvas);
    if (this.sI) {
      this.mR.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    if (this.tu) {
      return;
    }
    this.tu = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((t.ay(this)) && (isEnabled()))
    {
      d(bool2, false);
      cO();
      cI();
      cX();
      if (this.mR == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool1 = this.mR.setState(arrayOfInt) | false;; bool1 = false)
    {
      if (bool1) {
        invalidate();
      }
      this.tu = false;
      return;
      bool2 = false;
      break;
    }
  }
  
  public int getBoxBackgroundColor()
  {
    return this.sX;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.sR;
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.sS;
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.sQ;
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.sP;
  }
  
  public int getBoxStrokeColor()
  {
    return this.tp;
  }
  
  public int getCounterMaxLength()
  {
    return this.sD;
  }
  
  CharSequence getCounterOverflowDescription()
  {
    if ((this.sC) && (this.sE) && (this.sF != null)) {
      return this.sF.getContentDescription();
    }
    return null;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.tl;
  }
  
  public EditText getEditText()
  {
    return this.sz;
  }
  
  public CharSequence getError()
  {
    if (this.sB.pv) {
      return this.sB.pu;
    }
    return null;
  }
  
  public int getErrorCurrentTextColors()
  {
    return this.sB.ct();
  }
  
  final int getErrorTextCurrentColor()
  {
    return this.sB.ct();
  }
  
  public CharSequence getHelperText()
  {
    if (this.sB.pz) {
      return this.sB.py;
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    j localj = this.sB;
    if (localj.pA != null) {
      return localj.pA.getCurrentTextColor();
    }
    return -1;
  }
  
  public CharSequence getHint()
  {
    if (this.sI) {
      return this.hint;
    }
    return null;
  }
  
  final float getHintCollapsedTextHeight()
  {
    return this.mR.bJ();
  }
  
  final int getHintCurrentCollapsedTextColor()
  {
    return this.mR.bN();
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.tc;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.tb;
  }
  
  public Typeface getTypeface()
  {
    return this.pC;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.sK != null) {
      cI();
    }
    Rect localRect;
    int i;
    if ((this.sI) && (this.sz != null))
    {
      localRect = this.jL;
      f.a(this, this.sz, localRect);
      paramInt1 = localRect.left;
      paramInt3 = this.sz.getCompoundPaddingLeft() + paramInt1;
      i = localRect.right - this.sz.getCompoundPaddingRight();
      switch (this.sN)
      {
      default: 
        paramInt1 = getPaddingTop();
      }
    }
    for (;;)
    {
      this.mR.c(paramInt3, localRect.top + this.sz.getCompoundPaddingTop(), i, localRect.bottom - this.sz.getCompoundPaddingBottom());
      this.mR.d(paramInt3, paramInt1, i, paramInt4 - paramInt2 - getPaddingBottom());
      this.mR.bQ();
      if ((cU()) && (!this.tr)) {
        cV();
      }
      return;
      paramInt1 = getBoxBackground().getBounds().top - cK();
      continue;
      paramInt1 = getBoxBackground().getBounds().top + this.sO;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    cQ();
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
    super.onRestoreInstanceState(paramParcelable.Mm);
    setError(paramParcelable.ty);
    if (paramParcelable.tz) {
      y(true);
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.sB.cs()) {
      localSavedState.ty = getError();
    }
    localSavedState.tz = this.te;
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    if (this.sX != paramInt)
    {
      this.sX = paramInt;
      cN();
    }
  }
  
  public void setBoxBackgroundColorResource(int paramInt)
  {
    setBoxBackgroundColor(b.n(getContext(), paramInt));
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.sN) {
      return;
    }
    this.sN = paramInt;
    cF();
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    if (this.tp != paramInt)
    {
      this.tp = paramInt;
      cX();
    }
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.sC != paramBoolean)
    {
      if (!paramBoolean) {
        break label124;
      }
      this.sF = new AppCompatTextView(getContext());
      this.sF.setId(2131305751);
      if (this.pC != null) {
        this.sF.setTypeface(this.pC);
      }
      this.sF.setMaxLines(1);
      c(this.sF, this.sH);
      this.sB.a(this.sF, 2);
      if (this.sz != null) {
        break label105;
      }
      al(0);
    }
    for (;;)
    {
      this.sC = paramBoolean;
      return;
      label105:
      al(this.sz.getText().length());
      continue;
      label124:
      this.sB.b(this.sF, 2);
      this.sF = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.sD != paramInt)
    {
      if (paramInt <= 0) {
        break label39;
      }
      this.sD = paramInt;
      if (this.sC) {
        if (this.sz != null) {
          break label47;
        }
      }
    }
    label39:
    label47:
    for (paramInt = 0;; paramInt = this.sz.getText().length())
    {
      al(paramInt);
      return;
      this.sD = -1;
      break;
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    this.tl = paramColorStateList;
    this.tm = paramColorStateList;
    if (this.sz != null) {
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
    if (!this.sB.pv)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      j localj = this.sB;
      localj.cq();
      localj.pu = paramCharSequence;
      localj.pw.setText(paramCharSequence);
      if (localj.ps != 1) {
        localj.pt = 1;
      }
      localj.a(localj.ps, localj.pt, localj.a(localj.pw, paramCharSequence));
      return;
    }
    this.sB.cp();
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    j localj = this.sB;
    if (localj.pv != paramBoolean)
    {
      localj.cq();
      if (!paramBoolean) {
        break label103;
      }
      localj.pw = new AppCompatTextView(localj.context);
      localj.pw.setId(2131305752);
      if (localj.pC != null) {
        localj.pw.setTypeface(localj.pC);
      }
      localj.setErrorTextAppearance(localj.px);
      localj.pw.setVisibility(4);
      t.r(localj.pw, 1);
      localj.a(localj.pw, 0);
    }
    for (;;)
    {
      localj.pv = paramBoolean;
      return;
      label103:
      localj.cp();
      localj.b(localj.pw, 0);
      localj.pw = null;
      localj.pl.cO();
      localj.pl.cX();
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.sB.setErrorTextAppearance(paramInt);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    j localj = this.sB;
    if (localj.pw != null) {
      localj.pw.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (this.sB.pz) {
        setHelperTextEnabled(false);
      }
      return;
    }
    if (!this.sB.pz) {
      setHelperTextEnabled(true);
    }
    j localj = this.sB;
    localj.cq();
    localj.py = paramCharSequence;
    localj.pA.setText(paramCharSequence);
    if (localj.ps != 2) {
      localj.pt = 2;
    }
    localj.a(localj.ps, localj.pt, localj.a(localj.pA, paramCharSequence));
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    j localj = this.sB;
    if (localj.pA != null) {
      localj.pA.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    j localj = this.sB;
    if (localj.pz != paramBoolean)
    {
      localj.cq();
      if (!paramBoolean) {
        break label103;
      }
      localj.pA = new AppCompatTextView(localj.context);
      localj.pA.setId(2131305753);
      if (localj.pC != null) {
        localj.pA.setTypeface(localj.pC);
      }
      localj.pA.setVisibility(4);
      t.r(localj.pA, 1);
      localj.ab(localj.pB);
      localj.a(localj.pA, 1);
    }
    for (;;)
    {
      localj.pz = paramBoolean;
      return;
      label103:
      localj.cq();
      if (localj.ps == 2) {
        localj.pt = 0;
      }
      localj.a(localj.ps, localj.pt, localj.a(localj.pA, null));
      localj.b(localj.pA, 1);
      localj.pA = null;
      localj.pl.cO();
      localj.pl.cX();
    }
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    this.sB.ab(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.sI)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.ts = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.sI)
    {
      this.sI = paramBoolean;
      if (this.sI) {
        break label76;
      }
      this.sJ = false;
      if ((!TextUtils.isEmpty(this.hint)) && (TextUtils.isEmpty(this.sz.getHint()))) {
        this.sz.setHint(this.hint);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (this.sz != null) {
        cH();
      }
      return;
      label76:
      CharSequence localCharSequence = this.sz.getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.hint)) {
          setHint(localCharSequence);
        }
        this.sz.setHint(null);
      }
      this.sJ = true;
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    this.mR.Q(paramInt);
    this.tm = this.mR.md;
    if (this.sz != null)
    {
      d(false, false);
      cH();
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
    this.tc = paramCharSequence;
    if (this.td != null) {
      this.td.setContentDescription(paramCharSequence);
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
    this.tb = paramDrawable;
    if (this.td != null) {
      this.td.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.ta != paramBoolean)
    {
      this.ta = paramBoolean;
      if ((!paramBoolean) && (this.te) && (this.sz != null)) {
        this.sz.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      this.te = false;
      cQ();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.th = paramColorStateList;
    this.ti = true;
    cT();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.tj = paramMode;
    this.tk = true;
    cT();
  }
  
  public void setTextInputAccessibilityDelegate(a parama)
  {
    if (this.sz != null) {
      t.a(this.sz, parama);
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != this.pC)
    {
      this.pC = paramTypeface;
      this.mR.b(paramTypeface);
      j localj = this.sB;
      if (paramTypeface != localj.pC)
      {
        localj.pC = paramTypeface;
        j.a(localj.pw, paramTypeface);
        j.a(localj.pA, paramTypeface);
      }
      if (this.sF != null) {
        this.sF.setTypeface(paramTypeface);
      }
    }
  }
  
  public final void y(boolean paramBoolean)
  {
    int i;
    if (this.ta)
    {
      i = this.sz.getSelectionEnd();
      if (!cR()) {
        break label66;
      }
      this.sz.setTransformationMethod(null);
    }
    for (this.te = true;; this.te = false)
    {
      this.td.setChecked(this.te);
      if (paramBoolean) {
        this.td.jumpDrawablesToCurrentState();
      }
      this.sz.setSelection(i);
      return;
      label66:
      this.sz.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    CharSequence ty;
    boolean tz;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.ty = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      if (paramParcel.readInt() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.tz = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.ty + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.ty, paramParcel, paramInt);
      if (this.tz) {}
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
    private final TextInputLayout tx;
    
    public a(TextInputLayout paramTextInputLayout)
    {
      this.tx = paramTextInputLayout;
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      int n = 0;
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      paramView = this.tx.getEditText();
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
        localCharSequence3 = this.tx.getHint();
        localCharSequence1 = this.tx.getError();
        localCharSequence2 = this.tx.getCounterOverflowDescription();
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
          paramc.Op.setHintText(localCharSequence3);
          label131:
          if ((i != 0) || (k == 0)) {
            break label273;
          }
          bool = true;
          label143:
          if (Build.VERSION.SDK_INT < 26) {
            break label279;
          }
          paramc.Op.setShowingHintText(bool);
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
          paramc.Op.setError(paramView);
        }
        if (Build.VERSION.SDK_INT >= 19) {
          paramc.Op.setContentInvalid(true);
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
        paramc.Op.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", localCharSequence3);
        break label131;
        bool = false;
        break label143;
        if (Build.VERSION.SDK_INT >= 19) {}
        for (paramView = paramc.Op.getExtras();; paramView = new Bundle())
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
      paramView = this.tx.getEditText();
      if (paramView != null) {}
      for (paramView = paramView.getText();; paramView = null)
      {
        Object localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = this.tx.getHint();
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