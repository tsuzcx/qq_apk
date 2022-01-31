package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.v4.e.k.a;
import android.support.v4.e.k.b;
import android.support.v4.e.k.c;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.a;
import android.support.v4.view.q;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout
  extends HorizontalScrollView
{
  private static final k.a<TabLayout.e> lc = new k.c(16);
  private q lA;
  private DataSetObserver lB;
  private TabLayout.f lC;
  private TabLayout.a lD;
  private boolean lE;
  private final k.a<TabLayout.g> lF = new k.b(12);
  private final ArrayList<TabLayout.e> ld = new ArrayList();
  private TabLayout.e le;
  private final TabLayout.d lf;
  int lg;
  int lh;
  int li;
  int lj;
  int lk;
  ColorStateList ll;
  float lm;
  float ln;
  final int lo;
  int lp = 2147483647;
  private final int lq;
  private final int lr;
  private final int ls;
  private int lt;
  int lu;
  private TabLayout.b lv;
  private final ArrayList<TabLayout.b> lw = new ArrayList();
  private TabLayout.b lx;
  private ValueAnimator ly;
  ViewPager lz;
  int mMode;
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    n.F(paramContext);
    setHorizontalScrollBarEnabled(false);
    this.lf = new TabLayout.d(this, paramContext);
    super.addView(this.lf, 0, new FrameLayout.LayoutParams(-2, -1));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.design.a.a.TabLayout, paramInt, 2131492869);
    this.lf.O(paramAttributeSet.getDimensionPixelSize(1, 0));
    this.lf.N(paramAttributeSet.getColor(0, 0));
    paramInt = paramAttributeSet.getDimensionPixelSize(15, 0);
    this.lj = paramInt;
    this.li = paramInt;
    this.lh = paramInt;
    this.lg = paramInt;
    this.lg = paramAttributeSet.getDimensionPixelSize(11, this.lg);
    this.lh = paramAttributeSet.getDimensionPixelSize(12, this.lh);
    this.li = paramAttributeSet.getDimensionPixelSize(13, this.li);
    this.lj = paramAttributeSet.getDimensionPixelSize(14, this.lj);
    this.lk = paramAttributeSet.getResourceId(8, 2131493658);
    paramContext = paramContext.obtainStyledAttributes(this.lk, android.support.v7.a.a.a.TextAppearance);
    try
    {
      this.lm = paramContext.getDimensionPixelSize(0, 0);
      this.ll = paramContext.getColorStateList(3);
      paramContext.recycle();
      if (paramAttributeSet.hasValue(9)) {
        this.ll = paramAttributeSet.getColorStateList(9);
      }
      if (paramAttributeSet.hasValue(10))
      {
        paramInt = paramAttributeSet.getColor(10, 0);
        int i = this.ll.getDefaultColor();
        this.ll = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt, i });
      }
      this.lq = paramAttributeSet.getDimensionPixelSize(6, -1);
      this.lr = paramAttributeSet.getDimensionPixelSize(7, -1);
      this.lo = paramAttributeSet.getResourceId(3, 0);
      this.lt = paramAttributeSet.getDimensionPixelSize(2, 0);
      this.mMode = paramAttributeSet.getInt(4, 1);
      this.lu = paramAttributeSet.getInt(5, 0);
      paramAttributeSet.recycle();
      paramContext = getResources();
      this.ln = paramContext.getDimensionPixelSize(2131428306);
      this.ls = paramContext.getDimensionPixelSize(2131427393);
      bH();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void M(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (t.as(this)))
    {
      TabLayout.d locald = this.lf;
      j = locald.getChildCount();
      i = 0;
      if (i >= j) {
        break label70;
      }
      if (locald.getChildAt(i).getWidth() > 0) {
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
      bG();
      this.ly.setIntValues(new int[] { i, j });
      this.ly.start();
    }
    this.lf.j(paramInt, 300);
  }
  
  private TabLayout.g a(TabLayout.e parame)
  {
    if (this.lF != null) {}
    for (TabLayout.g localg1 = (TabLayout.g)this.lF.acquire();; localg1 = null)
    {
      TabLayout.g localg2 = localg1;
      if (localg1 == null) {
        localg2 = new TabLayout.g(this, getContext());
      }
      localg2.i(parame);
      localg2.setFocusable(true);
      localg2.setMinimumWidth(getTabMinWidth());
      return localg2;
    }
  }
  
  private void a(TabItem paramTabItem)
  {
    TabLayout.e locale = bE();
    if (paramTabItem.mText != null) {
      locale.c(paramTabItem.mText);
    }
    if (paramTabItem.la != null)
    {
      locale.la = paramTabItem.la;
      locale.bJ();
    }
    if (paramTabItem.lb != 0) {
      locale.P(paramTabItem.lb);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription()))
    {
      locale.lW = paramTabItem.getContentDescription();
      locale.bJ();
    }
    a(locale, this.ld.isEmpty());
  }
  
  private void a(TabLayout.e parame, int paramInt)
  {
    parame.mPosition = paramInt;
    this.ld.add(paramInt, parame);
    int i = this.ld.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((TabLayout.e)this.ld.get(paramInt)).mPosition = paramInt;
      paramInt += 1;
    }
  }
  
  private void a(ViewPager paramViewPager, boolean paramBoolean)
  {
    if (this.lz != null)
    {
      if (this.lC != null) {
        this.lz.removeOnPageChangeListener(this.lC);
      }
      if (this.lD != null) {
        this.lz.removeOnAdapterChangeListener(this.lD);
      }
    }
    if (this.lx != null)
    {
      b(this.lx);
      this.lx = null;
    }
    if (paramViewPager != null)
    {
      this.lz = paramViewPager;
      if (this.lC == null) {
        this.lC = new TabLayout.f(this);
      }
      this.lC.reset();
      paramViewPager.addOnPageChangeListener(this.lC);
      this.lx = new TabLayout.h(paramViewPager);
      a(this.lx);
      q localq = paramViewPager.getAdapter();
      if (localq != null) {
        a(localq, true);
      }
      if (this.lD == null) {
        this.lD = new TabLayout.a(this);
      }
      this.lD.lH = true;
      paramViewPager.addOnAdapterChangeListener(this.lD);
      setScrollPosition$4867b5c2(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.lE = paramBoolean;
      return;
      this.lz = null;
      a(null, false);
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mMode == 1) && (this.lu == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private int b(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (this.mMode == 0)
    {
      localView2 = this.lf.getChildAt(paramInt);
      if (paramInt + 1 >= this.lf.getChildCount()) {
        break label116;
      }
      localView1 = this.lf.getChildAt(paramInt + 1);
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
      if (t.T(this) != 0) {
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
  
  private void b(TabLayout.b paramb)
  {
    this.lw.remove(paramb);
  }
  
  private void bG()
  {
    if (this.ly == null)
    {
      this.ly = new ValueAnimator();
      this.ly.setInterpolator(a.fj);
      this.ly.setDuration(300L);
      this.ly.addUpdateListener(new TabLayout.1(this));
    }
  }
  
  private void bH()
  {
    if (this.mMode == 0) {}
    for (int i = Math.max(0, this.lt - this.lg);; i = 0)
    {
      t.d(this.lf, i, 0, 0, 0);
      switch (this.mMode)
      {
      }
      for (;;)
      {
        r(true);
        return;
        this.lf.setGravity(1);
        continue;
        this.lf.setGravity(8388611);
      }
    }
  }
  
  private void c(TabLayout.e parame)
  {
    int i = this.lw.size() - 1;
    while (i >= 0)
    {
      ((TabLayout.b)this.lw.get(i)).f(parame);
      i -= 1;
    }
  }
  
  private void d(TabLayout.e parame)
  {
    int i = this.lw.size() - 1;
    while (i >= 0)
    {
      ((TabLayout.b)this.lw.get(i)).g(parame);
      i -= 1;
    }
  }
  
  private void e(TabLayout.e parame)
  {
    int i = this.lw.size() - 1;
    while (i >= 0)
    {
      ((TabLayout.b)this.lw.get(i)).h(parame);
      i -= 1;
    }
  }
  
  private int getDefaultHeight()
  {
    int j = this.ld.size();
    int i = 0;
    if (i < j)
    {
      TabLayout.e locale = (TabLayout.e)this.ld.get(i);
      if ((locale == null) || (locale.la == null) || (TextUtils.isEmpty(locale.mText))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        return 72;
        i += 1;
        break;
      }
      return 48;
    }
  }
  
  private float getScrollPosition()
  {
    TabLayout.d locald = this.lf;
    float f = locald.lK;
    return locald.lL + f;
  }
  
  private int getTabMinWidth()
  {
    if (this.lq != -1) {
      return this.lq;
    }
    if (this.mMode == 0) {
      return this.ls;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.lf.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void removeAllTabs()
  {
    int i = this.lf.getChildCount() - 1;
    while (i >= 0)
    {
      localObject = (TabLayout.g)this.lf.getChildAt(i);
      this.lf.removeViewAt(i);
      if (localObject != null)
      {
        ((TabLayout.g)localObject).i(null);
        ((TabLayout.g)localObject).setSelected(false);
        this.lF.release(localObject);
      }
      requestLayout();
      i -= 1;
    }
    Object localObject = this.ld.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabLayout.e locale = (TabLayout.e)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      locale.lY = null;
      locale.lZ = null;
      locale.lV = null;
      locale.la = null;
      locale.mText = null;
      locale.lW = null;
      locale.mPosition = -1;
      locale.lX = null;
      lc.release(locale);
    }
    this.le = null;
  }
  
  private void setScrollPosition$4867b5c2(int paramInt)
  {
    a(paramInt, 0.0F, true, true);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = this.lf.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.lf.getChildAt(i);
        if (i == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          localView.setSelected(bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void t(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      a((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  public final TabLayout.e K(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount())) {
      return null;
    }
    return (TabLayout.e)this.ld.get(paramInt);
  }
  
  final int L(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramInt + paramFloat);
    if ((i < 0) || (i >= this.lf.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.lf.c(paramInt, paramFloat);
      }
      if ((this.ly != null) && (this.ly.isRunning())) {
        this.ly.cancel();
      }
      scrollTo(b(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    setSelectedTabView(i);
  }
  
  public final void a(TabLayout.b paramb)
  {
    if (!this.lw.contains(paramb)) {
      this.lw.add(paramb);
    }
  }
  
  public final void a(TabLayout.e parame, boolean paramBoolean)
  {
    int i = this.ld.size();
    if (parame.lY != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(parame, i);
    TabLayout.g localg = parame.lZ;
    TabLayout.d locald = this.lf;
    i = parame.mPosition;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    locald.addView(localg, i, localLayoutParams);
    if (paramBoolean) {
      parame.select();
    }
  }
  
  final void a(q paramq, boolean paramBoolean)
  {
    if ((this.lA != null) && (this.lB != null)) {
      this.lA.unregisterDataSetObserver(this.lB);
    }
    this.lA = paramq;
    if ((paramBoolean) && (paramq != null))
    {
      if (this.lB == null) {
        this.lB = new TabLayout.c(this);
      }
      paramq.registerDataSetObserver(this.lB);
    }
    bF();
  }
  
  public void addView(View paramView)
  {
    t(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    t(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    t(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    t(paramView);
  }
  
  final void b(TabLayout.e parame)
  {
    b(parame, true);
  }
  
  final void b(TabLayout.e parame, boolean paramBoolean)
  {
    TabLayout.e locale = this.le;
    if (locale == parame)
    {
      if (locale != null)
      {
        e(parame);
        M(parame.mPosition);
      }
      return;
    }
    int i;
    if (parame != null)
    {
      i = parame.mPosition;
      label40:
      if (paramBoolean)
      {
        if (((locale != null) && (locale.mPosition != -1)) || (i == -1)) {
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
      if (locale != null) {
        d(locale);
      }
      this.le = parame;
      if (parame == null) {
        break;
      }
      c(parame);
      return;
      i = -1;
      break label40;
      label109:
      M(i);
    }
  }
  
  public final TabLayout.e bE()
  {
    TabLayout.e locale2 = (TabLayout.e)lc.acquire();
    TabLayout.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new TabLayout.e();
    }
    locale1.lY = this;
    locale1.lZ = a(locale1);
    return locale1;
  }
  
  final void bF()
  {
    removeAllTabs();
    if (this.lA != null)
    {
      int j = this.lA.getCount();
      int i = 0;
      while (i < j)
      {
        a(bE().c(this.lA.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.lz != null) && (j > 0))
      {
        i = this.lz.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          b(K(i), true);
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
    if (this.le != null) {
      return this.le.mPosition;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.ld.size();
  }
  
  public int getTabGravity()
  {
    return this.lu;
  }
  
  int getTabMaxWidth()
  {
    return this.lp;
  }
  
  public int getTabMode()
  {
    return this.mMode;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.ll;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.lz == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        a((ViewPager)localViewParent, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.lE)
    {
      setupWithViewPager(null);
      this.lE = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = L(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    label76:
    View localView;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.lr > 0)
        {
          i = this.lr;
          this.lp = i;
        }
      }
      else
      {
        super.onMeasure(paramInt1, paramInt2);
        if (getChildCount() == 1)
        {
          localView = getChildAt(0);
          switch (this.mMode)
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
      i -= L(56);
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
  
  final void r(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.lf.getChildCount())
    {
      View localView = this.lf.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void setOnTabSelectedListener(TabLayout.b paramb)
  {
    if (this.lv != null) {
      b(this.lv);
    }
    this.lv = paramb;
    if (paramb != null) {
      a(paramb);
    }
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    bG();
    this.ly.addListener(paramAnimatorListener);
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.lf.N(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.lf.O(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.lu != paramInt)
    {
      this.lu = paramInt;
      bH();
    }
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mMode)
    {
      this.mMode = paramInt;
      bH();
    }
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.ll != paramColorStateList)
    {
      this.ll = paramColorStateList;
      int j = this.ld.size();
      int i = 0;
      while (i < j)
      {
        ((TabLayout.e)this.ld.get(i)).bJ();
        i += 1;
      }
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(q paramq)
  {
    a(paramq, false);
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    a(paramViewPager, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.TabLayout
 * JD-Core Version:    0.7.0.1
 */