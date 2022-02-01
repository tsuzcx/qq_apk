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
import androidx.core.g.ae;
import androidx.core.g.ae.e;
import androidx.core.g.s;
import androidx.core.g.w;
import com.google.android.material.a.f;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.c;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  ae buI;
  private boolean bvf;
  private Toolbar bvg;
  private View bvh;
  private View bvi;
  private int bvj;
  private int bvk;
  private int bvl;
  private int bvm;
  private final Rect bvn;
  final c bvo;
  private boolean bvp;
  private boolean bvq;
  private Drawable bvr;
  Drawable bvs;
  private int bvt;
  private boolean bvu;
  private ValueAnimator bvv;
  private long bvw;
  private AppBarLayout.b bvx;
  int bvy;
  private int scrimVisibleHeightTrigger;
  private int toolbarId;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(234619);
    this.bvf = true;
    this.bvn = new Rect();
    this.scrimVisibleHeightTrigger = -1;
    this.bvo = new c(this);
    this.bvo.c(com.google.android.material.a.a.buq);
    paramContext = k.a(paramContext, paramAttributeSet, a.k.CollapsingToolbarLayout, paramInt, a.j.Widget_Design_CollapsingToolbar, new int[0]);
    this.bvo.fV(paramContext.getInt(a.k.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    this.bvo.fW(paramContext.getInt(a.k.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    paramInt = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMargin, 0);
    this.bvm = paramInt;
    this.bvl = paramInt;
    this.bvk = paramInt;
    this.bvj = paramInt;
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginStart)) {
      this.bvj = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
      this.bvl = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginTop)) {
      this.bvk = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
      this.bvm = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    }
    this.bvp = paramContext.getBoolean(a.k.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(paramContext.getText(a.k.CollapsingToolbarLayout_title));
    this.bvo.fY(a.j.TextAppearance_Design_CollapsingToolbar_Expanded);
    this.bvo.fX(a.i.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
      this.bvo.fY(paramContext.getResourceId(a.k.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    }
    if (paramContext.hasValue(a.k.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
      this.bvo.fX(paramContext.getResourceId(a.k.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    }
    this.scrimVisibleHeightTrigger = paramContext.getDimensionPixelSize(a.k.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
    this.bvw = paramContext.getInt(a.k.CollapsingToolbarLayout_scrimAnimationDuration, 600);
    setContentScrim(paramContext.getDrawable(a.k.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(paramContext.getDrawable(a.k.CollapsingToolbarLayout_statusBarScrim));
    this.toolbarId = paramContext.getResourceId(a.k.CollapsingToolbarLayout_toolbarId, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    w.a(this, new s()
    {
      public final ae a(View paramAnonymousView, ae paramAnonymousae)
      {
        AppMethodBeat.i(234520);
        CollapsingToolbarLayout localCollapsingToolbarLayout = CollapsingToolbarLayout.this;
        paramAnonymousView = null;
        if (w.Z(localCollapsingToolbarLayout)) {
          paramAnonymousView = paramAnonymousae;
        }
        if (!androidx.core.f.d.equals(localCollapsingToolbarLayout.buI, paramAnonymousView))
        {
          localCollapsingToolbarLayout.buI = paramAnonymousView;
          localCollapsingToolbarLayout.requestLayout();
        }
        paramAnonymousView = paramAnonymousae.Oa.hl();
        AppMethodBeat.o(234520);
        return paramAnonymousView;
      }
    });
    AppMethodBeat.o(234619);
  }
  
  private View bX(View paramView)
  {
    AppMethodBeat.i(234628);
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    AppMethodBeat.o(234628);
    return localView;
  }
  
  private static int bY(View paramView)
  {
    AppMethodBeat.i(234638);
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      i = paramView.getHeight();
      int j = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      int k = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
      AppMethodBeat.o(234638);
      return k + (i + j);
    }
    int i = paramView.getHeight();
    AppMethodBeat.o(234638);
    return i;
  }
  
  static a bZ(View paramView)
  {
    AppMethodBeat.i(234639);
    a locala2 = (a)paramView.getTag(a.f.view_offset_helper);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramView);
      paramView.setTag(a.f.view_offset_helper, locala1);
    }
    AppMethodBeat.o(234639);
    return locala1;
  }
  
  private void vZ()
  {
    AppMethodBeat.i(234627);
    if (!this.bvf)
    {
      AppMethodBeat.o(234627);
      return;
    }
    this.bvg = null;
    this.bvh = null;
    if (this.toolbarId != -1)
    {
      this.bvg = ((Toolbar)findViewById(this.toolbarId));
      if (this.bvg != null) {
        this.bvh = bX(this.bvg);
      }
    }
    int i;
    if (this.bvg == null)
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
      this.bvg = ((Toolbar)localObject);
      wa();
      this.bvf = false;
      AppMethodBeat.o(234627);
      return;
      i += 1;
      break;
    }
  }
  
  private void wa()
  {
    AppMethodBeat.i(234630);
    if ((!this.bvp) && (this.bvi != null))
    {
      ViewParent localViewParent = this.bvi.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.bvi);
      }
    }
    if ((this.bvp) && (this.bvg != null))
    {
      if (this.bvi == null) {
        this.bvi = new View(getContext());
      }
      if (this.bvi.getParent() == null) {
        this.bvg.addView(this.bvi, -1, -1);
      }
    }
    AppMethodBeat.o(234630);
  }
  
  private void wc()
  {
    AppMethodBeat.i(234696);
    setContentDescription(getTitle());
    AppMethodBeat.o(234696);
  }
  
  final int ca(View paramView)
  {
    AppMethodBeat.i(234693);
    a locala = bZ(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = getHeight();
    int j = locala.bvT;
    int k = paramView.getHeight();
    int m = localLayoutParams.bottomMargin;
    AppMethodBeat.o(234693);
    return i - j - k - m;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(234624);
    super.draw(paramCanvas);
    vZ();
    if ((this.bvg == null) && (this.bvr != null) && (this.bvt > 0))
    {
      this.bvr.mutate().setAlpha(this.bvt);
      this.bvr.draw(paramCanvas);
    }
    if ((this.bvp) && (this.bvq)) {
      this.bvo.draw(paramCanvas);
    }
    if ((this.bvs != null) && (this.bvt > 0)) {
      if (this.buI == null) {
        break label165;
      }
    }
    label165:
    for (int i = this.buI.hd();; i = 0)
    {
      if (i > 0)
      {
        this.bvs.setBounds(0, -this.bvy, getWidth(), i - this.bvy);
        this.bvs.mutate().setAlpha(this.bvt);
        this.bvs.draw(paramCanvas);
      }
      AppMethodBeat.o(234624);
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(234625);
    if ((this.bvr != null) && (this.bvt > 0)) {
      if ((this.bvh == null) || (this.bvh == this)) {
        if (paramView == this.bvg)
        {
          i = 1;
          if (i == 0) {
            break label133;
          }
          this.bvr.mutate().setAlpha(this.bvt);
          this.bvr.draw(paramCanvas);
        }
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      if ((super.drawChild(paramCanvas, paramView, paramLong)) || (i != 0))
      {
        AppMethodBeat.o(234625);
        return true;
        i = 0;
        break;
        if (paramView == this.bvh)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
      AppMethodBeat.o(234625);
      return false;
    }
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(234657);
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.bvs;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.bvr;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    bool1 = bool2;
    if (this.bvo != null) {
      bool1 = bool2 | this.bvo.setState(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
    AppMethodBeat.o(234657);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(234690);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(234690);
    return paramAttributeSet;
  }
  
  public int getCollapsedTitleGravity()
  {
    return this.bvo.bBA;
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    c localc = this.bvo;
    if (localc.bBL != null) {
      return localc.bBL;
    }
    return Typeface.DEFAULT;
  }
  
  public Drawable getContentScrim()
  {
    return this.bvr;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.bvo.bBz;
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.bvm;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.bvl;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.bvj;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.bvk;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    c localc = this.bvo;
    if (localc.bBM != null) {
      return localc.bBM;
    }
    return Typeface.DEFAULT;
  }
  
  int getScrimAlpha()
  {
    return this.bvt;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.bvw;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    AppMethodBeat.i(234689);
    if (this.scrimVisibleHeightTrigger >= 0)
    {
      i = this.scrimVisibleHeightTrigger;
      AppMethodBeat.o(234689);
      return i;
    }
    if (this.buI != null) {}
    for (int i = this.buI.hd();; i = 0)
    {
      int j = w.P(this);
      if (j <= 0) {
        break;
      }
      i = Math.min(i + j * 2, getHeight());
      AppMethodBeat.o(234689);
      return i;
    }
    i = getHeight() / 3;
    AppMethodBeat.o(234689);
    return i;
  }
  
  public Drawable getStatusBarScrim()
  {
    return this.bvs;
  }
  
  public CharSequence getTitle()
  {
    if (this.bvp) {
      return this.bvo.LV;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(234620);
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      w.c(this, w.Z((View)localViewParent));
      if (this.bvx == null) {
        this.bvx = new a();
      }
      ((AppBarLayout)localViewParent).a(this.bvx);
      w.Y(this);
    }
    AppMethodBeat.o(234620);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(234622);
    Object localObject = getParent();
    if ((this.bvx != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.b localb = this.bvx;
      if ((((AppBarLayout)localObject).listeners != null) && (localb != null)) {
        ((AppBarLayout)localObject).listeners.remove(localb);
      }
    }
    super.onDetachedFromWindow();
    AppMethodBeat.o(234622);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int m = 0;
    AppMethodBeat.i(234636);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int k;
    int n;
    Object localObject;
    if (this.buI != null)
    {
      k = this.buI.hd();
      n = getChildCount();
      i = 0;
      while (i < n)
      {
        localObject = getChildAt(i);
        if ((!w.Z((View)localObject)) && (((View)localObject).getTop() < k)) {
          w.s((View)localObject, k);
        }
        i += 1;
      }
    }
    if ((this.bvp) && (this.bvi != null))
    {
      if ((!w.al(this.bvi)) || (this.bvi.getVisibility() != 0)) {
        break label410;
      }
      paramBoolean = true;
      this.bvq = paramBoolean;
      if (this.bvq)
      {
        if (w.I(this) != 1) {
          break label415;
        }
        i = j;
        label157:
        if (this.bvh == null) {
          break label421;
        }
        localObject = this.bvh;
        label170:
        n = ca((View)localObject);
        com.google.android.material.internal.d.a(this, this.bvi, this.bvn);
        localObject = this.bvo;
        int i1 = this.bvn.left;
        if (i == 0) {
          break label430;
        }
        j = this.bvg.getTitleMarginEnd();
        label219:
        int i2 = this.bvn.top;
        int i3 = this.bvg.getTitleMarginTop();
        int i4 = this.bvn.right;
        if (i == 0) {
          break label442;
        }
        k = this.bvg.getTitleMarginStart();
        label260:
        ((c)localObject).q(i1 + j, i3 + (i2 + n), k + i4, n + this.bvn.bottom - this.bvg.getTitleMarginBottom());
        localObject = this.bvo;
        if (i == 0) {
          break label454;
        }
        j = this.bvl;
        label318:
        k = this.bvn.top;
        n = this.bvk;
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
    for (int i = this.bvj;; i = this.bvl)
    {
      ((c)localObject).p(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.bvm);
      this.bvo.xq();
      paramInt2 = getChildCount();
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        bZ(getChildAt(paramInt1)).wf();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      i = 0;
      break label157;
      localObject = this.bvg;
      break label170;
      j = this.bvg.getTitleMarginStart();
      break label219;
      k = this.bvg.getTitleMarginEnd();
      break label260;
      j = this.bvj;
      break label318;
    }
    if (this.bvg != null)
    {
      if ((this.bvp) && (TextUtils.isEmpty(this.bvo.LV))) {
        setTitle(this.bvg.getTitle());
      }
      if ((this.bvh != null) && (this.bvh != this)) {
        break label547;
      }
      setMinimumHeight(bY(this.bvg));
    }
    for (;;)
    {
      wb();
      AppMethodBeat.o(234636);
      return;
      label547:
      setMinimumHeight(bY(this.bvh));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234633);
    vZ();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (this.buI != null) {}
    for (paramInt2 = this.buI.hd();; paramInt2 = 0)
    {
      if ((i == 0) && (paramInt2 > 0)) {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2 + getMeasuredHeight(), 1073741824));
      }
      AppMethodBeat.o(234633);
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234626);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.bvr != null) {
      this.bvr.setBounds(0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(234626);
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    AppMethodBeat.i(234666);
    this.bvo.fW(paramInt);
    AppMethodBeat.o(234666);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    AppMethodBeat.i(234663);
    this.bvo.fX(paramInt);
    AppMethodBeat.o(234663);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    AppMethodBeat.i(234664);
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(234664);
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(234665);
    this.bvo.e(paramColorStateList);
    AppMethodBeat.o(234665);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(234676);
    c localc = this.bvo;
    if (localc.bBL != paramTypeface)
    {
      localc.bBL = paramTypeface;
      localc.xq();
    }
    AppMethodBeat.o(234676);
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    AppMethodBeat.i(234650);
    if (this.bvr != paramDrawable)
    {
      if (this.bvr != null) {
        this.bvr.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.bvr = localDrawable;
      if (this.bvr != null)
      {
        this.bvr.setBounds(0, 0, getWidth(), getHeight());
        this.bvr.setCallback(this);
        this.bvr.setAlpha(this.bvt);
      }
      w.G(this);
    }
    AppMethodBeat.o(234650);
  }
  
  public void setContentScrimColor(int paramInt)
  {
    AppMethodBeat.i(234652);
    setContentScrim(new ColorDrawable(paramInt));
    AppMethodBeat.o(234652);
  }
  
  public void setContentScrimResource(int paramInt)
  {
    AppMethodBeat.i(234653);
    setContentScrim(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(234653);
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    AppMethodBeat.i(234669);
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(234669);
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    AppMethodBeat.i(234674);
    this.bvo.fV(paramInt);
    AppMethodBeat.o(234674);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    AppMethodBeat.i(234687);
    this.bvm = paramInt;
    requestLayout();
    AppMethodBeat.o(234687);
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    AppMethodBeat.i(234685);
    this.bvl = paramInt;
    requestLayout();
    AppMethodBeat.o(234685);
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    AppMethodBeat.i(234682);
    this.bvj = paramInt;
    requestLayout();
    AppMethodBeat.o(234682);
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    AppMethodBeat.i(234684);
    this.bvk = paramInt;
    requestLayout();
    AppMethodBeat.o(234684);
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    AppMethodBeat.i(234668);
    this.bvo.fY(paramInt);
    AppMethodBeat.o(234668);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(234673);
    this.bvo.f(paramColorStateList);
    AppMethodBeat.o(234673);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(234680);
    c localc = this.bvo;
    if (localc.bBM != paramTypeface)
    {
      localc.bBM = paramTypeface;
      localc.xq();
    }
    AppMethodBeat.o(234680);
  }
  
  void setScrimAlpha(int paramInt)
  {
    AppMethodBeat.i(234649);
    if (paramInt != this.bvt)
    {
      if ((this.bvr != null) && (this.bvg != null)) {
        w.G(this.bvg);
      }
      this.bvt = paramInt;
      w.G(this);
    }
    AppMethodBeat.o(234649);
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.bvw = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    AppMethodBeat.i(234688);
    if (this.scrimVisibleHeightTrigger != paramInt)
    {
      this.scrimVisibleHeightTrigger = paramInt;
      wb();
    }
    AppMethodBeat.o(234688);
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    int j = 255;
    AppMethodBeat.i(234648);
    label46:
    TimeInterpolator localTimeInterpolator;
    if ((w.ah(this)) && (!isInEditMode()))
    {
      i = 1;
      if (this.bvu != paramBoolean)
      {
        if (i == 0) {
          break label199;
        }
        if (!paramBoolean) {
          break label166;
        }
        i = 255;
        vZ();
        if (this.bvv != null) {
          break label179;
        }
        this.bvv = new ValueAnimator();
        this.bvv.setDuration(this.bvw);
        ValueAnimator localValueAnimator = this.bvv;
        if (i <= this.bvt) {
          break label171;
        }
        localTimeInterpolator = com.google.android.material.a.a.buo;
        label99:
        localValueAnimator.setInterpolator(localTimeInterpolator);
        this.bvv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(234540);
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            AppMethodBeat.o(234540);
          }
        });
      }
    }
    for (;;)
    {
      this.bvv.setIntValues(new int[] { this.bvt, i });
      this.bvv.start();
      this.bvu = paramBoolean;
      AppMethodBeat.o(234648);
      return;
      i = 0;
      break;
      label166:
      i = 0;
      break label46;
      label171:
      localTimeInterpolator = com.google.android.material.a.a.bup;
      break label99;
      label179:
      if (this.bvv.isRunning()) {
        this.bvv.cancel();
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
    AppMethodBeat.i(234656);
    if (this.bvs != paramDrawable)
    {
      if (this.bvs != null) {
        this.bvs.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.bvs = localDrawable;
      if (this.bvs != null)
      {
        if (this.bvs.isStateful()) {
          this.bvs.setState(getDrawableState());
        }
        androidx.core.graphics.drawable.a.b(this.bvs, w.I(this));
        paramDrawable = this.bvs;
        if (getVisibility() != 0) {
          break label137;
        }
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.bvs.setCallback(this);
      this.bvs.setAlpha(this.bvt);
      w.G(this);
      AppMethodBeat.o(234656);
      return;
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    AppMethodBeat.i(234660);
    setStatusBarScrim(new ColorDrawable(paramInt));
    AppMethodBeat.o(234660);
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    AppMethodBeat.i(234661);
    setStatusBarScrim(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(234661);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(234641);
    this.bvo.setText(paramCharSequence);
    wc();
    AppMethodBeat.o(234641);
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(234644);
    if (paramBoolean != this.bvp)
    {
      this.bvp = paramBoolean;
      wc();
      wa();
      requestLayout();
    }
    AppMethodBeat.o(234644);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(234659);
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.bvs != null) && (this.bvs.isVisible() != bool)) {
        this.bvs.setVisible(bool, false);
      }
      if ((this.bvr != null) && (this.bvr.isVisible() != bool)) {
        this.bvr.setVisible(bool, false);
      }
      AppMethodBeat.o(234659);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(234658);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.bvr) || (paramDrawable == this.bvs))
    {
      AppMethodBeat.o(234658);
      return true;
    }
    AppMethodBeat.o(234658);
    return false;
  }
  
  final void wb()
  {
    AppMethodBeat.i(234691);
    if ((this.bvr != null) || (this.bvs != null)) {
      if (getHeight() + this.bvy >= getScrimVisibleHeightTrigger()) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      setScrimsShown(bool);
      AppMethodBeat.o(234691);
      return;
    }
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int bvA;
    float bvB;
    
    public LayoutParams()
    {
      super(-1);
      this.bvA = 0;
      this.bvB = 0.5F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(234551);
      this.bvA = 0;
      this.bvB = 0.5F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.CollapsingToolbarLayout_Layout);
      this.bvA = paramContext.getInt(a.k.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
      this.bvB = paramContext.getFloat(a.k.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F);
      paramContext.recycle();
      AppMethodBeat.o(234551);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.bvA = 0;
      this.bvB = 0.5F;
    }
  }
  
  final class a
    implements AppBarLayout.b
  {
    a() {}
    
    public final void c(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(234581);
      CollapsingToolbarLayout.this.bvy = paramInt;
      int i;
      label47:
      CollapsingToolbarLayout.LayoutParams localLayoutParams;
      a locala;
      if (CollapsingToolbarLayout.this.buI != null)
      {
        i = CollapsingToolbarLayout.this.buI.hd();
        k = CollapsingToolbarLayout.this.getChildCount();
        j = 0;
        if (j >= k) {
          break label169;
        }
        paramAppBarLayout = CollapsingToolbarLayout.this.getChildAt(j);
        localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
        locala = CollapsingToolbarLayout.bZ(paramAppBarLayout);
        switch (localLayoutParams.bvA)
        {
        }
      }
      for (;;)
      {
        j += 1;
        break label47;
        i = 0;
        break;
        locala.fT(androidx.core.b.a.clamp(-paramInt, 0, CollapsingToolbarLayout.this.ca(paramAppBarLayout)));
        continue;
        float f = -paramInt;
        locala.fT(Math.round(localLayoutParams.bvB * f));
      }
      label169:
      CollapsingToolbarLayout.this.wb();
      if ((CollapsingToolbarLayout.this.bvs != null) && (i > 0)) {
        w.G(CollapsingToolbarLayout.this);
      }
      int j = CollapsingToolbarLayout.this.getHeight();
      int k = w.P(CollapsingToolbarLayout.this);
      CollapsingToolbarLayout.this.bvo.T(Math.abs(paramInt) / (j - k - i));
      AppMethodBeat.o(234581);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */