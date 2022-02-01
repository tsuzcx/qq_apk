package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.a;
import android.support.design.internal.f;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ab;
import android.support.v4.view.p;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.b(Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  List<a> listeners;
  private int mQ = -1;
  private int mR = -1;
  private int mS = -1;
  boolean mT;
  int mU = 0;
  ab mV;
  private boolean mW;
  private boolean mZ;
  private boolean na;
  boolean nb;
  private int[] nc;
  
  public AppBarLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      q.A(this);
      q.a(this, paramAttributeSet);
    }
    paramContext = f.a(paramContext, paramAttributeSet, a.a.AppBarLayout, 0, 2131821633, new int[0]);
    t.a(this, paramContext.getDrawable(0));
    if (paramContext.hasValue(4)) {
      b(paramContext.getBoolean(4, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.hasValue(3))) {
      q.c(this, paramContext.getDimensionPixelSize(3, 0));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramContext.hasValue(2)) {
        setKeyboardNavigationCluster(paramContext.getBoolean(2, false));
      }
      if (paramContext.hasValue(1)) {
        setTouchscreenBlocksFocus(paramContext.getBoolean(1, false));
      }
    }
    this.nb = paramContext.getBoolean(5, false);
    paramContext.recycle();
    t.a(this, new p()
    {
      public final ab a(View paramAnonymousView, ab paramAnonymousab)
      {
        AppBarLayout localAppBarLayout = AppBarLayout.this;
        paramAnonymousView = null;
        if (t.aq(localAppBarLayout)) {
          paramAnonymousView = paramAnonymousab;
        }
        if (!android.support.v4.e.j.equals(localAppBarLayout.mV, paramAnonymousView))
        {
          localAppBarLayout.mV = paramAnonymousView;
          localAppBarLayout.bL();
        }
        return paramAnonymousab;
      }
    });
  }
  
  private static LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  private LayoutParams b(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  private static LayoutParams bN()
  {
    return new LayoutParams(-2);
  }
  
  final void F(int paramInt)
  {
    if (this.listeners != null)
    {
      int j = this.listeners.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.listeners.get(i);
        if (locala != null) {
          locala.c(this, paramInt);
        }
        i += 1;
      }
    }
  }
  
  public final void a(b paramb)
  {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    if ((paramb != null) && (!this.listeners.contains(paramb))) {
      this.listeners.add(paramb);
    }
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label48;
      }
    }
    label48:
    for (int j = 4;; j = 0)
    {
      if (paramBoolean3) {
        k = 8;
      }
      this.mU = (k | j | i);
      requestLayout();
      return;
      i = 2;
      break;
    }
  }
  
  final void bL()
  {
    this.mQ = -1;
    this.mR = -1;
    this.mS = -1;
  }
  
  public final void bM()
  {
    b(true, true, true);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  int getDownNestedPreScrollRange()
  {
    if (this.mR != -1) {
      return this.mR;
    }
    int j = getChildCount() - 1;
    int i = 0;
    if (j >= 0)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int k = localView.getMeasuredHeight();
      int m = localLayoutParams.ns;
      if ((m & 0x5) == 5)
      {
        n = localLayoutParams.topMargin;
        i = localLayoutParams.bottomMargin + n + i;
        if ((m & 0x8) != 0) {
          i += t.af(localView);
        }
      }
      while (i <= 0) {
        for (;;)
        {
          int n;
          j -= 1;
          break;
          if ((m & 0x2) != 0) {
            i += k - t.af(localView);
          } else {
            i += k - getTopInset();
          }
        }
      }
    }
    i = Math.max(0, i);
    this.mR = i;
    return i;
  }
  
  int getDownNestedScrollRange()
  {
    if (this.mS != -1) {
      return this.mS;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = localLayoutParams.topMargin;
      int i2 = localLayoutParams.bottomMargin;
      int m = localLayoutParams.ns;
      if ((m & 0x1) != 0)
      {
        i += n + (i1 + i2);
        if ((m & 0x2) != 0) {
          i -= t.af(localView) + getTopInset();
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i);
      this.mS = i;
      return i;
      j += 1;
      break;
    }
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int j = getTopInset();
    int i = t.af(this);
    if (i != 0) {
      return i * 2 + j;
    }
    i = getChildCount();
    if (i > 0) {}
    for (i = t.af(getChildAt(i - 1)); i != 0; i = 0) {
      return i * 2 + j;
    }
    return getHeight() / 3;
  }
  
  int getPendingAction()
  {
    return this.mU;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  final int getTopInset()
  {
    if (this.mV != null) {
      return this.mV.getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    if (this.mQ != -1) {
      return this.mQ;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int m = localLayoutParams.ns;
      if ((m & 0x1) != 0)
      {
        int i1 = localLayoutParams.topMargin;
        i += localLayoutParams.bottomMargin + (n + i1);
        if ((m & 0x2) != 0) {
          i -= t.af(localView);
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i - getTopInset());
      this.mQ = i;
      return i;
      j += 1;
      break;
    }
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.nc == null) {
      this.nc = new int[4];
    }
    int[] arrayOfInt1 = this.nc;
    int[] arrayOfInt2 = super.onCreateDrawableState(arrayOfInt1.length + paramInt);
    if (this.mZ)
    {
      paramInt = 2130969481;
      arrayOfInt1[0] = paramInt;
      if ((!this.mZ) || (!this.na)) {
        break label115;
      }
      paramInt = 2130969482;
      label61:
      arrayOfInt1[1] = paramInt;
      if (!this.mZ) {
        break label122;
      }
      paramInt = 2130969480;
      label76:
      arrayOfInt1[2] = paramInt;
      if ((!this.mZ) || (!this.na)) {
        break label129;
      }
    }
    label129:
    for (paramInt = 2130969479;; paramInt = -2130969479)
    {
      arrayOfInt1[3] = paramInt;
      return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
      paramInt = -2130969481;
      break;
      label115:
      paramInt = -2130969482;
      break label61;
      label122:
      paramInt = -2130969480;
      break label76;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    bL();
    this.mT = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).nt != null) {
        this.mT = true;
      }
    }
    else if (!this.mW) {
      if (!this.nb)
      {
        paramInt3 = getChildCount();
        paramInt1 = 0;
        label76:
        if (paramInt1 >= paramInt3) {
          break label168;
        }
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(paramInt1).getLayoutParams();
        if (((localLayoutParams.ns & 0x1) != 1) || ((localLayoutParams.ns & 0xA) == 0)) {
          break label156;
        }
        paramInt2 = 1;
        label119:
        if (paramInt2 == 0) {
          break label161;
        }
        paramInt1 = 1;
        label125:
        if (paramInt1 == 0) {
          break label173;
        }
      }
    }
    label156:
    label161:
    label168:
    label173:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (this.mZ != paramBoolean)
      {
        this.mZ = paramBoolean;
        refreshDrawableState();
      }
      return;
      paramInt1 += 1;
      break;
      paramInt2 = 0;
      break label119;
      paramInt1 += 1;
      break label76;
      paramInt1 = 0;
      break label125;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    bL();
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    b(paramBoolean, t.ay(this), true);
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.nb = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt != 1) {
      throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }
    super.setOrientation(paramInt);
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      q.c(this, paramFloat);
    }
  }
  
  final boolean t(boolean paramBoolean)
  {
    if (this.na != paramBoolean)
    {
      this.na = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  public static class BaseBehavior<T extends AppBarLayout>
    extends HeaderBehavior<T>
  {
    private int ne;
    private int nf;
    private ValueAnimator ng;
    private int nh = -1;
    private boolean ni;
    private float nj;
    private WeakReference<View> nk;
    private a nl;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private static int a(T paramT, int paramInt)
    {
      int i = 0;
      int m = paramT.getChildCount();
      int k;
      int j;
      if (i < m)
      {
        Object localObject = paramT.getChildAt(i);
        k = ((View)localObject).getTop();
        j = ((View)localObject).getBottom();
        localObject = (AppBarLayout.LayoutParams)((View)localObject).getLayoutParams();
        if (!o(((AppBarLayout.LayoutParams)localObject).ns, 32)) {
          break label99;
        }
        k -= ((AppBarLayout.LayoutParams)localObject).topMargin;
        j = ((AppBarLayout.LayoutParams)localObject).bottomMargin + j;
      }
      label99:
      for (;;)
      {
        if ((k <= -paramInt) && (j >= -paramInt)) {
          return i;
        }
        i += 1;
        break;
        return -1;
      }
    }
    
    private static View a(CoordinatorLayout paramCoordinatorLayout)
    {
      int j = paramCoordinatorLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramCoordinatorLayout.getChildAt(i);
        if ((localView instanceof android.support.v4.view.j)) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    private void a(int paramInt1, T paramT, View paramView, int paramInt2)
    {
      if (paramInt2 == 1)
      {
        paramInt2 = bO();
        if (((paramInt1 < 0) && (paramInt2 == 0)) || ((paramInt1 > 0) && (paramInt2 == -paramT.getDownNestedScrollRange()))) {
          t.ax(paramView);
        }
      }
    }
    
    private void a(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      int n = bO();
      int k = a(paramT, n);
      View localView;
      int i1;
      int m;
      int i;
      int j;
      if (k >= 0)
      {
        localView = paramT.getChildAt(k);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        i1 = localLayoutParams.ns;
        if ((i1 & 0x11) == 17)
        {
          m = -localView.getTop();
          i = -localView.getBottom();
          j = i;
          if (k == paramT.getChildCount() - 1) {
            j = i + paramT.getTopInset();
          }
          if (!o(i1, 2)) {
            break label179;
          }
          i = j + t.af(localView);
          k = m;
          m = i;
          j = k;
          if (o(i1, 32))
          {
            j = k + localLayoutParams.topMargin;
            m = i - localLayoutParams.bottomMargin;
          }
          if (n >= (m + j) / 2) {
            break label226;
          }
        }
      }
      for (;;)
      {
        a(paramCoordinatorLayout, paramT, android.support.v4.b.a.clamp(m, -paramT.getTotalScrollRange(), 0));
        return;
        label179:
        i = j;
        k = m;
        if (!o(i1, 5)) {
          break;
        }
        i = t.af(localView) + j;
        if (n < i)
        {
          k = i;
          i = j;
          break;
        }
        k = m;
        break;
        label226:
        m = j;
      }
    }
    
    private void a(final CoordinatorLayout paramCoordinatorLayout, final T paramT, int paramInt)
    {
      int i = Math.abs(bO() - paramInt);
      float f = Math.abs(0.0F);
      if (f > 0.0F) {}
      int j;
      for (i = Math.round(i / f * 1000.0F) * 3;; i = (int)((i / paramT.getHeight() + 1.0F) * 150.0F))
      {
        j = bO();
        if (j != paramInt) {
          break;
        }
        if ((this.ng != null) && (this.ng.isRunning())) {
          this.ng.cancel();
        }
        return;
      }
      if (this.ng == null)
      {
        this.ng = new ValueAnimator();
        this.ng.setInterpolator(android.support.design.a.a.gM);
        this.ng.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppBarLayout.BaseBehavior.this.b(paramCoordinatorLayout, paramT, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
      }
      for (;;)
      {
        this.ng.setDuration(Math.min(i, 600));
        this.ng.setIntValues(new int[] { j, paramInt });
        this.ng.start();
        return;
        this.ng.cancel();
      }
    }
    
    private static void a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      boolean bool3 = true;
      View localView = b(paramT, paramInt1);
      int i;
      int j;
      boolean bool1;
      if (localView != null)
      {
        i = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).ns;
        if ((i & 0x1) == 0) {
          break label205;
        }
        j = t.af(localView);
        if ((paramInt2 <= 0) || ((i & 0xC) == 0)) {
          break label162;
        }
        if (-paramInt1 < localView.getBottom() - j - paramT.getTopInset()) {
          break label156;
        }
        bool1 = true;
      }
      for (;;)
      {
        boolean bool2 = bool1;
        if (paramT.nb)
        {
          localView = a(paramCoordinatorLayout);
          bool2 = bool1;
          if (localView != null) {
            if (localView.getScrollY() <= 0) {
              break label199;
            }
          }
        }
        label156:
        label162:
        label199:
        for (bool1 = bool3;; bool1 = false)
        {
          bool2 = bool1;
          bool1 = paramT.t(bool2);
          if ((Build.VERSION.SDK_INT >= 11) && ((paramBoolean) || ((bool1) && (b(paramCoordinatorLayout, paramT))))) {
            paramT.jumpDrawablesToCurrentState();
          }
          return;
          bool1 = false;
          break;
          if ((i & 0x2) == 0) {
            break label205;
          }
          if (-paramInt1 >= localView.getBottom() - j - paramT.getTopInset())
          {
            bool1 = true;
            break;
          }
          bool1 = false;
          break;
        }
        label205:
        bool1 = false;
      }
    }
    
    private static View b(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramAppBarLayout.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        View localView = paramAppBarLayout.getChildAt(paramInt);
        if ((i >= localView.getTop()) && (i <= localView.getBottom())) {
          return localView;
        }
        paramInt += 1;
      }
      return null;
    }
    
    private static boolean b(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      paramCoordinatorLayout = paramCoordinatorLayout.t(paramT);
      int j = paramCoordinatorLayout.size();
      int i = 0;
      while (i < j)
      {
        paramT = ((CoordinatorLayout.d)((View)paramCoordinatorLayout.get(i)).getLayoutParams()).qA;
        if ((paramT instanceof AppBarLayout.ScrollingViewBehavior)) {
          return ((AppBarLayout.ScrollingViewBehavior)paramT).se != 0;
        }
        i += 1;
      }
      return false;
    }
    
    private static boolean o(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }
    
    public void a(a parama)
    {
      this.nl = parama;
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, Parcelable paramParcelable)
    {
      if ((paramParcelable instanceof SavedState))
      {
        paramParcelable = (SavedState)paramParcelable;
        super.a(paramCoordinatorLayout, paramT, paramParcelable.Pa);
        this.nh = paramParcelable.np;
        this.nj = paramParcelable.nq;
        this.ni = paramParcelable.nr;
        return;
      }
      super.a(paramCoordinatorLayout, paramT, paramParcelable);
      this.nh = -1;
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt)
    {
      if ((this.nf == 0) || (paramInt == 1)) {
        a(paramCoordinatorLayout, paramT);
      }
      this.nk = new WeakReference(paramView);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      boolean bool = false;
      if (paramInt4 < 0)
      {
        b(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
        a(paramInt4, paramT, paramView, paramInt5);
      }
      if (paramT.nb)
      {
        if (paramView.getScrollY() > 0) {
          bool = true;
        }
        paramT.t(bool);
      }
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 >= 0) {
          break label60;
        }
        paramInt1 = -paramT.getTotalScrollRange();
      }
      for (int i = paramInt1 + paramT.getDownNestedPreScrollRange();; i = 0)
      {
        if (paramInt1 != i)
        {
          paramArrayOfInt[1] = b(paramCoordinatorLayout, paramT, paramInt2, paramInt1, i);
          a(paramInt2, paramT, paramView, paramInt3);
        }
        return;
        label60:
        paramInt1 = -paramT.getUpNestedPreScrollRange();
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (((CoordinatorLayout.d)paramT.getLayoutParams()).height == -2)
      {
        paramCoordinatorLayout.a(paramT, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        return true;
      }
      return super.a(paramCoordinatorLayout, paramT, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      boolean bool2 = true;
      if ((paramInt1 & 0x2) != 0)
      {
        bool1 = bool2;
        if (!paramT.nb)
        {
          if (paramT.getTotalScrollRange() == 0) {
            break label97;
          }
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramCoordinatorLayout.getHeight() - paramView1.getHeight() > paramT.getHeight())) {
            break label103;
          }
          paramInt1 = 1;
          label55:
          if (paramInt1 == 0) {
            break label109;
          }
        }
      }
      label97:
      label103:
      label109:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if ((bool1) && (this.ng != null)) {
          this.ng.cancel();
        }
        this.nk = null;
        this.nf = paramInt2;
        return bool1;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label55;
      }
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt)
    {
      boolean bool = super.a(paramCoordinatorLayout, paramT, paramInt);
      int i = paramT.getPendingAction();
      View localView;
      if ((this.nh >= 0) && ((i & 0x8) == 0))
      {
        localView = paramT.getChildAt(this.nh);
        paramInt = -localView.getBottom();
        if (this.ni)
        {
          paramInt = t.af(localView) + paramT.getTopInset() + paramInt;
          b(paramCoordinatorLayout, paramT, paramInt);
        }
      }
      for (;;)
      {
        paramT.mU = 0;
        this.nh = -1;
        G(android.support.v4.b.a.clamp(bR(), -paramT.getTotalScrollRange(), 0));
        a(paramCoordinatorLayout, paramT, bR(), 0, true);
        paramT.F(bR());
        return bool;
        paramInt = Math.round(localView.getHeight() * this.nj) + paramInt;
        break;
        if (i != 0)
        {
          if ((i & 0x4) != 0) {
            paramInt = 1;
          }
          for (;;)
          {
            if ((i & 0x2) != 0)
            {
              i = -paramT.getUpNestedPreScrollRange();
              if (paramInt != 0)
              {
                a(paramCoordinatorLayout, paramT, i);
                break;
                paramInt = 0;
                continue;
              }
              b(paramCoordinatorLayout, paramT, i);
              break;
            }
          }
          if ((i & 0x1) != 0) {
            if (paramInt != 0) {
              a(paramCoordinatorLayout, paramT, 0);
            } else {
              b(paramCoordinatorLayout, paramT, 0);
            }
          }
        }
      }
    }
    
    final int bO()
    {
      return bR() + this.ne;
    }
    
    public Parcelable c(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      boolean bool = false;
      Object localObject = super.b(paramCoordinatorLayout, paramT);
      int j = bR();
      int k = paramT.getChildCount();
      int i = 0;
      while (i < k)
      {
        paramCoordinatorLayout = paramT.getChildAt(i);
        int m = paramCoordinatorLayout.getBottom() + j;
        if ((paramCoordinatorLayout.getTop() + j <= 0) && (m >= 0))
        {
          localObject = new SavedState((Parcelable)localObject);
          ((SavedState)localObject).np = i;
          if (m == t.af(paramCoordinatorLayout) + paramT.getTopInset()) {
            bool = true;
          }
          ((SavedState)localObject).nr = bool;
          ((SavedState)localObject).nq = (m / paramCoordinatorLayout.getHeight());
          return localObject;
        }
        i += 1;
      }
      return localObject;
    }
    
    protected static class SavedState
      extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
      int np;
      float nq;
      boolean nr;
      
      public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        this.np = paramParcel.readInt();
        this.nq = paramParcel.readFloat();
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.nr = bool;
          return;
        }
      }
      
      public SavedState(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.np);
        paramParcel.writeFloat(this.nq);
        if (this.nr) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeByte((byte)paramInt);
          return;
        }
      }
    }
    
    public static abstract class a<T extends AppBarLayout>
    {
      public abstract boolean bQ();
    }
  }
  
  public static class Behavior
    extends AppBarLayout.BaseBehavior<AppBarLayout>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    public int ns = 1;
    Interpolator nt;
    
    public LayoutParams(int paramInt)
    {
      super(paramInt);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.AppBarLayout_Layout);
      this.ns = paramAttributeSet.getInt(0, 0);
      if (paramAttributeSet.hasValue(1)) {
        this.nt = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(1, 0));
      }
      paramAttributeSet.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static class ScrollingViewBehavior
    extends HeaderScrollingViewBehavior
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ScrollingViewBehavior_Layout);
      this.se = paramContext.getDimensionPixelSize(0, 0);
      paramContext.recycle();
    }
    
    private static AppBarLayout d(List<View> paramList)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramList.get(i);
        if ((localView instanceof AppBarLayout)) {
          return (AppBarLayout)localView;
        }
        i += 1;
      }
      return null;
    }
    
    public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
    {
      AppBarLayout localAppBarLayout = d(paramCoordinatorLayout.s(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramView = this.sa;
        paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!paramView.contains(paramRect))
        {
          if (!paramBoolean) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localAppBarLayout.b(false, paramBoolean, true);
            return true;
          }
        }
      }
      return false;
    }
    
    public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      paramCoordinatorLayout = ((CoordinatorLayout.d)paramView2.getLayoutParams()).qA;
      if ((paramCoordinatorLayout instanceof AppBarLayout.BaseBehavior))
      {
        paramCoordinatorLayout = (AppBarLayout.BaseBehavior)paramCoordinatorLayout;
        int i = paramView2.getBottom();
        int j = paramView1.getTop();
        t.s(paramView1, AppBarLayout.BaseBehavior.a(paramCoordinatorLayout) + (i - j) + this.sd - v(paramView2));
      }
      if ((paramView2 instanceof AppBarLayout))
      {
        paramCoordinatorLayout = (AppBarLayout)paramView2;
        if (paramCoordinatorLayout.nb) {
          if (paramView1.getScrollY() <= 0) {
            break label98;
          }
        }
      }
      label98:
      for (boolean bool = true;; bool = false)
      {
        paramCoordinatorLayout.t(bool);
        return false;
      }
    }
    
    public final boolean a(View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
    
    final float h(View paramView)
    {
      if ((paramView instanceof AppBarLayout))
      {
        paramView = (AppBarLayout)paramView;
        int j = paramView.getTotalScrollRange();
        int k = paramView.getDownNestedPreScrollRange();
        paramView = ((CoordinatorLayout.d)paramView.getLayoutParams()).qA;
        if ((paramView instanceof AppBarLayout.BaseBehavior)) {}
        for (int i = ((AppBarLayout.BaseBehavior)paramView).bO(); (k != 0) && (j + i <= k); i = 0) {
          return 0.0F;
        }
        j -= k;
        if (j != 0) {
          return i / j + 1.0F;
        }
      }
      return 0.0F;
    }
    
    final int i(View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        return ((AppBarLayout)paramView).getTotalScrollRange();
      }
      return super.i(paramView);
    }
  }
  
  public static abstract interface a<T extends AppBarLayout>
  {
    public abstract void c(T paramT, int paramInt);
  }
  
  public static abstract interface b
    extends AppBarLayout.a<AppBarLayout>
  {
    public abstract void c(AppBarLayout paramAppBarLayout, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout
 * JD-Core Version:    0.7.0.1
 */