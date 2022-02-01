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
import android.support.v4.view.u;
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
  private static final l.a<f> ug = new l.c(16);
  private int contentInsetStart;
  int mode;
  int uA = 2147483647;
  private final int uB;
  private final int uC;
  private final int uD;
  int uE;
  int uF;
  int uG;
  boolean uH;
  boolean uI;
  boolean uJ;
  private b uK;
  private final ArrayList<b> uL = new ArrayList();
  private b uM;
  private ValueAnimator uN;
  ViewPager uO;
  private android.support.v4.view.q uP;
  private DataSetObserver uQ;
  private g uR;
  private a uS;
  private boolean uT;
  private final l.a<h> uU = new l.b(12);
  private final ArrayList<f> uh = new ArrayList();
  private f uj;
  private final RectF uk = new RectF();
  private final e ul;
  int um;
  int un;
  int uo;
  int up;
  int uq;
  ColorStateList ur;
  ColorStateList ut;
  ColorStateList uu;
  Drawable uv;
  PorterDuff.Mode uw;
  float ux;
  float uy;
  final int uz;
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969610);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.ul = new e(paramContext);
    super.addView(this.ul, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = f.a(paramContext, paramAttributeSet, android.support.design.a.a.TabLayout, paramInt, 2131821689, new int[] { 22 });
    this.ul.ai(localTypedArray.getDimensionPixelSize(10, -1));
    this.ul.ah(localTypedArray.getColor(7, 0));
    setSelectedTabIndicator(android.support.design.d.a.c(paramContext, localTypedArray, 5));
    setSelectedTabIndicatorGravity(localTypedArray.getInt(9, 0));
    setTabIndicatorFullWidth(localTypedArray.getBoolean(8, true));
    paramInt = localTypedArray.getDimensionPixelSize(15, 0);
    this.up = paramInt;
    this.uo = paramInt;
    this.un = paramInt;
    this.um = paramInt;
    this.um = localTypedArray.getDimensionPixelSize(18, this.um);
    this.un = localTypedArray.getDimensionPixelSize(19, this.un);
    this.uo = localTypedArray.getDimensionPixelSize(17, this.uo);
    this.up = localTypedArray.getDimensionPixelSize(16, this.up);
    this.uq = localTypedArray.getResourceId(22, 2131821437);
    paramAttributeSet = paramContext.obtainStyledAttributes(this.uq, android.support.v7.a.a.a.TextAppearance);
    try
    {
      this.ux = paramAttributeSet.getDimensionPixelSize(0, 0);
      this.ur = android.support.design.d.a.b(paramContext, paramAttributeSet, 3);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(23)) {
        this.ur = android.support.design.d.a.b(paramContext, localTypedArray, 23);
      }
      if (localTypedArray.hasValue(21))
      {
        paramInt = localTypedArray.getColor(21, 0);
        int i = this.ur.getDefaultColor();
        this.ur = new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt, i });
      }
      this.ut = android.support.design.d.a.b(paramContext, localTypedArray, 3);
      this.uw = android.support.design.internal.g.a(localTypedArray.getInt(4, -1), null);
      this.uu = android.support.design.d.a.b(paramContext, localTypedArray, 20);
      this.uF = localTypedArray.getInt(6, 300);
      this.uB = localTypedArray.getDimensionPixelSize(13, -1);
      this.uC = localTypedArray.getDimensionPixelSize(12, -1);
      this.uz = localTypedArray.getResourceId(0, 0);
      this.contentInsetStart = localTypedArray.getDimensionPixelSize(1, 0);
      this.mode = localTypedArray.getInt(14, 1);
      this.uE = localTypedArray.getInt(2, 0);
      this.uH = localTypedArray.getBoolean(11, false);
      this.uJ = localTypedArray.getBoolean(24, false);
      localTypedArray.recycle();
      paramContext = getResources();
      this.uy = paramContext.getDimensionPixelSize(2131166175);
      this.uD = paramContext.getDimensionPixelSize(2131166173);
      dc();
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void a(TabItem paramTabItem)
  {
    f localf = cW();
    if (paramTabItem.text != null) {
      localf.d(paramTabItem.text);
    }
    if (paramTabItem.icon != null)
    {
      localf.icon = paramTabItem.icon;
      localf.updateView();
    }
    if (paramTabItem.uf != 0) {
      localf.aj(paramTabItem.uf);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription()))
    {
      localf.vj = paramTabItem.getContentDescription();
      localf.updateView();
    }
    a(localf);
  }
  
  private void a(f paramf, int paramInt, boolean paramBoolean)
  {
    if (paramf.vl != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    b(paramf, paramInt);
    d(paramf);
    if (paramBoolean) {
      paramf.select();
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mode == 1) && (this.uE == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private void ad(int paramInt)
  {
    h localh = (h)this.ul.getChildAt(paramInt);
    this.ul.removeViewAt(paramInt);
    if (localh != null)
    {
      localh.reset();
      this.uU.release(localh);
    }
    requestLayout();
  }
  
  private void ag(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (u.az(this)))
    {
      e locale = this.ul;
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
      db();
      this.uN.setIntValues(new int[] { i, j });
      this.uN.start();
    }
    this.ul.r(paramInt, this.uF);
  }
  
  private int b(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (this.mode == 0)
    {
      localView2 = this.ul.getChildAt(paramInt);
      if (paramInt + 1 >= this.ul.getChildCount()) {
        break label116;
      }
      localView1 = this.ul.getChildAt(paramInt + 1);
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
      if (u.Z(this) != 0) {
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
  
  private void b(f paramf, int paramInt)
  {
    paramf.position = paramInt;
    this.uh.add(paramInt, paramf);
    int i = this.uh.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((f)this.uh.get(paramInt)).position = paramInt;
      paramInt += 1;
    }
  }
  
  private static boolean b(f paramf)
  {
    return ug.release(paramf);
  }
  
  private h c(f paramf)
  {
    if (this.uU != null) {}
    h localh2;
    for (h localh1 = (h)this.uU.acquire();; localh1 = null)
    {
      localh2 = localh1;
      if (localh1 == null) {
        localh2 = new h(getContext());
      }
      localh2.l(paramf);
      localh2.setFocusable(true);
      localh2.setMinimumWidth(getTabMinWidth());
      if (!TextUtils.isEmpty(paramf.vj)) {
        break;
      }
      localh2.setContentDescription(paramf.text);
      return localh2;
    }
    localh2.setContentDescription(paramf.vj);
    return localh2;
  }
  
  private static f cX()
  {
    f localf2 = (f)ug.acquire();
    f localf1 = localf2;
    if (localf2 == null) {
      localf1 = new f();
    }
    return localf1;
  }
  
  private void cZ()
  {
    int j = this.uh.size();
    int i = 0;
    while (i < j)
    {
      ((f)this.uh.get(i)).updateView();
      i += 1;
    }
  }
  
  private void d(f paramf)
  {
    h localh = paramf.vm;
    this.ul.addView(localh, paramf.position, da());
  }
  
  private LinearLayout.LayoutParams da()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }
  
  private void db()
  {
    if (this.uN == null)
    {
      this.uN = new ValueAnimator();
      this.uN.setInterpolator(android.support.design.a.a.gL);
      this.uN.setDuration(this.uF);
      this.uN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
        }
      });
    }
  }
  
  private void dc()
  {
    if (this.mode == 0) {}
    for (int i = Math.max(0, this.contentInsetStart - this.um);; i = 0)
    {
      u.d(this.ul, i, 0, 0, 0);
      switch (this.mode)
      {
      }
      for (;;)
      {
        x(true);
        return;
        this.ul.setGravity(1);
        continue;
        this.ul.setGravity(8388611);
      }
    }
  }
  
  private void f(f paramf)
  {
    int i = this.uL.size() - 1;
    while (i >= 0)
    {
      ((b)this.uL.get(i)).i(paramf);
      i -= 1;
    }
  }
  
  private void g(f paramf)
  {
    int i = this.uL.size() - 1;
    while (i >= 0)
    {
      ((b)this.uL.get(i)).j(paramf);
      i -= 1;
    }
  }
  
  private int getDefaultHeight()
  {
    int j = this.uh.size();
    int i = 0;
    if (i < j)
    {
      f localf = (f)this.uh.get(i);
      if ((localf == null) || (localf.icon == null) || (TextUtils.isEmpty(localf.text))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (!this.uH))
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
    if (this.uB != -1) {
      return this.uB;
    }
    if (this.mode == 0) {
      return this.uD;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.ul.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void h(f paramf)
  {
    int i = this.uL.size() - 1;
    while (i >= 0)
    {
      ((b)this.uL.get(i)).k(paramf);
      i -= 1;
    }
  }
  
  private void removeAllTabs()
  {
    int i = this.ul.getChildCount() - 1;
    while (i >= 0)
    {
      ad(i);
      i -= 1;
    }
    Iterator localIterator = this.uh.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      localIterator.remove();
      localf.reset();
      b(localf);
    }
    this.uj = null;
  }
  
  private void setScrollPosition$4867b5c2(int paramInt)
  {
    a(paramInt, 0.0F, true, true);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = this.ul.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.ul.getChildAt(i);
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
  
  private void z(View paramView)
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
    if ((i < 0) || (i >= this.ul.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.ul.c(paramInt, paramFloat);
      }
      if ((this.uN != null) && (this.uN.isRunning())) {
        this.uN.cancel();
      }
      scrollTo(b(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    setSelectedTabView(i);
  }
  
  public final void a(b paramb)
  {
    if (!this.uL.contains(paramb)) {
      this.uL.add(paramb);
    }
  }
  
  public final void a(f paramf)
  {
    a(paramf, this.uh.isEmpty());
  }
  
  public final void a(f paramf, int paramInt)
  {
    a(paramf, paramInt, this.uh.isEmpty());
  }
  
  public final void a(f paramf, boolean paramBoolean)
  {
    a(paramf, this.uh.size(), paramBoolean);
  }
  
  public final void a(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.uO != null)
    {
      if (this.uR != null) {
        this.uO.removeOnPageChangeListener(this.uR);
      }
      if (this.uS != null) {
        this.uO.removeOnAdapterChangeListener(this.uS);
      }
    }
    if (this.uM != null)
    {
      b(this.uM);
      this.uM = null;
    }
    if (paramViewPager != null)
    {
      this.uO = paramViewPager;
      if (this.uR == null) {
        this.uR = new g(this);
      }
      this.uR.reset();
      paramViewPager.addOnPageChangeListener(this.uR);
      this.uM = new i(paramViewPager);
      a(this.uM);
      android.support.v4.view.q localq = paramViewPager.getAdapter();
      if (localq != null) {
        a(localq, paramBoolean1);
      }
      if (this.uS == null) {
        this.uS = new a();
      }
      this.uS.uW = paramBoolean1;
      paramViewPager.addOnAdapterChangeListener(this.uS);
      setScrollPosition$4867b5c2(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.uT = paramBoolean2;
      return;
      this.uO = null;
      a(null, false);
    }
  }
  
  final void a(android.support.v4.view.q paramq, boolean paramBoolean)
  {
    if ((this.uP != null) && (this.uQ != null)) {
      this.uP.unregisterDataSetObserver(this.uQ);
    }
    this.uP = paramq;
    if ((paramBoolean) && (paramq != null))
    {
      if (this.uQ == null) {
        this.uQ = new d();
      }
      paramq.registerDataSetObserver(this.uQ);
    }
    cY();
  }
  
  public final f ab(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount())) {
      return null;
    }
    return (f)this.uh.get(paramInt);
  }
  
  final int ac(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  public void addView(View paramView)
  {
    z(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    z(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    z(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    z(paramView);
  }
  
  public final void b(b paramb)
  {
    this.uL.remove(paramb);
  }
  
  final void b(f paramf, boolean paramBoolean)
  {
    f localf = this.uj;
    if (localf == paramf)
    {
      if (localf != null)
      {
        h(paramf);
        ag(paramf.position);
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
      this.uj = paramf;
      if (localf != null) {
        g(localf);
      }
      if (paramf == null) {
        break;
      }
      f(paramf);
      return;
      i = -1;
      break label40;
      label109:
      ag(i);
    }
  }
  
  public final f cW()
  {
    f localf = cX();
    localf.vl = this;
    localf.vm = c(localf);
    return localf;
  }
  
  final void cY()
  {
    removeAllTabs();
    if (this.uP != null)
    {
      int j = this.uP.getCount();
      int i = 0;
      while (i < j)
      {
        a(cW().d(this.uP.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.uO != null) && (j > 0))
      {
        i = this.uO.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          b(ab(i), true);
        }
      }
    }
  }
  
  final void e(f paramf)
  {
    b(paramf, true);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    if (this.uj != null) {
      return this.uj.position;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.uh.size();
  }
  
  public int getTabGravity()
  {
    return this.uE;
  }
  
  public ColorStateList getTabIconTint()
  {
    return this.ut;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.uG;
  }
  
  int getTabMaxWidth()
  {
    return this.uA;
  }
  
  public int getTabMode()
  {
    return this.mode;
  }
  
  public ColorStateList getTabRippleColor()
  {
    return this.uu;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return this.uv;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.ur;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.uO == null)
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
    if (this.uT)
    {
      setupWithViewPager(null);
      this.uT = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.ul.getChildCount())
    {
      View localView = this.ul.getChildAt(i);
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
    int i = ac(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    label76:
    View localView;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.uC > 0)
        {
          i = this.uC;
          this.uA = i;
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
      i -= ac(56);
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
  
  public final void removeTabAt(int paramInt)
  {
    if (this.uj != null) {}
    for (int i = this.uj.position;; i = 0)
    {
      ad(paramInt);
      localf = (f)this.uh.remove(paramInt);
      if (localf != null)
      {
        localf.reset();
        b(localf);
      }
      int k = this.uh.size();
      int j = paramInt;
      while (j < k)
      {
        ((f)this.uh.get(j)).position = j;
        j += 1;
      }
    }
    if (i == paramInt) {
      if (!this.uh.isEmpty()) {
        break label119;
      }
    }
    label119:
    for (f localf = null;; localf = (f)this.uh.get(Math.max(0, paramInt - 1)))
    {
      b(localf, true);
      return;
    }
  }
  
  public void setInlineLabel(boolean paramBoolean)
  {
    if (this.uH != paramBoolean)
    {
      this.uH = paramBoolean;
      int i = 0;
      if (i < this.ul.getChildCount())
      {
        Object localObject = this.ul.getChildAt(i);
        int j;
        if ((localObject instanceof h))
        {
          localObject = (h)localObject;
          if (!((h)localObject).uV.uH) {
            break label108;
          }
          j = 0;
          label64:
          ((h)localObject).setOrientation(j);
          if ((((h)localObject).vt == null) && (((h)localObject).vu == null)) {
            break label113;
          }
          ((h)localObject).a(((h)localObject).vt, ((h)localObject).vu);
        }
        for (;;)
        {
          i += 1;
          break;
          label108:
          j = 1;
          break label64;
          label113:
          ((h)localObject).a(((h)localObject).vr, ((h)localObject).vs);
        }
      }
      dc();
    }
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(b paramb)
  {
    if (this.uK != null) {
      b(this.uK);
    }
    this.uK = paramb;
    if (paramb != null) {
      a(paramb);
    }
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    db();
    this.uN.addListener(paramAnimatorListener);
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
    if (this.uv != paramDrawable)
    {
      this.uv = paramDrawable;
      u.X(this.ul);
    }
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.ul.ah(paramInt);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.uG != paramInt)
    {
      this.uG = paramInt;
      u.X(this.ul);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.ul.ai(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.uE != paramInt)
    {
      this.uE = paramInt;
      dc();
    }
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    if (this.ut != paramColorStateList)
    {
      this.ut = paramColorStateList;
      cZ();
    }
  }
  
  public void setTabIconTintResource(@android.support.annotation.a int paramInt)
  {
    setTabIconTint(android.support.v7.c.a.a.m(getContext(), paramInt));
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.uI = paramBoolean;
    u.X(this.ul);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      dc();
    }
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    if (this.uu != paramColorStateList)
    {
      this.uu = paramColorStateList;
      int i = 0;
      while (i < this.ul.getChildCount())
      {
        paramColorStateList = this.ul.getChildAt(i);
        if ((paramColorStateList instanceof h)) {
          h.a((h)paramColorStateList, getContext());
        }
        i += 1;
      }
    }
  }
  
  public void setTabRippleColorResource(@android.support.annotation.a int paramInt)
  {
    setTabRippleColor(android.support.v7.c.a.a.m(getContext(), paramInt));
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.ur != paramColorStateList)
    {
      this.ur = paramColorStateList;
      cZ();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(android.support.v4.view.q paramq)
  {
    a(paramq, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.uJ != paramBoolean)
    {
      this.uJ = paramBoolean;
      int i = 0;
      while (i < this.ul.getChildCount())
      {
        View localView = this.ul.getChildAt(i);
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
    while (i < this.ul.getChildCount())
    {
      View localView = this.ul.getChildAt(i);
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
    boolean uW;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, android.support.v4.view.q paramq1, android.support.v4.view.q paramq2)
    {
      if (TabLayout.this.uO == paramViewPager) {
        TabLayout.this.a(paramq2, this.uW);
      }
    }
  }
  
  public static abstract interface b<T extends TabLayout.f>
  {
    public abstract void i(T paramT);
    
    public abstract void j(T paramT);
    
    public abstract void k(T paramT);
  }
  
  public static abstract interface c
    extends TabLayout.b
  {}
  
  final class d
    extends DataSetObserver
  {
    d() {}
    
    public final void onChanged()
    {
      TabLayout.this.cY();
    }
    
    public final void onInvalidated()
    {
      TabLayout.this.cY();
    }
  }
  
  final class e
    extends LinearLayout
  {
    private int indicatorLeft = -1;
    private int indicatorRight = -1;
    private int layoutDirection = -1;
    private int uX;
    private final Paint uY;
    private final GradientDrawable uZ;
    int va = -1;
    float vb;
    private ValueAnimator vc;
    
    e(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      this.uY = new Paint();
      this.uZ = new GradientDrawable();
    }
    
    private void a(TabLayout.h paramh, RectF paramRectF)
    {
      int j = paramh.getContentWidth();
      int i = j;
      if (j < TabLayout.this.ac(24)) {
        i = TabLayout.this.ac(24);
      }
      j = (paramh.getLeft() + paramh.getRight()) / 2;
      int k = i / 2;
      i /= 2;
      paramRectF.set(j - k, 0.0F, i + j, 0.0F);
    }
    
    private void dd()
    {
      View localView = getChildAt(this.va);
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
        if (!TabLayout.this.uI)
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
        if (this.vb > 0.0F)
        {
          k = i;
          m = j;
          if (this.va < getChildCount() - 1)
          {
            localView = getChildAt(this.va + 1);
            m = localView.getLeft();
            k = localView.getRight();
            if ((TabLayout.this.uI) || (!(localView instanceof TabLayout.h))) {
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
        float f1 = this.vb;
        float f2 = m;
        float f3 = this.vb;
        m = (int)(j * (1.0F - f3) + f1 * f2);
        f1 = this.vb;
        f2 = k;
        f3 = this.vb;
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
    
    final void ah(int paramInt)
    {
      if (this.uY.getColor() != paramInt)
      {
        this.uY.setColor(paramInt);
        u.X(this);
      }
    }
    
    final void ai(int paramInt)
    {
      if (this.uX != paramInt)
      {
        this.uX = paramInt;
        u.X(this);
      }
    }
    
    final void c(int paramInt, float paramFloat)
    {
      if ((this.vc != null) && (this.vc.isRunning())) {
        this.vc.cancel();
      }
      this.va = paramInt;
      this.vb = paramFloat;
      dd();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (TabLayout.this.uv != null) {}
      for (int i = TabLayout.this.uv.getIntrinsicHeight();; i = 0)
      {
        if (this.uX >= 0) {
          i = this.uX;
        }
        int j;
        Object localObject;
        switch (TabLayout.this.uG)
        {
        default: 
          i = 0;
          j = 0;
          if ((this.indicatorLeft >= 0) && (this.indicatorRight > this.indicatorLeft))
          {
            if (TabLayout.this.uv == null) {
              break label238;
            }
            localObject = TabLayout.this.uv;
            label113:
            localObject = android.support.v4.graphics.drawable.a.i((Drawable)localObject);
            ((Drawable)localObject).setBounds(this.indicatorLeft, j, this.indicatorRight, i);
            if (this.uY != null)
            {
              if (Build.VERSION.SDK_INT != 21) {
                break label247;
              }
              ((Drawable)localObject).setColorFilter(this.uY.getColor(), PorterDuff.Mode.SRC_IN);
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
          localObject = this.uZ;
          break label113;
          label247:
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, this.uY.getColor());
        }
      }
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.vc != null) && (this.vc.isRunning()))
      {
        this.vc.cancel();
        long l = this.vc.getDuration();
        paramInt1 = this.va;
        float f = this.vc.getAnimatedFraction();
        r(paramInt1, Math.round((float)l * (1.0F - f)));
        return;
      }
      dd();
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
        break label15;
      }
      label15:
      while ((TabLayout.this.mode != 1) || (TabLayout.this.uE != 1)) {
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
        i = TabLayout.this.ac(16);
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
          TabLayout.this.uE = 0;
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
        u.X(this);
      }
    }
    
    final void r(final int paramInt1, int paramInt2)
    {
      if ((this.vc != null) && (this.vc.isRunning())) {
        this.vc.cancel();
      }
      Object localObject = getChildAt(paramInt1);
      if (localObject == null) {
        dd();
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
        if (!TabLayout.this.uI)
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
      this.vc = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setInterpolator(android.support.design.a.a.gL);
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
          TabLayout.e.this.va = paramInt1;
          TabLayout.e.this.vb = 0.0F;
        }
      });
      ((ValueAnimator)localObject).start();
    }
  }
  
  public static final class f
  {
    Drawable icon;
    int position = -1;
    private Object tag;
    CharSequence text;
    CharSequence vj;
    public View vk;
    public TabLayout vl;
    public TabLayout.h vm;
    
    private f A(View paramView)
    {
      this.vk = paramView;
      updateView();
      return this;
    }
    
    public final f aj(int paramInt)
    {
      return A(LayoutInflater.from(this.vm.getContext()).inflate(paramInt, this.vm, false));
    }
    
    public final f d(CharSequence paramCharSequence)
    {
      if ((TextUtils.isEmpty(this.vj)) && (!TextUtils.isEmpty(paramCharSequence))) {
        this.vm.setContentDescription(paramCharSequence);
      }
      this.text = paramCharSequence;
      updateView();
      return this;
    }
    
    public final f g(Object paramObject)
    {
      this.tag = paramObject;
      return this;
    }
    
    public final View getCustomView()
    {
      return this.vk;
    }
    
    public final int getPosition()
    {
      return this.position;
    }
    
    public final Object getTag()
    {
      return this.tag;
    }
    
    public final boolean isSelected()
    {
      if (this.vl == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      return this.vl.getSelectedTabPosition() == this.position;
    }
    
    final void reset()
    {
      this.vl = null;
      this.vm = null;
      this.tag = null;
      this.icon = null;
      this.text = null;
      this.vj = null;
      this.position = -1;
      this.vk = null;
    }
    
    public final void select()
    {
      if (this.vl == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      this.vl.e(this);
    }
    
    final void updateView()
    {
      if (this.vm != null) {
        this.vm.update();
      }
    }
  }
  
  public static final class g
    implements ViewPager.OnPageChangeListener
  {
    private final WeakReference<TabLayout> vn;
    private int vo;
    private int vp;
    
    public g(TabLayout paramTabLayout)
    {
      this.vn = new WeakReference(paramTabLayout);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      this.vo = this.vp;
      this.vp = paramInt;
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      boolean bool2 = false;
      TabLayout localTabLayout = (TabLayout)this.vn.get();
      if (localTabLayout != null) {
        if ((this.vp == 2) && (this.vo != 1)) {
          break label69;
        }
      }
      label69:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((this.vp != 2) || (this.vo != 0)) {
          bool2 = true;
        }
        localTabLayout.a(paramInt1, paramFloat, bool1, bool2);
        return;
      }
    }
    
    public final void onPageSelected(int paramInt)
    {
      TabLayout localTabLayout = (TabLayout)this.vn.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
        if ((this.vp != 0) && ((this.vp != 2) || (this.vo != 0))) {
          break label66;
        }
      }
      label66:
      for (boolean bool = true;; bool = false)
      {
        localTabLayout.b(localTabLayout.ab(paramInt), bool);
        return;
      }
    }
    
    final void reset()
    {
      this.vp = 0;
      this.vo = 0;
    }
  }
  
  final class h
    extends LinearLayout
  {
    private View vk;
    private TabLayout.f vq;
    TextView vr;
    ImageView vs;
    TextView vt;
    ImageView vu;
    private Drawable vv;
    private int vw = 2;
    
    public h(Context paramContext)
    {
      super();
      J(paramContext);
      u.d(this, TabLayout.this.um, TabLayout.this.un, TabLayout.this.uo, TabLayout.this.up);
      setGravity(17);
      if (TabLayout.this.uH) {}
      for (int i = 0;; i = 1)
      {
        setOrientation(i);
        setClickable(true);
        u.a(this, r.Y(getContext()));
        return;
      }
    }
    
    private void J(Context paramContext)
    {
      Object localObject = null;
      GradientDrawable localGradientDrawable;
      ColorStateList localColorStateList;
      if (TabLayout.this.uz != 0)
      {
        this.vv = android.support.v7.c.a.a.l(paramContext, TabLayout.this.uz);
        if ((this.vv != null) && (this.vv.isStateful())) {
          this.vv.setState(getDrawableState());
        }
        localGradientDrawable = new GradientDrawable();
        ((GradientDrawable)localGradientDrawable).setColor(0);
        paramContext = localGradientDrawable;
        if (TabLayout.this.uu != null)
        {
          paramContext = new GradientDrawable();
          paramContext.setCornerRadius(1.0E-005F);
          paramContext.setColor(-1);
          localColorStateList = android.support.design.e.a.b(TabLayout.this.uu);
          if (Build.VERSION.SDK_INT < 21) {
            break label183;
          }
          if (TabLayout.this.uJ) {
            localGradientDrawable = null;
          }
          if (!TabLayout.this.uJ) {
            break label180;
          }
          paramContext = localObject;
        }
      }
      label147:
      for (paramContext = new RippleDrawable(localColorStateList, localGradientDrawable, paramContext);; paramContext = new LayerDrawable(new Drawable[] { localGradientDrawable, paramContext }))
      {
        u.a(this, paramContext);
        TabLayout.this.invalidate();
        return;
        this.vv = null;
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
      if ((this.vq != null) && (this.vq.icon != null))
      {
        localDrawable = android.support.v4.graphics.drawable.a.i(this.vq.icon).mutate();
        if (this.vq == null) {
          break label217;
        }
        localCharSequence = this.vq.text;
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
      for (int j = TabLayout.this.ac(8);; j = 0)
      {
        if (TabLayout.this.uH)
        {
          if (j != android.support.v4.view.g.b(paramTextView))
          {
            android.support.v4.view.g.a(paramTextView, j);
            paramTextView.bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
          label183:
          if (this.vq == null) {
            break label288;
          }
          paramTextView = this.vq.vj;
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
      if (this.vv != null)
      {
        bool1 = bool2;
        if (this.vv.isStateful()) {
          bool1 = this.vv.setState(arrayOfInt) | false;
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
      TextView localTextView = this.vr;
      ImageView localImageView = this.vs;
      View localView1 = this.vk;
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
    
    final void l(TabLayout.f paramf)
    {
      if (paramf != this.vq)
      {
        this.vq = paramf;
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
          i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.uA, -2147483648);
        }
      }
      super.onMeasure(i, paramInt2);
      float f2;
      float f1;
      if (this.vr != null)
      {
        f2 = TabLayout.this.ux;
        j = this.vw;
        if ((this.vs == null) || (this.vs.getVisibility() != 0)) {
          break label285;
        }
        paramInt1 = 1;
        f1 = f2;
      }
      for (;;)
      {
        f2 = this.vr.getTextSize();
        m = this.vr.getLineCount();
        j = android.support.v4.widget.q.b(this.vr);
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
                Layout localLayout = this.vr.getLayout();
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
            this.vr.setTextSize(0, f1);
            this.vr.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
        return;
        label285:
        paramInt1 = j;
        f1 = f2;
        if (this.vr != null)
        {
          paramInt1 = j;
          f1 = f2;
          if (this.vr.getLineCount() > 1)
          {
            f1 = TabLayout.this.uy;
            paramInt1 = j;
          }
        }
      }
    }
    
    public final boolean performClick()
    {
      boolean bool2 = super.performClick();
      boolean bool1 = bool2;
      if (this.vq != null)
      {
        if (!bool2) {
          playSoundEffect(0);
        }
        this.vq.select();
        bool1 = true;
      }
      return bool1;
    }
    
    final void reset()
    {
      l(null);
      setSelected(false);
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
        if (this.vr != null) {
          this.vr.setSelected(paramBoolean);
        }
        if (this.vs != null) {
          this.vs.setSelected(paramBoolean);
        }
        if (this.vk != null) {
          this.vk.setSelected(paramBoolean);
        }
        return;
      }
    }
    
    final void update()
    {
      TabLayout.f localf = this.vq;
      Object localObject;
      if (localf != null)
      {
        localObject = localf.vk;
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
        this.vk = ((View)localObject);
        if (this.vr != null) {
          this.vr.setVisibility(8);
        }
        if (this.vs != null)
        {
          this.vs.setVisibility(8);
          this.vs.setImageDrawable(null);
        }
        this.vt = ((TextView)((View)localObject).findViewById(16908308));
        if (this.vt != null) {
          this.vw = android.support.v4.widget.q.b(this.vt);
        }
        this.vu = ((ImageView)((View)localObject).findViewById(16908294));
        label140:
        if (this.vk != null) {
          break label423;
        }
        if (this.vs == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(2131493827, this, false);
          addView((View)localObject, 0);
          this.vs = ((ImageView)localObject);
        }
        if ((localf == null) || (localf.icon == null)) {
          break label418;
        }
        localObject = android.support.v4.graphics.drawable.a.i(localf.icon).mutate();
        label206:
        if (localObject != null)
        {
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.ut);
          if (TabLayout.this.uw != null) {
            android.support.v4.graphics.drawable.a.a((Drawable)localObject, TabLayout.this.uw);
          }
        }
        if (this.vr == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(2131493828, this, false);
          addView((View)localObject);
          this.vr = ((TextView)localObject);
          this.vw = android.support.v4.widget.q.b(this.vr);
        }
        android.support.v4.widget.q.d(this.vr, TabLayout.this.uq);
        if (TabLayout.this.ur != null) {
          this.vr.setTextColor(TabLayout.this.ur);
        }
        a(this.vr, this.vs);
        label339:
        if ((localf != null) && (!TextUtils.isEmpty(localf.vj))) {
          setContentDescription(localf.vj);
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
        if (this.vk != null)
        {
          removeView(this.vk);
          this.vk = null;
        }
        this.vt = null;
        this.vu = null;
        break label140;
        localObject = null;
        break label206;
        if ((this.vt == null) && (this.vu == null)) {
          break label339;
        }
        a(this.vt, this.vu);
        break label339;
      }
    }
  }
  
  public static final class i
    implements TabLayout.c
  {
    private final ViewPager uO;
    
    public i(ViewPager paramViewPager)
    {
      this.uO = paramViewPager;
    }
    
    public final void i(TabLayout.f paramf)
    {
      this.uO.setCurrentItem(paramf.position);
    }
    
    public final void j(TabLayout.f paramf) {}
    
    public final void k(TabLayout.f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.TabLayout
 * JD-Core Version:    0.7.0.1
 */