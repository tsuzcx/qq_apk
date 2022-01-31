package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.a.f;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.v4.content.b;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.support.v4.widget.s;
import android.support.v7.a.a.i;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  y ev;
  private boolean gT = true;
  private int gU;
  private Toolbar gV;
  private View gW;
  private View gX;
  private int gY;
  private int gZ;
  private int ha;
  private int hb;
  private final Rect hc = new Rect();
  final f hd;
  private boolean he;
  private boolean hf;
  private Drawable hg;
  Drawable hh;
  private int hi;
  private boolean hj;
  private ValueAnimator hk;
  private long hl;
  private int hm = -1;
  private AppBarLayout.a hn;
  int ho;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    o.G(paramContext);
    this.hd = new f(this);
    this.hd.b(a.ep);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.CollapsingToolbarLayout, paramInt, a.j.Widget_Design_CollapsingToolbar);
    this.hd.z(paramContext.getInt(a.k.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    this.hd.A(paramContext.getInt(a.k.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    paramInt = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMargin, 0);
    this.hb = paramInt;
    this.ha = paramInt;
    this.gZ = paramInt;
    this.gY = paramInt;
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginStart)) {
      this.gY = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
      this.ha = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginTop)) {
      this.gZ = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
      this.hb = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    }
    this.he = paramContext.getBoolean(a.k.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(paramContext.getText(a.k.CollapsingToolbarLayout_title));
    this.hd.C(a.j.TextAppearance_Design_CollapsingToolbar_Expanded);
    this.hd.B(a.i.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
      this.hd.C(paramContext.getResourceId(a.k.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
      this.hd.B(paramContext.getResourceId(a.k.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    }
    this.hm = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
    this.hl = paramContext.getInt(a.k.CollapsingToolbarLayout_scrimAnimationDuration, 600);
    setContentScrim(paramContext.getDrawable(a.k.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(paramContext.getDrawable(a.k.CollapsingToolbarLayout_statusBarScrim));
    this.gU = paramContext.getResourceId(a.k.CollapsingToolbarLayout_toolbarId, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    q.a(this, new CollapsingToolbarLayout.1(this));
  }
  
  private void aB()
  {
    if (!this.gT) {
      return;
    }
    this.gV = null;
    this.gW = null;
    if (this.gU != -1)
    {
      this.gV = ((Toolbar)findViewById(this.gU));
      if (this.gV != null)
      {
        Object localObject2 = this.gV;
        for (localObject1 = ((View)localObject2).getParent(); (localObject1 != this) && (localObject1 != null); localObject1 = ((ViewParent)localObject1).getParent()) {
          if ((localObject1 instanceof View)) {
            localObject2 = (View)localObject1;
          }
        }
        this.gW = ((View)localObject2);
      }
    }
    int i;
    if (this.gV == null)
    {
      int j = getChildCount();
      i = 0;
      if (i >= j) {
        break label157;
      }
      localObject1 = getChildAt(i);
      if (!(localObject1 instanceof Toolbar)) {
        break label150;
      }
    }
    label150:
    label157:
    for (Object localObject1 = (Toolbar)localObject1;; localObject1 = null)
    {
      this.gV = ((Toolbar)localObject1);
      aC();
      this.gT = false;
      return;
      i += 1;
      break;
    }
  }
  
  private void aC()
  {
    if ((!this.he) && (this.gX != null))
    {
      ViewParent localViewParent = this.gX.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.gX);
      }
    }
    if ((this.he) && (this.gV != null))
    {
      if (this.gX == null) {
        this.gX = new View(getContext());
      }
      if (this.gX.getParent() == null) {
        this.gV.addView(this.gX, -1, -1);
      }
    }
  }
  
  private static int j(View paramView)
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
  
  static p k(View paramView)
  {
    p localp2 = (p)paramView.getTag(a.f.view_offset_helper);
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = new p(paramView);
      paramView.setTag(a.f.view_offset_helper, localp1);
    }
    return localp1;
  }
  
  final void aD()
  {
    if ((this.hg != null) || (this.hh != null)) {
      if (getHeight() + this.ho >= getScrimVisibleHeightTrigger()) {
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
    return paramLayoutParams instanceof CollapsingToolbarLayout.LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    aB();
    if ((this.gV == null) && (this.hg != null) && (this.hi > 0))
    {
      this.hg.mutate().setAlpha(this.hi);
      this.hg.draw(paramCanvas);
    }
    if ((this.he) && (this.hf)) {
      this.hd.draw(paramCanvas);
    }
    if ((this.hh != null) && (this.hi > 0)) {
      if (this.ev == null) {
        break label153;
      }
    }
    label153:
    for (int i = this.ev.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.hh.setBounds(0, -this.ho, getWidth(), i - this.ho);
        this.hh.mutate().setAlpha(this.hi);
        this.hh.draw(paramCanvas);
      }
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = false;
    if ((this.hg != null) && (this.hi > 0)) {
      if ((this.gW == null) || (this.gW == this)) {
        if (paramView == this.gV)
        {
          i = 1;
          if (i == 0) {
            break label120;
          }
          this.hg.mutate().setAlpha(this.hi);
          this.hg.draw(paramCanvas);
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
      if (paramView == this.gW)
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
    Drawable localDrawable = this.hh;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.hg;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    bool1 = bool2;
    if (this.hd != null) {
      bool1 = bool2 | this.hd.setState(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new CollapsingToolbarLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getCollapsedTitleGravity()
  {
    return this.hd.gk;
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    return this.hd.aw();
  }
  
  public Drawable getContentScrim()
  {
    return this.hg;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.hd.gj;
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.hb;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.ha;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.gY;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.gZ;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    f localf = this.hd;
    if (localf.gw != null) {
      return localf.gw;
    }
    return Typeface.DEFAULT;
  }
  
  int getScrimAlpha()
  {
    return this.hi;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.hl;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    if (this.hm >= 0) {
      return this.hm;
    }
    if (this.ev != null) {}
    for (int i = this.ev.getSystemWindowInsetTop();; i = 0)
    {
      int j = q.X(this);
      if (j <= 0) {
        break;
      }
      return Math.min(i + j * 2, getHeight());
    }
    return getHeight() / 3;
  }
  
  public Drawable getStatusBarScrim()
  {
    return this.hh;
  }
  
  public CharSequence getTitle()
  {
    if (this.he) {
      return this.hd.mText;
    }
    return null;
  }
  
  final int l(View paramView)
  {
    p localp = k(paramView);
    CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramView.getLayoutParams();
    return getHeight() - localp.mg - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof AppBarLayout))
    {
      q.e(this, q.ae((View)localObject));
      if (this.hn == null) {
        this.hn = new CollapsingToolbarLayout.a(this);
      }
      localObject = (AppBarLayout)localObject;
      AppBarLayout.a locala = this.hn;
      if (((AppBarLayout)localObject).mListeners == null) {
        ((AppBarLayout)localObject).mListeners = new ArrayList();
      }
      if ((locala != null) && (!((AppBarLayout)localObject).mListeners.contains(locala))) {
        ((AppBarLayout)localObject).mListeners.add(locala);
      }
      q.ad(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getParent();
    if ((this.hn != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.a locala = this.hn;
      if ((((AppBarLayout)localObject).mListeners != null) && (locala != null)) {
        ((AppBarLayout)localObject).mListeners.remove(locala);
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
    if (this.ev != null)
    {
      k = this.ev.getSystemWindowInsetTop();
      n = getChildCount();
      i = 0;
      while (i < n)
      {
        localObject = getChildAt(i);
        if ((!q.ae((View)localObject)) && (((View)localObject).getTop() < k)) {
          q.p((View)localObject, k);
        }
        i += 1;
      }
    }
    if ((this.he) && (this.gX != null))
    {
      if ((!q.ao(this.gX)) || (this.gX.getVisibility() != 0)) {
        break label404;
      }
      paramBoolean = true;
      this.hf = paramBoolean;
      if (this.hf)
      {
        if (q.Q(this) != 1) {
          break label409;
        }
        i = j;
        label151:
        if (this.gW == null) {
          break label415;
        }
        localObject = this.gW;
        label164:
        n = l((View)localObject);
        s.a(this, this.gX, this.hc);
        localObject = this.hd;
        int i1 = this.hc.left;
        if (i == 0) {
          break label424;
        }
        j = this.gV.getTitleMarginEnd();
        label213:
        int i2 = this.hc.top;
        int i3 = this.gV.getTitleMarginTop();
        int i4 = this.hc.right;
        if (i == 0) {
          break label436;
        }
        k = this.gV.getTitleMarginStart();
        label254:
        ((f)localObject).c(i1 + j, i3 + (i2 + n), k + i4, n + this.hc.bottom - this.gV.getTitleMarginBottom());
        localObject = this.hd;
        if (i == 0) {
          break label448;
        }
        j = this.ha;
        label312:
        k = this.hc.top;
        n = this.gZ;
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
    for (int i = this.gY;; i = this.ha)
    {
      ((f)localObject).b(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.hb);
      this.hd.az();
      paramInt2 = getChildCount();
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        k(getChildAt(paramInt1)).bh();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      i = 0;
      break label151;
      localObject = this.gV;
      break label164;
      j = this.gV.getTitleMarginStart();
      break label213;
      k = this.gV.getTitleMarginEnd();
      break label254;
      j = this.gY;
      break label312;
    }
    if (this.gV != null)
    {
      if ((this.he) && (TextUtils.isEmpty(this.hd.mText))) {
        this.hd.setText(this.gV.getTitle());
      }
      if ((this.gW != null) && (this.gW != this)) {
        break label538;
      }
      setMinimumHeight(j(this.gV));
    }
    for (;;)
    {
      aD();
      return;
      label538:
      setMinimumHeight(j(this.gW));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    aB();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.ev != null) {}
    for (paramInt2 = this.ev.getSystemWindowInsetTop();; paramInt2 = 0)
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
    if (this.hg != null) {
      this.hg.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.hd.A(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.hd.B(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.hd.b(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    f localf = this.hd;
    if (f.a(localf.gv, paramTypeface))
    {
      localf.gv = paramTypeface;
      localf.az();
    }
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.hg != paramDrawable)
    {
      if (this.hg != null) {
        this.hg.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.hg = localDrawable;
      if (this.hg != null)
      {
        this.hg.setBounds(0, 0, getWidth(), getHeight());
        this.hg.setCallback(this);
        this.hg.setAlpha(this.hi);
      }
      q.O(this);
    }
  }
  
  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(b.g(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    this.hd.z(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.hb = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.ha = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.gY = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.gZ = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.hd.C(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.hd.c(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    f localf = this.hd;
    if (f.a(localf.gw, paramTypeface))
    {
      localf.gw = paramTypeface;
      localf.az();
    }
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.hi)
    {
      if ((this.hg != null) && (this.gV != null)) {
        q.O(this.gV);
      }
      this.hi = paramInt;
      q.O(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.hl = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.hm != paramInt)
    {
      this.hm = paramInt;
      aD();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    int j = 255;
    label40:
    Interpolator localInterpolator;
    if ((q.al(this)) && (!isInEditMode()))
    {
      i = 1;
      if (this.hj != paramBoolean)
      {
        if (i == 0) {
          break label187;
        }
        if (!paramBoolean) {
          break label154;
        }
        i = 255;
        aB();
        if (this.hk != null) {
          break label167;
        }
        this.hk = new ValueAnimator();
        this.hk.setDuration(this.hl);
        ValueAnimator localValueAnimator = this.hk;
        if (i <= this.hi) {
          break label159;
        }
        localInterpolator = a.em;
        label93:
        localValueAnimator.setInterpolator(localInterpolator);
        this.hk.addUpdateListener(new CollapsingToolbarLayout.2(this));
      }
    }
    for (;;)
    {
      this.hk.setIntValues(new int[] { this.hi, i });
      this.hk.start();
      this.hj = paramBoolean;
      return;
      i = 0;
      break;
      label154:
      i = 0;
      break label40;
      label159:
      localInterpolator = a.eo;
      break label93;
      label167:
      if (this.hk.isRunning()) {
        this.hk.cancel();
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
    if (this.hh != paramDrawable)
    {
      if (this.hh != null) {
        this.hh.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.hh = localDrawable;
      if (this.hh != null)
      {
        if (this.hh.isStateful()) {
          this.hh.setState(getDrawableState());
        }
        android.support.v4.a.a.a.b(this.hh, q.Q(this));
        paramDrawable = this.hh;
        if (getVisibility() != 0) {
          break label125;
        }
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.hh.setCallback(this);
      this.hh.setAlpha(this.hi);
      q.O(this);
      return;
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(b.g(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.hd.setText(paramCharSequence);
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.he)
    {
      this.he = paramBoolean;
      aC();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.hh != null) && (this.hh.isVisible() != bool)) {
        this.hh.setVisible(bool, false);
      }
      if ((this.hg != null) && (this.hg.isVisible() != bool)) {
        this.hg.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.hg) || (paramDrawable == this.hh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */