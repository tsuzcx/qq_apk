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
  private final Rect kK = new Rect();
  ab le;
  private boolean nJ = true;
  private int nK;
  private Toolbar nL;
  private View nM;
  private View nN;
  private int nO;
  private int nP;
  private int nQ;
  private int nR;
  final d nS = new d(this);
  private boolean nT;
  private boolean nU;
  private Drawable nV;
  Drawable nW;
  private int nX;
  private boolean nY;
  private ValueAnimator nZ;
  private long oa;
  private int ob = -1;
  private AppBarLayout.b oc;
  int od;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.nS.a(android.support.design.a.a.eT);
    paramContext = android.support.design.internal.f.a(paramContext, paramAttributeSet, a.a.CollapsingToolbarLayout, paramInt, 2131821636, new int[0]);
    this.nS.O(paramContext.getInt(3, 8388691));
    this.nS.P(paramContext.getInt(0, 8388627));
    paramInt = paramContext.getDimensionPixelSize(4, 0);
    this.nR = paramInt;
    this.nQ = paramInt;
    this.nP = paramInt;
    this.nO = paramInt;
    if (paramContext.hasValue(7)) {
      this.nO = paramContext.getDimensionPixelSize(7, 0);
    }
    if (paramContext.hasValue(6)) {
      this.nQ = paramContext.getDimensionPixelSize(6, 0);
    }
    if (paramContext.hasValue(8)) {
      this.nP = paramContext.getDimensionPixelSize(8, 0);
    }
    if (paramContext.hasValue(5)) {
      this.nR = paramContext.getDimensionPixelSize(5, 0);
    }
    this.nT = paramContext.getBoolean(14, true);
    setTitle(paramContext.getText(13));
    this.nS.R(2131821386);
    this.nS.Q(2131821360);
    if (paramContext.hasValue(9)) {
      this.nS.R(paramContext.getResourceId(9, 0));
    }
    if (paramContext.hasValue(1)) {
      this.nS.Q(paramContext.getResourceId(1, 0));
    }
    this.ob = paramContext.getDimensionPixelSize(11, -1);
    this.oa = paramContext.getInt(10, 600);
    setContentScrim(paramContext.getDrawable(2));
    setStatusBarScrim(paramContext.getDrawable(12));
    this.nK = paramContext.getResourceId(15, -1);
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
        if (!j.equals(localCollapsingToolbarLayout.le, paramAnonymousView))
        {
          localCollapsingToolbarLayout.le = paramAnonymousView;
          localCollapsingToolbarLayout.requestLayout();
        }
        return paramAnonymousab.fk();
      }
    });
  }
  
  private void bZ()
  {
    if (!this.nJ) {
      return;
    }
    this.nL = null;
    this.nM = null;
    if (this.nK != -1)
    {
      this.nL = ((Toolbar)findViewById(this.nK));
      if (this.nL != null) {
        this.nM = m(this.nL);
      }
    }
    int i;
    if (this.nL == null)
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
      this.nL = ((Toolbar)localObject);
      ca();
      this.nJ = false;
      return;
      i += 1;
      break;
    }
  }
  
  private void ca()
  {
    if ((!this.nT) && (this.nN != null))
    {
      ViewParent localViewParent = this.nN.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.nN);
      }
    }
    if ((this.nT) && (this.nL != null))
    {
      if (this.nN == null) {
        this.nN = new View(getContext());
      }
      if (this.nN.getParent() == null) {
        this.nL.addView(this.nN, -1, -1);
      }
    }
  }
  
  private void cc()
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
  
  final void cb()
  {
    if ((this.nV != null) || (this.nW != null)) {
      if (getHeight() + this.od >= getScrimVisibleHeightTrigger()) {
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
    bZ();
    if ((this.nL == null) && (this.nV != null) && (this.nX > 0))
    {
      this.nV.mutate().setAlpha(this.nX);
      this.nV.draw(paramCanvas);
    }
    if ((this.nT) && (this.nU)) {
      this.nS.draw(paramCanvas);
    }
    if ((this.nW != null) && (this.nX > 0)) {
      if (this.le == null) {
        break label153;
      }
    }
    label153:
    for (int i = this.le.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.nW.setBounds(0, -this.od, getWidth(), i - this.od);
        this.nW.mutate().setAlpha(this.nX);
        this.nW.draw(paramCanvas);
      }
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = false;
    if ((this.nV != null) && (this.nX > 0)) {
      if ((this.nM == null) || (this.nM == this)) {
        if (paramView == this.nL)
        {
          i = 1;
          if (i == 0) {
            break label120;
          }
          this.nV.mutate().setAlpha(this.nX);
          this.nV.draw(paramCanvas);
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
      if (paramView == this.nM)
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
    Drawable localDrawable = this.nW;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.nV;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    bool1 = bool2;
    if (this.nS != null) {
      bool1 = bool2 | this.nS.setState(arrayOfInt);
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
    return this.nS.na;
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    d locald = this.nS;
    if (locald.nl != null) {
      return locald.nl;
    }
    return Typeface.DEFAULT;
  }
  
  public Drawable getContentScrim()
  {
    return this.nV;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.nS.mZ;
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.nR;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.nQ;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.nO;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.nP;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    d locald = this.nS;
    if (locald.nm != null) {
      return locald.nm;
    }
    return Typeface.DEFAULT;
  }
  
  int getScrimAlpha()
  {
    return this.nX;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.oa;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    if (this.ob >= 0) {
      return this.ob;
    }
    if (this.le != null) {}
    for (int i = this.le.getSystemWindowInsetTop();; i = 0)
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
    return this.nW;
  }
  
  public CharSequence getTitle()
  {
    if (this.nT) {
      return this.nS.text;
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
      if (this.oc == null) {
        this.oc = new a();
      }
      ((AppBarLayout)localViewParent).a(this.oc);
      t.ap(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getParent();
    if ((this.oc != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.b localb = this.oc;
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
    if (this.le != null)
    {
      k = this.le.getSystemWindowInsetTop();
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
    if ((this.nT) && (this.nN != null))
    {
      if ((!t.aC(this.nN)) || (this.nN.getVisibility() != 0)) {
        break label404;
      }
      paramBoolean = true;
      this.nU = paramBoolean;
      if (this.nU)
      {
        if (t.Y(this) != 1) {
          break label409;
        }
        i = j;
        label151:
        if (this.nM == null) {
          break label415;
        }
        localObject = this.nM;
        label164:
        n = p((View)localObject);
        f.a(this, this.nN, this.kK);
        localObject = this.nS;
        int i1 = this.kK.left;
        if (i == 0) {
          break label424;
        }
        j = this.nL.getTitleMarginEnd();
        label213:
        int i2 = this.kK.top;
        int i3 = this.nL.getTitleMarginTop();
        int i4 = this.kK.right;
        if (i == 0) {
          break label436;
        }
        k = this.nL.getTitleMarginStart();
        label254:
        ((d)localObject).d(i1 + j, i3 + (i2 + n), k + i4, n + this.kK.bottom - this.nL.getTitleMarginBottom());
        localObject = this.nS;
        if (i == 0) {
          break label448;
        }
        j = this.nQ;
        label312:
        k = this.kK.top;
        n = this.nP;
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
    for (int i = this.nO;; i = this.nQ)
    {
      ((d)localObject).c(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.nR);
      this.nS.bX();
      paramInt2 = getChildCount();
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        o(getChildAt(paramInt1)).df();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      i = 0;
      break label151;
      localObject = this.nL;
      break label164;
      j = this.nL.getTitleMarginStart();
      break label213;
      k = this.nL.getTitleMarginEnd();
      break label254;
      j = this.nO;
      break label312;
    }
    if (this.nL != null)
    {
      if ((this.nT) && (TextUtils.isEmpty(this.nS.text))) {
        setTitle(this.nL.getTitle());
      }
      if ((this.nM != null) && (this.nM != this)) {
        break label535;
      }
      setMinimumHeight(n(this.nL));
    }
    for (;;)
    {
      cb();
      return;
      label535:
      setMinimumHeight(n(this.nM));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    bZ();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.le != null) {}
    for (paramInt2 = this.le.getSystemWindowInsetTop();; paramInt2 = 0)
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
    if (this.nV != null) {
      this.nV.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  final int p(View paramView)
  {
    p localp = o(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - localp.uE - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.nS.P(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.nS.Q(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.nS.d(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    d locald = this.nS;
    if (locald.nl != paramTypeface)
    {
      locald.nl = paramTypeface;
      locald.bX();
    }
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.nV != paramDrawable)
    {
      if (this.nV != null) {
        this.nV.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.nV = localDrawable;
      if (this.nV != null)
      {
        this.nV.setBounds(0, 0, getWidth(), getHeight());
        this.nV.setCallback(this);
        this.nV.setAlpha(this.nX);
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
    this.nS.O(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.nR = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.nQ = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.nO = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.nP = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.nS.R(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.nS.e(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    d locald = this.nS;
    if (locald.nm != paramTypeface)
    {
      locald.nm = paramTypeface;
      locald.bX();
    }
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.nX)
    {
      if ((this.nV != null) && (this.nL != null)) {
        t.W(this.nL);
      }
      this.nX = paramInt;
      t.W(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.oa = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.ob != paramInt)
    {
      this.ob = paramInt;
      cb();
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
      if (this.nY != paramBoolean)
      {
        if (i == 0) {
          break label187;
        }
        if (!paramBoolean) {
          break label154;
        }
        i = 255;
        bZ();
        if (this.nZ != null) {
          break label167;
        }
        this.nZ = new ValueAnimator();
        this.nZ.setDuration(this.oa);
        ValueAnimator localValueAnimator = this.nZ;
        if (i <= this.nX) {
          break label159;
        }
        localTimeInterpolator = android.support.design.a.a.eR;
        label93:
        localValueAnimator.setInterpolator(localTimeInterpolator);
        this.nZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.nZ.setIntValues(new int[] { this.nX, i });
      this.nZ.start();
      this.nY = paramBoolean;
      return;
      i = 0;
      break;
      label154:
      i = 0;
      break label40;
      label159:
      localTimeInterpolator = android.support.design.a.a.eS;
      break label93;
      label167:
      if (this.nZ.isRunning()) {
        this.nZ.cancel();
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
    if (this.nW != paramDrawable)
    {
      if (this.nW != null) {
        this.nW.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.nW = localDrawable;
      if (this.nW != null)
      {
        if (this.nW.isStateful()) {
          this.nW.setState(getDrawableState());
        }
        android.support.v4.graphics.drawable.a.b(this.nW, t.Y(this));
        paramDrawable = this.nW;
        if (getVisibility() != 0) {
          break label125;
        }
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.nW.setCallback(this);
      this.nW.setAlpha(this.nX);
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
    this.nS.setText(paramCharSequence);
    cc();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.nT)
    {
      this.nT = paramBoolean;
      cc();
      ca();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.nW != null) && (this.nW.isVisible() != bool)) {
        this.nW.setVisible(bool, false);
      }
      if ((this.nV != null) && (this.nV.isVisible() != bool)) {
        this.nV.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.nV) || (paramDrawable == this.nW);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int of = 0;
    float og = 0.5F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CollapsingToolbarLayout_Layout);
      this.of = paramContext.getInt(0, 0);
      this.og = paramContext.getFloat(1, 0.5F);
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
      CollapsingToolbarLayout.this.od = paramInt;
      int i;
      label42:
      CollapsingToolbarLayout.LayoutParams localLayoutParams;
      p localp;
      if (CollapsingToolbarLayout.this.le != null)
      {
        i = CollapsingToolbarLayout.this.le.getSystemWindowInsetTop();
        k = CollapsingToolbarLayout.this.getChildCount();
        j = 0;
        if (j >= k) {
          break label161;
        }
        paramAppBarLayout = CollapsingToolbarLayout.this.getChildAt(j);
        localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
        localp = CollapsingToolbarLayout.o(paramAppBarLayout);
        switch (localLayoutParams.of)
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
        localp.G(Math.round(localLayoutParams.og * f));
      }
      label161:
      CollapsingToolbarLayout.this.cb();
      if ((CollapsingToolbarLayout.this.nW != null) && (i > 0)) {
        t.W(CollapsingToolbarLayout.this);
      }
      int j = CollapsingToolbarLayout.this.getHeight();
      int k = t.af(CollapsingToolbarLayout.this);
      CollapsingToolbarLayout.this.nS.m(Math.abs(paramInt) / (j - k - i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */