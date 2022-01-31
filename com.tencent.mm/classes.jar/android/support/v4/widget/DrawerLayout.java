package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
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
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.b.a;
import android.support.v4.view.d;
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
  private static final int[] JE;
  static final boolean JF;
  private static final boolean JG;
  static final int[] LAYOUT_ATTRS;
  private final b JH = new b();
  private float JI;
  private int JJ;
  private int JK = -1728053248;
  private float JL;
  private Paint JM = new Paint();
  final t JN;
  final t JO;
  private final d JP;
  private final d JQ;
  int JR;
  private int JS = 3;
  private int JT = 3;
  private int JU = 3;
  private int JV = 3;
  private boolean JW;
  boolean JX;
  private c JY;
  private Drawable JZ;
  private Drawable Ka;
  CharSequence Kb;
  CharSequence Kc;
  Object Kd;
  private Drawable Ke = null;
  private Drawable Kf = null;
  private Drawable Kg = null;
  private Drawable Kh = null;
  private final ArrayList<View> Ki;
  private Rect Kj;
  private Matrix Kk;
  List<c> fv;
  boolean iG;
  private Drawable iH;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  
  static
  {
    boolean bool2 = true;
    JE = new int[] { 16843828 };
    LAYOUT_ATTRS = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      JF = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      JG = bool1;
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
    this.JJ = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.JP = new d(3);
    this.JQ = new d(5);
    this.JN = t.a(this, 1.0F, this.JP);
    this.JN.MK = 1;
    this.JN.MI = f2;
    this.JP.Kv = this.JN;
    this.JO = t.a(this, 1.0F, this.JQ);
    this.JO.MK = 2;
    this.JO.MI = f2;
    this.JQ.Kv = this.JO;
    setFocusableInTouchMode(true);
    android.support.v4.view.t.o(this, 1);
    android.support.v4.view.t.a(this, new a());
    setMotionEventSplittingEnabled(false);
    if (android.support.v4.view.t.al(this))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label336;
      }
      setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          boolean bool2 = true;
          paramAnonymousView = (DrawerLayout)paramAnonymousView;
          if (paramAnonymousWindowInsets.getSystemWindowInsetTop() > 0)
          {
            bool1 = true;
            paramAnonymousView.Kd = paramAnonymousWindowInsets;
            paramAnonymousView.iG = bool1;
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
      paramContext = paramContext.obtainStyledAttributes(JE);
    }
    for (;;)
    {
      try
      {
        this.iH = paramContext.getDrawable(0);
        paramContext.recycle();
        this.JI = (f1 * 10.0F);
        this.Ki = new ArrayList();
        return;
      }
      finally
      {
        paramContext.recycle();
      }
      label336:
      this.iH = null;
    }
  }
  
  private void J(boolean paramBoolean)
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
      if (aI(localView)) {
        if (paramBoolean)
        {
          bool = i;
          if (!localLayoutParams.Kn) {}
        }
        else
        {
          k = localView.getWidth();
          if (!v(localView, 3)) {
            break label115;
          }
          i |= this.JN.i(localView, -k, localView.getTop());
        }
      }
      for (;;)
      {
        localLayoutParams.Kn = false;
        k = i;
        j += 1;
        i = k;
        break;
        label115:
        i |= this.JO.i(localView, getWidth(), localView.getTop());
      }
    }
    this.JP.dU();
    this.JQ.dU();
    if (i != 0) {
      invalidate();
    }
  }
  
  static float aF(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).Km;
  }
  
  private static boolean aH(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }
  
  static boolean aI(View paramView)
  {
    int i = d.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, android.support.v4.view.t.T(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  private void aJ(View paramView)
  {
    if (!aI(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.Km = 1.0F;
      localLayoutParams.Ko = 1;
      f(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      localLayoutParams.Ko |= 0x2;
      if (v(paramView, 3)) {
        this.JN.i(paramView, 0, paramView.getTop());
      } else {
        this.JO.i(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  static boolean aL(View paramView)
  {
    return (android.support.v4.view.t.S(paramView) != 4) && (android.support.v4.view.t.S(paramView) != 2);
  }
  
  private static boolean c(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (!android.support.v4.graphics.drawable.a.a(paramDrawable))) {
      return false;
    }
    android.support.v4.graphics.drawable.a.b(paramDrawable, paramInt);
    return true;
  }
  
  private View dW()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).Ko & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void t(int paramInt1, int paramInt2)
  {
    int i = d.getAbsoluteGravity(paramInt2, android.support.v4.view.t.T(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.JN;
          label67:
          ((t)localObject).cancel();
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
        this.JS = paramInt1;
        break;
        this.JT = paramInt1;
        break;
        this.JU = paramInt1;
        break;
        this.JV = paramInt1;
        break;
        localObject = this.JO;
        break label67;
        localObject = aE(i);
      } while (localObject == null);
      aJ((View)localObject);
      return;
      localObject = aE(i);
    } while (localObject == null);
    aK((View)localObject);
  }
  
  public final int aE(View paramView)
  {
    if (!aI(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    int i = ((LayoutParams)paramView.getLayoutParams()).gravity;
    int j = android.support.v4.view.t.T(this);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      if (this.JS != 3) {
        return this.JS;
      }
      if (j == 0) {}
      for (i = this.JU; i != 3; i = this.JV) {
        return i;
      }
      if (this.JT != 3) {
        return this.JT;
      }
      if (j == 0) {}
      for (i = this.JV; i != 3; i = this.JU) {
        return i;
      }
      if (this.JU != 3) {
        return this.JU;
      }
      if (j == 0) {}
      for (i = this.JS; i != 3; i = this.JT) {
        return i;
      }
      if (this.JV != 3) {
        return this.JV;
      }
      if (j == 0) {}
      for (i = this.JT; i != 3; i = this.JS) {
        return i;
      }
    }
  }
  
  final View aE(int paramInt)
  {
    int i = d.getAbsoluteGravity(paramInt, android.support.v4.view.t.T(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((aG(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  final int aG(View paramView)
  {
    return d.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, android.support.v4.view.t.T(this));
  }
  
  public final void aK(View paramView)
  {
    if (!aI(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.Km = 0.0F;
      localLayoutParams.Ko = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      localLayoutParams.Ko |= 0x4;
      if (v(paramView, 3)) {
        this.JN.i(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.JO.i(paramView, getWidth(), paramView.getTop());
      }
    }
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
      if (aI(localView))
      {
        if (!aI(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if ((((LayoutParams)localView.getLayoutParams()).Ko & 0x1) == 1)
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
        this.Ki.add(localView);
      }
    }
    if (i == 0)
    {
      j = this.Ki.size();
      i = 0;
      while (i < j)
      {
        localView = (View)this.Ki.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.Ki.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((dW() != null) || (aI(paramView))) {
      android.support.v4.view.t.o(paramView, 4);
    }
    for (;;)
    {
      if (!JF) {
        android.support.v4.view.t.a(paramView, this.JH);
      }
      return;
      android.support.v4.view.t.o(paramView, 1);
    }
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
      f = Math.max(f, ((LayoutParams)getChildAt(i).getLayoutParams()).Km);
      i += 1;
    }
    this.JL = f;
    boolean bool1 = this.JN.ep();
    boolean bool2 = this.JO.ep();
    if ((bool1) || (bool2)) {
      android.support.v4.view.t.R(this);
    }
  }
  
  final View dX()
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView = getChildAt(i);
      if (aI(localView))
      {
        if (!aI(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if (((LayoutParams)localView.getLayoutParams()).Km > 0.0F) {}
        for (int j = 1; j != 0; j = 0) {
          return localView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) == 0) || (paramMotionEvent.getAction() == 10) || (this.JL <= 0.0F)) {
      return super.dispatchGenericMotionEvent(paramMotionEvent);
    }
    int i = getChildCount();
    if (i != 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i -= 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        if (this.Kj == null) {
          this.Kj = new Rect();
        }
        localView.getHitRect(this.Kj);
        if ((this.Kj.contains((int)f1, (int)f2)) && (!aH(localView)))
        {
          float f3;
          float f4;
          boolean bool;
          if (!localView.getMatrix().isIdentity())
          {
            f3 = getScrollX() - localView.getLeft();
            f4 = getScrollY() - localView.getTop();
            MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
            localMotionEvent.offsetLocation(f3, f4);
            Matrix localMatrix = localView.getMatrix();
            if (!localMatrix.isIdentity())
            {
              if (this.Kk == null) {
                this.Kk = new Matrix();
              }
              localMatrix.invert(this.Kk);
              localMotionEvent.transform(this.Kk);
            }
            bool = localView.dispatchGenericMotionEvent(localMotionEvent);
            localMotionEvent.recycle();
          }
          while (bool)
          {
            return true;
            f3 = getScrollX() - localView.getLeft();
            f4 = getScrollY() - localView.getTop();
            paramMotionEvent.offsetLocation(f3, f4);
            bool = localView.dispatchGenericMotionEvent(paramMotionEvent);
            paramMotionEvent.offsetLocation(-f3, -f4);
          }
        }
        i -= 1;
      }
    }
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i2 = getHeight();
    boolean bool1 = aH(paramView);
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
              if (aI(localView))
              {
                n = i;
                i1 = j;
                if (localView.getHeight() >= i2)
                {
                  if (!v(localView, 3)) {
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
      if ((this.JL > 0.0F) && (bool1))
      {
        j = (int)(((this.JK & 0xFF000000) >>> 24) * this.JL);
        m = this.JK;
        this.JM.setColor(j << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(i, 0.0F, k, getHeight(), this.JM);
      }
      do
      {
        return bool2;
        if ((this.JZ != null) && (v(paramView, 3)))
        {
          i = this.JZ.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.JN.MJ;
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.JZ.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.JZ.setAlpha((int)(255.0F * f));
          this.JZ.draw(paramCanvas);
          return bool2;
        }
      } while ((this.Ka == null) || (!v(paramView, 5)));
      i = this.Ka.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = this.JO.MJ;
      float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      this.Ka.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.Ka.setAlpha((int)(255.0F * f));
      this.Ka.draw(paramCanvas);
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
      if (((!paramBoolean) && (!aI(localView))) || ((paramBoolean) && (localView == paramView))) {
        android.support.v4.view.t.o(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        android.support.v4.view.t.o(localView, 4);
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
    if (JG) {
      return this.JI;
    }
    return 0.0F;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.iH;
  }
  
  final void l(View paramView, float paramFloat)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == paramView.Km) {}
    for (;;)
    {
      return;
      paramView.Km = paramFloat;
      if (this.fv != null)
      {
        int i = this.fv.size() - 1;
        while (i >= 0)
        {
          ((c)this.fv.get(i)).D(paramFloat);
          i -= 1;
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i;
    if ((this.iG) && (this.iH != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label77;
      }
      if (this.Kd == null) {
        break label72;
      }
      i = ((WindowInsets)this.Kd).getSystemWindowInsetTop();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.iH.setBounds(0, 0, getWidth(), i);
        this.iH.draw(paramCanvas);
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
    boolean bool2 = this.JN.f(paramMotionEvent);
    boolean bool3 = this.JO.f(paramMotionEvent);
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
        if (!((LayoutParams)getChildAt(i).getLayoutParams()).Kn) {
          break;
        }
        i = 1;
        if ((i == 0) && (!this.JX)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if (this.JL > 0.0F)
      {
        paramMotionEvent = this.JN.A((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!aH(paramMotionEvent))) {}
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      this.JW = false;
      this.JX = false;
      break label63;
      paramMotionEvent = this.JN;
      int k = paramMotionEvent.Mx.length;
      j = 0;
      label214:
      if (j < k) {
        if (paramMotionEvent.aK(j))
        {
          f1 = paramMotionEvent.Mz[j] - paramMotionEvent.Mx[j];
          f2 = paramMotionEvent.MA[j] - paramMotionEvent.My[j];
          if (f1 * f1 + f2 * f2 > paramMotionEvent.mTouchSlop * paramMotionEvent.mTouchSlop)
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
        this.JP.dU();
        this.JQ.dU();
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
      J(true);
      this.JW = false;
      this.JX = false;
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
      if (dX() != null) {}
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
      paramKeyEvent = dX();
      if ((paramKeyEvent != null) && (aE(paramKeyEvent) == 0)) {
        J(false);
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
        if (aH(localView)) {
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
      if (v(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * localLayoutParams.Km) + paramInt1;
        f = (i1 + i) / i1;
        if (f == localLayoutParams.Km) {
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
            l(localView, f);
          }
          if (localLayoutParams.Km <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localLayoutParams.Km);
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
    this.mFirstLayout = false;
  }
  
  @SuppressLint({"WrongConstant"})
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
      if ((this.Kd != null) && (android.support.v4.view.t.al(this)))
      {
        n = 1;
        int i4 = android.support.v4.view.t.T(this);
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
            if (!android.support.v4.view.t.al(localView)) {
              break label396;
            }
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject2 = (WindowInsets)this.Kd;
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
        if (aH(localView))
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
            localObject2 = (WindowInsets)this.Kd;
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
      if (aI(localView))
      {
        if ((JG) && (android.support.v4.view.t.ag(localView) != this.JI)) {
          android.support.v4.view.t.i(localView, this.JI);
        }
        i3 = aG(localView) & 0x7;
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
          localView.measure(getChildMeasureSpec(paramInt1, this.JJ + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
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
      super.onRestoreInstanceState(paramParcelable.Fo);
      if (paramParcelable.Kp != 0)
      {
        View localView = aE(paramParcelable.Kp);
        if (localView != null) {
          aJ(localView);
        }
      }
      if (paramParcelable.Kq != 3) {
        t(paramParcelable.Kq, 3);
      }
      if (paramParcelable.Kr != 3) {
        t(paramParcelable.Kr, 5);
      }
      if (paramParcelable.Ks != 3) {
        t(paramParcelable.Ks, 8388611);
      }
    } while (paramParcelable.Kt == 3);
    t(paramParcelable.Kt, 8388613);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    Drawable localDrawable;
    if (!JG)
    {
      paramInt = android.support.v4.view.t.T(this);
      if (paramInt != 0) {
        break label77;
      }
      if (this.Ke == null) {
        break label101;
      }
      c(this.Ke, paramInt);
      localDrawable = this.Ke;
      this.JZ = localDrawable;
      paramInt = android.support.v4.view.t.T(this);
      if (paramInt != 0) {
        break label109;
      }
      if (this.Kf == null) {
        break label133;
      }
      c(this.Kf, paramInt);
      localDrawable = this.Kf;
    }
    label133:
    for (;;)
    {
      this.Ka = localDrawable;
      return;
      label77:
      if (this.Kf != null)
      {
        c(this.Kf, paramInt);
        localDrawable = this.Kf;
        break;
      }
      label101:
      localDrawable = this.Kg;
      break;
      label109:
      if (this.Ke != null)
      {
        c(this.Ke, paramInt);
        localDrawable = this.Ke;
      }
      else
      {
        localDrawable = this.Kh;
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
        if (localLayoutParams.Ko != 1) {
          break label119;
        }
        j = 1;
        if (localLayoutParams.Ko != 2) {
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
        localSavedState.Kp = localLayoutParams.gravity;
        localSavedState.Kq = this.JS;
        localSavedState.Kr = this.JT;
        localSavedState.Ks = this.JU;
        localSavedState.Kt = this.JV;
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
    this.JN.g(paramMotionEvent);
    this.JO.g(paramMotionEvent);
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
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.JW = false;
      this.JX = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.JN.A((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (aH(paramMotionEvent)))
      {
        f2 -= this.mInitialMotionX;
        f1 -= this.mInitialMotionY;
        int i = this.JN.mTouchSlop;
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = dW();
          if (paramMotionEvent != null) {
            if (aE(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      J(bool);
      this.JW = false;
      return true;
      bool = false;
      continue;
      J(true);
      this.JW = false;
      this.JX = false;
      return true;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.JW = paramBoolean;
    if (paramBoolean) {
      J(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.JI = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (aI(localView)) {
        android.support.v4.view.t.i(localView, this.JI);
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void setDrawerListener(c paramc)
  {
    if (this.JY != null)
    {
      c localc = this.JY;
      if ((localc != null) && (this.fv != null)) {
        this.fv.remove(localc);
      }
    }
    if ((paramc != null) && (paramc != null))
    {
      if (this.fv == null) {
        this.fv = new ArrayList();
      }
      this.fv.add(paramc);
    }
    this.JY = paramc;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    t(paramInt, 3);
    t(paramInt, 5);
  }
  
  public void setScrimColor(int paramInt)
  {
    this.JK = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v4.content.b.k(getContext(), paramInt);; localDrawable = null)
    {
      this.iH = localDrawable;
      invalidate();
      return;
    }
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.iH = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    this.iH = new ColorDrawable(paramInt);
    invalidate();
  }
  
  final boolean v(View paramView, int paramInt)
  {
    return (aG(paramView) & paramInt) == paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    float Km;
    boolean Kn;
    int Ko;
    public int gravity = 0;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
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
    int Kp = 0;
    int Kq;
    int Kr;
    int Ks;
    int Kt;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.Kp = paramParcel.readInt();
      this.Kq = paramParcel.readInt();
      this.Kr = paramParcel.readInt();
      this.Ks = paramParcel.readInt();
      this.Kt = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Kp);
      paramParcel.writeInt(this.Kq);
      paramParcel.writeInt(this.Kr);
      paramParcel.writeInt(this.Ks);
      paramParcel.writeInt(this.Kt);
    }
  }
  
  final class a
    extends android.support.v4.view.a
  {
    private final Rect hV = new Rect();
    
    a() {}
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getText();
        paramView = DrawerLayout.this.dX();
        int i;
        if (paramView != null)
        {
          i = DrawerLayout.this.aG(paramView);
          paramView = DrawerLayout.this;
          i = d.getAbsoluteGravity(i, android.support.v4.view.t.T(paramView));
          if (i != 3) {
            break label73;
          }
          paramView = paramView.Kb;
        }
        for (;;)
        {
          if (paramView != null) {
            paramAccessibilityEvent.add(paramView);
          }
          return true;
          label73:
          if (i == 5) {
            paramView = paramView.Kc;
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
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, android.support.v4.view.a.b paramb)
    {
      if (DrawerLayout.JF) {
        super.onInitializeAccessibilityNodeInfo(paramView, paramb);
      }
      for (;;)
      {
        paramb.setClassName(DrawerLayout.class.getName());
        paramb.setFocusable(false);
        paramb.setFocused(false);
        paramb.a(b.a.Hs);
        paramb.a(b.a.Ht);
        return;
        Object localObject1 = android.support.v4.view.a.b.a(paramb);
        super.onInitializeAccessibilityNodeInfo(paramView, (android.support.v4.view.a.b)localObject1);
        paramb.setSource(paramView);
        Object localObject2 = android.support.v4.view.t.U(paramView);
        if ((localObject2 instanceof View)) {
          paramb.setParent((View)localObject2);
        }
        localObject2 = this.hV;
        ((android.support.v4.view.a.b)localObject1).getBoundsInParent((Rect)localObject2);
        paramb.setBoundsInParent((Rect)localObject2);
        ((android.support.v4.view.a.b)localObject1).getBoundsInScreen((Rect)localObject2);
        paramb.setBoundsInScreen((Rect)localObject2);
        paramb.setVisibleToUser(((android.support.v4.view.a.b)localObject1).isVisibleToUser());
        paramb.setPackageName(((android.support.v4.view.a.b)localObject1).Hq.getPackageName());
        paramb.setClassName(((android.support.v4.view.a.b)localObject1).Hq.getClassName());
        paramb.setContentDescription(((android.support.v4.view.a.b)localObject1).Hq.getContentDescription());
        paramb.setEnabled(((android.support.v4.view.a.b)localObject1).Hq.isEnabled());
        paramb.setClickable(((android.support.v4.view.a.b)localObject1).Hq.isClickable());
        paramb.setFocusable(((android.support.v4.view.a.b)localObject1).Hq.isFocusable());
        paramb.setFocused(((android.support.v4.view.a.b)localObject1).Hq.isFocused());
        paramb.setAccessibilityFocused(((android.support.v4.view.a.b)localObject1).isAccessibilityFocused());
        paramb.setSelected(((android.support.v4.view.a.b)localObject1).Hq.isSelected());
        paramb.setLongClickable(((android.support.v4.view.a.b)localObject1).Hq.isLongClickable());
        paramb.addAction(((android.support.v4.view.a.b)localObject1).Hq.getActions());
        ((android.support.v4.view.a.b)localObject1).Hq.recycle();
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject1 = paramView.getChildAt(i);
          if (DrawerLayout.aL((View)localObject1)) {
            paramb.addChild((View)localObject1);
          }
          i += 1;
        }
      }
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((DrawerLayout.JF) || (DrawerLayout.aL(paramView))) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  static final class b
    extends android.support.v4.view.a
  {
    public final void onInitializeAccessibilityNodeInfo(View paramView, android.support.v4.view.a.b paramb)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramb);
      if (!DrawerLayout.aL(paramView)) {
        paramb.setParent(null);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void D(float paramFloat);
    
    public abstract void dY();
    
    public abstract void dZ();
  }
  
  final class d
    extends t.a
  {
    final int Ku;
    t Kv;
    private final Runnable Kw = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        Object localObject2 = DrawerLayout.d.this;
        int m = ((DrawerLayout.d)localObject2).Kv.MJ;
        int i;
        Object localObject1;
        int j;
        if (((DrawerLayout.d)localObject2).Ku == 3)
        {
          i = 1;
          if (i == 0) {
            break label226;
          }
          localObject1 = ((DrawerLayout.d)localObject2).Kl.aE(3);
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
          if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (((DrawerLayout.d)localObject2).Kl.aE((View)localObject1) == 0))))
          {
            DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((DrawerLayout.d)localObject2).Kv.i((View)localObject1, j, ((View)localObject1).getTop());
            localLayoutParams.Kn = true;
            ((DrawerLayout.d)localObject2).Kl.invalidate();
            ((DrawerLayout.d)localObject2).ea();
            localObject1 = ((DrawerLayout.d)localObject2).Kl;
            if (!((DrawerLayout)localObject1).JX)
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
                  localObject1 = ((DrawerLayout.d)localObject2).Kl.aE(5);
                  j = ((DrawerLayout.d)localObject2).Kl.getWidth() - m;
                  break label61;
                }
              }
              ((MotionEvent)localObject2).recycle();
              ((DrawerLayout)localObject1).JX = true;
            }
          }
        }
      }
    };
    
    d(int paramInt)
    {
      this.Ku = paramInt;
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.aF(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.v(paramView, 3)) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
          i = 0;
        }
      }
      for (;;)
      {
        this.Kv.y(i, paramView.getTop());
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
    
    public final void b(View paramView, int paramInt1, int paramInt2)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.v(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        DrawerLayout.this.l(paramView, f);
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
      return (DrawerLayout.aI(paramView)) && (DrawerLayout.this.v(paramView, this.Ku)) && (DrawerLayout.this.aE(paramView) == 0);
    }
    
    public final int c(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final int d(View paramView, int paramInt)
    {
      if (DrawerLayout.this.v(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
      }
      int i = DrawerLayout.this.getWidth();
      return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
    }
    
    public final void dU()
    {
      DrawerLayout.this.removeCallbacks(this.Kw);
    }
    
    final void ea()
    {
      int i = 3;
      if (this.Ku == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.aE(i);
      if (localView != null) {
        DrawerLayout.this.aK(localView);
      }
    }
    
    public final void eb()
    {
      DrawerLayout.this.postDelayed(this.Kw, 160L);
    }
    
    public final void k(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).Kn = false;
      ea();
    }
    
    public final int s(View paramView)
    {
      if (DrawerLayout.aI(paramView)) {
        return paramView.getWidth();
      }
      return 0;
    }
    
    public final void u(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = DrawerLayout.this.aE(3);; localView = DrawerLayout.this.aE(5))
      {
        if ((localView != null) && (DrawerLayout.this.aE(localView) == 0)) {
          this.Kv.w(localView, paramInt2);
        }
        return;
      }
    }
    
    public final void w(int paramInt)
    {
      DrawerLayout localDrawerLayout = DrawerLayout.this;
      View localView = this.Kv.MM;
      int i = localDrawerLayout.JN.Mw;
      int j = localDrawerLayout.JO.Mw;
      if ((i == 1) || (j == 1)) {
        i = 1;
      }
      DrawerLayout.LayoutParams localLayoutParams;
      while ((localView != null) && (paramInt == 0))
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.Km != 0.0F) {
          break label266;
        }
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.Ko & 0x1) == 1)
        {
          localLayoutParams.Ko = 0;
          if (localDrawerLayout.fv != null)
          {
            paramInt = localDrawerLayout.fv.size() - 1;
            for (;;)
            {
              if (paramInt >= 0)
              {
                ((DrawerLayout.c)localDrawerLayout.fv.get(paramInt)).dZ();
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
      while (i != localDrawerLayout.JR)
      {
        localDrawerLayout.JR = i;
        if (localDrawerLayout.fv == null) {
          break;
        }
        paramInt = localDrawerLayout.fv.size() - 1;
        while (paramInt >= 0)
        {
          localDrawerLayout.fv.get(paramInt);
          paramInt -= 1;
        }
        label266:
        if (localLayoutParams.Km == 1.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((localLayoutParams.Ko & 0x1) == 0)
          {
            localLayoutParams.Ko = 1;
            if (localDrawerLayout.fv != null)
            {
              paramInt = localDrawerLayout.fv.size() - 1;
              while (paramInt >= 0)
              {
                ((DrawerLayout.c)localDrawerLayout.fv.get(paramInt)).dY();
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