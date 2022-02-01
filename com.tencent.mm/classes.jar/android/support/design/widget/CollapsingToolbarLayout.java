package android.support.design.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.a.a;
import android.support.v4.content.b;
import android.support.v4.e.j;
import android.support.v4.view.ab;
import android.support.v4.view.t;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.List;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  private final Rect mA = new Rect();
  ab mV;
  private boolean pD = true;
  private int pE;
  private Toolbar pF;
  private View pG;
  private View pH;
  private int pI;
  private int pJ;
  private int pK;
  private int pL;
  final d pM = new d(this);
  private boolean pN;
  private boolean pO;
  private Drawable pP;
  Drawable pQ;
  private int pR;
  private boolean pS;
  private ValueAnimator pT;
  private long pU;
  private int pV = -1;
  private AppBarLayout.b pW;
  int pX;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.pM.a(android.support.design.a.a.gM);
    paramContext = android.support.design.internal.f.a(paramContext, paramAttributeSet, a.a.CollapsingToolbarLayout, paramInt, 2131821636, new int[0]);
    this.pM.N(paramContext.getInt(3, 8388691));
    this.pM.O(paramContext.getInt(0, 8388627));
    paramInt = paramContext.getDimensionPixelSize(4, 0);
    this.pL = paramInt;
    this.pK = paramInt;
    this.pJ = paramInt;
    this.pI = paramInt;
    if (paramContext.hasValue(7)) {
      this.pI = paramContext.getDimensionPixelSize(7, 0);
    }
    if (paramContext.hasValue(6)) {
      this.pK = paramContext.getDimensionPixelSize(6, 0);
    }
    if (paramContext.hasValue(8)) {
      this.pJ = paramContext.getDimensionPixelSize(8, 0);
    }
    if (paramContext.hasValue(5)) {
      this.pL = paramContext.getDimensionPixelSize(5, 0);
    }
    this.pN = paramContext.getBoolean(14, true);
    setTitle(paramContext.getText(13));
    this.pM.Q(2131821386);
    this.pM.P(2131821360);
    if (paramContext.hasValue(9)) {
      this.pM.Q(paramContext.getResourceId(9, 0));
    }
    if (paramContext.hasValue(1)) {
      this.pM.P(paramContext.getResourceId(1, 0));
    }
    this.pV = paramContext.getDimensionPixelSize(11, -1);
    this.pU = paramContext.getInt(10, 600);
    setContentScrim(paramContext.getDrawable(2));
    setStatusBarScrim(paramContext.getDrawable(12));
    this.pE = paramContext.getResourceId(15, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    t.a(this, new android.support.v4.view.p()
    {
      public final ab a(View paramAnonymousView, ab paramAnonymousab)
      {
        CollapsingToolbarLayout localCollapsingToolbarLayout = CollapsingToolbarLayout.this;
        paramAnonymousView = null;
        if (t.aq(localCollapsingToolbarLayout)) {
          paramAnonymousView = paramAnonymousab;
        }
        if (!j.equals(localCollapsingToolbarLayout.mV, paramAnonymousView))
        {
          localCollapsingToolbarLayout.mV = paramAnonymousView;
          localCollapsingToolbarLayout.requestLayout();
        }
        return paramAnonymousab.fB();
      }
    });
  }
  
  private void cp()
  {
    if (!this.pD) {
      return;
    }
    this.pF = null;
    this.pG = null;
    if (this.pE != -1)
    {
      this.pF = ((Toolbar)findViewById(this.pE));
      if (this.pF != null) {
        this.pG = m(this.pF);
      }
    }
    int i;
    if (this.pF == null)
    {
      int j = getChildCount();
      i = 0;
      if (i >= j) {
        break label119;
      }
      localObject = getChildAt(i);
      if (!(localObject instanceof Toolbar)) {
        break label112;
      }
    }
    label112:
    label119:
    for (Object localObject = (Toolbar)localObject;; localObject = null)
    {
      this.pF = ((Toolbar)localObject);
      cq();
      this.pD = false;
      return;
      i += 1;
      break;
    }
  }
  
  private void cq()
  {
    if ((!this.pN) && (this.pH != null))
    {
      ViewParent localViewParent = this.pH.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.pH);
      }
    }
    if ((this.pN) && (this.pF != null))
    {
      if (this.pH == null) {
        this.pH = new View(getContext());
      }
      if (this.pH.getParent() == null) {
        this.pF.addView(this.pH, -1, -1);
      }
    }
  }
  
  private void cs()
  {
    setContentDescription(getTitle());
  }
  
  private View m(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    return localView;
  }
  
  private static int n(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      int i = paramView.getHeight();
      int j = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      return ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + (i + j);
    }
    return paramView.getHeight();
  }
  
  static p o(View paramView)
  {
    p localp2 = (p)paramView.getTag(2131306431);
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = new p(paramView);
      paramView.setTag(2131306431, localp1);
    }
    return localp1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  final void cr()
  {
    if ((this.pP != null) || (this.pQ != null)) {
      if (getHeight() + this.pX >= getScrimVisibleHeightTrigger()) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      setScrimsShown(bool);
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    cp();
    if ((this.pF == null) && (this.pP != null) && (this.pR > 0))
    {
      this.pP.mutate().setAlpha(this.pR);
      this.pP.draw(paramCanvas);
    }
    if ((this.pN) && (this.pO)) {
      this.pM.draw(paramCanvas);
    }
    if ((this.pQ != null) && (this.pR > 0)) {
      if (this.mV == null) {
        break label153;
      }
    }
    label153:
    for (int i = this.mV.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.pQ.setBounds(0, -this.pX, getWidth(), i - this.pX);
        this.pQ.mutate().setAlpha(this.pR);
        this.pQ.draw(paramCanvas);
      }
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = false;
    if ((this.pP != null) && (this.pR > 0)) {
      if ((this.pG == null) || (this.pG == this)) {
        if (paramView == this.pF)
        {
          i = 1;
          if (i == 0) {
            break label120;
          }
          this.pP.mutate().setAlpha(this.pR);
          this.pP.draw(paramCanvas);
        }
      }
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if ((super.drawChild(paramCanvas, paramView, paramLong)) || (i != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
      if (paramView == this.pG)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.pQ;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.pP;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    bool1 = bool2;
    if (this.pM != null) {
      bool1 = bool2 | this.pM.setState(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getCollapsedTitleGravity()
  {
    return this.pM.oU;
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    d locald = this.pM;
    if (locald.pf != null) {
      return locald.pf;
    }
    return Typeface.DEFAULT;
  }
  
  public Drawable getContentScrim()
  {
    return this.pP;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.pM.oT;
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.pL;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.pK;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.pI;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.pJ;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    d locald = this.pM;
    if (locald.pg != null) {
      return locald.pg;
    }
    return Typeface.DEFAULT;
  }
  
  int getScrimAlpha()
  {
    return this.pR;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.pU;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    if (this.pV >= 0) {
      return this.pV;
    }
    if (this.mV != null) {}
    for (int i = this.mV.getSystemWindowInsetTop();; i = 0)
    {
      int j = t.af(this);
      if (j <= 0) {
        break;
      }
      return Math.min(i + j * 2, getHeight());
    }
    return getHeight() / 3;
  }
  
  public Drawable getStatusBarScrim()
  {
    return this.pQ;
  }
  
  public CharSequence getTitle()
  {
    if (this.pN) {
      return this.pM.text;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      t.e(this, t.aq((View)localViewParent));
      if (this.pW == null) {
        this.pW = new a();
      }
      ((AppBarLayout)localViewParent).a(this.pW);
      t.ap(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getParent();
    if ((this.pW != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.b localb = this.pW;
      if ((((AppBarLayout)localObject).listeners != null) && (localb != null)) {
        ((AppBarLayout)localObject).listeners.remove(localb);
      }
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int m = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int k;
    int n;
    Object localObject;
    if (this.mV != null)
    {
      k = this.mV.getSystemWindowInsetTop();
      n = getChildCount();
      i = 0;
      while (i < n)
      {
        localObject = getChildAt(i);
        if ((!t.aq((View)localObject)) && (((View)localObject).getTop() < k)) {
          t.s((View)localObject, k);
        }
        i += 1;
      }
    }
    if ((this.pN) && (this.pH != null))
    {
      if ((!t.aC(this.pH)) || (this.pH.getVisibility() != 0)) {
        break label404;
      }
      paramBoolean = true;
      this.pO = paramBoolean;
      if (this.pO)
      {
        if (t.Y(this) != 1) {
          break label409;
        }
        i = j;
        label151:
        if (this.pG == null) {
          break label415;
        }
        localObject = this.pG;
        label164:
        n = p((View)localObject);
        f.a(this, this.pH, this.mA);
        localObject = this.pM;
        int i1 = this.mA.left;
        if (i == 0) {
          break label424;
        }
        j = this.pF.getTitleMarginEnd();
        label213:
        int i2 = this.mA.top;
        int i3 = this.pF.getTitleMarginTop();
        int i4 = this.mA.right;
        if (i == 0) {
          break label436;
        }
        k = this.pF.getTitleMarginStart();
        label254:
        ((d)localObject).d(i1 + j, i3 + (i2 + n), k + i4, n + this.mA.bottom - this.pF.getTitleMarginBottom());
        localObject = this.pM;
        if (i == 0) {
          break label448;
        }
        j = this.pK;
        label312:
        k = this.mA.top;
        n = this.pJ;
        if (i == 0) {
          break label457;
        }
      }
    }
    label404:
    label409:
    label415:
    label424:
    label436:
    label448:
    label457:
    for (int i = this.pI;; i = this.pK)
    {
      ((d)localObject).c(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.pL);
      this.pM.cn();
      paramInt2 = getChildCount();
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        o(getChildAt(paramInt1)).du();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      i = 0;
      break label151;
      localObject = this.pF;
      break label164;
      j = this.pF.getTitleMarginStart();
      break label213;
      k = this.pF.getTitleMarginEnd();
      break label254;
      j = this.pI;
      break label312;
    }
    if (this.pF != null)
    {
      if ((this.pN) && (TextUtils.isEmpty(this.pM.text))) {
        setTitle(this.pF.getTitle());
      }
      if ((this.pG != null) && (this.pG != this)) {
        break label535;
      }
      setMinimumHeight(n(this.pF));
    }
    for (;;)
    {
      cr();
      return;
      label535:
      setMinimumHeight(n(this.pG));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    cp();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.mV != null) {}
    for (paramInt2 = this.mV.getSystemWindowInsetTop();; paramInt2 = 0)
    {
      if ((i == 0) && (paramInt2 > 0)) {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2 + getMeasuredHeight(), 1073741824));
      }
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.pP != null) {
      this.pP.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  final int p(View paramView)
  {
    p localp = o(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - localp.wx - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.pM.O(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.pM.P(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.pM.d(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    d locald = this.pM;
    if (locald.pf != paramTypeface)
    {
      locald.pf = paramTypeface;
      locald.cn();
    }
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.pP != paramDrawable)
    {
      if (this.pP != null) {
        this.pP.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.pP = localDrawable;
      if (this.pP != null)
      {
        this.pP.setBounds(0, 0, getWidth(), getHeight());
        this.pP.setCallback(this);
        this.pP.setAlpha(this.pR);
      }
      t.W(this);
    }
  }
  
  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(b.l(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    this.pM.N(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.pL = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.pK = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.pI = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.pJ = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.pM.Q(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.pM.e(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    d locald = this.pM;
    if (locald.pg != paramTypeface)
    {
      locald.pg = paramTypeface;
      locald.cn();
    }
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.pR)
    {
      if ((this.pP != null) && (this.pF != null)) {
        t.W(this.pF);
      }
      this.pR = paramInt;
      t.W(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.pU = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.pV != paramInt)
    {
      this.pV = paramInt;
      cr();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    int j = 255;
    label40:
    TimeInterpolator localTimeInterpolator;
    if ((t.ay(this)) && (!isInEditMode()))
    {
      i = 1;
      if (this.pS != paramBoolean)
      {
        if (i == 0) {
          break label187;
        }
        if (!paramBoolean) {
          break label154;
        }
        i = 255;
        cp();
        if (this.pT != null) {
          break label167;
        }
        this.pT = new ValueAnimator();
        this.pT.setDuration(this.pU);
        ValueAnimator localValueAnimator = this.pT;
        if (i <= this.pR) {
          break label159;
        }
        localTimeInterpolator = android.support.design.a.a.gK;
        label93:
        localValueAnimator.setInterpolator(localTimeInterpolator);
        this.pT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
      }
    }
    for (;;)
    {
      this.pT.setIntValues(new int[] { this.pR, i });
      this.pT.start();
      this.pS = paramBoolean;
      return;
      i = 0;
      break;
      label154:
      i = 0;
      break label40;
      label159:
      localTimeInterpolator = android.support.design.a.a.gL;
      break label93;
      label167:
      if (this.pT.isRunning()) {
        this.pT.cancel();
      }
    }
    label187:
    if (paramBoolean) {}
    for (int i = j;; i = 0)
    {
      setScrimAlpha(i);
      break;
    }
  }
  
  public void setStatusBarScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.pQ != paramDrawable)
    {
      if (this.pQ != null) {
        this.pQ.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.pQ = localDrawable;
      if (this.pQ != null)
      {
        if (this.pQ.isStateful()) {
          this.pQ.setState(getDrawableState());
        }
        android.support.v4.graphics.drawable.a.b(this.pQ, t.Y(this));
        paramDrawable = this.pQ;
        if (getVisibility() != 0) {
          break label125;
        }
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.pQ.setCallback(this);
      this.pQ.setAlpha(this.pR);
      t.W(this);
      return;
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(b.l(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.pM.setText(paramCharSequence);
    cs();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.pN)
    {
      this.pN = paramBoolean;
      cs();
      cq();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.pQ != null) && (this.pQ.isVisible() != bool)) {
        this.pQ.setVisible(bool, false);
      }
      if ((this.pP != null) && (this.pP.isVisible() != bool)) {
        this.pP.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.pP) || (paramDrawable == this.pQ);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int pZ = 0;
    float qa = 0.5F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CollapsingToolbarLayout_Layout);
      this.pZ = paramContext.getInt(0, 0);
      this.qa = paramContext.getFloat(1, 0.5F);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  final class a
    implements AppBarLayout.b
  {
    a() {}
    
    public final void c(AppBarLayout paramAppBarLayout, int paramInt)
    {
      CollapsingToolbarLayout.this.pX = paramInt;
      int i;
      label42:
      CollapsingToolbarLayout.LayoutParams localLayoutParams;
      p localp;
      if (CollapsingToolbarLayout.this.mV != null)
      {
        i = CollapsingToolbarLayout.this.mV.getSystemWindowInsetTop();
        k = CollapsingToolbarLayout.this.getChildCount();
        j = 0;
        if (j >= k) {
          break label161;
        }
        paramAppBarLayout = CollapsingToolbarLayout.this.getChildAt(j);
        localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
        localp = CollapsingToolbarLayout.o(paramAppBarLayout);
        switch (localLayoutParams.pZ)
        {
        }
      }
      for (;;)
      {
        j += 1;
        break label42;
        i = 0;
        break;
        localp.G(android.support.v4.b.a.clamp(-paramInt, 0, CollapsingToolbarLayout.this.p(paramAppBarLayout)));
        continue;
        float f = -paramInt;
        localp.G(Math.round(localLayoutParams.qa * f));
      }
      label161:
      CollapsingToolbarLayout.this.cr();
      if ((CollapsingToolbarLayout.this.pQ != null) && (i > 0)) {
        t.W(CollapsingToolbarLayout.this);
      }
      int j = CollapsingToolbarLayout.this.getHeight();
      int k = t.af(CollapsingToolbarLayout.this);
      CollapsingToolbarLayout.this.pM.k(Math.abs(paramInt) / (j - k - i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */