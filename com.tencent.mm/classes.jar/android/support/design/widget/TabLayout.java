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
import android.support.v4.view.ViewPager.OnPageChangeListener;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout
  extends HorizontalScrollView
{
  private static final l.a<f> rg = new l.c(16);
  private int contentInsetStart;
  int mode;
  private final int rA;
  private final int rB;
  private final int rC;
  int rD;
  int rE;
  int rF;
  boolean rG;
  boolean rH;
  boolean rI;
  private b rJ;
  private final ArrayList<b> rK = new ArrayList();
  private b rL;
  private ValueAnimator rM;
  ViewPager rN;
  private android.support.v4.view.q rO;
  private DataSetObserver rP;
  private g rQ;
  private a rR;
  private boolean rS;
  private final l.a<h> rT = new l.b(12);
  private final ArrayList<f> rh = new ArrayList();
  private f ri;
  private final RectF rj = new RectF();
  private final e rk;
  int rl;
  int rm;
  int rn;
  int ro;
  int rp;
  ColorStateList rq;
  ColorStateList rs;
  ColorStateList rt;
  Drawable ru;
  PorterDuff.Mode rv;
  float rw;
  float rx;
  final int ry;
  int rz = 2147483647;
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969524);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.rk = new e(paramContext);
    super.addView(this.rk, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = f.a(paramContext, paramAttributeSet, android.support.design.a.a.TabLayout, paramInt, 2131821641, new int[] { 22 });
    this.rk.aj(localTypedArray.getDimensionPixelSize(10, -1));
    this.rk.ai(localTypedArray.getColor(7, 0));
    setSelectedTabIndicator(android.support.design.d.a.c(paramContext, localTypedArray, 5));
    setSelectedTabIndicatorGravity(localTypedArray.getInt(9, 0));
    setTabIndicatorFullWidth(localTypedArray.getBoolean(8, true));
    paramInt = localTypedArray.getDimensionPixelSize(15, 0);
    this.ro = paramInt;
    this.rn = paramInt;
    this.rm = paramInt;
    this.rl = paramInt;
    this.rl = localTypedArray.getDimensionPixelSize(18, this.rl);
    this.rm = localTypedArray.getDimensionPixelSize(19, this.rm);
    this.rn = localTypedArray.getDimensionPixelSize(17, this.rn);
    this.ro = localTypedArray.getDimensionPixelSize(16, this.ro);
    this.rp = localTypedArray.getResourceId(22, 2131821393);
    paramAttributeSet = paramContext.obtainStyledAttributes(this.rp, android.support.v7.a.a.a.TextAppearance);
    try
    {
      this.rw = paramAttributeSet.getDimensionPixelSize(0, 0);
      this.rq = android.support.design.d.a.b(paramContext, paramAttributeSet, 3);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(23)) {
        this.rq = android.support.design.d.a.b(paramContext, localTypedArray, 23);
      }
      if (localTypedArray.hasValue(21))
      {
        paramInt = localTypedArray.getColor(21, 0);
        int i = this.rq.getDefaultColor();
        this.rq = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt, i });
      }
      this.rs = android.support.design.d.a.b(paramContext, localTypedArray, 3);
      this.rv = android.support.design.internal.g.a(localTypedArray.getInt(4, -1), null);
      this.rt = android.support.design.d.a.b(paramContext, localTypedArray, 20);
      this.rE = localTypedArray.getInt(6, 300);
      this.rA = localTypedArray.getDimensionPixelSize(13, -1);
      this.rB = localTypedArray.getDimensionPixelSize(12, -1);
      this.ry = localTypedArray.getResourceId(0, 0);
      this.contentInsetStart = localTypedArray.getDimensionPixelSize(1, 0);
      this.mode = localTypedArray.getInt(14, 1);
      this.rD = localTypedArray.getInt(2, 0);
      this.rG = localTypedArray.getBoolean(11, false);
      this.rI = localTypedArray.getBoolean(24, false);
      localTypedArray.recycle();
      paramContext = getResources();
      this.rx = paramContext.getDimensionPixelSize(2131166134);
      this.rC = paramContext.getDimensionPixelSize(2131166132);
      cC();
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private h a(f paramf)
  {
    if (this.rT != null) {}
    h localh2;
    for (h localh1 = (h)this.rT.acquire();; localh1 = null)
    {
      localh2 = localh1;
      if (localh1 == null) {
        localh2 = new h(getContext());
      }
      localh2.i(paramf);
      localh2.setFocusable(true);
      localh2.setMinimumWidth(getTabMinWidth());
      if (!TextUtils.isEmpty(paramf.sj)) {
        break;
      }
      localh2.setContentDescription(paramf.text);
      return localh2;
    }
    localh2.setContentDescription(paramf.sj);
    return localh2;
  }
  
  private void a(TabItem paramTabItem)
  {
    f localf = cx();
    if (paramTabItem.text != null) {
      localf.d(paramTabItem.text);
    }
    if (paramTabItem.icon != null)
    {
      localf.icon = paramTabItem.icon;
      localf.cE();
    }
    if (paramTabItem.rf != 0) {
      localf.ak(paramTabItem.rf);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription()))
    {
      localf.sj = paramTabItem.getContentDescription();
      localf.cE();
    }
    a(localf, this.rh.isEmpty());
  }
  
  private void a(f paramf, int paramInt)
  {
    paramf.position = paramInt;
    this.rh.add(paramInt, paramf);
    int i = this.rh.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((f)this.rh.get(paramInt)).position = paramInt;
      paramInt += 1;
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mode == 1) && (this.rD == 0))
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
      e locale = this.rk;
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
      cB();
      this.rM.setIntValues(new int[] { i, j });
      this.rM.start();
    }
    this.rk.k(paramInt, this.rE);
  }
  
  private int b(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (this.mode == 0)
    {
      localView2 = this.rk.getChildAt(paramInt);
      if (paramInt + 1 >= this.rk.getChildCount()) {
        break label116;
      }
      localView1 = this.rk.getChildAt(paramInt + 1);
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
    this.rK.remove(paramb);
  }
  
  private void c(f paramf)
  {
    int i = this.rK.size() - 1;
    while (i >= 0)
    {
      ((b)this.rK.get(i)).f(paramf);
      i -= 1;
    }
  }
  
  private void cA()
  {
    int j = this.rh.size();
    int i = 0;
    while (i < j)
    {
      ((f)this.rh.get(i)).cE();
      i += 1;
    }
  }
  
  private void cB()
  {
    if (this.rM == null)
    {
      this.rM = new ValueAnimator();
      this.rM.setInterpolator(android.support.design.a.a.dQ);
      this.rM.setDuration(this.rE);
      this.rM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
        }
      });
    }
  }
  
  private void cC()
  {
    if (this.mode == 0) {}
    for (int i = Math.max(0, this.contentInsetStart - this.rl);; i = 0)
    {
      t.d(this.rk, i, 0, 0, 0);
      switch (this.mode)
      {
      }
      for (;;)
      {
        x(true);
        return;
        this.rk.setGravity(1);
        continue;
        this.rk.setGravity(8388611);
      }
    }
  }
  
  private static f cy()
  {
    f localf2 = (f)rg.acquire();
    f localf1 = localf2;
    if (localf2 == null) {
      localf1 = new f();
    }
    return localf1;
  }
  
  private void d(f paramf)
  {
    int i = this.rK.size() - 1;
    while (i >= 0)
    {
      ((b)this.rK.get(i)).g(paramf);
      i -= 1;
    }
  }
  
  private void e(f paramf)
  {
    int i = this.rK.size() - 1;
    while (i >= 0)
    {
      ((b)this.rK.get(i)).h(paramf);
      i -= 1;
    }
  }
  
  private int getDefaultHeight()
  {
    int j = this.rh.size();
    int i = 0;
    if (i < j)
    {
      f localf = (f)this.rh.get(i);
      if ((localf == null) || (localf.icon == null) || (TextUtils.isEmpty(localf.text))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (!this.rG))
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
    if (this.rA != -1) {
      return this.rA;
    }
    if (this.mode == 0) {
      return this.rC;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.rk.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void removeAllTabs()
  {
    int i = this.rk.getChildCount() - 1;
    while (i >= 0)
    {
      localObject = (h)this.rk.getChildAt(i);
      this.rk.removeViewAt(i);
      if (localObject != null)
      {
        ((h)localObject).i(null);
        ((h)localObject).setSelected(false);
        this.rT.release(localObject);
      }
      requestLayout();
      i -= 1;
    }
    Object localObject = this.rh.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      localf.sl = null;
      localf.sm = null;
      localf.tag = null;
      localf.icon = null;
      localf.text = null;
      localf.sj = null;
      localf.position = -1;
      localf.sk = null;
      rg.release(localf);
    }
    this.ri = null;
  }
  
  private void setScrollPosition$4867b5c2(int paramInt)
  {
    a(paramInt, 0.0F, true, true);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = this.rk.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.rk.getChildAt(i);
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
    if ((i < 0) || (i >= this.rk.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.rk.c(paramInt, paramFloat);
      }
      if ((this.rM != null) && (this.rM.isRunning())) {
        this.rM.cancel();
      }
      scrollTo(b(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    setSelectedTabView(i);
  }
  
  public final void a(b paramb)
  {
    if (!this.rK.contains(paramb)) {
      this.rK.add(paramb);
    }
  }
  
  public final void a(f paramf, boolean paramBoolean)
  {
    int i = this.rh.size();
    if (paramf.sl != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramf, i);
    h localh = paramf.sm;
    e locale = this.rk;
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
    if (this.rN != null)
    {
      if (this.rQ != null) {
        this.rN.removeOnPageChangeListener(this.rQ);
      }
      if (this.rR != null) {
        this.rN.removeOnAdapterChangeListener(this.rR);
      }
    }
    if (this.rL != null)
    {
      b(this.rL);
      this.rL = null;
    }
    if (paramViewPager != null)
    {
      this.rN = paramViewPager;
      if (this.rQ == null) {
        this.rQ = new g(this);
      }
      this.rQ.reset();
      paramViewPager.addOnPageChangeListener(this.rQ);
      this.rL = new TabLayout.i(paramViewPager);
      a(this.rL);
      android.support.v4.view.q localq = paramViewPager.getAdapter();
      if (localq != null) {
        a(localq, paramBoolean1);
      }
      if (this.rR == null) {
        this.rR = new a();
      }
      this.rR.rV = paramBoolean1;
      paramViewPager.addOnAdapterChangeListener(this.rR);
      setScrollPosition$4867b5c2(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.rS = paramBoolean2;
      return;
      this.rN = null;
      a(null, false);
    }
  }
  
  final void a(android.support.v4.view.q paramq, boolean paramBoolean)
  {
    if ((this.rO != null) && (this.rP != null)) {
      this.rO.unregisterDataSetObserver(this.rP);
    }
    this.rO = paramq;
    if ((paramBoolean) && (paramq != null))
    {
      if (this.rP == null) {
        this.rP = new d();
      }
      paramq.registerDataSetObserver(this.rP);
    }
    cz();
  }
  
  public final f ad(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount())) {
      return null;
    }
    return (f)this.rh.get(paramInt);
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
  
  final void b(f paramf)
  {
    b(paramf, true);
  }
  
  final void b(f paramf, boolean paramBoolean)
  {
    f localf = this.ri;
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
      this.ri = paramf;
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
  
  public final f cx()
  {
    f localf = cy();
    localf.sl = this;
    localf.sm = a(localf);
    return localf;
  }
  
  final void cz()
  {
    removeAllTabs();
    if (this.rO != null)
    {
      int j = this.rO.getCount();
      int i = 0;
      while (i < j)
      {
        a(cx().d(this.rO.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.rN != null) && (j > 0))
      {
        i = this.rN.getCurrentItem();
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
    if (this.ri != null) {
      return this.ri.position;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.rh.size();
  }
  
  public int getTabGravity()
  {
    return this.rD;
  }
  
  public ColorStateList getTabIconTint()
  {
    return this.rs;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.rF;
  }
  
  int getTabMaxWidth()
  {
    return this.rz;
  }
  
  public int getTabMode()
  {
    return this.mode;
  }
  
  public ColorStateList getTabRippleColor()
  {
    return this.rt;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return this.ru;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.rq;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.rN == null)
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
    if (this.rS)
    {
      setupWithViewPager(null);
      this.rS = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.rk.getChildCount())
    {
      View localView = this.rk.getChildAt(i);
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
        if (this.rB > 0)
        {
          i = this.rB;
          this.rz = i;
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
    if (this.rG != paramBoolean)
    {
      this.rG = paramBoolean;
      int i = 0;
      if (i < this.rk.getChildCount())
      {
        Object localObject = this.rk.getChildAt(i);
        int j;
        if ((localObject instanceof h))
        {
          localObject = (h)localObject;
          if (!((h)localObject).rU.rG) {
            break label108;
          }
          j = 0;
          label64:
          ((h)localObject).setOrientation(j);
          if ((((h)localObject).su == null) && (((h)localObject).sv == null)) {
            break label113;
          }
          ((h)localObject).a(((h)localObject).su, ((h)localObject).sv);
        }
        for (;;)
        {
          i += 1;
          break;
          label108:
          j = 1;
          break label64;
          label113:
          ((h)localObject).a(((h)localObject).ss, ((h)localObject).st);
        }
      }
      cC();
    }
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(b paramb)
  {
    if (this.rJ != null) {
      b(this.rJ);
    }
    this.rJ = paramb;
    if (paramb != null) {
      a(paramb);
    }
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    cB();
    this.rM.addListener(paramAnimatorListener);
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
    if (this.ru != paramDrawable)
    {
      this.ru = paramDrawable;
      t.W(this.rk);
    }
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.rk.ai(paramInt);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.rF != paramInt)
    {
      this.rF = paramInt;
      t.W(this.rk);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.rk.aj(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.rD != paramInt)
    {
      this.rD = paramInt;
      cC();
    }
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    if (this.rs != paramColorStateList)
    {
      this.rs = paramColorStateList;
      cA();
    }
  }
  
  public void setTabIconTintResource(int paramInt)
  {
    setTabIconTint(android.support.v7.c.a.a.m(getContext(), paramInt));
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.rH = paramBoolean;
    t.W(this.rk);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      cC();
    }
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    if (this.rt != paramColorStateList)
    {
      this.rt = paramColorStateList;
      int i = 0;
      while (i < this.rk.getChildCount())
      {
        paramColorStateList = this.rk.getChildAt(i);
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
    if (this.rq != paramColorStateList)
    {
      this.rq = paramColorStateList;
      cA();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(android.support.v4.view.q paramq)
  {
    a(paramq, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.rI != paramBoolean)
    {
      this.rI = paramBoolean;
      int i = 0;
      while (i < this.rk.getChildCount())
      {
        View localView = this.rk.getChildAt(i);
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
    while (i < this.rk.getChildCount())
    {
      View localView = this.rk.getChildAt(i);
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
    boolean rV;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, android.support.v4.view.q paramq1, android.support.v4.view.q paramq2)
    {
      if (TabLayout.this.rN == paramViewPager) {
        TabLayout.this.a(paramq2, this.rV);
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
      TabLayout.this.cz();
    }
    
    public final void onInvalidated()
    {
      TabLayout.this.cz();
    }
  }
  
  final class e
    extends LinearLayout
  {
    private int indicatorLeft = -1;
    private int indicatorRight = -1;
    private int layoutDirection = -1;
    private int rW;
    private final Paint rX;
    private final GradientDrawable rY;
    int rZ = -1;
    float sa;
    private ValueAnimator sc;
    
    e(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      this.rX = new Paint();
      this.rY = new GradientDrawable();
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
    
    private void cD()
    {
      View localView = getChildAt(this.rZ);
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
        if (!TabLayout.this.rH)
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
        if (this.sa > 0.0F)
        {
          k = i;
          m = j;
          if (this.rZ < getChildCount() - 1)
          {
            localView = getChildAt(this.rZ + 1);
            m = localView.getLeft();
            k = localView.getRight();
            if ((TabLayout.this.rH) || (!(localView instanceof TabLayout.h))) {
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
        float f1 = this.sa;
        float f2 = m;
        float f3 = this.sa;
        m = (int)(j * (1.0F - f3) + f1 * f2);
        f1 = this.sa;
        f2 = k;
        f3 = this.sa;
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
      if (this.rX.getColor() != paramInt)
      {
        this.rX.setColor(paramInt);
        t.W(this);
      }
    }
    
    final void aj(int paramInt)
    {
      if (this.rW != paramInt)
      {
        this.rW = paramInt;
        t.W(this);
      }
    }
    
    final void c(int paramInt, float paramFloat)
    {
      if ((this.sc != null) && (this.sc.isRunning())) {
        this.sc.cancel();
      }
      this.rZ = paramInt;
      this.sa = paramFloat;
      cD();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (TabLayout.this.ru != null) {}
      for (int i = TabLayout.this.ru.getIntrinsicHeight();; i = 0)
      {
        if (this.rW >= 0) {
          i = this.rW;
        }
        int j;
        Object localObject;
        switch (TabLayout.this.rF)
        {
        default: 
          i = 0;
          j = 0;
          if ((this.indicatorLeft >= 0) && (this.indicatorRight > this.indicatorLeft))
          {
            if (TabLayout.this.ru == null) {
              break label238;
            }
            localObject = TabLayout.this.ru;
            label113:
            localObject = android.support.v4.graphics.drawable.a.i((Drawable)localObject);
            ((Drawable)localObject).setBounds(this.indicatorLeft, j, this.indicatorRight, i);
            if (this.rX != null)
            {
              if (Build.VERSION.SDK_INT != 21) {
                break label247;
              }
              ((Drawable)localObject).setColorFilter(this.rX.getColor(), PorterDuff.Mode.SRC_IN);
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
          localObject = this.rY;
          break label113;
          label247:
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.rX.getColor());
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
      if ((this.sc != null) && (this.sc.isRunning())) {
        this.sc.cancel();
      }
      Object localObject = getChildAt(paramInt1);
      if (localObject == null) {
        cD();
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
        if (!TabLayout.this.rH)
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
      this.sc = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setInterpolator(android.support.design.a.a.dQ);
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
          TabLayout.e.this.rZ = paramInt1;
          TabLayout.e.this.sa = 0.0F;
        }
      });
      ((ValueAnimator)localObject).start();
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.sc != null) && (this.sc.isRunning()))
      {
        this.sc.cancel();
        long l = this.sc.getDuration();
        paramInt1 = this.rZ;
        float f = this.sc.getAnimatedFraction();
        k(paramInt1, Math.round((float)l * (1.0F - f)));
        return;
      }
      cD();
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
        break label16;
      }
      label16:
      while ((TabLayout.this.mode != 1) || (TabLayout.this.rD != 1)) {
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
          TabLayout.this.rD = 0;
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
  
  public static final class f
  {
    Drawable icon;
    int position = -1;
    CharSequence sj;
    public View sk;
    public TabLayout sl;
    public TabLayout.h sm;
    Object tag;
    CharSequence text;
    
    private f z(View paramView)
    {
      this.sk = paramView;
      cE();
      return this;
    }
    
    public final f ak(int paramInt)
    {
      return z(LayoutInflater.from(this.sm.getContext()).inflate(paramInt, this.sm, false));
    }
    
    final void cE()
    {
      if (this.sm != null) {
        this.sm.update();
      }
    }
    
    public final f d(CharSequence paramCharSequence)
    {
      if ((TextUtils.isEmpty(this.sj)) && (!TextUtils.isEmpty(paramCharSequence))) {
        this.sm.setContentDescription(paramCharSequence);
      }
      this.text = paramCharSequence;
      cE();
      return this;
    }
    
    public final f gb(Object paramObject)
    {
      this.tag = paramObject;
      return this;
    }
    
    public final View getCustomView()
    {
      return this.sk;
    }
    
    public final Object getTag()
    {
      return this.tag;
    }
    
    public final boolean isSelected()
    {
      if (this.sl == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      return this.sl.getSelectedTabPosition() == this.position;
    }
    
    public final void select()
    {
      if (this.sl == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      this.sl.b(this);
    }
  }
  
  public static final class g
    implements ViewPager.OnPageChangeListener
  {
    private final WeakReference<TabLayout> sn;
    private int so;
    private int sq;
    
    public g(TabLayout paramTabLayout)
    {
      this.sn = new WeakReference(paramTabLayout);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      this.so = this.sq;
      this.sq = paramInt;
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      boolean bool2 = false;
      TabLayout localTabLayout = (TabLayout)this.sn.get();
      if (localTabLayout != null) {
        if ((this.sq == 2) && (this.so != 1)) {
          break label69;
        }
      }
      label69:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((this.sq != 2) || (this.so != 0)) {
          bool2 = true;
        }
        localTabLayout.a(paramInt1, paramFloat, bool1, bool2);
        return;
      }
    }
    
    public final void onPageSelected(int paramInt)
    {
      TabLayout localTabLayout = (TabLayout)this.sn.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
        if ((this.sq != 0) && ((this.sq != 2) || (this.so != 0))) {
          break label66;
        }
      }
      label66:
      for (boolean bool = true;; bool = false)
      {
        localTabLayout.b(localTabLayout.ad(paramInt), bool);
        return;
      }
    }
    
    final void reset()
    {
      this.sq = 0;
      this.so = 0;
    }
  }
  
  final class h
    extends LinearLayout
  {
    private View sk;
    private TabLayout.f sr;
    TextView ss;
    ImageView st;
    TextView su;
    ImageView sv;
    private Drawable sw;
    private int sx = 2;
    
    public h(Context paramContext)
    {
      super();
      I(paramContext);
      t.d(this, TabLayout.this.rl, TabLayout.this.rm, TabLayout.this.rn, TabLayout.this.ro);
      setGravity(17);
      if (TabLayout.this.rG) {}
      for (int i = 0;; i = 1)
      {
        setOrientation(i);
        setClickable(true);
        t.a(this, r.V(getContext()));
        return;
      }
    }
    
    private void I(Context paramContext)
    {
      Object localObject = null;
      GradientDrawable localGradientDrawable;
      ColorStateList localColorStateList;
      if (TabLayout.this.ry != 0)
      {
        this.sw = android.support.v7.c.a.a.l(paramContext, TabLayout.this.ry);
        if ((this.sw != null) && (this.sw.isStateful())) {
          this.sw.setState(getDrawableState());
        }
        localGradientDrawable = new GradientDrawable();
        ((GradientDrawable)localGradientDrawable).setColor(0);
        paramContext = localGradientDrawable;
        if (TabLayout.this.rt != null)
        {
          paramContext = new GradientDrawable();
          paramContext.setCornerRadius(1.0E-005F);
          paramContext.setColor(-1);
          localColorStateList = android.support.design.e.a.b(TabLayout.this.rt);
          if (Build.VERSION.SDK_INT < 21) {
            break label183;
          }
          if (TabLayout.this.rI) {
            localGradientDrawable = null;
          }
          if (!TabLayout.this.rI) {
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
        this.sw = null;
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
      if ((this.sr != null) && (this.sr.icon != null))
      {
        localDrawable = android.support.v4.graphics.drawable.a.i(this.sr.icon).mutate();
        if (this.sr == null) {
          break label217;
        }
        localCharSequence = this.sr.text;
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
        if (TabLayout.this.rG)
        {
          if (j != android.support.v4.view.g.b(paramTextView))
          {
            android.support.v4.view.g.a(paramTextView, j);
            paramTextView.bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
          label183:
          if (this.sr == null) {
            break label288;
          }
          paramTextView = this.sr.sj;
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
      if (this.sw != null)
      {
        bool1 = bool2;
        if (this.sw.isStateful()) {
          bool1 = this.sw.setState(arrayOfInt) | false;
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
      TextView localTextView = this.ss;
      ImageView localImageView = this.st;
      View localView1 = this.sk;
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
      if (paramf != this.sr)
      {
        this.sr = paramf;
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
          i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.rz, -2147483648);
        }
      }
      super.onMeasure(i, paramInt2);
      float f2;
      float f1;
      if (this.ss != null)
      {
        f2 = TabLayout.this.rw;
        j = this.sx;
        if ((this.st == null) || (this.st.getVisibility() != 0)) {
          break label285;
        }
        paramInt1 = 1;
        f1 = f2;
      }
      for (;;)
      {
        f2 = this.ss.getTextSize();
        m = this.ss.getLineCount();
        j = android.support.v4.widget.q.b(this.ss);
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
                Layout localLayout = this.ss.getLayout();
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
            this.ss.setTextSize(0, f1);
            this.ss.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
        return;
        label285:
        paramInt1 = j;
        f1 = f2;
        if (this.ss != null)
        {
          paramInt1 = j;
          f1 = f2;
          if (this.ss.getLineCount() > 1)
          {
            f1 = TabLayout.this.rx;
            paramInt1 = j;
          }
        }
      }
    }
    
    public final boolean performClick()
    {
      boolean bool2 = super.performClick();
      boolean bool1 = bool2;
      if (this.sr != null)
      {
        if (!bool2) {
          playSoundEffect(0);
        }
        this.sr.select();
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
        if (this.ss != null) {
          this.ss.setSelected(paramBoolean);
        }
        if (this.st != null) {
          this.st.setSelected(paramBoolean);
        }
        if (this.sk != null) {
          this.sk.setSelected(paramBoolean);
        }
        return;
      }
    }
    
    final void update()
    {
      TabLayout.f localf = this.sr;
      Object localObject;
      if (localf != null)
      {
        localObject = localf.sk;
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
        this.sk = ((View)localObject);
        if (this.ss != null) {
          this.ss.setVisibility(8);
        }
        if (this.st != null)
        {
          this.st.setVisibility(8);
          this.st.setImageDrawable(null);
        }
        this.su = ((TextView)((View)localObject).findViewById(16908308));
        if (this.su != null) {
          this.sx = android.support.v4.widget.q.b(this.su);
        }
        this.sv = ((ImageView)((View)localObject).findViewById(16908294));
        label140:
        if (this.sk != null) {
          break label423;
        }
        if (this.st == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(2131493696, this, false);
          addView((View)localObject, 0);
          this.st = ((ImageView)localObject);
        }
        if ((localf == null) || (localf.icon == null)) {
          break label418;
        }
        localObject = android.support.v4.graphics.drawable.a.i(localf.icon).mutate();
        label206:
        if (localObject != null)
        {
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.rs);
          if (TabLayout.this.rv != null) {
            android.support.v4.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.rv);
          }
        }
        if (this.ss == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(2131493697, this, false);
          addView((View)localObject);
          this.ss = ((TextView)localObject);
          this.sx = android.support.v4.widget.q.b(this.ss);
        }
        android.support.v4.widget.q.d(this.ss, TabLayout.this.rp);
        if (TabLayout.this.rq != null) {
          this.ss.setTextColor(TabLayout.this.rq);
        }
        a(this.ss, this.st);
        label339:
        if ((localf != null) && (!TextUtils.isEmpty(localf.sj))) {
          setContentDescription(localf.sj);
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
        if (this.sk != null)
        {
          removeView(this.sk);
          this.sk = null;
        }
        this.su = null;
        this.sv = null;
        break label140;
        localObject = null;
        break label206;
        if ((this.su == null) && (this.sv == null)) {
          break label339;
        }
        a(this.su, this.sv);
        break label339;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.TabLayout
 * JD-Core Version:    0.7.0.1
 */