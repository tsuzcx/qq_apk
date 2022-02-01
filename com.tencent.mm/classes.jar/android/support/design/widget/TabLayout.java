package android.support.design.widget;

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
import android.support.design.internal.f;
import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import android.support.v4.e.l.c;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.a;
import android.support.v4.view.ViewPager.c;
import android.support.v4.view.r;
import android.support.v4.view.t;
import android.support.v7.app.ActionBar.a;
import android.support.v7.widget.bb;
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
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout
  extends HorizontalScrollView
{
  private static final l.a<TabLayout.f> sh = new l.c(16);
  private int contentInsetStart;
  int mode;
  int sA = 2147483647;
  private final int sB;
  private final int sC;
  private final int sD;
  int sE;
  int sF;
  int sG;
  boolean sH;
  boolean sI;
  boolean sJ;
  private b sK;
  private final ArrayList<b> sL = new ArrayList();
  private b sM;
  private ValueAnimator sN;
  ViewPager sO;
  private android.support.v4.view.q sP;
  private DataSetObserver sQ;
  private TabLayout.g sR;
  private a sS;
  private boolean sT;
  private final l.a<h> sU = new l.b(12);
  private final ArrayList<TabLayout.f> si = new ArrayList();
  private TabLayout.f sj;
  private final RectF sk = new RectF();
  private final e sl;
  int sm;
  int sn;
  int so;
  int sq;
  int sr;
  ColorStateList ss;
  ColorStateList st;
  ColorStateList su;
  Drawable sv;
  PorterDuff.Mode sw;
  float sx;
  float sy;
  final int sz;
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969524);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.sl = new e(paramContext);
    super.addView(this.sl, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = f.a(paramContext, paramAttributeSet, android.support.design.a.a.TabLayout, paramInt, 2131821641, new int[] { 22 });
    this.sl.aj(localTypedArray.getDimensionPixelSize(10, -1));
    this.sl.ai(localTypedArray.getColor(7, 0));
    setSelectedTabIndicator(android.support.design.d.a.c(paramContext, localTypedArray, 5));
    setSelectedTabIndicatorGravity(localTypedArray.getInt(9, 0));
    setTabIndicatorFullWidth(localTypedArray.getBoolean(8, true));
    paramInt = localTypedArray.getDimensionPixelSize(15, 0);
    this.sq = paramInt;
    this.so = paramInt;
    this.sn = paramInt;
    this.sm = paramInt;
    this.sm = localTypedArray.getDimensionPixelSize(18, this.sm);
    this.sn = localTypedArray.getDimensionPixelSize(19, this.sn);
    this.so = localTypedArray.getDimensionPixelSize(17, this.so);
    this.sq = localTypedArray.getDimensionPixelSize(16, this.sq);
    this.sr = localTypedArray.getResourceId(22, 2131821393);
    paramAttributeSet = paramContext.obtainStyledAttributes(this.sr, android.support.v7.a.a.a.TextAppearance);
    try
    {
      this.sx = paramAttributeSet.getDimensionPixelSize(0, 0);
      this.ss = android.support.design.d.a.b(paramContext, paramAttributeSet, 3);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(23)) {
        this.ss = android.support.design.d.a.b(paramContext, localTypedArray, 23);
      }
      if (localTypedArray.hasValue(21))
      {
        paramInt = localTypedArray.getColor(21, 0);
        int i = this.ss.getDefaultColor();
        this.ss = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt, i });
      }
      this.st = android.support.design.d.a.b(paramContext, localTypedArray, 3);
      this.sw = android.support.design.internal.g.a(localTypedArray.getInt(4, -1), null);
      this.su = android.support.design.d.a.b(paramContext, localTypedArray, 20);
      this.sF = localTypedArray.getInt(6, 300);
      this.sB = localTypedArray.getDimensionPixelSize(13, -1);
      this.sC = localTypedArray.getDimensionPixelSize(12, -1);
      this.sz = localTypedArray.getResourceId(0, 0);
      this.contentInsetStart = localTypedArray.getDimensionPixelSize(1, 0);
      this.mode = localTypedArray.getInt(14, 1);
      this.sE = localTypedArray.getInt(2, 0);
      this.sH = localTypedArray.getBoolean(11, false);
      this.sJ = localTypedArray.getBoolean(24, false);
      localTypedArray.recycle();
      paramContext = getResources();
      this.sy = paramContext.getDimensionPixelSize(2131166134);
      this.sD = paramContext.getDimensionPixelSize(2131166132);
      cJ();
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private h a(TabLayout.f paramf)
  {
    if (this.sU != null) {}
    h localh2;
    for (h localh1 = (h)this.sU.acquire();; localh1 = null)
    {
      localh2 = localh1;
      if (localh1 == null) {
        localh2 = new h(getContext());
      }
      localh2.i(paramf);
      localh2.setFocusable(true);
      localh2.setMinimumWidth(getTabMinWidth());
      if (!TextUtils.isEmpty(paramf.tj)) {
        break;
      }
      localh2.setContentDescription(paramf.text);
      return localh2;
    }
    localh2.setContentDescription(paramf.tj);
    return localh2;
  }
  
  private void a(TabItem paramTabItem)
  {
    TabLayout.f localf = cE();
    if (paramTabItem.text != null) {
      localf.d(paramTabItem.text);
    }
    if (paramTabItem.icon != null)
    {
      localf.icon = paramTabItem.icon;
      localf.cL();
    }
    if (paramTabItem.sg != 0) {
      localf.ak(paramTabItem.sg);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription()))
    {
      localf.tj = paramTabItem.getContentDescription();
      localf.cL();
    }
    a(localf, this.si.isEmpty());
  }
  
  private void a(TabLayout.f paramf, int paramInt)
  {
    paramf.position = paramInt;
    this.si.add(paramInt, paramf);
    int i = this.si.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((TabLayout.f)this.si.get(paramInt)).position = paramInt;
      paramInt += 1;
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mode == 1) && (this.sE == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private void ah(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (t.ay(this)))
    {
      e locale = this.sl;
      j = locale.getChildCount();
      i = 0;
      if (i >= j) {
        break label70;
      }
      if (locale.getChildAt(i).getWidth() > 0) {
        break label63;
      }
    }
    label63:
    label70:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label75;
      }
      setScrollPosition$4867b5c2(paramInt);
      return;
      i += 1;
      break;
    }
    label75:
    i = getScrollX();
    int j = b(paramInt, 0.0F);
    if (i != j)
    {
      cI();
      this.sN.setIntValues(new int[] { i, j });
      this.sN.start();
    }
    this.sl.k(paramInt, this.sF);
  }
  
  private int b(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (this.mode == 0)
    {
      localView2 = this.sl.getChildAt(paramInt);
      if (paramInt + 1 >= this.sl.getChildCount()) {
        break label116;
      }
      localView1 = this.sl.getChildAt(paramInt + 1);
      if (localView2 == null) {
        break label122;
      }
    }
    label116:
    label122:
    for (paramInt = localView2.getWidth();; paramInt = 0)
    {
      i = j;
      if (localView1 != null) {
        i = localView1.getWidth();
      }
      j = localView2.getLeft() + paramInt / 2 - getWidth() / 2;
      paramInt = (int)((i + paramInt) * 0.5F * paramFloat);
      if (t.Y(this) != 0) {
        break label127;
      }
      i = paramInt + j;
      return i;
      localView1 = null;
      break;
    }
    label127:
    return j - paramInt;
  }
  
  private void b(b paramb)
  {
    this.sL.remove(paramb);
  }
  
  private void c(TabLayout.f paramf)
  {
    int i = this.sL.size() - 1;
    while (i >= 0)
    {
      ((b)this.sL.get(i)).f(paramf);
      i -= 1;
    }
  }
  
  private static TabLayout.f cF()
  {
    TabLayout.f localf2 = (TabLayout.f)sh.acquire();
    TabLayout.f localf1 = localf2;
    if (localf2 == null) {
      localf1 = new TabLayout.f();
    }
    return localf1;
  }
  
  private void cH()
  {
    int j = this.si.size();
    int i = 0;
    while (i < j)
    {
      ((TabLayout.f)this.si.get(i)).cL();
      i += 1;
    }
  }
  
  private void cI()
  {
    if (this.sN == null)
    {
      this.sN = new ValueAnimator();
      this.sN.setInterpolator(android.support.design.a.a.eQ);
      this.sN.setDuration(this.sF);
      this.sN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
        }
      });
    }
  }
  
  private void cJ()
  {
    if (this.mode == 0) {}
    for (int i = Math.max(0, this.contentInsetStart - this.sm);; i = 0)
    {
      t.d(this.sl, i, 0, 0, 0);
      switch (this.mode)
      {
      }
      for (;;)
      {
        x(true);
        return;
        this.sl.setGravity(1);
        continue;
        this.sl.setGravity(8388611);
      }
    }
  }
  
  private void d(TabLayout.f paramf)
  {
    int i = this.sL.size() - 1;
    while (i >= 0)
    {
      ((b)this.sL.get(i)).g(paramf);
      i -= 1;
    }
  }
  
  private void e(TabLayout.f paramf)
  {
    int i = this.sL.size() - 1;
    while (i >= 0)
    {
      ((b)this.sL.get(i)).h(paramf);
      i -= 1;
    }
  }
  
  private int getDefaultHeight()
  {
    int j = this.si.size();
    int i = 0;
    if (i < j)
    {
      TabLayout.f localf = (TabLayout.f)this.si.get(i);
      if ((localf == null) || (localf.icon == null) || (TextUtils.isEmpty(localf.text))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (!this.sH))
      {
        return 72;
        i += 1;
        break;
      }
      return 48;
    }
  }
  
  private int getTabMinWidth()
  {
    if (this.sB != -1) {
      return this.sB;
    }
    if (this.mode == 0) {
      return this.sD;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.sl.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void removeAllTabs()
  {
    int i = this.sl.getChildCount() - 1;
    while (i >= 0)
    {
      localObject = (h)this.sl.getChildAt(i);
      this.sl.removeViewAt(i);
      if (localObject != null)
      {
        ((h)localObject).i(null);
        ((h)localObject).setSelected(false);
        this.sU.release(localObject);
      }
      requestLayout();
      i -= 1;
    }
    Object localObject = this.si.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabLayout.f localf = (TabLayout.f)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      localf.tl = null;
      localf.tm = null;
      localf.tag = null;
      localf.icon = null;
      localf.text = null;
      localf.tj = null;
      localf.position = -1;
      localf.tk = null;
      sh.release(localf);
    }
    this.sj = null;
  }
  
  private void setScrollPosition$4867b5c2(int paramInt)
  {
    a(paramInt, 0.0F, true, true);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = this.sl.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.sl.getChildAt(i);
        if (i == paramInt)
        {
          bool = true;
          label38:
          localView.setSelected(bool);
          if (i != paramInt) {
            break label73;
          }
        }
        label73:
        for (boolean bool = true;; bool = false)
        {
          localView.setActivated(bool);
          i += 1;
          break;
          bool = false;
          break label38;
        }
      }
    }
  }
  
  private void y(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      a((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramInt + paramFloat);
    if ((i < 0) || (i >= this.sl.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.sl.c(paramInt, paramFloat);
      }
      if ((this.sN != null) && (this.sN.isRunning())) {
        this.sN.cancel();
      }
      scrollTo(b(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    setSelectedTabView(i);
  }
  
  public final void a(b paramb)
  {
    if (!this.sL.contains(paramb)) {
      this.sL.add(paramb);
    }
  }
  
  public final void a(TabLayout.f paramf, boolean paramBoolean)
  {
    int i = this.si.size();
    if (paramf.tl != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramf, i);
    h localh = paramf.tm;
    e locale = this.sl;
    i = paramf.position;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    locale.addView(localh, i, localLayoutParams);
    if (paramBoolean) {
      paramf.select();
    }
  }
  
  public final void a(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.sO != null)
    {
      if (this.sR != null) {
        this.sO.removeOnPageChangeListener(this.sR);
      }
      if (this.sS != null) {
        this.sO.removeOnAdapterChangeListener(this.sS);
      }
    }
    if (this.sM != null)
    {
      b(this.sM);
      this.sM = null;
    }
    if (paramViewPager != null)
    {
      this.sO = paramViewPager;
      if (this.sR == null) {
        this.sR = new TabLayout.g(this);
      }
      this.sR.reset();
      paramViewPager.addOnPageChangeListener(this.sR);
      this.sM = new TabLayout.i(paramViewPager);
      a(this.sM);
      android.support.v4.view.q localq = paramViewPager.getAdapter();
      if (localq != null) {
        a(localq, paramBoolean1);
      }
      if (this.sS == null) {
        this.sS = new a();
      }
      this.sS.sW = paramBoolean1;
      paramViewPager.addOnAdapterChangeListener(this.sS);
      setScrollPosition$4867b5c2(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.sT = paramBoolean2;
      return;
      this.sO = null;
      a(null, false);
    }
  }
  
  final void a(android.support.v4.view.q paramq, boolean paramBoolean)
  {
    if ((this.sP != null) && (this.sQ != null)) {
      this.sP.unregisterDataSetObserver(this.sQ);
    }
    this.sP = paramq;
    if ((paramBoolean) && (paramq != null))
    {
      if (this.sQ == null) {
        this.sQ = new d();
      }
      paramq.registerDataSetObserver(this.sQ);
    }
    cG();
  }
  
  public final TabLayout.f ad(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount())) {
      return null;
    }
    return (TabLayout.f)this.si.get(paramInt);
  }
  
  public void addView(View paramView)
  {
    y(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    y(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    y(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    y(paramView);
  }
  
  final int ag(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  final void b(TabLayout.f paramf)
  {
    b(paramf, true);
  }
  
  final void b(TabLayout.f paramf, boolean paramBoolean)
  {
    TabLayout.f localf = this.sj;
    if (localf == paramf)
    {
      if (localf != null)
      {
        e(paramf);
        ah(paramf.position);
      }
      return;
    }
    int i;
    if (paramf != null)
    {
      i = paramf.position;
      label40:
      if (paramBoolean)
      {
        if (((localf != null) && (localf.position != -1)) || (i == -1)) {
          break label109;
        }
        setScrollPosition$4867b5c2(i);
      }
    }
    for (;;)
    {
      if (i != -1) {
        setSelectedTabView(i);
      }
      this.sj = paramf;
      if (localf != null) {
        d(localf);
      }
      if (paramf == null) {
        break;
      }
      c(paramf);
      return;
      i = -1;
      break label40;
      label109:
      ah(i);
    }
  }
  
  public final TabLayout.f cE()
  {
    TabLayout.f localf = cF();
    localf.tl = this;
    localf.tm = a(localf);
    return localf;
  }
  
  final void cG()
  {
    removeAllTabs();
    if (this.sP != null)
    {
      int j = this.sP.getCount();
      int i = 0;
      while (i < j)
      {
        a(cE().d(this.sP.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.sO != null) && (j > 0))
      {
        i = this.sO.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          b(ad(i), true);
        }
      }
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    if (this.sj != null) {
      return this.sj.position;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.si.size();
  }
  
  public int getTabGravity()
  {
    return this.sE;
  }
  
  public ColorStateList getTabIconTint()
  {
    return this.st;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.sG;
  }
  
  int getTabMaxWidth()
  {
    return this.sA;
  }
  
  public int getTabMode()
  {
    return this.mode;
  }
  
  public ColorStateList getTabRippleColor()
  {
    return this.su;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return this.sv;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.ss;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.sO == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        a((ViewPager)localViewParent, true, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.sT)
    {
      setupWithViewPager(null);
      this.sT = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.sl.getChildCount())
    {
      View localView = this.sl.getChildAt(i);
      if ((localView instanceof h)) {
        h.a((h)localView, paramCanvas);
      }
      i += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = ag(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    label76:
    View localView;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.sC > 0)
        {
          i = this.sC;
          this.sA = i;
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
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
      break;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      break;
      i -= ag(56);
      break label76;
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
    if (this.sH != paramBoolean)
    {
      this.sH = paramBoolean;
      int i = 0;
      if (i < this.sl.getChildCount())
      {
        Object localObject = this.sl.getChildAt(i);
        int j;
        if ((localObject instanceof h))
        {
          localObject = (h)localObject;
          if (!((h)localObject).sV.sH) {
            break label108;
          }
          j = 0;
          label64:
          ((h)localObject).setOrientation(j);
          if ((((h)localObject).tt == null) && (((h)localObject).tu == null)) {
            break label113;
          }
          ((h)localObject).a(((h)localObject).tt, ((h)localObject).tu);
        }
        for (;;)
        {
          i += 1;
          break;
          label108:
          j = 1;
          break label64;
          label113:
          ((h)localObject).a(((h)localObject).tr, ((h)localObject).ts);
        }
      }
      cJ();
    }
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(b paramb)
  {
    if (this.sK != null) {
      b(this.sK);
    }
    this.sK = paramb;
    if (paramb != null) {
      a(paramb);
    }
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    cI();
    this.sN.addListener(paramAnimatorListener);
  }
  
  public void setSelectedTabIndicator(int paramInt)
  {
    if (paramInt != 0)
    {
      setSelectedTabIndicator(android.support.v7.c.a.a.l(getContext(), paramInt));
      return;
    }
    setSelectedTabIndicator(null);
  }
  
  public void setSelectedTabIndicator(Drawable paramDrawable)
  {
    if (this.sv != paramDrawable)
    {
      this.sv = paramDrawable;
      t.W(this.sl);
    }
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.sl.ai(paramInt);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.sG != paramInt)
    {
      this.sG = paramInt;
      t.W(this.sl);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.sl.aj(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.sE != paramInt)
    {
      this.sE = paramInt;
      cJ();
    }
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    if (this.st != paramColorStateList)
    {
      this.st = paramColorStateList;
      cH();
    }
  }
  
  public void setTabIconTintResource(int paramInt)
  {
    setTabIconTint(android.support.v7.c.a.a.m(getContext(), paramInt));
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.sI = paramBoolean;
    t.W(this.sl);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      cJ();
    }
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    if (this.su != paramColorStateList)
    {
      this.su = paramColorStateList;
      int i = 0;
      while (i < this.sl.getChildCount())
      {
        paramColorStateList = this.sl.getChildAt(i);
        if ((paramColorStateList instanceof h)) {
          h.a((h)paramColorStateList, getContext());
        }
        i += 1;
      }
    }
  }
  
  public void setTabRippleColorResource(int paramInt)
  {
    setTabRippleColor(android.support.v7.c.a.a.m(getContext(), paramInt));
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.ss != paramColorStateList)
    {
      this.ss = paramColorStateList;
      cH();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(android.support.v4.view.q paramq)
  {
    a(paramq, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.sJ != paramBoolean)
    {
      this.sJ = paramBoolean;
      int i = 0;
      while (i < this.sl.getChildCount())
      {
        View localView = this.sl.getChildAt(i);
        if ((localView instanceof h)) {
          h.a((h)localView, getContext());
        }
        i += 1;
      }
    }
  }
  
  public void setUnboundedRippleResource(int paramInt)
  {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    a(paramViewPager, true, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }
  
  final void x(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.sl.getChildCount())
    {
      View localView = this.sl.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
  }
  
  final class a
    implements ViewPager.c
  {
    boolean sW;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, android.support.v4.view.q paramq1, android.support.v4.view.q paramq2)
    {
      if (TabLayout.this.sO == paramViewPager) {
        TabLayout.this.a(paramq2, this.sW);
      }
    }
  }
  
  public static abstract interface b<T extends TabLayout.f>
  {
    public abstract void f(T paramT);
    
    public abstract void g(T paramT);
    
    public abstract void h(T paramT);
  }
  
  final class d
    extends DataSetObserver
  {
    d() {}
    
    public final void onChanged()
    {
      TabLayout.this.cG();
    }
    
    public final void onInvalidated()
    {
      TabLayout.this.cG();
    }
  }
  
  final class e
    extends LinearLayout
  {
    private int indicatorLeft = -1;
    private int indicatorRight = -1;
    private int layoutDirection = -1;
    private int sX;
    private final Paint sY;
    private final GradientDrawable sZ;
    int ta = -1;
    float tb;
    private ValueAnimator tc;
    
    e(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      this.sY = new Paint();
      this.sZ = new GradientDrawable();
    }
    
    private void a(TabLayout.h paramh, RectF paramRectF)
    {
      int j = paramh.getContentWidth();
      int i = j;
      if (j < TabLayout.this.ag(24)) {
        i = TabLayout.this.ag(24);
      }
      j = (paramh.getLeft() + paramh.getRight()) / 2;
      int k = i / 2;
      i /= 2;
      paramRectF.set(j - k, 0.0F, i + j, 0.0F);
    }
    
    private void cK()
    {
      View localView = getChildAt(this.ta);
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
        if (!TabLayout.this.sI)
        {
          i = m;
          j = k;
          if ((localView instanceof TabLayout.h))
          {
            a((TabLayout.h)localView, TabLayout.a(TabLayout.this));
            j = (int)TabLayout.a(TabLayout.this).left;
            i = (int)TabLayout.a(TabLayout.this).right;
          }
        }
        k = i;
        m = j;
        if (this.tb > 0.0F)
        {
          k = i;
          m = j;
          if (this.ta < getChildCount() - 1)
          {
            localView = getChildAt(this.ta + 1);
            m = localView.getLeft();
            k = localView.getRight();
            if ((TabLayout.this.sI) || (!(localView instanceof TabLayout.h))) {
              break label311;
            }
            a((TabLayout.h)localView, TabLayout.a(TabLayout.this));
            m = (int)TabLayout.a(TabLayout.this).left;
            k = (int)TabLayout.a(TabLayout.this).right;
          }
        }
      }
      label311:
      for (;;)
      {
        float f1 = this.tb;
        float f2 = m;
        float f3 = this.tb;
        m = (int)(j * (1.0F - f3) + f1 * f2);
        f1 = this.tb;
        f2 = k;
        f3 = this.tb;
        k = (int)(f2 * f1 + i * (1.0F - f3));
        for (;;)
        {
          j(m, k);
          return;
          k = -1;
          m = -1;
        }
      }
    }
    
    final void ai(int paramInt)
    {
      if (this.sY.getColor() != paramInt)
      {
        this.sY.setColor(paramInt);
        t.W(this);
      }
    }
    
    final void aj(int paramInt)
    {
      if (this.sX != paramInt)
      {
        this.sX = paramInt;
        t.W(this);
      }
    }
    
    final void c(int paramInt, float paramFloat)
    {
      if ((this.tc != null) && (this.tc.isRunning())) {
        this.tc.cancel();
      }
      this.ta = paramInt;
      this.tb = paramFloat;
      cK();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (TabLayout.this.sv != null) {}
      for (int i = TabLayout.this.sv.getIntrinsicHeight();; i = 0)
      {
        if (this.sX >= 0) {
          i = this.sX;
        }
        int j;
        Object localObject;
        switch (TabLayout.this.sG)
        {
        default: 
          i = 0;
          j = 0;
          if ((this.indicatorLeft >= 0) && (this.indicatorRight > this.indicatorLeft))
          {
            if (TabLayout.this.sv == null) {
              break label238;
            }
            localObject = TabLayout.this.sv;
            label113:
            localObject = android.support.v4.graphics.drawable.a.i((Drawable)localObject);
            ((Drawable)localObject).setBounds(this.indicatorLeft, j, this.indicatorRight, i);
            if (this.sY != null)
            {
              if (Build.VERSION.SDK_INT != 21) {
                break label247;
              }
              ((Drawable)localObject).setColorFilter(this.sY.getColor(), PorterDuff.Mode.SRC_IN);
            }
          }
          break;
        }
        for (;;)
        {
          ((Drawable)localObject).draw(paramCanvas);
          super.draw(paramCanvas);
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
          label238:
          localObject = this.sZ;
          break label113;
          label247:
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.sY.getColor());
        }
      }
    }
    
    final void j(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.indicatorLeft) || (paramInt2 != this.indicatorRight))
      {
        this.indicatorLeft = paramInt1;
        this.indicatorRight = paramInt2;
        t.W(this);
      }
    }
    
    final void k(final int paramInt1, int paramInt2)
    {
      if ((this.tc != null) && (this.tc.isRunning())) {
        this.tc.cancel();
      }
      Object localObject = getChildAt(paramInt1);
      if (localObject == null) {
        cK();
      }
      final int k;
      final int m;
      final int j;
      final int i;
      do
      {
        return;
        k = ((View)localObject).getLeft();
        m = ((View)localObject).getRight();
        j = k;
        i = m;
        if (!TabLayout.this.sI)
        {
          j = k;
          i = m;
          if ((localObject instanceof TabLayout.h))
          {
            a((TabLayout.h)localObject, TabLayout.a(TabLayout.this));
            j = (int)TabLayout.a(TabLayout.this).left;
            i = (int)TabLayout.a(TabLayout.this).right;
          }
        }
        k = this.indicatorLeft;
        m = this.indicatorRight;
      } while ((k == j) && (m == i));
      localObject = new ValueAnimator();
      this.tc = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setInterpolator(android.support.design.a.a.eQ);
      ((ValueAnimator)localObject).setDuration(paramInt2);
      ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = paramAnonymousValueAnimator.getAnimatedFraction();
          TabLayout.e.this.j(android.support.design.a.a.b(k, j, f), android.support.design.a.a.b(m, i, f));
        }
      });
      ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          TabLayout.e.this.ta = paramInt1;
          TabLayout.e.this.tb = 0.0F;
        }
      });
      ((ValueAnimator)localObject).start();
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.tc != null) && (this.tc.isRunning()))
      {
        this.tc.cancel();
        long l = this.tc.getDuration();
        paramInt1 = this.ta;
        float f = this.tc.getAnimatedFraction();
        k(paramInt1, Math.round((float)l * (1.0F - f)));
        return;
      }
      cK();
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
        break label16;
      }
      label16:
      while ((TabLayout.this.mode != 1) || (TabLayout.this.sE != 1)) {
        return;
      }
      int n = getChildCount();
      int k = 0;
      int j = 0;
      label51:
      Object localObject;
      if (k < n)
      {
        localObject = getChildAt(k);
        if (((View)localObject).getVisibility() != 0) {
          break label235;
        }
      }
      label133:
      label220:
      label232:
      label235:
      for (int i = Math.max(j, ((View)localObject).getMeasuredWidth());; i = j)
      {
        k += 1;
        j = i;
        break label51;
        if (j <= 0) {
          break;
        }
        i = TabLayout.this.ag(16);
        int m;
        if (j * n <= getMeasuredWidth() - i * 2)
        {
          i = 0;
          k = 0;
          m = i;
          if (k >= n) {
            break label220;
          }
          localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width == j) && (((LinearLayout.LayoutParams)localObject).weight == 0.0F)) {
            break label232;
          }
          ((LinearLayout.LayoutParams)localObject).width = j;
          ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
          i = 1;
        }
        for (;;)
        {
          k += 1;
          break label133;
          TabLayout.this.sE = 0;
          TabLayout.this.x(false);
          m = 1;
          if (m == 0) {
            break;
          }
          super.onMeasure(paramInt1, paramInt2);
          return;
        }
      }
    }
    
    public final void onRtlPropertiesChanged(int paramInt)
    {
      super.onRtlPropertiesChanged(paramInt);
      if ((Build.VERSION.SDK_INT < 23) && (this.layoutDirection != paramInt))
      {
        requestLayout();
        this.layoutDirection = paramInt;
      }
    }
  }
  
  final class h
    extends LinearLayout
  {
    private View tk;
    private TabLayout.f tq;
    TextView tr;
    ImageView ts;
    TextView tt;
    ImageView tu;
    private Drawable tv;
    private int tw = 2;
    
    public h(Context paramContext)
    {
      super();
      I(paramContext);
      t.d(this, TabLayout.this.sm, TabLayout.this.sn, TabLayout.this.so, TabLayout.this.sq);
      setGravity(17);
      if (TabLayout.this.sH) {}
      for (int i = 0;; i = 1)
      {
        setOrientation(i);
        setClickable(true);
        t.a(this, r.W(getContext()));
        return;
      }
    }
    
    private void I(Context paramContext)
    {
      Object localObject = null;
      GradientDrawable localGradientDrawable;
      ColorStateList localColorStateList;
      if (TabLayout.this.sz != 0)
      {
        this.tv = android.support.v7.c.a.a.l(paramContext, TabLayout.this.sz);
        if ((this.tv != null) && (this.tv.isStateful())) {
          this.tv.setState(getDrawableState());
        }
        localGradientDrawable = new GradientDrawable();
        ((GradientDrawable)localGradientDrawable).setColor(0);
        paramContext = localGradientDrawable;
        if (TabLayout.this.su != null)
        {
          paramContext = new GradientDrawable();
          paramContext.setCornerRadius(1.0E-005F);
          paramContext.setColor(-1);
          localColorStateList = android.support.design.e.a.b(TabLayout.this.su);
          if (Build.VERSION.SDK_INT < 21) {
            break label183;
          }
          if (TabLayout.this.sJ) {
            localGradientDrawable = null;
          }
          if (!TabLayout.this.sJ) {
            break label180;
          }
          paramContext = localObject;
        }
      }
      label147:
      for (paramContext = new RippleDrawable(localColorStateList, localGradientDrawable, paramContext);; paramContext = new LayerDrawable(new Drawable[] { localGradientDrawable, paramContext }))
      {
        t.a(this, paramContext);
        TabLayout.this.invalidate();
        return;
        this.tv = null;
        break;
        label180:
        break label147;
        label183:
        paramContext = android.support.v4.graphics.drawable.a.i(paramContext);
        android.support.v4.graphics.drawable.a.a(paramContext, localColorStateList);
      }
    }
    
    final void a(TextView paramTextView, ImageView paramImageView)
    {
      Object localObject = null;
      Drawable localDrawable;
      CharSequence localCharSequence;
      label51:
      label76:
      int i;
      if ((this.tq != null) && (this.tq.icon != null))
      {
        localDrawable = android.support.v4.graphics.drawable.a.i(this.tq.icon).mutate();
        if (this.tq == null) {
          break label217;
        }
        localCharSequence = this.tq.text;
        if (paramImageView != null)
        {
          if (localDrawable == null) {
            break label223;
          }
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
        }
        if (TextUtils.isEmpty(localCharSequence)) {
          break label237;
        }
        i = 1;
        label86:
        if (paramTextView != null)
        {
          if (i == 0) {
            break label242;
          }
          paramTextView.setText(localCharSequence);
          paramTextView.setVisibility(0);
          setVisibility(0);
        }
        label110:
        if (paramImageView != null)
        {
          paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
          if ((i == 0) || (paramImageView.getVisibility() != 0)) {
            break label296;
          }
        }
      }
      label288:
      label293:
      label296:
      for (int j = TabLayout.this.ag(8);; j = 0)
      {
        if (TabLayout.this.sH)
        {
          if (j != android.support.v4.view.g.b(paramTextView))
          {
            android.support.v4.view.g.a(paramTextView, j);
            paramTextView.bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
          label183:
          if (this.tq == null) {
            break label288;
          }
          paramTextView = this.tq.tj;
          label198:
          if (i == 0) {
            break label293;
          }
          paramTextView = localObject;
        }
        for (;;)
        {
          bb.a(this, paramTextView);
          return;
          localDrawable = null;
          break;
          label217:
          localCharSequence = null;
          break label51;
          label223:
          paramImageView.setVisibility(8);
          paramImageView.setImageDrawable(null);
          break label76;
          label237:
          i = 0;
          break label86;
          label242:
          paramTextView.setVisibility(8);
          paramTextView.setText(null);
          break label110;
          if (j == paramTextView.bottomMargin) {
            break label183;
          }
          paramTextView.bottomMargin = j;
          android.support.v4.view.g.a(paramTextView, 0);
          paramImageView.setLayoutParams(paramTextView);
          paramImageView.requestLayout();
          break label183;
          paramTextView = null;
          break label198;
        }
      }
    }
    
    protected final void drawableStateChanged()
    {
      super.drawableStateChanged();
      boolean bool2 = false;
      int[] arrayOfInt = getDrawableState();
      boolean bool1 = bool2;
      if (this.tv != null)
      {
        bool1 = bool2;
        if (this.tv.isStateful()) {
          bool1 = this.tv.setState(arrayOfInt) | false;
        }
      }
      if (bool1)
      {
        invalidate();
        TabLayout.this.invalidate();
      }
    }
    
    final int getContentWidth()
    {
      TextView localTextView = this.tr;
      ImageView localImageView = this.ts;
      View localView1 = this.tk;
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
              break label143;
            }
            i = Math.min(i, localView2.getLeft());
            label102:
            if (j == 0) {
              break label152;
            }
          }
        }
        label143:
        label152:
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
          break label102;
        }
      }
      return m - i;
    }
    
    final void i(TabLayout.f paramf)
    {
      if (paramf != this.tq)
      {
        this.tq = paramf;
        update();
      }
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
    }
    
    @TargetApi(14)
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      int k = 1;
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
          i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.sA, -2147483648);
        }
      }
      super.onMeasure(i, paramInt2);
      float f2;
      float f1;
      if (this.tr != null)
      {
        f2 = TabLayout.this.sx;
        j = this.tw;
        if ((this.ts == null) || (this.ts.getVisibility() != 0)) {
          break label285;
        }
        paramInt1 = 1;
        f1 = f2;
      }
      for (;;)
      {
        f2 = this.tr.getTextSize();
        m = this.tr.getLineCount();
        j = android.support.v4.widget.q.b(this.tr);
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
                Layout localLayout = this.tr.getLayout();
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
            this.tr.setTextSize(0, f1);
            this.tr.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
        return;
        label285:
        paramInt1 = j;
        f1 = f2;
        if (this.tr != null)
        {
          paramInt1 = j;
          f1 = f2;
          if (this.tr.getLineCount() > 1)
          {
            f1 = TabLayout.this.sy;
            paramInt1 = j;
          }
        }
      }
    }
    
    public final boolean performClick()
    {
      boolean bool2 = super.performClick();
      boolean bool1 = bool2;
      if (this.tq != null)
      {
        if (!bool2) {
          playSoundEffect(0);
        }
        this.tq.select();
        bool1 = true;
      }
      return bool1;
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
          sendAccessibilityEvent(4);
        }
        if (this.tr != null) {
          this.tr.setSelected(paramBoolean);
        }
        if (this.ts != null) {
          this.ts.setSelected(paramBoolean);
        }
        if (this.tk != null) {
          this.tk.setSelected(paramBoolean);
        }
        return;
      }
    }
    
    final void update()
    {
      TabLayout.f localf = this.tq;
      Object localObject;
      if (localf != null)
      {
        localObject = localf.tk;
        if (localObject == null) {
          break label385;
        }
        ViewParent localViewParent = ((View)localObject).getParent();
        if (localViewParent != this)
        {
          if (localViewParent != null) {
            ((ViewGroup)localViewParent).removeView((View)localObject);
          }
          addView((View)localObject);
        }
        this.tk = ((View)localObject);
        if (this.tr != null) {
          this.tr.setVisibility(8);
        }
        if (this.ts != null)
        {
          this.ts.setVisibility(8);
          this.ts.setImageDrawable(null);
        }
        this.tt = ((TextView)((View)localObject).findViewById(16908308));
        if (this.tt != null) {
          this.tw = android.support.v4.widget.q.b(this.tt);
        }
        this.tu = ((ImageView)((View)localObject).findViewById(16908294));
        label140:
        if (this.tk != null) {
          break label423;
        }
        if (this.ts == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(2131493696, this, false);
          addView((View)localObject, 0);
          this.ts = ((ImageView)localObject);
        }
        if ((localf == null) || (localf.icon == null)) {
          break label418;
        }
        localObject = android.support.v4.graphics.drawable.a.i(localf.icon).mutate();
        label206:
        if (localObject != null)
        {
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.st);
          if (TabLayout.this.sw != null) {
            android.support.v4.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.sw);
          }
        }
        if (this.tr == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(2131493697, this, false);
          addView((View)localObject);
          this.tr = ((TextView)localObject);
          this.tw = android.support.v4.widget.q.b(this.tr);
        }
        android.support.v4.widget.q.d(this.tr, TabLayout.this.sr);
        if (TabLayout.this.ss != null) {
          this.tr.setTextColor(TabLayout.this.ss);
        }
        a(this.tr, this.ts);
        label339:
        if ((localf != null) && (!TextUtils.isEmpty(localf.tj))) {
          setContentDescription(localf.tj);
        }
        if ((localf == null) || (!localf.isSelected())) {
          break label452;
        }
      }
      label385:
      label418:
      label423:
      label452:
      for (boolean bool = true;; bool = false)
      {
        setSelected(bool);
        return;
        localObject = null;
        break;
        if (this.tk != null)
        {
          removeView(this.tk);
          this.tk = null;
        }
        this.tt = null;
        this.tu = null;
        break label140;
        localObject = null;
        break label206;
        if ((this.tt == null) && (this.tu == null)) {
          break label339;
        }
        a(this.tt, this.tu);
        break label339;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.TabLayout
 * JD-Core Version:    0.7.0.1
 */