package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar.a;
import androidx.appcompat.widget.ae;
import androidx.core.f.e.a;
import androidx.core.f.e.b;
import androidx.core.f.e.c;
import androidx.core.g.h;
import androidx.core.g.v;
import androidx.core.g.z;
import androidx.core.widget.j;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.a;
import androidx.viewpager.widget.ViewPager.c;
import com.google.android.material.a.b;
import com.google.android.material.a.d;
import com.google.android.material.a.h;
import com.google.android.material.a.k;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout
  extends HorizontalScrollView
{
  private static final e.a<e> dxO;
  private int contentInsetStart;
  public final ArrayList<e> dxP;
  public e dxQ;
  private final RectF dxR;
  private final d dxS;
  ColorStateList dxT;
  ColorStateList dxU;
  ColorStateList dxV;
  Drawable dxW;
  PorterDuff.Mode dxX;
  float dxY;
  float dxZ;
  final int dya;
  private final int dyb;
  private final int dyc;
  private final int dyd;
  boolean dye;
  boolean dyf;
  boolean dyg;
  private b dyh;
  public final ArrayList<b> dyi;
  private b dyj;
  private ValueAnimator dyk;
  ViewPager dyl;
  private androidx.viewpager.widget.a dym;
  private DataSetObserver dyn;
  private TabLayout.f dyo;
  private a dyp;
  private boolean dyq;
  private final e.a<g> dyr;
  int mode;
  int tabGravity;
  int tabIndicatorAnimationDuration;
  int tabIndicatorGravity;
  int tabMaxWidth;
  int tabPaddingBottom;
  int tabPaddingEnd;
  int tabPaddingStart;
  int tabPaddingTop;
  int tabTextAppearance;
  
  static
  {
    AppMethodBeat.i(209093);
    dxO = new e.c(16);
    AppMethodBeat.o(209093);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.tabStyle);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208947);
    this.dxP = new ArrayList();
    this.dxR = new RectF();
    this.tabMaxWidth = 2147483647;
    this.dyi = new ArrayList();
    this.dyr = new e.b(12);
    setHorizontalScrollBarEnabled(false);
    this.dxS = new d(paramContext);
    super.addView(this.dxS, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = k.a(paramContext, paramAttributeSet, a.k.TabLayout, paramInt, com.google.android.material.a.j.Widget_Design_TabLayout, new int[] { a.k.TabLayout_tabTextAppearance });
    this.dxS.setSelectedIndicatorHeight(localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabIndicatorHeight, -1));
    this.dxS.setSelectedIndicatorColor(localTypedArray.getColor(a.k.TabLayout_tabIndicatorColor, 0));
    setSelectedTabIndicator(com.google.android.material.e.a.c(paramContext, localTypedArray, a.k.TabLayout_tabIndicator));
    setSelectedTabIndicatorGravity(localTypedArray.getInt(a.k.TabLayout_tabIndicatorGravity, 0));
    setTabIndicatorFullWidth(localTypedArray.getBoolean(a.k.TabLayout_tabIndicatorFullWidth, true));
    paramInt = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabPadding, 0);
    this.tabPaddingBottom = paramInt;
    this.tabPaddingEnd = paramInt;
    this.tabPaddingTop = paramInt;
    this.tabPaddingStart = paramInt;
    this.tabPaddingStart = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabPaddingStart, this.tabPaddingStart);
    this.tabPaddingTop = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabPaddingTop, this.tabPaddingTop);
    this.tabPaddingEnd = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
    this.tabPaddingBottom = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
    this.tabTextAppearance = localTypedArray.getResourceId(a.k.TabLayout_tabTextAppearance, com.google.android.material.a.j.TextAppearance_Design_Tab);
    paramAttributeSet = paramContext.obtainStyledAttributes(this.tabTextAppearance, androidx.appcompat.a.j.TextAppearance);
    try
    {
      this.dxY = paramAttributeSet.getDimensionPixelSize(androidx.appcompat.a.j.TextAppearance_android_textSize, 0);
      this.dxT = com.google.android.material.e.a.b(paramContext, paramAttributeSet, androidx.appcompat.a.j.TextAppearance_android_textColor);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(a.k.TabLayout_tabTextColor)) {
        this.dxT = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.TabLayout_tabTextColor);
      }
      if (localTypedArray.hasValue(a.k.TabLayout_tabSelectedTextColor))
      {
        paramInt = localTypedArray.getColor(a.k.TabLayout_tabSelectedTextColor, 0);
        this.dxT = cy(this.dxT.getDefaultColor(), paramInt);
      }
      this.dxU = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.TabLayout_tabIconTint);
      this.dxX = l.c(localTypedArray.getInt(a.k.TabLayout_tabIconTintMode, -1), null);
      this.dxV = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.TabLayout_tabRippleColor);
      this.tabIndicatorAnimationDuration = localTypedArray.getInt(a.k.TabLayout_tabIndicatorAnimationDuration, 300);
      this.dyb = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabMinWidth, -1);
      this.dyc = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabMaxWidth, -1);
      this.dya = localTypedArray.getResourceId(a.k.TabLayout_tabBackground, 0);
      this.contentInsetStart = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabContentStart, 0);
      this.mode = localTypedArray.getInt(a.k.TabLayout_tabMode, 1);
      this.tabGravity = localTypedArray.getInt(a.k.TabLayout_tabGravity, 0);
      this.dye = localTypedArray.getBoolean(a.k.TabLayout_tabInlineLabel, false);
      this.dyg = localTypedArray.getBoolean(a.k.TabLayout_tabUnboundedRipple, false);
      localTypedArray.recycle();
      paramContext = getResources();
      this.dxZ = paramContext.getDimensionPixelSize(a.d.design_tab_text_size_2line);
      this.dyd = paramContext.getDimensionPixelSize(a.d.design_tab_scrollable_min_width);
      Xd();
      AppMethodBeat.o(208947);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
      AppMethodBeat.o(208947);
    }
  }
  
  private static e WX()
  {
    AppMethodBeat.i(208960);
    e locale2 = (e)dxO.acquire();
    e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new e();
    }
    AppMethodBeat.o(208960);
    return locale1;
  }
  
  private void Xa()
  {
    AppMethodBeat.i(208971);
    int j = this.dxP.size();
    int i = 0;
    while (i < j)
    {
      ((e)this.dxP.get(i)).updateView();
      i += 1;
    }
    AppMethodBeat.o(208971);
  }
  
  private LinearLayout.LayoutParams Xb()
  {
    AppMethodBeat.i(208996);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    AppMethodBeat.o(208996);
    return localLayoutParams;
  }
  
  private void Xc()
  {
    AppMethodBeat.i(209017);
    if (this.dyk == null)
    {
      this.dyk = new ValueAnimator();
      this.dyk.setInterpolator(com.google.android.material.a.a.dnr);
      this.dyk.setDuration(this.tabIndicatorAnimationDuration);
      this.dyk.addUpdateListener(new TabLayout.1(this));
    }
    AppMethodBeat.o(209017);
  }
  
  private void Xd()
  {
    AppMethodBeat.i(209064);
    if (this.mode == 0) {}
    for (int i = Math.max(0, this.contentInsetStart - this.tabPaddingStart);; i = 0)
    {
      z.g(this.dxS, i, 0, 0, 0);
      switch (this.mode)
      {
      }
      for (;;)
      {
        bP(true);
        AppMethodBeat.o(209064);
        return;
        this.dxS.setGravity(1);
        continue;
        this.dxS.setGravity(8388611);
      }
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mode == 1) && (this.tabGravity == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(TabItem paramTabItem)
  {
    AppMethodBeat.i(208956);
    e locale = WW();
    if (paramTabItem.bba != null) {
      locale.D(paramTabItem.bba);
    }
    if (paramTabItem.dqY != null)
    {
      locale.dqY = paramTabItem.dqY;
      locale.updateView();
    }
    if (paramTabItem.dxN != 0) {
      locale.jw(paramTabItem.dxN);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription())) {
      locale.E(paramTabItem.getContentDescription());
    }
    a(locale);
    AppMethodBeat.o(208956);
  }
  
  private void a(e parame, int paramInt)
  {
    AppMethodBeat.i(208982);
    parame.position = paramInt;
    this.dxP.add(paramInt, parame);
    int i = this.dxP.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((e)this.dxP.get(paramInt)).position = paramInt;
      paramInt += 1;
    }
    AppMethodBeat.o(208982);
  }
  
  public static boolean b(e parame)
  {
    AppMethodBeat.i(208963);
    boolean bool = dxO.release(parame);
    AppMethodBeat.o(208963);
    return bool;
  }
  
  private g c(e parame)
  {
    AppMethodBeat.i(208977);
    g localg1;
    g localg2;
    if (this.dyr != null)
    {
      localg1 = (g)this.dyr.acquire();
      localg2 = localg1;
      if (localg1 == null) {
        localg2 = new g(getContext());
      }
      localg2.l(parame);
      localg2.setFocusable(true);
      localg2.setMinimumWidth(getTabMinWidth());
      if (!TextUtils.isEmpty(parame.dyJ)) {
        break label94;
      }
      localg2.setContentDescription(parame.bba);
    }
    for (;;)
    {
      AppMethodBeat.o(208977);
      return localg2;
      localg1 = null;
      break;
      label94:
      localg2.setContentDescription(parame.dyJ);
    }
  }
  
  private void cF(View paramView)
  {
    AppMethodBeat.i(208991);
    if ((paramView instanceof TabItem))
    {
      a((TabItem)paramView);
      AppMethodBeat.o(208991);
      return;
    }
    paramView = new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    AppMethodBeat.o(208991);
    throw paramView;
  }
  
  private static ColorStateList cy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209070);
    ColorStateList localColorStateList = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
    AppMethodBeat.o(209070);
    return localColorStateList;
  }
  
  private void d(e parame)
  {
    AppMethodBeat.i(208986);
    g localg = parame.dyM;
    this.dxS.addView(localg, parame.position, Xb());
    AppMethodBeat.o(208986);
  }
  
  private void f(e parame)
  {
    AppMethodBeat.i(209030);
    int i = this.dyi.size() - 1;
    while (i >= 0)
    {
      ((b)this.dyi.get(i)).i(parame);
      i -= 1;
    }
    AppMethodBeat.o(209030);
  }
  
  private void g(e parame)
  {
    AppMethodBeat.i(209036);
    int i = this.dyi.size() - 1;
    while (i >= 0)
    {
      ((b)this.dyi.get(i)).j(parame);
      i -= 1;
    }
    AppMethodBeat.o(209036);
  }
  
  private int getDefaultHeight()
  {
    AppMethodBeat.i(209075);
    int j = this.dxP.size();
    int i = 0;
    if (i < j)
    {
      e locale = (e)this.dxP.get(i);
      if ((locale == null) || (locale.dqY == null) || (TextUtils.isEmpty(locale.bba))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (!this.dye))
      {
        AppMethodBeat.o(209075);
        return 72;
        i += 1;
        break;
      }
      AppMethodBeat.o(209075);
      return 48;
    }
  }
  
  private int getTabMinWidth()
  {
    if (this.dyb != -1) {
      return this.dyb;
    }
    if (this.mode == 0) {
      return this.dyd;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    AppMethodBeat.i(208967);
    int i = Math.max(0, this.dxS.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
    AppMethodBeat.o(208967);
    return i;
  }
  
  private void h(e parame)
  {
    AppMethodBeat.i(209047);
    int i = this.dyi.size() - 1;
    while (i >= 0)
    {
      ((b)this.dyi.get(i)).k(parame);
      i -= 1;
    }
    AppMethodBeat.o(209047);
  }
  
  private int j(int paramInt, float paramFloat)
  {
    int i = 0;
    AppMethodBeat.i(209057);
    if (this.mode == 0)
    {
      View localView2 = this.dxS.getChildAt(paramInt);
      View localView1;
      if (paramInt + 1 < this.dxS.getChildCount())
      {
        localView1 = this.dxS.getChildAt(paramInt + 1);
        if (localView2 == null) {
          break label126;
        }
      }
      int j;
      label126:
      for (paramInt = localView2.getWidth();; paramInt = 0)
      {
        if (localView1 != null) {
          i = localView1.getWidth();
        }
        j = localView2.getLeft() + paramInt / 2 - getWidth() / 2;
        paramInt = (int)((i + paramInt) * 0.5F * paramFloat);
        if (z.U(this) != 0) {
          break label131;
        }
        AppMethodBeat.o(209057);
        return paramInt + j;
        localView1 = null;
        break;
      }
      label131:
      AppMethodBeat.o(209057);
      return j - paramInt;
    }
    AppMethodBeat.o(209057);
    return 0;
  }
  
  private void jr(int paramInt)
  {
    AppMethodBeat.i(208950);
    a(paramInt, 0.0F, true, true);
    AppMethodBeat.o(208950);
  }
  
  private void jv(int paramInt)
  {
    AppMethodBeat.i(209010);
    if (paramInt == -1)
    {
      AppMethodBeat.o(209010);
      return;
    }
    if ((getWindowToken() != null) && (z.au(this)))
    {
      d locald = this.dxS;
      j = locald.getChildCount();
      i = 0;
      if (i >= j) {
        break label88;
      }
      if (locald.getChildAt(i).getWidth() > 0) {
        break label81;
      }
    }
    label81:
    label88:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label93;
      }
      jr(paramInt);
      AppMethodBeat.o(209010);
      return;
      i += 1;
      break;
    }
    label93:
    i = getScrollX();
    int j = j(paramInt, 0.0F);
    if (i != j)
    {
      Xc();
      this.dyk.setIntValues(new int[] { i, j });
      this.dyk.start();
    }
    this.dxS.cA(paramInt, this.tabIndicatorAnimationDuration);
    AppMethodBeat.o(209010);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    AppMethodBeat.i(209024);
    int j = this.dxS.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.dxS.getChildAt(i);
        if (i == paramInt)
        {
          bool = true;
          label44:
          localView.setSelected(bool);
          if (i != paramInt) {
            break label79;
          }
        }
        label79:
        for (boolean bool = true;; bool = false)
        {
          localView.setActivated(bool);
          i += 1;
          break;
          bool = false;
          break label44;
        }
      }
    }
    AppMethodBeat.o(209024);
  }
  
  public final e WW()
  {
    AppMethodBeat.i(209181);
    e locale = WX();
    locale.dyL = this;
    locale.dyM = c(locale);
    AppMethodBeat.o(209181);
    return locale;
  }
  
  public final void WY()
  {
    AppMethodBeat.i(209212);
    int i = this.dxS.getChildCount() - 1;
    while (i >= 0)
    {
      ju(i);
      i -= 1;
    }
    Iterator localIterator = this.dxP.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      localIterator.remove();
      locale.reset();
      b(locale);
    }
    this.dxQ = null;
    AppMethodBeat.o(209212);
  }
  
  final void WZ()
  {
    AppMethodBeat.i(209429);
    WY();
    if (this.dym != null)
    {
      int j = this.dym.getCount();
      int i = 0;
      while (i < j)
      {
        a(WW().D(this.dym.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.dyl != null) && (j > 0))
      {
        i = this.dyl.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          b(js(i), true);
        }
      }
    }
    AppMethodBeat.o(209429);
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209116);
    int i = Math.round(paramInt + paramFloat);
    if ((i < 0) || (i >= this.dxS.getChildCount()))
    {
      AppMethodBeat.o(209116);
      return;
    }
    if (paramBoolean2) {
      this.dxS.k(paramInt, paramFloat);
    }
    if ((this.dyk != null) && (this.dyk.isRunning())) {
      this.dyk.cancel();
    }
    scrollTo(j(paramInt, paramFloat), 0);
    if (paramBoolean1) {
      setSelectedTabView(i);
    }
    AppMethodBeat.o(209116);
  }
  
  public final void a(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209384);
    if (this.dyl != null)
    {
      if (this.dyo != null) {
        this.dyl.removeOnPageChangeListener(this.dyo);
      }
      if (this.dyp != null) {
        this.dyl.removeOnAdapterChangeListener(this.dyp);
      }
    }
    if (this.dyj != null)
    {
      b(this.dyj);
      this.dyj = null;
    }
    if (paramViewPager != null)
    {
      this.dyl = paramViewPager;
      if (this.dyo == null) {
        this.dyo = new TabLayout.f(this);
      }
      this.dyo.reset();
      paramViewPager.addOnPageChangeListener(this.dyo);
      this.dyj = new TabLayout.h(paramViewPager);
      a(this.dyj);
      androidx.viewpager.widget.a locala = paramViewPager.getAdapter();
      if (locala != null) {
        a(locala, paramBoolean1);
      }
      if (this.dyp == null) {
        this.dyp = new a();
      }
      this.dyp.dyt = paramBoolean1;
      paramViewPager.addOnAdapterChangeListener(this.dyp);
      jr(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.dyq = paramBoolean2;
      AppMethodBeat.o(209384);
      return;
      this.dyl = null;
      a(null, false);
    }
  }
  
  final void a(androidx.viewpager.widget.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(209422);
    if ((this.dym != null) && (this.dyn != null)) {
      this.dym.unregisterDataSetObserver(this.dyn);
    }
    this.dym = parama;
    if ((paramBoolean) && (parama != null))
    {
      if (this.dyn == null) {
        this.dyn = new c();
      }
      parama.registerDataSetObserver(this.dyn);
    }
    WZ();
    AppMethodBeat.o(209422);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(209164);
    if (!this.dyi.contains(paramb)) {
      this.dyi.add(paramb);
    }
    AppMethodBeat.o(209164);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(209125);
    a(parame, this.dxP.isEmpty());
    AppMethodBeat.o(209125);
  }
  
  public final void a(e parame, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209145);
    if (parame.dyL != this)
    {
      parame = new IllegalArgumentException("Tab belongs to a different TabLayout.");
      AppMethodBeat.o(209145);
      throw parame;
    }
    a(parame, paramInt);
    d(parame);
    if (paramBoolean) {
      parame.Xf();
    }
    AppMethodBeat.o(209145);
  }
  
  public final void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(209134);
    a(parame, this.dxP.size(), paramBoolean);
    AppMethodBeat.o(209134);
  }
  
  public void addView(View paramView)
  {
    AppMethodBeat.i(209435);
    cF(paramView);
    AppMethodBeat.o(209435);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(209443);
    cF(paramView);
    AppMethodBeat.o(209443);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209455);
    cF(paramView);
    AppMethodBeat.o(209455);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209447);
    cF(paramView);
    AppMethodBeat.o(209447);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(209174);
    this.dyi.remove(paramb);
    AppMethodBeat.o(209174);
  }
  
  public final void b(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(209511);
    e locale = this.dxQ;
    int i;
    if (locale == parame)
    {
      if (locale != null)
      {
        h(parame);
        jv(parame.position);
        AppMethodBeat.o(209511);
      }
    }
    else
    {
      if (parame == null) {
        break label122;
      }
      i = parame.position;
      if (paramBoolean)
      {
        if (((locale != null) && (locale.position != -1)) || (i == -1)) {
          break label127;
        }
        jr(i);
      }
    }
    for (;;)
    {
      if (i != -1) {
        setSelectedTabView(i);
      }
      this.dxQ = parame;
      if (locale != null) {
        g(locale);
      }
      if (parame != null) {
        f(parame);
      }
      AppMethodBeat.o(209511);
      return;
      label122:
      i = -1;
      break;
      label127:
      jv(i);
    }
  }
  
  final void bP(boolean paramBoolean)
  {
    AppMethodBeat.i(209518);
    int i = 0;
    while (i < this.dxS.getChildCount())
    {
      View localView = this.dxS.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
    AppMethodBeat.o(209518);
  }
  
  public final void cx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209307);
    setTabTextColors(cy(paramInt1, paramInt2));
    AppMethodBeat.o(209307);
  }
  
  final void e(e parame)
  {
    AppMethodBeat.i(369523);
    b(parame, true);
    AppMethodBeat.o(369523);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(209527);
    paramAttributeSet = generateDefaultLayoutParams();
    AppMethodBeat.o(209527);
    return paramAttributeSet;
  }
  
  public int getSelectedTabPosition()
  {
    if (this.dxQ != null) {
      return this.dxQ.position;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    AppMethodBeat.i(209189);
    int i = this.dxP.size();
    AppMethodBeat.o(209189);
    return i;
  }
  
  public int getTabGravity()
  {
    return this.tabGravity;
  }
  
  public ColorStateList getTabIconTint()
  {
    return this.dxU;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.tabIndicatorGravity;
  }
  
  int getTabMaxWidth()
  {
    return this.tabMaxWidth;
  }
  
  public int getTabMode()
  {
    return this.mode;
  }
  
  public ColorStateList getTabRippleColor()
  {
    return this.dxV;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return this.dxW;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.dxT;
  }
  
  public final e js(int paramInt)
  {
    AppMethodBeat.i(209194);
    if ((paramInt < 0) || (paramInt >= getTabCount()))
    {
      AppMethodBeat.o(209194);
      return null;
    }
    e locale = (e)this.dxP.get(paramInt);
    AppMethodBeat.o(209194);
    return locale;
  }
  
  final int jt(int paramInt)
  {
    AppMethodBeat.i(209462);
    paramInt = Math.round(getResources().getDisplayMetrics().density * paramInt);
    AppMethodBeat.o(209462);
    return paramInt;
  }
  
  public final void ju(int paramInt)
  {
    AppMethodBeat.i(209489);
    g localg = (g)this.dxS.getChildAt(paramInt);
    this.dxS.removeViewAt(paramInt);
    if (localg != null)
    {
      localg.reset();
      this.dyr.release(localg);
    }
    requestLayout();
    AppMethodBeat.o(209489);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(209407);
    super.onAttachedToWindow();
    if (this.dyl == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        a((ViewPager)localViewParent, true, true);
      }
    }
    AppMethodBeat.o(209407);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(209417);
    super.onDetachedFromWindow();
    if (this.dyq)
    {
      setupWithViewPager(null);
      this.dyq = false;
    }
    AppMethodBeat.o(209417);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209469);
    int i = 0;
    while (i < this.dxS.getChildCount())
    {
      View localView = this.dxS.getChildAt(i);
      if ((localView instanceof g)) {
        g.a((g)localView, paramCanvas);
      }
      i += 1;
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(209469);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(209481);
    int i = jt(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    label84:
    View localView;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.dyc > 0)
        {
          i = this.dyc;
          this.tabMaxWidth = i;
        }
      }
      else
      {
        super.onMeasure(paramInt1, paramInt2);
        if (getChildCount() == 1)
        {
          localView = getChildAt(0);
          switch (this.mode)
          {
          default: 
            paramInt1 = 0;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
      AppMethodBeat.o(209481);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
      break;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      break;
      i -= jt(56);
      break label84;
      if (localView.getMeasuredWidth() < getMeasuredWidth()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    if (localView.getMeasuredWidth() != getMeasuredWidth()) {}
    for (paramInt1 = j;; paramInt1 = 0) {
      break;
    }
  }
  
  public void setInlineLabel(boolean paramBoolean)
  {
    AppMethodBeat.i(209264);
    if (this.dye != paramBoolean)
    {
      this.dye = paramBoolean;
      int i = 0;
      if (i < this.dxS.getChildCount())
      {
        Object localObject = this.dxS.getChildAt(i);
        int j;
        if ((localObject instanceof g))
        {
          localObject = (g)localObject;
          if (!((g)localObject).dys.dye) {
            break label114;
          }
          j = 0;
          label70:
          ((g)localObject).setOrientation(j);
          if ((((g)localObject).dyT == null) && (((g)localObject).dyU == null)) {
            break label119;
          }
          ((g)localObject).a(((g)localObject).dyT, ((g)localObject).dyU);
        }
        for (;;)
        {
          i += 1;
          break;
          label114:
          j = 1;
          break label70;
          label119:
          ((g)localObject).a(((g)localObject).dyR, ((g)localObject).dyS);
        }
      }
      Xd();
    }
    AppMethodBeat.o(209264);
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    AppMethodBeat.i(209270);
    setInlineLabel(getResources().getBoolean(paramInt));
    AppMethodBeat.o(209270);
  }
  
  @Deprecated
  public void setOnTabSelectedListener(b paramb)
  {
    AppMethodBeat.i(209155);
    if (this.dyh != null) {
      b(this.dyh);
    }
    this.dyh = paramb;
    if (paramb != null) {
      a(paramb);
    }
    AppMethodBeat.o(209155);
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(209494);
    Xc();
    this.dyk.addListener(paramAnimatorListener);
    AppMethodBeat.o(209494);
  }
  
  public void setSelectedTabIndicator(int paramInt)
  {
    AppMethodBeat.i(209365);
    if (paramInt != 0)
    {
      setSelectedTabIndicator(androidx.appcompat.a.a.a.m(getContext(), paramInt));
      AppMethodBeat.o(209365);
      return;
    }
    setSelectedTabIndicator(null);
    AppMethodBeat.o(209365);
  }
  
  public void setSelectedTabIndicator(Drawable paramDrawable)
  {
    AppMethodBeat.i(209358);
    if (this.dxW != paramDrawable)
    {
      this.dxW = paramDrawable;
      z.Q(this.dxS);
    }
    AppMethodBeat.o(209358);
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    AppMethodBeat.i(209100);
    this.dxS.setSelectedIndicatorColor(paramInt);
    AppMethodBeat.o(209100);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    AppMethodBeat.i(209248);
    if (this.tabIndicatorGravity != paramInt)
    {
      this.tabIndicatorGravity = paramInt;
      z.Q(this.dxS);
    }
    AppMethodBeat.o(209248);
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    AppMethodBeat.i(209108);
    this.dxS.setSelectedIndicatorHeight(paramInt);
    AppMethodBeat.o(209108);
  }
  
  public void setTabGravity(int paramInt)
  {
    AppMethodBeat.i(209235);
    if (this.tabGravity != paramInt)
    {
      this.tabGravity = paramInt;
      Xd();
    }
    AppMethodBeat.o(209235);
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209313);
    if (this.dxU != paramColorStateList)
    {
      this.dxU = paramColorStateList;
      Xa();
    }
    AppMethodBeat.o(209313);
  }
  
  public void setTabIconTintResource(int paramInt)
  {
    AppMethodBeat.i(209319);
    setTabIconTint(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    AppMethodBeat.o(209319);
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    AppMethodBeat.i(209260);
    this.dyf = paramBoolean;
    z.Q(this.dxS);
    AppMethodBeat.o(209260);
  }
  
  public void setTabMode(int paramInt)
  {
    AppMethodBeat.i(209223);
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      Xd();
    }
    AppMethodBeat.o(209223);
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209338);
    if (this.dxV != paramColorStateList)
    {
      this.dxV = paramColorStateList;
      int i = 0;
      while (i < this.dxS.getChildCount())
      {
        paramColorStateList = this.dxS.getChildAt(i);
        if ((paramColorStateList instanceof g)) {
          g.a((g)paramColorStateList, getContext());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(209338);
  }
  
  public void setTabRippleColorResource(int paramInt)
  {
    AppMethodBeat.i(209346);
    setTabRippleColor(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    AppMethodBeat.o(209346);
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209293);
    if (this.dxT != paramColorStateList)
    {
      this.dxT = paramColorStateList;
      Xa();
    }
    AppMethodBeat.o(209293);
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(androidx.viewpager.widget.a parama)
  {
    AppMethodBeat.i(209393);
    a(parama, false);
    AppMethodBeat.o(209393);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    AppMethodBeat.i(209279);
    if (this.dyg != paramBoolean)
    {
      this.dyg = paramBoolean;
      int i = 0;
      while (i < this.dxS.getChildCount())
      {
        View localView = this.dxS.getChildAt(i);
        if ((localView instanceof g)) {
          g.a((g)localView, getContext());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(209279);
  }
  
  public void setUnboundedRippleResource(int paramInt)
  {
    AppMethodBeat.i(209286);
    setUnboundedRipple(getResources().getBoolean(paramInt));
    AppMethodBeat.o(209286);
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    AppMethodBeat.i(209377);
    a(paramViewPager, true, false);
    AppMethodBeat.o(209377);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    AppMethodBeat.i(209403);
    if (getTabScrollRange() > 0)
    {
      AppMethodBeat.o(209403);
      return true;
    }
    AppMethodBeat.o(209403);
    return false;
  }
  
  final class a
    implements ViewPager.c
  {
    boolean dyt;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, androidx.viewpager.widget.a parama1, androidx.viewpager.widget.a parama2)
    {
      AppMethodBeat.i(208941);
      if (TabLayout.this.dyl == paramViewPager) {
        TabLayout.this.a(parama2, this.dyt);
      }
      AppMethodBeat.o(208941);
    }
  }
  
  public static abstract interface b<T extends TabLayout.e>
  {
    public abstract void i(T paramT);
    
    public abstract void j(T paramT);
    
    public abstract void k(T paramT);
  }
  
  final class c
    extends DataSetObserver
  {
    c() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(208953);
      TabLayout.this.WZ();
      AppMethodBeat.o(208953);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(208958);
      TabLayout.this.WZ();
      AppMethodBeat.o(208958);
    }
  }
  
  final class d
    extends LinearLayout
  {
    private int dyA;
    private int dyB;
    private ValueAnimator dyC;
    private int dyu;
    private final Paint dyv;
    private final GradientDrawable dyw;
    int dyx;
    float dyy;
    private int dyz;
    
    d(Context paramContext)
    {
      super();
      AppMethodBeat.i(208965);
      this.dyx = -1;
      this.dyz = -1;
      this.dyA = -1;
      this.dyB = -1;
      setWillNotDraw(false);
      this.dyv = new Paint();
      this.dyw = new GradientDrawable();
      AppMethodBeat.o(208965);
    }
    
    private void Xe()
    {
      AppMethodBeat.i(208972);
      View localView = getChildAt(this.dyx);
      int k;
      int m;
      int i;
      int j;
      if ((localView != null) && (localView.getWidth() > 0))
      {
        k = localView.getLeft();
        m = localView.getRight();
        i = m;
        j = k;
        if (!TabLayout.this.dyf)
        {
          i = m;
          j = k;
          if ((localView instanceof TabLayout.g))
          {
            a((TabLayout.g)localView, TabLayout.a(TabLayout.this));
            j = (int)TabLayout.a(TabLayout.this).left;
            i = (int)TabLayout.a(TabLayout.this).right;
          }
        }
        k = i;
        m = j;
        if (this.dyy > 0.0F)
        {
          k = i;
          m = j;
          if (this.dyx < getChildCount() - 1)
          {
            localView = getChildAt(this.dyx + 1);
            m = localView.getLeft();
            k = localView.getRight();
            if ((TabLayout.this.dyf) || (!(localView instanceof TabLayout.g))) {
              break label321;
            }
            a((TabLayout.g)localView, TabLayout.a(TabLayout.this));
            m = (int)TabLayout.a(TabLayout.this).left;
            k = (int)TabLayout.a(TabLayout.this).right;
          }
        }
      }
      label321:
      for (;;)
      {
        float f1 = this.dyy;
        float f2 = m;
        float f3 = this.dyy;
        m = (int)(j * (1.0F - f3) + f1 * f2);
        f1 = this.dyy;
        f2 = k;
        f3 = this.dyy;
        k = (int)(f2 * f1 + i * (1.0F - f3));
        for (;;)
        {
          cz(m, k);
          AppMethodBeat.o(208972);
          return;
          k = -1;
          m = -1;
        }
      }
    }
    
    private void a(TabLayout.g paramg, RectF paramRectF)
    {
      AppMethodBeat.i(208980);
      int j = paramg.getContentWidth();
      int i = j;
      if (j < TabLayout.this.jt(24)) {
        i = TabLayout.this.jt(24);
      }
      j = (paramg.getLeft() + paramg.getRight()) / 2;
      int k = i / 2;
      i /= 2;
      paramRectF.set(j - k, 0.0F, i + j, 0.0F);
      AppMethodBeat.o(208980);
    }
    
    final void cA(final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209066);
      if ((this.dyC != null) && (this.dyC.isRunning())) {
        this.dyC.cancel();
      }
      Object localObject = getChildAt(paramInt1);
      if (localObject == null)
      {
        Xe();
        AppMethodBeat.o(209066);
        return;
      }
      final int k = ((View)localObject).getLeft();
      final int m = ((View)localObject).getRight();
      final int j = k;
      final int i = m;
      if (!TabLayout.this.dyf)
      {
        j = k;
        i = m;
        if ((localObject instanceof TabLayout.g))
        {
          a((TabLayout.g)localObject, TabLayout.a(TabLayout.this));
          j = (int)TabLayout.a(TabLayout.this).left;
          i = (int)TabLayout.a(TabLayout.this).right;
        }
      }
      k = this.dyA;
      m = this.dyB;
      if ((k != j) || (m != i))
      {
        localObject = new ValueAnimator();
        this.dyC = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).setInterpolator(com.google.android.material.a.a.dnr);
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(208932);
            float f = paramAnonymousValueAnimator.getAnimatedFraction();
            TabLayout.d.this.cz(com.google.android.material.a.a.d(k, j, f), com.google.android.material.a.a.d(m, i, f));
            AppMethodBeat.o(208932);
          }
        });
        ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            TabLayout.d.this.dyx = paramInt1;
            TabLayout.d.this.dyy = 0.0F;
          }
        });
        ((ValueAnimator)localObject).start();
      }
      AppMethodBeat.o(209066);
    }
    
    final void cz(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209053);
      if ((paramInt1 != this.dyA) || (paramInt2 != this.dyB))
      {
        this.dyA = paramInt1;
        this.dyB = paramInt2;
        z.Q(this);
      }
      AppMethodBeat.o(209053);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(209083);
      if (TabLayout.this.dxW != null) {}
      for (int i = TabLayout.this.dxW.getIntrinsicHeight();; i = 0)
      {
        if (this.dyu >= 0) {
          i = this.dyu;
        }
        int j;
        Object localObject;
        switch (TabLayout.this.tabIndicatorGravity)
        {
        default: 
          i = 0;
          j = 0;
          if ((this.dyA >= 0) && (this.dyB > this.dyA))
          {
            if (TabLayout.this.dxW == null) {
              break label247;
            }
            localObject = TabLayout.this.dxW;
            label117:
            localObject = androidx.core.graphics.drawable.a.s((Drawable)localObject);
            ((Drawable)localObject).setBounds(this.dyA, j, this.dyB, i);
            if (this.dyv != null)
            {
              if (Build.VERSION.SDK_INT != 21) {
                break label256;
              }
              ((Drawable)localObject).setColorFilter(this.dyv.getColor(), PorterDuff.Mode.SRC_IN);
            }
          }
          break;
        }
        for (;;)
        {
          ((Drawable)localObject).draw(paramCanvas);
          super.draw(paramCanvas);
          AppMethodBeat.o(209083);
          return;
          int k = getHeight();
          j = getHeight();
          k -= i;
          i = j;
          j = k;
          break;
          j = (getHeight() - i) / 2;
          i = (i + getHeight()) / 2;
          break;
          j = 0;
          break;
          i = getHeight();
          j = 0;
          break;
          label247:
          localObject = this.dyw;
          break label117;
          label256:
          androidx.core.graphics.drawable.a.a((Drawable)localObject, this.dyv.getColor());
        }
      }
    }
    
    final void k(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(209005);
      if ((this.dyC != null) && (this.dyC.isRunning())) {
        this.dyC.cancel();
      }
      this.dyx = paramInt;
      this.dyy = paramFloat;
      Xe();
      AppMethodBeat.o(209005);
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(209041);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.dyC != null) && (this.dyC.isRunning()))
      {
        this.dyC.cancel();
        long l = this.dyC.getDuration();
        paramInt1 = this.dyx;
        float f = this.dyC.getAnimatedFraction();
        cA(paramInt1, Math.round((float)l * (1.0F - f)));
        AppMethodBeat.o(209041);
        return;
      }
      Xe();
      AppMethodBeat.o(209041);
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209026);
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
      {
        AppMethodBeat.o(209026);
        return;
      }
      int n;
      int k;
      int j;
      Object localObject;
      if ((TabLayout.this.mode == 1) && (TabLayout.this.tabGravity == 1))
      {
        n = getChildCount();
        k = 0;
        j = 0;
        if (k < n)
        {
          localObject = getChildAt(k);
          if (((View)localObject).getVisibility() != 0) {
            break label260;
          }
        }
      }
      label257:
      label260:
      for (int i = Math.max(j, ((View)localObject).getMeasuredWidth());; i = j)
      {
        k += 1;
        j = i;
        break;
        if (j <= 0)
        {
          AppMethodBeat.o(209026);
          return;
        }
        i = TabLayout.this.jt(16);
        int m;
        if (j * n <= getMeasuredWidth() - i * 2)
        {
          i = 0;
          k = 0;
          m = i;
          if (k >= n) {
            break label239;
          }
          localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width == j) && (((LinearLayout.LayoutParams)localObject).weight == 0.0F)) {
            break label257;
          }
          ((LinearLayout.LayoutParams)localObject).width = j;
          ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
          i = 1;
        }
        for (;;)
        {
          k += 1;
          break;
          TabLayout.this.tabGravity = 0;
          TabLayout.this.bP(false);
          m = 1;
          label239:
          if (m != 0) {
            super.onMeasure(paramInt1, paramInt2);
          }
          AppMethodBeat.o(209026);
          return;
        }
      }
    }
    
    public final void onRtlPropertiesChanged(int paramInt)
    {
      AppMethodBeat.i(209012);
      super.onRtlPropertiesChanged(paramInt);
      if ((Build.VERSION.SDK_INT < 23) && (this.dyz != paramInt))
      {
        requestLayout();
        this.dyz = paramInt;
      }
      AppMethodBeat.o(209012);
    }
    
    final void setSelectedIndicatorColor(int paramInt)
    {
      AppMethodBeat.i(208984);
      if (this.dyv.getColor() != paramInt)
      {
        this.dyv.setColor(paramInt);
        z.Q(this);
      }
      AppMethodBeat.o(208984);
    }
    
    final void setSelectedIndicatorHeight(int paramInt)
    {
      AppMethodBeat.i(208992);
      if (this.dyu != paramInt)
      {
        this.dyu = paramInt;
        z.Q(this);
      }
      AppMethodBeat.o(208992);
    }
  }
  
  public static final class e
  {
    public CharSequence bba;
    Drawable dqY;
    CharSequence dyJ;
    public View dyK;
    public TabLayout dyL;
    public TabLayout.g dyM;
    public int position = -1;
    public Object tag;
    
    public final e D(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(208948);
      if ((TextUtils.isEmpty(this.dyJ)) && (!TextUtils.isEmpty(paramCharSequence))) {
        this.dyM.setContentDescription(paramCharSequence);
      }
      this.bba = paramCharSequence;
      updateView();
      AppMethodBeat.o(208948);
      return this;
    }
    
    public final e E(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(208966);
      this.dyJ = paramCharSequence;
      updateView();
      AppMethodBeat.o(208966);
      return this;
    }
    
    public final void Xf()
    {
      AppMethodBeat.i(208954);
      if (this.dyL == null)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
        AppMethodBeat.o(208954);
        throw localIllegalArgumentException;
      }
      this.dyL.e(this);
      AppMethodBeat.o(208954);
    }
    
    public final e cG(View paramView)
    {
      AppMethodBeat.i(208938);
      this.dyK = paramView;
      updateView();
      AppMethodBeat.o(208938);
      return this;
    }
    
    public final boolean isSelected()
    {
      AppMethodBeat.i(208962);
      if (this.dyL == null)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
        AppMethodBeat.o(208962);
        throw localIllegalArgumentException;
      }
      if (this.dyL.getSelectedTabPosition() == this.position)
      {
        AppMethodBeat.o(208962);
        return true;
      }
      AppMethodBeat.o(208962);
      return false;
    }
    
    public final e jw(int paramInt)
    {
      AppMethodBeat.i(208943);
      e locale = cG(LayoutInflater.from(this.dyM.getContext()).inflate(paramInt, this.dyM, false));
      AppMethodBeat.o(208943);
      return locale;
    }
    
    public final void reset()
    {
      this.dyL = null;
      this.dyM = null;
      this.tag = null;
      this.dqY = null;
      this.bba = null;
      this.dyJ = null;
      this.position = -1;
      this.dyK = null;
    }
    
    final void updateView()
    {
      AppMethodBeat.i(208970);
      if (this.dyM != null) {
        this.dyM.update();
      }
      AppMethodBeat.o(208970);
    }
  }
  
  final class g
    extends LinearLayout
  {
    private View dyK;
    private TabLayout.e dyQ;
    TextView dyR;
    ImageView dyS;
    TextView dyT;
    ImageView dyU;
    private Drawable dyV;
    private int dyW;
    
    public g(Context paramContext)
    {
      super();
      AppMethodBeat.i(208939);
      this.dyW = 2;
      aR(paramContext);
      z.g(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
      setGravity(17);
      if (TabLayout.this.dye) {}
      for (int i = 0;; i = 1)
      {
        setOrientation(i);
        setClickable(true);
        z.a(this, v.aj(getContext()));
        AppMethodBeat.o(208939);
        return;
      }
    }
    
    private void aR(Context paramContext)
    {
      Object localObject = null;
      AppMethodBeat.i(208944);
      GradientDrawable localGradientDrawable;
      ColorStateList localColorStateList;
      if (TabLayout.this.dya != 0)
      {
        this.dyV = androidx.appcompat.a.a.a.m(paramContext, TabLayout.this.dya);
        if ((this.dyV != null) && (this.dyV.isStateful())) {
          this.dyV.setState(getDrawableState());
        }
        localGradientDrawable = new GradientDrawable();
        ((GradientDrawable)localGradientDrawable).setColor(0);
        paramContext = localGradientDrawable;
        if (TabLayout.this.dxV != null)
        {
          paramContext = new GradientDrawable();
          paramContext.setCornerRadius(1.0E-005F);
          paramContext.setColor(-1);
          localColorStateList = com.google.android.material.f.a.g(TabLayout.this.dxV);
          if (Build.VERSION.SDK_INT < 21) {
            break label193;
          }
          if (TabLayout.this.dyg) {
            localGradientDrawable = null;
          }
          if (!TabLayout.this.dyg) {
            break label190;
          }
          paramContext = localObject;
        }
      }
      label152:
      for (paramContext = new RippleDrawable(localColorStateList, localGradientDrawable, paramContext);; paramContext = new LayerDrawable(new Drawable[] { localGradientDrawable, paramContext }))
      {
        z.a(this, paramContext);
        TabLayout.this.invalidate();
        AppMethodBeat.o(208944);
        return;
        this.dyV = null;
        break;
        label190:
        break label152;
        label193:
        paramContext = androidx.core.graphics.drawable.a.s(paramContext);
        androidx.core.graphics.drawable.a.a(paramContext, localColorStateList);
      }
    }
    
    final void a(TextView paramTextView, ImageView paramImageView)
    {
      Object localObject = null;
      AppMethodBeat.i(209007);
      Drawable localDrawable;
      CharSequence localCharSequence;
      label56:
      label81:
      int i;
      if ((this.dyQ != null) && (this.dyQ.dqY != null))
      {
        localDrawable = androidx.core.graphics.drawable.a.s(this.dyQ.dqY).mutate();
        if (this.dyQ == null) {
          break label227;
        }
        localCharSequence = this.dyQ.bba;
        if (paramImageView != null)
        {
          if (localDrawable == null) {
            break label233;
          }
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
        }
        if (TextUtils.isEmpty(localCharSequence)) {
          break label247;
        }
        i = 1;
        label91:
        if (paramTextView != null)
        {
          if (i == 0) {
            break label252;
          }
          paramTextView.setText(localCharSequence);
          paramTextView.setVisibility(0);
          setVisibility(0);
        }
        label115:
        if (paramImageView != null)
        {
          paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
          if ((i == 0) || (paramImageView.getVisibility() != 0)) {
            break label306;
          }
        }
      }
      label298:
      label303:
      label306:
      for (int j = TabLayout.this.jt(8);; j = 0)
      {
        if (TabLayout.this.dye)
        {
          if (j != h.b(paramTextView))
          {
            h.a(paramTextView, j);
            paramTextView.bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
          label188:
          if (this.dyQ == null) {
            break label298;
          }
          paramTextView = this.dyQ.dyJ;
          label203:
          if (i == 0) {
            break label303;
          }
          paramTextView = localObject;
        }
        for (;;)
        {
          ae.a(this, paramTextView);
          AppMethodBeat.o(209007);
          return;
          localDrawable = null;
          break;
          label227:
          localCharSequence = null;
          break label56;
          label233:
          paramImageView.setVisibility(8);
          paramImageView.setImageDrawable(null);
          break label81;
          label247:
          i = 0;
          break label91;
          label252:
          paramTextView.setVisibility(8);
          paramTextView.setText(null);
          break label115;
          if (j == paramTextView.bottomMargin) {
            break label188;
          }
          paramTextView.bottomMargin = j;
          h.a(paramTextView, 0);
          paramImageView.setLayoutParams(paramTextView);
          paramImageView.requestLayout();
          break label188;
          paramTextView = null;
          break label203;
        }
      }
    }
    
    protected final void drawableStateChanged()
    {
      AppMethodBeat.i(208957);
      super.drawableStateChanged();
      boolean bool2 = false;
      int[] arrayOfInt = getDrawableState();
      boolean bool1 = bool2;
      if (this.dyV != null)
      {
        bool1 = bool2;
        if (this.dyV.isStateful()) {
          bool1 = this.dyV.setState(arrayOfInt) | false;
        }
      }
      if (bool1)
      {
        invalidate();
        TabLayout.this.invalidate();
      }
      AppMethodBeat.o(208957);
    }
    
    final int getContentWidth()
    {
      AppMethodBeat.i(209011);
      TextView localTextView = this.dyR;
      ImageView localImageView = this.dyS;
      View localView1 = this.dyK;
      int k = 0;
      int m = 0;
      int i = 0;
      int j = 0;
      if (k < 3)
      {
        View localView2 = new View[] { localTextView, localImageView, localView1 }[k];
        int i2 = m;
        int i1 = i;
        int n = j;
        if (localView2 != null)
        {
          i2 = m;
          i1 = i;
          n = j;
          if (localView2.getVisibility() == 0)
          {
            if (j == 0) {
              break label149;
            }
            i = Math.min(i, localView2.getLeft());
            label108:
            if (j == 0) {
              break label158;
            }
          }
        }
        label149:
        label158:
        for (j = Math.max(m, localView2.getRight());; j = localView2.getRight())
        {
          n = 1;
          i1 = i;
          i2 = j;
          k += 1;
          m = i2;
          i = i1;
          j = n;
          break;
          i = localView2.getLeft();
          break label108;
        }
      }
      AppMethodBeat.o(209011);
      return m - i;
    }
    
    final void l(TabLayout.e parame)
    {
      AppMethodBeat.i(208983);
      if (parame != this.dyQ)
      {
        this.dyQ = parame;
        update();
      }
      AppMethodBeat.o(208983);
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(208968);
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(208968);
    }
    
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(208973);
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(208973);
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      int k = 1;
      AppMethodBeat.i(208979);
      int j = View.MeasureSpec.getSize(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt1);
      int n = TabLayout.this.getTabMaxWidth();
      int i = paramInt1;
      if (n > 0) {
        if (m != 0)
        {
          i = paramInt1;
          if (j <= n) {}
        }
        else
        {
          i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, -2147483648);
        }
      }
      super.onMeasure(i, paramInt2);
      float f2;
      float f1;
      if (this.dyR != null)
      {
        f2 = TabLayout.this.dxY;
        j = this.dyW;
        if ((this.dyS == null) || (this.dyS.getVisibility() != 0)) {
          break label297;
        }
        paramInt1 = 1;
        f1 = f2;
      }
      for (;;)
      {
        f2 = this.dyR.getTextSize();
        m = this.dyR.getLineCount();
        j = j.a(this.dyR);
        if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
        {
          j = k;
          if (TabLayout.this.mode == 1)
          {
            j = k;
            if (f1 > f2)
            {
              j = k;
              if (m == 1)
              {
                Layout localLayout = this.dyR.getLayout();
                if (localLayout != null)
                {
                  f2 = localLayout.getLineWidth(0);
                  j = k;
                  if (f1 / localLayout.getPaint().getTextSize() * f2 <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
                }
                else
                {
                  j = 0;
                }
              }
            }
          }
          if (j != 0)
          {
            this.dyR.setTextSize(0, f1);
            this.dyR.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
        AppMethodBeat.o(208979);
        return;
        label297:
        paramInt1 = j;
        f1 = f2;
        if (this.dyR != null)
        {
          paramInt1 = j;
          f1 = f2;
          if (this.dyR.getLineCount() > 1)
          {
            f1 = TabLayout.this.dxZ;
            paramInt1 = j;
          }
        }
      }
    }
    
    public final boolean performClick()
    {
      AppMethodBeat.i(208961);
      boolean bool = super.performClick();
      if (this.dyQ != null)
      {
        if (!bool) {
          playSoundEffect(0);
        }
        this.dyQ.Xf();
        AppMethodBeat.o(208961);
        return true;
      }
      AppMethodBeat.o(208961);
      return bool;
    }
    
    final void reset()
    {
      AppMethodBeat.i(208987);
      l(null);
      setSelected(false);
      AppMethodBeat.o(208987);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(208964);
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
          sendAccessibilityEvent(4);
        }
        if (this.dyR != null) {
          this.dyR.setSelected(paramBoolean);
        }
        if (this.dyS != null) {
          this.dyS.setSelected(paramBoolean);
        }
        if (this.dyK != null) {
          this.dyK.setSelected(paramBoolean);
        }
        AppMethodBeat.o(208964);
        return;
      }
    }
    
    final void update()
    {
      AppMethodBeat.i(208999);
      TabLayout.e locale = this.dyQ;
      Object localObject;
      if (locale != null)
      {
        localObject = locale.dyK;
        if (localObject == null) {
          break label397;
        }
        ViewParent localViewParent = ((View)localObject).getParent();
        if (localViewParent != this)
        {
          if (localViewParent != null) {
            ((ViewGroup)localViewParent).removeView((View)localObject);
          }
          addView((View)localObject);
        }
        this.dyK = ((View)localObject);
        if (this.dyR != null) {
          this.dyR.setVisibility(8);
        }
        if (this.dyS != null)
        {
          this.dyS.setVisibility(8);
          this.dyS.setImageDrawable(null);
        }
        this.dyT = ((TextView)((View)localObject).findViewById(16908308));
        if (this.dyT != null) {
          this.dyW = j.a(this.dyT);
        }
        this.dyU = ((ImageView)((View)localObject).findViewById(16908294));
        label146:
        if (this.dyK != null) {
          break label435;
        }
        if (this.dyS == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_icon, this, false);
          addView((View)localObject, 0);
          this.dyS = ((ImageView)localObject);
        }
        if ((locale == null) || (locale.dqY == null)) {
          break label430;
        }
        localObject = androidx.core.graphics.drawable.a.s(locale.dqY).mutate();
        label212:
        if (localObject != null)
        {
          androidx.core.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.dxU);
          if (TabLayout.this.dxX != null) {
            androidx.core.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.dxX);
          }
        }
        if (this.dyR == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_text, this, false);
          addView((View)localObject);
          this.dyR = ((TextView)localObject);
          this.dyW = j.a(this.dyR);
        }
        j.a(this.dyR, TabLayout.this.tabTextAppearance);
        if (TabLayout.this.dxT != null) {
          this.dyR.setTextColor(TabLayout.this.dxT);
        }
        a(this.dyR, this.dyS);
        label345:
        if ((locale != null) && (!TextUtils.isEmpty(locale.dyJ))) {
          setContentDescription(locale.dyJ);
        }
        if ((locale == null) || (!locale.isSelected())) {
          break label464;
        }
      }
      label397:
      label430:
      label435:
      label464:
      for (boolean bool = true;; bool = false)
      {
        setSelected(bool);
        AppMethodBeat.o(208999);
        return;
        localObject = null;
        break;
        if (this.dyK != null)
        {
          removeView(this.dyK);
          this.dyK = null;
        }
        this.dyT = null;
        this.dyU = null;
        break label146;
        localObject = null;
        break label212;
        if ((this.dyT == null) && (this.dyU == null)) {
          break label345;
        }
        a(this.dyT, this.dyU);
        break label345;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout
 * JD-Core Version:    0.7.0.1
 */