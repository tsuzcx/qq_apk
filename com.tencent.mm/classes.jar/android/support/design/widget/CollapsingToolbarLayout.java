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
  private final Rect jL = new Rect();
  ab kf;
  private boolean mI = true;
  private int mJ;
  private Toolbar mK;
  private View mL;
  private View mM;
  private int mN;
  private int mO;
  private int mP;
  private int mQ;
  final d mR = new d(this);
  private boolean mS;
  private boolean mT;
  private Drawable mU;
  Drawable mV;
  private int mW;
  private boolean mZ;
  private ValueAnimator na;
  private long nb;
  private int nc = -1;
  private AppBarLayout.b nd;
  int ne;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mR.a(android.support.design.a.a.dT);
    paramContext = android.support.design.internal.f.a(paramContext, paramAttributeSet, a.a.CollapsingToolbarLayout, paramInt, 2131821636, new int[0]);
    this.mR.O(paramContext.getInt(3, 8388691));
    this.mR.P(paramContext.getInt(0, 8388627));
    paramInt = paramContext.getDimensionPixelSize(4, 0);
    this.mQ = paramInt;
    this.mP = paramInt;
    this.mO = paramInt;
    this.mN = paramInt;
    if (paramContext.hasValue(7)) {
      this.mN = paramContext.getDimensionPixelSize(7, 0);
    }
    if (paramContext.hasValue(6)) {
      this.mP = paramContext.getDimensionPixelSize(6, 0);
    }
    if (paramContext.hasValue(8)) {
      this.mO = paramContext.getDimensionPixelSize(8, 0);
    }
    if (paramContext.hasValue(5)) {
      this.mQ = paramContext.getDimensionPixelSize(5, 0);
    }
    this.mS = paramContext.getBoolean(14, true);
    setTitle(paramContext.getText(13));
    this.mR.R(2131821386);
    this.mR.Q(2131821360);
    if (paramContext.hasValue(9)) {
      this.mR.R(paramContext.getResourceId(9, 0));
    }
    if (paramContext.hasValue(1)) {
      this.mR.Q(paramContext.getResourceId(1, 0));
    }
    this.nc = paramContext.getDimensionPixelSize(11, -1);
    this.nb = paramContext.getInt(10, 600);
    setContentScrim(paramContext.getDrawable(2));
    setStatusBarScrim(paramContext.getDrawable(12));
    this.mJ = paramContext.getResourceId(15, -1);
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
        if (!j.equals(localCollapsingToolbarLayout.kf, paramAnonymousView))
        {
          localCollapsingToolbarLayout.kf = paramAnonymousView;
          localCollapsingToolbarLayout.requestLayout();
        }
        return paramAnonymousab.fc();
      }
    });
  }
  
  private void bS()
  {
    if (!this.mI) {
      return;
    }
    this.mK = null;
    this.mL = null;
    if (this.mJ != -1)
    {
      this.mK = ((Toolbar)findViewById(this.mJ));
      if (this.mK != null) {
        this.mL = m(this.mK);
      }
    }
    int i;
    if (this.mK == null)
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
      this.mK = ((Toolbar)localObject);
      bT();
      this.mI = false;
      return;
      i += 1;
      break;
    }
  }
  
  private void bT()
  {
    if ((!this.mS) && (this.mM != null))
    {
      ViewParent localViewParent = this.mM.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.mM);
      }
    }
    if ((this.mS) && (this.mK != null))
    {
      if (this.mM == null) {
        this.mM = new View(getContext());
      }
      if (this.mM.getParent() == null) {
        this.mK.addView(this.mM, -1, -1);
      }
    }
  }
  
  private void bV()
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
  
  final void bU()
  {
    if ((this.mU != null) || (this.mV != null)) {
      if (getHeight() + this.ne >= getScrimVisibleHeightTrigger()) {
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
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    bS();
    if ((this.mK == null) && (this.mU != null) && (this.mW > 0))
    {
      this.mU.mutate().setAlpha(this.mW);
      this.mU.draw(paramCanvas);
    }
    if ((this.mS) && (this.mT)) {
      this.mR.draw(paramCanvas);
    }
    if ((this.mV != null) && (this.mW > 0)) {
      if (this.kf == null) {
        break label153;
      }
    }
    label153:
    for (int i = this.kf.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.mV.setBounds(0, -this.ne, getWidth(), i - this.ne);
        this.mV.mutate().setAlpha(this.mW);
        this.mV.draw(paramCanvas);
      }
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = false;
    if ((this.mU != null) && (this.mW > 0)) {
      if ((this.mL == null) || (this.mL == this)) {
        if (paramView == this.mK)
        {
          i = 1;
          if (i == 0) {
            break label120;
          }
          this.mU.mutate().setAlpha(this.mW);
          this.mU.draw(paramCanvas);
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
      if (paramView == this.mL)
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
    Drawable localDrawable = this.mV;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.mU;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    bool1 = bool2;
    if (this.mR != null) {
      bool1 = bool2 | this.mR.setState(arrayOfInt);
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
    return this.mR.lZ;
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    d locald = this.mR;
    if (locald.mk != null) {
      return locald.mk;
    }
    return Typeface.DEFAULT;
  }
  
  public Drawable getContentScrim()
  {
    return this.mU;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.mR.lY;
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.mQ;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.mP;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.mN;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.mO;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    d locald = this.mR;
    if (locald.ml != null) {
      return locald.ml;
    }
    return Typeface.DEFAULT;
  }
  
  int getScrimAlpha()
  {
    return this.mW;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.nb;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    if (this.nc >= 0) {
      return this.nc;
    }
    if (this.kf != null) {}
    for (int i = this.kf.getSystemWindowInsetTop();; i = 0)
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
    return this.mV;
  }
  
  public CharSequence getTitle()
  {
    if (this.mS) {
      return this.mR.text;
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
      if (this.nd == null) {
        this.nd = new a();
      }
      ((AppBarLayout)localViewParent).a(this.nd);
      t.ap(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getParent();
    if ((this.nd != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.b localb = this.nd;
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
    if (this.kf != null)
    {
      k = this.kf.getSystemWindowInsetTop();
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
    if ((this.mS) && (this.mM != null))
    {
      if ((!t.aC(this.mM)) || (this.mM.getVisibility() != 0)) {
        break label404;
      }
      paramBoolean = true;
      this.mT = paramBoolean;
      if (this.mT)
      {
        if (t.Y(this) != 1) {
          break label409;
        }
        i = j;
        label151:
        if (this.mL == null) {
          break label415;
        }
        localObject = this.mL;
        label164:
        n = p((View)localObject);
        f.a(this, this.mM, this.jL);
        localObject = this.mR;
        int i1 = this.jL.left;
        if (i == 0) {
          break label424;
        }
        j = this.mK.getTitleMarginEnd();
        label213:
        int i2 = this.jL.top;
        int i3 = this.mK.getTitleMarginTop();
        int i4 = this.jL.right;
        if (i == 0) {
          break label436;
        }
        k = this.mK.getTitleMarginStart();
        label254:
        ((d)localObject).d(i1 + j, i3 + (i2 + n), k + i4, n + this.jL.bottom - this.mK.getTitleMarginBottom());
        localObject = this.mR;
        if (i == 0) {
          break label448;
        }
        j = this.mP;
        label312:
        k = this.jL.top;
        n = this.mO;
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
    for (int i = this.mN;; i = this.mP)
    {
      ((d)localObject).c(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.mQ);
      this.mR.bQ();
      paramInt2 = getChildCount();
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        o(getChildAt(paramInt1)).cY();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      i = 0;
      break label151;
      localObject = this.mK;
      break label164;
      j = this.mK.getTitleMarginStart();
      break label213;
      k = this.mK.getTitleMarginEnd();
      break label254;
      j = this.mN;
      break label312;
    }
    if (this.mK != null)
    {
      if ((this.mS) && (TextUtils.isEmpty(this.mR.text))) {
        setTitle(this.mK.getTitle());
      }
      if ((this.mL != null) && (this.mL != this)) {
        break label535;
      }
      setMinimumHeight(n(this.mK));
    }
    for (;;)
    {
      bU();
      return;
      label535:
      setMinimumHeight(n(this.mL));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    bS();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.kf != null) {}
    for (paramInt2 = this.kf.getSystemWindowInsetTop();; paramInt2 = 0)
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
    if (this.mU != null) {
      this.mU.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  final int p(View paramView)
  {
    p localp = o(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - localp.tD - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.mR.P(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.mR.Q(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.mR.d(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    d locald = this.mR;
    if (locald.mk != paramTypeface)
    {
      locald.mk = paramTypeface;
      locald.bQ();
    }
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.mU != paramDrawable)
    {
      if (this.mU != null) {
        this.mU.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.mU = localDrawable;
      if (this.mU != null)
      {
        this.mU.setBounds(0, 0, getWidth(), getHeight());
        this.mU.setCallback(this);
        this.mU.setAlpha(this.mW);
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
    this.mR.O(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.mQ = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.mP = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.mN = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.mO = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.mR.R(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.mR.e(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    d locald = this.mR;
    if (locald.ml != paramTypeface)
    {
      locald.ml = paramTypeface;
      locald.bQ();
    }
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.mW)
    {
      if ((this.mU != null) && (this.mK != null)) {
        t.W(this.mK);
      }
      this.mW = paramInt;
      t.W(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.nb = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.nc != paramInt)
    {
      this.nc = paramInt;
      bU();
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
      if (this.mZ != paramBoolean)
      {
        if (i == 0) {
          break label187;
        }
        if (!paramBoolean) {
          break label154;
        }
        i = 255;
        bS();
        if (this.na != null) {
          break label167;
        }
        this.na = new ValueAnimator();
        this.na.setDuration(this.nb);
        ValueAnimator localValueAnimator = this.na;
        if (i <= this.mW) {
          break label159;
        }
        localTimeInterpolator = android.support.design.a.a.dR;
        label93:
        localValueAnimator.setInterpolator(localTimeInterpolator);
        this.na.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.na.setIntValues(new int[] { this.mW, i });
      this.na.start();
      this.mZ = paramBoolean;
      return;
      i = 0;
      break;
      label154:
      i = 0;
      break label40;
      label159:
      localTimeInterpolator = android.support.design.a.a.dS;
      break label93;
      label167:
      if (this.na.isRunning()) {
        this.na.cancel();
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
    if (this.mV != paramDrawable)
    {
      if (this.mV != null) {
        this.mV.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.mV = localDrawable;
      if (this.mV != null)
      {
        if (this.mV.isStateful()) {
          this.mV.setState(getDrawableState());
        }
        android.support.v4.graphics.drawable.a.b(this.mV, t.Y(this));
        paramDrawable = this.mV;
        if (getVisibility() != 0) {
          break label125;
        }
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.mV.setCallback(this);
      this.mV.setAlpha(this.mW);
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
    this.mR.setText(paramCharSequence);
    bV();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.mS)
    {
      this.mS = paramBoolean;
      bV();
      bT();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.mV != null) && (this.mV.isVisible() != bool)) {
        this.mV.setVisible(bool, false);
      }
      if ((this.mU != null) && (this.mU.isVisible() != bool)) {
        this.mU.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mU) || (paramDrawable == this.mV);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int ng = 0;
    float nh = 0.5F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CollapsingToolbarLayout_Layout);
      this.ng = paramContext.getInt(0, 0);
      this.nh = paramContext.getFloat(1, 0.5F);
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
      CollapsingToolbarLayout.this.ne = paramInt;
      int i;
      label42:
      CollapsingToolbarLayout.LayoutParams localLayoutParams;
      p localp;
      if (CollapsingToolbarLayout.this.kf != null)
      {
        i = CollapsingToolbarLayout.this.kf.getSystemWindowInsetTop();
        k = CollapsingToolbarLayout.this.getChildCount();
        j = 0;
        if (j >= k) {
          break label161;
        }
        paramAppBarLayout = CollapsingToolbarLayout.this.getChildAt(j);
        localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
        localp = CollapsingToolbarLayout.o(paramAppBarLayout);
        switch (localLayoutParams.ng)
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
        localp.G(Math.round(localLayoutParams.nh * f));
      }
      label161:
      CollapsingToolbarLayout.this.bU();
      if ((CollapsingToolbarLayout.this.mV != null) && (i > 0)) {
        t.W(CollapsingToolbarLayout.this);
      }
      int j = CollapsingToolbarLayout.this.getHeight();
      int k = t.af(CollapsingToolbarLayout.this);
      CollapsingToolbarLayout.this.mR.i(Math.abs(paramInt) / (j - k - i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */