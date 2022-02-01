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
  private static final l.a<TabLayout.f> tZ = new l.c(16);
  private int contentInsetStart;
  int mode;
  boolean uA;
  boolean uB;
  boolean uC;
  private b uD;
  private final ArrayList<b> uE = new ArrayList();
  private b uF;
  private ValueAnimator uG;
  ViewPager uH;
  private android.support.v4.view.q uI;
  private DataSetObserver uJ;
  private TabLayout.g uK;
  private a uL;
  private boolean uM;
  private final l.a<h> uN = new l.b(12);
  private final ArrayList<TabLayout.f> ua = new ArrayList();
  private TabLayout.f ub;
  private final RectF uc = new RectF();
  private final e ud;
  int ue;
  int uf;
  int ug;
  int uh;
  int uj;
  ColorStateList uk;
  ColorStateList ul;
  ColorStateList um;
  Drawable un;
  PorterDuff.Mode uo;
  float up;
  float uq;
  final int ur;
  int ut = 2147483647;
  private final int uu;
  private final int uv;
  private final int uw;
  int ux;
  int uy;
  int uz;
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969524);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.ud = new e(paramContext);
    super.addView(this.ud, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = f.a(paramContext, paramAttributeSet, android.support.design.a.a.TabLayout, paramInt, 2131821641, new int[] { 22 });
    this.ud.aj(localTypedArray.getDimensionPixelSize(10, -1));
    this.ud.ai(localTypedArray.getColor(7, 0));
    setSelectedTabIndicator(android.support.design.d.a.c(paramContext, localTypedArray, 5));
    setSelectedTabIndicatorGravity(localTypedArray.getInt(9, 0));
    setTabIndicatorFullWidth(localTypedArray.getBoolean(8, true));
    paramInt = localTypedArray.getDimensionPixelSize(15, 0);
    this.uh = paramInt;
    this.ug = paramInt;
    this.uf = paramInt;
    this.ue = paramInt;
    this.ue = localTypedArray.getDimensionPixelSize(18, this.ue);
    this.uf = localTypedArray.getDimensionPixelSize(19, this.uf);
    this.ug = localTypedArray.getDimensionPixelSize(17, this.ug);
    this.uh = localTypedArray.getDimensionPixelSize(16, this.uh);
    this.uj = localTypedArray.getResourceId(22, 2131821393);
    paramAttributeSet = paramContext.obtainStyledAttributes(this.uj, android.support.v7.a.a.a.TextAppearance);
    try
    {
      this.up = paramAttributeSet.getDimensionPixelSize(0, 0);
      this.uk = android.support.design.d.a.b(paramContext, paramAttributeSet, 3);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(23)) {
        this.uk = android.support.design.d.a.b(paramContext, localTypedArray, 23);
      }
      if (localTypedArray.hasValue(21))
      {
        paramInt = localTypedArray.getColor(21, 0);
        int i = this.uk.getDefaultColor();
        this.uk = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt, i });
      }
      this.ul = android.support.design.d.a.b(paramContext, localTypedArray, 3);
      this.uo = android.support.design.internal.g.a(localTypedArray.getInt(4, -1), null);
      this.um = android.support.design.d.a.b(paramContext, localTypedArray, 20);
      this.uy = localTypedArray.getInt(6, 300);
      this.uu = localTypedArray.getDimensionPixelSize(13, -1);
      this.uv = localTypedArray.getDimensionPixelSize(12, -1);
      this.ur = localTypedArray.getResourceId(0, 0);
      this.contentInsetStart = localTypedArray.getDimensionPixelSize(1, 0);
      this.mode = localTypedArray.getInt(14, 1);
      this.ux = localTypedArray.getInt(2, 0);
      this.uA = localTypedArray.getBoolean(11, false);
      this.uC = localTypedArray.getBoolean(24, false);
      localTypedArray.recycle();
      paramContext = getResources();
      this.uq = paramContext.getDimensionPixelSize(2131166134);
      this.uw = paramContext.getDimensionPixelSize(2131166132);
      cZ();
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private h a(TabLayout.f paramf)
  {
    if (this.uN != null) {}
    h localh2;
    for (h localh1 = (h)this.uN.acquire();; localh1 = null)
    {
      localh2 = localh1;
      if (localh1 == null) {
        localh2 = new h(getContext());
      }
      localh2.i(paramf);
      localh2.setFocusable(true);
      localh2.setMinimumWidth(getTabMinWidth());
      if (!TextUtils.isEmpty(paramf.vc)) {
        break;
      }
      localh2.setContentDescription(paramf.text);
      return localh2;
    }
    localh2.setContentDescription(paramf.vc);
    return localh2;
  }
  
  private void a(TabItem paramTabItem)
  {
    TabLayout.f localf = cU();
    if (paramTabItem.text != null) {
      localf.d(paramTabItem.text);
    }
    if (paramTabItem.icon != null)
    {
      localf.icon = paramTabItem.icon;
      localf.updateView();
    }
    if (paramTabItem.tY != 0) {
      localf.ak(paramTabItem.tY);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription()))
    {
      localf.vc = paramTabItem.getContentDescription();
      localf.updateView();
    }
    a(localf, this.ua.isEmpty());
  }
  
  private void a(TabLayout.f paramf, int paramInt)
  {
    paramf.position = paramInt;
    this.ua.add(paramInt, paramf);
    int i = this.ua.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((TabLayout.f)this.ua.get(paramInt)).position = paramInt;
      paramInt += 1;
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mode == 1) && (this.ux == 0))
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
      e locale = this.ud;
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
      cY();
      this.uG.setIntValues(new int[] { i, j });
      this.uG.start();
    }
    this.ud.r(paramInt, this.uy);
  }
  
  private int b(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (this.mode == 0)
    {
      localView2 = this.ud.getChildAt(paramInt);
      if (paramInt + 1 >= this.ud.getChildCount()) {
        break label116;
      }
      localView1 = this.ud.getChildAt(paramInt + 1);
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
    this.uE.remove(paramb);
  }
  
  private void c(TabLayout.f paramf)
  {
    int i = this.uE.size() - 1;
    while (i >= 0)
    {
      ((b)this.uE.get(i)).f(paramf);
      i -= 1;
    }
  }
  
  private static TabLayout.f cV()
  {
    TabLayout.f localf2 = (TabLayout.f)tZ.acquire();
    TabLayout.f localf1 = localf2;
    if (localf2 == null) {
      localf1 = new TabLayout.f();
    }
    return localf1;
  }
  
  private void cX()
  {
    int j = this.ua.size();
    int i = 0;
    while (i < j)
    {
      ((TabLayout.f)this.ua.get(i)).updateView();
      i += 1;
    }
  }
  
  private void cY()
  {
    if (this.uG == null)
    {
      this.uG = new ValueAnimator();
      this.uG.setInterpolator(android.support.design.a.a.gJ);
      this.uG.setDuration(this.uy);
      this.uG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
        }
      });
    }
  }
  
  private void cZ()
  {
    if (this.mode == 0) {}
    for (int i = Math.max(0, this.contentInsetStart - this.ue);; i = 0)
    {
      t.d(this.ud, i, 0, 0, 0);
      switch (this.mode)
      {
      }
      for (;;)
      {
        x(true);
        return;
        this.ud.setGravity(1);
        continue;
        this.ud.setGravity(8388611);
      }
    }
  }
  
  private void d(TabLayout.f paramf)
  {
    int i = this.uE.size() - 1;
    while (i >= 0)
    {
      ((b)this.uE.get(i)).g(paramf);
      i -= 1;
    }
  }
  
  private void e(TabLayout.f paramf)
  {
    int i = this.uE.size() - 1;
    while (i >= 0)
    {
      ((b)this.uE.get(i)).h(paramf);
      i -= 1;
    }
  }
  
  private int getDefaultHeight()
  {
    int j = this.ua.size();
    int i = 0;
    if (i < j)
    {
      TabLayout.f localf = (TabLayout.f)this.ua.get(i);
      if ((localf == null) || (localf.icon == null) || (TextUtils.isEmpty(localf.text))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (!this.uA))
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
    if (this.uu != -1) {
      return this.uu;
    }
    if (this.mode == 0) {
      return this.uw;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.ud.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void removeAllTabs()
  {
    int i = this.ud.getChildCount() - 1;
    while (i >= 0)
    {
      localObject = (h)this.ud.getChildAt(i);
      this.ud.removeViewAt(i);
      if (localObject != null)
      {
        ((h)localObject).i(null);
        ((h)localObject).setSelected(false);
        this.uN.release(localObject);
      }
      requestLayout();
      i -= 1;
    }
    Object localObject = this.ua.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabLayout.f localf = (TabLayout.f)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      localf.ve = null;
      localf.vf = null;
      localf.tag = null;
      localf.icon = null;
      localf.text = null;
      localf.vc = null;
      localf.position = -1;
      localf.vd = null;
      tZ.release(localf);
    }
    this.ub = null;
  }
  
  private void setScrollPosition$4867b5c2(int paramInt)
  {
    a(paramInt, 0.0F, true, true);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = this.ud.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.ud.getChildAt(i);
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
    if ((i < 0) || (i >= this.ud.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.ud.c(paramInt, paramFloat);
      }
      if ((this.uG != null) && (this.uG.isRunning())) {
        this.uG.cancel();
      }
      scrollTo(b(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    setSelectedTabView(i);
  }
  
  public final void a(b paramb)
  {
    if (!this.uE.contains(paramb)) {
      this.uE.add(paramb);
    }
  }
  
  public final void a(TabLayout.f paramf, boolean paramBoolean)
  {
    int i = this.ua.size();
    if (paramf.ve != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramf, i);
    h localh = paramf.vf;
    e locale = this.ud;
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
    if (this.uH != null)
    {
      if (this.uK != null) {
        this.uH.removeOnPageChangeListener(this.uK);
      }
      if (this.uL != null) {
        this.uH.removeOnAdapterChangeListener(this.uL);
      }
    }
    if (this.uF != null)
    {
      b(this.uF);
      this.uF = null;
    }
    if (paramViewPager != null)
    {
      this.uH = paramViewPager;
      if (this.uK == null) {
        this.uK = new TabLayout.g(this);
      }
      this.uK.reset();
      paramViewPager.addOnPageChangeListener(this.uK);
      this.uF = new TabLayout.i(paramViewPager);
      a(this.uF);
      android.support.v4.view.q localq = paramViewPager.getAdapter();
      if (localq != null) {
        a(localq, paramBoolean1);
      }
      if (this.uL == null) {
        this.uL = new a();
      }
      this.uL.uP = paramBoolean1;
      paramViewPager.addOnAdapterChangeListener(this.uL);
      setScrollPosition$4867b5c2(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.uM = paramBoolean2;
      return;
      this.uH = null;
      a(null, false);
    }
  }
  
  final void a(android.support.v4.view.q paramq, boolean paramBoolean)
  {
    if ((this.uI != null) && (this.uJ != null)) {
      this.uI.unregisterDataSetObserver(this.uJ);
    }
    this.uI = paramq;
    if ((paramBoolean) && (paramq != null))
    {
      if (this.uJ == null) {
        this.uJ = new d();
      }
      paramq.registerDataSetObserver(this.uJ);
    }
    cW();
  }
  
  public final TabLayout.f ad(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount())) {
      return null;
    }
    return (TabLayout.f)this.ua.get(paramInt);
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
    TabLayout.f localf = this.ub;
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
      this.ub = paramf;
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
  
  public final TabLayout.f cU()
  {
    TabLayout.f localf = cV();
    localf.ve = this;
    localf.vf = a(localf);
    return localf;
  }
  
  final void cW()
  {
    removeAllTabs();
    if (this.uI != null)
    {
      int j = this.uI.getCount();
      int i = 0;
      while (i < j)
      {
        a(cU().d(this.uI.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.uH != null) && (j > 0))
      {
        i = this.uH.getCurrentItem();
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
    if (this.ub != null) {
      return this.ub.position;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.ua.size();
  }
  
  public int getTabGravity()
  {
    return this.ux;
  }
  
  public ColorStateList getTabIconTint()
  {
    return this.ul;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.uz;
  }
  
  int getTabMaxWidth()
  {
    return this.ut;
  }
  
  public int getTabMode()
  {
    return this.mode;
  }
  
  public ColorStateList getTabRippleColor()
  {
    return this.um;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return this.un;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.uk;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.uH == null)
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
    if (this.uM)
    {
      setupWithViewPager(null);
      this.uM = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.ud.getChildCount())
    {
      View localView = this.ud.getChildAt(i);
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
        if (this.uv > 0)
        {
          i = this.uv;
          this.ut = i;
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
    if (this.uA != paramBoolean)
    {
      this.uA = paramBoolean;
      int i = 0;
      if (i < this.ud.getChildCount())
      {
        Object localObject = this.ud.getChildAt(i);
        int j;
        if ((localObject instanceof h))
        {
          localObject = (h)localObject;
          if (!((h)localObject).uO.uA) {
            break label108;
          }
          j = 0;
          label64:
          ((h)localObject).setOrientation(j);
          if ((((h)localObject).vm == null) && (((h)localObject).vn == null)) {
            break label113;
          }
          ((h)localObject).a(((h)localObject).vm, ((h)localObject).vn);
        }
        for (;;)
        {
          i += 1;
          break;
          label108:
          j = 1;
          break label64;
          label113:
          ((h)localObject).a(((h)localObject).vk, ((h)localObject).vl);
        }
      }
      cZ();
    }
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(b paramb)
  {
    if (this.uD != null) {
      b(this.uD);
    }
    this.uD = paramb;
    if (paramb != null) {
      a(paramb);
    }
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    cY();
    this.uG.addListener(paramAnimatorListener);
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
    if (this.un != paramDrawable)
    {
      this.un = paramDrawable;
      t.W(this.ud);
    }
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.ud.ai(paramInt);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.uz != paramInt)
    {
      this.uz = paramInt;
      t.W(this.ud);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.ud.aj(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.ux != paramInt)
    {
      this.ux = paramInt;
      cZ();
    }
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    if (this.ul != paramColorStateList)
    {
      this.ul = paramColorStateList;
      cX();
    }
  }
  
  public void setTabIconTintResource(int paramInt)
  {
    setTabIconTint(android.support.v7.c.a.a.m(getContext(), paramInt));
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.uB = paramBoolean;
    t.W(this.ud);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      cZ();
    }
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    if (this.um != paramColorStateList)
    {
      this.um = paramColorStateList;
      int i = 0;
      while (i < this.ud.getChildCount())
      {
        paramColorStateList = this.ud.getChildAt(i);
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
    if (this.uk != paramColorStateList)
    {
      this.uk = paramColorStateList;
      cX();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(android.support.v4.view.q paramq)
  {
    a(paramq, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.uC != paramBoolean)
    {
      this.uC = paramBoolean;
      int i = 0;
      while (i < this.ud.getChildCount())
      {
        View localView = this.ud.getChildAt(i);
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
    while (i < this.ud.getChildCount())
    {
      View localView = this.ud.getChildAt(i);
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
    boolean uP;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, android.support.v4.view.q paramq1, android.support.v4.view.q paramq2)
    {
      if (TabLayout.this.uH == paramViewPager) {
        TabLayout.this.a(paramq2, this.uP);
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
      TabLayout.this.cW();
    }
    
    public final void onInvalidated()
    {
      TabLayout.this.cW();
    }
  }
  
  final class e
    extends LinearLayout
  {
    private int indicatorLeft = -1;
    private int indicatorRight = -1;
    private int layoutDirection = -1;
    private int uQ;
    private final Paint uR;
    private final GradientDrawable uS;
    int uT = -1;
    float uU;
    private ValueAnimator uV;
    
    e(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      this.uR = new Paint();
      this.uS = new GradientDrawable();
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
    
    private void da()
    {
      View localView = getChildAt(this.uT);
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
        if (!TabLayout.this.uB)
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
        if (this.uU > 0.0F)
        {
          k = i;
          m = j;
          if (this.uT < getChildCount() - 1)
          {
            localView = getChildAt(this.uT + 1);
            m = localView.getLeft();
            k = localView.getRight();
            if ((TabLayout.this.uB) || (!(localView instanceof TabLayout.h))) {
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
        float f1 = this.uU;
        float f2 = m;
        float f3 = this.uU;
        m = (int)(j * (1.0F - f3) + f1 * f2);
        f1 = this.uU;
        f2 = k;
        f3 = this.uU;
        k = (int)(f2 * f1 + i * (1.0F - f3));
        for (;;)
        {
          q(m, k);
          return;
          k = -1;
          m = -1;
        }
      }
    }
    
    final void ai(int paramInt)
    {
      if (this.uR.getColor() != paramInt)
      {
        this.uR.setColor(paramInt);
        t.W(this);
      }
    }
    
    final void aj(int paramInt)
    {
      if (this.uQ != paramInt)
      {
        this.uQ = paramInt;
        t.W(this);
      }
    }
    
    final void c(int paramInt, float paramFloat)
    {
      if ((this.uV != null) && (this.uV.isRunning())) {
        this.uV.cancel();
      }
      this.uT = paramInt;
      this.uU = paramFloat;
      da();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (TabLayout.this.un != null) {}
      for (int i = TabLayout.this.un.getIntrinsicHeight();; i = 0)
      {
        if (this.uQ >= 0) {
          i = this.uQ;
        }
        int j;
        Object localObject;
        switch (TabLayout.this.uz)
        {
        default: 
          i = 0;
          j = 0;
          if ((this.indicatorLeft >= 0) && (this.indicatorRight > this.indicatorLeft))
          {
            if (TabLayout.this.un == null) {
              break label238;
            }
            localObject = TabLayout.this.un;
            label113:
            localObject = android.support.v4.graphics.drawable.a.i((Drawable)localObject);
            ((Drawable)localObject).setBounds(this.indicatorLeft, j, this.indicatorRight, i);
            if (this.uR != null)
            {
              if (Build.VERSION.SDK_INT != 21) {
                break label247;
              }
              ((Drawable)localObject).setColorFilter(this.uR.getColor(), PorterDuff.Mode.SRC_IN);
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
          localObject = this.uS;
          break label113;
          label247:
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.uR.getColor());
        }
      }
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.uV != null) && (this.uV.isRunning()))
      {
        this.uV.cancel();
        long l = this.uV.getDuration();
        paramInt1 = this.uT;
        float f = this.uV.getAnimatedFraction();
        r(paramInt1, Math.round((float)l * (1.0F - f)));
        return;
      }
      da();
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
        break label15;
      }
      label15:
      while ((TabLayout.this.mode != 1) || (TabLayout.this.ux != 1)) {
        return;
      }
      int n = getChildCount();
      int k = 0;
      int j = 0;
      label50:
      Object localObject;
      if (k < n)
      {
        localObject = getChildAt(k);
        if (((View)localObject).getVisibility() != 0) {
          break label234;
        }
      }
      label132:
      label219:
      label231:
      label234:
      for (int i = Math.max(j, ((View)localObject).getMeasuredWidth());; i = j)
      {
        k += 1;
        j = i;
        break label50;
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
            break label219;
          }
          localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width == j) && (((LinearLayout.LayoutParams)localObject).weight == 0.0F)) {
            break label231;
          }
          ((LinearLayout.LayoutParams)localObject).width = j;
          ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
          i = 1;
        }
        for (;;)
        {
          k += 1;
          break label132;
          TabLayout.this.ux = 0;
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
    
    final void q(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.indicatorLeft) || (paramInt2 != this.indicatorRight))
      {
        this.indicatorLeft = paramInt1;
        this.indicatorRight = paramInt2;
        t.W(this);
      }
    }
    
    final void r(final int paramInt1, int paramInt2)
    {
      if ((this.uV != null) && (this.uV.isRunning())) {
        this.uV.cancel();
      }
      Object localObject = getChildAt(paramInt1);
      if (localObject == null) {
        da();
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
        if (!TabLayout.this.uB)
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
      this.uV = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setInterpolator(android.support.design.a.a.gJ);
      ((ValueAnimator)localObject).setDuration(paramInt2);
      ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = paramAnonymousValueAnimator.getAnimatedFraction();
          TabLayout.e.this.q(android.support.design.a.a.b(k, j, f), android.support.design.a.a.b(m, i, f));
        }
      });
      ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          TabLayout.e.this.uT = paramInt1;
          TabLayout.e.this.uU = 0.0F;
        }
      });
      ((ValueAnimator)localObject).start();
    }
  }
  
  final class h
    extends LinearLayout
  {
    private View vd;
    private TabLayout.f vj;
    TextView vk;
    ImageView vl;
    TextView vm;
    ImageView vn;
    private Drawable vo;
    private int vp = 2;
    
    public h(Context paramContext)
    {
      super();
      J(paramContext);
      t.d(this, TabLayout.this.ue, TabLayout.this.uf, TabLayout.this.ug, TabLayout.this.uh);
      setGravity(17);
      if (TabLayout.this.uA) {}
      for (int i = 0;; i = 1)
      {
        setOrientation(i);
        setClickable(true);
        t.a(this, r.X(getContext()));
        return;
      }
    }
    
    private void J(Context paramContext)
    {
      Object localObject = null;
      GradientDrawable localGradientDrawable;
      ColorStateList localColorStateList;
      if (TabLayout.this.ur != 0)
      {
        this.vo = android.support.v7.c.a.a.l(paramContext, TabLayout.this.ur);
        if ((this.vo != null) && (this.vo.isStateful())) {
          this.vo.setState(getDrawableState());
        }
        localGradientDrawable = new GradientDrawable();
        ((GradientDrawable)localGradientDrawable).setColor(0);
        paramContext = localGradientDrawable;
        if (TabLayout.this.um != null)
        {
          paramContext = new GradientDrawable();
          paramContext.setCornerRadius(1.0E-005F);
          paramContext.setColor(-1);
          localColorStateList = android.support.design.e.a.b(TabLayout.this.um);
          if (Build.VERSION.SDK_INT < 21) {
            break label183;
          }
          if (TabLayout.this.uC) {
            localGradientDrawable = null;
          }
          if (!TabLayout.this.uC) {
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
        this.vo = null;
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
      if ((this.vj != null) && (this.vj.icon != null))
      {
        localDrawable = android.support.v4.graphics.drawable.a.i(this.vj.icon).mutate();
        if (this.vj == null) {
          break label217;
        }
        localCharSequence = this.vj.text;
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
        if (TabLayout.this.uA)
        {
          if (j != android.support.v4.view.g.b(paramTextView))
          {
            android.support.v4.view.g.a(paramTextView, j);
            paramTextView.bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
          label183:
          if (this.vj == null) {
            break label288;
          }
          paramTextView = this.vj.vc;
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
      if (this.vo != null)
      {
        bool1 = bool2;
        if (this.vo.isStateful()) {
          bool1 = this.vo.setState(arrayOfInt) | false;
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
      TextView localTextView = this.vk;
      ImageView localImageView = this.vl;
      View localView1 = this.vd;
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
      if (paramf != this.vj)
      {
        this.vj = paramf;
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
          i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.ut, -2147483648);
        }
      }
      super.onMeasure(i, paramInt2);
      float f2;
      float f1;
      if (this.vk != null)
      {
        f2 = TabLayout.this.up;
        j = this.vp;
        if ((this.vl == null) || (this.vl.getVisibility() != 0)) {
          break label285;
        }
        paramInt1 = 1;
        f1 = f2;
      }
      for (;;)
      {
        f2 = this.vk.getTextSize();
        m = this.vk.getLineCount();
        j = android.support.v4.widget.q.b(this.vk);
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
                Layout localLayout = this.vk.getLayout();
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
            this.vk.setTextSize(0, f1);
            this.vk.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
        return;
        label285:
        paramInt1 = j;
        f1 = f2;
        if (this.vk != null)
        {
          paramInt1 = j;
          f1 = f2;
          if (this.vk.getLineCount() > 1)
          {
            f1 = TabLayout.this.uq;
            paramInt1 = j;
          }
        }
      }
    }
    
    public final boolean performClick()
    {
      boolean bool2 = super.performClick();
      boolean bool1 = bool2;
      if (this.vj != null)
      {
        if (!bool2) {
          playSoundEffect(0);
        }
        this.vj.select();
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
        if (this.vk != null) {
          this.vk.setSelected(paramBoolean);
        }
        if (this.vl != null) {
          this.vl.setSelected(paramBoolean);
        }
        if (this.vd != null) {
          this.vd.setSelected(paramBoolean);
        }
        return;
      }
    }
    
    final void update()
    {
      TabLayout.f localf = this.vj;
      Object localObject;
      if (localf != null)
      {
        localObject = localf.vd;
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
        this.vd = ((View)localObject);
        if (this.vk != null) {
          this.vk.setVisibility(8);
        }
        if (this.vl != null)
        {
          this.vl.setVisibility(8);
          this.vl.setImageDrawable(null);
        }
        this.vm = ((TextView)((View)localObject).findViewById(16908308));
        if (this.vm != null) {
          this.vp = android.support.v4.widget.q.b(this.vm);
        }
        this.vn = ((ImageView)((View)localObject).findViewById(16908294));
        label140:
        if (this.vd != null) {
          break label423;
        }
        if (this.vl == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(2131493696, this, false);
          addView((View)localObject, 0);
          this.vl = ((ImageView)localObject);
        }
        if ((localf == null) || (localf.icon == null)) {
          break label418;
        }
        localObject = android.support.v4.graphics.drawable.a.i(localf.icon).mutate();
        label206:
        if (localObject != null)
        {
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.ul);
          if (TabLayout.this.uo != null) {
            android.support.v4.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.uo);
          }
        }
        if (this.vk == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(2131493697, this, false);
          addView((View)localObject);
          this.vk = ((TextView)localObject);
          this.vp = android.support.v4.widget.q.b(this.vk);
        }
        android.support.v4.widget.q.d(this.vk, TabLayout.this.uj);
        if (TabLayout.this.uk != null) {
          this.vk.setTextColor(TabLayout.this.uk);
        }
        a(this.vk, this.vl);
        label339:
        if ((localf != null) && (!TextUtils.isEmpty(localf.vc))) {
          setContentDescription(localf.vc);
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
        if (this.vd != null)
        {
          removeView(this.vd);
          this.vd = null;
        }
        this.vm = null;
        this.vn = null;
        break label140;
        localObject = null;
        break label206;
        if ((this.vm == null) && (this.vn == null)) {
          break label339;
        }
        a(this.vm, this.vn);
        break label339;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.TabLayout
 * JD-Core Version:    0.7.0.1
 */