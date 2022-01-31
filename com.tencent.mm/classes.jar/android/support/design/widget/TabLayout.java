package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.design.a.d;
import android.support.design.a.k;
import android.support.v4.f.k.a;
import android.support.v4.f.k.b;
import android.support.v4.f.k.c;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.a;
import android.support.v4.view.n;
import android.support.v4.view.q;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ViewPager.a
public class TabLayout
  extends HorizontalScrollView
{
  private static final k.a<TabLayout.e> ke = new k.c(16);
  private ValueAnimator kA;
  ViewPager kB;
  private n kC;
  private DataSetObserver kD;
  private TabLayout.f kE;
  private TabLayout.a kF;
  private boolean kG;
  private final k.a<TabLayout.g> kH = new k.b(12);
  private final ArrayList<TabLayout.e> kf = new ArrayList();
  private TabLayout.e kg;
  private final TabLayout.d kh;
  int ki;
  int kj;
  int kk;
  int kl;
  int km;
  ColorStateList kn;
  float ko;
  float kp;
  final int kq;
  int kr = 2147483647;
  private final int ks;
  private final int kt;
  private final int ku;
  private int kv;
  int kw;
  private TabLayout.b kx;
  private final ArrayList<TabLayout.b> ky = new ArrayList();
  private TabLayout.b kz;
  int mMode;
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    o.G(paramContext);
    setHorizontalScrollBarEnabled(false);
    this.kh = new TabLayout.d(this, paramContext);
    super.addView(this.kh, 0, new FrameLayout.LayoutParams(-2, -1));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.TabLayout, paramInt, android.support.design.a.j.Widget_Design_TabLayout);
    this.kh.P(paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabIndicatorHeight, 0));
    this.kh.O(paramAttributeSet.getColor(a.k.TabLayout_tabIndicatorColor, 0));
    paramInt = paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabPadding, 0);
    this.kl = paramInt;
    this.kk = paramInt;
    this.kj = paramInt;
    this.ki = paramInt;
    this.ki = paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabPaddingStart, this.ki);
    this.kj = paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabPaddingTop, this.kj);
    this.kk = paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabPaddingEnd, this.kk);
    this.kl = paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabPaddingBottom, this.kl);
    this.km = paramAttributeSet.getResourceId(a.k.TabLayout_tabTextAppearance, android.support.design.a.j.TextAppearance_Design_Tab);
    paramContext = paramContext.obtainStyledAttributes(this.km, android.support.v7.a.a.j.TextAppearance);
    try
    {
      this.ko = paramContext.getDimensionPixelSize(android.support.v7.a.a.j.TextAppearance_android_textSize, 0);
      this.kn = paramContext.getColorStateList(android.support.v7.a.a.j.TextAppearance_android_textColor);
      paramContext.recycle();
      if (paramAttributeSet.hasValue(a.k.TabLayout_tabTextColor)) {
        this.kn = paramAttributeSet.getColorStateList(a.k.TabLayout_tabTextColor);
      }
      if (paramAttributeSet.hasValue(a.k.TabLayout_tabSelectedTextColor))
      {
        paramInt = paramAttributeSet.getColor(a.k.TabLayout_tabSelectedTextColor, 0);
        int i = this.kn.getDefaultColor();
        this.kn = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt, i });
      }
      this.ks = paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabMinWidth, -1);
      this.kt = paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabMaxWidth, -1);
      this.kq = paramAttributeSet.getResourceId(a.k.TabLayout_tabBackground, 0);
      this.kv = paramAttributeSet.getDimensionPixelSize(a.k.TabLayout_tabContentStart, 0);
      this.mMode = paramAttributeSet.getInt(a.k.TabLayout_tabMode, 1);
      this.kw = paramAttributeSet.getInt(a.k.TabLayout_tabGravity, 0);
      paramAttributeSet.recycle();
      paramContext = getResources();
      this.kp = paramContext.getDimensionPixelSize(a.d.design_tab_text_size_2line);
      this.ku = paramContext.getDimensionPixelSize(a.d.design_tab_scrollable_min_width);
      aX();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void N(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (q.al(this)))
    {
      TabLayout.d locald = this.kh;
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
      aW();
      this.kA.setIntValues(new int[] { i, j });
      this.kA.start();
    }
    this.kh.j(paramInt, 300);
  }
  
  private void a(TabLayout.b paramb)
  {
    if (!this.ky.contains(paramb)) {
      this.ky.add(paramb);
    }
  }
  
  private void a(TabLayout.e parame, int paramInt)
  {
    parame.mPosition = paramInt;
    this.kf.add(paramInt, parame);
    int i = this.kf.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((TabLayout.e)this.kf.get(paramInt)).mPosition = paramInt;
      paramInt += 1;
    }
  }
  
  private void a(TabLayout.e parame, boolean paramBoolean)
  {
    int i = this.kf.size();
    if (parame.lb != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(parame, i);
    TabLayout.g localg = parame.lc;
    TabLayout.d locald = this.kh;
    i = parame.mPosition;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    locald.addView(localg, i, localLayoutParams);
    if (paramBoolean) {
      parame.select();
    }
  }
  
  private void a(ViewPager paramViewPager, boolean paramBoolean)
  {
    Object localObject;
    if (this.kB != null)
    {
      if (this.kE != null)
      {
        localObject = this.kB;
        TabLayout.f localf = this.kE;
        if (((ViewPager)localObject).Hf != null) {
          ((ViewPager)localObject).Hf.remove(localf);
        }
      }
      if (this.kF != null) {
        this.kB.b(this.kF);
      }
    }
    if (this.kz != null)
    {
      b(this.kz);
      this.kz = null;
    }
    if (paramViewPager != null)
    {
      this.kB = paramViewPager;
      if (this.kE == null) {
        this.kE = new TabLayout.f(this);
      }
      localObject = this.kE;
      ((TabLayout.f)localObject).lf = 0;
      ((TabLayout.f)localObject).le = 0;
      paramViewPager.a(this.kE);
      this.kz = new TabLayout.h(paramViewPager);
      a(this.kz);
      localObject = paramViewPager.getAdapter();
      if (localObject != null) {
        a((n)localObject, true);
      }
      if (this.kF == null) {
        this.kF = new TabLayout.a(this);
      }
      this.kF.kJ = true;
      paramViewPager.a(this.kF);
      setScrollPosition$4867b5c2(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.kG = paramBoolean;
      return;
      this.kB = null;
      a(null, false);
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mMode == 1) && (this.kw == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private TabLayout.e aU()
  {
    TabLayout.e locale = (TabLayout.e)ke.de();
    if (locale == null) {
      locale = new TabLayout.e();
    }
    for (;;)
    {
      locale.lb = this;
      if (this.kH != null) {}
      for (TabLayout.g localg1 = (TabLayout.g)this.kH.de();; localg1 = null)
      {
        TabLayout.g localg2 = localg1;
        if (localg1 == null) {
          localg2 = new TabLayout.g(this, getContext());
        }
        localg2.c(locale);
        localg2.setFocusable(true);
        localg2.setMinimumWidth(getTabMinWidth());
        locale.lc = localg2;
        return locale;
      }
    }
  }
  
  private void aW()
  {
    if (this.kA == null)
    {
      this.kA = new ValueAnimator();
      this.kA.setInterpolator(a.el);
      this.kA.setDuration(300L);
      this.kA.addUpdateListener(new TabLayout.1(this));
    }
  }
  
  private void aX()
  {
    if (this.mMode == 0) {}
    for (int i = Math.max(0, this.kv - this.ki);; i = 0)
    {
      q.d(this.kh, i, 0, 0, 0);
      switch (this.mMode)
      {
      }
      for (;;)
      {
        s(true);
        return;
        this.kh.setGravity(1);
        continue;
        this.kh.setGravity(8388611);
      }
    }
  }
  
  private int b(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (this.mMode == 0)
    {
      localView2 = this.kh.getChildAt(paramInt);
      if (paramInt + 1 >= this.kh.getChildCount()) {
        break label116;
      }
      localView1 = this.kh.getChildAt(paramInt + 1);
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
      if (q.Q(this) != 0) {
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
    this.ky.remove(paramb);
  }
  
  private int getDefaultHeight()
  {
    int j = this.kf.size();
    int i = 0;
    if (i < j)
    {
      TabLayout.e locale = (TabLayout.e)this.kf.get(i);
      if ((locale == null) || (locale.kc == null) || (TextUtils.isEmpty(locale.mText))) {}
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
    TabLayout.d locald = this.kh;
    float f = locald.kM;
    return locald.kN + f;
  }
  
  private int getTabMinWidth()
  {
    if (this.ks != -1) {
      return this.ks;
    }
    if (this.mMode == 0) {
      return this.ku;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.kh.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void r(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      paramView = (TabItem)paramView;
      TabLayout.e locale = aU();
      if (paramView.mText != null) {
        locale.a(paramView.mText);
      }
      if (paramView.kc != null)
      {
        locale.kc = paramView.kc;
        locale.aZ();
      }
      if (paramView.kd != 0)
      {
        int i = paramView.kd;
        locale.la = LayoutInflater.from(locale.lc.getContext()).inflate(i, locale.lc, false);
        locale.aZ();
      }
      if (!TextUtils.isEmpty(paramView.getContentDescription()))
      {
        locale.kZ = paramView.getContentDescription();
        locale.aZ();
      }
      a(locale, this.kf.isEmpty());
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private void setScrollPosition$4867b5c2(int paramInt)
  {
    a(paramInt, 0.0F, true, true);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = this.kh.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.kh.getChildAt(i);
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
  
  public final TabLayout.e L(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount())) {
      return null;
    }
    return (TabLayout.e)this.kf.get(paramInt);
  }
  
  final int M(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramInt + paramFloat);
    if ((i < 0) || (i >= this.kh.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2)
      {
        TabLayout.d locald = this.kh;
        if ((locald.kR != null) && (locald.kR.isRunning())) {
          locald.kR.cancel();
        }
        locald.kM = paramInt;
        locald.kN = paramFloat;
        locald.aY();
      }
      if ((this.kA != null) && (this.kA.isRunning())) {
        this.kA.cancel();
      }
      scrollTo(b(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    setSelectedTabView(i);
  }
  
  final void a(TabLayout.e parame)
  {
    b(parame, true);
  }
  
  final void a(n paramn, boolean paramBoolean)
  {
    if ((this.kC != null) && (this.kD != null)) {
      this.kC.unregisterDataSetObserver(this.kD);
    }
    this.kC = paramn;
    if ((paramBoolean) && (paramn != null))
    {
      if (this.kD == null) {
        this.kD = new TabLayout.c(this);
      }
      paramn.registerDataSetObserver(this.kD);
    }
    aV();
  }
  
  final void aV()
  {
    int i = this.kh.getChildCount() - 1;
    while (i >= 0)
    {
      localObject = (TabLayout.g)this.kh.getChildAt(i);
      this.kh.removeViewAt(i);
      if (localObject != null)
      {
        ((TabLayout.g)localObject).c(null);
        ((TabLayout.g)localObject).setSelected(false);
        this.kH.D(localObject);
      }
      requestLayout();
      i -= 1;
    }
    Object localObject = this.kf.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabLayout.e locale = (TabLayout.e)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      locale.lb = null;
      locale.lc = null;
      locale.kY = null;
      locale.kc = null;
      locale.mText = null;
      locale.kZ = null;
      locale.mPosition = -1;
      locale.la = null;
      ke.D(locale);
    }
    this.kg = null;
    if (this.kC != null)
    {
      int j = this.kC.getCount();
      i = 0;
      while (i < j)
      {
        a(aU().a(this.kC.dj()), false);
        i += 1;
      }
      if ((this.kB != null) && (j > 0))
      {
        i = this.kB.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          b(L(i), true);
        }
      }
    }
  }
  
  public void addView(View paramView)
  {
    r(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    r(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    r(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    r(paramView);
  }
  
  final void b(TabLayout.e parame, boolean paramBoolean)
  {
    TabLayout.e locale = this.kg;
    int i;
    if (locale == parame) {
      if (locale != null)
      {
        i = this.ky.size() - 1;
        while (i >= 0)
        {
          this.ky.get(i);
          i -= 1;
        }
        N(parame.mPosition);
      }
    }
    for (;;)
    {
      return;
      if (parame != null)
      {
        i = parame.mPosition;
        if (paramBoolean)
        {
          if (((locale != null) && (locale.mPosition != -1)) || (i == -1)) {
            break label143;
          }
          setScrollPosition$4867b5c2(i);
        }
      }
      for (;;)
      {
        if (i != -1) {
          setSelectedTabView(i);
        }
        if (locale == null) {
          break label151;
        }
        i = this.ky.size() - 1;
        while (i >= 0)
        {
          this.ky.get(i);
          i -= 1;
        }
        i = -1;
        break;
        label143:
        N(i);
      }
      label151:
      this.kg = parame;
      if (parame != null)
      {
        i = this.ky.size() - 1;
        while (i >= 0)
        {
          ((TabLayout.b)this.ky.get(i)).b(parame);
          i -= 1;
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
    if (this.kg != null) {
      return this.kg.mPosition;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.kf.size();
  }
  
  public int getTabGravity()
  {
    return this.kw;
  }
  
  int getTabMaxWidth()
  {
    return this.kr;
  }
  
  public int getTabMode()
  {
    return this.mMode;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.kn;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.kB == null)
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
    if (this.kG)
    {
      setupWithViewPager(null);
      this.kG = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = M(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    label76:
    View localView;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.kt > 0)
        {
          i = this.kt;
          this.kr = i;
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
      i -= M(56);
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
  
  final void s(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.kh.getChildCount())
    {
      View localView = this.kh.getChildAt(i);
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
    if (this.kx != null) {
      b(this.kx);
    }
    this.kx = paramb;
    if (paramb != null) {
      a(paramb);
    }
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    aW();
    this.kA.addListener(paramAnimatorListener);
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.kh.O(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.kh.P(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.kw != paramInt)
    {
      this.kw = paramInt;
      aX();
    }
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mMode)
    {
      this.mMode = paramInt;
      aX();
    }
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.kn != paramColorStateList)
    {
      this.kn = paramColorStateList;
      int j = this.kf.size();
      int i = 0;
      while (i < j)
      {
        ((TabLayout.e)this.kf.get(i)).aZ();
        i += 1;
      }
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(n paramn)
  {
    a(paramn, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.TabLayout
 * JD-Core Version:    0.7.0.1
 */