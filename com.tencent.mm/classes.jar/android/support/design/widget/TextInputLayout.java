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
  private ValueAnimator animator;
  private CharSequence hint;
  private final Rect mA = new Rect();
  final d pM = new d(this);
  private Typeface sx;
  private boolean vA;
  boolean vB;
  private GradientDrawable vC;
  private final int vD;
  private final int vE;
  private int vF;
  private final int vG;
  private float vH;
  private float vI;
  private float vJ;
  private float vK;
  private int vL;
  private final int vM;
  private final int vN;
  private int vO;
  private int vP;
  private Drawable vQ;
  private final RectF vR = new RectF();
  private boolean vS;
  private Drawable vT;
  private CharSequence vU;
  private CheckableImageButton vV;
  private boolean vW;
  private Drawable vX;
  private Drawable vY;
  private ColorStateList vZ;
  private final FrameLayout vq;
  EditText vr;
  private CharSequence vs;
  private final j vt = new j(this);
  boolean vu;
  private int vv;
  private boolean vw;
  private TextView vx;
  private final int vy;
  private final int vz;
  private boolean wa;
  private PorterDuff.Mode wb;
  private boolean wd;
  private ColorStateList we;
  private ColorStateList wf;
  private final int wg;
  private final int wh;
  private int wi;
  private final int wj;
  private boolean wk;
  private boolean wl;
  private boolean wm;
  private boolean wn;
  private boolean wo;
  
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
    this.vq = new FrameLayout(paramContext);
    this.vq.setAddStatesFromChildren(true);
    addView(this.vq);
    this.pM.a(android.support.design.a.a.gI);
    Object localObject = this.pM;
    ((d)localObject).pt = android.support.design.a.a.gI;
    ((d)localObject).cn();
    this.pM.O(8388659);
    paramAttributeSet = android.support.design.internal.f.b(paramContext, paramAttributeSet, a.a.TextInputLayout, paramInt, 2131821642, new int[0]);
    this.vA = paramAttributeSet.getBoolean(21, true);
    setHint(paramAttributeSet.getText(1));
    this.wl = paramAttributeSet.getBoolean(20, true);
    this.vD = paramContext.getResources().getDimensionPixelOffset(2131166644);
    this.vE = paramContext.getResources().getDimensionPixelOffset(2131166647);
    this.vG = paramAttributeSet.getDimensionPixelOffset(4, 0);
    this.vH = paramAttributeSet.db(8);
    this.vI = paramAttributeSet.db(7);
    this.vJ = paramAttributeSet.db(5);
    this.vK = paramAttributeSet.db(6);
    this.vP = paramAttributeSet.getColor(2, 0);
    this.wi = paramAttributeSet.getColor(9, 0);
    this.vM = paramContext.getResources().getDimensionPixelSize(2131166649);
    this.vN = paramContext.getResources().getDimensionPixelSize(2131166650);
    this.vL = this.vM;
    setBoxBackgroundMode(paramAttributeSet.getInt(3, 0));
    if (paramAttributeSet.hasValue(0))
    {
      localObject = paramAttributeSet.getColorStateList(0);
      this.wf = ((ColorStateList)localObject);
      this.we = ((ColorStateList)localObject);
    }
    this.wg = b.n(paramContext, 2131100678);
    this.wj = b.n(paramContext, 2131100679);
    this.wh = b.n(paramContext, 2131100681);
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
    this.vz = paramAttributeSet.getResourceId(14, 0);
    this.vy = paramAttributeSet.getResourceId(13, 0);
    this.vS = paramAttributeSet.getBoolean(25, false);
    this.vT = paramAttributeSet.getDrawable(24);
    this.vU = paramAttributeSet.getText(23);
    if (paramAttributeSet.hasValue(26))
    {
      this.wa = true;
      this.vZ = paramAttributeSet.getColorStateList(26);
    }
    if (paramAttributeSet.hasValue(27))
    {
      this.wd = true;
      this.wb = android.support.design.internal.g.a(paramAttributeSet.getInt(27, -1), null);
    }
    paramAttributeSet.ayA.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(paramContext);
    setHelperTextTextAppearance(i);
    setErrorEnabled(bool1);
    setErrorTextAppearance(paramInt);
    setCounterEnabled(bool3);
    dp();
    t.p(this, 2);
  }
  
  private void A(boolean paramBoolean)
  {
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.wl)) {
      v(0.0F);
    }
    for (;;)
    {
      if ((dq()) && (((e)this.vC).cx())) {
        ds();
      }
      this.wk = true;
      return;
      this.pM.k(0.0F);
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
    paramRectF.left -= this.vE;
    paramRectF.top -= this.vE;
    paramRectF.right += this.vE;
    paramRectF.bottom += this.vE;
  }
  
  private void db()
  {
    dc();
    if (this.vF != 0) {
      dd();
    }
    de();
  }
  
  private void dc()
  {
    if (this.vF == 0) {
      this.vC = null;
    }
    do
    {
      return;
      if ((this.vF == 2) && (this.vA) && (!(this.vC instanceof e)))
      {
        this.vC = new e();
        return;
      }
    } while ((this.vC instanceof GradientDrawable));
    this.vC = new GradientDrawable();
  }
  
  private void dd()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vq.getLayoutParams();
    int i = dg();
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.vq.requestLayout();
    }
  }
  
  private void de()
  {
    if ((this.vF == 0) || (this.vC == null) || (this.vr == null) || (getRight() == 0)) {
      return;
    }
    int i3 = this.vr.getLeft();
    int i2 = df();
    int i1 = this.vr.getRight();
    int n = this.vr.getBottom() + this.vD;
    int m = n;
    int k = i1;
    int j = i2;
    int i = i3;
    if (this.vF == 2)
    {
      i = i3 + this.vN / 2;
      j = i2 - this.vN / 2;
      k = i1 - this.vN / 2;
      m = n + this.vN / 2;
    }
    this.vC.setBounds(i, j, k, m);
    dj();
    dh();
  }
  
  private int df()
  {
    if (this.vr == null) {
      return 0;
    }
    switch (this.vF)
    {
    default: 
      return 0;
    case 1: 
      return this.vr.getTop();
    }
    return this.vr.getTop() + dg();
  }
  
  private int dg()
  {
    if (!this.vA) {
      return 0;
    }
    switch (this.vF)
    {
    default: 
      return 0;
    case 0: 
    case 1: 
      return (int)this.pM.cg();
    }
    return (int)(this.pM.cg() / 2.0F);
  }
  
  private void dh()
  {
    if (this.vr == null) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = this.vr.getBackground();
      } while (localObject2 == null);
      localObject1 = localObject2;
      if (x.t((Drawable)localObject2)) {
        localObject1 = ((Drawable)localObject2).mutate();
      }
      localObject2 = new Rect();
      f.a(this, this.vr, (Rect)localObject2);
      localObject2 = ((Drawable)localObject1).getBounds();
    } while (((Rect)localObject2).left == ((Rect)localObject2).right);
    Rect localRect = new Rect();
    ((Drawable)localObject1).getPadding(localRect);
    int i = ((Rect)localObject2).left;
    int j = localRect.left;
    int k = ((Rect)localObject2).right;
    int m = localRect.right;
    ((Drawable)localObject1).setBounds(i - j, ((Rect)localObject2).top, m * 2 + k, this.vr.getBottom());
  }
  
  private void di()
  {
    switch (this.vF)
    {
    }
    do
    {
      return;
      this.vL = 0;
      return;
    } while (this.wi != 0);
    this.wi = this.wf.getColorForState(getDrawableState(), this.wf.getDefaultColor());
  }
  
  private void dj()
  {
    if (this.vC == null) {
      return;
    }
    di();
    if ((this.vr != null) && (this.vF == 2))
    {
      if (this.vr.getBackground() != null) {
        this.vQ = this.vr.getBackground();
      }
      t.a(this.vr, null);
    }
    if ((this.vr != null) && (this.vF == 1) && (this.vQ != null)) {
      t.a(this.vr, this.vQ);
    }
    if ((this.vL >= 0) && (this.vO != 0)) {
      this.vC.setStroke(this.vL, this.vO);
    }
    this.vC.setCornerRadii(getCornerRadiiAsArray());
    this.vC.setColor(this.vP);
    invalidate();
  }
  
  private void dl()
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
        localDrawable1 = this.vr.getBackground();
      } while ((localDrawable1 == null) || (this.wm));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.wm = g.a((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
    } while (this.wm);
    t.a(this.vr, localDrawable2);
    this.wm = true;
    db();
  }
  
  private void dm()
  {
    if (this.vr == null) {}
    Drawable[] arrayOfDrawable;
    do
    {
      do
      {
        return;
        if (jdMethod_do())
        {
          if (this.vV == null)
          {
            this.vV = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(2131493705, this.vq, false));
            this.vV.setImageDrawable(this.vT);
            this.vV.setContentDescription(this.vU);
            this.vq.addView(this.vV);
            this.vV.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                TextInputLayout.this.y(false);
              }
            });
          }
          if ((this.vr != null) && (t.af(this.vr) <= 0)) {
            this.vr.setMinimumHeight(t.af(this.vV));
          }
          this.vV.setVisibility(0);
          this.vV.setChecked(this.vW);
          if (this.vX == null) {
            this.vX = new ColorDrawable();
          }
          this.vX.setBounds(0, 0, this.vV.getMeasuredWidth(), 1);
          arrayOfDrawable = q.c(this.vr);
          if (arrayOfDrawable[2] != this.vX) {
            this.vY = arrayOfDrawable[2];
          }
          q.a(this.vr, arrayOfDrawable[0], arrayOfDrawable[1], this.vX, arrayOfDrawable[3]);
          this.vV.setPadding(this.vr.getPaddingLeft(), this.vr.getPaddingTop(), this.vr.getPaddingRight(), this.vr.getPaddingBottom());
          return;
        }
        if ((this.vV != null) && (this.vV.getVisibility() == 0)) {
          this.vV.setVisibility(8);
        }
      } while (this.vX == null);
      arrayOfDrawable = q.c(this.vr);
    } while (arrayOfDrawable[2] != this.vX);
    q.a(this.vr, arrayOfDrawable[0], arrayOfDrawable[1], this.vY, arrayOfDrawable[3]);
    this.vX = null;
  }
  
  private boolean dn()
  {
    return (this.vr != null) && ((this.vr.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private boolean jdMethod_do()
  {
    return (this.vS) && ((dn()) || (this.vW));
  }
  
  private void dp()
  {
    if ((this.vT != null) && ((this.wa) || (this.wd)))
    {
      this.vT = android.support.v4.graphics.drawable.a.i(this.vT).mutate();
      if (this.wa) {
        android.support.v4.graphics.drawable.a.a(this.vT, this.vZ);
      }
      if (this.wd) {
        android.support.v4.graphics.drawable.a.a(this.vT, this.wb);
      }
      if ((this.vV != null) && (this.vV.getDrawable() != this.vT)) {
        this.vV.setImageDrawable(this.vT);
      }
    }
  }
  
  private boolean dq()
  {
    return (this.vA) && (!TextUtils.isEmpty(this.hint)) && ((this.vC instanceof e));
  }
  
  private void dr()
  {
    if (!dq()) {
      return;
    }
    RectF localRectF = this.vR;
    this.pM.a(localRectF);
    c(localRectF);
    ((e)this.vC).b(localRectF);
  }
  
  private void ds()
  {
    if (dq()) {
      ((e)this.vC).a(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  private Drawable getBoxBackground()
  {
    if ((this.vF == 1) || (this.vF == 2)) {
      return this.vC;
    }
    throw new IllegalStateException();
  }
  
  private float[] getCornerRadiiAsArray()
  {
    if (!android.support.design.internal.g.d(this)) {
      return new float[] { this.vH, this.vH, this.vI, this.vI, this.vJ, this.vJ, this.vK, this.vK };
    }
    return new float[] { this.vI, this.vI, this.vH, this.vH, this.vK, this.vK, this.vJ, this.vJ };
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.vr != null) {
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    }
    this.vr = paramEditText;
    db();
    setTextInputAccessibilityDelegate(new a(this));
    if (!dn()) {
      this.pM.b(this.vr.getTypeface());
    }
    paramEditText = this.pM;
    float f = this.vr.getTextSize();
    if (paramEditText.oV != f)
    {
      paramEditText.oV = f;
      paramEditText.cn();
    }
    int i = this.vr.getGravity();
    this.pM.O(i & 0xFFFFFF8F | 0x30);
    this.pM.N(i);
    this.vr.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        TextInputLayout localTextInputLayout = TextInputLayout.this;
        if (!TextInputLayout.a(TextInputLayout.this)) {}
        for (boolean bool = true;; bool = false)
        {
          localTextInputLayout.d(bool, false);
          if (TextInputLayout.this.vu) {
            TextInputLayout.this.al(paramAnonymousEditable.length());
          }
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.we == null) {
      this.we = this.vr.getHintTextColors();
    }
    if (this.vA)
    {
      if (TextUtils.isEmpty(this.hint))
      {
        this.vs = this.vr.getHint();
        setHint(this.vs);
        this.vr.setHint(null);
      }
      this.vB = true;
    }
    if (this.vx != null) {
      al(this.vr.getText().length());
    }
    this.vt.cO();
    dm();
    d(false, true);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.hint))
    {
      this.hint = paramCharSequence;
      this.pM.setText(paramCharSequence);
      if (!this.wk) {
        dr();
      }
    }
  }
  
  private void v(float paramFloat)
  {
    if (this.pM.oP == paramFloat) {
      return;
    }
    if (this.animator == null)
    {
      this.animator = new ValueAnimator();
      this.animator.setInterpolator(android.support.design.a.a.gJ);
      this.animator.setDuration(167L);
      this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TextInputLayout.this.pM.k(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        }
      });
    }
    this.animator.setFloatValues(new float[] { this.pM.oP, paramFloat });
    this.animator.start();
  }
  
  private void z(boolean paramBoolean)
  {
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    if ((paramBoolean) && (this.wl)) {
      v(1.0F);
    }
    for (;;)
    {
      this.wk = false;
      if (dq()) {
        dr();
      }
      return;
      this.pM.k(1.0F);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.vq.addView(paramView, localLayoutParams);
      this.vq.setLayoutParams(paramLayoutParams);
      dd();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  final void al(int paramInt)
  {
    boolean bool2 = this.vw;
    if (this.vv == -1)
    {
      this.vx.setText(String.valueOf(paramInt));
      this.vx.setContentDescription(null);
      this.vw = false;
      if ((this.vr != null) && (bool2 != this.vw))
      {
        d(false, false);
        dt();
        dk();
      }
      return;
    }
    if (t.aa(this.vx) == 1) {
      t.r(this.vx, 0);
    }
    boolean bool1;
    label98:
    TextView localTextView;
    if (paramInt > this.vv)
    {
      bool1 = true;
      this.vw = bool1;
      if (bool2 != this.vw)
      {
        localTextView = this.vx;
        if (!this.vw) {
          break label236;
        }
      }
    }
    label236:
    for (int i = this.vy;; i = this.vz)
    {
      c(localTextView, i);
      if (this.vw) {
        t.r(this.vx, 1);
      }
      this.vx.setText(getContext().getString(2131757039, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vv) }));
      this.vx.setContentDescription(getContext().getString(2131757038, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vv) }));
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
  
  final void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    boolean bool1 = isEnabled();
    int i;
    label48:
    boolean bool2;
    if ((this.vr != null) && (!TextUtils.isEmpty(this.vr.getText())))
    {
      i = 1;
      if ((this.vr == null) || (!this.vr.hasFocus())) {
        break label162;
      }
      bool2 = this.vt.cP();
      if (this.we != null)
      {
        this.pM.d(this.we);
        this.pM.e(this.we);
      }
      if (bool1) {
        break label168;
      }
      this.pM.d(ColorStateList.valueOf(this.wj));
      this.pM.e(ColorStateList.valueOf(this.wj));
      label119:
      if ((i == 0) && ((!isEnabled()) || ((j == 0) && (!bool2)))) {
        break label247;
      }
      if ((paramBoolean2) || (this.wk)) {
        z(paramBoolean1);
      }
    }
    label162:
    label168:
    label247:
    while ((!paramBoolean2) && (this.wk))
    {
      return;
      i = 0;
      break;
      j = 0;
      break label48;
      if (bool2)
      {
        this.pM.d(this.vt.cR());
        break label119;
      }
      if ((this.vw) && (this.vx != null))
      {
        this.pM.d(this.vx.getTextColors());
        break label119;
      }
      if ((j == 0) || (this.wf == null)) {
        break label119;
      }
      this.pM.d(this.wf);
      break label119;
    }
    A(paramBoolean1);
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if ((this.vs == null) || (this.vr == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    boolean bool = this.vB;
    this.vB = false;
    CharSequence localCharSequence = this.vr.getHint();
    this.vr.setHint(this.vs);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.vr.setHint(localCharSequence);
      this.vB = bool;
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.wo = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.wo = false;
  }
  
  final void dk()
  {
    if (this.vr == null) {}
    Drawable localDrawable2;
    do
    {
      return;
      localDrawable2 = this.vr.getBackground();
    } while (localDrawable2 == null);
    dl();
    Drawable localDrawable1 = localDrawable2;
    if (x.t(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if (this.vt.cP())
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.b(this.vt.cQ(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((this.vw) && (this.vx != null))
    {
      localDrawable1.setColorFilter(android.support.v7.widget.g.b(this.vx.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    android.support.v4.graphics.drawable.a.h(localDrawable1);
    this.vr.refreshDrawableState();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.vC != null) {
      this.vC.draw(paramCanvas);
    }
    super.draw(paramCanvas);
    if (this.vA) {
      this.pM.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    if (this.wn) {
      return;
    }
    this.wn = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((t.ay(this)) && (isEnabled()))
    {
      d(bool2, false);
      dk();
      de();
      dt();
      if (this.pM == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool1 = this.pM.setState(arrayOfInt) | false;; bool1 = false)
    {
      if (bool1) {
        invalidate();
      }
      this.wn = false;
      return;
      bool2 = false;
      break;
    }
  }
  
  final void dt()
  {
    int j = 1;
    if ((this.vC == null) || (this.vF == 0)) {
      return;
    }
    int i;
    if ((this.vr != null) && (this.vr.hasFocus()))
    {
      i = 1;
      label36:
      if ((this.vr == null) || (!this.vr.isHovered())) {
        break label109;
      }
      label53:
      if (this.vF != 2) {
        break label112;
      }
      if (isEnabled()) {
        break label114;
      }
      this.vO = this.wj;
      label76:
      if (((j == 0) && (i == 0)) || (!isEnabled())) {
        break label207;
      }
    }
    label207:
    for (this.vL = this.vN;; this.vL = this.vM)
    {
      dj();
      return;
      i = 0;
      break label36;
      label109:
      j = 0;
      break label53;
      label112:
      break;
      label114:
      if (this.vt.cP())
      {
        this.vO = this.vt.cQ();
        break label76;
      }
      if ((this.vw) && (this.vx != null))
      {
        this.vO = this.vx.getCurrentTextColor();
        break label76;
      }
      if (i != 0)
      {
        this.vO = this.wi;
        break label76;
      }
      if (j != 0)
      {
        this.vO = this.wh;
        break label76;
      }
      this.vO = this.wg;
      break label76;
    }
  }
  
  public int getBoxBackgroundColor()
  {
    return this.vP;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.vJ;
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.vK;
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.vI;
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.vH;
  }
  
  public int getBoxStrokeColor()
  {
    return this.wi;
  }
  
  public int getCounterMaxLength()
  {
    return this.vv;
  }
  
  CharSequence getCounterOverflowDescription()
  {
    if ((this.vu) && (this.vw) && (this.vx != null)) {
      return this.vx.getContentDescription();
    }
    return null;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.we;
  }
  
  public EditText getEditText()
  {
    return this.vr;
  }
  
  public CharSequence getError()
  {
    if (this.vt.sq) {
      return this.vt.so;
    }
    return null;
  }
  
  public int getErrorCurrentTextColors()
  {
    return this.vt.cQ();
  }
  
  final int getErrorTextCurrentColor()
  {
    return this.vt.cQ();
  }
  
  public CharSequence getHelperText()
  {
    if (this.vt.su) {
      return this.vt.st;
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    j localj = this.vt;
    if (localj.sv != null) {
      return localj.sv.getCurrentTextColor();
    }
    return -1;
  }
  
  public CharSequence getHint()
  {
    if (this.vA) {
      return this.hint;
    }
    return null;
  }
  
  final float getHintCollapsedTextHeight()
  {
    return this.pM.cg();
  }
  
  final int getHintCurrentCollapsedTextColor()
  {
    return this.pM.ck();
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.vU;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.vT;
  }
  
  public Typeface getTypeface()
  {
    return this.sx;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.vC != null) {
      de();
    }
    Rect localRect;
    int i;
    if ((this.vA) && (this.vr != null))
    {
      localRect = this.mA;
      f.a(this, this.vr, localRect);
      paramInt1 = localRect.left;
      paramInt3 = this.vr.getCompoundPaddingLeft() + paramInt1;
      i = localRect.right - this.vr.getCompoundPaddingRight();
      switch (this.vF)
      {
      default: 
        paramInt1 = getPaddingTop();
      }
    }
    for (;;)
    {
      this.pM.c(paramInt3, localRect.top + this.vr.getCompoundPaddingTop(), i, localRect.bottom - this.vr.getCompoundPaddingBottom());
      this.pM.d(paramInt3, paramInt1, i, paramInt4 - paramInt2 - getPaddingBottom());
      this.pM.cn();
      if ((dq()) && (!this.wk)) {
        dr();
      }
      return;
      paramInt1 = getBoxBackground().getBounds().top - dg();
      continue;
      paramInt1 = getBoxBackground().getBounds().top + this.vG;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    dm();
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
    super.onRestoreInstanceState(paramParcelable.Pa);
    setError(paramParcelable.wr);
    if (paramParcelable.ws) {
      y(true);
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.vt.cP()) {
      localSavedState.wr = getError();
    }
    localSavedState.ws = this.vW;
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    if (this.vP != paramInt)
    {
      this.vP = paramInt;
      dj();
    }
  }
  
  public void setBoxBackgroundColorResource(int paramInt)
  {
    setBoxBackgroundColor(b.n(getContext(), paramInt));
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.vF) {
      return;
    }
    this.vF = paramInt;
    db();
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    if (this.wi != paramInt)
    {
      this.wi = paramInt;
      dt();
    }
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.vu != paramBoolean)
    {
      if (!paramBoolean) {
        break label124;
      }
      this.vx = new AppCompatTextView(getContext());
      this.vx.setId(2131305751);
      if (this.sx != null) {
        this.vx.setTypeface(this.sx);
      }
      this.vx.setMaxLines(1);
      c(this.vx, this.vz);
      this.vt.a(this.vx, 2);
      if (this.vr != null) {
        break label105;
      }
      al(0);
    }
    for (;;)
    {
      this.vu = paramBoolean;
      return;
      label105:
      al(this.vr.getText().length());
      continue;
      label124:
      this.vt.b(this.vx, 2);
      this.vx = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.vv != paramInt)
    {
      if (paramInt <= 0) {
        break label39;
      }
      this.vv = paramInt;
      if (this.vu) {
        if (this.vr != null) {
          break label47;
        }
      }
    }
    label39:
    label47:
    for (paramInt = 0;; paramInt = this.vr.getText().length())
    {
      al(paramInt);
      return;
      this.vv = -1;
      break;
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    this.we = paramColorStateList;
    this.wf = paramColorStateList;
    if (this.vr != null) {
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
    if (!this.vt.sq)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      j localj = this.vt;
      localj.cN();
      localj.so = paramCharSequence;
      localj.sr.setText(paramCharSequence);
      if (localj.sm != 1) {
        localj.sn = 1;
      }
      localj.a(localj.sm, localj.sn, localj.a(localj.sr, paramCharSequence));
      return;
    }
    this.vt.cM();
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    j localj = this.vt;
    if (localj.sq != paramBoolean)
    {
      localj.cN();
      if (!paramBoolean) {
        break label103;
      }
      localj.sr = new AppCompatTextView(localj.context);
      localj.sr.setId(2131305752);
      if (localj.sx != null) {
        localj.sr.setTypeface(localj.sx);
      }
      localj.setErrorTextAppearance(localj.ss);
      localj.sr.setVisibility(4);
      t.r(localj.sr, 1);
      localj.a(localj.sr, 0);
    }
    for (;;)
    {
      localj.sq = paramBoolean;
      return;
      label103:
      localj.cM();
      localj.b(localj.sr, 0);
      localj.sr = null;
      localj.sf.dk();
      localj.sf.dt();
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.vt.setErrorTextAppearance(paramInt);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    j localj = this.vt;
    if (localj.sr != null) {
      localj.sr.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (this.vt.su) {
        setHelperTextEnabled(false);
      }
      return;
    }
    if (!this.vt.su) {
      setHelperTextEnabled(true);
    }
    j localj = this.vt;
    localj.cN();
    localj.st = paramCharSequence;
    localj.sv.setText(paramCharSequence);
    if (localj.sm != 2) {
      localj.sn = 2;
    }
    localj.a(localj.sm, localj.sn, localj.a(localj.sv, paramCharSequence));
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    j localj = this.vt;
    if (localj.sv != null) {
      localj.sv.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    j localj = this.vt;
    if (localj.su != paramBoolean)
    {
      localj.cN();
      if (!paramBoolean) {
        break label103;
      }
      localj.sv = new AppCompatTextView(localj.context);
      localj.sv.setId(2131305753);
      if (localj.sx != null) {
        localj.sv.setTypeface(localj.sx);
      }
      localj.sv.setVisibility(4);
      t.r(localj.sv, 1);
      localj.Z(localj.sw);
      localj.a(localj.sv, 1);
    }
    for (;;)
    {
      localj.su = paramBoolean;
      return;
      label103:
      localj.cN();
      if (localj.sm == 2) {
        localj.sn = 0;
      }
      localj.a(localj.sm, localj.sn, localj.a(localj.sv, null));
      localj.b(localj.sv, 1);
      localj.sv = null;
      localj.sf.dk();
      localj.sf.dt();
    }
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    this.vt.Z(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.vA)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.wl = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.vA)
    {
      this.vA = paramBoolean;
      if (this.vA) {
        break label76;
      }
      this.vB = false;
      if ((!TextUtils.isEmpty(this.hint)) && (TextUtils.isEmpty(this.vr.getHint()))) {
        this.vr.setHint(this.hint);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (this.vr != null) {
        dd();
      }
      return;
      label76:
      CharSequence localCharSequence = this.vr.getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.hint)) {
          setHint(localCharSequence);
        }
        this.vr.setHint(null);
      }
      this.vB = true;
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    this.pM.P(paramInt);
    this.wf = this.pM.oY;
    if (this.vr != null)
    {
      d(false, false);
      dd();
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
    this.vU = paramCharSequence;
    if (this.vV != null) {
      this.vV.setContentDescription(paramCharSequence);
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
    this.vT = paramDrawable;
    if (this.vV != null) {
      this.vV.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.vS != paramBoolean)
    {
      this.vS = paramBoolean;
      if ((!paramBoolean) && (this.vW) && (this.vr != null)) {
        this.vr.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      this.vW = false;
      dm();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.vZ = paramColorStateList;
    this.wa = true;
    dp();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.wb = paramMode;
    this.wd = true;
    dp();
  }
  
  public void setTextInputAccessibilityDelegate(a parama)
  {
    if (this.vr != null) {
      t.a(this.vr, parama);
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != this.sx)
    {
      this.sx = paramTypeface;
      this.pM.b(paramTypeface);
      j localj = this.vt;
      if (paramTypeface != localj.sx)
      {
        localj.sx = paramTypeface;
        j.a(localj.sr, paramTypeface);
        j.a(localj.sv, paramTypeface);
      }
      if (this.vx != null) {
        this.vx.setTypeface(paramTypeface);
      }
    }
  }
  
  public final void y(boolean paramBoolean)
  {
    int i;
    if (this.vS)
    {
      i = this.vr.getSelectionEnd();
      if (!dn()) {
        break label66;
      }
      this.vr.setTransformationMethod(null);
    }
    for (this.vW = true;; this.vW = false)
    {
      this.vV.setChecked(this.vW);
      if (paramBoolean) {
        this.vV.jumpDrawablesToCurrentState();
      }
      this.vr.setSelection(i);
      return;
      label66:
      this.vr.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    CharSequence wr;
    boolean ws;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.wr = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      if (paramParcel.readInt() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.ws = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.wr + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.wr, paramParcel, paramInt);
      if (this.ws) {}
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
    private final TextInputLayout wq;
    
    public a(TextInputLayout paramTextInputLayout)
    {
      this.wq = paramTextInputLayout;
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      int n = 0;
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      paramView = this.wq.getEditText();
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
        localCharSequence3 = this.wq.getHint();
        localCharSequence1 = this.wq.getError();
        localCharSequence2 = this.wq.getCounterOverflowDescription();
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
          paramc.Rb.setHintText(localCharSequence3);
          label131:
          if ((i != 0) || (k == 0)) {
            break label273;
          }
          bool = true;
          label143:
          if (Build.VERSION.SDK_INT < 26) {
            break label279;
          }
          paramc.Rb.setShowingHintText(bool);
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
          paramc.Rb.setError(paramView);
        }
        if (Build.VERSION.SDK_INT >= 19) {
          paramc.Rb.setContentInvalid(true);
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
        paramc.Rb.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", localCharSequence3);
        break label131;
        bool = false;
        break label143;
        if (Build.VERSION.SDK_INT >= 19) {}
        for (paramView = paramc.Rb.getExtras();; paramView = new Bundle())
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
      paramView = this.wq.getEditText();
      if (paramView != null) {}
      for (paramView = paramView.getText();; paramView = null)
      {
        Object localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = this.wq.getHint();
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