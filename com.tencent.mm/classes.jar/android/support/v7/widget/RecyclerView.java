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
import android.support.v4.os.e;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.a;
import android.support.v4.view.k;
import android.support.v4.view.t;
import android.support.v4.view.u;
import android.support.v7.f.a.a;
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
  implements k
{
  private static final int[] ahE = { 16843830 };
  private static final int[] ahF = { 16842987 };
  static final boolean ahG;
  static final boolean ahH;
  static final boolean ahI;
  private static final boolean ahJ;
  private static final boolean ahK;
  private static final boolean ahL;
  private static final Class<?>[] ahM;
  static final Interpolator aiY;
  private final int[] KN;
  private final int[] KO;
  RecyclerView.a Tg;
  private final RecyclerView.q ahN = new RecyclerView.q(this);
  final RecyclerView.o ahO = new RecyclerView.o(this);
  private RecyclerView.SavedState ahP;
  d ahQ;
  s ahR;
  final bg ahS = new bg();
  boolean ahT;
  final Runnable ahU = new RecyclerView.1(this);
  final RectF ahV = new RectF();
  RecyclerView.i ahW;
  RecyclerView.p ahX;
  public final ArrayList<RecyclerView.h> ahY = new ArrayList();
  private final ArrayList<RecyclerView.l> ahZ = new ArrayList();
  private int aiA;
  private k aiB;
  private final int aiC;
  private final int aiD;
  private float aiE = 1.4E-45F;
  private float aiF = 1.4E-45F;
  private boolean aiG = true;
  final RecyclerView.u aiH = new RecyclerView.u(this);
  ac aiI;
  ac.a aiJ;
  final RecyclerView.s aiK;
  private m aiL;
  private List<m> aiM;
  boolean aiN;
  boolean aiO;
  private RecyclerView.f.b aiP;
  boolean aiQ;
  al aiR;
  private RecyclerView.d aiS;
  private final int[] aiT;
  private android.support.v4.view.l aiU;
  private final int[] aiV;
  final List<RecyclerView.v> aiW;
  private Runnable aiX;
  private final bg.b aiZ;
  private RecyclerView.l aia;
  boolean aib;
  boolean aic;
  boolean aid;
  boolean aie;
  private int aif = 0;
  boolean aig;
  public boolean aih;
  private boolean aii;
  private int aij;
  boolean aik;
  public List<j> ail;
  boolean aim = false;
  boolean ain = false;
  private int aio = 0;
  private int aip = 0;
  private RecyclerView.e aiq = new RecyclerView.e();
  private EdgeEffect air;
  private EdgeEffect ais;
  private EdgeEffect ait;
  private EdgeEffect aiu;
  RecyclerView.f aiv = new v();
  private int aiw = -1;
  private int aix;
  private int aiy;
  private int aiz;
  private final AccessibilityManager fU;
  private final Rect jX = new Rect();
  private int mScrollState = 0;
  final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      ahG = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label167;
      }
      bool = true;
      label62:
      ahH = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label172;
      }
      bool = true;
      label76:
      ahI = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label177;
      }
      bool = true;
      label90:
      ahJ = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label182;
      }
      bool = true;
      label104:
      ahK = bool;
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
      ahL = bool;
      ahM = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      aiY = new RecyclerView.3();
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
    if (ahJ)
    {
      localObject1 = new ac.a();
      this.aiJ = ((ac.a)localObject1);
      this.aiK = new RecyclerView.s();
      this.aiN = false;
      this.aiO = false;
      this.aiP = new RecyclerView.g(this);
      this.aiQ = false;
      this.aiT = new int[2];
      this.KN = new int[2];
      this.KO = new int[2];
      this.aiV = new int[2];
      this.aiW = new ArrayList();
      this.aiX = new RecyclerView.2(this);
      this.aiZ = new RecyclerView.4(this);
      if (paramAttributeSet == null) {
        break label678;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, ahF, paramInt, 0);
      this.ahT = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
      label351:
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject1 = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
      this.aiE = u.a((ViewConfiguration)localObject1, paramContext);
      this.aiF = u.b((ViewConfiguration)localObject1, paramContext);
      this.aiC = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
      this.aiD = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
      if (getOverScrollMode() != 2) {
        break label686;
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    StateListDrawable localStateListDrawable;
    Drawable localDrawable;
    label678:
    label686:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      this.aiv.ajd = this.aiP;
      this.ahQ = new d(new RecyclerView.6(this));
      this.ahR = new s(new RecyclerView.5(this));
      if (t.S(this) == 0) {
        t.o(this, 1);
      }
      this.fU = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new al(this));
      if (paramAttributeSet == null) {
        break label1257;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt, 0);
      localObject2 = ((TypedArray)localObject1).getString(2);
      if (((TypedArray)localObject1).getInt(1, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.aid = ((TypedArray)localObject1).getBoolean(6, false);
      if (!this.aid) {
        break label742;
      }
      localObject3 = (StateListDrawable)((TypedArray)localObject1).getDrawable(7);
      localObject4 = ((TypedArray)localObject1).getDrawable(8);
      localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(9);
      localDrawable = ((TypedArray)localObject1).getDrawable(10);
      if ((localObject3 != null) && (localObject4 != null) && (localStateListDrawable != null) && (localDrawable != null)) {
        break label692;
      }
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + iM());
      localObject1 = null;
      break;
      this.ahT = true;
      break label351;
    }
    label692:
    Resources localResources = getContext().getResources();
    new z(this, (StateListDrawable)localObject3, (Drawable)localObject4, localStateListDrawable, localDrawable, localResources.getDimensionPixelSize(2131428417), localResources.getDimensionPixelSize(2131428419), localResources.getDimensionPixelOffset(2131428418));
    label742:
    ((TypedArray)localObject1).recycle();
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).trim();
      if (!((String)localObject1).isEmpty())
      {
        if (((String)localObject1).charAt(0) != '.') {
          break label932;
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
          localObject3 = ((Class)localObject4).getConstructor(ahM);
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
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ahE, paramInt, 0);
          bool = paramContext.getBoolean(0, true);
          paramContext.recycle();
          setNestedScrollingEnabled(bool);
          return;
          label932:
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
      label1257:
      bool = true;
    }
  }
  
  private void a(long paramLong, RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    int j = this.ahR.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.v localv = bp(this.ahR.getChildAt(i));
      if ((localv != paramv1) && (g(localv) == paramLong))
      {
        if ((this.Tg != null) && (this.Tg.ajc)) {
          throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + iM());
        }
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + iM());
      }
      i += 1;
    }
    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(paramv2).append(" cannot be found but it is necessary for ").append(paramv1).append(iM());
  }
  
  private void a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramv1.ap(false);
    if (paramBoolean1) {
      f(paramv1);
    }
    if (paramv1 != paramv2)
    {
      if (paramBoolean2) {
        f(paramv2);
      }
      paramv1.akA = paramv2;
      f(paramv1);
      this.ahO.t(paramv1);
      paramv2.ap(false);
      paramv2.akB = paramv1;
    }
    if (this.aiv.a(paramv1, paramv2, paramc1, paramc2)) {
      je();
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    iO();
    int j;
    int i;
    int m;
    int k;
    if (this.Tg != null)
    {
      iP();
      ja();
      e.beginSection("RV Scroll");
      m(this.aiK);
      if (paramInt1 != 0)
      {
        j = this.ahW.a(paramInt1, this.ahO, this.aiK);
        i = paramInt1 - j;
        if (paramInt2 != 0)
        {
          m = this.ahW.b(paramInt2, this.ahO, this.aiK);
          k = paramInt2 - m;
          label92:
          e.endSection();
          jt();
          am(true);
          al(false);
        }
      }
    }
    for (;;)
    {
      if (!this.ahY.isEmpty()) {
        invalidate();
      }
      if (a(j, m, i, k, this.KN, 0))
      {
        this.aiz -= this.KN[0];
        this.aiA -= this.KN[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.KN[0], this.KN[1]);
        }
        paramMotionEvent = this.aiV;
        paramMotionEvent[0] += this.KN[0];
        paramMotionEvent = this.aiV;
        paramMotionEvent[1] += this.KN[1];
      }
      for (;;)
      {
        if ((j != 0) || (m != 0)) {
          am(j, m);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((j != 0) || (m != 0)) {
          bool = true;
        }
        return bool;
        if (getOverScrollMode() != 2)
        {
          if ((paramMotionEvent != null) && (!android.support.v4.view.i.d(paramMotionEvent))) {
            e(paramMotionEvent.getX(), i, paramMotionEvent.getY(), k);
          }
          ah(paramInt1, paramInt2);
        }
      }
      m = 0;
      k = 0;
      break label92;
      j = 0;
      i = 0;
      break;
      m = 0;
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  private boolean ak(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    m(this.aiT);
    if ((this.aiT[0] != paramInt1) || (this.aiT[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  static RecyclerView.v bp(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ajy;
  }
  
  public static int bq(View paramView)
  {
    paramView = bp(paramView);
    if (paramView != null) {
      return paramView.jN();
    }
    return -1;
  }
  
  public static int br(View paramView)
  {
    paramView = bp(paramView);
    if (paramView != null) {
      return paramView.jM();
    }
    return -1;
  }
  
  static RecyclerView bt(View paramView)
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
      RecyclerView localRecyclerView = bt(paramView.getChildAt(i));
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
      this.mTempRect.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams))
      {
        localObject = (RecyclerView.LayoutParams)localObject;
        if (!((RecyclerView.LayoutParams)localObject).ajz)
        {
          localObject = ((RecyclerView.LayoutParams)localObject).afM;
          localRect = this.mTempRect;
          localRect.left -= ((Rect)localObject).left;
          localRect = this.mTempRect;
          localRect.right += ((Rect)localObject).right;
          localRect = this.mTempRect;
          localRect.top -= ((Rect)localObject).top;
          localRect = this.mTempRect;
          int i = localRect.bottom;
          localRect.bottom = (((Rect)localObject).bottom + i);
        }
      }
      if (paramView2 != null)
      {
        offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
        offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
      }
      localObject = this.ahW;
      localRect = this.mTempRect;
      if (this.aie) {
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
  
  private void e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      iT();
      android.support.v4.widget.i.a(this.air, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label141;
      }
      iV();
      android.support.v4.widget.i.a(this.ais, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    for (;;)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        t.R(this);
      }
      return;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      iU();
      android.support.v4.widget.i.a(this.ait, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label141:
      if (paramFloat4 > 0.0F)
      {
        iW();
        android.support.v4.widget.i.a(this.aiu, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  static void e(View paramView, Rect paramRect)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.afM;
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
  
  private long g(RecyclerView.v paramv)
  {
    if (this.Tg.ajc) {
      return paramv.akx;
    }
    return paramv.mPosition;
  }
  
  static void h(RecyclerView.v paramv)
  {
    Object localObject;
    if (paramv.akv != null) {
      localObject = (View)paramv.akv.get();
    }
    while (localObject != null)
    {
      if (localObject == paramv.aku) {
        return;
      }
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof View)) {
        localObject = (View)localObject;
      } else {
        localObject = null;
      }
    }
    paramv.akv = null;
  }
  
  private void iR()
  {
    this.aiH.stop();
    if (this.ahW != null) {
      this.ahW.jB();
    }
  }
  
  private void iS()
  {
    boolean bool2 = false;
    if (this.air != null)
    {
      this.air.onRelease();
      bool2 = this.air.isFinished();
    }
    boolean bool1 = bool2;
    if (this.ais != null)
    {
      this.ais.onRelease();
      bool1 = bool2 | this.ais.isFinished();
    }
    bool2 = bool1;
    if (this.ait != null)
    {
      this.ait.onRelease();
      bool2 = bool1 | this.ait.isFinished();
    }
    bool1 = bool2;
    if (this.aiu != null)
    {
      this.aiu.onRelease();
      bool1 = bool2 | this.aiu.isFinished();
    }
    if (bool1) {
      t.R(this);
    }
  }
  
  private void iT()
  {
    if (this.air != null) {
      return;
    }
    this.air = RecyclerView.e.d(this);
    if (this.ahT)
    {
      this.air.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.air.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void iU()
  {
    if (this.ait != null) {
      return;
    }
    this.ait = RecyclerView.e.d(this);
    if (this.ahT)
    {
      this.ait.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.ait.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void iV()
  {
    if (this.ais != null) {
      return;
    }
    this.ais = RecyclerView.e.d(this);
    if (this.ahT)
    {
      this.ais.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.ais.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void iW()
  {
    if (this.aiu != null) {
      return;
    }
    this.aiu = RecyclerView.e.d(this);
    if (this.ahT)
    {
      this.aiu.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.aiu.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void iX()
  {
    this.aiu = null;
    this.ais = null;
    this.ait = null;
    this.air = null;
  }
  
  private void iY()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    av(0);
    iS();
  }
  
  private void iZ()
  {
    iY();
    setScrollState(0);
  }
  
  private void j(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.aiw) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.aiw = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.aiz = j;
      this.aix = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.aiA = i;
      this.aiy = i;
      return;
    }
  }
  
  private void jc()
  {
    int i = this.aij;
    this.aij = 0;
    if ((i != 0) && (jb()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      a.a(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private boolean jf()
  {
    return (this.aiv != null) && (this.ahW.ih());
  }
  
  private void jg()
  {
    boolean bool2 = true;
    if (this.aim)
    {
      this.ahQ.reset();
      if (this.ain) {
        this.ahW.a(this);
      }
    }
    int i;
    label61:
    RecyclerView.s locals;
    if (jf())
    {
      this.ahQ.gW();
      if ((!this.aiN) && (!this.aiO)) {
        break label180;
      }
      i = 1;
      locals = this.aiK;
      if ((!this.aie) || (this.aiv == null) || ((!this.aim) && (i == 0) && (!this.ahW.ajp)) || ((this.aim) && (!this.Tg.ajc))) {
        break label185;
      }
      bool1 = true;
      label121:
      locals.akj = bool1;
      locals = this.aiK;
      if ((!this.aiK.akj) || (i == 0) || (this.aim) || (!jf())) {
        break label190;
      }
    }
    label180:
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locals.akk = bool1;
      return;
      this.ahQ.gZ();
      break;
      i = 0;
      break label61;
      bool1 = false;
      break label121;
    }
  }
  
  private void jh()
  {
    if (this.Tg == null) {}
    while (this.ahW == null) {
      return;
    }
    this.aiK.aki = false;
    if (this.aiK.akd == 1)
    {
      jl();
      this.ahW.g(this);
      jm();
    }
    for (;;)
    {
      jn();
      return;
      if ((this.ahQ.ha()) || (this.ahW.mWidth != getWidth()) || (this.ahW.mHeight != getHeight()))
      {
        this.ahW.g(this);
        jm();
      }
      else
      {
        this.ahW.g(this);
      }
    }
  }
  
  private void ji()
  {
    if ((this.aiG) && (hasFocus()) && (this.Tg != null)) {}
    for (Object localObject1 = getFocusedChild();; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = bo((View)localObject1))
      {
        jj();
        return;
      }
      Object localObject2 = this.aiK;
      long l;
      int i;
      if (this.Tg.ajc)
      {
        l = ((RecyclerView.v)localObject1).akx;
        ((RecyclerView.s)localObject2).akm = l;
        localObject2 = this.aiK;
        if (!this.aim) {
          break label191;
        }
        i = -1;
      }
      RecyclerView.s locals;
      for (;;)
      {
        ((RecyclerView.s)localObject2).akl = i;
        locals = this.aiK;
        localObject1 = ((RecyclerView.v)localObject1).aku;
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
        label191:
        if (((RecyclerView.v)localObject1).isRemoved()) {
          i = ((RecyclerView.v)localObject1).akw;
        } else {
          i = ((RecyclerView.v)localObject1).jN();
        }
      }
      locals.akn = i;
      return;
    }
  }
  
  private void jj()
  {
    this.aiK.akm = -1L;
    this.aiK.akl = -1;
    this.aiK.akn = -1;
  }
  
  private void jk()
  {
    Object localObject3 = null;
    if ((!this.aiG) || (this.Tg == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused()))) {}
    Object localObject1;
    do
    {
      return;
      if (isFocused()) {
        break;
      }
      localObject1 = getFocusedChild();
      if ((ahL) && ((((View)localObject1).getParent() == null) || (!((View)localObject1).hasFocus())))
      {
        if (this.ahR.getChildCount() != 0) {
          break;
        }
        requestFocus();
        return;
      }
    } while (!this.ahR.ba((View)localObject1));
    long l;
    if ((this.aiK.akm != -1L) && (this.Tg.ajc))
    {
      l = this.aiK.akm;
      if ((this.Tg == null) || (!this.Tg.ajc)) {
        localObject1 = null;
      }
    }
    for (;;)
    {
      label168:
      int i;
      label228:
      int k;
      int j;
      label238:
      Object localObject2;
      if ((localObject1 == null) || (this.ahR.ba(((RecyclerView.v)localObject1).aku)) || (!((RecyclerView.v)localObject1).aku.hasFocusable()))
      {
        if (this.ahR.getChildCount() <= 0) {
          break label504;
        }
        if (this.aiK.akl != -1)
        {
          i = this.aiK.akl;
          k = this.aiK.getItemCount();
          j = i;
          if (j >= k) {
            break label431;
          }
          localObject1 = bQ(j);
          if (localObject1 == null) {
            break label431;
          }
          if (!((RecyclerView.v)localObject1).aku.hasFocusable()) {
            break label424;
          }
          localObject1 = ((RecyclerView.v)localObject1).aku;
          label273:
          if (localObject1 == null) {
            break label508;
          }
          if (this.aiK.akn == -1L) {
            break label501;
          }
          localObject2 = ((View)localObject1).findViewById(this.aiK.akn);
          if ((localObject2 == null) || (!((View)localObject2).isFocusable())) {
            break label501;
          }
          localObject1 = localObject2;
          label324:
          ((View)localObject1).requestFocus();
          return;
          j = this.ahR.hx();
          i = 0;
          localObject1 = null;
          label344:
          if (i < j)
          {
            localObject2 = bp(this.ahR.bt(i));
            if ((localObject2 == null) || (((RecyclerView.v)localObject2).isRemoved()) || (((RecyclerView.v)localObject2).akx != l)) {
              break label510;
            }
            localObject1 = localObject2;
            if (!this.ahR.ba(((RecyclerView.v)localObject2).aku)) {
              continue;
            }
            localObject1 = localObject2;
          }
        }
      }
      label424:
      label431:
      label501:
      label504:
      label508:
      label510:
      for (;;)
      {
        i += 1;
        break label344;
        break label168;
        i = 0;
        break label228;
        j += 1;
        break label238;
        i = Math.min(k, i) - 1;
        for (;;)
        {
          localObject1 = localObject3;
          if (i < 0) {
            break;
          }
          localObject2 = bQ(i);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break;
          }
          if (((RecyclerView.v)localObject2).aku.hasFocusable())
          {
            localObject1 = ((RecyclerView.v)localObject2).aku;
            break;
          }
          i -= 1;
        }
        localObject1 = ((RecyclerView.v)localObject1).aku;
        break label273;
        break label324;
        localObject1 = null;
        break label273;
        break;
      }
      localObject1 = null;
    }
  }
  
  private void jl()
  {
    this.aiK.ch(1);
    m(this.aiK);
    this.aiK.aki = false;
    iP();
    this.ahS.clear();
    ja();
    jg();
    ji();
    Object localObject = this.aiK;
    if ((this.aiK.akj) && (this.aiO)) {}
    int j;
    int i;
    RecyclerView.f.c localc;
    for (boolean bool = true;; bool = false)
    {
      ((RecyclerView.s)localObject).akh = bool;
      this.aiO = false;
      this.aiN = false;
      this.aiK.akg = this.aiK.akk;
      this.aiK.ake = this.Tg.getItemCount();
      m(this.aiT);
      if (!this.aiK.akj) {
        break;
      }
      j = this.ahR.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = bp(this.ahR.getChildAt(i));
        if ((!((RecyclerView.v)localObject).jL()) && ((!((RecyclerView.v)localObject).jU()) || (this.Tg.ajc)))
        {
          localc = this.aiv.a(this.aiK, (RecyclerView.v)localObject, RecyclerView.f.l((RecyclerView.v)localObject), ((RecyclerView.v)localObject).jZ());
          this.ahS.b((RecyclerView.v)localObject, localc);
          if ((this.aiK.akh) && (((RecyclerView.v)localObject).kb()) && (!((RecyclerView.v)localObject).isRemoved()) && (!((RecyclerView.v)localObject).jL()) && (!((RecyclerView.v)localObject).jU()))
          {
            long l = g((RecyclerView.v)localObject);
            this.ahS.a(l, (RecyclerView.v)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.aiK.akk)
    {
      jp();
      bool = this.aiK.akf;
      this.aiK.akf = false;
      this.ahW.c(this.ahO, this.aiK);
      this.aiK.akf = bool;
      i = 0;
      if (i < this.ahR.getChildCount())
      {
        localObject = bp(this.ahR.getChildAt(i));
        if ((!((RecyclerView.v)localObject).jL()) && (!this.ahS.I((RecyclerView.v)localObject)))
        {
          int k = RecyclerView.f.l((RecyclerView.v)localObject);
          bool = ((RecyclerView.v)localObject).ci(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localc = this.aiv.a(this.aiK, (RecyclerView.v)localObject, j, ((RecyclerView.v)localObject).jZ());
          if (!bool) {
            break label471;
          }
          a((RecyclerView.v)localObject, localc);
        }
        for (;;)
        {
          i += 1;
          break;
          label471:
          this.ahS.c((RecyclerView.v)localObject, localc);
        }
      }
      jq();
    }
    for (;;)
    {
      am(true);
      al(false);
      this.aiK.akd = 2;
      return;
      jq();
    }
  }
  
  private void jm()
  {
    iP();
    ja();
    this.aiK.ch(6);
    this.ahQ.gZ();
    this.aiK.ake = this.Tg.getItemCount();
    this.aiK.akc = 0;
    this.aiK.akg = false;
    this.ahW.c(this.ahO, this.aiK);
    this.aiK.akf = false;
    this.ahP = null;
    RecyclerView.s locals = this.aiK;
    if ((this.aiK.akj) && (this.aiv != null)) {}
    for (boolean bool = true;; bool = false)
    {
      locals.akj = bool;
      this.aiK.akd = 4;
      am(true);
      al(false);
      return;
    }
  }
  
  private void jn()
  {
    this.aiK.ch(4);
    iP();
    ja();
    this.aiK.akd = 1;
    if (this.aiK.akj)
    {
      int i = this.ahR.getChildCount() - 1;
      if (i >= 0)
      {
        RecyclerView.v localv1 = bp(this.ahR.getChildAt(i));
        RecyclerView.f.c localc2;
        RecyclerView.v localv2;
        boolean bool1;
        boolean bool2;
        RecyclerView.f.c localc1;
        if (!localv1.jL())
        {
          long l = g(localv1);
          localc2 = new RecyclerView.f.c().c(localv1, 0);
          localv2 = this.ahS.k(l);
          if ((localv2 == null) || (localv2.jL())) {
            break label224;
          }
          bool1 = this.ahS.H(localv2);
          bool2 = this.ahS.H(localv1);
          if ((bool1) && (localv2 == localv1)) {
            break label224;
          }
          localc1 = this.ahS.d(localv2, 4);
          this.ahS.d(localv1, localc2);
          localc2 = this.ahS.d(localv1, 8);
          if (localc1 != null) {
            break label205;
          }
          a(l, localv1, localv2);
        }
        for (;;)
        {
          i -= 1;
          break;
          label205:
          a(localv2, localv1, localc1, localc2, bool1, bool2);
          continue;
          label224:
          this.ahS.d(localv1, localc2);
        }
      }
      this.ahS.a(this.aiZ);
    }
    this.ahW.c(this.ahO);
    this.aiK.akb = this.aiK.ake;
    this.aim = false;
    this.ain = false;
    this.aiK.akj = false;
    this.aiK.akk = false;
    this.ahW.ajp = false;
    if (this.ahO.ajI != null) {
      this.ahO.ajI.clear();
    }
    if (this.ahW.aju)
    {
      this.ahW.ajt = 0;
      this.ahW.aju = false;
      this.ahO.jF();
    }
    this.ahW.a(this.aiK);
    am(true);
    al(false);
    this.ahS.clear();
    if (ak(this.aiT[0], this.aiT[1])) {
      am(0, 0);
    }
    jk();
    jj();
  }
  
  private void jo()
  {
    int j = this.ahR.hx();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.LayoutParams)this.ahR.bt(i).getLayoutParams()).ajz = true;
      i += 1;
    }
    this.ahO.jo();
  }
  
  private void jp()
  {
    int j = this.ahR.hx();
    int i = 0;
    while (i < j)
    {
      RecyclerView.v localv = bp(this.ahR.bt(i));
      if (!localv.jL()) {
        localv.jK();
      }
      i += 1;
    }
  }
  
  private void jq()
  {
    int j = this.ahR.hx();
    int i = 0;
    while (i < j)
    {
      RecyclerView.v localv = bp(this.ahR.bt(i));
      if (!localv.jL()) {
        localv.jJ();
      }
      i += 1;
    }
    this.ahO.jq();
  }
  
  private void jr()
  {
    int j = this.ahR.hx();
    int i = 0;
    while (i < j)
    {
      RecyclerView.v localv = bp(this.ahR.bt(i));
      if ((localv != null) && (!localv.jL())) {
        localv.addFlags(6);
      }
      i += 1;
    }
    jo();
    this.ahO.jr();
  }
  
  private void ju()
  {
    int i = this.aiW.size() - 1;
    while (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)this.aiW.get(i);
      if ((localv.aku.getParent() == this) && (!localv.jL()))
      {
        int j = localv.akJ;
        if (j != -1)
        {
          t.o(localv.aku, j);
          localv.akJ = -1;
        }
      }
      i -= 1;
    }
    this.aiW.clear();
  }
  
  private void m(int[] paramArrayOfInt)
  {
    int i2 = this.ahR.getChildCount();
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
      RecyclerView.v localv = bp(this.ahR.getChildAt(n));
      m = i;
      if (localv.jL()) {
        break label122;
      }
      int i1 = localv.jM();
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
  
  private boolean r(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().r(paramInt1, paramInt2);
  }
  
  final void S(String paramString)
  {
    if (jd())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + iM());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.aip > 0) {
      new IllegalStateException(iM());
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = 0;
    if (this.ahW == null) {}
    for (;;)
    {
      return;
      if (!this.aih)
      {
        if (!this.ahW.ij()) {
          paramInt1 = 0;
        }
        if (!this.ahW.ik()) {
          paramInt2 = i;
        }
        while ((paramInt1 != 0) || (paramInt2 != 0))
        {
          this.aiH.a(paramInt1, paramInt2, paramInterpolator);
          return;
        }
      }
    }
  }
  
  public final void a(RecyclerView.h paramh)
  {
    if (this.ahW != null) {
      this.ahW.S("Cannot add item decoration during a scroll  or layout");
    }
    if (this.ahY.isEmpty()) {
      setWillNotDraw(false);
    }
    this.ahY.add(paramh);
    jo();
    requestLayout();
  }
  
  public final void a(RecyclerView.l paraml)
  {
    this.ahZ.add(paraml);
  }
  
  public final void a(m paramm)
  {
    if (this.aiM == null) {
      this.aiM = new ArrayList();
    }
    this.aiM.add(paramm);
  }
  
  final void a(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    paramv.setFlags(0, 8192);
    if ((this.aiK.akh) && (paramv.kb()) && (!paramv.isRemoved()) && (!paramv.jL()))
    {
      long l = g(paramv);
      this.ahS.a(l, paramv);
    }
    this.ahS.b(paramv, paramc);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((this.ahW == null) || (!this.ahW.a(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public boolean ag(int paramInt1, int paramInt2)
  {
    if (this.ahW == null) {}
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
        } while (this.aih);
        bool2 = this.ahW.ij();
        bool3 = this.ahW.ik();
        if (bool2)
        {
          i = paramInt1;
          if (Math.abs(paramInt1) >= this.aiC) {}
        }
        else
        {
          i = 0;
        }
        if (bool3)
        {
          j = paramInt2;
          if (Math.abs(paramInt2) >= this.aiC) {}
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
        if ((this.aiB == null) || (!this.aiB.aA(i, j))) {
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
      paramInt1 = Math.max(-this.aiD, Math.min(i, this.aiD));
      paramInt2 = Math.max(-this.aiD, Math.min(j, this.aiD));
      RecyclerView.u localu = this.aiH;
      localu.aja.setScrollState(2);
      localu.akr = 0;
      localu.akq = 0;
      localu.jR.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      localu.jI();
      return true;
    }
  }
  
  final void ah(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.air != null)
    {
      bool1 = bool2;
      if (!this.air.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.air.onRelease();
          bool1 = this.air.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.ait != null)
    {
      bool2 = bool1;
      if (!this.ait.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.ait.onRelease();
          bool2 = bool1 | this.ait.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.ais != null)
    {
      bool1 = bool2;
      if (!this.ais.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.ais.onRelease();
          bool1 = bool2 | this.ais.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.aiu != null)
    {
      bool2 = bool1;
      if (!this.aiu.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.aiu.onRelease();
          bool2 = bool1 | this.aiu.isFinished();
        }
      }
    }
    if (bool2) {
      t.R(this);
    }
  }
  
  final void ai(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      iT();
      this.air.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label66;
      }
      iV();
      this.ais.onAbsorb(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        t.R(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      iU();
      this.ait.onAbsorb(paramInt1);
      break;
      label66:
      if (paramInt2 > 0)
      {
        iW();
        this.aiu.onAbsorb(paramInt2);
      }
    }
  }
  
  final void aj(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(RecyclerView.i.k(paramInt1, getPaddingLeft() + getPaddingRight(), t.Z(this)), RecyclerView.i.k(paramInt2, getPaddingTop() + getPaddingBottom(), t.aa(this)));
  }
  
  public void al(int paramInt1, int paramInt2) {}
  
  final void al(boolean paramBoolean)
  {
    if (this.aif <= 0) {
      this.aif = 1;
    }
    if ((!paramBoolean) && (!this.aih)) {
      this.aig = false;
    }
    if (this.aif == 1)
    {
      if ((paramBoolean) && (this.aig) && (!this.aih) && (this.ahW != null) && (this.Tg != null)) {
        jh();
      }
      if (!this.aih) {
        this.aig = false;
      }
    }
    this.aif -= 1;
  }
  
  final void am(int paramInt1, int paramInt2)
  {
    this.aip += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    al(paramInt1, paramInt2);
    if (this.aiL != null) {
      this.aiL.a(this, paramInt1, paramInt2);
    }
    if (this.aiM != null)
    {
      i = this.aiM.size() - 1;
      while (i >= 0)
      {
        ((m)this.aiM.get(i)).a(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.aip -= 1;
  }
  
  final void am(boolean paramBoolean)
  {
    this.aio -= 1;
    if (this.aio <= 0)
    {
      this.aio = 0;
      if (paramBoolean)
      {
        jc();
        ju();
      }
    }
  }
  
  final void an(boolean paramBoolean)
  {
    this.ain |= paramBoolean;
    this.aim = true;
    jr();
  }
  
  public final void av(int paramInt)
  {
    getScrollingChildHelper().av(paramInt);
  }
  
  public final void b(RecyclerView.h paramh)
  {
    a(paramh);
  }
  
  public final void b(RecyclerView.l paraml)
  {
    this.ahZ.remove(paraml);
    if (this.aia == paraml) {
      this.aia = null;
    }
  }
  
  public final void b(m paramm)
  {
    if (this.aiM != null) {
      this.aiM.remove(paramm);
    }
  }
  
  final boolean b(RecyclerView.v paramv, int paramInt)
  {
    if (jd())
    {
      paramv.akJ = paramInt;
      this.aiW.add(paramv);
      return false;
    }
    t.o(paramv.aku, paramInt);
    return true;
  }
  
  public void bJ(int paramInt)
  {
    if (this.aih) {}
    do
    {
      return;
      iQ();
    } while (this.ahW == null);
    this.ahW.bJ(paramInt);
    awakenScrollBars();
  }
  
  final void bO(int paramInt)
  {
    if (this.ahW == null) {
      return;
    }
    this.ahW.bJ(paramInt);
    awakenScrollBars();
  }
  
  public final void bP(int paramInt)
  {
    a(0, paramInt, null);
  }
  
  public final RecyclerView.v bQ(int paramInt)
  {
    Object localObject = null;
    if (this.aim) {}
    int i;
    RecyclerView.v localv;
    do
    {
      return localObject;
      int j = this.ahR.hx();
      i = 0;
      localObject = null;
      if (i >= j) {
        break;
      }
      localv = bp(this.ahR.bt(i));
      if ((localv == null) || (localv.isRemoved()) || (i(localv) != paramInt)) {
        break label100;
      }
      localObject = localv;
    } while (!this.ahR.ba(localv.aku));
    localObject = localv;
    label100:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public final RecyclerView.v bb(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return bp(paramView);
  }
  
  public final View bn(View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this) {
      return paramView;
    }
    return null;
  }
  
  public final RecyclerView.v bo(View paramView)
  {
    paramView = bn(paramView);
    if (paramView == null) {
      return null;
    }
    return bb(paramView);
  }
  
  final Rect bs(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.ajz) {
      return localLayoutParams.afM;
    }
    if ((this.aiK.akg) && ((localLayoutParams.ajy.kb()) || (localLayoutParams.ajy.jU()))) {
      return localLayoutParams.afM;
    }
    Rect localRect = localLayoutParams.afM;
    localRect.set(0, 0, 0, 0);
    int j = this.ahY.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((RecyclerView.h)this.ahY.get(i)).a(this.mTempRect, paramView, this, this.aiK);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.ajz = false;
    return localRect;
  }
  
  final void bu(View paramView)
  {
    bp(paramView);
    if (this.ail != null)
    {
      int i = this.ail.size() - 1;
      while (i >= 0)
      {
        ((j)this.ail.get(i)).bJ(paramView);
        i -= 1;
      }
    }
  }
  
  public final void c(RecyclerView.h paramh)
  {
    if (this.ahW != null) {
      this.ahW.S("Cannot remove item decoration during a scroll  or layout");
    }
    this.ahY.remove(paramh);
    if (this.ahY.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      jo();
      requestLayout();
      return;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof RecyclerView.LayoutParams)) && (this.ahW.a((RecyclerView.LayoutParams)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.ahW == null) {}
    while (!this.ahW.ij()) {
      return 0;
    }
    return this.ahW.f(this.aiK);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.ahW == null) {}
    while (!this.ahW.ij()) {
      return 0;
    }
    return this.ahW.d(this.aiK);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.ahW == null) {}
    while (!this.ahW.ij()) {
      return 0;
    }
    return this.ahW.h(this.aiK);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.ahW == null) {}
    while (!this.ahW.ik()) {
      return 0;
    }
    return this.ahW.g(this.aiK);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.ahW == null) {}
    while (!this.ahW.ik()) {
      return 0;
    }
    return this.ahW.e(this.aiK);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.ahW == null) {}
    while (!this.ahW.ik()) {
      return 0;
    }
    return this.ahW.i(this.aiK);
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
    int j = this.ahY.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.h)this.ahY.get(i)).a(paramCanvas, this);
      i += 1;
    }
    int n;
    if ((this.air != null) && (!this.air.isFinished()))
    {
      n = paramCanvas.save();
      if (this.ahT)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.air == null) || (!this.air.draw(paramCanvas))) {
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
      if (this.ais != null)
      {
        i = j;
        if (!this.ais.isFinished())
        {
          n = paramCanvas.save();
          if (this.ahT) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.ais == null) || (!this.ais.draw(paramCanvas))) {
            break label457;
          }
          i = 1;
          label198:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.ait != null)
      {
        j = i;
        if (!this.ait.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.ahT) {
            break label462;
          }
          j = getPaddingTop();
          label253:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.ait == null) || (!this.ait.draw(paramCanvas))) {
            break label467;
          }
          j = 1;
          label291:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.aiu != null)
      {
        i = j;
        if (!this.aiu.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.ahT) {
            break label472;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label368:
          i = m;
          if (this.aiu != null)
          {
            i = m;
            if (this.aiu.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.aiv != null) && (this.ahY.size() > 0) && (this.aiv.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          t.R(this);
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
  
  final void e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.ahR.hx();
    int i = 0;
    if (i < j)
    {
      localObject = bp(this.ahR.bt(i));
      if ((localObject != null) && (!((RecyclerView.v)localObject).jL()))
      {
        if (((RecyclerView.v)localObject).mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        ((RecyclerView.v)localObject).l(-paramInt2, paramBoolean);
        this.aiK.akf = true;
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
          ((RecyclerView.v)localObject).l(k, paramBoolean);
          ((RecyclerView.v)localObject).mPosition = (paramInt1 - 1);
          this.aiK.akf = true;
        }
      }
    }
    Object localObject = this.ahO;
    i = ((RecyclerView.o)localObject).ajJ.size() - 1;
    if (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)((RecyclerView.o)localObject).ajJ.get(i);
      if (localv != null)
      {
        if (localv.mPosition < paramInt1 + paramInt2) {
          break label200;
        }
        localv.l(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label200:
        if (localv.mPosition >= paramInt1)
        {
          localv.addFlags(8);
          ((RecyclerView.o)localObject).cd(i);
        }
      }
    }
    requestLayout();
  }
  
  final void f(RecyclerView.v paramv)
  {
    View localView = paramv.aku;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.ahO.t(bb(localView));
      if (!paramv.jW()) {
        break;
      }
      this.ahR.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.ahR.a(localView, -1, true);
      return;
    }
    paramv = this.ahR;
    i = paramv.abS.indexOfChild(localView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localView)));
    }
    paramv.abT.set(i);
    paramv.aY(localView);
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int i1 = -1;
    int n = 0;
    int i;
    Object localObject;
    label74:
    int k;
    if ((this.Tg != null) && (this.ahW != null) && (!jd()) && (!this.aih))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label327;
      }
      if (!this.ahW.ik()) {
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
      if (ahK) {
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
        if (this.ahW.ij())
        {
          if (t.T(this.ahW.adt) != 1) {
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
        if (ahK)
        {
          k = i;
          m = j;
        }
        if (m == 0) {
          break label288;
        }
        iO();
        if (bn(paramView) != null) {
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
      iP();
      this.ahW.a(paramView, k, this.ahO, this.aiK);
      al(false);
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
              iO();
              if (bn(paramView) == null) {
                return null;
              }
              iP();
              localObject = this.ahW.a(paramView, paramInt, this.ahO, this.aiK);
              al(false);
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
          if (bn((View)localObject) != null) {
            if (paramView == null)
            {
              paramInt = 1;
            }
            else if (bn(paramView) == null)
            {
              paramInt = 1;
            }
            else
            {
              this.mTempRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
              this.jX.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.mTempRect);
              offsetDescendantRectToMyCoords((View)localObject, this.jX);
              if (t.T(this.ahW.adt) == 1)
              {
                m = -1;
                if (((this.mTempRect.left >= this.jX.left) && (this.mTempRect.right > this.jX.left)) || (this.mTempRect.right >= this.jX.right)) {
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
        if (((this.mTempRect.top < this.jX.top) || (this.mTempRect.bottom <= this.jX.top)) && (this.mTempRect.bottom < this.jX.bottom)) {
          j = 1;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            throw new IllegalArgumentException("Invalid direction: " + k + iM());
            m = 1;
            break label547;
            label755:
            if (((this.mTempRect.right <= this.jX.right) && (this.mTempRect.left < this.jX.right)) || (this.mTempRect.left <= this.jX.left)) {
              break label986;
            }
            i = -1;
            break label600;
            if ((this.mTempRect.bottom > this.jX.bottom) || (this.mTempRect.top >= this.jX.bottom))
            {
              j = i1;
              if (this.mTempRect.top > this.jX.top) {}
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
    if (this.ahW == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + iM());
    }
    return this.ahW.ic();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.ahW == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + iM());
    }
    return this.ahW.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.ahW == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + iM());
    }
    return this.ahW.d(paramLayoutParams);
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.Tg;
  }
  
  public int getBaseline()
  {
    if (this.ahW != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.aiS == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.aiS.av(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return this.ahT;
  }
  
  public al getCompatAccessibilityDelegate()
  {
    return this.aiR;
  }
  
  public RecyclerView.e getEdgeEffectFactory()
  {
    return this.aiq;
  }
  
  public RecyclerView.f getItemAnimator()
  {
    return this.aiv;
  }
  
  public int getItemDecorationCount()
  {
    return this.ahY.size();
  }
  
  public RecyclerView.i getLayoutManager()
  {
    return this.ahW;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.aiD;
  }
  
  public int getMinFlingVelocity()
  {
    return this.aiC;
  }
  
  long getNanoTime()
  {
    if (ahJ) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public k getOnFlingListener()
  {
    return this.aiB;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.aiG;
  }
  
  public RecyclerView.n getRecycledViewPool()
  {
    return this.ahO.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  android.support.v4.view.l getScrollingChildHelper()
  {
    if (this.aiU == null) {
      this.aiU = new android.support.v4.view.l(this);
    }
    return this.aiU;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().au(0);
  }
  
  final int i(RecyclerView.v paramv)
  {
    if ((paramv.ci(524)) || (!paramv.isBound())) {
      return -1;
    }
    return this.ahQ.bm(paramv.mPosition);
  }
  
  final String iM()
  {
    return " " + super.toString() + ", adapter:" + this.Tg + ", layout:" + this.ahW + ", context:" + getContext();
  }
  
  final void iN()
  {
    if (this.aiv != null) {
      this.aiv.hC();
    }
    if (this.ahW != null)
    {
      this.ahW.d(this.ahO);
      this.ahW.c(this.ahO);
    }
    this.ahO.clear();
  }
  
  final void iO()
  {
    int k = 0;
    if ((!this.aie) || (this.aim))
    {
      e.beginSection("RV FullInvalidate");
      jh();
      e.endSection();
    }
    label168:
    label175:
    do
    {
      do
      {
        return;
      } while (!this.ahQ.gY());
      if ((this.ahQ.bk(4)) && (!this.ahQ.bk(11)))
      {
        e.beginSection("RV PartialInvalidate");
        iP();
        ja();
        this.ahQ.gW();
        int i;
        if (!this.aig)
        {
          int m = this.ahR.getChildCount();
          i = 0;
          int j = k;
          if (i < m)
          {
            RecyclerView.v localv = bp(this.ahR.getChildAt(i));
            if ((localv == null) || (localv.jL()) || (!localv.kb())) {
              break label168;
            }
            j = 1;
          }
          if (j == 0) {
            break label175;
          }
          jh();
        }
        for (;;)
        {
          al(true);
          am(true);
          e.endSection();
          return;
          i += 1;
          break;
          this.ahQ.gX();
        }
      }
    } while (!this.ahQ.gY());
    e.beginSection("RV FullInvalidate");
    jh();
    e.endSection();
  }
  
  final void iP()
  {
    this.aif += 1;
    if ((this.aif == 1) && (!this.aih)) {
      this.aig = false;
    }
  }
  
  public final void iQ()
  {
    setScrollState(0);
    iR();
  }
  
  public boolean isAttachedToWindow()
  {
    return this.aib;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().Ga;
  }
  
  final void ja()
  {
    this.aio += 1;
  }
  
  final boolean jb()
  {
    return (this.fU != null) && (this.fU.isEnabled());
  }
  
  public final boolean jd()
  {
    return this.aio > 0;
  }
  
  final void je()
  {
    if ((!this.aiQ) && (this.aib))
    {
      t.b(this, this.aiX);
      this.aiQ = true;
    }
  }
  
  public final boolean js()
  {
    return (!this.aie) || (this.aim) || (this.ahQ.gY());
  }
  
  final void jt()
  {
    int j = this.ahR.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.ahR.getChildAt(i);
      Object localObject = bb(localView);
      if ((localObject != null) && (((RecyclerView.v)localObject).akB != null))
      {
        localObject = ((RecyclerView.v)localObject).akB.aku;
        int k = localView.getLeft();
        int m = localView.getTop();
        if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
          ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
        }
      }
      i += 1;
    }
  }
  
  public final RecyclerView.v k(int paramInt, boolean paramBoolean)
  {
    int j = this.ahR.hx();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      RecyclerView.v localv = bp(this.ahR.bt(i));
      Object localObject2 = localObject1;
      if (localv != null)
      {
        localObject2 = localObject1;
        if (!localv.isRemoved())
        {
          if (!paramBoolean) {
            break label82;
          }
          if (localv.mPosition == paramInt) {
            break label95;
          }
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label82:
        localObject2 = localObject1;
        if (localv.jM() == paramInt)
        {
          label95:
          localObject1 = localv;
          if (!this.ahR.ba(localv.aku)) {
            break label121;
          }
          localObject2 = localv;
        }
      }
    }
    label121:
    return localObject1;
  }
  
  final void m(RecyclerView.s params)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = RecyclerView.u.a(this.aiH);
      params.ako = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      params.akp = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    params.ako = 0;
    params.akp = 0;
  }
  
  protected void onAttachedToWindow()
  {
    boolean bool = true;
    super.onAttachedToWindow();
    this.aio = 0;
    this.aib = true;
    float f;
    if ((this.aie) && (!isLayoutRequested()))
    {
      this.aie = bool;
      if (this.ahW != null) {
        this.ahW.e(this);
      }
      this.aiQ = false;
      if (ahJ)
      {
        this.aiI = ((ac)ac.adM.get());
        if (this.aiI == null)
        {
          this.aiI = new ac();
          Display localDisplay = t.ay(this);
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
      this.aiI.adP = ((1.0E+009F / f));
      ac.adM.set(this.aiI);
      this.aiI.adN.add(this);
      return;
      bool = false;
      break;
      label162:
      f = 60.0F;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.aiv != null) {
      this.aiv.hC();
    }
    iQ();
    this.aib = false;
    if (this.ahW != null) {
      this.ahW.b(this, this.ahO);
    }
    this.aiW.clear();
    removeCallbacks(this.aiX);
    bg.a.lc();
    if ((ahJ) && (this.aiI != null))
    {
      this.aiI.adN.remove(this);
      this.aiI = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.ahY.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.h)this.ahY.get(i)).a(paramCanvas, this, this.aiK);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.ahW == null) {}
    label188:
    for (;;)
    {
      return false;
      if ((!this.aih) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        float f3;
        float f2;
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
          if (this.ahW.ik())
          {
            f1 = -paramMotionEvent.getAxisValue(9);
            if (!this.ahW.ij()) {
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
          a((int)(this.aiE * f1), (int)(this.aiF * f2), paramMotionEvent);
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
            if (this.ahW.ik())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.ahW.ij())
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
    if (this.aih) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.aia = null;
    }
    int k = this.ahZ.size();
    int i = 0;
    if (i < k)
    {
      RecyclerView.l locall = (RecyclerView.l)this.ahZ.get(i);
      if ((locall.h(paramMotionEvent)) && (j != 3)) {
        this.aia = locall;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label104;
      }
      iZ();
      return true;
      i += 1;
      break;
    }
    label104:
    if (this.ahW == null) {
      return false;
    }
    boolean bool1 = this.ahW.ij();
    boolean bool2 = this.ahW.ik();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    j = paramMotionEvent.getActionMasked();
    i = paramMotionEvent.getActionIndex();
    switch (j)
    {
    case 4: 
    default: 
      if (this.mScrollState == 1) {
        return true;
      }
      break;
    case 0: 
      if (this.aii) {
        this.aii = false;
      }
      this.aiw = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.aiz = i;
      this.aix = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.aiA = i;
      this.aiy = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.aiV;
      this.aiV[1] = 0;
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
      this.aiw = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.aiz = j;
      this.aix = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.aiA = i;
      this.aiy = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.aiw);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.aiw).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.aix;
      int m = this.aiy;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.aiz = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.aiA = k;
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
        this.mVelocityTracker.clear();
        av(0);
        break;
        iZ();
        break;
        return false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e.beginSection("RV OnLayout");
    jh();
    e.endSection();
    this.aie = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.ahW == null) {
      aj(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.ahW.ii()) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        this.ahW.az(paramInt1, paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
      } while ((i != 0) || (this.Tg == null));
      if (this.aiK.akd == 1) {
        jl();
      }
      this.ahW.aw(paramInt1, paramInt2);
      this.aiK.aki = true;
      jm();
      this.ahW.ax(paramInt1, paramInt2);
    } while (!this.ahW.io());
    this.ahW.aw(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.aiK.aki = true;
    jm();
    this.ahW.ax(paramInt1, paramInt2);
    return;
    if (this.aic)
    {
      this.ahW.az(paramInt1, paramInt2);
      return;
    }
    if (this.aik)
    {
      iP();
      ja();
      jg();
      am(true);
      if (this.aiK.akk)
      {
        this.aiK.akg = true;
        this.aik = false;
        al(false);
        label256:
        if (this.Tg == null) {
          break label345;
        }
      }
    }
    label345:
    for (this.aiK.ake = this.Tg.getItemCount();; this.aiK.ake = 0)
    {
      iP();
      this.ahW.az(paramInt1, paramInt2);
      al(false);
      this.aiK.akg = false;
      return;
      this.ahQ.gZ();
      this.aiK.akg = false;
      break;
      if (!this.aiK.akk) {
        break label256;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (jd()) {
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
      this.ahP = ((RecyclerView.SavedState)paramParcelable);
      super.onRestoreInstanceState(this.ahP.Fo);
    } while ((this.ahW == null) || (this.ahP.ajP == null));
    this.ahW.onRestoreInstanceState(this.ahP.ajP);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (this.ahP != null)
    {
      localSavedState.ajP = this.ahP.ajP;
      return localSavedState;
    }
    if (this.ahW != null)
    {
      localSavedState.ajP = this.ahW.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.ajP = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      iX();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.aih) || (this.aii)) {}
    label144:
    label153:
    label159:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.aia != null)
      {
        if (i == 0) {
          this.aia = null;
        }
      }
      else
      {
        if (i == 0) {
          break label153;
        }
        j = this.ahZ.size();
        i = 0;
        if (i >= j) {
          break label153;
        }
        localObject = (RecyclerView.l)this.ahZ.get(i);
        if (!((RecyclerView.l)localObject).h(paramMotionEvent)) {
          break label144;
        }
        this.aia = ((RecyclerView.l)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label159;
        }
        iZ();
        return true;
        this.aia.i(paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.aia = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.ahW == null);
    boolean bool1 = this.ahW.ij();
    boolean bool2 = this.ahW.ik();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.aiV;
      this.aiV[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.aiV[0], this.aiV[1]);
    int i = i2;
    switch (k)
    {
    default: 
      i = i2;
    case 4: 
      if (i == 0) {
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    case 0: 
      this.aiw = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.aiz = i;
      this.aix = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.aiA = i;
      this.aiy = i;
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
      this.aiw = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.aiz = i;
      this.aix = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.aiA = i;
      this.aiy = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.aiw);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.aiw).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.aiz - i3;
      k = this.aiA - i4;
      j = m;
      i = k;
      if (a(m, k, this.KO, this.KN, 0))
      {
        j = m - this.KO[0];
        i = k - this.KO[1];
        ((MotionEvent)localObject).offsetLocation(this.KN[0], this.KN[1]);
        paramMotionEvent = this.aiV;
        paramMotionEvent[0] += this.KN[0];
        paramMotionEvent = this.aiV;
        paramMotionEvent[1] += this.KN[1];
      }
      k = j;
      m = i;
      if (this.mScrollState != 1)
      {
        if ((!bool1) || (Math.abs(j) <= this.mTouchSlop)) {
          break label1103;
        }
        if (j <= 0) {
          break label936;
        }
        j -= this.mTouchSlop;
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
          if (Math.abs(i) > this.mTouchSlop)
          {
            if (i <= 0) {
              break label948;
            }
            i -= this.mTouchSlop;
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
        if (this.mScrollState != 1) {
          break;
        }
        this.aiz = (i3 - this.KN[0]);
        this.aiA = (i4 - this.KN[1]);
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
          if (this.aiI == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.aiI.b(this, k, m);
          i = i2;
          break;
          j = this.mTouchSlop + j;
          break label730;
          i = this.mTouchSlop + i;
          break label780;
          i = 0;
          break label860;
        }
        j(paramMotionEvent);
        i = i2;
        break;
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.aiD);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.aiw);
          if (!bool2) {
            break label1087;
          }
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.aiw);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!ag((int)f1, (int)f2))) {
            setScrollState(0);
          }
          iY();
          i = 1;
          break;
          f1 = 0.0F;
          break label1026;
        }
        iZ();
        i = i2;
        break;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    RecyclerView.v localv = bp(paramView);
    if (localv != null)
    {
      if (!localv.jW()) {
        break label36;
      }
      localv.jT();
    }
    label36:
    while (localv.jL())
    {
      paramView.clearAnimation();
      bu(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localv + iM());
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((this.ahW.jz()) || (jd())) {}
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
    return this.ahW.a(this, paramView, paramRect, paramBoolean, false);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.ahZ.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.l)this.ahZ.get(i)).ac(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.aif == 0) && (!this.aih))
    {
      super.requestLayout();
      return;
    }
    this.aig = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.ahW == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.aih);
      bool1 = this.ahW.ij();
      bool2 = this.ahW.ik();
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
    if (jd())
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
        this.aij |= i;
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
  
  public void setAccessibilityDelegateCompat(al paramal)
  {
    this.aiR = paramal;
    t.a(this, this.aiR);
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    setLayoutFrozen(false);
    if (this.Tg != null) {
      this.Tg.b(this.ahN);
    }
    iN();
    this.ahQ.reset();
    RecyclerView.a locala = this.Tg;
    this.Tg = parama;
    if (parama != null) {
      parama.a(this.ahN);
    }
    if (this.ahW != null) {
      this.ahW.jA();
    }
    Object localObject = this.ahO;
    parama = this.Tg;
    ((RecyclerView.o)localObject).clear();
    localObject = ((RecyclerView.o)localObject).getRecycledViewPool();
    if (locala != null) {
      ((RecyclerView.n)localObject).detach();
    }
    if (((RecyclerView.n)localObject).ajC == 0)
    {
      int i = 0;
      while (i < ((RecyclerView.n)localObject).ajB.size())
      {
        ((n.a)((RecyclerView.n)localObject).ajB.valueAt(i)).ajD.clear();
        i += 1;
      }
    }
    if (parama != null) {
      ((RecyclerView.n)localObject).jE();
    }
    this.aiK.akf = true;
    an(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(RecyclerView.d paramd)
  {
    if (paramd == this.aiS) {
      return;
    }
    this.aiS = paramd;
    if (this.aiS != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.ahT) {
      iX();
    }
    this.ahT = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.aie) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(RecyclerView.e parame)
  {
    android.support.v4.e.l.checkNotNull(parame);
    this.aiq = parame;
    iX();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.aic = paramBoolean;
  }
  
  public void setItemAnimator(RecyclerView.f paramf)
  {
    if (this.aiv != null)
    {
      this.aiv.hC();
      this.aiv.ajd = null;
    }
    this.aiv = paramf;
    if (this.aiv != null) {
      this.aiv.ajd = this.aiP;
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    RecyclerView.o localo = this.ahO;
    localo.ajL = paramInt;
    localo.jF();
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.aih)
    {
      S("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.aih = false;
        if ((this.aig) && (this.ahW != null) && (this.Tg != null)) {
          requestLayout();
        }
        this.aig = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.aih = true;
    this.aii = true;
    iQ();
  }
  
  public void setLayoutManager(RecyclerView.i parami)
  {
    if (parami == this.ahW) {
      return;
    }
    iQ();
    if (this.ahW != null)
    {
      if (this.aiv != null) {
        this.aiv.hC();
      }
      this.ahW.d(this.ahO);
      this.ahW.c(this.ahO);
      this.ahO.clear();
      if (this.aib) {
        this.ahW.b(this, this.ahO);
      }
      this.ahW.setRecyclerView(null);
      this.ahW = null;
    }
    s locals;
    for (;;)
    {
      locals = this.ahR;
      for (s.a locala = locals.abT;; locala = locala.abW)
      {
        locala.abV = 0L;
        if (locala.abW == null) {
          break;
        }
      }
      this.ahO.clear();
    }
    int i = locals.abU.size() - 1;
    while (i >= 0)
    {
      locals.abS.bd((View)locals.abU.get(i));
      locals.abU.remove(i);
      i -= 1;
    }
    locals.abS.removeAllViews();
    this.ahW = parami;
    if (parami != null)
    {
      if (parami.adt != null) {
        throw new IllegalArgumentException("LayoutManager " + parami + " is already attached to a RecyclerView:" + parami.adt.iM());
      }
      this.ahW.setRecyclerView(this);
      if (this.aib) {
        this.ahW.e(this);
      }
    }
    this.ahO.jF();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(k paramk)
  {
    this.aiB = paramk;
  }
  
  @Deprecated
  public void setOnScrollListener(m paramm)
  {
    this.aiL = paramm;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.aiG = paramBoolean;
  }
  
  public void setRecycledViewPool(RecyclerView.n paramn)
  {
    RecyclerView.o localo = this.ahO;
    if (localo.ajN != null) {
      localo.ajN.detach();
    }
    localo.ajN = paramn;
    if (paramn != null)
    {
      paramn = localo.ajN;
      localo.aja.getAdapter();
      paramn.jE();
    }
  }
  
  public void setRecyclerListener(RecyclerView.p paramp)
  {
    this.ahX = paramp;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {}
    for (;;)
    {
      return;
      this.mScrollState = paramInt;
      if (paramInt != 2) {
        iR();
      }
      if (this.ahW != null) {
        this.ahW.bX(paramInt);
      }
      if (this.aiL != null) {
        this.aiL.c(this, paramInt);
      }
      if (this.aiM != null)
      {
        int i = this.aiM.size() - 1;
        while (i >= 0)
        {
          ((m)this.aiM.get(i)).c(this, paramInt);
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
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public void setViewCacheExtension(RecyclerView.t paramt)
  {
    this.ahO.ajO = paramt;
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    if (this.aih) {}
    while (this.ahW == null) {
      return;
    }
    this.ahW.a(this, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().r(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().av(0);
  }
  
  public final View x(float paramFloat1, float paramFloat2)
  {
    int i = this.ahR.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.ahR.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public static abstract interface j
  {
    public abstract void bJ(View paramView);
  }
  
  public static abstract class k
  {
    public abstract boolean aA(int paramInt1, int paramInt2);
  }
  
  public static abstract class m
  {
    public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void c(RecyclerView paramRecyclerView, int paramInt) {}
  }
  
  static final class n$a
  {
    final ArrayList<RecyclerView.v> ajD = new ArrayList();
    int ajE = 5;
    long ajF = 0L;
    long ajG = 0L;
  }
  
  public static abstract interface r$b
  {
    public abstract PointF bI(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */