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
import android.support.v4.content.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.c;
import android.support.v4.view.a.c.a;
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
  static final int[] LAYOUT_ATTRS;
  private static final int[] QE;
  static final boolean QF;
  private static final boolean QG;
  private final b QH = new b();
  private float QI;
  private int QJ;
  private int QK = -1728053248;
  private float QL;
  private Paint QM = new Paint();
  final t QN;
  final t QO;
  private final d QP;
  private final d QQ;
  int QR;
  private int QS = 3;
  private int QT = 3;
  private int QU = 3;
  private int QV = 3;
  private boolean QW;
  boolean QX;
  private c QY;
  private Drawable QZ;
  private Drawable Ra;
  CharSequence Rb;
  CharSequence Rc;
  Object Rd;
  private Drawable Re = null;
  private Drawable Rf = null;
  private Drawable Rg = null;
  private Drawable Rh = null;
  private final ArrayList<View> Ri;
  private Rect Rj;
  private Matrix Rk;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  List<c> mListeners;
  boolean nA;
  private Drawable nB;
  
  static
  {
    boolean bool2 = true;
    QE = new int[] { 16843828 };
    LAYOUT_ATTRS = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      QF = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QG = bool1;
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
    this.QJ = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.QP = new d(3);
    this.QQ = new d(5);
    this.QN = t.a(this, 1.0F, this.QP);
    this.QN.TL = 1;
    this.QN.TJ = f2;
    this.QP.Rw = this.QN;
    this.QO = t.a(this, 1.0F, this.QQ);
    this.QO.TL = 2;
    this.QO.TJ = f2;
    this.QQ.Rw = this.QO;
    setFocusableInTouchMode(true);
    android.support.v4.view.t.p(this, 1);
    android.support.v4.view.t.a(this, new a());
    setMotionEventSplittingEnabled(false);
    if (android.support.v4.view.t.aq(this))
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
            paramAnonymousView.Rd = paramAnonymousWindowInsets;
            paramAnonymousView.nA = bool1;
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
      paramContext = paramContext.obtainStyledAttributes(QE);
    }
    for (;;)
    {
      try
      {
        this.nB = paramContext.getDrawable(0);
        paramContext.recycle();
        this.QI = (f1 * 10.0F);
        this.Ri = new ArrayList();
        return;
      }
      finally
      {
        paramContext.recycle();
      }
      label336:
      this.nB = null;
    }
  }
  
  private void P(boolean paramBoolean)
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
      if (aO(localView)) {
        if (paramBoolean)
        {
          bool = i;
          if (!localLayoutParams.Ro) {}
        }
        else
        {
          k = localView.getWidth();
          if (!x(localView, 3)) {
            break label115;
          }
          i |= this.QN.h(localView, -k, localView.getTop());
        }
      }
      for (;;)
      {
        localLayoutParams.Ro = false;
        k = i;
        j += 1;
        i = k;
        break;
        label115:
        i |= this.QO.h(localView, getWidth(), localView.getTop());
      }
    }
    this.QP.fm();
    this.QQ.fm();
    if (i != 0) {
      invalidate();
    }
  }
  
  static float aL(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).Rn;
  }
  
  private static boolean aN(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }
  
  static boolean aO(View paramView)
  {
    int i = d.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, android.support.v4.view.t.Y(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  private void aP(View paramView)
  {
    if (!aO(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.Rn = 1.0F;
      localLayoutParams.Rp = 1;
      f(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      localLayoutParams.Rp |= 0x2;
      if (x(paramView, 3)) {
        this.QN.h(paramView, 0, paramView.getTop());
      } else {
        this.QO.h(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  static boolean aR(View paramView)
  {
    return (android.support.v4.view.t.X(paramView) != 4) && (android.support.v4.view.t.X(paramView) != 2);
  }
  
  private static boolean c(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (!android.support.v4.graphics.drawable.a.e(paramDrawable))) {
      return false;
    }
    android.support.v4.graphics.drawable.a.b(paramDrawable, paramInt);
    return true;
  }
  
  private View fo()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).Rp & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void v(int paramInt1, int paramInt2)
  {
    int i = d.getAbsoluteGravity(paramInt2, android.support.v4.view.t.Y(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.QN;
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
        this.QS = paramInt1;
        break;
        this.QT = paramInt1;
        break;
        this.QU = paramInt1;
        break;
        this.QV = paramInt1;
        break;
        localObject = this.QO;
        break label67;
        localObject = aV(i);
      } while (localObject == null);
      aP((View)localObject);
      return;
      localObject = aV(i);
    } while (localObject == null);
    aQ((View)localObject);
  }
  
  public final int aK(View paramView)
  {
    if (!aO(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    int i = ((LayoutParams)paramView.getLayoutParams()).gravity;
    int j = android.support.v4.view.t.Y(this);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      if (this.QS != 3) {
        return this.QS;
      }
      if (j == 0) {}
      for (i = this.QU; i != 3; i = this.QV) {
        return i;
      }
      if (this.QT != 3) {
        return this.QT;
      }
      if (j == 0) {}
      for (i = this.QV; i != 3; i = this.QU) {
        return i;
      }
      if (this.QU != 3) {
        return this.QU;
      }
      if (j == 0) {}
      for (i = this.QS; i != 3; i = this.QT) {
        return i;
      }
      if (this.QV != 3) {
        return this.QV;
      }
      if (j == 0) {}
      for (i = this.QT; i != 3; i = this.QS) {
        return i;
      }
    }
  }
  
  final int aM(View paramView)
  {
    return d.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, android.support.v4.view.t.Y(this));
  }
  
  public final void aQ(View paramView)
  {
    if (!aO(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.Rn = 0.0F;
      localLayoutParams.Rp = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      localLayoutParams.Rp |= 0x4;
      if (x(paramView, 3)) {
        this.QN.h(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.QO.h(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  final View aV(int paramInt)
  {
    int i = d.getAbsoluteGravity(paramInt, android.support.v4.view.t.Y(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((aM(localView) & 0x7) == (i & 0x7)) {
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
      if (aO(localView))
      {
        if (!aO(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if ((((LayoutParams)localView.getLayoutParams()).Rp & 0x1) == 1)
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
        this.Ri.add(localView);
      }
    }
    if (i == 0)
    {
      j = this.Ri.size();
      i = 0;
      while (i < j)
      {
        localView = (View)this.Ri.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.Ri.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((fo() != null) || (aO(paramView))) {
      android.support.v4.view.t.p(paramView, 4);
    }
    for (;;)
    {
      if (!QF) {
        android.support.v4.view.t.a(paramView, this.QH);
      }
      return;
      android.support.v4.view.t.p(paramView, 1);
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
      f = Math.max(f, ((LayoutParams)getChildAt(i).getLayoutParams()).Rn);
      i += 1;
    }
    this.QL = f;
    boolean bool1 = this.QN.fH();
    boolean bool2 = this.QO.fH();
    if ((bool1) || (bool2)) {
      android.support.v4.view.t.W(this);
    }
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) == 0) || (paramMotionEvent.getAction() == 10) || (this.QL <= 0.0F)) {
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
        if (this.Rj == null) {
          this.Rj = new Rect();
        }
        localView.getHitRect(this.Rj);
        if ((this.Rj.contains((int)f1, (int)f2)) && (!aN(localView)))
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
              if (this.Rk == null) {
                this.Rk = new Matrix();
              }
              localMatrix.invert(this.Rk);
              localMotionEvent.transform(this.Rk);
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
    boolean bool1 = aN(paramView);
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
              if (aO(localView))
              {
                n = i;
                i1 = j;
                if (localView.getHeight() >= i2)
                {
                  if (!x(localView, 3)) {
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
      if ((this.QL > 0.0F) && (bool1))
      {
        j = (int)(((this.QK & 0xFF000000) >>> 24) * this.QL);
        m = this.QK;
        this.QM.setColor(j << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(i, 0.0F, k, getHeight(), this.QM);
      }
      do
      {
        return bool2;
        if ((this.QZ != null) && (x(paramView, 3)))
        {
          i = this.QZ.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.QN.TK;
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.QZ.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.QZ.setAlpha((int)(255.0F * f));
          this.QZ.draw(paramCanvas);
          return bool2;
        }
      } while ((this.Ra == null) || (!x(paramView, 5)));
      i = this.Ra.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = this.QO.TK;
      float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      this.Ra.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.Ra.setAlpha((int)(255.0F * f));
      this.Ra.draw(paramCanvas);
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
      if (((!paramBoolean) && (!aO(localView))) || ((paramBoolean) && (localView == paramView))) {
        android.support.v4.view.t.p(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        android.support.v4.view.t.p(localView, 4);
      }
    }
  }
  
  final View fp()
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView = getChildAt(i);
      if (aO(localView))
      {
        if (!aO(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if (((LayoutParams)localView.getLayoutParams()).Rn > 0.0F) {}
        for (int j = 1; j != 0; j = 0) {
          return localView;
        }
      }
      i += 1;
    }
    return null;
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
    if (QG) {
      return this.QI;
    }
    return 0.0F;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.nB;
  }
  
  final void n(View paramView, float paramFloat)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == paramView.Rn) {}
    for (;;)
    {
      return;
      paramView.Rn = paramFloat;
      if (this.mListeners != null)
      {
        int i = this.mListeners.size() - 1;
        while (i >= 0)
        {
          ((c)this.mListeners.get(i)).D(paramFloat);
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
    if ((this.nA) && (this.nB != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label77;
      }
      if (this.Rd == null) {
        break label72;
      }
      i = ((WindowInsets)this.Rd).getSystemWindowInsetTop();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.nB.setBounds(0, 0, getWidth(), i);
        this.nB.draw(paramCanvas);
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
    boolean bool2 = this.QN.g(paramMotionEvent);
    boolean bool3 = this.QO.g(paramMotionEvent);
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
        if (!((LayoutParams)getChildAt(i).getLayoutParams()).Ro) {
          break;
        }
        i = 1;
        if ((i == 0) && (!this.QX)) {}
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
      if (this.QL > 0.0F)
      {
        paramMotionEvent = this.QN.C((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!aN(paramMotionEvent))) {}
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      this.QW = false;
      this.QX = false;
      break label63;
      paramMotionEvent = this.QN;
      int k = paramMotionEvent.TA.length;
      j = 0;
      label214:
      if (j < k) {
        if (paramMotionEvent.bd(j))
        {
          f1 = paramMotionEvent.TC[j] - paramMotionEvent.TA[j];
          f2 = paramMotionEvent.TD[j] - paramMotionEvent.TB[j];
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
        this.QP.fm();
        this.QQ.fm();
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
      P(true);
      this.QW = false;
      this.QX = false;
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
      if (fp() != null) {}
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
      paramKeyEvent = fp();
      if ((paramKeyEvent != null) && (aK(paramKeyEvent) == 0)) {
        P(false);
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
        if (aN(localView)) {
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
      if (x(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * localLayoutParams.Rn) + paramInt1;
        f = (i1 + i) / i1;
        if (f == localLayoutParams.Rn) {
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
            n(localView, f);
          }
          if (localLayoutParams.Rn <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localLayoutParams.Rn);
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
      if ((this.Rd != null) && (android.support.v4.view.t.aq(this)))
      {
        n = 1;
        int i4 = android.support.v4.view.t.Y(this);
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
            if (!android.support.v4.view.t.aq(localView)) {
              break label396;
            }
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject2 = (WindowInsets)this.Rd;
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
        if (aN(localView))
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
            localObject2 = (WindowInsets)this.Rd;
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
      if (aO(localView))
      {
        if ((QG) && (android.support.v4.view.t.al(localView) != this.QI)) {
          android.support.v4.view.t.k(localView, this.QI);
        }
        i3 = aM(localView) & 0x7;
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
          localView.measure(getChildMeasureSpec(paramInt1, this.QJ + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
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
      super.onRestoreInstanceState(paramParcelable.Mm);
      if (paramParcelable.Rq != 0)
      {
        View localView = aV(paramParcelable.Rq);
        if (localView != null) {
          aP(localView);
        }
      }
      if (paramParcelable.Rr != 3) {
        v(paramParcelable.Rr, 3);
      }
      if (paramParcelable.Rs != 3) {
        v(paramParcelable.Rs, 5);
      }
      if (paramParcelable.Rt != 3) {
        v(paramParcelable.Rt, 8388611);
      }
    } while (paramParcelable.Ru == 3);
    v(paramParcelable.Ru, 8388613);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    Drawable localDrawable;
    if (!QG)
    {
      paramInt = android.support.v4.view.t.Y(this);
      if (paramInt != 0) {
        break label77;
      }
      if (this.Re == null) {
        break label101;
      }
      c(this.Re, paramInt);
      localDrawable = this.Re;
      this.QZ = localDrawable;
      paramInt = android.support.v4.view.t.Y(this);
      if (paramInt != 0) {
        break label109;
      }
      if (this.Rf == null) {
        break label133;
      }
      c(this.Rf, paramInt);
      localDrawable = this.Rf;
    }
    label133:
    for (;;)
    {
      this.Ra = localDrawable;
      return;
      label77:
      if (this.Rf != null)
      {
        c(this.Rf, paramInt);
        localDrawable = this.Rf;
        break;
      }
      label101:
      localDrawable = this.Rg;
      break;
      label109:
      if (this.Re != null)
      {
        c(this.Re, paramInt);
        localDrawable = this.Re;
      }
      else
      {
        localDrawable = this.Rh;
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
        if (localLayoutParams.Rp != 1) {
          break label119;
        }
        j = 1;
        if (localLayoutParams.Rp != 2) {
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
        localSavedState.Rq = localLayoutParams.gravity;
        localSavedState.Rr = this.QS;
        localSavedState.Rs = this.QT;
        localSavedState.Rt = this.QU;
        localSavedState.Ru = this.QV;
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
    this.QN.h(paramMotionEvent);
    this.QO.h(paramMotionEvent);
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
      this.QW = false;
      this.QX = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.QN.C((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (aN(paramMotionEvent)))
      {
        f2 -= this.mInitialMotionX;
        f1 -= this.mInitialMotionY;
        int i = this.QN.mTouchSlop;
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = fo();
          if (paramMotionEvent != null) {
            if (aK(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      P(bool);
      this.QW = false;
      return true;
      bool = false;
      continue;
      P(true);
      this.QW = false;
      this.QX = false;
      return true;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.QW = paramBoolean;
    if (paramBoolean) {
      P(true);
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
    this.QI = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (aO(localView)) {
        android.support.v4.view.t.k(localView, this.QI);
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void setDrawerListener(c paramc)
  {
    if (this.QY != null)
    {
      c localc = this.QY;
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
    this.QY = paramc;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    v(paramInt, 3);
    v(paramInt, 5);
  }
  
  public void setScrimColor(int paramInt)
  {
    this.QK = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = b.l(getContext(), paramInt);; localDrawable = null)
    {
      this.nB = localDrawable;
      invalidate();
      return;
    }
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.nB = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    this.nB = new ColorDrawable(paramInt);
    invalidate();
  }
  
  final boolean x(View paramView, int paramInt)
  {
    return (aM(paramView) & paramInt) == paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    float Rn;
    boolean Ro;
    int Rp;
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
    int Rq = 0;
    int Rr;
    int Rs;
    int Rt;
    int Ru;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.Rq = paramParcel.readInt();
      this.Rr = paramParcel.readInt();
      this.Rs = paramParcel.readInt();
      this.Rt = paramParcel.readInt();
      this.Ru = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Rq);
      paramParcel.writeInt(this.Rr);
      paramParcel.writeInt(this.Rs);
      paramParcel.writeInt(this.Rt);
      paramParcel.writeInt(this.Ru);
    }
  }
  
  final class a
    extends android.support.v4.view.a
  {
    private final Rect Rm = new Rect();
    
    a() {}
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getText();
        paramView = DrawerLayout.this.fp();
        int i;
        if (paramView != null)
        {
          i = DrawerLayout.this.aM(paramView);
          paramView = DrawerLayout.this;
          i = d.getAbsoluteGravity(i, android.support.v4.view.t.Y(paramView));
          if (i != 3) {
            break label73;
          }
          paramView = paramView.Rb;
        }
        for (;;)
        {
          if (paramView != null) {
            paramAccessibilityEvent.add(paramView);
          }
          return true;
          label73:
          if (i == 5) {
            paramView = paramView.Rc;
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
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      if (DrawerLayout.QF) {
        super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      }
      for (;;)
      {
        paramc.setClassName(DrawerLayout.class.getName());
        paramc.setFocusable(false);
        paramc.setFocused(false);
        paramc.a(c.a.Or);
        paramc.a(c.a.Os);
        return;
        Object localObject1 = c.a(paramc);
        super.onInitializeAccessibilityNodeInfo(paramView, (c)localObject1);
        paramc.setSource(paramView);
        Object localObject2 = android.support.v4.view.t.Z(paramView);
        if ((localObject2 instanceof View)) {
          paramc.setParent((View)localObject2);
        }
        localObject2 = this.Rm;
        ((c)localObject1).getBoundsInParent((Rect)localObject2);
        paramc.setBoundsInParent((Rect)localObject2);
        ((c)localObject1).getBoundsInScreen((Rect)localObject2);
        paramc.setBoundsInScreen((Rect)localObject2);
        paramc.setVisibleToUser(((c)localObject1).isVisibleToUser());
        paramc.setPackageName(((c)localObject1).Op.getPackageName());
        paramc.setClassName(((c)localObject1).Op.getClassName());
        paramc.setContentDescription(((c)localObject1).Op.getContentDescription());
        paramc.setEnabled(((c)localObject1).Op.isEnabled());
        paramc.setClickable(((c)localObject1).Op.isClickable());
        paramc.setFocusable(((c)localObject1).Op.isFocusable());
        paramc.setFocused(((c)localObject1).Op.isFocused());
        paramc.setAccessibilityFocused(((c)localObject1).isAccessibilityFocused());
        paramc.setSelected(((c)localObject1).Op.isSelected());
        paramc.setLongClickable(((c)localObject1).Op.isLongClickable());
        paramc.addAction(((c)localObject1).Op.getActions());
        ((c)localObject1).Op.recycle();
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject1 = paramView.getChildAt(i);
          if (DrawerLayout.aR((View)localObject1)) {
            paramc.addChild((View)localObject1);
          }
          i += 1;
        }
      }
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((DrawerLayout.QF) || (DrawerLayout.aR(paramView))) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  static final class b
    extends android.support.v4.view.a
  {
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      if (!DrawerLayout.aR(paramView)) {
        paramc.setParent(null);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void D(float paramFloat);
    
    public abstract void fq();
    
    public abstract void fr();
  }
  
  final class d
    extends t.a
  {
    final int Rv;
    t Rw;
    private final Runnable Rx = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        Object localObject2 = DrawerLayout.d.this;
        int m = ((DrawerLayout.d)localObject2).Rw.TK;
        int i;
        Object localObject1;
        int j;
        if (((DrawerLayout.d)localObject2).Rv == 3)
        {
          i = 1;
          if (i == 0) {
            break label226;
          }
          localObject1 = ((DrawerLayout.d)localObject2).Rl.aV(3);
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
          if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (((DrawerLayout.d)localObject2).Rl.aK((View)localObject1) == 0))))
          {
            DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((DrawerLayout.d)localObject2).Rw.h((View)localObject1, j, ((View)localObject1).getTop());
            localLayoutParams.Ro = true;
            ((DrawerLayout.d)localObject2).Rl.invalidate();
            ((DrawerLayout.d)localObject2).fs();
            localObject1 = ((DrawerLayout.d)localObject2).Rl;
            if (!((DrawerLayout)localObject1).QX)
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
                  localObject1 = ((DrawerLayout.d)localObject2).Rl.aV(5);
                  j = ((DrawerLayout.d)localObject2).Rl.getWidth() - m;
                  break label61;
                }
              }
              ((MotionEvent)localObject2).recycle();
              ((DrawerLayout)localObject1).QX = true;
            }
          }
        }
      }
    };
    
    d(int paramInt)
    {
      this.Rv = paramInt;
    }
    
    public final void M(int paramInt)
    {
      DrawerLayout localDrawerLayout = DrawerLayout.this;
      View localView = this.Rw.TN;
      int i = localDrawerLayout.QN.Tz;
      int j = localDrawerLayout.QO.Tz;
      if ((i == 1) || (j == 1)) {
        i = 1;
      }
      DrawerLayout.LayoutParams localLayoutParams;
      while ((localView != null) && (paramInt == 0))
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.Rn != 0.0F) {
          break label266;
        }
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.Rp & 0x1) == 1)
        {
          localLayoutParams.Rp = 0;
          if (localDrawerLayout.mListeners != null)
          {
            paramInt = localDrawerLayout.mListeners.size() - 1;
            for (;;)
            {
              if (paramInt >= 0)
              {
                ((DrawerLayout.c)localDrawerLayout.mListeners.get(paramInt)).fr();
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
      while (i != localDrawerLayout.QR)
      {
        localDrawerLayout.QR = i;
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
        if (localLayoutParams.Rn == 1.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((localLayoutParams.Rp & 0x1) == 0)
          {
            localLayoutParams.Rp = 1;
            if (localDrawerLayout.mListeners != null)
            {
              paramInt = localDrawerLayout.mListeners.size() - 1;
              while (paramInt >= 0)
              {
                ((DrawerLayout.c)localDrawerLayout.mListeners.get(paramInt)).fq();
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
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.aL(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.x(paramView, 3)) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
          i = 0;
        }
      }
      for (;;)
      {
        this.Rw.A(i, paramView.getTop());
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
      if (DrawerLayout.this.x(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        DrawerLayout.this.n(paramView, f);
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
    
    public final boolean c(View paramView, int paramInt)
    {
      return (DrawerLayout.aO(paramView)) && (DrawerLayout.this.x(paramView, this.Rv)) && (DrawerLayout.this.aK(paramView) == 0);
    }
    
    public final int d(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final int e(View paramView, int paramInt)
    {
      if (DrawerLayout.this.x(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
      }
      int i = DrawerLayout.this.getWidth();
      return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
    }
    
    public final void fm()
    {
      DrawerLayout.this.removeCallbacks(this.Rx);
    }
    
    final void fs()
    {
      int i = 3;
      if (this.Rv == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.aV(i);
      if (localView != null) {
        DrawerLayout.this.aQ(localView);
      }
    }
    
    public final void ft()
    {
      DrawerLayout.this.postDelayed(this.Rx, 160L);
    }
    
    public final void l(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).Ro = false;
      fs();
    }
    
    public final void w(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = DrawerLayout.this.aV(3);; localView = DrawerLayout.this.aV(5))
      {
        if ((localView != null) && (DrawerLayout.this.aK(localView) == 0)) {
          this.Rw.y(localView, paramInt2);
        }
        return;
      }
    }
    
    public final int x(View paramView)
    {
      if (DrawerLayout.aO(paramView)) {
        return paramView.getWidth();
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */