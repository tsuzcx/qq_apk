package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.f.a;
import android.support.v4.f.l;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.h;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v7.e.a.a;
import android.support.v7.e.a.c;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements h
{
  private static final int[] afo = { 16843830 };
  private static final int[] afp = { 16842987 };
  static final boolean afq;
  static final boolean afr;
  static final boolean afs;
  private static final boolean aft;
  private static final boolean afu;
  private static final boolean afv;
  private static final Class<?>[] afw;
  static final Interpolator agI;
  private final int[] Lc;
  private final int[] Ld;
  a Sw;
  e afA;
  u afB;
  final be afC = new be();
  boolean afD;
  final Runnable afE = new RecyclerView.1(this);
  final RectF afF = new RectF();
  RecyclerView.i afG;
  RecyclerView.p afH;
  public final ArrayList<RecyclerView.h> afI = new ArrayList();
  private final ArrayList<RecyclerView.l> afJ = new ArrayList();
  private RecyclerView.l afK;
  boolean afL;
  boolean afM;
  boolean afN;
  boolean afO;
  private int afP = 0;
  boolean afQ;
  public boolean afR;
  private boolean afS;
  private int afT;
  boolean afU;
  public List<j> afV;
  boolean afW = false;
  boolean afX = false;
  private int afY = 0;
  private int afZ = 0;
  private final RecyclerView.q afx = new RecyclerView.q(this);
  final RecyclerView.o afy = new RecyclerView.o(this);
  private RecyclerView.SavedState afz;
  boolean agA;
  ak agB;
  private d agC;
  private final int[] agD;
  private android.support.v4.view.i agE;
  private final int[] agF;
  final List<RecyclerView.v> agG;
  private Runnable agH;
  private final be.b agJ;
  private RecyclerView.e aga = new RecyclerView.e();
  private EdgeEffect agb;
  private EdgeEffect agc;
  private EdgeEffect agd;
  private EdgeEffect age;
  RecyclerView.f agf = new x();
  private int agg = -1;
  private int agh;
  private int agi;
  private int agj;
  private int agk;
  private RecyclerView.k agl;
  private final int agm;
  private final int agn;
  private float ago = 1.4E-45F;
  private float agp = 1.4E-45F;
  private boolean agq = true;
  final RecyclerView.u agr = new RecyclerView.u(this);
  ad ags;
  ad.a agt;
  final RecyclerView.s agu;
  private RecyclerView.m agv;
  private List<RecyclerView.m> agw;
  boolean agx;
  boolean agy;
  private RecyclerView.f.b agz;
  private final AccessibilityManager eV;
  final Rect ec = new Rect();
  private VelocityTracker fB;
  private int jb;
  private final Rect jg = new Rect();
  private int lf = 0;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      afq = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label167;
      }
      bool = true;
      label62:
      afr = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label172;
      }
      bool = true;
      label76:
      afs = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label177;
      }
      bool = true;
      label90:
      aft = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label182;
      }
      bool = true;
      label104:
      afu = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label187;
      }
    }
    label167:
    label172:
    label177:
    label182:
    label187:
    for (boolean bool = true;; bool = false)
    {
      afv = bool;
      afw = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      agI = new RecyclerView.3();
      return;
      bool = false;
      break;
      bool = false;
      break label62;
      bool = false;
      break label76;
      bool = false;
      break label90;
      bool = false;
      break label104;
    }
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject1;
    if (aft)
    {
      localObject1 = new ad.a();
      this.agt = ((ad.a)localObject1);
      this.agu = new RecyclerView.s();
      this.agx = false;
      this.agy = false;
      this.agz = new RecyclerView.g(this);
      this.agA = false;
      this.agD = new int[2];
      this.Lc = new int[2];
      this.Ld = new int[2];
      this.agF = new int[2];
      this.agG = new ArrayList();
      this.agH = new RecyclerView.2(this);
      this.agJ = new RecyclerView.4(this);
      if (paramAttributeSet == null) {
        break label687;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, afp, paramInt, 0);
      this.afD = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
      label351:
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject1 = ViewConfiguration.get(paramContext);
      this.jb = ((ViewConfiguration)localObject1).getScaledTouchSlop();
      this.ago = r.a((ViewConfiguration)localObject1, paramContext);
      this.agp = r.b((ViewConfiguration)localObject1, paramContext);
      this.agm = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
      this.agn = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
      if (getOverScrollMode() != 2) {
        break label695;
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    StateListDrawable localStateListDrawable;
    Drawable localDrawable;
    label687:
    label695:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      this.agf.agN = this.agz;
      this.afA = new e(new RecyclerView.6(this));
      this.afB = new u(new RecyclerView.5(this));
      if (q.P(this) == 0) {
        q.n(this, 1);
      }
      this.eV = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new ak(this));
      if (paramAttributeSet == null) {
        break label1266;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.RecyclerView, paramInt, 0);
      localObject2 = ((TypedArray)localObject1).getString(a.c.RecyclerView_layoutManager);
      if (((TypedArray)localObject1).getInt(a.c.RecyclerView_android_descendantFocusability, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.afN = ((TypedArray)localObject1).getBoolean(a.c.RecyclerView_fastScrollEnabled, false);
      if (!this.afN) {
        break label751;
      }
      localObject3 = (StateListDrawable)((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollVerticalThumbDrawable);
      localObject4 = ((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollVerticalTrackDrawable);
      localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollHorizontalThumbDrawable);
      localDrawable = ((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollHorizontalTrackDrawable);
      if ((localObject3 != null) && (localObject4 != null) && (localStateListDrawable != null) && (localDrawable != null)) {
        break label701;
      }
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + hl());
      localObject1 = null;
      break;
      this.afD = true;
      break label351;
    }
    label701:
    Resources localResources = getContext().getResources();
    new aa(this, (StateListDrawable)localObject3, (Drawable)localObject4, localStateListDrawable, localDrawable, localResources.getDimensionPixelSize(a.a.fastscroll_default_thickness), localResources.getDimensionPixelSize(a.a.fastscroll_minimum_range), localResources.getDimensionPixelOffset(a.a.fastscroll_margin));
    label751:
    ((TypedArray)localObject1).recycle();
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).trim();
      if (!((String)localObject1).isEmpty())
      {
        if (((String)localObject1).charAt(0) != '.') {
          break label941;
        }
        localObject1 = paramContext.getPackageName() + (String)localObject1;
      }
    }
    for (;;)
    {
      try
      {
        if (isInEditMode())
        {
          localObject2 = getClass().getClassLoader();
          localObject4 = ((ClassLoader)localObject2).loadClass((String)localObject1).asSubclass(RecyclerView.i.class);
        }
        try
        {
          localObject3 = ((Class)localObject4).getConstructor(afw);
          localObject2 = new Object[4];
          localObject2[0] = paramContext;
          localObject2[1] = paramAttributeSet;
          localObject2[2] = Integer.valueOf(paramInt);
          localObject2[3] = Integer.valueOf(0);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          try
          {
            localObject3 = ((Class)localObject4).getConstructor(new Class[0]);
            localThrowable = null;
          }
          catch (NoSuchMethodException paramContext)
          {
            Throwable localThrowable;
            paramContext.initCause(localThrowable);
            throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Error creating LayoutManager " + (String)localObject1, paramContext);
          }
        }
        ((Constructor)localObject3).setAccessible(true);
        setLayoutManager((RecyclerView.i)((Constructor)localObject3).newInstance((Object[])localObject2));
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, afo, paramInt, 0);
          bool = paramContext.getBoolean(0, true);
          paramContext.recycle();
          setNestedScrollingEnabled(bool);
          return;
          label941:
          if (((String)localObject1).contains(".")) {
            continue;
          }
          localObject1 = RecyclerView.class.getPackage().getName() + '.' + (String)localObject1;
          continue;
          localObject2 = paramContext.getClassLoader();
          continue;
          setDescendantFocusability(262144);
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Unable to find LayoutManager " + (String)localObject1, paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + (String)localObject1, paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + (String)localObject1, paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Cannot access non-public constructor " + (String)localObject1, paramContext);
      }
      catch (ClassCastException paramContext)
      {
        throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Class is not a LayoutManager " + (String)localObject1, paramContext);
      }
      label1266:
      bool = true;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int n = 0;
    int k = 0;
    int i1 = 0;
    int m = 0;
    hn();
    if (this.Sw != null)
    {
      ho();
      hy();
      android.support.v4.os.f.beginSection("RV Scroll");
      m(this.agu);
      if (paramInt1 != 0)
      {
        j = this.afG.a(paramInt1, this.afy, this.agu);
        i = paramInt1 - j;
        if (paramInt2 != 0)
        {
          m = this.afG.b(paramInt2, this.afy, this.agu);
          k = paramInt2 - m;
        }
        android.support.v4.os.f.endSection();
        hN();
        ad(true);
        ac(false);
        n = m;
        m = k;
        k = n;
      }
    }
    for (;;)
    {
      if (!this.afI.isEmpty()) {
        invalidate();
      }
      if (a(j, k, i, m, this.Lc, 0))
      {
        this.agj -= this.Lc[0];
        this.agk -= this.Lc[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.Lc[0], this.Lc[1]);
        }
        paramMotionEvent = this.agF;
        paramMotionEvent[0] += this.Lc[0];
        paramMotionEvent = this.agF;
        paramMotionEvent[1] += this.Lc[1];
      }
      while (getOverScrollMode() == 2)
      {
        if ((j != 0) || (k != 0)) {
          ag(j, k);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((j == 0) && (k == 0)) {
          break;
        }
        return true;
      }
      label328:
      float f1;
      float f2;
      float f3;
      float f4;
      if (paramMotionEvent != null)
      {
        if ((paramMotionEvent.getSource() & 0x2002) != 8194) {
          break label468;
        }
        n = 1;
        if (n == 0)
        {
          f1 = paramMotionEvent.getX();
          f2 = i;
          f3 = paramMotionEvent.getY();
          f4 = m;
          i = 0;
          if (f2 >= 0.0F) {
            break label474;
          }
          hr();
          android.support.v4.widget.i.a(this.agb, -f2 / getWidth(), 1.0F - f3 / getHeight());
          i = 1;
          label398:
          if (f4 >= 0.0F) {
            break label514;
          }
          ht();
          android.support.v4.widget.i.a(this.agc, -f4 / getHeight(), f1 / getWidth());
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) || (f2 != 0.0F) || (f4 != 0.0F)) {
          q.O(this);
        }
        ad(paramInt1, paramInt2);
        break;
        label468:
        n = 0;
        break label328;
        label474:
        if (f2 <= 0.0F) {
          break label398;
        }
        hs();
        android.support.v4.widget.i.a(this.agd, f2 / getWidth(), f3 / getHeight());
        i = 1;
        break label398;
        label514:
        if (f4 > 0.0F)
        {
          hu();
          android.support.v4.widget.i.a(this.age, f4 / getHeight(), 1.0F - f1 / getWidth());
          i = 1;
        }
      }
      return false;
      n = 0;
      i = j;
      j = n;
      break;
      k = 0;
      j = i1;
      m = n;
    }
  }
  
  static RecyclerView.v bf(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahi;
  }
  
  public static int bg(View paramView)
  {
    paramView = bf(paramView);
    if (paramView != null) {
      return paramView.id();
    }
    return -1;
  }
  
  public static int bh(View paramView)
  {
    paramView = bf(paramView);
    if (paramView != null) {
      return paramView.ic();
    }
    return -1;
  }
  
  static RecyclerView bj(View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    if ((paramView instanceof RecyclerView)) {
      return (RecyclerView)paramView;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView localRecyclerView = bj(paramView.getChildAt(i));
      if (localRecyclerView != null) {
        return localRecyclerView;
      }
      i += 1;
    }
    return null;
  }
  
  public static void d(View paramView, Rect paramRect)
  {
    e(paramView, paramRect);
  }
  
  private void d(View paramView1, View paramView2)
  {
    boolean bool2 = true;
    Object localObject;
    Rect localRect;
    boolean bool1;
    if (paramView2 != null)
    {
      localObject = paramView2;
      this.ec.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams))
      {
        localObject = (RecyclerView.LayoutParams)localObject;
        if (!((RecyclerView.LayoutParams)localObject).ahj)
        {
          localObject = ((RecyclerView.LayoutParams)localObject).adx;
          localRect = this.ec;
          localRect.left -= ((Rect)localObject).left;
          localRect = this.ec;
          localRect.right += ((Rect)localObject).right;
          localRect = this.ec;
          localRect.top -= ((Rect)localObject).top;
          localRect = this.ec;
          int i = localRect.bottom;
          localRect.bottom = (((Rect)localObject).bottom + i);
        }
      }
      if (paramView2 != null)
      {
        offsetDescendantRectToMyCoords(paramView2, this.ec);
        offsetRectIntoDescendantCoords(paramView1, this.ec);
      }
      localObject = this.afG;
      localRect = this.ec;
      if (this.afO) {
        break label225;
      }
      bool1 = true;
      label200:
      if (paramView2 != null) {
        break label231;
      }
    }
    for (;;)
    {
      ((RecyclerView.i)localObject).a(this, paramView1, localRect, bool1, bool2);
      return;
      localObject = paramView1;
      break;
      label225:
      bool1 = false;
      break label200;
      label231:
      bool2 = false;
    }
  }
  
  static void e(View paramView, Rect paramRect)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.adx;
    int i = paramView.getLeft();
    int j = localRect.left;
    int k = localLayoutParams.leftMargin;
    int m = paramView.getTop();
    int n = localRect.top;
    int i1 = localLayoutParams.topMargin;
    int i2 = paramView.getRight();
    int i3 = localRect.right;
    int i4 = localLayoutParams.rightMargin;
    int i5 = paramView.getBottom();
    int i6 = localRect.bottom;
    paramRect.set(i - j - k, m - n - i1, i2 + i3 + i4, localLayoutParams.bottomMargin + (i6 + i5));
  }
  
  private void f(int[] paramArrayOfInt)
  {
    int i2 = this.afB.getChildCount();
    if (i2 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int i = 2147483647;
    int k = -2147483648;
    int n = 0;
    int m;
    int j;
    if (n < i2)
    {
      RecyclerView.v localv = bf(this.afB.getChildAt(n));
      m = i;
      if (localv.ib()) {
        break label122;
      }
      int i1 = localv.ic();
      j = i;
      if (i1 < i) {
        j = i1;
      }
      m = j;
      if (i1 <= k) {
        break label122;
      }
      i = j;
      j = i1;
    }
    for (;;)
    {
      n += 1;
      k = j;
      break;
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = k;
      return;
      label122:
      j = k;
      i = m;
    }
  }
  
  private long g(RecyclerView.v paramv)
  {
    if (this.Sw.agM) {
      return paramv.aih;
    }
    return paramv.mPosition;
  }
  
  static void h(RecyclerView.v paramv)
  {
    Object localObject;
    if (paramv.aif != null) {
      localObject = (View)paramv.aif.get();
    }
    while (localObject != null)
    {
      if (localObject == paramv.aie) {
        return;
      }
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof View)) {
        localObject = (View)localObject;
      } else {
        localObject = null;
      }
    }
    paramv.aif = null;
  }
  
  private boolean hB()
  {
    return this.afY > 0;
  }
  
  private boolean hD()
  {
    return (this.agf != null) && (this.afG.gM());
  }
  
  private void hE()
  {
    boolean bool2 = true;
    if (this.afW)
    {
      this.afA.reset();
      if (this.afX) {
        this.afG.gI();
      }
    }
    int i;
    label60:
    RecyclerView.s locals;
    if (hD())
    {
      this.afA.fZ();
      if ((!this.agx) && (!this.agy)) {
        break label179;
      }
      i = 1;
      locals = this.agu;
      if ((!this.afO) || (this.agf == null) || ((!this.afW) && (i == 0) && (!this.afG.agZ)) || ((this.afW) && (!this.Sw.agM))) {
        break label184;
      }
      bool1 = true;
      label120:
      locals.ahT = bool1;
      locals = this.agu;
      if ((!this.agu.ahT) || (i == 0) || (this.afW) || (!hD())) {
        break label189;
      }
    }
    label179:
    label184:
    label189:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locals.ahU = bool1;
      return;
      this.afA.gd();
      break;
      i = 0;
      break label60;
      bool1 = false;
      break label120;
    }
  }
  
  private void hF()
  {
    if (this.Sw == null) {}
    while (this.afG == null) {
      return;
    }
    this.agu.ahS = false;
    long l;
    RecyclerView.f.c localc;
    boolean bool1;
    boolean bool2;
    Object localObject3;
    int k;
    if (this.agu.ahN == 1)
    {
      hI();
      this.afG.d(this);
      hJ();
      this.agu.bZ(4);
      ho();
      hy();
      this.agu.ahN = 1;
      if (!this.agu.ahT) {
        break label660;
      }
      i = this.afB.getChildCount() - 1;
      if (i < 0) {
        break label649;
      }
      localObject1 = bf(this.afB.getChildAt(i));
      if (!((RecyclerView.v)localObject1).ib())
      {
        l = g((RecyclerView.v)localObject1);
        localc = new RecyclerView.f.c().c((RecyclerView.v)localObject1, 0);
        localObject2 = (RecyclerView.v)this.afC.ant.get(l);
        if ((localObject2 == null) || (((RecyclerView.v)localObject2).ib())) {
          break label635;
        }
        bool1 = this.afC.C((RecyclerView.v)localObject2);
        bool2 = this.afC.C((RecyclerView.v)localObject1);
        if ((bool1) && (localObject2 == localObject1)) {
          break label635;
        }
        localObject3 = this.afC.d((RecyclerView.v)localObject2, 4);
        this.afC.c((RecyclerView.v)localObject1, localc);
        localc = this.afC.d((RecyclerView.v)localObject1, 8);
        if (localObject3 != null) {
          break label540;
        }
        k = this.afB.getChildCount();
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (j >= k) {
          break label499;
        }
        localObject3 = bf(this.afB.getChildAt(j));
        if ((localObject3 != localObject1) && (g((RecyclerView.v)localObject3) == l))
        {
          if ((this.Sw != null) && (this.Sw.agM))
          {
            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localObject3 + " \n View Holder 2:" + localObject1 + hl());
            localObject1 = this.afA;
            if ((!((e)localObject1).Zf.isEmpty()) && (!((e)localObject1).Ze.isEmpty())) {}
            for (i = 1;; i = 0)
            {
              if ((i == 0) && (this.afG.mWidth == getWidth()) && (this.afG.mHeight == getHeight())) {
                break label437;
              }
              this.afG.d(this);
              hJ();
              break;
            }
            label437:
            this.afG.d(this);
            break;
          }
          throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localObject3 + " \n View Holder 2:" + localObject1 + hl());
        }
        j += 1;
      }
      label499:
      new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(localObject2).append(" cannot be found but it is necessary for ").append(localObject1).append(hl());
    }
    for (;;)
    {
      i -= 1;
      break;
      label540:
      ((RecyclerView.v)localObject2).ag(false);
      if (bool1) {
        f((RecyclerView.v)localObject2);
      }
      if (localObject2 != localObject1)
      {
        if (bool2) {
          f((RecyclerView.v)localObject1);
        }
        ((RecyclerView.v)localObject2).aik = ((RecyclerView.v)localObject1);
        f((RecyclerView.v)localObject2);
        this.afy.p((RecyclerView.v)localObject2);
        ((RecyclerView.v)localObject1).ag(false);
        ((RecyclerView.v)localObject1).ail = ((RecyclerView.v)localObject2);
      }
      if (this.agf.a((RecyclerView.v)localObject2, (RecyclerView.v)localObject1, (RecyclerView.f.c)localObject3, localc))
      {
        hC();
        continue;
        label635:
        this.afC.c((RecyclerView.v)localObject1, localc);
      }
    }
    label649:
    this.afC.a(this.agJ);
    label660:
    this.afG.c(this.afy);
    this.agu.ahL = this.agu.ahO;
    this.afW = false;
    this.afX = false;
    this.agu.ahT = false;
    this.agu.ahU = false;
    this.afG.agZ = false;
    if (this.afy.ahs != null) {
      this.afy.ahs.clear();
    }
    if (this.afG.ahe)
    {
      this.afG.ahd = 0;
      this.afG.ahe = false;
      this.afy.hW();
    }
    this.afG.a(this.agu);
    hz();
    ac(false);
    this.afC.clear();
    int i = this.agD[0];
    int j = this.agD[1];
    f(this.agD);
    if ((this.agD[0] != i) || (this.agD[1] != j))
    {
      i = 1;
      if (i != 0) {
        ag(0, 0);
      }
      if ((this.agq) && (this.Sw != null) && (hasFocus()) && (getDescendantFocusability() != 393216) && ((getDescendantFocusability() != 131072) || (!isFocused()))) {
        break label911;
      }
    }
    label911:
    label964:
    do
    {
      for (;;)
      {
        hG();
        return;
        i = 0;
        break;
        if (isFocused()) {
          break label976;
        }
        localObject1 = getFocusedChild();
        if ((!afv) || ((((View)localObject1).getParent() != null) && (((View)localObject1).hasFocus()))) {
          break label964;
        }
        if (this.afB.getChildCount() != 0) {
          break label976;
        }
        requestFocus();
      }
    } while (!this.afB.aS((View)localObject1));
    label976:
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.agu.ahW != -1L)
    {
      localObject1 = localObject2;
      if (this.Sw.agM) {
        localObject1 = m(this.agu.ahW);
      }
    }
    localObject2 = null;
    if ((localObject1 == null) || (this.afB.aS(((RecyclerView.v)localObject1).aie)) || (!((RecyclerView.v)localObject1).aie.hasFocusable()))
    {
      localObject1 = localObject2;
      if (this.afB.getChildCount() > 0) {
        localObject1 = hH();
      }
      label1078:
      if (localObject1 == null) {
        break label1146;
      }
      if (this.agu.ahX == -1L) {
        break label1148;
      }
      localObject2 = ((View)localObject1).findViewById(this.agu.ahX);
      if ((localObject2 == null) || (!((View)localObject2).isFocusable())) {
        break label1148;
      }
      localObject1 = localObject2;
    }
    label1146:
    label1148:
    for (;;)
    {
      ((View)localObject1).requestFocus();
      break;
      localObject1 = ((RecyclerView.v)localObject1).aie;
      break label1078;
      break;
    }
  }
  
  private void hG()
  {
    this.agu.ahW = -1L;
    this.agu.ahV = -1;
    this.agu.ahX = -1;
  }
  
  private View hH()
  {
    int k;
    int j;
    if (this.agu.ahV != -1)
    {
      i = this.agu.ahV;
      k = this.agu.getItemCount();
      j = i;
    }
    RecyclerView.v localv;
    for (;;)
    {
      if (j >= k) {
        break label75;
      }
      localv = bK(j);
      if (localv == null) {
        break label75;
      }
      if (localv.aie.hasFocusable())
      {
        return localv.aie;
        i = 0;
        break;
      }
      j += 1;
    }
    label75:
    int i = Math.min(k, i) - 1;
    while (i >= 0)
    {
      localv = bK(i);
      if (localv == null) {
        return null;
      }
      if (localv.aie.hasFocusable()) {
        return localv.aie;
      }
      i -= 1;
    }
    return null;
  }
  
  private void hI()
  {
    this.agu.bZ(1);
    m(this.agu);
    this.agu.ahS = false;
    ho();
    this.afC.clear();
    hy();
    hE();
    if ((this.agq) && (hasFocus()) && (this.Sw != null)) {}
    for (Object localObject1 = getFocusedChild();; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label345;
        }
        hG();
        label87:
        localObject1 = this.agu;
        if ((!this.agu.ahT) || (!this.agy)) {
          break label518;
        }
      }
      int j;
      int i;
      Object localObject2;
      label345:
      Object localObject3;
      label518:
      for (boolean bool = true;; bool = false)
      {
        ((RecyclerView.s)localObject1).ahR = bool;
        this.agy = false;
        this.agx = false;
        this.agu.ahQ = this.agu.ahU;
        this.agu.ahO = this.Sw.getItemCount();
        f(this.agD);
        if (!this.agu.ahT) {
          break label524;
        }
        j = this.afB.getChildCount();
        i = 0;
        long l;
        while (i < j)
        {
          localObject1 = bf(this.afB.getChildAt(i));
          if ((!((RecyclerView.v)localObject1).ib()) && ((!((RecyclerView.v)localObject1).ij()) || (this.Sw.agM)))
          {
            localObject2 = this.agf.a(this.agu, (RecyclerView.v)localObject1, RecyclerView.f.k((RecyclerView.v)localObject1), ((RecyclerView.v)localObject1).in());
            this.afC.b((RecyclerView.v)localObject1, (RecyclerView.f.c)localObject2);
            if ((this.agu.ahR) && (((RecyclerView.v)localObject1).ip()) && (!((RecyclerView.v)localObject1).isRemoved()) && (!((RecyclerView.v)localObject1).ib()) && (!((RecyclerView.v)localObject1).ij()))
            {
              l = g((RecyclerView.v)localObject1);
              this.afC.a(l, (RecyclerView.v)localObject1);
            }
          }
          i += 1;
        }
        localObject1 = be((View)localObject1);
        break;
        localObject2 = this.agu;
        if (this.Sw.agM)
        {
          l = ((RecyclerView.v)localObject1).aih;
          ((RecyclerView.s)localObject2).ahW = l;
          localObject2 = this.agu;
          if (!this.afW) {
            break label483;
          }
          i = -1;
        }
        for (;;)
        {
          ((RecyclerView.s)localObject2).ahV = i;
          localObject3 = this.agu;
          localObject1 = ((RecyclerView.v)localObject1).aie;
          i = ((View)localObject1).getId();
          while ((!((View)localObject1).isFocused()) && ((localObject1 instanceof ViewGroup)) && (((View)localObject1).hasFocus()))
          {
            localObject2 = ((ViewGroup)localObject1).getFocusedChild();
            localObject1 = localObject2;
            if (((View)localObject2).getId() != -1)
            {
              i = ((View)localObject2).getId();
              localObject1 = localObject2;
            }
          }
          l = -1L;
          break;
          label483:
          if (((RecyclerView.v)localObject1).isRemoved()) {
            i = ((RecyclerView.v)localObject1).aig;
          } else {
            i = ((RecyclerView.v)localObject1).id();
          }
        }
        ((RecyclerView.s)localObject3).ahX = i;
        break label87;
      }
      label524:
      if (this.agu.ahU)
      {
        j = this.afB.gx();
        i = 0;
        while (i < j)
        {
          localObject1 = bf(this.afB.bt(i));
          if ((!((RecyclerView.v)localObject1).ib()) && (((RecyclerView.v)localObject1).aig == -1)) {
            ((RecyclerView.v)localObject1).aig = ((RecyclerView.v)localObject1).mPosition;
          }
          i += 1;
        }
        bool = this.agu.ahP;
        this.agu.ahP = false;
        this.afG.c(this.afy, this.agu);
        this.agu.ahP = bool;
        i = 0;
        if (i < this.afB.getChildCount())
        {
          localObject3 = bf(this.afB.getChildAt(i));
          label705:
          RecyclerView.f.c localc;
          if (!((RecyclerView.v)localObject3).ib())
          {
            localObject1 = (be.a)this.afC.ans.get(localObject3);
            if ((localObject1 == null) || ((((be.a)localObject1).flags & 0x4) == 0)) {
              break label779;
            }
            j = 1;
            if (j == 0)
            {
              int k = RecyclerView.f.k((RecyclerView.v)localObject3);
              bool = ((RecyclerView.v)localObject3).ca(8192);
              j = k;
              if (!bool) {
                j = k | 0x1000;
              }
              localc = this.agf.a(this.agu, (RecyclerView.v)localObject3, j, ((RecyclerView.v)localObject3).in());
              if (!bool) {
                break label784;
              }
              a((RecyclerView.v)localObject3, localc);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            j = 0;
            break label705;
            label784:
            be localbe = this.afC;
            localObject2 = (be.a)localbe.ans.get(localObject3);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = be.a.jg();
              localbe.ans.put(localObject3, localObject1);
            }
            ((be.a)localObject1).flags |= 0x2;
            ((be.a)localObject1).anu = localc;
          }
        }
        hL();
      }
      for (;;)
      {
        label779:
        ad(true);
        ac(false);
        this.agu.ahN = 2;
        return;
        hL();
      }
    }
  }
  
  private void hJ()
  {
    ho();
    hy();
    this.agu.bZ(6);
    this.afA.gd();
    this.agu.ahO = this.Sw.getItemCount();
    this.agu.ahM = 0;
    this.agu.ahQ = false;
    this.afG.c(this.afy, this.agu);
    this.agu.ahP = false;
    this.afz = null;
    RecyclerView.s locals = this.agu;
    if ((this.agu.ahT) && (this.agf != null)) {}
    for (boolean bool = true;; bool = false)
    {
      locals.ahT = bool;
      this.agu.ahN = 4;
      ad(true);
      ac(false);
      return;
    }
  }
  
  private void hK()
  {
    int j = 0;
    int k = this.afB.gx();
    int i = 0;
    while (i < k)
    {
      ((RecyclerView.LayoutParams)this.afB.bt(i).getLayoutParams()).ahj = true;
      i += 1;
    }
    RecyclerView.o localo = this.afy;
    k = localo.aht.size();
    i = j;
    while (i < k)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.v)localo.aht.get(i)).aie.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.ahj = true;
      }
      i += 1;
    }
  }
  
  private void hL()
  {
    int j = 0;
    int k = this.afB.gx();
    int i = 0;
    while (i < k)
    {
      localObject = bf(this.afB.bt(i));
      if (!((RecyclerView.v)localObject).ib()) {
        ((RecyclerView.v)localObject).ia();
      }
      i += 1;
    }
    Object localObject = this.afy;
    k = ((RecyclerView.o)localObject).aht.size();
    i = 0;
    while (i < k)
    {
      ((RecyclerView.v)((RecyclerView.o)localObject).aht.get(i)).ia();
      i += 1;
    }
    k = ((RecyclerView.o)localObject).ahr.size();
    i = 0;
    while (i < k)
    {
      ((RecyclerView.v)((RecyclerView.o)localObject).ahr.get(i)).ia();
      i += 1;
    }
    if (((RecyclerView.o)localObject).ahs != null)
    {
      k = ((RecyclerView.o)localObject).ahs.size();
      i = j;
      while (i < k)
      {
        ((RecyclerView.v)((RecyclerView.o)localObject).ahs.get(i)).ia();
        i += 1;
      }
    }
  }
  
  private void hp()
  {
    setScrollState(0);
    hq();
  }
  
  private void hq()
  {
    this.agr.stop();
    if (this.afG != null) {
      this.afG.hS();
    }
  }
  
  private void hr()
  {
    if (this.agb != null) {
      return;
    }
    this.agb = RecyclerView.e.c(this);
    if (this.afD)
    {
      this.agb.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.agb.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void hs()
  {
    if (this.agd != null) {
      return;
    }
    this.agd = RecyclerView.e.c(this);
    if (this.afD)
    {
      this.agd.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.agd.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void ht()
  {
    if (this.agc != null) {
      return;
    }
    this.agc = RecyclerView.e.c(this);
    if (this.afD)
    {
      this.agc.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.agc.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void hu()
  {
    if (this.age != null) {
      return;
    }
    this.age = RecyclerView.e.c(this);
    if (this.afD)
    {
      this.age.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.age.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void hv()
  {
    this.age = null;
    this.agc = null;
    this.agd = null;
    this.agb = null;
  }
  
  private void hw()
  {
    boolean bool2 = false;
    if (this.fB != null) {
      this.fB.clear();
    }
    av(0);
    if (this.agb != null)
    {
      this.agb.onRelease();
      bool2 = this.agb.isFinished();
    }
    boolean bool1 = bool2;
    if (this.agc != null)
    {
      this.agc.onRelease();
      bool1 = bool2 | this.agc.isFinished();
    }
    bool2 = bool1;
    if (this.agd != null)
    {
      this.agd.onRelease();
      bool2 = bool1 | this.agd.isFinished();
    }
    bool1 = bool2;
    if (this.age != null)
    {
      this.age.onRelease();
      bool1 = bool2 | this.age.isFinished();
    }
    if (bool1) {
      q.O(this);
    }
  }
  
  private void hx()
  {
    hw();
    setScrollState(0);
  }
  
  private void hz()
  {
    ad(true);
  }
  
  private void j(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.agg) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.agg = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.agj = j;
      this.agh = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.agk = i;
      this.agi = i;
      return;
    }
  }
  
  private RecyclerView.v m(long paramLong)
  {
    RecyclerView.v localv2 = null;
    RecyclerView.v localv1 = localv2;
    if (this.Sw != null)
    {
      if (this.Sw.agM) {
        break label31;
      }
      localv1 = localv2;
    }
    label31:
    int i;
    do
    {
      return localv1;
      int j = this.afB.gx();
      i = 0;
      localv1 = null;
      if (i >= j) {
        break;
      }
      localv2 = bf(this.afB.bt(i));
      if ((localv2 == null) || (localv2.isRemoved()) || (localv2.aih != paramLong)) {
        break label120;
      }
      localv1 = localv2;
    } while (!this.afB.aS(localv2.aie));
    localv1 = localv2;
    label120:
    for (;;)
    {
      i += 1;
      break;
      return localv1;
    }
  }
  
  private boolean r(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().r(paramInt1, paramInt2);
  }
  
  final void Q(String paramString)
  {
    if (hB())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + hl());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.afZ > 0) {
      new IllegalStateException(hl());
    }
  }
  
  public final void a(RecyclerView.h paramh)
  {
    if (this.afG != null) {
      this.afG.Q("Cannot add item decoration during a scroll  or layout");
    }
    if (this.afI.isEmpty()) {
      setWillNotDraw(false);
    }
    this.afI.add(paramh);
    hK();
    requestLayout();
  }
  
  public final void a(RecyclerView.l paraml)
  {
    this.afJ.add(paraml);
  }
  
  public final void a(RecyclerView.m paramm)
  {
    if (this.agw == null) {
      this.agw = new ArrayList();
    }
    this.agw.add(paramm);
  }
  
  final void a(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    paramv.setFlags(0, 8192);
    if ((this.agu.ahR) && (paramv.ip()) && (!paramv.isRemoved()) && (!paramv.ib()))
    {
      long l = g(paramv);
      this.afC.a(l, paramv);
    }
    this.afC.b(paramv, paramc);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public final RecyclerView.v aT(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return bf(paramView);
  }
  
  final void ac(boolean paramBoolean)
  {
    if (this.afP <= 0) {
      this.afP = 1;
    }
    if ((!paramBoolean) && (!this.afR)) {
      this.afQ = false;
    }
    if (this.afP == 1)
    {
      if ((paramBoolean) && (this.afQ) && (!this.afR) && (this.afG != null) && (this.Sw != null)) {
        hF();
      }
      if (!this.afR) {
        this.afQ = false;
      }
    }
    this.afP -= 1;
  }
  
  public boolean ac(int paramInt1, int paramInt2)
  {
    if (this.afG == null) {}
    boolean bool2;
    boolean bool3;
    int i;
    int j;
    boolean bool1;
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.afR);
        bool2 = this.afG.gO();
        bool3 = this.afG.gP();
        if (bool2)
        {
          i = paramInt1;
          if (Math.abs(paramInt1) >= this.agm) {}
        }
        else
        {
          i = 0;
        }
        if (bool3)
        {
          j = paramInt2;
          if (Math.abs(paramInt2) >= this.agm) {}
        }
        else
        {
          j = 0;
        }
      } while (((i == 0) && (j == 0)) || (dispatchNestedPreFling(i, j)));
      if ((bool2) || (bool3)) {}
      for (bool1 = true;; bool1 = false)
      {
        dispatchNestedFling(i, j, bool1);
        if ((this.agl == null) || (!this.agl.at(i, j))) {
          break;
        }
        return true;
      }
    } while (!bool1);
    if (bool2) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramInt2 = paramInt1;
      if (bool3) {
        paramInt2 = paramInt1 | 0x2;
      }
      r(paramInt2, 1);
      paramInt1 = Math.max(-this.agn, Math.min(i, this.agn));
      paramInt2 = Math.max(-this.agn, Math.min(j, this.agn));
      RecyclerView.u localu = this.agr;
      localu.agK.setScrollState(2);
      localu.aib = 0;
      localu.aia = 0;
      localu.iY.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      localu.hZ();
      return true;
    }
  }
  
  final void ad(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.agb != null)
    {
      bool1 = bool2;
      if (!this.agb.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.agb.onRelease();
          bool1 = this.agb.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.agd != null)
    {
      bool2 = bool1;
      if (!this.agd.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.agd.onRelease();
          bool2 = bool1 | this.agd.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.agc != null)
    {
      bool1 = bool2;
      if (!this.agc.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.agc.onRelease();
          bool1 = bool2 | this.agc.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.age != null)
    {
      bool2 = bool1;
      if (!this.age.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.age.onRelease();
          bool2 = bool1 | this.age.isFinished();
        }
      }
    }
    if (bool2) {
      q.O(this);
    }
  }
  
  final void ad(boolean paramBoolean)
  {
    this.afY -= 1;
    if (this.afY <= 0)
    {
      this.afY = 0;
      if (paramBoolean)
      {
        int i = this.afT;
        this.afT = 0;
        Object localObject;
        if ((i != 0) && (hA()))
        {
          localObject = AccessibilityEvent.obtain();
          ((AccessibilityEvent)localObject).setEventType(2048);
          if (Build.VERSION.SDK_INT >= 19) {
            ((AccessibilityEvent)localObject).setContentChangeTypes(i);
          }
          sendAccessibilityEventUnchecked((AccessibilityEvent)localObject);
        }
        i = this.agG.size() - 1;
        while (i >= 0)
        {
          localObject = (RecyclerView.v)this.agG.get(i);
          if ((((RecyclerView.v)localObject).aie.getParent() == this) && (!((RecyclerView.v)localObject).ib()))
          {
            int j = ((RecyclerView.v)localObject).ait;
            if (j != -1)
            {
              q.n(((RecyclerView.v)localObject).aie, j);
              ((RecyclerView.v)localObject).ait = -1;
            }
          }
          i -= 1;
        }
        this.agG.clear();
      }
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }
  
  final void ae(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      hr();
      this.agb.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label66;
      }
      ht();
      this.agc.onAbsorb(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        q.O(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      hs();
      this.agd.onAbsorb(paramInt1);
      break;
      label66:
      if (paramInt2 > 0)
      {
        hu();
        this.age.onAbsorb(paramInt2);
      }
    }
  }
  
  final void ae(boolean paramBoolean)
  {
    this.afX |= paramBoolean;
    this.afW = true;
    int j = this.afB.gx();
    int i = 0;
    while (i < j)
    {
      localObject = bf(this.afB.bt(i));
      if ((localObject != null) && (!((RecyclerView.v)localObject).ib())) {
        ((RecyclerView.v)localObject).addFlags(6);
      }
      i += 1;
    }
    hK();
    Object localObject = this.afy;
    j = ((RecyclerView.o)localObject).aht.size();
    i = 0;
    while (i < j)
    {
      RecyclerView.v localv = (RecyclerView.v)((RecyclerView.o)localObject).aht.get(i);
      if (localv != null)
      {
        localv.addFlags(6);
        localv.M(null);
      }
      i += 1;
    }
    if ((((RecyclerView.o)localObject).agK.Sw == null) || (!((RecyclerView.o)localObject).agK.Sw.agM)) {
      ((RecyclerView.o)localObject).hX();
    }
  }
  
  final void af(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(RecyclerView.i.k(paramInt1, getPaddingLeft() + getPaddingRight(), q.W(this)), RecyclerView.i.k(paramInt2, getPaddingTop() + getPaddingBottom(), q.X(this)));
  }
  
  final void ag(int paramInt1, int paramInt2)
  {
    this.afZ += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.agv != null) {
      this.agv.a(this, paramInt1, paramInt2);
    }
    if (this.agw != null)
    {
      i = this.agw.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.m)this.agw.get(i)).a(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.afZ -= 1;
  }
  
  public final void av(int paramInt)
  {
    getScrollingChildHelper().av(paramInt);
  }
  
  public final void b(RecyclerView.h paramh)
  {
    if (this.afG != null) {
      this.afG.Q("Cannot remove item decoration during a scroll  or layout");
    }
    this.afI.remove(paramh);
    if (this.afI.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      hK();
      requestLayout();
      return;
    }
  }
  
  public final void b(RecyclerView.l paraml)
  {
    this.afJ.remove(paraml);
    if (this.afK == paraml) {
      this.afK = null;
    }
  }
  
  public final void b(RecyclerView.m paramm)
  {
    if (this.agw != null) {
      this.agw.remove(paramm);
    }
  }
  
  final boolean b(RecyclerView.v paramv, int paramInt)
  {
    if (hB())
    {
      paramv.ait = paramInt;
      this.agG.add(paramv);
      return false;
    }
    q.n(paramv.aie, paramInt);
    return true;
  }
  
  public void bE(int paramInt)
  {
    if (this.afR) {}
    do
    {
      return;
      hp();
    } while (this.afG == null);
    this.afG.bE(paramInt);
    awakenScrollBars();
  }
  
  final void bJ(int paramInt)
  {
    if (this.afG == null) {
      return;
    }
    this.afG.bE(paramInt);
    awakenScrollBars();
  }
  
  public final RecyclerView.v bK(int paramInt)
  {
    Object localObject = null;
    if (this.afW) {}
    int i;
    RecyclerView.v localv;
    do
    {
      return localObject;
      int j = this.afB.gx();
      i = 0;
      localObject = null;
      if (i >= j) {
        break;
      }
      localv = bf(this.afB.bt(i));
      if ((localv == null) || (localv.isRemoved()) || (i(localv) != paramInt)) {
        break label100;
      }
      localObject = localv;
    } while (!this.afB.aS(localv.aie));
    localObject = localv;
    label100:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public final View bd(View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this) {
      return paramView;
    }
    return null;
  }
  
  public final RecyclerView.v be(View paramView)
  {
    paramView = bd(paramView);
    if (paramView == null) {
      return null;
    }
    return aT(paramView);
  }
  
  final Rect bi(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.ahj) {
      return localLayoutParams.adx;
    }
    if ((this.agu.ahQ) && ((localLayoutParams.ahi.ip()) || (localLayoutParams.ahi.ij()))) {
      return localLayoutParams.adx;
    }
    Rect localRect = localLayoutParams.adx;
    localRect.set(0, 0, 0, 0);
    int j = this.afI.size();
    int i = 0;
    while (i < j)
    {
      this.ec.set(0, 0, 0, 0);
      ((RecyclerView.h)this.afI.get(i)).a(this.ec, paramView, this, this.agu);
      localRect.left += this.ec.left;
      localRect.top += this.ec.top;
      localRect.right += this.ec.right;
      localRect.bottom += this.ec.bottom;
      i += 1;
    }
    localLayoutParams.ahj = false;
    return localRect;
  }
  
  final void bk(View paramView)
  {
    bf(paramView);
    if (this.afV != null)
    {
      int i = this.afV.size() - 1;
      while (i >= 0)
      {
        ((j)this.afV.get(i)).bu(paramView);
        i -= 1;
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof RecyclerView.LayoutParams)) && (this.afG.a((RecyclerView.LayoutParams)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.afG == null) {}
    while (!this.afG.gO()) {
      return 0;
    }
    return this.afG.f(this.agu);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.afG == null) {}
    while (!this.afG.gO()) {
      return 0;
    }
    return this.afG.d(this.agu);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.afG == null) {}
    while (!this.afG.gO()) {
      return 0;
    }
    return this.afG.h(this.agu);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.afG == null) {}
    while (!this.afG.gP()) {
      return 0;
    }
    return this.afG.g(this.agu);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.afG == null) {}
    while (!this.afG.gP()) {
      return 0;
    }
    return this.afG.e(this.agu);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.afG == null) {}
    while (!this.afG.gP()) {
      return 0;
    }
    return this.afG.i(this.agu);
  }
  
  final void d(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.afB.gx();
    int i = 0;
    if (i < j)
    {
      localObject = bf(this.afB.bt(i));
      if ((localObject != null) && (!((RecyclerView.v)localObject).ib()))
      {
        if (((RecyclerView.v)localObject).mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        ((RecyclerView.v)localObject).p(-paramInt2, paramBoolean);
        this.agu.ahP = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        if (((RecyclerView.v)localObject).mPosition >= paramInt1)
        {
          int k = -paramInt2;
          ((RecyclerView.v)localObject).addFlags(8);
          ((RecyclerView.v)localObject).p(k, paramBoolean);
          ((RecyclerView.v)localObject).mPosition = (paramInt1 - 1);
          this.agu.ahP = true;
        }
      }
    }
    Object localObject = this.afy;
    i = ((RecyclerView.o)localObject).aht.size() - 1;
    if (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)((RecyclerView.o)localObject).aht.get(i);
      if (localv != null)
      {
        if (localv.mPosition < paramInt1 + paramInt2) {
          break label200;
        }
        localv.p(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label200:
        if (localv.mPosition >= paramInt1)
        {
          localv.addFlags(8);
          ((RecyclerView.o)localObject).bW(i);
        }
      }
    }
    requestLayout();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int m = 0;
    super.draw(paramCanvas);
    int j = this.afI.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.h)this.afI.get(i)).a(paramCanvas, this);
      i += 1;
    }
    int n;
    if ((this.agb != null) && (!this.agb.isFinished()))
    {
      n = paramCanvas.save();
      if (this.afD)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.agb == null) || (!this.agb.draw(paramCanvas))) {
          break label452;
        }
        j = 1;
        label124:
        paramCanvas.restoreToCount(n);
      }
    }
    for (;;)
    {
      i = j;
      if (this.agc != null)
      {
        i = j;
        if (!this.agc.isFinished())
        {
          n = paramCanvas.save();
          if (this.afD) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.agc == null) || (!this.agc.draw(paramCanvas))) {
            break label457;
          }
          i = 1;
          label198:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.agd != null)
      {
        j = i;
        if (!this.agd.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.afD) {
            break label462;
          }
          j = getPaddingTop();
          label253:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.agd == null) || (!this.agd.draw(paramCanvas))) {
            break label467;
          }
          j = 1;
          label291:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.age != null)
      {
        i = j;
        if (!this.age.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.afD) {
            break label472;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label368:
          i = m;
          if (this.age != null)
          {
            i = m;
            if (this.age.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.agf != null) && (this.afI.size() > 0) && (this.agf.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          q.O(this);
        }
        return;
        i = 0;
        break;
        label452:
        j = 0;
        break label124;
        label457:
        i = 0;
        break label198;
        label462:
        j = 0;
        break label253;
        label467:
        j = 0;
        break label291;
        label472:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label368;
      }
      j = 0;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  final void f(RecyclerView.v paramv)
  {
    View localView = paramv.aie;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.afy.p(aT(localView));
      if (!paramv.il()) {
        break;
      }
      this.afB.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.afB.a(localView, -1, true);
      return;
    }
    paramv = this.afB;
    i = paramv.abh.indexOfChild(localView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + localView);
    }
    paramv.abi.set(i);
    paramv.aQ(localView);
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int i1 = -1;
    int n = 0;
    int i;
    Object localObject;
    label74:
    int k;
    if ((this.Sw != null) && (this.afG != null) && (!hB()) && (!this.afR))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label327;
      }
      if (!this.afG.gP()) {
        break label991;
      }
      if (paramInt != 2) {
        break label225;
      }
      i = 130;
      if (((FocusFinder)localObject).findNextFocus(this, paramView, i) != null) {
        break label231;
      }
      k = 1;
      label88:
      j = k;
      if (afu) {
        paramInt = i;
      }
    }
    label149:
    label157:
    label167:
    label327:
    label600:
    label986:
    label991:
    for (int j = k;; j = 0)
    {
      int m = j;
      k = paramInt;
      if (j == 0)
      {
        m = j;
        k = paramInt;
        if (this.afG.gO())
        {
          if (q.Q(this.afG.acI) != 1) {
            break label237;
          }
          i = 1;
          if (paramInt != 2) {
            break label242;
          }
          j = 1;
          if ((j ^ i) == 0) {
            break label248;
          }
          i = 66;
          if (((FocusFinder)localObject).findNextFocus(this, paramView, i) != null) {
            break label254;
          }
        }
      }
      label225:
      label231:
      label237:
      label242:
      label248:
      label254:
      for (j = 1;; j = 0)
      {
        m = j;
        k = paramInt;
        if (afu)
        {
          k = i;
          m = j;
        }
        if (m == 0) {
          break label288;
        }
        hn();
        if (bd(paramView) != null) {
          break label260;
        }
        return null;
        i = 0;
        break;
        i = 33;
        break label74;
        k = 0;
        break label88;
        i = 0;
        break label149;
        j = 0;
        break label157;
        i = 17;
        break label167;
      }
      ho();
      this.afG.a(paramView, k, this.afy, this.agu);
      ac(false);
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, k);
      while ((localObject != null) && (!((View)localObject).hasFocusable())) {
        if (getFocusedChild() == null)
        {
          return super.focusSearch(paramView, k);
          View localView = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
          localObject = localView;
          k = paramInt;
          if (localView == null)
          {
            localObject = localView;
            k = paramInt;
            if (i != 0)
            {
              hn();
              if (bd(paramView) == null) {
                return null;
              }
              ho();
              localObject = this.afG.a(paramView, paramInt, this.afy, this.agu);
              ac(false);
              k = paramInt;
            }
          }
        }
        else
        {
          d((View)localObject, null);
          return paramView;
        }
      }
      paramInt = n;
      if (localObject != null)
      {
        if (localObject != this) {
          break label441;
        }
        paramInt = n;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          return localObject;
          paramInt = n;
          if (bd((View)localObject) != null) {
            if (paramView == null)
            {
              paramInt = 1;
            }
            else if (bd(paramView) == null)
            {
              paramInt = 1;
            }
            else
            {
              this.ec.set(0, 0, paramView.getWidth(), paramView.getHeight());
              this.jg.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.ec);
              offsetDescendantRectToMyCoords((View)localObject, this.jg);
              if (q.Q(this.afG.acI) == 1)
              {
                m = -1;
                if (((this.ec.left >= this.jg.left) && (this.ec.right > this.jg.left)) || (this.ec.right >= this.jg.right)) {
                  break label755;
                }
                i = 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (((this.ec.top < this.jg.top) || (this.ec.bottom <= this.jg.top)) && (this.ec.bottom < this.jg.bottom)) {
          j = 1;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            throw new IllegalArgumentException("Invalid direction: " + k + hl());
            m = 1;
            break label547;
            label755:
            if (((this.ec.right <= this.jg.right) && (this.ec.left < this.jg.right)) || (this.ec.left <= this.jg.left)) {
              break label986;
            }
            i = -1;
            break label600;
            if ((this.ec.bottom > this.jg.bottom) || (this.ec.top >= this.jg.bottom))
            {
              j = i1;
              if (this.ec.top > this.jg.top) {}
            }
            else
            {
              j = 0;
            }
            break;
          }
        }
        paramInt = n;
        if (i >= 0) {
          break;
        }
        paramInt = 1;
        break;
        paramInt = n;
        if (i <= 0) {
          break;
        }
        paramInt = 1;
        break;
        paramInt = n;
        if (j >= 0) {
          break;
        }
        paramInt = 1;
        break;
        paramInt = n;
        if (j <= 0) {
          break;
        }
        paramInt = 1;
        break;
        if (j <= 0)
        {
          paramInt = n;
          if (j != 0) {
            break;
          }
          paramInt = n;
          if (m * i < 0) {
            break;
          }
        }
        paramInt = 1;
        break;
        if (j >= 0)
        {
          paramInt = n;
          if (j != 0) {
            break;
          }
          paramInt = n;
          if (m * i > 0) {
            break;
          }
        }
        paramInt = 1;
        break;
        return super.focusSearch(paramView, k);
        i = 0;
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.afG == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + hl());
    }
    return this.afG.gJ();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.afG == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + hl());
    }
    return this.afG.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.afG == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + hl());
    }
    return this.afG.d(paramLayoutParams);
  }
  
  public a getAdapter()
  {
    return this.Sw;
  }
  
  public int getBaseline()
  {
    if (this.afG != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.agC == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.agC.ap(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return this.afD;
  }
  
  public ak getCompatAccessibilityDelegate()
  {
    return this.agB;
  }
  
  public RecyclerView.e getEdgeEffectFactory()
  {
    return this.aga;
  }
  
  public RecyclerView.f getItemAnimator()
  {
    return this.agf;
  }
  
  public int getItemDecorationCount()
  {
    return this.afI.size();
  }
  
  public RecyclerView.i getLayoutManager()
  {
    return this.afG;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.agn;
  }
  
  public int getMinFlingVelocity()
  {
    return this.agm;
  }
  
  long getNanoTime()
  {
    if (aft) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public RecyclerView.k getOnFlingListener()
  {
    return this.agl;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.agq;
  }
  
  public RecyclerView.n getRecycledViewPool()
  {
    return this.afy.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.lf;
  }
  
  android.support.v4.view.i getScrollingChildHelper()
  {
    if (this.agE == null) {
      this.agE = new android.support.v4.view.i(this);
    }
    return this.agE;
  }
  
  final boolean hA()
  {
    return (this.eV != null) && (this.eV.isEnabled());
  }
  
  final void hC()
  {
    if ((!this.agA) && (this.afL))
    {
      q.b(this, this.agH);
      this.agA = true;
    }
  }
  
  public final boolean hM()
  {
    return (!this.afO) || (this.afW) || (this.afA.gb());
  }
  
  final void hN()
  {
    int j = this.afB.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.afB.getChildAt(i);
      Object localObject = aT(localView);
      if ((localObject != null) && (((RecyclerView.v)localObject).ail != null))
      {
        localObject = ((RecyclerView.v)localObject).ail.aie;
        int k = localView.getLeft();
        int m = localView.getTop();
        if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
          ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
        }
      }
      i += 1;
    }
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().au(0);
  }
  
  final String hl()
  {
    return " " + super.toString() + ", adapter:" + this.Sw + ", layout:" + this.afG + ", context:" + getContext();
  }
  
  final void hm()
  {
    if (this.agf != null) {
      this.agf.gC();
    }
    if (this.afG != null)
    {
      this.afG.d(this.afy);
      this.afG.c(this.afy);
    }
    this.afy.clear();
  }
  
  final void hn()
  {
    int k = 0;
    if ((!this.afO) || (this.afW))
    {
      android.support.v4.os.f.beginSection("RV FullInvalidate");
      hF();
      android.support.v4.os.f.endSection();
    }
    label168:
    label175:
    do
    {
      do
      {
        return;
      } while (!this.afA.gb());
      if ((this.afA.bm(4)) && (!this.afA.bm(11)))
      {
        android.support.v4.os.f.beginSection("RV PartialInvalidate");
        ho();
        hy();
        this.afA.fZ();
        int i;
        if (!this.afQ)
        {
          int m = this.afB.getChildCount();
          i = 0;
          int j = k;
          if (i < m)
          {
            RecyclerView.v localv = bf(this.afB.getChildAt(i));
            if ((localv == null) || (localv.ib()) || (!localv.ip())) {
              break label168;
            }
            j = 1;
          }
          if (j == 0) {
            break label175;
          }
          hF();
        }
        for (;;)
        {
          ac(true);
          ad(true);
          android.support.v4.os.f.endSection();
          return;
          i += 1;
          break;
          this.afA.ga();
        }
      }
    } while (!this.afA.gb());
    android.support.v4.os.f.beginSection("RV FullInvalidate");
    hF();
    android.support.v4.os.f.endSection();
  }
  
  final void ho()
  {
    this.afP += 1;
    if ((this.afP == 1) && (!this.afR)) {
      this.afQ = false;
    }
  }
  
  final void hy()
  {
    this.afY += 1;
  }
  
  final int i(RecyclerView.v paramv)
  {
    int i;
    if ((paramv.ca(524)) || (!paramv.isBound())) {
      i = -1;
    }
    e locale;
    int j;
    int n;
    int m;
    do
    {
      return i;
      locale = this.afA;
      j = paramv.mPosition;
      n = locale.Ze.size();
      m = 0;
      i = j;
    } while (m >= n);
    paramv = (e.b)locale.Ze.get(m);
    switch (paramv.uC)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      m += 1;
      j = i;
      break;
      i = j;
      if (paramv.Zl <= j)
      {
        i = j + paramv.Zn;
        continue;
        i = j;
        if (paramv.Zl <= j)
        {
          if (paramv.Zl + paramv.Zn > j) {
            return -1;
          }
          i = j - paramv.Zn;
          continue;
          if (paramv.Zl == j)
          {
            i = paramv.Zn;
          }
          else
          {
            int k = j;
            if (paramv.Zl < j) {
              k = j - 1;
            }
            i = k;
            if (paramv.Zn <= k) {
              i = k + 1;
            }
          }
        }
      }
    }
  }
  
  public boolean isAttachedToWindow()
  {
    return this.afL;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().Fp;
  }
  
  final void m(RecyclerView.s params)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = RecyclerView.u.a(this.agr);
      params.ahY = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      params.ahZ = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    params.ahY = 0;
    params.ahZ = 0;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.afY = 0;
    this.afL = true;
    boolean bool;
    float f;
    if ((this.afO) && (!isLayoutRequested()))
    {
      bool = true;
      this.afO = bool;
      if (this.afG != null) {
        this.afG.hD = true;
      }
      this.agA = false;
      if (aft)
      {
        this.ags = ((ad)ad.adc.get());
        if (this.ags == null)
        {
          this.ags = new ad();
          Display localDisplay = q.aq(this);
          if ((isInEditMode()) || (localDisplay == null)) {
            break label162;
          }
          f = localDisplay.getRefreshRate();
          if (f < 30.0F) {
            break label162;
          }
        }
      }
    }
    for (;;)
    {
      this.ags.adg = ((1.0E+009F / f));
      ad.adc.set(this.ags);
      this.ags.ade.add(this);
      return;
      bool = false;
      break;
      label162:
      f = 60.0F;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.agf != null) {
      this.agf.gC();
    }
    hp();
    this.afL = false;
    if (this.afG != null) {
      this.afG.b(this, this.afy);
    }
    this.agG.clear();
    removeCallbacks(this.agH);
    be.a.jh();
    if ((aft) && (this.ags != null))
    {
      this.ags.ade.remove(this);
      this.ags = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.afI.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.h)this.afI.get(i)).a(paramCanvas, this, this.agu);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.afG == null) {}
    label188:
    for (;;)
    {
      return false;
      if ((!this.afR) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        float f3;
        float f2;
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
          if (this.afG.gP())
          {
            f1 = -paramMotionEvent.getAxisValue(9);
            if (!this.afG.gO()) {
              break label114;
            }
            f3 = paramMotionEvent.getAxisValue(10);
            f2 = f1;
            f1 = f3;
          }
        }
        for (;;)
        {
          if ((f2 == 0.0F) && (f1 == 0.0F)) {
            break label188;
          }
          a((int)(this.ago * f1), (int)(this.agp * f2), paramMotionEvent);
          return false;
          f1 = 0.0F;
          break;
          label114:
          f3 = 0.0F;
          f2 = f1;
          f1 = f3;
          continue;
          if ((paramMotionEvent.getSource() & 0x400000) != 0)
          {
            f1 = paramMotionEvent.getAxisValue(26);
            if (this.afG.gP())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.afG.gO())
            {
              f2 = 0.0F;
            }
            else
            {
              f1 = 0.0F;
              f2 = 0.0F;
            }
          }
          else
          {
            f1 = 0.0F;
            f2 = 0.0F;
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.afR) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.afK = null;
    }
    int k = this.afJ.size();
    int i = 0;
    if (i < k)
    {
      RecyclerView.l locall = (RecyclerView.l)this.afJ.get(i);
      if ((locall.h(paramMotionEvent)) && (j != 3)) {
        this.afK = locall;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label104;
      }
      hx();
      return true;
      i += 1;
      break;
    }
    label104:
    if (this.afG == null) {
      return false;
    }
    boolean bool1 = this.afG.gO();
    boolean bool2 = this.afG.gP();
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    this.fB.addMovement(paramMotionEvent);
    j = paramMotionEvent.getActionMasked();
    i = paramMotionEvent.getActionIndex();
    switch (j)
    {
    case 4: 
    default: 
      if (this.lf == 1) {
        return true;
      }
      break;
    case 0: 
      if (this.afS) {
        this.afS = false;
      }
      this.agg = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.agj = i;
      this.agh = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.agk = i;
      this.agi = i;
      if (this.lf == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.agF;
      this.agF[1] = 0;
      paramMotionEvent[0] = 0;
      if (!bool1) {}
      break;
    }
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      r(j, 0);
      break;
      this.agg = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.agj = j;
      this.agh = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.agk = i;
      this.agi = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.agg);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.agg).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.lf == 1) {
        break;
      }
      j = this.agh;
      int m = this.agi;
      if ((bool1) && (Math.abs(i - j) > this.jb)) {
        this.agj = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.jb)
          {
            this.agk = k;
            j = 1;
          }
        }
        if (j == 0) {
          break;
        }
        setScrollState(1);
        break;
        j(paramMotionEvent);
        break;
        this.fB.clear();
        av(0);
        break;
        hx();
        break;
        return false;
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    android.support.v4.os.f.beginSection("RV OnLayout");
    hF();
    android.support.v4.os.f.endSection();
    this.afO = true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.afG == null) {
      af(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.afG.gN()) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        this.afG.as(paramInt1, paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
      } while ((i != 0) || (this.Sw == null));
      if (this.agu.ahN == 1) {
        hI();
      }
      this.afG.aq(paramInt1, paramInt2);
      this.agu.ahS = true;
      hJ();
      this.afG.ar(paramInt1, paramInt2);
    } while (!this.afG.gT());
    this.afG.aq(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.agu.ahS = true;
    hJ();
    this.afG.ar(paramInt1, paramInt2);
    return;
    if (this.afM)
    {
      this.afG.as(paramInt1, paramInt2);
      return;
    }
    if (this.afU)
    {
      ho();
      hy();
      hE();
      ad(true);
      if (this.agu.ahU)
      {
        this.agu.ahQ = true;
        this.afU = false;
        ac(false);
        label256:
        if (this.Sw == null) {
          break label345;
        }
      }
    }
    label345:
    for (this.agu.ahO = this.Sw.getItemCount();; this.agu.ahO = 0)
    {
      ho();
      this.afG.as(paramInt1, paramInt2);
      ac(false);
      this.agu.ahQ = false;
      return;
      this.afA.gd();
      this.agu.ahQ = false;
      break;
      if (!this.agu.ahU) {
        break label256;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (hB()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof RecyclerView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      this.afz = ((RecyclerView.SavedState)paramParcelable);
      super.onRestoreInstanceState(this.afz.EA);
    } while ((this.afG == null) || (this.afz.ahz == null));
    this.afG.onRestoreInstanceState(this.afz.ahz);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (this.afz != null)
    {
      localSavedState.ahz = this.afz.ahz;
      return localSavedState;
    }
    if (this.afG != null)
    {
      localSavedState.ahz = this.afG.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.ahz = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      hv();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.afR) || (this.afS)) {}
    label144:
    label153:
    label159:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.afK != null)
      {
        if (i == 0) {
          this.afK = null;
        }
      }
      else
      {
        if (i == 0) {
          break label153;
        }
        j = this.afJ.size();
        i = 0;
        if (i >= j) {
          break label153;
        }
        localObject = (RecyclerView.l)this.afJ.get(i);
        if (!((RecyclerView.l)localObject).h(paramMotionEvent)) {
          break label144;
        }
        this.afK = ((RecyclerView.l)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label159;
        }
        hx();
        return true;
        this.afK.i(paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.afK = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.afG == null);
    boolean bool1 = this.afG.gO();
    boolean bool2 = this.afG.gP();
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.agF;
      this.agF[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.agF[0], this.agF[1]);
    int i = i2;
    switch (k)
    {
    default: 
      i = i2;
    case 4: 
      if (i == 0) {
        this.fB.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    case 0: 
      this.agg = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.agj = i;
      this.agh = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.agk = i;
      this.agi = i;
      if (!bool1) {
        break;
      }
    }
    label780:
    label936:
    label948:
    label966:
    label1103:
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      r(j, 0);
      i = i2;
      break;
      this.agg = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.agj = i;
      this.agh = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.agk = i;
      this.agi = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.agg);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.agg).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.agj - i3;
      k = this.agk - i4;
      j = m;
      i = k;
      if (a(m, k, this.Ld, this.Lc, 0))
      {
        j = m - this.Ld[0];
        i = k - this.Ld[1];
        ((MotionEvent)localObject).offsetLocation(this.Lc[0], this.Lc[1]);
        paramMotionEvent = this.agF;
        paramMotionEvent[0] += this.Lc[0];
        paramMotionEvent = this.agF;
        paramMotionEvent[1] += this.Lc[1];
      }
      k = j;
      m = i;
      if (this.lf != 1)
      {
        if ((!bool1) || (Math.abs(j) <= this.jb)) {
          break label1103;
        }
        if (j <= 0) {
          break label936;
        }
        j -= this.jb;
      }
      label730:
      for (k = 1;; k = 0)
      {
        int n = i;
        int i1 = k;
        if (bool2)
        {
          n = i;
          i1 = k;
          if (Math.abs(i) > this.jb)
          {
            if (i <= 0) {
              break label948;
            }
            i -= this.jb;
            i1 = 1;
            n = i;
          }
        }
        k = j;
        m = n;
        if (i1 != 0)
        {
          setScrollState(1);
          m = n;
          k = j;
        }
        i = i2;
        if (this.lf != 1) {
          break;
        }
        this.agj = (i3 - this.Lc[0]);
        this.agk = (i4 - this.Lc[1]);
        if (bool1)
        {
          i = k;
          label860:
          if (!bool2) {
            break label966;
          }
        }
        for (j = m;; j = 0)
        {
          if (a(i, j, (MotionEvent)localObject)) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
          i = i2;
          if (this.ags == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.ags.b(this, k, m);
          i = i2;
          break;
          j = this.jb + j;
          break label730;
          i = this.jb + i;
          break label780;
          i = 0;
          break label860;
        }
        j(paramMotionEvent);
        i = i2;
        break;
        this.fB.addMovement((MotionEvent)localObject);
        this.fB.computeCurrentVelocity(1000, this.agn);
        float f1;
        if (bool1)
        {
          f1 = -this.fB.getXVelocity(this.agg);
          if (!bool2) {
            break label1087;
          }
        }
        for (float f2 = -this.fB.getYVelocity(this.agg);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!ac((int)f1, (int)f2))) {
            setScrollState(0);
          }
          hw();
          i = 1;
          break;
          f1 = 0.0F;
          break label1026;
        }
        hx();
        i = i2;
        break;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    RecyclerView.v localv = bf(paramView);
    if (localv != null)
    {
      if (!localv.il()) {
        break label36;
      }
      localv.ii();
    }
    label36:
    while (localv.ib())
    {
      paramView.clearAnimation();
      bk(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localv + hl());
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((this.afG.hR()) || (hB())) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramView2 != null)) {
        d(paramView1, paramView2);
      }
      super.requestChildFocus(paramView1, paramView2);
      return;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.afG.a(this, paramView, paramRect, paramBoolean, false);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.afJ.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.l)this.afJ.get(i)).Z(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.afP == 0) && (!this.afR))
    {
      super.requestLayout();
      return;
    }
    this.afQ = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.afG == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.afR);
      bool1 = this.afG.gO();
      bool2 = this.afG.gP();
    } while ((!bool1) && (!bool2));
    if (bool1) {
      if (!bool2) {
        break label64;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label64:
      paramInt2 = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {}
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 0;
    int j = 0;
    if (hB())
    {
      if (paramAccessibilityEvent == null) {
        break label65;
      }
      if (Build.VERSION.SDK_INT < 19) {
        break label51;
      }
      i = paramAccessibilityEvent.getContentChangeTypes();
    }
    for (;;)
    {
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        this.afT |= i;
        i = 1;
        if (i != 0)
        {
          return;
          label51:
          i = 0;
          break;
        }
        super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
        return;
      }
      label65:
      i = 0;
    }
  }
  
  public void setAccessibilityDelegateCompat(ak paramak)
  {
    this.agB = paramak;
    q.a(this, this.agB);
  }
  
  public void setAdapter(a parama)
  {
    setLayoutFrozen(false);
    if (this.Sw != null) {
      this.Sw.b(this.afx);
    }
    hm();
    this.afA.reset();
    a locala = this.Sw;
    this.Sw = parama;
    if (parama != null) {
      parama.a(this.afx);
    }
    Object localObject = this.afy;
    parama = this.Sw;
    ((RecyclerView.o)localObject).clear();
    localObject = ((RecyclerView.o)localObject).getRecycledViewPool();
    if (locala != null) {
      ((RecyclerView.n)localObject).detach();
    }
    if (((RecyclerView.n)localObject).ahm == 0)
    {
      int i = 0;
      while (i < ((RecyclerView.n)localObject).ahl.size())
      {
        ((n.a)((RecyclerView.n)localObject).ahl.valueAt(i)).ahn.clear();
        i += 1;
      }
    }
    if (parama != null) {
      ((RecyclerView.n)localObject).hV();
    }
    this.agu.ahP = true;
    ae(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    if (paramd == this.agC) {
      return;
    }
    this.agC = paramd;
    if (this.agC != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.afD) {
      hv();
    }
    this.afD = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.afO) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(RecyclerView.e parame)
  {
    l.E(parame);
    this.aga = parame;
    hv();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.afM = paramBoolean;
  }
  
  public void setItemAnimator(RecyclerView.f paramf)
  {
    if (this.agf != null)
    {
      this.agf.gC();
      this.agf.agN = null;
    }
    this.agf = paramf;
    if (this.agf != null) {
      this.agf.agN = this.agz;
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    RecyclerView.o localo = this.afy;
    localo.ahv = paramInt;
    localo.hW();
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.afR)
    {
      Q("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.afR = false;
        if ((this.afQ) && (this.afG != null) && (this.Sw != null)) {
          requestLayout();
        }
        this.afQ = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.afR = true;
    this.afS = true;
    hp();
  }
  
  public void setLayoutManager(RecyclerView.i parami)
  {
    if (parami == this.afG) {
      return;
    }
    hp();
    if (this.afG != null)
    {
      if (this.agf != null) {
        this.agf.gC();
      }
      this.afG.d(this.afy);
      this.afG.c(this.afy);
      this.afy.clear();
      if (this.afL) {
        this.afG.b(this, this.afy);
      }
      this.afG.setRecyclerView(null);
      this.afG = null;
    }
    u localu;
    for (;;)
    {
      localu = this.afB;
      for (u.a locala = localu.abi;; locala = locala.abl)
      {
        locala.abk = 0L;
        if (locala.abl == null) {
          break;
        }
      }
      this.afy.clear();
    }
    int i = localu.abj.size() - 1;
    while (i >= 0)
    {
      localu.abh.aV((View)localu.abj.get(i));
      localu.abj.remove(i);
      i -= 1;
    }
    localu.abh.removeAllViews();
    this.afG = parami;
    if (parami != null)
    {
      if (parami.acI != null) {
        throw new IllegalArgumentException("LayoutManager " + parami + " is already attached to a RecyclerView:" + parami.acI.hl());
      }
      this.afG.setRecyclerView(this);
      if (this.afL) {
        this.afG.hD = true;
      }
    }
    this.afy.hW();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(RecyclerView.k paramk)
  {
    this.agl = paramk;
  }
  
  @Deprecated
  public void setOnScrollListener(RecyclerView.m paramm)
  {
    this.agv = paramm;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.agq = paramBoolean;
  }
  
  public void setRecycledViewPool(RecyclerView.n paramn)
  {
    RecyclerView.o localo = this.afy;
    if (localo.ahx != null) {
      localo.ahx.detach();
    }
    localo.ahx = paramn;
    if (paramn != null)
    {
      paramn = localo.ahx;
      localo.agK.getAdapter();
      paramn.hV();
    }
  }
  
  public void setRecyclerListener(RecyclerView.p paramp)
  {
    this.afH = paramp;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.lf) {}
    for (;;)
    {
      return;
      this.lf = paramInt;
      if (paramInt != 2) {
        hq();
      }
      if (this.afG != null) {
        this.afG.bR(paramInt);
      }
      if (this.agv != null) {
        this.agv.c(this, paramInt);
      }
      if (this.agw != null)
      {
        int i = this.agw.size() - 1;
        while (i >= 0)
        {
          ((RecyclerView.m)this.agw.get(i)).c(this, paramInt);
          i -= 1;
        }
      }
    }
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      new StringBuilder("setScrollingTouchSlop(): bad argument constant ").append(paramInt).append("; using default value");
    case 0: 
      this.jb = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    this.jb = localViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public void setViewCacheExtension(RecyclerView.t paramt)
  {
    this.afy.ahy = paramt;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((this.afG != null) && (!this.afR))
    {
      if (!this.afG.gO()) {
        paramInt1 = 0;
      }
      if (this.afG.gP()) {
        break label72;
      }
      paramInt2 = i;
    }
    label72:
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        RecyclerView.u localu = this.agr;
        localu.b(paramInt1, paramInt2, localu.au(paramInt1, paramInt2), agI);
      }
      return;
    }
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    if (this.afR) {}
    while (this.afG == null) {
      return;
    }
    this.afG.a(this, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().r(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().av(0);
  }
  
  public final View y(float paramFloat1, float paramFloat2)
  {
    int i = this.afB.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.afB.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public static abstract class a<VH extends RecyclerView.v>
  {
    public final RecyclerView.b agL = new RecyclerView.b();
    public boolean agM = false;
    
    public abstract VH a(ViewGroup paramViewGroup, int paramInt);
    
    public final void a(RecyclerView.c paramc)
    {
      this.agL.registerObserver(paramc);
    }
    
    public void a(VH paramVH) {}
    
    public abstract void a(VH paramVH, int paramInt);
    
    public void a(VH paramVH, int paramInt, List<Object> paramList)
    {
      a(paramVH, paramInt);
    }
    
    public final void ah(int paramInt1, int paramInt2)
    {
      this.agL.ah(paramInt1, paramInt2);
    }
    
    public final void ai(int paramInt1, int paramInt2)
    {
      this.agL.ai(paramInt1, paramInt2);
    }
    
    public final void aj(int paramInt1, int paramInt2)
    {
      this.agL.aj(paramInt1, paramInt2);
    }
    
    public final void ak(int paramInt1, int paramInt2)
    {
      this.agL.ak(paramInt1, paramInt2);
    }
    
    public final void b(RecyclerView.c paramc)
    {
      this.agL.unregisterObserver(paramc);
    }
    
    public final void bL(int paramInt)
    {
      this.agL.ah(paramInt, 1);
    }
    
    public final void bM(int paramInt)
    {
      this.agL.aj(paramInt, 1);
    }
    
    public final void bN(int paramInt)
    {
      this.agL.ak(paramInt, 1);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      this.agL.c(paramInt1, paramInt2, paramObject);
    }
    
    public final void c(int paramInt, Object paramObject)
    {
      this.agL.c(paramInt, 1, paramObject);
    }
    
    public final VH d(ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        android.support.v4.os.f.beginSection("RV CreateView");
        paramViewGroup = a(paramViewGroup, paramInt);
        if (paramViewGroup.aie.getParent() != null) {
          throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        }
      }
      finally
      {
        android.support.v4.os.f.endSection();
      }
      paramViewGroup.aii = paramInt;
      android.support.v4.os.f.endSection();
      return paramViewGroup;
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final void hO()
    {
      if (this.agL.hasObservers()) {
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      }
      this.agM = true;
    }
  }
  
  public static abstract class c
  {
    public void al(int paramInt1, int paramInt2) {}
    
    public void am(int paramInt1, int paramInt2) {}
    
    public void an(int paramInt1, int paramInt2) {}
    
    public void ao(int paramInt1, int paramInt2) {}
    
    public void d(int paramInt1, int paramInt2, Object paramObject)
    {
      al(paramInt1, paramInt2);
    }
    
    public void onChanged() {}
  }
  
  public static abstract interface d
  {
    public abstract int ap(int paramInt1, int paramInt2);
  }
  
  public static abstract interface j
  {
    public abstract void bu(View paramView);
  }
  
  static final class n$a
  {
    final ArrayList<RecyclerView.v> ahn = new ArrayList();
    int aho = 5;
    long ahp = 0L;
    long ahq = 0L;
  }
  
  public static abstract interface r$b
  {
    public abstract PointF bD(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */