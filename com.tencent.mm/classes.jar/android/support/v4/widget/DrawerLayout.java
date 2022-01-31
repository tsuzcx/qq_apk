package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.a.a;
import android.support.v4.view.d;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
{
  static final int[] Gr;
  private static final int[] JY;
  static final boolean JZ;
  private static final boolean Ka;
  private float FH;
  private float FI;
  private boolean Hb = true;
  private Drawable KA = null;
  private Drawable KB = null;
  private final ArrayList<View> KC;
  private final b Kb = new b();
  private float Kc;
  private int Kd;
  private int Ke = -1728053248;
  private float Kf;
  private Paint Kg = new Paint();
  final r Kh;
  final r Ki;
  private final d Kj;
  private final d Kk;
  int Kl;
  private int Km = 3;
  private int Kn = 3;
  private int Ko = 3;
  private int Kp = 3;
  private boolean Kq;
  boolean Kr;
  private c Ks;
  private Drawable Kt;
  private Drawable Ku;
  CharSequence Kv;
  CharSequence Kw;
  Object Kx;
  private Drawable Ky = null;
  private Drawable Kz = null;
  boolean hJ;
  private Drawable hK;
  private boolean mInLayout;
  List<c> mListeners;
  
  static
  {
    boolean bool2 = true;
    JY = new int[] { 16843828 };
    Gr = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      JZ = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Ka = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.Kd = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.Kj = new d(3);
    this.Kk = new d(5);
    this.Kh = r.a(this, 1.0F, this.Kj);
    this.Kh.MU = 1;
    this.Kh.MS = f2;
    this.Kj.KN = this.Kh;
    this.Ki = r.a(this, 1.0F, this.Kk);
    this.Ki.MU = 2;
    this.Ki.MS = f2;
    this.Kk.KN = this.Ki;
    setFocusableInTouchMode(true);
    q.n(this, 1);
    q.a(this, new a());
    setMotionEventSplittingEnabled(false);
    if (q.ae(this))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label336;
      }
      setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        @TargetApi(21)
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          boolean bool2 = true;
          paramAnonymousView = (DrawerLayout)paramAnonymousView;
          if (paramAnonymousWindowInsets.getSystemWindowInsetTop() > 0)
          {
            bool1 = true;
            paramAnonymousView.Kx = paramAnonymousWindowInsets;
            paramAnonymousView.hJ = bool1;
            if ((bool1) || (paramAnonymousView.getBackground() != null)) {
              break label60;
            }
          }
          label60:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            paramAnonymousView.setWillNotDraw(bool1);
            paramAnonymousView.requestLayout();
            return paramAnonymousWindowInsets.consumeSystemWindowInsets();
            bool1 = false;
            break;
          }
        }
      });
      setSystemUiVisibility(1280);
      paramContext = paramContext.obtainStyledAttributes(JY);
    }
    for (;;)
    {
      try
      {
        this.hK = paramContext.getDrawable(0);
        paramContext.recycle();
        this.Kc = (f1 * 10.0F);
        this.KC = new ArrayList();
        return;
      }
      finally
      {
        paramContext.recycle();
      }
      label336:
      this.hK = null;
    }
  }
  
  private void K(boolean paramBoolean)
  {
    int m = getChildCount();
    int j = 0;
    int i = 0;
    if (j < m)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      boolean bool = i;
      int k;
      if (aB(localView)) {
        if (paramBoolean)
        {
          bool = i;
          if (!localLayoutParams.KF) {}
        }
        else
        {
          k = localView.getWidth();
          if (!s(localView, 3)) {
            break label115;
          }
          i |= this.Kh.e(localView, -k, localView.getTop());
        }
      }
      for (;;)
      {
        localLayoutParams.KF = false;
        k = i;
        j += 1;
        i = k;
        break;
        label115:
        i |= this.Ki.e(localView, getWidth(), localView.getTop());
      }
    }
    this.Kj.dD();
    this.Kk.dD();
    if (i != 0) {
      invalidate();
    }
  }
  
  private static boolean aA(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }
  
  static boolean aB(View paramView)
  {
    int i = d.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, q.Q(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  private void aC(View paramView)
  {
    if (!aB(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.Hb)
    {
      localLayoutParams.KE = 1.0F;
      localLayoutParams.KG = 1;
      f(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      localLayoutParams.KG |= 0x2;
      if (s(paramView, 3)) {
        this.Kh.e(paramView, 0, paramView.getTop());
      } else {
        this.Ki.e(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  static boolean aE(View paramView)
  {
    return (q.P(paramView) != 4) && (q.P(paramView) != 2);
  }
  
  static float ay(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).KE;
  }
  
  private static boolean c(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (!android.support.v4.a.a.a.b(paramDrawable))) {
      return false;
    }
    android.support.v4.a.a.a.b(paramDrawable, paramInt);
    return true;
  }
  
  private View dF()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).KG & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void t(int paramInt1, int paramInt2)
  {
    int i = d.getAbsoluteGravity(paramInt2, q.Q(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.Kh;
          label67:
          ((r)localObject).cancel();
        }
      }
      else {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        this.Km = paramInt1;
        break;
        this.Kn = paramInt1;
        break;
        this.Ko = paramInt1;
        break;
        this.Kp = paramInt1;
        break;
        localObject = this.Ki;
        break label67;
        localObject = aH(i);
      } while (localObject == null);
      aC((View)localObject);
      return;
      localObject = aH(i);
    } while (localObject == null);
    aD((View)localObject);
  }
  
  public final void aD(View paramView)
  {
    if (!aB(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.Hb)
    {
      localLayoutParams.KE = 0.0F;
      localLayoutParams.KG = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      localLayoutParams.KG |= 0x4;
      if (s(paramView, 3)) {
        this.Kh.e(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.Ki.e(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  final View aH(int paramInt)
  {
    int i = d.getAbsoluteGravity(paramInt, q.Q(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((az(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int m = getChildCount();
    int j = 0;
    int i = 0;
    View localView;
    if (j < m)
    {
      localView = getChildAt(j);
      int k;
      if (aB(localView))
      {
        if (!aB(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if ((((LayoutParams)localView.getLayoutParams()).KG & 0x1) == 1)
        {
          k = 1;
          label106:
          if (k == 0) {
            break label147;
          }
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          i = 1;
        }
      }
      label147:
      for (;;)
      {
        j += 1;
        break;
        k = 0;
        break label106;
        this.KC.add(localView);
      }
    }
    if (i == 0)
    {
      j = this.KC.size();
      i = 0;
      while (i < j)
      {
        localView = (View)this.KC.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.KC.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((dF() != null) || (aB(paramView))) {
      q.n(paramView, 4);
    }
    for (;;)
    {
      if (!JZ) {
        q.a(paramView, this.Kb);
      }
      return;
      q.n(paramView, 1);
    }
  }
  
  public final int ax(View paramView)
  {
    if (!aB(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    int i = ((LayoutParams)paramView.getLayoutParams()).gravity;
    int j = q.Q(this);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      if (this.Km != 3) {
        return this.Km;
      }
      if (j == 0) {}
      for (i = this.Ko; i != 3; i = this.Kp) {
        return i;
      }
      if (this.Kn != 3) {
        return this.Kn;
      }
      if (j == 0) {}
      for (i = this.Kp; i != 3; i = this.Ko) {
        return i;
      }
      if (this.Ko != 3) {
        return this.Ko;
      }
      if (j == 0) {}
      for (i = this.Km; i != 3; i = this.Kn) {
        return i;
      }
      if (this.Kp != 3) {
        return this.Kp;
      }
      if (j == 0) {}
      for (i = this.Kn; i != 3; i = this.Km) {
        return i;
      }
    }
  }
  
  final int az(View paramView)
  {
    return d.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, q.Q(this));
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, ((LayoutParams)getChildAt(i).getLayoutParams()).KE);
      i += 1;
    }
    this.Kf = f;
    boolean bool1 = this.Kh.dW();
    boolean bool2 = this.Ki.dW();
    if ((bool1) || (bool2)) {
      q.O(this);
    }
  }
  
  final View dG()
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView = getChildAt(i);
      if (aB(localView))
      {
        if (!aB(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if (((LayoutParams)localView.getLayoutParams()).KE > 0.0F) {}
        for (int j = 1; j != 0; j = 0) {
          return localView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i2 = getHeight();
    boolean bool1 = aA(paramView);
    int i = 0;
    int n = 0;
    int j = getWidth();
    int i3 = paramCanvas.save();
    int k = j;
    int m;
    View localView;
    int i1;
    if (bool1)
    {
      int i4 = getChildCount();
      m = 0;
      i = n;
      if (m < i4)
      {
        localView = getChildAt(m);
        n = i;
        i1 = j;
        if (localView != paramView)
        {
          n = i;
          i1 = j;
          if (localView.getVisibility() == 0)
          {
            Drawable localDrawable = localView.getBackground();
            if (localDrawable == null) {
              break label227;
            }
            if (localDrawable.getOpacity() != -1) {
              break label221;
            }
            k = 1;
            label121:
            n = i;
            i1 = j;
            if (k != 0)
            {
              n = i;
              i1 = j;
              if (aB(localView))
              {
                n = i;
                i1 = j;
                if (localView.getHeight() >= i2)
                {
                  if (!s(localView, 3)) {
                    break label233;
                  }
                  k = localView.getRight();
                  if (k <= i) {
                    break label598;
                  }
                  i = k;
                }
              }
            }
          }
        }
      }
    }
    label598:
    for (;;)
    {
      i1 = j;
      n = i;
      for (;;)
      {
        m += 1;
        i = n;
        j = i1;
        break;
        label221:
        k = 0;
        break label121;
        label227:
        k = 0;
        break label121;
        label233:
        k = localView.getLeft();
        n = i;
        i1 = j;
        if (k < j)
        {
          i1 = k;
          n = i;
        }
      }
      paramCanvas.clipRect(i, 0, j, getHeight());
      k = j;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i3);
      if ((this.Kf > 0.0F) && (bool1))
      {
        j = (int)(((this.Ke & 0xFF000000) >>> 24) * this.Kf);
        m = this.Ke;
        this.Kg.setColor(j << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(i, 0.0F, k, getHeight(), this.Kg);
      }
      do
      {
        return bool2;
        if ((this.Kt != null) && (s(paramView, 3)))
        {
          i = this.Kt.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.Kh.MT;
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.Kt.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.Kt.setAlpha((int)(255.0F * f));
          this.Kt.draw(paramCanvas);
          return bool2;
        }
      } while ((this.Ku == null) || (!s(paramView, 5)));
      i = this.Ku.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = this.Ki.MT;
      float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      this.Ku.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.Ku.setAlpha((int)(255.0F * f));
      this.Ku.draw(paramCanvas);
      return bool2;
    }
  }
  
  final void f(View paramView, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!aB(localView))) || ((paramBoolean) && (localView == paramView))) {
        q.n(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        q.n(localView, 4);
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public float getDrawerElevation()
  {
    if (Ka) {
      return this.Kc;
    }
    return 0.0F;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.hK;
  }
  
  final void k(View paramView, float paramFloat)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == paramView.KE) {}
    for (;;)
    {
      return;
      paramView.KE = paramFloat;
      if (this.mListeners != null)
      {
        int i = this.mListeners.size() - 1;
        while (i >= 0)
        {
          ((c)this.mListeners.get(i)).C(paramFloat);
          i -= 1;
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.Hb = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.Hb = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i;
    if ((this.hJ) && (this.hK != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label77;
      }
      if (this.Kx == null) {
        break label72;
      }
      i = ((WindowInsets)this.Kx).getSystemWindowInsetTop();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.hK.setBounds(0, 0, getWidth(), i);
        this.hK.draw(paramCanvas);
      }
      return;
      label72:
      i = 0;
      continue;
      label77:
      i = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = paramMotionEvent.getActionMasked();
    boolean bool2 = this.Kh.f(paramMotionEvent);
    boolean bool3 = this.Ki.f(paramMotionEvent);
    label63:
    int j;
    label85:
    label113:
    float f1;
    float f2;
    switch (i)
    {
    default: 
      i = 0;
      if ((!(bool3 | bool2)) && (i == 0))
      {
        j = getChildCount();
        i = 0;
        if (i >= j) {
          break label373;
        }
        if (!((LayoutParams)getChildAt(i).getLayoutParams()).KF) {
          break;
        }
        i = 1;
        if ((i == 0) && (!this.Kr)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.FH = f1;
      this.FI = f2;
      if (this.Kf > 0.0F)
      {
        paramMotionEvent = this.Kh.y((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!aA(paramMotionEvent))) {}
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      this.Kq = false;
      this.Kr = false;
      break label63;
      paramMotionEvent = this.Kh;
      int k = paramMotionEvent.MJ.length;
      j = 0;
      label214:
      if (j < k) {
        if (paramMotionEvent.aO(j))
        {
          f1 = paramMotionEvent.ML[j] - paramMotionEvent.MJ[j];
          f2 = paramMotionEvent.MM[j] - paramMotionEvent.MK[j];
          if (f1 * f1 + f2 * f2 > paramMotionEvent.jb * paramMotionEvent.jb)
          {
            i = 1;
            if (i == 0) {
              break label331;
            }
          }
        }
      }
      label286:
      for (i = 1; i != 0; i = 0)
      {
        this.Kj.dD();
        this.Kk.dD();
        i = 0;
        break label63;
        i = 0;
        break label286;
        i = 0;
        break label286;
        label331:
        j += 1;
        break label214;
      }
      K(true);
      this.Kq = false;
      this.Kr = false;
      break;
      i += 1;
      break label85;
      label373:
      i = 0;
      break label113;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (dG() != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramKeyEvent.startTracking();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      paramKeyEvent = dG();
      if ((paramKeyEvent != null) && (ax(paramKeyEvent) == 0)) {
        K(false);
      }
      if (paramKeyEvent != null) {
        bool = true;
      }
      return bool;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      LayoutParams localLayoutParams;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (aA(localView)) {
          localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
        }
      }
      else
      {
        paramInt3 += 1;
        continue;
      }
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      int i;
      float f;
      label163:
      int j;
      if (s(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * localLayoutParams.KE) + paramInt1;
        f = (i1 + i) / i1;
        if (f == localLayoutParams.KE) {
          break label310;
        }
        j = 1;
        label177:
        switch (localLayoutParams.gravity & 0x70)
        {
        default: 
          localView.layout(i, localLayoutParams.topMargin, i1 + i, i2 + localLayoutParams.topMargin);
          label237:
          if (j != 0) {
            k(localView, f);
          }
          if (localLayoutParams.KE <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localLayoutParams.KE);
        f = (m - i) / i1;
        break label163;
        label310:
        j = 0;
        break label177;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - localLayoutParams.bottomMargin);
        break label237;
        int i3 = paramInt4 - paramInt2;
        int k = (i3 - i2) / 2;
        if (k < localLayoutParams.topMargin) {
          paramInt1 = localLayoutParams.topMargin;
        }
        for (;;)
        {
          localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
          break;
          paramInt1 = k;
          if (k + i2 > i3 - localLayoutParams.bottomMargin) {
            paramInt1 = i3 - localLayoutParams.bottomMargin - i2;
          }
        }
      }
    }
    this.mInLayout = false;
    this.Hb = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int j;
    int i;
    if (i1 == 1073741824)
    {
      j = k;
      if (n == 1073741824) {}
    }
    else if (isInEditMode())
    {
      i = k;
      if (i1 != -2147483648)
      {
        i = k;
        if (i1 == 0) {
          i = 300;
        }
      }
      j = i;
      if (n == -2147483648) {
        break label794;
      }
      j = i;
      if (n != 0) {
        break label794;
      }
      k = 300;
    }
    for (m = i;; m = j)
    {
      setMeasuredDimension(m, k);
      label146:
      View localView;
      int i2;
      int i3;
      LayoutParams localLayoutParams;
      Object localObject2;
      Object localObject1;
      if ((this.Kx != null) && (q.ae(this)))
      {
        n = 1;
        int i4 = q.Q(this);
        i = 0;
        j = 0;
        int i5 = getChildCount();
        i1 = 0;
        if (i1 >= i5) {
          break label793;
        }
        localView = getChildAt(i1);
        i2 = j;
        i3 = i;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (n != 0)
          {
            i2 = d.getAbsoluteGravity(localLayoutParams.gravity, i4);
            if (!q.ae(localView)) {
              break label396;
            }
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject2 = (WindowInsets)this.Kx;
              if (i2 != 3) {
                break label360;
              }
              localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
              label259:
              localView.dispatchApplyWindowInsets((WindowInsets)localObject1);
            }
          }
        }
      }
      for (;;)
      {
        if (aA(localView))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(m - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
          i3 = i;
          i2 = j;
          i1 += 1;
          j = i2;
          i = i3;
          break label146;
          throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
          n = 0;
          break;
          label360:
          localObject1 = localObject2;
          if (i2 != 5) {
            break label259;
          }
          localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
          break label259;
          label396:
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject2 = (WindowInsets)this.Kx;
            if (i2 == 3) {
              localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
            }
            for (;;)
            {
              localLayoutParams.leftMargin = ((WindowInsets)localObject1).getSystemWindowInsetLeft();
              localLayoutParams.topMargin = ((WindowInsets)localObject1).getSystemWindowInsetTop();
              localLayoutParams.rightMargin = ((WindowInsets)localObject1).getSystemWindowInsetRight();
              localLayoutParams.bottomMargin = ((WindowInsets)localObject1).getSystemWindowInsetBottom();
              break;
              localObject1 = localObject2;
              if (i2 == 5) {
                localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
              }
            }
          }
        }
      }
      if (aB(localView))
      {
        if ((Ka) && (q.Z(localView) != this.Kc)) {
          q.h(localView, this.Kc);
        }
        i3 = az(localView) & 0x7;
        if (i3 == 3)
        {
          i2 = 1;
          if (((i2 == 0) || (i == 0)) && ((i2 != 0) || (j == 0))) {
            break label677;
          }
          localObject2 = new StringBuilder("Child drawer has absolute gravity ");
          if ((i3 & 0x3) != 3) {
            break label651;
          }
          localObject1 = "LEFT";
        }
        for (;;)
        {
          throw new IllegalStateException((String)localObject1 + " but this DrawerLayout already has a drawer view along that edge");
          i2 = 0;
          break;
          label651:
          if ((i3 & 0x5) == 5) {
            localObject1 = "RIGHT";
          } else {
            localObject1 = Integer.toHexString(i3);
          }
        }
        label677:
        if (i2 != 0) {
          i = 1;
        }
        for (;;)
        {
          localView.measure(getChildMeasureSpec(paramInt1, this.Kd + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
          i2 = j;
          i3 = i;
          break;
          j = 1;
        }
      }
      throw new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
      label793:
      return;
      label794:
      k = m;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.EA);
      if (paramParcelable.KH != 0)
      {
        View localView = aH(paramParcelable.KH);
        if (localView != null) {
          aC(localView);
        }
      }
      if (paramParcelable.KI != 3) {
        t(paramParcelable.KI, 3);
      }
      if (paramParcelable.KJ != 3) {
        t(paramParcelable.KJ, 5);
      }
      if (paramParcelable.KK != 3) {
        t(paramParcelable.KK, 8388611);
      }
    } while (paramParcelable.KL == 3);
    t(paramParcelable.KL, 8388613);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    Drawable localDrawable;
    if (!Ka)
    {
      paramInt = q.Q(this);
      if (paramInt != 0) {
        break label77;
      }
      if (this.Ky == null) {
        break label101;
      }
      c(this.Ky, paramInt);
      localDrawable = this.Ky;
      this.Kt = localDrawable;
      paramInt = q.Q(this);
      if (paramInt != 0) {
        break label109;
      }
      if (this.Kz == null) {
        break label133;
      }
      c(this.Kz, paramInt);
      localDrawable = this.Kz;
    }
    label133:
    for (;;)
    {
      this.Ku = localDrawable;
      return;
      label77:
      if (this.Kz != null)
      {
        c(this.Kz, paramInt);
        localDrawable = this.Kz;
        break;
      }
      label101:
      localDrawable = this.KA;
      break;
      label109:
      if (this.Ky != null)
      {
        c(this.Ky, paramInt);
        localDrawable = this.Ky;
      }
      else
      {
        localDrawable = this.KB;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int m = getChildCount();
    int i = 0;
    for (;;)
    {
      LayoutParams localLayoutParams;
      int j;
      if (i < m)
      {
        localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        if (localLayoutParams.KG != 1) {
          break label119;
        }
        j = 1;
        if (localLayoutParams.KG != 2) {
          break label124;
        }
      }
      label119:
      label124:
      for (int k = 1;; k = 0)
      {
        if ((j == 0) && (k == 0)) {
          break label129;
        }
        localSavedState.KH = localLayoutParams.gravity;
        localSavedState.KI = this.Km;
        localSavedState.KJ = this.Kn;
        localSavedState.KK = this.Ko;
        localSavedState.KL = this.Kp;
        return localSavedState;
        j = 0;
        break;
      }
      label129:
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.Kh.g(paramMotionEvent);
    this.Ki.g(paramMotionEvent);
    float f1;
    float f2;
    boolean bool;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return true;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.FH = f1;
      this.FI = f2;
      this.Kq = false;
      this.Kr = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.Kh.y((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (aA(paramMotionEvent)))
      {
        f2 -= this.FH;
        f1 -= this.FI;
        int i = this.Kh.jb;
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = dF();
          if (paramMotionEvent != null) {
            if (ax(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      K(bool);
      this.Kq = false;
      return true;
      bool = false;
      continue;
      K(true);
      this.Kq = false;
      this.Kr = false;
      return true;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.Kq = paramBoolean;
    if (paramBoolean) {
      K(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  final boolean s(View paramView, int paramInt)
  {
    return (az(paramView) & paramInt) == paramInt;
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.Kc = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (aB(localView)) {
        q.h(localView, this.Kc);
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void setDrawerListener(c paramc)
  {
    if (this.Ks != null)
    {
      c localc = this.Ks;
      if ((localc != null) && (this.mListeners != null)) {
        this.mListeners.remove(localc);
      }
    }
    if ((paramc != null) && (paramc != null))
    {
      if (this.mListeners == null) {
        this.mListeners = new ArrayList();
      }
      this.mListeners.add(paramc);
    }
    this.Ks = paramc;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    t(paramInt, 3);
    t(paramInt, 5);
  }
  
  public void setScrimColor(int paramInt)
  {
    this.Ke = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = b.g(getContext(), paramInt);; localDrawable = null)
    {
      this.hK = localDrawable;
      invalidate();
      return;
    }
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.hK = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    this.hK = new ColorDrawable(paramInt);
    invalidate();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    float KE;
    boolean KF;
    int KG;
    public int gravity = 0;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.Gr);
      this.gravity = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    int KH = 0;
    int KI;
    int KJ;
    int KK;
    int KL;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.KH = paramParcel.readInt();
      this.KI = paramParcel.readInt();
      this.KJ = paramParcel.readInt();
      this.KK = paramParcel.readInt();
      this.KL = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.KH);
      paramParcel.writeInt(this.KI);
      paramParcel.writeInt(this.KJ);
      paramParcel.writeInt(this.KK);
      paramParcel.writeInt(this.KL);
    }
  }
  
  final class a
    extends android.support.v4.view.a
  {
    private final Rect hc = new Rect();
    
    a() {}
    
    public final void a(View paramView, android.support.v4.view.a.a parama)
    {
      if (DrawerLayout.JZ) {
        super.a(paramView, parama);
      }
      for (;;)
      {
        parama.setClassName(DrawerLayout.class.getName());
        parama.setFocusable(false);
        parama.setFocused(false);
        parama.a(a.a.HL);
        parama.a(a.a.HM);
        return;
        Object localObject1 = android.support.v4.view.a.a.a(parama);
        super.a(paramView, (android.support.v4.view.a.a)localObject1);
        parama.setSource(paramView);
        Object localObject2 = q.R(paramView);
        if ((localObject2 instanceof View)) {
          parama.setParent((View)localObject2);
        }
        localObject2 = this.hc;
        ((android.support.v4.view.a.a)localObject1).getBoundsInParent((Rect)localObject2);
        parama.setBoundsInParent((Rect)localObject2);
        ((android.support.v4.view.a.a)localObject1).getBoundsInScreen((Rect)localObject2);
        parama.setBoundsInScreen((Rect)localObject2);
        parama.setVisibleToUser(((android.support.v4.view.a.a)localObject1).isVisibleToUser());
        parama.setPackageName(((android.support.v4.view.a.a)localObject1).HJ.getPackageName());
        parama.setClassName(((android.support.v4.view.a.a)localObject1).HJ.getClassName());
        parama.setContentDescription(((android.support.v4.view.a.a)localObject1).HJ.getContentDescription());
        parama.setEnabled(((android.support.v4.view.a.a)localObject1).HJ.isEnabled());
        parama.setClickable(((android.support.v4.view.a.a)localObject1).HJ.isClickable());
        parama.setFocusable(((android.support.v4.view.a.a)localObject1).HJ.isFocusable());
        parama.setFocused(((android.support.v4.view.a.a)localObject1).HJ.isFocused());
        parama.setAccessibilityFocused(((android.support.v4.view.a.a)localObject1).isAccessibilityFocused());
        parama.setSelected(((android.support.v4.view.a.a)localObject1).HJ.isSelected());
        parama.setLongClickable(((android.support.v4.view.a.a)localObject1).HJ.isLongClickable());
        parama.addAction(((android.support.v4.view.a.a)localObject1).HJ.getActions());
        ((android.support.v4.view.a.a)localObject1).HJ.recycle();
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject1 = paramView.getChildAt(i);
          if (DrawerLayout.aE((View)localObject1)) {
            parama.addChild((View)localObject1);
          }
          i += 1;
        }
      }
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getText();
        paramView = DrawerLayout.this.dG();
        int i;
        if (paramView != null)
        {
          i = DrawerLayout.this.az(paramView);
          paramView = DrawerLayout.this;
          i = d.getAbsoluteGravity(i, q.Q(paramView));
          if (i != 3) {
            break label73;
          }
          paramView = paramView.Kv;
        }
        for (;;)
        {
          if (paramView != null) {
            paramAccessibilityEvent.add(paramView);
          }
          return true;
          label73:
          if (i == 5) {
            paramView = paramView.Kw;
          } else {
            paramView = null;
          }
        }
      }
      return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((DrawerLayout.JZ) || (DrawerLayout.aE(paramView))) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  static final class b
    extends android.support.v4.view.a
  {
    public final void a(View paramView, android.support.v4.view.a.a parama)
    {
      super.a(paramView, parama);
      if (!DrawerLayout.aE(paramView)) {
        parama.setParent(null);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void C(float paramFloat);
    
    public abstract void dH();
    
    public abstract void dI();
  }
  
  private final class d
    extends r.a
  {
    final int KM;
    r KN;
    private final Runnable KO = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        Object localObject2 = DrawerLayout.d.this;
        int m = ((DrawerLayout.d)localObject2).KN.MT;
        int i;
        Object localObject1;
        int j;
        if (((DrawerLayout.d)localObject2).KM == 3)
        {
          i = 1;
          if (i == 0) {
            break label226;
          }
          localObject1 = ((DrawerLayout.d)localObject2).KD.aH(3);
          if (localObject1 == null) {
            break label221;
          }
          j = -((View)localObject1).getWidth();
          label56:
          j += m;
        }
        for (;;)
        {
          label61:
          if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (((DrawerLayout.d)localObject2).KD.ax((View)localObject1) == 0))))
          {
            DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((DrawerLayout.d)localObject2).KN.e((View)localObject1, j, ((View)localObject1).getTop());
            localLayoutParams.KF = true;
            ((DrawerLayout.d)localObject2).KD.invalidate();
            ((DrawerLayout.d)localObject2).dJ();
            localObject1 = ((DrawerLayout.d)localObject2).KD;
            if (!((DrawerLayout)localObject1).Kr)
            {
              long l = SystemClock.uptimeMillis();
              localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
              j = ((DrawerLayout)localObject1).getChildCount();
              i = k;
              for (;;)
              {
                if (i < j)
                {
                  ((DrawerLayout)localObject1).getChildAt(i).dispatchTouchEvent((MotionEvent)localObject2);
                  i += 1;
                  continue;
                  i = 0;
                  break;
                  label221:
                  j = 0;
                  break label56;
                  label226:
                  localObject1 = ((DrawerLayout.d)localObject2).KD.aH(5);
                  j = ((DrawerLayout.d)localObject2).KD.getWidth() - m;
                  break label61;
                }
              }
              ((MotionEvent)localObject2).recycle();
              ((DrawerLayout)localObject1).Kr = true;
            }
          }
        }
      }
    };
    
    d(int paramInt)
    {
      this.KM = paramInt;
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.ay(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.s(paramView, 3)) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
          i = 0;
        }
      }
      for (;;)
      {
        this.KN.x(i, paramView.getTop());
        DrawerLayout.this.invalidate();
        return;
        i = -k;
        continue;
        int j = DrawerLayout.this.getWidth();
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (paramFloat2 <= 0.5F) {}
          }
        }
        else
        {
          i = j - k;
        }
      }
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.s(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        DrawerLayout.this.k(paramView, f);
        if (f != 0.0F) {
          break label76;
        }
      }
      label76:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        paramView.setVisibility(paramInt1);
        DrawerLayout.this.invalidate();
        return;
        f = (DrawerLayout.this.getWidth() - paramInt1) / paramInt2;
        break;
      }
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      return (DrawerLayout.aB(paramView)) && (DrawerLayout.this.s(paramView, this.KM)) && (DrawerLayout.this.ax(paramView) == 0);
    }
    
    public final int c(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final int d(View paramView, int paramInt)
    {
      if (DrawerLayout.this.s(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
      }
      int i = DrawerLayout.this.getWidth();
      return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
    }
    
    public final void dD()
    {
      DrawerLayout.this.removeCallbacks(this.KO);
    }
    
    final void dJ()
    {
      int i = 3;
      if (this.KM == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.aH(i);
      if (localView != null) {
        DrawerLayout.this.aD(localView);
      }
    }
    
    public final void dK()
    {
      DrawerLayout.this.postDelayed(this.KO, 160L);
    }
    
    public final void j(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).KF = false;
      dJ();
    }
    
    public final int q(View paramView)
    {
      if (DrawerLayout.aB(paramView)) {
        return paramView.getWidth();
      }
      return 0;
    }
    
    public final void u(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = DrawerLayout.this.aH(3);; localView = DrawerLayout.this.aH(5))
      {
        if ((localView != null) && (DrawerLayout.this.ax(localView) == 0)) {
          this.KN.t(localView, paramInt2);
        }
        return;
      }
    }
    
    public final void x(int paramInt)
    {
      DrawerLayout localDrawerLayout = DrawerLayout.this;
      View localView = this.KN.MW;
      int i = localDrawerLayout.Kh.MI;
      int j = localDrawerLayout.Ki.MI;
      if ((i == 1) || (j == 1)) {
        i = 1;
      }
      DrawerLayout.LayoutParams localLayoutParams;
      while ((localView != null) && (paramInt == 0))
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.KE != 0.0F) {
          break label266;
        }
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.KG & 0x1) == 1)
        {
          localLayoutParams.KG = 0;
          if (localDrawerLayout.mListeners != null)
          {
            paramInt = localDrawerLayout.mListeners.size() - 1;
            for (;;)
            {
              if (paramInt >= 0)
              {
                ((DrawerLayout.c)localDrawerLayout.mListeners.get(paramInt)).dI();
                paramInt -= 1;
                continue;
                if ((i == 2) || (j == 2))
                {
                  i = 2;
                  break;
                }
                i = 0;
                break;
              }
            }
          }
          localDrawerLayout.f(localView, false);
          if (localDrawerLayout.hasWindowFocus())
          {
            localView = localDrawerLayout.getRootView();
            if (localView != null) {
              localView.sendAccessibilityEvent(32);
            }
          }
        }
      }
      while (i != localDrawerLayout.Kl)
      {
        localDrawerLayout.Kl = i;
        if (localDrawerLayout.mListeners == null) {
          break;
        }
        paramInt = localDrawerLayout.mListeners.size() - 1;
        while (paramInt >= 0)
        {
          localDrawerLayout.mListeners.get(paramInt);
          paramInt -= 1;
        }
        label266:
        if (localLayoutParams.KE == 1.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((localLayoutParams.KG & 0x1) == 0)
          {
            localLayoutParams.KG = 1;
            if (localDrawerLayout.mListeners != null)
            {
              paramInt = localDrawerLayout.mListeners.size() - 1;
              while (paramInt >= 0)
              {
                ((DrawerLayout.c)localDrawerLayout.mListeners.get(paramInt)).dH();
                paramInt -= 1;
              }
            }
            localDrawerLayout.f(localView, true);
            if (localDrawerLayout.hasWindowFocus()) {
              localDrawerLayout.sendAccessibilityEvent(32);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */