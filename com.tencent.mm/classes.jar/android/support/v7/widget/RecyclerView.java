package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.e.m;
import android.support.v4.os.e;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.c.c;
import android.support.v4.view.k;
import android.support.v4.view.l;
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
import android.view.ViewGroup.MarginLayoutParams;
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
import java.util.Collections;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements k
{
  private static final int[] aoL = { 16843830 };
  private static final int[] aoM = { 16842987 };
  static final boolean aoN;
  static final boolean aoO;
  static final boolean aoP;
  static final boolean aoQ;
  private static final boolean aoR;
  private static final boolean aoS;
  private static final Class<?>[] aoT;
  static final Interpolator aqi;
  private final int[] RQ;
  final int[] RR;
  private final Rect Wl = new Rect();
  a aaj;
  private final q aoU = new q();
  final o aoV = new o();
  private SavedState aoW;
  d aoX;
  s aoY;
  final bg aoZ = new bg();
  private EdgeEffect apA;
  private EdgeEffect apB;
  private EdgeEffect apC;
  private EdgeEffect apD;
  f apE = new v();
  private int apF = -1;
  private int apG;
  private int apH;
  private int apI;
  private int apJ;
  private k apK;
  private final int apL;
  private final int apM;
  private float apN = 1.4E-45F;
  private float apO = 1.4E-45F;
  private boolean apP = true;
  final u apQ = new u();
  ac apR;
  ac.a apS;
  final s apT;
  private m apU;
  private List<m> apV;
  boolean apW;
  boolean apX;
  private RecyclerView.f.b apY;
  boolean apZ;
  boolean apa;
  final Runnable apb = new Runnable()
  {
    public final void run()
    {
      if ((!RecyclerView.this.apl) || (RecyclerView.this.isLayoutRequested())) {
        return;
      }
      if (!RecyclerView.this.api)
      {
        RecyclerView.this.requestLayout();
        return;
      }
      if (RecyclerView.this.apo)
      {
        RecyclerView.this.apn = true;
        return;
      }
      RecyclerView.this.kj();
    }
  };
  final RectF apc = new RectF();
  i apd;
  p ape;
  public final ArrayList<h> apf = new ArrayList();
  private final ArrayList<l> apg = new ArrayList();
  private l aph;
  boolean api;
  boolean apj;
  boolean apk;
  boolean apl;
  private int apm = 0;
  boolean apn;
  public boolean apo;
  private boolean apq;
  private int apr;
  boolean aps;
  private final AccessibilityManager apt;
  public List<j> apu;
  boolean apv = false;
  boolean apw = false;
  private int apx = 0;
  private int apy = 0;
  private e apz = new e();
  al aqa;
  private d aqb;
  private final int[] aqc;
  private l aqd;
  private final int[] aqe;
  final int[] aqf;
  final List<v> aqg;
  private Runnable aqh;
  private final bg.b aqj;
  private int mScrollState = 0;
  final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      aoN = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label169;
      }
      bool = true;
      label62:
      aoO = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label174;
      }
      bool = true;
      label76:
      aoP = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label179;
      }
      bool = true;
      label90:
      aoQ = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label184;
      }
      bool = true;
      label104:
      aoR = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label189;
      }
    }
    label169:
    label174:
    label179:
    label184:
    label189:
    for (boolean bool = true;; bool = false)
    {
      aoS = bool;
      aoT = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      aqi = new Interpolator()
      {
        public final float getInterpolation(float paramAnonymousFloat)
        {
          paramAnonymousFloat -= 1.0F;
          return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
        }
      };
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
    if (aoQ)
    {
      localObject1 = new ac.a();
      this.apS = ((ac.a)localObject1);
      this.apT = new s();
      this.apW = false;
      this.apX = false;
      this.apY = new g();
      this.apZ = false;
      this.aqc = new int[2];
      this.RQ = new int[2];
      this.RR = new int[2];
      this.aqe = new int[2];
      this.aqf = new int[2];
      this.aqg = new ArrayList();
      this.aqh = new Runnable()
      {
        public final void run()
        {
          if (RecyclerView.this.apE != null) {
            RecyclerView.this.apE.iW();
          }
          RecyclerView.this.apZ = false;
        }
      };
      this.aqj = new bg.b()
      {
        public final void a(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          RecyclerView.this.aoV.u(paramAnonymousv);
          RecyclerView localRecyclerView = RecyclerView.this;
          localRecyclerView.f(paramAnonymousv);
          paramAnonymousv.ax(false);
          if (localRecyclerView.apE.d(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.kz();
          }
        }
        
        public final void b(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          RecyclerView localRecyclerView = RecyclerView.this;
          paramAnonymousv.ax(false);
          if (localRecyclerView.apE.e(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.kz();
          }
        }
        
        public final void c(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          paramAnonymousv.ax(false);
          if (RecyclerView.this.apv) {
            if (RecyclerView.this.apE.a(paramAnonymousv, paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
              RecyclerView.this.kz();
            }
          }
          while (!RecyclerView.this.apE.f(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            return;
          }
          RecyclerView.this.kz();
        }
        
        public final void j(RecyclerView.v paramAnonymousv)
        {
          RecyclerView.this.apd.a(paramAnonymousv.arI, RecyclerView.this.aoV);
        }
      };
      if (paramAttributeSet == null) {
        break label693;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, aoM, paramInt, 0);
      this.apa = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
      label358:
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject1 = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
      this.apN = u.a((ViewConfiguration)localObject1, paramContext);
      this.apO = u.b((ViewConfiguration)localObject1, paramContext);
      this.apL = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
      this.apM = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
      if (getOverScrollMode() != 2) {
        break label701;
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    StateListDrawable localStateListDrawable;
    Drawable localDrawable;
    label693:
    label701:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      this.apE.aqn = this.apY;
      this.aoX = new d(new d.a()
      {
        private void f(d.b paramAnonymousb)
        {
          switch (paramAnonymousb.BX)
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            return;
          case 1: 
            RecyclerView.this.apd.c(RecyclerView.this, paramAnonymousb.ahb, paramAnonymousb.ahd);
            return;
          case 2: 
            RecyclerView.this.apd.d(RecyclerView.this, paramAnonymousb.ahb, paramAnonymousb.ahd);
            return;
          case 4: 
            RecyclerView.this.apd.a(RecyclerView.this, paramAnonymousb.ahb, paramAnonymousb.ahd, paramAnonymousb.ahc);
            return;
          }
          RecyclerView.this.apd.a(RecyclerView.this, paramAnonymousb.ahb, paramAnonymousb.ahd, 1);
        }
        
        public final void M(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, true);
          RecyclerView.this.apW = true;
          RecyclerView.s locals = RecyclerView.this.apT;
          locals.arq += paramAnonymousInt2;
        }
        
        public final void N(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, false);
          RecyclerView.this.apW = true;
        }
        
        public final void O(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView localRecyclerView = RecyclerView.this;
          int j = localRecyclerView.aoY.iT();
          int i = 0;
          while (i < j)
          {
            localObject = RecyclerView.bv(localRecyclerView.aoY.bL(i));
            if ((localObject != null) && (!((RecyclerView.v)localObject).ll()) && (((RecyclerView.v)localObject).mPosition >= paramAnonymousInt1))
            {
              ((RecyclerView.v)localObject).k(paramAnonymousInt2, false);
              localRecyclerView.apT.art = true;
            }
            i += 1;
          }
          Object localObject = localRecyclerView.aoV;
          j = ((RecyclerView.o)localObject).aqW.size();
          i = 0;
          while (i < j)
          {
            RecyclerView.v localv = (RecyclerView.v)((RecyclerView.o)localObject).aqW.get(i);
            if ((localv != null) && (localv.mPosition >= paramAnonymousInt1)) {
              localv.k(paramAnonymousInt2, true);
            }
            i += 1;
          }
          localRecyclerView.requestLayout();
          RecyclerView.this.apW = true;
        }
        
        public final void P(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int n = -1;
          RecyclerView localRecyclerView = RecyclerView.this;
          int i1 = localRecyclerView.aoY.iT();
          int i;
          int j;
          int k;
          int m;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            i = -1;
            j = paramAnonymousInt2;
            k = paramAnonymousInt1;
            m = 0;
            label35:
            if (m >= i1) {
              break label139;
            }
            localObject = RecyclerView.bv(localRecyclerView.aoY.bL(m));
            if ((localObject != null) && (((RecyclerView.v)localObject).mPosition >= k) && (((RecyclerView.v)localObject).mPosition <= j))
            {
              if (((RecyclerView.v)localObject).mPosition != paramAnonymousInt1) {
                break label129;
              }
              ((RecyclerView.v)localObject).k(paramAnonymousInt2 - paramAnonymousInt1, false);
            }
          }
          for (;;)
          {
            localRecyclerView.apT.art = true;
            m += 1;
            break label35;
            i = 1;
            j = paramAnonymousInt1;
            k = paramAnonymousInt2;
            break;
            label129:
            ((RecyclerView.v)localObject).k(i, false);
          }
          label139:
          Object localObject = localRecyclerView.aoV;
          label173:
          RecyclerView.v localv;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            j = paramAnonymousInt2;
            k = paramAnonymousInt1;
            i = n;
            n = ((RecyclerView.o)localObject).aqW.size();
            m = 0;
            if (m >= n) {
              break label268;
            }
            localv = (RecyclerView.v)((RecyclerView.o)localObject).aqW.get(m);
            if ((localv != null) && (localv.mPosition >= k) && (localv.mPosition <= j))
            {
              if (localv.mPosition != paramAnonymousInt1) {
                break label258;
              }
              localv.k(paramAnonymousInt2 - paramAnonymousInt1, false);
            }
          }
          for (;;)
          {
            m += 1;
            break label173;
            i = 1;
            j = paramAnonymousInt1;
            k = paramAnonymousInt2;
            break;
            label258:
            localv.k(i, false);
          }
          label268:
          localRecyclerView.requestLayout();
          RecyclerView.this.apW = true;
        }
        
        public final RecyclerView.v bF(int paramAnonymousInt)
        {
          RecyclerView.v localv = RecyclerView.this.j(paramAnonymousInt, true);
          if (localv == null) {}
          while (RecyclerView.this.aoY.bg(localv.arI)) {
            return null;
          }
          return localv;
        }
        
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          Object localObject = RecyclerView.this;
          int j = ((RecyclerView)localObject).aoY.iT();
          int i = 0;
          while (i < j)
          {
            View localView = ((RecyclerView)localObject).aoY.bL(i);
            RecyclerView.v localv = RecyclerView.bv(localView);
            if ((localv != null) && (!localv.ll()) && (localv.mPosition >= paramAnonymousInt1) && (localv.mPosition < paramAnonymousInt1 + paramAnonymousInt2))
            {
              localv.addFlags(2);
              localv.L(paramAnonymousObject);
              ((RecyclerView.LayoutParams)localView.getLayoutParams()).aqM = true;
            }
            i += 1;
          }
          paramAnonymousObject = ((RecyclerView)localObject).aoV;
          i = paramAnonymousObject.aqW.size() - 1;
          while (i >= 0)
          {
            localObject = (RecyclerView.v)paramAnonymousObject.aqW.get(i);
            if (localObject != null)
            {
              j = ((RecyclerView.v)localObject).mPosition;
              if ((j >= paramAnonymousInt1) && (j < paramAnonymousInt1 + paramAnonymousInt2))
              {
                ((RecyclerView.v)localObject).addFlags(2);
                paramAnonymousObject.cx(i);
              }
            }
            i -= 1;
          }
          RecyclerView.this.apX = true;
        }
        
        public final void d(d.b paramAnonymousb)
        {
          f(paramAnonymousb);
        }
        
        public final void e(d.b paramAnonymousb)
        {
          f(paramAnonymousb);
        }
      });
      this.aoY = new s(new s.b()
      {
        public final void addView(View paramAnonymousView, int paramAnonymousInt)
        {
          RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
          RecyclerView localRecyclerView = RecyclerView.this;
          RecyclerView.v localv = RecyclerView.bv(paramAnonymousView);
          if ((localRecyclerView.aaj != null) && (localv != null)) {
            localRecyclerView.aaj.k(localv);
          }
          if (localRecyclerView.apu != null)
          {
            paramAnonymousInt = localRecyclerView.apu.size() - 1;
            while (paramAnonymousInt >= 0)
            {
              ((RecyclerView.j)localRecyclerView.apu.get(paramAnonymousInt)).bQ(paramAnonymousView);
              paramAnonymousInt -= 1;
            }
          }
        }
        
        public final void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
        {
          RecyclerView.v localv = RecyclerView.bv(paramAnonymousView);
          if (localv != null)
          {
            if ((!localv.lw()) && (!localv.ll())) {
              throw new IllegalArgumentException("Called attach on a child which is not detached: " + localv + RecyclerView.this.kh());
            }
            localv.lu();
          }
          RecyclerView.a(RecyclerView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
        }
        
        public final RecyclerView.v bh(View paramAnonymousView)
        {
          return RecyclerView.bv(paramAnonymousView);
        }
        
        public final void bi(View paramAnonymousView)
        {
          paramAnonymousView = RecyclerView.bv(paramAnonymousView);
          RecyclerView localRecyclerView;
          if (paramAnonymousView != null)
          {
            localRecyclerView = RecyclerView.this;
            if (paramAnonymousView.arX == -1) {
              break label38;
            }
          }
          label38:
          for (paramAnonymousView.arW = paramAnonymousView.arX;; paramAnonymousView.arW = t.X(paramAnonymousView.arI))
          {
            localRecyclerView.b(paramAnonymousView, 4);
            return;
          }
        }
        
        public final void bj(View paramAnonymousView)
        {
          paramAnonymousView = RecyclerView.bv(paramAnonymousView);
          if (paramAnonymousView != null)
          {
            RecyclerView.this.b(paramAnonymousView, paramAnonymousView.arW);
            paramAnonymousView.arW = 0;
          }
        }
        
        public final void detachViewFromParent(int paramAnonymousInt)
        {
          Object localObject = getChildAt(paramAnonymousInt);
          if (localObject != null)
          {
            localObject = RecyclerView.bv((View)localObject);
            if (localObject != null)
            {
              if ((((RecyclerView.v)localObject).lw()) && (!((RecyclerView.v)localObject).ll())) {
                throw new IllegalArgumentException("called detach on an already detached child " + localObject + RecyclerView.this.kh());
              }
              ((RecyclerView.v)localObject).addFlags(256);
            }
          }
          RecyclerView.a(RecyclerView.this, paramAnonymousInt);
        }
        
        public final View getChildAt(int paramAnonymousInt)
        {
          return RecyclerView.this.getChildAt(paramAnonymousInt);
        }
        
        public final int getChildCount()
        {
          return RecyclerView.this.getChildCount();
        }
        
        public final int indexOfChild(View paramAnonymousView)
        {
          return RecyclerView.this.indexOfChild(paramAnonymousView);
        }
        
        public final void removeAllViews()
        {
          int j = RecyclerView.this.getChildCount();
          int i = 0;
          while (i < j)
          {
            View localView = getChildAt(i);
            RecyclerView.this.bA(localView);
            localView.clearAnimation();
            i += 1;
          }
          RecyclerView.this.removeAllViews();
        }
        
        public final void removeViewAt(int paramAnonymousInt)
        {
          View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
          if (localView != null)
          {
            RecyclerView.this.bA(localView);
            localView.clearAnimation();
          }
          RecyclerView.this.removeViewAt(paramAnonymousInt);
        }
      });
      if (t.S(this) == 0) {
        t.T(this);
      }
      if (t.X(this) == 0) {
        t.p(this, 1);
      }
      this.apt = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new al(this));
      if (paramAttributeSet == null) {
        break label1272;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt, 0);
      localObject2 = ((TypedArray)localObject1).getString(7);
      if (((TypedArray)localObject1).getInt(1, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.apk = ((TypedArray)localObject1).getBoolean(2, false);
      if (!this.apk) {
        break label757;
      }
      localObject3 = (StateListDrawable)((TypedArray)localObject1).getDrawable(5);
      localObject4 = ((TypedArray)localObject1).getDrawable(6);
      localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(3);
      localDrawable = ((TypedArray)localObject1).getDrawable(4);
      if ((localObject3 != null) && (localObject4 != null) && (localStateListDrawable != null) && (localDrawable != null)) {
        break label707;
      }
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + kh());
      localObject1 = null;
      break;
      this.apa = true;
      break label358;
    }
    label707:
    Resources localResources = getContext().getResources();
    new z(this, (StateListDrawable)localObject3, (Drawable)localObject4, localStateListDrawable, localDrawable, localResources.getDimensionPixelSize(2131166283), localResources.getDimensionPixelSize(2131166285), localResources.getDimensionPixelOffset(2131166284));
    label757:
    ((TypedArray)localObject1).recycle();
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).trim();
      if (!((String)localObject1).isEmpty())
      {
        if (((String)localObject1).charAt(0) != '.') {
          break label947;
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
          localObject4 = ((ClassLoader)localObject2).loadClass((String)localObject1).asSubclass(i.class);
        }
        try
        {
          localObject3 = ((Class)localObject4).getConstructor(aoT);
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
        setLayoutManager((i)((Constructor)localObject3).newInstance((Object[])localObject2));
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, aoL, paramInt, 0);
          bool = paramContext.getBoolean(0, true);
          paramContext.recycle();
          setNestedScrollingEnabled(bool);
          return;
          label947:
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
      label1272:
      bool = true;
    }
  }
  
  private void a(long paramLong, v paramv1, v paramv2)
  {
    int j = this.aoY.getChildCount();
    int i = 0;
    while (i < j)
    {
      v localv = bv(this.aoY.getChildAt(i));
      if ((localv != paramv1) && (g(localv) == paramLong))
      {
        if ((this.aaj != null) && (this.aaj.aqm)) {
          throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + kh());
        }
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + kh());
      }
      i += 1;
    }
    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(paramv2).append(" cannot be found but it is necessary for ").append(paramv1).append(kh());
  }
  
  private void a(v paramv1, v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramv1.ax(false);
    if (paramBoolean1) {
      f(paramv1);
    }
    if (paramv1 != paramv2)
    {
      if (paramBoolean2) {
        f(paramv2);
      }
      paramv1.arO = paramv2;
      f(paramv1);
      this.aoV.u(paramv1);
      paramv2.ax(false);
      paramv2.arP = paramv1;
    }
    if (this.apE.a(paramv1, paramv2, paramc1, paramc2)) {
      kz();
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    kj();
    int i;
    int j;
    int k;
    int m;
    if (this.aaj != null)
    {
      b(paramInt1, paramInt2, this.aqf);
      i = this.aqf[0];
      j = this.aqf[1];
      k = paramInt1 - i;
      m = paramInt2 - j;
    }
    for (;;)
    {
      if (!this.apf.isEmpty()) {
        invalidate();
      }
      if (a(i, j, k, m, this.RQ, 0))
      {
        this.apI -= this.RQ[0];
        this.apJ -= this.RQ[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.RQ[0], this.RQ[1]);
        }
        paramMotionEvent = this.aqe;
        paramMotionEvent[0] += this.RQ[0];
        paramMotionEvent = this.aqe;
        paramMotionEvent[1] += this.RQ[1];
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          an(i, j);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((i != 0) || (j != 0)) {
          bool = true;
        }
        return bool;
        if (getOverScrollMode() != 2)
        {
          if ((paramMotionEvent != null) && (!android.support.v4.view.i.e(paramMotionEvent))) {
            h(paramMotionEvent.getX(), k, paramMotionEvent.getY(), m);
          }
          aj(paramInt1, paramInt2);
        }
      }
      j = 0;
      i = 0;
      m = 0;
      k = 0;
    }
  }
  
  private boolean am(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    m(this.aqc);
    if ((this.aqc[0] != paramInt1) || (this.aqc[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  static v bv(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).aqL;
  }
  
  public static int bw(View paramView)
  {
    paramView = bv(paramView);
    if (paramView != null) {
      return paramView.ln();
    }
    return -1;
  }
  
  public static int bx(View paramView)
  {
    paramView = bv(paramView);
    if (paramView != null) {
      return paramView.lm();
    }
    return -1;
  }
  
  static RecyclerView bz(View paramView)
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
      RecyclerView localRecyclerView = bz(paramView.getChildAt(i));
      if (localRecyclerView != null) {
        return localRecyclerView;
      }
      i += 1;
    }
    return null;
  }
  
  public static void c(View paramView, Rect paramRect)
  {
    d(paramView, paramRect);
  }
  
  static void d(View paramView, Rect paramRect)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.amT;
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
  
  private void f(View paramView1, View paramView2)
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
      if ((localObject instanceof LayoutParams))
      {
        localObject = (LayoutParams)localObject;
        if (!((LayoutParams)localObject).aqM)
        {
          localObject = ((LayoutParams)localObject).amT;
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
      localObject = this.apd;
      localRect = this.mTempRect;
      if (this.apl) {
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
      ((i)localObject).a(this, paramView1, localRect, bool1, bool2);
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
  
  private long g(v paramv)
  {
    if (this.aaj.aqm) {
      return paramv.arL;
    }
    return paramv.mPosition;
  }
  
  private void h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      ko();
      android.support.v4.widget.i.a(this.apA, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label141;
      }
      kq();
      android.support.v4.widget.i.a(this.apB, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    for (;;)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        t.W(this);
      }
      return;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      kp();
      android.support.v4.widget.i.a(this.apC, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label141:
      if (paramFloat4 > 0.0F)
      {
        kr();
        android.support.v4.widget.i.a(this.apD, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  static void h(v paramv)
  {
    Object localObject;
    if (paramv.arJ != null) {
      localObject = (View)paramv.arJ.get();
    }
    while (localObject != null)
    {
      if (localObject == paramv.arI) {
        return;
      }
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof View)) {
        localObject = (View)localObject;
      } else {
        localObject = null;
      }
    }
    paramv.arJ = null;
  }
  
  private void k(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.apF) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.apF = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.apI = j;
      this.apG = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.apJ = i;
      this.apH = i;
      return;
    }
  }
  
  private boolean kA()
  {
    return (this.apE != null) && (this.apd.jC());
  }
  
  private void kB()
  {
    boolean bool2 = true;
    if (this.apv)
    {
      this.aoX.reset();
      if (this.apw) {
        this.apd.a(this);
      }
    }
    int i;
    label61:
    s locals;
    if (kA())
    {
      this.aoX.it();
      if ((!this.apW) && (!this.apX)) {
        break label180;
      }
      i = 1;
      locals = this.apT;
      if ((!this.apl) || (this.apE == null) || ((!this.apv) && (i == 0) && (!this.apd.aqz)) || ((this.apv) && (!this.aaj.aqm))) {
        break label185;
      }
      bool1 = true;
      label121:
      locals.arx = bool1;
      locals = this.apT;
      if ((!this.apT.arx) || (i == 0) || (this.apv) || (!kA())) {
        break label190;
      }
    }
    label180:
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locals.ary = bool1;
      return;
      this.aoX.iw();
      break;
      i = 0;
      break label61;
      bool1 = false;
      break label121;
    }
  }
  
  private void kC()
  {
    if (this.aaj == null) {}
    while (this.apd == null) {
      return;
    }
    this.apT.arw = false;
    if (this.apT.arr == 1)
    {
      kG();
      this.apd.h(this);
      kH();
    }
    for (;;)
    {
      kI();
      return;
      if ((this.aoX.ix()) || (this.apd.mWidth != getWidth()) || (this.apd.mHeight != getHeight()))
      {
        this.apd.h(this);
        kH();
      }
      else
      {
        this.apd.h(this);
      }
    }
  }
  
  private void kD()
  {
    if ((this.apP) && (hasFocus()) && (this.aaj != null)) {}
    for (Object localObject1 = getFocusedChild();; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = bu((View)localObject1))
      {
        kE();
        return;
      }
      Object localObject2 = this.apT;
      long l;
      int i;
      if (this.aaj.aqm)
      {
        l = ((v)localObject1).arL;
        ((s)localObject2).arA = l;
        localObject2 = this.apT;
        if (!this.apv) {
          break label191;
        }
        i = -1;
      }
      s locals;
      for (;;)
      {
        ((s)localObject2).arz = i;
        locals = this.apT;
        localObject1 = ((v)localObject1).arI;
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
        if (((v)localObject1).isRemoved()) {
          i = ((v)localObject1).arK;
        } else {
          i = ((v)localObject1).ln();
        }
      }
      locals.arB = i;
      return;
    }
  }
  
  private void kE()
  {
    this.apT.arA = -1L;
    this.apT.arz = -1;
    this.apT.arB = -1;
  }
  
  private void kF()
  {
    View localView = null;
    if ((!this.apP) || (this.aaj == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused()))) {}
    do
    {
      return;
      if (isFocused()) {
        break;
      }
      localObject = getFocusedChild();
      if ((aoS) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
      {
        if (this.aoY.getChildCount() != 0) {
          break;
        }
        requestFocus();
        return;
      }
    } while (!this.aoY.bg((View)localObject));
    if ((this.apT.arA != -1L) && (this.aaj.aqm)) {}
    for (Object localObject = k(this.apT.arA);; localObject = null)
    {
      int i;
      label216:
      int k;
      int j;
      if ((localObject == null) || (this.aoY.bg(((v)localObject).arI)) || (!((v)localObject).arI.hasFocusable()))
      {
        localObject = localView;
        if (this.aoY.getChildCount() > 0)
        {
          if (this.apT.arz != -1)
          {
            i = this.apT.arz;
            k = this.apT.getItemCount();
            j = i;
            label226:
            if (j >= k) {
              break label331;
            }
            localObject = cj(j);
            if (localObject == null) {
              break label331;
            }
            if (!((v)localObject).arI.hasFocusable()) {
              break label324;
            }
            localObject = ((v)localObject).arI;
          }
        }
        else
        {
          label261:
          if (localObject == null) {
            break label397;
          }
          if (this.apT.arB == -1L) {
            break label399;
          }
          localView = ((View)localObject).findViewById(this.apT.arB);
          if ((localView == null) || (!localView.isFocusable())) {
            break label399;
          }
          localObject = localView;
        }
      }
      label397:
      label399:
      for (;;)
      {
        ((View)localObject).requestFocus();
        return;
        i = 0;
        break label216;
        label324:
        j += 1;
        break label226;
        label331:
        i = Math.min(k, i) - 1;
        for (;;)
        {
          if (i < 0) {
            break label383;
          }
          localObject = cj(i);
          if (localObject == null) {
            break label383;
          }
          if (((v)localObject).arI.hasFocusable())
          {
            localObject = ((v)localObject).arI;
            break;
          }
          i -= 1;
        }
        label383:
        localObject = null;
        break label261;
        localObject = ((v)localObject).arI;
        break label261;
        break;
      }
    }
  }
  
  private void kG()
  {
    this.apT.cB(1);
    m(this.apT);
    this.apT.arw = false;
    kk();
    this.aoZ.clear();
    kv();
    kB();
    kD();
    Object localObject = this.apT;
    if ((this.apT.arx) && (this.apX)) {}
    int j;
    int i;
    RecyclerView.f.c localc;
    for (boolean bool = true;; bool = false)
    {
      ((s)localObject).arv = bool;
      this.apX = false;
      this.apW = false;
      this.apT.aru = this.apT.ary;
      this.apT.ars = this.aaj.getItemCount();
      m(this.aqc);
      if (!this.apT.arx) {
        break;
      }
      j = this.aoY.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = bv(this.aoY.getChildAt(i));
        if ((!((v)localObject).ll()) && ((!((v)localObject).bc()) || (this.aaj.aqm)))
        {
          localc = this.apE.a(this.apT, (v)localObject, f.m((v)localObject), ((v)localObject).lz());
          this.aoZ.b((v)localObject, localc);
          if ((this.apT.arv) && (((v)localObject).lC()) && (!((v)localObject).isRemoved()) && (!((v)localObject).ll()) && (!((v)localObject).bc()))
          {
            long l = g((v)localObject);
            this.aoZ.a(l, (v)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.apT.ary)
    {
      kK();
      bool = this.apT.art;
      this.apT.art = false;
      this.apd.c(this.aoV, this.apT);
      this.apT.art = bool;
      i = 0;
      if (i < this.aoY.getChildCount())
      {
        localObject = bv(this.aoY.getChildAt(i));
        if ((!((v)localObject).ll()) && (!this.aoZ.F((v)localObject)))
        {
          int k = f.m((v)localObject);
          bool = ((v)localObject).cC(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localc = this.apE.a(this.apT, (v)localObject, j, ((v)localObject).lz());
          if (!bool) {
            break label471;
          }
          a((v)localObject, localc);
        }
        for (;;)
        {
          i += 1;
          break;
          label471:
          this.aoZ.c((v)localObject, localc);
        }
      }
      kL();
    }
    for (;;)
    {
      at(true);
      as(false);
      this.apT.arr = 2;
      return;
      kL();
    }
  }
  
  private void kH()
  {
    kk();
    kv();
    this.apT.cB(6);
    this.aoX.iw();
    this.apT.ars = this.aaj.getItemCount();
    this.apT.arq = 0;
    this.apT.aru = false;
    this.apd.c(this.aoV, this.apT);
    this.apT.art = false;
    this.aoW = null;
    s locals = this.apT;
    if ((this.apT.arx) && (this.apE != null)) {}
    for (boolean bool = true;; bool = false)
    {
      locals.arx = bool;
      this.apT.arr = 4;
      at(true);
      as(false);
      return;
    }
  }
  
  private void kI()
  {
    this.apT.cB(4);
    kk();
    kv();
    this.apT.arr = 1;
    if (this.apT.arx)
    {
      int i = this.aoY.getChildCount() - 1;
      if (i >= 0)
      {
        v localv1 = bv(this.aoY.getChildAt(i));
        RecyclerView.f.c localc2;
        v localv2;
        boolean bool1;
        boolean bool2;
        RecyclerView.f.c localc1;
        if (!localv1.ll())
        {
          long l = g(localv1);
          localc2 = new RecyclerView.f.c().c(localv1, 0);
          localv2 = this.aoZ.l(l);
          if ((localv2 == null) || (localv2.ll())) {
            break label224;
          }
          bool1 = this.aoZ.E(localv2);
          bool2 = this.aoZ.E(localv1);
          if ((bool1) && (localv2 == localv1)) {
            break label224;
          }
          localc1 = this.aoZ.d(localv2, 4);
          this.aoZ.d(localv1, localc2);
          localc2 = this.aoZ.d(localv1, 8);
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
          this.aoZ.d(localv1, localc2);
        }
      }
      this.aoZ.a(this.aqj);
    }
    this.apd.c(this.aoV);
    this.apT.arp = this.apT.ars;
    this.apv = false;
    this.apw = false;
    this.apT.arx = false;
    this.apT.ary = false;
    this.apd.aqz = false;
    if (this.aoV.aqV != null) {
      this.aoV.aqV.clear();
    }
    if (this.apd.aqE)
    {
      this.apd.aqD = 0;
      this.apd.aqE = false;
      this.aoV.lf();
    }
    this.apd.a(this.apT);
    at(true);
    as(false);
    this.aoZ.clear();
    if (am(this.aqc[0], this.aqc[1])) {
      an(0, 0);
    }
    kF();
    kE();
  }
  
  private void kK()
  {
    int j = this.aoY.iT();
    int i = 0;
    while (i < j)
    {
      v localv = bv(this.aoY.bL(i));
      if (!localv.ll()) {
        localv.lk();
      }
      i += 1;
    }
  }
  
  private void kL()
  {
    int j = this.aoY.iT();
    int i = 0;
    while (i < j)
    {
      v localv = bv(this.aoY.bL(i));
      if (!localv.ll()) {
        localv.lj();
      }
      i += 1;
    }
    this.aoV.kL();
  }
  
  private void kM()
  {
    int j = this.aoY.iT();
    int i = 0;
    while (i < j)
    {
      v localv = bv(this.aoY.bL(i));
      if ((localv != null) && (!localv.ll())) {
        localv.addFlags(6);
      }
      i += 1;
    }
    kJ();
    this.aoV.kM();
  }
  
  private void kO()
  {
    int i = this.aqg.size() - 1;
    while (i >= 0)
    {
      v localv = (v)this.aqg.get(i);
      if ((localv.arI.getParent() == this) && (!localv.ll()))
      {
        int j = localv.arX;
        if (j != -1)
        {
          t.p(localv.arI, j);
          localv.arX = -1;
        }
      }
      i -= 1;
    }
    this.aqg.clear();
  }
  
  private void km()
  {
    this.apQ.stop();
    if (this.apd != null) {
      this.apd.kZ();
    }
  }
  
  private void kn()
  {
    boolean bool2 = false;
    if (this.apA != null)
    {
      this.apA.onRelease();
      bool2 = this.apA.isFinished();
    }
    boolean bool1 = bool2;
    if (this.apB != null)
    {
      this.apB.onRelease();
      bool1 = bool2 | this.apB.isFinished();
    }
    bool2 = bool1;
    if (this.apC != null)
    {
      this.apC.onRelease();
      bool2 = bool1 | this.apC.isFinished();
    }
    bool1 = bool2;
    if (this.apD != null)
    {
      this.apD.onRelease();
      bool1 = bool2 | this.apD.isFinished();
    }
    if (bool1) {
      t.W(this);
    }
  }
  
  private void ko()
  {
    if (this.apA != null) {
      return;
    }
    this.apA = e.e(this);
    if (this.apa)
    {
      this.apA.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.apA.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void kp()
  {
    if (this.apC != null) {
      return;
    }
    this.apC = e.e(this);
    if (this.apa)
    {
      this.apC.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.apC.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void kq()
  {
    if (this.apB != null) {
      return;
    }
    this.apB = e.e(this);
    if (this.apa)
    {
      this.apB.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.apB.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void kr()
  {
    if (this.apD != null) {
      return;
    }
    this.apD = e.e(this);
    if (this.apa)
    {
      this.apD.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.apD.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void ks()
  {
    this.apD = null;
    this.apB = null;
    this.apC = null;
    this.apA = null;
  }
  
  private void kt()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    aM(0);
    kn();
  }
  
  private void ku()
  {
    kt();
    setScrollState(0);
  }
  
  private void kx()
  {
    int i = this.apr;
    this.apr = 0;
    if ((i != 0) && (kw()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      android.support.v4.view.a.a.a(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private void m(s params)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.apQ.RH;
      params.arC = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      params.arD = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    params.arC = 0;
    params.arD = 0;
  }
  
  private void m(int[] paramArrayOfInt)
  {
    int i2 = this.aoY.getChildCount();
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
      v localv = bv(this.aoY.getChildAt(n));
      m = i;
      if (localv.ll()) {
        break label122;
      }
      int i1 = localv.lm();
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
  
  private boolean t(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().t(paramInt1, paramInt2);
  }
  
  final void E(String paramString)
  {
    if (ky())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + kh());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.apy > 0) {
      new IllegalStateException(kh());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = 0;
    if (this.apd == null) {}
    for (;;)
    {
      return;
      if (!this.apo)
      {
        if (!this.apd.jE()) {
          paramInt1 = 0;
        }
        if (!this.apd.jF()) {
          paramInt2 = i;
        }
        while ((paramInt1 != 0) || (paramInt2 != 0))
        {
          u localu = this.apQ;
          i = localu.aE(paramInt1, paramInt2);
          Interpolator localInterpolator = paramInterpolator;
          if (paramInterpolator == null) {
            localInterpolator = aqi;
          }
          localu.b(paramInt1, paramInt2, i, localInterpolator);
          return;
        }
      }
    }
  }
  
  public final void a(h paramh)
  {
    if (this.apd != null) {
      this.apd.E("Cannot add item decoration during a scroll  or layout");
    }
    if (this.apf.isEmpty()) {
      setWillNotDraw(false);
    }
    this.apf.add(paramh);
    kJ();
    requestLayout();
  }
  
  public final void a(j paramj)
  {
    if (this.apu == null) {
      this.apu = new ArrayList();
    }
    this.apu.add(paramj);
  }
  
  public final void a(l paraml)
  {
    this.apg.add(paraml);
  }
  
  public final void a(m paramm)
  {
    if (this.apV == null) {
      this.apV = new ArrayList();
    }
    this.apV.add(paramm);
  }
  
  final void a(v paramv, RecyclerView.f.c paramc)
  {
    paramv.setFlags(0, 8192);
    if ((this.apT.arv) && (paramv.lC()) && (!paramv.isRemoved()) && (!paramv.ll()))
    {
      long l = g(paramv);
      this.aoZ.a(l, paramv);
    }
    this.aoZ.b(paramv, paramc);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public final void aM(int paramInt)
  {
    getScrollingChildHelper().aM(paramInt);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((this.apd == null) || (!this.apd.a(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public boolean ai(int paramInt1, int paramInt2)
  {
    if (this.apd == null) {}
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
        } while (this.apo);
        bool2 = this.apd.jE();
        bool3 = this.apd.jF();
        if (bool2)
        {
          i = paramInt1;
          if (Math.abs(paramInt1) >= this.apL) {}
        }
        else
        {
          i = 0;
        }
        if (bool3)
        {
          j = paramInt2;
          if (Math.abs(paramInt2) >= this.apL) {}
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
        if ((this.apK == null) || (!this.apK.aA(i, j))) {
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
      t(paramInt2, 1);
      paramInt1 = Math.max(-this.apM, Math.min(i, this.apM));
      paramInt2 = Math.max(-this.apM, Math.min(j, this.apM));
      u localu = this.apQ;
      localu.aqk.setScrollState(2);
      localu.arF = 0;
      localu.arE = 0;
      localu.RH.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      localu.li();
      return true;
    }
  }
  
  final void aj(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.apA != null)
    {
      bool1 = bool2;
      if (!this.apA.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.apA.onRelease();
          bool1 = this.apA.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.apC != null)
    {
      bool2 = bool1;
      if (!this.apC.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.apC.onRelease();
          bool2 = bool1 | this.apC.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.apB != null)
    {
      bool1 = bool2;
      if (!this.apB.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.apB.onRelease();
          bool1 = bool2 | this.apB.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.apD != null)
    {
      bool2 = bool1;
      if (!this.apD.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.apD.onRelease();
          bool2 = bool1 | this.apD.isFinished();
        }
      }
    }
    if (bool2) {
      t.W(this);
    }
  }
  
  final void ak(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ko();
      this.apA.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label66;
      }
      kq();
      this.apB.onAbsorb(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        t.W(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      kp();
      this.apC.onAbsorb(paramInt1);
      break;
      label66:
      if (paramInt2 > 0)
      {
        kr();
        this.apD.onAbsorb(paramInt2);
      }
    }
  }
  
  final void al(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(i.m(paramInt1, getPaddingLeft() + getPaddingRight(), t.ae(this)), i.m(paramInt2, getPaddingTop() + getPaddingBottom(), t.af(this)));
  }
  
  final void an(int paramInt1, int paramInt2)
  {
    this.apy += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.apU != null) {
      this.apU.a(this, paramInt1, paramInt2);
    }
    if (this.apV != null)
    {
      i = this.apV.size() - 1;
      while (i >= 0)
      {
        ((m)this.apV.get(i)).a(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.apy -= 1;
  }
  
  final void as(boolean paramBoolean)
  {
    if (this.apm <= 0) {
      this.apm = 1;
    }
    if ((!paramBoolean) && (!this.apo)) {
      this.apn = false;
    }
    if (this.apm == 1)
    {
      if ((paramBoolean) && (this.apn) && (!this.apo) && (this.apd != null) && (this.aaj != null)) {
        kC();
      }
      if (!this.apo) {
        this.apn = false;
      }
    }
    this.apm -= 1;
  }
  
  final void at(boolean paramBoolean)
  {
    this.apx -= 1;
    if (this.apx <= 0)
    {
      this.apx = 0;
      if (paramBoolean)
      {
        kx();
        kO();
      }
    }
  }
  
  final void au(boolean paramBoolean)
  {
    this.apw |= paramBoolean;
    this.apv = true;
    kM();
  }
  
  final void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    kk();
    kv();
    e.beginSection("RV Scroll");
    m(this.apT);
    if (paramInt1 != 0) {}
    for (paramInt1 = this.apd.a(paramInt1, this.aoV, this.apT);; paramInt1 = 0)
    {
      if (paramInt2 != 0) {}
      for (paramInt2 = this.apd.b(paramInt2, this.aoV, this.apT);; paramInt2 = 0)
      {
        e.endSection();
        int j = this.aoY.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = this.aoY.getChildAt(i);
          Object localObject = bh(localView);
          if ((localObject != null) && (((v)localObject).arP != null))
          {
            localObject = ((v)localObject).arP.arI;
            int k = localView.getLeft();
            int m = localView.getTop();
            if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
              ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
            }
          }
          i += 1;
        }
        at(true);
        as(false);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramInt1;
          paramArrayOfInt[1] = paramInt2;
        }
        return;
      }
    }
  }
  
  public final void b(h paramh)
  {
    a(paramh);
  }
  
  public final void b(l paraml)
  {
    this.apg.remove(paraml);
    if (this.aph == paraml) {
      this.aph = null;
    }
  }
  
  public final void b(m paramm)
  {
    if (this.apV != null) {
      this.apV.remove(paramm);
    }
  }
  
  final boolean b(v paramv, int paramInt)
  {
    if (ky())
    {
      paramv.arX = paramInt;
      this.aqg.add(paramv);
      return false;
    }
    t.p(paramv.arI, paramInt);
    return true;
  }
  
  final void bA(View paramView)
  {
    v localv = bv(paramView);
    if ((this.aaj != null) && (localv != null)) {
      this.aaj.l(localv);
    }
    if (this.apu != null)
    {
      int i = this.apu.size() - 1;
      while (i >= 0)
      {
        ((j)this.apu.get(i)).bR(paramView);
        i -= 1;
      }
    }
  }
  
  public final v bh(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return bv(paramView);
  }
  
  public final View bt(View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this) {
      return paramView;
    }
    return null;
  }
  
  public final v bu(View paramView)
  {
    paramView = bt(paramView);
    if (paramView == null) {
      return null;
    }
    return bh(paramView);
  }
  
  final Rect by(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.aqM) {
      return localLayoutParams.amT;
    }
    if ((this.apT.aru) && ((localLayoutParams.aqL.lC()) || (localLayoutParams.aqL.bc()))) {
      return localLayoutParams.amT;
    }
    Rect localRect = localLayoutParams.amT;
    localRect.set(0, 0, 0, 0);
    int j = this.apf.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((h)this.apf.get(i)).a(this.mTempRect, paramView, this, this.apT);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.aqM = false;
    return localRect;
  }
  
  public final void c(h paramh)
  {
    if (this.apd != null) {
      this.apd.E("Cannot remove item decoration during a scroll  or layout");
    }
    this.apf.remove(paramh);
    if (this.apf.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      kJ();
      requestLayout();
      return;
    }
  }
  
  public void ca(int paramInt)
  {
    if (this.apo) {}
    do
    {
      return;
      kl();
    } while (this.apd == null);
    i locali = this.apd;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(locali, locala.adn(), "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    locali.ca(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(locali, "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
  }
  
  final void cg(int paramInt)
  {
    if (this.apd == null) {
      return;
    }
    i locali = this.apd;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(locali, locala.adn(), "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    locali.ca(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(locali, "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.apd.a((LayoutParams)paramLayoutParams));
  }
  
  public final v ci(int paramInt)
  {
    return j(paramInt, false);
  }
  
  public final v cj(int paramInt)
  {
    Object localObject = null;
    if (this.apv) {}
    int i;
    v localv;
    do
    {
      return localObject;
      int j = this.aoY.iT();
      i = 0;
      localObject = null;
      if (i >= j) {
        break;
      }
      localv = bv(this.aoY.bL(i));
      if ((localv == null) || (localv.isRemoved()) || (i(localv) != paramInt)) {
        break label100;
      }
      localObject = localv;
    } while (!this.aoY.bg(localv.arI));
    localObject = localv;
    label100:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.apd == null) {}
    while (!this.apd.jE()) {
      return 0;
    }
    return this.apd.f(this.apT);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.apd == null) {}
    while (!this.apd.jE()) {
      return 0;
    }
    return this.apd.d(this.apT);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.apd == null) {}
    while (!this.apd.jE()) {
      return 0;
    }
    return this.apd.h(this.apT);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.apd == null) {}
    while (!this.apd.jF()) {
      return 0;
    }
    return this.apd.g(this.apT);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.apd == null) {}
    while (!this.apd.jF()) {
      return 0;
    }
    return this.apd.e(this.apT);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.apd == null) {}
    while (!this.apd.jF()) {
      return 0;
    }
    return this.apd.i(this.apT);
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
    int j = this.apf.size();
    int i = 0;
    while (i < j)
    {
      ((h)this.apf.get(i)).b(paramCanvas, this, this.apT);
      i += 1;
    }
    int n;
    if ((this.apA != null) && (!this.apA.isFinished()))
    {
      n = paramCanvas.save();
      if (this.apa)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.apA == null) || (!this.apA.draw(paramCanvas))) {
          break label456;
        }
        j = 1;
        label128:
        paramCanvas.restoreToCount(n);
      }
    }
    for (;;)
    {
      i = j;
      if (this.apB != null)
      {
        i = j;
        if (!this.apB.isFinished())
        {
          n = paramCanvas.save();
          if (this.apa) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.apB == null) || (!this.apB.draw(paramCanvas))) {
            break label461;
          }
          i = 1;
          label202:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.apC != null)
      {
        j = i;
        if (!this.apC.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.apa) {
            break label466;
          }
          j = getPaddingTop();
          label257:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.apC == null) || (!this.apC.draw(paramCanvas))) {
            break label471;
          }
          j = 1;
          label295:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.apD != null)
      {
        i = j;
        if (!this.apD.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.apa) {
            break label476;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label372:
          i = m;
          if (this.apD != null)
          {
            i = m;
            if (this.apD.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.apE != null) && (this.apf.size() > 0) && (this.apE.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          t.W(this);
        }
        return;
        i = 0;
        break;
        label456:
        j = 0;
        break label128;
        label461:
        i = 0;
        break label202;
        label466:
        j = 0;
        break label257;
        label471:
        j = 0;
        break label295;
        label476:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label372;
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
    int j = this.aoY.iT();
    int i = 0;
    if (i < j)
    {
      localObject = bv(this.aoY.bL(i));
      if ((localObject != null) && (!((v)localObject).ll()))
      {
        if (((v)localObject).mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        ((v)localObject).k(-paramInt2, paramBoolean);
        this.apT.art = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        if (((v)localObject).mPosition >= paramInt1)
        {
          int k = -paramInt2;
          ((v)localObject).addFlags(8);
          ((v)localObject).k(k, paramBoolean);
          ((v)localObject).mPosition = (paramInt1 - 1);
          this.apT.art = true;
        }
      }
    }
    Object localObject = this.aoV;
    i = ((o)localObject).aqW.size() - 1;
    if (i >= 0)
    {
      v localv = (v)((o)localObject).aqW.get(i);
      if (localv != null)
      {
        if (localv.mPosition < paramInt1 + paramInt2) {
          break label200;
        }
        localv.k(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label200:
        if (localv.mPosition >= paramInt1)
        {
          localv.addFlags(8);
          ((o)localObject).cx(i);
        }
      }
    }
    requestLayout();
  }
  
  final void f(v paramv)
  {
    View localView = paramv.arI;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.aoV.u(bh(localView));
      if (!paramv.lw()) {
        break;
      }
      this.aoY.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.aoY.a(localView, -1, true);
      return;
    }
    paramv = this.aoY;
    i = paramv.aiZ.indexOfChild(localView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localView)));
    }
    paramv.aja.set(i);
    paramv.be(localView);
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int i1 = -1;
    int n = 0;
    int i;
    Object localObject;
    label74:
    int k;
    if ((this.aaj != null) && (this.apd != null) && (!ky()) && (!this.apo))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label327;
      }
      if (!this.apd.jF()) {
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
      if (aoR) {
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
        if (this.apd.jE())
        {
          if (t.Y(this.apd.akA) != 1) {
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
        if (aoR)
        {
          k = i;
          m = j;
        }
        if (m == 0) {
          break label288;
        }
        kj();
        if (bt(paramView) != null) {
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
      kk();
      this.apd.a(paramView, k, this.aoV, this.apT);
      as(false);
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
              kj();
              if (bt(paramView) == null) {
                return null;
              }
              kk();
              localObject = this.apd.a(paramView, paramInt, this.aoV, this.apT);
              as(false);
              k = paramInt;
            }
          }
        }
        else
        {
          f((View)localObject, null);
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
          if (bt((View)localObject) != null) {
            if (paramView == null)
            {
              paramInt = 1;
            }
            else if (bt(paramView) == null)
            {
              paramInt = 1;
            }
            else
            {
              this.mTempRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
              this.Wl.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.mTempRect);
              offsetDescendantRectToMyCoords((View)localObject, this.Wl);
              if (t.Y(this.apd.akA) == 1)
              {
                m = -1;
                if (((this.mTempRect.left >= this.Wl.left) && (this.mTempRect.right > this.Wl.left)) || (this.mTempRect.right >= this.Wl.right)) {
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
        if (((this.mTempRect.top < this.Wl.top) || (this.mTempRect.bottom <= this.Wl.top)) && (this.mTempRect.bottom < this.Wl.bottom)) {
          j = 1;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            throw new IllegalArgumentException("Invalid direction: " + k + kh());
            m = 1;
            break label547;
            label755:
            if (((this.mTempRect.right <= this.Wl.right) && (this.mTempRect.left < this.Wl.right)) || (this.mTempRect.left <= this.Wl.left)) {
              break label986;
            }
            i = -1;
            break label600;
            if ((this.mTempRect.bottom > this.Wl.bottom) || (this.mTempRect.top >= this.Wl.bottom))
            {
              j = i1;
              if (this.mTempRect.top > this.Wl.top) {}
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
    if (this.apd == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kh());
    }
    return this.apd.jy();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.apd == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kh());
    }
    return this.apd.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.apd == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kh());
    }
    return this.apd.d(paramLayoutParams);
  }
  
  public a getAdapter()
  {
    return this.aaj;
  }
  
  public int getBaseline()
  {
    if (this.apd != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.aqb == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.aqb.av(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return this.apa;
  }
  
  public al getCompatAccessibilityDelegate()
  {
    return this.aqa;
  }
  
  public e getEdgeEffectFactory()
  {
    return this.apz;
  }
  
  public f getItemAnimator()
  {
    return this.apE;
  }
  
  public int getItemDecorationCount()
  {
    return this.apf.size();
  }
  
  public i getLayoutManager()
  {
    return this.apd;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.apM;
  }
  
  public int getMinFlingVelocity()
  {
    return this.apL;
  }
  
  long getNanoTime()
  {
    if (aoQ) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public k getOnFlingListener()
  {
    return this.apK;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.apP;
  }
  
  public n getRecycledViewPool()
  {
    return this.aoV.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  l getScrollingChildHelper()
  {
    if (this.aqd == null) {
      this.aqd = new l(this);
    }
    return this.aqd;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().aN(0);
  }
  
  final int i(v paramv)
  {
    if ((paramv.cC(524)) || (!paramv.isBound())) {
      return -1;
    }
    return this.aoX.bE(paramv.mPosition);
  }
  
  public boolean isAttachedToWindow()
  {
    return this.api;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().Na;
  }
  
  public final v j(int paramInt, boolean paramBoolean)
  {
    int j = this.aoY.iT();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      v localv = bv(this.aoY.bL(i));
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
        if (localv.lm() == paramInt)
        {
          label95:
          localObject1 = localv;
          if (!this.aoY.bg(localv.arI)) {
            break label121;
          }
          localObject2 = localv;
        }
      }
    }
    label121:
    return localObject1;
  }
  
  public final v k(long paramLong)
  {
    v localv2 = null;
    v localv1 = localv2;
    if (this.aaj != null)
    {
      if (this.aaj.aqm) {
        break label31;
      }
      localv1 = localv2;
    }
    label31:
    int i;
    do
    {
      return localv1;
      int j = this.aoY.iT();
      i = 0;
      localv1 = null;
      if (i >= j) {
        break;
      }
      localv2 = bv(this.aoY.bL(i));
      if ((localv2 == null) || (localv2.isRemoved()) || (localv2.arL != paramLong)) {
        break label120;
      }
      localv1 = localv2;
    } while (!this.aoY.bg(localv2.arI));
    localv1 = localv2;
    label120:
    for (;;)
    {
      i += 1;
      break;
      return localv1;
    }
  }
  
  public void kJ()
  {
    int j = 0;
    int k = this.aoY.iT();
    int i = 0;
    while (i < k)
    {
      ((LayoutParams)this.aoY.bL(i).getLayoutParams()).aqM = true;
      i += 1;
    }
    o localo = this.aoV;
    k = localo.aqW.size();
    i = j;
    while (i < k)
    {
      LayoutParams localLayoutParams = (LayoutParams)((v)localo.aqW.get(i)).arI.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.aqM = true;
      }
      i += 1;
    }
  }
  
  public final boolean kN()
  {
    return (!this.apl) || (this.apv) || (this.aoX.iv());
  }
  
  final String kh()
  {
    return " " + super.toString() + ", adapter:" + this.aaj + ", layout:" + this.apd + ", context:" + getContext();
  }
  
  final void ki()
  {
    if (this.apE != null) {
      this.apE.iY();
    }
    if (this.apd != null)
    {
      this.apd.d(this.aoV);
      this.apd.c(this.aoV);
    }
    this.aoV.clear();
  }
  
  final void kj()
  {
    int k = 0;
    if ((!this.apl) || (this.apv))
    {
      e.beginSection("RV FullInvalidate");
      kC();
      e.endSection();
    }
    label168:
    label175:
    do
    {
      do
      {
        return;
      } while (!this.aoX.iv());
      if ((this.aoX.bC(4)) && (!this.aoX.bC(11)))
      {
        e.beginSection("RV PartialInvalidate");
        kk();
        kv();
        this.aoX.it();
        int i;
        if (!this.apn)
        {
          int m = this.aoY.getChildCount();
          i = 0;
          int j = k;
          if (i < m)
          {
            v localv = bv(this.aoY.getChildAt(i));
            if ((localv == null) || (localv.ll()) || (!localv.lC())) {
              break label168;
            }
            j = 1;
          }
          if (j == 0) {
            break label175;
          }
          kC();
        }
        for (;;)
        {
          as(true);
          at(true);
          e.endSection();
          return;
          i += 1;
          break;
          this.aoX.iu();
        }
      }
    } while (!this.aoX.iv());
    e.beginSection("RV FullInvalidate");
    kC();
    e.endSection();
  }
  
  final void kk()
  {
    this.apm += 1;
    if ((this.apm == 1) && (!this.apo)) {
      this.apn = false;
    }
  }
  
  public void kl()
  {
    setScrollState(0);
    km();
  }
  
  final void kv()
  {
    this.apx += 1;
  }
  
  final boolean kw()
  {
    return (this.apt != null) && (this.apt.isEnabled());
  }
  
  public final boolean ky()
  {
    return this.apx > 0;
  }
  
  final void kz()
  {
    if ((!this.apZ) && (this.api))
    {
      t.b(this, this.aqh);
      this.apZ = true;
    }
  }
  
  public final View o(float paramFloat1, float paramFloat2)
  {
    int i = this.aoY.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.aoY.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    boolean bool = true;
    super.onAttachedToWindow();
    this.apx = 0;
    this.api = true;
    float f;
    if ((this.apl) && (!isLayoutRequested()))
    {
      this.apl = bool;
      if (this.apd != null) {
        this.apd.f(this);
      }
      this.apZ = false;
      if (aoQ)
      {
        this.apR = ((ac)ac.akT.get());
        if (this.apR == null)
        {
          this.apR = new ac();
          Display localDisplay = t.aE(this);
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
      this.apR.akW = ((1.0E+009F / f));
      ac.akT.set(this.apR);
      this.apR.akU.add(this);
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
    if (this.apE != null) {
      this.apE.iY();
    }
    kl();
    this.api = false;
    if (this.apd != null) {
      this.apd.b(this, this.aoV);
    }
    this.aqg.clear();
    removeCallbacks(this.aqh);
    bg.a.mJ();
    if ((aoQ) && (this.apR != null))
    {
      this.apR.akU.remove(this);
      this.apR = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.apf.size();
    int i = 0;
    while (i < j)
    {
      ((h)this.apf.get(i)).a(paramCanvas, this, this.apT);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.apd == null) {}
    label188:
    for (;;)
    {
      return false;
      if ((!this.apo) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        float f3;
        float f2;
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
          if (this.apd.jF())
          {
            f1 = -paramMotionEvent.getAxisValue(9);
            if (!this.apd.jE()) {
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
          a((int)(this.apN * f1), (int)(this.apO * f2), paramMotionEvent);
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
            if (this.apd.jF())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.apd.jE())
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
    if (this.apo) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.aph = null;
    }
    int k = this.apg.size();
    int i = 0;
    if (i < k)
    {
      l locall = (l)this.apg.get(i);
      if ((locall.a(this, paramMotionEvent)) && (j != 3)) {
        this.aph = locall;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label105;
      }
      ku();
      return true;
      i += 1;
      break;
    }
    label105:
    if (this.apd == null) {
      return false;
    }
    boolean bool1 = this.apd.jE();
    boolean bool2 = this.apd.jF();
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
      if (this.apq) {
        this.apq = false;
      }
      this.apF = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.apI = i;
      this.apG = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.apJ = i;
      this.apH = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.aqe;
      this.aqe[1] = 0;
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
      t(j, 0);
      break;
      this.apF = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.apI = j;
      this.apG = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.apJ = i;
      this.apH = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.apF);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.apF).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.apG;
      int m = this.apH;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.apI = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.apJ = k;
            j = 1;
          }
        }
        if (j == 0) {
          break;
        }
        setScrollState(1);
        break;
        k(paramMotionEvent);
        break;
        this.mVelocityTracker.clear();
        aM(0);
        break;
        ku();
        break;
        return false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e.beginSection("RV OnLayout");
    kC();
    e.endSection();
    this.apl = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.apd == null) {
      al(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.apd.jD()) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        this.apd.az(paramInt1, paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
      } while ((i != 0) || (this.aaj == null));
      if (this.apT.arr == 1) {
        kG();
      }
      this.apd.aw(paramInt1, paramInt2);
      this.apT.arw = true;
      kH();
      this.apd.ax(paramInt1, paramInt2);
    } while (!this.apd.jJ());
    this.apd.aw(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.apT.arw = true;
    kH();
    this.apd.ax(paramInt1, paramInt2);
    return;
    if (this.apj)
    {
      this.apd.az(paramInt1, paramInt2);
      return;
    }
    if (this.aps)
    {
      kk();
      kv();
      kB();
      at(true);
      if (this.apT.ary)
      {
        this.apT.aru = true;
        this.aps = false;
        as(false);
        label256:
        if (this.aaj == null) {
          break label345;
        }
      }
    }
    label345:
    for (this.apT.ars = this.aaj.getItemCount();; this.apT.ars = 0)
    {
      kk();
      this.apd.az(paramInt1, paramInt2);
      as(false);
      this.apT.aru = false;
      return;
      this.aoX.iw();
      this.apT.aru = false;
      break;
      if (!this.apT.ary) {
        break label256;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (ky()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      this.aoW = ((SavedState)paramParcelable);
      super.onRestoreInstanceState(this.aoW.Mm);
    } while ((this.apd == null) || (this.aoW.arc == null));
    this.apd.onRestoreInstanceState(this.aoW.arc);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.aoW != null)
    {
      localSavedState.arc = this.aoW.arc;
      return localSavedState;
    }
    if (this.apd != null)
    {
      localSavedState.arc = this.apd.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.arc = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      ks();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.apo) || (this.apq)) {}
    label146:
    label155:
    label161:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.aph != null)
      {
        if (i == 0) {
          this.aph = null;
        }
      }
      else
      {
        if (i == 0) {
          break label155;
        }
        j = this.apg.size();
        i = 0;
        if (i >= j) {
          break label155;
        }
        localObject = (l)this.apg.get(i);
        if (!((l)localObject).a(this, paramMotionEvent)) {
          break label146;
        }
        this.aph = ((l)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label161;
        }
        ku();
        return true;
        this.aph.b(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.aph = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.apd == null);
    boolean bool1 = this.apd.jE();
    boolean bool2 = this.apd.jF();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.aqe;
      this.aqe[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.aqe[0], this.aqe[1]);
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
      this.apF = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.apI = i;
      this.apG = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.apJ = i;
      this.apH = i;
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
      t(j, 0);
      i = i2;
      break;
      this.apF = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.apI = i;
      this.apG = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.apJ = i;
      this.apH = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.apF);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.apF).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.apI - i3;
      k = this.apJ - i4;
      j = m;
      i = k;
      if (a(m, k, this.RR, this.RQ, 0))
      {
        j = m - this.RR[0];
        i = k - this.RR[1];
        ((MotionEvent)localObject).offsetLocation(this.RQ[0], this.RQ[1]);
        paramMotionEvent = this.aqe;
        paramMotionEvent[0] += this.RQ[0];
        paramMotionEvent = this.aqe;
        paramMotionEvent[1] += this.RQ[1];
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
        this.apI = (i3 - this.RQ[0]);
        this.apJ = (i4 - this.RQ[1]);
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
          if (this.apR == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.apR.b(this, k, m);
          i = i2;
          break;
          j = this.mTouchSlop + j;
          break label730;
          i = this.mTouchSlop + i;
          break label780;
          i = 0;
          break label860;
        }
        k(paramMotionEvent);
        i = i2;
        break;
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.apM);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.apF);
          if (!bool2) {
            break label1087;
          }
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.apF);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!ai((int)f1, (int)f2))) {
            setScrollState(0);
          }
          kt();
          i = 1;
          break;
          f1 = 0.0F;
          break label1026;
        }
        ku();
        i = i2;
        break;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    v localv = bv(paramView);
    if (localv != null)
    {
      if (!localv.lw()) {
        break label36;
      }
      localv.lu();
    }
    label36:
    while (localv.ll())
    {
      paramView.clearAnimation();
      bA(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localv + kh());
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((this.apd.kX()) || (ky())) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramView2 != null)) {
        f(paramView1, paramView2);
      }
      super.requestChildFocus(paramView1, paramView2);
      return;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.apd.a(this, paramView, paramRect, paramBoolean, false);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.apg.size();
    int i = 0;
    while (i < j)
    {
      ((l)this.apg.get(i)).ai(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.apm == 0) && (!this.apo))
    {
      super.requestLayout();
      return;
    }
    this.apn = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.apd == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.apo);
      bool1 = this.apd.jE();
      bool2 = this.apd.jF();
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
    if (ky())
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
        this.apr |= i;
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
    this.aqa = paramal;
    t.a(this, this.aqa);
  }
  
  public void setAdapter(a parama)
  {
    setLayoutFrozen(false);
    if (this.aaj != null)
    {
      this.aaj.b(this.aoU);
      this.aaj.d(this);
    }
    ki();
    this.aoX.reset();
    a locala = this.aaj;
    this.aaj = parama;
    if (parama != null)
    {
      parama.a(this.aoU);
      parama.c(this);
    }
    if (this.apd != null) {
      this.apd.kY();
    }
    Object localObject = this.aoV;
    parama = this.aaj;
    ((o)localObject).clear();
    localObject = ((o)localObject).getRecycledViewPool();
    if (locala != null) {
      ((n)localObject).detach();
    }
    if (((n)localObject).aqP == 0)
    {
      int i = 0;
      while (i < ((n)localObject).aqO.size())
      {
        ((RecyclerView.n.a)((n)localObject).aqO.valueAt(i)).aqQ.clear();
        i += 1;
      }
    }
    if (parama != null) {
      ((n)localObject).le();
    }
    this.apT.art = true;
    au(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    if (paramd == this.aqb) {
      return;
    }
    this.aqb = paramd;
    if (this.aqb != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.apa) {
      ks();
    }
    this.apa = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.apl) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(e parame)
  {
    m.checkNotNull(parame);
    this.apz = parame;
    ks();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.apj = paramBoolean;
  }
  
  public void setItemAnimator(f paramf)
  {
    if (this.apE != null)
    {
      this.apE.iY();
      this.apE.aqn = null;
    }
    this.apE = paramf;
    if (this.apE != null) {
      this.apE.aqn = this.apY;
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    o localo = this.aoV;
    localo.aqY = paramInt;
    localo.lf();
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.apo)
    {
      E("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.apo = false;
        if ((this.apn) && (this.apd != null) && (this.aaj != null)) {
          requestLayout();
        }
        this.apn = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.apo = true;
    this.apq = true;
    kl();
  }
  
  public void setLayoutManager(i parami)
  {
    if (parami == this.apd) {
      return;
    }
    kl();
    if (this.apd != null)
    {
      if (this.apE != null) {
        this.apE.iY();
      }
      this.apd.d(this.aoV);
      this.apd.c(this.aoV);
      this.aoV.clear();
      if (this.api) {
        this.apd.b(this, this.aoV);
      }
      this.apd.setRecyclerView(null);
      this.apd = null;
    }
    s locals;
    for (;;)
    {
      locals = this.aoY;
      for (s.a locala = locals.aja;; locala = locala.ajd)
      {
        locala.ajc = 0L;
        if (locala.ajd == null) {
          break;
        }
      }
      this.aoV.clear();
    }
    int i = locals.ajb.size() - 1;
    while (i >= 0)
    {
      locals.aiZ.bj((View)locals.ajb.get(i));
      locals.ajb.remove(i);
      i -= 1;
    }
    locals.aiZ.removeAllViews();
    this.apd = parami;
    if (parami != null)
    {
      if (parami.akA != null) {
        throw new IllegalArgumentException("LayoutManager " + parami + " is already attached to a RecyclerView:" + parami.akA.kh());
      }
      this.apd.setRecyclerView(this);
      if (this.api) {
        this.apd.f(this);
      }
    }
    this.aoV.lf();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(k paramk)
  {
    this.apK = paramk;
  }
  
  @Deprecated
  public void setOnScrollListener(m paramm)
  {
    this.apU = paramm;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.apP = paramBoolean;
  }
  
  public void setRecycledViewPool(n paramn)
  {
    o localo = this.aoV;
    if (localo.ara != null) {
      localo.ara.detach();
    }
    localo.ara = paramn;
    if ((localo.ara != null) && (localo.aqk.getAdapter() != null)) {
      localo.ara.le();
    }
  }
  
  public void setRecyclerListener(p paramp)
  {
    this.ape = paramp;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {}
    for (;;)
    {
      return;
      this.mScrollState = paramInt;
      if (paramInt != 2) {
        km();
      }
      if (this.apd != null) {
        this.apd.cq(paramInt);
      }
      if (this.apU != null) {
        this.apU.b(this, paramInt);
      }
      if (this.apV != null)
      {
        int i = this.apV.size() - 1;
        while (i >= 0)
        {
          ((m)this.apV.get(i)).b(this, paramInt);
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
  
  public void setViewCacheExtension(t paramt)
  {
    this.aoV.arb = paramt;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.apo) {}
    while (this.apd == null) {
      return;
    }
    this.apd.a(this, this.apT, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().t(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().aM(0);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect amT = new Rect();
    public RecyclerView.v aqL;
    boolean aqM = true;
    boolean aqN = false;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public final int ld()
    {
      return this.aqL.ln();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    Parcelable arc;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader != null) {}
      for (;;)
      {
        this.arc = paramParcel.readParcelable(paramClassLoader);
        return;
        paramClassLoader = RecyclerView.i.class.getClassLoader();
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.arc, 0);
    }
  }
  
  public static abstract class a<VH extends RecyclerView.v>
  {
    public final RecyclerView.b aql = new RecyclerView.b();
    protected boolean aqm = false;
    
    public abstract VH a(ViewGroup paramViewGroup, int paramInt);
    
    public void a(RecyclerView.c paramc)
    {
      this.aql.registerObserver(paramc);
    }
    
    public void a(VH paramVH) {}
    
    public abstract void a(VH paramVH, int paramInt);
    
    public void a(VH paramVH, int paramInt, List<Object> paramList)
    {
      a(paramVH, paramInt);
    }
    
    public final void ao(int paramInt1, int paramInt2)
    {
      this.aql.ao(paramInt1, paramInt2);
    }
    
    public final void ap(int paramInt1, int paramInt2)
    {
      this.aql.ap(paramInt1, paramInt2);
    }
    
    public final void aq(int paramInt1, int paramInt2)
    {
      this.aql.aq(paramInt1, paramInt2);
    }
    
    public final void ar(int paramInt1, int paramInt2)
    {
      this.aql.ar(paramInt1, paramInt2);
    }
    
    public void av(boolean paramBoolean)
    {
      if (this.aql.hasObservers()) {
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      }
      this.aqm = paramBoolean;
    }
    
    public final void b(int paramInt, Object paramObject)
    {
      this.aql.e(paramInt, 1, paramObject);
    }
    
    public void b(RecyclerView.c paramc)
    {
      this.aql.unregisterObserver(paramc);
    }
    
    public void c(RecyclerView paramRecyclerView) {}
    
    public final void ck(int paramInt)
    {
      this.aql.ao(paramInt, 1);
    }
    
    public final void cl(int paramInt)
    {
      this.aql.aq(paramInt, 1);
    }
    
    public final void cm(int paramInt)
    {
      this.aql.ar(paramInt, 1);
    }
    
    public final VH d(ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        e.beginSection("RV CreateView");
        paramViewGroup = a(paramViewGroup, paramInt);
        if (paramViewGroup.arI.getParent() != null) {
          throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        }
      }
      finally
      {
        e.endSection();
      }
      paramViewGroup.arM = paramInt;
      e.endSection();
      return paramViewGroup;
    }
    
    public void d(RecyclerView paramRecyclerView) {}
    
    public final void e(int paramInt1, int paramInt2, Object paramObject)
    {
      this.aql.e(paramInt1, paramInt2, paramObject);
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
    
    public void k(VH paramVH) {}
    
    public void l(VH paramVH) {}
    
    public final void notifyDataSetChanged()
    {
      this.aql.notifyChanged();
    }
  }
  
  public static final class b
    extends Observable<RecyclerView.c>
  {
    public final void ao(int paramInt1, int paramInt2)
    {
      e(paramInt1, paramInt2, null);
    }
    
    public final void ap(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).l(paramInt1, paramInt2, 1);
        i -= 1;
      }
    }
    
    public final void aq(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).at(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public final void ar(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).au(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public final void e(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).f(paramInt1, paramInt2, paramObject);
        i -= 1;
      }
    }
    
    public final boolean hasObservers()
    {
      return !this.mObservers.isEmpty();
    }
    
    public final void notifyChanged()
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onChanged();
        i -= 1;
      }
    }
  }
  
  public static abstract class c
  {
    public void as(int paramInt1, int paramInt2) {}
    
    public void at(int paramInt1, int paramInt2) {}
    
    public void au(int paramInt1, int paramInt2) {}
    
    public void f(int paramInt1, int paramInt2, Object paramObject)
    {
      as(paramInt1, paramInt2);
    }
    
    public void l(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onChanged() {}
  }
  
  public static abstract interface d
  {
    public abstract int av(int paramInt1, int paramInt2);
  }
  
  public static final class e
  {
    protected static EdgeEffect e(RecyclerView paramRecyclerView)
    {
      return new EdgeEffect(paramRecyclerView.getContext());
    }
  }
  
  public static abstract class f
  {
    b aqn = null;
    private ArrayList<a> aqo = new ArrayList();
    public long aqp = 120L;
    public long aqq = 120L;
    public long aqr = 250L;
    public long aqs = 250L;
    
    static int m(RecyclerView.v paramv)
    {
      int j = paramv.CW & 0xE;
      int i;
      if (paramv.bc()) {
        i = 4;
      }
      int k;
      int m;
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while ((j & 0x4) != 0);
            k = paramv.arK;
            m = paramv.ln();
            i = j;
          } while (k == -1);
          i = j;
        } while (m == -1);
        i = j;
      } while (k == m);
      return j | 0x800;
    }
    
    public c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      return new c().c(paramv, 0);
    }
    
    public final boolean a(a parama)
    {
      boolean bool = isRunning();
      if (parama != null)
      {
        if (!bool) {
          parama.kV();
        }
      }
      else {
        return bool;
      }
      this.aqo.add(parama);
      return bool;
    }
    
    public abstract boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, c paramc1, c paramc2);
    
    public boolean a(RecyclerView.v paramv, List<Object> paramList)
    {
      return p(paramv);
    }
    
    public abstract void d(RecyclerView.v paramv);
    
    public abstract boolean d(RecyclerView.v paramv, c paramc1, c paramc2);
    
    public abstract boolean e(RecyclerView.v paramv, c paramc1, c paramc2);
    
    public abstract boolean f(RecyclerView.v paramv, c paramc1, c paramc2);
    
    public abstract void iW();
    
    public abstract void iY();
    
    public abstract boolean isRunning();
    
    public long kP()
    {
      return this.aqp;
    }
    
    public long kQ()
    {
      return this.aqq;
    }
    
    public final void kR()
    {
      this.aqq = 2000L;
    }
    
    public final long kS()
    {
      return this.aqs;
    }
    
    public final void kT()
    {
      this.aqs = 0L;
    }
    
    public final void kU()
    {
      int j = this.aqo.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.aqo.get(i)).kV();
        i += 1;
      }
      this.aqo.clear();
    }
    
    public final void n(RecyclerView.v paramv)
    {
      o(paramv);
      if (this.aqn != null) {
        this.aqn.o(paramv);
      }
    }
    
    public void o(RecyclerView.v paramv) {}
    
    public boolean p(RecyclerView.v paramv)
    {
      return true;
    }
    
    public static abstract interface a
    {
      public abstract void kV();
    }
    
    static abstract interface b
    {
      public abstract void o(RecyclerView.v paramv);
    }
    
    public static class c
    {
      public int aqt;
      public int bottom;
      public int left;
      public int right;
      public int top;
      
      public c c(RecyclerView.v paramv, int paramInt)
      {
        paramv = paramv.arI;
        this.left = paramv.getLeft();
        this.top = paramv.getTop();
        this.right = paramv.getRight();
        this.bottom = paramv.getBottom();
        return this;
      }
    }
  }
  
  final class g
    implements RecyclerView.f.b
  {
    g() {}
    
    public final void o(RecyclerView.v paramv)
    {
      boolean bool = true;
      paramv.ax(true);
      if ((paramv.arO != null) && (paramv.arP == null)) {
        paramv.arO = null;
      }
      paramv.arP = null;
      int i;
      RecyclerView localRecyclerView;
      Object localObject;
      s locals;
      if ((paramv.CW & 0x10) != 0)
      {
        i = 1;
        if (i == 0)
        {
          localRecyclerView = RecyclerView.this;
          localObject = paramv.arI;
          localRecyclerView.kk();
          locals = localRecyclerView.aoY;
          i = locals.aiZ.indexOfChild((View)localObject);
          if (i != -1) {
            break label169;
          }
          locals.bf((View)localObject);
          i = 1;
          label99:
          if (i != 0)
          {
            localObject = RecyclerView.bv((View)localObject);
            localRecyclerView.aoV.u((RecyclerView.v)localObject);
            localRecyclerView.aoV.t((RecyclerView.v)localObject);
          }
          if (i != 0) {
            break label220;
          }
        }
      }
      for (;;)
      {
        localRecyclerView.as(bool);
        if ((i == 0) && (paramv.lw())) {
          RecyclerView.this.removeDetachedView(paramv.arI, false);
        }
        return;
        i = 0;
        break;
        label169:
        if (locals.aja.get(i))
        {
          locals.aja.remove(i);
          locals.bf((View)localObject);
          locals.aiZ.removeViewAt(i);
          i = 1;
          break label99;
        }
        i = 0;
        break label99;
        label220:
        bool = false;
      }
    }
  }
  
  public static abstract class h
  {
    public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params) {}
    
    public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      paramView.getLayoutParams();
      paramRect.set(0, 0, 0, 0);
    }
    
    public void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params) {}
  }
  
  public static abstract class i
  {
    protected RecyclerView akA;
    s aoY;
    protected boolean aqA = false;
    protected boolean aqB = true;
    boolean aqC = true;
    int aqD;
    boolean aqE;
    protected int aqF;
    protected int aqG;
    private final bf.b aqu = new bf.b()
    {
      public final int bO(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.i.bG(paramAnonymousView) - localLayoutParams.leftMargin;
      }
      
      public final int bP(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.i.bI(paramAnonymousView);
        return localLayoutParams.rightMargin + i;
      }
      
      public final View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.i.this.getChildAt(paramAnonymousInt);
      }
      
      public final int lb()
      {
        return RecyclerView.i.this.getPaddingLeft();
      }
      
      public final int lc()
      {
        return RecyclerView.i.this.mWidth - RecyclerView.i.this.getPaddingRight();
      }
    };
    private final bf.b aqv = new bf.b()
    {
      public final int bO(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.i.bH(paramAnonymousView) - localLayoutParams.topMargin;
      }
      
      public final int bP(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.i.bJ(paramAnonymousView);
        return localLayoutParams.bottomMargin + i;
      }
      
      public final View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.i.this.getChildAt(paramAnonymousInt);
      }
      
      public final int lb()
      {
        return RecyclerView.i.this.getPaddingTop();
      }
      
      public final int lc()
      {
        return RecyclerView.i.this.mHeight - RecyclerView.i.this.getPaddingBottom();
      }
    };
    bf aqw = new bf(this.aqu);
    bf aqx = new bf(this.aqv);
    RecyclerView.r aqy;
    boolean aqz = false;
    public int mHeight;
    public int mWidth;
    boolean nt = false;
    
    private void H(View paramView, int paramInt)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      RecyclerView.v localv = RecyclerView.bv(paramView);
      if (localv.isRemoved()) {
        this.akA.aoZ.G(localv);
      }
      for (;;)
      {
        this.aoY.a(paramView, paramInt, localLayoutParams, localv.isRemoved());
        return;
        this.akA.aoZ.H(localv);
      }
    }
    
    private void a(RecyclerView.o paramo, int paramInt, View paramView)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      if (localv.ll()) {
        return;
      }
      if ((localv.bc()) && (!localv.isRemoved()) && (!this.akA.aaj.aqm))
      {
        removeViewAt(paramInt);
        paramo.t(localv);
        return;
      }
      cn(paramInt);
      paramo.bU(paramView);
      this.akA.aoZ.H(localv);
    }
    
    private void ay(int paramInt1, int paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView == null) {
        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1 + this.akA.toString());
      }
      cn(paramInt1);
      H(localView, paramInt2);
    }
    
    public static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int i = Math.max(0, paramInt1 - paramInt3);
      if (paramBoolean) {
        if (paramInt4 >= 0)
        {
          paramInt1 = 1073741824;
          paramInt3 = paramInt4;
        }
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
        if (paramInt4 == -1)
        {
          paramInt3 = i;
          paramInt1 = paramInt2;
          switch (paramInt2)
          {
          }
          paramInt1 = 0;
          paramInt3 = 0;
        }
        else if (paramInt4 == -2)
        {
          paramInt3 = 0;
          do
          {
            paramInt1 = 0;
            break;
            if (paramInt4 >= 0)
            {
              paramInt1 = 1073741824;
              paramInt3 = paramInt4;
              break;
            }
            paramInt3 = i;
            paramInt1 = paramInt2;
            if (paramInt4 == -1) {
              break;
            }
            if (paramInt4 != -2) {
              break label148;
            }
            if (paramInt2 == -2147483648) {
              break label139;
            }
            paramInt3 = i;
          } while (paramInt2 != 1073741824);
          label139:
          paramInt1 = -2147483648;
          paramInt3 = i;
        }
        else
        {
          label148:
          paramInt1 = 0;
          paramInt3 = 0;
        }
      }
    }
    
    public static int bB(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aqL.lm();
    }
    
    public static int bC(View paramView)
    {
      return RecyclerView.bv(paramView).arM;
    }
    
    public static int bE(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).amT;
      int i = paramView.getMeasuredWidth();
      int j = localRect.left;
      return localRect.right + (i + j);
    }
    
    public static int bF(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).amT;
      int i = paramView.getMeasuredHeight();
      int j = localRect.top;
      return localRect.bottom + (i + j);
    }
    
    public static int bG(View paramView)
    {
      return paramView.getLeft() - bM(paramView);
    }
    
    public static int bH(View paramView)
    {
      return paramView.getTop() - bK(paramView);
    }
    
    public static int bI(View paramView)
    {
      return paramView.getRight() + bN(paramView);
    }
    
    public static int bJ(View paramView)
    {
      return paramView.getBottom() + bL(paramView);
    }
    
    public static int bK(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).amT.top;
    }
    
    public static int bL(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).amT.bottom;
    }
    
    public static int bM(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).amT.left;
    }
    
    public static int bN(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).amT.right;
    }
    
    public static b c(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      b localb = new b();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt1, paramInt2);
      localb.orientation = paramContext.getInt(0, 1);
      localb.aqI = paramContext.getInt(9, 1);
      localb.aqJ = paramContext.getBoolean(8, false);
      localb.aqK = paramContext.getBoolean(10, false);
      paramContext.recycle();
      return localb;
    }
    
    private void c(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localv.isRemoved()))
      {
        this.akA.aoZ.G(localv);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localv.ls()) && (!localv.lq())) {
          break label128;
        }
        if (!localv.lq()) {
          break label120;
        }
        localv.lr();
        label68:
        this.aoY.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (localLayoutParams.aqN)
        {
          localv.arI.invalidate();
          localLayoutParams.aqN = false;
        }
        return;
        this.akA.aoZ.H(localv);
        break;
        label120:
        localv.lt();
        break label68;
        label128:
        if (paramView.getParent() == this.akA)
        {
          int j = this.aoY.indexOfChild(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.aoY.getChildCount();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.akA.indexOfChild(paramView) + this.akA.kh());
          }
          if (j != i) {
            this.akA.apd.ay(j, i);
          }
        }
        else
        {
          this.aoY.a(paramView, paramInt, false);
          localLayoutParams.aqM = true;
          if ((this.aqy != null) && (this.aqy.arf)) {
            this.aqy.bV(paramView);
          }
        }
      }
    }
    
    public static void c(View paramView, Rect paramRect)
    {
      RecyclerView.d(paramView, paramRect);
    }
    
    private void cn(int paramInt)
    {
      getChildAt(paramInt);
      this.aoY.detachViewFromParent(paramInt);
    }
    
    private boolean f(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      paramRecyclerView = paramRecyclerView.getFocusedChild();
      if (paramRecyclerView == null) {}
      int i;
      int j;
      int k;
      int m;
      int n;
      int i1;
      Rect localRect;
      do
      {
        return false;
        i = getPaddingLeft();
        j = getPaddingTop();
        k = this.mWidth;
        m = getPaddingRight();
        n = this.mHeight;
        i1 = getPaddingBottom();
        localRect = this.akA.mTempRect;
        RecyclerView.d(paramRecyclerView, localRect);
      } while ((localRect.left - paramInt1 >= k - m) || (localRect.right - paramInt1 <= i) || (localRect.top - paramInt2 >= n - i1) || (localRect.bottom - paramInt2 <= j));
      return true;
    }
    
    private int[] g(View paramView, Rect paramRect)
    {
      int i2 = getPaddingLeft();
      int m = getPaddingTop();
      int i3 = this.mWidth - getPaddingRight();
      int i1 = this.mHeight;
      int i6 = getPaddingBottom();
      int i4 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
      int n = paramView.getTop() + paramRect.top - paramView.getScrollY();
      int i5 = i4 + paramRect.width();
      int i7 = paramRect.height();
      int i = Math.min(0, i4 - i2);
      int j = Math.min(0, n - m);
      int k = Math.max(0, i5 - i3);
      i1 = Math.max(0, n + i7 - (i1 - i6));
      if (t.Y(this.akA) == 1) {
        if (k != 0)
        {
          i = k;
          if (j == 0) {
            break label202;
          }
        }
      }
      for (;;)
      {
        return new int[] { i, j };
        i = Math.max(i, i5 - i3);
        break;
        if (i != 0) {
          break;
        }
        for (;;)
        {
          i = Math.min(i4 - i2, k);
        }
        label202:
        j = Math.min(n - m, i1);
      }
    }
    
    public static void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).amT;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public static void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.amT;
      paramView.layout(localRect.left + paramInt1 + localLayoutParams.leftMargin, localRect.top + paramInt2 + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }
    
    public static int m(int paramInt1, int paramInt2, int paramInt3)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      int i = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = i;
      switch (j)
      {
      default: 
        paramInt1 = Math.max(paramInt2, paramInt3);
      case 1073741824: 
        return paramInt1;
      }
      return Math.min(i, Math.max(paramInt2, paramInt3));
    }
    
    private static boolean n(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {}
      do
      {
        do
        {
          return false;
          switch (i)
          {
          default: 
            return false;
          }
        } while (paramInt2 < paramInt1);
        return true;
        return true;
      } while (paramInt2 != paramInt1);
      return true;
    }
    
    private void removeView(View paramView)
    {
      s locals = this.aoY;
      int i = locals.aiZ.indexOfChild(paramView);
      if (i >= 0)
      {
        if (locals.aja.remove(i)) {
          locals.bf(paramView);
        }
        locals.aiZ.removeViewAt(i);
      }
    }
    
    private void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        this.aoY.removeViewAt(paramInt);
      }
    }
    
    public void E(String paramString)
    {
      if (this.akA != null) {
        this.akA.E(paramString);
      }
    }
    
    public final void G(View paramView, int paramInt)
    {
      c(paramView, paramInt, true);
    }
    
    public int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
    {
      return 0;
    }
    
    public int a(RecyclerView.o paramo, RecyclerView.s params)
    {
      if ((this.akA == null) || (this.akA.aaj == null)) {}
      while (!jF()) {
        return 1;
      }
      return this.akA.aaj.getItemCount();
    }
    
    public RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.s params)
    {
      return null;
    }
    
    public void a(int paramInt1, int paramInt2, RecyclerView.s params, a parama) {}
    
    public void a(int paramInt, a parama) {}
    
    public final void a(int paramInt, RecyclerView.o paramo)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramo.bS(localView);
    }
    
    public void a(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = paramRect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(m(paramInt1, i + j + k, t.ae(this.akA)), m(paramInt2, m + n + i1, t.af(this.akA)));
    }
    
    public void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, android.support.v4.view.a.c paramc)
    {
      int i;
      if (jF())
      {
        i = bB(paramView);
        if (!jE()) {
          break label48;
        }
      }
      label48:
      for (int j = bB(paramView);; j = 0)
      {
        paramc.E(c.c.a(i, 1, j, 1, false));
        return;
        i = 0;
        break;
      }
    }
    
    public final void a(RecyclerView.r paramr)
    {
      if ((this.aqy != null) && (paramr != this.aqy) && (this.aqy.arf)) {
        this.aqy.stop();
      }
      this.aqy = paramr;
      paramr = this.aqy;
      RecyclerView localRecyclerView = this.akA;
      if (paramr.mStarted) {
        new StringBuilder("An instance of ").append(paramr.getClass().getSimpleName()).append(" was started more than once. Each instance of").append(paramr.getClass().getSimpleName()).append(" is intended to only be used once. You should create a new instance for each use.");
      }
      paramr.akA = localRecyclerView;
      paramr.aoI = this;
      if (paramr.ard == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      paramr.akA.apT.ard = paramr.ard;
      paramr.arf = true;
      paramr.are = true;
      int i = paramr.ard;
      paramr.arg = paramr.akA.apd.bY(i);
      paramr.akA.apQ.li();
      paramr.mStarted = true;
    }
    
    public void a(RecyclerView.s params) {}
    
    public void a(RecyclerView paramRecyclerView) {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
    {
      g(paramRecyclerView, paramInt1, paramInt2);
    }
    
    public void a(RecyclerView paramRecyclerView, RecyclerView.o paramo) {}
    
    public void a(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt) {}
    
    final void a(View paramView, android.support.v4.view.a.c paramc)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      if ((localv != null) && (!localv.isRemoved()) && (!this.aoY.bg(localv.arI))) {
        a(this.akA.aoV, this.akA.apT, paramView, paramc);
      }
    }
    
    public final void a(View paramView, RecyclerView.o paramo)
    {
      removeView(paramView);
      paramo.bS(paramView);
    }
    
    public boolean a(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }
    
    public final boolean a(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool = false;
      paramView = g(paramView, paramRect);
      int i = paramView[0];
      int j = paramView[1];
      if (paramBoolean2)
      {
        paramBoolean2 = bool;
        if (!f(paramRecyclerView, i, j)) {}
      }
      else if (i == 0)
      {
        paramBoolean2 = bool;
        if (j == 0) {}
      }
      else
      {
        if (!paramBoolean1) {
          break label74;
        }
        paramRecyclerView.scrollBy(i, j);
      }
      for (;;)
      {
        paramBoolean2 = true;
        return paramBoolean2;
        label74:
        paramRecyclerView.a(i, j, null);
      }
    }
    
    public boolean a(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }
    
    final boolean a(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (!this.aqB) || (!n(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public final void addView(View paramView)
    {
      c(paramView, -1, false);
    }
    
    public final void addView(View paramView, int paramInt)
    {
      c(paramView, paramInt, false);
    }
    
    final void aw(int paramInt1, int paramInt2)
    {
      this.mWidth = View.MeasureSpec.getSize(paramInt1);
      this.aqF = View.MeasureSpec.getMode(paramInt1);
      if ((this.aqF == 0) && (!RecyclerView.aoO)) {
        this.mWidth = 0;
      }
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      this.aqG = View.MeasureSpec.getMode(paramInt2);
      if ((this.aqG == 0) && (!RecyclerView.aoO)) {
        this.mHeight = 0;
      }
    }
    
    public final void aw(boolean paramBoolean)
    {
      if (paramBoolean != this.aqC)
      {
        this.aqC = paramBoolean;
        this.aqD = 0;
        if (this.akA != null) {
          this.akA.aoV.lf();
        }
      }
    }
    
    final void ax(int paramInt1, int paramInt2)
    {
      int i5 = getChildCount();
      if (i5 == 0)
      {
        this.akA.al(paramInt1, paramInt2);
        return;
      }
      int i = 0;
      int j = -2147483648;
      int n = -2147483648;
      int k = 2147483647;
      int i3 = 2147483647;
      while (i < i5)
      {
        View localView = getChildAt(i);
        Rect localRect = this.akA.mTempRect;
        RecyclerView.d(localView, localRect);
        int m = i3;
        if (localRect.left < i3) {
          m = localRect.left;
        }
        int i1 = n;
        if (localRect.right > n) {
          i1 = localRect.right;
        }
        int i2 = k;
        if (localRect.top < k) {
          i2 = localRect.top;
        }
        int i4 = j;
        if (localRect.bottom > j) {
          i4 = localRect.bottom;
        }
        i += 1;
        i3 = m;
        n = i1;
        k = i2;
        j = i4;
      }
      this.akA.mTempRect.set(i3, k, n, j);
      a(this.akA.mTempRect, paramInt1, paramInt2);
    }
    
    public final void az(int paramInt1, int paramInt2)
    {
      this.akA.al(paramInt1, paramInt2);
    }
    
    public int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
    {
      return 0;
    }
    
    public int b(RecyclerView.o paramo, RecyclerView.s params)
    {
      if ((this.akA == null) || (this.akA.aaj == null)) {}
      while (!jE()) {
        return 1;
      }
      return this.akA.aaj.getItemCount();
    }
    
    public final void b(RecyclerView.o paramo)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        a(paramo, i, getChildAt(i));
        i -= 1;
      }
    }
    
    final void b(RecyclerView paramRecyclerView, RecyclerView.o paramo)
    {
      this.nt = false;
      a(paramRecyclerView, paramo);
    }
    
    final boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.aqB) || (!n(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public final void bD(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.akA.by(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      k = b(this.mWidth, this.aqF, k + m + 0 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, jE());
      i = b(this.mHeight, this.aqG, j + i + 0 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, jF());
      if (b(paramView, k, i, localLayoutParams)) {
        paramView.measure(k, i);
      }
    }
    
    public View bY(int paramInt)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        RecyclerView.v localv = RecyclerView.bv(localView);
        if ((localv != null) && (localv.lm() == paramInt) && (!localv.ll()) && ((this.akA.apT.aru) || (!localv.isRemoved()))) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public final View bt(View paramView)
    {
      if (this.akA == null) {}
      do
      {
        return null;
        paramView = this.akA.bt(paramView);
      } while ((paramView == null) || (this.aoY.bg(paramView)));
      return paramView;
    }
    
    final void c(RecyclerView.o paramo)
    {
      int j = paramo.aqU.size();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = ((RecyclerView.v)paramo.aqU.get(i)).arI;
        RecyclerView.v localv = RecyclerView.bv(localView);
        if (!localv.ll())
        {
          localv.ax(false);
          if (localv.lw()) {
            this.akA.removeDetachedView(localView, false);
          }
          if (this.akA.apE != null) {
            this.akA.apE.d(localv);
          }
          localv.ax(true);
          paramo.bT(localView);
        }
        i -= 1;
      }
      paramo.aqU.clear();
      if (paramo.aqV != null) {
        paramo.aqV.clear();
      }
      if (j > 0) {
        this.akA.invalidate();
      }
    }
    
    public void c(RecyclerView.o paramo, RecyclerView.s params) {}
    
    public void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void ca(int paramInt) {}
    
    public void co(int paramInt)
    {
      if (this.akA != null)
      {
        RecyclerView localRecyclerView = this.akA;
        int j = localRecyclerView.aoY.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.aoY.getChildAt(i).offsetLeftAndRight(paramInt);
          i += 1;
        }
      }
    }
    
    public void cp(int paramInt)
    {
      if (this.akA != null)
      {
        RecyclerView localRecyclerView = this.akA;
        int j = localRecyclerView.aoY.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.aoY.getChildAt(i).offsetTopAndBottom(paramInt);
          i += 1;
        }
      }
    }
    
    public void cq(int paramInt) {}
    
    public int d(RecyclerView.s params)
    {
      return 0;
    }
    
    public RecyclerView.LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public final void d(RecyclerView.o paramo)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        if (!RecyclerView.bv(getChildAt(i)).ll()) {
          a(i, paramo);
        }
        i -= 1;
      }
    }
    
    public void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public int e(RecyclerView.s params)
    {
      return 0;
    }
    
    public final void e(View paramView, Rect paramRect)
    {
      Object localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).amT;
      int i = -((Rect)localObject).left;
      int j = -((Rect)localObject).top;
      int k = paramView.getWidth();
      int m = ((Rect)localObject).right;
      int n = paramView.getHeight();
      paramRect.set(i, j, k + m, ((Rect)localObject).bottom + n);
      if (this.akA != null)
      {
        localObject = paramView.getMatrix();
        if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
        {
          RectF localRectF = this.akA.apc;
          localRectF.set(paramRect);
          ((Matrix)localObject).mapRect(localRectF);
          paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
        }
      }
      paramRect.offset(paramView.getLeft(), paramView.getTop());
    }
    
    public int f(RecyclerView.s params)
    {
      return 0;
    }
    
    final void f(RecyclerView paramRecyclerView)
    {
      this.nt = true;
      g(paramRecyclerView);
    }
    
    public final void f(View paramView, Rect paramRect)
    {
      if (this.akA == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.akA.by(paramView));
    }
    
    public int g(RecyclerView.s params)
    {
      return 0;
    }
    
    public void g(RecyclerView paramRecyclerView) {}
    
    public void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public final View getChildAt(int paramInt)
    {
      if (this.aoY != null) {
        return this.aoY.getChildAt(paramInt);
      }
      return null;
    }
    
    public final int getChildCount()
    {
      if (this.aoY != null) {
        return this.aoY.getChildCount();
      }
      return 0;
    }
    
    public final boolean getClipToPadding()
    {
      return (this.akA != null) && (this.akA.apa);
    }
    
    public final View getFocusedChild()
    {
      if (this.akA == null) {}
      View localView;
      do
      {
        return null;
        localView = this.akA.getFocusedChild();
      } while ((localView == null) || (this.aoY.bg(localView)));
      return localView;
    }
    
    public final int getHeight()
    {
      return this.mHeight;
    }
    
    public final int getItemCount()
    {
      if (this.akA != null) {}
      for (RecyclerView.a locala = this.akA.getAdapter(); locala != null; locala = null) {
        return locala.getItemCount();
      }
      return 0;
    }
    
    public int getPaddingBottom()
    {
      if (this.akA != null) {
        return this.akA.getPaddingBottom();
      }
      return 0;
    }
    
    public int getPaddingEnd()
    {
      if (this.akA != null) {
        return t.ac(this.akA);
      }
      return 0;
    }
    
    public int getPaddingLeft()
    {
      if (this.akA != null) {
        return this.akA.getPaddingLeft();
      }
      return 0;
    }
    
    public int getPaddingRight()
    {
      if (this.akA != null) {
        return this.akA.getPaddingRight();
      }
      return 0;
    }
    
    public int getPaddingStart()
    {
      if (this.akA != null) {
        return t.ab(this.akA);
      }
      return 0;
    }
    
    public int getPaddingTop()
    {
      if (this.akA != null) {
        return this.akA.getPaddingTop();
      }
      return 0;
    }
    
    public final int getWidth()
    {
      return this.mWidth;
    }
    
    public int h(RecyclerView.s params)
    {
      return 0;
    }
    
    final void h(RecyclerView paramRecyclerView)
    {
      aw(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    public int i(RecyclerView.s params)
    {
      return 0;
    }
    
    public boolean jC()
    {
      return false;
    }
    
    public boolean jD()
    {
      return this.aqA;
    }
    
    public boolean jE()
    {
      return false;
    }
    
    public boolean jF()
    {
      return false;
    }
    
    boolean jJ()
    {
      return false;
    }
    
    public abstract RecyclerView.LayoutParams jy();
    
    @Deprecated
    public final void kW()
    {
      this.aqA = true;
    }
    
    public final boolean kX()
    {
      return (this.aqy != null) && (this.aqy.arf);
    }
    
    public void kY() {}
    
    final void kZ()
    {
      if (this.aqy != null) {
        this.aqy.stop();
      }
    }
    
    public void la()
    {
      this.aqz = true;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool2 = true;
      if ((this.akA == null) || (paramAccessibilityEvent == null)) {
        return;
      }
      boolean bool1 = bool2;
      if (!this.akA.canScrollVertically(1))
      {
        bool1 = bool2;
        if (!this.akA.canScrollVertically(-1))
        {
          bool1 = bool2;
          if (!this.akA.canScrollHorizontally(-1)) {
            if (!this.akA.canScrollHorizontally(1)) {
              break label96;
            }
          }
        }
      }
      label96:
      for (bool1 = bool2;; bool1 = false)
      {
        paramAccessibilityEvent.setScrollable(bool1);
        if (this.akA.aaj == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(this.akA.aaj.getItemCount());
        return;
      }
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public final void removeAllViews()
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        this.aoY.removeViewAt(i);
        i -= 1;
      }
    }
    
    public final boolean removeCallbacks(Runnable paramRunnable)
    {
      if (this.akA != null) {
        return this.akA.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public final void requestLayout()
    {
      if (this.akA != null) {
        this.akA.requestLayout();
      }
    }
    
    public final void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      RecyclerView.e(this.akA, paramInt1, paramInt2);
    }
    
    final void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.akA = null;
        this.aoY = null;
        this.mWidth = 0;
      }
      for (this.mHeight = 0;; this.mHeight = paramRecyclerView.getHeight())
      {
        this.aqF = 1073741824;
        this.aqG = 1073741824;
        return;
        this.akA = paramRecyclerView;
        this.aoY = paramRecyclerView.aoY;
        this.mWidth = paramRecyclerView.getWidth();
      }
    }
    
    public static abstract interface a
    {
      public abstract void R(int paramInt1, int paramInt2);
    }
    
    public static final class b
    {
      public int aqI;
      public boolean aqJ;
      public boolean aqK;
      public int orientation;
    }
  }
  
  public static abstract interface j
  {
    public abstract void bQ(View paramView);
    
    public abstract void bR(View paramView);
  }
  
  public static abstract class k
  {
    public abstract boolean aA(int paramInt1, int paramInt2);
  }
  
  public static abstract interface l
  {
    public abstract boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void ai(boolean paramBoolean);
    
    public abstract void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  }
  
  public static abstract class m
  {
    public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void b(RecyclerView paramRecyclerView, int paramInt) {}
  }
  
  public static class n
  {
    SparseArray<a> aqO = new SparseArray();
    int aqP = 0;
    
    static long c(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    final boolean a(int paramInt, long paramLong1, long paramLong2)
    {
      long l = ct(paramInt).aqS;
      return (l == 0L) || (l + paramLong1 < paramLong2);
    }
    
    public final void aB(int paramInt1, int paramInt2)
    {
      Object localObject = ct(paramInt1);
      ((a)localObject).aqR = paramInt2;
      localObject = ((a)localObject).aqQ;
      while (((ArrayList)localObject).size() > paramInt2) {
        ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
    }
    
    public final int cr(int paramInt)
    {
      return ct(paramInt).aqQ.size();
    }
    
    public RecyclerView.v cs(int paramInt)
    {
      Object localObject = (a)this.aqO.get(paramInt);
      if ((localObject != null) && (!((a)localObject).aqQ.isEmpty()))
      {
        localObject = ((a)localObject).aqQ;
        return (RecyclerView.v)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
      return null;
    }
    
    final a ct(int paramInt)
    {
      a locala2 = (a)this.aqO.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        this.aqO.put(paramInt, locala1);
      }
      return locala1;
    }
    
    final void d(int paramInt, long paramLong)
    {
      a locala = ct(paramInt);
      locala.aqS = c(locala.aqS, paramLong);
    }
    
    final void detach()
    {
      this.aqP -= 1;
    }
    
    final void le()
    {
      this.aqP += 1;
    }
    
    public void q(RecyclerView.v paramv)
    {
      int i = paramv.arM;
      ArrayList localArrayList = ct(i).aqQ;
      if (((a)this.aqO.get(i)).aqR <= localArrayList.size()) {
        return;
      }
      paramv.resetInternal();
      localArrayList.add(paramv);
    }
    
    static final class a
    {
      final ArrayList<RecyclerView.v> aqQ = new ArrayList();
      int aqR = 5;
      long aqS = 0L;
      long aqT = 0L;
    }
  }
  
  public final class o
  {
    final ArrayList<RecyclerView.v> aqU = new ArrayList();
    ArrayList<RecyclerView.v> aqV = null;
    final ArrayList<RecyclerView.v> aqW = new ArrayList();
    final List<RecyclerView.v> aqX = Collections.unmodifiableList(this.aqU);
    int aqY = 2;
    int aqZ = 2;
    RecyclerView.n ara;
    RecyclerView.t arb;
    
    public o() {}
    
    private RecyclerView.v a(long paramLong, int paramInt)
    {
      int i = this.aqU.size() - 1;
      RecyclerView.v localv;
      while (i >= 0)
      {
        localv = (RecyclerView.v)this.aqU.get(i);
        if ((localv.arL == paramLong) && (!localv.ls()))
        {
          if (paramInt == localv.arM)
          {
            localv.addFlags(32);
            if ((localv.isRemoved()) && (!RecyclerView.this.apT.aru)) {
              localv.setFlags(2, 14);
            }
            return localv;
          }
          this.aqU.remove(i);
          RecyclerView.this.removeDetachedView(localv.arI, false);
          bT(localv.arI);
        }
        i -= 1;
      }
      i = this.aqW.size() - 1;
      while (i >= 0)
      {
        localv = (RecyclerView.v)this.aqW.get(i);
        if (localv.arL == paramLong)
        {
          if (paramInt == localv.arM)
          {
            this.aqW.remove(i);
            return localv;
          }
          cx(i);
          return null;
        }
        i -= 1;
      }
      return null;
    }
    
    private boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, long paramLong)
    {
      paramv.arY = RecyclerView.this;
      int i = paramv.arM;
      long l1 = RecyclerView.this.getNanoTime();
      if (paramLong != 9223372036854775807L)
      {
        long l2 = this.ara.ct(i).aqT;
        if ((l2 == 0L) || (l2 + l1 < paramLong)) {}
        for (i = 1; i == 0; i = 0) {
          return false;
        }
      }
      Object localObject = RecyclerView.this.aaj;
      paramv.mPosition = paramInt1;
      if (((RecyclerView.a)localObject).aqm) {
        paramv.arL = ((RecyclerView.a)localObject).getItemId(paramInt1);
      }
      paramv.setFlags(1, 519);
      e.beginSection("RV OnBindView");
      ((RecyclerView.a)localObject).a(paramv, paramInt1, paramv.lz());
      paramv.ly();
      localObject = paramv.arI.getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams)) {
        ((RecyclerView.LayoutParams)localObject).aqM = true;
      }
      e.endSection();
      paramLong = RecyclerView.this.getNanoTime();
      localObject = this.ara.ct(paramv.arM);
      ((RecyclerView.n.a)localObject).aqT = RecyclerView.n.c(((RecyclerView.n.a)localObject).aqT, paramLong - l1);
      if (RecyclerView.this.kw())
      {
        localObject = paramv.arI;
        if (t.X((View)localObject) == 0) {
          t.p((View)localObject, 1);
        }
        if (!t.U((View)localObject))
        {
          paramv.addFlags(16384);
          t.a((View)localObject, RecyclerView.this.aqa.arZ);
        }
      }
      if (RecyclerView.this.apT.aru) {
        paramv.arN = paramInt2;
      }
      return true;
    }
    
    private RecyclerView.v cy(int paramInt)
    {
      int j = 0;
      int k;
      if (this.aqV != null)
      {
        k = this.aqV.size();
        if (k != 0) {}
      }
      else
      {
        return null;
      }
      int i = 0;
      RecyclerView.v localv;
      while (i < k)
      {
        localv = (RecyclerView.v)this.aqV.get(i);
        if ((!localv.ls()) && (localv.lm() == paramInt))
        {
          localv.addFlags(32);
          return localv;
        }
        i += 1;
      }
      if (RecyclerView.this.aaj.aqm)
      {
        paramInt = RecyclerView.this.aoX.L(paramInt, 0);
        if ((paramInt > 0) && (paramInt < RecyclerView.this.aaj.getItemCount()))
        {
          long l = RecyclerView.this.aaj.getItemId(paramInt);
          paramInt = j;
          while (paramInt < k)
          {
            localv = (RecyclerView.v)this.aqV.get(paramInt);
            if ((!localv.ls()) && (localv.arL == l))
            {
              localv.addFlags(32);
              return localv;
            }
            paramInt += 1;
          }
        }
      }
      return null;
    }
    
    private RecyclerView.v cz(int paramInt)
    {
      int j = 0;
      int k = this.aqU.size();
      int i = 0;
      Object localObject1;
      while (i < k)
      {
        localObject1 = (RecyclerView.v)this.aqU.get(i);
        if ((!((RecyclerView.v)localObject1).ls()) && (((RecyclerView.v)localObject1).lm() == paramInt) && (!((RecyclerView.v)localObject1).bc()) && ((RecyclerView.this.apT.aru) || (!((RecyclerView.v)localObject1).isRemoved())))
        {
          ((RecyclerView.v)localObject1).addFlags(32);
          return localObject1;
        }
        i += 1;
      }
      Object localObject2 = RecyclerView.this.aoY;
      k = ((s)localObject2).ajb.size();
      i = 0;
      Object localObject3;
      if (i < k)
      {
        localObject1 = (View)((s)localObject2).ajb.get(i);
        localObject3 = ((s)localObject2).aiZ.bh((View)localObject1);
        if ((((RecyclerView.v)localObject3).lm() != paramInt) || (((RecyclerView.v)localObject3).bc()) || (((RecyclerView.v)localObject3).isRemoved())) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = RecyclerView.bv((View)localObject1);
          localObject3 = RecyclerView.this.aoY;
          paramInt = ((s)localObject3).aiZ.indexOfChild((View)localObject1);
          if (paramInt < 0)
          {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localObject1)));
            i += 1;
            break;
            localObject1 = null;
            continue;
          }
          if (!((s)localObject3).aja.get(paramInt)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(localObject1)));
          }
          ((s)localObject3).aja.clear(paramInt);
          ((s)localObject3).bf((View)localObject1);
          paramInt = RecyclerView.this.aoY.indexOfChild((View)localObject1);
          if (paramInt == -1) {
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2 + RecyclerView.this.kh());
          }
          RecyclerView.this.aoY.detachViewFromParent(paramInt);
          bU((View)localObject1);
          ((RecyclerView.v)localObject2).addFlags(8224);
          return localObject2;
        }
      }
      k = this.aqW.size();
      i = j;
      while (i < k)
      {
        localObject1 = (RecyclerView.v)this.aqW.get(i);
        if ((!((RecyclerView.v)localObject1).bc()) && (((RecyclerView.v)localObject1).lm() == paramInt))
        {
          this.aqW.remove(i);
          return localObject1;
        }
        i += 1;
      }
      return null;
    }
    
    private void d(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      int i = paramViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          d((ViewGroup)localView, true);
        }
        i -= 1;
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
    }
    
    private void lg()
    {
      int i = this.aqW.size() - 1;
      while (i >= 0)
      {
        cx(i);
        i -= 1;
      }
      this.aqW.clear();
      if (RecyclerView.aoQ) {
        RecyclerView.this.apS.je();
      }
    }
    
    private boolean r(RecyclerView.v paramv)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramv.isRemoved()) {
        bool1 = RecyclerView.this.apT.aru;
      }
      do
      {
        do
        {
          return bool1;
          if ((paramv.mPosition < 0) || (paramv.mPosition >= RecyclerView.this.aaj.getItemCount())) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramv + RecyclerView.this.kh());
          }
          if (RecyclerView.this.apT.aru) {
            break;
          }
          bool1 = bool2;
        } while (RecyclerView.this.aaj.getItemViewType(paramv.mPosition) != paramv.arM);
        if (!RecyclerView.this.aaj.aqm) {
          break;
        }
        bool1 = bool2;
      } while (paramv.arL != RecyclerView.this.aaj.getItemId(paramv.mPosition));
      return true;
      return true;
    }
    
    private void s(RecyclerView.v paramv)
    {
      if ((paramv.arI instanceof ViewGroup)) {
        d((ViewGroup)paramv.arI, false);
      }
    }
    
    private void v(RecyclerView.v paramv)
    {
      if (RecyclerView.this.aaj != null) {
        RecyclerView.this.aaj.a(paramv);
      }
      if (RecyclerView.this.apT != null) {
        RecyclerView.this.aoZ.I(paramv);
      }
    }
    
    final void a(RecyclerView.v paramv, boolean paramBoolean)
    {
      RecyclerView.h(paramv);
      if (paramv.cC(16384))
      {
        paramv.setFlags(0, 16384);
        t.a(paramv.arI, null);
      }
      if (paramBoolean) {
        v(paramv);
      }
      paramv.arY = null;
      getRecycledViewPool().q(paramv);
    }
    
    public final void bS(View paramView)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      if (localv.lw()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localv.lq()) {
        localv.lr();
      }
      for (;;)
      {
        t(localv);
        return;
        if (localv.ls()) {
          localv.lt();
        }
      }
    }
    
    final void bT(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      paramView.arU = null;
      paramView.arV = false;
      paramView.lt();
      t(paramView);
    }
    
    final void bU(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      int i;
      if ((!paramView.cC(12)) && (paramView.lC()))
      {
        RecyclerView localRecyclerView = RecyclerView.this;
        if ((localRecyclerView.apE != null) && (!localRecyclerView.apE.a(paramView, paramView.lz()))) {
          break label112;
        }
        i = 1;
      }
      while (i != 0) {
        if ((paramView.bc()) && (!paramView.isRemoved()) && (!RecyclerView.this.aaj.aqm))
        {
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.kh());
          label112:
          i = 0;
        }
        else
        {
          paramView.a(this, false);
          this.aqU.add(paramView);
          return;
        }
      }
      if (this.aqV == null) {
        this.aqV = new ArrayList();
      }
      paramView.a(this, true);
      this.aqV.add(paramView);
    }
    
    public final void clear()
    {
      this.aqU.clear();
      lg();
    }
    
    public final int cu(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.apT.getItemCount())) {
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + RecyclerView.this.apT.getItemCount() + RecyclerView.this.kh());
      }
      if (!RecyclerView.this.apT.aru) {
        return paramInt;
      }
      return RecyclerView.this.aoX.bD(paramInt);
    }
    
    public final View cv(int paramInt)
    {
      return cw(paramInt);
    }
    
    final View cw(int paramInt)
    {
      return e(paramInt, 9223372036854775807L).arI;
    }
    
    final void cx(int paramInt)
    {
      a((RecyclerView.v)this.aqW.get(paramInt), true);
      this.aqW.remove(paramInt);
    }
    
    final RecyclerView.v e(int paramInt, long paramLong)
    {
      boolean bool2 = true;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.apT.getItemCount())) {
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.apT.getItemCount() + RecyclerView.this.kh());
      }
      Object localObject1;
      int i;
      if (RecyclerView.this.apT.aru)
      {
        localObject1 = cy(paramInt);
        if (localObject1 != null) {
          i = 1;
        }
      }
      for (int j = i;; j = 0)
      {
        Object localObject2;
        if (localObject1 == null)
        {
          localObject2 = cz(paramInt);
          localObject1 = localObject2;
          i = j;
          if (localObject2 != null)
          {
            if (r((RecyclerView.v)localObject2)) {
              break label321;
            }
            ((RecyclerView.v)localObject2).addFlags(4);
            if (!((RecyclerView.v)localObject2).lq()) {
              break label305;
            }
            RecyclerView.this.removeDetachedView(((RecyclerView.v)localObject2).arI, false);
            ((RecyclerView.v)localObject2).lr();
            label183:
            t((RecyclerView.v)localObject2);
            localObject1 = null;
            i = j;
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            int k = RecyclerView.this.aoX.bD(paramInt);
            if ((k < 0) || (k >= RecyclerView.this.aaj.getItemCount()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + RecyclerView.this.apT.getItemCount() + RecyclerView.this.kh());
              i = 0;
              break;
              label305:
              if (!((RecyclerView.v)localObject2).ls()) {
                break label183;
              }
              ((RecyclerView.v)localObject2).lt();
              break label183;
              label321:
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            j = RecyclerView.this.aaj.getItemViewType(k);
            if (RecyclerView.this.aaj.aqm)
            {
              localObject2 = a(RecyclerView.this.aaj.getItemId(k), j);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.v)localObject2).mPosition = k;
                i = 1;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject2 = getRecycledViewPool().cs(j);
                  localObject1 = localObject2;
                  if (localObject2 != null)
                  {
                    ((RecyclerView.v)localObject2).resetInternal();
                    localObject1 = localObject2;
                    if (RecyclerView.aoN)
                    {
                      s((RecyclerView.v)localObject2);
                      localObject1 = localObject2;
                    }
                  }
                }
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  long l1 = RecyclerView.this.getNanoTime();
                  if ((paramLong != 9223372036854775807L) && (!this.ara.a(j, l1, paramLong))) {
                    return null;
                  }
                  localObject2 = RecyclerView.this.aaj.d(RecyclerView.this, j);
                  if (RecyclerView.aoQ)
                  {
                    localObject1 = RecyclerView.bz(((RecyclerView.v)localObject2).arI);
                    if (localObject1 != null) {
                      ((RecyclerView.v)localObject2).arJ = new WeakReference(localObject1);
                    }
                  }
                  long l2 = RecyclerView.this.getNanoTime();
                  this.ara.d(j, l2 - l1);
                }
              }
            }
          }
          for (;;)
          {
            if ((i != 0) && (!RecyclerView.this.apT.aru) && (((RecyclerView.v)localObject2).cC(8192)))
            {
              ((RecyclerView.v)localObject2).setFlags(0, 8192);
              if (RecyclerView.this.apT.arx)
              {
                j = RecyclerView.f.m((RecyclerView.v)localObject2);
                localObject1 = RecyclerView.this.apE.a(RecyclerView.this.apT, (RecyclerView.v)localObject2, j | 0x1000, ((RecyclerView.v)localObject2).lz());
                RecyclerView.this.a((RecyclerView.v)localObject2, (RecyclerView.f.c)localObject1);
              }
            }
            boolean bool1;
            if ((RecyclerView.this.apT.aru) && (((RecyclerView.v)localObject2).isBound()))
            {
              ((RecyclerView.v)localObject2).arN = paramInt;
              bool1 = false;
            }
            for (;;)
            {
              localObject1 = ((RecyclerView.v)localObject2).arI.getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
                ((RecyclerView.v)localObject2).arI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                label738:
                ((RecyclerView.LayoutParams)localObject1).aqL = ((RecyclerView.v)localObject2);
                if ((i == 0) || (!bool1)) {
                  break label866;
                }
              }
              label866:
              for (bool1 = bool2;; bool1 = false)
              {
                ((RecyclerView.LayoutParams)localObject1).aqN = bool1;
                return localObject2;
                if ((((RecyclerView.v)localObject2).isBound()) && (!((RecyclerView.v)localObject2).lv()) && (!((RecyclerView.v)localObject2).bc())) {
                  break label872;
                }
                bool1 = a((RecyclerView.v)localObject2, RecyclerView.this.aoX.bD(paramInt), paramInt, paramLong);
                break;
                if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
                {
                  localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                  ((RecyclerView.v)localObject2).arI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  break label738;
                }
                localObject1 = (RecyclerView.LayoutParams)localObject1;
                break label738;
              }
              label872:
              bool1 = false;
            }
            localObject2 = localObject1;
            break;
            localObject2 = localObject1;
          }
          i = j;
        }
        localObject1 = null;
      }
    }
    
    final RecyclerView.n getRecycledViewPool()
    {
      if (this.ara == null) {
        this.ara = new RecyclerView.n();
      }
      return this.ara;
    }
    
    final void kL()
    {
      int j = 0;
      int k = this.aqW.size();
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.v)this.aqW.get(i)).lj();
        i += 1;
      }
      k = this.aqU.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.v)this.aqU.get(i)).lj();
        i += 1;
      }
      if (this.aqV != null)
      {
        k = this.aqV.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.v)this.aqV.get(i)).lj();
          i += 1;
        }
      }
    }
    
    final void kM()
    {
      int j = this.aqW.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.v localv = (RecyclerView.v)this.aqW.get(i);
        if (localv != null)
        {
          localv.addFlags(6);
          localv.L(null);
        }
        i += 1;
      }
      if ((RecyclerView.this.aaj == null) || (!RecyclerView.this.aaj.aqm)) {
        lg();
      }
    }
    
    final void lf()
    {
      if (RecyclerView.this.apd != null) {}
      for (int i = RecyclerView.this.apd.aqD;; i = 0)
      {
        this.aqZ = (i + this.aqY);
        i = this.aqW.size() - 1;
        while ((i >= 0) && (this.aqW.size() > this.aqZ))
        {
          cx(i);
          i -= 1;
        }
      }
    }
    
    final void t(RecyclerView.v paramv)
    {
      int k = 1;
      if ((paramv.lq()) || (paramv.arI.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramv.lq()).append(" isAttached:");
        if (paramv.arI.getParent() != null) {}
        for (bool = true;; bool = false) {
          throw new IllegalArgumentException(bool + RecyclerView.this.kh());
        }
      }
      if (paramv.lw()) {
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramv + RecyclerView.this.kh());
      }
      if (paramv.ll()) {
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.kh());
      }
      boolean bool = paramv.lB();
      int j;
      int i;
      if (paramv.lA()) {
        if ((this.aqZ > 0) && (!paramv.cC(526)))
        {
          j = this.aqW.size();
          i = j;
          if (j >= this.aqZ)
          {
            i = j;
            if (j > 0)
            {
              cx(0);
              i = j - 1;
            }
          }
          j = i;
          if (RecyclerView.aoQ)
          {
            j = i;
            if (i > 0)
            {
              j = i;
              if (!RecyclerView.this.apS.bO(paramv.mPosition))
              {
                i -= 1;
                while (i >= 0)
                {
                  j = ((RecyclerView.v)this.aqW.get(i)).mPosition;
                  if (!RecyclerView.this.apS.bO(j)) {
                    break;
                  }
                  i -= 1;
                }
                j = i + 1;
              }
            }
          }
          this.aqW.add(j, paramv);
          i = 1;
          if (i == 0)
          {
            a(paramv, true);
            j = k;
          }
        }
      }
      for (;;)
      {
        RecyclerView.this.aoZ.I(paramv);
        if ((i == 0) && (j == 0) && (bool)) {
          paramv.arY = null;
        }
        return;
        j = 0;
        continue;
        i = 0;
        break;
        j = 0;
        i = 0;
      }
    }
    
    final void u(RecyclerView.v paramv)
    {
      if (paramv.arV) {
        this.aqV.remove(paramv);
      }
      for (;;)
      {
        paramv.arU = null;
        paramv.arV = false;
        paramv.lt();
        return;
        this.aqU.remove(paramv);
      }
    }
  }
  
  public static abstract interface p {}
  
  final class q
    extends RecyclerView.c
  {
    q() {}
    
    private void lh()
    {
      if ((RecyclerView.aoP) && (RecyclerView.this.apj) && (RecyclerView.this.api))
      {
        t.b(RecyclerView.this, RecyclerView.this.apb);
        return;
      }
      RecyclerView.this.aps = true;
      RecyclerView.this.requestLayout();
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.E(null);
      d locald = RecyclerView.this.aoX;
      if (paramInt2 > 0)
      {
        locald.agU.add(locald.b(1, paramInt1, paramInt2, null));
        locald.aha |= 0x1;
        if (locald.agU.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lh();
        }
        return;
      }
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.E(null);
      d locald = RecyclerView.this.aoX;
      if (paramInt2 > 0)
      {
        locald.agU.add(locald.b(2, paramInt1, paramInt2, null));
        locald.aha |= 0x2;
        if (locald.agU.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lh();
        }
        return;
      }
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = 1;
      RecyclerView.this.E(null);
      d locald = RecyclerView.this.aoX;
      if (paramInt2 > 0)
      {
        locald.agU.add(locald.b(4, paramInt1, paramInt2, paramObject));
        locald.aha |= 0x4;
        if (locald.agU.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lh();
        }
        return;
      }
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      RecyclerView.this.E(null);
      d locald = RecyclerView.this.aoX;
      if (paramInt1 != paramInt2)
      {
        if (paramInt3 != 1) {
          throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        locald.agU.add(locald.b(8, paramInt1, paramInt2, null));
        locald.aha |= 0x8;
        if (locald.agU.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lh();
        }
        return;
      }
    }
    
    public final void onChanged()
    {
      RecyclerView.this.E(null);
      RecyclerView.this.apT.art = true;
      RecyclerView.this.au(true);
      if (!RecyclerView.this.aoX.iv()) {
        RecyclerView.this.requestLayout();
      }
    }
  }
  
  public static abstract class r
  {
    RecyclerView akA;
    RecyclerView.i aoI;
    public int ard = -1;
    boolean are;
    boolean arf;
    View arg;
    private final a arh = new a();
    boolean mStarted;
    
    protected abstract void a(int paramInt1, int paramInt2, a parama);
    
    protected abstract void a(View paramView, RecyclerView.s params, a parama);
    
    final void aC(int paramInt1, int paramInt2)
    {
      int i = 0;
      RecyclerView localRecyclerView = this.akA;
      if ((!this.arf) || (this.ard == -1) || (localRecyclerView == null)) {
        stop();
      }
      if ((this.are) && (this.arg == null) && (this.aoI != null))
      {
        PointF localPointF = bZ(this.ard);
        if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F))) {
          localRecyclerView.b((int)Math.signum(localPointF.x), (int)Math.signum(localPointF.y), null);
        }
      }
      this.are = false;
      if (this.arg != null)
      {
        if (RecyclerView.bx(this.arg) != this.ard) {
          break label233;
        }
        a(this.arg, localRecyclerView.apT, this.arh);
        this.arh.i(localRecyclerView);
        stop();
      }
      for (;;)
      {
        if (this.arf)
        {
          a(paramInt1, paramInt2, this.arh);
          paramInt1 = i;
          if (this.arh.arl >= 0) {
            paramInt1 = 1;
          }
          this.arh.i(localRecyclerView);
          if (paramInt1 != 0)
          {
            if (!this.arf) {
              break;
            }
            this.are = true;
            localRecyclerView.apQ.li();
          }
        }
        return;
        label233:
        this.arg = null;
      }
      stop();
    }
    
    protected final void bV(View paramView)
    {
      if (RecyclerView.bx(paramView) == this.ard) {
        this.arg = paramView;
      }
    }
    
    public PointF bZ(int paramInt)
    {
      RecyclerView.i locali = this.aoI;
      if ((locali instanceof b)) {
        return ((b)locali).bZ(paramInt);
      }
      new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(b.class.getCanonicalName());
      return null;
    }
    
    public final void cA(int paramInt)
    {
      this.ard = paramInt;
    }
    
    public final RecyclerView.i getLayoutManager()
    {
      return this.aoI;
    }
    
    protected abstract void onStop();
    
    protected final void stop()
    {
      if (!this.arf) {
        return;
      }
      this.arf = false;
      onStop();
      this.akA.apT.ard = -1;
      this.arg = null;
      this.ard = -1;
      this.are = false;
      RecyclerView.i locali = this.aoI;
      if (locali.aqy == this) {
        locali.aqy = null;
      }
      this.aoI = null;
      this.akA = null;
    }
    
    public static final class a
    {
      private int ari = 0;
      private int arj = 0;
      private int ark = -2147483648;
      int arl = -1;
      private boolean arm = false;
      private int arn = 0;
      private Interpolator mInterpolator = null;
      
      public a()
      {
        this((byte)0);
      }
      
      private a(byte paramByte) {}
      
      private void validate()
      {
        if ((this.mInterpolator != null) && (this.ark <= 0)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.ark <= 0) {
          throw new IllegalStateException("Scroll duration must be a positive number");
        }
      }
      
      public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.ari = paramInt1;
        this.arj = paramInt2;
        this.ark = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.arm = true;
      }
      
      final void i(RecyclerView paramRecyclerView)
      {
        if (this.arl >= 0)
        {
          int i = this.arl;
          this.arl = -1;
          paramRecyclerView.cg(i);
          this.arm = false;
          return;
        }
        if (this.arm)
        {
          validate();
          if (this.mInterpolator == null) {
            if (this.ark == -2147483648) {
              paramRecyclerView.apQ.aD(this.ari, this.arj);
            }
          }
          for (;;)
          {
            this.arn += 1;
            this.arm = false;
            return;
            paramRecyclerView.apQ.o(this.ari, this.arj, this.ark);
            continue;
            paramRecyclerView.apQ.b(this.ari, this.arj, this.ark, this.mInterpolator);
          }
        }
        this.arn = 0;
      }
    }
    
    public static abstract interface b
    {
      public abstract PointF bZ(int paramInt);
    }
  }
  
  public static final class s
  {
    long arA;
    int arB;
    int arC;
    int arD;
    int ard = -1;
    private SparseArray<Object> aro;
    int arp = 0;
    int arq = 0;
    int arr = 1;
    int ars = 0;
    boolean art = false;
    public boolean aru = false;
    boolean arv = false;
    boolean arw = false;
    boolean arx = false;
    boolean ary = false;
    int arz;
    
    final void cB(int paramInt)
    {
      if ((this.arr & paramInt) == 0) {
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.arr));
      }
    }
    
    public final int getItemCount()
    {
      if (this.aru) {
        return this.arp - this.arq;
      }
      return this.ars;
    }
    
    public final String toString()
    {
      return "State{mTargetPosition=" + this.ard + ", mData=" + this.aro + ", mItemCount=" + this.ars + ", mIsMeasuring=" + this.arw + ", mPreviousLayoutItemCount=" + this.arp + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.arq + ", mStructureChanged=" + this.art + ", mInPreLayout=" + this.aru + ", mRunSimpleAnimations=" + this.arx + ", mRunPredictiveAnimations=" + this.ary + '}';
    }
  }
  
  public static abstract class t {}
  
  final class u
    implements Runnable
  {
    OverScroller RH = new OverScroller(RecyclerView.this.getContext(), RecyclerView.aqi);
    int arE;
    int arF;
    private boolean arG = false;
    private boolean arH = false;
    Interpolator mInterpolator = RecyclerView.aqi;
    
    u() {}
    
    private static float distanceInfluenceForSnapDuration(float paramFloat)
    {
      return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    }
    
    final void aD(int paramInt1, int paramInt2)
    {
      o(paramInt1, paramInt2, aE(paramInt1, paramInt2));
    }
    
    final int aE(int paramInt1, int paramInt2)
    {
      int j = Math.abs(paramInt1);
      int k = Math.abs(paramInt2);
      int i;
      int m;
      if (j > k)
      {
        i = 1;
        m = (int)Math.sqrt(0.0D);
        paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
        if (i == 0) {
          break label131;
        }
      }
      label131:
      for (paramInt1 = RecyclerView.this.getWidth();; paramInt1 = RecyclerView.this.getHeight())
      {
        int n = paramInt1 / 2;
        float f3 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
        float f1 = n;
        float f2 = n;
        f3 = distanceInfluenceForSnapDuration(f3);
        if (m <= 0) {
          break label142;
        }
        paramInt1 = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / m)) * 4;
        return Math.min(paramInt1, 2000);
        i = 0;
        break;
      }
      label142:
      if (i != 0) {}
      for (paramInt2 = j;; paramInt2 = k)
      {
        paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
        break;
      }
    }
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      if (this.mInterpolator != paramInterpolator)
      {
        this.mInterpolator = paramInterpolator;
        this.RH = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.arF = 0;
      this.arE = 0;
      this.RH.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.RH.computeScrollOffset();
      }
      li();
    }
    
    final void li()
    {
      if (this.arG)
      {
        this.arH = true;
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      t.b(RecyclerView.this, this);
    }
    
    public final void o(int paramInt1, int paramInt2, int paramInt3)
    {
      b(paramInt1, paramInt2, paramInt3, RecyclerView.aqi);
    }
    
    public final void run()
    {
      if (RecyclerView.this.apd == null)
      {
        stop();
        return;
      }
      this.arH = false;
      this.arG = true;
      RecyclerView.this.kj();
      OverScroller localOverScroller = this.RH;
      RecyclerView.r localr = RecyclerView.this.apd.aqy;
      int i6;
      int i7;
      int k;
      int j;
      int i;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.RR;
        i6 = localOverScroller.getCurrX();
        i7 = localOverScroller.getCurrY();
        k = i6 - this.arE;
        j = i7 - this.arF;
        this.arE = i6;
        this.arF = i7;
        if (!RecyclerView.this.a(k, j, arrayOfInt, null, 1)) {
          break label849;
        }
        i = arrayOfInt[0];
        j -= arrayOfInt[1];
        k -= i;
      }
      label302:
      label569:
      label588:
      label849:
      for (;;)
      {
        int i3;
        int i4;
        int i5;
        int m;
        int n;
        int i1;
        int i2;
        if (RecyclerView.this.aaj != null)
        {
          RecyclerView.this.b(k, j, RecyclerView.this.aqf);
          i = RecyclerView.this.aqf[0];
          i3 = RecyclerView.this.aqf[1];
          i4 = k - i;
          i5 = j - i3;
          m = i;
          n = i3;
          i1 = i4;
          i2 = i5;
          if (localr != null)
          {
            m = i;
            n = i3;
            i1 = i4;
            i2 = i5;
            if (!localr.are)
            {
              m = i;
              n = i3;
              i1 = i4;
              i2 = i5;
              if (localr.arf)
              {
                m = RecyclerView.this.apT.getItemCount();
                if (m != 0) {
                  break label695;
                }
                localr.stop();
                i2 = i5;
                i1 = i4;
                n = i3;
                m = i;
              }
            }
          }
        }
        for (;;)
        {
          if (!RecyclerView.this.apf.isEmpty()) {
            RecyclerView.this.invalidate();
          }
          if (RecyclerView.this.getOverScrollMode() != 2) {
            RecyclerView.this.aj(k, j);
          }
          if ((!RecyclerView.this.a(m, n, i1, i2, null, 1)) && ((i1 != 0) || (i2 != 0)))
          {
            i3 = (int)localOverScroller.getCurrVelocity();
            if (i1 == i6) {
              break label828;
            }
            if (i1 >= 0) {
              break label745;
            }
            i = -i3;
          }
          for (i4 = i;; i4 = 0)
          {
            if (i2 != i7) {
              if (i2 < 0) {
                i = -i3;
              }
            }
            for (;;)
            {
              if (RecyclerView.this.getOverScrollMode() != 2) {
                RecyclerView.this.ak(i4, i);
              }
              if (((i4 != 0) || (i1 == i6) || (localOverScroller.getFinalX() == 0)) && ((i != 0) || (i2 == i7) || (localOverScroller.getFinalY() == 0))) {
                localOverScroller.abortAnimation();
              }
              if ((m != 0) || (n != 0)) {
                RecyclerView.this.an(m, n);
              }
              if (!RecyclerView.b(RecyclerView.this)) {
                RecyclerView.this.invalidate();
              }
              if ((j != 0) && (RecyclerView.this.apd.jF()) && (n == j))
              {
                i = 1;
                if ((k == 0) || (!RecyclerView.this.apd.jE()) || (m != k)) {
                  break label779;
                }
                m = 1;
                if (((k != 0) || (j != 0)) && (m == 0) && (i == 0)) {
                  break label785;
                }
                i = 1;
                if ((!localOverScroller.isFinished()) && ((i != 0) || (RecyclerView.this.getScrollingChildHelper().aN(1)))) {
                  break label790;
                }
                RecyclerView.this.setScrollState(0);
                if (RecyclerView.aoQ) {
                  RecyclerView.this.apS.je();
                }
                RecyclerView.this.aM(1);
              }
              for (;;)
              {
                if (localr != null)
                {
                  if (localr.are) {
                    localr.aC(0, 0);
                  }
                  if (!this.arH) {
                    localr.stop();
                  }
                }
                this.arG = false;
                if (!this.arH) {
                  break;
                }
                li();
                return;
                if (localr.ard >= m) {
                  localr.ard = (m - 1);
                }
                localr.aC(k - i4, j - i5);
                m = i;
                n = i3;
                i1 = i4;
                i2 = i5;
                break label302;
                label745:
                if (i1 > 0)
                {
                  i = i3;
                  break label396;
                }
                i = 0;
                break label396;
                i = i3;
                if (i2 > 0) {
                  break label415;
                }
                i = 0;
                break label415;
                i = 0;
                break label543;
                m = 0;
                break label569;
                i = 0;
                break label588;
                li();
                if (RecyclerView.this.apR != null) {
                  RecyclerView.this.apR.b(RecyclerView.this, k, j);
                }
              }
              i = 0;
            }
          }
          i2 = 0;
          i1 = 0;
          n = 0;
          m = 0;
        }
      }
    }
    
    public final void stop()
    {
      RecyclerView.this.removeCallbacks(this);
      this.RH.abortAnimation();
    }
  }
  
  public static abstract class v
  {
    private static final List<Object> arQ = ;
    int CW;
    public final View arI;
    WeakReference<RecyclerView> arJ;
    int arK = -1;
    public long arL = -1L;
    public int arM = -1;
    int arN = -1;
    v arO = null;
    v arP = null;
    List<Object> arR = null;
    List<Object> arS = null;
    private int arT = 0;
    RecyclerView.o arU = null;
    boolean arV = false;
    int arW = 0;
    int arX = -1;
    RecyclerView arY;
    int mPosition = -1;
    
    public v(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.arI = paramView;
    }
    
    private void lx()
    {
      if (this.arR == null)
      {
        this.arR = new ArrayList();
        this.arS = Collections.unmodifiableList(this.arR);
      }
    }
    
    final void L(Object paramObject)
    {
      if (paramObject == null) {
        addFlags(1024);
      }
      while ((this.CW & 0x400) != 0) {
        return;
      }
      lx();
      this.arR.add(paramObject);
    }
    
    final void a(RecyclerView.o paramo, boolean paramBoolean)
    {
      this.arU = paramo;
      this.arV = paramBoolean;
    }
    
    final void addFlags(int paramInt)
    {
      this.CW |= paramInt;
    }
    
    public final void ax(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = this.arT - 1;
        this.arT = i;
        if (this.arT >= 0) {
          break label53;
        }
        this.arT = 0;
        new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
      }
      label53:
      do
      {
        return;
        i = this.arT + 1;
        break;
        if ((!paramBoolean) && (this.arT == 1))
        {
          this.CW |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.arT != 0));
      this.CW &= 0xFFFFFFEF;
    }
    
    public final long bMs()
    {
      return this.arL;
    }
    
    final boolean bc()
    {
      return (this.CW & 0x4) != 0;
    }
    
    final boolean cC(int paramInt)
    {
      return (this.CW & paramInt) != 0;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.arN == -1) {
        return this.mPosition;
      }
      return this.arN;
    }
    
    final boolean isBound()
    {
      return (this.CW & 0x1) != 0;
    }
    
    public final boolean isRemoved()
    {
      return (this.CW & 0x8) != 0;
    }
    
    final void k(int paramInt, boolean paramBoolean)
    {
      if (this.arK == -1) {
        this.arK = this.mPosition;
      }
      if (this.arN == -1) {
        this.arN = this.mPosition;
      }
      if (paramBoolean) {
        this.arN += paramInt;
      }
      this.mPosition += paramInt;
      if (this.arI.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.arI.getLayoutParams()).aqM = true;
      }
    }
    
    public final boolean lA()
    {
      return ((this.CW & 0x10) == 0) && (!t.V(this.arI));
    }
    
    final boolean lB()
    {
      return ((this.CW & 0x10) == 0) && (t.V(this.arI));
    }
    
    final boolean lC()
    {
      return (this.CW & 0x2) != 0;
    }
    
    final void lj()
    {
      this.arK = -1;
      this.arN = -1;
    }
    
    final void lk()
    {
      if (this.arK == -1) {
        this.arK = this.mPosition;
      }
    }
    
    final boolean ll()
    {
      return (this.CW & 0x80) != 0;
    }
    
    public final int lm()
    {
      if (this.arN == -1) {
        return this.mPosition;
      }
      return this.arN;
    }
    
    public final int ln()
    {
      if (this.arY == null) {
        return -1;
      }
      return this.arY.i(this);
    }
    
    public final int lo()
    {
      return this.arK;
    }
    
    public final int lp()
    {
      return this.arM;
    }
    
    final boolean lq()
    {
      return this.arU != null;
    }
    
    final void lr()
    {
      this.arU.u(this);
    }
    
    final boolean ls()
    {
      return (this.CW & 0x20) != 0;
    }
    
    final void lt()
    {
      this.CW &= 0xFFFFFFDF;
    }
    
    final void lu()
    {
      this.CW &= 0xFFFFFEFF;
    }
    
    final boolean lv()
    {
      return (this.CW & 0x2) != 0;
    }
    
    final boolean lw()
    {
      return (this.CW & 0x100) != 0;
    }
    
    final void ly()
    {
      if (this.arR != null) {
        this.arR.clear();
      }
      this.CW &= 0xFFFFFBFF;
    }
    
    final List<Object> lz()
    {
      if ((this.CW & 0x400) == 0)
      {
        if ((this.arR == null) || (this.arR.size() == 0)) {
          return arQ;
        }
        return this.arS;
      }
      return arQ;
    }
    
    final void resetInternal()
    {
      this.CW = 0;
      this.mPosition = -1;
      this.arK = -1;
      this.arL = -1L;
      this.arN = -1;
      this.arT = 0;
      this.arO = null;
      this.arP = null;
      ly();
      this.arW = 0;
      this.arX = -1;
      RecyclerView.h(this);
    }
    
    final void setFlags(int paramInt1, int paramInt2)
    {
      this.CW = (this.CW & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.arL + ", oldPos=" + this.arK + ", pLpos:" + this.arN);
      String str;
      if (lq())
      {
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (this.arV)
        {
          str = "[changeScrap]";
          localStringBuilder2.append(str);
        }
      }
      else
      {
        if (bc()) {
          localStringBuilder1.append(" invalid");
        }
        if (!isBound()) {
          localStringBuilder1.append(" unbound");
        }
        if (lv()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (ll()) {
          localStringBuilder1.append(" ignored");
        }
        if (lw()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!lA()) {
          localStringBuilder1.append(" not recyclable(" + this.arT + ")");
        }
        if (((this.CW & 0x200) == 0) && (!bc())) {
          break label306;
        }
      }
      label306:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.arI.getParent() == null) {
          localStringBuilder1.append(" no parent");
        }
        localStringBuilder1.append("}");
        return localStringBuilder1.toString();
        str = "[attachedScrap]";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */