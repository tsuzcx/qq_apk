package com.google.android.material.appbar;

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
import androidx.appcompat.a.i;
import androidx.appcompat.widget.Toolbar;
import androidx.core.g.ah;
import androidx.core.g.s;
import androidx.core.g.z;
import com.google.android.material.a.f;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.d;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  ah dnL;
  private AppBarLayout.b doA;
  int doB;
  private boolean doi;
  private Toolbar doj;
  private View dok;
  private View dol;
  private int dom;
  private int don;
  private int doo;
  private int dop;
  final com.google.android.material.internal.c doq;
  private boolean dor;
  private boolean dos;
  private Drawable dou;
  Drawable dov;
  private int dow;
  private boolean dox;
  private ValueAnimator doy;
  private long doz;
  private int scrimVisibleHeightTrigger;
  private final Rect tmpRect;
  private int toolbarId;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210063);
    this.doi = true;
    this.tmpRect = new Rect();
    this.scrimVisibleHeightTrigger = -1;
    this.doq = new com.google.android.material.internal.c(this);
    this.doq.c(com.google.android.material.a.a.dnu);
    paramContext = k.a(paramContext, paramAttributeSet, a.k.CollapsingToolbarLayout, paramInt, a.j.Widget_Design_CollapsingToolbar, new int[0]);
    this.doq.jk(paramContext.getInt(a.k.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    this.doq.jl(paramContext.getInt(a.k.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    paramInt = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMargin, 0);
    this.dop = paramInt;
    this.doo = paramInt;
    this.don = paramInt;
    this.dom = paramInt;
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginStart)) {
      this.dom = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
      this.doo = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginTop)) {
      this.don = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
      this.dop = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    }
    this.dor = paramContext.getBoolean(a.k.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(paramContext.getText(a.k.CollapsingToolbarLayout_title));
    this.doq.jn(a.j.TextAppearance_Design_CollapsingToolbar_Expanded);
    this.doq.jm(a.i.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
      this.doq.jn(paramContext.getResourceId(a.k.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
      this.doq.jm(paramContext.getResourceId(a.k.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    }
    this.scrimVisibleHeightTrigger = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
    this.doz = paramContext.getInt(a.k.CollapsingToolbarLayout_scrimAnimationDuration, 600);
    setContentScrim(paramContext.getDrawable(a.k.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(paramContext.getDrawable(a.k.CollapsingToolbarLayout_statusBarScrim));
    this.toolbarId = paramContext.getResourceId(a.k.CollapsingToolbarLayout_toolbarId, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    z.a(this, new s()
    {
      public final ah a(View paramAnonymousView, ah paramAnonymousah)
      {
        AppMethodBeat.i(210041);
        CollapsingToolbarLayout localCollapsingToolbarLayout = CollapsingToolbarLayout.this;
        paramAnonymousView = null;
        if (z.al(localCollapsingToolbarLayout)) {
          paramAnonymousView = paramAnonymousah;
        }
        if (!androidx.core.f.c.equals(localCollapsingToolbarLayout.dnL, paramAnonymousView))
        {
          localCollapsingToolbarLayout.dnL = paramAnonymousView;
          localCollapsingToolbarLayout.requestLayout();
        }
        paramAnonymousView = paramAnonymousah.Es();
        AppMethodBeat.o(210041);
        return paramAnonymousView;
      }
    });
    AppMethodBeat.o(210063);
  }
  
  private void VB()
  {
    AppMethodBeat.i(210098);
    setContentDescription(getTitle());
    AppMethodBeat.o(210098);
  }
  
  private void Vy()
  {
    AppMethodBeat.i(210069);
    if (!this.doi)
    {
      AppMethodBeat.o(210069);
      return;
    }
    this.doj = null;
    this.dok = null;
    if (this.toolbarId != -1)
    {
      this.doj = ((Toolbar)findViewById(this.toolbarId));
      if (this.doj != null) {
        this.dok = ct(this.doj);
      }
    }
    int i;
    if (this.doj == null)
    {
      int j = getChildCount();
      i = 0;
      if (i >= j) {
        break label137;
      }
      localObject = getChildAt(i);
      if (!(localObject instanceof Toolbar)) {
        break label130;
      }
    }
    label130:
    label137:
    for (Object localObject = (Toolbar)localObject;; localObject = null)
    {
      this.doj = ((Toolbar)localObject);
      Vz();
      this.doi = false;
      AppMethodBeat.o(210069);
      return;
      i += 1;
      break;
    }
  }
  
  private void Vz()
  {
    AppMethodBeat.i(210082);
    if ((!this.dor) && (this.dol != null))
    {
      ViewParent localViewParent = this.dol.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.dol);
      }
    }
    if ((this.dor) && (this.doj != null))
    {
      if (this.dol == null) {
        this.dol = new View(getContext());
      }
      if (this.dol.getParent() == null) {
        this.doj.addView(this.dol, -1, -1);
      }
    }
    AppMethodBeat.o(210082);
  }
  
  private View ct(View paramView)
  {
    AppMethodBeat.i(210075);
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    AppMethodBeat.o(210075);
    return localView;
  }
  
  private static int cu(View paramView)
  {
    AppMethodBeat.i(210086);
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      i = paramView.getHeight();
      int j = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      int k = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
      AppMethodBeat.o(210086);
      return k + (i + j);
    }
    int i = paramView.getHeight();
    AppMethodBeat.o(210086);
    return i;
  }
  
  static a cv(View paramView)
  {
    AppMethodBeat.i(210092);
    a locala2 = (a)paramView.getTag(a.f.view_offset_helper);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramView);
      paramView.setTag(a.f.view_offset_helper, locala1);
    }
    AppMethodBeat.o(210092);
    return locala1;
  }
  
  final void VA()
  {
    AppMethodBeat.i(210283);
    if ((this.dou != null) || (this.dov != null)) {
      if (getHeight() + this.doB >= getScrimVisibleHeightTrigger()) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      setScrimsShown(bool);
      AppMethodBeat.o(210283);
      return;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  final int cw(View paramView)
  {
    AppMethodBeat.i(210284);
    a locala = cv(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = getHeight();
    int j = locala.doW;
    int k = paramView.getHeight();
    int m = localLayoutParams.bottomMargin;
    AppMethodBeat.o(210284);
    return i - j - k - m;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(210121);
    super.draw(paramCanvas);
    Vy();
    if ((this.doj == null) && (this.dou != null) && (this.dow > 0))
    {
      this.dou.mutate().setAlpha(this.dow);
      this.dou.draw(paramCanvas);
    }
    if ((this.dor) && (this.dos)) {
      this.doq.draw(paramCanvas);
    }
    if ((this.dov != null) && (this.dow > 0)) {
      if (this.dnL == null) {
        break label165;
      }
    }
    label165:
    for (int i = this.dnL.En();; i = 0)
    {
      if (i > 0)
      {
        this.dov.setBounds(0, -this.doB, getWidth(), i - this.doB);
        this.dov.mutate().setAlpha(this.dow);
        this.dov.draw(paramCanvas);
      }
      AppMethodBeat.o(210121);
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(210125);
    if ((this.dou != null) && (this.dow > 0)) {
      if ((this.dok == null) || (this.dok == this)) {
        if (paramView == this.doj)
        {
          i = 1;
          if (i == 0) {
            break label133;
          }
          this.dou.mutate().setAlpha(this.dow);
          this.dou.draw(paramCanvas);
        }
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      if ((super.drawChild(paramCanvas, paramView, paramLong)) || (i != 0))
      {
        AppMethodBeat.o(210125);
        return true;
        i = 0;
        break;
        if (paramView == this.dok)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
      AppMethodBeat.o(210125);
      return false;
    }
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(210202);
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.dov;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.dou;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    bool1 = bool2;
    if (this.doq != null) {
      bool1 = bool2 | this.doq.setState(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
    AppMethodBeat.o(210202);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(210281);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(210281);
    return paramAttributeSet;
  }
  
  public int getCollapsedTitleGravity()
  {
    return this.doq.duC;
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    com.google.android.material.internal.c localc = this.doq;
    if (localc.duN != null) {
      return localc.duN;
    }
    return Typeface.DEFAULT;
  }
  
  public Drawable getContentScrim()
  {
    return this.dou;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.doq.duB;
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.dop;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.doo;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.dom;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.don;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    com.google.android.material.internal.c localc = this.doq;
    if (localc.duO != null) {
      return localc.duO;
    }
    return Typeface.DEFAULT;
  }
  
  int getScrimAlpha()
  {
    return this.dow;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.doz;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    AppMethodBeat.i(210278);
    if (this.scrimVisibleHeightTrigger >= 0)
    {
      i = this.scrimVisibleHeightTrigger;
      AppMethodBeat.o(210278);
      return i;
    }
    if (this.dnL != null) {}
    for (int i = this.dnL.En();; i = 0)
    {
      int j = z.ab(this);
      if (j <= 0) {
        break;
      }
      i = Math.min(i + j * 2, getHeight());
      AppMethodBeat.o(210278);
      return i;
    }
    i = getHeight() / 3;
    AppMethodBeat.o(210278);
    return i;
  }
  
  public Drawable getStatusBarScrim()
  {
    return this.dov;
  }
  
  public CharSequence getTitle()
  {
    if (this.dor) {
      return this.doq.bba;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(210106);
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      z.c(this, z.al((View)localViewParent));
      if (this.doA == null) {
        this.doA = new a();
      }
      ((AppBarLayout)localViewParent).a(this.doA);
      z.ak(this);
    }
    AppMethodBeat.o(210106);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(210114);
    Object localObject = getParent();
    if ((this.doA != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.b localb = this.doA;
      if ((((AppBarLayout)localObject).listeners != null) && (localb != null)) {
        ((AppBarLayout)localObject).listeners.remove(localb);
      }
    }
    super.onDetachedFromWindow();
    AppMethodBeat.o(210114);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int m = 0;
    AppMethodBeat.i(210143);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int k;
    int n;
    Object localObject;
    if (this.dnL != null)
    {
      k = this.dnL.En();
      n = getChildCount();
      i = 0;
      while (i < n)
      {
        localObject = getChildAt(i);
        if ((!z.al((View)localObject)) && (((View)localObject).getTop() < k)) {
          z.s((View)localObject, k);
        }
        i += 1;
      }
    }
    if ((this.dor) && (this.dol != null))
    {
      if ((!z.ay(this.dol)) || (this.dol.getVisibility() != 0)) {
        break label410;
      }
      paramBoolean = true;
      this.dos = paramBoolean;
      if (this.dos)
      {
        if (z.U(this) != 1) {
          break label415;
        }
        i = j;
        label157:
        if (this.dok == null) {
          break label421;
        }
        localObject = this.dok;
        label170:
        n = cw((View)localObject);
        d.a(this, this.dol, this.tmpRect);
        localObject = this.doq;
        int i1 = this.tmpRect.left;
        if (i == 0) {
          break label430;
        }
        j = this.doj.getTitleMarginEnd();
        label219:
        int i2 = this.tmpRect.top;
        int i3 = this.doj.getTitleMarginTop();
        int i4 = this.tmpRect.right;
        if (i == 0) {
          break label442;
        }
        k = this.doj.getTitleMarginStart();
        label260:
        ((com.google.android.material.internal.c)localObject).z(i1 + j, i3 + (i2 + n), k + i4, n + this.tmpRect.bottom - this.doj.getTitleMarginBottom());
        localObject = this.doq;
        if (i == 0) {
          break label454;
        }
        j = this.doo;
        label318:
        k = this.tmpRect.top;
        n = this.don;
        if (i == 0) {
          break label463;
        }
      }
    }
    label410:
    label415:
    label421:
    label430:
    label442:
    label454:
    label463:
    for (int i = this.dom;; i = this.doo)
    {
      ((com.google.android.material.internal.c)localObject).y(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.dop);
      this.doq.xQ();
      paramInt2 = getChildCount();
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        cv(getChildAt(paramInt1)).VE();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      i = 0;
      break label157;
      localObject = this.doj;
      break label170;
      j = this.doj.getTitleMarginStart();
      break label219;
      k = this.doj.getTitleMarginEnd();
      break label260;
      j = this.dom;
      break label318;
    }
    if (this.doj != null)
    {
      if ((this.dor) && (TextUtils.isEmpty(this.doq.bba))) {
        setTitle(this.doj.getTitle());
      }
      if ((this.dok != null) && (this.dok != this)) {
        break label547;
      }
      setMinimumHeight(cu(this.doj));
    }
    for (;;)
    {
      VA();
      AppMethodBeat.o(210143);
      return;
      label547:
      setMinimumHeight(cu(this.dok));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210137);
    Vy();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.dnL != null) {}
    for (paramInt2 = this.dnL.En();; paramInt2 = 0)
    {
      if ((i == 0) && (paramInt2 > 0)) {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2 + getMeasuredHeight(), 1073741824));
      }
      AppMethodBeat.o(210137);
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(210131);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.dou != null) {
      this.dou.setBounds(0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(210131);
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    AppMethodBeat.i(210241);
    this.doq.jl(paramInt);
    AppMethodBeat.o(210241);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    AppMethodBeat.i(210229);
    this.doq.jm(paramInt);
    AppMethodBeat.o(210229);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    AppMethodBeat.i(210233);
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(210233);
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210236);
    this.doq.e(paramColorStateList);
    AppMethodBeat.o(210236);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(210258);
    com.google.android.material.internal.c localc = this.doq;
    if (localc.duN != paramTypeface)
    {
      localc.duN = paramTypeface;
      localc.xQ();
    }
    AppMethodBeat.o(210258);
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    AppMethodBeat.i(210181);
    if (this.dou != paramDrawable)
    {
      if (this.dou != null) {
        this.dou.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.dou = localDrawable;
      if (this.dou != null)
      {
        this.dou.setBounds(0, 0, getWidth(), getHeight());
        this.dou.setCallback(this);
        this.dou.setAlpha(this.dow);
      }
      z.Q(this);
    }
    AppMethodBeat.o(210181);
  }
  
  public void setContentScrimColor(int paramInt)
  {
    AppMethodBeat.i(210183);
    setContentScrim(new ColorDrawable(paramInt));
    AppMethodBeat.o(210183);
  }
  
  public void setContentScrimResource(int paramInt)
  {
    AppMethodBeat.i(210187);
    setContentScrim(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(210187);
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    AppMethodBeat.i(210248);
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(210248);
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    AppMethodBeat.i(210254);
    this.doq.jk(paramInt);
    AppMethodBeat.o(210254);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    AppMethodBeat.i(210274);
    this.dop = paramInt;
    requestLayout();
    AppMethodBeat.o(210274);
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    AppMethodBeat.i(210272);
    this.doo = paramInt;
    requestLayout();
    AppMethodBeat.o(210272);
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    AppMethodBeat.i(210268);
    this.dom = paramInt;
    requestLayout();
    AppMethodBeat.o(210268);
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    AppMethodBeat.i(210270);
    this.don = paramInt;
    requestLayout();
    AppMethodBeat.o(210270);
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    AppMethodBeat.i(210246);
    this.doq.jn(paramInt);
    AppMethodBeat.o(210246);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210251);
    this.doq.f(paramColorStateList);
    AppMethodBeat.o(210251);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(210263);
    com.google.android.material.internal.c localc = this.doq;
    if (localc.duO != paramTypeface)
    {
      localc.duO = paramTypeface;
      localc.xQ();
    }
    AppMethodBeat.o(210263);
  }
  
  void setScrimAlpha(int paramInt)
  {
    AppMethodBeat.i(210171);
    if (paramInt != this.dow)
    {
      if ((this.dou != null) && (this.doj != null)) {
        z.Q(this.doj);
      }
      this.dow = paramInt;
      z.Q(this);
    }
    AppMethodBeat.o(210171);
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.doz = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    AppMethodBeat.i(210276);
    if (this.scrimVisibleHeightTrigger != paramInt)
    {
      this.scrimVisibleHeightTrigger = paramInt;
      VA();
    }
    AppMethodBeat.o(210276);
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    int j = 255;
    AppMethodBeat.i(210164);
    label46:
    TimeInterpolator localTimeInterpolator;
    if ((z.au(this)) && (!isInEditMode()))
    {
      i = 1;
      if (this.dox != paramBoolean)
      {
        if (i == 0) {
          break label199;
        }
        if (!paramBoolean) {
          break label166;
        }
        i = 255;
        Vy();
        if (this.doy != null) {
          break label179;
        }
        this.doy = new ValueAnimator();
        this.doy.setDuration(this.doz);
        ValueAnimator localValueAnimator = this.doy;
        if (i <= this.dow) {
          break label171;
        }
        localTimeInterpolator = com.google.android.material.a.a.dns;
        label99:
        localValueAnimator.setInterpolator(localTimeInterpolator);
        this.doy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(210044);
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            AppMethodBeat.o(210044);
          }
        });
      }
    }
    for (;;)
    {
      this.doy.setIntValues(new int[] { this.dow, i });
      this.doy.start();
      this.dox = paramBoolean;
      AppMethodBeat.o(210164);
      return;
      i = 0;
      break;
      label166:
      i = 0;
      break label46;
      label171:
      localTimeInterpolator = com.google.android.material.a.a.dnt;
      break label99;
      label179:
      if (this.doy.isRunning()) {
        this.doy.cancel();
      }
    }
    label199:
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
    AppMethodBeat.i(210197);
    if (this.dov != paramDrawable)
    {
      if (this.dov != null) {
        this.dov.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.dov = localDrawable;
      if (this.dov != null)
      {
        if (this.dov.isStateful()) {
          this.dov.setState(getDrawableState());
        }
        androidx.core.graphics.drawable.a.b(this.dov, z.U(this));
        paramDrawable = this.dov;
        if (getVisibility() != 0) {
          break label137;
        }
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.dov.setCallback(this);
      this.dov.setAlpha(this.dow);
      z.Q(this);
      AppMethodBeat.o(210197);
      return;
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    AppMethodBeat.i(210217);
    setStatusBarScrim(new ColorDrawable(paramInt));
    AppMethodBeat.o(210217);
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    AppMethodBeat.i(210223);
    setStatusBarScrim(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(210223);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(210150);
    this.doq.setText(paramCharSequence);
    VB();
    AppMethodBeat.o(210150);
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(210156);
    if (paramBoolean != this.dor)
    {
      this.dor = paramBoolean;
      VB();
      Vz();
      requestLayout();
    }
    AppMethodBeat.o(210156);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(210212);
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.dov != null) && (this.dov.isVisible() != bool)) {
        this.dov.setVisible(bool, false);
      }
      if ((this.dou != null) && (this.dou.isVisible() != bool)) {
        this.dou.setVisible(bool, false);
      }
      AppMethodBeat.o(210212);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(210207);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.dou) || (paramDrawable == this.dov))
    {
      AppMethodBeat.o(210207);
      return true;
    }
    AppMethodBeat.o(210207);
    return false;
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int doD;
    float doE;
    
    public LayoutParams()
    {
      super(-1);
      this.doD = 0;
      this.doE = 0.5F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(210008);
      this.doD = 0;
      this.doE = 0.5F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.CollapsingToolbarLayout_Layout);
      this.doD = paramContext.getInt(a.k.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
      this.doE = paramContext.getFloat(a.k.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F);
      paramContext.recycle();
      AppMethodBeat.o(210008);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.doD = 0;
      this.doE = 0.5F;
    }
  }
  
  final class a
    implements AppBarLayout.b
  {
    a() {}
    
    public final void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(210064);
      CollapsingToolbarLayout.this.doB = paramInt;
      int i;
      label47:
      CollapsingToolbarLayout.LayoutParams localLayoutParams;
      a locala;
      if (CollapsingToolbarLayout.this.dnL != null)
      {
        i = CollapsingToolbarLayout.this.dnL.En();
        k = CollapsingToolbarLayout.this.getChildCount();
        j = 0;
        if (j >= k) {
          break label169;
        }
        paramAppBarLayout = CollapsingToolbarLayout.this.getChildAt(j);
        localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
        locala = CollapsingToolbarLayout.cv(paramAppBarLayout);
        switch (localLayoutParams.doD)
        {
        }
      }
      for (;;)
      {
        j += 1;
        break label47;
        i = 0;
        break;
        locala.ji(androidx.core.b.a.clamp(-paramInt, 0, CollapsingToolbarLayout.this.cw(paramAppBarLayout)));
        continue;
        float f = -paramInt;
        locala.ji(Math.round(localLayoutParams.doE * f));
      }
      label169:
      CollapsingToolbarLayout.this.VA();
      if ((CollapsingToolbarLayout.this.dov != null) && (i > 0)) {
        z.Q(CollapsingToolbarLayout.this);
      }
      int j = CollapsingToolbarLayout.this.getHeight();
      int k = z.ab(CollapsingToolbarLayout.this);
      CollapsingToolbarLayout.this.doq.aU(Math.abs(paramInt) / (j - k - i));
      AppMethodBeat.o(210064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */