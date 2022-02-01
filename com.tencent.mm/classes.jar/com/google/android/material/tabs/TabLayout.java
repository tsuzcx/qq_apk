package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
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
import androidx.core.f.f.a;
import androidx.core.f.f.b;
import androidx.core.f.f.c;
import androidx.core.g.h;
import androidx.core.g.t;
import androidx.core.g.w;
import androidx.core.widget.i;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.a;
import androidx.viewpager.widget.ViewPager.c;
import com.google.android.material.a.b;
import com.google.android.material.a.d;
import com.google.android.material.a.h;
import com.google.android.material.a.k;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout
  extends HorizontalScrollView
{
  private static final f.a<e> bEO;
  private final ArrayList<e> bEP;
  private e bEQ;
  private final RectF bER;
  private final d bES;
  ColorStateList bET;
  ColorStateList bEU;
  ColorStateList bEV;
  Drawable bEW;
  PorterDuff.Mode bEX;
  float bEY;
  float bEZ;
  final int bFa;
  private final int bFb;
  private final int bFc;
  private final int bFd;
  boolean bFe;
  boolean bFf;
  boolean bFg;
  private b bFh;
  private final ArrayList<b> bFi;
  private b bFj;
  private ValueAnimator bFk;
  ViewPager bFl;
  private androidx.viewpager.widget.a bFm;
  private DataSetObserver bFn;
  private f bFo;
  private a bFp;
  private boolean bFq;
  private final f.a<g> bFr;
  private int contentInsetStart;
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
    AppMethodBeat.i(240094);
    bEO = new f.c(16);
    AppMethodBeat.o(240094);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.tabStyle);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(239915);
    this.bEP = new ArrayList();
    this.bER = new RectF();
    this.tabMaxWidth = 2147483647;
    this.bFi = new ArrayList();
    this.bFr = new f.b(12);
    setHorizontalScrollBarEnabled(false);
    this.bES = new d(paramContext);
    super.addView(this.bES, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = k.a(paramContext, paramAttributeSet, a.k.TabLayout, paramInt, com.google.android.material.a.j.Widget_Design_TabLayout, new int[] { a.k.TabLayout_tabTextAppearance });
    this.bES.gj(localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabIndicatorHeight, -1));
    this.bES.gi(localTypedArray.getColor(a.k.TabLayout_tabIndicatorColor, 0));
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
      this.bEY = paramAttributeSet.getDimensionPixelSize(androidx.appcompat.a.j.TextAppearance_android_textSize, 0);
      this.bET = com.google.android.material.e.a.b(paramContext, paramAttributeSet, androidx.appcompat.a.j.TextAppearance_android_textColor);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(a.k.TabLayout_tabTextColor)) {
        this.bET = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.TabLayout_tabTextColor);
      }
      if (localTypedArray.hasValue(a.k.TabLayout_tabSelectedTextColor))
      {
        paramInt = localTypedArray.getColor(a.k.TabLayout_tabSelectedTextColor, 0);
        this.bET = bD(this.bET.getDefaultColor(), paramInt);
      }
      this.bEU = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.TabLayout_tabIconTint);
      this.bEX = l.c(localTypedArray.getInt(a.k.TabLayout_tabIconTintMode, -1), null);
      this.bEV = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.TabLayout_tabRippleColor);
      this.tabIndicatorAnimationDuration = localTypedArray.getInt(a.k.TabLayout_tabIndicatorAnimationDuration, 300);
      this.bFb = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabMinWidth, -1);
      this.bFc = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabMaxWidth, -1);
      this.bFa = localTypedArray.getResourceId(a.k.TabLayout_tabBackground, 0);
      this.contentInsetStart = localTypedArray.getDimensionPixelSize(a.k.TabLayout_tabContentStart, 0);
      this.mode = localTypedArray.getInt(a.k.TabLayout_tabMode, 1);
      this.tabGravity = localTypedArray.getInt(a.k.TabLayout_tabGravity, 0);
      this.bFe = localTypedArray.getBoolean(a.k.TabLayout_tabInlineLabel, false);
      this.bFg = localTypedArray.getBoolean(a.k.TabLayout_tabUnboundedRipple, false);
      localTypedArray.recycle();
      paramContext = getResources();
      this.bEZ = paramContext.getDimensionPixelSize(a.d.design_tab_text_size_2line);
      this.bFd = paramContext.getDimensionPixelSize(a.d.design_tab_scrollable_min_width);
      xG();
      AppMethodBeat.o(239915);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
      AppMethodBeat.o(239915);
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
    AppMethodBeat.i(239943);
    e locale = xz();
    if (paramTabItem.LV != null) {
      locale.y(paramTabItem.LV);
    }
    if (paramTabItem.bxV != null)
    {
      locale.bxV = paramTabItem.bxV;
      locale.updateView();
    }
    if (paramTabItem.bEN != 0) {
      locale.gk(paramTabItem.bEN);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription()))
    {
      locale.bFJ = paramTabItem.getContentDescription();
      locale.updateView();
    }
    a(locale);
    AppMethodBeat.o(239943);
  }
  
  private void a(e parame, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239939);
    if (parame.bFL != this)
    {
      parame = new IllegalArgumentException("Tab belongs to a different TabLayout.");
      AppMethodBeat.o(239939);
      throw parame;
    }
    b(parame, paramInt);
    d(parame);
    if (paramBoolean) {
      parame.xI();
    }
    AppMethodBeat.o(239939);
  }
  
  private void b(e parame, int paramInt)
  {
    AppMethodBeat.i(240020);
    parame.position = paramInt;
    this.bEP.add(paramInt, parame);
    int i = this.bEP.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((e)this.bEP.get(paramInt)).position = paramInt;
      paramInt += 1;
    }
    AppMethodBeat.o(240020);
  }
  
  private static boolean b(e parame)
  {
    AppMethodBeat.i(239958);
    boolean bool = bEO.release(parame);
    AppMethodBeat.o(239958);
    return bool;
  }
  
  private static ColorStateList bD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240081);
    ColorStateList localColorStateList = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
    AppMethodBeat.o(240081);
    return localColorStateList;
  }
  
  private g c(e parame)
  {
    AppMethodBeat.i(240018);
    g localg1;
    g localg2;
    if (this.bFr != null)
    {
      localg1 = (g)this.bFr.acquire();
      localg2 = localg1;
      if (localg1 == null) {
        localg2 = new g(getContext());
      }
      localg2.l(parame);
      localg2.setFocusable(true);
      localg2.setMinimumWidth(getTabMinWidth());
      if (!TextUtils.isEmpty(parame.bFJ)) {
        break label94;
      }
      localg2.setContentDescription(parame.LV);
    }
    for (;;)
    {
      AppMethodBeat.o(240018);
      return localg2;
      localg1 = null;
      break;
      label94:
      localg2.setContentDescription(parame.bFJ);
    }
  }
  
  private void cj(View paramView)
  {
    AppMethodBeat.i(240035);
    if ((paramView instanceof TabItem))
    {
      a((TabItem)paramView);
      AppMethodBeat.o(240035);
      return;
    }
    paramView = new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    AppMethodBeat.o(240035);
    throw paramView;
  }
  
  private void d(e parame)
  {
    AppMethodBeat.i(240022);
    g localg = parame.bFM;
    this.bES.addView(localg, parame.position, xE());
    AppMethodBeat.o(240022);
  }
  
  private void f(e parame)
  {
    AppMethodBeat.i(240068);
    int i = this.bFi.size() - 1;
    while (i >= 0)
    {
      ((b)this.bFi.get(i)).i(parame);
      i -= 1;
    }
    AppMethodBeat.o(240068);
  }
  
  private int g(int paramInt, float paramFloat)
  {
    int i = 0;
    AppMethodBeat.i(240076);
    if (this.mode == 0)
    {
      View localView2 = this.bES.getChildAt(paramInt);
      View localView1;
      if (paramInt + 1 < this.bES.getChildCount())
      {
        localView1 = this.bES.getChildAt(paramInt + 1);
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
        if (w.I(this) != 0) {
          break label131;
        }
        AppMethodBeat.o(240076);
        return paramInt + j;
        localView1 = null;
        break;
      }
      label131:
      AppMethodBeat.o(240076);
      return j - paramInt;
    }
    AppMethodBeat.o(240076);
    return 0;
  }
  
  private void g(e parame)
  {
    AppMethodBeat.i(240070);
    int i = this.bFi.size() - 1;
    while (i >= 0)
    {
      ((b)this.bFi.get(i)).j(parame);
      i -= 1;
    }
    AppMethodBeat.o(240070);
  }
  
  private void gc(int paramInt)
  {
    AppMethodBeat.i(239927);
    a(paramInt, 0.0F, true, true);
    AppMethodBeat.o(239927);
  }
  
  private int getDefaultHeight()
  {
    AppMethodBeat.i(240084);
    int j = this.bEP.size();
    int i = 0;
    if (i < j)
    {
      e locale = (e)this.bEP.get(i);
      if ((locale == null) || (locale.bxV == null) || (TextUtils.isEmpty(locale.LV))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (!this.bFe))
      {
        AppMethodBeat.o(240084);
        return 72;
        i += 1;
        break;
      }
      AppMethodBeat.o(240084);
      return 48;
    }
  }
  
  private int getTabMinWidth()
  {
    if (this.bFb != -1) {
      return this.bFb;
    }
    if (this.mode == 0) {
      return this.bFd;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    AppMethodBeat.i(240010);
    int i = Math.max(0, this.bES.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
    AppMethodBeat.o(240010);
    return i;
  }
  
  private void gg(int paramInt)
  {
    AppMethodBeat.i(240052);
    g localg = (g)this.bES.getChildAt(paramInt);
    this.bES.removeViewAt(paramInt);
    if (localg != null)
    {
      localg.reset();
      this.bFr.release(localg);
    }
    requestLayout();
    AppMethodBeat.o(240052);
  }
  
  private void gh(int paramInt)
  {
    AppMethodBeat.i(240055);
    if (paramInt == -1)
    {
      AppMethodBeat.o(240055);
      return;
    }
    if ((getWindowToken() != null) && (w.ah(this)))
    {
      d locald = this.bES;
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
      gc(paramInt);
      AppMethodBeat.o(240055);
      return;
      i += 1;
      break;
    }
    label93:
    i = getScrollX();
    int j = g(paramInt, 0.0F);
    if (i != j)
    {
      xF();
      this.bFk.setIntValues(new int[] { i, j });
      this.bFk.start();
    }
    this.bES.bF(paramInt, this.tabIndicatorAnimationDuration);
    AppMethodBeat.o(240055);
  }
  
  private void h(e parame)
  {
    AppMethodBeat.i(240072);
    int i = this.bFi.size() - 1;
    while (i >= 0)
    {
      ((b)this.bFi.get(i)).k(parame);
      i -= 1;
    }
    AppMethodBeat.o(240072);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    AppMethodBeat.i(240060);
    int j = this.bES.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.bES.getChildAt(i);
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
    AppMethodBeat.o(240060);
  }
  
  private static e xA()
  {
    AppMethodBeat.i(239956);
    e locale2 = (e)bEO.acquire();
    e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new e();
    }
    AppMethodBeat.o(239956);
    return locale1;
  }
  
  private void xB()
  {
    AppMethodBeat.i(239965);
    int i = this.bES.getChildCount() - 1;
    while (i >= 0)
    {
      gg(i);
      i -= 1;
    }
    Iterator localIterator = this.bEP.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      localIterator.remove();
      locale.reset();
      b(locale);
    }
    this.bEQ = null;
    AppMethodBeat.o(239965);
  }
  
  private void xD()
  {
    AppMethodBeat.i(240014);
    int j = this.bEP.size();
    int i = 0;
    while (i < j)
    {
      ((e)this.bEP.get(i)).updateView();
      i += 1;
    }
    AppMethodBeat.o(240014);
  }
  
  private LinearLayout.LayoutParams xE()
  {
    AppMethodBeat.i(240039);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    AppMethodBeat.o(240039);
    return localLayoutParams;
  }
  
  private void xF()
  {
    AppMethodBeat.i(240056);
    if (this.bFk == null)
    {
      this.bFk = new ValueAnimator();
      this.bFk.setInterpolator(com.google.android.material.a.a.bun);
      this.bFk.setDuration(this.tabIndicatorAnimationDuration);
      this.bFk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(239576);
          TabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
          AppMethodBeat.o(239576);
        }
      });
    }
    AppMethodBeat.o(240056);
  }
  
  private void xG()
  {
    AppMethodBeat.i(240077);
    if (this.mode == 0) {}
    for (int i = Math.max(0, this.contentInsetStart - this.tabPaddingStart);; i = 0)
    {
      w.g(this.bES, i, 0, 0, 0);
      switch (this.mode)
      {
      }
      for (;;)
      {
        bi(true);
        AppMethodBeat.o(240077);
        return;
        this.bES.setGravity(1);
        continue;
        this.bES.setGravity(8388611);
      }
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(239930);
    int i = Math.round(paramInt + paramFloat);
    if ((i < 0) || (i >= this.bES.getChildCount()))
    {
      AppMethodBeat.o(239930);
      return;
    }
    if (paramBoolean2) {
      this.bES.h(paramInt, paramFloat);
    }
    if ((this.bFk != null) && (this.bFk.isRunning())) {
      this.bFk.cancel();
    }
    scrollTo(g(paramInt, paramFloat), 0);
    if (paramBoolean1) {
      setSelectedTabView(i);
    }
    AppMethodBeat.o(239930);
  }
  
  public final void a(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(240000);
    if (this.bFl != null)
    {
      if (this.bFo != null) {
        this.bFl.removeOnPageChangeListener(this.bFo);
      }
      if (this.bFp != null) {
        this.bFl.removeOnAdapterChangeListener(this.bFp);
      }
    }
    if (this.bFj != null)
    {
      b(this.bFj);
      this.bFj = null;
    }
    if (paramViewPager != null)
    {
      this.bFl = paramViewPager;
      if (this.bFo == null) {
        this.bFo = new f(this);
      }
      this.bFo.reset();
      paramViewPager.addOnPageChangeListener(this.bFo);
      this.bFj = new TabLayout.h(paramViewPager);
      a(this.bFj);
      androidx.viewpager.widget.a locala = paramViewPager.getAdapter();
      if (locala != null) {
        a(locala, paramBoolean1);
      }
      if (this.bFp == null) {
        this.bFp = new a();
      }
      this.bFp.bFt = paramBoolean1;
      paramViewPager.addOnAdapterChangeListener(this.bFp);
      gc(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.bFq = paramBoolean2;
      AppMethodBeat.o(240000);
      return;
      this.bFl = null;
      a(null, false);
    }
  }
  
  final void a(androidx.viewpager.widget.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(240011);
    if ((this.bFm != null) && (this.bFn != null)) {
      this.bFm.unregisterDataSetObserver(this.bFn);
    }
    this.bFm = parama;
    if ((paramBoolean) && (parama != null))
    {
      if (this.bFn == null) {
        this.bFn = new c();
      }
      parama.registerDataSetObserver(this.bFn);
    }
    xC();
    AppMethodBeat.o(240011);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(239948);
    if (!this.bFi.contains(paramb)) {
      this.bFi.add(paramb);
    }
    AppMethodBeat.o(239948);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(239933);
    a(parame, this.bEP.isEmpty());
    AppMethodBeat.o(239933);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(239935);
    a(parame, paramInt, this.bEP.isEmpty());
    AppMethodBeat.o(239935);
  }
  
  public final void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(239937);
    a(parame, this.bEP.size(), paramBoolean);
    AppMethodBeat.o(239937);
  }
  
  public void addView(View paramView)
  {
    AppMethodBeat.i(240023);
    cj(paramView);
    AppMethodBeat.o(240023);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(240026);
    cj(paramView);
    AppMethodBeat.o(240026);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(240032);
    cj(paramView);
    AppMethodBeat.o(240032);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(240029);
    cj(paramView);
    AppMethodBeat.o(240029);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(239950);
    this.bFi.remove(paramb);
    AppMethodBeat.o(239950);
  }
  
  final void b(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(240066);
    e locale = this.bEQ;
    int i;
    if (locale == parame)
    {
      if (locale != null)
      {
        h(parame);
        gh(parame.position);
        AppMethodBeat.o(240066);
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
        gc(i);
      }
    }
    for (;;)
    {
      if (i != -1) {
        setSelectedTabView(i);
      }
      this.bEQ = parame;
      if (locale != null) {
        g(locale);
      }
      if (parame != null) {
        f(parame);
      }
      AppMethodBeat.o(240066);
      return;
      label122:
      i = -1;
      break;
      label127:
      gh(i);
    }
  }
  
  public final void bC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239983);
    setTabTextColors(bD(paramInt1, paramInt2));
    AppMethodBeat.o(239983);
  }
  
  final void bi(boolean paramBoolean)
  {
    AppMethodBeat.i(240079);
    int i = 0;
    while (i < this.bES.getChildCount())
    {
      View localView = this.bES.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
    AppMethodBeat.o(240079);
  }
  
  final void e(e parame)
  {
    AppMethodBeat.i(292976);
    b(parame, true);
    AppMethodBeat.o(292976);
  }
  
  public final e gd(int paramInt)
  {
    AppMethodBeat.i(239961);
    if ((paramInt < 0) || (paramInt >= getTabCount()))
    {
      AppMethodBeat.o(239961);
      return null;
    }
    e locale = (e)this.bEP.get(paramInt);
    AppMethodBeat.o(239961);
    return locale;
  }
  
  public final void ge(int paramInt)
  {
    AppMethodBeat.i(239962);
    if (this.bEQ != null) {}
    for (int i = this.bEQ.position;; i = 0)
    {
      gg(paramInt);
      locale = (e)this.bEP.remove(paramInt);
      if (locale != null)
      {
        locale.reset();
        b(locale);
      }
      int k = this.bEP.size();
      int j = paramInt;
      while (j < k)
      {
        ((e)this.bEP.get(j)).position = j;
        j += 1;
      }
    }
    if (i == paramInt) {
      if (!this.bEP.isEmpty()) {
        break label131;
      }
    }
    label131:
    for (e locale = null;; locale = (e)this.bEP.get(Math.max(0, paramInt - 1)))
    {
      b(locale, true);
      AppMethodBeat.o(239962);
      return;
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(240087);
    paramAttributeSet = generateDefaultLayoutParams();
    AppMethodBeat.o(240087);
    return paramAttributeSet;
  }
  
  public int getSelectedTabPosition()
  {
    if (this.bEQ != null) {
      return this.bEQ.position;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    AppMethodBeat.i(239960);
    int i = this.bEP.size();
    AppMethodBeat.o(239960);
    return i;
  }
  
  public int getTabGravity()
  {
    return this.tabGravity;
  }
  
  public ColorStateList getTabIconTint()
  {
    return this.bEU;
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
    return this.bEV;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return this.bEW;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.bET;
  }
  
  final int gf(int paramInt)
  {
    AppMethodBeat.i(240043);
    paramInt = Math.round(getResources().getDisplayMetrics().density * paramInt);
    AppMethodBeat.o(240043);
    return paramInt;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(240007);
    super.onAttachedToWindow();
    if (this.bFl == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        a((ViewPager)localViewParent, true, true);
      }
    }
    AppMethodBeat.o(240007);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(240008);
    super.onDetachedFromWindow();
    if (this.bFq)
    {
      setupWithViewPager(null);
      this.bFq = false;
    }
    AppMethodBeat.o(240008);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(240045);
    int i = 0;
    while (i < this.bES.getChildCount())
    {
      View localView = this.bES.getChildAt(i);
      if ((localView instanceof g)) {
        g.a((g)localView, paramCanvas);
      }
      i += 1;
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(240045);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(240050);
    int i = gf(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    label84:
    View localView;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.bFc > 0)
        {
          i = this.bFc;
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
      AppMethodBeat.o(240050);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
      break;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      break;
      i -= gf(56);
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
    AppMethodBeat.i(239976);
    if (this.bFe != paramBoolean)
    {
      this.bFe = paramBoolean;
      int i = 0;
      if (i < this.bES.getChildCount())
      {
        Object localObject = this.bES.getChildAt(i);
        int j;
        if ((localObject instanceof g))
        {
          localObject = (g)localObject;
          if (!((g)localObject).bFs.bFe) {
            break label114;
          }
          j = 0;
          label70:
          ((g)localObject).setOrientation(j);
          if ((((g)localObject).bFT == null) && (((g)localObject).bFU == null)) {
            break label119;
          }
          ((g)localObject).a(((g)localObject).bFT, ((g)localObject).bFU);
        }
        for (;;)
        {
          i += 1;
          break;
          label114:
          j = 1;
          break label70;
          label119:
          ((g)localObject).a(((g)localObject).bFR, ((g)localObject).bFS);
        }
      }
      xG();
    }
    AppMethodBeat.o(239976);
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    AppMethodBeat.i(239978);
    setInlineLabel(getResources().getBoolean(paramInt));
    AppMethodBeat.o(239978);
  }
  
  @Deprecated
  public void setOnTabSelectedListener(b paramb)
  {
    AppMethodBeat.i(239946);
    if (this.bFh != null) {
      b(this.bFh);
    }
    this.bFh = paramb;
    if (paramb != null) {
      a(paramb);
    }
    AppMethodBeat.o(239946);
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(240059);
    xF();
    this.bFk.addListener(paramAnimatorListener);
    AppMethodBeat.o(240059);
  }
  
  public void setSelectedTabIndicator(int paramInt)
  {
    AppMethodBeat.i(239996);
    if (paramInt != 0)
    {
      setSelectedTabIndicator(androidx.appcompat.a.a.a.m(getContext(), paramInt));
      AppMethodBeat.o(239996);
      return;
    }
    setSelectedTabIndicator(null);
    AppMethodBeat.o(239996);
  }
  
  public void setSelectedTabIndicator(Drawable paramDrawable)
  {
    AppMethodBeat.i(239994);
    if (this.bEW != paramDrawable)
    {
      this.bEW = paramDrawable;
      w.G(this.bES);
    }
    AppMethodBeat.o(239994);
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    AppMethodBeat.i(239920);
    this.bES.gi(paramInt);
    AppMethodBeat.o(239920);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    AppMethodBeat.i(239972);
    if (this.tabIndicatorGravity != paramInt)
    {
      this.tabIndicatorGravity = paramInt;
      w.G(this.bES);
    }
    AppMethodBeat.o(239972);
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    AppMethodBeat.i(239924);
    this.bES.gj(paramInt);
    AppMethodBeat.o(239924);
  }
  
  public void setTabGravity(int paramInt)
  {
    AppMethodBeat.i(239970);
    if (this.tabGravity != paramInt)
    {
      this.tabGravity = paramInt;
      xG();
    }
    AppMethodBeat.o(239970);
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(239984);
    if (this.bEU != paramColorStateList)
    {
      this.bEU = paramColorStateList;
      xD();
    }
    AppMethodBeat.o(239984);
  }
  
  public void setTabIconTintResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(239986);
    setTabIconTint(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    AppMethodBeat.o(239986);
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    AppMethodBeat.i(239974);
    this.bFf = paramBoolean;
    w.G(this.bES);
    AppMethodBeat.o(239974);
  }
  
  public void setTabMode(int paramInt)
  {
    AppMethodBeat.i(239967);
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      xG();
    }
    AppMethodBeat.o(239967);
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(239991);
    if (this.bEV != paramColorStateList)
    {
      this.bEV = paramColorStateList;
      int i = 0;
      while (i < this.bES.getChildCount())
      {
        paramColorStateList = this.bES.getChildAt(i);
        if ((paramColorStateList instanceof g)) {
          g.a((g)paramColorStateList, getContext());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(239991);
  }
  
  public void setTabRippleColorResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(239992);
    setTabRippleColor(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    AppMethodBeat.o(239992);
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(239982);
    if (this.bET != paramColorStateList)
    {
      this.bET = paramColorStateList;
      xD();
    }
    AppMethodBeat.o(239982);
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(androidx.viewpager.widget.a parama)
  {
    AppMethodBeat.i(240002);
    a(parama, false);
    AppMethodBeat.o(240002);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    AppMethodBeat.i(239979);
    if (this.bFg != paramBoolean)
    {
      this.bFg = paramBoolean;
      int i = 0;
      while (i < this.bES.getChildCount())
      {
        View localView = this.bES.getChildAt(i);
        if ((localView instanceof g)) {
          g.a((g)localView, getContext());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(239979);
  }
  
  public void setUnboundedRippleResource(int paramInt)
  {
    AppMethodBeat.i(239981);
    setUnboundedRipple(getResources().getBoolean(paramInt));
    AppMethodBeat.o(239981);
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    AppMethodBeat.i(239998);
    a(paramViewPager, true, false);
    AppMethodBeat.o(239998);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    AppMethodBeat.i(240005);
    if (getTabScrollRange() > 0)
    {
      AppMethodBeat.o(240005);
      return true;
    }
    AppMethodBeat.o(240005);
    return false;
  }
  
  final void xC()
  {
    AppMethodBeat.i(240012);
    xB();
    if (this.bFm != null)
    {
      int j = this.bFm.getCount();
      int i = 0;
      while (i < j)
      {
        a(xz().y(this.bFm.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.bFl != null) && (j > 0))
      {
        i = this.bFl.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          b(gd(i), true);
        }
      }
    }
    AppMethodBeat.o(240012);
  }
  
  public final e xz()
  {
    AppMethodBeat.i(239953);
    e locale = xA();
    locale.bFL = this;
    locale.bFM = c(locale);
    AppMethodBeat.o(239953);
    return locale;
  }
  
  final class a
    implements ViewPager.c
  {
    boolean bFt;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, androidx.viewpager.widget.a parama1, androidx.viewpager.widget.a parama2)
    {
      AppMethodBeat.i(239596);
      if (TabLayout.this.bFl == paramViewPager) {
        TabLayout.this.a(parama2, this.bFt);
      }
      AppMethodBeat.o(239596);
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
      AppMethodBeat.i(239634);
      TabLayout.this.xC();
      AppMethodBeat.o(239634);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(239639);
      TabLayout.this.xC();
      AppMethodBeat.o(239639);
    }
  }
  
  final class d
    extends LinearLayout
  {
    private int bFA;
    private int bFB;
    private ValueAnimator bFC;
    private int bFu;
    private final Paint bFv;
    private final GradientDrawable bFw;
    int bFx;
    float bFy;
    private int bFz;
    
    d(Context paramContext)
    {
      super();
      AppMethodBeat.i(239713);
      this.bFx = -1;
      this.bFz = -1;
      this.bFA = -1;
      this.bFB = -1;
      setWillNotDraw(false);
      this.bFv = new Paint();
      this.bFw = new GradientDrawable();
      AppMethodBeat.o(239713);
    }
    
    private void a(TabLayout.g paramg, RectF paramRectF)
    {
      AppMethodBeat.i(239737);
      int j = paramg.getContentWidth();
      int i = j;
      if (j < TabLayout.this.gf(24)) {
        i = TabLayout.this.gf(24);
      }
      j = (paramg.getLeft() + paramg.getRight()) / 2;
      int k = i / 2;
      i /= 2;
      paramRectF.set(j - k, 0.0F, i + j, 0.0F);
      AppMethodBeat.o(239737);
    }
    
    private void xH()
    {
      AppMethodBeat.i(239730);
      View localView = getChildAt(this.bFx);
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
        if (!TabLayout.this.bFf)
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
        if (this.bFy > 0.0F)
        {
          k = i;
          m = j;
          if (this.bFx < getChildCount() - 1)
          {
            localView = getChildAt(this.bFx + 1);
            m = localView.getLeft();
            k = localView.getRight();
            if ((TabLayout.this.bFf) || (!(localView instanceof TabLayout.g))) {
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
        float f1 = this.bFy;
        float f2 = m;
        float f3 = this.bFy;
        m = (int)(j * (1.0F - f3) + f1 * f2);
        f1 = this.bFy;
        f2 = k;
        f3 = this.bFy;
        k = (int)(f2 * f1 + i * (1.0F - f3));
        for (;;)
        {
          bE(m, k);
          AppMethodBeat.o(239730);
          return;
          k = -1;
          m = -1;
        }
      }
    }
    
    final void bE(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(239733);
      if ((paramInt1 != this.bFA) || (paramInt2 != this.bFB))
      {
        this.bFA = paramInt1;
        this.bFB = paramInt2;
        w.G(this);
      }
      AppMethodBeat.o(239733);
    }
    
    final void bF(final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(239736);
      if ((this.bFC != null) && (this.bFC.isRunning())) {
        this.bFC.cancel();
      }
      Object localObject = getChildAt(paramInt1);
      if (localObject == null)
      {
        xH();
        AppMethodBeat.o(239736);
        return;
      }
      final int k = ((View)localObject).getLeft();
      final int m = ((View)localObject).getRight();
      final int j = k;
      final int i = m;
      if (!TabLayout.this.bFf)
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
      k = this.bFA;
      m = this.bFB;
      if ((k != j) || (m != i))
      {
        localObject = new ValueAnimator();
        this.bFC = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).setInterpolator(com.google.android.material.a.a.bun);
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(239680);
            float f = paramAnonymousValueAnimator.getAnimatedFraction();
            TabLayout.d.this.bE(com.google.android.material.a.a.c(k, j, f), com.google.android.material.a.a.c(m, i, f));
            AppMethodBeat.o(239680);
          }
        });
        ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            TabLayout.d.this.bFx = paramInt1;
            TabLayout.d.this.bFy = 0.0F;
          }
        });
        ((ValueAnimator)localObject).start();
      }
      AppMethodBeat.o(239736);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(239739);
      if (TabLayout.this.bEW != null) {}
      for (int i = TabLayout.this.bEW.getIntrinsicHeight();; i = 0)
      {
        if (this.bFu >= 0) {
          i = this.bFu;
        }
        int j;
        Object localObject;
        switch (TabLayout.this.tabIndicatorGravity)
        {
        default: 
          i = 0;
          j = 0;
          if ((this.bFA >= 0) && (this.bFB > this.bFA))
          {
            if (TabLayout.this.bEW == null) {
              break label247;
            }
            localObject = TabLayout.this.bEW;
            label117:
            localObject = androidx.core.graphics.drawable.a.p((Drawable)localObject);
            ((Drawable)localObject).setBounds(this.bFA, j, this.bFB, i);
            if (this.bFv != null)
            {
              if (Build.VERSION.SDK_INT != 21) {
                break label256;
              }
              ((Drawable)localObject).setColorFilter(this.bFv.getColor(), PorterDuff.Mode.SRC_IN);
            }
          }
          break;
        }
        for (;;)
        {
          ((Drawable)localObject).draw(paramCanvas);
          super.draw(paramCanvas);
          AppMethodBeat.o(239739);
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
          localObject = this.bFw;
          break label117;
          label256:
          androidx.core.graphics.drawable.a.a((Drawable)localObject, this.bFv.getColor());
        }
      }
    }
    
    final void gi(int paramInt)
    {
      AppMethodBeat.i(239715);
      if (this.bFv.getColor() != paramInt)
      {
        this.bFv.setColor(paramInt);
        w.G(this);
      }
      AppMethodBeat.o(239715);
    }
    
    final void gj(int paramInt)
    {
      AppMethodBeat.i(239718);
      if (this.bFu != paramInt)
      {
        this.bFu = paramInt;
        w.G(this);
      }
      AppMethodBeat.o(239718);
    }
    
    final void h(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(239720);
      if ((this.bFC != null) && (this.bFC.isRunning())) {
        this.bFC.cancel();
      }
      this.bFx = paramInt;
      this.bFy = paramFloat;
      xH();
      AppMethodBeat.o(239720);
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(239725);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.bFC != null) && (this.bFC.isRunning()))
      {
        this.bFC.cancel();
        long l = this.bFC.getDuration();
        paramInt1 = this.bFx;
        float f = this.bFC.getAnimatedFraction();
        bF(paramInt1, Math.round((float)l * (1.0F - f)));
        AppMethodBeat.o(239725);
        return;
      }
      xH();
      AppMethodBeat.o(239725);
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(239723);
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
      {
        AppMethodBeat.o(239723);
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
          AppMethodBeat.o(239723);
          return;
        }
        i = TabLayout.this.gf(16);
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
          TabLayout.this.bi(false);
          m = 1;
          label239:
          if (m != 0) {
            super.onMeasure(paramInt1, paramInt2);
          }
          AppMethodBeat.o(239723);
          return;
        }
      }
    }
    
    public final void onRtlPropertiesChanged(int paramInt)
    {
      AppMethodBeat.i(239722);
      super.onRtlPropertiesChanged(paramInt);
      if ((Build.VERSION.SDK_INT < 23) && (this.bFz != paramInt))
      {
        requestLayout();
        this.bFz = paramInt;
      }
      AppMethodBeat.o(239722);
    }
  }
  
  public static final class e
  {
    CharSequence LV;
    CharSequence bFJ;
    public View bFK;
    public TabLayout bFL;
    public TabLayout.g bFM;
    Drawable bxV;
    int position = -1;
    private Object tag;
    
    private e ck(View paramView)
    {
      AppMethodBeat.i(239753);
      this.bFK = paramView;
      updateView();
      AppMethodBeat.o(239753);
      return this;
    }
    
    public final e ac(Object paramObject)
    {
      this.tag = paramObject;
      return this;
    }
    
    public final View getCustomView()
    {
      return this.bFK;
    }
    
    public final int getPosition()
    {
      return this.position;
    }
    
    public final Object getTag()
    {
      return this.tag;
    }
    
    public final e gk(int paramInt)
    {
      AppMethodBeat.i(239756);
      e locale = ck(LayoutInflater.from(this.bFM.getContext()).inflate(paramInt, this.bFM, false));
      AppMethodBeat.o(239756);
      return locale;
    }
    
    public final boolean isSelected()
    {
      AppMethodBeat.i(239765);
      if (this.bFL == null)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
        AppMethodBeat.o(239765);
        throw localIllegalArgumentException;
      }
      if (this.bFL.getSelectedTabPosition() == this.position)
      {
        AppMethodBeat.o(239765);
        return true;
      }
      AppMethodBeat.o(239765);
      return false;
    }
    
    final void reset()
    {
      this.bFL = null;
      this.bFM = null;
      this.tag = null;
      this.bxV = null;
      this.LV = null;
      this.bFJ = null;
      this.position = -1;
      this.bFK = null;
    }
    
    final void updateView()
    {
      AppMethodBeat.i(239767);
      if (this.bFM != null) {
        this.bFM.update();
      }
      AppMethodBeat.o(239767);
    }
    
    public final void xI()
    {
      AppMethodBeat.i(239762);
      if (this.bFL == null)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
        AppMethodBeat.o(239762);
        throw localIllegalArgumentException;
      }
      this.bFL.e(this);
      AppMethodBeat.o(239762);
    }
    
    public final e y(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(239759);
      if ((TextUtils.isEmpty(this.bFJ)) && (!TextUtils.isEmpty(paramCharSequence))) {
        this.bFM.setContentDescription(paramCharSequence);
      }
      this.LV = paramCharSequence;
      updateView();
      AppMethodBeat.o(239759);
      return this;
    }
  }
  
  public static final class f
    implements ViewPager.OnPageChangeListener
  {
    private final WeakReference<TabLayout> bFN;
    private int bFO;
    private int bFP;
    
    public f(TabLayout paramTabLayout)
    {
      AppMethodBeat.i(239773);
      this.bFN = new WeakReference(paramTabLayout);
      AppMethodBeat.o(239773);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      this.bFO = this.bFP;
      this.bFP = paramInt;
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      boolean bool2 = false;
      AppMethodBeat.i(239775);
      TabLayout localTabLayout = (TabLayout)this.bFN.get();
      if (localTabLayout != null) {
        if ((this.bFP == 2) && (this.bFO != 1)) {
          break label79;
        }
      }
      label79:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((this.bFP != 2) || (this.bFO != 0)) {
          bool2 = true;
        }
        localTabLayout.a(paramInt1, paramFloat, bool1, bool2);
        AppMethodBeat.o(239775);
        return;
      }
    }
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(239777);
      TabLayout localTabLayout = (TabLayout)this.bFN.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
        if ((this.bFP != 0) && ((this.bFP != 2) || (this.bFO != 0))) {
          break label76;
        }
      }
      label76:
      for (boolean bool = true;; bool = false)
      {
        localTabLayout.b(localTabLayout.gd(paramInt), bool);
        AppMethodBeat.o(239777);
        return;
      }
    }
    
    final void reset()
    {
      this.bFP = 0;
      this.bFO = 0;
    }
  }
  
  final class g
    extends LinearLayout
  {
    private View bFK;
    private TabLayout.e bFQ;
    TextView bFR;
    ImageView bFS;
    TextView bFT;
    ImageView bFU;
    private Drawable bFV;
    private int bFW;
    
    public g(Context paramContext)
    {
      super();
      AppMethodBeat.i(239812);
      this.bFW = 2;
      ag(paramContext);
      w.g(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
      setGravity(17);
      if (TabLayout.this.bFe) {}
      for (int i = 0;; i = 1)
      {
        setOrientation(i);
        setClickable(true);
        w.a(this, t.U(getContext()));
        AppMethodBeat.o(239812);
        return;
      }
    }
    
    private void ag(Context paramContext)
    {
      Object localObject = null;
      AppMethodBeat.i(239817);
      GradientDrawable localGradientDrawable;
      ColorStateList localColorStateList;
      if (TabLayout.this.bFa != 0)
      {
        this.bFV = androidx.appcompat.a.a.a.m(paramContext, TabLayout.this.bFa);
        if ((this.bFV != null) && (this.bFV.isStateful())) {
          this.bFV.setState(getDrawableState());
        }
        localGradientDrawable = new GradientDrawable();
        ((GradientDrawable)localGradientDrawable).setColor(0);
        paramContext = localGradientDrawable;
        if (TabLayout.this.bEV != null)
        {
          paramContext = new GradientDrawable();
          paramContext.setCornerRadius(1.0E-005F);
          paramContext.setColor(-1);
          localColorStateList = com.google.android.material.f.a.g(TabLayout.this.bEV);
          if (Build.VERSION.SDK_INT < 21) {
            break label193;
          }
          if (TabLayout.this.bFg) {
            localGradientDrawable = null;
          }
          if (!TabLayout.this.bFg) {
            break label190;
          }
          paramContext = localObject;
        }
      }
      label152:
      for (paramContext = new RippleDrawable(localColorStateList, localGradientDrawable, paramContext);; paramContext = new LayerDrawable(new Drawable[] { localGradientDrawable, paramContext }))
      {
        w.a(this, paramContext);
        TabLayout.this.invalidate();
        AppMethodBeat.o(239817);
        return;
        this.bFV = null;
        break;
        label190:
        break label152;
        label193:
        paramContext = androidx.core.graphics.drawable.a.p(paramContext);
        androidx.core.graphics.drawable.a.a(paramContext, localColorStateList);
      }
    }
    
    final void a(TextView paramTextView, ImageView paramImageView)
    {
      Object localObject = null;
      AppMethodBeat.i(239845);
      Drawable localDrawable;
      CharSequence localCharSequence;
      label56:
      label81:
      int i;
      if ((this.bFQ != null) && (this.bFQ.bxV != null))
      {
        localDrawable = androidx.core.graphics.drawable.a.p(this.bFQ.bxV).mutate();
        if (this.bFQ == null) {
          break label227;
        }
        localCharSequence = this.bFQ.LV;
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
      for (int j = TabLayout.this.gf(8);; j = 0)
      {
        if (TabLayout.this.bFe)
        {
          if (j != h.b(paramTextView))
          {
            h.a(paramTextView, j);
            paramTextView.bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
          label188:
          if (this.bFQ == null) {
            break label298;
          }
          paramTextView = this.bFQ.bFJ;
          label203:
          if (i == 0) {
            break label303;
          }
          paramTextView = localObject;
        }
        for (;;)
        {
          ae.a(this, paramTextView);
          AppMethodBeat.o(239845);
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
      AppMethodBeat.i(239820);
      super.drawableStateChanged();
      boolean bool2 = false;
      int[] arrayOfInt = getDrawableState();
      boolean bool1 = bool2;
      if (this.bFV != null)
      {
        bool1 = bool2;
        if (this.bFV.isStateful()) {
          bool1 = this.bFV.setState(arrayOfInt) | false;
        }
      }
      if (bool1)
      {
        invalidate();
        TabLayout.this.invalidate();
      }
      AppMethodBeat.o(239820);
    }
    
    final int getContentWidth()
    {
      AppMethodBeat.i(239846);
      TextView localTextView = this.bFR;
      ImageView localImageView = this.bFS;
      View localView1 = this.bFK;
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
      AppMethodBeat.o(239846);
      return m - i;
    }
    
    final void l(TabLayout.e parame)
    {
      AppMethodBeat.i(239839);
      if (parame != this.bFQ)
      {
        this.bFQ = parame;
        update();
      }
      AppMethodBeat.o(239839);
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(239828);
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(239828);
    }
    
    @TargetApi(14)
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(239831);
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(239831);
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      int k = 1;
      AppMethodBeat.i(239837);
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
      if (this.bFR != null)
      {
        f2 = TabLayout.this.bEY;
        j = this.bFW;
        if ((this.bFS == null) || (this.bFS.getVisibility() != 0)) {
          break label297;
        }
        paramInt1 = 1;
        f1 = f2;
      }
      for (;;)
      {
        f2 = this.bFR.getTextSize();
        m = this.bFR.getLineCount();
        j = i.a(this.bFR);
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
                Layout localLayout = this.bFR.getLayout();
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
            this.bFR.setTextSize(0, f1);
            this.bFR.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
        AppMethodBeat.o(239837);
        return;
        label297:
        paramInt1 = j;
        f1 = f2;
        if (this.bFR != null)
        {
          paramInt1 = j;
          f1 = f2;
          if (this.bFR.getLineCount() > 1)
          {
            f1 = TabLayout.this.bEZ;
            paramInt1 = j;
          }
        }
      }
    }
    
    public final boolean performClick()
    {
      AppMethodBeat.i(239824);
      boolean bool = super.performClick();
      if (this.bFQ != null)
      {
        if (!bool) {
          playSoundEffect(0);
        }
        this.bFQ.xI();
        AppMethodBeat.o(239824);
        return true;
      }
      AppMethodBeat.o(239824);
      return bool;
    }
    
    final void reset()
    {
      AppMethodBeat.i(239840);
      l(null);
      setSelected(false);
      AppMethodBeat.o(239840);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(239826);
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
          sendAccessibilityEvent(4);
        }
        if (this.bFR != null) {
          this.bFR.setSelected(paramBoolean);
        }
        if (this.bFS != null) {
          this.bFS.setSelected(paramBoolean);
        }
        if (this.bFK != null) {
          this.bFK.setSelected(paramBoolean);
        }
        AppMethodBeat.o(239826);
        return;
      }
    }
    
    final void update()
    {
      AppMethodBeat.i(239842);
      TabLayout.e locale = this.bFQ;
      Object localObject;
      if (locale != null)
      {
        localObject = locale.bFK;
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
        this.bFK = ((View)localObject);
        if (this.bFR != null) {
          this.bFR.setVisibility(8);
        }
        if (this.bFS != null)
        {
          this.bFS.setVisibility(8);
          this.bFS.setImageDrawable(null);
        }
        this.bFT = ((TextView)((View)localObject).findViewById(16908308));
        if (this.bFT != null) {
          this.bFW = i.a(this.bFT);
        }
        this.bFU = ((ImageView)((View)localObject).findViewById(16908294));
        label146:
        if (this.bFK != null) {
          break label435;
        }
        if (this.bFS == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_icon, this, false);
          addView((View)localObject, 0);
          this.bFS = ((ImageView)localObject);
        }
        if ((locale == null) || (locale.bxV == null)) {
          break label430;
        }
        localObject = androidx.core.graphics.drawable.a.p(locale.bxV).mutate();
        label212:
        if (localObject != null)
        {
          androidx.core.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.bEU);
          if (TabLayout.this.bEX != null) {
            androidx.core.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.bEX);
          }
        }
        if (this.bFR == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_text, this, false);
          addView((View)localObject);
          this.bFR = ((TextView)localObject);
          this.bFW = i.a(this.bFR);
        }
        i.a(this.bFR, TabLayout.this.tabTextAppearance);
        if (TabLayout.this.bET != null) {
          this.bFR.setTextColor(TabLayout.this.bET);
        }
        a(this.bFR, this.bFS);
        label345:
        if ((locale != null) && (!TextUtils.isEmpty(locale.bFJ))) {
          setContentDescription(locale.bFJ);
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
        AppMethodBeat.o(239842);
        return;
        localObject = null;
        break;
        if (this.bFK != null)
        {
          removeView(this.bFK);
          this.bFK = null;
        }
        this.bFT = null;
        this.bFU = null;
        break label146;
        localObject = null;
        break label212;
        if ((this.bFT == null) && (this.bFU == null)) {
          break label345;
        }
        a(this.bFT, this.bFU);
        break label345;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout
 * JD-Core Version:    0.7.0.1
 */