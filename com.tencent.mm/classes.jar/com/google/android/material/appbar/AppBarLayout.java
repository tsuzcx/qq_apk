package com.google.android.material.appbar;

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
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.f.d;
import androidx.core.g.ae;
import androidx.core.g.s;
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.b;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.b(gf=Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  private int buD;
  private int buE;
  private int buF;
  boolean buG;
  int buH;
  ae buI;
  private boolean buJ;
  private boolean buK;
  private boolean buL;
  boolean buM;
  private int[] buN;
  List<a> listeners;
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(234467);
    this.buD = -1;
    this.buE = -1;
    this.buF = -1;
    this.buH = 0;
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      b.cc(this);
      b.a(this, paramAttributeSet, a.j.Widget_Design_AppBarLayout);
    }
    paramContext = com.google.android.material.internal.k.a(paramContext, paramAttributeSet, a.k.AppBarLayout, 0, a.j.Widget_Design_AppBarLayout, new int[0]);
    w.a(this, paramContext.getDrawable(a.k.AppBarLayout_android_background));
    if (paramContext.hasValue(a.k.AppBarLayout_expanded)) {
      c(paramContext.getBoolean(a.k.AppBarLayout_expanded, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.hasValue(a.k.AppBarLayout_elevation))) {
      b.p(this, paramContext.getDimensionPixelSize(a.k.AppBarLayout_elevation, 0));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramContext.hasValue(a.k.AppBarLayout_android_keyboardNavigationCluster)) {
        setKeyboardNavigationCluster(paramContext.getBoolean(a.k.AppBarLayout_android_keyboardNavigationCluster, false));
      }
      if (paramContext.hasValue(a.k.AppBarLayout_android_touchscreenBlocksFocus)) {
        setTouchscreenBlocksFocus(paramContext.getBoolean(a.k.AppBarLayout_android_touchscreenBlocksFocus, false));
      }
    }
    this.buM = paramContext.getBoolean(a.k.AppBarLayout_liftOnScroll, false);
    paramContext.recycle();
    w.a(this, new s()
    {
      public final ae a(View paramAnonymousView, ae paramAnonymousae)
      {
        AppMethodBeat.i(234264);
        AppBarLayout localAppBarLayout = AppBarLayout.this;
        paramAnonymousView = null;
        if (w.Z(localAppBarLayout)) {
          paramAnonymousView = paramAnonymousae;
        }
        if (!d.equals(localAppBarLayout.buI, paramAnonymousView))
        {
          localAppBarLayout.buI = paramAnonymousView;
          localAppBarLayout.vT();
        }
        AppMethodBeat.o(234264);
        return paramAnonymousae;
      }
    });
    AppMethodBeat.o(234467);
  }
  
  private static LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(234484);
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams)))
    {
      paramLayoutParams = new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(234484);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(234484);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(234484);
    return paramLayoutParams;
  }
  
  private LayoutParams g(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(234483);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(234483);
    return paramAttributeSet;
  }
  
  private static LayoutParams vU()
  {
    AppMethodBeat.i(234482);
    LayoutParams localLayoutParams = new LayoutParams(-2);
    AppMethodBeat.o(234482);
    return localLayoutParams;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(234470);
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    if ((paramb != null) && (!this.listeners.contains(paramb))) {
      this.listeners.add(paramb);
    }
    AppMethodBeat.o(234470);
  }
  
  final boolean bb(boolean paramBoolean)
  {
    AppMethodBeat.i(234497);
    if (this.buL != paramBoolean)
    {
      this.buL = paramBoolean;
      refreshDrawableState();
      AppMethodBeat.o(234497);
      return true;
    }
    AppMethodBeat.o(234497);
    return false;
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    AppMethodBeat.i(234481);
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label58;
      }
    }
    label58:
    for (int j = 4;; j = 0)
    {
      if (paramBoolean3) {
        k = 8;
      }
      this.buH = (k | j | i);
      requestLayout();
      AppMethodBeat.o(234481);
      return;
      i = 2;
      break;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  final void fS(int paramInt)
  {
    AppMethodBeat.i(234490);
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
    AppMethodBeat.o(234490);
  }
  
  int getDownNestedPreScrollRange()
  {
    AppMethodBeat.i(234488);
    if (this.buE != -1)
    {
      i = this.buE;
      AppMethodBeat.o(234488);
      return i;
    }
    int j = getChildCount() - 1;
    int i = 0;
    if (j >= 0)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int k = localView.getMeasuredHeight();
      int m = localLayoutParams.bvd;
      if ((m & 0x5) == 5)
      {
        n = localLayoutParams.topMargin;
        i = localLayoutParams.bottomMargin + n + i;
        if ((m & 0x8) != 0) {
          i += w.P(localView);
        }
      }
      while (i <= 0) {
        for (;;)
        {
          int n;
          j -= 1;
          break;
          if ((m & 0x2) != 0) {
            i += k - w.P(localView);
          } else {
            i += k - getTopInset();
          }
        }
      }
    }
    i = Math.max(0, i);
    this.buE = i;
    AppMethodBeat.o(234488);
    return i;
  }
  
  int getDownNestedScrollRange()
  {
    AppMethodBeat.i(234489);
    if (this.buF != -1)
    {
      i = this.buF;
      AppMethodBeat.o(234489);
      return i;
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
      int m = localLayoutParams.bvd;
      if ((m & 0x1) != 0)
      {
        i += n + (i1 + i2);
        if ((m & 0x2) != 0) {
          i -= w.P(localView) + getTopInset();
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i);
      this.buF = i;
      AppMethodBeat.o(234489);
      return i;
      j += 1;
      break;
    }
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    AppMethodBeat.i(234492);
    int j = getTopInset();
    int i = w.P(this);
    if (i != 0)
    {
      AppMethodBeat.o(234492);
      return i * 2 + j;
    }
    i = getChildCount();
    if (i > 0) {}
    for (i = w.P(getChildAt(i - 1)); i != 0; i = 0)
    {
      AppMethodBeat.o(234492);
      return i * 2 + j;
    }
    i = getHeight() / 3;
    AppMethodBeat.o(234492);
    return i;
  }
  
  int getPendingAction()
  {
    return this.buH;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  final int getTopInset()
  {
    AppMethodBeat.i(234500);
    if (this.buI != null)
    {
      int i = this.buI.hd();
      AppMethodBeat.o(234500);
      return i;
    }
    AppMethodBeat.o(234500);
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    AppMethodBeat.i(234486);
    if (this.buD != -1)
    {
      i = this.buD;
      AppMethodBeat.o(234486);
      return i;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int m = localLayoutParams.bvd;
      if ((m & 0x1) != 0)
      {
        int i1 = localLayoutParams.topMargin;
        i += localLayoutParams.bottomMargin + (n + i1);
        if ((m & 0x2) != 0) {
          i -= w.P(localView);
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i - getTopInset());
      this.buD = i;
      AppMethodBeat.o(234486);
      return i;
      j += 1;
      break;
    }
  }
  
  int getUpNestedPreScrollRange()
  {
    AppMethodBeat.i(234487);
    int i = getTotalScrollRange();
    AppMethodBeat.o(234487);
    return i;
  }
  
  public final void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292967);
    c(paramBoolean1, paramBoolean2, true);
    AppMethodBeat.o(292967);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(234495);
    if (this.buN == null) {
      this.buN = new int[4];
    }
    int[] arrayOfInt1 = this.buN;
    int[] arrayOfInt2 = super.onCreateDrawableState(arrayOfInt1.length + paramInt);
    if (this.buK)
    {
      paramInt = a.b.state_liftable;
      arrayOfInt1[0] = paramInt;
      if ((!this.buK) || (!this.buL)) {
        break label130;
      }
      paramInt = a.b.state_lifted;
      label67:
      arrayOfInt1[1] = paramInt;
      if (!this.buK) {
        break label138;
      }
      paramInt = a.b.state_collapsible;
      label82:
      arrayOfInt1[2] = paramInt;
      if ((!this.buK) || (!this.buL)) {
        break label146;
      }
    }
    label130:
    label138:
    label146:
    for (paramInt = a.b.state_collapsed;; paramInt = -a.b.state_collapsed)
    {
      arrayOfInt1[3] = paramInt;
      arrayOfInt1 = mergeDrawableStates(arrayOfInt2, arrayOfInt1);
      AppMethodBeat.o(234495);
      return arrayOfInt1;
      paramInt = -a.b.state_liftable;
      break;
      paramInt = -a.b.state_lifted;
      break label67;
      paramInt = -a.b.state_collapsible;
      break label82;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234475);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    vT();
    this.buG = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).bve != null) {
        this.buG = true;
      }
    }
    else if (!this.buJ) {
      if (!this.buM)
      {
        paramInt3 = getChildCount();
        paramInt1 = 0;
        label82:
        if (paramInt1 >= paramInt3) {
          break label180;
        }
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(paramInt1).getLayoutParams();
        if (((localLayoutParams.bvd & 0x1) != 1) || ((localLayoutParams.bvd & 0xA) == 0)) {
          break label168;
        }
        paramInt2 = 1;
        label125:
        if (paramInt2 == 0) {
          break label173;
        }
        paramInt1 = 1;
        label131:
        if (paramInt1 == 0) {
          break label185;
        }
      }
    }
    label168:
    label173:
    label180:
    label185:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (this.buK != paramBoolean)
      {
        this.buK = paramBoolean;
        refreshDrawableState();
      }
      AppMethodBeat.o(234475);
      return;
      paramInt1 += 1;
      break;
      paramInt2 = 0;
      break label125;
      paramInt1 += 1;
      break label82;
      paramInt1 = 0;
      break label131;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234473);
    super.onMeasure(paramInt1, paramInt2);
    vT();
    AppMethodBeat.o(234473);
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    AppMethodBeat.i(234478);
    c(paramBoolean, w.ah(this), true);
    AppMethodBeat.o(234478);
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.buM = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(234477);
    if (paramInt != 1)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
      AppMethodBeat.o(234477);
      throw localIllegalArgumentException;
    }
    super.setOrientation(paramInt);
    AppMethodBeat.o(234477);
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    AppMethodBeat.i(234499);
    if (Build.VERSION.SDK_INT >= 21) {
      b.p(this, paramFloat);
    }
    AppMethodBeat.o(234499);
  }
  
  final void vT()
  {
    this.buD = -1;
    this.buE = -1;
    this.buF = -1;
  }
  
  public static class BaseBehavior<T extends AppBarLayout>
    extends HeaderBehavior<T>
  {
    private int buP;
    private int buQ;
    private ValueAnimator buR;
    private int buS = -1;
    private boolean buT;
    private float buU;
    private WeakReference<View> buV;
    private a buW;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private static int a(T paramT, int paramInt)
    {
      AppMethodBeat.i(234305);
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
        if (!by(((AppBarLayout.LayoutParams)localObject).bvd, 32)) {
          break label114;
        }
        k -= ((AppBarLayout.LayoutParams)localObject).topMargin;
        j = ((AppBarLayout.LayoutParams)localObject).bottomMargin + j;
      }
      label114:
      for (;;)
      {
        if ((k <= -paramInt) && (j >= -paramInt))
        {
          AppMethodBeat.o(234305);
          return i;
        }
        i += 1;
        break;
        AppMethodBeat.o(234305);
        return -1;
      }
    }
    
    private static View a(CoordinatorLayout paramCoordinatorLayout)
    {
      AppMethodBeat.i(234320);
      int j = paramCoordinatorLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramCoordinatorLayout.getChildAt(i);
        if ((localView instanceof androidx.core.g.k))
        {
          AppMethodBeat.o(234320);
          return localView;
        }
        i += 1;
      }
      AppMethodBeat.o(234320);
      return null;
    }
    
    private void a(int paramInt1, T paramT, View paramView, int paramInt2)
    {
      AppMethodBeat.i(234293);
      if (paramInt2 == 1)
      {
        paramInt2 = vV();
        if (((paramInt1 < 0) && (paramInt2 == 0)) || ((paramInt1 > 0) && (paramInt2 == -paramT.getDownNestedScrollRange()))) {
          w.ag(paramView);
        }
      }
      AppMethodBeat.o(234293);
    }
    
    private void a(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      AppMethodBeat.i(234308);
      int n = vV();
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
        i1 = localLayoutParams.bvd;
        if ((i1 & 0x11) == 17)
        {
          m = -localView.getTop();
          i = -localView.getBottom();
          j = i;
          if (k == paramT.getChildCount() - 1) {
            j = i + paramT.getTopInset();
          }
          if (!by(i1, 2)) {
            break label189;
          }
          i = j + w.P(localView);
          k = m;
          m = i;
          j = k;
          if (by(i1, 32))
          {
            j = k + localLayoutParams.topMargin;
            m = i - localLayoutParams.bottomMargin;
          }
          if (n >= (m + j) / 2) {
            break label236;
          }
        }
      }
      for (;;)
      {
        a(paramCoordinatorLayout, paramT, androidx.core.b.a.clamp(m, -paramT.getTotalScrollRange(), 0));
        AppMethodBeat.o(234308);
        return;
        label189:
        i = j;
        k = m;
        if (!by(i1, 5)) {
          break;
        }
        i = w.P(localView) + j;
        if (n < i)
        {
          k = i;
          i = j;
          break;
        }
        k = m;
        break;
        label236:
        m = j;
      }
    }
    
    private void a(final CoordinatorLayout paramCoordinatorLayout, final T paramT, int paramInt)
    {
      AppMethodBeat.i(234302);
      int i = Math.abs(vV() - paramInt);
      float f = Math.abs(0.0F);
      if (f > 0.0F) {}
      int j;
      for (i = Math.round(i / f * 1000.0F) * 3;; i = (int)((i / paramT.getHeight() + 1.0F) * 150.0F))
      {
        j = vV();
        if (j != paramInt) {
          break;
        }
        if ((this.buR != null) && (this.buR.isRunning())) {
          this.buR.cancel();
        }
        AppMethodBeat.o(234302);
        return;
      }
      if (this.buR == null)
      {
        this.buR = new ValueAnimator();
        this.buR.setInterpolator(com.google.android.material.a.a.buq);
        this.buR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(234267);
            AppBarLayout.BaseBehavior.this.b(paramCoordinatorLayout, paramT, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            AppMethodBeat.o(234267);
          }
        });
      }
      for (;;)
      {
        this.buR.setDuration(Math.min(i, 600));
        this.buR.setIntValues(new int[] { j, paramInt });
        this.buR.start();
        AppMethodBeat.o(234302);
        return;
        this.buR.cancel();
      }
    }
    
    private static void a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      boolean bool3 = true;
      AppMethodBeat.i(234314);
      View localView = b(paramT, paramInt1);
      int i;
      int j;
      boolean bool1;
      if (localView != null)
      {
        i = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).bvd;
        if ((i & 0x1) == 0) {
          break label215;
        }
        j = w.P(localView);
        if ((paramInt2 <= 0) || ((i & 0xC) == 0)) {
          break label172;
        }
        if (-paramInt1 < localView.getBottom() - j - paramT.getTopInset()) {
          break label166;
        }
        bool1 = true;
      }
      for (;;)
      {
        boolean bool2 = bool1;
        if (paramT.buM)
        {
          localView = a(paramCoordinatorLayout);
          bool2 = bool1;
          if (localView != null) {
            if (localView.getScrollY() <= 0) {
              break label209;
            }
          }
        }
        label166:
        label172:
        label209:
        for (bool1 = bool3;; bool1 = false)
        {
          bool2 = bool1;
          bool1 = paramT.bb(bool2);
          if ((Build.VERSION.SDK_INT >= 11) && ((paramBoolean) || ((bool1) && (b(paramCoordinatorLayout, paramT))))) {
            paramT.jumpDrawablesToCurrentState();
          }
          AppMethodBeat.o(234314);
          return;
          bool1 = false;
          break;
          if ((i & 0x2) == 0) {
            break label215;
          }
          if (-paramInt1 >= localView.getBottom() - j - paramT.getTopInset())
          {
            bool1 = true;
            break;
          }
          bool1 = false;
          break;
        }
        label215:
        bool1 = false;
      }
    }
    
    private static View b(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(234318);
      int i = Math.abs(paramInt);
      int j = paramAppBarLayout.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        View localView = paramAppBarLayout.getChildAt(paramInt);
        if ((i >= localView.getTop()) && (i <= localView.getBottom()))
        {
          AppMethodBeat.o(234318);
          return localView;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(234318);
      return null;
    }
    
    private static boolean b(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      AppMethodBeat.i(234317);
      paramCoordinatorLayout = paramCoordinatorLayout.y(paramT);
      int j = paramCoordinatorLayout.size();
      int i = 0;
      while (i < j)
      {
        paramT = ((CoordinatorLayout.d)((View)paramCoordinatorLayout.get(i)).getLayoutParams()).Hq;
        if ((paramT instanceof AppBarLayout.ScrollingViewBehavior))
        {
          if (((AppBarLayout.ScrollingViewBehavior)paramT).bvP != 0)
          {
            AppMethodBeat.o(234317);
            return true;
          }
          AppMethodBeat.o(234317);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(234317);
      return false;
    }
    
    private static boolean by(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, Parcelable paramParcelable)
    {
      AppMethodBeat.i(234330);
      if ((paramParcelable instanceof SavedState))
      {
        paramParcelable = (SavedState)paramParcelable;
        super.a(paramCoordinatorLayout, paramT, paramParcelable.Rb);
        this.buS = paramParcelable.bva;
        this.buU = paramParcelable.bvb;
        this.buT = paramParcelable.bvc;
        AppMethodBeat.o(234330);
        return;
      }
      super.a(paramCoordinatorLayout, paramT, paramParcelable);
      this.buS = -1;
      AppMethodBeat.o(234330);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt)
    {
      AppMethodBeat.i(234296);
      if ((this.buQ == 0) || (paramInt == 1)) {
        a(paramCoordinatorLayout, paramT);
      }
      this.buV = new WeakReference(paramView);
      AppMethodBeat.o(234296);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      boolean bool = false;
      AppMethodBeat.i(234291);
      if (paramInt4 < 0)
      {
        b(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
        a(paramInt4, paramT, paramView, paramInt5);
      }
      if (paramT.buM)
      {
        if (paramView.getScrollY() > 0) {
          bool = true;
        }
        paramT.bb(bool);
      }
      AppMethodBeat.o(234291);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      AppMethodBeat.i(234290);
      if (paramInt2 != 0)
      {
        if (paramInt2 >= 0) {
          break label72;
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
        AppMethodBeat.o(234290);
        return;
        label72:
        paramInt1 = -paramT.getUpNestedPreScrollRange();
      }
    }
    
    public void a(a parama)
    {
      this.buW = parama;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(234310);
      if (((CoordinatorLayout.d)paramT.getLayoutParams()).height == -2)
      {
        paramCoordinatorLayout.e(paramT, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        AppMethodBeat.o(234310);
        return true;
      }
      boolean bool = super.a(paramCoordinatorLayout, paramT, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(234310);
      return bool;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      boolean bool2 = true;
      AppMethodBeat.i(234288);
      if ((paramInt1 & 0x2) != 0)
      {
        bool1 = bool2;
        if (!paramT.buM)
        {
          if (paramT.getTotalScrollRange() == 0) {
            break label109;
          }
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramCoordinatorLayout.getHeight() - paramView1.getHeight() > paramT.getHeight())) {
            break label115;
          }
          paramInt1 = 1;
          label61:
          if (paramInt1 == 0) {
            break label121;
          }
        }
      }
      label109:
      label115:
      label121:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if ((bool1) && (this.buR != null)) {
          this.buR.cancel();
        }
        this.buV = null;
        this.buQ = paramInt2;
        AppMethodBeat.o(234288);
        return bool1;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label61;
      }
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt)
    {
      AppMethodBeat.i(234312);
      boolean bool = super.a(paramCoordinatorLayout, paramT, paramInt);
      int i = paramT.getPendingAction();
      View localView;
      if ((this.buS >= 0) && ((i & 0x8) == 0))
      {
        localView = paramT.getChildAt(this.buS);
        paramInt = -localView.getBottom();
        if (this.buT)
        {
          paramInt = w.P(localView) + paramT.getTopInset() + paramInt;
          b(paramCoordinatorLayout, paramT, paramInt);
        }
      }
      for (;;)
      {
        paramT.buH = 0;
        this.buS = -1;
        fT(androidx.core.b.a.clamp(vY(), -paramT.getTotalScrollRange(), 0));
        a(paramCoordinatorLayout, paramT, vY(), 0, true);
        paramT.fS(vY());
        AppMethodBeat.o(234312);
        return bool;
        paramInt = Math.round(localView.getHeight() * this.buU) + paramInt;
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
    
    public Parcelable c(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      boolean bool = false;
      AppMethodBeat.i(234325);
      Object localObject = super.a(paramCoordinatorLayout, paramT);
      int j = vY();
      int k = paramT.getChildCount();
      int i = 0;
      while (i < k)
      {
        paramCoordinatorLayout = paramT.getChildAt(i);
        int m = paramCoordinatorLayout.getBottom() + j;
        if ((paramCoordinatorLayout.getTop() + j <= 0) && (m >= 0))
        {
          localObject = new SavedState((Parcelable)localObject);
          ((SavedState)localObject).bva = i;
          if (m == w.P(paramCoordinatorLayout) + paramT.getTopInset()) {
            bool = true;
          }
          ((SavedState)localObject).bvc = bool;
          ((SavedState)localObject).bvb = (m / paramCoordinatorLayout.getHeight());
          AppMethodBeat.o(234325);
          return localObject;
        }
        i += 1;
      }
      AppMethodBeat.o(234325);
      return localObject;
    }
    
    final int vV()
    {
      AppMethodBeat.i(234322);
      int i = vY();
      int j = this.buP;
      AppMethodBeat.o(234322);
      return i + j;
    }
    
    protected static class SavedState
      extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR;
      int bva;
      float bvb;
      boolean bvc;
      
      static
      {
        AppMethodBeat.i(234278);
        CREATOR = new Parcelable.ClassLoaderCreator() {};
        AppMethodBeat.o(234278);
      }
      
      public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        AppMethodBeat.i(234274);
        this.bva = paramParcel.readInt();
        this.bvb = paramParcel.readFloat();
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.bvc = bool;
          AppMethodBeat.o(234274);
          return;
        }
      }
      
      public SavedState(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(234277);
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.bva);
        paramParcel.writeFloat(this.bvb);
        if (this.bvc) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeByte((byte)paramInt);
          AppMethodBeat.o(234277);
          return;
        }
      }
    }
    
    public static abstract class a<T extends AppBarLayout>
    {
      public abstract boolean vX();
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
    
    public static abstract class a
      extends AppBarLayout.BaseBehavior.a<AppBarLayout>
    {}
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    public int bvd;
    Interpolator bve;
    
    public LayoutParams(int paramInt)
    {
      super(paramInt);
      this.bvd = 1;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(234394);
      this.bvd = 1;
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.AppBarLayout_Layout);
      this.bvd = paramAttributeSet.getInt(a.k.AppBarLayout_Layout_layout_scrollFlags, 0);
      if (paramAttributeSet.hasValue(a.k.AppBarLayout_Layout_layout_scrollInterpolator)) {
        this.bve = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(a.k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
      }
      paramAttributeSet.recycle();
      AppMethodBeat.o(234394);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.bvd = 1;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.bvd = 1;
    }
    
    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
      this.bvd = 1;
    }
  }
  
  public static class ScrollingViewBehavior
    extends HeaderScrollingViewBehavior
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(234418);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ScrollingViewBehavior_Layout);
      this.bvP = paramContext.getDimensionPixelSize(a.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
      paramContext.recycle();
      AppMethodBeat.o(234418);
    }
    
    private static AppBarLayout v(List<View> paramList)
    {
      AppMethodBeat.i(234431);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramList.get(i);
        if ((localView instanceof AppBarLayout))
        {
          paramList = (AppBarLayout)localView;
          AppMethodBeat.o(234431);
          return paramList;
        }
        i += 1;
      }
      AppMethodBeat.o(234431);
      return null;
    }
    
    public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
    {
      AppMethodBeat.i(234425);
      AppBarLayout localAppBarLayout = v(paramCoordinatorLayout.x(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramView = this.bvM;
        paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!paramView.contains(paramRect))
        {
          if (!paramBoolean) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localAppBarLayout.c(false, paramBoolean, true);
            AppMethodBeat.o(234425);
            return true;
          }
        }
      }
      AppMethodBeat.o(234425);
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      AppMethodBeat.i(234423);
      paramCoordinatorLayout = ((CoordinatorLayout.d)paramView2.getLayoutParams()).Hq;
      if ((paramCoordinatorLayout instanceof AppBarLayout.BaseBehavior))
      {
        paramCoordinatorLayout = (AppBarLayout.BaseBehavior)paramCoordinatorLayout;
        int i = paramView2.getBottom();
        int j = paramView1.getTop();
        w.s(paramView1, AppBarLayout.BaseBehavior.a(paramCoordinatorLayout) + (i - j) + we() - cb(paramView2));
      }
      if ((paramView2 instanceof AppBarLayout))
      {
        paramCoordinatorLayout = (AppBarLayout)paramView2;
        if (paramCoordinatorLayout.buM) {
          if (paramView1.getScrollY() <= 0) {
            break label108;
          }
        }
      }
      label108:
      for (boolean bool = true;; bool = false)
      {
        paramCoordinatorLayout.bb(bool);
        AppMethodBeat.o(234423);
        return false;
      }
    }
    
    final float bV(View paramView)
    {
      AppMethodBeat.i(234428);
      if ((paramView instanceof AppBarLayout))
      {
        paramView = (AppBarLayout)paramView;
        int j = paramView.getTotalScrollRange();
        int k = paramView.getDownNestedPreScrollRange();
        paramView = ((CoordinatorLayout.d)paramView.getLayoutParams()).Hq;
        if ((paramView instanceof AppBarLayout.BaseBehavior)) {}
        for (int i = ((AppBarLayout.BaseBehavior)paramView).vV(); (k != 0) && (j + i <= k); i = 0)
        {
          AppMethodBeat.o(234428);
          return 0.0F;
        }
        j -= k;
        if (j != 0)
        {
          float f = i / j;
          AppMethodBeat.o(234428);
          return f + 1.0F;
        }
      }
      AppMethodBeat.o(234428);
      return 0.0F;
    }
    
    final int bW(View paramView)
    {
      AppMethodBeat.i(234434);
      if ((paramView instanceof AppBarLayout))
      {
        i = ((AppBarLayout)paramView).getTotalScrollRange();
        AppMethodBeat.o(234434);
        return i;
      }
      int i = super.bW(paramView);
      AppMethodBeat.o(234434);
      return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout
 * JD-Core Version:    0.7.0.1
 */