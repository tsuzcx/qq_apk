package androidx.drawerlayout.widget;

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
import androidx.core.g.a.d;
import androidx.core.g.a.d.a;
import androidx.core.g.e;
import androidx.core.g.w;
import androidx.customview.a.c;
import androidx.customview.a.c.a;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
{
  static final int[] LAYOUT_ATTRS;
  private static final int[] RA;
  static final boolean RB;
  private static final boolean RC;
  boolean Hk;
  private Drawable Hl;
  private final b RD;
  private float RE;
  private int RF;
  private int RG;
  private float RH;
  private Paint RI;
  final c RJ;
  final c RK;
  private final d RL;
  private final d RM;
  int RN;
  private int RO;
  private int RP;
  private int RQ;
  private int RR;
  private boolean RS;
  boolean RT;
  private c RU;
  private Drawable RV;
  private Drawable RW;
  CharSequence RX;
  CharSequence RY;
  Object RZ;
  private Drawable Sa;
  private Drawable Sb;
  private Drawable Sc;
  private Drawable Sd;
  private final ArrayList<View> Se;
  private Rect Sf;
  private Matrix Sg;
  private boolean mFirstLayout;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  List<c> mListeners;
  
  static
  {
    boolean bool2 = true;
    RA = new int[] { 16843828 };
    LAYOUT_ATTRS = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      RB = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      RC = bool1;
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
    AppMethodBeat.i(213555);
    this.RD = new b();
    this.RG = -1728053248;
    this.RI = new Paint();
    this.mFirstLayout = true;
    this.RO = 3;
    this.RP = 3;
    this.RQ = 3;
    this.RR = 3;
    this.Sa = null;
    this.Sb = null;
    this.Sc = null;
    this.Sd = null;
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.RF = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.RL = new d(3);
    this.RM = new d(5);
    this.RJ = c.a(this, 1.0F, this.RL);
    this.RJ.Rt = 1;
    this.RJ.Rr = f2;
    this.RL.Ss = this.RJ;
    this.RK = c.a(this, 1.0F, this.RM);
    this.RK.Rt = 2;
    this.RK.Rr = f2;
    this.RM.Ss = this.RK;
    setFocusableInTouchMode(true);
    w.p(this, 1);
    w.a(this, new a());
    setMotionEventSplittingEnabled(false);
    if (w.Z(this))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label351;
      }
      setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          boolean bool2 = true;
          AppMethodBeat.i(213480);
          paramAnonymousView = (DrawerLayout)paramAnonymousView;
          if (paramAnonymousWindowInsets.getSystemWindowInsetTop() > 0)
          {
            bool1 = true;
            paramAnonymousView.RZ = paramAnonymousWindowInsets;
            paramAnonymousView.Hk = bool1;
            if ((bool1) || (paramAnonymousView.getBackground() != null)) {
              break label72;
            }
          }
          label72:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            paramAnonymousView.setWillNotDraw(bool1);
            paramAnonymousView.requestLayout();
            paramAnonymousView = paramAnonymousWindowInsets.consumeSystemWindowInsets();
            AppMethodBeat.o(213480);
            return paramAnonymousView;
            bool1 = false;
            break;
          }
        }
      });
      setSystemUiVisibility(1280);
      paramContext = paramContext.obtainStyledAttributes(RA);
    }
    for (;;)
    {
      try
      {
        this.Hl = paramContext.getDrawable(0);
        paramContext.recycle();
        this.RE = (f1 * 10.0F);
        this.Se = new ArrayList();
        AppMethodBeat.o(213555);
        return;
      }
      finally
      {
        paramContext.recycle();
        AppMethodBeat.o(213555);
      }
      label351:
      this.Hl = null;
    }
  }
  
  private void M(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213562);
    int i = e.D(paramInt2, w.I(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.RJ;
          label75:
          ((c)localObject).cancel();
        }
      }
      else {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(213562);
      return;
      this.RO = paramInt1;
      break;
      this.RP = paramInt1;
      break;
      this.RQ = paramInt1;
      break;
      this.RR = paramInt1;
      break;
      localObject = this.RK;
      break label75;
      localObject = bT(i);
      if (localObject != null)
      {
        aI((View)localObject);
        AppMethodBeat.o(213562);
        return;
        localObject = bT(i);
        if (localObject != null) {
          aJ((View)localObject);
        }
      }
    }
  }
  
  static float aE(View paramView)
  {
    AppMethodBeat.i(213568);
    float f = ((LayoutParams)paramView.getLayoutParams()).Sj;
    AppMethodBeat.o(213568);
    return f;
  }
  
  private static boolean aG(View paramView)
  {
    AppMethodBeat.i(213598);
    if (((LayoutParams)paramView.getLayoutParams()).ek == 0)
    {
      AppMethodBeat.o(213598);
      return true;
    }
    AppMethodBeat.o(213598);
    return false;
  }
  
  static boolean aH(View paramView)
  {
    AppMethodBeat.i(213600);
    int i = e.D(((LayoutParams)paramView.getLayoutParams()).ek, w.I(paramView));
    if ((i & 0x3) != 0)
    {
      AppMethodBeat.o(213600);
      return true;
    }
    if ((i & 0x5) != 0)
    {
      AppMethodBeat.o(213600);
      return true;
    }
    AppMethodBeat.o(213600);
    return false;
  }
  
  private void aI(View paramView)
  {
    AppMethodBeat.i(213619);
    if (!aH(paramView))
    {
      paramView = new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
      AppMethodBeat.o(213619);
      throw paramView;
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.Sj = 1.0F;
      localLayoutParams.Sl = 1;
      d(paramView, true);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(213619);
      return;
      localLayoutParams.Sl |= 0x2;
      if (A(paramView, 3)) {
        this.RJ.f(paramView, 0, paramView.getTop());
      } else {
        this.RK.f(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  static boolean aK(View paramView)
  {
    AppMethodBeat.i(213638);
    if ((w.H(paramView) != 4) && (w.H(paramView) != 2))
    {
      AppMethodBeat.o(213638);
      return true;
    }
    AppMethodBeat.o(213638);
    return false;
  }
  
  private void af(boolean paramBoolean)
  {
    AppMethodBeat.i(213617);
    int m = getChildCount();
    int j = 0;
    int i = 0;
    if (j < m)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      boolean bool = i;
      int k;
      if (aH(localView)) {
        if (paramBoolean)
        {
          bool = i;
          if (!localLayoutParams.Sk) {}
        }
        else
        {
          k = localView.getWidth();
          if (!A(localView, 3)) {
            break label121;
          }
          i |= this.RJ.f(localView, -k, localView.getTop());
        }
      }
      for (;;)
      {
        localLayoutParams.Sk = false;
        k = i;
        j += 1;
        i = k;
        break;
        label121:
        i |= this.RK.f(localView, getWidth(), localView.getTop());
      }
    }
    this.RL.hC();
    this.RM.hC();
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(213617);
  }
  
  private static boolean c(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(213581);
    if ((paramDrawable == null) || (!androidx.core.graphics.drawable.a.l(paramDrawable)))
    {
      AppMethodBeat.o(213581);
      return false;
    }
    androidx.core.graphics.drawable.a.b(paramDrawable, paramInt);
    AppMethodBeat.o(213581);
    return true;
  }
  
  private View hP()
  {
    AppMethodBeat.i(213572);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).Sl & 0x1) == 1)
      {
        AppMethodBeat.o(213572);
        return localView;
      }
      i += 1;
    }
    AppMethodBeat.o(213572);
    return null;
  }
  
  final boolean A(View paramView, int paramInt)
  {
    AppMethodBeat.i(213571);
    if ((aF(paramView) & paramInt) == paramInt)
    {
      AppMethodBeat.o(213571);
      return true;
    }
    AppMethodBeat.o(213571);
    return false;
  }
  
  public final int aD(View paramView)
  {
    AppMethodBeat.i(213563);
    if (!aH(paramView))
    {
      paramView = new IllegalArgumentException("View " + paramView + " is not a drawer");
      AppMethodBeat.o(213563);
      throw paramView;
    }
    int i = ((LayoutParams)paramView.getLayoutParams()).ek;
    int j = w.I(this);
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(213563);
      return 0;
      if (this.RO != 3)
      {
        i = this.RO;
        AppMethodBeat.o(213563);
        return i;
      }
      if (j == 0) {}
      for (i = this.RQ; i != 3; i = this.RR)
      {
        AppMethodBeat.o(213563);
        return i;
      }
      if (this.RP != 3)
      {
        i = this.RP;
        AppMethodBeat.o(213563);
        return i;
      }
      if (j == 0) {}
      for (i = this.RR; i != 3; i = this.RQ)
      {
        AppMethodBeat.o(213563);
        return i;
      }
      if (this.RQ != 3)
      {
        i = this.RQ;
        AppMethodBeat.o(213563);
        return i;
      }
      if (j == 0) {}
      for (i = this.RO; i != 3; i = this.RP)
      {
        AppMethodBeat.o(213563);
        return i;
      }
      if (this.RR != 3)
      {
        i = this.RR;
        AppMethodBeat.o(213563);
        return i;
      }
      if (j == 0) {}
      for (i = this.RP; i != 3; i = this.RO)
      {
        AppMethodBeat.o(213563);
        return i;
      }
    }
  }
  
  final int aF(View paramView)
  {
    AppMethodBeat.i(213570);
    int i = e.D(((LayoutParams)paramView.getLayoutParams()).ek, w.I(this));
    AppMethodBeat.o(213570);
    return i;
  }
  
  public final void aJ(View paramView)
  {
    AppMethodBeat.i(213620);
    if (!aH(paramView))
    {
      paramView = new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
      AppMethodBeat.o(213620);
      throw paramView;
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.Sj = 0.0F;
      localLayoutParams.Sl = 0;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(213620);
      return;
      localLayoutParams.Sl |= 0x4;
      if (A(paramView, 3)) {
        this.RJ.f(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.RK.f(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213628);
    if (getDescendantFocusability() == 393216)
    {
      AppMethodBeat.o(213628);
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
      if (aH(localView))
      {
        if (!aH(localView))
        {
          paramArrayList = new IllegalArgumentException("View " + localView + " is not a drawer");
          AppMethodBeat.o(213628);
          throw paramArrayList;
        }
        if ((((LayoutParams)localView.getLayoutParams()).Sl & 0x1) == 1)
        {
          k = 1;
          label126:
          if (k == 0) {
            break label167;
          }
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          i = 1;
        }
      }
      label167:
      for (;;)
      {
        j += 1;
        break;
        k = 0;
        break label126;
        this.Se.add(localView);
      }
    }
    if (i == 0)
    {
      j = this.Se.size();
      i = 0;
      while (i < j)
      {
        localView = (View)this.Se.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.Se.clear();
    AppMethodBeat.o(213628);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(213636);
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((hP() != null) || (aH(paramView))) {
      w.p(paramView, 4);
    }
    for (;;)
    {
      if (!RB) {
        w.a(paramView, this.RD);
      }
      AppMethodBeat.o(213636);
      return;
      w.p(paramView, 1);
    }
  }
  
  final View bT(int paramInt)
  {
    AppMethodBeat.i(213573);
    int i = e.D(paramInt, w.I(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((aF(localView) & 0x7) == (i & 0x7))
      {
        AppMethodBeat.o(213573);
        return localView;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(213573);
    return null;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(213625);
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(213625);
      return true;
    }
    AppMethodBeat.o(213625);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(213587);
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, ((LayoutParams)getChildAt(i).getLayoutParams()).Sj);
      i += 1;
    }
    this.RH = f;
    boolean bool1 = this.RJ.hM();
    boolean bool2 = this.RK.hM();
    if ((bool1) || (bool2)) {
      w.G(this);
    }
    AppMethodBeat.o(213587);
  }
  
  final void d(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(213565);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!aH(localView))) || ((paramBoolean) && (localView == paramView))) {
        w.p(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        w.p(localView, 4);
      }
    }
    AppMethodBeat.o(213565);
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213606);
    boolean bool;
    if (((paramMotionEvent.getSource() & 0x2) == 0) || (paramMotionEvent.getAction() == 10) || (this.RH <= 0.0F))
    {
      bool = super.dispatchGenericMotionEvent(paramMotionEvent);
      AppMethodBeat.o(213606);
      return bool;
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
        if (this.Sf == null) {
          this.Sf = new Rect();
        }
        localView.getHitRect(this.Sf);
        if ((this.Sf.contains((int)f1, (int)f2)) && (!aG(localView)))
        {
          float f3;
          float f4;
          if (!localView.getMatrix().isIdentity())
          {
            f3 = getScrollX() - localView.getLeft();
            f4 = getScrollY() - localView.getTop();
            MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
            localMotionEvent.offsetLocation(f3, f4);
            Matrix localMatrix = localView.getMatrix();
            if (!localMatrix.isIdentity())
            {
              if (this.Sg == null) {
                this.Sg = new Matrix();
              }
              localMatrix.invert(this.Sg);
              localMotionEvent.transform(this.Sg);
            }
            bool = localView.dispatchGenericMotionEvent(localMotionEvent);
            localMotionEvent.recycle();
          }
          while (bool)
          {
            AppMethodBeat.o(213606);
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
    AppMethodBeat.o(213606);
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(213597);
    int i2 = getHeight();
    boolean bool1 = aG(paramView);
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
              break label233;
            }
            if (localDrawable.getOpacity() != -1) {
              break label227;
            }
            k = 1;
            label127:
            n = i;
            i1 = j;
            if (k != 0)
            {
              n = i;
              i1 = j;
              if (aH(localView))
              {
                n = i;
                i1 = j;
                if (localView.getHeight() >= i2)
                {
                  if (!A(localView, 3)) {
                    break label239;
                  }
                  k = localView.getRight();
                  if (k <= i) {
                    break label610;
                  }
                  i = k;
                }
              }
            }
          }
        }
      }
    }
    label610:
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
        label227:
        k = 0;
        break label127;
        label233:
        k = 0;
        break label127;
        label239:
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
      if ((this.RH > 0.0F) && (bool1))
      {
        j = (int)(((this.RG & 0xFF000000) >>> 24) * this.RH);
        m = this.RG;
        this.RI.setColor(j << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(i, 0.0F, k, getHeight(), this.RI);
      }
      for (;;)
      {
        AppMethodBeat.o(213597);
        return bool2;
        float f;
        if ((this.RV != null) && (A(paramView, 3)))
        {
          i = this.RV.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.RJ.Rs;
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.RV.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.RV.setAlpha((int)(255.0F * f));
          this.RV.draw(paramCanvas);
        }
        else if ((this.RW != null) && (A(paramView, 5)))
        {
          i = this.RW.getIntrinsicWidth();
          j = paramView.getLeft();
          k = getWidth();
          m = this.RK.Rs;
          f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
          this.RW.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
          this.RW.setAlpha((int)(255.0F * f));
          this.RW.draw(paramCanvas);
        }
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(213622);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(213622);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(213627);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(213627);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(213623);
    if ((paramLayoutParams instanceof LayoutParams))
    {
      paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      AppMethodBeat.o(213623);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(213623);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(213623);
    return paramLayoutParams;
  }
  
  public float getDrawerElevation()
  {
    if (RC) {
      return this.RE;
    }
    return 0.0F;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.Hl;
  }
  
  final View hQ()
  {
    AppMethodBeat.i(213629);
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      Object localObject = getChildAt(i);
      if (aH((View)localObject))
      {
        if (!aH((View)localObject))
        {
          localObject = new IllegalArgumentException("View " + localObject + " is not a drawer");
          AppMethodBeat.o(213629);
          throw ((Throwable)localObject);
        }
        if (((LayoutParams)((View)localObject).getLayoutParams()).Sj > 0.0F) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(213629);
          return localObject;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(213629);
    return null;
  }
  
  final void m(View paramView, float paramFloat)
  {
    AppMethodBeat.i(213566);
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == paramView.Sj)
    {
      AppMethodBeat.o(213566);
      return;
    }
    paramView.Sj = paramFloat;
    if (this.mListeners != null)
    {
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        this.mListeners.get(i);
        i -= 1;
      }
    }
    AppMethodBeat.o(213566);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(213576);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(213576);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(213575);
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(213575);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(213595);
    super.onDraw(paramCanvas);
    int i;
    if ((this.Hk) && (this.Hl != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label89;
      }
      if (this.RZ == null) {
        break label84;
      }
      i = ((WindowInsets)this.RZ).getSystemWindowInsetTop();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.Hl.setBounds(0, 0, getWidth(), i);
        this.Hl.draw(paramCanvas);
      }
      AppMethodBeat.o(213595);
      return;
      label84:
      i = 0;
      continue;
      label89:
      i = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213604);
    int i = paramMotionEvent.getActionMasked();
    boolean bool1 = this.RJ.i(paramMotionEvent);
    boolean bool2 = this.RK.i(paramMotionEvent);
    label67:
    int j;
    label89:
    label117:
    float f1;
    float f2;
    switch (i)
    {
    default: 
      i = 0;
      if ((!(bool2 | bool1)) && (i == 0))
      {
        j = getChildCount();
        i = 0;
        if (i >= j) {
          break label379;
        }
        if (((LayoutParams)getChildAt(i).getLayoutParams()).Sk)
        {
          i = 1;
          if ((i == 0) && (!this.RT)) {
            break label385;
          }
        }
      }
      else
      {
        AppMethodBeat.o(213604);
        return true;
      }
      break;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if (this.RH > 0.0F)
      {
        paramMotionEvent = this.RJ.K((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!aG(paramMotionEvent))) {}
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      this.RS = false;
      this.RT = false;
      break label67;
      paramMotionEvent = this.RJ;
      int k = paramMotionEvent.Ri.length;
      j = 0;
      label220:
      if (j < k) {
        if (paramMotionEvent.bQ(j))
        {
          f1 = paramMotionEvent.Rk[j] - paramMotionEvent.Ri[j];
          f2 = paramMotionEvent.Rl[j] - paramMotionEvent.Rj[j];
          if (f1 * f1 + f2 * f2 > paramMotionEvent.mTouchSlop * paramMotionEvent.mTouchSlop)
          {
            i = 1;
            if (i == 0) {
              break label337;
            }
          }
        }
      }
      label292:
      for (i = 1; i != 0; i = 0)
      {
        this.RL.hC();
        this.RM.hC();
        i = 0;
        break label67;
        i = 0;
        break label292;
        i = 0;
        break label292;
        label337:
        j += 1;
        break label220;
      }
      af(true);
      this.RS = false;
      this.RT = false;
      break;
      i += 1;
      break label89;
      label379:
      i = 0;
      break label117;
      label385:
      AppMethodBeat.o(213604);
      return false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(213632);
    if (paramInt == 4)
    {
      if (hQ() != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramKeyEvent.startTracking();
        AppMethodBeat.o(213632);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(213632);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(213633);
    if (paramInt == 4)
    {
      paramKeyEvent = hQ();
      if ((paramKeyEvent != null) && (aD(paramKeyEvent) == 0)) {
        af(false);
      }
      if (paramKeyEvent != null)
      {
        AppMethodBeat.o(213633);
        return true;
      }
      AppMethodBeat.o(213633);
      return false;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(213633);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(213583);
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
        if (aG(localView)) {
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
      label169:
      int j;
      if (A(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * localLayoutParams.Sj) + paramInt1;
        f = (i1 + i) / i1;
        if (f == localLayoutParams.Sj) {
          break label314;
        }
        j = 1;
        label183:
        switch (localLayoutParams.ek & 0x70)
        {
        default: 
          localView.layout(i, localLayoutParams.topMargin, i1 + i, i2 + localLayoutParams.topMargin);
          label241:
          if (j != 0) {
            m(localView, f);
          }
          if (localLayoutParams.Sj <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localLayoutParams.Sj);
        f = (m - i) / i1;
        break label169;
        label314:
        j = 0;
        break label183;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - localLayoutParams.bottomMargin);
        break label241;
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
    AppMethodBeat.o(213583);
  }
  
  @SuppressLint({"WrongConstant"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213579);
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
        break label836;
      }
      j = i;
      if (n != 0) {
        break label836;
      }
      k = 300;
    }
    for (m = i;; m = j)
    {
      setMeasuredDimension(m, k);
      label152:
      View localView;
      int i2;
      int i3;
      LayoutParams localLayoutParams;
      Object localObject2;
      if ((this.RZ != null) && (w.Z(this)))
      {
        n = 1;
        int i4 = w.I(this);
        i = 0;
        j = 0;
        int i5 = getChildCount();
        i1 = 0;
        if (i1 >= i5) {
          break label829;
        }
        localView = getChildAt(i1);
        i2 = j;
        i3 = i;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (n != 0)
          {
            i2 = e.D(localLayoutParams.ek, i4);
            if (!w.Z(localView)) {
              break label412;
            }
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject2 = (WindowInsets)this.RZ;
              if (i2 != 3) {
                break label376;
              }
              localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
              label265:
              localView.dispatchApplyWindowInsets((WindowInsets)localObject1);
            }
          }
        }
      }
      for (;;)
      {
        if (aG(localView))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(m - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
          i3 = i;
          i2 = j;
          i1 += 1;
          j = i2;
          i = i3;
          break label152;
          localObject1 = new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
          AppMethodBeat.o(213579);
          throw ((Throwable)localObject1);
          n = 0;
          break;
          label376:
          localObject1 = localObject2;
          if (i2 != 5) {
            break label265;
          }
          localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
          break label265;
          label412:
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject2 = (WindowInsets)this.RZ;
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
      if (aH(localView))
      {
        if ((RC) && (w.U(localView) != this.RE)) {
          w.j(localView, this.RE);
        }
        i3 = aF(localView) & 0x7;
        if (i3 == 3)
        {
          i2 = 1;
          if (((i2 == 0) || (i == 0)) && ((i2 != 0) || (j == 0))) {
            break label703;
          }
          localObject2 = new StringBuilder("Child drawer has absolute gravity ");
          if ((i3 & 0x3) != 3) {
            break label677;
          }
          localObject1 = "LEFT";
        }
        for (;;)
        {
          localObject1 = new IllegalStateException((String)localObject1 + " but this DrawerLayout already has a drawer view along that edge");
          AppMethodBeat.o(213579);
          throw ((Throwable)localObject1);
          i2 = 0;
          break;
          label677:
          if ((i3 & 0x5) == 5) {
            localObject1 = "RIGHT";
          } else {
            localObject1 = Integer.toHexString(i3);
          }
        }
        label703:
        if (i2 != 0) {
          i = 1;
        }
        for (;;)
        {
          localView.measure(getChildMeasureSpec(paramInt1, this.RF + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
          i2 = j;
          i3 = i;
          break;
          j = 1;
        }
      }
      Object localObject1 = new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
      AppMethodBeat.o(213579);
      throw ((Throwable)localObject1);
      label829:
      AppMethodBeat.o(213579);
      return;
      label836:
      k = m;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(213634);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(213634);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    if (paramParcelable.Sm != 0)
    {
      View localView = bT(paramParcelable.Sm);
      if (localView != null) {
        aI(localView);
      }
    }
    if (paramParcelable.Sn != 3) {
      M(paramParcelable.Sn, 3);
    }
    if (paramParcelable.So != 3) {
      M(paramParcelable.So, 5);
    }
    if (paramParcelable.Sp != 3) {
      M(paramParcelable.Sp, 8388611);
    }
    if (paramParcelable.Sq != 3) {
      M(paramParcelable.Sq, 8388613);
    }
    AppMethodBeat.o(213634);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    AppMethodBeat.i(213594);
    Drawable localDrawable;
    if (!RC)
    {
      paramInt = w.I(this);
      if (paramInt != 0) {
        break label89;
      }
      if (this.Sa == null) {
        break label113;
      }
      c(this.Sa, paramInt);
      localDrawable = this.Sa;
      this.RV = localDrawable;
      paramInt = w.I(this);
      if (paramInt != 0) {
        break label121;
      }
      if (this.Sb == null) {
        break label145;
      }
      c(this.Sb, paramInt);
      localDrawable = this.Sb;
    }
    label145:
    for (;;)
    {
      this.RW = localDrawable;
      AppMethodBeat.o(213594);
      return;
      label89:
      if (this.Sb != null)
      {
        c(this.Sb, paramInt);
        localDrawable = this.Sb;
        break;
      }
      label113:
      localDrawable = this.Sc;
      break;
      label121:
      if (this.Sa != null)
      {
        c(this.Sa, paramInt);
        localDrawable = this.Sa;
      }
      else
      {
        localDrawable = this.Sd;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(213635);
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
        if (localLayoutParams.Sl != 1) {
          break label131;
        }
        j = 1;
        if (localLayoutParams.Sl != 2) {
          break label136;
        }
      }
      label131:
      label136:
      for (int k = 1;; k = 0)
      {
        if ((j == 0) && (k == 0)) {
          break label141;
        }
        localSavedState.Sm = localLayoutParams.ek;
        localSavedState.Sn = this.RO;
        localSavedState.So = this.RP;
        localSavedState.Sp = this.RQ;
        localSavedState.Sq = this.RR;
        AppMethodBeat.o(213635);
        return localSavedState;
        j = 0;
        break;
      }
      label141:
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213610);
    this.RJ.j(paramMotionEvent);
    this.RK.j(paramMotionEvent);
    float f1;
    float f2;
    boolean bool;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(213610);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        this.RS = false;
        this.RT = false;
      }
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.RJ.K((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (aG(paramMotionEvent)))
      {
        f2 -= this.mInitialMotionX;
        f1 -= this.mInitialMotionY;
        int i = this.RJ.mTouchSlop;
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = hP();
          if (paramMotionEvent != null) {
            if (aD(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      af(bool);
      this.RS = false;
      break;
      bool = false;
      continue;
      af(true);
      this.RS = false;
      this.RT = false;
      break;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(213614);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.RS = paramBoolean;
    if (paramBoolean) {
      af(true);
    }
    AppMethodBeat.o(213614);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(213585);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(213585);
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    AppMethodBeat.i(213557);
    this.RE = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (aH(localView)) {
        w.j(localView, this.RE);
      }
      i += 1;
    }
    AppMethodBeat.o(213557);
  }
  
  @Deprecated
  public void setDrawerListener(c paramc)
  {
    AppMethodBeat.i(213559);
    if (this.RU != null)
    {
      c localc = this.RU;
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
    this.RU = paramc;
    AppMethodBeat.o(213559);
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    AppMethodBeat.i(213561);
    M(paramInt, 3);
    M(paramInt, 5);
    AppMethodBeat.o(213561);
  }
  
  public void setScrimColor(int paramInt)
  {
    AppMethodBeat.i(213558);
    this.RG = paramInt;
    invalidate();
    AppMethodBeat.o(213558);
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    AppMethodBeat.i(213590);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.core.content.a.m(getContext(), paramInt);; localDrawable = null)
    {
      this.Hl = localDrawable;
      invalidate();
      AppMethodBeat.o(213590);
      return;
    }
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(213588);
    this.Hl = paramDrawable;
    invalidate();
    AppMethodBeat.o(213588);
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(213591);
    this.Hl = new ColorDrawable(paramInt);
    invalidate();
    AppMethodBeat.o(213591);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    float Sj;
    boolean Sk;
    int Sl;
    public int ek;
    
    public LayoutParams()
    {
      super(-1);
      this.ek = 0;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(213506);
      this.ek = 0;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
      this.ek = paramContext.getInt(0, 0);
      paramContext.recycle();
      AppMethodBeat.o(213506);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.ek = 0;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.ek = 0;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.ek = 0;
      this.ek = paramLayoutParams.ek;
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int Sm;
    int Sn;
    int So;
    int Sp;
    int Sq;
    
    static
    {
      AppMethodBeat.i(213521);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(213521);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(213516);
      this.Sm = 0;
      this.Sm = paramParcel.readInt();
      this.Sn = paramParcel.readInt();
      this.So = paramParcel.readInt();
      this.Sp = paramParcel.readInt();
      this.Sq = paramParcel.readInt();
      AppMethodBeat.o(213516);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
      this.Sm = 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(213520);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Sm);
      paramParcel.writeInt(this.Sn);
      paramParcel.writeInt(this.So);
      paramParcel.writeInt(this.Sp);
      paramParcel.writeInt(this.Sq);
      AppMethodBeat.o(213520);
    }
  }
  
  final class a
    extends androidx.core.g.a
  {
    private final Rect Si;
    
    a()
    {
      AppMethodBeat.i(213484);
      this.Si = new Rect();
      AppMethodBeat.o(213484);
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(213496);
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getText();
        paramView = DrawerLayout.this.hQ();
        int i;
        if (paramView != null)
        {
          i = DrawerLayout.this.aF(paramView);
          paramView = DrawerLayout.this;
          i = e.D(i, w.I(paramView));
          if (i != 3) {
            break label83;
          }
          paramView = paramView.RX;
        }
        for (;;)
        {
          if (paramView != null) {
            paramAccessibilityEvent.add(paramView);
          }
          AppMethodBeat.o(213496);
          return true;
          label83:
          if (i == 5) {
            paramView = paramView.RY;
          } else {
            paramView = null;
          }
        }
      }
      boolean bool = super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(213496);
      return bool;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(213492);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
      AppMethodBeat.o(213492);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      AppMethodBeat.i(213489);
      if (DrawerLayout.RB) {
        super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      }
      for (;;)
      {
        paramd.t(DrawerLayout.class.getName());
        paramd.setFocusable(false);
        paramd.Y(false);
        paramd.b(d.a.Oz);
        paramd.b(d.a.OA);
        AppMethodBeat.o(213489);
        return;
        Object localObject1 = d.a(paramd);
        super.onInitializeAccessibilityNodeInfo(paramView, (d)localObject1);
        paramd.ax(paramView);
        Object localObject2 = w.J(paramView);
        if ((localObject2 instanceof View)) {
          paramd.setParent((View)localObject2);
        }
        localObject2 = this.Si;
        ((d)localObject1).e((Rect)localObject2);
        paramd.f((Rect)localObject2);
        ((d)localObject1).g((Rect)localObject2);
        paramd.h((Rect)localObject2);
        paramd.Z(((d)localObject1).hs());
        paramd.s(((d)localObject1).Ov.getPackageName());
        paramd.t(((d)localObject1).Ov.getClassName());
        paramd.setContentDescription(((d)localObject1).Ov.getContentDescription());
        paramd.setEnabled(((d)localObject1).Ov.isEnabled());
        paramd.setClickable(((d)localObject1).Ov.isClickable());
        paramd.setFocusable(((d)localObject1).Ov.isFocusable());
        paramd.Y(((d)localObject1).Ov.isFocused());
        paramd.aa(((d)localObject1).ht());
        paramd.setSelected(((d)localObject1).Ov.isSelected());
        paramd.setLongClickable(((d)localObject1).Ov.isLongClickable());
        paramd.bA(((d)localObject1).Ov.getActions());
        ((d)localObject1).Ov.recycle();
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject1 = paramView.getChildAt(i);
          if (DrawerLayout.aK((View)localObject1)) {
            paramd.ay((View)localObject1);
          }
          i += 1;
        }
      }
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(213498);
      if ((DrawerLayout.RB) || (DrawerLayout.aK(paramView)))
      {
        boolean bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
        AppMethodBeat.o(213498);
        return bool;
      }
      AppMethodBeat.o(213498);
      return false;
    }
  }
  
  static final class b
    extends androidx.core.g.a
  {
    public final void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      AppMethodBeat.i(213502);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      if (!DrawerLayout.aK(paramView)) {
        paramd.setParent(null);
      }
      AppMethodBeat.o(213502);
    }
  }
  
  public static abstract interface c {}
  
  final class d
    extends c.a
  {
    final int Sr;
    c Ss;
    private final Runnable St;
    
    d(int paramInt)
    {
      AppMethodBeat.i(213527);
      this.St = new Runnable()
      {
        public final void run()
        {
          int k = 0;
          AppMethodBeat.i(213525);
          Object localObject2 = DrawerLayout.d.this;
          int m = ((DrawerLayout.d)localObject2).Ss.Rs;
          int i;
          Object localObject1;
          int j;
          if (((DrawerLayout.d)localObject2).Sr == 3)
          {
            i = 1;
            if (i == 0) {
              break label231;
            }
            localObject1 = ((DrawerLayout.d)localObject2).Sh.bT(3);
            if (localObject1 == null) {
              break label226;
            }
            j = -((View)localObject1).getWidth();
            label61:
            j += m;
          }
          for (;;)
          {
            label66:
            if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (((DrawerLayout.d)localObject2).Sh.aD((View)localObject1) == 0))))
            {
              DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
              ((DrawerLayout.d)localObject2).Ss.f((View)localObject1, j, ((View)localObject1).getTop());
              localLayoutParams.Sk = true;
              ((DrawerLayout.d)localObject2).Sh.invalidate();
              ((DrawerLayout.d)localObject2).hR();
              localObject1 = ((DrawerLayout.d)localObject2).Sh;
              if (!((DrawerLayout)localObject1).RT)
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
                    label226:
                    j = 0;
                    break label61;
                    label231:
                    localObject1 = ((DrawerLayout.d)localObject2).Sh.bT(5);
                    j = ((DrawerLayout.d)localObject2).Sh.getWidth() - m;
                    break label66;
                  }
                }
                ((MotionEvent)localObject2).recycle();
                ((DrawerLayout)localObject1).RT = true;
              }
            }
          }
          AppMethodBeat.o(213525);
        }
      };
      this.Sr = paramInt;
      AppMethodBeat.o(213527);
    }
    
    public final void G(int paramInt)
    {
      AppMethodBeat.i(213533);
      DrawerLayout localDrawerLayout = DrawerLayout.this;
      View localView = this.Ss.Rv;
      int i = localDrawerLayout.RJ.Rh;
      int j = localDrawerLayout.RK.Rh;
      if ((i == 1) || (j == 1)) {
        i = 1;
      }
      DrawerLayout.LayoutParams localLayoutParams;
      while ((localView != null) && (paramInt == 0))
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.Sj != 0.0F) {
          break label264;
        }
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.Sl & 0x1) == 1)
        {
          localLayoutParams.Sl = 0;
          if (localDrawerLayout.mListeners != null)
          {
            paramInt = localDrawerLayout.mListeners.size() - 1;
            for (;;)
            {
              if (paramInt >= 0)
              {
                localDrawerLayout.mListeners.get(paramInt);
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
          localDrawerLayout.d(localView, false);
          if (localDrawerLayout.hasWindowFocus())
          {
            localView = localDrawerLayout.getRootView();
            if (localView != null) {
              localView.sendAccessibilityEvent(32);
            }
          }
        }
      }
      while (i != localDrawerLayout.RN)
      {
        localDrawerLayout.RN = i;
        if (localDrawerLayout.mListeners == null) {
          break;
        }
        paramInt = localDrawerLayout.mListeners.size() - 1;
        while (paramInt >= 0)
        {
          localDrawerLayout.mListeners.get(paramInt);
          paramInt -= 1;
        }
        label264:
        if (localLayoutParams.Sj == 1.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((localLayoutParams.Sl & 0x1) == 0)
          {
            localLayoutParams.Sl = 1;
            if (localDrawerLayout.mListeners != null)
            {
              paramInt = localDrawerLayout.mListeners.size() - 1;
              while (paramInt >= 0)
              {
                localDrawerLayout.mListeners.get(paramInt);
                paramInt -= 1;
              }
            }
            localDrawerLayout.d(localView, true);
            if (localDrawerLayout.hasWindowFocus()) {
              localDrawerLayout.sendAccessibilityEvent(32);
            }
          }
        }
      }
      AppMethodBeat.o(213533);
    }
    
    public final void L(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(213540);
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = DrawerLayout.this.bT(3);; localView = DrawerLayout.this.bT(5))
      {
        if ((localView != null) && (DrawerLayout.this.aD(localView) == 0)) {
          this.Ss.x(localView, paramInt2);
        }
        AppMethodBeat.o(213540);
        return;
      }
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(213537);
      paramFloat2 = DrawerLayout.aE(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.A(paramView, 3)) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
          i = 0;
        }
      }
      for (;;)
      {
        this.Ss.I(i, paramView.getTop());
        DrawerLayout.this.invalidate();
        AppMethodBeat.o(213537);
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
      AppMethodBeat.i(213534);
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.A(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        DrawerLayout.this.m(paramView, f);
        if (f != 0.0F) {
          break label86;
        }
      }
      label86:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        paramView.setVisibility(paramInt1);
        DrawerLayout.this.invalidate();
        AppMethodBeat.o(213534);
        return;
        f = (DrawerLayout.this.getWidth() - paramInt1) / paramInt2;
        break;
      }
    }
    
    public final int aC(View paramView)
    {
      AppMethodBeat.i(213541);
      if (DrawerLayout.aH(paramView))
      {
        int i = paramView.getWidth();
        AppMethodBeat.o(213541);
        return i;
      }
      AppMethodBeat.o(213541);
      return 0;
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      AppMethodBeat.i(213531);
      if ((DrawerLayout.aH(paramView)) && (DrawerLayout.this.A(paramView, this.Sr)) && (DrawerLayout.this.aD(paramView) == 0))
      {
        AppMethodBeat.o(213531);
        return true;
      }
      AppMethodBeat.o(213531);
      return false;
    }
    
    public final int c(View paramView, int paramInt)
    {
      AppMethodBeat.i(213547);
      paramInt = paramView.getTop();
      AppMethodBeat.o(213547);
      return paramInt;
    }
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(213544);
      if (DrawerLayout.this.A(paramView, 3))
      {
        paramInt = Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
        AppMethodBeat.o(213544);
        return paramInt;
      }
      int i = DrawerLayout.this.getWidth();
      paramInt = Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
      AppMethodBeat.o(213544);
      return paramInt;
    }
    
    public final void hC()
    {
      AppMethodBeat.i(213530);
      DrawerLayout.this.removeCallbacks(this.St);
      AppMethodBeat.o(213530);
    }
    
    public final void hO()
    {
      AppMethodBeat.i(213539);
      DrawerLayout.this.postDelayed(this.St, 160L);
      AppMethodBeat.o(213539);
    }
    
    final void hR()
    {
      int i = 3;
      AppMethodBeat.i(213536);
      if (this.Sr == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.bT(i);
      if (localView != null) {
        DrawerLayout.this.aJ(localView);
      }
      AppMethodBeat.o(213536);
    }
    
    public final void z(View paramView, int paramInt)
    {
      AppMethodBeat.i(213535);
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).Sk = false;
      hR();
      AppMethodBeat.o(213535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.drawerlayout.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */