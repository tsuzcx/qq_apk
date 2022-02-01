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
import android.support.v4.view.ac;
import android.support.v4.view.u;
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
  private final Rect mC = new Rect();
  ac mZ;
  private boolean pG = true;
  private int pH;
  private Toolbar pI;
  private View pJ;
  private View pK;
  private int pL;
  private int pM;
  private int pN;
  private int pO;
  final d pP = new d(this);
  private boolean pQ;
  private boolean pR;
  private Drawable pS;
  Drawable pT;
  private int pU;
  private boolean pV;
  private ValueAnimator pW;
  private long pX;
  private int pY = -1;
  private AppBarLayout.b pZ;
  int qa;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.pP.a(android.support.design.a.a.gO);
    paramContext = android.support.design.internal.f.a(paramContext, paramAttributeSet, a.a.CollapsingToolbarLayout, paramInt, 2131821684, new int[0]);
    this.pP.M(paramContext.getInt(3, 8388691));
    this.pP.N(paramContext.getInt(0, 8388627));
    paramInt = paramContext.getDimensionPixelSize(4, 0);
    this.pO = paramInt;
    this.pN = paramInt;
    this.pM = paramInt;
    this.pL = paramInt;
    if (paramContext.hasValue(7)) {
      this.pL = paramContext.getDimensionPixelSize(7, 0);
    }
    if (paramContext.hasValue(6)) {
      this.pN = paramContext.getDimensionPixelSize(6, 0);
    }
    if (paramContext.hasValue(8)) {
      this.pM = paramContext.getDimensionPixelSize(8, 0);
    }
    if (paramContext.hasValue(5)) {
      this.pO = paramContext.getDimensionPixelSize(5, 0);
    }
    this.pQ = paramContext.getBoolean(14, true);
    setTitle(paramContext.getText(13));
    this.pP.P(2131821430);
    this.pP.O(2131821404);
    if (paramContext.hasValue(9)) {
      this.pP.P(paramContext.getResourceId(9, 0));
    }
    if (paramContext.hasValue(1)) {
      this.pP.O(paramContext.getResourceId(1, 0));
    }
    this.pY = paramContext.getDimensionPixelSize(11, -1);
    this.pX = paramContext.getInt(10, 600);
    setContentScrim(paramContext.getDrawable(2));
    setStatusBarScrim(paramContext.getDrawable(12));
    this.pH = paramContext.getResourceId(15, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    u.a(this, new android.support.v4.view.p()
    {
      public final ac a(View paramAnonymousView, ac paramAnonymousac)
      {
        CollapsingToolbarLayout localCollapsingToolbarLayout = CollapsingToolbarLayout.this;
        paramAnonymousView = null;
        if (u.aq(localCollapsingToolbarLayout)) {
          paramAnonymousView = paramAnonymousac;
        }
        if (!j.equals(localCollapsingToolbarLayout.mZ, paramAnonymousView))
        {
          localCollapsingToolbarLayout.mZ = paramAnonymousView;
          localCollapsingToolbarLayout.requestLayout();
        }
        return paramAnonymousac.fI();
      }
    });
  }
  
  private void cr()
  {
    if (!this.pG) {
      return;
    }
    this.pI = null;
    this.pJ = null;
    if (this.pH != -1)
    {
      this.pI = ((Toolbar)findViewById(this.pH));
      if (this.pI != null) {
        this.pJ = n(this.pI);
      }
    }
    int i;
    if (this.pI == null)
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
      this.pI = ((Toolbar)localObject);
      cs();
      this.pG = false;
      return;
      i += 1;
      break;
    }
  }
  
  private void cs()
  {
    if ((!this.pQ) && (this.pK != null))
    {
      ViewParent localViewParent = this.pK.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.pK);
      }
    }
    if ((this.pQ) && (this.pI != null))
    {
      if (this.pK == null) {
        this.pK = new View(getContext());
      }
      if (this.pK.getParent() == null) {
        this.pI.addView(this.pK, -1, -1);
      }
    }
  }
  
  private void cu()
  {
    setContentDescription(getTitle());
  }
  
  private View n(View paramView)
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
  
  private static int o(View paramView)
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
  
  static p p(View paramView)
  {
    p localp2 = (p)paramView.getTag(2131309863);
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = new p(paramView);
      paramView.setTag(2131309863, localp1);
    }
    return localp1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  final void ct()
  {
    if ((this.pS != null) || (this.pT != null)) {
      if (getHeight() + this.qa >= getScrimVisibleHeightTrigger()) {
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
    cr();
    if ((this.pI == null) && (this.pS != null) && (this.pU > 0))
    {
      this.pS.mutate().setAlpha(this.pU);
      this.pS.draw(paramCanvas);
    }
    if ((this.pQ) && (this.pR)) {
      this.pP.draw(paramCanvas);
    }
    if ((this.pT != null) && (this.pU > 0)) {
      if (this.mZ == null) {
        break label153;
      }
    }
    label153:
    for (int i = this.mZ.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.pT.setBounds(0, -this.qa, getWidth(), i - this.qa);
        this.pT.mutate().setAlpha(this.pU);
        this.pT.draw(paramCanvas);
      }
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = false;
    if ((this.pS != null) && (this.pU > 0)) {
      if ((this.pJ == null) || (this.pJ == this)) {
        if (paramView == this.pI)
        {
          i = 1;
          if (i == 0) {
            break label120;
          }
          this.pS.mutate().setAlpha(this.pU);
          this.pS.draw(paramCanvas);
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
      if (paramView == this.pJ)
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
    Drawable localDrawable = this.pT;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.pS;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    bool1 = bool2;
    if (this.pP != null) {
      bool1 = bool2 | this.pP.setState(arrayOfInt);
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
    return this.pP.oW;
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    d locald = this.pP;
    if (locald.pi != null) {
      return locald.pi;
    }
    return Typeface.DEFAULT;
  }
  
  public Drawable getContentScrim()
  {
    return this.pS;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.pP.oV;
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.pO;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.pN;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.pL;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.pM;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    d locald = this.pP;
    if (locald.pj != null) {
      return locald.pj;
    }
    return Typeface.DEFAULT;
  }
  
  int getScrimAlpha()
  {
    return this.pU;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.pX;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    if (this.pY >= 0) {
      return this.pY;
    }
    if (this.mZ != null) {}
    for (int i = this.mZ.getSystemWindowInsetTop();; i = 0)
    {
      int j = u.ag(this);
      if (j <= 0) {
        break;
      }
      return Math.min(i + j * 2, getHeight());
    }
    return getHeight() / 3;
  }
  
  public Drawable getStatusBarScrim()
  {
    return this.pT;
  }
  
  public CharSequence getTitle()
  {
    if (this.pQ) {
      return this.pP.text;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      u.e(this, u.aq((View)localViewParent));
      if (this.pZ == null) {
        this.pZ = new a();
      }
      ((AppBarLayout)localViewParent).a(this.pZ);
      u.ap(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getParent();
    if ((this.pZ != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.b localb = this.pZ;
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
    if (this.mZ != null)
    {
      k = this.mZ.getSystemWindowInsetTop();
      n = getChildCount();
      i = 0;
      while (i < n)
      {
        localObject = getChildAt(i);
        if ((!u.aq((View)localObject)) && (((View)localObject).getTop() < k)) {
          u.s((View)localObject, k);
        }
        i += 1;
      }
    }
    if ((this.pQ) && (this.pK != null))
    {
      if ((!u.aD(this.pK)) || (this.pK.getVisibility() != 0)) {
        break label404;
      }
      paramBoolean = true;
      this.pR = paramBoolean;
      if (this.pR)
      {
        if (u.Z(this) != 1) {
          break label409;
        }
        i = j;
        label151:
        if (this.pJ == null) {
          break label415;
        }
        localObject = this.pJ;
        label164:
        n = q((View)localObject);
        f.a(this, this.pK, this.mC);
        localObject = this.pP;
        int i1 = this.mC.left;
        if (i == 0) {
          break label424;
        }
        j = this.pI.getTitleMarginEnd();
        label213:
        int i2 = this.mC.top;
        int i3 = this.pI.getTitleMarginTop();
        int i4 = this.mC.right;
        if (i == 0) {
          break label436;
        }
        k = this.pI.getTitleMarginStart();
        label254:
        ((d)localObject).d(i1 + j, i3 + (i2 + n), k + i4, n + this.mC.bottom - this.pI.getTitleMarginBottom());
        localObject = this.pP;
        if (i == 0) {
          break label448;
        }
        j = this.pN;
        label312:
        k = this.mC.top;
        n = this.pM;
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
    for (int i = this.pL;; i = this.pN)
    {
      ((d)localObject).c(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.pO);
      this.pP.cp();
      paramInt2 = getChildCount();
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        p(getChildAt(paramInt1)).dx();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      i = 0;
      break label151;
      localObject = this.pI;
      break label164;
      j = this.pI.getTitleMarginStart();
      break label213;
      k = this.pI.getTitleMarginEnd();
      break label254;
      j = this.pL;
      break label312;
    }
    if (this.pI != null)
    {
      if ((this.pQ) && (TextUtils.isEmpty(this.pP.text))) {
        setTitle(this.pI.getTitle());
      }
      if ((this.pJ != null) && (this.pJ != this)) {
        break label535;
      }
      setMinimumHeight(o(this.pI));
    }
    for (;;)
    {
      ct();
      return;
      label535:
      setMinimumHeight(o(this.pJ));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    cr();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.mZ != null) {}
    for (paramInt2 = this.mZ.getSystemWindowInsetTop();; paramInt2 = 0)
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
    if (this.pS != null) {
      this.pS.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  final int q(View paramView)
  {
    p localp = p(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - localp.wE - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.pP.N(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.pP.O(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.pP.d(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    d locald = this.pP;
    if (locald.pi != paramTypeface)
    {
      locald.pi = paramTypeface;
      locald.cp();
    }
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.pS != paramDrawable)
    {
      if (this.pS != null) {
        this.pS.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.pS = localDrawable;
      if (this.pS != null)
      {
        this.pS.setBounds(0, 0, getWidth(), getHeight());
        this.pS.setCallback(this);
        this.pS.setAlpha(this.pU);
      }
      u.X(this);
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
    this.pP.M(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.pO = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.pN = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.pL = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.pM = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.pP.P(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.pP.e(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    d locald = this.pP;
    if (locald.pj != paramTypeface)
    {
      locald.pj = paramTypeface;
      locald.cp();
    }
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.pU)
    {
      if ((this.pS != null) && (this.pI != null)) {
        u.X(this.pI);
      }
      this.pU = paramInt;
      u.X(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.pX = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.pY != paramInt)
    {
      this.pY = paramInt;
      ct();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    int j = 255;
    label40:
    TimeInterpolator localTimeInterpolator;
    if ((u.az(this)) && (!isInEditMode()))
    {
      i = 1;
      if (this.pV != paramBoolean)
      {
        if (i == 0) {
          break label187;
        }
        if (!paramBoolean) {
          break label154;
        }
        i = 255;
        cr();
        if (this.pW != null) {
          break label167;
        }
        this.pW = new ValueAnimator();
        this.pW.setDuration(this.pX);
        ValueAnimator localValueAnimator = this.pW;
        if (i <= this.pU) {
          break label159;
        }
        localTimeInterpolator = android.support.design.a.a.gM;
        label93:
        localValueAnimator.setInterpolator(localTimeInterpolator);
        this.pW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.pW.setIntValues(new int[] { this.pU, i });
      this.pW.start();
      this.pV = paramBoolean;
      return;
      i = 0;
      break;
      label154:
      i = 0;
      break label40;
      label159:
      localTimeInterpolator = android.support.design.a.a.gN;
      break label93;
      label167:
      if (this.pW.isRunning()) {
        this.pW.cancel();
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
    if (this.pT != paramDrawable)
    {
      if (this.pT != null) {
        this.pT.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.pT = localDrawable;
      if (this.pT != null)
      {
        if (this.pT.isStateful()) {
          this.pT.setState(getDrawableState());
        }
        android.support.v4.graphics.drawable.a.b(this.pT, u.Z(this));
        paramDrawable = this.pT;
        if (getVisibility() != 0) {
          break label125;
        }
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.pT.setCallback(this);
      this.pT.setAlpha(this.pU);
      u.X(this);
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
    this.pP.setText(paramCharSequence);
    cu();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.pQ)
    {
      this.pQ = paramBoolean;
      cu();
      cs();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.pT != null) && (this.pT.isVisible() != bool)) {
        this.pT.setVisible(bool, false);
      }
      if ((this.pS != null) && (this.pS.isVisible() != bool)) {
        this.pS.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.pS) || (paramDrawable == this.pT);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int qc = 0;
    float qd = 0.5F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CollapsingToolbarLayout_Layout);
      this.qc = paramContext.getInt(0, 0);
      this.qd = paramContext.getFloat(1, 0.5F);
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
      CollapsingToolbarLayout.this.qa = paramInt;
      int i;
      label42:
      CollapsingToolbarLayout.LayoutParams localLayoutParams;
      p localp;
      if (CollapsingToolbarLayout.this.mZ != null)
      {
        i = CollapsingToolbarLayout.this.mZ.getSystemWindowInsetTop();
        k = CollapsingToolbarLayout.this.getChildCount();
        j = 0;
        if (j >= k) {
          break label161;
        }
        paramAppBarLayout = CollapsingToolbarLayout.this.getChildAt(j);
        localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
        localp = CollapsingToolbarLayout.p(paramAppBarLayout);
        switch (localLayoutParams.qc)
        {
        }
      }
      for (;;)
      {
        j += 1;
        break label42;
        i = 0;
        break;
        localp.G(android.support.v4.b.a.clamp(-paramInt, 0, CollapsingToolbarLayout.this.q(paramAppBarLayout)));
        continue;
        float f = -paramInt;
        localp.G(Math.round(localLayoutParams.qd * f));
      }
      label161:
      CollapsingToolbarLayout.this.ct();
      if ((CollapsingToolbarLayout.this.pT != null) && (i > 0)) {
        u.X(CollapsingToolbarLayout.this);
      }
      int j = CollapsingToolbarLayout.this.getHeight();
      int k = u.ag(CollapsingToolbarLayout.this);
      CollapsingToolbarLayout.this.pP.k(Math.abs(paramInt) / (j - k - i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */