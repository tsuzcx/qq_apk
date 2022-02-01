package androidx.drawerlayout.widget;

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
import androidx.core.g.a.d;
import androidx.core.g.a.d.a;
import androidx.core.g.e;
import androidx.core.g.z;
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
  private static final int[] bxR;
  static final boolean bxS;
  private static final boolean bxT;
  private Paint bnd;
  boolean bnl;
  private Drawable bnm;
  private final b bxU;
  private float bxV;
  private int bxW;
  private int bxX;
  private float bxY;
  final c bxZ;
  final c bya;
  private final d byb;
  private final d byc;
  int byd;
  private int bye;
  private int byf;
  private int byg;
  private int byh;
  private boolean byi;
  boolean byj;
  private c byk;
  private Drawable byl;
  private Drawable bym;
  CharSequence byn;
  CharSequence byo;
  Object byp;
  private Drawable byq;
  private Drawable byr;
  private Drawable bys;
  private Drawable byt;
  private final ArrayList<View> byu;
  private Rect byv;
  private Matrix byw;
  private boolean mFirstLayout;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  List<c> mListeners;
  
  static
  {
    boolean bool2 = true;
    bxR = new int[] { 16843828 };
    LAYOUT_ATTRS = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      bxS = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bxT = bool1;
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
    AppMethodBeat.i(192902);
    this.bxU = new b();
    this.bxX = -1728053248;
    this.bnd = new Paint();
    this.mFirstLayout = true;
    this.bye = 3;
    this.byf = 3;
    this.byg = 3;
    this.byh = 3;
    this.byq = null;
    this.byr = null;
    this.bys = null;
    this.byt = null;
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.bxW = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.byb = new d(3);
    this.byc = new d(5);
    this.bxZ = c.a(this, 1.0F, this.byb);
    this.bxZ.bxK = 1;
    this.bxZ.bxI = f2;
    this.byb.byI = this.bxZ;
    this.bya = c.a(this, 1.0F, this.byc);
    this.bya.bxK = 2;
    this.bya.bxI = f2;
    this.byc.byI = this.bya;
    setFocusableInTouchMode(true);
    z.p(this, 1);
    z.a(this, new a());
    setMotionEventSplittingEnabled(false);
    if (z.al(this))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label351;
      }
      setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          boolean bool2 = true;
          AppMethodBeat.i(192865);
          paramAnonymousView = (DrawerLayout)paramAnonymousView;
          if (paramAnonymousWindowInsets.getSystemWindowInsetTop() > 0)
          {
            bool1 = true;
            paramAnonymousView.byp = paramAnonymousWindowInsets;
            paramAnonymousView.bnl = bool1;
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
            AppMethodBeat.o(192865);
            return paramAnonymousView;
            bool1 = false;
            break;
          }
        }
      });
      setSystemUiVisibility(1280);
      paramContext = paramContext.obtainStyledAttributes(bxR);
    }
    for (;;)
    {
      try
      {
        this.bnm = paramContext.getDrawable(0);
        paramContext.recycle();
        this.bxV = (f1 * 10.0F);
        this.byu = new ArrayList();
        AppMethodBeat.o(192902);
        return;
      }
      finally
      {
        paramContext.recycle();
        AppMethodBeat.o(192902);
      }
      label351:
      this.bnm = null;
    }
  }
  
  private View FB()
  {
    AppMethodBeat.i(192926);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).byB & 0x1) == 1)
      {
        AppMethodBeat.o(192926);
        return localView;
      }
      i += 1;
    }
    AppMethodBeat.o(192926);
    return null;
  }
  
  private void aH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192910);
    int i = e.ay(paramInt2, z.U(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.bxZ;
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
      AppMethodBeat.o(192910);
      return;
      this.bye = paramInt1;
      break;
      this.byf = paramInt1;
      break;
      this.byg = paramInt1;
      break;
      this.byh = paramInt1;
      break;
      localObject = this.bya;
      break label75;
      localObject = eO(i);
      if (localObject != null)
      {
        aW((View)localObject);
        AppMethodBeat.o(192910);
        return;
        localObject = eO(i);
        if (localObject != null) {
          aX((View)localObject);
        }
      }
    }
  }
  
  private void aO(boolean paramBoolean)
  {
    AppMethodBeat.i(192961);
    int m = getChildCount();
    int j = 0;
    int i = 0;
    if (j < m)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      boolean bool = i;
      int k;
      if (aV(localView)) {
        if (paramBoolean)
        {
          bool = i;
          if (!localLayoutParams.byA) {}
        }
        else
        {
          k = localView.getWidth();
          if (!E(localView, 3)) {
            break label121;
          }
          i |= this.bxZ.f(localView, -k, localView.getTop());
        }
      }
      for (;;)
      {
        localLayoutParams.byA = false;
        k = i;
        j += 1;
        i = k;
        break;
        label121:
        i |= this.bya.f(localView, getWidth(), localView.getTop());
      }
    }
    this.byb.Fg();
    this.byc.Fg();
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(192961);
  }
  
  static float aS(View paramView)
  {
    AppMethodBeat.i(192917);
    float f = ((LayoutParams)paramView.getLayoutParams()).byz;
    AppMethodBeat.o(192917);
    return f;
  }
  
  private static boolean aU(View paramView)
  {
    AppMethodBeat.i(192945);
    if (((LayoutParams)paramView.getLayoutParams()).fl == 0)
    {
      AppMethodBeat.o(192945);
      return true;
    }
    AppMethodBeat.o(192945);
    return false;
  }
  
  static boolean aV(View paramView)
  {
    AppMethodBeat.i(192953);
    int i = e.ay(((LayoutParams)paramView.getLayoutParams()).fl, z.U(paramView));
    if ((i & 0x3) != 0)
    {
      AppMethodBeat.o(192953);
      return true;
    }
    if ((i & 0x5) != 0)
    {
      AppMethodBeat.o(192953);
      return true;
    }
    AppMethodBeat.o(192953);
    return false;
  }
  
  private void aW(View paramView)
  {
    AppMethodBeat.i(192973);
    if (!aV(paramView))
    {
      paramView = new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
      AppMethodBeat.o(192973);
      throw paramView;
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.byz = 1.0F;
      localLayoutParams.byB = 1;
      d(paramView, true);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(192973);
      return;
      localLayoutParams.byB |= 0x2;
      if (E(paramView, 3)) {
        this.bxZ.f(paramView, 0, paramView.getTop());
      } else {
        this.bya.f(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  static boolean aY(View paramView)
  {
    AppMethodBeat.i(192982);
    if ((z.R(paramView) != 4) && (z.R(paramView) != 2))
    {
      AppMethodBeat.o(192982);
      return true;
    }
    AppMethodBeat.o(192982);
    return false;
  }
  
  private static boolean c(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(192935);
    if ((paramDrawable == null) || (!androidx.core.graphics.drawable.a.n(paramDrawable)))
    {
      AppMethodBeat.o(192935);
      return false;
    }
    androidx.core.graphics.drawable.a.b(paramDrawable, paramInt);
    AppMethodBeat.o(192935);
    return true;
  }
  
  final boolean E(View paramView, int paramInt)
  {
    AppMethodBeat.i(193079);
    if ((aT(paramView) & paramInt) == paramInt)
    {
      AppMethodBeat.o(193079);
      return true;
    }
    AppMethodBeat.o(193079);
    return false;
  }
  
  final View FC()
  {
    AppMethodBeat.i(193273);
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      Object localObject = getChildAt(i);
      if (aV((View)localObject))
      {
        if (!aV((View)localObject))
        {
          localObject = new IllegalArgumentException("View " + localObject + " is not a drawer");
          AppMethodBeat.o(193273);
          throw ((Throwable)localObject);
        }
        if (((LayoutParams)((View)localObject).getLayoutParams()).byz > 0.0F) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(193273);
          return localObject;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(193273);
    return null;
  }
  
  public final int aR(View paramView)
  {
    AppMethodBeat.i(193052);
    if (!aV(paramView))
    {
      paramView = new IllegalArgumentException("View " + paramView + " is not a drawer");
      AppMethodBeat.o(193052);
      throw paramView;
    }
    int i = ((LayoutParams)paramView.getLayoutParams()).fl;
    int j = z.U(this);
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(193052);
      return 0;
      if (this.bye != 3)
      {
        i = this.bye;
        AppMethodBeat.o(193052);
        return i;
      }
      if (j == 0) {}
      for (i = this.byg; i != 3; i = this.byh)
      {
        AppMethodBeat.o(193052);
        return i;
      }
      if (this.byf != 3)
      {
        i = this.byf;
        AppMethodBeat.o(193052);
        return i;
      }
      if (j == 0) {}
      for (i = this.byh; i != 3; i = this.byg)
      {
        AppMethodBeat.o(193052);
        return i;
      }
      if (this.byg != 3)
      {
        i = this.byg;
        AppMethodBeat.o(193052);
        return i;
      }
      if (j == 0) {}
      for (i = this.bye; i != 3; i = this.byf)
      {
        AppMethodBeat.o(193052);
        return i;
      }
      if (this.byh != 3)
      {
        i = this.byh;
        AppMethodBeat.o(193052);
        return i;
      }
      if (j == 0) {}
      for (i = this.byf; i != 3; i = this.bye)
      {
        AppMethodBeat.o(193052);
        return i;
      }
    }
  }
  
  final int aT(View paramView)
  {
    AppMethodBeat.i(193073);
    int i = e.ay(((LayoutParams)paramView.getLayoutParams()).fl, z.U(this));
    AppMethodBeat.o(193073);
    return i;
  }
  
  public final void aX(View paramView)
  {
    AppMethodBeat.i(193225);
    if (!aV(paramView))
    {
      paramView = new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
      AppMethodBeat.o(193225);
      throw paramView;
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.byz = 0.0F;
      localLayoutParams.byB = 0;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(193225);
      return;
      localLayoutParams.byB |= 0x4;
      if (E(paramView, 3)) {
        this.bxZ.f(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.bya.f(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193265);
    if (getDescendantFocusability() == 393216)
    {
      AppMethodBeat.o(193265);
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
      if (aV(localView))
      {
        if (!aV(localView))
        {
          paramArrayList = new IllegalArgumentException("View " + localView + " is not a drawer");
          AppMethodBeat.o(193265);
          throw paramArrayList;
        }
        if ((((LayoutParams)localView.getLayoutParams()).byB & 0x1) == 1)
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
        this.byu.add(localView);
      }
    }
    if (i == 0)
    {
      j = this.byu.size();
      i = 0;
      while (i < j)
      {
        localView = (View)this.byu.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.byu.clear();
    AppMethodBeat.o(193265);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(193323);
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((FB() != null) || (aV(paramView))) {
      z.p(paramView, 4);
    }
    for (;;)
    {
      if (!bxS) {
        z.a(paramView, this.bxU);
      }
      AppMethodBeat.o(193323);
      return;
      z.p(paramView, 1);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(193244);
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(193244);
      return true;
    }
    AppMethodBeat.o(193244);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(193141);
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, ((LayoutParams)getChildAt(i).getLayoutParams()).byz);
      i += 1;
    }
    this.bxY = f;
    boolean bool1 = this.bxZ.Fx();
    boolean bool2 = this.bya.Fx();
    if ((bool1) || (bool2)) {
      z.Q(this);
    }
    AppMethodBeat.o(193141);
  }
  
  final void d(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(193060);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!aV(localView))) || ((paramBoolean) && (localView == paramView))) {
        z.p(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        z.p(localView, 4);
      }
    }
    AppMethodBeat.o(193060);
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193202);
    boolean bool;
    if (((paramMotionEvent.getSource() & 0x2) == 0) || (paramMotionEvent.getAction() == 10) || (this.bxY <= 0.0F))
    {
      bool = super.dispatchGenericMotionEvent(paramMotionEvent);
      AppMethodBeat.o(193202);
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
        if (this.byv == null) {
          this.byv = new Rect();
        }
        localView.getHitRect(this.byv);
        if ((this.byv.contains((int)f1, (int)f2)) && (!aU(localView)))
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
              if (this.byw == null) {
                this.byw = new Matrix();
              }
              localMatrix.invert(this.byw);
              localMotionEvent.transform(this.byw);
            }
            bool = localView.dispatchGenericMotionEvent(localMotionEvent);
            localMotionEvent.recycle();
          }
          while (bool)
          {
            AppMethodBeat.o(193202);
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
    AppMethodBeat.o(193202);
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(193182);
    int i2 = getHeight();
    boolean bool1 = aU(paramView);
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
              if (aV(localView))
              {
                n = i;
                i1 = j;
                if (localView.getHeight() >= i2)
                {
                  if (!E(localView, 3)) {
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
      if ((this.bxY > 0.0F) && (bool1))
      {
        j = (int)(((this.bxX & 0xFF000000) >>> 24) * this.bxY);
        m = this.bxX;
        this.bnd.setColor(j << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(i, 0.0F, k, getHeight(), this.bnd);
      }
      for (;;)
      {
        AppMethodBeat.o(193182);
        return bool2;
        float f;
        if ((this.byl != null) && (E(paramView, 3)))
        {
          i = this.byl.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.bxZ.bxJ;
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.byl.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.byl.setAlpha((int)(255.0F * f));
          this.byl.draw(paramCanvas);
        }
        else if ((this.bym != null) && (E(paramView, 5)))
        {
          i = this.bym.getIntrinsicWidth();
          j = paramView.getLeft();
          k = getWidth();
          m = this.bya.bxJ;
          f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
          this.bym.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
          this.bym.setAlpha((int)(255.0F * f));
          this.bym.draw(paramCanvas);
        }
      }
    }
  }
  
  final View eO(int paramInt)
  {
    AppMethodBeat.i(193086);
    int i = e.ay(paramInt, z.U(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((aT(localView) & 0x7) == (i & 0x7))
      {
        AppMethodBeat.o(193086);
        return localView;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(193086);
    return null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(193232);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(193232);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(193253);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(193253);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(193239);
    if ((paramLayoutParams instanceof LayoutParams))
    {
      paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      AppMethodBeat.o(193239);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(193239);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(193239);
    return paramLayoutParams;
  }
  
  public float getDrawerElevation()
  {
    if (bxT) {
      return this.bxV;
    }
    return 0.0F;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.bnm;
  }
  
  final void n(View paramView, float paramFloat)
  {
    AppMethodBeat.i(193066);
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == paramView.byz)
    {
      AppMethodBeat.o(193066);
      return;
    }
    paramView.byz = paramFloat;
    if (this.mListeners != null)
    {
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        this.mListeners.get(i);
        i -= 1;
      }
    }
    AppMethodBeat.o(193066);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(193103);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(193103);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(193096);
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(193096);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(193169);
    super.onDraw(paramCanvas);
    int i;
    if ((this.bnl) && (this.bnm != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label89;
      }
      if (this.byp == null) {
        break label84;
      }
      i = ((WindowInsets)this.byp).getSystemWindowInsetTop();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.bnm.setBounds(0, 0, getWidth(), i);
        this.bnm.draw(paramCanvas);
      }
      AppMethodBeat.o(193169);
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
    AppMethodBeat.i(193194);
    int i = paramMotionEvent.getActionMasked();
    boolean bool1 = this.bxZ.i(paramMotionEvent);
    boolean bool2 = this.bya.i(paramMotionEvent);
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
        if (((LayoutParams)getChildAt(i).getLayoutParams()).byA)
        {
          i = 1;
          if ((i == 0) && (!this.byj)) {
            break label385;
          }
        }
      }
      else
      {
        AppMethodBeat.o(193194);
        return true;
      }
      break;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if (this.bxY > 0.0F)
      {
        paramMotionEvent = this.bxZ.aF((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!aU(paramMotionEvent))) {}
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      this.byi = false;
      this.byj = false;
      break label67;
      paramMotionEvent = this.bxZ;
      int k = paramMotionEvent.bxz.length;
      j = 0;
      label220:
      if (j < k) {
        if (paramMotionEvent.eL(j))
        {
          f1 = paramMotionEvent.bxB[j] - paramMotionEvent.bxz[j];
          f2 = paramMotionEvent.bxC[j] - paramMotionEvent.bxA[j];
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
        this.byb.Fg();
        this.byc.Fg();
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
      aO(true);
      this.byi = false;
      this.byj = false;
      break;
      i += 1;
      break label89;
      label379:
      i = 0;
      break label117;
      label385:
      AppMethodBeat.o(193194);
      return false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193279);
    if (paramInt == 4)
    {
      if (FC() != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramKeyEvent.startTracking();
        AppMethodBeat.o(193279);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(193279);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193287);
    if (paramInt == 4)
    {
      paramKeyEvent = FC();
      if ((paramKeyEvent != null) && (aR(paramKeyEvent) == 0)) {
        aO(false);
      }
      if (paramKeyEvent != null)
      {
        AppMethodBeat.o(193287);
        return true;
      }
      AppMethodBeat.o(193287);
      return false;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(193287);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193127);
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
        if (aU(localView)) {
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
      if (E(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * localLayoutParams.byz) + paramInt1;
        f = (i1 + i) / i1;
        if (f == localLayoutParams.byz) {
          break label314;
        }
        j = 1;
        label183:
        switch (localLayoutParams.fl & 0x70)
        {
        default: 
          localView.layout(i, localLayoutParams.topMargin, i1 + i, i2 + localLayoutParams.topMargin);
          label241:
          if (j != 0) {
            n(localView, f);
          }
          if (localLayoutParams.byz <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localLayoutParams.byz);
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
    AppMethodBeat.o(193127);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193115);
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
      if ((this.byp != null) && (z.al(this)))
      {
        n = 1;
        int i4 = z.U(this);
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
            i2 = e.ay(localLayoutParams.fl, i4);
            if (!z.al(localView)) {
              break label412;
            }
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject2 = (WindowInsets)this.byp;
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
        if (aU(localView))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(m - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
          i3 = i;
          i2 = j;
          i1 += 1;
          j = i2;
          i = i3;
          break label152;
          localObject1 = new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
          AppMethodBeat.o(193115);
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
            localObject2 = (WindowInsets)this.byp;
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
      if (aV(localView))
      {
        if ((bxT) && (z.ag(localView) != this.bxV)) {
          z.k(localView, this.bxV);
        }
        i3 = aT(localView) & 0x7;
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
          AppMethodBeat.o(193115);
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
          localView.measure(getChildMeasureSpec(paramInt1, this.bxW + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
          i2 = j;
          i3 = i;
          break;
          j = 1;
        }
      }
      Object localObject1 = new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
      AppMethodBeat.o(193115);
      throw ((Throwable)localObject1);
      label829:
      AppMethodBeat.o(193115);
      return;
      label836:
      k = m;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(193297);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(193297);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.bxs);
    if (paramParcelable.byC != 0)
    {
      View localView = eO(paramParcelable.byC);
      if (localView != null) {
        aW(localView);
      }
    }
    if (paramParcelable.byD != 3) {
      aH(paramParcelable.byD, 3);
    }
    if (paramParcelable.byE != 3) {
      aH(paramParcelable.byE, 5);
    }
    if (paramParcelable.byF != 3) {
      aH(paramParcelable.byF, 8388611);
    }
    if (paramParcelable.byG != 3) {
      aH(paramParcelable.byG, 8388613);
    }
    AppMethodBeat.o(193297);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    AppMethodBeat.i(193164);
    Drawable localDrawable;
    if (!bxT)
    {
      paramInt = z.U(this);
      if (paramInt != 0) {
        break label89;
      }
      if (this.byq == null) {
        break label113;
      }
      c(this.byq, paramInt);
      localDrawable = this.byq;
      this.byl = localDrawable;
      paramInt = z.U(this);
      if (paramInt != 0) {
        break label121;
      }
      if (this.byr == null) {
        break label145;
      }
      c(this.byr, paramInt);
      localDrawable = this.byr;
    }
    label145:
    for (;;)
    {
      this.bym = localDrawable;
      AppMethodBeat.o(193164);
      return;
      label89:
      if (this.byr != null)
      {
        c(this.byr, paramInt);
        localDrawable = this.byr;
        break;
      }
      label113:
      localDrawable = this.bys;
      break;
      label121:
      if (this.byq != null)
      {
        c(this.byq, paramInt);
        localDrawable = this.byq;
      }
      else
      {
        localDrawable = this.byt;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(193313);
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
        if (localLayoutParams.byB != 1) {
          break label131;
        }
        j = 1;
        if (localLayoutParams.byB != 2) {
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
        localSavedState.byC = localLayoutParams.fl;
        localSavedState.byD = this.bye;
        localSavedState.byE = this.byf;
        localSavedState.byF = this.byg;
        localSavedState.byG = this.byh;
        AppMethodBeat.o(193313);
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
    AppMethodBeat.i(193209);
    this.bxZ.j(paramMotionEvent);
    this.bya.j(paramMotionEvent);
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
        AppMethodBeat.o(193209);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        this.byi = false;
        this.byj = false;
      }
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.bxZ.aF((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (aU(paramMotionEvent)))
      {
        f2 -= this.mInitialMotionX;
        f1 -= this.mInitialMotionY;
        int i = this.bxZ.mTouchSlop;
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = FB();
          if (paramMotionEvent != null) {
            if (aR(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      aO(bool);
      this.byi = false;
      break;
      bool = false;
      continue;
      aO(true);
      this.byi = false;
      this.byj = false;
      break;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(193217);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.byi = paramBoolean;
    if (paramBoolean) {
      aO(true);
    }
    AppMethodBeat.o(193217);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(193135);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(193135);
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    AppMethodBeat.i(193010);
    this.bxV = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (aV(localView)) {
        z.k(localView, this.bxV);
      }
      i += 1;
    }
    AppMethodBeat.o(193010);
  }
  
  @Deprecated
  public void setDrawerListener(c paramc)
  {
    AppMethodBeat.i(193037);
    if (this.byk != null)
    {
      c localc = this.byk;
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
    this.byk = paramc;
    AppMethodBeat.o(193037);
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    AppMethodBeat.i(193044);
    aH(paramInt, 3);
    aH(paramInt, 5);
    AppMethodBeat.o(193044);
  }
  
  public void setScrimColor(int paramInt)
  {
    AppMethodBeat.i(193029);
    this.bxX = paramInt;
    invalidate();
    AppMethodBeat.o(193029);
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    AppMethodBeat.i(193154);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.core.content.a.m(getContext(), paramInt);; localDrawable = null)
    {
      this.bnm = localDrawable;
      invalidate();
      AppMethodBeat.o(193154);
      return;
    }
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(193147);
    this.bnm = paramDrawable;
    invalidate();
    AppMethodBeat.o(193147);
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(193159);
    this.bnm = new ColorDrawable(paramInt);
    invalidate();
    AppMethodBeat.o(193159);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    boolean byA;
    int byB;
    float byz;
    public int fl;
    
    public LayoutParams()
    {
      super(-1);
      this.fl = 0;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(192879);
      this.fl = 0;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
      this.fl = paramContext.getInt(0, 0);
      paramContext.recycle();
      AppMethodBeat.o(192879);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.fl = 0;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.fl = 0;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.fl = 0;
      this.fl = paramLayoutParams.fl;
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int byC;
    int byD;
    int byE;
    int byF;
    int byG;
    
    static
    {
      AppMethodBeat.i(192884);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(192884);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(192863);
      this.byC = 0;
      this.byC = paramParcel.readInt();
      this.byD = paramParcel.readInt();
      this.byE = paramParcel.readInt();
      this.byF = paramParcel.readInt();
      this.byG = paramParcel.readInt();
      AppMethodBeat.o(192863);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
      this.byC = 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(192897);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.byC);
      paramParcel.writeInt(this.byD);
      paramParcel.writeInt(this.byE);
      paramParcel.writeInt(this.byF);
      paramParcel.writeInt(this.byG);
      AppMethodBeat.o(192897);
    }
  }
  
  final class a
    extends androidx.core.g.a
  {
    private final Rect byy;
    
    a()
    {
      AppMethodBeat.i(192877);
      this.byy = new Rect();
      AppMethodBeat.o(192877);
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(192901);
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getText();
        paramView = DrawerLayout.this.FC();
        int i;
        if (paramView != null)
        {
          i = DrawerLayout.this.aT(paramView);
          paramView = DrawerLayout.this;
          i = e.ay(i, z.U(paramView));
          if (i != 3) {
            break label83;
          }
          paramView = paramView.byn;
        }
        for (;;)
        {
          if (paramView != null) {
            paramAccessibilityEvent.add(paramView);
          }
          AppMethodBeat.o(192901);
          return true;
          label83:
          if (i == 5) {
            paramView = paramView.byo;
          } else {
            paramView = null;
          }
        }
      }
      boolean bool = super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(192901);
      return bool;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(192893);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
      AppMethodBeat.o(192893);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      AppMethodBeat.i(192887);
      if (DrawerLayout.bxS) {
        super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      }
      for (;;)
      {
        paramd.v(DrawerLayout.class.getName());
        paramd.setFocusable(false);
        paramd.aE(false);
        paramd.b(d.a.buS);
        paramd.b(d.a.buT);
        AppMethodBeat.o(192887);
        return;
        Object localObject1 = d.a(paramd);
        super.onInitializeAccessibilityNodeInfo(paramView, (d)localObject1);
        paramd.aL(paramView);
        Object localObject2 = z.V(paramView);
        if ((localObject2 instanceof View)) {
          paramd.setParent((View)localObject2);
        }
        localObject2 = this.byy;
        ((d)localObject1).j((Rect)localObject2);
        paramd.k((Rect)localObject2);
        ((d)localObject1).l((Rect)localObject2);
        paramd.m((Rect)localObject2);
        paramd.aF(((d)localObject1).EL());
        paramd.u(((d)localObject1).EQ());
        paramd.v(((d)localObject1).ER());
        paramd.setContentDescription(((d)localObject1).getContentDescription());
        paramd.setEnabled(((d)localObject1).isEnabled());
        paramd.setClickable(((d)localObject1).isClickable());
        paramd.setFocusable(((d)localObject1).isFocusable());
        paramd.aE(((d)localObject1).isFocused());
        paramd.aG(((d)localObject1).EM());
        paramd.setSelected(((d)localObject1).isSelected());
        paramd.setLongClickable(((d)localObject1).EN());
        paramd.eu(((d)localObject1).EJ());
        ((d)localObject1).recycle();
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject1 = paramView.getChildAt(i);
          if (DrawerLayout.aY((View)localObject1)) {
            paramd.aM((View)localObject1);
          }
          i += 1;
        }
      }
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(192908);
      if ((DrawerLayout.bxS) || (DrawerLayout.aY(paramView)))
      {
        boolean bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
        AppMethodBeat.o(192908);
        return bool;
      }
      AppMethodBeat.o(192908);
      return false;
    }
  }
  
  static final class b
    extends androidx.core.g.a
  {
    public final void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      AppMethodBeat.i(192881);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      if (!DrawerLayout.aY(paramView)) {
        paramd.setParent(null);
      }
      AppMethodBeat.o(192881);
    }
  }
  
  public static abstract interface c {}
  
  final class d
    extends c.a
  {
    final int byH;
    c byI;
    private final Runnable byJ;
    
    d(int paramInt)
    {
      AppMethodBeat.i(192867);
      this.byJ = new Runnable()
      {
        public final void run()
        {
          int k = 0;
          AppMethodBeat.i(192898);
          Object localObject2 = DrawerLayout.d.this;
          int m = ((DrawerLayout.d)localObject2).byI.bxJ;
          int i;
          Object localObject1;
          int j;
          if (((DrawerLayout.d)localObject2).byH == 3)
          {
            i = 1;
            if (i == 0) {
              break label231;
            }
            localObject1 = ((DrawerLayout.d)localObject2).byx.eO(3);
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
            if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (((DrawerLayout.d)localObject2).byx.aR((View)localObject1) == 0))))
            {
              DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
              ((DrawerLayout.d)localObject2).byI.f((View)localObject1, j, ((View)localObject1).getTop());
              localLayoutParams.byA = true;
              ((DrawerLayout.d)localObject2).byx.invalidate();
              ((DrawerLayout.d)localObject2).FD();
              localObject1 = ((DrawerLayout.d)localObject2).byx;
              if (!((DrawerLayout)localObject1).byj)
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
                    localObject1 = ((DrawerLayout.d)localObject2).byx.eO(5);
                    j = ((DrawerLayout.d)localObject2).byx.getWidth() - m;
                    break label66;
                  }
                }
                ((MotionEvent)localObject2).recycle();
                ((DrawerLayout)localObject1).byj = true;
              }
            }
          }
          AppMethodBeat.o(192898);
        }
      };
      this.byH = paramInt;
      AppMethodBeat.o(192867);
    }
    
    public final void D(View paramView, int paramInt)
    {
      AppMethodBeat.i(192909);
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).byA = false;
      FD();
      AppMethodBeat.o(192909);
    }
    
    public final void F(int paramInt)
    {
      AppMethodBeat.i(192894);
      DrawerLayout localDrawerLayout = DrawerLayout.this;
      View localView = this.byI.bxM;
      int i = localDrawerLayout.bxZ.bxy;
      int j = localDrawerLayout.bya.bxy;
      if ((i == 1) || (j == 1)) {
        i = 1;
      }
      DrawerLayout.LayoutParams localLayoutParams;
      while ((localView != null) && (paramInt == 0))
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.byz != 0.0F) {
          break label264;
        }
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.byB & 0x1) == 1)
        {
          localLayoutParams.byB = 0;
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
      while (i != localDrawerLayout.byd)
      {
        localDrawerLayout.byd = i;
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
        if (localLayoutParams.byz == 1.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((localLayoutParams.byB & 0x1) == 0)
          {
            localLayoutParams.byB = 1;
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
      AppMethodBeat.o(192894);
    }
    
    public final boolean FA()
    {
      return false;
    }
    
    final void FD()
    {
      int i = 3;
      AppMethodBeat.i(192918);
      if (this.byH == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.eO(i);
      if (localView != null) {
        DrawerLayout.this.aX(localView);
      }
      AppMethodBeat.o(192918);
    }
    
    public final void Fg()
    {
      AppMethodBeat.i(192876);
      DrawerLayout.this.removeCallbacks(this.byJ);
      AppMethodBeat.o(192876);
    }
    
    public final void Fz()
    {
      AppMethodBeat.i(192936);
      DrawerLayout.this.postDelayed(this.byJ, 160L);
      AppMethodBeat.o(192936);
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192904);
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.E(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        DrawerLayout.this.n(paramView, f);
        if (f != 0.0F) {
          break label86;
        }
      }
      label86:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        paramView.setVisibility(paramInt1);
        DrawerLayout.this.invalidate();
        AppMethodBeat.o(192904);
        return;
        f = (DrawerLayout.this.getWidth() - paramInt1) / paramInt2;
        break;
      }
    }
    
    public final void aG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192954);
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = DrawerLayout.this.eO(3);; localView = DrawerLayout.this.eO(5))
      {
        if ((localView != null) && (DrawerLayout.this.aR(localView) == 0)) {
          this.byI.B(localView, paramInt2);
        }
        AppMethodBeat.o(192954);
        return;
      }
    }
    
    public final int aQ(View paramView)
    {
      AppMethodBeat.i(192962);
      if (DrawerLayout.aV(paramView))
      {
        int i = paramView.getWidth();
        AppMethodBeat.o(192962);
        return i;
      }
      AppMethodBeat.o(192962);
      return 0;
    }
    
    public final void b(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(192927);
      paramFloat2 = DrawerLayout.aS(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.E(paramView, 3)) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
          i = 0;
        }
      }
      for (;;)
      {
        this.byI.aD(i, paramView.getTop());
        DrawerLayout.this.invalidate();
        AppMethodBeat.o(192927);
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
    
    public final boolean b(View paramView, int paramInt)
    {
      AppMethodBeat.i(192886);
      if ((DrawerLayout.aV(paramView)) && (DrawerLayout.this.E(paramView, this.byH)) && (DrawerLayout.this.aR(paramView) == 0))
      {
        AppMethodBeat.o(192886);
        return true;
      }
      AppMethodBeat.o(192886);
      return false;
    }
    
    public final int c(View paramView, int paramInt)
    {
      AppMethodBeat.i(192981);
      paramInt = paramView.getTop();
      AppMethodBeat.o(192981);
      return paramInt;
    }
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(192972);
      if (DrawerLayout.this.E(paramView, 3))
      {
        paramInt = Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
        AppMethodBeat.o(192972);
        return paramInt;
      }
      int i = DrawerLayout.this.getWidth();
      paramInt = Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
      AppMethodBeat.o(192972);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.drawerlayout.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */