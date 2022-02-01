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
import androidx.core.f.c;
import androidx.core.g.ah;
import androidx.core.g.s;
import androidx.core.g.z;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.b;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.b(Dr=Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  private int dnG;
  private int dnH;
  private int dnI;
  boolean dnJ;
  int dnK;
  ah dnL;
  private boolean dnM;
  private boolean dnN;
  private boolean dnO;
  boolean dnP;
  private int[] dnQ;
  List<a> listeners;
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210074);
    this.dnG = -1;
    this.dnH = -1;
    this.dnI = -1;
    this.dnK = 0;
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      b.cy(this);
      b.a(this, paramAttributeSet, a.j.Widget_Design_AppBarLayout);
    }
    paramContext = com.google.android.material.internal.k.a(paramContext, paramAttributeSet, a.k.AppBarLayout, 0, a.j.Widget_Design_AppBarLayout, new int[0]);
    z.a(this, paramContext.getDrawable(a.k.AppBarLayout_android_background));
    if (paramContext.hasValue(a.k.AppBarLayout_expanded)) {
      c(paramContext.getBoolean(a.k.AppBarLayout_expanded, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.hasValue(a.k.AppBarLayout_elevation))) {
      b.q(this, paramContext.getDimensionPixelSize(a.k.AppBarLayout_elevation, 0));
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
    this.dnP = paramContext.getBoolean(a.k.AppBarLayout_liftOnScroll, false);
    paramContext.recycle();
    z.a(this, new s()
    {
      public final ah a(View paramAnonymousView, ah paramAnonymousah)
      {
        AppMethodBeat.i(210009);
        AppBarLayout localAppBarLayout = AppBarLayout.this;
        paramAnonymousView = null;
        if (z.al(localAppBarLayout)) {
          paramAnonymousView = paramAnonymousah;
        }
        if (!c.equals(localAppBarLayout.dnL, paramAnonymousView))
        {
          localAppBarLayout.dnL = paramAnonymousView;
          localAppBarLayout.Vs();
        }
        AppMethodBeat.o(210009);
        return paramAnonymousah;
      }
    });
    AppMethodBeat.o(210074);
  }
  
  private static LayoutParams Vt()
  {
    AppMethodBeat.i(210081);
    LayoutParams localLayoutParams = new LayoutParams(-2);
    AppMethodBeat.o(210081);
    return localLayoutParams;
  }
  
  private static LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(210090);
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams)))
    {
      paramLayoutParams = new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(210090);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(210090);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(210090);
    return paramLayoutParams;
  }
  
  private LayoutParams g(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(210085);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(210085);
    return paramAttributeSet;
  }
  
  final void Vs()
  {
    this.dnG = -1;
    this.dnH = -1;
    this.dnI = -1;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(210099);
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    if ((paramb != null) && (!this.listeners.contains(paramb))) {
      this.listeners.add(paramb);
    }
    AppMethodBeat.o(210099);
  }
  
  final boolean bJ(boolean paramBoolean)
  {
    AppMethodBeat.i(210179);
    if (this.dnO != paramBoolean)
    {
      this.dnO = paramBoolean;
      refreshDrawableState();
      AppMethodBeat.o(210179);
      return true;
    }
    AppMethodBeat.o(210179);
    return false;
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    AppMethodBeat.i(210134);
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
      this.dnK = (k | j | i);
      requestLayout();
      AppMethodBeat.o(210134);
      return;
      i = 2;
      break;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  int getDownNestedPreScrollRange()
  {
    AppMethodBeat.i(210153);
    if (this.dnH != -1)
    {
      i = this.dnH;
      AppMethodBeat.o(210153);
      return i;
    }
    int j = getChildCount() - 1;
    int i = 0;
    if (j >= 0)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int k = localView.getMeasuredHeight();
      int m = localLayoutParams.dog;
      if ((m & 0x5) == 5)
      {
        n = localLayoutParams.topMargin;
        i = localLayoutParams.bottomMargin + n + i;
        if ((m & 0x8) != 0) {
          i += z.ab(localView);
        }
      }
      while (i <= 0) {
        for (;;)
        {
          int n;
          j -= 1;
          break;
          if ((m & 0x2) != 0) {
            i += k - z.ab(localView);
          } else {
            i += k - getTopInset();
          }
        }
      }
    }
    i = Math.max(0, i);
    this.dnH = i;
    AppMethodBeat.o(210153);
    return i;
  }
  
  int getDownNestedScrollRange()
  {
    AppMethodBeat.i(210158);
    if (this.dnI != -1)
    {
      i = this.dnI;
      AppMethodBeat.o(210158);
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
      int m = localLayoutParams.dog;
      if ((m & 0x1) != 0)
      {
        i += n + (i1 + i2);
        if ((m & 0x2) != 0) {
          i -= z.ab(localView) + getTopInset();
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i);
      this.dnI = i;
      AppMethodBeat.o(210158);
      return i;
      j += 1;
      break;
    }
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    AppMethodBeat.i(210169);
    int j = getTopInset();
    int i = z.ab(this);
    if (i != 0)
    {
      AppMethodBeat.o(210169);
      return i * 2 + j;
    }
    i = getChildCount();
    if (i > 0) {}
    for (i = z.ab(getChildAt(i - 1)); i != 0; i = 0)
    {
      AppMethodBeat.o(210169);
      return i * 2 + j;
    }
    i = getHeight() / 3;
    AppMethodBeat.o(210169);
    return i;
  }
  
  int getPendingAction()
  {
    return this.dnK;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  final int getTopInset()
  {
    AppMethodBeat.i(210196);
    if (this.dnL != null)
    {
      int i = this.dnL.En();
      AppMethodBeat.o(210196);
      return i;
    }
    AppMethodBeat.o(210196);
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    AppMethodBeat.i(210144);
    if (this.dnG != -1)
    {
      i = this.dnG;
      AppMethodBeat.o(210144);
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
      int m = localLayoutParams.dog;
      if ((m & 0x1) != 0)
      {
        int i1 = localLayoutParams.topMargin;
        i += localLayoutParams.bottomMargin + (n + i1);
        if ((m & 0x2) != 0) {
          i -= z.ab(localView);
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i - getTopInset());
      this.dnG = i;
      AppMethodBeat.o(210144);
      return i;
      j += 1;
      break;
    }
  }
  
  int getUpNestedPreScrollRange()
  {
    AppMethodBeat.i(210148);
    int i = getTotalScrollRange();
    AppMethodBeat.o(210148);
    return i;
  }
  
  final void jh(int paramInt)
  {
    AppMethodBeat.i(210163);
    if (this.listeners != null)
    {
      int j = this.listeners.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.listeners.get(i);
        if (locala != null) {
          locala.onOffsetChanged(this, paramInt);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(210163);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(210175);
    if (this.dnQ == null) {
      this.dnQ = new int[4];
    }
    int[] arrayOfInt1 = this.dnQ;
    int[] arrayOfInt2 = super.onCreateDrawableState(arrayOfInt1.length + paramInt);
    if (this.dnN)
    {
      paramInt = a.b.state_liftable;
      arrayOfInt1[0] = paramInt;
      if ((!this.dnN) || (!this.dnO)) {
        break label130;
      }
      paramInt = a.b.state_lifted;
      label67:
      arrayOfInt1[1] = paramInt;
      if (!this.dnN) {
        break label138;
      }
      paramInt = a.b.state_collapsible;
      label82:
      arrayOfInt1[2] = paramInt;
      if ((!this.dnN) || (!this.dnO)) {
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
      AppMethodBeat.o(210175);
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
    AppMethodBeat.i(210117);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Vs();
    this.dnJ = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).doh != null) {
        this.dnJ = true;
      }
    }
    else if (!this.dnM) {
      if (!this.dnP)
      {
        paramInt3 = getChildCount();
        paramInt1 = 0;
        label82:
        if (paramInt1 >= paramInt3) {
          break label180;
        }
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(paramInt1).getLayoutParams();
        if (((localLayoutParams.dog & 0x1) != 1) || ((localLayoutParams.dog & 0xA) == 0)) {
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
      if (this.dnN != paramBoolean)
      {
        this.dnN = paramBoolean;
        refreshDrawableState();
      }
      AppMethodBeat.o(210117);
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
    AppMethodBeat.i(210105);
    super.onMeasure(paramInt1, paramInt2);
    Vs();
    AppMethodBeat.o(210105);
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    AppMethodBeat.i(210127);
    c(paramBoolean, z.au(this), true);
    AppMethodBeat.o(210127);
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.dnP = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(210124);
    if (paramInt != 1)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
      AppMethodBeat.o(210124);
      throw localIllegalArgumentException;
    }
    super.setOrientation(paramInt);
    AppMethodBeat.o(210124);
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    AppMethodBeat.i(210186);
    if (Build.VERSION.SDK_INT >= 21) {
      b.q(this, paramFloat);
    }
    AppMethodBeat.o(210186);
  }
  
  public static class BaseBehavior<T extends AppBarLayout>
    extends HeaderBehavior<T>
  {
    private int dnS;
    private int dnT;
    private ValueAnimator dnU;
    private int dnV = -1;
    private boolean dnW;
    private float dnX;
    private WeakReference<View> dnY;
    private a dnZ;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private static int a(T paramT, int paramInt)
    {
      AppMethodBeat.i(210042);
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
        if (!ct(((AppBarLayout.LayoutParams)localObject).dog, 32)) {
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
          AppMethodBeat.o(210042);
          return i;
        }
        i += 1;
        break;
        AppMethodBeat.o(210042);
        return -1;
      }
    }
    
    private static View a(CoordinatorLayout paramCoordinatorLayout)
    {
      AppMethodBeat.i(210083);
      int j = paramCoordinatorLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramCoordinatorLayout.getChildAt(i);
        if ((localView instanceof androidx.core.g.k))
        {
          AppMethodBeat.o(210083);
          return localView;
        }
        i += 1;
      }
      AppMethodBeat.o(210083);
      return null;
    }
    
    private void a(int paramInt1, T paramT, View paramView, int paramInt2)
    {
      AppMethodBeat.i(210023);
      if (paramInt2 == 1)
      {
        paramInt2 = Vu();
        if (((paramInt1 < 0) && (paramInt2 == 0)) || ((paramInt1 > 0) && (paramInt2 == -paramT.getDownNestedScrollRange()))) {
          z.at(paramView);
        }
      }
      AppMethodBeat.o(210023);
    }
    
    private void a(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      AppMethodBeat.i(210053);
      int n = Vu();
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
        i1 = localLayoutParams.dog;
        if ((i1 & 0x11) == 17)
        {
          m = -localView.getTop();
          i = -localView.getBottom();
          j = i;
          if (k == paramT.getChildCount() - 1) {
            j = i + paramT.getTopInset();
          }
          if (!ct(i1, 2)) {
            break label189;
          }
          i = j + z.ab(localView);
          k = m;
          m = i;
          j = k;
          if (ct(i1, 32))
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
        AppMethodBeat.o(210053);
        return;
        label189:
        i = j;
        k = m;
        if (!ct(i1, 5)) {
          break;
        }
        i = z.ab(localView) + j;
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
      AppMethodBeat.i(210034);
      int i = Math.abs(Vu() - paramInt);
      float f = Math.abs(0.0F);
      if (f > 0.0F) {}
      int j;
      for (i = Math.round(i / f * 1000.0F) * 3;; i = (int)((i / paramT.getHeight() + 1.0F) * 150.0F))
      {
        j = Vu();
        if (j != paramInt) {
          break;
        }
        if ((this.dnU != null) && (this.dnU.isRunning())) {
          this.dnU.cancel();
        }
        AppMethodBeat.o(210034);
        return;
      }
      if (this.dnU == null)
      {
        this.dnU = new ValueAnimator();
        this.dnU.setInterpolator(com.google.android.material.a.a.dnu);
        this.dnU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(210058);
            AppBarLayout.BaseBehavior.this.b(paramCoordinatorLayout, paramT, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            AppMethodBeat.o(210058);
          }
        });
      }
      for (;;)
      {
        this.dnU.setDuration(Math.min(i, 600));
        this.dnU.setIntValues(new int[] { j, paramInt });
        this.dnU.start();
        AppMethodBeat.o(210034);
        return;
        this.dnU.cancel();
      }
    }
    
    private static void a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      boolean bool3 = true;
      AppMethodBeat.i(210061);
      View localView = b(paramT, paramInt1);
      int i;
      int j;
      boolean bool1;
      if (localView != null)
      {
        i = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).dog;
        if ((i & 0x1) == 0) {
          break label215;
        }
        j = z.ab(localView);
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
        if (paramT.dnP)
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
          bool1 = paramT.bJ(bool2);
          if ((Build.VERSION.SDK_INT >= 11) && ((paramBoolean) || ((bool1) && (b(paramCoordinatorLayout, paramT))))) {
            paramT.jumpDrawablesToCurrentState();
          }
          AppMethodBeat.o(210061);
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
      AppMethodBeat.i(210076);
      int i = Math.abs(paramInt);
      int j = paramAppBarLayout.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        View localView = paramAppBarLayout.getChildAt(paramInt);
        if ((i >= localView.getTop()) && (i <= localView.getBottom()))
        {
          AppMethodBeat.o(210076);
          return localView;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(210076);
      return null;
    }
    
    private static boolean b(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      AppMethodBeat.i(210070);
      paramCoordinatorLayout = paramCoordinatorLayout.H(paramT);
      int j = paramCoordinatorLayout.size();
      int i = 0;
      while (i < j)
      {
        paramT = ((CoordinatorLayout.d)((View)paramCoordinatorLayout.get(i)).getLayoutParams()).bnr;
        if ((paramT instanceof AppBarLayout.ScrollingViewBehavior))
        {
          if (((AppBarLayout.ScrollingViewBehavior)paramT).doS != 0)
          {
            AppMethodBeat.o(210070);
            return true;
          }
          AppMethodBeat.o(210070);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(210070);
      return false;
    }
    
    private static boolean ct(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }
    
    final int Vu()
    {
      AppMethodBeat.i(210145);
      int i = Vx();
      int j = this.dnS;
      AppMethodBeat.o(210145);
      return i + j;
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, Parcelable paramParcelable)
    {
      AppMethodBeat.i(210155);
      if ((paramParcelable instanceof SavedState))
      {
        paramParcelable = (SavedState)paramParcelable;
        super.a(paramCoordinatorLayout, paramT, paramParcelable.bxs);
        this.dnV = paramParcelable.dod;
        this.dnX = paramParcelable.doe;
        this.dnW = paramParcelable.dof;
        AppMethodBeat.o(210155);
        return;
      }
      super.a(paramCoordinatorLayout, paramT, paramParcelable);
      this.dnV = -1;
      AppMethodBeat.o(210155);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt)
    {
      AppMethodBeat.i(210120);
      if ((this.dnT == 0) || (paramInt == 1)) {
        a(paramCoordinatorLayout, paramT);
      }
      this.dnY = new WeakReference(paramView);
      AppMethodBeat.o(210120);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      boolean bool = false;
      AppMethodBeat.i(210111);
      if (paramInt4 < 0)
      {
        b(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
        a(paramInt4, paramT, paramView, paramInt5);
      }
      if (paramT.dnP)
      {
        if (paramView.getScrollY() > 0) {
          bool = true;
        }
        paramT.bJ(bool);
      }
      AppMethodBeat.o(210111);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      AppMethodBeat.i(210103);
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
        AppMethodBeat.o(210103);
        return;
        label72:
        paramInt1 = -paramT.getUpNestedPreScrollRange();
      }
    }
    
    public void a(a parama)
    {
      this.dnZ = parama;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(210130);
      if (((CoordinatorLayout.d)paramT.getLayoutParams()).height == -2)
      {
        paramCoordinatorLayout.e(paramT, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        AppMethodBeat.o(210130);
        return true;
      }
      boolean bool = super.a(paramCoordinatorLayout, paramT, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(210130);
      return bool;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      boolean bool2 = true;
      AppMethodBeat.i(210094);
      if ((paramInt1 & 0x2) != 0)
      {
        bool1 = bool2;
        if (!paramT.dnP)
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
        if ((bool1) && (this.dnU != null)) {
          this.dnU.cancel();
        }
        this.dnY = null;
        this.dnT = paramInt2;
        AppMethodBeat.o(210094);
        return bool1;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label61;
      }
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt)
    {
      AppMethodBeat.i(210141);
      boolean bool = super.a(paramCoordinatorLayout, paramT, paramInt);
      int i = paramT.getPendingAction();
      View localView;
      if ((this.dnV >= 0) && ((i & 0x8) == 0))
      {
        localView = paramT.getChildAt(this.dnV);
        paramInt = -localView.getBottom();
        if (this.dnW)
        {
          paramInt = z.ab(localView) + paramT.getTopInset() + paramInt;
          b(paramCoordinatorLayout, paramT, paramInt);
        }
      }
      for (;;)
      {
        paramT.dnK = 0;
        this.dnV = -1;
        ji(androidx.core.b.a.clamp(Vx(), -paramT.getTotalScrollRange(), 0));
        a(paramCoordinatorLayout, paramT, Vx(), 0, true);
        paramT.jh(Vx());
        AppMethodBeat.o(210141);
        return bool;
        paramInt = Math.round(localView.getHeight() * this.dnX) + paramInt;
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
      AppMethodBeat.i(210151);
      Object localObject = super.a(paramCoordinatorLayout, paramT);
      int j = Vx();
      int k = paramT.getChildCount();
      int i = 0;
      while (i < k)
      {
        paramCoordinatorLayout = paramT.getChildAt(i);
        int m = paramCoordinatorLayout.getBottom() + j;
        if ((paramCoordinatorLayout.getTop() + j <= 0) && (m >= 0))
        {
          localObject = new SavedState((Parcelable)localObject);
          ((SavedState)localObject).dod = i;
          if (m == z.ab(paramCoordinatorLayout) + paramT.getTopInset()) {
            bool = true;
          }
          ((SavedState)localObject).dof = bool;
          ((SavedState)localObject).doe = (m / paramCoordinatorLayout.getHeight());
          AppMethodBeat.o(210151);
          return localObject;
        }
        i += 1;
      }
      AppMethodBeat.o(210151);
      return localObject;
    }
    
    protected static class SavedState
      extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR;
      int dod;
      float doe;
      boolean dof;
      
      static
      {
        AppMethodBeat.i(210011);
        CREATOR = new Parcelable.ClassLoaderCreator() {};
        AppMethodBeat.o(210011);
      }
      
      public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        AppMethodBeat.i(210000);
        this.dod = paramParcel.readInt();
        this.doe = paramParcel.readFloat();
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.dof = bool;
          AppMethodBeat.o(210000);
          return;
        }
      }
      
      public SavedState(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(210015);
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.dod);
        paramParcel.writeFloat(this.doe);
        if (this.dof) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeByte((byte)paramInt);
          AppMethodBeat.o(210015);
          return;
        }
      }
    }
    
    public static abstract class a<T extends AppBarLayout>
    {
      public abstract boolean Vw();
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
    public int dog;
    Interpolator doh;
    
    public LayoutParams(int paramInt)
    {
      super(paramInt);
      this.dog = 1;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(210065);
      this.dog = 1;
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.AppBarLayout_Layout);
      this.dog = paramAttributeSet.getInt(a.k.AppBarLayout_Layout_layout_scrollFlags, 0);
      if (paramAttributeSet.hasValue(a.k.AppBarLayout_Layout_layout_scrollInterpolator)) {
        this.doh = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(a.k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
      }
      paramAttributeSet.recycle();
      AppMethodBeat.o(210065);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.dog = 1;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.dog = 1;
    }
    
    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
      this.dog = 1;
    }
  }
  
  public static class ScrollingViewBehavior
    extends HeaderScrollingViewBehavior
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(210038);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ScrollingViewBehavior_Layout);
      this.doS = paramContext.getDimensionPixelSize(a.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
      paramContext.recycle();
      AppMethodBeat.o(210038);
    }
    
    private static AppBarLayout ao(List<View> paramList)
    {
      AppMethodBeat.i(210052);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramList.get(i);
        if ((localView instanceof AppBarLayout))
        {
          paramList = (AppBarLayout)localView;
          AppMethodBeat.o(210052);
          return paramList;
        }
        i += 1;
      }
      AppMethodBeat.o(210052);
      return null;
    }
    
    public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
    {
      AppMethodBeat.i(210077);
      AppBarLayout localAppBarLayout = ao(paramCoordinatorLayout.G(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramView = this.doP;
        paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!paramView.contains(paramRect))
        {
          if (!paramBoolean) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localAppBarLayout.c(false, paramBoolean, true);
            AppMethodBeat.o(210077);
            return true;
          }
        }
      }
      AppMethodBeat.o(210077);
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      AppMethodBeat.i(210067);
      paramCoordinatorLayout = ((CoordinatorLayout.d)paramView2.getLayoutParams()).bnr;
      if ((paramCoordinatorLayout instanceof AppBarLayout.BaseBehavior))
      {
        paramCoordinatorLayout = (AppBarLayout.BaseBehavior)paramCoordinatorLayout;
        int i = paramView2.getBottom();
        int j = paramView1.getTop();
        z.s(paramView1, AppBarLayout.BaseBehavior.a(paramCoordinatorLayout) + (i - j) + VD() - cx(paramView2));
      }
      if ((paramView2 instanceof AppBarLayout))
      {
        paramCoordinatorLayout = (AppBarLayout)paramView2;
        if (paramCoordinatorLayout.dnP) {
          if (paramView1.getScrollY() <= 0) {
            break label108;
          }
        }
      }
      label108:
      for (boolean bool = true;; bool = false)
      {
        paramCoordinatorLayout.bJ(bool);
        AppMethodBeat.o(210067);
        return false;
      }
    }
    
    final float cr(View paramView)
    {
      AppMethodBeat.i(210087);
      if ((paramView instanceof AppBarLayout))
      {
        paramView = (AppBarLayout)paramView;
        int j = paramView.getTotalScrollRange();
        int k = paramView.getDownNestedPreScrollRange();
        paramView = ((CoordinatorLayout.d)paramView.getLayoutParams()).bnr;
        if ((paramView instanceof AppBarLayout.BaseBehavior)) {}
        for (int i = ((AppBarLayout.BaseBehavior)paramView).Vu(); (k != 0) && (j + i <= k); i = 0)
        {
          AppMethodBeat.o(210087);
          return 0.0F;
        }
        j -= k;
        if (j != 0)
        {
          float f = i / j;
          AppMethodBeat.o(210087);
          return f + 1.0F;
        }
      }
      AppMethodBeat.o(210087);
      return 0.0F;
    }
    
    final int cs(View paramView)
    {
      AppMethodBeat.i(210095);
      if ((paramView instanceof AppBarLayout))
      {
        i = ((AppBarLayout)paramView).getTotalScrollRange();
        AppMethodBeat.o(210095);
        return i;
      }
      int i = super.cs(paramView);
      AppMethodBeat.o(210095);
      return i;
    }
  }
  
  public static abstract interface a<T extends AppBarLayout>
  {
    public abstract void onOffsetChanged(T paramT, int paramInt);
  }
  
  public static abstract interface b
    extends AppBarLayout.a<AppBarLayout>
  {
    public abstract void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout
 * JD-Core Version:    0.7.0.1
 */