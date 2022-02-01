package com.tencent.mm.plugin.finder.view.tabcomp;

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
import androidx.core.g.h;
import androidx.core.g.v;
import androidx.core.g.z;
import androidx.core.widget.j;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.a;
import androidx.viewpager.widget.ViewPager.c;
import com.google.android.material.a.b;
import com.google.android.material.a.d;
import com.google.android.material.a.h;
import com.google.android.material.a.k;
import com.google.android.material.internal.l;
import com.google.android.material.tabs.TabItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.r;

@ViewPager.a
public class FinderTabLayout
  extends HorizontalScrollView
{
  private static final e.a<e> dxO;
  e GJs;
  public final d GJt;
  private b GJu;
  private b GJv;
  private f GJw;
  private a GJx;
  private int contentInsetStart;
  final ArrayList<e> dxP;
  private final RectF dxR;
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
  private final ArrayList<b> dyi;
  private ValueAnimator dyk;
  ViewPager dyl;
  private androidx.viewpager.widget.a dym;
  private DataSetObserver dyn;
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
    AppMethodBeat.i(345817);
    dxO = new androidx.core.f.e.c(16);
    AppMethodBeat.o(345817);
  }
  
  public FinderTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.tabStyle);
  }
  
  public FinderTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345627);
    this.dxP = new ArrayList();
    this.dxR = new RectF();
    this.tabMaxWidth = 2147483647;
    this.dyi = new ArrayList();
    this.dyr = new e.b(12);
    setHorizontalScrollBarEnabled(false);
    this.GJt = new d(paramContext);
    super.addView(this.GJt, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = com.google.android.material.internal.k.a(paramContext, paramAttributeSet, a.k.TabLayout, paramInt, com.google.android.material.a.j.Widget_Design_TabLayout, new int[] { a.k.TabLayout_tabTextAppearance });
    this.GJt.setSelectedIndicatorHeight(localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabIndicatorHeight, -1));
    this.GJt.setSelectedIndicatorColor(localTypedArray.getColor(a.k.TabLayout_tabIndicatorColor, 0));
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
        int i = this.dxT.getDefaultColor();
        this.dxT = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt, i });
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
      this.dxZ = paramContext.getDimensionPixelSize(com.tencent.mm.plugin.finder.e.c.design_tab_text_size_2line);
      this.dyd = paramContext.getDimensionPixelSize(a.d.design_tab_scrollable_min_width);
      Xd();
      AppMethodBeat.o(345627);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
      AppMethodBeat.o(345627);
    }
  }
  
  private void WY()
  {
    AppMethodBeat.i(345675);
    int i = this.GJt.getChildCount() - 1;
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
      d(locale);
    }
    this.GJs = null;
    AppMethodBeat.o(345675);
  }
  
  private void Xa()
  {
    AppMethodBeat.i(345691);
    int j = this.dxP.size();
    int i = 0;
    while (i < j)
    {
      ((e)this.dxP.get(i)).updateView();
      i += 1;
    }
    AppMethodBeat.o(345691);
  }
  
  private LinearLayout.LayoutParams Xb()
  {
    AppMethodBeat.i(345718);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    AppMethodBeat.o(345718);
    return localLayoutParams;
  }
  
  private void Xc()
  {
    AppMethodBeat.i(345730);
    if (this.dyk == null)
    {
      this.dyk = new ValueAnimator();
      this.dyk.setInterpolator(c.dnr);
      this.dyk.setDuration(this.tabIndicatorAnimationDuration);
      this.dyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(345570);
          FinderTabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
          AppMethodBeat.o(345570);
        }
      });
    }
    AppMethodBeat.o(345730);
  }
  
  private void Xd()
  {
    AppMethodBeat.i(345776);
    if (this.mode == 0) {}
    for (int i = Math.max(0, this.contentInsetStart - this.tabPaddingStart);; i = 0)
    {
      z.g(this.GJt, i, 0, 0, 0);
      switch (this.mode)
      {
      }
      for (;;)
      {
        bP(true);
        AppMethodBeat.o(345776);
        return;
        this.GJt.setGravity(1);
        continue;
        this.GJt.setGravity(8388611);
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
  
  private void a(ViewPager paramViewPager, boolean paramBoolean)
  {
    AppMethodBeat.i(345684);
    if (this.dyl != null)
    {
      if (this.GJw != null) {
        this.dyl.removeOnPageChangeListener(this.GJw);
      }
      if (this.GJx != null) {
        this.dyl.removeOnAdapterChangeListener(this.GJx);
      }
    }
    if (this.GJv != null)
    {
      b(this.GJv);
      this.GJv = null;
    }
    if (paramViewPager != null)
    {
      this.dyl = paramViewPager;
      if (this.GJw == null) {
        this.GJw = new f(this);
      }
      this.GJw.reset();
      paramViewPager.addOnPageChangeListener(this.GJw);
      this.GJv = new h(paramViewPager);
      a(this.GJv);
      androidx.viewpager.widget.a locala = paramViewPager.getAdapter();
      if (locala != null) {
        a(locala, true);
      }
      if (this.GJx == null) {
        this.GJx = new a();
      }
      this.GJx.dyt = true;
      paramViewPager.addOnAdapterChangeListener(this.GJx);
      jr(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.dyq = paramBoolean;
      AppMethodBeat.o(345684);
      return;
      this.dyl = null;
      a(null, false);
    }
  }
  
  private void a(TabItem paramTabItem)
  {
    AppMethodBeat.i(345648);
    e locale = fmE();
    if (paramTabItem.bba != null) {
      locale.ag(paramTabItem.bba);
    }
    if (paramTabItem.dqY != null)
    {
      locale.dqY = paramTabItem.dqY;
      locale.updateView();
    }
    if (paramTabItem.dxN != 0) {
      locale.US(paramTabItem.dxN);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription())) {
      locale.ah(paramTabItem.getContentDescription());
    }
    c(locale);
    AppMethodBeat.o(345648);
  }
  
  private void a(e parame, int paramInt)
  {
    AppMethodBeat.i(345702);
    parame.position = paramInt;
    this.dxP.add(paramInt, parame);
    int i = this.dxP.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((e)this.dxP.get(paramInt)).position = paramInt;
      paramInt += 1;
    }
    AppMethodBeat.o(345702);
  }
  
  private void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(345641);
    a(parame, this.dxP.size(), paramBoolean);
    AppMethodBeat.o(345641);
  }
  
  private void b(b paramb)
  {
    AppMethodBeat.i(345656);
    this.dyi.remove(paramb);
    AppMethodBeat.o(345656);
  }
  
  private void cF(View paramView)
  {
    AppMethodBeat.i(345710);
    if ((paramView instanceof TabItem))
    {
      a((TabItem)paramView);
      AppMethodBeat.o(345710);
      return;
    }
    paramView = new IllegalArgumentException("Only TabItem instances can be added to CustomTabLayout");
    AppMethodBeat.o(345710);
    throw paramView;
  }
  
  static boolean d(e parame)
  {
    AppMethodBeat.i(345667);
    boolean bool = dxO.release(parame);
    AppMethodBeat.o(345667);
    return bool;
  }
  
  private g e(e parame)
  {
    AppMethodBeat.i(345697);
    g localg1;
    g localg2;
    if (this.dyr != null)
    {
      localg1 = (g)this.dyr.acquire();
      localg2 = localg1;
      if (localg1 == null) {
        localg2 = new g(getContext());
      }
      localg2.setTab(parame);
      localg2.setFocusable(true);
      localg2.setMinimumWidth(getTabMinWidth());
      if (!TextUtils.isEmpty(e.j(parame))) {
        break label94;
      }
      localg2.setContentDescription(e.k(parame));
    }
    for (;;)
    {
      AppMethodBeat.o(345697);
      return localg2;
      localg1 = null;
      break;
      label94:
      localg2.setContentDescription(e.j(parame));
    }
  }
  
  private void f(e parame)
  {
    AppMethodBeat.i(345706);
    g localg = parame.GJD;
    this.GJt.addView(localg, parame.position, Xb());
    AppMethodBeat.o(345706);
  }
  
  private static e fmF()
  {
    AppMethodBeat.i(345662);
    e locale2 = (e)dxO.acquire();
    e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new e();
    }
    AppMethodBeat.o(345662);
    return locale1;
  }
  
  private void fmG()
  {
    AppMethodBeat.i(345754);
    int i = this.dyi.size() - 1;
    while (i >= 0)
    {
      this.dyi.get(i);
      i -= 1;
    }
    AppMethodBeat.o(345754);
  }
  
  private int getDefaultHeight()
  {
    AppMethodBeat.i(345789);
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
        AppMethodBeat.o(345789);
        return 72;
        i += 1;
        break;
      }
      AppMethodBeat.o(345789);
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
    AppMethodBeat.i(345689);
    int i = Math.max(0, this.GJt.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
    AppMethodBeat.o(345689);
    return i;
  }
  
  private void h(e parame)
  {
    AppMethodBeat.i(345740);
    int i = this.dyi.size() - 1;
    while (i >= 0)
    {
      ((b)this.dyi.get(i)).b(parame);
      i -= 1;
    }
    AppMethodBeat.o(345740);
  }
  
  private void i(e parame)
  {
    AppMethodBeat.i(345747);
    int i = this.dyi.size() - 1;
    while (i >= 0)
    {
      ((b)this.dyi.get(i)).a(parame);
      i -= 1;
    }
    AppMethodBeat.o(345747);
  }
  
  private int j(int paramInt, float paramFloat)
  {
    int i = 0;
    AppMethodBeat.i(345762);
    if (this.mode == 0)
    {
      View localView2 = this.GJt.getChildAt(paramInt);
      View localView1;
      if (paramInt + 1 < this.GJt.getChildCount())
      {
        localView1 = this.GJt.getChildAt(paramInt + 1);
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
        AppMethodBeat.o(345762);
        return paramInt + j;
        localView1 = null;
        break;
      }
      label131:
      AppMethodBeat.o(345762);
      return j - paramInt;
    }
    AppMethodBeat.o(345762);
    return 0;
  }
  
  private void jr(int paramInt)
  {
    AppMethodBeat.i(345634);
    a(paramInt, 0.0F, true, true);
    AppMethodBeat.o(345634);
  }
  
  private void jv(int paramInt)
  {
    AppMethodBeat.i(345725);
    if (paramInt != -1)
    {
      if ((getWindowToken() != null) && (z.au(this)))
      {
        d locald = this.GJt;
        int j = locald.getChildCount();
        int i = 0;
        if (i < j) {
          if (locald.getChildAt(i).getWidth() > 0) {}
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label139;
          }
          i = getScrollX();
          j = j(paramInt, 0.0F);
          if (i != j)
          {
            Xc();
            this.dyk.setIntValues(new int[] { i, j });
            this.dyk.start();
          }
          this.GJt.cA(paramInt, this.tabIndicatorAnimationDuration);
          AppMethodBeat.o(345725);
          return;
          i += 1;
          break;
        }
      }
      label139:
      jr(paramInt);
    }
    AppMethodBeat.o(345725);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    AppMethodBeat.i(345734);
    int j = this.GJt.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.GJt.getChildAt(i);
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
    AppMethodBeat.o(345734);
  }
  
  public final e UR(int paramInt)
  {
    AppMethodBeat.i(345903);
    if ((paramInt >= 0) && (paramInt < getTabCount()))
    {
      e locale = (e)this.dxP.get(paramInt);
      AppMethodBeat.o(345903);
      return locale;
    }
    AppMethodBeat.o(345903);
    return null;
  }
  
  final void WZ()
  {
    AppMethodBeat.i(346073);
    WY();
    if (this.dym != null)
    {
      int j = this.dym.getCount();
      int i = 0;
      while (i < j)
      {
        a(fmE().ag(this.dym.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.dyl != null) && (j > 0))
      {
        i = this.dyl.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          b(UR(i), true);
        }
      }
    }
    AppMethodBeat.o(346073);
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(345847);
    int i = Math.round(paramInt + paramFloat);
    if ((i >= 0) && (i < this.GJt.getChildCount()))
    {
      if (paramBoolean2) {
        this.GJt.k(paramInt, paramFloat);
      }
      if ((this.dyk != null) && (this.dyk.isRunning())) {
        this.dyk.cancel();
      }
      scrollTo(j(paramInt, paramFloat), 0);
      if (paramBoolean1) {
        setSelectedTabView(i);
      }
    }
    AppMethodBeat.o(345847);
  }
  
  final void a(androidx.viewpager.widget.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(346067);
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
    AppMethodBeat.o(346067);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(345879);
    if (!this.dyi.contains(paramb)) {
      this.dyi.add(paramb);
    }
    AppMethodBeat.o(345879);
  }
  
  public final void a(e parame, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(345861);
    if (parame.GJC != this)
    {
      parame = new IllegalArgumentException("Tab belongs to a different CustomTabLayout.");
      AppMethodBeat.o(345861);
      throw parame;
    }
    a(parame, paramInt);
    f(parame);
    if (paramBoolean) {
      parame.Xf();
    }
    AppMethodBeat.o(345861);
  }
  
  public void addView(View paramView)
  {
    AppMethodBeat.i(346078);
    cF(paramView);
    AppMethodBeat.o(346078);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(346083);
    cF(paramView);
    AppMethodBeat.o(346083);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(346094);
    cF(paramView);
    AppMethodBeat.o(346094);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(346089);
    cF(paramView);
    AppMethodBeat.o(346089);
  }
  
  final void b(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(346135);
    e locale = this.GJs;
    int i;
    if (locale == parame)
    {
      if (locale != null)
      {
        fmG();
        jv(parame.position);
        AppMethodBeat.o(346135);
      }
    }
    else
    {
      if (parame == null) {
        break label121;
      }
      i = parame.position;
      if (paramBoolean)
      {
        if (((locale != null) && (locale.position != -1)) || (i == -1)) {
          break label126;
        }
        jr(i);
      }
    }
    for (;;)
    {
      if (i != -1) {
        setSelectedTabView(i);
      }
      this.GJs = parame;
      if (locale != null) {
        i(locale);
      }
      if (parame != null) {
        h(parame);
      }
      AppMethodBeat.o(346135);
      return;
      label121:
      i = -1;
      break;
      label126:
      jv(i);
    }
  }
  
  final void bP(boolean paramBoolean)
  {
    AppMethodBeat.i(346145);
    int i = 0;
    while (i < this.GJt.getChildCount())
    {
      View localView = this.GJt.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
    AppMethodBeat.o(346145);
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(345853);
    a(parame, this.dxP.isEmpty());
    AppMethodBeat.o(345853);
  }
  
  public final e fmE()
  {
    AppMethodBeat.i(345887);
    e locale = fmF();
    locale.GJC = this;
    locale.GJD = e(locale);
    AppMethodBeat.o(345887);
    return locale;
  }
  
  final void g(e parame)
  {
    AppMethodBeat.i(370680);
    b(parame, true);
    AppMethodBeat.o(370680);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(346152);
    paramAttributeSet = generateDefaultLayoutParams();
    AppMethodBeat.o(346152);
    return paramAttributeSet;
  }
  
  public int getSelectedTabPosition()
  {
    if (this.GJs != null) {
      return this.GJs.position;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    AppMethodBeat.i(345894);
    int i = this.dxP.size();
    AppMethodBeat.o(345894);
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
  
  final int jt(int paramInt)
  {
    AppMethodBeat.i(346099);
    paramInt = Math.round(getResources().getDisplayMetrics().density * paramInt);
    AppMethodBeat.o(346099);
    return paramInt;
  }
  
  final void ju(int paramInt)
  {
    AppMethodBeat.i(346112);
    g localg = (g)this.GJt.getChildAt(paramInt);
    this.GJt.removeViewAt(paramInt);
    if (localg != null)
    {
      localg.reset();
      this.dyr.release(localg);
    }
    requestLayout();
    AppMethodBeat.o(346112);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(346055);
    super.onAttachedToWindow();
    if (this.dyl == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        a((ViewPager)localViewParent, true);
      }
    }
    AppMethodBeat.o(346055);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(346062);
    super.onDetachedFromWindow();
    if (this.dyq)
    {
      setupWithViewPager(null);
      this.dyq = false;
    }
    AppMethodBeat.o(346062);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(346103);
    int i = 0;
    while (i < this.GJt.getChildCount())
    {
      View localView = this.GJt.getChildAt(i);
      if ((localView instanceof g)) {
        g.a((g)localView, paramCanvas);
      }
      i += 1;
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(346103);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(346108);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(346108);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(346105);
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
      AppMethodBeat.o(346105);
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
    AppMethodBeat.i(345964);
    if (this.dye != paramBoolean)
    {
      this.dye = paramBoolean;
      int i = 0;
      if (i < this.GJt.getChildCount())
      {
        Object localObject = this.GJt.getChildAt(i);
        int j;
        if ((localObject instanceof g))
        {
          localObject = (g)localObject;
          if (!((g)localObject).GJy.dye) {
            break label114;
          }
          j = 0;
          label70:
          ((g)localObject).setOrientation(j);
          if ((((g)localObject).dyT != null) || (((g)localObject).dyU != null)) {
            break label119;
          }
          ((g)localObject).a(((g)localObject).dyR, ((g)localObject).dyS);
        }
        for (;;)
        {
          i += 1;
          break;
          label114:
          j = 1;
          break label70;
          label119:
          ((g)localObject).a(((g)localObject).dyT, ((g)localObject).dyU);
        }
      }
      Xd();
    }
    AppMethodBeat.o(345964);
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    AppMethodBeat.i(345975);
    setInlineLabel(getResources().getBoolean(paramInt));
    AppMethodBeat.o(345975);
  }
  
  @Deprecated
  public void setOnTabSelectedListener(b paramb)
  {
    AppMethodBeat.i(345869);
    if (this.GJu != null) {
      b(this.GJu);
    }
    this.GJu = paramb;
    if (paramb != null) {
      a(paramb);
    }
    AppMethodBeat.o(345869);
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(346119);
    Xc();
    this.dyk.addListener(paramAnimatorListener);
    AppMethodBeat.o(346119);
  }
  
  public void setSelectedTabIndicator(int paramInt)
  {
    AppMethodBeat.i(346043);
    if (paramInt != 0)
    {
      setSelectedTabIndicator(androidx.appcompat.a.a.a.m(getContext(), paramInt));
      AppMethodBeat.o(346043);
      return;
    }
    setSelectedTabIndicator(null);
    AppMethodBeat.o(346043);
  }
  
  public void setSelectedTabIndicator(Drawable paramDrawable)
  {
    AppMethodBeat.i(346039);
    if (this.dxW != paramDrawable)
    {
      this.dxW = paramDrawable;
      z.Q(this.GJt);
    }
    AppMethodBeat.o(346039);
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    AppMethodBeat.i(345826);
    this.GJt.setSelectedIndicatorColor(paramInt);
    AppMethodBeat.o(345826);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    AppMethodBeat.i(345940);
    if (this.tabIndicatorGravity != paramInt)
    {
      this.tabIndicatorGravity = paramInt;
      z.Q(this.GJt);
    }
    AppMethodBeat.o(345940);
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    AppMethodBeat.i(345837);
    this.GJt.setSelectedIndicatorHeight(paramInt);
    AppMethodBeat.o(345837);
  }
  
  public void setTabGravity(int paramInt)
  {
    AppMethodBeat.i(345928);
    if (this.tabGravity != paramInt)
    {
      this.tabGravity = paramInt;
      Xd();
    }
    AppMethodBeat.o(345928);
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(346000);
    if (this.dxU != paramColorStateList)
    {
      this.dxU = paramColorStateList;
      Xa();
    }
    AppMethodBeat.o(346000);
  }
  
  public void setTabIconTintResource(int paramInt)
  {
    AppMethodBeat.i(346005);
    setTabIconTint(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    AppMethodBeat.o(346005);
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    AppMethodBeat.i(345950);
    this.dyf = paramBoolean;
    z.Q(this.GJt);
    AppMethodBeat.o(345950);
  }
  
  public void setTabMode(int paramInt)
  {
    AppMethodBeat.i(345917);
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      Xd();
    }
    AppMethodBeat.o(345917);
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(346023);
    if (this.dxV != paramColorStateList)
    {
      this.dxV = paramColorStateList;
      int i = 0;
      while (i < this.GJt.getChildCount())
      {
        paramColorStateList = this.GJt.getChildAt(i);
        if ((paramColorStateList instanceof g)) {
          g.a((g)paramColorStateList, getContext());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(346023);
  }
  
  public void setTabRippleColorResource(int paramInt)
  {
    AppMethodBeat.i(346032);
    setTabRippleColor(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    AppMethodBeat.o(346032);
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(345990);
    if (this.dxT != paramColorStateList)
    {
      this.dxT = paramColorStateList;
      Xa();
    }
    AppMethodBeat.o(345990);
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(androidx.viewpager.widget.a parama)
  {
    AppMethodBeat.i(346049);
    a(parama, false);
    AppMethodBeat.o(346049);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    AppMethodBeat.i(345981);
    if (this.dyg != paramBoolean)
    {
      this.dyg = paramBoolean;
      int i = 0;
      while (i < this.GJt.getChildCount())
      {
        View localView = this.GJt.getChildAt(i);
        if ((localView instanceof g)) {
          g.a((g)localView, getContext());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(345981);
  }
  
  public void setUnboundedRippleResource(int paramInt)
  {
    AppMethodBeat.i(345986);
    setUnboundedRipple(getResources().getBoolean(paramInt));
    AppMethodBeat.o(345986);
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    AppMethodBeat.i(346047);
    a(paramViewPager, false);
    AppMethodBeat.o(346047);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    AppMethodBeat.i(346052);
    if (getTabScrollRange() > 0)
    {
      AppMethodBeat.o(346052);
      return true;
    }
    AppMethodBeat.o(346052);
    return false;
  }
  
  final class a
    implements ViewPager.c
  {
    boolean dyt;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, androidx.viewpager.widget.a parama1, androidx.viewpager.widget.a parama2)
    {
      AppMethodBeat.i(345578);
      if (FinderTabLayout.this.dyl == paramViewPager) {
        FinderTabLayout.this.a(parama2, this.dyt);
      }
      AppMethodBeat.o(345578);
    }
  }
  
  public static abstract interface b<T extends FinderTabLayout.e>
  {
    public abstract void a(T paramT);
    
    public abstract void b(T paramT);
  }
  
  final class c
    extends DataSetObserver
  {
    c() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(345574);
      FinderTabLayout.this.WZ();
      AppMethodBeat.o(345574);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(345579);
      FinderTabLayout.this.WZ();
      AppMethodBeat.o(345579);
    }
  }
  
  public final class d
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
    private boolean isFirst;
    
    d(Context paramContext)
    {
      super();
      AppMethodBeat.i(345585);
      this.dyx = -1;
      this.dyz = -1;
      this.dyA = -1;
      this.dyB = -1;
      this.isFirst = false;
      setWillNotDraw(false);
      this.dyv = new Paint();
      this.dyw = new GradientDrawable();
      AppMethodBeat.o(345585);
    }
    
    private void Xe()
    {
      AppMethodBeat.i(345592);
      View localView = getChildAt(this.dyx);
      int k;
      int m;
      int j;
      int i;
      if ((localView != null) && (localView.getWidth() > 0))
      {
        k = localView.getLeft();
        m = localView.getRight();
        j = m;
        i = k;
        if (!FinderTabLayout.this.dyf)
        {
          j = m;
          i = k;
          if ((localView instanceof FinderTabLayout.g))
          {
            if (!a((FinderTabLayout.g)localView, FinderTabLayout.b(FinderTabLayout.this))) {
              b((FinderTabLayout.g)localView, FinderTabLayout.b(FinderTabLayout.this));
            }
            i = (int)FinderTabLayout.b(FinderTabLayout.this).left;
            j = (int)FinderTabLayout.b(FinderTabLayout.this).right;
            new StringBuilder("right - left:").append(j - i);
          }
        }
        m = j;
        j = m;
        k = i;
        if (this.dyy > 0.0F)
        {
          j = m;
          k = i;
          if (this.dyx < getChildCount() - 1)
          {
            localView = getChildAt(this.dyx + 1);
            k = localView.getLeft();
            j = localView.getRight();
            if ((FinderTabLayout.this.dyf) || (!(localView instanceof FinderTabLayout.g))) {
              break label361;
            }
            b((FinderTabLayout.g)localView, FinderTabLayout.b(FinderTabLayout.this));
            k = (int)FinderTabLayout.b(FinderTabLayout.this).left;
            j = (int)FinderTabLayout.b(FinderTabLayout.this).right;
          }
        }
      }
      label361:
      for (;;)
      {
        float f1 = this.dyy;
        float f2 = k;
        float f3 = this.dyy;
        k = (int)(i * (1.0F - f3) + f1 * f2);
        f1 = this.dyy;
        f2 = j;
        f3 = this.dyy;
        j = (int)(f2 * f1 + m * (1.0F - f3));
        for (;;)
        {
          cz(k, j);
          AppMethodBeat.o(345592);
          return;
          j = -1;
          k = -1;
        }
      }
    }
    
    private static boolean a(FinderTabLayout.g paramg, RectF paramRectF)
    {
      AppMethodBeat.i(345597);
      if ((paramg != null) && ((paramg.dyK.getTag() instanceof d)))
      {
        paramg = ((d)paramg.dyK.getTag()).fms();
        if (paramg != null)
        {
          paramRectF.set(((Integer)paramg.bsC).intValue(), 0.0F, ((Integer)paramg.bsD).intValue(), 0.0F);
          AppMethodBeat.o(345597);
          return true;
        }
      }
      AppMethodBeat.o(345597);
      return false;
    }
    
    private void b(FinderTabLayout.g paramg, RectF paramRectF)
    {
      AppMethodBeat.i(345602);
      int j = paramg.getContentWidth();
      int i = j;
      if (j < FinderTabLayout.this.jt(24)) {
        i = FinderTabLayout.this.jt(24);
      }
      j = (paramg.getLeft() + paramg.getRight()) / 2;
      int k = i / 2;
      i /= 2;
      paramRectF.set(j - k, 0.0F, i + j, 0.0F);
      AppMethodBeat.o(345602);
    }
    
    final void cA(final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(345679);
      if ((this.dyC != null) && (this.dyC.isRunning())) {
        this.dyC.cancel();
      }
      Object localObject = getChildAt(paramInt1);
      if (localObject == null)
      {
        Xe();
        AppMethodBeat.o(345679);
        return;
      }
      final int i;
      final int j;
      if (((localObject instanceof FinderTabLayout.g)) && ((((FinderTabLayout.g)localObject).dyK.getTag() instanceof d)))
      {
        i = 1;
        if (i == 0) {
          break label320;
        }
        if (FinderTabLayout.this.dyf) {
          break label304;
        }
        if (!a((FinderTabLayout.g)localObject, FinderTabLayout.b(FinderTabLayout.this))) {
          b((FinderTabLayout.g)localObject, FinderTabLayout.b(FinderTabLayout.this));
        }
        i = (int)FinderTabLayout.b(FinderTabLayout.this).left;
        j = (int)FinderTabLayout.b(FinderTabLayout.this).right;
      }
      for (;;)
      {
        new StringBuilder("indicatorLeft :").append(((View)localObject).getLeft()).append(" indicatorRight:").append(((View)localObject).getRight());
        final int k = this.dyA;
        final int m = this.dyB;
        if ((k != i) || (m != j))
        {
          localObject = new ValueAnimator();
          this.dyC = ((ValueAnimator)localObject);
          ((ValueAnimator)localObject).setInterpolator(c.dnr);
          ((ValueAnimator)localObject).setDuration(paramInt2);
          ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(345565);
              float f = paramAnonymousValueAnimator.getAnimatedFraction();
              FinderTabLayout.d.this.cz(c.d(k, i, f), c.d(m, j, f));
              AppMethodBeat.o(345565);
            }
          });
          ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              FinderTabLayout.d.this.dyx = paramInt1;
              FinderTabLayout.d.this.dyy = 0.0F;
            }
            
            public final void onAnimationStart(Animator paramAnonymousAnimator, boolean paramAnonymousBoolean) {}
          });
          ((ValueAnimator)localObject).start();
        }
        AppMethodBeat.o(345679);
        return;
        i = 0;
        break;
        label304:
        i = ((View)localObject).getLeft();
        j = ((View)localObject).getRight();
        continue;
        label320:
        if ((!FinderTabLayout.this.dyf) && ((localObject instanceof FinderTabLayout.g)))
        {
          b((FinderTabLayout.g)localObject, FinderTabLayout.b(FinderTabLayout.this));
          i = (int)FinderTabLayout.b(FinderTabLayout.this).left;
          j = (int)FinderTabLayout.b(FinderTabLayout.this).right;
        }
        else
        {
          i = ((View)localObject).getLeft();
          j = ((View)localObject).getRight();
        }
      }
    }
    
    final void cz(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(345665);
      if ((paramInt1 != this.dyA) || (paramInt2 != this.dyB))
      {
        this.dyA = paramInt1;
        this.dyB = paramInt2;
        new StringBuilder("indicatorLeft :").append(this.dyA).append(" indicatorRight:").append(this.dyB).append(" gap:").append(this.dyB - this.dyA);
        z.Q(this);
      }
      AppMethodBeat.o(345665);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(345686);
      if (FinderTabLayout.this.dxW != null) {}
      for (int i = FinderTabLayout.this.dxW.getIntrinsicHeight();; i = 0)
      {
        if (this.dyu >= 0) {
          i = this.dyu;
        }
        int j;
        Object localObject;
        switch (FinderTabLayout.this.tabIndicatorGravity)
        {
        default: 
          i = 0;
          j = 0;
          if ((this.dyA >= 0) && (this.dyB > this.dyA))
          {
            if (FinderTabLayout.this.dxW == null) {
              break label277;
            }
            localObject = FinderTabLayout.this.dxW;
            label117:
            localObject = androidx.core.graphics.drawable.a.s((Drawable)localObject);
            new StringBuilder("indicatorLeft :").append(this.dyA).append(" indicatorRight:").append(this.dyB);
            ((Drawable)localObject).setBounds(this.dyA, j, this.dyB, i);
            if (this.dyv != null)
            {
              if (Build.VERSION.SDK_INT != 21) {
                break label286;
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
          AppMethodBeat.o(345686);
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
          label277:
          localObject = this.dyw;
          break label117;
          label286:
          androidx.core.graphics.drawable.a.a((Drawable)localObject, this.dyv.getColor());
        }
      }
    }
    
    final float getIndicatorPosition()
    {
      return this.dyx + this.dyy;
    }
    
    final void k(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(345629);
      if ((this.dyC != null) && (this.dyC.isRunning())) {
        this.dyC.cancel();
      }
      this.dyx = paramInt;
      this.dyy = paramFloat;
      Xe();
      AppMethodBeat.o(345629);
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(345659);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.dyC != null) && (this.dyC.isRunning()))
      {
        this.dyC.cancel();
        long l = this.dyC.getDuration();
        paramInt1 = this.dyx;
        float f = this.dyC.getAnimatedFraction();
        cA(paramInt1, Math.round((float)l * (1.0F - f)));
      }
      for (;;)
      {
        if (!this.isFirst)
        {
          post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(345566);
              int m = FinderTabLayout.d.this.getChildCount();
              if (m % 2 != 0)
              {
                int k = m / 2;
                int n = FinderTabLayout.d.this.getPaddingStart();
                int i1 = FinderTabLayout.d.this.getPaddingEnd();
                new StringBuilder(" startPadding:").append(n).append(" endPadding:").append(i1);
                int j = 0;
                int i2;
                for (int i = 0; j < k; i = i2 + n + i)
                {
                  i2 = FinderTabLayout.d.this.getChildAt(j).getWidth();
                  j += 1;
                }
                j = k + 1;
                k = 0;
                while (j < m)
                {
                  k += FinderTabLayout.d.this.getChildAt(j).getWidth() + i1;
                  j += 1;
                }
                if (i > k)
                {
                  new StringBuilder(" add right padding:").append(i1 + i - k);
                  FinderTabLayout.d.a(FinderTabLayout.d.this, false, i + i1 - k);
                  AppMethodBeat.o(345566);
                  return;
                }
                new StringBuilder(" add left padding:").append(n + k - i);
                FinderTabLayout.d.a(FinderTabLayout.d.this, true, k + n - i);
              }
              AppMethodBeat.o(345566);
            }
          });
          this.isFirst = true;
        }
        AppMethodBeat.o(345659);
        return;
        Xe();
      }
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      int m = 1;
      AppMethodBeat.i(345653);
      super.onMeasure(paramInt1, paramInt2);
      int n;
      int k;
      int j;
      Object localObject;
      if ((View.MeasureSpec.getMode(paramInt1) == 1073741824) && (FinderTabLayout.this.mode == 1) && (FinderTabLayout.this.tabGravity == 1))
      {
        n = getChildCount();
        k = 0;
        j = 0;
        if (k < n)
        {
          localObject = getChildAt(k);
          if (((View)localObject).getVisibility() != 0) {
            break label255;
          }
        }
      }
      label184:
      label252:
      label255:
      for (int i = Math.max(j, ((View)localObject).getMeasuredWidth());; i = j)
      {
        k += 1;
        j = i;
        break;
        if (j <= 0)
        {
          AppMethodBeat.o(345653);
          return;
        }
        i = FinderTabLayout.this.jt(16);
        if (j * n > getMeasuredWidth() - i * 2)
        {
          FinderTabLayout.this.tabGravity = 0;
          FinderTabLayout.this.bP(false);
          i = m;
          if (i != 0) {
            super.onMeasure(paramInt1, paramInt2);
          }
          AppMethodBeat.o(345653);
          return;
        }
        i = 0;
        k = 0;
        if (k < n)
        {
          localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width == j) && (((LinearLayout.LayoutParams)localObject).weight == 0.0F)) {
            break label252;
          }
          ((LinearLayout.LayoutParams)localObject).width = j;
          ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
          i = 1;
        }
        for (;;)
        {
          k += 1;
          break label184;
          break;
        }
      }
    }
    
    public final void onRtlPropertiesChanged(int paramInt)
    {
      AppMethodBeat.i(345642);
      super.onRtlPropertiesChanged(paramInt);
      if ((Build.VERSION.SDK_INT < 23) && (this.dyz != paramInt))
      {
        requestLayout();
        this.dyz = paramInt;
      }
      AppMethodBeat.o(345642);
    }
    
    final void setSelectedIndicatorColor(int paramInt)
    {
      AppMethodBeat.i(345617);
      if (this.dyv.getColor() != paramInt)
      {
        this.dyv.setColor(paramInt);
        z.Q(this);
      }
      AppMethodBeat.o(345617);
    }
    
    final void setSelectedIndicatorHeight(int paramInt)
    {
      AppMethodBeat.i(345623);
      if (this.dyu != paramInt)
      {
        this.dyu = paramInt;
        z.Q(this);
      }
      AppMethodBeat.o(345623);
    }
  }
  
  public static class e
  {
    public FinderTabLayout GJC;
    public FinderTabLayout.g GJD;
    CharSequence bba;
    Drawable dqY;
    private CharSequence dyJ;
    View dyK;
    int position = -1;
    Object tag;
    
    private e hj(View paramView)
    {
      AppMethodBeat.i(345589);
      this.dyK = paramView;
      updateView();
      AppMethodBeat.o(345589);
      return this;
    }
    
    public final e US(int paramInt)
    {
      AppMethodBeat.i(345615);
      e locale = hj(LayoutInflater.from(this.GJD.getContext()).inflate(paramInt, this.GJD, false));
      AppMethodBeat.o(345615);
      return locale;
    }
    
    public final void Xf()
    {
      AppMethodBeat.i(345638);
      if (this.GJC == null)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Tab not attached to a CustomTabLayout");
        AppMethodBeat.o(345638);
        throw localIllegalArgumentException;
      }
      this.GJC.g(this);
      AppMethodBeat.o(345638);
    }
    
    public final e ag(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(345626);
      if ((TextUtils.isEmpty(this.dyJ)) && (!TextUtils.isEmpty(paramCharSequence))) {
        this.GJD.setContentDescription(paramCharSequence);
      }
      this.bba = paramCharSequence;
      updateView();
      AppMethodBeat.o(345626);
      return this;
    }
    
    public final e ah(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(345660);
      this.dyJ = paramCharSequence;
      updateView();
      AppMethodBeat.o(345660);
      return this;
    }
    
    public final boolean isSelected()
    {
      AppMethodBeat.i(345651);
      if (this.GJC == null)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Tab not attached to a CustomTabLayout");
        AppMethodBeat.o(345651);
        throw localIllegalArgumentException;
      }
      if (this.GJC.getSelectedTabPosition() == this.position)
      {
        AppMethodBeat.o(345651);
        return true;
      }
      AppMethodBeat.o(345651);
      return false;
    }
    
    final void reset()
    {
      this.GJC = null;
      this.GJD = null;
      this.tag = null;
      this.dqY = null;
      this.bba = null;
      this.dyJ = null;
      this.position = -1;
      this.dyK = null;
    }
    
    final void updateView()
    {
      AppMethodBeat.i(345672);
      if (this.GJD != null) {
        this.GJD.update();
      }
      AppMethodBeat.o(345672);
    }
  }
  
  public static final class f
    implements ViewPager.OnPageChangeListener
  {
    private final WeakReference<FinderTabLayout> dyN;
    private int dyO;
    private int dyP;
    
    public f(FinderTabLayout paramFinderTabLayout)
    {
      AppMethodBeat.i(345575);
      this.dyN = new WeakReference(paramFinderTabLayout);
      AppMethodBeat.o(345575);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      this.dyO = this.dyP;
      this.dyP = paramInt;
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      boolean bool2 = false;
      AppMethodBeat.i(345584);
      FinderTabLayout localFinderTabLayout = (FinderTabLayout)this.dyN.get();
      if (localFinderTabLayout != null) {
        if ((this.dyP == 2) && (this.dyO != 1)) {
          break label79;
        }
      }
      label79:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((this.dyP != 2) || (this.dyO != 0)) {
          bool2 = true;
        }
        localFinderTabLayout.a(paramInt1, paramFloat, bool1, bool2);
        AppMethodBeat.o(345584);
        return;
      }
    }
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(345590);
      FinderTabLayout localFinderTabLayout = (FinderTabLayout)this.dyN.get();
      if ((localFinderTabLayout != null) && (localFinderTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localFinderTabLayout.getTabCount())) {
        if ((this.dyP != 0) && ((this.dyP != 2) || (this.dyO != 0))) {
          break label76;
        }
      }
      label76:
      for (boolean bool = true;; bool = false)
      {
        localFinderTabLayout.b(localFinderTabLayout.UR(paramInt), bool);
        AppMethodBeat.o(345590);
        return;
      }
    }
    
    final void reset()
    {
      this.dyP = 0;
      this.dyO = 0;
    }
  }
  
  public final class g
    extends LinearLayout
  {
    private FinderTabLayout.e GJE;
    public View dyK;
    TextView dyR;
    ImageView dyS;
    TextView dyT;
    ImageView dyU;
    private Drawable dyV;
    private int dyW;
    
    public g(Context paramContext)
    {
      super();
      AppMethodBeat.i(345582);
      this.dyW = 2;
      aR(paramContext);
      z.g(this, FinderTabLayout.this.tabPaddingStart, FinderTabLayout.this.tabPaddingTop, FinderTabLayout.this.tabPaddingEnd, FinderTabLayout.this.tabPaddingBottom);
      setGravity(17);
      if (FinderTabLayout.this.dye) {}
      for (int i = 0;; i = 1)
      {
        setOrientation(i);
        setClickable(true);
        z.a(this, v.aj(getContext()));
        AppMethodBeat.o(345582);
        return;
      }
    }
    
    private void aR(Context paramContext)
    {
      Object localObject = null;
      AppMethodBeat.i(345587);
      GradientDrawable localGradientDrawable;
      ColorStateList localColorStateList;
      if (FinderTabLayout.this.dya != 0)
      {
        this.dyV = androidx.appcompat.a.a.a.m(paramContext, FinderTabLayout.this.dya);
        if ((this.dyV != null) && (this.dyV.isStateful())) {
          this.dyV.setState(getDrawableState());
        }
        paramContext = new GradientDrawable();
        ((GradientDrawable)paramContext).setColor(0);
        if (FinderTabLayout.this.dxV == null) {
          break label228;
        }
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(1.0E-005F);
        localGradientDrawable.setColor(-1);
        localColorStateList = p.g(FinderTabLayout.this.dxV);
        if (Build.VERSION.SDK_INT < 21) {
          break label194;
        }
        if (FinderTabLayout.this.dyg) {
          paramContext = null;
        }
        if (!FinderTabLayout.this.dyg) {
          break label189;
        }
        label148:
        paramContext = new RippleDrawable(localColorStateList, paramContext, (Drawable)localObject);
      }
      label189:
      label194:
      label228:
      for (;;)
      {
        z.a(this, (Drawable)paramContext);
        FinderTabLayout.this.invalidate();
        AppMethodBeat.o(345587);
        return;
        this.dyV = null;
        break;
        localObject = localGradientDrawable;
        break label148;
        localObject = androidx.core.graphics.drawable.a.s(localGradientDrawable);
        androidx.core.graphics.drawable.a.a((Drawable)localObject, localColorStateList);
        paramContext = new LayerDrawable(new Drawable[] { paramContext, localObject });
      }
    }
    
    final void a(TextView paramTextView, ImageView paramImageView)
    {
      Object localObject = null;
      AppMethodBeat.i(345682);
      Drawable localDrawable;
      CharSequence localCharSequence;
      label56:
      label81:
      int i;
      if ((this.GJE != null) && (this.GJE.dqY != null))
      {
        localDrawable = androidx.core.graphics.drawable.a.s(this.GJE.dqY).mutate();
        if (this.GJE == null) {
          break label227;
        }
        localCharSequence = this.GJE.bba;
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
      for (int j = FinderTabLayout.this.jt(8);; j = 0)
      {
        if (FinderTabLayout.this.dye)
        {
          if (j != h.b(paramTextView))
          {
            h.a(paramTextView, j);
            paramTextView.bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
          label188:
          if (this.GJE == null) {
            break label298;
          }
          paramTextView = FinderTabLayout.e.j(this.GJE);
          label203:
          if (i == 0) {
            break label303;
          }
          paramTextView = localObject;
        }
        for (;;)
        {
          ae.a(this, paramTextView);
          AppMethodBeat.o(345682);
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
      AppMethodBeat.i(345600);
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
        FinderTabLayout.this.invalidate();
      }
      AppMethodBeat.o(345600);
    }
    
    final int getContentWidth()
    {
      AppMethodBeat.i(345687);
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
      AppMethodBeat.o(345687);
      return m - i;
    }
    
    public final FinderTabLayout.e getTab()
    {
      return this.GJE;
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(345622);
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(345622);
    }
    
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(345628);
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(345628);
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      int k = 1;
      AppMethodBeat.i(345639);
      int j = View.MeasureSpec.getSize(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt1);
      int n = FinderTabLayout.this.getTabMaxWidth();
      int i = paramInt1;
      float f2;
      float f1;
      if (n > 0)
      {
        if ((m != 0) && (j <= n)) {
          i = paramInt1;
        }
      }
      else
      {
        super.onMeasure(i, paramInt2);
        if (this.dyR != null)
        {
          f2 = FinderTabLayout.this.dxY;
          j = this.dyW;
          if ((this.dyS == null) || (this.dyS.getVisibility() != 0)) {
            break label300;
          }
          paramInt1 = 1;
          f1 = f2;
        }
      }
      for (;;)
      {
        f2 = this.dyR.getTextSize();
        m = this.dyR.getLineCount();
        j = j.a(this.dyR);
        if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
        {
          j = k;
          if (FinderTabLayout.this.mode == 1)
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
        AppMethodBeat.o(345639);
        return;
        i = View.MeasureSpec.makeMeasureSpec(FinderTabLayout.this.tabMaxWidth, -2147483648);
        break;
        label300:
        paramInt1 = j;
        f1 = f2;
        if (this.dyR != null)
        {
          paramInt1 = j;
          f1 = f2;
          if (this.dyR.getLineCount() > 1)
          {
            f1 = FinderTabLayout.this.dxZ;
            paramInt1 = j;
          }
        }
      }
    }
    
    public final boolean performClick()
    {
      AppMethodBeat.i(345608);
      boolean bool = super.performClick();
      if (this.GJE != null)
      {
        if (!bool) {
          playSoundEffect(0);
        }
        this.GJE.Xf();
        AppMethodBeat.o(345608);
        return true;
      }
      AppMethodBeat.o(345608);
      return bool;
    }
    
    final void reset()
    {
      AppMethodBeat.i(345655);
      setTab(null);
      setSelected(false);
      AppMethodBeat.o(345655);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(345616);
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
        AppMethodBeat.o(345616);
        return;
      }
    }
    
    final void setTab(FinderTabLayout.e parame)
    {
      AppMethodBeat.i(345647);
      if (parame != this.GJE)
      {
        this.GJE = parame;
        update();
      }
      AppMethodBeat.o(345647);
    }
    
    final void update()
    {
      AppMethodBeat.i(345669);
      FinderTabLayout.e locale = this.GJE;
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
          androidx.core.graphics.drawable.a.a((Drawable)localObject, FinderTabLayout.this.dxU);
          if (FinderTabLayout.this.dxX != null) {
            androidx.core.graphics.drawable.a.a((Drawable)localObject, FinderTabLayout.this.dxX);
          }
        }
        if (this.dyR == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_text, this, false);
          addView((View)localObject);
          this.dyR = ((TextView)localObject);
          this.dyW = j.a(this.dyR);
        }
        j.a(this.dyR, FinderTabLayout.this.tabTextAppearance);
        if (FinderTabLayout.this.dxT != null) {
          this.dyR.setTextColor(FinderTabLayout.this.dxT);
        }
        a(this.dyR, this.dyS);
        label345:
        if ((locale != null) && (!TextUtils.isEmpty(FinderTabLayout.e.j(locale)))) {
          setContentDescription(FinderTabLayout.e.j(locale));
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
        AppMethodBeat.o(345669);
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
  
  public static final class h
    implements k
  {
    private final ViewPager dyl;
    
    public h(ViewPager paramViewPager)
    {
      this.dyl = paramViewPager;
    }
    
    public final void a(FinderTabLayout.e parame) {}
    
    public final void b(FinderTabLayout.e parame)
    {
      AppMethodBeat.i(345588);
      this.dyl.setCurrentItem(parame.position);
      AppMethodBeat.o(345588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.FinderTabLayout
 * JD-Core Version:    0.7.0.1
 */